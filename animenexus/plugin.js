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
    var SHOW_CACHE = {};  // id → { poster, backdrop, background, logo } from list endpoints

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
    function proxifyStream(url) {
        var headers = { "User-Agent": USER_AGENT, "Referer": APP_URL + "/", "Origin": APP_URL };
        if (SESSION_COOKIE) headers["Cookie"] = SESSION_COOKIE;
        var payload = { url: url, headers: headers, options: { referer: APP_URL + "/" } };
        return "MAGIC_PROXY_v2" + base64Encode(JSON.stringify(payload));
    }

    // ─── Image Helpers ───────────────────────────────────────────────────────────
    // CF Image Resizing URLs embed the original URL as base64 in the path.
    // Extract it to get a directly accessible assets.anime.nexus URL.
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

            // Show details
            var sj = await apiGet("/api/anime/shows?id=" + encodeURIComponent(showId));
            var sa = sj && sj.data;
            var show = Array.isArray(sa) ? sa[0] : sa;
            if (!show) { cb({ success: false, errorCode: "PARSE_ERROR", message: "Show not found" }); return; }

            // Statistics (scores, languages)
            var stats = { data: {} };
            try { stats = await apiGet("/api/anime/details/statistics?id=" + encodeURIComponent(showId)); } catch (_) {}

            // Episodes
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

            var item = new MultimediaItem({
                title: show.name || "Unknown",
                url: url,
                posterUrl: posterUrl(show),
                bannerUrl: bannerUrl(show),
                logoUrl: logoUrl(show),
                type: "anime",
                description: show.description || "",
                year: show.release_date ? parseInt(show.release_date) : undefined,
                releaseDate: show.release_date || undefined,
                score: stats.data && stats.data.average ? stats.data.average.score : undefined,
                status: (!show.status || show.status === "Finished Airing") ? "completed" : show.status === "Currently Airing" ? "ongoing" : "upcoming",
                contentRating: show.parental_rating || undefined,
                tags: show.genres ? show.genres.map(function(g) { return g.name; }) : undefined,
                nextAiring: show.next_episode ? new NextAiring({
                    episode: show.next_episode.episode,
                    season: 1,
                    airDate: show.next_episode.air_date || ""
                }) : undefined,
                playbackPolicy: "none",
                headers: { "Referer": APP_URL + "/" },
                episodes: episodes
            });

            cb({ success: true, data: item });

            Analytics.logEvent("load_show", { show_id: showId, show_name: show.name });
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

            // Route through MAGIC_PROXY_v2 with session cookie to handle auth.
            // Note: the video endpoint (api.anime.nexus/api/anime/video/*) uses
            // Cloudflare Turnstile + WebSocket attestation. The proxy may still
            // return 403 if the server requires a Turnstile token.
            var proxyUrl = proxifyStream(hlsUrl);

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
                label = best.replace("x", "×") + (mb ? " (" + mb + ")" : "");
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
