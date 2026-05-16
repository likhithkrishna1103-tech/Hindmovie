(function () {
    "use strict";

    var MAIN_URL = "https://net52.cc";
    var IMG_BASE = "https://imgcdn.kim";
    var COOKIE_TTL_MS = 54000000;
    var USER_AGENT = "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0";
    var NEWTV_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0 /OS.GatuNewTV v1.0";
    var HOME_TITLE_CONCURRENCY = 48;
    var HOME_CACHE_TTL_MS = 180000;

    var PROVIDERS = {
        netflix: {
            id: "netflix",
            name: "Netflix",
            ott: "nf",
            playerOtt: "nf",
            prefix: "",
            search: true,
            poster: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; },
            initialEpisodePoster: function (id) { return IMG_BASE + "/poster/v/150/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/epimg/150/" + id + ".jpg"; },
            suggestPoster: function (id) { return IMG_BASE + "/poster/v/" + id + ".jpg"; }
        },
        prime: {
            id: "prime",
            name: "Prime Video",
            ott: "pv",
            playerOtt: "pv",
            prefix: "/pv",
            search: true,
            poster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/pv/h/" + id + ".jpg"; },
            initialEpisodePoster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/pvepimg/" + id + ".jpg"; },
            suggestPoster: function (id) { return IMG_BASE + "/pv/v/" + id + ".jpg"; }
        },
        hotstar: {
            id: "hotstar",
            name: "Hotstar",
            ott: "hs",
            playerOtt: "hs",
            prefix: "/hs",
            search: true,
            poster: function (id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; },
            background: function (id) { return IMG_BASE + "/hs/h/" + id + ".jpg"; },
            initialEpisodePoster: function (id) { return IMG_BASE + "/hsepimg/150/" + id + ".jpg"; },
            episodePoster: function (id) { return IMG_BASE + "/hsepimg/" + id + ".jpg"; },
            suggestPoster: function (id) { return IMG_BASE + "/hs/v/" + id + ".jpg"; }
        },
        disney: null,
        marvel: null,
        starwars: null,
        pixar: null
    };

    function studioConfig(id, name, studio) {
        var base = Object.assign({}, PROVIDERS.hotstar);
        base.id = id;
        base.name = name;
        base.ott = "dp";
        base.playerOtt = "hs";
        base.prefix = "/hs";
        base.search = false;
        base.studio = studio;
        return base;
    }

    PROVIDERS.disney = studioConfig("disney", "Disney", "disney");
    PROVIDERS.marvel = studioConfig("marvel", "Marvel", "marvel");
    PROVIDERS.starwars = studioConfig("starwars", "Star Wars", "starwars");
    PROVIDERS.pixar = studioConfig("pixar", "Pixar", "pixar");

    var PAGE_HEADERS = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
        "Accept-Language": "en-IN,en-US;q=0.9,en;q=0.8",
        "Cache-Control": "max-age=0",
        "Connection": "keep-alive",
        "sec-ch-ua": "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\"",
        "sec-ch-ua-mobile": "?0",
        "sec-ch-ua-platform": "\"Android\"",
        "Sec-Fetch-Dest": "document",
        "Sec-Fetch-Mode": "navigate",
        "Sec-Fetch-Site": "same-origin",
        "Sec-Fetch-User": "?1",
        "Upgrade-Insecure-Requests": "1",
        "User-Agent": USER_AGENT,
        "X-Requested-With": "XMLHttpRequest"
    };

    var NEWTV_BASE_HEADERS = {
        "Cache-Control": "no-cache, no-store, must-revalidate",
        "Pragma": "no-cache",
        "Expires": "0",
        "X-Requested-With": "NetmirrorNewTV v1.0",
        "User-Agent": NEWTV_USER_AGENT,
        "Accept": "application/json, text/plain, */*"
    };

    var NEWTV_DOMAINS = [
        "aHR0cHM6Ly9tb2JpbGVkZXRlY3RzLmNvbQ==",
        "aHR0cHM6Ly9tb2JpbGVkZXRlY3QuYXBw",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmFydA==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNj",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmNsaWNr",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lmluaw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LmxpdmU=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnBybw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNob3A=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNpdGU=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnNwYWNl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnN0b3Jl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0LnZpcA==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lndpa2k=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0Lnh5eg==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5hcnQ=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5jYw==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbmZv",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5pbms=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5saXZl",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5wcm8=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy5zdG9yZQ==",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy50b3A=",
        "aHR0cHM6Ly9tb2JpZGV0ZWN0cy54eXo="
    ];

    var cookieCache = { value: "", time: 0 };
    var resolvedApiUrl = "";
    var titleCache = {};
    var homeCache = {};
    var LANGUAGE_NAMES = {
        ar: "Arabic", ara: "Arabic",
        bn: "Bengali", ben: "Bengali",
        cs: "Czech", ces: "Czech", cze: "Czech",
        da: "Danish", dan: "Danish",
        de: "German", deu: "German", ger: "German",
        el: "Greek", ell: "Greek", gre: "Greek",
        en: "English", eng: "English",
        es: "Spanish", spa: "Spanish",
        "es-es": "European Spanish",
        fi: "Finnish", fin: "Finnish",
        fr: "French", fra: "French", fre: "French",
        gu: "Gujarati", guj: "Gujarati",
        he: "Hebrew", heb: "Hebrew",
        hi: "Hindi", hin: "Hindi",
        hr: "Croatian", hrv: "Croatian",
        hu: "Hungarian", hun: "Hungarian",
        id: "Indonesian", ind: "Indonesian",
        it: "Italian", ita: "Italian",
        ja: "Japanese", jpn: "Japanese",
        kn: "Kannada", kan: "Kannada",
        ko: "Korean", kor: "Korean",
        ml: "Malayalam", mal: "Malayalam",
        mr: "Marathi", mar: "Marathi",
        ms: "Malay", msa: "Malay", may: "Malay",
        nb: "Norwegian", nob: "Norwegian", no: "Norwegian", nor: "Norwegian",
        nl: "Dutch", nld: "Dutch", dut: "Dutch",
        pa: "Punjabi", pan: "Punjabi",
        pl: "Polish", pol: "Polish",
        pt: "Portuguese", por: "Portuguese",
        "pt-br": "Brazilian Portuguese",
        ro: "Romanian", ron: "Romanian", rum: "Romanian",
        ru: "Russian", rus: "Russian",
        sv: "Swedish", swe: "Swedish",
        ta: "Tamil", tam: "Tamil",
        te: "Telugu", tel: "Telugu",
        th: "Thai", tha: "Thai",
        tr: "Turkish", tur: "Turkish",
        ur: "Urdu", urd: "Urdu",
        vi: "Vietnamese", vie: "Vietnamese",
        "zh-hans": "Chinese (Simplified)",
        "zh-hant": "Chinese (Traditional)",
        zh: "Chinese", zho: "Chinese", chi: "Chinese"
    };

    function trim(value) {
        return String(value || "").replace(/\s+/g, " ").trim();
    }

    function parseJsonSafe(value, fallback) {
        if (value && typeof value === "object") return value;
        try {
            return JSON.parse(String(value || ""));
        } catch (_) {
            return fallback;
        }
    }

    function encodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof btoa === "function") return btoa(input);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "utf8").toString("base64");
        } catch (_) {}
        return "";
    }

    function decodeBase64String(value) {
        var input = String(value || "");
        try {
            if (typeof atob === "function") return atob(input);
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(input, "base64").toString("utf8");
        } catch (_) {}
        return "";
    }

    function randomUuid() {
        if (typeof crypto !== "undefined" && crypto.randomUUID) return crypto.randomUUID();
        return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function (c) {
            var r = Math.random() * 16 | 0;
            var v = c === "x" ? r : (r & 3 | 8);
            return v.toString(16);
        });
    }

    function selectedProvider() {
        var id = trim(manifest && manifest.providerId).toLowerCase() || "netflix";
        return PROVIDERS[id] || PROVIDERS.netflix;
    }

    function cookieHeader(cookies) {
        var rows = [];
        Object.keys(cookies || {}).forEach(function (key) {
            var value = cookies[key];
            if (typeof value !== "undefined" && value !== null && value !== "") rows.push(key + "=" + value);
        });
        return rows.join("; ");
    }

    function withHeaders(base, extra) {
        var out = Object.assign({}, base || {});
        extra = extra || {};
        Object.keys(extra).forEach(function (key) {
            if (typeof extra[key] !== "undefined") out[key] = extra[key];
        });
        return out;
    }

    function pageCookies(config, token) {
        var cookies = {
            "ott": config.ott,
            "hd": "on"
        };
        if (token) cookies.t_hash_t = token;
        if (config.studio) cookies.studio = config.studio;
        return cookies;
    }

    function pageHeaders(config, token, referer) {
        return withHeaders(PAGE_HEADERS, {
            "Cookie": cookieHeader(pageCookies(config, token)),
            "Referer": referer || (MAIN_URL + "/home")
        });
    }

    function normalizeHeaders(headers) {
        var out = {};
        if (!headers) return out;
        if (typeof headers.forEach === "function") {
            headers.forEach(function (value, key) {
                out[String(key).toLowerCase()] = value;
            });
            return out;
        }
        Object.keys(headers).forEach(function (key) {
            out[String(key).toLowerCase()] = headers[key];
        });
        return out;
    }

    function normalizeResponse(res, url) {
        if (typeof res === "string") return { status: 200, body: res, headers: {}, url: url };
        return {
            status: res && typeof res.status !== "undefined" ? res.status : 200,
            body: String(res && (res.body || res.text || "") || ""),
            headers: normalizeHeaders(res && res.headers),
            url: res && (res.url || res.finalUrl) || url
        };
    }

    async function requestGet(url, headers) {
        if (typeof http_get === "function") return normalizeResponse(await http_get(url, headers || {}), url);
        var res = await fetch(url, { headers: headers || {} });
        var body = await res.text();
        var headersOut = {};
        if (res.headers && res.headers.forEach) {
            res.headers.forEach(function (value, key) { headersOut[key] = value; });
        }
        return { status: res.status, body: body, headers: headersOut, url: res.url || url };
    }

    async function httpParallelGet(requests, fallbackLimit) {
        var items = Array.isArray(requests) ? requests.filter(function (item) { return item && item.url; }) : [];
        if (!items.length) return [];
        if (typeof http_parallel === "function") {
            try {
                var responses = await http_parallel(items.map(function (item) {
                    return {
                        method: "GET",
                        url: item.url,
                        headers: item.headers || {}
                    };
                }));
                return items.map(function (item, index) {
                    return normalizeResponse(responses && responses[index], item.url);
                });
            } catch (_) {}
        }
        return await mapConcurrent(items, fallbackLimit || HOME_TITLE_CONCURRENCY, function (item) {
            return requestGet(item.url, item.headers || {}).catch(function () {
                return { status: 599, body: "", headers: {}, url: item.url };
            });
        });
    }

    async function requestPostForm(url, body, headers) {
        var res;
        if (typeof fetch === "function") {
            try {
                var fetchRes = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body: body || "",
                    redirect: "manual"
                });
                var text = await fetchRes.text().catch(function () { return ""; });
                return {
                    status: fetchRes.status,
                    body: text,
                    headers: normalizeHeaders(fetchRes.headers),
                    url: fetchRes.url || url
                };
            } catch (_) {}
        }
        try {
            res = await http_post(url, headers || {}, body || "");
            if (res && (res.body || res.headers)) return normalizeResponse(res, url);
        } catch (_) {}
        res = await http_post(url, body || "", headers || {});
        return normalizeResponse(res, url);
    }

    async function requestPostFormCandidates(url, body, headers) {
        var out = [];
        if (typeof axios !== "undefined" && axios && typeof axios.post === "function") {
            try {
                var ax = await axios.post(url, body || "", {
                    headers: headers || {},
                    maxRedirects: 0,
                    validateStatus: function () { return true; },
                    responseType: "text"
                });
                out.push({
                    status: ax.status,
                    body: typeof ax.data === "string" ? ax.data : JSON.stringify(ax.data || ""),
                    headers: normalizeHeaders(ax.headers),
                    url: url
                });
            } catch (_) {}
        }
        if (typeof fetch === "function") {
            try {
                var fetchRes = await fetch(url, {
                    method: "POST",
                    headers: headers || {},
                    body: body || "",
                    redirect: "manual"
                });
                out.push({
                    status: fetchRes.status,
                    body: await fetchRes.text().catch(function () { return ""; }),
                    headers: normalizeHeaders(fetchRes.headers),
                    url: fetchRes.url || url
                });
            } catch (_) {}
        }
        if (typeof http_post === "function") {
            try {
                out.push(normalizeResponse(await http_post(url, headers || {}, body || ""), url));
            } catch (_) {}
            try {
                out.push(normalizeResponse(await http_post(url, body || "", headers || {}), url));
            } catch (_) {}
        }
        return out;
    }

    function responseHeader(headers, name) {
        var wanted = String(name || "").toLowerCase();
        headers = headers || {};
        if (headers[wanted]) return headers[wanted];
        var keys = Object.keys(headers);
        for (var i = 0; i < keys.length; i++) {
            if (String(keys[i]).toLowerCase() === wanted) return headers[keys[i]];
        }
        return "";
    }

    function extractCookie(headers, cookieName) {
        var raw = responseHeader(headers, "set-cookie");
        if (Array.isArray(raw)) raw = raw.join("\n");
        var text = String(raw || "");
        var re = new RegExp(cookieName + "=([^;\\n]+)", "i");
        var match = text.match(re);
        return match ? match[1] : "";
    }

    async function bypass() {
        if (cookieCache.value && Date.now() - cookieCache.time < COOKIE_TTL_MS) return cookieCache.value;
        var headers = {
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
            "Accept-Encoding": "gzip, deflate, br, zstd",
            "Accept-Language": "en-US,en;q=0.9",
            "Cache-Control": "max-age=0",
            "Connection": "keep-alive",
            "Content-Type": "application/x-www-form-urlencoded",
            "Origin": "https://net22.cc",
            "Referer": "https://net22.cc/verify2",
            "sec-ch-ua": "\"Google Chrome\";v=\"147\", \"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"147\"",
            "sec-ch-ua-mobile": "?0",
            "sec-ch-ua-platform": "\"Windows\"",
            "Sec-Fetch-Dest": "document",
            "Sec-Fetch-Mode": "navigate",
            "Sec-Fetch-Site": "same-origin",
            "Sec-Fetch-User": "?1",
            "Upgrade-Insecure-Requests": "1",
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36"
        };
        var body = "g-recaptcha-response=" + encodeURIComponent(randomUuid());
        var candidates = await requestPostFormCandidates(MAIN_URL + "/verify.php", body, headers);
        var cookie = "";
        for (var i = 0; i < candidates.length; i++) {
            cookie = extractCookie(candidates[i].headers, "t_hash_t");
            if (cookie) break;
        }
        if (!cookie) throw new Error("CNCVerse bypass failed: missing t_hash_t cookie");
        cookieCache = { value: cookie, time: Date.now() };
        return cookie;
    }

    function unixTime() {
        return Math.floor(Date.now() / 1000);
    }

    function absoluteUrl(base, value) {
        value = String(value || "").trim();
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base).toString();
        } catch (_) {
            return value;
        }
    }

    function streamHost(url) {
        try {
            return new URL(String(url || "")).hostname;
        } catch (_) {
            return "";
        }
    }

    function proxifyUrl(url, headers, referer) {
        var hosts = [];
        var host = streamHost(url);
        if (host) hosts.push(host);
        var payload = {
            url: url,
            headers: headers || {},
            options: {
                referer: referer || "",
                mirrorHosts: hosts
            }
        };
        return "MAGIC_PROXY_v2" + encodeBase64String(JSON.stringify(payload));
    }

    function parseHlsAttributes(line) {
        var attrs = {};
        var regex = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/ig;
        var match;
        while ((match = regex.exec(String(line || ""))) !== null) {
            attrs[String(match[1] || "").toUpperCase()] = String(match[2] || "").replace(/^"|"$/g, "");
        }
        return attrs;
    }

    function quoteHlsAttr(value) {
        return "\"" + String(value || "").replace(/"/g, "\\\"") + "\"";
    }

    function serializeMediaLine(attrs, url) {
        var out = [];
        var keys = ["TYPE", "GROUP-ID", "LANGUAGE", "NAME", "DEFAULT", "AUTOSELECT", "FORCED", "CHANNELS", "CHARACTERISTICS"];
        for (var i = 0; i < keys.length; i++) {
            var key = keys[i];
            if (typeof attrs[key] === "undefined" || attrs[key] === "") continue;
            if (/^(TYPE|DEFAULT|AUTOSELECT|FORCED)$/i.test(key)) {
                out.push(key + "=" + attrs[key]);
            } else {
                out.push(key + "=" + quoteHlsAttr(attrs[key]));
            }
        }
        out.push("URI=" + quoteHlsAttr(url));
        return "#EXT-X-MEDIA:" + out.join(",");
    }

    function qualityFromVariant(attrs) {
        var resolution = String(attrs.RESOLUTION || "");
        var match = resolution.match(/x(\d+)/i);
        if (match) return parseInt(match[1], 10) || 0;
        var bandwidth = parseInt(String(attrs.BANDWIDTH || attrs["AVERAGE-BANDWIDTH"] || "0").replace(/[^0-9]/g, ""), 10) || 0;
        if (bandwidth >= 12000000) return 2160;
        if (bandwidth >= 5000000) return 1080;
        if (bandwidth >= 2500000) return 720;
        if (bandwidth >= 1200000) return 480;
        if (bandwidth) return 360;
        return 0;
    }

    function parseHlsMaster(masterUrl, body) {
        var text = String(body || "");
        if (!/^#EXTM3U/i.test(text) || text.indexOf("#EXT-X-STREAM-INF") === -1) return null;
        var lines = text.split(/\r?\n/);
        var variants = [];
        var media = [];
        var pending = null;
        var seen = {};
        for (var i = 0; i < lines.length; i++) {
            var raw = String(lines[i] || "").trim();
            if (!raw) continue;
            if (raw.indexOf("#EXT-X-MEDIA:") === 0) {
                var mediaAttrs = parseHlsAttributes(raw.slice("#EXT-X-MEDIA:".length));
                if (mediaAttrs.URI) {
                    mediaAttrs.URI = absoluteUrl(masterUrl, mediaAttrs.URI);
                    media.push({ attrs: mediaAttrs });
                }
                continue;
            }
            if (raw.indexOf("#EXT-X-I-FRAME-STREAM-INF:") === 0) {
                pending = null;
                continue;
            }
            if (raw.indexOf("#EXT-X-STREAM-INF:") === 0) {
                pending = {
                    attrs: parseHlsAttributes(raw.slice("#EXT-X-STREAM-INF:".length)),
                    raw: raw
                };
                continue;
            }
            if (raw.charAt(0) === "#") continue;
            if (!pending) continue;
            var variantUrl = absoluteUrl(masterUrl, raw);
            if (variantUrl && !seen[variantUrl]) {
                seen[variantUrl] = true;
                variants.push({
                    url: variantUrl,
                    attrs: pending.attrs,
                    raw: pending.raw,
                    quality: qualityFromVariant(pending.attrs)
                });
            }
            pending = null;
        }
        return variants.length ? { variants: variants, media: media } : null;
    }

    function mediaByGroup(media, type, groupId) {
        var out = [];
        for (var i = 0; i < (media || []).length; i++) {
            var attrs = media[i].attrs || {};
            if (String(attrs.TYPE || "").toUpperCase() === type && String(attrs["GROUP-ID"] || "") === String(groupId || "")) {
                out.push(attrs);
            }
        }
        return out;
    }

    function subtitlesFromMedia(media, groupId, headers, referer) {
        var rows = mediaByGroup(media, "SUBTITLES", groupId);
        var out = [];
        var seen = {};
        for (var i = 0; i < rows.length; i++) {
            var attrs = rows[i];
            var url = attrs.URI;
            if (!url || seen[url]) continue;
            seen[url] = true;
            var langCode = languageCodeFromAttrs(attrs) || "en";
            out.push({
                url: proxifyUrl(url, headers, referer),
                label: trim(attrs.NAME || attrs.LANGUAGE || "Subtitle"),
                lang: langCode
            });
        }
        return out;
    }

    function buildVariantMiniMaster(variant, media, headers, referer, audioTrack) {
        var lines = ["#EXTM3U", "#EXT-X-VERSION:3"];
        var audioGroup = variant.attrs.AUDIO;
        var audios = audioTrack ? [audioTrack] : mediaByGroup(media, "AUDIO", audioGroup);
        for (var i = 0; i < audios.length; i++) {
            var attrs = Object.assign({}, audios[i]);
            attrs.DEFAULT = "YES";
            attrs.AUTOSELECT = "YES";
            lines.push(serializeMediaLine(attrs, attrs.URI));
        }
        lines.push(String(variant.raw || "").replace(/,?SUBTITLES="[^"]*"/i, ""));
        lines.push(variant.url);
        return "magic_m3u8:" + encodeBase64String(lines.join("\n"));
    }

    function createHlsStream(url, source, headers, quality, subtitles, languageCode, languageName) {
        var stream = new StreamResult({
            url: url,
            source: source,
            headers: headers || {},
            quality: quality || 0
        });
        stream.quality = quality || 0;
        stream.type = "hls";
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        if (languageCode) stream.language = languageCode;
        if (languageName) stream.languageName = languageName;
        return stream;
    }

    function buildExpandedHlsStreams(variant, media, source, headers, referer) {
        var quality = variant.quality || 0;
        var audios = variant.attrs.AUDIO ? mediaByGroup(media, "AUDIO", variant.attrs.AUDIO) : [];
        if (!audios.length) {
            var subtitles = variant.attrs.SUBTITLES ? subtitlesFromMedia(media, variant.attrs.SUBTITLES, headers, referer) : [];
            return [createHlsStream(
                variant.url,
                quality ? (source + " [" + quality + "p]") : source,
                headers,
                quality,
                subtitles
            )];
        }
        var out = [];
        var usedLabels = {};
        for (var i = 0; i < audios.length; i++) {
            var audio = audios[i];
            if (!audio.URI) continue;
            var languageName = languageNameFromAttrs(audio);
            var languageCode = languageCodeFromAttrs(audio);
            var labelKey = languageName.toLowerCase();
            usedLabels[labelKey] = (usedLabels[labelKey] || 0) + 1;
            var displayName = usedLabels[labelKey] > 1 ? (languageName + " " + usedLabels[labelKey]) : languageName;
            out.push(createHlsStream(
                buildVariantMiniMaster(variant, media, headers, referer, audio),
                quality ? (source + " " + displayName + " [" + quality + "p]") : (source + " " + displayName),
                headers,
                quality,
                [],
                languageCode,
                displayName
            ));
        }
        return out.length ? out : [createHlsStream(
            buildVariantMiniMaster(variant, media, headers, referer),
            quality ? (source + " [" + quality + "p]") : source,
            headers,
            quality,
            subtitles
        )];
    }

    async function expandNewTvHlsStreams(masterUrl, source, headers, referer) {
        try {
            var res = await requestGet(masterUrl, headers);
            var parsed = parseHlsMaster(masterUrl, res.body);
            if (!parsed) return [];
            var streams = [];
            parsed.variants.forEach(function (variant) {
                streams.push.apply(streams, buildExpandedHlsStreams(variant, parsed.media, source, headers, referer));
            });
            return streams.sort(function (a, b) {
                var q = Number(b.quality || 0) - Number(a.quality || 0);
                if (q) return q;
                return String(a.source || "").localeCompare(String(b.source || ""));
            });
        } catch (_) {
            return [];
        }
    }

    function maxStreamQuality(streams) {
        var max = 0;
        for (var i = 0; i < (streams || []).length; i++) {
            max = Math.max(max, Number(streams[i] && streams[i].quality || 0) || 0);
        }
        return max;
    }

    function numberFrom(value) {
        var n = parseInt(String(value || "").replace(/[^0-9]/g, ""), 10);
        return isNaN(n) ? undefined : n;
    }

    function runtimeToMinutes(runtime) {
        var total = 0;
        String(runtime || "").split(/\s+/).forEach(function (part) {
            var hours = part.match(/^(\d+)h$/i);
            var minutes = part.match(/^(\d+)m$/i);
            if (hours) total += parseInt(hours[1], 10) * 60;
            if (minutes) total += parseInt(minutes[1], 10);
        });
        return total || undefined;
    }

    function payload(data) {
        return JSON.stringify(data || {});
    }

    function parsePayload(url) {
        var parsed = parseJsonSafe(url, null);
        if (parsed) return parsed;
        return { id: String(url || "") };
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&#(\d+);/g, function (_, n) { return String.fromCodePoint(parseInt(n, 10)); })
            .replace(/&#x([0-9a-f]+);/gi, function (_, n) { return String.fromCodePoint(parseInt(n, 16)); })
            .replace(/&nbsp;/gi, " ")
            .replace(/&amp;/gi, "&")
            .replace(/&quot;/gi, "\"")
            .replace(/&#39;|&apos;/gi, "'")
            .replace(/&lt;/gi, "<")
            .replace(/&gt;/gi, ">")
            .replace(/\s+/g, " ")
            .trim();
    }

    function normalizeLanguageCode(value) {
        var code = String(value || "").toLowerCase().trim();
        code = code.replace(/_/g, "-").replace(/\.\[cc\]|\[cc\]/g, "");
        code = code.replace(/[^a-z0-9-]/g, "");
        if (code === "ger") return "de";
        if (code === "eng") return "en";
        if (code === "deu") return "de";
        if (code === "ara") return "ar";
        if (code === "ben") return "bn";
        if (code === "ces" || code === "cze") return "cs";
        if (code === "dan") return "da";
        if (code === "ell") return "el";
        if (code === "fre") return "fr";
        if (code === "fra") return "fr";
        if (code === "gre") return "el";
        if (code === "guj") return "gu";
        if (code === "heb") return "he";
        if (code === "hin") return "hi";
        if (code === "hrv") return "hr";
        if (code === "hun") return "hu";
        if (code === "ind") return "id";
        if (code === "ita") return "it";
        if (code === "jpn") return "ja";
        if (code === "kan") return "kn";
        if (code === "kor") return "ko";
        if (code === "mal") return "ml";
        if (code === "mar") return "mr";
        if (code === "may") return "ms";
        if (code === "msa") return "ms";
        if (code === "nob" || code === "nor") return "nb";
        if (code === "dut") return "nl";
        if (code === "nld") return "nl";
        if (code === "pan") return "pa";
        if (code === "pol") return "pl";
        if (code === "por") return "pt";
        if (code === "ron") return "ro";
        if (code === "rum") return "ro";
        if (code === "rus") return "ru";
        if (code === "spa") return "es";
        if (code === "swe") return "sv";
        if (code === "tam") return "ta";
        if (code === "tel") return "te";
        if (code === "tha") return "th";
        if (code === "tur") return "tr";
        if (code === "urd") return "ur";
        if (code === "vie") return "vi";
        if (code === "chi") return "zh";
        if (code === "zho") return "zh";
        return code;
    }

    function languageNameFromAttrs(attrs) {
        attrs = attrs || {};
        var code = normalizeLanguageCode(attrs.LANGUAGE);
        var cleanName = trim(String(attrs.NAME || "").replace(/^\d+\.\s*/, "").replace(/\s*\[cc\]\s*/ig, ""));
        var fromCode = LANGUAGE_NAMES[code] || LANGUAGE_NAMES[code.split("-")[0]];
        if (fromCode) return fromCode;
        if (cleanName && !/^\d+$/i.test(cleanName)) return cleanName;
        return code ? code.toUpperCase() : "Audio";
    }

    function languageCodeFromAttrs(attrs) {
        attrs = attrs || {};
        var code = normalizeLanguageCode(attrs.LANGUAGE);
        if (code) return code;
        var name = trim(String(attrs.NAME || "").replace(/^\d+\.\s*/, "")).toLowerCase();
        var keys = Object.keys(LANGUAGE_NAMES);
        for (var i = 0; i < keys.length; i++) {
            if (LANGUAGE_NAMES[keys[i]].toLowerCase() === name) return normalizeLanguageCode(keys[i]);
        }
        return "";
    }

    function nodeText(node) {
        return decodeHtml(node && node.textContent || "");
    }

    function attr(node) {
        if (!node || !node.getAttribute) return "";
        for (var i = 1; i < arguments.length; i++) {
            var value = node.getAttribute(arguments[i]);
            if (value) return String(value).trim();
        }
        return "";
    }

    function qsa(root, selector) {
        try {
            return Array.from(root && root.querySelectorAll ? root.querySelectorAll(selector) : []);
        } catch (_) {
            return [];
        }
    }

    function qs(root, selector) {
        try {
            return root && root.querySelector ? root.querySelector(selector) : null;
        } catch (_) {
            return null;
        }
    }

    async function parseDocument(html) {
        return await parseHtml(String(html || "").replace(/<style\b[^>]*>[\s\S]*?<\/style>/gi, ""));
    }

    function buildItem(config, id, title, type, posterUrl) {
        var cleanTitle = trim(title);
        if (/<img\b/i.test(cleanTitle)) {
            var alt = cleanTitle.match(/alt=["']([^"']+)["']/i);
            cleanTitle = alt ? decodeHtml(alt[1]) : "";
        }
        return new MultimediaItem({
            title: cleanTitle || config.name,
            url: payload({ providerId: config.id, id: String(id || ""), title: cleanTitle || "" }),
            posterUrl: posterUrl || config.poster(id),
            type: type || "series"
        });
    }

    function mapHomeCard(config, node) {
        var link = qs(node, "a");
        var id = attr(link, "data-post") || attr(node, "data-post");
        if (!id) return null;
        var image = qs(node, ".card-img-container img, .top10-img img, img");
        var title = attr(image, "alt", "title") || attr(link, "title", "aria-label") || nodeText(qs(node, ".title, h3, h4, p")) || "";
        return buildItem(config, id, title, "series", config.poster(id));
    }

    function mapSearchResult(config, row) {
        if (!row || !row.id) return null;
        return buildItem(config, row.id, row.t, "series", config.poster(row.id));
    }

    function buildActor(name) {
        return new Actor({ name: trim(name) });
    }

    function buildEpisode(config, title, episode) {
        return new Episode({
            name: trim(episode && episode.t) || title,
            url: payload({ providerId: config.id, id: episode && episode.id, title: title }),
            season: numberFrom(episode && episode.s) || 1,
            episode: numberFrom(episode && episode.ep) || 1,
            runtime: numberFrom(episode && episode.time),
            posterUrl: config.episodePoster(episode && episode.id)
        });
    }

    async function fetchEpisodes(config, token, title, seriesId, seasonId, page) {
        var episodes = [];
        var pg = page || 1;
        while (true) {
            var url = MAIN_URL + "/mobile" + config.prefix + "/episodes.php?s=" + encodeURIComponent(seasonId) + "&series=" + encodeURIComponent(seriesId) + "&t=" + unixTime() + "&page=" + pg;
            var res = await requestGet(url, pageHeaders(config, token, MAIN_URL + "/home"));
            var json = parseJsonSafe(res.body, {});
            (json.episodes || []).forEach(function (row) {
                if (row && row.id) episodes.push(buildEpisode(config, title, row));
            });
            if (Number(json.nextPageShow || 0) === 0) break;
            pg++;
        }
        return episodes;
    }

    async function mapConcurrent(items, limit, fn) {
        var out = new Array(items.length);
        var index = 0;
        async function worker() {
            while (index < items.length) {
                var i = index++;
                out[i] = await fn(items[i], i).catch(function () { return null; });
            }
        }
        var workers = [];
        var count = Math.min(limit || 4, items.length);
        for (var i = 0; i < count; i++) workers.push(worker());
        await Promise.all(workers);
        return out;
    }

    async function hydrateHomeTitles(config, token, sections) {
        var items = [];
        var rowsById = {};
        Object.keys(sections || {}).forEach(function (section) {
            (sections[section] || []).forEach(function (item) {
                if (!item || !item.url || item.title !== config.name) return;
                var row = parsePayload(item.url);
                if (row && row.id) {
                    var id = String(row.id);
                    var entry = { item: item, id: id };
                    items.push(entry);
                    if (!rowsById[id]) rowsById[id] = [];
                    rowsById[id].push(entry);
                }
            });
        });
        var requests = [];
        Object.keys(rowsById).forEach(function (id) {
            var key = config.id + ":" + id;
            if (Object.prototype.hasOwnProperty.call(titleCache, key)) return;
            requests.push({
                id: id,
                key: key,
                url: MAIN_URL + "/mobile" + config.prefix + "/post.php?id=" + encodeURIComponent(id) + "&t=" + unixTime(),
                headers: pageHeaders(config, token, MAIN_URL + "/home")
            });
        });
        var responses = await httpParallelGet(requests, HOME_TITLE_CONCURRENCY);
        requests.forEach(function (req, index) {
            var json = parseJsonSafe(responses[index] && responses[index].body, {});
            titleCache[req.key] = trim(json.title);
        });
        items.forEach(function (row) {
            var title = titleCache[config.id + ":" + row.id] || "";
            if (title) {
                row.item.title = title;
                row.item.url = payload({ providerId: config.id, id: String(row.id), title: title });
            }
        });
    }

    function buildNewTvHeaders(ott, extra) {
        return withHeaders(NEWTV_BASE_HEADERS, withHeaders({ "Ott": ott }, extra || {}));
    }

    async function resolveApiUrl() {
        if (resolvedApiUrl) return resolvedApiUrl;
        for (var i = 0; i < NEWTV_DOMAINS.length; i++) {
            var base = decodeBase64String(NEWTV_DOMAINS[i]).replace(/\/+$/, "");
            if (!base) continue;
            try {
                var res = await requestGet(base + "/checknewtv.php", NEWTV_BASE_HEADERS);
                var json = parseJsonSafe(res.body, {});
                if (json && json.token_hash) {
                    resolvedApiUrl = decodeBase64String(json.token_hash).replace(/\/+$/, "");
                    if (resolvedApiUrl) return resolvedApiUrl;
                }
            } catch (_) {}
        }
        throw new Error("Failed to resolve NewTV API base URL");
    }

    function buildDirectHlsStream(url, source, quality, headers) {
        var stream = new StreamResult({
            url: url,
            source: source,
            headers: headers || {}
        });
        stream.quality = quality || 0;
        stream.type = "hls";
        return stream;
    }

    async function getHome(cb) {
        try {
            var config = selectedProvider();
            var cached = homeCache[config.id];
            if (cached && Date.now() - cached.time < HOME_CACHE_TTL_MS) {
                return cb({ success: true, data: cached.data });
            }
            var token = await bypass();
            var url = MAIN_URL + "/mobile/home?app=1";
            var res = await requestGet(url, pageHeaders(config, token, url));
            var doc = await parseDocument(res.body);
            var sections = {};
            qsa(doc, ".tray-container, #top10").forEach(function (section) {
                var title = nodeText(qs(section, "h2, span")) || "Home";
                var items = qsa(section, "article, .top10-post").map(function (node) {
                    return mapHomeCard(config, node);
                }).filter(Boolean);
                if (items.length) sections[title] = items;
            });
            await hydrateHomeTitles(config, token, sections);
            homeCache[config.id] = { time: Date.now(), data: sections };
            cb({ success: true, data: sections });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_HOME_FAILED", message: String(e && e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var config = selectedProvider();
            if (!config.search) return cb({ success: true, data: [] });
            var token = await bypass();
            var url = MAIN_URL + "/mobile" + config.prefix + "/search.php?s=" + encodeURIComponent(query || "") + "&t=" + unixTime();
            var res = await requestGet(url, pageHeaders(config, token, MAIN_URL + "/home"));
            var json = parseJsonSafe(res.body, {});
            var items = (json.searchResult || []).map(function (row) {
                return mapSearchResult(config, row);
            }).filter(Boolean);
            cb({ success: true, data: items });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_SEARCH_FAILED", message: String(e && e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var input = parsePayload(url);
            var config = PROVIDERS[String(input.providerId || "").toLowerCase()] || selectedProvider();
            var id = String(input.id || "");
            var token = await bypass();
            var detailUrl = MAIN_URL + "/mobile" + config.prefix + "/post.php?id=" + encodeURIComponent(id) + "&t=" + unixTime();
            var res = await requestGet(detailUrl, pageHeaders(config, token, MAIN_URL + "/home"));
            var data = parseJsonSafe(res.body, {});
            var title = trim(data.title || input.title || config.name);
            var rawEpisodes = data.episodes || [];
            var isMovie = !rawEpisodes.length || rawEpisodes[0] == null;
            var episodes = [];

            if (isMovie) {
                episodes.push(new Episode({
                    name: title,
                    url: payload({ providerId: config.id, id: id, title: title }),
                    season: 1,
                    episode: 1
                }));
            } else {
                rawEpisodes.filter(Boolean).forEach(function (row) {
                    episodes.push(new Episode(Object.assign({}, buildEpisode(config, title, row), {
                        posterUrl: config.initialEpisodePoster(row.id)
                    })));
                });

                var tasks = [];
                if (Number(data.nextPageShow || 0) === 1 && data.nextPageSeason) {
                    tasks.push({ seasonId: data.nextPageSeason, page: 2 });
                }
                (data.season || []).slice(0, Math.max(0, (data.season || []).length - 1)).forEach(function (season) {
                    if (season && season.id) tasks.push({ seasonId: season.id, page: 1 });
                });
                var extra = await mapConcurrent(tasks, 4, function (task) {
                    return fetchEpisodes(config, token, title, id, task.seasonId, task.page);
                });
                extra.forEach(function (rows) {
                    (rows || []).forEach(function (ep) { episodes.push(ep); });
                });
            }

            var genres = String(data.genre || "").split(",").map(trim).filter(Boolean);
            var cast = String(data.cast || "").split(",").map(trim).filter(Boolean).slice(0, 30).map(buildActor);
            var recommendations = (data.suggest || []).map(function (row) {
                return row && row.id ? buildItem(config, row.id, "", "series", config.suggestPoster(row.id)) : null;
            }).filter(Boolean);

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title,
                    url: payload({ providerId: config.id, id: id, title: title }),
                    posterUrl: config.poster(id),
                    bannerUrl: config.background(id),
                    type: isMovie ? "movie" : "series",
                    description: trim(data.desc),
                    year: numberFrom(data.year),
                    score: parseFloat(String(data.match || "").replace(/IMDb/i, "").trim()) || undefined,
                    duration: runtimeToMinutes(data.runtime),
                    contentRating: trim(data.ua) || undefined,
                    cast: cast,
                    tags: genres,
                    recommendations: recommendations,
                    episodes: episodes
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_LOAD_FAILED", message: String(e && e.message || e) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            var input = parsePayload(url);
            var config = PROVIDERS[String(input.providerId || "").toLowerCase()] || selectedProvider();
            var id = String(input.id || "");
            var apiBase = await resolveApiUrl();
            var res = await requestGet(apiBase + "/newtv/player.php?id=" + encodeURIComponent(id), buildNewTvHeaders(config.playerOtt, { "Usertoken": "" }));
            var json = parseJsonSafe(res.body, {});
            if (json.status !== "ok" || !json.video_link) return cb({ success: true, data: [] });
            var referer = json.referer || apiBase;
            var streamHeaders = {
                "User-Agent": NEWTV_USER_AGENT,
                "Accept": "*/*",
                "Referer": referer,
                "Cookie": "hd=on"
            };
            var streams = await expandNewTvHlsStreams(json.video_link, config.name, streamHeaders, referer);
            var maxQuality = maxStreamQuality(streams);
            var adaptiveLabel = maxQuality ? (config.name + " Auto [" + maxQuality + "p]") : (config.name + " Auto");
            cb({ success: true, data: [
                buildDirectHlsStream(json.video_link, adaptiveLabel, maxQuality, streamHeaders)
            ].concat(streams) });
        } catch (e) {
            cb({ success: false, errorCode: "CNCVERSE_STREAMS_FAILED", message: String(e && e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
