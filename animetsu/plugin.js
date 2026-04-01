(function () {
    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    const MAIN_URL = "https://animetsu.net";
    const API_BASE = MAIN_URL + "/v2/api/anime";
    const PROXY_BASE = "https://ani.metsu.site/proxy";

    const HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
        "Accept": "application/json, text/plain, */*",
        "Accept-Language": "en-US,en;q=0.5",
        "Origin": MAIN_URL,
        "Referer": MAIN_URL + "/"
    };

    function httpJson(url, headers) {
        return http_get(url, headers || HEADERS).then(function (res) {
            if (!res || !res.body) throw new Error("Empty response");
            return JSON.parse(res.body);
        });
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

    function itemTitle(data) {
        if (!data || !data.title) return "";
        return data.title.english || data.title.romaji || data.title.native || "";
    }

    function itemSubtitle(data) {
        if (!data || !data.title) return "";
        return data.title.native || data.title.romaji || "";
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
        return typeof y === "number" ? y : undefined;
    }

    function coverUrl(data) {
        if (!data || !data.cover_image) return "";
        return data.cover_image.large || data.cover_image.medium || data.cover_image.small || "";
    }

    function formatSourceLabel(serverName, quality, sourceType) {
        var parts = [];
        var q = String(quality || "").trim();
        var normalized = q.toLowerCase();

        parts.push(serverName || "default");

        if (q && normalized !== "master" && normalized !== "auto") {
            parts.push(q);
        }

        parts.push(String(sourceType || "sub").toUpperCase());
        return parts.join(" ");
    }

    function toMultimediaItem(data, opts) {
        opts = opts || {};

        var title = itemTitle(data);
        if (!title || !data || !data.id) return null;

        var url = opts.url || (MAIN_URL + "/anime/" + data.id);
        var item = new MultimediaItem({
            title: title,
            url: url,
            posterUrl: coverUrl(data),
            bannerUrl: absoluteUrl(data.banner || ""),
            type: animeTypeFromFormat(data.format || data.type),
            description: cleanText(data.description || opts.description || ""),
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
            var recent = await httpJson(API_BASE + "/recent?page=1&per_page=24", HEADERS);
            var recentResults = (recent && recent.results) || [];

            var recentItems = uniqueByUrl(recentResults.map(function (entry) {
                return toMultimediaItem(entry, {
                    url: MAIN_URL + "/watch/" + entry.id + "?ep=" + entry.ep_num,
                    description: entry.ep_name || ""
                });
            }));

            var trendingItems = uniqueByUrl(recentResults.slice(0, 8).map(function (entry) {
                return toMultimediaItem(entry, {
                    url: MAIN_URL + "/anime/" + entry.id,
                    description: entry.ep_name || ""
                });
            }));

            cb({
                success: true,
                data: {
                    "Trending": trendingItems,
                    "Recent Releases": recentItems
                }
            });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var data = await httpJson(API_BASE + "/search/?query=" + encodeURIComponent(query), HEADERS);
            var results = uniqueByUrl(((data && data.results) || []).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var animeMatch = String(url || "").match(/\/(?:anime|watch)\/([^/?#]+)/i);
            if (!animeMatch) throw new Error("Could not extract anime id from URL: " + url);

            var animeId = animeMatch[1];
            var info = await httpJson(API_BASE + "/info/" + animeId, HEADERS);
            var eps = await httpJson(API_BASE + "/eps/" + animeId, HEADERS);

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
                    name: character && character.name ? character.name : "",
                    role: character && character.role ? character.role : "",
                    image: character && character.image ? character.image : ""
                }));
            });

            var recommendations = uniqueByUrl(((info && info.recommendations) || (info && info.relations) || []).slice(0, 12).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            var episodes = ((eps || [])).map(function (ep) {
                return new Episode({
                    name: ep.name || ("Episode " + ep.ep_num),
                    url: MAIN_URL + "/watch/" + animeId + "?ep=" + ep.ep_num + "&server=default&source_type=sub",
                    season: 1,
                    episode: ep.ep_num,
                    description: cleanText(ep.desc || ""),
                    posterUrl: proxiedUrl(ep.img || "") || coverUrl(info),
                    headers: HEADERS,
                    dubStatus: "sub"
                });
            });

            var item = new MultimediaItem({
                title: itemTitle(info),
                japaneseTitle: itemSubtitle(info),
                url: MAIN_URL + "/anime/" + animeId,
                posterUrl: coverUrl(info),
                bannerUrl: absoluteUrl(info.banner || ""),
                logoUrl: absoluteUrl(info.clear_logo || ""),
                description: cleanText(info.description || ""),
                type: animeTypeFromFormat(info.format || info.type),
                year: numericYear(info),
                score: typeof info.average_score === "number" ? info.average_score / 10 : undefined,
                duration: typeof info.duration === "number" ? info.duration : undefined,
                status: mapStatus(info.status),
                contentRating: info.is_adult ? "R18+" : undefined,
                isAdult: !!info.is_adult,
                tags: []
                    .concat(info.genres || [])
                    .concat(info.tags || [])
                    .slice(0, 20),
                cast: cast,
                trailers: trailers,
                recommendations: recommendations,
                playbackPolicy: "none",
                syncData: {
                    anilist_id: info.anilist_id,
                    mal_id: info.mal_id
                },
                headers: HEADERS,
                episodes: episodes
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

                    for (var k = 0; k < payload.sources.length; k++) {
                        var source = payload.sources[k];
                        var streamUrl = source.need_proxy ? proxiedUrl(source.url) : absoluteUrl(source.url);
                        var key = streamUrl + "|" + (payload.server || server.id) + "|" + sourceType + "|" + (source.quality || "");
                        if (!streamUrl || seen[key]) continue;
                        seen[key] = true;

                        streams.push(new StreamResult({
                            url: streamUrl,
                            source: formatSourceLabel(payload.server || server.id || "default", source.quality, sourceType),
                            headers: {
                                "User-Agent": HEADERS["User-Agent"],
                                "Origin": MAIN_URL,
                                "Referer": MAIN_URL + "/"
                            }
                        }));
                    }
                }
            }

            if (!streams.length) throw new Error("No streams found from any server");

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
