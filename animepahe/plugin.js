(function() {
    const MAIN_URL = (((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://animepahe.com") + "").replace(/\/+$/, "");
    const PROXY = "https://animepaheproxy.phisheranimepahe.workers.dev/?url=";
    const HEADERS = {
        "Cookie": "__ddg2_=1234567890",
        "Referer": MAIN_URL,
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
    };

    // TMDB API key (from reference)
    const TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    const TMDB_BASE    = "https://api.themoviedb.org/3";
    const TMDB_IMG     = "https://image.tmdb.org/t/p/w500";
    // Poster lookup:
    // AnimePahe's search API returns a proper "poster" cover image for each anime.
    // We search by title and take the first result's poster — same proxy, always works.
    // Falls back to TMDB direct if AnimePahe search returns nothing.
    async function getPoster(title) {
        if (!title) return null;

        // Source 1: AnimePahe search API — returns proper cover poster, not episode snapshot
        try {
            var apUrl = PROXY + MAIN_URL + "/api?m=search&l=1&q=" + encodeURIComponent(title);
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

        // Source 3: TMDB via proxy (last resort)
        try {
            var tpUrl = PROXY + encodeURIComponent(
                TMDB_BASE + "/search/tv?api_key=" + TMDB_API_KEY
                + "&query=" + encodeURIComponent(title) + "&language=en-US"
            );
            var tpRes = await http_get(tpUrl);
            if (tpRes && tpRes.body && tpRes.body.indexOf("{") === 0) {
                var tpData = JSON.parse(tpRes.body);
                var rp = tpData.results && tpData.results[0];
                if (rp && rp.poster_path) return TMDB_IMG + rp.poster_path;
            }
        } catch(e) { /* all failed */ }

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
                var url = PROXY + MAIN_URL + "/api?m=airing&page=" + page;
                var res = await http_get(url, HEADERS);
                if (!res || !res.body) throw new Error("Empty response");
                var data = new AiringResponse(JSON.parse(res.body));
                var items = data.data.map(function(item) {
                    var m = toMultimediaItem(item, true);
                    m.description = "Episode " + item.episode;
                    return m;
                });
                // Enrich posters in parallel using session (fastest) or title fallback
                var enriched = await Promise.all(items.map(async function(m, idx) {
                    var rawItem = data.data[idx];
                    var session = rawItem && rawItem.animeSession;
                    var title   = m.title || "";

                    // Try session-based lookup first (most accurate — direct anime page)
                    if (session) {
                        try {
                            var spUrl = PROXY + MAIN_URL + "/api?m=search&l=1&q=" + encodeURIComponent(title);
                            var spRes = await http_get(spUrl, HEADERS);
                            if (spRes && spRes.body) {
                                var spData = JSON.parse(spRes.body);
                                // Find result whose session matches exactly
                                var match = (spData.data || []).find(function(d) {
                                    return d.session === session;
                                }) || spData.data && spData.data[0];
                                if (match && match.poster && match.poster.indexOf("/snapshots/") === -1) {
                                    m.posterUrl = match.poster;
                                    return m;
                                }
                            }
                        } catch(e) { /* fall through */ }
                    }

                    // Fallback: getPoster by title
                    var poster = await getPoster(title);
                    if (poster) m.posterUrl = poster;
                    return m;
                }));
                return enriched;
            }

            // Helper: fetch one search page for anime type, enrich posters from Jikan
            async function fetchSearchPage(query, page) {
                var url = PROXY + MAIN_URL + "/api?m=search&l=12&q=" + encodeURIComponent(query) + "&page=" + (page||1);
                var res = await http_get(url, HEADERS);
                if (!res || !res.body) throw new Error("Empty response");
                var data = new SearchResponse(JSON.parse(res.body));
                var items = data.data.map(function(item) { return toMultimediaItem(item, false); });
                var enriched = await Promise.all(items.map(async function(m) {
                    var poster = await getPoster(m.title || "");
                    if (poster) m.posterUrl = poster;
                    return m;
                }));
                return enriched;
            }

            // ── Row 1: Latest Releases ─────────────────────────────────
            try {
                var row1 = await fetchAiringPage(1);
                if (row1.length) homeData["🔴 Latest Releases"] = row1;
            } catch(e) { console.error("[Home] Row 1 error:", e.message); }

            // ── Row 2: New This Season ─────────────────────────────────
            try {
                var row2 = await fetchAiringPage(2);
                if (row2.length) homeData["🎌 New This Season"] = row2;
            } catch(e) { console.error("[Home] Row 2 error:", e.message); }

            // ── Row 3: Popular Right Now ───────────────────────────────
            try {
                var row3 = await fetchAiringPage(3);
                if (row3.length) homeData["🔥 Popular Right Now"] = row3;
            } catch(e) { console.error("[Home] Row 3 error:", e.message); }

            // ── Row 4: Anime Movies ────────────────────────────────────
            try {
                var row4 = await fetchSearchPage("movie");
                // Filter to only movie-type items
                var movies = row4.filter(function(i) { return i.type === "movie"; });
                if (!movies.length) movies = row4; // fallback: show all if none tagged movie
                if (movies.length) homeData["🎬 Anime Movies"] = movies;
            } catch(e) { console.error("[Home] Row 4 error:", e.message); }

            // ── Row 5: Recently Added ──────────────────────────────────
            try {
                var row5 = await fetchAiringPage(4);
                if (row5.length) homeData["⭐ Recently Added"] = row5;
            } catch(e) { console.error("[Home] Row 5 error:", e.message); }

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
            // Primary: AnimePahe API
            var url = PROXY + MAIN_URL + "/api?m=search&l=8&q=" + encodeURIComponent(query);
            var res = await http_get(url, HEADERS);
            var data = JSON.parse(res.body);
            var searchRes = new SearchResponse(data);
            var items = searchRes.data.map(function(item) {
                return toMultimediaItem(item, false);
            });

            // Supplement with TMDB if AnimePahe returns too few results
            if (items.length < 4) {
                try {
                    var tmdbResults = await tmdbAnimeSearch(query);
                    var tmdbItems   = tmdbResults.slice(0, 10).map(tmdbToMultimediaItem);
                    items = items.concat(tmdbItems);
                } catch(te) { console.error("[Search] TMDB fallback error:", te.message); }
            }

            cb({ success: true, data: items });
        } catch(e) {
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
            console.log("[Kwik] Fetching embed: " + kwikUrl);
            var res = await http_get(kwikUrl, { ...HEADERS, "Referer": kwikUrl });
            var html = res.body;

            var scriptMatch = html.match(/<script[^>]*>\s*(eval\(function\(p,a,c,k,e[,d]*\)[\s\S]*?)<\/script>/);
            if (!scriptMatch) { console.error("[Kwik] No packed script found in embed page"); return null; }

            var unpacked = unpackJS(scriptMatch[1]);
            if (!unpacked) { console.error("[Kwik] Failed to unpack script"); return null; }

            console.log("[Kwik] Unpacked (first 300 chars):", unpacked.substring(0, 300));

            var m3u8Match = unpacked.match(/source\s*=\s*'([^']*\.m3u8[^']*)'/);
            if (m3u8Match) { console.log("[Kwik] Found m3u8:", m3u8Match[1]); return m3u8Match[1]; }

            var bare = unpacked.match(/(https?:\/\/[^\s'"]+\.m3u8[^\s'"]*)/);
            if (bare) { console.log("[Kwik] Found m3u8 (bare):", bare[1]); return bare[1]; }

            console.error("[Kwik] m3u8 not found in unpacked script");
            return null;
        } catch(e) {
            console.error("[Kwik] Error:", e.message);
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

            // Refresh session if older than 10 minutes
            var now = Math.floor(Date.now() / 1000);
            if (loadData.sessionDate && (loadData.sessionDate + 600 < now)) {
                var searchRes = await new Promise(function(resolve, reject) {
                    search(name, function(result) {
                        if (result.success && result.data.length > 0) resolve(result.data[0]);
                        else reject(new Error("Session refresh failed"));
                    });
                });
                var freshData = JSON.parse(searchRes.url);
                session = freshData.session;
            }

            var animeUrl = PROXY + MAIN_URL + "/anime/" + session;
            var res      = await http_get(animeUrl, HEADERS);
            var html     = res.body;

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

            var aniZipMeta = await fetchAniZipMeta(malId);
            var metaEpisodes = buildAniZipEpisodeMap(aniZipMeta);
            var backgroundFanart = getAniZipFanart(aniZipMeta);
            var recommendations = parseRecommendations(html);
            var episodes = await fetchAllEpisodes(session, metaEpisodes);

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
        var firstPageUrl = PROXY + MAIN_URL + "/api?m=release&id=" + session + "&sort=episode_asc&page=1";

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
        var url = PROXY + MAIN_URL + "/api?m=release&id=" + session + "&sort=episode_asc&page=" + page;
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
            var episodeUrl = PROXY + MAIN_URL + "/play/" + data.session + "/" + data.episode_session;

            console.log("[loadStreams] Fetching play page:", episodeUrl);

            var res  = await http_get(episodeUrl, HEADERS);
            var html = res.body;

            var streams = [];

            var kwikRegex = /<button[^>]*data-src="(https:\/\/kwik\.cx\/e\/[^"]*)"[^>]*>([\s\S]*?)<\/button>/g;
            var match;
            var wantDub = (data.dubStatus === "dub");

            while ((match = kwikRegex.exec(html)) !== null) {
                var kwikHref = match[1];
                var btnText  = match[2].replace(/<[^>]+>/g, ' ').trim();
                var isDub    = btnText.toLowerCase().includes('eng');

                if (isDub !== wantDub) continue;

                var qualityMatch = btnText.match(/(\d{3,4})p/);
                var quality      = qualityMatch ? parseInt(qualityMatch[1]) : 0;
                var label        = (btnText.split('·')[0] || "").trim() || "Kwik";

                console.log("[loadStreams] Extracting Kwik [" + (isDub ? "DUB" : "SUB") + "]:", kwikHref);
                var streamUrl = await extractKwikStream(kwikHref);

                if (streamUrl) {
                    streams.push(new StreamResult({
                        url:     streamUrl,
                        quality: quality,
                        source:  "AnimePahe " + label + " [" + (isDub ? 'DUB' : 'SUB') + "]",
                        headers: { ...HEADERS, "Referer": "https://kwik.cx/" }
                    }));
                } else {
                    console.error("[loadStreams] Failed to extract stream for:", kwikHref);
                }
            }

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
