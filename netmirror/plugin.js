(function () {
    "use strict";

    var safeFetch = typeof fetch === "function" ? fetch : null;
    if (!safeFetch) {
        try {
            safeFetch = (new Function("return (this.constructor.constructor('return fetch')())")());
        } catch (_) {}
    }

    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    var DEFAULT_BASE_URL = "https://net52.cc";
    var runtimeManifest = (typeof manifest !== "undefined" && manifest) ? manifest : { baseUrl: DEFAULT_BASE_URL };
    var BASE_URL = runtimeManifest.baseUrl || DEFAULT_BASE_URL;

    var VERIFY_ORIGIN = "https://net22.cc";
    var VERIFY_REFERER = "https://net22.cc/verify2";
    var IMG_BASE = "https://imgcdn.kim";

    // 24 Base64-encoded seed discovery domains from CNC Verse bytecode
    var NEWTV_DOMAIN_SEEDS_B64 = [
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

    // =========================================================================
    // Provider Configuration matching CNC Verse (.cs3)
    // =========================================================================

    var PROVIDERS = {
        netflix: {
            id: "netflix",
            name: "Netflix",
            ott: "nf",
            playerOtt: "nf",
            prefix: "",
            search: true,
            poster: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/poster/h/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/epimg/150/" + id + ".jpg"; }
        },
        prime: {
            id: "prime",
            name: "Prime Video",
            ott: "pv",
            playerOtt: "pv",
            prefix: "/pv",
            search: true,
            poster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/pv/h/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/pvepimg/" + id + ".jpg"; }
        },
        hotstar: {
            id: "hotstar",
            name: "Hotstar",
            ott: "hs",
            playerOtt: "hs",
            prefix: "/hs",
            search: true,
            poster: function (id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/hs/h/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/hsepimg/" + id + ".jpg"; }
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

    function selectedProvider() {
        var id = (typeof manifest !== "undefined" && manifest && manifest.providerId)
            ? String(manifest.providerId).toLowerCase().trim()
            : "netflix";
        return PROVIDERS[id] || PROVIDERS.netflix;
    }

    // Cache variables
    var cachedCookie = null;
    var cachedCookieTime = 0;
    var cachedApiUrl = null;
    var cachedApiTime = 0;
    var cachedUserTokens = {};

    // =========================================================================
    // Utilities
    // =========================================================================

    function base64Decode(str) {
        if (typeof atob === "function") {
            return atob(str);
        }
        if (typeof Buffer !== "undefined") {
            return Buffer.from(str, "base64").toString("utf-8");
        }
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

    function generateUuid() {
        return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
            var r = (Math.random() * 16) | 0;
            return (c === "x" ? r : (r & 0x3) | 0x8).toString(16);
        });
    }

    function parseDurationMinutes(runtimeStr) {
        if (!runtimeStr) return undefined;
        var str = String(runtimeStr).toLowerCase();
        var total = 0;
        var hMatch = str.match(/(\d+)\s*h/);
        var mMatch = str.match(/(\d+)\s*m/);
        if (hMatch) total += parseInt(hMatch[1], 10) * 60;
        if (mMatch) total += parseInt(mMatch[1], 10);
        return total > 0 ? total : undefined;
    }

    function parseScore(matchStr) {
        if (!matchStr) return undefined;
        var pctMatch = String(matchStr).match(/(\d+)%/);
        if (pctMatch) {
            return parseFloat((parseInt(pctMatch[1], 10) / 10).toFixed(1));
        }
        var numMatch = String(matchStr).match(/([\d.]+)/);
        if (numMatch) {
            return parseFloat(numMatch[1]);
        }
        return undefined;
    }

    function normalizeHeaders(headers) {
        var out = {};
        if (!headers) return out;
        if (typeof headers.forEach === "function") {
            headers.forEach(function (v, k) {
                out[String(k).toLowerCase()] = v;
            });
            return out;
        }
        var keys = Object.keys(headers);
        for (var i = 0; i < keys.length; i++) {
            out[String(keys[i]).toLowerCase()] = headers[keys[i]];
        }
        return out;
    }

    function extractCookie(headers, cookieName) {
        if (!headers) return "";
        var wanted = String(cookieName || "").toLowerCase();
        var raw = headers["set-cookie"] || "";
        if (!raw) {
            var keys = Object.keys(headers);
            for (var i = 0; i < keys.length; i++) {
                if (keys[i].toLowerCase() === "set-cookie") {
                    raw = headers[keys[i]];
                    break;
                }
            }
        }
        if (Array.isArray(raw)) raw = raw.join("\n");
        var text = String(raw || "");
        var re = new RegExp(cookieName + "=([^;\\n\\s]+)", "i");
        var match = text.match(re);
        return match ? match[1] : "";
    }

    // =========================================================================
    // Universal HTTP Transport
    // =========================================================================

    async function httpRequest(url, options) {
        options = options || {};
        var method = (options.method || "GET").toUpperCase();
        var headers = options.headers || {};
        var body = options.body;
        var fetchFn = typeof fetch === "function" ? fetch : safeFetch;

        // When manual redirect is explicitly requested (e.g. verify.php 301 Set-Cookie capture),
        // use fetchFn with redirect: "manual" so the client does not follow the redirect to /home.
        if (options.redirect === "manual" && typeof fetchFn === "function") {
            try {
                var manualRes = await fetchFn(url, {
                    method: method,
                    headers: headers,
                    body: body,
                    redirect: "manual"
                });
                var mText = await manualRes.text();
                var mHeaders = normalizeHeaders(manualRes.headers);
                if (manualRes.headers && typeof manualRes.headers.get === "function") {
                    var msc = manualRes.headers.get("set-cookie");
                    if (msc) mHeaders["set-cookie"] = msc;
                }
                return {
                    status: manualRes.status,
                    headers: mHeaders,
                    body: mText,
                    json: function () {
                        try { return JSON.parse(mText); } catch (_) { return null; }
                    }
                };
            } catch (_) {}
        }

        // Prioritize native SkyStream HTTP client bindings (http_get / http_post) for regular requests
        if (method === "GET" && typeof http_get === "function") {
            try {
                var getRes = await Promise.resolve(http_get(url, headers));
                var gBody = (getRes && typeof getRes.body !== "undefined") ? String(getRes.body) : "";
                return {
                    status: (getRes && getRes.status) || 200,
                    headers: normalizeHeaders(getRes && getRes.headers),
                    body: gBody,
                    json: function () {
                        try { return JSON.parse(gBody); } catch (_) { return null; }
                    }
                };
            } catch (_) {}
        }

        if (method === "POST" && typeof http_post === "function") {
            try {
                var p1 = await Promise.resolve(http_post(url, headers, body || ""));
                if (p1 && (p1.body || p1.headers)) {
                    var p1Body = String(p1.body || "");
                    return {
                        status: p1.status || 200,
                        headers: normalizeHeaders(p1.headers),
                        body: p1Body,
                        json: function () {
                            try { return JSON.parse(p1Body); } catch (_) { return null; }
                        }
                    };
                }
            } catch (_) {}
            try {
                var p2 = await Promise.resolve(http_post(url, body || "", headers));
                if (p2 && (p2.body || p2.headers)) {
                    var p2Body = String(p2.body || "");
                    return {
                        status: p2.status || 200,
                        headers: normalizeHeaders(p2.headers),
                        body: p2Body,
                        json: function () {
                            try { return JSON.parse(p2Body); } catch (_) { return null; }
                        }
                    };
                }
            } catch (_) {}
        }

        var fetchFn = typeof fetch === "function" ? fetch : safeFetch;
        if (typeof fetchFn === "function") {
            var fetchOpts = {
                method: method,
                headers: headers,
                body: body,
                redirect: redirect
            };
            var res = await fetchFn(url, fetchOpts);
            var text = await res.text();
            var resHeaders = normalizeHeaders(res.headers);
            if (res.headers && typeof res.headers.get === "function") {
                var sc = res.headers.get("set-cookie");
                if (sc) resHeaders["set-cookie"] = sc;
            }
            return {
                status: res.status,
                headers: resHeaders,
                body: text,
                json: function () {
                    try { return JSON.parse(text); } catch (_) { return null; }
                }
            };
        }

        if (typeof axios !== "undefined" && axios) {
            try {
                var axRes = await axios({
                    url: url,
                    method: method,
                    headers: headers,
                    data: body,
                    maxRedirects: redirect === "manual" ? 0 : 5,
                    validateStatus: function () { return true; },
                    responseType: "text"
                });
                var axBody = (typeof axRes.data === "string") ? axRes.data : JSON.stringify(axRes.data || "");
                return {
                    status: axRes.status,
                    headers: normalizeHeaders(axRes.headers),
                    body: axBody,
                    json: function () {
                        try { return JSON.parse(axBody); } catch (_) { return null; }
                    }
                };
            } catch (_) {}
        }

        throw new Error("No HTTP client available in runtime environment");
    }

    // =========================================================================
    // Core Reverse-Engineered Handshakes & Bypasses
    // =========================================================================

    /**
     * Bypasses the NetMirror anti-bot verification via /verify.php
     * Accepts any synthetic UUID v4 in place of a genuine reCAPTCHA response.
     */
    async function bypassCookie(force) {
        var now = Date.now();
        if (!force && cachedCookie && (now - cachedCookieTime < 54000000)) {
            return cachedCookie;
        }

        var verifyUrl = BASE_URL + "/verify.php";
        var formBody = "g-recaptcha-response=" + encodeURIComponent(generateUuid());
        var headers = {
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
            "Accept-Language": "en-US,en;q=0.9",
            "Cache-Control": "max-age=0",
            "Connection": "keep-alive",
            "Content-Type": "application/x-www-form-urlencoded",
            "Origin": VERIFY_ORIGIN,
            "Referer": VERIFY_REFERER,
            "sec-ch-ua": "\"Google Chrome\";v=\"147\", \"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"147\"",
            "sec-ch-ua-mobile": "?0",
            "sec-ch-ua-platform": "\"Windows\"",
            "Sec-Fetch-Dest": "document",
            "Sec-Fetch-Mode": "navigate",
            "Sec-Fetch-Site": "same-origin",
            "Sec-Fetch-User": "?1",
            "Upgrade-Insecure-Requests": "1",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36"
        };

        var res = await httpRequest(verifyUrl, {
            method: "POST",
            headers: headers,
            body: formBody,
            redirect: "manual"
        });

        var cookieVal = extractCookie(res.headers, "t_hash_t");
        if (!cookieVal) {
            var raw = String(res.headers["set-cookie"] || "");
            var match = raw.match(/([^;\s\n]*t_hash[a-z0-9_]*)=([^;,\n\s]+)/i);
            if (match) cookieVal = match[2].trim();
        }

        if (cookieVal) {
            cachedCookie = cookieVal;
            cachedCookieTime = now;
            return cachedCookie;
        }

        if (cachedCookie) return cachedCookie;
        throw new Error("Failed to acquire t_hash_t session cookie from verify.php");
    }

    /**
     * Discovers the live NewTV streaming backend across 24 seed domains.
     * Caches the resolved URL for 24 hours.
     */
    async function resolveApiUrl(force) {
        var now = Date.now();
        if (!force && cachedApiUrl && (now - cachedApiTime < 86400000)) {
            return cachedApiUrl;
        }

        var headers = {
            "X-Requested-With": "NetmirrorNewTV v1.0",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0",
            "Accept": "application/json, text/plain, */*"
        };

        for (var i = 0; i < NEWTV_DOMAIN_SEEDS_B64.length; i++) {
            try {
                var domain = base64Decode(NEWTV_DOMAIN_SEEDS_B64[i]).replace(/\/+$/, "");
                var checkUrl = domain + "/checknewtv.php";
                var res = await httpRequest(checkUrl, { headers: headers });
                var json = res.json();
                if (json && json.token_hash && json.token_hash.trim()) {
                    var resolved = base64Decode(json.token_hash).replace(/\/+$/, "");
                    cachedApiUrl = resolved;
                    cachedApiTime = now;
                    return resolved;
                }
            } catch (_) {
                continue;
            }
        }

        if (cachedApiUrl) return cachedApiUrl;
        throw new Error("Failed to resolve NewTV API base URL from all seed domains");
    }

    /**
     * Requests an active playback usertoken using static OTP '111111'.
     */
    async function getNewTvUserToken(ott, force) {
        var now = Date.now();
        var backendOtt = (ott === "dp" || ott === "hs") ? "hs" : ott;

        if (!force && cachedUserTokens[backendOtt]) {
            var cached = cachedUserTokens[backendOtt];
            if (now - cached.ts < 3600000) {
                return cached.token;
            }
        }

        var apiBase = await resolveApiUrl(false);
        var otpUrl = apiBase + "/newtv/otp.php";
        var headers = {
            "accept": "application/json, text/plain, */*",
            "otp": "111111",
            "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.Gatu v1.0"
        };

        var res = await httpRequest(otpUrl, { headers: headers });
        var json = res.json();
        if (json && json.usertoken) {
            cachedUserTokens[backendOtt] = { token: json.usertoken, ts: now };
            return json.usertoken;
        }

        throw new Error("Failed to obtain playback usertoken from OTP gateway");
    }

    function createCookieHeader(cookie, config) {
        var parts = [];
        if (cookie) parts.push("t_hash_t=" + cookie);
        parts.push("ott=" + config.ott);
        parts.push("hd=on");
        if (config.studio) parts.push("studio=" + config.studio);
        return parts.join("; ");
    }

    // =========================================================================
    // SkyStream Plugin APIs
    // =========================================================================

    /**
     * Loads the home screen categories for the selected provider.
     * @param {(res: Response) => void} cb
     */
    async function getHome(cb) {
        try {
            var config = selectedProvider();
            var cookie = await bypassCookie(false);
            var homeUrl = BASE_URL + "/mobile/home?app=1";
            var headers = {
                "Cookie": createCookieHeader(cookie, config),
                "Referer": homeUrl,
                "User-Agent": "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0",
                "X-Requested-With": "XMLHttpRequest"
            };

            var res = await httpRequest(homeUrl, { headers: headers });
            var html = res.body || "";

            // Parse trays and items using tray-wrapper and top10 section boundaries
            var sections = html.split(/(?=<div[^>]*class=["\x27][^"\x27]*tray-wrapper|<div[^>]*id=["\x27]top10["\x27]|<div[^>]*class=["\x27]top10["\x27])/i);
            var trays = {};

            for (var t = 0; t < sections.length; t++) {
                var sec = sections[t];
                var titleMatch = sec.match(/<h2[^>]*class=["\x27]tray-title["\x27][^>]*>([\s\S]*?)<\/h2>/i) ||
                                 sec.match(/<a[^>]*class=["\x27]tray-link["\x27][^>]*>([\s\S]*?)<\/a>/i) ||
                                 sec.match(/<span>(Top 10[^<]*)<\/span>/i);

                var trayName = titleMatch ? titleMatch[1].replace(/<[^>]+>/g, "").trim() : "";
                if (!trayName) continue;

                var postRegex = /data-post=["\x27](\d+)["\x27]/g;
                var postMatch;
                var items = [];
                var seenIds = {};

                while ((postMatch = postRegex.exec(sec)) !== null) {
                    var id = postMatch[1];
                    if (seenIds[id]) continue;
                    seenIds[id] = true;

                    var posterUrl = config.poster(id);
                    var bannerUrl = config.background(id);

                    items.push(new MultimediaItem({
                        title: "",
                        url: BASE_URL + config.prefix + "/post?id=" + id + "&ott=" + config.ott + (config.studio ? "&studio=" + config.studio : ""),
                        posterUrl: posterUrl,
                        bannerUrl: bannerUrl,
                        type: "movie",
                        headers: { "Referer": BASE_URL + "/home" }
                    }));
                }

                if (items.length > 0) {
                    trays[trayName] = items;
                }
            }

            // Ensure Trending exists for hero carousel
            if (!trays["Trending"]) {
                var firstKey = Object.keys(trays)[0];
                if (firstKey) {
                    trays["Trending"] = trays[firstKey];
                }
            }

            cb({
                success: true,
                data: trays
            });
        } catch (e) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    /**
     * Searches for media items.
     * @param {string} query
     * @param {(res: Response) => void} cb
     */
    async function search(query, cb) {
        try {
            var config = selectedProvider();
            if (config.search === false) {
                return cb({ success: true, data: [] });
            }

            var cookie = await bypassCookie(false);
            var now = Date.now();
            var searchUrl = BASE_URL + "/mobile" + config.prefix + "/search.php?s=" + encodeURIComponent(query) + "&t=" + now;
            var headers = {
                "Cookie": createCookieHeader(cookie, config),
                "Referer": BASE_URL + "/home",
                "User-Agent": "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36"
            };

            var res = await httpRequest(searchUrl, { headers: headers });
            var json = res.json();
            var items = [];

            if (json && Array.isArray(json.searchResult)) {
                items = json.searchResult.map(function (item) {
                    var id = String(item.id);
                    var title = String(item.t || "Untitled");

                    return new MultimediaItem({
                        title: title,
                        url: BASE_URL + config.prefix + "/post?id=" + id + "&ott=" + config.ott + (config.studio ? "&studio=" + config.studio : ""),
                        posterUrl: config.poster(id),
                        bannerUrl: config.background(id),
                        type: "movie",
                        headers: { "Referer": BASE_URL + "/home" }
                    });
                });
            }

            cb({
                success: true,
                data: items
            });
        } catch (e) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    /**
     * Loads detailed metadata and episodes.
     * @param {string} url
     * @param {(res: Response) => void} cb
     */
    async function load(url, cb) {
        try {
            var u = new URL(url);
            var id = u.searchParams.get("id");
            var ott = u.searchParams.get("ott") || selectedProvider().ott;
            var studio = u.searchParams.get("studio");

            var config = (function () {
                var keys = Object.keys(PROVIDERS);
                for (var i = 0; i < keys.length; i++) {
                    var p = PROVIDERS[keys[i]];
                    if (!p) continue;
                    if (studio && p.studio === studio) return p;
                    if (!studio && p.ott === ott) return p;
                }
                return selectedProvider();
            })();

            var cookie = await bypassCookie(false);
            var now = Date.now();
            var postUrl = BASE_URL + "/mobile" + config.prefix + "/post.php?id=" + id + "&t=" + now;
            var headers = {
                "Cookie": createCookieHeader(cookie, config),
                "Referer": BASE_URL + "/home",
                "User-Agent": "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0",
                "X-Requested-With": "XMLHttpRequest"
            };

            var res = await httpRequest(postUrl, { headers: headers });
            var data = res.json();
            if (!data) throw new Error("Invalid or empty response from post.php");

            var title = String(data.title || "Untitled");
            var synopsis = String(data.desc || "");
            var year = parseInt(String(data.year), 10) || undefined;
            var rating = parseScore(data.match);
            var duration = parseDurationMinutes(data.runtime);
            var genres = String(data.genre || "").split(",").map(function (s) { return s.trim(); }).filter(Boolean);
            var isSeries = Array.isArray(data.episodes) && data.episodes.length > 0;

            var cast = [];
            if (data.cast) {
                var castNames = String(data.cast).split(",").map(function (s) { return s.trim(); }).filter(Boolean);
                cast = castNames.map(function (name) { return new Actor({ name: name }); });
            }

            var directors = [];
            if (data.director) {
                directors = String(data.director).split(",").map(function (s) { return s.trim(); }).filter(Boolean);
            }

            var episodes = [];
            if (isSeries) {
                for (var e = 0; e < data.episodes.length; e++) {
                    var ep = data.episodes[e];
                    var epId = String(ep.id);
                    var epNum = ep.ep ? parseInt(String(ep.ep).replace(/E/i, ""), 10) : (e + 1);
                    var sNum = ep.s ? parseInt(String(ep.s).replace(/S/i, ""), 10) : 1;
                    var epRuntime = parseDurationMinutes(ep.time);

                    episodes.push(new Episode({
                        name: ep.t || ("Episode " + epNum),
                        url: BASE_URL + "/watch?id=" + epId + "&ott=" + config.ott + (config.studio ? "&studio=" + config.studio : ""),
                        season: sNum,
                        episode: epNum,
                        runtime: epRuntime,
                        posterUrl: config.episodePoster(epId),
                        headers: { "Referer": BASE_URL + "/home" }
                    }));
                }

                // If series has multiple seasons, fetch remaining seasons in parallel
                var seasons = Array.isArray(data.season) ? data.season : [];
                if (seasons.length > 1) {
                    var remainingSeasons = seasons.slice(0, seasons.length - 1);
                    var seasonPromises = remainingSeasons.map(async function (s) {
                        var sid = s.id;
                        var sUrl = BASE_URL + "/mobile" + config.prefix + "/episodes.php?s=" + sid + "&series=" + id + "&t=" + now + "&page=1";
                        try {
                            var sRes = await httpRequest(sUrl, { headers: headers });
                            var sJson = sRes.json();
                            if (sJson && Array.isArray(sJson.episodes)) {
                                return sJson.episodes.map(function (sep, idx) {
                                    var sepId = String(sep.id);
                                    var sepNum = sep.ep ? parseInt(String(sep.ep).replace(/E/i, ""), 10) : (idx + 1);
                                    var sesNum = sep.s ? parseInt(String(sep.s).replace(/S/i, ""), 10) : parseInt(s.s, 10) || 1;
                                    var sepRuntime = parseDurationMinutes(sep.time);

                                    return new Episode({
                                        name: sep.t || ("Episode " + sepNum),
                                        url: BASE_URL + "/watch?id=" + sepId + "&ott=" + config.ott + (config.studio ? "&studio=" + config.studio : ""),
                                        season: sesNum,
                                        episode: sepNum,
                                        runtime: sepRuntime,
                                        posterUrl: config.episodePoster(sepId),
                                        headers: { "Referer": BASE_URL + "/home" }
                                    });
                                });
                            }
                        } catch (_) {}
                        return [];
                    });

                    var seasonResults = await Promise.all(seasonPromises);
                    for (var sr = 0; sr < seasonResults.length; sr++) {
                        episodes = episodes.concat(seasonResults[sr]);
                    }
                }
            } else {
                // Single movie
                episodes.push(new Episode({
                    name: title,
                    url: BASE_URL + "/watch?id=" + id + "&ott=" + config.ott + (config.studio ? "&studio=" + config.studio : ""),
                    season: 1,
                    episode: 1,
                    runtime: duration,
                    posterUrl: config.poster(id),
                    headers: { "Referer": BASE_URL + "/home" }
                }));
            }

            // Recommendations from suggest array
            var recommendations = [];
            if (Array.isArray(data.suggest)) {
                for (var sg = 0; sg < data.suggest.length; sg++) {
                    var sug = data.suggest[sg];
                    if (sug && sug.id) {
                        var sugId = String(sug.id);
                        recommendations.push(new MultimediaItem({
                            title: sug.t || "",
                            url: BASE_URL + config.prefix + "/post?id=" + sugId + "&ott=" + config.ott + (config.studio ? "&studio=" + config.studio : ""),
                            posterUrl: config.poster(sugId),
                            type: isSeries ? "series" : "movie"
                        }));
                    }
                }
            }

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: config.poster(id),
                bannerUrl: config.background(id),
                type: isSeries ? "series" : "movie",
                description: synopsis,
                releaseDate: year ? String(year) : undefined,
                score: rating,
                runtime: duration,
                genres: genres,
                directors: directors,
                actors: cast,
                episodes: episodes,
                recommendations: recommendations,
                headers: { "Referer": BASE_URL + "/home" }
            });

            cb({
                success: true,
                data: item
            });
        } catch (e) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    /**
     * Resolves playable HLS master stream for an episode or movie.
     * @param {string} url
     * @param {(res: Response) => void} cb
     */
    async function loadStreams(url, cb) {
        try {
            var u = new URL(url);
            var id = u.searchParams.get("id");
            var ott = u.searchParams.get("ott") || "nf";
            var playerOtt = (ott === "dp" || ott === "hs") ? "hs" : ott;

            var userToken = await getNewTvUserToken(playerOtt, false);
            var apiBase = await resolveApiUrl(false);
            var playerUrl = apiBase + "/newtv/player.php?id=" + id;

            var headers = {
                "Ott": playerOtt,
                "Usertoken": userToken,
                "X-Requested-With": "NetmirrorNewTV v1.0",
                "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0"
            };

            var res = await httpRequest(playerUrl, { headers: headers });
            var json = res.json();
            if (json && json.video_link) {
                var stream = new StreamResult({
                    url: json.video_link,
                    source: "Auto",
                    headers: {
                        "Referer": json.referer || BASE_URL,
                        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36"
                    }
                });

                cb({
                    success: true,
                    data: [stream]
                });
            } else {
                throw new Error("Invalid or empty response from player API: " + JSON.stringify(json));
            }
        } catch (e) {
            cb({
                success: false,
                errorCode: "STREAM_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    // Expose plugin methods globally for SkyStream runtime
    if (typeof globalThis !== "undefined") {
        globalThis.getHome = getHome;
        globalThis.search = search;
        globalThis.load = load;
        globalThis.loadStreams = loadStreams;
    }
    if (typeof window !== "undefined") {
        window.getHome = getHome;
        window.search = search;
        window.load = load;
        window.loadStreams = loadStreams;
    }
    if (typeof module !== "undefined" && module.exports) {
        module.exports = {
            getHome: getHome,
            search: search,
            load: load,
            loadStreams: loadStreams
        };
    }
})();
