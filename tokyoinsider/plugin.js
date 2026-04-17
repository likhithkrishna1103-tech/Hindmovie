(function () {
    "use strict";

    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var MAIN_URL = "https://www.tokyoinsider.com";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";

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

    async function getTmdbJson(path) {
        var urls = [
            TMDB_WORKER_API + "/" + String(path || "").replace(/^\/+/, ""),
            TMDB_API + "/" + String(path || "").replace(/^\/+/, "")
        ];
        var lastError = null;
        for (var i = 0; i < urls.length; i++) {
            try {
                return await getJson(urls[i]);
            } catch (error) {
                lastError = error;
            }
        }
        throw lastError || new Error("TMDB request failed");
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
            cb({
                success: true,
                data: {
                    "Popular Anime Series": await buildHomeSection("discover/tv?api_key=" + TMDB_API_KEY + "&with_genres=16&with_original_language=ja&sort_by=popularity.desc"),
                    "Top Anime Movies": await buildHomeSection("discover/movie?api_key=" + TMDB_API_KEY + "&with_genres=16&with_original_language=ja&sort_by=popularity.desc"),
                    "Trending Anime": await buildHomeSection("trending/tv/week?api_key=" + TMDB_API_KEY)
                }
            });
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
                type: isMovie ? "movie" : "anime"
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

    function parseDirectEpisodeLinks(html, pageUrl) {
        return parseAnchors(html, pageUrl).filter(function (row) {
            return isDirectMediaUrl(row && row.href);
        }).map(function (row) {
            return {
                url: row.href,
                source: "TokyoInsider",
                quality: qualityFromText(row.text || row.href),
                headers: {}
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
            var streams = sortStreams(dedupeStreams(parseDirectEpisodeLinks(html, targetUrl))).map(function (item) {
                return new StreamResult(item);
            });
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
