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

    /**
     * Removes common junk tokens from scraped titles.
     * Mirrors cleanTitle() from the Kotlin source.
     */
    function cleanTitle(raw) {
        if (!raw) return "Unknown";
        return raw
            .replace(/(480p|720p|1080p|4K|HDRip|BluRay|WEBRip|WEB-DL|DVDRip|HEVC|x264|x265|AAC|DD5\.1|ESub)/gi, "")
            .replace(/\s{2,}/g, " ")
            .trim();
    }

    /**
     * Derive a quality integer from a title/heading string.
     * Mirrors getIndexQuality() / getSearchQuality() from the Kotlin source.
     */
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

    /**
     * Extracts a bracketed spec string from a file name (resolution, codec, audio tags).
     * Mirrors extractSpecs() / buildExtractedTitle() from the Kotlin source.
     */
    function extractSpecs(name) {
        if (!name) return "";
        const tokens = [];
        const patterns = [
            /(480p|720p|1080p|4K|2160p)/i,
            /(HEVC|x264|x265|AVC)/i,
            /(BluRay|WEBRip|WEB-DL|HDRip|DVDRip)/i,
            /(AAC|DD5\.1|DDP5\.1|DTS|AC3)/i,
            /(ESub|MSub|Subs?)/i
        ];
        for (const p of patterns) {
            const m = name.match(p);
            if (m) tokens.push(m[0]);
        }
        return tokens.length ? "[" + tokens.join("][") + "]" : "";
    }

    /**
     * Parse a TMDB credits JSON string into an array of Actor objects.
     * Mirrors parseCredits() from the Kotlin source.
     */
    function parseCredits(creditsJson) {
        if (!creditsJson) return [];
        try {
            const data = JSON.parse(creditsJson);
            return (data.cast || []).slice(0, 20).map(c =>
                new Actor({
                    name: c.name,
                    role: c.character,
                    image: c.profile_path
                        ? `https://image.tmdb.org/t/p/w185${c.profile_path}`
                        : undefined
                })
            );
        } catch (e) {
            return [];
        }
    }

    /** Strip all HTML tags and decode common entities from a string. */
    function stripTags(str) {
        if (!str) return "";
        return str
            .replace(/<[^>]*>/g, "")
            .replace(/&amp;/g, "&")
            .replace(/&nbsp;/g, " ")
            .replace(/&#\d+;/g, "")
            .trim();
    }

    /** Resolve a possibly-relative URL against a base URL. */
    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.startsWith("http")) return href;
        if (href.startsWith("/")) return base.replace(/\/$/, "") + href;
        return base.replace(/\/$/, "") + "/" + href;
    }

    /**
     * Look up a TMDB integer ID from an IMDb ID string (e.g. "tt1234567").
     * Mirrors the tmdbId lookup block inside load() in the Kotlin source.
     */
    async function tmdbIdFromImdb(imdbId) {
        try {
            const res = await http_get(
                `https://api.themoviedb.org/3/find/${imdbId}` +
                `?api_key=${TMDB_API_KEY}&external_source=imdb_id`
            );
            const data = JSON.parse(res.body);
            return (
                data.movie_results?.[0]?.id ||
                data.tv_results?.[0]?.id ||
                null
            );
        } catch (e) {
            return null;
        }
    }

    // --- Core Functions ---

    /**
     * getHome – fetches all configured homepage sections.
     * Mirrors getMainPage() for every entry in mainPage from the Kotlin source.
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

            const homeData = {};

            for (const section of sections) {
                try {
                    const url = section.path
                        ? `${mainUrl}/${section.path}`
                        : mainUrl;
                    const res = await http_get(url);
                    const items = parseArticles(res.body, mainUrl);
                    if (items.length > 0) homeData[section.name] = items;
                } catch (e) {
                    console.error(`Section [${section.name}] failed: ${e.message}`);
                }
            }

            cb({ success: true, data: homeData });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    /**
     * Parse <article> elements from raw HTML into an array of MultimediaItem.
     * Mirrors Element.toSearchResult() from the Kotlin source.
     */
    function parseArticles(html, mainUrl) {
        const items = [];
        const articleRe = /<article[^]*?<\/article>/gi;
        let articleMatch;
        while ((articleMatch = articleRe.exec(html)) !== null) {
            const block = articleMatch[0];

            // Title from <h2 class="entry-title"><a>…</a></h2>
            const titleMatch = block.match(
                /<h2[^>]*class="entry-title"[^>]*>[^]*?<a[^>]*>([^]*?)<\/a>/i
            );
            const rawTitle = titleMatch
                ? titleMatch[1].replace(/<[^>]*>/g, "").trim()
                : null;
            if (!rawTitle) continue;
            const title = cleanTitle(rawTitle);

            // URL – first <a href> in the block
            const hrefMatch = block.match(/<a[^>]+href="([^"]+)"/i);
            const href = hrefMatch ? resolveUrl(hrefMatch[1], mainUrl) : null;
            if (!href) continue;

            // Poster – prefer data-src, fall back to src inside entry-header
            const posterMatch =
                block.match(/class="[^"]*entry-header[^"]*"[^]*?<img[^>]+data-src="([^"]+)"/i) ||
                block.match(/class="[^"]*entry-header[^"]*"[^]*?<img[^>]+src="([^"]+)"/i) ||
                block.match(/<img[^>]+data-src="([^"]+)"/i) ||
                block.match(/<img[^>]+src="([^"]+)"/i);
            const posterUrl = posterMatch ? posterMatch[1] : null;

            const type = /Season/i.test(rawTitle) ? "series" : "movie";

            items.push(new MultimediaItem({
                title,
                url: href,
                posterUrl,
                type,
            }));
        }
        return items;
    }

    /**
     * search – mirrors search() from the Kotlin source.
     */
    async function search(query, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await http_get(
                `${mainUrl}/?s=${encodeURIComponent(query)}`
            );
            const items = parseArticles(res.body, mainUrl);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    /**
     * load – mirrors load() from the Kotlin source.
     *
     * Scrapes the detail page, enriches with TMDB cast and Cinemeta metadata,
     * then builds either a series (with Episode objects) or a movie
     * (with a single Episode whose URL encodes the download-page link list).
     */
    async function load(url, cb) {
        try {
            const mainUrl = await getMainUrl();
            const res = await http_get(url);
            const html = res.body;

            // --- Parse metadata from <ul><li> blocks ---
            let name         = null;
            let imdbRating   = null;
            let imdbId       = null;
            let releaseYear  = null;
            let docGenres    = [];

            const liRe = /<li>([^]*?)<\/li>/gi;
            let liMatch;
            while ((liMatch = liRe.exec(html)) !== null) {
                const liHtml = liMatch[1];
                const strongMatch = liHtml.match(/<strong>([^]*?)<\/strong>/i);
                if (!strongMatch) continue;

                const strongText  = stripTags(strongMatch[1]).trim();
                const key         = strongText.split(":")[0].trim();
                const inlineVal   = (strongText.split(":")[1] || "").trim();
                const tailText    = stripTags(liHtml.replace(strongMatch[0], "")).trim();
                const value       = tailText || inlineVal;

                if      (key === "Name")        { name       = value || null; }
                else if (key === "IMDB Rating") {
                    imdbRating = inlineVal.split("/")[0].trim() || null;
                    const idMatch = liHtml.match(/href="[^"]*\/title\/(tt\d+)\//i);
                    if (idMatch) imdbId = idMatch[1];
                }
                else if (key === "Release Year") { releaseYear = value || null; }
                else if (key === "Genre") {
                    docGenres = value.split(",").map(s => s.trim()).filter(Boolean);
                }
            }

            const title = name || "Unknown";

            // Poster from og:image
            const posterMatch = html.match(
                /<meta[^>]+property="og:image"[^>]+content="([^"]+)"/i
            );
            const poster = posterMatch ? posterMatch[1] : null;

            // Storyline description paragraph that follows an <h3> containing "Storyline"
            const storyMatch = html.match(
                /<h3[^>]*>[^<]*Storyline[^<]*<\/h3>\s*<p[^>]*>([^]*?)<\/p>/i
            );
            const descriptions = storyMatch ? stripTags(storyMatch[1]).trim() : null;

            // Series vs Movie from <h1 class="entry-title">
            const h1Match = html.match(
                /<h1[^>]*class="entry-title"[^>]*>([^]*?)<\/h1>/i
            );
            const h1Text   = h1Match ? stripTags(h1Match[1]) : "";
            const isSeries = /Season/i.test(h1Text);

            let description = descriptions;
            let background  = poster;
            let castList    = [];

            // --- TMDB cast lookup ---
            const tmdbId = imdbId ? await tmdbIdFromImdb(imdbId) : null;
            if (tmdbId) {
                try {
                    const creditsRes = await http_get(
                        `https://api.themoviedb.org/3/${isSeries ? "tv" : "movie"}/${tmdbId}/credits` +
                        `?api_key=${TMDB_API_KEY}&language=en-US`
                    );
                    castList = parseCredits(creditsRes.body);
                } catch (_) {}
            }

            // --- Cinemeta metadata ---
            let responseData = null;
            if (imdbId) {
                try {
                    const cineRes = await http_get(
                        `${CINEMETA_URL}/${isSeries ? "series" : "movie"}/${imdbId}.json`
                    );
                    if (cineRes.body && cineRes.body.trim().startsWith("{")) {
                        responseData = JSON.parse(cineRes.body);
                    }
                } catch (_) {}
            }

            if (responseData?.meta) {
                description = responseData.meta.description || descriptions;
                background  = responseData.meta.background  || poster;
            }

            // --- Series branch ---
            if (isSeries) {
                const episodes = await buildSeriesEpisodes(html, responseData, mainUrl);
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title:      responseData?.meta?.name || title,
                        url,
                        posterUrl:  poster,
                        bannerUrl:  background,
                        logoUrl:    responseData?.meta?.logo || null,
                        type:       "series",
                        description,
                        year:       parseInt(releaseYear || responseData?.meta?.year) || undefined,
                        score:      parseFloat(imdbRating || responseData?.meta?.imdbRating) || undefined,
                        genres:     docGenres,
                        cast:       castList,
                        episodes
                    })
                });
                return;
            }

            // --- Movie branch ---
            // hrefs is a JSON-encoded array of download-hub page URLs, passed
            // through as the Episode URL so loadStreams can process them.
            const hrefs = await collectMovieLinks(html, mainUrl);
            cb({
                success: true,
                data: new MultimediaItem({
                    title:      responseData?.meta?.name || title,
                    url,
                    posterUrl:  poster,
                    bannerUrl:  background,
                    logoUrl:    responseData?.meta?.logo || null,
                    type:       "movie",
                    description,
                    year:       parseInt(releaseYear || responseData?.meta?.year) || undefined,
                    score:      parseFloat(imdbRating || responseData?.meta?.imdbRating) || undefined,
                    genres:     docGenres,
                    cast:       castList,
                    episodes: [
                        new Episode({
                            name:    "Movie",
                            url:     JSON.stringify(hrefs),
                            season:  1,
                            episode: 1
                        })
                    ]
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    /**
     * Build the Episode array for a TV series page.
     * Mirrors the episodeUrlMap block inside load() in the Kotlin source:
     *   • Each <h3> containing "Season N" is followed by a <p><a href="…">
     *     pointing to an episode-list page.
     *   • That page contains <h3><a>…Episode N…</a></h3> links.
     *   • Multiple download URLs per episode are collected and JSON-encoded
     *     as the Episode URL so loadStreams can process them.
     */
    async function buildSeriesEpisodes(html, responseData, mainUrl) {
        const episodeUrlMap = {};

        // Season header pattern: <h3>…Season N…</h3> <p>…<a href="episodeListUrl">…
        const seasonRe =
            /<h3[^>]*>[^]*?Season\s*(\d+)[^]*?<\/h3>\s*<p[^>]*>[^]*?<a[^>]+href="([^"]+)"/gi;
        let seasonMatch;
        while ((seasonMatch = seasonRe.exec(html)) !== null) {
            const seasonNumber   = parseInt(seasonMatch[1]);
            const episodeListUrl = seasonMatch[2];
            if (!seasonNumber || !episodeListUrl) continue;

            try {
                const epListRes = await http_get(episodeListUrl);
                // Each episode entry: <h3><a href="epUrl">…Episode N…</a></h3>
                const epRe = /<h3[^>]*>\s*<a[^>]+href="([^"]+)"[^>]*>([^]*?)<\/a>/gi;
                let epMatch;
                while ((epMatch = epRe.exec(epListRes.body)) !== null) {
                    const epUrl      = epMatch[1];
                    const epText     = stripTags(epMatch[2]);
                    const epNumMatch = epText.match(/Episode\s*(\d+)/i);
                    if (!epNumMatch) continue;
                    const episodeNumber = parseInt(epNumMatch[1]);
                    const key = `${seasonNumber}_${episodeNumber}`;
                    if (!episodeUrlMap[key]) {
                        episodeUrlMap[key] = { seasonNumber, episodeNumber, urls: [] };
                    }
                    episodeUrlMap[key].urls.push(epUrl);
                }
            } catch (e) {
                console.error(
                    `Failed to load episode list for Season ${seasonNumber}: ${e.message}`
                );
            }
        }

        return Object.values(episodeUrlMap)
            .map(({ seasonNumber, episodeNumber, urls }) => {
                const metaEp = responseData?.meta?.videos?.find(
                    v => v.season === seasonNumber && v.episode === episodeNumber
                );
                return new Episode({
                    name:        metaEp?.name   || `Episode ${episodeNumber}`,
                    url:         JSON.stringify(urls),
                    season:      seasonNumber,
                    episode:     episodeNumber,
                    description: metaEp?.overview   || null,
                    posterUrl:   metaEp?.thumbnail  || null,
                    aired:       metaEp?.released   || null
                });
            })
            .sort((a, b) =>
                a.season !== b.season
                    ? a.season  - b.season
                    : a.episode - b.episode
            );
    }

    /**
     * Follow each <a class="maxbutton"> link and collect all <a> hrefs found
     * inside the linked page's entry-content div.
     * Mirrors the hrefs / amap block inside load() in the Kotlin source.
     */
    async function collectMovieLinks(html, mainUrl) {
        const hrefs = [];
        const maxbuttonRe =
            /<a[^>]+class="[^"]*maxbutton[^"]*"[^>]+href="([^"]+)"/gi;
        let match;
        while ((match = maxbuttonRe.exec(html)) !== null) {
            const listUrl = match[1];
            if (!listUrl) continue;
            try {
                const listRes = await http_get(listUrl);
                // Try to scope to entry-content; fall back to full body
                const contentMatch = listRes.body.match(
                    /<div[^>]+class="[^"]*entry-content[^"]*"[^>]*>([^]*?)<\/div>/i
                );
                const content = contentMatch ? contentMatch[1] : listRes.body;
                const hrefRe  = /<a[^>]+href="([^"]+)"/gi;
                let hMatch;
                while ((hMatch = hrefRe.exec(content)) !== null) {
                    const h = hMatch[1];
                    if (h && h.startsWith("http")) hrefs.push(h);
                }
            } catch (e) {
                console.error(`collectMovieLinks failed for ${listUrl}: ${e.message}`);
            }
        }
        return hrefs;
    }

    // --- loadStreams helpers ---

    /**
     * Decode base64 from URL parameter (handles both 'file' and 'id' params)
     */
    function decodeBase64Param(url) {
        try {
            // Try file param first (for workers.dev links)
            let match = url.match(/[?&]file=([^&]+)/);
            if (match) {
                const decoded = atob(match[1]);
                // Sometimes the decoded string is URL encoded, try to decode
                try {
                    return decodeURIComponent(decoded);
                } catch {
                    return decoded;
                }
            }

            // Fall back to id param
            match = url.match(/[?&]id=([^&]+)/);
            if (match) {
                const decoded = atob(match[1]);
                try {
                    return decodeURIComponent(decoded);
                } catch {
                    return decoded;
                }
            }

            return "";
        } catch (e) {
            return "";
        }
    }

    /**
     * Extract quality from string (improved version)
     */
    function getQualityAdvanced(str) {
        if (!str) return 0;
        const s = str.toLowerCase();

        // Check for 4K/2160p first
        if (/(4k|2160p)/.test(s)) return 2160;
        if (/1080p/.test(s)) return 1080;
        if (/720p/.test(s)) return 720;
        if (/480p/.test(s)) return 480;
        if (/360p/.test(s)) return 360;
        if (/hd/.test(s)) return 720;
        if (/(cam|hdcam|ts|telesync)/.test(s)) return 360;

        return 0;
    }

    /**
     * Extract file size from string
     */
    function getSize(str) {
        if (!str) return "";
        const m = str.match(/(\d+(\.\d+)?)\s*(GB|MB|GiB|MiB)/i);
        if (!m) return "";
        return `${m[1]}${m[3].toUpperCase().replace('IB', 'B')}`;
    }

    /**
     * Extract server name from URL (e.g., "ger" from ger.xxx.workers.dev)
     */
    function getServerName(url) {
        if (!url) return "Unknown";
        try {
            // Match subdomain from workers.dev or similar
            const match = url.match(/https?:\/\/([^.]+)\.[^/]+\.(workers\.dev|work|dev)/i);
            if (match) return match[1].toUpperCase();

            // Fallback: get domain name
            const urlObj = new URL(url);
            const parts = urlObj.hostname.split('.');
            if (parts.length >= 2) return parts[parts.length - 2].toUpperCase();
            return parts[0].toUpperCase();
        } catch {
            return "Unknown";
        }
    }

    /**
     * loadStreams – mirrors loadLinks() from the Kotlin source.
     *
     * The `url` payload is a JSON-stringified array of download-hub page URLs.
     * For each page:
     *   1. Scrape the file Name and Size labels.
     *   2. Follow every <a class="btn"> → intermediate redirect page.
     *   3. On that page collect every <a class="button"> → direct stream link.
     */
    async function loadStreams(url, cb) {
        try {
            const links = JSON.parse(url);
            if (!Array.isArray(links) || links.length === 0) {
                return cb({ success: true, data: [] });
            }

            const results = [];
            const seen = new Set();

            for (const pageUrl of links) {
                let pageBody;

                try {
                    const res = await http_get(pageUrl);
                    pageBody = res.body;
                } catch (e) {
                    console.error(`Failed to load page ${pageUrl}: ${e.message}`);
                    continue;
                }

                // Find all links on the page
                const btnMatches = pageBody.matchAll(/<a[^>]+href="([^"]+)"[^>]*>(.*?)<\/a>/gi);

                for (const m of btnMatches) {
                    const btnUrl = m[1];
                    const btnText = stripTags(m[2] || "");

                    if (!btnUrl || !btnUrl.startsWith("http")) continue;

                    // Skip social links and blocked domains
                    if (/telegram|whatsapp|facebook|twitter|instagram/i.test(btnUrl)) continue;

                    let btnBody;
                    try {
                        const res = await http_get(btnUrl);
                        btnBody = res.body;
                    } catch (e) {
                        continue;
                    }

                    // Find final download links on the button page
                    const linkMatches = btnBody.matchAll(/<a[^>]+href="([^"]+)"[^>]*>(.*?)<\/a>/gi);

                    for (const lm of linkMatches) {
                        let finalUrl = lm[1];
                        const text = stripTags(lm[2] || "");

                        if (!finalUrl || !finalUrl.startsWith("http")) continue;
                        if (finalUrl.includes("hindmoviez")) continue;

                        // Handle protocol-relative URLs
                        if (finalUrl.startsWith("//")) finalUrl = "https:" + finalUrl;

                        // Skip if already seen
                        if (seen.has(finalUrl)) continue;
                        seen.add(finalUrl);

                        // Decode the base64 filename from the URL
                        const decodedFilename = decodeBase64Param(finalUrl);

                        // Combine decoded filename, link text, and URL for quality detection
                        const combinedText = (decodedFilename + " " + text + " " + finalUrl).toLowerCase();

                        // Extract quality
                        const quality = getQualityAdvanced(combinedText) || 
                                       getQualityAdvanced(decodedFilename) || 
                                       getQualityAdvanced(text) || 
                                       qualityFromString(decodedFilename) || 
                                       qualityFromString(text) || 
                                       0;

                        // Extract size
                        const size = getSize(combinedText) || getSize(decodedFilename) || getSize(text);

                        // Get server name (e.g., GER, CVB)
                        const server = getServerName(finalUrl);

                        // Build source label
                        let label = server;
                        if (quality && size) {
                            label = `${quality}p | ${server} | ${size}`;
                        } else if (quality) {
                            label = `${quality}p | ${server}`;
                        } else if (size) {
                            label = `${server} | ${size}`;
                        }

                        // Add specs if decoded filename contains them
                        const specs = extractSpecs(decodedFilename);
                        if (specs && !label.includes('p |')) {
                            label += ` ${specs}`;
                        }

                        results.push(new StreamResult({
                            url: finalUrl,
                            quality: quality,
                            source: label,
                            headers: { Referer: btnUrl }
                        }));
                    }
                }
            }

            // Sort by quality descending
            results.sort((a, b) => (b.quality || 0) - (a.quality || 0));

            cb({ success: true, data: results });

        } catch (e) {
            console.error("LoadStreams error:", e);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    // --- Export ---
    if (typeof globalThis !== 'undefined') {
        globalThis.getHome = getHome;
        globalThis.search = search;
        globalThis.load = load;
        globalThis.loadStreams = loadStreams;
    }

    if (typeof window !== 'undefined') {
        window.getHome = getHome;
        window.search = search;
        window.load = load;
        window.loadStreams = loadStreams;
    }

    if (typeof global !== 'undefined') {
        global.getHome = getHome;
        global.search = search;
        global.load = load;
        global.loadStreams = loadStreams;
    }
})();