(function () {
    var JIKAN_API = "https://api.jikan.moe/v4";
    var ANIZIP_API = "https://api.ani.zip";
    var MALSYNC_API = "https://api.malsync.moe/mal/anime/";
    var HIANIME_SITE = "https://hianime.to";
    var MEGA_BASE = "https://megaplay.buzz";
    var VIDWISH_BASE = "https://vidwish.live";
    var MEGACLOUD_BASE = "https://megacloud.bloggy.click";
    var UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0";
    var JSON_HEADERS = {
        "User-Agent": UA,
        "Accept": "application/json, text/plain, */*"
    };

    function cleanText(value) {
        return String(value || "")
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<\/p>/gi, "\n")
            .replace(/<[^>]+>/g, " ")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&nbsp;/g, " ")
            .replace(/\s+/g, " ")
            .trim();
    }

    function htmlDecode(value) {
        return String(value || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'");
    }

    function toNumber(value) {
        var num = Number(value);
        return isFinite(num) ? num : undefined;
    }

    function absoluteUrl(url, base) {
        if (!url) return "";
        if (/^https?:\/\//i.test(url)) return url;
        if (String(url).indexOf("//") === 0) return "https:" + url;
        try {
            return new URL(url, base || MEGA_BASE).toString();
        } catch (_) {
            return String(url || "");
        }
    }

    function getJson(url, headers) {
        return http_get(url, headers || JSON_HEADERS).then(function (res) {
            if (!res || !res.body) throw new Error("Empty response");
            return JSON.parse(res.body);
        });
    }

    function getDoc(url, headers) {
        return http_get(url, headers || JSON_HEADERS).then(function (res) {
            return String(res && res.body || "");
        });
    }

    function mapStatus(status) {
        var value = String(status || "").toLowerCase();
        if (value === "currently airing") return "ongoing";
        if (value === "finished airing") return "completed";
        if (value === "not yet aired") return "upcoming";
        return "";
    }

    function mapType(type) {
        var value = String(type || "").toLowerCase();
        if (value.indexOf("movie") !== -1) return "movie";
        return "anime";
    }

    function titleFromEntry(entry) {
        return entry && (entry.title_english || entry.title || entry.title_japanese || "Unknown");
    }

    function normalizeTitle(value) {
        return String(value || "")
            .toLowerCase()
            .replace(/[^a-z0-9]+/g, " ")
            .trim();
    }

    function titleSimilarity(a, b) {
        var left = normalizeTitle(a).split(/\s+/).filter(Boolean);
        var right = normalizeTitle(b).split(/\s+/).filter(Boolean);
        if (!left.length || !right.length) return 0;
        var set = {};
        right.forEach(function (word) { set[word] = true; });
        var hits = 0;
        left.forEach(function (word) {
            if (set[word]) hits++;
        });
        return hits / Math.max(left.length, right.length);
    }

    function posterFromEntry(entry) {
        return entry && entry.images && entry.images.jpg && (entry.images.jpg.large_image_url || entry.images.jpg.image_url);
    }

    function mapHomeItem(entry) {
        if (!entry || !entry.mal_id) return null;
        return new MultimediaItem({
            title: titleFromEntry(entry),
            url: String(entry.mal_id),
            posterUrl: posterFromEntry(entry),
            type: mapType(entry.type),
            year: entry.year || undefined,
            description: cleanText(entry.synopsis || ""),
            headers: JSON_HEADERS
        });
    }

    function mapSearchItems(items) {
        return (items || []).map(mapHomeItem).filter(Boolean);
    }

    async function getHome(cb) {
        try {
            var results = await Promise.allSettled([
                getJson(JIKAN_API + "/top/anime?filter=bypopularity&limit=24"),
                getJson(JIKAN_API + "/seasons/now?limit=24"),
                getJson(JIKAN_API + "/top/anime?type=movie&limit=24"),
                getJson(JIKAN_API + "/top/anime?filter=upcoming&limit=24")
            ]);

            var data = {};
            var sections = [
                ["Popular Anime", 0],
                ["Current Season", 1],
                ["Anime Movies", 2],
                ["Upcoming Anime", 3]
            ];

            sections.forEach(function (section) {
                var key = section[0];
                var idx = section[1];
                var result = results[idx];
                if (!result || result.status !== "fulfilled") return;
                var items = mapSearchItems(result.value && result.value.data);
                if (items.length) data[key] = items;
            });

            if (!Object.keys(data).length) {
                return cb({ success: false, errorCode: "HOME_ERROR", message: "No home sections available" });
            }
            cb({ success: true, data: data });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e && e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var res = await getJson(JIKAN_API + "/anime?q=" + encodeURIComponent(query || "") + "&limit=24&sfw=true");
            cb({ success: true, data: mapSearchItems(res && res.data) });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e && e.message || e) });
        }
    }

    function getEpisodeMeta(aniZip, epNum) {
        var episodes = aniZip && aniZip.episodes;
        if (!episodes) return null;
        return episodes[String(epNum)] || episodes[epNum] || null;
    }

    async function load(url, cb) {
        try {
            var malId = parseInt(String(url || "").replace(/\D+/g, ""), 10);
            if (!malId) return cb({ success: false, errorCode: "LOAD_ERROR", message: "Invalid MAL id" });

            var results = await Promise.allSettled([
                getJson(JIKAN_API + "/anime/" + malId + "/full"),
                getJson(ANIZIP_API + "/mappings?mal_id=" + malId)
            ]);

            var detail = results[0] && results[0].status === "fulfilled" ? results[0].value && results[0].value.data : null;
            var aniZip = results[1] && results[1].status === "fulfilled" ? results[1].value : null;
            if (!detail) return cb({ success: false, errorCode: "LOAD_ERROR", message: "Anime not found" });

            var title = detail.title_english || detail.title || detail.title_japanese || "Unknown";
            var altTitle = detail.title || detail.title_japanese || undefined;
            var poster = posterFromEntry(detail);
            var banner = detail.images && detail.images.jpg && detail.images.jpg.large_image_url;
            var type = mapType(detail.type);
            var rating = toNumber(detail.score);
            var status = mapStatus(detail.status);
            var genres = (detail.genres || []).map(function (g) { return g && g.name; }).filter(Boolean);
            var trailers = [];
            if (detail.trailer && detail.trailer.url) {
                trailers.push(new Trailer({
                    name: "Trailer",
                    url: detail.trailer.url
                }));
            }

            var totalEpisodes = 1;
            if (type !== "movie") {
                totalEpisodes = toNumber(detail.episodes) || 0;
                if (!totalEpisodes && aniZip && aniZip.episodes) {
                    totalEpisodes = Object.keys(aniZip.episodes).length;
                }
                if (!totalEpisodes) totalEpisodes = 1;
            }

            var episodes = [];
            for (var epNum = 1; epNum <= totalEpisodes; epNum++) {
                var meta = getEpisodeMeta(aniZip, epNum);
                episodes.push(new Episode({
                    name: type === "movie"
                        ? "Full Movie"
                        : (meta && ((meta.title && (meta.title.en || meta.title.ja)) || meta.overview) ? ((meta.title && (meta.title.en || meta.title.ja)) || ("Episode " + epNum)) : ("Episode " + epNum)),
                    season: 1,
                    episode: epNum,
                    url: JSON.stringify({
                        malId: malId,
                        episode: epNum,
                        type: type,
                        title: title,
                        altTitle: altTitle
                    }),
                    posterUrl: meta && meta.image ? meta.image : poster,
                    description: meta && meta.overview ? cleanText(meta.overview) : undefined,
                    runtime: meta && meta.runtime ? toNumber(meta.runtime) : undefined,
                    headers: JSON_HEADERS
                }));
                if (type === "movie") break;
            }

            var item = new MultimediaItem({
                title: title,
                url: String(malId),
                posterUrl: poster || undefined,
                bannerUrl: banner || undefined,
                type: type,
                description: cleanText(detail.synopsis || ""),
                year: detail.year || undefined,
                score: rating,
                status: status,
                genres: genres.length ? genres : undefined,
                contentRating: detail.rating || undefined,
                episodes: episodes,
                trailers: trailers.length ? trailers : undefined,
                headers: JSON_HEADERS
            });
            if (altTitle && altTitle !== title) item.japaneseTitle = altTitle;
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e && e.message || e) });
        }
    }

    function parsePlayerIds(html) {
        var block = String(html || "").match(/<div[^>]+class="[^"]*fix-area[^"]*"[^>]+id="megaplay-player"[^>]*>/i);
        var tag = block ? block[0] : "";
        var dataId = "";
        var realId = "";
        var m1 = tag.match(/\bdata-id="([^"]+)"/i);
        if (m1) dataId = htmlDecode(m1[1]);
        var m2 = tag.match(/\bdata-realid="([^"]+)"/i);
        if (m2) realId = htmlDecode(m2[1]);
        return { dataId: dataId, realId: realId };
    }

    function qualityFromText(text) {
        var value = String(text || "").toLowerCase();
        var match = value.match(/\b(2160|1440|1080|720|576|480|360|240)p\b/);
        if (match) return parseInt(match[1], 10) || undefined;
        if (/\b4k\b|\buhd\b/.test(value)) return 2160;
        if (/\bfhd\b/.test(value)) return 1080;
        if (/\bhd\b/.test(value)) return 720;
        return undefined;
    }

    function buildSubtitleList(tracks) {
        return (tracks || []).map(function (track) {
            var file = track && track.file;
            if (!file) return null;
            return {
                name: track.label || track.kind || "Unknown",
                url: absoluteUrl(file, MEGA_BASE)
            };
        }).filter(Boolean);
    }

    function toStream(url, source, quality, headers, subtitles) {
        var stream = new StreamResult({
            url: url,
            source: source,
            quality: quality,
            headers: headers || JSON_HEADERS
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    function dedupeStreams(items) {
        var seen = {};
        return (items || []).filter(function (item) {
            if (!item || !item.url) return false;
            var key = item.url + "|" + (item.source || "");
            if (seen[key]) return false;
            seen[key] = true;
            return true;
        });
    }

    function parseSiteSearchSlugs(html) {
        var out = [];
        var seen = {};
        String(html || "").replace(/\/watch\/([a-z0-9-]+-\d+)(?:\?|["'])/gi, function (_, slug) {
            if (!slug || seen[slug]) return _;
            seen[slug] = true;
            out.push(slug);
            return _;
        });
        return out;
    }

    async function resolveHiAnimeSlug(data) {
        var malId = parseInt(data && data.malId, 10);
        if (malId) {
            try {
                var sync = await getJson(MALSYNC_API + malId, JSON_HEADERS);
                var sites = sync && (sync.Sites || sync.sites);
                var hianime = sites && (sites.HiAnime || sites.hianime || sites.Zoro || sites.zoro || sites.Aniwatch || sites.aniwatch);
                if (hianime) {
                    var keys = Object.keys(hianime);
                    if (keys.length) {
                        var item = hianime[keys[0]];
                        if (item && item.url) {
                            var match = String(item.url).match(/\/watch\/([a-z0-9-]+-\d+)/i);
                            if (match) return match[1];
                        }
                        if (item && item.identifier) return String(item.identifier);
                    }
                }
            } catch (_) {}
        }

        var titles = [data && data.title, data && data.altTitle].filter(Boolean);
        for (var i = 0; i < titles.length; i++) {
            try {
                var res = await getDoc(HIANIME_SITE + "/search?keyword=" + encodeURIComponent(titles[i]), {
                    "User-Agent": UA,
                    "Referer": HIANIME_SITE + "/"
                });
                var slugs = parseSiteSearchSlugs(res);
                if (!slugs.length) continue;
                slugs.sort(function (a, b) {
                    var left = titleSimilarity(a.replace(/-\d+$/, "").replace(/-/g, " "), titles[i]);
                    var right = titleSimilarity(b.replace(/-\d+$/, "").replace(/-/g, " "), titles[i]);
                    return right - left;
                });
                if (slugs[0]) return slugs[0];
            } catch (_) {}
        }

        return null;
    }

    function extractNumericAnimeId(slug) {
        var match = String(slug || "").match(/-(\d+)$/);
        return match ? match[1] : "";
    }

    function parseAjaxJson(body) {
        var json = JSON.parse(String(body || "{}"));
        if (json && json.data) return json.data;
        return json;
    }

    function parseEpisodeIdFromHtml(html, episodeNum) {
        var wanted = String(episodeNum);
        var match = null;
        var re = /<a[^>]+class="[^"]*ep-item[^"]*"[^>]*href="([^"]+)"[^>]*data-number="([^"]+)"[^>]*>/gi;
        while ((match = re.exec(String(html || "")))) {
            if (String(match[2]) === wanted) {
                var href = htmlDecode(match[1]);
                var epMatch = href.match(/[?&]ep=(\d+)/i);
                if (epMatch) return epMatch[1];
            }
        }
        re = /<a[^>]+class="[^"]*ep-item[^"]*"[^>]*href="([^"]+)"[^>]*>/gi;
        while ((match = re.exec(String(html || "")))) {
            var href2 = htmlDecode(match[1]);
            var around = String(html || "").slice(Math.max(0, match.index - 120), match.index + match[0].length + 120);
            if (new RegExp("data-number\\s*=\\s*[\"']" + wanted + "[\"']", "i").test(around) || new RegExp(">\\s*" + wanted + "\\s*<").test(around)) {
                var epMatch2 = href2.match(/[?&]ep=(\d+)/i);
                if (epMatch2) return epMatch2[1];
            }
        }
        return "";
    }

    function parseServersFromHtml(html, category) {
        var out = [];
        var seen = {};
        var block = String(html || "");
        var categoryPattern = category === "dub" ? /dub/i : /sub/i;
        if (!categoryPattern.test(block)) {
            categoryPattern = /.*/;
        }
        block.replace(/<div[^>]+data-id="([^"]+)"[^>]*>([\s\S]*?)<\/div>/gi, function (_, id, inner) {
            var text = cleanText(inner);
            if (!id || !text || seen[id]) return _;
            if (!/hd-|vidstreaming|streamsb|filemoon|megacloud|streamtape/i.test(text)) return _;
            seen[id] = true;
            out.push({ id: id, name: text });
            return _;
        });
        block.replace(/<li[^>]+data-id="([^"]+)"[^>]*>([\s\S]*?)<\/li>/gi, function (_, id, inner) {
            var text = cleanText(inner);
            if (!id || !text || seen[id]) return _;
            if (!/hd-|vidstreaming|streamsb|filemoon|megacloud|streamtape/i.test(text)) return _;
            seen[id] = true;
            out.push({ id: id, name: text });
            return _;
        });
        return out;
    }

    async function tryHiAnimeAjaxSources(data, results) {
        var slug = await resolveHiAnimeSlug(data);
        if (!slug) return false;
        var animeId = extractNumericAnimeId(slug);
        if (!animeId) return false;

        try {
            var listRes = await http_get(HIANIME_SITE + "/ajax/v2/episode/list/" + animeId, {
                "User-Agent": UA,
                "Accept": "*/*",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": HIANIME_SITE + "/watch/" + slug
            });
            var listData = parseAjaxJson(listRes && listRes.body);
            var listHtml = listData && listData.html || "";
            var episodeId = parseEpisodeIdFromHtml(listHtml, data.episode || 1);
            if (!episodeId) return false;

            for (var c = 0; c < 2; c++) {
                var category = c === 0 ? "sub" : "dub";
                var serversRes = await http_get(HIANIME_SITE + "/ajax/v2/episode/servers?episodeId=" + episodeId, {
                    "User-Agent": UA,
                    "Accept": "*/*",
                    "X-Requested-With": "XMLHttpRequest",
                    "Referer": HIANIME_SITE + "/watch/" + slug + "?ep=" + episodeId
                });
                var serversData = parseAjaxJson(serversRes && serversRes.body);
                var serversHtml = serversData && serversData.html || "";
                var servers = parseServersFromHtml(serversHtml, category);
                for (var i = 0; i < servers.length; i++) {
                    var server = servers[i];
                    try {
                        var sourcesRes = await http_get(HIANIME_SITE + "/ajax/v2/episode/sources?id=" + server.id, {
                            "User-Agent": UA,
                            "Accept": "*/*",
                            "X-Requested-With": "XMLHttpRequest",
                            "Referer": HIANIME_SITE + "/watch/" + slug + "?ep=" + episodeId
                        });
                        var sourcesData = parseAjaxJson(sourcesRes && sourcesRes.body);
                        var sourcePayload = sourcesData && (sourcesData.link || sourcesData.sources || sourcesData.streamingLink && sourcesData.streamingLink.link || sourcesData.streamingLink);
                        var tracksPayload = sourcesData && (sourcesData.tracks || sourcesData.streamingLink && sourcesData.streamingLink.tracks);
                        var file = "";
                        if (sourcePayload) {
                            if (typeof sourcePayload.file === "string") file = sourcePayload.file;
                            else if (Array.isArray(sourcePayload) && sourcePayload.length) {
                                file = sourcePayload[0] && (sourcePayload[0].file || sourcePayload[0].url || sourcePayload[0].src) || "";
                            }
                        }
                        if (!file) continue;
                        var subs = buildSubtitleList(tracksPayload);
                        var items = await parseM3u8(file, "[HiAnime] " + server.name + " [" + category.toUpperCase() + "]", HIANIME_SITE + "/", subs);
                        items.forEach(function (item) { results.push(item); });
                    } catch (_) {}
                }
            }
            return results.length > 0;
        } catch (_) {
            return false;
        }
    }

    async function parseM3u8(url, source, referer, subtitles) {
        var headers = {
            "User-Agent": UA,
            "Accept": "*/*",
            "Origin": referer,
            "Referer": referer
        };
        try {
            var res = await http_get(url, headers);
            var text = String(res && res.body || "");
            if (!/#EXTM3U/i.test(text)) {
                return [toStream(url, source, qualityFromText(source), headers, subtitles)];
            }
            var lines = text.split(/\r?\n/);
            var out = [];
            for (var i = 0; i < lines.length; i++) {
                var line = lines[i];
                if (!/^#EXT-X-STREAM-INF:/i.test(line)) continue;
                var next = "";
                for (var j = i + 1; j < lines.length; j++) {
                    if (lines[j] && lines[j][0] !== "#") {
                        next = lines[j].trim();
                        break;
                    }
                }
                if (!next) continue;
                var resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
                var quality = resMatch ? parseInt(resMatch[1], 10) : qualityFromText(line);
                out.push(toStream(absoluteUrl(next, url), source + (quality ? " " + quality + "p" : ""), quality, headers, subtitles));
            }
            return out.length ? out : [toStream(url, source, qualityFromText(source), headers, subtitles)];
        } catch (_) {
            return [toStream(url, source, qualityFromText(source), headers, subtitles)];
        }
    }

    async function processSource(displayName, apiUrl, referer, origin, results, subtitleMap) {
        try {
            var json = await getJson(apiUrl, {
                "User-Agent": UA,
                "Accept": "*/*",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": referer
            });

            var tracks = buildSubtitleList(json && json.tracks);
            tracks.forEach(function (track) {
                if (!subtitleMap[track.url]) subtitleMap[track.url] = track;
            });

            var file = "";
            if (json && json.sources) {
                if (typeof json.sources.file === "string") file = json.sources.file;
                else if (Array.isArray(json.sources) && json.sources.length) {
                    file = json.sources[0] && (json.sources[0].file || json.sources[0].src || json.sources[0].url) || "";
                }
            }
            if (!file && Array.isArray(json && json.sources)) {
                for (var i = 0; i < json.sources.length; i++) {
                    var source = json.sources[i];
                    if (source && (source.file || source.src || source.url)) {
                        file = source.file || source.src || source.url;
                        break;
                    }
                }
            }
            if (!file) return;

            var items = await parseM3u8(absoluteUrl(file, origin), displayName, origin, tracks);
            items.forEach(function (item) { results.push(item); });
        } catch (_) {}
    }

    async function loadStreams(url, cb) {
        try {
            var data = JSON.parse(String(url || "{}"));
            var malId = parseInt(data.malId, 10);
            var episode = parseInt(data.episode || 1, 10) || 1;
            if (!malId) return cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid MAL id" });

            var results = [];
            var subtitles = {};
            var ajaxWorked = await tryHiAnimeAjaxSources(data, results);

            if (ajaxWorked) {
                return cb({ success: true, data: dedupeStreams(results) });
            }

            async function processType(dubType) {
                var streamType = dubType === "sub" ? "sub" : "dub";
                var megaUrl = MEGA_BASE + "/stream/mal/" + malId + "/" + episode + "/" + streamType;
                var html;
                try {
                    html = await getDoc(megaUrl, {
                        "User-Agent": UA,
                        "Referer": megaUrl
                    });
                } catch (_) {
                    return;
                }

                var ids = parsePlayerIds(html);
                if (ids.dataId) {
                    await processSource("[HiAnime] MegaPlay [" + streamType.toUpperCase() + "]", MEGA_BASE + "/stream/getSources?id=" + ids.dataId + "&id=" + ids.dataId, megaUrl, MEGA_BASE + "/", results, subtitles);
                }

                if (ids.realId) {
                    try {
                        var vidPage = VIDWISH_BASE + "/stream/s-2/" + ids.realId + "/" + streamType;
                        var vidHtml = await getDoc(vidPage, { "User-Agent": UA, "Referer": megaUrl });
                        var vidIds = parsePlayerIds(vidHtml);
                        if (vidIds.dataId) {
                            await processSource("[HiAnime] Vidwish [" + streamType.toUpperCase() + "]", VIDWISH_BASE + "/stream/getSources?id=" + vidIds.dataId + "&id=" + vidIds.dataId, vidPage, VIDWISH_BASE + "/", results, subtitles);
                        }
                    } catch (_) {}

                    try {
                        var megaCloudPage = MEGACLOUD_BASE + "/stream/s-3/" + ids.realId + "/" + streamType;
                        var megaCloudHtml = await getDoc(megaCloudPage, { "User-Agent": UA, "Referer": megaUrl });
                        var megaCloudIds = parsePlayerIds(megaCloudHtml);
                        if (megaCloudIds.dataId) {
                            await processSource("[HiAnime] MegaCloud [" + streamType.toUpperCase() + "]", MEGACLOUD_BASE + "/stream/getSources?id=" + megaCloudIds.dataId + "&id=" + megaCloudIds.dataId, megaCloudPage, MEGACLOUD_BASE + "/", results, subtitles);
                        }
                    } catch (_) {}
                }
            }

            await Promise.all([processType("sub"), processType("dub")]);
            cb({ success: true, data: dedupeStreams(results) });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e && e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
