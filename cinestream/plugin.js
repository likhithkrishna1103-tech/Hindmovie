(function () {
    "use strict";

    try {
        if (typeof require === "function") {
            var eventsModule = require("events");
            if (eventsModule && typeof eventsModule.defaultMaxListeners === "number" && eventsModule.defaultMaxListeners < 100) {
                eventsModule.defaultMaxListeners = 100;
            }
        }
    } catch (_) {}

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

    function getNodeCrypto() {
        try {
            if (typeof require === "function") return require("crypto");
        } catch (_) {}
        return null;
    }

    function utf8ToBytes(value) {
        var text = String(value == null ? "" : value);
        if (typeof TextEncoder !== "undefined") return new TextEncoder().encode(text);
        if (typeof Buffer !== "undefined") return new Uint8Array(Buffer.from(text, "utf8"));
        var out = [];
        for (var i = 0; i < text.length; i++) out.push(text.charCodeAt(i) & 255);
        return new Uint8Array(out);
    }

    function bytesToUtf8(bytes) {
        var view = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes || []);
        if (typeof TextDecoder !== "undefined") return new TextDecoder().decode(view);
        if (typeof Buffer !== "undefined") return Buffer.from(view).toString("utf8");
        var out = "";
        for (var i = 0; i < view.length; i++) out += String.fromCharCode(view[i]);
        return out;
    }

    function bytesToBinary(bytes) {
        var view = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes || []);
        var out = "";
        for (var i = 0; i < view.length; i++) out += String.fromCharCode(view[i]);
        return out;
    }

    function binaryToBytes(binary) {
        var out = new Uint8Array(String(binary || "").length);
        for (var i = 0; i < out.length; i++) out[i] = binary.charCodeAt(i) & 255;
        return out;
    }

    function base64EncodeBytes(bytes) {
        var binary = bytesToBinary(bytes);
        if (typeof btoa === "function") return btoa(binary);
        if (typeof Buffer !== "undefined") return Buffer.from(binary, "binary").toString("base64");
        throw new Error("Base64 encoding not available");
    }

    function base64DecodeToBytes(value) {
        var text = String(value || "");
        if (!text) return new Uint8Array(0);
        if (typeof atob === "function") return binaryToBytes(atob(text));
        if (typeof Buffer !== "undefined") return new Uint8Array(Buffer.from(text, "base64"));
        throw new Error("Base64 decoding not available");
    }

    function hexToBytes(value) {
        var text = String(value || "").replace(/[^0-9a-f]/gi, "");
        var out = new Uint8Array(Math.floor(text.length / 2));
        for (var i = 0; i < out.length; i++) out[i] = parseInt(text.substr(i * 2, 2), 16) & 255;
        return out;
    }

    function bytesToHex(bytes) {
        var view = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes || []);
        var out = "";
        for (var i = 0; i < view.length; i++) {
            var hex = view[i].toString(16);
            out += hex.length === 1 ? "0" + hex : hex;
        }
        return out;
    }

    function concatBytes(parts) {
        var total = 0;
        var arrays = [];
        for (var i = 0; i < (parts || []).length; i++) {
            var value = parts[i] instanceof Uint8Array ? parts[i] : new Uint8Array(parts[i] || []);
            arrays.push(value);
            total += value.length;
        }
        var out = new Uint8Array(total);
        var offset = 0;
        for (var j = 0; j < arrays.length; j++) {
            out.set(arrays[j], offset);
            offset += arrays[j].length;
        }
        return out;
    }

    async function sha256Bytes(bytes) {
        var view = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes || []);
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.digest === "function") {
            return new Uint8Array(await globalThis.crypto.subtle.digest("SHA-256", view));
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createHash === "function") {
            return new Uint8Array(nodeCrypto.createHash("sha256").update(Buffer.from(view)).digest());
        }
        throw new Error("SHA-256 not available");
    }

    async function hmacSha256Hex(keyText, messageText) {
        var keyBytes = utf8ToBytes(keyText);
        var messageBytes = utf8ToBytes(messageText);
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey(
                "raw",
                keyBytes,
                { name: "HMAC", hash: "SHA-256" },
                false,
                ["sign"]
            );
            var signature = await globalThis.crypto.subtle.sign("HMAC", imported, messageBytes);
            return bytesToHex(new Uint8Array(signature));
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createHmac === "function") {
            return nodeCrypto.createHmac("sha256", Buffer.from(keyBytes)).update(Buffer.from(messageBytes)).digest("hex");
        }
        throw new Error("HMAC-SHA256 not available");
    }

    async function pbkdf2Sha256(passwordBytes, saltBytes, iterations, keyLength) {
        var pass = passwordBytes instanceof Uint8Array ? passwordBytes : new Uint8Array(passwordBytes || []);
        var salt = saltBytes instanceof Uint8Array ? saltBytes : new Uint8Array(saltBytes || []);
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var baseKey = await globalThis.crypto.subtle.importKey("raw", pass, "PBKDF2", false, ["deriveBits"]);
            var derived = await globalThis.crypto.subtle.deriveBits({
                name: "PBKDF2",
                hash: "SHA-256",
                salt: salt,
                iterations: Number(iterations || 100000)
            }, baseKey, Number(keyLength || 32) * 8);
            return new Uint8Array(derived);
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.pbkdf2Sync === "function") {
            return new Uint8Array(nodeCrypto.pbkdf2Sync(Buffer.from(pass), Buffer.from(salt), Number(iterations || 100000), Number(keyLength || 32), "sha256"));
        }
        throw new Error("PBKDF2 not available");
    }

    async function encryptAesCbcPkcs7(plainBytes, keyBytes, ivBytes) {
        var blockSize = 16;
        var source = plainBytes instanceof Uint8Array ? plainBytes : new Uint8Array(plainBytes || []);
        var remainder = source.length % blockSize;
        var padLength = remainder === 0 ? blockSize : (blockSize - remainder);
        var padded = new Uint8Array(source.length + padLength);
        padded.set(source, 0);
        for (var i = source.length; i < padded.length; i++) padded[i] = padLength;
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey("raw", keyBytes, { name: "AES-CBC" }, false, ["encrypt"]);
            var encrypted = await globalThis.crypto.subtle.encrypt({ name: "AES-CBC", iv: ivBytes }, imported, padded);
            return new Uint8Array(encrypted);
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createCipheriv === "function") {
            var cipher = nodeCrypto.createCipheriv("aes-256-cbc", Buffer.from(keyBytes), Buffer.from(ivBytes));
            cipher.setAutoPadding(false);
            var part1 = cipher.update(Buffer.from(padded));
            var part2 = cipher.final();
            return new Uint8Array(Buffer.concat([part1, part2]));
        }
        throw new Error("AES-CBC encryption not available");
    }

    async function decryptAesGcm(cipherBytes, keyBytes, ivBytes, tagBytes) {
        var payload = concatBytes([cipherBytes, tagBytes]);
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey("raw", keyBytes, { name: "AES-GCM" }, false, ["decrypt"]);
            var plain = await globalThis.crypto.subtle.decrypt({
                name: "AES-GCM",
                iv: ivBytes,
                tagLength: 128
            }, imported, payload);
            return new Uint8Array(plain);
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createDecipheriv === "function") {
            var decipher = nodeCrypto.createDecipheriv("aes-256-gcm", Buffer.from(keyBytes), Buffer.from(ivBytes));
            decipher.setAuthTag(Buffer.from(tagBytes));
            var part1 = decipher.update(Buffer.from(cipherBytes));
            var part2 = decipher.final();
            return new Uint8Array(Buffer.concat([part1, part2]));
        }
        throw new Error("AES-GCM decryption not available");
    }

    async function decryptAesCbcPkcs7(cipherBytes, keyBytes, ivBytes) {
        var encrypted = cipherBytes instanceof Uint8Array ? cipherBytes : new Uint8Array(cipherBytes || []);
        var plain;
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey("raw", keyBytes, { name: "AES-CBC" }, false, ["decrypt"]);
            plain = new Uint8Array(await globalThis.crypto.subtle.decrypt({ name: "AES-CBC", iv: ivBytes }, imported, encrypted));
        } else {
            var nodeCrypto = getNodeCrypto();
            if (!(nodeCrypto && typeof nodeCrypto.createDecipheriv === "function")) {
                throw new Error("AES-CBC decryption not available");
            }
            var decipher = nodeCrypto.createDecipheriv("aes-128-cbc", Buffer.from(keyBytes), Buffer.from(ivBytes));
            var part1 = decipher.update(Buffer.from(encrypted));
            var part2 = decipher.final();
            plain = new Uint8Array(Buffer.concat([part1, part2]));
        }
        if (!plain.length) return plain;
        var padLength = plain[plain.length - 1];
        if (padLength > 0 && padLength <= 16 && padLength <= plain.length) {
            var valid = true;
            for (var i = plain.length - padLength; i < plain.length; i++) {
                if (plain[i] !== padLength) {
                    valid = false;
                    break;
                }
            }
            if (valid) return plain.slice(0, plain.length - padLength);
        }
        return plain;
    }

    async function encryptAesGcm(plainBytes, keyBytes, ivBytes) {
        var source = plainBytes instanceof Uint8Array ? plainBytes : new Uint8Array(plainBytes || []);
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey("raw", keyBytes, { name: "AES-GCM" }, false, ["encrypt"]);
            var encrypted = new Uint8Array(await globalThis.crypto.subtle.encrypt({ name: "AES-GCM", iv: ivBytes }, imported, source));
            return {
                cipher: encrypted.slice(0, Math.max(0, encrypted.length - 16)),
                tag: encrypted.slice(Math.max(0, encrypted.length - 16))
            };
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createCipheriv === "function") {
            var cipher = nodeCrypto.createCipheriv("aes-256-gcm", Buffer.from(keyBytes), Buffer.from(ivBytes));
            var part1 = cipher.update(Buffer.from(source));
            var part2 = cipher.final();
            return {
                cipher: new Uint8Array(Buffer.concat([part1, part2])),
                tag: new Uint8Array(cipher.getAuthTag())
            };
        }
        throw new Error("AES-GCM encryption not available");
    }

    function randomBytes(length) {
        var size = Math.max(0, Number(length || 0));
        var out = new Uint8Array(size);
        if (globalThis.crypto && typeof globalThis.crypto.getRandomValues === "function") {
            globalThis.crypto.getRandomValues(out);
            return out;
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.randomBytes === "function") {
            return new Uint8Array(nodeCrypto.randomBytes(size));
        }
        for (var i = 0; i < size; i++) out[i] = Math.floor(Math.random() * 256) & 255;
        return out;
    }

    function xorBytes(dataBytes, keyBytes) {
        var data = dataBytes instanceof Uint8Array ? dataBytes : new Uint8Array(dataBytes || []);
        var key = keyBytes instanceof Uint8Array ? keyBytes : new Uint8Array(keyBytes || []);
        var out = new Uint8Array(data.length);
        for (var i = 0; i < data.length; i++) out[i] = data[i] ^ key[i % key.length];
        return out;
    }

    function parsePemPublicKey(pemText) {
        var cleaned = String(pemText || "").replace(/-----BEGIN PUBLIC KEY-----/g, "").replace(/-----END PUBLIC KEY-----/g, "").replace(/\s+/g, "");
        return base64DecodeToBytes(cleaned);
    }

    async function encryptRsaOaepSha256(publicKeyPem, plainBytes) {
        var spki = parsePemPublicKey(publicKeyPem);
        if (globalThis.crypto && globalThis.crypto.subtle && typeof globalThis.crypto.subtle.importKey === "function") {
            var imported = await globalThis.crypto.subtle.importKey(
                "spki",
                spki,
                { name: "RSA-OAEP", hash: "SHA-256" },
                false,
                ["encrypt"]
            );
            return new Uint8Array(await globalThis.crypto.subtle.encrypt({ name: "RSA-OAEP" }, imported, plainBytes));
        }
        var nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.publicEncrypt === "function") {
            return new Uint8Array(nodeCrypto.publicEncrypt({
                key: String(publicKeyPem || ""),
                oaepHash: "sha256",
                padding: nodeCrypto.constants.RSA_PKCS1_OAEP_PADDING
            }, Buffer.from(plainBytes)));
        }
        throw new Error("RSA-OAEP encryption not available");
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
        if (/\b4320p\b|\b8k\b/.test(value)) return 4320;
        if (/\b2160p\b|\b4k\b|\buhd\b/.test(value)) return 2160;
        if (/\b1440p\b|\b2k\b|\bqhd\b/.test(value)) return 1440;
        if (/\b1080p\b|\bfhd\b|\bfull\s*hd\b/.test(value)) return 1080;
        if (/\b720p\b|\bhd\b/.test(value)) return 720;
        if (/\b576p\b/.test(value)) return 576;
        if (/\b480p\b|\bsd\b/.test(value)) return 480;
        if (/\b360p\b/.test(value)) return 360;
        if (/\b240p\b/.test(value)) return 240;
        return 0;
    }

    var SPEC_OPTIONS = {
        quality: [
            { regex: /\bUHD\s*BluRay\b/i, label: "4K UHD BluRay 💿" },
            { regex: /\bBluRay\s*REMUX\b/i, label: "BluRay REMUX 💾" },
            { regex: /\bBluRay\b/i, label: "BluRay 💿" },
            { regex: /\bBDRip\b/i, label: "BDRip 💿" },
            { regex: /\bBRRip\b/i, label: "BRRip 💿" },
            { regex: /\bDVD(?:Rip|5|9)?\b/i, label: "DVD 📀" },
            { regex: /\bWEB[-.\s]?DL\b/i, label: "WEB-DL ☁️" },
            { regex: /\bWEBRip\b/i, label: "WEBRip 🌐" },
            { regex: /\bHDRip\b/i, label: "HDRip ✨" },
            { regex: /\bHDTV\b/i, label: "HDTV 📺" },
            { regex: /\bCAM\b/i, label: "CAM 📹" },
            { regex: /\bTeleSync\b/i, label: "TeleSync 📹" },
            { regex: /\bTS\b/i, label: "TS 🚫" }
        ],
        codec: [
            { regex: /\bAV1\b/i, label: "AV1 🚀" },
            { regex: /\b(?:x265|h\.?265|HEVC)\b/i, label: "HEVC ⚡" },
            { regex: /\b(?:x264|h\.?264|AVC)\b/i, label: "H.264 📦" },
            { regex: /\bVP9\b/i, label: "VP9 🧪" },
            { regex: /\bXviD\b/i, label: "XviD 🧩" }
        ],
        bitdepth: [
            { regex: /\b12bit\b/i, label: "12bit 🌈" },
            { regex: /\b10bit\b/i, label: "10bit 🎨" },
            { regex: /\bHi10P\b/i, label: "Hi10P (10bit) 🎨" },
            { regex: /\b8bit\b/i, label: "8bit 🖍️" },
            { regex: /\bIMAX\b/i, label: "IMAX 🏟️" }
        ],
        audio: [
            { regex: /\bTrueHD\b/i, label: "Dolby TrueHD 🔊" },
            { regex: /\bAtmos\b/i, label: "Dolby Atmos 🌌" },
            { regex: /\bDDP\s*5\.1\b|\bDD\+\s*5\.1\b/i, label: "DD+ 5.1 🔉" },
            { regex: /\b7\.1\b/i, label: "7.1 Ch 🔊" },
            { regex: /\b5\.1\b/i, label: "5.1 Ch 🔉" },
            { regex: /\bFLAC\b/i, label: "FLAC 🎹" },
            { regex: /\bAAC\s*2\.0\b/i, label: "AAC 2.0 🎧" },
            { regex: /\bDD\s*2\.0\b/i, label: "DD 2.0 🎧" },
            { regex: /\bDTS-HD\b/i, label: "DTS-HD 🔊" },
            { regex: /\bDTS\b/i, label: "DTS 🔈" },
            { regex: /\bAAC\b/i, label: "AAC 🎧" },
            { regex: /\bAC3\b/i, label: "AC3 🔈" }
        ],
        hdr: [
            { regex: /\b(?:DoVi|Dolby\s*Vision|DV)\b/i, label: "Dolby Vision 👁️" },
            { regex: /\bHDR10\+\b/i, label: "HDR10+ 🔆" },
            { regex: /\bHDR10\b/i, label: "HDR10 🔆" },
            { regex: /\bHDR\b/i, label: "HDR 🔆" },
            { regex: /\bSDR\b/i, label: "SDR 🔅" }
        ],
        language: [
            { regex: /\b(?:HIN|Hindi)\b/i, label: "Hindi 🇮🇳" },
            { regex: /\bTamil\b/i, label: "Tamil 🇮🇳" },
            { regex: /\bTelugu\b/i, label: "Telugu 🇮🇳" },
            { regex: /\bMalayalam\b/i, label: "Malayalam 🇮🇳" },
            { regex: /\bKannada\b/i, label: "Kannada 🇮🇳" },
            { regex: /\b(?:ENG|English)\b/i, label: "English 🇺🇸" },
            { regex: /\b(?:KOR|Korean)\b/i, label: "Korean 🇰🇷" },
            { regex: /\b(?:JPN|Japanese)\b/i, label: "Japanese 🇯🇵" },
            { regex: /\b(?:Multi[-.\s]?Audio)\b/i, label: "Multi Audio 🌍" },
            { regex: /\b(?:Dual[-.\s]?Audio|Dual)\b/i, label: "Dual Audio 🌗" },
            { regex: /\b(?:Multi[-.\s]?Sub)\b/i, label: "Multi Subs 💬" },
            { regex: /\bESub\b/i, label: "English Subs 🇺🇸" }
        ]
    };
    var CATEGORY_ORDER = ["quality", "codec", "bitdepth", "audio", "hdr", "language"];
    var SIZE_REGEX = /(\d+(?:\.\d+)?\s?(?:MB|GB))/i;

    function getSimplifiedTitle(title) {
        var remainingTitle = String(title || "");
        var matchedLabels = [];
        for (var i = 0; i < CATEGORY_ORDER.length; i++) {
            var category = CATEGORY_ORDER[i];
            var specs = SPEC_OPTIONS[category] || [];
            for (var j = 0; j < specs.length; j++) {
                if (specs[j].regex.test(remainingTitle)) {
                    matchedLabels.push(specs[j].label);
                    remainingTitle = remainingTitle.replace(specs[j].regex, " ");
                }
            }
        }
        var sizeMatch = firstMatch(title, [SIZE_REGEX]);
        var size = sizeMatch ? String(sizeMatch).toUpperCase() + " 💾" : "";
        var result = uniqueBy(matchedLabels, function (item) { return item; }).join(" | ");
        if (size) result = result ? (result + " | " + size) : size;
        return result ? ("\n" + result) : "";
    }

    function withSimplifiedSource(label, title) {
        var specs = getSimplifiedTitle(title || "");
        return specs ? String(label || "") + specs : String(label || "");
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

    function rankedMatches(list, queries, year, typeHint, limit) {
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
        return ranked.slice(0, Math.max(1, Number(limit) || 1)).map(function (entry) {
            return entry.item;
        });
    }

    function isJunkStreamUrl(url) {
        var value = trim(String(url || ""));
        if (!value) return true;
        if (/t\.me\/|telegram|tinyurl\.com|winexch\.com|facebook|instagram|youtube/i.test(value)) return true;
        if (/hubcloud\.[^/]+\/?(?:$|[?#])/i.test(value)) return true;
        if (/hubcloud\.foo\/(?:video|drive)\/admin\/?$/i.test(value)) return true;
        if (/hubrouting\.site\/hubcloud\.php/i.test(value)) return true;
        if (/filebee\.xyz\/file\//i.test(value)) return true;
        if (/(?:^|\/\/)[^.]+\.gdtot\.[^/]+\/file\//i.test(value)) return true;
        if (/vcloud\.zip\/re\.php\?/i.test(value)) return true;
        return false;
    }

    function dedupeStreams(list) {
        return uniqueBy((list || []).filter(function (item) {
            return !!(item && item.url) && !isJunkStreamUrl(item.url);
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

    var SCRAPE_CONCURRENCY = 8;
    var PROVIDER_LINK_CONCURRENCY = 4;
    var PROVIDER_CANDIDATE_LIMIT = 3;
    var PROVIDER_TIMEOUT_MS = 15000;

    async function mapLimit(list, limit, iteratee) {
        var items = Array.isArray(list) ? list : [];
        var max = Math.max(1, Number(limit || 1));
        var results = new Array(items.length);
        var cursor = 0;

        async function worker() {
            while (cursor < items.length) {
                var index = cursor++;
                try {
                    results[index] = {
                        status: "fulfilled",
                        value: await iteratee(items[index], index)
                    };
                } catch (error) {
                    results[index] = {
                        status: "rejected",
                        reason: error
                    };
                }
            }
        }

        var workers = [];
        for (var i = 0; i < Math.min(max, items.length); i++) workers.push(worker());
        await Promise.all(workers);
        return results;
    }

    function providerTimeoutMs(provider) {
        var key = provider && provider.key || "";
        if (key === "p_streamvix" || key === "p_notorrent" || key === "p_vidrock" || key === "p_vidsrccc") return 9000;
        if (key === "p_pulp") return 12000;
        if (key === "p_yflix" || key === "p_flixindia" || key === "p_bollyflix" || key === "p_movies4u" || key === "p_moviesdrive_extra" || key === "p_vegamovies") return 15000;
        return PROVIDER_TIMEOUT_MS;
    }

    var DOMAINS_JSON_URL = "https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json";
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
        return /(?:gofile|hubcloud|hubdrive|filepress|filebee|gdfli?x|gdlink|gdtot|m4ulinks|mdrive|linksmod|nexdrive|gadgetsweb|cryptoinsights|fastdlserver|fastdl\.zip|vcloud\.zip|rubystm|streamruby|vidstreaming|pixeldrain|1fichier|clicknupload|streamtape|ok\.ru|multiup|\.m3u8|\.mp4|\.mkv|\.avi|\.mpd)/i.test(String(url || ""));
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

    function buildResolvedStream(url, label, quality, headers, title) {
        return {
            url: url,
            source: withSimplifiedSource(label, title),
            quality: quality || qualityFromText(url),
            headers: headers || {}
        };
    }

    function buildSearchTitleForEpisode(title, year, season, episode) {
        var clean = trim(String(title || "").replace(/:/g, ""));
        if (!clean) return "";
        if (season == null) return trim(clean + (year ? " " + year : ""));
        var seasonSlug = String(season).padStart(2, "0");
        var episodeSlug = String(episode || 1).padStart(2, "0");
        return clean + " S" + seasonSlug + "E" + episodeSlug;
    }

    function parseJsonResultsRows(payload) {
        if (!payload) return [];
        if (Array.isArray(payload)) return payload;
        if (Array.isArray(payload.results)) return payload.results;
        if (Array.isArray(payload.data)) return payload.data;
        if (payload.items && Array.isArray(payload.items)) return payload.items;
        return [];
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
            out.push(buildResolvedStream(file.link, label || "GoFile", qualityFromText(file.name || file.link), {}, file.name || file.link));
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
                streams.push(buildResolvedStream(pixel, label || "HubCloud", qualityFromText(anchor.text), {}, anchor.text || pixel));
            } else if (/download|server|file|mega|s3|buzz|gofile|hub/i.test(text + " " + anchor.href)) {
                streams.push(buildResolvedStream(anchor.href, label || "HubCloud", qualityFromText(anchor.text), {}, anchor.text || anchor.href));
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
            if (isCommonDirectMediaUrl(location)) return [buildResolvedStream(location, label || "Filepress", qualityFromText(location), {}, location)];
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

    function extractDirectMediaUrls(html, base) {
        var out = [];
        var seen = {};
        var regex = /https?:\/\/[^\s"'<>]+?\.(?:m3u8|mp4|mkv|webm|avi|mpd)(?:\?[^\s"'<>]*)?/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
            var value = normalizeResolvedUrl(match[0], base);
            if (!value || seen[value]) continue;
            seen[value] = true;
            out.push(value);
        }
        return out;
    }

    async function resolveM4uLinksGlobal(url, label, depth) {
        var html = await getText(url, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
        if (!html) return [];
        var base = baseOrigin(url);
        var blocks = [];
        var regex = /<h4\b[^>]*>([\s\S]*?)<\/h4>([\s\S]*?)(?=<h4\b|$)/gi;
        var match;
        while ((match = regex.exec(String(html || "")))) {
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
        var results = [];
        for (var i = 0; i < blocks.length; i++) {
            var block = blocks[i];
            for (var j = 0; j < (block.anchors || []).length; j++) {
                results = results.concat(await resolveCommonExtractorUrl(block.anchors[j].href, trim(block.qualityLabel || label || "M4ULinks"), url, depth + 1));
            }
        }
        return results;
    }

    async function resolveFilesdlGlobal(url, label, depth) {
        var html = await getText(url, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
        if (!html) return [];
        var qualityTitle = firstMatch(html, [/<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]);
        var quality = qualityFromText(qualityTitle) || qualityFromText(html);
        var anchors = parseAnchors(html, baseOrigin(url));
        var results = [];
        for (var i = 0; i < anchors.length; i++) {
            var anchor = anchors[i];
            var text = String(anchor.text || "").toLowerCase();
            if (/hubcloud|gdfli?x|gofile|filepress|filebee|pixeldrain|drive/i.test(text + " " + anchor.href)) {
                results = results.concat(await resolveCommonExtractorUrl(anchor.href, label || "FilesDL", url, depth + 1));
            } else if (/direct download|ultra fastdl|fast cloud/i.test(text)) {
                var directRes = await request(anchor.href, {
                    headers: commonHeaders({ "Referer": url }),
                    allowRedirects: false
                }).catch(function () { return null; });
                var location = normalizeResolvedUrl(directRes && (directRes.headers.location || directRes.headers["x-redirect-location"]) || anchor.href, baseOrigin(anchor.href));
                if (location) results.push(buildResolvedStream(location, label || "FilesDL", quality, {}, qualityTitle || location));
            }
        }
        return results;
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
        }), title)];
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
        return [buildResolvedStream(streamUrl, label || "RubyStream", qualityFromText(html), commonHeaders({ "Referer": origin + "/" }), html)];
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
            return [buildResolvedStream(normalized, label || "Source", qualityFromText(label + " " + normalized), commonHeaders(referer ? { "Referer": referer } : {}), normalized)];
        }
        if (/gofile\.io/i.test(normalized)) return resolveGofileGlobal(normalized, label || "GoFile");
        if (/m4ulinks\.com/i.test(normalized)) return resolveM4uLinksGlobal(normalized, label || "M4ULinks", currentDepth);
        if (/filesdl\./i.test(normalized)) return resolveFilesdlGlobal(normalized, label || "FilesDL", currentDepth);
        if (/hubcloud\.|hubcloud\.fans|hubcloud\.foo|gamerxyt\.com\/hubcloud\.php/i.test(normalized)) return resolveHubCloudGlobal(normalized, label || "HubCloud");
        if (/hubdrive\./i.test(normalized)) return resolveHubDriveGlobal(normalized, label || "HubDrive", currentDepth);
        if (/filepress\.|filebee/i.test(normalized)) return resolveFilepressGlobal(normalized, label || "Filepress", currentDepth);
        if (/(?:gdfli?x|gdlink|gdtot)/i.test(normalized)) return resolveGdflixGlobal(normalized, label || "GDFlix", currentDepth);
        if (/mdrive\./i.test(normalized)) return resolveMdriveGlobal(normalized, label || "MDrive", currentDepth);
        if (/hdm2\.ink\/play/i.test(normalized)) return resolveHdm2PlayGlobal(normalized, label || "HDMovie2");
        if (/rubystm\.com\/e\/|streamruby\.com\/e\//i.test(normalized)) return resolveRubyStreamGlobal(normalized, label || "RubyStream");
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

    var TMDB_CACHE_TTL = 5 * 60 * 1000;
    var tmdbJsonCache = Object.create(null);
    var tmdbJsonInflight = Object.create(null);

    async function getTmdbJson(path, preferWorker) {
        var normalized = normalizeTmdbPath(path);
        var cacheKey = normalized;
        var now = Date.now();
        var cached = tmdbJsonCache[cacheKey];
        if (cached && (now - cached.at) < TMDB_CACHE_TTL) return cached.data;
        if (tmdbJsonInflight[cacheKey]) return tmdbJsonInflight[cacheKey];

        var urls = preferWorker
            ? [TMDB_WORKER_API + "/" + normalized, TMDB_API + "/" + normalized]
            : [TMDB_API + "/" + normalized, TMDB_WORKER_API + "/" + normalized];
        tmdbJsonInflight[cacheKey] = (async function () {
            var lastError = null;
            for (var i = 0; i < urls.length; i++) {
                try {
                    var data = await getJson(urls[i]);
                    tmdbJsonCache[cacheKey] = { at: Date.now(), data: data };
                    return data;
                } catch (error) {
                    lastError = error;
                }
            }
            throw lastError || new Error("TMDB request failed: " + normalized);
        })();

        try {
            return await tmdbJsonInflight[cacheKey];
        } finally {
            delete tmdbJsonInflight[cacheKey];
        }
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
        var detailUrl = mediaType + "/" + tmdbId + "?api_key=" + TMDB_API_KEY + "&append_to_response=credits,external_ids,recommendations";
        var keywordsUrl = mediaType + "/" + tmdbId + "/keywords?api_key=" + TMDB_API_KEY;
        var results = await Promise.all([
            getTmdbJson(detailUrl, true).catch(function () { return {}; }),
            getTmdbJson(keywordsUrl, true).catch(function () { return {}; })
        ]);
        var detail = results[0];
        var keywords = results[1];
        return {
            detail: detail || {},
            keywords: keywords || {}
        };
    }

    async function getHome(cb) {
        try {
            var sections = await Promise.all(HOME_SECTIONS.map(function (section) {
                return getTmdbJson(section.path, true).then(function (json) {
                    return {
                        title: section.title,
                        items: uniqueBy(((json && json.results) || []).map(buildTmdbItem).filter(Boolean), function (item) {
                            return item && item.url;
                        })
                    };
                }).catch(function () {
                    return {
                        title: section.title,
                        items: []
                    };
                });
            }));
            var data = {};
            sections.forEach(function (section) {
                data[section.title] = section.items;
            });
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
            var seasonResults = await Promise.all(seasons.map(function (seasonInfo) {
                return getTmdbJson("tv/" + tmdbId + "/season/" + seasonInfo.season_number + "?api_key=" + TMDB_API_KEY, true)
                    .then(function (seasonJson) {
                        return { seasonInfo: seasonInfo, seasonJson: seasonJson || {} };
                    })
                    .catch(function () {
                        return { seasonInfo: seasonInfo, seasonJson: {} };
                    });
            }));
            var episodes = [];

            seasonResults.forEach(function (entry) {
                var seasonInfo = entry.seasonInfo;
                var seasonJson = entry.seasonJson || {};
                var seasonEpisodes = seasonJson.episodes || [];
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
            });

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
                            source: withSimplifiedSource("Castle [" + trackNames + "]", title),
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
                                source: withSimplifiedSource("Castle [" + (track.languageName || track.abbreviate || "Default") + "]", title),
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
        var DEFAULT_BASE_URL = "https://new1.movies4u.style";
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
            var candidates = uniqueBy([
                await getDynamicDomain("movies4u", ""),
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
            var links = [];
            var blockRegex = /<div\b[^>]*class=["'][^"']*downloads-btns-div[^"']*["'][^>]*>([\s\S]*?)<\/div>/gi;
            var match;
            while ((match = blockRegex.exec(String(html || "")))) {
                links = links.concat(parseAnchors(match[1], base).map(function (item) { return item.href; }).filter(Boolean));
            }
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
            var regex = /<h([34])\b[^>]*>([\s\S]*?)<\/h\1>([\s\S]*?)(?=<h[34]\b|$)/gi;
            var match;
            while ((match = regex.exec(section))) {
                var title = stripTags(match[2]);
                var seasonMatch = title.match(/Season\s*(\d+)/i);
                if (!seasonMatch) continue;
                out.push({
                    season: Number(seasonMatch[1]),
                    links: parseAnchors(match[3], base).map(function (item) { return item.href; }).filter(Boolean)
                });
            }
            if (out.length) return out;
            var anchors = parseAnchors(section, base);
            var seasonMap = {};
            for (var i = 0; i < anchors.length; i++) {
                var seasonLink = anchors[i];
                var seasonNum = Number(firstMatch(seasonLink.text, [/Season\s*(\d+)/i, /\bS(\d+)\b/i])) || 0;
                if (!seasonNum || !seasonLink.href) continue;
                if (!seasonMap[seasonNum]) seasonMap[seasonNum] = [];
                seasonMap[seasonNum].push(seasonLink.href);
            }
            return Object.keys(seasonMap).map(function (key) {
                return {
                    season: Number(key),
                    links: uniqueBy(seasonMap[key], function (item) { return item; })
                };
            });
        }

        function getEpisodeBlocks(html, base) {
            var blocks = [];
            var regex = /<h([56])\b[^>]*>([\s\S]*?)<\/h\1>([\s\S]*?)(?=<h[56]\b|$)/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var title = stripTags(match[2]);
                var episodeMatch = title.match(/Episodes?\s*:?\s*(\d+)/i)
                    || title.match(/\bEpisode\s*(\d+)/i)
                    || title.match(/\bEp\.?\s*(\d+)/i)
                    || title.match(/\bE(\d+)\b/i);
                if (!episodeMatch) continue;
                blocks.push({
                    episode: Number(episodeMatch[1]),
                    links: parseAnchors(match[3], base).map(function (item) { return item.href; }).filter(Boolean)
                });
            }
            if (blocks.length) return blocks;
            var anchors = parseAnchors(html, base);
            for (var i = 0; i < anchors.length; i++) {
                var episodeLink = anchors[i];
                var epNum = Number(firstMatch(episodeLink.text, [/\bEpisode\s*(\d+)/i, /\bEp\.?\s*(\d+)/i, /\bE(\d+)\b/i])) || 0;
                if (!epNum || !episodeLink.href) continue;
                blocks.push({
                    episode: epNum,
                    links: [episodeLink.href]
                });
            }
            return blocks;
        }

        function isDirectMediaUrl(url) {
            return /\.(?:m3u8|mp4|mkv|webm|mpd)(?:[?#].*)?$/i.test(String(url || ""))
                || /\/api\/file\/[^/?]+(?:\?download)?$/i.test(String(url || ""));
        }

        function isInterestingExtractorUrl(url) {
            return /hubcloud|hubdrive|filepress|filebee|gdfli?x|gdlink|gofile|pixeldrain|m4ulinks|mdrive|googleusercontent|drive\.google|workers\.dev|\.m3u8|\.mp4|\.mpd/i.test(String(url || ""));
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

        function buildStream(url, label, quality, headers, title) {
            return {
                url: url,
                source: withSimplifiedSource(label || "Movies4u", title || url),
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
                streams.push(buildStream(file.link, "Movies4u [GoFile]", qualityFromText(file.name), {}, file.name || file.link));
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
                    streams.push(buildStream(pixel, "Movies4u [Pixeldrain]", qualityFromText(anchor.text), {}, anchor.text || pixel));
                } else if (/download|server|file|mega|s3|buzz/i.test(text)) {
                    streams.push(buildStream(anchor.href, "Movies4u [HubCloud]", qualityFromText(anchor.text), {}, anchor.text || anchor.href));
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
            var settled = await mapLimit(candidates.slice(0, 8), PROVIDER_LINK_CONCURRENCY, function (candidate) {
                return resolveExtractorUrl(candidate, "Movies4u [HubDrive]");
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
        }

        async function resolveFilepress(url) {
            var headers = defaultHeaders({ "Referer": baseOrigin(url) + "/" });
            var res = await request(url, { headers: headers, allowRedirects: false }).catch(function () { return null; });
            var location = res && (res.headers.location || res.headers["x-redirect-location"]);
            if (location && /^https?:\/\//i.test(location)) {
                if (isDirectMediaUrl(location)) return [buildStream(location, "Movies4u [Filepress]", qualityFromText(location), {}, location)];
                return resolveExtractorUrl(location, "Movies4u [Filepress]");
            }
            var html = await getText(url, headers, true).catch(function () { return ""; });
            var candidates = extractInterestingUrls(html, baseOrigin(url));
            if (!candidates.length) return [];
            var settled = await mapLimit(candidates.slice(0, 8), PROVIDER_LINK_CONCURRENCY, function (candidate) {
                return resolveExtractorUrl(candidate, "Movies4u [Filepress]");
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
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
            var settled = await mapLimit(candidates.slice(0, 10), PROVIDER_LINK_CONCURRENCY, async function (candidate) {
                if (/gofile/i.test(candidate)) return resolveGofile(candidate);
                if (/pixeldrain/i.test(candidate)) return [buildStream(candidate, "Movies4u [GDFlix]", qualityFromText(candidate), {}, candidate)];
                return resolveExtractorUrl(candidate, "Movies4u [GDFlix]");
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
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
            var settled = await mapLimit(candidates.slice(0, 8), PROVIDER_LINK_CONCURRENCY, function (candidate) {
                return resolveExtractorUrl(candidate, "Movies4u [MDrive]");
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
        }

        async function resolveM4ulinks(url, label) {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
            if (!html) return [];
            var base = baseOrigin(url);
            var blocks = [];
            var regex = /<h4\b[^>]*>([\s\S]*?)<\/h4>([\s\S]*?)(?=<h4\b|$)/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
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
            var tasks = [];
            for (var i = 0; i < blocks.length; i++) {
                for (var j = 0; j < (blocks[i].anchors || []).length; j++) {
                    tasks.push({
                        href: blocks[i].anchors[j].href,
                        label: trim(blocks[i].qualityLabel || label || "Movies4u [M4ULinks]")
                    });
                }
            }
            var settled = await mapLimit(tasks.slice(0, 12), PROVIDER_LINK_CONCURRENCY, function (task) {
                return resolveExtractorUrl(task.href, task.label);
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
        }

        async function resolveFilesdl(url, label) {
            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
            if (!html) return [];
            var qualityTitle = firstMatch(html, [/<div\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/div>/i]);
            var quality = qualityFromText(qualityTitle) || qualityFromText(html);
            var anchors = parseAnchors(html, baseOrigin(url));
            var settled = await mapLimit(anchors.slice(0, 10), PROVIDER_LINK_CONCURRENCY, async function (anchor) {
                var text = String(anchor.text || "").toLowerCase();
                if (/hubcloud|gdfli?x|gofile|filepress|filebee|pixeldrain|drive/i.test(text + " " + anchor.href)) {
                    return resolveExtractorUrl(anchor.href, label || "Movies4u [FilesDL]");
                }
                if (/direct download|ultra fastdl|fast cloud/i.test(text)) {
                    var directRes = await request(anchor.href, {
                        headers: defaultHeaders({ "Referer": url }),
                        allowRedirects: false
                    }).catch(function () { return null; });
                    var location = normalizeExtractedUrl(directRes && (directRes.headers.location || directRes.headers["x-redirect-location"]) || anchor.href, baseOrigin(anchor.href));
                    return location ? [buildStream(location, label || "Movies4u [FilesDL]", quality, {}, qualityTitle || location)] : [];
                }
                return [];
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
        }

        async function resolveExtractorUrl(url, label) {
            if (!url) return [];
            if (isDirectMediaUrl(url)) return [buildStream(url, label || "Movies4u", qualityFromText(url), {}, url)];
            if (/m4ulinks\.com/i.test(url)) return resolveM4ulinks(url, label || "Movies4u [M4ULinks]");
            if (/filesdl\./i.test(url)) return resolveFilesdl(url, label || "Movies4u [FilesDL]");
            if (/gofile\.io/i.test(url)) return resolveGofile(url);
            if (/hubcloud\.|gamerxyt\.com\/hubcloud\.php/i.test(url)) return resolveHubCloud(url);
            if (/hubdrive\./i.test(url)) return resolveHubDrive(url);
            if (/filepress\.|filebee/i.test(url)) return resolveFilepress(url);
            if (/(?:gdfli?x|gdlink)/i.test(url)) return resolveGdflix(url);
            if (/mdrive\.ink/i.test(url)) return resolveMdrive(url);
            if (/vcloud\.zip|fastdl\.zip/i.test(url)) return resolveCommonExtractorUrl(url, label || "Movies4u", url, 0);

            var html = await getText(url, defaultHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
            var candidates = extractInterestingUrls(html, baseOrigin(url)).filter(function (candidate) { return candidate !== url; });
            if (!candidates.length) return [];
            var settled = await mapLimit(candidates.slice(0, 8), PROVIDER_LINK_CONCURRENCY, function (candidate) {
                return resolveExtractorUrl(candidate, label || "Movies4u");
            });
            return flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            var settled = await mapLimit((queries || []).filter(Boolean), 3, async function (query) {
                try {
                    var html = await getText(mainUrl + "/?s=" + encodeURIComponent(trim(query)), defaultHeaders({ "Referer": mainUrl + "/" }));
                    return parseSearchResults(html, mainUrl);
                } catch (_) {
                    return [];
                }
            });
            var out = [];
            for (var i = 0; i < settled.length; i++) {
                if (settled[i] && settled[i].status === "fulfilled" && settled[i].value && settled[i].value.length) {
                    out = out.concat(settled[i].value);
                }
            }
            return uniqueBy(out, function (item) { return item && item.url; });
        }

        async function resolve(media) {
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var results = await searchTitles(queries);
            var candidates = rankedMatches(results, queries, media.year, media.isMovie ? "movie" : null, PROVIDER_CANDIDATE_LIMIT);
            if (!media.isMovie && Number(media.season)) {
                for (var r = 0; r < results.length; r++) {
                    var text = String((results[r] && results[r].title) || "");
                    if (new RegExp("Season\\s*" + media.season + "\\b", "i").test(text) || new RegExp("\\bS0*" + media.season + "\\b", "i").test(text)) {
                        candidates.unshift(results[r]);
                        break;
                    }
                }
            }
            candidates = uniqueBy(candidates.filter(Boolean), function (item) { return item && item.url; });
            if (!candidates.length) return [];

            var settled = await mapLimit(candidates, 2, async function (match) {
                var html = await getText(match.url, defaultHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
                if (!html) return [];

                var links = [];
                if (media.isMovie) {
                    links = extractDownloadLinks(html, baseOrigin(match.url));
                } else {
                    var seasons = getSeasonSections(html, baseOrigin(match.url)).filter(function (row) {
                        return Number(row && row.season) === Number(media.season);
                    });
                    var seasonSettled = await mapLimit(seasons, 2, async function (seasonRow) {
                        var pages = await mapLimit((seasonRow.links || []).slice(0, 4), 2, async function (seasonUrl) {
                            var seasonHtml = await getText(seasonUrl, defaultHeaders({ "Referer": match.url }), true).catch(function () { return ""; });
                            if (!seasonHtml) return [];
                            var seasonLinks = [];
                            var blocks = getEpisodeBlocks(seasonHtml, baseOrigin(seasonUrl));
                            for (var k = 0; k < blocks.length; k++) {
                                if (Number(blocks[k].episode) === Number(media.episode)) seasonLinks = seasonLinks.concat(blocks[k].links || []);
                            }
                            if (!blocks.length) {
                                var fallbackAnchors = parseAnchors(seasonHtml, baseOrigin(seasonUrl)).filter(function (item) {
                                    var text = String(item && item.text || "");
                                    return !!(item && item.href) && /episode|ep\.?|e\d+/i.test(text);
                                });
                                for (var m = 0; m < fallbackAnchors.length; m++) {
                                    var epMatch = firstMatch(fallbackAnchors[m].text, [/\bEpisode\s*(\d+)/i, /\bEp\.?\s*(\d+)/i, /\bE(\d+)\b/i]);
                                    if (Number(epMatch) === Number(media.episode)) seasonLinks.push(fallbackAnchors[m].href);
                                }
                            }
                            return seasonLinks;
                        });
                        return flatten(pages.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
                    });
                    links = flatten(seasonSettled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
                }

                links = uniqueBy(links, function (item) { return item; }).slice(0, 12);
                var linkSettled = await mapLimit(links, PROVIDER_LINK_CONCURRENCY, function (link) {
                    return resolveExtractorUrl(link, "Movies4u");
                });
                return dedupeStreams(flatten(linkSettled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            });
            return dedupeStreams(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
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
                        source: withSimplifiedSource(sourceName, masterUrl),
                        quality: quality,
                        headers: streamHeaders,
                        isM3U8: true
                    });
                }
            } catch (_) {}
            if (!results.length) {
                results.push({
                    url: masterUrl,
                    source: withSimplifiedSource(sourceName, masterUrl),
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
                            source: withSimplifiedSource("Kaido [" + serverLabel + "]", src.file),
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
                            source: withSimplifiedSource("Animetsu [" + (payload.server || server.id || "default") + " " + sourceType.toUpperCase() + "]", source.quality || streamUrl),
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
        var MAIN_URL = "https://animepahe.pw";
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
                    source: withSimplifiedSource("AnimePahe [" + kind + "]", buttonText || streamUrl),
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
                var domainJson = await getDomainsJson();
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
            if (out.length) return uniqueValues(out);
            var anchors = parseAnchors(html, mainUrl);
            var seasonLinks = [];
            for (var j = 0; j < anchors.length; j++) {
                var anchor = anchors[j];
                var seasonMatch = String(anchor.text || "").match(/Season\s*(\d+)/i) || String(anchor.href || "").match(/season[-\s]?(\d+)/i);
                if (!seasonMatch || Number(seasonMatch[1]) !== Number(targetSeason)) continue;
                if (isGoodUrl(anchor.href)) seasonLinks.push(anchor.href);
            }
            seasonLinks = uniqueValues(seasonLinks);
            for (var k = 0; k < Math.min(seasonLinks.length, 6); k++) {
                try {
                    var seasonPage = await siteRequest(seasonLinks[k], { attempts: 1 });
                    var episodeAnchors = parseAnchors(seasonPage.body, seasonPage.url);
                    for (var x = 0; x < episodeAnchors.length; x++) {
                        var text = String(episodeAnchors[x].text || "");
                        var epMatch = text.match(/Episode\s*(\d+)/i)
                            || text.match(/\bEp\.?\s*(\d+)/i)
                            || text.match(/\bE(\d+)\b/i);
                        if (!epMatch || Number(epMatch[1]) !== Number(targetEpisode)) continue;
                        if (isGoodUrl(episodeAnchors[x].href)) out.push(episodeAnchors[x].href);
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
                    source: withSimplifiedSource("Hindmoviez [" + trim(chosen.text || "HCloud") + "]", heading || chosen.text || chosen.href),
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
            for (var i = 0; i < Math.min(pageUrls.length, 3); i++) {
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
        var ANIZIP_API = "https://api.ani.zip";
        var SPEC_OPTIONS = [
            { regex: /\bUHD\s*BluRay\b/i, label: "4K UHD BluRay" },
            { regex: /\bBluRay\s*REMUX\b/i, label: "BluRay REMUX" },
            { regex: /\bBluRay\b/i, label: "BluRay" },
            { regex: /\bBDRip\b/i, label: "BDRip" },
            { regex: /\bBRRip\b/i, label: "BRRip" },
            { regex: /\bWEB[-.\s]?DL\b/i, label: "WEB-DL" },
            { regex: /\bWEBRip\b/i, label: "WEBRip" },
            { regex: /\bHDTV\b/i, label: "HDTV" },
            { regex: /\bDVD(?:Rip|5|9)?\b/i, label: "DVD" },
            { regex: /\bAV1\b/i, label: "AV1" },
            { regex: /\b(?:x265|h\.?265|HEVC)\b/i, label: "HEVC" },
            { regex: /\b(?:x264|h\.?264|AVC)\b/i, label: "H.264" },
            { regex: /\b10bit\b/i, label: "10bit" },
            { regex: /\b12bit\b/i, label: "12bit" },
            { regex: /\bHi10P\b/i, label: "Hi10P" },
            { regex: /\b(?:TrueHD|Atmos|DDP\s*5\.1|DD\+\s*5\.1|DD\s*5\.1|DD\s*2\.0|AAC\s*2\.0|AAC|FLAC|DTS-HD|DTS:X|DTS|AC3)\b/i, label: "" },
            { regex: /\b(?:DoVi|Dolby\s*Vision|HDR10\+|HDR10|HDR|SDR)\b/i, label: "" },
            { regex: /\b(?:Hindi|HIN)\b/i, label: "Hindi" },
            { regex: /\b(?:English|ENG)\b/i, label: "English" },
            { regex: /\b(?:Japanese|JPN)\b/i, label: "Japanese" },
            { regex: /\b(?:Multi[-.\s]?Audio)\b/i, label: "Multi Audio" },
            { regex: /\b(?:Dual[-.\s]?Audio|Dual)\b/i, label: "Dual Audio" },
            { regex: /\b(?:Multi[-.\s]?Sub)\b/i, label: "Multi Subs" },
            { regex: /\bESub\b/i, label: "English Subs" }
        ];
        var AUDIO_LABELS = [
            { regex: /\bTrueHD\b/i, label: "Dolby TrueHD" },
            { regex: /\bAtmos\b/i, label: "Dolby Atmos" },
            { regex: /\bDDP\s*5\.1\b|\bDD\+\s*5\.1\b/i, label: "DD+ 5.1" },
            { regex: /\bDD\s*5\.1\b/i, label: "DD 5.1" },
            { regex: /\bDD\s*2\.0\b/i, label: "DD 2.0" },
            { regex: /\bAAC\s*2\.0\b/i, label: "AAC 2.0" },
            { regex: /\bFLAC\b/i, label: "FLAC" },
            { regex: /\bDTS-HD\b/i, label: "DTS-HD" },
            { regex: /\bDTS:X\b/i, label: "DTS:X" },
            { regex: /\bDTS\b/i, label: "DTS" },
            { regex: /\bAC3\b/i, label: "AC3" },
            { regex: /\bAAC\b/i, label: "AAC" }
        ];
        var HDR_LABELS = [
            { regex: /\b(?:DoVi|Dolby\s*Vision)\b/i, label: "Dolby Vision" },
            { regex: /\bHDR10\+\b/i, label: "HDR10+" },
            { regex: /\bHDR10\b/i, label: "HDR10" },
            { regex: /\bHDR\b/i, label: "HDR" },
            { regex: /\bSDR\b/i, label: "SDR" }
        ];
        var SIZE_REGEX = /(\d+(?:\.\d+)?\s?(?:MB|GB))/i;

        function parseTorznabItems(xml) {
            var out = [];
            var blocks = String(xml || "").match(/<item>[\s\S]*?<\/item>/gi) || [];
            for (var i = 0; i < blocks.length; i++) {
                var block = blocks[i];
                var title = decodeHtml(firstMatch(block, [/<title>([\s\S]*?)<\/title>/i]));
                var magnet = decodeHtml(firstMatch(block, [/<torznab:attr name=["']magneturl["'] value=["']([^"']+)["']/i]));
                if (!magnet) magnet = decodeHtml(firstMatch(block, [/<a href=["'](magnet:[^"']+)["']/i]));
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

        function extractSpecLabel(title, options) {
            for (var i = 0; i < options.length; i++) {
                if (options[i].regex.test(title)) return options[i].label;
            }
            return "";
        }

        function simplifiedTitle(title) {
            var text = trim(String(title || ""));
            var labels = [];
            for (var i = 0; i < SPEC_OPTIONS.length; i++) {
                if (!SPEC_OPTIONS[i].label) continue;
                if (SPEC_OPTIONS[i].regex.test(text)) labels.push(SPEC_OPTIONS[i].label);
            }
            var audio = extractSpecLabel(text, AUDIO_LABELS);
            var hdr = extractSpecLabel(text, HDR_LABELS);
            if (audio) labels.push(audio);
            if (hdr) labels.push(hdr);
            var size = firstMatch(text, [SIZE_REGEX]);
            if (size) labels.push(String(size).toUpperCase());
            return uniqueBy(labels, function (item) { return item; }).join(" | ");
        }

        function getEpisodeAniZipId(mappingJson, episode) {
            var root = parseJsonSafe(mappingJson, null);
            if (!root || !root.episodes) return 0;
            var targetEpisode = Number(episode || 1) || 1;
            var episodes = root.episodes || {};
            var exact = episodes[String(targetEpisode)];
            if (exact && exact.anidbEid) return Number(exact.anidbEid) || 0;
            var keys = Object.keys(episodes);
            for (var i = 0; i < keys.length; i++) {
                var entry = episodes[keys[i]] || {};
                if (Number(entry.absoluteEpisodeNumber || entry.episode || 0) !== targetEpisode) continue;
                if (entry.anidbEid) return Number(entry.anidbEid) || 0;
            }
            return 0;
        }

        function mapAniToshoJsonItems(items) {
            var rows = Array.isArray(items) ? items : [];
            return rows.map(function (item) {
                return {
                    title: trim(item && item.title || ""),
                    magnet_uri: trim(item && (item.magnet_uri || item.magnetUri) || ""),
                    seeders: Number(item && item.seeders) || 0,
                    leechers: Number(item && item.leechers) || 0,
                    total_size: Number(item && (item.total_size || item.totalSize)) || 0
                };
            }).filter(function (item) {
                return item.title && item.magnet_uri;
            });
        }

        function animeToshoType(title) {
            return /dual|dub/i.test(String(title || "")) ? "DUB" : "SUB";
        }

        function formatAniToshoStream(entry) {
            var streamType = animeToshoType(entry.title);
            var sizeText = sizeLabel(entry.total_size);
            var label = "AnimeTosho [" + streamType + "]"
                + " [S:" + String(entry.seeders || 0) + "/L:" + String(entry.leechers || 0) + "]";
            if (sizeText) label += " [" + sizeText + "]";
            var cleanTitle = simplifiedTitle(entry.title, sizeText);
            if (cleanTitle) label += " " + cleanTitle;
            return {
                url: entry.magnet_uri,
                source: withSimplifiedSource(label, entry.title),
                quality: qualityFromText(entry.title || ""),
                headers: {}
            };
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

        async function resolveViaAniZip(media) {
            var idType = "";
            var idValue = "";
            if (media.malId) {
                idType = "mal_id";
                idValue = String(media.malId);
            } else if (media.kitsuId) {
                idType = "kitsu_id";
                idValue = String(media.kitsuId);
            } else if (media.tmdbId) {
                idType = "themoviedb_id";
                idValue = String(media.tmdbId);
            }
            if (!idType || !idValue) return [];

            var mappingText = await getText(ANIZIP_API + "/mappings?" + idType + "=" + encodeURIComponent(idValue), {
                "Accept": "application/json"
            }).catch(function () { return ""; });
            var mapping = parseJsonSafe(mappingText, null);
            var episodeId = getEpisodeAniZipId(mappingText, media.isMovie ? 1 : media.episode || 1);
            if (!episodeId) return [];

            var itemsText = await getText(API_BASE + "/json?eid=" + encodeURIComponent(String(episodeId)), {
                "Accept": "application/json"
            }).catch(function () { return ""; });
            var mappingTitles = uniqueBy([
                trim(mapping && mapping.titles && mapping.titles.en || ""),
                trim(mapping && mapping.titles && mapping.titles.ja || ""),
                trim(media.title || ""),
                trim(media.originalTitle || "")
            ].filter(Boolean), function (item) { return normalizeTitle(item); });
            var parsedItems = mapAniToshoJsonItems(parseJsonSafe(itemsText, []));
            var filtered = parsedItems.filter(function (item) {
                if (!item.magnet_uri || Number(item.seeders || 0) < 25) return false;
                if (!media.isMovie && !episodeMatches(item.title, media.episode)) return false;
                if (mappingTitles.length && titleScore(item.title, mappingTitles) <= 0) return false;
                return true;
            }).sort(function (a, b) {
                var left = Number(a.total_size || 0) || Number.MAX_SAFE_INTEGER;
                var right = Number(b.total_size || 0) || Number.MAX_SAFE_INTEGER;
                return left - right;
            });
            return dedupeStreams(filtered.map(formatAniToshoStream));
        }

        async function resolveFallback(media) {
            var titleQueries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var searchQueries = titleQueries.slice();
            if (!media.isMovie && Number(media.episode)) {
                var epText = Number(media.episode) < 10 ? "0" + Number(media.episode) : String(Number(media.episode));
                if (media.title) searchQueries.push(media.title + " " + epText);
                if (media.originalTitle) searchQueries.push(media.originalTitle + " " + epText);
            }
            var entries = await searchEntries(uniqueValues(searchQueries));
            var ranked = rankedEntries(entries, media, titleQueries)
                .filter(function (entry) { return Number(entry.seeders || 0) >= 25; })
                .slice(0, 12);
            return dedupeStreams(ranked.map(formatAniToshoStream));
        }

        async function resolve(media) {
            var viaAniZip = await resolveViaAniZip(media);
            if (viaAniZip.length) return viaAniZip;
            if (media.malId || media.kitsuId || media.tmdbId) return [];
            return resolveFallback(media);
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
                    source: withSimplifiedSource(streamSourceLabel(stream), String(stream && stream.title || stream && stream.name || streamUrl)),
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
    var VidSrcSource = (function () {
        var PRIMARY_BASE = "https://vidsrc.cc";
        var FALLBACK_BASE = "https://vidsrc.to";
        var HEADERS = commonHeaders({
            "Referer": PRIMARY_BASE + "/"
        });

        function buildEmbedUrl(base, media) {
            var prefix = String(base || "").replace(/\/+$/g, "");
            var id = trim(media && (media.imdbId || media.tmdbId) || "");
            if (!id) return "";
            if (/vidsrc\.cc$/i.test(prefix)) {
                if (media && media.isMovie) return prefix + "/v2/embed/movie/" + encodeURIComponent(id);
                return prefix + "/v2/embed/tv/" + encodeURIComponent(id) + "/" + encodeURIComponent(media && media.season || 1) + "/" + encodeURIComponent(media && media.episode || 1);
            }
            if (media && media.isMovie) return prefix + "/embed/movie/" + encodeURIComponent(id);
            return prefix + "/embed/tv/" + encodeURIComponent(id) + "/" + encodeURIComponent(media && media.season || 1) + "/" + encodeURIComponent(media && media.episode || 1);
        }

        async function resolve(media) {
            if (!media || !media.tmdbId) return [];
            var bases = [PRIMARY_BASE, FALLBACK_BASE];
            for (var i = 0; i < bases.length; i++) {
                var embedUrl = buildEmbedUrl(bases[i], media);
                if (!embedUrl) continue;
                try {
                    var html = await getText(embedUrl, commonHeaders({ "Referer": bases[i] + "/" }), true);
                    var iframeSrc = firstMatch(html, [
                        /id=["']player_iframe["'][^>]*src=["']([^"']+)["']/i,
                        /<iframe[^>]+id=["']player_iframe["'][^>]+src=["']([^"']+)["']/i
                    ]);
                    iframeSrc = normalizeResolvedUrl(iframeSrc, bases[i]);
                    if (!iframeSrc) continue;

                    var firstReferer = baseOrigin(iframeSrc) + "/";
                    var firstHtml = await getText(iframeSrc, commonHeaders({ "Referer": bases[i] + "/" }), true);
                    var nestedPath = firstMatch(firstHtml, [/src:\s*['"]([^'"]+)['"]/i]);
                    var finalIframe = normalizeResolvedUrl(nestedPath, firstReferer);
                    if (!finalIframe) continue;

                    var finalHtml = await getText(finalIframe, commonHeaders({ "Referer": firstReferer }), true);
                    var streamUrl = firstMatch(finalHtml, [
                        /file:\s*['"]([^'"]+)['"]/i,
                        /(https?:\/\/[^\s"'<>]+\.m3u8[^\s"'<>]*)/i
                    ]);
                    if (!streamUrl) continue;

                    return [buildResolvedStream(streamUrl, "VidsrcCC", qualityFromText(streamUrl), commonHeaders({
                        "Referer": firstReferer
                    }), streamUrl)];
                } catch (_) {}
            }
            return [];
        }

        return {
            key: "p_vidsrccc",
            name: "VidsrcCC",
            resolve: resolve
        };
    })();

    var VidRockSource = (function () {
        var MAIN_URL = "https://vidrock.net";
        var PASSPHRASE = "x7k9mPqT2rWvY8zA5bC3nF6hJ2lK4mN9";
        var HEADERS = commonHeaders({
            "Referer": MAIN_URL + "/"
        });

        function toUrlSafeBase64(bytes) {
            return base64EncodeBytes(bytes).replace(/\+/g, "-").replace(/\//g, "_").replace(/=+$/g, "");
        }

        async function resolve(media) {
            if (!media || !media.tmdbId) return [];
            var itemType = media.isMovie ? "movie" : "tv";
            var itemId = media.isMovie
                ? String(media.tmdbId)
                : String(media.tmdbId) + "_" + String(media.season || 1) + "_" + String(media.episode || 1);
            var keyBytes = utf8ToBytes(PASSPHRASE);
            var ivBytes = keyBytes.slice(0, 16);
            var encrypted = await encryptAesCbcPkcs7(utf8ToBytes(itemId), keyBytes, ivBytes);
            var encoded = encodeURIComponent(toUrlSafeBase64(encrypted));
            var json = await getJson(MAIN_URL + "/api/" + itemType + "/" + encoded, HEADERS).catch(function () { return {}; });
            var streams = [];
            for (var key in (json || {})) {
                if (!Object.prototype.hasOwnProperty.call(json, key)) continue;
                var source = json[key];
                var streamUrl = trim(source && source.url || "");
                if (!streamUrl) continue;
                streams.push(buildResolvedStream(streamUrl, "VidRock", qualityFromText(streamUrl), HEADERS, streamUrl));
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_vidrock",
            name: "VidRock",
            resolve: resolve
        };
    })();

    var PrimeSrcSource = (function () {
        var BASES = ["https://primesrc.me", "https://primesrc.click"];
        var AES_KEY = utf8ToBytes("kiemtienmua911ca");
        var AES_IV = utf8ToBytes("1234567890oiuytr");

        function buildEmbedUrl(base, media) {
            var root = String(base || "").replace(/\/+$/g, "");
            if (!media || !media.imdbId) return "";
            if (media.isMovie) return root + "/embed/movie?imdb=" + encodeURIComponent(media.imdbId);
            return root + "/embed/tv?imdb=" + encodeURIComponent(media.imdbId) + "&season=" + encodeURIComponent(media.season || 1) + "&episode=" + encodeURIComponent(media.episode || 1);
        }

        async function resolve(media) {
            if (!media || !media.imdbId) return [];
            for (var i = 0; i < BASES.length; i++) {
                var base = BASES[i];
                var embedUrl = buildEmbedUrl(base, media);
                try {
                    var contentType = media.isMovie ? "movie" : "tv";
                    var serversJson = await getJson(base + "/api/v1/s?imdb=" + encodeURIComponent(media.imdbId) + "&type=" + encodeURIComponent(contentType), commonHeaders({
                        "Referer": base + "/",
                        "User-Agent": "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"
                    })).catch(function () { return {}; });
                    var servers = serversJson && serversJson.servers || [];
                    if (!servers.length || !servers[0].key) continue;
                    var linkJson = await getJson(base + "/api/v1/l?key=" + encodeURIComponent(servers[0].key), commonHeaders({
                        "Referer": embedUrl
                    })).catch(function () { return {}; });
                    var serverUrl = trim(linkJson && linkJson.link || "");
                    if (!serverUrl) continue;
                    var serverId = trim(serverUrl.split("#")[1] || "");
                    var serverOrigin = baseOrigin(serverUrl);
                    if (!serverId || !serverOrigin) continue;
                    var encryptedHex = await getText(serverOrigin + "/api/v1/video?id=" + encodeURIComponent(serverId), commonHeaders({
                        "Referer": serverOrigin + "/",
                        "User-Agent": "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"
                    }), true).catch(function () { return ""; });
                    encryptedHex = trim(encryptedHex);
                    if (!encryptedHex) continue;
                    var plain = await decryptAesCbcPkcs7(hexToBytes(encryptedHex), AES_KEY, AES_IV);
                    var payload = bytesToUtf8(plain).replace(/\\/g, "");
                    var streamUrl = firstMatch(payload, [/\"source\":\"(.*?)\"/i, /"source":"(.*?)"/i]);
                    if (!streamUrl) continue;
                    return [buildResolvedStream(streamUrl, "PrimeSrc", qualityFromText(streamUrl), commonHeaders({
                        "Referer": serverOrigin + "/",
                        "User-Agent": "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Mobile Safari/537.36"
                    }), streamUrl)];
                } catch (_) {}
            }
            return [];
        }

        return {
            key: "p_primesrc",
            name: "PrimeSrc",
            resolve: resolve
        };
    })();

    var CinemaOSSource = (function () {
        var MAIN_URL = "https://cinemaos.live";
        var USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";
        var PRIMARY_HMAC_KEY = "a7f3b9c2e8d4f1a6b5c9e2d7f4a8b3c6e1d9f7a4b2c8e5d3f9a6b4c1e7d2f8a5";
        var SECONDARY_HMAC_KEY = "d3f8a5b2c9e6d1f7a4b8c5e2d9f3a6b1c7e4d8f2a9b5c3e7d4f1a8b6c2e9d5f3";
        var PASSWORD_BYTES = utf8ToBytes("a1b2c3d4e4f6477658455678901477567890abcdef1234567890abcdef123456");
        var DEFAULT_HEADERS = {
            "Origin": MAIN_URL,
            "Referer": MAIN_URL + "/",
            "User-Agent": USER_AGENT
        };

        async function resolve(media) {
            if (!media || !media.tmdbId || !media.imdbId) return [];
            var contentType = media.isMovie ? "movie" : "tv";
            var message = "tmdbId:" + String(media.tmdbId) + "|imdbId:" + String(media.imdbId);
            if (!media.isMovie) {
                message += "|seasonId:" + String(media.season || 1) + "|episodeId:" + String(media.episode || 1);
            }
            var primarySecret = await hmacSha256Hex(PRIMARY_HMAC_KEY, message);
            var finalSecret = await hmacSha256Hex(SECONDARY_HMAC_KEY, primarySecret);
            var apiUrl = MAIN_URL + "/api/providerv3?type=" + encodeURIComponent(contentType)
                + "&tmdbId=" + encodeURIComponent(media.tmdbId)
                + "&imdbId=" + encodeURIComponent(media.imdbId)
                + "&seasonId=" + encodeURIComponent(media.isMovie ? "" : (media.season || 1))
                + "&episodeId=" + encodeURIComponent(media.isMovie ? "" : (media.episode || 1))
                + "&t=&ry=&secret=" + encodeURIComponent(finalSecret);
            var payload = await getJson(apiUrl, DEFAULT_HEADERS).catch(function () { return {}; });
            var data = payload && payload.data || {};
            if (!data.encrypted || !data.cin || !data.mao || !data.salt) return [];

            var derivedKey = await pbkdf2Sha256(PASSWORD_BYTES, hexToBytes(data.salt), 100000, 32);
            var plainBytes = await decryptAesGcm(hexToBytes(data.encrypted), derivedKey, hexToBytes(data.cin), hexToBytes(data.mao));
            var parsed = parseJsonSafe(bytesToUtf8(plainBytes), {});
            var sources = parsed && parsed.sources || {};
            var streams = [];
            for (var key in sources) {
                if (!Object.prototype.hasOwnProperty.call(sources, key)) continue;
                var source = sources[key];
                var streamUrl = trim(source && source.url || "");
                if (!streamUrl) continue;
                streams.push(buildResolvedStream(streamUrl, "CinemaOS [" + cleanProviderLabel(key) + "]", qualityFromText(key + " " + streamUrl), DEFAULT_HEADERS, key + " " + streamUrl));
            }
            return dedupeStreams(streams);
        }

        return {
            key: "p_cinemaos",
            name: "CinemaOS",
            resolve: resolve
        };
    })();

    var VidFastProSource = (function () {
        var MAIN_URL = "https://vidfast.pro";
        var USER_AGENT = "Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Mobile Safari/537.36";
        var AES_KEY = hexToBytes("50bb6a529bfb4abb1969c1a29c8cac6df1f00ec63a7297c4c06dcc9473cdacc4");
        var AES_IV = hexToBytes("ffe7765f45669a794181d0b4a8d9e96b");
        var XOR_SEED_KEY = hexToBytes("1a5d66c3fbf2");
        var STATIC_PATH = "hezushon/8ee77bc2e110fd6e6ac7659b33c6f9146497cb81b1a2694590a68f22c5b495b9/APA91DQqR0e_8UTJpaNhNS9c2Bgrg21PeT12bVxpsCvoUhB9rNLJgMZMHxO7oigbPWv7eXn4NavycM9jt2EGVHBmkXIeSJUXh2AOEvWyji1iNx4Txr2OZONKK5IjKp8GBmmzCCb6-rh1I0o50c5eLc_cZ6KnwX7TrB_UsqfYsbMwBqhvWBEEZ1Q/bdf45bbf7c054d8a75d7575767e40745f967d0a8";
        var CHAR_SOURCE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
        var CHAR_TARGET = "4jrpDdPNYKMiBLgwczuHGksmOIoS2-JVRCnbfl769A0UeE5Qyt_aWq1xTF3vhXZ8";

        function headers() {
            return {
                "Accept": "*/*",
                "Referer": MAIN_URL + "/",
                "User-Agent": USER_AGENT,
                "X-Csrf-Token": "22Xg4bhHnx4uUolyJWs7rdNBbIzYVz8z",
                "X-Requested-With": "XMLHttpRequest"
            };
        }

        function customEncode(inputBytes) {
            var encoded = base64EncodeBytes(inputBytes).replace(/=+$/g, "");
            var out = "";
            for (var i = 0; i < encoded.length; i++) {
                var index = CHAR_SOURCE.indexOf(encoded.charAt(i));
                out += index >= 0 ? CHAR_TARGET.charAt(index) : encoded.charAt(i);
            }
            return out;
        }

        function generateKsa(seedBytes, size) {
            var seed = seedBytes instanceof Uint8Array ? seedBytes : new Uint8Array(seedBytes || []);
            var view = new DataView(seed.buffer, seed.byteOffset, seed.byteLength);
            var state = ((view.getUint32(0, true) ^ view.getUint32(4, true) ^ view.getUint32(8, true) ^ view.getUint32(12, true)) >>> 0);
            var out = [];
            for (var i = 0; i < size; i++) out[i] = i;
            for (var j = size - 1; j > 0; j--) {
                state ^= (state << 13) >>> 0;
                state ^= state >>> 17;
                state ^= (state << 5) >>> 0;
                state >>>= 0;
                var idx = state % (j + 1);
                var tmp = out[j];
                out[j] = out[idx];
                out[idx] = tmp;
            }
            return out;
        }

        function transformByte(inputByte, keyByte) {
            var rotate = keyByte % 8;
            var rotated = (((inputByte << rotate) | (inputByte >> (8 - rotate))) & 255);
            return (rotated + ((keyByte ^ 0xA5) & 255)) & 255;
        }

        function shuffleBlocks(payloadBytes, pbox) {
            var payload = payloadBytes instanceof Uint8Array ? payloadBytes : new Uint8Array(payloadBytes || []);
            var count = pbox.length;
            if (!count || payload.length % count !== 0) throw new Error("Invalid VidFast payload size");
            var blockSize = payload.length / count;
            var out = new Uint8Array(payload.length);
            for (var i = 0; i < count; i++) {
                var srcStart = pbox[i] * blockSize;
                var dstStart = i * blockSize;
                out.set(payload.slice(srcStart, srcStart + blockSize), dstStart);
            }
            return out;
        }

        async function resolve(media) {
            if (!media || !media.tmdbId) return [];
            var pageUrl = media.isMovie
                ? MAIN_URL + "/movie/" + encodeURIComponent(media.tmdbId)
                : MAIN_URL + "/tv/" + encodeURIComponent(media.tmdbId) + "/" + encodeURIComponent(media.season || 1) + "/" + encodeURIComponent(media.episode || 1);
            var html = await getText(pageUrl, headers(), true).catch(function () { return ""; });
            var rawData = firstMatch(html, [/\\\"en\\\":\\\"(.*?)\\\"/i]);
            if (!rawData) return [];

            var timestampBytes = new Uint8Array(8);
            var timestamp = Date.now();
            for (var i = 0; i < 8; i++) {
                timestampBytes[i] = timestamp & 255;
                timestamp = Math.floor(timestamp / 256);
            }

            var randomIv = randomBytes(16);
            var combined = concatBytes([randomIv, timestampBytes, utf8ToBytes(rawData)]);
            var encrypted = await encryptAesCbcPkcs7(combined, AES_KEY, AES_IV);

            var xorSeed = concatBytes([XOR_SEED_KEY, randomIv]);
            var xorHash = await sha256Bytes(xorSeed);
            var xorOutput = new Uint8Array(encrypted.length);
            for (var j = 0; j < encrypted.length; j++) {
                if (j > 0 && (j % xorHash.length) === 0) xorHash = await sha256Bytes(xorHash);
                xorOutput[j] = encrypted[j] ^ xorHash[j % xorHash.length];
            }

            var transformSeed = concatBytes([AES_KEY, randomIv]);
            var transformHash = await sha256Bytes(transformSeed);
            var transformOutput = new Uint8Array(xorOutput.length);
            for (var k = 0; k < xorOutput.length; k++) {
                transformOutput[k] = transformByte(xorOutput[k], transformHash[k % transformHash.length]);
            }

            var ksaSeed = concatBytes([randomIv, XOR_SEED_KEY, AES_IV]);
            var ksaHash = await sha256Bytes(ksaSeed);
            var ksa = generateKsa(ksaHash, 256);
            var payloadSwaps = new Uint8Array(transformOutput.length);
            for (var m = 0; m < transformOutput.length; m++) {
                payloadSwaps[m] = ksa[transformOutput[m] & 255] & 255;
            }

            var permutationCount = Math.floor(payloadSwaps.length / 16);
            if (!permutationCount) return [];
            var blockShuffleSeed = concatBytes([XOR_SEED_KEY, randomIv]);
            var blockShuffleHash = await sha256Bytes(blockShuffleSeed);
            var permKsa = generateKsa(blockShuffleHash, permutationCount);
            var shuffled = shuffleBlocks(payloadSwaps, permKsa);

            var permSeed = concatBytes([AES_KEY, randomIv, new Uint8Array([shuffled.length & 255])]);
            var permHash = await sha256Bytes(permSeed);
            var permSBox = generateKsa(permHash, 112);
            var finalPayload = new Uint8Array(permSBox.length);
            for (var n = 0; n < permSBox.length; n++) finalPayload[n] = shuffled[permSBox[n]];

            var swapOrder = new Uint8Array(permKsa.length * 4);
            for (var p = 0; p < permKsa.length; p++) swapOrder[p * 4] = permKsa[p] & 255;
            var finalBuffer = concatBytes([swapOrder, finalPayload]);
            var footerHash = await sha256Bytes(finalBuffer);
            var footer = footerHash.slice(0, 8);
            var finalPacket = concatBytes([new Uint8Array([1]), randomIv, new Uint8Array([permutationCount & 255, 0]), finalBuffer, footer]);
            var encoded = customEncode(finalPacket).split("").reverse().join("");
            var serversToken = bytesToHex(utf8ToBytes(encoded));

            var serverRows = await getJson(MAIN_URL + "/" + STATIC_PATH + "/N1dm4OEpPc8/" + serversToken, headers()).catch(function () { return []; });
            if (!Array.isArray(serverRows) || !serverRows.length || !serverRows[0].data) return [];
            var serverId = serverRows[0].data;
            var streamJson = await getJson(MAIN_URL + "/" + STATIC_PATH + "/HSgMMZOauoo/" + encodeURIComponent(serverId), headers()).catch(function () { return {}; });
            var streamUrl = trim(streamJson && streamJson.url || "");
            if (!streamUrl) return [];
            return [buildResolvedStream(streamUrl, "VidFastPro", qualityFromText(streamUrl), headers(), streamUrl)];
        }

        return {
            key: "p_vidfastpro",
            name: "VidFastPro",
            resolve: resolve
        };
    })();

    var FlixIndiaSource = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("flixindia", "https://m.flixindia.xyz");
            return cachedMainUrl;
        }

        function buildHeaders(mainUrl, cookieHeader) {
            return commonHeaders({
                "Accept": "*/*",
                "Referer": mainUrl + "/",
                "Origin": mainUrl,
                "X-Requested-With": "XMLHttpRequest",
                "Cookie": cookieHeader || ""
            });
        }

        function extractPhpSession(headers) {
            var raw = headers && headers["set-cookie"];
            if (!raw) return "";
            var parts = Array.isArray(raw) ? raw : String(raw || "").split(/,(?=[^;]+=[^;]+)/);
            for (var i = 0; i < parts.length; i++) {
                var match = String(parts[i] || "").match(/PHPSESSID=([^;]+)/i);
                if (match) return "PHPSESSID=" + match[1];
            }
            return "";
        }

        async function createSearchContext() {
            var mainUrl = await getMainUrl();
            var res = await request(mainUrl + "/", {
                headers: commonHeaders({
                    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                    "Referer": mainUrl + "/",
                    "Origin": mainUrl
                }),
                allowRedirects: true
            }).catch(function () { return null; });
            var html = res ? String(res.body || "") : "";
            var csrfToken = firstMatch(html, [/window\.CSRF_TOKEN\s*=\s*['"]([a-f0-9]{64})['"]/i]);
            return {
                mainUrl: mainUrl,
                csrfToken: csrfToken,
                cookieHeader: extractPhpSession(res && res.headers || {})
            };
        }

        async function searchRows(media) {
            var ctx = await createSearchContext();
            if (!ctx.csrfToken) return [];
            var titles = uniqueBy([
                buildSearchTitleForEpisode(media.title, media.year, media.isMovie ? null : media.season, media.episode),
                buildSearchTitleForEpisode(media.originalTitle, media.year, media.isMovie ? null : media.season, media.episode),
                trim(String(media.title || "")),
                trim(String(media.originalTitle || ""))
            ], function (item) { return normalizeTitle(item); }).filter(Boolean);

            var settled = await mapLimit(titles, 3, async function (title) {
                var form = "action=search"
                    + "&csrf_token=" + encodeURIComponent(ctx.csrfToken)
                    + "&q=" + encodeURIComponent(title);
                var res = await request(ctx.mainUrl + "/", {
                    method: "POST",
                    body: form,
                    headers: Object.assign({}, buildHeaders(ctx.mainUrl, ctx.cookieHeader), {
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                    }),
                    allowRedirects: true
                }).catch(function () { return null; });
                var json = res ? parseJsonSafe(res.body, null) : null;
                return parseJsonResultsRows(json).map(function (item) {
                    var href = trim(String(item && (item.url || item.link || item.href) || ""));
                    var title = trim(String(item && (item.title || item.name || item.label) || ""));
                    return href ? {
                        title: title,
                        url: absoluteUrl(ctx.mainUrl, href),
                        year: Number(item && item.year) || undefined,
                        type: /series|season|episode|tv/i.test(title + " " + href) ? "series" : "movie"
                    } : null;
                }).filter(Boolean);
            });
            var rows = flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
            rows = uniqueBy(rows, function (item) { return item && item.url; });
            if (rows.length) return { rows: rows, ctx: ctx };
            return { rows: [], ctx: ctx };
        }

        async function resolveResultPage(url, referer) {
            if (!url) return [];
            var resolved = await resolveCommonExtractorUrl(url, "FlixIndia", referer || url, 0);
            if (resolved.length) {
                for (var r = 0; r < resolved.length; r++) {
                    resolved[r].source = withSimplifiedSource(resolved[r].source || "FlixIndia", url);
                }
                return resolved;
            }

            var html = await getText(url, commonHeaders({ "Referer": referer || (baseOrigin(url) + "/") }), true).catch(function () { return ""; });
            if (!html) return [];
            var links = extractExternalSourceLinks(html, url);
            var settled = await mapLimit(links.slice(0, 8), PROVIDER_LINK_CONCURRENCY, function (link) {
                return resolveCommonExtractorUrl(link.url, "FlixIndia", url, 0);
            });
            var out = flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));
            for (var j = 0; j < out.length; j++) {
                out[j].source = withSimplifiedSource(out[j].source || "FlixIndia", links[0] && (links[0].label || links[0].url) || url);
            }
            return dedupeStreams(out);
        }

        async function resolve(media) {
            if (!media || !media.title) return [];
            var search = await searchRows(media);
            var rows = search.rows || [];
            var ctx = search.ctx || {};
            if (!rows.length) return [];
            var queries = uniqueBy([media.title, media.originalTitle], function (item) { return normalizeTitle(item); }).filter(Boolean);
            var matches = rankedMatches(rows, queries, media.year, media.isMovie ? "movie" : null, PROVIDER_CANDIDATE_LIMIT);
            if (!matches.length) matches = rows.slice(0, PROVIDER_CANDIDATE_LIMIT);
            var settled = await mapLimit(matches, 2, function (match) {
                return resolveResultPage(match.url, (ctx.mainUrl || "") + "/");
            });
            return dedupeStreams(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
        }

        return {
            key: "p_flixindia",
            name: "FlixIndia",
            resolve: resolve
        };
    })();

    var FourKhdhubSource = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("4khdhub", "https://4khdhub.click");
            return cachedMainUrl;
        }

        function headers(extra) {
            return commonHeaders(Object.assign({
                "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
            }, extra || {}));
        }

        function decodeBase64Text(value) {
            try {
                return bytesToUtf8(base64DecodeToBytes(String(value || "")));
            } catch (_) {
                return "";
            }
        }

        function rot13(value) {
            return String(value || "").replace(/[a-zA-Z]/g, function (char) {
                var code = char.charCodeAt(0);
                var limit = code <= 90 ? 90 : 122;
                code += 13;
                return String.fromCharCode(code <= limit ? code : (code - 26));
            });
        }

        function parseSearchRows(html, mainUrl) {
            var out = [];
            var seen = {};
            var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*movie-card[^"']*["'][^>]*>([\s\S]*?)<\/a>/gi;
            var match;
            while ((match = regex.exec(String(html || ""))) !== null) {
                var href = absoluteUrl(mainUrl, decodeHtml(match[1]));
                if (!href || seen[href]) continue;
                var block = match[2] || "";
                var title = stripTags(firstMatch(block, [/<h[23]\b[^>]*class=["'][^"']*movie-card-title[^"']*["'][^>]*>([\s\S]*?)<\/h[23]>/i]));
                if (!title) continue;
                var meta = stripTags(firstMatch(block, [/<p\b[^>]*class=["'][^"']*movie-card-meta[^"']*["'][^>]*>([\s\S]*?)<\/p>/i]));
                var formatText = stripTags((block.match(/<span\b[^>]*class=["'][^"']*movie-card-format[^"']*["'][^>]*>[\s\S]*?<\/span>/gi) || []).join(" "));
                var infoText = title + " " + meta + " " + formatText + " " + href;
                seen[href] = true;
                out.push({
                    title: trim(title),
                    year: Number(firstMatch(meta, [/(\d{4})/])) || undefined,
                    type: /series|s\d+\s*-\s*s\d+|season/i.test(infoText) ? "series" : "movie",
                    url: href
                });
            }
            return out;
        }

        function parseDownloadAnchors(block, baseUrl) {
            return parseAnchors(block, baseUrl).filter(function (item) {
                return !!(item && item.href)
                    && /^https?:\/\//i.test(item.href)
                    && /download|hubcloud|hubdrive/i.test(String(item.text || "") + " " + item.href);
            }).map(function (item) {
                return {
                    url: item.href,
                    label: trim(item.text || "")
                };
            });
        }

        function parseMovieLinks(html, pageUrl) {
            var blocks = String(html || "").match(/<div\b[^>]*class=["'][^"']*download-item[^"']*["'][\s\S]*?<\/div>\s*<\/div>/gi) || [];
            var out = [];
            for (var i = 0; i < blocks.length; i++) {
                var quality = qualityFromText(stripTags(blocks[i]));
                var anchors = parseDownloadAnchors(blocks[i], pageUrl);
                for (var j = 0; j < anchors.length; j++) {
                    out.push({
                        url: anchors[j].url,
                        label: anchors[j].label,
                        quality: quality,
                        title: stripTags(blocks[i])
                    });
                }
            }
            if (out.length) return uniqueBy(out, function (item) { return item.url; });
            return extractExternalSourceLinks(html, pageUrl).map(function (row) {
                return {
                    url: row.url,
                    label: row.label,
                    quality: qualityFromText(row.label || row.url),
                    title: row.label || row.url
                };
            });
        }

        function parseEpisodeLinks(html, pageUrl, season, episode) {
            var blocks = String(html || "").match(/<div\b[^>]*class=["'][^"']*episode-download-item[^"']*["'][\s\S]*?<\/div>\s*<\/div>/gi) || [];
            var target = "S" + String(season || 1).padStart(2, "0") + "E" + String(episode || 1).padStart(2, "0");
            var out = [];
            for (var i = 0; i < blocks.length; i++) {
                var title = stripTags(firstMatch(blocks[i], [/<div\b[^>]*class=["'][^"']*episode-file-title[^"']*["'][^>]*>([\s\S]*?)<\/div>/i])) || stripTags(blocks[i]);
                if (target && title.toUpperCase().indexOf(target) === -1) continue;
                var quality = qualityFromText(title);
                var anchors = parseDownloadAnchors(blocks[i], pageUrl);
                for (var j = 0; j < anchors.length; j++) {
                    out.push({
                        url: anchors[j].url,
                        label: anchors[j].label,
                        quality: quality,
                        title: title
                    });
                }
            }
            return uniqueBy(out, function (item) { return item.url; });
        }

        async function decodeMediatorPayload(url) {
            var startRes = await request(url, {
                headers: headers({ "Referer": baseOrigin(url) + "/" }),
                allowRedirects: false
            }).catch(function () { return null; });
            var location = normalizeResolvedUrl(startRes && (startRes.headers.location || startRes.headers["x-redirect-location"]) || "", baseOrigin(url));
            var targetUrl = location || url;
            var html = await getText(targetUrl, headers({ "Referer": baseOrigin(targetUrl) + "/" }), true).catch(function () { return ""; });
            if (!html) return "";
            var payload = firstMatch(html, [
                /s\(\s*['"]o['"]\s*,\s*['"]([^'"]+)['"]/i,
                /localStorage\.setItem\(\s*['"]o['"]\s*,\s*['"]([^'"]+)['"]/i
            ]);
            if (!payload) return "";
            var step1 = decodeBase64Text(payload);
            var step2 = decodeBase64Text(step1);
            var step3 = rot13(step2);
            var decoded = parseJsonSafe(decodeBase64Text(step3), null);
            var finalUrl = decoded && decoded.o ? decodeBase64Text(decoded.o) : "";
            return normalizeResolvedUrl(finalUrl, baseOrigin(targetUrl));
        }

        async function resolveLinkRow(item, referer) {
            var sourceUrl = trim(item && item.url || "");
            if (!sourceUrl) return [];
            var quality = Number(item && item.quality || 0) || qualityFromText(item && item.label || sourceUrl);
            var targetUrl = sourceUrl;
            if (/gadgetsweb\.xyz/i.test(sourceUrl)) {
                targetUrl = await decodeMediatorPayload(sourceUrl) || sourceUrl;
            }
            var streams = await resolveCommonExtractorUrl(targetUrl, "4Khdhub", referer || sourceUrl, 0);
            streams = streams.filter(function (stream) {
                var streamUrl = trim(stream && stream.url || "");
                return streamUrl
                    && !/hubcloud\.[^/]+\/drive\/admin\/?$/i.test(streamUrl)
                    && !/t\.me\/|telegram/i.test(streamUrl);
            });
            for (var i = 0; i < streams.length; i++) {
                if (!streams[i].quality) streams[i].quality = quality;
                streams[i].source = withSimplifiedSource(streams[i].source || "4Khdhub", item && (item.title || item.label) || targetUrl);
            }
            return streams;
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var html = await getText(mainUrl + "/?s=" + encodeURIComponent(query), headers({ "Referer": mainUrl + "/" }), true);
                    var rows = parseSearchRows(html, mainUrl);
                    if (rows.length) return rows;
                } catch (_) {}
            }
            return [];
        }

        async function resolve(media) {
            if (media.anime) return [];
            var queries = uniqueBy([media.title, media.originalTitle], function (item) {
                return normalizeTitle(item);
            }).filter(Boolean);
            var rows = await searchTitles(queries);
            var matches = rankedMatches(rows, queries, media.year, media.isMovie ? "movie" : "series", PROVIDER_CANDIDATE_LIMIT);
            if (!matches.length) return [];
            var settled = await mapLimit(matches, 2, async function (match) {
                if (!match || !match.url) return [];
                var pageHtml = await getText(match.url, headers({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
                if (!pageHtml) return [];

                var links = media.isMovie
                    ? parseMovieLinks(pageHtml, match.url)
                    : parseEpisodeLinks(pageHtml, match.url, media.season, media.episode);
                if (!links.length) return [];

                var resolved = await mapLimit(links.slice(0, 10), PROVIDER_LINK_CONCURRENCY, function (link) {
                    return resolveLinkRow(link, match.url);
                });
                return dedupeStreams(flatten(resolved.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            });
            return dedupeStreams(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
        }

        return {
            key: "p_4khdhub",
            name: "4Khdhub",
            resolve: resolve
        };
    })();

    var VegaMoviesSource = (function () {
        var cachedMainUrl = "";
        var CINEMETA_URL = "https://v3-cinemeta.strem.io/meta";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("vegamovies", "https://vegamovies.vodka");
            return cachedMainUrl;
        }

        function vmHeaders(extra) {
            return commonHeaders(Object.assign({
                "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                "Accept-Language": "en-US,en;q=0.9"
            }, extra || {}));
        }

        async function vmGetDocument(url, headers, allowRedirects) {
            var res = await request(url, {
                headers: headers || vmHeaders(),
                allowRedirects: allowRedirects !== false
            }).catch(function () { return null; });
            if (!res || res.status >= 400) return null;
            return {
                body: String(res.body || ""),
                finalUrl: res.finalUrl || url,
                headers: res.headers || {}
            };
        }

        function vmExtractAttr(tag, name) {
            var quoted = new RegExp("\\b" + name + "\\s*=\\s*([\"'])([\\s\\S]*?)\\1", "i").exec(String(tag || ""));
            if (quoted) return decodeHtml(quoted[2]);
            var bare = new RegExp("\\b" + name + "\\s*=\\s*([^\\s>]+)", "i").exec(String(tag || ""));
            return bare ? decodeHtml(bare[1]) : "";
        }

        function vmExtractMeta(html, property) {
            var escaped = property.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
            return firstMatch(html, [
                new RegExp("<meta[^>]+property=[\"']" + escaped + "[\"'][^>]+content=[\"']([^\"']+)[\"']", "i"),
                new RegExp("<meta[^>]+name=[\"']" + escaped + "[\"'][^>]+content=[\"']([^\"']+)[\"']", "i"),
                new RegExp("<meta[^>]+content=[\"']([^\"']+)[\"'][^>]+property=[\"']" + escaped + "[\"']", "i"),
                new RegExp("<meta[^>]+content=[\"']([^\"']+)[\"'][^>]+name=[\"']" + escaped + "[\"']", "i")
            ]);
        }

        function vmParseAnchors(html, base) {
            var source = String(html || "");
            var out = [];
            var regex = /<a\b([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
            var match;
            while ((match = regex.exec(source)) !== null) {
                out.push({
                    href: absoluteUrl(base, decodeHtml(match[2])),
                    text: stripTags(match[4]),
                    html: match[0],
                    attrs: (match[1] || "") + " " + (match[3] || "")
                });
            }
            return out;
        }

        function vmExtractImdbUrl(html) {
            var anchors = vmParseAnchors(html, "");
            for (var i = 0; i < anchors.length; i++) {
                if (/imdb\.com\/title\//i.test(anchors[i].href)) return anchors[i].href;
            }
            return "";
        }

        function vmCleanTitle(value) {
            return trim(decodeHtml(String(value || ""))
                .replace(/^Download\s+/i, "")
                .replace(/\s*[-|]\s*Vegamovies(?:\.[a-z]+)?(?:\.hot|\.is|\.to|\.vodka)?\s*$/i, "")
                .replace(/\s*-\s*Nexdrive\.Pro\s*$/i, ""));
        }

        function vmMediaType(value) {
            return /\b(?:season|series|episode|web[\s-]*series)\b/i.test(String(value || "")) ? "series" : "movie";
        }

        function vmExtractListingItems(html, pageUrl) {
            var items = [];
            var seen = {};
            var anchors = vmParseAnchors(html, pageUrl);
            for (var i = 0; i < anchors.length; i++) {
                var anchor = anchors[i];
                if (!/\/download-/i.test(anchor.href)) continue;
                if (seen[anchor.href]) continue;
                var imgTag = firstMatch(anchor.html, [/(<img\b[\s\S]*?>)/i]);
                var title = vmCleanTitle(vmExtractAttr(imgTag, "alt") || anchor.text);
                var poster = vmExtractAttr(imgTag, "data-src") || vmExtractAttr(imgTag, "src");
                if (/^data:image\//i.test(poster)) poster = vmExtractAttr(imgTag, "data-src");
                if (!title || title.length < 3) continue;
                seen[anchor.href] = true;
                items.push({
                    title: title,
                    url: anchor.href,
                    posterUrl: absoluteUrl(pageUrl, poster),
                    type: vmMediaType(title),
                    quality: qualityFromText(title)
                });
            }
            return items;
        }

        function vmQualityGroups(html, base) {
            var groups = [];
            var re = /<h([35])\b[^>]*>([\s\S]*?)<\/h\1>\s*<p\b[^>]*>([\s\S]*?)<\/p>/gi;
            var match;
            while ((match = re.exec(String(html || ""))) !== null) {
                var headingText = stripTags(match[2] || "");
                if (!/(?:4k|\d{3,4}\s*p)/i.test(headingText) || /zip/i.test(headingText)) continue;
                var anchors = vmParseAnchors(match[3] || "", base);
                if (!anchors.length) continue;
                groups.push({
                    title: headingText,
                    season: Number(firstMatch(headingText, [/(?:Season\s*|S)(\d+)/i])) || 1,
                    quality: qualityFromText(headingText),
                    size: firstMatch(headingText, [/\[((?:\d+(?:\.\d+)?\s*)?(?:GB|MB|KB)(?:\/E)?)\]/i, /\b(\d+(?:\.\d+)?\s*(?:GB|MB|KB)(?:\/E)?)\b/i]),
                    anchors: anchors
                });
            }
            return groups;
        }

        function vmSelectSeriesIntermediateAnchor(group) {
            var anchors = group.anchors || [];
            for (var i = 0; i < anchors.length; i++) {
                if (/(?:V-?Cloud|Episode|Download)/i.test(anchors[i].text + " " + anchors[i].href) && !/batch|zip/i.test(anchors[i].text)) {
                    return anchors[i];
                }
            }
            for (var j = 0; j < anchors.length; j++) {
                if (/G-?Direct/i.test(anchors[j].text)) return anchors[j];
            }
            return anchors[0] || null;
        }

        function vmSourceLabel(anchor) {
            var value = String((anchor && (anchor.href + " " + anchor.text)) || "");
            if (/vcloud/i.test(value)) return "V-Cloud";
            if (/fastdl|g-direct/i.test(value)) return "G-Direct";
            if (/gdtot/i.test(value)) return "GDToT";
            if (/filebee/i.test(value)) return "FileBee";
            if (/filepress/i.test(value)) return "Filepress";
            if (/pixeldrain/i.test(value)) return "Pixeldrain";
            if (/hubcloud|hubdrive/i.test(value)) return "HubCloud";
            return trim(anchor && anchor.text) || "Source";
        }

        function vmUsefulAnchor(anchor) {
            var value = String((anchor && (anchor.href + " " + anchor.text)) || "");
            if (!/^https?:\/\//i.test(anchor && anchor.href || "")) return false;
            if (/#(?:content)?$/i.test(anchor && anchor.href || "")) return false;
            if (/vglist|xmlrpc|wp-json|wp-content|telegram|google\.com\/search|one\.one\.one\.one|tinyurl\.com\/Unblock/i.test(value)) return false;
            return /vcloud|fastdl|g-direct|filebee|filepress|gdtot|drive|hubcloud|hubdrive|pixeldrain|dropgalaxy|uploadever/i.test(value);
        }

        function vmExtractNexdriveSources(html, pageUrl, context) {
            var anchors = vmParseAnchors(html, pageUrl).filter(vmUsefulAnchor);
            var vcloud = anchors.filter(function (anchor) { return /vcloud/i.test(anchor.href + " " + anchor.text); });
            var chosen = vcloud.length ? [vcloud[0]] : anchors;
            return uniqueBy(chosen.map(function (anchor) {
                return {
                    source: anchor.href,
                    sourceName: vmSourceLabel(anchor),
                    title: context && context.title || "",
                    quality: (context && context.quality) || qualityFromText(anchor.text + " " + anchor.href),
                    referer: pageUrl
                };
            }), function (item) { return item.source; });
        }

        function vmExtractEpisodeVcloudSources(html, pageUrl, context) {
            var anchors = vmParseAnchors(html, pageUrl);
            var out = [];
            var episode = 0;
            for (var i = 0; i < anchors.length; i++) {
                if (!/vcloud/i.test(anchors[i].href + " " + anchors[i].text)) continue;
                episode++;
                out.push({
                    episode: episode,
                    source: anchors[i].href,
                    sourceName: "V-Cloud",
                    title: context && context.title || "",
                    quality: context && context.quality || qualityFromText(anchors[i].text + " " + anchors[i].href),
                    referer: pageUrl
                });
            }
            return out;
        }

        function vmHubButtons(html, base) {
            return vmParseAnchors(html, base).filter(function (anchor) {
                var value = anchor.text + " " + anchor.href + " " + anchor.html + " " + anchor.attrs;
                if (/telegram|tutorial|admin|login|one\.one\.one\.one|tinyurl\.com\/Unblock/i.test(value)) return false;
                return /btn|FSL|Mega|Download File|BuzzServer|10Gbps|pixeldrain|hub\.shipcdn|hubcdn\.fans/i.test(value);
            });
        }

        async function vmResolveFinalUrl(startUrl, referer) {
            var currentUrl = startUrl;
            for (var i = 0; i < 7; i++) {
                try {
                    var res = await request(currentUrl, {
                        method: "HEAD",
                        headers: vmHeaders({ "Referer": referer || baseOrigin(currentUrl) + "/" }),
                        allowRedirects: false
                    });
                    var location = res.headers.location || res.headers.Location || "";
                    if (!location) return currentUrl;
                    currentUrl = absoluteUrl(currentUrl, location);
                } catch (_) {
                    return currentUrl;
                }
            }
            return currentUrl;
        }

        function vmVcloudJump(html, baseUrl) {
            var link = firstMatch(html, [
                /var\s+url\s*=\s*'([^']+)'/i,
                /var\s+url\s*=\s*"([^"]+)"/i,
                /<div\b[^>]*class=["'][^"']*\bvd\b[^"']*["'][^>]*>[\s\S]*?<center>[\s\S]*?<a\b[^>]+href=["']([^"']+)["']/i
            ]);
            return link ? absoluteUrl(baseUrl, link) : "";
        }

        function vmIntentUrls(html) {
            var out = [];
            var re = /createIntentURL\(\{[\s\S]*?host:\s*(['"])(https?:\/\/[\s\S]*?)\1[\s\S]*?\}/gi;
            var match;
            while ((match = re.exec(String(html || ""))) !== null) out.push(decodeHtml(match[2]).replace(/\\\//g, "/"));
            return out;
        }

        async function vmResolveVcloud(source, context) {
            var sourceUrl = typeof source === "string" ? source : source.source;
            var base = baseOrigin(sourceUrl);
            var latestBase = await getDynamicDomain(/hubcloud|gamerxyt/i.test(sourceUrl) ? "hubcloud" : "vcloud", base);
            var newUrl = base && latestBase && base !== latestBase ? sourceUrl.replace(base, latestBase) : sourceUrl;
            var entry = await vmGetDocument(newUrl, vmHeaders({ "Referer": source.referer || context.sourceUrl || ((await getMainUrl()) + "/") }), true);
            if (!entry) return [];
            var jumpUrl = /gamerxyt\.com\/hubcloud\.php|hubcloud\./i.test(newUrl) ? newUrl : vmVcloudJump(entry.body, entry.finalUrl || newUrl);
            if (!jumpUrl) return [];
            var document = await vmGetDocument(jumpUrl, vmHeaders({ "Referer": entry.finalUrl || newUrl }), true);
            if (!document) return [];
            var quality = source.quality || qualityFromText(source.title + " " + sourceUrl + " " + context.title);
            var results = [];
            var buttons = vmHubButtons(document.body, document.finalUrl || jumpUrl);
            for (var i = 0; i < buttons.length; i++) {
                var text = buttons[i].text;
                var link = buttons[i].href;
                if (!link) continue;
                if (/BuzzServer/i.test(text)) {
                    try {
                        var buzzRes = await request(link.replace(/\/$/, "") + "/download", {
                            headers: vmHeaders({ "Referer": link }),
                            allowRedirects: false
                        });
                        var redirect = buzzRes.headers["hx-redirect"] || buzzRes.headers.location || "";
                if (redirect) results.push(buildResolvedStream(absoluteUrl(baseOrigin(link), redirect), "VegaMovies [BuzzServer]", quality, {}, context.title || text || redirect));
                    } catch (_) {}
                    continue;
                }
                if (/pixeldra/i.test(link + " " + text)) {
                    var pixelBase = baseOrigin(link);
                    var pixelUrl = /download/i.test(link) ? link : pixelBase + "/api/file/" + link.split("/").pop() + "?download";
                    results.push(buildResolvedStream(pixelUrl, "VegaMovies [Pixeldrain]", quality, {}, context.title || text || pixelUrl));
                    continue;
                }
                if (/Server\s*:\s*10Gbps/i.test(text)) {
                    var redirectUrl = await vmResolveFinalUrl(link, document.finalUrl || jumpUrl);
                    if (/link=/i.test(redirectUrl)) redirectUrl = decodeURIComponent(redirectUrl.substring(redirectUrl.indexOf("link=") + 5));
                    results.push(buildResolvedStream(redirectUrl, "VegaMovies [Download]", quality, {}, context.title || text || redirectUrl));
                    continue;
                }
                if (/FSLv2/i.test(text)) results.push(buildResolvedStream(link, "VegaMovies [FSLv2]", quality, {}, context.title || text || link));
                else if (/FSL Server/i.test(text)) results.push(buildResolvedStream(link, "VegaMovies [FSL]", quality, {}, context.title || text || link));
                else if (/Mega Server/i.test(text)) results.push(buildResolvedStream(link, "VegaMovies [Mega]", quality, {}, context.title || text || link));
                else if (/Download File/i.test(text)) results.push(buildResolvedStream(link, "VegaMovies", quality, {}, context.title || text || link));
            }
            var directUrls = vmIntentUrls(document.body);
            for (var j = 0; j < directUrls.length; j++) results.push(buildResolvedStream(directUrls[j], "VegaMovies [Direct]", quality, {}, context.title || directUrls[j]));
            return uniqueBy(results, function (item) { return item.url + "|" + item.source; });
        }

        async function vmResolveGeneric(source, context) {
            var sourceUrl = typeof source === "string" ? source : source.source;
            var sourceName = source.sourceName || "VegaMovies";
            var headers = { "Referer": source.referer || context.sourceUrl || ((await getMainUrl()) + "/") };
            var quality = source.quality || qualityFromText(source.title + " " + sourceUrl + " " + context.title);
            if (/vcloud|gamerxyt\.com\/hubcloud\.php|hubcloud\./i.test(sourceUrl)) {
                var vcloud = await vmResolveVcloud(source, context);
                if (vcloud.length) return vcloud;
            }
            if (isCommonDirectMediaUrl(sourceUrl)) return [buildResolvedStream(sourceUrl, sourceName, quality, headers, context.title || source.title || sourceUrl)];
            return [buildResolvedStream(sourceUrl, sourceName, quality, headers, context.title || source.title || sourceUrl)];
        }

        async function vmFetchCinemeta(type, imdbUrl) {
            var imdbId = firstMatch(imdbUrl, [/title\/(tt\d+)/i]);
            if (!imdbId) return null;
            try {
                var mediaType = type === "movie" ? "movie" : "series";
                var json = await getJson(CINEMETA_URL + "/" + mediaType + "/" + imdbId + ".json", vmHeaders({ "Accept": "application/json,*/*" }));
                return json && json.meta ? json.meta : null;
            } catch (_) {
                return null;
            }
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var json = await getJson(mainUrl + "/search.php?q=" + encodeURIComponent(query) + "&page=1", vmHeaders({ "Accept": "application/json,*/*", "Referer": mainUrl + "/" }));
                    var hits = json && Array.isArray(json.hits) ? json.hits : [];
                    var rows = hits.map(function (hit) {
                        var doc = hit && hit.document || {};
                        return {
                            title: vmCleanTitle(doc.post_title || ""),
                            url: absoluteUrl(mainUrl, doc.permalink || ""),
                            posterUrl: doc.post_thumbnail || "",
                            type: vmMediaType((doc.post_title || "") + " " + ((doc.category || []).join ? doc.category.join(" ") : "")),
                            quality: qualityFromText(doc.post_title || "")
                        };
                    }).filter(function (item) { return item && item.title && item.url; });
                    if (rows.length) return rows;
                } catch (_) {}
            }
            return [];
        }

        async function resolve(media) {
            if (media.anime) return [];
            var queries = uniqueBy([media.title, media.originalTitle, media.imdbId], function (item) { return trim(String(item || "").toLowerCase()); }).filter(Boolean);
            var rows = await searchTitles(queries);
            var match = bestMatch(rows, queries, media.year, media.isMovie ? "movie" : null);
            if (!match || !match.url) return [];

            var pageUrl = match.url;
            var res = await vmGetDocument(pageUrl, vmHeaders({ "Referer": (await getMainUrl()) + "/" }), true);
            if (!res) return [];
            pageUrl = res.finalUrl || pageUrl;
            var html = res.body || "";
            var title = vmCleanTitle(firstMatch(html, [/<h1\b[^>]*>([\s\S]*?)<\/h1>/i, /<title\b[^>]*>([\s\S]*?)<\/title>/i])) || match.title || media.title;
            var imdbUrl = vmExtractImdbUrl(html);
            var type = /Series-SYNOPSIS\/PLOT|Series Info|Series synopsis\/PLOT/i.test(html) || vmMediaType(title) === "series" ? "series" : "movie";
            var meta = await vmFetchCinemeta(type, imdbUrl);

            if (type === "movie" && media.isMovie) {
                var groups = vmQualityGroups(html, pageUrl);
                var sources = [];
                for (var i = 0; i < groups.length; i++) {
                    for (var j = 0; j < groups[i].anchors.length; j++) {
                        var anchor = groups[i].anchors[j];
                        if (!/dwd-button|Download/i.test(anchor.html + " " + anchor.text)) continue;
                        try {
                            var linkPage = await vmGetDocument(anchor.href, vmHeaders({ "Referer": pageUrl }), true);
                            if (!linkPage) continue;
                            sources = sources.concat(vmExtractNexdriveSources(linkPage.body, linkPage.finalUrl || anchor.href, {
                                title: groups[i].title,
                                quality: groups[i].quality
                            }));
                        } catch (_) {}
                    }
                }
                sources = uniqueBy(sources, function (item) { return item.source; });
                var streams = [];
                for (var x = 0; x < sources.length; x++) {
                    streams = streams.concat(await vmResolveGeneric(sources[x], {
                        sourceUrl: pageUrl,
                        title: meta && meta.name || title,
                        type: "movie",
                        season: 1,
                        episode: 1
                    }));
                }
                return dedupeStreams(streams);
            }
            if (type === "series" && !media.isMovie) {
                var seriesGroups = vmQualityGroups(html, pageUrl);
                var seriesSources = [];
                for (var y = 0; y < seriesGroups.length; y++) {
                    var group = seriesGroups[y];
                    if (media.season && Number(group.season || 1) !== Number(media.season)) continue;
                    var anchor = vmSelectSeriesIntermediateAnchor(group);
                    if (!anchor || !anchor.href) continue;
                    try {
                        var seriesPage = await vmGetDocument(anchor.href, vmHeaders({ "Referer": pageUrl }), true);
                        if (!seriesPage) continue;
                        var episodeSources = vmExtractEpisodeVcloudSources(seriesPage.body, seriesPage.finalUrl || anchor.href, {
                            title: group.title,
                            quality: group.quality
                        });
                        for (var z = 0; z < episodeSources.length; z++) {
                            if (media.episode && Number(episodeSources[z].episode) !== Number(media.episode)) continue;
                            seriesSources.push(episodeSources[z]);
                        }
                    } catch (_) {}
                }
                seriesSources = uniqueBy(seriesSources, function (item) { return item.source; });
                var seriesStreams = [];
                for (var q = 0; q < seriesSources.length; q++) {
                    seriesStreams.push(buildResolvedStream(
                        seriesSources[q].source,
                        seriesSources[q].sourceName || "VegaMovies",
                        seriesSources[q].quality || qualityFromText(seriesSources[q].title || ""),
                        { "Referer": seriesSources[q].referer || pageUrl }
                    ));
                }
                return dedupeStreams(seriesStreams);
            }
            return [];
        }

        return {
            key: "p_vegamovies",
            name: "VegaMovies",
            resolve: resolve
        };
    })();

    var MoviesDriveExtraSource = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("moviesdrive", "https://new2.moviesdrives.my");
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
            var out = [];
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                try {
                    var json = await getJson(mainUrl + "/searchapi.php?q=" + encodeURIComponent(query) + "&page=1", commonHeaders({
                        "Accept": "application/json, text/plain, */*",
                        "Referer": mainUrl + "/search.html?q=" + encodeURIComponent(query)
                    }));
                    var results = parseSearchRows(json, mainUrl);
                    if (results.length) out = out.concat(results);
                } catch (_) {}
            }
            return uniqueBy(out, function (item) { return item && item.url; });
        }

        function isSeriesTitle(title) {
            return /series|season|episode/i.test(String(title || ""));
        }

        function parseButtonRows(html, base) {
            var out = [];
            var regex = /<h5\b[^>]*>([\s\S]*?)<\/h5>/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var anchors = parseAnchors(match[1], base);
                for (var i = 0; i < anchors.length; i++) {
                    if (!anchors[i].href) continue;
                    out.push({ url: anchors[i].href, text: anchors[i].text || "" });
                }
            }
            return uniqueBy(out, function (item) { return item.url + "|" + item.text; });
        }

        function seasonFromText(text, fallback) {
            var match = String(text || "").match(/(?:season|s)\s*(\d+)/i);
            return match ? Number(match[1]) : Number(fallback || 1);
        }

        function episodeFromText(text, fallback) {
            var match = String(text || "").match(/(?:episode|ep|e)\s*(\d+)/i);
            return match ? Number(match[1]) : Number(fallback || 1);
        }

        function parseLinkRowsWithContext(html, base) {
            var out = [];
            var regex = /<a\b[^>]*href=["']([^"']+)["'][^>]*>([\s\S]*?)<\/a>/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                out.push({
                    href: absoluteUrl(base, decodeHtml(match[1])),
                    text: stripTags(match[2] || ""),
                    context: String(html || "").slice(Math.max(0, match.index - 500), Math.min(String(html || "").length, match.index + match[0].length + 500))
                });
            }
            return out;
        }

        function parseFinalButtonRows(html, base, quality) {
            var out = [];
            var regex = /<a\b([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var attrs = String(match[1] || "") + " " + String(match[3] || "");
                var className = firstMatch(attrs, [/class=["']([^"']+)["']/i]);
                var href = absoluteUrl(base, decodeHtml(match[2]));
                var text = stripTags(match[4] || "");
                if (!/\bbtn\b/i.test(className)) continue;
                if (/fsl server|fslv2|download file|s3 server|mega server|10gbps/i.test(text)) {
                    out.push(buildResolvedStream(href, "MoviesDrive", quality, commonHeaders(), text || href));
                } else if (/pixeldrain|pixel server/i.test(text)) {
                    var pixelId = firstMatch(href, [/\/u\/([A-Za-z0-9]+)/i]);
                    if (pixelId) out.push(buildResolvedStream("https://pixeldrain.com/api/file/" + pixelId + "?download", "MoviesDrive", quality, commonHeaders(), text || href));
                }
            }
            return dedupeStreams(out);
        }

        async function extractHubCloudLike(url, quality) {
            var headers = commonHeaders({ "Cookie": "xla=s4t" });
            var firstRes = await request(url, {
                headers: headers,
                allowRedirects: true
            }).catch(function () { return null; });
            var firstHtml = firstRes ? String(firstRes.body || "") : "";
            if (!firstHtml) return [];

            if (/gamerxyt\.com/i.test(url) || /Download Link Generated/i.test(firstHtml)) {
                return parseFinalButtonRows(firstHtml, baseOrigin(url), quality);
            }

            var nextHref = firstMatch(firstHtml, [
                /id=["']download["'][^>]*href=["']([^"']+)["']/i,
                /href=["']([^"']+)["'][^>]*id=["']download["']/i
            ]);
            if (!nextHref) return [];

            var nextUrl = absoluteUrl(baseOrigin(url), nextHref);
            var nextHtml = await getText(nextUrl, commonHeaders({
                "Cookie": "xla=s4t",
                "Referer": url
            }), true).catch(function () { return ""; });
            if (!nextHtml) return [];
            return parseFinalButtonRows(nextHtml, baseOrigin(nextUrl), quality);
        }

        async function collectLinkRows(media, match, html) {
            var buttons = parseButtonRows(html, match.url);
            var isSeries = !media.isMovie || isSeriesTitle(match.title);
            var settled = await mapLimit(buttons.slice(0, 8), 3, async function (button) {
                var season = seasonFromText(button.text, media.season || 1);
                if (isSeries && media.season && season !== Number(media.season)) return [];

                var pageHtml = await getText(button.url, commonHeaders({ "Referer": match.url }), true).catch(function () { return ""; });
                if (!pageHtml) return [];
                var links = parseLinkRowsWithContext(pageHtml, button.url);
                if (!links.length) return [];
                var collected = [];

                if (!isSeries) {
                    for (var j = 0; j < links.length; j++) {
                        var movieLink = links[j];
                        var movieText = String(movieLink.text || "").toLowerCase();
                        if (!(/hubcloud|gdflix|gdlink|gdtot/i.test(movieLink.href) || movieText.indexOf("hubcloud") !== -1)) continue;
                        collected.push({
                            url: movieLink.href,
                            quality: qualityFromText(button.text || match.title),
                            label: button.text || match.title
                        });
                    }
                    return collected;
                }

                for (var k = 0; k < links.length; k++) {
                    var row = links[k];
                    var lowerText = String(row.text || "").toLowerCase();
                    if (!(/hubcloud|gdflix|gdlink|gdtot/i.test(row.href) || lowerText.indexOf("hubcloud") !== -1)) continue;
                    var episode = episodeFromText(row.text, episodeFromText(row.context, k + 1));
                    if (media.episode && episode !== Number(media.episode)) continue;
                    collected.push({
                        url: row.href,
                        quality: qualityFromText(button.text || row.text || match.title),
                        label: button.text || row.text || match.title
                    });
                }
                return collected;
            });
            var collected = flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));

            if (!collected.length) {
                var fallbackRows = extractExternalSourceLinks(html, match.url);
                for (var m = 0; m < fallbackRows.length; m++) {
                    collected.push({
                        url: fallbackRows[m].url,
                        quality: qualityFromText(fallbackRows[m].label || match.title),
                        label: fallbackRows[m].label || match.title
                    });
                }
            }

            collected = uniqueBy(collected, function (item) { return item.url + "|" + item.quality; });
            collected.sort(function (a, b) {
                function score(item) {
                    var url = String(item && item.url || "");
                    if (/hubcloud/i.test(url)) return 3;
                    if (/gdflix|gdlink/i.test(url)) return 2;
                    if (/gdtot/i.test(url)) return 1;
                    return 0;
                }
                var qualityDiff = Number(b && b.quality || 0) - Number(a && a.quality || 0);
                if (qualityDiff) return qualityDiff;
                return score(b) - score(a);
            });

            var selected = [];
            var perQuality = {};
            for (var n = 0; n < collected.length; n++) {
                var item = collected[n];
                var key = String(item && item.quality || 0);
                var count = perQuality[key] || 0;
                if (count >= 1) continue;
                perQuality[key] = count + 1;
                selected.push(item);
                if (selected.length >= 4) break;
            }

            return selected;
        }

        async function resolveCollectedLink(item, referer) {
            var url = trim(item && item.url || "");
            if (!url) return [];
            var quality = Number(item && item.quality || 0) || qualityFromText(item && item.label || url);
            var resolved = [];
            if (/hubcloud|gdflix|gdlink/i.test(url)) {
                resolved = await extractHubCloudLike(url, quality);
                if (!resolved.length) resolved = await resolveHubCloudGlobal(url, "MoviesDrive");
                if (!resolved.length) resolved = await resolveGdflixGlobal(url, "MoviesDrive", 0);
            }
            if (!resolved.length) resolved = await resolveCommonExtractorUrl(url, "MoviesDrive", referer, 0);
            if (!resolved.length && isCommonDirectMediaUrl(url)) {
                resolved = [buildResolvedStream(url, "MoviesDrive", quality, commonHeaders(referer ? { "Referer": referer } : {}), item && item.label || url)];
            }
            for (var i = 0; i < resolved.length; i++) {
                if (!resolved[i].quality) resolved[i].quality = quality;
                resolved[i].source = withSimplifiedSource(resolved[i].source || "MoviesDrive", item && item.label || url);
            }
            return resolved;
        }

        async function resolve(media) {
            if (media.anime) return [];
            var queries = uniqueBy([media.title, media.originalTitle, media.imdbId], function (item) {
                return trim(String(item || "").toLowerCase());
            }).filter(Boolean);
            var rows = await searchTitles(queries);
            var matches = [];
            if (media.imdbId) {
                matches = rows.filter(function (row) {
                    return trim(row && row.imdbId) === trim(media.imdbId);
                });
            }
            if (!matches.length) matches = rankedMatches(rows, queries, media.year, media.isMovie ? "movie" : null, PROVIDER_CANDIDATE_LIMIT);
            matches = uniqueBy(matches.filter(Boolean), function (item) { return item && item.url; });
            if (!matches.length) return [];

            var settled = await mapLimit(matches, 2, async function (match) {
                var html = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
                if (!html) return [];
                var links = await collectLinkRows(media, match, html);
                var resolvedRows = await mapLimit(links.slice(0, 10), PROVIDER_LINK_CONCURRENCY, function (link) {
                    return resolveCollectedLink(link, match.url);
                });
                return dedupeStreams(flatten(resolvedRows.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            });
            return dedupeStreams(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
        }

        return {
            key: "p_moviesdrive_extra",
            name: "MoviesDrive",
            resolve: resolve
        };
    })();

    var BollyflixSource = (function () {
        var cachedMainUrl = "";

        async function getMainUrl() {
            if (cachedMainUrl) return cachedMainUrl;
            cachedMainUrl = await getDynamicDomain("bollyflix", "https://bollyflix.frl");
            return cachedMainUrl;
        }

        async function bypassSidexfee(url) {
            if (!/sidexfee\.com/i.test(String(url || ""))) return trim(String(url || ""));
            var id = firstMatch(String(url || ""), [/[?&]id=([^&#]+)/i]);
            if (!id) return trim(String(url || ""));
            var res = await getText("https://web.sidexfee.com/?id=" + encodeURIComponent(id), commonHeaders()).catch(function () { return ""; });
            var encoded = firstMatch(res, [/link":"([^"]+)"/i]).replace(/\\\//g, "/");
            if (!encoded) return trim(String(url || ""));
            try {
                while (encoded.length % 4 !== 0) encoded += "=";
                return trim(Buffer.from(encoded, "base64").toString("utf8"));
            } catch (_) {
                return trim(String(url || ""));
            }
        }

        function checkIsSeries(title, url) {
            var text = String(title || "").toLowerCase();
            var href = String(url || "").toLowerCase();
            return text.indexOf("series") !== -1
                || href.indexOf("/series/") !== -1
                || href.indexOf("-season-") !== -1
                || href.indexOf("-series-") !== -1
                || /season|episode/i.test(text);
        }

        async function searchTitles(queries) {
            var mainUrl = await getMainUrl();
            var out = [];
            for (var i = 0; i < queries.length; i++) {
                var query = trim(queries[i]);
                if (!query) continue;
                var urls = [
                    mainUrl + "/?s=" + encodeURIComponent(query),
                    mainUrl + "/search/" + encodeURIComponent(query) + "/page/1/"
                ];
                for (var j = 0; j < urls.length; j++) {
                    try {
                        var html = await getText(urls[j], commonHeaders({ "Referer": mainUrl + "/" }), true);
                        var results = parseWpArticleResults(html, mainUrl);
                        if (results.length) out = out.concat(results);
                    } catch (_) {}
                }
            }
            return uniqueBy(out, function (item) { return item && item.url; });
        }

        function parseClassAnchors(html, base, classPattern) {
            var out = [];
            var regex = /<a\b([^>]*)href=["']([^"']+)["']([^>]*)>([\s\S]*?)<\/a>/gi;
            var match;
            while ((match = regex.exec(String(html || "")))) {
                var attrs = String(match[1] || "") + " " + String(match[3] || "");
                var className = firstMatch(attrs, [/class=["']([^"']+)["']/i]);
                if (!classPattern.test(className)) continue;
                out.push({
                    href: absoluteUrl(base, decodeHtml(match[2])),
                    text: stripTags(match[4] || ""),
                    index: match.index
                });
            }
            return out;
        }

        function extractLastSeason(text) {
            var regex = /(?:season|s)\s*(\d+)/ig;
            var last = "";
            var match;
            while ((match = regex.exec(String(text || "")))) last = match[1];
            return Number(last || 1);
        }

        function extractEpisodeNumber(text, fallback) {
            var match = String(text || "").match(/(?:episode|ep|e)\s*(\d+)/i);
            return match ? Number(match[1]) : Number(fallback || 1);
        }

        function parseMovieButtons(html, base) {
            return parseClassAnchors(html, base, /(maxbutton|dl|btnn)/i).filter(function (item) {
                return /(download|links|view|click)/i.test(String(item.text || "")) || /id=|gdflix|gdlink|fastdlserver|linksmod|hub/i.test(String(item.href || ""));
            });
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

        async function unlockLinksmod(url) {
            var firstRes = await request(url, {
                headers: commonHeaders({ "Referer": baseOrigin(url) + "/" }),
                allowRedirects: true
            }).catch(function () { return null; });
            var firstHtml = firstRes ? String(firstRes.body || "") : "";
            if (!firstHtml) return "";
            var tokenMatch = String(firstHtml || "").match(/<input[^>]+type=["']hidden["'][^>]+name=["']([^"']+)["'][^>]+value=["']([^"']*)["']/i);
            if (!tokenMatch) return firstHtml;

            var form = encodeURIComponent(tokenMatch[1]) + "=" + encodeURIComponent(tokenMatch[2] || "");
            var cookieHeader = extractCookieHeader(firstRes && firstRes.headers || {});
            var postRes = await request(url, {
                method: "POST",
                body: form,
                headers: commonHeaders({
                    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
                    "Origin": baseOrigin(url),
                    "Referer": url,
                    "Cookie": cookieHeader
                }),
                allowRedirects: true
            }).catch(function () { return null; });
            return postRes ? String(postRes.body || "") : firstHtml;
        }

        async function resolveLinksmod(url, quality) {
            var html = await unlockLinksmod(url);
            if (!html) return [];
            var directMedia = extractDirectMediaUrls(html, url).map(function (streamUrl) {
                return buildResolvedStream(streamUrl, "Bollyflix [LinksMod]", qualityFromText(streamUrl) || quality, commonHeaders({ "Referer": url }), streamUrl);
            });
            var anchors = parseAnchors(html, url).filter(function (item) {
                return /^https?:\/\//i.test(item.href)
                    && baseOrigin(item.href) !== baseOrigin(url)
                    && !/telegram|facebook|instagram|twitter|youtube/i.test(item.href);
            });
            var streams = directMedia.slice();
            var settled = await mapLimit(anchors.slice(0, 10), PROVIDER_LINK_CONCURRENCY, async function (anchor) {
                if (isCommonDirectMediaUrl(anchor.href)) {
                    return [buildResolvedStream(anchor.href, "Bollyflix [LinksMod]", qualityFromText(anchor.href) || quality, commonHeaders({ "Referer": url }), anchor.href)];
                }
                return resolveCommonExtractorUrl(anchor.href, "Bollyflix", url, 0);
            });
            streams = streams.concat(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            if (!streams.length) {
                var gofileSettled = await mapLimit(anchors.filter(function (anchor) { return /gofile/i.test(anchor.href); }).slice(0, 6), 3, function (anchor) {
                    return resolveGofileGlobal(anchor.href, "Bollyflix");
                });
                streams = streams.concat(flatten(gofileSettled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            }
            for (var k = 0; k < streams.length; k++) {
                if (!streams[k].quality) streams[k].quality = quality;
                if (!streams[k].source) streams[k].source = withSimplifiedSource("Bollyflix", url);
            }
            return dedupeStreams(streams);
        }

        async function collectSeriesLinks(html, baseUrl, media) {
            var buttons = parseClassAnchors(html, baseUrl, /(maxbutton|dl|btnn)/i).filter(function (item) {
                return /(download|links|view|click)/i.test(String(item.text || ""));
            });
            var settled = await mapLimit(buttons.slice(0, 8), 3, async function (button) {
                var season = extractEpisodeNumber(button.text, extractLastSeason(String(html || "").slice(Math.max(0, button.index - 800), button.index)));
                if (media.season && season !== Number(media.season)) return [];

                var resolvedButtonUrl = await bypassSidexfee(button.href);
                if (!resolvedButtonUrl || !/^https?:\/\//i.test(resolvedButtonUrl)) return [];
                var pageHtml = await getText(resolvedButtonUrl, commonHeaders({ "Referer": baseUrl }), true).catch(function () { return ""; });
                if (!pageHtml) return [];
                var anchors = parseAnchors(pageHtml, resolvedButtonUrl).filter(function (item) {
                    var text = String(item.text || "").toLowerCase();
                    return /^https?:\/\//i.test(item.href) && text.indexOf("zip") === -1 && text.indexOf("elinks") === -1;
                });

                var out = [];
                for (var j = 0; j < anchors.length; j++) {
                    var epNum = extractEpisodeNumber(anchors[j].text, j + 1);
                    if (media.episode && epNum !== Number(media.episode)) continue;
                    out.push({
                        url: anchors[j].href,
                        quality: qualityFromText(button.text || anchors[j].text),
                        label: button.text || anchors[j].text
                    });
                }
                return out;
            });

            return uniqueBy(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })), function (item) { return item.url + "|" + item.quality; });
        }

        async function resolveBollyflixGdflix(url) {
            var html = await getText(url, commonHeaders({ "Referer": baseOrigin(url) + "/" }), true).catch(function () { return ""; });
            if (!html) return [];
            var fileName = firstMatch(html, [/Name\s*:\s*([^<]+)/i]);
            var fileSize = firstMatch(html, [/Size\s*:\s*([^<]+)/i]);
            var anchors = parseAnchors(html, baseOrigin(url));
            var out = [];

            var settled = await mapLimit(anchors.slice(0, 10), PROVIDER_LINK_CONCURRENCY, async function (anchor) {
                var text = String(anchor.text || "");
                var href = trim(anchor.href || "");
                if (!href) return [];
                var quality = qualityFromText(fileName || text || href);
                var suffix = fileSize ? " (" + fileSize + ")" : "";

                if (/DIRECT|FSL V2|CLOUD/i.test(text)) {
                    return [buildResolvedStream(href, "Bollyflix [" + trim(text) + "]", quality, commonHeaders(), fileName || text || href)];
                } else if (/instant/i.test(text) || /busycdn/i.test(href)) {
                    return [buildResolvedStream(href, "Bollyflix [InstantDL]" + suffix, quality, commonHeaders({ "Referer": url }), fileName || href)];
                } else if (/FAST CLOUD/i.test(text)) {
                    var fastHtml = await getText(href, commonHeaders({ "Referer": url }), true).catch(function () { return ""; });
                    var directLink = normalizeResolvedUrl(firstMatch(fastHtml, [/<div[^>]*class=["'][^"']*card-body[^"']*["'][\s\S]*?<a[^>]+href=["']([^"']+)["']/i]), baseOrigin(href));
                    if (directLink) {
                        return [buildResolvedStream(directLink, "Bollyflix [FastCloud]" + suffix, quality, commonHeaders({ "Referer": href }), fileName || directLink)];
                    }
                } else if (/gofile|mirror/i.test(text) || /goflix\.sbs/i.test(href)) {
                    return resolveCommonExtractorUrl(href, "Bollyflix [Mirror]" + suffix, url, 0);
                } else if (/pixeldrain/i.test(href) || /pixeldrain/i.test(text)) {
                    var fileId = href.split("/").pop();
                    if (fileId) return [buildResolvedStream("https://pixeldrain.com/api/file/" + fileId + "?download", "Bollyflix [Pixeldrain]" + suffix, quality, commonHeaders(), fileName || href)];
                }
                return [];
            });
            out = flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; }));

            if (!out.length) {
                var directMedia = extractDirectMediaUrls(html, url);
                for (var j = 0; j < directMedia.length; j++) {
                    out.push(buildResolvedStream(directMedia[j], "Bollyflix [Direct]" + (fileSize ? " (" + fileSize + ")" : ""), qualityFromText(fileName || directMedia[j]), commonHeaders({ "Referer": url }), fileName || directMedia[j]));
                }
            }

            return dedupeStreams(out);
        }

        async function resolveLinkRow(item, referer) {
            var url = trim(item && item.url || "");
            if (!url) return [];
            url = await bypassSidexfee(url);
            var quality = Number(item && item.quality || 0) || qualityFromText(item && item.label || url);
            var resolved = [];
            if (/linksmod\.top\/view\//i.test(url)) {
                resolved = await resolveLinksmod(url, quality);
            }
            if (/gdflix|gdlink|fastdlserver/i.test(url)) {
                resolved = await resolveBollyflixGdflix(url);
                if (!resolved.length) resolved = await resolveGdflixGlobal(url, "Bollyflix", 0);
            }
            if (!resolved.length) resolved = await resolveCommonExtractorUrl(url, "Bollyflix", referer, 0);
            if (!resolved.length && isCommonDirectMediaUrl(url)) {
                resolved = [buildResolvedStream(url, "Bollyflix", quality, commonHeaders(referer ? { "Referer": referer } : {}), item && item.label || url)];
            }
            for (var i = 0; i < resolved.length; i++) {
                if (!resolved[i].quality) resolved[i].quality = quality;
                resolved[i].source = withSimplifiedSource(resolved[i].source || "Bollyflix", item && item.label || url);
            }
            return resolved;
        }

        async function resolve(media) {
            if (media.anime) return [];
            var queries = uniqueBy([media.title, media.originalTitle, media.imdbId], function (item) {
                return trim(String(item || "").toLowerCase());
            }).filter(Boolean);
            var rows = await searchTitles(queries);
            var matches = rankedMatches(rows, queries, media.year, media.isMovie ? "movie" : null, PROVIDER_CANDIDATE_LIMIT);
            if (!matches.length) return [];
            var settled = await mapLimit(matches, 2, async function (match) {
                if (!match || !match.url) return [];
                var html = await getText(match.url, commonHeaders({ "Referer": (await getMainUrl()) + "/" }), true).catch(function () { return ""; });
                if (!html) return [];

                var isSeries = checkIsSeries(match.title || media.title, match.url) || !media.isMovie;
                var links = [];
                if (isSeries) {
                    links = await collectSeriesLinks(html, match.url, media);
                } else {
                    var buttons = parseMovieButtons(html, match.url);
                    for (var i = 0; i < buttons.length; i++) {
                        links.push({
                            url: buttons[i].href,
                            quality: qualityFromText(buttons[i].text || match.title),
                            label: buttons[i].text || match.title
                        });
                    }
                }

                if (!links.length) {
                    var fallbackRows = extractExternalSourceLinks(html, match.url);
                    for (var j = 0; j < fallbackRows.length; j++) {
                        links.push({
                            url: fallbackRows[j].url,
                            quality: qualityFromText(fallbackRows[j].label || match.title),
                            label: fallbackRows[j].label || match.title
                        });
                    }
                }

                var resolvedRows = await mapLimit(links.slice(0, 12), PROVIDER_LINK_CONCURRENCY, function (link) {
                    return resolveLinkRow(link, match.url);
                });
                return dedupeStreams(flatten(resolvedRows.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            });
            return dedupeStreams(flatten(settled.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
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
                    resolved[j].source = withSimplifiedSource(resolved[j].source || "HDMovie2", options[i].title || match.title);
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
                return buildResolvedStream(row.href, "TokyoInsider", qualityFromText(row.text || row.href), {}, row.text || row.href);
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

    var YflixSource = (function () {
        var MAIN_URL = "https://yflix.to";
        var YFX_ENC = "https://enc-dec.app/api/enc-movies-flix";
        var YFX_DEC = "https://enc-dec.app/api/dec-movies-flix";
        var FLIX_FIND_API = "https://enc-dec.app/db/flix/find";
        var YFLIX_HEADERS = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36",
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Accept-Language": "en-US,en;q=0.9",
            "Referer": MAIN_URL + "/"
        };

        async function decodeToken(text) {
            var res = await request(YFX_ENC + "?text=" + encodeURIComponent(String(text || "")), {
                headers: YFLIX_HEADERS,
                allowRedirects: true
            }).catch(function () { return null; });
            var json = res ? parseJsonSafe(res.body, {}) : {};
            return trim(String(json && json.result || ""));
        }

        async function decodeReversePayload(text) {
            var res = await request(YFX_DEC, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ text: String(text || "") })
            }).catch(function () { return null; });
            var json = res ? parseJsonSafe(res.body, {}) : {};
            return json && json.result || "";
        }

        function extractVideoUrlFromDecodedPayload(payload) {
            if (!payload) return "";
            if (typeof payload === "object") return trim(String(payload.url || payload.file || payload.src || payload.link || ""));
            var text = decodeHtml(String(payload || "").trim());
            if (/^https?:\/\//i.test(text)) return text;
            var json = parseJsonSafe(text, null);
            if (json) {
                if (typeof json === "string") return extractVideoUrlFromDecodedPayload(json);
                return trim(String(json.url || json.file || json.src || json.link || ""));
            }
            return trim(firstMatch(text, [
                /<iframe[^>]+src=["']([^"']+)["']/i,
                /(?:src|url|file|link)\s*[:=]\s*["'](https?:\/\/[^"']+)["']/i,
                /(https?:\/\/[^\s"'<>\\]+)/i
            ]));
        }

        function getServerNodes(html) {
            return parseAnchors(String(html || ""), MAIN_URL).filter(function (item) {
                return /class=["'][^"']*\bserver\b/i.test(item.html || "");
            }).map(function (item) {
                return {
                    lid: trim(firstMatch(item.html || "", [/data-lid=["']([^"']+)["']/i])),
                    name: stripTags(firstMatch(item.html || "", [/<span[^>]*>([\s\S]*?)<\/span>/i])) || item.text || "Server"
                };
            }).filter(function (item) {
                return !!item.lid;
            });
        }

        async function resolveYflixVideoUrl(videoUrl, displayName) {
            if (!videoUrl) return [];
            if (/\.m3u8(?:$|[?#])/i.test(videoUrl)) {
                return parseM3u8Qualities(videoUrl, { "Referer": MAIN_URL + "/" }, displayName || "Yflix");
            }
            var resolved = await resolveCommonExtractorUrl(videoUrl, displayName || "Yflix", MAIN_URL + "/", 0);
            if (resolved.length) return resolved;
            if (isCommonDirectMediaUrl(videoUrl)) {
                return [buildResolvedStream(videoUrl, displayName || "Yflix", qualityFromText(videoUrl), { "Referer": MAIN_URL + "/" }, videoUrl)];
            }
            return [];
        }

        function getEpisodeInfo(entry, media) {
            var seasons = entry && entry.episodes || {};
            var seasonKey = String(media.isMovie ? 1 : (media.season || 1));
            var episodeKey = String(media.isMovie ? 1 : (media.episode || 1));
            var seasonData = seasons[seasonKey] || seasons[String(Number(seasonKey))] || {};
            return seasonData[episodeKey] || seasonData[String(Number(episodeKey))] || null;
        }

        async function resolve(media) {
            if (!media || media.anime || !media.tmdbId) return [];
            var rows = await getJson(FLIX_FIND_API + "?tmdb_id=" + encodeURIComponent(String(media.tmdbId)), commonHeaders()).catch(function () { return []; });
            if (!Array.isArray(rows) || !rows.length) return [];
            var settledEntries = await mapLimit(rows.slice(0, PROVIDER_CANDIDATE_LIMIT), 2, async function (entry) {
                var episodeInfo = getEpisodeInfo(entry, media);
                if (!episodeInfo || !episodeInfo.eid) return [];

                var decodedEid = await decodeToken(episodeInfo.eid);
                if (!decodedEid) return [];
                var listRes = await request(MAIN_URL + "/ajax/links/list?eid=" + encodeURIComponent(episodeInfo.eid) + "&_=" + encodeURIComponent(decodedEid), {
                    headers: YFLIX_HEADERS,
                    allowRedirects: true
                }).catch(function () { return null; });
                var listJson = listRes ? parseJsonSafe(listRes.body, {}) : {};
                var linksHtml = decodeHtml(String(listJson && listJson.result || ""));
                if (!linksHtml) return [];
                var servers = getServerNodes(linksHtml);
                if (!servers.length) return [];

                var settledServers = await mapLimit(servers.slice(0, 8), 4, async function (server) {
                    var decodedLid = await decodeToken(server.lid);
                    if (!decodedLid) return [];
                    var viewRes = await request(MAIN_URL + "/ajax/links/view?id=" + encodeURIComponent(server.lid) + "&_=" + encodeURIComponent(decodedLid), {
                        headers: YFLIX_HEADERS,
                        allowRedirects: true
                    }).catch(function () { return null; });
                    var viewJson = viewRes ? parseJsonSafe(viewRes.body, {}) : {};
                    var encodedPayload = trim(String(viewJson && viewJson.result || ""));
                    if (!encodedPayload) return [];
                    var decodedPayload = await decodeReversePayload(encodedPayload);
                    var videoUrl = extractVideoUrlFromDecodedPayload(decodedPayload);
                    if (!videoUrl) return [];
                    return resolveYflixVideoUrl(videoUrl, "Yflix [" + server.name + "]");
                });
                return dedupeStreams(flatten(settledServers.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
            });
            return dedupeStreams(flatten(settledEntries.filter(function (row) { return row && row.status === "fulfilled"; }).map(function (row) { return row.value || []; })));
        }

        return {
            key: "p_yflix",
            name: "Yflix",
            resolve: resolve
        };
    })();

    var PulpSource = (function () {
        var PULP_API = "https://api.pulp.watch/v1";
        var PULP_REFERER = "https://tv.pulp.watch/";
        var PULP_PROVIDER = "02moviedownloader";

        function pulpSubtitles(items) {
            return uniqueBy((items || []).map(function (item) {
                var url = trim(String(item && item.url || ""));
                if (!url) return null;
                var label = trim(String(item && (item.label || item.language) || "Unknown")) || "Unknown";
                return {
                    url: url,
                    name: label
                };
            }).filter(Boolean), function (item) {
                return item.url;
            });
        }

        async function resolve(media) {
            if (!media || !media.tmdbId || media.anime) return [];
            var apiUrl = media.isMovie
                ? PULP_API + "/movies/" + encodeURIComponent(String(media.tmdbId)) + "?provider=" + encodeURIComponent(PULP_PROVIDER)
                : PULP_API + "/tv/" + encodeURIComponent(String(media.tmdbId))
                    + "/seasons/" + encodeURIComponent(String(media.season || 1))
                    + "/episodes/" + encodeURIComponent(String(media.episode || 1))
                    + "?provider=" + encodeURIComponent(PULP_PROVIDER);

            var json = await getJson(apiUrl, commonHeaders({
                "Accept": "application/json",
                "Referer": PULP_REFERER,
                "Origin": "https://tv.pulp.watch"
            })).catch(function () { return null; });
            if (!json || !Array.isArray(json.sources) || !json.sources.length) return [];

            var subtitles = pulpSubtitles(json.subtitles || []);
            return dedupeStreams(json.sources.map(function (source) {
                var sourceUrl = trim(String(source && source.url || ""));
                if (!sourceUrl) return null;
                var provider = source && source.provider || {};
                var providerName = trim(String(provider.name || provider.id || "Pulp")) || "Pulp";
                var headers = {};
                var sourceHeaders = source && source.headers || {};
                Object.keys(sourceHeaders).forEach(function (key) {
                    var value = trim(String(sourceHeaders[key] || ""));
                    if (value) headers[key] = value;
                });
                var qualityHint = [source && source.quality, source && source.type, sourceUrl].filter(Boolean).join(" ");
                var stream = {
                    url: sourceUrl,
                    source: withSimplifiedSource("Pulp [" + providerName + "]", source && source.quality || sourceUrl),
                    quality: qualityFromText(qualityHint) || 0,
                    headers: headers
                };
                if (subtitles.length) stream.subtitles = subtitles;
                return stream;
            }).filter(Boolean));
        }

        return {
            key: "p_pulp",
            name: "Pulp",
            resolve: resolve
        };
    })();

    var PROVIDERS = [
        CastleSource,
        StreamvixSource,
        NoTorrentSource,
        VidSrcSource,
        VidRockSource,
        FlixIndiaSource,
        FourKhdhubSource,
        VegaMoviesSource,
        Movies4uSource,
        MoviesDriveExtraSource,
        BollyflixSource,
        HindmoviezSource,
        HDMovie2Source,
        KaidoSource,
        AnimePaheSource,
        AnimetsuSource,
        AnimeToshoSource,
        TokyoInsiderSource,
        YflixSource,
        PulpSource
    ];

    async function loadStreams(url, cb) {
        try {
            var media = parsePayload(url);
            var anime = !!media.anime;
            var defaultProviders = anime
                ? [KaidoSource, AnimePaheSource, AnimetsuSource, AnimeToshoSource, TokyoInsiderSource]
                : [CastleSource, StreamvixSource, NoTorrentSource, FourKhdhubSource, VegaMoviesSource, MoviesDriveExtraSource, PulpSource];
            var providerKeys = [];
            if (Array.isArray(media.providerKeys)) providerKeys = media.providerKeys.slice();
            else if (Array.isArray(media.providers)) providerKeys = media.providers.slice();
            else if (media.providerKey) providerKeys = [media.providerKey];
            else if (media.provider) providerKeys = [media.provider];
            providerKeys = uniqueBy(providerKeys.map(function (item) {
                return trim(String(item || "").toLowerCase());
            }).filter(Boolean), function (item) { return item; });
            var selectedProviders = providerKeys.length ? PROVIDERS.slice() : defaultProviders.slice();
            if (providerKeys.length) {
                selectedProviders = selectedProviders.filter(function (provider) {
                    var key = trim(String(provider && provider.key || "").toLowerCase());
                    var name = trim(String(provider && provider.name || "").toLowerCase());
                    return providerKeys.indexOf(key) !== -1 || providerKeys.indexOf(name) !== -1;
                });
            }

            var settled = await mapLimit(selectedProviders, SCRAPE_CONCURRENCY, function (provider) {
                return withTimeout(provider.resolve(media), providerTimeoutMs(provider), provider && provider.name || "Provider");
            });
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
