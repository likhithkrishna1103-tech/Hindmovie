(function () {
    const DEBUG = false;

    const MAIN_URL = "https://piratexplay.cc";
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

    async function getDocument(url, headers = {}) {
        const response = await http_get(url, { ...DEFAULT_HEADERS, ...headers });
        const html = String(response?.body || "");
        return {
            response,
            html,
            document: await parseHtml(html)
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

        for (const seasonUrl of seasonUrls) {
            const { document: seasonDoc } = await getDocument(seasonUrl, { Referer: MAIN_URL });
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

        let pageText = (await getDocument(source, referer ? { Referer: referer } : {})).html;

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

            pageText = (await getDocument(apiUrl, { Referer: apiUrl })).html;
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

        await getDocument(pageUrl, referer ? { Referer: referer } : {});
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

        return [new StreamResult({
            url: streamUrl,
            quality: 1080,
            source: hostOf(pageUrl) || "AWSStream",
            headers: {
                Referer: ""
            }
        })];
    }

    async function extractFilesimLike(url, referer) {
        const { html } = await getDocument(url, referer ? { Referer: referer } : {});
        const mediaUrls = collectMediaUrls(html, url);
        if (mediaUrls.length) {
            return mediaUrls.map((streamUrl) => new StreamResult({
                url: streamUrl,
                quality: qualityFromText(streamUrl),
                source: hostOf(url) || "Filesim",
                headers: {
                    Referer: referer || getOrigin(url)
                }
            }));
        }

        const packedUrl = html.match(/["'](https?:\/\/[^"']+\/d\/[^"']+)["']/i)?.[1];
        if (packedUrl) {
            return [new StreamResult({
                url: packedUrl,
                quality: 0,
                source: hostOf(url) || "Filesim",
                headers: {
                    Referer: referer || getOrigin(url)
                }
            })];
        }

        return [];
    }

    async function extractGenericMedia(url, referer, depth = 0) {
        if (depth > 3) return [];

        const { html, document } = await getDocument(url, referer ? { Referer: referer } : {});
        const mediaUrls = collectMediaUrls(html, url);
        if (mediaUrls.length) {
            return mediaUrls.map((streamUrl) => new StreamResult({
                url: streamUrl,
                quality: qualityFromText(streamUrl),
                source: hostOf(url) || "Generic",
                headers: {
                    Referer: referer || getOrigin(url)
                }
            }));
        }

        const nestedFrames = iframeUrls(document, url);
        let streams = [];
        for (const frameUrl of nestedFrames) {
            streams = streams.concat(await extractFromUrl(frameUrl, url, depth + 1));
        }
        return streams;
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

        return streams;
    }

    async function extractFromUrl(url, referer, depth = 0) {
        const host = hostOf(url);

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

        if (/(?:^|\.)myanimeworld\.in$/i.test(host)) {
            const { document } = await getDocument(url, referer ? { Referer: referer } : {});
            const nested = resolveUrl(attrOf(document.querySelector("iframe"), "src"), url);
            return nested ? extractFromUrl(nested, url, depth + 1) : [];
        }

        if (/(?:^|\.)dlx\.techinmind\.space$/i.test(host)
            || /(?:^|\.)gdmirrorbot\.nl$/i.test(host)
            || /(?:^|\.)streams\.iqsmartgames\.com$/i.test(host)
            || /(?:^|\.)pro\.iqsmartgames\.com$/i.test(host)) {
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
            for (const [name, path] of Object.entries(sections)) {
                const page1 = await parseListingPage(`${MAIN_URL}/${path}?page=1`);
                const page2 = await parseListingPage(`${MAIN_URL}/${path}?page=2`);
                data[name] = uniqueBy(page1.concat(page2), (item) => item?.url);
            }

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
            const frames = [...document.querySelectorAll("iframe")];
            let streams = [];

            for (const frame of frames) {
                let link = attrOf(frame, "src", "data-src");
                if (!link) continue;
                link = link.includes("url=") ? decodeURIComponent(link.split("url=").pop()) : link;
                const resolved = resolveUrl(link, url);
                if (!resolved) continue;
                streams = streams.concat(await extractFromUrl(resolved, MAIN_URL, 0));
            }

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
