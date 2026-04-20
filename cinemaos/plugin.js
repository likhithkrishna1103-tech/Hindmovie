(function () {
    "use strict";

    var BASE_URL = "https://cinemaos.live";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/w500";
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";

    var PRIMARY_HMAC_KEY = "a7f3b9c2e8d4f1a6b5c9e2d7f4a8b3c6e1d9f7a4b2c8e5d3f9a6b4c1e7d2f8a5";
    var SECONDARY_HMAC_KEY = "d3f8a5b2c9e6d1f7a4b8c5e2d9f3a6b1c7e4d8f2a9b5c3e7d4f1a8b6c2e9d5f3";
    var PBKDF2_PASSWORD = "a1b2c3d4e4f6477658455678901477567890abcdef1234567890abcdef123456";
    var TMDB_API_KEY_B64 = "NTRlMDA0NjZhMDk2NzZkZjU3YmE1MWM0Y2EzMGIxYTY=";

    function decodeBase64(input) {
        var value = String(input || "");
        try {
            if (typeof atob === "function") return atob(value);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(value, "base64").toString("utf8");
        } catch (_) {}
        return "";
    }

    var TMDB_API_KEY = decodeBase64(TMDB_API_KEY_B64);

    function toErrorMessage(error) {
        return String(error && (error.stack || error.message) || error);
    }

    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">");
    }

    function defaultHeaders(extra) {
        var headers = {
            "User-Agent": USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Referer": BASE_URL + "/",
            "Origin": BASE_URL
        };
        var key;
        extra = extra || {};
        for (key in extra) {
            if (Object.prototype.hasOwnProperty.call(extra, key) && typeof extra[key] !== "undefined") {
                headers[key] = extra[key];
            }
        }
        return headers;
    }

    function parseHeaders(rawHeaders) {
        var headers = {};
        var key;
        if (!rawHeaders) return headers;
        if (typeof rawHeaders.forEach === "function") {
            rawHeaders.forEach(function (value, k) {
                headers[String(k).toLowerCase()] = value;
            });
            return headers;
        }
        for (key in rawHeaders) {
            if (Object.prototype.hasOwnProperty.call(rawHeaders, key)) {
                headers[String(key).toLowerCase()] = rawHeaders[key];
            }
        }
        return headers;
    }

    function getStatus(res) {
        if (!res) return 0;
        if (typeof res.status === "number") return res.status;
        if (typeof res.statusCode === "number") return res.statusCode;
        return 0;
    }

    function resolveUrl(base, path) {
        if (!path) return String(base || "");
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function baseOrigin(url) {
        try {
            return new URL(String(url || "")).origin;
        } catch (_) {
            return BASE_URL;
        }
    }

    function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || defaultHeaders();
        var body = typeof options.body === "undefined" ? "" : options.body;
        var followRedirects = options.followRedirects !== false;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                return {
                    status: getStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            return Promise.resolve(http_post(url, body, headers)).then(function (res) {
                return {
                    status: getStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        return fetch(url, {
            method: method,
            headers: headers,
            body: body,
            redirect: followRedirects ? "follow" : "manual"
        }).then(function (res) {
            return res.text().then(function (text) {
                return {
                    status: res.status,
                    body: text,
                    headers: parseHeaders(res.headers),
                    finalUrl: res.url || url
                };
            });
        });
    }

    function getText(url, headers) {
        return request(url, { headers: headers || defaultHeaders() }).then(function (res) {
            return String(res && res.body || "");
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers || defaultHeaders() }).then(function (res) {
            return parseJsonSafe(res && res.body || "", {});
        });
    }

    function uniqueBy(items, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (items || []).length; i++) {
            var item = items[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function extractMeta(html, prop) {
        var source = String(html || "");
        var re = new RegExp("<meta[^>]+(?:property|name)=[\"']" + prop.replace(/[.*+?^${}()|[\]\\]/g, "\\$&") + "[\"'][^>]+content=[\"']([^\"']+)[\"']", "i");
        var match = source.match(re);
        return trim(decodeHtml(match && match[1] || ""));
    }

    function htmlToRuntimeText(html) {
        return String(html || "")
            .replace(/\\u0026/gi, "&")
            .replace(/\\u0027/gi, "'")
            .replace(/\\u0022/gi, "\"")
            .replace(/\\u003d/gi, "=")
            .replace(/\\u003a/gi, ":")
            .replace(/\\\//g, "/")
            .replace(/\\"/g, "\"");
    }

    function extractPathIds(html, pattern) {
        var source = String(html || "");
        var re = new RegExp(pattern, "gi");
        var match;
        var ids = [];
        var seen = {};
        while ((match = re.exec(source)) !== null) {
            var id = String(match[1] || "");
            if (!id || seen[id]) continue;
            seen[id] = true;
            ids.push(id);
        }
        return ids;
    }

    function extractTvWatchEpisodes(html, tmdbId) {
        var source = String(html || "");
        var re = new RegExp("/tv/watch/" + tmdbId + "\\?season=(\\d+)(?:&amp;|&)episode=(\\d+)", "gi");
        var match;
        var out = [];
        var seen = {};
        while ((match = re.exec(source)) !== null) {
            var season = Number(match[1] || 0);
            var episode = Number(match[2] || 0);
            var key = season + "_" + episode;
            if (!season || !episode || seen[key]) continue;
            seen[key] = true;
            out.push({ season: season, episode: episode });
        }
        return out.sort(function (a, b) { return a.season - b.season || a.episode - b.episode; });
    }

    function extractAnimeEpisodes(html, animeId) {
        var source = String(html || "");
        var re = new RegExp("/anime/watch/" + animeId + "/(\\d+)", "gi");
        var match;
        var out = [];
        var seen = {};
        while ((match = re.exec(source)) !== null) {
            var ep = Number(match[1] || 0);
            if (!ep || seen[ep]) continue;
            seen[ep] = true;
            out.push(ep);
        }
        return out.sort(function (a, b) { return a - b; });
    }

    function extractTitleMap(html) {
        var source = htmlToRuntimeText(html);
        var re = /"id":(\d+)[\s\S]{0,320}?"(?:title|name)":"([^"]+)"/g;
        var match;
        var map = {};
        while ((match = re.exec(source)) !== null) {
            var id = String(match[1] || "");
            var title = trim(decodeHtml(match[2] || ""));
            if (!id || !title || map[id]) continue;
            if (/^(Action|Comedy|Drama|Crime|Adventure|Animation|Mystery|History|Horror|Fantasy|Western|War|Music|Documentary|Family|Romance|Thriller|News|Reality|Soap|Talk|Kids|Science Fiction|Sci-Fi)/i.test(title)) continue;
            map[id] = title;
        }
        return map;
    }

    function createHomeItem(type, id, titleMap) {
        var title = (titleMap && titleMap[id]) || ((type === "movie" ? "Movie " : type === "tv" ? "TV " : "Anime ") + id);
        var url = type === "movie"
            ? (BASE_URL + "/movie/" + id)
            : type === "tv"
                ? (BASE_URL + "/tv/" + id)
                : (BASE_URL + "/anime/" + id);
        return new MultimediaItem({
            title: title,
            url: url,
            type: type === "movie" ? "movie" : (type === "tv" ? "series" : "anime"),
            headers: defaultHeaders({ "Referer": BASE_URL + "/" })
        });
    }

    function moviePayload(watchUrl, tmdbId) {
        return JSON.stringify({
            watchUrl: watchUrl,
            type: "movie",
            tmdbId: String(tmdbId || "")
        });
    }

    function tvPayload(watchUrl, tmdbId, season, episode) {
        return JSON.stringify({
            watchUrl: watchUrl,
            type: "tv",
            tmdbId: String(tmdbId || ""),
            season: Number(season || 0),
            episode: Number(episode || 0)
        });
    }

    function animePayload(watchUrl, animeId, episode) {
        return JSON.stringify({
            watchUrl: watchUrl,
            type: "anime",
            animeId: String(animeId || ""),
            episode: Number(episode || 0)
        });
    }

    function parseLoadInput(input) {
        if (input && typeof input === "object" && input.watchUrl) return input;
        var parsed = parseJsonSafe(input, null);
        if (parsed && typeof parsed === "object") return parsed;
        return { watchUrl: String(input || "") };
    }

    function parseWatchInfo(watchUrl) {
        var url = String(watchUrl || "");
        var movieMatch = url.match(/\/movie\/watch\/(\d+)/i);
        if (movieMatch) {
            return { type: "movie", tmdbId: movieMatch[1], season: null, episode: null };
        }
        var tvMatch = url.match(/\/tv\/watch\/(\d+)\?season=(\d+)&episode=(\d+)/i);
        if (tvMatch) {
            return { type: "tv", tmdbId: tvMatch[1], season: Number(tvMatch[2]), episode: Number(tvMatch[3]) };
        }
        var animeMatch = url.match(/\/anime\/watch\/(\d+)\/(\d+)/i);
        if (animeMatch) {
            return { type: "anime", tmdbId: animeMatch[1], season: 1, episode: Number(animeMatch[2]) };
        }
        return null;
    }

    function textToBytes(text) {
        return new TextEncoder().encode(String(text || ""));
    }

    function hexToBytes(hex) {
        var clean = String(hex || "").replace(/[^0-9a-f]/gi, "");
        var out = new Uint8Array(clean.length / 2);
        for (var i = 0; i < out.length; i++) {
            out[i] = parseInt(clean.substr(i * 2, 2), 16);
        }
        return out;
    }

    function bytesToHex(bytes) {
        var out = [];
        for (var i = 0; i < bytes.length; i++) {
            out.push(bytes[i].toString(16).padStart(2, "0"));
        }
        return out.join("");
    }

    async function hmacSha256Hex(keyText, message) {
        if (!crypto || !crypto.subtle) return "";
        var key = await crypto.subtle.importKey(
            "raw",
            textToBytes(keyText),
            { name: "HMAC", hash: "SHA-256" },
            false,
            ["sign"]
        );
        var sig = await crypto.subtle.sign("HMAC", key, textToBytes(message));
        return bytesToHex(new Uint8Array(sig));
    }

    function concatBytes(a, b) {
        var out = new Uint8Array(a.length + b.length);
        out.set(a, 0);
        out.set(b, a.length);
        return out;
    }

    async function decryptProviderPayload(data) {
        if (!crypto || !crypto.subtle) return null;
        var encryptedHex = data && data.encrypted || "";
        var ivHex = data && data.cin || "";
        var tagHex = data && data.mao || "";
        var saltHex = data && data.salt || "";
        if (!encryptedHex || !ivHex || !tagHex || !saltHex) return null;

        var passKey = await crypto.subtle.importKey(
            "raw",
            textToBytes(PBKDF2_PASSWORD),
            { name: "PBKDF2" },
            false,
            ["deriveBits"]
        );
        var aesBits = await crypto.subtle.deriveBits({
            name: "PBKDF2",
            salt: hexToBytes(saltHex),
            iterations: 100000,
            hash: "SHA-256"
        }, passKey, 256);

        var aesKey = await crypto.subtle.importKey(
            "raw",
            aesBits,
            { name: "AES-GCM" },
            false,
            ["decrypt"]
        );

        var cipher = concatBytes(hexToBytes(encryptedHex), hexToBytes(tagHex));
        var plain = await crypto.subtle.decrypt({
            name: "AES-GCM",
            iv: hexToBytes(ivHex),
            tagLength: 128
        }, aesKey, cipher);
        return new TextDecoder().decode(new Uint8Array(plain));
    }

    async function fetchImdbId(type, tmdbId) {
        var lookupType = type === "movie" ? "movie" : "tv";
        var url = "https://api.themoviedb.org/3/" + lookupType + "/" + tmdbId + "?api_key=" + encodeURIComponent(TMDB_API_KEY) + "&append_to_response=external_ids";
        var data = await getJson(url, defaultHeaders({ "Referer": "https://www.themoviedb.org/" }));
        return (data && data.imdb_id) || (data && data.external_ids && data.external_ids.imdb_id) || "";
    }

    async function resolveProviderV3(watchInfo, watchUrl) {
        try {
            if (!watchInfo || !watchInfo.tmdbId) return [];
            var imdbId = await fetchImdbId(watchInfo.type, watchInfo.tmdbId);
            if (!imdbId) return [];

            var message = "tmdbId:" + watchInfo.tmdbId + "|imdbId:" + imdbId;
            if (watchInfo.season && watchInfo.episode) {
                message += "|seasonId:" + watchInfo.season + "|episodeId:" + watchInfo.episode;
            }
            var primary = await hmacSha256Hex(PRIMARY_HMAC_KEY, message);
            if (!primary) return [];
            var secret = await hmacSha256Hex(SECONDARY_HMAC_KEY, primary);
            if (!secret) return [];

            var origin = baseOrigin(watchUrl);
            var providerUrl = origin + "/api/providerv3?type=" + encodeURIComponent(watchInfo.type) +
                "&tmdbId=" + encodeURIComponent(watchInfo.tmdbId) +
                "&imdbId=" + encodeURIComponent(imdbId) +
                "&seasonId=" + encodeURIComponent(watchInfo.season || "") +
                "&episodeId=" + encodeURIComponent(watchInfo.episode || "") +
                "&t=&ry=&secret=" + encodeURIComponent(secret);

            var provider = await getJson(providerUrl, defaultHeaders({
                "Referer": origin + "/",
                "Origin": origin
            }));
            var decrypted = await decryptProviderPayload(provider && provider.data || {});
            if (!decrypted) return [];

            var payload = parseJsonSafe(decrypted, {});
            var sourcesObj = payload && payload.sources || {};
            var keys = Object.keys(sourcesObj);
            var streams = [];
            var seen = {};
            for (var i = 0; i < keys.length; i++) {
                var item = sourcesObj[keys[i]];
                var mediaUrl = item && item.url ? String(item.url) : "";
                if (!/^https?:\/\//i.test(mediaUrl) || seen[mediaUrl]) continue;
                seen[mediaUrl] = true;
                streams.push(new StreamResult({
                    url: mediaUrl,
                    source: "CinemaOS V3",
                    headers: defaultHeaders({
                        "Referer": origin + "/",
                        "Origin": origin
                    })
                }));
            }
            return streams;
        } catch (_) {
            return [];
        }
    }

    async function resolveAnimeSources(info, watchUrl) {
        if (!info || !info.tmdbId || !info.episode) return [];
        var apiUrl = BASE_URL + "/api/anime-sources/?animeId=" + encodeURIComponent(info.tmdbId) +
            "&episodeId=" + encodeURIComponent(info.episode) +
            "&category=sub";
        var payload = await getJson(apiUrl, defaultHeaders({ "Referer": watchUrl || BASE_URL + "/" }));
        var links = payload && payload.data && payload.data.links || [];
        var out = [];
        var seen = {};
        for (var i = 0; i < links.length; i++) {
            var link = links[i] && links[i].url ? String(links[i].url) : "";
            if (!/^https?:\/\//i.test(link) || seen[link]) continue;
            seen[link] = true;
            out.push(new StreamResult({
                url: link,
                source: "CinemaOS Anime",
                headers: defaultHeaders({
                    "Referer": watchUrl || BASE_URL + "/",
                    "Origin": BASE_URL
                })
            }));
        }
        return out;
    }

    function resolveVidsrcEndpoints(info, watchUrl) {
        var id = String(info && info.tmdbId || "");
        var s = Number(info && info.season || 0);
        var e = Number(info && info.episode || 0);
        var out = [];
        if (!id) return out;

        var urls = [];
        if (info.type === "movie") {
            urls = [
                "https://vidsrc.wtf/api/1/movie/?id=" + id + "&color=e01621",
                "https://vidsrc.wtf/api/2/movie/?id=" + id + "&color=e01621",
                "https://vidsrc.wtf/api/3/movie/?id=" + id + "&color=e01621",
                "https://vidsrc.wtf/api/4/movie/?id=" + id + "&color=e01621"
            ];
        } else if (info.type === "tv" && s && e) {
            urls = [
                "https://vidsrc.wtf/api/1/tv/?id=" + id + "&s=" + s + "&e=" + e + "&color=e01621",
                "https://vidsrc.wtf/api/2/tv/?id=" + id + "&s=" + s + "&e=" + e + "&color=e01621",
                "https://vidsrc.wtf/api/3/tv/?id=" + id + "&s=" + s + "&e=" + e + "&color=e01621",
                "https://vidsrc.wtf/api/4/tv/?id=" + id + "&s=" + s + "&e=" + e + "&color=e01621"
            ];
        }

        for (var i = 0; i < urls.length; i++) {
            out.push(new StreamResult({
                url: urls[i],
                source: "CinemaOS Provider " + (i + 1),
                headers: defaultHeaders({
                    "Referer": watchUrl || BASE_URL + "/",
                    "Origin": baseOrigin(watchUrl || BASE_URL)
                })
            }));
        }
        return out;
    }

    async function getHome(cb) {
        try {
            var homeHtml = await getText(BASE_URL + "/", defaultHeaders());
            var movieHtml = await getText(BASE_URL + "/movie", defaultHeaders());
            var tvHtml = await getText(BASE_URL + "/tv", defaultHeaders());
            var animeHtml = await getText(BASE_URL + "/anime", defaultHeaders());

            var titleMap = {};
            var sources = [extractTitleMap(homeHtml), extractTitleMap(movieHtml), extractTitleMap(tvHtml), extractTitleMap(animeHtml)];
            for (var i = 0; i < sources.length; i++) {
                var map = sources[i];
                var key;
                for (key in map) {
                    if (Object.prototype.hasOwnProperty.call(map, key) && !titleMap[key]) titleMap[key] = map[key];
                }
            }

            var featuredWatchMovie = extractPathIds(homeHtml, "/movie/watch/(\\d+)")[0] || "";
            var homeMovies = extractPathIds(homeHtml, "href=\\\"/movie/(\\d+)\\\"");
            var homeTv = extractPathIds(homeHtml, "href=\\\"/tv/(\\d+)\\\"");
            var movieWatch = extractPathIds(movieHtml, "/movie/watch/(\\d+)");
            var tvWatch = extractPathIds(tvHtml, "/tv/watch/(\\d+)\\?season=");
            var animeIds = extractPathIds(animeHtml, "href=\\\"/anime/(\\d+)\\\"");

            var data = {};
            if (featuredWatchMovie) data["Featured"] = [createHomeItem("movie", featuredWatchMovie, titleMap)];
            data["Trending Movies"] = uniqueBy(homeMovies.slice(0, 12), function (id) { return id; }).map(function (id) { return createHomeItem("movie", id, titleMap); });
            data["Trending TV Shows"] = uniqueBy(homeTv.slice(0, 12), function (id) { return id; }).map(function (id) { return createHomeItem("tv", id, titleMap); });
            data["Latest Movies"] = uniqueBy(movieWatch.slice(0, 20), function (id) { return id; }).map(function (id) { return createHomeItem("movie", id, titleMap); });
            data["Latest TV Episodes"] = uniqueBy(tvWatch.slice(0, 20), function (id) { return id; }).map(function (id) { return createHomeItem("tv", id, titleMap); });
            data["Anime Spotlight"] = uniqueBy(animeIds.slice(0, 20), function (id) { return id; }).map(function (id) { return createHomeItem("anime", id, titleMap); });
            data["More Movies"] = uniqueBy(homeMovies.slice(12, 24), function (id) { return id; }).map(function (id) { return createHomeItem("movie", id, titleMap); });
            data["More TV Shows"] = uniqueBy(homeTv.slice(12, 24), function (id) { return id; }).map(function (id) { return createHomeItem("tv", id, titleMap); });

            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: toErrorMessage(error) });
        }
    }

    async function search(query, cb) {
        try {
            var q = trim(query || "");
            if (!q) {
                cb({ success: true, data: [] });
                return;
            }
            var api = "https://api.themoviedb.org/3/search/multi?api_key=" + encodeURIComponent(TMDB_API_KEY) + "&query=" + encodeURIComponent(q);
            var payload = await getJson(api, defaultHeaders({ "Referer": "https://www.themoviedb.org/" }));
            var results = [];
            var items = payload && payload.results || [];

            for (var i = 0; i < items.length; i++) {
                var item = items[i] || {};
                var mediaType = String(item.media_type || "");
                if (mediaType !== "movie" && mediaType !== "tv") continue;
                var id = String(item.id || "");
                if (!id) continue;
                var isMovie = mediaType === "movie";
                results.push(new MultimediaItem({
                    title: item.title || item.name || ("TMDB " + id),
                    url: BASE_URL + "/" + (isMovie ? "movie" : "tv") + "/" + id,
                    posterUrl: item.poster_path ? (TMDB_IMAGE + item.poster_path) : undefined,
                    type: isMovie ? "movie" : "series",
                    year: Number(String(item.release_date || item.first_air_date || "").slice(0, 4)) || undefined,
                    headers: defaultHeaders()
                }));
            }

            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: toErrorMessage(error) });
        }
    }

    async function load(url, cb) {
        try {
            var sourceUrl = String(url || "");
            var watchInfo = parseWatchInfo(sourceUrl);
            var detailUrl = sourceUrl;

            if (watchInfo && watchInfo.type === "movie") detailUrl = BASE_URL + "/movie/" + watchInfo.tmdbId;
            if (watchInfo && watchInfo.type === "tv") detailUrl = BASE_URL + "/tv/" + watchInfo.tmdbId;
            if (watchInfo && watchInfo.type === "anime") detailUrl = BASE_URL + "/anime/" + watchInfo.tmdbId;

            var html = await getText(detailUrl, defaultHeaders({ "Referer": BASE_URL + "/" }));
            var titleMap = extractTitleMap(html);
            var movieIdMatch = detailUrl.match(/\/movie\/(\d+)/i);
            var tvIdMatch = detailUrl.match(/\/tv\/(\d+)/i);
            var animeIdMatch = detailUrl.match(/\/anime\/(\d+)/i);
            var isMovie = !!movieIdMatch;
            var isTv = !!tvIdMatch;
            var isAnime = !!animeIdMatch;
            var tmdbId = (movieIdMatch && movieIdMatch[1]) || (tvIdMatch && tvIdMatch[1]) || (animeIdMatch && animeIdMatch[1]) || (watchInfo && watchInfo.tmdbId) || "";
            var title = extractMeta(html, "og:title") || titleMap[tmdbId] || ("CinemaOS " + tmdbId);
            var poster = extractMeta(html, "og:image");
            var description = extractMeta(html, "description") || extractMeta(html, "og:description");

            var episodes = [];
            if (isMovie || (watchInfo && watchInfo.type === "movie")) {
                var movieWatch = (extractPathIds(html, "/movie/watch/(\\d+)")[0] || tmdbId);
                var movieWatchUrl = BASE_URL + "/movie/watch/" + movieWatch;
                episodes = [
                    new Episode({
                        name: "Movie",
                        url: moviePayload(movieWatchUrl, movieWatch),
                        season: 1,
                        episode: 1,
                        headers: defaultHeaders({ "Referer": detailUrl })
                    })
                ];
            } else if (isTv || (watchInfo && watchInfo.type === "tv")) {
                var tvId = tmdbId || (watchInfo && watchInfo.tmdbId) || "";
                var tvEps = extractTvWatchEpisodes(html, tvId);
                if (!tvEps.length) tvEps = [{ season: 1, episode: 1 }];
                episodes = tvEps.map(function (ep) {
                    var watchUrl = BASE_URL + "/tv/watch/" + tvId + "?season=" + ep.season + "&episode=" + ep.episode;
                    return new Episode({
                        name: "S" + ep.season + " E" + ep.episode,
                        url: tvPayload(watchUrl, tvId, ep.season, ep.episode),
                        season: ep.season,
                        episode: ep.episode,
                        headers: defaultHeaders({ "Referer": detailUrl })
                    });
                });
            } else {
                var animeId = tmdbId || (watchInfo && watchInfo.tmdbId) || "";
                var animeEps = extractAnimeEpisodes(html, animeId);
                if (!animeEps.length) animeEps = [1];
                episodes = animeEps.map(function (ep) {
                    var watchUrl = BASE_URL + "/anime/watch/" + animeId + "/" + ep;
                    return new Episode({
                        name: "Episode " + ep,
                        url: animePayload(watchUrl, animeId, ep),
                        season: 1,
                        episode: ep,
                        headers: defaultHeaders({ "Referer": detailUrl })
                    });
                });
            }

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: detailUrl,
                    posterUrl: poster || undefined,
                    description: description || undefined,
                    type: isMovie ? "movie" : (isAnime ? "anime" : "series"),
                    episodes: episodes,
                    headers: defaultHeaders({ "Referer": detailUrl })
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: toErrorMessage(error) });
        }
    }

    function dedupeStreams(streams) {
        return uniqueBy(streams || [], function (item) {
            return String(item && item.url || "") + "|" + JSON.stringify(item && item.headers || {});
        });
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parseLoadInput(url);
            var watchUrl = String(payload.watchUrl || payload.url || "");
            if (!watchUrl) {
                cb({ success: true, data: [] });
                return;
            }

            var info = parseWatchInfo(watchUrl);
            if (!info && /^https:\/\/cinemaos\.live\/movie\/\d+/i.test(watchUrl)) {
                info = { type: "movie", tmdbId: (watchUrl.match(/\/movie\/(\d+)/i) || [])[1], season: null, episode: null };
                watchUrl = BASE_URL + "/movie/watch/" + info.tmdbId;
            } else if (!info && /^https:\/\/cinemaos\.live\/tv\/\d+/i.test(watchUrl)) {
                info = { type: "tv", tmdbId: (watchUrl.match(/\/tv\/(\d+)/i) || [])[1], season: 1, episode: 1 };
                watchUrl = BASE_URL + "/tv/watch/" + info.tmdbId + "?season=1&episode=1";
            } else if (!info && /^https:\/\/cinemaos\.live\/anime\/\d+/i.test(watchUrl)) {
                info = { type: "anime", tmdbId: (watchUrl.match(/\/anime\/(\d+)/i) || [])[1], season: 1, episode: 1 };
                watchUrl = BASE_URL + "/anime/watch/" + info.tmdbId + "/1";
            }

            if (!info) {
                cb({ success: true, data: [new StreamResult({ url: watchUrl, source: "CinemaOS", headers: defaultHeaders() })] });
                return;
            }

            var streams = [];
            if (info.type === "anime") {
                streams = streams.concat(await resolveAnimeSources(info, watchUrl));
            } else {
                streams = streams.concat(resolveVidsrcEndpoints(info, watchUrl));
                var v3 = await resolveProviderV3(info, watchUrl);
                streams = streams.concat(v3);
            }

            if (!streams.length) {
                streams.push(new StreamResult({
                    url: watchUrl,
                    source: "CinemaOS Fallback",
                    headers: defaultHeaders({ "Referer": BASE_URL + "/" })
                }));
            }

            cb({ success: true, data: dedupeStreams(streams) });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: toErrorMessage(error) });
        }
    }

    var root = typeof globalThis !== "undefined" ? globalThis
        : typeof self !== "undefined" ? self
        : typeof window !== "undefined" ? window
        : typeof global !== "undefined" ? global
        : this;

    root.getHome = getHome;
    root.loadHome = getHome;
    root.loadhome = getHome;
    root.search = search;
    root.load = load;
    root.loadStreams = loadStreams;
})();
