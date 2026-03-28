(function () {
    // ============================================================
    // 5MovieRulz Plugin
    //
    // Site structure (confirmed from real pages):
    //
    // HOME:
    //   Two sections on homepage:
    //   1. "Featured Movies Free"  — 20 items with poster + title + url
    //   2. "Latest Movies"         — 20 items with poster + title + url
    //   Each item:
    //     <a href="/slug/movie-watch-online-free-NNN.html">
    //       <img src="/uploads/Poster.jpg">
    //     </a>
    //     <p><b>Title (Year) Quality Lang Movie Watch Online Free</b></p>
    //
    // SEARCH:
    //   URL: /?s=QUERY  (WordPress standard search)
    //   Returns same film grid format as homepage
    //
    // MOVIE PAGE:
    //   Poster: <img src="/uploads/Name-Lang-Poster.jpg">
    //   Title:  <h2>Title (Year) Quality Lang Full Movie Watch Online Free</h2>
    //   Info:   Directed by / Written by / Starring by / Genres / Language
    //   Desc:   Plain paragraph after info block
    //   Magnets:<a href="magnet:..." class="mv_button_css">
    //             <small>2.5 gb 1080p</small>  ← this is our source label
    //           </a>
    //   Each magnet button has <small>SIZE QUALITY</small> as visible text
    // ============================================================

    const DEBUG = true;
    function log(...a)  { if (DEBUG) console.log("[MRZ]", ...a); }
    function warn(...a) { if (DEBUG) console.warn("[MRZ WARN]", ...a); }
    function err(...a)  { console.error("[MRZ ERR]", ...a); }

    const FALLBACK_DOMAINS = [
        "https://www.5movierulz.army",
        "https://www.5movierulz.skin",
        "https://www.5movierulz.mobi",
        "https://www.5movierulz.com"
    ];
    const DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    let cachedMainUrl = null;
    async function getMainUrl() {
        if (cachedMainUrl) return cachedMainUrl;
        try {
            const res  = await http_get(DOMAINS_URL);
            const data = JSON.parse(res.body);
            const c    = data["5movierulz"] || data["movierulz"] || null;
            if (c) { try { await http_get(c + "/"); cachedMainUrl = c; return c; } catch (_) {} }
        } catch (e) { err("domains.json:", e.message); }
        for (const d of FALLBACK_DOMAINS) {
            try { await http_get(d + "/"); cachedMainUrl = d; return d; } catch (_) {}
        }
        cachedMainUrl = FALLBACK_DOMAINS[0];
        return cachedMainUrl;
    }

    // ============================================================
    // UTILS
    // ============================================================
    function stripTags(s) {
        return (s || "")
            .replace(/<script[\s\S]*?<\/script>/gi, "")
            .replace(/<style[\s\S]*?<\/style>/gi, "")
            .replace(/<[^>]+>/g, "")
            .replace(/&amp;/g, "&").replace(/&nbsp;/g, " ").replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">").replace(/&quot;/g, '"').replace(/&#\d+;/g, "")
            .replace(/\s+/g, " ").trim();
    }

    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.startsWith("http")) return href;
        if (href.startsWith("/")) return base.replace(/\/$/, "") + href;
        return base.replace(/\/$/, "") + "/" + href;
    }

    function safeDecodeURI(s) {
        if (!s) return "";
        try { return decodeURIComponent(s.replace(/\+/g, " ")); }
        catch (_) { return s.replace(/\+/g, " "); }
    }

    function qualityOf(s) {
        const t = (s || "").toLowerCase();
        if (/\b(4k|2160p|uhd)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t))           return 1080;
        if (/\b720p\b/.test(t))            return 720;
        if (/\b(480p|320p)\b/.test(t))     return 480;
        return 0;
    }

    // Clean title: "Band Melam (2026) DVDScr Telugu Movie Watch Online Free" → "Band Melam (2026)"
    function cleanTitle(raw) {
        if (!raw) return "Unknown";
        let t = stripTags(raw).trim();
        // Remove trailing "Full Movie Watch Online Free" boilerplate
        t = t.replace(/\s+(Full\s+)?Movie\s+Watch\s+Online\s+(Free|HD).*/i, "").trim();
        // Remove quality/source words that come after the year if not already trimmed
        t = t.replace(/\s+(DVDScr|DVDRip|HDRip|BRRip|WEBRip|WEB-DL|BluRay|CAMRip|PreDVD)\s+.*/i, "").trim();
        return t || "Unknown";
    }

    function isSeries(title) {
        return /\bSeason\s*\d|\bS\d{2}\b|\bEP\s*\d|Episode\s*\d/i.test(title);
    }

    // ============================================================
    // PARSE MOVIE GRID
    // Used by: getHome(), search()
    //
    // Each movie card:
    //   <div class="boxed film">
    //     <div class="cont_display">
    //       <a title="..." href="/slug/movie-watch-online-free-NNN.html">
    //         <img src="/uploads/Poster.jpg" alt="Title">
    //       </a>
    //     </div>
    //     <p><b>Title (2026) Quality Lang Movie Watch Online Free</b></p>
    //   </div>
    // ============================================================
    function parseMovieGrid(html, mainUrl) {
        const items    = [];
        const seenHref = new Set();

        // Walk through all <a> tags that point to movie-watch-online-free URLs
        let pos = 0;
        while (true) {
            // Find next movie link
            const aStart = html.indexOf("movie-watch-online-free", pos);
            if (aStart === -1) break;

            // Walk back to find the opening <a
            const aOpen = html.lastIndexOf("<a", aStart);
            if (aOpen === -1) { pos = aStart + 1; continue; }

            // Get href
            const hrefIdx = html.indexOf('href="', aOpen);
            if (hrefIdx === -1 || hrefIdx > aStart + 200) { pos = aStart + 1; continue; }
            const hrefStart = hrefIdx + 6;
            const hrefEnd   = html.indexOf('"', hrefStart);
            if (hrefEnd === -1) { pos = aStart + 1; continue; }
            const href = html.substring(hrefStart, hrefEnd);

            if (!href.includes("movie-watch-online-free")) { pos = aStart + 24; continue; }
            if (seenHref.has(href)) { pos = aStart + 24; continue; }
            seenHref.add(href);

            // Get img src (poster) — inside the same <a>...</a>
            const aClose = html.indexOf("</a>", aOpen);
            let posterUrl = null;
            const imgIdx = html.indexOf("<img", aOpen);
            if (imgIdx !== -1 && imgIdx < aClose) {
                const srcIdx = html.indexOf('src="', imgIdx);
                if (srcIdx !== -1 && srcIdx < aClose) {
                    const srcStart = srcIdx + 5;
                    const srcEnd   = html.indexOf('"', srcStart);
                    if (srcEnd !== -1) posterUrl = resolveUrl(html.substring(srcStart, srcEnd), mainUrl);
                }
            }

            // Get title from <a title="..."> attribute OR from the <p><b>...</b></p> after
            let rawTitle = "";
            const titleAttrIdx = html.indexOf('title="', aOpen);
            if (titleAttrIdx !== -1 && titleAttrIdx < aStart + 50) {
                const ts = titleAttrIdx + 7;
                const te = html.indexOf('"', ts);
                if (te !== -1) rawTitle = html.substring(ts, te);
            }

            // Fallback: find <b>...</b> near this block
            if (!rawTitle) {
                const bStart = html.indexOf("<b>", aClose);
                if (bStart !== -1 && bStart < aClose + 200) {
                    const bEnd = html.indexOf("</b>", bStart);
                    if (bEnd !== -1) rawTitle = html.substring(bStart + 3, bEnd);
                }
            }

            const title = cleanTitle(rawTitle);
            if (!title || title === "Unknown" || title.length < 3) { pos = aStart + 24; continue; }

            items.push({
                title,
                url:       resolveUrl(href, mainUrl),
                posterUrl,
                type:      isSeries(rawTitle) ? "series" : "movie",
                quality:   qualityOf(rawTitle),
                rawTitle
            });

            pos = aClose + 4;
        }

        log(`parseMovieGrid: ${items.length} items`);
        return items;
    }

    // Convert raw items to MultimediaItem objects
    function toMultimediaItems(items) {
        return items.map(item => new MultimediaItem({
            title:     item.title,
            url:       item.url,
            posterUrl: item.posterUrl || undefined,
            type:      item.type      || "movie",
            quality:   item.quality   || 0
        }));
    }

    // ============================================================
    // HOME
    // Fetches homepage, extracts "Featured Movies Free" and "Latest Movies"
    // sections by finding the section heading then slicing HTML until next heading
    // ============================================================
    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            log("getHome:", mainUrl);
            const res  = await http_get(mainUrl + "/");
            const html = res.body;

            function sliceSection(startText, endText) {
                const lower = html.toLowerCase();
                const s = lower.indexOf(startText.toLowerCase());
                if (s === -1) return "";
                const e = endText ? lower.indexOf(endText.toLowerCase(), s + startText.length) : html.length;
                return html.substring(s, e === -1 ? html.length : e);
            }

            const featuredHtml = sliceSection("featured movies free", "latest movies");
            const latestHtml   = sliceSection("latest movies",        "posts navigation");

            log(`featuredHtml: ${featuredHtml.length}c  latestHtml: ${latestHtml.length}c`);

            const featuredItems = featuredHtml ? parseMovieGrid(featuredHtml, mainUrl) : [];
            const latestItems   = latestHtml   ? parseMovieGrid(latestHtml,   mainUrl) : [];

            // Deduplicate latest vs featured
            const featuredUrls = new Set(featuredItems.map(i => i.url));
            const uniqueLatest = latestItems.filter(i => !featuredUrls.has(i.url));

            const homeData = {};
            if (featuredItems.length) homeData["🔥 Featured"]      = toMultimediaItems(featuredItems);
            if (uniqueLatest.length)  homeData["🆕 Latest Movies"] = toMultimediaItems(uniqueLatest);

            if (!Object.keys(homeData).length) {
                // Fallback: return everything from full page
                const allItems = parseMovieGrid(html, mainUrl);
                if (allItems.length) homeData["Movies"] = toMultimediaItems(allItems);
            }

            log(`getHome done: ${Object.keys(homeData).map(k => k + ":" + homeData[k].length).join(", ")}`);
            cb({ success: true, data: homeData });
        } catch (e) {
            err("getHome:", e.message);
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    // ============================================================
    // SEARCH
    // WordPress search: /?s=QUERY
    // Also tries /search/QUERY as fallback
    // ============================================================
    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const q       = encodeURIComponent(query);
            const urls    = [
                `${mainUrl}/?s=${q}`,
                `${mainUrl}/search/${encodeURIComponent(query)}`
            ];

            let items = [];
            for (const url of urls) {
                if (items.length > 0) break;
                try {
                    log("search:", url);
                    const res = await http_get(url);
                    items = parseMovieGrid(res.body, mainUrl);
                    log("search got:", items.length, "items");
                } catch (e) { err("search url:", e.message); }
            }

            cb({ success: true, data: toMultimediaItems(items) });
        } catch (e) {
            err("search:", e.message);
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    // ============================================================
    // LOAD — movie detail page
    //
    // Extracts from the page:
    //   - Title (clean)
    //   - Poster from <img> in movie header area
    //   - Description (plot paragraph)
    //   - Director, Cast, Genres, Language from info block
    //   - All magnet links with their button label (<small>SIZE QUALITY</small>)
    // ============================================================
    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            log("load:", url);
            const res  = await http_get(url);
            const html = res.body;

            // --- Title ---
            // <h2>Band Melam (2026) DVDScr Telugu Full Movie Watch Online Free</h2>
            let rawTitle = "";
            const h2s = html.indexOf("<h2");
            if (h2s !== -1) {
                const h2e = html.indexOf(">", h2s);
                const h2c = html.indexOf("</h2>", h2e);
                if (h2e !== -1 && h2c !== -1) rawTitle = html.substring(h2e + 1, h2c);
            }
            // Fallback to <title> tag
            if (!rawTitle) {
                const ts = html.indexOf("<title>");
                if (ts !== -1) {
                    const te = html.indexOf("</title>", ts);
                    if (te !== -1) rawTitle = html.substring(ts + 7, te);
                }
            }
            const title = cleanTitle(rawTitle);
            log("load title:", title);

            // --- Poster ---
            // The movie poster img is in the content area, right after the h2
            // Pattern: <img ... src="/uploads/Name-Lang-Poster.jpg" ...>
            let posterUrl = null;
            const uploadsIdx = html.indexOf("/uploads/");
            if (uploadsIdx !== -1) {
                // Walk back to find src=" before /uploads/
                const srcIdx = html.lastIndexOf('src="', uploadsIdx);
                if (srcIdx !== -1 && uploadsIdx - srcIdx < 10) {
                    const srcEnd = html.indexOf('"', uploadsIdx);
                    if (srcEnd !== -1) {
                        posterUrl = resolveUrl(html.substring(srcIdx + 5, srcEnd), mainUrl);
                    }
                }
            }
            // og:image fallback
            if (!posterUrl) {
                const ogIdx = html.indexOf('property="og:image"');
                if (ogIdx !== -1) {
                    const cIdx = html.indexOf('content="', ogIdx);
                    if (cIdx !== -1) {
                        const cs = cIdx + 9;
                        const ce = html.indexOf('"', cs);
                        if (ce !== -1) posterUrl = html.substring(cs, ce);
                    }
                }
            }
            log("load poster:", posterUrl);

            // --- Movie info block ---
            // "Directed by:" / "Starring by:" / "Genres:" / "Language:"
            let director = "", cast = [], genres = [], language = "", description = "";

            const dirIdx = html.indexOf("Directed by:");
            if (dirIdx !== -1) {
                const lineEnd = html.indexOf("<br", dirIdx);
                director = stripTags(html.substring(dirIdx + 12, lineEnd !== -1 ? lineEnd : dirIdx + 200)).trim();
            }

            const starIdx = html.indexOf("Starring by:");
            if (starIdx !== -1) {
                const lineEnd = html.indexOf("<br", starIdx);
                const castStr = stripTags(html.substring(starIdx + 12, lineEnd !== -1 ? lineEnd : starIdx + 300)).trim();
                cast = castStr.split(",").map(s => s.trim()).filter(Boolean);
            }

            const genreIdx = html.indexOf("Genres:");
            if (genreIdx !== -1) {
                const lineEnd = html.indexOf("<br", genreIdx);
                const genreStr = stripTags(html.substring(genreIdx + 7, lineEnd !== -1 ? lineEnd : genreIdx + 200)).trim();
                genres = genreStr.split(",").map(s => s.trim()).filter(Boolean);
            }

            const langIdx = html.indexOf("Language:");
            if (langIdx !== -1) {
                const lineEnd = html.indexOf("<br", langIdx);
                language = stripTags(html.substring(langIdx + 9, lineEnd !== -1 ? lineEnd : langIdx + 100)).trim();
            }

            // --- Description ---
            // Paragraph of plot text that appears after the info block
            // It's a plain <p> after the "Language:" line with no links inside
            const descSearchStart = langIdx > 0 ? langIdx : (genreIdx > 0 ? genreIdx : 0);
            let descPos = descSearchStart;
            for (let attempt = 0; attempt < 10; attempt++) {
                const pStart = html.indexOf("<p>", descPos);
                if (pStart === -1) break;
                const pEnd = html.indexOf("</p>", pStart);
                if (pEnd === -1) break;
                const candidate = html.substring(pStart + 3, pEnd);
                const plain = stripTags(candidate).trim();
                // Good description: long enough, no href links inside
                if (plain.length > 60 && !candidate.includes('href=')) {
                    description = plain;
                    break;
                }
                descPos = pEnd + 4;
            }

            log(`load info: director="${director}" cast=${cast.length} genres=${genres.join(",")} lang="${language}"`);
            log(`load desc: "${description.substring(0, 80)}..."`);

            // --- Extract ALL magnet links ---
            // Pattern: <a href="magnet:?xt=..." class="mv_button_css" ...>
            //            <small>2.5 gb 1080p</small>
            //          </a>
            const magnets   = [];
            const seenMag   = new Set();
            let mpos = 0;

            while (true) {
                const magIdx = html.indexOf('href="magnet:', mpos);
                if (magIdx === -1) break;

                const magStart = magIdx + 6; // after href="
                const magEnd   = html.indexOf('"', magStart);
                if (magEnd === -1) break;

                const magnetUrl = html.substring(magStart, magEnd);
                if (seenMag.has(magnetUrl)) { mpos = magEnd + 1; continue; }
                seenMag.add(magnetUrl);

                // Get button label from <small>...</small> inside this <a>...</a>
                const aCloseIdx = html.indexOf("</a>", magEnd);
                let buttonLabel = "";
                if (aCloseIdx !== -1) {
                    const smallIdx = html.indexOf("<small>", magEnd);
                    if (smallIdx !== -1 && smallIdx < aCloseIdx) {
                        const smallEnd = html.indexOf("</small>", smallIdx);
                        if (smallEnd !== -1) {
                            buttonLabel = stripTags(html.substring(smallIdx + 7, smallEnd)).trim();
                        }
                    }
                }

                // Decode dn= from magnet for quality fallback
                const dnMatch = magnetUrl.match(/[?&]dn=([^&]+)/i);
                const dnName  = dnMatch ? safeDecodeURI(dnMatch[1]) : "";
                const quality = qualityOf(buttonLabel) || qualityOf(dnName);

                log(`  magnet: label="${buttonLabel}" Q=${quality} url=${magnetUrl.substring(0, 60)}...`);
                magnets.push({ magnetUrl, buttonLabel, quality, dnName });

                mpos = magEnd + 1;
            }

            // Sort: best quality first
            magnets.sort((a, b) => b.quality - a.quality);
            log(`load: ${magnets.length} magnets found`);

            // --- Build cast actors ---
            const castActors = cast.map(name => new Actor({ name }));

            // --- Build episodes (one per quality variant) ---
            const episodes = magnets.map((m, i) => new Episode({
                name: m.buttonLabel || m.dnName.replace(/^www\.\S+\s*-\s*/i, "").replace(/\.(mkv|mp4|avi)$/i, "").trim() || `Option ${i + 1}`,
                url:  JSON.stringify({
                    magnetUrl:   m.magnetUrl,
                    buttonLabel: m.buttonLabel,
                    quality:     m.quality
                })
            }));

            const type = isSeries(rawTitle) ? "series" : "movie";

            cb({ success: true, data: new MultimediaItem({
                title:       title,
                url,
                posterUrl:   posterUrl  || undefined,
                type,
                description: description || undefined,
                genres,
                cast:        castActors,
                episodes
            }) });

        } catch (e) {
            err("load:", e.message);
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    // ============================================================
    // LOAD STREAMS
    // Input: JSON { magnetUrl, buttonLabel, quality }
    // Output: StreamResult — magnet is the final URL, zero fetches
    // Source label: "[MovieRulz] 2.5 gb 1080p"
    // ============================================================
    async function loadStreams(url, cb) {
        try {
            const { magnetUrl, buttonLabel, quality } = JSON.parse(url);
            log("loadStreams:", buttonLabel, "Q:", quality);

            if (!magnetUrl?.startsWith("magnet:")) {
                warn("not a valid magnet");
                return cb({ success: true, data: [] });
            }

            // Source = "[MovieRulz] 2.5 gb 1080p"  — exactly the button text from the site
            const label = `[MovieRulz]${buttonLabel ? " " + buttonLabel : ""}`.trim();
            log("✓ stream:", label, quality + "p");

            cb({ success: true, data: [
                new StreamResult({
                    url:     magnetUrl,
                    quality: quality || 0,
                    source:  label,
                    headers: {}
                })
            ]});
        } catch (e) {
            err("loadStreams:", e);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    // --- Export ---
    for (const ctx of [
        typeof globalThis !== "undefined" ? globalThis : null,
        typeof window     !== "undefined" ? window     : null,
        typeof global     !== "undefined" ? global     : null
    ]) {
        if (ctx) { ctx.getHome = getHome; ctx.search = search; ctx.load = load; ctx.loadStreams = loadStreams; }
    }
})();
