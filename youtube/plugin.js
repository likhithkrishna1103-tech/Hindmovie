(function () {
    "use strict";

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

    var BASE_URL = String((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://www.youtube.com").replace(/\/+$/, "");
    var MOBILE_URL = "https://m.youtube.com";
    var YOUTUBEI_BASE = "https://www.youtube.com/youtubei/v1";
    var YOUTUBEI_GAPIS_BASE = "https://youtubei.googleapis.com/youtubei/v1";
    var USER_AGENT = "com.google.android.youtube/21.03.36 (Linux; U; Android 13; en-IN) gzip";
    var ANDROID_CLIENT_VERSION = "21.03.36";
    var IOS_CLIENT_VERSION = "21.03.2";
    var IOS_USER_AGENT_VERSION = "18_7_2";
    var IOS_DEVICE_MODEL = "iPhone16,2";
    var TV_CLIENT_VERSION = "7.20230405.08.01";
    var TV_USER_AGENT = "Mozilla/5.0 (Chromecast; Google TV) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.0 Safari/537.36";
    var WEB_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
    var DEFAULT_PROVIDER_ID = "youtube_hindi";
    var LOCALE = { hl: "en", gl: "IN" };
    var SEARCH_HISTORY = {};
    var PROVIDER_CONFIGS = {
        youtube_telugu: {
            name: "Telugu",
            hl: "te",
            gl: "IN",
            language: "telugu",
            sections: [
                { title: "Trending", source: "trending", fallbackQuery: "telugu latest popular videos", type: "videos" },
                { title: "Latest Videos", query: "latest telugu videos", type: "videos" },
                { title: "Popular Channels", query: "popular telugu youtube channels", type: "channels" },
                { title: "Music", query: "latest telugu songs", type: "videos" },
                { title: "Movies & Trailers", query: "telugu movie trailers", type: "videos" },
                { title: "Comedy", query: "telugu comedy", type: "videos" },
                { title: "News", query: "telugu news today", type: "videos" },
                { title: "Playlists", query: "telugu playlists", type: "playlists" }
            ]
        },
        youtube_tamil: {
            name: "Tamil",
            hl: "ta",
            gl: "IN",
            language: "tamil",
            sections: [
                { title: "Trending", source: "trending", fallbackQuery: "tamil latest popular videos", type: "videos" },
                { title: "Latest Videos", query: "latest tamil videos", type: "videos" },
                { title: "Popular Channels", query: "popular tamil youtube channels", type: "channels" },
                { title: "Music", query: "latest tamil songs", type: "videos" },
                { title: "Movies & Trailers", query: "tamil movie trailers", type: "videos" },
                { title: "Comedy", query: "tamil comedy", type: "videos" },
                { title: "News", query: "tamil news today", type: "videos" },
                { title: "Playlists", query: "tamil playlists", type: "playlists" }
            ]
        },
        youtube_hindi: {
            name: "Hindi",
            hl: "hi",
            gl: "IN",
            language: "hindi",
            sections: [
                { title: "Trending", source: "trending", fallbackQuery: "hindi latest popular videos", type: "videos" },
                { title: "Latest Videos", query: "latest hindi videos", type: "videos" },
                { title: "Popular Channels", query: "popular hindi youtube channels", type: "channels" },
                { title: "Music", query: "latest hindi songs", type: "videos" },
                { title: "Movies & Trailers", query: "hindi movie trailers", type: "videos" },
                { title: "Comedy", query: "hindi comedy", type: "videos" },
                { title: "News", query: "hindi news today", type: "videos" },
                { title: "Playlists", query: "hindi playlists", type: "playlists" }
            ]
        },
        youtube_malayalam: {
            name: "Malayalam",
            hl: "ml",
            gl: "IN",
            language: "malayalam",
            sections: [
                { title: "Trending", source: "trending", fallbackQuery: "malayalam latest popular videos", type: "videos" },
                { title: "Latest Videos", query: "latest malayalam videos", type: "videos" },
                { title: "Popular Channels", query: "popular malayalam youtube channels", type: "channels" },
                { title: "Music", query: "latest malayalam songs", type: "videos" },
                { title: "Movies & Trailers", query: "malayalam movie trailers", type: "videos" },
                { title: "Comedy", query: "malayalam comedy", type: "videos" },
                { title: "News", query: "malayalam news today", type: "videos" },
                { title: "Playlists", query: "malayalam playlists", type: "playlists" }
            ]
        },
        youtube_kannada: {
            name: "Kannada",
            hl: "kn",
            gl: "IN",
            language: "kannada",
            sections: [
                { title: "Trending", source: "trending", fallbackQuery: "kannada latest popular videos", type: "videos" },
                { title: "Latest Videos", query: "latest kannada videos", type: "videos" },
                { title: "Popular Channels", query: "popular kannada youtube channels", type: "channels" },
                { title: "Music", query: "latest kannada songs", type: "videos" },
                { title: "Movies & Trailers", query: "kannada movie trailers", type: "videos" },
                { title: "Comedy", query: "kannada comedy", type: "videos" },
                { title: "News", query: "kannada news today", type: "videos" },
                { title: "Playlists", query: "kannada playlists", type: "playlists" }
            ]
        }
    };
    var CONFIG_CACHE = null;
    var CONFIG_PROMISE = null;
    var PAGE_CACHE = {};
    var CACHE_TTL = 5 * 60 * 1000;
    var HISTORY_STORAGE_KEY = "skystream_youtube_search_history_v1";
    var PROFILE_STORAGE_PREFIX = "skystream_youtube_profile_v1_";

    var SEARCH_FILTERS = {
        videos: "EgIQAQ%3D%3D",
        channels: "EgIQAg%3D%3D",
        playlists: "EgIQAw%3D%3D"
    };
    var CPN_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    var SUPPORTED_ITAGS = {
        17: "video", 36: "video", 18: "video", 34: "video", 35: "video", 59: "video", 78: "video", 22: "video", 37: "video", 38: "video", 43: "video", 44: "video", 45: "video", 46: "video",
        171: "audio", 172: "audio", 599: "audio", 139: "audio", 140: "audio", 141: "audio", 600: "audio", 249: "audio", 250: "audio", 251: "audio",
        160: "video-only", 394: "video-only", 133: "video-only", 395: "video-only", 134: "video-only", 396: "video-only", 135: "video-only", 212: "video-only", 397: "video-only", 136: "video-only", 398: "video-only", 298: "video-only", 137: "video-only", 399: "video-only", 299: "video-only", 400: "video-only", 266: "video-only", 401: "video-only", 278: "video-only", 242: "video-only", 243: "video-only", 244: "video-only", 245: "video-only", 246: "video-only", 247: "video-only", 248: "video-only", 271: "video-only", 272: "video-only", 302: "video-only", 303: "video-only", 308: "video-only", 313: "video-only", 315: "video-only"
    };
    var HOME_JUNK_RE = /\b(hot|sexy|sex|romantic|romance|love\s+songs?|valentine|instagram\s+reels?|insta\s+reels?|viral\s+reels?|kiss|kissing|bedroom|bold\s+scene|bikini|item\s+girl|18\+|adult|private video|deleted video)\b|रोमांटिक|प्रेम\s*गीत|लव\s*सॉन्ग|लव\s*स्टोरी/i;

    function providerId() {
        var id = String(typeof manifest !== "undefined" && manifest && manifest.providerId || DEFAULT_PROVIDER_ID).toLowerCase() || DEFAULT_PROVIDER_ID;
        return PROVIDER_CONFIGS[id] ? id : DEFAULT_PROVIDER_ID;
    }

    function providerConfig() {
        return PROVIDER_CONFIGS[providerId()] || PROVIDER_CONFIGS[DEFAULT_PROVIDER_ID];
    }

    function applyLocale(config) {
        config = config || providerConfig();
        if (LOCALE.hl !== (config.hl || "en") || LOCALE.gl !== (config.gl || "IN")) {
            CONFIG_CACHE = null;
            CONFIG_PROMISE = null;
        }
        LOCALE.hl = config.hl || "en";
        LOCALE.gl = config.gl || "IN";
    }

    function headers(extra) {
        var out = {
            "User-Agent": USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Accept-Language": "en-IN,en;q=0.9",
            "Referer": BASE_URL + "/"
        };
        Object.keys(extra || {}).forEach(function (key) { out[key] = extra[key]; });
        return out;
    }

    function jsonHeaders(extra) {
        return headers(Object.assign({
            "Accept": "application/json",
            "Content-Type": "application/json",
            "Origin": BASE_URL,
            "X-Youtube-Client-Name": "1"
        }, extra || {}));
    }

    function mobileJsonHeaders(clientName, clientVersion, userAgent) {
        return {
            "User-Agent": userAgent,
            "Accept": "application/json",
            "Accept-Language": "en-IN,en;q=0.9",
            "Content-Type": "application/json",
            "Origin": BASE_URL,
            "Referer": BASE_URL + "/",
            "X-Youtube-Client-Name": clientName,
            "X-Youtube-Client-Version": clientVersion
        };
    }

    function cleanText(value) {
        return String(value == null ? "" : value)
            .replace(/&amp;/g, "&")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/\s+/g, " ")
            .trim();
    }

    function now() {
        return Date.now ? Date.now() : new Date().getTime();
    }

    function cached(key) {
        var item = PAGE_CACHE[key];
        if (!item || now() - item.time > CACHE_TTL) return null;
        return item.value;
    }

    function cacheSet(key, value) {
        PAGE_CACHE[key] = { time: now(), value: value };
        return value;
    }

    function randomToken(length) {
        var out = "";
        for (var i = 0; i < length; i++) out += CPN_ALPHABET.charAt(Math.floor(Math.random() * CPN_ALPHABET.length));
        return out;
    }

    function generateContentPlaybackNonce() {
        return randomToken(16);
    }

    function generateTParameter() {
        return randomToken(12);
    }

    function isStreamSensitiveUrl(url) {
        url = String(url || "");
        return /\/watch\?/i.test(url)
            || /\/youtubei\/v1\/player/i.test(url)
            || /(?:^https?:\/\/)?(?:[^/]+\.)?(?:googlevideo\.com|youtube\.com\/api\/manifest)/i.test(url)
            || /\.m3u8(?:\?|$)/i.test(url)
            || /manifest\.googlevideo\.com/i.test(url);
    }

    function urlExpiry(url) {
        var match = String(url || "").match(/[?&](?:expire|expires)=([0-9]{9,})/i);
        return match ? parseInt(match[1], 10) || 0 : 0;
    }

    function isExpiredStreamUrl(url) {
        var expiry = urlExpiry(url);
        return !!expiry && expiry <= Math.floor(now() / 1000) + 60;
    }

    function shouldUseCache(url, options) {
        if (options && options.noCache) return false;
        return !isStreamSensitiveUrl(url);
    }

    function absoluteUrl(value, base) {
        value = String(value || "").trim();
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base || BASE_URL).toString();
        } catch (_) {
            return value;
        }
    }

    function normalizeImageUrl(value) {
        value = String(value || "").trim();
        if (!value) return "";
        if (value.indexOf("//") === 0) return "https:" + value;
        return value;
    }

    function getText(obj) {
        if (!obj) return "";
        if (typeof obj === "string") return obj;
        if (obj.simpleText) return obj.simpleText;
        if (obj.content) return obj.content;
        if (obj.text) return obj.text;
        if (Array.isArray(obj.runs)) {
            return obj.runs.map(function (run) { return run && (run.text || run.content) || ""; }).join("");
        }
        if (obj.accessibility && obj.accessibility.accessibilityData) return obj.accessibility.accessibilityData.label || "";
        return "";
    }

    function lastThumb(thumbnails) {
        thumbnails = Array.isArray(thumbnails) ? thumbnails : [];
        if (!thumbnails.length) return "";
        return normalizeImageUrl(thumbnails[thumbnails.length - 1].url || thumbnails[0].url || "");
    }

    function thumbsFrom(obj) {
        if (!obj) return [];
        if (obj.thumbnail && Array.isArray(obj.thumbnail.thumbnails)) return obj.thumbnail.thumbnails;
        if (obj.thumbnails && Array.isArray(obj.thumbnails)) return obj.thumbnails;
        return [];
    }

    function lockupThumbs(renderer) {
        var image = renderer && renderer.contentImage || {};
        var direct = image.thumbnailViewModel && image.thumbnailViewModel.image && image.thumbnailViewModel.image.sources;
        var collection = image.collectionThumbnailViewModel
            && image.collectionThumbnailViewModel.primaryThumbnail
            && image.collectionThumbnailViewModel.primaryThumbnail.thumbnailViewModel
            && image.collectionThumbnailViewModel.primaryThumbnail.thumbnailViewModel.image
            && image.collectionThumbnailViewModel.primaryThumbnail.thumbnailViewModel.image.sources;
        return direct || collection || [];
    }

    function parseIntSafe(value) {
        var n = parseInt(String(value || "").replace(/[^0-9]/g, ""), 10);
        return isNaN(n) ? 0 : n;
    }

    function durationMinutes(text) {
        var parts = String(text || "").split(":").map(function (x) { return parseInt(x, 10) || 0; });
        if (!parts.length) return 0;
        var seconds = 0;
        for (var i = 0; i < parts.length; i++) seconds = seconds * 60 + parts[i];
        return Math.max(0, Math.round(seconds / 60));
    }

    function videoUrl(id) {
        return BASE_URL + "/watch?v=" + encodeURIComponent(id);
    }

    function playlistUrl(id) {
        return BASE_URL + "/playlist?list=" + encodeURIComponent(id);
    }

    function channelUrl(pathOrId) {
        pathOrId = String(pathOrId || "").trim();
        if (/^https?:\/\//i.test(pathOrId)) return pathOrId;
        if (pathOrId.charAt(0) === "/") return BASE_URL + pathOrId;
        return BASE_URL + "/channel/" + encodeURIComponent(pathOrId);
    }

    function extractBalancedJson(text, marker) {
        var source = String(text || "");
        var markerIndex = source.indexOf(marker);
        if (markerIndex < 0) return null;
        var start = source.indexOf("{", markerIndex);
        if (start < 0) return null;
        var depth = 0;
        var inString = false;
        var quote = "";
        var escaped = false;
        for (var i = start; i < source.length; i++) {
            var ch = source.charAt(i);
            if (inString) {
                if (escaped) {
                    escaped = false;
                } else if (ch === "\\") {
                    escaped = true;
                } else if (ch === quote) {
                    inString = false;
                }
                continue;
            }
            if (ch === "\"" || ch === "'") {
                inString = true;
                quote = ch;
                continue;
            }
            if (ch === "{") depth++;
            else if (ch === "}") {
                depth--;
                if (depth === 0) {
                    try {
                        return JSON.parse(source.slice(start, i + 1));
                    } catch (_) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    function findValue(obj, key) {
        if (!obj || typeof obj !== "object") return null;
        if (Object.prototype.hasOwnProperty.call(obj, key)) return obj[key];
        if (Array.isArray(obj)) {
            for (var i = 0; i < obj.length; i++) {
                var arrValue = findValue(obj[i], key);
                if (arrValue) return arrValue;
            }
            return null;
        }
        var keys = Object.keys(obj);
        for (var j = 0; j < keys.length; j++) {
            var value = findValue(obj[keys[j]], key);
            if (value) return value;
        }
        return null;
    }

    function collectRenderers(obj, key, out) {
        out = out || [];
        if (!obj || typeof obj !== "object") return out;
        if (Object.prototype.hasOwnProperty.call(obj, key)) out.push(obj[key]);
        if (Array.isArray(obj)) {
            for (var i = 0; i < obj.length; i++) collectRenderers(obj[i], key, out);
            return out;
        }
        var keys = Object.keys(obj);
        for (var j = 0; j < keys.length; j++) collectRenderers(obj[keys[j]], key, out);
        return out;
    }

    async function requestText(url, requestHeaders, options) {
        var key = "GET:" + url;
        var useCache = shouldUseCache(url, options);
        var hit = useCache ? cached(key) : null;
        if (hit != null) return hit;
        if (typeof http_get === "function") {
            var res = await http_get(url, requestHeaders || headers());
            var body = String(res && res.body || "");
            return useCache ? cacheSet(key, body) : body;
        }
        if (typeof fetch === "function") {
            var response = await fetch(url, { headers: requestHeaders || headers() });
            var text = await response.text();
            return useCache ? cacheSet(key, text) : text;
        }
        throw new Error("No HTTP GET backend");
    }

    async function requestJson(url, payload, requestHeaders) {
        var body = JSON.stringify(payload || {});
        if (typeof http_post === "function") {
            try {
                var res1 = await http_post(url, requestHeaders || jsonHeaders(), body);
                return JSON.parse(String(res1 && res1.body || "{}"));
            } catch (_) {
                var res2 = await http_post(url, body, requestHeaders || jsonHeaders());
                return JSON.parse(String(res2 && res2.body || "{}"));
            }
        }
        if (typeof fetch === "function") {
            var response = await fetch(url, {
                method: "POST",
                headers: requestHeaders || jsonHeaders(),
                body: body
            });
            return response.json();
        }
        throw new Error("No HTTP POST backend");
    }

    async function httpParallelRequests(requests) {
        var items = Array.isArray(requests) ? requests.filter(function (item) { return item && item.url; }) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var parallelRes = await http_parallel(items.map(function (item) {
                    var req = {
                        method: item.method || "GET",
                        url: item.url,
                        headers: item.headers || {}
                    };
                    if (typeof item.body !== "undefined") req.body = item.body;
                    return req;
                }));
                return (parallelRes || []).map(function (res, index) {
                    return {
                        body: res && typeof res.body !== "undefined" ? String(res.body || "") : "",
                        finalUrl: res && (res.url || res.finalUrl) || items[index].url
                    };
                });
            } catch (_) {}
        }
        return Promise.all(items.map(function (item) {
            if (String(item.method || "GET").toUpperCase() === "POST") {
                return requestJson(item.url, JSON.parse(item.body || "{}"), item.headers || jsonHeaders()).then(function (json) {
                    return { body: JSON.stringify(json), finalUrl: item.url };
                }).catch(function () {
                    return { body: "", finalUrl: item.url };
                });
            }
            return requestText(item.url, item.headers || headers()).then(function (body) {
                return { body: body, finalUrl: item.url };
            }).catch(function () {
                return { body: "", finalUrl: item.url };
            });
        }));
    }

    function fallbackInnertubeKey() {
        return String.fromCharCode(65, 73, 122, 97, 83, 121, 65, 79, 95, 70, 74, 50, 83, 108, 113, 85, 56, 81, 52, 83, 84, 69, 72, 76, 71, 67, 105, 108, 119, 95, 89, 57, 95, 49, 49, 113, 99, 87, 56);
    }

    function parseConfigFromHtml(html) {
        var key = (String(html || "").match(/"INNERTUBE_API_KEY"\s*:\s*"([^"]+)"/) || [])[1]
            || (String(html || "").match(/"innertubeApiKey"\s*:\s*"([^"]+)"/) || [])[1]
            || fallbackInnertubeKey();
        var clientVersion = (String(html || "").match(/"INNERTUBE_CLIENT_VERSION"\s*:\s*"([^"]+)"/) || [])[1]
            || "2.20240508.00.00";
        var visitorData = (String(html || "").match(/"VISITOR_DATA"\s*:\s*"([^"]+)"/) || [])[1] || "";
        return { key: key, clientVersion: clientVersion, visitorData: visitorData };
    }

    async function getConfig(forceRefresh) {
        if (forceRefresh) {
            CONFIG_CACHE = null;
            CONFIG_PROMISE = null;
        }
        if (CONFIG_CACHE) return CONFIG_CACHE;
        if (CONFIG_PROMISE) return CONFIG_PROMISE;
        CONFIG_PROMISE = (async function () {
            try {
                console.log("[LOG] getConfig: Fetching config from " + BASE_URL);
                var html = await requestText(BASE_URL + "/?hl=" + LOCALE.hl + "&gl=" + LOCALE.gl, headers());
                CONFIG_CACHE = parseConfigFromHtml(html);
                console.log("[LOG] getConfig: Success. Key: " + (CONFIG_CACHE.key ? "Found" : "Missing"));
            } catch (e) {
                console.log("[LOG] getConfig: Error: " + e);
                CONFIG_CACHE = parseConfigFromHtml("");
            }
            CONFIG_PROMISE = null;
            return CONFIG_CACHE;
        })();
        return CONFIG_PROMISE;
    }

    function clientContext(config) {
        return {
            client: {
                clientName: "WEB",
                clientVersion: config.clientVersion,
                hl: LOCALE.hl,
                gl: LOCALE.gl,
                visitorData: config.visitorData || undefined
            },
            user: { lockedSafetyMode: false },
            request: { useSsl: true }
        };
    }

    async function youtubei(endpoint, payload) {
        var config = await getConfig();
        var fullPayload = Object.assign({ context: clientContext(config) }, payload || {});
        return requestJson(YOUTUBEI_BASE + "/" + endpoint + "?key=" + encodeURIComponent(config.key), fullPayload, jsonHeaders({
            "X-Youtube-Client-Version": config.clientVersion
        }));
    }

    function youtubeiRequest(endpoint, payload, config) {
        var fullPayload = Object.assign({ context: clientContext(config) }, payload || {});
        return {
            method: "POST",
            url: YOUTUBEI_BASE + "/" + endpoint + "?key=" + encodeURIComponent(config.key),
            headers: jsonHeaders({ "X-Youtube-Client-Version": config.clientVersion }),
            body: JSON.stringify(fullPayload)
        };
    }

    async function youtubeiParallel(requests) {
        var config = await getConfig();
        var responses = await httpParallelRequests((requests || []).map(function (item) {
            return youtubeiRequest(item.endpoint, item.payload, config);
        }));
        return responses.map(function (res) {
            try {
                return JSON.parse(String(res && res.body || "{}"));
            } catch (_) {
                return {};
            }
        });
    }

    function videoItem(renderer) {
        if (!renderer || !renderer.videoId) return null;
        var title = cleanText(getText(renderer.title));
        if (!title || /private video|deleted video/i.test(title)) return null;
        var duration = durationMinutes(getText(renderer.lengthText || renderer.thumbnailOverlays));
        var live = isLiveRenderer(renderer) || (!duration && /\bLIVE\b/i.test(title));
        return new MultimediaItem({
            title: title,
            url: videoUrl(renderer.videoId),
            posterUrl: lastThumb(thumbsFrom(renderer)) || undefined,
            type: live ? "livestream" : "movie",
            duration: duration,
            contentRating: cleanText(getText(renderer.ownerText || renderer.shortBylineText)) || undefined
        });
    }

    function isLiveRenderer(renderer) {
        var text = cleanText([
            getText(renderer && renderer.title),
            getText(renderer && renderer.badges),
            getText(renderer && renderer.thumbnailOverlays),
            getText(renderer && renderer.viewCountText),
            getText(renderer && renderer.shortViewCountText)
        ].join(" "));
        return /\bLIVE\b/i.test(text) || /watching now/i.test(text);
    }

    function playlistItem(renderer) {
        if (!renderer || !renderer.playlistId) return null;
        var title = cleanText(getText(renderer.title));
        if (!title) return null;
        var thumbSource = renderer.thumbnailRenderer && renderer.thumbnailRenderer.playlistVideoThumbnailRenderer || renderer;
        return new MultimediaItem({
            title: title,
            url: playlistUrl(renderer.playlistId),
            posterUrl: lastThumb(thumbsFrom(thumbSource)) || undefined,
            type: "series",
            contentRating: cleanText(getText(renderer.shortBylineText || renderer.ownerText)) || undefined
        });
    }

    function lockupCommand(renderer) {
        return renderer
            && renderer.rendererContext
            && renderer.rendererContext.commandContext
            && renderer.rendererContext.commandContext.onTap
            && renderer.rendererContext.commandContext.onTap.innertubeCommand || {};
    }

    function lockupTitle(renderer) {
        return cleanText(renderer
            && renderer.metadata
            && renderer.metadata.lockupMetadataViewModel
            && renderer.metadata.lockupMetadataViewModel.title
            && renderer.metadata.lockupMetadataViewModel.title.content);
    }

    function lockupDuration(renderer) {
        var badges = collectRenderers(renderer, "thumbnailBadgeViewModel");
        for (var i = 0; i < badges.length; i++) {
            var text = cleanText(badges[i] && badges[i].text);
            if (/^\d{1,2}:\d{2}(?::\d{2})?$/.test(text)) return durationMinutes(text);
        }
        var label = renderer && renderer.rendererContext && renderer.rendererContext.accessibilityContext && renderer.rendererContext.accessibilityContext.label;
        var match = String(label || "").match(/(\d+)\s+minutes?/i);
        return match ? parseInt(match[1], 10) || 0 : 0;
    }

    function lockupVideoItem(renderer) {
        var command = lockupCommand(renderer);
        var endpoint = command.watchEndpoint || {};
        if (!endpoint.videoId || endpoint.playlistId) return null;
        var title = lockupTitle(renderer);
        if (!title) return null;
        return new MultimediaItem({
            title: title,
            url: videoUrl(endpoint.videoId),
            posterUrl: lastThumb(lockupThumbs(renderer)) || undefined,
            type: "movie",
            duration: lockupDuration(renderer) || undefined
        });
    }

    function lockupPlaylistItem(renderer) {
        var command = lockupCommand(renderer);
        var endpoint = command.watchEndpoint || {};
        var webUrl = command.commandMetadata && command.commandMetadata.webCommandMetadata && command.commandMetadata.webCommandMetadata.url || "";
        var playlistId = endpoint.playlistId || extractPlaylistId(webUrl);
        if (!playlistId) return null;
        var title = lockupTitle(renderer);
        if (!title) return null;
        return new MultimediaItem({
            title: title,
            url: playlistUrl(playlistId),
            posterUrl: lastThumb(lockupThumbs(renderer)) || undefined,
            type: "series"
        });
    }

    function channelThumbs(renderer) {
        var sources = [];
        function add(list) {
            if (Array.isArray(list)) {
                for (var i = 0; i < list.length; i++) if (list[i] && list[i].url) sources.push(list[i]);
            }
        }
        add(renderer && renderer.thumbnail && renderer.thumbnail.thumbnails);
        add(renderer && renderer.avatar && renderer.avatar.thumbnails);
        add(renderer && renderer.channelThumbnail && renderer.channelThumbnail.thumbnails);
        add(renderer && renderer.avatarViewModel && renderer.avatarViewModel.image && renderer.avatarViewModel.image.sources);
        add(renderer && renderer.decoratedAvatarViewModel && renderer.decoratedAvatarViewModel.avatar && renderer.decoratedAvatarViewModel.avatar.avatarViewModel && renderer.decoratedAvatarViewModel.avatar.avatarViewModel.image && renderer.decoratedAvatarViewModel.avatar.avatarViewModel.image.sources);
        var imageSources = collectRenderers(renderer, "sources");
        for (var j = 0; j < imageSources.length; j++) add(imageSources[j]);
        return sources;
    }

    function channelItem(renderer) {
        if (!renderer) return null;
        var title = cleanText(getText(renderer.title));
        var path = renderer.navigationEndpoint
            && renderer.navigationEndpoint.commandMetadata
            && renderer.navigationEndpoint.commandMetadata.webCommandMetadata
            && renderer.navigationEndpoint.commandMetadata.webCommandMetadata.url;
        var id = renderer.channelId || "";
        if (!title || (!path && !id)) return null;
        return new MultimediaItem({
            title: title,
            url: channelUrl(path || id),
            posterUrl: lastThumb(channelThumbs(renderer)) || lastThumb(thumbsFrom(renderer)) || undefined,
            type: "series",
            description: cleanText(getText(renderer.descriptionSnippet)) || undefined,
            contentRating: cleanText(getText(renderer.subscriberCountText)) || undefined
        });
    }

    function compactVideoItem(renderer) {
        if (!renderer || !renderer.videoId) return null;
        var title = cleanText(getText(renderer.title));
        if (!title || /private video|deleted video/i.test(title)) return null;
        var duration = durationMinutes(getText(renderer.lengthText || renderer.thumbnailOverlays));
        var live = isLiveRenderer(renderer) || (!duration && /\bLIVE\b/i.test(title));
        return new MultimediaItem({
            title: title,
            url: videoUrl(renderer.videoId),
            posterUrl: lastThumb(thumbsFrom(renderer)) || undefined,
            type: live ? "livestream" : "movie",
            duration: duration || undefined,
            contentRating: cleanText(getText(renderer.shortBylineText || renderer.longBylineText || renderer.ownerText)) || undefined
        });
    }

    function parseItems(data, wantedProvider) {
        var out = [];
        var seen = {};
        function add(item) {
            if (!item || !item.url || seen[item.url]) return;
            seen[item.url] = true;
            out.push(item);
        }
        if (!wantedProvider || wantedProvider === "videos") collectRenderers(data, "videoRenderer").forEach(function (r) { add(videoItem(r)); });
        if (!wantedProvider || wantedProvider === "videos") collectRenderers(data, "compactVideoRenderer").forEach(function (r) { add(compactVideoItem(r)); });
        if (!wantedProvider || wantedProvider === "playlists") collectRenderers(data, "playlistRenderer").forEach(function (r) { add(playlistItem(r)); });
        if (!wantedProvider || wantedProvider === "channels") collectRenderers(data, "channelRenderer").forEach(function (r) { add(channelItem(r)); });
        if (!wantedProvider || wantedProvider === "videos") collectRenderers(data, "lockupViewModel").forEach(function (r) { add(lockupVideoItem(r)); });
        if (!wantedProvider || wantedProvider === "playlists") collectRenderers(data, "lockupViewModel").forEach(function (r) { add(lockupPlaylistItem(r)); });
        return out;
    }

    async function searchItems(query, type) {
        var filter = type ? (SEARCH_FILTERS[type] || SEARCH_FILTERS.videos) : "";
        var fullQuery = normalizeSearchQuery(query);
        try {
            var json = await youtubei("search", {
                query: fullQuery,
                params: filter ? decodeURIComponent(filter) : undefined
            });
            return parseItems(json, type || "");
        } catch (_) {
            var filterParam = filter ? "&sp=" + filter : "";
            var html = await requestText(BASE_URL + "/results?search_query=" + encodeURIComponent(fullQuery) + filterParam + "&hl=" + LOCALE.hl + "&gl=" + LOCALE.gl, headers());
            return parseItems(extractBalancedJson(html, "ytInitialData"), type || "");
        }
    }

    function storageKey(provider) {
        return "skystream_youtube_searches_" + String(provider || providerId());
    }

    function storedValueFromResponse(response, key) {
        if (response == null || response === "") return null;
        if (typeof response === "string") return response;
        if (typeof response.value !== "undefined") return response.value;
        if (typeof response[key] !== "undefined") return response[key];
        return null;
    }

    function storageNamespaceKey(key) {
        var pkg = String(typeof manifest !== "undefined" && manifest && manifest.packageName || "");
        return pkg ? pkg + ":" + key : key;
    }

    async function bridgeStorageGet(key) {
        if (typeof _dartAsyncCall === "function") {
            var value = await _dartAsyncCall("get_storage", { key: key });
            if (value == null || value === "") value = await _dartAsyncCall("get_storage", { key: storageNamespaceKey(key) });
            return value;
        }
        if (typeof getPreference === "function") {
            return getPreference(key);
        }
        return null;
    }

    function bridgeStorageSet(key, value) {
        var saved = false;
        if (typeof sendMessage === "function") {
            sendMessage("set_storage", JSON.stringify({ key: key, value: value }));
            sendMessage("set_storage", JSON.stringify({ key: storageNamespaceKey(key), value: value }));
            saved = true;
        }
        if (typeof setPreference === "function") {
            setPreference(key, value);
            saved = true;
        }
        return saved;
    }

    async function storageGet(key) {
        key = String(key || "");
        try {
            var preferred = await bridgeStorageGet(key);
            var preferredValue = storedValueFromResponse(preferred, key);
            if (preferredValue != null) return preferredValue;
        } catch (_) {}
        try {
            if (typeof get_storage === "function") {
                var stored = await get_storage({ key: key });
                var storedValue = storedValueFromResponse(stored, key);
                if (storedValue != null) return storedValue;
                var request = {};
                request[key] = "";
                stored = await get_storage(request);
                storedValue = storedValueFromResponse(stored, key);
                if (storedValue != null) return storedValue;
                stored = await get_storage(key);
                storedValue = storedValueFromResponse(stored, key);
                if (storedValue != null) return storedValue;
            }
        } catch (_) {}
        try {
            if (typeof localStorage !== "undefined" && localStorage && typeof localStorage.getItem === "function") {
                return localStorage.getItem(key);
            }
        } catch (_) {}
        return null;
    }

    async function storageSet(key, value) {
        key = String(key || "");
        value = String(value == null ? "" : value);
        var saved = false;
        try {
            saved = bridgeStorageSet(key, value) || saved;
        } catch (_) {}
        try {
            if (typeof set_storage === "function") {
                await set_storage({ key: key, value: value });
                saved = true;
            }
        } catch (_) {}
        try {
            if (typeof localStorage !== "undefined" && localStorage && typeof localStorage.setItem === "function") {
                localStorage.setItem(key, value);
                saved = true;
            }
        } catch (_) {}
        return saved;
    }

    function normalizeSearchQuery(query) {
        return cleanText(query).replace(/[^\w\s\u0900-\u097F\u0B80-\u0BFF\u0C00-\u0C7F\u0D00-\u0D7F-]/g, "").slice(0, 80);
    }

    async function readStoredHistory() {
        var stored = await storageGet(HISTORY_STORAGE_KEY);
        try {
            var parsed = JSON.parse(stored || "[]");
            return parsed && typeof parsed === "object" && !Array.isArray(parsed) ? parsed : {};
        } catch (_) {
            return {};
        }
    }

    async function writeStoredHistory(value) {
        await storageSet(HISTORY_STORAGE_KEY, JSON.stringify(value || {}));
    }

    async function readSearchHistory(provider) {
        provider = provider || providerId();
        if (SEARCH_HISTORY[provider]) return SEARCH_HISTORY[provider];
        var allHistory = await readStoredHistory();
        var stored = allHistory[provider];
        if (!Array.isArray(stored)) {
            try {
                stored = JSON.parse(await storageGet(storageKey(provider)) || "[]");
            } catch (_) {
                stored = [];
            }
        }
        SEARCH_HISTORY[provider] = Array.isArray(stored) ? stored.filter(Boolean).slice(0, 20) : [];
        return SEARCH_HISTORY[provider];
    }

    function profileKey(provider) {
        return PROFILE_STORAGE_PREFIX + String(provider || providerId());
    }

    function emptyProfile() {
        return { version: 1, searches: [], opened: [], channels: [], topics: {} };
    }

    function sanitizeProfile(profile) {
        profile = profile && typeof profile === "object" ? profile : {};
        return {
            version: 1,
            searches: Array.isArray(profile.searches) ? profile.searches.filter(Boolean).slice(0, 30) : [],
            opened: Array.isArray(profile.opened) ? profile.opened.filter(function (item) { return item && item.url; }).slice(0, 30) : [],
            channels: Array.isArray(profile.channels) ? profile.channels.filter(function (item) { return item && item.url; }).slice(0, 20) : [],
            topics: profile.topics && typeof profile.topics === "object" ? profile.topics : {}
        };
    }

    async function readProfile(provider) {
        provider = provider || providerId();
        try {
            return sanitizeProfile(JSON.parse(await storageGet(profileKey(provider)) || "{}"));
        } catch (_) {
            return emptyProfile();
        }
    }

    async function writeProfile(provider, profile) {
        await storageSet(profileKey(provider), JSON.stringify(sanitizeProfile(profile)));
    }

    function bumpTopics(profile, text, weight) {
        var stop = {
            latest: true, videos: true, video: true, youtube: true, official: true, full: true, hd: true, new: true, today: true, live: true,
            you: true, your: true, yours: true, never: true, gonna: true, give: true, with: true, from: true, this: true, that: true,
            what: true, when: true, where: true, have: true, has: true, are: true, the: true, and: true, for: true, not: true
        };
        cleanText(text).toLowerCase().split(/\s+/).forEach(function (word) {
            word = word.replace(/[^\w\u0900-\u097F\u0B80-\u0BFF\u0C00-\u0C7F\u0D00-\u0D7F-]/g, "");
            if (word.length < 3 || stop[word]) return;
            profile.topics[word] = Math.min(99, (parseInt(profile.topics[word], 10) || 0) + (weight || 1));
        });
    }

    function topTopics(profile, limit) {
        return Object.keys(profile && profile.topics || {}).sort(function (a, b) {
            return (profile.topics[b] || 0) - (profile.topics[a] || 0);
        }).slice(0, limit || 3);
    }

    function rememberListItem(list, item, limit) {
        if (!item || !item.url) return list || [];
        list = (list || []).filter(function (existing) {
            return existing && existing.url !== item.url;
        });
        list.unshift(item);
        return list.slice(0, limit || 20);
    }

    async function rememberSearch(query) {
        var provider = providerId();
        var clean = normalizeSearchQuery(query);
        if (clean.length < 2) return;
        var history = (await readSearchHistory(provider)).filter(function (item) {
            return String(item || "").toLowerCase() !== clean.toLowerCase();
        });
        history.unshift(clean);
        history = history.slice(0, 20);
        SEARCH_HISTORY[provider] = history;
        var allHistory = await readStoredHistory();
        allHistory[provider] = history;
        await writeStoredHistory(allHistory);
        await storageSet(storageKey(provider), JSON.stringify(history));
        var profile = await readProfile(provider);
        profile.searches = rememberListItem(profile.searches.map(function (text) {
            return { url: text, title: text };
        }), { url: clean, title: clean }, 30).map(function (item) { return item.title; });
        bumpTopics(profile, clean, 3);
        await writeProfile(provider, profile);
    }

    async function rememberOpenedItem(item) {
        if (!item || !item.url) return;
        var provider = providerId();
        var profile = await readProfile(provider);
        var entry = {
            title: cleanText(item.title) || "YouTube",
            url: item.url,
            type: item.type || "movie",
            posterUrl: item.posterUrl || item.bannerUrl || "",
            description: item.description || "",
            contentRating: item.contentRating || "",
            time: now()
        };
        if (/youtube\.com\/(?:@|channel\/|c\/|user\/)/i.test(entry.url) || entry.type === "series" && !extractPlaylistId(entry.url)) {
            profile.channels = rememberListItem(profile.channels, entry, 20);
        }
        profile.opened = rememberListItem(profile.opened, entry, 30);
        bumpTopics(profile, entry.title + " " + entry.description + " " + entry.contentRating, 2);
        await writeProfile(provider, profile);
    }

    async function recentSearches(provider) {
        return (await readSearchHistory(provider)).slice(0, 3);
    }

    async function relatedItemsFromVideo(url, limit) {
        var id = extractVideoId(url);
        if (!id) return [];
        try {
            var page = await videoPage(id);
            return parseItems(page.initialData, "videos").filter(function (item) {
                return item && extractVideoId(item.url) !== id;
            }).slice(0, limit || 20);
        } catch (_) {
            return [];
        }
    }

    async function channelVideoItems(url, limit) {
        try {
            var pageUrl = absoluteUrl(url, BASE_URL).replace(/\/$/, "") + "/videos?hl=" + LOCALE.hl + "&gl=" + LOCALE.gl;
            pageUrl = pageUrl.replace(/\/videos\/videos\?/, "/videos?");
            var html = await requestText(pageUrl, headers());
            return parseItems(parseInitialData(html), "videos").slice(0, limit || 20);
        } catch (_) {
            return [];
        }
    }

    async function relatedItemsFromSearchSeed(query, config, limit) {
        var seedQuery = normalizeSearchQuery(query);
        if (!seedQuery) return [];
        try {
            var seeds = await searchItems(seedQuery);
            for (var i = 0; i < seeds.length; i++) {
                if (extractVideoId(seeds[i].url)) {
                    var related = await relatedItemsFromVideo(seeds[i].url, limit || 20);
                    if (related.length) return related;
                }
                if (/youtube\.com\/(?:@|channel\/|c\/|user\/)/i.test(seeds[i].url)) {
                    var channelItems = await channelVideoItems(seeds[i].url, limit || 20);
                    if (channelItems.length) return channelItems;
                }
            }
        } catch (_) {}
        return searchItems(seedQuery + " recommended " + (config && config.language || ""), "videos").then(function (items) {
            return items.slice(0, limit || 20);
        }).catch(function () { return []; });
    }

    async function homeSearch(section, config) {
        if (section.source === "trending") return trendingItems(section, config);
        var query = section.query;
        if (section.personalized) query = section.query + " " + config.language;
        return searchItems(query, section.type || "");
    }

    async function trendingItems(section, config) {
        try {
            var html = await requestText(BASE_URL + "/feed/trending?hl=" + encodeURIComponent(config.hl || LOCALE.hl) + "&gl=" + encodeURIComponent(config.gl || LOCALE.gl), headers());
            var items = parseItems(parseInitialData(html), "videos");
            if (items.length) return items;
        } catch (_) {}
        return searchItems(section.fallbackQuery || (config.language + " latest popular videos"), section.type || "videos");
    }

    async function resolveHomeSection(section, config, seen) {
        var items = await homeSearch(section, config);
        return filterHomeItems(items, seen, section.limit || 20);
    }

    function filterHomeItems(items, seen, limit) {
        var out = [];
        (items || []).forEach(function (item) {
            if (!item || !item.url || seen[item.url] || isHomeJunk(item)) return;
            seen[item.url] = true;
            out.push(item);
        });
        return out.slice(0, limit || 20);
    }

    function isHomeJunk(item) {
        var text = cleanText((item && item.title || "") + " " + (item && item.description || "") + " " + (item && item.contentRating || ""));
        if (!item || !item.posterUrl) return true;
        return HOME_JUNK_RE.test(text);
    }

    function storedHomeItem(entry) {
        if (!entry || !entry.url || !entry.title) return null;
        return new MultimediaItem({
            title: entry.title,
            url: entry.url,
            posterUrl: entry.posterUrl || undefined,
            type: entry.type || "movie",
            description: entry.description || undefined,
            contentRating: entry.contentRating || undefined
        });
    }

    function storedHomeItems(entries, limit) {
        return (entries || []).map(storedHomeItem).filter(Boolean).slice(0, limit || 16);
    }

    async function fetchHomeSections(sections, config, concurrency) {
        sections = sections || [];
        if (!sections.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var requests = sections.map(function (section) {
                    var query = section.query;
                    if (section.personalized) query = section.query + " " + config.language;
                    var fullQuery = section.mixed ? normalizeSearchQuery(query + " " + (config.language || "")) : String(query || "");
                    var payload = { query: fullQuery };
                    if (!section.mixed) payload.params = decodeURIComponent(SEARCH_FILTERS[section.type] || SEARCH_FILTERS.videos);
                    return { endpoint: "search", payload: payload };
                });
                var jsonResults = await youtubeiParallel(requests);
                var anyItems = false;
                var mapped = sections.map(function (section, index) {
                    var items = parseItems(jsonResults[index], section.mixed ? "" : section.type || "videos");
                    if (items.length) anyItems = true;
                    return { section: section, items: items };
                });
                if (anyItems) return mapped;
            } catch (_) {}
        }
        if (typeof http_parallel === "function") {
            try {
                var pageRequests = sections.map(function (section) {
                    var query = section.query;
                    if (section.personalized) query = section.query + " " + config.language;
                    var fullQuery = section.mixed ? normalizeSearchQuery(query + " " + (config.language || "")) : String(query || "");
                    var filter = section.mixed ? "" : "&sp=" + (SEARCH_FILTERS[section.type] || SEARCH_FILTERS.videos);
                    return {
                        method: "GET",
                        url: BASE_URL + "/results?search_query=" + encodeURIComponent(fullQuery) + filter + "&hl=" + LOCALE.hl + "&gl=" + LOCALE.gl,
                        headers: headers()
                    };
                });
                var pageResponses = await httpParallelRequests(pageRequests);
                var anyPageItems = false;
                var pageMapped = sections.map(function (section, index) {
                    var items = parseItems(extractBalancedJson(pageResponses[index] && pageResponses[index].body || "", "ytInitialData"), section.mixed ? "" : section.type || "videos");
                    if (items.length) anyPageItems = true;
                    return { section: section, items: items };
                });
                if (anyPageItems) return pageMapped;
            } catch (_) {}
        }
        var results = new Array(sections.length);
        var next = 0;
        async function worker() {
            while (next < sections.length) {
                var index = next++;
                var section = sections[index];
                try {
                    results[index] = { section: section, items: await homeSearch(section, config) };
                } catch (_) {
                    results[index] = { section: section, items: [] };
                }
            }
        }
        var workers = [];
        var count = Math.min(concurrency || 3, sections.length);
        for (var i = 0; i < count; i++) workers.push(worker());
        await Promise.all(workers);
        return results;
    }

    function parseInitialData(html) {
        return extractBalancedJson(html, "ytInitialData") || {};
    }

    function parsePlayerResponse(html) {
        return extractBalancedJson(html, "ytInitialPlayerResponse") || {};
    }

    function extractVideoId(url) {
        url = String(url || "");
        var match = url.match(/[?&]v=([A-Za-z0-9_-]{11})/i)
            || url.match(/youtu\.be\/([A-Za-z0-9_-]{11})/i)
            || url.match(/\/(?:embed|shorts|live|v)\/([A-Za-z0-9_-]{11})/i);
        return match ? match[1] : "";
    }

    function extractPlaylistId(url) {
        var match = String(url || "").match(/[?&]list=([A-Za-z0-9_-]+)/i);
        return match ? match[1] : "";
    }

    async function videoPage(videoId) {
        var url = videoUrl(videoId) + "&hl=" + LOCALE.hl + "&gl=" + LOCALE.gl;
        var html = await requestText(url, headers());
        return { html: html, player: parsePlayerResponse(html), initialData: parseInitialData(html) };
    }

    function episodeFromVideoRenderer(renderer, index) {
        var item = videoItem(renderer);
        if (!item) return null;
        return new Episode({
            name: item.title,
            url: item.url,
            season: 1,
            episode: index + 1,
            posterUrl: item.posterUrl,
            runtime: item.duration || undefined
        });
    }

    function episodeFromLockup(renderer, index) {
        var item = lockupVideoItem(renderer);
        if (!item) return null;
        return new Episode({
            name: item.title,
            url: item.url,
            season: 1,
            episode: index + 1,
            posterUrl: item.posterUrl,
            runtime: item.duration || undefined
        });
    }

    function episodeFromPlaylistRenderer(renderer, index) {
        if (!renderer || !renderer.videoId) return null;
        var title = cleanText(getText(renderer.title));
        if (!title || /private video|deleted video/i.test(title)) return null;
        return new Episode({
            name: title,
            url: videoUrl(renderer.videoId),
            season: 1,
            episode: index + 1,
            posterUrl: lastThumb(thumbsFrom(renderer)) || undefined,
            runtime: durationMinutes(getText(renderer.lengthText)) || undefined
        });
    }

    async function loadVideo(url, cb) {
        var id = extractVideoId(url);
        if (!id) return cb({ success: false, errorCode: "INVALID_URL", message: "Invalid YouTube video URL" });
        var page = await videoPage(id);
        var details = page.player.videoDetails || {};
        var microformat = page.player.microformat && page.player.microformat.playerMicroformatRenderer || {};
        var title = cleanText(details.title || getText(microformat.title)) || "YouTube Video";
        var poster = lastThumb(details.thumbnail && details.thumbnail.thumbnails || microformat.thumbnail && microformat.thumbnail.thumbnails || []);
        var uploader = cleanText(details.author || microformat.ownerChannelName);
        var live = isLivePlayer(page.player);
        cb({
            success: true,
            data: new MultimediaItem({
                title: title,
                url: videoUrl(id),
                posterUrl: poster || undefined,
                bannerUrl: poster || undefined,
                description: cleanText(details.shortDescription || getText(microformat.description)) || undefined,
                type: live ? "livestream" : "movie",
                duration: Math.round((parseInt(details.lengthSeconds, 10) || 0) / 60) || undefined,
                contentRating: uploader || undefined,
                episodes: [
                    new Episode({
                        name: title,
                        url: videoUrl(id),
                        season: 1,
                        episode: 1,
                        posterUrl: poster || undefined,
                        runtime: Math.round((parseInt(details.lengthSeconds, 10) || 0) / 60) || undefined
                    })
                ]
            })
        });
    }

    async function loadPlaylist(url, cb) {
        var html = await requestText(absoluteUrl(url, BASE_URL) + "&hl=" + LOCALE.hl + "&gl=" + LOCALE.gl, headers());
        var data = parseInitialData(html);
        var metadata = findValue(data, "playlistMetadataRenderer") || {};
        var videos = collectRenderers(data, "playlistVideoRenderer")
            .map(function (renderer, index) { return episodeFromPlaylistRenderer(renderer, index); })
            .filter(Boolean);
        if (!videos.length) return cb({ success: false, errorCode: "NO_EPISODES", message: "No playlist videos found" });
        var sidebar = findValue(data, "playlistSidebarPrimaryInfoRenderer") || {};
        cb({
            success: true,
            data: new MultimediaItem({
                title: cleanText(metadata.title || getText(sidebar.title)) || "YouTube Playlist",
                url: absoluteUrl(url, BASE_URL),
                posterUrl: videos[0] && videos[0].posterUrl || undefined,
                type: "series",
                description: cleanText(metadata.description || getText(sidebar.description)) || undefined,
                episodes: videos
            })
        });
    }

    async function loadChannel(url, cb) {
        var pageUrl = absoluteUrl(url, BASE_URL).replace(/\/$/, "") + "/videos?hl=" + LOCALE.hl + "&gl=" + LOCALE.gl;
        pageUrl = pageUrl.replace(/\/videos\/videos\?/, "/videos?");
        var html = await requestText(pageUrl, headers());
        var data = parseInitialData(html);
        var meta = findValue(data, "channelMetadataRenderer") || {};
        var header = findValue(data, "c4TabbedHeaderRenderer") || findValue(data, "pageHeaderRenderer") || {};
        var episodeIndex = 0;
        var videos = collectRenderers(data, "videoRenderer")
            .map(function (renderer) { return episodeFromVideoRenderer(renderer, episodeIndex++); })
            .concat(collectRenderers(data, "lockupViewModel").map(function (renderer) { return episodeFromLockup(renderer, episodeIndex++); }))
            .filter(Boolean);
        if (!videos.length) return cb({ success: false, errorCode: "NO_EPISODES", message: "No channel videos found" });
        var title = cleanText(meta.title || getText(header.title)) || "YouTube Channel";
        var avatar = lastThumb(meta.avatar && meta.avatar.thumbnails || header.avatar && header.avatar.thumbnails || []);
        cb({
            success: true,
            data: new MultimediaItem({
                title: title,
                url: absoluteUrl(url, BASE_URL),
                posterUrl: avatar || videos[0].posterUrl || undefined,
                bannerUrl: lastThumb(header.banner && header.banner.thumbnails || []) || undefined,
                type: "series",
                description: cleanText(meta.description) || undefined,
                contentRating: cleanText(getText(header.subscriberCountText)) || undefined,
                episodes: videos
            })
        });
    }

    async function getHome(cb) {
        try {
            var config = providerConfig();
            applyLocale(config);
            var data = {};
            var seen = {};
            var sections = config.sections || [];
            var profile = await readProfile(providerId());

            var initialPromises = [];
            if (sections.length) {
                initialPromises.push(resolveHomeSection(sections[0], config, seen).then(function(items) {
                    if (items.length) return { key: sections[0].title, items: items };
                }));
            }
            initialPromises.push(Promise.resolve(filterHomeItems(storedHomeItems(profile.opened, 12), seen, 12)).then(function(items) {
                if (items.length) return { key: "Recently Opened", items: items };
            }));

            var results1 = await Promise.all(initialPromises);
            results1.filter(Boolean).forEach(function(r) { data[r.key] = r.items; });

            var morePromises = [];
            if (profile.channels && profile.channels.length) {
                morePromises.push(channelVideoItems(profile.channels[0].url, 16).then(function(items) {
                    var filtered = filterHomeItems(items, seen, 16);
                    if (filtered.length) return { key: "More From Your Channels", items: filtered };
                }));
            }

            for (var o = 0; o < Math.min(2, profile.opened.length); o++) {
                (function(entry) {
                    if (extractVideoId(entry.url)) {
                        morePromises.push(relatedItemsFromVideo(entry.url, 16).then(function(items) {
                            var filtered = filterHomeItems(items, seen, 16);
                            if (filtered.length) return { key: "Because You Watched: " + entry.title, items: filtered };
                        }));
                    }
                })(profile.opened[o]);
            }

            var results2 = await Promise.all(morePromises);
            results2.filter(Boolean).forEach(function(r) { data[r.key] = r.items; });

            var searches = await recentSearches(providerId());
            var topics = topTopics(profile, 2);
            var interestPromises = [];

            searches.forEach(function(q) {
                interestPromises.push(relatedItemsFromSearchSeed(q, config, 16).then(function(items) {
                    var filtered = filterHomeItems(items, seen, 16);
                    if (filtered.length) return { key: "Inspired By Your Search: " + q, items: filtered };
                }));
            });

            topics.forEach(function(t) {
                interestPromises.push(relatedItemsFromSearchSeed(t, config, 16).then(function(items) {
                    var filtered = filterHomeItems(items, seen, 16);
                    if (filtered.length) return { key: "Recommended For You: " + t, items: filtered };
                }));
            });

            var results3 = await Promise.all(interestPromises);
            results3.filter(Boolean).forEach(function(r) { data[r.key] = r.items; });

            var queuedSections = sections.slice(1);
            var resolvedSections = await fetchHomeSections(queuedSections, config, 3);
            for (var r = 0; r < resolvedSections.length; r++) {
                var resolved = resolvedSections[r] || {};
                var resolvedSection = resolved.section || {};
                var resolvedItems = filterHomeItems(resolved.items, seen, resolvedSection.limit || 20);
                if (resolvedItems.length) data[resolvedSection.title] = resolvedItems;
            }

            if (!Object.keys(data).length) {
                data.Trending = filterHomeItems(await trendingItems({
                    title: "Trending",
                    source: "trending",
                    fallbackQuery: config.language + " latest popular videos",
                    type: "videos"
                }, config), seen, 20);
            }
            Analytics.logEvent('youtube_home', {});
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var config = providerConfig();
            applyLocale(config);
            await rememberSearch(query);
            Analytics.logEvent('youtube_search', {});
            cb({ success: true, data: await searchItems(query, "") });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            applyLocale(providerConfig());
            var value = String(url || "");
            var wrapped = function (result) {
                cb(result);
                if (result && result.success && result.data) {
                    rememberOpenedItem(result.data).catch(function () {});
                }
            };
        if (extractPlaylistId(value)) return loadPlaylist(value, wrapped);
        if (/youtube\.com\/(?:@|channel\/|c\/|user\/)/i.test(value)) return loadChannel(value, wrapped);
        Analytics.logEvent('youtube_load', {});
        return loadVideo(value, wrapped);
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    function parseQuery(value) {
        var out = {};
        String(value || "").split("&").forEach(function (part) {
            var eq = part.indexOf("=");
            if (eq < 0) return;
            var key = part.slice(0, eq);
            var val = part.slice(eq + 1);
            try {
                out[decodeURIComponent(key)] = decodeURIComponent(val.replace(/\+/g, " "));
            } catch (_) {
                out[key] = val;
            }
        });
        return out;
    }

    function normalizeCodec(codec) {
        codec = String(codec || "").toLowerCase();
        if (!codec) return "";
        if (codec.indexOf("av01") === 0) return "AV1";
        if (codec.indexOf("vp9") === 0) return "VP9";
        if (codec.indexOf("avc1") === 0 || codec.indexOf("h264") === 0) return "H264";
        if (codec.indexOf("hev1") === 0 || codec.indexOf("hvc1") === 0 || codec.indexOf("hevc") === 0) return "H265";
        return codec.split(".")[0].toUpperCase();
    }

    function formatQuality(format) {
        var quality = parseInt(format && format.height, 10) || 0;
        if (quality) return quality;
        return parseInt(String(format && format.qualityLabel || "").replace(/[^0-9]/g, ""), 10) || 0;
    }

    function appendQueryParam(url, key, value) {
        if (!url || value == null || value === "") return url;
        return url + (url.indexOf("?") === -1 ? "?" : "&") + encodeURIComponent(key) + "=" + encodeURIComponent(value);
    }

    function itagType(format) {
        var itag = parseInt(format && format.itag, 10) || 0;
        return SUPPORTED_ITAGS[itag] || "";
    }

    function streamUrlFromFormat(format) {
        if (format.url) return format.url;
        var cipher = format.signatureCipher || format.cipher || "";
        if (!cipher) return "";
        var params = parseQuery(cipher);
        if (params.url && !params.s) return params.url;
        return "";
    }

    function newpipeStreamUrlFromFormat(format, cpn) {
        var url = streamUrlFromFormat(format);
        if (!url || isExpiredStreamUrl(url)) return "";
        return appendQueryParam(url, "cpn", cpn);
    }

    function isMuxed(format) {
        var mime = String(format.mimeType || "");
        return mime.indexOf("video/") !== -1 && (mime.indexOf("audio") !== -1 || (mime.indexOf("codecs") !== -1 && mime.indexOf(",") !== -1));
    }

    function isVideoOnly(format) {
        var mime = String(format && format.mimeType || "");
        return mime.indexOf("video/") !== -1 && mime.indexOf("audio") === -1;
    }

    function isAudioOnly(format) {
        var mime = String(format && format.mimeType || "");
        return mime.indexOf("audio/") !== -1;
    }

    function audioLangBase(value) {
        return String(value || "und").toLowerCase().split(/[.-]/)[0] || "und";
    }

    function audioFormatScore(format) {
        var itag = parseInt(format && format.itag, 10) || 0;
        var bitrate = parseInt(format && (format.bitrate || format.averageBitrate), 10) || 0;
        var codec = normalizeCodec((String(format && format.mimeType || "").match(/codecs="([^"]+)"/) || [])[1]);
        var codecScore = codec === "OPUS" ? 40 : codec === "MP4A" ? 30 : 0;
        var itagScore = { 251: 60, 250: 50, 140: 45, 249: 40, 141: 35, 139: 20, 600: 15, 599: 10 };
        return (itagScore[itag] || 0) + codecScore + Math.floor(bitrate / 10000);
    }

    function audioTrackRank(item) {
        var lang = audioLangBase(item && item.lang);
        var label = String(item && item.label || "").toLowerCase();
        var preferred = { hi: 90, en: 85, te: 80, ta: 75, ml: 70 };
        var score = preferred[lang] || 10;
        if (/original|default/.test(label)) score += 100;
        if (/dubbed|descriptive|commentary/.test(label)) score -= 25;
        return score + (item && item._score || 0);
    }

    function compactAudioTracks(tracks) {
        var preferredOrder = { hi: 0, en: 1, te: 2, ta: 3, ml: 4 };
        var bestByLang = {};
        (tracks || []).forEach(function (track) {
            if (!track || !track.url) return;
            var lang = audioLangBase(track.lang);
            var existing = bestByLang[lang];
            if (!existing || audioTrackRank(track) > audioTrackRank(existing)) bestByLang[lang] = track;
        });
        var preferred = Object.keys(preferredOrder).filter(function (lang) {
            return !!bestByLang[lang];
        }).map(function (lang) {
            return bestByLang[lang];
        }).sort(function (a, b) {
            return preferredOrder[a.lang] - preferredOrder[b.lang];
        });
        var selected = preferred.length ? preferred : Object.keys(bestByLang).map(function (lang) {
            return bestByLang[lang];
        }).sort(function (a, b) {
            return audioTrackRank(b) - audioTrackRank(a);
        }).slice(0, 5);
        return selected.map(function (track) {
            delete track._score;
            return track;
        });
    }

    function audioTracksFromNewPipeFormats(formats, cpn) {
        var tracks = (formats || []).filter(function (format) {
            return itagType(format) === "audio" || isAudioOnly(format);
        }).map(function (format) {
            var url = newpipeStreamUrlFromFormat(format, cpn);
            if (!url) return null;
            var codec = normalizeCodec((String(format.mimeType || "").match(/codecs="([^"]+)"/) || [])[1]);
            var audioTrack = format.audioTrack || {};
            var lang = audioTrack.id || format.language || "und";
            return {
                url: url,
                label: cleanText(audioTrack.displayName || format.quality || format.audioQuality || codec || "Audio"),
                lang: audioLangBase(lang),
                headers: { "User-Agent": USER_AGENT, "Referer": BASE_URL + "/" },
                _score: audioFormatScore(format)
            };
        }).filter(Boolean);
        return compactAudioTracks(tracks);
    }

    function buildStream(format, sourceName) {
        var url = streamUrlFromFormat(format);
        if (!url || isExpiredStreamUrl(url)) return null;
        var quality = formatQuality(format);
        var codec = normalizeCodec((String(format.mimeType || "").match(/codecs="([^"]+)"/) || [])[1]);
        var label = cleanText(sourceName + (quality ? " " + quality + "p" : "") + (codec ? " " + codec : ""));
        return new StreamResult({
            url: url,
            source: label,
            quality: quality || undefined,
            headers: {
                "User-Agent": USER_AGENT,
                "Referer": BASE_URL + "/"
            }
        });
    }

    function buildNewPipeStream(format, sourceName, cpn, subtitles) {
        var url = newpipeStreamUrlFromFormat(format, cpn);
        if (!url) return null;
        var quality = formatQuality(format);
        var codec = normalizeCodec((String(format.mimeType || "").match(/codecs="([^"]+)"/) || [])[1]);
        var label = cleanText(sourceName + (quality ? " " + quality + "p" : "") + (codec ? " " + codec : ""));
        var stream = new StreamResult({
            url: url,
            source: label,
            quality: quality || undefined,
            headers: {
                "User-Agent": USER_AGENT,
                "Referer": BASE_URL + "/"
            }
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    function buildNewPipeVideoOnlyStream(format, sourceName, audioTracks, cpn, subtitles) {
        if (!audioTracks || !audioTracks.length) return null;
        var stream = buildNewPipeStream(format, sourceName, cpn, subtitles);
        if (!stream) return null;
        stream.audioTracks = audioTracks;
        return stream;
    }

    function base64Encode(value) {
        value = String(value || "");
        try {
            if (typeof btoa === "function") return btoa(unescape(encodeURIComponent(value)));
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(value, "utf8").toString("base64");
        } catch (_) {}
        return value;
    }

    function magicM3u8(body) {
        return "magic_m3u8:" + base64Encode(body);
    }

    function hlsAttribute(line, name) {
        return hlsAttributes(line)[String(name || "").toUpperCase()] || "";
    }

    function hlsAttributes(line) {
        var attrs = {};
        var text = String(line || "");
        var colon = text.indexOf(":");
        if (colon >= 0) text = text.slice(colon + 1);
        var key = "";
        var value = "";
        var readingKey = true;
        var quoted = false;
        function flush() {
            var cleanKey = key.trim().toUpperCase();
            if (!cleanKey) return;
            var cleanValue = value.trim();
            if (cleanValue.charAt(0) === "\"" && cleanValue.charAt(cleanValue.length - 1) === "\"") {
                cleanValue = cleanValue.slice(1, -1);
            }
            attrs[cleanKey] = cleanValue;
            key = "";
            value = "";
            readingKey = true;
            quoted = false;
        }
        for (var i = 0; i < text.length; i++) {
            var ch = text.charAt(i);
            if (readingKey) {
                if (ch === "=") {
                    readingKey = false;
                } else if (ch !== ",") {
                    key += ch;
                }
                continue;
            }
            if (ch === "\"") {
                quoted = !quoted;
                value += ch;
            } else if (ch === "," && !quoted) {
                flush();
            } else {
                value += ch;
            }
        }
        flush();
        return attrs;
    }

    function hlsQuality(line) {
        var resolution = hlsAttribute(line, "RESOLUTION");
        var match = resolution.match(/x(\d+)/i);
        return match ? parseInt(match[1], 10) || 0 : 0;
    }

    function hlsCodecRank(line) {
        var codecs = hlsAttribute(line, "CODECS").toLowerCase();
        if (codecs.indexOf("avc1") !== -1 || codecs.indexOf("h264") !== -1) return 4;
        if (codecs.indexOf("hev1") !== -1 || codecs.indexOf("hvc1") !== -1) return 3;
        if (codecs.indexOf("vp09") !== -1 || codecs.indexOf("vp9") !== -1) return 2;
        if (codecs.indexOf("av01") !== -1) return 1;
        return 0;
    }

    function hlsCodecLabel(line) {
        var codecs = hlsAttribute(line, "CODECS").toLowerCase();
        if (codecs.indexOf("avc1") !== -1 || codecs.indexOf("h264") !== -1) return "H264";
        if (codecs.indexOf("hev1") !== -1 || codecs.indexOf("hvc1") !== -1) return "H265";
        if (codecs.indexOf("vp09") !== -1 || codecs.indexOf("vp9") !== -1) return "VP9";
        if (codecs.indexOf("av01") !== -1) return "AV1";
        return "";
    }

    function isHlsTrickPlay(line) {
        var text = String(line || "");
        return /^#EXT-X-I-FRAME-STREAM-INF/i.test(text)
            || /I-FRAMES-ONLY/i.test(text);
    }

    function hlsDefineVariables(lines) {
        var variables = {};
        (lines || []).forEach(function (line) {
            line = String(line || "").trim();
            if (!/^#EXT-X-DEFINE:/i.test(line)) return;
            var attrs = hlsAttributes(line);
            var name = attrs.NAME || "";
            if (name) variables[name] = attrs.VALUE || "";
        });
        return variables;
    }

    function replaceHlsVariables(value, variables) {
        value = String(value || "");
        return value.replace(/\{\$([A-Za-z0-9_-]+)\}/g, function (_, name) {
            return Object.prototype.hasOwnProperty.call(variables || {}, name) ? variables[name] : "";
        });
    }

    function absolutizeHlsUri(line, masterUrl, variables) {
        return String(line || "").replace(/URI="([^"]+)"/i, function (_, uri) {
            return 'URI="' + absoluteUrl(replaceHlsVariables(uri, variables), masterUrl) + '"';
        });
    }

    function hlsMediaUrl(line) {
        return hlsAttribute(line, "URI");
    }

    function collectHlsMedia(lines, masterUrl, variables) {
        return lines.map(function (line) {
            return String(line || "").trim();
        }).filter(function (line) {
            return /^#EXT-X-MEDIA:/i.test(line);
        }).map(function (line) {
            return absolutizeHlsUri(line, masterUrl, variables);
        });
    }

    function matchingMediaLines(mediaLines, variantLine) {
        var audioGroup = hlsAttribute(variantLine, "AUDIO");
        var subtitlesGroup = hlsAttribute(variantLine, "SUBTITLES");
        return mediaLines.filter(function (line) {
            var type = hlsAttribute(line, "TYPE").toUpperCase();
            var groupId = hlsAttribute(line, "GROUP-ID");
            if (type === "AUDIO") return !!audioGroup && groupId === audioGroup;
            if (type === "SUBTITLES") return !!subtitlesGroup && groupId === subtitlesGroup;
            return false;
        });
    }

    function preferredHlsLang(line) {
        return audioLangBase(hlsAttribute(line, "LANGUAGE") || hlsAttribute(line, "YT-EXT-AUDIO-CONTENT-ID") || hlsAttribute(line, "NAME"));
    }

    function compactHlsMediaLines(mediaLines) {
        var preferredOrder = { hi: 0, en: 1, te: 2, ta: 3, ml: 4, kn: 5 };
        var byType = {};
        (mediaLines || []).forEach(function (line) {
            var type = hlsAttribute(line, "TYPE").toUpperCase() || "OTHER";
            if (!byType[type]) byType[type] = [];
            byType[type].push(line);
        });
        var out = [];
        Object.keys(byType).forEach(function (type) {
            var lines = byType[type];
            var preferred = lines.filter(function (line) {
                return typeof preferredOrder[preferredHlsLang(line)] !== "undefined";
            }).sort(function (a, b) {
                return preferredOrder[preferredHlsLang(a)] - preferredOrder[preferredHlsLang(b)];
            });
            var selected = preferred.length ? preferred : lines.filter(function (line) {
                return /YES/i.test(hlsAttribute(line, "DEFAULT")) || /YES/i.test(hlsAttribute(line, "AUTOSELECT"));
            });
            if (type === "AUDIO") {
                lines.forEach(function (line) {
                    if (/YES/i.test(hlsAttribute(line, "DEFAULT")) && selected.indexOf(line) === -1) selected.push(line);
                });
            }
            if (!selected.length) selected = lines.slice(0, type === "AUDIO" ? 5 : 2);
            selected.slice(0, type === "AUDIO" || type === "SUBTITLES" ? 5 : 2).forEach(function (line) {
                if (out.indexOf(line) === -1) out.push(line);
            });
        });
        return out;
    }

    function hlsMustContainAudio(variantLine, mediaLines) {
        var audioGroup = hlsAttribute(variantLine, "AUDIO");
        if (!audioGroup) return true;
        var audio = (mediaLines || []).filter(function (line) {
            return hlsAttribute(line, "TYPE").toUpperCase() === "AUDIO"
                && hlsAttribute(line, "GROUP-ID") === audioGroup;
        });
        return audio.length > 0 && audio.every(function (line) {
            return !hlsMediaUrl(line);
        });
    }

    function hasPlayableHlsAudio(variantLine, mediaLines) {
        var audioGroup = hlsAttribute(variantLine, "AUDIO");
        if (!audioGroup) return true;
        var audioLines = (mediaLines || []).filter(function (line) {
            return hlsAttribute(line, "TYPE").toUpperCase() === "AUDIO"
                && hlsAttribute(line, "GROUP-ID") === audioGroup;
        });
        if (!audioLines.length) return false;
        if (audioLines.some(function (line) { return !hlsMediaUrl(line); })) return true;
        return (mediaLines || []).some(function (line) {
            return hlsAttribute(line, "TYPE").toUpperCase() === "AUDIO"
                && hlsAttribute(line, "GROUP-ID") === audioGroup
                && !!hlsMediaUrl(line)
                && !isExpiredStreamUrl(hlsMediaUrl(line));
        });
    }

    function hlsMasterPreamble(lines) {
        var out = [];
        (lines || []).forEach(function (line) {
            line = String(line || "").trim();
            if (!line) return;
            if (/^#EXT-X-STREAM-INF:/i.test(line) || /^#EXT-X-I-FRAME-STREAM-INF:/i.test(line) || /^#EXT-X-MEDIA:/i.test(line)) return;
            if (line.charAt(0) !== "#") return;
            if (/^#EXT-X-DEFINE:/i.test(line)) return;
            out.push(line);
        });
        if (!out.length || out[0] !== "#EXTM3U") out.unshift("#EXTM3U");
        return out;
    }

    function parseHlsVariants(masterText, masterUrl) {
        var lines = String(masterText || "").split(/\r?\n/);
        var variables = hlsDefineVariables(lines);
        var mediaLines = collectHlsMedia(lines, masterUrl, variables);
        var preamble = hlsMasterPreamble(lines);
        var variants = [];
        var seenUrls = {};
        for (var i = 0; i < lines.length; i++) {
            var line = String(lines[i] || "").trim();
            if (!/^#EXT-X-STREAM-INF:/i.test(line)) continue;
            if (isHlsTrickPlay(line)) continue;
            var variantUrl = "";
            for (var j = i + 1; j < lines.length; j++) {
                var next = String(lines[j] || "").trim();
                if (!next) continue;
                if (next.charAt(0) === "#") continue;
                variantUrl = absoluteUrl(replaceHlsVariables(next, variables), masterUrl);
                break;
            }
            if (!variantUrl) continue;
            var variantMediaLines = matchingMediaLines(mediaLines, line);
            if (!hasPlayableHlsAudio(line, variantMediaLines) || isExpiredStreamUrl(variantUrl)) continue;
            if (seenUrls[variantUrl]) continue;
            seenUrls[variantUrl] = true;
            variants.push({
                url: variantUrl,
                quality: hlsQuality(line),
                codec: hlsCodecLabel(line),
                rank: hlsCodecRank(line),
                bandwidth: parseInt(hlsAttribute(line, "BANDWIDTH"), 10) || 0,
                streamInf: line,
                mediaLines: variantMediaLines,
                fullMediaLines: variantMediaLines,
                preamble: preamble,
                standalone: hlsMustContainAudio(line, mediaLines)
            });
        }
        var byQuality = {};
        variants.forEach(function (variant) {
            var key = String(variant.quality || 0);
            var existing = byQuality[key];
            if (!existing || variant.rank > existing.rank || (variant.rank === existing.rank && variant.bandwidth > existing.bandwidth)) {
                byQuality[key] = variant;
            }
        });
        return Object.keys(byQuality).map(function (key) { return byQuality[key]; }).sort(function (a, b) {
            return (b.quality || 0) - (a.quality || 0);
        });
    }

    function qualityMasterPlaylist(variant, compactMedia) {
        var rows = (variant && variant.preamble && variant.preamble.length ? variant.preamble : ["#EXTM3U", "#EXT-X-INDEPENDENT-SEGMENTS"]).slice();
        var mediaLines = compactMedia === false ? (variant.fullMediaLines || variant.mediaLines || []) : compactHlsMediaLines(variant.mediaLines || []);
        mediaLines.forEach(function (line) {
            if (rows.indexOf(line) === -1) rows.push(line);
        });
        rows.push(variant.streamInf);
        rows.push(variant.url);
        return rows.join("\n");
    }

    function buildHlsStream(variant, subtitles, compactMedia) {
        if (!variant || !variant.url) return null;
        var label = variant.quality ? ("YouTube " + variant.quality + "p") : "YouTube HLS";
        if (variant.codec) label += " " + variant.codec;
        var stream = new StreamResult({
            url: magicM3u8(qualityMasterPlaylist(variant, compactMedia)),
            source: label,
            quality: variant.quality || undefined,
            headers: { "User-Agent": USER_AGENT, "Referer": BASE_URL + "/" }
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    function isH264HlsVariant(variant) {
        return /H264/i.test(String(variant && variant.codec || ""))
            || /avc1|h264/i.test(String(variant && variant.streamInf || ""));
    }

    async function hlsVariantStreams(masterUrl, subtitles) {
        if (!masterUrl) return [];
        try {
            var body = await requestText(masterUrl, headers({
                "Accept": "application/vnd.apple.mpegurl,application/x-mpegURL,*/*"
            }), { noCache: true });
            return parseHlsVariants(body, masterUrl).map(function (variant) {
                return isH264HlsVariant(variant)
                    ? buildHlsStream(variant, subtitles)
                    : buildHlsStream(variant, subtitles, false);
            }).filter(Boolean);
        } catch (_) {
            return [];
        }
    }

    function mobileClientContext(clientName, clientVersion, visitorData, extra) {
        var client = Object.assign({
            clientName: clientName,
            clientVersion: clientVersion,
            hl: LOCALE.hl,
            gl: LOCALE.gl,
            visitorData: visitorData || undefined
        }, extra || {});
        return {
            client: client,
            request: { internalExperimentFlags: [], useSsl: true },
            user: { lockedSafetyMode: false }
        };
    }

    async function visitorDataForMobile(clientName, clientVersion, headersForClient, extra) {
        try {
            var config = await getConfig();
            var json = await requestJson(YOUTUBEI_GAPIS_BASE + "/visitor_id?key=" + encodeURIComponent(config.key) + "&prettyPrint=false", {
                context: mobileClientContext(clientName, clientVersion, "", extra)
            }, headersForClient);
            return json && json.responseContext && json.responseContext.visitorData || "";
        } catch (_) {
            return "";
        }
    }

    function androidUserAgent() {
        return "com.google.android.youtube/" + ANDROID_CLIENT_VERSION + " (Linux; U; Android 13; " + LOCALE.gl + ") gzip";
    }

    function iosUserAgent() {
        return "com.google.ios.youtube/" + IOS_CLIENT_VERSION + " (" + IOS_DEVICE_MODEL + "; U; CPU iOS " + IOS_USER_AGENT_VERSION + " like Mac OS X; " + LOCALE.gl + ")";
    }

    async function androidReelPlayer(videoId, cpn, withVisitor) {
        var config = await getConfig();
        var h = mobileJsonHeaders("3", ANDROID_CLIENT_VERSION, androidUserAgent());
        var visitor = withVisitor ? await visitorDataForMobile("ANDROID", ANDROID_CLIENT_VERSION, h, {
            osName: "Android",
            osVersion: "13",
            androidSdkVersion: 33
        }) : "";
        var payload = {
            context: mobileClientContext("ANDROID", ANDROID_CLIENT_VERSION, visitor, {
                osName: "Android",
                osVersion: "13",
                androidSdkVersion: 33
            }),
            playerRequest: {
                videoId: videoId,
                cpn: cpn,
                contentCheckOk: true,
                racyCheckOk: true
            },
            disablePlayerResponse: false
        };
        var json = await requestJson(YOUTUBEI_GAPIS_BASE + "/reel/reel_item_watch?key=" + encodeURIComponent(config.key) + "&prettyPrint=false&t=" + encodeURIComponent(generateTParameter()) + "&id=" + encodeURIComponent(videoId) + "&$fields=playerResponse", payload, h);
        return json && json.playerResponse || {};
    }

    async function iosPlayer(videoId, cpn, withVisitor) {
        var config = await getConfig();
        var h = mobileJsonHeaders("5", IOS_CLIENT_VERSION, iosUserAgent());
        var visitor = withVisitor ? await visitorDataForMobile("IOS", IOS_CLIENT_VERSION, h, {
            deviceMake: "Apple",
            deviceModel: IOS_DEVICE_MODEL,
            osName: "iOS",
            osVersion: IOS_USER_AGENT_VERSION.replace(/_/g, ".")
        }) : "";
        var res = await requestJson(YOUTUBEI_BASE + "/player?key=" + encodeURIComponent(config.key) + "&id=" + encodeURIComponent(videoId), {
            context: mobileClientContext("IOS", IOS_CLIENT_VERSION, visitor, {
                deviceMake: "Apple",
                deviceModel: IOS_DEVICE_MODEL,
                osName: "iOS",
                osVersion: IOS_USER_AGENT_VERSION.replace(/_/g, ".")
            }),
            videoId: videoId,
            cpn: cpn,
            contentCheckOk: true,
            racyCheckOk: true
        }, h);
        return res;
    }

    async function tvPlayer(videoId, cpn) {
        var config = await getConfig();
        var h = mobileJsonHeaders("7", TV_CLIENT_VERSION, TV_USER_AGENT);
        var payload = {
            context: {
                client: {
                    clientName: "TVHTML5",
                    clientVersion: TV_CLIENT_VERSION,
                    hl: LOCALE.hl,
                    gl: LOCALE.gl,
                    userAgent: TV_USER_AGENT,
                    clientScreen: "WATCH"
                },
                user: { lockedSafetyMode: false },
                request: { useSsl: true }
            },
            videoId: videoId,
            cpn: cpn,
            contentCheckOk: true,
            racyCheckOk: true
        };
        return requestJson(YOUTUBEI_GAPIS_BASE + "/player?key=" + encodeURIComponent(config.key) + "&id=" + encodeURIComponent(videoId), payload, h);
    }

    async function androidTestSuitePlayer(videoId, cpn) {
        var config = await getConfig();
        var h = mobileJsonHeaders("30", "1.9", "Google-Test/1.0");
        var payload = {
            context: {
                client: {
                    clientName: "ANDROID_TESTSUITE",
                    clientVersion: "1.9",
                    hl: LOCALE.hl,
                    gl: LOCALE.gl,
                    androidSdkVersion: 30
                },
                user: { lockedSafetyMode: false },
                request: { useSsl: true }
            },
            videoId: videoId,
            cpn: cpn,
            contentCheckOk: true,
            racyCheckOk: true
        };
        return requestJson(YOUTUBEI_GAPIS_BASE + "/player?key=" + encodeURIComponent(config.key) + "&id=" + encodeURIComponent(videoId), payload, h);
    }

    async function androidVrPlayer(videoId, cpn) {
        var config = await getConfig();
        var h = mobileJsonHeaders("28", "1.50", "com.google.android.apps.youtube.vr/1.50.45 (Linux; U; Android 10; en_US) gzip");
        var payload = {
            context: {
                client: {
                    clientName: "ANDROID_VR",
                    clientVersion: "1.50.45",
                    hl: LOCALE.hl,
                    gl: LOCALE.gl,
                    deviceMake: "Oculus",
                    deviceModel: "Quest 2",
                    osName: "Android",
                    osVersion: "10"
                },
                user: { lockedSafetyMode: false },
                request: { useSsl: true }
            },
            videoId: videoId,
            cpn: cpn,
            contentCheckOk: true,
            racyCheckOk: true
        };
        return requestJson(YOUTUBEI_GAPIS_BASE + "/player?key=" + encodeURIComponent(config.key) + "&id=" + encodeURIComponent(videoId), payload, h);
    }

    async function webPlayer(videoId, cpn) {
        var config = await getConfig();
        var h = mobileJsonHeaders("1", config.clientVersion, WEB_USER_AGENT);
        var payload = {
            context: {
                client: {
                    clientName: "WEB",
                    clientVersion: config.clientVersion,
                    hl: LOCALE.hl,
                    gl: LOCALE.gl,
                    userAgent: WEB_USER_AGENT
                },
                user: { lockedSafetyMode: false },
                request: { useSsl: true }
            },
            videoId: videoId,
            cpn: cpn,
            contentCheckOk: true,
            racyCheckOk: true
        };
        return requestJson(YOUTUBEI_BASE + "/player?key=" + encodeURIComponent(config.key) + "&id=" + encodeURIComponent(videoId), payload, h);
    }

    function subtitleTracks(player) {
        var tracks = player && player.captions
            && player.captions.playerCaptionsTracklistRenderer
            && player.captions.playerCaptionsTracklistRenderer.captionTracks || [];
        return tracks.map(function (track) {
            return {
                url: track.baseUrl,
                label: track.name && getText(track.name) || track.languageCode || "Subtitle",
                lang: track.languageCode || "und"
            };
        }).filter(function (track) { return !!track.url; });
    }

    function compactSubtitleTracks(tracks) {
        var preferredOrder = { hi: 0, en: 1, te: 2, ta: 3, ml: 4 };
        var out = [];
        var seen = {};
        (tracks || []).forEach(function (track) {
            var lang = String(track && track.lang || "und");
            if (!track || !track.url || seen[lang] || typeof preferredOrder[lang] === "undefined") return;
            seen[lang] = true;
            out.push(track);
        });
        out.sort(function (a, b) {
            return preferredOrder[a.lang] - preferredOrder[b.lang];
        });
        if (out.length) return out.slice(0, 5);
        return (tracks || []).filter(function (track) {
            if (!track || !track.url || seen[track.lang]) return false;
            seen[track.lang] = true;
            return true;
        }).slice(0, 5);
    }

    function attachSubtitles(stream, subtitles) {
        if (stream && subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    function isLivePlayer(player) {
        var details = player && player.videoDetails || {};
        var micro = player && player.microformat && player.microformat.playerMicroformatRenderer || {};
        return details.isLive === true || details.isLiveContent === true || !!micro.liveBroadcastDetails;
    }

    function streamPriority(item) {
        var source = String(item && item.source || "");
        if (/^YouTube Live/i.test(source)) return 5000;
        if (/^YouTube TV/i.test(source)) return 4900;
        if (/^YouTube \d/i.test(source)) return 4800;
        if (/^YouTube HLS \d/i.test(source)) return 4700;
        if (/HLS Auto/i.test(source)) return 3000;
        if (/HLS/i.test(source)) return 2500;
        if (/^YouTube(?:\s|$)/i.test(source) && !/Video|HLS/i.test(source)) return 2200;
        if (item && item.audioTracks && item.audioTracks.length) return 1500;
        return 1000;
    }

    function streamCodecRank(item) {
        var source = String(item && item.source || "");
        if (/H264/i.test(source)) return 50;
        if (/VP9/i.test(source)) return 30;
        if (/AV1/i.test(source)) return 20;
        if (/H265/i.test(source)) return 10;
        return 0;
    }

    function streamQuality(item) {
        return parseInt(item && item.quality, 10) || parseInt((String(item && item.source || "").match(/(\d{3,4})p/i) || [])[1], 10) || 0;
    }

    function compactStreams(items) {
        var selectedByQuality = {};
        var other = [];
        (items || []).forEach(function (item) {
            var source = String(item && item.source || "");
            if (/^YouTube/i.test(source) && item && item.audioTracks && item.audioTracks.length) {
                var quality = streamQuality(item);
                var key = String(quality || source);
                var existing = selectedByQuality[key];
                if (!existing || streamCodecRank(item) > streamCodecRank(existing)) selectedByQuality[key] = item;
                return;
            }
            other.push(item);
        });
        var video = Object.keys(selectedByQuality).map(function (key) {
            return selectedByQuality[key];
        }).sort(function (a, b) {
            return streamQuality(b) - streamQuality(a);
        }).slice(0, 8);
        return other.concat(video);
    }

    function usableStream(item) {
        if (!item || !item.url) return false;
        if (String(item.url).indexOf("magic_m3u8:") === 0) return true;
        return !isExpiredStreamUrl(item.url);
    }

    function hasStreamingData(player) {
        return !!(player && player.streamingData);
    }

    function hlsUrlFromPlayer(player) {
        var streaming = player && player.streamingData || {};
        var url = streaming.hlsManifestUrl || "";
        return url && !isExpiredStreamUrl(url) ? url : "";
    }

    async function androidPlayer(videoId, cpn) {
        var config = await getConfig();
        var h = mobileJsonHeaders("3", ANDROID_CLIENT_VERSION, androidUserAgent());
        var payload = {
            context: mobileClientContext("ANDROID", ANDROID_CLIENT_VERSION, "", {
                osName: "Android",
                osVersion: "13",
                androidSdkVersion: 33
            }),
            videoId: videoId,
            cpn: cpn,
            contentCheckOk: true,
            racyCheckOk: true
        };
        return requestJson(YOUTUBEI_BASE + "/player?key=" + encodeURIComponent(config.key) + "&id=" + encodeURIComponent(videoId), payload, h);
    }

    async function hlsStreamsFromPlayer(player, subtitles) {
        var hlsUrl = hlsUrlFromPlayer(player);
        if (!hlsUrl) return [];
        var streams = await hlsVariantStreams(hlsUrl, subtitles);
        streams.push(attachSubtitles(new StreamResult({
            url: hlsUrl,
            source: "YouTube HLS Auto",
            quality: undefined,
            headers: { "User-Agent": USER_AGENT, "Referer": BASE_URL + "/" }
        }), subtitles));
        return streams;
    }

    async function loadStreams(url, cb) {
        try {
            console.log("[LOG] loadStreams: Starting for " + url);
            applyLocale(providerConfig());
            var id = extractVideoId(url);
            if (!id) return cb({ success: false, errorCode: "INVALID_URL", message: "Invalid YouTube video URL" });
            var cpn = generateContentPlaybackNonce();
            console.log("[LOG] loadStreams: Fetching players for id: " + id);
            
            var androidPromise = androidPlayer(id, cpn).catch(function (e) { console.log("[LOG] androidPlayer Error: " + e); return {}; });
            var androidReelPromise = androidReelPlayer(id, cpn, true).catch(function (e) { console.log("[LOG] androidReelPlayer Error: " + e); return {}; });
            var iosPromise = iosPlayer(id, generateContentPlaybackNonce(), true).catch(function (e) { console.log("[LOG] iosPlayer Error: " + e); return null; });
            var tvPromise = tvPlayer(id, cpn).catch(function (e) { console.log("[LOG] tvPlayer Error: " + e); return null; });
            var testSuitePromise = androidTestSuitePlayer(id, cpn).catch(function (e) { console.log("[LOG] androidTestSuitePlayer Error: " + e); return null; });
            var vrPromise = androidVrPlayer(id, cpn).catch(function (e) { console.log("[LOG] androidVrPlayer Error: " + e); return null; });
            var webPromise = webPlayer(id, cpn).catch(function (e) { console.log("[LOG] webPlayer Error: " + e); return null; });

            var hlsBundlePromise = Promise.all([iosPromise, vrPromise]).then(async function (players) {
                var iosRes = players[0];
                var vrRes = players[1];
                var iosSubs = compactSubtitleTracks(subtitleTracks(iosRes || vrRes));
                var streams = [];
                if (hasStreamingData(iosRes)) streams = streams.concat(await hlsStreamsFromPlayer(iosRes, iosSubs));
                if (hasStreamingData(vrRes)) streams = streams.concat(await hlsStreamsFromPlayer(vrRes, iosSubs));
                return { ios: iosRes, subtitles: iosSubs, streams: streams };
            }).catch(function () {
                return { ios: null, subtitles: [], streams: [] };
            });

            var player = await androidPromise;
            var reel = await androidReelPromise;
            var hlsBundle = await hlsBundlePromise;
            var ios = hlsBundle.ios;
            var tv = await tvPromise;
            var testSuite = await testSuitePromise;
            var vr = await vrPromise;
            var web = await webPromise;
            
            var allPlayers = [
                { player: player, name: "YouTube Android", ua: androidUserAgent() },
                { player: reel, name: "YouTube Android Reel", ua: androidUserAgent() },
                { player: ios, name: "YouTube iOS", ua: iosUserAgent() },
                { player: tv, name: "YouTube TV", ua: TV_USER_AGENT },
                { player: testSuite, name: "YouTube TS", ua: "Google-Test/1.0" },
                { player: vr, name: "YouTube VR", ua: "com.google.android.apps.youtube.vr/1.50.45 (Linux; U; Android 10; en_US) gzip" },
                { player: web, name: "YouTube Web", ua: WEB_USER_AGENT }
            ].filter(function(item) { return hasStreamingData(item.player); });

            if (!allPlayers.length) {
                try {
                    var retried = await Promise.all([
                        androidReelPlayer(id, cpn, true).catch(function () { return {}; }),
                        iosPlayer(id, generateContentPlaybackNonce(), true).catch(function () { return null; }),
                        tvPlayer(id, cpn).catch(function () { return null; }),
                        androidTestSuitePlayer(id, cpn).catch(function () { return null; }),
                        androidVrPlayer(id, cpn).catch(function () { return null; }),
                        webPlayer(id, cpn).catch(function () { return null; })
                    ]);
                    allPlayers = [
                        { player: retried[0], name: "YouTube Android Reel", ua: androidUserAgent() },
                        { player: retried[1], name: "YouTube iOS", ua: iosUserAgent() },
                        { player: retried[2], name: "YouTube TV", ua: TV_USER_AGENT },
                        { player: retried[3], name: "YouTube TS", ua: "Google-Test/1.0" },
                        { player: retried[4], name: "YouTube VR", ua: "com.google.android.apps.youtube.vr/1.50.45 (Linux; U; Android 10; en_US) gzip" },
                        { player: retried[5], name: "YouTube Web", ua: WEB_USER_AGENT }
                    ].filter(function(item) { return hasStreamingData(item.player); });

                    if (hasStreamingData(retried[1]) && !hlsBundle.streams.length) {
                        var retrySubs = compactSubtitleTracks(subtitleTracks(retried[1]));
                        hlsBundle = {
                            subtitles: retrySubs,
                            streams: await hlsStreamsFromPlayer(retried[1], retrySubs)
                        };
                    }
                } catch (_) {}
            }

            if (!allPlayers.length) {
                var page = await videoPage(id);
                if (hasStreamingData(page.player)) allPlayers.push({ player: page.player, name: "YouTube Page", ua: USER_AGENT });
            }

            var results = [];
            var seenItags = {};
            var subs = hlsBundle.subtitles || [];

            allPlayers.forEach(function(item) {
                var p = item.player;
                var streaming = p.streamingData || {};
                var sourceName = item.name;
                var playerUA = item.ua;
                
                var pSubs = compactSubtitleTracks(subtitleTracks(p));
                if (pSubs.length && !subs.length) subs = pSubs;

                if (isLivePlayer(p) && streaming.hlsManifestUrl && !isExpiredStreamUrl(streaming.hlsManifestUrl)) {
                    results.push(attachSubtitles(new StreamResult({
                        url: streaming.hlsManifestUrl,
                        source: sourceName + " Live",
                        quality: undefined,
                        headers: { "User-Agent": playerUA, "Referer": BASE_URL + "/" }
                    }), subs));
                }

                (streaming.formats || []).forEach(function (format) {
                    if (!isMuxed(format)) return;
                    var key = sourceName + "_" + format.itag;
                    if (seenItags[key]) return;
                    seenItags[key] = true;
                    var stream = buildNewPipeStream(format, sourceName, cpn, subs);
                    if (stream) {
                        stream.headers["User-Agent"] = playerUA;
                        results.push(stream);
                    }
                });

                var audioTracks = audioTracksFromNewPipeFormats(streaming.adaptiveFormats || [], cpn);
                audioTracks.forEach(function(t) { t.headers["User-Agent"] = playerUA; });

                (streaming.adaptiveFormats || []).forEach(function (format) {
                    if (itagType(format) === "video-only" || isVideoOnly(format)) {
                        var key = sourceName + "_" + format.itag;
                        if (seenItags[key]) return;
                        seenItags[key] = true;
                        var stream = buildNewPipeVideoOnlyStream(format, sourceName, audioTracks, cpn, subs);
                        if (stream) {
                            stream.headers["User-Agent"] = playerUA;
                            results.push(stream);
                        }
                    }
                });
            });

            results = results.concat(hlsBundle.streams || []);

            var seenUrls = {};
            results = results.filter(function (item) {
                if (!usableStream(item) || seenUrls[item.url]) return false;
                seenUrls[item.url] = true;
                return true;
            }).sort(function (a, b) {
                var priority = streamPriority(b) - streamPriority(a);
                if (priority) return priority;
                return streamQuality(b) - streamQuality(a);
            });
            
            results = compactStreams(results).sort(function (a, b) {
                var priority = streamPriority(b) - streamPriority(a);
                if (priority) return priority;
                return streamQuality(b) - streamQuality(a);
            });

            console.log("[LOG] loadStreams: Returning " + results.length + " streams.");
            results.forEach(function(r, i) {
                console.log("[LOG] Stream " + i + ": " + r.source + " | " + r.url.substring(0, 50) + "...");
            });

            Analytics.logEvent('youtube_loadstreams', {});
            cb({ success: true, data: results });
        } catch (error) {
            console.log("[LOG] loadStreams Error: " + error);
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
