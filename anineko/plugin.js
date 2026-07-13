(function () {
    "use strict";

    /**
     * AniNeko plugin (anineko.to) — self-contained, with embedded per-host extractors.
     *
     * Key design notes (verified against the live site + the skystream sandbox helpers):
     *  - The detail page server-renders ALL episodes as <article class="nv-info-episode-item">
     *    blocks (One Piece = 1169 of them, no pagination). We parse the grid with the
     *    native parse_html() helper (robust, no regex drift) -> consistent titles.
     *  - PERFORMANCE/COUNT FIX: the series plot is set ONCE on the MultimediaItem. It is
     *    NOT copied into every Episode (that previously produced ~1.4 MB of duplicated
     *    text and the app truncated the response to ~39 episodes). Episode objects stay small.
     *  - Per-episode metadata (thumb / air date / duration) comes from the schema.org
     *    TVEpisode JSON-LD on each /watch/{slug}/ep-N page, fetched in parallel via
     *    http_parallel and bounded by EP_META_CAP (first screen only, for speed).
     *  - Embeds (tab_0=HardSub, tab_1=SoftSub, tab_2=Dub) are EXTERNAL PLAYER PAGES. We
     *    resolve them with embedded extractors; packed P.A.C.K.E.R. embeds are deobfuscated
     *    natively via getAndUnpack().
     */

    var BASE_URL = (typeof manifest !== "undefined" && manifest && manifest.baseUrl) ? manifest.baseUrl : "https://anineko.to/";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36";
    var EP_META_CAP = 24; // per-episode JSON-LD enrichment cap (bounds latency; rest use series poster)

    function ensureSlash(u) { return (!u) ? u : (u.charAt(u.length - 1) === "/" ? u : u + "/"); }
    var BASE = ensureSlash(BASE_URL);

    // ---- helpers -----------------------------------------------------------
    function apiHeaders(extra) {
        var h = { "User-Agent": USER_AGENT, "Accept": "application/json, text/plain, */*", "X-Requested-With": "XMLHttpRequest", "Referer": BASE };
        if (extra) { for (var k in extra) if (extra.hasOwnProperty(k)) h[k] = extra[k]; }
        return h;
    }
    function htmlHeaders(extra) {
        var h = { "User-Agent": USER_AGENT, "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8", "X-Requested-With": "XMLHttpRequest", "Referer": BASE };
        if (extra) { for (var k in extra) if (extra.hasOwnProperty(k)) h[k] = extra[k]; }
        return h;
    }
    function parseJsonSafe(text, fallback) {
        try { return JSON.parse(String(text || "")); } catch (e) { return fallback; }
    }
    function absoluteUrl(path) {
        if (!path) return "";
        if (/^https?:\/\//i.test(path)) return path;
        if (path.charAt(0) === "/") return BASE + path.substring(1);
        return BASE + path;
    }
    function cleanText(s) {
        return String(s == null ? "" : s)
            .replace(/&amp;/g, "&").replace(/&lt;/g, "<").replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"').replace(/&#0?39;/g, "'").replace(/&nbsp;/g, " ")
            .replace(/\s+/g, " ").trim();
    }
    function decodeHtmlEntities(s) {
        return String(s || "")
            .replace(/&amp;/g, "&").replace(/&lt;/g, "<").replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"').replace(/&#0?39;/g, "'").replace(/&#x27;/gi, "'")
            .replace(/&nbsp;/g, " ");
    }
    function serverNameFromUrl(url) {
        var m = /^https?:\/\/([^\/]+)\//i.exec(url || "");
        if (!m) return "Server";
        var parts = m[1].replace(/^www\./i, "").split(".");
        var core = parts.length >= 2 ? parts[parts.length - 2] : m[1];
        return core.charAt(0).toUpperCase() + core.slice(1);
    }

    // ---- HTTP --------------------------------------------------------------
    async function httpGetText(url, headers) {
        var res = await http_get(url, headers || htmlHeaders());
        if (!res || res.status < 200 || res.status >= 400) throw new Error("HTTP " + (res ? res.status : "?") + " for " + url);
        return String(res.body || "");
    }

    // ---- Extractors (embed -> real StreamResult[]) -------------------------
    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: quality ? (source + " [" + quality + "p]") : source,
            quality: quality || undefined,
            headers: headers || {}
        });
    }
    function extractM3u8FromUnpacked(unpacked) {
        if (!unpacked) return "";
        var all = unpacked.match(/https?:\/\/[^\s"']+\.m3u8(?:\?[^\s"']*)?/gi) || [];
        if (all.length) return decodeHtmlEntities(all[0]);
        return "";
    }
    function extractSubtitleUrl(embedUrl) {
        if (!embedUrl) return "";
        var idx = embedUrl.indexOf("?");
        if (idx === -1) return "";
        var q = embedUrl.substring(idx + 1).split("&");
        for (var i = 0; i < q.length; i++) {
            var kv = q[i].split("=");
            var key = kv[0].toLowerCase();
            var val = kv[1] || "";
            if ((key === "sub" || key === "caption_1" || key === "c1_file" || key === "c1_file_1") && /^https?:\/\//i.test(val)) {
                return decodeURIComponent(val);
            }
        }
        return "";
    }

    // vivibebe.site -> /public/stream/<id>/master.m3u8
    async function resolveVivibebe(url, label) {
        var m = /^https?:\/\/vivibebe\.site\/([a-zA-Z0-9_-]+)/i.exec(url);
        if (!m) return [];
        var id = m[1];
        var m3u8 = "https://vivibebe.site/public/stream/" + id + "/master.m3u8";
        var res = await http_get(m3u8, { "User-Agent": USER_AGENT, "Referer": "https://vivibebe.site/" });
        if (!res || res.status !== 200) return [];
        return [buildStreamResult(m3u8, label || "AniNeko HD", { "User-Agent": USER_AGENT, "Referer": "https://vivibebe.site/" }, 0)];
    }

    // otakuhg.site / otakuvid.online / bibiemb.online -> P.A.C.K.E.R. packed -> signed m3u8.
    // Uses the native getAndUnpack() helper (no custom regex/tokenizer).
    async function resolveVidHide(url, label, refererHost) {
        var headers = { "User-Agent": USER_AGENT, "Referer": refererHost || "https://otakuhg.site/" };
        var res = await http_get(url, headers);
        if (!res || res.status !== 200) return [];
        var html = String(res.body || "");
        var unpacked = "";
        try { unpacked = getAndUnpack(html); } catch (e) { unpacked = ""; }
        var m3u8 = extractM3u8FromUnpacked(unpacked) || extractM3u8FromUnpacked(html);
        if (m3u8) return [buildStreamResult(m3u8, label || "AniNeko", headers, 0)];
        return [];
    }

    // playmogo.com /e/<id> -> DoodStream-style: /pass_md5/<token> then append random + expiry
    async function resolveDoodStream(url, label) {
        var headers = { "User-Agent": USER_AGENT, "Referer": "https://playmogo.com/" };
        var res = await http_get(url, headers);
        if (!res || res.status !== 200) return [];
        var html = String(res.body || "");
        var md5Match = /\/pass_md5\/[^'"]*/.exec(html);
        if (!md5Match) return [];
        var md5Url = "https://" + new URL(url).hostname + md5Match[0];
        var md5Res = await http_get(md5Url, { "User-Agent": USER_AGENT, "Referer": url });
        if (!md5Res || md5Res.status !== 200) return [];
        function makeid(length) {
            var result = "", chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            for (var i = 0; i < length; i++) result += chars.charAt(Math.floor(Math.random() * chars.length));
            return result;
        }
        // If the host ever ships an AES-wrapped URL, crypto.decryptAES(data, key, iv) is available here.
        var tokenMatch = /token=([^&]+)/.exec(md5Url);
        var token = tokenMatch ? tokenMatch[1] : "";
        var videoUrl = String(md5Res.body || "").trim() + makeid(10) + "?token=" + token + "&expiry=" + Date.now();
        return [buildStreamResult(videoUrl, label || "AniNeko Dood", { "User-Agent": USER_AGENT, "Referer": url }, 0)];
    }

    // Dispatcher: given an anineko embed URL, return resolved StreamResult[].
    async function resolveExtractorUrl(url, label) {
        if (!url) return [];
        var u = String(url);
        try {
            if (/vivibebe\.site/i.test(u)) return await resolveVivibebe(u, label || "AniNeko HD");
            if (/otakuhg\.site/i.test(u)) return await resolveVidHide(u, label || "AniNeko StreamHG", "https://otakuhg.site/");
            if (/otakuvid\.online|bibiemb\.online/i.test(u)) return await resolveVidHide(u, label || "AniNeko Earnvids", "https://otakuvid.online/");
            if (/playmogo\.com|dood/i.test(u)) return await resolveDoodStream(u, label || "AniNeko Dood");
            return [buildStreamResult(u, label || "AniNeko", { "User-Agent": USER_AGENT, "Referer": BASE }, 0)];
        } catch (e) {
            return [];
        }
    }

    // ---- Parsers -----------------------------------------------------------
    // Build episode list from parse_html() output (article.nv-info-episode-item -> innerHTML).
    function parseArticleBlocks(els) {
        var eps = [], seen = {};
        (els || []).forEach(function (el) {
            var block = el.innerHTML || "";
            var href = (block.match(/href="(\/watch\/[^"]+\/ep-\d+)"/i) || [])[1];
            if (!href) return;
            var epNum = (href.match(/ep-(\d+)/i) || [])[1];
            if (!epNum || seen[epNum]) return;
            seen[epNum] = true;
            // <strong> = "Episode N" label ; <span> = real episode title
            var strong = (block.match(/<strong>([^<]*)<\/strong>/i) || [])[1] || "";
            var span = (block.match(/<span>([^<]*)<\/span>/i) || [])[1] || "";
            var title = cleanText(span) || cleanText(strong) || ("Episode " + epNum);
            var badges = (block.match(/nv-info-episode-badges[^>]*>([\s\S]*?)<\/div>/i) || [])[1] || "";
            var badgeText = badges.toUpperCase();
            eps.push({
                episode: parseInt(epNum, 10),
                url: absoluteUrl(href),
                title: title,
                hasDub: /DUB/.test(badgeText),
                hasHsub: /HSUB/.test(badgeText),
                hasSub: /SUB/.test(badgeText)
            });
        });
        eps.sort(function (a, b) { return a.episode - b.episode; });
        return eps;
    }

    function parseHeroSlides(html) {
        var items = [], slideRe = /<article class="nv-hero-slide[^"]*"[^>]*>([\s\S]*?)<\/article>/gi, m;
        while ((m = slideRe.exec(html)) !== null) {
            var block = m[1];
            var bg = (block.match(/<img class="nv-hero-bg"[^>]*src="([^"]+)"/i) || [])[1] || "";
            var title = (block.match(/<h1 class="nv-hero-title"[^>]*>([^<]+)</i) || [])[1] || "";
            var link = (block.match(/<a class="nv-btn nv-btn-primary"[^>]*href="([^"]+)"/i) || [])[1] || "";
            if (!link) link = (block.match(/href="(\/watch\/[^"]+)"/i) || [])[1] || "";
            title = cleanText(title);
            if (!title || !link) continue;
            items.push({ title: title, url: absoluteUrl(link), posterUrl: bg ? absoluteUrl(bg) : "", bannerUrl: bg ? absoluteUrl(bg) : "" });
        }
        return items;
    }
    function parseServerBlocks(html) {
        var groups = { hsub: [], sub: [], dub: [] };
        var tabToGroup = { "tab_0": "hsub", "tab_1": "sub", "tab_2": "dub" };
        var btnRe = /<button class="nv-server-btn[^"]*"[^>]*?data-video="([^"]*)"[^>]*?data-tab="(tab_\d+)"[^>]*>([\s\S]*?)<\/button>/gi, m;
        while ((m = btnRe.exec(html)) !== null) {
            var video = m[1], tab = m[2], inner = m[3];
            var group = tabToGroup[tab] || "hsub";
            var nameMatch = inner.replace(/<[^>]+>/g, " ").replace(/\s+/g, " ").trim();
            var name = nameMatch.split("Hard Sub").join("").split("Soft Sub").join("").split("Sort Sub").join("").split("DUB").join("").trim() || serverNameFromUrl(video);
            groups[group].push({ video: video, name: name });
        }
        return groups;
    }
    function parseOgImage(html) { var m = html.match(/<meta property="og:image"[^>]*content="([^"]+)"/i); return m ? absoluteUrl(m[1]) : ""; }
    function parseBanner(html) {
        var m = html.match(/nv-info-bg[^>]*url\(\s*['"]?([^'")]+\.(?:webp|jpg|jpeg|png))['"]?\s*\)/i);
        return m ? absoluteUrl(m[1]) : "";
    }
    function parseDescription(html) { var m = html.match(/<meta name="description" content="([^"]*)"/i); return m ? cleanText(m[1]) : ""; }
    function parseGenres(html) {
        var out = [], seen = {}, re = /<a href="\/genres\/([^"]+)"[^>]*>([^<]+)</gi, m;
        while ((m = re.exec(html)) !== null) { var g = cleanText(m[2]); if (g && !seen[g]) { seen[g] = true; out.push(g); } }
        return out;
    }
    function parseStatusYear(html) {
        var status, year;
        if (/Currently Airing/i.test(html)) status = "ongoing";
        else if (/Finished Airing/i.test(html)) status = "completed";
        else if (/Not yet Aired|Upcoming/i.test(html)) status = "upcoming";
        var ym = html.match(/Release<\/span><strong>([^<]+)</i);
        if (ym) { var y = parseInt(cleanText(ym[1]), 10); if (!isNaN(y)) year = y; }
        return { status: status, year: year };
    }
    function durationToMinutes(d) {
        if (!d) return 0;
        var h = /(\d+)H/.exec(d), mm = /(\d+)M/.exec(d);
        var mins = 0;
        if (h) mins += parseInt(h[1], 10) * 60;
        if (mm) mins += parseInt(mm[1], 10);
        return mins;
    }
    // Parse the schema.org TVEpisode JSON-LD embedded on each /watch/{slug}/ep-N page.
    function parseEpisodeJsonLd(html) {
        try {
            var m = html.match(/<script type="application\/ld\+json">([\s\S]*?)<\/script>/i);
            if (!m) return null;
            var data = JSON.parse(m[1]);
            var arr = Array.isArray(data) ? data : [data];
            var ep = null;
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] && (arr[i]["@type"] === "TVEpisode" || arr[i].mainEntity)) { ep = arr[i].mainEntity || arr[i]; break; }
            }
            if (!ep) return null;
            var thumb = ep.thumbnailUrl || (ep.video && ep.video.thumbnailUrl && ep.video.thumbnailUrl[0]) || "";
            var air = ep.datePublished || ep.uploadDate || "";
            var dur = ep.duration || (ep.video && ep.video.duration) || "";
            return {
                thumbnailUrl: thumb ? absoluteUrl(thumb) : "",
                airDate: air ? String(air).slice(0, 10) : "",
                durationMin: durationToMinutes(dur),
                name: ep.name || "",
                episodeNumber: ep.episodeNumber || 0
            };
        } catch (e) { return null; }
    }
    function apiItemToMultimedia(it) {
        return new MultimediaItem({
            title: cleanText(it.title || ""),
            url: absoluteUrl(it.url || ""),
            posterUrl: it.image ? absoluteUrl(it.image) : "",
            type: "anime",
            headers: { "Referer": BASE },
            tags: (it.genres && it.genres.length) ? it.genres : undefined,
            description: it.meta ? cleanText(it.meta) : undefined
        });
    }

    // ---- Functions ---------------------------------------------------------
    async function getHome(cb) {
        try {
            var result = {};
            var homeHtml = "";
            try { homeHtml = await httpGetText(BASE, htmlHeaders()); } catch (e) {}
            var hero = parseHeroSlides(homeHtml);
            if (hero.length) {
                result["Trending"] = hero.map(function (h) {
                    return new MultimediaItem({ title: h.title, url: h.url, posterUrl: h.posterUrl, bannerUrl: h.bannerUrl, type: "anime", headers: { "Referer": BASE } });
                });
            }
            var genres = ["all", "action", "adventure", "comedy", "romance"];
            var requests = genres.map(function (g) { return { method: "GET", url: BASE + "ajax/featured-genre?genre=" + encodeURIComponent(g), headers: apiHeaders() }; });
            var responses = await http_parallel(requests);
            var seenUrls = {};
            responses.forEach(function (resp, i) {
                var label = i === 0 ? "Popular" : (genres[i].charAt(0).toUpperCase() + genres[i].slice(1));
                var json = parseJsonSafe(resp && resp.body ? String(resp.body) : "", null);
                if (!json || !json.success || !Array.isArray(json.results)) return;
                var items = [];
                json.results.forEach(function (r) {
                    if (seenUrls[r.url]) return; seenUrls[r.url] = true;
                    items.push(apiItemToMultimedia(r));
                });
                if (items.length) result[label] = items;
            });
            if (!Object.keys(result).length) throw new Error("HOME_EMPTY");
            cb({ success: true, data: result });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e && e.message ? e.message : e) });
        }
    }

    async function search(query, cb) {
        try {
            var q = cleanText(query || "");
            if (!q) { cb({ success: true, data: [] }); return; }
            var json = await http_get(BASE + "ajax/search?q=" + encodeURIComponent(q), apiHeaders());
            var parsed = parseJsonSafe(json && json.body ? json.body : "", null);
            var items = [];
            if (parsed && parsed.success && Array.isArray(parsed.results)) parsed.results.forEach(function (r) { items.push(apiItemToMultimedia(r)); });
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e && e.message ? e.message : e) });
        }
    }

    async function load(url, cb) {
        try {
            var slug = (url.match(/\/watch\/([^/?#]+)/i) || [])[1];
            if (!slug) throw new Error("Invalid AniNeko URL: " + url);
            var detailUrl = BASE + "watch/" + slug;
            var html = await httpGetText(detailUrl, htmlHeaders());

            var titleMatch = html.match(/<h1[^>]*>([^<]+)<\/h1>/i);
            var title = titleMatch ? cleanText(titleMatch[1]) : cleanText(slug);
            var posterUrl = parseOgImage(html) || "";
            var bannerUrl = parseBanner(html) || posterUrl || "";
            var description = parseDescription(html);          // series plot (set ONCE, not per-episode)
            var genres = parseGenres(html);
            var sy = parseStatusYear(html);

            // Robust grid parse via native helper -> all episodes, consistent titles.
            var articleEls = [];
            try { articleEls = await parse_html(html, "article.nv-info-episode-item", null); } catch (e) { articleEls = []; }
            var eps = parseArticleBlocks(articleEls);
            if (!eps.length) eps = [{ episode: 1, url: detailUrl + "/ep-1", title: "Episode 1", hasDub: false, hasHsub: false, hasSub: true }];

            // Bounded parallel enrichment (first EP_META_CAP episodes) for real thumb/airDate/runtime.
            var cap = Math.min(eps.length, EP_META_CAP);
            var metas = new Array(eps.length).fill(null);
            if (cap > 0) {
                var reqs = eps.slice(0, cap).map(function (ep) { return { method: "GET", url: ep.url, headers: htmlHeaders() }; });
                var resps = await http_parallel(reqs);
                for (var ri = 0; ri < resps.length; ri++) {
                    if (resps[ri]) metas[ri] = parseEpisodeJsonLd(String(resps[ri].body || ""));
                }
            }

            var episodes = eps.map(function (ep, idx) {
                var meta = (idx < cap) ? metas[idx] : null;
                var dubStatus = ep.hasDub ? "dub" : (ep.hasHsub ? "hardsub" : "softsub");
                return new Episode({
                    name: ep.title || ("Episode " + ep.episode),
                    url: JSON.stringify({ url: ep.url, episode: ep.episode }),
                    season: 1,
                    episode: ep.episode,
                    posterUrl: (meta && meta.thumbnailUrl) || posterUrl || undefined,
                    airDate: meta ? meta.airDate : undefined,
                    runtime: (meta && meta.durationMin) ? meta.durationMin : undefined,
                    headers: { "Referer": BASE },
                    dubStatus: dubStatus
                });
            });

            // Next airing: only while still ongoing (never fabricate for completed).
            var nextAiring = null;
            if (sy.status === "ongoing" && episodes.length) {
                nextAiring = new NextAiring({ episode: episodes[episodes.length - 1].episode + 1, season: 1, airDate: "" });
            }

            cb({ success: true, data: new MultimediaItem({
                title: title,
                url: detailUrl,
                posterUrl: posterUrl,
                bannerUrl: bannerUrl,
                type: "anime",
                description: description || undefined,   // set once on the series
                year: sy.year,
                status: sy.status,
                tags: genres.length ? genres : undefined,
                nextAiring: nextAiring,
                headers: { "Referer": BASE },
                episodes: episodes
            }) });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e && e.message ? e.message : e) });
        }
    }

    async function loadStreams(data, cb) {
        try {
            var epUrl = "";
            if (typeof data === "string") {
                var parsed = parseJsonSafe(data, null);
                epUrl = (parsed && parsed.url) ? parsed.url : data;
            } else if (data && data.url) epUrl = data.url;
            if (!epUrl) throw new Error("No episode url in loadStreams payload");

            var html = await httpGetText(epUrl, htmlHeaders());
            var groups = parseServerBlocks(html);

            // Order + labels: Hard Sub, Soft Sub, Dub. Subtype is sent in the stream `source`.
            var order = [
                { key: "hsub", language: "SUB", dubStatus: "hardsub", subtype: "Hard Sub" },
                { key: "sub", language: "SUB", dubStatus: "softsub", subtype: "Soft Sub" },
                { key: "dub", language: "DUB", dubStatus: "dub", subtype: "Dub" }
            ];
            var jobs = [];
            order.forEach(function (grp) {
                (groups[grp.key] || []).forEach(function (entry) {
                    var subUrl = (grp.key === "sub") ? extractSubtitleUrl(entry.video) : "";
                    jobs.push({ entry: entry, grp: grp, subUrl: subUrl });
                });
            });

            var resolvedArrays = await Promise.all(jobs.map(async function (job) {
                var entry = job.entry;
                var sourceLabel = "AniNeko " + entry.name + " (" + job.grp.subtype + ")";
                var streams = await resolveExtractorUrl(entry.video, sourceLabel);
                return streams.map(function (s) {
                    s.language = job.grp.language;
                    s.dubStatus = job.grp.dubStatus;
                    s.source = (job.grp.subtype + " • " + (s.source || entry.name)).trim();
                    if (job.subUrl) s.subtitles = [{ url: job.subUrl, label: "English", lang: "en" }];
                    return s;
                });
            }));

            var streams = [];
            resolvedArrays.forEach(function (arr) { arr.forEach(function (s) { if (s && s.url) streams.push(s); }); });
            if (!streams.length) throw new Error("No streams found for " + epUrl);
            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e && e.message ? e.message : e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
