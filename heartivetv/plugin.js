(function () {
    "use strict";

    var BASE_URL = "https://heartivetv.pages.dev";
    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";
    var TMDB_BEARER = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyYmYwZmFlZWIzZjc3OWRhZDdkOWM3MjY4ZGM0NmNmNiIsIm5iZiI6MTcyMzkzMjM1MS4xNDEyNzIsInN1YiI6IjY2YzExZTJmOTk5ZmYwYTFjNTE2YWRhNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vwZW4D57fT-wlqLgHt_4vhnfTbuIwFOOrWE2DBlRHMQ";
    var VIDZEE_SECRET = "pleasedontscrapemesaywallahi";
    var aesJsPromise = null;

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
        try {
            return new URL(String(path || ""), String(base || "")).toString();
        } catch (_) {
            return String(path || "");
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

    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: quality ? (source + " [" + quality + "p]") : source,
            quality: quality,
            headers: headers || {}
        });
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

    async function decryptAesCbc(encryptedBlob, secret) {
        var decoded = decodeBase64ToString(encryptedBlob);
        var parts = decoded.split(":");
        if (parts.length < 2) throw new Error("Malformed encrypted payload");
        var iv = decodeBase64ToBytes(parts[0]);
        var ciphertext = decodeBase64ToBytes(parts.slice(1).join(":"));
        var keyMaterial = String(secret || "").padEnd(32, "\0").slice(0, 32);
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

    async function resolveVidzee(payload) {
        var baseApi = "https://player.vidzee.wtf/api/server?id=" + payload.tmdbId;
        var serverIds = [3, 4, 5, 7, 9, 10];
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
                    results.push(buildStreamResult(
                        direct,
                        "Vidzee - " + serverName + (lang ? " [" + lang + "]" : ""),
                        json.headers || { "Referer": "https://player.vidzee.wtf/" },
                        quality
                    ));
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
                    results.push(buildStreamResult(
                        candidate,
                        "VidSrc ICU",
                        headers,
                        qualityFromText(candidate + " " + body)
                    ));
                }
            } catch (_) {}
        }

        return results;
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
            streams = streams.concat(await resolveVidsrcIcu(payload).catch(function () {
                return [];
            }));
            streams = uniqueBy(streams, function (item) {
                return item && item.url;
            });
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
