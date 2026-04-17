(function () {
    "use strict";

    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var DOMAINS_JSON_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var domainsCache = null;

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

        if (method === "POST" && typeof http_post === "function") {
            var attempts = [
                function () { return http_post(url, headers, body); },
                function () { return http_post(url, body, headers); }
            ];
            return (async function () {
                var lastError = null;
                for (var i = 0; i < attempts.length; i++) {
                    try {
                        var res = await attempts[i]();
                        return {
                            status: responseStatus(res) || 200,
                            body: res && typeof res.body !== "undefined" ? res.body : "",
                            headers: parseHeaders(res && res.headers),
                            finalUrl: (res && (res.url || res.finalUrl)) || url
                        };
                    } catch (error) {
                        lastError = error;
                    }
                }
                throw lastError || new Error("POST failed: " + url);
            })();
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

    function baseOrigin(url) {
        try {
            var parsed = new URL(url);
            return parsed.protocol + "//" + parsed.host;
        } catch (_) {
            return "";
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

    function extractBlocks(html, tagName) {
        var blocks = [];
        var regex = new RegExp("<" + tagName + "\\b[\\s\\S]*?<\\/" + tagName + ">", "gi");
        var match;
        while ((match = regex.exec(String(html || "")))) {
            blocks.push(match[0]);
        }
        return blocks;
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

    async function getDynamicDomain(key, fallback) {
        if (!domainsCache) {
            try {
                domainsCache = await getJson(DOMAINS_JSON_URL, commonHeaders({ "Accept": "application/json" }));
            } catch (_) {
                domainsCache = {};
            }
        }
        return trim(String(domainsCache && domainsCache[key] || fallback || "")).replace(/\/+$/g, "");
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
                isMovie: isMovie
            }),
            posterUrl: tmdbImage(item.poster_path),
            bannerUrl: tmdbImage(item.backdrop_path),
            description: item.overview || "",
            year: year,
            type: isMovie ? "movie" : "tvseries"
        });
    }

    async function buildHomeSection(path, mediaType) {
        var json = await getTmdbJson(path);
        var rows = json && json.results || [];
        return rows.slice(0, 20).map(function (item) {
            item.media_type = item.media_type || mediaType || "tv";
            return tmdbItemToCard(item);
        });
    }

    async function getHome(cb) {
        try {
            cb({
                success: true,
                data: {
                    "Trending Movies": await buildHomeSection("trending/movie/week?api_key=" + TMDB_API_KEY, "movie"),
                    "Popular Movies": await buildHomeSection("movie/popular?api_key=" + TMDB_API_KEY, "movie"),
                    "Popular Series": await buildHomeSection("tv/popular?api_key=" + TMDB_API_KEY, "tv")
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
                return item && (item.media_type === "movie" || item.media_type === "tv");
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
            var detailPath = (isMovie ? "movie/" : "tv/") + payload.tmdbId + "?api_key=" + TMDB_API_KEY + "&append_to_response=external_ids";
            var details = await getTmdbJson(detailPath);
            var imdbId = trim(details && details.external_ids && details.external_ids.imdb_id || "");
            var item = new MultimediaItem({
                title: details.title || details.name || payload.title,
                url: buildPayload({
                    mode: "tmdb",
                    tmdbId: payload.tmdbId,
                    mediaType: payload.mediaType,
                    title: details.title || details.name || payload.title,
                    originalTitle: details.original_title || details.original_name || payload.originalTitle || payload.title,
                    year: Number(String(details.release_date || details.first_air_date || "").slice(0, 4)) || payload.year || 0,
                    imdbId: imdbId,
                    isMovie: isMovie
                }),
                posterUrl: tmdbImage(details.poster_path),
                bannerUrl: tmdbImage(details.backdrop_path),
                description: details.overview || "",
                year: Number(String(details.release_date || details.first_air_date || "").slice(0, 4)) || payload.year || 0,
                type: isMovie ? "movie" : "tvseries"
            });

            if (!isMovie) {
                var seasons = [];
                var seasonRows = details.seasons || [];
                for (var i = 0; i < seasonRows.length; i++) {
                    var season = seasonRows[i];
                    if (!season || !season.season_number || season.season_number <= 0) continue;
                    var seasonInfo = await getTmdbJson("tv/" + payload.tmdbId + "/season/" + season.season_number + "?api_key=" + TMDB_API_KEY);
                    var episodes = seasonInfo && seasonInfo.episodes || [];
                    for (var j = 0; j < episodes.length; j++) {
                        var episode = episodes[j];
                        seasons.push(new Episode({
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
                                imdbId: imdbId,
                                isMovie: false,
                                season: season.season_number,
                                episode: episode.episode_number
                            })
                        }));
                    }
                }
                item.episodes = seasons;
            }

            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    function parseWpArticleCard(block, base) {
        var href = firstMatch(block, [
            /<h2\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*post-image[^"']*["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*>/i
        ]);
        if (!href) return null;
        var rawTitle = stripTags(firstMatch(block, [
            /<h2\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /\btitle=["']([^"']+)["']/i,
            /<img\b[^>]*alt=["']([^"']+)["']/i
        ]));
        if (!rawTitle) return null;
        return {
            title: trim(rawTitle.split(" |")[0]),
            year: Number(firstMatch(rawTitle, [/\((\d{4})\)/])) || undefined,
            type: /season|series|tv/i.test(rawTitle) ? "series" : "movie",
            url: absoluteUrl(base, href)
        };
    }

    function parseWpArticleResults(html, base) {
        return extractBlocks(html, "article").map(function (block) {
            return parseWpArticleCard(block, base);
        }).filter(Boolean);
    }

    function normalizeResolvedUrl(rawValue, base) {
        var value = String(rawValue || "");
        if (!value) return "";
        value = decodeHtml(value)
            .replace(/\\\//g, "/")
            .replace(/^["'`(]+/, "")
            .replace(/["'`),;]+$/, "");
        if (/^\/\//.test(value)) value = "https:" + value;
        if (/^www\./i.test(value)) value = "https://" + value;
        if (!/^https?:\/\//i.test(value) && base) value = absoluteUrl(base, value);
        return value;
    }

    function isCommonDirectMediaUrl(url) {
        var value = String(url || "");
        return /\.(?:m3u8|mp4|mkv|webm|avi|mpd)(?:[?#].*)?$/i.test(value)
            || /hdm2\.ink\/playlist\//i.test(value);
    }

    function buildResolvedStream(url, source, quality, headers) {
        return {
            url: url,
            source: source || "HDMovie2",
            quality: quality || qualityFromText(url),
            headers: headers || {}
        };
    }

    function extractInterestingUrls(html, base) {
        var out = [];
        var regex = /(?:href|src)=["']([^"']+)["']/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var value = normalizeResolvedUrl(match[1], base);
            if (!value) continue;
            out.push(value);
        }
        return uniqueBy(out, function (item) { return item; });
    }

    async function resolveHdm2Play(url, label) {
        var headers = commonHeaders({ "Referer": baseOrigin(url) + "/" });
        var html = await getText(url, headers, true).catch(function () { return ""; });
        if (!html) return [];
        var streamPath = normalizeResolvedUrl(firstMatch(html, [/data-stream-url=["']([^"']+)["']/i]), baseOrigin(url));
        if (!streamPath) return [];
        var title = decodeHtml(firstMatch(html, [/data-player-title=["']([^"']+)["']/i])) || label || "HDMovie2";
        return [buildResolvedStream(streamPath, label || "HDMovie2", qualityFromText(title), commonHeaders({
            "Referer": url,
            "Origin": baseOrigin(url)
        }))];
    }

    async function resolveGenericPage(url, label, depth) {
        if (depth > 3) return [];
        var res = await request(url, { headers: commonHeaders({ "Referer": baseOrigin(url) + "/" }), allowRedirects: true }).catch(function () { return null; });
        var finalUrl = res && res.finalUrl || url;
        var html = res ? String(res.body || "") : "";
        var candidates = extractInterestingUrls(html, baseOrigin(finalUrl)).filter(function (item) {
            return item && item !== url;
        });
        var out = [];
        for (var i = 0; i < candidates.length; i++) {
            out = out.concat(await resolveCommonExtractorUrl(candidates[i], label, depth + 1));
        }
        return out;
    }

    async function resolveCommonExtractorUrl(url, label, depth) {
        var normalized = normalizeResolvedUrl(url, "");
        if (!normalized) return [];
        if (isCommonDirectMediaUrl(normalized)) {
            return [buildResolvedStream(normalized, label || "HDMovie2", qualityFromText(normalized), commonHeaders())];
        }
        if (/hdm2\.ink\/play/i.test(normalized)) return resolveHdm2Play(normalized, label || "HDMovie2");
        return resolveGenericPage(normalized, label || "HDMovie2", depth || 0);
    }

    async function getMainUrl() {
        return getDynamicDomain("hdmovie2", "https://hdmovie2.restaurant");
    }

    async function searchTitles(queries) {
        var mainUrl = await getMainUrl();
        for (var i = 0; i < queries.length; i++) {
            var query = trim(queries[i]);
            if (!query) continue;
            try {
                var html = await getText(mainUrl + "/?s=" + encodeURIComponent(query), commonHeaders({ "Referer": mainUrl + "/" }), true);
                var results = parseWpArticleResults(html, mainUrl);
                if (results.length) return results;
            } catch (_) {}
        }
        return [];
    }

    function parsePlayerOptions(html) {
        var out = [];
        var regex = /<li\b[^>]*class=["'][^"']*dooplay_player_option[^"']*["'][^>]*data-(?:type|post|nume)=["'][^"']+["'][^>]*>/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var start = match.index;
            var end = html.indexOf("</li>", start);
            if (end === -1) continue;
            var block = html.slice(start, end + 5);
            var nume = firstMatch(block, [/data-nume=["']([^"']+)["']/i]);
            var postId = firstMatch(block, [/data-post=["']([^"']+)["']/i]);
            var type = firstMatch(block, [/data-type=["']([^"']+)["']/i]);
            var title = stripTags(firstMatch(block, [/<span[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/span>/i]));
            if (!nume || !postId || !type || /trailer/i.test(nume)) continue;
            out.push({ nume: nume, postId: postId, type: type, title: title || ("Server " + nume) });
        }
        return uniqueBy(out, function (item) { return item.nume; });
    }

    function dedupeStreams(list) {
        return uniqueBy((list || []).filter(function (item) { return item && item.url; }), function (item) {
            return item.url + "|" + JSON.stringify(item.headers || {});
        });
    }

    function sortStreams(list) {
        return list.slice().sort(function (a, b) { return Number(b.quality || 0) - Number(a.quality || 0); });
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parsePayload(url);
            var queries = uniqueBy([payload.title, payload.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = bestMatch(rows, queries, payload.year, payload.isMovie ? "movie" : null);
            if (!match || !match.url) return cb({ success: true, data: [] });
            var pageHtml = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            if (!pageHtml) return cb({ success: true, data: [] });

            var options = parsePlayerOptions(pageHtml);
            var streams = [];
            for (var i = 0; i < options.length; i++) {
                var form = "action=doo_player_ajax&post=" + encodeURIComponent(options[i].postId)
                    + "&nume=" + encodeURIComponent(options[i].nume)
                    + "&type=" + encodeURIComponent(options[i].type);
                var res = await request((await getMainUrl()) + "/wp-admin/admin-ajax.php", {
                    method: "POST",
                    body: form,
                    headers: commonHeaders({
                        "Referer": match.url,
                        "Origin": await getMainUrl(),
                        "X-Requested-With": "XMLHttpRequest",
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                    })
                }).catch(function () { return null; });
                var json = res ? parseJsonSafe(res.body, {}) : {};
                var embedUrl = normalizeResolvedUrl(firstMatch(String(json && json.embed_url || ""), [/<iframe[^>]+src=["']([^"']+)["']/i]), match.url);
                if (!embedUrl) continue;
                var resolved = await resolveCommonExtractorUrl(embedUrl, "HDMovie2", 0);
                for (var j = 0; j < resolved.length; j++) {
                    if (!resolved[j].quality) resolved[j].quality = qualityFromText(options[i].title || match.title);
                    streams.push(resolved[j]);
                }
            }
            cb({ success: true, data: sortStreams(dedupeStreams(streams)).map(function (item) { return new StreamResult(item); }) });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
