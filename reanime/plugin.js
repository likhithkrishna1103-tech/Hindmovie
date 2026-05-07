(function () {
    var BASE_URL = (((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://reanime.to") + "").replace(/\/+$/, "");
    var FLIX_URL = "https://flixcloud.cc";
    var ENC_DEC_URL = "https://enc-dec.app/api/dec-reanime";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";
    var HOME_CACHE = { value: null, time: 0 };
    var DETAIL_CACHE = {};
    var API_CACHE = {};

    var MAIN_HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/",
        "Origin": BASE_URL
    };

    function trim(value) {
        return String(value == null ? "" : value).trim();
    }

    function absoluteUrl(base, value) {
        value = trim(value);
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base || BASE_URL).toString();
        } catch (_) {
            return value;
        }
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ");
    }

    function cleanText(value) {
        return decodeHtml(String(value || "").replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "))
            .replace(/\n{3,}/g, "\n\n")
            .replace(/[ \t]{2,}/g, " ")
            .trim();
    }

    function uniqueBy(list, keyFn) {
        var seen = Object.create(null);
        var out = [];
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function cacheGet(cache, key, ttl) {
        var entry = cache[key];
        if (!entry) return null;
        if (Date.now() - entry.time > ttl) {
            delete cache[key];
            return null;
        }
        return entry.value;
    }

    function cacheSet(cache, key, value) {
        cache[key] = { value: value, time: Date.now() };
        return value;
    }

    function extractBalanced(text, startIndex, openChar, closeChar) {
        var depth = 0;
        var inSingle = false;
        var inDouble = false;
        var inTemplate = false;
        var escaped = false;
        var out = "";
        for (var i = startIndex; i < text.length; i++) {
            var ch = text.charAt(i);
            out += ch;
            if (escaped) {
                escaped = false;
                continue;
            }
            if (ch === "\\") {
                escaped = true;
                continue;
            }
            if (inSingle) {
                if (ch === "'") inSingle = false;
                continue;
            }
            if (inDouble) {
                if (ch === "\"") inDouble = false;
                continue;
            }
            if (inTemplate) {
                if (ch === "`") inTemplate = false;
                continue;
            }
            if (ch === "'") {
                inSingle = true;
                continue;
            }
            if (ch === "\"") {
                inDouble = true;
                continue;
            }
            if (ch === "`") {
                inTemplate = true;
                continue;
            }
            if (ch === openChar) depth++;
            else if (ch === closeChar) {
                depth--;
                if (depth === 0) return out;
            }
        }
        return "";
    }

    function extractObjectByKey(text, key) {
        var marker = key + ":{";
        var idx = text.indexOf(marker);
        if (idx === -1) return null;
        var raw = extractBalanced(text, idx + key.length + 1, "{", "}");
        if (!raw) return null;
        try {
            return (new Function("return (" + raw + ");"))();
        } catch (_) {
            return null;
        }
    }

    function extractInlineDataObject(html) {
        var videoIdx = html.indexOf("video_id:");
        if (videoIdx === -1) return null;
        var dataIdx = html.lastIndexOf("data:{", videoIdx);
        if (dataIdx === -1) return null;
        var raw = extractBalanced(html, dataIdx + 5, "{", "}");
        if (!raw) return null;
        try {
            return (new Function("return (" + raw + ");"))();
        } catch (_) {
            return null;
        }
    }

    async function httpGet(url, headers) {
        return http_get(url, headers || {});
    }

    async function httpGetText(url, headers) {
        var res = await httpGet(url, headers || {});
        return res && (res.body || res.text || "") || "";
    }

    async function httpGetJson(url, headers) {
        var res = await httpGet(url, headers || {});
        var body = res && (typeof res.body !== "undefined" ? res.body : res && typeof res.text !== "undefined" ? res.text : "");
        if (body && typeof body === "object") return body;
        return JSON.parse(String(body || ""));
    }

    async function httpPostJson(url, payload, headers) {
        var body = JSON.stringify(payload || {});
        var merged = Object.assign({
            "Content-Type": "application/json",
            "Accept": "application/json",
            "User-Agent": USER_AGENT
        }, headers || {});
        try {
            var res = await http_post(url, merged, body);
            var firstBody = res && (typeof res.body !== "undefined" ? res.body : res && typeof res.text !== "undefined" ? res.text : "");
            if (firstBody && typeof firstBody === "object") return firstBody;
            return JSON.parse(String(firstBody || "{}"));
        } catch (_) {
            var res2 = await http_post(url, body, merged);
            var secondBody = res2 && (typeof res2.body !== "undefined" ? res2.body : res2 && typeof res2.text !== "undefined" ? res2.text : "");
            if (secondBody && typeof secondBody === "object") return secondBody;
            return JSON.parse(String(secondBody || "{}"));
        }
    }

    function displayTitle(row) {
        return trim(row && row.title && (row.title.english || row.title.user_preferred || row.title.romaji || row.title.native)) || "Unknown";
    }

    function subtitleCount(row) {
        return Number(row && row.subbed || 0);
    }

    function dubCount(row) {
        return Number(row && row.dubbed || 0);
    }

    function rowType(row) {
        return /movie/i.test(String(row && row.format || "")) ? "movie" : "anime";
    }

    function buildCard(row) {
        var posterUrl = absoluteUrl(BASE_URL, row && row.cover_image && (row.cover_image.extra_large || row.cover_image.large || row.cover_image.medium) || "");
        var bannerUrl = absoluteUrl(BASE_URL, row && row.banner_image || posterUrl);
        return new MultimediaItem({
            title: displayTitle(row),
            posterUrl: posterUrl,
            bannerUrl: bannerUrl,
            url: absoluteUrl(BASE_URL, "/anime/" + row.anime_id),
            type: rowType(row)
        });
    }

    function buildNextAiring(next) {
        if (!next || !next.episode || !next.airing_at) return undefined;
        var unixTime = Math.floor(Date.parse(next.airing_at) / 1000);
        if (!unixTime) return undefined;
        var payload = { episode: Number(next.episode), season: 1, unixTime: unixTime };
        return typeof NextAiring === "function" ? new NextAiring(payload) : payload;
    }

    function buildEpisodePayload(payload) {
        return JSON.stringify(payload);
    }

    function parsePayload(value) {
        if (value && typeof value === "object") return value;
        var text = trim(value);
        if (text && text.charAt(0) === "{") {
            try {
                return JSON.parse(text);
            } catch (_) {}
        }
        return null;
    }

    function getQuality(value) {
        value = String(value || "");
        var match = value.match(/(\d{3,4})p/i);
        if (match) return parseInt(match[1], 10) || 0;
        if (/4k|2160/i.test(value)) return 2160;
        if (/2k|1440/i.test(value)) return 1440;
        if (/fhd|full hd/i.test(value)) return 1080;
        if (/\bhd\b/i.test(value)) return 720;
        return 0;
    }

    function formatSource(source, quality) {
        var label = trim(source || "ReAnime") || "ReAnime";
        var q = Number(quality || 0) || 0;
        if (!q || /\[\d{3,4}p\]/i.test(label)) return label;
        return label + " [" + q + "p]";
    }

    function normalizeSubtitle(track) {
        if (!track || !track.url) return null;
        return {
            url: absoluteUrl(FLIX_URL, track.url),
            label: trim(track.language || track.label || "Subtitle") || "Subtitle",
            lang: trim(track.language || track.label || "unknown") || "unknown"
        };
    }

    function buildStreamResult(url, source, headers, quality, subtitles) {
        var stream = new StreamResult({
            url: url,
            source: formatSource(source, quality),
            quality: quality || 0,
            headers: headers || {}
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    async function expandM3u8(url, source, headers, subtitles) {
        var body = "";
        try {
            body = await httpGetText(url, headers || {});
        } catch (_) {
            body = "";
        }
        if (!/#EXTM3U/i.test(body) || body.indexOf("#EXT-X-STREAM-INF") === -1) {
            return [buildStreamResult(url, source, headers, getQuality(url), subtitles)];
        }
        var lines = body.split(/\r?\n/);
        var out = [];
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i];
            if (line.indexOf("#EXT-X-STREAM-INF") !== 0) continue;
            var next = "";
            for (var j = i + 1; j < lines.length; j++) {
                if (trim(lines[j]) && trim(lines[j]).charAt(0) !== "#") {
                    next = trim(lines[j]);
                    break;
                }
            }
            if (!next) continue;
            var match = line.match(/RESOLUTION=\d+x(\d+)/i);
            var quality = match ? parseInt(match[1], 10) : getQuality(next);
            out.push(buildStreamResult(absoluteUrl(url, next), source, headers, quality || 0, subtitles));
        }
        if (!out.length) return [buildStreamResult(url, source, headers, getQuality(url), subtitles)];
        return uniqueBy(out, function (item) { return item.url; }).sort(function (a, b) {
            return Number(b.quality || 0) - Number(a.quality || 0);
        });
    }

    async function fetchHomeData() {
        if (HOME_CACHE.value && Date.now() - HOME_CACHE.time < 180000) return HOME_CACHE.value;
        var html = await httpGetText(BASE_URL + "/home", MAIN_HEADERS);
        var homeData = extractObjectByKey(html, "homeData");
        if (!homeData) throw new Error("ReAnime home data not found");
        HOME_CACHE = { value: homeData, time: Date.now() };
        return homeData;
    }

    async function fetchAnimeDetail(slug) {
        var cached = cacheGet(DETAIL_CACHE, slug, 300000);
        if (cached) return cached;
        var html = await httpGetText(BASE_URL + "/anime/" + slug, MAIN_HEADERS);
        var anime = extractObjectByKey(html, "anime");
        if (!anime) throw new Error("ReAnime anime data not found");
        anime._html = html;
        return cacheSet(DETAIL_CACHE, slug, anime);
    }

    async function fetchSearch(query, limit) {
        var cacheKey = String(query || "") + "::" + String(limit || 24);
        var cached = cacheGet(API_CACHE, cacheKey, 120000);
        if (cached) return cached;
        var json = await httpGetJson(BASE_URL + "/api/search?q=" + encodeURIComponent(query || "") + "&limit=" + encodeURIComponent(limit || 24), MAIN_HEADERS);
        return cacheSet(API_CACHE, cacheKey, json);
    }

    async function fetchEpisodes(slug) {
        return httpGetJson(BASE_URL + "/api/episodes/" + encodeURIComponent(slug), MAIN_HEADERS);
    }

    function mapRows(list, filterWatchable) {
        return uniqueBy((list || []).filter(function (row) {
            if (!row || !row.anime_id) return false;
            if (!filterWatchable) return true;
            return row.can_watch || subtitleCount(row) > 0 || dubCount(row) > 0;
        }).map(buildCard), function (item) {
            return item.url;
        });
    }

    async function getHome(cb) {
        try {
            var homeData = await fetchHomeData();
            var data = {};
            data["Trending"] = mapRows(homeData.trending || homeData.popular || [], true).slice(0, 24);
            data["Latest Aired"] = mapRows(homeData.latest_aired || [], true).slice(0, 24);
            data["Popular"] = mapRows(homeData.most_popular || homeData.top_popular || [], true).slice(0, 24);
            if (!data["Popular"].length) {
                var popularApi = await httpGetJson(BASE_URL + "/api/search?sort=popularity_desc&limit=24", MAIN_HEADERS).catch(function () { return { results: [] }; });
                data["Popular"] = mapRows(popularApi && popularApi.results || [], true).slice(0, 24);
            }
            data["Upcoming"] = mapRows(homeData.upcoming || homeData.top_upcoming || [], false).slice(0, 24);
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var json = await fetchSearch(query || "", 40);
            cb({ success: true, data: mapRows(json && json.results || [], true) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var watchUrl = absoluteUrl(BASE_URL, url);
            var slug = trim(watchUrl.split("/anime/")[1] || "").split(/[?#]/)[0];
            if (!slug) throw new Error("ReAnime slug not found");

            var anime = await fetchAnimeDetail(slug);
            var episodesJson = await fetchEpisodes(slug).catch(function () { return { data: [] }; });
            var episodeRows = episodesJson && episodesJson.data || [];
            var isMovie = /movie/i.test(String(anime.format || "")) || episodeRows.length <= 1;
            var title = trim(anime.title && (anime.title.english || anime.title.user_preferred || anime.title.romaji || anime.title.native)) || slug;
            var originalTitle = trim(anime.title && (anime.title.romaji || anime.title.native || anime.title.english)) || title;
            var posterUrl = absoluteUrl(BASE_URL, anime.cover_image && (anime.cover_image.extra_large || anime.cover_image.large || anime.cover_image.medium) || "");
            var bannerUrl = absoluteUrl(BASE_URL, anime.banner_image || posterUrl);
            var item = new MultimediaItem({
                title: title,
                originalTitle: originalTitle,
                posterUrl: posterUrl,
                bannerUrl: bannerUrl,
                description: cleanText(anime.description || ""),
                year: Number(anime.season_year || 0) || 0,
                type: "anime",
                nextAiring: buildNextAiring(anime.next_airing_episode),
                syncData: typeof SyncData === "function" ? new SyncData({
                    animeId: String(anime.anilist_id || ""),
                    imdbId: trim(anime.imdb_id || ""),
                    malId: String(anime.mal_id || "")
                }) : {
                    animeId: String(anime.anilist_id || ""),
                    imdbId: trim(anime.imdb_id || ""),
                    malId: String(anime.mal_id || "")
                }
            });

            if (isMovie) {
                item.episodes = [new Episode({
                    name: "Movie",
                    season: 1,
                    episode: 1,
                    posterUrl: posterUrl,
                    url: buildEpisodePayload({
                        slug: slug,
                        title: title,
                        originalTitle: originalTitle,
                        anilistId: Number(anime.anilist_id || 0) || 0,
                        episode: 1,
                        isMovie: true
                    })
                })];
            } else {
                item.episodes = episodeRows.map(function (row) {
                    var epNum = Number(row.episode_number || 0) || 0;
                    return new Episode({
                        name: trim(row.title || "") || ("Episode " + epNum),
                        season: 1,
                        episode: epNum,
                        posterUrl: row.thumbnail || posterUrl,
                        url: buildEpisodePayload({
                            slug: slug,
                            title: title,
                            originalTitle: originalTitle,
                            anilistId: Number(anime.anilist_id || 0) || 0,
                            episode: epNum,
                            isMovie: false
                        })
                    });
                });
            }

            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    async function resolveFlixCloud(server) {
        var pageUrl = absoluteUrl(FLIX_URL, server && server.dataLink || "");
        if (!pageUrl) return [];
        var pageHtml = await httpGetText(pageUrl, {
            "User-Agent": USER_AGENT,
            "Referer": FLIX_URL + "/",
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
        });
        if (!pageHtml) return [];
        var data = extractInlineDataObject(pageHtml);
        if (!data) return [];

        var subtitles = uniqueBy((data.subtitles || []).map(normalizeSubtitle).filter(Boolean), function (item) {
            return item.url;
        });
        delete data.subtitles;

        var resolved = await httpPostJson(ENC_DEC_URL + "?type=resolve", { data: data }, {
            "Referer": FLIX_URL + "/",
            "Origin": "https://enc-dec.app"
        });
        if (!resolved || !resolved.result || !resolved.result.token || !resolved.result.state) return [];

        var tokenResponse = await httpGetJson(FLIX_URL + "/api/m3u8/" + encodeURIComponent(resolved.result.token), {
            "User-Agent": USER_AGENT,
            "Referer": FLIX_URL + "/",
            "Accept": "*/*"
        });
        var decrypted = await httpPostJson(ENC_DEC_URL + "?type=decrypt", {
            data: {
                state: resolved.result.state,
                token_response: tokenResponse
            }
        }, {
            "Referer": FLIX_URL + "/",
            "Origin": "https://enc-dec.app"
        });
        var streamUrl = decrypted && decrypted.result && decrypted.result.stream || "";
        if (!streamUrl) return [];

        var source = "ReAnime [" + String(server.dataType || "sub").toUpperCase() + "] [" + trim(server.serverName || "FlixCloud") + "]";
        var headers = {
            "User-Agent": USER_AGENT,
            "Referer": FLIX_URL + "/"
        };
        if (/\.m3u8(?:$|[?#])/i.test(streamUrl)) {
            return expandM3u8(streamUrl, source, headers, subtitles);
        }
        return [buildStreamResult(streamUrl, source, headers, getQuality(streamUrl), subtitles)];
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parsePayload(url);
            if (!payload) throw new Error("Invalid ReAnime payload");
            var slug = trim(payload.slug || "");
            var episode = Number(payload.episode || 1) || 1;
            var anilistId = Number(payload.anilistId || 0) || 0;
            if (!slug) throw new Error("ReAnime payload slug missing");
            if (!anilistId) {
                var anime = await fetchAnimeDetail(slug);
                anilistId = Number(anime.anilist_id || 0) || 0;
            }
            if (!anilistId) return cb({ success: true, data: [] });

            var flix = await httpGetJson(BASE_URL + "/api/flix/" + encodeURIComponent(anilistId) + "/" + encodeURIComponent(episode), MAIN_HEADERS);
            var servers = flix && flix.servers || [];
            var all = [];
            for (var i = 0; i < servers.length; i++) {
                try {
                    var resolved = await resolveFlixCloud(servers[i]);
                    Array.prototype.push.apply(all, resolved);
                } catch (_) {}
            }
            all = uniqueBy(all, function (item) { return item && item.url; }).sort(function (a, b) {
                return Number(b.quality || 0) - Number(a.quality || 0);
            });
            cb({ success: true, data: all });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
