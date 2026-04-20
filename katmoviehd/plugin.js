(function () {
    var DEBUG = false;
    function log() { if (DEBUG) { var a = Array.prototype.slice.call(arguments); a.unshift("[KMH]"); console.log.apply(console, a); } }

    var BROWSER_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Referer": "https://katmoviehd.run/"
    };

    var DOMAINS = ["https://katmoviehd.run", "https://katmoviehd.co", "https://katmoviehd.fans"];
    var cachedDomain = null;

    function getDomain() {
        if (cachedDomain) return Promise.resolve(cachedDomain);
        return testDomain(0);
    }

    function testDomain(i) {
        if (i >= DOMAINS.length) return Promise.reject(new Error("No domain"));
        return http_get(DOMAINS[i] + "/", { headers: BROWSER_HEADERS }).then(function (res) {
            if (res.body && res.body.indexOf("katmoviehd") !== -1) {
                cachedDomain = DOMAINS[i];
                return cachedDomain;
            }
            return testDomain(i + 1);
        }).catch(function () { return testDomain(i + 1); });
    }

    function strip(s) {
        if (!s) return "";
        return s.replace(/<[^>]+>/g, "").replace(/&amp;/g, "&").replace(/&nbsp;/g, " ").replace(/\s+/g, " ").trim();
    }

    function getQ(t) {
        if (!t) return 0;
        t = t.toLowerCase();
        if (t.indexOf("2160p") !== -1 || t.indexOf("4k") !== -1) return 2160;
        if (t.indexOf("1080p") !== -1) return 1080;
        if (t.indexOf("720p") !== -1) return 720;
        if (t.indexOf("480p") !== -1) return 480;
        return 0;
    }

    function qualityLabel(q) {
        q = Number(q || 0);
        if (q >= 2160) return "2160p";
        if (q >= 1080) return "1080p";
        if (q >= 720) return "720p";
        if (q >= 480) return "480p";
        return "";
    }

    function formatStreamSource(source, quality) {
        var cleanSource = String(source || "Source").replace(/\s+/g, " ").trim() || "Source";
        var label = qualityLabel(quality);
        if (!label) return cleanSource;
        if (/\b(?:2160p|1080p|720p|480p|4k)\b/i.test(cleanSource)) return cleanSource;
        return cleanSource + " " + label;
    }

    function isMovie(h) {
        if (!h) return false;
        if (h.indexOf("/category/") !== -1) return false;
        if (h.indexOf("/tag/") !== -1) return false;
        if (h.indexOf("/page/") !== -1) return false;
        if (h.indexOf("/author/") !== -1) return false;
        if (h.indexOf("facebook.com") !== -1) return false;
        if (h.indexOf("twitter.com") !== -1) return false;
        if (h.indexOf("#") === 0) return false;
        return true;
    }

    function extractListingItems(html) {
        var source = String(html || "");
        var items = [];
        var seen = {};
        var patterns = [
            /<article[\s\S]*?<\/article>/gi,
            /<li[^>]+id=["']post-\d+["'][\s\S]*?<\/li>/gi
        ];

        for (var i = 0; i < patterns.length; i++) {
            var pattern = patterns[i];
            var match;
            while ((match = pattern.exec(source)) !== null) {
                var chunk = match[0];
                var linkMatch = chunk.match(/<a[^>]+href="([^"]+)"[^>]*(?:title="([^"]*)")?/i);
                if (!linkMatch) continue;

                var href = linkMatch[1];
                if (!isMovie(href) || seen[href]) continue;
                seen[href] = true;

                var title = linkMatch[2] || "";
                if (!title) {
                    var headingMatch = chunk.match(/<h[23][^>]*>([\s\S]*?)<\/h[23]>/i);
                    if (headingMatch) title = strip(headingMatch[1]);
                }
                if (!title) {
                    var altMatch = chunk.match(/<img[^>]+alt="([^"]+)"/i);
                    if (altMatch) title = decodeHtml(altMatch[1]);
                }
                title = strip(decodeHtml(title));
                if (!title || title.length < 3) continue;

                var poster = null;
                var imgMatch = chunk.match(/<img[^>]+(?:data-src|src)="([^"]+)"/i);
                if (imgMatch) poster = decodeHtml(imgMatch[1]);

                items.push({
                    title: title.replace(/\s*\(.*?\)/g, "").trim(),
                    url: href.indexOf("http") === 0 ? href : cachedDomain + href,
                    posterUrl: poster,
                    type: /season|episode/i.test(title) ? "series" : "movie",
                    quality: getQ(title)
                });
            }
        }

        return items;
    }

    function getHome(cb) {
        getDomain().then(function (d) {
            return http_get(d + "/", { headers: BROWSER_HEADERS }).then(function (res) {
                return { domain: d, response: res };
            });
        }).then(function (result) {
            var d = result.domain;
            var items = extractListingItems(result.response.body);

            var sections = {};
            if (items.length > 0) {
                var feat = items.slice(0, Math.min(6, items.length));
                sections["Featured"] = feat.map(function(i) {
                    return new MultimediaItem({
                        title: i.title,
                        url: i.url,
                        posterUrl: i.posterUrl,
                        type: i.type,
                        headers: { "User-Agent": "Mozilla/5.0", "Referer": d + "/" }
                    });
                });

                var rest = items.slice(6);
                if (rest.length > 0) {
                    sections["Latest"] = rest.map(function(i) {
                        return new MultimediaItem({
                            title: i.title,
                            url: i.url,
                            posterUrl: i.posterUrl,
                            type: i.type,
                            headers: { "User-Agent": "Mozilla/5.0", "Referer": d + "/" }
                        });
                    });
                }
            }

            cb({ success: true, data: sections });
        }).catch(function (e) { cb({ success: false, errorCode: "HOME_ERROR", message: e.message }); });
    }

    function search(q, cb) {
        getDomain().then(function (d) {
            return http_get(d + "/?s=" + encodeURIComponent(q), { headers: BROWSER_HEADERS }).then(function (res) {
                return { domain: d, response: res };
            });
        }).then(function (result) {
            var d = result.domain;
            var rawItems = extractListingItems(result.response.body);
            var items = rawItems.map(function (item) {
                return new MultimediaItem({
                    title: item.title,
                    url: item.url,
                    posterUrl: item.posterUrl,
                    type: item.type,
                    quality: item.quality,
                    headers: { "User-Agent": "Mozilla/5.0", "Referer": d + "/" }
                });
            });

            cb({ success: true, data: items });
        }).catch(function (e) { cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message }); });
    }

    function load(url, cb) {
        getDomain().then(function () {
            return http_get(url, { headers: BROWSER_HEADERS });
        }).then(function (res) {
            var html = res.body;

            var title = "";
            var h1m = html.match(/<h1[^>]*>(.*?)<\/h1>/is);
            if (h1m) title = strip(decodeHtml(h1m[1]));

            var poster = null;
            var ogm = html.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/);
            if (ogm) poster = ogm[1];

            var eps = extractPageEpisodes(html, url);
            var type = /season|episode/i.test(title) ? "series" : "movie";
            var bundledPayloads = [];
            var qualityHasIntermediate = {};
            var i;

            eps.sort(function(a, b) {
                var qa = JSON.parse(a.url).quality;
                var qb = JSON.parse(b.url).quality;
                return qb - qa;
            });

            if (type === "movie") {
                for (i = 0; i < eps.length; i++) {
                    try {
                        var payload = JSON.parse(eps[i].url);
                        if (payload && payload.type === "intermediate") qualityHasIntermediate[Number(payload.quality || 0)] = true;
                        bundledPayloads.push(payload);
                    } catch (_) {}
                }
                bundledPayloads = bundledPayloads.filter(function (payload) {
                    return !shouldSkipBundledMoviePayload(payload, qualityHasIntermediate);
                });
                eps = bundledPayloads.length ? [new Episode({
                    name: "Movie",
                    url: JSON.stringify(bundledPayloads),
                    season: 1,
                    episode: 1,
                    posterUrl: poster
                })] : [];
            } else {
                eps = groupSeriesEpisodes(eps, poster);
            }

            cb({ success: true, data: new MultimediaItem({
                title: title || "Unknown",
                url: url,
                posterUrl: poster,
                bannerUrl: poster,
                type: type,
                headers: { "User-Agent": "Mozilla/5.0", "Referer": url },
                episodes: eps
            })});
        }).catch(function (e) { cb({ success: false, errorCode: "LOAD_ERROR", message: e.message }); });
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&#(\d+);/g, function (_, code) { return String.fromCharCode(Number(code)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, code) { return String.fromCharCode(parseInt(code, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;/gi, "'")
            .replace(/&#039;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">");
    }

    function parseHeaders(raw) {
        var headers = {};
        if (!raw) return headers;
        if (typeof raw.forEach === "function") {
            raw.forEach(function (value, key) {
                headers[String(key).toLowerCase()] = value;
            });
            return headers;
        }
        for (var key in raw) {
            if (!Object.prototype.hasOwnProperty.call(raw, key)) continue;
            headers[String(key).toLowerCase()] = raw[key];
        }
        return headers;
    }

    function responseStatus(res) {
        if (!res) return 0;
        if (typeof res.status === "number") return res.status;
        if (typeof res.statusCode === "number") return res.statusCode;
        return 0;
    }

    function requestWithFetch(url, method, headers, body, followRedirects) {
        if (typeof fetch !== "function") {
            return Promise.reject(new Error("Fetch not available"));
        }
        return fetch(url, {
            method: method,
            headers: headers,
            body: body,
            redirect: followRedirects === false ? "manual" : "follow"
        }).then(function (res) {
            return res.text().then(function (bodyText) {
                var parsedHeaders = parseHeaders(res.headers);
                if (res.headers && typeof res.headers.getSetCookie === "function") {
                    var cookies = res.headers.getSetCookie();
                    if (cookies && cookies.length) parsedHeaders["set-cookie"] = cookies;
                }
                return {
                    status: res.status,
                    body: bodyText,
                    headers: parsedHeaders,
                    finalUrl: res.url || url
                };
            });
        });
    }

    function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || {};
        var body = typeof options.body === "undefined" ? "" : options.body;
        var followRedirects = options.followRedirects !== false;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, { headers: headers, followRedirects: followRedirects })).then(function (res) {
                return {
                    status: responseStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
            }).catch(function () {
                return requestWithFetch(url, method, headers, body, followRedirects);
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            var attempts = [
                function () { return http_post(url, body, { headers: headers, followRedirects: followRedirects }); },
                function () { return http_post(url, { headers: headers, followRedirects: followRedirects, body: body }); },
                function () { return http_post(url, headers, body); },
                function () { return http_post(url, body, headers); }
            ];
            return (async function () {
                var lastErr = null;
                var lastRes = null;
                for (var i = 0; i < attempts.length; i++) {
                    try {
                        var res = await attempts[i]();
                        var normalized = {
                            status: responseStatus(res) || 200,
                            body: res && typeof res.body !== "undefined" ? res.body : "",
                            headers: parseHeaders(res && res.headers),
                            finalUrl: (res && (res.url || res.finalUrl)) || url
                        };
                        if (normalized.status < 400) return normalized;
                        lastRes = normalized;
                    } catch (e) {
                        lastErr = e;
                    }
                }
                if (typeof fetch === "function") {
                    return requestWithFetch(url, method, headers, body, followRedirects).catch(function () {
                        if (lastRes) return lastRes;
                        throw lastErr || new Error("POST failed: " + url);
                    });
                }
                if (lastRes) return lastRes;
                if (lastErr) throw lastErr;
                throw new Error("POST failed: " + url);
            })();
        }

        return requestWithFetch(url, method, headers, body, followRedirects);
    }

    function networkRequest(url, options) {
        options = options || {};
        return request(resolveRequestUrl(url, options), options);
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function baseOrigin(url) {
        try {
            return new URL(url).origin;
        } catch (_) {
            return "";
        }
    }

    function isKnownErrorUrl(url) {
        try {
            var parsed = new URL(String(url || ""));
            var host = String(parsed.hostname || "").toLowerCase();
            var path = String(parsed.pathname || "").toLowerCase();
            if (!/(?:^|\.)kmhd\.eu$|(?:^|\.)links\.kmhd\.eu$|(?:^|\.)katmoviehd\./i.test(host)) return false;
            return /^\/(?:error|errors|404|not-found)(?:\/|$)/i.test(path);
        } catch (_) {
            return /(?:^|\/)(?:error|errors|404|not-found)(?:[/?#]|$)/i.test(String(url || ""));
        }
    }

    function resolveUrl(url, base) {
        try {
            return new URL(url, base).toString();
        } catch (_) {
            return String(url || "");
        }
    }

    function resolveRequestUrl(url, options) {
        var value = decodeHtml(String(url || "")).trim();
        if (!value || /^https?:\/\//i.test(value)) return value;

        var headers = options && options.headers || {};
        var base = headers.Referer || headers.referer || BROWSER_HEADERS.Referer;

        if (/^\/?(?:error|errors|404|not-found)(?:[/?#]|$)/i.test(value)) {
            return baseOrigin(base) + "/";
        }

        if (/^\/{2,}(?:locked|file|play)(?:[/?#]|$)/i.test(value)) {
            value = "/" + value.replace(/^\/+/, "");
        }

        return resolveUrl(value, base);
    }

    function safeDecodeURIComponent(value) {
        try {
            return decodeURIComponent(String(value || "").replace(/\+/g, "%20"));
        } catch (_) {
            return String(value || "");
        }
    }

    function normalizeExtractedUrl(rawValue, base) {
        var value = decodeHtml(String(rawValue || ""))
            .replace(/\\u002F/gi, "/")
            .replace(/\\u003A/gi, ":")
            .replace(/\\u0026/gi, "&")
            .replace(/\\\//g, "/")
            .replace(/^[\s"'`(]+/, "")
            .replace(/[\s"'`),;]+$/, "");

        for (var i = 0; i < 2; i++) {
            var decoded = safeDecodeURIComponent(value);
            if (decoded === value) break;
            value = decoded;
        }

        if (/^\/\//.test(value)) value = "https:" + value;
        if (/^www\./i.test(value)) value = "https://" + value;
        if (!/^https?:\/\//i.test(value) && base) {
            if (/^(?:\/|\.\/|\.\.\/|\?)/.test(value) || /^[a-z0-9][^:]*\/[^:]+/i.test(value)) {
                value = resolveUrl(value, base);
            }
        }
        if (/^(?:javascript|mailto|tel|data):/i.test(value) || /^#/.test(value)) return "";
        if (isKnownErrorUrl(value)) return "";
        return value;
    }

    function decodeQueryParam(url, name) {
        try {
            return new URL(url).searchParams.get(name) || "";
        } catch (_) {
            return "";
        }
    }

    function expandCandidateUrls(rawValue, base) {
        var queue = [];
        var out = [];
        var seen = {};
        var first = normalizeExtractedUrl(rawValue, base);
        var paramNames = ["url", "link", "r", "redirect", "redirect_url", "target", "destination", "dest", "to", "file", "dl"];
        if (first) queue.push(first);

        while (queue.length) {
            var current = queue.shift();
            if (!current || seen[current]) continue;
            seen[current] = true;
            out.push(current);

            for (var i = 0; i < paramNames.length; i++) {
                var nested = normalizeExtractedUrl(decodeQueryParam(current, paramNames[i]), base);
                if (nested && !seen[nested]) queue.push(nested);
            }
        }
        return out;
    }

    function extractCookieHeader(headers) {
        var raw = headers && headers["set-cookie"];
        if (!raw) return "";
        if (Array.isArray(raw)) {
            return raw.map(function (item) {
                return String(item || "").split(";")[0];
            }).filter(Boolean).join("; ");
        }
        return String(raw || "").split(/,(?=[^;]+=[^;]+)/).map(function (item) {
            return String(item || "").split(";")[0];
        }).filter(Boolean).join("; ");
    }

    function mergeHeaders(extra) {
        var headers = {};
        var key;
        for (key in BROWSER_HEADERS) {
            if (Object.prototype.hasOwnProperty.call(BROWSER_HEADERS, key)) headers[key] = BROWSER_HEADERS[key];
        }
        for (key in extra) {
            if (Object.prototype.hasOwnProperty.call(extra, key) && extra[key]) headers[key] = extra[key];
        }
        return headers;
    }

    function detectHoster(text) {
        var value = String(text || "").toLowerCase();
        if (value.indexOf("bbupload") !== -1 || value.indexOf("bullstream") !== -1 || value.indexOf("getnowit.site") !== -1) return "BBUpload";
        if (value.indexOf("gdflix") !== -1 || value.indexOf("gdlink") !== -1) return "GDFLix";
        if (value.indexOf("gofile") !== -1) return "GoFile";
        if (value.indexOf("hubcloud") !== -1 || value.indexOf("hubdrive") !== -1) return "HubCloud";
        if (value.indexOf("1xplayer") !== -1 || value.indexOf("1xcinema") !== -1 || /\/play\/(?:f)?tt\d+/i.test(value)) return "1xPlayer";
        if (value.indexOf("katdrive") !== -1) return "Katdrive";
        if (value.indexOf("send.cm") !== -1 || value.indexOf("sendcm") !== -1) return "Send.cm";
        if (value.indexOf("send.now") !== -1) return "Send.cm";
        if (value.indexOf("1fichier") !== -1) return "1Fichier";
        if (value.indexOf("clicknupload") !== -1) return "ClicknUpload";
        if (value.indexOf("streamtape") !== -1) return "StreamTape";
        if (value.indexOf("streamwish") !== -1 || /hglink\.to|hgplaycdn|filelions|uqloads|davioad|yuguaab|guxhag|taylorplayer|mivalyo|habetar|ghbrisk/i.test(value)) return "StreamWish";
        if (value.indexOf("mega") !== -1) return "Mega";
        if (value.indexOf("drive.google") !== -1 || value.indexOf("google drive") !== -1 || value.indexOf("googleusercontent.com") !== -1 || value.indexOf("googlevideo.com") !== -1 || value.indexOf("video-downloads.googleusercontent.com") !== -1) return "Google Drive";
        return "";
    }

    function isInterestingPlayerUrl(url) {
        return /1xplayer|1xcinema|\/play\/(?:f)?tt\d+/i.test(String(url || ""));
    }

    function isInterestingStreamUrl(url) {
        return /links\.kmhd|gdflix|gdlink|hubcloud|hubdrive|katdrive|send\.(?:cm|now)|1fichier|clicknupload|gofile|streamtape|streamwish|hglink\.to|hgplaycdn|filelions|uqloads|davioad|yuguaab|guxhag|taylorplayer|mivalyo|habetar|ghbrisk|mega\.nz|drive\.google|googleusercontent\.com|googlevideo\.com|video-downloads\.googleusercontent\.com|download\.bbupload\.to|bullstream|getnowit\.site/i.test(String(url || "")) ||
            isInterestingPlayerUrl(url);
    }

    function parseAnchors(html, base) {
        var out = [];
        var source = String(html || "");
        var re = /<a([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = re.exec(source)) !== null) {
            var inner = match[4] || "";
            var imgMatch = inner.match(/<img[^>]+(?:src|data-src)=["']([^"']+)["']/i);
            var beforeContext = source.slice(Math.max(0, match.index - 260), match.index);
            var afterContext = source.slice(re.lastIndex, Math.min(source.length, re.lastIndex + 160));
            var shortBeforeContext = source.slice(Math.max(0, match.index - 90), match.index);
            var shortAfterContext = source.slice(re.lastIndex, Math.min(source.length, re.lastIndex + 90));
            out.push({
                href: resolveUrl(decodeHtml(match[2]), base),
                text: strip(inner),
                html: inner,
                img: imgMatch ? decodeHtml(imgMatch[1]) : "",
                context: beforeContext + " " + afterContext,
                beforeContext: beforeContext,
                afterContext: afterContext,
                shortBeforeContext: shortBeforeContext,
                shortAfterContext: shortAfterContext
            });
        }
        return out;
    }

    function parseIframes(html, base) {
        var out = [];
        var source = String(html || "");
        var re = /<iframe([^>]*)src=["']([^"']+)["']([^>]*)>/gi;
        var match;

        while ((match = re.exec(source)) !== null) {
            var beforeContext = source.slice(Math.max(0, match.index - 180), match.index);
            var afterContext = source.slice(re.lastIndex, Math.min(source.length, re.lastIndex + 180));
            out.push({
                src: resolveUrl(decodeHtml(match[2]), base),
                html: match[0] || "",
                context: beforeContext + " " + afterContext,
                beforeContext: beforeContext,
                afterContext: afterContext
            });
        }

        return out;
    }

    function isBlockedLink(href, text) {
        var value = String(href || "").toLowerCase() + " " + String(text || "").toLowerCase();
        if (!href) return true;
        if (href.indexOf("#") === 0) return true;
        if (value.indexOf("javascript:") !== -1) return true;
        if (value.indexOf("mailto:") !== -1 || value.indexOf("tel:") !== -1) return true;
        if (value.indexOf("facebook.com") !== -1 || value.indexOf("twitter.com") !== -1) return true;
        if (value.indexOf("share on") !== -1 || value.indexOf("share this") !== -1) return true;
        return false;
    }

    function isIntermediateLink(url) {
        return /links\.kmhd\.eu\/file\//i.test(String(url || ""));
    }

    function buildEpisodeName(quality, text, source) {
        var label = qualityLabel(quality);
        var cleanText = strip(decodeHtml(text || ""));
        var sourceLabel = source || "";
        var parts = [];
        var normalizedText = cleanText.toLowerCase();
        var normalizedLabel = String(label || "").toLowerCase();
        var normalizedSource = String(sourceLabel || "").toLowerCase();

        if (normalizedLabel && normalizedText.indexOf(normalizedLabel) === 0) {
            cleanText = cleanText.slice(label.length).replace(/^[\s|:-]+/, "").trim();
            normalizedText = cleanText.toLowerCase();
        }
        if (normalizedSource && normalizedText.indexOf(normalizedSource) === 0) {
            cleanText = cleanText.slice(sourceLabel.length).replace(/^[\s|:-]+/, "").trim();
            normalizedText = cleanText.toLowerCase();
        }

        if (label) parts.push(label);
        if (sourceLabel) parts.push(sourceLabel);
        if (cleanText &&
            normalizedText !== normalizedSource &&
            normalizedText !== normalizedLabel) {
            parts.push(cleanText);
        }

        return parts.join(" ").trim() || label + " Links";
    }

    function shouldSkipBundledMoviePayload(payload, qualityHasIntermediate) {
        var url = String(payload && payload.url || "");
        var quality = Number(payload && payload.quality || 0);
        if (!url) return true;
        if (/links\.kmhd\.eu\/play\?/i.test(url) && qualityHasIntermediate[quality]) return true;
        return false;
    }

    function extractSeasonNumber(text) {
        var value = String(text || "");
        var match = value.match(/\bseason\s*(\d{1,3})\b/i) || value.match(/\bs(\d{1,3})\b/i);
        return match ? Number(match[1]) : 1;
    }

    function extractEpisodeNumber(text) {
        var value = decodeHtml(String(text || ""))
            .replace(/<[^>]+>/g, " ")
            .replace(/\s+/g, " ")
            .trim();
        var match = value.match(/\b(?:episode|ep)\s*[-.:#]?\s*(\d{1,3})\b/i) || value.match(/\bs\d{1,3}\s*e(\d{1,3})\b/i);
        return match ? Number(match[1]) : 0;
    }

    function groupSeriesEpisodes(episodes, poster) {
        var groups = {};
        var order = [];

        for (var i = 0; i < episodes.length; i++) {
            var item = episodes[i];
            var payload = parseJsonSafe(item && item.url || "", null);
            if (!payload || !payload.url) continue;

            var season = Number(item.season || payload.season || 1) || 1;
            var episode = Number(item.episode || payload.episode || (i + 1)) || (i + 1);
            var key = season + "_" + episode;

            payload.season = season;
            payload.episode = episode;

            if (!groups[key]) {
                groups[key] = {
                    season: season,
                    episode: episode,
                    payloads: []
                };
                order.push(key);
            }
            groups[key].payloads.push(payload);
        }

        return order.sort(function (a, b) {
            var left = groups[a];
            var right = groups[b];
            return left.season - right.season || left.episode - right.episode;
        }).map(function (key) {
            var group = groups[key];
            var qualities = {};
            var labels = [];

            group.payloads.sort(function (a, b) {
                return Number(b.quality || 0) - Number(a.quality || 0);
            });

            group.payloads.forEach(function (payload) {
                var label = qualityLabel(payload.quality);
                if (label && !qualities[label]) {
                    qualities[label] = true;
                    labels.push(label);
                }
            });

            return new Episode({
                name: "Episode " + group.episode + (labels.length ? " [" + labels.join(", ") + "]" : ""),
                url: JSON.stringify(group.payloads),
                season: group.season,
                episode: group.episode,
                posterUrl: poster || undefined
            });
        });
    }

    function extractPageEpisodes(html, pageUrl) {
        var episodes = [];
        var anchors = parseAnchors(html, pageUrl);
        var iframes = parseIframes(html, pageUrl);
        var seen = {};
        var pageTitleMatch = String(html || "").match(/<h1[^>]*>(.*?)<\/h1>/is);
        var pageTitle = pageTitleMatch ? strip(decodeHtml(pageTitleMatch[1])) : "";
        var pageQuality = extractQuality(pageTitle);
        var seasonNumber = extractSeasonNumber(pageTitle);
        var currentEpisode = 0;

        for (var i = 0; i < anchors.length; i++) {
            var anchor = anchors[i];
            var sourceHint = [anchor.text, anchor.img, anchor.html, anchor.href].join(" ");
            var qualityHint = [anchor.text, anchor.href].join(" ");
            var href = anchor.href;
            var sameOrigin = baseOrigin(href) && baseOrigin(pageUrl) && baseOrigin(href) === baseOrigin(pageUrl);
            var source = detectHoster(sourceHint);
            var quality = extractQuality(qualityHint);
            var payload;
            var episodeNumber = extractEpisodeNumber(anchor.beforeContext + " " + anchor.text);

            if (isBlockedLink(href, sourceHint)) continue;
            if (/\/(?:tag|category|author|page)\//i.test(href)) continue;
            if (sameOrigin && !isInterestingPlayerUrl(href)) continue;
            if (!source && !isInterestingStreamUrl(href)) continue;
            if (source === "1xPlayer" && !isInterestingPlayerUrl(href)) continue;
            if (!quality) quality = extractQuality(anchor.shortAfterContext || anchor.afterContext);
            if (!quality) quality = extractQuality(anchor.shortBeforeContext || anchor.beforeContext);
            if (!quality) continue;
            if (seen[href]) continue;

            if (episodeNumber) currentEpisode = episodeNumber;
            episodeNumber = currentEpisode || 1;
            seen[href] = true;
            payload = {
                type: isIntermediateLink(href) ? "intermediate" : "direct",
                url: href,
                quality: quality,
                pageUrl: pageUrl,
                source: source || "",
                season: seasonNumber,
                episode: episodeNumber
            };

            episodes.push(new Episode({
                name: "Episode " + episodeNumber + " - " + buildEpisodeName(quality, anchor.text, payload.source),
                url: JSON.stringify(payload),
                season: seasonNumber,
                episode: episodeNumber
            }));
        }

        for (i = 0; i < iframes.length; i++) {
            var frame = iframes[i];
            var frameHint = [frame.src, frame.html, frame.beforeContext, frame.afterContext, pageTitle].join(" ");
            var frameSource = detectHoster(frameHint);
            var frameQuality = extractQuality(frame.beforeContext) ||
                extractQuality(frame.afterContext) ||
                extractQuality(frame.src) ||
                pageQuality;
            var framePayload;

            if (isBlockedLink(frame.src, frameHint)) continue;
            if (!frameSource && !isInterestingPlayerUrl(frame.src) && !isInterestingStreamUrl(frame.src)) continue;
            if (seen[frame.src]) continue;

            seen[frame.src] = true;
            framePayload = {
                type: "direct",
                url: frame.src,
                quality: frameQuality || 0,
                pageUrl: pageUrl,
                source: frameSource || "Player"
            };

            episodes.push(new Episode({
                name: buildEpisodeName(framePayload.quality, "Watch Online", framePayload.source),
                url: JSON.stringify(framePayload)
            }));
        }

        return episodes;
    }

    function addStreamResult(out, seen, rawUrl, base, sourceHint, quality, headers) {
        var candidates = expandCandidateUrls(rawUrl, base);
        if (!candidates.length) candidates = [normalizeExtractedUrl(rawUrl, base)];

        for (var i = 0; i < candidates.length; i++) {
            var candidate = unwrapRedirectUrl(candidates[i], base) || candidates[i];
            if (!candidate || !/^https?:\/\//i.test(candidate)) continue;
            var hoster = detectHoster(sourceHint + " " + candidate);
            if (!hoster && !isInterestingStreamUrl(candidate)) continue;
            if (seen[candidate]) continue;
            seen[candidate] = true;
            out.push({
                url: candidate,
                quality: quality || extractQuality(sourceHint + " " + candidate),
                source: hoster || "Source",
                headers: headers
            });
        }
    }

    function extractQuality(txt) {
        return getQ(String(txt || ""));
    }

    function extractStreamedData(html) {
        var payload = { uploads: {}, links: {} };
        var uploadsMatch = String(html || "").match(/upload_links:\{([\s\S]*?)\},size:/i);
        var linksMatch = String(html || "").match(/links:\{([\s\S]*?)\},ads:/i);
        var match;

        if (uploadsMatch) {
            var uploadRe = /([a-z0-9_]+)\s*:\s*"([^"]*)"/gi;
            while ((match = uploadRe.exec(uploadsMatch[1])) !== null) {
                payload.uploads[match[1]] = decodeHtml(match[2]);
            }
        }

        if (linksMatch) {
            var blockRe = /([a-z0-9_]+)\s*:\s*\{([\s\S]*?)\}(?=,\s*[a-z0-9_]+\s*:\s*\{|$)/gi;
            while ((match = blockRe.exec(linksMatch[1])) !== null) {
                var block = match[2] || "";
                var linkMatch = block.match(/link:\s*"([^"]+)"/i);
                var imgMatch = block.match(/img:\s*"([^"]+)"/i);
                payload.links[match[1]] = {
                    link: linkMatch ? decodeHtml(linkMatch[1]) : "",
                    img: imgMatch ? decodeHtml(imgMatch[1]) : ""
                };
            }
        }

        return payload;
    }

    function extractStreamsFromStreamedData(html, quality, headers) {
        var data = extractStreamedData(html);
        var results = [];
        var seen = {};

        for (var key in data.uploads) {
            if (!Object.prototype.hasOwnProperty.call(data.uploads, key)) continue;
            var code = data.uploads[key];
            var meta = data.links[key] || {};
            if (!code || code === "None" || !meta.link) continue;
            addStreamResult(results, seen, meta.link + code, meta.link, key + " " + meta.link + " " + meta.img, quality, headers);
        }

        return results;
    }

    function extractStreamsFromAnchors(html, base, quality, headers) {
        var results = [];
        var seen = {};
        var anchors = parseAnchors(html, base);

        for (var i = 0; i < anchors.length; i++) {
            var anchor = anchors[i];
            var hint = [anchor.text, anchor.img, anchor.html, anchor.context, anchor.href].join(" ");
            if (!detectHoster(hint) && !isInterestingStreamUrl(anchor.href)) continue;
            addStreamResult(results, seen, anchor.href, base, hint, quality, headers);
        }

        var urlRe = /https?:\/\/[^\s"'<>\\]+/gi;
        var match;
        while ((match = urlRe.exec(String(html || ""))) !== null) {
            addStreamResult(results, seen, match[0], base, match[0], quality, headers);
        }

        return results;
    }

    function cloneHeaders(headers) {
        var out = {};
        for (var key in headers) {
            if (Object.prototype.hasOwnProperty.call(headers, key) && typeof headers[key] !== "undefined") {
                out[key] = headers[key];
            }
        }
        return out;
    }

    function buildStream(url, quality, source, headers) {
        var resolvedQuality = Number(quality || extractQuality(source + " " + url));
        var resolvedSource = source || detectHoster(url) || "Source";
        return {
            url: url,
            quality: resolvedQuality,
            source: formatStreamSource(resolvedSource, resolvedQuality),
            headers: headers || {}
        };
    }

    function pushStream(out, seen, url, quality, source, headers) {
        var normalized = normalizeExtractedUrl(url, headers && (headers.Referer || headers.referer));
        var key;
        if (!normalized || !/^https?:\/\//i.test(normalized)) return;
        key = String(source || "") + "||" + normalized;
        if (seen[key]) return;
        seen[key] = true;
        out.push(buildStream(normalized, quality, source, headers));
    }

    function flattenResults(resultSets) {
        var out = [];
        var i;
        var j;
        for (i = 0; i < resultSets.length; i++) {
            var set = resultSets[i];
            if (!Array.isArray(set)) continue;
            for (j = 0; j < set.length; j++) out.push(set[j]);
        }
        return out;
    }

    function withTimeout(promise, ms) {
        var timer = null;
        return Promise.race([
            promise,
            new Promise(function (_, reject) {
                timer = setTimeout(function () {
                    reject(new Error("Timeout after " + ms + "ms"));
                }, ms);
            })
        ]).then(function (value) {
            if (timer) clearTimeout(timer);
            return value;
        }).catch(function (err) {
            if (timer) clearTimeout(timer);
            throw err;
        });
    }

    function dedupeResults(results) {
        var out = [];
        var seen = {};
        for (var i = 0; i < results.length; i++) {
            var item = results[i];
            var key;
            if (!item || !item.url) continue;
            key = canonicalResultKey(item);
            if (seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function canonicalResultKey(item) {
        var source = String(item && item.source || "");
        var url = String(item && item.url || "");
        var parsed;
        var id = "";

        try {
            parsed = new URL(url);
            if (/streamtape\./i.test(parsed.hostname) && /\/get_video/i.test(parsed.pathname)) {
                id = parsed.searchParams.get("id") || "";
                if (id) return source + "||streamtape||" + id;
            }
            if (/hglink\.to|streamwish/i.test(parsed.hostname) && /\/e\//i.test(parsed.pathname)) {
                id = parsed.pathname.replace(/^.*\/e\//i, "").replace(/\/+$/, "");
                if (id) return source + "||streamwish||" + id;
            }
            if (/pixeldrain/i.test(parsed.hostname) && /\/api\/file\//i.test(parsed.pathname)) {
                return source + "||" + parsed.origin + parsed.pathname;
            }
            if (/hub\.odyssey\.surf|fsl\.gigabytes\.icu|getnowit\.site/i.test(parsed.hostname)) {
                return source + "||" + parsed.origin + parsed.pathname;
            }
        } catch (_) {}

        return source + "||" + url;
    }

    function sortResults(results) {
        return (results || []).slice().sort(function (a, b) {
            var qa = Number(a && a.quality || 0);
            var qb = Number(b && b.quality || 0);
            var sa = String(a && a.source || "");
            var sb = String(b && b.source || "");
            if (qb !== qa) return qb - qa;
            if (sa !== sb) return sa < sb ? -1 : 1;
            return String(a && a.url || "") < String(b && b.url || "") ? -1 : 1;
        });
    }

    function looksDirect(url) {
        var value = String(url || "");
        if (/googlevideo\.com|googleusercontent\.com|video-downloads\.googleusercontent\.com/i.test(value)) return true;
        return /(?:\.m3u8|\.mp4|\.mkv|\.avi|\.mpd)(?:$|[?#])/i.test(value) ||
            /streamtape\.[^/]+\/get_video\?/i.test(value) ||
            /getnowit\.site\/get\//i.test(value);
    }

    function headerValue(headers, key) {
        var lower = String(key || "").toLowerCase();
        if (!headers) return "";
        return String(headers[lower] || headers[key] || "");
    }

    function hasFileResponseHeaders(res) {
        var headers = parseHeaders(res && res.headers);
        var status = responseStatus(res);
        var contentType = headerValue(headers, "content-type").toLowerCase();
        var disposition = headerValue(headers, "content-disposition").toLowerCase();
        if (status >= 200 && status < 300 && disposition.indexOf("attachment") !== -1) return true;
        if (status >= 200 && status < 300 && /application\/octet-stream|video\/|audio\//i.test(contentType)) return true;
        if (status === 206) return true;
        return false;
    }

    function appendQuery(url, chunk) {
        if (!url) return "";
        if (!chunk) return url;
        return url + (url.indexOf("?") === -1 ? "?" : (/[?&]$/.test(url) ? "" : "&")) + chunk;
    }

    function normalizeStreamTapeUrl(rawValue) {
        var value = decodeHtml(String(rawValue || "").trim());
        if (!value) return "";
        if (/^\/(?:www\.)?streamtape\./i.test(value)) value = "https:/" + value;
        if (/^\/\/(?:www\.)?streamtape\./i.test(value)) value = "https:" + value;
        if (/^http:\/\//i.test(value)) value = value.replace(/^http:\/\//i, "https://");
        value = normalizeExtractedUrl(value, "https://streamtape.com/");
        if (/^https?:\/\/(?:www\.)?streamtape\.com\/get_video\?/i.test(value)) {
            value = value.replace(/^(https?:\/\/)(?:www\.)?streamtape\.com\/get_video\?/i, "$1streamtape.co/get_video?");
        }
        return value;
    }

    function extractStreamTapeDirectUrl(html) {
        var ids = ["botlink", "ideoolink", "robotlink", "captchalink"];
        var i;
        var assignment;
        var hidden;
        var value = "";

        for (i = 0; i < ids.length; i++) {
            assignment = new RegExp(
                "document\\.getElementById\\(['\"]" + ids[i] + "['\"]\\)\\.innerHTML\\s*=\\s*['\"]([^'\"]*)['\"]\\s*\\+\\s*\\(['\"]([^'\"]*)['\"]\\)\\.substring\\((\\d+)\\)(?:\\.substring\\((\\d+)\\))?",
                "i"
            ).exec(String(html || ""));
            if (assignment) {
                value = assignment[1] + assignment[2].substring(Number(assignment[3] || 0));
                if (assignment[4]) value = value.substring(Number(assignment[4] || 0));
                value = normalizeStreamTapeUrl(value);
                if (value) return value;
            }
        }

        for (i = 0; i < ids.length; i++) {
            hidden = new RegExp("id=['\"]" + ids[i] + "['\"][^>]*>([^<]+)<", "i").exec(String(html || ""));
            if (!hidden) continue;
            value = normalizeStreamTapeUrl(hidden[1]);
            if (value) return value;
        }

        hidden = String(html || "").match(/https?:\/\/(?:www\.)?streamtape\.[^"'\s<>]+get_video\?[^"'\s<>]+/i);
        return hidden ? normalizeStreamTapeUrl(hidden[0]) : "";
    }

    function resolveStreamTape(url, quality, headers) {
        var pageHeaders = cloneHeaders(headers || {});
        if (!pageHeaders.Referer && !pageHeaders.referer) pageHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: pageHeaders,
            followRedirects: true
        }).then(function (res) {
            var html = String(res && res.body || "");
            var directUrl = extractStreamTapeDirectUrl(html);
            var shimHeaders;
            var shimHtml;
            var redirectMatch;
            var redirectUrl;

            if (!directUrl) return [];
            directUrl = appendQuery(directUrl, "stream=1");
            shimHeaders = mergeHeaders({ "Referer": res && res.finalUrl || url });

            return networkRequest(directUrl, {
                headers: shimHeaders,
                followRedirects: true
            }).then(function (shimRes) {
                var out = [];
                var seen = {};

                shimHtml = String(shimRes && shimRes.body || "");
                redirectMatch = shimHtml.match(/var\s+redirect_link\s*=\s*['"]([^'"]+)['"]/i);
                redirectUrl = redirectMatch ? normalizeStreamTapeUrl(redirectMatch[1]) : "";

                if (redirectUrl) {
                    redirectUrl = appendQuery(redirectUrl, "fp=-7");
                    pushStream(out, seen, redirectUrl, quality, "StreamTape Direct", shimHeaders);
                } else {
                    pushStream(out, seen, directUrl, quality, "StreamTape Direct", shimHeaders);
                }
                return out;
            }).catch(function () {
                return [buildStream(directUrl, quality, "StreamTape Direct", shimHeaders)];
            });
        }).catch(function () {
            return [];
        });
    }

    function resolveBBUpload(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (pageRes) {
            var finalUrl = pageRes && pageRes.finalUrl || url;
            var html = String(pageRes && pageRes.body || "");
            var slug = decodeQueryParam(finalUrl, "v") || decodeQueryParam(url, "v");
            var slugMatch = html.match(/var\s+slug\s*=\s*["']([^"']+)["']/i);
            var buttonMatch = html.match(/id=["']btn-predownload["'][^>]+data-id=["']([^"']+)["']/i) ||
                html.match(/data-id=["']([^"']+)["'][^>]+id=["']btn-predownload["']/i);
            var ajaxUrl;
            var ajaxHeaders;

            if (slugMatch && slugMatch[1]) slug = slugMatch[1];
            if (!slug && buttonMatch && buttonMatch[1]) slug = buttonMatch[1];
            if (!slug) return [];

            ajaxUrl = resolveUrl("/ajax.php?action=getdownload&data=" + encodeURIComponent(slug), finalUrl);
            ajaxHeaders = mergeHeaders({
                "Accept": "application/json,text/plain,*/*",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": finalUrl
            });

            return networkRequest(ajaxUrl, {
                headers: ajaxHeaders,
                followRedirects: true
            }).then(function (ajaxRes) {
                var payload = parseJsonSafe(ajaxRes && ajaxRes.body || "", {});
                var downloadUrl = normalizeExtractedUrl(payload && payload.data && payload.data.downloadUrl, ajaxUrl);
                if (!downloadUrl) return [];
                return [buildStream(downloadUrl, quality, "BBUpload Direct", mergeHeaders({ "Referer": finalUrl }))];
            });
        }).catch(function () {
            return [];
        });
    }

    function extractStreamsFromKmhdPlayPage(html, quality, headers) {
        var results = [];
        var seen = {};
        var linkMap = {};
        var match;
        var linkRe = /([a-z0-9_]+_res):\{[^}]*link:"([^"]+)"/gi;
        var codeRe = /([a-z0-9_]+_res):"([^"]+)"/gi;

        while ((match = linkRe.exec(String(html || ""))) !== null) {
            linkMap[match[1]] = decodeHtml(match[2]);
        }

        while ((match = codeRe.exec(String(html || ""))) !== null) {
            if (!linkMap[match[1]]) continue;
            addStreamResult(
                results,
                seen,
                linkMap[match[1]] + decodeHtml(match[2]),
                linkMap[match[1]],
                match[1] + " " + linkMap[match[1]],
                quality,
                headers
            );
        }

        return results;
    }

    function resolveKmhdPlayPage(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (res) {
            var finalUrl = res && res.finalUrl || url;
            var resultHeaders = mergeHeaders({ "Referer": finalUrl });
            var results = extractStreamsFromKmhdPlayPage(res && res.body || "", quality, resultHeaders);

            if (!results.length) {
                results = extractStreamsFromAnchors(res && res.body || "", finalUrl, quality, resultHeaders);
            }
            return results;
        }).catch(function () {
            return [];
        });
    }

    function extractPlayerPayload(html) {
        var match = String(html || "").match(/let\s+p3\s*=\s*(\{[\s\S]*?\})\s*;/i);
        return parseJsonSafe(match && match[1] || "", {});
    }

    function resolve1xPlayer(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (pageRes) {
            var finalUrl = pageRes && pageRes.finalUrl || url;
            var html = String(pageRes && pageRes.body || "");
            var payload = extractPlayerPayload(html);
            var token = String(payload && payload.file || "");
            var csrf = String(payload && payload.key || "");
            var outputHeaders = mergeHeaders({
                "Referer": finalUrl,
                "Origin": baseOrigin(finalUrl)
            });
            var directUrl = normalizeExtractedUrl(token, finalUrl);
            var playlistUrl;
            var fallbackResults = [];
            var fallbackSeen = {};
            var iframeList = parseIframes(html, finalUrl);
            var directLike = html.match(/https?:\/\/[^\s"'<>\\]+/gi) || [];

            for (var f = 0; f < iframeList.length; f++) {
                var iframeSrc = iframeList[f] && iframeList[f].src || "";
                if (!iframeSrc) continue;
                addStreamResult(fallbackResults, fallbackSeen, iframeSrc, finalUrl, iframeSrc + " " + html, quality, outputHeaders);
            }
            for (var m = 0; m < directLike.length; m++) {
                addStreamResult(fallbackResults, fallbackSeen, directLike[m], finalUrl, directLike[m], quality, outputHeaders);
            }

            if (directUrl && /^https?:\/\//i.test(directUrl)) {
                return [buildStream(directUrl, quality, "1xPlayer Direct", outputHeaders)];
            }

            if (!token || !csrf) return fallbackResults;

            token = token.replace(/^[~#]+/, "");
            if (!token) return [];

            playlistUrl = resolveUrl("/playlist/" + token + ".txt", finalUrl);
            var playlistHeaders = mergeHeaders({
                "Accept": "*/*",
                "X-CSRF-TOKEN": csrf,
                "Referer": finalUrl,
                "Origin": baseOrigin(finalUrl)
            });

            return networkRequest(playlistUrl, {
                headers: playlistHeaders,
                followRedirects: true
            }).then(function (playlistRes) {
                var body = String(playlistRes && playlistRes.body || "").trim();
                var results = [];
                var seen = {};
                var matches = body.match(/https?:\/\/[^\s"'<>\\]+/gi) || [];

                if (!matches.length && /^https?:\/\//i.test(body)) matches = [body];
                for (var i = 0; i < matches.length; i++) {
                    pushStream(results, seen, matches[i], quality, "1xPlayer Direct", outputHeaders);
                }
                return results.length ? results : fallbackResults;
            });
        }).catch(function () {
            return [];
        });
    }

    function extractFormInputs(html, formName) {
        var source = String(html || "");
        var formMatch;
        var formHtml;
        var inputRe;
        var match;
        var payload = {};

        if (formName) {
            formMatch = source.match(new RegExp("<form[^>]*name=[\"']" + formName + "[\"'][^>]*>([\\s\\S]*?)<\\/form>", "i"));
            if (!formMatch) return payload;
            formHtml = formMatch[1] || "";
        } else {
            formMatch = source.match(/<form[^>]*>([\s\S]*?)<\/form>/i);
            formHtml = formMatch ? formMatch[1] : "";
        }

        inputRe = /<input[^>]*name=["']([^"']+)["'][^>]*>/gi;
        while ((match = inputRe.exec(formHtml)) !== null) {
            var inputTag = match[0] || "";
            var name = decodeHtml(match[1] || "");
            var valueMatch = inputTag.match(/value=["']([^"']*)["']/i);
            var value = decodeHtml(valueMatch ? valueMatch[1] : "");
            payload[name] = value;
        }

        return payload;
    }

    function encodeFormBody(payload) {
        var parts = [];
        for (var key in payload) {
            if (!Object.prototype.hasOwnProperty.call(payload, key)) continue;
            parts.push(encodeURIComponent(key) + "=" + encodeURIComponent(String(payload[key] || "")));
        }
        return parts.join("&");
    }

    function resolveSend(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (pageRes) {
            var finalUrl = pageRes && pageRes.finalUrl || url;
            var html = String(pageRes && pageRes.body || "");
            var formPayload = extractFormInputs(html, "F1");
            var submitUrl = baseOrigin(finalUrl) + "/";
            var req = mergeHeaders({
                "Referer": finalUrl,
                "Origin": baseOrigin(finalUrl),
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            });
            var target = "";

            if (!Object.keys(formPayload).length) {
                target = unwrapRedirectUrl(finalUrl, url);
                if (target && target !== url && /^https?:\/\//i.test(target)) {
                    return [buildStream(target, quality, "Send.cm Direct", req)];
                }
                return [];
            }

            return networkRequest(submitUrl, {
                method: "POST",
                body: encodeFormBody(formPayload),
                headers: req,
                followRedirects: false
            }).then(function (postRes) {
                var location = firstHeaderValue(postRes && postRes.headers, ["location", "x-redirect-location"]);
                var direct = unwrapRedirectUrl(location, submitUrl);
                if (!direct || !/^https?:\/\//i.test(direct)) return [];
                return [buildStream(direct, quality, "Send.cm Direct", req)];
            });
        }).catch(function () {
            return [];
        });
    }

    function toBase36(num) {
        return Number(num || 0).toString(36);
    }

    function unpackPacker(packed, count, keys) {
        var output = String(packed || "");
        var c = Number(count || 0);
        var i;
        for (i = c - 1; i >= 0; i--) {
            if (!keys[i]) continue;
            output = output.replace(new RegExp("\\b" + toBase36(i) + "\\b", "g"), keys[i]);
        }
        return output;
    }

    function extractPackedScript(html) {
        var source = String(html || "");
        var scripts = source.match(/<script[^>]*>[\s\S]*?<\/script>/gi) || [];
        for (var i = 0; i < scripts.length; i++) {
            var body = scripts[i].replace(/^<script[^>]*>/i, "").replace(/<\/script>$/i, "");
            if (/eval\(function\(p,a,c,k,e,d\)/i.test(body)) return body;
        }
        return "";
    }

    function decodePackedEval(scriptBody) {
        var source = String(scriptBody || "");
        var argsMatch = source.match(/\}\(\s*'([\s\S]*?)'\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*'([\s\S]*?)'\.split\('\|'\)/i);
        if (!argsMatch) return "";

        var packed = argsMatch[1]
            .replace(/\\'/g, "'")
            .replace(/\\\\/g, "\\")
            .replace(/\\n/g, "\n");
        var count = Number(argsMatch[3] || 0);
        var keys = String(argsMatch[4] || "").split("|");
        return unpackPacker(packed, count, keys);
    }

    function extractStreamWishUrl(html, base) {
        var source = String(html || "");
        var direct = source.match(/["']hls2?["']\s*:\s*["']([^"']+)["']/i) ||
            source.match(/["']file["']\s*:\s*["']([^"']+\.m3u8[^"']*)["']/i) ||
            source.match(/https?:\/\/[^\s"'<>]+\.m3u8[^\s"'<>]*/i);
        if (direct && direct[1]) return normalizeExtractedUrl(direct[1], base);
        if (direct && direct[0]) return normalizeExtractedUrl(direct[0], base);

        var packedScript = extractPackedScript(source);
        if (!packedScript) return "";
        var unpacked = decodePackedEval(packedScript);
        if (!unpacked) return "";

        var unpackedMatch = unpacked.match(/["']hls2?["']\s*:\s*["']([^"']+)["']/i) ||
            unpacked.match(/["']file["']\s*:\s*["']([^"']+\.m3u8[^"']*)["']/i) ||
            unpacked.match(/https?:\/\/[^\s"'<>]+\.m3u8[^\s"'<>]*/i);
        if (unpackedMatch && unpackedMatch[1]) return normalizeExtractedUrl(unpackedMatch[1], base);
        return unpackedMatch ? normalizeExtractedUrl(unpackedMatch[0], base) : "";
    }

    function resolveStreamWish(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (pageRes) {
            var finalUrl = pageRes && pageRes.finalUrl || url;
            var html = String(pageRes && pageRes.body || "");
            var streamUrl = extractStreamWishUrl(html, finalUrl);
            if (!streamUrl || !/^https?:\/\//i.test(streamUrl)) return [];
            return [buildStream(streamUrl, quality, "StreamWish Direct", mergeHeaders({ "Referer": finalUrl }))];
        }).catch(function () {
            return [];
        });
    }

    function resolveOneFichier(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        var af = decodeQueryParam(url, "af") || "0";
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = "https://1fichier.com/";

        return networkRequest(url, {
            headers: mergeHeaders({
                "Cookie": "AF=" + af,
                "Referer": reqHeaders.Referer
            }),
            followRedirects: true
        }).then(function (firstRes) {
            var finalUrl = firstRes && firstRes.finalUrl || url;
            var html = String(firstRes && firstRes.body || "");
            var adzMatch = html.match(/<input[^>]*name=["']adz["'][^>]*value=["']([^"']+)["']/i);
            var directMatch = html.match(/<a[^>]*class=["'][^"']*ok btn-general btn-orange[^"']*["'][^>]*href=["']([^"']+)["']/i);

            if (directMatch && directMatch[1]) {
                return [buildStream(normalizeExtractedUrl(directMatch[1], finalUrl), quality, "1Fichier Direct", mergeHeaders({ "Referer": finalUrl }))];
            }
            if (!adzMatch) return [];

            return networkRequest(finalUrl, {
                method: "POST",
                body: "adz=" + encodeURIComponent(decodeHtml(adzMatch[1])),
                headers: mergeHeaders({
                    "Referer": finalUrl,
                    "Origin": baseOrigin(finalUrl),
                    "Cookie": "AF=" + af,
                    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                }),
                followRedirects: true
            }).then(function (postRes) {
                var body = String(postRes && postRes.body || "");
                var hrefMatch = body.match(/<a[^>]*class=["'][^"']*ok btn-general btn-orange[^"']*["'][^>]*href=["']([^"']+)["']/i);
                var link = normalizeExtractedUrl(hrefMatch && hrefMatch[1] || "", finalUrl);
                if (!link) return [];
                return [buildStream(link, quality, "1Fichier Direct", mergeHeaders({ "Referer": finalUrl }))];
            });
        }).catch(function () {
            return [];
        });
    }

    function firstHeaderValue(headers, names) {
        var parsed = parseHeaders(headers || {});
        for (var i = 0; i < names.length; i++) {
            var key = String(names[i] || "").toLowerCase();
            if (parsed[key]) return String(parsed[key]);
        }
        return "";
    }

    function unwrapRedirectUrl(url, base) {
        var current = normalizeExtractedUrl(url, base);
        var guard = 0;

        while (current && guard < 5) {
            guard += 1;
            var nested = normalizeExtractedUrl(
                decodeQueryParam(current, "url") ||
                decodeQueryParam(current, "link") ||
                decodeQueryParam(current, "redirect"),
                current
            );
            if (!nested || nested === current) break;
            current = nested;
        }

        if (/#$/.test(current)) current = current.slice(0, -1);
        return current;
    }

    async function sha256Hex(input) {
        try {
            if (typeof crypto !== "undefined" && crypto.subtle && typeof TextEncoder !== "undefined") {
                var encoded = new TextEncoder().encode(String(input || ""));
                var digest = await crypto.subtle.digest("SHA-256", encoded);
                var bytes = Array.from(new Uint8Array(digest));
                return bytes.map(function (b) { return b.toString(16).padStart(2, "0"); }).join("");
            }
        } catch (_) {}
        return "";
    }

    function extractGdflixCandidates(html, base) {
        var out = [];
        var seen = {};
        var source = String(html || "");
        var match;
        var styleHref = /<a[^>]*style=["'][^"']*min-width[^"']*["'][^>]*href=["']([^"']+)["'][^>]*>/gi;
        var hrefStyle = /<a[^>]*href=["']([^"']+)["'][^>]*style=["'][^"']*min-width[^"']*["'][^>]*>/gi;
        var direct = /https?:\/\/(?:instant\.[^\s"'<>]+|[^"'\s<>]*gdflix[^"'\s<>]*\/(?:zfile|file)\/[^"'\s<>]+)/gi;
        var anchors = parseAnchors(source, base);
        var i;

        function push(url) {
            var normalized = normalizeExtractedUrl(url, base);
            if (!normalized || seen[normalized]) return;
            seen[normalized] = true;
            out.push(normalized);
        }

        while ((match = styleHref.exec(source)) !== null) push(match[1]);
        while ((match = hrefStyle.exec(source)) !== null) push(match[1]);
        while ((match = direct.exec(source)) !== null) push(match[0]);

        for (i = 0; i < anchors.length; i++) {
            var href = anchors[i] && anchors[i].href || "";
            if (/instant\.|gdflix|gdlink|zfile\//i.test(href)) push(href);
        }

        return out;
    }

    function resolveGdflix(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        if (!reqHeaders.Referer && !reqHeaders.referer) reqHeaders.Referer = baseOrigin(url) + "/";

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (pageRes) {
            var finalUrl = pageRes && pageRes.finalUrl || url;
            var html = String(pageRes && pageRes.body || "");
            var candidates = extractGdflixCandidates(html, finalUrl);
            var instant = "";
            var selected;
            var refererHeaders = mergeHeaders({ "Referer": finalUrl, "Origin": baseOrigin(finalUrl) });
            var mfilePath;
            var keyMatch;
            var tokenMatch;
            var formBody;
            var mfileHeaders;

            for (var i = 0; i < candidates.length; i++) {
                if (/instant\./i.test(candidates[i])) {
                    instant = candidates[i];
                    break;
                }
            }

            if (!instant && candidates.length) instant = candidates[0];

            if (!instant) {
                mfilePath = new URL(finalUrl).pathname.replace("/file/", "/mfile/");
                keyMatch = html.match(/formData\.append\("key",\s*"([^"]+)"\)/i);
                tokenMatch = html.match(/(?:var|let|const)\s+cf_token\s*=\s*['"]([^'"]+)['"]/i);
                if (!keyMatch || !tokenMatch) return [];

                formBody = "action=instant&key=" + encodeURIComponent(keyMatch[1]) + "&action_token=" + encodeURIComponent(tokenMatch[1]);
                mfileHeaders = mergeHeaders({
                    "Referer": finalUrl,
                    "Origin": baseOrigin(finalUrl),
                    "x-token": (new URL(finalUrl)).hostname,
                    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
                    "Accept": "application/json, text/plain, */*"
                });

                return networkRequest(resolveUrl(mfilePath, finalUrl), {
                    method: "POST",
                    body: formBody,
                    headers: mfileHeaders,
                    followRedirects: true
                }).then(function (mfileRes) {
                    var payload = parseJsonSafe(mfileRes && mfileRes.body || "", {});
                    var jumpUrl = normalizeExtractedUrl(payload && (payload.visit_url || payload.url), finalUrl);
                    if (!jumpUrl) return [];
                    return [buildStream(unwrapRedirectUrl(jumpUrl, finalUrl), quality, "GDFLix Direct", refererHeaders)];
                });
            }

            return networkRequest(instant, {
                headers: refererHeaders,
                followRedirects: false
            }).then(function (instantRes) {
                var location = firstHeaderValue(instantRes && instantRes.headers, ["location", "x-redirect-location"]);
                var target = unwrapRedirectUrl(location || "", instant);
                var source;

                if (target && /^https?:\/\//i.test(target)) {
                    source = /googleusercontent|googlevideo/i.test(target) ? "Google Drive" : "GDFLix Direct";
                    return [buildStream(target, quality, source, refererHeaders)];
                }

                return networkRequest(instant, {
                    headers: refererHeaders,
                    followRedirects: true
                }).then(function (followRes) {
                    var followBody = String(followRes && followRes.body || "");
                    var followUrl = followRes && followRes.finalUrl || instant;
                    var found = unwrapRedirectUrl(followUrl, instant) ||
                        unwrapRedirectUrl((followBody.match(/https?:\/\/[^\s"'<>]*\?url=[^\s"'<>]+/i) || [])[0] || "", followUrl);
                    var finalSource = /googleusercontent|googlevideo/i.test(found) ? "Google Drive" : "GDFLix Direct";
                    if (!found || !/^https?:\/\//i.test(found)) return [];
                    return [buildStream(found, quality, finalSource, refererHeaders)];
                });
            });
        }).catch(function () {
            return [];
        });
    }

    function resolveGofile(url, quality, headers) {
        var reqHeaders = cloneHeaders(headers || {});
        var finalQuality = Number(quality || 0);
        var referer = reqHeaders.Referer || reqHeaders.referer || baseOrigin(url) + "/";
        var parsed;
        var fileId = "";
        var ua = reqHeaders["User-Agent"] || reqHeaders["user-agent"] || BROWSER_HEADERS["User-Agent"];

        try {
            parsed = new URL(url);
            fileId = parsed.pathname.replace(/^\/+/, "").split("/").pop() || "";
            if (/^d$/i.test(fileId)) fileId = "";
            if (/\/d\//i.test(parsed.pathname)) {
                fileId = (parsed.pathname.match(/\/d\/([^/?#]+)/i) || [])[1] || fileId;
            }
        } catch (_) {}

        if (!fileId) return Promise.resolve([]);

        return networkRequest("https://api.gofile.io/accounts", {
            method: "POST",
            body: "",
            headers: mergeHeaders({
                "Referer": "https://gofile.io/",
                "Accept": "application/json, text/plain, */*"
            }),
            followRedirects: true
        }).then(function (tokenRes) {
            var tokenJson = parseJsonSafe(tokenRes && tokenRes.body || "", {});
            var token = tokenJson && tokenJson.data && tokenJson.data.token || "";
            if (!token) return [];

            var interval = String(Math.floor(Date.now() / 1000 / 14400));
            var baseHeaders = mergeHeaders({
                "Authorization": "Bearer " + token,
                "Referer": "https://gofile.io/",
                "Accept": "application/json, text/plain, */*",
                "User-Agent": ua
            });
            var message = [ua, "en-GB", token, interval, "gf2026x"].join("::");

            return sha256Hex(message).then(function (siteToken) {
                if (siteToken) {
                    baseHeaders["X-BL"] = "en-GB";
                    baseHeaders["X-Website-Token"] = siteToken;
                }

                var contentsUrl = "https://api.gofile.io/contents/" + encodeURIComponent(fileId) + "?contentFilter=&page=1&pageSize=1000&sortField=name&sortDirection=1";
                return networkRequest(contentsUrl, {
                    headers: baseHeaders,
                    followRedirects: true
                }).then(function (contentRes) {
                    var payload = parseJsonSafe(contentRes && contentRes.body || "", {});
                    var data = payload && payload.data || {};
                    var children = data.children || {};
                    var childKeys = Object.keys(children);
                    var out = [];
                    var seen = {};

                    for (var i = 0; i < childKeys.length; i++) {
                        var child = children[childKeys[i]] || {};
                        var link = normalizeExtractedUrl(
                            child.link || child.directLink || child.downloadPage || child.publicLink || "",
                            "https://gofile.io/"
                        );
                        if (!link || seen[link]) continue;
                        seen[link] = true;
                        pushStream(out, seen, link, finalQuality, /googleusercontent|googlevideo/i.test(link) ? "Google Drive" : "GoFile Direct", mergeHeaders({
                            "Referer": referer,
                            "Cookie": "accountToken=" + token
                        }));
                    }

                    return out;
                });
            });
        }).catch(function () {
            return [];
        });
    }

    function resolveHubCloud(url, quality, headers) {
        var reqHeaders = mergeHeaders({ "Referer": baseOrigin(url) + "/" });
        var anchorHint = /hubdrive/i.test(url) ? "HubDrive" : "HubCloud";

        function verifyHubCloudCandidate(candidateUrl, candidateQuality, candidateSource, candidateHeaders) {
            if (!candidateUrl) return Promise.resolve([]);
            if (/gpdl\.hubcdn\.fans|workers\.dev/i.test(candidateUrl)) {
                return Promise.resolve([]);
            }
            if (/pixeldrain\.dev\/api\/file\/|fsl\.gigabytes\.icu|https?:\/\/hub\.[^/]+/i.test(candidateUrl)) {
                return Promise.resolve([buildStream(candidateUrl, candidateQuality, candidateSource, candidateHeaders)]);
            }
            if (!/hub\.odyssey\.surf|fsl\.gigabytes\.icu|https?:\/\/hub\.[^/]+/i.test(candidateUrl)) {
                return Promise.resolve([buildStream(candidateUrl, candidateQuality, candidateSource, candidateHeaders)]);
            }

            return requestWithFetch(candidateUrl, "HEAD", candidateHeaders || {}, "", true).then(function (probeRes) {
                if (hasFileResponseHeaders(probeRes)) {
                    return [buildStream(probeRes.finalUrl || candidateUrl, candidateQuality, candidateSource, candidateHeaders)];
                }
                return [];
            }).catch(function () {
                return [];
            });
        }

        return networkRequest(url, {
            headers: reqHeaders,
            followRedirects: true
        }).then(function (firstRes) {
            var firstHtml = String(firstRes && firstRes.body || "");
            var firstUrl = firstRes && firstRes.finalUrl || url;
            var innerHrefMatch = firstHtml.match(/id=["']download["'][^>]*href=["']([^"']+)["']/i) ||
                firstHtml.match(/href=["']([^"']+)["'][^>]*id=["']download["']/i);
            var innerUrl = innerHrefMatch ? resolveUrl(decodeHtml(innerHrefMatch[1]), baseOrigin(firstUrl) + "/") : firstUrl;
            var innerPromise = innerUrl !== firstUrl ? networkRequest(innerUrl, {
                headers: mergeHeaders({ "Referer": baseOrigin(firstUrl) + "/" }),
                followRedirects: true
            }) : Promise.resolve(firstRes);

            return innerPromise.then(function (innerRes) {
                var html = String(innerRes && innerRes.body || firstHtml);
                var base = baseOrigin(innerRes && innerRes.finalUrl || innerUrl) || baseOrigin(innerUrl) || baseOrigin(url);
                var anchors = parseAnchors(html, base);
                var seenRaw = {};
                var rawCandidates = [];

                for (var i = 0; i < anchors.length; i++) {
                    var anchor = anchors[i];
                    var text = String(anchor.text || "");
                    var lower = text.toLowerCase();
                    var resultHeaders = mergeHeaders({ "Referer": innerRes && innerRes.finalUrl || innerUrl || url });
                    var pixelUrl = "";
                    var candidateUrl = "";
                    var candidateSource = "";
                    var key = "";

                    if (!anchor || !anchor.href) continue;
                    if (/\/drive\/admin\b/i.test(anchor.href) || /\badmin\b/i.test(lower)) continue;

                    if (/pixeldra|pixelserver|pixel server|pixeldrain/i.test(lower)) {
                        pixelUrl = /download/i.test(anchor.href)
                            ? anchor.href
                            : (baseOrigin(anchor.href) + "/api/file/" + anchor.href.split("/").pop() + "?download");
                        candidateUrl = pixelUrl;
                        candidateSource = anchorHint + " Direct";
                    } else if (/download file|download|server|file|mega|s3|buzz|gofile|drive/i.test(lower + " " + anchor.href)) {
                        candidateUrl = anchor.href;
                        candidateSource = /https?:\/\/hub\.[^/]+|hub\.odyssey\.surf|fsl\.gigabytes\.icu/i.test(anchor.href)
                            ? (anchorHint + " Direct")
                            : (detectHoster(text + " " + anchor.href) || anchorHint);
                    }

                    if (!candidateUrl) continue;
                    key = candidateSource + "||" + candidateUrl;
                    if (seenRaw[key]) continue;
                    seenRaw[key] = true;
                    rawCandidates.push({
                        url: candidateUrl,
                        quality: extractQuality(text) || quality,
                        source: candidateSource,
                        headers: resultHeaders
                    });
                }

                return Promise.all(rawCandidates.map(function (candidate) {
                    return verifyHubCloudCandidate(candidate.url, candidate.quality, candidate.source, candidate.headers);
                })).then(function (sets) {
                    var verified = dedupeResults(flattenResults(sets));
                    var fallback = rawCandidates.filter(function (candidate) {
                        return !/gpdl\.hubcdn\.fans|workers\.dev/i.test(String(candidate.url || ""));
                    }).map(function (candidate) {
                        return buildStream(candidate.url, candidate.quality, candidate.source, candidate.headers);
                    });
                    return dedupeResults(verified.concat(fallback));
                });
            });
        }).catch(function () {
            return [];
        });
    }

    function resolveStreamCandidate(item, depth) {
        var url;
        var unwrapped;
        var unwrappedSource;
        var unwrappedHeaders;
        depth = Number(depth || 0);
        if (!item || !item.url || depth > 2) return Promise.resolve(item ? [item] : []);
        url = String(item.url || "");
        unwrapped = unwrapRedirectUrl(url, url);
        if (unwrapped && unwrapped !== url && looksDirect(unwrapped)) {
            unwrappedSource = /googleusercontent|googlevideo/i.test(unwrapped)
                ? "Google Drive"
                : (item.source || detectHoster(unwrapped) || "Direct");
            unwrappedHeaders = mergeHeaders(item.headers || {
                "Referer": baseOrigin(url) + "/"
            });
            return Promise.resolve([buildStream(unwrapped, item.quality, unwrappedSource, unwrappedHeaders)]);
        }
        if (looksDirect(url)) return Promise.resolve([item]);

        if (/links\.kmhd\.eu\/play\?/i.test(url)) {
            return withTimeout(resolveKmhdPlayPage(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return Promise.all(results.map(function (resolved) {
                    return resolveStreamCandidate(resolved, depth + 1);
                })).then(function (nested) {
                    return dedupeResults(flattenResults(nested));
                });
            }).catch(function () {
                return [item];
            });
        }

        if (/1xplayer/i.test(String(item.source || "")) || isInterestingPlayerUrl(url)) {
            return withTimeout(resolve1xPlayer(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return Promise.all(results.map(function (resolved) {
                    return resolveStreamCandidate(resolved, depth + 1);
                })).then(function (nested) {
                    return dedupeResults(flattenResults(nested));
                });
            }).catch(function () {
                return [item];
            });
        }

        if (/streamtape\.(?:com|co)\/(?:e|v)\//i.test(url) || /shavetape\.cash\/(?:e|v)\//i.test(url)) {
            return withTimeout(resolveStreamTape(url, item.quality, item.headers || {}), 12000).then(function (results) {
                return results && results.length ? results : [item];
            }).catch(function () {
                return [item];
            });
        }

        if (/streamwish|hglink\.to|hgplaycdn|filelions|uqloads|davioad|yuguaab|guxhag|taylorplayer|mivalyo|habetar|ghbrisk/i.test(url)) {
            return withTimeout(resolveStreamWish(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return results;
            }).catch(function () {
                return [item];
            });
        }

        if (/send\.cm|send\.now/i.test(url)) {
            return withTimeout(resolveSend(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return results;
            }).catch(function () {
                return [item];
            });
        }

        if (/1fichier\.com/i.test(url)) {
            return withTimeout(resolveOneFichier(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return results;
            }).catch(function () {
                return [item];
            });
        }

        if (/download\.bbupload\.to\/download\?|bullstream\.|getnowit\.site\/get\//i.test(url)) {
            return withTimeout(resolveBBUpload(url, item.quality, item.headers || {}), 12000).then(function (results) {
                return results && results.length ? results : [item];
            }).catch(function () {
                return [item];
            });
        }

        if (/gofile\.io\/(?:d|file|download)\//i.test(url)) {
            return withTimeout(resolveGofile(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return results;
            }).catch(function () {
                return [item];
            });
        }

        if (/gdflix|gdlink|instant\.[^/]+|fastcdn-dl\.pages\.dev/i.test(url)) {
            return withTimeout(resolveGdflix(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return Promise.all(results.map(function (resolved) {
                    return resolveStreamCandidate(resolved, depth + 1);
                })).then(function (nested) {
                    return dedupeResults(flattenResults(nested));
                });
            }).catch(function () {
                return [item];
            });
        }

        if (/hubcloud\.|hubcloud\.fans|hubcloud\.foo|hubdrive\.|gamerxyt\.com\/hubcloud\.php/i.test(url)) {
            return withTimeout(resolveHubCloud(url, item.quality, item.headers || {}), 12000).then(function (results) {
                if (!results || !results.length) return [item];
                return Promise.all(results.map(function (resolved) {
                    return resolveStreamCandidate(resolved, depth + 1);
                })).then(function (nested) {
                    return dedupeResults(flattenResults(nested));
                });
            }).catch(function () {
                return [item];
            });
        }

        return Promise.resolve([item]);
    }

    function unlockKmhdFilePage(fileUrl, referer) {
        var initialHeaders = mergeHeaders({ "Referer": referer || BROWSER_HEADERS.Referer });
        return networkRequest(fileUrl, {
            headers: initialHeaders,
            followRedirects: true
        }).then(function (firstRes) {
            var firstHtml = String(firstRes && firstRes.body || "");
            var base = baseOrigin(firstRes && firstRes.finalUrl || fileUrl) || baseOrigin(fileUrl);

            if (/upload_links:\{[\s\S]*?\},size:/i.test(firstHtml)) {
                return {
                    html: firstHtml,
                    finalUrl: firstRes && firstRes.finalUrl || fileUrl,
                    headers: mergeHeaders({ "Referer": fileUrl })
                };
            }

            var actionMatch = firstHtml.match(/<form[^>]*method=["']POST["'][^>]*action=["']([^"']+)["']/i) ||
                firstHtml.match(/action=["']([^"']*\?\/unlock(?:&amp;|&)[^"']*)["']/i);
            if (!actionMatch) {
                return {
                    html: firstHtml,
                    finalUrl: firstRes && firstRes.finalUrl || fileUrl,
                    headers: mergeHeaders({ "Referer": fileUrl })
                };
            }

            var actionUrl = decodeHtml(actionMatch[1]);
            var finalUrl = resolveRequestUrl(firstRes && firstRes.finalUrl || fileUrl, {
                headers: { "Referer": fileUrl }
            });
            var redirectToken = decodeQueryParam(resolveUrl(actionUrl, finalUrl), "redirect") ||
                decodeQueryParam(finalUrl, "redirect") ||
                (actionUrl.match(/(?:\?|&)redirect=([^&"']+)/i) || [])[1] ||
                "";
            var lockedUrl = /\/locked\?/i.test(finalUrl) ? finalUrl : base + "/locked?redirect=" + redirectToken;
            var unlockUrl = resolveRequestUrl(actionUrl, {
                headers: { "Referer": lockedUrl }
            });
            if (!unlockUrl || isKnownErrorUrl(unlockUrl)) {
                log("Unlock action resolved to error path, skipping:", unlockUrl);
                return {
                    html: firstHtml,
                    finalUrl: firstRes && firstRes.finalUrl || fileUrl,
                    headers: mergeHeaders({ "Referer": fileUrl })
                };
            }
            log("Unlocking page:", unlockUrl);
            return networkRequest(unlockUrl, {
                method: "POST",
                body: "",
                followRedirects: false,
                headers: mergeHeaders({
                    "Origin": base,
                    "Referer": lockedUrl,
                    "Content-Type": "application/x-www-form-urlencoded"
                })
            }).then(function (unlockRes) {
                var unlockJson = parseJsonSafe(unlockRes && unlockRes.body || "", {});
                var cookieHeader = extractCookieHeader(unlockRes && unlockRes.headers || "");
                if (!cookieHeader && unlockJson && (unlockJson.type === "redirect" || unlockJson.location)) {
                    cookieHeader = "unlocked=true";
                }
                if (!cookieHeader && unlockRes && unlockRes.status && unlockRes.status < 400) {
                    cookieHeader = "unlocked=true";
                }
                var nextUrl = normalizeExtractedUrl(
                    unlockJson.location ||
                    unlockJson.redirect ||
                    (unlockRes && unlockRes.headers && (unlockRes.headers.location || unlockRes.headers["x-redirect-location"])) ||
                    fileUrl,
                    base + "/"
                ) || fileUrl;
                if (isKnownErrorUrl(nextUrl)) nextUrl = fileUrl;
                log("Unlock response:", unlockRes && unlockRes.status, "cookie:", cookieHeader ? "yes" : "no", "next:", nextUrl);

                return networkRequest(nextUrl, {
                    headers: mergeHeaders({
                        "Referer": lockedUrl,
                        "Origin": base,
                        "Cookie": cookieHeader
                    }),
                    followRedirects: true
                }).then(function (finalRes) {
                    log("Unlocked page marker:", /upload_links:\{[\s\S]*?\},size:/i.test(String(finalRes && finalRes.body || "")) ? "streamed-data" : "no-data");
                    return {
                        html: String(finalRes && finalRes.body || ""),
                        finalUrl: finalRes && finalRes.finalUrl || nextUrl,
                        headers: mergeHeaders({
                            "Referer": nextUrl,
                            "Origin": base,
                            "Cookie": cookieHeader
                        })
                    };
                });
            });
        });
    }

    function filterResolvedResults(results) {
        return dedupeResults((results || []).filter(function (item) {
            var url = String(item && item.url || "");
            if (!url) return false;
            if (/gamerxyt\.com\/hubcloud\.php/i.test(url)) return false;
            if (/links\.kmhd\.eu\/play\?/i.test(url) && !looksDirect(url)) return false;
            if (isInterestingPlayerUrl(url) && !looksDirect(url)) return false;
            return true;
        }));
    }

    function normalizeStreamPayload(payload, fallbackReferer) {
        if (!payload) return null;

        if (typeof payload === "string") {
            if (!/^https?:\/\//i.test(payload)) return null;
            return {
                type: "direct",
                url: payload,
                quality: extractQuality(payload),
                pageUrl: fallbackReferer || BROWSER_HEADERS.Referer,
                source: detectHoster(payload) || "Source"
            };
        }

        if (typeof payload !== "object" || !payload.url) return null;
        return {
            type: payload.type || "direct",
            url: String(payload.url || ""),
            quality: Number(payload.quality || extractQuality(payload.url || payload.source || "")),
            pageUrl: payload.pageUrl || fallbackReferer || BROWSER_HEADERS.Referer,
            source: payload.source || detectHoster(payload.url) || "Source",
            headers: payload.headers || null
        };
    }

    function parseLoadStreamsInput(input) {
        var raw = typeof input === "string" ? input : "";
        var parsed = null;
        var payloads = [];
        var source;

        if (typeof input === "string") {
            parsed = parseJsonSafe(raw, null);
        } else if (Array.isArray(input)) {
            parsed = input;
        } else if (input && typeof input === "object") {
            if (input.url && typeof input.url === "string") {
                parsed = parseJsonSafe(input.url, input);
            } else {
                parsed = input;
            }
        }

        source = Array.isArray(parsed) ? parsed : (parsed ? [parsed] : [raw]);

        for (var i = 0; i < source.length; i++) {
            var payload = normalizeStreamPayload(source[i], BROWSER_HEADERS.Referer);
            if (payload && payload.url) payloads.push(payload);
        }

        return payloads;
    }

    async function collectStreamsFromPayload(payload) {
        if (!payload || !payload.url) return [];
        log("Loading streams for quality:", payload.quality, payload.url);

        if (payload.type !== "intermediate") {
            return [
                buildStream(
                    payload.url,
                    payload.quality,
                    payload.source || detectHoster(payload.url) || "Source",
                    mergeHeaders({ "Referer": payload.pageUrl || BROWSER_HEADERS.Referer })
                )
            ];
        }

        if (!/links\.kmhd\.eu\/(?:file|play)\b/i.test(String(payload.url || ""))) {
            return [
                buildStream(
                    payload.url,
                    payload.quality,
                    payload.source || detectHoster(payload.url) || "Source",
                    mergeHeaders(payload.headers || {
                        "Referer": payload.pageUrl || baseOrigin(payload.url) + "/"
                    })
                )
            ];
        }

        var page = await unlockKmhdFilePage(payload.url, payload.pageUrl || BROWSER_HEADERS.Referer);
        var html = String(page && page.html || "");
        var results = extractStreamsFromStreamedData(html, payload.quality, page.headers);

        if (!results.length) {
            log("No streamed JSON links found, falling back to anchor scan");
            results = extractStreamsFromAnchors(html, page.finalUrl || payload.url, payload.quality, page.headers);
        }

        return results;
    }

    function collectPayloadSets(payloads) {
        return Promise.all((payloads || []).map(function (payload) {
            return withTimeout(collectStreamsFromPayload(payload), 10000).catch(function () {
                return [];
            });
        }));
    }

    function buildAppStreamResult(item) {
        var url = String(item && item.url || "");
        var sourceText = String(item && item.source || "") + " " + url;
        var quality = Number(item && item.quality || extractQuality(sourceText));

        return new StreamResult({
            url: url,
            quality: quality || undefined,
            source: formatStreamSource(item && item.source || detectHoster(url) || "Source", quality),
            headers: item && item.headers || {}
        });
    }

    async function resolveFinalStreams(results, fallback) {
        var resolvedSets = await Promise.all((results || []).map(function (item) {
            return resolveStreamCandidate(item, 0);
        }));
        var resolved = filterResolvedResults(flattenResults(resolvedSets));
        var filteredFallback = filterResolvedResults(fallback || results || []);
        var finalResults = sortResults(resolved.length ? resolved : filteredFallback);
        log("Total streams:", finalResults.length);
        return finalResults.map(buildAppStreamResult);
    }

    async function loadStreams(url, cb) {
        try {
            var payloads = parseLoadStreamsInput(url);
            if (!payloads.length) {
                cb({ success: true, data: [] });
                return;
            }

            var sets = await collectPayloadSets(payloads);
            var initialResults = flattenResults(sets);
            if (!initialResults.length && payloads.length === 1 && payloads[0] && payloads[0].url && payloads[0].type !== "intermediate") {
                initialResults = [
                    buildStream(
                        payloads[0].url,
                        payloads[0].quality,
                        payloads[0].source || detectHoster(payloads[0].url) || "Source",
                        mergeHeaders({ "Referer": payloads[0].pageUrl || BROWSER_HEADERS.Referer })
                    )
                ];
            }

            var streams = await resolveFinalStreams(initialResults, initialResults);
            cb({ success: true, data: streams });
        } catch (error) {
            log("Error:", error && error.message || error);
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
