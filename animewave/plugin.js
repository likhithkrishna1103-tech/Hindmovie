(function () {
    var BASE_URL = (((typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://animewave.to") + "").replace(/\/+$/, "");
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";
    var CACHE_TTL = 5 * 60 * 1000;
    var HOME_CACHE = { value: null, time: 0 };
    var TEXT_CACHE = {};
    var JSON_CACHE = {};
    var KWIK_CACHE = {};
    var TEXT_INFLIGHT = {};
    var JSON_INFLIGHT = {};

    var PAGE_HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/",
        "Cookie": "country_code=IN"
    };

    function ajaxHeaders(referer) {
        return {
            "User-Agent": USER_AGENT,
            "Accept": "application/json, text/javascript, */*; q=0.01",
            "Accept-Language": "en-US,en;q=0.9",
            "X-Requested-With": "XMLHttpRequest",
            "Referer": referer || (BASE_URL + "/home"),
            "Cookie": "country_code=IN"
        };
    }

    function trim(value) {
        return String(value == null ? "" : value).trim();
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ");
    }

    function cleanText(value) {
        return decodeHtml(String(value || "")
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<[^>]+>/g, " "))
            .replace(/\s+/g, " ")
            .trim();
    }

    function absoluteUrl(base, value) {
        value = trim(value);
        if (!value) return "";
        if (/^https?:\/\//i.test(value)) return value;
        if (value.indexOf("//") === 0) return "https:" + value;
        try {
            return new URL(value, base || BASE_URL).toString();
        } catch (_) {
            return value;
        }
    }

    function base64Encode(value) {
        value = String(value || "");
        try {
            if (typeof btoa === "function") return btoa(unescape(encodeURIComponent(value)));
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(value, "utf8").toString("base64");
        } catch (_) {}
        return value;
    }

    function proxifyUrlV1(url) {
        return "MAGIC_PROXY_v1" + base64Encode(String(url || ""));
    }

    function buildMagicM3u8(body, playlistUrl) {
        var lines = String(body || "").split(/\r?\n/);
        var rewritten = [];
        for (var i = 0; i < lines.length; i++) {
            var line = String(lines[i] || "");
            var trimmed = line.trim();
            if (!trimmed) {
                rewritten.push(line);
                continue;
            }
            if (trimmed.charAt(0) === "#") {
                if (/^#EXT-X-KEY:/i.test(trimmed) && /URI="/i.test(trimmed)) {
                    rewritten.push(line.replace(/URI="([^"]+)"/i, function (_, uri) {
                        return 'URI="' + proxifyUrlV1(absoluteUrl(playlistUrl, uri)) + '"';
                    }));
                } else {
                    rewritten.push(line);
                }
                continue;
            }
            rewritten.push(proxifyUrlV1(absoluteUrl(playlistUrl, trimmed)));
        }
        return "magic_m3u8:" + base64Encode(rewritten.join("\n"));
    }

    async function buildMagicM3u8Url(url, headers) {
        try {
            var res = await http_get(url, headers || {});
            var body = res && (res.body || res.text || "") || "";
            if (!/#EXTM3U/i.test(body)) return proxifyUrlV1(url);
            return buildMagicM3u8(body, url);
        } catch (_) {
            return proxifyUrlV1(url);
        }
    }

    function base64Decode(value) {
        value = String(value || "");
        try {
            if (typeof atob === "function") return decodeURIComponent(escape(atob(value)));
        } catch (_) {}
        try {
            if (typeof Buffer !== "undefined") return Buffer.from(value, "base64").toString("utf8");
        } catch (_) {}
        return "";
    }

    function packPayload(payload) {
        return "animewave:" + base64Encode(JSON.stringify(payload || {}));
    }

    function unpackPayload(url) {
        var raw = String(url || "");
        if (raw.indexOf("animewave:") === 0) {
            var decoded = base64Decode(raw.slice("animewave:".length));
            return JSON.parse(decoded || "{}");
        }
        return { url: raw };
    }

    function parseAttrs(tag) {
        var attrs = {};
        String(tag || "").replace(/([:\w-]+)\s*=\s*(["'])([\s\S]*?)\2/g, function (_, key, __, value) {
            attrs[key] = decodeHtml(value);
            return "";
        });
        return attrs;
    }

    function uniqueBy(list, keyFn) {
        var seen = Object.create(null);
        var out = [];
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function cacheGet(map, key, ttl) {
        var entry = map[key];
        if (!entry) return null;
        if (Date.now() - entry.time > (ttl || CACHE_TTL)) {
            delete map[key];
            return null;
        }
        return entry.value;
    }

    function cacheSet(map, key, value) {
        map[key] = { value: value, time: Date.now() };
        return value;
    }

    async function getText(url, headers, ttl) {
        var key = url + "\n" + JSON.stringify(headers || {});
        var cached = cacheGet(TEXT_CACHE, key, ttl || CACHE_TTL);
        if (cached != null) return cached;
        if (TEXT_INFLIGHT[key]) return TEXT_INFLIGHT[key];
        TEXT_INFLIGHT[key] = (async function () {
            try {
                var res = await http_get(url, headers || PAGE_HEADERS);
                var body = res && (typeof res.body !== "undefined" ? res.body : res.text) || "";
                return cacheSet(TEXT_CACHE, key, String(body || ""));
            } finally {
                delete TEXT_INFLIGHT[key];
            }
        })();
        return TEXT_INFLIGHT[key];
    }

    async function getJson(url, headers, ttl) {
        var key = url + "\n" + JSON.stringify(headers || {});
        var cached = cacheGet(JSON_CACHE, key, ttl || CACHE_TTL);
        if (cached) return cached;
        if (JSON_INFLIGHT[key]) return JSON_INFLIGHT[key];
        JSON_INFLIGHT[key] = (async function () {
            try {
                var text = await getText(url, headers || ajaxHeaders(BASE_URL + "/home"), ttl || CACHE_TTL);
                var json = JSON.parse(text || "{}");
                return cacheSet(JSON_CACHE, key, json);
            } finally {
                delete JSON_INFLIGHT[key];
            }
        })();
        return JSON_INFLIGHT[key];
    }

    function getQuality(text) {
        text = String(text || "");
        var match = text.match(/(?:^|[^\d])((?:2160|1440|1080|720|540|480|360|240))p?(?:[^\d]|$)/i);
        return match ? Number(match[1]) : 0;
    }

    function _toBase(n, a) {
        var chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (a <= 36) return n.toString(a);
        if (n === 0) return "0";
        var result = "";
        while (n > 0) {
            result = chars[n % a] + result;
            n = Math.floor(n / a);
        }
        return result;
    }

    function _decodePacked(p, a, c, k) {
        while (c--) {
            if (k[c] && k[c] !== "") {
                p = p.replace(new RegExp("\\b" + _toBase(c, a) + "\\b", "g"), k[c]);
            }
        }
        return p;
    }

    function unpackJS(script) {
        try {
            if (!script || script.indexOf("function(p,a,c,k,e") === -1) return null;
            var bracePos = script.lastIndexOf("}(");
            if (bracePos === -1) return null;
            var pos = bracePos + 2;
            var slen = script.length;

            function skipWS() { while (pos < slen && /\s/.test(script[pos])) pos++; }
            function readString() {
                var q = script[pos];
                pos++;
                var out = "";
                while (pos < slen) {
                    var ch = script[pos];
                    if (ch === "\\") {
                        pos++;
                        var esc = script[pos] || "";
                        var map = { "n": "\n", "r": "\r", "t": "\t", "\\": "\\", "'": "'", "\"": "\"" };
                        out += (map[esc] !== undefined ? map[esc] : esc);
                        pos++;
                    } else if (ch === q) {
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
                var s = pos;
                while (pos < slen && /\d/.test(script[pos])) pos++;
                return parseInt(script.slice(s, pos), 10);
            }
            function skipComma() { skipWS(); if (pos < slen && script[pos] === ",") pos++; skipWS(); }
            function skipPastChar(ch) { while (pos < slen && script[pos] !== ch) pos++; if (pos < slen) pos++; }

            skipWS();
            if (script[pos] !== "'" && script[pos] !== "\"") return null;
            var p = readString();
            skipComma();
            var a = readInt();
            skipComma();
            var c = readInt();
            skipComma();
            var k;
            if (script[pos] === "'" || script[pos] === "\"") {
                k = readString().split("|");
                skipWS();
                if (pos < slen && script[pos] === ".") skipPastChar(")");
            } else if (script[pos] === "[") {
                pos++;
                k = [];
                while (pos < slen && script[pos] !== "]") {
                    skipWS();
                    if (script[pos] === "'" || script[pos] === "\"") k.push(readString());
                    else { k.push(""); pos++; }
                    skipWS();
                    if (pos < slen && script[pos] === ",") pos++;
                }
            } else {
                return null;
            }
            if (isNaN(a) || a < 2 || isNaN(c) || c < 0) return null;
            return _decodePacked(p, a, c, k);
        } catch (_) {
            return null;
        }
    }

    async function extractKwikStream(kwikUrl) {
        var cached = cacheGet(KWIK_CACHE, kwikUrl, CACHE_TTL);
        if (cached) return cached;
        var html = await getText(kwikUrl, {
            "User-Agent": USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Referer": kwikUrl
        }, 60 * 1000);
        var scriptMatch = html.match(/<script[^>]*>\s*(eval\(function\(p,a,c,k,e[,d]*\)[\s\S]*?)<\/script>/);
        if (!scriptMatch && typeof getAndUnpack === "function") {
            try {
                var unpackedNative = getAndUnpack(html);
                var nativeMatch = String(unpackedNative || "").match(/(https?:\/\/[^\s'"]+\.m3u8[^\s'"]*)/);
                if (nativeMatch) return cacheSet(KWIK_CACHE, kwikUrl, nativeMatch[1]);
            } catch (_) {}
        }
        if (!scriptMatch) return null;
        var unpacked = unpackJS(scriptMatch[1]);
        if (!unpacked) return null;
        var m3u8Match = unpacked.match(/source\s*=\s*['"]([^'"]*\.m3u8[^'"]*)['"]/)
            || unpacked.match(/(https?:\/\/[^\s'"]+\.m3u8[^\s'"]*)/);
        return m3u8Match ? cacheSet(KWIK_CACHE, kwikUrl, m3u8Match[1]) : null;
    }

    function typeFromText(text) {
        text = String(text || "").toLowerCase();
        var typeMatch = text.match(/<span\b[^>]*class=["'][^"']*\bdot\b[^"']*["'][^>]*>\s*(movie|tv|ona|ova|special|music)\s*<\/span>/i);
        if (typeMatch && /movie/i.test(typeMatch[1])) return "movie";
        return "anime";
    }

    function safeMultimediaItem(data) {
        return new MultimediaItem({
            title: data.title || "Unknown",
            url: data.url,
            posterUrl: data.posterUrl || "",
            bannerUrl: data.bannerUrl || data.posterUrl || "",
            type: data.type || "anime"
        });
    }

    function cardFromHtml(block, pageUrl) {
        var posterAnchor = block.match(/<a\b([^>]*class=["'][^"']*\bposter\b[^"']*["'][^>]*)>/i);
        var titleAnchor = block.match(/<a\b([^>]*class=["'][^"']*\bname\b[^"']*\bd-title\b[^"']*["'][^>]*)>([\s\S]*?)<\/a>/i);
        var img = block.match(/<img\b[^>]*(?:data-src|src)=["']([^"']+)["']/i);
        var attrs = parseAttrs(titleAnchor && titleAnchor[1] || posterAnchor && posterAnchor[1] || "");
        var posterAttrs = parseAttrs(posterAnchor && posterAnchor[1] || "");
        var title = cleanText(titleAnchor && titleAnchor[2] || attrs.title || attrs["data-jp"] || "");
        var href = attrs.href || posterAttrs.href || "";
        var poster = img && img[1] || "";
        if (!title || !href) return null;
        var fullUrl = absoluteUrl(pageUrl || BASE_URL, href);
        return safeMultimediaItem({
            title: title,
            url: fullUrl,
            posterUrl: absoluteUrl(pageUrl || BASE_URL, poster),
            type: typeFromText(block)
        });
    }

    function parseCards(html, pageUrl) {
        var cards = [];
        var re = /<div\b[^>]*class=["'][^"']*\bitem\b[^"']*["'][^>]*>[\s\S]*?<a\b[^>]*class=["'][^"']*\bname\b[^"']*\bd-title\b[^"']*["'][^>]*>[\s\S]*?<\/a>[\s\S]*?<\/div>\s*<\/div>/gi;
        var match;
        while ((match = re.exec(html || "")) !== null) {
            var item = cardFromHtml(match[0], pageUrl);
            if (item) cards.push(item);
        }
        return uniqueBy(cards, function (item) { return item.url; });
    }

    function parseHeroCards(html) {
        var out = [];
        var re = /<div\b[^>]*class=["'][^"']*\bswiper-slide\b[^"']*\bitem\b[^"']*["'][^>]*>[\s\S]*?<h2\b[^>]*class=["'][^"']*\bd-title\b[^"']*["'][^>]*>([\s\S]*?)<\/h2>[\s\S]*?<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*\bplay\b[^"']*["'][\s\S]*?background-image:\s*url\((['"]?)([^'")]+)\3\)/gi;
        var match;
        while ((match = re.exec(html || "")) !== null) {
            out.push(safeMultimediaItem({
                title: cleanText(match[1]),
                url: absoluteUrl(BASE_URL, match[2]),
                posterUrl: absoluteUrl(BASE_URL, match[4]),
                bannerUrl: absoluteUrl(BASE_URL, match[4]),
                type: "anime"
            }));
        }
        return uniqueBy(out, function (item) { return item.url; });
    }

    function splitHomeSections(html) {
        var sections = [];
        var re = /<section\b[\s\S]*?<\/section>/gi;
        var match;
        while ((match = re.exec(html || "")) !== null) {
            var section = match[0];
            var title = cleanText((section.match(/<(?:h2|h3)\b[^>]*class=["'][^"']*(?:title|heading)[^"']*["'][^>]*>([\s\S]*?)<\/(?:h2|h3)>/i) || [])[1] || "");
            if (!title) title = cleanText((section.match(/<div\b[^>]*class=["'][^"']*\bheading\b[^"']*["'][^>]*>([\s\S]*?)<\/div>/i) || [])[1] || "");
            var items = parseCards(section, BASE_URL + "/home");
            if (title && items.length) sections.push({ title: title, items: items.slice(0, 24) });
        }
        return sections;
    }

    function makeSection(title, items) {
        return {
            title: title,
            items: uniqueBy(items || [], function (item) { return item.url; }).slice(0, 24)
        };
    }

    async function getHome(cb) {
        try {
            if (HOME_CACHE.value && Date.now() - HOME_CACHE.time < CACHE_TTL) {
                return cb({ success: true, data: HOME_CACHE.value });
            }
            var homeHtml = await getText(BASE_URL + "/home", PAGE_HEADERS);
            var sections = [];
            var hero = parseHeroCards(homeHtml);
            if (hero.length) sections.push(makeSection("Spotlight", hero));

            splitHomeSections(homeHtml).forEach(function (section) {
                sections.push(makeSection(section.title, section.items));
            });

            var fallbackPages = [
                { title: "Latest Updated", url: BASE_URL + "/latest-updated" },
                { title: "New Release", url: BASE_URL + "/new-release" },
                { title: "Most Viewed", url: BASE_URL + "/most-viewed" },
                { title: "Movies", url: BASE_URL + "/type/movie" },
                { title: "Currently Airing", url: BASE_URL + "/status/currently-airing" }
            ];
            var fallbackResults = await Promise.all(fallbackPages.map(function (page) {
                return getText(page.url, PAGE_HEADERS).then(function (html) {
                    return { title: page.title, items: parseCards(html, page.url) };
                }).catch(function () {
                    return { title: page.title, items: [] };
                });
            }));
            fallbackResults.forEach(function (section) {
                if (section.items.length) sections.push(makeSection(section.title, section.items));
            });

            sections = uniqueBy(sections.filter(function (section) {
                return section && section.items && section.items.length;
            }), function (section) { return section.title; });

            var homeData = {};
            sections.forEach(function (section) {
                homeData[section.title] = section.items;
            });
            HOME_CACHE = { value: homeData, time: Date.now() };
            cb({ success: true, data: homeData });
        } catch (error) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            query = trim(query);
            if (!query) return cb({ success: true, data: [] });
            var url = BASE_URL + "/filter?keyword=" + encodeURIComponent(query);
            var html = await getText(url, PAGE_HEADERS, 2 * 60 * 1000);
            cb({ success: true, data: parseCards(html, url) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    function parseWatchPage(html, url) {
        var watchTag = (html.match(/<div\b[^>]*id=["']watch-main["'][^>]*>/i) || [])[0] || "";
        var watchAttrs = parseAttrs(watchTag);
        var infoHtml = "";
        var infoStart = String(html || "").indexOf('id="w-info"');
        if (infoStart === -1) infoStart = String(html || "").indexOf("id='w-info'");
        if (infoStart !== -1) {
            var infoEnd = String(html || "").indexOf('id="ani-seasons"', infoStart);
            if (infoEnd === -1) infoEnd = String(html || "").indexOf("id='ani-seasons'", infoStart);
            infoHtml = String(html || "").slice(infoStart, infoEnd > infoStart ? infoEnd : undefined);
        }
        var title = cleanText((html.match(/<h1\b[^>]*class=["'][^"']*\bd-title\b[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i) || [])[1] || "");
        if (!title) title = cleanText((html.match(/<title>([\s\S]*?)<\/title>/i) || [])[1] || "").replace(/\s*-\s*AnimeWave.*$/i, "");
        var poster = ((infoHtml || html).match(/<div\b[^>]*class=["'][^"']*\bposter\b[^"']*["'][\s\S]*?<img\b[^>]*(?:data-src|src)=["']([^"']+)["']/i) || [])[1] || "";
        var banner = ((infoHtml || html).match(/background-image:\s*url\((['"]?)([^'")]+)\1\)/i) || [])[2] || poster;
        var description = cleanText((infoHtml.match(/<div\b[^>]*class=["'][^"']*\bcontent\b[^"']*["'][^>]*>([\s\S]*?)<\/div>/i) || [])[1] || "");
        if (!description) description = cleanText((html.match(/<meta\b[^>]*(?:name|property)=["'](?:description|og:description)["'][^>]*content=["']([^"']+)["']/i) || [])[1] || "");
        var year = Number((html.match(/\/year\/(\d{4})/i) || [])[1] || 0) || undefined;
        var genres = [];
        (infoHtml || html).replace(/<a\b[^>]*href=["'][^"']*\/genre\/[^"']+["'][^>]*>([\s\S]*?)<\/a>/gi, function (_, genre) {
            genre = cleanText(genre);
            if (genre) genres.push(genre);
            return "";
        });
        return {
            animeId: watchAttrs["data-id"] || "",
            cleanUrl: absoluteUrl(BASE_URL, watchAttrs["data-url"] || url).replace(/\/ep-\d+.*$/i, ""),
            title: title || "AnimeWave",
            posterUrl: absoluteUrl(BASE_URL, poster),
            bannerUrl: absoluteUrl(BASE_URL, banner),
            description: description,
            year: year,
            genres: uniqueBy(genres, function (item) { return item; })
        };
    }

    function buildNextAiring(episode, season, unixTime) {
        episode = Number(episode || 0) || 0;
        season = Number(season || 1) || 1;
        unixTime = Number(unixTime || 0) || 0;
        if (!episode || !unixTime) return undefined;
        var payload = { episode: episode, season: season, unixTime: unixTime };
        return typeof NextAiring === "function" ? new NextAiring(payload) : payload;
    }

    function parseNextAiring(html, episodes) {
        var blockMatch = String(html || "").match(/<div\b[^>]*class=["'][^"']*\bnext-episode\b[^"']*["'][\s\S]*?<\/div>/i);
        if (!blockMatch) return undefined;
        var block = blockMatch[0];
        var target = Number((block.match(/data-target=["'](\d+)["']/i) || [])[1] || 0) || 0;
        if (!target) return undefined;
        var text = cleanText(block);
        var explicitEp = Number((text.match(/episode\s+(\d+)/i) || [])[1] || 0) || 0;
        var maxEp = 0;
        for (var i = 0; i < (episodes || []).length; i++) {
            maxEp = Math.max(maxEp, Number(episodes[i] && episodes[i].episode || 0) || 0);
        }
        return buildNextAiring(explicitEp || (maxEp + 1), 1, target);
    }

    function parseEpisodes(html, meta) {
        var episodes = [];
        var re = /<a\b([^>]*data-ids=["'][^"']+["'][^>]*)>([\s\S]*?)<\/a>/gi;
        var match;
        while ((match = re.exec(html || "")) !== null) {
            var attrs = parseAttrs(match[1]);
            var epNum = Number(attrs["data-num"] || attrs["data-ep"] || 0) || (episodes.length + 1);
            var slug = attrs["data-slug"] || epNum;
            var name = cleanText(match[2]).replace(/\s+/g, " ") || ("Episode " + epNum);
            var watchUrl = meta.cleanUrl.replace(/\/+$/, "") + "/ep-" + slug;
            episodes.push(new Episode({
                name: name === String(epNum) ? ("Episode " + epNum) : name,
                season: 1,
                episode: epNum,
                posterUrl: meta.posterUrl,
                url: packPayload({
                    watchUrl: watchUrl,
                    cleanUrl: meta.cleanUrl,
                    animeId: meta.animeId,
                    serverIds: attrs["data-ids"] || "",
                    episode: epNum,
                    slug: slug,
                    sub: attrs["data-sub"] || "",
                    dub: attrs["data-dub"] || ""
                })
            }));
        }
        return episodes.sort(function (a, b) {
            return Number(a.episode || 0) - Number(b.episode || 0);
        });
    }

    async function load(url, cb) {
        try {
            var cleanUrl = absoluteUrl(BASE_URL, unpackPayload(url).url || url).replace(/\/ep-\d+.*$/i, "");
            var html = await getText(cleanUrl, PAGE_HEADERS);
            var meta = parseWatchPage(html, cleanUrl);
            if (!meta.animeId) throw new Error("AnimeWave anime id missing");
            var episodeJson = await getJson(BASE_URL + "/ajax/episode/list/" + encodeURIComponent(meta.animeId) + "?style=&vrf=", ajaxHeaders(cleanUrl), 2 * 60 * 1000);
            var episodeHtml = episodeJson && episodeJson.result || "";
            var episodes = parseEpisodes(episodeHtml, meta);
            var nextAiring = parseNextAiring(html, episodes);
            var item = new MultimediaItem({
                title: meta.title,
                url: cleanUrl,
                posterUrl: meta.posterUrl,
                bannerUrl: meta.bannerUrl || meta.posterUrl,
                description: meta.description,
                type: episodes.length === 1 ? "movie" : "anime",
                year: meta.year,
                genres: meta.genres,
                nextAiring: nextAiring,
                episodes: episodes
            });
            cb({ success: true, data: item });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(error && error.message || error) });
        }
    }

    function parseServers(html) {
        var servers = [];
        var sectionRe = /<div\b[^>]*class=["'][^"']*\btype\b[^"']*["'][^>]*data-type=["']([^"']+)["'][^>]*>([\s\S]*?)(?=<div\b[^>]*class=["'][^"']*\btype\b|$)/gi;
        var section;
        while ((section = sectionRe.exec(html || "")) !== null) {
            var lang = String(section[1] || "").toUpperCase() || "SUB";
            var body = section[2] || "";
            var liRe = /<li\b([^>]*data-link-id=["'][^"']+["'][^>]*)>([\s\S]*?)<\/li>/gi;
            var li;
            while ((li = liRe.exec(body)) !== null) {
                var attrs = parseAttrs(li[1]);
                var name = cleanText(li[2]) || "Server";
                servers.push({
                    language: lang,
                    name: name,
                    linkId: attrs["data-link-id"] || "",
                    serverId: attrs["data-sv-id"] || "",
                    episodeId: attrs["data-ep-id"] || ""
                });
            }
        }
        return uniqueBy(servers, function (server) { return server.linkId; });
    }

    function normalizeSubtitleTrack(track) {
        if (!track) return null;
        var file = trim(track.file || track.url || track.src || "");
        if (!file || /thumbnail/i.test(String(track.kind || "") + " " + file)) return null;
        return {
            url: file,
            language: trim(track.label || track.lang || track.language || "English")
        };
    }

    function buildStream(url, source, language, headers, subtitles, forcedQuality) {
        var quality = Number(forcedQuality || 0) || getQuality(source + " " + url);
        var isHls = /\.m3u8(?:$|[?#])/i.test(url);
        var isDash = /\.mpd(?:$|[?#])/i.test(url);
        var stream = new StreamResult({
            url: url,
            source: source + (quality ? (" [" + quality + "p]") : ""),
            quality: quality || undefined,
            type: isHls ? "hls" : (isDash ? "dash" : undefined),
            headers: headers || {},
            referer: headers && headers.Referer || BASE_URL + "/"
        });
        stream.language = language || "SUB";
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    async function expandM3u8(url, source, language, headers, subtitles) {
        var rows = [buildStream(url, source, language, headers, subtitles)];
        try {
            var playlist = await getText(url, headers, 30 * 1000);
            var variantRe = /#EXT-X-STREAM-INF:([^\n\r]*)[\r\n]+([^\r\n]+)/gi;
            var match;
            while ((match = variantRe.exec(playlist || "")) !== null) {
                var q = getQuality(match[1]);
                var variantUrl = absoluteUrl(url, trim(match[2]));
                if (!variantUrl) continue;
                rows.push(buildStream(variantUrl, source, language, headers, subtitles, q));
            }
        } catch (_) {}
        return uniqueBy(rows, function (item) { return item.url; });
    }

    async function resolveKwik(embedUrl, source, language) {
        var streamUrl = await extractKwikStream(embedUrl);
        if (!streamUrl) return [];
        var origin = (new URL(embedUrl)).origin;
        var headers = {
            "User-Agent": USER_AGENT,
            "Referer": origin + "/",
            "Origin": origin
        };
        var rows = await expandM3u8(streamUrl, source + " [Direct]", language, headers, []);
        try {
            var proxied = await buildMagicM3u8Url(streamUrl, headers);
            if (proxied && proxied !== streamUrl) {
                rows.push(buildStream(proxied, source + " [Direct Proxy]", language, headers, [], getQuality(streamUrl)));
            }
        } catch (_) {}
        return uniqueBy(rows, function (item) { return item.url; });
    }

    async function resolveMegaFamily(embedUrl, source, language, referer) {
        var origin = (new URL(embedUrl)).origin;
        var pageHtml = await getText(embedUrl, {
            "User-Agent": USER_AGENT,
            "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Referer": referer || origin + "/"
        }, 30 * 1000);

        var iframe = (pageHtml.match(/<iframe\b[^>]*src=["']([^"']+)["']/i) || [])[1] || "";
        if (iframe && /(?:megaplay\.buzz|vidwish\.live|kwik\.(?:cx|si)|kiwi\.)/i.test(iframe)) {
            return resolveHost(absoluteUrl(embedUrl, iframe), source, language, embedUrl);
        }

        var id = (pageHtml.match(/<title>\s*File\s+(\d+)/i) || [])[1]
            || (pageHtml.match(/data-id=["'](\d+)["']/i) || [])[1]
            || "";
        if (!id) return [];

        var json = await getJson(origin + "/stream/getSources?id=" + encodeURIComponent(id), {
            "User-Agent": USER_AGENT,
            "Accept": "application/json, text/javascript, */*; q=0.01",
            "X-Requested-With": "XMLHttpRequest",
            "Referer": origin + "/"
        }, 30 * 1000);
        var file = json && json.sources && (json.sources.file || (json.sources[0] && json.sources[0].file)) || "";
        if (!file) return [];
        file = file.replace(/\\\//g, "/");
        var subtitles = uniqueBy((json.tracks || []).map(normalizeSubtitleTrack).filter(Boolean), function (item) {
            return item.url;
        });
        var headers = {
            "User-Agent": USER_AGENT,
            "Referer": origin + "/",
            "Origin": origin
        };
        if (/\.m3u8(?:$|[?#])/i.test(file)) return expandM3u8(file, source + " [Direct]", language, headers, subtitles);
        return [buildStream(file, source + " [Direct]", language, headers, subtitles)];
    }

    async function resolveHost(embedUrl, source, language, referer) {
        var host = (embedUrl.match(/^https?:\/\/([^\/]+)/i) || [])[1] || "";
        if (/kwik\.(?:cx|si)|kiwi\./i.test(host)) return resolveKwik(embedUrl, source, language);
        if (/megaplay\.buzz|megacloud\.bloggy\.click|vidwish\.live/i.test(host)) {
            return resolveMegaFamily(embedUrl, source, language, referer);
        }
        return [];
    }

    async function resolveServer(server, referer) {
        var json = await getJson(BASE_URL + "/ajax/server?get=" + encodeURIComponent(server.linkId), ajaxHeaders(referer), 60 * 1000);
        var resultUrl = json && json.result && json.result.url || "";
        if (!resultUrl) return [];
        resultUrl = resultUrl.replace(/\\\//g, "/");
        var lang = server.language || "SUB";
        var source = "AnimeWave [" + lang + "] [" + trim(server.name || "Server") + "]";
        var host = (resultUrl.match(/^https?:\/\/([^\/]+)/i) || [])[1] || "";
        var headers = {
            "User-Agent": USER_AGENT,
            "Referer": referer || BASE_URL + "/",
            "Origin": BASE_URL
        };
        var rows = [];

        if (/megaplay\.buzz|megacloud\.bloggy\.click|vidwish\.live|kwik\.(?:cx|si)|kiwi\./i.test(host)) {
            try {
                rows = await resolveHost(resultUrl, source, lang, referer);
            } catch (_) {
                rows = [];
            }
        }

        if (!rows.length && /\.(?:m3u8|mp4|mkv|webm|mpd)(?:$|[?#])/i.test(resultUrl)) {
            rows = [buildStream(resultUrl, source, lang, headers)];
        }

        // If the endpoint ever starts returning a direct master playlist, expose variants too.
        if (/\.m3u8(?:$|[?#])/i.test(resultUrl)) {
            rows = rows.concat(await expandM3u8(resultUrl, source, lang, headers, []));
        }
        return uniqueBy(rows, function (item) { return item.url; });
    }

    async function loadStreams(url, cb) {
        try {
            var payload = unpackPayload(url);
            var serverIds = trim(payload.serverIds || "");
            var referer = trim(payload.watchUrl || payload.cleanUrl || BASE_URL + "/home");
            if (!serverIds && payload.url) {
                var loadResult = await new Promise(function (resolve) {
                    load(payload.url, function (res) { resolve(res); });
                });
                var eps = loadResult && loadResult.data && loadResult.data.episodes || [];
                if (eps.length) {
                    payload = unpackPayload(eps[0].url);
                    serverIds = trim(payload.serverIds || "");
                    referer = trim(payload.watchUrl || payload.cleanUrl || referer);
                }
            }
            if (!serverIds) throw new Error("AnimeWave server id missing");

            var listJson = await getJson(BASE_URL + "/ajax/server/list?servers=" + encodeURIComponent(serverIds), ajaxHeaders(referer), 60 * 1000);
            var servers = parseServers(listJson && listJson.result || "");
            if (!servers.length) return cb({ success: true, data: [] });

            var batches = await Promise.all(servers.map(function (server) {
                return resolveServer(server, referer).catch(function () { return []; });
            }));
            var streams = uniqueBy([].concat.apply([], batches).filter(Boolean), function (item) {
                return item && item.url;
            }).sort(function (a, b) {
                return Number(b.quality || 0) - Number(a.quality || 0);
            });
            cb({ success: true, data: streams });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
