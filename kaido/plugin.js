(function () {
    const MAIN_URL = "https://kaido.to";

    const HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
        "Accept": "*/*",
        "Accept-Language": "en-US,en;q=0.5",
        "Referer": MAIN_URL + "/"
    };

    // ─────────────────────────────────────────────
    // Helpers
    // ─────────────────────────────────────────────

    function fixUrl(href) {
        if (!href) return "";
        if (href.startsWith("http")) return href;
        if (href.startsWith("//")) return "https:" + href;
        return MAIN_URL + (href.startsWith("/") ? "" : "/") + href;
    }

    function getType(typeStr) {
        if (!typeStr) return "anime";
        var t = typeStr.toUpperCase();
        if (t.indexOf("OVA") !== -1 || t.indexOf("SPECIAL") !== -1) return "anime";
        if (t.indexOf("MOVIE") !== -1) return "movie";
        return "anime";
    }

    // Simple HTML entity decoder for title text
    function decodeHtmlEntities(str) {
        return str
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ");
    }

    // Parse a minimal subset of HTML: extract text from a CSS-like selector pattern
    // Uses regex since we have no DOM. Returns first match's inner text.
    function selectText(html, selector) {
        // Supports simple tag[.class] patterns with optional attribute filter
        // E.g. "h3.film-name", ".tick-sub", "#syncData"
        if (selector.startsWith("#")) {
            var id = selector.slice(1);
            var re = new RegExp('<[^>]+id=["\']' + id + '["\'][^>]*>([\\s\\S]*?)<\\/[^>]+>', 'i');
            var m = html.match(re);
            return m ? m[1].replace(/<[^>]+>/g, "").trim() : "";
        }
        var parts = selector.replace(/\./g, " ").trim().split(/\s+/);
        var tag = /^[a-zA-Z]/.test(parts[0]) ? parts.shift() : "[a-zA-Z]+";
        var classes = parts;
        var classPattern = classes.map(function (c) {
            return '(?=[^>]*class=["\'][^"\']*' + c + '[^"\']*["\'])';
        }).join("");
        var re2 = new RegExp('<' + tag + classPattern + '[^>]*>([\\s\\S]*?)<\\/' + tag + '>', 'i');
        var m2 = html.match(re2);
        return m2 ? m2[1].replace(/<[^>]+>/g, "").trim() : "";
    }

    // Extract all matches of an element
    function selectAll(html, tagName, className) {
        var classPattern = className
            ? '(?=[^>]*class=["\'][^"\']*' + className + '[^"\']*["\'])'
            : "";
        var re = new RegExp('<' + tagName + classPattern + '[^>]*>([\\s\\S]*?)<\\/' + tagName + '>', 'gi');
        var results = [];
        var m;
        while ((m = re.exec(html)) !== null) {
            results.push(m[0]);
        }
        return results;
    }

    function attrVal(html, attrName) {
        // Match double-quoted first (value may contain apostrophes), then single-quoted
        var reDouble = new RegExp(attrName + '="([^"]*)"', 'i');
        var reSingle = new RegExp(attrName + "='([^']*)'", 'i');
        var m = html.match(reDouble) || html.match(reSingle);
        return m ? m[1] : "";
    }

    function innerText(html) {
        return decodeHtmlEntities(html.replace(/<[^>]+>/g, " ").replace(/\s+/g, " ").trim());
    }

    // ─────────────────────────────────────────────
    // Parse search-result item  (div.flw-item)
    // ─────────────────────────────────────────────

    function parseFlwItem(itemHtml) {
        // href — from <a href="..."> inside the block
        var hrefMatch = itemHtml.match(/<a[^>]+href=["']([^"']+)["']/i);
        var href = hrefMatch ? fixUrl(hrefMatch[1]) : "";

        // On kaido.to the film-name anchor carries both the English title (title="...")
        // and the original Japanese title (data-jname="...").
        // <h3 class="film-name"><a href="..." data-jname="葬送のフリーレン" title="Frieren: Beyond Journey's End">Frieren...</a></h3>
        var filmAnchorMatch = itemHtml.match(/<h3[^>]*class=["'][^"']*film-name[^"']*["'][^>]*>[\s\S]*?(<a[^>]*>)/i);
        var filmAnchorTag = filmAnchorMatch ? filmAnchorMatch[1] : "";

        // Primary title: a[title] attribute — use [^"]+ when double-quoted, [^']+ when single-quoted
        var titleAttrMatch = filmAnchorTag.match(/\btitle="([^"]+)"/i)
                          || filmAnchorTag.match(/\btitle='([^']+)'/i);
        var title = titleAttrMatch ? decodeHtmlEntities(titleAttrMatch[1].trim()) : "";

        // Fallback: h3 > a inner text
        if (!title) {
            var innerMatch = itemHtml.match(/<h3[^>]*class=["'][^"']*film-name[^"']*["'][^>]*>[\s\S]*?<a[^>]*>([^<]+)<\/a>/i);
            if (innerMatch) title = decodeHtmlEntities(innerMatch[1].trim());
        }

        // Japanese / original title from data-jname attribute
        var jnameMatch = filmAnchorTag.match(/\bdata-jname="([^"]+)"/i)
                      || filmAnchorTag.match(/\bdata-jname='([^']+)'/i);
        var japaneseTitle = jnameMatch ? decodeHtmlEntities(jnameMatch[1].trim()) : null;

        // poster from img data-src
        var posterMatch = itemHtml.match(/<img[^>]+data-src=["']([^"']+)["']/i);
        var poster = posterMatch ? fixUrl(posterMatch[1]) : "";

        // type from span.fdi-item (first occurrence = type like "TV", "Movie", "OVA")
        var typeMatch = itemHtml.match(/<span[^>]*class=["'][^"']*fdi-item[^"']*["'][^>]*>([^<]+)<\/span>/i);
        var typeStr = typeMatch ? typeMatch[1].trim() : "";
        var type = getType(typeStr);

        if (!title || !href) return null;

        return new MultimediaItem({
            title:         title,
            url:           href,
            posterUrl:     poster,
            type:          type,
            japaneseTitle: japaneseTitle || undefined
        });
    }

    // ─────────────────────────────────────────────
    // getHome — 8 curated rows matching Kotlin mainPage
    // ─────────────────────────────────────────────

    async function getHome(cb) {
        var rows = [
            { label: "🕐 Latest Episodes",          url: MAIN_URL + "/recently-updated?page=1" },
            { label: "🔥 Top Airing",               url: MAIN_URL + "/top-airing?page=1" },
            { label: "📺 Recently Updated (SUB)",   url: MAIN_URL + "/filter?status=2&language=1&sort=recently_updated&page=1" },
            { label: "🎙️ Recently Updated (DUB)",   url: MAIN_URL + "/filter?status=2&language=2&sort=recently_updated&page=1" },
            { label: "🆕 New On Kaido",             url: MAIN_URL + "/recently-added?page=1" },
            { label: "⭐ Most Popular",              url: MAIN_URL + "/most-popular?page=1" },
            { label: "✨ Special",                   url: MAIN_URL + "/special?page=1" },
            { label: "✅ Latest Completed",         url: MAIN_URL + "/completed?page=1" }
        ];

        try {
            var homeData = {};

            for (var i = 0; i < rows.length; i++) {
                var row = rows[i];
                try {
                    var res = await http_get(row.url, HEADERS);
                    if (!res || !res.body) continue;
                    var items = parseFlwItems(res.body);
                    if (items.length > 0) homeData[row.label] = items;
                } catch (e) {
                    console.error("[Home] Row '" + row.label + "' error:", e.message);
                }
            }

            cb({ success: true, data: homeData });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    function parseFlwItems(html) {
        var items = [];
        // Depth-aware extraction: find each div.flw-item opening tag, then
        // walk forward counting <div>/<\/div> to find the matching closing tag.
        // This is robust against any nesting depth inside the card.
        var startRe = /<div[^>]*class=["'][^"]*flw-item[^"]*["'][^>]*>/gi;
        var m;
        while ((m = startRe.exec(html)) !== null) {
            var start = m.index;
            var depth = 0;
            var pos = start;
            var end = start;
            while (pos < html.length) {
                var nextOpen  = html.indexOf('<div',  pos);
                var nextClose = html.indexOf('</div>', pos);
                if (nextOpen === -1 && nextClose === -1) break;
                if (nextClose === -1 || (nextOpen !== -1 && nextOpen < nextClose)) {
                    depth++;
                    pos = nextOpen + 4;
                } else {
                    depth--;
                    pos = nextClose + 6;
                    if (depth === 0) { end = pos; break; }
                }
            }
            if (end > start) {
                var block = html.slice(start, end);
                var item = parseFlwItem(block);
                if (item) items.push(item);
            }
        }
        return items;
    }

    // ─────────────────────────────────────────────
    // search
    // ─────────────────────────────────────────────

    async function search(query, cb) {
        try {
            var url = MAIN_URL + "/search?keyword=" + encodeURIComponent(query) + "&page=1";
            var res = await http_get(url, HEADERS);
            if (!res || !res.body) throw new Error("Empty response");
            var items = parseFlwItems(res.body);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // ani.zip metadata fetch
    // ─────────────────────────────────────────────

    async function fetchAniZipMeta(malId) {
        if (!malId) return null;
        try {
            var url = "https://api.ani.zip/mappings?mal_id=" + malId;
            var res = await http_get(url, { "Accept": "application/json" });
            if (!res || !res.body) return null;
            return JSON.parse(res.body);
        } catch (e) {
            console.error("[AniZip] fetch error:", e.message);
            return null;
        }
    }

    // ─────────────────────────────────────────────
    // load — anime detail page
    // ─────────────────────────────────────────────

    async function load(url, cb) {
        try {
            // Kaido load() strips "watch/" from the URL for the detail page
            var detailUrl = url.replace("watch/", "");
            var res = await http_get(detailUrl, HEADERS);
            if (!res || !res.body) throw new Error("Empty response from detail page");
            var html = res.body;

            // ── syncData (MAL + AniList IDs) ─────────────────────────────
            var malId = null;
            var anilistId = null;
            var syncMatch = html.match(/id=["']syncData["'][^>]*data-page=["']([^"']+)["']/i);
            if (!syncMatch) {
                // Try script tag form: window.__data = {...}  or #syncData content
                var sdMatch = html.match(/id=["']syncData["'][^>]*>([\s\S]*?)<\//i);
                if (sdMatch) {
                    try {
                        var sdJson = JSON.parse(sdMatch[1].trim());
                        malId = sdJson.mal_id || null;
                        anilistId = sdJson.anilist_id || null;
                    } catch (e) { /* ignore */ }
                }
            } else {
                try {
                    var sdJson2 = JSON.parse(decodeHtmlEntities(syncMatch[1]));
                    malId = sdJson2.mal_id || null;
                    anilistId = sdJson2.anilist_id || null;
                } catch (e) { /* ignore */ }
            }
            // Broader fallback: look for mal_id in any JSON blob in the page
            if (!malId) {
                var malMatch = html.match(/"mal_id"\s*:\s*["']?(\d+)["']?/);
                if (malMatch) malId = malMatch[1];
            }
            if (!anilistId) {
                var alMatch = html.match(/"anilist_id"\s*:\s*["']?(\d+)["']?/);
                if (alMatch) anilistId = alMatch[1];
            }

            // ── ani.zip metadata (episode titles, images, overview) ──────
            var aniMeta = await fetchAniZipMeta(malId);

            // ── Basic info ───────────────────────────────────────────────
            var titleMatch = html.match(/<h2[^>]*class=["'][^"']*film-name[^"']*["'][^>]*>([^<]+)<\/h2>/i);
            var title = titleMatch ? decodeHtmlEntities(titleMatch[1].trim()) : "Unknown";

            var posterMatch = html.match(/<div[^>]*id=["']ani_detail["'][^>]*>[\s\S]*?<img[^>]+src=["']([^"']+)["']/i);
            var poster = posterMatch ? posterMatch[1] : "";

            var descMatch = html.match(/<div[^>]*class=["'][^"']*film-description[^"']*["'][^>]*>([\s\S]*?)<\/div>/i);
            var description = descMatch ? innerText(descMatch[1]) : "";

            // Genres
            var genres = [];
            var genreMatch = html.match(/item-head[^>]*>Genres[\s\S]*?<\/div>/i);
            if (genreMatch) {
                var genreRe = /<a[^>]*>([^<]+)<\/a>/gi;
                var gm;
                while ((gm = genreRe.exec(genreMatch[0])) !== null) {
                    genres.push(gm[1].trim());
                }
            }

            // Type
            var typeRawMatch = html.match(/<div[^>]*class=["'][^"']*film-stats[^"']*["'][^>]*>[\s\S]*?<div[^>]*class=["'][^"']*tick[^"']*["'][^>]*>([\s\S]*?)<\/div>/i);
            var typeRaw = typeRawMatch ? innerText(typeRawMatch[1]) : "";
            var type = (/movie/i.test(typeRaw)) ? "movie" : "anime";

            // Year, status, Japanese name, duration
            var year = null;
            var status = "unknown";
            var japName = null;
            var duration = null;
            var infoItems = [];
            var infoRe = /<div[^>]*class=["'][^"']*item\b[^"']*["'][^>]*>([\s\S]*?)<\/div>/gi;
            var infoM;
            while ((infoM = infoRe.exec(html)) !== null) {
                infoItems.push(infoM[1]);
            }
            infoItems.forEach(function (block) {
                var head = (block.match(/<span[^>]*class=["'][^"']*item-head[^"']*["'][^>]*>([^<]+)<\/span>/i) || [])[1] || "";
                head = head.replace(/:$/, "").trim();
                var val = (block.match(/<span[^>]*class=["'][^"']*name[^"']*["'][^>]*>([^<]+)<\/span>/i)
                    || block.match(/<a[^>]*>([^<]+)<\/a>/) || [])[1] || "";
                val = decodeHtmlEntities(val.trim());
                switch (head) {
                    case "Premiered": year = parseInt(val.split(" ").pop()) || null; break;
                    case "Status":
                        if (/finished/i.test(val)) status = "completed";
                        else if (/airing/i.test(val)) status = "ongoing";
                        break;
                    case "Japanese": japName = val; break;
                    case "Duration": duration = val; break;
                }
            });

            // Anime ID (last segment of path, after last "-")
            var animeId = url.replace(/\?.*$/, "").split("-").pop().replace(/\/.*$/, "");

            // Sub/Dub counts from .tick-sub / .tick-dub on detail page
            var subCountMatch = html.match(/<span[^>]*class=["'][^"']*tick-sub[^"']*["'][^>]*>(\d+)<\/span>/i);
            var dubCountMatch = html.match(/<span[^>]*class=["'][^"']*tick-dub[^"']*["'][^>]*>(\d+)<\/span>/i);
            var subCount = subCountMatch ? parseInt(subCountMatch[1]) : null;
            var dubCount = dubCountMatch ? parseInt(dubCountMatch[1]) : null;

            // ── Episode list from AJAX ───────────────────────────────────
            var episodes = await fetchEpisodeList(animeId, url, subCount, dubCount, aniMeta, title, type, poster, description);

            // ── Actors ───────────────────────────────────────────────────
            var actors = [];
            var actorRe = /<div[^>]*class=["'][^"']*bac-item[^"']*["'][^>]*>([\s\S]*?)<\/div>\s*<\/div>/gi;
            var am;
            while ((am = actorRe.exec(html)) !== null) {
                var block = am[1];
                var nameM = block.match(/<span[^>]*class=["'][^"']*pi-name[^"']*["'][^>]*>([^<]+)<\/span>/i);
                var imgM = block.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
                if (nameM && imgM) {
                    actors.push(new Actor({ name: nameM[1].trim(), imageUrl: imgM[1] }));
                }
            }

            // ── Recommendations ──────────────────────────────────────────
            var recoHtml = "";
            var recoMatch = html.match(/<div[^>]*class=["'][^"']*block_area_category[^"']*["'][^>]*>([\s\S]*?)<\/section>/i);
            if (recoMatch) recoHtml = recoMatch[1];
            var recommendations = recoHtml ? parseFlwItems(recoHtml) : [];

            // ── Build result ─────────────────────────────────────────────
            var result = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: poster,
                bannerUrl: poster,
                type: type,
                year: year,
                description: description,
                status: status,
                genres: genres,
                actors: actors,
                recommendations: recommendations,
                episodes: episodes,
                syncData: { mal: malId, anilist: anilistId },
                headers: HEADERS
            });

            cb({ success: true, data: result });
        } catch (e) {
            console.error("[load] Error:", e.message);
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // Episode list fetch  (/ajax/episode/list/{animeId})
    // ─────────────────────────────────────────────

    async function fetchEpisodeList(animeId, animeUrl, subCount, dubCount, aniMeta, animeTitle, type, poster, description) {
        var episodes = [];
        try {
            var ajaxUrl = MAIN_URL + "/ajax/episode/list/" + animeId;
            var res = await http_get(ajaxUrl, {
                "Accept": "application/json",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": animeUrl
            });
            if (!res || !res.body) throw new Error("Empty episode list response");

            var json = JSON.parse(res.body);
            // Response is { status: true, html: "<a ...> ..." }
            var epHtml = json.html || "";

            // Extract all episode links: <a href="/watch/..." data-id="..." title="...">
            var epRe = /<a[^>]+class=["'][^"']*ssl-item\s+ep-item[^"']*["'][^>]*>([\s\S]*?)<\/a>/gi;
            var m;
            var epList = [];
            while ((m = epRe.exec(epHtml)) !== null) {
                var tag = m[0];
                var href = attrVal(tag, "href");
                var dataId = attrVal(tag, "data-id") || attrVal(tag, "data-number");
                var titleAttr = attrVal(tag, "title");
                // ssli-order = episode number text
                var orderMatch = tag.match(/<div[^>]*class=["'][^"']*ssli-order[^"']*["'][^>]*>(\d+)<\/div>/i);
                var epNum = orderMatch ? parseInt(orderMatch[1]) : null;
                if (!href || epNum === null) continue;
                epList.push({ href: href.replace(/^\//, ""), epNum: epNum, titleAttr: titleAttr, dataId: dataId });
            }

            // Build sub + dub episodes, capped by subCount/dubCount like the Kotlin code
            epList.forEach(function (ep, index) {
                var epKey = ep.epNum.toString();
                var metaEp = resolveMetaEp(aniMeta, epKey);
                var siteTitle = ep.titleAttr || ("Episode " + ep.epNum);

                function resolveTitle() {
                    if (metaEp && metaEp.title) {
                        return metaEp.title["en"] || metaEp.title["ja"] || metaEp.title["x-jat"] || siteTitle;
                    }
                    return siteTitle;
                }

                var epTitle = (type === "movie") ? animeTitle : resolveTitle();
                var epPoster = (metaEp && metaEp.image) ? metaEp.image
                    : ((aniMeta && aniMeta.images && aniMeta.images[0]) ? aniMeta.images[0].url : poster);
                var epDesc = (metaEp && metaEp.overview) ? metaEp.overview : description || "No summary available";
                var airDate = metaEp ? metaEp.airDateUtc : null;

                function makeEpisode(dubStatus) {
                    var urlPayload = JSON.stringify({
                        source: dubStatus,
                        href: ep.href
                    });
                    return new Episode({
                        name: epTitle + (dubStatus === "dub" ? " (Dub)" : ""),
                        url: urlPayload,
                        season: 1,
                        episode: ep.epNum,
                        posterUrl: epPoster,
                        description: epDesc,
                        airDate: airDate,
                        dubStatus: dubStatus,
                        headers: HEADERS
                    });
                }

                // Exactly mirrors Kotlin:
                //   subCount?.let { if (index < it) subEpisodes += createEpisode("sub") }
                //   dubCount?.let { if (index < it) dubEpisodes += createEpisode("dub") }
                // Both only run when the count is non-null (anime actually has that track).
                // subCount null = no sub track exists → no sub episodes
                // dubCount null = no dub track exists → no dub episodes
                if (subCount !== null && index < subCount) {
                    episodes.push(makeEpisode("sub"));
                }
                if (dubCount !== null && index < dubCount) {
                    episodes.push(makeEpisode("dub"));
                }
            });

        } catch (e) {
            console.error("[fetchEpisodeList] Error:", e.message);
        }
        return episodes;
    }

    // Resolve metadata episode from anizip data
    function resolveMetaEp(aniMeta, epKey) {
        if (!aniMeta || !aniMeta.episodes) return null;
        var ep = aniMeta.episodes[epKey];
        if (!ep) return null;
        // Sanity check: episode field should match key (or be absent)
        if (ep.episode && ep.episode.trim() !== epKey) return null;
        return ep;
    }

    // ─────────────────────────────────────────────
    // loadStreams — mirrors Kotlin loadLinks
    // Flow:
    //   1. Parse EpisodeLoadData {source, href}
    //   2. GET /ajax/episode/servers?episodeId={epId}
    //   3. For each server matching dubType, GET /ajax/episode/sources?id={serverId}
    //   4. Extract stream via MegaPlay/RapidCloud extractor
    // ─────────────────────────────────────────────

    async function loadStreams(url, cb) {
        try {
            var loadData = JSON.parse(url);
            var dubType = loadData.source || "sub";       // "sub" | "dub" | "raw"
            var href = loadData.href || "";               // e.g. "watch/anime-slug/ep=12345"

            // Extract episodeId from href: after "ep="
            var epIdMatch = href.match(/ep=(\d+)/);
            if (!epIdMatch) throw new Error("Cannot determine episode ID from href: " + href);
            var epId = epIdMatch[1];

            console.log("[loadStreams] dubType=" + dubType + " epId=" + epId);

            // Step 1: fetch server list
            var serversUrl = MAIN_URL + "/ajax/episode/servers?episodeId=" + epId;
            var serversRes = await http_get(serversUrl, {
                "Accept": "application/json",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": MAIN_URL + "/" + href
            });
            if (!serversRes || !serversRes.body) throw new Error("Empty servers response");
            var serversJson = JSON.parse(serversRes.body);
            var serverHtml = serversJson.html || "";

            // Parse server items: <div class="server-item" data-type="sub|dub|raw" data-id="...">
            // Accept matching dubType OR "raw" (mirrors Kotlin: [data-type=$dubType], [data-type=raw])
            var serverRe = /<div[^>]*class=["'][^"']*server-item[^"']*["'][^>]*>([\s\S]*?)<\/div>/gi;
            var sm;
            var servers = [];
            var seenIds = {};
            while ((sm = serverRe.exec(serverHtml)) !== null) {
                var sBlock = sm[0];
                var dataType = attrVal(sBlock, "data-type");
                var dataId = attrVal(sBlock, "data-id");
                var labelMatch = sBlock.match(/<a[^>]*class=["'][^"']*btn[^"']*["'][^>]*>([^<]+)<\/a>/i);
                var label = labelMatch ? labelMatch[1].trim() : "Server";

                if (!dataId || dataId === "") continue;
                if (dataType !== dubType && dataType !== "raw") continue;
                if (seenIds[dataId]) continue;
                seenIds[dataId] = true;

                servers.push({ id: dataId, label: label, type: dataType });
            }

            console.log("[loadStreams] Found " + servers.length + " server(s) for dubType=" + dubType);

            var streams = [];
            var subtitles = [];

            // Step 2: for each server, fetch source URL then extract
            for (var i = 0; i < servers.length; i++) {
                var server = servers[i];
                try {
                    var sourceUrl = MAIN_URL + "/ajax/episode/sources?id=" + server.id;
                    var sourceRes = await http_get(sourceUrl, {
                        "Accept": "application/json",
                        "X-Requested-With": "XMLHttpRequest",
                        "Referer": MAIN_URL + "/" + href
                    });
                    if (!sourceRes || !sourceRes.body) {
                        console.error("[loadStreams] Empty source response for server " + server.id);
                        continue;
                    }
                    var sourceJson = JSON.parse(sourceRes.body);
                    var embedLink = sourceJson.link;
                    if (!embedLink) {
                        console.error("[loadStreams] No link in source response for server " + server.id);
                        continue;
                    }

                    console.log("[loadStreams] Server [" + server.label + "] embed:", embedLink);

                    var result = await extractMegaPlay(embedLink, server.label);
                    if (result.streams && result.streams.length > 0) {
                        result.streams.forEach(function (s) { streams.push(s); });
                    }
                    // Merge subtitles, deduplicated by URL
                    if (result.subtitles && result.subtitles.length > 0) {
                        result.subtitles.forEach(function (sub) {
                            var exists = subtitles.some(function (s) { return s.url === sub.url; });
                            if (!exists) subtitles.push(sub);
                        });
                    }
                } catch (se) {
                    console.error("[loadStreams] Server " + server.label + " error:", se.message);
                }
            }

            console.log("[loadStreams] Total streams:", streams.length, "subtitles:", subtitles.length);
            cb({ success: true, data: streams, subtitles: subtitles });

        } catch (e) {
            console.error("[loadStreams] Fatal error:", e.message);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    // ─────────────────────────────────────────────
    // M3u8 master playlist parser
    // Mirrors Kotlin's M3u8Helper.generateM3u8() —
    // fetches the master m3u8 and returns one entry per
    // #EXT-X-STREAM-INF variant with its actual resolution/bandwidth.
    // ─────────────────────────────────────────────

    async function parseM3u8Qualities(masterUrl, streamHeaders, sourceName) {
        var results = [];
        try {
            var res = await http_get(masterUrl, streamHeaders);
            if (!res || !res.body) throw new Error("Empty m3u8 response");
            var m3u8 = res.body;

            // Base URL for resolving relative variant URLs
            var baseUrl = masterUrl.substring(0, masterUrl.lastIndexOf("/") + 1);

            var lines = m3u8.split("\n");
            for (var i = 0; i < lines.length; i++) {
                var line = lines[i].trim();
                if (line.indexOf("#EXT-X-STREAM-INF") !== -1) {
                    // Parse BANDWIDTH and RESOLUTION from the tag
                    var bandwidthMatch = line.match(/BANDWIDTH=(\d+)/i);
                    var resMatch       = line.match(/RESOLUTION=\d+x(\d+)/i);
                    var bandwidth      = bandwidthMatch ? parseInt(bandwidthMatch[1]) : 0;
                    var height         = resMatch ? parseInt(resMatch[1]) : 0;

                    // Quality label: prefer resolution height, fall back to bandwidth bucket
                    var quality = height > 0 ? height : (
                        bandwidth >= 4000000 ? 1080 :
                        bandwidth >= 2000000 ? 720  :
                        bandwidth >= 1000000 ? 480  :
                        bandwidth >= 500000  ? 360  : 0
                    );

                    // Next non-empty line is the variant URL
                    var variantUrl = "";
                    for (var j = i + 1; j < lines.length; j++) {
                        variantUrl = lines[j].trim();
                        if (variantUrl && variantUrl.indexOf("#") !== 0) break;
                    }
                    if (!variantUrl) continue;

                    // Resolve relative URLs
                    if (!variantUrl.startsWith("http")) {
                        variantUrl = baseUrl + variantUrl;
                    }

                    results.push(new StreamResult({
                        url:     variantUrl,
                        quality: quality,
                        source:  sourceName + (quality > 0 ? " " + quality + "p" : ""),
                        headers: streamHeaders,
                        isM3U8:  true
                    }));
                }
            }

            // If no variants found this is likely a media playlist, not a master — return as-is
            if (results.length === 0) {
                results.push(new StreamResult({
                    url:     masterUrl,
                    quality: 0,
                    source:  sourceName,
                    headers: streamHeaders,
                    isM3U8:  true
                }));
            }
        } catch (e) {
            console.error("[parseM3u8Qualities] Error:", e.message);
            // Fallback: return the master URL directly
            results.push(new StreamResult({
                url:     masterUrl,
                quality: 0,
                source:  sourceName,
                headers: streamHeaders,
                isM3U8:  true
            }));
        }
        return results;
    }

    // ─────────────────────────────────────────────
    // MegaPlay / RapidCloud extractor
    // Ports Extractor.kt: MegaPlay + Rapid (extends MegaPlay, mainUrl=rapid-cloud.co)
    //
    // API: GET {embedBase}/embed-2/v2/e-1/getSources?id={embedId}
    // Response: { sources: [{file, type}], tracks: [{file, label, kind}], ... }
    // Returns: { streams: [StreamResult], subtitles: [{url, name}] }
    // ─────────────────────────────────────────────

    async function extractMegaPlay(embedUrl, serverLabel) {
        try {
            // Determine base URL from the embed URL
            var embedBase;
            if (embedUrl.indexOf("rapid-cloud.co") !== -1) {
                embedBase = "https://rapid-cloud.co";
            } else if (embedUrl.indexOf("megaplay.buzz") !== -1) {
                embedBase = "https://megaplay.buzz";
            } else {
                var originMatch = embedUrl.match(/^(https?:\/\/[^/]+)/);
                embedBase = originMatch ? originMatch[1] : "https://rapid-cloud.co";
            }

            // Extract embed ID: last path segment before any query string
            var embedId = embedUrl.split("?")[0].split("/").pop();
            if (!embedId) {
                var pageRes = await http_get(embedUrl, {
                    "Accept": "*/*",
                    "X-Requested-With": "XMLHttpRequest",
                    "Referer": embedBase + "/"
                });
                var idMatch = pageRes && pageRes.body && pageRes.body.match(/id=["']vidcloud-player["'][^>]*data-id=["']([^"']+)["']/i);
                embedId = idMatch ? idMatch[1] : null;
                if (!embedId) {
                    console.error("[MegaPlay] Cannot determine embed ID from:", embedUrl);
                    return { streams: [], subtitles: [] };
                }
            }

            var apiUrl = embedBase + "/embed-2/v2/e-1/getSources?id=" + embedId;
            console.log("[MegaPlay] API:", apiUrl);

            var apiHeaders = {
                "Accept": "*/*",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": embedBase + "/",
                "Origin": "https://rapid-cloud.co",
                "User-Agent": HEADERS["User-Agent"]
            };

            var apiRes = await http_get(apiUrl, apiHeaders);
            if (!apiRes || !apiRes.body) {
                console.error("[MegaPlay] Empty API response");
                return { streams: [], subtitles: [] };
            }

            var data = JSON.parse(apiRes.body);

            if (data.encrypted === true || (typeof data.sources === "string")) {
                console.error("[MegaPlay] Encrypted sources — cannot decrypt without client key");
                return { streams: [], subtitles: [] };
            }

            var sources = data.sources || [];
            if (!Array.isArray(sources) || sources.length === 0) {
                console.error("[MegaPlay] No sources in API response");
                return { streams: [], subtitles: [] };
            }

            // Stream headers matching Kotlin's mainHeaders exactly
            var streamHeaders = {
                "User-Agent":      HEADERS["User-Agent"],
                "Accept":          "*/*",
                "Accept-Language": "en-US,en;q=0.5",
                "Accept-Encoding": "gzip, deflate, br, zstd",
                "Origin":          "https://rapid-cloud.co",
                "Referer":         "https://rapid-cloud.co/",
                "Connection":      "keep-alive",
                "Pragma":          "no-cache",
                "Cache-Control":   "no-cache"
            };

            var streams = [];
            var sourceName = "Kaido [" + serverLabel + "]";

            // For each source, if it's an m3u8 master playlist parse quality variants
            // (mirrors Kotlin's generateM3u8 which splits master into per-quality links)
            for (var si = 0; si < sources.length; si++) {
                var src = sources[si];
                if (!src.file) continue;
                var isM3U8 = (src.type === "hls") || src.file.indexOf(".m3u8") !== -1;
                if (isM3U8) {
                    var variants = await parseM3u8Qualities(src.file, streamHeaders, sourceName);
                    variants.forEach(function (v) { streams.push(v); });
                } else {
                    streams.push(new StreamResult({
                        url:     src.file,
                        quality: 0,
                        source:  sourceName,
                        headers: streamHeaders,
                        isM3U8:  false
                    }));
                }
            }

            // Subtitle / caption tracks — mirrors Kotlin's subtitleCallback block:
            // only kind == "captions" or "subtitles", label used as track name
            var subtitles = [];
            var tracks = data.tracks || [];
            tracks.forEach(function (track) {
                if (!track.file) return;
                var kind = (track.kind || "").toLowerCase();
                if (kind === "captions" || kind === "subtitles") {
                    subtitles.push({
                        url:  track.file,
                        name: track.label || "Unknown"
                    });
                }
            });

            console.log("[MegaPlay] streams=" + streams.length + " subtitles=" + subtitles.length);
            return { streams: streams, subtitles: subtitles };

        } catch (e) {
            console.error("[MegaPlay] Error:", e.message);
            return { streams: [], subtitles: [] };
        }
    }

    // ─────────────────────────────────────────────
    // Exports
    // ─────────────────────────────────────────────

    globalThis.getHome    = getHome;
    globalThis.search     = search;
    globalThis.load       = load;
    globalThis.loadStreams = loadStreams;

    console.log("Kaido plugin loaded — kaido.to anime streaming");
})();
