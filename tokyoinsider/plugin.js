(function () {
    "use strict";

    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var MAIN_URL = "https://www.tokyoinsider.com";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var NEXT_AIRING_CACHE = {};

    function trim(value) {
        return String(value == null ? "" : value).replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function decodeHtml(value) {
        return trim(String(value == null ? "" : value)
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&#039;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">"));
    }

    function stripTags(value) {
        return decodeHtml(String(value == null ? "" : value).replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "));
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function parseHeaders(rawHeaders) {
        var headers = {};
        if (!rawHeaders) return headers;
        if (typeof rawHeaders.forEach === "function") {
            rawHeaders.forEach(function (value, key) {
                headers[String(key).toLowerCase()] = value;
            });
            return headers;
        }
        for (var key in rawHeaders) {
            if (!Object.prototype.hasOwnProperty.call(rawHeaders, key)) continue;
            headers[String(key).toLowerCase()] = rawHeaders[key];
        }
        return headers;
    }

    function cacheGet(cache, key, ttl) {
        var entry = cache[key];
        if (!entry) return null;
        if (Date.now() - entry.time > (ttl || 1800000)) {
            delete cache[key];
            return null;
        }
        return entry.value;
    }

    function cacheSet(cache, key, value) {
        cache[key] = { value: value, time: Date.now() };
        return value;
    }

    async function postJson(url, payload, headers) {
        var body = JSON.stringify(payload || {});
        var mergedHeaders = Object.assign({
            "Content-Type": "application/json",
            "Accept": "application/json",
            "User-Agent": COMMON_USER_AGENT
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
        if (Object.prototype.hasOwnProperty.call(NEXT_AIRING_CACHE, cacheKey)) {
            return cacheGet(NEXT_AIRING_CACHE, cacheKey, 1800000);
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
            return cacheSet(NEXT_AIRING_CACHE, cacheKey, buildNextAiring(next && next.episode, 1, next && next.airingAt) || null);
        } catch (_) {
            return cacheSet(NEXT_AIRING_CACHE, cacheKey, null);
        }
    }

    function responseStatus(res) {
        if (!res) return 0;
        if (typeof res.status === "number") return res.status;
        if (typeof res.statusCode === "number") return res.statusCode;
        return 0;
    }

    function requestWithFetch(url, method, headers, body, allowRedirects) {
        return fetch(url, {
            method: method,
            headers: headers,
            body: body,
            redirect: allowRedirects ? "follow" : "manual"
        }).then(function (res) {
            return res.text().then(function (bodyText) {
                return {
                    status: res.status,
                    body: bodyText,
                    headers: parseHeaders(res.headers),
                    finalUrl: res.url || url
                };
            });
        });
    }

    function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || {};
        var body = options.body;
        var allowRedirects = options.allowRedirects !== false;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                return {
                    status: responseStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        return requestWithFetch(url, method, headers, body, allowRedirects);
    }

    function getText(url, headers, allowRedirects) {
        return request(url, { headers: headers || {}, allowRedirects: allowRedirects }).then(function (res) {
            if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
            return String(res.body || "");
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers || {} }).then(function (res) {
            if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
            return parseJsonSafe(res.body, {});
        });
    }

    function absoluteUrl(base, path) {
        if (!path) return "";
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function firstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return trim(match[1]);
        }
        return "";
    }

    function parseAnchors(html, base) {
        var source = String(html || "");
        var out = [];
        var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = regex.exec(source))) {
            out.push({
                href: absoluteUrl(base, decodeHtml(match[1])),
                text: stripTags(match[2])
            });
        }
        return out;
    }

    function qualityFromText(text) {
        var value = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b|\buhd\b/.test(value)) return 2160;
        if (/\b1080p\b/.test(value)) return 1080;
        if (/\b720p\b/.test(value)) return 720;
        if (/\b480p\b/.test(value)) return 480;
        if (/\b360p\b/.test(value)) return 360;
        return 0;
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function normalizeTitle(value) {
        return trim(String(value || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/\b(the|a|an)\b/g, " ")
            .replace(/[^a-z0-9]+/g, " "));
    }

    function titleScore(candidate, queries) {
        var cand = normalizeTitle(candidate);
        if (!cand) return 0;
        var best = 0;
        for (var i = 0; i < queries.length; i++) {
            var query = normalizeTitle(queries[i]);
            if (!query) continue;
            if (cand === query) best = Math.max(best, 100);
            else if (cand.indexOf(query) !== -1 || query.indexOf(cand) !== -1) best = Math.max(best, 75);
        }
        return best;
    }

    function bestMatch(list, queries, year, typeHint) {
        var ranked = [];
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var score = titleScore(item && item.title, queries);
            if (score <= 0) continue;
            if (year && item && item.year) {
                if (String(item.year) === String(year)) score += 18;
                else if (Math.abs(Number(item.year) - Number(year)) <= 1) score += 8;
            }
            if (typeHint && item && item.type && String(item.type) === String(typeHint)) score += 5;
            ranked.push({ item: item, score: score });
        }
        ranked.sort(function (a, b) { return b.score - a.score; });
        return ranked.length ? ranked[0].item : null;
    }

    function commonHeaders(extra) {
        return Object.assign({
            "User-Agent": COMMON_USER_AGENT,
            "Accept": "*/*"
        }, extra || {});
    }

    function buildPayload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed && typeof parsed === "object") return parsed;
        throw new Error("Invalid payload");
    }

    var TMDB_CACHE_TTL = 5 * 60 * 1000;
    var tmdbCache = Object.create(null);
    var tmdbInflight = Object.create(null);

    async function httpParallelGet(requests) {
        var items = Array.isArray(requests) ? requests.filter(function (item) { return item && item.url; }) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var parallelRes = await http_parallel(items.map(function (item) {
                    return {
                        method: "GET",
                        url: item.url,
                        headers: item.headers || {}
                    };
                }));
                return (parallelRes || []).map(function (res, index) {
                    return {
                        status: responseStatus(res) || 200,
                        body: res && typeof res.body !== "undefined" ? res.body : "",
                        headers: parseHeaders(res && res.headers),
                        finalUrl: (res && (res.url || res.finalUrl)) || items[index].url
                    };
                });
            } catch (_) {}
        }
        return Promise.all(items.map(function (item) {
            return request(item.url, { headers: item.headers || {} }).catch(function () {
                return { status: 599, body: "", headers: {}, finalUrl: item.url };
            });
        }));
    }

    async function getTmdbJson(path) {
        var normalized = String(path || "").replace(/^\/+/, "");
        var now = Date.now();
        var cached = tmdbCache[normalized];
        if (cached && (now - cached.at) < TMDB_CACHE_TTL) return cached.data;
        if (tmdbInflight[normalized]) return tmdbInflight[normalized];

        tmdbInflight[normalized] = (async function () {
            var urls = [
                TMDB_WORKER_API + "/" + normalized,
                TMDB_API + "/" + normalized
            ];
            var lastError = null;
            for (var i = 0; i < urls.length; i++) {
                try {
                    var data = await getJson(urls[i]);
                    if (data && typeof data === "object" && Object.keys(data).length) {
                        tmdbCache[normalized] = { at: Date.now(), data: data };
                    }
                    return data;
                } catch (error) {
                    lastError = error;
                }
            }
            throw lastError || new Error("TMDB request failed: " + normalized);
        })();

        try {
            return await tmdbInflight[normalized];
        } finally {
            delete tmdbInflight[normalized];
        }
    }

    async function getManyTmdbJson(paths) {
        var normalized = (paths || []).map(function (path) { return String(path || "").replace(/^\/+/, ""); });
        var results = new Array(normalized.length);
        var requests = [];
        var now = Date.now();

        normalized.forEach(function (path, index) {
            var cached = tmdbCache[path];
            if (cached && (now - cached.at) < TMDB_CACHE_TTL) {
                results[index] = cached.data;
            } else if (tmdbInflight[path]) {
                results[index] = tmdbInflight[path];
            } else {
                requests.push({ index: index, path: path, url: TMDB_WORKER_API + "/" + path });
            }
        });

        if (requests.length) {
            var workerResponses = await httpParallelGet(requests.map(function (item) {
                return { url: item.url, headers: commonHeaders() };
            }));
            await Promise.all(requests.map(async function (item, idx) {
                var res = workerResponses[idx] || {};
                var ok = (responseStatus(res) || 0) < 400;
                var parsed = ok ? parseJsonSafe(res.body, null) : null;
                if (parsed && typeof parsed === "object" && Object.keys(parsed).length) {
                    tmdbCache[item.path] = { at: Date.now(), data: parsed };
                    results[item.index] = parsed;
                    return;
                }
                try {
                    var fallback = await getJson(TMDB_API + "/" + item.path);
                    if (fallback && typeof fallback === "object" && Object.keys(fallback).length) {
                        tmdbCache[item.path] = { at: Date.now(), data: fallback };
                    }
                    results[item.index] = fallback;
                } catch (_) {
                    results[item.index] = {};
                }
            }));
        }

        for (var i = 0; i < results.length; i++) {
            if (results[i] && typeof results[i].then === "function") {
                try {
                    results[i] = await results[i];
                } catch (_) {
                    results[i] = {};
                }
            }
            if (!results[i]) results[i] = {};
        }
        return results;
    }

    function tmdbImage(path) {
        return path ? (TMDB_IMAGE + path) : "";
    }

    function isAnimeItem(item) {
        var genreIds = item.genre_ids || [];
        var genres = item.genres || [];
        var originalLanguage = String(item.original_language || "");
        var originalCountry = item.origin_country || [];
        var hasAnimation = genreIds.indexOf(16) !== -1 || genres.some(function (genre) { return Number(genre.id) === 16; });
        return hasAnimation && (originalLanguage === "ja" || originalCountry.indexOf("JP") !== -1 || item.media_type === "tv" || item.media_type === "movie");
    }

    function tmdbItemToCard(item) {
        var isMovie = String(item.media_type || item.mediaType || "") === "movie";
        var title = trim(item.title || item.name || "");
        var originalTitle = trim(item.original_title || item.original_name || title);
        var year = Number(String(item.release_date || item.first_air_date || "").slice(0, 4)) || 0;
        return new MultimediaItem({
            title: title,
            url: buildPayload({
                mode: "tmdb",
                tmdbId: item.id,
                mediaType: isMovie ? "movie" : "tv",
                title: title,
                originalTitle: originalTitle,
                year: year,
                anime: true,
                isMovie: isMovie
            }),
            posterUrl: tmdbImage(item.poster_path),
            bannerUrl: tmdbImage(item.backdrop_path),
            description: item.overview || "",
            year: year,
            type: isMovie ? "movie" : "anime"
        });
    }

    async function buildHomeSection(path) {
        var json = await getTmdbJson(path);
        var rows = json && json.results || [];
        return rows.filter(isAnimeItem).slice(0, 20).map(function (item) {
            item.media_type = item.media_type || (/\/movie/.test(path) ? "movie" : "tv");
            return tmdbItemToCard(item);
        });
    }

    async function getHome(cb) {
        try {
            var sections = [
                { title: "Popular Anime Series", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_genres=16&with_original_language=ja&sort_by=popularity.desc", mediaType: "tv" },
                { title: "Top Anime Movies", path: "discover/movie?api_key=" + TMDB_API_KEY + "&with_genres=16&with_original_language=ja&sort_by=popularity.desc", mediaType: "movie" },
                { title: "Trending Anime", path: "trending/tv/week?api_key=" + TMDB_API_KEY, mediaType: "tv" }
            ];
            var jsons = await getManyTmdbJson(sections.map(function (section) { return section.path; }));
            var data = {};
            await Promise.all(sections.map(async function (section, index) {
                var rows = (jsons[index] && jsons[index].results) || [];
                var items = rows.filter(isAnimeItem).slice(0, 20).map(function (item) {
                    item.media_type = item.media_type || section.mediaType;
                    return tmdbItemToCard(item);
                }).filter(Boolean);
                if (!items.length) {
                    try {
                        items = await buildHomeSection(section.path);
                    } catch (_) {
                        items = [];
                    }
                }
                data[section.title] = items;
            }));
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var json = await getTmdbJson("search/multi?api_key=" + TMDB_API_KEY + "&query=" + encodeURIComponent(query));
            var rows = (json && json.results || []).filter(function (item) {
                return item && (item.media_type === "movie" || item.media_type === "tv") && isAnimeItem(item);
            });
            cb({ success: true, data: rows.map(tmdbItemToCard) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var payload = parsePayload(url);
            var isMovie = String(payload.mediaType) === "movie";
            var details = await getTmdbJson((isMovie ? "movie/" : "tv/") + payload.tmdbId + "?api_key=" + TMDB_API_KEY);
            var nextAiring = !isMovie
                ? await fetchNextAiring({
                    title: details.name || details.original_name || payload.originalTitle || payload.title
                })
                : undefined;
            var item = new MultimediaItem({
                title: details.title || details.name || payload.title,
                url: buildPayload({
                    mode: "tmdb",
                    tmdbId: payload.tmdbId,
                    mediaType: payload.mediaType,
                    title: details.title || details.name || payload.title,
                    originalTitle: details.original_title || details.original_name || payload.originalTitle || payload.title,
                    year: Number(String(details.release_date || details.first_air_date || "").slice(0, 4)) || payload.year || 0,
                    anime: true,
                    isMovie: isMovie
                }),
                posterUrl: tmdbImage(details.poster_path),
                bannerUrl: tmdbImage(details.backdrop_path),
                description: details.overview || "",
                year: Number(String(details.release_date || details.first_air_date || "").slice(0, 4)) || payload.year || 0,
                type: isMovie ? "movie" : "anime",
                nextAiring: nextAiring || undefined
            });

            if (!isMovie) {
                var episodes = [];
                var seasonRows = details.seasons || [];
                for (var i = 0; i < seasonRows.length; i++) {
                    var season = seasonRows[i];
                    if (!season || !season.season_number || season.season_number <= 0) continue;
                    var seasonInfo = await getTmdbJson("tv/" + payload.tmdbId + "/season/" + season.season_number + "?api_key=" + TMDB_API_KEY);
                    var seasonEpisodes = seasonInfo && seasonInfo.episodes || [];
                    for (var j = 0; j < seasonEpisodes.length; j++) {
                        var episode = seasonEpisodes[j];
                        episodes.push(new Episode({
                            name: episode.name || ("Episode " + episode.episode_number),
                            season: season.season_number,
                            episode: episode.episode_number,
                            posterUrl: tmdbImage(episode.still_path) || tmdbImage(details.poster_path),
                            url: buildPayload({
                                mode: "tmdb",
                                tmdbId: payload.tmdbId,
                                mediaType: payload.mediaType,
                                title: details.name || payload.title,
                                originalTitle: details.original_name || payload.originalTitle || payload.title,
                                year: Number(String(details.first_air_date || "").slice(0, 4)) || payload.year || 0,
                                anime: true,
                                isMovie: false,
                                season: season.season_number,
                                episode: episode.episode_number
                            })
                        }));
                    }
                }
                item.episodes = episodes;
            } else {
                item.episodes = [new Episode({
                    name: "Movie",
                    season: 0,
                    episode: 0,
                    posterUrl: tmdbImage(details.poster_path),
                    url: buildPayload({
                        mode: "tmdb",
                        tmdbId: payload.tmdbId,
                        mediaType: payload.mediaType,
                        title: details.title || details.name || payload.title,
                        originalTitle: details.original_title || details.original_name || payload.originalTitle || payload.title,
                        year: Number(String(details.release_date || details.first_air_date || "").slice(0, 4)) || payload.year || 0,
                        anime: true,
                        isMovie: true
                    })
                })];
            }

            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    async function searchTitles(queries) {
        for (var i = 0; i < queries.length; i++) {
            var query = trim(queries[i]);
            if (!query) continue;
            try {
                var html = await getText(MAIN_URL + "/anime/search?k=" + encodeURIComponent(query), commonHeaders({ "Referer": MAIN_URL + "/anime" }), true);
                var out = [];
                var byUrl = Object.create(null);
                var regex = /<td[^>]+class=["'][^"']*c_h2b?[^"']*["'][\s\S]*?<a[^>]+href=["'](\/anime\/[^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
                var match;
                while ((match = regex.exec(html)) !== null) {
                    var href = absoluteUrl(MAIN_URL, match[1]);
                    if (/\/reviews\b/i.test(href)) continue;
                    var item = {
                        title: stripTags(match[2]),
                        url: href,
                        type: /movie|ova|special/i.test(match[2]) ? "movie" : "anime"
                    };
                    var existing = byUrl[href];
                    if (!existing) {
                        byUrl[href] = item;
                        out.push(item);
                    } else if (!trim(existing.title) && trim(item.title)) {
                        existing.title = item.title;
                        existing.type = item.type;
                    }
                }
                out = uniqueBy(out, function (item) { return item.url; });
                if (out.length) return out;
            } catch (_) {}
        }
        return [];
    }

    function isDirectMediaUrl(url) {
        return /\.(?:m3u8|mp4|mkv|webm|avi)(?:[?#].*)?$/i.test(String(url || ""));
    }

    function isSubtitleUrl(url) {
        return /\.(?:srt|vtt|ass|ssa|sub)(?:[?#].*)?$/i.test(String(url || ""));
    }

    function inferSubtitleLang(text, url) {
        var value = String(text || url || "").toLowerCase();
        if (/\beng(?:lish)?\b/.test(value)) return "en";
        if (/\bjp|jpn|japanese\b/.test(value)) return "ja";
        if (/\bhin|hindi\b/.test(value)) return "hi";
        return "unknown";
    }

    function parseSubtitleTracks(html, pageUrl) {
        return uniqueBy(parseAnchors(html, pageUrl).filter(function (row) {
            return isSubtitleUrl(row && row.href);
        }).map(function (row) {
            return {
                url: row.href,
                label: trim(row.text || "Subtitle") || "Subtitle",
                lang: inferSubtitleLang(row.text, row.href)
            };
        }), function (item) { return item.url; });
    }

    function buildStreamResult(url, source, headers, quality, subtitles) {
        var stream = new StreamResult({
            url: url,
            source: source || "TokyoInsider",
            quality: quality || 0,
            headers: headers || {}
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    async function expandM3u8(url, source, headers, subtitles) {
        var text = "";
        try {
            text = await getText(url, headers || {});
        } catch (_) {
            text = "";
        }

        if (!/#EXTM3U/i.test(text) || text.indexOf("#EXT-X-STREAM-INF") === -1) {
            return [buildStreamResult(url, source, headers, qualityFromText(url) || 0, subtitles)];
        }

        var lines = text.split(/\r?\n/);
        var streams = [];
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i];
            if (line.indexOf("#EXT-X-STREAM-INF") !== 0) continue;
            var nextLine = "";
            for (var j = i + 1; j < lines.length; j++) {
                if (lines[j] && lines[j].charAt(0) !== "#") {
                    nextLine = trim(lines[j]);
                    break;
                }
            }
            if (!nextLine) continue;
            var resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
            var quality = resMatch ? parseInt(resMatch[1], 10) : qualityFromText(nextLine);
            streams.push(buildStreamResult(absoluteUrl(url, nextLine), source, headers, quality || 0, subtitles));
        }

        if (!streams.length) {
            streams.push(buildStreamResult(url, source, headers, qualityFromText(url) || 0, subtitles));
        }
        return dedupeStreams(streams);
    }

    function parseDirectEpisodeLinks(html, pageUrl, subtitles) {
        return parseAnchors(html, pageUrl).filter(function (row) {
            return isDirectMediaUrl(row && row.href);
        }).map(function (row) {
            return {
                url: row.href,
                source: "TokyoInsider",
                quality: qualityFromText(row.text || row.href),
                headers: {},
                subtitles: subtitles || []
            };
        });
    }

    function dedupeStreams(list) {
        return uniqueBy((list || []).filter(function (item) { return item && item.url; }), function (item) { return item.url; });
    }

    function sortStreams(list) {
        return list.slice().sort(function (a, b) { return Number(b.quality || 0) - Number(a.quality || 0); });
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parsePayload(url);
            var queries = uniqueBy([payload.originalTitle, payload.title], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = bestMatch(rows, queries, payload.year, payload.isMovie ? "movie" : "anime");
            if (!match || !match.url) return cb({ success: true, data: [] });
            var targetUrl = payload.isMovie ? match.url : (match.url.replace(/\/+$/g, "") + "/episode/" + encodeURIComponent(payload.episode || 1));
            var html = await getText(targetUrl, commonHeaders({ "Referer": match.url }), true).catch(function () { return ""; });
            if (!html) return cb({ success: true, data: [] });
            var subtitles = parseSubtitleTracks(html, targetUrl);
            var directLinks = parseDirectEpisodeLinks(html, targetUrl, subtitles);
            var expanded = [];
            for (var i = 0; i < directLinks.length; i++) {
                var item = directLinks[i];
                if (/\.m3u8(?:[?#].*)?$/i.test(item.url)) {
                    var built = await expandM3u8(item.url, item.source, item.headers, item.subtitles || []);
                    Array.prototype.push.apply(expanded, built);
                } else {
                    expanded.push(buildStreamResult(item.url, item.source, item.headers, item.quality, item.subtitles || []));
                }
            }
            var streams = sortStreams(dedupeStreams(expanded));
            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
