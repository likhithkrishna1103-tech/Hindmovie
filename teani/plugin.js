(function () {
var DEBUG = false;

    var CINEMETA_CATALOG = "https://cinemeta-catalogs.strem.io";
    var CINEMETA_META = "https://v3-cinemeta.strem.io";
    var KITSU_BASE = "https://anime-kitsu.strem.fun";
    var TORRENTIO = "https://torrentio.strem.fun/sort=seeders";
    var STREAMVIX = "https://streamvix.hayd.uk";
    var WEBSTREAMR = "https://webstreamr.hayd.uk/%7B%22multi%22:%22on%22,%22al%22:%22on%22,%22de%22:%22on%22,%22es%22:%22on%22,%22fr%22:%22on%22,%22it%22:%22on%22,%22mx%22:%22on%22,%22mediaFlowProxyUrl%22:%22%22,%22mediaFlowProxyPassword%22:%22%22,%22disableExtractor_hubcloud%22:%22on%22,%22disableExtractor_hubdrive%22:%22on%22%7D";
    var NOTORRENT = "https://addon-osvh.onrender.com";
    var ANIZIP = "https://api.ani.zip";
    var ANIMETOSHO = "https://feed.animetosho.org";
    var TMV_BASE = "https://www.1tamilmv.immo";

    var HOME_CONFIG = {
        animeAiring: { key: "Anime Airing Now", source: "kitsu", url: KITSU_BASE + "/catalog/anime/kitsu-anime-airing.json", limit: 18 },
        animeTrending: { key: "Anime Trending", source: "kitsu", url: KITSU_BASE + "/catalog/anime/kitsu-anime-trending.json", limit: 18 },
        topMovies: { key: "Hollywood Blockbusters", source: "cinemeta", url: CINEMETA_CATALOG + "/top/catalog/movie/top.json", limit: 18 },
        topSeries: { key: "Hollywood Prestige Series", source: "cinemeta", url: CINEMETA_CATALOG + "/top/catalog/series/top.json", limit: 18 }
    };

    function log() {
        if (!DEBUG) return;
        var args = Array.prototype.slice.call(arguments);
        args.unshift("[CineStream]");
        console.log.apply(console, args);
    }

    function trim(str) {
        return (str || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function parseJsonSafe(str, fallback) {
        if (str && typeof str === "object") return str;
        var value = String(str || "");
        try {
            return JSON.parse(value);
        } catch (e) {
            try {
                return JSON.parse(value.replace(/^'+|'+$/g, "").replace(/^\"+|\\"+$/g, "").replace(/\\"/g, "\""));
            } catch (e2) {
                var relaxed = parseLooseObject(value);
                return relaxed || fallback;
            }
        }
    }

    function parseLooseValue(value) {
        var text = trim(String(value || ""));
        if (!text.length) return "";
        if (text === "null") return null;
        if (text === "true") return true;
        if (text === "false") return false;
        if (/^-?\d+(?:\.\d+)?$/.test(text)) return Number(text);
        return text.replace(/^"(.*)"$/, "$1").replace(/^'(.*)'$/, "$1");
    }

    function parseLooseObject(str) {
        var text = trim(String(str || ""));
        if (!/^\{[\s\S]*\}$/.test(text)) return null;
        text = text.slice(1, -1);
        var out = {};
        var pattern = /([A-Za-z0-9_]+)\s*:\s*([\s\S]*?)(?=,\s*[A-Za-z0-9_]+\s*:|$)/g;
        var match;
        while ((match = pattern.exec(text))) {
            out[match[1]] = parseLooseValue(match[2]);
        }
        return Object.keys(out).length ? out : null;
    }

    function request(url, headers) {
        if (typeof axios !== "undefined" && axios && typeof axios.get === "function") {
            return axios.get(url, {
                headers: headers || { "User-Agent": "Mozilla/5.0" },
                proxy: false,
                responseType: "text",
                transformResponse: [function (data) { return data; }]
            }).then(function (res) {
                return {
                    status: res.status,
                    statusCode: res.status,
                    body: typeof res.data === "string" ? res.data : JSON.stringify(res.data),
                    headers: res.headers || {}
                };
            }).catch(function (e) {
                return {
                    status: e.response && e.response.status || 500,
                    statusCode: e.response && e.response.status || 500,
                    body: e.response && (typeof e.response.data === "string" ? e.response.data : JSON.stringify(e.response.data)) || String(e.message || e),
                    headers: e.response && e.response.headers || {}
                };
            });
        }
        return http_get(url, headers);
    }

    function httpText(url, headers) {
        return request(url, headers).then(function (res) {
            return (res && res.body) || "";
        });
    }

    function httpJson(url, headers) {
        return request(url, headers).then(function (res) {
            return JSON.parse((res && res.body) || "{}");
        });
    }

    function settled(promises) {
        return Promise.all(promises.map(function (p) {
            return Promise.resolve(p).then(function (value) {
                return { ok: true, value: value };
            }).catch(function (error) {
                return { ok: false, error: error };
            });
        }));
    }

    function extractYear(value) {
        var match = String(value || "").match(/\b(19|20)\d{2}\b/);
        return match ? parseInt(match[0], 10) : undefined;
    }

    function getQuality(text) {
        var lower = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b/.test(lower)) return 2160;
        if (/\b1440p\b/.test(lower)) return 1440;
        if (/\b1080p\b/.test(lower)) return 1080;
        if (/\b720p\b/.test(lower)) return 720;
        if (/\b576p\b/.test(lower)) return 576;
        if (/\b480p\b/.test(lower)) return 480;
        if (/\b360p\b/.test(lower)) return 360;
        return 0;
    }

    function extractSize(text) {
        var match = String(text || "").match(/(\d+(?:\.\d+)?)\s*(GB|MB)/i);
        return match ? (match[1] + " " + match[2].toUpperCase()) : "";
    }

    function formatBytes(bytes) {
        if (!bytes || isNaN(bytes)) return "";
        if (bytes >= 1073741824) return (Math.round((bytes / 1073741824) * 100) / 100) + " GB";
        if (bytes >= 1048576) return (Math.round((bytes / 1048576) * 100) / 100) + " MB";
        if (bytes >= 1024) return (Math.round((bytes / 1024) * 100) / 100) + " KB";
        return String(bytes) + " B";
    }

    function normalizeTitle(value) {
        return trim(String(value || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/[^a-z0-9]+/g, " "));
    }

    function wordOverlap(left, right) {
        var a = normalizeTitle(left).split(" ");
        var b = normalizeTitle(right).split(" ");
        var set = {};
        var matches = 0;
        var i;
        for (i = 0; i < b.length; i++) {
            if (b[i]) set[b[i]] = true;
        }
        for (i = 0; i < a.length; i++) {
            if (a[i] && set[a[i]]) matches++;
        }
        return a.length || b.length ? (matches / Math.max(a.length || 1, b.length || 1)) : 0;
    }

    function isSeriesTitle(title) {
        var lower = String(title || "").toLowerCase();
        return /\bs\d{1,2}\b/.test(lower) ||
            /\bseason\b/.test(lower) ||
            /\bepisode\b/.test(lower) ||
            /\bweb[- ]?series\b/.test(lower);
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function cleanHtmlText(value) {
        return trim(String(value || "")
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<[^>]+>/g, " ")
            .replace(/&nbsp;/g, " ")
            .replace(/&amp;/g, "&")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">"));
    }

    function toAbsoluteUrl(url) {
        if (!url) return "";
        if (/^https?:\/\//i.test(url)) return url;
        if (url.indexOf("//") === 0) return "https:" + url;
        if (url.charAt(0) === "/") return TMV_BASE + url;
        return TMV_BASE + "/" + url.replace(/^\.\//, "");
    }

    function interleaveLists(lists, limit) {
        var out = [];
        var max = 0;
        var i;
        for (i = 0; i < lists.length; i++) {
            if (lists[i].length > max) max = lists[i].length;
        }
        for (i = 0; i < max; i++) {
            for (var j = 0; j < lists.length; j++) {
                if (i < lists[j].length) out.push(lists[j][i]);
                if (limit && out.length >= limit) return out;
            }
        }
        return out;
    }

    function buildMetaPayload(meta, source) {
        return JSON.stringify({
            provider: "meta",
            source: source,
            id: meta.id,
            imdbId: meta.imdb_id || meta.id,
            kitsuId: meta.kitsu_id || (String(meta.id || "").indexOf("kitsu:") === 0 ? String(meta.id).split(":")[1] : null),
            type: meta.type === "series" ? "series" : "movie",
            isAnime: source === "kitsu"
        });
    }

    function createMetaItem(meta, source) {
        return {
            title: meta.name || "Unknown",
            url: buildMetaPayload(meta, source),
            posterUrl: meta.poster || undefined,
            bannerUrl: meta.background || undefined,
            type: source === "kitsu" ? "anime" : (meta.type === "series" ? "series" : "movie"),
            description: trim(meta.description || ""),
            year: extractYear(meta.releaseInfo || meta.year),
            score: meta.imdbRating ? parseFloat(meta.imdbRating) : undefined,
            genres: meta.genres || meta.genre || []
        };
    }

    function buildCatalogSection(json, source, limit) {
        var metas = json && json.metas ? json.metas : [];
        var items = [];
        for (var i = 0; i < metas.length; i++) items.push(createMetaItem(metas[i], source));
        return uniqueBy(items, function (item) { return item.url; }).slice(0, limit || items.length);
    }

    function itemText(item) {
        return normalizeTitle([
            item && item.title,
            item && item.description,
            item && item.year
        ].join(" "));
    }

    function pickSection(items, predicate, limit, fallback) {
        var filtered = items.filter(predicate);
        if (!filtered.length && Array.isArray(fallback)) filtered = fallback.slice();
        return uniqueBy(filtered, function (item) { return item.url; }).slice(0, limit || filtered.length);
    }

    function isIndianItem(item) {
        return /\b(indian|india|hindi|tamil|telugu|malayalam|kannada|marathi|punjabi|bollywood|kollywood|tollywood|mollywood)\b/.test(itemText(item));
    }

    function isSouthRegionalItem(item) {
        return /\b(tamil|telugu|malayalam|kannada|kollywood|tollywood|mollywood)\b/.test(itemText(item));
    }

    function buildTamilMvPayload(item) {
        return JSON.stringify({
            provider: "1tamilmv",
            url: item.url,
            title: item.title,
            type: item.type
        });
    }

    function createTamilMvItem(item) {
        return {
            title: item.title,
            url: buildTamilMvPayload(item),
            posterUrl: item.posterUrl || undefined,
            type: item.type,
            description: item.description || undefined
        };
    }

    function parseTamilMvTopicList(html) {
        var results = [];
        var seen = {};
        var re = /<a[^>]+href="([^"]*\/forums\/topic\/[^"]+)"[^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = re.exec(html))) {
            var href = toAbsoluteUrl(match[1]);
            var title = cleanHtmlText(match[2]);
            if (!href || !title || title.length < 4) continue;
            if (seen[href]) continue;
            if (/^(home|forums|leaderboard|languages|watch online)$/i.test(title)) continue;
            if (/^(sign in|existing user)/i.test(title)) continue;
            seen[href] = true;
            results.push({
                title: title,
                url: href,
                type: isSeriesTitle(title) ? "series" : "movie"
            });
        }
        return results;
    }

    function fetchTamilMvForum(url, limit, preferSeries) {
        return httpText(url).then(function (body) {
            var items = parseTamilMvTopicList(body || "");
            if (preferSeries) {
                items = items.filter(function (item) { return item.type === "series"; });
            }
            return items.slice(0, limit || items.length);
        });
    }

    function fetchTamilMvSearch(query) {
        var q = encodeURIComponent(trim(query));
        var urls = [
            TMV_BASE + "/index.php?/search/&q=" + q + "&type=forums_topic",
            TMV_BASE + "/index.php?/search/?q=" + q + "&type=forums_topic"
        ];

        function tryAt(index) {
            if (index >= urls.length) return Promise.resolve([]);
            return httpText(urls[index]).then(function (body) {
                var items = parseTamilMvTopicList(body || "");
                if (items.length) return items;
                return tryAt(index + 1);
            }).catch(function () {
                return tryAt(index + 1);
            });
        }

        return tryAt(0);
    }

    function getHome(cb) {
        var jobs = {
            animeAiring: httpJson(HOME_CONFIG.animeAiring.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.animeAiring.source, HOME_CONFIG.animeAiring.limit);
            }),
            animeTrending: httpJson(HOME_CONFIG.animeTrending.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.animeTrending.source, HOME_CONFIG.animeTrending.limit);
            }),
            topMovies: httpJson(HOME_CONFIG.topMovies.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.topMovies.source, 60);
            }),
            topSeries: httpJson(HOME_CONFIG.topSeries.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.topSeries.source, 60);
            })
        };

        Promise.allSettled([jobs.animeAiring, jobs.animeTrending, jobs.topMovies, jobs.topSeries]).then(function (results) {
            var animeAiring = results[0].status === "fulfilled" ? results[0].value : [];
            var animeTrending = results[1].status === "fulfilled" ? results[1].value : [];
            var topMovies = results[2].status === "fulfilled" ? results[2].value : [];
            var topSeries = results[3].status === "fulfilled" ? results[3].value : [];

            var indianMovies = pickSection(topMovies, isIndianItem, 18, topMovies.slice(0, 18));
            var indianSeries = pickSection(topSeries, isIndianItem, 18, topSeries.slice(0, 18));
            var southRegional = pickSection(topMovies, isSouthRegionalItem, 18, indianMovies);
            var hollywoodMovies = pickSection(topMovies, function (item) { return !isIndianItem(item); }, 18, topMovies.slice(0, 18));
            var hollywoodSeries = pickSection(topSeries, function (item) { return !isIndianItem(item); }, 18, topSeries.slice(0, 18));

            var homeData = {};
            if (animeAiring.length) homeData[HOME_CONFIG.animeAiring.key] = animeAiring;
            if (animeTrending.length) homeData[HOME_CONFIG.animeTrending.key] = animeTrending;
            if (indianMovies.length) homeData["Indian Top Movies"] = indianMovies;
            if (indianSeries.length) homeData["Indian Top Series"] = indianSeries;
            if (southRegional.length) homeData["South Regional Picks"] = southRegional;
            if (hollywoodMovies.length) homeData[HOME_CONFIG.topMovies.key] = hollywoodMovies;
            if (hollywoodSeries.length) homeData[HOME_CONFIG.topSeries.key] = hollywoodSeries;

            if (!Object.keys(homeData).length) {
                return cb({ success: false, errorCode: "HOME_ERROR", message: "No homepage sections returned" });
            }
            cb({ success: true, data: homeData });
        }).catch(function (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        });
    }

    function search(query, cb) {
        var q = encodeURIComponent(trim(query));
        var jobs = [
            httpJson(CINEMETA_META + "/catalog/movie/top/search=" + q + ".json").then(function (json) {
                return buildCatalogSection(json, "cinemeta", 30);
            }),
            httpJson(CINEMETA_META + "/catalog/series/top/search=" + q + ".json").then(function (json) {
                return buildCatalogSection(json, "cinemeta", 30);
            }),
            httpJson(KITSU_BASE + "/catalog/anime/kitsu-anime-trending/search=" + q + ".json").then(function (json) {
                return buildCatalogSection(json, "kitsu", 30);
            }),
            fetchTamilMvSearch(query).then(function (items) {
                return items.slice(0, 20).map(createTamilMvItem);
            })
        ];

        settled(jobs).then(function (results) {
            var lists = [];
            for (var i = 0; i < results.length; i++) if (results[i].ok) lists.push(results[i].value);
            var merged = uniqueBy(interleaveLists(lists, 60), function (item) { return item.url; });
            cb({ success: true, data: merged });
        }).catch(function (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        });
    }

    function buildDescription(meta) {
        var parts = [];
        var description = trim(meta.description || "");
        var cast = meta.cast && meta.cast.length ? meta.cast.slice(0, 6).join(", ") : "";
        var genres = meta.genres || meta.genre || [];
        if (description) parts.push(description);
        if (cast) parts.push("Cast: " + cast);
        if (genres.length) parts.push("Genres: " + genres.join(", "));
        return parts.join("\n\n");
    }

    function buildEpisodePayload(base, episode) {
        return JSON.stringify({
            provider: "meta",
            source: base.source,
            id: base.id,
            imdbId: base.imdbId,
            kitsuId: base.kitsuId || null,
            type: base.type,
            isAnime: !!base.isAnime,
            title: base.title,
            year: base.year,
            season: episode.season,
            episode: episode.episode
        });
    }

    function sortEpisodes(a, b) {
        if ((a.season || 0) !== (b.season || 0)) return (a.season || 0) - (b.season || 0);
        return (a.episode || 0) - (b.episode || 0);
    }

    function loadMetaItem(payload, cb) {
        var baseUrl = payload.source === "kitsu" ? KITSU_BASE : CINEMETA_META;
        var metaUrl = baseUrl + "/meta/" + payload.type + "/" + encodeURIComponent(payload.id) + ".json";

        httpJson(metaUrl).then(function (json) {
            var meta = json && json.meta ? json.meta : null;
            if (!meta) throw new Error("Metadata not found");

            var itemType = meta.type === "series" ? "series" : "movie";
            var baseData = {
                source: payload.source,
                id: payload.id,
                imdbId: meta.imdb_id || payload.imdbId || payload.id,
                kitsuId: payload.kitsuId || meta.kitsu_id || (String(meta.id || "").indexOf("kitsu:") === 0 ? String(meta.id).split(":")[1] : null),
                type: itemType,
                isAnime: payload.source === "kitsu",
                title: meta.name || "Unknown",
                year: extractYear(meta.releaseInfo || meta.year)
            };

            var item = {
                title: baseData.title,
                url: payload.raw,
                posterUrl: meta.poster || undefined,
                bannerUrl: meta.background || undefined,
                type: itemType,
                description: buildDescription(meta) || undefined,
                year: baseData.year,
                score: meta.imdbRating ? parseFloat(meta.imdbRating) : undefined,
                genres: meta.genres || meta.genre || []
            };

            if (itemType === "movie") {
                item.episodes = [new Episode({
                    name: item.title,
                    url: JSON.stringify({
                        provider: "meta",
                        source: baseData.source,
                        id: baseData.id,
                        imdbId: baseData.imdbId,
                        kitsuId: baseData.kitsuId,
                        type: "movie",
                        isAnime: baseData.isAnime,
                        title: baseData.title,
                        year: baseData.year
                    })
                })];
                return cb({ success: true, data: new MultimediaItem(item) });
            }

            var videos = meta.videos || [];
            item.episodes = videos.filter(function (ep) {
                return ep && ep.season !== 0;
            }).sort(sortEpisodes).map(function (ep) {
                return new Episode({
                    name: trim(ep.name || ep.title || ("S" + ep.season + "E" + ep.episode)),
                    url: buildEpisodePayload(baseData, {
                        season: ep.season || ep.imdbSeason,
                        episode: ep.episode || ep.imdbEpisode
                    }),
                    season: ep.season || ep.imdbSeason,
                    episode: ep.episode || ep.imdbEpisode,
                    posterUrl: ep.thumbnail || undefined,
                    description: trim(ep.overview || ep.description || "")
                });
            });

            cb({ success: true, data: new MultimediaItem(item) });
        }).catch(function (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        });
    }

    function extractMagnets(html) {
        var entries = [];
        var seen = {};
        var re = /href="(magnet:[^"]+)"/gi;
        var match;
        while ((match = re.exec(html))) {
            var magnet = match[1];
            if (!magnet || seen[magnet]) continue;
            seen[magnet] = true;
            var decoded = decodeURIComponent(magnet);
            entries.push({
                url: magnet,
                quality: getQuality(decoded),
                size: extractSize(decoded),
                title: decoded
            });
        }
        return entries;
    }

    function loadTamilMvItem(payload, cb) {
        httpText(payload.url).then(function (html) {
            var h1Match = html.match(/<h1[^>]*>([\s\S]*?)<\/h1>/i);
            var title = cleanHtmlText(h1Match ? h1Match[1] : payload.title || "1TamilMV");
            var posterMatch = html.match(/property="og:image"[^>]*content="([^"]+)"/i);
            var descMatch = html.match(/property="og:description"[^>]*content="([^"]+)"/i);
            var magnets = extractMagnets(html);

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: payload.raw,
                    posterUrl: posterMatch ? posterMatch[1] : undefined,
                    type: payload.type || (isSeriesTitle(title) ? "series" : "movie"),
                    description: descMatch ? cleanHtmlText(descMatch[1]) : undefined,
                    episodes: [new Episode({
                        name: title,
                        url: JSON.stringify({
                            provider: "1tamilmv_direct",
                            title: title,
                            magnets: magnets
                        })
                    })]
                })
            });
        }).catch(function (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        });
    }

    function load(url, cb) {
        var payload = parseJsonSafe(url, null);
        if (!payload) return cb({ success: false, errorCode: "LOAD_ERROR", message: "Invalid payload: " + String(url || "").slice(0, 200) });
        payload.raw = url;

        if (payload.provider === "1tamilmv") return loadTamilMvItem(payload, cb);
        return loadMetaItem(payload, cb);
    }

    function extractHeaderMap(stream) {
        var hints = stream && stream.behaviorHints ? stream.behaviorHints : {};
        var proxy = hints.proxyHeaders && hints.proxyHeaders.request ? hints.proxyHeaders.request : {};
        var headers = hints.headers || {};
        var out = {};
        if (proxy.userAgent || headers["User-Agent"] || headers["user-agent"]) {
            out["User-Agent"] = proxy.userAgent || headers["User-Agent"] || headers["user-agent"];
        }
        if (proxy.Referer || headers.Referer || headers.referer) {
            out.Referer = proxy.Referer || headers.Referer || headers.referer;
        }
        if (proxy.Origin || headers.Origin || headers.origin) {
            out.Origin = proxy.Origin || headers.Origin || headers.origin;
        }
        return out;
    }

    function cleanStreamLabel(text) {
        return trim(String(text || "").replace(/[\r\n]+/g, " ").replace(/[^\x20-\x7E]+/g, " "));
    }

    function pushStream(results, url, source, quality, headers) {
        if (!url) return;
        results.push(new StreamResult({
            url: url,
            quality: quality || 0,
            source: source,
            headers: headers || {}
        }));
    }

    function buildMagnet(stream) {
        var infoHash = stream && stream.infoHash;
        if (!infoHash) return null;
        var params = ["xt=urn:btih:" + encodeURIComponent(infoHash)];
        var fileName = stream.behaviorHints && stream.behaviorHints.filename ? stream.behaviorHints.filename : "";
        if (fileName) params.push("dn=" + encodeURIComponent(fileName));
        var trackers = stream.sources || [];
        for (var i = 0; i < trackers.length; i++) {
            if (trackers[i] && trackers[i].indexOf("tracker:") === 0) {
                params.push("tr=" + encodeURIComponent(trackers[i].substring(8)));
            }
        }
        return "magnet:?" + params.join("&");
    }

    function appendStremioStreams(baseUrl, sourceName, payload, results) {
        var suffix = payload.type === "movie"
            ? "movie/" + encodeURIComponent(payload.imdbId)
            : "series/" + encodeURIComponent(payload.imdbId + ":" + payload.season + ":" + payload.episode);

        return httpJson(baseUrl + "/stream/" + suffix + ".json").then(function (json) {
            var streams = json && json.streams ? json.streams : [];
            for (var i = 0; i < streams.length; i++) {
                var stream = streams[i];
                if (!stream || !stream.url) continue;
                var label = cleanStreamLabel((stream.name || sourceName) + " " + (stream.title || ""));
                pushStream(results, stream.url, "[" + sourceName + "] " + label, getQuality(label), extractHeaderMap(stream));
            }
        }).catch(function (e) {
            log(sourceName + " failed:", e.message);
        });
    }

    function appendNoTorrentStreams(payload, results) {
        var suffix = payload.type === "movie"
            ? "movie/" + encodeURIComponent(payload.imdbId)
            : "series/" + encodeURIComponent(payload.imdbId + ":" + payload.season + ":" + payload.episode);

        return httpJson(NOTORRENT + "/stream/" + suffix + ".json").then(function (json) {
            var streams = json && json.streams ? json.streams : [];
            for (var i = 0; i < streams.length; i++) {
                var stream = streams[i];
                if (!stream || !stream.url) continue;
                var label = cleanStreamLabel(stream.title || "NoTorrent");
                pushStream(results, stream.url, "[NoTorrent] " + label, getQuality(label), {});
            }
        }).catch(function (e) {
            log("NoTorrent failed:", e.message);
        });
    }

    function appendTorrentioStreams(payload, results) {
        var suffix = payload.type === "movie"
            ? "movie/" + encodeURIComponent(payload.imdbId)
            : "series/" + encodeURIComponent(payload.imdbId + ":" + payload.season + ":" + payload.episode);

        return httpJson(TORRENTIO + "/stream/" + suffix + ".json").then(function (json) {
            var streams = json && json.streams ? json.streams : [];
            for (var i = 0; i < streams.length; i++) {
                var stream = streams[i];
                var magnet = buildMagnet(stream);
                var label = cleanStreamLabel(stream && (stream.title || stream.name || ""));
                if (!magnet) continue;
                pushStream(results, magnet, "[Torrentio] " + label, getQuality(label), {});
            }
        }).catch(function (e) {
            log("Torrentio failed:", e.message);
        });
    }

    function extractAniZipEpisodeId(mapping, episodeNumber) {
        var episodes = mapping && mapping.episodes ? mapping.episodes : {};
        var direct = episodes[String(episodeNumber)];
        if (direct && direct.anidbEid) return direct.anidbEid;
        for (var key in episodes) {
            if (!episodes.hasOwnProperty(key)) continue;
            var episode = episodes[key];
            if (!episode) continue;
            if (String(episode.episode) === String(episodeNumber) && episode.anidbEid) return episode.anidbEid;
        }
        return null;
    }

    function appendAnimeToshoStreams(payload, results) {
        if (!payload.isAnime || !payload.kitsuId) return Promise.resolve();
        return httpJson(ANIZIP + "/mappings?kitsu_id=" + encodeURIComponent(payload.kitsuId)).then(function (mapping) {
            var epId = extractAniZipEpisodeId(mapping, payload.episode || 1);
            if (!epId) return;
            return httpJson(ANIMETOSHO + "/json?eid=" + encodeURIComponent(epId)).then(function (items) {
                items = Array.isArray(items) ? items : [];
                items.filter(function (item) {
                    return item && item.magnet_uri && (item.seeders || 0) >= 10;
                }).sort(function (a, b) {
                    return (b.seeders || 0) - (a.seeders || 0);
                }).slice(0, 12).forEach(function (item) {
                    var title = cleanStreamLabel(item.title || "AnimeTosho");
                    var label = "[AnimeTosho] " + title;
                    if (item.total_size) label += " [" + formatBytes(parseInt(item.total_size, 10)) + "]";
                    pushStream(results, item.magnet_uri, label, getQuality(title), {});
                });
            });
        }).catch(function (e) {
            log("AnimeTosho failed:", e.message);
        });
    }

    function selectTamilMvMatch(items, payload) {
        var target = normalizeTitle(payload.title);
        var best = null;
        var bestScore = 0;
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            var score = wordOverlap(target, item.title);
            if (payload.year && item.title.indexOf(payload.year) !== -1) score += 0.3;
            if (payload.type === "series" && item.type === "series") score += 0.2;
            if (score > bestScore) {
                best = item;
                bestScore = score;
            }
        }
        return bestScore >= 0.35 ? best : null;
    }

    function appendTamilMvStreams(payload, results) {
        if (!payload.title) return Promise.resolve();
        return fetchTamilMvSearch(payload.title).then(function (items) {
            var match = selectTamilMvMatch(items, payload);
            if (!match) return;
            return httpText(match.url).then(function (body) {
                var magnets = extractMagnets(body || "");
                for (var i = 0; i < magnets.length; i++) {
                    var entry = magnets[i];
                    var label = "[1TamilMV] " + cleanStreamLabel(match.title);
                    if (entry.size) label += " [" + entry.size + "]";
                    pushStream(results, entry.url, label, entry.quality || getQuality(entry.title), {});
                }
            });
        }).catch(function (e) {
            log("1TamilMV provider failed:", e.message);
        });
    }

    function appendDirectTamilMvPayload(payload, results) {
        var magnets = payload.magnets || [];
        for (var i = 0; i < magnets.length; i++) {
            var entry = magnets[i];
            var label = "[1TamilMV] " + cleanStreamLabel(payload.title || "1TamilMV");
            if (entry.size) label += " [" + entry.size + "]";
            pushStream(results, entry.url, label, entry.quality || getQuality(entry.title), {});
        }
        return Promise.resolve();
    }

    function dedupeStreams(results) {
        return uniqueBy(results, function (item) { return item.url + "|" + item.source; });
    }

    function loadStreams(url, cb) {
        var payload = parseJsonSafe(url, null);
        if (!payload) return cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid stream payload: " + String(url || "").slice(0, 200) });

        var results = [];

        if (payload.provider === "1tamilmv_direct") {
            appendDirectTamilMvPayload(payload, results);
            return cb({ success: true, data: dedupeStreams(results) });
        }

        var jobs = [
            appendStremioStreams(STREAMVIX, "StreamVix", payload, results),
            appendStremioStreams(WEBSTREAMR, "WebStreamr", payload, results),
            appendNoTorrentStreams(payload, results),
            appendTorrentioStreams(payload, results),
            appendTamilMvStreams(payload, results)
        ];

        if (payload.isAnime) jobs.push(appendAnimeToshoStreams(payload, results));

        settled(jobs).then(function () {
            cb({ success: true, data: dedupeStreams(results) });
        }).catch(function (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        });
    }

    async function gethome(query, cb) {
        if (typeof query === "function") return getHome(query);
        if (typeof cb === "function") return getHome(cb);
        return getHome(function () {});
    }

    async function loadstreams(url, cb) {
        return loadStreams(url || "", cb);
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
    globalThis.gethome = gethome;
    globalThis.loadstreams = loadstreams;

if (typeof module !== "undefined" && module.exports) {
    module.exports = {
        getHome: getHome,
        gethome: gethome,
        search: search,
        load: load,
        loadStreams: loadStreams,
        loadstreams: loadstreams
    };
}
})();
