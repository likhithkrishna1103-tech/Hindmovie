(function () {
    "use strict";

    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var DOMAINS_JSON_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var domainsCache = null;
    var HDMOVIE2_HOME_SECTIONS = [
        { path: function () { return "release/" + new Date().getFullYear(); }, title: "Latest" },
        { path: "genre/bollywood", title: "BollyWood" },
        { path: "movies", title: "Movies" },
        { path: "genre/hindi-webseries", title: "Hindi Web Series" },
        { path: "genre/netflix", title: "Netflix" },
        { path: "genre/zee5", title: "Zee5" },
        { path: "genre/hindi-dubbed", title: "Hindi Dubbed" },
        { path: "genre/comedy", title: "Comedy" },
        { path: "genre/science-fiction", title: "Science Fiction" }
    ];

    function trim(value) {
        return String(value == null ? "" : value).replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function decodeHtml(value) {
        return trim(String(value == null ? "" : value)
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&#039;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">"));
    }

    function stripTags(value) {
        return decodeHtml(String(value == null ? "" : value).replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "));
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function parseHeaders(rawHeaders) {
        var headers = {};
        if (!rawHeaders) return headers;
        if (typeof rawHeaders.forEach === "function") {
            rawHeaders.forEach(function (value, key) {
                headers[String(key).toLowerCase()] = value;
            });
            return headers;
        }
        for (var key in rawHeaders) {
            if (!Object.prototype.hasOwnProperty.call(rawHeaders, key)) continue;
            headers[String(key).toLowerCase()] = rawHeaders[key];
        }
        return headers;
    }

    function responseStatus(res) {
        if (!res) return 0;
        if (typeof res.status === "number") return res.status;
        if (typeof res.statusCode === "number") return res.statusCode;
        return 0;
    }

    function requestWithFetch(url, method, headers, body, allowRedirects) {
        return fetch(url, {
            method: method,
            headers: headers,
            body: body,
            redirect: allowRedirects ? "follow" : "manual"
        }).then(function (res) {
            return res.text().then(function (bodyText) {
                return {
                    status: res.status,
                    body: bodyText,
                    headers: parseHeaders(res.headers),
                    finalUrl: res.url || url
                };
            });
        });
    }

    function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || {};
        var body = options.body;
        var allowRedirects = options.allowRedirects !== false;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                return {
                    status: responseStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            var attempts = [
                function () { return http_post(url, headers, body); },
                function () { return http_post(url, body, headers); }
            ];
            return (async function () {
                var lastError = null;
                for (var i = 0; i < attempts.length; i++) {
                    try {
                        var res = await attempts[i]();
                        return {
                            status: responseStatus(res) || 200,
                            body: res && typeof res.body !== "undefined" ? res.body : "",
                            headers: parseHeaders(res && res.headers),
                            finalUrl: (res && (res.url || res.finalUrl)) || url
                        };
                    } catch (error) {
                        lastError = error;
                    }
                }
                throw lastError || new Error("POST failed: " + url);
            })();
        }

        return requestWithFetch(url, method, headers, body, allowRedirects);
    }

    function getText(url, headers, allowRedirects) {
        return request(url, { headers: headers || {}, allowRedirects: allowRedirects }).then(function (res) {
            if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
            return String(res.body || "");
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers || {} }).then(function (res) {
            if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
            return parseJsonSafe(res.body, {});
        });
    }

    function absoluteUrl(base, path) {
        if (!path) return "";
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function baseOrigin(url) {
        try {
            var parsed = new URL(url);
            return parsed.protocol + "//" + parsed.host;
        } catch (_) {
            return "";
        }
    }

    function firstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return trim(match[1]);
        }
        return "";
    }

    function firstRawMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && typeof match[1] !== "undefined") return String(match[1] || "");
        }
        return "";
    }

    function parseAnchors(html, base) {
        var source = String(html || "");
        var out = [];
        var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = regex.exec(source))) {
            out.push({
                href: absoluteUrl(base, decodeHtml(match[1])),
                text: stripTags(match[2])
            });
        }
        return out;
    }

    function extractBlocks(html, tagName) {
        var blocks = [];
        var regex = new RegExp("<" + tagName + "\\b[\\s\\S]*?<\\/" + tagName + ">", "gi");
        var match;
        while ((match = regex.exec(String(html || "")))) {
            blocks.push(match[0]);
        }
        return blocks;
    }

    function qualityFromText(text) {
        var value = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b|\buhd\b/.test(value)) return 2160;
        if (/\b1080p\b/.test(value)) return 1080;
        if (/\b720p\b/.test(value)) return 720;
        if (/\b480p\b/.test(value)) return 480;
        if (/\b360p\b/.test(value)) return 360;
        return 0;
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function normalizeTitle(value) {
        return trim(String(value || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/\b(the|a|an)\b/g, " ")
            .replace(/[^a-z0-9]+/g, " "));
    }

    function titleScore(candidate, queries) {
        var cand = normalizeTitle(candidate);
        if (!cand) return 0;
        var best = 0;
        for (var i = 0; i < queries.length; i++) {
            var query = normalizeTitle(queries[i]);
            if (!query) continue;
            if (cand === query) best = Math.max(best, 100);
            else if (cand.indexOf(query) !== -1 || query.indexOf(cand) !== -1) best = Math.max(best, 75);
        }
        return best;
    }

    function bestMatch(list, queries, year, typeHint) {
        var ranked = [];
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var score = titleScore(item && item.title, queries);
            if (score <= 0) continue;
            if (year && item && item.year) {
                if (String(item.year) === String(year)) score += 18;
                else if (Math.abs(Number(item.year) - Number(year)) <= 1) score += 8;
            }
            if (typeHint && item && item.type && String(item.type) === String(typeHint)) score += 5;
            ranked.push({ item: item, score: score });
        }
        ranked.sort(function (a, b) { return b.score - a.score; });
        return ranked.length ? ranked[0].item : null;
    }

    function commonHeaders(extra) {
        return Object.assign({
            "User-Agent": COMMON_USER_AGENT,
            "Accept": "*/*"
        }, extra || {});
    }

    async function getDynamicDomain(key, fallback) {
        if (!domainsCache) {
            try {
                domainsCache = await getJson(DOMAINS_JSON_URL, commonHeaders({ "Accept": "application/json" }));
            } catch (_) {
                domainsCache = {};
            }
        }
        return trim(String(domainsCache && domainsCache[key] || fallback || "")).replace(/\/+$/g, "");
    }

    function buildPayload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed && typeof parsed === "object") return parsed;
        throw new Error("Invalid payload");
    }

    async function getTmdbJson(path) {
        var urls = [
            TMDB_WORKER_API + "/" + String(path || "").replace(/^\/+/, ""),
            TMDB_API + "/" + String(path || "").replace(/^\/+/, "")
        ];
        var lastError = null;
        for (var i = 0; i < urls.length; i++) {
            try {
                return await getJson(urls[i]);
            } catch (error) {
                lastError = error;
            }
        }
        throw lastError || new Error("TMDB request failed");
    }

    function tmdbImage(path) {
        return path ? (TMDB_IMAGE + path) : "";
    }

    function yearFromText(value) {
        var match = String(value || "").match(/\b(19|20)\d{2}\b/);
        return match ? Number(match[0]) : 0;
    }

    function buildSitePayload(data) {
        return buildPayload({
            mode: "site",
            pageUrl: data.pageUrl || data.url || "",
            title: data.title || "",
            originalTitle: data.originalTitle || data.title || "",
            year: Number(data.year) || 0,
            isMovie: true,
            posterUrl: data.posterUrl || "",
            bannerUrl: data.bannerUrl || data.posterUrl || "",
            description: data.description || ""
        });
    }

    function buildSiteCard(data) {
        return new MultimediaItem({
            title: data.title || "",
            url: buildSitePayload(data),
            posterUrl: data.posterUrl || "",
            bannerUrl: data.bannerUrl || data.posterUrl || "",
            description: data.description || "",
            year: Number(data.year) || 0,
            type: "movie"
        });
    }

    function parseHdmovieCard(block, base) {
        var href = absoluteUrl(base, firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*>\s*<div\b[^>]*class=["'][^"']*see/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*>/i
        ]));
        var title = stripTags(firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<img\b[^>]*alt=["']([^"']+)["']/i
        ]));
        if (!href || !title) return null;
        var posterUrl = normalizeResolvedUrl(firstMatch(block, [/<img\b[^>]*src=["']([^"']+)["']/i]), base);
        var year = yearFromText(stripTags(firstMatch(block, [
            /<span class=["']year["'][^>]*>([^<]+)<\/span>/i,
            /<div class=["'][^"']*data[^"']*>\s*<h3[\s\S]*?<span>([\s\S]*?)<\/span>/i,
            /<div class=["'][^"']*meta[^"']*>\s*<span class=["']year["'][^>]*>([^<]+)<\/span>/i
        ])) || title);
        var description = stripTags(firstMatch(block, [/<div class=["'][^"']*contenido[^"']*>\s*<p>([\s\S]*?)<\/p>/i]));
        return {
            title: title,
            pageUrl: href,
            url: href,
            posterUrl: posterUrl,
            bannerUrl: posterUrl,
            description: description,
            year: year,
            type: "movie"
        };
    }

    function parseHdmovieCards(containerHtml, base) {
        return extractBlocks(containerHtml, "article").map(function (block) {
            return parseHdmovieCard(block, base);
        }).filter(Boolean);
    }

    function parseHdmovieFeatured(html, base) {
        var container = firstRawMatch(html, [/<div class=["']items featured["']>([\s\S]*?)<\/div>\s*<header>/i]);
        return parseHdmovieCards(container, base);
    }

    function parseHdmovieLatest(html, base) {
        var container = firstRawMatch(html, [/<div class=["']items normal["']>([\s\S]*?)<\/div>\s*<\/div>\s*<div class=["']sidebar/i]);
        return parseHdmovieCards(container, base);
    }

    function parseHdmoviePopular(html, base) {
        var container = firstRawMatch(html, [/<h2 class=["']widget-title["']>Popular Mo(?:i|v)ies[\s\S]*?<\/h2><div class=["']dtw_content dt_views_count["']>([\s\S]*?)<\/div><\/aside>/i]);
        return parseHdmovieCards(container, base);
    }

    function parseHdmovieArchiveItems(html, base) {
        var container = firstRawMatch(html, [
            /<header>\s*<h2>Recently added<\/h2>\s*<\/header>\s*<div class=["']items normal["']>([\s\S]*?)<\/div>\s*<div class=["']resppages["']/i,
            /<div class=["']items normal["']>([\s\S]*?)<\/div>\s*<div class=["']resppages["']/i,
            /<div class=["']items normal["']>([\s\S]*?)<\/div>\s*<\/div>\s*<div class=["']sidebar/i
        ]);
        return parseHdmovieCards(container, base);
    }

    function parseHdmovieSearchResults(html, base) {
        var out = [];
        var regex = /<div class=["']result-item["'][\s\S]*?<\/article>\s*<\/div>/gi;
        var match;
        while ((match = regex.exec(String(html || ""))) !== null) {
            var card = parseHdmovieCard(match[0], base);
            if (card) out.push(card);
        }
        return uniqueBy(out, function (item) { return item.pageUrl; });
    }

    function cleanHdmovieSynopsis(block, fallback) {
        var regex = /<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var match;
        var candidates = [];
        while ((match = regex.exec(String(block || ""))) !== null) {
            var text = stripTags(match[1]);
            if (!text || text.length < 25) continue;
            if (/(?:1080p|720p|480p|2160p|gdflix|gdtot|filepress|use vpn|signup|please use vpn)/i.test(text)) continue;
            candidates.push(text);
        }
        return candidates.length ? candidates[0] : trim(fallback || "");
    }

    function parseHdmovieDetails(html, pageUrl, payload) {
        var title = stripTags(firstMatch(html, [
            /<div class=["']sheader["'][\s\S]*?<h1>([\s\S]*?)<\/h1>/i,
            /<title>([^<]+?)\s*-\s*Hdmovie2/i
        ])) || trim(payload && payload.title || "");
        var originalTitle = stripTags(firstMatch(html, [
            /<b class=["']variante["']>\s*Original title\s*<\/b>\s*<span class=["']valor["']>([\s\S]*?)<\/span>/i
        ])) || trim(payload && payload.originalTitle || title);
        var posterUrl = normalizeResolvedUrl(firstMatch(html, [
            /<div class=["']poster["']>\s*<img[^>]*src=["']([^"']+)["']/i,
            /<meta property=['"]og:image['"] content=['"]([^'"]+)['"]/i
        ]), pageUrl);
        var bannerUrl = normalizeResolvedUrl(firstMatch(html, [
            /<img class=['"]cover['"] src=['"]([^'"]+)['"]/i,
            /<meta property=['"]og:image['"] content=['"]([^'"]+)['"]/i
        ]), pageUrl) || posterUrl;
        var metaDescription = decodeHtml(firstMatch(html, [/<meta name=["']description["'] content=["']([^"']+)["']/i]));
        var synopsisBlock = firstRawMatch(html, [/<div itemprop=["']description["'] class=["']wp-content["']>([\s\S]*?)<\/div>\s*<div class=["']custom_fields["']/i]);
        var description = cleanHdmovieSynopsis(synopsisBlock, metaDescription);
        var year = yearFromText(title + " " + stripTags(firstMatch(html, [
            /<span class=['"]date['"][^>]*>([^<]+)<\/span>/i,
            /<meta itemprop=['"]dateCreated['"] content=['"]([^'"]+)['"]/i
        ]))) || Number(payload && payload.year) || 0;
        return {
            title: title,
            originalTitle: originalTitle,
            pageUrl: pageUrl,
            posterUrl: posterUrl,
            bannerUrl: bannerUrl,
            description: description,
            year: year,
            type: "movie"
        };
    }

    async function getSitePage(url) {
        return getText(url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true);
    }

    async function fetchHdmovieHomeSection(mainUrl, section) {
        var path = typeof section.path === "function" ? section.path() : section.path;
        var url = absoluteUrl(mainUrl + "/", String(path || "").replace(/^\/+/, ""));
        var html = await getText(url, commonHeaders({ "Referer": mainUrl + "/" }), true);
        return {
            title: section.title,
            items: uniqueBy(parseHdmovieArchiveItems(html, mainUrl), function (item) {
                return item.pageUrl || item.url;
            }).map(buildSiteCard)
        };
    }

    async function getHome(cb) {
        try {
            var mainUrl = await getMainUrl();
            var data = {};
            var sections = await Promise.all(HDMOVIE2_HOME_SECTIONS.map(function (section) {
                return fetchHdmovieHomeSection(mainUrl, section).catch(function () {
                    return { title: section.title, items: [] };
                });
            }));
            for (var i = 0; i < sections.length; i++) {
                if (sections[i].items && sections[i].items.length) {
                    data[sections[i].title] = sections[i].items;
                }
            }
            if (!Object.keys(data).length) {
                var html = await getText(mainUrl + "/", commonHeaders({ "Referer": mainUrl + "/" }), true);
                var featured = parseHdmovieFeatured(html, mainUrl).map(buildSiteCard);
                var latest = parseHdmovieLatest(html, mainUrl).map(buildSiteCard);
                var popular = parseHdmoviePopular(html, mainUrl).map(buildSiteCard);
                if (featured.length) data["Featured"] = featured;
                if (latest.length) data["Latest"] = latest;
                if (popular.length) data["Popular"] = popular;
            }
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var mainUrl = await getMainUrl();
            var html = await getText(mainUrl + "/?s=" + encodeURIComponent(query), commonHeaders({ "Referer": mainUrl + "/" }), true);
            cb({ success: true, data: parseHdmovieSearchResults(html, mainUrl).map(buildSiteCard) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var payload = parsePayload(url);
            var pageUrl = trim(payload.pageUrl || payload.url || "");
            if (!pageUrl) throw new Error("Missing page URL");
            var html = await getSitePage(pageUrl);
            var details = parseHdmovieDetails(html, pageUrl, payload);
            cb({
                success: true,
                data: new MultimediaItem({
                    title: details.title,
                    url: buildSitePayload(details),
                    posterUrl: details.posterUrl,
                    bannerUrl: details.bannerUrl,
                    description: details.description,
                    year: details.year,
                    type: "movie",
                    episodes: [new Episode({
                        name: "Movie",
                        url: buildSitePayload(details),
                        season: 0,
                        episode: 0,
                        posterUrl: details.posterUrl,
                        description: details.description
                    })]
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    function parseWpArticleCard(block, base) {
        var href = firstMatch(block, [
            /<h2\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*post-image[^"']*["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*>/i
        ]);
        if (!href) return null;
        var rawTitle = stripTags(firstMatch(block, [
            /<h2\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /\btitle=["']([^"']+)["']/i,
            /<img\b[^>]*alt=["']([^"']+)["']/i
        ]));
        if (!rawTitle) return null;
        return {
            title: trim(rawTitle.split(" |")[0]),
            year: Number(firstMatch(rawTitle, [/\((\d{4})\)/])) || undefined,
            type: /season|series|tv/i.test(rawTitle) ? "series" : "movie",
            url: absoluteUrl(base, href)
        };
    }

    function parseWpArticleResults(html, base) {
        return extractBlocks(html, "article").map(function (block) {
            return parseWpArticleCard(block, base);
        }).filter(Boolean);
    }

    function normalizeResolvedUrl(rawValue, base) {
        var value = String(rawValue || "");
        if (!value) return "";
        value = decodeHtml(value)
            .replace(/\\\//g, "/")
            .replace(/^["'`(]+/, "")
            .replace(/["'`),;]+$/, "");
        if (/^\/\//.test(value)) value = "https:" + value;
        if (/^www\./i.test(value)) value = "https://" + value;
        if (!/^https?:\/\//i.test(value) && base) value = absoluteUrl(base, value);
        return value;
    }

    function isCommonDirectMediaUrl(url) {
        var value = String(url || "");
        return /\.(?:m3u8|mp4|mkv|webm|avi|mpd)(?:[?#].*)?$/i.test(value)
            || /hdm2\.ink\/playlist\//i.test(value);
    }

    function buildResolvedStream(url, source, quality, headers) {
        return {
            url: url,
            source: source || "HDMovie2",
            quality: quality || qualityFromText(url),
            headers: headers || {}
        };
    }

    function extractInterestingUrls(html, base) {
        var out = [];
        var regex = /(?:href|src)=["']([^"']+)["']/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var value = normalizeResolvedUrl(match[1], base);
            if (!value) continue;
            out.push(value);
        }
        return uniqueBy(out, function (item) { return item; });
    }

    async function resolveHdm2Play(url, label) {
        var headers = commonHeaders({ "Referer": baseOrigin(url) + "/" });
        var html = await getText(url, headers, true).catch(function () { return ""; });
        if (!html) return [];
        var streamPath = normalizeResolvedUrl(firstMatch(html, [/data-stream-url=["']([^"']+)["']/i]), baseOrigin(url));
        if (!streamPath) return [];
        var title = decodeHtml(firstMatch(html, [/data-player-title=["']([^"']+)["']/i])) || label || "HDMovie2";
        return [buildResolvedStream(streamPath, label || "HDMovie2", qualityFromText(title), commonHeaders({
            "Referer": url,
            "Origin": baseOrigin(url)
        }))];
    }

    async function resolveGenericPage(url, label, depth) {
        if (depth > 3) return [];
        var res = await request(url, { headers: commonHeaders({ "Referer": baseOrigin(url) + "/" }), allowRedirects: true }).catch(function () { return null; });
        var finalUrl = res && res.finalUrl || url;
        var html = res ? String(res.body || "") : "";
        var candidates = extractInterestingUrls(html, baseOrigin(finalUrl)).filter(function (item) {
            return item && item !== url;
        });
        var out = [];
        for (var i = 0; i < candidates.length; i++) {
            out = out.concat(await resolveCommonExtractorUrl(candidates[i], label, depth + 1));
        }
        return out;
    }

    async function resolveCommonExtractorUrl(url, label, depth) {
        var normalized = normalizeResolvedUrl(url, "");
        if (!normalized) return [];
        if (isCommonDirectMediaUrl(normalized)) {
            return [buildResolvedStream(normalized, label || "HDMovie2", qualityFromText(normalized), commonHeaders())];
        }
        if (/hdm2\.ink\/play/i.test(normalized)) return resolveHdm2Play(normalized, label || "HDMovie2");
        return resolveGenericPage(normalized, label || "HDMovie2", depth || 0);
    }

    async function getMainUrl() {
        return getDynamicDomain("hdmovie2", "https://hdmovie2.restaurant");
    }

    async function searchTitles(queries) {
        var mainUrl = await getMainUrl();
        for (var i = 0; i < queries.length; i++) {
            var query = trim(queries[i]);
            if (!query) continue;
            try {
                var html = await getText(mainUrl + "/?s=" + encodeURIComponent(query), commonHeaders({ "Referer": mainUrl + "/" }), true);
                var results = parseHdmovieSearchResults(html, mainUrl);
                if (results.length) return results;
            } catch (_) {}
        }
        return [];
    }

    function parsePlayerOptions(html) {
        var out = [];
        var regex = /<li\b[^>]*class=["'][^"']*dooplay_player_option[^"']*["'][^>]*data-(?:type|post|nume)=["'][^"']+["'][^>]*>/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var start = match.index;
            var end = html.indexOf("</li>", start);
            if (end === -1) continue;
            var block = html.slice(start, end + 5);
            var nume = firstMatch(block, [/data-nume=["']([^"']+)["']/i]);
            var postId = firstMatch(block, [/data-post=["']([^"']+)["']/i]);
            var type = firstMatch(block, [/data-type=["']([^"']+)["']/i]);
            var title = stripTags(firstMatch(block, [/<span[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/span>/i]));
            if (!nume || !postId || !type || /trailer/i.test(nume)) continue;
            out.push({ nume: nume, postId: postId, type: type, title: title || ("Server " + nume) });
        }
        return uniqueBy(out, function (item) { return item.nume; });
    }

    function dedupeStreams(list) {
        return uniqueBy((list || []).filter(function (item) { return item && item.url; }), function (item) {
            return item.url + "|" + JSON.stringify(item.headers || {});
        });
    }

    function sortStreams(list) {
        return list.slice().sort(function (a, b) { return Number(b.quality || 0) - Number(a.quality || 0); });
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parsePayload(url);
            var pageUrl = trim(payload.pageUrl || payload.url || "");
            var match = pageUrl ? { url: pageUrl, title: payload.title || "" } : null;
            if (!match) {
                var queries = uniqueBy([payload.title, payload.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
                var rows = await searchTitles(queries);
                match = bestMatch(rows, queries, payload.year, "movie");
            }
            if (!match || !match.url) return cb({ success: true, data: [] });
            var pageHtml = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            if (!pageHtml) return cb({ success: true, data: [] });

            var options = parsePlayerOptions(pageHtml);
            var streams = [];
            for (var i = 0; i < options.length; i++) {
                var form = "action=doo_player_ajax&post=" + encodeURIComponent(options[i].postId)
                    + "&nume=" + encodeURIComponent(options[i].nume)
                    + "&type=" + encodeURIComponent(options[i].type);
                var res = await request((await getMainUrl()) + "/wp-admin/admin-ajax.php", {
                    method: "POST",
                    body: form,
                    headers: commonHeaders({
                        "Referer": match.url,
                        "Origin": await getMainUrl(),
                        "X-Requested-With": "XMLHttpRequest",
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                    })
                }).catch(function () { return null; });
                var json = res ? parseJsonSafe(res.body, {}) : {};
                var embedUrl = normalizeResolvedUrl(firstMatch(String(json && json.embed_url || ""), [/<iframe[^>]+src=["']([^"']+)["']/i]), match.url);
                if (!embedUrl) continue;
                var resolved = await resolveCommonExtractorUrl(embedUrl, "HDMovie2", 0);
                for (var j = 0; j < resolved.length; j++) {
                    if (!resolved[j].quality) resolved[j].quality = qualityFromText(options[i].title || payload.title || match.title);
                    streams.push(resolved[j]);
                }
            }
            cb({ success: true, data: sortStreams(dedupeStreams(streams)).map(function (item) { return new StreamResult(item); }) });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
