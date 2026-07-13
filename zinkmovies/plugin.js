(function () {
    function base64Decode(str) {
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var output = "";
        var bytes = [];
        for (var i = 0; i < str.length; i += 4) {
            var a = chars.indexOf(str[i]);
            var b = chars.indexOf(str[i + 1] || "=");
            var c = chars.indexOf(str[i + 2] || "=");
            var d = chars.indexOf(str[i + 3] || "=");
            bytes.push((a << 2) | (b >> 4));
            if (c !== -1 && str[i + 2] !== "=") bytes.push(((b & 15) << 4) | (c >> 2));
            if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
        }
        for (var j = 0; j < bytes.length; j++) output += String.fromCharCode(bytes[j]);
        return output;
    }

    const GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
    const GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

    const SessionTracker = {
        clientId: null,
        init() { this.clientId = this.generateUuid(); },
        generateUuid() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random() * 16 | 0;
                return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
        }
    };
    SessionTracker.init();

    const Analytics = {
        clientId: null,
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        queue: [],
        init() { this.clientId = SessionTracker.clientId; },
        logEvent(eventName, parameters) {
            console.log('[Analytics] Event: ' + eventName + ' | clientId: ' + this.clientId);
            if (!this.measurementId || !this.apiSecret) return;
            this.queue.push({ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) });
            this.flushQueue();
        },
        async flushQueue() {
            if (this.queue.length === 0) return;
            var events = this.queue.splice(0);
            try {
                await http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
            } catch (e) { console.log('[Analytics] Send skipped'); }
        }
    };
    Analytics.init();

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
    const pageCache = Object.create(null);
    const zinkLinkCache = Object.create(null);

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

    function cleanBrokenText(value) {
        return decodeHtml(String(value || "")
            .replace(/<img\b[\s\S]*?alt=["']([^"']+)["'][\s\S]*?>/ig, "$1")
            .replace(/<[^>]+>/g, " ")
            .replace(/\s*\/\s*/g, "/")
            .replace(/https?:\/\s+/ig, function (m) { return m.replace(/\s+/g, ""); })
            .replace(/\s+/g, " ")
            .trim());
    }

    function attrFromHtml(block, name) {
        const re = new RegExp("\\s" + name + "\\s*=\\s*([\"'])([\\s\\S]*?)\\1", "i");
        const match = String(block || "").match(re);
        return match ? decodeHtml(match[2]) : "";
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

    function cacheKey(url, headers) {
        return String(url || "") + "|" + JSON.stringify(headers || {});
    }

    async function getTextCached(url, headers) {
        const key = cacheKey(url, headers);
        if (Object.prototype.hasOwnProperty.call(pageCache, key)) return pageCache[key];
        const html = await getText(url, headers, true);
        pageCache[key] = html;
        return html;
    }

    async function parallelGetText(requests, limit) {
        const items = Array.isArray(requests) ? requests.filter(function (item) { return item && item.url; }) : [];
        if (!items.length) return [];

        const uncached = [];
        const out = new Array(items.length);
        items.forEach(function (item, index) {
            const key = cacheKey(item.url, item.headers);
            if (Object.prototype.hasOwnProperty.call(pageCache, key)) {
                out[index] = pageCache[key];
            } else {
                uncached.push({ item: item, index: index, key: key });
            }
        });

        if (uncached.length && typeof http_parallel === "function") {
            try {
                const responses = await http_parallel(uncached.map(function (row) {
                    return { method: "GET", url: row.item.url, headers: mergeHeaders(row.item.headers || {}) };
                }));
                uncached.forEach(function (row, i) {
                    const body = String(responses && responses[i] && responses[i].body || "");
                    pageCache[row.key] = body;
                    out[row.index] = body;
                });
                return out;
            } catch (_) {}
        }

        await mapConcurrent(uncached, limit || 6, async function (row) {
            const body = await getText(row.item.url, row.item.headers || {}, true).catch(function () { return ""; });
            pageCache[row.key] = body;
            out[row.index] = body;
        });
        return out;
    }

    async function httpParallelGet(requests) {
        var items = Array.isArray(requests) ? requests.filter(function (item) { return item && item.url; }) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var parallelRes = await http_parallel(items.map(function (item) {
                    return {
                        method: "GET",
                        url: item.url,
                        headers: mergeHeaders(item.headers || {})
                    };
                }));
                return items.map(function (item, index) {
                    var res = parallelRes && parallelRes[index];
                    return {
                        status: (res && typeof res.status !== "undefined") ? res.status : 200,
                        body: String(res && (res.body || res.text || "") || ""),
                        headers: (res && res.headers) || {},
                        url: (res && (res.url || res.finalUrl)) || item.url
                    };
                });
            } catch (_) {}
        }
        return await Promise.all(items.map(function (item) {
            return getText(item.url, mergeHeaders(item.headers || {})).then(function (body) {
                return { status: 200, body: body, headers: {}, url: item.url };
            }).catch(function () {
                return { status: 599, body: "", headers: {}, url: item.url };
            });
        }));
    }

    async function getDocument(url, headers) {
        const html = await getTextCached(url, headers);
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
        const source = cleanBrokenText(raw);
        let name = source.split("(")[0].trim().replace(/\s+/g, " ");
        if (name) name = name.charAt(0).toUpperCase() + name.slice(1);
        const season = (source.match(/Season\s*\d+/i) || [])[0];
        const year = (source.match(/\b(?:19|20)\d{2}\b/) || [])[0];
        let suffix = "";
        if (season) suffix += " (" + season.charAt(0).toUpperCase() + season.slice(1) + ")";
        if (year) suffix += " (" + year + ")";
        return (name || source.trim()) + suffix;
    }

    function usableTitle(value) {
        const cleaned = cleanTitle(value);
        if (!cleaned || /<\s*img|src\s*=|data-lazy-src/i.test(cleaned)) return "";
        return cleaned;
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
        const anchor = qs(article, "h3 a") || qs(article, ".title a");
        const href = absoluteUrl(base, attrOf(anchor, "href"));
        let title = usableTitle(textOf(anchor));
        if (!title) title = usableTitle(attrOf(qs(article, "img"), "alt"));
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
            let title = usableTitle(stripTags(firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<img\b[^>]*alt=["']([^"']+)["']/i
            ])));
            if (!title) title = usableTitle(attrFromHtml(firstMatch(block, [/<img\b([\s\S]*?)>/i]), "alt"));
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
            const details = safeJson(await getText(TMDB_API + "/" + kind + "/" + id + "?api_key=" + TMDB_KEY + "&append_to_response=credits,external_ids,videos", {}, true), {});
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

    function extractTmdbGenres(tmdbDetails) {
        if (!tmdbDetails || !Array.isArray(tmdbDetails.genres)) return [];
        return tmdbDetails.genres.map(function (g) {
            return g && g.name ? g.name : "";
        }).filter(Boolean);
    }

    function chooseBestTmdbResult(results, title, year) {
        if (!Array.isArray(results) || !results.length) return null;
        if (year) {
            for (var i = 0; i < results.length; i++) {
                var r = results[i];
                var dateStr = r.release_date || r.first_air_date || "";
                if (dateStr.indexOf(year) === 0) return r;
            }
        }
        return results[0];
    }

    async function getHome(cb) {
        try {
            var mainUrl = await getMainUrl();
            var results = {};
            var firstHtml = "";

            var sectionRequests = HOME_SECTIONS.map(function (section) {
                return {
                    url: mainUrl + "/" + section.path + "page/1/",
                    headers: { Referer: mainUrl + "/" }
                };
            });
            var sectionResponses = await httpParallelGet(sectionRequests);

            var sectionEntries = sectionResponses.map(function (res, idx) {
                var html = res && res.body ? res.body : "";
                if (!firstHtml && html) firstHtml = html;
                var items = parseCardsFromHtml(html, mainUrl);
                return {
                    title: HOME_SECTIONS[idx].title,
                    html: html,
                    items: items
                };
            });

            var trendingIdx = 0;
            var trendingEntry = sectionEntries[trendingIdx];
            var trendingItems = (trendingEntry && trendingEntry.items) || [];
            var trendingMeta = {};

            if (trendingItems.length) {
                var searchReqs = [];
                for (var t = 0; t < trendingItems.length; t++) {
                    var item = trendingItems[t];
                    var rawTitle = String(item.title || "").split("(")[0].trim();
                    var yearMatch = String(item.title || "").match(/\((\d{4})\)/);
                    var searchYear = yearMatch ? yearMatch[1] : "";
                    var mediaType = item.type === "series" ? "tv" : "movie";
                    var searchUrl = TMDB_API + "/search/" + mediaType + "?api_key=" + TMDB_KEY + "&query=" + encodeURIComponent(rawTitle) + (searchYear ? "&year=" + searchYear : "");
                    searchReqs.push({ url: searchUrl, headers: mergeHeaders() });
                }

                var searchResponses = await httpParallelGet(searchReqs);

                var detailReqs = [];
                var detailOrigIdx = [];
                for (var r = 0; r < searchResponses.length; r++) {
                    var searchJson = safeJson(searchResponses[r].body, {});
                    var itemYearMatch = String(trendingItems[r].title || "").match(/\((\d{4})\)/);
                    var itemYear = itemYearMatch ? itemYearMatch[1] : "";
                    var bestResult = chooseBestTmdbResult(searchJson.results, trendingItems[r].title, itemYear);
                    if (bestResult && bestResult.id) {
                        var mdType = trendingItems[r].type === "series" ? "tv" : "movie";
                        detailReqs.push({
                            url: TMDB_API + "/" + mdType + "/" + bestResult.id + "?api_key=" + TMDB_KEY + "&append_to_response=images,external_ids",
                            headers: mergeHeaders()
                        });
                        detailOrigIdx.push(r);
                    }
                }

                var detailResponses = detailReqs.length ? await httpParallelGet(detailReqs) : [];
                for (var d = 0; d < detailResponses.length; d++) {
                    var origItemIdx = detailOrigIdx[d];
                    var details = safeJson(detailResponses[d].body, {});
                    var imdbId = details && details.external_ids && details.external_ids.imdb_id ? details.external_ids.imdb_id : "";
                    var logoUrl = imdbId ? ("https://live.metahub.space/logo/medium/" + imdbId + "/img") : "";
                    var bannerPath = details && details.backdrop_path ? details.backdrop_path : "";
                    var genres = extractTmdbGenres(details);
                    var rating = details && typeof details.vote_average === "number" ? Number(details.vote_average.toFixed(1)) : undefined;
                    trendingMeta[origItemIdx] = {
                        logoUrl: logoUrl || undefined,
                        bannerUrl: bannerPath ? (TMDB_IMAGE + bannerPath) : undefined,
                        genres: genres,
                        rating: rating
                    };
                }
            }

            for (var e = 0; e < sectionEntries.length; e++) {
                var entry = sectionEntries[e];
                if (e === trendingIdx) {
                    var enrichedItems = entry.items.map(function (item, idx) {
                        var meta = trendingMeta[idx] || {};
                        return {
                            title: item.title,
                            url: item.url,
                            posterUrl: item.posterUrl,
                            type: item.type,
                            quality: item.quality,
                            logoUrl: meta.logoUrl,
                            bannerUrl: meta.bannerUrl,
                            genres: meta.genres,
                            rating: meta.rating
                        };
                    });
                    results[entry.title] = enrichedItems;
                } else {
                    results[entry.title] = entry.items;
                }
            }

            var total = 0;
            for (var key in results) {
                if (!Object.prototype.hasOwnProperty.call(results, key)) continue;
                total += (results[key] || []).length;
            }
            if (!total) {
                cb({ success: false, errorCode: "HOME_EMPTY", message: "No home items parsed." });
                return;
            }

            Analytics.logEvent('zinkmovies_home', {});
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && (error.stack || error.message) || error) });
        }
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const html = await getTextCached(mainUrl + "/page/1/?s=" + encodeURIComponent(String(query || "")), { Referer: mainUrl + "/" });
            let items = parseCardsFromHtml(html, mainUrl);
            if (!items.length) {
                const doc = await parseHtml(stripScripts(html));
                items = qsa(doc, "article").map(function (article) { return parseCard(article, mainUrl); }).filter(Boolean);
            }
            Analytics.logEvent('zinkmovies_search', {});
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
            const anchor = qs(article, "h3 a") || qs(article, ".title a") || qs(article, "a[href]");
            const href = absoluteUrl(base, attrOf(anchor, "href"));
            const title = usableTitle(textOf(anchor)) || usableTitle(attrOf(qs(article, "img"), "alt"));
            if (!href || !title) return null;
            return new MultimediaItem({
                title: title,
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
                airDate: info && info.released || undefined
            });
        });
    }

    function extractTmdbTrailerUrl(tmdbDetails) {
        if (!tmdbDetails || !tmdbDetails.videos) return "";
        var results = tmdbDetails.videos.results || [];
        var official = null;
        var fallback = null;
        for (var i = 0; i < results.length; i++) {
            var v = results[i];
            if (!v || !v.key) continue;
            var name = String(v.name || "").toLowerCase();
            var type = String(v.type || "").toLowerCase();
            if (v.site === "YouTube" && type === "trailer" && v.official) {
                if (!official || name.indexOf("official") !== -1) official = v;
            }
            if (!fallback && v.site === "YouTube" && type === "trailer") fallback = v;
        }
        var best = official || fallback;
        if (!best) {
            for (var j = 0; j < results.length; j++) {
                if (results[j] && results[j].key && results[j].site === "YouTube") {
                    best = results[j];
                    break;
                }
            }
        }
        return best ? ("https://www.youtube.com/watch?v=" + best.key) : "";
    }

    function extractTmdbDuration(tmdbDetails, type) {
        if (!tmdbDetails) return undefined;
        if (type === "movie") {
            var runtime = Number(tmdbDetails.runtime);
            return isNaN(runtime) || runtime <= 0 ? undefined : runtime;
        }
        var runTimes = tmdbDetails.episode_run_time;
        if (Array.isArray(runTimes) && runTimes.length > 0) {
            var first = Number(runTimes[0]);
            return isNaN(first) || first <= 0 ? undefined : first;
        }
        return undefined;
    }

    function extractDurationFromHtml(html) {
        var text = stripTags(String(html || ""));
        var match = text.match(/(?:Duration|Runtime|Length)[:\s]*(\d+)\s*(?:min|minutes?|mins?|m\b)/i);
        if (match) return Number(match[1]);
        var hMatch = text.match(/(\d+)\s*h(?:r|our)?s?\s*(?:\d+)?\s*(?:min|minutes?|mins?)?/i);
        if (hMatch) {
            var hours = Number(hMatch[1]) * 60;
            var mins = text.match(/\d+\s*h(?:r|our)?s?\s*(\d+)\s*(?:min|minutes?|mins?)/i);
            return hours + (mins ? Number(mins[1]) : 0);
        }
        return undefined;
    }

    function extractTrailerFromHtml(html, base) {
        var match = firstMatch(html, [
            /<a\b[^>]*href=["']([^"']*(?:youtube\.com\/watch|youtu\.be\/)[^"']*)["']/i,
            /<iframe\b[^>]*src=["']([^"']*(?:youtube\.com\/embed|youtube\.com\/v)[^"']*)["']/i
        ]);
        if (!match) return "";
        if (/youtu\.be\/([a-zA-Z0-9_-]+)/.test(match)) {
            var id = match.match(/youtu\.be\/([a-zA-Z0-9_-]+)/);
            return "https://www.youtube.com/watch?v=" + id[1];
        }
        if (/youtube\.com\/embed\/([a-zA-Z0-9_-]+)/.test(match)) {
            var embedId = match.match(/youtube\.com\/embed\/([a-zA-Z0-9_-]+)/);
            return "https://www.youtube.com/watch?v=" + embedId[1];
        }
        return match;
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
            const trailerUrl = extractTmdbTrailerUrl(tmdb) || extractTrailerFromHtml(page.html, pageUrl);
            const duration = extractTmdbDuration(tmdb, basics.type === "movie" ? "movie" : "tv") || extractDurationFromHtml(page.html);
            const genres = extractTmdbGenres(tmdb);
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
                runtime: duration,
                genres: genres,
                trailers: trailerUrl ? [new Trailer({ url: trailerUrl })] : undefined,
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
            Analytics.logEvent('zinkmovies_load', {});
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

    function parseAnchorsFromHtml(html, base, selectorHint) {
        const out = [];
        const text = String(html || "");
        const regex = /<a\b([^>]*)>([\s\S]*?)<\/a>/gi;
        let match;
        while ((match = regex.exec(text))) {
            const attrs = match[1] || "";
            const body = match[2] || "";
            if (selectorHint === "btn" && !/\bclass\s*=\s*["'][^"']*\bbtn\b/i.test(attrs)) continue;
            const href = absoluteUrl(base, attrFromHtml(attrs, "href"));
            if (!href) continue;
            out.push({ href: href, text: cleanBrokenText(body), attrs: attrs, html: match[0] });
        }
        return out;
    }

    async function generateZinkLinks(url) {
        if (Object.prototype.hasOwnProperty.call(zinkLinkCache, url)) return zinkLinkCache[url];
        try {
            const html = await getTextCached(url, { Referer: originOf(url) + "/" });
            const randomId = (html.match(/generateDownloadLink\(['"]([^'"]+)/i) || [])[1];
            const ajaxEndpoint = (html.match(/https:\/\/[^"'\\\s]+ajax_generate_token\.php/i) || [])[0];
            const downloadBase = (html.match(/https:\/\/[^"'\\\s]+\/dl\//i) || [])[0];
            if (!randomId || !ajaxEndpoint || !downloadBase) {
                zinkLinkCache[url] = [];
                return [];
            }
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
            if (!token) {
                zinkLinkCache[url] = [];
                return [];
            }
            const generatedUrl = downloadBase + token;
            const generatedHtml = await getTextCached(generatedUrl, { Referer: url });
            const mirrorBlock = firstMatch(generatedHtml, [/<[^>]*id=["']mirror-buttons["'][^>]*>([\s\S]*?)(?:<\/div>|<[^>]*id=["']worker-btn["'])/i]) || generatedHtml;
            const links = parseAnchorsFromHtml(mirrorBlock, generatedUrl).map(function (a) {
                return {
                    name: a.text.replace(/generate/ig, "").trim() || hostOf(a.href),
                    url: a.href
                };
            });
            const workerButtonHtml = (generatedHtml.match(/<[^>]*id=["']worker-btn["'][^>]*>/i) || [""])[0];
            const workerId = (workerButtonHtml.match(/handleServerRequest\(['"]worker['"]\s*,\s*['"]([^'"]+)/i) || [])[1];
            const serverHandler = (generatedHtml.match(/SERVER_HANDLER_URL\s*=\s*["']([^"']+)/i) || [])[1];
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
            zinkLinkCache[url] = dedupeBy(links, function (item) { return item.url; });
            return zinkLinkCache[url];
        } catch (_) {
            zinkLinkCache[url] = [];
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
            const html = await getTextCached(realUrl, { Referer: base + "/" }).catch(function () { return ""; });
            const downloadTag = (html.match(/<a\b[^>]*id=["']download["'][^>]*>/i) || [""])[0];
            const raw = attrFromHtml(downloadTag, "href");
            href = absoluteUrl(base, raw);
        }
        if (!href) return [];
        const html = await getTextCached(href, { Referer: realUrl }).catch(function () { return ""; });
        if (!html) return [];
        const size = cleanBrokenText(firstMatch(html, [/<i\b[^>]*id=["']size["'][^>]*>([\s\S]*?)<\/i>/i]));
        const header = cleanBrokenText(firstMatch(html, [/<div\b[^>]*class=["'][^"']*card-header[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]));
        const details = cleanReleaseTags(header);
        const quality = qualityFromText(header) || 2160;
        const extras = (details ? "[" + details + "]" : "") + (size ? "[" + size + "]" : "");
        const out = [];
        const buttons = parseAnchorsFromHtml(html, href, "btn");
        for (let i = 0; i < buttons.length; i++) {
            const link = buttons[i].href;
            const label = String(buttons[i].text || "").toLowerCase();
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
        const html = await getTextCached(url, { Referer: originOf(url) + "/" }).catch(function () { return ""; });
        const button = (html.match(/<a\b[^>]*class=["'][^"']*btn-primary[^"']*btn-user[^"']*btn-success1[^"']*["'][^>]*>/i) || [""])[0];
        const href = absoluteUrl(url, attrFromHtml(button, "href"));
        if (!href) return [streamResult(url, "Hubdrive", { Referer: originOf(url) + "/" }, qualityFromText(url))];
        if (/hubcloud/i.test(href)) return resolveHubCloud(href, "HubDrive");
        const extracted = await resolveWithBuiltin(href, "HubDrive", url);
        return extracted.length ? extracted : [streamResult(href, "HubDrive", { Referer: url }, qualityFromText(href))];
    }

    async function resolveHubCdn(url) {
        const script = await getTextCached(url, { Referer: originOf(url) + "/" }).catch(function () { return ""; });
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
            const batches = await mapConcurrent(links, 6, async function (pageUrl) {
                const zinks = await generateZinkLinks(pageUrl);
                if (!zinks.length) return resolveFinalLink(pageUrl, "Zinkmovies", parsed.sourceUrl || "");
                const resolved = await mapConcurrent(zinks, 6, async function (link) {
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
            Analytics.logEvent('zinkmovies_loadstreams', {});
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
