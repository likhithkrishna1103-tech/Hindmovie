(function () {
    // ============================================================
    // DEBUG — set false to silence logs in production
    // ============================================================
    const DEBUG = true;
    function log(...a)  { if (DEBUG) console.log("[HMZ]", ...a); }
    function warn(...a) { if (DEBUG) console.warn("[HMZ WARN]", ...a); }
    function err(...a)  { console.error("[HMZ ERR]", ...a); }

    // --- Constants ---
    const DOMAINS_URL  = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    const CINEMETA_URL = "https://v3-cinemeta.strem.io/meta";
    const TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";

    const FALLBACK_DOMAINS = [
        "https://hindmoviez.cafe",
        "https://hindmoviez.com",
        "https://hindmoviez.net",
        "https://hindmoviez.in"
    ];

    const SKIP_PATTERNS = [
        /t\.me\//i, /telegram\./i, /facebook\.com/i, /instagram\.com/i,
        /twitter\.com/i, /youtube\.com/i, /doubleclick/i,
        /googlesyndication/i, /adservice/i, /disqus\.com/i,
        /whatsapp/i, /bit\.ly/i, /tinyurl/i, /rebrand\.ly/i,
        /linkskit/i, /contact/i, /disclaimer/i
    ];

    function isGoodUrl(url) {
        if (!url || !url.startsWith("http")) return false;
        for (const p of SKIP_PATTERNS) if (p.test(url)) return false;
        return true;
    }

    // ============================================================
    // REDIRECT FOLLOWER
    // ============================================================
    async function fetchFinal(url, maxHops = 5) {
        let cur = url;
        for (let i = 0; i < maxHops; i++) {
            log(`  [hop ${i}] ${cur}`);
            let res;
            try { res = await http_get(cur); }
            catch (e) { err(`  [hop ${i}] failed:`, e.message); return { url: cur, body: "" }; }
            const body = res.body || "";
            if (res.headers?.location) { cur = resolveUrl(res.headers.location, cur); continue; }
            const meta = body.match(/<meta[^>]+http-equiv="refresh"[^>]+content="[^;]*;\s*url=([^"'>\s]+)/i);
            if (meta) { cur = resolveUrl(meta[1].replace(/['"]/g,""), cur); continue; }
            const js = body.match(/window\.location(?:\.href)?\s*=\s*["']([^"']+)["']/i)
                    || body.match(/location\.replace\s*\(\s*["']([^"']+)["']\s*\)/i);
            if (js) { cur = resolveUrl(js[1], cur); continue; }
            return { url: cur, body };
        }
        return { url: cur, body: "" };
    }

    // ============================================================
    // UTILS
    // ============================================================
    function allHrefs(html) {
        const found = [];
        for (const m of html.matchAll(/<a[^>]+href=["']([^"'#\s]+)["'][^>]*>([\s\S]*?)<\/a>/gi))
            found.push({ href: m[1], text: stripTags(m[2]||"").trim() });
        return found;
    }
    function stripTags(s) {
        return (s||"").replace(/<[^>]*>/g,"").replace(/&amp;/g,"&").replace(/&nbsp;/g," ")
                      .replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&#\d+;/g,"").trim();
    }
    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.startsWith("http")) return href;
        if (href.startsWith("/")) return base.replace(/\/$/,"") + href;
        return base.replace(/\/$/,"") + "/" + href;
    }
    function cleanTitle(raw) {
        return (raw||"").replace(/\b(480p|720p|1080p|4K|HDRip|BluRay|WEBRip|WEB-DL|DVDRip|HEVC|x264|x265|AAC|DD5\.1|ESub)\b/gi,"")
                        .replace(/\s{2,}/g," ").trim() || "Unknown";
    }
    function qualityOf(s) {
        const t = (s||"").toLowerCase();
        if (/\b(4k|2160p)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t))       return 1080;
        if (/\b720p\b/.test(t))        return 720;
        if (/\b480p\b/.test(t))        return 480;
        return 0;
    }
    function specsLabel(s) {
        const pats = [
            /\b(480p|720p|1080p|2160p|4K)\b/i,/\b(HEVC|x264|x265|AVC)\b/i,
            /\b(BluRay|WEBRip|WEB-DL|HDRip|DVDRip)\b/i,
            /\b(AAC|DD5\.1|DDP5\.1|DTS|AC3|Atmos)\b/i,/\b(ESub|MSub)\b/i
        ];
        return pats.map(p=>(s||"").match(p)?.[0]).filter(Boolean).map(x=>`[${x}]`).join("");
    }
    function decodeHshareId(id) { try { return atob(id); } catch(_){ return ""; } }

    // ============================================================
    // DOMAIN
    // ============================================================
    let cachedMainUrl = null;
    async function getMainUrl() {
        if (cachedMainUrl) return cachedMainUrl;
        try {
            const res = await http_get(DOMAINS_URL);
            const d   = JSON.parse(res.body);
            const c   = d.hindmoviez || d.hindmoviez_url;
            if (c) { try { await http_get(c+"/"); cachedMainUrl=c; return c; } catch(_){} }
        } catch(e) { err("domains.json:", e.message); }
        for (const d of FALLBACK_DOMAINS) {
            try { await http_get(d+"/"); cachedMainUrl=d; return d; } catch(_) {}
        }
        cachedMainUrl = FALLBACK_DOMAINS[0];
        return cachedMainUrl;
    }

    async function tmdbIdFromImdb(id) {
        try {
            const r = await http_get(`https://api.themoviedb.org/3/find/${id}?api_key=${TMDB_API_KEY}&external_source=imdb_id`);
            const d = JSON.parse(r.body);
            return d.movie_results?.[0]?.id || d.tv_results?.[0]?.id || null;
        } catch(_) { return null; }
    }
    function parseCredits(json) {
        try {
            return (JSON.parse(json).cast||[]).slice(0,20).map(c=>new Actor({
                name:c.name, role:c.character,
                image:c.profile_path?`https://image.tmdb.org/t/p/w185${c.profile_path}`:undefined
            }));
        } catch(_){ return []; }
    }

    // ============================================================
    // HOME
    // ============================================================
    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const sections = [
                {name:"Home",path:""},{name:"Movies",path:"movies"},
                {name:"Web Series",path:"web-series"},{name:"Korean Dramas",path:"dramas/korean-drama"},
                {name:"Chinese Dramas",path:"dramas/chinese-drama"},{name:"Anime",path:"anime"}
            ];
            const homeData = {};
            for (const s of sections) {
                try {
                    const url = s.path ? `${mainUrl}/${s.path}` : mainUrl;
                    const res = await http_get(url);
                    const items = parseArticles(res.body, mainUrl);
                    if (items.length) homeData[s.name] = items;
                } catch(e) { err("section", s.name, e.message); }
            }
            cb({ success:true, data:homeData });
        } catch(e) { cb({ success:false, errorCode:"HOME_ERROR", message:e.message }); }
    }

    function parseArticles(html, mainUrl) {
        const items=[], blocks=[];
        for (const re of [
            /<article[\s\S]*?<\/article>/gi,
            /<div[^>]+class="[^"]*\bpost\b[^"]*"[\s\S]*?<\/div>/gi,
            /<div[^>]+class="[^"]*\bitem\b[^"]*"[\s\S]*?<\/div>/gi
        ]) { if(blocks.length) break; let m; while((m=re.exec(html))!==null) blocks.push(m[0]); }

        for (const block of blocks) {
            const tm = block.match(/<h[23][^>]*class="[^"]*entry-title[^"]*"[^>]*>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>/i)
                    || block.match(/<h[23][^>]*>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>[\s\S]*?<\/h[23]>/i);
            const rawTitle = tm ? stripTags(tm[1]) : null;
            if (!rawTitle) continue;
            const hm = block.match(/<a[^>]+href="([^"]+)"/i);
            const href = hm ? resolveUrl(hm[1], mainUrl) : null;
            if (!href) continue;
            const pm = block.match(/<img[^>]+data-src="([^"]+)"/i) || block.match(/<img[^>]+src="([^"]+)"/i);
            items.push(new MultimediaItem({
                title: cleanTitle(rawTitle), url: href, posterUrl: pm?.[1]||null,
                type: /Season/i.test(rawTitle) ? "series" : "movie"
            }));
        }
        return items;
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await http_get(`${mainUrl}/?s=${encodeURIComponent(query)}`);
            cb({ success:true, data: parseArticles(res.body, mainUrl) });
        } catch(e) { cb({ success:false, errorCode:"SEARCH_ERROR", message:e.message }); }
    }

    // ============================================================
    // LOAD
    // ============================================================
    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await http_get(url);
            const html = res.body;

            let name=null, imdbRating=null, imdbId=null, releaseYear=null, docGenres=[];
            const liRe = /<li>([\s\S]*?)<\/li>/gi; let lm;
            while ((lm=liRe.exec(html))!==null) {
                const lh=lm[1], sm=lh.match(/<strong>([\s\S]*?)<\/strong>/i); if(!sm) continue;
                const key=stripTags(sm[1]).split(":")[0].trim();
                const inv=(stripTags(sm[1]).split(":")[1]||"").trim();
                const val=stripTags(lh.replace(sm[0],"")).trim()||inv;
                if(key==="Name") name=val||null;
                else if(key==="IMDB Rating"){ imdbRating=inv.split("/")[0].trim()||null; const im=lh.match(/href="[^"]*\/title\/(tt\d+)\//i); if(im) imdbId=im[1]; }
                else if(key==="Release Year") releaseYear=val||null;
                else if(key==="Genre") docGenres=val.split(",").map(s=>s.trim()).filter(Boolean);
            }
            if(!name){ const m=html.match(/(?:Name|Movie Name)\s*:\s*([^\n<]+)/i); if(m) name=stripTags(m[1]).trim(); }
            if(!releaseYear){ const m=html.match(/(?:Release Year|Year)\s*:\s*(\d{4})/i); if(m) releaseYear=m[1]; }

            const title   = name||"Unknown";
            const poster  = html.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/i)?.[1]||null;
            const descRaw = html.match(/<h3[^>]*>[^<]*Storyline[^<]*<\/h3>\s*<p[^>]*>([\s\S]*?)<\/p>/i)?.[1];
            const h1      = stripTags(html.match(/<h1[^>]*class="entry-title"[^>]*>([\s\S]*?)<\/h1>/i)?.[1]||"");
            const isSeries = /Season/i.test(h1);

            let description = descRaw ? stripTags(descRaw) : null, background=poster, castList=[];
            const tmdbId = imdbId ? await tmdbIdFromImdb(imdbId) : null;
            if(tmdbId){ try{ const cr=await http_get(`https://api.themoviedb.org/3/${isSeries?"tv":"movie"}/${tmdbId}/credits?api_key=${TMDB_API_KEY}&language=en-US`); castList=parseCredits(cr.body); }catch(_){} }
            let responseData=null;
            if(imdbId){ try{ const cr=await http_get(`${CINEMETA_URL}/${isSeries?"series":"movie"}/${imdbId}.json`); if(cr.body?.trim().startsWith("{")) responseData=JSON.parse(cr.body); }catch(_){} }
            if(responseData?.meta){ description=responseData.meta.description||description; background=responseData.meta.background||poster; }

            if(isSeries){
                const episodes = await buildSeriesEpisodes(html, responseData, mainUrl);
                cb({ success:true, data: new MultimediaItem({
                    title:responseData?.meta?.name||title, url, posterUrl:poster, bannerUrl:background,
                    logoUrl:responseData?.meta?.logo||null, type:"series", description,
                    year:parseInt(releaseYear||responseData?.meta?.year)||undefined,
                    score:parseFloat(imdbRating||responseData?.meta?.imdbRating)||undefined,
                    genres:docGenres, cast:castList, episodes
                }) });
                return;
            }

            const hrefs = await collectMovieLinks(html, mainUrl);
            log("MAIN LINKS:", hrefs);
            cb({ success:true, data: new MultimediaItem({
                title:responseData?.meta?.name||title, url, posterUrl:poster, bannerUrl:background,
                logoUrl:responseData?.meta?.logo||null, type:"movie", description,
                year:parseInt(releaseYear||responseData?.meta?.year)||undefined,
                score:parseFloat(imdbRating||responseData?.meta?.imdbRating)||undefined,
                genres:docGenres, cast:castList,
                episodes:[new Episode({ name:"Movie", url:JSON.stringify(hrefs), season:1, episode:1 })]
            }) });
        } catch(e) { cb({ success:false, errorCode:"LOAD_ERROR", message:e.message }); }
    }

    // ============================================================
    // SERIES EPISODE BUILDER
    // ============================================================
    async function buildSeriesEpisodes(html, responseData, mainUrl) {
        const map = {};
        const sRe = /<h[23][^>]*>[\s\S]*?Season\s*(\d+)[\s\S]*?<\/h[23]>[\s\S]*?<a[^>]+href="([^"]+)"/gi;
        let sm;
        while((sm=sRe.exec(html))!==null){
            const sNum=parseInt(sm[1]), listUrl=sm[2];
            if(!sNum||!listUrl) continue;
            try {
                const lr = await http_get(listUrl);
                for(const {href, text} of allHrefs(lr.body)){
                    const em = text.match(/Episode\s*(\d+)/i)||text.match(/\bEp\.?\s*(\d+)/i)||text.match(/\bE(\d+)\b/i);
                    if(!em) continue;
                    const epNum = parseInt(em[1]);
                    const key   = `${sNum}_${epNum}`;
                    if(!map[key]) map[key] = { season:sNum, episode:epNum, hshareUrls:[] };
                    if(href.startsWith("http")) map[key].hshareUrls.push(href);
                }
            } catch(e) { err("season list fetch:", e.message); }
        }
        return Object.values(map).map(ep=>{
            const metaEp = responseData?.meta?.videos?.find(v=>v.season===ep.season&&v.episode===ep.episode);
            return new Episode({
                name: metaEp?.name||`Episode ${ep.episode}`,
                url: JSON.stringify({ season:ep.season, episode:ep.episode, hshareUrls:ep.hshareUrls }),
                season:ep.season, episode:ep.episode,
                description:metaEp?.overview||null, posterUrl:metaEp?.thumbnail||null, aired:metaEp?.released||null
            });
        }).sort((a,b)=>a.season!==b.season?a.season-b.season:a.episode-b.episode);
    }

    // ============================================================
    // COLLECT MOVIE LINKS
    // ============================================================
    async function collectMovieLinks(html, mainUrl) {
        const candidates = new Set();
        for (const re of [
            /<a[^>]+class="[^"]*maxbutton[^"]*"[^>]+href="([^"']+)"/gi,
            /<a[^>]+class="[^"]*download-btn[^"]*"[^>]+href="([^"']+)"/gi,
            /<a[^>]+class="[^"]*\bbtn\b[^"]*"[^>]+href="([^"']+)"/gi,
            /<a[^>]+class="[^"]*\bbutton\b[^"]*"[^>]+href="([^"']+)"/gi,
        ]) { for(const m of html.matchAll(re)) { if(isGoodUrl(m[1])) candidates.add(m[1]); } }

        for(const {href,text} of allHrefs(html)){
            if(isGoodUrl(href) && /download|480p|720p|1080p|4k|server\s*\d|mirror\s*\d|mvlink/i.test(text))
                candidates.add(href);
        }

        if(candidates.size===0){
            warn("collectMovieLinks: no candidates, brute-forcing");
            const cm = html.match(/<div[^>]+class="[^"]*entry-content[^"]*"[^>]*>([\s\S]*?)<\/div>/i);
            return [...new Set(allHrefs(cm?cm[1]:html).filter(x=>isGoodUrl(x.href)).map(x=>x.href))];
        }

        const hrefs = new Set();
        for(const listUrl of candidates){
            try {
                const { body } = await fetchFinal(listUrl, 3);
                for(const {href} of allHrefs(body)) { if(isGoodUrl(href)) hrefs.add(href); }
            } catch(e) { err("collectMovieLinks:", e.message); }
        }
        return [...hrefs];
    }

    // ============================================================
    // RESOLVE ONE STREAM LINK FROM A HSHARE URL
    //
    // Strategy: try GDirect first (fastest — 1 fetch → 1 link).
    //           Only fall back to HPage if GDirect fails.
    //           Return the FIRST working URL and stop.
    // ============================================================
    async function resolveOneStreamFromHshare(hshareUrl, referer) {
        log("  resolveOne:", hshareUrl);

        // Step 1 — fetch hshare landing page
        let landingBody = "";
        try {
            const r = await fetchFinal(hshareUrl, 4);
            landingBody = r.body;
            log("  landing:", r.url, landingBody.length+"b");
        } catch(e) { err("  landing fetch failed:", e.message); return null; }

        const links = allHrefs(landingBody);
        log("  landing links:", links.map(x=>x.text+":"+x.href));

        // ---- Try GDirect first ----
        const gdirect = links.find(x => /gdirect|g-direct/i.test(x.text) && isGoodUrl(x.href));
        if (gdirect) {
            log("  [GDirect] trying:", gdirect.href);
            try {
                const { url: finalUrl, body: gdBody } = await fetchFinal(gdirect.href, 5);
                // Find the actual download link on gdirect page
                const dlLink = allHrefs(gdBody).find(x =>
                    isGoodUrl(x.href) && x.href !== gdirect.href &&
                    (/download|get\s*file|click\s*here|direct/i.test(x.text) || qualityOf(x.href) > 0)
                );
                const streamUrl = dlLink?.href || (finalUrl !== gdirect.href ? finalUrl : null);
                if (streamUrl) {
                    log("  [GDirect] ✓ got:", streamUrl);
                    return { url: streamUrl, source: "GDirect", referer: finalUrl };
                }
            } catch(e) { err("  [GDirect] failed:", e.message); }
        }

        // ---- Fallback: HPage — try Server 1 only (fastest) ----
        const hpage = links.find(x => /hpage|h-page/i.test(x.text) && isGoodUrl(x.href));
        if (hpage) {
            log("  [HPage] trying:", hpage.href);
            try {
                const { url: hpUrl, body: hpBody } = await fetchFinal(hpage.href, 5);
                // Find Server 1 first, then any server
                const serverLinks = allHrefs(hpBody).filter(x =>
                    isGoodUrl(x.href) && /server\s*\d|mirror\s*\d|s\d+\b|link\s*\d|hcloud|embed|stream/i.test(x.text)
                );
                const server = serverLinks.find(x => /\b1\b/.test(x.text)) || serverLinks[0];
                if (server) {
                    const { url: streamUrl } = await fetchFinal(server.href, 4);
                    log("  [HPage] ✓ got:", streamUrl);
                    return { url: streamUrl, source: `HPage ${server.text}`, referer: hpUrl };
                }
            } catch(e) { err("  [HPage] failed:", e.message); }
        }

        // ---- Last resort: first good non-skip link on landing ----
        const fallback = links.find(x => isGoodUrl(x.href) && x.href !== hshareUrl);
        if (fallback) {
            log("  [fallback] using:", fallback.href);
            try {
                const { url: streamUrl } = await fetchFinal(fallback.href, 3);
                return { url: streamUrl, source: "HShare", referer: hshareUrl };
            } catch(_) {}
        }

        warn("  resolveOne: no stream found for", hshareUrl);
        return null;
    }

    // ============================================================
    // LOAD STREAMS
    //
    // One hshare URL = one quality file.
    // We resolve ONE link per file and stop — no exhausting all 6 paths.
    // ============================================================
    async function loadStreams(url, cb) {
        try {
            const parsed = JSON.parse(url);
            log("loadStreams input:", parsed);

            // Collect { hshareUrl, fileName, quality } entries — one per file
            const fileEntries = [];

            if (Array.isArray(parsed)) {
                // MOVIE MODE: fetch each mvlink page, collect hshare URLs
                for (const pageUrl of parsed) {
                    log("loadStreams: mvlink page →", pageUrl);
                    try {
                        const { body } = await fetchFinal(pageUrl, 3);
                        // Page name → quality hint
                        const nh = body.match(/(?:Movie\s*)?Name\s*:\s*([^\n<]+)/i) || body.match(/<title>([^<]+)<\/title>/i);
                        const pageName = nh ? stripTags(nh[1]).trim() : "";

                        for (const { href, text } of allHrefs(body)) {
                            if (!href.includes("hshare")) continue;
                            // Decode filename from BASE64 id → gives us quality
                            const idM = href.match(/[?&]id=([A-Za-z0-9+/=]+)/);
                            const fileName = idM ? decodeHshareId(idM[1]) : (text || pageName);
                            fileEntries.push({ hshareUrl: href, fileName, quality: qualityOf(fileName) || qualityOf(pageName) });
                            log("  entry:", fileName, "→", href);
                        }
                    } catch(e) { err("mvlink page:", e.message); }
                }
            } else if (parsed.hshareUrls) {
                // SERIES EPISODE MODE
                for (const hshareUrl of parsed.hshareUrls) {
                    const idM = hshareUrl.match(/[?&]id=([A-Za-z0-9+/=]+)/);
                    const fileName = idM ? decodeHshareId(idM[1]) : "";
                    fileEntries.push({ hshareUrl, fileName, quality: qualityOf(fileName) });
                }
            }

            log("loadStreams: file entries count =", fileEntries.length);

            if (fileEntries.length === 0) {
                warn("loadStreams: no file entries");
                return cb({ success:true, data:[] });
            }

            const results = [];
            const seenUrls = new Set();

            // For each quality file: resolve ONE stream link, then move on
            for (const { hshareUrl, fileName, quality } of fileEntries) {
                const specs = specsLabel(fileName);
                const stream = await resolveOneStreamFromHshare(hshareUrl, hshareUrl);

                if (!stream) { warn("  no stream for:", fileName); continue; }
                if (seenUrls.has(stream.url)) { log("  duplicate, skipping:", stream.url); continue; }

                seenUrls.add(stream.url);
                const label = `[${stream.source}]${specs || ` ${fileName.split(".").slice(-3,-1).join(".")}`}`.trim();
                results.push(new StreamResult({
                    url:     stream.url,
                    quality: quality,
                    source:  label,
                    headers: { Referer: stream.referer }
                }));
                log("✓ result:", label, quality+"p →", stream.url);
            }

            log("FINAL RESULTS count:", results.length);
            results.sort((a,b) => (b.quality||0) - (a.quality||0));
            cb({ success:true, data:results });

        } catch(e) {
            err("LoadStreams:", e);
            cb({ success:false, errorCode:"STREAM_ERROR", message:e.message });
        }
    }

    // --- Export ---
    for (const ctx of [
        typeof globalThis!=="undefined" ? globalThis : null,
        typeof window    !=="undefined" ? window     : null,
        typeof global    !=="undefined" ? global     : null
    ]) {
        if(ctx){ ctx.getHome=getHome; ctx.search=search; ctx.load=load; ctx.loadStreams=loadStreams; }
    }
})();
