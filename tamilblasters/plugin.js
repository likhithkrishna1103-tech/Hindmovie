(function () {
    const DEBUG = false;
    function log(...a) { if (DEBUG) console.log("[Tamilblasters]", ...a); }
    function err(...a) { console.error("[Tamilblasters ERR]", ...a); }

    const DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    const FALLBACK_MAIN_URL = "https://www.1tamilblasters.dog/";
    const STREAMHG_BASE = "https://cavanhabg.com";

    const HTTP_CACHE_TTL = 5 * 60 * 1000;
    const DOMAIN_CACHE_TTL = 30 * 60 * 1000;

    const httpCache = new Map();
    const inFlightGets = new Map();

    let cachedDomains = null;
    let cachedDomainsAt = 0;
    let resolvingDomains = null;

    function sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    function unique(arr) {
        return [...new Set((arr || []).filter(Boolean))];
    }

    function stripTags(html) {
        return String(html || "")
            .replace(/<script[\s\S]*?<\/script>/gi, " ")
            .replace(/<style[\s\S]*?<\/style>/gi, " ")
            .replace(/<[^>]+>/g, " ")
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/\s+/g, " ")
            .trim();
    }

    function decodeHtmlEntities(text) {
        return String(text || "")
            .replace(/&#(\d+);/g, (_, dec) => {
                const code = parseInt(dec, 10);
                return Number.isFinite(code) ? String.fromCodePoint(code) : _;
            })
            .replace(/&#x([0-9a-f]+);/gi, (_, hex) => {
                const code = parseInt(hex, 16);
                return Number.isFinite(code) ? String.fromCodePoint(code) : _;
            })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/&ndash;/gi, "-")
            .replace(/&mdash;/gi, "-")
            .replace(/&hellip;/gi, "...")
            .replace(/\s+/g, " ")
            .trim();
    }

    function decodeEntities(text) {
        return decodeHtmlEntities(stripTags(String(text || "").replace(/</g, "&lt;")));
    }

    function getOrigin(url) {
        const match = String(url || "").match(/^https?:\/\/[^/]+/i);
        return match ? match[0].replace(/\/$/, "") : "";
    }

    function resolveUrl(href, base) {
        if (!href) return null;
        if (/^https?:\/\//i.test(href)) return href;
        if (href.startsWith("//")) return `https:${href}`;
        const origin = getOrigin(base);
        const cleanBase = String(base || "").replace(/[?#].*$/, "");
        const dir = cleanBase.endsWith("/") ? cleanBase.slice(0, -1) : cleanBase.replace(/\/[^/]*$/, "");
        if (href.startsWith("/")) return `${origin}${href}`;
        return `${dir}/${href}`
            .replace(/^https?:\/\//i, match => match.replace("//", "__PROTO__"))
            .replace(/\/{2,}/g, "/")
            .replace("__PROTO__", "//");
    }

    function isBlockedBody(body) {
        const text = String(body || "");
        return /just a moment/i.test(text)
            || /checking if the site connection is secure/i.test(text)
            || /cf-browser-verification/i.test(text)
            || (/attention required/i.test(text) && /cloudflare/i.test(text));
    }

    async function httpGetCached(url, ttl = HTTP_CACHE_TTL, force = false) {
        const key = String(url);
        const now = Date.now();
        const cached = httpCache.get(key);
        if (!force && cached && cached.expiresAt > now) return cached.value;
        if (!force && inFlightGets.has(key)) return inFlightGets.get(key);

        const job = (async () => {
            const value = await http_get(url);
            httpCache.set(key, { value, expiresAt: Date.now() + ttl });
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

    async function getDomains(forceRefresh = false) {
        const now = Date.now();
        if (!forceRefresh && cachedDomains && (now - cachedDomainsAt) < DOMAIN_CACHE_TTL) return cachedDomains;
        if (!forceRefresh && resolvingDomains) return resolvingDomains;

        resolvingDomains = (async () => {
            try {
                const res = await fetchWithRetry(DOMAINS_URL, {
                    attempts: 2,
                    ttl: DOMAIN_CACHE_TTL,
                    force: forceRefresh,
                    allowBlocked: true
                });
                const body = String(res.body || "").trim();
                if (!body.startsWith("{")) throw new Error(`Unexpected domains response: ${body.slice(0, 80)}`);
                cachedDomains = JSON.parse(body);
                cachedDomainsAt = Date.now();
                return cachedDomains;
            } catch (e) {
                return cachedDomains;
            }
        })();

        try {
            return await resolvingDomains;
        } finally {
            resolvingDomains = null;
        }
    }

    async function getMainUrl() {
        try {
            const domains = await getDomains(false);
            return domains?.tamilblasters || FALLBACK_MAIN_URL;
        } catch (_) {
            return FALLBACK_MAIN_URL;
        }
    }

    function splitTopLevel(html, tagName) {
        const source = String(html || "");
        const tag = tagName.toLowerCase();
        const openRe = new RegExp(`<${tag}\\b[^>]*>`, "ig");
        const closeRe = new RegExp(`</${tag}>`, "ig");
        const out = [];
        let match;

        while ((match = openRe.exec(source)) !== null) {
            let depth = 1;
            let cursor = openRe.lastIndex;
            while (depth > 0) {
                openRe.lastIndex = cursor;
                closeRe.lastIndex = cursor;
                const nextOpen = openRe.exec(source);
                const nextClose = closeRe.exec(source);
                if (!nextClose) {
                    depth = 0;
                    cursor = source.length;
                    break;
                }
                if (nextOpen && nextOpen.index < nextClose.index) {
                    depth += 1;
                    cursor = openRe.lastIndex;
                } else {
                    depth -= 1;
                    cursor = closeRe.lastIndex;
                }
            }
            out.push(source.slice(match.index, cursor));
            openRe.lastIndex = cursor;
        }

        return out;
    }

    function extractArticleBlocks(html, className) {
        const classRe = new RegExp(`\\b${className.replace(/[.*+?^${}()|[\]\\]/g, "\\$&")}\\b`, "i");
        return splitTopLevel(html, "article").filter(block => {
            return classRe.test(block);
        });
    }

    function parseSearchResultBlock(block, mainUrl) {
        const title = decodeEntities(
            block.match(/<h2[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a[^>]*>([\s\S]*?)<\/a>\s*<\/h2>/i)?.[1]
            || block.match(/<h2[^>]*>\s*<a[^>]*>([\s\S]*?)<\/a>\s*<\/h2>/i)?.[1]
            || ""
        );
        const href = resolveUrl(block.match(/<a[^>]+href=["']([^"']+)["']/i)?.[1], mainUrl);
        if (!title || !href) return null;
        const posterUrl = resolveUrl(
            block.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i)?.[1],
            mainUrl
        ) || null;
        return new MultimediaItem({
            title,
            url: href,
            posterUrl,
            type: /\bS\d+\b|\bEP\b|season/i.test(title) ? "series" : "movie"
        });
    }

    function parseSearchResults(html, mainUrl) {
        return extractArticleBlocks(html, "article-content-col")
            .map(block => parseSearchResultBlock(block, mainUrl))
            .filter(Boolean);
    }

    function parseOgDescription(html) {
        return html.match(/<meta[^>]+property=["']og:description["'][^>]+content=["']([^"']+)["']/i)?.[1] || "";
    }

    function parsePosterUrl(html, baseUrl) {
        return resolveUrl(html.match(/<meta[^>]+property=["']og:image["'][^>]+content=["']([^"']+)["']/i)?.[1], baseUrl) || null;
    }

    function parsePlot(html) {
        const paragraphs = splitTopLevel(html, "p");
        for (const p of paragraphs) {
            const strong = p.match(/<strong[^>]*>([\s\S]*?)<\/strong>/i);
            if (!strong) continue;
            if (!/plot/i.test(stripTags(strong[1]))) continue;
            return stripTags(p.replace(strong[0], "")).trim();
        }
        return "";
    }

    function parseParagraphs(html) {
        return splitTopLevel(html, "p")
            .map(p => decodeEntities(stripTags(p)))
            .map(p => p.replace(/\s+/g, " ").trim())
            .filter(Boolean);
    }

    function extractDescription(html) {
        const explicitPlot = parsePlot(html);
        if (explicitPlot) return decodeEntities(explicitPlot);

        const paragraphs = parseParagraphs(html);
        for (const paragraph of paragraphs) {
            if (/^movie name\s*:/i.test(paragraph)) continue;
            if (/^episode\s*[–-]/i.test(paragraph)) continue;
            if (/^(latest movies|watch online|download now)/i.test(paragraph)) continue;
            if (/^(www\.1tamilblasters|magnet:)/i.test(paragraph)) continue;
            if (paragraph.length >= 40) return paragraph;
        }
        return "";
    }

    function parseInfoTitle(ogDesc, heading) {
        const source = decodeEntities(ogDesc || "");
        const headingText = decodeEntities(heading || "");
        const fromOg = source.match(/Movie Name:\s*(.+?)(?=(?:Directed by|Written by|Created by|Starring by|Starring|Genres|Country|Language)\s*:|$)/i)?.[1]?.trim();
        if (fromOg) {
            return fromOg.replace(/\b(HDRip|WEBRip|WEB-DL|DVDRip)\b/gi, "").replace(/\s+/g, " ").trim();
        }
        return headingText
            .replace(/\s*Movie Download\s*-\s*Tamilblasters$/i, "")
            .trim();
    }

    function inferIsSeries(title, heading, ogDesc, html) {
        const text = [title, heading, ogDesc].map(x => String(x || "")).join(" ");
        if (/\bS\d{1,2}\b/i.test(text) || /\bEP\s*\(?\d+/i.test(text) || /\bseason\s*\d+/i.test(text)) return true;
        return parseParagraphs(html).some(p => /^episode\s*[–-]\s*\d+/i.test(p));
    }

    function parseIframes(html, baseUrl) {
        return [...String(html || "").matchAll(/<iframe[^>]+src=["']([^"']+)["'][^>]*><\/iframe>|<iframe[^>]+src=["']([^"']+)["'][^>]*>/gi)]
            .map(match => resolveUrl(match[1] || match[2], baseUrl))
            .filter(Boolean);
    }

    function extractVideos(html, baseUrl) {
        const source = String(html || "");
        const iframeRe = /<iframe[^>]+src=["']([^"']+)["'][^>]*><\/iframe>|<iframe[^>]+src=["']([^"']+)["'][^>]*>/gi;
        const videos = [];
        let match;

        while ((match = iframeRe.exec(source)) !== null) {
            const before = source.slice(0, match.index);
            const paragraphMatches = [...before.matchAll(/<p\b[^>]*>([\s\S]*?)<\/p>/gi)];
            const lastParagraph = paragraphMatches.length ? paragraphMatches[paragraphMatches.length - 1][1] : "";
            const label = stripTags(lastParagraph);
            if (!label) continue;
            const url = resolveUrl(match[1] || match[2], baseUrl);
            if (!url) continue;
            videos.push({ title: label, url });
        }

        return videos;
    }

    function parseEpisodeMeta(label, fallbackIndex) {
        const text = decodeEntities(label || "").trim();
        const episode = parseInt(text.match(/episode\s*[–-]?\s*(\d+)/i)?.[1] || `${fallbackIndex}`, 10) || fallbackIndex;
        const name = text.replace(/^episode\s*[–-]?\s*\d+\s*/i, "").trim() || `Episode ${episode}`;
        return { episode, name: text || name || `Episode ${episode}` };
    }

    function rewriteHgUrl(url) {
        let streamUrl = String(url || "");
        if (streamUrl.includes("hg")) {
            const secondPart = streamUrl.includes("/e") ? streamUrl.split("/e").slice(1).join("/e") : "";
            if (secondPart) streamUrl = `${STREAMHG_BASE}/e/${secondPart.replace(/^\/+/, "")}`;
        }
        return streamUrl;
    }

    function parseHost(url) {
        const match = String(url || "").match(/^https?:\/\/([^/]+)/i);
        return (match?.[1] || "").toLowerCase();
    }

    function qualityFromUrl(url) {
        const text = String(url || "").toLowerCase();
        if (/\b(2160p|4k)\b/.test(text)) return 2160;
        if (/\b1080p\b/.test(text)) return 1080;
        if (/\b720p\b/.test(text)) return 720;
        if (/\b480p\b/.test(text)) return 480;
        return 0;
    }

    function findMediaUrls(html, pageUrl) {
        const body = String(html || "");
        const found = new Set();

        for (const match of body.matchAll(/https?:\/\/[^"'\\\s<>]+(?:m3u8|mp4|master\.txt)[^"'\\\s<>]*/gi)) {
            found.add(match[0]);
        }

        for (const match of body.matchAll(/["']([^"']+(?:m3u8|mp4|master\.txt)[^"']*)["']/gi)) {
            const resolved = resolveUrl(match[1], pageUrl);
            if (resolved) found.add(resolved);
        }

        return [...found];
    }

    async function fetchFinal(url, maxHops = 5, opts = {}) {
        let current = url;
        for (let i = 0; i < maxHops; i++) {
            const res = await fetchWithRetry(current, {
                attempts: 2,
                ttl: opts.ttl ?? HTTP_CACHE_TTL,
                allowBlocked: !!opts.allowBlocked
            });
            const body = res.body || "";
            const location = res.headers?.location || res.headers?.Location;
            if (location) {
                current = resolveUrl(location, current);
                continue;
            }

            const meta = body.match(/<meta[^>]+http-equiv=["']refresh["'][^>]+content=["'][^"']*url=([^"'>\s]+)["']/i);
            if (meta) {
                current = resolveUrl(meta[1].replace(/['"]/g, ""), current);
                continue;
            }

            const js = body.match(/window\.location(?:\.href)?\s*=\s*["']([^"']+)["']/i)
                || body.match(/location\.replace\(\s*["']([^"']+)["']\s*\)/i);
            if (js) {
                current = resolveUrl(js[1], current);
                continue;
            }

            return { url: current, body };
        }
        return { url: current, body: "" };
    }

    async function extractIframeStream(streamUrl, referer, label) {
        const finalTarget = rewriteHgUrl(streamUrl);
        const { url: finalUrl, body } = await fetchFinal(finalTarget, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
        const mediaUrls = findMediaUrls(body, finalUrl);
        const finalHost = parseHost(finalUrl);
        const isHgFamily = /(?:^|\.)(hgcloud\.to|cavanhabg\.com|hglink\.to)$/.test(finalHost);

        if (mediaUrls.length > 0) {
            return mediaUrls.map(url => new StreamResult({
                url,
                quality: qualityFromUrl(url) || qualityFromUrl(label),
                source: label || parseHost(finalTarget) || "Tamilblasters",
                headers: { Referer: referer || finalTarget }
            }));
        }

        if (isHgFamily) {
            return [];
        }

        return [new StreamResult({
            url: finalUrl,
            quality: qualityFromUrl(label),
            source: label || parseHost(finalTarget) || "Tamilblasters",
            headers: { Referer: referer || finalTarget }
        })];
    }

    function dedupeStreams(streams) {
        const seen = new Set();
        const out = [];
        for (const stream of streams || []) {
            const key = `${stream?.url}|${stream?.source}`;
            if (!stream?.url || seen.has(key)) continue;
            seen.add(key);
            out.push(stream);
        }
        return out.sort((a, b) => (b.quality || 0) - (a.quality || 0));
    }

    function parseJsonLikeInput(value) {
        const raw = String(value || "").trim();
        const candidates = [raw];
        if ((raw.startsWith("'") && raw.endsWith("'")) || (raw.startsWith("\"") && raw.endsWith("\""))) {
            candidates.push(raw.slice(1, -1));
        }
        candidates.push(raw.replace(/\\"/g, "\""));
        candidates.push(raw.replace(/\\"/g, "\"").replace(/^"+|"+$/g, ""));

        for (const candidate of unique(candidates)) {
            try {
                return JSON.parse(candidate);
            } catch (_) {}
        }

        const objectLike = raw.match(/^\{\s*url\s*:\s*([^,}]+)\s*,\s*title\s*:\s*(.+)\s*\}$/i)
            || raw.match(/^\{\s*title\s*:\s*([^,}]+)\s*,\s*url\s*:\s*(.+)\s*\}$/i);
        if (objectLike) {
            const firstIsUrl = /^\{\s*url\s*:/i.test(raw);
            const first = decodeEntities(objectLike[1]).trim();
            const second = decodeEntities(objectLike[2]).trim();
            return firstIsUrl
                ? { url: first, title: second }
                : { title: first, url: second };
        }

        throw new Error("Invalid serialized episode payload");
    }

    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await fetchFinal(mainUrl, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
            const items = parseSearchResults(res.body, res.url || mainUrl);
            cb({
                success: true,
                data: {
                    Home: items
                }
            });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await fetchFinal(`${mainUrl}/?s=${encodeURIComponent(query)}`, 5, {
                ttl: HTTP_CACHE_TTL,
                allowBlocked: true
            });
            const items = parseSearchResults(res.body, res.url || mainUrl);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    async function load(url, cb) {
        try {
            const res = await fetchFinal(url, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
            const html = res.body || "";
            const ogDesc = parseOgDescription(html);
            if (!ogDesc) {
                cb({ success: false, errorCode: "LOAD_ERROR", message: "Missing og:description" });
                return;
            }

            const heading = decodeEntities(stripTags(html.match(/<h1[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i)?.[1] || ""));
            const title = parseInfoTitle(ogDesc, heading) || heading || "Unknown";
            const yearMatch = ogDesc.match(/\((\d{4})\)/);
            const year = yearMatch ? parseInt(yearMatch[1], 10) : undefined;
            const isSeries = inferIsSeries(title, heading, ogDesc, html);
            const posterUrl = parsePosterUrl(html, url);
            const plot = extractDescription(html);

            if (isSeries) {
                const episodes = extractVideos(html, url).map((video, index) => {
                    const meta = parseEpisodeMeta(video.title, index + 1);
                    return new Episode({
                    name: meta.name,
                    url: JSON.stringify(video),
                    season: 1,
                    episode: meta.episode
                });
                }).sort((a, b) => (a.episode || 0) - (b.episode || 0));

                cb({
                    success: true,
                    data: new MultimediaItem({
                        title,
                        url,
                        posterUrl,
                        type: "series",
                        description: plot,
                        year,
                        episodes
                    })
                });
                return;
            }

            cb({
                success: true,
                data: new MultimediaItem({
                    title,
                    url,
                    posterUrl,
                    type: "movie",
                    description: plot,
                    year,
                    episodes: [new Episode({
                        name: "Movie",
                        url,
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
            let streamResults = [];

            if (/^[{'"]/.test(String(url || "").trim())) {
                const loadData = parseJsonLikeInput(url);
                if (loadData?.url) {
                    streamResults = await extractIframeStream(loadData.url, await getMainUrl(), loadData.title);
                    cb({ success: true, data: dedupeStreams(streamResults) });
                    return;
                }
            }

            const res = await fetchWithRetry(url, { attempts: 2, ttl: HTTP_CACHE_TTL });
            const iframeUrls = parseIframes(res.body || "", url);
            for (const iframeUrl of iframeUrls) {
                const host = parseHost(iframeUrl);
                const label = host || "Tamilblasters";
                if (host.includes("hg")) {
                    streamResults.push(...await extractIframeStream(iframeUrl, url, label));
                } else {
                    streamResults.push(...await extractIframeStream(iframeUrl, url, label));
                }
            }

            cb({ success: true, data: dedupeStreams(streamResults) });
        } catch (e) {
            log("loadStreams failed", e.message || e);
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
