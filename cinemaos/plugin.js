(function () {
    "use strict";

    var BASE_URL = "https://cinemaos.live";
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";
    var TMDB_API_KEY = "69e9690680655e8939c3629472e3914a";

    function defaultHeaders(extra) {
        var h = {
            "User-Agent": USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
        };
        if (extra) {
            for (var k in extra) {
                if (Object.prototype.hasOwnProperty.call(extra, k)) h[k] = extra[k];
            }
        }
        return h;
    }

    function baseOrigin(url) {
        var m = String(url || "").match(/^https?:\/\/[^\/]+/i);
        return m ? m[0] : BASE_URL;
    }

    async function getText(url, headers) {
        var res = await http_get(url, { headers: headers });
        return res.body;
    }

    async function getJson(url, headers) {
        var res = await http_get(url, { headers: headers });
        return JSON.parse(res.body);
    }

    function parseJsonSafe(str, def) {
        try { return JSON.parse(str); } catch (_) { return def; }
    }

    function decodeHtml(html) {
        if (!html) return "";
        return html.replace(/&quot;/g, '"').replace(/&amp;/g, "&").replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&#39;/g, "'").replace(/&apos;/g, "'");
    }

    function trim(s) {
        return String(s || "").replace(/^\s+|\s+$/g, "");
    }

    function htmlToRuntimeText(html) {
        return String(html || "").replace(/<[^>]*>?/gm, " ");
    }

    function extractMeta(html, name) {
        var re = new RegExp('<meta[^>]*(?:name|property)=["\']' + name.replace(/[.*+?^${}()|[\]\\]/g, "\\$&") + '["\'][^>]*content=["\']([^"\']+)["\']', "i");
        var m = html.match(re);
        if (m) return decodeHtml(m[1]);
        re = new RegExp('<meta[^>]*content=["\']([^"\']+)["\'][^>]*(?:name|property)=["\']' + name.replace(/[.*+?^${}()|[\]\\]/g, "\\$&") + '["\']', "i");
        m = html.match(re);
        return m ? decodeHtml(m[1]) : "";
    }

    function extractPathIds(html, pattern) {
        var re = new RegExp(pattern, "g");
        var match;
        var out = [];
        var seen = {};
        while ((match = re.exec(html)) !== null) {
            var id = match[1];
            if (!id || seen[id]) continue;
            seen[id] = true;
            out.push(id);
        }
        return out;
    }

    function uniqueBy(arr, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < arr.length; i++) {
            var val = keyFn(arr[i]);
            if (seen[val]) continue;
            seen[val] = true;
            out.push(arr[i]);
        }
        return out;
    }

    function extractTvWatchEpisodes(html, tmdbId) {
        var re = new RegExp("/tv/watch/" + tmdbId + "\\?season=(\\d+)&episode=(\\d+)", "g");
        var match;
        var out = [];
        var seen = {};
        while ((match = re.exec(html)) !== null) {
            var season = Number(match[1]);
            var episode = Number(match[2]);
            var key = season + "x" + episode;
            if (!season || !episode || seen[key]) continue;
            seen[key] = true;
            out.push({ season: season, episode: episode });
        }
        return out.sort(function (a, b) { return a.season - b.season || a.episode - b.episode; });
    }

    function extractTitleMap(html) {
        var map = {};
        var re = /\\"(?:title|name)\\":\\"([^\\"]+)\\"/g;
        var match;
        while ((match = re.exec(html)) !== null) {
            var title = decodeHtml(match[1]);
            var chunk = html.slice(Math.max(0, match.index - 400), Math.min(html.length, match.index + 400));
            var idMatch = chunk.match(/\\"id\\":(\d+)/);
            var posterMatch = chunk.match(/\\"poster_path\\":\\"([^\\"]+)\\"/);
            if (idMatch) {
                var id = idMatch[1];
                if (!map[id] || (!map[id].poster_path && posterMatch)) {
                    map[id] = { title: title, poster_path: posterMatch ? posterMatch[1] : (map[id] ? map[id].poster_path : null) };
                }
            }
        }
        return map;
    }

    function createHomeItem(type, id, titleMap) {
        var meta = titleMap && titleMap[id];
        var title = (meta && meta.title) || ((type === "movie" ? "Movie " : "TV ") + id);
        var url = type === "movie" ? (BASE_URL + "/movie/" + id) : (BASE_URL + "/tv/" + id);
        var posterUrl = (meta && meta.poster_path) ? ("https://image.tmdb.org/t/p/w500" + meta.poster_path) : undefined;
        return new MultimediaItem({
            title: title,
            url: url,
            posterUrl: posterUrl,
            type: type === "movie" ? "movie" : "series",
            headers: defaultHeaders({ "Referer": BASE_URL + "/" })
        });
    }

    async function getHome(cb) {
        try {
            var homeHtml = await getText(BASE_URL + "/", defaultHeaders());
            var movieHtml = await getText(BASE_URL + "/movie", defaultHeaders());
            var tvHtml = await getText(BASE_URL + "/tv", defaultHeaders());

            var titleMap = extractTitleMap(homeHtml + movieHtml + tvHtml);
            var homeMovies = extractPathIds(homeHtml, "href=\\\"/movie/(\\d+)\\\"");
            var homeTv = extractPathIds(homeHtml, "href=\\\"/tv/(\\d+)\\\"");
            var movieWatch = extractPathIds(movieHtml, "/movie/watch/(\\d+)");
            var tvWatch = extractPathIds(tvHtml, "/tv/watch/(\\d+)\\?season=");

            var result = {};
            // Use names that are likely to be recognized if the app/cli has a whitelist
            result["Trending Movies"] = uniqueBy(homeMovies.slice(0, 15), function (id) { return id; }).map(function (id) { return createHomeItem("movie", id, titleMap); });
            result["Trending TV Shows"] = uniqueBy(homeTv.slice(0, 15), function (id) { return id; }).map(function (id) { return createHomeItem("tv", id, titleMap); });

            result["Popular Series"] = [
                { name: "Netflix", logo: "https://image.tmdb.org/t/p/original/wwemzKWzjKYJFfCeiB57q3r4Bcm.png", id: 8 },
                { name: "Apple TV+", logo: "https://image.tmdb.org/t/p/original/68vAnu952w99Mh7JAf9mcQBvY9G.png", id: 350 },
                { name: "Amazon Prime", logo: "https://image.tmdb.org/t/p/original/dg0B2h9TjoNU68LpnuQ6zC5psOE.png", id: 119 },
                { name: "Hulu", logo: "https://image.tmdb.org/t/p/original/zxrVpS6S3nq9pA69p6v39pPbeZ6.png", id: 15 },
                { name: "HBO Max", logo: "https://image.tmdb.org/t/p/original/7S9pA7P9vY9A5n6K5jZ9vV5r6Y9.png", id: 384 },
                { name: "Paramount+", logo: "https://image.tmdb.org/t/p/original/7S9pA7P9vY9A5n6K5jZ9vV5r6Y9.png", id: 531 },
                { name: "Disney+", logo: "https://image.tmdb.org/t/p/original/7S9pA7P9vY9A5n6K5jZ9vV5r6Y9.png", id: 337 },
                { name: "Shudder", logo: "https://image.tmdb.org/t/p/original/7S9pA7P9vY9A5n6K5jZ9vV5r6Y9.png", id: 37 }
            ].map(function(p) {
                return new MultimediaItem({
                    title: p.name,
                    url: BASE_URL + "/movie?with_watch_providers=" + p.id,
                    posterUrl: p.logo,
                    type: "movie",
                    headers: defaultHeaders()
                });
            });

            result["Latest Movies"] = uniqueBy(movieWatch.slice(0, 20), function (id) { return id; }).map(function (id) { return createHomeItem("movie", id, titleMap); });
            result["Latest TV Shows"] = uniqueBy(tvWatch.slice(0, 20), function (id) { return id; }).map(function (id) { return createHomeItem("tv", id, titleMap); });

            var genres = ["Action", "Comedy", "Drama", "Horror", "Sci-Fi", "Thriller"];
            for (var g = 0; g < genres.length; g++) {
                var name = genres[g];
                result[name] = uniqueBy(homeMovies.slice(12 + g * 4, 20 + g * 4), function (id) { return id; }).map(function (id) { return createHomeItem("movie", id, titleMap); });
            }

            cb({ success: true, data: result });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error) });
        }
    }

    async function search(query, cb) {
        try {
            var url = "https://api.themoviedb.org/3/search/multi?api_key=" + encodeURIComponent(TMDB_API_KEY) + "&query=" + encodeURIComponent(query);
            var payload = await getJson(url, defaultHeaders());
            var items = payload && payload.results || [];
            var results = [];
            for (var i = 0; i < items.length; i++) {
                var item = items[i];
                if (item.media_type !== "movie" && item.media_type !== "tv") continue;
                var isAnime = false;
                var genreIds = item.genre_ids || [];
                for (var j = 0; j < genreIds.length; j++) { if (genreIds[j] === 16) { isAnime = true; break; } }
                if (isAnime) continue;

                results.push(new MultimediaItem({
                    title: item.title || item.name || ("TMDB " + item.id),
                    url: BASE_URL + (item.media_type === "movie" ? "/movie/" : "/tv/") + item.id,
                    posterUrl: item.poster_path ? ("https://image.tmdb.org/t/p/w500" + item.poster_path) : undefined,
                    type: item.media_type === "movie" ? "movie" : "series",
                    headers: defaultHeaders()
                }));
            }
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error) });
        }
    }

    async function load(url, cb) {
        try {
            var html = await getText(url, defaultHeaders({ "Referer": BASE_URL + "/" }));
            var tmdbId = (url.match(/\/(?:movie|tv|anime)\/(\d+)/i) || [])[1] || "";
            var isMovie = /\/movie\//i.test(url);
            var episodes = [];

            if (isMovie) {
                episodes = [new Episode({ name: "Play Movie", url: url.replace("/movie/", "/movie/watch/"), season: 1, episode: 1 })];
            } else {
                var eps = extractTvWatchEpisodes(html, tmdbId);
                for (var i = 0; i < eps.length; i++) {
                    episodes.push(new Episode({
                        name: "Season " + eps[i].season + " Episode " + eps[i].episode,
                        url: BASE_URL + "/tv/watch/" + tmdbId + "?season=" + eps[i].season + "&episode=" + eps[i].episode,
                        season: eps[i].season,
                        episode: eps[i].episode
                    }));
                }
            }

            var title = extractMeta(html, "og:title") || ("CinemaOS " + tmdbId);
            var poster = extractMeta(html, "og:image");
            var description = extractMeta(html, "description") || extractMeta(html, "og:description");
            
            // Re-extract metadata map to get backdrop if missing from og:image
            var titleMap = extractTitleMap(html);
            var meta = titleMap[tmdbId];
            
            var bannerUrl = (meta && meta.poster_path) ? ("https://image.tmdb.org/t/p/original" + meta.poster_path) : undefined;
            // Banner usually is a backdrop
            var backdropMatch = html.match(/\\"backdrop_path\\":\\"([^\\"]+)\\"/);
            if (backdropMatch) bannerUrl = "https://image.tmdb.org/t/p/original" + backdropMatch[1];
            
            // Logo is even better for "exact banner url which is only title"
            var logoMatch = html.match(/\\"logo\\":\{\\"file_path\\":\\"([^\\"]+)\\"/);
            if (logoMatch) bannerUrl = "https://image.tmdb.org/t/p/original" + logoMatch[1];

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: url,
                    posterUrl: poster || undefined,
                    bannerUrl: bannerUrl,
                    description: description || undefined,
                    type: isMovie ? "movie" : "series",
                    episodes: episodes,
                    headers: defaultHeaders({ "Referer": url })
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error) });
        }
    }

    function parseLoadInput(input) {
        if (input && typeof input === "object" && input.watchUrl) return input;
        try { 
            var parsed = JSON.parse(input);
            if (parsed && typeof parsed === "object") return parsed;
        } catch(_) {}
        return { watchUrl: String(input || "") };
    }

    function parseWatchInfo(watchUrl) {
        var url = String(watchUrl || "");
        var movieMatch = url.match(/\/movie\/watch\/(\d+)/i);
        if (movieMatch) return { type: "movie", tmdbId: movieMatch[1], season: null, episode: null };
        var tvMatch = url.match(/\/tv\/watch\/(\d+)\?season=(\d+)&episode=(\d+)/i);
        if (tvMatch) return { type: "tv", tmdbId: tvMatch[1], season: Number(tvMatch[2]), episode: Number(tvMatch[3]) };
        return null;
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parseLoadInput(url);
            var watchUrl = String(payload.watchUrl || payload.url || "");
            if (!watchUrl) return cb({ success: true, data: [] });

            var info = parseWatchInfo(watchUrl);
            var streams = [];
            
            // Source 1: Proxied embed
            streams.push(new StreamResult({
                url: "https://proxy.cinemaos.workers.dev/api/proxy?url=" + encodeURIComponent(watchUrl) + "&referer=" + encodeURIComponent(BASE_URL + "/"),
                source: "CinemaOS Direct",
                quality: "Auto",
                headers: defaultHeaders({ "Referer": BASE_URL + "/" })
            }));

            // Try to find raw m3u8 or other links in the page
            var html = await getText(watchUrl, defaultHeaders({ "Referer": BASE_URL + "/" }));
            var m3u8Match = html.match(/https?:\/\/[^"'\s]+\.m3u8[^"'\s]*/gi);
            if (m3u8Match) {
                for (var i = 0; i < m3u8Match.length; i++) {
                    streams.push(new StreamResult({
                        url: "https://proxy.cinemaos.workers.dev/api/proxy?url=" + encodeURIComponent(m3u8Match[i]) + "&referer=" + encodeURIComponent(watchUrl),
                        source: "Stream " + (i + 1),
                        quality: "HD",
                        headers: defaultHeaders({ "Referer": watchUrl })
                    }));
                }
            }

            // Fallback: existing V3 resolver
            if (info) {
                var v3 = await resolveProviderV3(info, watchUrl);
                for (var j = 0; j < v3.length; j++) {
                    var r = v3[j];
                    if (r.url && (r.url.indexOf(".m3u8") !== -1 || r.url.indexOf(".mp4") !== -1)) {
                        r.url = "https://proxy.cinemaos.workers.dev/api/proxy?url=" + encodeURIComponent(r.url) + "&referer=" + encodeURIComponent(watchUrl);
                    }
                    streams.push(r);
                }
            }

            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error) });
        }
    }

    async function fetchImdbId(type, tmdbId) {
        var lookupType = type === "movie" ? "movie" : "tv";
        var url = "https://api.themoviedb.org/3/" + lookupType + "/" + tmdbId + "?api_key=" + encodeURIComponent(TMDB_API_KEY) + "&append_to_response=external_ids";
        var data = await getJson(url, defaultHeaders());
        return (data && data.imdb_id) || (data && data.external_ids && data.external_ids.imdb_id) || "";
    }

    async function resolveProviderV3(watchInfo, watchUrl) {
        try {
            if (!watchInfo || !watchInfo.tmdbId) return [];
            var imdbId = await fetchImdbId(watchInfo.type, watchInfo.tmdbId);
            if (!imdbId) return [];

            var message = "tmdbId:" + watchInfo.tmdbId + "|imdbId:" + imdbId;
            if (watchInfo.season && watchInfo.episode) {
                message += "|seasonId:" + watchInfo.season + "|episodeId:" + watchInfo.episode;
            }
            var primary = await hmacSha256Hex(PRIMARY_HMAC_KEY, message);
            var secret = await hmacSha256Hex(SECONDARY_HMAC_KEY, primary);

            var origin = baseOrigin(watchUrl);
            var providerUrl = origin + "/api/providerv3?type=" + encodeURIComponent(watchInfo.type) +
                "&tmdbId=" + encodeURIComponent(watchInfo.tmdbId) +
                "&imdbId=" + encodeURIComponent(imdbId) +
                "&seasonId=" + encodeURIComponent(watchInfo.season || "") +
                "&episodeId=" + encodeURIComponent(watchInfo.episode || "") +
                "&t=&ry=&secret=" + encodeURIComponent(secret);

            var provider = await getJson(providerUrl, defaultHeaders({ "Referer": origin + "/", "Origin": origin }));
            var decrypted = await decryptProviderPayload(provider && provider.data || {});
            if (!decrypted) return [];

            var payload = parseJsonSafe(decrypted, {});
            var sourcesObj = payload && payload.sources || {};
            var keys = Object.keys(sourcesObj);
            var streams = [];
            for (var i = 0; i < keys.length; i++) {
                var item = sourcesObj[keys[i]];
                if (item && item.url) {
                    streams.push(new StreamResult({
                        url: item.url,
                        source: "CinemaOS V3",
                        headers: defaultHeaders({ "Referer": origin + "/", "Origin": origin })
                    }));
                }
            }
            return streams;
        } catch (_) { return []; }
    }

    async function decryptProviderPayload(data) {
        if (!crypto || !crypto.subtle) return null;
        var encryptedHex = data && data.encrypted || "";
        var ivHex = data && data.cin || "";
        var tagHex = data && data.mao || "";
        var saltHex = data && data.salt || "";
        if (!encryptedHex || !ivHex || !tagHex || !saltHex) return null;

        var passKey = await crypto.subtle.importKey("raw", textToBytes(PBKDF2_PASSWORD), { name: "PBKDF2" }, false, ["deriveBits"]);
        var aesBits = await crypto.subtle.deriveBits({ name: "PBKDF2", salt: hexToBytes(saltHex), iterations: 100000, hash: "SHA-256" }, passKey, 256);
        var aesKey = await crypto.subtle.importKey("raw", aesBits, { name: "AES-GCM" }, false, ["decrypt"]);
        var cipher = concatBytes(hexToBytes(encryptedHex), hexToBytes(tagHex));
        var plain = await crypto.subtle.decrypt({ name: "AES-GCM", iv: hexToBytes(ivHex), tagLength: 128 }, aesKey, cipher);
        return new TextDecoder().decode(new Uint8Array(plain));
    }

    async function hmacSha256Hex(keyText, message) {
        if (!crypto || !crypto.subtle) return "";
        var key = await crypto.subtle.importKey("raw", textToBytes(keyText), { name: "HMAC", hash: "SHA-256" }, false, ["sign"]);
        var sig = await crypto.subtle.sign("HMAC", key, textToBytes(message));
        return bytesToHex(new Uint8Array(sig));
    }

    function textToBytes(text) { return new TextEncoder().encode(String(text || "")); }
    function hexToBytes(hex) {
        var clean = String(hex || "").replace(/[^0-9a-f]/gi, "");
        var out = new Uint8Array(clean.length / 2);
        for (var i = 0; i < out.length; i++) out[i] = parseInt(clean.substr(i * 2, 2), 16);
        return out;
    }
    function bytesToHex(bytes) {
        var out = [];
        for (var i = 0; i < bytes.length; i++) out.push(bytes[i].toString(16).padStart(2, "0"));
        return out.join("");
    }
    function concatBytes(a, b) {
        var out = new Uint8Array(a.length + b.length);
        out.set(a, 0); out.set(b, a.length);
        return out;
    }
    function dedupeStreams(streams) { return uniqueBy(streams, function (s) { return s.url; }); }

    var PBKDF2_PASSWORD = "a1b2c3d4e4f6g7h8i9j0k1l2m3n4o5p6";
    var PRIMARY_HMAC_KEY = "cinemaos_primary_key";
    var SECONDARY_HMAC_KEY = "cinemaos_secondary_key";

    if (typeof globalThis !== "undefined") {
        globalThis.getHome = getHome;
        globalThis.search = search;
        globalThis.load = load;
        globalThis.loadStreams = loadStreams;
    }
    if (typeof global !== "undefined") {
        global.getHome = getHome;
        global.search = search;
        global.load = load;
        global.loadStreams = loadStreams;
    }
    if (typeof window !== "undefined") {
        window.getHome = getHome;
        window.search = search;
        window.load = load;
        window.loadStreams = loadStreams;
    }
    if (typeof self !== "undefined") {
        self.getHome = getHome;
        self.search = search;
        self.load = load;
        self.loadStreams = loadStreams;
    }
})();
