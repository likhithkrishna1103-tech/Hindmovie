(function() {
    "use strict";

    function base64Decode(str) {
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var output = "";
        var bytes = [];
        for (var i = 0; i < str.length; i += 4) {
            var a = chars.indexOf(str[i]);
            var b = chars.indexOf(str[i + 1] || "=");
            var c = chars.indexOf(str[i + 2] || "=");
            var d = chars.indexOf(str[i + 3] || "=");
            bytes.push((a << 2) | (b >> 4));
            if (c !== -1 && str[i + 2] !== "=") bytes.push(((b & 15) << 4) | (c >> 2));
            if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
        }
        for (var j = 0; j < bytes.length; j++) output += String.fromCharCode(bytes[j]);
        return output;
    }

    const GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
    const GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

    const Analytics = {
        clientId: null,
        init() { this.clientId = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
            var r = Math.random() * 16 | 0;
            return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
        }); },
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        logEvent(eventName, parameters) {
            if (!this.measurementId || !this.apiSecret) return;
            try {
                http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: [{ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) }] })
                );
            } catch (e) {}
        }
    };
    Analytics.init();

    var BASE_URL = (manifest && manifest.baseUrl) || "https://senshi.live";
    var IMG_URL = "https://senshi.live";

    var API_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36",
        "Accept": "application/json, text/plain, */*",
        "X-Requested-With": "XMLHttpRequest",
        "Referer": BASE_URL + "/",
        "Origin": BASE_URL
    };

    var POST_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36",
        "Accept": "application/json, text/plain, */*",
        "Content-Type": "application/json",
        "X-Requested-With": "XMLHttpRequest",
        "Referer": BASE_URL + "/",
        "Origin": BASE_URL
    };

    function absUrl(path) {
        if (!path) return "";
        if (/^https?:\/\//i.test(path)) return path;
        if (path.indexOf("//") === 0) return "https:" + path;
        return IMG_URL + path;
    }

    function parseJsonSafe(text, fallback) {
        try {
            return JSON.parse(String(text || ""));
        } catch (e) {
            return fallback;
        }
    }

    function cleanHtml(value) {
        return String(value || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ")
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<[^>]+>/g, " ")
            .replace(/\s{2,}/g, " ")
            .trim();
    }

    function guessType(typeText) {
        typeText = String(typeText || "").toLowerCase();
        if (typeText.indexOf("movie") !== -1) return "movie";
        return "anime";
    }

    function getStatus(statusText) {
        statusText = String(statusText || "").toLowerCase();
        if (statusText.indexOf("currently airing") !== -1) return "ongoing";
        if (statusText.indexOf("finished") !== -1) return "completed";
        if (statusText.indexOf("not yet aired") !== -1) return "upcoming";
        return undefined;
    }

    function parseAnimeToItem(anime, posterOverride) {
        var title = cleanHtml(anime.title_english || anime.title || "");
        var poster = absUrl(posterOverride || anime.anime_picture);
        var trailerUrl = anime.trailer || undefined;
        var genres = anime.genres ? anime.genres.split(",").map(function(g) { return g.trim(); }).filter(Boolean) : [];

        return new MultimediaItem({
            title: title,
            url: BASE_URL + "/watch/" + (anime.public_id || anime.id) + "/1",
            posterUrl: poster,
            type: guessType(anime.type),
            description: cleanHtml(anime.ani_description || ""),
            year: anime.ani_year ? Number(anime.ani_year) : undefined,
            score: anime.score ? Number(anime.score) : undefined,
            status: getStatus(anime.ani_status),
            tags: genres.length ? genres : undefined,
            trailers: trailerUrl ? [new Trailer({ name: "Trailer", url: trailerUrl })] : undefined,
            headers: { "Referer": BASE_URL + "/" }
        });
    }

    async function httpGetJson(url) {
        try {
            var res = await http_get(url, API_HEADERS);
            var body = res && res.body ? String(res.body) : "";
            return parseJsonSafe(body, null);
        } catch (e) {
            return null;
        }
    }

    async function httpPostJson(url, bodyData) {
        try {
            var bodyStr = JSON.stringify(bodyData || {});
            var res = await http_post(url, POST_HEADERS, bodyStr);
            var body = res && res.body ? String(res.body) : "";
            return parseJsonSafe(body, null);
        } catch (e) {
            return null;
        }
    }

    async function getHome(cb) {
        try {
            var result = {};

            // 1. Trending from /sliders (hero section -> Trending row)
            var sliders = await httpGetJson(BASE_URL + "/sliders");
            var trendingItems = [];
            if (sliders && Array.isArray(sliders)) {
                for (var i = 0; i < sliders.length; i++) {
                    var slide = sliders[i];
                    if (slide.anime) {
                        var item = parseAnimeToItem(slide.anime);
                        if (slide.image_url) {
                            item.bannerUrl = absUrl(slide.image_url);
                        }
                        trendingItems.push(item);
                    }
                }
            }
            if (trendingItems.length) {
                result["Trending"] = trendingItems;
            }

            // 2. Recently Added from /anime/recently-added
            var recent = await httpGetJson(BASE_URL + "/anime/recently-added");
            var recentItems = [];
            if (recent && Array.isArray(recent)) {
                for (var r = 0; r < Math.min(recent.length, 36); r++) {
                    recentItems.push(parseAnimeToItem(recent[r]));
                }
            }
            if (recentItems.length) {
                result["Recently Added"] = recentItems;
            }

            // 3. Latest Episodes from /episode-embeds/latest
            var latestEmbeds = await httpGetJson(BASE_URL + "/episode-embeds/latest");
            var latestItems = [];
            if (latestEmbeds && Array.isArray(latestEmbeds)) {
                for (var e = 0; e < Math.min(latestEmbeds.length, 36); e++) {
                    var embed = latestEmbeds[e];
                    if (!embed.anime) continue;
                    var animeData = embed.anime;
                    var epNum = embed.ep_id || embed.episode_info_id || 1;
                    var epTitle = embed.episode && embed.episode.ep_title ? embed.episode.ep_title : ("Episode " + epNum);
                    var title = cleanHtml(animeData.title_english || animeData.title || "");
                    var poster = absUrl(animeData.anime_picture);
                    var streamStatus = embed.status || "HardSub";

                    latestItems.push(new MultimediaItem({
                        title: title + " - " + epTitle,
                        url: BASE_URL + "/watch/" + (animeData.public_id || animeData.id) + "/" + epNum,
                        posterUrl: poster,
                        type: "anime",
                        description: "Episode " + epNum + " [" + streamStatus + "]",
                        headers: { "Referer": BASE_URL + "/" }
                    }));
                }
            }
            if (latestItems.length) {
                result["Latest Episodes"] = latestItems;
            }

            // Fallback: if no sliders, use first items as Trending
            if (!trendingItems.length && recentItems.length) {
                result["Trending"] = recentItems.slice(0, 20);
            }

            Analytics.logEvent('senshi_home', {});
            cb({ success: true, data: result });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var payload = { page: 1, limit: 50 };
            if (query && query.trim()) {
                payload.keyword = query.trim();
            }
            var json = await httpPostJson(BASE_URL + "/anime/filter", payload);
            var items = [];
            if (json && json.data && Array.isArray(json.data)) {
                for (var i = 0; i < json.data.length; i++) {
                    items.push(parseAnimeToItem(json.data[i]));
                }
            }
            Analytics.logEvent('senshi_search', {});
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var match = url.match(/\/watch\/([^\/]+)(?:\/(\d+))?/);
            if (!match) throw new Error("Invalid senshi URL: " + url);
            var publicId = match[1];
            var initialEp = parseInt(match[2], 10) || 1;

            // Fetch anime by public_id (the site's native resolution endpoint)
            var animeData = await httpGetJson(BASE_URL + "/anime/" + encodeURIComponent(publicId));
            if (!animeData || !animeData.id) throw new Error("Anime not found: " + publicId);

            var malId = animeData.id;
            var title = cleanHtml(animeData.title_english || animeData.title || "");
            var poster = absUrl(animeData.anime_picture);
            var genres = animeData.genres ? animeData.genres.split(",").map(function(g) { return g.trim(); }).filter(Boolean) : [];
            var trailerUrl = animeData.trailer || undefined;
            var score = animeData.score ? Number(animeData.score) : undefined;
            var year = animeData.ani_year ? Number(animeData.ani_year) : undefined;

            // Fetch episodes by mal_id
            var episodesData = await httpGetJson(BASE_URL + "/episodes/" + malId);
            var episodes = [];
            if (episodesData && Array.isArray(episodesData)) {
                for (var e = 0; e < episodesData.length; e++) {
                    var ep = episodesData[e];
                    var epNum = ep.ep_id ? Number(ep.ep_id) : (e + 1);
                    var epTitle = ep.ep_title ? cleanHtml(ep.ep_title) : ("Episode " + epNum);
                    episodes.push(new Episode({
                        name: epTitle,
                        url: JSON.stringify({ mal_id: malId, episode: epNum }),
                        season: 1,
                        episode: epNum,
                        posterUrl: poster,
                        description: ep.filler ? "Filler" : undefined,
                        headers: { "Referer": BASE_URL + "/" },
                        dubStatus: "sub"
                    }));
                }
            }

            if (!episodes.length) {
                episodes.push(new Episode({
                    name: "Episode " + initialEp,
                    url: JSON.stringify({ mal_id: malId, episode: initialEp }),
                    season: 1,
                    episode: initialEp,
                    posterUrl: poster,
                    headers: { "Referer": BASE_URL + "/" },
                    dubStatus: "sub"
                }));
            }

            // Fetch recommendations
            var recs = [];
            var recData = await httpGetJson(BASE_URL + "/anime/" + encodeURIComponent(publicId) + "/recommended");
            if (recData && Array.isArray(recData)) {
                for (var r = 0; r < recData.length; r++) {
                    var rec = recData[r];
                    if (!rec) continue;
                    recs.push(new MultimediaItem({
                        title: cleanHtml(rec.title_english || rec.title || ""),
                        url: BASE_URL + "/watch/" + (rec.public_id || rec.id) + "/1",
                        posterUrl: absUrl(rec.anime_picture),
                        type: "anime",
                        headers: { "Referer": BASE_URL + "/" }
                    }));
                }
            }

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: poster,
                type: guessType(animeData.type),
                description: cleanHtml(animeData.ani_description || ""),
                year: year,
                score: score,
                status: getStatus(animeData.ani_status),
                tags: genres.length ? genres : undefined,
                trailers: trailerUrl ? [new Trailer({ name: "Trailer", url: trailerUrl })] : undefined,
                cast: animeData.studios ? [new Actor({ name: cleanHtml(animeData.studios), role: "Studio" })] : undefined,
                recommendations: recs,
                headers: { "Referer": BASE_URL + "/" },
                syncData: { mal_id: String(malId) },
                episodes: episodes
            });

            Analytics.logEvent('senshi_load', {});
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e.message || e) });
        }
    }

    async function loadStreams(data, cb) {
        try {
            var malId = null;
            var episode = null;

            if (typeof data === "object" && data !== null) {
                malId = data.mal_id;
                episode = data.episode;
            } else if (typeof data === "string") {
                var parsed = parseJsonSafe(data, null);
                if (parsed && parsed.mal_id) {
                    malId = parsed.mal_id;
                    episode = parsed.episode;
                } else {
                    throw new Error("Episode data malformed, need object with mal_id and episode");
                }
            }

            if (!malId || !episode) throw new Error("Missing mal_id or episode number");

            var embeds = await httpGetJson(BASE_URL + "/episode-embeds/" + malId + "/" + episode);
            var streams = [];

            if (embeds && Array.isArray(embeds)) {
                for (var i = 0; i < embeds.length; i++) {
                    var e = embeds[i];
                    var status = e.status || "HardSub";
                    var streamHeaders = {
                        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36",
                        "Referer": BASE_URL + "/"
                    };

                    if (e.url) {
                        streams.push(new StreamResult({
                            url: e.url,
                            source: "Senshi " + status,
                            headers: streamHeaders
                        }));
                    }

                    if (e.server2) {
                        streams.push(new StreamResult({
                            url: e.server2,
                            source: "Senshi " + status + " (Alt)",
                            headers: streamHeaders
                        }));
                    }

                    if (e.serverFM) {
                        streams.push(new StreamResult({
                            url: e.serverFM,
                            source: "Senshi " + status + " (FM)",
                            headers: streamHeaders
                        }));
                    }

                    if (e.download) {
                        streams.push(new StreamResult({
                            url: e.download,
                            source: "Senshi " + status + " (DL)",
                            headers: streamHeaders
                        }));
                    }
                }
            }

            if (!streams.length) throw new Error("No streams found for episode " + episode);

            Analytics.logEvent('senshi_loadstreams', {});
            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
