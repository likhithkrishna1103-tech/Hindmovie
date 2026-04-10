(function() {
    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // var manifest is injected at runtime

    var DEFAULT_API_BASE = "https://api.hlowb.com";
    var PACKAGE_NAME = "com.external.castle";
    var CHANNEL = "IndiaA";
    var CLIENT_TYPE = "1";
    var LANG = "en-US";
    var LOCATION_ID = "1001";
    var MODE = "1";
    var APP_MARKET = "GuanWang";
    var APK_SIGN_KEY = "ED0955EB04E67A1D9F3305B95454FED485261475";
    var ANDROID_VERSION = "13";
    var CASTLE_SUFFIX = "T!BgJB";
    var SERIES_TYPES = { "1": true, "3": true, "5": true };
    var SKIP_HOME_ROWS = { "Hot Erotic Series": true, "Bollywood Star": true };
    var QUALITY_MAP = { "3": 1080, "2": 720, "1": 480 };
    var QUALITY_NAME_MAP = { "3": "1080p", "2": "720p", "1": "480p" };
    var DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36";

    function safeJsonParse(text) {
        try {
            return JSON.parse(text);
        } catch (e) {
            return null;
        }
    }

    function toMessage(error) {
        if (!error) return "Unknown error";
        if (typeof error === "string") return error;
        return error.stack || error.message || String(error);
    }

    function ensureString(value) {
        return value == null ? "" : String(value);
    }

    function getApiBase() {
        if (typeof manifest !== "undefined" && manifest && manifest.baseUrl) {
            return String(manifest.baseUrl).replace(/\/$/, "");
        }
        return DEFAULT_API_BASE;
    }

    function getPluginName() {
        if (typeof manifest !== "undefined" && manifest && manifest.name) {
            return String(manifest.name);
        }
        return "Castle TV";
    }

    function encodeMediaUrl(id) {
        return "castle://media/" + encodeURIComponent(String(id));
    }

    function encodePlayUrl(movieId, episodeId) {
        return "castle://play/" + encodeURIComponent(String(movieId)) + "_" + encodeURIComponent(String(episodeId));
    }

    function parseCastleUrl(url) {
        var raw = ensureString(url).trim();
        var decoded = raw;

        if (decoded.indexOf("castle://media/") === 0) {
            return { kind: "media", movieId: decodeURIComponent(decoded.substring("castle://media/".length)) };
        }

        if (decoded.indexOf("castle://play/") === 0) {
            var payload = decodeURIComponent(decoded.substring("castle://play/".length));
            var splitIndex = payload.indexOf("_");
            if (splitIndex === -1) {
                return { kind: "play", movieId: payload };
            }
            return {
                kind: "play",
                movieId: payload.substring(0, splitIndex),
                episodeId: payload.substring(splitIndex + 1)
            };
        }

        if (/^\d+_\d+$/.test(decoded)) {
            var parts = decoded.split("_");
            return { kind: "play", movieId: parts[0], episodeId: parts[1] };
        }

        if (/^\d+$/.test(decoded)) {
            return { kind: "media", movieId: decoded };
        }

        var tail = decoded.substring(decoded.lastIndexOf("/") + 1);
        if (/^\d+_\d+$/.test(tail)) {
            var tailParts = tail.split("_");
            return { kind: "play", movieId: tailParts[0], episodeId: tailParts[1] };
        }
        if (/^\d+$/.test(tail)) {
            return { kind: "media", movieId: tail };
        }

        return { kind: "media", movieId: decoded };
    }

    function buildHeaders(extra) {
        var apiBase = getApiBase();
        var headers = {
            "Referer": apiBase + "/",
            "Origin": apiBase,
            "Accept": "application/json, text/plain, */*",
            "Accept-Language": "en-US,en;q=0.9",
            "User-Agent": DEFAULT_USER_AGENT
        };
        if (extra) {
            Object.keys(extra).forEach(function(key) {
                headers[key] = extra[key];
            });
        }
        return headers;
    }

    async function httpGetText(url, headers) {
        var res = await http_get(url, buildHeaders(headers));
        if (!res || res.statusCode >= 400) {
            throw new Error("GET failed (" + (res ? res.statusCode : "unknown") + "): " + url + " -> " + (res ? res.body : "no response"));
        }
        return typeof res.body === "string" ? res.body : JSON.stringify(res.body);
    }

    async function httpPostText(url, body, headers) {
        var res = await http_post(
            url,
            buildHeaders(Object.assign({
                "Content-Type": "application/json; charset=utf-8"
            }, headers || {})),
            typeof body === "string" ? body : JSON.stringify(body)
        );
        if (!res || res.statusCode >= 400) {
            throw new Error("POST failed (" + (res ? res.statusCode : "unknown") + "): " + url + " -> " + (res ? res.body : "no response"));
        }
        return typeof res.body === "string" ? res.body : JSON.stringify(res.body);
    }

    function deriveKey(apiKeyB64) {
        var decodedKey = atob(apiKeyB64 || "");
        var keyMaterial = decodedKey + CASTLE_SUFFIX;
        if (keyMaterial.length < 16) {
            while (keyMaterial.length < 16) {
                keyMaterial += "\u0000";
            }
        }
        return keyMaterial.substring(0, 16);
    }

    async function tryBridgeDecrypt(encryptedB64, keyValue, ivValue) {
        if (typeof crypto !== "undefined" && crypto && typeof crypto.decryptAES === "function") {
            try {
                var viaCrypto = await crypto.decryptAES(encryptedB64, keyValue, ivValue);
                if (typeof viaCrypto === "string" && viaCrypto) {
                    return viaCrypto;
                }
            } catch (e) {}
        }

        if (typeof sendMessage === "function") {
            try {
                var viaMessage = await sendMessage("crypto_decrypt_aes", JSON.stringify({
                    data: encryptedB64,
                    key: keyValue,
                    iv: ivValue
                }));
                if (typeof viaMessage === "string" && viaMessage) {
                    return viaMessage;
                }
            } catch (e) {}
        }

        return null;
    }

    async function decryptData(encryptedB64, apiKeyB64) {
        if (!encryptedB64) return null;
        try {
            var aesKey = deriveKey(apiKeyB64);
            var keyB64 = btoa(aesKey);
            var candidates = [
                [aesKey, aesKey],
                [keyB64, keyB64]
            ];

            for (var i = 0; i < candidates.length; i++) {
                var decrypted = await tryBridgeDecrypt(encryptedB64, candidates[i][0], candidates[i][1]);
                if (typeof decrypted === "string" && decrypted && decrypted !== encryptedB64) {
                    return decrypted;
                }
            }

            return null;
        } catch (e) {
            return null;
        }
    }

    async function getSecurityKey() {
        var url = getApiBase() + "/v0.1/system/getSecurityKey/1?channel=" + CHANNEL + "&clientType=" + CLIENT_TYPE + "&lang=" + LANG;
        var body = await httpGetText(url);
        var payload = safeJsonParse(body);
        if (payload && payload.code === 200 && payload.data) {
            return payload.data;
        }
        return null;
    }

    function getEncryptedPayload(body) {
        var payload = safeJsonParse(body);
        if (payload && typeof payload.data === "string") {
            return payload.data;
        }
        return ensureString(body).trim();
    }

    async function getDecryptedJson(url) {
        var securityKey = await getSecurityKey();
        if (!securityKey) {
            throw new Error("Unable to fetch CastleTV security key");
        }

        var body = await httpGetText(url);
        var encryptedPayload = getEncryptedPayload(body);
        if (!encryptedPayload) {
            throw new Error("CastleTV returned an empty encrypted payload");
        }

        var directPayload = safeJsonParse(encryptedPayload);
        if (directPayload && typeof directPayload === "object") {
            return {
                securityKey: securityKey,
                data: directPayload
            };
        }

        var decrypted = await decryptData(encryptedPayload, securityKey);
        if (!decrypted) {
            throw new Error("CastleTV payload decryption failed");
        }

        var parsed = safeJsonParse(decrypted);
        if (!parsed) {
            throw new Error("CastleTV decrypted payload was not valid JSON");
        }

        return {
            securityKey: securityKey,
            data: parsed
        };
    }

    async function postDecryptedJson(url, body, securityKey) {
        var payloadKey = securityKey || await getSecurityKey();
        if (!payloadKey) {
            throw new Error("Unable to fetch CastleTV security key");
        }

        var responseText = await httpPostText(url, body);
        var encryptedPayload = getEncryptedPayload(responseText);
        if (!encryptedPayload) {
            throw new Error("CastleTV returned an empty encrypted payload");
        }

        var directPayload = safeJsonParse(encryptedPayload);
        if (directPayload && typeof directPayload === "object") {
            return {
                securityKey: payloadKey,
                data: directPayload
            };
        }

        var decrypted = await decryptData(encryptedPayload, payloadKey);
        if (!decrypted) {
            throw new Error("CastleTV payload decryption failed");
        }

        var parsed = safeJsonParse(decrypted);
        if (!parsed) {
            throw new Error("CastleTV decrypted payload was not valid JSON");
        }

        return {
            securityKey: payloadKey,
            data: parsed
        };
    }

    function getYearFromTimestamp(timestamp) {
        if (!timestamp) return undefined;
        try {
            return new Date(Number(timestamp)).getFullYear();
        } catch (e) {
            return undefined;
        }
    }

    function normalizeType(movieType) {
        return SERIES_TYPES[String(movieType)] ? "series" : "movie";
    }

    function buildSearchItem(id, title, posterUrl, movieType, description, bannerUrl, extra) {
        return new MultimediaItem(Object.assign({
            title: title,
            url: encodeMediaUrl(id),
            posterUrl: posterUrl || undefined,
            bannerUrl: bannerUrl || undefined,
            type: normalizeType(movieType),
            description: description || undefined,
            headers: buildHeaders()
        }, extra || {}));
    }

    function mapActor(actor) {
        return new Actor({
            name: actor && actor.name ? actor.name : "",
            image: actor && actor.avatar ? actor.avatar : undefined
        });
    }

    function buildRecommendation(item, fallbackType) {
        if (!item || !item.id || !item.name) return null;
        return new MultimediaItem({
            title: item.name,
            url: encodeMediaUrl(item.id),
            posterUrl: item.coverImage || undefined,
            type: fallbackType || "movie",
            headers: buildHeaders()
        });
    }

    async function fetchMovieDetails(movieId, securityKey) {
        var url = getApiBase()
            + "/film-api/v1.9.9/movie?channel=" + CHANNEL
            + "&clientType=" + CLIENT_TYPE
            + "&clientType=" + CLIENT_TYPE
            + "&lang=" + LANG
            + "&movieId=" + encodeURIComponent(movieId)
            + "&packageName=" + PACKAGE_NAME;

        var decrypted = await getDecryptedJson(url);
        if (securityKey && decrypted.securityKey !== securityKey) {
            // Keep the caller-provided key only when it is available; the API can rotate,
            // so use the latest working key from the response pipeline.
        }
        return {
            securityKey: decrypted.securityKey,
            details: decrypted.data && decrypted.data.data ? decrypted.data.data : null
        };
    }

    async function collectEpisodes(details, securityKey) {
        var allEpisodes = [];
        var responseKey = securityKey;

        if (details && details.seasons && details.seasons.length > 1) {
            for (var i = 0; i < details.seasons.length; i++) {
                var season = details.seasons[i];
                if (!season || !season.movieId) continue;

                try {
                    var seasonData = await fetchMovieDetails(String(season.movieId), responseKey);
                    responseKey = seasonData.securityKey || responseKey;
                    var seasonDetails = seasonData.details;
                    var seasonEpisodes = seasonDetails && seasonDetails.episodes ? seasonDetails.episodes : [];

                    for (var j = 0; j < seasonEpisodes.length; j++) {
                        var seasonEpisode = seasonEpisodes[j];
                        if (!seasonEpisode || !seasonEpisode.id) continue;

                        allEpisodes.push(new Episode({
                            name: seasonEpisode.title || ("Episode " + (seasonEpisode.number || (j + 1))),
                            url: encodePlayUrl(season.movieId, seasonEpisode.id),
                            season: season.number || 1,
                            episode: seasonEpisode.number || (j + 1),
                            description: undefined,
                            posterUrl: seasonEpisode.coverImage || undefined,
                            headers: buildHeaders()
                        }));
                    }
                } catch (e) {
                    console.warn("Skipping CastleTV season fetch:", season.movieId, toMessage(e));
                }
            }
        } else {
            var episodes = details && details.episodes ? details.episodes : [];
            for (var k = 0; k < episodes.length; k++) {
                var episode = episodes[k];
                if (!episode || !episode.id) continue;

                allEpisodes.push(new Episode({
                    name: episode.title || ("Episode " + (episode.number || (k + 1))),
                    url: encodePlayUrl(details.id, episode.id),
                    season: details.seasonNumber || 1,
                    episode: episode.number || (k + 1),
                    description: undefined,
                    posterUrl: episode.coverImage || undefined,
                    headers: buildHeaders()
                }));
            }
        }

        return {
            securityKey: responseKey,
            episodes: allEpisodes
        };
    }

    function uniqueStreams(streams) {
        var seen = {};
        var finalStreams = [];

        for (var i = 0; i < streams.length; i++) {
            var stream = streams[i];
            var key = stream.url + "|" + stream.source;
            if (seen[key]) continue;
            seen[key] = true;
            finalStreams.push(stream);
        }

        return finalStreams;
    }

    function buildStreamSource(title, languageName, resolution, isPreview) {
        var parts = [title || getPluginName()];
        if (languageName) parts.push(languageName);
        if (QUALITY_NAME_MAP[String(resolution)]) parts.push(QUALITY_NAME_MAP[String(resolution)]);
        if (isPreview) parts.push("preview");
        return parts.join(" - ");
    }

    async function resolveVideoPayload(movieId, episodeId, languageId, resolution, securityKey) {
        var url = getApiBase() + "/film-api/v2.0.1/movie/getVideo2?clientType=" + CLIENT_TYPE + "&packageName=" + PACKAGE_NAME + "&channel=" + CHANNEL + "&lang=" + LANG;
        var body = {
            mode: MODE,
            appMarket: APP_MARKET,
            clientType: CLIENT_TYPE,
            woolUser: "false",
            apkSignKey: APK_SIGN_KEY,
            androidVersion: ANDROID_VERSION,
            movieId: String(movieId),
            episodeId: String(episodeId),
            isNewUser: "true",
            resolution: String(resolution),
            packageName: PACKAGE_NAME
        };

        if (languageId != null && languageId !== "") {
            body.languageId = String(languageId);
        }

        return postDecryptedJson(url, body, securityKey);
    }

    /**
     * Loads the home screen categories.
     * @param {(res: Response) => void} cb
     */
    async function getHome(cb) {
        try {
            var url = getApiBase()
                + "/film-api/v0.1/category/home?channel=" + CHANNEL
                + "&clientType=" + CLIENT_TYPE
                + "&clientType=" + CLIENT_TYPE
                + "&lang=" + LANG
                + "&locationId=" + LOCATION_ID
                + "&mode=" + MODE
                + "&packageName=" + PACKAGE_NAME
                + "&page=1&size=17";

            var decrypted = await getDecryptedJson(url);
            var rows = decrypted.data && decrypted.data.data && decrypted.data.data.rows ? decrypted.data.data.rows : [];
            var home = {};

            for (var i = 0; i < rows.length; i++) {
                var row = rows[i];
                var rowName = row && row.name ? row.name : "Unknown Category";
                if (SKIP_HOME_ROWS[rowName]) continue;

                var contents = row && row.contents ? row.contents : [];
                var items = [];

                for (var j = 0; j < contents.length; j++) {
                    var item = contents[j];
                    if (!item || !item.redirectId || !item.title) continue;

                    items.push(buildSearchItem(
                        item.redirectId,
                        item.title,
                        item.coverImage,
                        item.movieType,
                        item.briefIntroduction
                    ));
                }

                if (items.length > 0) {
                    home[rowName] = items;
                }
            }

            cb({ success: true, data: home });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: toMessage(e) });
        }
    }

    /**
     * Searches for media items.
     * @param {string} query
     * @param {(res: Response) => void} cb
     */
    async function search(query, cb) {
        try {
            if (!query || !query.trim()) {
                cb({ success: true, data: [] });
                return;
            }

            var encodedQuery = encodeURIComponent(query.trim());
            var url = getApiBase()
                + "/film-api/v1.1.0/movie/searchByKeyword?channel=" + CHANNEL
                + "&clientType=" + CLIENT_TYPE
                + "&clientType=" + CLIENT_TYPE
                + "&keyword=" + encodedQuery
                + "&lang=" + LANG
                + "&mode=" + MODE
                + "&packageName=" + PACKAGE_NAME
                + "&page=1&size=30";

            var decrypted = await getDecryptedJson(url);
            var rows = decrypted.data && decrypted.data.data && decrypted.data.data.rows ? decrypted.data.data.rows : [];
            var results = [];

            for (var i = 0; i < rows.length; i++) {
                var item = rows[i];
                if (!item || !item.id || !item.title) continue;

                results.push(buildSearchItem(
                    item.id,
                    item.title,
                    item.coverVerticalImage || item.coverHorizontalImage,
                    item.movieType,
                    item.briefIntroduction,
                    item.coverHorizontalImage,
                    { year: getYearFromTimestamp(item.publishTime) }
                ));
            }

            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: toMessage(e) });
        }
    }

    /**
     * Loads details for a specific media item.
     * @param {string} url
     * @param {(res: Response) => void} cb
     */
    async function load(url, cb) {
        try {
            var parsed = parseCastleUrl(url);
            var movieId = parsed.movieId;
            if (!movieId) {
                throw new Error("Invalid CastleTV media URL: " + url);
            }

            var detailsResult = await fetchMovieDetails(movieId);
            var securityKey = detailsResult.securityKey;
            var details = detailsResult.details;
            if (!details) {
                throw new Error("CastleTV returned empty media details");
            }

            var title = details.title || "Unknown Title";
            var posterUrl = details.coverVerticalImage || details.coverHorizontalImage || undefined;
            var bannerUrl = details.coverHorizontalImage || details.coverVerticalImage || undefined;
            var plot = details.briefIntroduction || undefined;
            var year = getYearFromTimestamp(details.publishTime);
            var score = details.score || undefined;
            var tags = details.tags || undefined;
            var cast = (details.actors || []).map(mapActor);
            var fallbackType = normalizeType(details.movieType);
            var recommendations = [];
            var titbits = details.titbits || [];

            for (var i = 0; i < titbits.length; i++) {
                var recommendation = buildRecommendation(titbits[i], fallbackType);
                if (recommendation) recommendations.push(recommendation);
            }

            var isSeriesLike = !!SERIES_TYPES[String(details.movieType)] || ((details.episodes || []).length > 1);

            if (isSeriesLike) {
                var collected = await collectEpisodes(details, securityKey);
                var episodes = collected.episodes;

                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: title,
                        url: encodeMediaUrl(details.id || movieId),
                        posterUrl: posterUrl,
                        bannerUrl: bannerUrl,
                        type: "series",
                        description: plot,
                        year: year,
                        score: score,
                        duration: details.episodes && details.episodes[0] && details.episodes[0].duration ? Math.round(details.episodes[0].duration / 60) : undefined,
                        status: details.seasonDescription && details.seasonDescription.toLowerCase().indexOf("season") !== -1 ? "ongoing" : "completed",
                        tags: tags,
                        cast: cast,
                        recommendations: recommendations,
                        headers: buildHeaders(),
                        episodes: episodes
                    })
                });
                return;
            }

            var firstEpisode = details.episodes && details.episodes.length ? details.episodes[0] : null;
            if (!firstEpisode || !firstEpisode.id) {
                throw new Error("CastleTV movie did not include a playable episode id");
            }

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: encodePlayUrl(details.id || movieId, firstEpisode.id),
                    posterUrl: posterUrl,
                    bannerUrl: bannerUrl,
                    type: "movie",
                    description: plot,
                    year: year,
                    score: score,
                    duration: firstEpisode.duration ? Math.round(firstEpisode.duration / 60) : undefined,
                    tags: tags,
                    cast: cast,
                    recommendations: recommendations,
                    headers: buildHeaders()
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: toMessage(e) });
        }
    }

    /**
     * Resolves streams for a specific media item or episode.
     * @param {string} url
     * @param {(res: Response) => void} cb
     */
    async function loadStreams(url, cb) {
        try {
            var parsed = parseCastleUrl(url);
            var movieId = parsed.movieId;
            var episodeId = parsed.episodeId;

            if (!movieId) {
                throw new Error("Invalid CastleTV stream URL: " + url);
            }

            var detailsResult = await fetchMovieDetails(movieId);
            var securityKey = detailsResult.securityKey;
            var details = detailsResult.details;
            if (!details) {
                throw new Error("CastleTV returned empty media details");
            }

            if (!episodeId) {
                var firstEpisode = details.episodes && details.episodes.length ? details.episodes[0] : null;
                if (!firstEpisode || !firstEpisode.id) {
                    throw new Error("No episode id available for movie stream resolution");
                }
                episodeId = String(firstEpisode.id);
            }

            var episode = null;
            var episodes = details.episodes || [];
            for (var i = 0; i < episodes.length; i++) {
                if (String(episodes[i].id) === String(episodeId)) {
                    episode = episodes[i];
                    break;
                }
            }

            if (!episode) {
                throw new Error("CastleTV episode not found for stream resolution");
            }

            var title = details.title || getPluginName();
            var streams = [];
            var availableTracks = episode.tracks || [];
            var resolutions = [3, 2, 1];
            var videoLoaded = false;
            var hasIndividualVideo = false;

            for (var j = 0; j < availableTracks.length; j++) {
                if (availableTracks[j] && availableTracks[j].existIndividualVideo === true) {
                    hasIndividualVideo = true;
                    break;
                }
            }

            if (!hasIndividualVideo) {
                var firstTrack = availableTracks.length ? availableTracks[0] : null;
                var allLanguageNames = availableTracks.length
                    ? availableTracks.map(function(track) {
                        return track.languageName || track.abbreviate;
                    }).filter(Boolean).join(", ")
                    : "Default";

                for (var r = 0; r < resolutions.length; r++) {
                    var resolution = resolutions[r];
                    try {
                        var videoResult = await resolveVideoPayload(movieId, episodeId, null, resolution, securityKey);
                        securityKey = videoResult.securityKey || securityKey;
                        var videoData = videoResult.data && videoResult.data.data ? videoResult.data.data : null;

                        if (videoData && videoData.videoUrl && videoData.permissionDenied !== true) {
                            streams.push(new StreamResult({
                                url: videoData.videoUrl,
                                source: buildStreamSource(title, allLanguageNames, resolution, /preview/i.test(videoData.videoUrl)),
                                quality: QUALITY_MAP[String(resolution)] || 0,
                                headers: buildHeaders()
                            }));
                            videoLoaded = true;
                        }
                    } catch (e) {
                        if (!firstTrack) {
                            console.warn("CastleTV fallback stream attempt failed:", toMessage(e));
                        }
                    }
                }
            } else {
                for (var t = 0; t < availableTracks.length; t++) {
                    var track = availableTracks[t];
                    if (!track || track.languageId == null) continue;

                    var languageName = track.languageName || track.abbreviate || "Unknown";

                    for (var x = 0; x < resolutions.length; x++) {
                        var trackResolution = resolutions[x];
                        try {
                            var trackVideoResult = await resolveVideoPayload(movieId, episodeId, track.languageId, trackResolution, securityKey);
                            securityKey = trackVideoResult.securityKey || securityKey;
                            var trackVideoData = trackVideoResult.data && trackVideoResult.data.data ? trackVideoResult.data.data : null;

                            if (trackVideoData && trackVideoData.videoUrl && trackVideoData.permissionDenied !== true) {
                                streams.push(new StreamResult({
                                    url: trackVideoData.videoUrl,
                                    source: buildStreamSource(title, languageName, trackResolution, /preview/i.test(trackVideoData.videoUrl)),
                                    quality: QUALITY_MAP[String(trackResolution)] || 0,
                                    headers: buildHeaders()
                                }));
                                videoLoaded = true;
                            }
                        } catch (e) {
                            console.warn("CastleTV per-language stream attempt failed:", languageName, trackResolution, toMessage(e));
                        }
                    }
                }
            }

            var finalStreams = uniqueStreams(streams);
            if (!videoLoaded || !finalStreams.length) {
                throw new Error("CastleTV did not return any playable stream links");
            }

            cb({ success: true, data: finalStreams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: toMessage(e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
