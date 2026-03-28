(function () {
    // ============================================================
    // 1TamilMV Plugin v5 — ES5, Bing domain discovery, all magnets
    // as single episode → user picks quality in sources tab
    // No TMDB, no domains.json — site provides all needed info
    // ============================================================

    var DEBUG = true;
    function log() {
        if (!DEBUG) return;
        var a = Array.prototype.slice.call(arguments);
        a.unshift("[TMV]");
        console.log.apply(console, a);
    }
    function warn() {
        if (!DEBUG) return;
        var a = Array.prototype.slice.call(arguments);
        a.unshift("[TMV WARN]");
        console.warn.apply(console, a);
    }
    function err() {
        var a = Array.prototype.slice.call(arguments);
        a.unshift("[TMV ERR]");
        console.error.apply(console, a);
    }

    // ============================================================
    // DOMAIN DISCOVERY — 3 level waterfall (no domains.json):
    //   1. Memory cache
    //   2. Known TLD fallback list
    //   3. Bing search for "1tamilmv" (last resort)
    // ============================================================
    var FALLBACK_DOMAINS = [
        "https://www.1tamilmv.immo",
        "https://www.1tamilmv.fi",
        "https://www.1tamilmv.wf",
        "https://www.1tamilmv.eu",
        "https://www.1tamilmv.haus",
        "https://www.1tamilmv.com",
        "https://www.1tamilmv.net",
        "https://www.1tamilmv.pw"
    ];

    var BING_SEARCH_URLS = [
        "https://www.bing.com/search?q=1tamilmv+tamil+movies+download+torrent&count=10",
        "https://www.bing.com/search?q=1tamilmv+latest+movies+forum&count=10",
        "https://www.bing.com/search?q=site%3A1tamilmv+movies&count=10"
    ];

    // A response from the real site always contains this IPS forum string
    var SITE_FINGERPRINT = "forums/topic";
    var DOMAIN_PATTERN   = /https?:\/\/(?:www\.)?1tamilmv\.\w{2,10}/i;

    var cachedMainUrl = null;

    function getMainUrl() {
        if (cachedMainUrl) return Promise.resolve(cachedMainUrl);
        return tryFallbacks(0);
    }

    function tryFallbacks(i) {
        if (i >= FALLBACK_DOMAINS.length) {
            log("All fallbacks failed — trying Bing search discovery");
            return tryBingSearch(0);
        }
        log("Trying: " + FALLBACK_DOMAINS[i]);
        return testDomain(FALLBACK_DOMAINS[i]).then(function (ok) {
            if (ok) {
                cachedMainUrl = FALLBACK_DOMAINS[i];
                log("Domain OK: " + cachedMainUrl);
                return cachedMainUrl;
            }
            return tryFallbacks(i + 1);
        }).catch(function () {
            return tryFallbacks(i + 1);
        });
    }

    function tryBingSearch(i) {
        if (i >= BING_SEARCH_URLS.length) {
            warn("Bing exhausted — using first fallback as last resort");
            cachedMainUrl = FALLBACK_DOMAINS[0];
            return Promise.resolve(cachedMainUrl);
        }
        log("Bing search attempt " + (i + 1) + ": " + BING_SEARCH_URLS[i]);
        return http_get(BING_SEARCH_URLS[i]).then(function (res) {
            var candidates = extractDomainCandidates(res.body);
            log("Bing candidates: " + candidates.join(", "));
            if (!candidates.length) return tryBingSearch(i + 1);
            return tryBingCandidates(candidates, 0, i);
        }).catch(function (e) {
            err("Bing search failed:", e.message);
            return tryBingSearch(i + 1);
        });
    }

    function tryBingCandidates(candidates, i, searchIdx) {
        if (i >= candidates.length) return tryBingSearch(searchIdx + 1);
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

    function extractDomainCandidates(html) {
        var found = [], seen = {}, pos = 0;
        while (true) {
            var hIdx = html.indexOf('href="', pos);
            if (hIdx === -1) break;
            var hStart = hIdx + 6;
            var hEnd   = html.indexOf('"', hStart);
            if (hEnd === -1) break;
            var href  = html.substring(hStart, hEnd);
            var match = href.match(DOMAIN_PATTERN);
            if (match) {
                var origin = extractOrigin(href);
                if (origin && !seen[origin]) { seen[origin] = true; found.push(origin); }
            }
            pos = hEnd + 1;
        }
        // Also check <cite> tags
        pos = 0;
        while (true) {
            var cIdx = html.indexOf("<cite", pos);
            if (cIdx === -1) break;
            var cClose = html.indexOf(">", cIdx);
            var cEnd   = html.indexOf("</cite>", cClose);
            if (cClose === -1 || cEnd === -1) break;
            var cText  = stripTags(html.substring(cClose + 1, cEnd)).trim();
            var cMatch = cText.match(DOMAIN_PATTERN);
            if (cMatch) {
                var origin = extractOrigin(cMatch[0]);
                if (origin && !seen[origin]) { seen[origin] = true; found.push(origin); }
            }
            pos = cEnd + 7;
        }
        return found;
    }

    function extractOrigin(url) {
        if (!url) return null;
        var m = url.match(/^(https?:\/\/[^\/]+)/);
        return m ? m[1] : null;
    }

    function testDomain(domain) {
        return http_get(domain + "/").then(function (res) {
            var ok = res.body && res.body.indexOf(SITE_FINGERPRINT) !== -1;
            log("testDomain " + domain + " -> " + (ok ? "OK" : "FAIL"));
            return ok;
        }).catch(function (e) {
            log("testDomain " + domain + " -> FAIL (" + e.message + ")");
            return false;
        });
    }

    // ============================================================
    // JUNK / VALID FILTERS
    // ============================================================
    var JUNK_WORDS = ["announcement","notice","request","discussion","help","rules","faq","sticky","guide","welcome","important","pin"];
    function isJunkTitle(title) {
        if (!title) return true;
        var lower = title.toLowerCase().trim();
        for (var i = 0; i < JUNK_WORDS.length; i++) {
            if (lower.indexOf(JUNK_WORDS[i]) === 0 || lower.indexOf("[" + JUNK_WORDS[i]) === 0) return true;
        }
        return false;
    }
    function hasYear(title) { return /\(\d{4}\)/.test(title); }

    // ============================================================
    // TITLE PARSING
    // "Band Melam (2026) Telugu HQ PreDVD - [1080p & 720p ...]"
    // → { cleanName:"Band Melam", year:"2026", displayTitle:"Band Melam (2026)" }
    // ============================================================
    function parseTopicTitle(raw) {
        if (!raw) return { cleanName: "Unknown", year: "", isSeries: false, displayTitle: "Unknown" };

        var t = raw.replace(/^(?:www[\s.]+)?1?TamilMV(?:[\s.]+(?:immo|fi|wf|eu|haus|com|net|org))?\s*[-\u2013]\s*/i, "").trim();
        t = t.replace(/\s*-\s*\[.*$/, "").trim();
        t = t.replace(/\s*\[.*$/, "").trim();

        var isSeries = /\bS\d{2}\b|\bEP\s*[\(\d]/i.test(raw)
                    || /\bSeason\s+\d/i.test(raw)
                    || /\bWeb[- ]?Series\b/i.test(raw);

        var yearM = t.match(/\((\d{4})\)/);
        var year  = yearM ? yearM[1] : "";

        var cleanName = year ? t.substring(0, t.indexOf("(" + year + ")")).trim() : t;

        cleanName = cleanName
            .replace(/\s+(Tamil|Telugu|Hindi|Malayalam|Kannada|English|Dual\s*Audio|Multi)\s*$/i, "")
            .replace(/\s+(TRUE|HQ)\s*$/i, "")
            .replace(/\s+S\d{2}.*$/i, "")
            .trim();

        var displayTitle = year ? cleanName + " (" + year + ")" : cleanName;
        log("parseTopicTitle: " + raw.substring(0, 60) + " -> " + displayTitle);
        return { cleanName: cleanName, year: year, isSeries: isSeries, displayTitle: displayTitle };
    }

    // ============================================================
    // UTILS
    // ============================================================
    function stripTags(s) {
        if (!s) return "";
        return s
            .replace(/<script[\s\S]*?<\/script>/gi, "")
            .replace(/<style[\s\S]*?<\/style>/gi, "")
            .replace(/<[^>]+>/g, "")
            .replace(/&amp;/g, "&").replace(/&nbsp;/g, " ").replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">").replace(/&quot;/g, '"').replace(/&#\d+;/g, "")
            .replace(/\s+/g, " ").trim();
    }
    function resolveUrl(href, base) {
        if (!href) return null;
        if (href.indexOf("http") === 0) return href;
        if (href.indexOf("/") === 0) return base.replace(/\/$/, "") + href;
        return base.replace(/\/$/, "") + "/" + href;
    }
    function qualityOf(s) {
        if (!s) return 0;
        var t = s.toLowerCase();
        if (/\b(4k|2160p|uhd)\b/.test(t)) return 2160;
        if (/\b1080p\b/.test(t)) return 1080;
        if (/\b720p\b/.test(t))  return 720;
        if (/\b480p\b/.test(t))  return 480;
        return 0;
    }
    function safeDecodeURI(s) {
        if (!s) return "";
        try { return decodeURIComponent(s.replace(/\+/g, " ")); }
        catch (e) {
            try { return decodeURIComponent(s.replace(/\+/g, " ").replace(/%(?![0-9A-Fa-f]{2})/g, "%25")); }
            catch (e2) { return s.replace(/\+/g, " "); }
        }
    }
    function parseFileName(fn) {
        if (!fn) return { size: "", specs: [], quality: 0 };
        var sizeAll = fn.match(/\d+(?:\.\d+)?\s*(?:GB|MB|TB)/gi) || [];
        var size    = sizeAll.length ? sizeAll[sizeAll.length - 1] : "";
        var quality = qualityOf(fn);
        var specs   = [];
        var sq     = (fn.match(/\b(2160p|4K|UHD|1080p|720p|480p)\b/i) || [])[0];
        var ssrc   = (fn.match(/\b(TRUE\s+WEB-DL|WEB-DL|WEBRip|BluRay|HDRip|DVDRip|HQ\s*PreDVD|PreDVD)\b/i) || [])[0];
        var scodec = (fn.match(/\b(x265|x264|HEVC|AVC|AV1)\b/i) || [])[0];
        var saudio = (fn.match(/\b(DD\+?5\.1|DDP5\.1|DTS[-\s]?HD|DTS|AC3|Atmos|AAC|MP3)\b/i) || [])[0];
        if (sq)     specs.push(sq);
        if (ssrc)   specs.push(ssrc.replace(/\s+/g, "-"));
        if (scodec) specs.push(scodec);
        if (saudio) specs.push(saudio);
        return { size: size, specs: specs, quality: quality };
    }
    function toBytes(s) {
        var m = (s || "").match(/([\d.]+)\s*(GB|MB|TB)/i);
        if (!m) return 0;
        var n = parseFloat(m[1]);
        if (/TB/i.test(m[2])) return n * 1e12;
        if (/GB/i.test(m[2])) return n * 1e9;
        return n * 1e6;
    }

    // ============================================================
    // PARSE TOPIC LIST
    // ============================================================
    function parseTopicList(html, mainUrl, requireYear) {
        if (requireYear === undefined) requireYear = true;
        var items    = [];
        var seenHref = {};
        var pos = 0;

        while (true) {
            var aStart = html.indexOf("<a", pos);
            if (aStart === -1) break;
            var aEnd = html.indexOf(">", aStart);
            if (aEnd === -1) break;
            var tagContent   = html.substring(aStart, aEnd + 1);
            var hrefStart    = tagContent.indexOf('href="');
            if (hrefStart === -1) { pos = aEnd + 1; continue; }
            var hrefValStart = hrefStart + 6;
            var hrefEnd      = tagContent.indexOf('"', hrefValStart);
            if (hrefEnd === -1) { pos = aEnd + 1; continue; }
            var href         = tagContent.substring(hrefValStart, hrefEnd);
            var closeStart   = html.indexOf("</a>", aEnd);
            if (closeStart === -1) { pos = aEnd + 1; continue; }
            var rawTitle     = stripTags(html.substring(aEnd + 1, closeStart)).trim();

            if (href.indexOf("forums/topic") === -1)              { pos = closeStart + 4; continue; }
            if (!/forums\/topic\/\d+-[a-z]/i.test(href))          { pos = closeStart + 4; continue; }
            if (!rawTitle || rawTitle.length < 5)                  { pos = closeStart + 4; continue; }
            if (href.indexOf("page_") !== -1 ||
                href.indexOf("#replies") !== -1 ||
                href.indexOf("#comment") !== -1)                   { pos = closeStart + 4; continue; }
            if (seenHref[href])                                    { pos = closeStart + 4; continue; }
            if (isJunkTitle(rawTitle))                             { pos = closeStart + 4; continue; }
            if (requireYear && !hasYear(rawTitle))                 { pos = closeStart + 4; continue; }

            seenHref[href] = true;
            var parsed = parseTopicTitle(rawTitle);
            items.push({
                title:     parsed.displayTitle,
                url:       resolveUrl(href, mainUrl),
                posterUrl: null,
                type:      parsed.isSeries ? "series" : "movie",
                quality:   qualityOf(rawTitle),
                rawTitle:  rawTitle
            });
            pos = closeStart + 4;
        }
        log("parseTopicList(requireYear=" + requireYear + "): " + items.length + " items");
        return items;
    }

    // ============================================================
    // PARSE BANGER SECTION (homepage)
    // ============================================================
    function parseBangerSection(sectionHtml, mainUrl) {
        var items    = [];
        var seenHref = {};
        var lines    = sectionHtml.split(/<br\s*\/?>/i);

        for (var li = 0; li < lines.length; li++) {
            var line = lines[li];
            var topicHref = null, innerText = "", firstAIdx = -1;
            var aPos = 0;

            while (true) {
                var aIdx = line.indexOf("<a", aPos);
                if (aIdx === -1) break;
                var aCloseIdx = line.indexOf(">", aIdx);
                if (aCloseIdx === -1) break;
                var aTag    = line.substring(aIdx, aCloseIdx + 1);
                var hrefIdx = aTag.indexOf('href="');
                if (hrefIdx !== -1) {
                    var hStart = hrefIdx + 6;
                    var hEnd   = aTag.indexOf('"', hStart);
                    if (hEnd !== -1) {
                        var candidate = aTag.substring(hStart, hEnd);
                        if (candidate.indexOf("forums/topic") !== -1 &&
                            candidate.indexOf("page_") === -1 &&
                            candidate.indexOf("#replies") === -1) {
                            topicHref = candidate;
                            firstAIdx = aIdx;
                            var aEndClose = line.indexOf("</a>", aCloseIdx);
                            if (aEndClose !== -1)
                                innerText = stripTags(line.substring(aCloseIdx + 1, aEndClose)).trim();
                            break;
                        }
                    }
                }
                aPos = aCloseIdx + 1;
            }

            if (!topicHref || seenHref[topicHref]) continue;

            var textBefore = firstAIdx > 0
                ? stripTags(line.substring(0, firstAIdx)).replace(/-\s*$/, "").replace(/\s+/g, " ").trim()
                : "";

            var rawTitle = "";
            if (hasYear(textBefore) && textBefore.length > 5) rawTitle = textBefore;
            else if (innerText.length > 5)                     rawTitle = innerText;
            else if (textBefore.length > 5)                    rawTitle = textBefore;

            if (!rawTitle || rawTitle.length < 3) continue;
            if (isJunkTitle(rawTitle)) continue;

            seenHref[topicHref] = true;
            var parsed = parseTopicTitle(rawTitle);
            items.push({
                title:     parsed.displayTitle,
                url:       resolveUrl(topicHref, mainUrl),
                posterUrl: null,
                type:      parsed.isSeries ? "series" : "movie",
                quality:   qualityOf(rawTitle),
                rawTitle:  rawTitle
            });
        }
        log("parseBangerSection: " + items.length + " items");
        return items;
    }

    function extractSection(html, startKeyword, endKeyword) {
        var lower = html.toLowerCase();
        var start = lower.indexOf(startKeyword.toLowerCase());
        if (start === -1) return "";
        var end = html.length;
        if (endKeyword) {
            var e = lower.indexOf(endKeyword.toLowerCase(), start + startKeyword.length);
            if (e !== -1) end = e;
        }
        return html.substring(start, end);
    }

    function makeMultimediaItems(items) {
        var result = [];
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            result.push(new MultimediaItem({
                title:       item.title,
                url:         item.url,
                posterUrl:   item.posterUrl   || undefined,
                bannerUrl:   item.bannerUrl   || undefined,
                type:        item.type        || "movie",
                quality:     item.quality     || 0,
                description: item.description || undefined,
                year:        item.year        || undefined,
                score:       item.score       || undefined,
                genres:      item.genres      || []
            }));
        }
        return result;
    }

    // ============================================================
    // HOME
    // ============================================================
    function getHome(cb) {
        getMainUrl().then(function (mainUrl) {
            log("getHome: " + mainUrl);
            return http_get(mainUrl + "/").then(function (homeRes) {
                var homeHtml = homeRes.body;

                var topHtml    = extractSection(homeHtml, "top releases this week", "recently added");
                if (!topHtml)  topHtml = extractSection(homeHtml, "top releases", "recently added");
                var recentHtml = extractSection(homeHtml, "recently added", "forum statistics");
                if (!recentHtml) recentHtml = extractSection(homeHtml, "recently added", "");

                log("topHtml: " + topHtml.length + "c  recentHtml: " + recentHtml.length + "c");

                var topItems    = topHtml    ? parseBangerSection(topHtml,    mainUrl) : [];
                var recentItems = recentHtml ? parseBangerSection(recentHtml, mainUrl) : [];

                // Fallback to forum pages
                if (!topItems.length && !recentItems.length) {
                    log("Homepage sections empty — falling back to forum pages");
                    var sections = [
                        {name:"tamil",id:"2"},{name:"telugu",id:"22"},{name:"hindi",id:"56"},
                        {name:"malayalam",id:"58"},{name:"kannada",id:"60"},
                        {name:"english",id:"62"},{name:"web-series",id:"90"}
                    ];
                    var seenUrls = {};
                    var promises = [];
                    for (var si = 0; si < sections.length; si++) {
                        (function(s) {
                            var fUrl = mainUrl + "/index.php?/forums/forum/" + s.id + "-" + s.name + "/&sortby=start_date&sortdirection=desc";
                            promises.push(
                                http_get(fUrl).then(function (fRes) {
                                    var fItems = parseTopicList(fRes.body, mainUrl);
                                    for (var fi = 0; fi < Math.min(fItems.length, 6); fi++) {
                                        var item = fItems[fi];
                                        if (!seenUrls[item.url]) {
                                            seenUrls[item.url] = true;
                                            recentItems.push(item);
                                        }
                                    }
                                }).catch(function(e) { err("fallback forum:", e.message); })
                            );
                        })(sections[si]);
                    }
                    return Promise.all(promises).then(function () {
                        return buildHomeData(topItems, recentItems, mainUrl, cb);
                    });
                }

                return buildHomeData(topItems, recentItems, mainUrl, cb);
            });
        }).catch(function (e) {
            err("getHome:", e.message);
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        });
    }

    function buildHomeData(topItems, recentItems, mainUrl, cb) {
        // Deduplicate
        var topUrls = {};
        for (var i = 0; i < topItems.length; i++) topUrls[topItems[i].url] = true;
        var uniqueRecent = [];
        for (var j = 0; j < recentItems.length; j++) {
            if (!topUrls[recentItems[j].url]) uniqueRecent.push(recentItems[j]);
        }

        var homeData = {};
        if (topItems.length)    homeData["\uD83D\uDD25 Top Releases This Week"] = makeMultimediaItems(topItems);
        if (uniqueRecent.length) homeData["\uD83C\uDD95 Recently Added"]         = makeMultimediaItems(uniqueRecent);

        if (!Object.keys(homeData).length) {
            return cb({ success: false, errorCode: "HOME_EMPTY", message: "No sections found" });
        }
        log("getHome done: " + Object.keys(homeData).length + " sections");
        cb({ success: true, data: homeData });
    }

    // ============================================================
    // SEARCH
    // ============================================================
    function search(query, cb) {
        getMainUrl().then(function (mainUrl) {
            var nodes        = "2,22,56,58,60,62,63,90";
            var encodedQuery = encodeURIComponent(query);
            var searchUrls   = [
                mainUrl + "/index.php?/search/?q=" + encodedQuery + "&type=forums_topic&nodes=" + nodes + "&sortby=relevancy",
                mainUrl + "/index.php?/search/?q=" + encodedQuery + "&type=forums_topic&sortby=relevancy",
                mainUrl + "/index.php?/search/&q=" + encodedQuery + "&type=forums_topic&nodes=" + nodes + "&sortby=relevancy",
                mainUrl + "/index.php?/search/&q=" + encodedQuery + "&type=forums_topic&sortby=relevancy",
                mainUrl + "/index.php?/search/?q=" + encodedQuery,
                mainUrl + "/index.php?/search/&q=" + encodedQuery
            ];
            return trySearchUrls(searchUrls, 0, mainUrl, query);
        }).then(function (items) {
            cb({ success: true, data: makeMultimediaItems(items) });
        }).catch(function (e) {
            err("search:", e.message);
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        });
    }

    function trySearchUrls(urls, i, mainUrl, query) {
        if (i >= urls.length) return tryForumFallbackSearch(mainUrl, query, []);
        log("search attempt: " + urls[i]);
        return http_get(urls[i]).then(function (res) {
            var items = parseTopicList(res.body, mainUrl, false);
            log("search got: " + items.length + " items");
            if (items.length >= 3) return items;
            return trySearchUrls(urls, i + 1, mainUrl, query);
        }).catch(function () {
            return trySearchUrls(urls, i + 1, mainUrl, query);
        });
    }

    function tryForumFallbackSearch(mainUrl, query, existingItems) {
        log("Forum fallback search for: " + query);
        var sections = [
            {id:"2",name:"tamil"},{id:"22",name:"telugu"},{id:"56",name:"hindi"},
            {id:"58",name:"malayalam"},{id:"60",name:"kannada"},{id:"62",name:"english"},
            {id:"90",name:"web-series"}
        ];
        var qLower   = query.toLowerCase();
        var seenUrls = {};
        var items    = existingItems.slice();
        for (var k = 0; k < items.length; k++) seenUrls[items[k].url] = true;

        var promises = [];
        for (var si = 0; si < sections.length; si++) {
            (function(s) {
                var fUrl = mainUrl + "/index.php?/forums/forum/" + s.id + "-" + s.name + "/";
                promises.push(
                    http_get(fUrl).then(function (fRes) {
                        var fItems = parseTopicList(fRes.body, mainUrl, false);
                        for (var fi = 0; fi < fItems.length; fi++) {
                            var item = fItems[fi];
                            if (seenUrls[item.url]) continue;
                            if (item.rawTitle.toLowerCase().indexOf(qLower) === -1) continue;
                            seenUrls[item.url] = true;
                            items.push(item);
                        }
                    }).catch(function(e) { err("forum fallback search:", e.message); })
                );
            })(sections[si]);
        }
        return Promise.all(promises).then(function () {
            log("After forum fallback: " + items.length + " items");
            return items;
        });
    }

    // ============================================================
    // EXTRACT MAGNET ENTRIES from post HTML
    // ============================================================
    function extractMagnetEntries(html) {
        var entries   = [];
        var seenMag   = {};
        var pos       = 0;

        while (true) {
            var magnetIdx = html.indexOf('href="magnet:', pos);
            if (magnetIdx === -1) break;
            var valStart  = magnetIdx + 6;
            var valEnd    = html.indexOf('"', valStart);
            if (valEnd === -1) break;
            var magnetUrl = html.substring(valStart, valEnd);

            if (seenMag[magnetUrl]) { pos = valEnd + 1; continue; }
            seenMag[magnetUrl] = true;

            // Filename from dn= param
            var fileName = "";
            var dnIdx    = magnetUrl.indexOf("dn=");
            if (dnIdx !== -1) {
                var dnEnd = magnetUrl.indexOf("&", dnIdx);
                if (dnEnd === -1) dnEnd = magnetUrl.length;
                fileName = safeDecodeURI(magnetUrl.substring(dnIdx + 3, dnEnd));
            }

            // Fallback: last <strong> or <b> before this magnet
            if (!fileName) {
                var before    = html.substring(0, magnetIdx);
                var strongIdx = before.lastIndexOf("<strong");
                var boldIdx   = before.lastIndexOf("<b");
                var useStrong = strongIdx > boldIdx;
                var tagIdx    = useStrong ? strongIdx : boldIdx;
                var closeTag  = useStrong ? "</strong>" : "</b>";
                if (tagIdx !== -1) {
                    var openEnd = before.indexOf(">", tagIdx);
                    var tagEnd  = before.indexOf(closeTag, openEnd);
                    if (openEnd !== -1 && tagEnd !== -1)
                        fileName = stripTags(before.substring(openEnd + 1, tagEnd));
                }
            }

            // Fallback: last meaningful text line
            if (!fileName) {
                var plainBefore = stripTags(html.substring(0, magnetIdx));
                var lines = plainBefore.split(/\n/);
                for (var li = lines.length - 1; li >= 0; li--) {
                    var trimmed = lines[li].trim();
                    if (trimmed.length > 8) { fileName = trimmed; break; }
                }
            }

            var parsed = parseFileName(fileName);
            log("  magnet Q=" + parsed.quality + " size=" + parsed.size + " file=" + fileName.substring(0, 60));
            entries.push({
                fileName:  fileName,
                magnetUrl: magnetUrl,
                quality:   parsed.quality,
                size:      parsed.size,
                specs:     parsed.specs
            });
            pos = valEnd + 1;
        }

        entries.sort(function (a, b) {
            if (b.quality !== a.quality) return b.quality - a.quality;
            return toBytes(b.size) - toBytes(a.size);
        });
        log("extractMagnetEntries: " + entries.length + " unique");
        return entries;
    }

    // ============================================================
    // EXTRACT POST BLOCKS — depth-aware div extraction
    // ============================================================
    function extractPostBlocks(html) {
        var blocks  = [];
        var markers = ['data-role="commentContent"', 'class="cPost_contentWrap'];
        var found   = false;

        for (var mi = 0; mi < markers.length; mi++) {
            if (found) break;
            var marker = markers[mi];
            var pos    = 0;

            while (true) {
                var markerIdx = html.indexOf(marker, pos);
                if (markerIdx === -1) break;
                found = true;

                var divOpen = html.lastIndexOf("<div", markerIdx);
                if (divOpen === -1) { pos = markerIdx + marker.length; continue; }

                var openEnd = html.indexOf(">", divOpen);
                if (openEnd === -1) { pos = markerIdx + marker.length; continue; }

                var depth = 1, i = openEnd + 1;
                while (i < html.length && depth > 0) {
                    var nextOpen  = html.indexOf("<div",  i);
                    var nextClose = html.indexOf("</div>", i);
                    if (nextClose === -1) break;
                    if (nextOpen !== -1 && nextOpen < nextClose) {
                        depth++;
                        i = nextOpen + 4;
                    } else {
                        depth--;
                        i = nextClose + 6;
                    }
                }
                blocks.push(html.substring(openEnd + 1, i - 6));
                pos = i;
            }
        }

        if (!blocks.length) blocks.push(html);
        return blocks;
    }

    // ============================================================
    // LOAD — topic page
    // Extracts title, poster (og:image), description, cast from page
    // All magnets stored as ONE episode array → user picks in sources
    // ============================================================
    function load(url, cb) {
        getMainUrl().then(function (mainUrl) {
            log("load: " + url);
            return http_get(url).then(function (res) {
                var html = res.body;

                // --- Title ---
                var rawTitle = "Unknown";
                var h1Start  = html.indexOf("<h1");
                if (h1Start !== -1) {
                    var h1Close = html.indexOf(">", h1Start);
                    var h1End   = html.indexOf("</h1>", h1Close);
                    if (h1Close !== -1 && h1End !== -1)
                        rawTitle = stripTags(html.substring(h1Close + 1, h1End));
                }
                if (rawTitle === "Unknown") {
                    var ogStart = html.indexOf('property="og:title"');
                    if (ogStart !== -1) {
                        var cs = html.indexOf('content="', ogStart);
                        if (cs !== -1) {
                            var vs = cs + 9, ve = html.indexOf('"', vs);
                            if (ve !== -1) rawTitle = html.substring(vs, ve);
                        }
                    }
                }
                if (rawTitle === "Unknown") {
                    var ts = html.indexOf("<title>");
                    if (ts !== -1) {
                        var vs2 = ts + 7, ve2 = html.indexOf("</title>", vs2);
                        if (ve2 !== -1) rawTitle = stripTags(html.substring(vs2, ve2));
                    }
                }
                log("load rawTitle: " + rawTitle);

                var parsed       = parseTopicTitle(rawTitle);
                var displayTitle = parsed.displayTitle;
                var isSeries     = parsed.isSeries;

                // --- Poster from og:image ---
                var poster = null;
                var ogImg  = html.indexOf('property="og:image"');
                if (ogImg !== -1) {
                    var ci = html.indexOf('content="', ogImg);
                    if (ci !== -1) {
                        var ps = ci + 9, pe = html.indexOf('"', ps);
                        if (pe !== -1) poster = html.substring(ps, pe);
                    }
                }

                // --- Description from og:description ---
                var description = null;
                var ogDesc = html.indexOf('property="og:description"');
                if (ogDesc !== -1) {
                    var dc = html.indexOf('content="', ogDesc);
                    if (dc !== -1) {
                        var ds = dc + 9, de = html.indexOf('"', ds);
                        if (de !== -1) description = safeDecodeURI(html.substring(ds, de).replace(/&quot;/g, '"'));
                    }
                }

                // --- Extract all magnets ---
                var postBlocks = extractPostBlocks(html);
                log("load: " + postBlocks.length + " post blocks");

                var allMagnets = [];
                var globalSeen = {};
                for (var bi = 0; bi < postBlocks.length; bi++) {
                    var entries = extractMagnetEntries(postBlocks[bi]);
                    for (var ei = 0; ei < entries.length; ei++) {
                        if (!globalSeen[entries[ei].magnetUrl]) {
                            globalSeen[entries[ei].magnetUrl] = true;
                            allMagnets.push(entries[ei]);
                        }
                    }
                }
                log("load: " + allMagnets.length + " total magnets");

                // ONE episode = ALL magnets as JSON array
                // loadStreams() returns all as StreamResults → user picks quality
                var magnetPayload = [];
                for (var mi2 = 0; mi2 < allMagnets.length; mi2++) {
                    var m = allMagnets[mi2];
                    magnetPayload.push({
                        magnetUrl: m.magnetUrl,
                        fileName:  m.fileName,
                        quality:   m.quality,
                        size:      m.size,
                        specs:     m.specs
                    });
                }

                var episodes = [new Episode({
                    name: displayTitle,
                    url:  JSON.stringify(magnetPayload)
                })];

                cb({ success: true, data: new MultimediaItem({
                    title:       displayTitle,
                    url:         url,
                    posterUrl:   poster      || undefined,
                    type:        isSeries ? "series" : "movie",
                    description: description || undefined,
                    episodes:    episodes
                }) });
            });
        }).catch(function (e) {
            err("load:", e.message);
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        });
    }

    // ============================================================
    // LOAD STREAMS
    // Input: JSON array of { magnetUrl, fileName, quality, size, specs }
    // Returns ALL as StreamResults → user picks quality in sources tab
    // Source label: "[TamilMV][1080p][WEB-DL][x265] 2.6GB"
    // ============================================================
    function loadStreams(url, cb) {
        try {
            var parsed  = JSON.parse(url);
            var entries = Array.isArray(parsed) ? parsed : [parsed];
            log("loadStreams: entries = " + entries.length);

            var results = [];
            for (var i = 0; i < entries.length; i++) {
                var entry     = entries[i];
                var magnetUrl = entry.magnetUrl || "";
                var fileName  = entry.fileName  || "";
                var quality   = entry.quality   || 0;
                var size      = entry.size      || "";
                var specs     = entry.specs     || [];

                if (!magnetUrl || magnetUrl.indexOf("magnet:") !== 0) continue;

                // Build label: "[TamilMV][1080p][WEB-DL][x265] 2.6GB"
                var specsStr = "";
                for (var si = 0; si < specs.length; si++) specsStr += "[" + specs[si] + "]";
                var label = "[TamilMV]" + specsStr + (size ? " " + size : "");

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

    // --- Export ---
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
