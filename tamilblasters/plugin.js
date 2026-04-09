(function () {
    const DEBUG = true;
    function log(...a) { if (DEBUG) console.log("[Tamilblasters]", ...a); }
    function err(...a) { console.error("[Tamilblasters ERR]", ...a); }

    const DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    const FALLBACK_MAIN_URL = "https://www.1tamilblasters.dog/";

    const STREAMHG_BASE = "https://streamhg.com";

    const HTTP_CACHE_TTL  = 5 * 60 * 1000;
    const DOMAIN_CACHE_TTL = 30 * 60 * 1000;

    const httpCache    = new Map();
    const inFlightGets = new Map();

    let cachedDomains   = null;
    let cachedDomainsAt = 0;
    let resolvingDomains = null;

    function sleep(ms) { return new Promise(r => setTimeout(r, ms)); }

    function unique(arr) { return [...new Set((arr || []).filter(Boolean))]; }

    function stripTags(html) {
        return String(html || "")
            .replace(/<script[\s\S]*?<\/script>/gi, " ")
            .replace(/<style[\s\S]*?<\/style>/gi,   " ")
            .replace(/<[^>]+>/g, " ")
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi,  "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi,  "<")
            .replace(/&gt;/gi,  ">")
            .replace(/\s+/g,    " ")
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
            .replace(/&nbsp;/gi,   " ")
            .replace(/&amp;/gi,    "&")
            .replace(/&quot;/gi,   "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi,     "<")
            .replace(/&gt;/gi,     ">")
            .replace(/&ndash;/gi,  "-")
            .replace(/&mdash;/gi,  "-")
            .replace(/&hellip;/gi, "...")
            .replace(/\s+/g, " ")
            .trim();
    }

    function decodeEntities(text) {
        return decodeHtmlEntities(stripTags(String(text || "").replace(/</g, "&lt;")));
    }

    function getOrigin(url) {
        const m = String(url || "").match(/^https?:\/\/[^/]+/i);
        return m ? m[0].replace(/\/$/, "") : "";
    }

    function resolveUrl(href, base) {
        if (!href) return null;
        if (/^https?:\/\//i.test(href)) return href;
        if (href.startsWith("//")) return `https:${href}`;
        const origin   = getOrigin(base);
        const cleanBase = String(base || "").replace(/[?#].*$/, "");
        const dir = cleanBase.endsWith("/")
            ? cleanBase.slice(0, -1)
            : cleanBase.replace(/\/[^/]*$/, "");
        if (href.startsWith("/")) return `${origin}${href}`;
        return `${dir}/${href}`
            .replace(/^https?:\/\//i, m => m.replace("//", "__PROTO__"))
            .replace(/\/{2,}/g, "/")
            .replace("__PROTO__", "//");
    }

    function isBlockedBody(body) {
        const t = String(body || "");
        return /just a moment/i.test(t)
            || /checking if the site connection is secure/i.test(t)
            || /cf-browser-verification/i.test(t)
            || (/attention required/i.test(t) && /cloudflare/i.test(t));
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
        try { return await job; } finally { inFlightGets.delete(key); }
    }

    async function fetchWithRetry(url, {
        attempts = 2, ttl = HTTP_CACHE_TTL, force = false, allowBlocked = false
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
                    attempts: 2, ttl: DOMAIN_CACHE_TTL, force: forceRefresh, allowBlocked: true
                });
                const body = String(res.body || "").trim();
                if (!body.startsWith("{")) throw new Error(`Bad domains: ${body.slice(0, 80)}`);
                cachedDomains   = JSON.parse(body);
                cachedDomainsAt = Date.now();
                return cachedDomains;
            } catch (e) { return cachedDomains; }
        })();

        try { return await resolvingDomains; } finally { resolvingDomains = null; }
    }

    async function getMainUrl() {
        try {
            const d = await getDomains(false);
            return d?.tamilblasters || FALLBACK_MAIN_URL;
        } catch (_) { return FALLBACK_MAIN_URL; }
    }

    function splitTopLevel(html, tagName) {
        const source = String(html || "");
        const tag    = tagName.toLowerCase();
        const openRe  = new RegExp(`<${tag}\\b[^>]*>`,  "ig");
        const closeRe = new RegExp(`</${tag}>`,          "ig");
        const out = [];
        let match;

        while ((match = openRe.exec(source)) !== null) {
            let depth = 1, cursor = openRe.lastIndex;
            while (depth > 0) {
                openRe.lastIndex  = cursor;
                closeRe.lastIndex = cursor;
                const nextOpen  = openRe.exec(source);
                const nextClose = closeRe.exec(source);
                if (!nextClose) { depth = 0; cursor = source.length; break; }
                if (nextOpen && nextOpen.index < nextClose.index) {
                    depth++; cursor = openRe.lastIndex;
                } else {
                    depth--; cursor = closeRe.lastIndex;
                }
            }
            out.push(source.slice(match.index, cursor));
            openRe.lastIndex = cursor;
        }
        return out;
    }

    function extractArticleBlocks(html, className) {
        const re = new RegExp(`\\b${className.replace(/[.*+?^${}()|[\]\\]/g, "\\$&")}\\b`, "i");
        return splitTopLevel(html, "article").filter(b => re.test(b));
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
            block.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i)?.[1], mainUrl
        ) || null;
        return new MultimediaItem({
            title, url: href, posterUrl,
            type: /\bS\d+\b|\bEP\b|season/i.test(title) ? "series" : "movie"
        });
    }

    function parseSearchResults(html, mainUrl) {
        return extractArticleBlocks(html, "article-content-col")
            .map(b => parseSearchResultBlock(b, mainUrl))
            .filter(Boolean);
    }

    function parseOgDescription(html) {
        return html.match(/<meta[^>]+property=["']og:description["'][^>]+content=["']([^"']+)["']/i)?.[1] || "";
    }

    function parsePosterUrl(html, baseUrl) {
        return resolveUrl(
            html.match(/<meta[^>]+property=["']og:image["'][^>]+content=["']([^"']+)["']/i)?.[1], baseUrl
        ) || null;
    }

    function parsePlot(html) {
        for (const p of splitTopLevel(html, "p")) {
            const strong = p.match(/<strong[^>]*>([\s\S]*?)<\/strong>/i);
            if (!strong || !/plot/i.test(stripTags(strong[1]))) continue;
            return stripTags(p.replace(strong[0], "")).trim();
        }
        return "";
    }

    function parseParagraphs(html) {
        return splitTopLevel(html, "p")
            .map(p => decodeEntities(stripTags(p)).replace(/\s+/g, " ").trim())
            .filter(Boolean);
    }

    function extractDescription(html) {
        const plot = parsePlot(html);
        if (plot) return decodeEntities(plot);
        for (const p of parseParagraphs(html)) {
            if (/^movie name\s*:/i.test(p))  continue;
            if (/^episode\s*[–-]/i.test(p))  continue;
            if (/^(latest movies|watch online|download now)/i.test(p)) continue;
            if (/^(www\.1tamilblasters|magnet:)/i.test(p)) continue;
            if (p.length >= 40) return p;
        }
        return "";
    }

    function parseInfoTitle(ogDesc, heading) {
        const src = decodeEntities(ogDesc || "");
        const hd  = decodeEntities(heading || "");
        const fromOg = src.match(
            /Movie Name:\s*(.+?)(?=(?:Directed by|Written by|Created by|Starring by|Starring|Genres|Country|Language)\s*:|$)/i
        )?.[1]?.trim();
        if (fromOg) return fromOg.replace(/\b(HDRip|WEBRip|WEB-DL|DVDRip)\b/gi, "").replace(/\s+/g, " ").trim();
        return hd.replace(/\s*Movie Download\s*-\s*Tamilblasters$/i, "").trim();
    }

    function inferIsSeries(title, heading, ogDesc, html) {
        const text = [title, heading, ogDesc].map(x => String(x || "")).join(" ");
        if (/\bS\d{1,2}\b/i.test(text) || /\bEP\s*\(?\d+/i.test(text) || /\bseason\s*\d+/i.test(text)) return true;
        return parseParagraphs(html).some(p => /^episode\s*[–-]\s*\d+/i.test(p));
    }

    function parseIframes(html, baseUrl) {
        return [...String(html || "").matchAll(/<iframe[^>]+src=["']([^"']+)["'][^>]*\/?>/gi)]
            .map(m => resolveUrl(m[1], baseUrl))
            .filter(Boolean);
    }

    function extractVideos(html, baseUrl) {
        const source  = String(html || "");
        const iframeRe = /<iframe[^>]+src=["']([^"']+)["'][^>]*\/?>/gi;
        const videos  = [];
        let match;
        while ((match = iframeRe.exec(source)) !== null) {
            const before = source.slice(0, match.index);
            const pMatches = [...before.matchAll(/<p\b[^>]*>([\s\S]*?)<\/p>/gi)];
            const label = stripTags(pMatches.length ? pMatches[pMatches.length - 1][1] : "");
            if (!label) continue;
            const url = resolveUrl(match[1], baseUrl);
            if (!url) continue;
            videos.push({ title: label, url, referer: baseUrl });
        }
        return videos;
    }

    function parseEpisodeMeta(label, fallbackIndex) {
        const text = decodeEntities(label || "").trim();
        const episode = parseInt(text.match(/episode\s*[–-]?\s*(\d+)/i)?.[1] || `${fallbackIndex}`, 10) || fallbackIndex;
        const name = text.replace(/^episode\s*[–-]?\s*\d+\s*/i, "").trim() || `Episode ${episode}`;
        return { episode, name: text || name || `Episode ${episode}` };
    }

    function parseHost(url) {
        const m = String(url || "").match(/^https?:\/\/([^/]+)/i);
        return (m?.[1] || "").toLowerCase();
    }

    function buildHgApiUrl(url, videoId) {
        const host = parseHost(url) || "streamhg.com";
        return `https://${host}/api/source/${videoId}`;
    }

    function qualityFromUrl(url) {
        const t = String(url || "").toLowerCase();
        if (/\b(2160p|4k)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t))      return 1080;
        if (/\b720p\b/.test(t))       return 720;
        if (/\b480p\b/.test(t))       return 480;
        return 0;
    }

    function findMediaUrls(html, pageUrl) {
        const body  = String(html || "");
        const found = new Set();
        const addFound = (value) => {
            const v = String(value || "").trim();
            if (!v) return;
            if (v.includes("|")) return;
            if (v.length > 2000) return;
            found.add(v);
        };
        for (const m of body.matchAll(/https?:\/\/[^"'\\\s<>]+(?:m3u8|mp4|master\.txt)[^"'\\\s<>]*/gi))
            addFound(m[0]);
        for (const m of body.matchAll(/["']([^"']+(?:m3u8|mp4|master\.txt)[^"']*)["']/gi)) {
            const r = resolveUrl(m[1], pageUrl);
            if (r) addFound(r);
        }
        for (const m of body.matchAll(/https?:\\\/\\\/[^"'\\\s<>]+(?:m3u8|mp4|master\.txt)[^"'\\\s<>]*/gi)) {
            const r = m[0].replace(/\\\//g, "/");
            if (r) addFound(r);
        }
        return [...found];
    }

    function extractHgId(url) {
        const src = String(url || "");
        return src.match(/\/(?:e|d|embed)\/([a-zA-Z0-9]+)/i)?.[1]
            || src.match(/[?&](?:id|v)=([a-zA-Z0-9]+)/i)?.[1]
            || null;
    }

    async function fetchFinal(url, maxHops = 5, opts = {}) {
        let current = url;
        for (let i = 0; i < maxHops; i++) {
            const res  = await fetchWithRetry(current, {
                attempts: 2, ttl: opts.ttl ?? HTTP_CACHE_TTL, allowBlocked: !!opts.allowBlocked
            });
            const body = res.body || "";
            const loc  = res.headers?.location || res.headers?.Location;
            if (loc) { current = resolveUrl(loc, current); continue; }

            const meta = body.match(/<meta[^>]+http-equiv=["']refresh["'][^>]+content=["'][^"']*url=([^"'>\s]+)["']/i);
            if (meta) { current = resolveUrl(meta[1].replace(/['"]/g, ""), current); continue; }

            const js = body.match(/window\.location(?:\.href)?\s*=\s*["']([^"']+)["']/i)
                    || body.match(/location\.replace\(\s*["']([^"']+)["']\s*\)/i);
            if (js) { current = resolveUrl(js[1], current); continue; }

            return { url: current, body };
        }
        return { url: current, body: "" };
    }

    // Keep host aliases normalized to an /e/<id> style URL, but do not force a
    // specific domain. The live flow now relies on host-side loader JS.
    function rewriteHgUrl(url) {
        const src = String(url || "");
        if (/\/e\//i.test(src)) return src;
        const videoId = extractHgId(src);
        if (videoId) {
            const host = parseHost(src) || "hgcloud.to";
            return `https://${host}/e/${videoId}`;
        }
        return src;
    }

    function isHgFamily(url) {
        const host = parseHost(url);
        return /(?:^|\.)(streamhg\.com|hgcloud\.to|hglink\.to)$/.test(host);
    }

    // Try http_post with multiple calling conventions (SkyStream runtimes differ).
    async function tryHttpPost(url, formBody, headers) {
        const errors = [];

        // Convention 1: http_post(url, bodyString, headersObj)
        try {
            const res  = await http_post(url, formBody, headers);
            const body = res?.body ?? res;
            if (typeof body === "string" && body.length > 0) { log("http_post conv1 ok"); return body; }
        } catch (e) { errors.push("conv1: " + e.message); }

        // Convention 2: http_post(url, { body, headers })
        try {
            const res  = await http_post(url, { body: formBody, headers });
            const body = res?.body ?? res;
            if (typeof body === "string" && body.length > 0) { log("http_post conv2 ok"); return body; }
        } catch (e) { errors.push("conv2: " + e.message); }

        // Convention 3: http_post(url, formBody) — no explicit headers
        try {
            const res  = await http_post(url, formBody);
            const body = res?.body ?? res;
            if (typeof body === "string" && body.length > 0) { log("http_post conv3 ok"); return body; }
        } catch (e) { errors.push("conv3: " + e.message); }

        throw new Error("All http_post conventions failed: " + errors.join(" | "));
    }

    function executeLoaderRedirect(scriptText, currentUrl) {
        const previousWindow   = globalThis.window;
        const previousLocation = globalThis.location;
        const previousDocument = globalThis.document;
        const previousConsole  = globalThis.console;
        let redirected = null;

        const locationMock = {
            _href: currentUrl,
            get href() { return this._href; },
            set href(value) {
                redirected = resolveUrl(value, this._href) || value;
                this._href = redirected;
            }
        };

        try {
            globalThis.window = { location: locationMock };
            globalThis.location = locationMock;
            globalThis.document = {};
            globalThis.console = { log() {}, warn() {}, error() {} };
            eval(String(scriptText || ""));
            return redirected || locationMock.href || null;
        } catch (e) {
            err("Loader redirect eval failed:", e.message);
            return redirected || null;
        } finally {
            globalThis.window   = previousWindow;
            globalThis.location = previousLocation;
            globalThis.document = previousDocument;
            globalThis.console  = previousConsole;
        }
    }

    async function resolveLoaderRedirect(pageUrl) {
        const pageRes = await fetchWithRetry(pageUrl, {
            attempts: 2, ttl: HTTP_CACHE_TTL, allowBlocked: true
        });
        const pageBody = pageRes.body || "";
        const mainJs = pageBody.match(/<script[^>]+src=["']([^"']*main\.js[^"']*)["']/i);
        if (!mainJs) return { url: pageUrl, body: pageBody, redirected: false };

        const jsUrl = resolveUrl(mainJs[1], pageUrl);
        log("Loader JS:", jsUrl);
        const jsRes = await fetchWithRetry(jsUrl, {
            attempts: 2, ttl: HTTP_CACHE_TTL, allowBlocked: true
        });
        const redirectedUrl = executeLoaderRedirect(jsRes.body || "", pageUrl);
        if (!redirectedUrl || redirectedUrl === pageUrl) {
            return { url: pageUrl, body: pageBody, redirected: false };
        }

        log("Loader redirect:", pageUrl, "=>", redirectedUrl);
        const redirectedRes = await fetchWithRetry(redirectedUrl, {
            attempts: 2, ttl: HTTP_CACHE_TTL, allowBlocked: true
        });
        return { url: redirectedUrl, body: redirectedRes.body || "", redirected: true };
    }

    function extractPackedPlayerSources(body, pageUrl) {
        const packedScripts = [...String(body || "").matchAll(
            /<script[^>]*>\s*(eval\(function\(p,a,c,k,e,[\s\S]*?)<\/script>/gi
        )];
        if (packedScripts.length === 0) return [];

        const previousWindow       = globalThis.window;
        const previousDocument     = globalThis.document;
        const previousJwplayer     = globalThis.jwplayer;
        const previousDollar       = globalThis.$;
        const previousLocalStorage = globalThis.localStorage;
        const previousDOMParser    = globalThis.DOMParser;
        const previousFetch        = globalThis.fetch;
        const previousOpen         = globalThis.open;
        const previousSetTimeout   = globalThis.setTimeout;
        const previousSetInterval  = globalThis.setInterval;
        const previousConsole      = globalThis.console;
        const captured = [];

        const chain = {
            removeClass() { return this; },
            addClass() { return this; },
            toggleClass() { return this; },
            hasClass() { return false; },
            fadeIn() { return this; },
            fadeOut() { return this; },
            hide() { return this; },
            show() { return this; },
            html() { return this; },
            attr() { return this; },
            focus() { return this; },
            detach() { return this; },
            insertAfter() { return this; },
            append() { return this; },
            remove() { return this; },
            text() { return this; },
            css() { return this; },
            prop() { return this; },
            on() { return this; }
        };

        try {
            globalThis.console = { log() {}, warn() {}, error() {} };
            globalThis.window = globalThis;
            globalThis.document = {
                body: { appendChild() {}, removeChild() {} },
                documentElement: {},
                createElement() {
                    return {
                        style: {},
                        setAttribute() {},
                        appendChild() {},
                        removeChild() {},
                        parentNode: { removeChild() {} },
                        click() {},
                        focus() {},
                        innerHTML: "",
                        textContent: "",
                        onload: null,
                        onerror: null
                    };
                }
            };
            globalThis.localStorage = {
                getItem() { return null; },
                setItem() {},
                removeItem() {}
            };
            globalThis.DOMParser = function () {
                return { parseFromString() { return { documentElement: { textContent: "" } }; } };
            };
            globalThis.fetch = async () => ({ ok: false, status: 500, text: async () => "" });
            globalThis.open = () => ({ focus() {} });
            globalThis.setTimeout = () => 0;
            globalThis.setInterval = () => 0;

            const fakePlayer = {
                setup(config) {
                    if (config) captured.push(config);
                    return fakePlayer;
                },
                on() { return fakePlayer; },
                once() { return fakePlayer; },
                addButton() { return fakePlayer; },
                load(items) {
                    if (Array.isArray(items)) captured.push({ sources: items });
                    return fakePlayer;
                },
                play() { return fakePlayer; },
                stop() { return fakePlayer; },
                pause() { return fakePlayer; },
                seek() { return fakePlayer; },
                getPosition() { return 0; },
                getConfig() { return { playlist: [{ sources: captured[0]?.sources || [] }] }; },
                getPlaylistItem() { return { file: captured[0]?.sources?.[0]?.file || "" }; },
                getAudioTracks() { return []; },
                setCurrentAudioTrack() { return fakePlayer; }
            };

            globalThis.jwplayer = () => fakePlayer;

            const $ = function () { return Object.create(chain); };
            $.ajaxSetup = () => {};
            $.post = (_url, _data, cb) => { if (typeof cb === "function") cb(""); };
            $.get = (_url, cb) => { if (typeof cb === "function") cb(""); };
            $.cookie = () => {};
            globalThis.$ = $;

            for (const match of packedScripts) {
                try { eval(match[1]); } catch (_) {}
            }
        } finally {
            globalThis.window       = previousWindow;
            globalThis.document     = previousDocument;
            globalThis.jwplayer     = previousJwplayer;
            globalThis.$            = previousDollar;
            globalThis.localStorage = previousLocalStorage;
            globalThis.DOMParser    = previousDOMParser;
            globalThis.fetch        = previousFetch;
            globalThis.open         = previousOpen;
            globalThis.setTimeout   = previousSetTimeout;
            globalThis.setInterval  = previousSetInterval;
            globalThis.console      = previousConsole;
        }

        const urls = [];
        for (const cfg of captured) {
            for (const source of cfg?.sources || []) {
                const candidate = resolveUrl(source?.file || source?.src, pageUrl);
                if (candidate && !candidate.includes("|")) urls.push(candidate);
            }
        }
        return unique(urls);
    }

    async function extractStreamHg(embedUrl, referer) {
        const rewritten = rewriteHgUrl(embedUrl);
        const videoId   = extractHgId(rewritten);
        if (!videoId) { err("StreamHG: no video ID in", rewritten); return []; }

        // Attempt 1: resolve the host-side loader chain and parse the redirected player page.
        try {
            const { url: finalUrl, body, redirected } = await resolveLoaderRedirect(rewritten);
            log("StreamHG page snippet:", body.slice(0, 600));

            const mediaUrls = findMediaUrls(body, finalUrl);
            if (mediaUrls.length > 0) {
                log("StreamHG page scan →", mediaUrls.length, "URL(s)");
                return mediaUrls.map(u => new StreamResult({
                    url: u,
                    quality: qualityFromUrl(u) || 0,
                    source: redirected ? "StreamHG Redirect" : "StreamHG",
                    headers: { Referer: finalUrl || referer || rewritten }
                }));
            }

            // jwplayer/videojs sources array
            const srcArr = body.match(/sources\s*[=:]\s*\[\s*\{[^}]*?["']?file["']?\s*:\s*["']([^"']+)["']/i);
            if (srcArr) {
                log("StreamHG sources array match");
                return [new StreamResult({
                    url: srcArr[1],
                    quality: qualityFromUrl(srcArr[1]) || 0,
                    source: redirected ? "StreamHG Redirect" : "StreamHG",
                    headers: { Referer: finalUrl || referer || rewritten }
                })];
            }

            // Bare file/src key
            const fileKey = body.match(/["']?(?:file|src)["']?\s*:\s*["']([^"']+\.m3u8[^"']*)["']/i);
            if (fileKey) {
                log("StreamHG file key match");
                return [new StreamResult({
                    url: fileKey[1],
                    quality: qualityFromUrl(fileKey[1]) || 0,
                    source: redirected ? "StreamHG Redirect" : "StreamHG",
                    headers: { Referer: finalUrl || referer || rewritten }
                })];
            }

            const packedUrls = extractPackedPlayerSources(body, finalUrl);
            if (packedUrls.length > 0) {
                log("StreamHG packed player →", packedUrls.length, "URL(s)");
                return packedUrls.map(u => new StreamResult({
                    url: u,
                    quality: qualityFromUrl(u) || 0,
                    source: redirected ? "StreamHG Redirect" : "StreamHG",
                    headers: { Referer: finalUrl || referer || rewritten }
                }));
            }

            err("StreamHG: no media found. Body length:", body.length);
        } catch (e) { err("StreamHG resolve failed:", e.message); }

        // Attempt 2: legacy API path for older mirrors.
        try {
            const apiUrl   = buildHgApiUrl(embedUrl, videoId);
            const apiHost  = parseHost(embedUrl) || parseHost(rewritten) || "streamhg.com";
            const apiOrigin = `https://${apiHost}`;
            const normalizedReferer = referer || embedUrl || rewritten;
            const postBody = `r=${encodeURIComponent(normalizedReferer)}&d=${encodeURIComponent(apiHost)}`;
            const headers  = {
                "Content-Type": "application/x-www-form-urlencoded",
                "Referer": rewritten,
                "Origin": apiOrigin,
                "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            };
            const rawBody = await tryHttpPost(apiUrl, postBody, headers);
            log("StreamHG API raw:", String(rawBody).slice(0, 300));
            const data = JSON.parse(rawBody);
            if (data?.success && Array.isArray(data?.data) && data.data.length > 0) {
                return data.data
                    .filter(s => s?.file)
                    .map(s => new StreamResult({
                        url: s.file,
                        quality: parseInt(s.label) || qualityFromUrl(s.file) || 0,
                        source: "StreamHG API",
                        headers: { Referer: rewritten }
                    }));
            }
        } catch (e) { err("StreamHG legacy API failed:", e.message); }

        return [];
    }

    async function extractIframeStream(streamUrl, referer, label) {
        // Rewrite before host check so hgcloud.to/hglink.to are recognised
        const finalTarget = rewriteHgUrl(streamUrl);

        if (isHgFamily(finalTarget)) {
            return extractStreamHg(finalTarget, referer);
        }

        // Generic embed: follow redirects, scrape media URLs from HTML
        const { url: finalUrl, body } = await fetchFinal(finalTarget, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
        const mediaUrls = findMediaUrls(body, finalUrl);

        if (mediaUrls.length > 0) {
            return mediaUrls.map(url => new StreamResult({
                url,
                quality: qualityFromUrl(url) || qualityFromUrl(label),
                source:  label || parseHost(finalTarget) || "Tamilblasters",
                headers: { Referer: referer || finalTarget }
            }));
        }

        return [new StreamResult({
            url:     finalUrl,
            quality: qualityFromUrl(label),
            source:  label || parseHost(finalTarget) || "Tamilblasters",
            headers: { Referer: referer || finalTarget }
        })];
    }

    function dedupeStreams(streams) {
        const seen = new Set(), out = [];
        for (const s of streams || []) {
            const key = `${s?.url}|${s?.source}`;
            if (!s?.url || seen.has(key)) continue;
            seen.add(key);
            out.push(s);
        }
        return out.sort((a, b) => (b.quality || 0) - (a.quality || 0));
    }

    function parseJsonLikeInput(value) {
        const raw = String(value || "").trim();
        const candidates = [raw];
        if ((raw.startsWith("'") && raw.endsWith("'")) || (raw.startsWith("\"") && raw.endsWith("\"")))
            candidates.push(raw.slice(1, -1));
        candidates.push(raw.replace(/\\"/g, "\""));
        candidates.push(raw.replace(/\\"/g, "\"").replace(/^"+|"+$/g, ""));

        for (const c of unique(candidates)) {
            try { return JSON.parse(c); } catch (_) {}
        }

        const ol = raw.match(/^\{\s*url\s*:\s*([^,}]+)\s*,\s*title\s*:\s*(.+)\s*\}$/i)
                || raw.match(/^\{\s*title\s*:\s*([^,}]+)\s*,\s*url\s*:\s*(.+)\s*\}$/i);
        if (ol) {
            const firstIsUrl = /^\{\s*url\s*:/i.test(raw);
            const a = decodeEntities(ol[1]).trim(), b = decodeEntities(ol[2]).trim();
            return firstIsUrl ? { url: a, title: b } : { title: a, url: b };
        }
        throw new Error("Invalid serialized episode payload");
    }

    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const res     = await fetchFinal(mainUrl, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
            cb({ success: true, data: { Home: parseSearchResults(res.body, res.url || mainUrl) } });
        } catch (e) { cb({ success: false, errorCode: "HOME_ERROR", message: e.message }); }
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await fetchFinal(`${mainUrl}/?s=${encodeURIComponent(query)}`, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
            cb({ success: true, data: parseSearchResults(res.body, res.url || mainUrl) });
        } catch (e) { cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message }); }
    }

    async function load(url, cb) {
        try {
            const res  = await fetchFinal(url, 5, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
            const html = res.body || "";
            const ogDesc = parseOgDescription(html);
            if (!ogDesc) { cb({ success: false, errorCode: "LOAD_ERROR", message: "Missing og:description" }); return; }

            const heading  = decodeEntities(stripTags(html.match(/<h1[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i)?.[1] || ""));
            const title    = parseInfoTitle(ogDesc, heading) || heading || "Unknown";
            const year     = ogDesc.match(/\((\d{4})\)/)?.[1] ? parseInt(ogDesc.match(/\((\d{4})\)/)[1], 10) : undefined;
            const isSeries = inferIsSeries(title, heading, ogDesc, html);
            const posterUrl = parsePosterUrl(html, url);
            const plot     = extractDescription(html);

            if (isSeries) {
                const episodes = extractVideos(html, url).map((video, i) => {
                    const meta = parseEpisodeMeta(video.title, i + 1);
                    return new Episode({ name: meta.name, url: JSON.stringify(video), season: 1, episode: meta.episode });
                }).sort((a, b) => (a.episode || 0) - (b.episode || 0));

                cb({ success: true, data: new MultimediaItem({ title, url, posterUrl, type: "series", description: plot, year, episodes }) });
                return;
            }

            // Movies: store each iframe as its own Episode with a JSON blob URL so
            // loadStreams gets the embed URL directly (same path as series episodes).
            const videos = extractVideos(html, url);
            const movieEpisodes = videos.length > 0
                ? videos.map((v, i) => new Episode({ name: v.title || "Movie", url: JSON.stringify(v), season: 1, episode: i + 1 }))
                : [new Episode({ name: "Movie", url: JSON.stringify({ url, referer: url, title: "Movie" }), season: 1, episode: 1 })];

            cb({ success: true, data: new MultimediaItem({ title, url, posterUrl, type: "movie", description: plot, year, episodes: movieEpisodes }) });
        } catch (e) { cb({ success: false, errorCode: "LOAD_ERROR", message: e.message }); }
    }

    async function loadStreams(url, cb) {
        try {
            let streamResults = [];
            const mainUrl = await getMainUrl();

            // Path A: JSON blob {"url":"<embed>","title":"..."} from load()
            if (/^[{'"]/.test(String(url || "").trim())) {
                const loadData = parseJsonLikeInput(url);
                if (loadData?.url) {
                    log("loadStreams Path A: embed =", loadData.url);
                    streamResults = await extractIframeStream(loadData.url, loadData.referer || mainUrl, loadData.title);
                    cb({ success: true, data: dedupeStreams(streamResults) });
                    return;
                }
            }

            // Path B: bare post URL — fetch page, extract iframes
            log("loadStreams Path B: fetching", url);
            const res = await fetchWithRetry(url, { attempts: 2, ttl: HTTP_CACHE_TTL, allowBlocked: true });
            const iframeUrls = parseIframes(res.body || "", url);
            log("loadStreams Path B:", iframeUrls.length, "iframe(s)");
            if (iframeUrls.length === 0) {
                const mediaUrls = findMediaUrls(res.body || "", url);
                if (mediaUrls.length > 0) {
                    streamResults.push(...mediaUrls.map(mediaUrl => new StreamResult({
                        url: mediaUrl,
                        quality: qualityFromUrl(mediaUrl) || 0,
                        source: parseHost(mediaUrl) || "Tamilblasters",
                        headers: { Referer: url }
                    })));
                }
            }
            for (const iframeUrl of iframeUrls) {
                streamResults.push(...await extractIframeStream(iframeUrl, url, parseHost(iframeUrl) || "Tamilblasters"));
            }

            cb({ success: true, data: dedupeStreams(streamResults) });
        } catch (e) {
            err("loadStreams failed:", e.message || e);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    for (const ctx of [
        typeof globalThis !== "undefined" ? globalThis : null,
        typeof window    !== "undefined" ? window    : null,
        typeof global    !== "undefined" ? global    : null
    ]) {
        if (ctx) { ctx.getHome = getHome; ctx.search = search; ctx.load = load; ctx.loadStreams = loadStreams; }
    }
})();
