(function() {
    const DEFAULT_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0",
        "Accept": "*/*",
        "Accept-Language": "en-US,en;q=0.5",
        "Connection": "keep-alive"
    };

    const DEFAULT_PLAYLIST_URLS = [
        "https://ranapk.short.gy/Darktv/playlist.php",
        "https://ranapkbd.site/tvd/2/TVDin.php"
    ];

    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // var manifest is injected at runtime

    function trimToString(value) {
        return typeof value === "string" ? value.trim() : "";
    }

    function safeDecode(value) {
        try {
            return decodeURIComponent(value);
        } catch (e) {
            return value;
        }
    }

    function buildPlaylistCandidates() {
        const candidates = [];
        const configuredBaseUrl = trimToString(manifest && manifest.baseUrl);

        if (configuredBaseUrl && configuredBaseUrl !== "https://example.com") {
            if (
                /\/tvd\/\d+\/TVDin\.php(?:[?#].*)?$/i.test(configuredBaseUrl) ||
                /\.(?:m3u|m3u8|php|txt)(?:[?#].*)?$/i.test(configuredBaseUrl)
            ) {
                candidates.push(configuredBaseUrl);
            } else {
                candidates.push(`${configuredBaseUrl.replace(/\/+$/, "")}/tvd/2/TVDin.php`);
            }
        }

        for (let i = 0; i < DEFAULT_PLAYLIST_URLS.length; i++) {
            candidates.push(DEFAULT_PLAYLIST_URLS[i]);
        }

        const uniqueCandidates = [];
        const seen = {};
        for (let i = 0; i < candidates.length; i++) {
            const url = trimToString(candidates[i]);
            if (!url || seen[url]) continue;
            seen[url] = true;
            uniqueCandidates.push(url);
        }

        return uniqueCandidates;
    }

    function isPlaylistResponse(body) {
        const text = trimToString(body);
        return text.startsWith("#EXTM3U") || text.startsWith("#EXTINF") || text.startsWith("#KODIPROP");
    }

    function getResponseStatus(response) {
        if (!response || typeof response !== "object") return undefined;
        if (response.status !== undefined) return response.status;
        return response.statusCode;
    }

    /**
     * Helper to fetch the M3U playlist.
     */
    async function fetchM3U() {
        const candidates = buildPlaylistCandidates();
        const failures = [];

        for (let i = 0; i < candidates.length; i++) {
            const url = candidates[i];

            try {
                const response = await http_get(url, DEFAULT_HEADERS);
                const status = getResponseStatus(response);
                const body = response && typeof response.body === "string" ? response.body.trim() : "";

                if (status >= 200 && status < 300 && isPlaylistResponse(body)) {
                    return body;
                }

                const bodyPreview = body ? body.slice(0, 120).replace(/\s+/g, " ") : "empty response body";
                failures.push(`${url} -> ${status || "no response"} (${bodyPreview})`);
            } catch (e) {
                failures.push(`${url} -> ${e.message || String(e)}`);
            }
        }

        throw new Error(`Unable to fetch DARK TV playlist. ${failures.join(" | ")}`);
    }

    function splitExtInfLine(line) {
        const payload = line.replace(/^#EXTINF:[^ ]+/, "").trim();
        let lastCommaIndex = -1;
        let insideQuotes = false;

        for (let i = 0; i < payload.length; i++) {
            const char = payload[i];
            if (char === "\"") {
                insideQuotes = !insideQuotes;
            } else if (char === "," && !insideQuotes) {
                lastCommaIndex = i;
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
            const value = (match[2] || match[3] || "").trim();
            if (key) attributes[key] = value;
        }

        return attributes;
    }

    function parseExtHttpLine(line) {
        try {
            return JSON.parse(line.replace(/^#EXTHTTP:/, "").trim());
        } catch (e) {
            return null;
        }
    }

    function parsePipeHeaders(line) {
        const index = line.indexOf("|");
        if (index === -1) {
            return {
                url: line.trim(),
                headers: {},
                userAgent: "",
                cookie: ""
            };
        }

        const headers = {};
        let userAgent = "";
        let cookie = "";
        const url = line.slice(0, index).trim();
        const headerPairs = line.slice(index + 1).split("&");

        for (let i = 0; i < headerPairs.length; i++) {
            const pair = headerPairs[i];
            const separatorIndex = pair.indexOf("=");
            if (separatorIndex === -1) continue;

            const rawKey = pair.slice(0, separatorIndex).trim();
            const rawValue = pair.slice(separatorIndex + 1).trim();
            const key = safeDecode(rawKey);
            const value = safeDecode(rawValue);
            const normalizedKey = key.toLowerCase();

            if (normalizedKey === "user-agent") {
                headers["User-Agent"] = value;
                userAgent = value;
            } else if (normalizedKey === "cookie") {
                headers["Cookie"] = value;
                cookie = value;
            } else if (normalizedKey === "referer" || normalizedKey === "referrer") {
                headers["Referer"] = value;
            } else if (normalizedKey === "origin") {
                headers["Origin"] = value;
            } else {
                headers[key] = value;
            }
        }

        return { url, headers, userAgent, cookie };
    }

    /**
     * Helper to parse M3U string into MultimediaItems organized by category.
     */
    function parseM3U(m3uString) {
        const lines = m3uString.split(/\r?\n/);
        const categories = { "Other Channels": [] };
        let currentChannel = null;

        for (let i = 0; i < lines.length; i++) {
            const line = lines[i].trim();

            if (!line) continue;

            if (line.startsWith("#EXTINF")) {
                const extInfParts = splitExtInfLine(line);
                const attributes = extractAttributes(extInfParts.attributesPart);

                currentChannel = { 
                    title: extInfParts.title,
                    poster: attributes["tvg-logo"] || "",
                    group: attributes["group-title"] || "Other Channels",
                    headers: {},
                    userAgent: "",
                    cookie: "",
                    licenseUrl: ""
                };

                if (!categories[currentChannel.group]) categories[currentChannel.group] = [];
            } else if (line.startsWith("#EXTVLCOPT:http-user-agent=")) {
                if (currentChannel) {
                    currentChannel.userAgent = line.split("=").slice(1).join("=").trim();
                    currentChannel.headers["User-Agent"] = currentChannel.userAgent;
                }
            } else if (line.startsWith("#EXTVLCOPT:http-referrer=") || line.startsWith("#EXTVLCOPT:http-referer=")) {
                if (currentChannel) currentChannel.headers["Referer"] = line.split("=").slice(1).join("=").trim();
            } else if (line.startsWith("#EXTHTTP:")) {
                if (currentChannel) {
                    const extHttp = parseExtHttpLine(line);
                    if (extHttp && typeof extHttp === "object") {
                        if (extHttp["user-agent"]) {
                            currentChannel.userAgent = extHttp["user-agent"];
                            currentChannel.headers["User-Agent"] = extHttp["user-agent"];
                        }
                        if (extHttp.cookie) {
                            currentChannel.cookie = extHttp.cookie;
                            currentChannel.headers["Cookie"] = extHttp.cookie;
                        }
                    }
                }
            } else if (line.startsWith("#KODIPROP:inputstream.adaptive.license_key=")) {
                if (currentChannel) {
                    const licenseValue = line.split("=").slice(1).join("=").trim();
                    if (/^https?:\/\//i.test(licenseValue)) {
                        currentChannel.licenseUrl = licenseValue;
                    }
                }
            } else if (!line.startsWith("#")) {
                if (currentChannel) {
                    const parsedStream = parsePipeHeaders(line);
                    if (!/^https?:\/\//i.test(parsedStream.url)) {
                        currentChannel = null;
                        continue;
                    }

                    currentChannel.url = parsedStream.url;
                    for (const key in parsedStream.headers) {
                        currentChannel.headers[key] = parsedStream.headers[key];
                    }
                    if (!currentChannel.userAgent && parsedStream.userAgent) currentChannel.userAgent = parsedStream.userAgent;
                    if (!currentChannel.cookie && parsedStream.cookie) currentChannel.cookie = parsedStream.cookie;
                    
                    const item = new MultimediaItem({
                        title: currentChannel.title,
                        url: JSON.stringify(currentChannel),
                        posterUrl: currentChannel.poster,
                        type: "livestream",
                        description: `Live Stream from ${currentChannel.group}`,
                        headers: currentChannel.headers
                    });

                    // Ensure .png for placeholders
                    if (!currentChannel.poster || currentChannel.poster.includes("placehold.co")) {
                        item.posterUrl = `https://placehold.co/400x600.png?text=${encodeURIComponent(currentChannel.title)}`;
                    }

                    categories[currentChannel.group].push(item);
                    currentChannel = null;
                }
            }
        }
        
        const finalOutput = {};
        for (const cat in categories) {
            if (categories[cat].length > 0) {
                finalOutput[cat] = categories[cat];
            }
        }
        return finalOutput;
    }

    /**
     * Loads the home screen categories.
     */
    async function getHome(cb) {
        try {
            const m3u = await fetchM3U();
            const data = parseM3U(m3u);
            cb({ success: true, data });
        } catch (e) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: e.message || String(e) });
        }
    }

    /**
     * Searches for media items.
     */
    async function search(query, cb) {
        try {
            const m3u = await fetchM3U();
            const categories = parseM3U(m3u);
            const results = [];
            const q = String(query || "").toLowerCase();
            
            for (const cat in categories) {
                categories[cat].forEach(item => {
                    if (String(item.title || "").toLowerCase().includes(q)) {
                        results.push(item);
                    }
                });
            }
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: e.message || String(e) });
        }
    }

    /**
     * Loads details for a specific media item.
     */
    async function load(url, cb) {
        try {
            let channelData;
            try {
                channelData = JSON.parse(url);
            } catch (e) {
                channelData = { title: "Live Channel", url: url, poster: "", group: "IPTV" };
            }

            const poster = channelData.poster || `https://placehold.co/400x600.png?text=${encodeURIComponent(channelData.title)}`;

            cb({
                success: true,
                data: new MultimediaItem({
                    title: channelData.title,
                    url: url,
                    posterUrl: poster,
                    type: "livestream",
                    description: `Live TV Channel - ${channelData.group}`,
                    headers: channelData.headers || {},
                    episodes: [
                        new Episode({ 
                            name: "Live", 
                            season: 1, 
                            episode: 1, 
                            url: url, 
                            posterUrl: poster 
                        })
                    ]
                })
            });
        } catch (e) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: e.message || String(e) });
        }
    }

    /**
     * Resolves streams for a specific media item or episode.
     */
    async function loadStreams(url, cb) {
        try {
            const channelData = JSON.parse(url);
            const streamHeaders = {};

            if (channelData.headers && typeof channelData.headers === "object") {
                for (const key in channelData.headers) {
                    streamHeaders[key] = channelData.headers[key];
                }
            }
            if (channelData.userAgent && !streamHeaders["User-Agent"]) {
                streamHeaders["User-Agent"] = channelData.userAgent;
            }
            if (channelData.cookie && !streamHeaders["Cookie"]) {
                streamHeaders["Cookie"] = channelData.cookie;
            }

            cb({
                success: true,
                data: [
                    new StreamResult({
                        url: channelData.url,
                        source: "Auto",
                        headers: streamHeaders
                    })
                ]
            });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message || String(e) });
        }
    }

    // Export to global scope
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
