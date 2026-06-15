(function() {
    // ========== GA Tracker ==========
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

    const SessionTracker = {
        clientId: null,
        init: function() { this.clientId = this.generateUuid(); },
        generateUuid: function() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random() * 16 | 0;
                return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
        }
    };
    SessionTracker.init();

    const Analytics = {
        clientId: null,
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        queue: [],
        init: function() { this.clientId = SessionTracker.clientId; },
        logEvent: function(eventName, parameters) {
            if (!this.measurementId || !this.apiSecret) return;
            this.queue.push({ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) });
            this.flushQueue();
        },
        flushQueue: function() {
            if (this.queue.length === 0) return;
            var events = this.queue.splice(0);
            try {
                http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
            } catch (e) { /* silently skip */ }
        }
    };
    Analytics.init();

    // ========== Config ==========
    var BASE_URL = typeof manifest !== "undefined" && manifest && manifest.baseUrl ? manifest.baseUrl : "https://anikage.cc";
    var PROXY_URL = "https://prox.anikage.cc";

    var HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
        "Referer": BASE_URL + "/"
    };

    // ========== Utility Functions ==========
    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function stripHtml(str) {
        return String(str || "").replace(/<[^>]+>/g, "").trim();
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            try {
                var text = String(value || "").replace(/^'+|'+$/g, "").replace(/^"+|"+$/g, "");
                return JSON.parse(text);
            } catch (_) {
                return fallback !== undefined ? fallback : {};
            }
        }
    }

    function uniqueBy(list, keyFn) {
        var out = [], seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var key = keyFn(list[i]);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(list[i]);
        }
        return out;
    }

    function getQualityFromName(quality) {
        if (!quality) return 1080;
        var q = String(quality).toLowerCase();
        if (q.indexOf("1080") !== -1) return 1080;
        if (q.indexOf("720") !== -1) return 720;
        if (q.indexOf("480") !== -1) return 480;
        if (q.indexOf("360") !== -1) return 360;
        return 1080;
    }

    function getStatusFromString(status) {
        if (status === "FINISHED") return "completed";
        if (status === "RELEASING") return "ongoing";
        return null;
    }

    function getTvType(format, type) {
        var ft = String(format || "").toUpperCase();
        if (ft === "MOVIE" || ft === "SPECIAL") return "movie";
        if (ft === "OVA" || ft === "ONA") return "other";
        return "series";
    }

    async function apiGet(url) {
        try {
            var res = await http_get(url, HEADERS);
            return parseJsonSafe(res && (res.body || res.text), {});
        } catch (_) {
            return {};
        }
    }

    // ========== Categories ==========
    var CATEGORIES = [
        [BASE_URL + "/api/media/anime/advanced-search?sort=trending&per_page=25&include_adult=true&page=", "Trending", false],
        [BASE_URL + "/api/media/anime/advanced-search?sort=popularity&per_page=25&page=", "Popular", false],
        [BASE_URL + "/api/media/anime/advanced-search?sort=popularity&per_page=25&include_adult=true&formats=MOVIE&page=", "Popular Movies", false],
        [BASE_URL + "/api/media/anime/advanced-search?sort=popularity&per_page=25&include_adult=true&formats=OVA&page=", "Popular OVAs", true],
        [BASE_URL + "/api/media/anime/advanced-search?sort=updated&per_page=25&page=", "Latest Updates", false]
    ];

    // ========== Data Parsing ==========
    function animeResultToItem(result, extra) {
        var title = (result.title && (result.title.english || result.title.romaji)) || "Unknown";
        var poster = "";
        if (result.coverImage) {
            poster = result.coverImage.extraLarge || result.coverImage.large || result.coverImage.medium || "";
        }
        var banner = (extra && extra.bannerImage) || result.bannerImage || poster;
        var logo = (extra && extra.clearLogo) || "";
        var type = getTvType(result.format, result.type);
        return new MultimediaItem({
            title: title,
            url: BASE_URL + "/api/media/anime/" + result.slug,
            posterUrl: poster,
            bannerUrl: banner,
            logoUrl: logo,
            type: type,
            year: result.year || 0,
            score: result.averageScore ? result.averageScore / 10 : 0,
            headers: HEADERS
        });
    }

    function parseAnimeListResponse(data, fetchDetails) {
        var resp = parseJsonSafe(data, {});
        var results = resp.results || [];
        return results.map(function(r) { return animeResultToItem(r); });
    }

    function mergeDetailExtra(item, detailData) {
        var animeInfo = detailData.anime || {};
        if (animeInfo.bannerImage || animeInfo.clearLogo) {
            var slug = String(item.url || "").split("/").pop();
            // Create new MultimediaItem with extra fields merged
            return new MultimediaItem({
                title: item.title,
                url: item.url,
                posterUrl: item.posterUrl,
                bannerUrl: animeInfo.bannerImage || item.bannerUrl,
                logoUrl: animeInfo.clearLogo || "",
                type: item.type,
                year: item.year,
                score: item.score,
                tags: animeInfo.genres || [],
                description: animeInfo.description ? stripHtml(animeInfo.description) : "",
                headers: HEADERS
            });
        }
        return item;
    }

    // ========== Runtime Functions ==========
    async function getHome(cb) {
        try {
            var pageData = {};
            var requests = CATEGORIES.map(function(cat) {
                return apiGet(cat[0] + "1").then(async function(data) {
                    var items = parseAnimeListResponse(data, cat[2]);
                    // For categories that need detail enrichment (OVAs), fetch banner/logo in parallel
                    if (cat[2] && items.length > 0) {
                        var detailRequests = items.map(function(item) {
                            var slug = String(item.url || "").split("/").pop();
                            return apiGet(BASE_URL + "/api/media/anime/" + slug).then(function(info) {
                                return mergeDetailExtra(item, info);
                            }).catch(function() { return item; });
                        });
                        items = await Promise.all(detailRequests);
                        // Also deduplicate card-style duplicates for OVAs
                        items = uniqueBy(items, function(i) { return i.url; });
                    }
                    pageData[cat[1]] = items;
                });
            });
            await Promise.all(requests);
            Analytics.logEvent('anikage_home', {});
            cb({ success: true, data: pageData });
        } catch (e) {
            cb({ success: false, errorCode: "GET_HOME_ERROR", message: e.stack });
        }
    }

    async function search(query, cb) {
        try {
            var url = BASE_URL + "/api/media/anime/advanced-search?per_page=25&page=1&query=" + encodeURIComponent(query);
            var data = await apiGet(url);
            var results = parseAnimeListResponse(data);
            Analytics.logEvent('anikage_search', { query: query });
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.stack });
        }
    }

    async function load(url, cb) {
        try {
            var slug = url.split("/").pop();

            // Fetch episodes and info in parallel
            var episodesUrl = BASE_URL + "/api/media/anime/" + slug + "/episodes";
            var infoUrl = BASE_URL + "/api/media/anime/" + slug;

            var results = await Promise.all([
                apiGet(episodesUrl),
                apiGet(infoUrl)
            ]);

            var episodesData = results[0];
            var infoData = results[1];
            var animeInfo = infoData.anime || {};

            var title = (animeInfo.title && (animeInfo.title.english || animeInfo.title.romaji)) || "Unknown";
            var type = getTvType(animeInfo.format, animeInfo.type);

            var poster = "";
            if (animeInfo.coverImage) {
                poster = animeInfo.coverImage.extraLarge || animeInfo.coverImage.large || animeInfo.coverImage.medium || "";
            }

            var description = stripHtml(animeInfo.description || "");
            if (!description) {
                description = "Format: " + (animeInfo.format || "Unknown");
            }

            var status = getStatusFromString(animeInfo.status);
            var genres = animeInfo.genres || [];
            var year = animeInfo.year || 0;

            // Build episodes with single iteration (sub + dub together)
            var epList = Array.isArray(episodesData) ? episodesData : [];
            epList.sort(function(a, b) { return (a.number || 0) - (b.number || 0); });
            var allEpisodes = [];
            epList.forEach(function(ep) {
                var epTitle = ep.title || "Episode " + ep.number;
                // Sub episode
                allEpisodes.push(new Episode({
                    name: epTitle,
                    url: BASE_URL + "/play/" + slug + "/" + ep.number,
                    season: 1,
                    episode: ep.number,
                    description: ep.description || "",
                    posterUrl: ep.img || poster,
                    dubStatus: "sub",
                    headers: HEADERS
                }));
                // Dub episode
                allEpisodes.push(new Episode({
                    name: epTitle,
                    url: BASE_URL + "/play/" + slug + "/" + ep.number + "?dub=true",
                    season: 1,
                    episode: ep.number,
                    description: ep.description || "",
                    posterUrl: ep.img || poster,
                    dubStatus: "dub",
                    headers: HEADERS
                }));
            });

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: poster,
                type: type,
                bannerUrl: animeInfo.bannerImage || "",
                description: description,
                year: year,
                score: animeInfo.averageScore ? animeInfo.averageScore / 10 : 0,
                status: status,
                tags: genres,
                episodes: allEpisodes,
                headers: HEADERS
            });

            Analytics.logEvent('anikage_load', {});
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.stack });
        }
    }

    function parseEpisodeUrl(url) {
        // URL format: {BASE_URL}/play/{slug}/{epNumber}?dub=true
        var slug = "";
        var epNumber = 1;
        var isDub = false;
        try {
            var parts = String(url || "").split("/");
            // Find "play" in path
            var playIdx = -1;
            for (var i = 0; i < parts.length; i++) {
                if (parts[i] === "play") { playIdx = i; break; }
            }
            if (playIdx !== -1) {
                slug = parts[playIdx + 1] || "";
                epNumber = parseInt(parts[playIdx + 2], 10) || 1;
            }
            isDub = url.indexOf("dub=true") !== -1;
        } catch (_) {}
        return { slug: slug, epNumber: epNumber, isDub: isDub };
    }

    async function loadStreams(url, cb) {
        try {
            var epInfo = parseEpisodeUrl(url);
            var slug = epInfo.slug;
            var epNumber = epInfo.epNumber;
            var isDub = epInfo.isDub;

            var lang = isDub ? "dub" : "sub";

            // Fetch available servers
            var serversUrl = BASE_URL + "/api/media/anime/" + slug + "/episodes/" + epNumber + "/servers?lang=" + lang;
            var serversData = await apiGet(serversUrl);

            var providers = [];
            if (Array.isArray(serversData) && serversData.length > 0) {
                providers = serversData.map(function(s) { return s.id; });
            } else {
                providers = ["megg", "miko", "anya", "verse", "neko"];
            }

            // === PARALLEL provider fetching (matching Kotlin coroutineScope + async/awaitAll) ===
            var providerResults = await Promise.all(providers.map(async function(provider) {
                var providerStreams = [];
                try {
                    var sourceUrl = BASE_URL + "/api/media/anime/" + slug + "/episodes/" + epNumber + "/sources?lang=" + lang + "&provider=" + provider;
                    var sourceData = await apiGet(sourceUrl);

                    var sources = sourceData.sources || [];

                    // SubType matching Kotlin: if lang=="sub", determine Softsub/Hardsub; dub gets empty
                    var subType = "";
                    if (lang === "sub") {
                        var subtitles = sourceData.subtitles || [];
                        subType = subtitles.length > 0 ? "Softsub" : "Hardsub";
                    }
                    var baseName = "Anikage " + provider.charAt(0).toUpperCase() + provider.slice(1) + " " + subType;
                    baseName = baseName.trim();

                    // Process each source for this provider
                    for (var s = 0; s < sources.length; s++) {
                        var src = sources[s];
                        // Skip embed-type sources (not direct video)
                        if (src.type === "embed") continue;

                        var isM3u8 = src.isM3U8 === true;
                        var videoUrl = PROXY_URL + (isM3u8 ? "/m3u8/" : "/stream/") + src.url;

                        // Quality name matching Kotlin: capitalize first letter e.g. "Auto", "Hls", "HD-1"
                        var qualName = src.quality ? src.quality.charAt(0).toUpperCase() + src.quality.slice(1) : "";
                        var nameStr = baseName + (qualName ? " " + qualName : "");

                        providerStreams.push(new StreamResult({
                            url: videoUrl,
                            source: nameStr,
                            quality: getQualityFromName(src.quality),
                            headers: Object.assign({}, HEADERS)  // full headers: User-Agent + Referer
                        }));
                    }
                } catch (_) {
                    // Silently skip failed providers (matching Kotlin)
                }
                return providerStreams;
            }));

            // Flatten results from all providers
            var allStreams = [];
            for (var i = 0; i < providerResults.length; i++) {
                allStreams = allStreams.concat(providerResults[i]);
            }

            Analytics.logEvent('anikage_loadstreams', { slug: slug, ep: epNumber });
            cb({ success: true, data: allStreams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.stack });
        }
    }

    // ========== Exports ==========
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
