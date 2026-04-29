(function() {
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_BASE = "https://api.themoviedb.org/3";
    var TMDB_FALLBACK = "https://orange-voice-abcf.phisher16.workers.dev";
    var TMDB_IMG = "https://image.tmdb.org/t/p/original";
    var PULP_API = String((manifest && manifest.baseUrl) || "https://api.pulp.watch/v1").replace(/\/+$/, "");
    var PULP_REFERER = "https://tv.pulp.watch/";
    var PULP_PROVIDER = "02moviedownloader";
    var UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";

    function httpHeaders(extra) {
        return Object.assign({
            "User-Agent": UA,
            "Accept": "*/*"
        }, extra || {});
    }

    function parseJsonSafe(text, fallback) {
        try {
            return JSON.parse(String(text || ""));
        } catch (_) {
            return fallback;
        }
    }

    async function fetchJson(url, headers) {
        var res = await http_get(url, headers || httpHeaders());
        return parseJsonSafe(res && res.body, null);
    }

    async function fetchTmdb(path) {
        var directUrl = TMDB_BASE + path + (path.indexOf("?") === -1 ? "?" : "&") + "api_key=" + TMDB_API_KEY;
        var fallbackUrl = TMDB_FALLBACK + path + (path.indexOf("?") === -1 ? "?" : "&") + "api_key=" + TMDB_API_KEY;
        var json = null;
        try {
            json = await fetchJson(directUrl, httpHeaders({ "Accept": "application/json" }));
        } catch (_) {}
        if (json) return json;
        try {
            return await fetchJson(fallbackUrl, httpHeaders({ "Accept": "application/json" }));
        } catch (_) {
            return null;
        }
    }

    function decodeHtml(text) {
        return String(text || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'");
    }

    function normalizeTitle(text) {
        return decodeHtml(String(text || ""))
            .toLowerCase()
            .replace(/&/g, " and ")
            .replace(/['"`]/g, "")
            .replace(/[^a-z0-9]+/g, " ")
            .replace(/\s+/g, " ")
            .trim();
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        (list || []).forEach(function(item) {
            var key = keyFn(item);
            if (!key || seen[key]) return;
            seen[key] = true;
            out.push(item);
        });
        return out;
    }

    function firstYear(item) {
        return Number(String(item && (item.release_date || item.first_air_date || "")).slice(0, 4)) || undefined;
    }

    function mediaType(item) {
        return item && item.media_type === "tv" ? "series" : "movie";
    }

    function toPoster(path) {
        return path ? TMDB_IMG + path : undefined;
    }

    function qualityFromText(value) {
        var text = String(value || "").toLowerCase();
        if (/\b4320p\b|\b8k\b/.test(text)) return 4320;
        if (/\b2160p\b|\b4k\b|\buhd\b/.test(text)) return 2160;
        if (/\b1440p\b|\b2k\b|\bqhd\b/.test(text)) return 1440;
        if (/\b1080p\b|\bfhd\b|\bfull\s*hd\b/.test(text)) return 1080;
        if (/\b720p\b|\bhd\b/.test(text)) return 720;
        if (/\b576p\b/.test(text)) return 576;
        if (/\b480p\b|\bsd\b/.test(text)) return 480;
        if (/\b360p\b/.test(text)) return 360;
        if (/\b240p\b/.test(text)) return 240;
        return 0;
    }

    function subtitleTracks(items) {
        return uniqueBy((items || []).map(function(item) {
            var url = String(item && item.url || "").trim();
            if (!url) return null;
            var label = String(item && (item.label || item.language) || "Unknown").trim() || "Unknown";
            return { url: url, name: label };
        }).filter(Boolean), function(item) {
            return item.url;
        });
    }

    function streamPayload(item, season, episode) {
        return JSON.stringify({
            tmdbId: item.id,
            mediaType: item.media_type,
            title: item.title || item.name || "",
            year: firstYear(item),
            season: season || 1,
            episode: episode || 1,
            isMovie: item.media_type !== "tv"
        });
    }

    async function tmdbDetails(id, mediaTypeName) {
        return fetchTmdb("/" + mediaTypeName + "/" + id + "?append_to_response=credits,recommendations");
    }

    async function getHome(cb) {
        try {
            var movieJson = await fetchJson(
                TMDB_BASE + "/trending/movie/week?api_key=" + TMDB_API_KEY,
                httpHeaders({ "Accept": "application/json" })
            ).catch(function() { return null; });
            var tvJson = await fetchJson(
                TMDB_BASE + "/trending/tv/week?api_key=" + TMDB_API_KEY,
                httpHeaders({ "Accept": "application/json" })
            ).catch(function() { return null; });
            if (!movieJson) movieJson = await fetchTmdb("/trending/movie/week");
            if (!tvJson) tvJson = await fetchTmdb("/trending/tv/week");

            function mapItems(results) {
                return (results || []).slice(0, 20).map(function(item) {
                    return new MultimediaItem({
                        title: item.title || item.name || "Unknown",
                        url: JSON.stringify({ mode: "tmdb", tmdbId: item.id, mediaType: item.media_type || (item.title ? "movie" : "tv") }),
                        posterUrl: toPoster(item.poster_path),
                        bannerUrl: toPoster(item.backdrop_path),
                        type: mediaType(item)
                    });
                });
            }

            cb({
                success: true,
                data: {
                    "Trending Movies": mapItems(movieJson && movieJson.results),
                    "Trending Series": mapItems(tvJson && tvJson.results)
                }
            });
        } catch (error) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var json = await fetchTmdb("/search/multi?query=" + encodeURIComponent(query || ""));
            var q = normalizeTitle(query);
            var items = uniqueBy((json && json.results || []).filter(function(item) {
                return item && (item.media_type === "movie" || item.media_type === "tv");
            }).sort(function(a, b) {
                var at = normalizeTitle(a.title || a.name || "");
                var bt = normalizeTitle(b.title || b.name || "");
                var as = at === q ? 2 : at.indexOf(q) !== -1 ? 1 : 0;
                var bs = bt === q ? 2 : bt.indexOf(q) !== -1 ? 1 : 0;
                if (bs !== as) return bs - as;
                return Number(b.popularity || 0) - Number(a.popularity || 0);
            }).map(function(item) {
                return new MultimediaItem({
                    title: item.title || item.name || "Unknown",
                    url: JSON.stringify({ mode: "tmdb", tmdbId: item.id, mediaType: item.media_type }),
                    posterUrl: toPoster(item.poster_path),
                    bannerUrl: toPoster(item.backdrop_path),
                    type: mediaType(item),
                    year: firstYear(item)
                });
            }), function(item) {
                return item.url;
            });
            cb({ success: true, data: items });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var payload = parseJsonSafe(url, null);
            if (!payload || payload.mode !== "tmdb" || !payload.tmdbId || !payload.mediaType) {
                cb({ success: false, errorCode: "LOAD_ERROR", message: "Invalid load payload" });
                return;
            }

            var type = payload.mediaType === "tv" ? "tv" : "movie";
            var details = await tmdbDetails(payload.tmdbId, type);
            if (!details) {
                cb({ success: false, errorCode: "LOAD_ERROR", message: "Failed to fetch TMDB details" });
                return;
            }

            var item = new MultimediaItem({
                title: details.title || details.name || "Unknown",
                url: url,
                posterUrl: toPoster(details.poster_path),
                bannerUrl: toPoster(details.backdrop_path),
                description: details.overview || "",
                type: type === "tv" ? "series" : "movie",
                year: firstYear(details),
                score: Number(details.vote_average || 0) || undefined,
                cast: (details.credits && details.credits.cast || []).slice(0, 20).map(function(person) {
                    return new Actor({
                        name: person.name || "",
                        role: person.character || "",
                        image: toPoster(person.profile_path)
                    });
                }).filter(function(actor) { return actor.name; }),
                recommendations: (details.recommendations && details.recommendations.results || []).slice(0, 20).map(function(rec) {
                    return new MultimediaItem({
                        title: rec.title || rec.name || "Unknown",
                        url: JSON.stringify({ mode: "tmdb", tmdbId: rec.id, mediaType: rec.media_type || type }),
                        posterUrl: toPoster(rec.poster_path),
                        bannerUrl: toPoster(rec.backdrop_path),
                        type: rec.media_type === "tv" || (type === "tv" && !rec.title) ? "series" : "movie",
                        year: firstYear(rec)
                    });
                })
            });

            if (type === "movie") {
                item.episodes = [
                    new Episode({
                        name: "Movie",
                        season: 1,
                        episode: 1,
                        posterUrl: item.posterUrl,
                        description: item.description,
                        url: streamPayload({ id: payload.tmdbId, media_type: type, title: item.title, release_date: String(item.year || "") }, 1, 1)
                    })
                ];
            } else {
                var seasonCount = Number(details.number_of_seasons || 0);
                var episodes = [];
                for (var season = 1; season <= seasonCount; season++) {
                    var seasonJson = await fetchTmdb("/tv/" + payload.tmdbId + "/season/" + season).catch(function() { return null; });
                    (seasonJson && seasonJson.episodes || []).forEach(function(ep) {
                        episodes.push(new Episode({
                            name: ep.name || ("Episode " + ep.episode_number),
                            season: season,
                            episode: ep.episode_number,
                            posterUrl: toPoster(ep.still_path) || item.posterUrl,
                            description: ep.overview || "",
                            airDate: ep.air_date || undefined,
                            score: Number(ep.vote_average || 0) || undefined,
                            url: streamPayload({ id: payload.tmdbId, media_type: "tv", name: item.title, first_air_date: String(item.year || "") }, season, ep.episode_number)
                        }));
                    });
                }
                item.episodes = episodes;
            }

            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parseJsonSafe(url, null);
            if (!payload || !payload.tmdbId || !payload.mediaType) {
                cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid stream payload" });
                return;
            }

            var apiUrl = payload.mediaType === "tv"
                ? PULP_API + "/tv/" + payload.tmdbId + "/seasons/" + (payload.season || 1) + "/episodes/" + (payload.episode || 1) + "?provider=" + PULP_PROVIDER
                : PULP_API + "/movies/" + payload.tmdbId + "?provider=" + PULP_PROVIDER;

            var json = await fetchJson(apiUrl, httpHeaders({
                "Referer": PULP_REFERER,
                "Origin": "https://tv.pulp.watch",
                "Accept": "application/json"
            }));
            if (!json) {
                cb({ success: true, data: [] });
                return;
            }

            var subtitles = subtitleTracks(json.subtitles || []);
            var streams = uniqueBy((json.sources || []).map(function(source) {
                var sourceUrl = String(source && source.url || "").trim();
                if (!sourceUrl) return null;
                var provider = source && source.provider || {};
                var providerName = String(provider.name || provider.id || "Pulp").trim() || "Pulp";
                var headers = {};
                Object.keys(source && source.headers || {}).forEach(function(key) {
                    var value = String(source.headers[key] || "").trim();
                    if (value) headers[key] = value;
                });
                var qualityHint = [source && source.quality, source && source.type, sourceUrl].filter(Boolean).join(" ");
                var stream = new StreamResult({
                    url: sourceUrl,
                    source: "Pulp [" + providerName + "]",
                    quality: qualityFromText(qualityHint) || undefined,
                    headers: headers
                });
                if (subtitles.length) stream.subtitles = subtitles;
                return stream;
            }).filter(Boolean), function(stream) {
                return stream.url + "|" + JSON.stringify(stream.headers || {});
            }).sort(function(a, b) {
                return Number(b.quality || 0) - Number(a.quality || 0);
            });

            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
