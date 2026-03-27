(function () {
    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // manifest is injected at runtime

    // --- Constants ---
    const DOMAINS_URL =
        "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    const CINEMETA_URL = "https://v3-cinemeta.strem.io/meta";
    const TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";

    /**
     * Domains/patterns that are never valid stream sources.
     * Covers social apps, URL shorteners, ad-redirect networks, and analytics.
     */
    const BLOCKED_DOMAINS = [
        "telegram", "whatsapp", "facebook.com", "twitter.com", "x.com",
        "instagram.com", "youtube.com", "bit.ly", "tinyurl.com", "adf.ly",
        "linkvertise", "shorte.st", "ouo.io", "bc.vc", "sh.st", "exe.io",
        "za.gl", "fc.lc", "shrinke.me", "clk.sh", "gplinks.in", "earnl.ink",
        "google.com/url", "doubleclick.net", "googletagmanager.com"
    ];

    // --- Domain caching ---
    let cachedMainUrl = null;

    async function getMainUrl() {
        if (cachedMainUrl) return cachedMainUrl;
        try {
            const res = await http_get(DOMAINS_URL);
            const data = JSON.parse(res.body);
            cachedMainUrl = data.hindmoviez || "https://hindmoviez.cafe";
        } catch (e) {
            cachedMainUrl = "https://hindmoviez.cafe";
        }
        return cachedMainUrl;
    }

    // --- Helpers ---

    function cleanTitle(raw) {
        if (!raw) return "Unknown";
        return raw
            .replace(/\b(480p|720p|1080p|4K|HDRip|BluRay|WEBRip|WEB-DL|DVDRip|HEVC|x264|x265|AAC|DD5\.1|ESub)\b/gi, "")
            .replace(/\s{2,}/g, " ")
            .trim();
    }

    function qualityFromString(str) {
        if (!str) return 0;
        const s = str.toUpperCase();
        if (s.includes("4K") || s.includes("2160")) return 2160;
        if (s.includes("1080")) return 1080;
        if (s.includes("720")) return 720;
        if (s.includes("480")) return 480;
        if (s.includes("360")) return 360;
        return 0;
    }

    // Used only for sort order, NOT for labels
    function getQualityAdvanced(str) {
        if (!str) return 0;
        const s = str.toLowerCase();
        if (/4k|2160/.test(s)) return 2160;
        if (/1080/.test(s))    return 1080;
        if (/720/.test(s))     return 720;
        if (/480/.test(s))     return 480;
        if (/360/.test(s))     return 360;
        if (/\bhd\b/.test(s))  return 720;
        if (/\bcam\b|camrip|telesync|\bts\b/.test(s)) return 240;
        return 0;
    }

    function isLowQualitySource(str) {
        if (!str) return false;
        return /\bcam\b|camrip|telesync|\bts\b|hdtc|hdcam/.test(str.toLowerCase());
    }

    // FIX: also allow protocol-relative URLs (//cdn.example.com/...) which are valid streams
    function isBlockedUrl(url) {
        if (!url) return true;
        if (!url.startsWith("http") && !url.startsWith("//")) return true;
        const lower = url.toLowerCase();
        return BLOCKED_DOMAINS.some(d => lower.includes(d));
    }

    /**
     * FIX: Decode base64-encoded filename from common URL param names.
     * Previously only checked `id=`; now also checks `file=`, `f=`, `name=`.
     */
    function decodeBase64Id(url) {
        try {
            const paramNames = ["id", "file", "f", "name"];
            for (const param of paramNames) {
                const match = url.match(new RegExp("[?&]" + param + "=([^&]+)"));
                if (!match) continue;
                try {
                    const decoded = atob(match[1]);
                    if (decoded && decoded.length > 4) return decoded;
                } catch (_) {
                    // Not valid base64 - try next param
                }
            }
            return "";
        } catch {
            return "";
        }
    }

    /**
     * Extract a clean filename from URL path or anchor text.
     * Returns something like "Movie.Name.2023.1080p.WEBRip.x265.mkv"
     */
    function extractFilename(url, anchorText) {
        // 1. Try URL path segment
        try {
            // Normalise protocol-relative URLs for parsing
            const fullUrl = url.startsWith("//") ? "https:" + url : url;
            const pathname = new URL(fullUrl).pathname;
            const seg = pathname.split("/").filter(Boolean).pop() || "";
            const decoded = decodeURIComponent(seg);
            if (/\.(mkv|mp4|avi|mov|ts|m2ts|webm)$/i.test(decoded)) return decoded;
            if (/\b(480p|720p|1080p|2160p|4k)\b/i.test(decoded))    return decoded;
        } catch (_) {}

        // 2. Anchor text
        if (anchorText && anchorText.trim()) {
            const t = anchorText.trim();
            if (/\.(mkv|mp4|avi|mov|ts|m2ts|webm)$/i.test(t)) return t;
            if (/\b(480p|720p|1080p|2160p|4k)\b/i.test(t))    return t;
        }

        // 3. Decoded base64 id/file param - FIX: now checks multiple param names
        const decoded = decodeBase64Id(url);
        if (
            decoded &&
            decoded.length > 4 &&
            /(\.(mkv|mp4|avi|mov|ts|m2ts|webm))$/i.test(decoded)
        ) {
            return decoded;
        }

        return null;
    }

    /**
     * Strip the movie/series title from a filename so only spec tokens remain.
     * "Interstellar.2014.1080p.BluRay.x265.mkv" -> "2014.1080p.BluRay.x265.mkv"
     */
    function stripMovieTitle(filename, movieTitle) {
        if (!filename) return filename;

        if (movieTitle && movieTitle !== "Unknown") {
            const escaped = movieTitle
                .trim()
                .replace(/[.*+?^${}()|[\]\\]/g, "\\$&")
                .replace(/\s+/g, "[._ -]+");
            const titleRe = new RegExp("^" + escaped + "[._ -]*", "i");
            const stripped = filename.replace(titleRe, "");
            if (stripped && stripped !== filename && stripped.length > 3) {
                return stripped.trim().replace(/^[._ -]+/, "");
            }
        }

        // Fallback: cut at first year or spec token
        const specStartRe =
            /\b(19\d{2}|20\d{2}|480p|720p|1080p|2160p|4k|bluray|bdrip|webrip|web-dl|webdl|hdrip|dvdrip|hevc|x264|x265|avc|aac|dd5|dts|esub|msub)\b/i;
        const match = filename.match(specStartRe);
        if (match && match.index > 0) {
            return filename.slice(match.index).trim().replace(/^[._ -]+/, "");
        }

        return filename;
    }

    function parseCredits(creditsJson) {
        if (!creditsJson) return [];
        try {
            const data = JSON.parse(creditsJson);
            return (data.cast || []).slice(0, 20).map(c =>
                new Actor({
                    name: c.name,
                    role: c.character,
                    image: c.profile_path
                        ? "https://image.tmdb.org/t/p/w185" + c.profile_path
                        : undefined
                })
            );
        } catch (e) {
            return [];
        }
    }

    // FIX: also decode &lt; and &gt; HTML entities which can appear in descriptions
    function stripTags(str) {
        if (!str) return "";
        return str
            .replace(/<[^>]*>/g, "")
            .replace(/&amp;/g, "&")
            .replace(/&nbsp;/g, " ")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&#\d+;/g, "")
            .trim();
    }

    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.startsWith("http")) return href;
        // FIX: handle protocol-relative URLs
        if (href.startsWith("//")) return "https:" + href;
        if (href.startsWith("/")) return base.replace(/\/$/, "") + href;
        return base.replace(/\/$/, "") + "/" + href;
    }

    async function tmdbIdFromImdb(imdbId) {
        try {
            const res = await http_get(
                "https://api.themoviedb.org/3/find/" + imdbId +
                "?api_key=" + TMDB_API_KEY + "&external_source=imdb_id"
            );
            const data = JSON.parse(res.body);
            return data.movie_results?.[0]?.id || data.tv_results?.[0]?.id || null;
        } catch (e) {
            return null;
        }
    }

    // --- Core Functions ---

    /**
     * getHome - all section fetches run IN PARALLEL for speed.
     */
    async function getHome(cb) {
        try {
            const mainUrl = await getMainUrl();
            const sections = [
                { name: "Home",           path: "" },
                { name: "Movies",         path: "movies" },
                { name: "Web Series",     path: "web-series" },
                { name: "Korean Dramas",  path: "dramas/korean-drama" },
                { name: "Chinese Dramas", path: "dramas/chinese-drama" },
                { name: "Anime",          path: "anime" }
            ];

            const settled = await Promise.allSettled(
                sections.map(async section => {
                    const url = section.path ? mainUrl + "/" + section.path : mainUrl;
                    const res = await http_get(url);
                    return { name: section.name, items: parseArticles(res.body, mainUrl) };
                })
            );

            const homeData = {};
            for (const result of settled) {
                if (result.status === "fulfilled" && result.value.items.length > 0) {
                    homeData[result.value.name] = result.value.items;
                }
            }
            cb({ success: true, data: homeData });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    function parseArticles(html, mainUrl) {
        const items = [];
        const articleRe = /<article[^]*?<\/article>/gi;
        let articleMatch;
        while ((articleMatch = articleRe.exec(html)) !== null) {
            const block = articleMatch[0];
            const titleMatch = block.match(
                /<h2[^>]*class="entry-title"[^>]*>[^]*?<a[^>]*>([^]*?)<\/a>/i
            );
            const rawTitle = titleMatch
                ? titleMatch[1].replace(/<[^>]*>/g, "").trim()
                : null;
            if (!rawTitle) continue;
            const title = cleanTitle(rawTitle);
            const hrefMatch = block.match(/<a[^>]+href="([^"]+)"/i);
            const href = hrefMatch ? resolveUrl(hrefMatch[1], mainUrl) : null;
            if (!href) continue;
            const posterMatch =
                block.match(/class="[^"]*entry-header[^"]*"[^]*?<img[^>]+data-src="([^"]+)"/i) ||
                block.match(/class="[^"]*entry-header[^"]*"[^]*?<img[^>]+src="([^"]+)"/i) ||
                block.match(/<img[^>]+data-src="([^"]+)"/i) ||
                block.match(/<img[^>]+src="([^"]+)"/i);
            const posterUrl = posterMatch ? posterMatch[1] : null;
            const type = /Season/i.test(rawTitle) ? "series" : "movie";
            items.push(new MultimediaItem({ title, url: href, posterUrl, type }));
        }
        return items;
    }

    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await http_get(mainUrl + "/?s=" + encodeURIComponent(query));
            const items = parseArticles(res.body, mainUrl);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    /**
     * load - TMDB + Cinemeta fetches run IN PARALLEL.
     * The resolved movie title is appended as the last element of the hrefs
     * array so loadStreams can strip it from filenames without an extra fetch.
     */
    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await http_get(url);
            const html = res.body;

            let name        = null;
            let imdbRating  = null;
            let imdbId      = null;
            let releaseYear = null;
            let docGenres   = [];

            const liRe = /<li>([^]*?)<\/li>/gi;
            let liMatch;
            while ((liMatch = liRe.exec(html)) !== null) {
                const liHtml      = liMatch[1];
                const strongMatch = liHtml.match(/<strong>([^]*?)<\/strong>/i);
                if (!strongMatch) continue;
                const strongText = stripTags(strongMatch[1]).trim();
                const key        = strongText.split(":")[0].trim();
                const inlineVal  = (strongText.split(":")[1] || "").trim();
                const tailText   = stripTags(liHtml.replace(strongMatch[0], "")).trim();
                const value      = tailText || inlineVal;

                if      (key === "Name")         { name       = value || null; }
                else if (key === "IMDB Rating")  {
                    imdbRating = inlineVal.split("/")[0].trim() || null;
                    const idMatch = liHtml.match(/href="[^"]*\/title\/(tt\d+)\//i);
                    if (idMatch) imdbId = idMatch[1];
                }
                else if (key === "Release Year") { releaseYear = value || null; }
                else if (key === "Genre")        {
                    docGenres = value.split(",").map(s => s.trim()).filter(Boolean);
                }
            }

            const title = name || "Unknown";

            const posterMatch = html.match(
                /<meta[^>]+property="og:image"[^>]+content="([^"]+)"/i
            );
            const poster = posterMatch ? posterMatch[1] : null;

            const storyMatch = html.match(
                /<h3[^>]*>[^<]*Storyline[^<]*<\/h3>\s*<p[^>]*>([^]*?)<\/p>/i
            );
            // FIX: consistent variable name
            const description = storyMatch ? stripTags(storyMatch[1]).trim() : null;

            const h1Match = html.match(
                /<h1[^>]*class="entry-title"[^>]*>([^]*?)<\/h1>/i
            );
            const h1Text   = h1Match ? stripTags(h1Match[1]) : "";
            const isSeries = /Season/i.test(h1Text);

            // PARALLEL: TMDB + Cinemeta
            const [tmdbResult, cineResult] = await Promise.allSettled([
                imdbId ? tmdbIdFromImdb(imdbId) : Promise.resolve(null),
                imdbId
                    ? http_get(CINEMETA_URL + "/" + (isSeries ? "series" : "movie") + "/" + imdbId + ".json")
                    : Promise.resolve(null)
            ]);

            const tmdbId = tmdbResult.status === "fulfilled" ? tmdbResult.value : null;

            let responseData = null;
            if (cineResult.status === "fulfilled" && cineResult.value?.body?.trim().startsWith("{")) {
                try { responseData = JSON.parse(cineResult.value.body); } catch (_) {}
            }

            let castList = [];
            if (tmdbId) {
                try {
                    const creditsRes = await http_get(
                        "https://api.themoviedb.org/3/" + (isSeries ? "tv" : "movie") + "/" + tmdbId + "/credits" +
                        "?api_key=" + TMDB_API_KEY + "&language=en-US"
                    );
                    castList = parseCredits(creditsRes.body);
                } catch (_) {}
            }

            let finalDescription = description;
            let background       = poster;
            if (responseData?.meta) {
                finalDescription = responseData.meta.description || description;
                background       = responseData.meta.background  || poster;
            }

            const resolvedTitle = responseData?.meta?.name || title;

            if (isSeries) {
                const episodes = await buildSeriesEpisodes(html, responseData, mainUrl, resolvedTitle);
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: resolvedTitle, url,
                        posterUrl: poster, bannerUrl: background,
                        logoUrl: responseData?.meta?.logo || null,
                        type: "series", description: finalDescription,
                        year:   parseInt(releaseYear || responseData?.meta?.year) || undefined,
                        score:  parseFloat(imdbRating || responseData?.meta?.imdbRating) || undefined,
                        genres: docGenres, cast: castList, episodes
                    })
                });
                return;
            }

            const hrefs = await collectMovieLinks(html, mainUrl);
            // Append movie title as last element so loadStreams can strip it from filenames
            const episodeUrl = JSON.stringify([...hrefs, resolvedTitle]);

            cb({
                success: true,
                data: new MultimediaItem({
                    title: resolvedTitle, url,
                    posterUrl: poster, bannerUrl: background,
                    logoUrl: responseData?.meta?.logo || null,
                    type: "movie", description: finalDescription,
                    year:   parseInt(releaseYear || responseData?.meta?.year) || undefined,
                    score:  parseFloat(imdbRating || responseData?.meta?.imdbRating) || undefined,
                    genres: docGenres, cast: castList,
                    episodes: [
                        new Episode({ name: "Movie", url: episodeUrl, season: 1, episode: 1 })
                    ]
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    /**
     * buildSeriesEpisodes - season list pages fetched IN PARALLEL.
     * Series title appended to each episode URL array for filename stripping.
     */
    async function buildSeriesEpisodes(html, responseData, mainUrl, seriesTitle) {
        const seasonEntries = [];
        const seasonRe =
            /<h3[^>]*>[^]*?Season\s*(\d+)[^]*?<\/h3>\s*<p[^>]*>[^]*?<a[^>]+href="([^"]+)"/gi;
        let seasonMatch;
        while ((seasonMatch = seasonRe.exec(html)) !== null) {
            const seasonNumber   = parseInt(seasonMatch[1]);
            const episodeListUrl = seasonMatch[2];
            if (!seasonNumber || !episodeListUrl) continue;
            seasonEntries.push({ seasonNumber, episodeListUrl });
        }

        // PARALLEL: all season pages at once
        const seasonResults = await Promise.allSettled(
            seasonEntries.map(async ({ seasonNumber, episodeListUrl }) => {
                const epListRes = await http_get(episodeListUrl);
                const eps = [];
                const epRe = /<h3[^>]*>\s*<a[^>]+href="([^"]+)"[^>]*>([^]*?)<\/a>/gi;
                let epMatch;
                while ((epMatch = epRe.exec(epListRes.body)) !== null) {
                    const epUrl      = epMatch[1];
                    const epText     = stripTags(epMatch[2]);
                    const epNumMatch = epText.match(/Episode\s*(\d+)/i);
                    if (!epNumMatch) continue;
                    eps.push({ seasonNumber, episodeNumber: parseInt(epNumMatch[1]), epUrl });
                }
                return eps;
            })
        );

        const episodeUrlMap = {};
        for (const result of seasonResults) {
            if (result.status !== "fulfilled") continue;
            for (const { seasonNumber, episodeNumber, epUrl } of result.value) {
                const key = seasonNumber + "_" + episodeNumber;
                if (!episodeUrlMap[key]) {
                    episodeUrlMap[key] = { seasonNumber, episodeNumber, urls: [] };
                }
                episodeUrlMap[key].urls.push(epUrl);
            }
        }

        return Object.values(episodeUrlMap)
            .map(({ seasonNumber, episodeNumber, urls }) => {
                const metaEp = responseData?.meta?.videos?.find(
                    v => v.season === seasonNumber && v.episode === episodeNumber
                );
                return new Episode({
                    name:        metaEp?.name  || "Episode " + episodeNumber,
                    url:         JSON.stringify([...urls, seriesTitle]),
                    season:      seasonNumber,
                    episode:     episodeNumber,
                    description: metaEp?.overview  || null,
                    posterUrl:   metaEp?.thumbnail || null,
                    aired:       metaEp?.released  || null
                });
            })
            .sort((a, b) =>
                a.season !== b.season ? a.season - b.season : a.episode - b.episode
            );
    }

    /**
     * collectMovieLinks - maxbutton pages fetched IN PARALLEL.
     */
    async function collectMovieLinks(html, mainUrl) {
        const listUrls = [];
        const maxbuttonRe =
            /<a[^>]+class="[^"]*maxbutton[^"]*"[^>]+href="([^"]+)"/gi;
        let match;
        while ((match = maxbuttonRe.exec(html)) !== null) {
            if (match[1]) listUrls.push(match[1]);
        }

        const settled = await Promise.allSettled(listUrls.map(u => http_get(u)));

        const hrefs = [];
        for (const result of settled) {
            if (result.status !== "fulfilled") continue;
            const contentMatch = result.value.body.match(
                /<div[^>]+class="[^"]*entry-content[^"]*"[^>]*>([^]*?)<\/div>/i
            );
            const content = contentMatch ? contentMatch[1] : result.value.body;
            const hrefRe  = /<a[^>]+href="([^"]+)"/gi;
            let hMatch;
            while ((hMatch = hrefRe.exec(content)) !== null) {
                const h = hMatch[1];
                if (h && h.startsWith("http")) hrefs.push(h);
            }
        }
        return hrefs;
    }

    /**
     * loadStreams - filename-based labels, title stripped, full dedup, all-parallel fetches.
     *
     * LABEL: clean filename with movie title stripped from the front.
     *   e.g.  "Interstellar.2014.1080p.BluRay.x265.AAC.mkv"
     *         -> "2014.1080p.BluRay.x265.AAC.mkv"   (year-based fallback cut)
     *         OR "1080p.BluRay.x265.AAC.mkv"        (if title regex matched)
     *
     * DEDUP:  by final URL  AND  by cleaned label - mirrors with same filename collapse.
     * FILTER: CAM / TS / HDCAM rips silently dropped.
     * SPEED:  hub pages parallel -> no extra fetches.
     * SORT:   quality integer extracted from filename/text, used only for ordering.
     */
    async function loadStreams(url, cb) {
        try {
            const rawLinks = JSON.parse(url);
            if (!Array.isArray(rawLinks) || rawLinks.length === 0) {
                return cb({ success: true, data: [] });
            }

            // Extract movie/series title appended as last element
            let movieTitle = null;
            let links = rawLinks;

            if (
                typeof rawLinks[rawLinks.length - 1] === "string" &&
                !rawLinks[rawLinks.length - 1].startsWith("http")
            ) {
                movieTitle = rawLinks[rawLinks.length - 1];
                links = rawLinks.slice(0, -1);
            }

            const results    = [];
            const seenUrls   = new Set();
            const seenNames  = new Set();

            // PARALLEL: fetch all hub pages
            const hubPages = await Promise.allSettled(
                links.map(u => http_get(u))
            );

            for (const hub of hubPages) {
                if (hub.status !== "fulfilled" || !hub.value?.body) continue;

                const pageBody = hub.value.body;

                // FIX: capture anchor text alongside href for better filename detection
                const matches = [...pageBody.matchAll(/<a[^>]+href="([^"]+)"[^>]*>([^<]*)<\/a>/gi)];

                for (const m of matches) {
                    const link       = m[1];
                    const anchorText = (m[2] || "").trim();

                    if (isBlockedUrl(link)) continue;
                    if (link.includes("hindmoviez")) continue;

                    // Normalise protocol-relative URLs to absolute https
                    const resolvedLink = link.startsWith("//") ? "https:" + link : link;

                    if (seenUrls.has(resolvedLink)) continue;
                    seenUrls.add(resolvedLink);

                    // FIX: pass anchor text so extractFilename can use it as a fallback
                    const filename = extractFilename(resolvedLink, anchorText);

                    // Build label: prefer filename, fall back to hostname
                    let cleanName;
                    if (filename) {
                        cleanName = stripMovieTitle(filename, movieTitle);
                    } else {
                        try {
                            cleanName = new URL(resolvedLink).hostname.replace(/^www\./, "");
                        } catch (_) {
                            cleanName = "Stream";
                        }
                    }

                    // Remove non-ASCII / control characters
                    cleanName = cleanName.replace(/[^\x20-\x7E.]/g, "");

                    // FIX: normalise dots and underscores (previously in a broken orphaned block)
                    cleanName = cleanName
                        .replace(/\.+/g, ".")
                        .replace(/_/g, ".")
                        .trim();

                    if (!cleanName || cleanName.length < 3) continue;

                    const normalized = cleanName.toLowerCase();

                    // Deduplicate by label
                    if (seenNames.has(normalized)) continue;
                    seenNames.add(normalized);

                    // Drop CAM / TS / HDCAM rips
                    if (isLowQualitySource(normalized)) continue;

                    results.push(new StreamResult({
                        url: resolvedLink,
                        source: cleanName
                    }));
                }
            }

            cb({ success: true, data: results });

        } catch (e) {
            cb({
                success: false,
                errorCode: "STREAM_ERROR",
                message: e.message
            });
        }
    }

    // --- Export ---
    globalThis.getHome    = getHome;
    globalThis.search     = search;
    globalThis.load       = load;
    globalThis.loadStreams = loadStreams;
})();
