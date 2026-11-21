(function () {
    "use strict";

    var BASE_URL = "https://animesky.app";
    var USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36";
    var ABYSS_DEC_API = "https://enc-dec.app/api/dec-abyss";

    var DEFAULT_HEADERS = {
        "User-Agent": USER_AGENT,
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
        "Referer": BASE_URL + "/"
    };

    // ========== Utilities ==========
    function trim(value) {
        return String(value == null ? "" : value).trim();
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
            .replace(/&#8217;/g, "'")
            .replace(/&nbsp;/g, " ")
            .replace(/\s+/g, " ")
            .trim();
    }

    function cleanTitle(raw) {
        var str = decodeHtml(raw);
        str = str.replace(/\s*-\s*Watch Now in.*$/i, "");
        str = str.replace(/\s*-\s*Anime Sky.*$/i, "");
        str = str.replace(/\s*Anime Sky.*$/i, "");
        str = str.replace(/\s*-\s*Movies Archive.*$/i, "");
        return str.trim();
    }

    function normalizeUrl(url, base) {
        url = trim(url);
        if (!url) return "";
        if (/^https?:\/\//i.test(url)) return url;
        if (url.indexOf("//") === 0) return "https:" + url;
        base = base || BASE_URL;
        if (url.charAt(0) === "/") return base.replace(/\/+$/, "") + url;
        return base.replace(/\/+$/, "") + "/" + url;
    }

    function safeJsonParse(str, fallback) {
        if (!str) return fallback;
        try {
            return JSON.parse(str);
        } catch (_) {
            return fallback;
        }
    }

    function safeAtob(str) {
        if (!str) return "";
        try {
            return atob(str);
        } catch (_) {
            try {
                if (typeof Buffer !== "undefined") {
                    return Buffer.from(str, "base64").toString("utf8");
                }
            } catch (_) {}
            return "";
        }
    }

    // ========== HTTP Helpers ==========
    async function fetchText(url, headers) {
        var reqHeaders = Object.assign({}, DEFAULT_HEADERS, headers || {});
        var res = await http_get(url, reqHeaders);
        return String((res && (res.body || res.text)) || "");
    }

    async function postForm(url, data, headers) {
        var reqHeaders = Object.assign({}, DEFAULT_HEADERS, {
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
        }, headers || {});
        var bodyStr = typeof data === "string" ? data : Object.keys(data || {}).map(function (k) {
            return encodeURIComponent(k) + "=" + encodeURIComponent(data[k]);
        }).join("&");
        var res = await http_post(url, reqHeaders, bodyStr);
        return String((res && (res.body || res.text)) || "");
    }

    async function postJson(url, payload, headers) {
        var reqHeaders = Object.assign({}, DEFAULT_HEADERS, {
            "Content-Type": "application/json",
            "Accept": "application/json"
        }, headers || {});
        var bodyStr = JSON.stringify(payload || {});
        var res = await http_post(url, reqHeaders, bodyStr);
        return String((res && (res.body || res.text)) || "");
    }

    // ========== Card & Item Parsers ==========
    function parseCardsFromHtml(html) {
        var items = [];
        var seen = {};

        // Match article elements for tr-movie-card or latest-ep-card
        var articleRegex = /<article\b[^>]*class=["']([^"']*(?:tr-movie-card|latest-ep-card)[^"']*)["'][^>]*>([\s\S]*?)<\/article>/gi;
        var match;

        while ((match = articleRegex.exec(html)) !== null) {
            var block = match[2];

            // Extract URL
            var linkMatch = block.match(/<a\b[^>]+href=["']([^"']+)["']/i);
            if (!linkMatch) continue;
            var url = normalizeUrl(linkMatch[1]);
            if (!url || seen[url]) continue;

            // Extract Title
            var titleMatch = block.match(/<(?:h[2-4]|span|div)\b[^>]*class=["'][^"']*(?:title|name)[^"']*["'][^>]*>([\s\S]*?)<\/(?:h[2-4]|span|div)>/i);
            var title = "";
            if (titleMatch) {
                title = cleanTitle(titleMatch[1]);
            }
            if (!title) {
                var altMatch = block.match(/<img\b[^>]+alt=["'](?:Image\s*)?([^"']+)["']/i);
                if (altMatch) title = cleanTitle(altMatch[1]);
            }
            if (!title) continue;

            // Extract Poster
            var posterMatch = block.match(/<img\b[^>]+(?:data-src|src)=["']([^"']+)["']/i);
            var posterUrl = "";
            if (posterMatch) {
                var candidate = posterMatch[1];
                if (!candidate.startsWith("data:")) {
                    posterUrl = normalizeUrl(candidate);
                } else {
                    var dataSrcMatch = block.match(/<img\b[^>]+data-src=["']([^"']+)["']/i);
                    if (dataSrcMatch) posterUrl = normalizeUrl(dataSrcMatch[1]);
                }
            }

            var isMovie = /\/movies\//i.test(url);
            var type = isMovie ? "movie" : "series";

            seen[url] = true;
            items.push(new MultimediaItem({
                title: title,
                url: url,
                posterUrl: posterUrl || undefined,
                type: type,
                headers: { "Referer": BASE_URL + "/" }
            }));
        }

        return items;
    }

    function extractSectionCards(html, sectionTitle) {
        var regex = new RegExp("<h[2-4][^>]*class=[\"'][^\"']*(?:tr-section-title|section-title)[^\"']*[\"'][^>]*>\\s*" + sectionTitle + "\\s*<\\/h[2-4]>([\\s\\S]*?)(?:<header\\b|<section\\b|$)", "i");
        var match = html.match(regex);
        if (match && match[1]) {
            return parseCardsFromHtml(match[1]);
        }
        return [];
    }

    // ========== getHome Implementation ==========
    async function getHome(cb) {
        try {
            var html = await fetchText(BASE_URL + "/");
            if (!html) {
                return cb({ success: false, errorCode: "NETWORK_ERROR", message: "Failed to load home page" });
            }

            var homeData = {};

            // 1. Fresh Drops (Latest releases)
            var freshDrops = extractSectionCards(html, "Fresh Drops");
            if (!freshDrops.length) {
                // Fallback to all latest-ep-card
                freshDrops = parseCardsFromHtml(html).slice(0, 20);
            }

            // 2. Most-Watched Series
            var mostWatchedSeries = extractSectionCards(html, "Most-Watched Series");

            // 3. Most-Watched Films
            var mostWatchedFilms = extractSectionCards(html, "Most-Watched Films");

            // 4. New Anime Arrivals
            var newArrivals = extractSectionCards(html, "New Anime Arrivals");

            // 5. Latest Anime Movies
            var latestMovies = extractSectionCards(html, "Latest Anime Movies");

            // Carousel / Trending: use Most-Watched Series or Fresh Drops
            var trending = mostWatchedSeries.length ? mostWatchedSeries.slice(0, 10) : freshDrops.slice(0, 10);
            if (trending.length) {
                homeData["Trending"] = trending;
            }

            if (freshDrops.length) homeData["Fresh Drops"] = freshDrops;
            if (mostWatchedSeries.length) homeData["Most-Watched Series"] = mostWatchedSeries;
            if (mostWatchedFilms.length) homeData["Most-Watched Films"] = mostWatchedFilms;
            if (newArrivals.length) homeData["New Anime Arrivals"] = newArrivals;
            if (latestMovies.length) homeData["Latest Anime Movies"] = latestMovies;

            // Fallback if sections were not split cleanly
            if (Object.keys(homeData).length === 0) {
                var allCards = parseCardsFromHtml(html);
                if (allCards.length) {
                    homeData["Trending"] = allCards.slice(0, 10);
                    homeData["Latest Releases"] = allCards.slice(10);
                }
            }

            cb({ success: true, data: homeData });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e && e.message || e) });
        }
    }

    // ========== search Implementation ==========
    async function search(query, cb) {
        try {
            var searchUrl = BASE_URL + "/?s=" + encodeURIComponent(query || "");
            var html = await fetchText(searchUrl);
            if (!html) {
                return cb({ success: false, errorCode: "SEARCH_ERROR", message: "Empty search response" });
            }

            var results = parseCardsFromHtml(html);
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e && e.message || e) });
        }
    }

    // ========== load Implementation ==========
    function parseEpisodesFromHtml(html, defaultSeason) {
        var episodes = [];
        var epRegex = /<li\b[^>]*class=["'][^"']*tr-episode-item[^"']*["'][^>]*>([\s\S]*?)<\/li>/gi;
        var match;

        while ((match = epRegex.exec(html)) !== null) {
            var block = match[1];

            // Extract episode link
            var linkMatch = block.match(/<a\b[^>]+href=["']([^"']+)["']/i);
            if (!linkMatch) continue;
            var epUrl = normalizeUrl(linkMatch[1]);

            // Extract episode title
            var titleMatch = block.match(/<(?:h[2-4]|span|div)\b[^>]*class=["'][^"']*tr-episode-title[^"']*["'][^>]*>([\s\S]*?)<\/(?:h[2-4]|span|div)>/i);
            var epName = titleMatch ? cleanTitle(titleMatch[1]) : "Episode";

            // Extract poster
            var posterMatch = block.match(/<img\b[^>]+(?:data-src|src)=["']([^"']+)["']/i);
            var epPoster = "";
            if (posterMatch && !posterMatch[1].startsWith("data:")) {
                epPoster = normalizeUrl(posterMatch[1]);
            }

            // Determine Season and Episode number
            var seasonNum = defaultSeason || 1;
            var epNum = 1;

            // Pattern like "2x3" or "1x12"
            var xMatch = epUrl.match(/[-_](\d+)x(\d+)(?:\/|$)/i) || epName.match(/(\d+)x(\d+)/i);
            if (xMatch) {
                seasonNum = parseInt(xMatch[1], 10) || seasonNum;
                epNum = parseInt(xMatch[2], 10) || epNum;
            } else {
                var numBadge = block.match(/class=["'][^"']*tr-episode-number[^"']*["'][^>]*>\s*(?:EP\s*)?(\d+)/i);
                if (numBadge) {
                    epNum = parseInt(numBadge[1], 10) || 1;
                }
            }

            episodes.push(new Episode({
                name: epName,
                url: epUrl,
                season: seasonNum,
                episode: epNum,
                posterUrl: epPoster || undefined,
                headers: { "Referer": BASE_URL + "/" }
            }));
        }

        return episodes;
    }

    async function load(url, cb) {
        try {
            var rawUrl = normalizeUrl(url);

            // If an episode URL is passed, resolve to its series URL
            var isEpisodeUrl = /\/episode\/([^/]+)/i.test(rawUrl);
            var targetUrl = rawUrl;
            if (isEpisodeUrl) {
                var epSlugMatch = rawUrl.match(/\/episode\/([a-z0-9-]+?)(?:-\d+x\d+)?\/?$/i);
                if (epSlugMatch && epSlugMatch[1]) {
                    targetUrl = BASE_URL + "/series/" + epSlugMatch[1] + "/";
                }
            }

            var html = await fetchText(targetUrl);
            if (!html && isEpisodeUrl) {
                // Fallback to fetching the episode url directly
                targetUrl = rawUrl;
                html = await fetchText(targetUrl);
            }

            if (!html) {
                return cb({ success: false, errorCode: "LOAD_ERROR", message: "Failed to load details page" });
            }

            // Determine if movie or series
            var isMovie = /\/movies\//i.test(targetUrl);

            // Title
            var titleMatch = html.match(/<meta\b[^>]+property=["']og:title["'][^>]+content=["']([^"']+)["']/i) ||
                             html.match(/<h1\b[^>]*>([\s\S]*?)<\/h1>/i);
            var title = titleMatch ? cleanTitle(titleMatch[1]) : "Anime";

            // Description
            var descMatch = html.match(/<div\b[^>]+id=["']overview-text["'][^>]*>([\s\S]*?)<\/div>/i) ||
                            html.match(/<meta\b[^>]+property=["']og:description["'][^>]+content=["']([^"']+)["']/i);
            var description = descMatch ? decodeHtml(descMatch[1].replace(/<[^>]+>/g, " ")) : "";

            // Poster
            var posterMatch = html.match(/<img\b[^>]+data-src=["']([^"']*tmdb\.org\/t\/p\/w(?:342|500)[^"']*)["']/i) ||
                              html.match(/<img\b[^>]+src=["']([^"']*tmdb\.org\/t\/p\/w(?:342|500)[^"']*)["']/i) ||
                              html.match(/<meta\b[^>]+property=["']og:image["'][^>]+content=["']([^"']+)["']/i);
            var posterUrl = posterMatch ? normalizeUrl(posterMatch[1]) : "";

            // Banner
            var bannerMatch = html.match(/<img\b[^>]+class=["'][^"']*TPostBg[^"']*["'][^>]+data-src=["']([^"']+)["']/i) ||
                              html.match(/<img\b[^>]+class=["'][^"']*TPostBg[^"']*["'][^>]+src=["']([^"']+)["']/i);
            var bannerUrl = bannerMatch ? normalizeUrl(bannerMatch[1]) : (posterUrl || "");

            var episodes = [];

            if (isMovie) {
                episodes.push(new Episode({
                    name: title || "Full Movie",
                    url: targetUrl,
                    season: 1,
                    episode: 1,
                    posterUrl: posterUrl || undefined,
                    headers: { "Referer": BASE_URL + "/" }
                }));
            } else {
                // Parse Season 1 episodes from page HTML
                episodes = parseEpisodesFromHtml(html, 1);

                // Check for multi-season buttons
                var seasonBtnRegex = /<a\b[^>]*class=["'][^"']*season-btn[^"']*["'][^>]*data-post=["'](\d+)["'][^>]*data-season=["'](\d+)["']/gi;
                var sMatch;
                var seasonsToFetch = [];
                var postId = null;

                while ((sMatch = seasonBtnRegex.exec(html)) !== null) {
                    postId = sMatch[1];
                    var sNum = parseInt(sMatch[2], 10);
                    if (sNum && sNum > 1 && seasonsToFetch.indexOf(sNum) === -1) {
                        seasonsToFetch.push(sNum);
                    }
                }

                // Fetch extra seasons via WordPress AJAX
                if (postId && seasonsToFetch.length > 0) {
                    var seasonFetches = seasonsToFetch.map(async function (season) {
                        try {
                            var ajaxUrl = BASE_URL + "/wp-admin/admin-ajax.php?action=action_select_season&season=" + encodeURIComponent(season) + "&post=" + encodeURIComponent(postId);
                            var ajaxHtml = await fetchText(ajaxUrl, {
                                "X-Requested-With": "XMLHttpRequest",
                                "Referer": targetUrl
                            });
                            if (ajaxHtml) {
                                return parseEpisodesFromHtml(ajaxHtml, season);
                            }
                        } catch (_) {}
                        return [];
                    });

                    var extraResults = await Promise.all(seasonFetches);
                    extraResults.forEach(function (extraEps) {
                        if (extraEps && extraEps.length) {
                            episodes = episodes.concat(extraEps);
                        }
                    });
                }

                // Fallback: If no episodes found on series page, provide current page as single episode
                if (!episodes.length) {
                    episodes.push(new Episode({
                        name: title,
                        url: targetUrl,
                        season: 1,
                        episode: 1,
                        posterUrl: posterUrl || undefined,
                        headers: { "Referer": BASE_URL + "/" }
                    }));
                }
            }

            var item = new MultimediaItem({
                title: title,
                url: targetUrl,
                posterUrl: posterUrl || undefined,
                bannerUrl: bannerUrl || undefined,
                description: description || undefined,
                type: isMovie ? "movie" : "series",
                episodes: episodes,
                headers: { "Referer": BASE_URL + "/" }
            });

            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e && e.message || e) });
        }
    }

    // ========== Stream Extractors ==========

    /**
     * Extracts direct master.m3u8 from Ravok.buzz video player
     */
    async function extractRavok(videoUrl) {
        var streams = [];
        try {
            var hashMatch = videoUrl.match(/\/video\/([a-zA-Z0-9]+)/i);
            if (!hashMatch) return streams;
            var hash = hashMatch[1];

            var apiUrl = "https://ravok.buzz/player/index.php?data=" + encodeURIComponent(hash) + "&do=getVideo";
            var postData = "hash=" + encodeURIComponent(hash) + "&r=" + encodeURIComponent(BASE_URL + "/");

            var respText = await postForm(apiUrl, postData, {
                "Referer": videoUrl,
                "Origin": "https://ravok.buzz",
                "X-Requested-With": "XMLHttpRequest"
            });

            var json = safeJsonParse(respText, null);
            if (json && (json.videoSource || json.securedLink)) {
                var streamUrl = json.videoSource || json.securedLink;

                var ravokHeaders = {
                    "Referer": videoUrl,
                    "Origin": "https://ravok.buzz",
                    "User-Agent": USER_AGENT
                };

                streams.push(new StreamResult({
                    url: streamUrl,
                    source: "Ravok [Multi-Audio HLS]",
                    quality: "Auto",
                    headers: ravokHeaders
                }));
            }
        } catch (e) {
            console.log("[ExtractRavok Error]", String(e && e.message || e));
        }
        return streams;
    }

    /**
     * Extracts direct MP4 streams from AbyssPlayer (abyssplayer.com) using dec-abyss API
     */
    async function extractAbyss(url, language) {
        var streams = [];
        try {
            var abyssHeaders = {
                "User-Agent": USER_AGENT,
                "Origin": "https://playhydrax.com",
                "Referer": "https://playhydrax.com/"
            };

            var pageHtml = await fetchText(url, abyssHeaders);
            if (!pageHtml) return streams;

            var match = pageHtml.match(/const\s+datas\s*=\s*"([^"]*)"/i);
            if (!match || !match[1]) return streams;

            var decResp = await postJson(ABYSS_DEC_API, { text: match[1] }, abyssHeaders);
            var decData = safeJsonParse(decResp, null);

            if (decData && decData.result && Array.isArray(decData.result.sources)) {
                decData.result.sources.forEach(function (source) {
                    if (source && (source.status === true || typeof source.status === "undefined")) {
                        var qual = source.type || "Auto";
                        var codec = source.codec ? " [" + String(source.codec).toUpperCase() + "]" : "";
                        var langLabel = language ? " [" + language + "]" : "";

                        streams.push(new StreamResult({
                            url: source.url,
                            source: "Abyss" + langLabel + codec,
                            quality: qual,
                            headers: abyssHeaders
                        }));
                    }
                });
            }
        } catch (e) {
            console.log("[ExtractAbyss Error]", String(e && e.message || e));
        }
        return streams;
    }

    // ========== loadStreams Implementation ==========
    async function loadStreams(url, cb) {
        try {
            var targetUrl = normalizeUrl(url);
            var html = await fetchText(targetUrl);
            if (!html) {
                return cb({ success: false, errorCode: "STREAM_ERROR", message: "Failed to load stream page" });
            }

            var streams = [];

            // 1. Check for Ravok iframe
            var ravokMatches = html.match(/https?:\/\/ravok\.buzz\/video\/[a-zA-Z0-9]+/gi) || [];
            var uniqueRavok = Array.from(new Set(ravokMatches));

            var ravokPromises = uniqueRavok.map(function (rvUrl) {
                return extractRavok(rvUrl);
            });

            // 2. Check for multi-language player (AbyssPlayer)
            var multiLangMatch = html.match(/as-cdn\/clone\/multi-lang-plyr\.php\?data=([a-zA-Z0-9%_+/=-]+)/i);
            var abyssPromises = [];

            if (multiLangMatch && multiLangMatch[1]) {
                var rawData = multiLangMatch[1];
                try {
                    rawData = decodeURIComponent(rawData);
                } catch (_) {}
                var decoded = safeAtob(rawData);
                var langList = safeJsonParse(decoded, []);

                if (Array.isArray(langList)) {
                    langList.forEach(function (item) {
                        if (item && item.link) {
                            var linkUrl = String(item.link).replace(/\\\//g, "/");
                            var langName = item.language || "Unknown";
                            abyssPromises.push(extractAbyss(linkUrl, langName));
                        }
                    });
                }
            } else {
                // Direct AbyssPlayer link check
                var directAbyss = html.match(/https?:\/\/(?:abyssplayer\.com|abyss\.to)\/[a-zA-Z0-9_-]+/gi) || [];
                var uniqueAbyss = Array.from(new Set(directAbyss));
                uniqueAbyss.forEach(function (abUrl) {
                    abyssPromises.push(extractAbyss(abUrl, "Default"));
                });
            }

            // Execute extractors concurrently
            var allPromises = ravokPromises.concat(abyssPromises);
            var extractedGroups = await Promise.all(allPromises);

            extractedGroups.forEach(function (group) {
                if (Array.isArray(group)) {
                    streams = streams.concat(group);
                }
            });

            // Fallback: check for any direct video files in the HTML
            if (!streams.length) {
                var directMedia = html.match(/https?:\/\/[^"'\s]+\.(?:m3u8|mp4)(?:\?[^"'\s]*)?/gi) || [];
                Array.from(new Set(directMedia)).forEach(function (mUrl) {
                    streams.push(new StreamResult({
                        url: mUrl,
                        source: "Direct Stream",
                        quality: "Auto",
                        headers: { "Referer": targetUrl }
                    }));
                });
            }

            // Deduplicate streams
            var seenUrls = {};
            var finalStreams = streams.filter(function (s) {
                if (!s || !s.url || seenUrls[s.url]) return false;
                seenUrls[s.url] = true;
                return true;
            });

            // Sort streams: 1080p -> 720p -> 480p -> 360p -> Auto
            finalStreams.sort(function (a, b) {
                var getRes = function (q) {
                    var m = String(q || "").match(/(\d+)p?/i);
                    return m ? parseInt(m[1], 10) : 0;
                };
                return getRes(b.quality) - getRes(a.quality);
            });

            if (!finalStreams.length) {
                return cb({ success: false, errorCode: "NO_STREAMS", message: "No playable streams found" });
            }

            cb({ success: true, data: finalStreams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e && e.message || e) });
        }
    }

    // Export to global scope
    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
