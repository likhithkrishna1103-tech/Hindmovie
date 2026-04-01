(function () {
var DEBUG = false;

    var CINEMETA_CATALOG = "https://cinemeta-catalogs.strem.io";
    var CINEMETA_META = "https://v3-cinemeta.strem.io";
    var KITSU_BASE = "https://anime-kitsu.strem.fun";
    var ANIZIP = "https://api.ani.zip";
    var ANIMETOSHO = "https://feed.animetosho.org";
    var MOVIES4U_BASE = "https://movies4u.direct";
    var RTALLY_BASE = "https://www.rtally.xyz";

    var HOME_CONFIG = {
        animeAiring: { key: "Anime Airing Now", source: "kitsu", url: KITSU_BASE + "/catalog/anime/kitsu-anime-airing.json", limit: 18 },
        animeTrending: { key: "Anime Trending", source: "kitsu", url: KITSU_BASE + "/catalog/anime/kitsu-anime-trending.json", limit: 18 },
        tamilMovies: { key: "Tamil Movies", source: "cinemeta", url: CINEMETA_META + "/catalog/movie/top/search=tamil.json", limit: 18 },
        teluguMovies: { key: "Telugu Movies", source: "cinemeta", url: CINEMETA_META + "/catalog/movie/top/search=telugu.json", limit: 18 },
        hindiMovies: { key: "Hindi Movies", source: "cinemeta", url: CINEMETA_META + "/catalog/movie/top/search=hindi.json", limit: 18 },
        topMovies: { key: "Hollywood Blockbusters", source: "cinemeta", url: CINEMETA_CATALOG + "/top/catalog/movie/top.json", limit: 18 },
        topSeries: { key: "Hollywood Prestige Series", source: "cinemeta", url: CINEMETA_CATALOG + "/top/catalog/series/top.json", limit: 18 }
    };

    function log() {
        if (!DEBUG) return;
        var args = Array.prototype.slice.call(arguments);
        args.unshift("[CineStream]");
        console.log.apply(console, args);
    }

    function trim(str) {
        return (str || "").replace(/\s+/g, " ").replace(/^\s+|\s+$/g, "");
    }

    function parseJsonSafe(str, fallback) {
        if (str && typeof str === "object") return str;
        var value = String(str || "");
        try {
            return JSON.parse(value);
        } catch (e) {
            try {
                return JSON.parse(value.replace(/^'+|'+$/g, "").replace(/^\"+|\\"+$/g, "").replace(/\\"/g, "\""));
            } catch (e2) {
                var relaxed = parseLooseObject(value);
                return relaxed || fallback;
            }
        }
    }

    function parseLooseValue(value) {
        var text = trim(String(value || ""));
        if (!text.length) return "";
        if (text === "null") return null;
        if (text === "true") return true;
        if (text === "false") return false;
        if (/^-?\d+(?:\.\d+)?$/.test(text)) return Number(text);
        return text.replace(/^"(.*)"$/, "$1").replace(/^'(.*)'$/, "$1");
    }

    function parseLooseObject(str) {
        var text = trim(String(str || ""));
        if (!/^\{[\s\S]*\}$/.test(text)) return null;
        text = text.slice(1, -1);
        var out = {};
        var pattern = /([A-Za-z0-9_]+)\s*:\s*([\s\S]*?)(?=,\s*[A-Za-z0-9_]+\s*:|$)/g;
        var match;
        while ((match = pattern.exec(text))) {
            out[match[1]] = parseLooseValue(match[2]);
        }
        return Object.keys(out).length ? out : null;
    }

    function request(url, options) {
        options = options || {};
        var method = options.method || "GET";
        var headers = options.headers || { "User-Agent": "Mozilla/5.0" };
        var data = options.data;
        if (typeof axios !== "undefined" && axios && typeof axios.get === "function") {
            return axios({
                url: url,
                method: method,
                headers: headers,
                data: data,
                proxy: false,
                responseType: "text",
                transformResponse: [function (data) { return data; }]
            }).then(function (res) {
                return {
                    status: res.status,
                    statusCode: res.status,
                    body: typeof res.data === "string" ? res.data : JSON.stringify(res.data),
                    headers: res.headers || {}
                };
            }).catch(function (e) {
                return {
                    status: e.response && e.response.status || 500,
                    statusCode: e.response && e.response.status || 500,
                    body: e.response && (typeof e.response.data === "string" ? e.response.data : JSON.stringify(e.response.data)) || String(e.message || e),
                    headers: e.response && e.response.headers || {}
                };
            });
        }
        if (method === "GET") {
            return http_get(url, headers);
        }
        if (typeof fetch === "function") {
            return fetch(url, {
                method: method,
                headers: headers,
                body: method === "GET" || method === "HEAD" ? undefined : data,
                redirect: "follow"
            }).then(function (res) {
                return res.text().then(function (body) {
                    var outHeaders = {};
                    if (res && res.headers && typeof res.headers.forEach === "function") {
                        res.headers.forEach(function (value, key) {
                            outHeaders[key] = value;
                        });
                    }
                    return {
                        status: res.status,
                        statusCode: res.status,
                        body: body,
                        headers: outHeaders
                    };
                });
            }).catch(function (e) {
                return {
                    status: 500,
                    statusCode: 500,
                    body: String(e.message || e),
                    headers: {}
                };
            });
        }
        return Promise.reject(new Error(method + " requests require fetch or axios in this runtime"));
    }

    function httpText(url, headers) {
        return request(url, { headers: headers }).then(function (res) {
            return (res && res.body) || "";
        });
    }

    function httpJson(url, headers) {
        return request(url, { headers: headers }).then(function (res) {
            return JSON.parse((res && res.body) || "{}");
        });
    }

    function httpPostForm(url, form, headers) {
        var body = [];
        for (var key in form) {
            if (!form.hasOwnProperty(key)) continue;
            body.push(encodeURIComponent(key) + "=" + encodeURIComponent(form[key]));
        }
        return request(url, {
            method: "POST",
            headers: Object.assign({
                "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, headers || {}),
            data: body.join("&")
        }).then(function (res) {
            return (res && res.body) || "";
        });
    }

    function settled(promises) {
        return Promise.all(promises.map(function (p) {
            return Promise.resolve(p).then(function (value) {
                return { ok: true, value: value };
            }).catch(function (error) {
                return { ok: false, error: error };
            });
        }));
    }

    function withTimeout(promise, ms, label) {
        ms = ms || 12000;
        label = label || "operation";
        return new Promise(function (resolve, reject) {
            var done = false;
            var timer = setTimeout(function () {
                if (done) return;
                done = true;
                reject(new Error(label + " timed out"));
            }, ms);

            Promise.resolve(promise).then(function (value) {
                if (done) return;
                done = true;
                clearTimeout(timer);
                resolve(value);
            }).catch(function (error) {
                if (done) return;
                done = true;
                clearTimeout(timer);
                reject(error);
            });
        });
    }

    function firstSuccessful(items, worker) {
        items = items || [];
        var index = 0;

        function next() {
            if (index >= items.length) return Promise.reject(new Error("No working endpoint"));
            var current = items[index++];
            return Promise.resolve().then(function () {
                return worker(current);
            }).then(function (value) {
                return { item: current, value: value };
            }).catch(function () {
                return next();
            });
        }

        return next();
    }

    function extractYear(value) {
        var match = String(value || "").match(/\b(19|20)\d{2}\b/);
        return match ? parseInt(match[0], 10) : undefined;
    }

    function getQuality(text) {
        var lower = String(text || "").toLowerCase();
        if (/\b2160p\b|\b4k\b/.test(lower)) return 2160;
        if (/\b1440p\b/.test(lower)) return 1440;
        if (/\b1080p\b/.test(lower)) return 1080;
        if (/\b720p\b/.test(lower)) return 720;
        if (/\b576p\b/.test(lower)) return 576;
        if (/\b480p\b/.test(lower)) return 480;
        if (/\b360p\b/.test(lower)) return 360;
        return 0;
    }

    function extractSize(text) {
        var match = String(text || "").match(/(\d+(?:\.\d+)?)\s*(GB|MB)/i);
        return match ? (match[1] + " " + match[2].toUpperCase()) : "";
    }

    function formatBytes(bytes) {
        if (!bytes || isNaN(bytes)) return "";
        if (bytes >= 1073741824) return (Math.round((bytes / 1073741824) * 100) / 100) + " GB";
        if (bytes >= 1048576) return (Math.round((bytes / 1048576) * 100) / 100) + " MB";
        if (bytes >= 1024) return (Math.round((bytes / 1024) * 100) / 100) + " KB";
        return String(bytes) + " B";
    }

    function normalizeTitle(value) {
        return trim(String(value || "").toLowerCase()
            .replace(/&/g, " and ")
            .replace(/[^a-z0-9]+/g, " "));
    }

    function wordOverlap(left, right) {
        var a = normalizeTitle(left).split(" ");
        var b = normalizeTitle(right).split(" ");
        var set = {};
        var matches = 0;
        var i;
        for (i = 0; i < b.length; i++) {
            if (b[i]) set[b[i]] = true;
        }
        for (i = 0; i < a.length; i++) {
            if (a[i] && set[a[i]]) matches++;
        }
        return a.length || b.length ? (matches / Math.max(a.length || 1, b.length || 1)) : 0;
    }

    function significantWords(value) {
        var stop = {
            "the": true, "a": true, "an": true, "and": true, "of": true, "for": true, "to": true,
            "in": true, "on": true, "part": true, "season": true, "series": true, "episode": true,
            "ep": true, "movie": true, "web": true, "dl": true, "webrip": true, "webdl": true,
            "hdrip": true, "bluray": true, "brrip": true, "x264": true, "x265": true, "hevc": true,
            "aac": true, "dd": true, "org": true, "original": true, "audio": true, "audios": true,
            "dubbed": true, "dual": true, "multi": true, "subs": true, "sub": true, "hq": true,
            "hd": true, "true": true, "proper": true, "complete": true
        };
        return normalizeTitle(value).split(" ").filter(function (word) {
            return word && !stop[word] && !/^\d+$/.test(word) && word.length > 2;
        });
    }

    function isSeriesTitle(title) {
        var lower = String(title || "").toLowerCase();
        return /\bs\d{1,2}\b/.test(lower) ||
            /\bseason\b/.test(lower) ||
            /\bepisode\b/.test(lower) ||
            /\bweb[- ]?series\b/.test(lower);
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function cleanHtmlText(value) {
        return trim(String(value || "")
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<[^>]+>/g, " ")
            .replace(/&nbsp;/g, " ")
            .replace(/&amp;/g, "&")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">"));
    }

    function toAbsoluteUrl(url, base) {
        if (!url) return "";
        if (/^https?:\/\//i.test(url)) return url;
        if (url.indexOf("//") === 0) return "https:" + url;
        if (!base) return url;
        if (url.charAt(0) === "/") return base + url;
        return base + "/" + url.replace(/^\.\//, "");
    }

    function slugify(value) {
        return trim(String(value || "").toLowerCase())
            .replace(/&/g, " and ")
            .replace(/[^a-z0-9]+/g, "-")
            .replace(/^-+|-+$/g, "");
    }

    function getEpisodeTag(season, episode) {
        function pad(num) {
            num = Number(num || 0);
            return num < 10 ? "0" + num : String(num);
        }
        return "S" + pad(season) + "E" + pad(episode);
    }

    function decodeHtmlEntities(text) {
        return trim(String(text || "")
            .replace(/&amp;/g, "&")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&#x2F;/gi, "/")
            .replace(/&#x3D;/gi, "="));
    }

    function makeAbsoluteFromBase(base, href) {
        if (!href) return "";
        if (/^https?:\/\//i.test(href)) return href;
        if (href.indexOf("//") === 0) return "https:" + href;
        if (href.charAt(0) === "/") return base + href;
        return base + "/" + href.replace(/^\.\//, "");
    }

    function collectCandidateUrls(text, base) {
        var results = [];
        var seen = {};
        var pattern = /https?:\/\/[^\s"'<>\\]+|(?:href|src)=["']([^"'#]+)["']|\\u002F\\u002F[^"'\\\s<]+/gi;
        var match;
        while ((match = pattern.exec(String(text || "")))) {
            var raw = match[1] || match[0] || "";
            raw = decodeHtmlEntities(raw)
                .replace(/\\\//g, "/")
                .replace(/^href=|^src=/, "")
                .replace(/^["']|["']$/g, "");
            if (raw.indexOf("\\u002F\\u002F") === 0) raw = "https://" + raw.slice(8);
            raw = makeAbsoluteFromBase(base || "", raw);
            if (!/^https?:\/\//i.test(raw)) continue;
            if (seen[raw]) continue;
            seen[raw] = true;
            results.push(raw);
        }
        return results;
    }

    function expandCompoundUrls(urls) {
        var out = [];
        for (var i = 0; i < (urls || []).length; i++) {
            var raw = String(urls[i] || "");
            if (!raw) continue;
            var matches = raw.match(/https?:\/\/[^\s"'<>`]+/gi);
            if (matches && matches.length > 1) {
                for (var j = 0; j < matches.length; j++) out.push(matches[j]);
                continue;
            }
            out.push(raw);
        }
        return out;
    }

    function parsePageTitleQuality(text) {
        var source = String(text || "");
        var titleMatch = source.match(/<title[^>]*>([\s\S]*?)<\/title>/i);
        var metaMatch = source.match(/<meta[^>]+(?:name|property)=["'](?:description|keywords|og:title|twitter:title)["'][^>]+content=["']([^"']+)["']/i);
        return getQuality((titleMatch && cleanHtmlText(titleMatch[1])) || (metaMatch && cleanHtmlText(metaMatch[1])) || source);
    }

    function extractM3u8Urls(text, base) {
        var urls = [];
        var seen = {};
        var patterns = [
            /data-hash="([^"]+\.m3u8[^"]*)"/gi,
            /https?:\/\/[^\s"'<>\\]+\.m3u8[^\s"'<>\\]*/gi,
            /["'](\/[^"'<>]+\.m3u8[^"'<>]*)["']/gi
        ];
        for (var i = 0; i < patterns.length; i++) {
            var match;
            while ((match = patterns[i].exec(String(text || "")))) {
                var raw = match[1] || match[0] || "";
                raw = raw.replace(/^["']|["']$/g, "");
                raw = makeAbsoluteFromBase(base || "", raw);
                if (!/^https?:\/\//i.test(raw) || seen[raw]) continue;
                seen[raw] = true;
                urls.push(raw);
            }
        }
        return urls;
    }

    function parseM3u8Variants(text, playlistUrl) {
        var lines = String(text || "").split(/\r?\n/);
        var variants = [];
        var pendingQuality = 0;
        for (var i = 0; i < lines.length; i++) {
            var line = trim(lines[i]);
            if (!line) continue;
            if (line.indexOf("#EXT-X-STREAM-INF:") === 0) {
                var resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
                var nameMatch = line.match(/NAME="?(\d{3,4})p"?/i);
                pendingQuality = resMatch ? parseInt(resMatch[1], 10) : (nameMatch ? parseInt(nameMatch[1], 10) : 0);
                continue;
            }
            if (line.charAt(0) === "#") continue;
            variants.push({
                url: toAbsoluteUrl(line, String(playlistUrl || "").replace(/\/[^\/?#]+(?:[?#].*)?$/, "")),
                quality: pendingQuality || getQuality(line)
            });
            pendingQuality = 0;
        }
        if (!variants.length && /\.m3u8(?:$|[?#])/i.test(String(playlistUrl || ""))) {
            variants.push({ url: playlistUrl, quality: getQuality(playlistUrl) });
        }
        return uniqueBy(variants, function (item) { return item.url; });
    }

    function buildSourceLabel(providerName, payload, quality) {
        var parts = [providerName];
        if (quality) parts.push(String(quality) + "p");
        return "[" + parts.join(" ") + "] " + cleanStreamLabel(payload.title || providerName);
    }

    function appendMinuteSuffix(url, suffix) {
        url = String(url || "");
        suffix = String(suffix || "");
        if (!url || !suffix) return url;
        if (/[?&]token=\d+$/i.test(url)) return url + suffix;
        return url;
    }

    function extractHubCloudFinalUrls(html, pageUrl) {
        html = String(html || "");
        pageUrl = String(pageUrl || "");
        var pageBase = pageUrl.split("/").slice(0, 3).join("/");
        var urls = [];
        var seen = {};
        var patterns = [
            /href=["'](https?:\/\/hub\.mayhem\.buzz\/[^"']+)["']/gi,
            /href=["'](https?:\/\/gpdl\.hubcdn\.fans\/[^"']+)["']/gi,
            /location\.href\s*=\s*["'](https?:\/\/(?:hub\.mayhem\.buzz|gpdl\.hubcdn\.fans)\/[^"']+)["']/gi,
            /window\.open\(\s*["'](https?:\/\/(?:hub\.mayhem\.buzz|gpdl\.hubcdn\.fans)\/[^"']+)["']/gi
        ];
        var minuteSuffix = "";
        if (/fsl\.href\s*\+=\s*['"]1['"]\s*\+\s*new\s+Date\(\)\.getMinutes\(\)/i.test(html)) {
            minuteSuffix = "1" + String(new Date().getMinutes());
        }
        for (var i = 0; i < patterns.length; i++) {
            var match;
            while ((match = patterns[i].exec(html))) {
                var candidate = decodeHtmlEntities(match[1] || "").replace(/\\\//g, "/");
                candidate = makeAbsoluteFromBase(pageBase, candidate);
                if (/hub\.mayhem\.buzz/i.test(candidate)) candidate = appendMinuteSuffix(candidate, minuteSuffix);
                if (!candidate || seen[candidate]) continue;
                seen[candidate] = true;
                urls.push(candidate);
            }
        }
        return urls;
    }

    function isResolvedFinalUrl(url, quality) {
        url = String(url || "");
        if (!url) return false;
        if (/\.m3u8(?:$|[?#])/i.test(url)) return true;
        if (/\.(mp4|mkv)(?:$|[?#])/i.test(url)) return true;
        if (/https?:\/\/hub\.mayhem\.buzz\//i.test(url)) return true;
        if (/https?:\/\/gpdl\.hubcdn\.fans\//i.test(url)) return true;
        return false;
    }

    function isLikelyStreamUrl(url) {
        return /\.(m3u8|mp4|mkv)(?:$|[?#])/i.test(url) ||
            /streamwish|filemoon|vidhide|lulustream|strmup|dood|streamtape|hubcloud|hubdrive|pixeldrain|workers\.dev|vidcloud|vidsrc|mixdrop|mp4upload|streamruby|turbovidhls|embedseek|bysewihe|filepress|vidara/i.test(url);
    }

    function interleaveLists(lists, limit) {
        var out = [];
        var max = 0;
        var i;
        for (i = 0; i < lists.length; i++) {
            if (lists[i].length > max) max = lists[i].length;
        }
        for (i = 0; i < max; i++) {
            for (var j = 0; j < lists.length; j++) {
                if (i < lists[j].length) out.push(lists[j][i]);
                if (limit && out.length >= limit) return out;
            }
        }
        return out;
    }

    function buildMetaPayload(meta, source) {
        return JSON.stringify({
            provider: "meta",
            source: source,
            id: meta.id,
            imdbId: meta.imdb_id || meta.id,
            tmdbId: meta.tmdb_id || meta.tmdbId || null,
            kitsuId: meta.kitsu_id || (String(meta.id || "").indexOf("kitsu:") === 0 ? String(meta.id).split(":")[1] : null),
            type: meta.type === "series" ? "series" : "movie",
            isAnime: source === "kitsu"
        });
    }

    function createMetaItem(meta, source) {
        return {
            title: meta.name || "Unknown",
            url: buildMetaPayload(meta, source),
            posterUrl: meta.poster || undefined,
            bannerUrl: meta.background || undefined,
            type: source === "kitsu" ? "anime" : (meta.type === "series" ? "series" : "movie"),
            description: trim(meta.description || ""),
            year: extractYear(meta.releaseInfo || meta.year),
            score: meta.imdbRating ? parseFloat(meta.imdbRating) : undefined,
            genres: meta.genres || meta.genre || []
        };
    }

    function buildCatalogSection(json, source, limit) {
        var metas = json && json.metas ? json.metas : [];
        var items = [];
        for (var i = 0; i < metas.length; i++) items.push(createMetaItem(metas[i], source));
        return uniqueBy(items, function (item) { return item.url; }).slice(0, limit || items.length);
    }

    function itemText(item) {
        return normalizeTitle([
            item && item.title,
            item && item.description,
            item && item.year
        ].join(" "));
    }

    function extractDirectLikeUrls(text, base) {
        return collectCandidateUrls(text, base).filter(isLikelyStreamUrl);
    }

    function filterUrlsByTitle(urls, payload) {
        var title = normalizeTitle(payload.title || "");
        var words = significantWords(payload.title || "");
        return urls.filter(function (url) {
            if (isLikelyStreamUrl(url)) return true;
            var hay = normalizeTitle(url);
            var score = wordOverlap(title, hay);
            for (var i = 0; i < words.length; i++) {
                if (hay.indexOf(words[i]) !== -1) score += 0.2;
            }
            if (payload.year && hay.indexOf(String(payload.year)) !== -1) score += 0.2;
            return score >= 0.2 || /\.(m3u8|mp4|mkv)(?:$|[?#])/i.test(url);
        });
    }

    function getHome(cb) {
        var jobs = {
            animeAiring: httpJson(HOME_CONFIG.animeAiring.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.animeAiring.source, HOME_CONFIG.animeAiring.limit);
            }),
            animeTrending: httpJson(HOME_CONFIG.animeTrending.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.animeTrending.source, HOME_CONFIG.animeTrending.limit);
            }),
            tamilMovies: httpJson(HOME_CONFIG.tamilMovies.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.tamilMovies.source, HOME_CONFIG.tamilMovies.limit);
            }),
            teluguMovies: httpJson(HOME_CONFIG.teluguMovies.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.teluguMovies.source, HOME_CONFIG.teluguMovies.limit);
            }),
            hindiMovies: httpJson(HOME_CONFIG.hindiMovies.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.hindiMovies.source, HOME_CONFIG.hindiMovies.limit);
            }),
            topMovies: httpJson(HOME_CONFIG.topMovies.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.topMovies.source, 60);
            }),
            topSeries: httpJson(HOME_CONFIG.topSeries.url).then(function (json) {
                return buildCatalogSection(json, HOME_CONFIG.topSeries.source, 60);
            })
        };

        Promise.allSettled([jobs.animeAiring, jobs.animeTrending, jobs.tamilMovies, jobs.teluguMovies, jobs.hindiMovies, jobs.topMovies, jobs.topSeries]).then(function (results) {
            var animeAiring = results[0].status === "fulfilled" ? results[0].value : [];
            var animeTrending = results[1].status === "fulfilled" ? results[1].value : [];
            var tamilMovies = results[2].status === "fulfilled" ? results[2].value : [];
            var teluguMovies = results[3].status === "fulfilled" ? results[3].value : [];
            var hindiMovies = results[4].status === "fulfilled" ? results[4].value : [];
            var topMovies = results[5].status === "fulfilled" ? results[5].value : [];
            var topSeries = results[6].status === "fulfilled" ? results[6].value : [];

            var homeData = {};
            if (animeAiring.length) homeData[HOME_CONFIG.animeAiring.key] = animeAiring;
            if (animeTrending.length) homeData[HOME_CONFIG.animeTrending.key] = animeTrending;
            if (tamilMovies.length) homeData[HOME_CONFIG.tamilMovies.key] = tamilMovies;
            if (teluguMovies.length) homeData[HOME_CONFIG.teluguMovies.key] = teluguMovies;
            if (hindiMovies.length) homeData[HOME_CONFIG.hindiMovies.key] = hindiMovies;
            if (topMovies.length) homeData[HOME_CONFIG.topMovies.key] = topMovies.slice(0, HOME_CONFIG.topMovies.limit);
            if (topSeries.length) homeData[HOME_CONFIG.topSeries.key] = topSeries.slice(0, HOME_CONFIG.topSeries.limit);

            if (!Object.keys(homeData).length) {
                return cb({ success: false, errorCode: "HOME_ERROR", message: "No homepage sections returned" });
            }
            cb({ success: true, data: homeData });
        }).catch(function (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        });
    }

    function search(query, cb) {
        var q = encodeURIComponent(trim(query));
        var jobs = [
            httpJson(CINEMETA_META + "/catalog/movie/top/search=" + q + ".json").then(function (json) {
                return buildCatalogSection(json, "cinemeta", 30);
            }),
            httpJson(CINEMETA_META + "/catalog/series/top/search=" + q + ".json").then(function (json) {
                return buildCatalogSection(json, "cinemeta", 30);
            }),
            httpJson(KITSU_BASE + "/catalog/anime/kitsu-anime-trending/search=" + q + ".json").then(function (json) {
                return buildCatalogSection(json, "kitsu", 30);
            })
        ];

        settled(jobs).then(function (results) {
            var lists = [];
            for (var i = 0; i < results.length; i++) if (results[i].ok) lists.push(results[i].value);
            var merged = uniqueBy(interleaveLists(lists, 60), function (item) { return item.url; });
            cb({ success: true, data: merged });
        }).catch(function (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        });
    }

    function buildDescription(meta) {
        var parts = [];
        var description = trim(meta.description || "");
        var cast = meta.cast && meta.cast.length ? meta.cast.slice(0, 6).join(", ") : "";
        var genres = meta.genres || meta.genre || [];
        if (description) parts.push(description);
        if (cast) parts.push("Cast: " + cast);
        if (genres.length) parts.push("Genres: " + genres.join(", "));
        return parts.join("\n\n");
    }

    function buildEpisodePayload(base, episode) {
        return JSON.stringify({
            provider: "meta",
            source: base.source,
            id: base.id,
            imdbId: base.imdbId,
            tmdbId: base.tmdbId || null,
            kitsuId: base.kitsuId || null,
            type: base.type,
            isAnime: !!base.isAnime,
            title: base.title,
            year: base.year,
            season: episode.season,
            episode: episode.episode
        });
    }

    function sortEpisodes(a, b) {
        if ((a.season || 0) !== (b.season || 0)) return (a.season || 0) - (b.season || 0);
        return (a.episode || 0) - (b.episode || 0);
    }

    function loadMetaItem(payload, cb) {
        var baseUrl = payload.source === "kitsu" ? KITSU_BASE : CINEMETA_META;
        var metaUrl = baseUrl + "/meta/" + payload.type + "/" + encodeURIComponent(payload.id) + ".json";

        httpJson(metaUrl).then(function (json) {
            var meta = json && json.meta ? json.meta : null;
            if (!meta) throw new Error("Metadata not found");

            var itemType = meta.type === "series" ? "series" : "movie";
            var baseData = {
                source: payload.source,
                id: payload.id,
                imdbId: meta.imdb_id || payload.imdbId || payload.id,
                tmdbId: meta.tmdb_id || meta.tmdbId || payload.tmdbId || null,
                kitsuId: payload.kitsuId || meta.kitsu_id || (String(meta.id || "").indexOf("kitsu:") === 0 ? String(meta.id).split(":")[1] : null),
                type: itemType,
                isAnime: payload.source === "kitsu",
                title: meta.name || "Unknown",
                year: extractYear(meta.releaseInfo || meta.year)
            };

            var item = {
                title: baseData.title,
                url: payload.raw,
                posterUrl: meta.poster || undefined,
                bannerUrl: meta.background || undefined,
                type: itemType,
                description: buildDescription(meta) || undefined,
                year: baseData.year,
                score: meta.imdbRating ? parseFloat(meta.imdbRating) : undefined,
                genres: meta.genres || meta.genre || []
            };

            if (itemType === "movie") {
                item.episodes = [new Episode({
                    name: item.title,
                    url: JSON.stringify({
                        provider: "meta",
                        source: baseData.source,
                        id: baseData.id,
                        imdbId: baseData.imdbId,
                        tmdbId: baseData.tmdbId,
                        kitsuId: baseData.kitsuId,
                        type: "movie",
                        isAnime: baseData.isAnime,
                        title: baseData.title,
                        year: baseData.year
                    })
                })];
                return cb({ success: true, data: new MultimediaItem(item) });
            }

            var videos = meta.videos || [];
            item.episodes = videos.filter(function (ep) {
                return ep && ep.season !== 0;
            }).sort(sortEpisodes).map(function (ep) {
                return new Episode({
                    name: trim(ep.name || ep.title || ("S" + ep.season + "E" + ep.episode)),
                    url: buildEpisodePayload(baseData, {
                        season: ep.season || ep.imdbSeason,
                        episode: ep.episode || ep.imdbEpisode
                    }),
                    season: ep.season || ep.imdbSeason,
                    episode: ep.episode || ep.imdbEpisode,
                    posterUrl: ep.thumbnail || undefined,
                    description: trim(ep.overview || ep.description || "")
                });
            });

            cb({ success: true, data: new MultimediaItem(item) });
        }).catch(function (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        });
    }

    function extractMagnets(html) {
        var entries = [];
        var seen = {};
        var re = /href="(magnet:[^"]+)"/gi;
        var match;
        while ((match = re.exec(html))) {
            var magnet = String(match[1] || "").replace(/&amp;/g, "&");
            if (!magnet || seen[magnet]) continue;
            seen[magnet] = true;
            var decoded = decodeURIComponent(magnet);
            entries.push({
                url: magnet,
                quality: getQuality(decoded),
                size: extractSize(decoded),
                title: decoded
            });
        }
        return entries;
    }

    function load(url, cb) {
        var payload = parseJsonSafe(url, null);
        if (!payload) return cb({ success: false, errorCode: "LOAD_ERROR", message: "Invalid payload: " + String(url || "").slice(0, 200) });
        payload.raw = url;

        return loadMetaItem(payload, cb);
    }

    function extractHeaderMap(stream) {
        var hints = stream && stream.behaviorHints ? stream.behaviorHints : {};
        var proxy = hints.proxyHeaders && hints.proxyHeaders.request ? hints.proxyHeaders.request : {};
        var headers = hints.headers || {};
        var out = {};
        if (proxy.userAgent || headers["User-Agent"] || headers["user-agent"]) {
            out["User-Agent"] = proxy.userAgent || headers["User-Agent"] || headers["user-agent"];
        }
        if (proxy.Referer || headers.Referer || headers.referer) {
            out.Referer = proxy.Referer || headers.Referer || headers.referer;
        }
        if (proxy.Origin || headers.Origin || headers.origin) {
            out.Origin = proxy.Origin || headers.Origin || headers.origin;
        }
        return out;
    }

    function cleanStreamLabel(text) {
        return trim(String(text || "").replace(/[\r\n]+/g, " ").replace(/[^\x20-\x7E]+/g, " "));
    }

    function pushStream(results, url, source, quality, headers) {
        if (!url) return;
        results.push(new StreamResult({
            url: url,
            quality: quality || 0,
            source: source,
            headers: headers || {}
        }));
    }

    function extractAniZipEpisodeId(mapping, episodeNumber) {
        var episodes = mapping && mapping.episodes ? mapping.episodes : {};
        var direct = episodes[String(episodeNumber)];
        if (direct && direct.anidbEid) return direct.anidbEid;
        for (var key in episodes) {
            if (!episodes.hasOwnProperty(key)) continue;
            var episode = episodes[key];
            if (!episode) continue;
            if (String(episode.episode) === String(episodeNumber) && episode.anidbEid) return episode.anidbEid;
        }
        return null;
    }

    function appendAnimeToshoStreams(payload, results) {
        if (!payload.isAnime || !payload.kitsuId) return Promise.resolve();
        return httpJson(ANIZIP + "/mappings?kitsu_id=" + encodeURIComponent(payload.kitsuId)).then(function (mapping) {
            var epId = extractAniZipEpisodeId(mapping, payload.episode || 1);
            if (!epId) return;
            return httpJson(ANIMETOSHO + "/json?eid=" + encodeURIComponent(epId)).then(function (items) {
                items = Array.isArray(items) ? items : [];
                items.filter(function (item) {
                    return item && item.magnet_uri && (item.seeders || 0) >= 10;
                }).sort(function (a, b) {
                    return (b.seeders || 0) - (a.seeders || 0);
                }).slice(0, 12).forEach(function (item) {
                    var title = cleanStreamLabel(item.title || "AnimeTosho");
                    var label = "[AnimeTosho] " + title;
                    if (item.total_size) label += " [" + formatBytes(parseInt(item.total_size, 10)) + "]";
                    pushStream(results, item.magnet_uri, label, getQuality(title), {});
                });
            });
        }).catch(function (e) {
            log("AnimeTosho failed:", e.message);
        });
    }

    function getHeaderValue(headers, name) {
        if (!headers) return "";
        var target = String(name || "").toLowerCase();
        for (var key in headers) {
            if (!headers.hasOwnProperty(key)) continue;
            if (String(key).toLowerCase() === target) return headers[key];
        }
        return "";
    }

    function flattenSetCookie(value) {
        if (!value) return "";
        if (Array.isArray(value)) return value.join("; ");
        return String(value);
    }

    function extractCookieValue(cookieHeader, name) {
        var escaped = String(name || "").replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
        var match = String(cookieHeader || "").match(new RegExp(escaped + "=([^;\\s,]+)", "i"));
        return match ? match[1] : "";
    }

    function extractFirstMatch(text, patterns) {
        var source = String(text || "");
        for (var i = 0; i < patterns.length; i++) {
            var match = source.match(patterns[i]);
            if (match && match[1]) return decodeHtmlEntities(match[1]).replace(/\\\//g, "/");
        }
        return "";
    }

    function extractAssignedQuotedValue(text, marker) {
        text = String(text || "");
        marker = String(marker || "");
        var index = text.indexOf(marker);
        if (index < 0) return "";
        var windowText = text.slice(index, index + 220);
        var tokenMatch = windowText.match(/[a-f0-9]{64}/i);
        return tokenMatch ? trim(tokenMatch[0]) : "";
    }

    function crawlPages(startUrls, base, headers, maxDepth) {
        var maxPages = 12;
        var maxQueue = 24;
        var queue = uniqueBy(startUrls || [], function (url) { return url; }).filter(function (url) {
            return /^https?:\/\//i.test(url);
        }).map(function (url) {
            return { url: url, depth: 0 };
        }).slice(0, maxQueue);
        var pageUrls = [];
        var streamUrls = [];
        var seenPages = {};
        var seenStreams = {};

        function pushStreamUrl(url) {
            if (!url || seenStreams[url]) return;
            seenStreams[url] = true;
            streamUrls.push(url);
        }

        function shouldFollow(url, depth) {
            if (!url || depth > maxDepth) return false;
            if (seenPages[url]) return false;
            if (isLikelyStreamUrl(url)) return false;
            return true;
        }

        function consume(html, currentUrl, depth) {
            var currentBase = String(currentUrl || "").split("/").slice(0, 3).join("/");
            var direct = extractDirectLikeUrls(html, currentBase);
            for (var i = 0; i < direct.length; i++) pushStreamUrl(direct[i]);

            var all = collectCandidateUrls(html, currentBase);
            var next = [];
            for (var j = 0; j < all.length; j++) {
                var candidate = all[j];
                if (isLikelyStreamUrl(candidate)) {
                    pushStreamUrl(candidate);
                } else if (shouldFollow(candidate, depth + 1)) {
                    next.push({ url: candidate, depth: depth + 1 });
                }
            }

            var jumpUrl = extractFirstMatch(html, [
                /<iframe[^>]+src=["']([^"']+)["']/i,
                /(?:window\.location|location\.href|location\.replace)\s*(?:=|\()\s*["']([^"']+)["']/i,
                /window\.open\(\s*["']([^"']+)["']/i
            ]);
            if (jumpUrl) {
                jumpUrl = makeAbsoluteFromBase(currentBase, jumpUrl);
                if (isLikelyStreamUrl(jumpUrl)) pushStreamUrl(jumpUrl);
                else if (shouldFollow(jumpUrl, depth + 1)) next.push({ url: jumpUrl, depth: depth + 1 });
            }

            return next;
        }

        function walk() {
            if (!queue.length || pageUrls.length >= maxPages) {
                return Promise.resolve({
                    streams: uniqueBy(streamUrls, function (url) { return url; }),
                    pages: uniqueBy(pageUrls, function (url) { return url; })
                });
            }

            var current = queue.shift();
            if (seenPages[current.url]) return walk();
            seenPages[current.url] = true;
            pageUrls.push(current.url);

            return httpText(current.url, headers).then(function (html) {
                var next = consume(html, current.url, current.depth);
                for (var i = 0; i < next.length && queue.length < maxQueue; i++) queue.push(next[i]);
            }).catch(function () {
                return null;
            }).then(walk);
        }

        return walk();
    }

    function resolveFinalStreamEntries(url, providerName, payload) {
        url = trim(url);
        if (!url) return Promise.resolve([]);

        if (/\.m3u8(?:$|[?#])/i.test(url)) {
            return httpText(url, {
                "User-Agent": "Mozilla/5.0",
                "Referer": String(url).split("/").slice(0, 3).join("/") + "/"
            }).then(function (playlist) {
                return parseM3u8Variants(playlist, url);
            }).catch(function () {
                return [{ url: url, quality: getQuality(url) }];
            });
        }

        if (/\.(mp4|mkv)(?:$|[?#])/i.test(url)) {
            return Promise.resolve([{ url: url, quality: getQuality(url) }]);
        }

        if (/vidhideplus\.com\/d\//i.test(url)) {
            return resolveFinalStreamEntries(url.replace("/d/", "/v/"), providerName, payload);
        }

        return httpText(url, {
            "User-Agent": "Mozilla/5.0",
            "Referer": String(url).split("/").slice(0, 3).join("/") + "/"
        }).then(function (html) {
            var pageQuality = parsePageTitleQuality(html);
            var m3u8s = extractM3u8Urls(html, String(url).split("/").slice(0, 3).join("/"));
            if (m3u8s.length) {
                return settled(m3u8s.map(function (m3u8) {
                    return resolveFinalStreamEntries(m3u8, providerName, payload);
                })).then(function (items) {
                    var resolved = [];
                    for (var i = 0; i < items.length; i++) {
                        if (items[i].ok) resolved = resolved.concat(items[i].value || []);
                    }
                    return resolved.length ? resolved : [{ url: url, quality: pageQuality }];
                });
            }

            if (/gamerxyt\.com\/hubcloud\.php/i.test(url)) {
                var generated = extractHubCloudFinalUrls(html, url).map(function (finalUrl) {
                    return { url: finalUrl, quality: pageQuality };
                });
                if (generated.length) return generated;
            }

            if (/hubcloud\.(foo|one)/i.test(url)) {
                var generator = extractFirstMatch(html, [
                    /href="(https:\/\/gamerxyt\.com\/hubcloud\.php[^"]+)"/i,
                    /var\s+url\s*=\s*'(https:\/\/gamerxyt\.com\/hubcloud\.php[^']+)'/i
                ]);
                if (generator) return resolveFinalStreamEntries(generator, providerName, payload);
            }

            return [{ url: url, quality: pageQuality }];
        }).catch(function () {
            return [{ url: url, quality: getQuality(url) }];
        });
    }

    function resolveAndPushUrls(results, urls, providerName, payload) {
        urls = filterUrlsByTitle(uniqueBy(expandCompoundUrls(urls), function (url) { return url; }), payload);
        return settled(urls.map(function (url) {
            return resolveFinalStreamEntries(url, providerName, payload);
        })).then(function (items) {
            var out = [];
            for (var i = 0; i < items.length; i++) {
                if (items[i].ok) out = out.concat(items[i].value || []);
            }
            out = out.filter(function (item) {
                return item && isResolvedFinalUrl(item.url, item.quality || 0);
            });
            out = uniqueBy(out, function (item) { return item.url; });
            for (var j = 0; j < out.length; j++) {
                var entry = out[j];
                pushStream(results, entry.url, buildSourceLabel(providerName, payload, entry.quality), entry.quality, {});
            }
        });
    }

    function pushNamedUrls(results, urls, providerName, payload) {
        return resolveAndPushUrls(results, urls, providerName, payload);
    }

    function appendRtallyStreams(payload, results) {
        if (!payload.title || payload.type !== "movie") return Promise.resolve();
        return httpText(RTALLY_BASE + "/post/" + encodeURIComponent(slugify(payload.title))).then(function (body) {
            var urls = extractDirectLikeUrls(body, RTALLY_BASE).concat(collectCandidateUrls(body, RTALLY_BASE));
            var sizedPattern = /\\"(small|medium|large|extraLarge)\\":\\"(https?:\/\/[^\\"]+)/gi;
            var servicePattern = /\\"(lulustream|strmup|filemoon|turbo|vidhide|doodStream|streamwish)Url\\":\\"?([^\\"]+)/gi;
            var match;
            while ((match = sizedPattern.exec(body || ""))) {
                urls.push(decodeHtmlEntities(match[2] || "").replace(/\\\//g, "/"));
            }
            while ((match = servicePattern.exec(body || ""))) {
                var service = String(match[1] || "").toLowerCase();
                var id = decodeHtmlEntities(match[2] || "").replace(/\\\//g, "/");
                if (!id || id === "null") continue;
                if (service === "vidhide") urls.push("https://vidhideplus.com/v/" + id);
                if (service === "lulustream") urls.push("https://lulustream.com/e/" + id);
                if (service === "filemoon") urls.push("https://filemoon.sx/e/" + id);
                if (service === "streamwish") urls.push("https://playerwish.com/e/" + id);
                if (service === "strmup") urls.push("https://strmup.cc/" + id);
                if (service === "turbo") urls.push("https://turboviplay.com/" + id);
                if (service === "doodstream") urls.push("https://dood.wf/d/" + id);
            }
            urls = urls.filter(function (url) {
                return !/rtally\.(xyz|shop|store|space)/i.test(url);
            });
            return pushNamedUrls(results, urls, "Rtally", payload);
        }).catch(function (e) {
            log("Rtally failed:", e.message);
        });
    }

    function appendMovies4uStreams(payload, results) {
        if (!payload.title) return Promise.resolve();
        var query = payload.type === "series" && payload.season
            ? payload.title.replace(/\s+/g, "+") + "+season+" + payload.season
            : payload.title.replace(/\s+/g, "+") + (payload.year ? "+" + payload.year : "");
        var headers = {
            "Cookie": "xla=s4t",
            "Referer": MOVIES4U_BASE + "/",
            "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36"
        };
        return httpText(MOVIES4U_BASE + "/?s=" + query, headers).then(function (searchBody) {
            var links = [];
            var re = /<article[\s\S]*?<h3[^>]*>\s*<a[^>]+href="([^"]+)"/gi;
            var match;
            while ((match = re.exec(searchBody || ""))) links.push(makeAbsoluteFromBase(MOVIES4U_BASE, match[1]));
            links = uniqueBy(links, function (url) { return url; }).slice(0, 8);
            return settled(links.map(function (url) {
                return httpText(url, headers).then(function (html) {
                    var seedUrls = [];
                    var innerPattern = /<div[^>]+download-links-div[\s\S]*?<a[^>]+href="([^"]+)"/gi;
                    var innerMatch;
                    while ((innerMatch = innerPattern.exec(html || ""))) {
                        seedUrls.push(makeAbsoluteFromBase(MOVIES4U_BASE, innerMatch[1]));
                    }
                    if (!seedUrls.length) seedUrls = collectCandidateUrls(html, MOVIES4U_BASE);
                    return crawlPages(seedUrls.slice(0, 10), MOVIES4U_BASE, headers, 3).then(function (crawl) {
                        return (crawl.streams || []).concat(crawl.pages || []);
                    });
                });
            })).then(function (pages) {
                var urls = [];
                for (var i = 0; i < pages.length; i++) {
                    if (pages[i].ok) urls = urls.concat(pages[i].value);
                }
                urls = urls.filter(function (url) {
                    return !/movies4u\.direct|m4ulinks\.com/i.test(url);
                });
                return pushNamedUrls(results, urls, "Movies4u", payload);
            });
        }).catch(function (e) {
            log("Movies4u failed:", e.message);
        });
    }

    function dedupeStreams(results) {
        return uniqueBy(results, function (item) { return item.url + "|" + item.source; });
    }

    function sortStreams(results) {
        return (results || []).slice().sort(function (left, right) {
            var qualityDelta = Number(right && right.quality || 0) - Number(left && left.quality || 0);
            if (qualityDelta) return qualityDelta;
            var sourceLeft = String(left && left.source || "");
            var sourceRight = String(right && right.source || "");
            if (sourceLeft < sourceRight) return -1;
            if (sourceLeft > sourceRight) return 1;
            var urlLeft = String(left && left.url || "");
            var urlRight = String(right && right.url || "");
            if (urlLeft < urlRight) return -1;
            if (urlLeft > urlRight) return 1;
            return 0;
        });
    }

    function loadStreams(url, cb) {
        var payload = parseJsonSafe(url, null);
        if (!payload) return cb({ success: false, errorCode: "STREAM_ERROR", message: "Invalid stream payload: " + String(url || "").slice(0, 200) });

        var results = [];

        var jobs = [
            withTimeout(appendAnimeToshoStreams(payload, results), 10000, "AnimeTosho"),
            withTimeout(appendMovies4uStreams(payload, results), 12000, "Movies4u"),
            withTimeout(appendRtallyStreams(payload, results), 8000, "Rtally")
        ];

        settled(jobs).then(function () {
            cb({ success: true, data: sortStreams(dedupeStreams(results)) });
        }).catch(function (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        });
    }

    async function gethome(query, cb) {
        if (typeof query === "function") return getHome(query);
        if (typeof cb === "function") return getHome(cb);
        return getHome(function () {});
    }

    async function loadstreams(url, cb) {
        return loadStreams(url || "", cb);
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
    globalThis.gethome = gethome;
    globalThis.loadstreams = loadstreams;

if (typeof module !== "undefined" && module.exports) {
    module.exports = {
        getHome: getHome,
        gethome: gethome,
        search: search,
        load: load,
        loadStreams: loadStreams,
        loadstreams: loadstreams
    };
}
})();
