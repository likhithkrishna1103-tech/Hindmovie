(function () {
    var hostFetch = null;
    try {
        if (typeof fetch === "function") {
            hostFetch = fetch;
        } else {
            hostFetch = (() => {}).constructor("return fetch")();
        }
    } catch (_) {}

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
                if (typeof http_post === "function") {
                    await http_post(
                        'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                        { 'Content-Type': 'application/json' },
                        JSON.stringify({ client_id: this.clientId, events: events })
                    );
                }
            } catch (e) { console.log('[Analytics] Send skipped'); }
        }
    };
    Analytics.init();

    "use strict";

    var DEFAULT_BASE_URL = "https://hdmovie2a.icu";
    var DOMAINS_JSON_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    var TMDB_WORKER_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_FALLBACK_API = "https://api.themoviedb.org/3";
    var TMDB_IMAGE_BASE = "https://image.tmdb.org/t/p/original";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";

    var domainsCache = null;
    var cachedBaseUrl = null;
    var cachedBaseUrlTime = 0;
    var CACHE_TTL = 300000;

    var HDMOVIE2_HOME_SECTIONS = [
        { path: function () { return "release/" + new Date().getFullYear(); }, title: "Trending" },
        { path: "movies", title: "Movies" },
        { path: "genre/bollywood", title: "BollyWood" },
        { path: "genre/hindi-webseries", title: "Hindi Web Series" },
        { path: "genre/netflix", title: "Netflix" },
        { path: "genre/zee5", title: "Zee5" },
        { path: "genre/hindi-dubbed", title: "Hindi Dubbed" },
        { path: "genre/comedy", title: "Comedy" },
        { path: "genre/science-fiction", title: "Science Fiction" }
    ];

    function toErrorMessage(error) {
        return String(error && (error.stack || error.message) || error);
    }

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

    function defaultHeaders(extra) {
        return Object.assign({
            "User-Agent": COMMON_USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
        }, extra || {});
    }

    function requestWithFetch(url, method, headers, body, allowRedirects) {
        return hostFetch(url, {
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

    function normalizeExtractorDomain(url) {
        var str = String(url || "");
        str = str.replace(/^https?:\/\/(?:www\.)?(?:gdflix\.dev|new\.gdflix\.dad|new2\.gdflix\.\w+|new\d*\.gdflix\.\w+)/i, "https://new3.gdflix.io");
        str = str.replace(/^https?:\/\/(?:www\.)?new\d*\.filepress\.\w+/i, "https://new3.filepress.baby");
        return str;
    }

    function request(url, options) {
        options = options || {};
        var normalizedUrl = normalizeExtractorDomain(url);
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || defaultHeaders();
        var body = options.body;
        var allowRedirects = options.allowRedirects !== false;

        if (hostFetch) {
            return requestWithFetch(normalizedUrl, method, headers, body, allowRedirects).catch(function (err) {
                if (method === "GET" && typeof http_get === "function") {
                    return Promise.resolve(http_get(normalizedUrl, headers)).then(function (res) {
                        return {
                            status: responseStatus(res) || 200,
                            body: res && typeof res.body !== "undefined" ? res.body : "",
                            headers: parseHeaders(res && res.headers),
                            finalUrl: (res && (res.url || res.finalUrl)) || normalizedUrl
                        };
                    });
                }
                throw err;
            });
        }

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(normalizedUrl, headers)).then(function (res) {
                return {
                    status: responseStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || normalizedUrl
                };
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            return Promise.resolve(http_post(normalizedUrl, headers, body)).then(function (res) {
                return {
                    status: responseStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || normalizedUrl
                };
            });
        }

        throw new Error("No HTTP client available");
    }

    function getText(url, headers, allowRedirects) {
        return request(url, { headers: headers || defaultHeaders(), allowRedirects: allowRedirects }).then(function (res) {
            if (res.status >= 400 && res.status !== 404) throw new Error("GET failed (" + res.status + "): " + url);
            return String(res.body || "");
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers || defaultHeaders({ "Accept": "application/json" }) }).then(function (res) {
            if (res.status >= 400) throw new Error("GET JSON failed (" + res.status + "): " + url);
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
            if (match) return match[1] ? String(match[1]) : String(match[0]);
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
        if (/\b1440p\b|\bqhd\b/.test(value)) return 1440;
        if (/\b1080p\b|\bfullhd\b/.test(value)) return 1080;
        if (/\b720p\b|\bhd\b/.test(value)) return 720;
        if (/\b576p\b/.test(value)) return 576;
        if (/\b480p\b|\bsd\b/.test(value)) return 480;
        if (/\b360p\b/.test(value)) return 360;
        return 0;
    }

    function getSearchQuality(text) {
        var lower = String(text || "").toLowerCase();
        if (/\b(4k|ds4k|uhd|2160p)\b/.test(lower)) return "4K";
        if (/\b(hdts|hdcam|hdtc)\b/.test(lower)) return "HD Cam";
        if (/\b(camrip|cam-rip|cam)\b/.test(lower)) return "Cam";
        if (/\b(web-dl|webrip|webdl)\b/.test(lower)) return "WebRip";
        if (/\b(bluray|bdrip|blu-ray)\b/.test(lower)) return "BluRay";
        if (/\b(1080p|fullhd|hdrip|hdtv|hd)\b/.test(lower)) return "HD";
        if (/\b720p\b/.test(lower)) return "SD";
        if (/\bdvd\b/.test(lower)) return "DVD";
        if (/\bhq\b/.test(lower)) return "HQ";
        return "HD";
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

    function cleanTmdbTitle(title) {
        return trim(String(title || "")
            .replace(/\(\d{4}\)/g, "")
            .replace(/\b(Hindi|English|Tamil|Telugu|Kannada|Malayalam|Dubbed|HQ Dubbed|HQ|Dual Audio|Season\s*\d+|Complete|AMZN|Netflix|Zee5|Hotstar|JioCinema|HD|CAMRip|HDTC|CAM|Pre DVD|V2|V3|V4|Multi)\b/gi, "")
            .replace(/\s{2,}/g, " "));
    }

    async function getMainUrl() {
        var now = Date.now();
        if (cachedBaseUrl && (now - cachedBaseUrlTime < CACHE_TTL)) {
            return cachedBaseUrl;
        }
        var resolved = (typeof manifest !== "undefined" && manifest && manifest.baseUrl) ? manifest.baseUrl : DEFAULT_BASE_URL;
        try {
            if (!domainsCache) {
                domainsCache = await getJson(DOMAINS_JSON_URL, defaultHeaders());
            }
            if (domainsCache && domainsCache.hdmovie2) {
                resolved = domainsCache.hdmovie2;
            }
        } catch (_) {}
        cachedBaseUrl = trim(resolved).replace(/\/+$/g, "");
        cachedBaseUrlTime = now;
        return cachedBaseUrl;
    }

    function getProperLink(uri, mainUrl) {
        if (!uri) return "";
        if (uri.indexOf("/episodes/") !== -1) {
            var title = uri.split("/episodes/")[1] || "";
            var match = title.match(/(.+?)-season-\d+-episode-\d+/i);
            var titleSlug = match ? match[1] : title.replace(/\/+$/, "");
            return (mainUrl || DEFAULT_BASE_URL) + "/tvshows/" + titleSlug;
        }
        if (uri.indexOf("/seasons/") !== -1) {
            var title2 = uri.split("/seasons/")[1] || "";
            var match2 = title2.match(/(.+?)-season/i);
            var titleSlug2 = match2 ? match2[1] : title2.replace(/\/+$/, "");
            return (mainUrl || DEFAULT_BASE_URL) + "/tvshows/" + titleSlug2;
        }
        return uri;
    }

    function parseImageAttr(imgHtml) {
        if (!imgHtml) return "";
        var dataSrc = firstMatch(imgHtml, [
            /\bdata-src=["']([^"']+)["']/i,
            /\bdata-wpfc-original-src=["']([^"']+)["']/i,
            /\bdata-lazy-src=["']([^"']+)["']/i,
            /\bdata-original=["']([^"']+)["']/i,
            /\bsrc=["']([^"']+)["']/i
        ]);
        if (dataSrc && dataSrc.indexOf(".gif") === -1 && !dataSrc.startsWith("data:image")) return dataSrc;
        var src = firstMatch(imgHtml, [/\bsrc=["']([^"']+)["']/i]);
        if (src && src.indexOf(".gif") === -1 && !src.startsWith("data:image")) return src;
        return dataSrc || src || "";
    }

    function parseArticleItem(block, base) {
        var linkTag = firstRawMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/i,
            /<h2\b[^>]*class=["'][^"']*result-title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/i,
            /<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*>/i
        ]);
        var href = firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<h2\b[^>]*class=["'][^"']*result-title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<a\b[^>]*href=["']([^"']+)["']/i
        ]);
        var rawTitle = stripTags(firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<h2\b[^>]*class=["'][^"']*result-title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<img\b[^>]*alt=["']([^"']+)["']/i
        ]));
        if (!href || !rawTitle) return null;

        var cleanTitle = trim(rawTitle.replace(/\(\d{4}\)/g, "")).split(" |")[0];
        var properHref = getProperLink(absoluteUrl(base, href), base);
        var imgHtml = firstRawMatch(block, [
            /<div\b[^>]*class=["'][^"']*poster[^"']*["'][\s\S]*?<img\b[^>]*>/i,
            /<img\b[^>]*>/i
        ]);
        var posterUrl = parseImageAttr(imgHtml);
        if (posterUrl) posterUrl = absoluteUrl(base, posterUrl);

        var qualityStr = stripTags(firstMatch(block, [/<span\b[^>]*class=["'][^"']*quality[^"']*["'][^>]*>([\s\S]*?)<\/span>/i]));
        var ratingStr = stripTags(firstMatch(block, [/<div\b[^>]*class=["'][^"']*rating[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]));
        var score = ratingStr ? parseFloat(ratingStr) : undefined;
        if (isNaN(score)) score = undefined;

        var typeStr = stripTags(firstMatch(block, [/<span\b[^>]*class=["'][^"']*result-type[^"']*["'][^>]*>([\s\S]*?)<\/span>/i]));
        var isTv = /series|tvshows|tv|season|episode/i.test(typeStr + " " + href + " " + rawTitle);
        var type = isTv ? "series" : "movie";

        var yearMatch = rawTitle.match(/\b((?:19|20)\d{2})\b/) || block.match(/\b((?:19|20)\d{2})\b/);
        var year = yearMatch ? parseInt(yearMatch[1] || yearMatch[0], 10) : undefined;
        if (isNaN(year) || year < 1900 || year > 2100) year = undefined;

        return new MultimediaItem({
            title: cleanTitle,
            url: properHref,
            posterUrl: posterUrl || undefined,
            type: type,
            year: year,
            score: score,
            quality: getSearchQuality(qualityStr || rawTitle),
            headers: { "Referer": base + "/" }
        });
    }

    function parseArticles(html, base) {
        var blocks = extractBlocks(html, "article");
        var items = [];
        for (var i = 0; i < blocks.length; i++) {
            var item = parseArticleItem(blocks[i], base);
            if (item && item.url) items.push(item);
        }
        return uniqueBy(items, function (it) { return it.url; });
    }

    async function getHome(cb) {
        try {
            var mainUrl = await getMainUrl();
            var results = {};

            var sectionPromises = HDMOVIE2_HOME_SECTIONS.map(async function (section) {
                var sectionPath = typeof section.path === "function" ? section.path() : section.path;
                var url = mainUrl + "/" + String(sectionPath || "").replace(/^\/+/, "") + "/";
                try {
                    var html = await getText(url, defaultHeaders({ "Referer": mainUrl + "/" }));
                    var items = parseArticles(html, mainUrl);
                    return { title: section.title, items: items };
                } catch (e) {
                    return { title: section.title, items: [] };
                }
            });

            var sections = await Promise.all(sectionPromises);
            for (var i = 0; i < sections.length; i++) {
                if (sections[i].items && sections[i].items.length) {
                    results[sections[i].title] = sections[i].items;
                }
            }

            // Fallback to home page if all sections empty
            if (!Object.keys(results).length) {
                var homeHtml = await getText(mainUrl + "/", defaultHeaders({ "Referer": mainUrl + "/" }));
                var allItems = parseArticles(homeHtml, mainUrl);
                if (allItems.length) {
                    results["Trending"] = allItems.slice(0, 20);
                    results["Latest"] = allItems.slice(20);
                }
            }

            // Enrich Trending items with TMDB metadata (banner, logo, genres, score) for carousel
            if (results["Trending"] && results["Trending"].length) {
                try {
                    var enrichCount = Math.min(results["Trending"].length, 10);
                    var enrichPromises = [];
                    for (var t = 0; t < enrichCount; t++) {
                        var it = results["Trending"][t];
                        var tmdbType = it.type === "series" ? "tv" : "movie";
                        var cleanQ = cleanTmdbTitle(it.title);
                        var tmdbSearchUrl = TMDB_WORKER_API + "/search/" + tmdbType + "?api_key=" + TMDB_API_KEY + "&query=" + encodeURIComponent(cleanQ) + (it.year ? "&year=" + it.year : "");
                        enrichPromises.push(getJson(tmdbSearchUrl).catch(function () { return {}; }));
                    }
                    var tmdbResults = await Promise.all(enrichPromises);
                    for (var e = 0; e < tmdbResults.length; e++) {
                        var tmdbJson = tmdbResults[e];
                        if (tmdbJson && tmdbJson.results && tmdbJson.results[0]) {
                            var best = tmdbJson.results[0];
                            if (best.backdrop_path) {
                                results["Trending"][e].bannerUrl = TMDB_IMAGE_BASE + best.backdrop_path;
                            }
                            if (best.poster_path && !results["Trending"][e].posterUrl) {
                                results["Trending"][e].posterUrl = TMDB_IMAGE_BASE + best.poster_path;
                            }
                            if (best.vote_average && !results["Trending"][e].score) {
                                results["Trending"][e].score = Number(best.vote_average.toFixed(1));
                            }
                        }
                    }
                } catch (_) {}
            }

            Analytics.logEvent('hdmovie2_home', {});
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: toErrorMessage(error) });
        }
    }

    async function search(query, cb) {
        try {
            var mainUrl = await getMainUrl();
            var q = encodeURIComponent(trim(query));
            var searchUrls = [
                mainUrl + "/?s=" + q,
                mainUrl + "/search/" + q + "/"
            ];
            var items = [];
            for (var i = 0; i < searchUrls.length; i++) {
                try {
                    var html = await getText(searchUrls[i], defaultHeaders({ "Referer": mainUrl + "/" }));
                    var parsed = parseArticles(html, mainUrl);
                    if (parsed.length) {
                        items = parsed;
                        break;
                    }
                } catch (err) {
            console.log("extractGdflixStreams exception:", err && err.message);
        }
            }

            Analytics.logEvent('hdmovie2_search', {});
            cb({ success: true, data: items });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: toErrorMessage(error) });
        }
    }

    function cleanSynopsis(block, fallback) {
        var regex = /<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var match;
        var candidates = [];
        while ((match = regex.exec(String(block || ""))) !== null) {
            var text = stripTags(match[1]);
            if (!text || text.length < 20) continue;
            if (/(?:1080p|720p|480p|2160p|gdflix|gdtot|filepress|use vpn|signup|telegram)/i.test(text)) continue;
            candidates.push(text);
        }
        return candidates.length ? candidates[0] : trim(fallback || "");
    }

    async function load(url, cb) {
        try {
            var mainUrl = await getMainUrl();
            var pageUrl = String(url || "");
            if (pageUrl.startsWith("{")) {
                var parsedPayload = parseJsonSafe(pageUrl, null);
                if (parsedPayload && (parsedPayload.url || parsedPayload.sourceUrl)) {
                    pageUrl = parsedPayload.url || parsedPayload.sourceUrl;
                }
            }

            var html = await getText(pageUrl, defaultHeaders({ "Referer": mainUrl + "/" }));
            var title = stripTags(firstMatch(html, [
                /<div\b[^>]*class=["'][^"']*data[^"']*["'][\s\S]*?<h1\b[^>]*>([\s\S]*?)<\/h1>/i,
                /<h1\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i,
                /<h1\b[^>]*>([\s\S]*?)<\/h1>/i,
                /<title>([^<]+?)\s*-\s*Hdmovie2/i
            ]));
            title = trim(title.replace(/\(\d{4}\)/g, "")).split(" |")[0];

            var posterImgHtml = firstRawMatch(html, [/<div\b[^>]*class=["'][^"']*poster[^"']*["'][\s\S]*?<img\b[^>]*>/i, /<img\b[^>]*>/i]);
            var posterUrl = parseImageAttr(posterImgHtml);
            if (posterUrl) posterUrl = absoluteUrl(mainUrl, posterUrl);

            var coverImgHtml = firstRawMatch(html, [
                /<div\b[^>]*class=["'][^"']*(?:playbox|dooplay-player)[^"']*["'][\s\S]*?<img\b[^>]*class=["'][^"']*cover[^"']*["'][^>]*>/i,
                /<img\b[^>]*class=["'][^"']*cover[^"']*["'][^>]*>/i
            ]);
            var bannerUrl = parseImageAttr(coverImgHtml);
            if (bannerUrl) bannerUrl = absoluteUrl(mainUrl, bannerUrl);
            else bannerUrl = posterUrl;

            var genres = [];
            var genreRegex = /<div\b[^>]*class=["'][^"']*sgeneros[^"']*["'][\s\S]*?<\/div>/i;
            var genreBlock = firstRawMatch(html, [genreRegex]);
            if (genreBlock) {
                var gMatches = [...genreBlock.matchAll(/<a\b[^>]*>([\s\S]*?)<\/a>/gi)];
                genres = gMatches.map(function (m) { return stripTags(m[1]); }).filter(Boolean);
            }

            var yearMatch = firstMatch(html, [/<span\b[^>]*class=["']date["'][^>]*>([\s\S]*?)<\/span>/i]).match(/,\s*((?:19|20)\d{2})/)
                || title.match(/\b((?:19|20)\d{2})\b/)
                || html.match(/\b((?:19|20)\d{2})\b/);
            var year = yearMatch ? parseInt(yearMatch[1] || yearMatch[0], 10) : undefined;
            if (isNaN(year) || year < 1900 || year > 2100) year = undefined;

            var descriptionBlock = firstRawMatch(html, [/<div\b[^>]*class=["'][^"']*wp-content[^"']*["']>([\s\S]*?)<\/div>/i]);
            var metaDesc = decodeHtml(firstMatch(html, [/<meta\b[^>]*name=["']description["'][^>]*content=["']([^"']+)["']/i]));
            var description = cleanSynopsis(descriptionBlock, metaDesc);

            var trailerIframe = firstMatch(html, [/<div\b[^>]*class=["'][^"']*embed[^"']*["'][\s\S]*?<iframe\b[^>]*src=["']([^"']+)["']/i]);
            var trailerUrl = trailerIframe ? absoluteUrl(mainUrl, trailerIframe) : undefined;

            var ratingStr = stripTags(firstMatch(html, [/<span\b[^>]*class=["']dt_rating_vgs["'][^>]*>([\s\S]*?)<\/span>/i]));
            var score = ratingStr ? parseFloat(ratingStr) : undefined;
            if (isNaN(score)) score = undefined;

            var cast = [];
            var actorBlocks = [...html.matchAll(/<div\b[^>]*itemprop=["']actor["'][^>]*>([\s\S]*?)<\/div>/gi)];
            for (var a = 0; a < actorBlocks.length; a++) {
                var aBlock = actorBlocks[a][1];
                var actorName = decodeHtml(firstMatch(aBlock, [/<meta\b[^>]*itemprop=["']name["'][^>]*content=["']([^"']+)["']/i, /<img\b[^>]*alt=["']([^"']+)["']/i]));
                var actorImg = parseImageAttr(aBlock);
                if (actorName) {
                    cast.push(new Actor({ name: actorName, image: actorImg ? absoluteUrl(mainUrl, actorImg) : undefined }));
                }
            }

            var recommendations = [];
            var recBlocks = [...html.matchAll(/<div\b[^>]*class=["'][^"']*owl-item[^"']*["'][\s\S]*?<article\b[^>]*>([\s\S]*?)<\/article>/gi)];
            for (var r = 0; r < recBlocks.length; r++) {
                var recItem = parseArticleItem(recBlocks[r][1], mainUrl);
                if (recItem && recItem.url) recommendations.push(recItem);
            }

            var isTv = /Episodes/i.test(firstMatch(html, [/<ul\b[^>]*id=["']section["'][\s\S]*?<li\b[^>]*:first-child>([\s\S]*?)<\/li>/i]))
                || /\b(?:Episode\s*\d+|EP\s*\d+|S\d+E\d+)\b/i.test(html)
                || /tvshows|season/i.test(pageUrl);
            var type = isTv ? "series" : "movie";

            // Download Links: Look for all download links across the page and deduplicate
            var downloadLinks = [];
            var dlAnchors = [...html.matchAll(/<a\b[^>]*href=["'](https?:\/\/(?:hdm\.im|[^\/]*gdflix|[^\/]*gdtot|[^\/]*filepress|[^\/]*filebee|[^\/]*hubcloud)[^"']*)["'][^>]*>([\s\S]*?)<\/a>/gi)];
            for (var d = 0; d < dlAnchors.length; d++) {
                var dHref = absoluteUrl(mainUrl, dlAnchors[d][1]);
                var dLabel = stripTags(dlAnchors[d][2]);
                if (dHref && !downloadLinks.some(function (x) { return x.href === dHref; })) {
                    downloadLinks.push({ href: dHref, label: dLabel });
                }
            }

            // Enrich load with TMDB details (backdrop, poster, logo, score)
            try {
                var cleanLoadTitle = cleanTmdbTitle(title);
                var tmdbType = type === "series" ? "tv" : "movie";
                var searchRes = await getJson(TMDB_WORKER_API + "/search/" + tmdbType + "?api_key=" + TMDB_API_KEY + "&query=" + encodeURIComponent(cleanLoadTitle) + (year ? "&year=" + year : ""));
                if (searchRes && searchRes.results && searchRes.results[0]) {
                    var tmdbItem = searchRes.results[0];
                    if (tmdbItem.backdrop_path && (!bannerUrl || bannerUrl === posterUrl)) {
                        bannerUrl = TMDB_IMAGE_BASE + tmdbItem.backdrop_path;
                    }
                    if (tmdbItem.poster_path && !posterUrl) {
                        posterUrl = TMDB_IMAGE_BASE + tmdbItem.poster_path;
                    }
                    if (tmdbItem.vote_average && !score) {
                        score = Number(tmdbItem.vote_average.toFixed(1));
                    }
                }
            } catch (_) {}

            // DooPlay player ajax options (post, nume, type)
            var playerOptions = [];
            var optLiMatches = [...html.matchAll(/<li\b[^>]*class=["'][^"']*dooplay_player_option[^"']*["'][^>]*data-type=["']([^"']*)["'][^>]*data-post=["']([^"']*)["'][^>]*data-nume=["']([^"']*)["'][^>]*>([\s\S]*?)<\/li>/gi)];
            if (!optLiMatches.length) {
                optLiMatches = [...html.matchAll(/<li\b[^>]*data-type=["']([^"']*)["'][^>]*data-post=["']([^"']*)["'][^>]*data-nume=["']([^"']*)["'][^>]*>([\s\S]*?)<\/li>/gi)];
            }
            for (var o = 0; o < optLiMatches.length; o++) {
                var oType = optLiMatches[o][1];
                var oPost = optLiMatches[o][2];
                var oNume = optLiMatches[o][3];
                var oTitle = stripTags(firstMatch(optLiMatches[o][4], [/<span\b[^>]*class=["']title["'][^>]*>([\s\S]*?)<\/span>/i]));
                if (oNume && !/trailer/i.test(oNume)) {
                    playerOptions.push({ type: oType, post: oPost, nume: oNume, title: oTitle || ("Server " + oNume) });
                }
            }

            // Parse episodes
            var episodes = [];
            var episodeLiMatches = [...html.matchAll(/<ul\b[^>]*class=["'][^"']*episodios[^"']*["'][\s\S]*?<li\b[^>]*>([\s\S]*?)<\/li>/gi)];
            if (episodeLiMatches.length && isTv) {
                for (var ep = 0; ep < episodeLiMatches.length; ep++) {
                    var epBlock = episodeLiMatches[ep][1];
                    var epHref = absoluteUrl(mainUrl, firstMatch(epBlock, [/<a\b[^>]*href=["']([^"']+)["']/i]));
                    var epName = stripTags(firstMatch(epBlock, [/<div\b[^>]*class=["']episodiotitle["'][\s\S]*?<a\b[^>]*>([\s\S]*?)<\/a>/i])) || ("Episode " + (ep + 1));
                    var epNumText = stripTags(firstMatch(epBlock, [/<div\b[^>]*class=["']numerando["'][^>]*>([\s\S]*?)<\/div>/i])).replace(/\s+/g, "");
                    var epParts = epNumText.split("-");
                    var seasonNum = epParts.length > 1 ? (parseInt(epParts[0], 10) || 1) : 1;
                    var epNum = epParts.length > 1 ? (parseInt(epParts[1], 10) || (ep + 1)) : (parseInt(epParts[0], 10) || (ep + 1));
                    var epImg = parseImageAttr(epBlock);

                    episodes.push(new Episode({
                        name: epName,
                        season: seasonNum,
                        episode: epNum,
                        posterUrl: epImg ? absoluteUrl(mainUrl, epImg) : posterUrl,
                        url: JSON.stringify({
                            sourceUrl: epHref || pageUrl,
                            title: title,
                            season: seasonNum,
                            episode: epNum,
                            downloadLinks: downloadLinks,
                            playerOptions: playerOptions
                        }),
                        headers: { "Referer": mainUrl + "/" }
                    }));
                }
            }

            // Check for option-based episode list (e.g. Ultra Stream V3 EP01 ... EP14)
            if (!episodes.length) {
                var optionEpisodes = [...html.matchAll(/<li\b[^>]*class=["'][^"']*dooplay_player_option[^"']*["'][^>]*>([\s\S]*?)<\/li>/gi)];
                for (var oe = 0; oe < optionEpisodes.length; oe++) {
                    var oeBlock = optionEpisodes[oe][1];
                    var oeTitle = stripTags(firstMatch(oeBlock, [/<span\b[^>]*class=["']title["'][^>]*>([\s\S]*?)<\/span>/i]));
                    var oeSource = firstMatch(oeBlock, [/data-source=["']([^"']+)["']/i]);
                    var epMatch = oeTitle.match(/(?:EP|Episode|E)\s*0*(\d+)/i);
                    if (epMatch) {
                        var parsedEpNum = parseInt(epMatch[1], 10);
                        var relDl = downloadLinks.filter(function (dl) {
                            var rangeMatch = dl.label.match(/(?:EP|Episode|E)\s*0*(\d+)\s*-\s*0*(\d+)/i);
                            if (rangeMatch) {
                                var rStart = parseInt(rangeMatch[1], 10);
                                var rEnd = parseInt(rangeMatch[2], 10);
                                return parsedEpNum >= rStart && parsedEpNum <= rEnd;
                            }
                            return true;
                        });

                        episodes.push(new Episode({
                            name: oeTitle || ("Episode " + parsedEpNum),
                            season: 1,
                            episode: parsedEpNum,
                            posterUrl: posterUrl,
                            description: description,
                            url: JSON.stringify({
                                sourceUrl: oeSource || pageUrl,
                                title: title,
                                season: 1,
                                episode: parsedEpNum,
                                downloadLinks: relDl,
                                playerOptions: []
                            }),
                            headers: { "Referer": mainUrl + "/" }
                        }));
                    }
                }
            }

            // For movies or series without episodes list: return Movie Episode with season 1, episode 1
            if (!episodes.length) {
                episodes.push(new Episode({
                    name: isTv ? "Full Series" : "Full Movie",
                    season: 1,
                    episode: 1,
                    posterUrl: posterUrl,
                    description: description,
                    url: JSON.stringify({
                        sourceUrl: pageUrl,
                        title: title,
                        year: year,
                        type: type,
                        season: 1,
                        episode: 1,
                        downloadLinks: downloadLinks,
                        playerOptions: playerOptions
                    }),
                    headers: { "Referer": mainUrl + "/" }
                }));
            }

            Analytics.logEvent('hdmovie2_load', {});
            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: pageUrl,
                    posterUrl: posterUrl || undefined,
                    bannerUrl: bannerUrl || undefined,
                    type: type,
                    description: description || undefined,
                    year: year,
                    score: score,
                    genres: genres.length ? genres : undefined,
                    trailers: trailerUrl ? [new Trailer({ url: trailerUrl })] : undefined,
                    cast: cast.length ? cast : undefined,
                    recommendations: recommendations.length ? recommendations : undefined,
                    headers: { "Referer": mainUrl + "/" },
                    episodes: episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: toErrorMessage(error) });
        }
    }

    // -------------------------------------------------------------
    // Extractors: GDFlix, HubCloud, Filepress, PixelDrain, HDm2, Abyass
    // -------------------------------------------------------------

    // -------------------------------------------------------------
    // Extractors: CloudStream standard embed & stream extractors
    // -------------------------------------------------------------

    function unpackPacker(code) {
        if (!code) return "";
        try {
            if (typeof getAndUnpack === "function") {
                var res = getAndUnpack(code);
                if (res) return res;
            }
            var match = code.match(/eval\s*\(\s*function\s*\(\s*p\s*,\s*a\s*,\s*c\s*,\s*k\s*,\s*e\s*,\s*[rd]\s*\)[\s\S]*?\}\s*\(([\s\S]*?)\)\s*\)/);
            if (!match) return code;
            var args = match[1];
            var fn = new Function('return (function(p,a,c,k,e,d){while(c--)if(k[c])p=p.replace(new RegExp("\\\\b"+c.toString(a)+"\\\\b","g"),k[c]);return p;}(' + args + '))');
            return fn() || "";
        } catch (_) {
            return code;
        }
    }

    function isDirectMediaUrl(url) {
        var str = String(url || "");
        return /\.(m3u8|mp4|mkv|webm|avi)(?:[?#]|$)/i.test(str)
            || /busycdn\.xyz|r2\.dev|cloudfront\.net|pixeldrain\.dev\/api\/file|workers\.dev|awscdn\.rest|y5acuyojym|hdm2\.ink\/playlist/i.test(str);
    }

    // 1. Streamtape Extractor (streamtape.com, streamta.pe, streamtape.net, streamtape.to)
    async function extractStreamtape(url, sourceName) {
        var streams = [];
        try {
            var res = await getText(url, defaultHeaders({ "Referer": "https://streamtape.com/" }));
            var linkMatch = res.match(/document\.getElementById\(['"](?:robotlink|videolink)['"]\)\.innerHTML\s*=\s*['"]([^'"]+)['"]/i)
                || res.match(/(?:'|")(\/\/streamtape\.com\/get_video\?[^'"]+)(?:'|")/i)
                || res.match(/(?:'|")(https?:\/\/[^'"]*\.mp4(?:\?[^'"]*)?)(?:'|")/i);
            if (linkMatch && linkMatch[1]) {
                var streamUrl = linkMatch[1].indexOf("//") === 0 ? ("https:" + linkMatch[1]) : linkMatch[1];
                streams.push(new StreamResult({
                    url: streamUrl,
                    source: (sourceName || "Streamtape") + " [Direct]",
                    quality: qualityFromText(url) || 1080,
                    headers: defaultHeaders({ "Referer": "https://streamtape.com/" })
                }));
            }
        } catch (_) {}
        return streams;
    }

    // 2. Streamwish / VidHide / FileLions / WishFast Extractor
    async function extractStreamwish(url, sourceName) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }));
            var unpacked = unpackPacker(html) || html;
            var m3u8Match = unpacked.match(/https?:\/\/[^"'\s]+\.m3u8(?:[^"'\s]*)?/i)
                || unpacked.match(/file\s*:\s*["']([^"']+\.m3u8[^"']*)["']/i)
                || unpacked.match(/sources\s*:\s*\[\s*\{[^}]*file\s*:\s*["']([^"']+)["']/i);
            if (m3u8Match) {
                var m3u8Url = (m3u8Match[1] || m3u8Match[0]).replace(/&amp;/g, "&");
                streams.push(new StreamResult({
                    url: m3u8Url,
                    source: (sourceName || "Streamwish") + " [HLS]",
                    quality: qualityFromText(m3u8Url) || 1080,
                    headers: defaultHeaders({ "Referer": baseOrigin(url) + "/" })
                }));
            }
        } catch (_) {}
        return streams;
    }

    // 3. DoodStream / Dood Extractor (doodstream.com, dood.to, dood.so, dood.ws, ds2play.com)
    async function extractDoodStream(url, sourceName) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }));
            var md5Match = html.match(/\/pass_md5\/([^'"]*)/i);
            if (md5Match) {
                var passUrl = baseOrigin(url) + "/pass_md5/" + md5Match[1];
                var tokenRes = await getText(passUrl, defaultHeaders({ "Referer": url }));
                if (tokenRes && tokenRes.indexOf("http") === 0) {
                    var expiry = Date.now();
                    var directUrl = tokenRes + "1234567890?token=" + md5Match[1] + "&expiry=" + expiry;
                    streams.push(new StreamResult({
                        url: directUrl,
                        source: (sourceName || "DoodStream") + " [Direct]",
                        quality: qualityFromText(url) || 1080,
                        headers: defaultHeaders({ "Referer": baseOrigin(url) + "/" })
                    }));
                }
            }
        } catch (_) {}
        return streams;
    }

    // 4. Mixdrop Extractor (mixdrop.co, mixdrop.to, mixdrop.sx, mixdrop.bz)
    async function extractMixdrop(url, sourceName) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({ "Referer": "https://mixdrop.co/" }));
            var unpacked = unpackPacker(html) || html;
            var vurlMatch = unpacked.match(/MDCore\.(?:vurl|wurl)\s*=\s*["']([^"']+)["']/i);
            if (vurlMatch && vurlMatch[1]) {
                var vurl = vurlMatch[1];
                if (vurl.indexOf("//") === 0) vurl = "https:" + vurl;
                streams.push(new StreamResult({
                    url: vurl,
                    source: (sourceName || "Mixdrop") + " [Direct]",
                    quality: qualityFromText(url) || 1080,
                    headers: defaultHeaders({ "Referer": "https://mixdrop.co/" })
                }));
            }
        } catch (_) {}
        return streams;
    }

    // 5. Voe Extractor (voe.sx, voe-network.net, tubeless.cc)
    async function extractVoe(url, sourceName) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }));
            var hlsMatch = html.match(/["']hls["']\s*:\s*["']([^"']+)["']/i)
                || html.match(/(https?:\/\/[^"'\s]+\.m3u8[^"'\s]*)/i);
            if (hlsMatch && hlsMatch[1]) {
                streams.push(new StreamResult({
                    url: hlsMatch[1],
                    source: (sourceName || "Voe") + " [HLS]",
                    quality: qualityFromText(hlsMatch[1]) || 1080,
                    headers: defaultHeaders({ "Referer": baseOrigin(url) + "/" })
                }));
            }
        } catch (_) {}
        return streams;
    }

    // 6. Filemoon Extractor (filemoon.sx, filemoon.to)
    async function extractFilemoon(url, sourceName) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }));
            var unpacked = unpackPacker(html) || html;
            var m3u8Match = unpacked.match(/(https?:\/\/[^"'\s]+\.m3u8[^"'\s]*)/i);
            if (m3u8Match && m3u8Match[1]) {
                streams.push(new StreamResult({
                    url: m3u8Match[1],
                    source: (sourceName || "Filemoon") + " [HLS]",
                    quality: qualityFromText(m3u8Match[1]) || 1080,
                    headers: defaultHeaders({ "Referer": baseOrigin(url) + "/" })
                }));
            }
        } catch (_) {}
        return streams;
    }

    // 7. Mp4Upload Extractor (mp4upload.com)
    async function extractMp4Upload(url, sourceName) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({ "Referer": "https://www.mp4upload.com/" }));
            var unpacked = unpackPacker(html) || html;
            var srcMatch = unpacked.match(/player\.src\(\s*\{\s*type:\s*["']video\/mp4["'],\s*src:\s*["']([^"']+)["']/i)
                || unpacked.match(/(https?:\/\/[^"'\s]+\.mp4[^"'\s]*)/i);
            if (srcMatch && srcMatch[1]) {
                streams.push(new StreamResult({
                    url: srcMatch[1],
                    source: (sourceName || "Mp4Upload") + " [Direct]",
                    quality: qualityFromText(srcMatch[1]) || 1080,
                    headers: defaultHeaders({ "Referer": "https://www.mp4upload.com/" })
                }));
            }
        } catch (_) {}
        return streams;
    }

    // Universal Embed Router
    async function extractUniversalEmbed(url, sourceName, defaultQuality) {
        if (!url) return [];
        var val = String(url).toLowerCase();

        if (val.indexOf("hdm2.ink") !== -1) {
            return await extractHDm2Streams(url);
        }
        if (val.indexOf("prvs.top") !== -1 || val.indexOf("hydrax") !== -1 || val.indexOf("abyss") !== -1) {
            return await extractAbyassStreams(url);
        }
        if (val.indexOf("streamtape") !== -1 || val.indexOf("streamta.pe") !== -1) {
            return await extractStreamtape(url, sourceName);
        }
        if (val.indexOf("streamwish") !== -1 || val.indexOf("vidhide") !== -1 || val.indexOf("filelions") !== -1 || val.indexOf("wishfast") !== -1) {
            return await extractStreamwish(url, sourceName);
        }
        if (val.indexOf("dood") !== -1 || val.indexOf("ds2play") !== -1) {
            return await extractDoodStream(url, sourceName);
        }
        if (val.indexOf("mixdrop") !== -1) {
            return await extractMixdrop(url, sourceName);
        }
        if (val.indexOf("voe") !== -1 || val.indexOf("tubeless") !== -1) {
            return await extractVoe(url, sourceName);
        }
        if (val.indexOf("filemoon") !== -1 || val.indexOf("moonplayer") !== -1) {
            return await extractFilemoon(url, sourceName);
        }
        if (val.indexOf("mp4upload") !== -1) {
            return await extractMp4Upload(url, sourceName);
        }
        if (val.indexOf("gdflix") !== -1 || val.indexOf("gdlink") !== -1) {
            return await extractGdflixStreams(url, sourceName, defaultQuality);
        }
        if (val.indexOf("hubcloud") !== -1 || val.indexOf("gamerxyt") !== -1) {
            return await extractHubcloudStreams(url, sourceName, defaultQuality);
        }
        if (isDirectMediaUrl(url)) {
            return [new StreamResult({
                url: url,
                source: (sourceName || "HDMovie2") + " [Direct]",
                quality: defaultQuality || qualityFromText(url) || 1080,
                headers: defaultHeaders()
            })];
        }
        return [];
    }

    async function extractGdflixStreams(targetUrl, sourceName, defaultQuality) {
        var streams = [];
        try {
            var res = await getText(targetUrl, defaultHeaders({ "Referer": "https://hdm.im/" }));
            var anchors = parseAnchors(res, baseOrigin(targetUrl));
            for (var i = 0; i < anchors.length; i++) {
                var a = anchors[i];
                var label = a.text.toLowerCase();
                var href = a.href;
                if (!href || /login|sign in|privacy|terms|dmca|about us|telegram/i.test(label)) continue;

                var qual = qualityFromText(a.text) || defaultQuality;

                // 1. Instant DL [10GBPS]
                if (label.indexOf("instant dl") !== -1 || href.indexOf("busycdn") !== -1) {
                    streams.push(new StreamResult({
                        url: href,
                        source: (sourceName || "HDMovie2") + " [Instant 10Gbps]",
                        quality: qual || 1080,
                        headers: defaultHeaders({ "Referer": targetUrl })
                    }));
                }
                // 2. CLOUD DOWNLOAD [R2]
                else if (label.indexOf("cloud download") !== -1 || href.indexOf("fastcdn-dl") !== -1 || href.indexOf("r2.dev") !== -1) {
                    var r2Url = href;
                    var matchUrl = href.match(/[?&]url=([^&]+)/i);
                    if (matchUrl && matchUrl[1]) {
                        try { r2Url = decodeURIComponent(matchUrl[1]); } catch (_) {}
                    }
                    streams.push(new StreamResult({
                        url: r2Url,
                        source: (sourceName || "HDMovie2") + " [Cloud R2]",
                        quality: qual || 1080,
                        headers: defaultHeaders({ "Referer": targetUrl })
                    }));
                }
                // 3. FAST CLOUD / ZIPDISK / CFlare
                else if (label.indexOf("fast cloud") !== -1 || label.indexOf("zipdisk") !== -1 || href.indexOf("/cflare/") !== -1) {
                    var cflareHref = href.indexOf("http") === 0 ? href : absoluteUrl(baseOrigin(targetUrl), href);
                    try {
                        var cflareHtml = await getText(cflareHref, defaultHeaders({ "Referer": targetUrl }));
                        var cflareAnchors = parseAnchors(cflareHtml, baseOrigin(cflareHref));
                        for (var c = 0; c < cflareAnchors.length; c++) {
                            var cAnchor = cflareAnchors[c];
                            var cLabel = cAnchor.text.toLowerCase();
                            var cHref = cAnchor.href;
                            if (cLabel.indexOf("cloud resume") !== -1 || cHref.indexOf("workers.dev") !== -1 || cHref.indexOf("awscdn") !== -1 || isDirectMediaUrl(cHref)) {
                                streams.push(new StreamResult({
                                    url: cHref,
                                    source: (sourceName || "HDMovie2") + " [Cloud Resume]",
                                    quality: qual || 1080,
                                    headers: defaultHeaders({ "Referer": cflareHref })
                                }));
                            }
                        }
                    } catch (_) {}
                }
                // 4. Pixeldrain
                else if (label.indexOf("pixel") !== -1 || href.indexOf("pixeldrain") !== -1) {
                    var pixId = href.split("/").pop();
                    streams.push(new StreamResult({
                        url: "https://pixeldrain.dev/api/file/" + pixId + "?download",
                        source: (sourceName || "HDMovie2") + " [Pixeldrain]",
                        quality: qual || 1080,
                        headers: defaultHeaders()
                    }));
                }
                // 5. Direct / Fast Cloud
                else if (label.indexOf("direct dl") !== -1 || label.indexOf("fast cloud") !== -1) {
                    if (isDirectMediaUrl(href)) {
                        streams.push(new StreamResult({
                            url: href,
                            source: (sourceName || "HDMovie2") + " [Fast Direct]",
                            quality: qual || 1080,
                            headers: defaultHeaders({ "Referer": targetUrl })
                        }));
                    }
                }
            }
        } catch (_) {}
        return streams;
    }

    async function extractHubcloudStreams(targetUrl, sourceName, defaultQuality) {
        var streams = [];
        try {
            var html = await getText(targetUrl, defaultHeaders({ "Referer": baseOrigin(targetUrl) + "/" }));
            var anchors = parseAnchors(html, baseOrigin(targetUrl));
            for (var i = 0; i < anchors.length; i++) {
                var a = anchors[i];
                var label = a.text.toLowerCase();
                var href = a.href;
                var qual = qualityFromText(a.text) || defaultQuality;

                if (label.indexOf("10gbps") !== -1 || label.indexOf("download") !== -1 || href.indexOf("r2.dev") !== -1 || href.indexOf("cloudfront") !== -1) {
                    if (href.indexOf("http") === 0) {
                        streams.push(new StreamResult({
                            url: href,
                            source: (sourceName || "HDMovie2") + " [HubCloud " + (qual ? qual + "p" : "Direct") + "]",
                            quality: qual || 1080,
                            headers: defaultHeaders({ "Referer": targetUrl })
                        }));
                    }
                }
            }
        } catch (_) {}
        return streams;
    }

    async function extractHDm2Streams(playUrl) {
        var streams = [];
        try {
            var resText = await getText(playUrl, {
                "User-Agent": "okhttp/4.12.0",
                "Referer": "https://hdmovie2a.icu/"
            });
            var streamMatch = resText.match(/data-stream-url=["'](.*?)["']/i);
            if (streamMatch && streamMatch[1]) {
                var rawStream = streamMatch[1].trim();
                var cleaned = rawStream.replace(/&amp;/g, "&");
                var m3u8Url = cleaned.indexOf("http") === 0 ? cleaned : ("https://hdm2.ink/" + cleaned.replace(/^\/+/, ""));
                streams.push(new StreamResult({
                    url: m3u8Url,
                    source: "Ultra Stream V3 [HDm2]",
                    quality: qualityFromText(resText) || 1080,
                    headers: {
                        "User-Agent": "okhttp/4.12.0",
                        "Referer": "https://hdm2.ink/"
                    }
                }));
            }
        } catch (_) {}
        return streams;
    }

    async function extractAbyassStreams(url) {
        var streams = [];
        try {
            var html = await getText(url, defaultHeaders({
                "Origin": "https://playhydrax.com",
                "Referer": "https://playhydrax.com/"
            }));
            var encMatch = html.match(/const\s+datas\s*=\s*"([^"]*)"/i);
            if (encMatch && encMatch[1]) {
                var encText = encMatch[1];
                var decRes = await request("https://enc-dec.app/api/dec-abyss", {
                    method: "POST",
                    body: JSON.stringify({ text: encText }),
                    headers: {
                        "Content-Type": "application/json",
                        "User-Agent": COMMON_USER_AGENT
                    }
                });
                var decJson = parseJsonSafe(decRes.body, {});
                if (decJson && decJson.result && decJson.result.sources) {
                    var sources = decJson.result.sources;
                    for (var s = 0; s < sources.length; s++) {
                        var src = sources[s];
                        if (src.status && src.url) {
                            streams.push(new StreamResult({
                                url: src.url,
                                source: "Abyass [" + String(src.codec || "HLS").toUpperCase() + "]",
                                quality: qualityFromText(src.type || "") || 1080,
                                headers: defaultHeaders({
                                    "Origin": "https://playhydrax.com",
                                    "Referer": "https://playhydrax.com/"
                                })
                            }));
                        }
                    }
                }
            }
        } catch (_) {}
        return streams;
    }

    async function resolveSingleHdmLink(hdmHref, buttonLabel) {
        var streams = [];
        try {
            var normalizedHdm = normalizeExtractorDomain(hdmHref);
            if (/gdflix|gdlink/i.test(normalizedHdm)) {
                return await extractGdflixStreams(normalizedHdm, "HDMovie2", qualityFromText(buttonLabel) || 1080);
            }
            if (/hubcloud|gamerxyt/i.test(normalizedHdm)) {
                return await extractHubcloudStreams(normalizedHdm, "HDMovie2", qualityFromText(buttonLabel) || 1080);
            }
            if (/hdm2\.ink/i.test(normalizedHdm)) {
                return await extractHDm2Streams(normalizedHdm);
            }

            var res = await getText(normalizedHdm, defaultHeaders({ "Referer": "https://hdmovie2a.icu/" }));
            var buttons = [...res.matchAll(/<p\b[^>]*>\s*<a\b[^>]+href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>\s*<\/p>/gi)];
            if (!buttons.length) {
                buttons = [...res.matchAll(/<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi)].filter(function (m) {
                    return /gdflix|gdtot|filepress|filebee|hubcloud/i.test(m[1]);
                });
            }

            var targetTasks = buttons.map(async function (btn) {
                var btnHref = normalizeExtractorDomain(btn[1]);
                var btnText = stripTags(btn[2]);
                var btnQual = qualityFromText(btnText) || qualityFromText(buttonLabel) || 1080;

                try {
                    return await extractUniversalEmbed(btnHref, "HDMovie2 " + (btnQual ? btnQual + "p" : ""), btnQual);
                } catch (e) {
                    console.log("targetTask error:", e && e.message);
                }
                return [];
            });

            var subResults = await Promise.all(targetTasks);
            for (var s = 0; s < subResults.length; s++) {
                streams = streams.concat(subResults[s]);
            }
        } catch (_) {}
        return streams;
    }

    async function resolveDooPlayerOption(opt, mainUrl, sourceUrl) {
        var streams = [];
        try {
            var formData = "action=doo_player_ajax&post=" + encodeURIComponent(opt.post)
                + "&nume=" + encodeURIComponent(opt.nume)
                + "&type=" + encodeURIComponent(opt.type);
            var res = await request(mainUrl + "/wp-admin/admin-ajax.php", {
                method: "POST",
                body: formData,
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
                    "X-Requested-With": "XMLHttpRequest",
                    "User-Agent": COMMON_USER_AGENT,
                    "Referer": sourceUrl || (mainUrl + "/"),
                    "Origin": mainUrl
                }
            });
            var json = parseJsonSafe(res.body, {});
            var embedUrl = firstMatch(String(json.embed_url || ""), [/<iframe\b[^>]*src=["']([^"']+)["']/i, /^https?:\/\/[^\s]+/i]);
            if (embedUrl) {
                var extracted = await extractUniversalEmbed(embedUrl, opt.title || "Ultra Stream", 1080);
                if (extracted && extracted.length) {
                    streams = streams.concat(extracted);
                }
            }
        } catch (_) {}
        return streams;
    }

    async function loadStreams(url, cb) {
        try {
            var mainUrl = await getMainUrl();
            var payload = parseJsonSafe(url, null);
            var sourceUrl = "";
            var downloadLinks = [];
            var playerOptions = [];

            if (payload && typeof payload === "object") {
                sourceUrl = payload.sourceUrl || payload.url || "";
                downloadLinks = payload.downloadLinks || [];
                playerOptions = payload.playerOptions || [];
            } else if (typeof url === "string" && url.indexOf("http") === 0) {
                sourceUrl = url;
            }

            // If payload had no download links, fetch the page to extract them
            if (sourceUrl && !downloadLinks.length && !playerOptions.length) {
                var html = await getText(sourceUrl, defaultHeaders({ "Referer": mainUrl + "/" }));
                var pAnchors = [...html.matchAll(/<p\b[^>]*>\s*<a\b[^>]+href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>\s*<\/p>/gi)];
                for (var p = 0; p < pAnchors.length; p++) {
                    var pHref = absoluteUrl(mainUrl, pAnchors[p][1]);
                    var pLabel = stripTags(pAnchors[p][2]);
                    if (pHref && pHref.indexOf("http") === 0) {
                        downloadLinks.push({ href: pHref, label: pLabel });
                    }
                }
                var optLiMatches = [...html.matchAll(/<li\b[^>]*data-type=["']([^"']*)["'][^>]*data-post=["']([^"']*)["'][^>]*data-nume=["']([^"']*)["'][^>]*>([\s\S]*?)<\/li>/gi)];
                for (var o = 0; o < optLiMatches.length; o++) {
                    var oType = optLiMatches[o][1];
                    var oPost = optLiMatches[o][2];
                    var oNume = optLiMatches[o][3];
                    var oTitle = stripTags(firstMatch(optLiMatches[o][4], [/<span\b[^>]*class=["']title["'][^>]*>([\s\S]*?)<\/span>/i]));
                    if (oNume && !/trailer/i.test(oNume)) {
                        playerOptions.push({ type: oType, post: oPost, nume: oNume, title: oTitle || ("Server " + oNume) });
                    }
                }
            }

            var allStreams = [];

            // 0. Direct hdm2.ink stream task
            var hdm2Task = (/hdm2\.ink/i.test(sourceUrl)) ? extractHDm2Streams(sourceUrl) : Promise.resolve([]);

            // 1. Resolve hdm.im download buttons in parallel (deduplicated by href)
            var uniqueLinks = uniqueBy(downloadLinks, function (link) { return link.href; });
            var hdmTasks = uniqueLinks.map(function (link) {
                return resolveSingleHdmLink(link.href, link.label);
            });

            // 2. Resolve doo_player_ajax options in parallel
            var optTasks = playerOptions.map(function (opt) {
                return resolveDooPlayerOption(opt, mainUrl, sourceUrl);
            });

            var results = await Promise.all([hdm2Task].concat(hdmTasks, optTasks));
            for (var r = 0; r < results.length; r++) {
                allStreams = allStreams.concat(results[r]);
            }

            // Deduplicate and filter direct streams only
            var directStreams = uniqueBy(allStreams.filter(function (it) {
                return it && it.url && isDirectMediaUrl(it.url);
            }), function (it) {
                return it.url;
            });

            // Sort descending by quality
            directStreams.sort(function (a, b) {
                return (b.quality || 0) - (a.quality || 0);
            });

            Analytics.logEvent('hdmovie2_loadstreams', {});
            cb({ success: true, data: directStreams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: toErrorMessage(error) });
        }
    }

    var root = typeof globalThis !== "undefined" ? globalThis
        : typeof self !== "undefined" ? self
        : typeof window !== "undefined" ? window
        : typeof global !== "undefined" ? global
        : this;

    root.getHome = getHome;
    root.loadHome = getHome;
    root.loadhome = getHome;
    root.search = search;
    root.load = load;
    root.loadStreams = loadStreams;

})();
