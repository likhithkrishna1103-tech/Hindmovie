(function () {
    "use strict";

    // ============================================================
    // CONFIGURATION — matches IStreamFlare.kt (phisher98 source)
    // ============================================================
    var BASE_URL   = "https://stream.hippitunes.pro";
    var SECRET_KEY = "iSf#2024$Xk9@mNpQrStUvWxYz1234Ab";
    var SALT       = "iStreamFlareSalt";
    var API_KEY    = "kC7V1f8QRaZyvYnh";

    // Kotlin source: USER_AGENT = Chrome 120 (not Dalvik)
    var USER_AGENT  = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
    var CDN_UA      = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    // Kotlin: val headers = mapOf("User-Agent" to USER_AGENT, "x-api-key" to "kC7V1f8QRaZyvYnh")
    var HEADERS = {
        "User-Agent": USER_AGENT,
        "x-api-key": API_KEY
    };

    // Kotlin mainPage: exactly the same endpoints + labels
    var HOME_ENDPOINTS = [
        ["android/getTrending",                               "Trending"],
        ["android/getMostWatched/Movies/0",                   "Most Watched Movies"],
        ["android/getMostWatched/WebSeries/0",                "Most Watched Webseries"],
        ["android/getRecentContentList/Movies",                "Recently Added Movies"],
        ["android/getRecentContentList/WebSeries",             "Recently Added Webseries"],
        ["android/getRandWebSeries",                          "Webseries"],
        ["android/getRandMovies",                             "Movies"],
        ["android/getAllLiveTV",                              "TV Channels"]
    ];

    // ============================================================
    // HELPERS
    // ============================================================
    function trim(v)  { return String(v || "").trim(); }
    function ut8(b)   { return new TextDecoder("utf-8").decode(b); }
    function s2b(s)   { return new TextEncoder().encode(s); }

    // Detect mojibake — if description is garbled double-encoded, return null
    function cleanDesc(s) {
        if (!s) return "";
        // Mojibake characters are telltale of CP1252 double-encoding
        // Ã (U+00C3) and Æ (U+00C6) always start the garbled sequences
        if (s.indexOf("\u00C3") >= 0 || s.indexOf("\u00C6") >= 0) return null;
        // Also reject C1 control chars / high bytes that shouldn't be in clean text
        for (var i = 0; i < s.length; i++) {
            var c = s.charCodeAt(i);
            if (c >= 0x80 && c <= 0x9F) return null;
        }
        return s;
    }

    // ── HLS Master Playlist Parser (for x7flix multi-quality streams) ──
    function parseHlsAttributes(line) {
        var attrs = {};
        var re = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/g;
        var m;
        while ((m = re.exec(line)) !== null) {
            var k = m[1].toUpperCase();
            var v = m[2].replace(/^"|"$/g, "");
            attrs[k] = v;
        }
        return attrs;
    }
    function resolveUrl(base, path) {
        if (!path || path.indexOf("http") === 0) return path || "";
        try { return new URL(path, base).toString(); } catch (_) { return path; }
    }
    function parseQuality(attrs) {
        var res = attrs.RESOLUTION || "";
        var m = res.match(/(\d+)\s*x\s*(\d+)/i);
        if (m) return parseInt(m[2], 10) || 0;
        var bw = parseInt(attrs["AVERAGE-BANDWIDTH"] || attrs.BANDWIDTH || "0", 10);
        if (!bw || bw < 1) return 0;
        if (bw >= 20000000) return 4320;
        if (bw >= 10000000) return 2160;
        if (bw >= 6000000) return 1080;
        if (bw >= 3000000) return 720;
        if (bw >= 1500000) return 480;
        if (bw >= 800000)  return 360;
        if (bw >= 400000)  return 240;
        return 144;
    }
    function parseHlsMaster(text, baseUrl) {
        var info = { variants: [], audioGroups: {} };
        var lines = text.split(/\r?\n/);
        var pending = null;
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i].trim();
            if (!line) continue;
            if (line.indexOf("#EXT-X-MEDIA:") === 0) {
                var a = parseHlsAttributes(line.substring("#EXT-X-MEDIA:".length));
                if (a.TYPE === "AUDIO" && a["GROUP-ID"] && a.URI) {
                    if (!info.audioGroups[a["GROUP-ID"]]) info.audioGroups[a["GROUP-ID"]] = [];
                    info.audioGroups[a["GROUP-ID"]].push({ uri: resolveUrl(baseUrl, a.URI), name: a.NAME || a.LANGUAGE || "Audio", language: a.LANGUAGE || "" });
                }
                continue;
            }
            if (line.indexOf("#EXT-X-STREAM-INF:") === 0) {
                pending = parseHlsAttributes(line.substring("#EXT-X-STREAM-INF:".length));
                continue;
            }
            if (line.charAt(0) === "#") continue;
            if (pending) {
                var resolved = resolveUrl(baseUrl, line);
                if (resolved) {
                    info.variants.push({ url: resolved, attributes: pending });
                }
                pending = null;
            }
        }
        return info;
    }
    async function expandHlsVariants(url, headers) {
        try {
            // Strip |Referer=... or |user_agent=... appended by some sources
            var cleanUrl = url.split("|")[0];
            var resp = await http_get(cleanUrl, headers || {});
            if (!resp) return null;
            var body = (typeof resp.body === "string") ? resp.body : (typeof resp === "string" ? resp : "");
            if (!body || body.indexOf("#EXTM3U") !== 0) return null;
            // If it's already a single-variant playlist (no STREAM-INF), return null -> caller uses URL directly
            if (body.indexOf("#EXT-X-STREAM-INF") === -1) return null;
            var info = parseHlsMaster(body, url);
            if (!info.variants || info.variants.length === 0) return null;
            var streams = [];
            var audioGroupId = null;
            // Find AUDIO group-id from first variant
            for (var a in info.audioGroups) { audioGroupId = a; break; }
            for (var j = 0; j < info.variants.length; j++) {
                var v = info.variants[j];
                var q = parseQuality(v.attributes);
                var label = q > 0 ? q + "p" : "Auto";
                // If AUDIO group referenced, merge audio URLs as additional streams
                var audioUri = v.attributes.AUDIO && info.audioGroups[v.attributes.AUDIO] ? info.audioGroups[v.attributes.AUDIO][0].uri : null;
                // Clone headers for this variant
                var h = {};
                for (var k in headers) { h[k] = headers[k]; }
                streams.push(new StreamResult({
                    url:       v.url,
                    quality:   q + (audioUri ? "" : ""),
                    source:    label,
                    headers:   h
                }));
                // If this variant has an audio group, also push audio-only tracks
                if (audioUri) {
                    var audioGroup = info.audioGroups[v.attributes.AUDIO];
                    for (var ai = 0; ai < audioGroup.length; ai++) {
                        var ah = {}; for (var ak in headers) { ah[ak] = headers[ak]; }
                        streams.push(new StreamResult({
                            url:       audioGroup[ai].uri,
                            quality:   0,
                            source:    "Audio (" + audioGroup[ai].name + ")",
                            headers:   ah
                        }));
                    }
                }
            }
            return streams;
        } catch (_) { return null; }
    }

    function b64ToBytes(b64) {
        var bin = atob(b64);
        var b = new Uint8Array(bin.length);
        for (var i = 0; i < bin.length; i++) b[i] = bin.charCodeAt(i);
        return b;
    }

    // ============================================================
    // HTTP
    // ============================================================
    function normRes(res) {
        if (typeof res === "string") return { status: 200, body: res };
        return {
            status: res && typeof res.status !== "undefined" ? res.status : 200,
            body: String(res && (res.body || res.text || "") || "")
        };
    }

    function apiGet(path) {
        return http_get(BASE_URL + "/" + path, HEADERS).then(normRes);
    }

    // ============================================================
    // AES-256-GCM + PBKDF2 — dual-path (WebCrypto / Node)
    // Matches IStreamFlareParser.kt exactly
    // ============================================================
    function deriveKeyNode() {
        if (typeof Buffer === "undefined" || typeof __crypto__ === "undefined" || !__crypto__.pbkdf2Sync) return null;
        return __crypto__.pbkdf2Sync(Buffer.from(SECRET_KEY, "utf8"), SALT, 10000, 32, "sha256");
    }

    function decryptGcmNode(encB64) {
        try {
            var k = deriveKeyNode();
            if (!k) return "";
            var e = Buffer.from(encB64, "base64");
            var d = __crypto__.createDecipheriv("aes-256-gcm", k, e.subarray(0, 12));
            d.setAuthTag(e.subarray(12, 28));
            return Buffer.concat([d.update(e.subarray(28)), d.final()]).toString("utf8");
        } catch (_) { return ""; }
    }

    async function deriveKeyWeb() {
        if (!globalThis.crypto || !globalThis.crypto.subtle || typeof globalThis.crypto.subtle.importKey !== "function") return null;
        var km = await globalThis.crypto.subtle.importKey("raw", s2b(SECRET_KEY), { name: "PBKDF2" }, false, ["deriveBits"]);
        return new Uint8Array(await globalThis.crypto.subtle.deriveBits({ name: "PBKDF2", salt: s2b(SALT), iterations: 10000, hash: "SHA-256" }, km, 256));
    }

    async function decryptGcmWeb(encB64, k) {
        var enc = b64ToBytes(encB64);
        var ak = await globalThis.crypto.subtle.importKey("raw", k, { name: "AES-GCM" }, false, ["decrypt"]);
        // Kotlin: iv[0..12), tag[12..28), ciphertext[28..)
        var ct = enc.slice(28);
        var tag = enc.slice(12, 28);
        var combined = new Uint8Array(ct.length + 16);
        combined.set(ct, 0); combined.set(tag, ct.length);
        return ut8(new Uint8Array(await globalThis.crypto.subtle.decrypt({ name: "AES-GCM", iv: enc.slice(0, 12), tagLength: 128 }, ak, combined)));
    }

    // Kotlin: decryptPayload → getDecodedJson
    async function decryptBody(body) {
        var t = trim(body);
        if (!t) return null;
        var j;
        try { j = JSON.parse(t); } catch (_) { return t; }
        if (j && j.encrypted && j.data) {
            var dec = "";
            try { var wk = await deriveKeyWeb(); if (wk) dec = await decryptGcmWeb(j.data, wk); } catch (_) {}
            if (!dec) dec = decryptGcmNode(j.data);
            if (dec) { try { return JSON.parse(dec); } catch (_) { return dec; } }
        }
        // Kotlin: parsedElement["data"] ?: parsedElement
        if (j && j.data && typeof j.data === "object" && !Array.isArray(j.data)) return j.data;
        if (j && typeof j.data === "string" && j.encrypted === false) return j.data;
        return j;
    }

    // Kotlin: getDecodedJson(url) → fetch + decrypt
    async function getDecodedJson(path) {
        var resp = await apiGet(path);
        if (!resp || !resp.body) return null;
        return await decryptBody(resp.body);
    }

    // ============================================================
    // HOME / SEARCH — buildItem matches HomeRes.toSearchResult()
    // ============================================================
    function buildItem(item) {
        var poster = item.poster || item.banner || "";
        var ct = parseInt(item.content_type || "0", 10);
        // Kotlin: ALL items get TvType.Movie — we differentiate for UI
        var kind = ct === 3 ? "livestream" : (ct === 1 ? "movie" : "series");

        // Kotlin: LoadDataObject(id, tmdbId, contentType, url) — exactly this shape
        var payload = JSON.stringify({
            id:          String(item.id || ""),
            tmdbId:      String(item.TMDB_ID || ""),
            contentType: String(item.content_type || "0"),
            url:         String(item.url || "")
        });

        // Kotlin: quality = custom_tag?.custom_tags_name?.substringBefore("+")
        var quality = "";
        if (item.custom_tag && item.custom_tag.custom_tags_name) {
            quality = String(item.custom_tag.custom_tags_name).split("+")[0].trim();
        }

        return new MultimediaItem({
            title:      item.name || "Untitled",
            url:        payload,
            posterUrl:  poster,
            type:       kind,
            description: cleanDesc(trim(item.description)),
            quality:    quality
        });
    }

    // ============================================================
    // STREAM HELPERS — matches IStreamFlare.kt loadLinks()
    // ============================================================
    function mapStreamType(apiType) {
        // Kotlin: ExtractorLinkType (DASH, M3U8, INFER_TYPE)
        // SkyStream: "hls" for HLS, "default" for direct/Dash
        var t = trim(apiType).toLowerCase();
        if (t === "m3u8" || t === "hls") return "hls";
        return "default"; // DASH and other types
    }

    // Kotlin: Istreamcdn resolveCdnRedirect() — follow 302 on PHP extractor
    // Returns Promise<string|null> — resolved URL or null
    function tryResolvePhpRedirect(phpUrl, referer) {
        // Use http_get; if response has status 3xx, return Location
        return http_get(phpUrl, {
            "User-Agent":      CDN_UA,
            "Referer":         referer,
            "Accept-Encoding": "gzip"
        }).then(function(resp) {
            var r = normRes(resp);
            // Kotlin: if (code in 300..399) return Location
            if (r.status >= 300 && r.status < 400) {
                var loc = (resp && resp.headers && resp.headers.location) || "";
                if (loc && (loc.indexOf("http") === 0 || loc.indexOf("https") === 0)) return loc;
                // Relative → prepend host
                if (loc) return referer + (loc.indexOf("/") === 0 ? "" : "/") + loc;
            }
            return null;
        }).catch(function() { return null; });
    }

    function buildStream(link) {
        var raw = trim(link.url || "");
        if (!raw) return null;

        var q    = trim(link.quality || "");
        var n    = trim(link.name    || "IStreamFlare");
        var apiT = trim(link.type    || "");

        // Kotlin loadLinks logic:
        //   1) x7flix → M3U8 + referer = url
        //   2) .php?id= → loadExtractor (redirect follow)
        //   3) else → INFER_TYPE

        if (raw.indexOf("x7flix") >= 0) {
            // x7flix: always M3U8, referer = the URL itself
            return new StreamResult({
                url:     raw,
                quality: q,
                headers: { "User-Agent": CDN_UA, "Referer": raw }
            });
        }

        if (raw.indexOf(".php?id=") >= 0) {
            // PHP extractor URL — Kotlin loadExtractor resolves redirect
            // For JS: attempt redirect follow, fall back to raw URL with headers
            // This is async — handled in loadStreams
            return null; // defer to loadStreams PHP extractor handler
        }

        // Default: infer type from extension or use API type
        var t = "default";
        if (raw.indexOf(".m3u8") >= 0 || apiT.toLowerCase() === "m3u8" || apiT.toLowerCase() === "hls") t = "hls";
        else if (raw.indexOf(".mp4") >= 0) t = "default";

        return new StreamResult({
            url:      raw,
            quality:  q,
            headers:  { "User-Agent": USER_AGENT }
        });
    }

    // ============================================================
    // getHome — matches Kotlin getMainPage()
    // ============================================================
    async function getHome(cb) {
        try {
            var sections = {};
            var proms = [];

            for (var i = 0; i < HOME_ENDPOINTS.length; i++) {
                var ep    = HOME_ENDPOINTS[i];
                var path  = ep[0];
                var label = ep[1];

                proms.push(
                    (async function(p, lbl) {
                        try {
                            var data = await getDecodedJson(p);
                            if (!data) return;
                            var items = Array.isArray(data) ? data : (data.data && Array.isArray(data.data) ? data.data : []);
                            if (!items.length) return;
                            var out = [];
                            for (var j = 0; j < items.length; j++) {
                                var mi = buildItem(items[j]);
                                if (mi) out.push(mi);
                            }
                            if (out.length) sections[lbl] = out;
                        } catch (_) {}
                    })(path, label)
                );
            }

            await Promise.all(proms);
            cb({ success: true, data: sections });
        } catch (e) {
            cb({ success: false, errorCode: "ISTREAMFLARE_HOME_FAILED", message: String(e && e.message || e) });
        }
    }

    // ============================================================
    // search — matches Kotlin search()
    // ============================================================
    async function search(query, cb) {
        try {
            var q = encodeURIComponent(trim(query));
            var data = await getDecodedJson("android/searchContent/" + q + "/1");
            var items = Array.isArray(data) ? data : [];
            var out = [];
            for (var i = 0; i < items.length; i++) {
                var mi = buildItem(items[i]);
                if (mi) out.push(mi);
            }
            cb({ success: true, data: out });
        } catch (e) {
            cb({ success: false, errorCode: "ISTREAMFLARE_SEARCH_FAILED", message: String(e && e.message || e) });
        }
    }

    // ============================================================
    // load — matches Kotlin load()
    // ============================================================
    async function load(url, cb) {
        try {
            var ld;
            try { ld = JSON.parse(url); } catch (_) {
                return cb({ success: false, errorCode: "INVALID_URL", message: "Bad load payload" });
            }

            var id        = trim(ld.id || "");
            var ct        = parseInt(ld.contentType || "0", 10);
            var directUrl = trim(ld.url || "");

            // --- Live TV (Kotlin: newLiveStreamLoadResponse) ---
            if (ct === 3 && directUrl) {
                return cb({
                    success: true,
                    data: new MultimediaItem({
                        title: "Live TV",
                        url:   directUrl,
                        type:  "livestream",
                        episodes: [new Episode({ name: "Live", season: 1, episode: 1, url: directUrl })]
                    })
                });
            }

            var isMovie = ct === 1;
            var typeStr = isMovie ? "movie" : "series";
            var endpoint = isMovie ? "getMovieDetails" : "getWebSeriesDetails";

            // Kotlin: getDecodedJson("$mainUrl/android/$endpoint/${res.id}")
            var rawJson = await getDecodedJson("android/" + endpoint + "/" + id);
            if (!rawJson) return cb({ success: false, errorCode: "EMPTY", message: "No details" });

            // Kotlin: parsedElement["data"] ?: parsedElement
            var dd;
            try {
                var parsed = JSON.parse(rawJson);
                dd = parsed.data && typeof parsed.data === "object" ? parsed.data : parsed;
            } catch (_) {
                dd = rawJson;
            }

            var title = dd.name || "Untitled";
            var poster = dd.poster || dd.banner || "";
            var desc = cleanDesc(dd.description || "");
            var genres = dd.genres || "";
            var releaseDate = dd.release_date || "";
            var year = releaseDate ? parseInt(releaseDate.substring(0, 4), 10) || undefined : undefined;
            var runtimeStr = dd.runtime || "";
            var duration;
            if (runtimeStr) {
                var m = runtimeStr.match(/(\d+)\s*min/i);
                if (m) duration = parseInt(m[1], 10);
            }

            var tags = [];
            if (genres) {
                tags = genres.split(",").map(function(g) { return trim(g); }).filter(Boolean);
            }

            // ---- Series: seasons + episodes (Kotlin: episodesList) ----
            var episodes = [];
            if (!isMovie) {
                var seasData = await getDecodedJson("android/getSeasons/" + id);
                var seasList = Array.isArray(seasData) ? seasData : [];
                for (var s = 0; s < seasList.length; s++) {
                    var season = seasList[s];
                    if (parseInt(season.status || "0", 10) === 0) continue;
                    var sNum = 1;
                    var sn = String(season.Session_Name || "").match(/(\d+)/);
                    if (sn) sNum = parseInt(sn[1], 10);
                    var sid = trim(season.id || "");
                    if (!sid) continue;

                    var epData = await getDecodedJson("android/getEpisodes/" + sid + "/0");
                    var epList = Array.isArray(epData) ? epData : [];
                    for (var e = 0; e < epList.length; e++) {
                        var ep = epList[e];
                        var epUrl = trim(ep.url || "");
                        if (!epUrl) continue;
                        var epNum = parseInt(ep.episoade_order || "0", 10);
                        if (!epNum) continue;

                        // Kotlin episode URL logic:
                        //   if url contains ".php?id=" || startsWith("http") → direct pass
                        //   else → build play-links endpoint from episode.id
                        var episodeHref;
                        if (epUrl.indexOf(".php?id=") >= 0 || epUrl.indexOf("http") === 0) {
                            episodeHref = epUrl; // direct pass-through
                        } else {
                            episodeHref = BASE_URL + "/android/getMoviePlayLinks/" + trim(ep.id || "") + "/0";
                        }

                        episodes.push(new Episode({
                            name:        trim(ep.Episoade_Name) || "Episode " + epNum,
                            season:      sNum,
                            episode:     epNum,
                            url:         episodeHref,
                            posterUrl:   trim(ep.episoade_image) || poster,
                            description: cleanDesc(trim(ep.episoade_description)) || "",
                        }));
                    }
                }
            }

            // Kotlin: href = "$mainUrl/android/getMoviePlayLinks/${res.id}/0"
            var href = isMovie ? BASE_URL + "/android/getMoviePlayLinks/" + id + "/0" : "";

            cb({
                success: true,
                data: new MultimediaItem({
                    title:       title,
                    url:         href,
                    posterUrl:   poster,
                    bannerUrl:   dd.banner || poster,
                    type:        typeStr,
                    description: desc,
                    year:        year,
                    duration:    duration,
                    tags:        tags,
                    episodes:    episodes
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "ISTREAMFLARE_LOAD_FAILED", message: String(e && e.message || e) });
        }
    }

    // ============================================================
    // loadStreams — matches Kotlin loadLinks()
    // ============================================================
    async function loadStreams(url, cb) {
        try {
            var streams = [];

            // ── Direct PHP/Live extractor URL (not from BASE_URL) ──────────
            if (url.indexOf(BASE_URL) !== 0) {
                // Kotlin: handle .php?id= → loadExtractor (redirect follow)
                // Kotlin: handle x7flix → M3U8
                if (url.indexOf("x7flix") >= 0) {
                    // Try to expand HLS master playlist into multi-quality streams
                    var expanded = await expandHlsVariants(url, { "User-Agent": CDN_UA, "Referer": url });
                    if (expanded) {
                        streams = streams.concat(expanded);
                    } else {
                        streams.push(new StreamResult({
                            url:     url,
                            quality: "",
                            headers: { "User-Agent": CDN_UA, "Referer": url }
                        }));
                    }
                    return cb({ success: true, data: streams });
                }

                if (url.indexOf(".php?id=") >= 0) {
                    // Kotlin resolves via Istreamcdn.getUrl → follow 302 redirect
                    // Try redirect follow; if fails, return PHP URL with headers
                    var host = url.indexOf("//") >= 0 ? url.split("/").slice(0, 3).join("/") : "";
                    var resolved = await tryResolvePhpRedirect(url, host);
                    if (resolved) {
                        var t = "default";
                        if (resolved.indexOf(".m3u8") >= 0) t = "hls";
                        else if (resolved.indexOf(".mpd") >= 0) t = "default";
                        streams.push(new StreamResult({
                            url:       resolved,
                            quality:   "",
                            headers:   { "User-Agent": CDN_UA, "Referer": host }
                        }));
                    } else {
                        // Pass PHP URL with browser UA + host referer
                        streams.push(new StreamResult({
                            url:       url,
                            quality:   "",
                            headers:   { "User-Agent": CDN_UA, "Referer": host || "https://istreamflare.in/" }
                        }));
                    }
                    return cb({ success: true, data: streams });
                }

                // Direct HTTP URL → infer type
                var t = "default";
                if (url.indexOf(".m3u8") >= 0) t = "hls";
                streams.push(new StreamResult({
                    url:       url,
                    quality:   "",
                    headers:   { "User-Agent": USER_AGENT }
                }));
                return cb({ success: true, data: streams });
            }

            // ── Movie play links from API ─────────────────────────────────
            var path = url.substring(BASE_URL.length + 1);
            var data = await getDecodedJson(path);
            var links = Array.isArray(data) ? data : [];

            // First pass: collect non-PHP streams immediately
            var phpLinks = [];
            for (var i = 0; i < links.length; i++) {
                var s = buildStream(links[i]);
                if (s) {
                    streams.push(s);
                } else if (links[i].url && links[i].url.indexOf(".php?id=") >= 0) {
                    phpLinks.push(links[i]);
                }
            }

            // Second pass: resolve PHP extractor URLs with redirect following
            for (var j = 0; j < phpLinks.length; j++) {
                var link = phpLinks[j];
                var raw  = trim(link.url);
                var q    = trim(link.quality || "");
                var n    = trim(link.name    || "IStreamFlare");
                var host = raw.indexOf("//") >= 0 ? raw.split("/").slice(0, 3).join("/") : "";

                var resolved = await tryResolvePhpRedirect(raw, host);
                if (resolved) {
                    var t = "default";
                    if (resolved.indexOf(".m3u8") >= 0) t = "hls";
                    else if (resolved.indexOf(".mpd") >= 0) t = "default";
                    streams.push(new StreamResult({
                        url:       resolved,
                        quality:   q,
                        headers:   { "User-Agent": CDN_UA, "Referer": host }
                    }));
                } else {
                    // Return PHP URL with proper headers
                    streams.push(new StreamResult({
                        url:       raw,
                        quality:   q,
                        headers:   { "User-Agent": CDN_UA, "Referer": host || "https://istreamflare.in/" }
                    }));
                }
            }

            // Third pass: expand x7flix HLS master playlists into multi-quality streams
            for (var x = 0; x < streams.length; x++) {
                var sx = streams[x];
                if (sx && sx.url && sx.url.indexOf("x7flix") >= 0) {
                    var expanded = await expandHlsVariants(sx.url, sx.headers || { "User-Agent": CDN_UA, "Referer": sx.url });
                    if (expanded && expanded.length > 0) {
                        // Replace single stream with multi-quality variants
                        streams.splice.apply(streams, [x, 1].concat(expanded));
                        x += expanded.length - 1;
                    }
                }
            }

            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "ISTREAMFLARE_STREAMS_FAILED", message: String(e && e.message || e) });
        }
    }

    // ============================================================
    // EXPOSE
    // ============================================================
    globalThis.getHome      = getHome;
    globalThis.search       = search;
    globalThis.load         = load;
    globalThis.loadStreams  = loadStreams;

})();
