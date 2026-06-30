(function() {
    function base64Decode(str) {
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var output = "";
        var bytes = [];
        for (var i = 0; i < str.length; i += 4) {
            var a = chars.indexOf(str[i]);
            var b = chars.indexOf(str[i + 1] || "=");
            var c = chars.indexOf(str[i + 2] || "=");
            var d = chars.indexOf(str[i + 3] || "=");
            bytes.push((a << 2) | (b >> 4));
            if (c !== -1 && str[i + 2] !== "=") bytes.push(((b & 15) << 4) | (c >> 2));
            if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
        }
        for (var j = 0; j < bytes.length; j++) output += String.fromCharCode(bytes[j]);
        return output;
    }

    const GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
    const GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

    const SessionTracker = {
        clientId: null,
        init() { this.clientId = this.generateUuid(); },
        generateUuid() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random() * 16 | 0;
                return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
        }
    };
    SessionTracker.init();

    const Analytics = {
        clientId: null,
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        queue: [],
        init() { this.clientId = SessionTracker.clientId; },
        logEvent(eventName, parameters) {
            console.log('[Analytics] Event: ' + eventName + ' | clientId: ' + this.clientId);
            if (!this.measurementId || !this.apiSecret) return;
            this.queue.push({ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) });
            this.flushQueue();
        },
        async flushQueue() {
            if (this.queue.length === 0) return;
            var events = this.queue.splice(0);
            try {
                await http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
            } catch (e) { console.log('[Analytics] Send skipped'); }
        }
    };
    Analytics.init();

    const DEBUG = false;
    function log(...a) { if (DEBUG) console.log("[HMZ]", ...a); }
    function warn(...a) { if (DEBUG) console.warn("[HMZ WARN]", ...a); }
    function err(...a) { console.error("[HMZ ERR]", ...a); }

    const DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    const DEFAULT_DOMAIN = "https://hindmoviez.icu";

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
    const siteDomains = new Set([getOrigin(DEFAULT_DOMAIN)]);

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

    function toBase64Url(text) {
        const input = String(text || "");
        const utf8 = [];
        for (let i = 0; i < input.length; i++) {
            const code = input.charCodeAt(i);
            if (code < 0x80) {
                utf8.push(code);
            } else if (code < 0x800) {
                utf8.push(0xc0 | (code >> 6), 0x80 | (code & 0x3f));
            } else {
                utf8.push(0xe0 | (code >> 12), 0x80 | ((code >> 6) & 0x3f), 0x80 | (code & 0x3f));
            }
        }
        const chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        let out = "";
        for (let i = 0; i < utf8.length; i += 3) {
            const a = utf8[i];
            const b = i + 1 < utf8.length ? utf8[i + 1] : 0;
            const c = i + 2 < utf8.length ? utf8[i + 2] : 0;
            const triplet = (a << 16) | (b << 8) | c;
            out += chars[(triplet >> 18) & 63];
            out += chars[(triplet >> 12) & 63];
            out += i + 1 < utf8.length ? chars[(triplet >> 6) & 63] : "=";
            out += i + 2 < utf8.length ? chars[triplet & 63] : "=";
        }
        return out.replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/g, "");
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
        if (!raw) return "";
        const match = raw.match(/S(\d+)[Ee](\d+)(?:-(\d+))?/i);
        if (!match) {
            return raw
                .replace(/\b(480p|720p|1080p|4K|HDRip|BluRay|WEBRip|WEB-DL|DVDRip|HEVC|x264|x265|AAC|DD5\.1|ESub)\b/gi, "")
                .replace(/\s{2,}/g, " ")
                .trim() || "Unknown";
        }
        const season = parseInt(match[1], 10);
        const epStart = parseInt(match[2], 10);
        const epEnd = match[3] ? parseInt(match[3], 10) : null;
        const showName = raw.substring(0, match.index).trim();
        const episodes = epEnd !== null ? `Episodes ${epStart}–${epEnd}` : `Episode ${epStart}`;
        return `${showName} Season ${season} | ${episodes}`;
    }

    const SECRET = "5e96085c56e0f54eda657790ac58d19b271479c504367fc9e6a6c33f1f824e6b";

    function hmacSha256(keyStr, dataStr) {
        function strToWords(str) {
            const words = [];
            for (let i = 0; i < str.length; i++) {
                words[i >> 2] |= (str.charCodeAt(i) & 0xff) << (24 - (i % 4) * 8);
            }
            return words;
        }
        function wordsToHex(words) {
            let hex = "";
            for (let i = 0; i < words.length; i++) {
                let h = (words[i] >>> 0).toString(16);
                while (h.length < 8) h = "0" + h;
                hex += h;
            }
            return hex;
        }
        function sha256Words(words, lenBits) {
            const K = [
                0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
                0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
                0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
                0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
                0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
                0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
                0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
                0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
            ];
            const H = [
                0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19
            ];
            const totalWords = Math.ceil((lenBits + 65) / 512) * 16;
            const w = new Array(totalWords).fill(0);
            for (let i = 0; i < words.length; i++) w[i] = words[i];
            w[lenBits >> 5] |= 0x80 << (24 - (lenBits % 32));
            w[totalWords - 1] = lenBits;
            for (let i = 0; i < totalWords; i += 16) {
                const chunk = w.slice(i, i + 16);
                const W = new Array(64);
                for (let j = 0; j < 16; j++) W[j] = chunk[j];
                for (let j = 16; j < 64; j++) {
                    const s0 = ((W[j - 15] >>> 7) | (W[j - 15] << 25)) ^ ((W[j - 15] >>> 18) | (W[j - 15] << 14)) ^ (W[j - 15] >>> 3);
                    const s1 = ((W[j - 2] >>> 17) | (W[j - 2] << 15)) ^ ((W[j - 2] >>> 19) | (W[j - 2] << 13)) ^ (W[j - 2] >>> 10);
                    W[j] = (W[j - 16] + s0 + W[j - 7] + s1) | 0;
                }
                let a = H[0], b = H[1], c = H[2], d = H[3], e = H[4], f = H[5], g = H[6], h = H[7];
                for (let j = 0; j < 64; j++) {
                    const S1 = ((e >>> 6) | (e << 26)) ^ ((e >>> 11) | (e << 21)) ^ ((e >>> 25) | (e << 7));
                    const ch = (e & f) ^ (~e & g);
                    const temp1 = (h + S1 + ch + K[j] + W[j]) | 0;
                    const S0 = ((a >>> 2) | (a << 30)) ^ ((a >>> 13) | (a << 19)) ^ ((a >>> 22) | (a << 10));
                    const maj = (a & b) ^ (a & c) ^ (b & c);
                    const temp2 = (S0 + maj) | 0;
                    h = g; g = f; f = e; e = (d + temp1) | 0; d = c; c = b; b = a; a = (temp1 + temp2) | 0;
                }
                H[0] = (H[0] + a) | 0; H[1] = (H[1] + b) | 0; H[2] = (H[2] + c) | 0; H[3] = (H[3] + d) | 0;
                H[4] = (H[4] + e) | 0; H[5] = (H[5] + f) | 0; H[6] = (H[6] + g) | 0; H[7] = (H[7] + h) | 0;
            }
            return H;
        }
        let keyWords = strToWords(keyStr);
        if (keyStr.length > 64) {
            const h = sha256Words(keyWords, keyStr.length * 8);
            keyWords = h.concat(new Array(8).fill(0));
        } else {
            while (keyWords.length < 16) keyWords.push(0);
        }
        const ipad = new Array(16);
        const opad = new Array(16);
        for (let i = 0; i < 16; i++) {
            ipad[i] = keyWords[i] ^ 0x36363636;
            opad[i] = keyWords[i] ^ 0x5c5c5c5c;
        }
        const dataWords = strToWords(dataStr);
        const ipadData = ipad.concat(dataWords);
        const innerHash = sha256Words(ipadData, 512 + dataStr.length * 8);
        const opadInnerHash = opad.concat(innerHash);
        const outerHash = sha256Words(opadInnerHash, 512 + 256);
        return wordsToHex(outerHash);
    }

    function parseCredits(jsonText) {
        if (!jsonText) return [];
        const root = parseJsonSafe(jsonText);
        if (!root || !Array.isArray(root.cast)) return [];
        return root.cast.map(c => {
            const name = c.name || c.original_name || "";
            const profile = c.profile_path ? `https://image.tmdb.org/t/p/original${c.profile_path}` : null;
            return {
                name,
                image: profile,
                role: c.character || null
            };
        }).filter(actor => actor.name);
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
        return /hshare\.|gdirect\.|gdshine\.|hcloud\.|gdtot\.|redirect\.php|file\.php/i.test(text);
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

    async function postText(url, body, headers = {}) {
        if (typeof http_post === "function") {
            let lastErr = null;
            for (const attempt of [
                () => http_post(url, headers, body),
                () => http_post(url, body, headers)
            ]) {
                try {
                    const res = await attempt();
                    return {
                        status: res && typeof res.status !== "undefined" ? res.status : 200,
                        body: res && typeof res.body !== "undefined" ? res.body : "",
                        headers: res && res.headers ? res.headers : {}
                    };
                } catch (e) {
                    lastErr = e;
                }
            }
            throw lastErr || new Error(`POST failed: ${url}`);
        }
        if (typeof fetch === "function") {
            const res = await fetch(url, { method: "POST", headers, body });
            return {
                status: res.status,
                body: await res.text(),
                headers: {}
            };
        }
        throw new Error("POST not supported");
    }

    async function postJson(url, body, headers = {}) {
        const payload = typeof body === "string" ? body : JSON.stringify(body || {});
        return postText(url, payload, {
            "content-type": "application/json",
            ...headers
        });
    }

    function parseJsonSafe(text) {
        try {
            return JSON.parse(text);
        } catch (_) {
            return null;
        }
    }

    async function signHshareUrl(url) {
        const match = String(url || "").match(/^(https?:\/\/[^/]+)\/\?id=([^&#]+)/i);
        if (!match) return url;
        const domain = match[1];
        const rawId = decodeURIComponent(match[2].replace(/\+/g, "%2B"));
        const t = Math.floor(Date.now() / 1000);
        const encoded = toBase64Url(rawId);
        const s = hmacSha256(SECRET, `${encoded}|${t}`).substring(0, 16);
        return `${domain}/r.php?d=${encodeURIComponent(encoded)}&t=${t}&s=${s}`;
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
            let domain = null;
            try {
                const res = await fetchWithRetry(DOMAINS_URL, { attempts: 2, ttl: DOMAIN_CACHE_TTL, force });
                const d = JSON.parse(res.body);
                domain = d.hindmoviez || d.hindmoviez_url || null;
            } catch (e) {
                err("domains.json:", e.message);
            }

            if (!domain) {
                domain = DEFAULT_DOMAIN;
            }

            cachedMainUrl = domain.replace(/\/$/, "");
            cachedMainUrlAt = Date.now();
            siteDomains.add(getOrigin(cachedMainUrl));
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
            const results = await pooledMap(sections, 6, async (section) => {
                const url = section.path ? `${mainUrl}/${section.path}` : mainUrl;
                const res = await siteRequest(url, { attempts: 2, ttl: HTTP_CACHE_TTL });
                return [section.name, parseArticles(res.body, mainUrl)];
            });

            for (const entry of results) {
                if (entry && entry[1]?.length) homeData[entry[0]] = entry[1];
            }

            Analytics.logEvent('hindmoviez_home', {});
            cb({ success: true, data: homeData });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await siteRequest(`${mainUrl}/?s=${encodeURIComponent(query)}`, { attempts: 2, ttl: HTTP_CACHE_TTL });
            Analytics.logEvent('hindmoviez_search', {});
            cb({ success: true, data: parseArticles(res.body, mainUrl) });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    async function buildSeriesEpisodes(html, mainUrl) {
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
            return new Episode({
                name: `Episode ${ep.episode}`,
                url: JSON.stringify(unique(ep.pageUrls)),
                season: ep.season,
                episode: ep.episode
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

    async function extractGdshine(gdUrl, specs, fileSize) {
        const id = String(gdUrl).replace(/[?#].*$/, "").split("/").filter(Boolean).pop();
        if (!id) return [];
        try {
            const fileRes = await fetchWithRetry(`https://gdshine.org/api/files/s/${id}`, {
                attempts: 2,
                ttl: HTTP_CACHE_TTL,
                allowBlocked: true
            });
            const fileData = parseJsonSafe(fileRes.body)?.data;
            if (fileData?.id) {
                const workerRes = await postJson(`https://gdshine.org/api/downloads/${fileData.id}/via-worker`, {});
                const copyUrl = parseJsonSafe(workerRes.body)?.data?.copyUrl;
                if (copyUrl && isGoodUrl(copyUrl)) {
                    return [{
                        url: copyUrl,
                        quality: qualityOf(fileData.name),
                        source: `[Gdshine] ${specs || specsLabel(fileData.name)}${fileSize ? `[${fileSize}]` : ""}`.trim(),
                        headers: {}
                    }];
                }
            }
        } catch (e) {
            err("extract gdshine failed:", e.message);
        }
        return [];
    }

    async function extractPageStreams(pageUrl) {
        const key = String(pageUrl);
        const now = Date.now();
        const cached = streamCache.get(key);
        if (cached && cached.expiresAt > now) return cached.value;

        const job = (async () => {
            pageUrl = await signHshareUrl(pageUrl);

            if (/gdshine\./i.test(pageUrl)) {
                return await extractGdshine(pageUrl);
            }

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
                        if (t.includes("gdshine")) return 0;
                        if (t.includes("gd shine")) return 0;
                        if (t.includes("gdirect")) return 1;
                        if (t.includes("hpage")) return 2;
                        if (t.includes("hcloud")) return 2;
                        if (t.includes("gdtot")) return 3;
                        return 4;
                    };
                    return score(a.text) - score(b.text);
                });

            const streams = [];
            const results = await pooledMap(preferredBtns, 4, async (btn) => {
                if (btn.href.includes("gdshine")) {
                    return await extractGdshine(btn.href, specs, fileSize);
                }
                try {
                    const { url: btnPageUrl, body: btnBody } = await fetchFinal(btn.href, 4, { ttl: HTTP_CACHE_TTL, allowBlocked: true });
                    const heading = stripTags(btnBody.match(/<h2[^>]*>([\s\S]*?)<\/h2>/i)?.[1] || "");
                    const quality = qualityOf(heading) || qualityOf(fileName) || qualityOf(btn.text);
                    const finalLinks = unique([
                        ...parseAnchorsByClass(btnBody, "button", btnPageUrl),
                        ...parseAnchorsContainingButtonClass(btnBody, "button", btnPageUrl)
                    ].map(link => link && isGoodUrl(link.href) ? JSON.stringify(link) : null))
                        .map(link => JSON.parse(link))
                        .filter(Boolean);

                    const btnStreams = [];
                    for (const link of finalLinks) {
                        if (link.href.includes("gdshine")) {
                            const gdshineStreams = await extractGdshine(link.href, specs, fileSize);
                            btnStreams.push(...gdshineStreams);
                        } else {
                            btnStreams.push({
                                url: link.href,
                                quality,
                                source: `[${link.text || "HCloud"}] ${specs}${fileSize ? `[${fileSize}]` : ""}`.trim(),
                                headers: { Referer: btnPageUrl }
                            });
                        }
                    }
                    return btnStreams;
                } catch (e) {
                    err("extract btn page failed:", e.message);
                    return [];
                }
            });

            for (const r of results) {
                if (r) streams.push(...r);
            }

            return streams;
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
            const heading = stripTags(html.match(/<h1[^>]*class="entry-title"[^>]*>([\s\S]*?)<\/h1>/i)?.[1] || "");
            const isSeries = /Season/i.test(heading);

            let imdbId = null;
            const imdbM = html.match(/href=["'][^"']*(?:imdb\.com)?\/title\/(tt\d+)[^"']*["']/i);
            if (imdbM) imdbId = imdbM[1];

            let tmdbId = null;
            let castList = [];
            let description = null;
            let background = null;
            let responseData = null;

            if (imdbId) {
                const [tmdbFindRes, cinemetaRes] = await Promise.allSettled([
                    fetchWithRetry(`https://api.themoviedb.org/3/find/${imdbId}?api_key=1865f43a0549ca50d341dd9ab8b29f49&external_source=imdb_id`, { attempts: 2, ttl: HTTP_CACHE_TTL }),
                    fetchWithRetry(`https://v3-cinemeta.strem.io/meta/${isSeries ? "series" : "movie"}/${imdbId}.json`, { attempts: 2, ttl: HTTP_CACHE_TTL })
                ]);

                if (tmdbFindRes.status === "fulfilled" && tmdbFindRes.value) {
                    const findObj = parseJsonSafe(tmdbFindRes.value.body);
                    if (findObj) {
                        const movieRes = findObj.movie_results?.[0];
                        const tvRes = findObj.tv_results?.[0];
                        tmdbId = movieRes?.id || tvRes?.id || null;
                    }
                }

                if (cinemetaRes.status === "fulfilled" && cinemetaRes.value) {
                    responseData = parseJsonSafe(cinemetaRes.value.body);
                    if (responseData?.meta) {
                        description = responseData.meta.description || null;
                        background = responseData.meta.background || null;
                    }
                }

                if (tmdbId) {
                    try {
                        const tmdbmetatype = isSeries ? "tv" : "movie";
                        const creditsRes = await fetchWithRetry(`https://api.themoviedb.org/3/${tmdbmetatype}/${tmdbId}/credits?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US`, { attempts: 2, ttl: HTTP_CACHE_TTL });
                        castList = parseCredits(creditsRes.body);
                    } catch (e) {
                        err("TMDB credits failed:", e.message);
                    }
                }
            }

            const metaDescription = html.match(/<meta[^>]+property="og:description"[^>]+content="([^"]+)"/i)?.[1]
                || html.match(/<meta[^>]+name="description"[^>]+content="([^"]+)"/i)?.[1];

            let descriptionsFallback = null;
            const storyMatch = html.match(/<h3[^>]*>.*?Storyline.*?<\/h3>[\s\S]*?<p[^>]*>([\s\S]*?)<\/p>/i);
            if (storyMatch) {
                descriptionsFallback = stripTags(storyMatch[1]);
            }
            const plot = description || descriptionsFallback || metaDescription || "";

            if (isSeries) {
                const episodeUrlMap = new Map();
                const h3Re = /<h3[^>]*>([\s\S]*?)<\/h3>/gi;
                let h3m;
                const seasons = [];
                while ((h3m = h3Re.exec(html)) !== null) {
                    const h3Text = stripTags(h3m[1]);
                    const seasonMatch = h3Text.match(/Season\s*(\d+)/i);
                    if (!seasonMatch) continue;
                    const seasonNumber = parseInt(seasonMatch[1], 10);

                    const indexAfterH3 = h3Re.lastIndex;
                    const subHtml = html.substring(indexAfterH3, indexAfterH3 + 500);
                    const aMatch = subHtml.match(/<a[^>]+href=["']([^"']+)["']/i);
                    if (!aMatch) continue;

                    const episodeListUrl = resolveUrl(aMatch[1], realUrl);
                    if (episodeListUrl) {
                        seasons.push({ seasonNumber, episodeListUrl });
                    }
                }

                await pooledMap(seasons, 4, async (season) => {
                    try {
                        const epListRes = await siteRequest(season.episodeListUrl, { attempts: 2, ttl: HTTP_CACHE_TTL });
                        const epListHtml = epListRes.body;

                        const epRe = /<h3[^>]*>\s*<a[^>]+href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
                        let epM;
                        const epList = [];
                        while ((epM = epRe.exec(epListHtml)) !== null) {
                            const href = resolveUrl(epM[1], season.episodeListUrl);
                            const epText = stripTags(epM[2]);
                            const epMatch = epText.match(/Episode\s*(\d+)/i)
                                || epText.match(/\bEp\.?\s*(\d+)/i)
                                || epText.match(/\bE(\d+)\b/i);
                            if (epMatch && href) {
                                epList.push({
                                    episodeNumber: parseInt(epMatch[1], 10),
                                    href
                                });
                            }
                        }

                        await pooledMap(epList, 6, async (ep) => {
                            const signedUrl = await signHshareUrl(ep.href);
                            if (signedUrl) {
                                const key = `${season.seasonNumber}_${ep.episodeNumber}`;
                                if (!episodeUrlMap.has(key)) {
                                    episodeUrlMap.set(key, []);
                                }
                                episodeUrlMap.get(key).push(signedUrl);
                            }
                        });
                    } catch (e) {
                        err("Failed to fetch episodes for season:", season.seasonNumber, e.message);
                    }
                });

                const episodes = [];
                for (const [key, urls] of episodeUrlMap.entries()) {
                    const [seasonNumber, episodeNumber] = key.split("_").map(Number);
                    const uniqueUrls = unique(urls);

                    let epName = `Episode ${episodeNumber}`;
                    let epPoster = null;
                    let epDesc = null;
                    let epReleased = null;

                    if (responseData?.meta?.videos) {
                        const metaEpisode = responseData.meta.videos.find(
                            v => v.season === seasonNumber && v.episode === episodeNumber
                        );
                        if (metaEpisode) {
                            epName = metaEpisode.name || metaEpisode.title || epName;
                            epPoster = metaEpisode.thumbnail || null;
                            epDesc = metaEpisode.overview || null;
                            epReleased = metaEpisode.released || null;
                        }
                    }

                    episodes.push(new Episode({
                        name: epName,
                        url: JSON.stringify(uniqueUrls),
                        season: seasonNumber,
                        episode: episodeNumber,
                        posterUrl: epPoster,
                        description: epDesc,
                        date: epReleased
                    }));
                }
                episodes.sort((a, b) => a.season !== b.season ? a.season - b.season : a.episode - b.episode);

                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: responseData?.meta?.name || title,
                        url: realUrl,
                        posterUrl: poster,
                        bannerUrl: background || poster,
                        logoUrl: responseData?.meta?.logo || undefined,
                        type: "series",
                        year: parseInt(releaseYear) || (responseData?.meta?.year ? parseInt(responseData.meta.year) : undefined),
                        score: parseFloat(imdbRating) || (responseData?.meta?.imdbRating ? parseFloat(responseData.meta.imdbRating) : undefined),
                        genres: docGenres.length ? docGenres : (responseData?.meta?.genres || []),
                        actors: castList,
                        description: plot,
                        episodes
                    })
                });
                return;
            }

            const maxbuttons = [];
            const mbRe = /<a[^>]+class=["'][^"']*maxbutton[^"']*["'][^>]*?href=["']([^"']+)["']/gi;
            let mbm;
            while ((mbm = mbRe.exec(html)) !== null) {
                maxbuttons.push(resolveUrl(mbm[1], realUrl));
            }

            const moviePageUrls = [];
            if (maxbuttons.length > 0) {
                const nestedResults = await pooledMap(unique(maxbuttons), 4, async (listUrl) => {
                    try {
                        const pageUrl = await rewriteToActiveDomain(listUrl);
                        const { body } = await siteRequest(pageUrl, { attempts: 2, ttl: HTTP_CACHE_TTL });
                        const content = body.match(/<div[^>]+class="[^"]*entry-content[^"]*"[^>]*>([\s\S]*?)<\/div>/i)?.[1] || body;
                        const links = [];
                        for (const link of allHrefs(content, pageUrl)) {
                            if (isGoodUrl(link.href) && /Get\s+Links/i.test(link.text)) {
                                links.push(link.href);
                            }
                        }

                        const signedLinks = [];
                        await pooledMap(links, 6, async (linkHref) => {
                            const signed = await signHshareUrl(linkHref);
                            if (signed) signedLinks.push(signed);
                        });

                        return signedLinks;
                    } catch (e) {
                        err("Failed to collect movie links from:", listUrl, e.message);
                        return [];
                    }
                });
                moviePageUrls.push(...unique(nestedResults.flat()));
            }

            if (moviePageUrls.length === 0) {
                const collected = await collectMovieLinks(html, mainUrl);
                const signed = await pooledMap(collected, 6, signHshareUrl);
                moviePageUrls.push(...unique(signed.filter(Boolean)));
            }

            Analytics.logEvent('hindmoviez_load', {});
            cb({
                success: true,
                data: new MultimediaItem({
                    title: responseData?.meta?.name || title,
                    url: realUrl,
                    posterUrl: poster,
                    bannerUrl: background || poster,
                    logoUrl: responseData?.meta?.logo || undefined,
                    type: "movie",
                    year: parseInt(releaseYear) || (responseData?.meta?.year ? parseInt(responseData.meta.year) : undefined),
                    score: parseFloat(imdbRating) || (responseData?.meta?.imdbRating ? parseFloat(responseData.meta.imdbRating) : undefined),
                    genres: docGenres.length ? docGenres : (responseData?.meta?.genres || []),
                    actors: castList,
                    description: plot,
                    episodes: [new Episode({
                        name: "Movie",
                        url: JSON.stringify(unique(moviePageUrls)),
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

            const extracted = await pooledMap(pageUrls, 6, extractPageStreams);
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
            Analytics.logEvent('hindmoviez_loadstreams', {});
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
