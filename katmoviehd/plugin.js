(function () {
    var DEBUG = true;
    function log() { if (DEBUG) { var a = Array.prototype.slice.call(arguments); a.unshift("[KMH]"); console.log.apply(console, a); } }

    var BROWSER_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Referer": "https://katmoviehd.run/"
    };

    var DOMAINS = ["https://katmoviehd.run", "https://katmoviehd.co", "https://katmoviehd.fans"];
    var cachedDomain = null;

    function getDomain() {
        if (cachedDomain) return Promise.resolve(cachedDomain);
        return testDomain(0);
    }

    function testDomain(i) {
        if (i >= DOMAINS.length) return Promise.reject(new Error("No domain"));
        return http_get(DOMAINS[i] + "/", { headers: BROWSER_HEADERS }).then(function (res) {
            if (res.body && res.body.indexOf("katmoviehd") !== -1) {
                cachedDomain = DOMAINS[i];
                return cachedDomain;
            }
            return testDomain(i + 1);
        }).catch(function () { return testDomain(i + 1); });
    }

    function strip(s) {
        if (!s) return "";
        return s.replace(/<[^>]+>/g, "").replace(/&amp;/g, "&").replace(/&nbsp;/g, " ").replace(/\s+/g, " ").trim();
    }

    function getQ(t) {
        if (!t) return 0;
        t = t.toLowerCase();
        if (t.indexOf("2160p") !== -1 || t.indexOf("4k") !== -1) return 2160;
        if (t.indexOf("1080p") !== -1) return 1080;
        if (t.indexOf("720p") !== -1) return 720;
        if (t.indexOf("480p") !== -1) return 480;
        return 0;
    }

    function isMovie(h) {
        if (!h) return false;
        if (h.indexOf("/category/") !== -1) return false;
        if (h.indexOf("/tag/") !== -1) return false;
        if (h.indexOf("/page/") !== -1) return false;
        if (h.indexOf("/author/") !== -1) return false;
        if (h.indexOf("facebook.com") !== -1) return false;
        if (h.indexOf("twitter.com") !== -1) return false;
        if (h.indexOf("#") === 0) return false;
        return true;
    }

    function getHome(cb) {
        getDomain().then(function (d) {
            return http_get(d + "/", { headers: BROWSER_HEADERS });
        }).then(function (res) {
            var html = res.body;
            var items = [];
            var seen = {};
            var pos = 0;

            while (true) {
                var art = html.indexOf("<article", pos);
                if (art === -1) break;
                var end = html.indexOf("</article>", art);
                if (end === -1) end = art + 2000;

                var chunk = html.substring(art, end);
                var hm = chunk.match(/href="([^"]+)"/);
                if (!hm) { pos = end + 1; continue; }

                var href = hm[1];
                if (seen[href] || !isMovie(href)) { pos = end + 1; continue; }
                seen[href] = true;

                var title = "";
                var tm = chunk.match(/title="([^"]+)"/);
                if (tm) title = tm[1];
                else {
                    var hm2 = chunk.match(/<h[23][^>]*>(.*?)<\/h[23]>/);
                    if (hm2) title = strip(hm2[1]);
                }

                if (!title || title.length < 3) { pos = end + 1; continue; }

                var img = null;
                var im = chunk.match(/<img[^>]+src="([^"]+)"/);
                if (im) img = im[1];
                if (!img) {
                    var dm = chunk.match(/data-src="([^"]+)"/);
                    if (dm) img = dm[1];
                }

                items.push({
                    title: title.replace(/\s*\(.*?\)/g, "").trim(),
                    url: href.indexOf("http") === 0 ? href : cachedDomain + href,
                    posterUrl: img,
                    type: /season|episode/i.test(title) ? "series" : "movie",
                    quality: getQ(title)
                });

                pos = end + 1;
            }

            var sections = {};
            if (items.length > 0) {
                var feat = items.slice(0, Math.min(6, items.length));
                sections["\ud83d\udd25 Featured"] = feat.map(function(i) { return new MultimediaItem(i); });

                var rest = items.slice(6);
                if (rest.length > 0) {
                    sections["\ud83c\udd95 Latest"] = rest.map(function(i) { return new MultimediaItem(i); });
                }
            }

            cb({ success: true, data: sections });
        }).catch(function (e) { cb({ success: false, errorCode: "HOME_ERROR", message: e.message }); });
    }

    function search(q, cb) {
        getDomain().then(function (d) {
            return http_get(d + "/?s=" + encodeURIComponent(q), { headers: BROWSER_HEADERS });
        }).then(function (res) {
            var items = [];
            var seen = {};
            var html = res.body;
            var pos = 0;

            while (true) {
                var art = html.indexOf("<article", pos);
                if (art === -1) break;
                var end = html.indexOf("</article>", art);
                if (end === -1) end = art + 2000;

                var chunk = html.substring(art, end);
                var hm = chunk.match(/href="([^"]+)"/);
                if (!hm) { pos = end + 1; continue; }

                var href = hm[1];
                if (seen[href] || !isMovie(href)) { pos = end + 1; continue; }
                seen[href] = true;

                var title = "";
                var tm = chunk.match(/title="([^"]+)"/);
                if (tm) title = tm[1];
                else {
                    var hm2 = chunk.match(/<h[23][^>]*>(.*?)<\/h[23]>/);
                    if (hm2) title = strip(hm2[1]);
                }

                if (!title) { pos = end + 1; continue; }

                items.push(new MultimediaItem({
                    title: title,
                    url: href.indexOf("http") === 0 ? href : cachedDomain + href,
                    type: /season|episode/i.test(title) ? "series" : "movie"
                }));

                pos = end + 1;
            }

            cb({ success: true, data: items });
        }).catch(function (e) { cb({ success: false, errorCode: "SEARCH_ERROR", message: e.message }); });
    }

    function load(url, cb) {
        getDomain().then(function () {
            return http_get(url, { headers: BROWSER_HEADERS });
        }).then(function (res) {
            var html = res.body;

            var title = "";
            var h1m = html.match(/<h1[^>]*>(.*?)<\/h1>/is);
            if (h1m) title = strip(h1m[1]);

            var poster = null;
            var ogm = html.match(/<meta[^>]+property="og:image"[^>]+content="([^"]+)"/);
            if (ogm) poster = ogm[1];

            var eps = [];
            var seen = {};

            // Find quality links
            var am = html.match(/<a[^>]*href="([^"]+)"[^>]*>([\s\S]*?)<\/a>/gi);
            if (am) {
                for (var i = 0; i < am.length; i++) {
                    var m = am[i].match(/href="([^"]+)"/);
                    var tm = am[i].match(/>([\s\S]*?)<\/a>/);
                    if (!m || !tm) continue;

                    var href = m[1];
                    var text = strip(tm[1]).toLowerCase();

                    if (seen[href]) continue;
                    if (href.indexOf("#") === 0) continue;
                    if (href.indexOf("javascript:") !== -1) continue;
                    if (text.indexOf("share") !== -1) continue;
                    if (href.indexOf("facebook.com") !== -1) continue;

                    var q = 0;
                    var label = "";
                    if (text.indexOf("1080") !== -1 || href.indexOf("1080") !== -1) { q = 1080; label = "1080p"; }
                    else if (text.indexOf("720") !== -1 || href.indexOf("720") !== -1) { q = 720; label = "720p"; }
                    else if (text.indexOf("480") !== -1 || href.indexOf("480") !== -1) { q = 480; label = "480p"; }
                    else if (text.indexOf("2160") !== -1 || text.indexOf("4k") !== -1) { q = 2160; label = "4K"; }

                    if (q > 0 && (href.indexOf("links.kmhd") !== -1 || href.indexOf("katdrive") !== -1)) {
                        seen[href] = true;
                        eps.push(new Episode({
                            name: label + " Links",
                            url: JSON.stringify({ type: "intermediate", url: href, quality: q })
                        }));
                    }
                }
            }

            eps.sort(function(a, b) {
                var qa = JSON.parse(a.url).quality;
                var qb = JSON.parse(b.url).quality;
                return qb - qa;
            });

            cb({ success: true, data: new MultimediaItem({
                title: title || "Unknown",
                url: url,
                posterUrl: poster,
                type: /season|episode/i.test(title) ? "series" : "movie",
                episodes: eps
            })});
        }).catch(function (e) { cb({ success: false, errorCode: "LOAD_ERROR", message: e.message }); });
    }

    function loadStreams(url, cb) {
  try {
    var p = JSON.parse(url);
    log("Loading streams for quality:", p.quality);

    // Follow redirects properly
    http_get(p.url, { headers: BROWSER_HEADERS, followRedirects: true }).then(function (res) {
      var html = res.body;
      var results = [];
      var seen = {};

      // Method 1: Find images with hoster names in src (case-insensitive)
      var imgRe = /<img[^>]+src="([^\"]*(?:gdflix|hubcloud|mega|drive)[^\"]*)"[^>]*>/gi;
      var m;

      while ((m = imgRe.exec(html)) !== null) {
        var imgSrc = m[1].toLowerCase();
        var pos = m.index;

        // Look back for preceding anchor
        var before = html.substring(Math.max(0, pos - 1000), pos);
        var hrefMatch = before.match(/<a[^>]*href="([^\"]+)"[^>]*>/i);

        if (hrefMatch) {
          var linkUrl = hrefMatch[1];
          if (!seen[linkUrl] && linkUrl.indexOf("http") === 0) {
            seen[linkUrl] = true;

            // Extract hoster from imgSrc
            var hoster = "Unknown";
            if (imgSrc.includes("gdflix")) hoster = "GDFLix";
            else if (imgSrc.includes("hubcloud")) hoster = "HubCloud";
            else if (imgSrc.includes("mega")) hoster = "Mega";
            else if (imgSrc.includes("drive")) hoster = "Google Drive";

            // Extract quality from anchor text if available
            var quality = null;
            var textMatch = before.match(/>([\s\S]+?)<\/a>/i);
            if (textMatch) {
              var anchorText = textMatch[1].toLowerCase();
              quality = extractQuality(anchorText);
            }

            results.push(new StreamResult({
              url: linkUrl,
              quality: quality || p.quality,
              source: hoster,
              headers: BROWSER_HEADERS
            }));
            log("Found:", hoster, "->", linkUrl.substring(0, 50) + "...");
          }
        }
      }

      // Method 2: Check anchor text for hoster + quality indicators
      if (results.length === 0) {
        log("Method 1 found nothing, trying method 2...");
        var aRe = /<a[^>]*href="([^\"]+)"[^>]*>([\s\S]*?)<\/a>/gi;

        while ((m = aRe.exec(html)) !== null) {
          var h = m[1];
          var c = m[2].toLowerCase();

          if (h.indexOf("http") !== 0) continue;
          if (seen[h]) continue;

          var quality = extractQuality(c);
          if (quality) {
            var hoster = "Unknown";
            if (c.includes("gdflix")) hoster = "GDFLix";
            else if (c.includes("hubcloud")) hoster = "HubCloud";

            results.push(new StreamResult({
              url: h,
              quality: quality,
              source: hoster,
              headers: BROWSER_HEADERS
            }));
            log("Found:", hoster, "(", quality, ") ->", h.substring(0, 50) + "...");
          }
        }
      }

      // Fallback method if both above fail
      if (results.length === 0) {
        log("Method 2 found nothing, trying method 3...");
        var urlRe = /href="(https?:\/\/([^\"]*?(?:gdflix|hubcloud|mega\.nz)[^\"]*))"/gi;
        while ((m = urlRe.exec(html)) !== null) {
          var u = m[1];
          if (seen[u]) continue;
          seen[u] = true;
          var host = u.includes("gdflix") ? "GDFLix" : (u.includes("hubcloud") ? "HubCloud" : "Unknown");
          results.push(new StreamResult({
            url: u,
            quality: p.quality,
            source: host,
            headers: BROWSER_HEADERS
          }));
        }
      }

      log("Total streams:", results.length);
      cb({ success: true, data: results });
    }).catch(function (e) {
      log("Error:", e.message);
      cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
    });
  } catch (e) {
    cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
  }
}

