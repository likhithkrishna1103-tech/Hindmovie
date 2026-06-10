(function() {
    var BASE_URL = (typeof manifest !== "undefined" && manifest && manifest.baseUrl) || "https://anidb.app";

    var CATEGORIES = [
        [BASE_URL + "/browse?q=&type=&status=Currently+Airing&season=&year=&genres=&sort=order_favorite&page=", "Trending"],
        [BASE_URL + "/browse?type=TV&page=", "TV Series"],
        [BASE_URL + "/browse?type=Movie&page=", "Movies"],
        [BASE_URL + "/browse?type=ONA&page=", "ONA"],
        [BASE_URL + "/browse?type=OVA&page=", "OVA"],
        [BASE_URL + "/browse?type=Special&page=", "Specials"],
        [BASE_URL + "/browse?q=&type=&status=Finished+Airing&season=&year=&genres=&sort=order_favorite&page=", "Finished Airing"]
    ];

    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0";

    var HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/"
    };

    var API_HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "application/json, text/plain, */*",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/",
        "X-Requested-With": "XMLHttpRequest"
    };



    function stripHtml(str) {
        return String(str || "").replace(/<[^>]+>/g, "").trim();
    }

    async function get(url, extraHeaders) {
        try {
            var headers = Object.assign({}, HEADERS, extraHeaders || {});
            var res = await http_get(url, headers);
            if (!res) return { body: "" };
            return { body: res.body || res.text || "" };
        } catch (_) {
            return { body: "" };
        }
    }

    async function getApi(url, extraHeaders) {
        try {
            var headers = Object.assign({}, API_HEADERS, extraHeaders || {});
            if (url.includes("/api/frontend/episode/")) {
                var slug = "";
                if (url.includes("/api/frontend/episode/")) {
                    var match = url.match(/\/episode\/(\d+)\/languages/);
                    if (match) {
                        var episodeId = match[1];
                        var tempUrl = url.replace("/languages", "");
                        var slugMatch = tempUrl.match(/\/([^\/]+)$/);
                        if (slugMatch) {
                            slug = slugMatch[1];
                        }
                    }
                }
                if (slug) {
                    headers["Referer"] = BASE_URL + "/anime/" + slug;
                }
            }
            var res = await http_get(url, headers);
            if (!res) return { body: "" };
            return { body: res.body || res.text || "" };
        } catch (_) {
            return { body: "" };
        }
    }

    function extractCards(html) {
        var items = [];
        var cardRegex = /<a[^>]*class="[^"]*anime-card[^"]*"[^>]*>([\s\S]*?)<\/a>/g;
        var cardMatch;
        while ((cardMatch = cardRegex.exec(html)) !== null) {
            var fullCard = cardMatch[0];
            var cardHtml = cardMatch[1];
            var titleMatch = /title="([^"]*)"/.exec(fullCard);
            var hrefMatch = /href="([^"]*)"/.exec(fullCard);
            var imgMatch = /<img[^>]*src="([^"]*)"[^>]*>/.exec(cardHtml);
            var ratingMatch = /<span[^>]*class="[^"]*badge-gray[^"]*"[^>]*>\s*([\d.]+)\s*<\/span>/.exec(cardHtml);
            if (!hrefMatch) continue;
            var url = hrefMatch[1];
            if (url && url.indexOf("://") === -1) url = (url.charAt(0) === "/" ? BASE_URL : BASE_URL + "/") + url;
            items.push({
                title: titleMatch ? titleMatch[1].trim() : "Unknown",
                url: url,
                posterUrl: imgMatch ? imgMatch[1] : null,
                score: ratingMatch ? parseFloat(ratingMatch[1]) : null,
                type: "anime"
            });
        }
        return items;
    }

    function extractBannerAndLogo(html) {
        if (!html || typeof html !== 'string') return {};
        var bannerUrl = null;
        var logoUrl = null;
        var ogImgMatch = /<meta[^>]*property="og:image"[^>]*content="([^"]*)"[^>]*>/.exec(html);
        if (ogImgMatch) bannerUrl = ogImgMatch[1];
        if (!bannerUrl) {
            var bgMatch = /background-image:\s*url\(['"]?([^'")\s]+)['"]?\)/.exec(html);
            if (bgMatch) bannerUrl = bgMatch[1];
        }
        if (!bannerUrl) {
            var bannerImgMatch = /<div[^>]*class="[^"]*(?:hero|banner|cover)[^"]*"[^>]*>[\s\S]*?<img[^>]*src="([^"]*)"[^>]*>/.exec(html);
            if (bannerImgMatch) bannerUrl = bannerImgMatch[1];
        }
        var logoMatch = /<img[^>]*class="[^"]*logo[^"]*"[^>]*src="([^"]*)"[^>]*>/.exec(html);
        if (logoMatch) logoUrl = logoMatch[1];
        if (!logoUrl) {
            var altLogoMatch = /<img[^>]*alt="[^"]*logo[^"]*"[^>]*src="([^"]*)"[^>]*>/.exec(html);
            if (altLogoMatch) logoUrl = altLogoMatch[1];
        }
        return { bannerUrl: bannerUrl, logoUrl: logoUrl };
    }

    async function getHome(cb) {
        try {
            var data = {};
            var results = await Promise.all(CATEGORIES.map(async function(cat) {
                try {
                    var res = await get(cat[0] + "1");
                    var items = extractCards(res.body || "");
                    return {
                        name: cat[1],
                        items: items.map(function(item) {
                            return new MultimediaItem({
                                title: item.title,
                                url: item.url,
                                posterUrl: item.posterUrl,
                                score: item.score || undefined,
                                type: item.type,
                                headers: API_HEADERS
                            });
                        })
                    };
                } catch (_) {
                    return { name: cat[1], items: [] };
                }
            }));
            results.forEach(function(r) { data[r.name] = r.items; });

            if (data["Trending"] && data["Trending"].length > 0) {
                data["Trending"] = await Promise.all(data["Trending"].map(async function(item) {
                    try {
                        var res = await get(item.url);
                        var extras = extractBannerAndLogo(res.body || "");
                        if (extras.bannerUrl) item.bannerUrl = extras.bannerUrl;
                        if (extras.logoUrl) item.logoUrl = extras.logoUrl;
                    } catch (_) {}
                    return item;
                }));
            }

            cb({ success: true, data: data });
        } catch (e) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: e.stack });
        }
    }

    async function search(query, cb) {
        try {
            var res = await get(BASE_URL + "/browse?q=" + encodeURIComponent(query));
            var items = extractCards(res.body || "");
            var results = items.map(function(item) {
                return new MultimediaItem({
                    title: item.title,
                    url: item.url,
                    posterUrl: item.posterUrl,
                    score: item.score || undefined,
                    type: "anime",
                    headers: HEADERS
                });
            });
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.stack });
        }
    }

    async function load(url, cb) {
        try {
            var res = await get(url);
            var html = res.body || "";

            var slug = url.substring(url.lastIndexOf("/") + 1);
            var siteIdMatch = slug.match(/-(\d+)$/);
            var siteId = siteIdMatch ? parseInt(siteIdMatch[1]) : null;

            var titleMatch = /<h1[^>]*>([\s\S]*?)<\/h1>/.exec(html);
            var title = titleMatch ? stripHtml(titleMatch[1]) : "Unknown";

            var poster = null;
            var posterDivMatch = /<div[^>]*class="[^"]*flex-shrink-0[^"]*"[^>]*>[\s\S]*?<img[^>]*src="([^"]*)"[^>]*>/.exec(html);
            if (posterDivMatch) poster = posterDivMatch[1];
            if (!poster) {
                var ogImgMatch = /<meta[^>]*property="og:image"[^>]*content="([^"]*)"[^>]*>/.exec(html);
                if (ogImgMatch) poster = ogImgMatch[1];
            }

            var descMatch = /<meta[^>]*name="description"[^>]*content="([^"]*)"[^>]*>/.exec(html);
            var description = descMatch ? descMatch[1] : null;

            var tags = [];
            try {
                var tagRegex = /<a[^>]*class="[^"]*filter-chip[^"]*"[^>]*>([\s\S]*?)<\/a>/g;
                var tm;
                while ((tm = tagRegex.exec(html)) !== null) {
                    tags.push(stripHtml(tm[1]));
                }
            } catch (_) {}

            var year = null;
            var yearMatch = /<a[^>]*href="[^"]*&year=(\d{4})"[^>]*>/.exec(html);
            if (yearMatch) year = parseInt(yearMatch[1]);

            var rating = null;
            var ratingMatch = /<span[^>]*class="[^"]*badge-gray[^"]*"[^>]*>\s*([\d.]+)\s*<\/span>/.exec(html);
            if (ratingMatch) rating = parseFloat(ratingMatch[1]);

            var status = null;
            var statusMatch = /<a[^>]*class="[^"]*badge[^"]*"[^>]*href="[^"]*\/browse\?status=([^"]*)"[^>]*>([\s\S]*?)<\/a>/.exec(html);
            if (statusMatch) {
                var st = statusMatch[2].trim();
                if (st.indexOf("Currently Airing") !== -1) status = "ongoing";
                else if (st.indexOf("Finished Airing") !== -1) status = "completed";
                else status = "upcoming";
            }

            var duration = null;
            try {
                var durDivMatch = /<div[^>]*class="[^"]*flex\s+flex-wrap\s+gap-x-6[^"]*"[^>]*>([\s\S]*?)<\/div>/.exec(html);
                if (durDivMatch) {
                    var durSpanMatch = /<span[^>]*>([\s\S]*?)<\/span>/.exec(durDivMatch[1]);
                    if (durSpanMatch) {
                        var durText = durSpanMatch[1].trim();
                        if (durText.indexOf("h") !== -1 && durText.indexOf("m") !== -1) {
                            var h = parseInt(durText.split("h")[0]) || 0;
                            var m = parseInt(durText.split("h")[1].replace("m", "").trim()) || 0;
                            duration = h * 60 + m;
                        } else if (durText.indexOf("h") !== -1) {
                            duration = (parseInt(durText) || 0) * 60;
                        } else {
                            duration = parseInt(durText) || null;
                        }
                    }
                }
            } catch (_) {}

            var isMovie = /<a[^>]*class="[^"]*badge-orange[^"]*"[^>]*href="[^"]*\/browse\?type=Movie[^"]*"[^>]*>/.test(html);

            var malIdMatch = /<a[^>]*href="https:\/\/myanimelist\.net\/anime\/(\d+)"[^>]*>/.exec(html);
            var malId = malIdMatch ? parseInt(malIdMatch[1]) : null;

            var anilistIdMatch = /<a[^>]*href="https:\/\/anilist\.co\/anime\/(\d+)"[^>]*>/.exec(html);
            var anilistId = anilistIdMatch ? parseInt(anilistIdMatch[1]) : null;

            var trailerMatch = /<a[^>]*href="(https:\/\/www\.youtube\.com\/watch\?v=[^"]*)"[^>]*>/.exec(html);
            var trailerUrl = trailerMatch ? trailerMatch[1] : null;

            var episodesList = [];
            var hasSub = true;
            var hasDub = false;

            if (siteId) {
                try {
                    var epRes = await getApi(BASE_URL + "/api/frontend/anime/" + siteId + "/episodes");
                    var epText = epRes.body || "";
                    try {
                        var epData = JSON.parse(epText);
                        episodesList = epData.episodes || [];
                    } catch (_) {}

                    if (episodesList.length > 0) {
                        var firstEpId = episodesList[0].id;
                        var langRes = await getApi(BASE_URL + "/api/frontend/episode/" + firstEpId + "/languages");
                        var langText = langRes.body || "";
                        try {
                            var langData = JSON.parse(langText);
                            var langs = langData.languages || [];
                            hasSub = langs.length === 0 || langs.some(function(l) {
                                var c = (l.code || "").toLowerCase();
                                var n = (l.name || "").toLowerCase();
                                return ["jpn", "ja", "japanese"].indexOf(c) !== -1 || ["jpn", "ja", "japanese"].indexOf(n) !== -1;
                            });
                            hasDub = langs.some(function(l) {
                                var c = (l.code || "").toLowerCase();
                                var n = (l.name || "").toLowerCase();
                                return ["eng", "en", "english"].indexOf(c) !== -1 || ["eng", "en", "english"].indexOf(n) !== -1;
                            });
                        } catch (_) {}
                    }
                } catch (_) {}
            }

            var aniZipData = null;
            if (anilistId || malId) {
                try {
                    var qp = anilistId ? "anilist_id=" + anilistId : "mal_id=" + malId;
                    var azRes = await get("https://api.ani.zip/mappings?" + qp);
                    var azText = azRes.body || "";
                    try {
                        aniZipData = JSON.parse(azText);
                    } catch (_) {}
                } catch (_) {}
            }

            var episodes = [];

            for (var i = 0; i < episodesList.length; i++) {
                var ep = episodesList[i];
                var num = i + 1;
                var key = ep.number ? ep.number.toString() : num.toString();
                var metaEp = aniZipData && aniZipData.episodes ? aniZipData.episodes[key] : null;

                var epTitle = metaEp && metaEp.title
                    ? (metaEp.title.en || metaEp.title["x-jat"] || metaEp.title.ja || "Episode " + num)
                    : "Episode " + num;
                var epRating = metaEp && metaEp.rating ? parseFloat(metaEp.rating) : undefined;

                var epBase = {
                    name: epTitle,
                    season: 1,
                    episode: num,
                    rating: epRating,
                    runtime: metaEp ? (metaEp.runtime || metaEp.length) : undefined,
                    airDate: metaEp ? (metaEp.airDateUtc || metaEp.airdate) : undefined,
                    posterUrl: metaEp ? metaEp.image : undefined,
                    description: metaEp ? metaEp.overview : undefined
                };

                if (isMovie) {
                    episodes.push(new Episode(Object.assign({}, epBase, {
                        url: ep.id + "|" + slug + "|movie",
                        dubStatus: "sub"
                    })));
                } else {
                    episodes.push(new Episode(Object.assign({}, epBase, {
                        url: ep.id + "|" + slug + "|sub",
                        dubStatus: "sub"
                    })));
                    if (hasDub) {
                        episodes.push(new Episode(Object.assign({}, epBase, {
                            url: ep.id + "|" + slug + "|dub",
                            dubStatus: "dub"
                        })));
                    }
                }
            }

            var syncData = {};
            if (malId) syncData.mal_id = malId.toString();
            if (anilistId) syncData.anilist_id = anilistId.toString();

            var extras = extractBannerAndLogo(html);

            var item = new MultimediaItem({
                title: title,
                url: url,
                posterUrl: poster,
                type: isMovie ? "movie" : "anime",
                bannerUrl: extras.bannerUrl || undefined,
                logoUrl: extras.logoUrl || undefined,
                description: description,
                year: year,
                score: rating || undefined,
                duration: duration,
                status: status || undefined,
                tags: tags.length > 0 ? tags : undefined,
                trailers: trailerUrl ? [new Trailer({ name: "Official Trailer", url: trailerUrl })] : undefined,
                syncData: Object.keys(syncData).length > 0 ? syncData : undefined,
                episodes: episodes
            });

            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.stack });
        }
    }

    function resolveUrl(base, relative) {
        if (!relative) return base;
        if (/^https?:\/\//i.test(relative)) return relative;
        if (relative.indexOf("://") > 0) return relative;
        if (relative.charAt(0) === "/") {
            var baseParts = /^(https?:\/\/[^\/]+)/i.exec(base);
            return baseParts ? baseParts[1] + relative : relative;
        }
        var idx = base.lastIndexOf("/");
        return base.substring(0, idx + 1) + relative;
    }

    function parseHlsAttrs(str) {
        var attrs = {};
        var ph = [];
        var s = str.replace(/"([^"]*)"/g, function(_, v) { ph.push(v); return "\x00" + (ph.length - 1) + "\x00"; });
        var parts = s.split(",");
        for (var i = 0; i < parts.length; i++) {
            var eq = parts[i].indexOf("=");
            if (eq < 0) continue;
            var key = parts[i].substring(0, eq).trim();
            var val = parts[i].substring(eq + 1).trim();
            var pm = val.match(/\x00(\d+)\x00/);
            if (pm) val = ph[parseInt(pm[1], 10)];
            attrs[key] = val;
        }
        return attrs;
    }

    function parseHlsMasterPlaylist(text, baseUri) {
        var result = { variants: [], audios: [], subtitles: [], iframeStreams: [] };
        var m;

        var mediaRe = /#EXT-X-MEDIA\s*:\s*([^\r\n]+)/gi;
        while ((m = mediaRe.exec(text)) !== null) {
            var attrs = parseHlsAttrs(m[1]);
            var type = (attrs.TYPE || "").toUpperCase();
            var rendition = {
                type: type, groupId: attrs["GROUP-ID"] || null,
                name: attrs.NAME || null, language: attrs.LANGUAGE || null,
                uri: attrs.URI ? resolveUrl(baseUri, attrs.URI) : null,
                default: (attrs.DEFAULT || "").toUpperCase() === "YES",
                autoSelect: (attrs.AUTOSELECT || "").toUpperCase() === "YES",
                forced: (attrs.FORCED || "").toUpperCase() === "YES",
                channels: attrs.CHANNELS ? parseInt(attrs.CHANNELS, 10) : null
            };
            if (type === "AUDIO") result.audios.push(rendition);
            else if (type === "SUBTITLES") result.subtitles.push(rendition);
        }

        var streamRe = /#EXT-X-STREAM-INF\s*:\s*([^\r\n]*)\s*[\r\n]+\s*([^\r\n]+)/gi;
        while ((m = streamRe.exec(text)) !== null) {
            var attrs = parseHlsAttrs(m[1].trim());
            var url = resolveUrl(baseUri, m[2].trim());
            var resolution = null;
            if (attrs.RESOLUTION) {
                var rParts = attrs.RESOLUTION.split("x");
                if (rParts.length === 2) resolution = { width: parseInt(rParts[0], 10), height: parseInt(rParts[1], 10) };
            }
            result.variants.push({
                url: url, bandwidth: attrs.BANDWIDTH ? parseInt(attrs.BANDWIDTH, 10) : null,
                resolution: resolution, codecs: attrs.CODECS || null,
                frameRate: attrs["FRAME-RATE"] ? parseFloat(attrs["FRAME-RATE"]) : null,
                audioGroupId: attrs.AUDIO || null, videoGroupId: attrs.VIDEO || null,
                subtitleGroupId: attrs.SUBTITLES || null
            });
        }

        var iframeRe = /#EXT-X-I-FRAME-STREAM-INF\s*:\s*([^\r\n]+)/gi;
        while ((m = iframeRe.exec(text)) !== null) {
            var attrs = parseHlsAttrs(m[1]);
            var iframeUrl = resolveUrl(baseUri, attrs.URI || "");
            var iframeRes = null;
            if (attrs.RESOLUTION) {
                var rParts = attrs.RESOLUTION.split("x");
                if (rParts.length === 2) iframeRes = { width: parseInt(rParts[0], 10), height: parseInt(rParts[1], 10) };
            }
            result.iframeStreams.push({
                url: iframeUrl, bandwidth: attrs.BANDWIDTH ? parseInt(attrs.BANDWIDTH, 10) : null,
                resolution: iframeRes, codecs: attrs.CODECS || null
            });
        }

        return result;
    }

    function getStreamHeight(variant) {
        if (variant.resolution) return variant.resolution.height;
        if (variant.bandwidth) {
            if (variant.bandwidth >= 4000000) return 1080;
            if (variant.bandwidth >= 2000000) return 720;
            if (variant.bandwidth >= 1000000) return 480;
            if (variant.bandwidth >= 500000) return 360;
            return 240;
        }
        return 0;
    }

    async function loadStreams(url, cb) {
        try {
            var parts = url.split("|");
            var episodeIdRaw = parts[0];
            var episodeId = episodeIdRaw.indexOf("/") !== -1 ? episodeIdRaw.substring(episodeIdRaw.lastIndexOf("/") + 1) : episodeIdRaw;
            var slug = parts[1] || "";
            var audio = parts[2] || "sub";

            var langs = [];
            try {
                var langRes = await getApi(BASE_URL + "/api/frontend/episode/" + episodeId + "/languages", { "Referer": BASE_URL + "/anime/" + slug });
                var langData = JSON.parse(langRes.body || "{}");
                langs = langData.languages || [];
            } catch (_) {}

            if (langs.length === 0) {
                return cb({ success: true, data: [] });
            }

            var langsToExtract = audio === "movie"
                ? langs
                : (function() {
                    var preferredCodes = audio === "sub"
                        ? ["jpn", "ja", "japanese"]
                        : ["eng", "en", "english"];
                    for (var i = 0; i < langs.length; i++) {
                        var l = langs[i];
                        var c = (l.code || "").toLowerCase();
                        var n = (l.name || "").toLowerCase();
                        if (preferredCodes.indexOf(c) !== -1 || preferredCodes.indexOf(n) !== -1) {
                            return [l];
                        }
                    }
                    return langs.length > 0 ? [langs[0]] : [];
                })();

            var hlsRegexes = [
                /file\s*:\s*["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/gi,
                /sources\s*:\s*\[\s*\{[\s\S]*?file\s*:\s*["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/gi,
                /["'](https?:\/\/[^"']+\/master\.m3u8[^"']*)["']/gi,
                /["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/gi
            ];

            var streams = [];

            for (var j = 0; j < langsToExtract.length; j++) {
                var language = langsToExtract[j];
                if (!language.embed_url) continue;
                try {
                    var embedRes = await get(language.embed_url, { "Referer": BASE_URL + "/" });
                    var embedHtml = embedRes.body || "";

                    var hlsUrl = null;
                    for (var k = 0; k < hlsRegexes.length; k++) {
                        hlsRegexes[k].lastIndex = 0;
                        var m = hlsRegexes[k].exec(embedHtml);
                        if (m) {
                            hlsUrl = m[1];
                            break;
                        }
                    }

                    if (hlsUrl) {
                        var parsedVariants = false;
                        try {
                            var m3u8Res = await get(hlsUrl);
                            var m3u8Body = m3u8Res.body || "";
                            if (/#EXT-X-STREAM-INF:/i.test(m3u8Body)) {
                                var masterP = parseHlsMasterPlaylist(m3u8Body, hlsUrl);
                                if (masterP.variants.length > 0) {
                                    parsedVariants = true;
                                    for (var v = 0; v < masterP.variants.length; v++) {
                                        var variant = masterP.variants[v];
                                        var q = getStreamHeight(variant);
                                        var stream = new StreamResult({
                                            url: variant.url,
                                            source: (audio === "movie" ? "AniDB - " + (language.name || "Unknown") : "AniDB") + (q ? " " + q + "p" : ""),
                                            headers: { "Referer": BASE_URL + "/" }
                                        });
                                        stream.quality = q || undefined;
                                        if (variant.audioGroupId) {
                                            var matchedAudio = [];
                                            for (var a = 0; a < masterP.audios.length; a++) {
                                                if (masterP.audios[a].groupId === variant.audioGroupId) matchedAudio.push(masterP.audios[a]);
                                            }
                                            stream.audioGroup = variant.audioGroupId;
                                            stream.audioTracks = matchedAudio;
                                        }
                                        streams.push(stream);
                                    }
                                }
                            }
                        } catch (_) {}
                        if (!parsedVariants) {
                            streams.push(new StreamResult({
                                url: hlsUrl,
                                quality: "auto",
                                source: audio === "movie" ? "AniDB - " + (language.name || "Unknown") : "AniDB",
                                headers: { "Referer": BASE_URL + "/" }
                            }));
                        }
                    } else {
                        if (typeof globalThis.loadExtractor === "function") {
                            try {
                                await globalThis.loadExtractor(language.embed_url, function(stream) {
                                    streams.push(stream);
                                });
                            } catch (_) {}
                        }
                    }
                } catch (_) {}
            }

            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.stack });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
