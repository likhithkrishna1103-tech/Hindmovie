(function() {
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

    const MAIN_URL = "https://animetsu.net";
    const API_BASE = MAIN_URL + "/v2/api/anime";
    const PROXY_BASE = "https://swiftstream.top/proxy";
    const NEXT_AIRING_CACHE = {};
    const ANIZIP_CACHE = {};

    const HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
        "Accept": "application/json, text/plain, */*",
        "Accept-Language": "en-US,en;q=0.5",
        "Origin": MAIN_URL,
        "Referer": MAIN_URL + "/"
    };

    const IMAGE_HEADERS = {
        "User-Agent": HEADERS["User-Agent"],
        "Accept": "image/avif,image/webp,image/png,image/jpeg,image/*,*/*;q=0.8",
        "Referer": MAIN_URL + "/"
    };

    // SessionTracker - Ported from Kotlin Tracker.kt with UUID-based session ID
    const SessionTracker = {
        clientId: null,
        init() {
            this.clientId = this.generateUuid();
        },
        generateUuid() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random() * 16 | 0;
                return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
        }
    };

    SessionTracker.init();

    // Analytics Module - Ported from Kotlin Tracker.kt
    const Analytics = {
        clientId: null,
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        queue: [],

        init() {
            this.clientId = SessionTracker.clientId;
        },

        logEvent(eventName, parameters = {}) {
            const enabled = this.measurementId && this.apiSecret;
            console.log('[Animetsu-Analytics] Event: ' + eventName + ' | clientId: ' + this.clientId + ' | enabled: ' + !!enabled + ' | params: ' + JSON.stringify(parameters));
            if (!enabled) {
                return;
            }
            this.queue.push({
                name: eventName,
                params: Object.assign({
                    engagement_time_msec: "1000",
                    session_id: this.clientId
                }, parameters)
            });
            this.flushQueue();
        },

        async flushQueue() {
            if (this.queue.length === 0) return;
            const events = this.queue.splice(0);
            console.log('[Animetsu-Analytics] Flushing ' + events.length + ' events to GA');
            try {
                await http_post(
                    `https://www.google-analytics.com/mp/collect?measurement_id=${this.measurementId}&api_secret=${this.apiSecret}`,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
                console.log('[Animetsu-Analytics] Events flushed successfully');
            } catch (error) {
                console.log('[Animetsu-Analytics] Send skipped (no GA credentials)');
            }
        }
    };

    Analytics.init();

    function httpJson(url, headers) {
        return http_get(url, headers || HEADERS).then(function (res) {
            if (!res || !res.body) throw new Error("Empty response");
            return JSON.parse(res.body);
        });
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
            "Accept": "application/json"
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
            }, { "User-Agent": HEADERS["User-Agent"] });
            var media = json && json.data && json.data.Media;
            var next = media && media.nextAiringEpisode;
            return cacheSet(NEXT_AIRING_CACHE, cacheKey, buildNextAiring(next && next.episode, 1, next && next.airingAt) || null);
        } catch (_) {
            return cacheSet(NEXT_AIRING_CACHE, cacheKey, null);
        }
    }

    async function fetchAniZipMeta(ids) {
        if (!ids || (!ids.mal_id && !ids.anilist_id)) return null;
        var idType = ids.mal_id ? "mal_id" : "anilist_id";
        var idValue = ids[idType];
        var cacheKey = idType + ":" + String(idValue);
        if (Object.prototype.hasOwnProperty.call(ANIZIP_CACHE, cacheKey)) {
            return cacheGet(ANIZIP_CACHE, cacheKey, 1800000);
        }
        try {
            var meta = await httpJson(
                "https://api.ani.zip/mappings?" + idType + "=" + encodeURIComponent(String(idValue)),
                { "Accept": "application/json", "User-Agent": HEADERS["User-Agent"] }
            );
            return cacheSet(ANIZIP_CACHE, cacheKey, meta || null);
        } catch (_) {
            return cacheSet(ANIZIP_CACHE, cacheKey, null);
        }
    }

    function extractFanart(aniZipMeta) {
        if (aniZipMeta && aniZipMeta.images) {
            for (var i = 0; i < aniZipMeta.images.length; i++) {
                if (aniZipMeta.images[i].coverType === "Fanart") {
                    return aniZipMeta.images[i].url || "";
                }
            }
        }
        return "";
    }

    function getAniZipEpisodeMeta(aniZipMeta, episodeNumber) {
        if (!aniZipMeta || !aniZipMeta.episodes || episodeNumber == null) return null;
        return aniZipMeta.episodes[String(episodeNumber)] || null;
    }

    function cleanText(str) {
        if (!str) return "";
        return String(str)
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<\/p>/gi, "\n")
            .replace(/<[^>]+>/g, "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ")
            .replace(/\n{3,}/g, "\n\n")
            .trim();
    }

    function stringOrEmpty(value) {
        return value == null ? "" : String(value);
    }

    function optionalString(value) {
        if (value == null || value === "") return undefined;
        return String(value);
    }

    function integerOrUndefined(value) {
        if (value == null || value === "") return undefined;
        var num = Number(value);
        if (!isFinite(num)) return undefined;
        return Math.round(num);
    }

    function absoluteUrl(url) {
        if (!url) return "";
        if (url.indexOf("http://") === 0 || url.indexOf("https://") === 0) return url;
        return MAIN_URL + (url.charAt(0) === "/" ? "" : "/") + url;
    }

    function proxiedUrl(path) {
        if (!path) return "";
        if (path.indexOf("http://") === 0 || path.indexOf("https://") === 0) return path;
        return PROXY_BASE + (path.charAt(0) === "/" ? "" : "/") + path;
    }

    function animeTypeFromFormat(format) {
        var f = (format || "").toUpperCase();
        if (f === "MOVIE") return "movie";
        return "anime";
    }

    function getStreamQuality(text) {
        text = String(text || "");
        var match = text.match(/(?:^|[^\d])((?:2160|1440|1080|720|540|480|360|240))p?(?:[^\d]|$)/i);
        return match ? Number(match[1]) : 0;
    }

    function normalizeSubtitle(sub) {
        if (!sub) return null;
        var url = sub.url || sub.file || sub.src || "";
        var lang = sub.label || sub.lang || sub.language || "English";
        if (!url) return null;
        return { url: url, lang: lang, label: lang };
    }

    function resolveUrl(base, value) {
        value = String(value || "").trim();
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base || MAIN_URL).toString();
        } catch (_) {
            base = base || MAIN_URL;
            return base.replace(/\/+$/, "") + "/" + value.replace(/^\/+/, "");
        }
    }

    function itemTitle(data) {
        if (!data || !data.title) return "";
        return stringOrEmpty(data.title.english || data.title.romaji || data.title.native || "");
    }

    function itemSubtitle(data) {
        if (!data || !data.title) return "";
        return stringOrEmpty(data.title.native || data.title.romaji || "");
    }

    function mapStatus(status) {
        var s = (status || "").toUpperCase();
        if (s === "RELEASING") return "ongoing";
        if (s === "NOT_YET_RELEASED") return "upcoming";
        if (s === "FINISHED" || s === "CANCELLED") return "completed";
        return "";
    }

    function numericYear(data) {
        var y = data && data.year;
        return integerOrUndefined(y);
    }

    function coverUrl(data) {
        if (!data || !data.cover_image) return "";
        return stringOrEmpty(data.cover_image.large || data.cover_image.medium || data.cover_image.small || "");
    }

    function episodePosterUrl(ep, info, aniZipMeta) {
        var episodeNumber = integerOrUndefined(ep && ep.ep_num);
        var meta = getAniZipEpisodeMeta(aniZipMeta, episodeNumber);
        return stringOrEmpty(meta && meta.image) || proxiedUrl(ep && ep.img) || coverUrl(info);
    }

    function normalizeTag(tag) {
        if (tag == null) return "";
        if (typeof tag === "string" || typeof tag === "number" || typeof tag === "boolean") {
            return String(tag);
        }

        if (typeof tag === "object") {
            return stringOrEmpty(tag.name || tag.tag || tag.label || tag.value || tag.id || "");
        }

        return "";
    }

    function normalizeTags(info) {
        return []
            .concat((info && info.genres) || [])
            .concat((info && info.tags) || [])
            .map(normalizeTag)
            .filter(function (tag) { return !!tag; })
            .slice(0, 20);
    }

    function formatSourceLabel(serverName, quality, sourceType, isSoftSub) {
        var parts = [];
        var q = String(quality || "").trim();
        var normalized = q.toLowerCase();

        parts.push(serverName || "default");

        if (q && normalized !== "master" && normalized !== "auto") {
            parts.push(q);
        }

        if (sourceType === "dub") {
            parts.push("[Audio: DUB]");
        } else if (sourceType === "sub" && isSoftSub) {
            parts.push("[Soft Sub]");
        } else if (sourceType === "sub") {
            parts.push("[Hard Sub]");
        } else {
            parts.push("[" + String(sourceType || "sub").toUpperCase() + "]");
        }
        return parts.join(" ");
    }

    function toMultimediaItem(data, opts) {
        opts = opts || {};
        if (data && !toMultimediaItem._logged) { toMultimediaItem._logged = true; try { var keys = []; for (var k in data) { keys.push(k + ":" + typeof data[k]); } console.log("[Animetsu-DEBUG] toMultimediaItem data keys: " + keys.join(", ")); if (data.clear_logo) console.log("[Animetsu-DEBUG] clear_logo: " + data.clear_logo); if (data.title) { var tkeys = []; for (var tk in data.title) { tkeys.push(tk); } console.log("[Animetsu-DEBUG] title keys: " + tkeys.join(", ")); } } catch(_) {} }

        var title = itemTitle(data);
        if (!title || !data || !data.id) return null;

        var url = opts.url || (MAIN_URL + "/anime/" + data.id);
        var item = new MultimediaItem({
            title: title,
            url: url,
            posterUrl: coverUrl(data),
            bannerUrl: opts.fanartUrl || absoluteUrl(data.banner || ""),
            logoUrl: absoluteUrl(data.clear_logo || ""),
            type: animeTypeFromFormat(data.format || data.type),
            description: opts.description !== undefined ? opts.description : cleanText(data.description || ""),
            year: numericYear(data),
            headers: HEADERS
        });

        var jp = itemSubtitle(data);
        if (jp && jp !== title) item.japaneseTitle = jp;
        return item;
    }

    function uniqueByUrl(items) {
        var seen = {};
        var out = [];
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            if (!item || !item.url || seen[item.url]) continue;
            seen[item.url] = true;
            out.push(item);
        }
        return out;
    }

    function mapHomeItems(items, opts) {
        opts = opts || {};
        return uniqueByUrl(((items || []).map(function (entry) {
            return toMultimediaItem(entry, {
                url: opts.watchEpisode && entry && entry.next_airing_ep && entry.next_airing_ep.ep_num
                    ? MAIN_URL + "/watch/" + entry.id + "?ep=" + entry.next_airing_ep.ep_num
                    : MAIN_URL + "/anime/" + (entry && entry.id),
                description: ""
            });
        })));
    }

    function parseEpisodeInput(url) {
        var match = String(url || "").match(/\/watch\/([^/?#]+)(?:\/([^/?#]+))?(?:\?([^#]+))?/i);
        if (!match) throw new Error("Invalid episode URL: " + url);

        var animeId = match[1];
        var ep = match[2] || "";
        var query = match[3] || "";
        var server = "default";
        var sourceType = "sub";

        if (query) {
            query.split("&").forEach(function (part) {
                var pair = part.split("=");
                var key = decodeURIComponent(pair[0] || "");
                var value = decodeURIComponent(pair[1] || "");
                if (key === "ep" && !ep) ep = value;
                if (key === "server" && value) server = value;
                if (key === "source_type" && value) sourceType = value;
            });
        }

        if (!ep) throw new Error("Episode number not found in URL: " + url);

        return {
            animeId: animeId,
            epNum: ep,
            server: server,
            sourceType: sourceType
        };
    }

    async function getHome(cb) {
        try {
            var startTime = Date.now();
            var home = await httpJson(API_BASE + "/home", HEADERS);
            var trendingEntries = ((home && home.trending) || []).slice(0, 20);
            var trendingFanartPromises = trendingEntries.map(function (entry) {
                if (entry && entry.anilist_id) {
                    return fetchAniZipMeta({ anilist_id: entry.anilist_id }).then(extractFanart);
                }
                return Promise.resolve("");
            });
            var trendingFanartUrls = await Promise.all(trendingFanartPromises);
            var trendingItems = uniqueByUrl(trendingEntries.map(function (entry, i) {
                return toMultimediaItem(entry, {
                    url: MAIN_URL + "/anime/" + (entry && entry.id),
                    description: "",
                    fanartUrl: trendingFanartUrls[i] || ""
                });
            })).slice(0, 20);

            var seasonalItems = mapHomeItems((home && home.seasonal) || []).slice(0, 20);
            var popularItems = mapHomeItems((home && home.popular) || []).slice(0, 20);
            var topItems = mapHomeItems((home && home.top) || []).slice(0, 20);
            var upcomingItems = mapHomeItems((home && home.upcoming) || []).slice(0, 20);

            // Analytics tracking
            Analytics.logEvent('Animetsu_home', {
                itemsTotal: trendingItems.length + seasonalItems.length + popularItems.length + topItems.length + upcomingItems.length
            });

            cb({
                success: true,
                data: {
                    "Trending Now": trendingItems,
                    "Popular This Season": seasonalItems,
                    "Most Popular": popularItems,
                    "Top Rated": topItems,
                    "Top Upcoming": upcomingItems
                }
            });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var startTime = Date.now();
            var data = await httpJson(API_BASE + "/search/?query=" + encodeURIComponent(query), HEADERS);
            var results = uniqueByUrl(((data && data.results) || []).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            // Analytics tracking
            Analytics.logEvent('Animetsu_search', {
                resultCount: results.length
            });

            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var startTime = Date.now();
            var animeMatch = String(url || "").match(/\/(?:anime|watch)\/([^/?#]+)/i);
            if (!animeMatch) throw new Error("Could not extract anime id from URL: " + url);

            var animeId = animeMatch[1];
            var info = await httpJson(API_BASE + "/info/" + animeId, HEADERS);
            var eps = await httpJson(API_BASE + "/eps/" + animeId, HEADERS);
            var aniZipMeta = await fetchAniZipMeta({ mal_id: optionalString(info && info.mal_id) });

            var trailers = [];
            if (info && info.trailer) {
                trailers.push(new Trailer({
                    name: "Trailer",
                    url: "https://www.youtube.com/watch?v=" + info.trailer
                }));
            }

            var cast = [];
            ((info && info.characters) || []).slice(0, 20).forEach(function (character) {
                cast.push(new Actor({
                    name: stringOrEmpty(character && character.name),
                    role: stringOrEmpty(character && character.role),
                    image: stringOrEmpty(character && character.image)
                }));
            });

            var recommendations = uniqueByUrl(((info && info.recommendations) || (info && info.relations) || []).slice(0, 12).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            var episodes = ((eps || [])).map(function (ep) {
                var episodeNumber = integerOrUndefined(ep && ep.ep_num);
                var episodeMeta = getAniZipEpisodeMeta(aniZipMeta, episodeNumber);
                var posterUrl = episodePosterUrl(ep, info, aniZipMeta);
                return new Episode({
                    name: stringOrEmpty((episodeMeta && episodeMeta.title && episodeMeta.title.en) || ep.name || ("Episode " + stringOrEmpty(episodeNumber || ep.ep_num))),
                    url: MAIN_URL + "/watch/" + animeId + "?ep=" + encodeURIComponent(stringOrEmpty(episodeNumber || ep.ep_num)) + "&server=default&source_type=sub",
                    season: 1,
                    episode: episodeNumber || 1,
                    description: cleanText((episodeMeta && (episodeMeta.overview || episodeMeta.summary)) || ep.desc || ""),
                    posterUrl: posterUrl,
                    thumbnailUrl: posterUrl,
                    image: posterUrl,
                    headers: IMAGE_HEADERS,
                    runtime: integerOrUndefined(episodeMeta && (episodeMeta.runtime || episodeMeta.length)),
                    airDate: optionalString((episodeMeta && (episodeMeta.airDate || episodeMeta.airdate)) || (ep && ep.aired_at)),
                    dubStatus: "sub"
                });
            });

            var nextAiring = mapStatus(info.status) === "ongoing"
                ? await fetchNextAiring({
                    anilistId: optionalString(info.anilist_id),
                    malId: optionalString(info.mal_id),
                    title: itemTitle(info)
                })
                : undefined;

            var fanartUrl = extractFanart(aniZipMeta);

            var item = new MultimediaItem({
                title: itemTitle(info),
                japaneseTitle: itemSubtitle(info),
                url: MAIN_URL + "/anime/" + animeId,
                posterUrl: coverUrl(info),
                bannerUrl: fanartUrl || absoluteUrl(info.banner || ""),
                logoUrl: absoluteUrl(info.clear_logo || ""),
                description: cleanText(info.description || ""),
                type: animeTypeFromFormat(info.format || info.type),
                year: numericYear(info),
                score: typeof info.average_score === "number" ? info.average_score / 10 : undefined,
                duration: integerOrUndefined(info.duration),
                status: mapStatus(info.status),
                contentRating: info.is_adult ? "R18+" : undefined,
                isAdult: !!info.is_adult,
                tags: normalizeTags(info),
                cast: cast,
                trailers: trailers,
                recommendations: recommendations,
                nextAiring: nextAiring || undefined,
                playbackPolicy: "none",
                syncData: {
                    anilist_id: optionalString(info.anilist_id),
                    mal_id: optionalString(info.mal_id)
                },
                headers: HEADERS,
                episodes: episodes
            });

            // Analytics tracking
            Analytics.logEvent('Animetsu_load', {
                episodeCount: episodes.length
            });

            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e.message || e) });
        }
    }

    async function fetchSources(animeId, epNum, server, sourceType) {
        return httpJson(
            API_BASE + "/oppai/" + animeId + "/" + epNum +
            "?server=" + encodeURIComponent(server || "default") +
            "&source_type=" + encodeURIComponent(sourceType || "sub"),
            HEADERS
        );
    }

    async function fetchServers(animeId, epNum) {
        return httpJson(
            API_BASE + "/servers/" + animeId + "/" + epNum,
            HEADERS
        );
    }

    async function loadStreams(url, cb) {
        try {
            var startTime = Date.now();
            var parsed = parseEpisodeInput(url);
            var serverList = [];
            var streams = [];
            var seen = {};

            try {
                serverList = await fetchServers(parsed.animeId, parsed.epNum);
            } catch (e1) {
                serverList = [];
            }

            if (!serverList || !serverList.length) {
                serverList = [{ id: parsed.server || "default", default: true }];
            } else {
                serverList = serverList.slice().sort(function (a, b) {
                    if (a.id === parsed.server) return -1;
                    if (b.id === parsed.server) return 1;
                    if (a.default) return -1;
                    if (b.default) return 1;
                    return 0;
                });
            }

            for (var i = 0; i < serverList.length; i++) {
                var server = serverList[i];
                var sourceTypes = parsed.sourceType === "dub" ? ["dub", "sub"] : ["sub", "dub"];

                for (var j = 0; j < sourceTypes.length; j++) {
                    var sourceType = sourceTypes[j];
                    var payload = null;

                    try {
                        payload = await fetchSources(parsed.animeId, parsed.epNum, server.id, sourceType);
                    } catch (e2) {
                        payload = null;
                    }

                    if (!payload || !payload.sources || !payload.sources.length) continue;

                    // Extract subtitles from payload
                    var subtitles = [];
                    if (payload.subtitles && payload.subtitles.length) {
                        for (var s = 0; s < payload.subtitles.length; s++) {
                            var sub = normalizeSubtitle(payload.subtitles[s]);
                            if (sub) subtitles.push(sub);
                        }
                    }
                    if (payload.tracks && payload.tracks.subtitle && payload.tracks.subtitle.length) {
                        for (var s = 0; s < payload.tracks.subtitle.length; s++) {
                            var sub = normalizeSubtitle(payload.tracks.subtitle[s]);
                            if (sub) subtitles.push(sub);
                        }
                    }

                    // Determine if this is a soft-sub (has separate subtitle tracks)
                    var isSoftSub = sourceType === "sub" && subtitles.length > 0;

                    var serverName = payload.server || server.id || "default";
                    var language = sourceType === "dub" ? "DUB" : "SUB";

                    for (var k = 0; k < payload.sources.length; k++) {
                        var source = payload.sources[k];
                        var streamUrl = source.need_proxy ? proxiedUrl(source.url) : absoluteUrl(source.url);
                        var key = streamUrl + "|" + serverName + "|" + sourceType + "|" + (source.quality || "");
                        if (!streamUrl || seen[key]) continue;
                        seen[key] = true;

                        var headers = {
                            "User-Agent": HEADERS["User-Agent"],
                            "Origin": MAIN_URL,
                            "Referer": MAIN_URL + "/"
                        };

                        // Expand M3U8 variant playlists into individual quality streams
                        if (/\.m3u8(?:$|[?#])/i.test(streamUrl)) {
                            try {
                                var res = await http_get(streamUrl, headers);
                                var body = res && (res.body || res.text) || "";
                                if (/#EXTM3U/i.test(body) && /#EXT-X-STREAM-INF:/i.test(body)) {
                                    var variantRe = /#EXT-X-STREAM-INF:([^\n\r]*)[\r\n]+([^\r\n]+)/gi;
                                    var vMatch;
                                    var m3u8Seen = {};
                                    while ((vMatch = variantRe.exec(body)) !== null) {
                                        var q = getStreamQuality(vMatch[1] + " " + vMatch[2]);
                                        var variantUrl = resolveUrl(streamUrl, vMatch[2]);
                                        var vKey = variantUrl + "|" + serverName + "|" + sourceType;
                                        if (!variantUrl || m3u8Seen[vKey]) continue;
                                        m3u8Seen[vKey] = true;
                                        var stream = new StreamResult({
                                            url: variantUrl,
                                            source: formatSourceLabel(serverName, q ? (q + "p") : source.quality, sourceType, isSoftSub),
                                            quality: q || undefined,
                                            headers: headers
                                        });
                                        stream.language = language;
                                        if (subtitles.length) stream.subtitles = subtitles;
                                        streams.push(stream);
                                    }
                                    if (Object.keys(m3u8Seen).length > 0) continue;
                                }
                            } catch (_) {}
                        }

                        // Create stream for non-M3U8 or failed M3U8 expansion
                        var stream = new StreamResult({
                            url: streamUrl,
                            source: formatSourceLabel(serverName, source.quality, sourceType, isSoftSub),
                            quality: getStreamQuality(source.quality || "") || undefined,
                            headers: headers
                        });
                        stream.language = language;
                        if (subtitles.length) stream.subtitles = subtitles;
                        streams.push(stream);
                    }
                }
            }

            if (!streams.length) throw new Error("No streams found from any server");

            // Analytics tracking
            Analytics.logEvent('Animetsu_loadstreams', {
                streamCount: streams.length
            });

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
