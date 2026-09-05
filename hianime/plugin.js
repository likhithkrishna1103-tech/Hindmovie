(function () {
  "use strict";

  // ========== GA Tracker ==========
  function base64Decode(str) {
    var chars =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var output = "";
    var bytes = [];
    var strClean = String(str || "").replace(/[^A-Za-z0-9+/=]/g, "");
    for (var i = 0; i < strClean.length; i += 4) {
      var a = chars.indexOf(strClean[i]);
      var b = chars.indexOf(strClean[i + 1] || "=");
      var c = chars.indexOf(strClean[i + 2] || "=");
      var d = chars.indexOf(strClean[i + 3] || "=");
      bytes.push((a << 2) | (b >> 4));
      if (c !== -1 && strClean[i + 2] !== "=") {
        bytes.push(((b & 15) << 4) | (c >> 2));
      }
      if (d !== -1 && strClean[i + 3] !== "=") {
        bytes.push(((c & 3) << 6) | d);
      }
    }
    for (var j = 0; j < bytes.length; j++) {
      output += String.fromCharCode(bytes[j]);
    }
    return output;
  }

  var GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
  var GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

  var SessionTracker = {
    clientId: null,
    init: function () {
      this.clientId = this.generateUuid();
    },
    generateUuid: function () {
      return "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(
        /[xy]/g,
        function (c) {
          var r = (Math.random() * 16) | 0;
          return (c === "x" ? r : (r & 0x3) | 0x8).toString(16);
        }
      );
    },
  };
  SessionTracker.init();

  var Analytics = {
    clientId: null,
    measurementId: GA_MEASUREMENT_ID,
    apiSecret: GA_API_SECRET,
    queue: [],
    init: function () {
      this.clientId = SessionTracker.clientId;
    },
    logEvent: function (eventName, parameters) {
      if (!this.measurementId || !this.apiSecret) return;
      this.queue.push({
        name: eventName,
        params: Object.assign({ session_id: this.clientId }, parameters || {}),
      });
      this.flushQueue();
    },
    flushQueue: function () {
      if (this.queue.length === 0) return;
      var events = this.queue.splice(0);
      try {
        if (typeof http_post === "function") {
          http_post(
            "https://www.google-analytics.com/mp/collect?measurement_id=" +
              this.measurementId +
              "&api_secret=" +
              this.apiSecret,
            { "Content-Type": "application/json" },
            JSON.stringify({ client_id: this.clientId, events: events })
          );
        }
      } catch (_) {}
    },
  };
  Analytics.init();

  // ========== Config ==========
  var BASE_URL =
    typeof manifest !== "undefined" && manifest && manifest.baseUrl
      ? manifest.baseUrl.replace(/\/+$/, "")
      : "https://hianime.at";

  var USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";

  var HEADERS = {
    "User-Agent": USER_AGENT,
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Referer": BASE_URL + "/",
  };

  var AJAX_HEADERS = {
    "User-Agent": USER_AGENT,
    "Accept": "application/json, text/javascript, */*; q=0.01",
    "X-Requested-With": "XMLHttpRequest",
    "Referer": BASE_URL + "/",
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
      .replace(/&nbsp;/g, " ");
  }

  function cleanText(value) {
    return decodeHtml(String(value || "")
      .replace(/<br\s*\/?>/gi, "\n")
      .replace(/<[^>]+>/g, " "))
      .replace(/\s+/g, " ")
      .trim();
  }

  function parseJsonSafe(value, fallback) {
    if (value && typeof value === "object") return value;
    try {
      return JSON.parse(String(value || ""));
    } catch (_) {
      return fallback !== undefined ? fallback : {};
    }
  }

  function uniqueBy(list, keyFn) {
    var out = [];
    var seen = Object.create(null);
    for (var i = 0; i < (list || []).length; i++) {
      var key = keyFn(list[i]);
      if (!key || seen[key]) continue;
      seen[key] = true;
      out.push(list[i]);
    }
    return out;
  }

  function absoluteUrl(path) {
    path = trim(path);
    if (!path) return "";
    if (/^https?:\/\//i.test(path)) return path;
    if (path.indexOf("//") === 0) return "https:" + path;
    if (path.indexOf("/") === 0) return BASE_URL + path;
    return BASE_URL + "/" + path;
  }

  function resolveUrl(base, relative) {
    if (!relative) return base;
    if (relative.indexOf("http") === 0) return relative;
    if (relative.indexOf("//") === 0) return "https:" + relative;
    if (relative.indexOf("/") === 0) {
      var protoEnd = base.indexOf("://") + 3;
      var hostEnd = base.indexOf("/", protoEnd);
      if (hostEnd === -1) hostEnd = base.length;
      return base.slice(0, hostEnd) + relative;
    }
    var slashIdx = base.lastIndexOf("/");
    return (slashIdx > 8 ? base.slice(0, slashIdx + 1) : base + "/") + relative;
  }

  function parseHlsVariants(m3u8Content, baseUrl) {
    if (!m3u8Content || m3u8Content.indexOf("#EXTM3U") === -1) return null;
    var variants = [];
    var lines = m3u8Content.split("\n");
    var currentInf = null;
    var hasStreamInf = false;

    for (var i = 0; i < lines.length; i++) {
      var line = lines[i].trim();
      if (line.indexOf("#EXT-X-STREAM-INF") === 0) {
        hasStreamInf = true;
        var resMatch = line.match(/RESOLUTION=(\d+)x(\d+)/);
        var bwMatch = line.match(/[^-]BANDWIDTH=(\d+)\b/);
        currentInf = {
          height: resMatch ? parseInt(resMatch[2], 10) : 0,
          width: resMatch ? parseInt(resMatch[1], 10) : 0,
          bandwidth: bwMatch ? parseInt(bwMatch[1], 10) : 0,
        };
      } else if (line.indexOf("#") === 0 || line.length === 0) {
        continue;
      } else if (currentInf) {
        var vUrl = line;
        if (vUrl.indexOf("http") !== 0) vUrl = resolveUrl(baseUrl, vUrl);
        var label = "";
        if (currentInf.height >= 2160) label = "4K";
        else if (currentInf.height >= 1080) label = "1080p";
        else if (currentInf.height >= 720) label = "720p";
        else if (currentInf.height >= 480) label = "480p";
        else if (currentInf.height >= 360) label = "360p";
        else label = currentInf.height + "p";

        variants.push({
          url: vUrl,
          height: currentInf.height,
          bandwidth: currentInf.bandwidth,
          label: label,
        });
        currentInf = null;
      }
    }

    variants.sort(function (a, b) {
      return b.height - a.height;
    });
    return variants.length > 0 && hasStreamInf ? variants : null;
  }

  function responseStatus(res) {
    if (!res) return 0;
    if (typeof res.status === "number") return res.status;
    if (typeof res.statusCode === "number") return res.statusCode;
    return 0;
  }

  async function httpParallelGet(requests) {
    var items = Array.isArray(requests)
      ? requests.filter(function (item) {
          return item && item.url;
        })
      : [];
    if (!items.length) return [];
    if (typeof http_parallel === "function") {
      try {
        var parallelRes = await http_parallel(
          items.map(function (item) {
            return {
              method: "GET",
              url: item.url,
              headers: item.headers || HEADERS,
            };
          })
        );
        return items.map(function (item, index) {
          var res = parallelRes && parallelRes[index];
          return {
            status: responseStatus(res) || 200,
            body: String((res && (res.body || res.text || "")) || ""),
            headers: (res && res.headers) || {},
            url: (res && (res.url || res.finalUrl)) || item.url,
          };
        });
      } catch (_) {}
    }
    return await Promise.all(
      items.map(function (item) {
        return http_get(item.url, item.headers || HEADERS)
          .then(function (res) {
            return {
              status: responseStatus(res) || 200,
              body: String((res && (res.body || res.text || "")) || ""),
              headers: (res && res.headers) || {},
              url: (res && (res.url || res.finalUrl)) || item.url,
            };
          })
          .catch(function () {
            return { status: 599, body: "", headers: {}, url: item.url };
          });
      })
    );
  }

  // ========== Card Parsers ==========
  function parseSliderCards(html) {
    var items = [];
    var slideRegex = /<div\s+class=["']deslide-item["']>([\s\S]*?)<div\s+class=["']clearfix["']><\/div>\s*<\/div>/gi;
    var match;

    while ((match = slideRegex.exec(html)) !== null) {
      var block = match[1];

      var titleMatch =
        block.match(/class=["']desi-head-title[^>]*>([\s\S]*?)<\/div>/i) ||
        block.match(/data-jname=["']([^"']+)["']/i);
      var linkMatch =
        block.match(/<a\s+href=["']([^"']+)["'][^>]*class=["'][^"']*btn-secondary/i) ||
        block.match(/<a\s+href=["']([^"']+)["'][^>]*class=["'][^"']*btn-primary/i);
      var imgMatch =
        block.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["'][^>]*class=["'][^"']*film-poster-img/i) ||
        block.match(/<img[^>]+class=["'][^"']*film-poster-img[^>]+(?:data-src|src)=["']([^"']+)["']/i) ||
        block.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
      var descMatch = block.match(/class=["']desi-description["']>([\s\S]*?)<\/div>/i);
      var isMovie = /<i[^>]*class=["'][^"']*fa-play-circle[^>]*><\/i>\s*Movie/i.test(block);

      if (titleMatch && linkMatch) {
        var title = cleanText(titleMatch[1]);
        var url = absoluteUrl(linkMatch[1]);
        var poster = imgMatch ? absoluteUrl(imgMatch[1]) : "";
        var desc = descMatch ? cleanText(descMatch[1]) : "";

        items.push(
          new MultimediaItem({
            title: title,
            url: url,
            posterUrl: poster,
            bannerUrl: poster,
            type: isMovie ? "movie" : "anime",
            description: desc,
            headers: HEADERS,
          })
        );
      }
    }
    return uniqueBy(items, function (item) {
      return item.url;
    });
  }

  function parseFlwCards(html) {
    var items = [];
    var cardRegex = /<div\s+class=["']flw-item\b[^"']*["']>([\s\S]*?)<div\s+class=["']clearfix["']><\/div>\s*<\/div>/gi;
    var match;

    while ((match = cardRegex.exec(html)) !== null) {
      var cardHtml = match[1];

      var linkMatch =
        cardHtml.match(/<h3\s+class=["']film-name["']>\s*<a\s+href=["']([^"']+)["']/i) ||
        cardHtml.match(/<a\s+href=["']([^"']+)["'][^>]*class=["'][^"']*film-poster-ahref/i) ||
        cardHtml.match(/<a\s+href=["']([^"']+)["']/i);
      var titleMatch =
        cardHtml.match(/<h3\s+class=["']film-name["']>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>/i) ||
        cardHtml.match(/title=["']([^"']+)["']/i) ||
        cardHtml.match(/alt=["']([^"']+)["']/i);
      var imgMatch = cardHtml.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
      var isMovie = /<span\s+class=["']fdi-item["']>\s*Movie\s*<\/span>/i.test(cardHtml);

      if (linkMatch && titleMatch) {
        var url = absoluteUrl(linkMatch[1]);
        var title = cleanText(titleMatch[1]);
        var poster = imgMatch ? absoluteUrl(imgMatch[1]) : "";

        items.push(
          new MultimediaItem({
            title: title,
            url: url,
            posterUrl: poster,
            type: isMovie ? "movie" : "anime",
            headers: HEADERS,
          })
        );
      }
    }
    return uniqueBy(items, function (item) {
      return item.url;
    });
  }

  function parseAnifCards(ulHtml) {
    var items = [];
    var liRegex = /<li>([\s\S]*?)<\/li>/gi;
    var match;

    while ((match = liRegex.exec(ulHtml)) !== null) {
      var liHtml = match[1];

      var linkMatch =
        liHtml.match(/<h3\s+class=["']film-name["']>\s*<a\s+href=["']([^"']+)["']/i) ||
        liHtml.match(/<a\s+href=["']([^"']+)["']/i);
      var titleMatch =
        liHtml.match(/<h3\s+class=["']film-name["']>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>/i) ||
        liHtml.match(/title=["']([^"']+)["']/i);
      var imgMatch = liHtml.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);
      var isMovie = /<span\s+class=["']fdi-item["']>\s*Movie\s*<\/span>/i.test(liHtml);

      if (linkMatch && titleMatch) {
        var url = absoluteUrl(linkMatch[1]);
        var title = cleanText(titleMatch[1]);
        var poster = imgMatch ? absoluteUrl(imgMatch[1]) : "";

        items.push(
          new MultimediaItem({
            title: title,
            url: url,
            posterUrl: poster,
            type: isMovie ? "movie" : "anime",
            headers: HEADERS,
          })
        );
      }
    }
    return uniqueBy(items, function (item) {
      return item.url;
    });
  }

  function parseTrendingBar(html) {
    var items = [];
    var itemRegex = /<div\s+class=["']item["']>([\s\S]*?)<div\s+class=["']clearfix["']><\/div>\s*<\/div>/gi;
    var match;

    while ((match = itemRegex.exec(html)) !== null) {
      var block = match[1];
      var titleMatch =
        block.match(/class=["']film-title[^>]*>([\s\S]*?)<\/div>/i) ||
        block.match(/title=["']([^"']+)["']/i);
      var linkMatch = block.match(/<a\s+href=["']([^"']+)["']/i);
      var imgMatch = block.match(/<img[^>]+(?:data-src|src)=["']([^"']+)["']/i);

      if (titleMatch && linkMatch) {
        items.push(
          new MultimediaItem({
            title: cleanText(titleMatch[1]),
            url: absoluteUrl(linkMatch[1]),
            posterUrl: imgMatch ? absoluteUrl(imgMatch[1]) : "",
            type: "anime",
            headers: HEADERS,
          })
        );
      }
    }
    return items;
  }

  // ========== Core API Functions ==========

  /**
   * Loads the home screen categories.
   * @param {(res: Object) => void} cb
   */
  async function getHome(cb) {
    try {
      var res = await http_get(BASE_URL + "/home", HEADERS);
      var html = String((res && (res.body || res.text)) || "");
      if (!html) {
        return cb({
          success: false,
          errorCode: "GET_HOME_ERROR",
          message: "Empty response from home page",
        });
      }

      var pageData = {};

      // 1. Trending / Hero Carousel
      var sliderItems = parseSliderCards(html);
      if (sliderItems.length > 0) {
        pageData["Trending"] = sliderItems;
      } else {
        var trendingBarItems = parseTrendingBar(html);
        if (trendingBarItems.length > 0) {
          pageData["Trending"] = trendingBarItems;
        }
      }

      // 2. Anif Blocks (Top Airing, Most Popular, Most Favorite, Latest Completed)
      var anifBlockRegex = /<div\s+class=["']anif-block-header["']>([\s\S]*?)<\/div>[\s\S]*?<ul\s+class=["']ulclear["']>([\s\S]*?)<\/ul>/gi;
      var bMatch;
      while ((bMatch = anifBlockRegex.exec(html)) !== null) {
        var catName = cleanText(bMatch[1]);
        var cards = parseAnifCards(bMatch[2]);
        if (catName && cards.length > 0) {
          pageData[catName] = cards;
        }
      }

      // 3. Grid Sections (Latest Episode, New On HiAnime, Top Upcoming)
      var sectionRegex = /<section\s+class=["']block_area[^"']*["']>([\s\S]*?)<\/section>/gi;
      var secMatch;
      while ((secMatch = sectionRegex.exec(html)) !== null) {
        var secContent = secMatch[1];
        var headingMatch = secContent.match(/<h2\s+class=["']cat-heading["']>([\s\S]*?)<\/h2>/i);
        if (!headingMatch) continue;
        var hName = cleanText(headingMatch[1]);
        if (hName === "Trending" || hName === "Genres" || hName === "Top 10") {
          continue;
        }
        var gCards = parseFlwCards(secContent);
        if (gCards.length > 0) {
          pageData[hName] = gCards;
        }
      }

      Analytics.logEvent("hianime_home", { sections: Object.keys(pageData).length });
      cb({ success: true, data: pageData });
    } catch (e) {
      cb({ success: false, errorCode: "GET_HOME_ERROR", message: e.stack || String(e) });
    }
  }

  /**
   * Searches for media items.
   * @param {string} query
   * @param {(res: Object) => void} cb
   */
  async function search(query, cb) {
    try {
      var searchUrl = BASE_URL + "/browse?keyword=" + encodeURIComponent(query);
      var res = await http_get(searchUrl, HEADERS);
      var html = String((res && (res.body || res.text)) || "");

      var items = parseFlwCards(html);

      Analytics.logEvent("hianime_search", { query: query, count: items.length });
      cb({ success: true, data: items });
    } catch (e) {
      cb({ success: false, errorCode: "SEARCH_ERROR", message: e.stack || String(e) });
    }
  }

  /**
   * Loads details and episode list for a specific anime.
   * @param {string} url
   * @param {(res: Object) => void} cb
   */
  async function load(url, cb) {
    try {
      var cleanUrl = String(url || "").split("?")[0].replace(/\/+$/, "");
      var slug = cleanUrl.split("/").pop();

      // Extract animeId from slug (e.g. attack-on-titan-240 -> 240)
      var idMatch = slug.match(/-(\d+)$/);
      var animeId = idMatch ? idMatch[1] : null;

      var detailUrl = BASE_URL + "/" + slug;
      var detailRequests = [{ url: detailUrl, headers: HEADERS }];
      if (animeId) {
        detailRequests.push({
          url: BASE_URL + "/api/theme/episode/list/" + animeId,
          headers: AJAX_HEADERS,
        });
      }

      var responses = await httpParallelGet(detailRequests);
      var detailHtml = responses[0] ? responses[0].body : "";

      if (!animeId) {
        var metaIdMatch =
          detailHtml.match(/<meta[^>]+name=["']hi-anime-id["'][^>]+content=["'](\d+)["']/i) ||
          detailHtml.match(/data-anime-id=["'](\d+)["']/i) ||
          detailHtml.match(/data-id=["'](\d+)["']/i);
        if (metaIdMatch) {
          animeId = metaIdMatch[1];
          var epRes = await http_get(
            BASE_URL + "/api/theme/episode/list/" + animeId,
            AJAX_HEADERS
          );
          responses[1] = {
            body: String((epRes && (epRes.body || epRes.text)) || ""),
          };
        }
      }

      // 1. Metadata Extraction
      var titleMatch =
        detailHtml.match(/<h2\s+class=["']film-name[^>]*>([\s\S]*?)<\/h2>/i) ||
        detailHtml.match(/<meta\s+property=["']og:title["']\s+content=["']([^"']+)["']/i);
      var title = titleMatch ? cleanText(titleMatch[1]) : slug;

      var posterMatch =
        detailHtml.match(/<div\s+class=["']film-poster["']>[\s\S]*?<img[^>]+src=["']([^"']+)["']/i) ||
        detailHtml.match(/<meta\s+property=["']og:image["']\s+content=["']([^"']+)["']/i);
      var posterUrl = posterMatch ? absoluteUrl(posterMatch[1]) : "";

      var bannerMatch = detailHtml.match(/class=["']anis-cover["'][^>]*style=["'][^"']*url\(([^)]+)\)/i);
      var bannerUrl = bannerMatch
        ? absoluteUrl(bannerMatch[1].replace(/['"]/g, ""))
        : posterUrl;

      var descMatch =
        detailHtml.match(/<div\s+class=["']film-description[^>]*>[\s\S]*?<div\s+class=["']text["']>([\s\S]*?)<\/div>/i) ||
        detailHtml.match(/<meta\s+property=["']og:description["']\s+content=["']([^"']+)["']/i);
      var description = descMatch ? cleanText(descMatch[1]) : "";

      var scoreMatch = detailHtml.match(/<span\s+class=["']item-head["']>MAL Score:<\/span>[\s\S]*?<span\s+class=["']name["']>([\s\S]*?)<\/span>/i);
      var score = scoreMatch ? parseFloat(cleanText(scoreMatch[1])) || 0 : 0;

      var durMatch = detailHtml.match(/<span\s+class=["']item-head["']>Duration:<\/span>[\s\S]*?<span\s+class=["']name["']>([\s\S]*?)<\/span>/i);
      var duration = 0;
      if (durMatch) {
        var durNum = durMatch[1].match(/(\d+)/);
        if (durNum) duration = parseInt(durNum[1], 10);
      }

      var statusMatch = detailHtml.match(/<span\s+class=["']item-head["']>Status:<\/span>[\s\S]*?<span\s+class=["']name["']>([\s\S]*?)<\/span>/i);
      var statusStr = statusMatch ? cleanText(statusMatch[1]).toLowerCase() : "";
      var status = "ongoing";
      if (statusStr.indexOf("finish") !== -1 || statusStr.indexOf("complete") !== -1) {
        status = "completed";
      }

      var yearMatch = detailHtml.match(/<span\s+class=["']item-head["']>Aired:<\/span>[\s\S]*?<span\s+class=["']name["']>[\s\S]*?(\d{4})/i);
      var year = yearMatch ? parseInt(yearMatch[1], 10) : 0;

      var isMovie = /<span\s+class=["']item["']>\s*Movie\s*<\/span>/i.test(detailHtml) ||
        cleanUrl.indexOf("/movie") !== -1;

      // Genres
      var genres = [];
      var genresMatch = detailHtml.match(/<span\s+class=["']item-head["']>Genres:<\/span>([\s\S]*?)<\/div>/i);
      if (genresMatch) {
        var gLinkRegex = /<a[^>]*>([\s\S]*?)<\/a>/gi;
        var gm;
        while ((gm = gLinkRegex.exec(genresMatch[1])) !== null) {
          var gName = cleanText(gm[1]);
          if (gName) genres.push(gName);
        }
      }

      // Rating (e.g. PG-13, R)
      var ratingMatch = detailHtml.match(/<div\s+class=["']tick-item tick-pg["']>([\s\S]*?)<\/div>/i);
      var contentRating = ratingMatch ? cleanText(ratingMatch[1]) : "";

      // Cast
      var cast = [];
      var bacRegex = /<div\s+class=["']bac-item["']>([\s\S]*?)<div\s+class=["']clearfix["']><\/div>\s*<\/div>/gi;
      var cm;
      while ((cm = bacRegex.exec(detailHtml)) !== null) {
        var bacHtml = cm[1];
        var actorNameMatch =
          bacHtml.match(/class=["']pi-detail["']>[\s\S]*?<h4\s+class=["']pi-name["']>[\s\S]*?<a[^>]*>([\s\S]*?)<\/a>/i) ||
          bacHtml.match(/class=["']pi-name["']>([\s\S]*?)<\/h4>/i);
        var actorRoleMatch = bacHtml.match(/class=["']pi-cast["']>([\s\S]*?)<\/span>/i);
        var actorImgMatch = bacHtml.match(/<img[^>]+src=["']([^"']+)["']/i);
        if (actorNameMatch) {
          cast.push(
            new Actor({
              name: cleanText(actorNameMatch[1]),
              role: actorRoleMatch ? cleanText(actorRoleMatch[1]) : "",
              image: actorImgMatch ? absoluteUrl(actorImgMatch[1]) : "",
            })
          );
        }
      }

      // Check if anime has dub
      var hasDub = /class=["']tick-item tick-dub["']/i.test(detailHtml) ||
        /class=["'][^"']*servers-dub/i.test(detailHtml);

      // 2. Parse Episodes
      var allEpisodes = [];
      var epJsonRaw = responses[1] ? responses[1].body : "";
      var epJson = parseJsonSafe(epJsonRaw, {});
      var epListHtml = epJson.html || epJsonRaw || "";

      var epItemRegex = /<a\s+[^>]*class=["'][^"']*ep-item[^"']*["'][^>]*>([\s\S]*?)<\/a>/gi;
      var em;
      while ((em = epItemRegex.exec(epListHtml)) !== null) {
        var epTag = em[0];
        var innerHtml = em[1];

        var epNumMatch = epTag.match(/data-number=["'](\d+)["']/i);
        var epIdMatch = epTag.match(/data-id=["'](\d+)["']/i);
        var epTitleMatch =
          epTag.match(/title=["']([^"']+)["']/i) ||
          innerHtml.match(/class=["']ep-name[^>]*title=["']([^"']+)["']/i) ||
          innerHtml.match(/class=["']ep-name[^>]*>([\s\S]*?)<\/div>/i);

        if (epIdMatch) {
          var epNum = epNumMatch ? parseInt(epNumMatch[1], 10) : 1;
          var epId = epIdMatch[1];
          var epName = epTitleMatch ? cleanText(epTitleMatch[1]) : "Episode " + epNum;

          // Sub episode
          allEpisodes.push(
            new Episode({
              name: epName,
              url: BASE_URL + "/watch/" + slug + "?ep=" + epId + "&type=sub",
              season: 1,
              episode: epNum,
              dubStatus: "sub",
              posterUrl: posterUrl,
              headers: HEADERS,
            })
          );

          // Dub episode
          if (hasDub) {
            allEpisodes.push(
              new Episode({
                name: epName,
                url: BASE_URL + "/watch/" + slug + "?ep=" + epId + "&type=dub",
                season: 1,
                episode: epNum,
                dubStatus: "dub",
                posterUrl: posterUrl,
                headers: HEADERS,
              })
            );
          }
        }
      }

      var item = new MultimediaItem({
        title: title,
        url: detailUrl,
        posterUrl: posterUrl,
        bannerUrl: bannerUrl,
        type: isMovie ? "movie" : "anime",
        description: description,
        score: score,
        duration: duration,
        status: status,
        year: year,
        tags: genres,
        contentRating: contentRating,
        cast: cast,
        episodes: allEpisodes,
        headers: HEADERS,
      });

      Analytics.logEvent("hianime_load", { title: title, episodes: allEpisodes.length });
      cb({ success: true, data: item });
    } catch (e) {
      cb({ success: false, errorCode: "LOAD_ERROR", message: e.stack || String(e) });
    }
  }

  // ========== Stream Decryption & Extraction ==========
  var OBF_KEY = "otaku-embed-v1";

  function deobfuscateZoko(blob) {
    try {
      var raw = base64Decode(blob);
      var out = "";
      for (var i = 0; i < raw.length; i++) {
        out += String.fromCharCode(
          raw.charCodeAt(i) ^ OBF_KEY.charCodeAt(i % OBF_KEY.length)
        );
      }
      return JSON.parse(decodeURIComponent(escape(out)));
    } catch (_) {
      return null;
    }
  }

  /**
   * Resolves playable streams for an episode.
   * @param {string} url
   * @param {(res: Object) => void} cb
   */
  async function loadStreams(url, cb) {
    try {
      var urlStr = String(url || "");

      // Extract episode ID & sub/dub preference from URL
      var epMatch = urlStr.match(/[?&]ep=(\d+)/i);
      var typeMatch = urlStr.match(/[?&]type=(sub|dub)/i);
      var requestedType = typeMatch ? typeMatch[1].toLowerCase() : "sub";
      var episodeId = epMatch ? epMatch[1] : null;

      if (!episodeId) {
        var pageRes = await http_get(urlStr, HEADERS);
        var pageBody = String((pageRes && (pageRes.body || pageRes.text)) || "");
        var pageEpMatch = pageBody.match(/data-id=["'](\d+)["']/i);
        if (pageEpMatch) {
          episodeId = pageEpMatch[1];
        }
      }

      if (!episodeId) {
        return cb({
          success: false,
          errorCode: "STREAM_ERROR",
          message: "Could not find episode ID from URL: " + urlStr,
        });
      }

      // Fetch servers list for this episode
      var serversRes = await http_get(
        BASE_URL + "/api/theme/episode/servers?episodeId=" + episodeId,
        AJAX_HEADERS
      );
      var serversJson = parseJsonSafe(serversRes && (serversRes.body || serversRes.text), {});
      var serversHtml = serversJson.html || "";

      var serverRegex = /<div\s+class=["'][^"']*server-item[^"']*["'][^>]*data-type=["']([^"']+)["'][^>]*data-server-name=["']([^"']+)["'][^>]*data-hash=["']([^"']+)["']/gi;
      var sm;
      var allServers = [];
      while ((sm = serverRegex.exec(serversHtml)) !== null) {
        allServers.push({
          type: sm[1].toLowerCase(),
          serverName: sm[2],
          embedUrl: base64Decode(sm[3]),
        });
      }

      // If regex with strict attribute order missed some, try loose attribute matching
      if (allServers.length === 0) {
        var looseRegex = /<div\s+class=["'][^"']*server-item[^"']*["']([^>]+)>/gi;
        while ((sm = looseRegex.exec(serversHtml)) !== null) {
          var attrs = sm[1];
          var tMatch = attrs.match(/data-type=["']([^"']+)["']/i);
          var nMatch = attrs.match(/data-server-name=["']([^"']+)["']/i);
          var hMatch = attrs.match(/data-hash=["']([^"']+)["']/i);
          if (tMatch && nMatch && hMatch) {
            allServers.push({
              type: tMatch[1].toLowerCase(),
              serverName: nMatch[1],
              embedUrl: base64Decode(hMatch[1]),
            });
          }
        }
      }

      var filteredServers = allServers.filter(function (s) {
        return s.type === requestedType;
      });
      if (filteredServers.length === 0) {
        filteredServers = allServers;
      }

      // 1. Concurrently fetch all server embed pages
      var embedRequests = filteredServers.map(function (s) {
        return {
          url: s.embedUrl,
          headers: {
            "User-Agent": USER_AGENT,
            "Referer": BASE_URL + "/",
          },
        };
      });
      var embedResponses = await httpParallelGet(embedRequests);

      // 2. Extract raw stream candidates from embed pages
      var candidateStreams = []; // { m3u8Url, baseName, subtitles, referer }
      var secondaryRequests = []; // For megaplay getSources requests

      for (var i = 0; i < filteredServers.length; i++) {
        var srv = filteredServers[i];
        var resBody = embedResponses[i] ? embedResponses[i].body : "";
        var baseName = "HiAnime " + srv.serverName + " " + (srv.type === "dub" ? "Dub" : "Sub");

        if (srv.embedUrl.indexOf("zokoanime.video") !== -1) {
          var pMatch = resBody.match(/window\.__P\s*=\s*["']([^"']+)["']/);
          if (pMatch) {
            var zokoData = deobfuscateZoko(pMatch[1]);
            if (zokoData && zokoData.src) {
              var zokoSubs = (zokoData.subtitles || []).map(function (sub) {
                return {
                  url: sub.src,
                  label: sub.label || sub.lang || "English",
                };
              });
              candidateStreams.push({
                m3u8Url: zokoData.src,
                baseName: baseName,
                subtitles: zokoSubs,
                referer: "https://zokoanime.video/",
              });
            }
          }
        } else if (srv.embedUrl.indexOf("megaplay.buzz") !== -1) {
          var dataIdMatch =
            resBody.match(/id=["']megaplay-player["'][^>]*data-id=["'](\d+)["']/i) ||
            resBody.match(/data-id=["'](\d+)["']/i);
          if (dataIdMatch) {
            secondaryRequests.push({
              url: "https://megaplay.buzz/stream/getSources?id=" + dataIdMatch[1],
              headers: {
                "User-Agent": USER_AGENT,
                "Referer": srv.embedUrl,
                "X-Requested-With": "XMLHttpRequest",
              },
              baseName: baseName,
              referer: "https://megaplay.buzz/",
            });
          }
        }
      }

      // Fetch MegaPlay sources in parallel if any
      if (secondaryRequests.length > 0) {
        var secResponses = await httpParallelGet(secondaryRequests);
        for (var j = 0; j < secondaryRequests.length; j++) {
          var sReq = secondaryRequests[j];
          var secBody = secResponses[j] ? secResponses[j].body : "";
          var megaJson = parseJsonSafe(secBody, {});
          var megaFile = (megaJson.sources && megaJson.sources.file) || (Array.isArray(megaJson.sources) && megaJson.sources[0] && megaJson.sources[0].file) || "";
          if (megaFile) {
            var megaSubs = (megaJson.tracks || [])
              .filter(function (t) {
                return t && t.file && t.kind !== "thumbnails";
              })
              .map(function (t) {
                return {
                  url: t.file,
                  label: t.label || "English",
                };
              });
            candidateStreams.push({
              m3u8Url: megaFile,
              baseName: sReq.baseName,
              subtitles: megaSubs,
              referer: sReq.referer,
            });
          }
        }
      }

      // 3. Concurrently fetch and parse HLS master playlists for all streams
      var playlistRequests = candidateStreams.map(function (c) {
        return {
          url: c.m3u8Url,
          headers: {
            "User-Agent": USER_AGENT,
            "Referer": c.referer,
          },
        };
      });
      var playlistResponses = await httpParallelGet(playlistRequests);

      var allStreams = [];

      for (var k = 0; k < candidateStreams.length; k++) {
        var cand = candidateStreams[k];
        var pBody = playlistResponses[k] ? playlistResponses[k].body : "";
        var streamHeaders = {
          "User-Agent": USER_AGENT,
          "Referer": cand.referer,
        };

        var variants = parseHlsVariants(pBody, cand.m3u8Url);

        if (variants && variants.length > 1) {
          for (var v = 0; v < variants.length; v++) {
            var st = new StreamResult({
              url: variants[v].url,
              source: cand.baseName + " [" + variants[v].label + "]",
              headers: streamHeaders,
            });
            if (cand.subtitles && cand.subtitles.length > 0) {
              st.subtitles = cand.subtitles;
            }
            allStreams.push(st);
          }
        } else if (variants && variants.length === 1) {
          var singleSt = new StreamResult({
            url: variants[0].url,
            source: cand.baseName + " [" + variants[0].label + "]",
            headers: streamHeaders,
          });
          if (cand.subtitles && cand.subtitles.length > 0) {
            singleSt.subtitles = cand.subtitles;
          }
          allStreams.push(singleSt);
        } else {
          // Direct playlist or fallback
          var directSt = new StreamResult({
            url: cand.m3u8Url,
            source: cand.baseName + " [Auto]",
            headers: streamHeaders,
          });
          if (cand.subtitles && cand.subtitles.length > 0) {
            directSt.subtitles = cand.subtitles;
          }
          allStreams.push(directSt);
        }
      }

      Analytics.logEvent("hianime_streams", { count: allStreams.length });
      cb({ success: true, data: allStreams });
    } catch (e) {
      cb({ success: false, errorCode: "STREAM_ERROR", message: e.stack || String(e) });
    }
  }

  // Export to global scope for SkyStream runner
  globalThis.getHome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
