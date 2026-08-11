(function() {
    // ========== GA Tracker ==========
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
        init: function() { this.clientId = this.generateUuid(); },
        generateUuid: function() {
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
        init: function() { this.clientId = SessionTracker.clientId; },
        logEvent: function(eventName, parameters) {
            if (!this.measurementId || !this.apiSecret) return;
            this.queue.push({ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) });
            this.flushQueue();
        },
        flushQueue: function() {
            if (this.queue.length === 0) return;
            var events = this.queue.splice(0);
            try {
                http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
            } catch (e) { /* silently skip */ }
        }
    };
    Analytics.init();

    // ========== Config ==========
    var BASE_URL = typeof manifest !== "undefined" && manifest && manifest.baseUrl ? manifest.baseUrl : "https://anikage.cc";
    var PROXY_URL = "https://gg.akage.lol";

    var HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
        "Referer": BASE_URL + "/"
    };

    // ========== Utility Functions ==========
    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function stripHtml(str) {
        return String(str || "").replace(/<[^>]+>/g, "").trim();
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            try {
                var text = String(value || "").replace(/^'+|'+$/g, "").replace(/^"+|"+$/g, "");
                return JSON.parse(text);
            } catch (_) {
                return fallback !== undefined ? fallback : {};
            }
        }
    }

    function uniqueBy(list, keyFn) {
        var out = [], seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var key = keyFn(list[i]);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(list[i]);
        }
        return out;
    }

    function getQualityFromName(quality) {
        if (!quality) return 0;
        var q = String(quality).toLowerCase().replace(/-/g, ' ');
        // Direct resolution matches (1080p, 720p, 480p, 360p, 4k)
        var numMatch = q.match(/(\d+)/);
        if (numMatch) {
            var n = parseInt(numMatch[1], 10);
            if (n >= 2160) return 2160;
            if (n >= 1080) return 1080;
            if (n >= 720) return 720;
            if (n >= 480) return 480;
            if (n >= 360) return 360;
        }
        // Keyword-based detection
        if (q.indexOf('4k') !== -1 || q.indexOf('2160') !== -1) return 2160;
        if (q.indexOf('uhd') !== -1) return 2160;
        if (q.indexOf('fhd') !== -1 || q.indexOf('full hd') !== -1) return 1080;
        if (q.indexOf('hd') !== -1) return 720;  // "HD-x", "HD" → 720p
        if (q.indexOf('sd') !== -1) return 480;
        // Ambiguous but commonly high-bitrate — assume 1080
        if (q.indexOf('hls') !== -1 || q.indexOf('m3u8') !== -1) return 1080;
        if (q.indexOf('auto') !== -1) return 1080;
        if (q.indexOf('mp4') !== -1) return 1080;
        return 0;
    }

    // ========== HLS Playlist Parser (CloudStream-compatible) ==========
    // Parses a variant m3u8 playlist and returns an array of {url, height, bandwidth}
    // resolution variants. Returns null if content isn't a valid HLS variant playlist.

    function resolveUrl(base, relative) {
        if (!relative) return base;
        if (relative.indexOf("http") === 0) return relative;
        if (relative.indexOf("//") === 0) return "https:" + relative;
        if (relative.indexOf("/") === 0) {
            // Absolute path — resolve against origin (e.g. prox.anikage.cc)
            var protoEnd = base.indexOf("://") + 3;
            var hostEnd = base.indexOf("/", protoEnd);
            if (hostEnd === -1) hostEnd = base.length;
            return base.slice(0, hostEnd) + relative;
        }
        // Relative path — resolve against directory of base URL
        var slashIdx = base.lastIndexOf("/");
        return (slashIdx > 8 ? base.slice(0, slashIdx + 1) : base + "/") + relative;
    }

    function parseHlsVariants(m3u8Content, baseUrl) {
        if (!m3u8Content || m3u8Content.indexOf("#EXTM3U") === -1) return null;
        var variants = [];
        var lines = m3u8Content.split("\n");
        var currentInf = null;
        var hasStreamInf = false;

        for (var i = 0; i < lines.length; i++) {
            var line = lines[i].trim();

            if (line.indexOf("#EXT-X-STREAM-INF") === 0) {
                hasStreamInf = true;
                var resMatch = line.match(/RESOLUTION=(\d+)x(\d+)/);
                var bwMatch = line.match(/[^-]BANDWIDTH=(\d+)\b/);
                currentInf = {
                    height: resMatch ? parseInt(resMatch[2], 10) : 0,
                    width: resMatch ? parseInt(resMatch[1], 10) : 0,
                    bandwidth: bwMatch ? parseInt(bwMatch[1], 10) : 0
                };
            } else if (line.indexOf("#") === 0 || line.length === 0) {
                continue;
            } else if (currentInf) {
                // Variant URL follows #EXT-X-STREAM-INF
                var vUrl = line;
                if (vUrl.indexOf("http") !== 0) vUrl = resolveUrl(baseUrl, vUrl);

                // Generate quality label from resolution
                var label = "";
                if (currentInf.height >= 2160) label = "4K";
                else if (currentInf.height >= 1080) label = "1080p";
                else if (currentInf.height >= 720) label = "720p";
                else if (currentInf.height >= 480) label = "480p";
                else if (currentInf.height >= 360) label = "360p";
                else label = currentInf.height + "p";

                variants.push({
                    url: vUrl,
                    height: currentInf.height,
                    bandwidth: currentInf.bandwidth,
                    label: label
                });
                currentInf = null;
            }
        }

        // Sort by height descending (best first)
        variants.sort(function(a, b) { return b.height - a.height; });
        return variants.length > 0 && hasStreamInf ? variants : null;
    }

    function getStatusFromString(status) {
        if (status === "FINISHED") return "completed";
        if (status === "RELEASING") return "ongoing";
        return null;
    }

    function getTvType(format, type) {
        var ft = String(format || "").toUpperCase();
        if (ft === "MOVIE" || ft === "SPECIAL") return "movie";
        if (ft === "OVA" || ft === "ONA") return "anime";
        return "series";
    }

    async function apiGet(url) {
        try {
            var res = await http_get(url, HEADERS);
            return parseJsonSafe(res && (res.body || res.text), {});
        } catch (_) {
            return {};
        }
    }

    // ========== Parallel HTTP (Dart-native concurrency) ==========
    function responseStatus(res) {
        if (!res) return 0;
        if (typeof res.status === "number") return res.status;
        if (typeof res.statusCode === "number") return res.statusCode;
        return 0;
    }

    async function httpParallelGet(requests) {
        var items = Array.isArray(requests) ? requests.filter(function(item) { return item && item.url; }) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var parallelRes = await http_parallel(items.map(function(item) {
                    return {
                        method: "GET",
                        url: item.url,
                        headers: item.headers || HEADERS
                    };
                }));
                return items.map(function(item, index) {
                    var res = parallelRes && parallelRes[index];
                    return {
                        status: responseStatus(res) || 200,
                        body: String(res && (res.body || res.text || "") || ""),
                        headers: res && res.headers || {},
                        url: res && (res.url || res.finalUrl) || item.url
                    };
                });
            } catch (_) { }
        }
        return await Promise.all(items.map(function(item) {
            return http_get(item.url, item.headers || HEADERS).then(function(res) {
                return {
                    status: responseStatus(res) || 200,
                    body: String(res && (res.body || "") || ""),
                    headers: res && res.headers || {},
                    url: res && (res.url || res.finalUrl) || item.url
                };
            }).catch(function() {
                return { status: 599, body: "{}", headers: {}, url: item.url };
            });
        }));
    }

    function parseResponseBody(res) {
        if (res && res.body) {
            try { return JSON.parse(res.body); } catch (_) { return {}; }
        }
        return {};
    }

    // ========== Runtime Functions ==========
    async function getHome(cb) {
        try {
            // Fetch home data from SvelteKit SSR __data.json
            var res = await http_get(BASE_URL + "/__data.json", HEADERS);
            var body = res && (res.body || res.text || "");
            if (!body) {
                cb({ success: false, errorCode: "GET_HOME_ERROR", message: "Empty response from __data.json" });
                return;
            }
            var parsed = parseJsonSafe(body);
            if (!parsed || !parsed.nodes || !parsed.nodes[1] || !parsed.nodes[1].data) {
                cb({ success: false, errorCode: "GET_HOME_ERROR", message: "Invalid __data.json format" });
                return;
            }

            var arr = parsed.nodes[1].data;
            var mapping = arr[0]; // { trendinganime: 1, seasonalanime: 222, ... }

            // Resolve an anime from the compact SvelteKit array by its index
            function resolveAnime(index) {
                var obj = arr[index];
                if (!obj || typeof obj !== 'object') return null;
                var slug = arr[obj.slug] || "";
                if (!slug) return null;
                var titleObj = arr[obj.title] || {};
                var title = arr[titleObj.english || titleObj.romaji || titleObj.userPreferred] || "Unknown";
                var coverObj = arr[obj.coverImage] || {};
                var poster = arr[coverObj.extraLarge] || arr[coverObj.large] || "";
                var format = arr[obj.format] || "";
                var score = arr[obj.averageScore] || 0;
                var year = arr[obj.year] || 0;
                return new MultimediaItem({
                    title: title,
                    url: BASE_URL + "/api/media/anime/" + slug,
                    posterUrl: poster,
                    type: getTvType(format),
                    year: year,
                    score: score ? score / 10 : 0,
                    headers: HEADERS
                });
            }

            // Resolve a spotlight item (has extra fields: banner, logo, description, genres)
            function resolveSpotlight(index) {
                var obj = arr[index];
                if (!obj || typeof obj !== 'object') return null;
                var slug = arr[obj.slug] || "";
                if (!slug) return null;
                var titleObj = arr[obj.title] || {};
                var title = arr[titleObj.english || titleObj.romaji || titleObj.userPreferred] || "Unknown";
                var coverObj = arr[obj.coverImage] || {};
                var poster = arr[coverObj.extraLarge] || arr[coverObj.large] || "";
                var format = arr[obj.format] || "";
                var score = arr[obj.averageScore] || 0;
                var banner = arr[obj.bannerImage] || poster;
                var logo = arr[obj.clearLogo] || "";
                var desc = obj.description && arr[obj.description] ? stripHtml(arr[obj.description]) : "";
                var genreIndices = arr[obj.genres] || [];
                var genres = [];
                for (var gi = 0; gi < genreIndices.length; gi++) {
                    var g = arr[genreIndices[gi]];
                    if (g) genres.push(g);
                }
                return new MultimediaItem({
                    title: title,
                    url: BASE_URL + "/api/media/anime/" + slug,
                    posterUrl: poster,
                    bannerUrl: banner,
                    logoUrl: logo,
                    type: getTvType(format),
                    year: arr[obj.year] || 0,
                    score: score ? score / 10 : 0,
                    tags: genres,
                    description: desc,
                    headers: HEADERS
                });
            }

            // Resolve an array of anime indices into MultimediaItems
            function resolveSection(sectionName) {
                var idx = mapping[sectionName];
                if (idx === undefined) return [];
                var indices = arr[idx];
                if (!Array.isArray(indices)) return [];
                var items = [];
                for (var i = 0; i < indices.length; i++) {
                    var item = resolveAnime(indices[i]);
                    if (item) items.push(item);
                }
                return items;
            }

            var pageData = {};
            pageData["Featured"] = resolveSection("trendinganime");
            pageData["Popular"] = resolveSection("seasonalanime");
            pageData["Upcoming"] = resolveSection("upcominganime");
            pageData["Popular Movies"] = resolveSection("popularmovies");
            pageData["Favorites"] = resolveSection("favoriteanime");

            // Build Featured section from spotlight items (with banners/logos/descriptions)
            var spotlightIdx = mapping["spotlightItems"];
            if (spotlightIdx !== undefined && Array.isArray(arr[spotlightIdx])) {
                var spotlightIndices = arr[spotlightIdx];
                var spotlightItems = [];
                for (var si = 0; si < spotlightIndices.length; si++) {
                    var slItem = resolveSpotlight(spotlightIndices[si]);
                    if (slItem) spotlightItems.push(slItem);
                }
                if (spotlightItems.length > 0) {
                    pageData["Trending"] = spotlightItems;
                }
            }

            Analytics.logEvent('anikage_home', {});
            cb({ success: true, data: pageData });
        } catch (e) {
            cb({ success: false, errorCode: "GET_HOME_ERROR", message: e.stack });
        }
    }

    async function search(query, cb) {
        try {
            // AniList GraphQL search — anikage has no server-side search REST endpoint
            var anilistQuery = JSON.stringify({
                query: "query ($search: String, $page: Int, $perPage: Int) { Page(page: $page, perPage: $perPage) { media(search: $search, type: ANIME, sort: SEARCH_MATCH) { id idMal title { romaji english native } coverImage { large extraLarge } format status season averageScore episodes year duration genres isAdult } } }",
                variables: { search: query, page: 1, perPage: 25 }
            });

            var res = await http_post(
                "https://graphql.anilist.co",
                { "Content-Type": "application/json", "Accept": "application/json", "User-Agent": HEADERS["User-Agent"] },
                anilistQuery
            );

            var data = parseJsonSafe(res && (res.body || res.text), {});
            var mediaList = (data.data && data.data.Page && data.data.Page.media) || [];

            var results = [];
            for (var i = 0; i < mediaList.length; i++) {
                var m = mediaList[i];
                var title = (m.title && (m.title.english || m.title.romaji)) || "Unknown";
                var poster = m.coverImage ? (m.coverImage.extraLarge || m.coverImage.large || "") : "";
                results.push(new MultimediaItem({
                    title: title,
                    // Use anilistId — /api/media/anime/{id} works on anikage and load() resolves it
                    url: BASE_URL + "/api/media/anime/" + m.id,
                    posterUrl: poster,
                    type: getTvType(m.format),
                    year: m.year || 0,
                    score: m.averageScore ? m.averageScore / 10 : 0,
                    headers: HEADERS
                }));
            }

            Analytics.logEvent('anikage_search', { query: query });
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.stack });
        }
    }

    async function load(url, cb) {
        try {
            var slug = url.split("/").pop();

            // Fetch episodes and info in parallel (Dart-native http_parallel)
            var loadRequests = [
                { url: BASE_URL + "/api/media/anime/" + slug + "/episodes" },
                { url: BASE_URL + "/api/media/anime/" + slug }
            ];
            var loadResponses = await httpParallelGet(loadRequests);

            var episodesResponse = parseResponseBody(loadResponses[0]);
            var episodesData = episodesResponse.episodes || episodesResponse;
            var infoData = parseResponseBody(loadResponses[1]);
            var animeInfo = infoData.anime || {};

            if (!Array.isArray(episodesData)) episodesData = [];

            var title = (animeInfo.title && (animeInfo.title.english || animeInfo.title.romaji)) || "Unknown";
            var type = getTvType(animeInfo.format, animeInfo.type);

            var poster = "";
            if (animeInfo.coverImage) {
                poster = animeInfo.coverImage.extraLarge || animeInfo.coverImage.large || animeInfo.coverImage.medium || "";
            }

            var description = stripHtml(animeInfo.description || "");
            if (!description) {
                description = "Format: " + (animeInfo.format || "Unknown");
            }

            var status = getStatusFromString(animeInfo.status);
            var genres = animeInfo.genres || [];
            var year = animeInfo.year || 0;

            // Build episodes with single iteration (sub + dub together)
            var epList = Array.isArray(episodesData) ? episodesData : [];
            epList.sort(function(a, b) { return (a.number || 0) - (b.number || 0); });
            var allEpisodes = [];
            epList.forEach(function(ep) {
                var epTitle = String(ep.title || "") || "Episode " + ep.number;
                // Sub episode
                allEpisodes.push(new Episode({
                    name: epTitle,
                    url: BASE_URL + "/play/" + slug + "/" + ep.number,
                    season: 1,
                    episode: ep.number,
                    description: String(ep.description || ""),
                    posterUrl: ep.img || poster,
                    dubStatus: "sub",
                    headers: HEADERS
                }));
                // Dub episode
                allEpisodes.push(new Episode({
                    name: epTitle,
                    url: BASE_URL + "/play/" + slug + "/" + ep.number + "?dub=true",
                    season: 1,
                    episode: ep.number,
                    description: String(ep.description || ""),
                    posterUrl: ep.img || poster,
                    dubStatus: "dub",
                    headers: HEADERS
                }));
            });

            // Map characters to Actor objects
            var castList = (animeInfo.characters || []).map(function(c) {
                return {
                    name: c.name || "",
                    image: c.image || "",
                    role: c.role || ""
                };
            });

            // Map videos to Trailer objects
            var trailerList = (animeInfo.videos || []).map(function(v) {
                return {
                    title: v.title || "",
                    url: v.embedUrl || ""
                };
            });

            // Map recommendations to MultimediaItem objects
            var recList = (animeInfo.recommendations || []).map(function(r) {
                var recTitle = r.title && (r.title.english || r.title.romaji || "");
                return new MultimediaItem({
                    title: recTitle || "Unknown",
                    url: BASE_URL + "/api/media/anime/" + (r.slug || ""),
                    posterUrl: r.coverImage || "",
                    type: getTvType(r.format),
                    headers: HEADERS
                });
            });

            // Map nextAiring
            var nextAiringObj = null;
            if (animeInfo.nextAiringEpisode) {
                nextAiringObj = {
                    episode: animeInfo.nextAiringEpisode.episode || 0,
                    airingAt: animeInfo.nextAiringEpisode.airingAt || 0
                };
            }

            // Sync data with external IDs
            var syncDataObj = {};
            if (animeInfo.idMal) syncDataObj.mal = String(animeInfo.idMal);
            if (animeInfo.anilistId) syncDataObj.anilist = String(animeInfo.anilistId);

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: poster,
                type: type,
                bannerUrl: animeInfo.fanart || animeInfo.bannerImage || "",
                logoUrl: animeInfo.clearLogo || "",
                description: description,
                year: year,
                score: animeInfo.averageScore ? animeInfo.averageScore / 10 : 0,
                duration: animeInfo.duration || 0,
                status: status,
                tags: genres,
                contentRating: String(animeInfo.rating || ""),
                isAdult: animeInfo.isAdult || false,
                cast: castList,
                trailers: trailerList,
                recommendations: recList,
                nextAiring: nextAiringObj,
                syncData: syncDataObj,
                episodes: allEpisodes,
                headers: HEADERS
            });

            Analytics.logEvent('anikage_load', {});
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.stack });
        }
    }

    function parseEpisodeUrl(url) {
        var slug = "";
        var epNumber = 1;
        var isDub = false;
        try {
            var parts = String(url || "").split("/");
            var playIdx = -1;
            for (var i = 0; i < parts.length; i++) {
                if (parts[i] === "play") { playIdx = i; break; }
            }
            if (playIdx !== -1) {
                slug = parts[playIdx + 1] || "";
                epNumber = parseInt(parts[playIdx + 2], 10) || 1;
            }
            isDub = url.indexOf("dub=true") !== -1;
        } catch (_) { }
        return { slug: slug, epNumber: epNumber, isDub: isDub };
    }

    async function loadStreams(url, cb) {
        try {
            var epInfo = parseEpisodeUrl(url);
            var slug = epInfo.slug;
            var epNumber = epInfo.epNumber;
            var isDub = epInfo.isDub;

            var lang = isDub ? "dub" : "sub";

            // Fetch available servers
            var serversUrl = BASE_URL + "/api/media/anime/" + slug + "/episodes/" + epNumber + "/servers?lang=" + lang;
            var serversResponse = await apiGet(serversUrl);
            var serversData = serversResponse.servers || serversResponse;

            var providers = [];
            if (Array.isArray(serversData) && serversData.length > 0) {
                providers = serversData.filter(function(s) {
                    if (!s) return false;
                    if (Array.isArray(s.subTypes) && s.subTypes.length > 0) {
                        return s.subTypes.indexOf(lang) !== -1;
                    }
                    return true;
                }).map(function(s) { return s.id || s.providerId; });
            } else {
                // Real, live-verified server union on anikage.cc.
                // Per-anime server sets vary; filter according to dub vs sub availability.
                providers = lang === "dub" ? ["koto", "kiwi", "uwu", "neko", "wave"] : ["koto", "kiwi", "uwu", "neko", "dib", "wave", "megg"];
            }

            // === PARALLEL provider fetching via Dart-native http_parallel ===
            var sourceRequests = providers.map(function(provider) {
                return { url: BASE_URL + "/api/media/anime/" + slug + "/episodes/" + epNumber + "/sources?lang=" + lang + "&provider=" + provider };
            });
            var sourceResponses = await httpParallelGet(sourceRequests);

            // Phase 1: Collect all sources, defer m3u8 fetches to parallel batch
            var allStreams = [];
            var m3u8Batch = []; // { proxyUrl, baseName, subtitleTracks, quality }

            // Bottleneck #3 fix: precompute provider display names once
            var providerDisplayNames = providers.map(function(p) {
                return "Anikage " + p.charAt(0).toUpperCase() + p.slice(1);
            });

            for (var p = 0; p < providers.length; p++) {
                var providerBase = providerDisplayNames[p];
                var sourceData = parseResponseBody(sourceResponses[p]);
                var sources = sourceData.sources || [];
                var hasSubs = (sourceData.subtitles || []).length > 0;

                // Collect subtitle tracks from the API response
                var subtitleTracks = [];
                if (hasSubs) {
                    for (var t = 0; t < sourceData.subtitles.length; t++) {
                        var sub = sourceData.subtitles[t];
                        if (sub.file) {
                            subtitleTracks.push({
                                url: PROXY_URL + "/stream/" + sub.file,
                                label: sub.label || lang
                            });
                        }
                    }
                }

                for (var s = 0; s < sources.length; s++) {
                    var src = sources[s];
                    if (src.type === "embed") continue;

                    // Determine subType per-source: use src.type if available
                    var subType = "";
                    if (lang === "sub") {
                        if (src.type && (src.type === "hardsub" || src.type === "softsub")) {
                            subType = src.type.charAt(0).toUpperCase() + src.type.slice(1);
                        } else {
                            subType = hasSubs ? "Softsub" : "Hardsub";
                        }
                    }
                    // Bottleneck #3 fix: precomputed providerBase + conditional subType avoids trim()
                    var baseName = providerBase + (subType ? " " + subType : "");

                    var isM3u8 = src.isM3U8 === true;
                    var proxyUrl = PROXY_URL + (isM3u8 ? "/m3u8/" : "/stream/") + src.url;

                    if (isM3u8) {
                        // Bottleneck #1 fix: defer to parallel batch instead of serial await
                        m3u8Batch.push({
                            proxyUrl: proxyUrl,
                            baseName: baseName,
                            subtitleTracks: subtitleTracks,
                            quality: src.quality
                        });
                    } else {
                        // --- Single stream (direct) ---
                        var qualName = src.quality ? src.quality.charAt(0).toUpperCase() + src.quality.slice(1) : "";
                        var qualityNum = getQualityFromName(src.quality);
                        var qualitySuffix = qualityNum > 0 ? " " + qualityNum + "p" : (qualName ? " " + qualName : "");
                        var nameStr = baseName + qualitySuffix;

                        var stream = new StreamResult({
                            url: proxyUrl,
                            source: nameStr,
                            headers: HEADERS  // Bottleneck #2 fix: share reference, no copy
                        });
                        if (subtitleTracks.length > 0) {
                            stream.subtitles = subtitleTracks;
                        }
                        allStreams.push(stream);
                    }
                }
            }

            // Phase 2: Fetch all m3u8 playlists in parallel (Bottleneck #1 fix)
            if (m3u8Batch.length > 0) {
                var m3u8Requests = m3u8Batch.map(function(item) {
                    return { url: item.proxyUrl };
                });
                var m3u8Responses = await httpParallelGet(m3u8Requests);

                // Phase 3: Process each m3u8 result
                for (var m = 0; m < m3u8Batch.length; m++) {
                    var info = m3u8Batch[m];
                    var m3u8Res = m3u8Responses[m] || {};
                    var m3u8Body = m3u8Res.body || "";
                    var didPushVariants = false;

                    if (m3u8Body.indexOf("#EXTM3U") !== -1) {
                        try {
                            var variants = parseHlsVariants(m3u8Body, info.proxyUrl);

                            if (variants && variants.length > 1) {
                                for (var v = 0; v < variants.length; v++) {
                                    var stream = new StreamResult({
                                        url: variants[v].url,
                                        source: info.baseName + " " + variants[v].label,
                                        headers: HEADERS  // Bottleneck #2 fix: share reference
                                    });
                                    if (info.subtitleTracks.length > 0) {
                                        stream.subtitles = info.subtitleTracks;
                                    }
                                    allStreams.push(stream);
                                }
                                didPushVariants = true;
                            } else if (variants && variants.length === 1) {
                                var stream = new StreamResult({
                                    url: variants[0].url,
                                    source: info.baseName + " " + variants[0].label,
                                    headers: HEADERS  // Bottleneck #2 fix: share reference
                                });
                                if (info.subtitleTracks.length > 0) {
                                    stream.subtitles = info.subtitleTracks;
                                }
                                allStreams.push(stream);
                                didPushVariants = true;
                            }
                        } catch (_) {
                            // variant parsing failed — fall through to single-stream fallback
                        }
                    }

                    if (!didPushVariants) {
                        // Fallback to single stream (fetch failed, non-variant, or parse error)
                        var qualName = info.quality ? info.quality.charAt(0).toUpperCase() + info.quality.slice(1) : "";
                        var qualityNum = getQualityFromName(info.quality);
                        var qualitySuffix = qualityNum > 0 ? " " + qualityNum + "p" : (qualName ? " " + qualName : "");
                        var nameStr = info.baseName + qualitySuffix;

                        var stream = new StreamResult({
                            url: info.proxyUrl,
                            source: nameStr,
                            headers: HEADERS  // Bottleneck #2 fix: share reference
                        });
                        if (info.subtitleTracks.length > 0) {
                            stream.subtitles = info.subtitleTracks;
                        }
                        allStreams.push(stream);
                    }
                }
            }

            Analytics.logEvent('anikage_loadstreams', { slug: slug, ep: epNumber });
            cb({ success: true, data: allStreams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.stack });
        }
    }

    // ========== Exports ==========
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
