(function() {
    function base64Decode(str) {
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var output = "";
        var bytes = [];
        for (var i = 0; i < str.length; i += 4) {
            var a = chars.indexOf(str[i]);
            var b = chars.indexOf(str[i + 1] || "=");
            var c = chars.indexOf(str[i + 2] || "=");
            var d = chars.indexOf(str[i + 3] || "=");
            bytes.push((a << 2) | (b >> 4));
            if (c !== -1 && str[i + 2] !== "=") bytes.push(((b & 15) << 4) | (c >> 2));
            if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
        }
        for (var j = 0; j < bytes.length; j++) output += String.fromCharCode(bytes[j]);
        return output;
    }

    const GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
    const GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

    const SessionTracker = {
        clientId: null,
        init() { this.clientId = this.generateUuid(); },
        generateUuid() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random() * 16 | 0;
                return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
        }
    };
    SessionTracker.init();

    const Analytics = {
        clientId: null,
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        queue: [],
        init() { this.clientId = SessionTracker.clientId; },
        logEvent(eventName, parameters) {
            console.log('[Analytics] Event: ' + eventName + ' | clientId: ' + this.clientId);
            if (!this.measurementId || !this.apiSecret) return;
            this.queue.push({ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) });
            this.flushQueue();
        },
        async flushQueue() {
            if (this.queue.length === 0) return;
            var events = this.queue.splice(0);
            try {
                await http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
            } catch (e) { console.log('[Analytics] Send skipped'); }
        }
    };
    Analytics.init();

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

    var MAIN_URL = "https://www.5movierulz.pictures";

    function getMainUrl() {
        return Promise.resolve(MAIN_URL);
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
        if (/\b720p\b/.test(t)) return 720;
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
        var items = [];
        var seenHref = {};
        var pos = 0;

        while (true) {
            var idx1 = html.indexOf("boxed film", pos);
            var idx2 = html.indexOf("cont_display", pos);
            var idx3 = html.indexOf("movie-watch-online-free", pos);

            var cardIdx = -1;
            if (idx1 !== -1) cardIdx = idx1;
            if (idx2 !== -1 && (cardIdx === -1 || idx2 < cardIdx)) cardIdx = idx2;
            if (idx3 !== -1 && (cardIdx === -1 || idx3 < cardIdx)) cardIdx = idx3;

            if (cardIdx === -1) break;

            var aOpen = html.indexOf("<a", cardIdx);
            if (aOpen === -1 || aOpen > cardIdx + 300) {
                var prevA = html.lastIndexOf("<a", cardIdx);
                if (prevA !== -1 && cardIdx - prevA < 300) aOpen = prevA;
            }
            if (aOpen === -1) { pos = cardIdx + 12; continue; }

            var hrefIdx = html.indexOf('href="', aOpen);
            if (hrefIdx === -1 || hrefIdx > aOpen + 300) { pos = cardIdx + 12; continue; }
            var hrefStart = hrefIdx + 6;
            var hrefEnd = html.indexOf('"', hrefStart);
            if (hrefEnd === -1) { pos = cardIdx + 12; continue; }
            var href = html.substring(hrefStart, hrefEnd);

            if (!href || href === "#" || href.indexOf("javascript:") === 0 ||
                href.indexOf("/category/") !== -1 || href.indexOf("/language/") !== -1 ||
                href.indexOf("/quality/") !== -1 || href.indexOf("/genre/") !== -1 ||
                href.indexOf("/director/") !== -1 || href.indexOf("/actor/") !== -1) {
                pos = cardIdx + 12;
                continue;
            }

            var fullUrl = resolveUrl(href, mainUrl);
            if (seenHref[fullUrl]) { pos = cardIdx + 12; continue; }
            seenHref[fullUrl] = true;

            var aClose = html.indexOf("</a>", aOpen);

            var posterUrl = null;
            var imgIdx = html.indexOf("<img", aOpen);
            if (imgIdx !== -1 && (aClose === -1 || imgIdx < aClose + 500)) {
                var srcIdx = html.indexOf('src="', imgIdx);
                if (srcIdx !== -1) {
                    var srcStart = srcIdx + 5;
                    var srcEnd = html.indexOf('"', srcStart);
                    if (srcEnd !== -1) posterUrl = resolveUrl(html.substring(srcStart, srcEnd), mainUrl);
                }
            }

            var rawTitle = "";
            var titleAttrIdx = html.indexOf('title="', aOpen);
            if (titleAttrIdx !== -1 && (aClose === -1 || titleAttrIdx < aClose)) {
                var ts = titleAttrIdx + 7;
                var te = html.indexOf('"', ts);
                if (te !== -1) rawTitle = html.substring(ts, te);
            }
            if (!rawTitle && imgIdx !== -1) {
                var altIdx = html.indexOf('alt="', imgIdx);
                if (altIdx !== -1) {
                    var as = altIdx + 5;
                    var ae = html.indexOf('"', as);
                    if (ae !== -1) rawTitle = html.substring(as, ae);
                }
            }
            if (!rawTitle && aClose !== -1) {
                var bStart = html.indexOf("<b>", aClose);
                if (bStart !== -1 && bStart < aClose + 300) {
                    var bEnd = html.indexOf("</b>", bStart);
                    if (bEnd !== -1) rawTitle = html.substring(bStart + 3, bEnd);
                }
            }

            var title = cleanTitle(rawTitle);
            if (!title || title === "Unknown" || title.length < 3) {
                pos = Math.max(cardIdx + 12, aClose !== -1 ? aClose + 4 : cardIdx + 12);
                continue;
            }

            items.push({
                title: title,
                url: fullUrl,
                posterUrl: posterUrl,
                type: isSeries(rawTitle) ? "series" : "movie",
                quality: qualityOf(rawTitle),
                rawTitle: rawTitle
            });

            pos = Math.max(cardIdx + 12, aClose !== -1 ? aClose + 4 : cardIdx + 12);
        }

        log("parseMovieGrid: " + items.length + " items");
        return items;
    }

    function toMultimediaItems(items) {
        var result = [];
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            result.push(new MultimediaItem({
                title: item.title,
                url: item.url,
                posterUrl: item.posterUrl || undefined,
                type: item.type || "movie",
                quality: item.quality || 0
            }));
        }
        return result;
    }

    function getHome(cb) {
        getMainUrl().then(function(mainUrl) {
            log("getHome: " + mainUrl);
            return http_get(mainUrl + "/").then(function(res) {
                var html = res.body;

                function sliceSection(startText, endText) {
                    var lower = html.toLowerCase();
                    var s = lower.indexOf(startText.toLowerCase());
                    if (s === -1) return "";
                    var e = endText ? lower.indexOf(endText.toLowerCase(), s + startText.length) : html.length;
                    return html.substring(s, e === -1 ? html.length : e);
                }

                var featuredHtml = sliceSection("featured movies free", "latest movies");
                var latestHtml = sliceSection("latest movies", "posts navigation");

                log("featuredHtml: " + featuredHtml.length + "c  latestHtml: " + latestHtml.length + "c");

                var featuredItems = featuredHtml ? parseMovieGrid(featuredHtml, mainUrl) : [];
                var latestItems = latestHtml ? parseMovieGrid(latestHtml, mainUrl) : [];

                var featuredUrls = {};
                for (var i = 0; i < featuredItems.length; i++) featuredUrls[featuredItems[i].url] = true;
                var uniqueLatest = [];
                for (var j = 0; j < latestItems.length; j++) {
                    if (!featuredUrls[latestItems[j].url]) uniqueLatest.push(latestItems[j]);
                }

                var homeData = {};
                if (featuredItems.length) homeData["🔥 Featured"] = toMultimediaItems(featuredItems);
                if (uniqueLatest.length) homeData["🆕 Latest Movies"] = toMultimediaItems(uniqueLatest);

                if (!Object.keys(homeData).length) {
                    var allItems = parseMovieGrid(html, mainUrl);
                    if (allItems.length) homeData["Movies"] = toMultimediaItems(allItems);
                }

                log("getHome done: " + Object.keys(homeData).length + " sections");
                Analytics.logEvent('movierulz_home', {});
                cb({ success: true, data: homeData });
            });
        }).catch(function(e) {
            err("getHome:", e.message);
            cb({ success: false, errorCode: "HOME_ERROR", message: e.message });
        });
    }

    function search(query, cb) {
        getMainUrl().then(function(mainUrl) {
            var q = encodeURIComponent(query);
            var urls = [
                mainUrl + "/search_movies?s=" + q,
                mainUrl + "/?s=" + q,
                mainUrl + "/search/" + encodeURIComponent(query)
            ];
            return trySearchUrls(urls, 0, mainUrl);
        }).then(function(items) {
            Analytics.logEvent('movierulz_search', {});
            cb({ success: true, data: toMultimediaItems(items) });
        }).catch(function(e) {
            err("search:", e.message);
            cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message });
        });
    }

    function trySearchUrls(urls, i, mainUrl) {
        if (i >= urls.length) return Promise.resolve([]);
        log("search: " + urls[i]);
        return http_get(urls[i]).then(function(res) {
            var items = parseMovieGrid(res.body, mainUrl);
            log("search got: " + items.length + " items");
            if (items.length > 0) return items;
            return trySearchUrls(urls, i + 1, mainUrl);
        }).catch(function() {
            return trySearchUrls(urls, i + 1, mainUrl);
        });
    }

    function load(url, cb) {
        getMainUrl().then(function(mainUrl) {
            log("load: " + url);
            return http_get(url).then(function(res) {
                var html = res.body;

                // Title
                var rawTitle = "";
                var ets = html.indexOf('class="entry-title"');
                if (ets !== -1) {
                    var ete = html.indexOf(">", ets);
                    var etc = html.indexOf("</", ete);
                    if (ete !== -1 && etc !== -1) rawTitle = html.substring(ete + 1, etc);
                }
                if (!rawTitle) {
                    var h2s = html.indexOf("<h2");
                    if (h2s !== -1) {
                        var h2e = html.indexOf(">", h2s);
                        var h2c = html.indexOf("</h2>", h2e);
                        if (h2e !== -1 && h2c !== -1) rawTitle = html.substring(h2e + 1, h2c);
                    }
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
                var descPos = descStart;
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
                var magnets = [];
                var seenMag = {};
                var mpos = 0;

                while (true) {
                    var magIdx = html.indexOf('href="magnet:', mpos);
                    if (magIdx === -1) break;

                    var magStart = magIdx + 6;
                    var magEnd = html.indexOf('"', magStart);
                    if (magEnd === -1) break;

                    var magnetUrl = html.substring(magStart, magEnd);
                    if (seenMag[magnetUrl]) { mpos = magEnd + 1; continue; }
                    seenMag[magnetUrl] = true;

                    var aCloseIdx = html.indexOf("</a>", magEnd);
                    var buttonLabel = "";
                    if (aCloseIdx !== -1) {
                        var sizeIdx = html.indexOf('class="btn-size">', magEnd);
                        if (sizeIdx !== -1 && sizeIdx < aCloseIdx) {
                            var sizeEnd = html.indexOf("</span>", sizeIdx);
                            if (sizeEnd !== -1) {
                                buttonLabel = stripTags(html.substring(sizeIdx + 17, sizeEnd)).trim();
                            }
                        }
                        if (!buttonLabel) {
                            var smallIdx = html.indexOf("<small>", magEnd);
                            if (smallIdx !== -1 && smallIdx < aCloseIdx) {
                                var smallEnd = html.indexOf("</small>", smallIdx);
                                if (smallEnd !== -1) {
                                    buttonLabel = stripTags(html.substring(smallIdx + 7, smallEnd)).trim();
                                }
                            }
                        }
                    }

                    var dnMatch = magnetUrl.match(/[?&]dn=([^&]+)/i);
                    var dnName = dnMatch ? safeDecodeURI(dnMatch[1]) : "";
                    var quality = qualityOf(buttonLabel) || qualityOf(dnName);

                    log("  magnet: label=" + buttonLabel + " Q=" + quality);
                    magnets.push({ magnetUrl: magnetUrl, buttonLabel: buttonLabel, quality: quality });
                    mpos = magEnd + 1;
                }

                magnets.sort(function(a, b) { return b.quality - a.quality; });
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
                        magnetUrl: magnets[mi].magnetUrl,
                        buttonLabel: magnets[mi].buttonLabel,
                        quality: magnets[mi].quality
                    });
                }

                var episodes = [new Episode({
                    name: title,
                    url: JSON.stringify(magnetPayload)
                })];

                Analytics.logEvent('movierulz_load', {});
                cb({
                    success: true, data: new MultimediaItem({
                        title: title,
                        url: url,
                        posterUrl: posterUrl || undefined,
                        type: type,
                        description: description || undefined,
                        genres: genres,
                        cast: castActors,
                        episodes: episodes
                    })
                });
            });
        }).catch(function(e) {
            err("load:", e.message);
            cb({ success: false, errorCode: "LOAD_ERROR", message: e.message });
        });
    }

    // ALL magnets returned at once as StreamResults
    // User sees: [MovieRulz] 2.5 gb 1080p / [MovieRulz] 1.4 gb 720p / etc.
    function loadStreams(url, cb) {
        try {
            var parsed = JSON.parse(url);
            var entries = Array.isArray(parsed) ? parsed : [parsed];
            log("loadStreams: entries = " + entries.length);

            var results = [];
            for (var i = 0; i < entries.length; i++) {
                var entry = entries[i];
                var magnetUrl = entry.magnetUrl || "";
                var buttonLabel = entry.buttonLabel || "";
                var quality = entry.quality || 0;

                if (!magnetUrl || magnetUrl.indexOf("magnet:") !== 0) continue;

                var label = "[MovieRulz]" + (buttonLabel ? " " + buttonLabel : "");
                log("  stream: " + label + " " + quality + "p");

                results.push(new StreamResult({
                    url: magnetUrl,
                    quality: quality,
                    source: label,
                    headers: {}
                }));
            }

            if (!results.length) {
                warn("loadStreams: no valid magnets");
                return cb({ success: true, data: [] });
            }

            Analytics.logEvent('movierulz_loadstreams', {});
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
