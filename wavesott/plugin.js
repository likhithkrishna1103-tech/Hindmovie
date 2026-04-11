(function() {
    const DEFAULT_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0",
        "Accept": "*/*",
        "Accept-Language": "en-US,en;q=0.5",
        "Connection": "keep-alive"
    };
    const FIREBASE_CONFIG = {
        packageName: "com.cricfy.tv",
        apiKey: "AIzaSyAh9jkEU0E_UYxH0m_BKAt-uUSTiTPqhb8",
        appId: "1:963020218535:android:47ec53252c64fb3c9c7b82",
        projectNumber: "963020218535",
        sdkVersion: "22.1.0",
        appVersion: "5.0",
        appBuild: "50"
    };
    const DEFAULT_BASE_URLS = [
        "https://cfykjgvjjjvn106.top",
        "https://indsp1.site",
        "https://cfymarkscanjiostar80.top",
        "https://cfyhljddgbkkufh82.top",
        "https://cfynewihgf1.top",
        "https://cfyshgdkuytv15.top",
        "https://cfykshdbdkidv75.top",
        "https://cfyksgsksnbslv67.top"
    ];
    const PROVIDER_KEYS = [
        { key: "M2hIenhZQWdTR0k4L2hhbQ==", iv: "VXFDdmt2amVjRUl6ODQyVg==" },
        { key: "TXFlWUdDVDRBWUtvSEtyVA==", iv: "b0hLclRRdVB4OHpsOG9KKw==" }
    ];
    const PROVIDER_TITLE_FALLBACKS = {
        sonyin: ["sonyin2", "sonyliv", "sonybd"],
        zee5: ["zee5live", "zee5in", "zee5in2"],
        jioind: ["jioind2", "jiotv", "jiotvs2", "jiotvs3", "jiotvs4", "jioliveind"],
        vootind: ["jiocinemaind"],
        dishhomebd: ["dishtv"],
        fancodebd: ["fancodebd2", "fancodeind"]
    };

    let activeCatalogBaseUrl = null;
    let remoteBaseUrlsPromise = null;
    let providerCatalogPromise = null;

    function trimToString(value) {
        return typeof value === "string" ? value.trim() : "";
    }

    function normalizeBaseUrl(value) {
        const normalized = trimToString(value).replace(/\/+$/, "");
        if (!normalized || /example\.com/i.test(normalized)) return "";
        return normalized;
    }

    function normalizeProviderTitle(value) {
        return trimToString(value).toLowerCase().replace(/[^a-z0-9]/g, "");
    }

    function safeDecode(value) {
        try {
            return decodeURIComponent(value);
        } catch (_) {
            return value;
        }
    }

    function safeParseJson(value) {
        try {
            return JSON.parse(value);
        } catch (_) {
            return null;
        }
    }

    function getResponseStatus(response) {
        if (!response || typeof response !== "object") return 200;
        if (typeof response.status !== "undefined") return response.status;
        if (typeof response.statusCode !== "undefined") return response.statusCode;
        return 200;
    }

    function extractResponseBody(response) {
        if (typeof response === "string") return response;
        if (response && typeof response.body === "string") return response.body;
        return "";
    }

    function createAppInstanceId() {
        let value = "";
        while (value.length < 32) {
            value += Math.random().toString(16).slice(2);
        }
        return value.slice(0, 32);
    }

    async function postJson(url, payload, headers) {
        const body = JSON.stringify(payload);
        if (typeof http_post === "function") {
            return http_post(url, body, headers);
        }
        if (typeof fetch === "function") {
            const response = await fetch(url, {
                method: "POST",
                headers,
                body
            });
            return {
                status: response.status,
                body: await response.text()
            };
        }
        throw new Error("POST requests are not supported in this runtime");
    }

    async function fetchRemoteBaseUrls() {
        if (remoteBaseUrlsPromise) return remoteBaseUrlsPromise;

        remoteBaseUrlsPromise = (async function() {
            const endpoint = "https://firebaseremoteconfig.googleapis.com/v1/projects/" +
                FIREBASE_CONFIG.projectNumber +
                "/namespaces/firebase:fetch";
            const payload = {
                appInstanceId: createAppInstanceId(),
                appInstanceIdToken: "",
                appId: FIREBASE_CONFIG.appId,
                countryCode: "US",
                languageCode: "en-US",
                platformVersion: "30",
                timeZone: "UTC",
                appVersion: FIREBASE_CONFIG.appVersion,
                appBuild: FIREBASE_CONFIG.appBuild,
                packageName: FIREBASE_CONFIG.packageName,
                sdkVersion: FIREBASE_CONFIG.sdkVersion,
                analyticsUserProperties: {}
            };
            const headers = {
                "Content-Type": "application/json",
                "Accept": "application/json",
                "X-Android-Package": FIREBASE_CONFIG.packageName,
                "X-Goog-Api-Key": FIREBASE_CONFIG.apiKey,
                "X-Google-GFE-Can-Retry": "yes",
                "User-Agent": "okhttp/4.12.0"
            };

            try {
                const response = await postJson(endpoint, payload, headers);
                if (getResponseStatus(response) >= 400) return [];

                const data = safeParseJson(trimToString(extractResponseBody(response)));
                const entries = data && typeof data.entries === "object" ? data.entries : {};
                const urls = [];

                function addUrl(value) {
                    const normalized = normalizeBaseUrl(value);
                    if (normalized && urls.indexOf(normalized) === -1) {
                        urls.push(normalized);
                    }
                }

                addUrl(entries.cric_api2);
                addUrl(entries.cric_api1);
                return urls;
            } catch (_) {
                return [];
            }
        })();

        return remoteBaseUrlsPromise;
    }

    async function getCatalogBaseUrls() {
        const urls = [];

        function addUrl(value) {
            const normalized = normalizeBaseUrl(value);
            if (normalized && urls.indexOf(normalized) === -1) {
                urls.push(normalized);
            }
        }

        addUrl(activeCatalogBaseUrl);
        (await fetchRemoteBaseUrls()).forEach(addUrl);
        DEFAULT_BASE_URLS.forEach(addUrl);
        return urls;
    }

    function isPlaylistResponse(body) {
        const text = trimToString(body);
        return text.startsWith("#EXTM3U") || text.startsWith("#EXTINF") || text.startsWith("#KODIPROP");
    }

    function extractPlaylistText(body) {
        const text = trimToString(body);
        if (!text) return "";
        if (isPlaylistResponse(text)) return text;

        const extM3UIndex = text.indexOf("#EXTM3U");
        const extInfIndex = text.indexOf("#EXTINF");
        const kodiIndex = text.indexOf("#KODIPROP");
        const indexes = [extM3UIndex, extInfIndex, kodiIndex].filter((index) => index >= 0);

        if (!indexes.length) return "";
        return text.slice(Math.min.apply(null, indexes)).trim();
    }

    async function fetchEncryptedJson(url) {
        const response = await http_get(url, {
            "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)",
            "Host": url.split("//")[1].split("/")[0]
        });
        const body = trimToString(extractResponseBody(response));
        if (!body) return null;

        const directData = safeParseJson(body);
        if (directData) return directData;

        const compactBody = body.replace(/\s+/g, "");
        if (!compactBody) return null;

        for (let index = 0; index < PROVIDER_KEYS.length; index++) {
            const keyInfo = PROVIDER_KEYS[index];
            try {
                const decrypted = await crypto.decryptAES(compactBody, keyInfo.key, keyInfo.iv);
                const parsed = safeParseJson(trimToString(decrypted));
                if (parsed) return parsed;
            } catch (_) {
                // Try the next key.
            }
        }

        return null;
    }

    async function fetchProviderCatalog() {
        if (providerCatalogPromise) return providerCatalogPromise;

        providerCatalogPromise = (async function() {
            const baseUrls = await getCatalogBaseUrls();
            for (let index = 0; index < baseUrls.length; index++) {
                const baseUrl = baseUrls[index];
                try {
                    const data = await fetchEncryptedJson(baseUrl + "/cats.txt");
                    if (Array.isArray(data) && data.length) {
                        activeCatalogBaseUrl = baseUrl;
                        return data;
                    }
                } catch (_) {
                    // Try the next catalog host.
                }
            }
            return null;
        })();

        return providerCatalogPromise;
    }

    async function buildPlaylistCandidates() {
        const candidates = [];

        function addCandidate(value) {
            const normalized = trimToString(value);
            if (normalized && normalized !== "https://example.com" && candidates.indexOf(normalized) === -1) {
                candidates.push(normalized);
            }
        }

        const providerTitle = normalizeProviderTitle(manifest && manifest.name);
        if (providerTitle) {
            const catalog = await fetchProviderCatalog();
            if (Array.isArray(catalog)) {
                const catalogByTitle = {};
                for (let index = 0; index < catalog.length; index++) {
                    const provider = catalog[index];
                    const normalizedTitle = normalizeProviderTitle(provider && provider.title);
                    if (!normalizedTitle) continue;
                    if (!catalogByTitle[normalizedTitle]) {
                        catalogByTitle[normalizedTitle] = provider;
                    }
                }

                addCandidate(catalogByTitle[providerTitle] && catalogByTitle[providerTitle].catLink);

                const fallbackTitles = PROVIDER_TITLE_FALLBACKS[providerTitle] || [];
                for (let index = 0; index < fallbackTitles.length; index++) {
                    const fallbackTitle = fallbackTitles[index];
                    addCandidate(catalogByTitle[fallbackTitle] && catalogByTitle[fallbackTitle].catLink);
                }
            }
        }

        addCandidate(manifest && manifest.baseUrl);
        return candidates;
    }

    function looksLikeEncryptedPlaylist(text) {
        const compact = trimToString(text).replace(/\s+/g, "");
        return compact.length >= 79 && /^[A-Za-z0-9+/=]+$/.test(compact);
    }

    async function decryptContent(content) {
        const text = trimToString(content);
        if (!text || isPlaylistResponse(text) || !crypto || typeof crypto.decryptAES !== "function") {
            return text;
        }
        if (!looksLikeEncryptedPlaylist(text)) return text;

        try {
            const encryptedData = text.slice(0, 10) + text.slice(34, text.length - 54) + text.slice(text.length - 10);
            const ivBase64 = text.slice(10, 34);
            const keyBase64 = text.slice(text.length - 54, text.length - 10);
            const decrypted = await crypto.decryptAES(encryptedData, keyBase64, ivBase64);
            return trimToString(decrypted) || text;
        } catch (_) {
            return text;
        }
    }

    async function fetchPlaylist() {
        const failures = [];
        const candidates = await buildPlaylistCandidates();
        if (!candidates.length) {
            throw new Error("No playlist URL configured");
        }

        for (let index = 0; index < candidates.length; index++) {
            const url = candidates[index];
            try {
                const response = await http_get(url, DEFAULT_HEADERS);
                const status = getResponseStatus(response);
                const rawBody = response && typeof response.body === "string" ? response.body : "";
                const directPlaylist = extractPlaylistText(rawBody);
                if (status >= 200 && status < 300 && directPlaylist) {
                    return directPlaylist;
                }

                const decryptedBody = await decryptContent(rawBody);
                const decryptedPlaylist = extractPlaylistText(decryptedBody);
                if (status >= 200 && status < 300 && decryptedPlaylist) {
                    return decryptedPlaylist;
                }

                const previewSource = decryptedBody || rawBody || "";
                const preview = trimToString(previewSource).slice(0, 120).replace(/\s+/g, " ") || "empty response body";
                failures.push(`${url} -> ${status} (${preview})`);
            } catch (error) {
                failures.push(`${url} -> ${error && error.message ? error.message : String(error)}`);
            }
        }

        throw new Error(`Unable to fetch playlist. ${failures.join(" | ")}`);
    }

    function splitExtInfLine(line) {
        const payload = line.replace(/^#EXTINF:[^ ]+/, "").trim();
        let lastCommaIndex = -1;
        let insideQuotes = false;

        for (let index = 0; index < payload.length; index++) {
            const char = payload[index];
            if (char === "\"") {
                insideQuotes = !insideQuotes;
            } else if (char === "," && !insideQuotes) {
                lastCommaIndex = index;
            }
        }

        if (lastCommaIndex === -1) {
            return {
                attributesPart: payload,
                title: payload.replace(/^,/, "").trim() || "Unknown Channel"
            };
        }

        return {
            attributesPart: payload.slice(0, lastCommaIndex).trim(),
            title: payload.slice(lastCommaIndex + 1).trim() || "Unknown Channel"
        };
    }

    function extractAttributes(attributesPart) {
        const attributes = {};
        const regex = /(\w[-\w]*)\s*=\s*(?:"([^"]*)"|([^\s,]+))/gi;
        let match;

        while ((match = regex.exec(attributesPart)) !== null) {
            const key = match[1];
            const value = trimToString(match[2] || match[3] || "");
            if (key) attributes[key] = value;
        }

        return attributes;
    }

    function parseExtHttpLine(line) {
        return safeParseJson(line.replace(/^#EXTHTTP:/, "").trim());
    }

    function isHexString(value) {
        return /^[0-9a-f]+$/i.test(value) && value.length % 2 === 0;
    }

    function base64UrlToHexOrNull(value) {
        if (typeof atob !== "function") return null;
        try {
            const normalized = String(value || "").trim().replace(/-/g, "+").replace(/_/g, "/");
            if (!normalized) return null;
            const padding = normalized.length % 4 === 0 ? "" : "=".repeat(4 - (normalized.length % 4));
            const decoded = atob(normalized + padding);
            let hex = "";
            for (let index = 0; index < decoded.length; index++) {
                hex += decoded.charCodeAt(index).toString(16).padStart(2, "0");
            }
            return hex || null;
        } catch (_) {
            return null;
        }
    }

    function normalizeDrmValue(value) {
        const text = trimToString(value).replace(/-/g, "");
        if (!text || /^null$/i.test(text)) return "";
        if (isHexString(text)) return text.toLowerCase();
        const base64Hex = base64UrlToHexOrNull(text);
        return base64Hex || text;
    }

    function parseLicenseKeyPayload(licenseValue) {
        const normalizedLicense = trimToString(licenseValue);
        const result = { key: "", keyid: "", drmKeys: {}, licenseUrl: "" };
        if (!normalizedLicense) return result;

        if (/^https?:\/\//i.test(normalizedLicense)) {
            result.licenseUrl = normalizedLicense;
            return result;
        }

        if (normalizedLicense.startsWith("{")) {
            const parsed = safeParseJson(normalizedLicense);
            const keys = parsed && Array.isArray(parsed.keys) ? parsed.keys : [];
            for (let index = 0; index < keys.length; index++) {
                const entry = keys[index];
                if (!entry || typeof entry !== "object") continue;
                const keyid = normalizeDrmValue(entry.kid);
                const key = normalizeDrmValue(entry.k);
                if (keyid && key) {
                    result.drmKeys[keyid] = key;
                    if (!result.keyid) result.keyid = keyid;
                    if (!result.key) result.key = key;
                }
            }
            return result;
        }

        const separator = normalizedLicense.includes(":") ? ":" : (normalizedLicense.includes(",") ? "," : "");
        if (!separator) return result;
        const parts = normalizedLicense.split(separator, 2);
        result.keyid = normalizeDrmValue(parts[0]);
        result.key = normalizeDrmValue(parts[1]);
        return result;
    }

    function parsePipeSuffix(suffix) {
        const data = {
            headers: {},
            userAgent: "",
            cookie: "",
            key: "",
            keyid: "",
            licenseUrl: "",
            licenseType: ""
        };
        if (!suffix) return data;

        const pairs = String(suffix).split("&");
        for (let index = 0; index < pairs.length; index++) {
            const pair = pairs[index];
            const equalsIndex = pair.indexOf("=");
            if (equalsIndex === -1) continue;

            const rawKey = safeDecode(pair.slice(0, equalsIndex).trim());
            const rawValue = safeDecode(pair.slice(equalsIndex + 1).trim());
            const key = rawKey.toLowerCase();
            const value = trimToString(rawValue);

            if (!rawKey || !value) continue;

            if (key === "user-agent") {
                data.headers["User-Agent"] = value;
                data.userAgent = value;
            } else if (key === "cookie") {
                data.headers["Cookie"] = value;
                data.cookie = value;
            } else if (key === "referer" || key === "referrer") {
                data.headers["Referer"] = value;
            } else if (key === "origin") {
                data.headers["Origin"] = value;
            } else if (key === "key" || key === "drm-key") {
                data.key = normalizeDrmValue(value);
            } else if (key === "keyid" || key === "kid" || key === "drm-keyid") {
                data.keyid = normalizeDrmValue(value);
            } else if (key === "licenseurl" || key === "drmlicense" || key === "drmlicenseurl") {
                data.licenseUrl = value;
            } else if (key === "drmscheme" || key === "license_type") {
                data.licenseType = value.toLowerCase();
            } else {
                data.headers[rawKey] = value;
            }
        }

        return data;
    }

    function parseStreamLine(line) {
        const separatorIndex = line.indexOf("|");
        const urlPart = separatorIndex === -1 ? line : line.slice(0, separatorIndex);
        const suffix = separatorIndex === -1 ? "" : line.slice(separatorIndex + 1);
        const pipeData = parsePipeSuffix(suffix);

        return {
            url: trimToString(urlPart),
            headers: pipeData.headers,
            userAgent: pipeData.userAgent,
            cookie: pipeData.cookie,
            key: pipeData.key,
            keyid: pipeData.keyid,
            licenseUrl: pipeData.licenseUrl,
            licenseType: pipeData.licenseType
        };
    }

    function isPlayableUrl(url) {
        return /^[a-z][a-z0-9+.-]*:\/\//i.test(trimToString(url));
    }

    function ensurePosterUrl(title, poster) {
        const cleanPoster = trimToString(poster);
        if (cleanPoster && !cleanPoster.includes("placehold.co")) return cleanPoster;
        return `https://placehold.co/400x600.png?text=${encodeURIComponent(trimToString(title) || "Channel")}`;
    }

    function buildCategoryOutput(items) {
        const categories = {};
        for (let index = 0; index < items.length; index++) {
            const item = items[index];
            const group = trimToString(item.group) || "Other Channels";
            if (!categories[group]) categories[group] = [];
            categories[group].push(item.multimedia);
        }
        return categories;
    }

    function parseM3U(m3uString) {
        const lines = String(m3uString || "").split(/\r?\n/);
        const parsedItems = [];

        let bufferedTitle = "";
        let bufferedAttributes = {};
        let bufferedHeaders = {};
        let bufferedUserAgent = "";
        let bufferedCookie = "";
        let bufferedKey = "";
        let bufferedKeyid = "";
        let bufferedLicenseUrl = "";
        let bufferedLicenseType = "";
        let bufferedDrmKeys = {};

        function resetBuffers() {
            bufferedTitle = "";
            bufferedAttributes = {};
            bufferedHeaders = {};
            bufferedUserAgent = "";
            bufferedCookie = "";
            bufferedKey = "";
            bufferedKeyid = "";
            bufferedLicenseUrl = "";
            bufferedLicenseType = "";
            bufferedDrmKeys = {};
        }

        for (let index = 0; index < lines.length; index++) {
            const line = trimToString(lines[index]);
            if (!line) continue;

            if (line.startsWith("#EXTINF")) {
                const extInfParts = splitExtInfLine(line);
                bufferedTitle = extInfParts.title;
                bufferedAttributes = extractAttributes(extInfParts.attributesPart);
                if (!bufferedKey) bufferedKey = normalizeDrmValue(bufferedAttributes.key || bufferedAttributes["drm-key"] || "");
                if (!bufferedKeyid) bufferedKeyid = normalizeDrmValue(bufferedAttributes.keyid || bufferedAttributes.kid || bufferedAttributes["drm-keyid"] || "");
                continue;
            }

            if (line.startsWith("#EXTHTTP:")) {
                const extHttp = parseExtHttpLine(line);
                if (extHttp && typeof extHttp === "object") {
                    if (trimToString(extHttp.cookie)) bufferedCookie = trimToString(extHttp.cookie);
                    if (trimToString(extHttp["user-agent"])) bufferedUserAgent = trimToString(extHttp["user-agent"]);
                }
                continue;
            }

            if (line.startsWith("#EXTVLCOPT:")) {
                const optionMatch = /^#EXTVLCOPT:([^=]+)=(.*)$/.exec(line);
                if (optionMatch) {
                    const optionKey = trimToString(optionMatch[1]).toLowerCase();
                    const optionValue = trimToString(optionMatch[2]);
                    if (optionKey === "http-user-agent" && optionValue) {
                        bufferedUserAgent = optionValue;
                    } else if ((optionKey === "http-referrer" || optionKey === "http-referer") && optionValue) {
                        bufferedHeaders.Referer = optionValue;
                    }
                }
                continue;
            }

            if (line.startsWith("#KODIPROP:inputstream.adaptive.license_type=")) {
                bufferedLicenseType = trimToString(line.split("=").slice(1).join("=")).toLowerCase();
                continue;
            }

            if (line.startsWith("#KODIPROP:inputstream.adaptive.license_key=")) {
                const parsedLicense = parseLicenseKeyPayload(trimToString(line.split("=").slice(1).join("=")));
                if (parsedLicense.licenseUrl) bufferedLicenseUrl = parsedLicense.licenseUrl;
                if (parsedLicense.key) bufferedKey = parsedLicense.key;
                if (parsedLicense.keyid) bufferedKeyid = parsedLicense.keyid;
                if (parsedLicense.drmKeys && Object.keys(parsedLicense.drmKeys).length) bufferedDrmKeys = parsedLicense.drmKeys;
                continue;
            }

            if (line.startsWith("#")) continue;

            const streamLine = parseStreamLine(line);
            if (!isPlayableUrl(streamLine.url)) {
                resetBuffers();
                continue;
            }

            const headers = Object.assign({}, bufferedHeaders, streamLine.headers);
            const userAgent = streamLine.userAgent || bufferedUserAgent;
            const cookie = streamLine.cookie || bufferedCookie;
            const key = streamLine.key || bufferedKey;
            const keyid = streamLine.keyid || bufferedKeyid;
            const licenseUrl = streamLine.licenseUrl || bufferedLicenseUrl;
            const licenseType = streamLine.licenseType || bufferedLicenseType || (licenseUrl ? "widevine" : "");

            if (userAgent && !headers["User-Agent"]) headers["User-Agent"] = userAgent;
            if (cookie && !headers["Cookie"]) headers["Cookie"] = cookie;

            const title = bufferedTitle || trimToString(bufferedAttributes["tvg-name"]) || "Unknown Channel";
            const group = trimToString(bufferedAttributes["group-title"]) || "Other Channels";
            const poster = ensurePosterUrl(title, bufferedAttributes["tvg-logo"] || "");
            const payload = {
                title,
                group,
                poster,
                url: streamLine.url,
                headers,
                userAgent,
                cookie,
                key,
                keyid,
                licenseUrl,
                licenseType,
                drmKeys: bufferedDrmKeys
            };

            parsedItems.push({
                group,
                multimedia: new MultimediaItem({
                    title,
                    url: JSON.stringify(payload),
                    posterUrl: poster,
                    type: "livestream",
                    description: `Live Stream from ${group}`,
                    headers
                })
            });

            resetBuffers();
        }

        return buildCategoryOutput(parsedItems);
    }

    async function getHome(cb) {
        try {
            const playlist = await fetchPlaylist();
            const data = parseM3U(playlist);
            if (!Object.keys(data).length) {
                return cb({ success: false, errorCode: "EMPTY_RESULT", message: "Playlist loaded but no channels were parsed" });
            }
            cb({ success: true, data });
        } catch (error) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: error && error.message ? error.message : String(error) });
        }
    }

    async function search(query, cb) {
        try {
            const playlist = await fetchPlaylist();
            const categories = parseM3U(playlist);
            const loweredQuery = trimToString(query).toLowerCase();
            const results = [];

            Object.keys(categories).forEach((group) => {
                const items = categories[group];
                if (!Array.isArray(items)) return;
                items.forEach((item) => {
                    const title = trimToString(item && item.title).toLowerCase();
                    if (!loweredQuery || title.includes(loweredQuery) || trimToString(group).toLowerCase().includes(loweredQuery)) {
                        results.push(item);
                    }
                });
            });

            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    async function load(url, cb) {
        try {
            const channelData = safeParseJson(url) || { title: "Live Channel", url: trimToString(url), group: "IPTV", poster: "" };
            if (!trimToString(channelData.url)) {
                return cb({ success: false, errorCode: "LOAD_ERROR", message: "Missing channel URL" });
            }

            const poster = ensurePosterUrl(channelData.title, channelData.poster || "");
            cb({
                success: true,
                data: new MultimediaItem({
                    title: channelData.title || "Live Channel",
                    url: JSON.stringify(channelData),
                    posterUrl: poster,
                    type: "livestream",
                    description: `Live TV Channel - ${channelData.group || "IPTV"}`,
                    headers: channelData.headers || {},
                    episodes: [
                        new Episode({
                            name: "Live",
                            season: 1,
                            episode: 1,
                            url: JSON.stringify(channelData),
                            posterUrl: poster
                        })
                    ]
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            const channelData = safeParseJson(url);
            if (!channelData || !trimToString(channelData.url)) {
                return cb({ success: false, errorCode: "STREAM_ERROR", message: "Missing stream data" });
            }

            const headers = Object.assign({}, channelData.headers || {});
            if (trimToString(channelData.userAgent) && !headers["User-Agent"]) headers["User-Agent"] = trimToString(channelData.userAgent);
            if (trimToString(channelData.cookie) && !headers["Cookie"]) headers["Cookie"] = trimToString(channelData.cookie);

            const stream = new StreamResult({
                url: trimToString(channelData.url),
                source: trimToString(channelData.title) || "Auto",
                headers
            });

            const normalizedKey = normalizeDrmValue(channelData.key);
            const normalizedKeyid = normalizeDrmValue(channelData.keyid);
            if (normalizedKey && normalizedKeyid) {
                stream.drmType = "clearkey";
                stream.drmKey = normalizedKey;
                stream.drmKid = normalizedKeyid;
            } else if (trimToString(channelData.licenseUrl)) {
                const licenseUrl = trimToString(channelData.licenseUrl);
                stream.drmType = trimToString(channelData.licenseType) || "widevine";
                stream.licenseUrl = licenseUrl;
                stream.drmLicenseUrl = licenseUrl;
            }

            cb({ success: true, data: [stream] });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
