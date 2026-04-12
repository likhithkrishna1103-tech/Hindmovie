(function() {
    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // `manifest` is injected by the runtime.

    const FIREBASE_CONFIG = {
        packageName: "com.playz.tv",
        apiKey: "AIzaSyDKRqLlbaZBIpHzLBiQTUrJqr3gN-nDWWc",
        appId: "1:516859456626:android:12a75869902c4f8a6826eb",
        projectNumber: "516859456626",
        sdkVersion: "22.1.0",
        appVersion: "2.1",
        appBuild: "4"
    };
    const DEFAULT_BASE_URLS = [
        "https://adsflw.xyz",
        "https://playztv2828.store"
    ];
    const PLAYZ_AES_KEY = "bTVLbDVuazR4SzFrTjdwTg==";
    const PLAYZ_AES_IV = "azVLNG5NOG1LbE5MN2wxNQ==";
    const DEFAULT_PLAYLIST_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0",
        Accept: "*/*",
        "Accept-Language": "en-US,en;q=0.5",
        Connection: "keep-alive"
    };
    const STREAM_TRUSTED_HOSTS = [
        "a151aivottlinear-a.akamaihd.net",
        "a201aivottlinear-a.akamaihd.net",
        "otte.cache.aiv-cdn.net",
        "otte.live.cf.ww.aiv-cdn.net",
        "in-mc-flive.fancode.com",
        "livevideos.cricbuzz.com",
        "livetv.hotstar.com",
        "jiotvpllive.cdn.jio.com",
        "dice-live-oc.akamaized.net",
        "z5ak-cmaflive.zee5.com",
        "livestream1.sunnxt.com",
        "d1g8wgjurz8via.cloudfront.net"
    ];
    const STREAM_WEAK_HOSTS = [
        "winner-api.icu",
        "mainstreams.pro",
        "smarthard.click",
        "chatgpt.hereisman.net",
        "windows-devs.top",
        "firebase-api.com",
        "195.178.110.2"
    ];
    const PLAYLIST_CACHE_TTL_MS = 5 * 60 * 1000;
    const PROVIDER_CATALOG_TTL_MS = 5 * 60 * 1000;

    const PLUGIN_CONFIGS = {
        "com.igris.repo.playztvsony": {
            merged: true,
            providers: [
                { label: "SONY IN", names: ["SONY IN"] },
                { label: "SONY IN 2", names: ["SONY IN 2"] },
                { label: "SONY BD", names: ["SONY BD"] },
                { label: "SONY 2", names: ["SONY 2"] },
                { label: "SonyLiv", names: ["SonyLiv"] },
                { label: "Sony Sports", names: ["Sony Sports"] }
            ]
        },
        "com.igris.repo.playztvjio": {
            merged: true,
            providers: [
                { label: "JIO IND", names: ["JIO IND"] },
                { label: "JIOTV+ IND", names: ["JIOTV+ IND"] },
                { label: "Jio Cinema IND", names: ["Jio Cinema IND"] },
                { label: "Jiohotstar", names: ["Jiohotstar"] },
                { label: "Jio BD", names: ["Jio BD"] },
                { label: "JIOTV+", names: ["JIOTV+"] }
            ]
        },
        "com.igris.repo.playztvzee": {
            merged: true,
            providers: [
                { label: "Z5 SD", names: ["Z5 SD"] },
                { label: "Zee5 IN", names: ["Zee5 IN"] },
                { label: "ZEE5 LIVE", names: ["ZEE5 LIVE"] }
            ]
        },
        "com.igris.repo.playztvbdixtv": {
            merged: false,
            providers: [
                { label: "BDIX TV", names: ["BDIX TV"] }
            ]
        },
        "com.igris.repo.playztvsunnxt": {
            merged: false,
            providers: [
                { label: "Sun Nxt", names: ["Sun Nxt"] }
            ]
        },
        "com.igris.repo.playztvdishtv": {
            merged: false,
            providers: [
                { label: "Dish Tv", names: ["Dish Tv"] }
            ]
        },
        "com.igris.repo.playztvfreesports": {
            merged: false,
            providers: [
                { label: "Free Sports", names: ["Free Sports"] }
            ]
        },
        "com.igris.repo.playztvpiratestv": {
            merged: false,
            providers: [
                { label: "Pirates TV", names: ["Pirates TV"] }
            ]
        }
    };

    let activeBaseUrl = null;
    let remoteBaseUrlsPromise = null;
    let providerCatalogCache = {
        timestamp: 0,
        entries: null
    };
    const providerPlaylistCache = {};

    function trimToString(value) {
        return typeof value === "string" ? value.trim() : String(value || "").trim();
    }

    function safeJsonParse(text) {
        try {
            return JSON.parse(String(text || ""));
        } catch (_) {
            return null;
        }
    }

    function normalizeBaseUrl(value) {
        const normalized = trimToString(value).replace(/\/+$/, "");
        if (!normalized || /example\.com/i.test(normalized)) return null;
        if (!/^https?:\/\//i.test(normalized)) return null;
        return normalized;
    }

    function extractResponseBody(response) {
        if (typeof response === "string") return response;
        if (response && typeof response.body === "string") return response.body;
        return "";
    }

    function extractResponseStatus(response) {
        return response && typeof response.status !== "undefined" ? response.status : 200;
    }

    function createAppInstanceId() {
        let value = "";
        while (value.length < 32) {
            value += Math.random().toString(16).slice(2);
        }
        return value.slice(0, 32);
    }

    function getPluginConfig() {
        const packageName = trimToString(manifest && manifest.packageName);
        return PLUGIN_CONFIGS[packageName] || null;
    }

    async function postJson(url, payload, headers) {
        const body = JSON.stringify(payload);
        if (typeof http_post === "function") {
            return http_post(url, headers || {}, body);
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

    async function fetchText(url, headers) {
        if (typeof http_get === "function") {
            return http_get(url, headers || {});
        }
        if (typeof fetch === "function") {
            const response = await fetch(url, { headers: headers || {} });
            return {
                status: response.status,
                body: await response.text()
            };
        }
        throw new Error("GET requests are not supported in this runtime");
    }

    async function fetchRemoteBaseUrls() {
        if (remoteBaseUrlsPromise) return remoteBaseUrlsPromise;

        remoteBaseUrlsPromise = (async () => {
            const endpoint = `https://firebaseremoteconfig.googleapis.com/v1/projects/${FIREBASE_CONFIG.projectNumber}/namespaces/firebase:fetch`;
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
                Accept: "application/json",
                "X-Android-Package": FIREBASE_CONFIG.packageName,
                "X-Goog-Api-Key": FIREBASE_CONFIG.apiKey,
                "X-Google-GFE-Can-Retry": "yes",
                "User-Agent": "okhttp/4.12.0"
            };

            try {
                const response = await postJson(endpoint, payload, headers);
                if (extractResponseStatus(response) >= 400) return [];

                const data = safeJsonParse(extractResponseBody(response));
                const entries = data && data.entries ? data.entries : {};
                const urls = [];
                const addUrl = (value) => {
                    const normalized = normalizeBaseUrl(value);
                    if (normalized && !urls.includes(normalized)) {
                        urls.push(normalized);
                    }
                };

                addUrl(entries.api_url);
                return urls;
            } catch (error) {
                console.error("Failed to fetch PlayZTV remote config: " + (error && error.message ? error.message : String(error)));
                return [];
            }
        })();

        return remoteBaseUrlsPromise;
    }

    async function getBaseUrls() {
        const urls = [];
        const addUrl = (value) => {
            const normalized = normalizeBaseUrl(value);
            if (normalized && !urls.includes(normalized)) {
                urls.push(normalized);
            }
        };

        addUrl(activeBaseUrl);
        (await fetchRemoteBaseUrls()).forEach(addUrl);
        addUrl(manifest && manifest.baseUrl);
        DEFAULT_BASE_URLS.forEach(addUrl);
        return urls;
    }

    function buildPlayzHeaders(url) {
        const headers = {
            "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)"
        };

        try {
            headers.Host = new URL(String(url || "")).hostname;
        } catch (_) {
            // Ignore invalid URLs.
        }

        return headers;
    }

    async function decryptPlayzPayload(body) {
        const raw = trimToString(body);
        if (!raw) return "";
        if (raw.startsWith("{") || raw.startsWith("[") || raw.startsWith("<")) return raw;

        try {
            const decrypted = await crypto.decryptAES(raw.replace(/\s/g, ""), PLAYZ_AES_KEY, PLAYZ_AES_IV);
            return trimToString(decrypted);
        } catch (_) {
            return "";
        }
    }

    async function fetchPlayzPayload(url) {
        const response = await fetchText(url, buildPlayzHeaders(url));
        if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) {
            return "";
        }
        return decryptPlayzPayload(extractResponseBody(response));
    }

    async function fetchPlayzJson(path) {
        const baseUrls = await getBaseUrls();
        for (const baseUrl of baseUrls) {
            try {
                const finalUrl = /^https?:\/\//i.test(path) ? path : `${baseUrl}/${String(path || "").replace(/^\/+/, "")}`;
                const payload = await fetchPlayzPayload(finalUrl);
                const data = safeJsonParse(payload);
                if (data) {
                    activeBaseUrl = normalizeBaseUrl(baseUrl);
                    return data;
                }
            } catch (error) {
                console.error(`Failed to fetch ${path} from ${baseUrl}: ${error && error.message ? error.message : String(error)}`);
            }
        }
        return null;
    }

    function normalizeHeaderName(key) {
        const lowered = trimToString(key).toLowerCase();
        if (lowered === "user-agent") return "User-Agent";
        if (lowered === "referer" || lowered === "referrer") return "Referer";
        if (lowered === "origin") return "Origin";
        if (lowered === "cookie") return "Cookie";
        return trimToString(key);
    }

    function normalizeDrmScheme(value) {
        const normalized = trimToString(value).toLowerCase();
        if (!normalized) return "";
        if (normalized.includes("widevine")) return "widevine";
        if (normalized.includes("clearkey") || normalized.includes("clear")) return "clearkey";
        return normalized;
    }

    function normalizeDrmToken(value) {
        const normalized = trimToString(value);
        if (!normalized) return "";
        if (/^[0-9a-f-]{32,}$/i.test(normalized)) {
            return normalized.replace(/-/g, "").toLowerCase();
        }
        return normalized;
    }

    function parseHeaderString(headerString) {
        const headers = {};
        trimToString(headerString).split("&").forEach((pair) => {
            const equalsIndex = pair.indexOf("=");
            if (equalsIndex === -1) return;

            const key = normalizeHeaderName(pair.slice(0, equalsIndex));
            if (!key) return;

            let value = trimToString(pair.slice(equalsIndex + 1));
            try {
                value = decodeURIComponent(value);
            } catch (_) {
                // Keep raw value.
            }
            headers[key] = value;
        });
        return headers;
    }

    function splitUrlAndHeaders(rawUrl) {
        const value = trimToString(rawUrl);
        const result = {
            url: value,
            headers: {},
            userAgent: "",
            cookie: "",
            drmScheme: "",
            licenseUrl: "",
            key: "",
            keyid: ""
        };

        if (!value.includes("|")) {
            return result;
        }

        const parts = value.split("|", 2);
        result.url = trimToString(parts[0]);
        trimToString(parts[1] || "").split("&").forEach((pair) => {
            const equalsIndex = pair.indexOf("=");
            if (equalsIndex === -1) return;

            const rawKey = trimToString(pair.slice(0, equalsIndex));
            if (!rawKey) return;

            let rawValue = trimToString(pair.slice(equalsIndex + 1));
            try {
                rawValue = decodeURIComponent(rawValue);
            } catch (_) {
                // Keep raw value.
            }

            const lowered = rawKey.toLowerCase();
            if (lowered === "drmlicense" || lowered === "licenseurl") {
                result.licenseUrl = rawValue;
                return;
            }
            if (lowered === "drmscheme") {
                result.drmScheme = normalizeDrmScheme(rawValue);
                return;
            }
            if (lowered === "key") {
                result.key = rawValue;
                return;
            }
            if (lowered === "keyid") {
                result.keyid = rawValue;
                return;
            }

            const key = normalizeHeaderName(rawKey);
            if (!key) return;
            result.headers[key] = rawValue;
            if (key === "User-Agent") result.userAgent = rawValue;
            if (key === "Cookie") result.cookie = rawValue;
        });
        return result;
    }

    function mergeHeaders(left, right) {
        return Object.assign({}, left || {}, right || {});
    }

    function isPlaylistResponse(body) {
        const text = trimToString(body);
        if (!text) return false;

        const preview = text.slice(0, 20000);
        return (
            preview.includes("#EXTM3U") ||
            preview.includes("#EXTINF:") ||
            preview.includes("#KODIPROP:")
        );
    }

    function parseCatalogEntry(sourcePath, entry) {
        if (!entry || typeof entry !== "object" || !entry.cat) return null;
        const cat = typeof entry.cat === "string" ? safeJsonParse(entry.cat) : entry.cat;
        if (!cat || cat.visible === false) return null;

        return {
            sourcePath,
            name: trimToString(cat.name),
            api: trimToString(cat.api),
            type: trimToString(cat.type).toLowerCase(),
            logo: trimToString(cat.logo)
        };
    }

    async function fetchProviderCatalog() {
        if (providerCatalogCache.entries && (Date.now() - providerCatalogCache.timestamp) < PROVIDER_CATALOG_TTL_MS) {
            return providerCatalogCache.entries;
        }

        const [categories, sports] = await Promise.all([
            fetchPlayzJson("categories.txt"),
            fetchPlayzJson("sports.txt")
        ]);
        const entries = [];

        (Array.isArray(categories) ? categories : []).forEach((entry) => {
            const parsed = parseCatalogEntry("categories.txt", entry);
            if (parsed) entries.push(parsed);
        });
        (Array.isArray(sports) ? sports : []).forEach((entry) => {
            const parsed = parseCatalogEntry("sports.txt", entry);
            if (parsed) entries.push(parsed);
        });

        providerCatalogCache = {
            timestamp: Date.now(),
            entries
        };
        return entries;
    }

    function findProviderCandidates(catalog, providerDefinition) {
        const acceptedNames = (providerDefinition && Array.isArray(providerDefinition.names) ? providerDefinition.names : [])
            .map((name) => trimToString(name).toLowerCase())
            .filter(Boolean);

        return (catalog || []).filter((entry) => {
            const entryName = trimToString(entry && entry.name).toLowerCase();
            return entryName && acceptedNames.includes(entryName);
        });
    }

    async function fetchProviderPlaylist(candidate) {
        const cacheKey = trimToString(candidate && candidate.api);
        const cached = providerPlaylistCache[cacheKey];
        if (cached && (Date.now() - cached.timestamp) < PLAYLIST_CACHE_TTL_MS) {
            if (cached.error) throw new Error(cached.error);
            return cached.body;
        }

        const parsedApi = splitUrlAndHeaders(cacheKey);
        if (!parsedApi.url) throw new Error("Missing provider playlist URL");

        const headers = mergeHeaders(DEFAULT_PLAYLIST_HEADERS, parsedApi.headers);
        const response = await fetchText(parsedApi.url, headers);
        const status = extractResponseStatus(response);
        const body = extractResponseBody(response);
        const trimmed = trimToString(body);

        if (status >= 200 && status < 300 && isPlaylistResponse(trimmed)) {
            providerPlaylistCache[cacheKey] = {
                timestamp: Date.now(),
                body: trimmed
            };
            return trimmed;
        }

        const preview = trimmed ? trimmed.slice(0, 120).replace(/\s+/g, " ") : "empty response body";
        const message = `${cacheKey} -> ${status || "no response"} (${preview})`;
        providerPlaylistCache[cacheKey] = {
            timestamp: Date.now(),
            error: message
        };
        throw new Error(message);
    }

    function splitExtInfLine(line) {
        const payload = String(line || "").replace(/^#EXTINF:[^ ]+/, "").trim();
        let lastCommaIndex = -1;
        let insideQuotes = false;

        for (let index = 0; index < payload.length; index++) {
            const character = payload[index];
            if (character === "\"") {
                insideQuotes = !insideQuotes;
            } else if (character === "," && !insideQuotes) {
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

        while ((match = regex.exec(String(attributesPart || ""))) !== null) {
            const key = match[1];
            const value = trimToString(match[2] || match[3] || "");
            if (key) attributes[key] = value;
        }

        return attributes;
    }

    function parseExtHttpLine(line) {
        return safeJsonParse(String(line || "").replace(/^#EXTHTTP:/, "").trim());
    }

    function safeDecode(value) {
        try {
            return decodeURIComponent(value);
        } catch (_) {
            return value;
        }
    }

    function parsePipeHeaders(line) {
        const parsed = splitUrlAndHeaders(safeDecode(line));
        return {
            url: parsed.url,
            headers: parsed.headers || {},
            userAgent: parsed.userAgent || trimToString(parsed.headers && parsed.headers["User-Agent"]),
            cookie: parsed.cookie || trimToString(parsed.headers && parsed.headers.Cookie),
            drmScheme: parsed.drmScheme || "",
            licenseUrl: parsed.licenseUrl || "",
            key: parsed.key || "",
            keyid: parsed.keyid || ""
        };
    }

    function createBufferedDrm() {
        return {
            licenseType: "",
            licenseKey: "",
            licenseUrl: ""
        };
    }

    function isLowValuePosterUrl(url) {
        const value = trimToString(url).toLowerCase();
        if (!value) return true;

        return (
            value.includes("encrypted-tbn0.gstatic.com/images?q=tbn:") ||
            value.includes("googleusercontent.com/img/b/")
        );
    }

    function normalizePosterUrl(providerLabel, posterUrl) {
        const value = trimToString(posterUrl);
        if (!value) return "";

        const normalizedProvider = trimToString(providerLabel).toLowerCase();
        if (normalizedProvider === "jio bd" && isLowValuePosterUrl(value)) {
            return "";
        }

        return value;
    }

    function createChannelFromExtInf(providerLabel, providerLogo, title, attributes, bufferedDrm) {
        const poster = normalizePosterUrl(
            providerLabel,
            trimToString(attributes["tvg-logo"]) || trimToString(providerLogo)
        );

        return {
            title,
            poster,
            group: trimToString(attributes["group-title"]) || "Other Channels",
            headers: {},
            userAgent: "",
            cookie: "",
            providerLabel,
            licenseType: trimToString(bufferedDrm && bufferedDrm.licenseType),
            licenseKey: trimToString(bufferedDrm && bufferedDrm.licenseKey),
            licenseUrl: trimToString(bufferedDrm && bufferedDrm.licenseUrl),
            drmScheme: "",
            key: "",
            keyid: ""
        };
    }

    function normalizeGroupName(groupName) {
        const value = trimToString(groupName);
        return value || "Other Channels";
    }

    function isNoiseChannel(channel) {
        const title = trimToString(channel && channel.title).toLowerCase();
        const url = trimToString(channel && channel.url).toLowerCase();
        if (!title || !/^https?:\/\//i.test(url)) return true;

        const patterns = [
            /join\s*(telegram|tg)/i,
            /\btelegram\b/i,
            /\bt\.me\//i,
            /welcome to playz tv/i,
            /download\s+app/i,
            /contact\s+(developer|admin|us)/i,
            /how to install/i,
            /playlist update/i,
            /new app/i
        ];
        return patterns.some((pattern) => pattern.test(title) || pattern.test(url));
    }

    function parseM3UChannels(m3uString, providerLabel, providerLogo) {
        const lines = String(m3uString || "").split(/\r?\n/);
        const channels = [];
        let currentChannel = null;
        let bufferedDrm = createBufferedDrm();

        for (let index = 0; index < lines.length; index++) {
            const line = trimToString(lines[index]);
            if (!line) continue;

            if (/^#KODIPROP:inputstream\.adaptive\.license_type=/i.test(line)) {
                const value = trimToString(line.split("=").slice(1).join("="));
                if (currentChannel) currentChannel.licenseType = value;
                else bufferedDrm.licenseType = value;
                continue;
            }

            if (/^#KODIPROP:inputstream\.adaptive\.license_key=/i.test(line)) {
                const value = trimToString(line.split("=").slice(1).join("="));
                if (currentChannel) currentChannel.licenseKey = value;
                else bufferedDrm.licenseKey = value;
                continue;
            }

            if (/^#KODIPROP:inputstream\.adaptive\.license_url=/i.test(line)) {
                const value = trimToString(line.split("=").slice(1).join("="));
                if (currentChannel) currentChannel.licenseUrl = value;
                else bufferedDrm.licenseUrl = value;
                continue;
            }

            if (line.startsWith("#EXTINF")) {
                const extInfParts = splitExtInfLine(line);
                const attributes = extractAttributes(extInfParts.attributesPart);
                currentChannel = createChannelFromExtInf(providerLabel, providerLogo, extInfParts.title, attributes, bufferedDrm);
                bufferedDrm = createBufferedDrm();
                continue;
            }

            if (line.startsWith("#EXTGRP:")) {
                if (currentChannel) {
                    currentChannel.group = normalizeGroupName(line.split(":").slice(1).join(":"));
                }
                continue;
            }

            if (line.startsWith("#EXTVLCOPT:http-user-agent=")) {
                if (currentChannel) {
                    currentChannel.userAgent = line.split("=").slice(1).join("=").trim();
                    currentChannel.headers["User-Agent"] = currentChannel.userAgent;
                }
                continue;
            }

            if (line.startsWith("#EXTVLCOPT:http-referrer=") || line.startsWith("#EXTVLCOPT:http-referer=")) {
                if (currentChannel) currentChannel.headers["Referer"] = line.split("=").slice(1).join("=").trim();
                continue;
            }

            if (line.startsWith("#EXTVLCOPT:http-origin=")) {
                if (currentChannel) currentChannel.headers["Origin"] = line.split("=").slice(1).join("=").trim();
                continue;
            }

            if (line.startsWith("#EXTHTTP:")) {
                if (currentChannel) {
                    const extHttp = parseExtHttpLine(line);
                    if (extHttp && typeof extHttp === "object") {
                        Object.keys(extHttp).forEach((key) => {
                            const normalizedKey = normalizeHeaderName(key);
                            const value = trimToString(extHttp[key]);
                            if (!normalizedKey || !value) return;

                            currentChannel.headers[normalizedKey] = value;
                            if (normalizedKey === "User-Agent") currentChannel.userAgent = value;
                            if (normalizedKey === "Cookie") currentChannel.cookie = value;
                        });
                    }
                }
                continue;
            }

            if (!line.startsWith("#")) {
                if (!currentChannel) {
                    bufferedDrm = createBufferedDrm();
                    continue;
                }

                const parsedStream = parsePipeHeaders(line);
                currentChannel.url = parsedStream.url;
                currentChannel.headers = mergeHeaders(currentChannel.headers, parsedStream.headers);
                if (!currentChannel.userAgent && parsedStream.userAgent) currentChannel.userAgent = parsedStream.userAgent;
                if (!currentChannel.cookie && parsedStream.cookie) currentChannel.cookie = parsedStream.cookie;
                if (!currentChannel.drmScheme && parsedStream.drmScheme) currentChannel.drmScheme = parsedStream.drmScheme;
                if (!currentChannel.licenseUrl && parsedStream.licenseUrl) currentChannel.licenseUrl = parsedStream.licenseUrl;
                if (!currentChannel.key && parsedStream.key) currentChannel.key = parsedStream.key;
                if (!currentChannel.keyid && parsedStream.keyid) currentChannel.keyid = parsedStream.keyid;

                currentChannel.group = normalizeGroupName(currentChannel.group);
                if (!isNoiseChannel(currentChannel)) {
                    channels.push(currentChannel);
                }

                currentChannel = null;
                bufferedDrm = createBufferedDrm();
            }
        }

        return channels;
    }

    function createChannelItem(channel, prefixProvider) {
        const title = prefixProvider ? `${channel.providerLabel} · ${channel.title}` : channel.title;
        const poster = trimToString(channel.poster) || `https://placehold.co/400x600.png?text=${encodeURIComponent(channel.title)}`;
        const descriptionParts = [channel.providerLabel];
        if (trimToString(channel.group) && trimToString(channel.group) !== "Other Channels") {
            descriptionParts.push(channel.group);
        }

        return new MultimediaItem({
            title,
            url: JSON.stringify(channel),
            posterUrl: poster,
            type: "livestream",
            description: descriptionParts.join(" · ")
        });
    }

    function buildSectionsFromChannels(channels) {
        const sections = {};
        channels.forEach((channel) => {
            const group = normalizeGroupName(channel.group);
            if (!sections[group]) sections[group] = [];
            sections[group].push(createChannelItem(channel, false));
        });
        return sections;
    }

    async function resolveProviderChannels(providerDefinition) {
        const catalog = await fetchProviderCatalog();
        const candidates = findProviderCandidates(catalog, providerDefinition);
        const failures = [];

        for (const candidate of candidates) {
            if (candidate.type !== "m3u") {
                failures.push(`${candidate.name}: unsupported type ${candidate.type || "unknown"}`);
                continue;
            }

            try {
                const playlist = await fetchProviderPlaylist(candidate);
                const channels = parseM3UChannels(playlist, providerDefinition.label, candidate.logo);
                if (channels.length) {
                    return {
                        label: providerDefinition.label,
                        channels,
                        candidate
                    };
                }
                failures.push(`${candidate.name}: empty playlist`);
            } catch (error) {
                failures.push(`${candidate.name}: ${error && error.message ? error.message : String(error)}`);
            }
        }

        return {
            label: providerDefinition.label,
            channels: [],
            candidate: null,
            error: failures.join(" | ")
        };
    }

    async function resolveAllProviders() {
        const config = getPluginConfig();
        if (!config) throw new Error("Unsupported PlayZTV plugin manifest");
        return Promise.all(config.providers.map((provider) => resolveProviderChannels(provider)));
    }

    function getStreamHost(url) {
        try {
            return new URL(String(url || "")).hostname.toLowerCase();
        } catch (_) {
            return "";
        }
    }

    function matchesHost(host, entries) {
        const normalized = trimToString(host).toLowerCase();
        return entries.some((entry) => normalized === entry || normalized.endsWith(`.${entry}`));
    }

    function shouldExpandHlsVariants(url) {
        const value = trimToString(url).toLowerCase();
        if (!value || /\.mpd(?:$|[?#])/i.test(value)) return false;
        return /\.m3u8(?:$|[?#])/i.test(value) || value.includes("/hls/") || value.includes("m3u8");
    }

    function parseHlsAttributes(line) {
        const attributes = {};
        const regex = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/g;
        let match;

        while ((match = regex.exec(String(line || ""))) !== null) {
            const key = trimToString(match[1]).toUpperCase();
            const value = trimToString(match[2]).replace(/^"|"$/g, "");
            if (key) attributes[key] = value;
        }

        return attributes;
    }

    function resolveVariantUrl(baseUrl, variantPath) {
        const target = trimToString(variantPath);
        if (!target) return "";

        try {
            const resolved = new URL(target, baseUrl);
            const base = new URL(baseUrl);
            if (!resolved.search && !target.includes("?") && base.search) {
                resolved.search = base.search;
            }
            return resolved.toString();
        } catch (_) {
            return target;
        }
    }

    function parseVariantQuality(attributes) {
        const resolution = trimToString(attributes && attributes.RESOLUTION);
        const resolutionMatch = /(\d+)\s*x\s*(\d+)/i.exec(resolution);
        if (resolutionMatch) return parseInt(resolutionMatch[2], 10) || 0;

        const bandwidth = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (!bandwidth || bandwidth < 1) return 0;
        if (bandwidth >= 6000000) return 1080;
        if (bandwidth >= 3000000) return 720;
        if (bandwidth >= 1500000) return 480;
        if (bandwidth >= 800000) return 360;
        return 240;
    }

    function buildVariantSource(baseSource, attributes, fallbackIndex) {
        const quality = parseVariantQuality(attributes);
        if (quality > 0) {
            return {
                quality,
                source: `${baseSource} ${quality}p`
            };
        }

        const bandwidth = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (bandwidth > 0) {
            return {
                quality: 0,
                source: `${baseSource} ${Math.max(1, Math.round(bandwidth / 1000))}kbps`
            };
        }

        return {
            quality: 0,
            source: `${baseSource} Variant ${fallbackIndex + 1}`
        };
    }

    function parseHlsMasterPlaylist(manifestText, manifestUrl) {
        const info = {
            variants: [],
            version: "",
            independentSegments: false,
            mediaGroups: {
                AUDIO: {},
                SUBTITLES: {},
                "CLOSED-CAPTIONS": {}
            }
        };
        const lines = String(manifestText || "").split(/\r?\n/);
        let pendingAttributes = null;

        lines.forEach((rawLine) => {
            const line = trimToString(rawLine);
            if (!line) return;

            if (line.startsWith("#EXT-X-VERSION:")) {
                info.version = trimToString(line.slice("#EXT-X-VERSION:".length));
                return;
            }

            if (line === "#EXT-X-INDEPENDENT-SEGMENTS") {
                info.independentSegments = true;
                return;
            }

            if (line.startsWith("#EXT-X-MEDIA:")) {
                const attributes = parseHlsAttributes(line.slice("#EXT-X-MEDIA:".length));
                const mediaType = trimToString(attributes.TYPE).toUpperCase();
                const groupId = trimToString(attributes["GROUP-ID"]);
                if (!mediaType || !groupId) return;
                if (attributes.URI) {
                    attributes.URI = resolveVariantUrl(manifestUrl, attributes.URI);
                }
                if (!info.mediaGroups[mediaType]) {
                    info.mediaGroups[mediaType] = {};
                }
                if (!info.mediaGroups[mediaType][groupId]) {
                    info.mediaGroups[mediaType][groupId] = [];
                }
                info.mediaGroups[mediaType][groupId].push(attributes);
                return;
            }

            if (line.startsWith("#EXT-X-STREAM-INF:")) {
                pendingAttributes = parseHlsAttributes(line.slice("#EXT-X-STREAM-INF:".length));
                return;
            }

            if (line.startsWith("#")) return;

            if (pendingAttributes) {
                const resolved = resolveVariantUrl(manifestUrl, line);
                if (resolved) {
                    info.variants.push({
                        url: resolved,
                        attributes: pendingAttributes
                    });
                }
                pendingAttributes = null;
            }
        });

        return info;
    }

    function encodeInlineManifest(text) {
        return `data:application/vnd.apple.mpegurl;charset=utf-8,${encodeURIComponent(String(text || ""))}`;
    }

    function serializeHlsAttributeValue(value) {
        const text = trimToString(value);
        if (!text) return "\"\"";
        if (/^-?\d+(?:\.\d+)?$/i.test(text)) return text;
        if (/^(YES|NO|NONE)$/i.test(text)) return text.toUpperCase();
        if (/^[A-Za-z0-9._:-]+(?:x[A-Za-z0-9._:-]+)?$/i.test(text)) return text;
        return `"${text.replace(/"/g, "\\\"")}"`;
    }

    function serializeHlsAttributes(attributes) {
        return Object.keys(attributes || {}).map((key) => `${key}=${serializeHlsAttributeValue(attributes[key])}`).join(",");
    }

    function appendMediaGroupLines(lines, manifestInfo, mediaType, groupId) {
        const groups = manifestInfo && manifestInfo.mediaGroups ? manifestInfo.mediaGroups : {};
        const entries = groups[mediaType] && groups[mediaType][groupId] ? groups[mediaType][groupId] : [];
        entries.forEach((attributes) => {
            lines.push(`#EXT-X-MEDIA:${serializeHlsAttributes(attributes)}`);
        });
        return entries.length > 0;
    }

    function buildVariantPlaybackUrl(manifestInfo, variant) {
        const attributes = variant && variant.attributes ? variant.attributes : {};
        const lines = ["#EXTM3U"];
        if (manifestInfo && manifestInfo.version) {
            lines.push(`#EXT-X-VERSION:${manifestInfo.version}`);
        }
        if (manifestInfo && manifestInfo.independentSegments) {
            lines.push("#EXT-X-INDEPENDENT-SEGMENTS");
        }

        let includedAlternateMedia = false;
        const audioGroupId = trimToString(attributes.AUDIO);
        if (audioGroupId) {
            includedAlternateMedia = appendMediaGroupLines(lines, manifestInfo, "AUDIO", audioGroupId) || includedAlternateMedia;
        }
        const subtitleGroupId = trimToString(attributes.SUBTITLES);
        if (subtitleGroupId) {
            includedAlternateMedia = appendMediaGroupLines(lines, manifestInfo, "SUBTITLES", subtitleGroupId) || includedAlternateMedia;
        }
        const captionsGroupId = trimToString(attributes["CLOSED-CAPTIONS"]);
        if (captionsGroupId && captionsGroupId.toUpperCase() !== "NONE") {
            includedAlternateMedia = appendMediaGroupLines(lines, manifestInfo, "CLOSED-CAPTIONS", captionsGroupId) || includedAlternateMedia;
        }

        if (!includedAlternateMedia) {
            return trimToString(variant && variant.url);
        }

        lines.push(`#EXT-X-STREAM-INF:${serializeHlsAttributes(attributes)}`);
        lines.push(trimToString(variant && variant.url));
        return encodeInlineManifest(lines.join("\n"));
    }

    function extractClearKeyPairFromJson(value) {
        const data = safeJsonParse(value);
        const entries = data && Array.isArray(data.keys) ? data.keys : [];
        const firstEntry = entries.find((entry) => entry && (entry.k || entry.key) && (entry.kid || entry.keyid));
        if (!firstEntry) return null;

        const drmKey = normalizeDrmToken(firstEntry.k || firstEntry.key);
        const drmKid = normalizeDrmToken(firstEntry.kid || firstEntry.keyid);
        if (!drmKey || !drmKid) return null;
        return { drmKey, drmKid };
    }

    function extractClearKeyPairFromValue(value) {
        const text = trimToString(value);
        if (!text || /^https?:\/\//i.test(text)) return null;
        if (text.startsWith("{")) {
            return extractClearKeyPairFromJson(text);
        }

        const delimiter = text.includes(":") ? ":" : (text.includes(",") ? "," : "");
        if (!delimiter) return null;

        const parts = text.split(delimiter, 2);
        const drmKid = normalizeDrmToken(parts[0]);
        const drmKey = normalizeDrmToken(parts[1]);
        if (!drmKey || !drmKid) return null;
        return { drmKey, drmKid };
    }

    function hexToBase64Url(hex) {
        const normalized = trimToString(hex).replace(/-/g, "");
        if (!/^[0-9a-f]+$/i.test(normalized) || normalized.length % 2 !== 0) return "";
        const bytes = [];
        for (let index = 0; index < normalized.length; index += 2) {
            bytes.push(parseInt(normalized.slice(index, index + 2), 16));
        }
        const binary = String.fromCharCode.apply(null, bytes);
        if (typeof btoa === "function") {
            return btoa(binary).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/g, "");
        }
        return "";
    }

    async function extractDefaultKidFromMpd(streamUrl, headers) {
        if (!/\.mpd(?:$|[?#])/i.test(trimToString(streamUrl))) return "";
        try {
            const response = await fetchText(streamUrl, headers || {});
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return "";
            const body = extractResponseBody(response);
            const match = /cenc:default_KID=["']([0-9a-fA-F-]{32,36})["']/i.exec(body);
            if (!match) return "";
            return hexToBase64Url(match[1]);
        } catch (_) {
            return "";
        }
    }

    async function fetchClearKeyFromLicenseServer(url, kid, headers) {
        const licenseUrl = trimToString(url);
        const drmKid = trimToString(kid);
        if (!licenseUrl || !drmKid) return "";

        try {
            const response = await postJson(licenseUrl, {
                kids: [drmKid],
                type: "temporary"
            }, mergeHeaders(headers || {}, {
                "Content-Type": "application/json;charset=UTF-8"
            }));

            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return "";
            const data = safeJsonParse(extractResponseBody(response));
            const keys = data && Array.isArray(data.keys) ? data.keys : [];
            const firstKey = keys.find((entry) => entry && (entry.k || entry.key));
            return normalizeDrmToken(firstKey && (firstKey.k || firstKey.key));
        } catch (_) {
            return "";
        }
    }

    async function resolveChannelDrm(channel, streamUrl, baseHeaders) {
        if (!channel || typeof channel !== "object") {
            return {
                headers: mergeHeaders({}, baseHeaders || {}),
                drmType: "",
                drmKey: "",
                drmKid: "",
                licenseUrl: ""
            };
        }

        if (channel.__resolvedDrmPromise) {
            return channel.__resolvedDrmPromise;
        }

        channel.__resolvedDrmPromise = (async () => {
            const streamHeaders = mergeHeaders({}, baseHeaders || {});
            const inlineKey = normalizeDrmToken(channel.key);
            const inlineKid = normalizeDrmToken(channel.keyid);
            const inlineScheme = normalizeDrmScheme(channel.drmScheme);
            const licenseType = normalizeDrmScheme(channel.licenseType) || inlineScheme;
            const rawLicenseKey = trimToString(channel.licenseKey);
            const rawLicenseUrl = trimToString(channel.licenseUrl);

            const parsedLicenseKey = rawLicenseKey ? splitUrlAndHeaders(rawLicenseKey) : null;
            const parsedLicenseUrl = rawLicenseUrl ? splitUrlAndHeaders(rawLicenseUrl) : null;
            if (parsedLicenseKey && parsedLicenseKey.headers) {
                Object.assign(streamHeaders, mergeHeaders(streamHeaders, parsedLicenseKey.headers));
            }
            if (parsedLicenseUrl && parsedLicenseUrl.headers) {
                Object.assign(streamHeaders, mergeHeaders(streamHeaders, parsedLicenseUrl.headers));
            }

            let drmKey = inlineKey;
            let drmKid = inlineKid;
            if ((!drmKey || !drmKid) && parsedLicenseKey) {
                const pair = extractClearKeyPairFromValue(parsedLicenseKey.url);
                if (pair) {
                    drmKey = drmKey || pair.drmKey;
                    drmKid = drmKid || pair.drmKid;
                }
            }

            const resolvedLicenseUrl = trimToString(
                channel.licenseUrl ||
                (parsedLicenseUrl && parsedLicenseUrl.url) ||
                (parsedLicenseKey && /^https?:\/\//i.test(parsedLicenseKey.url) ? parsedLicenseKey.url : "")
            );

            const drmType = normalizeDrmScheme(
                channel.drmScheme ||
                (parsedLicenseKey && parsedLicenseKey.drmScheme) ||
                (parsedLicenseUrl && parsedLicenseUrl.drmScheme) ||
                channel.licenseType
            );

            if ((!drmKey || !drmKid) && drmType === "clearkey" && resolvedLicenseUrl && /\.mpd(?:$|[?#])/i.test(trimToString(streamUrl))) {
                const mpdKid = await extractDefaultKidFromMpd(streamUrl, streamHeaders);
                if (mpdKid) {
                    const fetchedKey = await fetchClearKeyFromLicenseServer(resolvedLicenseUrl, mpdKid, streamHeaders);
                    if (fetchedKey) {
                        drmKid = mpdKid;
                        drmKey = fetchedKey;
                    }
                }
            }

            const resolved = {
                headers: streamHeaders,
                drmType: drmKey && drmKid ? "clearkey" : (drmType || (resolvedLicenseUrl ? "widevine" : "")),
                drmKey,
                drmKid,
                licenseUrl: resolvedLicenseUrl
            };

            channel.__resolvedDrm = resolved;
            return resolved;
        })();

        return channel.__resolvedDrmPromise;
    }

    function applyChannelDrm(stream, channel, streamHeaders) {
        const resolved = channel && channel.__resolvedDrm ? channel.__resolvedDrm : null;
        if (resolved) {
            Object.assign(streamHeaders, mergeHeaders(streamHeaders, resolved.headers || {}));
            if (resolved.drmKey && resolved.drmKid) {
                stream.drmKey = resolved.drmKey;
                stream.drmKid = resolved.drmKid;
                stream.drmType = normalizeDrmScheme(resolved.drmType) || "clearkey";
                return;
            }
            if (resolved.licenseUrl) {
                stream.licenseUrl = resolved.licenseUrl;
                stream.drmLicenseUrl = resolved.licenseUrl;
                stream.drmType = normalizeDrmScheme(resolved.drmType) || "widevine";
                return;
            }
        }

        const licenseType = trimToString(channel && channel.licenseType).toLowerCase();
        const rawLicenseKey = trimToString(channel && channel.licenseKey);
        const rawLicenseUrl = trimToString(channel && channel.licenseUrl);

        const parsedLicenseKey = rawLicenseKey ? splitUrlAndHeaders(rawLicenseKey) : null;
        const parsedLicenseUrl = rawLicenseUrl ? splitUrlAndHeaders(rawLicenseUrl) : null;
        if (parsedLicenseKey && parsedLicenseKey.headers) {
            Object.assign(streamHeaders, mergeHeaders(streamHeaders, parsedLicenseKey.headers));
        }
        if (parsedLicenseUrl && parsedLicenseUrl.headers) {
            Object.assign(streamHeaders, mergeHeaders(streamHeaders, parsedLicenseUrl.headers));
        }

        if (licenseType === "clearkey" && parsedLicenseKey && parsedLicenseKey.url) {
            const pair = extractClearKeyPairFromValue(parsedLicenseKey.url);
            if (pair) {
                stream.drmKid = pair.drmKid;
                stream.drmKey = pair.drmKey;
                stream.drmType = "clearkey";
                return;
            }
        }

        const resolvedLicenseUrl = parsedLicenseUrl && parsedLicenseUrl.url
            ? parsedLicenseUrl.url
            : (parsedLicenseKey && /^https?:\/\//i.test(parsedLicenseKey.url) ? parsedLicenseKey.url : "");
        if (resolvedLicenseUrl) {
            stream.licenseUrl = resolvedLicenseUrl;
            stream.drmLicenseUrl = resolvedLicenseUrl;
            stream.drmType = licenseType === "clearkey" ? "clearkey" : (licenseType || "widevine");
        }
    }

    function createStreamResult(channel, sourceLabel, url, headers, quality) {
        const streamHeaders = mergeHeaders({}, headers || {});
        const stream = new StreamResult({
            source: sourceLabel,
            url,
            headers: streamHeaders
        });
        if (typeof quality === "number" && quality > 0) {
            stream.quality = quality;
        }
        applyChannelDrm(stream, channel, streamHeaders);
        return stream;
    }

    function scoreStream(channel, sourceLabel, url, headers, quality, isVariant) {
        const source = trimToString(sourceLabel).toLowerCase();
        const host = getStreamHost(url);
        const hasDrm = trimToString(channel && (channel.licenseKey || channel.licenseUrl));
        const isDash = /\.mpd(?:$|[?#])/i.test(url);
        const isHls = /\.m3u8(?:$|[?#])/i.test(url) || /\/hls\//i.test(url);
        const mergedHeaders = headers && typeof headers === "object" ? headers : {};

        let score = 0;
        if (/^https?:\/\//i.test(url)) score += 10;
        if (isDash) score += 25;
        if (isHls) score += 15;
        if (hasDrm) score += 45;
        if (Object.keys(mergedHeaders).length) score += 4;
        if (mergedHeaders.Cookie) score += 8;
        if (mergedHeaders.Referer) score += 6;
        if (mergedHeaders["User-Agent"]) score += 2;
        if (typeof quality === "number" && quality > 0) score += Math.min(Math.round(quality / 180), 6);
        if (matchesHost(host, STREAM_TRUSTED_HOSTS)) score += 20;
        if (matchesHost(host, STREAM_WEAK_HOSTS)) score -= 30;
        if (source.includes("low")) score -= 12;
        if (source.includes("sd")) score -= 5;
        if (source.includes("backup")) score -= 3;
        if (isVariant) score -= 1;
        return score;
    }

    async function expandHlsStreams(channel) {
        if (!channel || !shouldExpandHlsVariants(channel.url)) return [];

        try {
            const response = await fetchText(channel.url, channel.headers || {});
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return [];

            const manifestText = trimToString(extractResponseBody(response));
            if (!manifestText.startsWith("#EXTM3U") || manifestText.indexOf("#EXT-X-STREAM-INF") === -1) return [];

            const manifestInfo = parseHlsMasterPlaylist(manifestText, channel.url);
            const variants = manifestInfo && Array.isArray(manifestInfo.variants) ? manifestInfo.variants : [];
            const seen = {};
            const streams = [];

            variants.forEach((variant, index) => {
                const playbackUrl = buildVariantPlaybackUrl(manifestInfo, variant);
                if (!variant || !variant.url || !playbackUrl || seen[playbackUrl]) return;
                seen[playbackUrl] = true;
                const variantInfo = buildVariantSource(channel.providerLabel, variant.attributes || {}, index);
                streams.push(createStreamResult(
                    channel,
                    variantInfo.source,
                    playbackUrl,
                    channel.headers || {},
                    variantInfo.quality
                ));
            });

            return streams;
        } catch (_) {
            return [];
        }
    }

    async function getHome(cb) {
        try {
            const config = getPluginConfig();
            if (!config) {
                return cb({ success: false, errorCode: "PARSE_ERROR", message: "Unsupported PlayZTV manifest configuration" });
            }

            const providerResults = await resolveAllProviders();
            const sections = {};

            if (config.merged) {
                providerResults.forEach((provider) => {
                    if (!provider.channels.length) return;
                    sections[provider.label] = provider.channels.map((channel) => createChannelItem(channel, false));
                });
            } else {
                providerResults.forEach((provider) => {
                    if (!provider.channels.length) return;
                    const providerSections = buildSectionsFromChannels(provider.channels);
                    Object.keys(providerSections).forEach((sectionName) => {
                        if (!sections[sectionName]) sections[sectionName] = [];
                        providerSections[sectionName].forEach((item) => sections[sectionName].push(item));
                    });
                });
            }

            const availableSections = Object.keys(sections).filter((sectionName) => Array.isArray(sections[sectionName]) && sections[sectionName].length);
            if (!availableSections.length) {
                return cb({
                    success: false,
                    errorCode: "SITE_OFFLINE",
                    message: "No playable PlayZTV providers are currently available for this plugin"
                });
            }

            cb({ success: true, data: sections });
        } catch (error) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: error && error.message ? error.message : String(error)
            });
        }
    }

    async function search(query, cb) {
        try {
            const config = getPluginConfig();
            if (!config) return cb({ success: true, data: [] });

            const loweredQuery = trimToString(query).toLowerCase();
            if (!loweredQuery) return cb({ success: true, data: [] });

            const providerResults = await resolveAllProviders();
            const results = [];

            providerResults.forEach((provider) => {
                provider.channels.forEach((channel) => {
                    const haystack = [
                        channel.title,
                        channel.group,
                        channel.providerLabel
                    ].filter(Boolean).join(" ").toLowerCase();
                    if (haystack.includes(loweredQuery)) {
                        results.push(createChannelItem(channel, !!config.merged));
                    }
                });
            });

            cb({ success: true, data: results });
        } catch (_) {
            cb({ success: true, data: [] });
        }
    }

    async function load(urlStr, cb) {
        try {
            const channel = JSON.parse(urlStr);
            const poster = trimToString(channel.poster) || `https://placehold.co/400x600.png?text=${encodeURIComponent(channel.title || "Live")}`;
            const description = [
                trimToString(channel.providerLabel),
                trimToString(channel.group)
            ].filter(Boolean).join(" · ");

            cb({
                success: true,
                data: new MultimediaItem({
                    title: trimToString(channel.title) || "Live Channel",
                    url: urlStr,
                    posterUrl: poster,
                    type: "livestream",
                    description,
                    episodes: [
                        new Episode({
                            name: "Live",
                            season: 1,
                            episode: 1,
                            url: urlStr,
                            posterUrl: poster
                        })
                    ]
                })
            });
        } catch (error) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: error && error.message ? error.message : String(error)
            });
        }
    }

    async function loadStreams(urlStr, cb) {
        try {
            const channel = JSON.parse(urlStr);
            const baseHeaders = mergeHeaders({}, channel.headers || {});
            if (trimToString(channel.userAgent) && !baseHeaders["User-Agent"]) {
                baseHeaders["User-Agent"] = channel.userAgent;
            }
            if (trimToString(channel.cookie) && !baseHeaders.Cookie) {
                baseHeaders.Cookie = channel.cookie;
            }
            const playbackChannel = Object.assign({}, channel, {
                headers: baseHeaders
            });
            await resolveChannelDrm(playbackChannel, trimToString(channel.url), baseHeaders);

            const rankedStreams = [];
            const baseSource = trimToString(channel.providerLabel) || "Auto";
            rankedStreams.push({
                score: scoreStream(playbackChannel, baseSource, channel.url, baseHeaders, 0, false),
                order: 0,
                stream: createStreamResult(playbackChannel, baseSource, channel.url, baseHeaders, 0)
            });

            const variants = await expandHlsStreams({
                url: trimToString(channel.url),
                headers: baseHeaders,
                providerLabel: baseSource,
                licenseType: channel.licenseType,
                licenseKey: channel.licenseKey,
                licenseUrl: channel.licenseUrl,
                drmScheme: channel.drmScheme,
                key: channel.key,
                keyid: channel.keyid,
                __resolvedDrm: playbackChannel.__resolvedDrm,
                __resolvedDrmPromise: playbackChannel.__resolvedDrmPromise
            });

            variants.forEach((variant, index) => {
                rankedStreams.push({
                    score: scoreStream(playbackChannel, trimToString(variant.source) || baseSource, variant.url, variant.headers || baseHeaders, typeof variant.quality === "number" ? variant.quality : 0, true),
                    order: index + 1,
                    stream: variant
                });
            });

            rankedStreams.sort((left, right) => {
                if (right.score !== left.score) return right.score - left.score;
                return left.order - right.order;
            });

            cb({
                success: true,
                data: rankedStreams.map((entry) => entry.stream)
            });
        } catch (error) {
            cb({
                success: false,
                errorCode: "STREAM_ERROR",
                message: error && error.message ? error.message : String(error)
            });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
