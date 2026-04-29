(function () {
    "use strict";

    var DEFAULT_BASE_URL = "https://new1.movies4u.style";
    var DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    var TMDB_WORKER_API = "https://api.themoviedb.org/3";
    var TMDB_IMAGE_BASE = "https://image.tmdb.org/t/p/original";
    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_LOGO_API_KEY = "98ae14df2b8d8f8f8136499daf79f0e0";
    var runtimeManifest = (typeof manifest !== "undefined" && manifest) ? manifest : { baseUrl: DEFAULT_BASE_URL };
    var domainCache = null;
    var gdflixDomainCache = null;
    var urlCache = {};
    var CACHE_TTL = 300000;

    var MAIN_PAGE_SECTIONS = [
        { path: "", title: "Home" },
        { path: "category/bollywood/", title: "BollyWood" },
        { path: "category/hollywood/", title: "HollyWood" },
        { path: "category/web-series/", title: "WEB-Series" },
        { path: "category/anime/", title: "Anime / Animation" },
        { path: "category/k-drama/", title: "K-Drama" },
        { path: "category/south-hindi-movies/", title: "South Hindi Movies" }
    ];

    function toErrorMessage(error) {
        return String(error && (error.stack || error.message) || error);
    }

    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function decodeHtmlEntities(value) {
        return trim(String(value || "")
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">"));
    }

    function stripTags(value) {
        return decodeHtmlEntities(String(value || "").replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "));
    }

    function snippet(value, max) {
        return trim(stripTags(String(value || ""))).slice(0, max || 280);
    }

    function escapeRegExp(value) {
        return String(value || "").replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function firstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return trim(match[1]);
        }
        return "";
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            try {
                var text = String(value || "").replace(/^'+|'+$/g, "").replace(/^"+|"+$/g, "");
                return JSON.parse(text);
            } catch (_) {
                return fallback;
            }
        }
    }

    function absoluteUrl(base, path) {
        if (!path) return String(base || "");
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function normalizeBaseUrl(url) {
        return String(url || "").replace(/\/+$/g, "");
    }

    function baseOrigin(url) {
        try {
            var parsed = new URL(url);
            return parsed.protocol + "//" + parsed.host;
        } catch (_) {
            return "";
        }
    }

    function decodeQueryParam(url, name) {
        try {
            return new URL(url).searchParams.get(name) || "";
        } catch (_) {
            return "";
        }
    }

    function safeDecodeURIComponent(value) {
        try {
            return decodeURIComponent(String(value || ""));
        } catch (_) {
            return String(value || "");
        }
    }

    function decodeBase64Safe(value) {
        var input = String(value || "").trim();
        if (!input) return "";
        var normalized = input.replace(/-/g, "+").replace(/_/g, "/");
        while (normalized.length % 4) normalized += "=";

        try {
            if (typeof atob === "function") return atob(normalized);
        } catch (_) {}

        try {
            if (typeof Buffer !== "undefined") return Buffer.from(normalized, "base64").toString("utf8");
        } catch (_) {}

        return "";
    }

    function getQualityFromText(text) {
        var lower = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b|\buhd\b|\bds4k\b/.test(lower)) return 2160;
        if (/\b1440p\b|\bqhd\b/.test(lower)) return 1440;
        if (/\b1080p\b|\bfullhd\b/.test(lower)) return 1080;
        if (/\b720p\b/.test(lower)) return 720;
        if (/\b576p\b/.test(lower)) return 576;
        if (/\b480p\b/.test(lower)) return 480;
        if (/\b360p\b/.test(lower)) return 360;
        return 0;
    }

    function getSearchQuality(text) {
        var value = String(text || "").toLowerCase();
        if (/\b(4k|ds4k|uhd|2160p)\b/.test(value)) return "4K";
        if (/\b(hdts|hdcam|hdtc)\b/.test(value)) return "HD Cam";
        if (/\b(camrip|cam-rip)\b/.test(value)) return "Cam Rip";
        if (/\bcam\b/.test(value)) return "Cam";
        if (/\b(web-dl|webrip|webdl)\b/.test(value)) return "WebRip";
        if (/\b(bluray|bdrip|blu-ray)\b/.test(value)) return "BluRay";
        if (/\b(1080p|fullhd|hdrip|hdtv)\b/.test(value)) return "HD";
        if (/\b720p\b/.test(value)) return "SD";
        if (/\bdvd\b/.test(value)) return "DVD";
        if (/\bhq\b/.test(value)) return "HQ";
        return undefined;
    }

    function inferTypeFromTitle(text) {
        var value = String(text || "");
        if (/anime/i.test(value)) return "anime";
        if (/season|series/i.test(value)) return "series";
        return "movie";
    }

    function normalizeTitle(text) {
        return trim(String(text || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/[^a-z0-9]+/g, " "));
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

    function request(url, options) {
        options = options || {};
        var method = options.method || "GET";
        var headers = options.headers || {};
        var body = options.body;
        var allowRedirects = options.allowRedirects !== false;
        var timeout = options.timeout || 20000;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                return {
                    status: res && typeof res.status !== "undefined" ? res.status : 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            return Promise.resolve(http_post(url, body, headers)).then(function (res) {
                return {
                    status: res && typeof res.status !== "undefined" ? res.status : 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            });
        }

        if (typeof fetch === "function") {
            var controller = typeof AbortController !== "undefined" ? new AbortController() : null;
            var timer = null;
            var fetchOptions = {
                method: method,
                headers: headers,
                body: body,
                redirect: allowRedirects ? "follow" : "manual"
            };
            if (controller) fetchOptions.signal = controller.signal;

            var fetchPromise = fetch(url, fetchOptions).then(function (res) {
                return res.text().then(function (bodyText) {
                    return {
                        status: res.status,
                        body: bodyText,
                        headers: parseHeaders(res.headers),
                        finalUrl: res.url || url
                    };
                });
            });

            if (controller) {
                timer = setTimeout(function () {
                    try { controller.abort(); } catch (_) {}
                }, timeout);

                return fetchPromise.then(function (result) {
                    clearTimeout(timer);
                    return result;
                }).catch(function (error) {
                    clearTimeout(timer);
                    throw error;
                });
            }

            return Promise.race([
                fetchPromise,
                new Promise(function (_, reject) {
                    timer = setTimeout(function () {
                        reject(new Error("Request timeout after " + timeout + "ms"));
                    }, timeout);
                })
            ]).then(function (result) {
                clearTimeout(timer);
                return result;
            }).catch(function (error) {
                clearTimeout(timer);
                throw error;
            });
        }

        if (typeof axios !== "undefined" && axios) {
            return axios({
                url: url,
                method: method,
                headers: headers,
                data: body,
                proxy: false,
                timeout: options.timeout || 20000,
                maxRedirects: allowRedirects ? 5 : 0,
                responseType: "text",
                transformResponse: [function (data) { return data; }],
                validateStatus: function () { return true; }
            }).then(function (res) {
                return {
                    status: res.status,
                    body: typeof res.data === "string" ? res.data : JSON.stringify(res.data),
                    headers: parseHeaders(res.headers),
                    finalUrl: (res.request && res.request.res && res.request.res.responseUrl) || url
                };
            });
        }

        throw new Error("No HTTP client available in runtime");
    }

    function getText(url, headers, allowRedirects) {
        var now = Date.now();
        if (urlCache[url] && (now - urlCache[url].time) < CACHE_TTL) {
            return Promise.resolve(urlCache[url].body);
        }
        return request(url, { headers: headers, allowRedirects: allowRedirects, timeout: 15000 }).then(function (res) {
            var body = res.body || "";
            urlCache[url] = { body: body, time: now };
            return body;
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers }).then(function (res) {
            return parseJsonSafe(res.body, {});
        });
    }

    function postForm(url, form, headers, allowRedirects) {
        var body = [];
        for (var key in form) {
            if (!Object.prototype.hasOwnProperty.call(form, key)) continue;
            body.push(encodeURIComponent(key) + "=" + encodeURIComponent(form[key]));
        }
        return request(url, {
            method: "POST",
            body: body.join("&"),
            headers: Object.assign({
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, headers || {}),
            allowRedirects: allowRedirects
        });
    }

    function defaultHeaders(extra) {
        return Object.assign({
            "Cookie": "xla=s4t",
            "User-Agent": "Mozilla/5.0"
        }, extra || {});
    }

    function pageHeaders(mainUrl) {
        return defaultHeaders({ "Referer": mainUrl + "/" });
    }

    function mainPageHeaders(mainUrl) {
        return pageHeaders(mainUrl);
    }

    function isPlaceholderBaseUrl(url) {
        return /(?:^|\/\/)(?:www\.)?example\.com(?:\/|$)/i.test(String(url || ""));
    }

    function looksLikeMediaListing(html) {
        var source = String(html || "");
        return /<article\b[^>]*class=["'][^"']*(?:entry-card|post|hentry)[^"']*["']/i.test(source)
            || /<h[23]\b[^>]*class=["'][^"']*entry-title[^"']*["']/i.test(source);
    }

    function validateMainUrl(candidate) {
        var url = normalizeBaseUrl(candidate);
        if (!/^https?:\/\//i.test(url) || isPlaceholderBaseUrl(url)) return Promise.resolve("");

        return getText(url + "/", pageHeaders(url), true).then(function (html) {
            return looksLikeMediaListing(html) ? url : "";
        }).catch(function () {
            return "";
        });
    }

    function parseAnchors(html, base) {
        var source = String(html || "");
        var out = [];
        var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = regex.exec(source))) {
            out.push({
                href: absoluteUrl(base, decodeHtmlEntities(match[1])),
                text: stripTags(match[2])
            });
        }
        return out;
    }

    function extractBlocks(html, tagName) {
        var blocks = [];
        var regex = new RegExp("<" + tagName + "\\b[\\s\\S]*?<\\/" + tagName + ">", "gi");
        var match;
        while ((match = regex.exec(String(html || "")))) {
            blocks.push(match[0]);
        }
        return blocks;
    }

    function getImageFromBlock(block, base) {
        var img = firstMatch(block, [
            /<img\b[^>]*src=["']([^"']+)["']/i,
            /<img\b[^>]*data-src=["']([^"']+)["']/i
        ]);
        return img ? absoluteUrl(base, img) : "";
    }

    function getMainUrl() {
        if (domainCache) return Promise.resolve(domainCache);

        return getJson(DOMAINS_URL, defaultHeaders()).catch(function () {
            return {};
        }).then(function (json) {
            var candidates = uniqueBy([
                runtimeManifest.baseUrl,
                DEFAULT_BASE_URL,
                json && json.movies4u
            ].map(normalizeBaseUrl).filter(Boolean), function (item) {
                return item;
            });

            var current = Promise.resolve("");
            for (var i = 0; i < candidates.length; i++) {
                (function (candidate) {
                    current = current.then(function (resolved) {
                        if (resolved) return resolved;
                        return validateMainUrl(candidate);
                    });
                })(candidates[i]);
            }

            return current.then(function (resolved) {
                domainCache = resolved || normalizeBaseUrl(runtimeManifest.baseUrl) || DEFAULT_BASE_URL;
                return domainCache;
            });
        });
    }

    function getLatestGdflixUrl() {
        if (gdflixDomainCache) return Promise.resolve(gdflixDomainCache);
        return getJson("https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json", defaultHeaders()).then(function (json) {
            gdflixDomainCache = (json && json.gdflix) || "https://*.gdflix.*";
            return gdflixDomainCache;
        }).catch(function () {
            gdflixDomainCache = "https://*.gdflix.*";
            return gdflixDomainCache;
        });
    }

    function parseSearchCard(block, base, defaultType) {
        var href = firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<h3\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i
        ]);
        if (!href) return null;

        var rawTitle = firstMatch(block, [
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<h3\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i
        ]);
        rawTitle = stripTags(rawTitle);
        if (!rawTitle) return null;

        var cleanTitle = trim(rawTitle.split(" (")[0]);
        if (!cleanTitle) cleanTitle = rawTitle;
        var yearMatch = rawTitle.match(/\((\d{4})\)/);
        var langMatch = rawTitle.match(/\[([^\]]+)\]/);
        var fullTitle = cleanTitle;
        if (yearMatch) fullTitle += " (" + yearMatch[1] + ")";
        if (langMatch && trim(langMatch[1])) fullTitle += " [" + trim(langMatch[1]) + "]";

        return new MultimediaItem({
            title: fullTitle,
            url: absoluteUrl(base, href),
            posterUrl: getImageFromBlock(block, base),
            type: defaultType || inferTypeFromTitle(rawTitle),
            quality: getSearchQuality(rawTitle),
            headers: defaultHeaders({ "Referer": base + "/" })
        });
    }

    function parseSearchResults(html, base, defaultType) {
        return extractBlocks(html, "article").map(function (block) {
            return parseSearchCard(block, base, defaultType);
        }).filter(Boolean);
    }

    function parseHomeResults(html, base) {
        return extractBlocks(html, "article").map(function (block) {
            var href = firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
                /<h2\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i
            ]);
            var rawTitle = stripTags(firstMatch(block, [
                /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<h2\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i
            ]));
            if (!href || !rawTitle) return null;

            var title = trim(rawTitle.split(" (")[0]);
            var year = rawTitle.match(/\((\d{4})\)/);
            var lang = rawTitle.match(/\[([^\]]+)\]/);
            var fullTitle = title;
            if (year) fullTitle += " (" + year[1] + ")";
            if (lang && trim(lang[1])) fullTitle += " [" + trim(lang[1]) + "]";

            return new MultimediaItem({
                title: fullTitle,
                url: absoluteUrl(base, href),
                posterUrl: getImageFromBlock(block, base),
                type: inferTypeFromTitle(rawTitle),
                quality: getSearchQuality(rawTitle),
                headers: defaultHeaders()
            });
        }).filter(Boolean);
    }

    function parseSearchResultsKotlin(html, base) {
        return parseSearchResults(html, base);
    }

    function extractMetaContent(html, propertyName) {
        var pattern = new RegExp("<meta\\b[^>]*(?:property|name)=[\"']" + escapeRegExp(propertyName) + "[\"'][^>]*content=[\"']([^\"']+)[\"']", "i");
        return decodeHtmlEntities(firstMatch(html, [pattern]));
    }

    function extractBetweenMarkers(html, startPattern, endPattern) {
        var source = String(html || "");
        var startMatch = source.match(startPattern);
        if (!startMatch || typeof startMatch.index !== "number") return "";
        var startIndex = startMatch.index + startMatch[0].length;
        var rest = source.slice(startIndex);
        var endMatch = rest.match(endPattern);
        if (!endMatch || typeof endMatch.index !== "number") return rest;
        return rest.slice(0, endMatch.index);
    }

    function extractDownloadLinks(html, base) {
        var section = extractBetweenMarkers(
            html,
            /<div\b[^>]*class=["'][^"']*downloads-btns-div[^"']*["'][^>]*>/i,
            /<\/div>/i
        );
        var links = parseAnchors(section, base).map(function (item) { return item.href; }).filter(Boolean);
        if (links.length) return links;

        var buttonLinks = [];
        var buttonRegex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>(?:(?!<\/a>)[\s\S])*?<button\b[^>]*class=["'][^"']*dwd-button[^"']*["'][^>]*>/gi;
        var buttonMatch;
        while ((buttonMatch = buttonRegex.exec(String(html || "")))) {
            buttonLinks.push(absoluteUrl(base, decodeHtmlEntities(buttonMatch[1])));
        }
        if (buttonLinks.length) return uniqueBy(buttonLinks, function (item) { return item; });

        return uniqueBy(parseAnchors(html, base).filter(function (item) {
            var href = String(item && item.href || "");
            var text = String(item && item.text || "");
            if (!/^https?:\/\//i.test(href)) return false;
            if (baseOrigin(href) === baseOrigin(base)) return false;
            if (/t\.me|telegram|hianime|fuckmaza|how-to-download/i.test(href)) return false;
            return /download|watch|server|drive|cloud|direct|gdflix|hubcloud|filepress|filebee|pixeldrain|gofile|m4ulinks|mdrive/i.test(text + " " + href);
        }).map(function (item) {
            return item.href;
        }), function (item) {
            return item;
        });
    }

    function extractStoryline(html) {
        var regex = /<h3\b[^>]*class=["'][^"']*movie-title[^"']*["'][^>]*>([\s\S]*?)<\/h3>\s*<p\b[^>]*>([\s\S]*?)<\/p>/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            if (stripTags(match[1]).toLowerCase().indexOf("storyline") !== -1) {
                return stripTags(match[2]);
            }
        }
        return "";
    }

    function extractPrimaryHeading(html) {
        return stripTags(firstMatch(html, [
            /<div\b[^>]*class=["'][^"']*single-service-content[^"']*["'][^>]*>[\s\S]*?<h1\b[^>]*>([\s\S]*?)<\/h1>/i
        ]));
    }

    function extractImdbId(html) {
        var href = firstMatch(html, [
            /<a\b[^>]*href=["']https?:\/\/(?:www\.)?imdb\.com\/title\/([^\/"']+)\/?["']/i
        ]);
        return href ? href.split("/")[0] : "";
    }

    function getSeasonSections(html, base) {
        var section = extractBetweenMarkers(
            html,
            /<div\b[^>]*class=["'][^"']*download-links-div[^"']*["'][^>]*>/i,
            /<\/article>|<\/section>/i
        );
        if (!section) section = html;

        var out = [];
        var regex = /<h4\b[^>]*>([\s\S]*?)<\/h4>([\s\S]*?)(?=<h4\b|$)/gi;
        var match;
        while ((match = regex.exec(section))) {
            var title = stripTags(match[1]);
            var seasonMatch = title.match(/Season\s*(\d+)/i);
            if (!seasonMatch) continue;
            out.push({
                season: Number(seasonMatch[1]),
                links: parseAnchors(match[2], base)
                    .filter(function (item) { return !/zip/i.test(String(item && item.text || "")); })
                    .map(function (item) { return item.href; })
                    .filter(Boolean)
            });
        }

        return out;
    }

    function getEpisodeBlocks(html, base) {
        var blocks = [];
        var regex = /<h5\b[^>]*>([\s\S]*?)<\/h5>([\s\S]*?)(?=<h5\b|$)/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var title = stripTags(match[1]);
            var episodeMatch = title.match(/Episodes:\s*(\d+)/i);
            if (!episodeMatch) continue;
            blocks.push({
                episode: Number(episodeMatch[1]),
                links: parseAnchors(match[2], base).map(function (item) { return item.href; }).filter(Boolean)
            });
        }
        return blocks;
    }

    function fetchTmdbJson(path) {
        return getJson(path, defaultHeaders()).catch(function () { return {}; });
    }

    function fetchTmdbLogoUrl(type, tmdbId) {
        if (!tmdbId) return Promise.resolve("");
        var route = type === "movie" ? "movie" : "tv";
        return fetchTmdbJson(TMDB_API + "/" + route + "/" + tmdbId + "/images?api_key=" + TMDB_LOGO_API_KEY).then(function (json) {
            var logos = (json && json.logos) || [];
            var best = null;
            var bestSvg = null;
            for (var i = 0; i < logos.length; i++) {
                var logo = logos[i];
                if (!logo || !logo.file_path) continue;
                var isSvg = /\.svg$/i.test(logo.file_path);
                if ((logo.iso_639_1 || "").toLowerCase() === "en" && !isSvg) return "https://image.tmdb.org/t/p/w500" + logo.file_path;
                if ((logo.iso_639_1 || "").toLowerCase() === "en" && isSvg && !bestSvg) bestSvg = logo;
                if (!best || Number(logo.vote_average || 0) > Number(best.vote_average || 0)) {
                    if (isSvg) bestSvg = logo;
                    else best = logo;
                }
            }
            if (best) return "https://image.tmdb.org/t/p/w500" + best.file_path;
            if (bestSvg) return "https://image.tmdb.org/t/p/w500" + bestSvg.file_path;
            return "";
        });
    }

    function findTmdbId(imdbId, type, title) {
        var mediaType = type === "movie" ? "movie" : "tv";
        if (imdbId) {
            return fetchTmdbJson(TMDB_WORKER_API + "/find/" + imdbId + "?api_key=" + TMDB_WORKER_API_KEY + "&external_source=imdb_id").then(function (json) {
                var results = type === "movie" ? json.movie_results : json.tv_results;
                if (results && results[0] && results[0].id) return String(results[0].id);
                return "";
            }).catch(function () { return ""; });
        }

        return fetchTmdbJson(TMDB_WORKER_API + "/search/" + mediaType + "?api_key=" + TMDB_WORKER_API_KEY + "&query=" + encodeURIComponent(title || "")).then(function (json) {
            return json && json.results && json.results[0] && json.results[0].id ? String(json.results[0].id) : "";
        }).catch(function () { return ""; });
    }

    function fetchTmdbDetails(type, tmdbId) {
        if (!tmdbId) return Promise.resolve({});
        var mediaType = type === "movie" ? "movie" : "tv";
        return fetchTmdbJson(TMDB_WORKER_API + "/" + mediaType + "/" + tmdbId + "?api_key=" + TMDB_WORKER_API_KEY + "&append_to_response=credits");
    }

    function fetchSeasonMetadata(tmdbId, season) {
        if (!tmdbId || !season) return Promise.resolve({});
        return fetchTmdbJson(TMDB_WORKER_API + "/tv/" + tmdbId + "/season/" + season + "?api_key=" + TMDB_WORKER_API_KEY).then(function (json) {
            var out = {};
            var episodes = json && json.episodes || [];
            for (var i = 0; i < episodes.length; i++) {
                var episode = episodes[i];
                if (!episode || !episode.episode_number) continue;
                out[String(season) + "_" + String(episode.episode_number)] = {
                    title: episode.name || "",
                    overview: episode.overview || "",
                    thumbnail: episode.still_path ? (TMDB_IMAGE_BASE + episode.still_path) : "",
                    released: episode.air_date || "",
                    rating: Number(episode.vote_average || 0)
                };
            }
            return out;
        }).catch(function () {
            return {};
        });
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

    function buildStreamResult(url, source, headers, quality) {
        return new StreamResult({
            url: url,
            source: quality ? (source + " [" + quality + "p]") : source,
            quality: quality || undefined,
            headers: headers || {}
        });
    }

    function buildActorList(castArray) {
        var cast = [];
        for (var i = 0; i < (castArray || []).length; i++) {
            var item = castArray[i];
            if (!item || !(item.name || item.original_name)) continue;
            cast.push(new Actor({
                name: item.name || item.original_name,
                role: item.character || "",
                image: item.profile_path ? (TMDB_IMAGE_BASE + item.profile_path) : undefined
            }));
        }
        return cast;
    }

    function isDirectMediaUrl(url) {
        return /\.(m3u8|mp4|mkv|avi|mov|webm)(?:[?#]|$)/i.test(String(url || ""))
            || /\/api\/file\/.+\?download/i.test(String(url || ""))
            || /gofile\.io\/download/i.test(String(url || ""));
    }

    function looksLikeGoogleDriveUrl(url) {
        return /(?:drive|docs)\.google\.com|googleusercontent\.com/i.test(String(url || ""));
    }

    function isUsableStreamUrl(url) {
        var value = String(url || "");
        if (!/^https?:\/\//i.test(value)) return false;
        if (/gpdl\.hubcdn\.fans|tinyurl\.com\/Unblock-Ban-Site|one\.one\.one\.one|\/cdn-cgi\/challenge-platform\//i.test(value)) return false;
        if (isDirectMediaUrl(value)) return true;
        if (/hub\.hailmary\.lat\/[a-f0-9]+\?token=/i.test(value)) return true;
        if (/pixeldrain\.(dev|com)\/api\/file\//i.test(value)) return true;
        if (/hubcloud\.|hubdrive\./i.test(value)) return true;
        if (/filepress\.|filebee/i.test(value)) return true;
        if (looksLikeGoogleDriveUrl(value)) return true;
        if (/mdrive\.ink\//i.test(value)) return true;
        if (/vcloud\.zip|fastdl\.zip/i.test(value)) return true;
        return false;
    }

    function isInterestingExtractorUrl(url) {
        var value = String(url || "");
        if (!value) return false;
        if (/\/cdn-cgi\/challenge-platform\//i.test(value)) return false;
        if (isDirectMediaUrl(value)) return true;
        if (looksLikeGoogleDriveUrl(value)) return true;
        return /hubcloud\.|hubdrive\.|gamerxyt\.com\/hubcloud\.php|gdfli?x|gdlink|gofile\.io|m4ulinks\.com|filesdl\.|filepress\.|filebee|pixeldrain|buzzserver|streamtape|mediafire\.com|1fichier\.com|mdrive\.ink\/|vcloud\.zip|fastdl\.zip/i.test(value);
    }

    function normalizeExtractedUrl(rawValue, base) {
        var value = String(rawValue || "");
        if (!value) return "";

        value = value
            .replace(/^[\s"'`(]+/, "")
            .replace(/[\s"'`),;]+$/, "")
            .replace(/\\u002F/gi, "/")
            .replace(/\\u003A/gi, ":")
            .replace(/\\u0026/gi, "&")
            .replace(/\\\//g, "/");

        value = decodeHtmlEntities(value);

        for (var i = 0; i < 2; i++) {
            var decoded = safeDecodeURIComponent(value);
            if (decoded === value) break;
            value = decoded;
        }

        if (/^\/\//.test(value)) value = "https:" + value;
        if (/^www\./i.test(value)) value = "https://" + value;
        if (/^(?:javascript|mailto|tel|data):/i.test(value) || /^#/.test(value)) return "";

        if (!/^https?:\/\//i.test(value) && base) {
            if (/^(?:\/|\.\/|\.\.\/|\?)/.test(value) || /^[a-z0-9][^:]*\/[^:]+/i.test(value)) {
                value = absoluteUrl(base, value);
            }
        }

        return String(value || "").replace(/&amp;/gi, "&");
    }

    function addExtractedUrl(out, seen, rawValue, base) {
        var queue = [];
        var initial = normalizeExtractedUrl(rawValue, base);
        if (initial) queue.push(initial);

        for (var index = 0; index < queue.length; index++) {
            var current = queue[index];
            var fingerprint = String(current || "");
            if (!fingerprint || seen[fingerprint]) continue;
            seen[fingerprint] = true;

            if (isInterestingExtractorUrl(fingerprint)) {
                out.push(fingerprint);
            }

            var paramNames = ["url", "link", "r", "redirect", "redirect_url", "target", "destination", "dest", "to", "file", "dl"];
            for (var i = 0; i < paramNames.length; i++) {
                var nested = decodeQueryParam(fingerprint, paramNames[i]);
                if (!nested) continue;
                nested = normalizeExtractedUrl(nested, base);
                if (nested && !seen[nested]) queue.push(nested);
                var decodedNested = decodeBase64Safe(nested);
                if (decodedNested && /https?:\/\//i.test(decodedNested) && !seen[decodedNested]) {
                    queue.push(decodedNested);
                }
            }

            if (/^[A-Za-z0-9+/_-]{24,}={0,2}$/.test(fingerprint) && !/^https?:\/\//i.test(fingerprint)) {
                var decoded = decodeBase64Safe(fingerprint);
                if (decoded && !seen[decoded]) queue.push(decoded);
            }
        }
    }

    function extractInterestingExtractorUrls(html, base) {
        var source = String(html || "");
        var out = [];
        var seen = {};

        parseAnchors(source, base).forEach(function (anchor) {
            addExtractedUrl(out, seen, anchor && anchor.href, base);
        });

        var regexes = [
            /https?:\/\/[^\s"'<>\\]+/gi,
            /(?:href|src|action)\s*=\s*["']([^"']+)["']/gi,
            /(?:window\.)?location(?:\.href)?\s*=\s*["']([^"']+)["']/gi,
            /location\.replace\(\s*["']([^"']+)["']/gi,
            /window\.open\(\s*["']([^"']+)["']/gi,
            /["']((?:https?:)?\/\/[^"'<>\\]+)["']/gi,
            /"(?:url|link|file|download(?:Url)?|source|redirect(?:Url)?)"\s*:\s*"([^"]+)"/gi,
            /'(?:url|link|file|download(?:Url)?|source|redirect(?:Url)?)'\s*:\s*'([^']+)'/gi,
            /atob\(\s*["']([A-Za-z0-9+/_-]{24,}={0,2})["']\s*\)/gi
        ];

        for (var i = 0; i < regexes.length; i++) {
            var regex = regexes[i];
            var match;
            while ((match = regex.exec(source))) {
                addExtractedUrl(out, seen, match[1] || match[0], base);
            }
        }

        var quotedBase64 = /["']([A-Za-z0-9+/_-]{40,}={0,2})["']/gi;
        var base64Match;
        while ((base64Match = quotedBase64.exec(source))) {
            var decoded = decodeBase64Safe(base64Match[1]);
            if (decoded && (/https?:\/\//i.test(decoded) || /hubcloud|filepress|filebee|drive\.google|gdfli?x|gofile|pixeldrain/i.test(decoded))) {
                addExtractedUrl(out, seen, decoded, base);
            }
        }

        return uniqueBy(out, function (item) { return item; });
    }

    function cleanHubTitle(title) {
        var normalized = String(title || "")
            .replace(/\.[a-zA-Z0-9]{2,4}$/, "")
            .replace(/WEB[-_. ]?DL/gi, "WEB-DL")
            .replace(/WEB[-_. ]?RIP/gi, "WEBRIP")
            .replace(/H[ .]?265/gi, "H265")
            .replace(/H[ .]?264/gi, "H264")
            .replace(/DDP[ .]?([0-9]\.[0-9])/gi, "DDP$1");

        var parts = normalized.split(/[\s._-]+/);
        var keep = {
            "WEB-DL": true, "WEBRIP": true, "BLURAY": true, "HDRIP": true, "DVDRIP": true, "HDTV": true,
            "CAM": true, "TS": true, "BRRIP": true, "BDRIP": true, "H264": true, "H265": true, "X264": true,
            "X265": true, "HEVC": true, "AVC": true, "AAC": true, "AC3": true, "DTS": true, "MP3": true,
            "FLAC": true, "DD": true, "DDP": true, "EAC3": true, "ATMOS": true, "SDR": true, "HDR": true,
            "HDR10": true, "HDR10+": true, "DV": true, "DOLBYVISION": true, "NF": true, "CR": true
        };

        var result = [];
        for (var i = 0; i < parts.length; i++) {
            var token = String(parts[i] || "").toUpperCase();
            if (!token) continue;
            if (keep[token]) result.push(token === "DV" ? "DOLBYVISION" : token);
            else if (/^DDP\d\.\d$/.test(token)) result.push(token);
        }

        return uniqueBy(result, function (item) { return item; }).join(" ");
    }

    function flattenResults(results) {
        var out = [];
        for (var i = 0; i < (results || []).length; i++) {
            out = out.concat(results[i] || []);
        }
        return out;
    }

    function resolveFilesdl(url) {
        return getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" })).then(function (html) {
            var qualityTitle = firstMatch(html, [/<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]);
            var quality = getQualityFromText(qualityTitle) || getQualityFromText(html);
            var anchors = parseAnchors(html, baseOrigin(url));
            return Promise.all(anchors.map(function (anchor) {
                var label = String(anchor.text || "").toLowerCase();
                if (/hubcloud/.test(label)) return resolveExtractorUrl(anchor.href, "Filmyfiy");
                if (/gdfli?x/.test(label)) return resolveExtractorUrl(anchor.href, "Filmyfiy");
                if (/gofile/.test(label)) return resolveExtractorUrl(anchor.href, "Filmyfiy");
                if (/direct download|ultra fastdl|fast cloud-02/.test(label)) {
                    return request(anchor.href, { headers: defaultHeaders(), allowRedirects: false }).then(function (res) {
                        var location = res.headers.location || anchor.href;
                        return [buildStreamResult(location, "Filmyfiy [Direct Download]", {}, quality)];
                    }).catch(function () {
                        return [buildStreamResult(anchor.href, "Filmyfiy [Direct Download]", {}, quality)];
                    });
                }
                if (/fast cloud/.test(label)) {
                    return Promise.resolve([buildStreamResult(anchor.href, "Filmyfiy [Fast Cloud]", {}, quality)]);
                }
                return Promise.resolve([]);
            })).then(flattenResults);
        });
    }

    function resolveM4ulinks(url) {
        return getText(url, defaultHeaders()).then(function (html) {
            var base = baseOrigin(url);
            var blocks = [];
            var regex = /<h4\b[^>]*>([\s\S]*?)<\/h4>([\s\S]*?)(?=<h4\b|$)/gi;
            var match;
            while ((match = regex.exec(html))) {
                blocks.push({
                    qualityLabel: stripTags(match[1]),
                    anchors: parseAnchors(match[2], base)
                });
            }
            if (!blocks.length) {
                blocks.push({
                    qualityLabel: "",
                    anchors: parseAnchors(html, base)
                });
            }
            return Promise.all(blocks.map(function (block) {
                return Promise.all((block.anchors || []).map(function (anchor) {
                    return resolveExtractorUrl(anchor.href, trim(block.qualityLabel || ""));
                })).then(flattenResults);
            })).then(flattenResults);
        });
    }

    function resolveHubCloud(url, refererLabel) {
        var ref = refererLabel || "HubCloud";
        var refHeaders = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        var hrefPromise = /hubcloud\.php/i.test(url)
            ? Promise.resolve(url)
            : getText(url, refHeaders).then(function (html) {
                var href = firstMatch(html, [
                    /id=["']download["'][^>]*href=["']([^"']+)["']/i,
                    /href=["']([^"']+)["'][^>]*id=["']download["']/i
                ]);
                return absoluteUrl(baseOrigin(url), href || url);
            });

        return hrefPromise.then(function (innerUrl) {
            return getText(innerUrl, refHeaders).then(function (html) {
                var size = stripTags(firstMatch(html, [/<i\b[^>]*id=["']size["'][^>]*>([\s\S]*?)<\/i>/i]));
                var header = stripTags(firstMatch(html, [/<div\b[^>]*class=["'][^"']*card-header[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]));
                var quality = getQualityFromText(header) || 2160;
                var extras = [];
                var clean = cleanHubTitle(header);
                if (clean) extras.push("[" + clean + "]");
                if (size) extras.push("[" + size + "]");
                var suffix = extras.join(" ");
                var anchors = parseAnchors(html, baseOrigin(innerUrl));

                return Promise.all(anchors.map(function (anchor) {
                    var label = String(anchor.text || "").toLowerCase();
                    if (/fsl server/.test(label)) return Promise.resolve([buildStreamResult(anchor.href, ref + " [FSL Server] " + suffix, {}, quality)]);
                    if (/download file/.test(label)) return Promise.resolve([buildStreamResult(anchor.href, ref + " " + suffix, {}, quality)]);
                    if (/buzzserver/.test(label)) {
                        return request(anchor.href.replace(/\/$/, "") + "/download", {
                            headers: defaultHeaders({ "Referer": anchor.href }),
                            allowRedirects: false
                        }).then(function (res) {
                            var redirectUrl = res.headers["hx-redirect"] || res.headers.location || anchor.href;
                            return [buildStreamResult(redirectUrl, ref + " [BuzzServer] " + suffix, {}, quality)];
                        }).catch(function () {
                            return [buildStreamResult(anchor.href, ref + " [BuzzServer] " + suffix, {}, quality)];
                        });
                    }
                    if (/pixeldra|pixelserver|pixel server|pixeldrain/.test(label)) {
                        var base = baseOrigin(anchor.href);
                        var finalUrl = /download/i.test(anchor.href)
                            ? anchor.href
                            : (base + "/api/file/" + anchor.href.split("/").pop() + "?download");
                        return Promise.resolve([buildStreamResult(finalUrl, ref + " Pixeldrain " + suffix, {}, quality)]);
                    }
                    if (/s3 server/.test(label)) return Promise.resolve([buildStreamResult(anchor.href, ref + " [S3 Server] " + suffix, {}, quality)]);
                    if (/fslv2/.test(label)) return Promise.resolve([buildStreamResult(anchor.href, ref + " [FSLv2] " + suffix, {}, quality)]);
                    if (/mega server/.test(label)) return Promise.resolve([buildStreamResult(anchor.href, ref + " [Mega Server] " + suffix, {}, quality)]);
                    return resolveExtractorUrl(anchor.href, "");
                })).then(flattenResults);
            });
        });
    }

    function resolveGofile(url) {
        var idMatch = String(url || "").match(/(?:\?c=|\/d\/)([\da-zA-Z-]+)/i);
        if (!idMatch) return Promise.resolve([]);
        var folderId = idMatch[1];

        return request("https://api.gofile.io/accounts", {
            method: "POST",
            body: "",
            headers: defaultHeaders()
        }).then(function (accountRes) {
            var accountJson = parseJsonSafe(accountRes.body, {});
            var token = accountJson && accountJson.data && accountJson.data.token;
            if (!token) return [];

            return getText("https://gofile.io/dist/js/global.js", defaultHeaders()).then(function (globalJs) {
                var wt = firstMatch(globalJs, [/appdata\.wt\s*=\s*["']([^"']+)["']/i]);
                if (!wt) return [];

                return getJson("https://api.gofile.io/contents/" + folderId + "?wt=" + encodeURIComponent(wt), {
                    "Authorization": "Bearer " + token,
                    "User-Agent": "Mozilla/5.0"
                }).then(function (json) {
                    var children = json && json.data && json.data.children || {};
                    var entries = [];
                    for (var key in children) {
                        if (!Object.prototype.hasOwnProperty.call(children, key)) continue;
                        var file = children[key];
                        if (!file || !file.link) continue;
                        entries.push(buildStreamResult(file.link, "Gofile", {
                            "Cookie": "accountToken=" + token
                        }, getQualityFromText(file.name || "")));
                    }
                    return entries;
                });
            });
        }).catch(function () {
            return [];
        });
    }

    function resolveGoogleDrive(url) {
        return Promise.resolve([buildStreamResult(url, "GDrive", {
            "Referer": "https://drive.google.com/"
        }, getQualityFromText(url))]);
    }

    function resolveFilepress(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });

        function resolveFilepressContent(contentUrl) {
            if (!contentUrl) return Promise.resolve([]);

            var contentHeaders = defaultHeaders({
                "Referer": url,
                "Origin": baseOrigin(url)
            });

            return request(contentUrl, {
                headers: contentHeaders,
                allowRedirects: false
            }).catch(function () {
                return { headers: {}, body: "", finalUrl: contentUrl };
            }).then(function (initialRes) {
                var redirectLocation = normalizeExtractedUrl(initialRes.headers.location || initialRes.headers["x-redirect-location"] || "", baseOrigin(contentUrl));
                if (redirectLocation && redirectLocation !== contentUrl) {
                    if (looksLikeGoogleDriveUrl(redirectLocation)) return resolveGoogleDrive(redirectLocation);
                    if (isDirectMediaUrl(redirectLocation)) {
                        return [buildStreamResult(redirectLocation, "Filepress", {}, getQualityFromText(redirectLocation))];
                    }
                    if (isInterestingExtractorUrl(redirectLocation)) {
                        return resolveExtractorUrl(redirectLocation, "Filepress");
                    }
                }

                return request(contentUrl, {
                    headers: contentHeaders,
                    allowRedirects: true
                }).catch(function () {
                    return initialRes;
                }).then(function (pageRes) {
                    var finalUrl = normalizeExtractedUrl(pageRes.finalUrl || contentUrl, baseOrigin(contentUrl)) || contentUrl;
                    if (looksLikeGoogleDriveUrl(finalUrl)) return resolveGoogleDrive(finalUrl);
                    if (isDirectMediaUrl(finalUrl)) {
                        return [buildStreamResult(finalUrl, "Filepress", {}, getQualityFromText(finalUrl))];
                    }

                    var pageBase = baseOrigin(finalUrl) || baseOrigin(contentUrl);
                    var candidates = extractInterestingExtractorUrls(pageRes.body || initialRes.body || "", pageBase).filter(function (candidate) {
                        return candidate && candidate !== url && candidate !== contentUrl && candidate !== finalUrl;
                    });

                    if (!candidates.length && finalUrl !== contentUrl && isInterestingExtractorUrl(finalUrl)) {
                        candidates.push(finalUrl);
                    }

                    if (!candidates.length) return [];

                    return Promise.all(candidates.map(function (candidate) {
                        if (looksLikeGoogleDriveUrl(candidate)) return resolveGoogleDrive(candidate);
                        return resolveExtractorUrl(candidate, "Filepress");
                    })).then(flattenResults);
                });
            });
        }

        return request(url, {
            headers: headers,
            allowRedirects: false
        }).catch(function () {
            return { headers: {}, body: "", finalUrl: url };
        }).then(function (initialRes) {
            var redirectLocation = normalizeExtractedUrl(initialRes.headers.location || initialRes.headers["x-redirect-location"] || "", baseOrigin(url));
            if (redirectLocation && redirectLocation !== url) {
                if (looksLikeGoogleDriveUrl(redirectLocation)) return resolveGoogleDrive(redirectLocation);
                if (isDirectMediaUrl(redirectLocation)) {
                    return [buildStreamResult(redirectLocation, "Filepress", {}, getQualityFromText(redirectLocation))];
                }
                if (isInterestingExtractorUrl(redirectLocation)) {
                    return resolveExtractorUrl(redirectLocation, "Filepress");
                }
            }

            return request(url, {
                headers: headers,
                allowRedirects: true
            }).catch(function () {
                return initialRes;
            }).then(function (pageRes) {
                var finalUrl = normalizeExtractedUrl(pageRes.finalUrl || url, baseOrigin(url)) || url;
                if (looksLikeGoogleDriveUrl(finalUrl)) return resolveGoogleDrive(finalUrl);
                if (isDirectMediaUrl(finalUrl)) {
                    return [buildStreamResult(finalUrl, "Filepress", {}, getQualityFromText(finalUrl))];
                }

                var pageBase = baseOrigin(finalUrl) || baseOrigin(url);
                var html = String(pageRes.body || initialRes.body || "");
                var candidates = extractInterestingExtractorUrls(html, pageBase).filter(function (candidate) {
                    return candidate && candidate !== url && candidate !== finalUrl;
                });

                var hiddenContentLinks = parseAnchors(html, pageBase).map(function (anchor) {
                    return anchor && anchor.href;
                }).filter(function (href) {
                    return /\/cdn-cgi\/content\?id=/i.test(String(href || ""));
                });

                for (var i = 0; i < hiddenContentLinks.length; i++) {
                    if (candidates.indexOf(hiddenContentLinks[i]) === -1) {
                        candidates.push(hiddenContentLinks[i]);
                    }
                }

                if (!candidates.length && finalUrl !== url && isInterestingExtractorUrl(finalUrl)) {
                    candidates.push(finalUrl);
                }

                if (!candidates.length) {
                    return [buildStreamResult(url, "Filepress [GDrive]", headers, getQualityFromText(url))];
                }

                return Promise.all(candidates.map(function (candidate) {
                    if (/\/cdn-cgi\/content\?id=/i.test(candidate)) {
                        return resolveFilepressContent(candidate);
                    }
                    if (looksLikeGoogleDriveUrl(candidate)) return resolveGoogleDrive(candidate);
                    return resolveExtractorUrl(candidate, "Filepress");
                })).then(flattenResults).then(function (results) {
                    if (results && results.length) return results;
                    return [buildStreamResult(url, "Filepress [GDrive]", headers, getQualityFromText(url))];
                });
            });
        });
    }

    function resolveDrivebot(link, fileName, fileSize, quality) {
        var id = decodeQueryParam(link, "id");
        var doId = (link.split("do=")[1] || "").split("==")[0];
        var bases = ["https://drivebot.sbs", "https://indexbot.site"];
        return Promise.all(bases.map(function (base) {
            var indexbotLink = base + "/download?id=" + id + "&do=" + doId;
            return request(indexbotLink, { headers: defaultHeaders(), allowRedirects: true }).then(function (res) {
                var html = res.body || "";
                var cookieHeader = res.headers["set-cookie"] || "";
                var phpsessidMatch = String(cookieHeader).match(/PHPSESSID=([^;]+)/i);
                var phpsessid = phpsessidMatch ? phpsessidMatch[1] : "";
                var token = firstMatch(html, [/formData\.append\('token', '([a-f0-9]+)'\)/i]);
                var postId = firstMatch(html, [/fetch\('\/download\?id=([a-zA-Z0-9/+]+)'/i]);
                if (!token || !postId) return [];
                return postForm(base + "/download?id=" + postId, { token: token }, {
                    "Referer": indexbotLink,
                    "Cookie": phpsessid ? ("PHPSESSID=" + phpsessid) : ""
                }, true).then(function (postRes) {
                    var downloadLink = firstMatch(postRes.body, [/url":"(.*?)"/i]).replace(/\\/g, "");
                    if (!downloadLink) return [];
                    return [buildStreamResult(downloadLink, "GDFlix[DriveBot] " + fileName + "[" + fileSize + "]", {
                        "Referer": base
                    }, quality)];
                });
            }).catch(function () {
                return [];
            });
        })).then(flattenResults);
    }

    function resolveGdflix(url) {
        return getLatestGdflixUrl().then(function (latestUrl) {
            var finalUrl = String(url || "").replace("https://*.gdflix.*", latestUrl);
            return getText(finalUrl, defaultHeaders()).then(function (html) {
                var fileName = stripTags(firstMatch(html, [/<li\b[^>]*class=["'][^"']*list-group-item[^"']*["'][^>]*>[\s\S]*?Name\s*:\s*([\s\S]*?)<\/li>/i]));
                var fileSize = stripTags(firstMatch(html, [/<li\b[^>]*class=["'][^"']*list-group-item[^"']*["'][^>]*>[\s\S]*?Size\s*:\s*([\s\S]*?)<\/li>/i]));
                var quality = getQualityFromText(fileName);
                var section = firstMatch(html, [/<div\b[^>]*class=["'][^"']*text-center[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]) || html;
                var anchors = parseAnchors(section, baseOrigin(finalUrl));

                return Promise.all(anchors.map(function (anchor) {
                    var text = String(anchor.text || "");
                    if (/DIRECT DL/.test(text)) {
                        return Promise.resolve([buildStreamResult(anchor.href, "GDFlix[Direct] " + fileName + "[" + fileSize + "]", {}, quality)]);
                    }
                    if (/CLOUD DOWNLOAD \[R2\]/.test(text)) {
                        var cloudUrl = decodeQueryParam(anchor.href, "url") || anchor.href;
                        return Promise.resolve([buildStreamResult(cloudUrl, "GDFlix[Cloud] " + fileName + "[" + fileSize + "]", {}, quality)]);
                    }
                    if (/pixeldra|pixel/i.test(text)) {
                        var base = baseOrigin(anchor.href);
                        var pixelUrl = /download/i.test(anchor.href) ? anchor.href : (base + "/api/file/" + anchor.href.split("/").pop() + "?download");
                        return Promise.resolve([buildStreamResult(pixelUrl, "GDFlix Pixeldrain " + fileName + "[" + fileSize + "]", {}, quality)]);
                    }
                    if (/Index Links/i.test(text)) {
                        var indexUrl = absoluteUrl(latestUrl, anchor.href);
                        return getText(indexUrl, defaultHeaders()).then(function (indexHtml) {
                            var btns = parseAnchors(indexHtml, baseOrigin(indexUrl));
                            return Promise.all(btns.map(function (btn) {
                                var serverUrl = absoluteUrl(latestUrl, btn.href);
                                return getText(serverUrl, defaultHeaders()).then(function (serverHtml) {
                                    return parseAnchors(serverHtml, baseOrigin(serverUrl)).filter(function (sourceAnchor) {
                                        return !!sourceAnchor.href && !/gdflix/i.test(sourceAnchor.href);
                                    }).map(function (sourceAnchor) {
                                        return buildStreamResult(sourceAnchor.href, "GDFlix[Index] " + fileName + "[" + fileSize + "]", {}, quality);
                                    });
                                });
                            })).then(flattenResults);
                        }).catch(function () {
                            return [];
                        });
                    }
                    if (/DRIVEBOT/i.test(text)) {
                        return resolveDrivebot(anchor.href, fileName, fileSize, quality);
                    }
                    if (/Instant DL/i.test(text)) {
                        return request(anchor.href, { headers: defaultHeaders(), allowRedirects: false }).then(function (res) {
                            var instantUrl = decodeQueryParam(res.headers.location || "", "url") || decodeQueryParam(anchor.href, "url") || anchor.href;
                            return [buildStreamResult(instantUrl, "GDFlix[Instant Download] " + fileName + "[" + fileSize + "]", {}, quality)];
                        }).catch(function () {
                            return [];
                        });
                    }
                    if (/GoFile/i.test(text)) {
                        return getText(anchor.href, defaultHeaders()).then(function (gofileHtml) {
                            var goAnchors = parseAnchors(gofileHtml, baseOrigin(anchor.href)).filter(function (item) {
                                return /gofile/i.test(item.href || "");
                            });
                            return Promise.all(goAnchors.map(function (goAnchor) {
                                return resolveGofile(goAnchor.href);
                            })).then(flattenResults);
                        }).catch(function () {
                            return [];
                        });
                    }
                    return Promise.resolve([]);
                })).then(flattenResults);
            });
        });
    }

    function resolveHubCloudWithFallback(url, refererLabel) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return resolveHubCloud(url, refererLabel).then(function (results) {
            if (results && results.length) return results;
            return [buildStreamResult(url, refererLabel || "HubCloud", headers, getQualityFromText(url))];
        }).catch(function () {
            return [buildStreamResult(url, refererLabel || "HubCloud", headers, getQualityFromText(url))];
        });
    }

    function resolveHubDrive(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return getText(url, headers, true).then(function (html) {
            var candidates = extractInterestingExtractorUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && !/hubdrive\./i.test(candidate);
            });
            if (!candidates.length) {
                return [buildStreamResult(url, "HubDrive", headers, getQualityFromText(url))];
            }
            return Promise.all(candidates.map(function (candidate) {
                return resolveExtractorUrl(candidate, "HubDrive");
            })).then(flattenResults).then(function (results) {
                return results && results.length ? results : [buildStreamResult(url, "HubDrive", headers, getQualityFromText(url))];
            });
        }).catch(function () {
            return [buildStreamResult(url, "HubDrive", headers, getQualityFromText(url))];
        });
    }

    function resolveVcloud(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return getText(url, headers).then(function (html) {
            var hubcloudMatch = html.match(/https:\/\/gamerxyt\.com\/hubcloud\.php\?host=vcloud[^"'\s]*/i);
            if (hubcloudMatch) {
                return resolveExtractorUrl(hubcloudMatch[0], "VCloud");
            }
            var candidates = extractInterestingExtractorUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && /hubcloud\.|gdflix\.|filepress\.|g-direct\.|drive\.google/i.test(candidate);
            });
            if (candidates.length) {
                return Promise.all(candidates.map(function (candidate) {
                    return resolveExtractorUrl(candidate, "VCloud");
                })).then(flattenResults);
            }
            return [];
        }).catch(function () {
            return [];
        });
    }

    function resolveFastdl(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return getText(url, headers).then(function (html) {
            var candidates = extractInterestingExtractorUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && /hubcloud\.|gdflix\.|filepress\.|g-direct\.|drive\.google|filebee/i.test(candidate);
            });
            if (candidates.length) {
                return Promise.all(candidates.map(function (candidate) {
                    return resolveExtractorUrl(candidate, "FastDL");
                })).then(flattenResults);
            }
            return [];
        }).catch(function () {
            return [];
        });
    }

    function resolveMdrive(url) {
        var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
        return request(url, {
            headers: headers,
            allowRedirects: false
        }).catch(function () {
            return { headers: {}, body: "", finalUrl: url };
        }).then(function (initialRes) {
            var redirectLocation = normalizeExtractedUrl(initialRes.headers.location || initialRes.headers["x-redirect-location"] || "", baseOrigin(url));
            if (redirectLocation && /^https?:\/\//i.test(redirectLocation) && redirectLocation !== url) {
                return resolveExtractorUrl(redirectLocation, "MDrive");
            }

            return request(url, {
                headers: headers,
                allowRedirects: true
            }).catch(function () {
                return initialRes;
            }).then(function (pageRes) {
                var finalUrl = normalizeExtractedUrl(pageRes.finalUrl || url, baseOrigin(url)) || url;
                if (finalUrl !== url && isDirectMediaUrl(finalUrl)) {
                    return [buildStreamResult(finalUrl, "MDrive", {}, getQualityFromText(finalUrl))];
                }

                var pageBase = baseOrigin(finalUrl) || baseOrigin(url);
                var html = String(pageRes.body || initialRes.body || "");
                var candidates = extractInterestingExtractorUrls(html, pageBase).filter(function (candidate) {
                    return candidate && candidate !== url && candidate !== finalUrl;
                });

                if (!candidates.length && finalUrl && finalUrl !== url && isInterestingExtractorUrl(finalUrl)) {
                    candidates.push(finalUrl);
                }

                if (!candidates.length) {
                    return [buildStreamResult(url, "MDrive", headers, getQualityFromText(url))];
                }

                return Promise.all(candidates.map(function (candidate) {
                    if (looksLikeGoogleDriveUrl(candidate)) return resolveGoogleDrive(candidate);
                    return resolveExtractorUrl(candidate, "MDrive");
                })).then(flattenResults).then(function (results) {
                    if (results && results.length) return results;
                    return candidates.filter(function (candidate) {
                        return looksLikeGoogleDriveUrl(candidate) || /hubcloud\.|hubdrive\.|filepress\.|filebee/i.test(candidate);
                    }).map(function (candidate) {
                        var label = looksLikeGoogleDriveUrl(candidate)
                            ? "GDrive"
                            : (/hubdrive\./i.test(candidate)
                                ? "HubDrive"
                                : (/filepress\.|filebee/i.test(candidate) ? "Filepress [GDrive]" : "HubCloud"));
                        return buildStreamResult(candidate, label, headers, getQualityFromText(candidate));
                    });
                });
            });
        });
    }

    function withTimeout(promise, ms, label) {
        var timer;
        var timeoutPromise = new Promise(function (_, reject) {
            timer = setTimeout(function () {
                reject(new Error("Timeout after " + ms + "ms for " + (label || "request")));
            }, ms);
        });
        return Promise.race([promise, timeoutPromise]).then(function (result) {
            clearTimeout(timer);
            return result;
        }).catch(function (err) {
            clearTimeout(timer);
            throw err;
        });
    }

    function resolveExtractorUrl(url, refererLabel) {
        if (!url) return Promise.resolve([]);
        if (isDirectMediaUrl(url)) return Promise.resolve([buildStreamResult(url, refererLabel || "Direct", {}, getQualityFromText(url))]);
        if (looksLikeGoogleDriveUrl(url)) return resolveGoogleDrive(url);
        if (/m4ulinks\.com/i.test(url)) return withTimeout(resolveM4ulinks(url), 20000, "M4ULinks");
        if (/filesdl\./i.test(url)) return withTimeout(resolveFilesdl(url), 20000, "FilesDL");
        if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php/i.test(url)) return withTimeout(resolveHubCloudWithFallback(url, refererLabel || "HubCloud"), 25000, "HubCloud");
        if (/hubdrive\./i.test(url)) return withTimeout(resolveHubDrive(url), 20000, "HubDrive");
        if (/filepress\.|filebee/i.test(url)) return withTimeout(resolveFilepress(url), 25000, "Filepress");
        if (/gdfli?x/i.test(url)) return withTimeout(resolveGdflix(url), 25000, "GDFlix");
        if (/gofile\.io/i.test(url)) return withTimeout(resolveGofile(url), 20000, "Gofile");
        if (/mdrive\.ink\//i.test(url)) return withTimeout(resolveMdrive(url), 30000, "MDrive");
        if (/vcloud\.zip/i.test(url)) return withTimeout(resolveVcloud(url), 20000, "VCloud");
        if (/fastdl\.zip/i.test(url)) return withTimeout(resolveFastdl(url), 20000, "FastDL");
        return Promise.resolve([]);
    }

    function sortStreams(streams) {
        return streams.slice().sort(function (a, b) {
            var qa = getQualityFromText(a && a.source || "");
            var qb = getQualityFromText(b && b.source || "");
            return qb - qa;
        });
    }

    async function getHome(cb) {
        try {
            var mainUrl = await getMainUrl();
            var results = {};
            var firstHtml = "";

            for (var i = 0; i < MAIN_PAGE_SECTIONS.length; i++) {
                var section = MAIN_PAGE_SECTIONS[i];
                var url = absoluteUrl(mainUrl + "/", section.path);
                try {
                    var html = await getText(url, mainPageHeaders(mainUrl));
                    if (!firstHtml) firstHtml = html;
                    results[section.title] = parseHomeResults(html, mainUrl);
                } catch (_) {
                    results[section.title] = [];
                }
            }

            var total = 0;
            for (var key in results) {
                if (!Object.prototype.hasOwnProperty.call(results, key)) continue;
                total += (results[key] || []).length;
            }
            if (!total) {
                cb({ success: false, errorCode: "HOME_EMPTY", message: "No home items parsed. Snippet: " + snippet(firstHtml, 320) });
                return;
            }

            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: toErrorMessage(error) });
        }
    }

    async function search(query, cb) {
        try {
            var mainUrl = await getMainUrl();
            var url = mainUrl + "/?s=" + encodeURIComponent(query || "");
            var html = await getText(url, defaultHeaders());
            var results = parseSearchResultsKotlin(html, mainUrl);
            if (!results.length) {
                cb({ success: false, errorCode: "SEARCH_EMPTY", message: "No search items parsed. Snippet: " + snippet(html, 320) });
                return;
            }
            cb({
                success: true,
                data: results
            });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: toErrorMessage(error) });
        }
    }

    async function load(url, cb) {
        try {
            var sourceUrl = String(url || "");
            var html = await getText(sourceUrl, defaultHeaders());

            var rawOgTitle = extractMetaContent(html, "og:title") || "Unknown Title";
            var title = trim(rawOgTitle.split("(")[0]) || "Unknown Title";
            var plot = extractStoryline(html);
            var poster = extractMetaContent(html, "og:image")
                || getImageFromBlock(firstMatch(html, [/<div\b[^>]*class=["'][^"']*post-thumbnail[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]), sourceUrl);
            var typeRaw = extractPrimaryHeading(html);
            var type = /Series/i.test(typeRaw) ? "series" : "movie";
            if (/Anime/i.test(typeRaw)) type = "anime";
            var isMovie = type === "movie";
            var imdbId = extractImdbId(html);
            var downloadLinks = extractDownloadLinks(html, baseOrigin(sourceUrl));
            if (title === "Unknown Title" && !downloadLinks.length) {
                cb({ success: false, errorCode: "LOAD_EMPTY", message: "Load page not parsed. Snippet: " + snippet(html, 320) });
                return;
            }

            var tmdbId = await findTmdbId(imdbId, isMovie ? "movie" : "tv", title);
            var logoUrl = await fetchTmdbLogoUrl(isMovie ? "movie" : "tv", tmdbId);

            var episodeMeta = {};
            var episodeLinksMap = {};

            if (!isMovie && tmdbId) {
                var seasonSections = getSeasonSections(html, baseOrigin(sourceUrl));
                for (var i = 0; i < seasonSections.length; i++) {
                    var section = seasonSections[i];
                    var seasonMetadata = await fetchSeasonMetadata(tmdbId, section.season);
                    for (var metaKey in seasonMetadata) {
                        if (Object.prototype.hasOwnProperty.call(seasonMetadata, metaKey)) {
                            episodeMeta[metaKey] = seasonMetadata[metaKey];
                        }
                    }

                    for (var j = 0; j < section.links.length; j++) {
                        var qualityLink = section.links[j];
                        try {
                            var seasonHtml = await getText(qualityLink, defaultHeaders({ "Referer": sourceUrl }));
                            var episodeBlocks = getEpisodeBlocks(seasonHtml, baseOrigin(qualityLink));
                            if (episodeBlocks.length) {
                                for (var k = 0; k < episodeBlocks.length; k++) {
                                    var epBlock = episodeBlocks[k];
                                    var key = String(section.season) + "_" + String(epBlock.episode);
                                    if (!episodeLinksMap[key]) episodeLinksMap[key] = [];
                                    episodeLinksMap[key] = episodeLinksMap[key].concat(epBlock.links);
                                }
                            } else {
                                var fallbackKey = String(section.season) + "_1";
                                if (!episodeLinksMap[fallbackKey]) episodeLinksMap[fallbackKey] = [];
                                episodeLinksMap[fallbackKey].push(qualityLink);
                            }
                        } catch (_) {}
                    }
                }
            }

            var tmdbDetails = tmdbId ? await fetchTmdbDetails(isMovie ? "movie" : "tv", tmdbId) : {};
            if (tmdbDetails) {
                title = tmdbDetails.name || tmdbDetails.title || title;
            }

            var description = (tmdbDetails && tmdbDetails.overview) || plot || "";
            var bannerUrl = tmdbDetails && tmdbDetails.backdrop_path ? (TMDB_IMAGE_BASE + tmdbDetails.backdrop_path) : poster;
            var year = trim((tmdbDetails && (tmdbDetails.first_air_date || tmdbDetails.release_date) || "").slice(0, 4));
            var cast = buildActorList(tmdbDetails && tmdbDetails.credits && tmdbDetails.credits.cast);
            var score = tmdbDetails && typeof tmdbDetails.vote_average === "number" ? Number(tmdbDetails.vote_average.toFixed(1)) : undefined;

            if (isMovie) {
                var movieLinks = uniqueBy(downloadLinks, function (item) { return item; });
                cb({
                    success: true,
                    data: new MultimediaItem({
                        title: title,
                        url: sourceUrl,
                        posterUrl: poster,
                        bannerUrl: bannerUrl,
                        logoUrl: logoUrl || undefined,
                        type: "movie",
                        description: description,
                        year: year ? Number(year) : undefined,
                        score: score,
                        cast: cast,
                        headers: defaultHeaders({ "Referer": sourceUrl }),
                        episodes: [
                            new Episode({
                                name: "Movie",
                                url: buildLoadPayload(sourceUrl, movieLinks, {
                                    title: title,
                                    type: "movie",
                                    season: 1,
                                    episode: 1
                                }),
                                season: 1,
                                episode: 1,
                                posterUrl: poster,
                                description: description,
                                headers: defaultHeaders({ "Referer": sourceUrl })
                            })
                        ]
                    })
                });
                return;
            }

            var episodes = Object.keys(episodeLinksMap).sort(function (a, b) {
                var aParts = a.split("_");
                var bParts = b.split("_");
                return Number(aParts[0]) - Number(bParts[0]) || Number(aParts[1]) - Number(bParts[1]);
            }).map(function (key) {
                var parts = key.split("_");
                var season = Number(parts[0]);
                var episode = Number(parts[1]);
                var meta = episodeMeta[key] || {};
                var isCompleteSeason = !(meta && meta.title);
                return new Episode({
                    name: meta.title || ("Episode " + episode),
                    url: buildLoadPayload(sourceUrl, uniqueBy(episodeLinksMap[key], function (item) { return item; }), {
                        title: title,
                        type: type,
                        season: season,
                        episode: episode
                    }),
                    season: season,
                    episode: episode,
                    description: meta.overview || plot,
                    posterUrl: meta.thumbnail || poster,
                    airDate: meta.released || undefined,
                    score: meta.rating ? Number(Number(meta.rating).toFixed(1)) : undefined,
                    headers: defaultHeaders({ "Referer": sourceUrl })
                });
            });

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: sourceUrl,
                    posterUrl: poster,
                    bannerUrl: bannerUrl,
                    logoUrl: logoUrl || undefined,
                    type: type,
                    description: description,
                    year: year ? Number(year) : undefined,
                    score: score,
                    cast: cast,
                    headers: defaultHeaders({ "Referer": sourceUrl }),
                    episodes: episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: toErrorMessage(error) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            var payload = parseJsonSafe(url, null);
            if (Array.isArray(payload)) {
                payload = {
                    sourceUrl: "",
                    links: payload
                };
            }
            if (!payload || !payload.links || !payload.links.length) {
                if (/^https?:\/\//i.test(String(url || ""))) {
                    var html = await getText(String(url), defaultHeaders());
                    payload = {
                        sourceUrl: String(url),
                        links: extractDownloadLinks(html, baseOrigin(String(url))),
                        type: "movie",
                        title: ""
                    };
                } else {
                    cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid stream payload" });
                    return;
                }
            }

            var resolved = await Promise.all((payload.links || []).map(function (link) {
                return resolveExtractorUrl(link, "Movies4u");
            }));

            var streams = uniqueBy(flattenResults(resolved), function (item) {
                return String(item.url || "") + "|" + JSON.stringify(item.headers || {});
            }).filter(function (item) {
                return !!(item && item.url) && isUsableStreamUrl(item.url);
            });

            cb({
                success: true,
                data: sortStreams(streams)
            });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: toErrorMessage(error) });
        }
    }

    var root = typeof globalThis !== "undefined" ? globalThis
        : typeof self !== "undefined" ? self
        : typeof window !== "undefined" ? window
        : typeof global !== "undefined" ? global
        : this;

    root.getHome = getHome;
    root.loadHome = getHome;
    root.loadhome = getHome;
    root.search = search;
    root.load = load;
    root.loadStreams = loadStreams;

})();
