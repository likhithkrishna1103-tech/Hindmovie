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
    const PLAYZ_AES_KEY = "bTVLbDVuazR4SzFrTjdwTg==";
    const PLAYZ_AES_IV = "azVLNG5NOG1LbE5MN2wxNQ==";
    const PLAYZ_PRIMARY_AES_KEY = "Yi8xam1sNW5rNHg1azdwTg==";
    const PLAYZ_PRIMARY_AES_IV = "MTRuTWs4bU41S2w1S0w3bA==";
    const AES_JS_URL = "https://cdnjs.cloudflare.com/ajax/libs/aes-js/3.1.2/index.min.js";
    const PLAYZ_SUBSTITUTION_FROM = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    const PLAYZ_SUBSTITUTION_TO = "fFgGjJkKaApPbBmMoOzZeEnNcCdDrRqQtTvVuUxXhHiIwWyYlLsS";
    const PLAYZ_SUBSTITUTION_REVERSE = {};
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

    for (let index = 0; index < PLAYZ_SUBSTITUTION_TO.length; index++) {
        PLAYZ_SUBSTITUTION_REVERSE[PLAYZ_SUBSTITUTION_TO[index]] = PLAYZ_SUBSTITUTION_FROM[index];
    }

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

    function base64DecodeText(value) {
        const normalized = String(value || "");
        if (!normalized) return "";
        
        if (typeof atob === "function") {
            return atob(normalized);
        }
        if (typeof Buffer !== "undefined") {
            return Buffer.from(normalized, "base64").toString("utf8");
        }
        return "";
    }

    function base64DecodeBytes(value) {
        let normalized = String(value || "").replace(/-/g, "+").replace(/_/g, "/");
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

    function bytesToUtf8(bytes) {
        if (!bytes || !bytes.length) return "";
        if (typeof TextDecoder !== "undefined") {
            return new TextDecoder().decode(bytes);
        }
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

    function decodePlayzSubstitutionPayload(value) {
        if (!value) return "";
        
        let restored = "";
        for (const char of String(value)) {
            restored += PLAYZ_SUBSTITUTION_REVERSE[char] || char;
        }
        return base64DecodeText(restored);
    }

    async function mapWithConcurrency(items, limit, worker) {
        if (!Array.isArray(items)) {
            console.error("Invalid items array for mapWithConcurrency");
            return [];
        }
        
        if (typeof worker !== "function") {
            console.error("Invalid worker function for mapWithConcurrency");
            return [];
        }
        
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

    function decryptAesCbcWithNode(dataB64, keyB64, ivB64) {
        if (typeof Buffer === "undefined" || typeof __crypto__ === "undefined" || !__crypto__.createDecipheriv) {
            return "";
        }

        const key = Buffer.from(keyB64, "base64");
        const iv = Buffer.from(ivB64, "base64");
        const data = Buffer.from(dataB64, "base64");
        const algorithm = key.length <= 16 ? "aes-128-cbc" : (key.length <= 24 ? "aes-192-cbc" : "aes-256-cbc");
        const decipher = __crypto__.createDecipheriv(algorithm, key, iv);
        return Buffer.concat([decipher.update(data), decipher.final()]).toString("utf8");
    }

    async function getAesJs() {
        if (globalThis.aesjs) return globalThis.aesjs;
        if (!aesJsPromise) {
            aesJsPromise = (async () => {
                const response = await fetchText(AES_JS_URL, {
                    "User-Agent": "Mozilla/5.0",
                    "Referer": "https://adsflw.xyz/"
                });
                const source = extractResponseBody(response);
                if (!trimToString(source)) throw new Error("Failed to load AES runtime");
                Function(String(source || ""))();
                if (!globalThis.aesjs) throw new Error("AES runtime unavailable");
                return globalThis.aesjs;
            })();
        }
        return aesJsPromise;
    }

    async function decryptAesCbcWithWebCrypto(dataB64, keyB64, ivB64) {
        if (!globalThis.crypto || !globalThis.crypto.subtle || typeof globalThis.crypto.subtle.importKey !== "function") {
            return "";
        }
        const keyBytes = base64DecodeBytes(keyB64);
        const ivBytes = base64DecodeBytes(ivB64);
        const dataBytes = base64DecodeBytes(dataB64);
        const imported = await globalThis.crypto.subtle.importKey("raw", keyBytes, { name: "AES-CBC" }, false, ["decrypt"]);
        const plain = new Uint8Array(await globalThis.crypto.subtle.decrypt({ name: "AES-CBC", iv: ivBytes }, imported, dataBytes));
        return trimToString(bytesToUtf8(stripPkcs7(plain)));
    }

    async function decryptAesCbcWithAesJs(dataB64, keyB64, ivB64) {
        const aesjs = await getAesJs();
        const keyBytes = base64DecodeBytes(keyB64);
        const ivBytes = base64DecodeBytes(ivB64);
        const dataBytes = base64DecodeBytes(dataB64);
        const cipher = new aesjs.ModeOfOperation.cbc(keyBytes, ivBytes);
        return trimToString(bytesToUtf8(stripPkcs7(cipher.decrypt(dataBytes))));
    }

    async function decryptAesCbc(dataB64, keyB64, ivB64) {
        try {
            if (globalThis.crypto && typeof globalThis.crypto.decryptAES === "function") {
                const decrypted = await globalThis.crypto.decryptAES(dataB64, keyB64, ivB64);
                if (trimToString(decrypted)) return trimToString(decrypted);
            }
        } catch (_) {
            // Continue through the runtime fallbacks below.
        }

        try {
            const decrypted = await decryptAesCbcWithWebCrypto(dataB64, keyB64, ivB64);
            if (trimToString(decrypted)) return decrypted;
        } catch (_) {}

        try {
            const decrypted = decryptAesCbcWithNode(dataB64, keyB64, ivB64);
            if (trimToString(decrypted)) return trimToString(decrypted);
        } catch (_) {}

        try {
            const decrypted = await decryptAesCbcWithAesJs(dataB64, keyB64, ivB64);
            if (trimToString(decrypted)) return decrypted;
        } catch (_) {}

        return "";
    }

    async function postJson(url, payload, headers) {
        if (!url || typeof url !== "string") {
            throw new Error("Invalid URL for postJson");
        }
        
        if (!payload || typeof payload !== "object") {
            throw new Error("Invalid payload for postJson");
        }
        
        const body = JSON.stringify(payload);
        try {
            if (typeof http_post === "function") {
                return http_post(url, headers || {}, body);
            }
            if (typeof fetch === "function") {
                const response = await fetch(url, {
                    method: "POST",
                    headers,
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
        } catch (_) {
            // Ignore invalid URLs.
        }

        return headers;
    }

    async function decryptPlayzPayload(body) {
        const raw = trimToString(body);
        if (!raw) return "";
        if (raw.startsWith("{") || raw.startsWith("[") || raw.startsWith("<")) return raw;

        try {
            const primaryPayload = decodePlayzSubstitutionPayload(raw.replace(/\s/g, ""));
            const decrypted = await decryptAesCbc(primaryPayload, PLAYZ_PRIMARY_AES_KEY, PLAYZ_PRIMARY_AES_IV);
            const normalized = trimToString(decrypted);
            if (normalized) return normalized;
        } catch (_) {
            // Fall back to the older PlayZTV payload format below.
        }

        try {
            const decrypted = await decryptAesCbc(raw.replace(/\s/g, ""), PLAYZ_AES_KEY, PLAYZ_AES_IV);
            return trimToString(decrypted);
        } catch (_) {
            return "";
        }
    }

    async function fetchPlayzPayload(url) {
        if (!url || typeof url !== "string") {
            console.error("Invalid URL for fetchPlayzPayload");
            return "";
        }
        
        try {
            const response = await fetchText(url, buildPlayzHeaders(url));
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) {
                return "";
            }
            return decryptPlayzPayload(extractResponseBody(response));
        } catch (error) {
            console.error(`Failed to fetch payload from ${url}: ${error && error.message ? error.message : String(error)}`);
            return "";
        }
    }

    async function fetchPlayzJson(path) {
        if (!path || typeof path !== "string") {
            console.error("Invalid path for fetchPlayzJson");
            return null;
        }
        
        const baseUrls = await getBaseUrls();
        if (!baseUrls || !Array.isArray(baseUrls) || !baseUrls.length) {
            console.error("No base URLs available for fetchPlayzJson");
            return null;
        }
        
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
                // Continue to next URL for recovery
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
            } catch (_) {
                // Keep raw value.
            }

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
                    } catch (_) {
                        // Ignore invalid URLs.
                    }
                }

                if (/\.m3u8/i.test(normalized) || /\.mpd/i.test(normalized)) {
                    return normalized;
                }
            }
        }

        return "";
    }

    function extractHtmlPackedSource(text) {
        if (!text) return "";
        
        const sourceMatch = /player\.load\(\{[^}]*source:\s*([a-zA-Z0-9_]+)\(/i.exec(String(text));
        if (!sourceMatch || !sourceMatch[1]) return "";

        const functionPattern = new RegExp(`function\\s+${sourceMatch[1]}\\s*\\(\\)\\s*\\{([\\s\\S]*?)\\}`, "i");
        const functionMatch = functionPattern.exec(String(text));
        if (!functionMatch || !functionMatch[1]) return "";

        const joinMatch = /\[([\s\S]*?)\]\.join/i.exec(functionMatch[1]);
        if (!joinMatch || !joinMatch[1]) return "";

        return joinMatch[1]
            .split(/","|"/)
            .map((entry) => trimToString(entry))
            .filter(Boolean)
            .join("")
            .replace(/\\\//g, "/");
    }

    function extractPlaybackUrlFromObfuscatedHtml(text) {
        if (!text) return "";
        
        const html = String(text);
        const playbackVarMatch = /var\s+([A-Za-z_$][A-Za-z0-9_$]*)\s*=\s*""\s*,\s*([A-Za-z_$][A-Za-z0-9_$]*)\s*=\s*\[\s*\]/.exec(html);
        if (!playbackVarMatch) return "";

        const arrayVar = playbackVarMatch[2];
        const arrayMatch = new RegExp(`${arrayVar}\\s*=\\s*(\\[[\\s\\S]*?\\]);`).exec(html);
        if (!arrayMatch || !arrayMatch[1]) return "";

        const arrayData = safeJsonParse(arrayMatch[1]);
        if (!Array.isArray(arrayData) || !arrayData.length) return "";

        const functionNamesMatch = new RegExp(`var\\s+k\\s*=\\s*([A-Za-z_$][A-Za-z0-9_$]*)\\(\\)\\s*\\+\\s*([A-Za-z_$][A-Za-z0-9_$]*)\\(\\)`).exec(html);
        if (!functionNamesMatch) return "";

        const firstValueMatch = new RegExp(`function\\s+${functionNamesMatch[1]}\\s*\\(\\)\\s*\\{\\s*return\\s+([0-9]+);\\s*\\}`).exec(html);
        const secondValueMatch = new RegExp(`function\\s+${functionNamesMatch[2]}\\s*\\(\\)\\s*\\{\\s*return\\s+([0-9]+);\\s*\\}`).exec(html);
        const firstValue = firstValueMatch ? parseInt(firstValueMatch[1], 10) : NaN;
        const secondValue = secondValueMatch ? parseInt(secondValueMatch[1], 10) : NaN;
        if (!Number.isFinite(firstValue) || !Number.isFinite(secondValue)) return "";

        const offset = firstValue + secondValue;
        const sorted = arrayData.slice().sort((left, right) => {
            const leftIndex = Array.isArray(left) ? parseInt(left[0], 10) : 0;
            const rightIndex = Array.isArray(right) ? parseInt(right[0], 10) : 0;
            return leftIndex - rightIndex;
        });

        let url = "";
        for (const entry of sorted) {
            if (!Array.isArray(entry) || entry.length < 2) continue;
            try {
                const decoded = typeof atob === "function"
                    ? atob(String(entry[1]))
                    : Buffer.from(String(entry[1]), "base64").toString("utf8");
                const digits = decoded.replace(/\D/g, "");
                if (!digits) continue;
                url += String.fromCharCode(parseInt(digits, 10) - offset);
            } catch (_) {
                return "";
            }
        }

        return trimToString(url);
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
            if (!resolved) resolved = extractPlaybackUrlFromObfuscatedHtml(html);
            if (!resolved) resolved = extractHtmlPackedSource(html);

            let preferredHost = "";
            try {
                preferredHost = trimToString(tokenConfig.url ? new URL(tokenConfig.url).hostname.replace(/^www\./i, "") : "");
            } catch (_) {
                preferredHost = "";
            }
            if (!resolved) resolved = extractDirectMediaUrl(html, preferredHost);

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

    function buildEventStatus(event) {
        if (!event || typeof event !== "object") {
            return "LIVE";
        }
        
        const now = Date.now();
        const start = parsePlayzUtcDateTime(event && event.date, event && event.time);
        const end = parsePlayzUtcDateTime(event && event.endDate, event && event.endTime);

        if (Number.isFinite(end) && now >= end) return "ENDED";
        if (Number.isFinite(start) && now >= start) return "LIVE";
        if (Number.isFinite(start) && now < start) return "UPCOMING";
        return "LIVE";
    }

    function buildEventStatusPrefix(event) {
        if (!event || typeof event !== "object") {
            return "[LIVE]";
        }
        
        const status = buildEventStatus(event);
        if (status === "LIVE") return "[LIVE]";
        if (status === "UPCOMING") return "[SOON]";
        return "[ENDED]";
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

    function normalizeCategoryName(name) {
        const value = trimToString(name) || "Other";
        return value.replace(/\s+/g, " ").trim();
    }

    function getCategoryLabel(name) {
        const category = normalizeCategoryName(name);
        if (/cricket/i.test(category)) return "Cricket";
        if (/football|soccer/i.test(category)) return "Football";
        if (/basketball/i.test(category)) return "Basketball";
        if (/tennis/i.test(category)) return "Tennis";
        if (/boxing/i.test(category)) return "Boxing";
        if (/motorsport|motorsports|formula|racing/i.test(category)) return "Motorsport";
        if (/wwe|wrestling/i.test(category)) return "WWE";
        return category;
    }

    function buildEventTitle(event) {
        if (!event || typeof event !== "object") {
            return "Live Event";
        }
        
        const teamA = trimToString(event && event.teamAName);
        const teamB = trimToString(event && event.teamBName);
        if (teamA && teamB) {
            if (teamA === teamB) return teamA;
            return `${teamA} vs ${teamB}`;
        }
        return trimToString(event && event.eventName) || "Live Event";
    }

    function buildEventPoster(event) {
        if (!event || typeof event !== "object") {
            return `${MATCH_CARD_API}?title=${encodeURIComponent("Live Event")}&teamA=${encodeURIComponent("Team A")}&teamB=${encodeURIComponent("Team B")}`;
        }
        
        const title = encodeURIComponent(trimToString(event && event.eventName));
        let url = `${MATCH_CARD_API}?title=${title}&teamA=${encodeURIComponent(trimToString(event && event.teamAName) || "Team A")}&teamB=${encodeURIComponent(trimToString(event && event.teamBName) || "Team B")}`;
        if (trimToString(event && event.teamAFlag)) url += "&teamAImg=" + encodeURIComponent(event.teamAFlag);
        if (trimToString(event && event.teamBFlag)) url += "&teamBImg=" + encodeURIComponent(event.teamBFlag);
        if (trimToString(event && event.eventLogo)) url += "&eventLogo=" + encodeURIComponent(event.eventLogo);
        if (trimToString(event && event.date) && trimToString(event && event.time)) {
            url += "&time=" + encodeURIComponent(`${event.date} ${event.time} UTC`);
        }
        return url;
    }

    function parseEventEntry(rawEntry) {
        if (!rawEntry || typeof rawEntry !== "object") return null;
        const eventObject = rawEntry.event && typeof rawEntry.event === "string"
            ? safeJsonParse(rawEntry.event)
            : rawEntry;
        if (!eventObject || eventObject.visible === false) return null;

        return {
            category: normalizeCategoryName(eventObject.category),
            eventName: trimToString(eventObject.eventName),
            eventLogo: trimToString(eventObject.eventLogo),
            teamAName: trimToString(eventObject.teamAName),
            teamBName: trimToString(eventObject.teamBName),
            teamAFlag: trimToString(eventObject.teamAFlag),
            teamBFlag: trimToString(eventObject.teamBFlag),
            linksPath: trimToString(eventObject.links),
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
        if (!Array.isArray(events)) {
            return [];
        }
        
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

            const leftPriority = Number.isFinite(left.priority) ? left.priority : 9999;
            const rightPriority = Number.isFinite(right.priority) ? right.priority : 9999;
            if (leftPriority !== rightPriority) return leftPriority - rightPriority;

            const leftStart = parsePlayzUtcDateTime(left.date, left.time);
            const rightStart = parsePlayzUtcDateTime(right.date, right.time);
            if (Number.isFinite(leftStart) && Number.isFinite(rightStart) && leftStart !== rightStart) {
                return leftStart - rightStart;
            }

            return buildEventTitle(left).localeCompare(buildEventTitle(right));
        });
    }

    async function fetchPlayzEvents() {
        try {
            const data = await fetchPlayzJson("events.txt");
            if (!Array.isArray(data)) return [];
            return sortEvents(data.map(parseEventEntry).filter(Boolean));
        } catch (error) {
            console.error(`Failed to fetch PlayZTV events: ${error && error.message ? error.message : String(error)}`);
            return [];
        }
    }

    async function fetchPlayzCategories() {
        try {
            const data = await fetchPlayzJson("event_cats.txt");
            return data && typeof data === "object" && !Array.isArray(data) ? data : {};
        } catch (error) {
            console.error(`Failed to fetch PlayZTV categories: ${error && error.message ? error.message : String(error)}`);
            return {};
        }
    }

    function buildHomeItem(event) {
        if (!event || typeof event !== "object") {
            throw new Error("Invalid event data for buildHomeItem");
        }
        
        const displayTitle = buildEventTitle(event);
        const poster = buildEventPoster(event);
        return new MultimediaItem({
            title: `${buildEventStatusPrefix(event)} ${displayTitle}`,
            description: trimToString(event.eventName) || "Live Event",
            posterUrl: poster,
            type: "livestream",
            url: JSON.stringify({
                title: displayTitle,
                poster,
                category: event.category,
                eventName: event.eventName,
                linksPath: event.linksPath,
                date: event.date,
                time: event.time,
                endDate: event.endDate,
                endTime: event.endTime,
                teamAName: event.teamAName,
                teamBName: event.teamBName,
                eventLogo: event.eventLogo
            })
        });
    }

    function getStreamHost(url) {
        if (!url || typeof url !== "string") {
            return "";
        }
        
        try {
            return new URL(String(url)).hostname.toLowerCase();
        } catch (_) {
            return "";
        }
    }

    function matchesHost(host, entries) {
        if (!host || typeof host !== "string" || !Array.isArray(entries)) {
            return false;
        }
        
        const normalized = trimToString(host).toLowerCase();
        return entries.some((entry) => normalized === entry || normalized.endsWith(`.${entry}`));
    }

    function shouldExpandHlsVariants(url) {
        const value = trimToString(url).toLowerCase();
        if (!value || /\.mpd(?:$|[?#])/i.test(value)) return false;
        return /\.m3u8(?:$|[?#])/i.test(value) || value.includes("/hls/") || value.includes("m3u8");
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

    function parseVariantQuality(attributes, isMpd = false) {
        if (!attributes || typeof attributes !== "object") {
            return 0;
        }
        
        let resolution = trimToString(attributes && attributes.RESOLUTION);
        if (!resolution && isMpd) {
            const width = attributes && attributes.width;
            const height = attributes && attributes.height;
            if (width && height) {
                resolution = `${width}x${height}`;
            }
        }
        
        const resolutionMatch = /(\d+)\s*x\s*(\d+)/i.exec(resolution);
        if (resolutionMatch) return parseInt(resolutionMatch[2], 10) || 0;

        let bandwidth = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (!bandwidth && isMpd) {
            bandwidth = attributes && attributes.bandwidth;
        }
        
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

    function buildVariantSource(baseSource, attributes, fallbackIndex, isMpd = false) {
        if (!baseSource || typeof baseSource !== "string") {
            baseSource = "";
        }
        
        const quality = parseVariantQuality(attributes, isMpd);
        if (quality > 0) {
            return {
                quality,
                source: `${baseSource} ${quality}p`
            };
        }

        const bandwidth = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (!bandwidth && isMpd) {
            const mpdBandwidth = attributes && attributes.bandwidth;
            if (mpdBandwidth) {
                return {
                    quality: 0,
                    source: `${baseSource} ${Math.max(1, Math.round(mpdBandwidth / 1000))}kbps`
                };
            }
        }
        
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
        const info = {
            variants: [],
            version: "",
            independentSegments: false,
            mediaGroups: {
                AUDIO: {},
                SUBTITLES: {},
                "CLOSED-CAPTIONS": {}
            }
        };
        const lines = String(manifestText || "").split(/\r?\n/);
        let pendingAttributes = null;

        lines.forEach((rawLine) => {
            const line = trimToString(rawLine);
            if (!line) return;

            if (line.startsWith("#EXT-X-VERSION:")) {
                info.version = trimToString(line.slice("#EXT-X-VERSION:".length));
                return;
            }

            if (line === "#EXT-X-INDEPENDENT-SEGMENTS") {
                info.independentSegments = true;
                return;
            }

            if (line.startsWith("#EXT-X-MEDIA:")) {
                const attributes = parseHlsAttributes(line.slice("#EXT-X-MEDIA:".length));
                const mediaType = trimToString(attributes.TYPE).toUpperCase();
                const groupId = trimToString(attributes["GROUP-ID"]);
                if (!mediaType || !groupId) return;
                if (attributes.URI) {
                    attributes.URI = resolveVariantUrl(manifestUrl, attributes.URI);
                }
                if (!info.mediaGroups[mediaType]) info.mediaGroups[mediaType] = {};
                if (!info.mediaGroups[mediaType][groupId]) info.mediaGroups[mediaType][groupId] = [];
                info.mediaGroups[mediaType][groupId].push(attributes);
                return;
            }

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

function buildVariantPlaybackUrl(variant) {
        // Always return the direct variant URL.
        // Inline data: manifests (previously used to embed audio groups) crash
        // WinRT's AdaptiveMediaSource which only accepts http/https URIs, even
        // though hasExtension() matches .m3u8 inside the encoded data: body.
        // Audio group selection is handled by the player from the master manifest.
        if (!variant || typeof variant !== "object") {
            return "";
}

        return trimToString(variant.url);
    }
    function extractClearKeyPairFromJson(value) {
        const data = safeJsonParse(value);
        if (!data || typeof data !== "object") return null;
        
        const entries = data && Array.isArray(data.keys) ? data.keys : [];
        const firstEntry = entries.find((entry) => entry && (entry.k || entry.key) && (entry.kid || entry.keyid));
        if (!firstEntry) return null;

        const drmKey = normalizeDrmToken(firstEntry.k || firstEntry.key);
        const drmKid = normalizeDrmToken(firstEntry.kid || firstEntry.keyid);
        if (!drmKey || !drmKid) return null;
        return { drmKey, drmKid };
    }

    function extractClearKeyPairFromValue(value) {
        const text = trimToString(value);
        if (!text || /^https?:\/\//i.test(text)) return null;
        if (text.startsWith("{")) {
            return extractClearKeyPairFromJson(text);
        }

        const delimiter = text.includes(":") ? ":" : (text.includes(",") ? "," : "");
        if (!delimiter) return null;

        const parts = text.split(delimiter, 2);
        const drmKid = normalizeDrmToken(parts[0]);
        const drmKey = normalizeDrmToken(parts[1]);
        if (!drmKey || !drmKid) return null;
        return { drmKey, drmKid };
    }

    function hexToBase64Url(hex) {
        const normalized = trimToString(hex).replace(/-/g, "");
        if (!normalized || !/^[0-9a-f]+$/i.test(normalized) || normalized.length % 2 !== 0) return "";
        const bytes = [];
        for (let index = 0; index < normalized.length; index += 2) {
            bytes.push(parseInt(normalized.slice(index, index + 2), 16));
        }
        const binary = String.fromCharCode.apply(null, bytes);
        if (typeof btoa === "function") {
            return btoa(binary).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/g, "");
        }
        return "";
    }

    async function extractDefaultKidFromMpd(streamUrl, headers) {
        if (!streamUrl || typeof streamUrl !== "string") return "";
        if (!/\.mpd(?:$|[?#])/i.test(trimToString(streamUrl))) return "";
        try {
            const response = await fetchText(streamUrl, headers || {});
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return "";
            const body = extractResponseBody(response);
            const match = /cenc:default_KID=["']([0-9a-fA-F-]{32,36})["']/i.exec(body);
            if (!match) return "";
            return hexToBase64Url(match[1]);
        } catch (_) {
            return "";
        }
    }

    async function fetchClearKeyFromLicenseServer(url, kid, headers) {
        const licenseUrl = trimToString(url);
        const drmKid = trimToString(kid);
        if (!licenseUrl || !drmKid) return "";

        try {
            const response = await postJson(licenseUrl, {
                kids: [drmKid],
                type: "temporary"
            }, mergeHeaders(headers || {}, {
                "Content-Type": "application/json;charset=UTF-8"
            }));

            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return "";
            const data = safeJsonParse(extractResponseBody(response));
            const keys = data && Array.isArray(data.keys) ? data.keys : [];
            const firstKey = keys.find((entry) => entry && (entry.k || entry.key));
            return normalizeDrmToken(firstKey && (firstKey.k || firstKey.key));
        } catch (_) {
            return "";
        }
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
            const parsedApi = splitUrlAndHeaders(rawValue);
            Object.assign(streamHeaders, mergeHeaders(streamHeaders, parsedApi.headers || {}));
            drmScheme = drmScheme || normalizeDrmScheme(parsedApi.drmScheme);
            licenseUrl = licenseUrl || trimToString(parsedApi.licenseUrl || (/^https?:\/\//i.test(parsedApi.url) ? parsedApi.url : ""));
            if (!drmKey || !drmKid) {
                const pair = extractClearKeyPairFromValue(parsedApi.url);
                if (pair) {
                    drmKey = drmKey || pair.drmKey;
                    drmKid = drmKid || pair.drmKid;
                }
            }
        }

        if ((!drmKey || !drmKid) && drmScheme === "clearkey" && licenseUrl && /\.mpd(?:$|[?#])/i.test(trimToString(streamUrl))) {
            try {
                const mpdKid = await extractDefaultKidFromMpd(streamUrl, streamHeaders);
                if (mpdKid) {
                    const fetchedKey = await fetchClearKeyFromLicenseServer(licenseUrl, mpdKid, streamHeaders);
                    if (fetchedKey) {
                        drmKid = mpdKid;
                        drmKey = fetchedKey;
                    }
                }
            } catch (error) {
                console.error(`Failed to resolve DRM from stream URL ${streamUrl}: ${error && error.message ? error.message : String(error)}`);
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

    function createStreamResult(source, parsed, drmInfo, quality) {
        if (!parsed || typeof parsed !== "object") {
            throw new Error("Invalid parsed data for createStreamResult");
        }
        
        const streamHeaders = mergeHeaders({}, drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {}));
        const stream = new StreamResult({
            source,
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
        if (!parsed || typeof parsed !== "object") {
            return 0;
        }
        
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
        if (!parsed || typeof parsed !== "object") {
            throw new Error("Invalid parsed data for createRankedStream");
        }
        
        return {
            score: scoreStream(source, {
                url: parsed.url,
                headers: drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {})
            }, trimToString(drmInfo && (drmInfo.drmKey || drmInfo.licenseUrl || drmInfo.drmType)), quality, isVariant),
            order,
            stream: createStreamResult(source, parsed, drmInfo, quality)
        };
    }

    async function expandHlsStreams(sourceLabel, parsed, drmInfo) {
        if (!parsed || !parsed.url || !shouldExpandHlsVariants(parsed.url)) return [];

        try {
            const response = await fetchText(parsed.url, drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {}));
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return [];

            const manifestText = trimToString(extractResponseBody(response));
            if (!manifestText.startsWith("#EXTM3U") || manifestText.indexOf("#EXT-X-STREAM-INF") === -1) return [];

            const manifestInfo = parseHlsMasterPlaylist(manifestText, parsed.url);
            const variants = manifestInfo && Array.isArray(manifestInfo.variants) ? manifestInfo.variants : [];
            const seen = {};
            const streams = [];

            variants.forEach((variant, index) => {
                const playbackUrl = buildVariantPlaybackUrl(variant);
                if (!variant || !variant.url || !playbackUrl || seen[playbackUrl]) return;
                seen[playbackUrl] = true;
                const variantInfo = buildVariantSource(sourceLabel, variant.attributes || {}, index, false);
                streams.push(createStreamResult(variantInfo.source, {
                    url: playbackUrl,
                    headers: drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {})
                }, drmInfo, variantInfo.quality));
            });

            return streams;
        } catch (error) {
            console.error(`Failed to expand HLS streams from ${parsed.url}: ${error && error.message ? error.message : String(error)}`);
            return [];
        }
    }

    async function expandMpdStreams(sourceLabel, parsed, drmInfo) {
        if (!parsed || !parsed.url || !/\.mpd(?:$|[?#])/i.test(trimToString(parsed.url))) return [];

        try {
            const response = await fetchText(parsed.url, drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {}));
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return [];

            const manifestText = trimToString(extractResponseBody(response));
            if (!manifestText.startsWith("<?xml") || !manifestText.includes("<MPD")) return [];

            const manifestInfo = parseMpdMasterPlaylist(manifestText, parsed.url);
            const variants = manifestInfo && Array.isArray(manifestInfo.variants) ? manifestInfo.variants : [];
            const seen = {};
            const streams = [];

            variants.forEach((variant, index) => {
                const playbackUrl = buildVariantPlaybackUrl(variant);
                if (!variant || !variant.url || !playbackUrl || seen[playbackUrl]) return;
                seen[playbackUrl] = true;
                const variantInfo = buildVariantSource(sourceLabel, variant.attributes || {}, index, true);
                streams.push(createStreamResult(variantInfo.source, {
                    url: playbackUrl,
                    headers: drmInfo && drmInfo.headers ? drmInfo.headers : (parsed.headers || {})
                }, drmInfo, variantInfo.quality));
            });

            return streams;
        } catch (error) {
            console.error(`Failed to expand MPD streams from ${parsed.url}: ${error && error.message ? error.message : String(error)}`);
            return [];
        }
    }

    async function buildResolvedStream(entry) {
        if (!entry || typeof entry !== "object") {
            return null;
        }
        
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

    function parseMpdMasterPlaylist(manifestText, manifestUrl) {
        const info = {
            variants: [],
            version: "",
            independentSegments: false,
            mediaGroups: {
                AUDIO: {},
                SUBTITLES: {},
                "CLOSED-CAPTIONS": {}
            }
        };
        const lines = String(manifestText || "").split(/\r?\n/);
        let currentAdaptationSet = null;
        let currentRepresentation = null;

        lines.forEach((rawLine) => {
            const line = trimToString(rawLine);
            if (!line) return;

            if (line.includes("<AdaptationSet")) {
                const adaptationSetMatch = line.match(/id="?(\d+)?"?/);
                currentAdaptationSet = {
                    id: adaptationSetMatch ? adaptationSetMatch[1] : null,
                    mimeType: null,
                    codecs: null,
                    bandwidth: null,
                    width: null,
                    height: null,
                    frameRate: null,
                    audioSamplingRate: null,
                    startWithSAP: null
                };

                const mimeTypeMatch = line.match(/mimeType="([^"]*)"/);
                if (mimeTypeMatch) currentAdaptationSet.mimeType = mimeTypeMatch[1];

                const codecsMatch = line.match(/codecs="([^"]*)"/);
                if (codecsMatch) currentAdaptationSet.codecs = codecsMatch[1];

                const bandwidthMatch = line.match(/bandwidth="?(\d+)?"?/);
                if (bandwidthMatch) currentAdaptationSet.bandwidth = bandwidthMatch[1] ? parseInt(bandwidthMatch[1]) : null;

                const widthMatch = line.match(/width="?(\d+)?"?/);
                if (widthMatch) currentAdaptationSet.width = widthMatch[1] ? parseInt(widthMatch[1]) : null;

                const heightMatch = line.match(/height="?(\d+)?"?/);
                if (heightMatch) currentAdaptationSet.height = heightMatch[1] ? parseInt(heightMatch[1]) : null;

                const frameRateMatch = line.match(/frameRate="([^"]*)"/);
                if (frameRateMatch) currentAdaptationSet.frameRate = frameRateMatch[1];

                const audioSamplingRateMatch = line.match(/audioSamplingRate="([^"]*)"/);
                if (audioSamplingRateMatch) currentAdaptationSet.audioSamplingRate = audioSamplingRateMatch[1];

                const startWithSAPMatch = line.match(/startWithSAP="?(\d+)?"?/);
                if (startWithSAPMatch) currentAdaptationSet.startWithSAP = startWithSAPMatch[1] ? parseInt(startWithSAPMatch[1]) : null;
            } else if (line.includes("<Representation")) {
                currentRepresentation = {
                    id: null,
                    bandwidth: null,
                    width: null,
                    height: null,
                    frameRate: null,
                    audioSamplingRate: null,
                    codecs: null,
                    mimeType: null
                };

                const idMatch = line.match(/id="?(\d+)?"?/);
                if (idMatch) currentRepresentation.id = idMatch[1] ? parseInt(idMatch[1]) : null;

                const bandwidthMatch = line.match(/bandwidth="?(\d+)?"?/);
                if (bandwidthMatch) currentRepresentation.bandwidth = bandwidthMatch[1] ? parseInt(bandwidthMatch[1]) : null;

                const widthMatch = line.match(/width="?(\d+)?"?/);
                if (widthMatch) currentRepresentation.width = widthMatch[1] ? parseInt(widthMatch[1]) : null;

                const heightMatch = line.match(/height="?(\d+)?"?/);
                if (heightMatch) currentRepresentation.height = heightMatch[1] ? parseInt(heightMatch[1]) : null;

                const frameRateMatch = line.match(/frameRate="([^"]*)"/);
                if (frameRateMatch) currentRepresentation.frameRate = frameRateMatch[1];

                const audioSamplingRateMatch = line.match(/audioSamplingRate="([^"]*)"/);
                if (audioSamplingRateMatch) currentRepresentation.audioSamplingRate = audioSamplingRateMatch[1];

                const codecsMatch = line.match(/codecs="([^"]*)"/);
                if (codecsMatch) currentRepresentation.codecs = codecsMatch[1];

                const mimeTypeMatch = line.match(/mimeType="([^"]*)"/);
                if (mimeTypeMatch) currentRepresentation.mimeType = mimeTypeMatch[1];

                if (currentAdaptationSet) {
                    currentAdaptationSet.representations = currentAdaptationSet.representations || [];
                    currentAdaptationSet.representations.push(currentRepresentation);
                }
            } else if (line.includes("</Representation>")) {
                currentRepresentation = null;
            } else if (line.includes("</AdaptationSet>")) {
                if (currentAdaptationSet && currentAdaptationSet.representations && currentAdaptationSet.representations.length > 0) {
                    const baseUrl = manifestUrl;
                    currentAdaptationSet.representations.forEach((representation, repIndex) => {
                        const quality = parseMpdRepresentationQuality(representation);
                        const source = buildMpdVariantSource("Stream", representation, currentAdaptationSet, repIndex);
                        const playbackUrl = buildMpdVariantPlaybackUrl(representation, baseUrl);

                        if (playbackUrl) {
                            info.variants.push({
                                url: playbackUrl,
                                attributes: {
                                    BANDWIDTH: representation.bandwidth,
                                    RESOLUTION: representation.width && representation.height ? `${representation.width}x${representation.height}` : null,
                                    FRAME_RATE: representation.frameRate,
                                    AUDIO_SAMPLING_RATE: representation.audioSamplingRate,
                                    CODECS: representation.codecs,
                                    MIME_TYPE: representation.mimeType
                                }
                            });
                        }
                    });
                }
                currentAdaptationSet = null;
            }
        });

        return info;
    }

    function buildMpdVariantSource(baseSource, representation, adaptationSet, index) {
        const quality = parseMpdRepresentationQuality(representation);
        if (quality > 0) {
            return {
                quality,
                source: `${baseSource} ${quality}p`
            };
        }

        const bandwidth = representation.bandwidth;
        if (bandwidth > 0) {
            return {
                quality: 0,
                source: `${baseSource} ${Math.max(1, Math.round(bandwidth / 1000))}kbps`
            };
        }

        return {
            quality: 0,
            source: `${baseSource} Variant ${index + 1}`
        };
    }

    function buildMpdVariantPlaybackUrl(representation, baseUrl) {
        if (!representation || typeof representation !== "object") {
            return "";
        }

        const segmentBase = representation.id ? `RepresentationID=${representation.id}` : "";
        const baseURL = representation.baseURL || baseUrl;
        const quality = representation.bandwidth ? `quality=${representation.bandwidth}` : "";

        let playbackUrl = baseURL;
        if (segmentBase) playbackUrl += `?${segmentBase}`;
        if (quality) playbackUrl += (playbackUrl.includes("?") ? "&" : "?") + quality;

        return playbackUrl;
    }

    function parseMpdRepresentationQuality(representation) {
        if (!representation || typeof representation !== "object") {
            return 0;
        }

        const resolution = representation.height;
        if (resolution && resolution > 0) {
            if (resolution >= 4320) return 8160;
            if (resolution >= 2160) return 4320;
            if (resolution >= 1080) return 1080;
            if (resolution >= 720) return 720;
            if (resolution >= 480) return 480;
            if (resolution >= 360) return 360;
            if (resolution >= 240) return 240;
            if (resolution >= 144) return 144;
        }

        const bandwidth = representation.bandwidth;
        if (bandwidth && bandwidth > 0) {
            if (bandwidth >= 20000000) return 8160;
            if (bandwidth >= 10000000) return 4320;
            if (bandwidth >= 5000000) return 1080;
            if (bandwidth >= 3000000) return 720;
            if (bandwidth >= 1500000) return 480;
            if (bandwidth >= 800000) return 360;
            if (bandwidth >= 400000) return 240;
            if (bandwidth >= 200000) return 144;
        }

        return 0;
    }

    async function processStreamEntry(entry, index) {
        if (!entry || typeof entry !== "object") {
            console.error(`Invalid stream entry at index ${index}`);
            return [];
        }
        
        const resolved = await buildResolvedStream(entry);
        if (!resolved || !resolved.url) return [];

        const rawApi = trimToString(entry && entry.api);
        const sourceLabel = trimToString(entry && entry.name) || `Server ${index + 1}`;
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
        } catch (error) {
            console.error(`Failed to expand HLS streams for entry at index ${index}: ${error && error.message ? error.message : String(error)}`);
        }

        try {
            const variants = await expandMpdStreams(sourceLabel, resolved, drmInfo);
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
        } catch (error) {
            console.error(`Failed to expand MPD streams for entry at index ${index}: ${error && error.message ? error.message : String(error)}`);
        }

        return rankedStreams;
    }

    async function getHome(cb) {
        if (typeof cb !== "function") {
            throw new Error("Callback function is required");
        }
        
        try {
            const [events, categoryMeta] = await Promise.all([
                fetchPlayzEvents(),
                fetchPlayzCategories()
            ]);

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

            const orderedLabels = [];
            Object.keys(categoryMeta || {}).forEach((name) => {
                const label = getCategoryLabel(name);
                if (!orderedLabels.includes(label)) orderedLabels.push(label);
            });

            const categories = {};
            events.forEach((event) => {
                if (!event || typeof event !== "object") return;
                
                const label = getCategoryLabel(event.category);
                if (!orderedLabels.includes(label)) orderedLabels.push(label);
                if (!categories[label]) categories[label] = [];
                categories[label].push(buildHomeItem(event));
            });

            const orderedCategories = {};
            orderedLabels.forEach((label) => {
                if (categories[label] && categories[label].length) {
                    orderedCategories[label] = categories[label];
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
        if (typeof cb !== "function") {
            throw new Error("Callback function is required");
        }
        
        try {
            const events = await fetchPlayzEvents();
            if (!events || !Array.isArray(events)) {
                return cb({ success: true, data: [] });
            }
            
            if (!events.length) return cb({ success: true, data: [] });

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
            const data = JSON.parse(urlStr);
            if (!data || typeof data !== "object") {
                throw new Error("Invalid event data format");
            }
            
            const plotParts = [
                trimToString(data.eventName) ? `Event: ${data.eventName}` : "",
                trimToString(data.date) && trimToString(data.time) ? `Time: ${data.date} ${data.time} UTC` : ""
            ].filter(Boolean);

            Analytics.logEvent('playeztvliveevents_load', {});
            cb({
                success: true,
                data: new MultimediaItem({
                    title: data.title,
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
            cb({ success: false, errorCode: "PARSE_ERROR", message: "Invalid event data" });
        }
    }

    async function loadStreams(urlStr, cb) {
        if (!urlStr || typeof urlStr !== "string") {
            return cb({ success: false, errorCode: "INVALID_INPUT", message: "Invalid URL string" });
        }
        
        try {
            const data = JSON.parse(urlStr);
            if (!data || typeof data !== "object") {
                throw new Error("Invalid event data format");
            }
            
            const linksPath = trimToString(data && data.linksPath);
            if (!linksPath) {
                return cb({ success: false, errorCode: "PARSE_ERROR", message: "Missing PlayZTV links path" });
            }

            const response = await fetchPlayzJson(linksPath);
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
