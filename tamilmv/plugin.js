(function () {
    // ============================================================
    // 1TamilMV Plugin v3
    //
    // Real page structure (IPS Forum):
    //   Topic title slug: "band-melam-2026-telugu-hq-predvd-1080p-720p-..."
    //   Post body per quality variant:
    //     <strong>Band.Melam.2026.Telugu.HQ.PreDVD.1080p.x264.2.6GB</strong>
    //     <a href="magnet:?xt=urn:btih:HASH&dn=...&tr=...">Magnet</a>
    //
    //   One topic = one movie, multiple magnets = multiple quality variants
    //   Each magnet preceded by its own filename (has size embedded)
    // ============================================================

    const DEBUG = true;
    function log(...a)  { if (DEBUG) console.log("[TMV]", ...a); }
    function warn(...a) { if (DEBUG) console.warn("[TMV WARN]", ...a); }
    function err(...a)  { console.error("[TMV ERR]", ...a); }

    const TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    const CINEMETA_URL = "https://v3-cinemeta.strem.io/meta";
    const DOMAINS_URL  = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    const FALLBACK_DOMAINS = [
        "https://www.1tamilmv.immo",
        "https://www.1tamilmv.fi",
        "https://www.1tamilmv.wf",
        "https://www.1tamilmv.eu",
        "https://www.1tamilmv.haus"
    ];

    // Movie forum IDs only — excludes announcements/requests/general
    const MOVIE_FORUM_IDS = ["2","22","56","58","60","62","63","90","3","4","5"];

    // Junk topic filter
    const JUNK_RE   = /^\[?(announcement|notice|request|discussion|help|rules|faq|sticky|guide|welcome|important)\b/i;
    const VALID_RE  = /\(\d{4}\)|\b(1080p|720p|480p|2160p|4K|UHD|WEB-DL|WEBRip|BluRay|HDRip|DVDRip|PreDVD|HQ\s+PreDVD)\b/i;

    // ============================================================
    // DOMAIN
    // ============================================================
    let cachedMainUrl = null;
    async function getMainUrl() {
        if (cachedMainUrl) return cachedMainUrl;
        try {
            const res  = await http_get(DOMAINS_URL);
            const data = JSON.parse(res.body);
            const cand = data["1tamilmv"] || data["tamilmv"] || null;
            if (cand) { try { await http_get(cand+"/"); cachedMainUrl=cand; return cand; } catch(_){} }
        } catch(e) { err("domains.json:", e.message); }
        for (const d of FALLBACK_DOMAINS) {
            try { await http_get(d+"/"); cachedMainUrl=d; return d; } catch(_) {}
        }
        cachedMainUrl = FALLBACK_DOMAINS[0];
        return cachedMainUrl;
    }

    // ============================================================
    // UTILS
    // ============================================================
    function stripTags(s) {
        return (s||"").replace(/<[^>]*>/g,"").replace(/&amp;/g,"&").replace(/&nbsp;/g," ")
                      .replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&quot;/g,'"')
                      .replace(/&#\d+;/g,"").replace(/\s+/g," ").trim();
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

    // Extract "Movie Name (Year)" from full IPS slug/title
    // "Band Melam (2026) Telugu HQ PreDVD - [1080p ...]" → "Band Melam (2026)"
    function cleanTitle(raw) {
        if (!raw) return "Unknown";
        let t = stripTags(raw).trim();
        t = t.replace(/\s*-\s*\[.*$/,"").trim();                  // cut " - [..."
        t = t.replace(/\s+(TRUE\s+WEB-DL|WEB-DL|WEBRip|BluRay|HDRip|DVDRip|PreDVD|HQ\s*PreDVD|HQ\s*DVDRip|UHD|HD).*$/i,"").trim();
        t = t.replace(/\s+(Tamil|Telugu|Hindi|Malayalam|Kannada|English|Dual\s+Audio)\s*$/i,"").trim();
        return t || "Unknown";
    }

    // Parse "Band.Melam.2026.Telugu.HQ.PreDVD.1080p.x264.2.6GB" into parts
    // Returns { movieName, year, specs, size }
    function parseFileName(fn) {
        if (!fn) return { movieName:"", year:"", specs:"", size:"" };

        // Size: last token matching NNgb / NNmb / NN.NN GB etc.
        const sizeMatch = fn.match(/(\d+(?:\.\d+)?\s*(?:GB|MB|TB))\b/gi) || [];
        const size = sizeMatch[sizeMatch.length-1] || "";   // last size = this file

        const year  = fn.match(/\b(19|20)\d{2}\b/)?.[0] || "";

        const specs = [];
        const sq    = fn.match(/\b(2160p|4K|UHD|1080p|720p|480p)\b/i)?.[0];
        const ssrc  = fn.match(/\b(TRUE\s+WEB-DL|WEB-DL|WEBRip|BluRay|HDRip|DVDRip|HQ\s*PreDVD|PreDVD)\b/i)?.[0];
        const scodec= fn.match(/\b(x265|x264|HEVC|AVC|AV1|H\.265|H\.264)\b/i)?.[0];
        const saudio= fn.match(/\b(DD\+?5\.1|DDP5\.1|DTS[-\s]?HD|DTS|AC3|Atmos|AAC|MP3)\b/i)?.[0];
        if (sq)      specs.push(sq);
        if (ssrc)    specs.push(ssrc.replace(/\s+/g,"-"));
        if (scodec)  specs.push(scodec);
        if (saudio)  specs.push(saudio);

        // Movie name: everything before the year in dot-separated or space-separated form
        let movieName = "";
        if (year) {
            const idx = fn.indexOf(year);
            movieName = fn.substring(0, idx).replace(/[._]/g," ").trim();
        } else {
            // Fallback: up to first quality keyword
            movieName = fn.replace(/\b(2160p|4K|1080p|720p|480p|WEB-DL|WEBRip|BluRay|HDRip|DVDRip|PreDVD).*$/i,"")
                          .replace(/[._]/g," ").trim();
        }

        return { movieName: movieName||"", year, specs, size };
    }

    // Build label for StreamResult source field: "[1080p][WEB-DL][x264] 2.6GB"
    function buildSourceLabel(fileName) {
        const { specs, size } = parseFileName(fileName);
        const specStr = specs.map(s=>`[${s}]`).join("");
        return `[TamilMV]${specStr}${size ? " "+size : ""}`;
    }

    // ============================================================
    // TMDB — search by title + year, return metadata
    // ============================================================
    async function fetchTmdbMeta(movieName, year, isSeries) {
        try {
            const type  = isSeries ? "tv" : "movie";
            const query = encodeURIComponent(movieName);
            const url   = year
                ? `https://api.themoviedb.org/3/search/${type}?api_key=${TMDB_API_KEY}&query=${query}&year=${year}&language=en-US`
                : `https://api.themoviedb.org/3/search/${type}?api_key=${TMDB_API_KEY}&query=${query}&language=en-US`;
            const res   = await http_get(url);
            const data  = JSON.parse(res.body);
            const item  = data.results?.[0];
            if (!item) return null;

            // Fetch full details for cast + backdrop
            const detailRes = await http_get(
                `https://api.themoviedb.org/3/${type}/${item.id}?api_key=${TMDB_API_KEY}&append_to_response=credits&language=en-US`
            );
            const detail = JSON.parse(detailRes.body);

            const cast = (detail.credits?.cast || []).slice(0,15).map(c => new Actor({
                name:  c.name,
                role:  c.character,
                image: c.profile_path ? `https://image.tmdb.org/t/p/w185${c.profile_path}` : undefined
            }));

            return {
                tmdbId:     item.id,
                imdbId:     detail.imdb_id || null,
                title:      detail.title || detail.name || movieName,
                poster:     item.poster_path   ? `https://image.tmdb.org/t/p/w500${item.poster_path}`   : null,
                backdrop:   item.backdrop_path ? `https://image.tmdb.org/t/p/w1280${item.backdrop_path}` : null,
                description: detail.overview   || null,
                year:       (detail.release_date || detail.first_air_date || "").substring(0,4),
                score:      item.vote_average  || null,
                genres:     (detail.genres     || []).map(g=>g.name),
                cast
            };
        } catch(e) { err("TMDB fetch:", e.message); return null; }
    }

    // Cinemeta fallback if TMDB poster missing
    async function fetchCinemeta(imdbId, isSeries) {
        if (!imdbId) return null;
        try {
            const res = await http_get(`${CINEMETA_URL}/${isSeries?"series":"movie"}/${imdbId}.json`);
            if (res.body?.trim().startsWith("{")) return JSON.parse(res.body)?.meta || null;
        } catch(_) {}
        return null;
    }

    // ============================================================
    // PARSE TOPIC LIST — only valid movie topics
    // ============================================================
    function parseTopicList(html, mainUrl) {
        const items    = [];
        const seenHref = new Set();
        const topicRe  = /<a[^>]+href="([^"]*index\.php\?\/forums\/topic\/[^"]+)"[^>]*>([\s\S]*?)<\/a>/gi;
        let m;
        while ((m=topicRe.exec(html))!==null) {
            const href     = m[1];
            const rawTitle = stripTags(m[2]).trim();
            if (!rawTitle || rawTitle.length < 5)             continue;
            if (/page_\d+|#replies|#comment/i.test(href))    continue;
            if (seenHref.has(href))                           continue;
            if (JUNK_RE.test(rawTitle))                       continue;
            if (!VALID_RE.test(rawTitle))                     continue;
            seenHref.add(href);
            items.push(new MultimediaItem({
                title:     cleanTitle(rawTitle),
                url:       resolveUrl(href, mainUrl),
                posterUrl: null,
                type:      /\bS\d{2}\b|\bSeason\b|\bEP\b|\bWeb[- ]?Series\b/i.test(rawTitle) ? "series" : "movie",
                quality:   qualityOf(rawTitle)
            }));
        }
        log(`parseTopicList: ${items.length} items`);
        return items;
    }

    // ============================================================
    // HOME
    // ============================================================
    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const sections = [
                { name:"Tamil",      id:"2"  },
                { name:"Telugu",     id:"22" },
                { name:"Hindi",      id:"56" },
                { name:"Malayalam",  id:"58" },
                { name:"Kannada",    id:"60" },
                { name:"English",    id:"62" },
                { name:"Web Series", id:"90" },
            ];
            const homeData = {};
            for (const s of sections) {
                try {
                    // IPS forum URL pattern
                    const url = `${mainUrl}/index.php?/forums/forum/${s.id}-${s.name.toLowerCase().replace(/ /g,"-")}/`;
                    const res = await http_get(url);
                    const items = parseTopicList(res.body, mainUrl);
                    if (items.length) homeData[s.name] = items;
                } catch(e) { err(`Section [${s.name}]:`, e.message); }
            }
            cb({ success:true, data:homeData });
        } catch(e) { cb({ success:false, errorCode:"HOME_ERROR", message:e.message }); }
    }

    // ============================================================
    // SEARCH
    // ============================================================
    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const nodes   = MOVIE_FORUM_IDS.join(",");
            const url     = `${mainUrl}/index.php?/search/?q=${encodeURIComponent(query)}&type=forums_topic&nodes=${nodes}`;
            log("search:", url);
            const res = await http_get(url);
            cb({ success:true, data: parseTopicList(res.body, mainUrl) });
        } catch(e) { cb({ success:false, errorCode:"SEARCH_ERROR", message:e.message }); }
    }

    // ============================================================
    // EXTRACT MAGNET ENTRIES FROM POST HTML
    //
    // Structure per variant:
    //   <strong>Band.Melam.2026.Telugu.HQ.PreDVD.1080p.x264.2.6GB</strong>
    //   <a href="magnet:?xt=urn:btih:...&dn=...&tr=...">⊕ Magnet Link</a>
    //
    // We walk the post HTML linearly. For each magnet found, we look
    // at the text immediately before it to find the filename line.
    // ============================================================
    function extractMagnetEntries(html) {
        const entries    = [];
        const seenMagnets = new Set();

        // Find all magnet links with their positions
        const magnetRe = /href="(magnet:[^"]+)"/gi;
        let magM;

        while ((magM = magnetRe.exec(html)) !== null) {
            const magnetUrl = magM[1];
            if (seenMagnets.has(magnetUrl)) continue;
            seenMagnets.add(magnetUrl);

            // --- Get filename ---
            let fileName = "";

            // 1. dn= param in magnet (most reliable — encoded filename)
            const dnM = magnetUrl.match(/[?&]dn=([^&]+)/i);
            if (dnM) fileName = safeDecodeURI(dnM[1]);

            // 2. Last <strong> before this magnet
            if (!fileName) {
                const before   = html.substring(0, magM.index);
                const strongs  = [...before.matchAll(/<strong[^>]*>([\s\S]*?)<\/strong>/gi)];
                if (strongs.length) fileName = stripTags(strongs[strongs.length-1][1]);
            }

            // 3. Last <b> before this magnet
            if (!fileName) {
                const before = html.substring(0, magM.index);
                const bolds  = [...before.matchAll(/<b[^>]*>([\s\S]*?)<\/b>/gi)];
                if (bolds.length) fileName = stripTags(bolds[bolds.length-1][1]);
            }

            // 4. Last non-empty text line before this magnet
            if (!fileName) {
                const plainBefore = stripTags(html.substring(0, magM.index));
                const lines = plainBefore.split(/\n/).map(l=>l.trim()).filter(l=>l.length>8);
                if (lines.length) fileName = lines[lines.length-1];
            }

            // Parse out the size from filename
            const { size, specs, movieName, year } = parseFileName(fileName);
            const quality = qualityOf(fileName);

            log(`  magnet: Q=${quality} size="${size}" specs=[${specs.join(",")}] file="${fileName.substring(0,60)}"`);

            entries.push({ fileName, magnetUrl, quality, size, specs, movieName, year });
        }

        // Sort: highest quality first, then largest size first within same quality
        entries.sort((a,b) => {
            if (b.quality !== a.quality) return b.quality - a.quality;
            // parse size to bytes for comparison
            const toBytes = s => {
                const m = (s||"").match(/([\d.]+)\s*(GB|MB|TB)/i);
                if (!m) return 0;
                const n = parseFloat(m[1]);
                if (/TB/i.test(m[2])) return n*1e12;
                if (/GB/i.test(m[2])) return n*1e9;
                return n*1e6;
            };
            return toBytes(b.size) - toBytes(a.size);
        });

        log(`extractMagnetEntries: ${entries.length} unique magnets`);
        return entries;
    }

    // ============================================================
    // LOAD — topic page + TMDB metadata
    // ============================================================
    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            log("load:", url);
            const res  = await http_get(url);
            const html = res.body;

            // --- Page title ---
            const h1M      = html.match(/<h1[^>]*class="[^"]*ipsType_pageTitle[^"]*"[^>]*>([\s\S]*?)<\/h1>/i)
                           || html.match(/<title>([^<|–-]+)/i);
            const rawPageTitle = h1M ? stripTags(h1M[1]) : "Unknown";
            const pageTitle    = cleanTitle(rawPageTitle);
            const isSeries     = /\bS\d{2}\b|\bSeason\b|\bEP\b|\bWeb[- ]?Series\b/i.test(rawPageTitle);

            log("load: pageTitle =", pageTitle, "| isSeries =", isSeries);

            // --- Extract post blocks ---
            const postBlocks = [];
            for (const m of html.matchAll(/<div[^>]+data-role="commentContent"[^>]*>([\s\S]*?)<\/div>\s*(?=<\/div>)/gi))
                postBlocks.push(m[1]);
            if (!postBlocks.length)
                for (const m of html.matchAll(/<div[^>]+class="[^"]*cPost_contentWrap[^"]*"[^>]*>([\s\S]*?)<\/div>/gi))
                    postBlocks.push(m[1]);
            if (!postBlocks.length) postBlocks.push(html);

            log(`load: ${postBlocks.length} post blocks`);

            // --- Extract ALL magnets from ALL post blocks ---
            const allMagnets  = [];
            const globalSeen  = new Set();
            for (const block of postBlocks) {
                for (const entry of extractMagnetEntries(block)) {
                    if (globalSeen.has(entry.magnetUrl)) continue;
                    globalSeen.add(entry.magnetUrl);
                    allMagnets.push(entry);
                }
            }

            log(`load: ${allMagnets.length} total unique magnets`);

            // --- TMDB lookup ---
            // Use the first entry's parsed movieName + year, or fall back to page title
            const firstEntry    = allMagnets[0];
            const lookupName    = firstEntry?.movieName || pageTitle;
            const lookupYear    = firstEntry?.year || "";
            log(`TMDB lookup: "${lookupName}" (${lookupYear})`);

            let meta    = await fetchTmdbMeta(lookupName, lookupYear, isSeries);

            // Fallback: try Cinemeta if TMDB returned nothing
            if (!meta && lookupName) {
                // Try TMDB without year constraint
                meta = await fetchTmdbMeta(lookupName, "", isSeries);
            }
            let cinemeta = null;
            if (meta?.imdbId) cinemeta = await fetchCinemeta(meta.imdbId, isSeries);

            const finalTitle       = meta?.title       || pageTitle;
            const poster           = meta?.poster      || cinemeta?.poster     || html.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/i)?.[1] || null;
            const backdrop         = meta?.backdrop    || cinemeta?.background || null;
            const description      = meta?.description || cinemeta?.description || null;
            const score            = meta?.score       || null;
            const genres           = meta?.genres      || [];
            const cast             = meta?.cast        || [];
            const releaseYear      = meta?.year        || lookupYear || null;
            const logoUrl          = cinemeta?.logo    || null;

            // --- Build episodes (one per quality variant) ---
            const episodes = allMagnets.map((entry, i) => new Episode({
                name:    entry.fileName
                            ? entry.fileName.replace(/\.(mkv|mp4|avi|ts)$/i,"").replace(/[._]+/g," ").trim()
                            : `Quality ${i+1}`,
                url:     JSON.stringify({
                    magnetUrl: entry.magnetUrl,
                    fileName:  entry.fileName,
                    quality:   entry.quality,
                    size:      entry.size,
                    specs:     entry.specs
                }),
                season:  1,
                episode: i + 1
            }));

            cb({ success:true, data: new MultimediaItem({
                title:       finalTitle,
                url,
                posterUrl:   poster,
                bannerUrl:   backdrop,
                logoUrl,
                type:        isSeries ? "series" : "movie",
                description,
                year:        parseInt(releaseYear) || undefined,
                score:       score ? parseFloat(score) : undefined,
                genres,
                cast,
                episodes
            }) });

        } catch(e) { cb({ success:false, errorCode:"LOAD_ERROR", message:e.message }); }
    }

    // ============================================================
    // LOAD STREAMS
    // Magnet = final URL, zero extra fetches.
    // Source label: "[TamilMV][1080p][HQ-PreDVD][x264] 2.6GB"
    // ============================================================
    async function loadStreams(url, cb) {
        try {
            const { magnetUrl, fileName, quality, size, specs } = JSON.parse(url);
            log("loadStreams:", fileName, "| Q:", quality, "| size:", size);

            if (!magnetUrl?.startsWith("magnet:")) {
                warn("not a valid magnet URI");
                return cb({ success:true, data:[] });
            }

            // Build source label with specs + size
            const specsStr = (specs||[]).map(s=>`[${s}]`).join("");
            const label    = `[TamilMV]${specsStr}${size ? " "+size : ""}`.trim();

            log("✓ stream:", label, quality+"p");

            cb({ success:true, data:[
                new StreamResult({
                    url:     magnetUrl,
                    quality: quality || 0,
                    source:  label,
                    headers: {}
                })
            ]});

        } catch(e) {
            err("loadStreams:", e);
            cb({ success:false, errorCode:"STREAM_ERROR", message:e.message });
        }
    }

    // --- Export ---
    for (const ctx of [
        typeof globalThis !== "undefined" ? globalThis : null,
        typeof window     !== "undefined" ? window     : null,
        typeof global     !== "undefined" ? global     : null
    ]) {
        if (ctx) { ctx.getHome=getHome; ctx.search=search; ctx.load=load; ctx.loadStreams=loadStreams; }
    }
})();
