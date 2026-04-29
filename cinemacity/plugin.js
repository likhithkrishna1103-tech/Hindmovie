(function () {
    "use strict";

    var MAIN_URL = String((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://cinemacity.cc").replace(/\/+$/g, "");
    var NAME = "CinemaCity";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var COOKIE = "dle_user_id=32729; dle_password=894171c6a8dab18ee594d5c652009a35;";
    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_FALLBACK = "https://orange-voice-abcf.phisher16.workers.dev";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";
    var CINEMETA_API = "https://v3-cinemeta.strem.io/meta";
    var HOME_SECTIONS = [
        { title: "Movies", path: "movies" },
        { title: "TV Series", path: "tv-series" },
        { title: "Anime", path: "xfsearch/genre/anime" },
        { title: "Asian", path: "xfsearch/genre/asian" },
        { title: "Animation", path: "xfsearch/genre/animation" },
        { title: "Documentary", path: "xfsearch/genre/documentary" }
    ];

    function defaultHeaders(extra) {
        return Object.assign({
            "User-Agent": USER_AGENT,
            "Accept": "*/*",
            "Cookie": COOKIE
        }, extra || {});
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    async function request(url, headers) {
        if (typeof http_get === "function") return http_get(url, headers || defaultHeaders());
        if (typeof fetch === "function") {
            var res = await fetch(url, { headers: headers || defaultHeaders() });
            return { body: await res.text(), headers: {}, status: res.status, finalUrl: res.url || url };
        }
        throw new Error("No HTTP client available");
    }

    async function getText(url, headers) {
        var res = await request(url, headers || defaultHeaders());
        return String(res && res.body || "");
    }

    async function getJson(url, headers) {
        var text = await getText(url, headers || defaultHeaders({ "Accept": "application/json" }));
        return parseJsonSafe(text, null);
    }

    async function postForm(url, form, headers) {
        var body = [];
        for (var key in (form || {})) {
            if (!Object.prototype.hasOwnProperty.call(form, key)) continue;
            body.push(encodeURIComponent(key) + "=" + encodeURIComponent(form[key]));
        }
        var payload = body.join("&");
        var requestHeaders = Object.assign({
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
        }, headers || defaultHeaders());
        if (typeof http_post === "function") {
            var attempts = [
                function () { return http_post(url, requestHeaders, payload); },
                function () { return http_post(url, payload, requestHeaders); }
            ];
            for (var i = 0; i < attempts.length; i++) {
                try {
                    var res = await attempts[i]();
                    var text = String(res && res.body || "");
                    if (/(Found\s+\d+\s+responses|dar-short_item|Zootopia)/i.test(text)) return text;
                    if (text && i === attempts.length - 1) return text;
                } catch (_) {}
            }
            return "";
        }
        if (typeof fetch === "function") {
            var response = await fetch(url, {
                method: "POST",
                headers: requestHeaders,
                body: payload
            });
            return await response.text();
        }
        throw new Error("No HTTP POST client available");
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">");
    }

    function trim(value) {
        return decodeHtml(String(value || "").replace(/\s+/g, " ")).replace(/^\s+|\s+$/g, "");
    }

    function stripTags(value) {
        return trim(String(value || "").replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "));
    }

    function snippet(value, max) {
        return trim(stripTags(value)).slice(0, max || 280);
    }

    function absoluteUrl(base, path) {
        if (!path) return "";
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function firstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return trim(match[1]);
        }
        return "";
    }

    function parseAnchors(html, base) {
        var source = String(html || "");
        var out = [];
        var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = regex.exec(source))) {
            out.push({
                href: absoluteUrl(base, decodeHtml(match[1])),
                text: stripTags(match[2])
            });
        }
        return out;
    }

    function splitCardBlocks(html) {
        var parts = String(html || "").split(/<div\b[^>]*class=["'][^"']*dar-short_item[^"']*["'][^>]*>/i);
        var out = [];
        for (var i = 1; i < parts.length; i++) out.push(parts[i]);
        return out;
    }

    function scoreFromText(text) {
        var value = Number(String(text || "").replace(/[^0-9.]/g, ""));
        return value ? value : undefined;
    }

    function qualityFromText(text) {
        var value = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b|\buhd\b/.test(value)) return 2160;
        if (/\b1440p\b|\b2k\b/.test(value)) return 1440;
        if (/\b1080p\b|\bfhd\b/.test(value)) return 1080;
        if (/\b720p\b|\bhd\b/.test(value)) return 720;
        if (/\b480p\b|\bsd\b/.test(value)) return 480;
        if (/\b360p\b/.test(value)) return 360;
        return 0;
    }

    function inferTypeFromHref(href) {
        return /\/tv-series\//i.test(String(href || "")) ? "series" : "movie";
    }

    function parseCard(block, base) {
        var anchors = parseAnchors(block, base);
        var itemAnchor = null;
        var poster = "";
        for (var i = 0; i < anchors.length; i++) {
            if (!poster && /\.(?:webp|jpg|jpeg|png)(?:[?#]|$)/i.test(anchors[i].href)) poster = anchors[i].href;
            if (!itemAnchor && /\/(?:movies|tv-series)\//i.test(anchors[i].href)) itemAnchor = anchors[i];
        }
        if (!itemAnchor || !itemAnchor.href || !itemAnchor.text) return null;

        var title = trim(itemAnchor.text);
        var score = firstMatch(block, [/<span\b[^>]*class=["'][^"']*rating-color1?[^"']*["'][^>]*>([^<]+)<\/span>/i]);
        var qualityLabel = firstMatch(block, [
            /<span>\s*<a\b[^>]*href=["'][^"']*\/xfsearch\/quality\/[^"']*["'][^>]*>([^<]+)<\/a>\s*<\/span>/i
        ]) || (/>\s*TS\s*</i.test(block) ? "TS" : "HD");

        return new MultimediaItem({
            title: title,
            url: itemAnchor.href,
            posterUrl: poster || undefined,
            type: inferTypeFromHref(itemAnchor.href),
            score: scoreFromText(score),
            quality: qualityLabel,
            headers: defaultHeaders({ "Referer": MAIN_URL + "/" })
        });
    }

    function parseCards(html, base) {
        return uniqueBy(splitCardBlocks(html).map(function (block) {
            return parseCard(block, base);
        }).filter(Boolean), function (item) {
            return item.url;
        });
    }

    function extractSearchContent(html) {
        var source = String(html || "");
        var marker = /<div\b[^>]*class=["'][^"']*content container[^"']*["'][^>]*>/i;
        var match = marker.exec(source);
        if (!match) return source;
        return source.slice(match.index);
    }

    function parseSearchCards(html, base) {
        var source = extractSearchContent(html);
        var formEnd = source.indexOf("</form>");
        if (formEnd !== -1) source = source.slice(formEnd + 7);
        var footerIndex = source.search(/<footer\b/i);
        if (footerIndex !== -1) source = source.slice(0, footerIndex);
        return parseCards(source, base);
    }

    function normalizeTitle(text) {
        return trim(text)
            .toLowerCase()
            .replace(/&/g, " and ")
            .replace(/['"`]/g, "")
            .replace(/[^a-z0-9]+/g, " ")
            .replace(/\s+/g, " ")
            .trim();
    }

    function rankSearchResults(items, query) {
        var q = normalizeTitle(query);
        return (items || []).slice().sort(function (a, b) {
            function score(item) {
                var rawTitle = String(item && item.title || "");
                var title = normalizeTitle(rawTitle);
                var bareTitle = normalizeTitle(rawTitle.replace(/\(\d{4}[^)]*\)\s*$/i, ""));
                if (!title) return -1;
                if (bareTitle === q || title === q) return 1000;
                if (bareTitle.indexOf(q + " ") === 0) return 900 - (bareTitle.length - q.length);
                if (title.indexOf(q + " ") === 0) return 850 - (title.length - q.length);
                if (bareTitle.indexOf(q) !== -1) return 800 - (bareTitle.length - q.length);
                if (title.indexOf(q) !== -1) return 700 - (title.length - q.length);
                var tokens = q.split(" ").filter(Boolean);
                var matched = 0;
                for (var i = 0; i < tokens.length; i++) {
                    if (bareTitle.indexOf(tokens[i]) !== -1 || title.indexOf(tokens[i]) !== -1) matched++;
                }
                return matched * 100 - title.length;
            }
            return score(b) - score(a);
        });
    }

    function extractMeta(html, propertyName) {
        var pattern = new RegExp("<meta\\b[^>]*(?:property|name)=[\"']" + propertyName.replace(/[.*+?^${}()|[\]\\]/g, "\\$&") + "[\"'][^>]*content=[\"']([^\"']+)[\"']", "i");
        return decodeHtml(firstMatch(html, [pattern]));
    }

    function decodeBase64(value) {
        var input = String(value || "");
        if (typeof atob === "function") return atob(input);
        if (typeof Buffer !== "undefined") return Buffer.from(input, "base64").toString("utf8");
        throw new Error("Base64 decoder unavailable");
    }

    function decodeJsQuoted(quoted) {
        var source = String(quoted || "");
        if (!source) return "";
        var quote = source.charAt(0);
        var text = source.slice(1, -1);
        text = text
            .replace(/\\u([0-9a-fA-F]{4})/g, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/\\x([0-9a-fA-F]{2})/g, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/\\n/g, "\n")
            .replace(/\\r/g, "\r")
            .replace(/\\t/g, "\t")
            .replace(/\\\//g, "/")
            .replace(/\\"/g, "\"")
            .replace(/\\'/g, "'")
            .replace(/\\\\/g, "\\");
        if (quote === "\"") {
            try { return JSON.parse(source); } catch (_) {}
        }
        return text;
    }

    function extractPlayerScript(html) {
        var regex = /eval\(atob\("([^"]+)"\)\)/g;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var decoded = "";
            try { decoded = decodeBase64(match[1]); } catch (_) {}
            if (decoded && /new\s+Playerjs\s*\(/.test(decoded) && /file\s*:/.test(decoded)) return decoded;
        }
        return "";
    }

    function extractPlayerField(script, fieldName) {
        var quoted = new RegExp(fieldName + "\\s*:\\s*('(?:\\\\.|[^'])*'|\"(?:\\\\.|[^\"])*\")", "s").exec(script || "");
        if (quoted && quoted[1]) return decodeJsQuoted(quoted[1]);
        var raw = new RegExp(fieldName + "\\s*:\\s*(\\[[\\s\\S]*?\\]|\\{[\\s\\S]*?\\})\\s*,\\s*(?:poster|default_quality|preload|ready|id)", "s").exec(script || "");
        return raw && raw[1] ? raw[1] : "";
    }

    function normalizeRawFile(rawValue) {
        if (!rawValue) return [];
        if (Array.isArray(rawValue)) return rawValue;
        if (typeof rawValue === "object") return [rawValue];
        var value = trim(rawValue);
        if (!value) return [];
        if (value.charAt(0) === "[") {
            return parseJsonSafe(value, []);
        }
        if (value.charAt(0) === "{") {
            var obj = parseJsonSafe(value, null);
            return obj ? [obj] : [];
        }
        return [{ file: value }];
    }

    function parseSubtitleTracks(raw) {
        var tracks = [];
        var regex = /\[([^\]]+)\](https?:\/\/[^,\s]+)/g;
        var match;
        while ((match = regex.exec(String(raw || "")))) {
            tracks.push({
                url: match[2],
                name: trim(match[1])
            });
        }
        return uniqueBy(tracks, function (item) { return item.url; });
    }

    function extractAudioLanguagesFromStream(base) {
        var out = [];
        var parts = String(base || "").split(",");
        for (var i = 0; i < parts.length; i++) {
            var part = trim(parts[i]);
            if (!/\.m4a(?:[?#]|$)/i.test(part)) continue;
            var lang = trim(part.substring(part.lastIndexOf("_") + 1).replace(/\.m4a(?:[?#].*)?$/i, "")).replace(/-/g, " ");
            if (!lang) continue;
            lang = lang.replace(/\b\w/g, function (ch) { return ch.toUpperCase(); });
            out.push(lang);
        }
        return uniqueBy(out, function (item) { return item.toLowerCase(); });
    }

    function buildPayload(data) {
        return JSON.stringify(data || {});
    }

    async function fetchTmdb(path) {
        var directUrl = TMDB_API + path + (path.indexOf("?") === -1 ? "?" : "&") + "api_key=" + TMDB_API_KEY;
        var fallbackUrl = TMDB_FALLBACK + path + (path.indexOf("?") === -1 ? "?" : "&") + "api_key=" + TMDB_API_KEY;
        try {
            return await getJson(directUrl, defaultHeaders({ "Accept": "application/json" }));
        } catch (_) {}
        try {
            return await getJson(fallbackUrl, defaultHeaders({ "Accept": "application/json" }));
        } catch (_) {
            return null;
        }
    }

    function buildActorList(castArray) {
        return (castArray || []).slice(0, 20).map(function (person) {
            if (!person || !(person.name || person.original_name)) return null;
            return new Actor({
                name: person.name || person.original_name,
                role: person.character || "",
                image: person.profile_path ? (TMDB_IMAGE + person.profile_path) : undefined
            });
        }).filter(Boolean);
    }

    function buildRecommendations(html, base) {
        var parts = String(html || "").split(/<div\b[^>]*class=["'][^"']*ta-rel_item[^"']*["'][^>]*>/i);
        var out = [];
        for (var i = 1; i < parts.length; i++) {
            var block = parts[i];
            var anchors = parseAnchors(block, base);
            var itemAnchor = null;
            var poster = "";
            for (var j = 0; j < anchors.length; j++) {
                if (!poster && /\.(?:webp|jpg|jpeg|png)(?:[?#]|$)/i.test(anchors[j].href)) poster = anchors[j].href;
                if (!itemAnchor && /\/(?:movies|tv-series)\//i.test(anchors[j].href)) itemAnchor = anchors[j];
            }
            if (!itemAnchor) continue;
            out.push(new MultimediaItem({
                title: trim(itemAnchor.text),
                url: itemAnchor.href,
                posterUrl: poster || undefined,
                type: inferTypeFromHref(itemAnchor.href),
                score: scoreFromText(firstMatch(block, [/<span\b[^>]*class=["'][^"']*rating-color1[^"']*["'][^>]*>([^<]+)<\/span>/i]))
            }));
        }
        return uniqueBy(out, function (item) { return item.url; });
    }

    function mapEpisodeMeta(videos) {
        var out = {};
        (videos || []).forEach(function (item) {
            if (!item || item.season == null || item.episode == null) return;
            out[String(item.season) + ":" + String(item.episode)] = item;
        });
        return out;
    }

    function extractImdbId(html) {
        var match = String(html || "").match(/tt\d+/);
        return match ? match[0] : "";
    }

    async function findTmdbId(imdbId) {
        if (!imdbId) return "";
        var json = await fetchTmdb("/find/" + imdbId + "?external_source=imdb_id");
        if (!json) return "";
        var movie = json.movie_results && json.movie_results[0];
        var tv = json.tv_results && json.tv_results[0];
        return String((movie && movie.id) || (tv && tv.id) || "");
    }

    function extractAudioLanguages(html) {
        var match = /<li>\s*<span>\s*Audio language\s*<\/span>\s*<span>([\s\S]*?)<\/span>\s*<\/li>/i.exec(String(html || ""));
        if (!match) return "";
        return parseAnchors(match[1], MAIN_URL).map(function (item) { return item.text; }).filter(Boolean).join(", ");
    }

    function extractDescription(html) {
        var match = /<div\b[^>]*id=["']about["'][^>]*>[\s\S]*?<div\b[^>]*class=["'][^"']*ta-full_text1[^"']*["'][^>]*>([\s\S]*?)<\/div>/i.exec(String(html || ""));
        return match ? stripTags(match[1]) : "";
    }

    function extractBackground(html, base) {
        var block = /<div\b[^>]*class=["'][^"']*dar-full_bg[^"']*["'][^>]*>([\s\S]*?)<\/div>/i.exec(String(html || ""));
        return block ? firstMatch(block[1], [/<a\b[^>]*href=["']([^"']+)["']/i]) : "";
    }

    function extractTrailer(html) {
        return firstMatch(html, [/<div\b[^>]*class=["'][^"']*dar-full_bg[^"']*["'][^>]*>[\s\S]*?data-vbg=["']([^"']+)["']/i]);
    }

    function getYearFromTitle(title) {
        var match = String(title || "").match(/\((\d{4})\)/);
        return match ? Number(match[1]) : undefined;
    }

    async function getHome(cb) {
        try {
            var sections = await Promise.all(HOME_SECTIONS.map(async function (section) {
                try {
                    var html = await getText(MAIN_URL + "/" + section.path, defaultHeaders({ "Referer": MAIN_URL + "/" }));
                    return { title: section.title, items: parseCards(html, MAIN_URL) };
                } catch (_) {
                    return { title: section.title, items: [] };
                }
            }));
            var data = {};
            sections.forEach(function (section) { data[section.title] = section.items; });
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var html = await postForm(MAIN_URL + "/", {
                do: "search",
                subaction: "search",
                search_start: "0",
                full_search: "0",
                story: String(query || "")
            }, defaultHeaders({ "Referer": MAIN_URL + "/" }));
            var items = rankSearchResults(parseSearchCards(html, MAIN_URL), query);
            if (!items.length) {
                cb({ success: false, errorCode: "SEARCH_EMPTY", message: "No results parsed. Snippet: " + snippet(html, 260) });
                return;
            }
            cb({ success: true, data: items });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var pageUrl = String(url || "");
            var html = await getText(pageUrl, defaultHeaders({ "Referer": MAIN_URL + "/" }));
            var ogTitle = extractMeta(html, "og:title") || "Unknown Title";
            var title = trim(ogTitle.split("»")[0]).replace(/\(\d{4}\)\s*$/, "").trim() || "Unknown Title";
            var poster = extractMeta(html, "og:image") || undefined;
            var bgPoster = extractBackground(html, MAIN_URL) || poster;
            var trailer = extractTrailer(html) || "";
            var audioLanguages = extractAudioLanguages(html);
            var description = extractDescription(html);
            var imdbId = extractImdbId(html);
            var isSeries = /\/tv-series\//i.test(pageUrl);
            var mediaType = isSeries ? "tv" : "movie";
            var tmdbId = await findTmdbId(imdbId);
            var credits = tmdbId ? await fetchTmdb("/" + mediaType + "/" + tmdbId + "/credits?language=en-US") : null;
            var cinemeta = imdbId ? await getJson(CINEMETA_API + "/" + (isSeries ? "series" : "movie") + "/" + imdbId + ".json", defaultHeaders({ "Accept": "application/json" })).catch(function () { return null; }) : null;
            var meta = cinemeta && cinemeta.meta || {};
            var episodeMeta = mapEpisodeMeta(meta.videos || []);
            var playerScript = extractPlayerScript(html);
            if (!playerScript) {
                cb({ success: false, errorCode: "LOAD_ERROR", message: "PlayerJS block not found. Snippet: " + snippet(html, 260) });
                return;
            }

            var rawFile = extractPlayerField(playerScript, "file");
            var rawSubtitle = extractPlayerField(playerScript, "subtitle");
            var fileArray = normalizeRawFile(rawFile);
            if (!fileArray.length) {
                cb({ success: false, errorCode: "LOAD_ERROR", message: "Player file payload not parsed." });
                return;
            }

            var recommendation = buildRecommendations(html, MAIN_URL);
            var cast = buildActorList(credits && credits.cast);
            var score = meta.imdbRating ? Number(meta.imdbRating) : undefined;
            var year = getYearFromTitle(ogTitle) || (meta.year ? Number(meta.year) : undefined);
            var plot = meta.description || description || "";
            if (audioLanguages) plot += (plot ? " - " : "") + "Audio: " + audioLanguages;
            var logoUrl = imdbId ? ("https://live.metahub.space/logo/medium/" + imdbId + "/img") : undefined;

            if (!isSeries) {
                var movieItem = fileArray[0];
                var moviePayload = buildPayload({
                    title: meta.name || title,
                    streamUrl: String(movieItem && movieItem.file || ""),
                    subtitleTracks: parseSubtitleTracks(rawSubtitle || movieItem && movieItem.subtitle || ""),
                    audioLanguages: audioLanguages || extractAudioLanguagesFromStream(movieItem && movieItem.file || "").join(", ")
                });
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: meta.name || title,
                        url: pageUrl,
                        posterUrl: poster,
                        bannerUrl: meta.background || bgPoster,
                        logoUrl: logoUrl,
                        type: "movie",
                        description: plot,
                        year: year,
                        score: score,
                        cast: cast,
                        recommendations: recommendation,
                        genres: meta.genres || [],
                        headers: defaultHeaders({ "Referer": pageUrl }),
                        episodes: [
                            new Episode({
                                name: "Movie",
                                url: moviePayload,
                                season: 1,
                                episode: 1,
                                posterUrl: poster,
                                description: plot,
                                headers: defaultHeaders({ "Referer": pageUrl })
                            })
                        ]
                    })
                });
                return;
            }

            var seasonRegex = /Season\s*(\d+)/i;
            var episodeRegex = /Episode\s*(\d+)/i;
            var episodes = [];

            for (var i = 0; i < fileArray.length; i++) {
                var seasonItem = fileArray[i] || {};
                var seasonMatch = seasonRegex.exec(String(seasonItem.title || ""));
                if (!seasonMatch || !Array.isArray(seasonItem.folder)) continue;
                var season = Number(seasonMatch[1]);
                for (var j = 0; j < seasonItem.folder.length; j++) {
                    var epItem = seasonItem.folder[j] || {};
                    var episodeMatch = episodeRegex.exec(String(epItem.title || ""));
                    if (!episodeMatch) continue;
                    var episode = Number(episodeMatch[1]);
                    var streams = [];
                    if (epItem.file) streams.push(epItem.file);
                    if (Array.isArray(epItem.folder)) {
                        for (var k = 0; k < epItem.folder.length; k++) {
                            if (epItem.folder[k] && epItem.folder[k].file) streams.push(epItem.folder[k].file);
                        }
                    }
                    streams = uniqueBy(streams.filter(Boolean), function (item) { return item; });
                    if (!streams.length) continue;
                    var metaKey = String(season) + ":" + String(episode);
                    var epMeta = episodeMeta[metaKey] || {};
                    episodes.push(new Episode({
                        name: epMeta.name || ("S" + season + "E" + episode),
                        url: buildPayload({
                            title: meta.name || title,
                            season: season,
                            episode: episode,
                            streams: streams,
                            subtitleTracks: parseSubtitleTracks(epItem.subtitle || "")
                        }),
                        season: season,
                        episode: episode,
                        posterUrl: epMeta.thumbnail || poster,
                        description: epMeta.overview || plot,
                        airDate: epMeta.released || undefined,
                        headers: defaultHeaders({ "Referer": pageUrl })
                    }));
                }
            }

            cb({
                success: true,
                data: new MultimediaItem({
                    title: meta.name || title,
                    url: pageUrl,
                    posterUrl: poster,
                    bannerUrl: meta.background || bgPoster,
                    logoUrl: logoUrl,
                    type: "series",
                    description: plot,
                    year: year,
                    score: score,
                    cast: cast,
                    recommendations: recommendation,
                    genres: meta.genres || [],
                    headers: defaultHeaders({ "Referer": pageUrl }),
                    episodes: episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    function normalizeSubtitlePath(url) {
        var marker = "/public_files/";
        var idx = String(url || "").indexOf(marker);
        return idx === -1 ? null : String(url).slice(idx + marker.length);
    }

    function cleanTitle(input) {
        return String(input || "")
            .replace(/[^0-9A-Za-z\s._-]/g, "")
            .replace(/[\s_]+/g, ".")
            .replace(/\.+/g, ".")
            .replace(/^\.+|\.+$/g, "");
    }

    function extractQuality(url) {
        return qualityFromText(url);
    }

    function buildDownloadLinks(base, subtitles, selectedAudioIndex, title, season, episode) {
        var parts = String(base || "").split(",").map(trim);
        var videoFiles = parts.filter(function (item) { return /\.mp4(?:[?#]|$)/i.test(item); });
        var audioFiles = parts.filter(function (item) { return /\.m4a(?:[?#]|$)/i.test(item); });
        if (!audioFiles.length) return [];
        var audio = audioFiles[selectedAudioIndex];
        if (!audio) return [];
        var baseUrl = parts.join(",");

        function filterSubs(video) {
            var baseName = String(video || "").split("/").pop().split("_web-dl")[0].split("_202")[0];
            return (subtitles || []).map(function (item) {
                return normalizeSubtitlePath(item && item.url);
            }).filter(function (item) {
                return item && item.indexOf(baseName) !== -1;
            }).filter(function (item, index, arr) {
                return arr.indexOf(item) === index;
            }).join(",");
        }

        var langRaw = trim(audio.substring(audio.lastIndexOf("_") + 1).replace(/\.m4a(?:[?#].*)?$/i, ""));
        var lang = langRaw.replace(/-/g, " ").replace(/\b\w/g, function (ch) { return ch.toUpperCase(); }) || "Unknown";
        var out = [];

        for (var i = 0; i < videoFiles.length; i++) {
            var video = videoFiles[i];
            var quality = extractQuality(video);
            var res = trim(video.substring(video.lastIndexOf("_") + 1).replace(/\.mp4(?:[?#].*)?$/i, ""));
            var fileName;
            if (season != null && episode != null) {
                var s = String(season).padStart(2, "0");
                var e = String(episode).padStart(2, "0");
                fileName = cleanTitle(title) + ".S" + s + "E" + e + "." + res + "." + lang.replace(/ /g, ".");
            } else {
                fileName = cleanTitle(title) + ".WEB-DL." + res + "." + lang.replace(/ /g, ".");
            }
            var subs = filterSubs(video);
            var finalUrl = baseUrl + "?action=download"
                + "&video=" + encodeURIComponent(video)
                + "&audio=" + encodeURIComponent(audio)
                + (subs ? "&subtitle=" + encodeURIComponent(subs) : "")
                + "&name=" + encodeURIComponent(fileName);
            out.push({
                url: finalUrl,
                quality: quality || undefined,
                lang: lang
            });
        }
        return out;
    }

    function attachSubtitles(stream, subtitles) {
        if (!subtitles || !subtitles.length) return stream;
        stream.subtitles = subtitles.map(function (item) {
            return { url: item.url, name: item.name };
        });
        return stream;
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parseJsonSafe(url, null);
            if (!payload) {
                cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid stream payload" });
                return;
            }
            var subtitles = payload.subtitleTracks || [];
            var streamUrls = [];
            if (Array.isArray(payload.streams)) streamUrls = payload.streams.slice();
            if (!streamUrls.length && payload.streamUrl) streamUrls = [payload.streamUrl];
            if (!streamUrls.length) {
                cb({ success: true, data: [] });
                return;
            }

            var results = [];
            for (var i = 0; i < streamUrls.length; i++) {
                var streamUrl = String(streamUrls[i] || "").trim();
                if (!streamUrl) continue;
                var languages = payload.audioLanguages ? String(payload.audioLanguages).split(/\s*,\s*/) : extractAudioLanguagesFromStream(streamUrl);
                languages = uniqueBy(languages.filter(Boolean), function (item) { return item.toLowerCase(); });
                var label = languages.length === 1 ? languages[0] : (languages.length ? "Multi Audio" : "Unknown");
                results.push(attachSubtitles(new StreamResult({
                    url: streamUrl,
                    source: NAME + " [" + label + "] [HLS]",
                    quality: extractQuality(streamUrl) || undefined,
                    headers: defaultHeaders({ "Referer": MAIN_URL + "/" })
                }), subtitles));

                var audioFiles = String(streamUrl).split(",").filter(function (item) {
                    return /\.m4a(?:[?#]|$)/i.test(item);
                });
                for (var j = 0; j < audioFiles.length; j++) {
                    var downloads = buildDownloadLinks(streamUrl, subtitles, j, payload.title || NAME, payload.season, payload.episode);
                    for (var k = 0; k < downloads.length; k++) {
                        results.push(attachSubtitles(new StreamResult({
                            url: downloads[k].url,
                            source: NAME + " [" + downloads[k].lang + "] [Download]",
                            quality: downloads[k].quality,
                            headers: defaultHeaders({ "Referer": MAIN_URL + "/" })
                        }), subtitles));
                    }
                }
            }

            cb({ success: true, data: uniqueBy(results, function (item) { return item.url + "|" + item.source; }) });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    if (typeof globalThis !== "undefined") {
        globalThis.getHome = getHome;
        globalThis.loadHome = getHome;
        globalThis.loadhome = getHome;
        globalThis.search = search;
        globalThis.load = load;
        globalThis.loadStreams = loadStreams;
    }
    if (typeof window !== "undefined") {
        window.getHome = getHome;
        window.loadHome = getHome;
        window.loadhome = getHome;
        window.search = search;
        window.load = load;
        window.loadStreams = loadStreams;
    }
    if (typeof global !== "undefined") {
        global.getHome = getHome;
        global.loadHome = getHome;
        global.loadhome = getHome;
        global.search = search;
        global.load = load;
        global.loadStreams = loadStreams;
    }
})();
