(function () {
    "use strict";

    var DEFAULT_BASE_URL = "https://vegamovies.vodka";
    var URLS_JSON_URL = "https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json";
    var CINEMETA_URL = "https://v3-cinemeta.strem.io/meta";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var cachedUrls = null;
    var cachedMainUrl = null;

    var HOME_SECTIONS = [
        { path: "/", title: "Home" },
        { path: "/web-series/netflix/", title: "Netflix" },
        { path: "/web-series/disney-plus-hotstar/", title: "Disney Plus Hotstar" },
        { path: "/web-series/amazon-prime-video/", title: "Amazon Prime" },
        { path: "/web-series/mx-original/", title: "MX Original" },
        { path: "/anime-series/", title: "Anime Series" },
        { path: "/korean-series/", title: "Korean Series" }
    ];

    function trim(value) {
        return String(value == null ? "" : value).replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function decodeHtml(value) {
        return trim(String(value == null ? "" : value)
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&#039;/gi, "'")
            .replace(/&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">"));
    }

    function stripTags(value) {
        return decodeHtml(String(value == null ? "" : value)
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<script[\s\S]*?<\/script>/gi, " ")
            .replace(/<style[\s\S]*?<\/style>/gi, " ")
            .replace(/<[^>]+>/g, " "));
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function parseHeaders(rawHeaders) {
        var headers = {};
        if (!rawHeaders) return headers;
        if (typeof rawHeaders.forEach === "function") {
            rawHeaders.forEach(function (value, key) {
                headers[String(key).toLowerCase()] = value;
            });
            return headers;
        }
        for (var key in rawHeaders) {
            if (!Object.prototype.hasOwnProperty.call(rawHeaders, key)) continue;
            headers[String(key).toLowerCase()] = rawHeaders[key];
        }
        return headers;
    }

    function responseStatus(res) {
        if (!res) return 0;
        if (typeof res.status === "number") return res.status;
        if (typeof res.statusCode === "number") return res.statusCode;
        if (typeof res.code === "number") return res.code;
        return 0;
    }

    function requestWithFetch(url, method, headers, body, followRedirects) {
        if (typeof fetch !== "function") {
            return Promise.reject(new Error("No request backend for " + method + " " + url));
        }
        return fetch(url, {
            method: method,
            headers: headers,
            body: method === "HEAD" ? undefined : body,
            redirect: followRedirects === false ? "manual" : "follow"
        }).then(function (res) {
            var finish = function (bodyText) {
                return {
                    status: res.status,
                    body: bodyText || "",
                    headers: parseHeaders(res.headers),
                    finalUrl: res.url || url
                };
            };
            if (method === "HEAD") return finish("");
            return res.text().then(finish);
        });
    }

    async function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || {};
        var body = typeof options.body === "undefined" ? "" : options.body;
        var followRedirects = options.followRedirects !== false;

        if (method === "GET" && typeof http_get === "function") {
            var attempts = [
                function () { return http_get(url, { headers: headers, followRedirects: followRedirects }); },
                function () { return http_get(url, headers); }
            ];
            var lastError = null;
            for (var i = 0; i < attempts.length; i++) {
                try {
                    var res = await attempts[i]();
                    return {
                        status: responseStatus(res) || 200,
                        body: res && typeof res.body !== "undefined" ? res.body : "",
                        headers: parseHeaders(res && res.headers),
                        finalUrl: (res && (res.url || res.finalUrl)) || url
                    };
                } catch (error) {
                    lastError = error;
                }
            }
            throw lastError || new Error("GET failed: " + url);
        }

        if (method === "HEAD" && typeof http_head === "function") {
            try {
                var headRes = await http_head(url, { headers: headers, followRedirects: followRedirects });
                return {
                    status: responseStatus(headRes) || 200,
                    body: "",
                    headers: parseHeaders(headRes && headRes.headers),
                    finalUrl: (headRes && (headRes.url || headRes.finalUrl)) || url
                };
            } catch (_) {}
        }

        return requestWithFetch(url, method, headers, body, followRedirects);
    }

    async function getText(url, headers, followRedirects) {
        var res = await request(url, {
            headers: headers || defaultHeaders(),
            followRedirects: followRedirects !== false
        });
        if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
        return { body: String(res.body || ""), finalUrl: res.finalUrl || url, headers: res.headers || {} };
    }

    async function getJson(url, headers) {
        var res = await getText(url, headers || defaultHeaders());
        return parseJsonSafe(res.body, {});
    }

    function defaultHeaders(extra) {
        var headers = {
            "User-Agent": COMMON_USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Accept-Language": "en-US,en;q=0.9",
            "Referer": DEFAULT_BASE_URL + "/"
        };
        extra = extra || {};
        for (var key in extra) {
            if (Object.prototype.hasOwnProperty.call(extra, key)) headers[key] = extra[key];
        }
        return headers;
    }

    async function getDynamicUrls() {
        if (cachedUrls) return cachedUrls;
        try {
            cachedUrls = await getJson(URLS_JSON_URL, defaultHeaders({ "Accept": "application/json,*/*" }));
        } catch (_) {
            cachedUrls = {};
        }
        return cachedUrls || {};
    }

    async function getMainUrl() {
        if (cachedMainUrl) return cachedMainUrl;
        var urls = await getDynamicUrls();
        cachedMainUrl = urls.vegamovies || DEFAULT_BASE_URL;
        return cachedMainUrl;
    }

    async function getLatestBaseUrl(baseUrl, key) {
        var urls = await getDynamicUrls();
        return urls[key] || baseUrl;
    }

    function baseOrigin(url) {
        try {
            var parsed = new URL(url);
            return parsed.protocol + "//" + parsed.host;
        } catch (_) {
            return "";
        }
    }

    function absoluteUrl(base, path) {
        if (!path) return "";
        try {
            return new URL(decodeHtml(path), base || DEFAULT_BASE_URL).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    async function fixUrl(value) {
        return absoluteUrl(await getMainUrl(), value);
    }

    function extractAttr(tag, name) {
        var quoted = new RegExp("\\b" + name + "\\s*=\\s*([\"'])([\\s\\S]*?)\\1", "i").exec(String(tag || ""));
        if (quoted) return decodeHtml(quoted[2]);
        var bare = new RegExp("\\b" + name + "\\s*=\\s*([^\\s>]+)", "i").exec(String(tag || ""));
        return bare ? decodeHtml(bare[1]) : "";
    }

    function firstMatch(value, patterns) {
        var source = String(value || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = patterns[i].exec(source);
            if (match) return decodeHtml(match[1] || match[0] || "");
        }
        return "";
    }

    function cleanTitle(value) {
        return trim(decodeHtml(value)
            .replace(/^Download\s+/i, "")
            .replace(/\s*[-|]\s*Vegamovies(?:\.[a-z]+)?(?:\.hot|\.is|\.to)?\s*$/i, "")
            .replace(/\s*-\s*Nexdrive\.Pro\s*$/i, ""));
    }

    function mediaTypeFromText(value) {
        return /\b(?:season|series|episode|web[\s-]*series)\b/i.test(String(value || "")) ? "series" : "movie";
    }

    function getQualityFromText(value) {
        var text = String(value || "");
        var match = /(\d{3,4})\s*p\b/i.exec(text);
        if (match) return Number(match[1]);
        var lower = text.toLowerCase();
        if (lower.indexOf("8k") !== -1) return 4320;
        if (lower.indexOf("4k") !== -1 || lower.indexOf("uhd") !== -1 || lower.indexOf("2160") !== -1) return 2160;
        if (lower.indexOf("2k") !== -1 || lower.indexOf("1440") !== -1) return 1440;
        return 0;
    }

    function qualityLabel(quality) {
        quality = Number(quality || 0);
        if (quality >= 2160) return "2160p";
        if (quality >= 1440) return "1440p";
        if (quality >= 1080) return "1080p";
        if (quality >= 720) return "720p";
        if (quality >= 480) return "480p";
        return "";
    }

    function sourceWithQuality(source, quality) {
        var cleanSource = trim(source || "VegaMovies") || "VegaMovies";
        var label = qualityLabel(quality);
        if (!label || new RegExp("\\b" + label + "\\b", "i").test(cleanSource)) return cleanSource;
        return cleanSource + " " + label;
    }

    function sizeFromText(value) {
        return firstMatch(value, [/\[((?:\d+(?:\.\d+)?\s*)?(?:GB|MB|KB)(?:\/E)?)\]/i, /\b(\d+(?:\.\d+)?\s*(?:GB|MB|KB)(?:\/E)?)\b/i]);
    }

    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: sourceWithQuality(source, quality),
            quality: quality || undefined,
            headers: headers || {}
        });
    }

    function uniqueBy(list, keyFn) {
        var seen = {};
        var out = [];
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function extractAnchors(html, base) {
        var anchors = [];
        var re = /<a\b([^>]*\bhref\s*=\s*(["'])([\s\S]*?)\2[^>]*)>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = re.exec(String(html || ""))) !== null) {
            var href = absoluteUrl(base, match[3]);
            anchors.push({
                href: href,
                attrs: match[1] || "",
                html: match[4] || "",
                text: stripTags(match[4] || "")
            });
        }
        return anchors;
    }

    function extractListingItems(html, pageUrl) {
        var items = [];
        var seen = {};
        var anchors = extractAnchors(html, pageUrl);
        for (var i = 0; i < anchors.length; i++) {
            var anchor = anchors[i];
            if (!/\/download-/i.test(anchor.href)) continue;
            if (seen[anchor.href]) continue;

            var imgTag = firstMatch(anchor.html, [/(<img\b[\s\S]*?>)/i]);
            var title = cleanTitle(extractAttr(imgTag, "alt") || anchor.text);
            var poster = extractAttr(imgTag, "data-src") || extractAttr(imgTag, "src");
            if (/^data:image\//i.test(poster)) poster = extractAttr(imgTag, "data-src");
            if (!title || title.length < 3) continue;

            seen[anchor.href] = true;
            items.push({
                title: title,
                url: anchor.href,
                posterUrl: absoluteUrl(pageUrl, poster),
                type: mediaTypeFromText(title),
                quality: getQualityFromText(title)
            });
        }
        return items;
    }

    function toMultimediaItem(item, referer) {
        return new MultimediaItem({
            title: item.title,
            url: item.url,
            posterUrl: item.posterUrl || undefined,
            type: item.type || mediaTypeFromText(item.title),
            quality: item.quality || undefined,
            headers: defaultHeaders({ "Referer": referer || item.url })
        });
    }

    function extractMetaContent(html, property) {
        var escaped = property.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
        return firstMatch(html, [
            new RegExp("<meta[^>]+property=[\"']" + escaped + "[\"'][^>]+content=[\"']([^\"']+)[\"']", "i"),
            new RegExp("<meta[^>]+name=[\"']" + escaped + "[\"'][^>]+content=[\"']([^\"']+)[\"']", "i"),
            new RegExp("<meta[^>]+content=[\"']([^\"']+)[\"'][^>]+property=[\"']" + escaped + "[\"']", "i"),
            new RegExp("<meta[^>]+content=[\"']([^\"']+)[\"'][^>]+name=[\"']" + escaped + "[\"']", "i")
        ]);
    }

    function extractImdbUrl(html) {
        var anchors = extractAnchors(html, DEFAULT_BASE_URL);
        for (var i = 0; i < anchors.length; i++) {
            if (/imdb\.com\/title\//i.test(anchors[i].href)) return anchors[i].href;
        }
        return "";
    }

    function extractSynopsis(html) {
        return stripTags(firstMatch(html, [
            /<h3\b[^>]*>[\s\S]*?(?:SYNOPSIS|PLOT)[\s\S]*?<\/h3>\s*<p\b[^>]*>([\s\S]*?)<\/p>/i
        ]));
    }

    async function fetchCinemeta(type, imdbUrl) {
        var imdbId = firstMatch(imdbUrl, [/title\/(tt\d+)/i]);
        if (!imdbId) return null;
        try {
            var mediaType = type === "movie" ? "movie" : "series";
            var json = await getJson(CINEMETA_URL + "/" + mediaType + "/" + imdbId + ".json", defaultHeaders({ "Accept": "application/json,*/*" }));
            return json && json.meta ? json.meta : null;
        } catch (_) {
            return null;
        }
    }

    function extractQualityGroups(html, base) {
        var groups = [];
        var re = /<h([35])\b[^>]*>([\s\S]*?)<\/h\1>\s*<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var match;
        while ((match = re.exec(String(html || ""))) !== null) {
            var headingHtml = match[2] || "";
            var headingText = stripTags(headingHtml);
            if (!/(?:4k|\d{3,4}\s*p)/i.test(headingText)) continue;
            if (/zip/i.test(headingText)) continue;
            var anchors = extractAnchors(match[3] || "", base);
            if (!anchors.length) continue;
            groups.push({
                title: headingText,
                season: Number(firstMatch(headingText, [/(?:Season\s*|S)(\d+)/i])) || 1,
                quality: getQualityFromText(headingText),
                size: sizeFromText(headingText),
                anchors: anchors
            });
        }
        return groups;
    }

    function selectSeriesIntermediateAnchors(group) {
        var anchors = (group && group.anchors || []).filter(function (anchor) {
            return anchor && anchor.href && !/batch|zip/i.test(String(anchor.text || ""));
        });
        var preferred = [];
        var i;
        for (i = 0; i < anchors.length; i++) {
            var value = String(anchors[i].text || "") + " " + String(anchors[i].href || "");
            if (/(?:G-?Direct|V-?Cloud|Episode|Download|File)/i.test(value)) {
                preferred.push(anchors[i]);
            }
        }
        return preferred.length ? uniqueBy(preferred, function (item) { return item.href; }) : uniqueBy(anchors, function (item) { return item.href; });
    }

    function sourceLabelFromAnchor(anchor) {
        var value = String((anchor && (anchor.href + " " + anchor.text)) || "");
        if (/vcloud/i.test(value)) return "V-Cloud";
        if (/fastdl|g-direct/i.test(value)) return "G-Direct";
        if (/gdtot/i.test(value)) return "GDToT";
        if (/filebee|direct-\[drive-link\]|direct-download/i.test(value)) return "FileBee";
        if (/filepress/i.test(value)) return "Filepress";
        if (/pixeldrain/i.test(value)) return "Pixeldrain";
        if (/hubcloud|hubdrive/i.test(value)) return "HubCloud";
        if (/dropgalaxy/i.test(value)) return "DropGalaxy";
        if (/uploadever/i.test(value)) return "Uploadever";
        return trim(anchor && anchor.text) || "Source";
    }

    function isUsefulNexdriveAnchor(anchor) {
        var href = String(anchor && anchor.href || "");
        var value = String((anchor && (href + " " + anchor.text)) || "");
        if (!/^https?:\/\//i.test(href)) return false;
        if (/#(?:content)?(?:$|[?#])/i.test(href)) return false;
        if (/vglist|xmlrpc|wp-json|wp-content|telegram|google\.com\/search|one\.one\.one\.one|tinyurl\.com\/Unblock|skip to content/i.test(value)) return false;
        return /vcloud|fastdl|g-direct|filebee|filepress|gdtot|drive|hubcloud|hubdrive|pixeldrain|dropgalaxy|uploadever/i.test(value);
    }

    function extractNexdriveSources(html, pageUrl, context) {
        var anchors = extractAnchors(html, pageUrl).filter(isUsefulNexdriveAnchor);
        return uniqueBy(anchors.map(function (anchor) {
            return {
                source: anchor.href,
                sourceName: sourceLabelFromAnchor(anchor),
                title: context && context.title || "",
                quality: (context && context.quality) || getQualityFromText(anchor.text + " " + anchor.href),
                size: (context && context.size) || sizeFromText(anchor.text),
                referer: pageUrl
            };
        }), function (item) { return item.source; });
    }

    function buildLoadPayload(sourceUrl, links, context) {
        return JSON.stringify({
            sourceUrl: sourceUrl,
            links: links || [],
            title: context && context.title || "",
            type: context && context.type || "movie",
            season: context && context.season || null,
            episode: context && context.episode || null
        });
    }

    async function extractMovieSources(html, pageUrl) {
        var groups = extractQualityGroups(html, pageUrl);
        var sources = [];
        for (var i = 0; i < groups.length; i++) {
            var group = groups[i];
            for (var j = 0; j < group.anchors.length; j++) {
                var anchor = group.anchors[j];
                if (!/dwd-button|Download/i.test(anchor.html + " " + anchor.text)) continue;
                try {
                    var linkPage = await getText(anchor.href, defaultHeaders({ "Referer": pageUrl }));
                    sources = sources.concat(extractNexdriveSources(linkPage.body, linkPage.finalUrl || anchor.href, {
                        title: group.title,
                        quality: group.quality,
                        size: group.size
                    }));
                } catch (_) {}
            }
        }
        return uniqueBy(sources, function (item) { return item.source; });
    }

    function extractEpisodeVcloudSources(html, pageUrl, context) {
        var out = [];
        var matchedEpisodes = false;
        var blockRe = /<h4\b[^>]*>([\s\S]*?)<\/h4>\s*<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var blockMatch;
        while ((blockMatch = blockRe.exec(String(html || ""))) !== null) {
            var headingText = stripTags(blockMatch[1] || "");
            var episode = Number(firstMatch(headingText, [/Episodes?\s*[:\-]?\s*0*([0-9]+)/i, /\bE(?:pisode)?\s*0*([0-9]+)/i])) || 0;
            if (!episode) continue;
            var anchors = extractAnchors(blockMatch[2] || "", pageUrl).filter(isUsefulNexdriveAnchor);
            if (!anchors.length) continue;
            matchedEpisodes = true;
            for (var i = 0; i < anchors.length; i++) {
                out.push({
                    episode: episode,
                    source: anchors[i].href,
                    sourceName: sourceLabelFromAnchor(anchors[i]),
                    title: context && context.title || "",
                    quality: context && context.quality || getQualityFromText(anchors[i].text + " " + anchors[i].href),
                    size: context && context.size || sizeFromText(anchors[i].text),
                    referer: pageUrl
                });
            }
        }

        if (matchedEpisodes) {
            return uniqueBy(out, function (item) { return String(item.episode) + "|" + item.source; });
        }

        var anchors = extractAnchors(html, pageUrl).filter(isUsefulNexdriveAnchor);
        var fallback = [];
        var episodeCounter = 0;
        for (var j = 0; j < anchors.length; j++) {
            if (!/vcloud|fastdl|g-direct|filebee|filepress|gdtot|drive|hubcloud|hubdrive|pixeldrain|dropgalaxy|uploadever/i.test(anchors[j].href + " " + anchors[j].text)) continue;
            episodeCounter++;
            fallback.push({
                episode: episodeCounter,
                source: anchors[j].href,
                sourceName: sourceLabelFromAnchor(anchors[j]),
                title: context && context.title || "",
                quality: context && context.quality || getQualityFromText(anchors[j].text + " " + anchors[j].href),
                size: context && context.size || sizeFromText(anchors[j].text),
                referer: pageUrl
            });
        }
        return fallback;
    }

    async function extractSeriesEpisodes(html, pageUrl, meta) {
        var groups = extractQualityGroups(html, pageUrl);
        var episodeLinksMap = {};
        for (var i = 0; i < groups.length; i++) {
            var group = groups[i];
            var anchors = selectSeriesIntermediateAnchors(group);
            for (var a = 0; a < anchors.length; a++) {
                var anchor = anchors[a];
                if (!anchor || !anchor.href) continue;
                try {
                    var linkPage = await getText(anchor.href, defaultHeaders({ "Referer": pageUrl }));
                    var episodeSources = extractEpisodeVcloudSources(linkPage.body, linkPage.finalUrl || anchor.href, {
                        title: group.title,
                        quality: group.quality,
                        size: group.size
                    });
                    for (var j = 0; j < episodeSources.length; j++) {
                        var item = episodeSources[j];
                        var key = String(group.season || 1) + "_" + String(item.episode || (j + 1));
                        if (!episodeLinksMap[key]) episodeLinksMap[key] = [];
                        episodeLinksMap[key].push(item);
                    }
                } catch (_) {}
            }
        }

        return Object.keys(episodeLinksMap).sort(function (a, b) {
            var aa = a.split("_");
            var bb = b.split("_");
            return Number(aa[0]) - Number(bb[0]) || Number(aa[1]) - Number(bb[1]);
        }).map(function (key) {
            var parts = key.split("_");
            var season = Number(parts[0]) || 1;
            var episode = Number(parts[1]) || 1;
            var episodeMeta = null;
            if (meta && Array.isArray(meta.videos)) {
                for (var i = 0; i < meta.videos.length; i++) {
                    if (Number(meta.videos[i].season) === season && Number(meta.videos[i].episode) === episode) {
                        episodeMeta = meta.videos[i];
                        break;
                    }
                }
            }
            return new Episode({
                name: episodeMeta && (episodeMeta.name || episodeMeta.title) || ("Episode " + episode),
                url: buildLoadPayload(pageUrl, uniqueBy(episodeLinksMap[key], function (item) { return item.source; }), {
                    title: meta && meta.name || "",
                    type: "series",
                    season: season,
                    episode: episode
                }),
                season: season,
                episode: episode,
                posterUrl: episodeMeta && episodeMeta.thumbnail || undefined,
                description: episodeMeta && episodeMeta.overview || undefined,
                headers: defaultHeaders({ "Referer": pageUrl })
            });
        });
    }

    function isDirectMediaUrl(url) {
        return /\.(?:m3u8|mp4|mkv|avi|mov|webm)(?:[?#]|$)/i.test(String(url || ""))
            || /\/api\/file\/.+\?download/i.test(String(url || ""))
            || /hub\.shipcdn\.|hubcdn\.fans|r2\.dev/i.test(String(url || ""));
    }

    async function resolveFinalUrl(startUrl, referer) {
        var currentUrl = startUrl;
        for (var i = 0; i < 7; i++) {
            try {
                var res = await request(currentUrl, {
                    method: "HEAD",
                    headers: defaultHeaders({ "Referer": referer || baseOrigin(currentUrl) + "/" }),
                    followRedirects: false
                });
                var location = res.headers.location || res.headers.Location || "";
                if (!location) return currentUrl;
                currentUrl = absoluteUrl(currentUrl, location);
            } catch (_) {
                return currentUrl;
            }
        }
        return currentUrl;
    }

    function extractVcloudJumpUrl(html, baseUrl) {
        var link = firstMatch(html, [
            /var\s+url\s*=\s*'([^']+)'/i,
            /var\s+url\s*=\s*"([^"]+)"/i,
            /<div\b[^>]*class=["'][^"']*\bvd\b[^"']*["'][^>]*>[\s\S]*?<center>[\s\S]*?<a\b[^>]+href=["']([^"']+)["']/i
        ]);
        return link ? absoluteUrl(baseUrl, link) : "";
    }

    function extractHubButtons(html, base) {
        var anchors = extractAnchors(html, base);
        return anchors.filter(function (anchor) {
            var value = anchor.text + " " + anchor.href + " " + anchor.attrs;
            if (/telegram|tutorial|admin|login|one\.one\.one\.one|tinyurl\.com\/Unblock/i.test(value)) return false;
            return /btn|FSL|Mega|Download File|BuzzServer|10Gbps|pixeldrain|hub\.shipcdn|hubcdn\.fans/i.test(value);
        });
    }

    function extractIntentDirectUrls(html) {
        var out = [];
        var re = /createIntentURL\(\{[\s\S]*?host:\s*(['"])(https?:\/\/[\s\S]*?)\1[\s\S]*?\}/gi;
        var match;
        while ((match = re.exec(String(html || ""))) !== null) {
            out.push(decodeHtml(match[2]).replace(/\\\//g, "/"));
        }
        return out;
    }

    function extractFastdlDirectUrl(html, pageUrl) {
        return absoluteUrl(pageUrl, firstMatch(html, [
            /var\s+reurl\s*=\s*"([^"]+)"/i,
            /var\s+reurl\s*=\s*'([^']+)'/i,
            /window\.location\s*=\s*reurl/i
        ]));
    }

    function extractHiddenContentLinks(html, pageUrl) {
        return extractAnchors(html, pageUrl).map(function (anchor) { return anchor.href; }).filter(function (href) {
            return /\/cdn-cgi\/content\?id=/i.test(String(href || ""));
        });
    }

    async function resolveFastdl(source, context) {
        var sourceUrl = typeof source === "string" ? source : source.source;
        var normalizedUrl = sourceUrl.replace(/fastdl\.zip\/embed\?(?=download=)/i, "fastdl.zip/embed.php?");
        var page = await getText(normalizedUrl, defaultHeaders({ "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }));
        var direct = extractFastdlDirectUrl(page.body, page.finalUrl || sourceUrl);
        if (!direct) return [];
        var quality = source.quality || getQualityFromText(source.title + " " + direct + " " + context.title);
        return [buildStreamResult(direct, source.sourceName || "G-Direct", {}, quality)];
    }

    async function resolveFilebee(source, context) {
        var sourceUrl = typeof source === "string" ? source : source.source;
        var page = await getText(sourceUrl, defaultHeaders({ "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }));
        var hiddenLinks = extractHiddenContentLinks(page.body, page.finalUrl || sourceUrl);
        var quality = source.quality || getQualityFromText(source.title + " " + sourceUrl + " " + context.title);
        if (hiddenLinks.length) {
            return hiddenLinks.map(function (link) {
                return buildStreamResult(link, source.sourceName || "FileBee", {}, quality);
            });
        }
        return [buildStreamResult(sourceUrl, source.sourceName || "FileBee", { "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }, quality)];
    }

    async function resolveVcloud(source, context) {
        var sourceUrl = typeof source === "string" ? source : source.source;
        var base = baseOrigin(sourceUrl);
        var latestBase = await getLatestBaseUrl(base, /hubcloud|gamerxyt/i.test(sourceUrl) ? "hubcloud" : "vcloud");
        var newUrl = base && latestBase && base !== latestBase ? sourceUrl.replace(base, latestBase) : sourceUrl;
        var entry = await getText(newUrl, defaultHeaders({ "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }));
        var jumpUrl = /gamerxyt\.com\/hubcloud\.php|hubcloud\./i.test(newUrl)
            ? newUrl
            : extractVcloudJumpUrl(entry.body, entry.finalUrl || newUrl);
        if (!jumpUrl) return [];

        var document = await getText(jumpUrl, defaultHeaders({ "Referer": entry.finalUrl || newUrl }));
        var header = stripTags(firstMatch(document.body, [/<div\b[^>]*class=["'][^"']*card-header[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]));
        var size = stripTags(firstMatch(document.body, [/<i\b[^>]*id=["']size["'][^>]*>([\s\S]*?)<\/i>/i]));
        var quality = source.quality || getQualityFromText(header + " " + size + " " + source.title + " " + context.title);
        var suffix = trim((header || source.title || "") + (size ? " [" + size + "]" : ""));
        var results = [];
        var buttons = extractHubButtons(document.body, document.finalUrl || jumpUrl);

        for (var i = 0; i < buttons.length; i++) {
            var button = buttons[i];
            var text = button.text;
            var link = button.href;
            if (!link) continue;

            if (/BuzzServer/i.test(text)) {
                try {
                    var buzzRes = await request(link.replace(/\/$/, "") + "/download", {
                        headers: defaultHeaders({ "Referer": link }),
                        followRedirects: false
                    });
                    var redirect = buzzRes.headers["hx-redirect"] || buzzRes.headers.location || "";
                    if (redirect) {
                        results.push(buildStreamResult(absoluteUrl(baseOrigin(link), redirect), "V-Cloud [BuzzServer]" + (suffix ? " " + suffix : ""), {}, quality));
                    }
                } catch (_) {}
                continue;
            }

            if (/pixeldra/i.test(link + " " + text)) {
                var pixelBase = baseOrigin(link);
                var pixelUrl = /download/i.test(link) ? link : pixelBase + "/api/file/" + link.split("/").pop() + "?download";
                results.push(buildStreamResult(pixelUrl, "V-Cloud [Pixeldrain]" + (suffix ? " " + suffix : ""), {}, quality));
                continue;
            }

            if (/Server\s*:\s*10Gbps/i.test(text)) {
                var redirectUrl = await resolveFinalUrl(link, document.finalUrl || jumpUrl);
                if (/link=/i.test(redirectUrl)) {
                    redirectUrl = decodeURIComponent(redirectUrl.substring(redirectUrl.indexOf("link=") + 5));
                }
                results.push(buildStreamResult(redirectUrl, "V-Cloud [Download]" + (suffix ? " " + suffix : ""), {}, quality));
                continue;
            }

            if (/FSLv2/i.test(text)) {
                results.push(buildStreamResult(link, "V-Cloud [FSLv2 Server]" + (suffix ? " " + suffix : ""), {}, quality));
            } else if (/FSL Server/i.test(text)) {
                results.push(buildStreamResult(link, "V-Cloud [FSL Server]" + (suffix ? " " + suffix : ""), {}, quality));
            } else if (/Mega Server/i.test(text)) {
                results.push(buildStreamResult(link, "V-Cloud [Mega Server]" + (suffix ? " " + suffix : ""), {}, quality));
            } else if (/Download File/i.test(text)) {
                results.push(buildStreamResult(link, "V-Cloud" + (suffix ? " " + suffix : ""), {}, quality));
            }
        }

        var directUrls = extractIntentDirectUrls(document.body);
        for (var j = 0; j < directUrls.length; j++) {
            results.push(buildStreamResult(directUrls[j], "V-Cloud [Direct]" + (suffix ? " " + suffix : ""), {}, quality));
        }

        return uniqueBy(results, function (item) { return item.url + "|" + item.source; });
    }

    async function resolveGenericSource(source, context) {
        var sourceUrl = typeof source === "string" ? source : source.source;
        var name = source.sourceName || "VegaMovies";
        var quality = source.quality || getQualityFromText(source.title + " " + sourceUrl + " " + context.title);
        try {
            if (/vcloud|gamerxyt\.com\/hubcloud\.php|hubcloud\./i.test(sourceUrl)) {
                var vcloud = await resolveVcloud(source, context);
                if (vcloud.length) return vcloud;
            }
            if (/fastdl\.zip\/embed/i.test(sourceUrl)) {
                var fastdl = await resolveFastdl(source, context);
                if (fastdl.length) return fastdl;
            }
            if (/filebee\.xyz|filepress/i.test(sourceUrl)) {
                var filebee = await resolveFilebee(source, context);
                if (filebee.length) return filebee;
            }
        } catch (_) {
            if (!/vcloud/i.test(sourceUrl)) {
                return [buildStreamResult(sourceUrl, name, { "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }, quality)];
            }
        }
        if (isDirectMediaUrl(sourceUrl)) {
            return [buildStreamResult(sourceUrl, name, { "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }, quality)];
        }
        return [buildStreamResult(sourceUrl, name, { "Referer": source.referer || context.sourceUrl || DEFAULT_BASE_URL + "/" }, quality)];
    }

    async function getHome(cb) {
        try {
            var mainUrl = await getMainUrl();
            var sections = {};
            for (var i = 0; i < HOME_SECTIONS.length; i++) {
                var section = HOME_SECTIONS[i];
                var pageUrl = absoluteUrl(mainUrl, section.path);
                try {
                    var res = await getText(pageUrl, defaultHeaders({ "Referer": mainUrl + "/" }));
                    var items = extractListingItems(res.body, res.finalUrl || pageUrl).slice(0, 24);
                    if (items.length) {
                        sections[section.title] = items.map(function (item) { return toMultimediaItem(item, res.finalUrl || pageUrl); });
                    }
                } catch (_) {}
            }
            cb({ success: true, data: sections });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var mainUrl = await getMainUrl();
            var url = mainUrl + "/search.php?q=" + encodeURIComponent(query || "") + "&page=1";
            var json = await getJson(url, defaultHeaders({ "Accept": "application/json,*/*", "Referer": mainUrl + "/" }));
            var hits = json && Array.isArray(json.hits) ? json.hits : [];
            var results = hits.map(function (hit) {
                var doc = hit && hit.document || {};
                var item = {
                    title: cleanTitle(doc.post_title || ""),
                    url: absoluteUrl(mainUrl, doc.permalink || ""),
                    posterUrl: doc.post_thumbnail || "",
                    type: mediaTypeFromText((doc.post_title || "") + " " + ((doc.category || []).join ? doc.category.join(" ") : "")),
                    quality: getQualityFromText(doc.post_title || "")
                };
                return toMultimediaItem(item, mainUrl + "/");
            }).filter(function (item) { return item && item.title && item.url; });
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var pageUrl = await fixUrl(url);
            var res = await getText(pageUrl, defaultHeaders({ "Referer": (await getMainUrl()) + "/" }));
            pageUrl = res.finalUrl || pageUrl;
            var html = res.body;
            var title = cleanTitle(firstMatch(html, [/<h1\b[^>]*>([\s\S]*?)<\/h1>/i, /<title\b[^>]*>([\s\S]*?)<\/title>/i])) || "Unknown";
            var imdbUrl = extractImdbUrl(html);
            var type = /Series-SYNOPSIS\/PLOT|Series Info|Series synopsis\/PLOT/i.test(html) || mediaTypeFromText(title) === "series" ? "series" : "movie";
            var poster = extractMetaContent(html, "og:image")
                || absoluteUrl(pageUrl, firstMatch(html, [/<p\b[^>]*>\s*<img\b[^>]*(?:data-src|src)=["']([^"']+)["'][\s\S]*?<\/p>/i]));
            var description = extractSynopsis(html);
            var meta = await fetchCinemeta(type, imdbUrl);

            if (meta) {
                title = meta.name || title;
                description = meta.description || description;
                poster = meta.poster || poster;
            }
            var bannerUrl = meta && meta.background || poster;
            var year = meta && meta.year ? Number(String(meta.year).split(/[^\d]/)[0]) : undefined;
            var score = meta && meta.imdbRating ? Number(meta.imdbRating) : undefined;

            if (type === "movie") {
                var movieSources = await extractMovieSources(html, pageUrl);
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: title,
                        url: pageUrl,
                        posterUrl: poster || undefined,
                        bannerUrl: bannerUrl || undefined,
                        type: "movie",
                        description: description || undefined,
                        year: year || undefined,
                        score: score || undefined,
                        headers: defaultHeaders({ "Referer": pageUrl }),
                        episodes: [
                            new Episode({
                                name: "Movie",
                                url: buildLoadPayload(pageUrl, movieSources, {
                                    title: title,
                                    type: "movie",
                                    season: 1,
                                    episode: 1
                                }),
                                season: 1,
                                episode: 1,
                                posterUrl: poster || undefined,
                                description: description || undefined,
                                headers: defaultHeaders({ "Referer": pageUrl })
                            })
                        ]
                    })
                });
                return;
            }

            var episodes = await extractSeriesEpisodes(html, pageUrl, meta);
            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: pageUrl,
                    posterUrl: poster || undefined,
                    bannerUrl: bannerUrl || undefined,
                    type: "series",
                    description: description || undefined,
                    year: year || undefined,
                    score: score || undefined,
                    headers: defaultHeaders({ "Referer": pageUrl }),
                    episodes: episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    async function loadStreams(dataStr, cb) {
        try {
            var payload = parseJsonSafe(dataStr, null);
            if (Array.isArray(payload)) {
                payload = { sourceUrl: "", links: payload, title: "" };
            }
            if (!payload || !Array.isArray(payload.links)) {
                payload = {
                    sourceUrl: /^https?:\/\//i.test(String(dataStr || "")) ? String(dataStr) : "",
                    links: /^https?:\/\//i.test(String(dataStr || "")) ? [{ source: String(dataStr), sourceName: "VegaMovies" }] : [],
                    title: ""
                };
            }

            var streams = [];
            for (var i = 0; i < payload.links.length; i++) {
                try {
                    var resolved = await resolveGenericSource(payload.links[i], payload);
                    streams = streams.concat(resolved);
                } catch (_) {}
            }

            streams = uniqueBy(streams, function (item) { return item.url + "|" + item.source; }).sort(function (a, b) {
                return Number(b.quality || 0) - Number(a.quality || 0);
            });
            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
