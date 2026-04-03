(function () {
    const DEBUG = false;
    function log()  { if (DEBUG) console.log.apply(console, ["[SX]"].concat([].slice.call(arguments))); }
    function warn() { if (DEBUG) console.warn.apply(console, ["[SX WARN]"].concat([].slice.call(arguments))); }
    function err()  { console.error.apply(console, ["[SX ERR]"].concat([].slice.call(arguments))); }

    const API_CANDIDATES = [
        "https://streamex.sh",
        "https://streamex.net"
    ];

    const API = {
        tmdb: "/api/tmdb",
        anime: "/api/hianime"
    };

    const VIDLINK_API = "https://vidlink.pro/api/b";
    const VIDLINK_KEY_HEX = "2de6e6ea13a9df9503b11a6117fd7e51941e04a0c223dfeacfe8a1dbb6c52783";

    const MOVIE_TV_PROVIDERS = {
        streamx:  { flag: "https://flagcdn.com/w20/us.png", movie: "https://embed.wplay.me/embed/movie/{id}",                    tv: "https://embed.wplay.me/embed/tv/{id}/{season}/{episode}",            recommended: true,  sandbox: true  },
        vid2:     { flag: "https://flagcdn.com/w20/gb.png", movie: "https://cdn.mov2day.xyz/embed/movie/{id}",                  tv: "https://cdn.mov2day.xyz/embed/tv/{id}/{season}/{episode}",            recommended: false, sandbox: true  },
        mapi:     { flag: "https://flagcdn.com/w20/gb.png", movie: "https://www.zxcstream.xyz/embed/movie/{id}",                tv: "https://www.zxcstream.xyz/embed/tv/{id}/{season}/{episode}",          recommended: false, sandbox: true  },
        cinemaos: { flag: "https://flagcdn.com/w20/us.png", movie: "https://cinemaos.tech/player/{id}",                         tv: "https://cinemaos.tech/player/{id}/{season}/{episode}",                recommended: false, sandbox: true  },
        vidsrc:   { flag: "https://flagcdn.com/w20/us.png", movie: "https://vsembed.ru/embed/movie/{id}",                       tv: "https://vsembed.ru/embed/tv/{id}/{season}/{episode}",                 recommended: true,  sandbox: false },
        videasy:  { flag: "https://flagcdn.com/w20/gb.png", movie: "https://player.videasy.net/movie/{id}",                     tv: "https://player.videasy.net/tv/{id}/{season}/{episode}",               recommended: false, sandbox: false },
        vidpro:   { flag: "https://flagcdn.com/w20/us.png", movie: "https://vidlink.pro/movie/{id}?icons=vid",                  tv: "https://vidlink.pro/tv/{id}/{season}/{episode}?icons=vid&nextbutton=true", recommended: true, sandbox: false },
        embedcc:  { flag: "https://flagcdn.com/w20/us.png", movie: "https://www.2embed.cc/embed/{id}",                          tv: "https://www.2embed.cc/embedtv/{id}&s={season}&e={episode}",           recommended: false, sandbox: false },
        zxcstream:{ flag: "https://flagcdn.com/w20/us.png", movie: "https://www.zxcstream.xyz/player/movie/{id}",               tv: "https://www.zxcstream.xyz/player/tv/{id}/{season}/{episode}",         recommended: true,  sandbox: true  },
        french:   { flag: "https://flagcdn.com/w20/fr.png", movie: "https://frembed.buzz/api/film.php?id={id}",                 tv: "https://frembed.buzz/api/serie.php?id={id}&sa={season}&epi={episode}", recommended: false, sandbox: false },
        spanish:  { flag: "https://flagcdn.com/w20/es.png", movie: "https://play.modocine.com/play.php/embed/movie/{id}",       tv: "https://play.modocine.com/play.php/embed/tv/{id}/{season}/{episode}", recommended: false, sandbox: true  },
        italian:  { flag: "https://flagcdn.com/w20/it.png", movie: "https://vixsrc.to/movie/{id}?lang=it",                      tv: "https://vixsrc.to/tv/{id}/{season}/{episode}?lang=it",                recommended: false, sandbox: false }
    };

    const ANIME_PROVIDERS = {
        "Main-sub":     { flag: "https://flagcdn.com/w20/us.png", anime: "https://megaplay.buzz/stream/s-2/{epId}/sub",                 recommended: true,  sandbox: false, requiresEpId: true  },
        "Main-dub":     { flag: "https://flagcdn.com/w20/us.png", anime: "https://megaplay.buzz/stream/s-2/{epId}/dub",                 recommended: true,  sandbox: false, requiresEpId: true  },
        "videasy-sub":  { flag: "https://flagcdn.com/w20/gb.png", anime: "https://player.videasy.net/anime/{id}/{episode}",            recommended: false, sandbox: false, requiresEpId: false },
        "videasy-dub":  { flag: "https://flagcdn.com/w20/gb.png", anime: "https://player.videasy.net/anime/{id}/{episode}?dub=true",   recommended: false, sandbox: false, requiresEpId: false },
        "vidnest-sub":  { flag: "https://flagcdn.com/w20/us.png", anime: "https://vidnest.fun/anime/{id}/{episode}/sub",               recommended: false, sandbox: false, requiresEpId: false },
        "vidnest-dub":  { flag: "https://flagcdn.com/w20/us.png", anime: "https://vidnest.fun/anime/{id}/{episode}/dub",               recommended: false, sandbox: false, requiresEpId: false },
        "pahe-sub":     { flag: "https://flagcdn.com/w20/us.png", anime: "https://vidnest.fun/animepahe/{id}/{episode}/sub",           recommended: false, sandbox: false, requiresEpId: false },
        "pahe-dub":     { flag: "https://flagcdn.com/w20/us.png", anime: "https://vidnest.fun/animepahe/{id}/{episode}/dub",           recommended: false, sandbox: false, requiresEpId: false }
    };

    let cachedBaseUrl = null;

    async function getBaseUrl() {
        if (cachedBaseUrl) return cachedBaseUrl;
        for (const base of API_CANDIDATES) {
            try {
                await http_get(base + "/");
                cachedBaseUrl = base;
                return cachedBaseUrl;
            } catch (e) {
                warn("base failed", base, e.message);
            }
        }
        cachedBaseUrl = API_CANDIDATES[0];
        return cachedBaseUrl;
    }

    async function fetchJson(url) {
        const res = await http_get(url);
        const data = JSON.parse(res.body || "{}");
        if (data && data.error) throw new Error(data.error);
        return data;
    }

    function stripHtml(s) {
        return (s || "").replace(/<\/?[^>]+(>|$)/g, "").replace(/\s+/g, " ").trim();
    }

    function yearFromDate(s) {
        if (!s) return undefined;
        const m = String(s).match(/^(\d{4})/);
        return m ? parseInt(m[1], 10) : undefined;
    }

    function posterUrl(path) {
        if (!path) return undefined;
        if (/^https?:\/\//i.test(path)) return path;
        return "https://image.tmdb.org/t/p/w500" + path;
    }

    function backdropUrl(path) {
        if (!path) return undefined;
        if (/^https?:\/\//i.test(path)) return path;
        return "https://image.tmdb.org/t/p/original" + path;
    }

    function makeWatchUrl(type, id) {
        return "https://streamex.sh/watch/" + type + "/" + encodeURIComponent(id);
    }

    function toActor(c) {
        return new Actor({
            name: c.name,
            role: c.character,
            image: c.profile_path ? posterUrl(c.profile_path.replace("https://image.tmdb.org/t/p/w185", "")) || c.profile_path : c.profile_path
        });
    }

    function tmdbItemToMedia(item, forcedType) {
        const type = forcedType || item.media_type || (item.first_air_date ? "tv" : "movie");
        if (type !== "movie" && type !== "tv") return null;
        return new MultimediaItem({
            title: item.title || item.name || "Unknown",
            url: makeWatchUrl(type, item.id),
            posterUrl: posterUrl(item.poster_path),
            bannerUrl: backdropUrl(item.backdrop_path),
            type: type === "tv" ? "series" : "movie",
            description: stripHtml(item.overview || ""),
            year: yearFromDate(item.release_date || item.first_air_date),
            score: typeof item.vote_average === "number" ? Math.round(item.vote_average * 10) / 10 : undefined,
            genres: []
        });
    }

    function animeItemToMedia(item) {
        return new MultimediaItem({
            title: item.title || item.name || "Unknown",
            url: makeWatchUrl("anime", item.id),
            posterUrl: item.poster || item.poster_path || undefined,
            type: "series",
            description: "",
            score: item.rating ? parseFloat(item.rating) : undefined,
            genres: []
        });
    }

    function uniqueByUrl(items) {
        const out = [];
        const seen = {};
        for (let i = 0; i < items.length; i++) {
            const item = items[i];
            if (!item || !item.url || seen[item.url]) continue;
            seen[item.url] = true;
            out.push(item);
        }
        return out;
    }

    function parseLoadInput(url) {
        let m = String(url || "").match(/\/watch\/(movie|tv|anime)\/([^/?#]+)/i);
        if (m) return { type: m[1].toLowerCase(), id: decodeURIComponent(m[2]) };
        m = String(url || "").match(/^streamex:(movie|tv|anime):(.+)$/i);
        if (m) return { type: m[1].toLowerCase(), id: m[2] };
        throw new Error("Unsupported StreameX url");
    }

    function parseStreamPayload(url) {
        return JSON.parse(url);
    }

    async function getHome(cb) {
        try {
            const base = await getBaseUrl();
            const movieTrending = await fetchJson(base + API.tmdb + "/trending/movie/week?page=1");
            const tvTrending = await fetchJson(base + API.tmdb + "/trending/tv/week?page=1");
            const movieTop = await fetchJson(base + API.tmdb + "/movie/top_rated?page=1");
            const animeTrending = await fetchJson(base + API.anime + "/top-airing?page=1");

            cb({
                success: true,
                data: {
                    "Trending Movies": uniqueByUrl((movieTrending.results || []).map(function (x) { return tmdbItemToMedia(x, "movie"); })),
                    "Trending TV Shows": uniqueByUrl((tvTrending.results || []).map(function (x) { return tmdbItemToMedia(x, "tv"); })),
                    "Top Rated Movies": uniqueByUrl((movieTop.results || []).map(function (x) { return tmdbItemToMedia(x, "movie"); })),
                    "Trending Anime": uniqueByUrl((animeTrending.results || []).map(animeItemToMedia))
                }
            });
        } catch (e) {
            err("getHome", e.message);
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        }
    }

    async function search(query, cb) {
        try {
            const base = await getBaseUrl();
            const tmdb = await fetchJson(base + API.tmdb + "/search/multi?query=" + encodeURIComponent(query) + "&page=1");
            const anime = await fetchJson(base + API.anime + "/search?query=" + encodeURIComponent(query) + "&page=1");
            const items = [];

            (tmdb.results || []).forEach(function (item) {
                const media = tmdbItemToMedia(item, item.media_type);
                if (media) items.push(media);
            });

            (anime.results || []).forEach(function (item) {
                items.push(animeItemToMedia(item));
            });

            cb({ success: true, data: uniqueByUrl(items) });
        } catch (e) {
            err("search", e.message);
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        }
    }

    async function loadMovie(base, id, url, cb) {
        const data = await fetchJson(base + API.tmdb + "/movie/" + id + "?append_to_response=credits,recommendations,external_ids,videos");
        cb({
            success: true,
            data: new MultimediaItem({
                title: data.title || "Unknown",
                url: url,
                posterUrl: posterUrl(data.poster_path),
                bannerUrl: backdropUrl(data.backdrop_path),
                type: "movie",
                description: stripHtml(data.overview || ""),
                year: yearFromDate(data.release_date),
                score: typeof data.vote_average === "number" ? Math.round(data.vote_average * 10) / 10 : undefined,
                genres: (data.genres || []).map(function (g) { return g.name; }),
                cast: (data.credits && data.credits.cast ? data.credits.cast : []).slice(0, 20).map(toActor),
                episodes: [
                    new Episode({
                        name: "Movie",
                        season: 1,
                        episode: 1,
                        url: JSON.stringify({ type: "movie", id: id })
                    })
                ]
            })
        });
    }

    async function loadTv(base, id, url, cb) {
        const data = await fetchJson(base + API.tmdb + "/tv/" + id + "?append_to_response=credits,recommendations,external_ids,videos");
        const seasons = (data.seasons || []).filter(function (s) { return typeof s.season_number === "number" && s.season_number >= 1; });
        const episodes = [];

        for (let i = 0; i < seasons.length; i++) {
            const season = seasons[i];
            try {
                const seasonData = await fetchJson(base + API.tmdb + "/tv/" + id + "/season/" + season.season_number);
                (seasonData.episodes || []).forEach(function (ep) {
                    episodes.push(new Episode({
                        name: ep.name || ("Episode " + ep.episode_number),
                        season: ep.season_number || season.season_number,
                        episode: ep.episode_number,
                        url: JSON.stringify({ type: "tv", id: id, season: season.season_number, episode: ep.episode_number }),
                        description: stripHtml(ep.overview || ""),
                        posterUrl: posterUrl(ep.still_path),
                        aired: ep.air_date || undefined
                    }));
                });
            } catch (e) {
                warn("season load failed", id, season.season_number, e.message);
            }
        }

        cb({
            success: true,
            data: new MultimediaItem({
                title: data.name || "Unknown",
                url: url,
                posterUrl: posterUrl(data.poster_path),
                bannerUrl: backdropUrl(data.backdrop_path),
                type: "series",
                description: stripHtml(data.overview || ""),
                year: yearFromDate(data.first_air_date),
                score: typeof data.vote_average === "number" ? Math.round(data.vote_average * 10) / 10 : undefined,
                genres: (data.genres || []).map(function (g) { return g.name; }),
                cast: (data.credits && data.credits.cast ? data.credits.cast : []).slice(0, 20).map(toActor),
                episodes: episodes
            })
        });
    }

    async function loadAnime(base, id, url, cb) {
        const info = await fetchJson(base + API.anime + "/info/" + id);
        const eps = await fetchJson(base + API.anime + "/episodes/" + id);
        const episodes = (eps.episodes || []).map(function (ep) {
            return new Episode({
                name: ep.title || ("Episode " + ep.episode_no),
                season: 1,
                episode: ep.episode_no,
                url: JSON.stringify({
                    type: "anime",
                    id: id,
                    episode: ep.episode_no,
                    epId: ep.epId,
                    anilistId: info.anilistId,
                    malId: info.malId
                }),
                description: ep.japanese_title || undefined
            });
        });

        cb({
            success: true,
            data: new MultimediaItem({
                title: info.title || "Unknown",
                url: url,
                posterUrl: info.poster || undefined,
                bannerUrl: undefined,
                type: "series",
                description: stripHtml(info.description || ""),
                score: info.animeInfo && info.animeInfo["MAL Score"] ? parseFloat(info.animeInfo["MAL Score"]) : undefined,
                genres: info.genres || [],
                cast: [],
                episodes: episodes
            })
        });
    }

    async function load(url, cb) {
        try {
            const parsed = parseLoadInput(url);
            const base = await getBaseUrl();
            if (parsed.type === "movie") return loadMovie(base, parsed.id, url, cb);
            if (parsed.type === "tv") return loadTv(base, parsed.id, url, cb);
            if (parsed.type === "anime") return loadAnime(base, parsed.id, url, cb);
            throw new Error("Unsupported media type");
        } catch (e) {
            err("load", e.message);
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        }
    }

    async function getExternalIds(base, type, id) {
        try {
            if (type === "anime") {
                const info = await fetchJson(base + API.anime + "/info/" + id);
                return {
                    imdb_id: null,
                    anilist_id: info.anilistId || null,
                    mal_id: info.malId || null
                };
            }
            return await fetchJson(base + API.tmdb + "/" + type + "/" + id + "/external_ids");
        } catch (e) {
            warn("external ids failed", type, id, e.message);
            return {};
        }
    }

    function providerQuality(name, recommended) {
        if (/4k|uhd/i.test(name)) return 2160;
        if (recommended) return 1080;
        return 720;
    }

    function absoluteUrl(base, maybeRelative) {
        if (!maybeRelative) return null;
        maybeRelative = String(maybeRelative)
            .replace(/&amp;/g, "&")
            .replace(/&#x2F;/gi, "/")
            .replace(/&#47;/g, "/");
        if (/^https?:\/\//i.test(maybeRelative)) return maybeRelative;
        if (!/^https?:\/\//i.test(base || "")) return maybeRelative;
        const root = base.match(/^https?:\/\/[^/]+/i);
        if (!root) return maybeRelative;
        if (maybeRelative.charAt(0) === "/") return root[0] + maybeRelative;
        const pathBase = base.replace(/[#?].*$/, "").replace(/\/[^/]*$/, "/");
        return pathBase + maybeRelative;
    }

    function uniqueStrings(values) {
        const out = [];
        const seen = {};
        for (let i = 0; i < values.length; i++) {
            const value = values[i];
            if (!value || seen[value]) continue;
            seen[value] = true;
            out.push(value);
        }
        return out;
    }

    function parseJsonSafely(text) {
        try {
            return JSON.parse(text);
        } catch (_) {
            return null;
        }
    }

    function getNodeCrypto() {
        try {
            if (typeof require === "function") return require("crypto");
        } catch (_) {}
        return null;
    }

    function getRuntimeCrypto() {
        if (typeof crypto !== "undefined" && crypto) return crypto;
        if (typeof globalThis !== "undefined" && globalThis.crypto) return globalThis.crypto;
        return null;
    }

    function textToBytes(text) {
        if (typeof TextEncoder !== "undefined") return new TextEncoder().encode(String(text));
        if (typeof Buffer !== "undefined") return Uint8Array.from(Buffer.from(String(text), "utf8"));
        const out = new Uint8Array(String(text).length);
        for (let i = 0; i < out.length; i++) out[i] = String(text).charCodeAt(i) & 255;
        return out;
    }

    function bytesToText(bytes) {
        const arr = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes);
        if (typeof TextDecoder !== "undefined") return new TextDecoder().decode(arr);
        if (typeof Buffer !== "undefined") return Buffer.from(arr).toString("utf8");
        let out = "";
        for (let i = 0; i < arr.length; i++) out += String.fromCharCode(arr[i]);
        return out;
    }

    function bytesToHex(bytes) {
        const arr = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes);
        let out = "";
        for (let i = 0; i < arr.length; i++) {
            const hex = arr[i].toString(16);
            out += hex.length === 1 ? "0" + hex : hex;
        }
        return out;
    }

    function hexToBytes(hex) {
        const clean = String(hex || "").replace(/[^0-9a-f]/gi, "");
        const out = new Uint8Array(Math.floor(clean.length / 2));
        for (let i = 0; i < out.length; i++) out[i] = parseInt(clean.substr(i * 2, 2), 16);
        return out;
    }

    function bytesToBase64(bytes) {
        const arr = bytes instanceof Uint8Array ? bytes : new Uint8Array(bytes);
        if (typeof Buffer !== "undefined") return Buffer.from(arr).toString("base64");
        let binary = "";
        for (let i = 0; i < arr.length; i++) binary += String.fromCharCode(arr[i]);
        if (typeof btoa === "function") return btoa(binary);
        throw new Error("No base64 encoder available");
    }

    function randomBytesCompat(length) {
        const nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.randomBytes === "function") {
            return Uint8Array.from(nodeCrypto.randomBytes(length));
        }

        const runtimeCrypto = getRuntimeCrypto();
        if (runtimeCrypto && typeof runtimeCrypto.getRandomValues === "function") {
            const out = new Uint8Array(length);
            runtimeCrypto.getRandomValues(out);
            return out;
        }

        const out = new Uint8Array(length);
        for (let i = 0; i < length; i++) out[i] = Math.floor(Math.random() * 256);
        return out;
    }

    async function aesCbcEncrypt(plainText, keyBytes, ivBytes) {
        const nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createCipheriv === "function") {
            const cipher = nodeCrypto.createCipheriv(
                "aes-256-cbc",
                Buffer.from(keyBytes),
                Buffer.from(ivBytes)
            );
            let encrypted = cipher.update(String(plainText), "utf8");
            encrypted = Buffer.concat([encrypted, cipher.final()]);
            return Uint8Array.from(encrypted);
        }

        const runtimeCrypto = getRuntimeCrypto();
        if (runtimeCrypto && runtimeCrypto.subtle) {
            const key = await runtimeCrypto.subtle.importKey(
                "raw",
                keyBytes,
                { name: "AES-CBC" },
                false,
                ["encrypt"]
            );
            const encrypted = await runtimeCrypto.subtle.encrypt(
                { name: "AES-CBC", iv: ivBytes },
                key,
                textToBytes(plainText)
            );
            return new Uint8Array(encrypted);
        }

        throw new Error("AES encryption unavailable");
    }

    async function aesCbcDecrypt(cipherBytes, keyBytes, ivBytes) {
        const nodeCrypto = getNodeCrypto();
        if (nodeCrypto && typeof nodeCrypto.createDecipheriv === "function") {
            const decipher = nodeCrypto.createDecipheriv(
                "aes-256-cbc",
                Buffer.from(keyBytes),
                Buffer.from(ivBytes)
            );
            let decrypted = decipher.update(Buffer.from(cipherBytes));
            decrypted = Buffer.concat([decrypted, decipher.final()]);
            return Uint8Array.from(decrypted);
        }

        const runtimeCrypto = getRuntimeCrypto();
        if (runtimeCrypto && runtimeCrypto.subtle) {
            const key = await runtimeCrypto.subtle.importKey(
                "raw",
                keyBytes,
                { name: "AES-CBC" },
                false,
                ["decrypt"]
            );
            const decrypted = await runtimeCrypto.subtle.decrypt(
                { name: "AES-CBC", iv: ivBytes },
                key,
                cipherBytes
            );
            return new Uint8Array(decrypted);
        }

        throw new Error("AES decryption unavailable");
    }

    async function encodeVidlinkId(id) {
        const keyBytes = hexToBytes(VIDLINK_KEY_HEX).slice(0, 32);
        const ivBytes = randomBytesCompat(16);
        const cipherBytes = await aesCbcEncrypt(String(id), keyBytes, ivBytes);
        return bytesToBase64(textToBytes(bytesToHex(ivBytes) + ":" + bytesToHex(cipherBytes)));
    }

    async function decryptVidlinkPayload(payloadText) {
        const parts = String(payloadText || "").trim().split(":");
        if (parts.length !== 2) throw new Error("Invalid Vidlink payload");
        const keyBytes = hexToBytes(VIDLINK_KEY_HEX).slice(0, 32);
        const ivBytes = hexToBytes(parts[0]);
        const cipherBytes = hexToBytes(parts[1]);
        const decrypted = await aesCbcDecrypt(cipherBytes, keyBytes, ivBytes);
        return bytesToText(decrypted);
    }

    async function resolveVidlinkApiUrls(payload) {
        if (!payload || (payload.type !== "movie" && payload.type !== "tv" && payload.type !== "anime")) return [];

        try {
            const encodedId = await encodeVidlinkId(payload.id);
            let apiUrl = VIDLINK_API + "/movie/" + encodedId;

            if (payload.type === "tv") {
                apiUrl = VIDLINK_API + "/tv/" + encodedId + "/" + String(payload.season || 1) + "/" + String(payload.episode || 1);
            } else if (payload.type === "anime") {
                apiUrl = VIDLINK_API + "/anime/" + encodedId + "/" + String(payload.episode || 1) + "/" + (payload.dub ? "dub" : "sub");
            }

            const response = await http_get(apiUrl);
            const decrypted = await decryptVidlinkPayload(response.body || "");
            const parsed = parseJsonSafely(decrypted);
            const urls = [];

            if (parsed && parsed.stream) {
                if (parsed.stream.playlist) urls.push(parsed.stream.playlist);
                if (Array.isArray(parsed.stream.alternates)) {
                    parsed.stream.alternates.forEach(function (item) {
                        const value = item && (item.playlist || item.file || item.url);
                        if (value) urls.push(value);
                    });
                }
            }

            return uniqueStrings(urls.filter(Boolean));
        } catch (e) {
            warn("vidlink api failed", payload.type, payload.id, e.message);
            return [];
        }
    }

    function extractDirectMediaUrls(text, currentUrl) {
        const found = [];
        const patterns = [
            /https?:\/\/[^"'`\s<>]+?\.(?:m3u8|mp4|mkv|webm)(?:\?[^"'`\s<>]*)?/ig,
            /["']file["']\s*:\s*["']([^"']+?(?:m3u8|mp4|mkv|webm)(?:\?[^"']*)?)["']/ig,
            /<source[^>]+src=["']([^"']+?(?:m3u8|mp4|mkv|webm)(?:\?[^"']*)?)["']/ig
        ];

        for (let i = 0; i < patterns.length; i++) {
            const regex = patterns[i];
            let match;
            while ((match = regex.exec(text))) {
                const value = match[1] || match[0];
                found.push(absoluteUrl(currentUrl, value));
            }
        }

        const json = parseJsonSafely(text);
        if (json && Array.isArray(json.sources)) {
            json.sources.forEach(function (source) {
                const url = source && (source.file || source.src || source.url);
                if (url) found.push(absoluteUrl(currentUrl, url));
            });
        }

        return uniqueStrings(found.filter(Boolean));
    }

    function extractIframeUrls(text, currentUrl) {
        const found = [];
        const patterns = [
            /<iframe[^>]+src=["']([^"']+)["']/ig,
            /["']iframe["']\s*:\s*["']([^"']+)["']/ig,
            /id=["']player_iframe["'][^>]+src=["']([^"']+)["']/ig
        ];

        for (let i = 0; i < patterns.length; i++) {
            const regex = patterns[i];
            let match;
            while ((match = regex.exec(text))) {
                found.push(absoluteUrl(currentUrl, match[1]));
            }
        }

        return uniqueStrings(found.filter(Boolean));
    }

    function base64DecodeCompat(value) {
        const text = String(value || "");
        if (typeof atob === "function") return atob(text);
        if (typeof Buffer !== "undefined") return Buffer.from(text, "base64").toString("binary");
        throw new Error("No base64 decoder available");
    }

    function decodeBase64Utf8Compat(value) {
        const binary = base64DecodeCompat(value);
        const bytes = new Uint8Array(binary.length);
        for (let i = 0; i < binary.length; i++) bytes[i] = binary.charCodeAt(i);
        return bytesToText(bytes);
    }

    function vidsrcDecoder1(value) {
        const chunkSize = 3;
        const chunks = [];
        for (let i = 0; i < value.length; i += chunkSize) {
            chunks.push(value.substring(i, Math.min(i + chunkSize, value.length)));
        }
        return chunks.reverse().join("");
    }

    function vidsrcDecoder2(value) {
        const key = "pWB9V)[*4I`nJpp?ozyB~dbr9yt!_n4u".split("").map(function (ch) { return ch.charCodeAt(0); });
        const bytes = String(value || "").match(/.{2}/g) || [];
        const decrypted = bytes.map(function (hex, index) {
            return (parseInt(hex, 16) ^ key[index % key.length]) - 3;
        });
        return decodeBase64Utf8Compat(String.fromCharCode.apply(String, decrypted));
    }

    function vidsrcDecoder3(value) {
        const rotated = String(value || "").split("").map(function (ch) {
            if (/[a-mA-M]/.test(ch)) return String.fromCharCode(ch.charCodeAt(0) + 13);
            if (/[n-zN-Z]/.test(ch)) return String.fromCharCode(ch.charCodeAt(0) - 13);
            return ch;
        }).join("");
        return decodeBase64Utf8Compat(rotated);
    }

    function vidsrcDecoder4(value) {
        const filtered = String(value || "").split("").reverse().filter(function (_, index) {
            return index % 2 === 0;
        }).join("");
        return decodeBase64Utf8Compat(filtered);
    }

    function vidsrcDecoder5(value) {
        const reversed = String(value || "").split("").reverse().map(function (ch) {
            return String.fromCharCode(ch.charCodeAt(0) - 1);
        }).join("");
        const pairs = reversed.match(/.{1,2}/g) || [];
        return pairs.map(function (pair) { return String.fromCharCode(parseInt(pair, 16)); }).join("");
    }

    function vidsrcDecoder6(value) {
        const chars = String(value || "").split("").reverse().map(function (ch) {
            return ch.charCodeAt(0) - 1;
        });
        const bytes = [];
        for (let i = 0; i < chars.length; i += 2) {
            bytes.push(parseInt(String.fromCharCode(chars[i], chars[i + 1]), 16));
        }
        return bytesToText(new Uint8Array(bytes));
    }

    function vidsrcDecoder7(value) {
        const trimmed = String(value || "").slice(10, -16);
        const key = "3SAY~#%Y(V%>5d/Yg\"$G[Lh1rK4a;7ok".split("").map(function (ch) { return ch.charCodeAt(0); });
        const decoded = base64DecodeCompat(trimmed).split("").map(function (ch) { return ch.charCodeAt(0); });
        const out = decoded.map(function (num, index) { return num ^ key[index % key.length]; });
        return String.fromCharCode.apply(String, out);
    }

    function vidsrcDecoder8(value) {
        const map = {
            x: "a", y: "b", z: "c", a: "d", b: "e", c: "f", d: "g", e: "h", f: "i", g: "j", h: "k", i: "l", j: "m",
            k: "n", l: "o", m: "p", n: "q", o: "r", p: "s", q: "t", r: "u", s: "v", t: "w", u: "x", v: "y", w: "z",
            X: "A", Y: "B", Z: "C", A: "D", B: "E", C: "F", D: "G", E: "H", F: "I", G: "J", H: "K", I: "L", J: "M",
            K: "N", L: "O", M: "P", N: "Q", O: "R", P: "S", Q: "T", R: "U", S: "V", T: "W", U: "X", V: "Y", W: "Z"
        };
        return String(value || "").split("").map(function (ch) { return map[ch] || ch; }).join("");
    }

    function vidsrcDecoder9(value, shift) {
        const normalized = String(value || "").split("").reverse().map(function (ch) {
            if (ch === "-") return "+";
            if (ch === "_") return "/";
            return ch;
        }).join("");
        const decoded = base64DecodeCompat(normalized).split("").map(function (ch) {
            return ch.charCodeAt(0) - shift;
        });
        return String.fromCharCode.apply(String, decoded);
    }

    function decodeVidSrcContent(decoderId, content) {
        const decoders = {
            NdonQLf1Tzyx7bMG: function (v) { return vidsrcDecoder1(v); },
            sXnL9MQIry: function (v) { return vidsrcDecoder2(v); },
            IhWrImMIGL: function (v) { return vidsrcDecoder3(v); },
            KJHidj7det: function (v) { return vidsrcDecoder7(v); },
            Oi3v1dAlaM: function (v) { return vidsrcDecoder9(v, 5); },
            TsA2KGDGux: function (v) { return vidsrcDecoder9(v, 7); },
            JoAHUMCLXV: function (v) { return vidsrcDecoder9(v, 3); },
            eSfH1IRMyL: function (v) { return vidsrcDecoder6(v); },
            o2VSUnjnZl: function (v) { return vidsrcDecoder8(v); },
            xTyBxQyGTA: function (v) { return vidsrcDecoder4(v); },
            ux8qjPHC66: function (v) { return vidsrcDecoder5(v); }
        };
        return decoders[decoderId] ? decoders[decoderId](content) : null;
    }

    function parseVixsrcQualities(text) {
        const out = [];
        const lines = String(text || "").split(/\r?\n/);
        for (let i = 0; i < lines.length; i++) {
            const line = lines[i].trim();
            if (!/^#EXT-X-STREAM-INF:/i.test(line)) continue;
            const nextLine = (lines[i + 1] || "").trim();
            if (!/^https?:\/\//i.test(nextLine)) continue;
            const resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
            out.push({
                url: nextLine,
                quality: resMatch ? parseInt(resMatch[1], 10) : 720
            });
        }
        out.sort(function (a, b) { return (b.quality || 0) - (a.quality || 0); });
        return out;
    }

    async function resolveVixsrcApiUrls(entry) {
        try {
            const page = await http_get(entry.url);
            const html = String(page.body || "");
            const token = (html.match(/['"]token['"]\s*:\s*['"]([^'"]+)['"]/) || [])[1];
            const expires = (html.match(/['"]expires['"]\s*:\s*['"]([^'"]+)['"]/) || [])[1];
            const playlist = (html.match(/url\s*:\s*['"]([^'"]+)['"]/) || [])[1];

            if (!token || !expires || !playlist) return [];

            let masterUrl = playlist + (playlist.indexOf("?") >= 0 ? "&" : "?") +
                "token=" + encodeURIComponent(token) +
                "&expires=" + encodeURIComponent(expires) +
                "&h=1&lang=en";

            const master = await http_get(masterUrl);
            const qualities = parseVixsrcQualities(master.body || "");
            if (qualities.length) return qualities;
            if (/#EXTM3U/i.test(String(master.body || ""))) {
                return [{ url: masterUrl, quality: 1080 }];
            }
        } catch (e) {
            warn("vixsrc api failed", entry.url, e.message);
        }
        return [];
    }

    async function resolveVidSrcUrls(entry) {
        try {
            const outer = await http_get(entry.url);
            const outerHtml = String(outer.body || "");
            const iframeMatch = outerHtml.match(/id=["']player_iframe["'][^>]+src=["']([^"']+)["']/i) ||
                outerHtml.match(/<iframe[^>]+src=["']([^"']+)["']/i);
            if (!iframeMatch) return [];

            const secondUrl = absoluteUrl(entry.url, iframeMatch[1]);
            const second = await http_get(secondUrl);
            const secondHtml = String(second.body || "");
            const thirdMatch = secondHtml.match(/src:\s*'([^']*\/prorcp\/[^']+)'/i) ||
                secondHtml.match(/<iframe[^>]+src=["']([^"']*\/prorcp\/[^"']+)["']/i);
            if (!thirdMatch) return [];

            const thirdUrl = absoluteUrl(secondUrl, thirdMatch[1]);
            const third = await http_get(thirdUrl);
            const thirdHtml = String(third.body || "");
            const paramsMatch = thirdHtml.match(/<div id="([^"]+)" style="display:none;">([^<]+)<\/div>/i);
            if (paramsMatch) {
                const decoded = decodeVidSrcContent(paramsMatch[1], paramsMatch[2]);
                if (decoded) return [{ url: decoded, quality: 1080 }];
            }

            const fileMatch = thirdHtml.match(/player_parent.*?file:\s*'([^']+)'.*?cuid/si);
            if (fileMatch) return [{ url: fileMatch[1], quality: 1080 }];
        } catch (e) {
            warn("vidsrc direct failed", entry.url, e.message);
        }
        return [];
    }

    async function resolvePlayableUrls(url, depth, seen) {
        if (!url || depth < 0 || seen[url]) return [];
        seen[url] = true;

        if (/\.(?:m3u8|mp4|mkv|webm)(?:[?#].*)?$/i.test(url)) return [url];

        try {
            const response = await http_get(url);
            const headers = String(response.headers || "");
            const body = String(response.body || "");
            if (/application\/(?:vnd\.apple\.mpegurl|x-mpegurl)|video\//i.test(headers)) return [url];

            const direct = extractDirectMediaUrls(body, url);
            if (direct.length) return direct;

            if (depth === 0) return [];

            const iframes = extractIframeUrls(body, url);
            for (let i = 0; i < iframes.length; i++) {
                const nested = await resolvePlayableUrls(iframes[i], depth - 1, seen);
                if (nested.length) return nested;
            }

            if (iframes.length) return [iframes[0]];
        } catch (e) {
            warn("resolve playable failed", url, e.message);
        }

        return [];
    }

    function buildMovieTvStreams(type, payload, externalIds) {
        const out = [];
        const seen = {};
        Object.keys(MOVIE_TV_PROVIDERS).forEach(function (name) {
            const provider = MOVIE_TV_PROVIDERS[name];
            const template = provider[type];
            if (!template) return;
            let streamUrl = template
                .replace(/\{id\}/g, String(payload.id))
                .replace(/\{imdbId\}/g, String(externalIds.imdb_id || payload.id))
                .replace(/\{season\}/g, String(payload.season || 1))
                .replace(/\{episode\}/g, String(payload.episode || 1));
            if (seen[streamUrl]) return;
            seen[streamUrl] = true;
            out.push({
                providerName: name,
                provider: provider,
                url: streamUrl,
                payload: payload
            });
        });
        return out;
    }

    function buildAnimeStreams(payload) {
        const out = [];
        const seen = {};
        const animeId = payload.anilistId || payload.id;
        const malId = payload.malId || animeId || payload.id;

        Object.keys(ANIME_PROVIDERS).forEach(function (name) {
            const provider = ANIME_PROVIDERS[name];
            if (provider.requiresEpId && !payload.epId) return;
            let streamUrl = provider.anime
                .replace(/\{id\}/g, String(animeId || payload.id))
                .replace(/\{episode\}/g, String(payload.episode || 1))
                .replace(/\{malId\}/g, String(malId || payload.id))
                .replace(/\{epId\}/g, String(payload.epId || ""));
            if (seen[streamUrl]) return;
            seen[streamUrl] = true;
            out.push({
                providerName: name,
                provider: provider,
                url: streamUrl,
                payload: payload
            });
        });

        return out;
    }

    function toStreamResult(entry, url, suffix) {
        const provider = entry.provider || {};
        return new StreamResult({
            url: url,
            quality: providerQuality(entry.providerName, provider.recommended),
            source: "[" + entry.providerName + "]" +
                (provider.recommended ? "[Recommended]" : "") +
                (provider.sandbox ? "[Sandbox]" : "") +
                (suffix ? "[" + suffix + "]" : "")
        });
    }

    async function expandStreamEntries(entries) {
        const direct = [];
        const fallback = [];
        const seen = {};

        for (let i = 0; i < entries.length; i++) {
            const entry = entries[i];
            if (entry.providerName === "vidpro") {
                const apiResolved = await resolveVidlinkApiUrls(entry.payload);
                if (apiResolved.length) {
                    apiResolved.forEach(function (url) {
                        if (seen[url]) return;
                        seen[url] = true;
                        direct.push(toStreamResult(entry, url, "API"));
                    });
                    continue;
                }
            }

            if (entry.providerName === "italian") {
                const vixsrcResolved = await resolveVixsrcApiUrls(entry);
                if (vixsrcResolved.length) {
                    vixsrcResolved.forEach(function (item) {
                        const url = item.url || item;
                        if (!url || seen[url]) return;
                        seen[url] = true;
                        direct.push(new StreamResult({
                            url: url,
                            quality: item.quality || 1080,
                            source: "[italian][Direct]"
                        }));
                    });
                    continue;
                }
            }

            if (entry.providerName === "vidsrc") {
                const vidsrcResolved = await resolveVidSrcUrls(entry);
                if (vidsrcResolved.length) {
                    vidsrcResolved.forEach(function (item) {
                        const url = item.url || item;
                        if (!url || seen[url]) return;
                        seen[url] = true;
                        direct.push(new StreamResult({
                            url: url,
                            quality: item.quality || 1080,
                            source: "[vidsrc][Direct]"
                        }));
                    });
                    continue;
                }
            }

            const resolved = await resolvePlayableUrls(entry.url, 2, {});
            if (resolved.length) {
                resolved.forEach(function (url) {
                    if (seen[url]) return;
                    seen[url] = true;
                    direct.push(toStreamResult(
                        entry,
                        url,
                        /\.(?:m3u8|mp4|mkv|webm)(?:[?#].*)?$/i.test(url) ? "Resolved" : "Nested"
                    ));
                });
                continue;
            }

            if (!seen[entry.url]) {
                seen[entry.url] = true;
                fallback.push(toStreamResult(entry, entry.url, "Embed"));
            }
        }

        return direct.length ? direct.concat(fallback) : fallback;
    }

    async function loadStreams(url, cb) {
        try {
            const payload = parseStreamPayload(url);
            const base = await getBaseUrl();
            let results = [];
            let entries = [];

            if (payload.type === "movie" || payload.type === "tv") {
                const externalIds = await getExternalIds(base, payload.type, payload.id);
                entries = buildMovieTvStreams(payload.type, payload, externalIds);
            } else if (payload.type === "anime") {
                entries = buildAnimeStreams(payload);
            }

            results = await expandStreamEntries(entries);
            results.sort(function (a, b) { return (b.quality || 0) - (a.quality || 0); });
            cb({ success: true, data: results });
        } catch (e) {
            err("loadStreams", e.message);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    for (const ctx of [
        typeof globalThis !== "undefined" ? globalThis : null,
        typeof window !== "undefined" ? window : null,
        typeof global !== "undefined" ? global : null
    ]) {
        if (!ctx) continue;
        ctx.getHome = getHome;
        ctx.search = search;
        ctx.load = load;
        ctx.loadStreams = loadStreams;
    }
})();
