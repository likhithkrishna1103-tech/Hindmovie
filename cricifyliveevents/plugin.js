(function() {
    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // `manifest` is injected by the runtime.

    const MATCH_CARD_API = "https://live-card-png.cricify.workers.dev/";
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
    const KEYS = [
        { key: "M2hIenhZQWdTR0k4L2hhbQ==", iv: "VXFDdmt2amVjRUl6ODQyVg==" },
        { key: "TXFlWUdDVDRBWUtvSEtyVA==", iv: "b0hLclRRdVB4OHpsOG9KKw==" }
    ];

    let activeBaseUrl = null;
    let remoteBaseUrlsPromise = null;

    function normalizeBaseUrl(value) {
        if (!value || typeof value !== "string") return null;
        const normalized = value.trim().replace(/\/+$/, "");
        if (!normalized || /example\.com/i.test(normalized)) return null;
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
                if (extractResponseStatus(response) >= 400) {
                    return [];
                }
                const body = extractResponseBody(response).trim();
                if (!body) return [];

                const data = JSON.parse(body);
                const entries = data && data.entries ? data.entries : {};
                const urls = [];
                const addUrl = (value) => {
                    const normalized = normalizeBaseUrl(value);
                    if (normalized && !urls.includes(normalized)) {
                        urls.push(normalized);
                    }
                };

                addUrl(entries.cric_api2);
                addUrl(entries.cric_api1);
                return urls;
            } catch (error) {
                console.error("Failed to fetch Cricify remote config: " + (error && error.message ? error.message : String(error)));
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

    async function fetchAndDecrypt(url) {
        const host = url.split("//")[1].split("/")[0];
        const response = await http_get(url, {
            "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)",
            Host: host
        });
        if (!response || !response.body) return null;

        const body = String(response.body).trim();
        if (!body) return null;
        if (body.startsWith("{") || body.startsWith("[")) {
            return JSON.parse(body);
        }

        const cleanB64 = body.replace(/\s/g, "");
        for (const keyInfo of KEYS) {
            try {
                const decrypted = await crypto.decryptAES(cleanB64, keyInfo.key, keyInfo.iv);
                if (!decrypted || typeof decrypted !== "string") continue;
                const text = decrypted.trim();
                if (text.startsWith("{") || text.startsWith("[") || text.includes("http")) {
                    return JSON.parse(text);
                }
            } catch (error) {
                console.error("Decryption attempt failed: " + (error && error.message ? error.message : String(error)));
            }
        }

        return null;
    }

    async function fetchCricifyJson(path) {
        const baseUrls = await getBaseUrls();
        for (const baseUrl of baseUrls) {
            try {
                const data = await fetchAndDecrypt(`${baseUrl}${path}`);
                if (data) {
                    activeBaseUrl = baseUrl;
                    return data;
                }
            } catch (error) {
                console.error(`Failed to fetch ${path} from ${baseUrl}: ${error && error.message ? error.message : String(error)}`);
            }
        }
        return null;
    }

    function isPublished(event) {
        if (!event || typeof event.publish === "undefined" || event.publish === null) return true;
        return String(event.publish) === "1";
    }

    function getStatus(info) {
        const now = Date.now();
        const startText = info && info.startTime ? info.startTime.replace(" +0000", "Z").replace(/\//g, "-") : null;
        const endText = info && info.endTime ? info.endTime.replace(" +0000", "Z").replace(/\//g, "-") : null;
        const startTime = startText ? new Date(startText).getTime() : null;
        const endTime = endText ? new Date(endText).getTime() : null;

        if (endTime && now >= endTime) return "✅";
        if (startTime && now >= startTime) return "🔴";
        if (startTime && now < startTime) return "🔜";
        return "🔴";
    }

    function createDisplayTitle(event) {
        const info = event && event.eventInfo ? event.eventInfo : {};
        if (info.teamA && info.teamB) {
            if (info.teamA === info.teamB) return info.teamA;
            return `${info.teamA} vs ${info.teamB}`;
        }
        return event && event.title ? event.title : "Event";
    }

    function generateCard(event) {
        const info = event && event.eventInfo ? event.eventInfo : {};
        const title = encodeURIComponent(info.eventName || event.title || "");
        let url = `${MATCH_CARD_API}?title=${title}&teamA=${encodeURIComponent(info.teamA || "Team A")}&teamB=${encodeURIComponent(info.teamB || "Team B")}`;
        if (info.teamAFlag) url += "&teamAImg=" + encodeURIComponent(info.teamAFlag);
        if (info.teamBFlag) url += "&teamBImg=" + encodeURIComponent(info.teamBFlag);
        if (info.eventLogo) url += "&eventLogo=" + encodeURIComponent(info.eventLogo);
        if (info.startTime) url += "&time=" + encodeURIComponent(info.startTime);
        return url;
    }

    function parseStreamLink(link) {
        const headers = {};
        if (!link || typeof link !== "string") {
            return { url: "", headers };
        }
        if (!link.includes("|")) {
            return { url: link.trim(), headers };
        }

        const parts = link.split("|", 2);
        const headerPart = parts[1] || "";
        headerPart.split("&").forEach((pair) => {
            const keyValue = pair.split("=", 2);
            if (keyValue.length !== 2) return;
            const key = String(keyValue[0] || "").trim();
            if (!key) return;

            let value = String(keyValue[1] || "").trim();
            try {
                value = decodeURIComponent(value);
            } catch (_) {
                // Keep the original value when it is not URI-encoded.
            }

            const normalizedKey = key.toLowerCase() === "user-agent" ? "User-Agent"
                : key.toLowerCase() === "referer" ? "Referer"
                : key.toLowerCase() === "origin" ? "Origin"
                : key.toLowerCase() === "cookie" ? "Cookie"
                : key;
            headers[normalizedKey] = value;
        });

        return { url: String(parts[0] || "").trim(), headers };
    }

    function shouldExpandHlsVariants(url) {
        const text = String(url || "").trim().toLowerCase();
        if (!text || /\.mpd(?:$|[?#])/i.test(text)) return false;
        return /\.m3u8(?:$|[?#])/i.test(text) || text.includes("/hls/") || text.includes("m3u8");
    }

    function parseHlsAttributes(line) {
        const attributes = {};
        const regex = /([A-Z0-9-]+)=("[^"]*"|[^,]*)/g;
        let match;

        while ((match = regex.exec(String(line || ""))) !== null) {
            const key = String(match[1] || "").trim().toUpperCase();
            const value = String(match[2] || "").trim().replace(/^"|"$/g, "");
            if (key) attributes[key] = value;
        }

        return attributes;
    }

    function resolveVariantUrl(baseUrl, variantPath) {
        const target = String(variantPath || "").trim();
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
        const resolution = String(attributes && attributes.RESOLUTION ? attributes.RESOLUTION : "").trim();
        const resolutionMatch = /(\d+)\s*x\s*(\d+)/i.exec(resolution);
        if (resolutionMatch) return parseInt(resolutionMatch[2], 10) || 0;

        const bandwidthValue = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (!bandwidthValue || bandwidthValue < 1) return 0;
        if (bandwidthValue >= 6000000) return 1080;
        if (bandwidthValue >= 3000000) return 720;
        if (bandwidthValue >= 1500000) return 480;
        if (bandwidthValue >= 800000) return 360;
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

        const bandwidthValue = parseInt(attributes && (attributes["AVERAGE-BANDWIDTH"] || attributes.BANDWIDTH || "0"), 10);
        if (bandwidthValue > 0) {
            return {
                quality: 0,
                source: `${baseSource} ${Math.max(1, Math.round(bandwidthValue / 1000))}kbps`
            };
        }

        return {
            quality: 0,
            source: `${baseSource} Variant ${fallbackIndex + 1}`
        };
    }

    function parseHlsMasterPlaylist(manifestText, manifestUrl) {
        const variants = [];
        const lines = String(manifestText || "").split(/\r?\n/);
        let pendingAttributes = null;

        lines.forEach((rawLine) => {
            const line = String(rawLine || "").trim();
            if (!line) return;

            if (line.startsWith("#EXT-X-STREAM-INF:")) {
                pendingAttributes = parseHlsAttributes(line.slice("#EXT-X-STREAM-INF:".length));
                return;
            }

            if (line.startsWith("#")) return;

            if (pendingAttributes) {
                const resolvedUrl = resolveVariantUrl(manifestUrl, line);
                if (resolvedUrl) {
                    variants.push({
                        url: resolvedUrl,
                        attributes: pendingAttributes
                    });
                }
                pendingAttributes = null;
            }
        });

        return variants;
    }

    function applyEventDrm(stream, rawApi) {
        if (!rawApi || !String(rawApi).includes(":")) return;
        const parts = String(rawApi).split(":", 2);
        if (parts.length !== 2) return;
        stream.drmKid = parts[0].replace(/-/g, "");
        stream.drmKey = parts[1].replace(/-/g, "");
        stream.drmType = "clearkey";
    }

    function createEventStreamResult(sourceLabel, parsed, rawApi, quality) {
        const result = new StreamResult({
            source: sourceLabel,
            url: parsed.url,
            headers: parsed.headers
        });
        if (typeof quality === "number" && quality > 0) {
            result.quality = quality;
        }
        applyEventDrm(result, rawApi);
        return result;
    }

    async function expandEventHlsStreams(sourceLabel, parsed, rawApi) {
        if (!parsed || !parsed.url || !shouldExpandHlsVariants(parsed.url)) return [];

        try {
            const response = await http_get(parsed.url, parsed.headers || {});
            if (extractResponseStatus(response) < 200 || extractResponseStatus(response) >= 300) return [];

            const manifestText = extractResponseBody(response).trim();
            if (!manifestText.startsWith("#EXTM3U") || manifestText.indexOf("#EXT-X-STREAM-INF") === -1) return [];

            const variants = parseHlsMasterPlaylist(manifestText, parsed.url);
            const streams = [];
            const seenUrls = {};

            variants.forEach((variant, index) => {
                if (!variant || !variant.url || seenUrls[variant.url]) return;
                seenUrls[variant.url] = true;
                const variantInfo = buildVariantSource(sourceLabel, variant.attributes || {}, index);
                streams.push(createEventStreamResult(variantInfo.source, {
                    url: variant.url,
                    headers: parsed.headers || {}
                }, rawApi, variantInfo.quality));
            });

            return streams;
        } catch (_) {
            return [];
        }
    }

    async function getHome(cb) {
        try {
            const events = (await fetchCricifyJson("/categories/live-events.txt") || []).filter(isPublished);
            if (!events.length) {
                return cb({
                    success: false,
                    errorCode: "SITE_OFFLINE",
                    message: "Failed to load events from the available Cricify hosts"
                });
            }

            const categories = {};
            events.forEach((event) => {
                const rawCategory = (event.eventInfo && event.eventInfo.eventCat) || event.cat || "Other";
                const icon = /cricket/i.test(rawCategory) ? "🏏"
                    : /football/i.test(rawCategory) ? "⚽"
                    : /basketball/i.test(rawCategory) ? "🏀"
                    : /tennis/i.test(rawCategory) ? "🎾"
                    : "📺";
                const category = `${icon} ${rawCategory}`;
                if (!categories[category]) categories[category] = [];

                const displayTitle = createDisplayTitle(event);
                const poster = generateCard(event);
                categories[category].push(new MultimediaItem({
                    title: `${getStatus(event.eventInfo)} ${displayTitle}`,
                    url: JSON.stringify({
                        slug: event.slug,
                        title: displayTitle,
                        poster,
                        eventInfo: event.eventInfo || null
                    }),
                    posterUrl: poster,
                    type: "livestream",
                    description: (event.eventInfo && event.eventInfo.eventName) || event.title || "Live Event"
                }));
            });

            cb({ success: true, data: categories });
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
            const events = (await fetchCricifyJson("/categories/live-events.txt") || []).filter(isPublished);
            if (!events.length) return cb({ success: true, data: [] });

            const loweredQuery = String(query || "").toLowerCase();
            const results = events.filter((event) => {
                const info = event.eventInfo || {};
                const haystack = [
                    event.title,
                    info.teamA,
                    info.teamB,
                    info.eventName,
                    info.eventType
                ].filter(Boolean).join(" ").toLowerCase();
                return haystack.includes(loweredQuery);
            }).map((event) => {
                const displayTitle = createDisplayTitle(event);
                const poster = generateCard(event);
                return new MultimediaItem({
                    title: `${getStatus(event.eventInfo)} ${displayTitle}`,
                    url: JSON.stringify({
                        slug: event.slug,
                        title: displayTitle,
                        poster,
                        eventInfo: event.eventInfo || null
                    }),
                    posterUrl: poster,
                    type: "livestream",
                    description: (event.eventInfo && event.eventInfo.eventName) || event.title || "Live Event"
                });
            });

            cb({ success: true, data: results });
        } catch (_) {
            cb({ success: true, data: [] });
        }
    }

    async function load(urlStr, cb) {
        try {
            const data = JSON.parse(urlStr);
            const plot = `🏆 ${(data.eventInfo && data.eventInfo.eventName) || ""}\n🕐 ${(data.eventInfo && data.eventInfo.startTime) || ""}`;
            cb({
                success: true,
                data: new MultimediaItem({
                    title: data.title,
                    url: urlStr,
                    posterUrl: data.poster,
                    description: plot,
                    type: "livestream",
                    episodes: [new Episode({
                        name: "Watch Live",
                        season: 1,
                        episode: 1,
                        url: urlStr,
                        posterUrl: data.poster
                    })]
                })
            });
        } catch (_) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: "Invalid event data" });
        }
    }

    async function loadStreams(urlStr, cb) {
        try {
            const data = JSON.parse(urlStr);
            if (!data || !data.slug) {
                return cb({ success: false, errorCode: "PARSE_ERROR", message: "Missing event slug" });
            }

            const response = await fetchCricifyJson(`/channels/${String(data.slug).toLowerCase()}.txt`);
            const streams = [];
            const streamUrls = response && Array.isArray(response.streamUrls) ? response.streamUrls : [];

            streamUrls.forEach((stream, index) => {
                const parsed = parseStreamLink(stream && stream.link);
                if (!parsed.url) return;
                const sourceLabel = (stream && stream.title) || `Server ${index + 1}`;
                const rawApi = stream && stream.type === "7" ? stream.api : "";
                streams.push(createEventStreamResult(sourceLabel, parsed, rawApi, 0));
            });

            const expandedGroups = await Promise.all(streamUrls.map(async (stream, index) => {
                const parsed = parseStreamLink(stream && stream.link);
                if (!parsed.url) return [];
                const sourceLabel = (stream && stream.title) || `Server ${index + 1}`;
                const rawApi = stream && stream.type === "7" ? stream.api : "";
                const variants = await expandEventHlsStreams(sourceLabel, parsed, rawApi);
                if (!variants.length) return [];
                return [createEventStreamResult(`${sourceLabel} Auto`, parsed, rawApi, 0)].concat(variants);
            }));

            const expandedStreams = [];
            expandedGroups.forEach((group) => {
                if (Array.isArray(group) && group.length) {
                    group.forEach((item) => expandedStreams.push(item));
                }
            });

            cb({ success: true, data: expandedStreams.length ? expandedStreams : streams });
        } catch (error) {
            cb({
                success: false,
                errorCode: "PARSE_ERROR",
                message: "Failed to load streams: " + (error && error.message ? error.message : String(error))
            });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
