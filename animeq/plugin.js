(function () {
    "use strict";

    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    var BASE_URL = (((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://animeq.net") + "").replace(/\/+$/, "");
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";
    
    var DEFAULT_HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/"
    };

    var JSON_HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "application/json, text/javascript, */*; q=0.01",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/"
    };

    // AES Keys for Vidstack player hosts (animeshd, strp2p, rpmplay, etc.)
    var AES_KEY_BYTES = new Uint8Array([107, 105, 101, 109, 116, 105, 101, 110, 109, 117, 97, 57, 49, 49, 99, 97]); // "kiemtienmua911ca"
    var AES_IV_BYTES = new Uint8Array([49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 111, 105, 117, 121, 116, 114]);  // "1234567890oiuytr"

    // Zero-dependency pure JS AES-128 tables
    var SBOX_INV = new Uint8Array([
        0x52,0x09,0x6a,0xd5,0x30,0x36,0xa5,0x38,0xbf,0x40,0xa3,0x9e,0x81,0xf3,0xd7,0xfb,
        0x7c,0xe3,0x39,0x82,0x9b,0x2f,0xff,0x87,0x34,0x8e,0x43,0x44,0xc4,0xde,0xe9,0xcb,
        0x54,0x7b,0x94,0x32,0xa6,0xc2,0x23,0x3d,0xee,0x4c,0x95,0x0b,0x42,0xfa,0xc3,0x4e,
        0x08,0x2e,0xa1,0x66,0x28,0xd9,0x24,0xb2,0x76,0x5b,0xa2,0x49,0x6d,0x8b,0xd1,0x25,
        0x72,0xf8,0xf6,0x64,0x86,0x68,0x98,0x16,0xd4,0xa4,0x5c,0xcc,0x5d,0x65,0xb6,0x92,
        0x6c,0x70,0x48,0x50,0xfd,0xed,0xb9,0xda,0x5e,0x15,0x46,0x57,0xa7,0x8d,0x9d,0x84,
        0x90,0xd8,0xab,0x00,0x8c,0xbc,0xd3,0x0a,0xf7,0xe4,0x58,0x05,0xb8,0xb3,0x45,0x06,
        0xd0,0x2c,0x1e,0x8f,0xca,0x3f,0x0f,0x02,0xc1,0xaf,0xbd,0x03,0x01,0x13,0x8a,0x6b,
        0x3a,0x91,0x11,0x41,0x4f,0x67,0xdc,0xea,0x97,0xf2,0xcf,0xce,0xf0,0xb4,0xe6,0x73,
        0x96,0xac,0x74,0x22,0xe7,0xad,0x35,0x85,0xe2,0xf9,0x37,0xe8,0x1c,0x75,0xdf,0x6e,
        0x47,0xf1,0x1a,0x71,0x1d,0x29,0xc5,0x89,0x6f,0xb7,0x62,0x0e,0xaa,0x18,0xbe,0x1b,
        0xfc,0x56,0x3e,0x4b,0xc6,0xd2,0x79,0x20,0x9a,0xdb,0xc0,0xfe,0x78,0xcd,0x5a,0xf4,
        0x1f,0xdd,0xa8,0x33,0x88,0x07,0xc7,0x31,0xb1,0x12,0x10,0x59,0x27,0x80,0xec,0x5f,
        0x60,0x51,0x7f,0xa9,0x19,0xb5,0x4a,0x0d,0x2d,0xe5,0x7a,0x9f,0x93,0xc9,0x9c,0xef,
        0xa0,0xe0,0x3b,0x4d,0xae,0x2a,0xf5,0xb0,0xc8,0xeb,0xbb,0x3c,0x83,0x53,0x99,0x61,
        0x17,0x2b,0x04,0x7e,0xba,0x77,0xd6,0x26,0xe1,0x69,0x14,0x63,0x55,0x21,0x0c,0x7d
    ]);

    var SBOX = new Uint8Array([
        0x63,0x7c,0x77,0x7b,0xf2,0x6b,0x6f,0xc5,0x30,0x01,0x67,0x2b,0xfe,0xd7,0xab,0x76,
        0xca,0x82,0xc9,0x7d,0xfa,0x59,0x47,0xf0,0xad,0xd4,0xa2,0xaf,0x9c,0xa4,0x72,0xc0,
        0xb7,0xfd,0x93,0x26,0x36,0x3f,0xf7,0xcc,0x34,0xa5,0xe5,0xf1,0x71,0xd8,0x31,0x15,
        0x04,0xc7,0x23,0xc3,0x18,0x96,0x05,0x9a,0x07,0x12,0x80,0xe2,0xeb,0x27,0xb2,0x75,
        0x09,0x83,0x2c,0x1a,0x1b,0x6e,0x5a,0xa0,0x52,0x3b,0xd6,0xb3,0x29,0xe3,0x2f,0x84,
        0x53,0xd1,0x00,0xed,0x20,0xfc,0xb1,0x5b,0x6a,0xcb,0xbe,0x39,0x4a,0x4c,0x58,0xcf,
        0xd0,0xef,0xaa,0xfb,0x43,0x4d,0x33,0x85,0x45,0xf9,0x02,0x7f,0x50,0x3c,0x9f,0xa8,
        0x51,0xa3,0x40,0x8f,0x92,0x9d,0x38,0xf5,0xbc,0xb6,0xda,0x21,0x10,0xff,0xf3,0xd2,
        0xcd,0x0c,0x13,0xec,0x5f,0x97,0x44,0x17,0xc4,0xa7,0x7e,0x3d,0x64,0x5d,0x19,0x73,
        0x60,0x81,0x4f,0xdc,0x22,0x2a,0x90,0x88,0x46,0xee,0xb8,0x14,0xde,0x5e,0x0b,0xdb,
        0xe0,0x32,0x3a,0x0a,0x49,0x06,0x24,0x5c,0xc2,0xd3,0xac,0x62,0x91,0x95,0xe4,0x79,
        0xe7,0xc8,0x37,0x6d,0x8d,0xd5,0x4e,0xa9,0x6c,0x56,0xf4,0xea,0x65,0x7a,0xae,0x08,
        0xba,0x78,0x25,0x2e,0x1c,0xa6,0xb4,0xc6,0xe8,0xdd,0x74,0x1f,0x4b,0xbd,0x8b,0x8a,
        0x70,0x3e,0xb5,0x66,0x48,0x03,0xf6,0x0e,0x61,0x35,0x57,0xb9,0x86,0xc1,0x1d,0x9e,
        0xe1,0xf8,0x98,0x11,0x69,0xd9,0x8e,0x94,0x9b,0x1e,0x87,0xe9,0xce,0x55,0x28,0xdf,
        0x8c,0xa1,0x89,0x0d,0xbf,0xe6,0x42,0x68,0x41,0x99,0x2d,0x0f,0xb0,0x54,0xbb,0x16
    ]);

    var RCON = new Uint8Array([0x00, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b, 0x36]);

    function galMul(a, b) {
        var p = 0;
        for (var counter = 0; counter < 8; counter++) {
            if ((b & 1) !== 0) p ^= a;
            var hi = (a & 0x80);
            a = (a << 1) & 0xff;
            if (hi !== 0) a ^= 0x1b;
            b >>= 1;
        }
        return p;
    }

    function keyExpansion(key) {
        var w = new Uint32Array(44);
        for (var i = 0; i < 4; i++) {
            w[i] = (key[4 * i] << 24) | (key[4 * i + 1] << 16) | (key[4 * i + 2] << 8) | key[4 * i + 3];
        }
        for (var i = 4; i < 44; i++) {
            var temp = w[i - 1];
            if (i % 4 === 0) {
                temp = ((SBOX[(temp >> 16) & 0xff] << 24) |
                        (SBOX[(temp >> 8) & 0xff] << 16) |
                        (SBOX[temp & 0xff] << 8) |
                        SBOX[(temp >> 24) & 0xff]) ^ (RCON[i / 4] << 24);
            }
            w[i] = w[i - 4] ^ temp;
        }
        return w;
    }

    function invCipher(block, w) {
        var state = new Uint8Array(16);
        for (var i = 0; i < 16; i++) state[i] = block[i];

        for (var c = 0; c < 4; c++) {
            var kw = w[40 + c];
            state[c * 4] ^= (kw >> 24) & 0xff;
            state[c * 4 + 1] ^= (kw >> 16) & 0xff;
            state[c * 4 + 2] ^= (kw >> 8) & 0xff;
            state[c * 4 + 3] ^= kw & 0xff;
        }

        for (var round = 9; round >= 1; round--) {
            var tmp = state[13]; state[13] = state[9]; state[9] = state[5]; state[5] = state[1]; state[1] = tmp;
            tmp = state[2]; var tmp2 = state[6]; state[2] = state[10]; state[6] = state[14]; state[10] = tmp; state[14] = tmp2;
            tmp = state[3]; state[3] = state[7]; state[7] = state[11]; state[11] = state[15]; state[15] = tmp;

            for (var i = 0; i < 16; i++) state[i] = SBOX_INV[state[i]];

            for (var c = 0; c < 4; c++) {
                var kw = w[round * 4 + c];
                state[c * 4] ^= (kw >> 24) & 0xff;
                state[c * 4 + 1] ^= (kw >> 16) & 0xff;
                state[c * 4 + 2] ^= (kw >> 8) & 0xff;
                state[c * 4 + 3] ^= kw & 0xff;
            }

            for (var c = 0; c < 4; c++) {
                var s0 = state[c * 4], s1 = state[c * 4 + 1], s2 = state[c * 4 + 2], s3 = state[c * 4 + 3];
                state[c * 4]     = galMul(s0, 0x0e) ^ galMul(s1, 0x0b) ^ galMul(s2, 0x0d) ^ galMul(s3, 0x09);
                state[c * 4 + 1] = galMul(s0, 0x09) ^ galMul(s1, 0x0e) ^ galMul(s2, 0x0b) ^ galMul(s3, 0x0d);
                state[c * 4 + 2] = galMul(s0, 0x0d) ^ galMul(s1, 0x09) ^ galMul(s2, 0x0e) ^ galMul(s3, 0x0b);
                state[c * 4 + 3] = galMul(s0, 0x0b) ^ galMul(s1, 0x0d) ^ galMul(s2, 0x09) ^ galMul(s3, 0x0e);
            }
        }

        var tmp = state[13]; state[13] = state[9]; state[9] = state[5]; state[5] = state[1]; state[1] = tmp;
        tmp = state[2]; var tmp2 = state[6]; state[2] = state[10]; state[6] = state[14]; state[10] = tmp; state[14] = tmp2;
        tmp = state[3]; state[3] = state[7]; state[7] = state[11]; state[11] = state[15]; state[15] = tmp;

        for (var i = 0; i < 16; i++) state[i] = SBOX_INV[state[i]];

        for (var c = 0; c < 4; c++) {
            var kw = w[c];
            state[c * 4] ^= (kw >> 24) & 0xff;
            state[c * 4 + 1] ^= (kw >> 16) & 0xff;
            state[c * 4 + 2] ^= (kw >> 8) & 0xff;
            state[c * 4 + 3] ^= kw & 0xff;
        }

        return state;
    }

    function aes128CbcDecryptPure(encryptedBuf, keyBuf, ivBuf) {
        var w = keyExpansion(keyBuf);
        var numBlocks = Math.floor(encryptedBuf.length / 16);
        if (numBlocks === 0) return null;
        var decrypted = new Uint8Array(numBlocks * 16);
        var prevBlock = ivBuf;

        for (var b = 0; b < numBlocks; b++) {
            var cipherBlock = encryptedBuf.subarray(b * 16, b * 16 + 16);
            var decBlock = invCipher(cipherBlock, w);
            for (var i = 0; i < 16; i++) {
                decrypted[b * 16 + i] = decBlock[i] ^ prevBlock[i];
            }
            prevBlock = cipherBlock;
        }

        var padLen = decrypted[decrypted.length - 1];
        if (padLen > 0 && padLen <= 16) {
            var valid = true;
            for (var p = decrypted.length - padLen; p < decrypted.length; p++) {
                if (decrypted[p] !== padLen) { valid = false; break; }
            }
            if (valid) return decrypted.subarray(0, decrypted.length - padLen);
        }
        return decrypted;
    }

    // Helper functions
    function trim(value) {
        return String(value == null ? "" : value).trim();
    }

    function sanitizeUrl(url) {
        var str = String(url || "").replace(/[\r\n\t]+/g, "").trim();
        if (!str) return "";
        return str.replace(/\s+/g, "%20");
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&#8211;/g, "-")
            .replace(/&nbsp;/g, " ");
    }

    function cleanText(value) {
        return decodeHtml(String(value || "")
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<[^>]+>/g, " "))
            .replace(/\s+/g, " ")
            .trim();
    }

    function absoluteUrl(path) {
        path = trim(path);
        if (!path) return "";
        if (/^https?:\/\//i.test(path)) return path;
        if (path.indexOf("//") === 0) return "https:" + path;
        if (path.indexOf("/") === 0) return BASE_URL + path;
        return BASE_URL + "/" + path;
    }

    function uint8ToString(uint8Array) {
        if (typeof TextDecoder !== "undefined") {
            try {
                return new TextDecoder("utf-8").decode(uint8Array);
            } catch (_) {}
        }
        var str = "";
        var chunk = 1024;
        for (var i = 0; i < uint8Array.length; i += chunk) {
            var sub = uint8Array.subarray(i, i + chunk);
            str += String.fromCharCode.apply(null, sub);
        }
        return str;
    }

    async function httpFetchText(url, extraHeaders) {
        var headers = Object.assign({}, DEFAULT_HEADERS, extraHeaders || {});
        if (typeof http_get === "function") {
            var res = await http_get(url, headers);
            if (typeof res === "string") return res;
            if (res && res.body) return res.body;
            if (res && typeof res.text === "function") return await res.text();
            return "";
        } else if (typeof fetch === "function") {
            var fRes = await fetch(url, { headers: headers });
            if (fRes.ok) return await fRes.text();
            return "";
        }
        return "";
    }

    async function httpFetchJson(url, extraHeaders) {
        var headers = Object.assign({}, JSON_HEADERS, extraHeaders || {});
        if (typeof http_get === "function") {
            var res = await http_get(url, headers);
            var bodyText = "";
            if (typeof res === "string") bodyText = res;
            else if (res && res.body) bodyText = res.body;
            
            if (bodyText) {
                try {
                    return JSON.parse(bodyText);
                } catch (_) {
                    return null;
                }
            }
            return null;
        } else if (typeof fetch === "function") {
            var fRes = await fetch(url, { headers: headers });
            if (fRes.ok) return await fRes.json();
            return null;
        }
        return null;
    }

    /**
     * AES-128-CBC Decryption Helper using Pure JS (Zero external dependencies)
     */
    async function aes128CbcDecrypt(hexStr) {
        try {
            var match = String(hexStr || "").match(/[\da-f]{2}/gi);
            if (!match) return null;
            var inputArr = new Uint8Array(match.map(function (h) { return parseInt(h, 16); }));

            var decBuf = aes128CbcDecryptPure(inputArr, AES_KEY_BYTES, AES_IV_BYTES);
            if (!decBuf) return null;

            var str = uint8ToString(decBuf);
            return JSON.parse(str);
        } catch (_) {}
        return null;
    }

    /**
     * Resolves embed URLs into direct streamable .m3u8 or .mp4 links
     */
    async function resolveEmbedUrl(embedUrl) {
        var results = [];
        if (!embedUrl) return results;
        embedUrl = sanitizeUrl(embedUrl);

        // 1. Direct source query parameter (jwplayer?source=...)
        if (embedUrl.indexOf("source=") !== -1) {
            var sourceMatch = embedUrl.match(/source=([^&]+)/i);
            if (sourceMatch) {
                try {
                    var sUrl = sanitizeUrl(decodeURIComponent(decodeURIComponent(sourceMatch[1])));
                    results.push({ url: sUrl, quality: "", refererHost: "" });
                } catch (_) {
                    var sUrl2 = sanitizeUrl(decodeURIComponent(sourceMatch[1]));
                    results.push({ url: sUrl2, quality: "", refererHost: "" });
                }
            }
        } else if (/\.(mp4|m3u8)($|\?)/i.test(embedUrl)) {
            results.push({ url: embedUrl, quality: "", refererHost: "" });
        }

        // 2. Vidstack Player Hosts AES-128 Decryption (animeshd, strp2p, rpmplay, etc.)
        if (embedUrl.indexOf("#") !== -1 || /(?:animeshd|strp2p|rpmplay|stellarwebconcepts)/i.test(embedUrl)) {
            try {
                var embedHost = "";
                var embedId = "";

                var hashIdx = embedUrl.indexOf("#");
                if (hashIdx !== -1) {
                    embedId = embedUrl.substring(hashIdx + 1).split("?")[0].split("&")[0];
                }
                var hostMatch = embedUrl.match(/https?:\/\/([^\/]+)/i);
                if (hostMatch) embedHost = hostMatch[1];

                if (embedHost && embedId) {
                    var api1Url = "https://" + embedHost + "/api/v1/video?id=" + embedId;
                    var api2Url = "https://" + embedHost + "/api/v1/download?id=" + embedId;
                    var refHeader = {
                        "User-Agent": USER_AGENT,
                        "Accept": "application/json, text/plain, */*",
                        "Referer": "https://" + embedHost + "/",
                        "Origin": "https://" + embedHost
                    };

                    var text1 = await httpFetchText(api1Url, refHeader);
                    if (text1) {
                        try {
                            var data1 = await aes128CbcDecrypt(text1);
                            if (data1 && data1.source) {
                                results.push({ url: sanitizeUrl(data1.source), quality: " (HLS Stream)", refererHost: embedHost });
                            }
                        } catch (_) {}
                    }

                    var text2 = await httpFetchText(api2Url, refHeader);
                    if (text2) {
                        try {
                            var data2 = await aes128CbcDecrypt(text2);
                            if (data2 && data2.mp4) {
                                results.push({ url: sanitizeUrl(data2.mp4), quality: " (1080p MP4)", refererHost: embedHost });
                            }
                        } catch (_) {}
                    }
                }
            } catch (_) {}
        }

        // 3. DoodStream Extractor
        if (/dood\.|doodstream|ds2play/i.test(embedUrl)) {
            try {
                var doodBody = await httpFetchText(embedUrl, { "User-Agent": USER_AGENT });
                if (doodBody) {
                    var md5Match = /\/pass_md5\/[^\s"'`<\\]*/.exec(doodBody);
                    if (md5Match) {
                        var doodHostMatch = embedUrl.match(/https?:\/\/([^\/]+)/i);
                        if (doodHostMatch) {
                            var doodHost = doodHostMatch[1];
                            var md5Url = "https://" + doodHost + md5Match[0];
                            var tokenData = await httpFetchText(md5Url, { "User-Agent": USER_AGENT, "Referer": embedUrl });
                            if (tokenData && tokenData.indexOf("http") === 0) {
                                var randomStr = Math.random().toString(36).substring(2, 12);
                                var passToken = md5Match[0].split("/").pop();
                                var directDoodUrl = sanitizeUrl(tokenData + randomStr + "?token=" + passToken + "&expiry=" + Date.now());
                                results.push({ url: directDoodUrl, quality: " (DoodStream Direct MP4)", refererHost: doodHost });
                            }
                        }
                    }
                }
            } catch (_) {}
        }

        // Fallback: If no direct stream could be decrypted, return raw embedUrl
        if (results.length === 0) {
            results.push({ url: embedUrl, quality: "", refererHost: "" });
        }

        return results;
    }

    /**
     * Parses articles (cards) from DooPlay HTML blocks
     */
    function parseArticlesFromHtml(html) {
        var items = [];
        var seenUrls = {};
        var articleRegex = /<article[^>]*>([\s\S]*?)<\/article>/gi;
        var match;

        while ((match = articleRegex.exec(html)) !== null) {
            var artHtml = match[1];

            var hrefMatch = artHtml.match(/href=["'](https:\/\/animeq\.net\/[^"']+)["']/i) || artHtml.match(/href=["'](\/[^"']+)["']/i);
            var imgMatch = artHtml.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
            var titleMatch = artHtml.match(/<h3>\s*<a[^>]*>([\s\S]*?)<\/a>/i) || artHtml.match(/alt=["']([^"']+)["']/i) || artHtml.match(/title=["']([^"']+)["']/i);

            if (hrefMatch) {
                var url = absoluteUrl(hrefMatch[1]);
                if (seenUrls[url]) continue;
                seenUrls[url] = true;

                var title = titleMatch ? cleanText(titleMatch[1]) : "";
                var posterUrl = imgMatch ? absoluteUrl(imgMatch[1]) : "";

                var type = "anime";
                if (url.indexOf("/filme/") !== -1) {
                    type = "movie";
                }

                if (title && url) {
                    items.push(new MultimediaItem({
                        title: title,
                        url: url,
                        posterUrl: posterUrl,
                        type: type,
                        headers: { "Referer": BASE_URL + "/" }
                    }));
                }
            }
        }
        return items;
    }

    /**
     * Loads the home screen categories.
     * @param {(res: Response) => void} cb 
     */
    async function getHome(cb) {
        try {
            var html = await httpFetchText(BASE_URL + "/");
            if (!html) {
                return cb({ success: false, errorCode: "FETCH_ERROR", message: "Failed to fetch home page" });
            }

            var result = {};
            var parts = html.split(/<header>/gi);

            for (var i = 1; i < parts.length; i++) {
                var part = parts[i];
                var titleMatch = part.match(/<h[23][^>]*>([\s\S]*?)<\/h[23]>/i);
                if (!titleMatch) continue;

                var secTitle = cleanText(titleMatch[1]);
                if (!secTitle || secTitle.indexOf("Glossary") !== -1 || secTitle.indexOf("Histórico") !== -1 || secTitle.indexOf("Menu") !== -1 || secTitle.indexOf("Parceiros") !== -1 || secTitle.indexOf("EM ALTA") !== -1) {
                    continue;
                }

                var items = parseArticlesFromHtml(part);
                if (items.length > 0) {
                    var key = secTitle;
                    if (secTitle.indexOf("Animes Adicionados") !== -1) {
                        key = "Trending";
                    } else if (secTitle.indexOf("Lançamentos de Animes") !== -1) {
                        key = "Latest Episodes";
                    } else if (secTitle.indexOf("Filmes e Especiais") !== -1) {
                        key = "Movies & Specials";
                    }

                    result[key] = items;
                }
            }

            if (!result["Trending"]) {
                var keys = Object.keys(result);
                if (keys.length > 0) {
                    result["Trending"] = result[keys[0]];
                }
            }

            cb({ success: true, data: result });
        } catch (e) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: String(e.stack || e) });
        }
    }

    /**
     * Searches for media items.
     * @param {string} query
     * @param {(res: Response) => void} cb 
     */
    async function search(query, cb) {
        try {
            var q = trim(query);
            if (!q) {
                return cb({ success: true, data: [] });
            }

            var searchUrl = BASE_URL + "/?s=" + encodeURIComponent(q);
            var html = await httpFetchText(searchUrl);
            if (!html) {
                return cb({ success: true, data: [] });
            }

            var results = [];
            var seenUrls = {};

            var articleRegex = /<article[^>]*>([\s\S]*?)<\/article>/gi;
            var match;

            while ((match = articleRegex.exec(html)) !== null) {
                var artHtml = match[1];

                var hrefMatch = artHtml.match(/href=["'](https:\/\/animeq\.net\/[^"']+)["']/i) || artHtml.match(/href=["'](\/[^"']+)["']/i);
                var imgMatch = artHtml.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
                var titleMatch = artHtml.match(/<h3>\s*<a[^>]*>([\s\S]*?)<\/a>/i) || artHtml.match(/alt=["']([^"']+)["']/i) || artHtml.match(/title=["']([^"']+)["']/i);
                var descMatch = artHtml.match(/<div class=["']contenido["'][^>]*>([\s\S]*?)<\/div>/i) || artHtml.match(/<p>([\s\S]*?)<\/p>/i);

                if (hrefMatch) {
                    var url = absoluteUrl(hrefMatch[1]);
                    if (seenUrls[url]) continue;
                    seenUrls[url] = true;

                    var title = titleMatch ? cleanText(titleMatch[1]) : "";
                    var posterUrl = imgMatch ? absoluteUrl(imgMatch[1]) : "";
                    var description = descMatch ? cleanText(descMatch[1]) : "";

                    var type = "anime";
                    if (url.indexOf("/filme/") !== -1) {
                        type = "movie";
                    }

                    if (title && url) {
                        results.push(new MultimediaItem({
                            title: title,
                            url: url,
                            posterUrl: posterUrl,
                            type: type,
                            description: description,
                            headers: { "Referer": BASE_URL + "/" }
                        }));
                    }
                }
            }

            if (results.length === 0) {
                var itemRegex = /<div class=["']result-item["']>([\s\S]*?)<\/div>\s*<\/div>/gi;
                while ((match = itemRegex.exec(html)) !== null) {
                    var itemHtml = match[1];
                    var rHref = itemHtml.match(/href=["'](https:\/\/animeq\.net\/[^"']+)["']/i) || itemHtml.match(/href=["'](\/[^"']+)["']/i);
                    var rImg = itemHtml.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
                    var rTitle = itemHtml.match(/<div class=["']title["'][^>]*>\s*<a[^>]*>([\s\S]*?)<\/a>/i);
                    var rDesc = itemHtml.match(/<div class=["']contenido["'][^>]*>([\s\S]*?)<\/div>/i);

                    if (rHref) {
                        var rUrl = absoluteUrl(rHref[1]);
                        if (seenUrls[rUrl]) continue;
                        seenUrls[rUrl] = true;

                        var rTitleStr = rTitle ? cleanText(rTitle[1]) : "";
                        var rPosterStr = rImg ? absoluteUrl(rImg[1]) : "";
                        var rDescStr = rDesc ? cleanText(rDesc[1]) : "";
                        var rType = rUrl.indexOf("/filme/") !== -1 ? "movie" : "anime";

                        if (rTitleStr && rUrl) {
                            results.push(new MultimediaItem({
                                title: rTitleStr,
                                url: rUrl,
                                posterUrl: rPosterStr,
                                type: rType,
                                description: rDescStr,
                                headers: { "Referer": BASE_URL + "/" }
                            }));
                        }
                    }
                }
            }

            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e.stack || e) });
        }
    }

    /**
     * Loads details for a specific media item.
     * @param {string} url
     * @param {(res: Response) => void} cb 
     */
    async function load(url, cb) {
        try {
            var html = await httpFetchText(url);
            if (!html) {
                return cb({ success: false, errorCode: "LOAD_ERROR", message: "Failed to load page details" });
            }

            // Extract Title
            var title = "";
            var h1Match = html.match(/<div class=["']data["'][^>]*>\s*<h1>([\s\S]*?)<\/h1>/i) ||
                          html.match(/<h1>(?!\s*<div class=["']dt-breadcrumb)([\s\S]*?)<\/h1>/i) ||
                          html.match(/property=["']og:title["']\s+content=["']([^"']+)["']/i);
            if (h1Match) {
                title = cleanText(h1Match[1]);
            }

            // Extract Poster
            var posterUrl = "";
            var posterMatch = html.match(/<div class=["']poster["'][^>]*>\s*<img[^>]+(?:data-src|src)=["']([^"']+)["']/i) ||
                                html.match(/property=["']og:image["']\s+content=["']([^"']+)["']/i);
            if (posterMatch) {
                posterUrl = absoluteUrl(posterMatch[1]);
            }

            // Description / Sinopse
            var description = "";
            var descMatch = html.match(/<div class=["']wp-content["'][^>]*>([\s\S]*?)<\/div>/i) ||
                              html.match(/<div id=["']info["'][^>]*>([\s\S]*?)<\/div>/i);
            if (descMatch) {
                description = cleanText(descMatch[1]);
            }

            // Rating / Score
            var score = 0;
            var ratingMatch = html.match(/<span class=["']dt_rating_v["'][^>]*>([\d\.]+)<\/span>/i) ||
                                html.match(/<div class=["']rating["'][^>]*>([\d\.]+)<\/div>/i);
            if (ratingMatch) {
                score = parseFloat(ratingMatch[1]) || 0;
            }

            // Release Year
            var year = 0;
            var yearMatch = html.match(/<span class=["']date["'][^>]*>(\d{4})<\/span>/i) ||
                              html.match(/Ano de Lançamento:\s*(\d{4})/i) ||
                              html.match(/\/(\d{4})\//);
            if (yearMatch) {
                year = parseInt(yearMatch[1], 10) || 0;
            }

            // Genres / Tags
            var tags = [];
            var genreRegex = /href=["']https:\/\/animeq\.net\/genre\/([^"']+)["'][^>]*>([^<]+)<\/a>/gi;
            var gMatch;
            while ((gMatch = genreRegex.exec(html)) !== null) {
                var tag = cleanText(gMatch[2]);
                if (tag && tags.indexOf(tag) === -1) {
                    tags.push(tag);
                }
            }

            // Status
            var status = "ongoing";
            if (html.indexOf("Finalizado") !== -1 || html.indexOf("Completo") !== -1) {
                status = "completed";
            }

            // Media Type
            var isMovie = url.indexOf("/filme/") !== -1 || html.indexOf('class="movies"') !== -1 || html.indexOf('class="single-movies"') !== -1;
            var type = isMovie ? "movie" : "anime";

            // Extract Episode List for Anime Series
            var episodes = [];
            if (!isMovie) {
                var epRegex = /<a\s+[^>]*href=["'](https:\/\/animeq\.net\/episodio\/[^"']+)["'][^>]*>(?:<img[^>]+src=["']([^"']+)["'][^>]*alt=["']([^"']*)["'][^>]*>|([\s\S]*?))<\/a>/gi;
                var epMatch;
                var epMap = {};
                var epOrder = [];

                while ((epMatch = epRegex.exec(html)) !== null) {
                    var epUrl = absoluteUrl(epMatch[1]);
                    var imgPoster = epMatch[2] ? absoluteUrl(epMatch[2]) : "";
                    var imgAlt = epMatch[3] ? cleanText(epMatch[3]) : "";
                    var textContent = epMatch[4] ? cleanText(epMatch[4]) : "";

                    if (!epMap[epUrl]) {
                        epMap[epUrl] = { title: "", posterUrl: "" };
                        epOrder.push(epUrl);
                    }

                    if (imgPoster) epMap[epUrl].posterUrl = imgPoster;
                    if (imgAlt && !epMap[epUrl].title) epMap[epUrl].title = imgAlt;
                    if (textContent && !epMap[epUrl].title) epMap[epUrl].title = textContent;
                }

                var defaultDub = title.toLowerCase().indexOf("dublado") !== -1 ? "dub" : "sub";

                for (var eIdx = 0; eIdx < epOrder.length; eIdx++) {
                    var eUrl = epOrder[eIdx];
                    var eData = epMap[eUrl];
                    var epTitle = eData.title;

                    var numMatch = epTitle.match(/episódio\s*(\d+)/i) || epTitle.match(/ep\s*(\d+)/i) || eUrl.match(/episodio-(\d+)/i) || epTitle.match(/(\d+)/);
                    var epNum = numMatch ? parseInt(numMatch[1], 10) : (eIdx + 1);

                    if (!epTitle) epTitle = "Episódio " + epNum;

                    var dubStatus = defaultDub;
                    if (epTitle.toLowerCase().indexOf("dublado") !== -1 || eUrl.toLowerCase().indexOf("dublado") !== -1) {
                        dubStatus = "dub";
                    }

                    episodes.push(new Episode({
                        name: epTitle,
                        url: eUrl,
                        season: 1,
                        episode: epNum,
                        posterUrl: eData.posterUrl || posterUrl,
                        dubStatus: dubStatus,
                        headers: { "Referer": BASE_URL + "/" }
                    }));
                }
            }

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: posterUrl,
                bannerUrl: posterUrl,
                type: type,
                description: description,
                year: year,
                score: score,
                status: status,
                tags: tags.length ? tags : undefined,
                episodes: episodes,
                headers: { "Referer": BASE_URL + "/" }
            });

            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e.stack || e) });
        }
    }

    /**
     * Resolves streams for a specific media item or episode in PARALLEL.
     * Decrypts iframe embed URLs into direct .m3u8 & .mp4 links with proper host Referer headers & URL encoding.
     * @param {string} url
     * @param {(res: Response) => void} cb 
     */
    async function loadStreams(url, cb) {
        try {
            var html = await httpFetchText(url);
            if (!html) {
                return cb({ success: false, errorCode: "STREAM_ERROR", message: "Failed to fetch stream page HTML" });
            }

            // Extract Post ID from page HTML
            var postIdMatch = html.match(/data-post=["'](\d+)["']/i) ||
                              html.match(/"post_id"\s*:\s*(\d+)/i) ||
                              html.match(/data-postid=["'](\d+)["']/i);
            var postId = postIdMatch ? postIdMatch[1] : null;

            if (!postId) {
                return cb({ success: false, errorCode: "STREAM_ERROR", message: "Post ID not found" });
            }

            // Extract all Player option tabs from HTML
            var options = [];
            var playerOptRegex = /<li[^>]*data-type=["']([^"']+)["'][^>]*data-nume=["']([^"']+)["'][^>]*>([\s\S]*?)<\/li>/gi;
            var optMatch;

            while ((optMatch = playerOptRegex.exec(html)) !== null) {
                var optType = optMatch[1];
                var optNume = optMatch[2];
                var optLabel = cleanText(optMatch[3]);
                options.push({ type: optType, nume: optNume, label: optLabel });
            }

            // Fallback options if none explicitly parsed from HTML
            if (options.length === 0) {
                options.push(
                    { type: "tv", nume: "1", label: "" },
                    { type: "tv", nume: "2", label: "" },
                    { type: "tv", nume: "3", label: "" },
                    { type: "movie", nume: "1", label: "" },
                    { type: "movie", nume: "2", label: "" }
                );
            }

            // Step 1: Fetch ALL dooplayer endpoints IN PARALLEL
            var optionPromises = options.map(async function (opt) {
                var apiUrl = BASE_URL + "/wp-json/dooplayer/v2/" + postId + "/" + opt.type + "/" + opt.nume;
                try {
                    var json = await httpFetchJson(apiUrl);
                    if (json && json.embed_url) {
                        return { opt: opt, embedUrl: json.embed_url };
                    }
                } catch (_) {}
                return null;
            });

            var optionResults = (await Promise.all(optionPromises)).filter(Boolean);

            // Step 2: Resolve ALL embed URLs IN PARALLEL to extract direct .m3u8 & .mp4 links
            var resolvePromises = optionResults.map(async function (item) {
                var resolvedList = await resolveEmbedUrl(item.embedUrl);
                return { opt: item.opt, resolvedList: resolvedList };
            });

            var resolvedResults = await Promise.all(resolvePromises);
            var streams = [];
            var seenUrls = {};

            for (var i = 0; i < resolvedResults.length; i++) {
                var resItem = resolvedResults[i];
                var opt = resItem.opt;
                var isDub = url.toLowerCase().indexOf("dublado") !== -1;
                var langLabel = isDub ? "Dub" : "Sub";
                var serverTitle = opt.label ? opt.label : ("Server " + opt.nume);

                for (var j = 0; j < resItem.resolvedList.length; j++) {
                    var r = resItem.resolvedList[j];
                    if (r && r.url) {
                        var cleanUrl = sanitizeUrl(r.url);
                        if (!cleanUrl || seenUrls[cleanUrl]) continue;
                        seenUrls[cleanUrl] = true;

                        var sourceLabel = "AnimeQ " + serverTitle + (r.quality || "") + " (" + langLabel + ")";
                        var refererHeader = r.refererHost ? ("https://" + r.refererHost + "/") : (BASE_URL + "/");

                        streams.push(new StreamResult({
                            url: cleanUrl,
                            source: sourceLabel,
                            headers: { "Referer": refererHeader }
                        }));
                    }
                }
            }

            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e.stack || e) });
        }
    }

    // Export to global scope
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
