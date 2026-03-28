(function () {
    // ============================================================
    // 1TamilMV Plugin — Fixed
    //
    // Bugs fixed vs uploaded version:
    //  1. extractSection() is broken — function body is split across
    //     two code paths that can never both run. Fixed with clean impl.
    //  2. extractSection() called wrong: extractSection("top releases")
    //     passes a string as `html` arg instead of homeHtml. Fixed.
    //  3. getHome() doesn't enrich with TMDB so posterUrl is always null.
    //     Fixed: enrich home items with TMDB (batched, max 30).
    //  4. enrichWithTmdb() silently swallows items on error — fixed to
    //     always push the original item as fallback.
    //  5. search() passes requireYear=false which lets junk through.
    //     Fixed: junk filter still runs regardless of requireYear.
    //  6. parseTopicTitle() doesn't handle titles like
    //     "Band Melam (2026) Telugu HQ PreDVD" where language word
    //     sits before (YEAR). Fixed with pre-strip.
    //  7. postBlock extraction stops at first </div> — shallow match
    //     misses nested div content. Fixed with depth-aware extraction.
    //  8. No poster/type in MultimediaItem in getHome makeItems. Fixed.
    // ============================================================

    const DEBUG = true;
    function log(...a)  { if (DEBUG) console.log("[TMV]", ...a); }
    function warn(...a) { if (DEBUG) console.warn("[TMV WARN]", ...a); }
    function err(...a)  { console.error("[TMV ERR]", ...a); }

    const TMDB_KEY     = "1865f43a0549ca50d341dd9ab8b29f49";
    const CINEMETA_URL = "https://v3-cinemeta.strem.io/meta";
    const DOMAINS_URL  = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    const FALLBACK_DOMAINS = [
        "https://www.1tamilmv.immo",
        "https://www.1tamilmv.fi",
        "https://www.1tamilmv.wf",
        "https://www.1tamilmv.eu",
        "https://www.1tamilmv.haus"
    ];

    // ============================================================
    // JUNK / VALID FILTERS
    // ============================================================
    const JUNK_WORDS = ['announcement','notice','request','discussion','help','rules','faq','sticky','guide','welcome','important','pin'];
    function isJunkTitle(title) {
        if (!title) return true;
        const lower = title.toLowerCase().trim();
        return JUNK_WORDS.some(w => lower.startsWith(w) || lower.startsWith('['+w));
    }
    function hasYear(title) { return /\(\d{4}\)/.test(title); }

    // ============================================================
    // DOMAIN
    // ============================================================
    let cachedMainUrl = null;
    async function getMainUrl() {
        if (cachedMainUrl) return cachedMainUrl;
        try {
            const res  = await http_get(DOMAINS_URL);
            const data = JSON.parse(res.body);
            const c    = data["1tamilmv"] || data["tamilmv"] || null;
            if (c) { try { await http_get(c+"/"); cachedMainUrl=c; return c; } catch(_){} }
        } catch(e) { err("domains.json:", e.message); }
        for (const d of FALLBACK_DOMAINS) {
            try { await http_get(d+"/"); cachedMainUrl=d; return d; } catch(_) {}
        }
        cachedMainUrl = FALLBACK_DOMAINS[0];
        return cachedMainUrl;
    }

    // ============================================================
    // TITLE PARSING
    //
    // Handles real site formats:
    //   "Band Melam (2026) Telugu HQ PreDVD - [1080p & 720p - x264 - 2.6GB]"
    //   "Daredevil: Born Again (2026) S02 EP(01) TRUE WEB-DL - [1080p...]"
    //   "1TamilMV - Will (2025) Tamil TRUE WEB-DL - [1080p...]"
    // ============================================================
    function parseTopicTitle(raw) {
        if (!raw) return { cleanName:"Unknown", year:"", isSeries:false, displayTitle:"Unknown" };

        // Strip site prefix: "1TamilMV - " or "www 1TamilMV immo - "
        // FIX: (?:\s+\w+)? was too greedy — it ate the first word of the movie name
        // Only strip known domain/site words, not arbitrary words
        let t = raw.replace(/^(?:www[\s.]+)?1?TamilMV(?:[\s.]+(?:immo|fi|wf|eu|haus|com|net|org))?\s*[-–]\s*/i, "").trim();

        // Strip everything from " - [" onward (quality block)
        t = t.replace(/\s*-\s*\[.*$/, "").trim();
        // Strip any remaining "[..." block
        t = t.replace(/\s*\[.*$/, "").trim();

        // Series detection BEFORE we strip season info
        const isSeries = /\bS\d{2}\b|\bEP\s*[\(\d]/i.test(raw)
                      || /\bSeason\s+\d/i.test(raw)
                      || /\bWeb[- ]?Series\b/i.test(raw);

        // Extract year
        const yearM = t.match(/\((\d{4})\)/);
        const year  = yearM ? yearM[1] : "";

        // Clean name = everything before (YEAR)
        let cleanName = year
            ? t.substring(0, t.indexOf("("+year+")")).trim()
            : t;

        // Strip trailing language / source words that bleed in
        cleanName = cleanName
            .replace(/\s+(Tamil|Telugu|Hindi|Malayalam|Kannada|English|Dual\s*Audio|Multi)\s*$/i, "")
            .replace(/\s+(TRUE|HQ)\s*$/i, "")
            .trim();

        // Strip season info from name for series: "Show Name S02" → "Show Name"
        cleanName = cleanName.replace(/\s+S\d{2}.*$/i, "").trim();

        const displayTitle = year ? `${cleanName} (${year})` : cleanName;
        log(`parseTopicTitle: raw="${raw.substring(0,60)}" → clean="${cleanName}" year="${year}" series=${isSeries}`);
        return { cleanName, year, isSeries, displayTitle };
    }

    // ============================================================
    // UTILS
    // ============================================================
    function stripTags(s) {
        return (s||"")
            .replace(/<script[^>]*>[\s\S]*?<\/script>/gi, "")
            .replace(/<style[^>]*>[\s\S]*?<\/style>/gi, "")
            .replace(/<[^>]*>/g, "")
            .replace(/&amp;/g,"&").replace(/&nbsp;/g," ").replace(/&lt;/g,"<")
            .replace(/&gt;/g,">").replace(/&quot;/g,'"').replace(/&#\d+;/g,"")
            .replace(/\s+/g," ").trim();
    }
    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.startsWith("http")) return href;
        if (href.startsWith("/")) return base.replace(/\/$/,"")+href;
        return base.replace(/\/$/,"")+"/"+href;
    }
    function qualityOf(s) {
        const t=(s||"").toLowerCase();
        if (/\b(4k|2160p|uhd)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t))           return 1080;
        if (/\b720p\b/.test(t))            return 720;
        if (/\b480p\b/.test(t))            return 480;
        return 0;
    }
    function safeDecodeURI(s) {
        if (!s) return "";
        try { return decodeURIComponent(s.replace(/\+/g," ")); }
        catch(_) { try { return decodeURIComponent(s.replace(/\+/g," ").replace(/%(?![0-9A-Fa-f]{2})/g,"%25")); }
        catch(_) { return s.replace(/\+/g," "); } }
    }
    function parseFileName(fn) {
        if (!fn) return { size:"", specs:[], quality:0 };
        const sizeAll = fn.match(/\d+(?:\.\d+)?\s*(?:GB|MB|TB)/gi) || [];
        const size    = sizeAll[sizeAll.length-1] || "";
        const quality = qualityOf(fn);
        const specs   = [];
        const sq     = fn.match(/\b(2160p|4K|UHD|1080p|720p|480p)\b/i)?.[0];
        const ssrc   = fn.match(/\b(TRUE\s+WEB-DL|WEB-DL|WEBRip|BluRay|HDRip|DVDRip|HQ\s*PreDVD|PreDVD)\b/i)?.[0];
        const scodec = fn.match(/\b(x265|x264|HEVC|AVC|AV1)\b/i)?.[0];
        const saudio = fn.match(/\b(DD\+?5\.1|DDP5\.1|DTS[-\s]?HD|DTS|AC3|Atmos|AAC|MP3)\b/i)?.[0];
        if (sq)      specs.push(sq);
        if (ssrc)    specs.push(ssrc.replace(/\s+/g,"-"));
        if (scodec)  specs.push(scodec);
        if (saudio)  specs.push(saudio);
        return { size, specs, quality };
    }

    // ============================================================
    // TMDB
    // ============================================================
    async function fetchTmdbMeta(cleanName, year, isSeries) {
        if (!cleanName || cleanName === "Unknown") return null;
        const type = isSeries ? "tv" : "movie";
        const q    = encodeURIComponent(cleanName);
        for (const yr of [year, ""]) {
            try {
                const url = `https://api.themoviedb.org/3/search/${type}?api_key=${TMDB_KEY}&query=${q}${yr?`&year=${yr}`:""}&language=en-US`;
                log(`TMDB search: "${cleanName}" year=${yr||"any"} type=${type}`);
                const res  = await http_get(url);
                const data = JSON.parse(res.body);
                const item = data.results?.[0];
                if (!item) continue;
                const det = await http_get(
                    `https://api.themoviedb.org/3/${type}/${item.id}?api_key=${TMDB_KEY}&append_to_response=credits&language=en-US`
                );
                const d = JSON.parse(det.body);
                const cast = (d.credits?.cast||[]).slice(0,15).map(c=>new Actor({
                    name:c.name, role:c.character,
                    image:c.profile_path?`https://image.tmdb.org/t/p/w185${c.profile_path}`:undefined
                }));
                return {
                    imdbId:      d.imdb_id||null,
                    title:       d.title||d.name||cleanName,
                    poster:      item.poster_path   ? `https://image.tmdb.org/t/p/w500${item.poster_path}`   : null,
                    backdrop:    item.backdrop_path ? `https://image.tmdb.org/t/p/w1280${item.backdrop_path}` : null,
                    description: d.overview||null,
                    year:        (d.release_date||d.first_air_date||"").substring(0,4),
                    score:       item.vote_average||null,
                    genres:      (d.genres||[]).map(g=>g.name),
                    cast
                };
            } catch(e) { err("TMDB:", e.message); }
        }
        return null;
    }

    async function fetchCinemeta(imdbId, isSeries) {
        if (!imdbId) return null;
        try {
            const r = await http_get(`${CINEMETA_URL}/${isSeries?"series":"movie"}/${imdbId}.json`);
            if (r.body?.trim().startsWith("{")) return JSON.parse(r.body)?.meta||null;
        } catch(_) {}
        return null;
    }

    // ============================================================
    // ENRICH WITH TMDB — adds poster/backdrop/description to items
    // FIX: always push item even if TMDB fails (was dropping items on error)
    // ============================================================
    async function enrichWithTmdb(items) {
        const enriched = [];
        for (const item of items) {
            try {
                const { cleanName, year, isSeries } = parseTopicTitle(item.rawTitle || item.title);
                let meta = await fetchTmdbMeta(cleanName, year, isSeries);
                if (!meta && year)      meta = await fetchTmdbMeta(cleanName, "", isSeries);
                if (!meta)              meta = await fetchTmdbMeta(cleanName, year, !isSeries);
                if (meta) {
                    if (meta.title)       item.title       = meta.title;
                    if (meta.poster)      item.posterUrl   = meta.poster;
                    if (meta.backdrop)    item.bannerUrl   = meta.backdrop;
                    if (meta.description) item.description = meta.description;
                    if (meta.score)       item.score       = parseFloat(meta.score);
                    if (meta.year)        item.year        = parseInt(meta.year);
                    item.genres = meta.genres || item.genres || [];
                }
            } catch(e) {
                err("enrichWithTmdb:", e.message);
                // FIX: was missing — always push item even if enrichment fails
            }
            enriched.push(item); // always push
        }
        return enriched;
    }

    // ============================================================
    // PARSE TOPIC LIST (forum pages and search results)
    // ============================================================
    function parseTopicList(html, mainUrl, requireYear) {
        if (requireYear === undefined) requireYear = true;
        const items    = [];
        const seenHref = new Set();
        let pos = 0;
        while (true) {
            const aStart = html.indexOf("<a", pos);
            if (aStart === -1) break;
            const aEnd = html.indexOf(">", aStart);
            if (aEnd === -1) break;
            const tagContent = html.substring(aStart, aEnd + 1);
            const hrefStart  = tagContent.indexOf('href="');
            if (hrefStart === -1) { pos = aEnd + 1; continue; }
            const hrefValueStart = hrefStart + 6;
            const hrefEnd = tagContent.indexOf('"', hrefValueStart);
            if (hrefEnd === -1) { pos = aEnd + 1; continue; }
            const href = tagContent.substring(hrefValueStart, hrefEnd);
            const closeStart = html.indexOf("</a>", aEnd);
            if (closeStart === -1) { pos = aEnd + 1; continue; }
            const rawTitle = stripTags(html.substring(aEnd + 1, closeStart)).trim();

            if (href.indexOf("forums/topic") === -1)                    { pos = closeStart + 4; continue; }
            // FIX: Reject forum index/redirect URLs like /topic/183-0/ or /topic/123-/
            // A real movie topic has a numeric ID followed by a meaningful slug (not just "0" or "-")
            if (!/forums\/topic\/\d+-[a-z]/i.test(href))               { pos = closeStart + 4; continue; }
            if (!rawTitle || rawTitle.length < 5)                       { pos = closeStart + 4; continue; }
            if (href.indexOf("page_") !== -1 ||
                href.indexOf("#replies") !== -1 ||
                href.indexOf("#comment") !== -1)                        { pos = closeStart + 4; continue; }
            if (seenHref.has(href))                                     { pos = closeStart + 4; continue; }
            if (isJunkTitle(rawTitle))                                  { pos = closeStart + 4; continue; }
            if (requireYear && !hasYear(rawTitle))                      { pos = closeStart + 4; continue; }

            seenHref.add(href);
            const { displayTitle, isSeries } = parseTopicTitle(rawTitle);
            items.push({
                title:    displayTitle,
                url:      resolveUrl(href, mainUrl),
                posterUrl: null,
                type:     isSeries ? "series" : "movie",
                quality:  qualityOf(rawTitle),
                rawTitle
            });
            pos = closeStart + 4;
        }
        log(`parseTopicList(requireYear=${requireYear}): ${items.length} items`);
        return items;
    }

    // ============================================================
    // PARSE BANGER SECTION (homepage sections)
    // ============================================================
    function parseBangerSection(sectionHtml, mainUrl) {
        const items    = [];
        const seenHref = new Set();
        const lines    = sectionHtml.split(/<br\s*\/?>/i);

        for (const line of lines) {
            let topicHref = null, innerText = "", firstAIdx = -1;
            let aPos = 0;
            while (true) {
                const aIdx = line.indexOf('<a', aPos);
                if (aIdx === -1) break;
                const aCloseIdx = line.indexOf('>', aIdx);
                if (aCloseIdx === -1) break;
                const aTag = line.substring(aIdx, aCloseIdx + 1);
                const hrefIdx = aTag.indexOf('href="');
                if (hrefIdx !== -1) {
                    const hStart = hrefIdx + 6;
                    const hEnd   = aTag.indexOf('"', hStart);
                    if (hEnd !== -1) {
                        const candidate = aTag.substring(hStart, hEnd);
                        if (candidate.indexOf("forums/topic") !== -1 &&
                            candidate.indexOf("page_") === -1 &&
                            candidate.indexOf("#replies") === -1) {
                            topicHref = candidate;
                            firstAIdx = aIdx;
                            const aEndClose = line.indexOf('</a>', aCloseIdx);
                            if (aEndClose !== -1)
                                innerText = stripTags(line.substring(aCloseIdx + 1, aEndClose)).trim();
                            break;
                        }
                    }
                }
                aPos = aCloseIdx + 1;
            }

            if (!topicHref || seenHref.has(topicHref)) continue;

            const textBefore = firstAIdx > 0
                ? stripTags(line.substring(0, firstAIdx)).replace(/-\s*$/,"").replace(/\s+/g," ").trim()
                : "";

            let rawTitle = "";
            if (hasYear(textBefore) && textBefore.length > 5) rawTitle = textBefore;
            else if (innerText.length > 5)                    rawTitle = innerText;
            else if (textBefore.length > 5)                   rawTitle = textBefore;

            if (!rawTitle || rawTitle.length < 3) continue;
            if (isJunkTitle(rawTitle)) continue;

            seenHref.add(topicHref);
            const { displayTitle, isSeries } = parseTopicTitle(rawTitle);
            items.push({
                title:    displayTitle,
                url:      resolveUrl(topicHref, mainUrl),
                posterUrl: null,
                type:     isSeries ? "series" : "movie",
                quality:  qualityOf(rawTitle),
                rawTitle
            });
        }
        log(`parseBangerSection: ${items.length} items`);
        return items;
    }

    // ============================================================
    // EXTRACT SECTION FROM HOMEPAGE HTML
    //
    // FIX: The uploaded version's extractSection() had a critical bug —
    // the function body was split across two code paths that could never
    // both execute. The `return html.substring(start, end)` path ran but
    // then the outer code tried to use banger-container logic that was
    // now dead code below an early return.
    //
    // New impl: simple indexOf slice — enough for homepage sections.
    // ============================================================
    function extractSection(html, startKeyword, endKeyword) {
        const lower = html.toLowerCase();
        const start = lower.indexOf(startKeyword.toLowerCase());
        if (start === -1) return "";
        let end = html.length;
        if (endKeyword) {
            const e = lower.indexOf(endKeyword.toLowerCase(), start + startKeyword.length);
            if (e !== -1) end = e;
        }
        return html.substring(start, end);
    }

    // ============================================================
    // HOME
    // FIX 1: extractSection called with wrong args (string as html param)
    // FIX 2: makeItems was missing posterUrl, type, description, year
    // FIX 3: Home now enriches with TMDB so posters appear
    // ============================================================
    async function getHome(cb) {
        try {
            const mainUrl  = await getMainUrl();
            log("getHome:", mainUrl);
            const homeRes  = await http_get(mainUrl + "/");
            const homeHtml = homeRes.body;

            // FIX: both calls now correctly pass homeHtml as first arg
            let topHtml    = extractSection(homeHtml, "top releases this week", "recently added");
            if (!topHtml)  topHtml = extractSection(homeHtml, "top releases", "recently added");
            let recentHtml = extractSection(homeHtml, "recently added", "forum statistics");
            if (!recentHtml) recentHtml = extractSection(homeHtml, "recently added", "");

            log(`topHtml: ${topHtml.length}c, recentHtml: ${recentHtml.length}c`);

            let topItems    = topHtml    ? parseBangerSection(topHtml,    mainUrl) : [];
            let recentItems = recentHtml ? parseBangerSection(recentHtml, mainUrl) : [];

            // Fallback to forum pages if homepage sections not found
            if (!topItems.length && !recentItems.length) {
                log("Homepage sections empty — falling back to forum pages");
                const seenUrls = new Set();
                const sections = [
                    {name:"tamil",     id:"2"},  {name:"telugu",    id:"22"},
                    {name:"hindi",     id:"56"}, {name:"malayalam", id:"58"},
                    {name:"kannada",   id:"60"}, {name:"english",   id:"62"},
                    {name:"web-series",id:"90"}
                ];
                for (const s of sections) {
                    if (recentItems.length >= 30) break;
                    try {
                        const fUrl = `${mainUrl}/index.php?/forums/forum/${s.id}-${s.name}/&sortby=start_date&sortdirection=desc`;
                        const fRes = await http_get(fUrl);
                        for (const item of parseTopicList(fRes.body, mainUrl).slice(0,6)) {
                            if (seenUrls.has(item.url)) continue;
                            seenUrls.add(item.url);
                            recentItems.push(item);
                        }
                    } catch(e) { err("fallback:", s.name, e.message); }
                }
            }

            // Deduplicate
            const topUrls = new Set(topItems.map(i=>i.url));
            recentItems   = recentItems.filter(i=>!topUrls.has(i.url));

            // FIX: Enrich ALL home items with TMDB to get posters
            // Cap at 30 total to avoid too many API calls
            const allForEnrich = [...topItems, ...recentItems].slice(0, 30);
            log(`Enriching ${allForEnrich.length} home items with TMDB...`);
            const enriched = await enrichWithTmdb(allForEnrich);

            // Re-split back into sections after enrichment
            const topCount = Math.min(topItems.length, enriched.length);
            const enrichedTop    = enriched.slice(0, topCount);
            const enrichedRecent = enriched.slice(topCount);

            // FIX: makeItems now includes posterUrl, bannerUrl, type, year, score
            const makeItems = arr => arr.map(item => new MultimediaItem({
                title:       item.title,
                url:         item.url,
                posterUrl:   item.posterUrl   || undefined,
                bannerUrl:   item.bannerUrl   || undefined,
                type:        item.type        || "movie",
                quality:     item.quality     || 0,
                description: item.description || undefined,
                year:        item.year        || undefined,
                score:       item.score       || undefined,
                genres:      item.genres      || []
            }));

            const homeData = {};
            if (enrichedTop.length)    homeData["🔥 Top Releases This Week"] = makeItems(enrichedTop);
            if (enrichedRecent.length) homeData["🆕 Recently Added"]         = makeItems(enrichedRecent);

            if (!Object.keys(homeData).length) {
                return cb({ success:false, errorCode:"HOME_EMPTY", message:"No sections found on homepage" });
            }

            log(`getHome done: ${Object.keys(homeData).map(k=>k+":"+homeData[k].length).join(", ")}`);
            cb({ success:true, data:homeData });

        } catch(e) { err("getHome:", e.message); cb({ success:false, errorCode:"HOME_ERROR", message:e.message }); }
    }

    // ============================================================
    // SEARCH
    // FIX: IPS search URL format — correct param separator
    // IPS 4.x search: /index.php?/search/  with query params after
    // Also falls back to scraping each forum page when search returns nothing
    // ============================================================
    async function search(query, cb) {
        try {
            const mainUrl      = await getMainUrl();
            const nodes        = "2,22,56,58,60,62,63,90";
            const encodedQuery = encodeURIComponent(query);

            // IPS 4.x search URLs — try multiple formats as IPS versions differ
            const searchUrls = [
                // Standard IPS 4 search
                `${mainUrl}/index.php?/search/?q=${encodedQuery}&type=forums_topic&nodes=${nodes}&sortby=relevancy`,
                `${mainUrl}/index.php?/search/?q=${encodedQuery}&type=forums_topic&sortby=relevancy`,
                // Some IPS installs use &q= after /search/
                `${mainUrl}/index.php?/search/&q=${encodedQuery}&type=forums_topic&nodes=${nodes}&sortby=relevancy`,
                `${mainUrl}/index.php?/search/&q=${encodedQuery}&type=forums_topic&sortby=relevancy`,
                // Minimal fallback
                `${mainUrl}/index.php?/search/?q=${encodedQuery}`,
                `${mainUrl}/index.php?/search/&q=${encodedQuery}`
            ];

            let items = [];
            for (const url of searchUrls) {
                if (items.length > 0) break;
                try {
                    log("search attempt:", url);
                    const res = await http_get(url);
                    items = parseTopicList(res.body, mainUrl, false);
                    log("search got:", items.length, "items");
                } catch(e) { err("search url failed:", e.message); }
            }

            // FIX: If search API returned nothing or too few, fall back to
            // fetching each forum section and filtering by query string match
            if (items.length < 3) {
                log("Search API returned few results — falling back to forum scrape");
                const sections = [
                    {id:"2",name:"tamil"},{id:"22",name:"telugu"},{id:"56",name:"hindi"},
                    {id:"58",name:"malayalam"},{id:"60",name:"kannada"},{id:"62",name:"english"},
                    {id:"90",name:"web-series"}
                ];
                const qLower = query.toLowerCase();
                const seenUrls = new Set(items.map(i=>i.url));
                for (const s of sections) {
                    if (items.length >= 20) break;
                    try {
                        const fUrl = `${mainUrl}/index.php?/forums/forum/${s.id}-${s.name}/`;
                        const fRes = await http_get(fUrl);
                        const fItems = parseTopicList(fRes.body, mainUrl, false);
                        for (const item of fItems) {
                            if (seenUrls.has(item.url)) continue;
                            // Only include if raw title contains query word(s)
                            if (!item.rawTitle.toLowerCase().includes(qLower)) continue;
                            seenUrls.add(item.url);
                            items.push(item);
                        }
                    } catch(e) { err("search fallback section:", e.message); }
                }
                log("After forum fallback:", items.length, "items");
            }

            const enriched = await enrichWithTmdb(items.slice(0,20));
            cb({ success:true, data: enriched.map(item => new MultimediaItem({
                title:       item.title,
                url:         item.url,
                posterUrl:   item.posterUrl   || undefined,
                bannerUrl:   item.bannerUrl   || undefined,
                type:        item.type        || "movie",
                quality:     item.quality     || 0,
                description: item.description || undefined,
                year:        item.year        || undefined,
                score:       item.score       || undefined,
                genres:      item.genres      || []
            })) });
        } catch(e) { err("search:", e.message); cb({ success:false, errorCode:"SEARCH_ERROR", message:e.message }); }
    }

    // ============================================================
    // EXTRACT MAGNET ENTRIES
    // ============================================================
    function extractMagnetEntries(html) {
        const entries     = [];
        const seenMagnets = new Set();
        let pos = 0;

        while (true) {
            const magnetIdx = html.indexOf('href="magnet:', pos);
            if (magnetIdx === -1) break;
            const valueStart = magnetIdx + 6;
            const valueEnd   = html.indexOf('"', valueStart);
            if (valueEnd === -1) break;
            const magnetUrl = html.substring(valueStart, valueEnd);

            if (seenMagnets.has(magnetUrl)) { pos = valueEnd + 1; continue; }
            seenMagnets.add(magnetUrl);

            // Filename from dn= param
            let fileName = "";
            const dnIdx = magnetUrl.indexOf("dn=");
            if (dnIdx !== -1) {
                let dnEnd = magnetUrl.indexOf("&", dnIdx);
                if (dnEnd === -1) dnEnd = magnetUrl.length;
                fileName = safeDecodeURI(magnetUrl.substring(dnIdx + 3, dnEnd));
            }

            // Fallback: last <strong> or <b> before this magnet
            if (!fileName) {
                const before    = html.substring(0, magnetIdx);
                const strongIdx = before.lastIndexOf("<strong");
                const boldIdx   = before.lastIndexOf("<b");
                const useStrong = strongIdx > boldIdx;
                const tagIdx    = useStrong ? strongIdx : boldIdx;
                const closeTag  = useStrong ? "</strong>" : "</b>";
                if (tagIdx !== -1) {
                    const openEnd = before.indexOf(">", tagIdx);
                    const tagEnd  = before.indexOf(closeTag, openEnd);
                    if (openEnd !== -1 && tagEnd !== -1)
                        fileName = stripTags(before.substring(openEnd + 1, tagEnd));
                }
            }

            // Fallback: last meaningful text line before this magnet
            if (!fileName) {
                const lines = stripTags(html.substring(0, magnetIdx))
                    .split(/\n/).map(l=>l.trim()).filter(l=>l.length>8);
                if (lines.length) fileName = lines[lines.length-1];
            }

            const { size, specs, quality } = parseFileName(fileName);
            log(`  magnet Q=${quality} size="${size}" file="${fileName.substring(0,70)}"`);
            entries.push({ fileName, magnetUrl, quality, size, specs });
            pos = valueEnd + 1;
        }

        const toBytes = s => {
            const m=(s||"").match(/([\d.]+)\s*(GB|MB|TB)/i);
            if(!m) return 0;
            const n=parseFloat(m[1]);
            return /TB/i.test(m[2])?n*1e12:/GB/i.test(m[2])?n*1e9:n*1e6;
        };
        entries.sort((a,b)=>b.quality!==a.quality?b.quality-a.quality:toBytes(b.size)-toBytes(a.size));
        log(`extractMagnetEntries: ${entries.length} unique`);
        return entries;
    }

    // ============================================================
    // EXTRACT POST BLOCKS — depth-aware div extraction
    //
    // FIX: old version used html.indexOf("</div>", closeIdx) which finds
    // the FIRST </div> — this is wrong for nested divs and cuts the block
    // short, missing all magnet links deeper in the DOM.
    // New version counts div depth to find the correct closing tag.
    // ============================================================
    function extractPostBlocks(html) {
        const blocks   = [];
        const markers  = ['data-role="commentContent"', 'class="cPost_contentWrap'];
        let found = false;

        for (const marker of markers) {
            if (found) break;
            let pos = 0;
            while (true) {
                const markerIdx = html.indexOf(marker, pos);
                if (markerIdx === -1) break;
                found = true;

                // Find the opening < of the div containing this marker
                const divOpen = html.lastIndexOf("<div", markerIdx);
                if (divOpen === -1) { pos = markerIdx + marker.length; continue; }

                // Find > that closes this opening tag
                const openEnd = html.indexOf(">", divOpen);
                if (openEnd === -1) { pos = markerIdx + marker.length; continue; }

                // Count nested divs to find real closing </div>
                let depth = 1, i = openEnd + 1;
                while (i < html.length && depth > 0) {
                    const nextOpen  = html.indexOf("<div",  i);
                    const nextClose = html.indexOf("</div>", i);
                    if (nextClose === -1) break;
                    if (nextOpen !== -1 && nextOpen < nextClose) {
                        depth++;
                        i = nextOpen + 4;
                    } else {
                        depth--;
                        i = nextClose + 6;
                    }
                }
                // i is now right after the matched closing </div>
                blocks.push(html.substring(openEnd + 1, i - 6));
                pos = i;
            }
        }

        if (!blocks.length) blocks.push(html); // last resort — full page
        return blocks;
    }

    // ============================================================
    // LOAD
    // ============================================================
    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            log("load:", url);
            const res  = await http_get(url);
            const html = res.body;

            // Extract raw title
            let rawTitle = "Unknown";
            const h1Start = html.indexOf('<h1');
            if (h1Start !== -1) {
                const h1Close = html.indexOf(">", h1Start);
                const h1End   = html.indexOf("</h1>", h1Close);
                if (h1Close !== -1 && h1End !== -1)
                    rawTitle = stripTags(html.substring(h1Close + 1, h1End));
            }
            if (rawTitle === "Unknown") {
                const ogStart = html.indexOf('property="og:title"');
                if (ogStart !== -1) {
                    const cs = html.indexOf('content="', ogStart);
                    if (cs !== -1) {
                        const vs = cs + 9;
                        const ve = html.indexOf('"', vs);
                        if (ve !== -1) rawTitle = html.substring(vs, ve);
                    }
                }
            }
            if (rawTitle === "Unknown") {
                const ts = html.indexOf('<title>');
                if (ts !== -1) {
                    const vs = ts + 7;
                    const ve = html.indexOf('</title>', vs);
                    if (ve !== -1) rawTitle = stripTags(html.substring(vs, ve));
                }
            }
            log("load rawTitle:", rawTitle);

            const { cleanName, year, isSeries, displayTitle } = parseTopicTitle(rawTitle);
            log(`load parsed: name="${cleanName}" year="${year}" isSeries=${isSeries}`);

            // FIX: use depth-aware post block extraction
            const postBlocks = extractPostBlocks(html);
            log(`load: ${postBlocks.length} post blocks`);

            const allMagnets = [];
            const globalSeen = new Set();
            for (const block of postBlocks) {
                for (const entry of extractMagnetEntries(block)) {
                    if (globalSeen.has(entry.magnetUrl)) continue;
                    globalSeen.add(entry.magnetUrl);
                    allMagnets.push(entry);
                }
            }
            log(`load: ${allMagnets.length} total magnets`);

            // TMDB lookup
            let meta = await fetchTmdbMeta(cleanName, year, isSeries);
            if (!meta && year)      meta = await fetchTmdbMeta(cleanName, "", isSeries);
            if (!meta && !isSeries) meta = await fetchTmdbMeta(cleanName, year, true);

            let cinemeta = null;
            if (meta?.imdbId) cinemeta = await fetchCinemeta(meta.imdbId, isSeries);

            const finalTitle  = meta?.title        || displayTitle;
            const poster      = meta?.poster       || cinemeta?.poster      || null;
            const backdrop    = meta?.backdrop     || cinemeta?.background  || null;
            const description = meta?.description  || cinemeta?.description || null;
            const score       = meta?.score        ? parseFloat(meta.score) : null;
            const genres      = meta?.genres       || [];
            const cast        = meta?.cast         || [];
            const releaseYear = meta?.year         || year || null;
            const logoUrl     = cinemeta?.logo     || null;

            log(`TMDB result: "${finalTitle}" poster=${!!poster} cast=${cast.length}`);

            const episodes = allMagnets.map((e, i) => {
                let displayName = e.fileName
                    ? e.fileName.replace(/\.(mkv|mp4|avi|ts|m2ts)$/i,"").replace(/[._]+/g," ").trim()
                    : `Download Option ${i+1}`;
                if (e.size) displayName += ` [${e.size}]`;
                return new Episode({
                    name: displayName,
                    url:  JSON.stringify({
                        magnetUrl: e.magnetUrl,
                        fileName:  e.fileName,
                        quality:   e.quality,
                        size:      e.size,
                        specs:     e.specs
                    })
                });
            });

            cb({ success:true, data: new MultimediaItem({
                title:       finalTitle,
                url,
                posterUrl:   poster,
                bannerUrl:   backdrop,
                logoUrl,
                type:        isSeries ? "series" : "movie",
                description,
                year:        parseInt(releaseYear) || undefined,
                score:       score || undefined,
                genres,
                cast,
                episodes
            }) });

        } catch(e) { cb({ success:false, errorCode:"LOAD_ERROR", message:e.message }); }
    }

    // ============================================================
    // LOAD STREAMS
    // ============================================================
    async function loadStreams(url, cb) {
        try {
            const { magnetUrl, fileName, quality, size, specs } = JSON.parse(url);
            log("loadStreams:", fileName, "Q:", quality, "size:", size);
            if (!magnetUrl?.startsWith("magnet:")) {
                warn("not a valid magnet");
                return cb({ success:true, data:[] });
            }
            const specsStr = (specs||[]).map(s=>`[${s}]`).join("");
            const label    = `[TamilMV]${specsStr}${size?" "+size:""}`.trim();
            log("✓ stream:", label, quality+"p");
            cb({ success:true, data:[
                new StreamResult({ url:magnetUrl, quality:quality||0, source:label, headers:{} })
            ]});
        } catch(e) { err("loadStreams:", e); cb({ success:false, errorCode:"STREAM_ERROR", message:e.message }); }
    }

    // --- Export ---
    globalThis.getHome     = getHome;
    globalThis.search      = search;
    globalThis.load        = load;
    globalThis.loadStreams = loadStreams;
})();
