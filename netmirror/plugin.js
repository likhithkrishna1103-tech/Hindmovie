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

    "use strict";

    var MAIN_URL = "https://net52.cc";
    var IMG_BASE = "https://imgcdn.kim";
    var COOKIE_TTL_MS = 54000000;
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0";
    var NEWTV_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0";
    var HOME_TITLE_CONCURRENCY = 48;
    var HOME_TITLE_HYDRATE_LIMIT = 0;
    var HOME_CACHE_TTL_MS = 600000;
    var LOAD_CACHE_TTL_MS = 300000;
    var EPISODE_PAGE_CONCURRENCY = 24;

    // Desktop player UA observed in real playlist.php traffic (Firefox/Win).
    var PLAYER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:152.0) Gecko/20100101 Firefox/152.0";

    var PROVIDERS = {
        netflix: {
            id: "netflix",
            name: "Netflix",
            ott: "nf",
            playerOtt: "nf",
            prefix: "",
            search: true,
            poster: function(id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            background: function(id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            initialEpisodePoster: function(id) { return IMG_BASE + "/poster/v/150/" + id + ".jpg"; },
            episodePoster: function(id) { return IMG_BASE + "/epimg/150/" + id + ".jpg"; },
            suggestPoster: function(id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; }
        },
        prime: {
            id: "prime",
            name: "Prime Video",
            ott: "pv",
            playerOtt: "pv",
            prefix: "/pv",
            search: true,
            poster: function(id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            background: function(id) { return IMG_BASE + "/pv/h/" + id + ".jpg"; },
            initialEpisodePoster: function(id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            episodePoster: function(id) { return IMG_BASE + "/pvepimg/" + id + ".jpg"; },
            suggestPoster: function(id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; }
        },
        hotstar: {
            id: "hotstar",
            name: "Hotstar",
            ott: "hs",
            playerOtt: "hs",
            prefix: "/hs",
            search: true,
            poster: function(id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; },
            background: function(id) { return IMG_BASE + "/hs/h/" + id + ".jpg"; },
            initialEpisodePoster: function(id) { return IMG_BASE + "/hsepimg/150/" + id + ".jpg"; },
            episodePoster: function(id) { return IMG_BASE + "/hsepimg/" + id + ".jpg"; },
            suggestPoster: function(id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; }
        },
        disney: null,
        marvel: null,
        starwars: null,
        pixar: null
    };

    function studioConfig(id, name, studio) {
        var base = Object.assign({}, PROVIDERS.hotstar);
        base.id = id;
        base.name = name;
        base.ott = "dp";
        base.playerOtt = "hs";
        base.prefix = "/hs";
        base.search = false;
        base.studio = studio;
        return base;
    }

    PROVIDERS.disney = studioConfig("disney", "Disney", "disney");
    PROVIDERS.marvel = studioConfig("marvel", "Marvel", "marvel");
    PROVIDERS.starwars = studioConfig("starwars", "Star Wars", "starwars");
    PROVIDERS.pixar = studioConfig("pixar", "Pixar", "pixar");

    var PAGE_HEADERS = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
        "Accept-Language": "en-IN,en-US;q=0.9,en;q=0.8",
        "Cache-Control": "max-age=0",
        "Connection": "keep-alive",
        "sec-ch-ua": "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\"",
        "sec-ch-ua-mobile": "?0",
        "sec-ch-ua-platform": "\"Android\"",
        "Sec-Fetch-Dest": "document",
        "Sec-Fetch-Mode": "navigate",
        "Sec-Fetch-Site": "same-origin",
        "Sec-Fetch-User": "?1",
        "Upgrade-Insecure-Requests": "1",
        "User-Agent": USER_AGENT,
        "X-Requested-With": "XMLHttpRequest"
    };

    var NEWTV_BASE_HEADERS = {
        "Cache-Control": "no-cache, no-store, must-revalidate",
        "Pragma": "no-cache",
        "Expires": "0",
        "X-Requested-With": "NetmirrorNewTV v1.0",
        "User-Agent": NEWTV_USER_AGENT,
        "Accept": "application/json, text/plain, */*"
    };

    var NEWTV_DOMAINS = [
        "aHR0cHM6Ly9tb2JpbGVkZXRlY3RzLmNvbQ==",
        "aHR0cHM6Ly9tb2JpbGVkZXRlY3QuYXBw",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmFydA==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNj",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNsaWNr",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lmluaw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmxpdmU=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnBybw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNob3A=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNpdGU=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNwYWNl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnN0b3Jl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnZpcA==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lndpa2k=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lnh5eg==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5hcnQ=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5jYw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbmZv",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbms=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5saXZl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5wcm8=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5zdG9yZQ==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy50b3A=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy54eXo="
    ];

    var cookieCache = { value: "", time: 0 };
    // Captured hash cookie (name + value). The working extension captures whatever
    // t_hash* cookie name verify2.php issues (e.g. t_hash_p / t_hash) — we do NOT
    // hard-code it. Replayed verbatim on every playlist call.
    var bypassCookie = { name: "", value: "" };
    var lastHomeDiag = null; // last home-page diagnostic (title/len/hits/head)
    var resolvedApiUrl = "";
    var homeCache = {};
    var loadCache = {};

    // --- Persistent premium token storage (mirrors NetflixMirrorStorage.INSTANCE) ---
    // The working CNCVerse .cs3 stores the bypass t_hash_t in NetflixMirrorStorage
    // (Android SharedPreferences). We persist it via the host storage bridge so the
    // token survives the 1-day expiry window and is reused across sessions.
    var STORAGE_KEY_TOKENS = "cncverse_tokens_v1";

    async function storageGet(key) {
        key = String(key || "");
        try {
            if (typeof get_storage === "function") {
                var stored = await get_storage({ key: key });
                if (stored != null && typeof stored !== "undefined") {
                    var v = typeof stored === "object" && typeof stored.value !== "undefined" ? stored.value : stored;
                    if (v != null && v !== "") return String(v);
                }
            }
        } catch (_) {}
        try {
            if (typeof localStorage !== "undefined" && localStorage && typeof localStorage.getItem === "function") {
                var lsv = localStorage.getItem(key);
                if (lsv != null && lsv !== "") return lsv;
            }
        } catch (_) {}
        return null;
    }

    async function storageSet(key, value) {
        key = String(key || "");
        value = String(value == null ? "" : value);
        try {
            if (typeof set_storage === "function") { await set_storage({ key: key, value: value }); return true; }
        } catch (_) {}
        try {
            if (typeof localStorage !== "undefined" && localStorage && typeof localStorage.setItem === "function") {
                localStorage.setItem(key, value); return true;
            }
        } catch (_) {}
        return false;
    }

    // Read/write the whole token map (provider -> {value,time}).
    async function loadTokenStore() {
        try {
            var raw = await storageGet(STORAGE_KEY_TOKENS);
            if (raw) return JSON.parse(raw) || {};
        } catch (_) {}
        return {};
    }
    async function saveTokenStore(store) {
        try { await storageSet(STORAGE_KEY_TOKENS, JSON.stringify(store)); } catch (_) {}
    }

    // Headers confirmed in the working CNCVerse .cs3 (UtilsKt.bypass + loadLinks).
    var BYPASS_USER_AGENT = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
    var BYPASS_XREQ = "app.netmirror.netmirrornew";
    // The app's WebView performs the ad-click; headless we loop verify2.php until
    // the server reports "All Done" and issues the t_hash_t cookie.
    var BYPASS_MAX_TRIES = 8;
    var BYPASS_RETRY_DELAY_MS = 10000;
    var LANGUAGE_NAMES = {
        ar: "Arabic", ara: "Arabic",
        bn: "Bengali", ben: "Bengali",
        cs: "Czech", ces: "Czech", cze: "Czech",
        da: "Danish", dan: "Danish",
        de: "German", deu: "German", ger: "German",
        el: "Greek", ell: "Greek", gre: "Greek",
        en: "English", eng: "English",
        es: "Spanish", spa: "Spanish",
        "es-es": "European Spanish",
        fi: "Finnish", fin: "Finnish",
        fr: "French", fra: "French", fre: "French",
        gu: "Gujarati", guj: "Gujarati",
        he: "Hebrew", heb: "Hebrew",
        hi: "Hindi", hin: "Hindi",
        hr: "Croatian", hrv: "Croatian",
        hu: "Hungarian", hun: "Hungarian",
        id: "Indonesian", ind: "Indonesian",
        it: "Italian", ita: "Italian",
        ja: "Japanese", jpn: "Japanese",
        kn: "Kannada", kan: "Kannada",
        ko: "Korean", kor: "Korean",
        ml: "Malayalam", mal: "Malayalam",
        mr: "Marathi", mar: "Marathi",
        ms: "Malay", msa: "Malay", may: "Malay",
        nb: "Norwegian", nob: "Norwegian", no: "Norwegian", nor: "Norwegian",
        nl: "Dutch", nld: "Dutch", dut: "Dutch",
        pa: "Punjabi", pan: "Punjabi",
        pl: "Polish", pol: "Polish",
        pt: "Portuguese", por: "Portuguese",
        "pt-br": "Brazilian Portuguese",
        ro: "Romanian", ron: "Romanian", rum: "Romanian",
        ru: "Russian", rus: "Russian",
        sv: "Swedish", swe: "Swedish",
        ta: "Tamil", tam: "Tamil",
        te: "Telugu", tel: "Telugu",
        th: "Thai", tha: "Thai",
        tr: "Turkish", tur: "Turkish",
        ur: "Urdu", urd: "Urdu",
        vi: "Vietnamese", vie: "Vietnamese",
        "zh-hans": "Chinese (Simplified)",
        "zh-hant": "Chinese (Traditional)",
        zh: "Chinese", zho: "Chinese", chi: "Chinese"
    };

    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").trim();
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function encodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof btoa === "function") return btoa(input);
        } catch (_) { }
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "utf8").toString("base64");
        } catch (_) { }
        return "";
    }

    function decodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof atob === "function") return atob(input);
        } catch (_) { }
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "base64").toString("utf8");
        } catch (_) { }
        return "";
    }

    function randomUuid() {
        if (typeof crypto !== "undefined" && crypto.randomUUID) return crypto.randomUUID();
        return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function(c) {
            var r = Math.random() * 16 | 0;
            var v = c === "x" ? r : (r & 3 | 8);
            return v.toString(16);
        });
    }

    function selectedProvider() {
        var id = trim(manifest && manifest.providerId).toLowerCase() || "netflix";
        return PROVIDERS[id] || PROVIDERS.netflix;
    }

    function cookieHeader(cookies) {
        var rows = [];
        Object.keys(cookies || {}).forEach(function(key) {
            var value = cookies[key];
            if (typeof value !== "undefined" && value !== null && value !== "") rows.push(key + "=" + value);
        });
        return rows.join("; ");
    }

    function withHeaders(base, extra) {
        var out = Object.assign({}, base || {});
        extra = extra || {};
        Object.keys(extra).forEach(function(key) {
            if (typeof extra[key] !== "undefined") out[key] = extra[key];
        });
        return out;
    }

    function pageCookies(config, token) {
        var cookies = {
            "ott": config.ott,
            "hd": "on"
        };
        if (token) cookies.t_hash_t = token;
        if (config.studio) cookies.studio = config.studio;
        return cookies;
    }

    function pageHeaders(config, token, referer) {
        return withHeaders(PAGE_HEADERS, {
            "Cookie": cookieHeader(pageCookies(config, token)),
            "Referer": referer || (MAIN_URL + "/home")
        });
    }

    function normalizeHeaders(headers) {
        var out = {};
        if (!headers) return out;
        if (typeof headers.forEach === "function") {
            headers.forEach(function(value, key) {
                out[String(key).toLowerCase()] = value;
            });
            return out;
        }
        Object.keys(headers).forEach(function(key) {
            out[String(key).toLowerCase()] = headers[key];
        });
        return out;
    }

    function normalizeResponse(res, url) {
        if (typeof res === "string") return { status: 200, body: res, headers: {}, url: url };
        return {
            status: res && typeof res.status !== "undefined" ? res.status : 200,
            body: String(res && (res.body || res.text || "") || ""),
            headers: normalizeHeaders(res && res.headers),
            url: res && (res.url || res.finalUrl) || url
        };
    }

    async function requestGet(url, headers) {
        if (typeof http_get === "function") return normalizeResponse(await http_get(url, headers || {}), url);
        var res = await fetch(url, { headers: headers || {} });
        var body = await res.text();
        var headersOut = {};
        if (res.headers && res.headers.forEach) {
            res.headers.forEach(function(value, key) { headersOut[key] = value; });
        }
        return { status: res.status, body: body, headers: headersOut, url: res.url || url };
    }

    async function httpParallelGet(requests, fallbackLimit) {
        var items = Array.isArray(requests) ? requests.filter(function(item) { return item && item.url; }) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var responses = await http_parallel(items.map(function(item) {
                    return {
                        method: "GET",
                        url: item.url,
                        headers: item.headers || {}
                    };
                }));
                return items.map(function(item, index) {
                    return normalizeResponse(responses && responses[index], item.url);
                });
            } catch (_) { }
        }
        return await mapConcurrent(items, fallbackLimit || HOME_TITLE_CONCURRENCY, function(item) {
            return requestGet(item.url, item.headers || {}).catch(function() {
                return { status: 599, body: "", headers: {}, url: item.url };
            });
        });
    }

    async function requestPostForm(url, body, headers) {
        var res;
        if (typeof fetch === "function") {
            try {
                var fetchRes = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body: body || "",
                    redirect: "manual"
                });
                var text = await fetchRes.text().catch(function() { return ""; });
                return {
                    status: fetchRes.status,
                    body: text,
                    headers: normalizeHeaders(fetchRes.headers),
                    url: fetchRes.url || url
                };
            } catch (_) { }
        }
        try {
            res = await http_post(url, headers || {}, body || "");
            if (res && (res.body || res.headers)) return normalizeResponse(res, url);
        } catch (_) { }
        res = await http_post(url, body || "", headers || {});
        return normalizeResponse(res, url);
    }

    async function requestPostFormCandidates(url, body, headers) {
        var out = [];
        if (typeof axios !== "undefined" && axios && typeof axios.post === "function") {
            try {
                var ax = await axios.post(url, body || "", {
                    headers: headers || {},
                    maxRedirects: 0,
                    validateStatus: function() { return true; },
                    responseType: "text"
                });
                out.push({
                    status: ax.status,
                    body: typeof ax.data === "string" ? ax.data : JSON.stringify(ax.data || ""),
                    headers: normalizeHeaders(ax.headers),
                    url: url
                });
            } catch (_) { }
        }
        if (typeof fetch === "function") {
            try {
                var fetchRes = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body: body || "",
                    redirect: "manual"
                });
                out.push({
                    status: fetchRes.status,
                    body: await fetchRes.text().catch(function() { return ""; }),
                    headers: normalizeHeaders(fetchRes.headers),
                    url: fetchRes.url || url
                });
            } catch (_) { }
        }
        if (typeof http_post === "function") {
            try {
                out.push(normalizeResponse(await http_post(url, headers || {}, body || ""), url));
            } catch (_) { }
            try {
                out.push(normalizeResponse(await http_post(url, body || "", headers || {}), url));
            } catch (_) { }
        }
        return out;
    }

    function responseHeader(headers, name) {
        var wanted = String(name || "").toLowerCase();
        headers = headers || {};
        if (headers[wanted]) return headers[wanted];
        var keys = Object.keys(headers);
        for (var i = 0; i < keys.length; i++) {
            if (String(keys[i]).toLowerCase() === wanted) return headers[keys[i]];
        }
        return "";
    }

    function extractCookie(headers, cookieName) {
        var raw = responseHeader(headers, "set-cookie");
        if (Array.isArray(raw)) raw = raw.join("\n");
        var text = String(raw || "");
        var re = new RegExp(cookieName + "=([^;\\n]+)", "i");
        var match = text.match(re);
        return match ? match[1] : "";
    }

    // Verified bypass flow (matches UtilsKt.bypass in the working CNCVerse .cs3):
    //   1. GET {MAIN_URL}/mobile/home?app=1  -> read body[data-addhash]
    //   2. GET https://userver.net52.cc/?jjoii=<addhash>&a=y&t=<unix>  (ad-impression beacon)
    //   3. POST {MAIN_URL}/mobile/verify2.php (verify=<addhash>) in a loop
    //      until the JSON body contains "statusup":"All Done"; the server then
    //      sets the t_hash* cookie (name varies: t_hash_p / t_hash / ...).
    //      We capture WHATEVER t_hash* name the server issues and replay it verbatim
    // Verified flow (proven end-to-end via curl against net52.cc, 2026-07-10):
    //   1. GET {MAIN_URL}/mobile/home?app=1  -> read addhash (guest token, embed/body)
    //   2. GET https://userver.net52.cc/?jjoii=<addhash>&a=y&t=<unix>  (ad beacon; 301->ad net)
    //   3. POST {MAIN_URL}/mobile/verify2.php (verify=<addhash>) in a LOOP.
    //      Server returns {"c":"y","statusup":"Waiting for your ads click."} for ~10-15s,
    //      THEN {"statusup":"All Done"} and SETS the t_hash_t cookie. The cookie arrives
    //      ONLY on the "All Done" response, so we must poll until All Done, not bail early.
    //      The cookie is name-agnostic (t_hash_t in the DEX; t_hash_p / t_hash on others).
    // PORTED 1:1 FROM THE WORKING CNCVerse .cs3 — com.horis.cncverse.UtilsKt.bypass
    // (decompiled). The real flow:
    //   0. If a stored cookie exists AND age < 54000000ms (15h) -> return it (no home fetch).
    //   1. GET {MAIN_URL}/mobile/home?app=1 with ONLY two headers:
    //        User-Agent: …/OS.Gatu v3.0   +   X-Requested-With: app.netmirror.netmirrornew
    //      then read body.attr("data-addhash").
    //   2. GET https://userver.net52.cc/?jjoii=<addhash>&a=y&t=<unix>  (ad beacon).
    //   3. delay(10000)  — the ad-view wait, BEFORE the first verify2 POST.
    //   4. POST {MAIN_URL}/mobile/verify2.php (verify=<addhash>) with
    //        User-Agent: …/OS.Gatu v3.0  +  X-Requested-With: XMLHttpRequest.
    //      Loop up to 8 times; if the response does NOT contain "statusup":"All Done",
    //      retry (with a delay between). When it DOES -> t_hash_t = response cookie
    //      "t_hash_t" -> saveCookie -> return. If loop exceeds 7 or cookie empty ->
    //      clearCookie + throw "Failed to verify cookie".
    // A valid home-page addhash is the 4-segment form: hex::hex::unixtime::(ni|p).
    // (The bare 32-40 hex token is only what verify2.php mints back as a COOKIE and is
    //  captured separately by extractCookie — never scraped from home, to avoid grabbing a
    //  substring of a malformed value like "9ad5...::769496".)
    function isValidToken(t) {
        if (!t || typeof t !== "string") return false;
        return /^[0-9a-f]{32}::[0-9a-f]{32}::\d{9,10}::(ni|p)$/i.test(t);
    }

    async function mintToken() {
        var config = selectedProvider();
        var homeUrl = MAIN_URL + "/mobile/home?app=1";

        // Step 0: stored-cookie fast path (mirrors getCookie() age check in the source).
        try {
            var s0 = await loadTokenStore();
            var e0 = s0[(config && config.id) || "netflix"];
            if (e0 && e0.value && Date.now() - (e0.time || 0) < 54000000) {
                bypassCookie = { name: e0.name || "t_hash_t", value: e0.value, time: e0.time || Date.now() };
                console.log("[netmirror][bypass] reuse stored cookie (age=" + (Date.now() - (e0.time || 0)) + "ms)");
                return e0.value;
            }
        } catch (_) {}

        // Step 1: home fetch with EXACTLY the two headers the working extension sends.
        var addHash = "";
        try {
            var homeRes = await requestGet(homeUrl, {
                "User-Agent": BYPASS_USER_AGENT,
                "X-Requested-With": BYPASS_XREQ
            });
            var body = String(homeRes.body || "");
            // parseDocument best-effort; never block extraction on its failure.
            try {
                var doc = await parseDocument(body);
                if (doc) {
                    var bodyEl = qs(doc, "body");
                    addHash = bodyEl && bodyEl.attr ? (bodyEl.attr("data-addhash") || "") : "";
                }
            } catch (_) {}
            if (!addHash) {
                var m = body.match(/data-addhash=["']([^"']+)["']/i);
                if (m && isValidToken(m[1])) addHash = m[1];
            }
            if (!addHash) {
                var m2 = body.match(/\baddhash=["']?([0-9a-f]{32}::[0-9a-f]{32}::\d{9,10}::(?:ni|p))["']?/i);
                if (m2 && isValidToken(m2[1])) addHash = m2[1];
            }
            if (!addHash) {
                // Capture diagnostics so we can see EVERY token-shaped value in the page.
                try {
                    var _title = (body.match(/<title>([^<]*)<\/title>/i) || [])[1] || "(none)";
                    var _hits = [];
                    // Every data-addhash=/addhash= value, verbatim (most likely to be the real token).
                    var _da = /(?:data-)?addhash=["']([^"']+)["']/gi;
                    var _dm;
                    while ((_dm = _da.exec(body)) !== null && _hits.length < 5) _hits.push("addhash:" + _dm[1].slice(0, 60));
                    // Plus any generic hash=/token=/in= value.
                    var _gh = /(?:hash|token|in|verify)=["']?([0-9a-f]{16,}(?:::[0-9a-f]+)*)/gi;
                    var _gm;
                    while ((_gm = _gh.exec(body)) !== null && _hits.length < 8) _hits.push("gen:" + _gm[1].slice(0, 60));
                    lastHomeDiag = { title: _title, len: body.length, hits: _hits, head: body.slice(0, 300).replace(/\n/g, " ") };
                } catch (_) {}
            }
        } catch (_) { /* home fetch best-effort */ }

        if (!addHash) {
            throw new Error("CNCVerse bypass failed: no data-addhash from home and no stored cookie :: DIAG " + JSON.stringify(lastHomeDiag || {}));
        }

        // Step 2: ad-impression beacon (the 301 to the ad network is expected).
        try {
            await requestGet("https://userver.net52.cc/?jjoii=" + encodeURIComponent(addHash) + "&a=y&t=" + unixTime(), {
                "User-Agent": BYPASS_USER_AGENT,
                "X-Requested-With": BYPASS_XREQ
            });
        } catch (_) { /* beacon best-effort */ }

        // Step 3: 10s ad-view delay BEFORE the first verify2 POST (matches delay(10000)).
        await sleep(10000);

        // Step 4: verify2 loop (up to 8 tries); capture t_hash_t when "All Done" appears.
        var lastText = "";
        for (var i = 0; i < 8; i++) {
            var vHeaders = {
                "User-Agent": BYPASS_USER_AGENT,
                "X-Requested-With": "XMLHttpRequest"
            };
            var vRes = await requestPostForm(MAIN_URL + "/mobile/verify2.php", "verify=" + encodeURIComponent(addHash), vHeaders);
            var vText = String(vRes.body || "");
            lastText = vText;
            console.log("[netmirror][bypass] verifyCheck: " + vText.slice(0, 80));
            if (vText.indexOf('"statusup":"All Done"') !== -1) {
                // t_hash_t comes from the response cookies. responseHeader may return an
                // array (multiple set-cookie headers), so use extractCookie which joins
                // and parses safely (avoids "setCookie.match is not a function").
                var cookieVal = extractCookie(vRes.headers, "t_hash_t");
                var cookieName = cookieVal ? "t_hash_t" : "";
                if (!cookieVal) {
                    // Name-agnostic fallback: any t_hash* cookie the server issued.
                    var raw = responseHeader(vRes.headers, "set-cookie");
                    if (Array.isArray(raw)) raw = raw.join("\n");
                    var rawStr = String(raw || "");
                    var cMatch = rawStr.match(/([^;\s\n]*t_hash[a-z0-9_]*)=([^;,\n]+)/i);
                    cookieName = cMatch ? cMatch[1].trim() : "t_hash_t";
                    cookieVal = cMatch ? cMatch[2].trim() : "";
                }
                if (cookieVal) {
                    bypassCookie = { name: cookieName, value: cookieVal, time: Date.now() };
                    try {
                        var store = await loadTokenStore();
                        store[(config && config.id) || "netflix"] = { name: cookieName, value: cookieVal, time: Date.now() };
                        await saveTokenStore(store);
                    } catch (_) {}
                    console.log("[netmirror][bypass] newCookie: " + cookieVal.slice(0, 30));
                    return cookieVal;
                }
                // All Done but no cookie in this response; keep looping a little.
            }
            if (i < 7) await sleep(BYPASS_RETRY_DELAY_MS);
        }
        // Failure path: clear the stored cookie (mirrors clearCookie() in the source).
        try {
            var sf = await loadTokenStore();
            delete sf[(config && config.id) || "netflix"];
            await saveTokenStore(sf);
        } catch (_) {}
        throw new Error("CNCVerse bypass failed: verify2 never returned All Done (last: " + lastText.slice(0, 80) + ")");
    }

    async function bypass() {
        var providerId = (selectedProvider() && selectedProvider().id) || "netflix";
        // In-memory cache first.
        if (bypassCookie.value && Date.now() - (bypassCookie.time || 0) < COOKIE_TTL_MS) return bypassCookie.value;
        // Persistent storage (until the cookie's expiry window) second.
        try {
            var store = await loadTokenStore();
            var entry = store[providerId];
            if (entry && entry.value && Date.now() - (entry.time || 0) < COOKIE_TTL_MS) {
                bypassCookie = { name: entry.name || "t_hash", value: entry.value, time: entry.time || Date.now() };
                return entry.value;
            }
        } catch (_) {}
        // Fresh mint (runs the ad-click verify2 loop).
        var cookie = await mintToken();
        return cookie;
    }

    function unixTime() {
        return Math.floor(Date.now() / 1000);
    }

    function sleep(ms) {
        return new Promise(function(resolve) { setTimeout(resolve, ms || 0); });
    }

    function absoluteUrl(base, value) {
        value = String(value || "").trim();
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base).toString();
        } catch (_) {
            return value;
        }
    }

    function streamHost(url) {
        try {
            return new URL(String(url || "")).hostname;
        } catch (_) {
            return "";
        }
    }

    function proxifyUrl(url, headers, referer) {
        var hosts = [];
        var host = streamHost(url);
        if (host) hosts.push(host);
        var payload = {
            url: url,
            headers: headers || {},
            options: {
                referer: referer || "",
                mirrorHosts: hosts
            }
        };
        return "MAGIC_PROXY_v2" + encodeBase64String(JSON.stringify(payload));
    }

    function parseHlsAttributes(line) {
        var attrs = {};
        var regex = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/ig;
        var match;
        while ((match = regex.exec(String(line || ""))) !== null) {
            attrs[String(match[1] || "").toUpperCase()] = String(match[2] || "").replace(/^"|"$/g, "");
        }
        return attrs;
    }

    function quoteHlsAttr(value) {
        return "\"" + String(value || "").replace(/"/g, "\\\"") + "\"";
    }

    function serializeMediaLine(attrs, url) {
        var out = [];
        var keys = ["TYPE", "GROUP-ID", "LANGUAGE", "NAME", "DEFAULT", "AUTOSELECT", "FORCED", "CHANNELS", "CHARACTERISTICS"];
        for (var i = 0; i < keys.length; i++) {
            var key = keys[i];
            if (typeof attrs[key] === "undefined" || attrs[key] === "") continue;
            if (/^(TYPE|DEFAULT|AUTOSELECT|FORCED)$/i.test(key)) {
                out.push(key + "=" + attrs[key]);
            } else {
                out.push(key + "=" + quoteHlsAttr(attrs[key]));
            }
        }
        out.push("URI=" + quoteHlsAttr(url));
        return "#EXT-X-MEDIA:" + out.join(",");
    }

    function qualityFromVariant(attrs) {
        var resolution = String(attrs.RESOLUTION || "");
        var match = resolution.match(/x(\d+)/i);
        if (match) return parseInt(match[1], 10) || 0;
        var bandwidth = parseInt(String(attrs.BANDWIDTH || attrs["AVERAGE-BANDWIDTH"] || "0").replace(/[^0-9]/g, ""), 10) || 0;
        if (bandwidth >= 12000000) return 2160;
        if (bandwidth >= 5000000) return 1080;
        if (bandwidth >= 2500000) return 720;
        if (bandwidth >= 1200000) return 480;
        if (bandwidth) return 360;
        return 0;
    }

    function parseHlsMaster(masterUrl, body) {
        var text = String(body || "");
        if (!/^#EXTM3U/i.test(text) || text.indexOf("#EXT-X-STREAM-INF") === -1) return null;
        var lines = text.split(/\r?\n/);
        var variants = [];
        var media = [];
        var pending = null;
        var seen = {};
        for (var i = 0; i < lines.length; i++) {
            var raw = String(lines[i] || "").trim();
            if (!raw) continue;
            if (raw.indexOf("#EXT-X-MEDIA:") === 0) {
                var mediaAttrs = parseHlsAttributes(raw.slice("#EXT-X-MEDIA:".length));
                if (mediaAttrs.URI) {
                    mediaAttrs.URI = absoluteUrl(masterUrl, mediaAttrs.URI);
                    media.push({ attrs: mediaAttrs });
                }
                continue;
            }
            if (raw.indexOf("#EXT-X-I-FRAME-STREAM-INF:") === 0) {
                pending = null;
                continue;
            }
            if (raw.indexOf("#EXT-X-STREAM-INF:") === 0) {
                pending = {
                    attrs: parseHlsAttributes(raw.slice("#EXT-X-STREAM-INF:".length)),
                    raw: raw
                };
                continue;
            }
            if (raw.charAt(0) === "#") continue;
            if (!pending) continue;
            var variantUrl = absoluteUrl(masterUrl, raw);
            if (variantUrl && !seen[variantUrl]) {
                seen[variantUrl] = true;
                variants.push({
                    url: variantUrl,
                    attrs: pending.attrs,
                    raw: pending.raw,
                    quality: qualityFromVariant(pending.attrs)
                });
            }
            pending = null;
        }
        return variants.length ? { variants: variants, media: media } : null;
    }

    function mediaByGroup(media, type, groupId) {
        var out = [];
        for (var i = 0; i < (media || []).length; i++) {
            var attrs = media[i].attrs || {};
            if (String(attrs.TYPE || "").toUpperCase() === type && String(attrs["GROUP-ID"] || "") === String(groupId || "")) {
                out.push(attrs);
            }
        }
        return out;
    }

    function subtitlesFromMedia(media, groupId, headers, referer) {
        var rows = mediaByGroup(media, "SUBTITLES", groupId);
        var out = [];
        var seen = {};
        for (var i = 0; i < rows.length; i++) {
            var attrs = rows[i];
            var url = attrs.URI;
            if (!url || seen[url]) continue;
            seen[url] = true;
            var langCode = languageCodeFromAttrs(attrs) || "en";
            out.push({
                url: proxifyUrl(url, headers, referer),
                label: trim(attrs.NAME || attrs.LANGUAGE || "Subtitle"),
                lang: langCode
            });
        }
        return out;
    }

    function buildVariantMiniMaster(variant, media, headers, referer, audioTrack) {
        var lines = ["#EXTM3U", "#EXT-X-VERSION:3"];
        var audioGroup = variant.attrs.AUDIO;
        var audios = audioTrack ? [audioTrack] : mediaByGroup(media, "AUDIO", audioGroup);
        for (var i = 0; i < audios.length; i++) {
            var attrs = Object.assign({}, audios[i]);
            attrs.DEFAULT = "YES";
            attrs.AUTOSELECT = "YES";
            lines.push(serializeMediaLine(attrs, attrs.URI));
        }
        lines.push(String(variant.raw || "").replace(/,?SUBTITLES="[^"]*"/i, ""));
        lines.push(variant.url);
        return "magic_m3u8:" + encodeBase64String(lines.join("\n"));
    }

    function createHlsStream(url, source, headers, quality, subtitles, languageCode, languageName) {
        var stream = new StreamResult({
            url: url,
            source: source,
            headers: headers || {},
            quality: quality || 0
        });
        stream.quality = quality || 0;
        stream.type = "hls";
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        if (languageCode) stream.language = languageCode;
        if (languageName) stream.languageName = languageName;
        return stream;
    }

    function buildExpandedHlsStreams(variant, media, source, headers, referer) {
        var quality = variant.quality || 0;
        var audios = variant.attrs.AUDIO ? mediaByGroup(media, "AUDIO", variant.attrs.AUDIO) : [];
        if (!audios.length) {
            var subtitles = variant.attrs.SUBTITLES ? subtitlesFromMedia(media, variant.attrs.SUBTITLES, headers, referer) : [];
            return [createHlsStream(
                variant.url,
                quality ? (source + " [" + quality + "p]") : source,
                headers,
                quality,
                subtitles
            )];
        }
        var out = [];
        var usedLabels = {};
        for (var i = 0; i < audios.length; i++) {
            var audio = audios[i];
            if (!audio.URI) continue;
            var languageName = languageNameFromAttrs(audio);
            var languageCode = languageCodeFromAttrs(audio);
            var labelKey = languageName.toLowerCase();
            usedLabels[labelKey] = (usedLabels[labelKey] || 0) + 1;
            var displayName = usedLabels[labelKey] > 1 ? (languageName + " " + usedLabels[labelKey]) : languageName;
            out.push(createHlsStream(
                buildVariantMiniMaster(variant, media, headers, referer, audio),
                quality ? (source + " " + displayName + " [" + quality + "p]") : (source + " " + displayName),
                headers,
                quality,
                [],
                languageCode,
                displayName
            ));
        }
        return out.length ? out : [createHlsStream(
            buildVariantMiniMaster(variant, media, headers, referer),
            quality ? (source + " [" + quality + "p]") : source,
            headers,
            quality,
            subtitles
        )];
    }

    async function expandNewTvHlsStreams(masterUrl, source, headers, referer) {
        try {
            var res = await requestGet(masterUrl, headers);
            var parsed = parseHlsMaster(masterUrl, res.body);
            if (!parsed) return [];
            var streams = [];
            parsed.variants.forEach(function(variant) {
                streams.push.apply(streams, buildExpandedHlsStreams(variant, parsed.media, source, headers, referer));
            });
            return streams.sort(function(a, b) {
                var q = Number(b.quality || 0) - Number(a.quality || 0);
                if (q) return q;
                return String(a.source || "").localeCompare(String(b.source || ""));
            });
        } catch (_) {
            return [];
        }
    }

    function maxStreamQuality(streams) {
        var max = 0;
        for (var i = 0; i < (streams || []).length; i++) {
            max = Math.max(max, Number(streams[i] && streams[i].quality || 0) || 0);
        }
        return max;
    }

    function numberFrom(value) {
        var n = parseInt(String(value || "").replace(/[^0-9]/g, ""), 10);
        return isNaN(n) ? undefined : n;
    }

    function runtimeToMinutes(runtime) {
        var total = 0;
        String(runtime || "").split(/\s+/).forEach(function(part) {
            var hours = part.match(/^(\d+)h$/i);
            var minutes = part.match(/^(\d+)m$/i);
            if (hours) total += parseInt(hours[1], 10) * 60;
            if (minutes) total += parseInt(minutes[1], 10);
        });
        return total || undefined;
    }

    function payload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed) return parsed;
        return { id: String(url || "") };
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&#(\d+);/g, function(_, n) { return String.fromCodePoint(parseInt(n, 10)); })
            .replace(/&#x([0-9a-f]+);/gi, function(_, n) { return String.fromCodePoint(parseInt(n, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/\s+/g, " ")
            .trim();
    }

    function normalizeLanguageCode(value) {
        var code = String(value || "").toLowerCase().trim();
        code = code.replace(/_/g, "-").replace(/\.\[cc\]|\[cc\]/g, "");
        code = code.replace(/[^a-z0-9-]/g, "");
        if (code === "ger") return "de";
        if (code === "eng") return "en";
        if (code === "deu") return "de";
        if (code === "ara") return "ar";
        if (code === "ben") return "bn";
        if (code === "ces" || code === "cze") return "cs";
        if (code === "dan") return "da";
        if (code === "ell") return "el";
        if (code === "fre") return "fr";
        if (code === "fra") return "fr";
        if (code === "gre") return "el";
        if (code === "guj") return "gu";
        if (code === "heb") return "he";
        if (code === "hin") return "hi";
        if (code === "hrv") return "hr";
        if (code === "hun") return "hu";
        if (code === "ind") return "id";
        if (code === "ita") return "it";
        if (code === "jpn") return "ja";
        if (code === "kan") return "kn";
        if (code === "kor") return "ko";
        if (code === "mal") return "ml";
        if (code === "mar") return "mr";
        if (code === "may") return "ms";
        if (code === "msa") return "ms";
        if (code === "nob" || code === "nor") return "nb";
        if (code === "dut") return "nl";
        if (code === "nld") return "nl";
        if (code === "pan") return "pa";
        if (code === "pol") return "pl";
        if (code === "por") return "pt";
        if (code === "ron") return "ro";
        if (code === "rum") return "ro";
        if (code === "rus") return "ru";
        if (code === "spa") return "es";
        if (code === "swe") return "sv";
        if (code === "tam") return "ta";
        if (code === "tel") return "te";
        if (code === "tha") return "th";
        if (code === "tur") return "tr";
        if (code === "urd") return "ur";
        if (code === "vie") return "vi";
        if (code === "chi") return "zh";
        if (code === "zho") return "zh";
        return code;
    }

    function languageNameFromAttrs(attrs) {
        attrs = attrs || {};
        var code = normalizeLanguageCode(attrs.LANGUAGE);
        var cleanName = trim(String(attrs.NAME || "").replace(/^\d+\.\s*/, "").replace(/\s*\[cc\]\s*/ig, ""));
        var fromCode = LANGUAGE_NAMES[code] || LANGUAGE_NAMES[code.split("-")[0]];
        if (fromCode) return fromCode;
        if (cleanName && !/^\d+$/i.test(cleanName)) return cleanName;
        return code ? code.toUpperCase() : "Audio";
    }

    function languageCodeFromAttrs(attrs) {
        attrs = attrs || {};
        var code = normalizeLanguageCode(attrs.LANGUAGE);
        if (code) return code;
        var name = trim(String(attrs.NAME || "").replace(/^\d+\.\s*/, "")).toLowerCase();
        var keys = Object.keys(LANGUAGE_NAMES);
        for (var i = 0; i < keys.length; i++) {
            if (LANGUAGE_NAMES[keys[i]].toLowerCase() === name) return normalizeLanguageCode(keys[i]);
        }
        return "";
    }

    function nodeText(node) {
        return decodeHtml(node && node.textContent || "");
    }

    function attr(node) {
        if (!node || !node.getAttribute) return "";
        for (var i = 1; i < arguments.length; i++) {
            var value = node.getAttribute(arguments[i]);
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

    async function parseDocument(html) {
        return await parseHtml(String(html || "").replace(/<style\b[^>]*>[\s\S]*?<\/style>/gi, ""));
    }

    function buildItem(config, id, title, type, posterUrl) {
        var cleanTitle = trim(title);
        if (/<img\b/i.test(cleanTitle)) {
            var alt = cleanTitle.match(/alt=["']([^"']+)["']/i);
            cleanTitle = alt ? decodeHtml(alt[1]) : "";
        }
        return new MultimediaItem({
            title: cleanTitle || "",
            url: payload({ providerId: config.id, id: String(id || ""), title: cleanTitle || "" }),
            posterUrl: posterUrl || config.poster(id),
            type: type || "series"
        });
    }

    function mapHomeCard(config, node) {
        var link = qs(node, "a");
        var id = attr(link, "data-post") || attr(node, "data-post");
        if (!id) return null;
        var image = qs(node, ".card-img-container img, .top10-img img, img");
        var title = attr(image, "alt", "title") || attr(link, "title", "aria-label") || nodeText(qs(node, ".title, h3, h4, p")) || "";
        return buildItem(config, id, title, "series", config.poster(id));
    }

    function mapSearchResult(config, row) {
        if (!row || !row.id) return null;
        return buildItem(config, row.id, row.t, "series", config.poster(row.id));
    }

    function stripTags(value) {
        return decodeHtml(String(value || "").replace(/<[^>]*>/g, " "));
    }

    function parseHomeSectionsFast(config, html) {
        var text = String(html || "");
        var sections = {};
        var chunks = text.split(/<div[^>]+class=["']tray-container["'][^>]*>/i);
        for (var chunkIndex = 1; chunkIndex < chunks.length; chunkIndex++) {
            var block = chunks[chunkIndex] || "";
            var titleMatch = block.match(/<h2[^>]*class=["'][^"']*\btray-title\b[^"']*["'][^>]*>([\s\S]*?)<\/h2>/i);
            var title = stripTags(titleMatch && titleMatch[1]) || "Home";
            var seen = {};
            var items = [];
            var idMatch;
            var idRe = /data-post=["']([^"']+)["']/gi;
            while ((idMatch = idRe.exec(block)) !== null) {
                var id = String(idMatch[1] || "").trim();
                if (!id || seen[id]) continue;
                seen[id] = true;
                items.push(buildItem(config, id, "", "series", config.poster(id)));
            }
            if (items.length) sections[title] = items;
        }
        return sections;
    }

    function buildActor(name) {
        return new Actor({ name: trim(name) });
    }

    function buildEpisode(config, title, episode) {
        return new Episode({
            name: trim(episode && episode.t) || title,
            url: payload({ providerId: config.id, id: episode && episode.id, title: title }),
            season: numberFrom(episode && episode.s) || 1,
            episode: numberFrom(episode && episode.ep) || 1,
            runtime: numberFrom(episode && episode.time),
            posterUrl: config.episodePoster(episode && episode.id)
        });
    }

    async function fetchEpisodes(config, token, title, seriesId, seasonId, page) {
        var episodes = [];
        var pg = page || 1;
        while (true) {
            var url = MAIN_URL + "/mobile" + config.prefix + "/episodes.php?s=" + encodeURIComponent(seasonId) + "&series=" + encodeURIComponent(seriesId) + "&t=" + unixTime() + "&page=" + pg;
            var res = await requestGet(url, pageHeaders(config, token, MAIN_URL + "/home"));
            var json = parseJsonSafe(res.body, {});
            (json.episodes || []).forEach(function(row) {
                if (row && row.id) episodes.push(buildEpisode(config, title, row));
            });
            if (Number(json.nextPageShow || 0) === 0) break;
            pg++;
        }
        return episodes;
    }

    function episodePageRequest(config, token, seriesId, seasonId, page) {
        return {
            seasonId: seasonId,
            page: page || 1,
            url: MAIN_URL + "/mobile" + config.prefix + "/episodes.php?s=" + encodeURIComponent(seasonId) + "&series=" + encodeURIComponent(seriesId) + "&t=" + unixTime() + "&page=" + (page || 1),
            headers: pageHeaders(config, token, MAIN_URL + "/home")
        };
    }

    async function fetchEpisodePagesFast(config, token, title, seriesId, tasks) {
        var episodes = [];
        var pending = (tasks || []).filter(function(task) { return task && task.seasonId; });
        var seen = {};
        while (pending.length) {
            var batch = pending.splice(0, EPISODE_PAGE_CONCURRENCY);
            var requests = batch.map(function(task) {
                var key = String(task.seasonId) + ":" + String(task.page || 1);
                seen[key] = true;
                return episodePageRequest(config, token, seriesId, task.seasonId, task.page || 1);
            });
            var responses = await httpParallelGet(requests, EPISODE_PAGE_CONCURRENCY);
            requests.forEach(function(req, index) {
                var json = parseJsonSafe(responses[index] && responses[index].body, {});
                (json.episodes || []).forEach(function(row) {
                    if (row && row.id) episodes.push(buildEpisode(config, title, row));
                });
                if (Number(json.nextPageShow || 0) !== 0) {
                    var nextTask = { seasonId: req.seasonId, page: (req.page || 1) + 1 };
                    var nextKey = String(nextTask.seasonId) + ":" + String(nextTask.page);
                    if (!seen[nextKey]) pending.push(nextTask);
                }
            });
        }
        return episodes;
    }

    async function mapConcurrent(items, limit, fn) {
        var out = new Array(items.length);
        var index = 0;
        async function worker() {
            while (index < items.length) {
                var i = index++;
                out[i] = await fn(items[i], i).catch(function() { return null; });
            }
        }
        var workers = [];
        var count = Math.min(limit || 4, items.length);
        for (var i = 0; i < count; i++) workers.push(worker());
        await Promise.all(workers);
        return out;
    }

    function buildNewTvHeaders(ott, extra) {
        return withHeaders(NEWTV_BASE_HEADERS, withHeaders({ "Ott": ott }, extra || {}));
    }

    async function resolveApiUrl() {
        if (resolvedApiUrl) return resolvedApiUrl;
        for (var i = 0; i < NEWTV_DOMAINS.length; i++) {
            var base = decodeBase64String(NEWTV_DOMAINS[i]).replace(/\/+$/, "");
            if (!base) continue;
            try {
                var res = await requestGet(base + "/checknewtv.php", NEWTV_BASE_HEADERS);
                var json = parseJsonSafe(res.body, {});
                if (json && json.token_hash) {
                    resolvedApiUrl = decodeBase64String(json.token_hash).replace(/\/+$/, "");
                    if (resolvedApiUrl) return resolvedApiUrl;
                }
            } catch (_) { }
        }
        throw new Error("Failed to resolve NewTV API base URL");
    }

    function buildDirectHlsStream(url, source, quality, headers) {
        var stream = new StreamResult({
            url: url,
            source: source,
            headers: headers || {}
        });
        stream.quality = quality || 0;
        stream.type = "hls";
        return stream;
    }

    async function getHome(cb) {
        try {
            var config = selectedProvider();
            var cached = homeCache[config.id];
            if (cached && Date.now() - cached.time < HOME_CACHE_TTL_MS) {
                return cb({ success: true, data: cached.data });
            }
            var token = await bypass();
            var url = MAIN_URL + "/mobile/home?app=1";
            var res = await requestGet(url, pageHeaders(config, token, url));
            var sections = parseHomeSectionsFast(config, res.body);
            if (!Object.keys(sections).length) {
                var doc = await parseDocument(res.body);
                qsa(doc, ".tray-container, #top10").forEach(function(section) {
                    var title = nodeText(qs(section, "h2, span")) || "Home";
                    var items = qsa(section, "article, .top10-post").map(function(node) {
                        return mapHomeCard(config, node);
                    }).filter(Boolean);
                    if (items.length) sections[title] = items;
                });
            }
            homeCache[config.id] = { time: Date.now(), data: sections };
            Analytics.logEvent('netmirror_home', {});
            cb({ success: true, data: sections });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_HOME_FAILED", message: String(e && e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var config = selectedProvider();
            if (!config.search) return cb({ success: true, data: [] });
            var token = await bypass();
            var url = MAIN_URL + "/mobile" + config.prefix + "/search.php?s=" + encodeURIComponent(query || "") + "&t=" + unixTime();
            var res = await requestGet(url, pageHeaders(config, token, MAIN_URL + "/home"));
            var json = parseJsonSafe(res.body, {});
            var items = (json.searchResult || []).map(function(row) {
                return mapSearchResult(config, row);
            }).filter(Boolean);
            Analytics.logEvent('netmirror_search', {});
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_SEARCH_FAILED", message: String(e && e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var input = parsePayload(url);
            var config = PROVIDERS[String(input.providerId || "").toLowerCase()] || selectedProvider();
            var id = String(input.id || "");
            var loadKey = config.id + ":" + id;
            var cached = loadCache[loadKey];
            if (cached && Date.now() - cached.time < LOAD_CACHE_TTL_MS) {
                return cb({ success: true, data: cached.data });
            }
            var token = await bypass();
            var detailUrl = MAIN_URL + "/mobile" + config.prefix + "/post.php?id=" + encodeURIComponent(id) + "&t=" + unixTime();
            var res = await requestGet(detailUrl, pageHeaders(config, token, MAIN_URL + "/home"));
            var data = parseJsonSafe(res.body, {});
            var title = trim(data.title || input.title || config.name);
            var rawEpisodes = data.episodes || [];
            var isMovie = !rawEpisodes.length || rawEpisodes[0] == null;
            var episodes = [];

            if (isMovie) {
                episodes.push(new Episode({
                    name: title,
                    url: payload({ providerId: config.id, id: id, title: title }),
                    season: 1,
                    episode: 1
                }));
            } else {
                rawEpisodes.filter(Boolean).forEach(function(row) {
                    episodes.push(new Episode(Object.assign({}, buildEpisode(config, title, row), {
                        posterUrl: config.initialEpisodePoster(row.id)
                    })));
                });

                var tasks = [];
                if (Number(data.nextPageShow || 0) === 1 && data.nextPageSeason) {
                    tasks.push({ seasonId: data.nextPageSeason, page: 2 });
                }
                (data.season || []).slice(0, Math.max(0, (data.season || []).length - 1)).forEach(function(season) {
                    if (season && season.id) tasks.push({ seasonId: season.id, page: 1 });
                });
                var extra = await fetchEpisodePagesFast(config, token, title, id, tasks);
                extra.forEach(function(ep) {
                    if (ep) episodes.push(ep);
                });
            }

            var genres = String(data.genre || "").split(",").map(trim).filter(Boolean);
            var cast = String(data.cast || "").split(",").map(trim).filter(Boolean).slice(0, 30).map(buildActor);
            var recommendations = (data.suggest || []).map(function(row) {
                return row && row.id ? buildItem(config, row.id, "", "series", config.suggestPoster(row.id)) : null;
            }).filter(Boolean);

            var item = new MultimediaItem({
                title: title,
                url: payload({ providerId: config.id, id: id, title: title }),
                posterUrl: config.poster(id),
                bannerUrl: config.background(id),
                type: isMovie ? "movie" : "series",
                description: trim(data.desc),
                year: numberFrom(data.year),
                score: parseFloat(String(data.match || "").replace(/IMDb/i, "").trim()) || undefined,
                duration: runtimeToMinutes(data.runtime),
                contentRating: trim(data.ua) || undefined,
                cast: cast,
                tags: genres,
                recommendations: recommendations,
                episodes: episodes
            });
            loadCache[loadKey] = { time: Date.now(), data: item };
            Analytics.logEvent('netmirror_load', {});
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_LOAD_FAILED", message: String(e && e.message || e) });
        }
    }

    function parsePlayPage(html) {
        var text = String(html || "");
        var bodyMatch = text.match(/<body\b([^>]*)>/i);
        if (!bodyMatch) return null;
        var attrs = bodyMatch[1] || "";
        function attr(name) {
            var m = attrs.match(new RegExp(name + "=\"([^\"]*)\"", "i"));
            return m ? decodeHtml(m[1]) : "";
        }
        var h = attr("data-h");
        var time = attr("data-time");
        var title = attr("data-title");
        if (!h) return null;
        return { h: h, time: time, title: title };
    }

    async function loadStreams(url, cb) {
        try {
            var input = parsePayload(url);
            var config = PROVIDERS[String(input.providerId || "").toLowerCase()] || selectedProvider();
            var id = String(input.id || "");
            console.log("[netmirror][loadStreams] START id=" + id + " provider=" + config.name);
            var token = await bypass();
            console.log("[netmirror][loadStreams] bypass ok (t_hash_t len=" + (token ? token.length : 0) + ")");

            // Verified flow — mirrors NetflixMirrorProvider.loadLinks in the working
            // CNCVerse .cs3: GET {MAIN_URL}/mobile/playlist.php?id=<id>&t=<title>&tm=<unix>
            // with the premium t_hash_t cookie. The server returns a PlayList JSON
            // whose `sources` carry the real .m3u8 and `tracks` carry captions.
            // (No /newtv/player.php, no Cloudflare clearance — the t_hash_t tier is
            // the actual gate, confirmed by decompiling the working build.)
            var playlistUrl = MAIN_URL + "/mobile/playlist.php?id=" + encodeURIComponent(id) +
                "&t=" + encodeURIComponent(input.title || config.name) + "&tm=" + unixTime();
            console.log("[netmirror][loadStreams] GET " + playlistUrl);

            var cookieName = bypassCookie.name || "t_hash";
            var cookieHeaderValue = cookieName + "=" + token + "; ott=" + (config.playerOtt || config.ott) + "; hd=on";
            var plHeaders = {
                "Accept": "*/*",
                "Accept-Language": "en-IN,en-US;q=0.9,en;q=0.8",
                "Connection": "keep-alive",
                "Cookie": cookieHeaderValue,
                "Referer": MAIN_URL + "/mobile/home?app=1",
                "sec-ch-ua": "\"Android WebView\";v=\"149\", \"Chromium\";v=\"149\", \"Not)A;Brand\";v=\"24\"",
                "sec-ch-ua-mobile": "?0",
                "sec-ch-ua-platform": "\"Android\"",
                "Sec-Fetch-Dest": "empty",
                "Sec-Fetch-Mode": "cors",
                "Sec-Fetch-Site": "same-origin",
                "User-Agent": USER_AGENT,
                "X-Requested-With": BYPASS_XREQ
            };

            var plRes = await requestGet(playlistUrl, plHeaders);
            var pl = parseJsonSafe(plRes.body, null);
            // playlist.php returns a JSON ARRAY: [{ title, image2, sources, tracks }].
            var data = (pl && Array.isArray(pl)) ? (pl[0] || {}) : (pl || {});
            console.log("[netmirror][loadStreams] playlist BACK (keys=" + Object.keys(data).slice(0, 12).join(",") + ")");

            var streams = [];
            var sources = data.sources || [];
            var tracks = data.tracks || [];

            // Build per-source HLS streams (full master, not just audio).
            for (var i = 0; i < sources.length; i++) {
                var src = sources[i];
                if (!src) continue;
                var file = src.file || src.url || src.src || "";
                var label = src.label || src.quality || src.type || ("Source " + (i + 1));
                if (!file) continue;
                file = absoluteUrl(MAIN_URL, file);
                // Each source is a master .m3u8; expand its VIDEO+AUDIO+SUBTITLES groups.
                var srcHeaders = {
                    "User-Agent": PLAYER_USER_AGENT,
                    "Accept": "*/*",
                    "Referer": MAIN_URL + "/mobile/home?app=1",
                    "Cookie": "hd=on"
                };
                var expanded = await expandNewTvHlsStreams(file, config.name + " " + label, srcHeaders, MAIN_URL + "/mobile/home?app=1");
                if (expanded && expanded.length) {
                    streams = streams.concat(expanded);
                } else {
                    streams.push(buildDirectHlsStream(file, config.name + " " + label, 0, srcHeaders));
                }
            }

            // Attach caption tracks as standalone subtitle streams.
            if (tracks && tracks.length) {
                for (var t = 0; t < tracks.length; t++) {
                    var tr = tracks[t];
                    if (!tr || (tr.kind && tr.kind !== "captions" && tr.kind !== "subtitles")) continue;
                    var tfile = absoluteUrl(MAIN_URL, tr.file || tr.url || "");
                    if (!tfile) continue;
                    var sub = new StreamResult({ url: tfile, source: config.name + " " + (tr.label || "CC"), headers: { "Referer": MAIN_URL + "/mobile/home?app=1" } });
                    sub.type = "subtitle";
                    sub.subtitleLang = String(tr.label || "en").slice(0, 3).toLowerCase();
                    streams.push(sub);
                }
            }

            console.log("[netmirror][loadStreams] built streams=" + streams.length);
            if (!streams.length) {
                console.log("[netmirror][loadStreams] no sources -> empty");
                return cb({ success: true, data: [] });
            }

            Analytics.logEvent('netmirror_loadstreams', {});
            console.log("[netmirror][loadStreams] DONE streams=" + streams.length);
            cb({ success: true, data: streams });
        } catch (e) {
            console.log("[netmirror][loadStreams] EXCEPTION " + (e && e.message));
            cb({ success: false, errorCode: "CNCVERSE_STREAMS_FAILED", message: String(e && e.message || e) });
        }
    }


    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
