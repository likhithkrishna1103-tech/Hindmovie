(function () {
    const DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    const FALLBACK_MAIN = "https://new7.zinkmovies.biz";
    const FALLBACK_HUBCLOUD = "https://hubcloud.foo";
    const TMDB_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    const TMDB_API = "https://api.themoviedb.org/3";
    const TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    const USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0";
    const DEFAULT_HEADERS = {
        "User-Agent": USER_AGENT,
        "Cookie": "xla=s4t"
    };
    const HOME_SECTIONS = [
        { path: "", title: "Home" },
        { path: "movies/", title: "Movies" },
        { path: "tvshows/", title: "Tv Shows" },
        { path: "genre/bollywood/", title: "Bollywood" },
        { path: "genre/HOLLYWOOD-MOVIES/", title: "Hollywood" },
        { path: "genre/animation/", title: "Animation" },
        { path: "genre/anime/", title: "Anime" },
        { path: "genre/korean/", title: "KDrama" }
    ];

    let cachedDomains = null;

    function cleanBase(url) {
        return String(url || "").replace(/\/+$/, "");
    }

    function mergeHeaders(extra) {
        return Object.assign({}, DEFAULT_HEADERS, extra || {});
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&#(\d+);/g, function (_, n) { return String.fromCodePoint(parseInt(n, 10)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, n) { return String.fromCodePoint(parseInt(n, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/\s+/g, " ")
            .trim();
    }

    function textOf(node) {
        return decodeHtml(node && node.textContent || "");
    }

    function attrOf(node) {
        if (!node || !node.getAttribute) return "";
        for (let i = 1; i < arguments.length; i++) {
            const value = node.getAttribute(arguments[i]);
            if (value) return String(value).trim();
        }
        return "";
    }

    function qsa(root, selector) {
        try {
            return Array.from(root && root.querySelectorAll ? root.querySelectorAll(selector) : []);
        } catch (_) {
            return [];
        }
    }

    function qs(root, selector) {
        try {
            return root && root.querySelector ? root.querySelector(selector) : null;
        } catch (_) {
            return null;
        }
    }

    function stripScripts(html) {
        return String(html || "")
            .replace(/<style\b[^>]*>[\s\S]*?<\/style>/gi, "")
            .replace(/<link\b[^>]+rel=["']stylesheet["'][^>]*>/gi, "");
    }

    function stripTags(html) {
        return decodeHtml(String(html || "").replace(/<[^>]+>/g, " "));
    }

    function firstMatch(value, patterns) {
        for (let i = 0; i < patterns.length; i++) {
            const match = String(value || "").match(patterns[i]);
            if (match && match[1]) return match[1];
        }
        return "";
    }

    function absoluteUrl(base, href) {
        if (!href) return "";
        try {
            return new URL(String(href), String(base || FALLBACK_MAIN)).toString();
        } catch (_) {
            return "";
        }
    }

    function originOf(url) {
        try {
            return new URL(String(url)).origin;
        } catch (_) {
            return "";
        }
    }

    function hostOf(url) {
        try {
            return new URL(String(url)).hostname.toLowerCase();
        } catch (_) {
            return "";
        }
    }

    function safeJson(value, fallback) {
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    async function getText(url, headers, allowRedirects) {
        const res = await http_get(url, mergeHeaders(headers || {}));
        return String(res && res.body || "");
    }

    async function getDocument(url, headers) {
        const html = await getText(url, headers, true);
        return { html: html, document: await parseHtml(stripScripts(html)) };
    }

    async function postText(url, body, headers) {
        const res = await http_post(url, mergeHeaders(headers || {}), body || "");
        return String(res && res.body || "");
    }

    async function requestGet(url, headers, allowRedirects) {
        return await http_get(url, mergeHeaders(headers || {}));
    }

    async function getDomains(force) {
        if (cachedDomains && !force) return cachedDomains;
        try {
            const json = safeJson(await getText(DOMAINS_URL, {}, true), null);
            cachedDomains = {
                zinkmovies: cleanBase(json && json.zinkmovies) || cleanBase((manifest && manifest.baseUrl) || FALLBACK_MAIN),
                hubcloud: cleanBase(json && json.hubcloud) || FALLBACK_HUBCLOUD
            };
        } catch (_) {
            cachedDomains = {
                zinkmovies: cleanBase((manifest && manifest.baseUrl) || FALLBACK_MAIN),
                hubcloud: FALLBACK_HUBCLOUD
            };
        }
        return cachedDomains;
    }

    async function getMainUrl() {
        return (await getDomains()).zinkmovies || FALLBACK_MAIN;
    }

    async function getHubCloudUrl() {
        return (await getDomains()).hubcloud || FALLBACK_HUBCLOUD;
    }

    function cleanTitle(raw) {
        const source = String(raw || "");
        let name = source.split("(")[0].trim().replace(/\s+/g, " ");
        if (name) name = name.charAt(0).toUpperCase() + name.slice(1);
        const season = (source.match(/Season\s*\d+/i) || [])[0];
        const year = (source.match(/\b(?:19|20)\d{2}\b/) || [])[0];
        let suffix = "";
        if (season) suffix += " (" + season.charAt(0).toUpperCase() + season.slice(1) + ")";
        if (year) suffix += " (" + year + ")";
        return (name || source.trim()) + suffix;
    }

    function qualityFromText(value) {
        const text = String(value || "").toLowerCase();
        if (/\b(2160p|4k|uhd)\b/.test(text)) return 2160;
        if (/\b1440p\b/.test(text)) return 1440;
        if (/\b1080p\b/.test(text)) return 1080;
        if (/\b720p\b/.test(text)) return 720;
        if (/\b480p\b/.test(text)) return 480;
        if (/\b360p\b/.test(text)) return 360;
        return 0;
    }

    function itemTypeFromUrl(url) {
        if (/\/tvshows\//i.test(String(url || ""))) return "series";
        return "movie";
    }

    function posterFrom(root, base) {
        return absoluteUrl(base, attrOf(qs(root, "img"), "data-lazy-src", "data-src", "src")).replace("/w185/", "/w500/").replace("/w92/", "/w500/");
    }

    function parseCard(article, base) {
        const anchor = qs(article, "h3 a") || qs(article, ".title a") || qs(article, "a[href]");
        const href = absoluteUrl(base, attrOf(anchor, "href"));
        const title = cleanTitle(textOf(anchor));
        if (!href || !title) return null;
        return new MultimediaItem({
            title: title,
            url: href,
            posterUrl: posterFrom(article, base),
            type: itemTypeFromUrl(href),
            score: parseFloat(textOf(qs(article, "div.rating"))) || undefined,
            quality: qualityFromText(textOf(qs(article, "span.quality"))) || undefined
        });
    }

    function parseCardsFromHtml(html, base) {
        const out = [];
        const text = String(html || "");
        const regex = /<article\b[\s\S]*?<\/article>/gi;
        let match;
        while ((match = regex.exec(text))) {
            const block = match[0];
            const href = absoluteUrl(base, firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
                /<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
                /<a\b[^>]*href=["']([^"']+)["'][^>]*>/i
            ]));
            const title = cleanTitle(stripTags(firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<img\b[^>]*alt=["']([^"']+)["']/i
            ])));
            if (!href || !title) continue;
            const poster = absoluteUrl(base, firstMatch(block, [
                /<img\b[^>]*data-lazy-src=["']([^"']+)["']/i,
                /<img\b[^>]*data-src=["']([^"']+)["']/i,
                /<img\b[^>]*src=["']([^"']+)["']/i
            ])).replace("/w185/", "/w500/").replace("/w92/", "/w500/");
            const rating = parseFloat(stripTags(firstMatch(block, [
                /<div\b[^>]*class=["'][^"']*rating[^"']*["'][^>]*>([\s\S]*?)<\/div>/i,
                /<span\b[^>]*class=["'][^"']*rating[^"']*["'][^>]*>([\s\S]*?)<\/span>/i
            ]))) || undefined;
            out.push(new MultimediaItem({
                title: title,
                url: href,
                posterUrl: poster,
                type: itemTypeFromUrl(href),
                score: rating,
                quality: qualityFromText(block) || undefined
            }));
        }
        return dedupeBy(out, function (item) { return item.url; });
    }

    function dedupeBy(items, fn) {
        const seen = new Set();
        const out = [];
        for (const item of items || []) {
            const key = fn(item);
            if (!key || seen.has(key)) continue;
            seen.add(key);
            out.push(item);
        }
        return out;
    }

    async function mapConcurrent(items, limit, worker) {
        const rows = Array.isArray(items) ? items : [];
        const count = Math.max(1, Math.min(rows.length || 1, parseInt(limit, 10) || 1));
        const out = new Array(rows.length);
        let index = 0;
        async function run() {
            while (index < rows.length) {
                const current = index++;
                try {
                    out[current] = await worker(rows[current], current);
                } catch (_) {
                    out[current] = null;
                }
            }
        }
        await Promise.all(Array.from({ length: count }, run));
        return out;
    }

    function streamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: source || hostOf(url) || "Zinkmovies",
            quality: Number(quality) || qualityFromText(url),
            headers: headers || {}
        });
    }

    function payload(value) {
        return JSON.stringify(value || {});
    }

    function parsePayload(value) {
        const parsed = safeJson(value, null);
        if (Array.isArray(parsed)) return { links: parsed, sourceUrl: "", title: "" };
        if (parsed && typeof parsed === "object") return parsed;
        if (/^https?:\/\//i.test(String(value || ""))) return { links: [String(value)], sourceUrl: String(value), title: "" };
        return { links: [], sourceUrl: "", title: "" };
    }

    async function fetchTmdb(title, type, seasonNumber) {
        try {
            const query = String(title || "").replace(new RegExp("Season\\s*" + (seasonNumber || ""), "i"), "").trim();
            const kind = type === "series" ? "tv" : "movie";
            const search = safeJson(await getText(TMDB_API + "/search/" + kind + "?api_key=" + TMDB_KEY + "&query=" + encodeURIComponent(query), {}, true), {});
            const id = search && search.results && search.results[0] && search.results[0].id;
            if (!id) return null;
            const details = safeJson(await getText(TMDB_API + "/" + kind + "/" + id + "?api_key=" + TMDB_KEY + "&append_to_response=credits,external_ids", {}, true), {});
            const imdbId = details && details.external_ids && details.external_ids.imdb_id || "";
            const meta = {
                id: id,
                title: details.name || details.title || title,
                description: details.overview || "",
                year: String(details.release_date || details.first_air_date || "").slice(0, 4),
                score: typeof details.vote_average === "number" ? Number(details.vote_average.toFixed(1)) : undefined,
                bannerUrl: details.backdrop_path ? TMDB_IMAGE + details.backdrop_path : "",
                posterUrl: details.poster_path ? TMDB_IMAGE + details.poster_path : "",
                logoUrl: imdbId ? "https://live.metahub.space/logo/medium/" + imdbId + "/img" : "",
                imdbId: imdbId,
                genres: (details.genres || []).map(function (g) { return g && g.name; }).filter(Boolean),
                cast: ((details.credits && details.credits.cast) || []).slice(0, 20).map(function (c) {
                    return {
                        name: c.name || c.original_name || "",
                        image: c.profile_path ? TMDB_IMAGE + c.profile_path : undefined,
                        role: c.character || undefined
                    };
                }).filter(function (c) { return c.name; }),
                episodes: []
            };
            if (seasonNumber && !/season\s*\d+/i.test(meta.title)) meta.title += " (Season " + seasonNumber + ")";
            if (type === "series") {
                const total = Number(details.number_of_seasons || 0);
                const seasons = [];
                for (let i = 1; i <= total; i++) seasons.push(i);
                const seasonRows = await mapConcurrent(seasons, 3, async function (season) {
                    const seasonJson = safeJson(await getText(TMDB_API + "/tv/" + id + "/season/" + season + "?api_key=" + TMDB_KEY, {}, true), {});
                    return (seasonJson.episodes || []).map(function (ep) {
                        return {
                            season: season,
                            episode: Number(ep.episode_number || 0),
                            name: ep.name || "",
                            description: ep.overview || "",
                            posterUrl: ep.still_path ? TMDB_IMAGE + ep.still_path : "",
                            score: typeof ep.vote_average === "number" ? Number(ep.vote_average.toFixed(1)) : undefined,
                            released: ep.air_date || ""
                        };
                    });
                });
                meta.episodes = seasonRows.flat().filter(function (ep) { return ep.season && ep.episode; });
            }
            return meta;
        } catch (_) {
            return null;
        }
    }

    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const entries = await mapConcurrent(HOME_SECTIONS, 4, async function (section) {
                const url = mainUrl + "/" + section.path + "page/1/";
                const page = await getDocument(url, { Referer: mainUrl + "/" });
                let items = qsa(page.document, "article")
                    .filter(function (node) {
                        return !(node.closest && (node.closest(".animation-1") || node.closest(".items.featured")));
                    })
                    .map(function (article) { return parseCard(article, mainUrl); })
                    .filter(Boolean);
                if (!items.length) items = parseCardsFromHtml(page.html, mainUrl);
                return { title: section.title, items: items };
            });
            const data = {};
            entries.forEach(function (entry) {
                if (entry && entry.items && entry.items.length) data[entry.title] = entry.items;
            });
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const page = await getDocument(mainUrl + "/page/1/?s=" + encodeURIComponent(String(query || "")), { Referer: mainUrl + "/" });
            let items = qsa(page.document, "article").map(function (article) { return parseCard(article, mainUrl); }).filter(Boolean);
            if (!items.length) items = parseCardsFromHtml(page.html, mainUrl);
            cb({ success: true, data: items });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    function metaContent(doc, prop) {
        return attrOf(qs(doc, "meta[property=\"" + prop + "\"]"), "content");
    }

    function parseDetailBasics(doc, url) {
        const rawTitle = textOf(qs(doc, "div.sheader h1")) || textOf(qs(doc, "h1"));
        const title = rawTitle.split("(")[0].trim() || rawTitle;
        const type = itemTypeFromUrl(url);
        const seasonMatch = rawTitle.match(/\bSeason\s*(\d+)\b/i);
        const poster = posterFrom(doc, url);
        return {
            title: title,
            rawTitle: rawTitle,
            seasonNumber: seasonMatch ? Number(seasonMatch[1]) : 0,
            type: type,
            image: absoluteUrl(url, metaContent(doc, "og:image")),
            description: metaContent(doc, "og:description"),
            posterUrl: poster,
            tags: qsa(doc, "div.sgeneros a").map(textOf).filter(Boolean),
            trailer: absoluteUrl(url, attrOf(qs(doc, ".responsive-embed-container iframe"), "src")).replace("/embed/", "/watch?v=")
        };
    }

    function parseRecommendations(doc, base) {
        return qsa(doc, "#single_relacionados article").map(function (article) {
            const anchor = qs(article, "a[href]");
            const href = absoluteUrl(base, attrOf(anchor, "href"));
            if (!href) return null;
            return new MultimediaItem({
                title: textOf(qs(article, "h3 a")) || "",
                url: href,
                posterUrl: posterFrom(article, base),
                type: itemTypeFromUrl(href)
            });
        }).filter(Boolean);
    }

    async function extractSeriesEpisodes(doc, pageUrl, basics, tmdb) {
        const entries = [];
        const seasonBlocks = qsa(doc, ".lgtagmessage");
        await mapConcurrent(seasonBlocks, 3, async function (seasonElement) {
            const seasonMatch = textOf(seasonElement).match(/Season\s*(\d+)/i);
            const season = seasonMatch ? Number(seasonMatch[1]) : 0;
            if (!season) return;
            let next = seasonElement.nextElementSibling;
            while (next && !(next.classList && next.classList.contains("lgtagmessage"))) {
                if (next.classList && next.classList.contains("movie-button-container")) {
                    const seasonUrl = absoluteUrl(pageUrl, attrOf(qs(next, "a[href]"), "href"));
                    if (seasonUrl) {
                        const seasonPage = await getDocument(seasonUrl, { Referer: pageUrl }).catch(function () { return null; });
                        if (seasonPage && seasonPage.document) {
                            qsa(seasonPage.document, ".entry-content a[href]").forEach(function (anchor) {
                                const label = textOf(anchor);
                                if (/zip/i.test(label)) return;
                                const epMatch = label.match(/EPISODE\s*[-:]?\s*(\d+)/i);
                                const episode = epMatch ? Number(epMatch[1]) : 0;
                                const href = absoluteUrl(seasonUrl, attrOf(anchor, "href"));
                                if (episode && href) entries.push({ season: season, episode: episode, href: href });
                            });
                        }
                    }
                }
                next = next.nextElementSibling;
            }
        });

        const grouped = {};
        entries.forEach(function (row) {
            const key = row.season + ":" + row.episode;
            grouped[key] = grouped[key] || { season: row.season, episode: row.episode, links: [] };
            grouped[key].links.push(row.href);
        });

        return Object.keys(grouped).sort(function (a, b) {
            const aa = grouped[a], bb = grouped[b];
            return aa.season === bb.season ? aa.episode - bb.episode : aa.season - bb.season;
        }).map(function (key) {
            const row = grouped[key];
            const info = tmdb && tmdb.episodes && tmdb.episodes.find(function (ep) {
                return ep.season === row.season && ep.episode === row.episode;
            });
            return new Episode({
                name: info && info.name || "Episode " + row.episode,
                url: payload({
                    sourceUrl: pageUrl,
                    title: basics.title,
                    type: "series",
                    season: row.season,
                    episode: row.episode,
                    links: dedupeBy(row.links, function (item) { return item; })
                }),
                season: row.season,
                episode: row.episode,
                posterUrl: info && info.posterUrl || basics.posterUrl,
                description: info && info.description || basics.description,
                score: info && info.score || undefined,
                released: info && info.released || undefined
            });
        });
    }

    async function load(url, cb) {
        try {
            const pageUrl = String(url || "");
            const page = await getDocument(pageUrl, { Referer: (await getMainUrl()) + "/" });
            const basics = parseDetailBasics(page.document, pageUrl);
            const tmdb = await fetchTmdb(basics.title, basics.type, basics.seasonNumber);
            const title = tmdb && tmdb.title || basics.title;
            const description = tmdb && tmdb.description || basics.description;
            const poster = tmdb && tmdb.posterUrl || basics.posterUrl || basics.image;
            const banner = tmdb && tmdb.bannerUrl || basics.image || poster;
            const tags = dedupeBy([].concat(basics.tags || [], tmdb && tmdb.genres || []), function (item) { return String(item).toLowerCase(); });
            const common = {
                title: title,
                url: pageUrl,
                posterUrl: poster,
                bannerUrl: banner,
                logoUrl: tmdb && tmdb.logoUrl || undefined,
                type: basics.type,
                description: description,
                year: tmdb && tmdb.year ? Number(tmdb.year) : undefined,
                score: tmdb && tmdb.score || undefined,
                cast: tmdb && tmdb.cast || undefined,
                tags: tags,
                recommendations: parseRecommendations(page.document, pageUrl),
                headers: mergeHeaders({ Referer: pageUrl })
            };
            if (basics.type === "movie") {
                const links = qsa(page.document, "div.movie-button-container a[href]").map(function (a) {
                    return absoluteUrl(pageUrl, attrOf(a, "href"));
                }).filter(Boolean);
                common.episodes = [new Episode({
                    name: "Movie",
                    url: payload({ sourceUrl: pageUrl, title: title, type: "movie", season: 1, episode: 1, links: dedupeBy(links, function (item) { return item; }) }),
                    season: 1,
                    episode: 1,
                    posterUrl: poster,
                    description: description
                })];
            } else {
                common.episodes = await extractSeriesEpisodes(page.document, pageUrl, basics, tmdb);
            }
            cb({ success: true, data: new MultimediaItem(common) });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    async function retry(times, delayMs, worker) {
        let last = null;
        for (let i = 0; i < times; i++) {
            try {
                const value = await worker();
                if (value) return value;
                last = value;
            } catch (e) {
                last = e;
            }
            if (i + 1 < times && delayMs) await new Promise(function (resolve) { setTimeout(resolve, delayMs); });
        }
        return last instanceof Error ? null : last;
    }

    function formEncode(data) {
        return Object.keys(data || {}).map(function (key) {
            return encodeURIComponent(key) + "=" + encodeURIComponent(data[key] == null ? "" : String(data[key]));
        }).join("&");
    }

    async function generateZinkLinks(url) {
        try {
            const page = await getDocument(url, { Referer: originOf(url) + "/" });
            const html = page.html;
            const randomId = (html.match(/generateDownloadLink\(['"]([^'"]+)/i) || [])[1];
            const ajaxEndpoint = (html.match(/https:\/\/[^"'\\\s]+ajax_generate_token\.php/i) || [])[0];
            const downloadBase = (html.match(/https:\/\/[^"'\\\s]+\/dl\//i) || [])[0];
            if (!randomId || !ajaxEndpoint || !downloadBase) return [];
            const token = await retry(3, 1000, async function () {
                const json = safeJson(await postText(
                    ajaxEndpoint + "?random_id=" + encodeURIComponent(randomId),
                    formEncode({ random_id: randomId }),
                    {
                        "X-Requested-With": "XMLHttpRequest",
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
                        "Referer": url
                    }
                ), {});
                return json && json.token;
            });
            if (!token) return [];
            const generatedUrl = downloadBase + token;
            const generated = await getDocument(generatedUrl, { Referer: url });
            const links = qsa(generated.document, "#mirror-buttons a[href]").map(function (a) {
                const href = absoluteUrl(generatedUrl, attrOf(a, "href"));
                const name = textOf(a).replace(/generate/ig, "").trim() || hostOf(href);
                return href ? { name: name, url: href } : null;
            }).filter(Boolean);
            const workerBtn = qs(generated.document, "#worker-btn");
            const workerId = (attrOf(workerBtn, "onclick").match(/handleServerRequest\(['"]worker['"]\s*,\s*['"]([^'"]+)/i) || [])[1];
            const serverHandler = (generated.html.match(/SERVER_HANDLER_URL\s*=\s*["']([^"']+)/i) || [])[1];
            if (workerId && serverHandler) {
                try {
                    const workerJson = safeJson(await postText(
                        absoluteUrl(generatedUrl, serverHandler),
                        JSON.stringify({ server: "worker", random_id: workerId }),
                        {
                            "X-Requested-With": "XMLHttpRequest",
                            "Content-Type": "application/json",
                            "Origin": generatedUrl.split("/dl/")[0],
                            "Referer": generatedUrl
                        }
                    ), {});
                    const workerUrl = workerJson && (workerJson.url || workerJson.download);
                    if (workerUrl) links.push({ name: "WORKER", url: workerUrl });
                } catch (_) {}
            }
            return dedupeBy(links, function (item) { return item.url; });
        } catch (_) {
            return [];
        }
    }

    async function resolveWithBuiltin(url, source, referer) {
        if (!url || typeof globalThis.loadExtractor !== "function") return [];
        const out = [];
        try {
            await globalThis.loadExtractor(url, function (stream) {
                if (!stream) return;
                if (!stream.headers && referer) stream.headers = { Referer: referer };
                if (!stream.source && source) stream.source = source;
                out.push(stream);
            });
        } catch (_) {}
        return out;
    }

    function cleanReleaseTags(title) {
        const parts = String(title || "")
            .replace(/\.[a-zA-Z0-9]{2,4}$/, "")
            .replace(/WEB[-_. ]?DL/ig, "WEB-DL")
            .replace(/WEB[-_. ]?RIP/ig, "WEBRIP")
            .replace(/H[ .]?265/ig, "H265")
            .replace(/H[ .]?264/ig, "H264")
            .split(/[ _.]+/);
        const keep = [];
        parts.forEach(function (part) {
            const p = part.toUpperCase();
            if (/^(WEB-DL|WEBRIP|BLURAY|HDRIP|DVDRIP|HDTV|CAM|TS|BRRIP|BDRIP|H264|H265|X264|X265|HEVC|AVC|ATMOS|SDR|HDR|HDR10|HDR10\+|DV|DOLBYVISION|NF|CR)$/.test(p) || /^(AAC|AC3|DTS|MP3|FLAC|DD|DDP|EAC3)/.test(p)) {
                keep.push(p === "DV" ? "DOLBYVISION" : p);
            }
        });
        return dedupeBy(keep, function (item) { return item; }).join(" ");
    }

    async function resolveHubCloud(url, refererLabel) {
        const realUrl = String(url || "");
        const base = originOf(realUrl) || await getHubCloudUrl();
        let href = realUrl;
        if (!/hubcloud\.php/i.test(realUrl)) {
            const page = await getDocument(realUrl, { Referer: base + "/" }).catch(function () { return null; });
            const raw = page && attrOf(qs(page.document, "#download"), "href");
            href = absoluteUrl(base, raw);
        }
        if (!href) return [];
        const page = await getDocument(href, { Referer: realUrl }).catch(function () { return null; });
        if (!page) return [];
        const size = textOf(qs(page.document, "i#size"));
        const header = textOf(qs(page.document, "div.card-header"));
        const details = cleanReleaseTags(header);
        const quality = qualityFromText(header) || 2160;
        const extras = (details ? "[" + details + "]" : "") + (size ? "[" + size + "]" : "");
        const out = [];
        const buttons = qsa(page.document, "a.btn[href]");
        for (let i = 0; i < buttons.length; i++) {
            const link = absoluteUrl(href, attrOf(buttons[i], "href"));
            const label = textOf(buttons[i]).toLowerCase();
            const ref = refererLabel || "HubCloud";
            if (!link) continue;
            if (/fsl server/i.test(label)) out.push(streamResult(link, ref + " [FSL Server] " + extras, {}, quality));
            else if (/download file/i.test(label)) out.push(streamResult(link, ref + " " + extras, {}, quality));
            else if (/buzzserver/i.test(label)) {
                const resp = await requestGet(link + "/download", { Referer: link }, false).catch(function () { return null; });
                const dlink = resp && resp.headers && (resp.headers["hx-redirect"] || resp.headers["HX-Redirect"]);
                if (dlink) out.push(streamResult(dlink, ref + " [BuzzServer] " + extras, {}, quality));
            } else if (/pixeldra|pixelserver|pixel server|pixeldrain/i.test(label)) {
                const finalUrl = /download/i.test(link) ? link : originOf(link) + "/api/file/" + link.split("/").pop() + "?download";
                out.push(streamResult(finalUrl, ref + " Pixeldrain " + extras, {}, quality));
            } else if (/s3 server/i.test(label)) out.push(streamResult(link, ref + " [S3 Server] " + extras, {}, quality));
            else if (/fslv2/i.test(label)) out.push(streamResult(link, ref + " [FSLv2] " + extras, {}, quality));
            else if (/mega server/i.test(label)) out.push(streamResult(link, ref + " [Mega Server] " + extras, {}, quality));
            else out.push.apply(out, await resolveWithBuiltin(link, ref, href));
        }
        return out;
    }

    async function resolveHubDrive(url) {
        const page = await getDocument(url, { Referer: originOf(url) + "/" }).catch(function () { return null; });
        const href = page && absoluteUrl(url, attrOf(qs(page.document, ".btn.btn-primary.btn-user.btn-success1.m-1"), "href"));
        if (!href) return [streamResult(url, "Hubdrive", { Referer: originOf(url) + "/" }, qualityFromText(url))];
        if (/hubcloud/i.test(href)) return resolveHubCloud(href, "HubDrive");
        const extracted = await resolveWithBuiltin(href, "HubDrive", url);
        return extracted.length ? extracted : [streamResult(href, "HubDrive", { Referer: url }, qualityFromText(href))];
    }

    async function resolveHubCdn(url) {
        const page = await getDocument(url, { Referer: originOf(url) + "/" }).catch(function () { return null; });
        const script = page && textOf(qs(page.document, "script")) + "\n" + page.html || "";
        const encoded = ((script.match(/reurl\s*=\s*"([^"]+)"/i) || [])[1] || "").split("?r=").pop();
        if (!encoded) return [];
        let decoded = "";
        try {
            decoded = atob(encoded);
        } catch (_) {
            decoded = "";
        }
        const finalUrl = decoded.split("link=").pop();
        return finalUrl && /^https?:\/\//i.test(finalUrl) ? [streamResult(finalUrl, "HUBCDN", {}, qualityFromText(finalUrl))] : [];
    }

    function isDirectMedia(url) {
        return /\.(m3u8|mp4|mkv)(?:[?#]|$)/i.test(String(url || ""));
    }

    function isUnresolvedGdflixPage(url) {
        return /(^|\.)gdlink\.dev$/i.test(hostOf(url)) || /(^|\.)gdfli?x/i.test(hostOf(url));
    }

    async function resolveFinalLink(link, source, referer) {
        const url = String(link || "").trim();
        if (!url) return [];
        const host = hostOf(url);
        if (isDirectMedia(url)) return [streamResult(url, source || host || "Direct", referer ? { Referer: referer } : {}, qualityFromText(url))];
        if (isUnresolvedGdflixPage(url)) return [];
        if (/hubdrive\./i.test(host)) return resolveHubDrive(url);
        if (/hubcloud/i.test(host) || /hubcloud\.php/i.test(url)) return resolveHubCloud(url, source || "HubCloud");
        if (/hubcdn\./i.test(host)) return resolveHubCdn(url);
        if (/pixeldrain\./i.test(host)) {
            const finalUrl = /\/api\/file\/|download/i.test(url) ? url : originOf(url) + "/api/file/" + url.split("/").pop() + "?download";
            return [streamResult(finalUrl, source || "Pixeldrain", {}, qualityFromText(finalUrl))];
        }
        const extracted = await resolveWithBuiltin(url, source || host, referer);
        return extracted.length ? extracted : [streamResult(url, source || host || "Zinkmovies", referer ? { Referer: referer } : {}, qualityFromText(url))];
    }

    async function loadStreams(data, cb) {
        try {
            const parsed = parsePayload(data);
            const links = dedupeBy((parsed.links || []).map(String).filter(Boolean), function (item) { return item; });
            if (!links.length) return cb({ success: true, data: [] });
            const batches = await mapConcurrent(links, 4, async function (pageUrl) {
                const zinks = await generateZinkLinks(pageUrl);
                if (!zinks.length) return resolveFinalLink(pageUrl, "Zinkmovies", parsed.sourceUrl || "");
                const resolved = await mapConcurrent(zinks, 4, async function (link) {
                    if (/worker/i.test(link.name)) {
                        return [streamResult(link.url, "Zink Worker", {}, qualityFromText(link.url))];
                    }
                    return resolveFinalLink(link.url, link.name || "Zinkmovies", pageUrl);
                });
                return resolved.flat();
            });
            const streams = dedupeBy(batches.flat().filter(function (item) { return item && item.url; }), function (item) {
                return item.url + "|" + JSON.stringify(item.headers || {});
            }).filter(function (item) {
                return !isUnresolvedGdflixPage(item.url);
            }).sort(function (a, b) {
                return Number(b.quality || 0) - Number(a.quality || 0);
            });
            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
