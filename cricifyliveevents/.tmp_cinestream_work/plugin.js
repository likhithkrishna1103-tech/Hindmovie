(function () {
    "use strict";

    var TMDB_API = "https://api.themoviedb.org/3";
    var TMDB_WORKER_API = "https://wild-surf-4a0d.phisher1.workers.dev";
    var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    var TMDB_IMAGE = "https://image.tmdb.org/t/p/original";

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
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">"));
    }

    function stripTags(value) {
        return decodeHtml(String(value == null ? "" : value).replace(/<br\s*\/?>/gi, "\n").replace(/<[^>]+>/g, " "));
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
        return 0;
    }

    function requestWithFetch(url, method, headers, body, allowRedirects) {
        if (typeof fetch !== "function") {
            return Promise.reject(new Error("Fetch not available"));
        }
        return fetch(url, {
            method: method,
            headers: headers,
            body: body,
            redirect: allowRedirects ? "follow" : "manual"
        }).then(function (res) {
            return res.text().then(function (bodyText) {
                return {
                    status: res.status,
                    body: bodyText,
                    headers: parseHeaders(res.headers),
                    finalUrl: res.url || url
                };
            });
        });
    }

    function request(url, options) {
        options = options || {};
        var method = String(options.method || "GET").toUpperCase();
        var headers = options.headers || {};
        var body = options.body;
        var allowRedirects = options.allowRedirects !== false;

        if (method === "GET" && typeof http_get === "function") {
            return Promise.resolve(http_get(url, headers)).then(function (res) {
                var normalized = {
                    status: responseStatus(res) || 200,
                    body: res && typeof res.body !== "undefined" ? res.body : "",
                    headers: parseHeaders(res && res.headers),
                    finalUrl: (res && (res.url || res.finalUrl)) || url
                };
                if (normalized.status >= 500 && typeof fetch === "function") {
                    return requestWithFetch(url, method, headers, body, allowRedirects).catch(function () {
                        return normalized;
                    });
                }
                return normalized;
            });
        }

        if (method === "POST" && typeof http_post === "function") {
            var attempts = [
                function () { return http_post(url, headers, body); },
                function () { return http_post(url, body, headers); }
            ];
            return (async function () {
                var lastResponse = null;
                var lastError = null;
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
                        lastResponse = normalized;
                    } catch (error) {
                        lastError = error;
                    }
                }
                if (lastResponse) return lastResponse;
                throw lastError || new Error("POST failed: " + url);
            })();
        }

        if (typeof fetch === "function") {
            return requestWithFetch(url, method, headers, body, allowRedirects);
        }

        return Promise.reject(new Error("No HTTP client available"));
    }

    function getText(url, headers, allowRedirects) {
        return request(url, { headers: headers || {}, allowRedirects: allowRedirects }).then(function (res) {
            if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
            return String(res.body || "");
        });
    }

    function getJson(url, headers) {
        return request(url, { headers: headers || {} }).then(function (res) {
            if (res.status >= 400) throw new Error("GET failed (" + res.status + "): " + url);
            return parseJsonSafe(res.body, {});
        });
    }

    function postJson(url, body, headers) {
        return request(url, {
            method: "POST",
            body: typeof body === "string" ? body : JSON.stringify(body),
            headers: Object.assign({
                "Content-Type": "application/json; charset=utf-8"
            }, headers || {})
        }).then(function (res) {
            if (res.status >= 400) throw new Error("POST failed (" + res.status + "): " + url);
            return String(res.body || "");
        });
    }

    function absoluteUrl(base, path) {
        if (!path) return "";
        try {
            return new URL(path, base).toString();
        } catch (_) {
            return String(path || "");
        }
    }

    function baseOrigin(url) {
        try {
            var parsed = new URL(url);
            return parsed.protocol + "//" + parsed.host;
        } catch (_) {
            return "";
        }
    }

    function firstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return trim(match[1]);
        }
        return "";
    }

    function parseAnchors(html, base) {
        var source = String(html || "");
        var out = [];
        var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = regex.exec(source))) {
            out.push({
                href: absoluteUrl(base, decodeHtml(match[1])),
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

    function qualityFromText(text) {
        var value = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b|\buhd\b/.test(value)) return 2160;
        if (/\b1440p\b/.test(value)) return 1440;
        if (/\b1080p\b/.test(value)) return 1080;
        if (/\b720p\b/.test(value)) return 720;
        if (/\b576p\b/.test(value)) return 576;
        if (/\b480p\b/.test(value)) return 480;
        if (/\b360p\b/.test(value)) return 360;
        return 0;
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

    function flatten(items) {
        var out = [];
        for (var i = 0; i < (items || []).length; i++) {
            out = out.concat(items[i] || []);
        }
        return out;
    }

    function uniqueValues(list) {
        return uniqueBy((list || []).filter(Boolean), function (item) {
            return String(item);
        });
    }

    function normalizeTitle(value) {
        return trim(String(value || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/\b(the|a|an)\b/g, " ")
            .replace(/[^a-z0-9]+/g, " "));
    }

    function titleScore(candidate, queries) {
        var cand = normalizeTitle(candidate);
        if (!cand) return 0;
        var best = 0;
        for (var i = 0; i < queries.length; i++) {
            var query = normalizeTitle(queries[i]);
            if (!query) continue;
            if (cand === query) best = Math.max(best, 100);
            else if (cand.indexOf(query) !== -1 || query.indexOf(cand) !== -1) best = Math.max(best, 75);
            else {
                var candTokens = cand.split(" ");
                var queryTokens = query.split(" ");
                var common = 0;
                for (var j = 0; j < candTokens.length; j++) {
                    if (queryTokens.indexOf(candTokens[j]) !== -1) common++;
                }
                best = Math.max(best, Math.round((common / Math.max(queryTokens.length, 1)) * 60));
            }
        }
        return best;
    }

    function bestMatch(list, queries, year, typeHint) {
        var ranked = [];
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var score = titleScore(item && item.title, queries);
            if (score <= 0) continue;
            if (year && item && item.year) {
                if (String(item.year) === String(year)) score += 18;
                else if (Math.abs(Number(item.year) - Number(year)) <= 1) score += 8;
            }
            if (typeHint && item && item.type && String(item.type) === String(typeHint)) score += 5;
            ranked.push({ item: item, score: score });
        }
        ranked.sort(function (a, b) { return b.score - a.score; });
        return ranked.length ? ranked[0].item : null;
    }

    function dedupeStreams(list) {
        return uniqueBy((list || []).filter(function (item) {
            return !!(item && item.url);
        }), function (item) {
            return String(item.url) + "|" + JSON.stringify(item.headers || {}) + "|" + String(item.drmKey || "") + "|" + String(item.drmKid || "");
        });
    }

    function sortStreams(list) {
        return list.slice().sort(function (a, b) {
            return Number(b.quality || 0) - Number(a.quality || 0);
        });
    }

    function withTimeout(promise, ms, label) {
        return Promise.race([
            Promise.resolve(promise),
            new Promise(function (_, reject) {
                setTimeout(function () {
                    reject(new Error((label || "Operation") + " timed out"));
                }, ms);
            })
        ]);
    }

    var DOMAINS_JSON_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
    var COMMON_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var domainsCache = null;
    var domainsCacheAt = 0;
    var DOMAIN_CACHE_TTL = 30 * 60 * 1000;

    function commonHeaders(extra) {
        return Object.assign({
            "User-Agent": COMMON_USER_AGENT,
            "Accept": "*/*"
        }, extra || {});
    }

    async function getDomainsJson() {
        if (domainsCache && (Date.now() - domainsCacheAt) < DOMAIN_CACHE_TTL) return domainsCache;
        try {
            domainsCache = await getJson(DOMAINS_JSON_URL, commonHeaders({ "Accept": "application/json" }));
        } catch (_) {
            domainsCache = {};
        }
        domainsCacheAt = Date.now();
        return domainsCache || {};
    }

    async function getDynamicDomain(key, fallback) {
        var json = await getDomainsJson().catch(function () { return {}; });
        var value = trim(String(json && json[key] || fallback || ""));
        return value.replace(/\/+$/g, "");
    }

    function createSlugText(value) {
        return trim(String(value || "")
            .toLowerCase()
            .replace(/&/g, " and ")
            .replace(/['"`]/g, "")
            .replace(/[:(),.!?]/g, " ")
            .replace(/[^a-z0-9]+/g, "-")
            .replace(/-+/g, "-")
            .replace(/^-|-$/g, ""));
    }

    function isCommonDirectMediaUrl(url) {
        var value = String(url || "");
        return /\.(?:m3u8|mp4|mkv|webm|avi|mpd)(?:[?#].*)?$/i.test(value)
            || /\/api\/file\/[^/?]+(?:\?download)?$/i.test(value)
            || /hdm2\.ink\/playlist\//i.test(value);
    }

    function isCommonInterestingUrl(url) {
        return /(?:gofile|hubcloud|hubdrive|filepress|filebee|gdfli?x|gdtot|m4ulinks|mdrive|linksmod|nexdrive|gadgetsweb|cryptoinsights|fastdlserver|fastdl\.zip|vcloud\.zip|rubystm|streamruby|vidstreaming|pixeldrain|1fichier|clicknupload|streamtape|ok\.ru|multiup|\.m3u8|\.mp4|\.mkv|\.avi|\.mpd)/i.test(String(url || ""));
    }

    function normalizeResolvedUrl(rawValue, base) {
        var value = String(rawValue || "");
        if (!value) return "";
        value = decodeHtml(value)
            .replace(/\\u002F/gi, "/")
            .replace(/\\u003A/gi, ":")
            .replace(/\\u0026/gi, "&")
            .replace(/\\\//g, "/")
            .replace(/&amp;/gi, "&")
            .replace(/^["'`(]+/, "")
            .replace(/["'`),;]+$/, "");
        if (/^\/\//.test(value)) value = "https:" + value;
        if (/^www\./i.test(value)) value = "https://" + value;
        if (!/^https?:\/\//i.test(value) && base) value = absoluteUrl(base, value);
        return value;
    }

    function decodeQueryValue(url, name) {
        try {
            return new URL(String(url || "")).searchParams.get(name) || "";
        } catch (_) {
            return "";
        }
    }

    function extractInterestingUrlsGlobal(html, base) {
        var out = [];
        var seen = {};

        function add(raw) {
            var value = normalizeResolvedUrl(raw, base);
            if (!value || seen[value]) return;
            seen[value] = true;
            if (isCommonInterestingUrl(value) || isCommonDirectMediaUrl(value)) out.push(value);
            ["url", "link", "file", "redirect", "dl", "download", "target"].forEach(function (name) {
                var nested = normalizeResolvedUrl(decodeQueryValue(value, name), base);
                if (!nested || seen[nested]) return;
                if (isCommonInterestingUrl(nested) || isCommonDirectMediaUrl(nested)) {
                    seen[nested] = true;
                    out.push(nested);
                }
            });
        }

        parseAnchors(html, base).forEach(function (anchor) {
            add(anchor && anchor.href);
        });

        var regexes = [
            /https?:\/\/[^\s"'<>\\]+/gi,
            /(?:href|src|data-stream-url)\s*=\s*["']([^"']+)["']/gi,
            /"(?:url|link|file|download(?:Url)?)"\s*:\s*"([^"]+)"/gi,
            /location(?:\.href)?\s*=\s*["']([^"']+)["']/gi
        ];
        for (var i = 0; i < regexes.length; i++) {
            var regex = regexes[i];
            var match;
            while ((match = regex.exec(String(html || "")))) add(match[1] || match[0]);
        }

        return uniqueBy(out, function (item) { return item; });
    }

    function buildResolvedStream(url, label, quality, headers) {
        return {
            url: url,
            source: label,
            quality: quality || qualityFromText(url),
            headers: headers || {}
        };
    }

    function baseConvertGlobal(number, radix) {
        var chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (radix <= 36) return Number(number).toString(radix);
        var value = Number(number);
        if (!value) return "0";
        var result = "";
        while (value > 0) {
            result = chars[value % radix] + result;
            value = Math.floor(value / radix);
        }
        return result;
    }

    function unpackPackedScriptGlobal(script) {
        try {
            if (String(script || "").indexOf("function(p,a,c,k,e") === -1) return "";
            var bracePos = script.lastIndexOf("}(");
            if (bracePos === -1) return "";
            var pos = bracePos + 2;
            var len = script.length;

            function skipWs() {
                while (pos < len && /\s/.test(script.charAt(pos))) pos++;
            }

            function readString() {
                var quote = script.charAt(pos++);
                var out = "";
                while (pos < len) {
                    var ch = script.charAt(pos);
                    if (ch === "\\") {
                        pos++;
                        var esc = script.charAt(pos) || "";
                        var map = { "n": "\n", "r": "\r", "t": "\t", "\\": "\\", "'": "'", "\"": "\"" };
                        out += Object.prototype.hasOwnProperty.call(map, esc) ? map[esc] : esc;
                        pos++;
                    } else if (ch === quote) {
                        pos++;
                        break;
                    } else {
                        out += ch;
                        pos++;
                    }
                }
                return out;
            }

            function readInt() {
                var start = pos;
                while (pos < len && /\d/.test(script.charAt(pos))) pos++;
                return Number(script.slice(start, pos));
            }

            function skipComma() {
                skipWs();
                if (script.charAt(pos) === ",") pos++;
                skipWs();
            }

            skipWs();
            if (script.charAt(pos) !== "'" && script.charAt(pos) !== "\"") return "";
            var payload = readString();
            skipComma();
            var radix = readInt();
            skipComma();
            var wordCount = readInt();
            skipComma();
            var keys = [];
            if (script.charAt(pos) === "'" || script.charAt(pos) === "\"") {
                keys = readString().split("|");
            } else if (script.charAt(pos) === "[") {
                pos++;
                while (pos < len && script.charAt(pos) !== "]") {
                    skipWs();
                    if (script.charAt(pos) === "'" || script.charAt(pos) === "\"") keys.push(readString());
                    else {
                        keys.push("");
                        pos++;
                    }
                    skipWs();
                    if (script.charAt(pos) === ",") pos++;
                }
            } else {
                return "";
            }

            if (!radix || radix < 2 || wordCount < 0) return "";
            while (wordCount--) {
                if (keys[wordCount]) {
                    payload = payload.replace(new RegExp("\\b" + baseConvertGlobal(wordCount, radix) + "\\b", "g"), keys[wordCount]);
                }
            }
            return payload;
        } catch (_) {
            return "";
        }
    }

    async function resolveGofileGlobal(url, label) {
        var idMatch = String(url || "").match(/(?:\?c=|\/d\/)([\da-zA-Z-]+)/i);
        if (!idMatch) return [];
        var folderId = idMatch[1];
        var accountRes = await request("https://api.gofile.io/accounts", {
            method: "POST",
            body: "",
            headers: commonHeaders({ "Referer": "https://gofile.io/" })
        }).catch(function () { return null; });
        var accountJson = accountRes ? parseJsonSafe(accountRes.body, {}) : {};
        var token = accountJson && accountJson.data && accountJson.data.token;
        if (!token) return [];
        var globalJs = await getText("https://gofile.io/dist/js/global.js", commonHeaders({ "Referer": "https://gofile.io/" })).catch(function () { return ""; });
        var wt = firstMatch(globalJs, [/appdata\.wt\s*=\s*["']([^"']+)["']/i]);
        if (!wt) return [];
        var json = await getJson("https://api.gofile.io/contents/" + folderId + "?wt=" + encodeURIComponent(wt), {
            "Authorization": "Bearer " + token,
            "User-Agent": COMMON_USER_AGENT
        }).catch(function () { return {}; });
        var children = json && json.data && json.data.children || {};
        var out = [];
        for (var key in children) {
            if (!Object.prototype.hasOwnProperty.call(children, key)) continue;
            var file = children[key];
            if (!file || !file.link) continue;
            out.push(buildResolvedStream(file.link, label || "GoFile", qualityFromText(file.name || file.link), {}));
        }
        return out;
    }

    async function resolveHubCloudGlobal(url, label) {
        var html = await getText(url, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
        var innerHref = firstMatch(html, [
            /id=["']download["'][^>]*href=["']([^"']+)["']/i,
            /href=["']([^"']+)["'][^>]*id=["']download["']/i
        ]);
        var innerUrl = absoluteUrl(baseOrigin(url), innerHref || url);
        var innerHtml = await getText(innerUrl, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return html; });
        var anchors = parseAnchors(innerHtml, baseOrigin(innerUrl));
        var streams = [];
        for (var i = 0; i < anchors.length; i++) {
            var anchor = anchors[i];
            var text = String(anchor.text || "").toLowerCase();
            if (/pixeldrain|pixel/i.test(text)) {
                var base = baseOrigin(anchor.href);
                var pixel = /download/i.test(anchor.href) ? anchor.href : (base + "/api/file/" + anchor.href.split("/").pop() + "?download");
                streams.push(buildResolvedStream(pixel, label || "HubCloud", qualityFromText(anchor.text), {}));
            } else if (/download|server|file|mega|s3|buzz|gofile|hub/i.test(text + " " + anchor.href)) {
                streams.push(buildResolvedStream(anchor.href, label || "HubCloud", qualityFromText(anchor.text), {}));
            }
        }
        return streams;
    }

    async function resolveHubDriveGlobal(url, label, depth) {
        var html = await getText(url, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
        var candidates = extractInterestingUrlsGlobal(html, baseOrigin(url)).filter(function (candidate) {
            return candidate !== url && !/hubdrive\./i.test(candidate);
        });
        var out = [];
        for (var i = 0; i < candidates.length; i++) {
            out = out.concat(await resolveCommonExtractorUrl(candidates[i], label || "HubDrive", url, depth + 1));
        }
        return out;
    }

    async function resolveFilepressGlobal(url, label, depth) {
        var headers = commonHeaders({ "Referer": baseOrigin(url) + "/" });
        var res = await request(url, { headers: headers, allowRedirects: false }).catch(function () { return null; });
        var location = res && (res.headers.location || res.headers["x-redirect-location"]);
        if (location && /^https?:\/\//i.test(location)) {
            if (isCommonDirectMediaUrl(location)) return [buildResolvedStream(location, label || "Filepress", qualityFromText(location), {})];
            return resolveCommonExtractorUrl(location, label || "Filepress", url, depth + 1);
        }
        var html = await getText(url, headers, true).catch(function () { return ""; });
        var candidates = extractInterestingUrlsGlobal(html, baseOrigin(url));
        var out = [];
        for (var i = 0; i < candidates.length; i++) {
            out = out.concat(await resolveCommonExtractorUrl(candidates[i], label || "Filepress", url, depth + 1));
        }
        return out;
    }

    async function resolveGdflixGlobal(url, label, depth) {
        var html = await getText(url, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
        var anchors = parseAnchors(html, baseOrigin(url));
        var candidates = [];
        for (var i = 0; i < anchors.length; i++) {
            if (/download|instant|gofile|pixeldrain|drivebot|index|view/i.test(String(anchors[i].text || "") + " " + anchors[i].href)) {
                candidates.push(anchors[i].href);
            }
        }
        if (!candidates.length) candidates = extractInterestingUrlsGlobal(html, baseOrigin(url));
        var out = [];
        for (var j = 0; j < candidates.length; j++) {
            var candidate = candidates[j];
            if (/gofile/i.test(candidate)) out = out.concat(await resolveGofileGlobal(candidate, label || "GDFlix"));
            else out = out.concat(await resolveCommonExtractorUrl(candidate, label || "GDFlix", url, depth + 1));
        }
        return out;
    }

    async function resolveMdriveGlobal(url, label, depth) {
        var headers = commonHeaders({ "Referer": baseOrigin(url) + "/" });
        var res = await request(url, { headers: headers, allowRedirects: false }).catch(function () { return null; });
        var redirect = normalizeResolvedUrl(res && (res.headers.location || res.headers["x-redirect-location"]) || "", baseOrigin(url));
        if (redirect && redirect !== url) return resolveCommonExtractorUrl(redirect, label || "MDrive", url, depth + 1);
        var html = await getText(url, headers, true).catch(function () { return ""; });
        var candidates = extractInterestingUrlsGlobal(html, baseOrigin(url)).filter(function (candidate) {
            return candidate !== url;
        });
        var out = [];
        for (var i = 0; i < candidates.length; i++) {
            out = out.concat(await resolveCommonExtractorUrl(candidates[i], label || "MDrive", url, depth + 1));
        }
        return out;
    }

    async function resolveHdm2PlayGlobal(url, label) {
        var headers = commonHeaders({ "Referer": baseOrigin(url) + "/" });
        var html = await getText(url, headers, true).catch(function () { return ""; });
        if (!html) return [];
        var streamPath = normalizeResolvedUrl(firstMatch(html, [/data-stream-url=["']([^"']+)["']/i]), baseOrigin(url));
        if (!streamPath) return [];
        var title = decodeHtml(firstMatch(html, [/data-player-title=["']([^"']+)["']/i])) || label || "HDMovie2";
        return [buildResolvedStream(streamPath, label || "HDMovie2", qualityFromText(title), commonHeaders({
            "Referer": url,
            "Origin": baseOrigin(url)
        }))];
    }

    async function resolveRubyStreamGlobal(url, label) {
        var parsed = new URL(url);
        var origin = parsed.protocol + "//" + parsed.host;
        var pageHtml = await getText(url, commonHeaders({ "Referer": origin + "/" }), true).catch(function () { return ""; });
        var fileCode = trim(parsed.pathname.replace(/\/+$/g, "").split("/").pop().replace(/\.html$/i, ""));
        if (!fileCode) return [];
        var body = "op=embed&file_code=" + encodeURIComponent(fileCode) + "&auto=1&referer=";
        var res = await request(origin + "/dl", {
            method: "POST",
            body: body,
            headers: commonHeaders({
                "Referer": url,
                "Origin": origin,
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            })
        }).catch(function () { return null; });
        var html = res && String(res.body || "") || pageHtml;
        var unpacked = unpackPackedScriptGlobal(firstMatch(html, [/<script[^>]*>\s*(eval\(function\(p,a,c,k,e[,d]*\)[\s\S]*?)<\/script>/i]));
        var streamUrl = firstMatch(unpacked || html, [
            /(https?:\/\/[^\s"'<>]+(?:\.m3u8|\.mp4|\.mkv|\.avi)[^\s"'<>]*)/i,
            /sources\s*:\s*\[\s*\{\s*file\s*:\s*["']([^"']+)/i
        ]);
        if (!streamUrl) return [];
        return [buildResolvedStream(streamUrl, label || "RubyStream", qualityFromText(html), commonHeaders({ "Referer": origin + "/" }))];
    }

    async function resolveAsCdnVideoGlobal(url, label, referer) {
        var normalized = normalizeResolvedUrl(url, referer ? baseOrigin(referer) : "");
        var match = String(normalized || "").match(/\/video\/([A-Za-z0-9]+)/i);
        if (!match) return [];
        var videoId = match[1];
        var origin = baseOrigin(normalized);
        var endpoint = origin + "/player/index.php?data=" + encodeURIComponent(videoId) + "&do=getVideo";
        var body = "hash=" + encodeURIComponent(videoId) + "&r=" + encodeURIComponent(referer || normalized);
        var res = await request(endpoint, {
            method: "POST",
            body: body,
            headers: commonHeaders({
                "Referer": normalized,
                "Origin": origin,
                "X-Requested-With": "XMLHttpRequest",
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            })
        }).catch(function () { return null; });
        var payload = res ? parseJsonSafe(res.body, null) : null;
        if (!payload || typeof payload !== "object") return [];

        var headers = commonHeaders({
            "Referer": normalized,
            "Origin": origin
        });
        var out = [];
        var streamUrl = trim(payload.videoSource || payload.securedLink || "");
        if (payload.hls === true && streamUrl) {
            out.push(buildResolvedStream(streamUrl, label || "Toonstream", qualityFromText(streamUrl), headers));
        }

        var rows = Array.isArray(payload.videoSources) ? payload.videoSources : [];
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i] || {};
            var fileUrl = trim(row.file || row.src || row.url || "");
            if (!fileUrl) continue;
            out.push(buildResolvedStream(fileUrl, label || "Toonstream", qualityFromText(row.label || fileUrl), headers));
        }
        return dedupeStreams(out);
    }

    async function resolveGenericLinkPage(url, label, referer, depth) {
        var res = await request(url, {
            headers: commonHeaders({ "Referer": (referer || baseOrigin(url) + "/") }),
            allowRedirects: true
        }).catch(function () { return null; });
        var html = res ? String(res.body || "") : "";
        var finalUrl = res && res.finalUrl || url;
        var base = baseOrigin(finalUrl || url);
        var candidates = [];
        if (finalUrl && finalUrl !== url) candidates.push(finalUrl);
        candidates = candidates.concat(extractInterestingUrlsGlobal(html, base));
        candidates = uniqueBy(candidates, function (item) { return item; }).filter(function (candidate) {
            return candidate && candidate !== url;
        });
        var out = [];
        for (var i = 0; i < candidates.length; i++) {
            out = out.concat(await resolveCommonExtractorUrl(candidates[i], label, finalUrl || url, depth + 1));
        }
        return out;
    }

    async function resolveCommonExtractorUrl(url, label, referer, depth) {
        var currentDepth = Number(depth || 0);
        if (!url || currentDepth > 6) return [];
        var normalized = normalizeResolvedUrl(url, referer ? baseOrigin(referer) : "");
        if (!normalized) return [];
        if (isCommonDirectMediaUrl(normalized)) {
            return [buildResolvedStream(normalized, label || "Source", qualityFromText(label + " " + normalized), commonHeaders(referer ? { "Referer": referer } : {}))];
        }
        if (/gofile\.io/i.test(normalized)) return resolveGofileGlobal(normalized, label || "GoFile");
        if (/hubcloud\.|hubcloud\.fans|hubcloud\.foo|gamerxyt\.com\/hubcloud\.php/i.test(normalized)) return resolveHubCloudGlobal(normalized, label || "HubCloud");
        if (/hubdrive\./i.test(normalized)) return resolveHubDriveGlobal(normalized, label || "HubDrive", currentDepth);
        if (/filepress\.|filebee/i.test(normalized)) return resolveFilepressGlobal(normalized, label || "Filepress", currentDepth);
        if (/gdfli?x|gdtot/i.test(normalized)) return resolveGdflixGlobal(normalized, label || "GDFlix", currentDepth);
        if (/mdrive\./i.test(normalized)) return resolveMdriveGlobal(normalized, label || "MDrive", currentDepth);
        if (/hdm2\.ink\/play/i.test(normalized)) return resolveHdm2PlayGlobal(normalized, label || "HDMovie2");
        if (/rubystm\.com\/e\/|streamruby\.com\/e\//i.test(normalized)) return resolveRubyStreamGlobal(normalized, label || "RubyStream");
        if (/\/\/as-cdn\d+\.[^/]+\/video\//i.test(normalized)) return resolveAsCdnVideoGlobal(normalized, label || "Toonstream", referer || normalized);
        if (/toonstream\.dad\/\?trembed=/i.test(normalized)) return resolveGenericLinkPage(normalized, label || "Toonstream", referer || normalized, currentDepth);
        if (/linksmod|nexdrive|gadgetsweb|cryptoinsights|fastdlserver|fastdl\.zip|vcloud\.zip|streamtape|1fichier|clicknupload|ok\.ru|multiup|vidstreaming|rubystm|strmup/i.test(normalized)) {
            return resolveGenericLinkPage(normalized, label || "Source", referer || normalized, currentDepth);
        }
        return resolveGenericLinkPage(normalized, label || "Source", referer || normalized, currentDepth);
    }

    function parseWpArticleCard(block, base) {
        var href = firstMatch(block, [
            /<h2\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<h3\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*post-image[^"']*["']/i,
            /<a\b[^>]*href=["']([^"']+)["'][^>]*>/i
        ]);
        if (!href) return null;
        var rawTitle = stripTags(firstMatch(block, [
            /<h2\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /<h3\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
            /\btitle=["']([^"']+)["']/i,
            /<img\b[^>]*alt=["']([^"']+)["']/i
        ]));
        if (!rawTitle) return null;
        return {
            title: trim(rawTitle.split(" |")[0]),
            year: Number(firstMatch(rawTitle, [/\((\d{4})\)/])) || undefined,
            type: /season|series|tv/i.test(rawTitle) ? "series" : "movie",
            url: absoluteUrl(base, href)
        };
    }

    function parseWpArticleResults(html, base) {
        return extractBlocks(html, "article").map(function (block) {
            return parseWpArticleCard(block, base);
        }).filter(Boolean);
    }

    function extractExternalSourceLinks(html, base) {
        var origin = baseOrigin(base);
        var anchors = parseAnchors(html, base).filter(function (item) {
            if (!item || !/^https?:\/\//i.test(item.href)) return false;
            if (baseOrigin(item.href) === origin) return false;
            if (/telegram|facebook|instagram|twitter|youtube|imdb|imgbb|fonts\.googleapis|googletagmanager|ampproject/i.test(item.href)) return false;
            return isCommonInterestingUrl(item.href)
                || /download|watch|server|hub|drive|cloud|direct|save/i.test(String(item.text || "") + " " + item.href);
        }).map(function (item) {
            return { url: item.href, label: trim(item.text || "") };
        });
        var extras = extractInterestingUrlsGlobal(html, base).filter(function (item) {
            return /^https?:\/\//i.test(item) && baseOrigin(item) !== origin;
        }).map(function (item) {
            return { url: item, label: "" };
        });
        return uniqueBy(anchors.concat(extras), function (item) {
            return item && item.url;
        });
    }

    function tmdbImage(path) {
        return path ? (TMDB_IMAGE + path) : undefined;
    }

    function buildPayload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed && typeof parsed === "object") return parsed;
        throw new Error("Invalid CineStream payload");
    }

    function normalizeTmdbPath(path) {
        return String(path || "").replace(/^\/+/, "");
    }

    async function getTmdbJson(path, preferWorker) {
        var normalized = normalizeTmdbPath(path);
        var urls = preferWorker
            ? [TMDB_WORKER_API + "/" + normalized, TMDB_API + "/" + normalized]
            : [TMDB_API + "/" + normalized, TMDB_WORKER_API + "/" + normalized];
        var lastError = null;
        for (var i = 0; i < urls.length; i++) {
            try {
                return await getJson(urls[i]);
            } catch (error) {
                lastError = error;
            }
        }
        throw lastError || new Error("TMDB request failed: " + normalized);
    }

    function isoDate(offsetDays) {
        var date = new Date();
        date.setUTCDate(date.getUTCDate() + (offsetDays || 0));
        return date.toISOString().slice(0, 10);
    }

    var HOME_SECTIONS = [
        { title: "Trending", path: "trending/all/day?api_key=" + TMDB_API_KEY + "&region=US" },
        { title: "Popular Movies", path: "trending/movie/week?api_key=" + TMDB_API_KEY + "&region=US" },
        { title: "Popular TV Shows", path: "trending/tv/week?api_key=" + TMDB_API_KEY + "&region=US" },
        { title: "Airing Today Anime", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_keywords=210024|222243&sort_by=popularity.desc&air_date.lte=" + isoDate(0) + "&air_date.gte=" + isoDate(0) },
        { title: "On The Air Anime", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_keywords=210024|222243&sort_by=popularity.desc&air_date.lte=" + isoDate(7) + "&air_date.gte=" + isoDate(0) },
        { title: "Korean Shows", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_original_language=ko" },
        { title: "Netflix", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=213" },
        { title: "Amazon", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=1024" },
        { title: "Disney+", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=2739" },
        { title: "JioHotstar", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_watch_providers=2336&watch_region=IN" },
        { title: "Hulu", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=453" },
        { title: "Apple TV+", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=2552" },
        { title: "HBO", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=49" },
        { title: "Paramount+", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=4330" },
        { title: "Peacock", path: "discover/tv?api_key=" + TMDB_API_KEY + "&with_networks=3353" },
        { title: "Trending Indian Movies", path: "discover/movie?api_key=" + TMDB_API_KEY + "&language=en-US&page=1&sort_by=popularity.desc&with_origin_country=IN&release_date.gte=" + isoDate(-7) + "&release_date.lte=" + isoDate(0) },
        { title: "Anime Movies", path: "discover/movie?api_key=" + TMDB_API_KEY + "&with_keywords=210024|222243" },
        { title: "Top Rated TV Shows", path: "tv/top_rated?api_key=" + TMDB_API_KEY + "&region=US" }
    ];

    function inferTmdbType(result) {
        var mediaType = result && result.media_type ? result.media_type : (result && result.first_air_date ? "tv" : "movie");
        var genres = result && result.genre_ids || [];
        if (mediaType === "movie") {
            if ((result && result.original_language) === "ja" || genres.indexOf(16) !== -1) return "anime";
            return "movie";
        }
        if ((result && result.original_language) === "ja") return "anime";
        if (genres.indexOf(16) !== -1) return "anime";
        return "series";
    }

    function buildTmdbItem(result) {
        var mediaType = result && result.media_type ? result.media_type : (result && result.first_air_date ? "tv" : "movie");
        var title = trim(result && (result.title || result.name));
        if (!title || !result || !result.id) return null;
        var item = new MultimediaItem({
            title: title,
            url: buildPayload({
                mode: "tmdb",
                tmdbId: result.id,
                mediaType: mediaType
            }),
            posterUrl: tmdbImage(result.poster_path),
            bannerUrl: tmdbImage(result.backdrop_path),
            type: inferTmdbType(result),
            description: trim(result.overview || ""),
            year: Number(String(result.release_date || result.first_air_date || "").slice(0, 4)) || undefined
        });
        var jp = trim(result.original_title || result.original_name || "");
        if (jp && normalizeTitle(jp) !== normalizeTitle(title)) item.japaneseTitle = jp;
        return item;
    }

    function mapCast(cast) {
        return (cast || []).slice(0, 20).map(function (person) {
            return new Actor({
                name: trim(person && person.name),
                image: tmdbImage(person && person.profile_path),
                role: trim(person && person.character)
            });
        }).filter(function (actor) { return !!actor.name; });
    }

    function mapRecommendations(items) {
        return uniqueBy((items || []).slice(0, 12).map(buildTmdbItem).filter(Boolean), function (item) {
            return item && item.url;
        });
    }

    function isAnimeDetail(detail, keywordJson) {
        var genres = (detail && detail.genres || []).map(function (genre) { return String(genre && genre.name || "").toLowerCase(); });
        var keywords = [];
        if (keywordJson) {
            var rows = keywordJson.results || keywordJson.keywords || [];
            keywords = rows.map(function (row) { return String(row && row.name || "").toLowerCase(); });
        }
        return (detail && detail.original_language === "ja")
            || genres.indexOf("animation") !== -1
            || keywords.indexOf("anime") !== -1
            || keywords.indexOf("anime series") !== -1;
    }

    async function tmdbDetail(mediaType, tmdbId) {
        var detail = await getTmdbJson(mediaType + "/" + tmdbId + "?api_key=" + TMDB_API_KEY + "&append_to_response=credits,external_ids,recommendations", true);
        var keywords = await getTmdbJson(mediaType + "/" + tmdbId + "/keywords?api_key=" + TMDB_API_KEY, true).catch(function () {
            return {};
        });
        return {
            detail: detail || {},
            keywords: keywords || {}
        };
    }

    async function getHome(cb) {
        try {
            var data = {};
            for (var i = 0; i < HOME_SECTIONS.length; i++) {
                var section = HOME_SECTIONS[i];
                try {
                    var json = await getTmdbJson(section.path, true);
                    data[section.title] = uniqueBy(((json && json.results) || []).map(buildTmdbItem).filter(Boolean), function (item) {
                        return item && item.url;
                    });
                } catch (_) {
                    data[section.title] = [];
                }
            }
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function tmdbSearch(query) {
        var encoded = encodeURIComponent(query || "");
        var urls = [
            "search/multi?api_key=" + TMDB_API_KEY + "&language=en-US&page=1&include_adult=false&query=" + encoded
        ];

        try {
            var multi = await getTmdbJson(urls[0], true);
            return ((multi && multi.results) || []).filter(function (item) {
                return item && (item.media_type === "movie" || item.media_type === "tv");
            });
        } catch (_) {
            var movieJson = await getTmdbJson("search/movie?api_key=" + TMDB_API_KEY + "&language=en-US&page=1&include_adult=false&query=" + encoded, true).catch(function () {
                return {};
            });
            var tvJson = await getTmdbJson("search/tv?api_key=" + TMDB_API_KEY + "&language=en-US&page=1&include_adult=false&query=" + encoded, true).catch(function () {
                return {};
            });

            var movieResults = ((movieJson && movieJson.results) || []).map(function (item) {
                item = item || {};
                item.media_type = "movie";
                return item;
            });
            var tvResults = ((tvJson && tvJson.results) || []).map(function (item) {
                item = item || {};
                item.media_type = "tv";
                return item;
            });
            return movieResults.concat(tvResults);
        }
    }

    async function search(query, cb) {
        try {
            var results = uniqueBy((await tmdbSearch(query)).map(buildTmdbItem).filter(Boolean), function (item) {
                return item && item.url;
            });
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var parsed = parsePayload(url);
            var tmdbId = parsed.tmdbId;
            var mediaType = parsed.mediaType || "movie";
            if (!tmdbId) throw new Error("Missing TMDB id");

            var detailBundle = await tmdbDetail(mediaType, tmdbId);
            var detail = detailBundle.detail || {};
            var keywords = detailBundle.keywords || {};
            var title = trim(detail.title || detail.name || "Unknown");
            var originalTitle = trim(detail.original_title || detail.original_name || "");
            var year = Number(String(detail.release_date || detail.first_air_date || "").slice(0, 4)) || undefined;
            var anime = isAnimeDetail(detail, keywords);
            var type = mediaType === "movie" ? (anime ? "anime" : "movie") : (anime ? "anime" : "series");
            var genres = (detail.genres || []).map(function (genre) { return trim(genre && genre.name); }).filter(Boolean);
            var recommendations = mapRecommendations(detail.recommendations && detail.recommendations.results);
            var item = new MultimediaItem({
                title: title,
                url: buildPayload({
                    mode: "tmdb",
                    tmdbId: tmdbId,
                    mediaType: mediaType
                }),
                posterUrl: tmdbImage(detail.poster_path),
                bannerUrl: tmdbImage(detail.backdrop_path),
                logoUrl: undefined,
                type: type,
                description: trim(detail.overview || ""),
                year: year,
                score: typeof detail.vote_average === "number" ? Number(detail.vote_average.toFixed(1)) : undefined,
                genres: genres,
                cast: mapCast(detail.credits && detail.credits.cast),
                recommendations: recommendations,
                headers: {
                    "Referer": "https://www.themoviedb.org/"
                },
                episodes: []
            });
            if (originalTitle && normalizeTitle(originalTitle) !== normalizeTitle(title)) item.japaneseTitle = originalTitle;

            if (mediaType === "movie") {
                item.episodes = [new Episode({
                    name: "Movie",
                    url: buildPayload({
                        mode: "stream",
                        tmdbId: tmdbId,
                        mediaType: mediaType,
                        title: title,
                        originalTitle: originalTitle,
                        year: year,
                        imdbId: detail.external_ids && detail.external_ids.imdb_id || "",
                        season: 1,
                        episode: 1,
                        anime: anime,
                        isMovie: true
                    }),
                    season: 1,
                    episode: 1,
                    posterUrl: tmdbImage(detail.poster_path),
                    description: trim(detail.overview || ""),
                    headers: { "Referer": "https://www.themoviedb.org/" }
                })];
                cb({ success: true, data: item });
                return;
            }

            var seasons = (detail.seasons || []).filter(function (season) {
                return season && season.season_number > 0;
            });
            var episodes = [];

            for (var i = 0; i < seasons.length; i++) {
                var seasonInfo = seasons[i];
                try {
                    var seasonJson = await getTmdbJson("tv/" + tmdbId + "/season/" + seasonInfo.season_number + "?api_key=" + TMDB_API_KEY, true);
                    var seasonEpisodes = seasonJson && seasonJson.episodes || [];
                    for (var j = 0; j < seasonEpisodes.length; j++) {
                        var ep = seasonEpisodes[j];
                        episodes.push(new Episode({
                            name: trim(ep && ep.name) || ("Episode " + String(ep && ep.episode_number || (j + 1))),
                            url: buildPayload({
                                mode: "stream",
                                tmdbId: tmdbId,
                                mediaType: mediaType,
                                title: title,
                                originalTitle: originalTitle,
                                year: year,
                                imdbId: detail.external_ids && detail.external_ids.imdb_id || "",
                                season: seasonInfo.season_number,
                                episode: ep && ep.episode_number || (j + 1),
                                anime: anime,
                                isMovie: false
                            }),
                            season: seasonInfo.season_number,
                            episode: ep && ep.episode_number || (j + 1),
                            posterUrl: tmdbImage(ep && ep.still_path || seasonInfo.poster_path || detail.poster_path),
                            description: trim(ep && ep.overview || detail.overview || ""),
                            airDate: ep && ep.air_date || undefined,
                            headers: { "Referer": "https://www.themoviedb.org/" }
                        }));
                    }
                } catch (_) {}
            }

            item.episodes = episodes;
            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    var CastleSource = (function () {
        var DEFAULT_API_BASE = "https://api.hlowb.com";
        var PACKAGE_NAME = "com.external.castle";
        var CHANNEL = "IndiaA";
        var CLIENT_TYPE = "1";
        var LANG = "en-US";
        var MODE = "1";
        var APP_MARKET = "GuanWang";
        var APK_SIGN_KEY = "ED0955EB04E67A1D9F3305B95454FED485261475";
        var ANDROID_VERSION = "13";
        var CASTLE_SUFFIX = "T!BgJB";
        var SERIES_TYPES = { "1": true, "3": true, "5": true };
        var QUALITY_MAP = { "3": 1080, "2": 720, "1": 480 };

        function preserveIds(text) {
            return String(text || "").replace(/"([A-Za-z0-9_]*Id|id)"\s*:\s*(-?\d+)/g, function (_, key, value) {
                return "\"" + key + "\":\"" + value + "\"";
            });
        }

        function safeJson(text) {
            return parseJsonSafe(preserveIds(text), null);
        }

        function deriveKey(apiKeyB64) {
            var decoded = atob(apiKeyB64 || "");
            var keyMaterial = decoded + CASTLE_SUFFIX;
            while (keyMaterial.length < 16) keyMaterial += "\u0000";
            return keyMaterial.substring(0, 16);
        }

        async function decryptPayload(encryptedB64, apiKeyB64) {
            if (!encryptedB64) return null;
            var aesKey = deriveKey(apiKeyB64);
            var candidates = [
                [aesKey, aesKey],
                [btoa(aesKey), btoa(aesKey)]
            ];
            for (var i = 0; i < candidates.length; i++) {
                try {
                    if (typeof crypto !== "undefined" && crypto && typeof crypto.decryptAES === "function") {
                        var decrypted = await crypto.decryptAES(encryptedB64, candidates[i][0], candidates[i][1]);
                        if (typeof decrypted === "string" && decrypted) return decrypted;
                    }
                } catch (_) {}
                try {
                    if (typeof sendMessage === "function") {
                        var viaBridge = await sendMessage("crypto_decrypt_aes", JSON.stringify({
                            data: encryptedB64,
                            key: candidates[i][0],
                            iv: candidates[i][1]
                        }));
                        if (typeof viaBridge === "string" && viaBridge) return viaBridge;
                    }
                } catch (_) {}
            }
            return null;
        }

        async function getSecurityKey() {
            var url = DEFAULT_API_BASE + "/v0.1/system/getSecurityKey/1?channel=" + CHANNEL + "&clientType=" + CLIENT_TYPE + "&lang=" + LANG;
            var json = await getJson(url);
            return json && json.code === 200 ? json.data : null;
        }

        function encryptedPayload(body) {
            var parsed = safeJson(body);
            if (parsed && typeof parsed.data === "string") return parsed.data;
            return trim(body);
        }

        async function getDecryptedJson(url, securityKey) {
            var key = securityKey || await getSecurityKey();
            if (!key) throw new Error("Castle security key unavailable");
            var body = await getText(url);
            var encrypted = encryptedPayload(body);
            var direct = safeJson(encrypted);
            if (direct && typeof direct === "object") return { securityKey: key, data: direct };
            var decrypted = await decryptPayload(encrypted, key);
            var parsed = safeJson(decrypted);
            if (!parsed) throw new Error("Castle payload decryption failed");
            return { securityKey: key, data: parsed };
        }

        async function postDecryptedJson(url, body, securityKey) {
            var key = securityKey || await getSecurityKey();
            if (!key) throw new Error("Castle security key unavailable");
            var responseText = await postJson(url, body);
            var encrypted = encryptedPayload(responseText);
            var direct = safeJson(encrypted);
            if (direct && typeof direct === "object") return { securityKey: key, data: direct };
            var decrypted = await decryptPayload(encrypted, key);
            var parsed = safeJson(decrypted);
            if (!parsed) throw new Error("Castle payload decryption failed");
            return { securityKey: key, data: parsed };
        }

        function normalizeType(movieType) {
            return SERIES_TYPES[String(movieType)] ? "series" : "movie";
        }

        async function searchTitles(queries) {
            var out = [];
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var url = DEFAULT_API_BASE
                        + "/film-api/v1.1.0/movie/searchByKeyword?channel=" + CHANNEL
                        + "&clientType=" + CLIENT_TYPE
                        + "&clientType=" + CLIENT_TYPE
                        + "&keyword=" + encodeURIComponent(query)
                        + "&lang=" + LANG
                        + "&mode=" + MODE
                        + "&packageName=" + PACKAGE_NAME
                        + "&page=1&size=30";
                    var decrypted = await getDecryptedJson(url);
                    var rows = decrypted.data && decrypted.data.data && decrypted.data.data.rows || [];
                    for (var j = 0; j < rows.length; j++) {
                        var item = rows[j];
                        if (!item || !item.id || !item.title) continue;
                        out.push({
                            id: String(item.id),
                            title: item.title,
                            type: normalizeType(item.movieType),
                            year: item.publishTime ? new Date(Number(item.publishTime)).getFullYear() : undefined
                        });
                    }
                } catch (_) {}
                if (out.length) break;
            }
            return uniqueBy(out, function (item) { return item.id; });
        }

        async function fetchMovieDetails(movieId, securityKey) {
            var url = DEFAULT_API_BASE
                + "/film-api/v1.9.9/movie?channel=" + CHANNEL
                + "&clientType=" + CLIENT_TYPE
                + "&clientType=" + CLIENT_TYPE
                + "&lang=" + LANG
                + "&movieId=" + encodeURIComponent(movieId)
                + "&packageName=" + PACKAGE_NAME;
            var decrypted = await getDecryptedJson(url, securityKey);
            return {
                securityKey: decrypted.securityKey,
                details: decrypted.data && decrypted.data.data || null
            };
        }

        async function resolveEpisode(detailsBundle, media) {
            var details = detailsBundle.details;
            var securityKey = detailsBundle.securityKey;
            if (!details) return null;

            if (media.isMovie) {
                var firstEpisode = details.episodes && details.episodes[0];
                return firstEpisode && firstEpisode.id ? {
                    movieId: String(details.id || media.tmdbId),
                    episodeId: String(firstEpisode.id),
                    details: details,
                    securityKey: securityKey
                } : null;
            }

            if (details.seasons && details.seasons.length > 1) {
                for (var i = 0; i < details.seasons.length; i++) {
                    var season = details.seasons[i];
                    if (!season || Number(season.number) !== Number(media.season)) continue;
                    var seasonBundle = await fetchMovieDetails(String(season.movieId), securityKey);
                    securityKey = seasonBundle.securityKey || securityKey;
                    var seasonDetails = seasonBundle.details;
                    var seasonEpisodes = seasonDetails && seasonDetails.episodes || [];
                    for (var j = 0; j < seasonEpisodes.length; j++) {
                        var episode = seasonEpisodes[j];
                        if (!episode || Number(episode.number) !== Number(media.episode)) continue;
                        return {
                            movieId: String(season.movieId),
                            episodeId: String(episode.id),
                            details: seasonDetails,
                            securityKey: securityKey
                        };
                    }
                }
            }

            var episodes = details.episodes || [];
            for (var k = 0; k < episodes.length; k++) {
                var entry = episodes[k];
                if (!entry || Number(entry.number) !== Number(media.episode)) continue;
                return {
                    movieId: String(details.id),
                    episodeId: String(entry.id),
                    details: details,
                    securityKey: securityKey
                };
            }
            return null;
        }

        async function resolveVideoPayload(movieId, episodeId, languageId, resolution, securityKey) {
            var url = DEFAULT_API_BASE + "/film-api/v2.0.1/movie/getVideo2?clientType=" + CLIENT_TYPE + "&packageName=" + PACKAGE_NAME + "&channel=" + CHANNEL + "&lang=" + LANG;
            var body = {
                mode: MODE,
                appMarket: APP_MARKET,
                clientType: CLIENT_TYPE,
                woolUser: "false",
                apkSignKey: APK_SIGN_KEY,
                androidVersion: ANDROID_VERSION,
                movieId: String(movieId),
                episodeId: String(episodeId),
                isNewUser: "true",
                resolution: String(resolution),
                packageName: PACKAGE_NAME
            };
            if (languageId != null && languageId !== "") body.languageId = String(languageId);
            return postDecryptedJson(url, body, securityKey);
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var match = bestMatch(results, queries, media.year, media.isMovie ? "movie" : "series");
            if (!match) return [];

            var detailsBundle = await fetchMovieDetails(match.id);
            var episodeRef = await resolveEpisode(detailsBundle, media);
            if (!episodeRef) return [];

            var details = episodeRef.details;
            var availableTracks = (details && details.episodes && details.episodes[0] && details.episodes[0].tracks) || (details && details.tracks) || [];
            var title = details && details.title || "Castle";
            var streams = [];
            var resolutions = [3, 2, 1];
            var securityKey = episodeRef.securityKey;
            var hasIndividualVideo = false;

            for (var i = 0; i < availableTracks.length; i++) {
                if (availableTracks[i] && availableTracks[i].existIndividualVideo === true) {
                    hasIndividualVideo = true;
                    break;
                }
            }

            if (!hasIndividualVideo) {
                var trackNames = availableTracks.map(function (track) {
                    return track && (track.languageName || track.abbreviate);
                }).filter(Boolean).join(", ") || "Default";

                for (var r = 0; r < resolutions.length; r++) {
                    try {
                        var result = await resolveVideoPayload(episodeRef.movieId, episodeRef.episodeId, null, resolutions[r], securityKey);
                        securityKey = result.securityKey || securityKey;
                        var data = result.data && result.data.data || null;
                        if (!data || !data.videoUrl || data.permissionDenied === true) continue;
                        streams.push({
                            url: data.videoUrl,
                            source: "Castle [" + trackNames + "]",
                            quality: QUALITY_MAP[String(resolutions[r])] || 0,
                            headers: { "Referer": DEFAULT_API_BASE + "/" }
                        });
                    } catch (_) {}
                }
            } else {
                for (var t = 0; t < availableTracks.length; t++) {
                    var track = availableTracks[t];
                    if (!track || track.languageId == null) continue;
                    for (var x = 0; x < resolutions.length; x++) {
                        try {
                            var trackResult = await resolveVideoPayload(episodeRef.movieId, episodeRef.episodeId, track.languageId, resolutions[x], securityKey);
                            securityKey = trackResult.securityKey || securityKey;
                            var trackData = trackResult.data && trackResult.data.data || null;
                            if (!trackData || !trackData.videoUrl || trackData.permissionDenied === true) continue;
                            streams.push({
                                url: trackData.videoUrl,
                                source: "Castle [" + (track.languageName || track.abbreviate || "Default") + "]",
                                quality: QUALITY_MAP[String(resolutions[x])] || 0,
                                headers: { "Referer": DEFAULT_API_BASE + "/" }
                            });
                        } catch (_) {}
                    }
                }
            }

            return dedupeStreams(streams);
        }

        return {
            key: "p_castle",
            name: "Castle",
            resolve: resolve
        };
    })();

    var Movies4uSource = (function () {
        var DEFAULT_BASE_URL = "https://movies4u.rs";
        var DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
        var domainCache = null;

        function defaultHeaders(extra) {
            return Object.assign({
                "Cookie": "xla=s4t",
                "User-Agent": "Mozilla/5.0",
                "Referer": DEFAULT_BASE_URL + "/"
            }, extra || {});
        }

        function isPlaceholder(url) {
            return /(?:^|\/\/)(?:www\.)?example\.com(?:\/|$)/i.test(String(url || ""));
        }

        function looksLikeListing(html) {
            return /<article\b[^>]*class=["'][^"']*(?:entry-card|post|hentry)[^"']*["']/i.test(String(html || ""))
                || /<h[23]\b[^>]*class=["'][^"']*entry-title[^"']*["']/i.test(String(html || ""));
        }

        async function validateMainUrl(url) {
            var candidate = trim(String(url || "").replace(/\/+$/g, ""));
            if (!candidate || !/^https?:\/\//i.test(candidate) || isPlaceholder(candidate)) return "";
            try {
                var html = await getText(candidate + "/", defaultHeaders({ "Referer": candidate + "/" }));
                return looksLikeListing(html) ? candidate : "";
            } catch (_) {
                return "";
            }
        }

        async function getMainUrl() {
            if (domainCache) return domainCache;
            var json = await getJson(DOMAINS_URL, defaultHeaders()).catch(function () { return {}; });
            var candidates = uniqueBy([
                json && json.movies4u,
                DEFAULT_BASE_URL
            ].filter(Boolean), function (item) { return item; });
            for (var i = 0; i < candidates.length; i++) {
                var valid = await validateMainUrl(candidates[i]);
                if (valid) {
                    domainCache = valid;
                    return valid;
                }
            }
            domainCache = DEFAULT_BASE_URL;
            return domainCache;
        }

        function getImageFromBlock(block, base) {
            var img = firstMatch(block, [
                /<img\b[^>]*src=["']([^"']+)["']/i,
                /<img\b[^>]*data-src=["']([^"']+)["']/i
            ]);
            return img ? absoluteUrl(base, img) : "";
        }

        function inferType(rawTitle) {
            var value = String(rawTitle || "");
            if (/anime/i.test(value)) return "anime";
            if (/season|series/i.test(value)) return "series";
            return "movie";
        }

        function parseSearchCard(block, base) {
            var href = firstMatch(block, [
                /<h2\b[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
                /<h3\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i
            ]);
            if (!href) return null;
            var rawTitle = stripTags(firstMatch(block, [
                /<h2\b[^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i,
                /<h3\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*>([\s\S]*?)<\/a>/i
            ]));
            if (!rawTitle) return null;
            var title = trim(rawTitle.split(" (")[0]) || rawTitle;
            var yearMatch = rawTitle.match(/\((\d{4})\)/);
            return {
                title: title,
                year: yearMatch ? Number(yearMatch[1]) : undefined,
                type: inferType(rawTitle),
                url: absoluteUrl(base, href),
                poster: getImageFromBlock(block, base)
            };
        }

        function parseSearchResults(html, base) {
            return extractBlocks(html, "article").map(function (block) {
                return parseSearchCard(block, base);
            }).filter(Boolean);
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
            if (links.length) return uniqueBy(links, function (item) { return item; });
            return uniqueBy(parseAnchors(html, base).filter(function (item) {
                var href = String(item && item.href || "");
                var text = String(item && item.text || "");
                if (!/^https?:\/\//i.test(href)) return false;
                if (baseOrigin(href) === baseOrigin(base)) return false;
                return /download|watch|server|drive|cloud|direct|gdflix|hubcloud|filepress|filebee|pixeldrain|gofile|m4ulinks|mdrive/i.test(text + " " + href);
            }).map(function (item) { return item.href; }), function (item) { return item; });
        }

        function getSeasonSections(html, base) {
            var section = extractBetweenMarkers(
                html,
                /<div\b[^>]*class=["'][^"']*download-links-div[^"']*["'][^>]*>/i,
                /<\/article>|<\/section>/i
            ) || html;
            var out = [];
            var regex = /<h4\b[^>]*>([\s\S]*?)<\/h4>([\s\S]*?)(?=<h4\b|$)/gi;
            var match;
            while ((match = regex.exec(section))) {
                var title = stripTags(match[1]);
                var seasonMatch = title.match(/Season\s*(\d+)/i);
                if (!seasonMatch) continue;
                out.push({
                    season: Number(seasonMatch[1]),
                    links: parseAnchors(match[2], base).map(function (item) { return item.href; }).filter(Boolean)
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

        function isDirectMediaUrl(url) {
            return /\.(?:m3u8|mp4|mkv|webm|mpd)(?:[?#].*)?$/i.test(String(url || ""))
                || /\/api\/file\/[^/?]+(?:\?download)?$/i.test(String(url || ""));
        }

        function isInterestingExtractorUrl(url) {
            return /hubcloud|hubdrive|filepress|filebee|gdfli?x|gofile|pixeldrain|m4ulinks|mdrive|googleusercontent|drive\.google|workers\.dev|\.m3u8|\.mp4|\.mpd/i.test(String(url || ""));
        }

        function normalizeExtractedUrl(rawValue, base) {
            var value = String(rawValue || "");
            if (!value) return "";
            value = decodeHtml(value)
                .replace(/\\u002F/gi, "/")
                .replace(/\\u003A/gi, ":")
                .replace(/\\u0026/gi, "&")
                .replace(/\\\//g, "/")
                .replace(/^[\s"'`(]+/, "")
                .replace(/[\s"'`),;]+$/, "");
            if (/^\/\//.test(value)) value = "https:" + value;
            if (/^www\./i.test(value)) value = "https://" + value;
            if (!/^https?:\/\//i.test(value) && base) value = absoluteUrl(base, value);
            return value;
        }

        function decodeQueryParam(url, name) {
            try {
                return new URL(url).searchParams.get(name) || "";
            } catch (_) {
                return "";
            }
        }

        function extractInterestingUrls(html, base) {
            var out = [];
            var seen = {};
            function add(raw) {
                var value = normalizeExtractedUrl(raw, base);
                if (!value || seen[value]) return;
                seen[value] = true;
                if (isInterestingExtractorUrl(value)) out.push(value);
                ["url", "link", "file", "target", "redirect", "dl"].forEach(function (name) {
                    var nested = normalizeExtractedUrl(decodeQueryParam(value, name), base);
                    if (nested && !seen[nested] && isInterestingExtractorUrl(nested)) {
                        seen[nested] = true;
                        out.push(nested);
                    }
                });
            }
            parseAnchors(html, base).forEach(function (anchor) { add(anchor && anchor.href); });
            var regexes = [
                /https?:\/\/[^\s"'<>\\]+/gi,
                /(?:href|src)\s*=\s*["']([^"']+)["']/gi,
                /"(?:url|link|file|download(?:Url)?)"\s*:\s*"([^"]+)"/gi
            ];
            for (var i = 0; i < regexes.length; i++) {
                var regex = regexes[i];
                var match;
                while ((match = regex.exec(String(html || "")))) add(match[1] || match[0]);
            }
            return uniqueBy(out, function (item) { return item; });
        }

        function buildStream(url, label, quality, headers) {
            return {
                url: url,
                source: label || "Movies4u",
                quality: quality || qualityFromText(url),
                headers: headers || {}
            };
        }

        async function resolveGofile(url) {
            var idMatch = String(url || "").match(/(?:\?c=|\/d\/)([\da-zA-Z-]+)/i);
            if (!idMatch) return [];
            var folderId = idMatch[1];
            var accountRes = await request("https://api.gofile.io/accounts", {
                method: "POST",
                body: "",
                headers: defaultHeaders()
            }).catch(function () { return null; });
            var accountJson = accountRes ? parseJsonSafe(accountRes.body, {}) : {};
            var token = accountJson && accountJson.data && accountJson.data.token;
            if (!token) return [];
            var globalJs = await getText("https://gofile.io/dist/js/global.js", defaultHeaders()).catch(function () { return ""; });
            var wt = firstMatch(globalJs, [/appdata\.wt\s*=\s*["']([^"']+)["']/i]);
            if (!wt) return [];
            var json = await getJson("https://api.gofile.io/contents/" + folderId + "?wt=" + encodeURIComponent(wt), {
                "Authorization": "Bearer " + token,
                "User-Agent": "Mozilla/5.0"
            }).catch(function () { return {}; });
            var children = json && json.data && json.data.children || {};
            var streams = [];
            for (var key in children) {
                if (!Object.prototype.hasOwnProperty.call(children, key)) continue;
                var file = children[key];
                if (!file || !file.link) continue;
                streams.push(buildStream(file.link, "Movies4u [GoFile]", qualityFromText(file.name), {}));
            }
            return streams;
        }

        async function resolveHubCloud(url) {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" })).catch(function () { return ""; });
            var innerHref = firstMatch(html, [
                /id=["']download["'][^>]*href=["']([^"']+)["']/i,
                /href=["']([^"']+)["'][^>]*id=["']download["']/i
            ]);
            var innerUrl = absoluteUrl(baseOrigin(url), innerHref || url);
            var innerHtml = await getText(innerUrl, defaultHeaders({ "Referer": baseOrigin(url) + "/" })).catch(function () { return html; });
            var anchors = parseAnchors(innerHtml, baseOrigin(innerUrl));
            var streams = [];
            for (var i = 0; i < anchors.length; i++) {
                var anchor = anchors[i];
                var text = String(anchor.text || "").toLowerCase();
                if (/pixeldrain|pixel/i.test(text)) {
                    var base = baseOrigin(anchor.href);
                    var pixel = /download/i.test(anchor.href) ? anchor.href : (base + "/api/file/" + anchor.href.split("/").pop() + "?download");
                    streams.push(buildStream(pixel, "Movies4u [Pixeldrain]", qualityFromText(anchor.text), {}));
                } else if (/download|server|file|mega|s3|buzz/i.test(text)) {
                    streams.push(buildStream(anchor.href, "Movies4u [HubCloud]", qualityFromText(anchor.text), {}));
                }
            }
            return streams;
        }

        async function resolveHubDrive(url) {
            var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
            var html = await getText(url, headers, true).catch(function () { return ""; });
            var candidates = extractInterestingUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url && !/hubdrive\./i.test(candidate);
            });
            if (!candidates.length) return [];
            var resolved = [];
            for (var i = 0; i < candidates.length; i++) {
                resolved = resolved.concat(await resolveExtractorUrl(candidates[i], "Movies4u [HubDrive]"));
            }
            return resolved;
        }

        async function resolveFilepress(url) {
            var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
            var res = await request(url, { headers: headers, allowRedirects: false }).catch(function () { return null; });
            var location = res && (res.headers.location || res.headers["x-redirect-location"]);
            if (location && /^https?:\/\//i.test(location)) {
                if (isDirectMediaUrl(location)) return [buildStream(location, "Movies4u [Filepress]", qualityFromText(location), {})];
                return resolveExtractorUrl(location, "Movies4u [Filepress]");
            }
            var html = await getText(url, headers, true).catch(function () { return ""; });
            var candidates = extractInterestingUrls(html, baseOrigin(url));
            if (!candidates.length) return [];
            var out = [];
            for (var i = 0; i < candidates.length; i++) {
                out = out.concat(await resolveExtractorUrl(candidates[i], "Movies4u [Filepress]"));
            }
            return out;
        }

        async function resolveGdflix(url) {
            var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
            var html = await getText(url, headers, true).catch(function () { return ""; });
            var anchors = parseAnchors(html, baseOrigin(url));
            var candidates = [];
            for (var i = 0; i < anchors.length; i++) {
                if (/download|instant|gofile|pixeldrain|drivebot|index/i.test(String(anchors[i].text || ""))) candidates.push(anchors[i].href);
            }
            if (!candidates.length) candidates = extractInterestingUrls(html, baseOrigin(url));
            var out = [];
            for (var j = 0; j < candidates.length; j++) {
                var candidate = candidates[j];
                if (/gofile/i.test(candidate)) out = out.concat(await resolveGofile(candidate));
                else if (/pixeldrain/i.test(candidate)) out.push(buildStream(candidate, "Movies4u [GDFlix]", qualityFromText(candidate), {}));
                else out = out.concat(await resolveExtractorUrl(candidate, "Movies4u [GDFlix]"));
            }
            return out;
        }

        async function resolveMdrive(url) {
            var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
            var res = await request(url, { headers: headers, allowRedirects: false }).catch(function () { return null; });
            var redirect = normalizeExtractedUrl(res && (res.headers.location || res.headers["x-redirect-location"]) || "", baseOrigin(url));
            if (redirect && redirect !== url) return resolveExtractorUrl(redirect, "Movies4u [MDrive]");
            var html = await getText(url, headers, true).catch(function () { return ""; });
            var candidates = extractInterestingUrls(html, baseOrigin(url)).filter(function (candidate) {
                return candidate !== url;
            });
            if (!candidates.length) return [];
            var out = [];
            for (var i = 0; i < candidates.length; i++) {
                out = out.concat(await resolveExtractorUrl(candidates[i], "Movies4u [MDrive]"));
            }
            return out;
        }

        async function resolveExtractorUrl(url, label) {
            if (!url) return [];
            if (isDirectMediaUrl(url)) return [buildStream(url, label || "Movies4u", qualityFromText(url), {})];
            if (/gofile\.io/i.test(url)) return resolveGofile(url);
            if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php/i.test(url)) return resolveHubCloud(url);
            if (/hubdrive\./i.test(url)) return resolveHubDrive(url);
            if (/filepress\.|filebee/i.test(url)) return resolveFilepress(url);
            if (/gdfli?x/i.test(url)) return resolveGdflix(url);
            if (/mdrive\.ink/i.test(url)) return resolveMdrive(url);

            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
            var candidates = extractInterestingUrls(html, baseOrigin(url)).filter(function (candidate) { return candidate !== url; });
            if (!candidates.length) return [];
            var out = [];
            for (var i = 0; i < candidates.length; i++) {
                out = out.concat(await resolveExtractorUrl(candidates[i], label || "Movies4u"));
            }
            return out;
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            var out = [];
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var html = await getText(mainUrl + "/?s=" + encodeURIComponent(query), defaultHeaders({ "Referer": mainUrl + "/" }));
                    out = parseSearchResults(html, mainUrl);
                } catch (_) {
                    out = [];
                }
                if (out.length) break;
            }
            return out;
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var match = bestMatch(results, queries, media.year, media.isMovie ? "movie" : null);
            if (!match) return [];
            var html = await getText(match.url, defaultHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            if (!html) return [];

            var links = [];
            if (media.isMovie) {
                links = extractDownloadLinks(html, baseOrigin(match.url));
            } else {
                var seasons = getSeasonSections(html, baseOrigin(match.url));
                for (var i = 0; i < seasons.length; i++) {
                    if (Number(seasons[i].season) !== Number(media.season)) continue;
                    for (var j = 0; j < seasons[i].links.length; j++) {
                        var seasonUrl = seasons[i].links[j];
                        var seasonHtml = await getText(seasonUrl, defaultHeaders({ "Referer": match.url }), true).catch(function () { return ""; });
                        var blocks = getEpisodeBlocks(seasonHtml, baseOrigin(seasonUrl));
                        for (var k = 0; k < blocks.length; k++) {
                            if (Number(blocks[k].episode) === Number(media.episode)) {
                                links = links.concat(blocks[k].links);
                            }
                        }
                    }
                }
            }

            links = uniqueBy(links, function (item) { return item; });
            var out = [];
            for (var x = 0; x < links.length; x++) {
                out = out.concat(await resolveExtractorUrl(links[x], "Movies4u"));
            }
            return dedupeStreams(out);
        }

        return {
            key: "p_movies4u",
            name: "Movies4u",
            resolve: resolve
        };
    })();

    var KaidoSource = (function () {
        var MAIN_URL = "https://kaido.to";
        var HEADERS = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
            "Accept": "*/*",
            "Accept-Language": "en-US,en;q=0.5",
            "Referer": MAIN_URL + "/"
        };

        function fixUrl(href) {
            if (!href) return "";
            if (/^https?:\/\//i.test(href)) return href;
            if (/^\/\//.test(href)) return "https:" + href;
            return MAIN_URL + (href.charAt(0) === "/" ? "" : "/") + href;
        }

        function getType(typeStr) {
            if (!typeStr) return "anime";
            var t = String(typeStr).toUpperCase();
            if (t.indexOf("MOVIE") !== -1) return "movie";
            return "anime";
        }

        function attrVal(html, attrName) {
            var reDouble = new RegExp(attrName + '="([^"]*)"', "i");
            var reSingle = new RegExp(attrName + "='([^']*)'", "i");
            var match = html.match(reDouble) || html.match(reSingle);
            return match ? match[1] : "";
        }

        function innerText(html) {
            return decodeHtml(String(html || "").replace(/<[^>]+>/g, " ").replace(/\s+/g, " ").trim());
        }

        function parseFlwItem(itemHtml) {
            var hrefMatch = itemHtml.match(/<a[^>]+href=["']([^"']+)["']/i);
            var href = hrefMatch ? fixUrl(hrefMatch[1]) : "";
            var filmAnchorMatch = itemHtml.match(/<h3[^>]*class=["'][^"']*film-name[^"']*["'][^>]*>[\s\S]*?(<a[^>]*>)/i);
            var filmAnchorTag = filmAnchorMatch ? filmAnchorMatch[1] : "";
            var titleAttrMatch = filmAnchorTag.match(/\btitle="([^"]+)"/i) || filmAnchorTag.match(/\btitle='([^']+)'/i);
            var title = titleAttrMatch ? decodeHtml(titleAttrMatch[1].trim()) : "";
            if (!title) {
                var innerMatch = itemHtml.match(/<h3[^>]*class=["'][^"']*film-name[^"']*["'][^>]*>[\s\S]*?<a[^>]*>([^<]+)<\/a>/i);
                if (innerMatch) title = decodeHtml(innerMatch[1].trim());
            }
            var posterMatch = itemHtml.match(/<img[^>]+data-src=["']([^"']+)["']/i);
            var poster = posterMatch ? fixUrl(posterMatch[1]) : "";
            var typeMatch = itemHtml.match(/<span[^>]*class=["'][^"']*fdi-item[^"']*["'][^>]*>([^<]+)<\/span>/i);
            var type = getType(typeMatch ? typeMatch[1].trim() : "");
            if (!title || !href) return null;
            return {
                title: title,
                type: type,
                url: href,
                poster: poster
            };
        }

        function parseFlwItems(html) {
            var items = [];
            var startRe = /<div[^>]*class=["'][^"]*flw-item[^"]*["'][^>]*>/gi;
            var match;
            while ((match = startRe.exec(html)) !== null) {
                var start = match.index;
                var depth = 0;
                var pos = start;
                var end = start;
                while (pos < html.length) {
                    var nextOpen = html.indexOf("<div", pos);
                    var nextClose = html.indexOf("</div>", pos);
                    if (nextOpen === -1 && nextClose === -1) break;
                    if (nextClose === -1 || (nextOpen !== -1 && nextOpen < nextClose)) {
                        depth++;
                        pos = nextOpen + 4;
                    } else {
                        depth--;
                        pos = nextClose + 6;
                        if (depth === 0) {
                            end = pos;
                            break;
                        }
                    }
                }
                if (end > start) {
                    var item = parseFlwItem(html.slice(start, end));
                    if (item) items.push(item);
                }
            }
            return items;
        }

        async function searchTitles(queries) {
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var html = await getText(MAIN_URL + "/search?keyword=" + encodeURIComponent(query) + "&page=1", HEADERS);
                    var items = parseFlwItems(html);
                    if (items.length) return items;
                } catch (_) {}
            }
            return [];
        }

        async function fetchEpisodeList(animeId, animeUrl) {
            var res = await getJson(MAIN_URL + "/ajax/episode/list/" + animeId, {
                "Accept": "application/json",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": animeUrl
            }).catch(function () { return {}; });
            var epHtml = res && res.html || "";
            var regex = /<a[^>]+class=["'][^"']*ssl-item\s+ep-item[^"']*["'][^>]*>([\s\S]*?)<\/a>/gi;
            var items = [];
            var match;
            while ((match = regex.exec(epHtml)) !== null) {
                var tag = match[0];
                var href = attrVal(tag, "href");
                var orderMatch = tag.match(/<div[^>]*class=["'][^"']*ssli-order[^"']*["'][^>]*>(\d+)<\/div>/i);
                if (!href || !orderMatch) continue;
                items.push({
                    href: href.replace(/^\//, ""),
                    epNum: Number(orderMatch[1])
                });
            }
            return items;
        }

        async function parseM3u8Qualities(masterUrl, streamHeaders, sourceName) {
            var results = [];
            try {
                var text = await getText(masterUrl, streamHeaders);
                var baseUrl = masterUrl.substring(0, masterUrl.lastIndexOf("/") + 1);
                var lines = text.split("\n");
                for (var i = 0; i < lines.length; i++) {
                    var line = trim(lines[i]);
                    if (line.indexOf("#EXT-X-STREAM-INF") === -1) continue;
                    var band = line.match(/BANDWIDTH=(\d+)/i);
                    var res = line.match(/RESOLUTION=\d+x(\d+)/i);
                    var quality = res ? Number(res[1]) : (band ? (Number(band[1]) >= 4000000 ? 1080 : Number(band[1]) >= 2000000 ? 720 : 480) : 0);
                    var variant = "";
                    for (var j = i + 1; j < lines.length; j++) {
                        variant = trim(lines[j]);
                        if (variant && variant.indexOf("#") !== 0) break;
                    }
                    if (!variant) continue;
                    if (!/^https?:\/\//i.test(variant)) variant = baseUrl + variant;
                    results.push({
                        url: variant,
                        source: sourceName,
                        quality: quality,
                        headers: streamHeaders,
                        isM3U8: true
                    });
                }
            } catch (_) {}
            if (!results.length) {
                results.push({
                    url: masterUrl,
                    source: sourceName,
                    quality: 0,
                    headers: streamHeaders,
                    isM3U8: true
                });
            }
            return results;
        }

        async function extractMegaPlay(embedUrl, serverLabel) {
            try {
                var embedBase = /rapid-cloud\.co/i.test(embedUrl) ? "https://rapid-cloud.co" : (/megaplay\.buzz/i.test(embedUrl) ? "https://megaplay.buzz" : baseOrigin(embedUrl));
                var embedId = String(embedUrl || "").split("?")[0].split("/").pop();
                if (!embedId) return { streams: [] };
                var apiUrl = embedBase + "/embed-2/v2/e-1/getSources?id=" + embedId;
                var json = await getJson(apiUrl, {
                    "Accept": "*/*",
                    "X-Requested-With": "XMLHttpRequest",
                    "Referer": embedBase + "/",
                    "Origin": "https://rapid-cloud.co",
                    "User-Agent": HEADERS["User-Agent"]
                }).catch(function () { return {}; });
                if (json.encrypted === true || typeof json.sources === "string") return { streams: [] };
                var sources = Array.isArray(json.sources) ? json.sources : [];
                var streamHeaders = {
                    "User-Agent": HEADERS["User-Agent"],
                    "Origin": "https://rapid-cloud.co",
                    "Referer": "https://rapid-cloud.co/"
                };
                var streams = [];
                for (var i = 0; i < sources.length; i++) {
                    var src = sources[i];
                    if (!src || !src.file) continue;
                    if ((src.type === "hls") || /\.m3u8(?:[?#].*)?$/i.test(src.file)) {
                        streams = streams.concat(await parseM3u8Qualities(src.file, streamHeaders, "Kaido [" + serverLabel + "]"));
                    } else {
                        streams.push({
                            url: src.file,
                            source: "Kaido [" + serverLabel + "]",
                            quality: 0,
                            headers: streamHeaders
                        });
                    }
                }
                return { streams: streams };
            } catch (_) {
                return { streams: [] };
            }
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var match = bestMatch(results, queries, media.year, media.isMovie ? "movie" : "anime");
            if (!match) return [];
            var animeId = String(match.url || "").replace(/\?.*$/, "").split("-").pop().replace(/\/.*$/, "");
            if (!animeId) return [];
            var episodes = await fetchEpisodeList(animeId, match.url.replace("watch/", ""));
            var target = null;
            if (media.isMovie) target = episodes[0] || null;
            else {
                for (var i = 0; i < episodes.length; i++) {
                    if (Number(episodes[i].epNum) === Number(media.episode)) {
                        target = episodes[i];
                        break;
                    }
                }
            }
            if (!target) return [];

            var epIdMatch = String(target.href || "").match(/ep=(\d+)/);
            if (!epIdMatch) return [];
            var epId = epIdMatch[1];
            var serverList = await getJson(MAIN_URL + "/ajax/episode/servers?episodeId=" + epId, {
                "Accept": "application/json",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": MAIN_URL + "/" + target.href
            }).catch(function () { return {}; });
            var serverHtml = serverList && serverList.html || "";
            var servers = [];
            var seen = {};
            var regex = /<div[^>]*class=["'][^"']*server-item[^"']*["'][^>]*>([\s\S]*?)<\/div>/gi;
            var matchServer;
            while ((matchServer = regex.exec(serverHtml)) !== null) {
                var block = matchServer[0];
                var dataId = attrVal(block, "data-id");
                var dataType = attrVal(block, "data-type");
                var label = stripTags(firstMatch(block, [/<a[^>]*class=["'][^"']*btn[^"']*["'][^>]*>([^<]+)<\/a>/i])) || "Server";
                if (!dataId || seen[dataId]) continue;
                if (dataType !== "sub" && dataType !== "dub" && dataType !== "raw") continue;
                seen[dataId] = true;
                servers.push({ id: dataId, label: label });
            }

            var streams = [];
            for (var j = 0; j < servers.length; j++) {
                var json = await getJson(MAIN_URL + "/ajax/episode/sources?id=" + servers[j].id, {
                    "Accept": "application/json",
                    "X-Requested-With": "XMLHttpRequest",
                    "Referer": MAIN_URL + "/" + target.href
                }).catch(function () { return {}; });
                if (!json || !json.link) continue;
                var extracted = await extractMegaPlay(json.link, servers[j].label);
                streams = streams.concat(extracted.streams || []);
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_kaido",
            name: "Kaido",
            resolve: resolve
        };
    })();

    var AnimetsuSource = (function () {
        var MAIN_URL = "https://animetsu.net";
        var API_BASE = MAIN_URL + "/v2/api/anime";
        var PROXY_BASE = "https://ani.metsu.site/proxy";
        var HEADERS = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
            "Accept": "application/json, text/plain, */*",
            "Origin": MAIN_URL,
            "Referer": MAIN_URL + "/"
        };

        function proxiedUrl(path) {
            if (!path) return "";
            if (/^https?:\/\//i.test(path)) return path;
            return PROXY_BASE + (path.charAt(0) === "/" ? "" : "/") + path;
        }

        function itemTitle(data) {
            if (!data || !data.title) return "";
            return trim(data.title.english || data.title.romaji || data.title.native || "");
        }

        async function searchTitles(queries) {
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var data = await getJson(API_BASE + "/search/?query=" + encodeURIComponent(query), HEADERS);
                    var results = ((data && data.results) || []).map(function (entry) {
                        return {
                            id: String(entry.id),
                            title: itemTitle(entry),
                            year: entry.year || undefined,
                            type: /movie/i.test(String(entry.format || entry.type || "")) ? "movie" : "anime"
                        };
                    }).filter(function (entry) { return !!entry.title; });
                    if (results.length) return results;
                } catch (_) {}
            }
            return [];
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var match = bestMatch(results, queries, media.year, media.isMovie ? "movie" : "anime");
            if (!match) return [];

            var episodes = await getJson(API_BASE + "/eps/" + match.id, HEADERS).catch(function () { return []; });
            var target = null;
            if (media.isMovie) target = episodes[0] || null;
            else {
                for (var i = 0; i < episodes.length; i++) {
                    if (Number(episodes[i].ep_num) === Number(media.episode)) {
                        target = episodes[i];
                        break;
                    }
                }
            }
            if (!target) return [];

            var serverList = await getJson(API_BASE + "/servers/" + match.id + "/" + target.ep_num, HEADERS).catch(function () { return []; });
            if (!serverList || !serverList.length) serverList = [{ id: "default", default: true }];

            var streams = [];
            var seen = {};
            for (var j = 0; j < serverList.length; j++) {
                var server = serverList[j];
                var sourceTypes = media.preferDub ? ["dub", "sub"] : ["sub", "dub"];
                for (var k = 0; k < sourceTypes.length; k++) {
                    var sourceType = sourceTypes[k];
                    var payload = await getJson(
                        API_BASE + "/oppai/" + match.id + "/" + target.ep_num
                        + "?server=" + encodeURIComponent(server.id || "default")
                        + "&source_type=" + encodeURIComponent(sourceType),
                        HEADERS
                    ).catch(function () { return null; });
                    if (!payload || !Array.isArray(payload.sources)) continue;
                    for (var x = 0; x < payload.sources.length; x++) {
                        var source = payload.sources[x];
                        var streamUrl = source.need_proxy ? proxiedUrl(source.url) : source.url;
                        var key = streamUrl + "|" + sourceType + "|" + (payload.server || server.id);
                        if (!streamUrl || seen[key]) continue;
                        seen[key] = true;
                        streams.push({
                            url: streamUrl,
                            source: "Animetsu [" + (payload.server || server.id || "default") + " " + sourceType.toUpperCase() + "]",
                            quality: qualityFromText(source.quality || streamUrl),
                            headers: {
                                "User-Agent": HEADERS["User-Agent"],
                                "Origin": MAIN_URL,
                                "Referer": MAIN_URL + "/"
                            }
                        });
                    }
                }
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_gojo",
            name: "Animetsu",
            resolve: resolve
        };
    })();

    var AnimePaheSource = (function () {
        var MAIN_URL = "https://animepahe.org";
        var PROXY = "https://animepaheproxy.phisheranimepahe.workers.dev/?url=";
        var HEADERS = {
            "Cookie": "__ddg2_=1234567890",
            "Referer": MAIN_URL,
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
        };

        function proxied(path) {
            return PROXY + MAIN_URL + path;
        }

        function baseConvert(number, radix) {
            var chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            if (radix <= 36) return Number(number).toString(radix);
            var value = Number(number);
            if (!value) return "0";
            var result = "";
            while (value > 0) {
                result = chars[value % radix] + result;
                value = Math.floor(value / radix);
            }
            return result;
        }

        function unpackPackedScript(script) {
            try {
                if (String(script || "").indexOf("function(p,a,c,k,e") === -1) return "";
                var bracePos = script.lastIndexOf("}(");
                if (bracePos === -1) return "";
                var pos = bracePos + 2;
                var len = script.length;

                function skipWs() {
                    while (pos < len && /\s/.test(script.charAt(pos))) pos++;
                }

                function readString() {
                    var quote = script.charAt(pos++);
                    var out = "";
                    while (pos < len) {
                        var ch = script.charAt(pos);
                        if (ch === "\\") {
                            pos++;
                            var esc = script.charAt(pos) || "";
                            var map = { "n": "\n", "r": "\r", "t": "\t", "\\": "\\", "'": "'", "\"": "\"" };
                            out += map.hasOwnProperty(esc) ? map[esc] : esc;
                            pos++;
                        } else if (ch === quote) {
                            pos++;
                            break;
                        } else {
                            out += ch;
                            pos++;
                        }
                    }
                    return out;
                }

                function readInt() {
                    var start = pos;
                    while (pos < len && /\d/.test(script.charAt(pos))) pos++;
                    return Number(script.slice(start, pos));
                }

                function skipComma() {
                    skipWs();
                    if (script.charAt(pos) === ",") pos++;
                    skipWs();
                }

                skipWs();
                if (script.charAt(pos) !== "'" && script.charAt(pos) !== "\"") return "";
                var payload = readString();
                skipComma();
                var radix = readInt();
                skipComma();
                var wordCount = readInt();
                skipComma();

                var keys = [];
                if (script.charAt(pos) === "'" || script.charAt(pos) === "\"") {
                    keys = readString().split("|");
                } else if (script.charAt(pos) === "[") {
                    pos++;
                    while (pos < len && script.charAt(pos) !== "]") {
                        skipWs();
                        if (script.charAt(pos) === "'" || script.charAt(pos) === "\"") keys.push(readString());
                        else {
                            keys.push("");
                            pos++;
                        }
                        skipWs();
                        if (script.charAt(pos) === ",") pos++;
                    }
                } else {
                    return "";
                }

                if (!radix || radix < 2 || wordCount < 0) return "";
                while (wordCount--) {
                    if (keys[wordCount]) {
                        payload = payload.replace(new RegExp("\\b" + baseConvert(wordCount, radix) + "\\b", "g"), keys[wordCount]);
                    }
                }
                return payload;
            } catch (_) {
                return "";
            }
        }

        async function searchTitles(queries) {
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var data = await getJson(proxied("/api?m=search&l=8&q=" + encodeURIComponent(query)), HEADERS);
                    var rows = (data && data.data) || [];
                    var results = rows.map(function (entry) {
                        return {
                            session: String(entry && entry.session || ""),
                            title: trim(entry && entry.title),
                            year: entry && entry.year || undefined,
                            type: /movie/i.test(String(entry && entry.type || "")) ? "movie" : "anime"
                        };
                    }).filter(function (entry) {
                        return entry.session && entry.title;
                    });
                    if (results.length) return results;
                } catch (_) {}
            }
            return [];
        }

        async function findTargetEpisode(session, episode, isMovie) {
            var page = 1;
            var lastPage = 1;
            while (page <= lastPage) {
                var data = await getJson(proxied("/api?m=release&id=" + encodeURIComponent(session) + "&sort=episode_asc&page=" + page), HEADERS).catch(function () {
                    return null;
                });
                var rows = data && data.data || [];
                if (data && data.last_page) lastPage = Number(data.last_page) || 1;
                if (isMovie && rows.length) return rows[0];
                for (var i = 0; i < rows.length; i++) {
                    if (Number(rows[i] && rows[i].episode) === Number(episode)) return rows[i];
                }
                page++;
            }
            return null;
        }

        async function extractKwikStream(kwikUrl) {
            try {
                var html = await getText(kwikUrl, Object.assign({}, HEADERS, { "Referer": kwikUrl }));
                var scriptMatch = html.match(/<script[^>]*>\s*(eval\(function\(p,a,c,k,e[,d]*\)[\s\S]*?)<\/script>/i);
                if (!scriptMatch) return "";
                var unpacked = unpackPackedScript(scriptMatch[1]);
                if (!unpacked) return "";
                return firstMatch(unpacked, [
                    /source\s*=\s*['"]([^'"]*\.m3u8[^'"]*)['"]/i,
                    /(https?:\/\/[^\s'"]+\.m3u8[^\s'"]*)/i
                ]);
            } catch (_) {
                return "";
            }
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var match = bestMatch(results, queries, media.year, media.isMovie ? "movie" : "anime");
            if (!match || !match.session) return [];

            var target = await findTargetEpisode(match.session, media.episode, media.isMovie);
            if (!target || !target.session) return [];

            var playHtml = await getText(proxied("/play/" + match.session + "/" + target.session), HEADERS).catch(function () {
                return "";
            });
            if (!playHtml) return [];

            var regex = /<button[^>]*data-src="(https:\/\/kwik\.cx\/e\/[^"]*)"[^>]*>([\s\S]*?)<\/button>/gi;
            var seen = {};
            var streams = [];
            var kwikMatch;
            while ((kwikMatch = regex.exec(playHtml)) !== null) {
                var kwikHref = kwikMatch[1];
                var buttonText = stripTags(kwikMatch[2] || "");
                var kind = /eng|dub/i.test(buttonText) ? "DUB" : "SUB";
                var streamUrl = await extractKwikStream(kwikHref);
                if (!streamUrl) continue;
                var key = streamUrl + "|" + kind;
                if (seen[key]) continue;
                seen[key] = true;
                streams.push({
                    url: streamUrl,
                    source: "AnimePahe [" + kind + "]",
                    quality: qualityFromText(buttonText || streamUrl),
                    headers: Object.assign({}, HEADERS, { "Referer": "https://kwik.cx/" })
                });
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_animepahe",
            name: "AnimePahe",
            resolve: resolve
        };
    })();

    var HindmoviezSource = (function () {
        var DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";
        var FALLBACK_DOMAINS = [
            "https://hindmoviez.cafe",
            "https://hindmoviez.com",
            "https://hindmoviez.net",
            "https://hindmoviez.in"
        ];
        var SKIP_PATTERNS = [
            /t\.me\//i, /telegram\./i, /facebook\.com/i, /instagram\.com/i,
            /twitter\.com/i, /youtube\.com/i, /doubleclick/i, /googlesyndication/i,
            /contact/i, /disclaimer/i
        ];

        var cachedMainUrl = "";
        var cachedMainUrlAt = 0;
        var DOMAIN_TTL = 30 * 60 * 1000;

        function getOrigin(url) {
            return baseOrigin(url);
        }

        function isBlockedBody(body) {
            var text = String(body || "");
            return /just a moment/i.test(text)
                || /checking if the site connection is secure/i.test(text)
                || /cf-browser-verification/i.test(text)
                || (/attention required/i.test(text) && /cloudflare/i.test(text));
        }

        function isGoodUrl(url) {
            var value = String(url || "");
            if (!/^https?:\/\//i.test(value)) return false;
            for (var i = 0; i < SKIP_PATTERNS.length; i++) {
                if (SKIP_PATTERNS[i].test(value)) return false;
            }
            return true;
        }

        function parseArticles(html, mainUrl) {
            var items = [];
            var blocks = String(html || "").match(/<article[\s\S]*?<\/article>/gi) || [];
            if (!blocks.length) blocks = String(html || "").match(/<div[^>]+class="[^"]*\bpost\b[^"]*"[\s\S]*?<\/div>/gi) || [];
            for (var i = 0; i < blocks.length; i++) {
                var block = blocks[i];
                var title = stripTags(firstMatch(block, [
                    /<h[23][^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>/i,
                    /<h[23][^>]*>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>[\s\S]*?<\/h[23]>/i
                ]));
                var href = absoluteUrl(mainUrl, firstMatch(block, [/<a[^>]+href=["']([^"']+)["']/i]));
                if (!title || !href) continue;
                items.push({
                    title: trim(title),
                    url: href,
                    type: /season/i.test(title) ? "series" : "movie"
                });
            }
            return items;
        }

        async function isHealthyDomain(url) {
            try {
                var text = await getText(String(url || "").replace(/\/$/, "") + "/", {});
                return !isBlockedBody(text);
            } catch (_) {
                return false;
            }
        }

        async function getMainUrl(force) {
            var now = Date.now();
            if (!force && cachedMainUrl && (now - cachedMainUrlAt) < DOMAIN_TTL) return cachedMainUrl;
            var candidates = [];
            try {
                var domainJson = await getJson(DOMAINS_URL, { "Accept": "application/json" });
                if (domainJson && domainJson.hindmoviez) candidates.push(domainJson.hindmoviez);
                if (domainJson && domainJson.hindmoviez_url) candidates.push(domainJson.hindmoviez_url);
            } catch (_) {}
            candidates = candidates.concat(FALLBACK_DOMAINS);
            var uniq = uniqueValues(candidates);
            for (var i = 0; i < uniq.length; i++) {
                if (await isHealthyDomain(uniq[i])) {
                    cachedMainUrl = String(uniq[i]).replace(/\/$/, "");
                    cachedMainUrlAt = Date.now();
                    return cachedMainUrl;
                }
            }
            cachedMainUrl = FALLBACK_DOMAINS[0];
            cachedMainUrlAt = Date.now();
            return cachedMainUrl;
        }

        async function rewriteToActiveDomain(url) {
            var origin = getOrigin(url);
            if (!origin) return url;
            var mainUrl = await getMainUrl(false);
            var activeOrigin = getOrigin(mainUrl);
            return origin === activeOrigin ? url : String(url).replace(origin, activeOrigin);
        }

        async function siteRequest(url) {
            var current = await rewriteToActiveDomain(url);
            var lastError = null;
            for (var i = 0; i < 2; i++) {
                try {
                    var body = await getText(current, { "Referer": getOrigin(current) + "/" }, true);
                    if (isBlockedBody(body)) throw new Error("Blocked by anti-bot");
                    return { url: current, body: body };
                } catch (error) {
                    lastError = error;
                    var mainUrl = await getMainUrl(true);
                    current = String(current).replace(getOrigin(current), getOrigin(mainUrl));
                }
            }
            throw lastError || new Error("Hindmoviez request failed");
        }

        async function fetchFinal(url, maxHops) {
            var current = url;
            for (var i = 0; i < (maxHops || 4); i++) {
                var res = await request(current, {
                    headers: { "Referer": getOrigin(current) + "/" },
                    allowRedirects: false
                }).catch(function () { return null; });
                if (!res) return { url: current, body: "" };
                var body = String(res.body || "");
                var redirect = res.headers && (res.headers.location || res.headers["x-redirect-location"]);
                if (redirect) {
                    current = absoluteUrl(current, redirect);
                    continue;
                }
                var meta = body.match(/<meta[^>]+http-equiv=["']refresh["'][^>]+content="[^;]*;\s*url=([^"'>\s]+)/i);
                if (meta) {
                    current = absoluteUrl(current, meta[1].replace(/['"]/g, ""));
                    continue;
                }
                var js = body.match(/window\.location(?:\.href)?\s*=\s*["']([^"']+)["']/i)
                    || body.match(/location\.replace\(\s*["']([^"']+)["']\s*\)/i);
                if (js) {
                    current = absoluteUrl(current, js[1]);
                    continue;
                }
                return { url: current, body: body };
            }
            return { url: current, body: "" };
        }

        function parseAnchorsByClass(body, classPart, baseUrl) {
            var out = [];
            var regex = /<a([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
            var match;
            while ((match = regex.exec(String(body || "")))) {
                var attrs = String(match[1] || "") + " " + String(match[3] || "");
                if (!new RegExp('class=["\'][^"\']*' + classPart + '[^"\']*["\']', "i").test(attrs)) continue;
                out.push({
                    href: absoluteUrl(baseUrl, match[2]),
                    text: stripTags(match[4] || "")
                });
            }
            return out;
        }

        function parseAnchorsContainingButtonClass(body, classPart, baseUrl) {
            var out = [];
            var regex = new RegExp('<a[^>]+href=["\']([^"\']+)["\'][^>]*>[\\s\\S]*?<button[^>]+class=["\'][^"\']*' + classPart + '[^"\']*["\'][^>]*>([\\s\\S]*?)<\\/button>[\\s\\S]*?<\\/a>', "gi");
            var match;
            while ((match = regex.exec(String(body || "")))) {
                out.push({
                    href: absoluteUrl(baseUrl, match[1]),
                    text: stripTags(match[2] || "")
                });
            }
            return out;
        }

        function isCandidateStreamPageUrl(url) {
            return /hshare\.|gdirect\.|hcloud\.|gdtot\.|redirect\.php|file\.php/i.test(String(url || ""));
        }

        async function collectMovieLinks(html, mainUrl) {
            var candidates = [];
            var match;
            var regexes = [
                /<a[^>]+class=["'][^"']*maxbutton[^"']*["'][^>]+href=["']([^"']+)["']/gi,
                /<a[^>]+class=["'][^"']*download-btn[^"']*["'][^>]+href=["']([^"']+)["']/gi
            ];
            for (var i = 0; i < regexes.length; i++) {
                while ((match = regexes[i].exec(String(html || "")))) {
                    candidates.push(absoluteUrl(mainUrl, match[1]));
                }
            }

            var anchors = parseAnchors(html, mainUrl);
            for (var j = 0; j < anchors.length; j++) {
                if (isGoodUrl(anchors[j].href) && /download|480p|720p|1080p|4k|mvlink/i.test(String(anchors[j].text || ""))) {
                    candidates.push(anchors[j].href);
                }
            }

            candidates = uniqueValues(candidates);
            if (!candidates.length) {
                return uniqueValues(anchors.map(function (row) {
                    return isGoodUrl(row.href) ? row.href : "";
                }).filter(Boolean));
            }

            var nested = [];
            for (var x = 0; x < Math.min(candidates.length, 6); x++) {
                try {
                    var page = await siteRequest(candidates[x]);
                    var links = parseAnchors(page.body, page.url).map(function (row) { return row.href; }).filter(function (href) {
                        return isGoodUrl(href) && isCandidateStreamPageUrl(href);
                    });
                    nested = nested.concat(links);
                } catch (_) {}
            }
            return uniqueValues(nested);
        }

        async function collectSeriesEpisodePages(html, mainUrl, targetSeason, targetEpisode) {
            var out = [];
            var regex = /<h[23][^>]*>[\s\S]*?Season\s*(\d+)[\s\S]*?<\/h[23]>[\s\S]*?<a[^>]+href=["']([^"']+)["']/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var seasonNumber = Number(match[1]);
                if (seasonNumber !== Number(targetSeason)) continue;
                var listUrl = absoluteUrl(mainUrl, match[2]);
                try {
                    var listPage = await siteRequest(listUrl);
                    var anchors = parseAnchors(listPage.body, listPage.url);
                    for (var i = 0; i < anchors.length; i++) {
                        var text = String(anchors[i].text || "");
                        var epMatch = text.match(/Episode\s*(\d+)/i)
                            || text.match(/\bEp\.?\s*(\d+)/i)
                            || text.match(/\bE(\d+)\b/i);
                        if (!epMatch || Number(epMatch[1]) !== Number(targetEpisode)) continue;
                        if (isGoodUrl(anchors[i].href)) out.push(anchors[i].href);
                    }
                } catch (_) {}
            }
            return uniqueValues(out);
        }

        async function extractPageStreams(pageUrl) {
            try {
                var finalPage = await fetchFinal(pageUrl, 4);
                var body = finalPage.body || "";
                var heading = stripTags(firstMatch(body, [/<h2[^>]*>([\s\S]*?)<\/h2>/i]));
                var quality = qualityFromText(heading || pageUrl);
                var finalLinks = [];
                finalLinks = finalLinks.concat(parseAnchorsByClass(body, "button", finalPage.url));
                finalLinks = finalLinks.concat(parseAnchorsContainingButtonClass(body, "button", finalPage.url));
                finalLinks = finalLinks.filter(function (row) { return row && isGoodUrl(row.href); });
                if (!finalLinks.length) return [];
                var chosen = finalLinks[0];
                return [{
                    url: chosen.href,
                    quality: quality || qualityFromText(chosen.text || chosen.href),
                    source: "Hindmoviez [" + trim(chosen.text || "HCloud") + "]",
                    headers: { "Referer": finalPage.url }
                }];
            } catch (_) {
                return [];
            }
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl(false);
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var res = await siteRequest(mainUrl + "/?s=" + encodeURIComponent(query));
                    var items = parseArticles(res.body, mainUrl);
                    if (items.length) return items;
                } catch (_) {}
            }
            return [];
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var match = bestMatch(results, queries, media.year, media.isMovie ? "movie" : "series");
            if (!match || !match.url) return [];

            var page = await siteRequest(match.url).catch(function () { return null; });
            if (!page || !page.body) return [];

            var pageUrls = media.isMovie
                ? await collectMovieLinks(page.body, page.url)
                : await collectSeriesEpisodePages(page.body, page.url, media.season, media.episode);
            if (!pageUrls.length) return [];

            var out = [];
            for (var i = 0; i < Math.min(pageUrls.length, 4); i++) {
                out = out.concat(await extractPageStreams(pageUrls[i]));
            }
            return dedupeStreams(out);
        }

        return {
            key: "p_hindmoviez",
            name: "Hindmoviez",
            resolve: resolve
        };
    })();

    var AnimeToshoSource = (function () {
        var API_BASE = "https://feed.animetosho.org";

        function parseTorznabItems(xml) {
            var out = [];
            var blocks = String(xml || "").match(/<item>[\s\S]*?<\/item>/gi) || [];
            for (var i = 0; i < blocks.length; i++) {
                var block = blocks[i];
                var title = decodeHtml(firstMatch(block, [/<title>([\s\S]*?)<\/title>/i]));
                var magnet = decodeHtml(firstMatch(block, [/<torznab:attr name=["']magneturl["'] value=["']([^"']+)["']/i]));
                if (!magnet) {
                    magnet = decodeHtml(firstMatch(block, [/<a href=["'](magnet:[^"']+)["']/i]));
                }
                if (!title || !magnet) continue;
                out.push({
                    title: trim(title),
                    magnet_uri: magnet,
                    seeders: Number(firstMatch(block, [/<torznab:attr name=["']seeders["'] value=["']([^"']+)["']/i])) || 0,
                    leechers: Number(firstMatch(block, [/<torznab:attr name=["']leechers["'] value=["']([^"']+)["']/i])) || 0,
                    total_size: Number(firstMatch(block, [/<(?:newznab|torznab):attr name=["']size["'] value=["']([^"']+)["']/i])) || 0,
                    episode: Number(firstMatch(block, [/<(?:newznab|torznab):attr name=["']episode["'] value=["']([^"']+)["']/i])) || 0,
                    season: Number(firstMatch(block, [/<(?:newznab|torznab):attr name=["']season["'] value=["']([^"']+)["']/i])) || 0,
                    year: Number(firstMatch(block, [/<(?:newznab|torznab):attr name=["']year["'] value=["']([^"']+)["']/i])) || 0
                });
            }
            return out;
        }

        function episodeMatches(title, episode) {
            var ep = Number(episode);
            if (!ep) return true;
            var text = String(title || "");
            var padded = ep < 10 ? "0" + ep : String(ep);
            return new RegExp("\\bS\\d{1,2}E0*" + ep + "\\b", "i").test(text)
                || new RegExp("\\b(?:Episode|Ep)\\s*0*" + ep + "\\b", "i").test(text)
                || new RegExp("(?:^|[^\\d])0*" + ep + "(?:v\\d+)?(?:[^\\d]|$)", "i").test(text)
                || new RegExp("\\-\\s*" + padded + "(?:[^\\d]|$)", "i").test(text);
        }

        function sizeLabel(bytes) {
            var value = Number(bytes);
            if (!value) return "";
            if (value >= 1073741824) return (value / 1073741824).toFixed(value >= 10737418240 ? 0 : 1) + " GB";
            if (value >= 1048576) return Math.round(value / 1048576) + " MB";
            if (value >= 1024) return Math.round(value / 1024) + " KB";
            return String(value) + " B";
        }

        async function searchEntries(queries) {
            var out = [];
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var xml = await getText(API_BASE + "/api?apikey=0&t=search&q=" + encodeURIComponent(query), {
                        "Accept": "application/rss+xml, application/xml, text/xml"
                    });
                    var rows = parseTorznabItems(xml);
                    out = out.concat(rows);
                    if (out.length >= 60) break;
                } catch (_) {}
            }
            return uniqueBy(out, function (entry) {
                return String(entry && (entry.magnet_uri || entry.title) || "");
            });
        }

        function rankedEntries(entries, media, queries) {
            var list = [];
            for (var i = 0; i < (entries || []).length; i++) {
                var entry = entries[i];
                var title = trim(entry && entry.title);
                var magnetUri = trim(entry && entry.magnet_uri);
                if (!title || !magnetUri) continue;
                var score = titleScore(title, queries);
                if (score <= 0) continue;
                if (media.isMovie) {
                    if (/movie|gekijouban|film/i.test(title)) score += 10;
                } else {
                    if (entry.season && Number(media.season) && Number(entry.season) === Number(media.season)) score += 12;
                    if (entry.episode && Number(media.episode) && Number(entry.episode) === Number(media.episode)) score += 30;
                    else if (episodeMatches(title, media.episode)) score += 20;
                    else score -= 25;
                }
                if (entry.year && media.year && Number(entry.year) === Number(media.year)) score += 8;
                score += Math.min(Number(entry && entry.seeders) || 0, 50);
                score += Math.min(qualityFromText(title) / 100, 20);
                list.push({ item: entry, score: score });
            }
            list.sort(function (a, b) { return b.score - a.score; });
            return list.map(function (row) { return row.item; });
        }

        async function resolve(media) {
            var titleQueries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var searchQueries = titleQueries.slice();
            if (!media.isMovie && Number(media.episode)) {
                var epText = Number(media.episode) < 10 ? "0" + Number(media.episode) : String(Number(media.episode));
                if (media.title) searchQueries.push(media.title + " " + epText);
                if (media.originalTitle) searchQueries.push(media.originalTitle + " " + epText);
            }
            var entries = await searchEntries(uniqueValues(searchQueries));
            var ranked = rankedEntries(entries, media, titleQueries).slice(0, 12);
            var streams = [];
            for (var i = 0; i < ranked.length; i++) {
                var entry = ranked[i];
                var labelParts = ["AnimeTosho"];
                if (entry.seeders != null || entry.leechers != null) {
                    labelParts.push("[S:" + String(entry.seeders == null ? "?" : entry.seeders) + "/L:" + String(entry.leechers == null ? "?" : entry.leechers) + "]");
                }
                var size = sizeLabel(entry.total_size);
                if (size) labelParts.push("[" + size + "]");
                streams.push({
                    url: entry.magnet_uri,
                    source: labelParts.join(" "),
                    quality: qualityFromText(entry.title || ""),
                    headers: {}
                });
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_animetosho",
            name: "AnimeTosho",
            resolve: resolve
        };
    })();

    function cleanProviderLabel(value) {
        return trim(String(value || "").replace(/[^\x20-\x7E]+/g, " ").replace(/\s+/g, " "));
    }

    function createStremioSource(key, name, baseUrl) {
        var API_BASE = String(baseUrl || "").replace(/\/$/, "");
        var HEADERS = {
            "Accept": "application/json, text/plain, */*",
            "Origin": API_BASE,
            "Referer": API_BASE + "/",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
        };

        function streamPath(media) {
            if (!media || !media.imdbId) return "";
            if (media.isMovie) return "/stream/movie/" + encodeURIComponent(media.imdbId) + ".json";
            return "/stream/series/" + encodeURIComponent(media.imdbId)
                + ":" + encodeURIComponent(media.season || 1)
                + ":" + encodeURIComponent(media.episode || 1)
                + ".json";
        }

        function streamSourceLabel(stream) {
            var remoteName = cleanProviderLabel(stream && stream.name);
            if (!remoteName || normalizeTitle(remoteName) === normalizeTitle(name)) return name;
            return name + " [" + remoteName + "]";
        }

        async function resolve(media) {
            if (!media || !media.imdbId || media.anime) return [];
            var path = streamPath(media);
            if (!path) return [];
            var payload = await getJson(API_BASE + path, HEADERS).catch(function () {
                return null;
            });
            var rows = payload && payload.streams || [];
            if (!Array.isArray(rows) || !rows.length) return [];

            var streams = [];
            for (var i = 0; i < rows.length; i++) {
                var stream = rows[i];
                var streamUrl = trim(stream && stream.url || "");
                if (!streamUrl || stream && (stream.externalUrl || stream.ytId)) continue;
                var requestHeaders = stream && stream.behaviorHints && stream.behaviorHints.proxyHeaders && stream.behaviorHints.proxyHeaders.request || {};
                streams.push({
                    url: streamUrl,
                    source: streamSourceLabel(stream),
                    quality: qualityFromText(String(stream && stream.title || stream && stream.name || streamUrl)),
                    headers: Object.assign({}, HEADERS, requestHeaders)
                });
            }
            return dedupeStreams(streams);
        }

        return {
            key: key,
            name: name,
            resolve: resolve
        };
    }

    var StreamvixSource = createStremioSource("p_streamvix", "Streamvix", "https://streamvix.hayd.uk");
    var NoTorrentSource = createStremioSource("p_notorrent", "NoTorrent", "https://addon-osvh.onrender.com");
    var MoviesDriveExtraSource = createJsonSearchDownloadSource("p_moviesdrive_extra", "MoviesDrive", {
        domainKey: "moviesdrive",
        fallback: "https://new2.moviesdrives.my",
        movieOnly: false
    });
    var VegaMoviesSource = createJsonSearchDownloadSource("p_vegamovies", "VegaMovies", {
        domainKey: "vegamovies",
        fallback: "https://vegamovies.vodka",
        movieOnly: true,
        searchPath: "/search.php"
    });
    var RogMoviesSource = createJsonSearchDownloadSource("p_rogmovies", "RogMovies", {
        domainKey: "rogmovies",
        fallback: "https://rogmovies.vip",
        movieOnly: true,
        searchPath: "/search.php"
    });

    function createJsonSearchDownloadSource(key, name, options) {
        var opts = options || {};
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain(opts.domainKey, opts.fallback);
            return cachedMainUrl;
        }

        function parseSearchRows(payload, mainUrl) {
            var hits = payload && payload.hits || [];
            var out = [];
            for (var i = 0; i < hits.length; i++) {
                var doc = hits[i] && hits[i].document || {};
                var title = trim(doc.post_title || doc.title || "");
                var permalink = trim(doc.permalink || "");
                if (!title || !permalink) continue;
                out.push({
                    title: title,
                    year: Number(firstMatch(title, [/\((\d{4})\)/])) || Number(firstMatch(doc.post_date || "", [/(\d{4})/])) || undefined,
                    url: absoluteUrl(mainUrl, permalink),
                    imdbId: trim(doc.imdb_id || ""),
                    type: /season|series|episode/i.test(title) ? "series" : "movie"
                });
            }
            return out;
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            var searchPath = trim(opts.searchPath || "/searchapi.php");
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var json = await getJson(mainUrl + searchPath + "?q=" + encodeURIComponent(query) + "&page=1", commonHeaders({
                        "Accept": "application/json, text/plain, */*",
                        "Referer": mainUrl + "/search.html?q=" + encodeURIComponent(query)
                    }));
                    var rows = parseSearchRows(json, mainUrl);
                    if (rows.length) return rows;
                } catch (_) {}
            }
            return [];
        }

        async function resolve(media) {
            if (media.anime) return [];
            if (opts.movieOnly && !media.isMovie) return [];
            var queries = uniqueBy([media.imdbId, media.title, media.originalTitle], function (item) {
                return trim(String(item || "").toLowerCase());
            }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = null;
            if (media.imdbId) {
                for (var i = 0; i < rows.length; i++) {
                    if (trim(rows[i].imdbId) === trim(media.imdbId)) {
                        match = rows[i];
                        break;
                    }
                }
            }
            if (!match) match = bestMatch(rows, queries, media.year, media.isMovie ? "movie" : null);
            if (!match || !match.url) return [];

            var html = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            if (!html) return [];

            var linkRows = extractExternalSourceLinks(html, match.url);
            var streams = [];
            for (var j = 0; j < linkRows.length; j++) {
                var resolved = await resolveCommonExtractorUrl(linkRows[j].url, name, match.url, 0);
                var linkQuality = qualityFromText(linkRows[j].label || match.title);
                for (var k = 0; k < resolved.length; k++) {
                    if (!resolved[k].quality) resolved[k].quality = linkQuality;
                    streams.push(resolved[k]);
                }
            }
            return dedupeStreams(streams);
        }

        return {
            key: key,
            name: name,
            resolve: resolve
        };
    }

    var BollyflixSource = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("bollyflix", "https://bollyflix.frl");
            return cachedMainUrl;
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var html = await getText(mainUrl + "/search/" + encodeURIComponent(query), commonHeaders({ "Referer": mainUrl + "/" }), true);
                    var results = parseWpArticleResults(html, mainUrl);
                    if (results.length) return results;
                } catch (_) {}
            }
            return [];
        }

        function parseDownloadRows(html, base) {
            var out = [];
            var regex = /<h5\b[^>]*>([\s\S]*?)<\/h5>\s*([\s\S]*?)(?=<h5\b|$)/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var label = stripTags(match[1]);
                var anchors = extractExternalSourceLinks(match[2], base);
                for (var i = 0; i < anchors.length; i++) {
                    out.push({
                        url: anchors[i].url,
                        label: label || anchors[i].label || ""
                    });
                }
            }
            if (!out.length) {
                return extractExternalSourceLinks(html, base).map(function (item) {
                    return { url: item.url, label: item.label || "" };
                });
            }
            return uniqueBy(out, function (item) { return item.url; });
        }

        async function resolve(media) {
            if (!media.isMovie || media.anime) return [];
            var queries = uniqueBy([media.imdbId, media.title, media.originalTitle], function (item) {
                return trim(String(item || "").toLowerCase());
            }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = bestMatch(rows, queries, media.year, "movie");
            if (!match || !match.url) return [];
            var html = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            if (!html) return [];
            var links = parseDownloadRows(html, match.url);
            var streams = [];
            for (var i = 0; i < links.length; i++) {
                var resolved = await resolveCommonExtractorUrl(links[i].url, "Bollyflix", match.url, 0);
                var linkQuality = qualityFromText(links[i].label || match.title);
                for (var j = 0; j < resolved.length; j++) {
                    if (!resolved[j].quality) resolved[j].quality = linkQuality;
                    streams.push(resolved[j]);
                }
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_bollyflix",
            name: "Bollyflix",
            resolve: resolve
        };
    })();

    var HDMovie2Source = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("hdmovie2", "https://hdmovie2.restaurant");
            return cachedMainUrl;
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var html = await getText(mainUrl + "/?s=" + encodeURIComponent(query), commonHeaders({ "Referer": mainUrl + "/" }), true);
                    var results = parseWpArticleResults(html, mainUrl);
                    if (results.length) return results;
                } catch (_) {}
            }
            return [];
        }

        function parsePlayerOptions(html) {
            var out = [];
            var regex = /<li\b[^>]*class=["'][^"']*dooplay_player_option[^"']*["'][^>]*data-(?:type|post|nume)=["'][^"']+["'][^>]*>/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var start = match.index;
                var end = html.indexOf("</li>", start);
                if (end === -1) continue;
                var block = html.slice(start, end + 5);
                var nume = firstMatch(block, [/data-nume=["']([^"']+)["']/i]);
                var postId = firstMatch(block, [/data-post=["']([^"']+)["']/i]);
                var type = firstMatch(block, [/data-type=["']([^"']+)["']/i]);
                var title = stripTags(firstMatch(block, [/<span[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/span>/i]));
                if (!nume || !postId || !type || /trailer/i.test(nume)) continue;
                out.push({ nume: nume, postId: postId, type: type, title: title || ("Server " + nume) });
            }
            return uniqueBy(out, function (item) { return item.nume; });
        }

        async function resolve(media) {
            if (media.anime) return [];
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = bestMatch(rows, queries, media.year, media.isMovie ? "movie" : null);
            if (!match || !match.url) return [];
            var pageHtml = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            if (!pageHtml) return [];

            var options = parsePlayerOptions(pageHtml);
            var streams = [];
            for (var i = 0; i < options.length; i++) {
                var form = "action=doo_player_ajax&post=" + encodeURIComponent(options[i].postId)
                    + "&nume=" + encodeURIComponent(options[i].nume)
                    + "&type=" + encodeURIComponent(options[i].type);
                var res = await request((await getMainUrl()) + "/wp-admin/admin-ajax.php", {
                    method: "POST",
                    body: form,
                    headers: commonHeaders({
                        "Referer": match.url,
                        "Origin": await getMainUrl(),
                        "X-Requested-With": "XMLHttpRequest",
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                    })
                }).catch(function () { return null; });
                var json = res ? parseJsonSafe(res.body, {}) : {};
                var embedUrl = normalizeResolvedUrl(firstMatch(String(json && json.embed_url || ""), [/<iframe[^>]+src=["']([^"']+)["']/i]), match.url);
                if (!embedUrl) continue;
                var resolved = await resolveCommonExtractorUrl(embedUrl, "HDMovie2", match.url, 0);
                var linkQuality = qualityFromText(options[i].title || match.title);
                for (var j = 0; j < resolved.length; j++) {
                    if (!resolved[j].quality) resolved[j].quality = linkQuality;
                    streams.push(resolved[j]);
                }
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_hdmovie2",
            name: "HDMovie2",
            resolve: resolve
        };
    })();

    var TokyoInsiderSource = (function () {
        var MAIN_URL = "https://www.tokyoinsider.com";

        async function searchTitles(queries) {
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var html = await getText(MAIN_URL + "/anime/search?k=" + encodeURIComponent(query), commonHeaders({ "Referer": MAIN_URL + "/anime" }), true);
                    var out = [];
                    var byUrl = Object.create(null);
                    var regex = /<td[^>]+class=["'][^"']*c_h2b?[^"']*["'][\s\S]*?<a[^>]+href=["'](\/anime\/[^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
                    var match;
                    while ((match = regex.exec(html)) !== null) {
                        var href = absoluteUrl(MAIN_URL, match[1]);
                        if (/\/reviews\b/i.test(href)) continue;
                        var item = {
                            title: stripTags(match[2]),
                            url: href,
                            type: /movie|ova|special/i.test(match[2]) ? "movie" : "anime"
                        };
                        var existing = byUrl[href];
                        if (!existing) {
                            byUrl[href] = item;
                            out.push(item);
                        } else if (!trim(existing.title) && trim(item.title)) {
                            existing.title = item.title;
                            existing.type = item.type;
                        }
                    }
                    out = uniqueBy(out, function (item) { return item.url; });
                    if (out.length) return out;
                } catch (_) {}
            }
            return [];
        }

        function parseDirectEpisodeLinks(html, pageUrl) {
            return parseAnchors(html, pageUrl).filter(function (row) {
                return isCommonDirectMediaUrl(row && row.href);
            }).map(function (row) {
                return buildResolvedStream(row.href, "TokyoInsider", qualityFromText(row.text || row.href), {});
            });
        }

        async function resolve(media) {
            if (!media.anime) return [];
            var queries = uniqueBy([media.originalTitle, media.title], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = bestMatch(rows, queries, media.year, media.isMovie ? "movie" : "anime");
            if (!match || !match.url) return [];
            var targetUrl = media.isMovie ? match.url : (match.url.replace(/\/+$/g, "") + "/episode/" + encodeURIComponent(media.episode || 1));
            var html = await getText(targetUrl, commonHeaders({ "Referer": match.url }), true).catch(function () { return ""; });
            if (!html) return [];
            return dedupeStreams(parseDirectEpisodeLinks(html, targetUrl));
        }

        return {
            key: "p_tokyoinsider",
            name: "TokyoInsider",
            resolve: resolve
        };
    })();

    var ToonstreamSource = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("toonstream", "https://toonstream.dad");
            return cachedMainUrl;
        }

        function parseSearchResults(html, mainUrl) {
            return extractBlocks(html, "article").map(function (block) {
                var href = firstMatch(block, [
                    /<a[^>]+href=["']([^"']*(?:\/series\/|\/movies\/)[^"']+)["'][^>]*class=["'][^"']*lnk-blk[^"']*["']/i,
                    /<a[^>]+class=["'][^"']*lnk-blk[^"']*["'][^>]+href=["']([^"']*(?:\/series\/|\/movies\/)[^"']+)["']/i,
                    /<a[^>]+href=["']([^"']*(?:\/series\/|\/movies\/)[^"']+)["']/i
                ]);
                var title = stripTags(firstMatch(block, [
                    /<h2[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h2>/i,
                    /<img[^>]+alt=["']([^"']+)["']/i
                ])).replace(/^Image\s+/i, "");
                if (!href || !title) return null;
                var resolved = absoluteUrl(mainUrl, href);
                return {
                    title: title,
                    url: resolved,
                    type: /\/movies\//i.test(resolved) ? "movie" : "anime"
                };
            }).filter(Boolean).filter(function (item) {
                return /\/(?:series|movies)\//i.test(String(item && item.url || ""));
            }).filter(function (item) {
                return !/category\//i.test(String(item && item.url || ""));
            }).filter(function (item) {
                return !/random|latest/i.test(normalizeTitle(item && item.title || ""));
            }).filter(function (item, index, list) {
                for (var i = 0; i < index; i++) {
                    if (list[i].url === item.url) return false;
                }
                return true;
            });
        }

        function slugifySearch(text) {
            return trim(String(text || "").toLowerCase())
                .replace(/[^a-z0-9]+/g, "-")
                .replace(/^-+|-+$/g, "");
        }

        function findEpisodeLink(html, mainUrl, season, episode) {
            var anchors = parseAnchors(html, mainUrl);
            for (var i = 0; i < anchors.length; i++) {
                var href = String(anchors[i].href || "");
                var match = href.match(/\/episode\/[^/]+-(\d+)x(\d+)\/?$/i);
                if (!match) continue;
                if (Number(match[1]) === Number(season) && Number(match[2]) === Number(episode)) return href;
            }
            return "";
        }

        function extractEmbedCandidates(html, base) {
            var out = [];
            var regexes = [
                /data-src=["']([^"']+)["']/gi,
                /(?:href|src)=["']([^"']+\?trembed=[^"']+)["']/gi
            ];
            for (var i = 0; i < regexes.length; i++) {
                var regex = regexes[i];
                var match;
                while ((match = regex.exec(String(html || "")))) {
                    var value = normalizeResolvedUrl(decodeHtml(match[1]), baseOrigin(base));
                    if (value && /\?trembed=/i.test(value)) out.push(value);
                }
            }
            return uniqueValues(out);
        }

        async function expandFrameUrls(url, referer) {
            if (/\/\/as-cdn\d+\.[^/]+\/video\//i.test(String(url || ""))) return [url];
            if (!/toonstream\.dad\/\?trembed=/i.test(String(url || ""))) return [url];
            var html = await getText(url, commonHeaders({ "Referer": referer || (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
            var frames = [];
            var regex = /<iframe[^>]+src=["']([^"']+)["']/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                frames.push(normalizeResolvedUrl(decodeHtml(match[1]), baseOrigin(url)));
            }
            return frames.length ? uniqueValues(frames) : [url];
        }

        async function resolve(media) {
            if (!media.anime) return [];
            var mainUrl = await getMainUrl();
            var queries = uniqueBy([media.originalTitle, media.title], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var rows = [];
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                var searchUrls = uniqueValues([
                    mainUrl + "/search/" + encodeURIComponent(slugifySearch(query)) + "/",
                    mainUrl + "/?s=" + encodeURIComponent(query)
                ]);
                for (var s = 0; s < searchUrls.length; s++) {
                    try {
                        var html = await getText(searchUrls[s], commonHeaders({ "Referer": mainUrl + "/" }), true);
                        rows = parseSearchResults(html, mainUrl);
                        if (rows.length) break;
                    } catch (_) {}
                }
                if (rows.length) break;
            }
            var match = bestMatch(rows, queries, media.year, media.isMovie ? "movie" : "anime");
            if (!match || !match.url) return [];
            var targetUrl = match.url;
            if (!media.isMovie) {
                var seriesHtml = await getText(match.url, commonHeaders({ "Referer": mainUrl + "/" }), true).catch(function () { return ""; });
                targetUrl = findEpisodeLink(seriesHtml, match.url, media.season || 1, media.episode || 1);
                if (!targetUrl) return [];
            }
            var pageHtml = await getText(targetUrl, commonHeaders({ "Referer": match.url }), true).catch(function () { return ""; });
            if (!pageHtml) return [];
            var iframeUrls = extractEmbedCandidates(pageHtml, targetUrl);
            if (!iframeUrls.length) {
                var frameRegex = /<iframe[^>]+src=["']([^"']+)["']/gi;
                var frameMatch;
                while ((frameMatch = frameRegex.exec(String(pageHtml || "")))) {
                    iframeUrls.push(normalizeResolvedUrl(decodeHtml(frameMatch[1]), baseOrigin(targetUrl)));
                }
                iframeUrls = uniqueValues(iframeUrls);
            }
            var streams = [];
            for (var j = 0; j < iframeUrls.length; j++) {
                var expanded = await expandFrameUrls(iframeUrls[j], targetUrl);
                for (var k = 0; k < expanded.length; k++) {
                    var resolved = await resolveCommonExtractorUrl(expanded[k], "Toonstream", targetUrl, 0);
                    streams = streams.concat(resolved);
                }
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_toonstream",
            name: "Toonstream",
            resolve: resolve
        };
    })();

    var PROVIDERS = [
        CastleSource,
        StreamvixSource,
        NoTorrentSource,
        Movies4uSource,
        HindmoviezSource,
        HDMovie2Source,
        KaidoSource,
        AnimePaheSource,
        AnimetsuSource,
        AnimeToshoSource,
        TokyoInsiderSource
    ];

    async function loadStreams(url, cb) {
        try {
            var media = parsePayload(url);
            var anime = !!media.anime;
            var selectedProviders = PROVIDERS.filter(function (provider) {
                if (anime) {
                    return provider === KaidoSource
                        || provider === AnimePaheSource
                        || provider === AnimetsuSource
                        || provider === AnimeToshoSource
                        || provider === Movies4uSource
                        || provider === TokyoInsiderSource;
                }
                return provider === CastleSource
                    || provider === StreamvixSource
                    || provider === NoTorrentSource
                    || provider === Movies4uSource
                    || provider === HindmoviezSource
                    || provider === HDMovie2Source;
            });

            var settled = await Promise.allSettled(selectedProviders.map(function (provider) {
                return withTimeout(provider.resolve(media), 15000, provider && provider.name || "Provider");
            }));
            var streams = [];
            for (var i = 0; i < settled.length; i++) {
                if (settled[i].status !== "fulfilled") continue;
                streams = streams.concat(settled[i].value || []);
            }

            streams = sortStreams(dedupeStreams(streams)).map(function (item) {
                return new StreamResult(item);
            });

            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    if (typeof globalThis !== "undefined") {
        globalThis.getHome = getHome;
        globalThis.loadHome = getHome;
        globalThis.loadhome = getHome;
        globalThis.search = search;
        globalThis.load = load;
        globalThis.loadStreams = loadStreams;
    }
    if (typeof window !== "undefined") {
        window.getHome = getHome;
        window.loadHome = getHome;
        window.loadhome = getHome;
        window.search = search;
        window.load = load;
        window.loadStreams = loadStreams;
    }
    if (typeof global !== "undefined") {
        global.getHome = getHome;
        global.loadHome = getHome;
        global.loadhome = getHome;
        global.search = search;
        global.load = load;
        global.loadStreams = loadStreams;
    }
})();
