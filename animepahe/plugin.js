(function() {
    const MAIN_URL = "https://animepahe.si";
    const PROXY = "https://animepaheproxy.phisheranimepahe.workers.dev/?url=";
    const HEADERS = {
        "Cookie": "__ddg2_=1234567890",
        "Referer": MAIN_URL,
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
    };

    // ─────────────────────────────────────────────
    // Data models
    // ─────────────────────────────────────────────

    function AiringData(json) {
        this.animeTitle = json.anime_title;
        this.episode    = json.episode;
        this.snapshot   = json.snapshot;
        this.animeSession = json.anime_session;
        this.createdAt  = json.created_at;
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
            headers:   HEADERS
        });
        if (episodeInfo && item.episode) {
            multimedia.description = "Episode " + item.episode;
        }
        return multimedia;
    }

    // ─────────────────────────────────────────────
    // Kwik extractor  (mirrors Kotlin Kwik class)
    // ─────────────────────────────────────────────
    /**
     * Unpacks a dean.edwards P,A,C,K,E,D script.
     *
     * Uses character-walking to parse the call-site arguments — immune to
     * changes in quote style, whitespace, or Kwik script updates.
     *
     * Packed scripts always end with:
     *   }('p_string', radix, count, 'k1|k2|...'.split('|'), 0, {}))
     *    ^--- we find the last ( and walk forward from there
     */
    function unpackJS(script) {
        try {
            if (!script.includes("function(p,a,c,k,e")) {
                console.error("[unpackJS] Not a packed script");
                return null;
            }

            // Find the LAST opening paren of the outer call — i.e. the ( in }(
            var bracePos = script.lastIndexOf('}(');
            if (bracePos === -1) {
                console.error("[unpackJS] Cannot find call site }(");
                return null;
            }
            var pos = bracePos + 2; // right after }(
            var slen = script.length;

            function skipWS() {
                while (pos < slen && /\s/.test(script[pos])) pos++;
            }

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

            function skipComma() {
                skipWS();
                if (pos < slen && script[pos] === ',') pos++;
                skipWS();
            }

            function skipPastChar(ch) {
                while (pos < slen && script[pos] !== ch) pos++;
                if (pos < slen) pos++;
            }

            // Arg 1: p (encoded body string)
            skipWS();
            if (script[pos] !== "'" && script[pos] !== '"') {
                console.error("[unpackJS] p not a string, char='" + script[pos] + "' pos=" + pos);
                return null;
            }
            var p = readString();

            // Arg 2: a (radix)
            skipComma();
            var a = readInt();

            // Arg 3: c (word count)
            skipComma();
            var c = readInt();

            // Arg 4: k (keyword list as string or array)
            skipComma();
            var k;
            if (script[pos] === "'" || script[pos] === '"') {
                k = readString().split('|');
                skipWS();
                // skip optional .split('|')
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

            // Radix can legally be 62 (Kwik uses base-62); only reject truly invalid values
            if (isNaN(a) || a < 2) {
                console.error("[unpackJS] invalid radix=" + a);
                return null;
            }
            if (isNaN(c) || c < 0) {
                console.error("[unpackJS] bad word count c=" + c);
                return null;
            }

            console.log("[unpackJS] a=" + a + " c=" + c + " k.len=" + k.length + " p.len=" + p.length);
            return _decode(p, a, c, k);

        } catch(e) {
            console.error("[unpackJS] error:", e.message);
            return null;
        }
    }

    // Custom base encoder: JS .toString() only goes to base-36,
    // but Kwik uses base-62 (0-9 + a-z + A-Z).
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


    /**
     * Fetches a kwik.cx/e/{id} embed page and extracts the m3u8 URL.
     * Mirrors the Kotlin Kwik.getUrl() exactly:
     *   1. GET the embed URL  (referer = the embed URL itself, as Kotlin does)
     *   2. Find the eval(function(p,a,c,k,e,d){…}) script block
     *   3. Unpack it
     *   4. Regex out  source='…m3u8…'
     */
    async function extractKwikStream(kwikUrl) {
        try {
            console.log("[Kwik] Fetching embed: " + kwikUrl);

            // FIX: referer must be the embed URL itself (matches Kotlin: referer=url)
            var res = await http_get(kwikUrl, {
                ...HEADERS,
                "Referer": kwikUrl
            });

            var html = res.body;

            // Find the packed <script> block
            var scriptMatch = html.match(/<script[^>]*>\s*(eval\(function\(p,a,c,k,e[,d]*\)[\s\S]*?)<\/script>/);
            if (!scriptMatch) {
                console.error("[Kwik] No packed script found in embed page");
                return null;
            }

            var unpacked = unpackJS(scriptMatch[1]);
            if (!unpacked) {
                console.error("[Kwik] Failed to unpack script");
                return null;
            }

            console.log("[Kwik] Unpacked (first 300 chars):", unpacked.substring(0, 300));

            // FIX: regex uses single-quotes to match  source='https://…m3u8…'
            // The old regex had a stray extra quote character in the character class
            var m3u8Match = unpacked.match(/source\s*=\s*'([^']*\.m3u8[^']*)'/);
            if (m3u8Match) {
                console.log("[Kwik] Found m3u8:", m3u8Match[1]);
                return m3u8Match[1];
            }

            // Fallback: any bare https URL ending in .m3u8 (with possible query string)
            var bare = unpacked.match(/(https?:\/\/[^\s'"]+\.m3u8[^\s'"]*)/);
            if (bare) {
                console.log("[Kwik] Found m3u8 (bare):", bare[1]);
                return bare[1];
            }

            console.error("[Kwik] m3u8 not found in unpacked script");
            return null;

        } catch(e) {
            console.error("[Kwik] Error:", e.message);
            return null;
        }
    }


    // ─────────────────────────────────────────────
    // Home
    // ─────────────────────────────────────────────

    async function getHome(cb) {
        try {
            var url = PROXY + MAIN_URL + "/api?m=airing&page=1";
            var res = await http_get(url, HEADERS);
            var data = JSON.parse(res.body);
            var airing = new AiringResponse(data);

            var items = airing.data.map(function(item) {
                var multimedia = toMultimediaItem(item, true);
                multimedia.description = "Episode " + item.episode;
                return multimedia;
            });

            cb({ success: true, data: { "Latest Releases": items } });
        } catch(e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // Search
    // ─────────────────────────────────────────────

    async function search(query, cb) {
        try {
            var url = PROXY + MAIN_URL + "/api?m=search&l=8&q=" + encodeURIComponent(query);
            var res = await http_get(url, HEADERS);
            var data = JSON.parse(res.body);
            var searchRes = new SearchResponse(data);

            var items = searchRes.data.map(function(item) {
                return toMultimediaItem(item, false);
            });
            cb({ success: true, data: items });
        } catch(e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // Load (anime detail page)
    // ─────────────────────────────────────────────

    async function load(url, cb) {
        try {
            var loadData = JSON.parse(url);
            var session  = loadData.session;
            var name     = loadData.name;

            // Refresh session if older than 10 minutes (mirrors Kotlin sessionDate check)
            var now = Math.floor(Date.now() / 1000);
            if (loadData.sessionDate && (loadData.sessionDate + 600 < now)) {
                var searchRes = await new Promise(function(resolve, reject) {
                    search(name, function(result) {
                        if (result.success && result.data.length > 0) {
                            resolve(result.data[0]);
                        } else {
                            reject(new Error("Session refresh failed"));
                        }
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

            var malId    = null;
            var anilistId = null;
            var malMatch = html.match(/myanimelist\.net\/anime\/(\d+)/);
            var aniMatch = html.match(/anilist\.co\/anime\/(\d+)/);
            if (malMatch) malId     = malMatch[1];
            if (aniMatch) anilistId = aniMatch[1];

            var episodes = await fetchAllEpisodes(session);

            var result = new MultimediaItem({
                title:       animeTitle,
                url:         url,
                posterUrl:   poster,
                bannerUrl:   poster,
                type:        getType(type),
                year:        year,
                description: synopsis,
                status:      status,
                genres:      genres,
                syncData:    { mal: malId, anilist: anilistId },
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

    async function fetchAllEpisodes(session) {
        var episodes = [];
        var firstPageUrl = PROXY + MAIN_URL + "/api?m=release&id=" + session + "&sort=episode_asc&page=1";

        try {
            var res       = await http_get(firstPageUrl, HEADERS);
            var data      = JSON.parse(res.body);
            var firstPage = new EpisodeResponse(data);

            firstPage.data.forEach(function(ep) {
                episodes.push(createEpisode(ep, session, 1, "sub"));
                episodes.push(createEpisode(ep, session, 1, "dub"));
            });

            if (firstPage.lastPage > 1) {
                var pagePromises = [];
                for (var page = 2; page <= firstPage.lastPage; page++) {
                    pagePromises.push(fetchEpisodePage(session, page));
                }
                var results = await Promise.all(pagePromises);
                results.forEach(function(pageEps) {
                    episodes.push.apply(episodes, pageEps);
                });
            }

            // Sort by episode number and re-index from 1
            episodes.sort(function(a, b) { return a.episode - b.episode; });
            episodes.forEach(function(ep, idx) { ep.episode = idx + 1; });

        } catch(e) {
            console.error("[fetchAllEpisodes] Error:", e.message);
        }

        return episodes;
    }

    async function fetchEpisodePage(session, page) {
        var url = PROXY + MAIN_URL + "/api?m=release&id=" + session + "&sort=episode_asc&page=" + page;
        try {
            var res      = await http_get(url, HEADERS);
            var data     = JSON.parse(res.body);
            var pageData = new EpisodeResponse(data);
            var episodes = [];
            pageData.data.forEach(function(ep) {
                episodes.push(createEpisode(ep, session, page, "sub"));
                episodes.push(createEpisode(ep, session, page, "dub"));
            });
            return episodes;
        } catch(e) {
            console.error("[fetchEpisodePage] page " + page + " error:", e.message);
            return [];
        }
    }

    function createEpisode(epData, animeSession, page, dubStatus) {
        var title      = epData.title || "Episode " + epData.episode;
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
            posterUrl: epData.snapshot,
            airDate:   epData.createdAt,
            dubStatus: dubStatus,
            headers:   HEADERS
        });
    }

    // ─────────────────────────────────────────────
    // loadStreams  (the main entry point for playing)
    // ─────────────────────────────────────────────

    async function loadStreams(url, cb) {
        try {
            var data       = JSON.parse(url);
            var episodeUrl = PROXY + MAIN_URL + "/play/" + data.session + "/" + data.episode_session;

            console.log("[loadStreams] Fetching play page:", episodeUrl);

            var res  = await http_get(episodeUrl, HEADERS);
            var html = res.body;

            var streams = [];

            // ── Kwik stream buttons (#resolutionMenu) ──────────────────────────
            // The play page has buttons like:
            //   <button data-src="https://kwik.cx/e/XXXX">…1080p…</button>
            var kwikRegex = /<button[^>]*data-src="(https:\/\/kwik\.cx\/e\/[^"]*)"[^>]*>([\s\S]*?)<\/button>/g;
            var match;

            // dubStatus from episode url payload: "sub" or "dub"
            var wantDub = (data.dubStatus === "dub");

            while ((match = kwikRegex.exec(html)) !== null) {
                var kwikHref = match[1];
                var btnText  = match[2].replace(/<[^>]+>/g, ' ').trim();

                // AnimePahe marks dub streams with "eng" in the <span> inside the button
                var isDub = btnText.toLowerCase().includes('eng');

                // Only extract streams that match the requested dubStatus
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
                        headers: {
                            ...HEADERS,
                            "Referer": "https://kwik.cx/"
                        }
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

    globalThis.getHome    = getHome;
    globalThis.search     = search;
    globalThis.load       = load;
    globalThis.loadStreams = loadStreams;

    console.log("AnimePahe plugin loaded");
})();
