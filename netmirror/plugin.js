(function () {
    "use strict";

    var MAIN_URL = "https://net52.cc";
    var IMG_BASE = "https://imgcdn.kim";
    var COOKIE_TTL_MS = 54000000;
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0";
    var NEWTV_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0";

    var PROVIDERS = {
        netflix: {
            id: "netflix",
            name: "Netflix",
            ott: "nf",
            playerOtt: "nf",
            prefix: "",
            search: true,
            poster: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            initialEpisodePoster: function (id) { return IMG_BASE + "/poster/v/150/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/epimg/150/" + id + ".jpg"; },
            suggestPoster: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; }
        },
        prime: {
            id: "prime",
            name: "Prime Video",
            ott: "pv",
            playerOtt: "pv",
            prefix: "/pv",
            search: true,
            poster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/pv/h/" + id + ".jpg"; },
            initialEpisodePoster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/pvepimg/" + id + ".jpg"; },
            suggestPoster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; }
        },
        hotstar: {
            id: "hotstar",
            name: "Hotstar",
            ott: "hs",
            playerOtt: "hs",
            prefix: "/hs",
            search: true,
            poster: function (id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/hs/h/" + id + ".jpg"; },
            initialEpisodePoster: function (id) { return IMG_BASE + "/hsepimg/150/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/hsepimg/" + id + ".jpg"; },
            suggestPoster: function (id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; }
        },
        disney: null,
        marvel: null,
        starwars: null,
        pixar: null
    };

    function studioConfig(id, name, studio) {
        var base = Object.assign({}, PROVIDERS.hotstar);
        base.id = id;
        base.name = name;
        base.ott = "dp";
        base.playerOtt = "hs";
        base.prefix = "/hs";
        base.search = false;
        base.studio = studio;
        return base;
    }

    PROVIDERS.disney = studioConfig("disney", "Disney", "disney");
    PROVIDERS.marvel = studioConfig("marvel", "Marvel", "marvel");
    PROVIDERS.starwars = studioConfig("starwars", "Star Wars", "starwars");
    PROVIDERS.pixar = studioConfig("pixar", "Pixar", "pixar");

    var PAGE_HEADERS = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
        "Accept-Language": "en-IN,en-US;q=0.9,en;q=0.8",
        "Cache-Control": "max-age=0",
        "Connection": "keep-alive",
        "sec-ch-ua": "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\"",
        "sec-ch-ua-mobile": "?0",
        "sec-ch-ua-platform": "\"Android\"",
        "Sec-Fetch-Dest": "document",
        "Sec-Fetch-Mode": "navigate",
        "Sec-Fetch-Site": "same-origin",
        "Sec-Fetch-User": "?1",
        "Upgrade-Insecure-Requests": "1",
        "User-Agent": USER_AGENT,
        "X-Requested-With": "XMLHttpRequest"
    };

    var NEWTV_BASE_HEADERS = {
        "Cache-Control": "no-cache, no-store, must-revalidate",
        "Pragma": "no-cache",
        "Expires": "0",
        "X-Requested-With": "NetmirrorNewTV v1.0",
        "User-Agent": NEWTV_USER_AGENT,
        "Accept": "application/json, text/plain, */*"
    };

    var NEWTV_DOMAINS = [
        "aHR0cHM6Ly9tb2JpbGVkZXRlY3RzLmNvbQ==",
        "aHR0cHM6Ly9tb2JpbGVkZXRlY3QuYXBw",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmFydA==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNj",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNsaWNr",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lmluaw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmxpdmU=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnBybw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNob3A=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNpdGU=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNwYWNl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnN0b3Jl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnZpcA==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lndpa2k=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lnh5eg==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5hcnQ=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5jYw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbmZv",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbms=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5saXZl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5wcm8=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5zdG9yZQ==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy50b3A=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy54eXo="
    ];

    var cookieCache = { value: "", time: 0 };
    var resolvedApiUrl = "";

    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").trim();
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function encodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof btoa === "function") return btoa(input);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "utf8").toString("base64");
        } catch (_) {}
        return "";
    }

    function decodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof atob === "function") return atob(input);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "base64").toString("utf8");
        } catch (_) {}
        return "";
    }

    function randomUuid() {
        if (typeof crypto !== "undefined" && crypto.randomUUID) return crypto.randomUUID();
        return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
            var r = Math.random() * 16 | 0;
            var v = c === "x" ? r : (r & 3 | 8);
            return v.toString(16);
        });
    }

    function selectedProvider() {
        var id = trim(manifest && manifest.providerId).toLowerCase() || "netflix";
        return PROVIDERS[id] || PROVIDERS.netflix;
    }

    function cookieHeader(cookies) {
        var rows = [];
        Object.keys(cookies || {}).forEach(function (key) {
            var value = cookies[key];
            if (typeof value !== "undefined" && value !== null && value !== "") rows.push(key + "=" + value);
        });
        return rows.join("; ");
    }

    function withHeaders(base, extra) {
        var out = Object.assign({}, base || {});
        extra = extra || {};
        Object.keys(extra).forEach(function (key) {
            if (typeof extra[key] !== "undefined") out[key] = extra[key];
        });
        return out;
    }

    function pageCookies(config, token) {
        var cookies = {
            "ott": config.ott,
            "hd": "on"
        };
        if (token) cookies.t_hash_t = token;
        if (config.studio) cookies.studio = config.studio;
        return cookies;
    }

    function pageHeaders(config, token, referer) {
        return withHeaders(PAGE_HEADERS, {
            "Cookie": cookieHeader(pageCookies(config, token)),
            "Referer": referer || (MAIN_URL + "/home")
        });
    }

    function normalizeHeaders(headers) {
        var out = {};
        if (!headers) return out;
        if (typeof headers.forEach === "function") {
            headers.forEach(function (value, key) {
                out[String(key).toLowerCase()] = value;
            });
            return out;
        }
        Object.keys(headers).forEach(function (key) {
            out[String(key).toLowerCase()] = headers[key];
        });
        return out;
    }

    function normalizeResponse(res, url) {
        if (typeof res === "string") return { status: 200, body: res, headers: {}, url: url };
        return {
            status: res && typeof res.status !== "undefined" ? res.status : 200,
            body: String(res && (res.body || res.text || "") || ""),
            headers: normalizeHeaders(res && res.headers),
            url: res && (res.url || res.finalUrl) || url
        };
    }

    async function requestGet(url, headers) {
        if (typeof http_get === "function") return normalizeResponse(await http_get(url, headers || {}), url);
        var res = await fetch(url, { headers: headers || {} });
        var body = await res.text();
        var headersOut = {};
        if (res.headers && res.headers.forEach) {
            res.headers.forEach(function (value, key) { headersOut[key] = value; });
        }
        return { status: res.status, body: body, headers: headersOut, url: res.url || url };
    }

    async function requestPostForm(url, body, headers) {
        var res;
        if (typeof fetch === "function") {
            try {
                var fetchRes = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body: body || "",
                    redirect: "manual"
                });
                var text = await fetchRes.text().catch(function () { return ""; });
                return {
                    status: fetchRes.status,
                    body: text,
                    headers: normalizeHeaders(fetchRes.headers),
                    url: fetchRes.url || url
                };
            } catch (_) {}
        }
        try {
            res = await http_post(url, headers || {}, body || "");
            if (res && (res.body || res.headers)) return normalizeResponse(res, url);
        } catch (_) {}
        res = await http_post(url, body || "", headers || {});
        return normalizeResponse(res, url);
    }

    async function requestPostFormCandidates(url, body, headers) {
        var out = [];
        if (typeof axios !== "undefined" && axios && typeof axios.post === "function") {
            try {
                var ax = await axios.post(url, body || "", {
                    headers: headers || {},
                    maxRedirects: 0,
                    validateStatus: function () { return true; },
                    responseType: "text"
                });
                out.push({
                    status: ax.status,
                    body: typeof ax.data === "string" ? ax.data : JSON.stringify(ax.data || ""),
                    headers: normalizeHeaders(ax.headers),
                    url: url
                });
            } catch (_) {}
        }
        if (typeof fetch === "function") {
            try {
                var fetchRes = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body: body || "",
                    redirect: "manual"
                });
                out.push({
                    status: fetchRes.status,
                    body: await fetchRes.text().catch(function () { return ""; }),
                    headers: normalizeHeaders(fetchRes.headers),
                    url: fetchRes.url || url
                });
            } catch (_) {}
        }
        if (typeof http_post === "function") {
            try {
                out.push(normalizeResponse(await http_post(url, headers || {}, body || ""), url));
            } catch (_) {}
            try {
                out.push(normalizeResponse(await http_post(url, body || "", headers || {}), url));
            } catch (_) {}
        }
        return out;
    }

    function responseHeader(headers, name) {
        var wanted = String(name || "").toLowerCase();
        headers = headers || {};
        if (headers[wanted]) return headers[wanted];
        var keys = Object.keys(headers);
        for (var i = 0; i < keys.length; i++) {
            if (String(keys[i]).toLowerCase() === wanted) return headers[keys[i]];
        }
        return "";
    }

    function extractCookie(headers, cookieName) {
        var raw = responseHeader(headers, "set-cookie");
        if (Array.isArray(raw)) raw = raw.join("\n");
        var text = String(raw || "");
        var re = new RegExp(cookieName + "=([^;\\n]+)", "i");
        var match = text.match(re);
        return match ? match[1] : "";
    }

    async function bypass() {
        if (cookieCache.value && Date.now() - cookieCache.time < COOKIE_TTL_MS) return cookieCache.value;
        var headers = {
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
            "Accept-Encoding": "gzip, deflate, br, zstd",
            "Accept-Language": "en-US,en;q=0.9",
            "Cache-Control": "max-age=0",
            "Connection": "keep-alive",
            "Content-Type": "application/x-www-form-urlencoded",
            "Origin": "https://net22.cc",
            "Referer": "https://net22.cc/verify2",
            "sec-ch-ua": "\"Google Chrome\";v=\"147\", \"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"147\"",
            "sec-ch-ua-mobile": "?0",
            "sec-ch-ua-platform": "\"Windows\"",
            "Sec-Fetch-Dest": "document",
            "Sec-Fetch-Mode": "navigate",
            "Sec-Fetch-Site": "same-origin",
            "Sec-Fetch-User": "?1",
            "Upgrade-Insecure-Requests": "1",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36"
        };
        var body = "g-recaptcha-response=" + encodeURIComponent(randomUuid());
        var candidates = await requestPostFormCandidates(MAIN_URL + "/verify.php", body, headers);
        var cookie = "";
        for (var i = 0; i < candidates.length; i++) {
            cookie = extractCookie(candidates[i].headers, "t_hash_t");
            if (cookie) break;
        }
        if (!cookie) throw new Error("CNCVerse bypass failed: missing t_hash_t cookie");
        cookieCache = { value: cookie, time: Date.now() };
        return cookie;
    }

    function unixTime() {
        return Math.floor(Date.now() / 1000);
    }

    function absoluteUrl(base, value) {
        value = String(value || "").trim();
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base).toString();
        } catch (_) {
            return value;
        }
    }

    function numberFrom(value) {
        var n = parseInt(String(value || "").replace(/[^0-9]/g, ""), 10);
        return isNaN(n) ? undefined : n;
    }

    function runtimeToMinutes(runtime) {
        var total = 0;
        String(runtime || "").split(/\s+/).forEach(function (part) {
            var hours = part.match(/^(\d+)h$/i);
            var minutes = part.match(/^(\d+)m$/i);
            if (hours) total += parseInt(hours[1], 10) * 60;
            if (minutes) total += parseInt(minutes[1], 10);
        });
        return total || undefined;
    }

    function payload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed) return parsed;
        return { id: String(url || "") };
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&#(\d+);/g, function (_, n) { return String.fromCodePoint(parseInt(n, 10)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, n) { return String.fromCodePoint(parseInt(n, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/\s+/g, " ")
            .trim();
    }

    function nodeText(node) {
        return decodeHtml(node && node.textContent || "");
    }

    function attr(node) {
        if (!node || !node.getAttribute) return "";
        for (var i = 1; i < arguments.length; i++) {
            var value = node.getAttribute(arguments[i]);
            if (value) return String(value).trim();
        }
        return "";
    }

    function qsa(root, selector) {
        try {
            return Array.from(root && root.querySelectorAll ? root.querySelectorAll(selector) : []);
        } catch (_) {
            return [];
        }
    }

    function qs(root, selector) {
        try {
            return root && root.querySelector ? root.querySelector(selector) : null;
        } catch (_) {
            return null;
        }
    }

    async function parseDocument(html) {
        return await parseHtml(String(html || "").replace(/<style\b[^>]*>[\s\S]*?<\/style>/gi, ""));
    }

    function buildItem(config, id, title, type, posterUrl) {
        var cleanTitle = trim(title);
        if (/<img\b/i.test(cleanTitle)) {
            var alt = cleanTitle.match(/alt=["']([^"']+)["']/i);
            cleanTitle = alt ? decodeHtml(alt[1]) : "";
        }
        return new MultimediaItem({
            title: cleanTitle || config.name,
            url: payload({ providerId: config.id, id: String(id || ""), title: cleanTitle || "" }),
            posterUrl: posterUrl || config.poster(id),
            type: type || "series"
        });
    }

    function mapHomeCard(config, node) {
        var link = qs(node, "a");
        var id = attr(link, "data-post") || attr(node, "data-post");
        if (!id) return null;
        var image = qs(node, ".card-img-container img, .top10-img img, img");
        var title = attr(image, "alt", "title") || attr(link, "title", "aria-label") || nodeText(qs(node, ".title, h3, h4, p")) || "";
        return buildItem(config, id, title, "series", config.poster(id));
    }

    function mapSearchResult(config, row) {
        if (!row || !row.id) return null;
        return buildItem(config, row.id, row.t, "series", config.poster(row.id));
    }

    function buildActor(name) {
        return new Actor({ name: trim(name) });
    }

    function buildEpisode(config, title, episode) {
        return new Episode({
            name: trim(episode && episode.t) || title,
            url: payload({ providerId: config.id, id: episode && episode.id, title: title }),
            season: numberFrom(episode && episode.s) || 1,
            episode: numberFrom(episode && episode.ep) || 1,
            runtime: numberFrom(episode && episode.time),
            posterUrl: config.episodePoster(episode && episode.id)
        });
    }

    async function fetchEpisodes(config, token, title, seriesId, seasonId, page) {
        var episodes = [];
        var pg = page || 1;
        while (true) {
            var url = MAIN_URL + "/mobile" + config.prefix + "/episodes.php?s=" + encodeURIComponent(seasonId) + "&series=" + encodeURIComponent(seriesId) + "&t=" + unixTime() + "&page=" + pg;
            var res = await requestGet(url, pageHeaders(config, token, MAIN_URL + "/home"));
            var json = parseJsonSafe(res.body, {});
            (json.episodes || []).forEach(function (row) {
                if (row && row.id) episodes.push(buildEpisode(config, title, row));
            });
            if (Number(json.nextPageShow || 0) === 0) break;
            pg++;
        }
        return episodes;
    }

    async function mapConcurrent(items, limit, fn) {
        var out = new Array(items.length);
        var index = 0;
        async function worker() {
            while (index < items.length) {
                var i = index++;
                out[i] = await fn(items[i], i).catch(function () { return null; });
            }
        }
        var workers = [];
        var count = Math.min(limit || 4, items.length);
        for (var i = 0; i < count; i++) workers.push(worker());
        await Promise.all(workers);
        return out;
    }

    function buildNewTvHeaders(ott, extra) {
        return withHeaders(NEWTV_BASE_HEADERS, withHeaders({ "Ott": ott }, extra || {}));
    }

    async function resolveApiUrl() {
        if (resolvedApiUrl) return resolvedApiUrl;
        for (var i = 0; i < NEWTV_DOMAINS.length; i++) {
            var base = decodeBase64String(NEWTV_DOMAINS[i]).replace(/\/+$/, "");
            if (!base) continue;
            try {
                var res = await requestGet(base + "/checknewtv.php", NEWTV_BASE_HEADERS);
                var json = parseJsonSafe(res.body, {});
                if (json && json.token_hash) {
                    resolvedApiUrl = decodeBase64String(json.token_hash).replace(/\/+$/, "");
                    if (resolvedApiUrl) return resolvedApiUrl;
                }
            } catch (_) {}
        }
        throw new Error("Failed to resolve NewTV API base URL");
    }

    function proxifyUrl(url, headers, referer) {
        return "MAGIC_PROXY_v2" + encodeBase64String(JSON.stringify({
            url: url,
            headers: headers || {},
            options: {
                referer: referer || "",
                mirrorHosts: hostOf(url) ? [hostOf(url)] : []
            }
        }));
    }

    function hostOf(url) {
        try {
            return new URL(String(url)).hostname;
        } catch (_) {
            return "";
        }
    }

    function parseAttributeList(value) {
        var out = {};
        var text = String(value || "");
        var re = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/gi;
        var match;
        while ((match = re.exec(text)) !== null) {
            out[match[1].toUpperCase()] = String(match[2] || "").replace(/^"|"$/g, "");
        }
        return out;
    }

    function qualityFromInf(line, uri) {
        var attrs = parseAttributeList(String(line || "").replace(/^#EXT-X-STREAM-INF:/i, ""));
        var res = String(attrs.RESOLUTION || "").match(/x(\d+)/i);
        if (res) return parseInt(res[1], 10) || 0;
        var bw = parseInt(attrs["AVERAGE-BANDWIDTH"] || attrs.BANDWIDTH || "0", 10);
        if (bw >= 7000000) return 2160;
        if (bw >= 3500000) return 1080;
        if (bw >= 1500000) return 720;
        if (bw >= 800000) return 480;
        if (bw >= 400000) return 360;
        var text = String(uri || "");
        var match = text.match(/(\d{3,4})p/i);
        return match ? parseInt(match[1], 10) || 0 : 0;
    }

    function mediaGroupLines(lines, streamAttrs) {
        var groups = {};
        ["AUDIO", "SUBTITLES", "CLOSED-CAPTIONS"].forEach(function (key) {
            if (streamAttrs[key] && streamAttrs[key] !== "NONE") groups[key] = streamAttrs[key];
        });
        return lines.filter(function (line) {
            if (!/^#EXT-X-MEDIA:/i.test(line)) return false;
            var attrs = parseAttributeList(line.replace(/^#EXT-X-MEDIA:/i, ""));
            var type = String(attrs.TYPE || "").toUpperCase();
            return groups[type] && attrs["GROUP-ID"] === groups[type];
        });
    }

    function rewriteMediaLine(line, masterUrl, headers, referer) {
        return line.replace(/URI="([^"]+)"/i, function (_, uri) {
            return 'URI="' + proxifyUrl(absoluteUrl(masterUrl, uri), headers, referer) + '"';
        });
    }

    function buildVariantMaster(masterUrl, mediaLines, streamInfLine, variantUrl, headers, referer) {
        var rewritten = ["#EXTM3U", "#EXT-X-VERSION:3"];
        mediaLines.forEach(function (line) {
            rewritten.push(rewriteMediaLine(line, masterUrl, headers, referer));
        });
        rewritten.push(streamInfLine);
        rewritten.push(proxifyUrl(variantUrl, headers, referer));
        return "magic_m3u8:" + encodeBase64String(rewritten.join("\n"));
    }

    function buildStream(url, source, quality) {
        var stream = new StreamResult({
            url: url,
            source: source,
            quality: quality || 0,
            type: "hls",
            headers: {}
        });
        stream.quality = quality || 0;
        stream.type = "hls";
        return stream;
    }

    async function expandHls(masterUrl, headers, source, referer) {
        var streams = [
            buildStream(proxifyUrl(masterUrl, headers, referer), source + " [Adaptive]", 0)
        ];
        var res = await requestGet(masterUrl, headers).catch(function () { return null; });
        var text = String(res && res.body || "");
        if (!/#EXTM3U/i.test(text) || text.indexOf("#EXT-X-STREAM-INF") === -1) return streams;

        var lines = text.split(/\r?\n/).map(function (line) { return String(line || "").trim(); }).filter(Boolean);
        var seen = {};
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i];
            if (!/^#EXT-X-STREAM-INF:/i.test(line)) continue;
            var uri = "";
            for (var j = i + 1; j < lines.length; j++) {
                if (lines[j] && lines[j].charAt(0) !== "#") {
                    uri = lines[j];
                    break;
                }
            }
            if (!uri) continue;
            var variantUrl = absoluteUrl(masterUrl, uri);
            var quality = qualityFromInf(line, uri);
            var streamAttrs = parseAttributeList(line.replace(/^#EXT-X-STREAM-INF:/i, ""));
            var groups = mediaGroupLines(lines, streamAttrs);
            var playable = groups.length
                ? buildVariantMaster(masterUrl, groups, line, variantUrl, headers, referer)
                : proxifyUrl(variantUrl, headers, referer);
            var key = playable + "|" + quality;
            if (seen[key]) continue;
            seen[key] = true;
            streams.push(buildStream(playable, source + (quality ? " [" + quality + "p]" : " [HLS]"), quality));
        }
        streams.sort(function (a, b) {
            return Number(b.quality || 0) - Number(a.quality || 0);
        });
        return streams;
    }

    async function getHome(cb) {
        try {
            var config = selectedProvider();
            var token = await bypass();
            var url = MAIN_URL + "/mobile/home?app=1";
            var res = await requestGet(url, pageHeaders(config, token, url));
            var doc = await parseDocument(res.body);
            var sections = {};
            qsa(doc, ".tray-container, #top10").forEach(function (section) {
                var title = nodeText(qs(section, "h2, span")) || "Home";
                var items = qsa(section, "article, .top10-post").map(function (node) {
                    return mapHomeCard(config, node);
                }).filter(Boolean);
                if (items.length) sections[title] = items;
            });
            cb({ success: true, data: sections });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_HOME_FAILED", message: String(e && e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var config = selectedProvider();
            if (!config.search) return cb({ success: true, data: [] });
            var token = await bypass();
            var url = MAIN_URL + "/mobile" + config.prefix + "/search.php?s=" + encodeURIComponent(query || "") + "&t=" + unixTime();
            var res = await requestGet(url, pageHeaders(config, token, MAIN_URL + "/home"));
            var json = parseJsonSafe(res.body, {});
            var items = (json.searchResult || []).map(function (row) {
                return mapSearchResult(config, row);
            }).filter(Boolean);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_SEARCH_FAILED", message: String(e && e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var input = parsePayload(url);
            var config = PROVIDERS[String(input.providerId || "").toLowerCase()] || selectedProvider();
            var id = String(input.id || "");
            var token = await bypass();
            var detailUrl = MAIN_URL + "/mobile" + config.prefix + "/post.php?id=" + encodeURIComponent(id) + "&t=" + unixTime();
            var res = await requestGet(detailUrl, pageHeaders(config, token, MAIN_URL + "/home"));
            var data = parseJsonSafe(res.body, {});
            var title = trim(data.title || input.title || config.name);
            var rawEpisodes = data.episodes || [];
            var isMovie = !rawEpisodes.length || rawEpisodes[0] == null;
            var episodes = [];

            if (isMovie) {
                episodes.push(new Episode({
                    name: title,
                    url: payload({ providerId: config.id, id: id, title: title }),
                    season: 1,
                    episode: 1
                }));
            } else {
                rawEpisodes.filter(Boolean).forEach(function (row) {
                    episodes.push(new Episode(Object.assign({}, buildEpisode(config, title, row), {
                        posterUrl: config.initialEpisodePoster(row.id)
                    })));
                });

                var tasks = [];
                if (Number(data.nextPageShow || 0) === 1 && data.nextPageSeason) {
                    tasks.push({ seasonId: data.nextPageSeason, page: 2 });
                }
                (data.season || []).slice(0, Math.max(0, (data.season || []).length - 1)).forEach(function (season) {
                    if (season && season.id) tasks.push({ seasonId: season.id, page: 1 });
                });
                var extra = await mapConcurrent(tasks, 4, function (task) {
                    return fetchEpisodes(config, token, title, id, task.seasonId, task.page);
                });
                extra.forEach(function (rows) {
                    (rows || []).forEach(function (ep) { episodes.push(ep); });
                });
            }

            var genres = String(data.genre || "").split(",").map(trim).filter(Boolean);
            var cast = String(data.cast || "").split(",").map(trim).filter(Boolean).slice(0, 30).map(buildActor);
            var recommendations = (data.suggest || []).map(function (row) {
                return row && row.id ? buildItem(config, row.id, "", "series", config.suggestPoster(row.id)) : null;
            }).filter(Boolean);

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: payload({ providerId: config.id, id: id, title: title }),
                    posterUrl: config.poster(id),
                    bannerUrl: config.background(id),
                    type: isMovie ? "movie" : "series",
                    description: trim(data.desc),
                    year: numberFrom(data.year),
                    score: parseFloat(String(data.match || "").replace(/IMDb/i, "").trim()) || undefined,
                    duration: runtimeToMinutes(data.runtime),
                    contentRating: trim(data.ua) || undefined,
                    cast: cast,
                    tags: genres,
                    recommendations: recommendations,
                    episodes: episodes
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_LOAD_FAILED", message: String(e && e.message || e) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            var input = parsePayload(url);
            var config = PROVIDERS[String(input.providerId || "").toLowerCase()] || selectedProvider();
            var apiBase = await resolveApiUrl();
            var id = String(input.id || "");
            var res = await requestGet(apiBase + "/newtv/player.php?id=" + encodeURIComponent(id), buildNewTvHeaders(config.playerOtt, { "Usertoken": "" }));
            var json = parseJsonSafe(res.body, {});
            if (json.status !== "ok" || !json.video_link) return cb({ success: true, data: [] });
            var referer = json.referer || apiBase;
            var streamHeaders = {
                "User-Agent": NEWTV_USER_AGENT,
                "Accept": "*/*",
                "Referer": referer,
                "Cookie": "hd=on"
            };
            var streams = await expandHls(json.video_link, streamHeaders, config.name, referer);
            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_STREAMS_FAILED", message: String(e && e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
