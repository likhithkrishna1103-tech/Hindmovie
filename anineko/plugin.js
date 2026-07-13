(function () {
    "use strict";

    /**
     * AniNeko plugin (anineko.to) — self-contained, with embedded per-host extractors.
     *
     * Architecture (reverse-engineered from the live site, verified against real fetches):
     *  - getHome : hero carousel (big_cover banner) + /ajax/featured-genre rows + /ajax/search
     *  - search  : /ajax/search?q=
     *  - load    : detail page -> metadata + episode grid (/watch/{slug}/ep-N)
     *  - loadStreams : episode page -> parse data-video server buttons grouped by tab
     *        tab_0 = hsub (Hard Sub), tab_1 = sub (Soft Sub, external .vtt), tab_2 = dub (DUB)
     *        Each data-video is an EXTERNAL EMBED PLAYER page, NOT a direct file.
     *
     *  The embeds resolve to direct HLS like this (traced live, not guessed):
     *   - vivibebe.site     -> https://vivibebe.site/public/stream/<id>/master.m3u8   (JWPlayer, direct)
     *   - otakuhg.site      -> packed eval() -> links.hls2 signed .m3u8 (StreamHG/VidHide JWPlayer)
     *   - otakuvid.online   -> packed eval() -> links.hls2 signed .m3u8 (Earnvids/VidHide JWPlayer)
     *   - playmogo.com /e/  -> DoodStream-style (Cloudflare) -> /pass_md5/ token + random + expiry
     *   - bibiemb.online    -> same family as otakuvid (VidHide) packed eval()
     *
     *  We therefore embed custom extractors (resolveVivibebe, resolveStreamHG/Earnvids,
     *  resolveDoodStream) and call them from loadStreams via resolveExtractorUrl().
     *
     *  Metadata:
     *   - Per-episode JSON-LD (schema.org TVEpisode) on each /watch/{slug}/ep-N page gives the
     *     REAL thumbnail (poster), air date (datePublished) and duration (PTxxM). Parsed in load().
     *   - Series-level: title, poster (og:image), banner, description, genres, status, year.
     *   - NOTE: anineko's pages expose NO rating/cast/studio fields, so those are intentionally
     *     omitted (never fabricated).
     */

    var BASE_URL = (typeof manifest !== "undefined" && manifest && manifest.baseUrl) ? manifest.baseUrl : "https://anineko.to/";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36";
    var EP_META_CAP = 100; // max episodes enriched with per-episode JSON-LD (avoid runaway fetches on long series)

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
    function getQualityFromText(s) {
        if (!s) return 0;
        var decoded = String(s).replace(/%[0-9a-fA-F]{2}/g, " ");
        var m = decoded.match(/(\d{3,4})p/i);
        if (m) return parseInt(m[1], 10);
        if (/2160|4k|uhd/i.test(decoded)) return 2160;
        if (/1440|qhd/i.test(decoded)) return 1440;
        if (/1080/i.test(decoded)) return 1080;
        if (/720/i.test(decoded)) return 720;
        if (/480/i.test(decoded)) return 480;
        if (/360/i.test(decoded)) return 360;
        return 0;
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
    async function httpGetJson(url, headers) {
        var res = await http_get(url, headers || apiHeaders());
        if (!res || res.status < 200 || res.status >= 400) throw new Error("HTTP " + (res ? res.status : "?") + " for " + url);
        return parseJsonSafe(res.body || "", null);
    }

    // ---- Decode the Dean-Edwards packer used by otakuhg/otakuvid/bibiemb embeds ----
    // The embed page contains: eval(function(p,a,c,k,e,d){while(c--)if(k[c])p=p.replace(new RegExp(k[c],'g'),k[c]);return p}("<template>","<base>","<count>","<dict>".split('|')|["..."],"<e>"))
    // Unpacked in pure JS. NOTE: the plugin sandbox has NO eval(), so we parse args manually.
    function unpackPacker(html) {
        try {
            var start = html.lastIndexOf("eval(function(p,a,c,k,e,d)");
            if (start < 0) return "";
            var depth = 0, realEnd = -1;
            for (var i = start + 4; i < html.length; i++) {
                if (html[i] === "(") depth++;
                else if (html[i] === ")") { depth--; if (depth === 0) { realEnd = i; break; } }
            }
            if (realEnd < 0) return "";
            var packed = html.slice(start, realEnd + 1);
            var sig = html.indexOf("function(p,a,c,k,e,d){", start);
            var braceOpen = html.indexOf("{", sig);
            var bd = 0, bodyClose = -1;
            for (var j = braceOpen; j < html.length; j++) {
                if (html[j] === "{") bd++;
                else if (html[j] === "}") { bd--; if (bd === 0) { bodyClose = j; break; } }
            }
            var argOpen = html.indexOf("(", bodyClose);
            var argStr = packed.slice(argOpen - start + 1, realEnd - start + 1);
            // Tokenize top-level comma-separated args (respect quotes AND escaped quotes)
            var parts = [], cur = "", q = null;
            for (var t = 0; t < argStr.length; t++) {
                var ch = argStr[t];
                if (q) {
                    cur += ch;
                    if (ch === "\\" && t + 1 < argStr.length) { cur += argStr[t + 1]; t++; continue; }
                    if (ch === q) q = null;
                }
                else if (ch === '"' || ch === "'") { cur += ch; q = ch; }
                else if (ch === ",") { parts.push(cur); cur = ""; }
                else cur += ch;
            }
            parts.push(cur);
            if (parts.length < 4) return "";
            function stripQ(s) { s = s.trim(); if (s.length >= 2 && (s[0] === '"' || s[0] === "'") && s[s.length - 1] === s[0]) return s.slice(1, -1); return s; }
            var p = stripQ(parts[0]);
            var a = parseInt(stripQ(parts[1]), 10) || 36;
            var c = parseInt(stripQ(parts[2]), 10);
            var kExpr = parts[3].trim();
            var k = [];
            if (kExpr.indexOf(".split(") >= 0) {
                var sm = kExpr.match(/["']((?:[^"']|\.)*)["']/);
                k = sm ? sm[1].split("|") : [];
            } else if (kExpr.charAt(0) === "[") {
                // parse array of quoted strings manually
                var inner = kExpr.slice(1, kExpr.lastIndexOf("]"));
                var qi = 0, qopen = false, buf = "", arr = [];
                for (var x = 0; x < inner.length; x++) {
                    var cx = inner[x];
                    if (qopen) { buf += cx; if (cx === qi) qopen = false; }
                    else if (cx === '"' || cx === "'") { qi = cx; qopen = true; buf = ""; }
                    else if (cx === "," && !qopen) { arr.push(buf); buf = ""; }
                    else if (!qopen && cx !== " ") buf += cx;
                }
                if (buf.length) arr.push(buf);
                k = arr;
            }
            var e = parseInt(stripQ(parts[4] || "0"), 10) || 0;
            var out = String(p);
            for (var ci = c - 1; ci >= 0; ci--) {
                if (k[ci]) {
                    var key = (ci ^ e).toString(a);
                    var re = new RegExp("\\b" + key + "\\b", "g");
                    out = out.replace(re, k[ci]);
                }
            }
            return out;
        } catch (err) {
            return "";
        }
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

    // ---- Extractors (embed -> real StreamResult[]) -------------------------
    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: quality ? (source + " [" + quality + "p]") : source,
            quality: quality || undefined,
            headers: headers || {}
        });
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

    // otakuhg.site / otakuvid.online / bibiemb.online -> packed eval() -> signed m3u8
    async function resolveVidHide(url, label, refererHost) {
        var headers = { "User-Agent": USER_AGENT, "Referer": refererHost || "https://otakuhg.site/" };
        var res = await http_get(url, headers);
        if (!res || res.status !== 200) return [];
        var html = String(res.body || "");
        var unpacked = unpackPacker(html);
        if (unpacked) {
            var m3u8 = extractM3u8FromUnpacked(unpacked);
            if (m3u8) return [buildStreamResult(m3u8, label || "AniNeko", headers, 0)];
        }
        // fallback: direct m3u8 already in page
        var direct = extractM3u8FromUnpacked(html);
        if (direct) return [buildStreamResult(direct, label || "AniNeko", headers, 0)];
        return [];
    }

    // playmogo.com /e/<id> -> DoodStream-style: /pass_md5/<id> then append random + expiry
    async function resolveDoodStream(url, label) {
        var headers = { "User-Agent": USER_AGENT, "Referer": "https://playmogo.com/" };
        var res = await http_get(url, headers);
        if (!res || res.status !== 200) return [];
        var html = String(res.body || "");
        // DoodStream embeds usually contain /pass_md5/<token>
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
            // Unknown embed host: pass through as a raw extractor candidate with Referer.
            return [buildStreamResult(u, label || "AniNeko", { "User-Agent": USER_AGENT, "Referer": BASE }, 0)];
        } catch (e) {
            return [];
        }
    }

    // ---- Parsers -----------------------------------------------------------
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
    function parseEpisodeGrid(html) {
        var eps = [], seen = {}, re = /<article class="nv-info-episode-item">([\s\S]*?)<\/article>/gi, m;
        while ((m = re.exec(html)) !== null) {
            var block = m[1];
            var href = (block.match(/href="(\/watch\/[^"]+\/ep-\d+)"/i) || [])[1];
            if (!href) continue;
            var epNum = (href.match(/ep-(\d+)/i) || [])[1];
            if (!epNum || seen[epNum]) continue;
            seen[epNum] = true;
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
        }
        if (!eps.length) {
            var re2 = /href="(\/watch\/[^"]+\/ep-(\d+))"/gi;
            while ((m = re2.exec(html)) !== null) {
                var n = m[2];
                if (seen[n]) continue;
                seen[n] = true;
                eps.push({ episode: parseInt(n, 10), url: absoluteUrl(m[1]), title: "Episode " + n, hasDub: false, hasHsub: false, hasSub: true });
            }
        }
        eps.sort(function (a, b) { return a.episode - b.episode; });
        return eps;
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
    // Provides REAL per-episode: thumbnail (poster), air date, duration.
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
            var json = await httpGetJson(BASE + "ajax/search?q=" + encodeURIComponent(q));
            var items = [];
            if (json && json.success && Array.isArray(json.results)) json.results.forEach(function (r) { items.push(apiItemToMultimedia(r)); });
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
            var description = parseDescription(html);
            var genres = parseGenres(html);
            var sy = parseStatusYear(html);
            var eps = parseEpisodeGrid(html);
            if (!eps.length) eps = [{ episode: 1, url: detailUrl + "/ep-1", title: "Episode 1", hasDub: false, hasHsub: false, hasSub: true }];

            // Enrich a bounded number of episodes with their per-episode JSON-LD (real thumb / air date / duration).
            // We only FETCH the first EP_META_CAP episode pages to avoid N network calls on long series;
            // later episodes still get the series poster but no per-episode air date / duration.
            var enrichCount = Math.min(eps.length, EP_META_CAP);
            var epHtmlList = await Promise.all(eps.slice(0, enrichCount).map(function (ep) {
                return httpGetText(ep.url, htmlHeaders()).catch(function () { return ""; });
            }));

            var episodes = eps.map(function (ep, idx) {
                var meta = (idx < enrichCount) ? parseEpisodeJsonLd(epHtmlList[idx]) : null;
                var dubStatus;
                if (ep.hasDub) dubStatus = "dub";
                else if (ep.hasHsub) dubStatus = "hardsub";
                else dubStatus = "softsub";
                return new Episode({
                    name: ep.title || ("Episode " + ep.episode),
                    url: JSON.stringify({ url: ep.url, episode: ep.episode }),
                    season: 1,
                    episode: ep.episode,
                    posterUrl: (meta && meta.thumbnailUrl) || posterUrl || undefined,
                    description: description || undefined,
                    airDate: meta ? meta.airDate : undefined,
                    runtime: (meta && meta.durationMin) ? meta.durationMin : undefined,
                    headers: { "Referer": BASE },
                    dubStatus: dubStatus
                });
            });

            // Next airing: only meaningful while the series is still ongoing.
            var nextAiring = null;
            if (sy.status === "ongoing" && episodes.length) {
                var maxEp = episodes[episodes.length - 1].episode;
                nextAiring = new NextAiring({ episode: maxEp + 1, season: 1, airDate: "" });
            }

            cb({ success: true, data: new MultimediaItem({
                title: title,
                url: detailUrl,
                posterUrl: posterUrl,
                bannerUrl: bannerUrl,
                type: "anime",
                description: description || undefined,
                year: sy.year,
                status: sy.status,
                duration: (episodes[0] && episodes[0].runtime) || undefined,
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
