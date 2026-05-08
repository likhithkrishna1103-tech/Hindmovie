(function () {
    "use strict";

    var BASE_URL = String((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://www.youtube.com").replace(/\/+$/, "");
    var MOBILE_URL = "https://m.youtube.com";
    var YOUTUBEI_BASE = "https://www.youtube.com/youtubei/v1";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";
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
        }
    };
    var CONFIG_CACHE = null;
    var CONFIG_PROMISE = null;
    var PAGE_CACHE = {};
    var CACHE_TTL = 5 * 60 * 1000;
    var HISTORY_STORAGE_KEY = "skystream_youtube_search_history_v1";

    var SEARCH_FILTERS = {
        videos: "EgIQAQ%3D%3D",
        channels: "EgIQAg%3D%3D",
        playlists: "EgIQAw%3D%3D"
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

    async function requestText(url, requestHeaders) {
        var key = "GET:" + url;
        var hit = cached(key);
        if (hit != null) return hit;
        if (typeof http_get === "function") {
            var res = await http_get(url, requestHeaders || headers());
            return cacheSet(key, String(res && res.body || ""));
        }
        if (typeof fetch === "function") {
            var response = await fetch(url, { headers: requestHeaders || headers() });
            return cacheSet(key, await response.text());
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

    async function getConfig() {
        if (CONFIG_CACHE) return CONFIG_CACHE;
        if (CONFIG_PROMISE) return CONFIG_PROMISE;
        CONFIG_PROMISE = (async function () {
            try {
                var html = await requestText(BASE_URL + "/?hl=" + LOCALE.hl + "&gl=" + LOCALE.gl, headers());
                CONFIG_CACHE = parseConfigFromHtml(html);
            } catch (_) {
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
        return new MultimediaItem({
            title: title,
            url: videoUrl(renderer.videoId),
            posterUrl: lastThumb(thumbsFrom(renderer)) || undefined,
            type: "movie",
            duration: durationMinutes(getText(renderer.lengthText || renderer.thumbnailOverlays)),
            contentRating: cleanText(getText(renderer.ownerText || renderer.shortBylineText)) || undefined
        });
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

    function parseItems(data, wantedProvider) {
        var out = [];
        var seen = {};
        function add(item) {
            if (!item || !item.url || seen[item.url]) return;
            seen[item.url] = true;
            out.push(item);
        }
        if (!wantedProvider || wantedProvider === "videos") collectRenderers(data, "videoRenderer").forEach(function (r) { add(videoItem(r)); });
        if (!wantedProvider || wantedProvider === "playlists") collectRenderers(data, "playlistRenderer").forEach(function (r) { add(playlistItem(r)); });
        if (!wantedProvider || wantedProvider === "channels") collectRenderers(data, "channelRenderer").forEach(function (r) { add(channelItem(r)); });
        if (!wantedProvider || wantedProvider === "videos") collectRenderers(data, "lockupViewModel").forEach(function (r) { add(lockupVideoItem(r)); });
        if (!wantedProvider || wantedProvider === "playlists") collectRenderers(data, "lockupViewModel").forEach(function (r) { add(lockupPlaylistItem(r)); });
        return out;
    }

    async function searchItems(query, type) {
        var filter = SEARCH_FILTERS[type] || SEARCH_FILTERS.videos;
        try {
            var json = await youtubei("search", {
                query: String(query || ""),
                params: decodeURIComponent(filter)
            });
            return parseItems(json, type);
        } catch (_) {
            var html = await requestText(BASE_URL + "/results?search_query=" + encodeURIComponent(query || "") + "&sp=" + filter + "&hl=" + LOCALE.hl + "&gl=" + LOCALE.gl, headers());
            return parseItems(extractBalancedJson(html, "ytInitialData"), type);
        }
    }

    function storageKey(provider) {
        return "skystream_youtube_searches_" + String(provider || providerId());
    }

    function storageGet(key) {
        try {
            if (typeof localStorage !== "undefined" && localStorage && typeof localStorage.getItem === "function") {
                return localStorage.getItem(key);
            }
        } catch (_) {}
        return null;
    }

    function storageSet(key, value) {
        try {
            if (typeof localStorage !== "undefined" && localStorage && typeof localStorage.setItem === "function") {
                localStorage.setItem(key, value);
            }
        } catch (_) {}
    }

    function normalizeSearchQuery(query) {
        return cleanText(query).replace(/[^\w\s\u0900-\u097F\u0B80-\u0BFF\u0C00-\u0C7F\u0D00-\u0D7F-]/g, "").slice(0, 80);
    }

    function readStoredHistory() {
        var stored = storageGet(HISTORY_STORAGE_KEY);
        try {
            var parsed = JSON.parse(stored || "[]");
            return parsed && typeof parsed === "object" && !Array.isArray(parsed) ? parsed : {};
        } catch (_) {
            return {};
        }
    }

    function writeStoredHistory(value) {
        storageSet(HISTORY_STORAGE_KEY, JSON.stringify(value || {}));
    }

    function readSearchHistory(provider) {
        provider = provider || providerId();
        if (SEARCH_HISTORY[provider]) return SEARCH_HISTORY[provider];
        var allHistory = readStoredHistory();
        var stored = allHistory[provider];
        if (!Array.isArray(stored)) {
            try {
                stored = JSON.parse(storageGet(storageKey(provider)) || "[]");
            } catch (_) {
                stored = [];
            }
        }
        SEARCH_HISTORY[provider] = Array.isArray(stored) ? stored.filter(Boolean).slice(0, 20) : [];
        return SEARCH_HISTORY[provider];
    }

    function rememberSearch(query) {
        var provider = providerId();
        var clean = normalizeSearchQuery(query);
        if (clean.length < 2) return;
        var history = readSearchHistory(provider).filter(function (item) {
            return String(item || "").toLowerCase() !== clean.toLowerCase();
        });
        history.unshift(clean);
        history = history.slice(0, 20);
        SEARCH_HISTORY[provider] = history;
        var allHistory = readStoredHistory();
        allHistory[provider] = history;
        writeStoredHistory(allHistory);
        storageSet(storageKey(provider), JSON.stringify(history));
    }

    function recentSearches(provider) {
        return readSearchHistory(provider).slice(0, 3);
    }

    async function searchItemsForProvider(query) {
        var fullQuery = normalizeSearchQuery(query);
        var mixed = [];
        try {
            var json = await youtubei("search", { query: fullQuery });
            mixed = parseItems(json, "");
        } catch (_) {
            var html = await requestText(BASE_URL + "/results?search_query=" + encodeURIComponent(fullQuery) + "&hl=" + LOCALE.hl + "&gl=" + LOCALE.gl, headers());
            mixed = parseItems(extractBalancedJson(html, "ytInitialData"), "");
        }
        return mixed;
    }

    async function homeSearch(section, config) {
        if (section.source === "trending") return trendingItems(section, config);
        var query = section.query;
        if (section.personalized) query = section.query + " " + config.language;
        if (section.mixed) return searchItemsForProvider(query, config);
        return searchItems(query, section.type || "videos");
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
        cb({
            success: true,
            data: new MultimediaItem({
                title: title,
                url: videoUrl(id),
                posterUrl: poster || undefined,
                bannerUrl: poster || undefined,
                description: cleanText(details.shortDescription || getText(microformat.description)) || undefined,
                type: "movie",
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
        var videos = collectRenderers(data, "videoRenderer")
            .map(function (renderer, index) { return episodeFromVideoRenderer(renderer, index); })
            .concat(collectRenderers(data, "lockupViewModel").map(function (renderer, index) { return episodeFromLockup(renderer, index); }))
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
            if (sections.length) {
                try {
                    var trendingItems = await resolveHomeSection(sections[0], config, seen);
                    if (trendingItems.length) data[sections[0].title] = trendingItems;
                } catch (_) {}
            }
            var searches = recentSearches(providerId());
            var queuedSections = [];
            for (var h = 0; h < searches.length; h++) {
                queuedSections.push({
                    title: "Because You Searched: " + searches[h],
                    query: searches[h],
                    mixed: true,
                    personalized: true,
                    limit: 16
                });
            }
            for (var i = 1; i < sections.length; i++) {
                queuedSections.push(sections[i]);
            }
            var resolvedSections = await fetchHomeSections(queuedSections, config, 3);
            for (var r = 0; r < resolvedSections.length; r++) {
                var resolved = resolvedSections[r] || {};
                var resolvedSection = resolved.section || {};
                var resolvedItems = filterHomeItems(resolved.items, seen, resolvedSection.limit || 20);
                if (resolvedItems.length) data[resolvedSection.title] = resolvedItems;
            }
            if (!Object.keys(data).length) data.Trending = filterHomeItems(await trendingItems({
                title: "Trending",
                source: "trending",
                fallbackQuery: config.language + " latest popular videos",
                type: "videos"
            }, config), seen, 20);
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var config = providerConfig();
            applyLocale(config);
            rememberSearch(query);
            cb({ success: true, data: await searchItemsForProvider(query, config) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            applyLocale(providerConfig());
            var value = String(url || "");
            if (extractPlaylistId(value)) return loadPlaylist(value, cb);
            if (/youtube\.com\/(?:@|channel\/|c\/|user\/)/i.test(value)) return loadChannel(value, cb);
            return loadVideo(value, cb);
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

    function streamUrlFromFormat(format) {
        if (format.url) return format.url;
        var cipher = format.signatureCipher || format.cipher || "";
        if (!cipher) return "";
        var params = parseQuery(cipher);
        if (params.url && !params.s) return params.url;
        return "";
    }

    function isMuxed(format) {
        var mime = String(format.mimeType || "");
        return mime.indexOf("video/") !== -1 && mime.indexOf("audio") !== -1;
    }

    function buildStream(format, sourceName) {
        var url = streamUrlFromFormat(format);
        if (!url) return null;
        var quality = parseInt(format.height || format.qualityLabel, 10) || 0;
        var codec = normalizeCodec((String(format.mimeType || "").match(/codecs="([^"]+)"/) || [])[1]);
        return new StreamResult({
            url: url,
            source: cleanText(sourceName + (codec ? " " + codec : "")),
            quality: quality || undefined,
            headers: {
                "User-Agent": USER_AGENT,
                "Referer": BASE_URL + "/"
            }
        });
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
        var re = new RegExp(name + "=((?:\"[^\"]+\")|[^,]+)", "i");
        var match = String(line || "").match(re);
        if (!match) return "";
        return String(match[1] || "").replace(/^"|"$/g, "");
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

    function absolutizeHlsUri(line, masterUrl) {
        return String(line || "").replace(/URI="([^"]+)"/i, function (_, uri) {
            return 'URI="' + absoluteUrl(uri, masterUrl) + '"';
        });
    }

    function collectHlsMedia(lines, masterUrl) {
        return lines.map(function (line) {
            return String(line || "").trim();
        }).filter(function (line) {
            return /^#EXT-X-MEDIA:/i.test(line);
        }).map(function (line) {
            return absolutizeHlsUri(line, masterUrl);
        });
    }

    function mediaGroup(line, name) {
        return hlsAttribute(line, name);
    }

    function matchingMediaLines(mediaLines, variantLine) {
        var audioGroup = hlsAttribute(variantLine, "AUDIO");
        var subtitlesGroup = hlsAttribute(variantLine, "SUBTITLES");
        return mediaLines.filter(function (line) {
            var type = hlsAttribute(line, "TYPE").toUpperCase();
            var groupId = mediaGroup(line, "GROUP-ID");
            if (type === "AUDIO") return !audioGroup || groupId === audioGroup;
            if (type === "SUBTITLES") return !subtitlesGroup || groupId === subtitlesGroup;
            return false;
        });
    }

    function parseHlsVariants(masterText, masterUrl) {
        var lines = String(masterText || "").split(/\r?\n/);
        var mediaLines = collectHlsMedia(lines, masterUrl);
        var variants = [];
        for (var i = 0; i < lines.length; i++) {
            var line = String(lines[i] || "").trim();
            if (!/^#EXT-X-STREAM-INF:/i.test(line)) continue;
            var variantUrl = "";
            for (var j = i + 1; j < lines.length; j++) {
                var next = String(lines[j] || "").trim();
                if (!next) continue;
                if (next.charAt(0) === "#") continue;
                variantUrl = absoluteUrl(next, masterUrl);
                break;
            }
            if (!variantUrl) continue;
            variants.push({
                url: variantUrl,
                quality: hlsQuality(line),
                codec: hlsCodecLabel(line),
                rank: hlsCodecRank(line),
                bandwidth: parseInt(hlsAttribute(line, "BANDWIDTH"), 10) || 0,
                streamInf: line,
                mediaLines: matchingMediaLines(mediaLines, line)
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

    function qualityMasterPlaylist(variant) {
        var rows = ["#EXTM3U", "#EXT-X-INDEPENDENT-SEGMENTS"];
        (variant.mediaLines || []).forEach(function (line) {
            if (rows.indexOf(line) === -1) rows.push(line);
        });
        rows.push(variant.streamInf);
        rows.push(variant.url);
        return rows.join("\n");
    }

    function buildHlsStream(variant, subtitles) {
        if (!variant || !variant.url) return null;
        var label = variant.quality ? ("YouTube HLS " + variant.quality + "p") : "YouTube HLS";
        if (variant.codec) label += " " + variant.codec;
        var stream = new StreamResult({
            url: magicM3u8(qualityMasterPlaylist(variant)),
            source: label,
            quality: variant.quality || undefined,
            headers: { "User-Agent": USER_AGENT, "Referer": BASE_URL + "/" }
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    async function hlsVariantStreams(masterUrl, subtitles) {
        if (!masterUrl) return [];
        try {
            var body = await requestText(masterUrl, headers({
                "Accept": "application/vnd.apple.mpegurl,application/x-mpegURL,*/*"
            }));
            return parseHlsVariants(body, masterUrl).map(function (variant) {
                return buildHlsStream(variant, subtitles);
            }).filter(Boolean);
        } catch (_) {
            return [];
        }
    }

    async function iosPlayer(videoId) {
        var config = await getConfig();
        return requestJson(YOUTUBEI_BASE + "/player?key=" + encodeURIComponent(config.key), {
            context: {
                client: {
                    clientName: "IOS",
                    clientVersion: "20.10.4",
                    hl: LOCALE.hl,
                    gl: LOCALE.gl
                }
            },
            videoId: videoId
        }, jsonHeaders({
            "User-Agent": "com.google.ios.youtube/20.10.4 (iPhone16,2; U; CPU iOS 18_3_2 like Mac OS X;)"
        }));
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

    async function loadStreams(url, cb) {
        try {
            applyLocale(providerConfig());
            var id = extractVideoId(url);
            if (!id) return cb({ success: false, errorCode: "INVALID_URL", message: "Invalid YouTube video URL" });
            var page = await videoPage(id);
            var player = page.player || {};
            var streaming = player.streamingData || {};
            var subs = subtitleTracks(player);
            var results = [];

            if (streaming.hlsManifestUrl) {
                var live = new StreamResult({
                    url: streaming.hlsManifestUrl,
                    source: "YouTube Live",
                    quality: undefined,
                    headers: { "User-Agent": USER_AGENT, "Referer": BASE_URL + "/" }
                });
                if (subs.length) live.subtitles = subs;
                results.push(live);
            }

            (streaming.formats || []).filter(isMuxed).forEach(function (format) {
                var stream = buildStream(format, "YouTube");
                if (!stream) return;
                if (subs.length) stream.subtitles = subs;
                results.push(stream);
            });

            if (!results.length) {
                (streaming.adaptiveFormats || []).filter(isMuxed).forEach(function (format) {
                    var stream = buildStream(format, "YouTube Adaptive");
                    if (!stream) return;
                    if (subs.length) stream.subtitles = subs;
                    results.push(stream);
                });
            }

            if (!results.length) {
                try {
                    var ios = await iosPlayer(id);
                    if (ios && ios.streamingData && ios.streamingData.hlsManifestUrl) {
                        results = results.concat(await hlsVariantStreams(ios.streamingData.hlsManifestUrl, subs));
                        var iosStream = new StreamResult({
                            url: ios.streamingData.hlsManifestUrl,
                            source: "YouTube HLS Auto",
                            quality: undefined,
                            headers: { "User-Agent": USER_AGENT, "Referer": BASE_URL + "/" }
                        });
                        if (subs.length) iosStream.subtitles = subs;
                        results.push(iosStream);
                    }
                } catch (_) {}
            }

            var seen = {};
            results = results.filter(function (item) {
                if (!item || !item.url || seen[item.url]) return false;
                seen[item.url] = true;
                return true;
            }).sort(function (a, b) {
                return (parseInt(b.quality, 10) || 0) - (parseInt(a.quality, 10) || 0);
            });

            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
