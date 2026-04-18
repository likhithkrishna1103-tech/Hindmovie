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
            return http_get(d + "/", { headers: BROWSER_HEADERS });
        }).then(function (res) {
            var items = extractListingItems(res.body);

            var sections = {};
            if (items.length > 0) {
                var feat = items.slice(0, Math.min(6, items.length));
                sections["\ud83d\udd25 Featured"] = feat.map(function(i) { return new MultimediaItem(i); });

                var rest = items.slice(6);
                if (rest.length > 0) {
                    sections["\ud83c\udd95 Latest"] = rest.map(function(i) { return new MultimediaItem(i); });
                }
            }

            cb({ success: true, data: sections });
        }).catch(function (e) { cb({ success: false, errorCode: "HOME_ERROR", message: e.message }); });
    }

    function search(q, cb) {
        getDomain().then(function (d) {
            return http_get(d + "/?s=" + encodeURIComponent(q), { headers: BROWSER_HEADERS });
        }).then(function (res) {
            var rawItems = extractListingItems(res.body);
            var items = rawItems.map(function (item) {
                return new MultimediaItem({
                    title: item.title,
                    url: item.url,
                    posterUrl: item.posterUrl,
                    type: item.type,
                    quality: item.quality
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
            if (h1m) title = strip(h1m[1]);

            var poster = null;
            var ogm = html.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/);
            if (ogm) poster = ogm[1];

            var eps = [];
            var seen = {};

            // Find quality links
            var am = html.match(/<a[^>]*href="([^"]+)"[^>]*>([\s\S]*?)<\/a>/gi);
            if (am) {
                for (var i = 0; i < am.length; i++) {
                    var m = am[i].match(/href="([^"]+)"/);
                    var tm = am[i].match(/>([\s\S]*?)<\/a>/);
                    if (!m || !tm) continue;

                    var href = m[1];
                    var text = strip(tm[1]).toLowerCase();

                    if (seen[href]) continue;
                    if (href.indexOf("#") === 0) continue;
                    if (href.indexOf("javascript:") !== -1) continue;
                    if (text.indexOf("share") !== -1) continue;
                    if (href.indexOf("facebook.com") !== -1) continue;

                    var q = 0;
                    var label = "";
                    if (text.indexOf("1080") !== -1 || href.indexOf("1080") !== -1) { q = 1080; label = "1080p"; }
                    else if (text.indexOf("720") !== -1 || href.indexOf("720") !== -1) { q = 720; label = "720p"; }
                    else if (text.indexOf("480") !== -1 || href.indexOf("480") !== -1) { q = 480; label = "480p"; }
                    else if (text.indexOf("2160") !== -1 || text.indexOf("4k") !== -1) { q = 2160; label = "4K"; }

                    if (q > 0 && (href.indexOf("links.kmhd") !== -1 || href.indexOf("katdrive") !== -1)) {
                        seen[href] = true;
                        eps.push(new Episode({
                            name: label + " Links",
                            url: JSON.stringify({ type: "intermediate", url: href, quality: q, pageUrl: url })
                        }));
                    }
                }
            }

            eps.sort(function(a, b) {
                var qa = JSON.parse(a.url).quality;
                var qb = JSON.parse(b.url).quality;
                return qb - qa;
            });

            cb({ success: true, data: new MultimediaItem({
                title: title || "Unknown",
                url: url,
                posterUrl: poster,
                type: /season|episode/i.test(title) ? "series" : "movie",
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
        if (typeof fetch === "function") {
            return requestWithFetch(
                url,
                String(options.method || "GET").toUpperCase(),
                options.headers || {},
                typeof options.body === "undefined" ? "" : options.body,
                options.followRedirects !== false
            );
        }
        return request(url, options);
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

    function resolveUrl(url, base) {
        try {
            return new URL(url, base).toString();
        } catch (_) {
            return String(url || "");
        }
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
        if (value.indexOf("gdflix") !== -1 || value.indexOf("gdlink") !== -1) return "GDFLix";
        if (value.indexOf("hubcloud") !== -1 || value.indexOf("hubdrive") !== -1) return "HubCloud";
        if (value.indexOf("katdrive") !== -1) return "Katdrive";
        if (value.indexOf("send.cm") !== -1 || value.indexOf("sendcm") !== -1) return "Send.cm";
        if (value.indexOf("1fichier") !== -1) return "1Fichier";
        if (value.indexOf("clicknupload") !== -1) return "ClicknUpload";
        if (value.indexOf("gofile") !== -1) return "GoFile";
        if (value.indexOf("streamtape") !== -1) return "StreamTape";
        if (value.indexOf("streamwish") !== -1) return "StreamWish";
        if (value.indexOf("mega") !== -1) return "Mega";
        if (value.indexOf("drive.google") !== -1 || value.indexOf("google drive") !== -1) return "Google Drive";
        return "";
    }

    function isInterestingStreamUrl(url) {
        return /gdflix|gdlink|hubcloud|hubdrive|katdrive|send\.cm|1fichier|clicknupload|gofile|streamtape|streamwish|mega\.nz|drive\.google/i.test(String(url || ""));
    }

    function parseAnchors(html, base) {
        var out = [];
        var re = /<a([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = re.exec(String(html || ""))) !== null) {
            var inner = match[4] || "";
            var imgMatch = inner.match(/<img[^>]+(?:src|data-src)=["']([^"']+)["']/i);
            out.push({
                href: resolveUrl(decodeHtml(match[2]), base),
                text: strip(inner),
                html: inner,
                img: imgMatch ? decodeHtml(imgMatch[1]) : ""
            });
        }
        return out;
    }

    function addStreamResult(out, seen, rawUrl, base, sourceHint, quality, headers) {
        var candidates = expandCandidateUrls(rawUrl, base);
        if (!candidates.length) candidates = [normalizeExtractedUrl(rawUrl, base)];

        for (var i = 0; i < candidates.length; i++) {
            var candidate = candidates[i];
            if (!candidate || !/^https?:\/\//i.test(candidate)) continue;
            var hoster = detectHoster(sourceHint + " " + candidate);
            if (!hoster && !isInterestingStreamUrl(candidate)) continue;
            if (seen[candidate]) continue;
            seen[candidate] = true;
            out.push(new StreamResult({
                url: candidate,
                quality: quality || extractQuality(sourceHint + " " + candidate),
                source: hoster || "Source",
                headers: headers
            }));
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
            var hint = [anchor.text, anchor.img, anchor.html, anchor.href].join(" ");
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

            var actionMatch = firstHtml.match(/action=["']\?\/unlock(?:&amp;|&)redirect=([^"'&]+(?:={0,2})?)[^"']*["']/i);
            if (!actionMatch) {
                return {
                    html: firstHtml,
                    finalUrl: firstRes && firstRes.finalUrl || fileUrl,
                    headers: mergeHeaders({ "Referer": fileUrl })
                };
            }

            var redirectToken = decodeHtml(actionMatch[1]);
            var lockedUrl = base + "/locked?redirect=" + redirectToken;
            var unlockUrl = base + "/locked?/unlock&redirect=" + redirectToken;
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

    function loadStreams(url, cb) {
        try {
            var p = JSON.parse(url);
            log("Loading streams for quality:", p.quality, p.url);

            unlockKmhdFilePage(p.url, p.pageUrl || BROWSER_HEADERS.Referer).then(function (page) {
                var html = String(page && page.html || "");
                var results = extractStreamsFromStreamedData(html, p.quality, page.headers);

                if (!results.length) {
                    log("No streamed JSON links found, falling back to anchor scan");
                    results = extractStreamsFromAnchors(html, page.finalUrl || p.url, p.quality, page.headers);
                }

                log("Total streams:", results.length);
                cb({ success: true, data: results });
            }).catch(function (e) {
                log("Error:", e.message);
                cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
            });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    if (typeof globalThis !== "undefined") {
        globalThis.getHome = getHome; globalThis.search = search;
        globalThis.load = load; globalThis.loadStreams = loadStreams;
    }
    if (typeof window !== "undefined") {
        window.getHome = getHome; window.search = search;
        window.load = load; window.loadStreams = loadStreams;
    }
})();