// Helper to extract quality
function extractQuality(txt) {
  if (!txt) return null;
  if (txt.includes("2160") || txt.includes("4k")) return 2160;
  if (txt.includes("1080")) return 1080;
  if (txt.includes("720")) return 720;
  if (txt.includes("480")) return 480;
  return null;
}
        try {
            var p = JSON.parse(url);
            log("Loading streams for quality:", p.quality);

            http_get(p.url, { headers: BROWSER_HEADERS }).then(function (res) {
                var html = res.body;
                var results = [];
                var seen = {};

                // METHOD 1: Find images with hoster names, get preceding anchor
                // This handles: <a href="LINK"><img src="...gdflix..."/></a>
                var imgRe = /<img[^>]+src="([^"]*(?:gdflix|hubcloud|mega|drive)[^"]*)"[^>]*>/gi;
                var m;
                while ((m = imgRe.exec(html)) !== null) {
                    var imgSrc = m[1];
                    var pos = m.index;

                    // Look back for <a ...>
                    var before = html.substring(Math.max(0, pos - 800), pos);
                    var hrefMatch = before.match(/<a[^>]*href="([^"]+)"[^>]*>[^<]*$/i);

                    if (hrefMatch) {
                        var linkUrl = hrefMatch[1];
                        if (!seen[linkUrl] && linkUrl.indexOf("http") === 0) {
                            seen[linkUrl] = true;

                            var hoster = "Unknown";
                            if (imgSrc.toLowerCase().indexOf("gdflix") !== -1) hoster = "GDFLix";
                            else if (imgSrc.toLowerCase().indexOf("hubcloud") !== -1) hoster = "HubCloud";
                            else if (imgSrc.toLowerCase().indexOf("mega") !== -1) hoster = "Mega";
                            else if (imgSrc.toLowerCase().indexOf("drive") !== -1 || imgSrc.toLowerCase().indexOf("google") !== -1) hoster = "Google Drive";

                            results.push(new StreamResult({
                                url: linkUrl,
                                quality: p.quality,
                                source: hoster,
                                headers: BROWSER_HEADERS
                            }));
                            log("Found:", hoster, "->", linkUrl.substring(0, 50) + "...");
                        }
                    }
                }

                // METHOD 2: If no results, scan all <a> tags for images with hoster names
                if (results.length === 0) {
                    log("Method 1 found nothing, trying method 2...");
                    var aRe = /<a[^>]*href="([^"]+)"[^>]*>([\s\S]*?)<\/a>/gi;
                    while ((m = aRe.exec(html)) !== null) {
                        var h = m[1];
                        var c = m[2].toLowerCase();

                        if (h.indexOf("http") !== 0) continue;
                        if (seen[h]) continue;

                        if (c.indexOf("gdflix") !== -1 || c.indexOf("hubcloud") !== -1 || c.indexOf("mega") !== -1) {
                            seen[h] = true;
                            var host = c.indexOf("gdflix") !== -1 ? "GDFLix" : (c.indexOf("hubcloud") !== -1 ? "HubCloud" : "Mega");
                            results.push(new StreamResult({
                                url: h,
                                quality: p.quality,
                                source: host,
                                headers: BROWSER_HEADERS
                            }));
                        }
                    }
                }

                // METHOD 3: Direct URL pattern matching in entire HTML
                if (results.length === 0) {
                    log("Method 2 found nothing, trying method 3...");
                    var urlRe = /href="(https?:\/\/(?:www\.)?(?:gdflix|hubcloud|mega\.nz)\.[^"]+)"/gi;
                    while ((m = urlRe.exec(html)) !== null) {
                        var u = m[1];
                        if (seen[u]) continue;

                        seen[u] = true;
                        var host = "Unknown";
                        if (u.indexOf("gdflix") !== -1) host = "GDFLix";
                        else if (u.indexOf("hubcloud") !== -1) host = "HubCloud";
                        else if (u.indexOf("mega.nz") !== -1) host = "Mega";

                        results.push(new StreamResult({
                            url: u,
                            quality: p.quality,
                            source: host,
                            headers: BROWSER_HEADERS
                        }));
                    }
                }

                log("Total streams:", results.length);
                cb({ success: true, data: results });
            }).catch(function (e) {
                log("Error:", e.message);
                cb({ success: false, errorCode: "STREAM_ERROR", message: e.message });
            });
        } catch (e) {
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
})();
