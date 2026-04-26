(function () {
    "use strict";

    var CONFIG = {
  "key": "primevideo",
  "displayName": "PrimeVideo",
  "ott": "pv",
  "defaultBaseUrl": "https://net52.cc",
  "contentBases": [
    "https://net52.cc",
    "https://net22.cc"
  ],
  "homeBases": [
    "https://net52.cc",
    "https://net22.cc"
  ],
  "streamBases": [
    "https://net52.cc",
    "https://net22.cc"
  ],
  "cookieBases": [
    "https://net52.cc",
    "https://net22.cc"
  ],
  "tokenBases": [],
  "homeMode": "prime_json",
  "homePath": "/pv/homepage.php",
  "searchPath": "/pv/search.php",
  "detailPath": "/pv/post.php",
  "episodesPath": "/pv/episodes.php",
  "playlistPath": "/pv/playlist.php",
  "needsCookie": false,
  "needsVideoToken": false,
  "needsUserTokenOnHome": false,
  "posterUrl": "https://wsrv.nl/?url=https://imgcdn.kim/pv/v/{id}.jpg&w=500",
  "backgroundPosterUrl": "https://wsrv.nl/?url=https://imgcdn.kim/pv/h/{id}.jpg&w=500",
  "episodePosterUrl": "https://imgcdn.kim/pvepimg/150/{id}.jpg",
  "refererPath": "/home"
};
    var runtimeManifest = (typeof manifest !== "undefined" && manifest) ? manifest : { baseUrl: CONFIG.defaultBaseUrl };
    var COOKIE_CACHE = {};
    var DESKTOP_UA = "Mozilla/5.0 (X11; Linux x86_64; rv:139.0) Gecko/20100101 Firefox/139.0";
    var MOBILE_UA = "Mozilla/5.0 (Linux; Android 12; RMX2117 Build/SP1A.210812.016; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/147.0.7727.55 Mobile Safari/537.36 /OS.Gatu v3.0";
    var USER_TOKEN = "233123f803cf02184bf6c67e149cdd50";

    function trim(value) {
        return String(value == null ? "" : value).trim();
    }

    function normalizeBaseUrl(value) {
        var out = trim(value).replace(/\/+$/g, "");
        return out && !/example\.com/i.test(out) ? out : "";
    }

    function unixTime() {
        return Math.floor(Date.now() / 1000);
    }

    function unique(list) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var item = normalizeBaseUrl(list[i]);
            if (!item || seen[item]) continue;
            seen[item] = true;
            out.push(item);
        }
        return out;
    }

    function absoluteUrl(base, value) {
        if (!value) return normalizeBaseUrl(base);
        try {
            return new URL(String(value), String(base || "")).toString();
        } catch (_) {
            return String(value);
        }
    }

    function replaceId(template, id) {
        return String(template || "").replace(/\{id\}/g, encodeURIComponent(String(id || "")));
    }

    function parseJsonSafe(text, fallback) {
        try {
            return JSON.parse(String(text || ""));
        } catch (_) {
            return fallback;
        }
    }

    function extractResponseBody(response) {
        if (typeof response === "string") return response;
        if (response && typeof response.body === "string") return response.body;
        return "";
    }

    function extractResponseStatus(response) {
        if (response && typeof response.status !== "undefined") return response.status;
        if (response && typeof response.statusCode !== "undefined") return response.statusCode;
        return 200;
    }

    function normalizeHeaders(raw) {
        var headers = {};
        if (!raw) return headers;
        if (typeof raw.forEach === "function") {
            raw.forEach(function (value, key) {
                headers[String(key).toLowerCase()] = value;
            });
            return headers;
        }
        for (var key in raw) {
            if (!Object.prototype.hasOwnProperty.call(raw, key)) continue;
            headers[String(key).toLowerCase()] = raw[key];
        }
        return headers;
    }

    function extractCookiesFromHeaders(headers) {
        var out = {};
        var raw = headers["set-cookie"] || headers["set-cookie2"] || "";
        var values = Array.isArray(raw) ? raw : [raw];
        for (var i = 0; i < values.length; i++) {
            var line = String(values[i] || "");
            var match = line.match(/(^|,\s*)([^=;,\s]+)=([^;]+)/);
            if (match) out[match[2]] = match[3];
        }
        return out;
    }

    async function sleep(ms) {
        return new Promise(function (resolve) {
            setTimeout(resolve, ms);
        });
    }

    async function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = Object.assign({}, options.headers || {});
        var body = typeof options.body === "undefined" ? "" : String(options.body);

        if (method === "GET" && typeof http_get === "function") {
            var getResponse = await http_get(url, headers);
            var getHeaders = normalizeHeaders(getResponse && getResponse.headers);
            return {
                status: extractResponseStatus(getResponse),
                body: extractResponseBody(getResponse),
                headers: getHeaders,
                cookies: extractCookiesFromHeaders(getHeaders),
                finalUrl: (getResponse && (getResponse.finalUrl || getResponse.url)) || url
            };
        }

        if (method === "POST" && typeof http_post === "function") {
            var postResponse = await http_post(url, body, headers);
            var postHeaders = normalizeHeaders(postResponse && postResponse.headers);
            return {
                status: extractResponseStatus(postResponse),
                body: extractResponseBody(postResponse),
                headers: postHeaders,
                cookies: extractCookiesFromHeaders(postHeaders),
                finalUrl: (postResponse && (postResponse.finalUrl || postResponse.url)) || url
            };
        }

        if (typeof fetch === "function") {
            var fetchResponse = await fetch(url, {
                method: method,
                headers: headers,
                body: method === "POST" ? body : undefined,
                redirect: "follow"
            });
            var fetchHeaders = normalizeHeaders(fetchResponse.headers);
            return {
                status: fetchResponse.status,
                body: await fetchResponse.text(),
                headers: fetchHeaders,
                cookies: extractCookiesFromHeaders(fetchHeaders),
                finalUrl: fetchResponse.url || url
            };
        }

        throw new Error("No HTTP client available");
    }

    function encodeQuery(params) {
        var out = [];
        for (var key in params) {
            if (!Object.prototype.hasOwnProperty.call(params, key)) continue;
            if (typeof params[key] === "undefined" || params[key] === null) continue;
            out.push(encodeURIComponent(key) + "=" + encodeURIComponent(String(params[key])));
        }
        return out.join("&");
    }

    function payloadString(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(data) {
        return parseJsonSafe(String(data || ""), {}) || {};
    }

    function splitCsv(value) {
        return String(value || "")
            .split(",")
            .map(function (item) { return trim(item); })
            .filter(Boolean);
    }

    function parseScore(value) {
        var match = String(value || "").match(/(\d+(?:\.\d+)?)/);
        return match ? Number(match[1]) : undefined;
    }

    function parseDurationMinutes(value) {
        var text = String(value || "");
        if (/episodes?/i.test(text)) return undefined;
        var total = 0;
        var hourMatch = text.match(/(\d+)\s*h/i);
        var minuteMatch = text.match(/(\d+)\s*m/i);
        if (hourMatch) total += Number(hourMatch[1]) * 60;
        if (minuteMatch) total += Number(minuteMatch[1]);
        return total || undefined;
    }

    function parseEpisodeNumber(value) {
        var match = String(value || "").match(/(\d+)/);
        return match ? Number(match[1]) : undefined;
    }

    function inferTypeFromMeta(title, detail) {
        var text = String(title || "") + " " + String((detail && detail.type) || "") + " " + String((detail && detail.runtime) || "");
        if ((detail && detail.season && detail.season.length) || /series|season|episodes?/i.test(text)) return "series";
        return "movie";
    }

    function qualityFromLabel(label) {
        var text = String(label || "").toLowerCase();
        if (/2160|4k|uhd/.test(text)) return 2160;
        if (/1440/.test(text)) return 1440;
        if (/1080/.test(text)) return 1080;
        if (/720/.test(text)) return 720;
        if (/480/.test(text)) return 480;
        if (/360/.test(text)) return 360;
        return 0;
    }

    function buildCookieMap(cookieValue, extra) {
        var map = Object.assign({}, extra || {});
        if (cookieValue) map.t_hash_t = cookieValue;
        map.ott = CONFIG.ott;
        map.hd = "on";
        return map;
    }

    function buildCookieHeader(map) {
        var parts = [];
        for (var key in map) {
            if (!Object.prototype.hasOwnProperty.call(map, key)) continue;
            if (typeof map[key] === "undefined" || map[key] === null || map[key] === "") continue;
            parts.push(key + "=" + String(map[key]));
        }
        return parts.join("; ");
    }

    function buildHeaders(baseUrl, refererPath, cookieMap, extraHeaders) {
        var headers = {
            "User-Agent": DESKTOP_UA,
            "Accept": "*/*"
        };
        if (refererPath) headers["Referer"] = absoluteUrl(baseUrl, refererPath);
        if (cookieMap && Object.keys(cookieMap).length) headers["Cookie"] = buildCookieHeader(cookieMap);
        if (extraHeaders) {
            for (var key in extraHeaders) {
                if (Object.prototype.hasOwnProperty.call(extraHeaders, key) && typeof extraHeaders[key] !== "undefined") {
                    headers[key] = extraHeaders[key];
                }
            }
        }
        return headers;
    }

    function getSelectedBaseUrl() {
        return normalizeBaseUrl((runtimeManifest && runtimeManifest.baseUrl) || CONFIG.defaultBaseUrl) || CONFIG.defaultBaseUrl;
    }

    function getContentBases() {
        return unique([getSelectedBaseUrl()].concat(CONFIG.contentBases || []).concat([CONFIG.defaultBaseUrl]));
    }

    function getHomeBases() {
        return unique([getSelectedBaseUrl()].concat(CONFIG.homeBases || []).concat(getContentBases()));
    }

    function getStreamBases() {
        return unique([getSelectedBaseUrl()].concat(CONFIG.streamBases || []).concat(getContentBases()));
    }

    function getCookieBases() {
        return unique([getSelectedBaseUrl()].concat(CONFIG.cookieBases || []).concat(getStreamBases()));
    }

    function getTokenBases() {
        return unique((CONFIG.tokenBases || []).concat(getStreamBases()));
    }

    async function ensureCookie(baseUrl) {
        if (!CONFIG.needsCookie) return "";
        var base = normalizeBaseUrl(baseUrl);
        if (!base) throw new Error("Missing base URL for cookie verification");

        var cacheKey = CONFIG.ott + "|" + base;
        if (COOKIE_CACHE[cacheKey] && COOKIE_CACHE[cacheKey].expiresAt > Date.now()) {
            return COOKIE_CACHE[cacheKey].value;
        }

        var mobileHeaders = {
            "User-Agent": MOBILE_UA,
            "X-Requested-With": "app.netmirror.netmirrornew"
        };
        var mobileResponse = await request(base + "/mobile/home?app=1", {
            headers: mobileHeaders
        });
        var addhashMatch = String(mobileResponse.body || "").match(/data-addhash="([^"]+)"/);
        var addhash = addhashMatch ? addhashMatch[1] : "";
        if (!addhash) {
            throw new Error("Unable to extract mirror verification token");
        }

        await request("https://userver.net52.cc/?jjoii=" + encodeURIComponent(addhash) + "&a=y&t=" + unixTime(), {
            headers: { "User-Agent": DESKTOP_UA }
        });

        for (var attempt = 0; attempt < 7; attempt++) {
            await sleep(10000);
            var verifyResponse = await request(base + "/mobile/verify2.php", {
                method: "POST",
                headers: {
                    "User-Agent": MOBILE_UA,
                    "X-Requested-With": "XMLHttpRequest",
                    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                },
                body: encodeQuery({ verify: addhash })
            });
            if (String(verifyResponse.body || "").indexOf('"statusup":"All Done"') !== -1) {
                var cookieValue = verifyResponse.cookies.t_hash_t || "";
                if (!cookieValue) {
                    var cookieHeader = verifyResponse.headers["set-cookie"] || "";
                    var cookieMatch = String(cookieHeader).match(/t_hash_t=([^;]+)/);
                    cookieValue = cookieMatch ? cookieMatch[1] : "";
                }
                if (cookieValue) {
                    COOKIE_CACHE[cacheKey] = {
                        value: cookieValue,
                        expiresAt: Date.now() + 54 * 60 * 1000
                    };
                    return cookieValue;
                }
            }
        }

        throw new Error("Failed to verify mirror cookie for " + base);
    }

    async function getCookieForBases(bases) {
        var lastError = null;
        for (var i = 0; i < bases.length; i++) {
            try {
                return await ensureCookie(bases[i]);
            } catch (error) {
                lastError = error;
            }
        }
        if (CONFIG.needsCookie && lastError) throw lastError;
        return "";
    }

    async function fetchVideoToken(baseUrl, id, cookieValue) {
        var cookieMap = buildCookieMap(cookieValue, { user_token: USER_TOKEN });
        var headers = {
            "Accept": "*/*",
            "Accept-Language": "en-US,en;q=0.5",
            "Connection": "keep-alive",
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
            "Host": "net22.cc",
            "Origin": baseUrl + "/",
            "Priority": "u=0",
            "Referer": baseUrl + "/home",
            "Sec-Fetch-Dest": "empty",
            "Sec-Fetch-Mode": "cors",
            "Sec-Fetch-Site": "same-origin",
            "User-Agent": DESKTOP_UA,
            "X-Requested-With": "XMLHttpRequest",
            "Cookie": buildCookieHeader(cookieMap)
        };
        var response = await request(baseUrl + "/play.php", {
            method: "POST",
            headers: headers,
            body: encodeQuery({ id: id })
        });
        var data = parseJsonSafe(response.body, {});
        var h = data && data.h ? String(data.h) : "";
        var index = h.indexOf("in=");
        return index >= 0 ? h.slice(index + 3) : "";
    }

    async function fetchDetail(baseUrl, id) {
        var cookieValue = CONFIG.needsCookie ? await getCookieForBases(getCookieBases()) : "";
        var extraCookies = {};
        if (CONFIG.key === "netflix" && CONFIG.needsUserTokenOnHome) {
            extraCookies.user_token = USER_TOKEN;
        }
        var response = await request(baseUrl + CONFIG.detailPath + "?" + encodeQuery({ id: id, t: unixTime() }), {
            headers: buildHeaders(
                baseUrl,
                CONFIG.key === "netflix" ? "/tv/home" : CONFIG.refererPath,
                buildCookieMap(cookieValue, extraCookies),
                { "X-Requested-With": "XMLHttpRequest" }
            )
        });
        return parseJsonSafe(response.body, null);
    }

    async function fetchEpisodeBatch(baseUrl, seriesId, seasonId) {
        var cookieValue = CONFIG.needsCookie ? await getCookieForBases(getCookieBases()) : "";
        var cookieMap = buildCookieMap(cookieValue, {});
        var episodes = [];
        var seenIds = {};

        for (var page = 1; page <= 8; page++) {
            var response = await request(baseUrl + CONFIG.episodesPath + "?" + encodeQuery({
                s: seasonId,
                series: seriesId,
                t: unixTime(),
                page: page
            }), {
                headers: buildHeaders(baseUrl, CONFIG.refererPath, cookieMap, {
                    "X-Requested-With": "XMLHttpRequest"
                })
            });
            var data = parseJsonSafe(response.body, null);
            var batch = data && Array.isArray(data.episodes) ? data.episodes : [];
            if (!batch.length) break;
            var added = 0;
            for (var i = 0; i < batch.length; i++) {
                var episode = batch[i];
                var episodeId = trim(episode && episode.id);
                if (!episodeId || seenIds[episodeId]) continue;
                seenIds[episodeId] = true;
                episodes.push(episode);
                added++;
            }
            if (!added) break;
        }

        return episodes;
    }

    function buildPoster(urlTemplate, id) {
        return urlTemplate ? replaceId(urlTemplate, id) : undefined;
    }

    function buildSearchItem(id, title, extra) {
        var itemType = inferTypeFromMeta(title, extra);
        return new MultimediaItem({
            title: title || "",
            url: payloadString({ id: id, title: title || "" }),
            posterUrl: buildPoster(CONFIG.posterUrl, id),
            backgroundPosterUrl: buildPoster(CONFIG.backgroundPosterUrl, id),
            year: extra && extra.y ? parseEpisodeNumber(extra.y) : undefined,
            duration: extra && extra.r ? parseDurationMinutes(extra.r) : undefined,
            type: itemType
        });
    }

    function buildHomeItem(id, title) {
        return new MultimediaItem({
            title: title || "",
            url: payloadString({ id: id, title: title || "" }),
            posterUrl: buildPoster(CONFIG.posterUrl, id),
            backgroundPosterUrl: buildPoster(CONFIG.backgroundPosterUrl, id),
            type: inferTypeFromMeta(title, {})
        });
    }

    function buildEpisode(showTitle, episodeData) {
        var episodeId = trim(episodeData && episodeData.id);
        return new Episode({
            name: trim(episodeData && episodeData.t) || showTitle || "Episode",
            url: payloadString({ id: episodeId, title: showTitle || "" }),
            season: parseEpisodeNumber(episodeData && episodeData.s),
            episode: parseEpisodeNumber(episodeData && episodeData.ep),
            posterUrl: buildPoster(CONFIG.episodePosterUrl, episodeId),
            description: trim(episodeData && (episodeData.ep_desc || episodeData.desc)) || undefined,
            duration: parseDurationMinutes(episodeData && episodeData.time)
        });
    }

    async function parseNetflixHome(baseUrl, cb) {
        var cookieValue = await getCookieForBases(getCookieBases());
        var response = await request(baseUrl + CONFIG.homePath, {
            headers: buildHeaders(baseUrl, "/", buildCookieMap(cookieValue, { user_token: USER_TOKEN }), {
                "X-Requested-With": "XMLHttpRequest"
            })
        });
        var document = await parseHtml(response.body);
        var rows = document.querySelectorAll(".lolomoRow");
        var data = {};
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            var titleNode = row.querySelector("h2 span div") || row.querySelector("h2") || row.querySelector("span");
            var category = trim(titleNode && titleNode.textContent) || ("Section " + (i + 1));
            var images = row.querySelectorAll("img.lazy");
            var items = [];
            for (var j = 0; j < images.length; j++) {
                var dataSrc = trim(images[j].getAttribute("data-src") || images[j].getAttribute("src"));
                var match = dataSrc.match(/\/([^\/.?#]+)\.[a-z0-9]+(?:$|[?#])/i);
                var itemId = match ? match[1] : "";
                if (!itemId) continue;
                items.push(buildHomeItem(itemId, trim(images[j].getAttribute("alt") || images[j].getAttribute("title"))));
            }
            if (items.length) data[category] = items;
        }
        cb({ success: true, data: data });
    }

    async function parsePrimeHome(baseUrl, cb) {
        var response = await request(baseUrl + CONFIG.homePath, {
            headers: buildHeaders(baseUrl, "/", {}, { "X-Requested-With": "XMLHttpRequest" })
        });
        var homeData = parseJsonSafe(response.body, null);
        var posts = homeData && Array.isArray(homeData.post) ? homeData.post : [];
        var data = {};
        for (var i = 0; i < posts.length; i++) {
            var category = trim(posts[i] && posts[i].cate) || ("Section " + (i + 1));
            var ids = String(posts[i] && posts[i].ids || "").split(",").map(trim).filter(Boolean);
            var items = ids.map(function (id) { return buildHomeItem(id, ""); });
            if (items.length) data[category] = items;
        }
        cb({ success: true, data: data });
    }

    async function parseJioHome(baseUrl, cb) {
        var cookieValue = await getCookieForBases(getCookieBases());
        var response = await request(baseUrl + CONFIG.homePath, {
            headers: buildHeaders(baseUrl, CONFIG.refererPath, buildCookieMap(cookieValue, {}), {
                "X-Requested-With": "XMLHttpRequest"
            })
        });
        var document = await parseHtml(response.body);
        var trays = document.querySelectorAll(".tray-container, #top10");
        var data = {};
        for (var i = 0; i < trays.length; i++) {
            var tray = trays[i];
            var titleNode = tray.querySelector("h2, span");
            var category = trim(titleNode && titleNode.textContent) || ("Section " + (i + 1));
            var cards = tray.querySelectorAll("article, .top10-post");
            var items = [];
            for (var j = 0; j < cards.length; j++) {
                var card = cards[j];
                var anchor = card.querySelector("a");
                var itemId = trim((anchor && anchor.getAttribute("data-post")) || card.getAttribute("data-post"));
                if (!itemId) continue;
                var cardTitleNode = card.querySelector("h2, h3, h4, .title, img");
                var cardTitle = trim((cardTitleNode && (cardTitleNode.textContent || cardTitleNode.getAttribute("alt"))) || "");
                items.push(buildHomeItem(itemId, cardTitle));
            }
            if (items.length) data[category] = items;
        }
        cb({ success: true, data: data });
    }

    async function getHome(cb) {
        var bases = CONFIG.homeMode === "netflix_html" ? getHomeBases() : getContentBases();
        var lastError = null;
        for (var i = 0; i < bases.length; i++) {
            try {
                if (CONFIG.homeMode === "netflix_html") return await parseNetflixHome(bases[i], cb);
                if (CONFIG.homeMode === "prime_json") return await parsePrimeHome(bases[i], cb);
                if (CONFIG.homeMode === "jio_html") return await parseJioHome(bases[i], cb);
            } catch (error) {
                lastError = error;
            }
        }
        cb({
            success: false,
            errorCode: "HOME_ERROR",
            message: String(lastError && lastError.message || lastError || "Unable to load home")
        });
    }

    async function search(query, cb) {
        var q = trim(query);
        if (!q) return cb({ success: true, data: [] });

        var bases = getContentBases();
        var lastError = null;
        for (var i = 0; i < bases.length; i++) {
            try {
                var base = bases[i];
                var cookieValue = CONFIG.needsCookie && CONFIG.key !== "primevideo" ? await getCookieForBases(getCookieBases()) : "";
                var response = await request(base + CONFIG.searchPath + "?" + encodeQuery({ s: q, t: unixTime() }), {
                    headers: buildHeaders(base, CONFIG.refererPath, buildCookieMap(cookieValue, {}), {
                        "X-Requested-With": "XMLHttpRequest"
                    })
                });
                var data = parseJsonSafe(response.body, null);
                var rows = data && Array.isArray(data.searchResult) ? data.searchResult : [];
                var items = [];
                for (var j = 0; j < rows.length; j++) {
                    var row = rows[j] || {};
                    if (!row.id) continue;
                    items.push(buildSearchItem(String(row.id), trim(row.t), row));
                }
                return cb({ success: true, data: items });
            } catch (error) {
                lastError = error;
            }
        }

        cb({
            success: false,
            errorCode: "SEARCH_ERROR",
            message: String(lastError && lastError.message || lastError || "Search failed")
        });
    }

    async function load(url, cb) {
        var payload = parsePayload(url);
        var id = trim(payload.id);
        if (!id) {
            return cb({ success: false, errorCode: "LOAD_ERROR", message: "Missing content id" });
        }

        var bases = getContentBases();
        var lastError = null;
        for (var i = 0; i < bases.length; i++) {
            try {
                var base = bases[i];
                var detail = await fetchDetail(base, id);
                if (!detail || !detail.title) continue;

                var mediaType = inferTypeFromMeta(detail.title, detail);
                var tags = splitCsv(detail.genre);
                var cast = splitCsv(detail.cast).map(function (name) {
                    return typeof Actor === "function" ? new Actor({ name: name }) : { name: name };
                });
                var description = trim(detail.desc || detail.m_desc || detail.thismovieis || detail.error || "");
                var commonItem = {
                    title: trim(detail.title) || payload.title || CONFIG.displayName,
                    url: payloadString({ id: id, title: trim(detail.title) || payload.title || "" }),
                    posterUrl: buildPoster(CONFIG.posterUrl, id),
                    backgroundPosterUrl: buildPoster(CONFIG.backgroundPosterUrl, id),
                    description: description || undefined,
                    year: parseEpisodeNumber(detail.year),
                    score: parseScore(detail.match),
                    duration: parseDurationMinutes(detail.runtime),
                    contentRating: trim(detail.ua) || undefined,
                    genres: tags.length ? tags : undefined,
                    cast: cast.length ? cast : undefined,
                    type: mediaType
                };

                if (mediaType === "movie") {
                    commonItem.episodes = [
                        new Episode({
                            name: commonItem.title,
                            url: payloadString({ id: id, title: commonItem.title }),
                            season: 1,
                            episode: 1,
                            posterUrl: buildPoster(CONFIG.posterUrl, id),
                            description: commonItem.description
                        })
                    ];
                    return cb({ success: true, data: new MultimediaItem(commonItem) });
                }

                var seenEpisodeIds = {};
                var episodeData = [];
                var currentEpisodes = Array.isArray(detail.episodes) ? detail.episodes : [];
                for (var j = 0; j < currentEpisodes.length; j++) {
                    var episodeId = trim(currentEpisodes[j] && currentEpisodes[j].id);
                    if (!episodeId || seenEpisodeIds[episodeId]) continue;
                    seenEpisodeIds[episodeId] = true;
                    episodeData.push(currentEpisodes[j]);
                }

                var currentSeasonId = trim(detail.nextPageSeason || id);
                var seasons = Array.isArray(detail.season) ? detail.season : [];
                for (var k = 0; k < seasons.length; k++) {
                    var seasonId = trim(seasons[k] && seasons[k].id);
                    if (!seasonId || seasonId === currentSeasonId) continue;
                    try {
                        var extraEpisodes = await fetchEpisodeBatch(base, id, seasonId);
                        for (var e = 0; e < extraEpisodes.length; e++) {
                            var extraId = trim(extraEpisodes[e] && extraEpisodes[e].id);
                            if (!extraId || seenEpisodeIds[extraId]) continue;
                            seenEpisodeIds[extraId] = true;
                            episodeData.push(extraEpisodes[e]);
                        }
                    } catch (_) {
                        // Skip broken season mirrors without failing the whole detail page.
                    }
                }

                commonItem.episodes = episodeData.map(function (episode) {
                    return buildEpisode(commonItem.title, episode);
                });
                return cb({ success: true, data: new MultimediaItem(commonItem) });
            } catch (error) {
                lastError = error;
            }
        }

        cb({
            success: false,
            errorCode: "LOAD_ERROR",
            message: String(lastError && lastError.message || lastError || "Load failed")
        });
    }

    function normalizeSubtitle(track) {
        var file = absoluteUrl(getSelectedBaseUrl(), String(track && track.file || "").replace(/\\/g, ""));
        return {
            url: file,
            label: trim(track && track.label) || "Subtitle",
            lang: trim(track && track.label) || "Subtitle"
        };
    }

    async function loadStreams(data, cb) {
        var payload = parsePayload(data);
        var id = trim(payload.id);
        var title = trim(payload.title);
        if (!id) return cb({ success: true, data: [] });

        var playlistBases = getStreamBases();
        var tokenBases = CONFIG.needsVideoToken ? getTokenBases() : [];
        var cookieValue = CONFIG.needsCookie ? await getCookieForBases(getCookieBases()) : "";
        var cookieMap = buildCookieMap(cookieValue, {});
        var lastError = null;

        try {
            for (var i = 0; i < playlistBases.length; i++) {
                var playlistBase = playlistBases[i];
                var token = "";
                if (CONFIG.needsVideoToken) {
                    var tokenResolved = false;
                    for (var t = 0; t < tokenBases.length; t++) {
                        try {
                            token = await fetchVideoToken(tokenBases[t], id, cookieValue);
                            if (token) {
                                tokenResolved = true;
                                break;
                            }
                        } catch (error) {
                            lastError = error;
                        }
                    }
                    if (!tokenResolved) continue;
                }

                var playlistQuery = {
                    id: id,
                    t: title || id,
                    tm: unixTime()
                };
                if (CONFIG.needsVideoToken) playlistQuery.h = token;

                var response = await request(playlistBase + CONFIG.playlistPath + "?" + encodeQuery(playlistQuery), {
                    headers: buildHeaders(
                        playlistBase,
                        CONFIG.refererPath,
                        cookieMap,
                        { "X-Requested-With": "XMLHttpRequest" }
                    )
                });
                var playlist = parseJsonSafe(response.body, null);
                if (!Array.isArray(playlist) || !playlist.length) continue;

                var streams = [];
                for (var p = 0; p < playlist.length; p++) {
                    var entry = playlist[p] || {};
                    var subtitles = Array.isArray(entry.tracks)
                        ? entry.tracks.filter(function (track) { return trim(track && track.kind) === "captions"; }).map(normalizeSubtitle)
                        : [];
                    var sources = Array.isArray(entry.sources) ? entry.sources : [];
                    for (var s = 0; s < sources.length; s++) {
                        var source = sources[s] || {};
                        var streamUrl = absoluteUrl(playlistBase, source.file);
                        if (!streamUrl) continue;
                        streams.push(new StreamResult({
                            url: streamUrl,
                            source: CONFIG.displayName + (trim(source.label) ? " " + trim(source.label) : ""),
                            quality: qualityFromLabel(source.label || entry.title),
                            headers: buildHeaders(playlistBase, "/", cookieMap, {
                                "Origin": playlistBase,
                                "User-Agent": DESKTOP_UA
                            }),
                            subtitles: subtitles.length ? subtitles : undefined
                        }));
                    }
                }

                if (streams.length) {
                    return cb({ success: true, data: streams });
                }
            }
        } catch (error) {
            lastError = error;
        }

        cb({
            success: lastError ? false : true,
            errorCode: lastError ? "STREAM_ERROR" : undefined,
            message: lastError ? String(lastError && lastError.message || lastError) : undefined,
            data: []
        });
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
