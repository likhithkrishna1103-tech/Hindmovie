(function () {
    "use strict";

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

    var POSTER_CDNS = {
        nf: {
            poster_v: "https://imgcdn.kim/poster/v/{id}.jpg",
            poster_h: "https://imgcdn.kim/poster/h/{id}.jpg",
            episode: "https://imgcdn.kim/epimg/150/{id}.jpg"
        },
        pv: {
            poster_v: "https://imgcdn.kim/pv/v/{id}.jpg",
            poster_h: "https://imgcdn.kim/pv/h/{id}.jpg",
            episode: "https://imgcdn.kim/pvepimg/{id}.jpg"
        },
        hs: {
            poster_v: "https://imgcdn.kim/hs/v/{id}.jpg",
            poster_h: "https://imgcdn.kim/hs/h/{id}.jpg",
            episode: "https://imgcdn.kim/hsepimg/{id}.jpg"
        },
        dp: {
            poster_v: "https://imgcdn.kim/hs/v/{id}.jpg",
            poster_h: "https://imgcdn.kim/hs/h/{id}.jpg",
            episode: "https://imgcdn.kim/hsepimg/{id}.jpg"
        }
    };

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

    // =========================================================================
    // Universal HTTP Transport
    // =========================================================================

    async function httpRequest(url, options) {
        options = options || {};
        var method = options.method || "GET";
        var headers = options.headers || {};
        var body = options.body;
        var redirect = options.redirect || "follow";

        if (typeof fetch === "function") {
            var fetchOpts = {
                method: method,
                headers: headers,
                body: body,
                redirect: redirect
            };
            var res = await fetch(url, fetchOpts);
            var text = await res.text();
            var resHeaders = {};
            if (res.headers) {
                if (typeof res.headers.forEach === "function") {
                    res.headers.forEach(function (v, k) {
                        resHeaders[k.toLowerCase()] = v;
                    });
                } else if (typeof res.headers.get === "function") {
                    var setCookie = res.headers.get("set-cookie");
                    if (setCookie) resHeaders["set-cookie"] = setCookie;
                }
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

        if (method === "GET" && typeof http_get === "function") {
            var getRes = await Promise.resolve(http_get(url, headers));
            return {
                status: (getRes && getRes.status) || 200,
                headers: (getRes && getRes.headers) || {},
                body: (getRes && getRes.body) || "",
                json: function () {
                    try { return JSON.parse((getRes && getRes.body) || ""); } catch (_) { return null; }
                }
            };
        }

        if (method === "POST" && typeof http_post === "function") {
            var postRes = await Promise.resolve(http_post(url, body, headers));
            return {
                status: (postRes && postRes.status) || 200,
                headers: (postRes && postRes.headers) || {},
                body: (postRes && postRes.body) || "",
                json: function () {
                    try { return JSON.parse((postRes && postRes.body) || ""); } catch (_) { return null; }
                }
            };
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
            "Content-Type": "application/x-www-form-urlencoded",
            "Origin": VERIFY_ORIGIN,
            "Referer": VERIFY_REFERER,
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36"
        };

        var res = await httpRequest(verifyUrl, {
            method: "POST",
            headers: headers,
            body: formBody,
            redirect: "manual"
        });

        var cookieHeader = res.headers["set-cookie"] || "";
        var match = String(cookieHeader).match(/t_hash_t=([^;,\s]+)/);
        if (match && match[1]) {
            cachedCookie = match[1];
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
     * Obtains playback JWT usertoken via /newtv/otp.php using hardcoded OTP '111111'.
     */
    async function getNewTvUserToken(ott, force) {
        var now = Date.now();
        var backendOtt = (ott === "dp" || ott === "hs") ? "hs" : ott;
        var existing = cachedUserTokens[backendOtt];
        if (!force && existing && (now - existing.ts < 3600000)) {
            return existing.token;
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

    function createCookieHeader(cookie, ott) {
        return "t_hash_t=" + cookie + "; ott=" + ott + "; hd=on";
    }

    // =========================================================================
    // SkyStream Plugin APIs
    // =========================================================================

    /**
     * Loads the home screen categories.
     * @param {(res: Response) => void} cb
     */
    async function getHome(cb) {
        try {
            var cookie = await bypassCookie(false);
            var homeUrl = BASE_URL + "/mobile/home?app=1";
            var headers = {
                "Cookie": createCookieHeader(cookie, "nf"),
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

                    var posterUrl = POSTER_CDNS.nf.poster_v.replace("{id}", id);
                    var bannerUrl = POSTER_CDNS.nf.poster_h.replace("{id}", id);

                    items.push(new MultimediaItem({
                        title: "",
                        url: BASE_URL + "/post?id=" + id + "&ott=nf",
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
     * Searches for media items across Netflix, Prime Video, and Hotstar.
     * @param {string} query
     * @param {(res: Response) => void} cb
     */
    async function search(query, cb) {
        try {
            var cookie = await bypassCookie(false);
            var now = Date.now();
            var platforms = ["nf", "pv", "hs"];
            var platformLabels = { nf: "Netflix", pv: "Prime Video", hs: "Hotstar" };
            var allResults = [];

            // Query Netflix, Prime Video, and Hotstar in parallel
            var searchPromises = platforms.map(async function (ott) {
                var searchUrl = BASE_URL + "/mobile/search.php?s=" + encodeURIComponent(query) + "&t=" + now;
                var headers = {
                    "Cookie": createCookieHeader(cookie, ott),
                    "Referer": BASE_URL + "/home",
                    "User-Agent": "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36"
                };

                try {
                    var res = await httpRequest(searchUrl, { headers: headers });
                    var json = res.json();
                    if (json && Array.isArray(json.searchResult)) {
                        var posterTmpl = (POSTER_CDNS[ott] && POSTER_CDNS[ott].poster_v) || POSTER_CDNS.nf.poster_v;
                        var bannerTmpl = (POSTER_CDNS[ott] && POSTER_CDNS[ott].poster_h) || POSTER_CDNS.nf.poster_h;

                        return json.searchResult.map(function (item) {
                            var id = String(item.id);
                            var title = String(item.t || "Untitled");
                            var posterUrl = posterTmpl.replace("{id}", id);
                            var bannerUrl = bannerTmpl.replace("{id}", id);
                            var tag = platformLabels[ott] || ott.toUpperCase();

                            return new MultimediaItem({
                                title: "[" + tag + "] " + title,
                                url: BASE_URL + "/post?id=" + id + "&ott=" + ott,
                                posterUrl: posterUrl,
                                bannerUrl: bannerUrl,
                                type: "movie",
                                headers: { "Referer": BASE_URL + "/home" }
                            });
                        });
                    }
                } catch (_) {}
                return [];
            });

            var searchResponses = await Promise.all(searchPromises);
            for (var p = 0; p < searchResponses.length; p++) {
                allResults = allResults.concat(searchResponses[p]);
            }

            cb({
                success: true,
                data: allResults
            });
        } catch (e) {
            cb({
                success: false,
                errorCode: "SEARCH_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    /**
     * Loads detailed metadata and episodes for a media item.
     * @param {string} url
     * @param {(res: Response) => void} cb
     */
    async function load(url, cb) {
        try {
            var cookie = await bypassCookie(false);
            var now = Date.now();

            // Extract id and ott from URL parameters
            var idMatch = url.match(/[?&]id=([^&]+)/);
            var ottMatch = url.match(/[?&]ott=([^&]+)/);
            var id = idMatch ? idMatch[1] : url.replace(/^.*\/watch\/|^.*\/post\//, "").split("?")[0];
            var ott = ottMatch ? ottMatch[1] : "nf";

            var postUrl = BASE_URL + "/mobile/post.php?id=" + id + "&t=" + now;
            var headers = {
                "Cookie": createCookieHeader(cookie, ott),
                "Referer": BASE_URL + "/home",
                "User-Agent": "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36"
            };

            var res = await httpRequest(postUrl, { headers: headers });
            var data = res.json();
            if (!data) {
                throw new Error("Empty or invalid response from post.php for ID: " + id);
            }

            var title = data.title || "Untitled";
            var year = parseInt(data.year, 10) || undefined;
            var description = data.desc || undefined;
            var director = data.director || undefined;
            var genres = (data.genre || "").split(",").map(function (s) { return s.trim(); }).filter(Boolean);
            var castList = (data.cast || "").split(",").map(function (s) { return s.trim(); }).filter(Boolean);
            var actors = castList.map(function (name) { return new Actor({ name: name }); });
            var score = parseScore(data.match);
            var duration = parseDurationMinutes(data.runtime);

            var posterTmpl = (POSTER_CDNS[ott] && POSTER_CDNS[ott].poster_v) || POSTER_CDNS.nf.poster_v;
            var bannerTmpl = (POSTER_CDNS[ott] && POSTER_CDNS[ott].poster_h) || POSTER_CDNS.nf.poster_h;
            var epPosterTmpl = (POSTER_CDNS[ott] && POSTER_CDNS[ott].episode) || POSTER_CDNS.nf.episode;

            var isSeries = Array.isArray(data.episodes) && data.episodes.length > 0 && data.episodes[0] !== null;
            var episodes = [];

            if (isSeries) {
                // Collect initial season episodes
                for (var e = 0; e < data.episodes.length; e++) {
                    var ep = data.episodes[e];
                    if (!ep) continue;
                    var epId = String(ep.id);
                    var epNum = ep.ep ? parseInt(String(ep.ep).replace(/E/i, ""), 10) : (e + 1);
                    var sNum = ep.s ? parseInt(String(ep.s).replace(/S/i, ""), 10) : 1;
                    var epRuntime = parseDurationMinutes(ep.time);

                    episodes.push(new Episode({
                        name: ep.t || ("Episode " + epNum),
                        url: BASE_URL + "/watch?id=" + epId + "&ott=" + ott,
                        season: sNum,
                        episode: epNum,
                        runtime: epRuntime,
                        posterUrl: epPosterTmpl.replace("{id}", epId),
                        headers: { "Referer": BASE_URL + "/home" }
                    }));
                }

                // If series has multiple seasons, fetch remaining seasons in parallel
                var seasons = Array.isArray(data.season) ? data.season : [];
                if (seasons.length > 1) {
                    var remainingSeasons = seasons.slice(0, seasons.length - 1);
                    var seasonPromises = remainingSeasons.map(async function (s) {
                        var sid = s.id;
                        var sUrl = BASE_URL + "/mobile/episodes.php?s=" + sid + "&series=" + id + "&t=" + now + "&page=1";
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
                                        url: BASE_URL + "/watch?id=" + sepId + "&ott=" + ott,
                                        season: sesNum,
                                        episode: sepNum,
                                        runtime: sepRuntime,
                                        posterUrl: epPosterTmpl.replace("{id}", sepId),
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
                    url: BASE_URL + "/watch?id=" + id + "&ott=" + ott,
                    season: 1,
                    episode: 1,
                    runtime: duration,
                    posterUrl: posterTmpl.replace("{id}", id),
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
                            url: BASE_URL + "/post?id=" + sugId + "&ott=" + ott,
                            posterUrl: posterTmpl.replace("{id}", sugId),
                            type: isSeries ? "series" : "movie"
                        }));
                    }
                }
            }

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: posterTmpl.replace("{id}", id),
                bannerUrl: bannerTmpl.replace("{id}", id),
                type: isSeries ? "series" : "movie",
                year: year,
                description: description,
                score: score,
                duration: duration,
                tags: genres,
                cast: actors,
                recommendations: recommendations,
                episodes: episodes,
                headers: { "Referer": BASE_URL + "/home" }
            });

            cb({
                success: true,
                data: item
            });
        } catch (e) {
            cb({
                success: false,
                errorCode: "LOAD_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    /**
     * Resolves HLS master streams for a media item or episode via NewTV player.
     * @param {string} url
     * @param {(res: Response) => void} cb
     */
    async function loadStreams(url, cb) {
        try {
            var idMatch = url.match(/[?&]id=([^&]+)/);
            var ottMatch = url.match(/[?&]ott=([^&]+)/);
            var id = idMatch ? idMatch[1] : url.replace(/^.*\/watch\/|^.*\/post\//, "").split("?")[0];
            var ott = ottMatch ? ottMatch[1] : "nf";

            var apiBase = await resolveApiUrl(false);
            var backendOtt = (ott === "dp" || ott === "hs") ? "hs" : ott;
            var usertoken = await getNewTvUserToken(backendOtt, false);

            var playerUrl = apiBase + "/newtv/player.php?id=" + id;
            var headers = {
                "Ott": backendOtt,
                "Usertoken": usertoken,
                "X-Requested-With": "NetmirrorNewTV v1.0",
                "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0"
            };

            var res = await httpRequest(playerUrl, { headers: headers });
            var json = res.json();
            if (!json || !json.video_link) {
                throw new Error("NewTV player failed to provide video stream link: " + res.body);
            }

            var videoLink = json.video_link;
            var referer = json.referer || apiBase;

            cb({
                success: true,
                data: [
                    new StreamResult({
                        url: videoLink,
                        quality: "Auto (HLS)",
                        headers: {
                            "Referer": referer,
                            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36"
                        }
                    })
                ]
            });
        } catch (e) {
            cb({
                success: false,
                errorCode: "STREAM_ERROR",
                message: String(e && (e.stack || e.message) || e)
            });
        }
    }

    // Export functions to both globalThis and root
    var root = typeof globalThis !== "undefined" ? globalThis : (typeof window !== "undefined" ? window : (typeof global !== "undefined" ? global : this));

    root.getHome = getHome;
    root.loadHome = getHome;
    root.loadhome = getHome;
    root.search = search;
    root.load = load;
    root.loadStreams = loadStreams;

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
