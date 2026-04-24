(function () {
    "use strict";

    var BASE_URL = "https://heartivetv.pages.dev";
    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";
    var TMDB_BEARER = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYmYwZmFlZWIzZjc3OWRhZDdkOWM3MjY4ZGM0NmNmNiIsIm5iZiI6MTcyMzkzMjM1MS4xNDEyNzIsInN1YiI6IjY2YzExZTJmOTk5ZmYwYTFjNTE2YWRhNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vwZW4D57fT-wlqLgHt_4vhnfTbuIwFOOrWE2DBlRHMQ";
    var VIDZEE_SECRET = "pleasedontscrapemesaywallahi";
    var aesJsPromise = null;
    var sha256JsPromise = null;
    var VIDFAST_HEADERS = {
        "Accept": "*/*",
        "Referer": "https://vidfast.pro/",
        "User-Agent": USER_AGENT,
        "X-Csrf-Token": "22Xg4bhHnx4uUolyJWs7rdNBbIzYVz8z",
        "X-Requested-With": "XMLHttpRequest"
    };
    var VIDFAST_STATIC_PATH = "hezushon/8ee77bc2e110fd6e6ac7659b33c6f9146497cb81b1a2694590a68f22c5b495b9/APA91DQqR0e_8UTJpaNhNS9c2Bgrg21PeT12bVxpsCvoUhB9rNLJgMZMHxO7oigbPWv7eXn4NavycM9jt2EGVHBmkXIeSJUXh2AOEvWyji1iNx4Txr2OZONKK5IjKp8GBmmzCCb6-rh1I0o50c5eLc_cZ6KnwX7TrB_UsqfYsbMwBqhvWBEEZ1Q/bdf45bbf7c054d8a75d7575767e40745f967d0a8";
    var VIDFAST_AES_KEY = "50bb6a529bfb4abb1969c1a29c8cac6df1f00ec63a7297c4c06dcc9473cdacc4";
    var VIDFAST_AES_IV = "ffe7765f45669a794181d0b4a8d9e96b";
    var VIDFAST_XOR_SEED_KEY = "1a5d66c3fbf2";

    var HOME_ROWS = [
        { title: "Trending", path: "/trending/all/week?language=en-US&page=1", mixed: true },
        { title: "Trending Movies", path: "/trending/movie/week?language=en-US&page=1", mediaType: "movie" },
        { title: "Trending TV Shows", path: "/trending/tv/week?language=en-US&page=1", mediaType: "tv" },
        { title: "Netflix", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_networks=213", mediaType: "tv" },
        { title: "Prime Video", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_watch_providers=119&watch_region=US", mediaType: "tv" },
        { title: "Apple TV+", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_watch_providers=350&watch_region=US", mediaType: "tv" },
        { title: "Hulu", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_networks=453", mediaType: "tv" },
        { title: "HBO / Max", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_networks=49|3186", mediaType: "tv" },
        { title: "Disney+", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_watch_providers=337&watch_region=US", mediaType: "tv" },
        { title: "Paramount+", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_networks=4330", mediaType: "tv" },
        { title: "Action Movies", path: "/discover/movie?language=en-US&sort_by=popularity.desc&with_genres=28", mediaType: "movie" },
        { title: "Comedy Movies", path: "/discover/movie?language=en-US&sort_by=popularity.desc&with_genres=35", mediaType: "movie" },
        { title: "Sci-Fi Shows", path: "/discover/tv?language=en-US&sort_by=popularity.desc&with_genres=10765", mediaType: "tv" },
        { title: "Horror Movies", path: "/discover/movie?language=en-US&sort_by=popularity.desc&with_genres=27", mediaType: "movie" }
    ];
    var genreCache = {};

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

    function normalizeTitle(value) {
        return trim(String(value || "").toLowerCase().replace(/[^a-z0-9]+/g, " "));
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
            if (Object.prototype.hasOwnProperty.call(rawHeaders, key)) {
                headers[String(key).toLowerCase()] = rawHeaders[key];
            }
        }
        return headers;
    }

    function defaultHeaders(extra) {
        var headers = {
            "User-Agent": USER_AGENT,
            "Accept": "*/*",
            "Referer": BASE_URL + "/",
            "Origin": BASE_URL
        };
        extra = extra || {};
        for (var key in extra) {
            if (Object.prototype.hasOwnProperty.call(extra, key) && typeof extra[key] !== "undefined") {
                headers[key] = extra[key];
            }
        }
        return headers;
    }

    function absoluteUrl(base, path) {
        var value = String(path || "");
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        if (/^[a-z0-9.-]+\.[a-z]{2,}(?:\/|$)/i.test(value)) return "https://" + value.replace(/^\/+/, "");
        try {
            return new URL(value, String(base || "")).toString();
        } catch (_) {
            return value;
        }
    }

    function tmdbImage(path) {
        return path ? (TMDB_IMAGE + path) : undefined;
    }

    function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || defaultHeaders();
        var body = typeof options.body === "undefined" ? "" : options.body;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                return {
                    status: res && typeof res.status !== "undefined" ? res.status : 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            return Promise.resolve(http_post(url, body, headers)).then(function (res) {
                return {
                    status: res && typeof res.status !== "undefined" ? res.status : 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        return fetch(url, {
            method: method,
            headers: headers,
            body: method === "GET" ? undefined : body,
            redirect: "follow"
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
        return request(url, { headers: headers }).then(function (res) {
            return String(res && res.body || "");
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers }).then(function (res) {
            return parseJsonSafe(res && res.body || "", {});
        });
    }

    function tmdbHeaders() {
        return {
            "User-Agent": USER_AGENT,
            "Accept": "application/json",
            "Authorization": TMDB_BEARER
        };
    }

    function tmdbGet(path) {
        return getJson(TMDB_API + path, tmdbHeaders());
    }

    async function getGenreMap(mediaType) {
        if (genreCache[mediaType]) return genreCache[mediaType];
        var json = await tmdbGet("/genre/" + mediaType + "/list?language=en-US").catch(function () {
            return {};
        });
        var map = {};
        var rows = json && json.genres || [];
        for (var i = 0; i < rows.length; i++) {
            if (rows[i] && rows[i].id) map[rows[i].id] = trim(rows[i].name || "");
        }
        genreCache[mediaType] = map;
        return map;
    }

    function shouldHideAnime(result) {
        if (!result) return true;
        var genres = result.genre_ids || [];
        var language = String(result.original_language || "").toLowerCase();
        var mediaType = result.media_type || (result.first_air_date ? "tv" : "movie");
        if (language === "ja" && genres.indexOf(16) !== -1) return true;
        if (mediaType === "tv" && language === "ja" && genres.indexOf(10759) !== -1 && genres.indexOf(16) !== -1) return true;
        return false;
    }

    function inferType(result) {
        var mediaType = result && result.media_type ? result.media_type : (result && result.first_air_date ? "tv" : "movie");
        return mediaType === "tv" ? "series" : "movie";
    }

    function buildPayload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed) return parsed;
        var value = String(url || "");
        var movieMatch = value.match(/\/movie\/(\d+)/i);
        if (movieMatch) return { mode: "detail", tmdbId: Number(movieMatch[1]), mediaType: "movie" };
        var tvMatch = value.match(/\/tv\/(\d+)/i);
        if (tvMatch) return { mode: "detail", tmdbId: Number(tvMatch[1]), mediaType: "tv" };
        throw new Error("Unsupported payload");
    }

    function selectLogo(images) {
        var logos = images && images.logos || [];
        if (!logos.length) return undefined;
        logos = logos.slice().sort(function (a, b) {
            var aLang = (a.iso_639_1 === "en" ? 2 : (!a.iso_639_1 ? 1 : 0));
            var bLang = (b.iso_639_1 === "en" ? 2 : (!b.iso_639_1 ? 1 : 0));
            if (aLang !== bLang) return bLang - aLang;
            var aVector = /\.svg$/i.test(String(a.file_path || "")) ? 1 : 0;
            var bVector = /\.svg$/i.test(String(b.file_path || "")) ? 1 : 0;
            if (aVector !== bVector) return bVector - aVector;
            return (Number(b.width || 0) - Number(a.width || 0));
        });
        return tmdbImage(logos[0] && logos[0].file_path);
    }

    function mapActors(cast) {
        return (cast || []).slice(0, 20).map(function (person) {
            return new Actor({
                name: trim(person && person.name),
                role: trim(person && person.character),
                image: tmdbImage(person && person.profile_path)
            });
        }).filter(function (actor) {
            return !!actor.name;
        });
    }

    function mapTrailers(videos) {
        return (videos && videos.results || []).filter(function (video) {
            return video && video.site === "YouTube" && /trailer/i.test(video.type || "");
        }).slice(0, 2).map(function (video) {
            return new Trailer({
                name: trim(video.name || "Trailer"),
                url: "https://www.youtube.com/watch?v=" + video.key
            });
        });
    }

    function mapRecommendations(items) {
        return uniqueBy((items || []).filter(function (row) {
            return row && (row.media_type === "movie" || row.media_type === "tv" || row.first_air_date || row.release_date) && !shouldHideAnime(row);
        }).slice(0, 16).map(buildTmdbItem).filter(Boolean), function (item) {
            return item.url;
        });
    }

    async function fetchDetailBundle(tmdbId, mediaType) {
        var base = "/" + mediaType + "/" + tmdbId;
        var detail = await tmdbGet(base + "?language=en-US");
        var credits = await tmdbGet(base + "/credits?language=en-US").catch(function () { return {}; });
        var externalIds = await tmdbGet(base + "/external_ids").catch(function () { return {}; });
        var videos = await tmdbGet(base + "/videos?language=en-US").catch(function () { return {}; });
        var recommendations = await tmdbGet(base + "/recommendations?language=en-US&page=1").catch(function () { return {}; });
        var images = await tmdbGet(base + "/images").catch(function () { return {}; });
        var ratings = mediaType === "movie"
            ? await tmdbGet(base + "/release_dates").catch(function () { return {}; })
            : await tmdbGet(base + "/content_ratings").catch(function () { return {}; });
        detail.credits = credits || {};
        detail.external_ids = externalIds || {};
        detail.videos = videos || {};
        detail.recommendations = recommendations || {};
        detail.images = images || {};
        if (mediaType === "movie") detail.release_dates = ratings || {};
        else detail.content_ratings = ratings || {};
        if ((!detail.title && !detail.name) && detail.external_ids && detail.external_ids.imdb_id) {
            var findJson = await tmdbGet("/find/" + detail.external_ids.imdb_id + "?external_source=imdb_id&language=en-US").catch(function () {
                return {};
            });
            var findRow = mediaType === "movie"
                ? (findJson.movie_results && findJson.movie_results[0])
                : (findJson.tv_results && findJson.tv_results[0]);
            if (findRow) {
                detail.title = detail.title || findRow.title;
                detail.name = detail.name || findRow.name;
                detail.overview = detail.overview || findRow.overview;
                detail.poster_path = detail.poster_path || findRow.poster_path;
                detail.backdrop_path = detail.backdrop_path || findRow.backdrop_path;
                if ((!detail.genres || !detail.genres.length) && findRow.genre_ids && findRow.genre_ids.length) {
                    var genreMap = await getGenreMap(mediaType);
                    detail.genres = findRow.genre_ids.map(function (id) {
                        return genreMap[id] ? { id: id, name: genreMap[id] } : null;
                    }).filter(Boolean);
                }
                detail.first_air_date = detail.first_air_date || findRow.first_air_date;
                detail.release_date = detail.release_date || findRow.release_date;
                detail.vote_average = typeof detail.vote_average === "number" && detail.vote_average ? detail.vote_average : findRow.vote_average;
            }
        }
        return detail;
    }

    function extractContentRating(detail, mediaType) {
        if (mediaType === "movie") {
            var releaseDates = detail && detail.release_dates && detail.release_dates.results || [];
            for (var i = 0; i < releaseDates.length; i++) {
                if (releaseDates[i] && releaseDates[i].iso_3166_1 === "US") {
                    var rows = releaseDates[i].release_dates || [];
                    for (var j = 0; j < rows.length; j++) {
                        if (rows[j] && rows[j].certification) return rows[j].certification;
                    }
                }
            }
            return undefined;
        }
        var ratings = detail && detail.content_ratings && detail.content_ratings.results || [];
        for (var k = 0; k < ratings.length; k++) {
            if (ratings[k] && ratings[k].iso_3166_1 === "US" && ratings[k].rating) return ratings[k].rating;
        }
        return undefined;
    }

    function normalizeStatus(status, mediaType) {
        var value = String(status || "").toLowerCase();
        if (mediaType === "movie") {
            if (value === "released") return "completed";
            if (value === "post production" || value === "planned" || value === "in production") return "upcoming";
            return "completed";
        }
        if (value === "ended" || value === "canceled") return "completed";
        if (value === "returning series" || value === "in production") return "ongoing";
        if (value === "planned") return "upcoming";
        return "ongoing";
    }

    function buildTmdbItem(result) {
        if (!result || !result.id) return null;
        if (shouldHideAnime(result)) return null;
        var mediaType = result.media_type || (result.first_air_date ? "tv" : "movie");
        if (mediaType !== "movie" && mediaType !== "tv") return null;
        var title = trim(result.title || result.name);
        var posterUrl = tmdbImage(result.poster_path);
        var bannerUrl = tmdbImage(result.backdrop_path);
        var description = trim(result.overview || "");
        var year = Number(String(result.release_date || result.first_air_date || "").slice(0, 4)) || undefined;
        if (!title) return null;
        return new MultimediaItem({
            title: title,
            url: buildPayload({
                mode: "detail",
                tmdbId: Number(result.id),
                mediaType: mediaType,
                title: title,
                description: description,
                posterUrl: posterUrl,
                bannerUrl: bannerUrl,
                year: year
            }),
            posterUrl: posterUrl,
            bannerUrl: bannerUrl,
            type: inferType(result),
            description: description,
            year: year
        });
    }

    async function fetchHomeRow(row) {
        var data = await tmdbGet(row.path);
        var results = data && data.results || [];
        if (row.mixed) {
            results = results.filter(function (item) {
                return item && (item.media_type === "movie" || item.media_type === "tv") && !shouldHideAnime(item);
            });
        } else {
            results = results.filter(function (item) {
                return item && !shouldHideAnime(item);
            }).map(function (item) {
                item.media_type = row.mediaType || item.media_type;
                return item;
            });
        }
        return uniqueBy(results.map(buildTmdbItem).filter(Boolean), function (item) {
            return item.url;
        }).slice(0, row.title === "Trending" ? 10 : 20);
    }

    function qualityFromText(text) {
        var value = String(text || "").toLowerCase();
        if (/2160|4k/.test(value)) return 2160;
        if (/1440/.test(value)) return 1440;
        if (/1080/.test(value)) return 1080;
        if (/720/.test(value)) return 720;
        if (/480/.test(value)) return 480;
        return undefined;
    }

    function buildStreamResult(url, source, headers, quality, subtitles) {
        var stream = new StreamResult({
            url: url,
            source: quality ? (source + " [" + quality + "p]") : source,
            quality: quality,
            headers: headers || {}
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    function extractFirstMatch(text, pattern) {
        var match = String(text || "").match(pattern);
        return match ? trim(match[1]) : "";
    }

    function decodeBase64ToString(value) {
        var input = String(value || "").replace(/-/g, "+").replace(/_/g, "/");
        while (input.length % 4) input += "=";
        try {
            if (typeof atob === "function") return atob(input);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "base64").toString("utf8");
        } catch (_) {}
        return "";
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

    function encodeUtf8ToBase64(value) {
        var bytes = utf8ToBytes(value);
        return uint8ArrayToBase64(bytes);
    }

    function decodeBase64ToBytes(value) {
        var input = String(value || "").replace(/-/g, "+").replace(/_/g, "/");
        while (input.length % 4) input += "=";
        try {
            if (typeof Buffer !== "undefined") {
                return new Uint8Array(Buffer.from(input, "base64"));
            }
        } catch (_) {}
        var decoded = typeof atob === "function" ? atob(input) : "";
        var bytes = new Uint8Array(decoded.length);
        for (var i = 0; i < decoded.length; i++) {
            bytes[i] = decoded.charCodeAt(i);
        }
        return bytes;
    }

    function uint8ArrayToBase64(bytes) {
        try {
            if (typeof Buffer !== "undefined") {
                return Buffer.from(bytes).toString("base64");
            }
        } catch (_) {}
        var binary = "";
        for (var i = 0; i < bytes.length; i++) binary += String.fromCharCode(bytes[i]);
        try {
            if (typeof btoa === "function") return btoa(binary);
        } catch (_) {}
        return "";
    }

    function utf8ToBytes(value) {
        if (typeof TextEncoder !== "undefined") return new TextEncoder().encode(String(value || ""));
        var text = String(value || "");
        var bytes = [];
        for (var i = 0; i < text.length; i++) bytes.push(text.charCodeAt(i) & 255);
        return new Uint8Array(bytes);
    }

    function bytesToUtf8(bytes) {
        if (typeof TextDecoder !== "undefined") return new TextDecoder().decode(bytes);
        var out = "";
        for (var i = 0; i < bytes.length; i++) out += String.fromCharCode(bytes[i]);
        return out;
    }

    function hexToBytes(hex) {
        var value = String(hex || "").replace(/[^a-f0-9]/gi, "");
        var out = new Uint8Array(Math.floor(value.length / 2));
        for (var i = 0; i < out.length; i++) {
            out[i] = parseInt(value.slice(i * 2, i * 2 + 2), 16);
        }
        return out;
    }

    function concatBytes(chunks) {
        var total = 0;
        for (var i = 0; i < chunks.length; i++) total += chunks[i].length;
        var out = new Uint8Array(total);
        var offset = 0;
        for (var j = 0; j < chunks.length; j++) {
            out.set(chunks[j], offset);
            offset += chunks[j].length;
        }
        return out;
    }

    function pkcs7Pad(bytes, blockSize) {
        var pad = blockSize - (bytes.length % blockSize || blockSize);
        if (pad <= 0) pad = blockSize;
        var out = new Uint8Array(bytes.length + pad);
        out.set(bytes, 0);
        for (var i = bytes.length; i < out.length; i++) out[i] = pad;
        return out;
    }

    function getRandomBytes(length) {
        if (globalThis.crypto && typeof globalThis.crypto.getRandomValues === "function") {
            var out = new Uint8Array(length);
            globalThis.crypto.getRandomValues(out);
            return out;
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.randomBytes === "function") {
            return new Uint8Array(nodeCrypto.randomBytes(length));
        }
        var fallback = new Uint8Array(length);
        for (var i = 0; i < length; i++) fallback[i] = Math.floor(Math.random() * 256);
        return fallback;
    }

    function reverseBytes(bytes) {
        var out = new Uint8Array(bytes.length);
        for (var i = 0; i < bytes.length; i++) out[i] = bytes[bytes.length - 1 - i];
        return out;
    }

    function hexFromBytes(bytes) {
        var out = "";
        for (var i = 0; i < bytes.length; i++) {
            var hex = bytes[i].toString(16);
            out += hex.length === 1 ? ("0" + hex) : hex;
        }
        return out;
    }

    function getNodeCrypto() {
        try {
            return Function("return typeof require !== 'undefined' ? require('crypto') : undefined;")();
        } catch (_) {
            return undefined;
        }
    }

    async function getAesJs() {
        if (globalThis.aesjs) return globalThis.aesjs;
        if (!aesJsPromise) {
            aesJsPromise = getText("https://cdnjs.cloudflare.com/ajax/libs/aes-js/3.1.2/index.min.js", {
                "User-Agent": USER_AGENT,
                "Referer": BASE_URL + "/"
            }).then(function (source) {
                if (!trim(source)) throw new Error("Failed to fetch aes-js");
                Function(String(source || ""))();
                if (!globalThis.aesjs) throw new Error("aes-js not available");
                return globalThis.aesjs;
            });
        }
        return aesJsPromise;
    }

    async function getSha256Js() {
        if (globalThis.sha256 && typeof globalThis.sha256.create === "function") return globalThis.sha256;
        if (!sha256JsPromise) {
            sha256JsPromise = getText("https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.11.0/sha256.min.js", {
                "User-Agent": USER_AGENT,
                "Referer": BASE_URL + "/"
            }).then(function (source) {
                if (!trim(source)) throw new Error("Failed to fetch sha256");
                Function(String(source || ""))();
                if (!globalThis.sha256 || typeof globalThis.sha256.create !== "function") {
                    throw new Error("sha256 not available");
                }
                return globalThis.sha256;
            });
        }
        return sha256JsPromise;
    }

    async function sha256Bytes(bytes) {
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.digest === "function") {
            var digest = await globalThis.crypto.subtle.digest("SHA-256", bytes);
            return new Uint8Array(digest);
        }

        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createHash === "function") {
            return new Uint8Array(nodeCrypto.createHash("sha256").update(Buffer.from(bytes)).digest());
        }

        var sha256 = await getSha256Js();
        var hash = sha256.create();
        hash.update(bytes);
        return new Uint8Array(hash.array());
    }

    async function encryptAesCbcRaw(plainBytes, keyBytes, ivBytes) {
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey(
                "raw",
                keyBytes,
                { name: "AES-CBC" },
                false,
                ["encrypt"]
            );
            var encrypted = await globalThis.crypto.subtle.encrypt(
                { name: "AES-CBC", iv: ivBytes },
                imported,
                plainBytes
            );
            return new Uint8Array(encrypted);
        }

        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createCipheriv === "function") {
            var cipher = nodeCrypto.createCipheriv("aes-256-cbc", Buffer.from(keyBytes), Buffer.from(ivBytes));
            cipher.setAutoPadding(false);
            var part1 = cipher.update(Buffer.from(plainBytes));
            var part2 = cipher.final();
            return new Uint8Array(Buffer.concat([part1, part2]));
        }

        var aesjs = await getAesJs();
        var cipherJs = new aesjs.ModeOfOperation.cbc(keyBytes, ivBytes);
        return cipherJs.encrypt(plainBytes);
    }

    async function decryptAesCbc(encryptedBlob, secret) {
        var decoded = decodeBase64ToString(encryptedBlob);
        var parts = decoded.split(":");
        if (parts.length < 2) throw new Error("Malformed encrypted payload");
        var iv = decodeBase64ToBytes(parts[0]);
        var ciphertext = decodeBase64ToBytes(parts.slice(1).join(":"));
        var keyMaterial = String(secret || "").padEnd(32, "\0").slice(0, 32);
        if (globalThis.crypto && typeof globalThis.crypto.decryptAES === "function") {
            try {
                var bridgePlain = await globalThis.crypto.decryptAES(
                    uint8ArrayToBase64(ciphertext),
                    encodeUtf8ToBase64(keyMaterial),
                    uint8ArrayToBase64(iv)
                );
                if (trim(bridgePlain)) return trim(String(bridgePlain || "").replace(/[\u0000-\u001f]+$/g, ""));
            } catch (_) {}
        }
        if (globalThis.crypto && globalThis.crypto.subtle) {
            var key = await globalThis.crypto.subtle.importKey(
                "raw",
                utf8ToBytes(keyMaterial),
                { name: "AES-CBC" },
                false,
                ["decrypt"]
            );
            var plain = await globalThis.crypto.subtle.decrypt(
                { name: "AES-CBC", iv: iv },
                key,
                ciphertext
            );
            return trim(bytesToUtf8(new Uint8Array(plain)).replace(/[\u0000-\u001f]+$/g, ""));
        }

        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto) {
            var decipher = nodeCrypto.createDecipheriv("aes-256-cbc", Buffer.from(utf8ToBytes(keyMaterial)), Buffer.from(iv));
            var plaintext = decipher.update(Buffer.from(ciphertext), undefined, "utf8");
            plaintext += decipher.final("utf8");
            return trim(String(plaintext || "").replace(/[\u0000-\u001f]+$/g, ""));
        }

        var aesjs = await getAesJs();
        var cipher = new aesjs.ModeOfOperation.cbc(utf8ToBytes(keyMaterial), iv);
        var decrypted = cipher.decrypt(ciphertext);
        var stripped = aesjs.padding.pkcs7.strip(decrypted);
        return trim(bytesToUtf8(stripped).replace(/[\u0000-\u001f]+$/g, ""));
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

    function buildPlayableStreamResult(url, source, headers, quality, opts) {
        var config = opts || {};
        var referer = config.referer || (headers && (headers.Referer || headers.referer)) || "";
        var mirrorHosts = config.mirrorHosts || [];
        var subtitles = config.subtitles || [];
        if (!mirrorHosts.length) {
            try {
                mirrorHosts = [new URL(url).hostname];
            } catch (_) {
                mirrorHosts = [];
            }
        }
        if (config.forceProxy || isLikelyHls(url, config.body)) {
            var proxied = new StreamResult({
                url: proxifyUrl(url, headers, referer, mirrorHosts),
                source: quality ? (source + " [" + quality + "p]") : source,
                quality: quality,
                type: "hls",
                headers: {}
            });
            if (subtitles.length) proxied.subtitles = subtitles;
            return proxied;
        }
        return buildStreamResult(url, source, headers, quality, subtitles);
    }

    function normalizeSubtitleTracks(tracks) {
        var out = [];
        var seen = {};
        var rows = tracks || [];
        for (var i = 0; i < rows.length; i++) {
            var track = rows[i] || {};
            var url = trim(track.file || track.url || track.src || "");
            if (!/^https?:\/\//i.test(url) || seen[url]) continue;
            seen[url] = true;
            var langValue = normalizeSubtitleLang(track.lang || track.language || track.label || track.name || "en");
            out.push({
                url: url,
                label: trim(track.label || track.name || track.lang || track.language || "Unknown"),
                lang: langValue
            });
        }
        return out;
    }

    function parseHlsAttributes(line) {
        var attributes = {};
        var regex = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/ig;
        var match;
        while ((match = regex.exec(String(line || ""))) !== null) {
            attributes[match[1]] = String(match[2] || "").replace(/^"|"$/g, "");
        }
        return attributes;
    }

    function scoreStream(item) {
        var source = String(item && item.source || "").toLowerCase();
        var quality = Number(item && item.quality || 0) || 0;
        var sourceRank = /vidzee/.test(source) ? 0 :
            (/vidfast/.test(source) ? 1 :
            (/moviesclub|primewire/.test(source) ? 2 :
            (/vidlink/.test(source) ? 3 :
            (/vixsrc/.test(source) ? 4 :
            (/vidsrc/.test(source) ? 5 : 6)))));
        var targetQuality = /vidsrc/.test(source) ? 480 : 720;
        var qualityRank = quality ? Math.abs(quality - targetQuality) : 9999;
        return (sourceRank * 10000) + qualityRank;
    }

    function sortStreams(streams) {
        return (streams || []).slice().sort(function (a, b) {
            return scoreStream(a) - scoreStream(b);
        });
    }

    async function expandHlsStreams(masterUrl, streamHeaders, sourceName, opts, manifestText) {
        var config = opts || {};
        var subtitles = normalizeSubtitleTracks(config.subtitles || []);
        var results = [];
        try {
            var manifest = String(manifestText || "");
            if (!manifest) {
                var response = await request(masterUrl, { headers: streamHeaders });
                manifest = String(response && response.body || "");
            }
            if (!manifest || !/^#EXTM3U/i.test(manifest)) {
                return [buildPlayableStreamResult(masterUrl, sourceName, streamHeaders, config.quality, {
                    subtitles: subtitles,
                    forceProxy: true,
                    referer: config.referer,
                    mirrorHosts: config.mirrorHosts || []
                })];
            }

            var lines = manifest.split(/\r?\n/);
            var baseUrl = masterUrl.substring(0, masterUrl.lastIndexOf("/") + 1);
            var pending = null;
            var mediaSubs = [];
            var seenSubs = {};

            for (var i = 0; i < lines.length; i++) {
                var rawLine = trim(lines[i]);
                if (!rawLine) continue;
                if (rawLine.indexOf("#EXT-X-MEDIA:") === 0) {
                    var mediaAttrs = parseHlsAttributes(rawLine.slice("#EXT-X-MEDIA:".length));
                    if (String(mediaAttrs.TYPE || "").toUpperCase() === "SUBTITLES" && mediaAttrs.URI) {
                        var subUrl = absoluteUrl(baseUrl, mediaAttrs.URI);
                        if (!seenSubs[subUrl]) {
                            seenSubs[subUrl] = true;
                            mediaSubs.push({
                                url: subUrl,
                                label: trim(mediaAttrs.NAME || mediaAttrs.LANGUAGE || "Unknown"),
                                lang: trim(mediaAttrs.LANGUAGE || "en").toLowerCase()
                            });
                        }
                    }
                    continue;
                }
                if (rawLine.indexOf("#EXT-X-STREAM-INF:") === 0) {
                    pending = parseHlsAttributes(rawLine.slice("#EXT-X-STREAM-INF:".length));
                    continue;
                }
                if (rawLine.indexOf("#") === 0) continue;
                if (!pending) continue;

                var variantUrl = absoluteUrl(baseUrl, rawLine);
                var bandwidth = Number(pending.BANDWIDTH || 0) || 0;
                var resolution = String(pending.RESOLUTION || "");
                var heightMatch = resolution.match(/x(\d+)/i);
                var quality = heightMatch ? Number(heightMatch[1]) : 0;
                if (!quality) {
                    quality = bandwidth >= 12000000 ? 2160 :
                        bandwidth >= 5000000 ? 1080 :
                        bandwidth >= 2500000 ? 720 :
                        bandwidth >= 1200000 ? 480 : 360;
                }
                if (quality >= 470 && quality <= 490) quality = 480;
                if (quality >= 350 && quality <= 370) quality = 360;
                results.push(buildPlayableStreamResult(variantUrl, sourceName, streamHeaders, quality, {
                    subtitles: subtitles.concat(mediaSubs),
                    forceProxy: true,
                    referer: config.referer,
                    mirrorHosts: config.mirrorHosts || []
                }));
                pending = null;
            }

            if (!results.length) {
                results.push(buildPlayableStreamResult(masterUrl, sourceName, streamHeaders, config.quality, {
                    subtitles: subtitles.concat(mediaSubs),
                    forceProxy: true,
                    referer: config.referer,
                    mirrorHosts: config.mirrorHosts || []
                }));
            }
        } catch (_) {
            results.push(buildPlayableStreamResult(masterUrl, sourceName, streamHeaders, config.quality, {
                subtitles: subtitles,
                forceProxy: true,
                referer: config.referer,
                mirrorHosts: config.mirrorHosts || []
            }));
        }
        return results;
    }

    function extractInlineTracks(text, baseUrl) {
        var html = String(text || "");
        var payload = extractFirstMatch(html, /tracks\s*:\s*(\[[\s\S]*?\])/i)
            || extractFirstMatch(html, /tracks\s*=\s*(\[[\s\S]*?\])/i);
        if (!payload) return [];
        var out = [];
        var seen = {};
        var objectRegex = /\{[\s\S]*?\}/g;
        var match;
        while ((match = objectRegex.exec(payload)) !== null) {
            var block = match[0];
            var file = extractFirstMatch(block, /(?:file|src|url)\s*:\s*["']([^"']+)["']/i);
            if (!file) continue;
            var url = absoluteUrl(baseUrl, file);
            if (!/^https?:\/\//i.test(url) || seen[url]) continue;
            seen[url] = true;
            out.push({
                url: url,
                label: trim(
                    extractFirstMatch(block, /(?:label|name)\s*:\s*["']([^"']+)["']/i)
                    || extractFirstMatch(block, /(?:lang|language)\s*:\s*["']([^"']+)["']/i)
                    || "Unknown"
                ),
                lang: trim(
                    extractFirstMatch(block, /(?:lang|language)\s*:\s*["']([^"']+)["']/i)
                    || "en"
                ).toLowerCase()
            });
        }
        return out;
    }

    function decodePackedNumber(value, base) {
        var alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
        var input = String(value || "").toLowerCase();
        var result = 0;
        for (var i = 0; i < input.length; i++) {
            var index = alphabet.indexOf(input.charAt(i));
            if (index < 0 || index >= base) return NaN;
            result = (result * base) + index;
        }
        return result;
    }

    function parsePackedStringArray(value) {
        var raw = trim(String(value || ""));
        if (!raw) return [];
        if ((raw.charAt(0) === "'" && raw.charAt(raw.length - 1) === "'")
            || (raw.charAt(0) === "\"" && raw.charAt(raw.length - 1) === "\"")) {
            raw = raw.slice(1, -1);
        }
        raw = raw.replace(/\\'/g, "'").replace(/\\"/g, "\"").replace(/\\\\/g, "\\");
        return raw.split("|");
    }

    function unpackDeanEdwards(text) {
        var html = String(text || "");
        var match = html.match(/eval\(function\(p,a,c,k,e,d\)\{[\s\S]*?\}\(\s*'((?:\\.|[^'])*)'\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*'((?:\\.|[^'])*)'\.split\('\\\|'\)/i)
            || html.match(/eval\(function\(p,a,c,k,e,d\)\{[\s\S]*?\}\(\s*'((?:\\.|[^'])*)'\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*'((?:\\.|[^'])*)'\.split\('\|'\)/i);
        if (!match) return "";
        var payload = match[1]
            .replace(/\\'/g, "'")
            .replace(/\\"/g, "\"")
            .replace(/\\\\/g, "\\");
        var base = Number(match[2]) || 36;
        var count = Number(match[3]) || 0;
        var words = parsePackedStringArray(match[4]);
        if (!payload || !words.length) return "";
        return payload.replace(/\b[0-9a-z]+\b/gi, function (token) {
            var index = decodePackedNumber(token, base);
            if (!isFinite(index) || index < 0 || index >= count) return token;
            return typeof words[index] === "string" && words[index] ? words[index] : token;
        });
    }

    function inferSubtitleMeta(url) {
        var value = String(url || "").toLowerCase();
        var lastToken = trim(value.split("/").pop() || "");
        var lang = extractFirstMatch(lastToken, /[_\-.]([a-z]{2,3})(?:[_\-.]|\.vtt\b)/i) || "en";
        var labelMap = {
            en: "English",
            eng: "English",
            es: "Spanish",
            spa: "Spanish",
            fr: "French",
            fre: "French",
            de: "German",
            ger: "German",
            pt: "Portuguese",
            por: "Portuguese",
            ar: "Arabic",
            ara: "Arabic",
            tr: "Turkish",
            tur: "Turkish",
            pl: "Polish",
            pol: "Polish",
            it: "Italian",
            ind: "Indonesian",
            nl: "Dutch",
            dut: "Dutch",
            sv: "Swedish",
            swe: "Swedish",
            da: "Danish",
            ro: "Romanian",
            ron: "Romanian",
            fi: "Finnish",
            ko: "Korean",
            kor: "Korean",
            he: "Hebrew",
            heb: "Hebrew",
            el: "Greek",
            gre: "Greek",
            cs: "Czech",
            cze: "Czech",
            fa: "Persian",
            per: "Persian",
            bg: "Bulgarian",
            bul: "Bulgarian",
            sr: "Serbian",
            srp: "Serbian",
            sl: "Slovenian",
            slv: "Slovenian",
            sq: "Albanian",
            alb: "Albanian"
        };
        return {
            lang: normalizeSubtitleLang(lang),
            label: labelMap[lang] || (lang ? (lang.toUpperCase()) : "Unknown")
        };
    }

    function normalizeSubtitleLang(value) {
        var raw = trim(String(value || "").toLowerCase());
        var langMap = {
            arabic: "ar",
            ar: "ar",
            ara: "ar",
            bengali: "bn",
            bn: "bn",
            chinese: "zh",
            zh: "zh",
            eng: "en",
            english: "en",
            en: "en",
            filipino: "fil",
            fil: "fil",
            french: "fr",
            fre: "fr",
            fr: "fr",
            german: "de",
            ger: "de",
            de: "de",
            greek: "el",
            gre: "el",
            el: "el",
            hebrew: "he",
            heb: "he",
            he: "he",
            hindi: "hi",
            hi: "hi",
            indonesian: "id",
            ind: "id",
            id: "id",
            italian: "it",
            it: "it",
            korean: "ko",
            kor: "ko",
            ko: "ko",
            malay: "ms",
            ms: "ms",
            panjabi: "pa",
            punjabi: "pa",
            pa: "pa",
            persian: "fa",
            per: "fa",
            fa: "fa",
            polish: "pl",
            pol: "pl",
            pl: "pl",
            portuguese: "pt",
            por: "pt",
            pt: "pt",
            romanian: "ro",
            ron: "ro",
            ro: "ro",
            russian: "ru",
            ru: "ru",
            serbian: "sr",
            srp: "sr",
            sr: "sr",
            slovenian: "sl",
            slv: "sl",
            sl: "sl",
            spanish: "es",
            spa: "es",
            es: "es",
            swedish: "sv",
            swe: "sv",
            sv: "sv",
            tamil: "ta",
            ta: "ta",
            telugu: "te",
            te: "te",
            turkish: "tr",
            tur: "tr",
            tr: "tr",
            urdu: "ur",
            ur: "ur",
            vietnamese: "vi",
            viet: "vi",
            vi: "vi"
        };
        return langMap[raw] || (raw ? raw.slice(0, 3) : "en");
    }

    function extractSubtitleUrls(text, baseUrl) {
        var source = String(text || "");
        var out = [];
        var seen = {};
        var regex = /https?:\/\/[^"' )]+\.vtt(?:\?[^"' )]*)?/ig;
        var match;
        while ((match = regex.exec(source)) !== null) {
            var url = absoluteUrl(baseUrl, match[0]);
            if (!/^https?:\/\//i.test(url) || seen[url]) continue;
            seen[url] = true;
            var meta = inferSubtitleMeta(url);
            out.push({
                url: url,
                label: meta.label || "Unknown",
                lang: meta.lang || "en"
            });
        }
        return out;
    }

    function extractMediaUrls(text, extension) {
        var source = String(text || "");
        var pattern = new RegExp("https?:\\\\/\\\\/[^\\\"' )]+\\." + extension + "(?:\\?[^\\\"' )]*)?", "ig");
        var out = [];
        var seen = {};
        var match;
        while ((match = pattern.exec(source)) !== null) {
            var url = trim(match[0]);
            if (!seen[url]) {
                seen[url] = true;
                out.push(url);
            }
        }
        return out;
    }

    async function resolveVidoraEmbed(embedUrl, sourceName) {
        var pageHtml = await getText(embedUrl, {
            "User-Agent": USER_AGENT,
            "Referer": "https://moviesapi.club/"
        }).catch(function () {
            return "";
        });
        if (!pageHtml) return [];

        var unpacked = unpackDeanEdwards(pageHtml);
        var scanText = unpacked || pageHtml;
        var subtitles = normalizeSubtitleTracks(extractSubtitleUrls(scanText, embedUrl));
        var hlsUrls = extractMediaUrls(scanText, "m3u8");
        if (!hlsUrls.length) return [];

        var headers = {
            "User-Agent": USER_AGENT,
            "Referer": "https://vidora.stream/",
            "Origin": "https://vidora.stream"
        };
        var results = [];
        for (var i = 0; i < hlsUrls.length; i++) {
            results = results.concat(await expandHlsStreams(hlsUrls[i], headers, sourceName || "MoviesClub", {
                subtitles: subtitles,
                quality: qualityFromText(hlsUrls[i] + " " + scanText),
                referer: "https://vidora.stream/",
                mirrorHosts: ["vidora.stream", "netrocdn.site", "box.netrocdn.site"]
            }).catch(function () {
                return [];
            }));
        }
        return results;
    }

    async function resolveMoviesclub(payload) {
        var pageUrl = payload.mediaType === "tv"
            ? ("https://moviesapi.club/tv/" + payload.tmdbId + "-" + payload.season + "-" + payload.episode)
            : ("https://moviesapi.club/movie/" + payload.tmdbId);

        var pageHtml = await getText(pageUrl, {
            "User-Agent": USER_AGENT,
            "Referer": BASE_URL + "/"
        }).catch(function () {
            return "";
        });
        if (!pageHtml) return [];

        var iframeUrl = extractFirstMatch(pageHtml, /<iframe[^>]+src=["']([^"']+)["']/i);
        if (!iframeUrl) return [];
        iframeUrl = absoluteUrl(pageUrl, iframeUrl);

        if (/vidora\.stream/i.test(iframeUrl)) {
            return resolveVidoraEmbed(iframeUrl, "MoviesClub");
        }

        return [];
    }

    async function resolveVidlink(payload) {
        var apiUrl = payload.mediaType === "tv"
            ? ("https://vidlink.pro/api/b/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode + "?multiLang=0")
            : ("https://vidlink.pro/api/b/movie/" + payload.tmdbId + "?multiLang=0");

        var response = await request(apiUrl, {
            headers: {
                "User-Agent": USER_AGENT,
                "Accept": "application/json, text/plain, */*",
                "Referer": payload.mediaType === "tv"
                    ? ("https://vidlink.pro/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode + "?autoplay=false&poster=true&title=true&nextbutton=false&primaryColor=ffffff")
                    : ("https://vidlink.pro/movie/" + payload.tmdbId + "?autoplay=false&poster=true&title=true&nextbutton=false&primaryColor=ffffff")
            }
        }).catch(function () {
            return null;
        });
        if (!response) return [];

        var json = parseJsonSafe(response.body, null);
        var stream = json && (json.stream || json.data && json.data.stream) || null;
        var payloadData = stream && (stream.stream || stream) || null;
        if (!payloadData) return [];

        var playlist = trim(payloadData.playlist || payloadData.file || "");
        var subtitles = normalizeSubtitleTracks(payloadData.captions || payloadData.tracks || []);
        var headers = defaultHeaders({
            "Referer": "https://vidlink.pro/",
            "Origin": "https://vidlink.pro"
        });
        if (playlist && /^https?:\/\//i.test(playlist)) {
            return expandHlsStreams(playlist, headers, "VidLink", {
                subtitles: subtitles,
                quality: qualityFromText(playlist),
                referer: "https://vidlink.pro/",
                mirrorHosts: ["vidlink.pro"]
            });
        }

        var qualities = payloadData.qualities || [];
        var results = [];
        for (var i = 0; i < qualities.length; i++) {
            var row = qualities[i] || {};
            var url = trim(row.url || row.file || row.src || "");
            if (!/^https?:\/\//i.test(url)) continue;
            results.push(buildPlayableStreamResult(url, "VidLink", headers, qualityFromText((row.quality || row.label || "") + " " + url), {
                subtitles: subtitles,
                forceProxy: isLikelyHls(url),
                referer: "https://vidlink.pro/",
                mirrorHosts: ["vidlink.pro"]
            }));
        }
        return results;
    }

    async function resolveVixsrc(payload) {
        var apiUrl = payload.mediaType === "tv"
            ? ("https://vixsrc.to/api/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode + "?primaryColor=ffffff")
            : ("https://vixsrc.to/api/movie/" + payload.tmdbId + "?primaryColor=ffffff");
        var json = await getJson(apiUrl, {
            "User-Agent": USER_AGENT,
            "Accept": "application/json, text/plain, */*",
            "Referer": payload.mediaType === "tv"
                ? ("https://vixsrc.to/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode + "?primaryColor=ffffff")
                : ("https://vixsrc.to/movie/" + payload.tmdbId + "?primaryColor=ffffff")
        }).catch(function () {
            return {};
        });

        var embedUrl = absoluteUrl("https://vixsrc.to/", json && json.src || "");
        if (!embedUrl) return [];

        var embedHtml = await getText(embedUrl, {
            "User-Agent": USER_AGENT,
            "Referer": payload.mediaType === "tv"
                ? ("https://vixsrc.to/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode + "?primaryColor=ffffff")
                : ("https://vixsrc.to/movie/" + payload.tmdbId + "?primaryColor=ffffff")
        }).catch(function () {
            return "";
        });
        if (!embedHtml) return [];

        var subtitles = normalizeSubtitleTracks(extractInlineTracks(embedHtml, embedUrl).concat(extractSubtitleUrls(embedHtml, embedUrl)));
        var masterUrl = extractFirstMatch(embedHtml, /file:\s*["']([^"']+\.m3u8[^"']*)["']/i)
            || extractFirstMatch(embedHtml, /source:\s*["']([^"']+\.m3u8[^"']*)["']/i)
            || extractFirstMatch(embedHtml, /(https?:\/\/[^"' )]+\.m3u8(?:\?[^"' )]*)?)/i);
        if (!masterUrl) return [];

        return expandHlsStreams(masterUrl, defaultHeaders({
            "Referer": "https://vixsrc.to/",
            "Origin": "https://vixsrc.to"
        }), "VixSrc", {
            subtitles: subtitles,
            quality: qualityFromText(masterUrl),
            referer: "https://vixsrc.to/",
            mirrorHosts: ["vixsrc.to"]
        });
    }

    async function resolvePrimewire(payload) {
        var query = payload.mediaType === "tv"
            ? ("tmdb=" + payload.tmdbId + "&type=tv&season=" + payload.season + "&episode=" + payload.episode)
            : ("tmdb=" + payload.tmdbId + "&type=movie");

        var listJson = await getJson("https://primewire.mov/api/v1/s?" + query, {
            "User-Agent": USER_AGENT,
            "Accept": "application/json, text/plain, */*",
            "Referer": payload.mediaType === "tv"
                ? ("https://primewire.mov/embed/tv?tmdb=" + payload.tmdbId + "&season=" + payload.season + "&episode=" + payload.episode)
                : ("https://primewire.mov/embed/movie?tmdb=" + payload.tmdbId)
        }).catch(function () {
            return {};
        });

        var servers = listJson && listJson.servers || [];
        if (!servers.length) return [];

        var preferred = ["PrimeVid", "Voe", "Streamwish", "Filemoon", "Mixdrop", "VidNest", "Vidmoly"];
        servers = servers.slice().sort(function (a, b) {
            var aName = trim(a && a.name || "");
            var bName = trim(b && b.name || "");
            var aRank = preferred.indexOf(aName);
            var bRank = preferred.indexOf(bName);
            if (aRank < 0) aRank = preferred.length + 10;
            if (bRank < 0) bRank = preferred.length + 10;
            return aRank - bRank;
        }).slice(0, 8);

        var results = [];
        for (var i = 0; i < servers.length; i++) {
            var server = servers[i] || {};
            var key = trim(server.key || "");
            if (!key) continue;
            var linkJson = await getJson("https://primewire.mov/api/v1/l?key=" + encodeURIComponent(key), {
                "User-Agent": USER_AGENT,
                "Accept": "application/json, text/plain, */*",
                "Referer": payload.mediaType === "tv"
                    ? ("https://primewire.mov/embed/tv?tmdb=" + payload.tmdbId + "&season=" + payload.season + "&episode=" + payload.episode)
                    : ("https://primewire.mov/embed/movie?tmdb=" + payload.tmdbId)
            }).catch(function () {
                return {};
            });
            var link = trim(linkJson && linkJson.link || "");
            if (!link) continue;

            if (/vidora\.stream/i.test(link)) {
                results = results.concat(await resolveVidoraEmbed(link, "PrimeWire - " + trim(server.name || "Vidora")).catch(function () {
                    return [];
                }));
                continue;
            }

            if (/\.m3u8(?:$|\?)/i.test(link)) {
                results = results.concat(await expandHlsStreams(link, defaultHeaders({
                    "Referer": "https://primewire.mov/",
                    "Origin": "https://primewire.mov"
                }), "PrimeWire - " + trim(server.name || "Stream"), {
                    subtitles: [],
                    quality: qualityFromText((server.file_name || "") + " " + link),
                    referer: "https://primewire.mov/",
                    mirrorHosts: ["primewire.mov"]
                }).catch(function () {
                    return [];
                }));
            }
        }
        return results;
    }

    function customBase64Encode(inputBytes) {
        var sourceChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
        var targetChars = "4jrpDdPNYKMiBLgwczuHGksmOIoS2-JVRCnbfl769A0UeE5Qyt_aWq1xTF3vhXZ8";
        var encoded = uint8ArrayToBase64(inputBytes).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/g, "");
        var out = "";
        for (var i = 0; i < encoded.length; i++) {
            var index = sourceChars.indexOf(encoded[i]);
            out += index === -1 ? encoded[i] : targetChars[index];
        }
        return out;
    }

    function generateKsa(seedBytes, size) {
        var s = seedBytes;
        var state = (
            ((s[0] | (s[1] << 8) | (s[2] << 16) | (s[3] << 24)) >>> 0) ^
            ((s[4] | (s[5] << 8) | (s[6] << 16) | (s[7] << 24)) >>> 0) ^
            ((s[8] | (s[9] << 8) | (s[10] << 16) | (s[11] << 24)) >>> 0) ^
            ((s[12] | (s[13] << 8) | (s[14] << 16) | (s[15] << 24)) >>> 0)
        ) >>> 0;
        var box = [];
        for (var i = 0; i < size; i++) box[i] = i;
        for (var j = size - 1; j > 0; j--) {
            state ^= (state << 13) >>> 0;
            state ^= state >>> 17;
            state ^= (state << 5) >>> 0;
            state >>>= 0;
            var idx = state % (j + 1);
            var tmp = box[j];
            box[j] = box[idx];
            box[idx] = tmp;
        }
        return box;
    }

    function transformByte(inputByte, keyByte) {
        var r = keyByte % 8;
        var rotated = (((inputByte << r) | (inputByte >>> (8 - r))) & 255) >>> 0;
        return (rotated + (keyByte ^ 0xA5)) & 255;
    }

    function shuffleBlocks(payload, pbox) {
        var numBlocks = pbox.length;
        if (!numBlocks || payload.length % numBlocks !== 0) {
            throw new Error("Invalid shuffle payload");
        }
        var blockSize = payload.length / numBlocks;
        var out = new Uint8Array(payload.length);
        for (var i = 0; i < numBlocks; i++) {
            var srcBlock = pbox[i];
            var srcStart = srcBlock * blockSize;
            var dstStart = i * blockSize;
            out.set(payload.slice(srcStart, srcStart + blockSize), dstStart);
        }
        return out;
    }

    function extractVidfastToken(html) {
        return extractFirstMatch(html, /"en":"([^"]+)"/i)
            || extractFirstMatch(html, /\\"en\\":\\"(.*?)\\"/i);
    }

    async function resolveVidzee(payload) {
        var baseApi = "https://player.vidzee.wtf/api/server?id=" + payload.tmdbId;
        var serverIds = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
        var results = [];
        var dedupe = {};
        for (var i = 0; i < serverIds.length; i++) {
            try {
                var apiUrl = baseApi + "&sr=" + serverIds[i];
                if (payload.mediaType === "tv") {
                    apiUrl += "&ss=" + payload.season + "&ep=" + payload.episode;
                }
                var json = await getJson(apiUrl, {
                    "User-Agent": USER_AGENT,
                    "Referer": "https://player.vidzee.wtf/"
                });
                var rows = json && json.url || [];
                var subtitles = normalizeSubtitleTracks(json && json.tracks || []);
                for (var j = 0; j < rows.length; j++) {
                    var row = rows[j];
                    if (!row || !row.link) continue;
                    var direct = await decryptAesCbc(row.link, VIDZEE_SECRET).catch(function () {
                        return "";
                    });
                    if (!/^https?:\/\//i.test(direct) || dedupe[direct]) continue;
                    dedupe[direct] = true;
                    var quality = qualityFromText(direct + " " + (row.name || "") + " " + (row.message || ""));
                    var serverName = trim((json.serverInfo && json.serverInfo.name) || row.name || ("Server " + serverIds[i]));
                    var lang = trim(row.lang || (json.serverInfo && json.serverInfo.language) || "");
                    var sourceLabel = "Vidzee - " + serverName + (lang ? " [" + lang + "]" : "");
                    var headers = defaultHeaders({
                        "Referer": "https://player.vidzee.wtf/",
                        "Origin": "https://player.vidzee.wtf"
                    });
                    if (isLikelyHls(direct)) {
                        var expanded = await expandHlsStreams(direct, headers, sourceLabel, {
                            subtitles: subtitles,
                            quality: quality,
                            referer: "https://player.vidzee.wtf/",
                            mirrorHosts: ["player.vidzee.wtf", "vidzee.wtf"]
                        });
                        results = results.concat(expanded);
                    } else {
                        results.push(buildPlayableStreamResult(
                            direct,
                            sourceLabel,
                            headers,
                            quality,
                            {
                                subtitles: subtitles,
                                forceProxy: false,
                                referer: "https://player.vidzee.wtf/",
                                mirrorHosts: ["player.vidzee.wtf", "vidzee.wtf"]
                            }
                        ));
                    }
                }
            } catch (_) {}
        }
        return results;
    }

    async function resolveVidsrcIcu(payload) {
        var embedUrl = payload.mediaType === "tv"
            ? ("https://vidsrc.icu/embed/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode)
            : ("https://vidsrc.icu/embed/movie/" + payload.tmdbId);

        var outerHtml = await getText(embedUrl, {
            "User-Agent": USER_AGENT,
            "Referer": BASE_URL + "/"
        }).catch(function () {
            return "";
        });
        if (!outerHtml) return [];

        var middleUrl = extractFirstMatch(outerHtml, /id=["']videoIframe["'][^>]+src=["']([^"']+)["']/i);
        if (!middleUrl) return [];
        middleUrl = absoluteUrl(embedUrl, middleUrl);

        var middleHtml = await getText(middleUrl, {
            "User-Agent": USER_AGENT,
            "Referer": embedUrl
        }).catch(function () {
            return "";
        });
        if (!middleHtml) return [];

        var rcpUrl = extractFirstMatch(middleHtml, /id=["']player_iframe["'][^>]+src=["']([^"']+)["']/i);
        if (!rcpUrl) return [];
        rcpUrl = absoluteUrl(middleUrl, rcpUrl);

        var rcpHtml = await getText(rcpUrl, {
            "User-Agent": USER_AGENT,
            "Referer": middleUrl
        }).catch(function () {
            return "";
        });
        if (!rcpHtml) return [];

        var prorcpPath = extractFirstMatch(rcpHtml, /src:\s*['"]([^'"]*\/prorcp\/[^'"]+)['"]/i)
            || extractFirstMatch(rcpHtml, /["'](\/prorcp\/[^"']+)["']/i);
        if (!prorcpPath) return [];

        var prorcpUrl = absoluteUrl(rcpUrl, prorcpPath);
        var playerHtml = await getText(prorcpUrl, {
            "User-Agent": USER_AGENT,
            "Referer": rcpUrl
        }).catch(function () {
            return "";
        });
        if (!playerHtml) return [];

        var fileString = extractFirstMatch(playerHtml, /file:\s*"([^"]+)"/i)
            || extractFirstMatch(playerHtml, /file:\s*'([^']+)'/i);
        if (!fileString) return [];
        var inlineTracks = extractInlineTracks(playerHtml, prorcpUrl);

        var headers = {
            "User-Agent": USER_AGENT,
            "Referer": "https://cloudnestra.com/"
        };
        var hostMap = {
            "{v1}": "cloudnestra.com",
            "{v2}": "cloudnestra.com",
            "{v3}": "cloudnestra.com",
            "{v4}": "cloudnestra.com"
        };
        var candidates = fileString.split(" or ").map(function (item) {
            var url = trim(item);
            var key;
            for (key in hostMap) {
                if (Object.prototype.hasOwnProperty.call(hostMap, key)) {
                    url = url.split(key).join(hostMap[key]);
                }
            }
            return url;
        }).filter(function (item) {
            return /^https?:\/\//i.test(item) && item.indexOf("{v") === -1;
        });

        candidates = uniqueBy(candidates, function (item) {
            return item;
        });

        var results = [];
        for (var i = 0; i < candidates.length; i++) {
            var candidate = candidates[i];
            try {
                var probe = await request(candidate, { headers: headers });
                var body = String(probe && probe.body || "");
                if ((probe && probe.status >= 200 && probe.status < 300) && /^#EXTM3U/i.test(body)) {
                    results = results.concat(await expandHlsStreams(candidate, headers, "VidSrc ICU", {
                        subtitles: inlineTracks,
                        quality: qualityFromText(candidate + " " + body),
                        referer: "https://cloudnestra.com/",
                        mirrorHosts: ["tmstr5.cloudnestra.com", "cloudnestra.com"]
                    }, body));
                }
            } catch (_) {}
        }

        return results;
    }

    async function resolveVidfast(payload) {
        var embedUrl = payload.mediaType === "tv"
            ? ("https://vidfast.pro/tv/" + payload.tmdbId + "/" + payload.season + "/" + payload.episode + "?autoPlay=false&title=true&poster=true&nextButton=false&autoNext=false&theme=ffffff")
            : ("https://vidfast.pro/movie/" + payload.tmdbId + "?autoPlay=false&title=true&poster=true&nextButton=false&autoNext=false&theme=ffffff");

        var pageHtml = await getText(embedUrl, VIDFAST_HEADERS).catch(function () {
            return "";
        });
        if (!pageHtml) return [];

        var rawData = extractVidfastToken(pageHtml);
        if (!rawData) return [];

        var aesKey = hexToBytes(VIDFAST_AES_KEY);
        var aesIv = hexToBytes(VIDFAST_AES_IV);
        var xorSeedKey = hexToBytes(VIDFAST_XOR_SEED_KEY);
        var randomIv = getRandomBytes(16);
        var timestamp = Date.now();
        var timestampBytes = new Uint8Array(8);
        for (var i = 0; i < 8; i++) {
            timestampBytes[i] = timestamp & 255;
            timestamp = Math.floor(timestamp / 256);
        }

        var combinedInput = concatBytes([randomIv, timestampBytes, utf8ToBytes(rawData)]);
        var paddedInput = pkcs7Pad(combinedInput, 16);
        var encrypted = await encryptAesCbcRaw(paddedInput, aesKey, aesIv);

        var xorSeed = concatBytes([xorSeedKey, randomIv]);
        var xorHash = await sha256Bytes(xorSeed);
        var xorOutput = new Uint8Array(encrypted.length);
        for (var j = 0; j < encrypted.length; j++) {
            if (j > 0 && j % xorHash.length === 0) {
                xorHash = await sha256Bytes(xorHash);
            }
            xorOutput[j] = encrypted[j] ^ xorHash[j % xorHash.length];
        }

        var transformSeed = concatBytes([aesKey, randomIv]);
        var transformHash = await sha256Bytes(transformSeed);
        var transformOutput = new Uint8Array(xorOutput.length);
        for (var k = 0; k < xorOutput.length; k++) {
            transformOutput[k] = transformByte(xorOutput[k], transformHash[k % transformHash.length]);
        }

        var ksaSeed = concatBytes([randomIv, xorSeedKey, aesIv]);
        var ksaHash = await sha256Bytes(ksaSeed);
        var ksa = generateKsa(ksaHash, 256);
        var payloadSwaps = new Uint8Array(transformOutput.length);
        for (var n = 0; n < transformOutput.length; n++) {
            payloadSwaps[n] = ksa[transformOutput[n] & 255] & 255;
        }

        var permutationCount = Math.floor(payloadSwaps.length / 16);
        if (!permutationCount) return [];
        var trimmedPayload = payloadSwaps.slice(0, permutationCount * 16);
        var blockShuffleSeed = concatBytes([xorSeedKey, randomIv]);
        var blockShuffleHash = await sha256Bytes(blockShuffleSeed);
        var permKsa = generateKsa(blockShuffleHash, permutationCount);
        var shuffled = shuffleBlocks(trimmedPayload, permKsa);

        var permSeed = concatBytes([aesKey, randomIv, new Uint8Array([shuffled.length & 255])]);
        var permHash = await sha256Bytes(permSeed);
        var permSBox = generateKsa(permHash, 112);
        var finalPayload = new Uint8Array(permSBox.length);
        for (var p = 0; p < permSBox.length; p++) {
            finalPayload[p] = shuffled[permSBox[p]];
        }

        var swapOrder = new Uint8Array(permKsa.length * 4);
        for (var q = 0; q < permKsa.length; q++) {
            swapOrder[q * 4] = permKsa[q];
        }

        var finalBuffer = concatBytes([swapOrder, finalPayload]);
        var footerHash = await sha256Bytes(finalBuffer);
        var footer = footerHash.slice(0, 8);
        var finalPacket = concatBytes([
            new Uint8Array([1]),
            randomIv,
            new Uint8Array([permutationCount & 255, 0]),
            finalBuffer,
            footer
        ]);

        var encoded = customBase64Encode(finalPacket);
        var reversedBytes = reverseBytes(utf8ToBytes(encoded));
        var serversToken = hexFromBytes(reversedBytes);
        var serversUrl = "https://vidfast.pro/" + VIDFAST_STATIC_PATH + "/N1dm4OEpPc8/" + serversToken;
        var serversJson = await getJson(serversUrl, VIDFAST_HEADERS).catch(function () {
            return [];
        });
        var server = serversJson && serversJson[0] && serversJson[0].data;
        if (!server) return [];

        var streamApiUrl = "https://vidfast.pro/" + VIDFAST_STATIC_PATH + "/HSgMMZOauoo/" + server;
        var streamJson = await getJson(streamApiUrl, VIDFAST_HEADERS).catch(function () {
            return {};
        });
        var finalUrl = trim(streamJson && streamJson.url || "");
        if (!/^https?:\/\//i.test(finalUrl)) return [];
        var subtitles = normalizeSubtitleTracks(streamJson && streamJson.tracks || []);

        var headers = defaultHeaders({
            "Referer": "https://vidfast.pro/",
            "Origin": "https://vidfast.pro"
        });
        if (isLikelyHls(finalUrl)) {
            return await expandHlsStreams(finalUrl, headers, "VidFast", {
                subtitles: subtitles,
                quality: qualityFromText(finalUrl + " " + server),
                referer: "https://vidfast.pro/",
                mirrorHosts: ["vidfast.pro", "begin.10017.workers.dev", "workers.dev"]
            });
        }

        return [buildPlayableStreamResult(
            finalUrl,
            "VidFast",
            headers,
            qualityFromText(finalUrl + " " + server),
            {
                subtitles: subtitles,
                forceProxy: false,
                referer: "https://vidfast.pro/",
                mirrorHosts: ["vidfast.pro", "begin.10017.workers.dev", "workers.dev"]
            }
        )];
    }

    async function loadSeriesEpisodes(detail, fallbackTmdbId, fallbackTitle) {
        var episodes = [];
        var seasonNumbers = [];
        var seasons = detail && detail.seasons || [];
        var seriesId = Number(detail && detail.id || fallbackTmdbId || 0);
        if (!seriesId) return episodes;
        if (seasons.length) {
            for (var i = 0; i < seasons.length; i++) {
                var season = seasons[i];
                if (!season || !season.season_number || season.season_number < 1) continue;
                if (season.air_date && new Date(season.air_date).getTime() > Date.now()) continue;
                seasonNumbers.push(Number(season.season_number));
            }
        } else {
            for (var s = 1; s <= 20; s++) seasonNumbers.push(s);
        }
        for (var n = 0; n < seasonNumbers.length; n++) {
            var seasonNumber = seasonNumbers[n];
            var seasonInfo = await tmdbGet("/tv/" + seriesId + "/season/" + seasonNumber + "?language=en-US").catch(function () {
                return {};
            });
            var seasonEpisodes = seasonInfo && seasonInfo.episodes || [];
            if (!seasonEpisodes.length && !seasons.length && seasonNumber > 3) break;
            for (var j = 0; j < seasonEpisodes.length; j++) {
                var episode = seasonEpisodes[j];
                if (!episode || !episode.episode_number) continue;
                if (episode.air_date && new Date(episode.air_date).getTime() > Date.now()) continue;
                episodes.push(new Episode({
                    name: trim(episode.name || ("Episode " + episode.episode_number)),
                    url: buildPayload({
                        mode: "stream",
                        tmdbId: seriesId,
                        mediaType: "tv",
                        imdbId: trim(detail.external_ids && detail.external_ids.imdb_id || ""),
                        season: Number(seasonNumber),
                        episode: Number(episode.episode_number),
                        title: trim(detail.name || detail.original_name || fallbackTitle || "")
                    }),
                    season: Number(seasonNumber),
                    episode: Number(episode.episode_number),
                    description: trim(episode.overview || ""),
                    posterUrl: tmdbImage(episode.still_path) || tmdbImage(seasonInfo.poster_path) || tmdbImage(detail.poster_path),
                    headers: defaultHeaders(),
                    streams: []
                }));
            }
        }
        return episodes;
    }

    async function getHome(cb) {
        try {
            var home = {};
            for (var i = 0; i < HOME_ROWS.length; i++) {
                var row = HOME_ROWS[i];
                var items = await fetchHomeRow(row);
                if (items.length) home[row.title] = items;
            }
            cb({ success: true, data: home });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: toErrorMessage(error) });
        }
    }

    async function search(query, cb) {
        try {
            var q = trim(query);
            if (!q) return cb({ success: true, data: [] });
            var searchJson = await tmdbGet("/search/multi?query=" + encodeURIComponent(q) + "&include_adult=false&language=en-US&page=1");
            var results = uniqueBy((searchJson && searchJson.results || []).filter(function (item) {
                return item && (item.media_type === "movie" || item.media_type === "tv") && !shouldHideAnime(item);
            }).map(buildTmdbItem).filter(Boolean), function (item) {
                return item.url;
            });
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: toErrorMessage(error) });
        }
    }

    async function load(url, cb) {
        try {
            var payload = parsePayload(url);
            var tmdbId = Number(payload.tmdbId);
            var mediaType = payload.mediaType === "tv" ? "tv" : "movie";
            if (!tmdbId) throw new Error("Missing tmdbId");

            var detail = await fetchDetailBundle(tmdbId, mediaType);
            var title = trim(detail.title || detail.name || payload.title || "Unknown");
            var posterUrl = tmdbImage(detail.poster_path) || payload.posterUrl;
            var bannerUrl = tmdbImage(detail.backdrop_path) || payload.bannerUrl || posterUrl;
            var description = trim(detail.overview || payload.description || "");
            var year = Number(String(detail.release_date || detail.first_air_date || payload.year || "").slice(0, 4)) || undefined;
            var item = new MultimediaItem({
                title: title,
                url: buildPayload({
                    mode: "detail",
                    tmdbId: tmdbId,
                    mediaType: mediaType,
                    title: title,
                    description: description,
                    posterUrl: posterUrl,
                    bannerUrl: bannerUrl,
                    year: year
                }),
                posterUrl: posterUrl,
                bannerUrl: bannerUrl,
                logoUrl: selectLogo(detail.images),
                type: mediaType === "tv" ? "series" : "movie",
                description: description,
                year: year,
                score: typeof detail.vote_average === "number" ? Number(detail.vote_average.toFixed(1)) : undefined,
                duration: mediaType === "movie" ? Number(detail.runtime || 0) || undefined : undefined,
                status: normalizeStatus(detail.status, mediaType),
                contentRating: extractContentRating(detail, mediaType),
                isAdult: !!detail.adult,
                genres: (detail.genres || []).map(function (genre) { return trim(genre && genre.name); }).filter(Boolean),
                cast: mapActors(detail.credits && detail.credits.cast),
                trailers: mapTrailers(detail.videos),
                recommendations: mapRecommendations(detail.recommendations && detail.recommendations.results),
                headers: defaultHeaders(),
                episodes: []
            });

            if (mediaType === "movie") {
                item.episodes = [new Episode({
                    name: "Movie",
                    url: buildPayload({
                        mode: "stream",
                        tmdbId: tmdbId,
                        mediaType: "movie",
                        imdbId: trim(detail.external_ids && detail.external_ids.imdb_id || ""),
                        season: 1,
                        episode: 1,
                        title: title
                    }),
                    season: 1,
                    episode: 1,
                    description: description,
                    posterUrl: posterUrl,
                    headers: defaultHeaders(),
                    streams: []
                })];
            } else {
                item.episodes = await loadSeriesEpisodes(detail, tmdbId, title);
            }

            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: toErrorMessage(error) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parsePayload(url);
            if (payload.mode !== "stream") throw new Error("Invalid stream payload");

            var streams = [];
            streams = streams.concat(await resolveVidzee(payload).catch(function () {
                return [];
            }));
            streams = streams.concat(await resolveVidfast(payload).catch(function () {
                return [];
            }));
            streams = streams.concat(await resolveVidsrcIcu(payload).catch(function () {
                return [];
            }));
            if (payload.mediaType === "movie") {
                streams = streams.concat(await resolveMoviesclub(payload).catch(function () {
                    return [];
                }));
                streams = streams.concat(await resolvePrimewire(payload).catch(function () {
                    return [];
                }));
                streams = streams.concat(await resolveVidlink(payload).catch(function () {
                    return [];
                }));
                streams = streams.concat(await resolveVixsrc(payload).catch(function () {
                    return [];
                }));
            }
            streams = uniqueBy(streams, function (item) {
                return item && item.url;
            });
            streams = sortStreams(streams);
            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: toErrorMessage(error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
