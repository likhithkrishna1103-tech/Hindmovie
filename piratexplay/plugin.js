(function () {
    const DEBUG = false;

    const MAIN_URL = normalizeUrl((manifest && manifest.baseUrl) || "https://piratexplay.cc");
    const USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36";
    const DEFAULT_HEADERS = {
        "User-Agent": USER_AGENT
    };

    function log(...args) {
        if (DEBUG) console.log("[Piratexplay]", ...args);
    }

    function normalizeUrl(url) {
        return String(url || "").replace(/\/+$/, "");
    }

    function getOrigin(url) {
        try {
            return new URL(String(url)).origin;
        } catch (_) {
            return "";
        }
    }

    function resolveUrl(href, base = MAIN_URL) {
        if (!href) return null;
        try {
            return new URL(String(href), String(base)).toString();
        } catch (_) {
            return null;
        }
    }

    function hostOf(url) {
        try {
            return new URL(String(url)).hostname.toLowerCase();
        } catch (_) {
            return "";
        }
    }

    function providerPriority(url) {
        const host = hostOf(url);
        if (/(^|\.)piratexplay\.cc$/i.test(host) || /(^|\.)as-cdn21\.top$/i.test(host) || /(^|\.)z\.awstream\.net$/i.test(host)) return 100;
        if (/(^|\.)gdmirrorbot\.nl$/i.test(host) || /(^|\.)pro\.iqsmartgames\.com$/i.test(host) || /(^|\.)streams\.iqsmartgames\.com$/i.test(host)) return 95;
        if (/(^|\.)animesalt\.ac$/i.test(host) || /(^|\.)short\.icu$/i.test(host)) return 90;
        if (/(^|\.)cloudy\.upns\.one$/i.test(host) || /(^|\.)pixdrive\.cfd$/i.test(host) || /(^|\.)ghbrisk\.com$/i.test(host)) return 80;
        if (/(^|\.)vidstreaming\.xyz$/i.test(host)) return 70;
        if (/(^|\.)rubystm\.com$/i.test(host)) return 60;
        return 10;
    }

    function shouldSkipFrame(url) {
        const host = hostOf(url);
        return /(^|\.)strmup\.to$/i.test(host)
            || /(^|\.)emturbovid\.com$/i.test(host)
            || /(^|\.)vidmoly\.net$/i.test(host);
    }

    function htmlDecode(text) {
        return String(text || "")
            .replace(/&#(\d+);/g, (_, dec) => String.fromCodePoint(parseInt(dec, 10)))
            .replace(/&#x([0-9a-f]+);/gi, (_, hex) => String.fromCodePoint(parseInt(hex, 16)))
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/&ndash;|&mdash;/gi, "-")
            .replace(/\s+/g, " ")
            .trim();
    }

    function textOf(node) {
        return htmlDecode(node?.textContent || "");
    }

    function attrOf(node, ...names) {
        for (const name of names) {
            const value = node?.getAttribute?.(name);
            if (value) return value.trim();
        }
        return "";
    }

    function imageAttr(node, base) {
        return resolveUrl(attrOf(node, "src", "data-src", "data-lazy-src"), base);
    }

    function sanitizeHtmlForDom(html) {
        return String(html || "")
            .replace(/<style\b[^>]*>[\s\S]*?<\/style>/gi, "")
            .replace(/<link\b[^>]+rel=["']stylesheet["'][^>]*>/gi, "");
    }

    async function getDocument(url, headers = {}, parseDom = true) {
        const response = await http_get(url, { ...DEFAULT_HEADERS, ...headers });
        const html = String(response?.body || "");
        return {
            response,
            html,
            document: parseDom ? await parseHtml(sanitizeHtmlForDom(html)) : null
        };
    }

    async function postText(url, body, headers = {}) {
        const response = await http_post(url, { ...DEFAULT_HEADERS, ...headers }, body);
        return String(response?.body || "");
    }

    function safeJsonParse(value) {
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return null;
        }
    }

    function base64ToUtf8(value) {
        try {
            return atob(String(value || ""));
        } catch (_) {
            return "";
        }
    }

    function qualityFromText(value) {
        const text = String(value || "").toLowerCase();
        if (/\b(2160p|4k)\b/.test(text)) return 2160;
        if (/\b1080p\b/.test(text)) return 1080;
        if (/\b720p\b/.test(text)) return 720;
        if (/\b480p\b/.test(text)) return 480;
        if (/\b360p\b/.test(text)) return 360;
        return 0;
    }

    function qualityLabel(quality) {
        const value = parseInt(quality, 10) || 0;
        return value > 0 ? `${value}p` : "";
    }

    function formEncode(data) {
        return Object.entries(data || {})
            .map(([key, value]) => `${encodeURIComponent(key)}=${encodeURIComponent(value == null ? "" : String(value))}`)
            .join("&");
    }

    function uniqueBy(items, keyFn) {
        const seen = new Set();
        const out = [];
        for (const item of items || []) {
            const key = keyFn(item);
            if (!key || seen.has(key)) continue;
            seen.add(key);
            out.push(item);
        }
        return out;
    }

    async function httpParallelGet(requests) {
        const items = Array.isArray(requests) ? requests.filter((item) => item && item.url) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                return await http_parallel(items.map((item) => ({
                    method: "GET",
                    url: item.url,
                    headers: item.headers || {}
                })));
            } catch (_) {}
        }
        return Promise.all(items.map((item) => http_get(item.url, item.headers || {}).catch(() => ({ body: "", finalUrl: item.url }))));
    }

    async function mapConcurrent(items, limit, worker) {
        const rows = Array.isArray(items) ? items : [];
        const count = Math.max(1, parseInt(limit, 10) || 1);
        const out = new Array(rows.length);
        let index = 0;
        async function run() {
            while (index < rows.length) {
                const current = index++;
                out[current] = await worker(rows[current], current);
            }
        }
        await Promise.all(Array.from({ length: Math.min(count, rows.length) }, () => run()));
        return out;
    }

    function collectMediaUrls(text, baseUrl) {
        const found = new Set();
        const body = String(text || "");

        for (const match of body.matchAll(/https?:\/\/[^"'\\\s<>]+(?:m3u8|mp4|mkv|master\.txt)[^"'\\\s<>]*/gi)) {
            found.add(match[0]);
        }

        for (const match of body.matchAll(/["']([^"']+(?:m3u8|mp4|mkv|master\.txt)[^"']*)["']/gi)) {
            const resolved = resolveUrl(match[1], baseUrl);
            if (resolved) found.add(resolved);
        }

        return [...found].filter((url) => {
            const value = String(url || "");
            return value
                && !/%3c|%3e/i.test(value)
                && !/[<>]/.test(value);
        });
    }

    function buildStreamResult(url, source, headers, quality, subtitles) {
        const stream = new StreamResult({
            url,
            source: source || "PirateXPlay",
            quality: quality || 0,
            headers: headers || {}
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    async function expandM3u8(url, source, headers, subtitles) {
        let text = "";
        try {
            text = String((await http_get(url, headers || {}))?.body || "");
        } catch (_) {
            text = "";
        }
        if (!/#EXTM3U/i.test(text) || !/#EXT-X-STREAM-INF/i.test(text)) {
            return [buildStreamResult(url, source, headers, qualityFromText(url), subtitles)];
        }
        const lines = text.split(/\r?\n/);
        const streams = [];
        for (let i = 0; i < lines.length; i++) {
            const line = lines[i];
            if (!/^#EXT-X-STREAM-INF/i.test(line)) continue;
            let next = "";
            for (let j = i + 1; j < lines.length; j++) {
                if (lines[j] && lines[j][0] !== "#") {
                    next = lines[j].trim();
                    break;
                }
            }
            if (!next) continue;
            const resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
            const quality = resMatch ? parseInt(resMatch[1], 10) : qualityFromText(next);
            streams.push(buildStreamResult(resolveUrl(next, url), source, headers, quality, subtitles));
        }
        return streams.length ? streams : [buildStreamResult(url, source, headers, qualityFromText(url), subtitles)];
    }

    function iframeUrls(document, baseUrl) {
        return [...document.querySelectorAll("iframe")]
            .map((node) => resolveUrl(attrOf(node, "src", "data-src"), baseUrl))
            .filter(Boolean);
    }

    function toSearchItem(li, baseUrl) {
        const title = textOf(li.querySelector("header h2"));
        const href = resolveUrl(attrOf(li.querySelector("a"), "href"), baseUrl);
        if (!title || !href) return null;
        const posterUrl = imageAttr(li.querySelector("img"), baseUrl);
        const itemType = href.includes("/movies/") || href.includes("/movie/")
            ? "movie"
            : "series";

        return new MultimediaItem({
            title,
            url: href,
            posterUrl,
            type: itemType
        });
    }

    async function parseListingPage(url) {
        const { document } = await getDocument(url);
        return [...document.querySelectorAll("#movies-a ul li")]
            .map((li) => toSearchItem(li, url))
            .filter(Boolean);
    }

    async function buildSeriesEpisodes(document, pageUrl) {
        const seasonHrefs = [...document.querySelectorAll("div.season-swiper a.season-btn")]
            .map((node) => resolveUrl(attrOf(node, "href"), pageUrl))
            .filter(Boolean);

        const seasonUrls = seasonHrefs.length ? seasonHrefs : [pageUrl];
        const episodes = [];

        const seasonPages = await httpParallelGet(seasonUrls.map((seasonUrl) => ({
            url: seasonUrl,
            headers: { ...DEFAULT_HEADERS, Referer: MAIN_URL }
        })));

        for (let seasonIndex = 0; seasonIndex < seasonUrls.length; seasonIndex++) {
            const seasonUrl = seasonUrls[seasonIndex];
            const html = String(seasonPages[seasonIndex]?.body || "");
            const seasonDoc = await parseHtml(html);
            const liNodes = [...seasonDoc.querySelectorAll("#episode_by_temp li")];

            for (const li of liNodes) {
                const headerText = textOf(li.querySelector("header.entry-header span"));
                const match = headerText.match(/(\d+)\s*x\s*(\d+)/i);
                const season = match ? parseInt(match[1], 10) : 1;
                const episode = match ? parseInt(match[2], 10) : episodes.length + 1;
                const href = resolveUrl(attrOf(li.querySelector("a"), "href"), seasonUrl);
                if (!href) continue;

                episodes.push(new Episode({
                    name: `Episode ${episode}`,
                    url: href,
                    season,
                    episode
                }));
            }
        }

        return episodes.sort((a, b) => {
            const seasonDiff = (a.season || 0) - (b.season || 0);
            return seasonDiff !== 0 ? seasonDiff : (a.episode || 0) - (b.episode || 0);
        });
    }

    async function extractGDMirrorbotSids(url, referer) {
        const source = String(url || "");
        if (!source.includes("key=")) {
            const sid = source.split("embed/").pop()?.split(/[?#]/)[0];
            return sid ? [sid] : [];
        }

        let pageText = (await getDocument(source, referer ? { Referer: referer } : {}, false)).html;

        const finalId = pageText.match(/FinalID\s*=\s*"([^"]+)"/)?.[1];
        const myKey = pageText.match(/myKey\s*=\s*"([^"]+)"/)?.[1];
        const idType = pageText.match(/idType\s*=\s*"([^"]+)"/)?.[1] || "imdbid";

        if (finalId && myKey) {
            let apiUrl;
            if (/\/tv\//i.test(source)) {
                const season = source.match(/\/tv\/\d+\/(\d+)\//)?.[1] || "1";
                const episode = source.match(/\/tv\/\d+\/\d+\/(\d+)/)?.[1] || "1";
                apiUrl = `${MAIN_URL}/myseriesapi?tmdbid=${encodeURIComponent(finalId)}&season=${encodeURIComponent(season)}&epname=${encodeURIComponent(episode)}&key=${encodeURIComponent(myKey)}`;
            } else {
                apiUrl = `${MAIN_URL}/mymovieapi?${encodeURIComponent(idType)}=${encodeURIComponent(finalId)}&key=${encodeURIComponent(myKey)}`;
            }

            pageText = (await getDocument(apiUrl, { Referer: apiUrl }, false)).html;
        }

        const json = safeJsonParse(pageText);
        const sids = (json?.data || [])
            .map((item) => item?.fileslug)
            .filter(Boolean);

        if (sids.length) return sids;

        const fallback = source.split("/").pop()?.split(/[?#]/)[0];
        return fallback ? [fallback] : [];
    }

    async function extractAwsStream(url, referer) {
        const pageUrl = String(url || "");
        const baseUrl = `${new URL(pageUrl).protocol}//${new URL(pageUrl).host}`;
        const hash = pageUrl.split("/").pop()?.split(/[?#]/)[0];
        if (!hash) return [];

        await getDocument(pageUrl, referer ? { Referer: referer } : {}, false);
        const apiUrl = `${baseUrl}/player/index.php?data=${encodeURIComponent(hash)}&do=getVideo`;
        const body = formEncode({
            hash,
            r: baseUrl
        });

        const responseText = await postText(apiUrl, body, {
            Referer: pageUrl,
            "X-Requested-With": "XMLHttpRequest",
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
        });

        const json = safeJsonParse(responseText);
        const streamUrl = json?.videoSource;
        if (!streamUrl) return [];

        return expandM3u8(streamUrl, hostOf(pageUrl) || "AWSStream", {
            Referer: ""
        }, []);
    }

    async function extractFilesimLike(url, referer) {
        const { html } = await getDocument(url, referer ? { Referer: referer } : {}, false);
        const mediaUrls = collectMediaUrls(html, url);
        if (mediaUrls.length) {
            const streams = [];
            for (const streamUrl of mediaUrls) {
                if (/\.m3u8(?:[?#].*)?$/i.test(streamUrl)) {
                    streams.push(...(await expandM3u8(streamUrl, hostOf(url) || "Filesim", {
                        Referer: referer || getOrigin(url)
                    }, [])));
                } else {
                    streams.push(buildStreamResult(streamUrl, hostOf(url) || "Filesim", {
                        Referer: referer || getOrigin(url)
                    }, qualityFromText(streamUrl), []));
                }
            }
            return streams;
        }

        const packedUrl = html.match(/["'](https?:\/\/[^"']+\/d\/[^"']+)["']/i)?.[1];
        if (packedUrl) {
            return [buildStreamResult(packedUrl, hostOf(url) || "Filesim", {
                Referer: referer || getOrigin(url)
            }, 0, [])];
        }

        return [];
    }

    async function extractGenericMedia(url, referer, depth = 0) {
        if (depth > 3) return [];

        const { html, document } = await getDocument(url, referer ? { Referer: referer } : {});
        const mediaUrls = collectMediaUrls(html, url);
        if (mediaUrls.length) {
            const streams = [];
            for (const streamUrl of mediaUrls) {
                if (/\.m3u8(?:[?#].*)?$/i.test(streamUrl)) {
                    streams.push(...(await expandM3u8(streamUrl, hostOf(url) || "Generic", {
                        Referer: referer || getOrigin(url)
                    }, [])));
                } else {
                    streams.push(buildStreamResult(streamUrl, hostOf(url) || "Generic", {
                        Referer: referer || getOrigin(url)
                    }, qualityFromText(streamUrl), []));
                }
            }
            return streams;
        }

        const nestedFrames = iframeUrls(document, url);
        const batches = await mapConcurrent(nestedFrames, 4, (frameUrl) => extractFromUrl(frameUrl, url, depth + 1));
        return batches.flat();
    }

    function isBuiltinExtractorHost(url) {
        const host = hostOf(url);
        return /(^|\.)hubcloud/i.test(host)
            || /(^|\.)dood/i.test(host)
            || /(^|\.)filemoon/i.test(host)
            || /(^|\.)mixdrop/i.test(host)
            || /(^|\.)streamtape/i.test(host)
            || /(^|\.)voe/i.test(host);
    }

    async function tryBuiltinExtractor(url, referer) {
        if (!url || typeof globalThis.loadExtractor !== "function" || !isBuiltinExtractorHost(url)) return [];
        const out = [];
        try {
            await globalThis.loadExtractor(url, (stream) => {
                if (!stream) return;
                if (!stream.headers && referer) stream.headers = { Referer: referer };
                out.push(stream);
            });
        } catch (_) {
            return [];
        }
        return dedupeStreams(out);
    }

    async function extractAnimesaltPlayer(url, referer, depth = 0) {
        let parsed;
        try {
            parsed = new URL(String(url));
        } catch (_) {
            return [];
        }
        const rawData = parsed.searchParams.get("data");
        if (!rawData) return [];
        const decoded = safeJsonParse(base64ToUtf8(rawData)) || [];
        const batches = await mapConcurrent(decoded, 4, async (item) => {
            const lang = htmlDecode(item?.language || item?.lang || "").trim();
            const link = resolveUrl(item?.link, parsed.origin);
            if (!link) return [];
            const streams = await extractFromUrl(link, referer || url, depth + 1);
            return streams.map((stream) => {
                const qualityTag = qualityLabel(stream?.quality);
                const baseSource = [lang, stream?.source].filter(Boolean).join(" ").trim() || "Animesalt";
                stream.source = qualityTag && !new RegExp(`\\b${qualityTag}\\b`, "i").test(baseSource)
                    ? `${baseSource} ${qualityTag}`.trim()
                    : baseSource;
                return stream;
            });
        });
        return batches.flat();
    }

    async function extractGDMirrorbotPage(url, referer) {
        const { html, response } = await getDocument(url, referer ? { Referer: referer } : {}, false);
        const fileUrl = html.match(/const\s+fileurl\s*=\s*"([^"]+)"/i)?.[1]?.replace(/\\\//g, "/");
        const fileName = htmlDecode((html.match(/const\s+filename\s*=\s*"([^"]+)"/i)?.[1] || "").replace(/\\\//g, "/"));
        const pageReferer = getOrigin(response?.finalUrl || url) || getOrigin(url);
        const baseQuality = qualityFromText(fileName || html);
        const streams = [];
        if (fileUrl) {
            const directSource = baseQuality > 0 ? `PirateXPlay Direct ${baseQuality}p` : "PirateXPlay Direct";
            streams.push(buildStreamResult(fileUrl, directSource, {
                Referer: pageReferer,
                "User-Agent": USER_AGENT
            }, baseQuality, []));
        }
        const visitMatches = [...html.matchAll(/<strong class="text-info">([\s\S]*?)<\/strong>[\s\S]*?<a href="([^"]+)"/gi)];
        const visitBatches = await mapConcurrent(visitMatches, 4, async (match) => {
            const label = htmlDecode(String(match[1] || "")).trim();
            const visitUrl = resolveUrl(match[2], response?.finalUrl || url);
            if (!visitUrl) return [];
            const extracted = await tryBuiltinExtractor(visitUrl, pageReferer);
            return extracted.map((stream) => {
                const source = label ? `PirateXPlay ${label}` : (stream.source || "PirateXPlay Mirror");
                if (!stream.source || /^unknown$/i.test(stream.source)) stream.source = source;
                return stream;
            });
        });
        return dedupeStreams(streams.concat(visitBatches.flat()));
    }

    async function extractGDMirrorbot(url, referer) {
        const pageOrigin = getOrigin(url);
        const sids = await extractGDMirrorbotSids(url, referer);
        if (!sids.length) return [];

        let streams = [];

        for (const sid of sids) {
            const helperBody = formEncode({ sid });
            const responseText = await postText(`${pageOrigin}/embedhelper.php`, helperBody, {
                Referer: pageOrigin,
                "X-Requested-With": "XMLHttpRequest",
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            });

            const json = safeJsonParse(responseText);
            const siteUrls = json?.siteUrls || {};
            const friendlyNames = json?.siteFriendlyNames || {};
            let mresult = json?.mresult || {};

            if (typeof mresult === "string") {
                mresult = safeJsonParse(base64ToUtf8(mresult)) || {};
            }

            for (const key of Object.keys(mresult || {})) {
                const base = String(siteUrls?.[key] || "").replace(/\/+$/, "");
                const path = String(mresult?.[key] || "").replace(/^\/+/, "");
                if (!base || !path) continue;

                const fullUrl = `${base}/${path}`;
                const friendlyName = String(friendlyNames?.[key] || key);
                const lowerFriendly = friendlyName.toLowerCase();

                if (/(streamhg|earnvids)/i.test(lowerFriendly)) {
                    streams = streams.concat(await extractGenericMedia(fullUrl, referer || pageOrigin));
                    continue;
                }

                if (/(rpmshare|upnshare|streamp2p)/i.test(lowerFriendly)) {
                    streams = streams.concat(await extractGenericMedia(fullUrl, referer || pageOrigin));
                    continue;
                }

                streams = streams.concat(await extractFromUrl(fullUrl, referer || pageOrigin, 1));
            }
        }

        if (!streams.length) {
            const fallbackPages = uniqueBy(sids.map((sid) => resolveUrl(`/file/${sid}`, pageOrigin)).filter(Boolean), (item) => item);
            const batches = await mapConcurrent(fallbackPages, 3, (pageUrl) => extractGDMirrorbotPage(pageUrl, referer || pageOrigin));
            streams = streams.concat(batches.flat());
        }

        return streams;
    }

    async function extractFromUrl(url, referer, depth = 0) {
        const host = hostOf(url);

        const builtin = await tryBuiltinExtractor(url, referer);
        if (builtin.length) return builtin;

        if (/piratexplay\.cc$/i.test(host)) {
            try {
                const parsed = new URL(String(url));
                const proxied = parsed.searchParams.get("url");
                if (proxied) {
                    const unwrapped = decodeURIComponent(proxied);
                    return extractFromUrl(unwrapped, url, depth + 1);
                }
            } catch (_) {}

            const { document } = await getDocument(url, referer ? { Referer: referer } : {});
            const nested = resolveUrl(attrOf(document.querySelector("#playerFrame"), "src"), url);
            if (nested) return extractFromUrl(nested, url, depth + 1);

            const frameUrls = iframeUrls(document, url);
            if (frameUrls.length) {
                let streams = [];
                for (const frameUrl of frameUrls) {
                    streams = streams.concat(await extractFromUrl(frameUrl, url, depth + 1));
                }
                if (streams.length) return streams;
            }

            return extractGenericMedia(url, referer, depth + 1);
        }

        if (/(?:^|\.)animesalt\.ac$/i.test(host) && /multi-lang-plyr\/player\.php/i.test(url)) {
            return extractAnimesaltPlayer(url, referer, depth + 1);
        }

        if (/(?:^|\.)short\.icu$/i.test(host)) {
            const response = await http_get(url, referer ? { ...DEFAULT_HEADERS, Referer: referer } : DEFAULT_HEADERS).catch(() => null);
            const finalUrl = response?.finalUrl && response.finalUrl !== url ? response.finalUrl : "";
            return finalUrl ? extractFromUrl(finalUrl, url, depth + 1) : [];
        }

        if (/(?:^|\.)myanimeworld\.in$/i.test(host)) {
            const { document } = await getDocument(url, referer ? { Referer: referer } : {});
            const nested = resolveUrl(attrOf(document.querySelector("iframe"), "src"), url);
            return nested ? extractFromUrl(nested, url, depth + 1) : [];
        }

        if (/(?:^|\.)dlx\.techinmind\.space$/i.test(host)
            || /(?:^|\.)gdmirrorbot\.nl$/i.test(host)
            || /(?:^|\.)streams\.iqsmartgames\.com$/i.test(host)
            || /(?:^|\.)pro\.iqsmartgames\.com$/i.test(host)) {
            if (/\/files\//i.test(url)) {
                return extractGDMirrorbotPage(url, referer);
            }
            return extractGDMirrorbot(url, referer);
        }

        if (/(?:^|\.)z\.awstream\.net$/i.test(host)
            || /(?:^|\.)as-cdn21\.top$/i.test(host)) {
            return extractAwsStream(url, referer);
        }

        if (/(?:^|\.)pixdrive\.cfd$/i.test(host)
            || /(?:^|\.)ghbrisk\.com$/i.test(host)
            || /(?:^|\.)cloudy\.upns\.one$/i.test(host)) {
            return extractFilesimLike(url, referer);
        }

        return extractGenericMedia(url, referer, depth);
    }

    function dedupeStreams(streams) {
        return uniqueBy(streams, (item) => `${item?.url}|${item?.source}`)
            .sort((a, b) => (b?.quality || 0) - (a?.quality || 0));
    }

    async function getHome(cb) {
        try {
            const sections = {
                Popular: "category/popular",
                "Top Airing": "category/top-airing",
                OnGoing: "category/ongoing",
                Series: "category/series",
                Movies: "category/movies",
                Anime: "category/anime",
                Cartoon: "category/cartoon"
            };

            const data = {};
            const jobs = Object.entries(sections).map(async ([name, path]) => {
                const [page1, page2] = await Promise.all([
                    parseListingPage(`${MAIN_URL}/${path}?page=1`).catch(() => []),
                    parseListingPage(`${MAIN_URL}/${path}?page=2`).catch(() => [])
                ]);
                data[name] = uniqueBy(page1.concat(page2), (item) => item?.url);
            });
            await Promise.all(jobs);

            cb({ success: true, data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: error.message });
        }
    }

    async function search(query, cb) {
        try {
            const items = await parseListingPage(`${MAIN_URL}/?s=${encodeURIComponent(query)}&page=1`);
            cb({ success: true, data: items });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: error.message });
        }
    }

    async function load(url, cb) {
        try {
            const { document } = await getDocument(url, { Referer: MAIN_URL });
            const title = textOf(document.querySelector("div.dfxb h1.entry-title"))
                || htmlDecode(attrOf(document.querySelector('meta[property="og:title"]'), "content"))
                || "Unknown";
            const posterUrl = resolveUrl(attrOf(document.querySelector("div.dfxb img"), "src", "data-src"), url);
            const backgroundPosterUrl = resolveUrl(attrOf(document.querySelector("div.bghd img"), "src", "data-src"), url);
            const year = parseInt(textOf(document.querySelector("span.year span")), 10) || undefined;
            const description = textOf(document.querySelector("div.description p"));
            const tags = [...document.querySelectorAll("header.entry-header ul li p a")]
                .map(textOf)
                .filter(Boolean);
            const tvType = String(url || "").includes("/movies/") || String(url || "").includes("/movie/")
                ? "movie"
                : "series";

            if (tvType === "series") {
                const episodes = await buildSeriesEpisodes(document, url);
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title,
                        url,
                        posterUrl,
                        backgroundPosterUrl,
                        description,
                        year,
                        genres: tags,
                        type: "series",
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
                    backgroundPosterUrl,
                    description,
                    year,
                    genres: tags,
                    type: "movie",
                    episodes: [new Episode({
                        name: "Movie",
                        url,
                        season: 1,
                        episode: 1
                    })]
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: error.message });
        }
    }

    async function loadStreams(url, cb) {
        try {
            const { document } = await getDocument(url, { Referer: MAIN_URL });
            const frames = [...document.querySelectorAll("iframe")]
                .map((frame) => {
                    let link = attrOf(frame, "src", "data-src");
                    if (!link) return null;
                    link = link.includes("url=") ? decodeURIComponent(link.split("url=").pop()) : link;
                    return resolveUrl(link, url);
                })
                .filter(Boolean)
                .filter((frameUrl) => !shouldSkipFrame(frameUrl))
                .sort((a, b) => providerPriority(b) - providerPriority(a))
                .slice(0, 8);
            const batches = await mapConcurrent(frames, 4, async (frame) => {
                return extractFromUrl(frame, MAIN_URL, 0);
            });
            const streams = batches.flat();

            cb({
                success: true,
                data: dedupeStreams(streams)
            });
        } catch (error) {
            log("loadStreams failed", error);
            cb({ success: false, errorCode: "STREAM_ERROR", message: error.message });
        }
    }

    for (const ctx of [
        typeof globalThis !== "undefined" ? globalThis : null,
        typeof window !== "undefined" ? window : null,
        typeof global !== "undefined" ? global : null
    ]) {
        if (!ctx) continue;
        ctx.getHome = getHome;
        ctx.search = search;
        ctx.load = load;
        ctx.loadStreams = loadStreams;
    }
})();
