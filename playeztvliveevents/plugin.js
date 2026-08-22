(function() {
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

    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // `manifest` is injected by the runtime.

    const MATCH_CARD_API = "https://live-card-png.cricify.workers.dev/";
    const FIREBASE_CONFIG = {
        packageName: "com.playz.tv",
        apiKey: "AIzaSyDKRqLlbaZBIpHzLBiQTUrJqr3gN-nDWWc",
        appId: "1:516859456626:android:12a75869902c4f8a6826eb",
        projectNumber: "516859456626",
        sdkVersion: "22.1.0",
        appVersion: "2.1",
        appBuild: "4"
    };
    const DEFAULT_BASE_URLS = [
        "https://adsflw.xyz",
        "https://playztv2828.store"
    ];

    const PLAYZ_NATIVE_KEY = [99, 122, 49, 52, 82, 83, 116, 107, 78, 48, 49, 80, 86, 69, 53, 119];
    const PLAYZ_NATIVE_IV = [87, 84, 108, 69, 118, 99, 107, 100, 50, 85, 82, 52, 49, 115, 100, 107];
    const PLAYZ_PRIMARY_KEY = [98, 47, 49, 106, 109, 108, 53, 110, 107, 52, 120, 53, 107, 55, 112, 78];
    const PLAYZ_PRIMARY_IV = [49, 52, 110, 77, 107, 56, 109, 78, 53, 75, 108, 53, 75, 76, 55, 108];
    const PLAYZ_FALLBACK_KEY = [109, 53, 75, 108, 53, 110, 107, 52, 120, 75, 49, 107, 78, 55, 112, 78];
    const PLAYZ_FALLBACK_IV = [107, 53, 75, 52, 110, 77, 56, 109, 75, 108, 78, 76, 55, 108, 49, 53];

    const PLAYZ_SUBSTITUTION_FROM = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    const PLAYZ_SUBSTITUTION_TO = "fFgGjJkKaApPbBmMoOzZeEnNcCdDrRqQtTvVuUxXhHiIwWyYlLsS";
    const PLAYZ_SUBSTITUTION_REVERSE = {};
    for (let index = 0; index < PLAYZ_SUBSTITUTION_TO.length; index++) {
        PLAYZ_SUBSTITUTION_REVERSE[PLAYZ_SUBSTITUTION_TO[index]] = PLAYZ_SUBSTITUTION_FROM[index];
    }

    const PLAYZ_TRUSTED_HOSTS = [
        "a201aivottlinear-a.akamaihd.net",
        "otte.live.cf.ww.aiv-cdn.net",
        "in-mc-flive.fancode.com",
        "livevideos.cricbuzz.com",
        "livetv.hotstar.com",
        "jiotvpllive.cdn.jio.com",
        "dice-live-oc.akamaized.net"
    ];
    const PLAYZ_WEAK_HOSTS = [
        "winner-api.icu",
        "mainstreams.pro",
        "smarthard.click",
        "chatgpt.hereisman.net",
        "windows-devs.top",
        "firebase-api.com",
        "195.178.110.2"
    ];

    let activeBaseUrl = null;
    let remoteBaseUrlsPromise = null;
    let aesJsPromise = null;

    function trimToString(value) {
        if (value === null || value === undefined) return "";
        return typeof value === "string" ? value.trim() : String(value).trim();
    }

    function normalizeBaseUrl(value) {
        const normalized = trimToString(value).replace(/\/+$/, "");
        if (!normalized || /example\.com/i.test(normalized)) return null;
        if (!/^https?:\/\//i.test(normalized)) return null;
        return normalized;
    }

    function extractResponseBody(response) {
        if (!response) return "";
        if (typeof response === "string") return response;
        if (response && typeof response.body === "string") return response.body;
        return "";
    }

    function extractResponseStatus(response) {
        if (!response) return 200;
        return response && typeof response.status !== "undefined" ? response.status : 200;
    }

    function createAppInstanceId() {
        let value = "";
        while (value.length < 32) {
            value += Math.random().toString(16).slice(2);
        }
        return value.slice(0, 32);
    }

    function safeJsonParse(text) {
        if (!text) return null;
        try {
            return JSON.parse(String(text));
        } catch (_) {
            return null;
        }
    }

    function base64ToBytes(value) {
        let normalized = String(value || "").replace(/-/g, "+").replace(/_/g, "/").replace(/\s+/g, "");
        while (normalized.length % 4) normalized += "=";
        try {
            if (typeof Buffer !== "undefined") return new Uint8Array(Buffer.from(normalized, "base64"));
        } catch (_) {}
        const decoded = typeof atob === "function" ? atob(normalized) : "";
        const bytes = new Uint8Array(decoded.length);
        for (let index = 0; index < decoded.length; index++) {
            bytes[index] = decoded.charCodeAt(index) & 255;
        }
        return bytes;
    }

    function bytesToBase64(bytes) {
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(bytes).toString("base64");
        } catch (_) {}
        let binary = "";
        for (let index = 0; index < bytes.length; index++) {
            binary += String.fromCharCode(bytes[index]);
        }
        return typeof btoa === "function" ? btoa(binary) : "";
    }

    function bytesToAscii(bytes) {
        let out = "";
        for (let index = 0; index < bytes.length; index++) {
            out += String.fromCharCode(bytes[index]);
        }
        return out;
    }

    function bytesToUtf8(bytes) {
        if (!bytes || !bytes.length) return "";
        if (typeof TextDecoder !== "undefined") {
            try {
                return new TextDecoder().decode(bytes);
            } catch (_) {}
        }
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(bytes).toString("utf8");
        } catch (_) {}
        let out = "";
        for (let index = 0; index < bytes.length; index++) {
            out += String.fromCharCode(bytes[index]);
        }
        try {
            return decodeURIComponent(escape(out));
        } catch (_) {
            return out;
        }
    }

    function stripPkcs7(bytes) {
        if (!bytes || !bytes.length) return bytes || new Uint8Array(0);
        const pad = bytes[bytes.length - 1];
        if (!pad || pad > 16 || pad > bytes.length) return bytes;
        for (let index = bytes.length - pad; index < bytes.length; index++) {
            if (bytes[index] !== pad) return bytes;
        }
        return bytes.slice(0, bytes.length - pad);
    }

    function swapAdjacentPairs(bytes) {
        const out = new Uint8Array(bytes);
        for (let i = 0; i + 1 < out.length; i += 2) {
            const tmp = out[i];
            out[i] = out[i + 1];
            out[i + 1] = tmp;
        }
        return out;
    }

    async function mapWithConcurrency(items, limit, worker) {
        if (!Array.isArray(items)) return [];
        if (typeof worker !== "function") return [];
        const source = items;
        const results = new Array(source.length);
        const maxWorkers = Math.max(1, Math.min(parseInt(limit, 10) || 1, source.length || 1));
        let nextIndex = 0;

        async function runWorker() {
            while (nextIndex < source.length) {
                const currentIndex = nextIndex++;
                try {
                    results[currentIndex] = await worker(source[currentIndex], currentIndex);
                } catch (error) {
                    console.error("Stream entry failed: " + (error && error.message ? error.message : String(error)));
                    results[currentIndex] = [];
                }
            }
        }

        const workers = [];
        for (let index = 0; index < maxWorkers; index++) {
            workers.push(runWorker());
        }
        await Promise.all(workers);
        return results;
    }

    async function decryptAesCbcBytes(cipherBytes, keyBytes, ivBytes) {
        if (typeof __crypto__ !== "undefined" && __crypto__.createDecipheriv) {
            try {
                const keyBuf = Buffer.from(keyBytes);
                const ivBuf = Buffer.from(ivBytes);
                const dataBuf = Buffer.from(cipherBytes);
                const algo = keyBuf.length <= 16 ? "aes-128-cbc" : (keyBuf.length <= 24 ? "aes-192-cbc" : "aes-256-cbc");
                const decipher = __crypto__.createDecipheriv(algo, keyBuf, ivBuf);
                return new Uint8Array(Buffer.concat([decipher.update(dataBuf), decipher.final()]));
            } catch (_) {}
        }

        if (globalThis.crypto && typeof globalThis.crypto.decryptAES === "function") {
            try {
                const dataB64 = bytesToBase64(cipherBytes);
                const keyB64 = bytesToBase64(keyBytes);
                const ivB64 = bytesToBase64(ivBytes);
                const ptStr = await globalThis.crypto.decryptAES(dataB64, keyB64, ivB64, { mode: "cbc" });
                if (ptStr) {
                    return new Uint8Array(typeof Buffer !== "undefined" ? Buffer.from(ptStr, "utf8") : new TextEncoder().encode(ptStr));
                }
            } catch (_) {}
        }

        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            try {
                const key = await globalThis.crypto.subtle.importKey("raw", new Uint8Array(keyBytes), { name: "AES-CBC" }, false, ["decrypt"]);
                const pt = await globalThis.crypto.subtle.decrypt({ name: "AES-CBC", iv: new Uint8Array(ivBytes) }, key, new Uint8Array(cipherBytes));
                return new Uint8Array(pt);
            } catch (_) {}
        }

        return new Uint8Array(0);
    }

    async function postJson(url, payload, headers) {
        if (!url || typeof url !== "string") {
            throw new Error("Invalid URL for postJson");
        }
        const body = JSON.stringify(payload);
        try {
            if (typeof http_post === "function") {
                return http_post(url, headers || {}, body);
            }
            if (typeof fetch === "function") {
                const response = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body
                });
                return {
                    status: response.status,
                    body: await response.text()
                };
            }
            throw new Error("POST requests are not supported in this runtime");
        } catch (error) {
            console.error(`Failed to POST to ${url}: ${error && error.message ? error.message : String(error)}`);
            throw error;
        }
    }

    async function fetchText(url, headers) {
        if (!url || typeof url !== "string") {
            throw new Error("Invalid URL for fetchText");
        }
        try {
            if (typeof http_get === "function") {
                return http_get(url, headers || {});
            }
            if (typeof fetch === "function") {
                const response = await fetch(url, { headers: headers || {} });
                return {
                    status: response.status,
                    body: await response.text()
                };
            }
            throw new Error("GET requests are not supported in this runtime");
        } catch (error) {
            console.error(`Failed to fetch text from ${url}: ${error && error.message ? error.message : String(error)}`);
            throw error;
        }
    }

    async function fetchWithMethod(url, requestType, headers, body, bodyType) {
        const normalizedType = trimToString(requestType).toLowerCase();
        if (normalizedType === "post") {
            const postHeaders = Object.assign({}, headers || {});
            const normalizedBodyType = trimToString(bodyType).toLowerCase();
            if (!postHeaders["Content-Type"]) {
                postHeaders["Content-Type"] = normalizedBodyType === "json"
                    ? "application/json"
                    : normalizedBodyType === "text"
                        ? "text/plain; charset=utf-8"
                        : "application/x-www-form-urlencoded; charset=utf-8";
            }
            if (typeof http_post === "function") {
                return http_post(url, postHeaders, body || "");
            }
            if (typeof fetch === "function") {
                const response = await fetch(url, {
                    method: "POST",
                    headers: postHeaders,
                    body: body || ""
                });
                return {
                    status: response.status,
                    body: await response.text()
                };
            }
            throw new Error("POST requests are not supported in this runtime");
        }
        return fetchText(url, headers);
    }

    async function fetchRemoteBaseUrls() {
        if (remoteBaseUrlsPromise) return remoteBaseUrlsPromise;

        remoteBaseUrlsPromise = (async () => {
            const endpoint = `https://firebaseremoteconfig.googleapis.com/v1/projects/${FIREBASE_CONFIG.projectNumber}/namespaces/firebase:fetch`;
            const payload = {
                appInstanceId: createAppInstanceId(),
                appInstanceIdToken: "",
                appId: FIREBASE_CONFIG.appId,
                countryCode: "US",
                languageCode: "en-US",
                platformVersion: "30",
                timeZone: "UTC",
                appVersion: FIREBASE_CONFIG.appVersion,
                appBuild: FIREBASE_CONFIG.appBuild,
                packageName: FIREBASE_CONFIG.packageName,
                sdkVersion: FIREBASE_CONFIG.sdkVersion,
                analyticsUserProperties: {}
            };
            const headers = {
                "Content-Type": "application/json",
                Accept: "application/json",
                "X-Android-Package": FIREBASE_CONFIG.packageName,
                "X-Goog-Api-Key": FIREBASE_CONFIG.apiKey,
                "X-Google-GFE-Can-Retry": "yes",
                "User-Agent": "okhttp/4.12.0"
            };

            try {
                const response = await postJson(endpoint, payload, headers);
                if (extractResponseStatus(response) >= 400) return [];

                const data = safeJsonParse(extractResponseBody(response));
                const entries = data && data.entries ? data.entries : {};
                const urls = [];
                const addUrl = (value) => {
                    const normalized = normalizeBaseUrl(value);
                    if (normalized && !urls.includes(normalized)) {
                        urls.push(normalized);
                    }
                };

                addUrl(entries.api_url);
                return urls;
            } catch (error) {
                console.error("Failed to fetch PlayZTV remote config: " + (error && error.message ? error.message : String(error)));
                return [];
            }
        })();

        return remoteBaseUrlsPromise;
    }

    async function getBaseUrls() {
        const urls = [];
        const addUrl = (value) => {
            const normalized = normalizeBaseUrl(value);
            if (normalized && !urls.includes(normalized)) {
                urls.push(normalized);
            }
        };

        addUrl(activeBaseUrl);
        try {
            (await fetchRemoteBaseUrls()).forEach(addUrl);
        } catch (error) {
            console.error(`Failed to fetch remote base URLs: ${error && error.message ? error.message : String(error)}`);
        }
        addUrl(manifest && manifest.baseUrl);
        DEFAULT_BASE_URLS.forEach(addUrl);
        return urls;
    }

    function buildPlayzHeaders(url) {
        const headers = {
            "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)"
        };
        try {
            headers.Host = new URL(String(url || "")).hostname;
        } catch (_) {}
        return headers;
    }

    async function decryptPlayzPayload(body) {
        const raw = trimToString(body);
        if (!raw) return "";
        if (raw.startsWith("{") || raw.startsWith("[") || raw.startsWith("<")) return raw;

        // Strategy 1: Native Decrypt
        try {
            const stripped = raw.replace(/\s+/g, "");
            const b1 = base64ToBytes(stripped);
            const b1Rev = new Uint8Array(b1).reverse();
            const b2 = swapAdjacentPairs(b1Rev);
            const b2Str = bytesToAscii(b2).replace(/\s+/g, "");
            const b3 = base64ToBytes(b2Str);
            const pt = await decryptAesCbcBytes(b3, PLAYZ_NATIVE_KEY, PLAYZ_NATIVE_IV);
            const text = bytesToUtf8(pt).trim();
            if (text.startsWith("{") || text.startsWith("[")) {
                return text;
            }
        } catch (_) {}

        // Strategy 2: Primary Decrypt
        try {
            const stripped = raw.replace(/\s+/g, "");
            let restored = "";
            for (let i = 0; i < stripped.length; i++) {
                const ch = stripped[i];
                restored += PLAYZ_SUBSTITUTION_REVERSE[ch] || ch;
            }
            const b1 = base64ToBytes(restored);
            const b1Str = bytesToAscii(b1);
            const ct = base64ToBytes(b1Str);
            const pt = await decryptAesCbcBytes(ct, PLAYZ_PRIMARY_KEY, PLAYZ_PRIMARY_IV);
            const text = bytesToUtf8(pt).trim();
            if (text.startsWith("{") || text.startsWith("[")) {
                return text;
            }
        } catch (_) {}

        // Strategy 3: Fallback Decrypt
        try {
            const stripped = raw.replace(/\s+/g, "");
            const ct = base64ToBytes(stripped);
            const pt = await decryptAesCbcBytes(ct, PLAYZ_FALLBACK_KEY, PLAYZ_FALLBACK_IV);
            const text = bytesToUtf8(pt).trim();
            if (text.startsWith("{") || text.startsWith("[")) {
                return text;
            }
        } catch (_) {}

        return "";
    }

    async function fetchPlayzPayload(url) {
        if (!url || typeof url !== "string") return "";
        try {
            const response = await fetchText(url, buildPlayzHeaders(url));
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) {
                return "";
            }
            return await decryptPlayzPayload(extractResponseBody(response));
        } catch (error) {
            console.error(`Failed to fetch payload from ${url}: ${error && error.message ? error.message : String(error)}`);
            return "";
        }
    }

    async function fetchPlayzJson(path) {
        if (!path || typeof path !== "string") return null;
        const baseUrls = await getBaseUrls();
        if (!baseUrls || !Array.isArray(baseUrls) || !baseUrls.length) return null;

        for (const baseUrl of baseUrls) {
            try {
                const finalUrl = /^https?:\/\//i.test(path) ? path : `${baseUrl}/${String(path || "").replace(/^\/+/, "")}`;
                const payload = await fetchPlayzPayload(finalUrl);
                const data = safeJsonParse(payload);
                if (data) {
                    activeBaseUrl = normalizeBaseUrl(baseUrl);
                    return data;
                }
            } catch (error) {
                console.error(`Failed to fetch ${path} from ${baseUrl}: ${error && error.message ? error.message : String(error)}`);
                continue;
            }
        }
        return null;
    }

    function normalizeHeaderName(key) {
        if (!key) return "";
        const lowered = trimToString(key).toLowerCase();
        if (lowered === "user-agent") return "User-Agent";
        if (lowered === "referer" || lowered === "referrer") return "Referer";
        if (lowered === "origin") return "Origin";
        if (lowered === "cookie") return "Cookie";
        return trimToString(key);
    }

    function normalizeDrmScheme(value) {
        const normalized = trimToString(value).toLowerCase();
        if (!normalized) return "";
        if (normalized.includes("widevine")) return "widevine";
        if (normalized.includes("clearkey") || normalized.includes("clear")) return "clearkey";
        return normalized;
    }

    function normalizeDrmToken(value) {
        const normalized = trimToString(value);
        if (!normalized) return "";
        if (/^[0-9a-f-]{32,}$/i.test(normalized)) {
            return normalized.replace(/-/g, "").toLowerCase();
        }
        return normalized;
    }

    function splitUrlAndHeaders(rawUrl) {
        const value = trimToString(rawUrl);
        const result = {
            url: value,
            headers: {},
            userAgent: "",
            cookie: "",
            drmScheme: "",
            licenseUrl: "",
            key: "",
            keyid: ""
        };

        if (!value || !value.includes("|")) {
            return result;
        }

        const parts = value.split("|", 2);
        result.url = trimToString(parts[0]);
        trimToString(parts[1] || "").split("&").forEach((pair) => {
            const equalsIndex = pair.indexOf("=");
            if (equalsIndex === -1) return;

            const rawKey = trimToString(pair.slice(0, equalsIndex));
            if (!rawKey) return;

            let rawValue = trimToString(pair.slice(equalsIndex + 1));
            try {
                rawValue = decodeURIComponent(rawValue);
            } catch (_) {}

            const lowered = rawKey.toLowerCase();
            if (lowered === "drmlicense" || lowered === "licenseurl") {
                result.licenseUrl = rawValue;
                return;
            }
            if (lowered === "drmscheme") {
                result.drmScheme = normalizeDrmScheme(rawValue);
                return;
            }
            if (lowered === "key") {
                result.key = rawValue;
                return;
            }
            if (lowered === "keyid") {
                result.keyid = rawValue;
                return;
            }

            const key = normalizeHeaderName(rawKey);
            if (!key) return;
            result.headers[key] = rawValue;
            if (key === "User-Agent") result.userAgent = rawValue;
            if (key === "Cookie") result.cookie = rawValue;
        });
        return result;
    }

    function mergeHeaders(left, right) {
        if (!left || typeof left !== "object") left = {};
        if (!right || typeof right !== "object") right = {};
        return Object.assign({}, left, right);
    }

    function decodeEscapedText(text) {
        if (!text) return "";
        return String(text)
            .replace(/\\u0026/g, "&")
            .replace(/\\\//g, "/");
    }

    function tryDecodeReversedTokenPayload(text, key) {
        if (!text || typeof text !== "string") return "";
        try {
            const reversed = String(text).split("").reverse().join("");
            const decoded = typeof atob === "function"
                ? atob(reversed)
                : Buffer.from(reversed, "base64").toString("utf8");
            const parts = decoded.split("|", 2);
            if (parts.length !== 2) return "";
            const shift = parseInt(parts[0], 10);
            if (!Number.isFinite(shift)) return "";

            let decodedJson = "";
            for (const char of parts[1]) {
                const code = char.charCodeAt(0);
                if (code >= 65 && code <= 90) {
                    decodedJson += String.fromCharCode(((code - 65 - shift + 26) % 26) + 65);
                } else if (code >= 97 && code <= 122) {
                    decodedJson += String.fromCharCode(((code - 97 - shift + 26) % 26) + 97);
                } else {
                    decodedJson += char;
                }
            }
            const data = safeJsonParse(decodedJson);
            return trimToString(data && data[key]);
        } catch (_) {
            return "";
        }
    }

    function extractJsonPlaybackUrl(text, key) {
        if (!text) return "";
        const normalizedKey = trimToString(key) || "playback_url";
        const data = safeJsonParse(text);
        if (data && typeof data === "object") {
            const direct = trimToString(data[normalizedKey]);
            if (direct) return decodeEscapedText(direct);
        }

        const reversed = tryDecodeReversedTokenPayload(text, normalizedKey);
        if (reversed) return decodeEscapedText(reversed);

        const escapedKey = normalizedKey.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
        const regex = new RegExp(`"${escapedKey}"\\s*:\\s*"([^"]+)"`, "i");
        const match = regex.exec(String(text));
        if (match && match[1]) return decodeEscapedText(match[1]);
        return "";
    }

    function extractDirectMediaUrl(text, preferredHost) {
        if (!text) return "";
        const patterns = [
            /https?:\/\/[^"'\\\s<>]+?\.(?:m3u8|mpd)(?:[^"'\\\s<>]*)/ig,
            /https?:\\\/\\\/[^"'\\\s<>]+?\.(?:m3u8|mpd)(?:[^"'\\\s<>]*)/ig,
            /"hlsManifestUrl"\s*:\s*"([^"]+)"/ig,
            /"playback_url"\s*:\s*"([^"]+)"/ig
        ];

        for (const pattern of patterns) {
            const matches = String(text).match(pattern);
            if (!matches || !matches.length) continue;

            for (const candidate of matches) {
                const normalized = decodeEscapedText(candidate)
                    .replace(/^"hlsManifestUrl"\s*:\s*"/i, "")
                    .replace(/^"playback_url"\s*:\s*"/i, "")
                    .replace(/"$/, "");
                if (!normalized) continue;

                if (preferredHost) {
                    try {
                        const host = new URL(normalized).hostname.replace(/^www\./i, "");
                        if (host !== preferredHost) continue;
                    } catch (_) {}
                }

                if (/\.m3u8/i.test(normalized) || /\.mpd/i.test(normalized)) {
                    return normalized;
                }
            }
        }
        return "";
    }

    async function resolveEmbedToken(tokenConfig) {
        if (!tokenConfig || typeof tokenConfig !== "object") {
            return { url: "", headers: {} };
        }
        const request = splitUrlAndHeaders(tokenConfig.api || "");
        if (!request.url || request.url.includes("%s")) return { url: "", headers: {} };

        try {
            const response = await fetchText(request.url, mergeHeaders({
                "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36"
            }, request.headers));
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) {
                return { url: "", headers: {} };
            }

            const html = extractResponseBody(response);
            let resolved = extractJsonPlaybackUrl(html, tokenConfig.link_key || "playback_url");
            if (!resolved) resolved = extractDirectMediaUrl(html);

            const parsed = splitUrlAndHeaders(resolved);
            return {
                url: parsed.url,
                headers: mergeHeaders(request.headers, parsed.headers)
            };
        } catch (error) {
            console.error(`Failed to resolve embed token: ${error && error.message ? error.message : String(error)}`);
            return { url: "", headers: {} };
        }
    }

    async function resolveStructuredToken(tokenConfig, allowReversePayload) {
        if (!tokenConfig || typeof tokenConfig !== "object") {
            return { url: "", headers: {} };
        }
        const request = splitUrlAndHeaders(tokenConfig.api || "");
        if (!request.url || request.url.includes("%s")) return { url: "", headers: {} };

        try {
            const response = await fetchWithMethod(
                request.url,
                tokenConfig.request_type || "get",
                request.headers,
                tokenConfig.request_body || "",
                tokenConfig.request_body_type || "normal"
            );
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) {
                return { url: "", headers: {} };
            }

            let resolved = extractJsonPlaybackUrl(extractResponseBody(response), tokenConfig.link_key || "playback_url");
            if (!resolved && allowReversePayload) {
                resolved = tryDecodeReversedTokenPayload(extractResponseBody(response), tokenConfig.link_key || "playback_url");
            }
            if (!resolved) return { url: "", headers: {} };

            const parsed = splitUrlAndHeaders(resolved);
            return {
                url: parsed.url,
                headers: mergeHeaders(request.headers, parsed.headers)
            };
        } catch (error) {
            console.error(`Failed to resolve structured token: ${error && error.message ? error.message : String(error)}`);
            return { url: "", headers: {} };
        }
    }

    async function resolveTokenizedStream(entry) {
        if (!entry || typeof entry !== "object") return null;
        if (!entry.tokenApi || typeof entry.tokenApi !== "string") return null;

        const tokenConfig = safeJsonParse(entry.tokenApi);
        if (!tokenConfig || typeof tokenConfig !== "object") return null;

        const tokenType = trimToString(tokenConfig.type || "token").toLowerCase();
        try {
            if (tokenType === "sp" || tokenType === "json") {
                const resolved = await resolveStructuredToken(tokenConfig, true);
                if (resolved && resolved.url) return resolved;
            } else if (tokenType === "embed" || tokenType === "html" || tokenType === "yt") {
                const resolved = await resolveEmbedToken(tokenConfig);
                if (resolved && resolved.url) return resolved;
            }
        } catch (error) {
            console.error("Token resolution failed for " + ((entry && entry.name) || "stream") + ": " + (error && error.message ? error.message : String(error)));
        }
        return null;
    }

    function parsePlayzUtcDateTime(dateText, timeText) {
        const dateValue = trimToString(dateText);
        const timeValue = trimToString(timeText);
        const dateMatch = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/.exec(dateValue);
        const timeMatch = /^(\d{1,2}):(\d{1,2})(?::(\d{1,2}))?$/.exec(timeValue);
        if (!dateMatch || !timeMatch) return NaN;

        const day = parseInt(dateMatch[1], 10);
        const month = parseInt(dateMatch[2], 10) - 1;
        const year = parseInt(dateMatch[3], 10);
        const hour = parseInt(timeMatch[1], 10);
        const minute = parseInt(timeMatch[2], 10);
        const second = parseInt(timeMatch[3] || "0", 10);
        return Date.UTC(year, month, day, hour, minute, second);
    }

    function buildEventStatus(event) {
        if (!event || typeof event !== "object") return "LIVE";
        const now = Date.now();
        const start = parsePlayzUtcDateTime(event && event.date, event && event.time);
        const end = parsePlayzUtcDateTime(event && event.endDate, event && event.endTime);

        if (Number.isFinite(end) && now >= end) return "ENDED";
        if (Number.isFinite(start) && now >= start) return "LIVE";
        if (Number.isFinite(start) && now < start) return "UPCOMING";
        return "LIVE";
    }

    function buildEventStatusPrefix(event) {
        const status = buildEventStatus(event);
        if (status === "LIVE") return "🔴";
        if (status === "UPCOMING") return "🔜";
        if (status === "ENDED") return "✅";
        return "";
    }

    function normalizeCategoryName(name) {
        const value = trimToString(name) || "Other";
        return value.replace(/\s+/g, " ").trim();
    }

    function getCategoryIcon(name) {
        const lowered = String(name || "").toLowerCase();
        if (lowered.includes("cricket")) return "🏏";
        if (lowered.includes("football") || lowered.includes("soccer")) return "⚽";
        if (lowered.includes("motorsport") || lowered.includes("formula") || lowered.includes("racing") || lowered.includes("f1")) return "🏎️";
        if (lowered.includes("basketball") || lowered.includes("nba")) return "🏀";
        if (lowered.includes("tennis")) return "🎾";
        if (lowered.includes("boxing") || lowered.includes("fight") || lowered.includes("ufc") || lowered.includes("mma")) return "🥊";
        if (lowered.includes("hockey")) return "🏒";
        if (lowered.includes("wwe") || lowered.includes("wrestling")) return "🤼";
        if (lowered.includes("badminton")) return "🏸";
        if (lowered.includes("volleyball")) return "🏐";
        if (lowered.includes("baseball")) return "⚾";
        if (lowered.includes("rugby") || lowered.includes("nfl") || lowered.includes("american football")) return "🏈";
        return "📺";
    }

    function getCategorySectionTitle(name) {
        const cleanName = normalizeCategoryName(name);
        const icon = getCategoryIcon(cleanName);
        return `${icon} ${cleanName}`;
    }

    function buildEventTitle(event) {
        if (!event || typeof event !== "object") return "Live Event";
        const teamA = trimToString(event && event.teamAName);
        const teamB = trimToString(event && event.teamBName);
        if (teamA && teamB) {
            if (teamA === teamB) return teamA;
            return `${teamA} vs ${teamB}`;
        }
        return trimToString(event && event.teamAName) || trimToString(event && event.eventName) || "Live Event";
    }

    function buildEventPoster(event) {
        if (!event || typeof event !== "object") {
            return `${MATCH_CARD_API}?title=${encodeURIComponent("Live Event")}&teamA=${encodeURIComponent("Team A")}&teamB=${encodeURIComponent("Team B")}`;
        }
        const title = encodeURIComponent(trimToString(event && event.eventName) || "Live Event");
        let url = `${MATCH_CARD_API}?title=${title}&teamA=${encodeURIComponent(trimToString(event && event.teamAName) || "Team A")}&teamB=${encodeURIComponent(trimToString(event && event.teamBName) || "Team B")}`;
        if (trimToString(event && event.teamAFlag)) url += "&teamAImg=" + encodeURIComponent(event.teamAFlag);
        if (trimToString(event && event.teamBFlag)) url += "&teamBImg=" + encodeURIComponent(event.teamBFlag);
        if (trimToString(event && event.eventLogo)) url += "&eventLogo=" + encodeURIComponent(event.eventLogo);
        if (trimToString(event && event.date) && trimToString(event && event.time)) {
            url += "&time=" + encodeURIComponent(`${event.date} ${event.time} UTC`);
        }
        const status = buildEventStatus(event);
        url += `&isLive=${status === "LIVE"}&isEnded=${status === "ENDED"}`;
        return url;
    }

    function parseEventEntry(rawEntry, index) {
        if (!rawEntry) return null;
        let eventObject = rawEntry;
        if (typeof rawEntry === "string") {
            eventObject = safeJsonParse(rawEntry);
        } else if (rawEntry.event) {
            eventObject = typeof rawEntry.event === "string" ? safeJsonParse(rawEntry.event) : rawEntry.event;
        }
        if (!eventObject || typeof eventObject !== "object") return null;
        if (eventObject.visible === false) return null;

        const linksPath = trimToString(eventObject.links);
        if (!linksPath) return null;

        const slug = linksPath.replace(/\.txt$/i, "");
        return {
            id: index + 1,
            category: normalizeCategoryName(eventObject.category),
            eventName: trimToString(eventObject.eventName),
            eventLogo: trimToString(eventObject.eventLogo),
            teamAName: trimToString(eventObject.teamAName),
            teamBName: trimToString(eventObject.teamBName),
            teamAFlag: trimToString(eventObject.teamAFlag),
            teamBFlag: trimToString(eventObject.teamBFlag),
            linksPath: linksPath,
            slug: slug,
            date: trimToString(eventObject.date),
            time: trimToString(eventObject.time),
            endDate: trimToString(eventObject.end_date),
            endTime: trimToString(eventObject.end_time),
            visible: eventObject.visible !== false,
            priority: Number.isFinite(eventObject.priority) ? eventObject.priority : parseInt(eventObject.priority || "-1", 10),
            linkNames: Array.isArray(eventObject.link_names) ? eventObject.link_names : []
        };
    }

    function sortEvents(events) {
        if (!Array.isArray(events)) return [];
        const weight = {
            LIVE: 0,
            UPCOMING: 1,
            ENDED: 2
        };

        return events.slice().sort((left, right) => {
            const leftStatus = buildEventStatus(left);
            const rightStatus = buildEventStatus(right);
            const statusDiff = (weight[leftStatus] || 9) - (weight[rightStatus] || 9);
            if (statusDiff !== 0) return statusDiff;

            const leftStart = parsePlayzUtcDateTime(left.date, left.time);
            const rightStart = parsePlayzUtcDateTime(right.date, right.time);
            if (Number.isFinite(leftStart) && Number.isFinite(rightStart) && leftStart !== rightStart) {
                return leftStart - rightStart;
            }

            const leftPriority = Number.isFinite(left.priority) ? left.priority : 9999;
            const rightPriority = Number.isFinite(right.priority) ? right.priority : 9999;
            if (leftPriority !== rightPriority) return leftPriority - rightPriority;

            return buildEventTitle(left).localeCompare(buildEventTitle(right));
        });
    }

    async function fetchPlayzEvents() {
        try {
            const data = await fetchPlayzJson("events.txt");
            if (!Array.isArray(data)) return [];
            return sortEvents(data.map((entry, idx) => parseEventEntry(entry, idx)).filter(Boolean));
        } catch (error) {
            console.error(`Failed to fetch PlayZTV events: ${error && error.message ? error.message : String(error)}`);
            return [];
        }
    }

    function buildHomeItem(event) {
        if (!event || typeof event !== "object") {
            throw new Error("Invalid event data for buildHomeItem");
        }
        const displayTitle = buildEventTitle(event);
        const prefix = buildEventStatusPrefix(event);
        const fullTitle = prefix ? `${prefix} ${displayTitle}` : displayTitle;
        const poster = buildEventPoster(event);

        return new MultimediaItem({
            title: fullTitle,
            description: trimToString(event.eventName) || "Live Event",
            posterUrl: poster,
            type: "livestream",
            url: JSON.stringify({
                title: displayTitle,
                fullTitle: fullTitle,
                poster: poster,
                category: event.category,
                eventName: event.eventName,
                linksPath: event.linksPath,
                slug: event.slug,
                date: event.date,
                time: event.time,
                endDate: event.endDate,
                endTime: event.endTime,
                teamAName: event.teamAName,
                teamBName: event.teamBName,
                eventLogo: event.eventLogo,
                linkNames: event.linkNames
            })
        });
    }

    function getStreamHost(url) {
        if (!url || typeof url !== "string") return "";
        try {
            return new URL(String(url)).hostname.toLowerCase();
        } catch (_) {
            return "";
        }
    }

    function matchesHost(host, entries) {
        if (!host || typeof host !== "string" || !Array.isArray(entries)) return false;
        const normalized = trimToString(host).toLowerCase();
        return entries.some((entry) => normalized === entry || normalized.endsWith(`.${entry}`));
    }

    function parseHlsAttributes(line) {
        const attributes = {};
        const regex = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/g;
        let match;
        while ((match = regex.exec(String(line || ""))) !== null) {
            const key = trimToString(match[1]).toUpperCase();
            const value = trimToString(match[2]).replace(/^"|"$/g, "");
            if (key) attributes[key] = value;
        }
        return attributes;
    }

    function resolveVariantUrl(baseUrl, variantPath) {
        const target = trimToString(variantPath);
        if (!target) return "";
        try {
            const resolved = new URL(target, baseUrl);
            const base = new URL(baseUrl);
            if (!resolved.search && !target.includes("?") && base.search) {
                resolved.search = base.search;
            }
            return resolved.toString();
        } catch (_) {
            return target;
        }
    }

    function parseVariantQuality(attributes) {
        if (!attributes || typeof attributes !== "object") return 0;
        let resolution = trimToString(attributes.RESOLUTION);
        const resolutionMatch = /(\d+)\s*x\s*(\d+)/i.exec(resolution);
        if (resolutionMatch) return parseInt(resolutionMatch[2], 10) || 0;

        let bandwidth = parseInt(attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0", 10);
        if (!bandwidth || bandwidth < 1) return 0;
        if (bandwidth >= 20000000) return 8160;
        if (bandwidth >= 10000000) return 4320;
        if (bandwidth >= 6000000) return 1080;
        if (bandwidth >= 3000000) return 720;
        if (bandwidth >= 1500000) return 480;
        if (bandwidth >= 800000) return 360;
        if (bandwidth >= 400000) return 240;
        if (bandwidth >= 200000) return 144;
        return 0;
    }

    function buildVariantSource(baseSource, attributes, fallbackIndex) {
        const quality = parseVariantQuality(attributes);
        if (quality > 0) {
            return {
                quality,
                source: `${baseSource} ${quality}p`
            };
        }
        const bandwidth = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (bandwidth > 0) {
            return {
                quality: 0,
                source: `${baseSource} ${Math.max(1, Math.round(bandwidth / 1000))}kbps`
            };
        }
        return {
            quality: 0,
            source: `${baseSource} Variant ${fallbackIndex + 1}`
        };
    }

    function parseHlsMasterPlaylist(manifestText, manifestUrl) {
        const info = { variants: [] };
        const lines = String(manifestText || "").split(/\r?\n/);
        let pendingAttributes = null;

        lines.forEach((rawLine) => {
            const line = trimToString(rawLine);
            if (!line) return;
            if (line.startsWith("#EXT-X-STREAM-INF:")) {
                pendingAttributes = parseHlsAttributes(line.slice("#EXT-X-STREAM-INF:".length));
                return;
            }
            if (line.startsWith("#")) return;

            if (pendingAttributes) {
                const resolved = resolveVariantUrl(manifestUrl, line);
                if (resolved) {
                    info.variants.push({
                        url: resolved,
                        attributes: pendingAttributes
                    });
                }
                pendingAttributes = null;
            }
        });
        return info;
    }

    async function expandHlsStreams(sourceLabel, parsed, drmInfo) {
        if (!parsed || !parsed.url) return [];
        const isHls = /\.m3u8(?:$|[?#])/i.test(parsed.url) || parsed.url.includes("/hls/");
        if (!isHls) return [];

        try {
            const response = await fetchText(parsed.url, drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {}));
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return [];

            const manifestText = trimToString(extractResponseBody(response));
            if (!manifestText.startsWith("#EXTM3U") || !manifestText.includes("#EXT-X-STREAM-INF")) return [];

            const manifestInfo = parseHlsMasterPlaylist(manifestText, parsed.url);
            const variants = manifestInfo && Array.isArray(manifestInfo.variants) ? manifestInfo.variants : [];
            const seen = {};
            const streams = [];

            variants.forEach((variant, index) => {
                const playbackUrl = trimToString(variant.url);
                if (!variant || !playbackUrl || seen[playbackUrl]) return;
                seen[playbackUrl] = true;
                const variantInfo = buildVariantSource(sourceLabel, variant.attributes || {}, index);
                streams.push(createStreamResult(variantInfo.source, {
                    url: playbackUrl,
                    headers: drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {})
                }, drmInfo, variantInfo.quality));
            });
            return streams;
        } catch (_) {
            return [];
        }
    }

    function createStreamResult(source, parsed, drmInfo, quality) {
        if (!parsed || typeof parsed !== "object") {
            throw new Error("Invalid parsed data for createStreamResult");
        }
        const streamHeaders = mergeHeaders({}, drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {}));
        const stream = new StreamResult({
            source: source || "Auto",
            url: parsed.url,
            headers: streamHeaders
        });
        if (typeof quality === "number" && quality > 0) {
            stream.quality = quality;
        }
        if (drmInfo && drmInfo.drmKey && drmInfo.drmKid) {
            stream.drmKey = drmInfo.drmKey;
            stream.drmKid = drmInfo.drmKid;
            stream.drmType = normalizeDrmScheme(drmInfo.drmType) || "clearkey";
        } else if (drmInfo && drmInfo.licenseUrl) {
            stream.licenseUrl = drmInfo.licenseUrl;
            stream.drmLicenseUrl = drmInfo.licenseUrl;
            stream.drmType = normalizeDrmScheme(drmInfo.drmType) || "widevine";
        }
        return stream;
    }

    function scoreStream(sourceLabel, parsed, rawApi, quality, isVariant) {
        if (!parsed || typeof parsed !== "object") return 0;
        const url = trimToString(parsed && parsed.url);
        const headers = parsed && parsed.headers && typeof parsed.headers === "object" ? parsed.headers : {};
        const source = trimToString(sourceLabel).toLowerCase();
        const host = getStreamHost(url);
        const hasDrm = trimToString(rawApi).includes(":");
        const isDash = /\.mpd(?:$|[?#])/i.test(url);
        const isHls = /\.m3u8(?:$|[?#])/i.test(url) || /\/hls\//i.test(url);

        let score = 0;
        if (/^https?:\/\//i.test(url)) score += 10;
        if (isDash) score += 25;
        if (isHls) score += 15;
        if (hasDrm) score += 45;
        if (Object.keys(headers).length) score += 4;
        if (headers.Cookie) score += 8;
        if (headers.Referer) score += 6;
        if (headers["User-Agent"]) score += 2;
        if (typeof quality === "number" && quality > 0) score += Math.min(Math.round(quality / 180), 6);

        if (matchesHost(host, PLAYZ_TRUSTED_HOSTS)) score += 20;
        if (matchesHost(host, PLAYZ_WEAK_HOSTS)) score -= 30;

        if (source.includes("low")) score -= 12;
        if (source.includes("sd")) score -= 5;
        if (source.includes("backup")) score -= 3;
        if (isVariant) score -= 1;

        return score;
    }

    function createRankedStream(source, parsed, drmInfo, quality, order, isVariant) {
        return {
            score: scoreStream(source, {
                url: parsed.url,
                headers: drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {})
            }, trimToString(drmInfo && (drmInfo.drmKey || drmInfo.licenseUrl || drmInfo.drmType)), quality, isVariant),
            order,
            stream: createStreamResult(source, parsed, drmInfo, quality)
        };
    }

    async function buildResolvedStream(entry) {
        if (!entry || typeof entry !== "object") return null;

        const tokenResolved = await resolveTokenizedStream(entry);
        if (tokenResolved && tokenResolved.url) {
            const parsedToken = splitUrlAndHeaders(tokenResolved.url);
            return {
                url: parsedToken.url,
                headers: mergeHeaders(tokenResolved.headers, parsedToken.headers),
                drmScheme: parsedToken.drmScheme || "",
                licenseUrl: parsedToken.licenseUrl || "",
                key: parsedToken.key || "",
                keyid: parsedToken.keyid || ""
            };
        }

        const parsed = splitUrlAndHeaders(entry && entry.link);
        if (!parsed.url) return null;
        return parsed;
    }

    async function resolveStreamDrm(rawApi, parsed, streamUrl, baseHeaders) {
        if (!parsed || typeof parsed !== "object") {
            return {
                headers: mergeHeaders({}, baseHeaders || {}),
                drmType: "",
                drmKey: "",
                drmKid: "",
                licenseUrl: ""
            };
        }

        const streamHeaders = mergeHeaders({}, baseHeaders || {}, parsed && parsed.headers ? parsed.headers : {});
        let drmScheme = normalizeDrmScheme(parsed && parsed.drmScheme);
        let drmKey = normalizeDrmToken(parsed && parsed.key);
        let drmKid = normalizeDrmToken(parsed && parsed.keyid);
        let licenseUrl = trimToString(parsed && parsed.licenseUrl);

        const rawValue = trimToString(rawApi);
        if (rawValue) {
            if (rawValue.includes(":")) {
                const parts = rawValue.split(":");
                if (parts.length === 2) {
                    drmKid = normalizeDrmToken(parts[0]);
                    drmKey = normalizeDrmToken(parts[1]);
                    drmScheme = "clearkey";
                }
            } else if (/^https?:\/\//i.test(rawValue)) {
                licenseUrl = rawValue;
                drmScheme = "widevine";
            }
        }

        return {
            headers: streamHeaders,
            drmType: drmKey && drmKid ? "clearkey" : (drmScheme || (licenseUrl ? "widevine" : "")),
            drmKey,
            drmKid,
            licenseUrl
        };
    }

    async function processStreamEntry(entry, index) {
        if (!entry || typeof entry !== "object") return [];
        const resolved = await buildResolvedStream(entry);
        if (!resolved || !resolved.url) return [];

        const rawApi = trimToString(entry && entry.api);
        const sourceLabel = trimToString(entry && entry.name) || `Server ${index + 1}`;

        // Ensure default User-Agent for m3u/m3u8 if not present
        if (/\.m3u(?:8)?(?:$|[?#])/i.test(resolved.url) && (!resolved.headers || !resolved.headers["User-Agent"])) {
            resolved.headers = mergeHeaders(resolved.headers || {}, {
                "User-Agent": "Mozilla/5.0 (Linux; Android 10; Pixel 3 XL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36"
            });
        }

        const drmInfo = await resolveStreamDrm(rawApi, resolved, resolved.url, resolved.headers || {});
        const rankedStreams = [
            createRankedStream(sourceLabel, resolved, drmInfo, 0, index * 100, false)
        ];

        try {
            const variants = await expandHlsStreams(sourceLabel, resolved, drmInfo);
            variants.forEach((variant, variantIndex) => {
                rankedStreams.push(createRankedStream(
                    trimToString(variant && variant.source) || sourceLabel,
                    {
                        url: trimToString(variant && variant.url),
                        headers: variant && variant.headers ? variant.headers : (drmInfo.headers || resolved.headers || {})
                    },
                    drmInfo,
                    typeof (variant && variant.quality) === "number" ? variant.quality : 0,
                    (index * 100) + variantIndex + 1,
                    true
                ));
            });
        } catch (_) {}

        return rankedStreams;
    }

    async function getHome(cb) {
        if (typeof cb !== "function") throw new Error("Callback function is required");

        try {
            const events = await fetchPlayzEvents();
            if (!events || !Array.isArray(events)) {
                return cb({
                    success: false,
                    errorCode: "INVALID_DATA",
                    message: "Invalid events data format"
                });
            }

            if (!events.length) {
                return cb({
                    success: false,
                    errorCode: "SITE_OFFLINE",
                    message: "Failed to load events from the available PlayZTV hosts"
                });
            }

            const categoryOrder = ["Cricket", "Football", "Basketball", "Motorsport", "Tennis", "Boxing"];
            const categories = {};

            events.forEach((event) => {
                if (!event || typeof event !== "object") return;
                const sectionTitle = getCategorySectionTitle(event.category);
                if (!categories[sectionTitle]) {
                    categories[sectionTitle] = [];
                }
                categories[sectionTitle].push(buildHomeItem(event));
            });

            const orderedCategories = {};
            const sectionKeys = Object.keys(categories);

            sectionKeys.sort((left, right) => {
                const leftClean = left.replace(/^[^\w\s]+\s*/, "");
                const rightClean = right.replace(/^[^\w\s]+\s*/, "");
                let leftIdx = categoryOrder.findIndex(c => leftClean.toLowerCase().includes(c.toLowerCase()));
                let rightIdx = categoryOrder.findIndex(c => rightClean.toLowerCase().includes(c.toLowerCase()));
                if (leftIdx === -1) leftIdx = 99;
                if (rightIdx === -1) rightIdx = 99;
                if (leftIdx !== rightIdx) return leftIdx - rightIdx;
                return left.localeCompare(right);
            });

            sectionKeys.forEach((key) => {
                if (categories[key] && categories[key].length) {
                    orderedCategories[key] = categories[key];
                }
            });

            Analytics.logEvent('playeztvliveevents_home', {});
            cb({ success: true, data: orderedCategories });
        } catch (error) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: error && error.message ? error.message : String(error)
            });
        }
    }

    async function search(query, cb) {
        if (typeof cb !== "function") throw new Error("Callback function is required");

        try {
            const events = await fetchPlayzEvents();
            if (!events || !Array.isArray(events) || !events.length) {
                return cb({ success: true, data: [] });
            }

            const loweredQuery = trimToString(query).toLowerCase();
            const results = events.filter((event) => {
                if (!event || typeof event !== "object") return false;
                const haystack = [
                    event.category,
                    event.eventName,
                    event.teamAName,
                    event.teamBName
                ].filter(Boolean).join(" ").toLowerCase();
                return haystack.includes(loweredQuery);
            }).map(buildHomeItem);

            Analytics.logEvent('playeztvliveevents_search', {});
            cb({ success: true, data: results });
        } catch (_) {
            cb({ success: true, data: [] });
        }
    }

    async function load(urlStr, cb) {
        if (!urlStr || typeof urlStr !== "string") {
            return cb({ success: false, errorCode: "INVALID_INPUT", message: "Invalid URL string" });
        }

        try {
            const data = typeof urlStr === "object" ? urlStr : JSON.parse(urlStr);
            if (!data || typeof data !== "object") {
                throw new Error("Invalid event data format");
            }

            const plotParts = [
                trimToString(data.category) ? `📌 Category: ${data.category}` : "",
                trimToString(data.eventName) ? `🏆 Event: ${data.eventName}` : "",
                trimToString(data.date) ? `🕐 Time: ${data.date} ${trimToString(data.time)} UTC` : "",
                data.linkNames && data.linkNames.length ? `📡 Servers: ${data.linkNames.length} available` : ""
            ].filter(Boolean);

            Analytics.logEvent('playeztvliveevents_load', {});
            cb({
                success: true,
                data: new MultimediaItem({
                    title: data.title || "Live Event",
                    url: urlStr,
                    posterUrl: data.poster,
                    description: plotParts.join("\n"),
                    type: "livestream",
                    episodes: [
                        new Episode({
                            name: "Watch Live",
                            season: 1,
                            episode: 1,
                            url: urlStr,
                            posterUrl: data.poster
                        })
                    ]
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: "Invalid event data: " + (error && error.message ? error.message : String(error)) });
        }
    }

    async function loadStreams(urlStr, cb) {
        if (!urlStr || typeof urlStr !== "string") {
            return cb({ success: false, errorCode: "INVALID_INPUT", message: "Invalid URL string" });
        }

        try {
            const data = typeof urlStr === "object" ? urlStr : JSON.parse(urlStr);
            if (!data || typeof data !== "object") {
                throw new Error("Invalid event data format");
            }

            const slug = trimToString(data.slug);
            const linksPath = trimToString(data.linksPath);
            const targetPath = slug ? `${slug}.txt` : linksPath;

            if (!targetPath) {
                return cb({ success: false, errorCode: "PARSE_ERROR", message: "Missing PlayZTV links path" });
            }

            const response = await fetchPlayzJson(targetPath);
            if (!Array.isArray(response) || !response.length) {
                return cb({ success: false, errorCode: "EMPTY_RESULT", message: "No streams found for this event" });
            }

            const rankedStreams = (await mapWithConcurrency(response, 6, processStreamEntry))
                .reduce((allStreams, entryStreams) => allStreams.concat(entryStreams || []), []);

            if (!rankedStreams.length) {
                return cb({ success: false, errorCode: "EMPTY_RESULT", message: "No playable streams resolved for this event" });
            }

            rankedStreams.sort((left, right) => {
                if (right.score !== left.score) return right.score - left.score;
                return left.order - right.order;
            });

            Analytics.logEvent('playeztvliveevents_loadstreams', {});
            cb({ success: true, data: rankedStreams.map((entry) => entry.stream) });
        } catch (error) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: "Failed to load streams: " + (error && error.message ? error.message : String(error))
            });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
