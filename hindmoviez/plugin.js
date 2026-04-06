(function () {
    const DEBUG = false;
    function log(...a)  { if (DEBUG) console.log("[HMZ]", ...a); }
    function warn(...a) { if (DEBUG) console.warn("[HMZ WARN]", ...a); }
    function err(...a)  { console.error("[HMZ ERR]", ...a); }

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

    const HTTP_CACHE_TTL = 5 * 60 * 1000;
    const DOMAIN_CACHE_TTL = 30 * 60 * 1000;
    const STREAM_CACHE_TTL = 10 * 60 * 1000;

    const httpCache = new Map();
    const inFlightGets = new Map();
    const streamCache = new Map();
    const siteDomains = new Set(FALLBACK_DOMAINS.map(getOrigin));

    let cachedMainUrl = null;
    let cachedMainUrlAt = 0;
    let resolvingMainUrl = null;

    function getOrigin(url) {
        const m = String(url || "").match(/^https?:\/\/[^/]+/i);
        return m ? m[0].replace(/\/$/, "") : "";
    }

    function sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    function unique(arr) {
        return [...new Set((arr || []).filter(Boolean))];
    }

    function isBlockedBody(body) {
        const text = String(body || "");
        return /just a moment/i.test(text)
            || /checking if the site connection is secure/i.test(text)
            || /cf-browser-verification/i.test(text)
            || /attention required/i.test(text) && /cloudflare/i.test(text);
    }

    function isGoodUrl(url) {
        if (!url || !url.startsWith("http")) return false;
        for (const p of SKIP_PATTERNS) if (p.test(url)) return false;
        return true;
    }

    function stripTags(s) {
        return (s || "")
            .replace(/<[^>]*>/g, " ")
            .replace(/&amp;/g, "&")
            .replace(/&nbsp;/g, " ")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&#\d+;/g, " ")
            .replace(/\s+/g, " ")
            .trim();
    }

    function allHrefs(html, baseUrl) {
        const found = [];
        for (const m of String(html || "").matchAll(/<a[^>]+href=["']([^"'#\s]+)["'][^>]*>([\s\S]*?)<\/a>/gi)) {
            found.push({
                href: resolveUrl(m[1], baseUrl || ""),
                text: stripTags(m[2] || "").trim()
            });
        }
        return found;
    }

    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.startsWith("http")) return href;
        if (href.startsWith("//")) return `https:${href}`;
        const origin = getOrigin(base);
        const cleanBase = String(base || "").replace(/[?#].*$/, "");
        const dir = cleanBase.endsWith("/") ? cleanBase.slice(0, -1) : cleanBase.replace(/\/[^/]*$/, "");
        if (href.startsWith("/")) return origin + href;
        return `${dir}/${href}`
            .replace(/^https?:\/\//i, match => match.replace("//", "__PROTO__"))
            .replace(/\/{2,}/g, "/")
            .replace("__PROTO__", "//");
    }

    function cleanTitle(raw) {
        return (raw || "")
            .replace(/\b(480p|720p|1080p|4K|HDRip|BluRay|WEBRip|WEB-DL|DVDRip|HEVC|x264|x265|AAC|DD5\.1|ESub)\b/gi, "")
            .replace(/\s{2,}/g, " ")
            .trim() || "Unknown";
    }

    function qualityOf(s) {
        const t = (s || "").toLowerCase();
        if (/\b(4k|2160p)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t)) return 1080;
        if (/\b720p\b/.test(t)) return 720;
        if (/\b480p\b/.test(t)) return 480;
        return 0;
    }

    function specsLabel(s) {
        const pats = [
            /\b(480p|720p|1080p|2160p|4K)\b/i,
            /\b(HEVC|x264|x265|AVC)\b/i,
            /\b(BluRay|WEBRip|WEB-DL|HDRip|DVDRip)\b/i,
            /\b(AAC|DD5\.1|DDP5\.1|DTS|AC3|Atmos)\b/i,
            /\b(ESub|MSub)\b/i
        ];
        return pats.map(p => (s || "").match(p)?.[0]).filter(Boolean).map(x => `[${x}]`).join("");
    }

    function parseContainerValue(body, label) {
        const escaped = label.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
        const inlineStrong = body.match(new RegExp(`<p[^>]*>\\s*<strong>\\s*${escaped}\\s*:\\s*([^<]+)</strong>\\s*</p>`, "i"));
        if (inlineStrong) return stripTags(inlineStrong[1] || "");
        const splitStrong = body.match(new RegExp(`<p[^>]*>\\s*<strong>\\s*${escaped}\\s*:?\\s*</strong>\\s*([^<]+)</p>`, "i"));
        if (splitStrong) return stripTags(splitStrong[1] || "");
        const re = new RegExp(`(?:^|>|\\s)${escaped}\\s*:?\\s*([^<\\n]+)`, "i");
        return stripTags(body.match(re)?.[1] || "");
    }

    function parseAnchorsByClass(body, classPart, baseUrl) {
        const out = [];
        const re = /<a([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
        for (const m of String(body || "").matchAll(re)) {
            const attrs = `${m[1] || ""} ${m[3] || ""}`;
            if (!new RegExp(`class=["'][^"']*${classPart}[^"']*["']`, "i").test(attrs)) continue;
            out.push({
                href: resolveUrl(m[2], baseUrl),
                text: stripTags(m[4] || "")
            });
        }
        return out;
    }

    function parseAnchorsContainingButtonClass(body, classPart, baseUrl) {
        const out = [];
        const re = new RegExp(`<a[^>]+href=["']([^"']+)["'][^>]*>[\\s\\S]*?<button[^>]+class=["'][^"']*${classPart}[^"']*["'][^>]*>([\\s\\S]*?)<\\/button>[\\s\\S]*?<\\/a>`, "gi");
        for (const m of String(body || "").matchAll(re)) {
            out.push({
                href: resolveUrl(m[1], baseUrl),
                text: stripTags(m[2] || "")
            });
        }
        return out;
    }

    function isCandidateStreamPageUrl(url) {
        const text = String(url || "");
        return /hshare\.|gdirect\.|hcloud\.|gdtot\.|redirect\.php|file\.php/i.test(text);
    }

    async function pooledMap(items, limit, mapper) {
        const list = items || [];
        const results = new Array(list.length);
        let cursor = 0;
        const workers = Array.from({ length: Math.min(limit, list.length || 0) }, async () => {
            while (cursor < list.length) {
                const index = cursor++;
                try {
                    results[index] = await mapper(list[index], index);
                } catch (e) {
                    results[index] = null;
                    err("pooledMap item failed:", e.message || e);
                }
            }
        });
        await Promise.all(workers);
        return results;
    }

    async function httpGetCached(url, ttl = HTTP_CACHE_TTL, force = false) {
        const key = String(url);
        const now = Date.now();
        const cached = httpCache.get(key);
        if (!force && cached && cached.expiresAt > now) return cached.value;
        if (!force && inFlightGets.has(key)) return inFlightGets.get(key);
        const job = (async () => {
            const value = await http_get(url);
            httpCache.set(key, { value, expiresAt: now + ttl });
            return value;
        })();
        inFlightGets.set(key, job);
        try {
            return await job;
        } finally {
            inFlightGets.delete(key);
        }
    }

    async function fetchWithRetry(url, {
        attempts = 2,
        ttl = HTTP_CACHE_TTL,
        force = false,
        allowBlocked = false
    } = {}) {
        let lastErr = null;
        for (let i = 0; i < attempts; i++) {
            try {
                const res = await httpGetCached(url, ttl, force || i > 0);
                if (!allowBlocked && isBlockedBody(res.body)) throw new Error("Blocked by anti-bot");
                return res;
            } catch (e) {
                lastErr = e;
                if (i + 1 < attempts) await sleep(150 * (i + 1));
            }
        }
        throw lastErr;
    }

    async function fetchFinal(url, maxHops = 5, opts = {}) {
        let cur = url;
        for (let i = 0; i < maxHops; i++) {
            log("hop", i, cur);
            let res;
            try {
                res = await fetchWithRetry(cur, {
                    attempts: 2,
                    ttl: opts.ttl ?? HTTP_CACHE_TTL,
                    allowBlocked: !!opts.allowBlocked
                });
            } catch (e) {
                err("fetchFinal failed:", e.message);
                return { url: cur, body: "" };
            }
            const body = res.body || "";
            if (res.headers?.location) {
                cur = resolveUrl(res.headers.location, cur);
                continue;
            }
            const meta = body.match(/<meta[^>]+http-equiv="refresh"[^>]+content="[^;]*;\s*url=([^"'>\s]+)/i);
            if (meta) {
                cur = resolveUrl(meta[1].replace(/['"]/g, ""), cur);
                continue;
            }
            const js = body.match(/window\.location(?:\.href)?\s*=\s*["']([^"']+)["']/i)
                || body.match(/location\.replace\s*\(\s*["']([^"']+)["']\s*\)/i);
            if (js) {
                cur = resolveUrl(js[1], cur);
                continue;
            }
            return { url: cur, body };
        }
        return { url: cur, body: "" };
    }

    async function isHealthyDomain(url) {
        try {
            const res = await fetchWithRetry(`${url}/`, { attempts: 1, ttl: DOMAIN_CACHE_TTL });
            return !isBlockedBody(res.body);
        } catch (_) {
            return false;
        }
    }

    async function resolveMainUrl(force = false) {
        const now = Date.now();
        if (!force && cachedMainUrl && (now - cachedMainUrlAt) < DOMAIN_CACHE_TTL) return cachedMainUrl;
        if (!force && resolvingMainUrl) return resolvingMainUrl;

        resolvingMainUrl = (async () => {
            const candidates = [];
            try {
                const res = await fetchWithRetry(DOMAINS_URL, { attempts: 2, ttl: DOMAIN_CACHE_TTL, force });
                const d = JSON.parse(res.body);
                const c = d.hindmoviez || d.hindmoviez_url;
                if (c) candidates.push(c);
            } catch (e) {
                err("domains.json:", e.message);
            }

            candidates.push(...FALLBACK_DOMAINS);
            for (const domain of unique(candidates)) {
                if (await isHealthyDomain(domain)) {
                    cachedMainUrl = domain.replace(/\/$/, "");
                    cachedMainUrlAt = Date.now();
                    siteDomains.add(getOrigin(cachedMainUrl));
                    return cachedMainUrl;
                }
            }

            cachedMainUrl = FALLBACK_DOMAINS[0];
            cachedMainUrlAt = Date.now();
            return cachedMainUrl;
        })();

        try {
            return await resolvingMainUrl;
        } finally {
            resolvingMainUrl = null;
        }
    }

    async function getMainUrl() {
        return resolveMainUrl(false);
    }

    async function refreshMainUrl() {
        return resolveMainUrl(true);
    }

    async function rewriteToActiveDomain(url) {
        const currentOrigin = getOrigin(url);
        if (!siteDomains.has(currentOrigin)) return url;
        const mainUrl = await getMainUrl();
        const activeOrigin = getOrigin(mainUrl);
        return currentOrigin === activeOrigin ? url : url.replace(currentOrigin, activeOrigin);
    }

    async function siteRequest(url, { attempts = 2, ttl = HTTP_CACHE_TTL } = {}) {
        let current = await rewriteToActiveDomain(url);
        let lastErr = null;

        for (let i = 0; i < attempts; i++) {
            try {
                const res = await fetchWithRetry(current, { attempts: 2, ttl, force: i > 0 });
                if (isBlockedBody(res.body)) throw new Error("Blocked by anti-bot");
                return { ...res, url: current };
            } catch (e) {
                lastErr = e;
                const freshMain = await refreshMainUrl();
                if (siteDomains.has(getOrigin(current))) {
                    current = current.replace(getOrigin(current), getOrigin(freshMain));
                }
            }
        }

        throw lastErr;
    }

    async function tmdbIdFromImdb(id) {
        try {
            const r = await fetchWithRetry(`https://api.themoviedb.org/3/find/${id}?api_key=${TMDB_API_KEY}&external_source=imdb_id`, {
                attempts: 2,
                ttl: DOMAIN_CACHE_TTL,
                allowBlocked: true
            });
            const d = JSON.parse(r.body);
            return d.movie_results?.[0]?.id || d.tv_results?.[0]?.id || null;
        } catch (_) {
            return null;
        }
    }

    function parseCredits(json) {
        try {
            return (JSON.parse(json).cast || []).slice(0, 20).map(c => new Actor({
                name: c.name,
                role: c.character,
                image: c.profile_path ? `https://image.tmdb.org/t/p/w185${c.profile_path}` : undefined
            }));
        } catch (_) {
            return [];
        }
    }

    function parseArticles(html, mainUrl) {
        const items = [];
        const articleMatches = String(html || "").match(/<article[\s\S]*?<\/article>/gi) || [];
        const blocks = articleMatches.length ? articleMatches : (
            String(html || "").match(/<div[^>]+class="[^"]*\bpost\b[^"]*"[\s\S]*?<\/div>/gi) || []
        );

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
                title: cleanTitle(rawTitle),
                url: href,
                posterUrl: pm?.[1] || null,
                type: /Season/i.test(rawTitle) ? "series" : "movie"
            }));
        }

        return items;
    }

    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const sections = [
                { name: "Home", path: "" },
                { name: "Movies", path: "movies" },
                { name: "Web Series", path: "web-series" },
                { name: "Korean Dramas", path: "dramas/korean-drama" },
                { name: "Chinese Dramas", path: "dramas/chinese-drama" },
                { name: "Anime", path: "anime" }
            ];

            const homeData = {};
            const results = await pooledMap(sections, 3, async (section) => {
                const url = section.path ? `${mainUrl}/${section.path}` : mainUrl;
                const res = await siteRequest(url, { attempts: 2, ttl: HTTP_CACHE_TTL });
                return [section.name, parseArticles(res.body, mainUrl)];
            });

            for (const entry of results) {
                if (entry && entry[1]?.length) homeData[entry[0]] = entry[1];
            }

            cb({ success: true, data: homeData });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await siteRequest(`${mainUrl}/?s=${encodeURIComponent(query)}`, { attempts: 2, ttl: HTTP_CACHE_TTL });
            cb({ success: true, data: parseArticles(res.body, mainUrl) });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    async function buildSeriesEpisodes(html, responseData, mainUrl) {
        const map = {};
        const sRe = /<h[23][^>]*>[\s\S]*?Season\s*(\d+)[\s\S]*?<\/h[23]>[\s\S]*?<a[^>]+href="([^"]+)"/gi;
        let sm;

        while ((sm = sRe.exec(html)) !== null) {
            const season = parseInt(sm[1], 10);
            const listUrl = resolveUrl(sm[2], mainUrl);
            if (!season || !listUrl) continue;

            try {
                const lr = await siteRequest(listUrl, { attempts: 2, ttl: HTTP_CACHE_TTL });
                for (const { href, text } of allHrefs(lr.body, listUrl)) {
                    const epMatch = text.match(/Episode\s*(\d+)/i)
                        || text.match(/\bEp\.?\s*(\d+)/i)
                        || text.match(/\bE(\d+)\b/i);
                    if (!epMatch || !isGoodUrl(href)) continue;

                    const episode = parseInt(epMatch[1], 10);
                    const key = `${season}_${episode}`;
                    if (!map[key]) map[key] = { season, episode, pageUrls: [] };
                    map[key].pageUrls.push(href);
                }
            } catch (e) {
                err("season list fetch:", e.message);
            }
        }

        return Object.values(map).map(ep => {
            const metaEp = responseData?.meta?.videos?.find(v => v.season === ep.season && v.episode === ep.episode);
            return new Episode({
                name: metaEp?.name || `Episode ${ep.episode}`,
                url: JSON.stringify(unique(ep.pageUrls)),
                season: ep.season,
                episode: ep.episode,
                description: metaEp?.overview || null,
                posterUrl: metaEp?.thumbnail || null,
                aired: metaEp?.released || null
            });
        }).sort((a, b) => a.season !== b.season ? a.season - b.season : a.episode - b.episode);
    }

    async function collectMovieLinks(html, mainUrl) {
        const candidates = new Set();

        for (const re of [
            /<a[^>]+class="[^"]*maxbutton[^"]*"[^>]+href="([^"']+)"/gi,
            /<a[^>]+class="[^"]*download-btn[^"]*"[^>]+href="([^"']+)"/gi
        ]) {
            for (const m of String(html || "").matchAll(re)) {
                candidates.add(resolveUrl(m[1], mainUrl));
            }
        }

        for (const { href, text } of allHrefs(html, mainUrl)) {
            if (isGoodUrl(href) && /download|480p|720p|1080p|4k|mvlink/i.test(text)) {
                candidates.add(href);
            }
        }

        if (candidates.size === 0) {
            warn("collectMovieLinks: no direct candidates, brute-forcing entry-content");
            const content = html.match(/<div[^>]+class="[^"]*entry-content[^"]*"[^>]*>([\s\S]*?)<\/div>/i)?.[1] || html;
            return unique(allHrefs(content, mainUrl).map(x => x.href).filter(isGoodUrl));
        }

        const nestedResults = await pooledMap([...candidates], 4, async (listUrl) => {
            const pageUrl = await rewriteToActiveDomain(listUrl);
            const { body } = await siteRequest(pageUrl, { attempts: 2, ttl: HTTP_CACHE_TTL });
            const content = body.match(/<div[^>]+class="[^"]*entry-content[^"]*"[^>]*>([\s\S]*?)<\/div>/i)?.[1] || body;
            return allHrefs(content, pageUrl)
                .map(x => x.href)
                .filter(href => isGoodUrl(href) && isCandidateStreamPageUrl(href));
        });

        return unique(nestedResults.flat());
    }

    async function extractPageStreams(pageUrl) {
        const key = String(pageUrl);
        const now = Date.now();
        const cached = streamCache.get(key);
        if (cached && cached.expiresAt > now) return cached.value;

        const job = (async () => {
            const { url: resolvedPageUrl, body } = await fetchFinal(pageUrl, 3, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
            const fileName = parseContainerValue(body, "Name") || stripTags(body.match(/<title>([^<]+)<\/title>/i)?.[1] || "");
            const fileSize = parseContainerValue(body, "Size");
            const specs = specsLabel(fileName);
            const btns = parseAnchorsByClass(body, "btn", resolvedPageUrl);
            const preferredBtns = btns
                .filter(btn => isGoodUrl(btn.href))
                .sort((a, b) => {
                    const score = (text) => {
                        const t = String(text || "").toLowerCase();
                        if (t.includes("gdirect")) return 0;
                        if (t.includes("hpage")) return 1;
                        if (t.includes("gdtot")) return 2;
                        return 3;
                    };
                    return score(a.text) - score(b.text);
                });

            for (const btn of preferredBtns) {
                try {
                    const { url: btnPageUrl, body: btnBody } = await fetchFinal(btn.href, 4, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
                    const heading = stripTags(btnBody.match(/<h2[^>]*>([\s\S]*?)<\/h2>/i)?.[1] || "");
                    const quality = qualityOf(heading) || qualityOf(fileName) || qualityOf(btn.text);
                    const finalLinks = unique([
                        ...parseAnchorsByClass(btnBody, "button", btnPageUrl),
                        ...parseAnchorsContainingButtonClass(btnBody, "button", btnPageUrl)
                    ].map(link => link && isGoodUrl(link.href) ? JSON.stringify(link) : null))
                        .map(link => JSON.parse(link));

                    if (finalLinks.length > 0) {
                        const link = finalLinks[0];
                        return [{
                            url: link.href,
                            quality,
                            source: `[${link.text || "HCloud"}]${specs}${fileSize ? `[${fileSize}]` : ""}`.trim(),
                            headers: { Referer: btnPageUrl }
                        }];
                    }
                } catch (e) {
                    err("extract btn page failed:", e.message);
                }
            }

            return [];
        })();

        streamCache.set(key, { value: job, expiresAt: now + STREAM_CACHE_TTL });
        try {
            return await job;
        } catch (e) {
            streamCache.delete(key);
            throw e;
        }
    }

    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            const realUrl = await rewriteToActiveDomain(url);
            const res = await siteRequest(realUrl, { attempts: 2, ttl: HTTP_CACHE_TTL });
            const html = res.body;

            let name = null;
            let imdbRating = null;
            let imdbId = null;
            let releaseYear = null;
            let docGenres = [];

            const liRe = /<li>([\s\S]*?)<\/li>/gi;
            let lm;
            while ((lm = liRe.exec(html)) !== null) {
                const liHtml = lm[1];
                const sm = liHtml.match(/<strong>([\s\S]*?)<\/strong>/i);
                if (!sm) continue;
                const key = stripTags(sm[1]).split(":")[0].trim();
                const innerValue = (stripTags(sm[1]).split(":")[1] || "").trim();
                const value = stripTags(liHtml.replace(sm[0], "")).trim() || innerValue;

                if (key === "Name") name = value || null;
                else if (key === "IMDB Rating") {
                    imdbRating = innerValue.split("/")[0].trim() || null;
                    const im = liHtml.match(/href="[^"]*\/title\/(tt\d+)\//i);
                    if (im) imdbId = im[1];
                } else if (key === "Release Year") {
                    releaseYear = value || null;
                } else if (key === "Genre") {
                    docGenres = value.split(",").map(s => s.trim()).filter(Boolean);
                }
            }

            if (!name) {
                const m = html.match(/(?:Name|Movie Name)\s*:\s*([^\n<]+)/i);
                if (m) name = stripTags(m[1]).trim();
            }
            if (!releaseYear) {
                const m = html.match(/(?:Release Year|Year)\s*:\s*(\d{4})/i);
                if (m) releaseYear = m[1];
            }

            const title = name || "Unknown";
            const poster = html.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/i)?.[1] || null;
            const descRaw = html.match(/<h3[^>]*>[^<]*Storyline[^<]*<\/h3>\s*<p[^>]*>([\s\S]*?)<\/p>/i)?.[1];
            const heading = stripTags(html.match(/<h1[^>]*class="entry-title"[^>]*>([\s\S]*?)<\/h1>/i)?.[1] || "");
            const isSeries = /Season/i.test(heading);

            let description = descRaw ? stripTags(descRaw) : null;
            let background = poster;
            let castList = [];

            const [tmdbId, responseData] = await Promise.all([
                imdbId ? tmdbIdFromImdb(imdbId) : Promise.resolve(null),
                imdbId ? fetchWithRetry(`${CINEMETA_URL}/${isSeries ? "series" : "movie"}/${imdbId}.json`, {
                    attempts: 2,
                    ttl: DOMAIN_CACHE_TTL,
                    allowBlocked: true
                }).then(cr => cr.body?.trim().startsWith("{") ? JSON.parse(cr.body) : null).catch(() => null) : Promise.resolve(null)
            ]);

            if (tmdbId) {
                try {
                    const cr = await fetchWithRetry(`https://api.themoviedb.org/3/${isSeries ? "tv" : "movie"}/${tmdbId}/credits?api_key=${TMDB_API_KEY}&language=en-US`, {
                        attempts: 2,
                        ttl: DOMAIN_CACHE_TTL,
                        allowBlocked: true
                    });
                    castList = parseCredits(cr.body);
                } catch (_) {}
            }

            if (responseData?.meta) {
                description = responseData.meta.description || description;
                background = responseData.meta.background || poster;
            }

            if (isSeries) {
                const episodes = await buildSeriesEpisodes(html, responseData, mainUrl);
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: responseData?.meta?.name || title,
                        url: realUrl,
                        posterUrl: poster,
                        bannerUrl: background,
                        logoUrl: responseData?.meta?.logo || null,
                        type: "series",
                        description,
                        year: parseInt(releaseYear || responseData?.meta?.year) || undefined,
                        score: parseFloat(imdbRating || responseData?.meta?.imdbRating) || undefined,
                        genres: docGenres,
                        cast: castList,
                        episodes
                    })
                });
                return;
            }

            const pageUrls = await collectMovieLinks(html, mainUrl);
            cb({
                success: true,
                data: new MultimediaItem({
                    title: responseData?.meta?.name || title,
                    url: realUrl,
                    posterUrl: poster,
                    bannerUrl: background,
                    logoUrl: responseData?.meta?.logo || null,
                    type: "movie",
                    description,
                    year: parseInt(releaseYear || responseData?.meta?.year) || undefined,
                    score: parseFloat(imdbRating || responseData?.meta?.imdbRating) || undefined,
                    genres: docGenres,
                    cast: castList,
                    episodes: [new Episode({
                        name: "Movie",
                        url: JSON.stringify(pageUrls),
                        season: 1,
                        episode: 1
                    })]
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    async function loadStreams(url, cb) {
        try {
            const parsed = JSON.parse(url);
            const pageUrls = Array.isArray(parsed) ? unique(parsed) : [];
            if (pageUrls.length === 0) {
                cb({ success: true, data: [] });
                return;
            }

            const extracted = await pooledMap(pageUrls, 4, extractPageStreams);
            const seenUrls = new Set();
            const results = [];

            for (const group of extracted) {
                for (const stream of group || []) {
                    if (!stream?.url || seenUrls.has(stream.url)) continue;
                    seenUrls.add(stream.url);
                    results.push(new StreamResult(stream));
                }
            }

            results.sort((a, b) => (b.quality || 0) - (a.quality || 0));
            cb({ success: true, data: results });
        } catch (e) {
            err("LoadStreams:", e);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    for (const ctx of [
        typeof globalThis !== "undefined" ? globalThis : null,
        typeof window !== "undefined" ? window : null,
        typeof global !== "undefined" ? global : null
    ]) {
        if (ctx) {
            ctx.getHome = getHome;
            ctx.search = search;
            ctx.load = load;
            ctx.loadStreams = loadStreams;
        }
    }
})();
