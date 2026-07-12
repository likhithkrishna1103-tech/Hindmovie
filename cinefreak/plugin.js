(function () {
    var safeFetch = typeof fetch === "function" ? fetch : null;
    if (!safeFetch) {
        try {
            safeFetch = (new Function("return (this.constructor.constructor('return fetch')())")());
        } catch (_) {}
    }
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

    "use strict";

    var DEFAULT_BASE_URL = "https://cinefreak.nl";
    var DEFAULT_HUBCLOUD_URL = "https://hubcloud.cx";
    var DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    var TMDB_WORKER_API = "https://api.themoviedb.org/3";
    var TMDB_FALLBACK_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_IMAGE_BASE = "https://image.tmdb.org/t/p/original";
    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_LOGO_API_KEY = "98ae14df2b8d8f8f8136499daf79f0e0";
    var runtimeManifest = (typeof manifest !== "undefined" && manifest) ? manifest : { baseUrl: DEFAULT_BASE_URL };
    var domainCache = null;
    var hubcloudCache = null;
    var gdflixDomainCache = null;
    var urlCache = {};
    var tmdbJsonCache = {};
    var tmdbInflight = {};
    var CACHE_TTL = 300000;

    var MAIN_PAGE_SECTIONS = [
        { path: "", title: "Home" },
        { path: "hindi-movies", title: "Hindi Movies" },
        { path: "hindi-dubbed-movies", title: "Hindi Dubbed" },
        { path: "english-movies", title: "English Movies" },
        { path: "dual-audio", title: "Dual Audio" },
        { path: "web-series", title: "Web Series" },
        { path: "korean", title: "Korean" },
        { path: "k-drama", title: "K-Drama" },
        { path: "tamil", title: "Tamil" },
        { path: "telugu", title: "Telugu" },
        { path: "malayalam", title: "Malayalam" },
        { path: "kannada", title: "Kannada" },
        { path: "bangla-movies", title: "Bangla Movies" },
        { path: "bangla-dubbed", title: "Bangla Dubbed" },
        { path: "animation", title: "Animation" },
        { path: "chinese", title: "Chinese" },
        { path: "japanese", title: "Japanese" },
        { path: "indonesian", title: "Indonesian" },
        { path: "spanish", title: "Spanish" },
        { path: "horror", title: "Horror" },
        { path: "mcu", title: "MCU" },
        { path: "others", title: "Others" }
    ];

    function toErrorMessage(error) {
        return String(error && (error.stack || error.message) || error);
    }

    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function decodeHtmlEntities(value) {
        return trim(String(value || "")
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">"));
    }

    function stripTags(value) {
        return decodeHtmlEntities(String(value || "").replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "));
    }

    function snippet(value, max) {
        return trim(stripTags(String(value || ""))).slice(0, max || 280);
    }

    function escapeRegExp(value) {
        return String(value || "").replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
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

    function firstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return trim(match[1]);
        }
        return "";
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            try {
                var text = String(value || "").replace(/^'+|'+$/g, "").replace(/^"+|"+$/g, "");
                return JSON.parse(text);
            } catch (_) {
                return fallback;
            }
        }
    }

    function hasMeaningfulJsonData(value) {
        if (!value || typeof value !== "object") return false;
        if (Array.isArray(value)) return value.length > 0;
        for (var key in value) {
            if (!Object.prototype.hasOwnProperty.call(value, key)) continue;
            var item = value[key];
            if (Array.isArray(item)) {
                if (item.length) return true;
                continue;
            }
            if (item && typeof item === "object") {
                for (var nestedKey in item) {
                    if (Object.prototype.hasOwnProperty.call(item, nestedKey)) return true;
                }
                continue;
            }
            if (item !== "" && item !== null && typeof item !== "undefined") return true;
        }
        return false;
    }

    function absoluteUrl(base, path) {
        if (!path) return String(base || "");
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function normalizeBaseUrl(url) {
        return String(url || "").replace(/\/+$/g, "");
    }

    function baseOrigin(url) {
        try {
            var parsed = new URL(url);
            return parsed.protocol + "//" + parsed.host;
        } catch (_) {
            return "";
        }
    }

    function decodeQueryParam(url, name) {
        try {
            return new URL(url).searchParams.get(name) || "";
        } catch (_) {
            return "";
        }
    }

    function safeDecodeURIComponent(value) {
        try {
            return decodeURIComponent(String(value || ""));
        } catch (_) {
            return String(value || "");
        }
    }

    function decodeBase64Safe(value) {
        var input = String(value || "").trim();
        if (!input) return "";
        var normalized = input.replace(/-/g, "+").replace(/_/g, "/");
        while (normalized.length % 4) normalized += "=";

        try {
            if (typeof atob === "function") return atob(normalized);
        } catch (_) {}

        try {
            if (typeof Buffer !== "undefined") return Buffer.from(normalized, "base64").toString("utf8");
        } catch (_) {}

        return "";
    }

    function getQualityFromText(text) {
        var lower = decodeHtmlEntities(String(text || "")).replace(/%[0-9a-fA-F]{2}/g, " ").toLowerCase();
        // Prefer the LAST explicit "NNNp" token — that is the real resolution tag
        // (e.g. "...UNCUT DS4K WEB-DL... 480p ESub" -> 480, not the marketing "DS4K").
        var explicit = lower.match(/(\d{3,4})p/g);
        if (explicit && explicit.length) {
            return parseInt(explicit[explicit.length - 1], 10);
        }
        if (/\b2160p\b|\b4k\b|\buhd\b|\bds4k\b/.test(lower)) return 2160;
        if (/\b1440p\b|\bqhd\b/.test(lower)) return 1440;
        if (/\bfullhd\b/.test(lower)) return 1080;
        if (/\b576p\b/.test(lower)) return 576;
        if (/\b360p\b/.test(lower)) return 360;
        return 0;
    }

    // Parse audio codec / channels from a download filename or link label.
    function getAudioFromText(text) {
        var lower = decodeHtmlEntities(String(text || "")).replace(/%[0-9a-fA-F]{2}/g, " ").toLowerCase();
        var audio = "";
        if (/\batmos\b|\bdolby atmos\b/.test(lower)) audio = "Atmos";
        else if (/\b(ddp|dd\+|e-ac-3|eac3|dolby digital plus)\b/.test(lower)) audio = "DDP";
        else if (/\b(dd|ac-3|dolby digital|dolby)\b/.test(lower)) audio = "DD";
        else if (/\baac\b/.test(lower)) audio = "AAC";
        else if (/\b(mp3|mpeg)\b/.test(lower)) audio = "MP3";
        else if (/\bflac\b/.test(lower)) audio = "FLAC";
        else if (/\bopus\b/.test(lower)) audio = "Opus";
        var channels = "";
        if (/\b7\.1\b/.test(lower)) channels = "7.1";
        else if (/\b5\.1\b/.test(lower)) channels = "5.1";
        else if (/\b2\.0\b/.test(lower)) channels = "2.0";
        var out = [audio, channels].filter(Boolean).join(" ");
        return out || "";
    }

    // Build a descriptive source label: "Cinefreak [1080p AAC 2.0]" etc.
    function buildSourceLabel(base, text) {
        var q = getQualityFromText(text);
        var a = getAudioFromText(text);
        var parts = [base];
        if (q) parts.push(q + "p");
        if (a) parts.push(a);
        return parts.join(" ");
    }

    function getSearchQuality(text) {
        var value = String(text || "").toLowerCase();
        if (/\b(4k|ds4k|uhd|2160p)\b/.test(value)) return "4K";
        if (/\b(hdts|hdcam|hdtc)\b/.test(value)) return "HD Cam";
        if (/\b(camrip|cam-rip)\b/.test(value)) return "Cam Rip";
        if (/\bcam\b/.test(value)) return "Cam";
        if (/\b(web-dl|webrip|webdl)\b/.test(value)) return "WebRip";
        if (/\b(bluray|bdrip|blu-ray)\b/.test(value)) return "BluRay";
        if (/\b(1080p|fullhd|hdrip|hdtv)\b/.test(value)) return "HD";
        if (/\b720p\b/.test(value)) return "SD";
        if (/\bdvd\b/.test(value)) return "DVD";
        if (/\bhq\b/.test(value)) return "HQ";
        return undefined;
    }

    function inferTypeFromTitle(text) {
        var value = String(text || "");
        if (/anime/i.test(value)) return "anime";
        if (/season|series/i.test(value)) return "series";
        return "movie";
    }

    function normalizeTitle(text) {
        return trim(String(text || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/[^a-z0-9]+/g, " "));
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

    function request(url, options) {
        options = options || {};
        var method = options.method || "GET";
        var headers = options.headers || {};
        var body = options.body;
        var allowRedirects = options.allowRedirects !== false;
        var timeout = options.timeout || 20000;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                return {
                    status: res && typeof res.status !== "undefined" ? res.status : 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            return Promise.resolve(http_post(url, body, headers)).then(function (res) {
                return {
                    status: res && typeof res.status !== "undefined" ? res.status : 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (typeof fetch === "function") {
            var controller = typeof AbortController !== "undefined" ? new AbortController() : null;
            var timer = null;
            var fetchOptions = {
                method: method,
                headers: headers,
                body: body,
                redirect: allowRedirects ? "follow" : "manual"
            };
            if (controller) fetchOptions.signal = controller.signal;

            var fetchPromise = fetch(url, fetchOptions).then(function (res) {
                console.log("Fetch Debug - url: " + url + " res.url: " + res.url + " res.status: " + res.status + " res.redirected: " + res.redirected + " keys: " + Object.keys(res || {}));
                return res.text().then(function (bodyText) {
                    return {
                        status: res.status,
                        body: bodyText,
                        headers: parseHeaders(res.headers),
                        finalUrl: res.url || url
                    };
                });
            });

            if (controller) {
                timer = setTimeout(function () {
                    try { controller.abort(); } catch (_) {}
                }, timeout);

                return fetchPromise.then(function (result) {
                    clearTimeout(timer);
                    return result;
                }).catch(function (error) {
                    clearTimeout(timer);
                    throw error;
                });
            }

            return Promise.race([
                fetchPromise,
                new Promise(function (_, reject) {
                    timer = setTimeout(function () {
                        reject(new Error("Request timeout after " + timeout + "ms"));
                    }, timeout);
                })
            ]).then(function (result) {
                clearTimeout(timer);
                return result;
            }).catch(function (error) {
                clearTimeout(timer);
                throw error;
            });
        }

        if (typeof axios !== "undefined" && axios) {
            return axios({
                url: url,
                method: method,
                headers: headers,
                data: body,
                proxy: false,
                timeout: options.timeout || 20000,
                maxRedirects: allowRedirects ? 5 : 0,
                responseType: "text",
                transformResponse: [function (data) { return data; }],
                validateStatus: function () { return true; }
            }).then(function (res) {
                return {
                    status: res.status,
                    body: typeof res.data === "string" ? res.data : JSON.stringify(res.data),
                    headers: parseHeaders(res.headers),
                    finalUrl: (res.request && res.request.res && res.request.res.responseUrl) || url
                };
            });
        }

        throw new Error("No HTTP client available in runtime");
    }

    function getText(url, headers, allowRedirects) {
        var now = Date.now();
        if (urlCache[url] && (now - urlCache[url].time) < CACHE_TTL) {
            return Promise.resolve(urlCache[url].body);
        }
        return request(url, { headers: headers, allowRedirects: allowRedirects, timeout: 15000 }).then(function (res) {
            var body = res.body || "";
            urlCache[url] = { body: body, time: now };
            return body;
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers }).then(function (res) {
            return parseJsonSafe(res.body, {});
        });
    }

    function postForm(url, form, headers, allowRedirects) {
        var body = [];
        for (var key in form) {
            if (!Object.prototype.hasOwnProperty.call(form, key)) continue;
            body.push(encodeURIComponent(key) + "=" + encodeURIComponent(form[key]));
        }
        return request(url, {
            method: "POST",
            body: body.join("&"),
            headers: Object.assign({
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, headers || {}),
            allowRedirects: allowRedirects
        });
    }

    function defaultHeaders(extra) {
        return Object.assign({
            "Cookie": "xla=s4t; ext_name=ojplmecpdpgccookcobabopnaifgidhf; cf_clearance=t8e4FnYNVLq5mnSM3STcq978u7YyAaAb_WiqmVmXkcI-1773985249-1.2.1.1-Sg.2ExY1ScnsVHPQ0nj5jSQ7aKuFzBaPOPn8WRH5i0JYxUTrGXNrowzFsl36zUeK9irU7RqVsRTLF9DoM25Rz1tyFLiGaVK6WlxZLkOyr0_xyAduok9mNr3ilfnSXx1FT6.g9jo4m2cAKY.AFbvLZ8AB.8VgL0Wv4BTn5EBGcKQo4s.grQTQ.Bd58bFWF0CQRYgxD0O2PrfIoveenO8wCQMqQ_R9h22MKBQdBqqLCgk",
            "User-Agent": "Mozilla/5.0"
        }, extra || {});
    }

    function pageHeaders(mainUrl) {
        return defaultHeaders({ "Referer": mainUrl + "/" });
    }

    function mainPageHeaders(mainUrl) {
        return pageHeaders(mainUrl);
    }

    function isPlaceholderBaseUrl(url) {
        return /(?:^|\/\/)(?:www\.)?example\.com(?:\/|$)/i.test(String(url || ""));
    }

    function looksLikeMediaListing(html) {
        var source = String(html || "");
        return /<article\b[^>]*class=["'][^"']*(?:entry-card|post|hentry)[^"']*["']/i.test(source)
            || /<h[23]\b[^>]*class=["'][^"']*entry-title[^"']*["']/i.test(source);
    }

    function validateMainUrl(candidate) {
        var url = normalizeBaseUrl(candidate);
        if (!/^https?:\/\//i.test(url) || isPlaceholderBaseUrl(url)) return Promise.resolve("");

        return getText(url + "/", pageHeaders(url), true).then(function (html) {
            return looksLikeMediaListing(html) ? url : "";
        }).catch(function () {
            return "";
        });
    }

    function parseAnchors(html, base) {
        var source = String(html || "");
        var out = [];
        var regex = /<a\b[^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = regex.exec(source))) {
            var tagContent = match[0];
            var hrefMatch = tagContent.match(/\bhref=["']([^"']+)["']/i);
            if (!hrefMatch) continue;
            var idMatch = tagContent.match(/\bid=["']([^"']+)["']/i);
            out.push({
                href: absoluteUrl(base, decodeHtmlEntities(hrefMatch[1])),
                text: stripTags(match[1]),
                id: idMatch ? idMatch[1] : ""
            });
        }
        return out;
    }

    function escapeRegExp(string) {
        return string.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
    }

    function decodeQueryParam(url, name) {
        var match = String(url || "").match(new RegExp("[?&]" + escapeRegExp(name) + "=([^&#]*)", "i"));
        return match ? decodeURIComponent(match[1].replace(/\+/g, " ")) : "";
    }

    function resolveDynamicJsHrefs(html) {
        var mappings = {};
        var elementHrefRegex = /document\.getElementById\(\s*["']([^"']+)["']\s*\)\.href\s*=\s*([a-zA-Z0-9_$]+)/g;
        var match;
        while ((match = elementHrefRegex.exec(html))) {
            var id = match[1];
            var varName = match[2];
            var varDeclRegex = new RegExp("(?:var|let|const)\\s+" + escapeRegExp(varName) + "\\s*=\\s*[\"']([^\"']+)[\"']", "i");
            var declMatch = html.match(varDeclRegex);
            if (declMatch && declMatch[1]) {
                mappings[id] = declMatch[1];
            }
        }
        return mappings;
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

    function getImageFromBlock(block, base) {
        var img = firstMatch(block, [
            /<img\b[^>]*src=["']([^"']+)["']/i,
            /<img\b[^>]*data-src=["']([^"']+)["']/i
        ]);
        return img ? absoluteUrl(base, img) : "";
    }

    function getMainUrl() {
        if (domainCache) return Promise.resolve(domainCache);

        return getJson(DOMAINS_URL, defaultHeaders()).catch(function () {
            return {};
        }).then(function (json) {
            var domain = (json && json.cinefreak) || DEFAULT_BASE_URL;
            domainCache = normalizeBaseUrl(domain);
            return domainCache;
        });
    }

    function getHubCloudUrl() {
        if (hubcloudCache) return Promise.resolve(hubcloudCache);

        return getJson(DOMAINS_URL, defaultHeaders()).catch(function () {
            return {};
        }).then(function (json) {
            var domain = (json && json.hubcloud) || DEFAULT_HUBCLOUD_URL;
            hubcloudCache = normalizeBaseUrl(domain);
            return hubcloudCache;
        });
    }

    function getLatestGdflixUrl() {
        if (gdflixDomainCache) return Promise.resolve(gdflixDomainCache);
        return getJson("https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json", defaultHeaders()).then(function (json) {
            gdflixDomainCache = (json && json.gdflix) || "https://*.gdflix.*";
            return gdflixDomainCache;
        }).catch(function () {
            gdflixDomainCache = "https://*.gdflix.*";
            return gdflixDomainCache;
        });
    }

    function parseSearchCard(block, base, defaultType) {
        var href = firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<h3\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i
        ]);
        if (!href) return null;

        var rawTitle = firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<h3\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i
        ]);
        rawTitle = stripTags(rawTitle);
        if (!rawTitle) return null;

        var cleanTitle = trim(rawTitle.split(" (")[0]);
        if (!cleanTitle) cleanTitle = rawTitle;
        var yearMatch = rawTitle.match(/\((\d{4})\)/);
        var langMatch = rawTitle.match(/\[([^\]]+)\]/);
        var fullTitle = cleanTitle;
        if (yearMatch) fullTitle += " (" + yearMatch[1] + ")";
        if (langMatch && trim(langMatch[1])) fullTitle += " [" + trim(langMatch[1]) + "]";

        return new MultimediaItem({
            title: fullTitle,
            url: absoluteUrl(base, href),
            posterUrl: getImageFromBlock(block, base),
            type: defaultType || inferTypeFromTitle(rawTitle),
            quality: getSearchQuality(rawTitle),
            headers: defaultHeaders({ "Referer": base + "/" })
        });
    }

    function parseSearchResults(html, base, defaultType) {
        return extractBlocks(html, "article").map(function (block) {
            return parseSearchCard(block, base, defaultType);
        }).filter(Boolean);
    }

    function parseHomeResults(html, base) {
        return extractBlocks(html, "article").map(function (block) {
            var href = firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
                /<h2\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i
            ]);
            var rawTitle = stripTags(firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<h2\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i
            ]));
            if (!href || !rawTitle) return null;

            var title = trim(rawTitle.split(" (")[0]);
            var year = rawTitle.match(/\((\d{4})\)/);
            var lang = rawTitle.match(/\[([^\]]+)\]/);
            var fullTitle = title;
            if (year) fullTitle += " (" + year[1] + ")";
            if (lang && trim(lang[1])) fullTitle += " [" + trim(lang[1]) + "]";

            return new MultimediaItem({
                title: fullTitle,
                url: absoluteUrl(base, href),
                posterUrl: getImageFromBlock(block, base),
                type: inferTypeFromTitle(rawTitle),
                quality: getSearchQuality(rawTitle),
                headers: defaultHeaders()
            });
        }).filter(Boolean);
    }

    function parseHomeCards(html, base) {
        var source = String(html || "");
        var out = [];
        var anchorRegex = /<a\b[^>]*class=["'][^"']*movie-card[^"']*["'][^>]*>/gi;
        var match;
        while ((match = anchorRegex.exec(source))) {
            var openTag = match[0];
            var hrefMatch = openTag.match(/href=["']([^"']+)["']/i);
            if (!hrefMatch) continue;
            var href = absoluteUrl(base, decodeHtmlEntities(hrefMatch[1]));
            if (!/^https?:\/\//i.test(href)) continue;

            var ariaMatch = openTag.match(/aria-label=["']([^"']*)["']/i);
            var title = trim(decodeHtmlEntities(ariaMatch ? ariaMatch[1] : "").replace(/ details$/, "").split(/\s*\(\d{4}\)/)[0]);
            // Fallback to img alt if aria-label missing
            if (!title) {
                var altMatch = source.slice(match.index, match.index + 4000).match(/<img\b[^>]*alt=["']([^"']+)["']/i);
                title = trim(decodeHtmlEntities(altMatch ? altMatch[1] : "").split(/\s*\(\d{4}\)/)[0]);
            }
            if (!title) continue;

            // Poster: nearest <img src> after this anchor
            var after = source.slice(match.index, match.index + 6000);
            var imgMatch = after.match(/<img\b[^>]*src=["']([^"']+)["']/i);
            var poster = imgMatch ? absoluteUrl(base, decodeHtmlEntities(imgMatch[1])) : "";
            poster = poster.replace(/\/w185\//i, "/w500/");

            // Quality: first quality-badges span text
            var qBlock = after.match(/class=["'][^"']*quality-badges[^"']*["'][^>]*>([\s\S]*?)<\/div>/i);
            var quality = qBlock ? trim(stripTags(qBlock[1]).replace(/\s+/g, " ")) : "";
            if (!quality) quality = getSearchQuality(title) || "";

            var isSeries = /season|series|episode|full-series-download|web-series|animated-series/i.test(href + " " + title);
            var type = isSeries ? "series" : "movie";

            out.push(new MultimediaItem({
                title: title,
                url: href,
                posterUrl: poster,
                type: type,
                quality: quality || undefined,
                headers: defaultHeaders({ "Referer": base + "/" })
            }));
        }
        return out;
    }

    function parseSearchResultsKotlin(html, base) {
        return parseSearchResults(html, base);
    }

    function extractMetaContent(html, propertyName) {
        var pattern = new RegExp("<meta\\b[^>]*(?:property|name)=[\"']" + escapeRegExp(propertyName) + "[\"'][^>]*content=[\"']([^\"']+)[\"']", "i");
        return decodeHtmlEntities(firstMatch(html, [pattern]));
    }

    function extractBetweenMarkers(html, startPattern, endPattern) {
        var source = String(html || "");
        var startMatch = source.match(startPattern);
        if (!startMatch || typeof startMatch.index !== "number") return "";
        var startIndex = startMatch.index + startMatch[0].length;
        var rest = source.slice(startIndex);
        var endMatch = rest.match(endPattern);
        if (!endMatch || typeof endMatch.index !== "number") return rest;
        return rest.slice(0, endMatch.index);
    }

    function extractDownloadLinks(html, base) {
        var section = extractBetweenMarkers(
            html,
            /<div\b[^>]*class=["'][^"']*downloads-btns-div[^"']*["'][^>]*>/i,
            /<\/div>/i
        );
        var links = parseAnchors(section, base).filter(function (item) {
            return item && item.href && !isIgnoredAnchorLink(item.href) && !/zip/i.test(String(item.text || ""));
        }).map(function (item) { return item.href; }).filter(Boolean);
        if (links.length) return links;

        var buttonLinks = [];
        var buttonRegex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>(?:(?!<\/a>)[\s\S])*?<button\b[^>]*class=["'][^"']*dwd-button[^"']*["'][^>]*>/gi;
        var buttonMatch;
        while ((buttonMatch = buttonRegex.exec(String(html || "")))) {
            buttonLinks.push(absoluteUrl(base, decodeHtmlEntities(buttonMatch[1])));
        }
        if (buttonLinks.length) return uniqueBy(buttonLinks, function (item) { return item; });

        return uniqueBy(parseAnchors(html, base).filter(function (item) {
            var href = String(item && item.href || "");
            var text = String(item && item.text || "");
            if (!/^https?:\/\//i.test(href)) return false;
            if (baseOrigin(href) === baseOrigin(base)) return false;
            if (isIgnoredAnchorLink(href) || /hianime|fuckmaza/i.test(href)) return false;
            if (/zip/i.test(text)) return false;
            return /download|watch|server|drive|cloud|direct|gdflix|hubcloud|filepress|filebee|pixeldrain|gofile|m4ulinks|mdrive/i.test(text + " " + href);
        }).map(function (item) {
            return item.href;
        }), function (item) {
            return item;
        });
    }

    function extractStoryline(html) {
        var regex = /<h3\b[^>]*class=["'][^"']*movie-title[^"']*["'][^>]*>([\s\S]*?)<\/h3>\s*<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            if (stripTags(match[1]).toLowerCase().indexOf("storyline") !== -1) {
                return stripTags(match[2]);
            }
        }
        return "";
    }

    function extractPrimaryHeading(html) {
        return stripTags(firstMatch(html, [
            /<div\b[^>]*class=["'][^"']*single-service-content[^"']*["'][^>]*>[\s\S]*?<h1\b[^>]*>([\s\S]*?)<\/h1>/i
        ]));
    }

    function extractImdbId(html) {
        var href = firstMatch(html, [
            /<a\b[^>]*href=["']https?:\/\/(?:www\.)?imdb\.com\/title\/([^\/"']+)\/?["']/i
        ]);
        return href ? href.split("/")[0] : "";
    }

    function getSeasonSections(html, base) {
        var section = extractBetweenMarkers(
            html,
            /<div\b[^>]*class=["'][^"']*download-links-div[^"']*["'][^>]*>/i,
            /<\/article>|<\/section>/i
        );
        if (!section) section = html;

        var out = [];
        var regex = /<h4\b[^>]*>([\s\S]*?)<\/h4>([\s\S]*?)(?=<h4\b|$)/gi;
        var match;
        while ((match = regex.exec(section))) {
            var title = stripTags(match[1]);
            var seasonMatch = title.match(/Season\s*(\d+)/i);
            if (!seasonMatch) continue;
            out.push({
                season: Number(seasonMatch[1]),
                links: parseAnchors(match[2], base)
                    .filter(function (item) { return !/zip/i.test(String(item && item.text || "")); })
                    .map(function (item) { return item.href; })
                    .filter(Boolean)
            });
        }

        return out;
    }

    function getEpisodeBlocks(html, base) {
        var blocks = [];
        var regex = /<h5\b[^>]*>([\s\S]*?)<\/h5>([\s\S]*?)(?=<h5\b|$)/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var title = stripTags(match[1]);
            var episodeMatch = title.match(/Episodes:\s*(\d+)/i);
            if (!episodeMatch) continue;
            blocks.push({
                episode: Number(episodeMatch[1]),
                links: parseAnchors(match[2], base).filter(function (item) {
                    var href = String(item && item.href || "");
                    var text = String(item && item.text || "");
                    if (!href || isIgnoredAnchorLink(href)) return false;
                    if (/zip/i.test(text)) return false;
                    return true;
                }).map(function (item) { return item.href; }).filter(Boolean)
            });
        }
        return blocks;
    }

    function fetchJsonWithRetry(url, headers, attemptsLeft) {
        return request(url, { headers: headers || defaultHeaders(), timeout: 15000 }).then(function (res) {
            var json = parseJsonSafe(res.body, {});
            if (json && typeof json === "object") return json;
            if (attemptsLeft > 1) return fetchJsonWithRetry(url, headers, attemptsLeft - 1);
            return {};
        }).catch(function () {
            if (attemptsLeft > 1) return fetchJsonWithRetry(url, headers, attemptsLeft - 1);
            return {};
        });
    }

    function getTmdbFallbackPath(path) {
        var value = String(path || "");
        if (!value) return "";
        if (value.indexOf(TMDB_FALLBACK_API) === 0) return value;
        if (value.indexOf(TMDB_API) === 0) return TMDB_FALLBACK_API + value.slice(TMDB_API.length);
        if (value.indexOf(TMDB_WORKER_API) === 0) return TMDB_FALLBACK_API + value.slice(TMDB_WORKER_API.length);
        return "";
    }

    function fetchTmdbJson(path) {
        var key = String(path || "");
        var now = Date.now();
        if (tmdbJsonCache[key] && (now - tmdbJsonCache[key].time) < CACHE_TTL) {
            return Promise.resolve(tmdbJsonCache[key].data);
        }
        if (tmdbInflight[key]) return tmdbInflight[key];
        tmdbInflight[key] = fetchJsonWithRetry(key, defaultHeaders(), 2).then(function (json) {
            if (hasMeaningfulJsonData(json)) return json;
            var fallbackPath = getTmdbFallbackPath(key);
            if (!fallbackPath || fallbackPath === key) return json || {};
            return fetchJsonWithRetry(fallbackPath, defaultHeaders(), 2);
        }).then(function (json) {
            if (hasMeaningfulJsonData(json)) {
                tmdbJsonCache[key] = { data: json || {}, time: Date.now() };
            }
            delete tmdbInflight[key];
            return json || {};
        }).catch(function () {
            delete tmdbInflight[key];
            return {};
        });
        return tmdbInflight[key];
    }

    function fetchTmdbLogoUrl(type, tmdbId) {
        if (!tmdbId) return Promise.resolve("");
        var route = type === "movie" ? "movie" : "tv";
        return fetchTmdbJson(TMDB_API + "/" + route + "/" + tmdbId + "/images?api_key=" + TMDB_LOGO_API_KEY).then(function (json) {
            var logos = (json && json.logos) || [];
            var best = null;
            var bestSvg = null;
            for (var i = 0; i < logos.length; i++) {
                var logo = logos[i];
                if (!logo || !logo.file_path) continue;
                var isSvg = /\.svg$/i.test(logo.file_path);
                if ((logo.iso_639_1 || "").toLowerCase() === "en" && !isSvg) return "https://image.tmdb.org/t/p/w500" + logo.file_path;
                if ((logo.iso_639_1 || "").toLowerCase() === "en" && isSvg && !bestSvg) bestSvg = logo;
                if (!best || Number(logo.vote_average || 0) > Number(best.vote_average || 0)) {
                    if (isSvg) bestSvg = logo;
                    else best = logo;
                }
            }
            if (best) return "https://image.tmdb.org/t/p/w500" + best.file_path;
            if (bestSvg) return "https://image.tmdb.org/t/p/w500" + bestSvg.file_path;
            return "";
        });
    }

    function normalizeTmdbTitle(value) {
        return String(value || "")
            .toLowerCase()
            .replace(/&/g, "and")
            .replace(/[^a-z0-9]+/g, " ")
            .replace(/\bseason\s*\d+\b/g, " ")
            .replace(/\s+/g, " ")
            .trim();
    }

    function getTmdbResultYear(result) {
        var date = result && (result.first_air_date || result.release_date) || "";
        var year = Number(String(date).slice(0, 4));
        return isNaN(year) ? 0 : year;
    }

    function scoreTmdbResult(result, expectedTitle, expectedYear) {
        if (!result) return -Infinity;
        var expected = normalizeTmdbTitle(expectedTitle);
        var name = normalizeTmdbTitle(result.name || result.title || result.original_name || result.original_title);
        var original = normalizeTmdbTitle(result.original_name || result.original_title);
        var score = 0;

        if (expected && name === expected) score += 200;
        else if (expected && original === expected) score += 190;
        else if (expected && name.indexOf(expected) !== -1) score += 140;
        else if (expected && original.indexOf(expected) !== -1) score += 130;
        else if (expected && expected.indexOf(name) !== -1 && name) score += 120;

        var expectedWords = expected ? expected.split(" ") : [];
        for (var i = 0; i < expectedWords.length; i++) {
            var word = expectedWords[i];
            if (word.length < 2) continue;
            if (name.indexOf(word) !== -1 || original.indexOf(word) !== -1) score += 12;
        }

        var resultYear = getTmdbResultYear(result);
        if (expectedYear && resultYear) {
            if (resultYear === expectedYear) score += 80;
            else score -= Math.min(Math.abs(resultYear - expectedYear) * 10, 60);
        }

        score += Number(result.popularity || 0) / 100;
        return score;
    }

    function chooseBestTmdbResult(results, expectedTitle, expectedYear) {
        var items = Array.isArray(results) ? results : [];
        if (!items.length) return null;
        var best = null;
        var bestScore = -Infinity;
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            var score = scoreTmdbResult(item, expectedTitle, expectedYear);
            if (score > bestScore) {
                best = item;
                bestScore = score;
            }
        }
        return best;
    }

    function searchTmdbId(mediaType, title, year) {
        return fetchTmdbJson(TMDB_WORKER_API + "/search/" + mediaType + "?api_key=" + TMDB_WORKER_API_KEY + "&query=" + encodeURIComponent(title || "")).then(function (json) {
            var best = chooseBestTmdbResult(json && json.results, title, year);
            return best && best.id ? String(best.id) : "";
        }).catch(function () { return ""; });
    }

    function findTmdbId(imdbId, type, title, year) {
        var mediaType = type === "movie" ? "movie" : "tv";
        if (imdbId) {
            return fetchTmdbJson(TMDB_WORKER_API + "/find/" + imdbId + "?api_key=" + TMDB_WORKER_API_KEY + "&external_source=imdb_id").then(function (json) {
                var results = type === "movie" ? json.movie_results : json.tv_results;
                if (results && results[0] && results[0].id) return String(results[0].id);
                return searchTmdbId(mediaType, title, year);
            }).catch(function () {
                return searchTmdbId(mediaType, title, year);
            });
        }

        return searchTmdbId(mediaType, title, year);
    }

    function fetchTmdbDetails(type, tmdbId) {
        if (!tmdbId) return Promise.resolve({});
        var mediaType = type === "movie" ? "movie" : "tv";
        return fetchTmdbJson(TMDB_WORKER_API + "/" + mediaType + "/" + tmdbId + "?api_key=" + TMDB_WORKER_API_KEY + "&append_to_response=credits");
    }

    function fetchSeasonMetadata(tmdbId, season) {
        if (!tmdbId || !season) return Promise.resolve({});
        return fetchTmdbJson(TMDB_WORKER_API + "/tv/" + tmdbId + "/season/" + season + "?api_key=" + TMDB_WORKER_API_KEY).then(function (json) {
            var out = {};
            var episodes = json && json.episodes || [];
            for (var i = 0; i < episodes.length; i++) {
                var episode = episodes[i];
                if (!episode || !episode.episode_number) continue;
                out[String(season) + "_" + String(episode.episode_number)] = {
                    title: episode.name || "",
                    overview: episode.overview || "",
                    thumbnail: episode.still_path ? (TMDB_IMAGE_BASE + episode.still_path) : "",
                    released: episode.air_date || "",
                    rating: Number(episode.vote_average || 0)
                };
            }
            return out;
        }).catch(function () {
            return {};
        });
    }

    function getSeasonEpisodeNumbers(seasonMetadata, season) {
        var numbers = [];
        var prefix = String(season) + "_";
        for (var key in (seasonMetadata || {})) {
            if (!Object.prototype.hasOwnProperty.call(seasonMetadata, key)) continue;
            if (key.indexOf(prefix) !== 0) continue;
            var episode = Number(key.slice(prefix.length));
            if (!isNaN(episode) && episode > 0) numbers.push(episode);
        }
        return numbers.sort(function (a, b) { return a - b; });
    }

    function buildLoadPayload(sourceUrl, links, context) {
        return JSON.stringify({
            sourceUrl: sourceUrl,
            links: links || [],
            title: context && context.title || "",
            type: context && context.type || "movie",
            season: context && context.season || null,
            episode: context && context.episode || null
        });
    }

    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: quality ? (source + " [" + quality + "p]") : source,
            quality: quality || undefined,
            headers: headers || {}
        });
    }

    function sourceLabelFromUrl(url) {
        var value = String(url || "").toLowerCase();
        if (/m4ulinks\.com/.test(value)) return "Movies4u [M4ULinks]";
        if (/filesdl\./.test(value)) return "Movies4u [FilesDL]";
        if (/gdfli?x|gdlink/.test(value)) return "Movies4u [GDFlix]";
        if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php/.test(value)) return "Movies4u [HubCloud]";
        if (/hubdrive\./.test(value)) return "Movies4u [HubDrive]";
        if (/filepress\.|filebee/.test(value)) return "Movies4u [Filepress]";
        if (/gofile\.io/.test(value)) return "Movies4u [Gofile]";
        if (/mdrive\.ink\//.test(value)) return "Movies4u [MDrive]";
        if (/vcloud\.zip/.test(value)) return "Movies4u [VCloud]";
        if (/fastdl\.zip/.test(value)) return "Movies4u [FastDL]";
        if (/multiup|validate\.multiup2\.workers\.dev/.test(value)) return "Cinefreak [MultiUp]";
        if (/buzzserver/.test(value)) return "Cinefreak [BuzzServer]";
        if (/streamtape/.test(value)) return "Cinefreak [StreamTape]";
        if (/neodrive|cinecloud/.test(value)) return "Cinefreak [NeoDrive]";
        if (/pixeldrain/.test(value)) return "Cinefreak [Pixeldrain]";
        return "Cinefreak";
    }

    function buildActorList(castArray) {
        var cast = [];
        for (var i = 0; i < (castArray || []).length; i++) {
            var item = castArray[i];
            if (!item || !(item.name || item.original_name)) continue;
            cast.push(new Actor({
                name: item.name || item.original_name,
                role: item.character || "",
                image: item.profile_path ? (TMDB_IMAGE_BASE + item.profile_path) : undefined
            }));
        }
        return cast;
    }

    function isDirectMediaUrl(url) {
        var val = String(url || "");
        return /\.(m3u8|mp4|mkv|avi|mov|webm)(?:[?#]|$)/i.test(val)
            || /\/api\/file\/.+/i.test(val)
            || /gofile\.io\/download/i.test(val)
            || /cloudflarestorage\.com|amazonaws\.com/i.test(val);
    }

    function looksLikeGoogleDriveUrl(url) {
        return /(?:drive|docs)\.google\.com|googleusercontent\.com/i.test(String(url || ""));
    }

    function isUsableStreamUrl(url) {
        var value = String(url || "");
        if (!/^https?:\/\//i.test(value)) return false;
        if (/gpdl\.hubcdn\.fans|tinyurl\.com\/Unblock-Ban-Site|one\.one\.one\.one|\/cdn-cgi\/challenge-platform\/|\/drive\/admin(?:[/?#]|$)|\/login(?:[/?#]|$)|t\.me\/|telegram|winexch\.com/i.test(value)) return false;
        if (isDirectMediaUrl(value)) return true;
        if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php/i.test(value)) return true;
        if (/hub\.hailmary\.lat\/[a-f0-9]+\?token=/i.test(value)) return true;
        if (/pixeldrain\.(dev|com)\/api\/file\//i.test(value)) return true;
        if (/video-downloads\.googleusercontent\.com|instant\.busycdn\.xyz|fastcdn-dl\.pages\.dev|rest\.awscdn\.rest|cdn\.[a-z0-9.-]*buzz\/|hub\.diskcdn\.buzz/i.test(value)) return true;
        if (/filepress\.|filebee/i.test(value)) return true;
        if (looksLikeGoogleDriveUrl(value)) return true;
        if (/mdrive\.ink\//i.test(value)) return true;
        if (/vcloud\.zip|fastdl\.zip/i.test(value)) return true;
        // Cinefreak file hosts: decoded generate.php links land here; treat as usable download pages
        if (/cinecloud|neodrive|hubdrive\.|buzzserver|streamtape/i.test(value)) return true;
        return false;
    }

    function isPreferredStreamUrl(url) {
        var value = String(url || "");
        if (!/^https?:\/\//i.test(value)) return false;
        if (/(\.zip(?:[?#]|$)|Complete(?:\s+Zip)?\s+File)/i.test(value)) return false;
        if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php/i.test(value)) return true;
        return isDirectMediaUrl(value)
            || /pixeldrain\.(dev|com)\/api\/file\//i.test(value)
            || /video-downloads\.googleusercontent\.com|instant\.busycdn\.xyz|fastcdn-dl\.pages\.dev|rest\.awscdn\.rest|diskcdn\.buzz|hub\.diskcdn\.buzz|hub\.hailmary\.lat/i.test(value)
            || /gofile\.io\/download/i.test(value)
            || /\/cdn-cgi\/content\?id=/i.test(value)
            || looksLikeGoogleDriveUrl(value);
    }

    function isZipLikeResult(item) {
        var url = String(item && item.url || "");
        var source = String(item && item.source || "");
        return /\.zip(?:[?#]|$)/i.test(url) || /\bzip\b/i.test(source);
    }

    function isPixeldrainResult(item) {
        return /pixeldrain\.(dev|com)\/api\/file\//i.test(String(item && item.url || ""));
    }

    function isEphemeralResolvedUrl(url) {
        return /instant\.busycdn\.xyz|hub\.diskcdn\.buzz|rest\.awscdn\.rest|video-downloads\.googleusercontent\.com|\/cdn-cgi\/content\?id=/i.test(String(url || ""));
    }

    function isInterestingExtractorUrl(url) {
        var value = String(url || "");
        if (!value) return false;
        if (/\/cdn-cgi\/challenge-platform\/|\/drive\/admin(?:[/?#]|$)|\/login(?:[/?#]|$)|t\.me\/|telegram|tinyurl\.com\/|winexch\.com/i.test(value)) return false;
        if (isDirectMediaUrl(value)) return true;
        if (looksLikeGoogleDriveUrl(value)) return true;
        return /hubcloud\.|hubdrive\.|gamerxyt\.com\/hubcloud\.php|gofile\.io|m4ulinks|filesdl\.|filepress\.|filebee|pixeldrain|buzzserver|streamtape|mediafire\.com|1fichier\.com|megaup\.net|multiup|validate\.multiup2\.workers\.dev|mdrive\.ink\/|vcloud\.zip|fastdl\.zip|instant\.busycdn\.xyz|rest\.awscdn\.rest|diskcdn|shikshakdaak/i.test(value);
    }

    function isIgnoredAnchorLink(url) {
        return /\/drive\/admin(?:[/?#]|$)|\/login(?:[/?#]|$)|t\.me\/|telegram|tinyurl\.com\/|winexch\.com|how-to-download/i.test(String(url || ""));
    }

    function isRawExtractorCandidate(url) {
        var value = String(url || "");
        if (!/^https?:\/\//i.test(value) || isIgnoredAnchorLink(value)) return false;
        return /m4ulinks|filesdl\.|hubcloud\.|gamerxyt\.com\/hubcloud\.php|hubdrive\.|filepress\.|filebee|gofile\.io|mdrive\.ink\/|vcloud\.zip|fastdl\.zip|multiup|validate\.multiup2\.workers\.dev|shikshakdaak|cinecloud|neodrive|buzzserver|streamtape/i.test(value);
    }

    function isWrapperOnlyExtractor(url) {
        return /m4ulinks/i.test(String(url || ""));
    }

    function isRelevantHubCloudAnchor(anchor) {
        var href = String(anchor && anchor.href || "");
        var text = String(anchor && anchor.text || "");
        if (!href || isIgnoredAnchorLink(href)) return false;
        return /pixeldra|pixel\.|diskcdn|awscdn|buzzserver|video-downloads\.googleusercontent\.com|instant\.busycdn\.xyz|gofile|filepress|filebee|drive\.google/i.test(href)
            || /download file|pixel|pixeldrain|fsl|s3 server|mega server|buzzserver|fslv2|gofile|filepress|filebee|drive|instant/i.test(text);
    }

    function normalizeExtractedUrl(rawValue, base) {
        var value = String(rawValue || "");
        if (!value) return "";

        value = value
            .replace(/^[\s"'`(]+/, "")
            .replace(/[\s"'`),;]+$/, "")
            .replace(/\\u002F/gi, "/")
            .replace(/\\u003A/gi, ":")
            .replace(/\\u0026/gi, "&")
            .replace(/\\\//g, "/");

        value = decodeHtmlEntities(value);

        for (var i = 0; i < 2; i++) {
            var decoded = safeDecodeURIComponent(value);
            if (decoded === value) break;
            value = decoded;
        }

        if (/^\/\//.test(value)) value = "https:" + value;
        if (/^www\./i.test(value)) value = "https://" + value;
        if (/^(?:javascript|mailto|tel|data):/i.test(value) || /^#/.test(value)) return "";

        if (!/^https?:\/\//i.test(value) && base) {
            if (/^(?:\/|\.\/|\.\.\/|\?)/.test(value) || /^[a-z0-9][^:]*\/[^:]+/i.test(value)) {
                value = absoluteUrl(base, value);
            }
        }

        return String(value || "").replace(/&amp;/gi, "&");
    }

    function addExtractedUrl(out, seen, rawValue, base) {
        var queue = [];
        var initial = normalizeExtractedUrl(rawValue, base);
        if (initial) queue.push(initial);

        for (var index = 0; index < queue.length; index++) {
            var current = queue[index];
            var fingerprint = String(current || "");
            if (!fingerprint || seen[fingerprint]) continue;
            seen[fingerprint] = true;

            if (isInterestingExtractorUrl(fingerprint)) {
                out.push(fingerprint);
            }

            var paramNames = ["url", "link", "r", "redirect", "redirect_url", "target", "destination", "dest", "to", "file", "dl"];
            for (var i = 0; i < paramNames.length; i++) {
                var nested = decodeQueryParam(fingerprint, paramNames[i]);
                if (!nested) continue;
                nested = normalizeExtractedUrl(nested, base);
                if (nested && !seen[nested]) queue.push(nested);
                var decodedNested = decodeBase64Safe(nested);
                if (decodedNested && /https?:\/\//i.test(decodedNested) && !seen[decodedNested]) {
                    queue.push(decodedNested);
                }
            }

            if (/^[A-Za-z0-9+/_-]{24,}={0,2}$/.test(fingerprint) && !/^https?:\/\//i.test(fingerprint)) {
                var decoded = decodeBase64Safe(fingerprint);
                if (decoded && !seen[decoded]) queue.push(decoded);
            }
        }
    }

    function extractInterestingExtractorUrls(html, base) {
        var source = String(html || "");
        var out = [];
        var seen = {};

        parseAnchors(source, base).forEach(function (anchor) {
            addExtractedUrl(out, seen, anchor && anchor.href, base);
        });

        var regexes = [
            /https?:\/\/[^\s"'<>\\]+/gi,
            /(?:href|src|action)\s*=\s*["']([^"']+)["']/gi,
            /(?:window\.)?location(?:\.href)?\s*=\s*["']([^"']+)["']/gi,
            /location\.replace\(\s*["']([^"']+)["']/gi,
            /window\.open\(\s*["']([^"']+)["']/gi,
            /["']((?:https?:)?\/\/[^"'<>\\]+)["']/gi,
            /"(?:url|link|file|download(?:Url)?|source|redirect(?:Url)?)"\s*:\s*"([^"]+)"/gi,
            /'(?:url|link|file|download(?:Url)?|source|redirect(?:Url)?)'\s*:\s*'([^']+)'/gi,
            /atob\(\s*["']([A-Za-z0-9+/_-]{24,}={0,2})["']\s*\)/gi
        ];

        for (var i = 0; i < regexes.length; i++) {
            var regex = regexes[i];
            var match;
            while ((match = regex.exec(source))) {
                addExtractedUrl(out, seen, match[1] || match[0], base);
            }
        }

        var quotedBase64 = /["']([A-Za-z0-9+/_-]{40,}={0,2})["']/gi;
        var base64Match;
        while ((base64Match = quotedBase64.exec(source))) {
            var decoded = decodeBase64Safe(base64Match[1]);
            if (decoded && (/https?:\/\//i.test(decoded) || /hubcloud|filepress|filebee|drive\.google|gdfli?x|gofile|pixeldrain/i.test(decoded))) {
                addExtractedUrl(out, seen, decoded, base);
            }
        }

        return uniqueBy(out, function (item) { return item; });
    }

    function cleanHubTitle(title) {
        var normalized = String(title || "")
            .replace(/\.[a-zA-Z0-9]{2,4}$/, "")
            .replace(/WEB[-_. ]?DL/gi, "WEB-DL")
            .replace(/WEB[-_. ]?RIP/gi, "WEBRIP")
            .replace(/H[ .]?265/gi, "H265")
            .replace(/H[ .]?264/gi, "H264")
            .replace(/DDP[ .]?([0-9]\.[0-9])/gi, "DDP$1");

        var parts = normalized.split(/[\s._-]+/);
        var keep = {
            "WEB-DL": true, "WEBRIP": true, "BLURAY": true, "HDRIP": true, "DVDRIP": true, "HDTV": true,
            "CAM": true, "TS": true, "BRRIP": true, "BDRIP": true, "H264": true, "H265": true, "X264": true,
            "X265": true, "HEVC": true, "AVC": true, "AAC": true, "AC3": true, "DTS": true, "MP3": true,
            "FLAC": true, "DD": true, "DDP": true, "EAC3": true, "ATMOS": true, "SDR": true, "HDR": true,
            "HDR10": true, "HDR10+": true, "DV": true, "DOLBYVISION": true, "NF": true, "CR": true
        };

        var result = [];
        for (var i = 0; i < parts.length; i++) {
            var token = String(parts[i] || "").toUpperCase();
            if (!token) continue;
            if (keep[token]) result.push(token === "DV" ? "DOLBYVISION" : token);
            else if (/^DDP\d\.\d$/.test(token)) result.push(token);
        }

        return uniqueBy(result, function (item) { return item; }).join(" ");
    }

    function flattenResults(results) {
        var out = [];
        for (var i = 0; i < (results || []).length; i++) {
            out = out.concat(results[i] || []);
        }
        return out;
    }

    function resolveFilesdl(url) {
        return getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" })).then(function (html) {
            var qualityTitle = firstMatch(html, [/<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]);
            var quality = getQualityFromText(qualityTitle) || getQualityFromText(html);
            var anchors = parseAnchors(html, baseOrigin(url));
            return Promise.all(anchors.map(function (anchor) {
                var label = String(anchor.text || "").toLowerCase();
                if (/hubcloud/.test(label)) return resolveExtractorUrl(anchor.href, "Filmyfiy");
                if (/gdfli?x/.test(label)) return resolveExtractorUrl(anchor.href, "Filmyfiy");
                if (/gofile/.test(label)) return resolveExtractorUrl(anchor.href, "Filmyfiy");
                if (/direct download|ultra fastdl|fast cloud-02/.test(label)) {
                    return request(anchor.href, { headers: defaultHeaders(), allowRedirects: false }).then(function (res) {
                        var location = res.headers.location || anchor.href;
                        return [buildStreamResult(location, "Filmyfiy [Direct Download]", {}, quality)];
                    }).catch(function () {
                        return [buildStreamResult(anchor.href, "Filmyfiy [Direct Download]", {}, quality)];
                    });
                }
                if (/fast cloud/.test(label)) {
                    return Promise.resolve([buildStreamResult(anchor.href, "Filmyfiy [Fast Cloud]", {}, quality)]);
                }
                return Promise.resolve([]);
            })).then(flattenResults);
        });
    }

    function resolveM4ulinks(url) {
        return getText(url, defaultHeaders()).then(function (html) {
            var base = baseOrigin(url);
            var blocks = [];
            var regex = /<div\b[^>]*class=["'][^"']*downloads-btns-div[^"']*["'][^>]*>([\s\S]*?)<\/div>/gi;
            var match;
            while ((match = regex.exec(html))) {
                blocks.push(match[1]);
            }
            var section = blocks.length ? blocks.join("\n") : html;
            var anchors = parseAnchors(section, base).filter(function (anchor) {
                var href = String(anchor && anchor.href || "");
                if (!href || isIgnoredAnchorLink(href)) return false;
                return true;
            });
            return Promise.all(anchors.map(function (anchor) {
                return resolveExtractorUrl(anchor.href, "M4ULinks").catch(function () {
                    return [];
                });
            })).then(flattenResults);
        });
    }

    function resolveHubCloudAnchor(anchor, ref, suffix, quality, jsHrefs) {
        var label = String(anchor.text || "").toLowerCase();
        var href = (anchor.id && jsHrefs[anchor.id]) || anchor.href;
        if (/video-downloads\.googleusercontent\.com|instant\.busycdn\.xyz|fastcdn-dl\.pages\.dev|rest\.awscdn\.rest|hub\.diskcdn\.buzz|cdn\.[a-z0-9.-]*buzz/i.test(href)) {
            return Promise.resolve([buildStreamResult(href, ref + " " + suffix, {}, quality)]);
        }
        if (/fsl server/.test(label)) return Promise.resolve([buildStreamResult(href, ref + " [FSL Server] " + suffix, {}, quality)]);
        if (/download file/.test(label)) return Promise.resolve([buildStreamResult(href, ref + " " + suffix, {}, quality)]);
        if (/buzzserver/.test(label)) {
            return request(href.replace(/\/$/, "") + "/download", {
                headers: defaultHeaders({ "Referer": href }),
                allowRedirects: false
            }).then(function (res) {
                var redirectUrl = res.headers["hx-redirect"] || res.headers.location || href;
                return [buildStreamResult(redirectUrl, ref + " [BuzzServer] " + suffix, {}, quality)];
            }).catch(function () {
                return [buildStreamResult(href, ref + " [BuzzServer] " + suffix, {}, quality)];
            });
        }
        if (/pixeldra|pixelserver|pixel server|pixeldrain/.test(label)) {
            var base = baseOrigin(href);
            var finalUrl = /download/i.test(href)
                ? href.replace(/\?download$/i, "")
                : (base + "/api/file/" + href.split("/").pop());
            return Promise.resolve([buildStreamResult(finalUrl, ref + " Pixeldrain " + suffix, {}, quality)]);
        }
        // 10Gbps resolver block removed
        if (/s3 server/.test(label)) return Promise.resolve([buildStreamResult(href, ref + " [S3 Server] " + suffix, {}, quality)]);
        if (/fslv2/.test(label)) return Promise.resolve([buildStreamResult(href, ref + " [FSLv2] " + suffix, {}, quality)]);
        if (/mega server/.test(label)) return Promise.resolve([buildStreamResult(href, ref + " [Mega Server] " + suffix, {}, quality)]);
        return resolveExtractorUrl(href, "");
    }

    function resolveHubCloud(url, refererLabel) {
        var ref = refererLabel || "HubCloud";
        var refHeaders = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        var hrefPromise = /hubcloud\.php/i.test(url)
            ? Promise.resolve(url)
            : getText(url, refHeaders).then(function (html) {
                var href = firstMatch(html, [
                    /id=["']download["'][^>]*href=["']([^"']+)["']/i,
                    /href=["']([^"']+)["'][^>]*id=["']download["']/i
                ]);
                return absoluteUrl(baseOrigin(url), href || url);
            });

        return hrefPromise.then(function (innerUrl) {
            return getText(innerUrl, refHeaders).then(function (html) {
                var size = stripTags(firstMatch(html, [/<i\b[^>]*id=["']size["'][^>]*>([\s\S]*?)<\/i>/i]));
                var header = stripTags(firstMatch(html, [/<div\b[^>]*class=["'][^"']*card-header[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]));
                var quality = getQualityFromText(header) || (header.match(/(\d{3,4})[pP]/) ? Number(header.match(/(\d{3,4})[pP]/)[1]) : 0) || 2160;
                var extras = [];
                var clean = cleanHubTitle(header);
                if (clean) extras.push("[" + clean + "]");
                if (size) extras.push("[" + size + "]");
                var suffix = extras.join(" ");
                var jsHrefs = resolveDynamicJsHrefs(html);
                var anchors = parseAnchors(html, baseOrigin(innerUrl)).filter(isRelevantHubCloudAnchor);

                return Promise.all(anchors.map(function (anchor) {
                    try {
                        return resolveHubCloudAnchor(anchor, ref, suffix, quality, jsHrefs).catch(function () {
                            return [];
                        });
                    } catch (_) {
                        return Promise.resolve([]);
                    }
                })).then(flattenResults);
            });
        });
    }

    function resolveGofile(url) {
        var idMatch = String(url || "").match(/(?:\?c=|\/d\/)([\da-zA-Z-]+)/i);
        if (!idMatch) {
            if (/gofile\.io/i.test(String(url || ""))) {
                return Promise.resolve([buildStreamResult(url, "Gofile", defaultHeaders({ "Referer": "https://gofile.io/" }), getQualityFromText(url))]);
            }
            return Promise.resolve([]);
        }
        var folderId = idMatch[1];
        var fallbackHeaders = defaultHeaders({ "Referer": "https://gofile.io/" });

        return request("https://api.gofile.io/accounts", {
            method: "POST",
            body: "",
            headers: defaultHeaders()
        }).then(function (accountRes) {
            var accountJson = parseJsonSafe(accountRes.body, {});
            var token = accountJson && accountJson.data && accountJson.data.token;
            if (!token) {
                return [buildStreamResult(url, "Gofile", fallbackHeaders, getQualityFromText(url))];
            }

            return request("https://api.gofile.io/contents/" + folderId + "?wt=4fd6sg89d7s6", {
                headers: {
                    "Authorization": "Bearer " + token,
                    "User-Agent": "Mozilla/5.0"
                },
                timeout: 15000
            }).then(function (contentsRes) {
                var json = parseJsonSafe(contentsRes.body, {});
                var children = json && json.data && json.data.children || {};
                var entries = [];
                for (var key in children) {
                    if (!Object.prototype.hasOwnProperty.call(children, key)) continue;
                    var file = children[key];
                    if (!file || !file.link) continue;
                    entries.push(buildStreamResult(file.link, "Gofile", {
                        "Cookie": "accountToken=" + token
                    }, getQualityFromText(file.name || "")));
                }
                return entries.length ? entries : [buildStreamResult(url, "Gofile", fallbackHeaders, getQualityFromText(url))];
            });
        }).catch(function () {
            return [buildStreamResult(url, "Gofile", fallbackHeaders, getQualityFromText(url))];
        });
    }

    function resolveGoogleDrive(url) {
        return Promise.resolve([buildStreamResult(url, "GDrive", {
            "Referer": "https://drive.google.com/"
        }, getQualityFromText(url))]);
    }

    function resolveFilepress(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });

        function resolveFilepressContent(contentUrl) {
            if (!contentUrl) return Promise.resolve([]);

            var contentHeaders = defaultHeaders({
                "Referer": url,
                "Origin": baseOrigin(url)
            });

            return request(contentUrl, {
                headers: contentHeaders,
                allowRedirects: false
            }).catch(function () {
                return { headers: {}, body: "", finalUrl: contentUrl };
            }).then(function (initialRes) {
                var redirectLocation = normalizeExtractedUrl(initialRes.headers.location || initialRes.headers["x-redirect-location"] || "", baseOrigin(contentUrl));
                if (redirectLocation && redirectLocation !== contentUrl) {
                    if (looksLikeGoogleDriveUrl(redirectLocation)) return resolveGoogleDrive(redirectLocation);
                    if (isDirectMediaUrl(redirectLocation)) {
                        return [buildStreamResult(redirectLocation, "Filepress", {}, getQualityFromText(redirectLocation))];
                    }
                    if (isInterestingExtractorUrl(redirectLocation)) {
                        return resolveExtractorUrl(redirectLocation, "Filepress");
                    }
                }

                return request(contentUrl, {
                    headers: contentHeaders,
                    allowRedirects: true
                }).catch(function () {
                    return initialRes;
                }).then(function (pageRes) {
                    var finalUrl = normalizeExtractedUrl(pageRes.finalUrl || contentUrl, baseOrigin(contentUrl)) || contentUrl;
                    if (looksLikeGoogleDriveUrl(finalUrl)) return resolveGoogleDrive(finalUrl);
                    if (isDirectMediaUrl(finalUrl)) {
                        return [buildStreamResult(finalUrl, "Filepress", {}, getQualityFromText(finalUrl))];
                    }

                    var pageBase = baseOrigin(finalUrl) || baseOrigin(contentUrl);
                    var candidates = extractInterestingExtractorUrls(pageRes.body || initialRes.body || "", pageBase).filter(function (candidate) {
                        return candidate && candidate !== url && candidate !== contentUrl && candidate !== finalUrl;
                    });

                    if (!candidates.length && finalUrl !== contentUrl && isInterestingExtractorUrl(finalUrl)) {
                        candidates.push(finalUrl);
                    }

                    if (!candidates.length) return [];

                    return Promise.all(candidates.map(function (candidate) {
                        if (looksLikeGoogleDriveUrl(candidate)) return resolveGoogleDrive(candidate);
                        return resolveExtractorUrl(candidate, "Filepress");
                    })).then(flattenResults);
                });
            });
        }

        return request(url, {
            headers: headers,
            allowRedirects: false
        }).catch(function () {
            return { headers: {}, body: "", finalUrl: url };
        }).then(function (initialRes) {
            var redirectLocation = normalizeExtractedUrl(initialRes.headers.location || initialRes.headers["x-redirect-location"] || "", baseOrigin(url));
            if (redirectLocation && redirectLocation !== url) {
                if (looksLikeGoogleDriveUrl(redirectLocation)) return resolveGoogleDrive(redirectLocation);
                if (isDirectMediaUrl(redirectLocation)) {
                    return [buildStreamResult(redirectLocation, "Filepress", {}, getQualityFromText(redirectLocation))];
                }
                if (isInterestingExtractorUrl(redirectLocation)) {
                    return resolveExtractorUrl(redirectLocation, "Filepress");
                }
            }

            return request(url, {
                headers: headers,
                allowRedirects: true
            }).catch(function () {
                return initialRes;
            }).then(function (pageRes) {
                var finalUrl = normalizeExtractedUrl(pageRes.finalUrl || url, baseOrigin(url)) || url;
                if (looksLikeGoogleDriveUrl(finalUrl)) return resolveGoogleDrive(finalUrl);
                if (isDirectMediaUrl(finalUrl)) {
                    return [buildStreamResult(finalUrl, "Filepress", {}, getQualityFromText(finalUrl))];
                }

                var pageBase = baseOrigin(finalUrl) || baseOrigin(url);
                var html = String(pageRes.body || initialRes.body || "");
                var candidates = extractInterestingExtractorUrls(html, pageBase).filter(function (candidate) {
                    return candidate && candidate !== url && candidate !== finalUrl;
                });

                var hiddenContentLinks = parseAnchors(html, pageBase).map(function (anchor) {
                    return anchor && anchor.href;
                }).filter(function (href) {
                    return /\/cdn-cgi\/content\?id=/i.test(String(href || ""));
                });

                for (var i = 0; i < hiddenContentLinks.length; i++) {
                    if (candidates.indexOf(hiddenContentLinks[i]) === -1) {
                        candidates.push(hiddenContentLinks[i]);
                    }
                }

                if (!candidates.length && finalUrl !== url && isInterestingExtractorUrl(finalUrl)) {
                    candidates.push(finalUrl);
                }

                if (!candidates.length) {
                    return [buildStreamResult(url, "Filepress [GDrive]", headers, getQualityFromText(url))];
                }

                return Promise.all(candidates.map(function (candidate) {
                    if (/\/cdn-cgi\/content\?id=/i.test(candidate)) {
                        return resolveFilepressContent(candidate);
                    }
                    if (looksLikeGoogleDriveUrl(candidate)) return resolveGoogleDrive(candidate);
                    return resolveExtractorUrl(candidate, "Filepress");
                })).then(flattenResults).then(function (results) {
                    if (results && results.length) return results;
                    return [buildStreamResult(url, "Filepress [GDrive]", headers, getQualityFromText(url))];
                });
            });
        });
    }

    function resolveDrivebot(link, fileName, fileSize, quality) {
        var id = decodeQueryParam(link, "id");
        var doId = (link.split("do=")[1] || "").split("==")[0];
        var bases = ["https://drivebot.sbs", "https://indexbot.site"];
        return Promise.all(bases.map(function (base) {
            var indexbotLink = base + "/download?id=" + id + "&do=" + doId;
            return request(indexbotLink, { headers: defaultHeaders(), allowRedirects: true }).then(function (res) {
                var html = res.body || "";
                var cookieHeader = res.headers["set-cookie"] || "";
                var phpsessidMatch = String(cookieHeader).match(/PHPSESSID=([^;]+)/i);
                var phpsessid = phpsessidMatch ? phpsessidMatch[1] : "";
                var token = firstMatch(html, [/formData\.append\('token', '([a-f0-9]+)'\)/i]);
                var postId = firstMatch(html, [/fetch\('\/download\?id=([a-zA-Z0-9/+]+)'/i]);
                if (!token || !postId) return [];
                return postForm(base + "/download?id=" + postId, { token: token }, {
                    "Referer": indexbotLink,
                    "Cookie": phpsessid ? ("PHPSESSID=" + phpsessid) : ""
                }, true).then(function (postRes) {
                    var downloadLink = firstMatch(postRes.body, [/url":"(.*?)"/i]).replace(/\\/g, "");
                    if (!downloadLink) return [];
                    return [buildStreamResult(downloadLink, "GDFlix[DriveBot] " + fileName + "[" + fileSize + "]", {
                        "Referer": base
                    }, quality)];
                });
            }).catch(function () {
                return [];
            });
        })).then(flattenResults);
    }

    function resolveMultiupMirror(url, fileName, fileSize, quality) {
        return getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" })).then(function (html) {
            var anchors = parseAnchors(html, baseOrigin(url)).filter(function (anchor) {
                return anchor && anchor.href && !isIgnoredAnchorLink(anchor.href);
            });
            return Promise.all(anchors.map(function (anchor) {
                var href = anchor.href;
                var label = String(anchor.text || "").toLowerCase();
                if (/gofile\.io/i.test(href) || /gofile/i.test(label)) return resolveGofile(href);
                if (/megaup\.net/i.test(href)) return Promise.resolve([buildStreamResult(href, "GDFlix[Mirror Megaup] " + fileName + "[" + fileSize + "]", {}, quality)]);
                if (/1fichier\.com/i.test(href)) return Promise.resolve([buildStreamResult(href, "GDFlix[Mirror 1fichier] " + fileName + "[" + fileSize + "]", {}, quality)]);
                if (/download-fast\//i.test(href)) return Promise.resolve([buildStreamResult(absoluteUrl(baseOrigin(url), href), "GDFlix[Mirror Direct] " + fileName + "[" + fileSize + "]", {}, quality)]);
                return Promise.resolve([]);
            })).then(flattenResults);
        }).catch(function () {
            return [];
        });
    }

    // GDFlix extractor removed by request

    function resolveHubCloudWithFallback(url, refererLabel) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return resolveHubCloud(url, refererLabel).then(function (results) {
            if (results && results.length) return results;
            return [buildStreamResult(url, refererLabel || "HubCloud", headers, getQualityFromText(url))];
        }).catch(function () {
            return [buildStreamResult(url, refererLabel || "HubCloud", headers, getQualityFromText(url))];
        });
    }

    function resolveHubDrive(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return getText(url, headers, true).then(function (html) {
            var candidates = extractInterestingExtractorUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && !/hubdrive\./i.test(candidate);
            });
            if (!candidates.length) {
                return [buildStreamResult(url, "HubDrive", headers, getQualityFromText(url))];
            }
            return Promise.all(candidates.map(function (candidate) {
                return resolveExtractorUrl(candidate, "HubDrive");
            })).then(flattenResults).then(function (results) {
                return results && results.length ? results : [buildStreamResult(url, "HubDrive", headers, getQualityFromText(url))];
            });
        }).catch(function () {
            return [buildStreamResult(url, "HubDrive", headers, getQualityFromText(url))];
        });
    }

    function resolveVcloud(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return getText(url, headers).then(function (html) {
            var hubcloudMatch = html.match(/https:\/\/gamerxyt\.com\/hubcloud\.php\?host=vcloud[^"'\s]*/i);
            if (hubcloudMatch) {
                return resolveExtractorUrl(hubcloudMatch[0], "VCloud");
            }
            var candidates = extractInterestingExtractorUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && /hubcloud\.|gdflix\.|filepress\.|g-direct\.|drive\.google/i.test(candidate);
            });
            if (candidates.length) {
                return Promise.all(candidates.map(function (candidate) {
                    return resolveExtractorUrl(candidate, "VCloud");
                })).then(flattenResults);
            }
            return [];
        }).catch(function () {
            return [];
        });
    }

    function resolveFastdl(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return getText(url, headers).then(function (html) {
            var candidates = extractInterestingExtractorUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && /hubcloud\.|gdflix\.|filepress\.|g-direct\.|drive\.google|filebee/i.test(candidate);
            });
            if (candidates.length) {
                return Promise.all(candidates.map(function (candidate) {
                    return resolveExtractorUrl(candidate, "FastDL");
                })).then(flattenResults);
            }
            return [];
        }).catch(function () {
            return [];
        });
    }

    function resolveMdrive(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return request(url, {
            headers: headers,
            allowRedirects: false
        }).catch(function () {
            return { headers: {}, body: "", finalUrl: url };
        }).then(function (initialRes) {
            var redirectLocation = normalizeExtractedUrl(initialRes.headers.location || initialRes.headers["x-redirect-location"] || "", baseOrigin(url));
            if (redirectLocation && /^https?:\/\//i.test(redirectLocation) && redirectLocation !== url) {
                return resolveExtractorUrl(redirectLocation, "MDrive");
            }

            return request(url, {
                headers: headers,
                allowRedirects: true
            }).catch(function () {
                return initialRes;
            }).then(function (pageRes) {
                var finalUrl = normalizeExtractedUrl(pageRes.finalUrl || url, baseOrigin(url)) || url;
                if (finalUrl !== url && isDirectMediaUrl(finalUrl)) {
                    return [buildStreamResult(finalUrl, "MDrive", {}, getQualityFromText(finalUrl))];
                }

                var pageBase = baseOrigin(finalUrl) || baseOrigin(url);
                var html = String(pageRes.body || initialRes.body || "");
                var candidates = extractInterestingExtractorUrls(html, pageBase).filter(function (candidate) {
                    return candidate && candidate !== url && candidate !== finalUrl;
                });

                if (!candidates.length && finalUrl && finalUrl !== url && isInterestingExtractorUrl(finalUrl)) {
                    candidates.push(finalUrl);
                }

                if (!candidates.length) {
                    return [buildStreamResult(url, "MDrive", headers, getQualityFromText(url))];
                }

                return Promise.all(candidates.map(function (candidate) {
                    if (looksLikeGoogleDriveUrl(candidate)) return resolveGoogleDrive(candidate);
                    return resolveExtractorUrl(candidate, "MDrive");
                })).then(flattenResults).then(function (results) {
                    if (results && results.length) return results;
                    return candidates.filter(function (candidate) {
                        return looksLikeGoogleDriveUrl(candidate) || /hubcloud\.|hubdrive\.|filepress\.|filebee/i.test(candidate);
                    }).map(function (candidate) {
                        var label = looksLikeGoogleDriveUrl(candidate)
                            ? "GDrive"
                            : (/hubdrive\./i.test(candidate)
                                ? "HubDrive"
                                : (/filepress\.|filebee/i.test(candidate) ? "Filepress [GDrive]" : "HubCloud"));
                        return buildStreamResult(candidate, label, headers, getQualityFromText(candidate));
                    });
                });
            });
        });
    }

    function resolvePixeldrain(url, refererLabel) {
        var ref = refererLabel || "Pixeldrain";
        var idMatch = String(url || "").match(/pixeldrain\.(dev|com)\/(?:api\/file\/|d\/|u\/|file\/)([A-Za-z0-9]+)/i);
        if (!idMatch) {
            return Promise.resolve([buildStreamResult(url, ref, {}, getQualityFromText(url))]);
        }
        var id = idMatch[2];
        return request("https://pixeldrain.com/api/file/" + id + "/info", {
            headers: { "User-Agent": "Mozilla/5.0", "Referer": "https://pixeldrain.com/" },
            allowRedirects: false
        }).then(function (res) {
            var quality = getQualityFromText(url);
            try {
                var json = parseJsonSafe(res.body, {});
                if (json && json.files && json.files.length) {
                    return json.files.map(function (file) {
                        return buildStreamResult("https://pixeldrain.com/api/file/" + file.id + "?download", ref, {}, quality);
                    });
                }
            } catch (_) {}
            return [buildStreamResult("https://pixeldrain.com/api/file/" + id + "?download", ref, {}, quality)];
        }).catch(function () {
            return [buildStreamResult("https://pixeldrain.com/api/file/" + id + "?download", ref, {}, getQualityFromText(url))];
        });
    }

    function resolveStreamtape(url, refererLabel) {
        var ref = refererLabel || "StreamTape";
        var headers = { "User-Agent": "Mozilla/5.0", "Referer": String(url || "") };
        return getText(url, headers).then(function (html) {
            var mp4Match = String(html || "").match(/(?:'|")(https?:\/\/[^'"]*\.mp4(?:\?[^'"]*)?)(?:'|")/i);
            if (mp4Match && mp4Match[1]) {
                return [buildStreamResult(mp4Match[1], ref, { "Referer": baseOrigin(url) + "/" }, getQualityFromText(url))];
            }
            var idMatch = String(url || "").match(/streamtape\.com\/(?:e|v)\/([a-zA-Z0-9]+)/i);
            if (idMatch) {
                return request("https://streamtape.com/get_video?id=" + idMatch[1], {
                    headers: headers,
                    allowRedirects: false
                }).then(function (res) {
                    var link = normalizeExtractedUrl(res.headers.location || "", baseOrigin(url));
                    if (link) return [buildStreamResult(link, ref, { "Referer": baseOrigin(url) + "/" }, getQualityFromText(url))];
                    return [buildStreamResult(url, ref, { "Referer": baseOrigin(url) + "/" }, getQualityFromText(url))];
                }).catch(function () {
                    return [buildStreamResult(url, ref, { "Referer": baseOrigin(url) + "/" }, getQualityFromText(url))];
                });
            }
            return [buildStreamResult(url, ref, { "Referer": baseOrigin(url) + "/" }, getQualityFromText(url))];
        }).catch(function () {
            return [buildStreamResult(url, ref, { "Referer": baseOrigin(url) + "/" }, getQualityFromText(url))];
        });
    }

    function resolveBuzzserver(url, refererLabel) {
        var ref = refererLabel || "BuzzServer";
        var quality = getQualityFromText(url);
        return request(String(url).replace(/\/$/, "") + "/download", {
            headers: defaultHeaders({ "Referer": url }),
            allowRedirects: false
        }).then(function (res) {
            var redirectUrl = res.headers.location || res.headers["hx-redirect"] || url;
            return [buildStreamResult(redirectUrl, ref + " [BuzzServer]", {}, quality)];
        }).catch(function () {
            return [buildStreamResult(url, ref + " [BuzzServer]", {}, quality)];
        });
    }

    function resolveNeoDriveCinecloud(url, refererLabel) {
        var ref = refererLabel || "Cinecloud";
        // CloudStream's CineCloud extractor: GET the file page, parse ALL <a[href]>,
        // match server links by their TEXT label, and for "Cloud [Resumable]" follow
        // the sub-page and grab a.download-now[href].
        var headers = defaultHeaders({ "Referer": "https://cinefreak.nl/" });
        return getText(url, headers).then(function (html) {
            var anchors = parseAnchors(html, baseOrigin(url));
            var results = [];
            var pending = [];
            for (var i = 0; i < anchors.length; i++) {
                var a = anchors[i];
                var href = a.href;
                var text = trim(a.text);
                if (!href || !/^https?:\/\//i.test(href)) continue;
                var lower = (text + " " + href).toLowerCase();
                if (/fast cloud|\[fsl\]/i.test(text)) {
                    // FSL server — direct link
                    var fslQuality = getQualityFromText(text + " " + href) || getQualityFromText(url);
                    results.push(buildStreamResult(href, buildSourceLabel(ref + " [FSL]", text + " " + href), headers, fslQuality));
                } else if (/cloud \[resumable\]/i.test(text)) {
                    // Resumable server — fetch /d/<id> sub-page, then grab the real file link:
                    // it's the "Download Now!" anchor whose href is the R2/S3 pre-signed URL
                    // (cloudflarestorage), or a "/w/<id>" instant-download link.
                    pending.push(getText(href, headers).then(function (subHtml) {
                        var dl = parseAnchors(subHtml, baseOrigin(href));
                        var picks = dl.filter(function (x) {
                            return /cloudflarestorage|\.r2\.|download-now|download now|\/w\//i.test(x.href + " " + x.text);
                        });
                        if (!picks.length) picks = dl;
                        return picks.map(function (x) {
                            var rq = getQualityFromText(x.text + " " + x.href) || getQualityFromText(url);
                            return buildStreamResult(x.href, buildSourceLabel(ref + " [ResumeCloud]", x.text + " " + x.href), headers, rq);
                        });
                    }).catch(function () { return []; }));
                }
            }
            return Promise.all(pending).then(function (subs) {
                for (var s = 0; s < subs.length; s++) {
                    for (var r = 0; r < subs[s].length; r++) results.push(subs[s][r]);
                }
                if (!results.length) {
                    // No recognised server link (file may be expired/404) — return page as last resort
                    return [buildStreamResult(url, buildSourceLabel(ref, url), headers, getQualityFromText(url))];
                }
                return uniqueBy(results, function (item) { return item.url + "|" + (item.source || ""); });
            });
        }).catch(function () {
            return [buildStreamResult(url, buildSourceLabel(ref, url), headers, getQualityFromText(url))];
        });
    }

    function withTimeout(promise, ms, label) {
        var timer;
        var timeoutPromise = new Promise(function (_, reject) {
            timer = setTimeout(function () {
                reject(new Error("Timeout after " + ms + "ms for " + (label || "request")));
            }, ms);
        });
        return Promise.race([promise, timeoutPromise]).then(function (result) {
            clearTimeout(timer);
            return result;
        }).catch(function (err) {
            clearTimeout(timer);
            throw err;
        });
    }

    function resolveExtractorUrl(url, refererLabel) {
        if (!url) return Promise.resolve([]);
        // Cinefreak wraps extractor links via generate.php?id=<base64 of real URL>.
        // IMPORTANT: the decoded URL has a junk "newgo32" suffix appended (a decoy trap
        // that 404s). CloudStream strips everything from "newgo32" onward, e.g.
        // ".../f/ad20fde7newgo32" -> ".../f/ad20fde7". Must do the same or the file 404s.
        var genMatch = String(url || "").match(/generate\.php\?id=([^&\s"']+)/i);
        if (genMatch) {
            var decoded = decodeBase64Safe(genMatch[1]);
            if (decoded && /^https?:\/\//i.test(decoded)) {
                var cut = decoded.indexOf("newgo32");
                if (cut !== -1) decoded = trim(decoded.substring(0, cut));
                return resolveExtractorUrl(decoded, refererLabel || "Cinefreak");
            }
        }
        if (isDirectMediaUrl(url)) return Promise.resolve([buildStreamResult(url, refererLabel || "Direct", {}, getQualityFromText(url))]);
        if (looksLikeGoogleDriveUrl(url)) return resolveGoogleDrive(url);
        if (/m4ulinks/i.test(url)) return withTimeout(resolveM4ulinks(url), 20000, "M4ULinks");
        if (/filesdl\./i.test(url)) return withTimeout(resolveFilesdl(url), 20000, "FilesDL");
        if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php|shikshakdaak/i.test(url)) return withTimeout(resolveHubCloudWithFallback(url, refererLabel || "HubCloud"), 25000, "HubCloud");
        if (/hubdrive\./i.test(url)) return withTimeout(resolveHubDrive(url), 20000, "HubDrive");
        if (/filepress\.|filebee/i.test(url)) return withTimeout(resolveFilepress(url), 25000, "Filepress");
        if (/pixeldrain\.(dev|com)/i.test(url)) return withTimeout(resolvePixeldrain(url, refererLabel || "Pixeldrain"), 25000, "Pixeldrain");
        if (/buzzserver/i.test(url)) return withTimeout(resolveBuzzserver(url, refererLabel || "BuzzServer"), 25000, "BuzzServer");
        if (/streamtape/i.test(url)) return withTimeout(resolveStreamtape(url, refererLabel || "StreamTape"), 25000, "StreamTape");
        if (/neodrive|cinecloud/i.test(url)) return withTimeout(resolveNeoDriveCinecloud(url, refererLabel || "NeoDrive"), 30000, "NeoDrive");
        // GDFlix route removed
        if (/validate\.multiup2\.workers\.dev|multiup/i.test(url)) return withTimeout(resolveMultiupMirror(url, "", "", getQualityFromText(url)), 25000, "MultiUp");
        if (/gofile\.io/i.test(url)) return withTimeout(resolveGofile(url), 20000, "Gofile");
        if (/mdrive\.ink\//i.test(url)) return withTimeout(resolveMdrive(url), 30000, "MDrive");
        if (/vcloud\.zip/i.test(url)) return withTimeout(resolveVcloud(url), 20000, "VCloud");
        if (/fastdl\.zip/i.test(url)) return withTimeout(resolveFastdl(url), 20000, "FastDL");
        return Promise.resolve([]);
    }

    function sortStreams(streams) {
        return streams.slice().sort(function (a, b) {
            var qa = getQualityFromText(a && a.source || "");
            var qb = getQualityFromText(b && b.source || "");
            return qb - qa;
        });
    }

    async function getHome(cb) {
        try {
            var mainUrl = await getMainUrl();
            var requests = MAIN_PAGE_SECTIONS.map(function (section) {
                var url = absoluteUrl(mainUrl + "/", section.path + (section.path ? "?pg=1" : ""));
                return { method: "GET", url: url, headers: mainPageHeaders(mainUrl) };
            });

            var responses = await http_parallel(requests);
            var results = {};
            var firstHtml = "";
            var total = 0;

            for (var i = 0; i < MAIN_PAGE_SECTIONS.length; i++) {
                var section = MAIN_PAGE_SECTIONS[i];
                var res = responses && responses[i] ? responses[i] : null;
                var html = res && typeof res.body !== "undefined" ? res.body : "";
                if (!firstHtml && html) firstHtml = html;
                var items = parseHomeCards(html, mainUrl);
                results[section.title] = items;
                total += items.length;
            }

            if (!total) {
                cb({ success: false, errorCode: "HOME_EMPTY", message: "No home items parsed. Snippet: " + snippet(firstHtml, 320) });
                return;
            }

            Analytics.logEvent('cinefreak_home', {});
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: toErrorMessage(error) });
        }
    }

    async function search(query, cb) {
        try {
            var mainUrl = await getMainUrl();
            var url = mainUrl + "/search-api.php?q=" + encodeURIComponent(query || "");
            var res = await request(url, { headers: defaultHeaders() });
            var parsed = parseJsonSafe(res.body, {});
            var data = Array.isArray(parsed) ? parsed : (parsed && parsed.results) || [];
            if (!Array.isArray(data) || !data.length) {
                cb({ success: false, errorCode: "SEARCH_EMPTY", message: "No search items parsed." });
                return;
            }

            var results = data.map(function (item) {
                var rawTitle = String(item.t || item.title || "");
                var itemSlug = String(item.l || item.href || item.slug || "");
                var itemUrl = absoluteUrl(mainUrl, itemSlug);
                if (!/^https?:\/\//i.test(itemUrl) && !/\/$/.test(itemUrl)) itemUrl += "/";
                var poster = String(item.poster || item.img || "");
                poster = poster.indexOf("http") === 0 ? poster : absoluteUrl(mainUrl, poster);
                var type = /season|series|episode|s0|full-series-download/i.test(rawTitle) ? "series" : "movie";
                return new MultimediaItem({
                    title: trim(rawTitle.split(" (")[0]),
                    url: itemUrl,
                    posterUrl: poster,
                    type: type,
                    quality: getSearchQuality(rawTitle),
                    headers: defaultHeaders({ "Referer": mainUrl + "/" })
                });
            }).filter(function (item) { return !!item.title; });

            if (!results.length) {
                cb({ success: false, errorCode: "SEARCH_EMPTY", message: "No search items parsed." });
                return;
            }
            Analytics.logEvent('cinefreak_search', {});
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: toErrorMessage(error) });
        }
    }

    async function load(url, cb) {
        try {
            var sourceUrl = String(url || "");
            var html = await getText(sourceUrl, defaultHeaders());

            var titleRaw = firstMatch(html, [/class=["'][^"']*page-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i]);
            var title = trim(stripTags(titleRaw).split("(")[0]) || "Unknown Title";
            var yearMatch = String(titleRaw || "").match(/\((\d{4})\)/);
            var year = yearMatch ? Number(yearMatch[1]) : 0;

            var plot = trim(firstMatch(html, [
                /<div\b[^>]*id=["']single_post_content["'][^>]*>\s*<p\b[^>]*>([\s\S]*?)<\/p>/i,
                /<div\b[^>]*class=["'][^"']*story-content[^"']*["'][^>]*>\s*<p\b[^>]*>([\s\S]*?)<\/p>/i
            ]).replace(/<[^>]+>/g, " ")) || "";

            var genres = parseAnchors(firstMatch(html, [/class=["'][^"']*sgeneros[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]), baseOrigin(sourceUrl))
                .map(function (a) { return trim(a.text); })
                .filter(function (g) { return !!g; });

            var posterMatch = html.match(/<img\b[^>]*class=["'][^"']*wp-post-image[^"']*["'][^>]*src=["']([^"']+)["']/i)
                || html.match(/<div\b[^>]*class=["'][^"']*post-thumbnail[^"']*["'][^>]*>\s*<img\b[^>]*src=["']([^"']+)["']/i);
            var poster = posterMatch ? absoluteUrl(baseOrigin(sourceUrl), decodeHtmlEntities(posterMatch[1])) : "";

            var hasSeries = /class=["'][^"']*ep-card[^"']*["']/i.test(html) || /class=["'][^"']*seasons?[^"']*["']/i.test(html);
            var type = hasSeries ? "series" : "movie";

            var imdbId = extractImdbId(html);
            var tmdbId = await findTmdbId(imdbId, type, title, year);
            var logoPromise = fetchTmdbLogoUrl(type, tmdbId);
            var detailsPromise = tmdbId ? fetchTmdbDetails(type, tmdbId) : Promise.resolve({});
            var tmdbDetails = await detailsPromise;
            var logoUrl = await logoPromise;

            var detailsTitle = tmdbDetails && (tmdbDetails.name || tmdbDetails.title);
            if (detailsTitle) title = detailsTitle;
            var description = (tmdbDetails && tmdbDetails.overview) || plot || "";
            var backgroundUrl = tmdbDetails && tmdbDetails.backdrop_path ? (TMDB_IMAGE_BASE + tmdbDetails.backdrop_path) : poster;
            var tmdbYear = trim((tmdbDetails && (tmdbDetails.first_air_date || tmdbDetails.release_date) || "").slice(0, 4));
            var cast = buildActorList(tmdbDetails && tmdbDetails.credits && tmdbDetails.credits.cast);
            var score = tmdbDetails && typeof tmdbDetails.vote_average === "number" ? Number(tmdbDetails.vote_average.toFixed(1)) : undefined;

            if (type === "movie") {
                // Cinefreak movie pages: <h4 class="movie-title">Label</h4> followed by
                // <div class="dlbtn-container"><a class="dlbtn dlbtn-download" href="...generate.php?id=..."></a></div>
                // Real download links are wrapped as generate.php?id=<base64>; filter out
                // same-site "related movie" cards (their URLs also contain "download").
                var movieTitleRegex = /<h4\b[^>]*class=["'][^"']*movie-title[^"']*["'][^>]*>([\s\S]*?)<\/h4>/gi;
                var labelBlocks = [];
                var mt;
                while ((mt = movieTitleRegex.exec(html))) {
                    labelBlocks.push({ label: trim(stripTags(mt[1]).replace(/<[^>]+>/g, " ")), index: mt.index });
                }
                var movieLinks = [];
                for (var i = 0; i < labelBlocks.length; i++) {
                    var start = labelBlocks[i].index;
                    var end = (i + 1 < labelBlocks.length) ? labelBlocks[i + 1].index : html.length;
                    var segment = html.slice(start, end);
                    var anchors = parseAnchors(segment, baseOrigin(sourceUrl)).filter(function (a) {
                        return /dlbtn-download/i.test(a.href + " " + a.text) || /download/i.test(a.href + " " + a.text);
                    });
                    for (var j = 0; j < anchors.length; j++) {
                        var a = anchors[j];
                        // Only keep real extractor-wrapped links (generate.php) or external hosts
                        if (!/generate\.php/i.test(a.href) && !/^https?:\/\/(?!cinefreak\.nl)/i.test(a.href)) continue;
                        var label = trim(labelBlocks[i].label + " " + a.text);
                        var quality = getQualityFromText(label + " " + a.href) || getQualityFromText(labelBlocks[i].label);
                        movieLinks.push({ label: label, href: a.href, quality: quality });
                    }
                }
                movieLinks = uniqueBy(movieLinks, function (item) { return item.href; });

                var streamPayload = buildLoadPayload(sourceUrl, movieLinks, { title: title, type: "movie" });
                Analytics.logEvent('cinefreak_load', {});
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: title,
                        url: streamPayload,
                        posterUrl: poster,
                        backgroundUrl: backgroundUrl,
                        logoUrl: logoUrl || undefined,
                        type: "movie",
                        plot: plot,
                        year: tmdbYear ? Number(tmdbYear) : (year || undefined),
                        genres: genres,
                        rating: score,
                        actors: cast,
                        headers: defaultHeaders({ "Referer": sourceUrl })
                    })
                });
                return;
            }

            // SERIES — Cinefreak structure:
            // <div class="ep-card"><div class="ep-title">Name</div>
            //   <div class="ep-meta"><span class="season-number">S01</span> ... <span class="episode-badge">Episode 01-09</span> ...</div>
            //   <div class="ep-actions"> ... <div class="quality-box download-links" id="combo-dlN">
            //       <div class="quality-grid"><a href="/generate.php?id=...">SD 480p</a> ...</div></div></div></div>
            var epCardRegex = /<div\b[^>]*class=["'][^"']*ep-card[^"']*["'][^>]*>/gi;
            var epStarts = [];
            var em;
            while ((em = epCardRegex.exec(html))) { epStarts.push(em.index); }
            if (!epStarts.length) {
                // fallback: treat each quality-box as one combined episode group
                epStarts = [0];
            }
            var episodes = [];
            for (var e = 0; e < epStarts.length; e++) {
                var epStart = epStarts[e];
                var epEnd = (e + 1 < epStarts.length) ? epStarts[e + 1] : html.length;
                var epBlock = html.slice(epStart, epEnd);

                var seasonMatch = String(epBlock).match(/class=["'][^"']*season-number[^"']*["'][^>]*>\s*S?0*(\d+)/i)
                    || String(epBlock).match(/S(\d+)/i);
                var season = seasonMatch ? Number(seasonMatch[1]) : 1;
                var epBadge = String(epBlock).match(/class=["'][^"']*episode-badge[^"']*["'][^>]*>\s*Episode\s*(\d+)(?:-(\d+))?/i);
                var episodeStart = epBadge ? Number(epBadge[1]) : (e + 1);
                var episodeEnd = (epBadge && epBadge[2]) ? Number(epBadge[2]) : episodeStart;
                var epTitle = trim(stripTags(firstMatch(epBlock, [/class=["'][^"']*ep-title[^"']*["'][^>]*>([\s\S]*?)<\/[a-z]+>/i]))) || ("Episode " + episodeStart);

                // Restrict link extraction to the download quality-box (combo-dlN)
                var dlBox = epBlock.match(/<div\b[^>]*class=["'][^"']*quality-box[^"']*download-links[^"']*["'][^>]*>([\s\S]*?)<\/div>\s*<\/div>/i);
                var linkScope = dlBox ? dlBox[1] : epBlock;
                var epAnchors = parseAnchors(linkScope, baseOrigin(sourceUrl)).filter(function (a) {
                    return /generate\.php/i.test(a.href) || /^(?!.*cinefreak\.nl)/i.test(a.href) || /download|watch/i.test(a.href + " " + a.text);
                });
                var epLinks = [];
                for (var k = 0; k < epAnchors.length; k++) {
                    var ea = epAnchors[k];
                    if (!/generate\.php/i.test(ea.href) && !/^https?:\/\/(?!cinefreak\.nl)/i.test(ea.href)) continue;
                    var elabel = trim(ea.text) || ("Link " + (k + 1));
                    var equality = getQualityFromText(elabel + " " + ea.href);
                    epLinks.push({ label: elabel, href: ea.href, quality: equality });
                }
                epLinks = uniqueBy(epLinks, function (item) { return item.href; });

                for (var epNum = episodeStart; epNum <= episodeEnd; epNum++) {
                    episodes.push(new Episode({
                        title: epTitle + (episodeStart !== episodeEnd ? " (E" + epNum + ")" : ""),
                        url: JSON.stringify({ sourceUrl: sourceUrl, title: title, type: "series", season: season, episode: epNum, links: epLinks }),
                        season: season,
                        episode: epNum,
                        thumbnail: poster,
                        plot: plot,
                        released: "",
                        rating: score
                    }));
                }
            }

            if (!episodes.length) {
                cb({ success: false, errorCode: "LOAD_EMPTY", message: "No episodes parsed. Snippet: " + snippet(html, 320) });
                return;
            }

            Analytics.logEvent('cinefreak_load', {});
            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: sourceUrl,
                    posterUrl: poster,
                    backgroundUrl: backgroundUrl,
                    logoUrl: logoUrl || undefined,
                    type: "series",
                    plot: plot,
                    year: tmdbYear ? Number(tmdbYear) : (year || undefined),
                    genres: genres,
                    rating: score,
                    actors: cast,
                    headers: defaultHeaders({ "Referer": sourceUrl }),
                    episodes: episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: toErrorMessage(error) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parseJsonSafe(url, null);
            if (Array.isArray(payload)) {
                payload = { sourceUrl: "", links: payload };
            }
            if (!payload || !payload.links || !payload.links.length) {
                if (/^https?:\/\//i.test(String(url || ""))) {
                    var html = await getText(String(url), defaultHeaders());
                    payload = {
                        sourceUrl: String(url),
                        links: extractDownloadLinks(html, baseOrigin(String(url))).map(function (l) { return { href: l }; }),
                        type: "movie",
                        title: ""
                    };
                } else {
                    cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid stream payload" });
                    return;
                }
            }

            var rawLinks = (payload.links || []).map(function (link) {
                if (typeof link === "string") return { href: link, quality: 0 };
                return { href: link.href || link.url || "", quality: Number(link.quality || 0) };
            }).filter(function (l) { return !!l.href; });

            var resolved = await Promise.all(rawLinks.map(function (link) {
                var quality = link.quality || getQualityFromText(String(link.href || "") + " " + String(payload.title || ""));
                var rawFallback = [buildStreamResult(link.href, sourceLabelFromUrl(link.href), defaultHeaders({ "Referer": payload.sourceUrl || baseOrigin(link.href) + "/" }), quality)];
                if (isDirectMediaUrl(link.href) || looksLikeGoogleDriveUrl(link.href)) {
                    return Promise.resolve(rawFallback);
                }
                return resolveExtractorUrl(link.href, "Cinefreak").then(function (results) {
                    if (results && results.length) return results;
                    if (isRawExtractorCandidate(link.href)) return rawFallback;
                    return [];
                }).catch(function () {
                    if (isRawExtractorCandidate(link.href)) return rawFallback;
                    return [];
                });
            }));

            var streams = uniqueBy(flattenResults(resolved), function (item) {
                return String(item.url || "") + "|" + JSON.stringify(item.headers || {});
            }).filter(function (item) {
                return !!(item && item.url) && isUsableStreamUrl(item.url);
            });

            var preferredStreams = streams.filter(function (item) {
                return isPreferredStreamUrl(item.url);
            });
            if (preferredStreams.length) {
                streams = preferredStreams;
            }

            Analytics.logEvent('cinefreak_loadstreams', {});
            cb({
                success: true,
                data: sortStreams(streams)
            });
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
