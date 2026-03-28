(function () {
    // ============================================================
    // 5MovieRulz Plugin — ES5 Compatible
    // No async/await, no arrow functions, no template literals,
    // no for..of, no destructuring, no optional chaining
    // ============================================================

    var DEBUG = true;
    function log() {
        if (!DEBUG) return;
        var args = Array.prototype.slice.call(arguments);
        args.unshift("[MRZ]");
        console.log.apply(console, args);
    }
    function warn() {
        if (!DEBUG) return;
        var args = Array.prototype.slice.call(arguments);
        args.unshift("[MRZ WARN]");
        console.warn.apply(console, args);
    }
    function err() {
        var args = Array.prototype.slice.call(arguments);
        args.unshift("[MRZ ERR]");
        console.error.apply(console, args);
    }

    var FALLBACK_DOMAINS = [
        "https://www.5movierulz.army",
        "https://www.5movierulz.skin",
        "https://www.5movierulz.mobi",
        "https://www.5movierulz.com",
        "https://www.5movierulz.haus",
        "https://www.5movierulz.net",
        "https://www.5movierulz.tel",
        "https://www.5movierulz.show"
    ];
    var DOMAINS_URL = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/domains.json";

    // Bing search URLs — tried in order if all other methods fail
    var BING_SEARCH_URLS = [
        "https://www.bing.com/search?q=5movierulz+watch+movies+online+free&count=10",
        "https://www.bing.com/search?q=5movierulz+telugu+hindi+movies+download&count=10",
        "https://www.bing.com/search?q=site%3A5movierulz+movies&count=10"
    ];

    // A response from the real site always contains this string
    var SITE_FINGERPRINT = "movie-watch-online-free";

    // Pattern that a 5movierulz domain must match
    var DOMAIN_PATTERN = /https?:\/\/(?:www\.)?5movierulz\.\w{2,10}/i;

    var cachedMainUrl = null;

    // ============================================================
    // DOMAIN DISCOVERY — 4 level waterfall:
    //   1. cachedMainUrl (memory)
    //   2. domains.json  (GitHub)
    //   3. Known TLD fallback list
    //   4. Bing search   (last resort — scrapes top results)
    // ============================================================
    function getMainUrl() {
        if (cachedMainUrl) return Promise.resolve(cachedMainUrl);

        // Level 1 & 2: domains.json
        return http_get(DOMAINS_URL).then(function (res) {
            var data = JSON.parse(res.body);
            var c = data["5movierulz"] || data["movierulz"] || null;
            if (c) {
                return testDomain(c).then(function (ok) {
                    if (ok) { cachedMainUrl = c; return c; }
                    return tryFallbacks(0);
                });
            }
            return tryFallbacks(0);
        }).catch(function () {
            return tryFallbacks(0);
        });
    }

    // Level 3: try each known TLD one by one
    function tryFallbacks(i) {
        if (i >= FALLBACK_DOMAINS.length) {
            log("All fallbacks failed — trying Bing search discovery");
            return tryBingSearch(0);
        }
        log("Trying fallback: " + FALLBACK_DOMAINS[i]);
        return testDomain(FALLBACK_DOMAINS[i]).then(function (ok) {
            if (ok) {
                cachedMainUrl = FALLBACK_DOMAINS[i];
                log("Fallback OK: " + cachedMainUrl);
                return cachedMainUrl;
            }
            return tryFallbacks(i + 1);
        }).catch(function () {
            return tryFallbacks(i + 1);
        });
    }

    // Level 4: Bing search — try each search query until we find candidates
    function tryBingSearch(i) {
        if (i >= BING_SEARCH_URLS.length) {
            // Absolute last resort — return first fallback and hope for the best
            warn("Bing search exhausted — using first fallback as last resort");
            cachedMainUrl = FALLBACK_DOMAINS[0];
            return Promise.resolve(cachedMainUrl);
        }
        log("Bing search attempt " + (i + 1) + ": " + BING_SEARCH_URLS[i]);
        return http_get(BING_SEARCH_URLS[i]).then(function (res) {
            var candidates = extractDomainCandidates(res.body);
            log("Bing returned " + candidates.length + " candidates: " + candidates.join(", "));
            if (candidates.length === 0) return tryBingSearch(i + 1);
            return tryBingCandidates(candidates, 0, i);
        }).catch(function (e) {
            err("Bing search failed:", e.message);
            return tryBingSearch(i + 1);
        });
    }

    // Test each Bing candidate domain
    function tryBingCandidates(candidates, i, searchIdx) {
        if (i >= candidates.length) {
            // This search query's candidates all failed — try next search query
            return tryBingSearch(searchIdx + 1);
        }
        var candidate = candidates[i];
        log("Testing Bing candidate: " + candidate);
        return testDomain(candidate).then(function (ok) {
            if (ok) {
                cachedMainUrl = candidate;
                log("Bing discovery success: " + cachedMainUrl);
                return cachedMainUrl;
            }
            return tryBingCandidates(candidates, i + 1, searchIdx);
        }).catch(function () {
            return tryBingCandidates(candidates, i + 1, searchIdx);
        });
    }

    // Extract all 5movierulz domain candidates from a Bing results page
    // Bing wraps result links in: <a href="https://www.5movierulz.xxx/...">
    // Also checks <cite> tags which show the domain cleanly
    function extractDomainCandidates(html) {
        var found   = [];
        var seen    = {};
        var pos     = 0;

        // Strategy 1: scan all href= values for matching domains
        while (true) {
            var hIdx = html.indexOf('href="', pos);
            if (hIdx === -1) break;
            var hStart = hIdx + 6;
            var hEnd   = html.indexOf('"', hStart);
            if (hEnd === -1) break;
            var href = html.substring(hStart, hEnd);
            var match = href.match(DOMAIN_PATTERN);
            if (match) {
                // Extract just the origin (scheme + host)
                var origin = extractOrigin(href);
                if (origin && !seen[origin]) {
                    seen[origin] = true;
                    found.push(origin);
                }
            }
            pos = hEnd + 1;
        }

        // Strategy 2: Bing <cite> tags contain clean domain text
        pos = 0;
        while (true) {
            var cIdx = html.indexOf("<cite", pos);
            if (cIdx === -1) break;
            var cClose = html.indexOf(">", cIdx);
            var cEnd   = html.indexOf("</cite>", cClose);
            if (cClose === -1 || cEnd === -1) break;
            var citeText = stripTags(html.substring(cClose + 1, cEnd)).trim();
            // citeText might be "www.5movierulz.army › movies" etc.
            var cMatch = citeText.match(DOMAIN_PATTERN);
            if (cMatch) {
                var origin = extractOrigin(cMatch[0]);
                if (origin && !seen[origin]) {
                    seen[origin] = true;
                    found.push(origin);
                }
            }
            pos = cEnd + 7;
        }

        return found;
    }

    // Get "https://www.5movierulz.army" from a full URL
    function extractOrigin(url) {
        if (!url) return null;
        var m = url.match(/^(https?:\/\/[^\/]+)/);
        return m ? m[1] : null;
    }

    // Test a domain by fetching its homepage and checking for site fingerprint
    // Returns Promise<boolean>
    function testDomain(domain) {
        return http_get(domain + "/").then(function (res) {
            var ok = res.body && res.body.indexOf(SITE_FINGERPRINT) !== -1;
            log("testDomain " + domain + " -> " + (ok ? "OK" : "FAIL (wrong content)"));
            return ok;
        }).catch(function (e) {
            log("testDomain " + domain + " -> FAIL (" + e.message + ")");
            return false;
        });
    }

    function stripTags(s) {
        if (!s) return "";
        return s
            .replace(/<script[\s\S]*?<\/script>/gi, "")
            .replace(/<style[\s\S]*?<\/style>/gi, "")
            .replace(/<[^>]+>/g, "")
            .replace(/&amp;/g, "&")
            .replace(/&nbsp;/g, " ")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#\d+;/g, "")
            .replace(/\s+/g, " ")
            .trim();
    }

    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.indexOf("http") === 0) return href;
        if (href.indexOf("/") === 0) return base.replace(/\/$/, "") + href;
        return base.replace(/\/$/, "") + "/" + href;
    }

    function safeDecodeURI(s) {
        if (!s) return "";
        try { return decodeURIComponent(s.replace(/\+/g, " ")); }
        catch (e) { return s.replace(/\+/g, " "); }
    }

    function qualityOf(s) {
        if (!s) return 0;
        var t = s.toLowerCase();
        if (/\b(4k|2160p|uhd)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t)) return 1080;
        if (/\b720p\b/.test(t))  return 720;
        if (/\b(480p|320p)\b/.test(t)) return 480;
        return 0;
    }

    function cleanTitle(raw) {
        if (!raw) return "Unknown";
        var t = stripTags(raw).trim();
        t = t.replace(/\s+(Full\s+)?Movie\s+Watch\s+Online\s+(Free|HD).*/i, "").trim();
        t = t.replace(/\s+(DVDScr|DVDRip|HDRip|BRRip|WEBRip|WEB-DL|BluRay|CAMRip|PreDVD)\s+.*/i, "").trim();
        return t || "Unknown";
    }

    function isSeries(title) {
        return /\bSeason\s*\d|\bS\d{2}\b|\bEP\s*\d|Episode\s*\d/i.test(title);
    }

    function parseMovieGrid(html, mainUrl) {
        var items    = [];
        var seenHref = {};
        var pos = 0;

        while (true) {
            var aStart = html.indexOf("movie-watch-online-free", pos);
            if (aStart === -1) break;

            var aOpen = html.lastIndexOf("<a", aStart);
            if (aOpen === -1) { pos = aStart + 1; continue; }

            var hrefIdx = html.indexOf('href="', aOpen);
            if (hrefIdx === -1 || hrefIdx > aStart + 200) { pos = aStart + 1; continue; }
            var hrefStart = hrefIdx + 6;
            var hrefEnd   = html.indexOf('"', hrefStart);
            if (hrefEnd === -1) { pos = aStart + 1; continue; }
            var href = html.substring(hrefStart, hrefEnd);

            if (href.indexOf("movie-watch-online-free") === -1) { pos = aStart + 24; continue; }
            if (seenHref[href]) { pos = aStart + 24; continue; }
            seenHref[href] = true;

            var aClose = html.indexOf("</a>", aOpen);

            var posterUrl = null;
            var imgIdx = html.indexOf("<img", aOpen);
            if (imgIdx !== -1 && imgIdx < aClose) {
                var srcIdx = html.indexOf('src="', imgIdx);
                if (srcIdx !== -1 && srcIdx < aClose) {
                    var srcStart = srcIdx + 5;
                    var srcEnd   = html.indexOf('"', srcStart);
                    if (srcEnd !== -1) posterUrl = resolveUrl(html.substring(srcStart, srcEnd), mainUrl);
                }
            }

            var rawTitle = "";
            var titleAttrIdx = html.indexOf('title="', aOpen);
            if (titleAttrIdx !== -1 && titleAttrIdx < aStart + 50) {
                var ts = titleAttrIdx + 7;
                var te = html.indexOf('"', ts);
                if (te !== -1) rawTitle = html.substring(ts, te);
            }
            if (!rawTitle) {
                var bStart = html.indexOf("<b>", aClose);
                if (bStart !== -1 && bStart < aClose + 200) {
                    var bEnd = html.indexOf("</b>", bStart);
                    if (bEnd !== -1) rawTitle = html.substring(bStart + 3, bEnd);
                }
            }

            var title = cleanTitle(rawTitle);
            if (!title || title === "Unknown" || title.length < 3) { pos = aClose + 4; continue; }

            items.push({
                title:     title,
                url:       resolveUrl(href, mainUrl),
                posterUrl: posterUrl,
                type:      isSeries(rawTitle) ? "series" : "movie",
                quality:   qualityOf(rawTitle),
                rawTitle:  rawTitle
            });

            pos = aClose + 4;
        }

        log("parseMovieGrid: " + items.length + " items");
        return items;
    }

    function toMultimediaItems(items) {
        var result = [];
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            result.push(new MultimediaItem({
                title:     item.title,
                url:       item.url,
                posterUrl: item.posterUrl || undefined,
                type:      item.type      || "movie",
                quality:   item.quality   || 0
            }));
        }
        return result;
    }

    function getHome(cb) {
        getMainUrl().then(function (mainUrl) {
            log("getHome: " + mainUrl);
            return http_get(mainUrl + "/").then(function (res) {
                var html = res.body;

                function sliceSection(startText, endText) {
                    var lower = html.toLowerCase();
                    var s = lower.indexOf(startText.toLowerCase());
                    if (s === -1) return "";
                    var e = endText ? lower.indexOf(endText.toLowerCase(), s + startText.length) : html.length;
                    return html.substring(s, e === -1 ? html.length : e);
                }

                var featuredHtml = sliceSection("featured movies free", "latest movies");
                var latestHtml   = sliceSection("latest movies",        "posts navigation");

                log("featuredHtml: " + featuredHtml.length + "c  latestHtml: " + latestHtml.length + "c");

                var featuredItems = featuredHtml ? parseMovieGrid(featuredHtml, mainUrl) : [];
                var latestItems   = latestHtml   ? parseMovieGrid(latestHtml,   mainUrl) : [];

                var featuredUrls = {};
                for (var i = 0; i < featuredItems.length; i++) featuredUrls[featuredItems[i].url] = true;
                var uniqueLatest = [];
                for (var j = 0; j < latestItems.length; j++) {
                    if (!featuredUrls[latestItems[j].url]) uniqueLatest.push(latestItems[j]);
                }

                var homeData = {};
                if (featuredItems.length) homeData["\uD83D\uDD25 Featured"]      = toMultimediaItems(featuredItems);
                if (uniqueLatest.length)  homeData["\uD83C\uDD95 Latest Movies"] = toMultimediaItems(uniqueLatest);

                if (!Object.keys(homeData).length) {
                    var allItems = parseMovieGrid(html, mainUrl);
                    if (allItems.length) homeData["Movies"] = toMultimediaItems(allItems);
                }

                log("getHome done: " + Object.keys(homeData).length + " sections");
                cb({ success: true, data: homeData });
            });
        }).catch(function (e) {
            err("getHome:", e.message);
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        });
    }

    function search(query, cb) {
        getMainUrl().then(function (mainUrl) {
            var q    = encodeURIComponent(query);
            var urls = [
                mainUrl + "/?s=" + q,
                mainUrl + "/search/" + encodeURIComponent(query)
            ];
            return trySearchUrls(urls, 0, mainUrl);
        }).then(function (items) {
            cb({ success: true, data: toMultimediaItems(items) });
        }).catch(function (e) {
            err("search:", e.message);
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        });
    }

    function trySearchUrls(urls, i, mainUrl) {
        if (i >= urls.length) return Promise.resolve([]);
        log("search: " + urls[i]);
        return http_get(urls[i]).then(function (res) {
            var items = parseMovieGrid(res.body, mainUrl);
            log("search got: " + items.length + " items");
            if (items.length > 0) return items;
            return trySearchUrls(urls, i + 1, mainUrl);
        }).catch(function () {
            return trySearchUrls(urls, i + 1, mainUrl);
        });
    }

    function load(url, cb) {
        getMainUrl().then(function (mainUrl) {
            log("load: " + url);
            return http_get(url).then(function (res) {
                var html = res.body;

                // Title
                var rawTitle = "";
                var h2s = html.indexOf("<h2");
                if (h2s !== -1) {
                    var h2e = html.indexOf(">", h2s);
                    var h2c = html.indexOf("</h2>", h2e);
                    if (h2e !== -1 && h2c !== -1) rawTitle = html.substring(h2e + 1, h2c);
                }
                if (!rawTitle) {
                    var tts = html.indexOf("<title>");
                    if (tts !== -1) {
                        var tte = html.indexOf("</title>", tts);
                        if (tte !== -1) rawTitle = html.substring(tts + 7, tte);
                    }
                }
                var title = cleanTitle(rawTitle);
                log("load title: " + title);

                // Poster
                var posterUrl = null;
                var uploadsIdx = html.indexOf("/uploads/");
                if (uploadsIdx !== -1) {
                    var srcCheck = html.lastIndexOf('src="', uploadsIdx);
                    if (srcCheck !== -1 && uploadsIdx - srcCheck < 10) {
                        var srcEnd = html.indexOf('"', uploadsIdx);
                        if (srcEnd !== -1) posterUrl = resolveUrl(html.substring(srcCheck + 5, srcEnd), mainUrl);
                    }
                }
                if (!posterUrl) {
                    var ogIdx = html.indexOf('property="og:image"');
                    if (ogIdx !== -1) {
                        var cIdx = html.indexOf('content="', ogIdx);
                        if (cIdx !== -1) {
                            var cs = cIdx + 9;
                            var ce = html.indexOf('"', cs);
                            if (ce !== -1) posterUrl = html.substring(cs, ce);
                        }
                    }
                }

                // Movie info
                var director = "", cast = [], genres = [], language = "", description = "";

                var dirIdx = html.indexOf("Directed by:");
                if (dirIdx !== -1) {
                    var dirEnd = html.indexOf("<br", dirIdx);
                    director = stripTags(html.substring(dirIdx + 12, dirEnd !== -1 ? dirEnd : dirIdx + 200)).trim();
                }

                var starIdx = html.indexOf("Starring by:");
                if (starIdx !== -1) {
                    var starEnd = html.indexOf("<br", starIdx);
                    var castStr = stripTags(html.substring(starIdx + 12, starEnd !== -1 ? starEnd : starIdx + 300)).trim();
                    var castParts = castStr.split(",");
                    for (var ci = 0; ci < castParts.length; ci++) {
                        var cp = castParts[ci].trim();
                        if (cp) cast.push(cp);
                    }
                }

                var genreIdx = html.indexOf("Genres:");
                if (genreIdx !== -1) {
                    var genreEnd = html.indexOf("<br", genreIdx);
                    var genreStr = stripTags(html.substring(genreIdx + 7, genreEnd !== -1 ? genreEnd : genreIdx + 200)).trim();
                    var genreParts = genreStr.split(",");
                    for (var gi = 0; gi < genreParts.length; gi++) {
                        var gp = genreParts[gi].trim();
                        if (gp) genres.push(gp);
                    }
                }

                var langIdx = html.indexOf("Language:");
                if (langIdx !== -1) {
                    var langEnd = html.indexOf("<br", langIdx);
                    language = stripTags(html.substring(langIdx + 9, langEnd !== -1 ? langEnd : langIdx + 100)).trim();
                }

                // Description
                var descStart = langIdx > 0 ? langIdx : (genreIdx > 0 ? genreIdx : 0);
                var descPos   = descStart;
                for (var da = 0; da < 10; da++) {
                    var pStart = html.indexOf("<p>", descPos);
                    if (pStart === -1) break;
                    var pEnd = html.indexOf("</p>", pStart);
                    if (pEnd === -1) break;
                    var candidate = html.substring(pStart + 3, pEnd);
                    var plain = stripTags(candidate).trim();
                    if (plain.length > 60 && candidate.indexOf("href=") === -1) {
                        description = plain;
                        break;
                    }
                    descPos = pEnd + 4;
                }

                // All magnet links
                var magnets  = [];
                var seenMag  = {};
                var mpos = 0;

                while (true) {
                    var magIdx = html.indexOf('href="magnet:', mpos);
                    if (magIdx === -1) break;

                    var magStart = magIdx + 6;
                    var magEnd   = html.indexOf('"', magStart);
                    if (magEnd === -1) break;

                    var magnetUrl = html.substring(magStart, magEnd);
                    if (seenMag[magnetUrl]) { mpos = magEnd + 1; continue; }
                    seenMag[magnetUrl] = true;

                    var aCloseIdx   = html.indexOf("</a>", magEnd);
                    var buttonLabel = "";
                    if (aCloseIdx !== -1) {
                        var smallIdx = html.indexOf("<small>", magEnd);
                        if (smallIdx !== -1 && smallIdx < aCloseIdx) {
                            var smallEnd = html.indexOf("</small>", smallIdx);
                            if (smallEnd !== -1) {
                                buttonLabel = stripTags(html.substring(smallIdx + 7, smallEnd)).trim();
                            }
                        }
                    }

                    var dnMatch = magnetUrl.match(/[?&]dn=([^&]+)/i);
                    var dnName  = dnMatch ? safeDecodeURI(dnMatch[1]) : "";
                    var quality = qualityOf(buttonLabel) || qualityOf(dnName);

                    log("  magnet: label=" + buttonLabel + " Q=" + quality);
                    magnets.push({ magnetUrl: magnetUrl, buttonLabel: buttonLabel, quality: quality });
                    mpos = magEnd + 1;
                }

                magnets.sort(function (a, b) { return b.quality - a.quality; });
                log("load: " + magnets.length + " magnets found");

                // Cast actors
                var castActors = [];
                for (var cai = 0; cai < cast.length; cai++) {
                    castActors.push(new Actor({ name: cast[cai] }));
                }

                var type = isSeries(rawTitle) ? "series" : "movie";

                // ONE episode = ALL magnets as array
                // loadStreams returns all as StreamResults → user picks quality
                var magnetPayload = [];
                for (var mi = 0; mi < magnets.length; mi++) {
                    magnetPayload.push({
                        magnetUrl:   magnets[mi].magnetUrl,
                        buttonLabel: magnets[mi].buttonLabel,
                        quality:     magnets[mi].quality
                    });
                }

                var episodes = [new Episode({
                    name: title,
                    url:  JSON.stringify(magnetPayload)
                })];

                cb({ success: true, data: new MultimediaItem({
                    title:       title,
                    url:         url,
                    posterUrl:   posterUrl  || undefined,
                    type:        type,
                    description: description || undefined,
                    genres:      genres,
                    cast:        castActors,
                    episodes:    episodes
                }) });
            });
        }).catch(function (e) {
            err("load:", e.message);
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        });
    }

    // ALL magnets returned at once as StreamResults
    // User sees: [MovieRulz] 2.5 gb 1080p / [MovieRulz] 1.4 gb 720p / etc.
    function loadStreams(url, cb) {
        try {
            var parsed  = JSON.parse(url);
            var entries = Array.isArray(parsed) ? parsed : [parsed];
            log("loadStreams: entries = " + entries.length);

            var results = [];
            for (var i = 0; i < entries.length; i++) {
                var entry       = entries[i];
                var magnetUrl   = entry.magnetUrl   || "";
                var buttonLabel = entry.buttonLabel || "";
                var quality     = entry.quality     || 0;

                if (!magnetUrl || magnetUrl.indexOf("magnet:") !== 0) continue;

                var label = "[MovieRulz]" + (buttonLabel ? " " + buttonLabel : "");
                log("  stream: " + label + " " + quality + "p");

                results.push(new StreamResult({
                    url:     magnetUrl,
                    quality: quality,
                    source:  label,
                    headers: {}
                }));
            }

            if (!results.length) {
                warn("loadStreams: no valid magnets");
                return cb({ success: true, data: [] });
            }

            cb({ success: true, data: results });
        } catch (e) {
            err("loadStreams:", e.message);
            cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
        }
    }

    if (typeof globalThis !== "undefined") {
        globalThis.getHome = getHome; globalThis.search = search;
        globalThis.load = load; globalThis.loadStreams = loadStreams;
    }
    if (typeof window !== "undefined") {
        window.getHome = getHome; window.search = search;
        window.load = load; window.loadStreams = loadStreams;
    }
    if (typeof global !== "undefined") {
        global.getHome = getHome; global.search = search;
        global.load = load; global.loadStreams = loadStreams;
    }
})();
