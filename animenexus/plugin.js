(function () {
    var MAIN_URL = "https://anime.nexus";
    var API_BASE = "https://api.anime.nexus/api/anime";
    var ASSETS_BASE = "https://assets.anime.nexus";

    var HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:151.0) Gecko/20100101 Firefox/151.0",
        "Accept": "application/json, text/plain, */*",
        "Accept-Language": "en-US,en;q=0.5",
        "Origin": MAIN_URL,
        "Referer": MAIN_URL + "/"
    };

    var IMAGE_HEADERS = {
        "User-Agent": HEADERS["User-Agent"],
        "Accept": "image/avif,image/webp,image/png,image/jpeg,image/*,*/*;q=0.8",
        "Referer": MAIN_URL + "/"
    };

    function httpJson(url, headers) {
        return http_get(url, headers || HEADERS).then(function (res) {
            if (!res || !res.body) throw new Error("Empty response");
            return JSON.parse(res.body);
        });
    }

    function base64Decode(str) {
        if (typeof atob !== "undefined") return atob(str);
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        str = str.replace(/=+$/, "");
        var output = "";
        for (var i = 0; i < str.length; i += 4) {
            var a = chars.indexOf(str[i] || "A");
            var b = chars.indexOf(str[i + 1] || "A");
            var c = chars.indexOf(str[i + 2] || "A");
            var d = chars.indexOf(str[i + 3] || "A");
            if (a < 0) a = 0; if (b < 0) b = 0; if (c < 0) c = 0; if (d < 0) d = 0;
            output += String.fromCharCode((a << 18) | (b << 12) | (c << 6) | d);
        }
        return output;
    }

    function base64Encode(str) {
        if (typeof btoa !== "undefined") return btoa(str);
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var output = "";
        for (var i = 0; i < str.length; i += 3) {
            var a = str.charCodeAt(i) || 0;
            var b = str.charCodeAt(i + 1) || 0;
            var c = str.charCodeAt(i + 2) || 0;
            output += chars.charAt(a >> 2);
            output += chars.charAt(((a & 3) << 4) | (b >> 4));
            output += chars.charAt(((b & 15) << 2) | (c >> 6));
            output += chars.charAt(c & 63);
        }
        var pad = str.length % 3;
        if (pad === 1) output = output.substring(0, output.length - 2) + "==";
        else if (pad === 2) output = output.substring(0, output.length - 1) + "=";
        return output;
    }

    function decodeImgproxyUrl(path) {
        if (!path) return "";
        if (path.indexOf("http://") === 0 || path.indexOf("https://") === 0) return path;
        var segments = String(path).split("/");
        var b64Parts = [];
        for (var i = 2; i < segments.length; i++) {
            var seg = segments[i];
            if (seg.indexOf(":") >= 0) continue;
            b64Parts.push(seg);
        }
        if (b64Parts.length === 0) return "";
        var last = b64Parts[b64Parts.length - 1];
        b64Parts[b64Parts.length - 1] = last.replace(/\.[^.]+$/, "");
        var b64 = b64Parts.join("");
        if (b64.length % 4 !== 0) {
            b64 += "====".substring(0, 4 - (b64.length % 4));
        }
        try {
            var decoded = base64Decode(b64);
            if (decoded.indexOf("http://") === 0 || decoded.indexOf("https://") === 0) return decoded;
        } catch (_) {}
        return "";
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

    function integerOrUndefined(value) {
        if (value == null || value === "") return undefined;
        var num = Number(value);
        if (!isFinite(num)) return undefined;
        return Math.round(num);
    }

    function floatOrUndefined(value) {
        if (value == null || value === "") return undefined;
        var num = Number(value);
        if (!isFinite(num)) return undefined;
        return num;
    }

    function pickResized(obj, preferred) {
        if (!obj || !obj.resized) return "";
        for (var i = 0; i < preferred.length; i++) {
            var url = obj.resized[preferred[i]];
            if (url) return decodeImgproxyUrl(url);
        }
        var keys = Object.keys(obj.resized);
        return keys.length ? decodeImgproxyUrl(obj.resized[keys[0]]) : "";
    }

    function posterUrl(item) {
        return pickResized(item && item.poster, ["640x960", "480x720", "240x360", "1560x2340"]);
    }

    function logoUrl(item) {
        return pickResized(item && item.logo, ["large", "medium", "small"]);
    }

    function bannerUrl(item) {
        return pickResized(item && item.background, ["1920x1080", "3840x2160", "1360x768", "960x540"]);
    }

    function episodeImageUrl(episode) {
        return pickResized(episode && episode.image, ["1280x720", "640x360", "1920x1080", "1024x576"]);
    }

    function mapStatus(status) {
        var s = (status || "").toLowerCase();
        if (s === "currently airing" || s === "releasing") return "ongoing";
        if (s === "not yet aired" || s === "upcoming") return "upcoming";
        if (s === "finished airing" || s === "finished" || s === "cancelled") return "completed";
        return "";
    }

    function mapContentRating(type) {
        var t = (type || "").toLowerCase();
        if (t === "hentai" || t === "ero" || t === "adult") return "R18+";
        if (t === "rx") return "R18+";
        if (t === "r+") return "R17+";
        if (t === "pg-13") return "PG-13";
        return undefined;
    }

    function normalizeGenres(item) {
        var genres = item && item.genres;
        if (!genres || !Array.isArray(genres)) return [];
        return genres.map(function (g) {
            return typeof g === "string" ? g : stringOrEmpty(g.name || g.code || "");
        }).filter(function (g) { return !!g; }).slice(0, 20);
    }

    function toMultimediaItem(item, opts) {
        opts = opts || {};
        if (!item || !item.id || !item.name) return null;

        var animeId = item.id;
        var title = item.name;
        var url = opts.url || (MAIN_URL + "/anime/" + animeId);

        var itemData = {
            title: title,
            url: url,
            posterUrl: opts.posterUrl || posterUrl(item),
            bannerUrl: opts.bannerUrl || bannerUrl(item),
            logoUrl: opts.logoUrl || logoUrl(item),
            type: "anime",
            description: cleanText(opts.description || item.description || ""),
            headers: HEADERS
        };

        if (item.name_alt && item.name_alt !== title) {
            itemData.japaneseTitle = item.name_alt;
        }

        if (item.type) {
            var t = String(item.type).toLowerCase();
            if (t === "movie") itemData.type = "movie";
        }

        return new MultimediaItem(itemData);
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

    function mapHomeItems(items) {
        return uniqueByUrl((items || []).map(function (entry) {
            return toMultimediaItem(entry);
        }));
    }

    async function fetchAllEpisodes(animeId) {
        var all = [];
        var lastPage = 1;
        var baseUrl = API_BASE + "/details/episodes?id=" + encodeURIComponent(animeId) + "&order=asc&fillers=true&recaps=true";

        try {
            var first = await httpJson(baseUrl + "&page=1", HEADERS);
            if (first && first.data && Array.isArray(first.data)) {
                all = first.data;
                lastPage = first.meta && first.meta.last_page ? first.meta.last_page : 1;
            }
            for (var p = 2; p <= lastPage; p += 5) {
                var batch = [];
                var batchEnd = Math.min(p + 5, lastPage + 1);
                for (var b = p; b < batchEnd; b++) {
                    var pageNum = b;
                    batch.push(httpJson(baseUrl + "&page=" + pageNum, HEADERS).catch(function () { return null; }));
                }
                var pageResults = await Promise.all(batch);
                for (var r = 0; r < pageResults.length; r++) {
                    if (pageResults[r] && pageResults[r].data && Array.isArray(pageResults[r].data)) {
                        all = all.concat(pageResults[r].data);
                    }
                }
            }
        } catch (_) {}

        return all;
    }

    async function getHome(cb) {
        try {
            var results = await Promise.all([
                httpJson(API_BASE + "/featured", HEADERS).catch(function () { return null; }),
                httpJson(API_BASE + "/seasonal", HEADERS).catch(function () { return null; }),
                httpJson(API_BASE + "/popular?period=day&limit=15", HEADERS).catch(function () { return null; }),
                httpJson(API_BASE + "/latest", HEADERS).catch(function () { return null; })
            ]);

            var trendingItems = mapHomeItems((results[0] && results[0].data) || []).slice(0, 20);
            var seasonalItems = mapHomeItems((results[1] && results[1].data) || []).slice(0, 20);
            var popularItems = mapHomeItems((results[2] && results[2].data) || []).slice(0, 20);
            var latestItems = mapHomeItems((results[3] && results[3].data) || []).slice(0, 20);

            cb({
                success: true,
                data: {
                    "Trending Now": trendingItems,
                    "Seasonal Anime": seasonalItems,
                    "Most Popular": popularItems,
                    "Latest Anime": latestItems
                }
            });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var data = await httpJson(
                API_BASE + "/search?q=" + encodeURIComponent(query),
                HEADERS
            );
            var results = uniqueByUrl(((data && data.data) || []).map(function (entry) {
                return toMultimediaItem(entry, {
                    description: entry.description || ""
                });
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

            var results = await Promise.all([
                httpJson(API_BASE + "/details/view?id=" + encodeURIComponent(animeId), HEADERS).catch(function () { return null; }),
                fetchAllEpisodes(animeId),
                httpJson(API_BASE + "/details/statistics?id=" + encodeURIComponent(animeId), HEADERS).catch(function () { return null; }),
                httpJson(API_BASE + "/details/related?id=" + encodeURIComponent(animeId), HEADERS).catch(function () { return null; })
            ]);

            var info = results[0] && results[0].data;
            var episodes = results[1] || [];
            var stats = results[2] && results[2].data;
            var relatedData = (results[3] && results[3].data) || [];

            var trailers = [];

            var recommendations = uniqueByUrl(relatedData.slice(0, 12).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            var episodeItems = episodes.map(function (ep) {
                var epNum = integerOrUndefined(ep.number) || 1;
                var epTitle = ep.title || ("Episode " + epNum);
                return new Episode({
                    name: epTitle,
                    url: MAIN_URL + "/watch/" + animeId + "?ep=" + encodeURIComponent(ep.id) + "&num=" + encodeURIComponent(String(epNum)),
                    season: 1,
                    episode: epNum,
                    description: ep.title ? ("Episode " + epNum + ": " + ep.title) : ("Episode " + epNum),
                    posterUrl: episodeImageUrl(ep),
                    thumbnailUrl: episodeImageUrl(ep),
                    image: episodeImageUrl(ep),
                    headers: IMAGE_HEADERS,
                    runtime: integerOrUndefined(ep.duration),
                    dubStatus: ep.video_meta && ep.video_meta.audio_languages && ep.video_meta.audio_languages.indexOf("english") >= 0 ? "dub" : "sub",
                    isFillers: !!ep.is_filler,
                    isRecaps: !!ep.is_recap
                });
            });

            var score = null;
            if (stats && stats.weighted && stats.weighted.score) {
                score = floatOrUndefined(stats.weighted.score);
            } else if (stats && stats.average && stats.average.score) {
                score = floatOrUndefined(stats.average.score);
            }

            var item = new MultimediaItem({
                title: stringOrEmpty((info && info.name) || ""),
                japaneseTitle: stringOrEmpty((info && info.name_alt) || ""),
                url: MAIN_URL + "/anime/" + animeId,
                posterUrl: info ? posterUrl(info) : "",
                bannerUrl: info ? bannerUrl(info) : "",
                logoUrl: info ? logoUrl(info) : "",
                description: cleanText((info && info.description) || ""),
                type: (info && info.type && String(info.type).toLowerCase() === "movie") ? "movie" : "anime",
                score: score,
                duration: info && info.episode_count ? integerOrUndefined(info.episode_count) : undefined,
                status: mapStatus(info && info.status),
                contentRating: mapContentRating(info && info.type),
                tags: normalizeGenres(info),
                trailers: trailers,
                recommendations: recommendations,
                playbackPolicy: "none",
                headers: HEADERS,
                episodes: episodeItems
            });

            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e.message || e) });
        }
    }

    function resolveUrl(relativeUrl, baseUrl) {
        if (relativeUrl.indexOf("http://") === 0 || relativeUrl.indexOf("https://") === 0) return relativeUrl;
        if (relativeUrl.indexOf("//") === 0) return "https:" + relativeUrl;
        if (relativeUrl.indexOf("/") === 0) {
            var m = baseUrl.match(/^(https?:\/\/[^\/]+)/);
            return (m ? m[1] : "") + relativeUrl;
        }
        var idx = baseUrl.lastIndexOf("/");
        return (idx > 8 ? baseUrl.substring(0, idx + 1) : baseUrl + "/") + relativeUrl;
    }

    function buildStreamResult(url, source, headers, quality, subtitles) {
        var result = {
            url: url,
            source: source,
            headers: headers || {}
        };
        if (quality != null) {
            result.quality = quality;
        }
        if (subtitles && subtitles.length) {
            result.subtitles = subtitles;
        }
        return new StreamResult(result);
    }

    async function expandM3u8(url, headers, subtitles) {
        var streams = [];
        try {
            var resp = await http_get(url, headers);
            if (!resp || !resp.body) return streams;
            var lines = resp.body.split(/\r?\n/);
            for (var i = 0; i < lines.length; i++) {
                var line = lines[i].trim();
                if (line.indexOf("#EXT-X-STREAM-INF:") !== 0) continue;
                var attrs = line.substring(19);
                var quality = 0;
                var resMatch = attrs.match(/RESOLUTION=\d+x(\d+)/i);
                if (resMatch) {
                    quality = parseInt(resMatch[1], 10);
                } else {
                    var bwMatch = attrs.match(/BANDWIDTH=(\d+)/i);
                    if (bwMatch) {
                        var bw = parseInt(bwMatch[1], 10);
                        if (bw >= 8000000) quality = 2160;
                        else if (bw >= 4000000) quality = 1080;
                        else if (bw >= 2000000) quality = 720;
                        else if (bw >= 800000) quality = 480;
                        else quality = 360;
                    }
                }
                if (i + 1 < lines.length) {
                    var variantUrl = resolveUrl(lines[i + 1].trim(), url);
                    streams.push(buildStreamResult(
                        variantUrl,
                        "Anime Nexus [" + quality + "p]",
                        headers,
                        quality,
                        subtitles
                    ));
                }
            }
        } catch (_) {}
        return streams;
    }

    async function loadStreams(url, cb) {
        try {
            var match = String(url || "").match(/\/watch\/([^/?#]+)\?ep=([^&]+)/i);
            if (!match) throw new Error("Could not extract episode info from URL: " + url);

            var sessionCookie = "";

            try {
                if (typeof fetch !== "undefined") {
                    var fr = await fetch(MAIN_URL + "/watch/" + match[1], {
                        headers: {
                            "User-Agent": HEADERS["User-Agent"],
                            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                            "Accept-Language": "en-US,en;q=0.5",
                            "Origin": MAIN_URL,
                            "Referer": MAIN_URL + "/"
                        },
                        credentials: "include"
                    }).catch(function () { return null; });
                    if (fr) {
                        var sc = fr.headers.get("Set-Cookie");
                        if (sc) {
                            var m = sc.match(/^([^=]+=[^;]+)/);
                            if (m) sessionCookie = m[1];
                        }
                    }
                    var sr = await fetch(API_BASE + "/search?q=a", {
                        headers: HEADERS,
                        credentials: "include"
                    }).catch(function () { return null; });
                    if (sr && !sessionCookie) {
                        var sc2 = sr.headers.get("Set-Cookie");
                        if (sc2) {
                            var m2 = sc2.match(/^([^=]+=[^;]+)/);
                            if (m2) sessionCookie = m2[1];
                        }
                    }
                }
            } catch (_) {}
            try { await http_get(MAIN_URL + "/", HEADERS); } catch (_) {}
            try { await httpJson(API_BASE + "/search?q=a", HEADERS); } catch (_) {}

            var episodeId = decodeURIComponent(match[2]);

            var payload = await httpJson(
                API_BASE + "/details/episode/stream?id=" + encodeURIComponent(episodeId) + "&fillers=true&recaps=true",
                HEADERS
            );

            var data = payload && payload.data;
            if (!data || !data.hls) throw new Error("No HLS stream found");

            var hlsBase = data.hls.replace(/\/video\.m3u8$/, "");
            var qualities = (data.video_meta && data.video_meta.qualities) || {};

            var subtitles = [];
            if (data.subtitles && Array.isArray(data.subtitles)) {
                subtitles = data.subtitles.map(function (sub) {
                    return {
                        url: sub.src,
                        label: sub.label || sub.srcLang || "Unknown",
                        lang: sub.srcLang || "en"
                    };
                });
            }

            var streamHeaders = {
                "User-Agent": HEADERS["User-Agent"],
                "Accept": "*/*",
                "Origin": MAIN_URL,
                "Referer": url
            };
            if (sessionCookie) {
                streamHeaders["Cookie"] = sessionCookie;
            }

            var streams = [];
            var qualityKeys = Object.keys(qualities).sort(function (a, b) {
                return (parseInt(b.split("x")[1], 10) || 0) - (parseInt(a.split("x")[1], 10) || 0);
            });

            for (var i = 0; i < qualityKeys.length; i++) {
                var q = qualityKeys[i];
                var height = parseInt(q.split("x")[1], 10) || 0;
                var variantUrl = hlsBase + "/" + q + ".m3u8";
                var proxyUrl = "MAGIC_PROXY_v1" + base64Encode(variantUrl);
                streams.push(buildStreamResult(
                    proxyUrl,
                    "Anime Nexus [" + height + "p]",
                    streamHeaders,
                    height,
                    subtitles
                ));
            }

            var masterProxyUrl = "MAGIC_PROXY_v1" + base64Encode(data.hls);
            streams.push(buildStreamResult(
                masterProxyUrl,
                "Anime Nexus Auto",
                streamHeaders,
                undefined,
                subtitles
            ));

            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
    if (typeof window !== "undefined") {
        window.getHome = getHome;
        window.search = search;
        window.load = load;
        window.loadStreams = loadStreams;
    }
})();
