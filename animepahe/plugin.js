(function() {
    const MAIN_URL = (((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://animepahe.com") + "").replace(/\/+$/, "");
    const HEADERS = {
        "Cookie": "__ddg2_=1234567890",
        "Referer": MAIN_URL,
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
    };

    // TMDB API key (from reference)
    const TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    const TMDB_BASE    = "https://api.themoviedb.org/3";
    const TMDB_IMG     = "https://image.tmdb.org/t/p/w500";
    const CACHE_TTL    = 300000;
    var searchCache = {};
    var searchInflight = {};
    var kwikCache = {};
    var nextAiringCache = {};
    // Poster lookup:
    // AnimePahe's search API returns a proper "poster" cover image for each anime.
    // We search by title and take the first result's poster.
    // Falls back to TMDB direct if AnimePahe search returns nothing.
    async function getPoster(title) {
        if (!title) return null;

        // Source 1: AnimePahe search API — returns proper cover poster, not episode snapshot
        try {
            var apUrl = MAIN_URL + "/api?m=search&l=1&q=" + encodeURIComponent(title);
            var apRes = await http_get(apUrl, HEADERS);
            if (apRes && apRes.body) {
                var apData = JSON.parse(apRes.body);
                var hit = apData.data && apData.data[0];
                // poster field is the cover art (e.g. https://i.animepahe.ru/posters/...)
                // Only accept it if it is NOT a snapshot (snapshots contain "/snapshots/")
                if (hit && hit.poster && hit.poster.indexOf("/snapshots/") === -1) {
                    return hit.poster;
                }
            }
        } catch(e) { /* try next */ }

        // Source 2: TMDB direct search
        try {
            var tUrl = TMDB_BASE + "/search/tv?api_key=" + TMDB_API_KEY
                     + "&query=" + encodeURIComponent(title) + "&language=en-US";
            var tRes = await http_get(tUrl);
            if (tRes && tRes.body) {
                var tData = JSON.parse(tRes.body);
                var r = tData.results && tData.results[0];
                if (r && r.poster_path) return TMDB_IMG + r.poster_path;
            }
        } catch(e) { /* try next */ }

        return null;
    }

    // ─────────────────────────────────────────────
    // Data models
    // ─────────────────────────────────────────────

    function AiringData(json) {
        this.animeTitle   = json.anime_title;
        this.episode      = json.episode;
        this.snapshot     = json.snapshot;
        this.animeSession = json.anime_session;
        this.createdAt    = json.created_at;
    }

    function AiringResponse(json) {
        this.total = json.total;
        this.data  = (json.data || []).map(function(d) { return new AiringData(d); });
    }

    function SearchData(json) {
        this.id       = json.id;
        this.slug     = json.slug;
        this.title    = json.title;
        this.type     = json.type;
        this.episodes = json.episodes;
        this.status   = json.status;
        this.season   = json.season;
        this.year     = json.year;
        this.score    = json.score;
        this.poster   = json.poster;
        this.session  = json.session;
    }

    function SearchResponse(json) {
        this.total = json.total;
        this.data  = (json.data || []).map(function(d) { return new SearchData(d); });
    }

    function EpisodeData(json) {
        this.id        = json.id;
        this.animeId   = json.anime_id;
        this.episode   = json.episode;
        this.title     = json.title;
        this.snapshot  = json.snapshot;
        this.session   = json.session;
        this.filler    = json.filler;
        this.createdAt = json.created_at;
    }

    function EpisodeResponse(json) {
        this.total       = json.total;
        this.perPage     = json.per_page;
        this.currentPage = json.current_page;
        this.lastPage    = json.last_page;
        this.data        = (json.data || []).map(function(d) { return new EpisodeData(d); });
    }

    // ─────────────────────────────────────────────
    // Helpers
    // ─────────────────────────────────────────────

    function getType(typeStr) {
        if (!typeStr) return "anime";
        var t = typeStr.toLowerCase();
        if (t.indexOf("movie")   !== -1) return "movie";
        if (t.indexOf("ova")     !== -1) return "anime";
        if (t.indexOf("special") !== -1) return "anime";
        return "anime";
    }

    function decodeHtmlEntities(str) {
        return String(str || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ");
    }

    function stripTags(str) {
        return decodeHtmlEntities(String(str || "").replace(/<[^>]+>/g, " ").replace(/\s+/g, " ").trim());
    }

    function uniqueByUrl(items) {
        var seen = {};
        return (items || []).filter(function(item) {
            var key = item && item.url;
            if (!key || seen[key]) return false;
            seen[key] = true;
            return true;
        });
    }

    function cacheGet(map, key, ttl) {
        var entry = map[key];
        if (!entry) return null;
        if (Date.now() - entry.time > (ttl || CACHE_TTL)) {
            delete map[key];
            return null;
        }
        return entry.value;
    }

    function cacheSet(map, key, value) {
        map[key] = { value: value, time: Date.now() };
        return value;
    }

    function encodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof btoa === "function") return btoa(input);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "binary").toString("base64");
        } catch (_) {}
        return "";
    }

    function qualityFromText(value) {
        value = String(value || "");
        var match = value.match(/(\d{3,4})p/i);
        if (match) return parseInt(match[1], 10) || 0;
        if (/2160|4k|uhd/i.test(value)) return 2160;
        if (/1440|2k|qhd/i.test(value)) return 1440;
        if (/1080|fhd|full\s*hd/i.test(value)) return 1080;
        if (/720|hd/i.test(value)) return 720;
        if (/576/i.test(value)) return 576;
        if (/480|sd/i.test(value)) return 480;
        if (/360/i.test(value)) return 360;
        if (/240/i.test(value)) return 240;
        return 0;
    }

    function formatSourceName(base, quality) {
        return quality ? (base + " [" + quality + "p]") : base;
    }

    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: formatSourceName(source || "AnimePahe", quality || 0),
            quality: quality || 0,
            headers: headers || {}
        });
    }

    function isLikelyHls(url, body) {
        var text = String(body || "");
        var value = String(url || "");
        return /\.m3u8(?:$|\?)/i.test(value) || /^#EXTM3U/i.test(text);
    }

    function proxifyUrl(url, headers, referer, mirrorHosts) {
        var payload = {
            url: url,
            headers: headers || {},
            options: {
                referer: referer || "",
                mirrorHosts: mirrorHosts || []
            }
        };
        return "MAGIC_PROXY_v2" + encodeBase64String(JSON.stringify(payload));
    }

    function proxifyUrlV1(url) {
        return "MAGIC_PROXY_v1" + encodeBase64String(String(url || ""));
    }

    function buildMagicM3u8(body, playlistUrl) {
        var lines = String(body || "").split(/\r?\n/);
        var rewritten = [];
        for (var i = 0; i < lines.length; i++) {
            var line = String(lines[i] || "");
            var trimmed = line.trim();
            if (!trimmed) {
                rewritten.push(line);
                continue;
            }
            if (trimmed.charAt(0) === "#") {
                if (/^#EXT-X-KEY:/i.test(trimmed) && /URI="/i.test(trimmed)) {
                    rewritten.push(line.replace(/URI="([^"]+)"/i, function (_, uri) {
                        return 'URI="' + proxifyUrlV1(absoluteUrl(playlistUrl, uri)) + '"';
                    }));
                } else {
                    rewritten.push(line);
                }
                continue;
            }
            rewritten.push(proxifyUrlV1(absoluteUrl(playlistUrl, trimmed)));
        }
        return "magic_m3u8:" + encodeBase64String(rewritten.join("\n"));
    }

    async function buildMagicM3u8Url(url, headers) {
        try {
            var res = await http_get(url, headers || {});
            var body = res && (res.body || res.text || "") || "";
            if (!/#EXTM3U/i.test(body)) return proxifyUrlV1(url);
            return buildMagicM3u8(body, url);
        } catch (_) {
            return proxifyUrlV1(url);
        }
    }

    function buildPlayableStreamResult(url, source, headers, quality, opts) {
        var config = opts || {};
        var referer = config.referer || (headers && (headers.Referer || headers.referer)) || "";
        var mirrorHosts = config.mirrorHosts || [];
        if (!mirrorHosts.length) {
            try {
                mirrorHosts = [new URL(url).hostname];
            } catch (_) {
                mirrorHosts = [];
            }
        }
        if (config.forceProxy || isLikelyHls(url, config.body)) {
            return new StreamResult({
                url: proxifyUrl(url, headers, referer, mirrorHosts),
                source: source || "AnimePahe",
                quality: quality || 0,
                type: "hls",
                headers: {}
            });
        }
        var stream = new StreamResult({
            url: url,
            source: source || "AnimePahe",
            quality: quality || 0,
            referer: referer,
            headers: headers || {}
        });
        return stream;
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

    async function expandM3u8(url, source, headers, fallbackQuality) {
        var text = "";
        try {
            var res = await http_get(url, headers || {});
            text = res && (res.body || res.text || "") || "";
        } catch (_) {
            text = "";
        }

        if (!/#EXTM3U/i.test(text) || text.indexOf("#EXT-X-STREAM-INF") === -1) {
            return [buildStreamResult(url, source, headers, fallbackQuality || qualityFromText(url))];
        }

        var lines = text.split(/\r?\n/);
        var streams = [];
        var seen = {};
        for (var i = 0; i < lines.length; i++) {
            var line = String(lines[i] || "").trim();
            if (line.indexOf("#EXT-X-STREAM-INF") !== 0) continue;
            var nextLine = "";
            for (var j = i + 1; j < lines.length; j++) {
                var candidate = String(lines[j] || "").trim();
                if (candidate && candidate.charAt(0) !== "#") {
                    nextLine = candidate;
                    break;
                }
            }
            if (!nextLine) continue;
            var variantUrl = absoluteUrl(url, nextLine);
            if (!variantUrl || seen[variantUrl]) continue;
            seen[variantUrl] = true;
            var resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
            var quality = resMatch ? (parseInt(resMatch[1], 10) || 0) : 0;
            if (!quality) quality = qualityFromText(nextLine) || fallbackQuality || qualityFromText(url);
            streams.push(buildStreamResult(variantUrl, source, headers, quality));
        }

        if (!streams.length) {
            streams.push(buildStreamResult(url, source, headers, fallbackQuality || qualityFromText(url)));
        }

        return streams.sort(function(a, b) {
            return Number(b.quality || 0) - Number(a.quality || 0);
        });
    }

    async function postJson(url, payload, headers) {
        var body = JSON.stringify(payload || {});
        var mergedHeaders = Object.assign({
            "Content-Type": "application/json",
            "Accept": "application/json"
        }, headers || {});
        try {
            var res1 = await http_post(url, mergedHeaders, body);
            if (!res1 || !res1.body) throw new Error("Empty response");
            return JSON.parse(res1.body);
        } catch (_) {
            var res2 = await http_post(url, body, mergedHeaders);
            if (!res2 || !res2.body) throw new Error("Empty response");
            return JSON.parse(res2.body);
        }
    }

    function buildNextAiring(episode, season, unixTime) {
        if (!episode || !unixTime) return undefined;
        var payload = { episode: Number(episode), season: Number(season || 1), unixTime: Number(unixTime) };
        return typeof NextAiring === "function" ? new NextAiring(payload) : payload;
    }

    async function fetchNextAiring(params) {
        params = params || {};
        var cacheKey = params.anilistId ? ("al:" + params.anilistId)
            : params.malId ? ("mal:" + params.malId)
            : params.title ? ("title:" + String(params.title).toLowerCase())
            : "";
        if (!cacheKey) return undefined;
        if (Object.prototype.hasOwnProperty.call(nextAiringCache, cacheKey)) {
            return cacheGet(nextAiringCache, cacheKey, 1800000);
        }
        try {
            var variables = {};
            if (params.anilistId) variables.id = Number(params.anilistId);
            else if (params.malId) variables.idMal = Number(params.malId);
            else variables.search = String(params.title || "");
            var json = await postJson("https://graphql.anilist.co", {
                query: "query($id:Int,$idMal:Int,$search:String){Media(id:$id,idMal:$idMal,search:$search,type:ANIME){status nextAiringEpisode{episode airingAt}}}",
                variables: variables
            });
            var media = json && json.data && json.data.Media;
            var next = media && media.nextAiringEpisode;
            return cacheSet(nextAiringCache, cacheKey, buildNextAiring(next && next.episode, 1, next && next.airingAt) || null);
        } catch (_) {
            return cacheSet(nextAiringCache, cacheKey, null);
        }
    }

    async function fetchAniZipMeta(malId) {
        if (!malId) return null;
        try {
            var url = "https://api.ani.zip/mappings?mal_id=" + encodeURIComponent(malId);
            var res = await http_get(url, { "Accept": "application/json" });
            if (!res || !res.body) return null;
            return JSON.parse(res.body);
        } catch (e) {
            console.error("[AniZip] fetch error:", e.message);
            return null;
        }
    }

    function buildAniZipEpisodeMap(aniZipMeta) {
        return aniZipMeta && aniZipMeta.episodes ? aniZipMeta.episodes : null;
    }

    function getAniZipEpisodeMeta(metaEpisodes, episodeNumber) {
        if (!metaEpisodes || episodeNumber == null) return null;
        return metaEpisodes[String(episodeNumber)] || null;
    }

    function scoreFromAniZip(metaEpisode) {
        if (!metaEpisode || !metaEpisode.rating) return null;
        var score = parseFloat(metaEpisode.rating);
        return isNaN(score) ? null : score;
    }

    function getAniZipFanart(aniZipMeta) {
        var images = aniZipMeta && aniZipMeta.images;
        if (!images || !images.length) return null;
        for (var i = 0; i < images.length; i++) {
            var image = images[i];
            if (image && image.coverType === "Fanart" && image.url) return image.url;
        }
        return null;
    }

    function parseRecommendations(html) {
        var start = html.indexOf('tab-content anime-recommendation row');
        if (start === -1) start = html.indexOf('anime-recommendation row');
        var end = start !== -1 ? html.indexOf('anime-comment', start) : -1;
        var section = start !== -1 ? html.slice(start, end !== -1 ? end : start + 20000) : "";
        if (!section) return [];

        var recommendations = [];
        var cardRegex = /<div[^>]*class="[^"]*col-12 col-sm-6[^"]*"[^>]*>[\s\S]*?<a href="\/anime\/([^"]+)" title="([^"]+)"[\s\S]*?<img[^>]+(?:data-src|src)="([^"]+)"[\s\S]*?<\/div>\s*<\/div>/gi;
        var match;
        while ((match = cardRegex.exec(section)) !== null) {
            var session = match[1];
            var title = decodeHtmlEntities(match[2].trim());
            var posterUrl = match[3] || null;
            if (!session || !title) continue;

            recommendations.push(new MultimediaItem({
                title: title,
                url: JSON.stringify({
                    session: session,
                    name: title,
                    sessionDate: Math.floor(Date.now() / 1000)
                }),
                posterUrl: posterUrl,
                type: "anime",
                headers: HEADERS
            }));
        }

        return uniqueByUrl(recommendations);
    }

    function toMultimediaItem(item, episodeInfo) {
        var multimedia = new MultimediaItem({
            title:     item.animeTitle || item.title,
            url:       JSON.stringify({
                session:     item.animeSession || item.session,
                name:        item.animeTitle   || item.title,
                sessionDate: Math.floor(Date.now() / 1000)
            }),
            posterUrl: item.snapshot || item.poster,
            type:      getType(item.type),
            year:      item.year,
            score:     item.score,
            headers:   HEADERS
        });
        if (episodeInfo && item.episode) {
            multimedia.description = "Episode " + item.episode;
        }
        return multimedia;
    }

    // ─────────────────────────────────────────────
    // TMDB Helpers
    // ─────────────────────────────────────────────

    async function tmdbAnimeSearch(query) {
        try {
            var url = TMDB_BASE + "/search/tv?api_key=" + TMDB_API_KEY
                    + "&query=" + encodeURIComponent(query)
                    + "&with_genres=16&with_origin_country=JP&language=en-US";
            var res  = await tmdbGet(url);
            if (!res || !res.body) throw new Error("Empty response");
            var data = JSON.parse(res.body);
            return data.results || [];
        } catch(e) {
            console.error("[TMDB] search error:", e.message);
            return [];
        }
    }

    async function tmdbAnimeByCategory(endpoint, extraParams) {
        try {
            // Build URL cleanly — api_key always first, no duplicates
            var url = TMDB_BASE + endpoint
                    + "?api_key=" + TMDB_API_KEY
                    + "&language=en-US"
                    + "&with_genres=16"
                    + "&with_origin_country=JP"
                    + (extraParams || "");
            var res  = await tmdbGet(url);
            if (!res || !res.body) throw new Error("Empty response");
            var data = JSON.parse(res.body);
            return (data.results || []).slice(0, 20);
        } catch(e) {
            console.error("[TMDB] category error:", e.message);
            return [];
        }
    }

    function tmdbToMultimediaItem(item) {
        var title   = item.name || item.original_name || item.title || "Unknown";
        var poster  = item.poster_path  ? (TMDB_IMG + item.poster_path)  : null;
        var banner  = item.backdrop_path? (TMDB_IMG + item.backdrop_path): poster;
        var year    = item.first_air_date ? parseInt(item.first_air_date.split("-")[0]) : null;
        var score   = item.vote_average  ? parseFloat(item.vote_average.toFixed(1)) : null;
        var mediaType = (item.media_type === "movie") ? "movie" : "anime";

        return new MultimediaItem({
            title:       title,
            url:         JSON.stringify({
                tmdb_id:     item.id,
                media_type:  mediaType,
                name:        title,
                sessionDate: Math.floor(Date.now() / 1000)
            }),
            posterUrl:   poster,
            bannerUrl:   banner,
            type:        mediaType,
            year:        year,
            score:       score,
            description: item.overview || null
        });
    }

    // ─────────────────────────────────────────────
    // HOME — IMDb-style, 5 curated rows, all from AnimePahe API
    // ─────────────────────────────────────────────
    //
    // Row 1: 🔴 Latest Releases     — airing page 1 (newest episodes)
    // Row 2: 🎌 New This Season     — airing page 2
    // Row 3: 🔥 Popular Right Now   — airing page 3
    // Row 4: 🎬 Anime Movies        — search "movie" filter (type=movie)
    // Row 5: ⭐ Recently Added       — airing page 4
    // ─────────────────────────────────────────────

    async function getHome(cb) {
        try {
            var homeData = {};

            // Helper: fetch one airing page, enrich posters from Jikan (MAL)
            async function fetchAiringPage(page) {
                var url = MAIN_URL + "/api?m=airing&page=" + page;
                var res = await http_get(url, HEADERS);
                if (!res || !res.body) throw new Error("Empty response");
                var data = new AiringResponse(JSON.parse(res.body));
                return data.data.map(function(item) {
                    var m = toMultimediaItem(item, true);
                    m.description = "Episode " + item.episode;
                    if (!m.posterUrl && item.snapshot) m.posterUrl = item.snapshot;
                    return m;
                });
            }

            // Helper: fetch one search page for anime type, enrich posters from Jikan
            async function fetchSearchPage(query, page) {
                var url = MAIN_URL + "/api?m=search&l=12&q=" + encodeURIComponent(query) + "&page=" + (page||1);
                var res = await http_get(url, HEADERS);
                if (!res || !res.body) throw new Error("Empty response");
                var data = new SearchResponse(JSON.parse(res.body));
                return data.data.map(function(item) { return toMultimediaItem(item, false); });
            }

            var rowJobs = [
                { key: "🔴 Latest Releases", run: function() { return fetchAiringPage(1); } },
                { key: "🎌 New This Season", run: function() { return fetchAiringPage(2); } },
                { key: "🔥 Popular Right Now", run: function() { return fetchAiringPage(3); } },
                { key: "🎬 Anime Movies", run: async function() {
                    var row4 = await fetchSearchPage("movie");
                    var movies = row4.filter(function(i) { return i.type === "movie"; });
                    return movies.length ? movies : row4;
                }},
                { key: "⭐ Recently Added", run: function() { return fetchAiringPage(4); } }
            ];

            var rowResults = await Promise.all(rowJobs.map(async function(job) {
                try {
                    return { key: job.key, items: await job.run() };
                } catch(e) {
                    console.error("[Home] " + job.key + " error:", e.message);
                    return { key: job.key, items: [] };
                }
            }));

            rowResults.forEach(function(result) {
                if (result.items && result.items.length) homeData[result.key] = result.items;
            });

            cb({ success: true, data: homeData });

        } catch(e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

        // ─────────────────────────────────────────────
    // Search — AnimePahe primary, TMDB fallback
    // ─────────────────────────────────────────────

    async function search(query, cb) {
        try {
            var key = String(query || "").trim().toLowerCase();
            var cached = cacheGet(searchCache, key, CACHE_TTL);
            if (cached) {
                cb({ success: true, data: cached });
                return;
            }
            if (searchInflight[key]) {
                cb({ success: true, data: await searchInflight[key] });
                return;
            }
            searchInflight[key] = (async function() {
            // Primary: AnimePahe API
            var url = MAIN_URL + "/api?m=search&l=8&q=" + encodeURIComponent(query);
            var res = await http_get(url, HEADERS);
            var data = JSON.parse(res.body);
            var searchRes = new SearchResponse(data);
            var items = searchRes.data.map(function(item) {
                return toMultimediaItem(item, false);
            });

            // Supplement with TMDB only if AnimePahe returns nothing
            if (!items.length) {
                try {
                    var tmdbResults = await tmdbAnimeSearch(query);
                    var tmdbItems   = tmdbResults.slice(0, 10).map(tmdbToMultimediaItem);
                    items = items.concat(tmdbItems);
                } catch(te) { console.error("[Search] TMDB fallback error:", te.message); }
            }
            return cacheSet(searchCache, key, uniqueByUrl(items));
            })();

            var finalItems = await searchInflight[key];
            delete searchInflight[key];
            cb({ success: true, data: finalItems });
        } catch(e) {
            delete searchInflight[String(query || "").trim().toLowerCase()];
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // Kwik extractor
    // ─────────────────────────────────────────────

    function unpackJS(script) {
        try {
            if (!script.includes("function(p,a,c,k,e")) {
                console.error("[unpackJS] Not a packed script");
                return null;
            }
            var bracePos = script.lastIndexOf('}(');
            if (bracePos === -1) { console.error("[unpackJS] Cannot find call site }("); return null; }
            var pos = bracePos + 2;
            var slen = script.length;

            function skipWS() { while (pos < slen && /\s/.test(script[pos])) pos++; }

            function readString() {
                var q = script[pos]; pos++;
                var out = "";
                while (pos < slen) {
                    var ch = script[pos];
                    if (ch === '\\') {
                        pos++;
                        var esc = script[pos] || '';
                        var map = {'n':'\n','r':'\r','t':'\t','\\':'\\','\'':'\'','"':'"'};
                        out += (map[esc] !== undefined ? map[esc] : esc);
                        pos++;
                    } else if (ch === q) { pos++; break; }
                    else { out += ch; pos++; }
                }
                return out;
            }

            function readInt() {
                var s = pos;
                while (pos < slen && /\d/.test(script[pos])) pos++;
                return parseInt(script.slice(s, pos), 10);
            }

            function skipComma() { skipWS(); if (pos < slen && script[pos] === ',') pos++; skipWS(); }
            function skipPastChar(ch) { while (pos < slen && script[pos] !== ch) pos++; if (pos < slen) pos++; }

            skipWS();
            if (script[pos] !== "'" && script[pos] !== '"') {
                console.error("[unpackJS] p not a string, char='" + script[pos] + "' pos=" + pos);
                return null;
            }
            var p = readString();

            skipComma();
            var a = readInt();

            skipComma();
            var c = readInt();

            skipComma();
            var k;
            if (script[pos] === "'" || script[pos] === '"') {
                k = readString().split('|');
                skipWS();
                if (pos < slen && script[pos] === '.') skipPastChar(')');
            } else if (script[pos] === '[') {
                pos++; k = [];
                while (pos < slen && script[pos] !== ']') {
                    skipWS();
                    if (script[pos] === "'" || script[pos] === '"') k.push(readString());
                    else { k.push(''); pos++; }
                    skipWS();
                    if (pos < slen && script[pos] === ',') pos++;
                }
            } else {
                console.error("[unpackJS] k not string/array, char='" + script[pos] + "'");
                return null;
            }

            if (isNaN(a) || a < 2) { console.error("[unpackJS] invalid radix=" + a); return null; }
            if (isNaN(c) || c < 0) { console.error("[unpackJS] bad word count c=" + c); return null; }

            console.log("[unpackJS] a=" + a + " c=" + c + " k.len=" + k.length + " p.len=" + p.length);
            return _decode(p, a, c, k);

        } catch(e) {
            console.error("[unpackJS] error:", e.message);
            return null;
        }
    }

    function _toBase(n, a) {
        var chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
        if (a <= 36) return n.toString(a);
        if (n === 0) return '0';
        var result = '';
        while (n > 0) { result = chars[n % a] + result; n = Math.floor(n / a); }
        return result;
    }

    function _decode(p, a, c, k) {
        while (c--) {
            if (k[c] && k[c] !== '') {
                p = p.replace(new RegExp('\\b' + _toBase(c, a) + '\\b', 'g'), k[c]);
            }
        }
        return p;
    }

    async function extractKwikStream(kwikUrl) {
        try {
            var cached = cacheGet(kwikCache, kwikUrl, CACHE_TTL);
            if (cached) return cached;
            console.log("[Kwik] Fetching embed: " + kwikUrl);
            var res = await http_get(kwikUrl, {
                ...HEADERS,
                "Referer": MAIN_URL + "/",
                "Origin": MAIN_URL
            });
            var html = res.body;

            var scriptMatch = html.match(/<script[^>]*>\s*(eval\(function\(p,a,c,k,e[,d]*\)[\s\S]*?)<\/script>/);
            if (!scriptMatch) { console.error("[Kwik] No packed script found in embed page"); return null; }

            var unpacked = unpackJS(scriptMatch[1]);
            if (!unpacked) { console.error("[Kwik] Failed to unpack script"); return null; }

            console.log("[Kwik] Unpacked (first 300 chars):", unpacked.substring(0, 300));

            var m3u8Match = unpacked.match(/source\s*=\s*'([^']*\.m3u8[^']*)'/);
            if (m3u8Match) { console.log("[Kwik] Found m3u8:", m3u8Match[1]); return cacheSet(kwikCache, kwikUrl, m3u8Match[1]); }

            var bare = unpacked.match(/(https?:\/\/[^\s'"]+\.m3u8[^\s'"]*)/);
            if (bare) { console.log("[Kwik] Found m3u8 (bare):", bare[1]); return cacheSet(kwikCache, kwikUrl, bare[1]); }

            console.error("[Kwik] m3u8 not found in unpacked script");
            return null;
        } catch(e) {
            console.error("[Kwik] Error:", e.message);
            return null;
        }
    }

    async function extractPaheUrl(paheUrl) {
        try {
            var res = await http_get(paheUrl, {
                "Referer": MAIN_URL + "/",
                "User-Agent": HEADERS["User-Agent"] || "Mozilla/5.0"
            });
            var html = res && (res.body || res.text || "") || "";
            if (!html) return null;
            var direct = (html.match(/https:\/\/kwik\.cx\/f\/[A-Za-z0-9]+/i) || [])[0]
                || (html.match(/https:\/\/kwik\.cx\/e\/[A-Za-z0-9]+/i) || [])[0]
                || "";
            return direct || null;
        } catch (e) {
            console.error("[Pahe] Error:", e.message);
            return null;
        }
    }

    // ─────────────────────────────────────────────
    // Load (anime detail page)
    // ─────────────────────────────────────────────

    async function load(url, cb) {
        try {
            var loadData = JSON.parse(url);

            // If this came from a TMDB item, try to find on AnimePahe first
            if (loadData.tmdb_id && !loadData.session) {
                var title = loadData.name || "";
                try {
                    var searchResult = await new Promise(function(resolve, reject) {
                        search(title, function(r) {
                            if (r.success && r.data.length > 0) resolve(r.data[0]);
                            else reject(new Error("Not found on AnimePahe"));
                        });
                    });
                    loadData = JSON.parse(searchResult.url);
                } catch(e) {
                    // Fallback: load TMDB detail and return with empty episodes
                    console.warn("[load] AnimePahe not found, using TMDB metadata for:", title);
                    try {
                        var mediaType = loadData.media_type === "movie" ? "movie" : "tv";
                        var tmdbDetail = await tmdbGet(
                            TMDB_BASE + "/" + mediaType + "/" + loadData.tmdb_id
                            + "?api_key=" + TMDB_API_KEY + "&language=en-US"
                        );
                        var td = JSON.parse(tmdbDetail.body);
                        cb({ success: true, data: new MultimediaItem({
                            title:       td.name || td.title || title,
                            url:         url,
                            posterUrl:   td.poster_path  ? (TMDB_IMG + td.poster_path)  : null,
                            bannerUrl:   td.backdrop_path? (TMDB_IMG + td.backdrop_path): null,
                            type:        mediaType === "movie" ? "movie" : "anime",
                            year:        td.first_air_date ? parseInt(td.first_air_date.split("-")[0])
                                        : (td.release_date ? parseInt(td.release_date.split("-")[0]) : null),
                            score:       td.vote_average ? parseFloat(td.vote_average.toFixed(1)) : null,
                            description: td.overview || null,
                            genres:      (td.genres || []).map(function(g) { return g.name; }),
                            episodes:    [
                                new Episode({
                                    name: "Movie",
                                    url:  url,
                                    season: 1,
                                    episode: 1,
                                    headers: HEADERS
                                })
                            ]
                        }) });
                    } catch(te) {
                        cb({ success: false, errorCode: "LOAD_ERROR", message: te.message });
                    }
                    return;
                }
            }

            var session = loadData.session;
            var name    = loadData.name;

            async function fetchAnimePage(targetSession) {
                var animeUrl = MAIN_URL + "/anime/" + targetSession;
                var res = await http_get(animeUrl, HEADERS);
                return { animeUrl: animeUrl, html: res.body || "" };
            }

            var pageData = await fetchAnimePage(session);
            var html = pageData.html;
            if (!html || html.indexOf("anime-info") === -1) {
                var searchRes = await new Promise(function(resolve, reject) {
                    search(name, function(result) {
                        if (result.success && result.data.length > 0) resolve(result.data[0]);
                        else reject(new Error("Session refresh failed"));
                    });
                });
                var freshData = JSON.parse(searchRes.url);
                session = freshData.session;
                pageData = await fetchAnimePage(session);
                html = pageData.html;
            }

            var japaneseTitle = (html.match(/<h2 class="japanese">([^<]+)<\/h2>/) || [])[1] || "";
            var animeTitle    = (html.match(/<span class="sr-only unselectable">([^<]+)<\/span>/) || [])[1]
                                || japaneseTitle || name;
            var poster        = (html.match(/class="anime-poster"[^>]*>\s*<a[^>]*href="([^"]+)"/) || [])[1] || "";

            var typeMatch = html.match(/<a[^>]*href="\/anime\/type\/[^"]*"[^>]*>([^<]+)<\/a>/);
            var type      = typeMatch ? typeMatch[1] : "TV";

            var yearMatch = html.match(/<strong>Aired:<\/strong>[^,]*,\s*(\d{4})/);
            var year      = yearMatch ? parseInt(yearMatch[1]) : null;

            var status = "unknown";
            if      (html.indexOf('href="/anime/airing"')    !== -1) status = "ongoing";
            else if (html.indexOf('href="/anime/completed"') !== -1) status = "completed";

            var synopsisMatch = html.match(/<div class="anime-synopsis[^"]*"[^>]*>([\s\S]*?)<\/div>/);
            var synopsis      = synopsisMatch ? synopsisMatch[1].replace(/<[^>]+>/g, '').trim() : "";

            var genres = [];
            var genreSection = html.match(/<div class="anime-genre[^"]*"[^>]*>([\s\S]*?)<\/div>/);
            if (genreSection) {
                genres = Array.from(genreSection[1].matchAll(/<a[^>]*>([^<]+)<\/a>/g))
                              .map(function(m) { return m[1].trim(); });
            }

            var malId     = null;
            var anilistId = null;
            var malMatch  = html.match(/myanimelist\.net\/anime\/(\d+)/);
            var aniMatch  = html.match(/anilist\.co\/anime\/(\d+)/);
            if (malMatch) malId     = malMatch[1];
            if (aniMatch) anilistId = aniMatch[1];

            var nextAiringPromise = (getType(type) === "anime" && status !== "completed")
                ? fetchNextAiring({ anilistId: anilistId, malId: malId, title: animeTitle || name })
                : Promise.resolve(undefined);
            var aniZipMeta = await fetchAniZipMeta(malId);
            var metaEpisodes = buildAniZipEpisodeMap(aniZipMeta);
            var backgroundFanart = getAniZipFanart(aniZipMeta);
            var recommendations = parseRecommendations(html);
            var episodes = await fetchAllEpisodes(session, metaEpisodes);
            var nextAiring = await nextAiringPromise;

            var result = new MultimediaItem({
                title:       animeTitle,
                url:         url,
                posterUrl:   poster,
                bannerUrl:   backgroundFanart || poster,
                backgroundPosterUrl: backgroundFanart || poster,
                type:        getType(type),
                year:        year,
                description: synopsis,
                status:      status,
                genres:      genres,
                syncData:    { mal: malId, anilist: anilistId },
                nextAiring:  nextAiring || undefined,
                recommendations: recommendations,
                episodes:    episodes,
                headers:     HEADERS
            });

            cb({ success: true, data: result });
        } catch(e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // Episode fetching
    // ─────────────────────────────────────────────

    async function fetchAllEpisodes(session, metaEpisodes) {
        var episodes = [];
        var firstPageUrl = MAIN_URL + "/api?m=release&id=" + session + "&sort=episode_asc&page=1";

        try {
            var res       = await http_get(firstPageUrl, HEADERS);
            var data      = JSON.parse(res.body);
            var firstPage = new EpisodeResponse(data);

            firstPage.data.forEach(function(ep) {
                episodes.push(createEpisode(ep, session, 1, "sub", metaEpisodes));
                episodes.push(createEpisode(ep, session, 1, "dub", metaEpisodes));
            });

            if (firstPage.lastPage > 1) {
                var pagePromises = [];
                for (var page = 2; page <= firstPage.lastPage; page++) {
                    pagePromises.push(fetchEpisodePage(session, page, metaEpisodes));
                }
                var results = await Promise.all(pagePromises);
                results.forEach(function(pageEps) {
                    episodes.push.apply(episodes, pageEps);
                });
            }

            episodes.sort(function(a, b) { return a.episode - b.episode; });
            episodes.forEach(function(ep, idx) { ep.episode = idx + 1; });

        } catch(e) {
            console.error("[fetchAllEpisodes] Error:", e.message);
        }

        return episodes;
    }

    async function fetchEpisodePage(session, page, metaEpisodes) {
        var url = MAIN_URL + "/api?m=release&id=" + session + "&sort=episode_asc&page=" + page;
        try {
            var res      = await http_get(url, HEADERS);
            var data     = JSON.parse(res.body);
            var pageData = new EpisodeResponse(data);
            var episodes = [];
            pageData.data.forEach(function(ep) {
                episodes.push(createEpisode(ep, session, page, "sub", metaEpisodes));
                episodes.push(createEpisode(ep, session, page, "dub", metaEpisodes));
            });
            return episodes;
        } catch(e) {
            console.error("[fetchEpisodePage] page " + page + " error:", e.message);
            return [];
        }
    }

    function createEpisode(epData, animeSession, page, dubStatus, metaEpisodes) {
        var meta = getAniZipEpisodeMeta(metaEpisodes, epData.episode);
        var title      = (meta && meta.title && meta.title.en) || epData.title || "Episode " + epData.episode;
        var suffix     = dubStatus === "dub" ? " (Dub)" : "";
        var urlPayload = JSON.stringify({
            mainUrl:         MAIN_URL,
            is_play_page:    true,
            episode_num:     epData.episode,
            page:            page - 1,
            session:         animeSession,
            episode_session: epData.session,
            dubStatus:       dubStatus
        });

        return new Episode({
            name:      title + suffix,
            url:       urlPayload,
            season:    1,
            episode:   epData.episode,
            posterUrl: (meta && meta.image) || epData.snapshot,
            description: (meta && meta.overview) || "",
            score: scoreFromAniZip(meta),
            runTime: meta && meta.runtime ? meta.runtime : undefined,
            airDate:   epData.createdAt,
            dubStatus: dubStatus,
            headers:   HEADERS
        });
    }

    // ─────────────────────────────────────────────
    // loadStreams
    // ─────────────────────────────────────────────

    async function loadStreams(url, cb) {
        try {
            var data       = JSON.parse(url);
            var episodeUrl = MAIN_URL + "/play/" + data.session + "/" + data.episode_session;

            console.log("[loadStreams] Fetching play page:", episodeUrl);

            var res  = await http_get(episodeUrl, HEADERS);
            var html = res.body;

            var streams = [];
            var buttonRegex = /<button[^>]*data-src="(https?:\/\/[^"]*kwik[^"]+)"([^>]*)>([\s\S]*?)<\/button>/gi;
            var attrRegex = /([:@\w-]+)="([^"]*)"/g;
            var match;
            var wantDub = (data.dubStatus === "dub");
            var wantAudio = wantDub ? "eng" : "jpn";
            var buttons = [];

            while ((match = buttonRegex.exec(html)) !== null) {
                var kwikHref = match[1];
                var attrsRaw = match[2] || "";
                var btnHtml  = match[3] || "";
                var attrs = {};
                var attrMatch;
                while ((attrMatch = attrRegex.exec(attrsRaw)) !== null) {
                    attrs[attrMatch[1]] = attrMatch[2];
                }
                var btnText = btnHtml.replace(/<[^>]+>/g, " ").replace(/&middot;/g, "·").trim();
                var audio = String(attrs["data-audio"] || "").toLowerCase();
                var isDub = audio === "eng" || /\beng(?:lish)?\b/i.test(btnText);
                var resolution = parseInt(attrs["data-resolution"] || "0", 10) || 0;

                buttons.push({
                    kwikHref: kwikHref,
                    btnText: btnText,
                    isDub: isDub,
                    audio: audio,
                    resolution: resolution
                });
            }

            if (!buttons.length) {
                var currentUrl = (html.match(/let\s+url\s*=\s*"(https?:\/\/[^"]*kwik[^"]+)"/i) || [])[1] || "";
                if (currentUrl) {
                    buttons.push({
                        kwikHref: currentUrl,
                        btnText: "Current",
                        isDub: wantDub,
                        audio: wantAudio,
                        resolution: 0
                    });
                }
            }

            var filteredButtons = buttons.filter(function(button) {
                if (!button || !button.kwikHref) return false;
                if (button.audio) return button.audio === wantAudio;
                return button.isDub === wantDub;
            });
            if (!filteredButtons.length) filteredButtons = buttons;
            filteredButtons = filteredButtons.filter(function(button, index, arr) {
                return arr.findIndex(function(other) { return other.kwikHref === button.kwikHref; }) === index;
            });

            var streamRows = await Promise.all(filteredButtons.map(async function(button) {
                var qualityMatch = button.btnText.match(/(\d{3,4})p/);
                var quality      = qualityMatch ? parseInt(qualityMatch[1], 10) : (button.resolution || 0);
                var label        = (button.btnText.split('·')[0] || "").trim() || "Kwik";
                var qualityTag   = quality ? (" [" + quality + "p]") : "";
                var sourceBase   = "AnimePahe " + label + " [" + (button.isDub ? "DUB" : "SUB") + "]" + qualityTag;

                console.log("[loadStreams] Extracting Kwik [" + (button.isDub ? "DUB" : "SUB") + "]:", button.kwikHref);
                var streamUrl = await extractKwikStream(button.kwikHref);

                if (streamUrl) {
                    var rows = [];
                    if (/\.m3u8(?:$|\?)/i.test(streamUrl)) {
                        var streamHeaders = {
                            "Referer": "https://kwik.cx/",
                            "Origin": "https://kwik.cx",
                            "User-Agent": HEADERS["User-Agent"] || "Mozilla/5.0"
                        };
                        var magicUrl = await buildMagicM3u8Url(streamUrl, streamHeaders);
                        rows.push(new StreamResult({
                            url: streamUrl,
                            quality: quality || qualityFromText(streamUrl) || qualityFromText(button.btnText),
                            source: sourceBase,
                            referer: "https://kwik.cx/",
                            type: "hls",
                            headers: streamHeaders
                        }));
                        rows.push(new StreamResult({
                            url: magicUrl,
                            quality: quality || qualityFromText(streamUrl) || qualityFromText(button.btnText),
                            source: sourceBase + " [Proxy]",
                            referer: "https://kwik.cx/",
                            type: "hls",
                            headers: streamHeaders
                        }));
                        return rows;
                    }
                    return [new StreamResult({
                        url: streamUrl,
                        quality: quality || qualityFromText(streamUrl) || qualityFromText(button.btnText),
                        source: sourceBase,
                        referer: "https://kwik.cx",
                        headers: {}
                    })];
                }
                console.error("[loadStreams] Failed to extract stream for:", button.kwikHref);
                return [];
            }));

            streams = [].concat.apply([], streamRows).filter(Boolean);

            console.log("[loadStreams] Total streams found:", streams.length);
            cb({ success: true, data: streams });

        } catch(e) {
            console.error("[loadStreams] Fatal error:", e.message);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // Exports
    // ─────────────────────────────────────────────

    globalThis.getHome     = getHome;
    globalThis.search      = search;
    globalThis.load        = load;
    globalThis.loadStreams  = loadStreams;

    console.log("AnimePahe plugin loaded — IMDb-style home with 6 JP Anime rows");
})();
