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
    // manifest is injected by the runtime

    // ─── Constants ───────────────────────────────────────────────────────────────
    var API_BASE = "https://api.anime.nexus";
    var APP_URL = "https://anime.nexus";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";

    // ─── Cookie / Session Management ─────────────────────────────────────────────
    var SESSION_COOKIE = null;
    var COOKIE_PROMISE = null;
    var SHOW_CACHE = {};  // id → { name, description, poster, backdrop, background, logo } from list endpoints

    function parsecookie(res) {
        if (!res || !res.headers) return null;
        var raw = String(res.headers["set-cookie"] || res.headers["Set-Cookie"] || res.headers["SET_COOKIE"] || "");
        var m = raw.match(/anime_nexus_session=([^;]+)/);
        return m ? "anime_nexus_session=" + m[1] : null;
    }

    async function ensureCookie() {
        if (SESSION_COOKIE) return SESSION_COOKIE;
        if (COOKIE_PROMISE) return COOKIE_PROMISE;
        COOKIE_PROMISE = (async function () {
            try {
                var res = await http_get(API_BASE + "/api/anime/featured", {
                    "User-Agent": USER_AGENT,
                    "Accept": "application/json, text/plain, */*",
                    "Referer": APP_URL + "/",
                    "Origin": APP_URL
                });
                var c = parsecookie(res);
                if (c) SESSION_COOKIE = c;
                // Cache show poster data from featured list
                try {
                    var parsed = JSON.parse(res && res.body ? res.body : "{}");
                    cacheShowsFromList(parsed);
                } catch (_) {}
                return c || "";
            } catch (e) {
                return "";
            }
        })();
        return COOKIE_PROMISE;
    }

    // ─── HTTP Helpers ────────────────────────────────────────────────────────────
    function mergeHeaders() {
        var out = {
            "User-Agent": USER_AGENT,
            "Accept": "application/json, text/plain, */*",
            "Referer": APP_URL + "/",
            "Origin": APP_URL
        };
        if (SESSION_COOKIE) out["Cookie"] = SESSION_COOKIE;
        for (var i = 0; i < arguments.length; i++) {
            var h = arguments[i];
            if (h) { for (var k in h) { if (h.hasOwnProperty(k)) out[k] = h[k]; } }
        }
        return out;
    }

    async function apiGet(path, extraHeaders) {
        await ensureCookie();
        var url = path.indexOf("http") === 0 ? path : API_BASE + path;
        var res = await http_get(url, mergeHeaders(extraHeaders));
        // Refresh cookie if rotated
        var c = parsecookie(res);
        if (c) SESSION_COOKIE = c;
        try { return JSON.parse(res && res.body ? res.body : "{}"); } catch (e) { return {}; }
    }

    async function apiPost(path, extraHeaders, body) {
        await ensureCookie();
        var url = path.indexOf("http") === 0 ? path : (path.indexOf(APP_URL) === 0 ? path : APP_URL + path);
        var res = await http_post(url, mergeHeaders(extraHeaders), body || "");
        var c = parsecookie(res);
        if (c) SESSION_COOKIE = c;
        try { return JSON.parse(res && res.body ? res.body : "{}"); } catch (e) { return {}; }
    }

    // ─── URL Payload Encoding ────────────────────────────────────────────────────
    function base64Encode(value) {
        value = String(value || "");
        try { if (typeof btoa === "function") return btoa(unescape(encodeURIComponent(value))); } catch (_) {}
        try { if (typeof Buffer !== "undefined") return Buffer.from(value, "utf8").toString("base64"); } catch (_) {}
        return value;
    }

    function encodePayload(obj) {
        return "animenexus:" + base64Encode(JSON.stringify(obj || {}));
    }

    function decodePayload(url) {
        var s = String(url || "");
        if (s.indexOf("animenexus:") === 0) {
            try { return JSON.parse(base64Decode(s.slice("animenexus:".length)) || "{}"); } catch (_) {}
        }
        return null;
    }

    // ─── Proxy Helper ────────────────────────────────────────────────────────────
    function proxifyStream(url, extraHeaders) {
        var headers = { "User-Agent": USER_AGENT, "Referer": APP_URL + "/", "Origin": APP_URL };
        if (SESSION_COOKIE) headers["Cookie"] = SESSION_COOKIE;
        if (extraHeaders) {
            for (var k in extraHeaders) {
                if (extraHeaders.hasOwnProperty(k)) headers[k] = extraHeaders[k];
            }
        }
        var payload = { url: url, headers: headers, options: { referer: APP_URL + "/" } };
        return "MAGIC_PROXY_v2" + base64Encode(JSON.stringify(payload));
    }

    // ─── Image Helpers ───────────────────────────────────────────────────────────
    function extractDirectUrl(cfUrl) {
        if (!cfUrl || cfUrl.indexOf("/aHR0c") === -1) return cfUrl;
        var idx = cfUrl.indexOf("/aHR0c");
        var b64part = cfUrl.substring(idx + 1);
        var dotIdx = b64part.lastIndexOf(".");
        if (dotIdx !== -1) b64part = b64part.substring(0, dotIdx);
        b64part = b64part.replace(/\//g, "");
        try { return base64Decode(b64part); } catch (_) { return cfUrl; }
    }

    function pickImg(obj, keys) {
        if (!obj || !obj.resized) return "";
        for (var i = 0; i < keys.length; i++) {
            var v = obj.resized[keys[i]];
            if (v) return extractDirectUrl(v);
        }
        return "";
    }

    function posterUrl(show) {
        var src = (show && show.poster) || (show && SHOW_CACHE[show.id] && SHOW_CACHE[show.id].poster);
        return pickImg(src, ["640x960", "480x720", "240x360"]);
    }
    function bannerUrl(show) {
        var bd = show && (show.backdrop || show.background);
        if (!bd) {
            var cached = show && SHOW_CACHE[show.id];
            bd = cached && (cached.backdrop || cached.background);
        }
        return pickImg(bd, ["1920x1080", "1920x762", "1360x768", "960x540"]);
    }
    function logoUrl(show) {
        var src = (show && show.logo) || (show && SHOW_CACHE[show.id] && SHOW_CACHE[show.id].logo);
        return pickImg(src, ["large", "medium", "small"]);
    }

    // Seed SHOW_CACHE from list endpoints (featured/popular/latest/seasonal)
    function cacheShowsFromList(r) {
        if (!r || !r.data || !r.data.length) return;
        for (var i = 0; i < r.data.length; i++) {
            var s = r.data[i];
            if (s && s.id) {
                SHOW_CACHE[s.id] = {
                    name: s.name,
                    description: s.description,
                    poster: s.poster,
                    backdrop: s.backdrop || s.background,
                    background: s.background,
                    logo: s.logo
                };
            }
        }
    }

    // ─── Mapper ───────────────────────────────────────────────────────────────────
    function mapShow(show) {
        return new MultimediaItem({
            title: show.name || "Unknown",
            url: encodePayload({ t: "s", id: show.id, slug: show.slug, name: show.name }),
            posterUrl: posterUrl(show),
            bannerUrl: bannerUrl(show),
            logoUrl: logoUrl(show),
            type: "anime",
            description: show.description || "",
            year: show.release_date ? parseInt(show.release_date) : undefined,
            score: show.average && show.average.score ? show.average.score : undefined,
            status: (!show.status || show.status === "Finished Airing" || show.status === "Completed") ? "completed" : (show.status === "Currently Airing") ? "ongoing" : "upcoming",
            contentRating: show.parental_rating || undefined,
            tags: show.genres ? show.genres.map(function(g) { return g.name; }) : undefined,
            headers: { "Referer": APP_URL + "/" }
        });
    }

    // ─── WebView-Based HTTP fetch ───────────────────────────────────────────────
    // Makes a web request through the InAppWebView so Cloudflare session/cookies
    // established by solveCaptcha are maintained. Falls back to normal apiPost.
    async function webViewPost(url, bodyObj) {
        var bodyStr = JSON.stringify(bodyObj);
        var headers = {
            "Content-Type": "application/json",
            "Referer": APP_URL + "/",
            "Origin": APP_URL
        };

        // Try global WebView fetch functions first (maintains Cloudflare session)
        var wvNames = [
            "fetchWithWebView", "requestWithWebView", "webViewFetch",
            "webview_fetch", "sessionFetch", "session_fetch",
            "http_post_webview"
        ];
        for (var i = 0; i < wvNames.length; i++) {
            var fn = globalThis[wvNames[i]];
            if (typeof fn !== "function") continue;
            try {
                var res = await fn(url, {
                    method: "POST",
                    body: bodyStr,
                    headers: headers,
                    useWebView: true,
                    webView: true,
                    session: true,
                    cloudflare: true
                });
                var raw = res && res.body ? res.body : (typeof res === "string" ? res : null);
                if (raw) { try { return JSON.parse(raw); } catch (_) {} }
            } catch (_) {}
        }

        // Try http_post with WebView options (4th argument)
        if (typeof http_post === "function") {
            try {
                var res = await http_post(url, headers, bodyStr, {
                    useWebView: true,
                    webView: true,
                    session: true,
                    cloudflare: true
                });
                if (res && res.body) { try { return JSON.parse(res.body); } catch (_) {} }
            } catch (_) {}
        }

        // Final fallback: normal apiPost
        return await apiPost(url, { "Content-Type": "application/json" }, bodyStr);
    }

    // ─── WebSocket Authenticated Session ───────────────────────────────────────────
    // Establishes a Socket.IO connection via WebSocket to get the authenticated
    // session, challenge, and encryptedSecret needed for HLS access.
    async function establishSocketSession(hlsUrl, streamId, fingerprint) {
        if (typeof WebSocket !== "function") {
            console.log("[AnimeNexus] WebSocket not available");
            return null;
        }

        var sid = "";
        var socketUrl = APP_URL.replace(/^http/, "ws") + "/api/socket/?" +
            "EIO=4&transport=websocket&" +
            "videoId=" + encodeURIComponent(streamId) + "&" +
            "fingerprint=" + encodeURIComponent(fingerprint) + "&" +
            "m3u8Url=" + encodeURIComponent(hlsUrl);

        return new Promise(function(resolve) {
            var timeout = setTimeout(function() {
                console.log("[AnimeNexus] Socket session timeout");
                try { ws.close(); } catch(_) {}
                resolve(null);
            }, 15000);

            var ws;
            try {
                ws = new WebSocket(socketUrl);
            } catch(e) {
                console.log("[AnimeNexus] WebSocket create error: " + String(e));
                clearTimeout(timeout);
                resolve(null);
                return;
            }

            var challenge = null;
            var encryptedSecret = null;
            var sessionId = null;
            var connected = false;
            var authenticated = false;

            ws.onopen = function() {
                console.log("[AnimeNexus] Socket connected");
            };

            ws.onmessage = function(event) {
                var data = String(event.data || "");
                // Socket.IO Engine.IO protocol:
                // 0 = open (handshake), 40 = namespace connect, 42 = event

                if (data.charAt(0) === "0") {
                    // Engine.IO handshake: 0{"sid":"...","upgrades":[],"pingInterval":25000,"pingTimeout":20000}
                    try {
                        var handshake = JSON.parse(data.slice(1));
                        sid = handshake.sid;
                        // Send CONNECT to namespace
                        ws.send("40");
                    } catch(e) {}
                }
                else if (data === "40") {
                    // Connected to default namespace
                    connected = true;
                    checkDone();
                }
                else if (data.slice(0, 2) === "42") {
                    // Socket.IO EVENT: 42["eventName", data]
                    try {
                        var msg = JSON.parse(data.slice(2));
                        var eventName = msg[0];
                        var eventData = msg[1] || {};

                        if (eventName === "authenticated") {
                            console.log("[AnimeNexus] Socket authenticated");
                            authenticated = true;
                            challenge = eventData.challenge || null;
                            encryptedSecret = eventData.encryptedSecret || null;
                            sessionId = eventData.sessionId || sid || eventData.sid || null;
                            checkDone();
                        }
                        else if (eventName === "challenge") {
                            // Challenge received (may contain additional attestation data)
                            if (!challenge) challenge = eventData.challenge || null;
                            if (!encryptedSecret) encryptedSecret = eventData.encryptedSecret || null;
                            checkDone();
                        }
                        else if (eventName === "connected") {
                            connected = true;
                            checkDone();
                        }
                    } catch(e) {}
                }
                else if (data === "3") {
                    // Engine.IO ping — respond with pong
                    ws.send("2");
                }
            };

            function checkDone() {
                if (connected && authenticated && challenge && encryptedSecret) {
                    clearTimeout(timeout);
                    console.log("[AnimeNexus] Socket session established");
                    resolve({
                        challenge: challenge,
                        encryptedSecret: encryptedSecret,
                        sessionId: sessionId || sid
                    });
                }
            }

            ws.onerror = function(err) {
                console.log("[AnimeNexus] Socket error: " + String(err));
            };

            ws.onclose = function() {
                if (!connected || !authenticated) {
                    clearTimeout(timeout);
                    console.log("[AnimeNexus] Socket closed before session established");
                    resolve(null);
                }
            };
        });
    }

    // ─── Turnstile / Attestation ──────────────────────────────────────────────────
    // Extracts the stream UUID from an HLS URL
    function extractStreamId(hlsUrl) {
        if (!hlsUrl) return "";
        var m = hlsUrl.match(/\/anime\/video\/([a-f0-9-]+)\//);
        return m ? m[1] : "";
    }

    // Performs the full Turnstile solve + attestation exchange, returns headers map + attested URL
    async function attestStream(hlsUrl) {
        if (typeof solveCaptcha !== "function") {
            console.log("[AnimeNexus] solveCaptcha not available, skipping attestation");
            return null;
        }

        var streamId = extractStreamId(hlsUrl);
        if (!streamId) {
            console.log("[AnimeNexus] Could not extract streamId from HLS URL");
            return null;
        }

        // Generate a unique fingerprint for this session
        var fingerprint = SessionTracker.generateUuid();

        // Solve the Turnstile challenge — opens InAppWebView for user to complete
        var turnstileToken = await solveCaptcha('0x4AAAAAAA80VvnXcgnXgqVY', APP_URL + '/');

        if (!turnstileToken) {
            console.log("[AnimeNexus] Turnstile solve returned no token");
            return null;
        }

        // ─── Strategy 1: WebSocket auth (Socket.IO) ─────────────────────────────
        // This establishes an authenticated session on the server, giving us the
        // challenge + encryptedSecret directly — the HTTP POST is only for refresh.
        var socketSession = null;
        try {
            socketSession = await establishSocketSession(hlsUrl, streamId, fingerprint);
        } catch (e) {
            console.log("[AnimeNexus] Socket session error: " + String(e));
        }

        if (socketSession && socketSession.challenge) {
            var sid = socketSession.sessionId || "";
            var sep = hlsUrl.indexOf('?') > -1 ? '&' : '?';
            var attestedUrl = hlsUrl + sep +
                "token=" + encodeURIComponent(sid) +
                "&requestType=manifest" +
                "&sessionId=" + encodeURIComponent(sid);

            var proxyHeaders = {
                "X-Session-ID": sid,
                "X-Fingerprint": fingerprint,
                "X-Challenge": socketSession.challenge,
                "X-Encrypted-Secret": socketSession.encryptedSecret || ""
            };

            return {
                url: attestedUrl,
                headers: proxyHeaders
            };
        }

        // ─── Strategy 2: HTTP POST attestation (fallback) ───────────────────────
        console.log("[AnimeNexus] WebSocket unavailable or failed, trying HTTP POST");

        var authRes = await webViewPost(APP_URL + "/api/auth/ws-token", {
            videoId: streamId,
            fingerprint: fingerprint,
            purpose: "manifest",
            turnstileToken: turnstileToken
        });

        // Validate attestation response
        if (!authRes || (!authRes.refId && !authRes.token && !authRes.sessionId)) {
            console.log("[AnimeNexus] Attestation failed: " + JSON.stringify(authRes).slice(0, 200));
            return null;
        }

        var refId = authRes.refId || "";
        var sessionId = authRes.sessionId || refId;
        var token = authRes.token || refId;
        var encryptedSecret = authRes.encryptedSecret || "";
        var challenge = authRes.challenge || "";

        var sep = hlsUrl.indexOf('?') > -1 ? '&' : '?';
        var attestedUrl = hlsUrl + sep +
            "token=" + encodeURIComponent(token) +
            "&requestType=manifest" +
            "&sessionId=" + encodeURIComponent(sessionId);

        var proxyHeaders = {
            "X-Session-ID": sessionId,
            "X-Fingerprint": fingerprint
        };
        if (challenge) proxyHeaders["X-Challenge"] = challenge;
        if (encryptedSecret) proxyHeaders["X-Encrypted-Secret"] = encryptedSecret;

        return {
            url: attestedUrl,
            headers: proxyHeaders
        };
    }

    // ─── getHome ──────────────────────────────────────────────────────────────────
    async function getHome(cb) {
        try {
            var results = {};

            try {
                var r = await apiGet("/api/anime/featured");
                if (r && r.data && r.data.length) {
                    cacheShowsFromList(r);
                    results["Trending"] = r.data.map(mapShow);
                }
            } catch (_) {}

            try {
                var r = await apiGet("/api/anime/popular");
                if (r && r.data && r.data.length) {
                    cacheShowsFromList(r);
                    results["Popular"] = r.data.map(mapShow);
                }
            } catch (_) {}

            try {
                var r = await apiGet("/api/anime/latest");
                if (r && r.data && r.data.length) {
                    cacheShowsFromList(r);
                    results["Latest Release"] = r.data.map(mapShow);
                }
            } catch (_) {}

            try {
                var r = await apiGet("/api/anime/seasonal");
                if (r && r.data && r.data.length) {
                    cacheShowsFromList(r);
                    results["Seasonal"] = r.data.map(mapShow);
                }
            } catch (_) {}

            if (Object.keys(results).length === 0) {
                cb({ success: false, errorCode: "PARSE_ERROR", message: "No data from API" });
                return;
            }
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: e && e.stack ? e.stack : String(e) });
        }
    }

    // ─── search ───────────────────────────────────────────────────────────────────
    async function search(query, cb) {
        try {
            var q = String(query || "").trim();
            if (!q) { cb({ success: true, data: [] }); return; }
            var r = await apiGet("/api/anime/shows?search=" + encodeURIComponent(q) + "&perPage=30");
            cb({ success: true, data: (r && r.data || []).map(mapShow) });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e && e.stack ? e.stack : String(e) });
        }
    }

    // ─── load ─────────────────────────────────────────────────────────────────────
    async function load(url, cb) {
        try {
            var p = decodePayload(url);
            if (!p || !p.id) { cb({ success: false, errorCode: "PARSE_ERROR", message: "Bad URL" }); return; }

            var showId = p.id;

            // Show details — NOTE: /api/anime/shows?id=X does FUZZY matching (not exact ID lookup),
            // so the returned show may have wrong name/description.
            // We prefer SHOW_CACHE data (seeded from list/search endpoints) for authoritative
            // metadata, and use the API response only for fields not in cache (status, parental_rating, etc.).
            var sj = await apiGet("/api/anime/shows?id=" + encodeURIComponent(showId));
            var sa = sj && sj.data;
            var show = Array.isArray(sa) ? sa[0] : sa;

            // Use cached show metadata from list endpoints (always correct)
            var cached = SHOW_CACHE[showId] || {};

            if (!show && !cached.name) {
                cb({ success: false, errorCode: "PARSE_ERROR", message: "Show not found" });
                return;
            }

            // Statistics (scores, languages) — this endpoint works correctly
            var stats = { data: {} };
            try { stats = await apiGet("/api/anime/details/statistics?id=" + encodeURIComponent(showId)); } catch (_) {}

            // Episodes — this endpoint works correctly
            var ej = await apiGet("/api/anime/details/episodes?id=" + encodeURIComponent(showId));
            var eps = ej && ej.data || [];
            var episodes = [];

            // API returns newest-first; reverse so ep1 comes first
            for (var i = eps.length - 1; i >= 0; i--) {
                var ep = eps[i];
                if (!ep) continue;

                var al = ep.video_meta && ep.video_meta.audio_languages || [];
                var hasEng = false;
                for (var ai = 0; ai < al.length; ai++) {
                    if (al[ai] === "eng" || al[ai] === "english") { hasEng = true; break; }
                }

                var subLangs = ep.video_meta && ep.video_meta.subtitle_languages || [];
                var qualities = ep.video_meta && ep.video_meta.qualities || {};

                episodes.push(new Episode({
                    name: ep.title || ("Episode " + (ep.number || "")),
                    url: encodePayload({
                        t: "e",
                        id: ep.id,
                        sid: showId,
                        num: ep.number || (eps.length - i),
                        title: ep.title
                    }),
                    season: 1,
                    episode: ep.number || (eps.length - i),
                    description: ep.title || "",
                    posterUrl: pickImg(ep.image, ["640x360", "1024x576"]),
                    duration: ep.duration ? Math.round(ep.duration / 60) : undefined,
                    dubStatus: hasEng ? "dub" : "sub",
                    headers: { "Referer": APP_URL + "/" },
                    streams: []
                }));
            }

            // Prefer cached metadata (correct) over show detail API (may be wrong due to fuzzy ID matching)
            var showTitle = cached.name || (show && show.name) || "Unknown";
            var showDescription = cached.description || (show && show.description) || "";
            var showPoster = cached.poster ? pickImg(cached.poster, ["640x960", "480x720", "240x360"]) : posterUrl(show);
            var showBanner = cached.backdrop ? pickImg(cached.backdrop, ["1920x1080", "1920x762", "1360x768", "960x540"]) : bannerUrl(show);
            var showLogo = cached.logo ? pickImg(cached.logo, ["large", "medium", "small"]) : logoUrl(show);

            // Status from show detail API (SHOW_CACHE doesn't have it)
            var showStatus = show && show.status;
            var itemStatus = (!showStatus || showStatus === "Finished Airing") ? "completed" : showStatus === "Currently Airing" ? "ongoing" : "upcoming";

            var item = new MultimediaItem({
                title: showTitle,
                url: url,
                posterUrl: showPoster,
                bannerUrl: showBanner,
                logoUrl: showLogo,
                type: "anime",
                description: showDescription,
                year: show && show.release_date ? parseInt(show.release_date) : undefined,
                releaseDate: (show && show.release_date) || undefined,
                score: stats.data && stats.data.average ? stats.data.average.score : undefined,
                status: itemStatus,
                contentRating: (show && show.parental_rating) || undefined,
                tags: show && show.genres ? show.genres.map(function(g) { return g.name; }) : undefined,
                nextAiring: show && show.next_episode ? new NextAiring({
                    episode: show.next_episode.episode,
                    season: 1,
                    airDate: show.next_episode.air_date || ""
                }) : undefined,
                playbackPolicy: "none",
                headers: { "Referer": APP_URL + "/" },
                episodes: episodes
            });

            cb({ success: true, data: item });

            Analytics.logEvent("load_show", { show_id: showId, show_name: showTitle });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e && e.stack ? e.stack : String(e) });
        }
    }

    // ─── loadStreams ──────────────────────────────────────────────────────────────
    async function loadStreams(url, cb) {
        try {
            var p = decodePayload(url);
            if (!p || !p.id) { cb({ success: false, errorCode: "PARSE_ERROR", message: "Bad URL" }); return; }

            // Ensure we have a session cookie before hitting stream endpoint
            await ensureCookie();

            var epId = p.id;
            var sj = await apiGet("/api/anime/details/episode/stream?id=" + encodeURIComponent(epId) + "&fillers=false&recaps=false");

            // Check for API error response
            if (sj && sj.errorCode) {
                cb({ success: false, errorCode: "STREAM_ERROR", message: "API error: " + sj.errorCode + (sj.message ? " - " + sj.message : "") });
                return;
            }

            var sd = sj && sj.data;

            if (!sd) { cb({ success: false, errorCode: "PARSE_ERROR", message: "No stream data - response: " + JSON.stringify(sj).slice(0, 500) }); return; }

            var hlsUrl = sd.hls;
            var vmeta = sd.video_meta || {};
            var qualities = vmeta.qualities || {};
            var fileSizes = vmeta.file_size_streams || {};
            var subtitles = sd.subtitles || [];

            if (!hlsUrl) { cb({ success: false, errorCode: "PARSE_ERROR", message: "No HLS URL" }); return; }

            // ─── Turnstile Attestation ─────────────────────────────────────────
            // Try to solve Turnstile + get attestation tokens for the HLS URL.
            // Falls back to proxy without attestation if captcha solve is unavailable.
            var finalUrl = hlsUrl;
            var extraHeaders = {};
            try {
                var attestResult = await attestStream(hlsUrl);
                if (attestResult) {
                    finalUrl = attestResult.url;
                    extraHeaders = attestResult.headers;
                    console.log("[AnimeNexus] Attestation succeeded, tokens acquired");
                } else {
                    console.log("[AnimeNexus] Attestation returned no result, using plain proxy");
                }
            } catch (e) {
                console.log("[AnimeNexus] Attestation error: " + String(e));
            }

            // Build proxy URL with attestation headers if available
            var proxyUrl = proxifyStream(finalUrl, extraHeaders);

            // Quality label — sort by width numerically (not lexicographically)
            var qKeys = Object.keys(qualities).sort(function(a, b) {
                var wa = parseInt(a.split("x")[0]) || 0;
                var wb = parseInt(b.split("x")[0]) || 0;
                return wa - wb;
            });
            var label = "HLS";
            if (qKeys.length > 0) {
                var best = qKeys[qKeys.length - 1];
                var mb = fileSizes[best] ? Math.round(fileSizes[best] / 1048576) + "MB" : "";
                label = best.replace("x", "\u00D7") + (mb ? " (" + mb + ")" : "");
            }

            var primarySource = new StreamResult({
                url: proxyUrl,
                source: label,
                headers: { "Referer": APP_URL + "/", "Origin": APP_URL }
            });

            var streamList = [primarySource];

            // Attach subtitle tracks if available
            if (subtitles.length > 0) {
                var subs = [];
                for (var si = 0; si < subtitles.length; si++) {
                    var s = subtitles[si];
                    if (s && s.src) {
                        subs.push({
                            url: s.src,
                            label: s.label || s.srcLang || "Unknown",
                            lang: s.srcLang || "und"
                        });
                    }
                }
                if (subs.length > 0) {
                    primarySource.subtitleTracks = subs;
                }
            }

            cb({ success: true, data: streamList });

            Analytics.logEvent("load_stream", { episode_id: epId });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e && e.stack ? e.stack : String(e) });
        }
    }

    // ─── Exports ──────────────────────────────────────────────────────────────────
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
