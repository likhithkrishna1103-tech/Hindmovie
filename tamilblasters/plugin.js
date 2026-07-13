(function () {
    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // var manifest is injected at runtime

    // ============================================================
    // Constants
    // ============================================================
    var BASE_URL = String((typeof manifest !== "undefined" && manifest.baseUrl) || "https://www.1tamilblasters.pro").replace(/\/+$/, "");
    var UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0";
    var HEADERS = { "User-Agent": UA, "Referer": BASE_URL + "/" };

    // StreamHG (hgcloud.to) loader -> serves player on any of these mirror hosts.
    // Extracted from the dmca[] array inside hgcloud.to/main.js.
    var HG_MIRRORS = [
        "hgplaycdn.com",
        "hglamioz.com",
        "niramirus.com",
        "playnixes.com",
        "medixiru.com",
        "audinifer.com"
    ];

    // Homepage categories (real WP category slugs verified live).
    var CATEGORIES = [
        ["Tamil Movies", "/category/tamil-movies-2026/page/"],
        ["Telugu Movies", "/category/telugu-movies-2026/page/"],
        ["Hindi Movies", "/category/hindi-movies-2026/page/"],
        ["Malayalam Movies", "/category/malayalam-movies-2026/page/"],
        ["Kannada Movies", "/category/kannada-movies-2026/page/"],
        ["Tamil Dubbed", "/category/tamil-dubbed-movies/page/"]
    ];

    // ============================================================
    // Small utilities
    // ============================================================
    function decodeEntities(v) {
        return String(v || "")
            .replace(/&#(\d+);/g, function (_, d) { return String.fromCharCode(Number(d)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, h) { return String.fromCharCode(parseInt(h, 16)); })
            .replace(/&nbsp;/gi, " ").replace(/&amp;/gi, "&").replace(/&quot;/gi, '"')
            .replace(/&#39;/gi, "'").replace(/&apos;/gi, "'").replace(/&lt;/gi, "<").replace(/&gt;/gi, ">")
            .replace(/&#8211;/g, "-").replace(/&#8212;/g, "-");
    }
    function cleanText(v) { return decodeEntities(String(v || "").replace(/<[^>]+>/g, " ")).replace(/\s+/g, " ").trim(); }
    function absUrl(u) {
        if (!u) return "";
        u = decodeEntities(u).trim();
        if (/^https?:\/\//i.test(u)) return u;
        if (u.indexOf("//") === 0) return "https:" + u;
        if (u.charAt(0) === "/") return BASE_URL + u;
        return BASE_URL + "/" + u;
    }
    function inferType(title) {
        return /\b(s\d{1,2}|season\s*\d+|ep\s*\d+|episode|series)\b/i.test(String(title || "")) ? "series" : "movie";
    }
    function qualityFromText(t) {
        var l = String(t || "").toLowerCase();
        if (l.indexOf("2160") > -1 || l.indexOf("4k") > -1) return "4K";
        if (l.indexOf("1080") > -1) return "1080p";
        if (l.indexOf("720") > -1) return "720p";
        if (l.indexOf("480") > -1) return "480p";
        if (l.indexOf("360") > -1) return "360p";
        return "Auto";
    }

    // ============================================================
    // HTTP helpers (with native http_parallel + caching)
    // ============================================================
    var TEXT_CACHE = {};
    function cacheGet(key) {
        var e = TEXT_CACHE[key];
        if (!e) return null;
        if (Date.now() - e.t > 600000) { delete TEXT_CACHE[key]; return null; }
        return e.v;
    }
    function bodyOf(res) { return String((res && (res.body || res.text)) || ""); }

    async function httpGet(url, extraHeaders) {
        var key = url;
        var cached = cacheGet(key);
        if (cached != null) return cached;
        try {
            var res = await http_get(url, Object.assign({}, HEADERS, extraHeaders || {}));
            var body = bodyOf(res);
            TEXT_CACHE[key] = { v: body, t: Date.now() };
            return body;
        } catch (_) { return ""; }
    }

    // Native Dart parallel GET with Promise.all fallback. Returns [{url, body}].
    async function httpParallelGet(requests) {
        var items = (requests || []).filter(function (r) { return r && r.url; });
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var pr = await http_parallel(items.map(function (it) {
                    return { method: "GET", url: it.url, headers: it.headers || HEADERS };
                }));
                return items.map(function (it, i) {
                    var r = pr && pr[i];
                    return { url: it.url, body: bodyOf(r) };
                });
            } catch (_) { /* fall through */ }
        }
        return await Promise.all(items.map(function (it) {
            return http_get(it.url, it.headers || HEADERS)
                .then(function (r) { return { url: it.url, body: bodyOf(r) }; })
                .catch(function () { return { url: it.url, body: "" }; });
        }));
    }

    // ============================================================
    // Card parsing (uses native parse_html, regex fallback)
    // ============================================================
    async function parseCards(html) {
        var items = [];
        var seen = {};
        var blocks = [];

        if (typeof parse_html === "function") {
            try {
                var els = await parse_html(String(html || ""), "article", null);
                blocks = (els || []).map(function (e) { return (e && (e.innerHTML || e.html)) || ""; });
            } catch (_) { blocks = []; }
        }
        if (!blocks.length) {
            var re = /<article\b[\s\S]*?<\/article>/gi, m;
            while ((m = re.exec(String(html || "")))) blocks.push(m[0]);
        }

        blocks.forEach(function (block) {
            // Prefer the entry-title anchor for the canonical link + title.
            var titleAnchor = block.match(/<h2[^>]*blog-entry-title[^>]*>\s*<a[^>]+href="([^"]*)"[^>]*>([\s\S]*?)<\/a>/i);
            var href = "", title = "";
            if (titleAnchor) { href = titleAnchor[1]; title = cleanText(titleAnchor[2]); }
            if (!href) {
                var anyA = block.match(/<a[^>]+href="([^"]*)"[^>]*rel="bookmark"/i);
                if (anyA) href = anyA[1];
            }
            var img = block.match(/<img[^>]+(?:data-src|src)="([^"]*)"[^>]*>/i);
            var poster = img ? absUrl(img[1]) : "";
            if (!title && img) {
                var alt = img[0].match(/alt="([^"]*)"/i);
                if (alt) title = cleanText(alt[1]);
            }
            href = absUrl(href);
            title = title.replace(/^Download\s+/i, "");
            if (!href || !title || /javascript/i.test(href) || seen[href]) return;
            seen[href] = 1;
            items.push(new MultimediaItem({
                title: title, url: href, posterUrl: poster,
                type: inferType(title), headers: HEADERS
            }));
        });
        return items;
    }

    // ============================================================
    // Detail page extraction
    // ============================================================

    // Extract iframe src URLs (case-insensitive, handles <IFRAME SRC="...">).
    async function extractIframes(html) {
        var out = [];
        if (typeof parse_html === "function") {
            try {
                var rows = await parse_html(String(html || ""), "iframe", "src");
                (rows || []).forEach(function (r) {
                    var s = r && (r.attr || r.src || r.href || "");
                    if (s) out.push(String(s).trim());
                });
            } catch (_) { /* fall through */ }
        }
        if (!out.length) {
            // Case-insensitive, handles <IFRAME SRC=...> and quoted/unquoted values.
            var re = /<iframe\b[^>]*?\bsrc\s*=\s*(?:"([^"]*)"|'([^']*)'|([^\s>]*))/gi;
            var m;
            while ((m = re.exec(String(html || "")))) {
                var val = m[1] || m[2] || m[3];
                if (val) out.push(val);
            }
        }
        // de-dup
        var seen = {}, res = [];
        out.forEach(function (u) { if (u && !seen[u]) { seen[u] = 1; res.push(u); } });
        return res;
    }

    // Like the cs3's extractVideos(): pair each iframe with its nearest preceding
    // <p> sibling for a human-readable label.
    function extractIframeWithLabels(html) {
        var text = String(html || "");
        var pairs = [];

        // Find all iframes with their positions.
        var iframeRe = /<iframe\b[^>]*?\bsrc\s*=\s*(?:"([^"]*)"|'([^']*)'|([^\s>]*))/gi;
        var positions = [];
        var m;
        while ((m = iframeRe.exec(text))) {
            var val = m[1] || m[2] || m[3];
            if (val) {
                positions.push({ src: val, index: m.index });
            }
        }

        // Find all <p> elements with their positions.
        var pRe = /<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var pTags = [];
        var pm;
        while ((pm = pRe.exec(text))) {
            pTags.push({ text: cleanText(pm[1]), index: pm.index, end: pm.index + pm[0].length });
        }

        // For each iframe, find the preceding <p> (closest before the iframe).
        for (var i = 0; i < positions.length; i++) {
            var ifr = positions[i];
            var label = "";
            var closestDist = Infinity;
            for (var j = 0; j < pTags.length; j++) {
                var pTag = pTags[j];
                if (pTag.end < ifr.index && (ifr.index - pTag.end) < closestDist) {
                    var t = pTag.text.replace(/^(?:Watch\s*(?:Online|Now|Full|In\s*HD)\s*)+/i, "").trim();
                    if (t && t.length > 1 && t.length < 60) {
                        label = t;
                        closestDist = ifr.index - pTag.end;
                    }
                }
            }
            pairs.push({ src: absUrl(ifr.src), label: label || "Stream" });
        }

        return pairs;
    }

    function extractDownloadButtons(html) {
        var text = String(html || "");
        var results = [];
        // The page defines: const downloadLink = "https://<host>.icu/<path>.php?file="
        var baseM = text.match(/const\s+downloadLink\s*=\s*["']([^"']+)["']/i);
        var base = baseM ? baseM[1] : "";
        var re = /data-file="([^"]+)"/gi, m;
        while ((m = re.exec(text))) {
            var file = decodeEntities(m[1]); // decodes &amp; -> &
            var full = base ? (base + file) : "";
            if (!full) continue;
            var label = "Download " + qualityFromText(file);
            var sizeM = file.match(/(\d+(?:\.\d+)?\s*[GM]B)/i);
            if (sizeM) label += " (" + sizeM[1] + ")";
            results.push({ url: full, quality: qualityFromText(file), label: label });
        }
        return results;
    }

    function extractMeta(html) {
        var text = String(html || "");
        var title = "";
        var t = text.match(/<h1[^>]*entry-title[^>]*>([\s\S]*?)<\/h1>/i) || text.match(/<title>([\s\S]*?)<\/title>/i);
        if (t) title = cleanText(t[1]).replace(/\s*[-|]\s*Tamil ?Blasters.*$/i, "").replace(/^Download\s+/i, "");
        var poster = "";
        var og = text.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/i);
        if (og) poster = absUrl(og[1]);
        var desc = "";
        var d = text.match(/<meta[^>]+name="description"[^>]+content="([^"]+)"/i);
        if (d) desc = cleanText(d[1]);
        var year = 0;
        var y = title.match(/\((\d{4})\)/) || title.match(/\b(19|20)\d{2}\b/);
        if (y) year = parseInt(y[0].replace(/[()]/g, ""), 10) || 0;
        return { title: title, poster: poster, desc: desc, year: year };
    }

    // ============================================================
    // Stream resolution (getAndUnpack the P.A.C.K.E.R. player)
    // ============================================================
    function manualUnpack(packed) {
        try {
            var mm = packed.match(/\}\s*\(\s*'([\s\S]*?)'\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*'([\s\S]*?)'\.split\('\|'\)/);
            if (!mm) return "";
            var payload = mm[1].replace(/\\'/g, "'").replace(/\\\\/g, "\\");
            var base = parseInt(mm[2], 10);
            var count = parseInt(mm[3], 10);
            var words = mm[4].split("|");
            var chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            function enc(n) {
                if (n === 0) return "0";
                var s = "";
                while (n > 0) { s = chars.charAt(n % base) + s; n = Math.floor(n / base); }
                return s;
            }
            var dict = {};
            for (var i = 0; i < count; i++) {
                var k = enc(i);
                dict[k] = (i < words.length && words[i] !== "") ? words[i] : k;
            }
            return payload.replace(/\b\w+\b/g, function (w) { return dict[w] !== undefined ? dict[w] : w; });
        } catch (_) { return ""; }
    }

    function unpackPlayer(html) {
        var text = String(html || "");
        // Isolate the P.A.C.K.E.R. eval block (getAndUnpack needs the script, not the whole page).
        var packedMatch = text.match(/eval\(function\(p,a,c,k,e,d\)[\s\S]*?\.split\('\|'\)(?:,0)?\)\)/);
        var packed = packedMatch ? packedMatch[0] : "";

        if (typeof getAndUnpack === "function") {
            try {
                var u = getAndUnpack(packed || text);
                if (u && String(u).length !== (packed || text).length) return String(u);
            } catch (_) { /* fall through */ }
        }
        if (packed) {
            var manual = manualUnpack(packed);
            if (manual) return manual;
        }
        return text; // fall back to raw (in case sources are inline)
    }

    function extractM3u8(unpacked) {
        var s = String(unpacked || "");
        // Match the .cs3 reference intercept filter: (m3u8|master\.txt).
        // StreamHG player defines links={"hls2":"...master.m3u8","hls4":"/stream/...master.m3u8","hls3":"...master.txt"}.
        var STREAM_RE = "(?:m3u8|master\\.txt)";

        // 1) Explicit hls2/hls4/hls key with an absolute stream URL.
        var keyed = s.match(new RegExp("[\"'](?:hls2|hls4|hls|file)[\"']\\s*:\\s*[\"'](https?:\\/\\/[^\"']+" + STREAM_RE + "[^\"']*)[\"']", "i"));
        if (keyed) return keyed[1];

        // 2) jwplayer sources:[{file:"..."}] (luluvdo etc.)
        var file = s.match(new RegExp("file\\s*:\\s*[\"'](https?:\\/\\/[^\"']+" + STREAM_RE + "[^\"']*)[\"']", "i"));
        if (file) return file[1];

        // 3) hls3 master.txt (absolute) as a fallback variant.
        var txt = s.match(/["']hls3["']\s*:\s*["'](https?:\/\/[^"']+master\.txt[^"']*)["']/i);
        if (txt) return txt[1];

        // 4) Generic absolute stream URL (m3u8 or master.txt).
        var gen = s.match(new RegExp("(https?:\\/\\/[^\"'\\s\\\\]+" + STREAM_RE + "[^\"'\\s\\\\]*)", "i"));
        if (gen) return gen[1];
        return "";
    }

    // Given a list of embed iframe URLs, resolve each to an m3u8 StreamResult.
    async function resolveEmbeds(iframes) {
        var streams = [];
        for (var i = 0; i < iframes.length; i++) {
            var url = iframes[i];
            var idM = url.match(/\/e\/([A-Za-z0-9]+)/) || url.match(/\/(?:embed|v|d)\/([A-Za-z0-9]+)/);
            if (!idM) continue;
            var id = idM[1];
            var host = "";
            try { host = new URL(url).hostname.replace(/^www\./, ""); } catch (_) { host = ""; }

            var candidates = [];
            if (host === "hgcloud.to" || HG_MIRRORS.indexOf(host) > -1) {
                // StreamHG loader -> try all mirrors in parallel.
                candidates = HG_MIRRORS.map(function (m) {
                    return { url: "https://" + m + "/e/" + id, headers: { "User-Agent": UA, "Referer": "https://hgcloud.to/" } };
                });
            } else {
                // Other hosts (luluvdo, filemoon, etc.) serve the player directly.
                candidates = [{ url: url, headers: { "User-Agent": UA, "Referer": BASE_URL + "/" } }];
            }

            var responses = await httpParallelGet(candidates);
            var m3u8 = "", chosenHost = host;
            for (var j = 0; j < responses.length; j++) {
                var body = responses[j].body;
                if (!body || !/function\(p,a,c,k,e,d\)/.test(body)) continue;
                var got = extractM3u8(unpackPlayer(body));
                if (got) {
                    m3u8 = got;
                    try { chosenHost = new URL(responses[j].url).hostname; } catch (_) {}
                    break;
                }
            }
            if (m3u8) {
                var srcLabel = (host === "hgcloud.to" || HG_MIRRORS.indexOf(host) > -1) ? "StreamHG" : (host || "Embed");
                streams.push(new StreamResult({
                    url: m3u8,
                    source: srcLabel + " " + qualityFromText(m3u8),
                    quality: qualityFromText(m3u8),
                    headers: { "User-Agent": UA, "Referer": "https://" + chosenHost + "/" }
                }));
            }
        }
        return streams;
    }

    // ============================================================
    // Runtime functions
    // ============================================================
    async function getHome(cb) {
        try {
            var reqs = CATEGORIES.map(function (c) { return { url: BASE_URL + c[1] + "1", headers: HEADERS, name: c[0] }; });
            var pages = await httpParallelGet(reqs);
            var data = {};
            for (var i = 0; i < pages.length; i++) {
                var items = await parseCards(pages[i].body);
                if (items.length) data[CATEGORIES[i][0]] = items;
            }
            cb({ success: true, data: data });
        } catch (e) {
            cb({ success: false, errorCode: "GET_HOME_ERROR", message: e.stack || String(e) });
        }
    }

    async function search(query, cb) {
        try {
            var html = await httpGet(BASE_URL + "/?s=" + encodeURIComponent(query));
            var items = await parseCards(html);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.stack || String(e) });
        }
    }

    function parseSeasonEpisode(title) {
        var t = String(title || "");
        var season = 1, episode = 1, isSeries = false;
        var se = t.match(/\bS(\d{1,2})\s*[-_ ]?\s*EP?\s*(\d{1,3})\b/i);
        if (se) { season = parseInt(se[1], 10); episode = parseInt(se[2], 10); isSeries = true; }
        else {
            var sMatch = t.match(/\b(?:Season|S)\s*(\d{1,2})\b/i);
            var eMatch = t.match(/\b(?:Episode|Ep)\s*(\d{1,3})\b/i);
            if (sMatch) { season = parseInt(sMatch[1], 10); isSeries = true; }
            if (eMatch) { episode = parseInt(eMatch[1], 10); isSeries = true; }
        }
        if (/\b(series|web[- ]?series|complete)\b/i.test(t)) isSeries = true;
        return { season: season || 1, episode: episode || 1, isSeries: isSeries };
    }

    async function load(url, cb) {
        try {
            var html = await httpGet(url);
            var meta = extractMeta(html);
            var se = parseSeasonEpisode(meta.title);
            var type = se.isSeries ? "series" : "movie";

            if (type === "movie") {
                // Movie: single S1E1 episode with the page URL as payload.
                var payload = JSON.stringify({ sourceUrl: url, title: meta.title, type: type });
                var episode = new Episode({
                    name: "Movie",
                    url: payload,
                    season: 1,
                    episode: 1,
                    description: meta.desc,
                    posterUrl: meta.poster || undefined,
                    headers: HEADERS,
                    dubStatus: "none"
                });
                var item = new MultimediaItem({
                    title: meta.title || "Tamilblasters",
                    url: url,
                    posterUrl: meta.poster,
                    type: "movie",
                    description: meta.desc,
                    year: meta.year || undefined,
                    headers: HEADERS,
                    playbackPolicy: "VPN Recommended",
                    episodes: [episode]
                });
                return cb({ success: true, data: item });
            }

            // --- SERIES ---
            // cs3-style: one Episode per iframe, paired with preceding <p> label.
            var iframePairs = extractIframeWithLabels(html);
            var episodes = [];
            var epNum = se.episode;

            if (iframePairs.length) {
                for (var i = 0; i < iframePairs.length; i++) {
                    var pair = iframePairs[i];
                    // Episode URL = JSON that loadStreams will parse to resolve this single iframe.
                    var epPayload = JSON.stringify({
                        url: pair.src,
                        sourceUrl: url,
                        label: pair.label,
                        season: se.season,
                        episode: epNum
                    });
                    episodes.push(new Episode({
                        name: pair.label,
                        url: epPayload,
                        season: se.season,
                        episode: epNum + i,
                        description: meta.desc,
                        posterUrl: meta.poster || undefined,
                        headers: HEADERS,
                        dubStatus: "none"
                    }));
                }
            } else {
                // No iframes found — still return the episode so loadStreams can fetch the page.
                var fallbackPayload = JSON.stringify({ sourceUrl: url, title: meta.title, type: type });
                episodes.push(new Episode({
                    name: "Season " + se.season + " Episode " + se.episode,
                    url: fallbackPayload,
                    season: se.season,
                    episode: se.episode,
                    description: meta.desc,
                    posterUrl: meta.poster || undefined,
                    headers: HEADERS,
                    dubStatus: "none"
                }));
            }

            var item = new MultimediaItem({
                title: meta.title || "Tamilblasters",
                url: url,
                posterUrl: meta.poster,
                type: "series",
                description: meta.desc,
                year: meta.year || undefined,
                headers: HEADERS,
                playbackPolicy: "VPN Recommended",
                episodes: episodes
            });
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.stack || String(e) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            // Try to parse as JSON payload (from load())
            var payload = null;
            try { payload = JSON.parse(url); } catch (_) {}

            if (payload && payload.url) {
                // -- Series episode: resolve THIS specific iframe --
                var streams = await resolveEmbeds([payload.url]);

                // Also fetch the source page for download buttons.
                if (payload.sourceUrl) {
                    try {
                        var html = await httpGet(payload.sourceUrl);
                        var buttons = extractDownloadButtons(html);
                        buttons.forEach(function (b) {
                            streams.push(new StreamResult({
                                url: b.url,
                                source: b.label,
                                quality: b.quality,
                                headers: { "User-Agent": UA, "Referer": BASE_URL + "/" }
                            }));
                        });
                    } catch (_) {}
                }

                if (!streams.length) {
                    return cb({ success: false, errorCode: "NO_STREAMS", message: "No stream resolved for this episode." });
                }
                return cb({ success: true, data: streams });
            }

            // -- Movie / fallback: fetch the page, resolve ALL iframes + downloads --
            var sourceUrl = url;
            if (payload && payload.sourceUrl) sourceUrl = payload.sourceUrl;

            var html = await httpGet(sourceUrl);

            var iframes = await extractIframes(html);
            var buttons = extractDownloadButtons(html);

            var embedStreamsP = resolveEmbeds(iframes);
            var downloadStreams = buttons.map(function (b) {
                return new StreamResult({
                    url: b.url,
                    source: b.label,
                    quality: b.quality,
                    headers: { "User-Agent": UA, "Referer": BASE_URL + "/" }
                });
            });

            var embedStreams = await embedStreamsP;
            var all = embedStreams.concat(downloadStreams);

            if (!all.length) {
                return cb({ success: false, errorCode: "NO_STREAMS", message: "No embeds or download links found on page." });
            }
            cb({ success: true, data: all });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.stack || String(e) });
        }
    }

    // ============================================================
    // Exports
    // ============================================================
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
