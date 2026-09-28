(function () {
  "use strict";

  // ========== GA Tracker ==========
  function base64Decode(str) {
    var chars =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var output = "";
    var bytes = [];
    for (var i = 0; i < str.length; i += 4) {
      var a = chars.indexOf(str[i]);
      var b = chars.indexOf(str[i + 1] || "=");
      var c = chars.indexOf(str[i + 2] || "=");
      var d = chars.indexOf(str[i + 3] || "=");
      bytes.push((a << 2) | (b >> 4));
      if (c !== -1 && str[i + 2] !== "=")
        bytes.push(((b & 15) << 4) | (c >> 2));
      if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
    }
    for (var j = 0; j < bytes.length; j++)
      output += String.fromCharCode(bytes[j]);
    return output;
  }

  const GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
  const GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

  const SessionTracker = {
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
        },
      );
    },
  };
  SessionTracker.init();

  const Analytics = {
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
            JSON.stringify({ client_id: this.clientId, events: events }),
          );
        }
      } catch (e) {
        /* silently skip */
      }
    },
  };
  Analytics.init();

  // ========== Configuration & Constants ==========
  var BASE_URL =
    typeof manifest !== "undefined" && manifest && manifest.baseUrl
      ? manifest.baseUrl
      : "https://www.mxplayer.in";
  var IMAGE_URL = "https://qqcdnpictest.mxplay.com/";
  var WEB_API = "https://api.mxplayer.in/v1/web";
  var ENDPOINT_URL = "https://d3sgzbosmwirao.cloudfront.net/";
  var DEFAULT_USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36";

  var HEADERS = {
    "User-Agent": DEFAULT_USER_AGENT,
    Referer: BASE_URL + "/",
  };

  var cachedUserId = SessionTracker.generateUuid();

  // ========== Utility Functions ==========
  function toErrorMessage(error) {
    return String((error && (error.stack || error.message)) || error);
  }

  function parseJsonSafe(value, fallback) {
    if (value && typeof value === "object") return value;
    try {
      return JSON.parse(String(value || ""));
    } catch (_) {
      try {
        var text = String(value || "")
          .replace(/^'+|'+$/g, "")
          .replace(/^"+|"+$/g, "");
        return JSON.parse(text);
      } catch (_) {
        return fallback !== undefined ? fallback : {};
      }
    }
  }

  function parseHeaders(rawHeaders) {
    var headers = {};
    if (!rawHeaders) return headers;
    if (typeof rawHeaders.forEach === "function") {
      rawHeaders.forEach(function (value, key) {
        headers[String(key).toLowerCase()] = value;
      });
      return headers;
    }
    for (var key in rawHeaders) {
      if (!Object.prototype.hasOwnProperty.call(rawHeaders, key)) continue;
      headers[String(key).toLowerCase()] = rawHeaders[key];
    }
    return headers;
  }

  function extractResponseBody(res) {
    if (res == null) return "";
    if (typeof res === "string") return res;
    if (typeof res.body === "string") return res.body;
    if (res.body && typeof res.body === "object") return res.body;
    if (typeof res.text === "string") return res.text;
    if (res.text && typeof res.text === "object") return res.text;
    if (typeof res.data === "string") return res.data;
    if (res.data && typeof res.data === "object") return res.data;
    return res;
  }

  async function request(url, options) {
    url = String(url || "").trim();
    options = options || {};
    var method = options.method || "GET";
    var headers = Object.assign({}, HEADERS, options.headers || {});
    var body = options.body !== undefined ? options.body : "";
    var allowRedirects = options.allowRedirects !== false;
    var timeout = options.timeout || 20000;

    if (method === "GET" && typeof http_get === "function") {
      try {
        var res = await Promise.resolve(http_get(url, headers));
        if (
          res &&
          (res.body || res.text || res.data || res.status || res.statusCode)
        ) {
          return {
            status: res.status || res.statusCode || 200,
            body: extractResponseBody(res),
            headers: parseHeaders(res.headers),
            finalUrl: res.url || res.finalUrl || url,
          };
        }
      } catch (_) {}
    }

    if (method === "POST" && typeof http_post === "function") {
      // 1. Try standard Flutter bridge order: http_post(url, headers, body)
      try {
        var p1 = await Promise.resolve(http_post(url, headers, body));
        if (
          p1 &&
          (p1.body || p1.text || p1.data || p1.status || p1.statusCode)
        ) {
          return {
            status: p1.status || p1.statusCode || 200,
            body: extractResponseBody(p1),
            headers: parseHeaders(p1.headers),
            finalUrl: p1.url || p1.finalUrl || url,
          };
        }
      } catch (_) {}

      // 2. Try alternative order: http_post(url, body, headers)
      try {
        var p2 = await Promise.resolve(http_post(url, body, headers));
        if (
          p2 &&
          (p2.body || p2.text || p2.data || p2.status || p2.statusCode)
        ) {
          return {
            status: p2.status || p2.statusCode || 200,
            body: extractResponseBody(p2),
            headers: parseHeaders(p2.headers),
            finalUrl: p2.url || p2.finalUrl || url,
          };
        }
      } catch (_) {}
    }

    if (typeof fetch === "function") {
      var controller =
        typeof AbortController !== "undefined" ? new AbortController() : null;
      var timer = null;
      var fetchOptions = {
        method: method,
        headers: headers,
        redirect: allowRedirects ? "follow" : "manual",
      };
      if (
        body &&
        (method === "POST" || method === "PUT" || method === "PATCH")
      ) {
        fetchOptions.body =
          typeof body === "string" ? body : JSON.stringify(body);
      }
      if (controller) fetchOptions.signal = controller.signal;

      var fetchPromise = fetch(url, fetchOptions).then(function (res) {
        var resHeaders = {};
        if (res.headers && typeof res.headers.forEach === "function") {
          res.headers.forEach(function (v, k) {
            resHeaders[k.toLowerCase()] = v;
          });
        }
        return res.text().then(function (bodyText) {
          return {
            status: res.status,
            body: bodyText,
            headers: resHeaders,
            finalUrl: res.url || url,
          };
        });
      });

      if (controller) {
        timer = setTimeout(function () {
          try {
            controller.abort();
          } catch (_) {}
        }, timeout);

        return fetchPromise
          .then(function (result) {
            clearTimeout(timer);
            return result;
          })
          .catch(function (err) {
            clearTimeout(timer);
            throw err;
          });
      }
      return fetchPromise;
    }

    throw new Error("No HTTP client available");
  }

  async function ensureUserId() {
    if (cachedUserId) return cachedUserId;
    cachedUserId = SessionTracker.generateUuid();
    return cachedUserId;
  }

  function getEndParam(userId) {
    return (
      "&device-density=2&userid=" +
      (userId || cachedUserId || "") +
      "&platform=com.mxplay.desktop&content-languages=hi,en&kids-mode-enabled=false"
    );
  }

  function buildImageUrl(url) {
    if (!url) return "";
    var s = String(url).trim();
    if (s.startsWith("http://") || s.startsWith("https://")) return s;
    if (s.startsWith("//")) return "https:" + s;
    return IMAGE_URL + s;
  }

  function getPortraitLargeImageUrl(item) {
    if (!item || !Array.isArray(item.imageInfo)) return "";
    for (var i = 0; i < item.imageInfo.length; i++) {
      var img = item.imageInfo[i];
      if (img && img.type === "portrait_large" && img.url) {
        return buildImageUrl(img.url);
      }
    }
    for (var j = 0; j < item.imageInfo.length; j++) {
      var img2 = item.imageInfo[j];
      if (img2 && img2.url) {
        return buildImageUrl(img2.url);
      }
    }
    return "";
  }

  function getMBigPic(item) {
    if (!item || !Array.isArray(item.imageInfo)) return null;
    for (var i = 0; i < item.imageInfo.length; i++) {
      var img = item.imageInfo[i];
      if (img && img.type === "bigpic" && img.url) {
        return buildImageUrl(img.url);
      }
    }
    return null;
  }

  function getMovieBigPic(item) {
    if (!item) return null;
    var list = item.titleContentImageInfo;
    if (!Array.isArray(list)) return null;
    for (var i = 0; i < list.length; i++) {
      var img = list[i];
      if (img && img.type === "banner_and_static_bg_desktop" && img.url) {
        return buildImageUrl(img.url);
      }
    }
    for (var j = 0; j < list.length; j++) {
      var img2 = list[j];
      if (img2 && img2.url && String(img2.type || "").indexOf("banner") !== -1) {
        return buildImageUrl(img2.url);
      }
    }
    return null;
  }

  function bestVariant(variantObj) {
    if (!variantObj || typeof variantObj !== "object") return null;
    var keys = ["high", "base", "main"];
    for (var i = 0; i < keys.length; i++) {
      var k = keys[i];
      var v = variantObj[k];
      if (v && typeof v === "string" && v.trim()) {
        return v.trim();
      }
    }
    return null;
  }

  function normalizeUrl(url) {
    if (!url || typeof url !== "string") return null;
    var s = url.trim();
    if (!s) return null;
    if (s.toLowerCase().startsWith("http://") || s.toLowerCase().startsWith("https://")) {
      return s;
    }
    if (s.startsWith("//")) return "https:" + s;
    return ENDPOINT_URL + s;
  }

  function toSearchResult(item) {
    var title = item.title || "";
    var portraitUrl = getPortraitLargeImageUrl(item);
    var bigPic = getMBigPic(item);
    var banner = getMovieBigPic(item) || bigPic || portraitUrl;
    var description = item.description || "";
    var isMovie =
      item.type && String(item.type).toLowerCase().indexOf("movie") !== -1;
    var type = isMovie ? "movie" : "series";

    var loadData = {
      title: title,
      titleContentImageInfo: item.titleContentImageInfo || null,
      bigpic: bigPic,
      tvType: item.type || type,
      stream: item.stream || null,
      description: description,
      shareUrl: item.shareUrl || null,
      alternativestream: null,
      alternativeposter: null,
      languages: item.languages || [],
    };

    return new MultimediaItem({
      title: title,
      url: JSON.stringify(loadData),
      posterUrl: portraitUrl || "",
      bannerUrl: banner || "",
      type: type,
      description: description,
      headers: { Referer: BASE_URL + "/" },
    });
  }

  async function getSeasonData(url) {
    try {
      var res = await request(url, { headers: HEADERS });
      var html = res.body || "";
      var seasons = [];
      var divRegex = /<div\b[^>]*\bdata-tab=["']?(\d+)["']?[^>]*>/gi;
      var match;
      while ((match = divRegex.exec(html)) !== null) {
        var tag = match[0];
        var tabMatch = tag.match(/data-tab=["']?(\d+)["']?/i);
        var idMatch = tag.match(/data-id=["']?([^"'\s>]+)["']?/i);
        if (tabMatch && idMatch && idMatch[1].trim()) {
          seasons.push({
            season: parseInt(tabMatch[1], 10),
            id: idMatch[1].trim(),
          });
        }
      }

      if (seasons.length > 0) {
        seasons.sort(function (a, b) {
          return a.season - b.season;
        });
        return seasons;
      }

      // Fallback: extract 32-char hex id from url if HTML season tabs are unavailable
      var idFromUrl = url.match(/\/([a-f0-9]{32})/i);
      if (idFromUrl && idFromUrl[1]) {
        return [{ season: 1, id: idFromUrl[1] }];
      }
    } catch (_) {}
    return [];
  }

  // ========== Core Plugin Methods ==========

  /**
   * Loads the home screen categories.
   * @param {(res: { success: boolean, data?: any, errorCode?: string, message?: string }) => void} cb
   */
  async function getHome(cb) {
    try {
      var userId = await ensureUserId();
      var param = getEndParam(userId);

      var sectionsConfig = [
        {
          name: "Crime Shows",
          url:
            WEB_API +
            "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=b413dff55bdad743c577a8bea3b65044&type=2" +
            param,
        },
        {
          name: "Drama Shows",
          url:
            WEB_API +
            "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=48efa872f6f17facebf6149dfc536ee1&type=2" +
            param,
        },
        {
          name: "Thriller Shows",
          url:
            WEB_API +
            "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=2dd5daf25be5619543524f360c73c3d8&type=2" +
            param,
        },
        {
          name: "Hindi Movies",
          url:
            WEB_API +
            "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&browseLangFilterIds=hi&type=1" +
            param,
        },
        {
          name: "Telgu Movies",
          url:
            WEB_API +
            "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" +
            param,
        },
      ];

      var responses = await Promise.all(
        sectionsConfig.map(function (sec) {
          return request(sec.url, { headers: HEADERS })
            .then(function (res) {
              return { name: sec.name, body: res.body };
            })
            .catch(function () {
              return { name: sec.name, body: "{}" };
            });
        }),
      );

      var homeData = {};
      for (var i = 0; i < responses.length; i++) {
        var parsed = parseJsonSafe(responses[i].body, {});
        var items = Array.isArray(parsed.items) ? parsed.items : [];
        var mapped = items.map(toSearchResult);
        if (mapped.length > 0) {
          homeData[responses[i].name] = mapped;
        }
      }

      Analytics.logEvent("mplayer_gethome", {});
      cb({ success: true, data: homeData });
    } catch (e) {
      cb({
        success: false,
        errorCode: "PARSE_ERROR",
        message: toErrorMessage(e),
      });
    }
  }

  /**
   * Searches for media items.
   * @param {string} query
   * @param {(res: { success: boolean, data?: any, errorCode?: string, message?: string }) => void} cb
   */
  async function search(query, cb) {
    try {
      var cleanQuery = String(query || "").trim();
      if (!cleanQuery) {
        if (typeof cb === "function") cb({ success: true, data: [] });
        return { success: true, data: [] };
      }

      var userId = await ensureUserId();
      var searchUrl =
        WEB_API +
        "/search/resultv2?query=" +
        encodeURIComponent(cleanQuery) +
        getEndParam(userId);

      var res = await request(searchUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json, text/plain, */*",
          "User-Agent": DEFAULT_USER_AGENT,
          Referer: "https://www.mxplayer.in/",
          Origin: "https://www.mxplayer.in",
        },
        body: "{}",
      });

      var rawBody = res ? res.body || res.data || res.text || res : {};
      var data = parseJsonSafe(rawBody, {});

      var allItems = [];
      if (Array.isArray(data.sections)) {
        for (var s = 0; s < data.sections.length; s++) {
          var section = data.sections[s];
          if (section && Array.isArray(section.items)) {
            allItems = allItems.concat(section.items);
          }
        }
      } else if (Array.isArray(data.items)) {
        allItems = data.items;
      }

      var results = [];
      for (var j = 0; j < allItems.length; j++) {
        var item = allItems[j];
        if (!item || !item.title) continue;

        var title = item.title || "";
        var description = item.description || "";
        var type = item.type || "";
        var shareUrl = item.shareUrl || "";
        var languages = Array.isArray(item.languages) ? item.languages : [];

        var portraitLargeImageUrl = "";
        if (Array.isArray(item.imageInfo)) {
          for (var k = 0; k < item.imageInfo.length; k++) {
            var img = item.imageInfo[k];
            if (img && img.type === "portrait_large" && img.url) {
              portraitLargeImageUrl = normalizeUrl(img.url);
              break;
            }
          }
          if (
            !portraitLargeImageUrl &&
            item.imageInfo.length > 0 &&
            item.imageInfo[0].url
          ) {
            portraitLargeImageUrl = normalizeUrl(item.imageInfo[0].url);
          }
        }

        var alternativeStream = null;
        if (item.stream && typeof item.stream === "object") {
          var streamObj = item.stream;
          var thirdParty = streamObj.thirdParty;
          var mxplay = streamObj.mxplay;
          var hlsObj = streamObj.hls || (mxplay ? mxplay.hls : null);
          var dashObj = streamObj.dash || (mxplay ? mxplay.dash : null);

          var hlsRaw =
            bestVariant(hlsObj) ||
            (thirdParty && thirdParty.hlsUrl ? thirdParty.hlsUrl : null);
          var dashRaw =
            bestVariant(dashObj) ||
            (thirdParty && thirdParty.dashUrl ? thirdParty.dashUrl : null);

          var hlsUrl = normalizeUrl(hlsRaw);
          var dashUrl = normalizeUrl(dashRaw);

          var urls = [];
          if (hlsUrl && urls.indexOf(hlsUrl) === -1) urls.push(hlsUrl);
          if (dashUrl && urls.indexOf(dashUrl) === -1) urls.push(dashUrl);

          if (urls.length === 1) {
            alternativeStream = urls[0];
          } else if (urls.length > 1) {
            alternativeStream = JSON.stringify(urls);
          }
        }

        var isMovie =
          type && String(type).toLowerCase().indexOf("movie") !== -1;
        var mediaType = isMovie ? "movie" : "series";

        var loadData = {
          title: title,
          titleContentImageInfo: item.titleContentImageInfo || null,
          bigpic: null,
          tvType: type,
          stream: null,
          description: description,
          shareUrl: shareUrl,
          alternativestream: alternativeStream,
          alternativeposter: portraitLargeImageUrl,
          languages: languages,
        };

        results.push(
          new MultimediaItem({
            title: title,
            url: JSON.stringify(loadData),
            posterUrl: portraitLargeImageUrl || "",
            bannerUrl: portraitLargeImageUrl || "",
            type: mediaType,
            description: description,
            headers: { Referer: BASE_URL + "/" },
          }),
        );
      }

      Analytics.logEvent("mplayer_search", { query: cleanQuery, count: results.length });
      if (typeof cb === "function") cb({ success: true, data: results });
      return { success: true, data: results };
    } catch (e) {
      var errRes = {
        success: false,
        errorCode: "SEARCH_ERROR",
        message: toErrorMessage(e),
      };
      if (typeof cb === "function") cb(errRes);
      return errRes;
    }
  }

  /**
   * Loads details for a specific media item.
   * @param {string} url
   * @param {(res: { success: boolean, data?: any, errorCode?: string, message?: string }) => void} cb
   */
  async function load(url, cb) {
    try {
      var video = null;
      try {
        video = JSON.parse(url);
      } catch (_) {
        var cleanPath = String(url || "").replace(/^https?:\/\/[^\/]+/i, "");
        var isMov = String(url || "").toLowerCase().indexOf("movie") !== -1;
        video = {
          title: "M Player",
          shareUrl: cleanPath,
          tvType: isMov ? "movie" : "tvshow",
          description: "",
          languages: [],
        };
      }

      if (!video) {
        cb({
          success: false,
          errorCode: "LOAD_ERROR",
          message: "Failed to parse video from payload",
        });
        return;
      }

      var title = video.title || "";
      var poster =
        getMovieBigPic(video) ||
        (video.titleContentImageInfo &&
        video.titleContentImageInfo[0] &&
        video.titleContentImageInfo[0].url
          ? buildImageUrl(video.titleContentImageInfo[0].url)
          : null) ||
        video.alternativeposter ||
        video.bigpic ||
        "";

      var isSeries =
        video.tvType &&
        String(video.tvType).toLowerCase().indexOf("tvshow") !== -1;
      var mediaType = isSeries ? "series" : "movie";
      var languages = Array.isArray(video.languages) ? video.languages : [];
      var description = video.description || "";

      // Collect available stream links
      var hrefList = [];
      if (video.alternativestream) {
        var altStr = String(video.alternativestream).trim();
        if (altStr.startsWith("[")) {
          try {
            var parsedAlt = JSON.parse(altStr);
            if (Array.isArray(parsedAlt)) {
              hrefList = hrefList.concat(parsedAlt);
            }
          } catch (_) {
            hrefList.push(altStr);
          }
        } else if (altStr.indexOf("|") !== -1) {
          var parts = altStr.split("|").map(function (p) {
            return p.trim();
          });
          hrefList = hrefList.concat(
            parts.filter(function (p) {
              return p.length > 0;
            }),
          );
        } else if (altStr) {
          hrefList.push(altStr);
        }
      }

      if (video.stream && typeof video.stream === "object") {
        var s = video.stream;
        var directCandidates = [
          s.hls && s.hls.high,
          s.hls && s.hls.base,
          s.hls && s.hls.main,
          s.dash && s.dash.high,
          s.dash && s.dash.base,
          s.dash && s.dash.main,
          s.mxplay && s.mxplay.hls && s.mxplay.hls.high,
          s.mxplay && s.mxplay.hls && s.mxplay.hls.base,
          s.mxplay && s.mxplay.hls && s.mxplay.hls.main,
          s.mxplay && s.mxplay.dash && s.mxplay.dash.high,
          s.mxplay && s.mxplay.dash && s.mxplay.dash.base,
          s.mxplay && s.mxplay.dash && s.mxplay.dash.main,
          s.thirdParty && s.thirdParty.hlsUrl,
          s.thirdParty && s.thirdParty.dashUrl,
        ];
        for (var c = 0; c < directCandidates.length; c++) {
          var cand = directCandidates[c];
          if (cand && typeof cand === "string" && cand.trim()) {
            hrefList.push(cand.trim());
          }
        }
      }

      // Filter and distinct hrefList
      var distinctHrefList = [];
      for (var h = 0; h < hrefList.length; h++) {
        var href = hrefList[h];
        if (href && distinctHrefList.indexOf(href) === -1) {
          distinctHrefList.push(href);
        }
      }

      if (isSeries) {
        var userId = await ensureUserId();
        var fullShareUrl = BASE_URL + (video.shareUrl || "");
        var seasons = await getSeasonData(fullShareUrl);
        var allEpisodes = [];

        for (var si = 0; si < seasons.length; si++) {
          var seasonObj = seasons[si];
          var seasonNum = seasonObj.season;
          var seasonId = seasonObj.id;
          var nextQuery = null;
          var pageCount = 0;

          while (pageCount < 20) {
            pageCount++;
            var epApiUrl =
              WEB_API +
              "/detail/tab/tvshowepisodes?type=season&" +
              (nextQuery ? nextQuery + "&" : "") +
              "id=" +
              seasonId +
              "&sortOrder=0" +
              getEndParam(userId);

            var epRes = await request(epApiUrl, { headers: HEADERS }).catch(
              function () {
                return { body: "{}" };
              },
            );

            var epParsed = parseJsonSafe(epRes.body, {});
            var epItems = Array.isArray(epParsed.items) ? epParsed.items : [];
            if (!epItems.length) break;

            for (var ei = 0; ei < epItems.length; ei++) {
              var epItem = epItems[ei];
              var epStreams = [];

              if (epItem.stream && typeof epItem.stream === "object") {
                var es = epItem.stream;
                var epCandidates = [
                  es.hls && es.hls.high,
                  es.hls && es.hls.base,
                  es.hls && es.hls.main,
                  es.dash && es.dash.high,
                  es.dash && es.dash.base,
                  es.dash && es.dash.main,
                  es.mxplay && es.mxplay.hls && es.mxplay.hls.high,
                  es.mxplay && es.mxplay.hls && es.mxplay.hls.base,
                  es.mxplay && es.mxplay.hls && es.mxplay.hls.main,
                  es.mxplay && es.mxplay.dash && es.mxplay.dash.high,
                  es.mxplay && es.mxplay.dash && es.mxplay.dash.base,
                  es.mxplay && es.mxplay.dash && es.mxplay.dash.main,
                ];

                for (var ec = 0; ec < epCandidates.length; ec++) {
                  var epCand = epCandidates[ec];
                  if (
                    epCand &&
                    typeof epCand === "string" &&
                    epCand.trim() &&
                    epStreams.indexOf(epCand.trim()) === -1
                  ) {
                    epStreams.push(epCand.trim());
                  }
                }
              }

              if (epStreams.length > 0) {
                var epTitle = epItem.title || "Episode " + (epItem.sequence || ei + 1);
                var epImage =
                  epItem.imageInfo &&
                  epItem.imageInfo[0] &&
                  epItem.imageInfo[0].url
                    ? buildImageUrl(epItem.imageInfo[0].url)
                    : poster;
                var epDescription = epItem.description || "";
                var epDuration = epItem.duration
                  ? Math.floor(epItem.duration / 60)
                  : 0;
                var epSeq = epItem.sequence || ei + 1;

                allEpisodes.push(
                  new Episode({
                    name: epTitle,
                    url: JSON.stringify(epStreams),
                    season: seasonNum,
                    episode: epSeq,
                    description: epDescription,
                    posterUrl: epImage,
                    duration: epDuration,
                    headers: { Referer: BASE_URL + "/" },
                  }),
                );
              }
            }

            if (epParsed.next && typeof epParsed.next === "string") {
              nextQuery = epParsed.next;
            } else {
              break;
            }
          }
        }

        Analytics.logEvent("mplayer_load", { title: title, type: "series" });
        cb({
          success: true,
          data: new MultimediaItem({
            title: title,
            url: url,
            posterUrl: poster,
            bannerUrl: poster,
            type: "series",
            description: description,
            tags: languages,
            episodes: allEpisodes,
            headers: { Referer: BASE_URL + "/" },
          }),
        });
      } else {
        // Movie item with streams and single episode (season 0 and episode 0)
        var movieStreams = [];
        for (var m = 0; m < distinctHrefList.length; m++) {
          var streamHref = distinctHrefList[m];
          var streamFullUrl = normalizeUrl(streamHref);
          var streamLabel =
            streamFullUrl.indexOf(".m3u8") !== -1
              ? "HLS"
              : streamFullUrl.indexOf(".mpd") !== -1
                ? "DASH"
                : "";

          movieStreams.push(
            new StreamResult({
              url: streamFullUrl,
              source: ("M Player " + streamLabel).trim(),
              headers: { Referer: BASE_URL + "/" },
            }),
          );
        }

        var episodeStreamsPayload =
          distinctHrefList.length > 0
            ? JSON.stringify(distinctHrefList)
            : JSON.stringify(
                movieStreams.map(function (s) {
                  return s.url;
                }),
              );

        var movieEpisode = new Episode({
          name: title || "Movie",
          url: episodeStreamsPayload,
          season: 0,
          episode: 0,
          description: description,
          posterUrl: poster,
          headers: { Referer: BASE_URL + "/" },
        });

        Analytics.logEvent("mplayer_load", { title: title, type: "movie" });
        cb({
          success: true,
          data: new MultimediaItem({
            title: title,
            url: typeof url === "string" ? url : JSON.stringify(url),
            posterUrl: poster,
            bannerUrl: poster,
            type: "movie",
            description: description,
            tags: languages,
            streams: movieStreams,
            episodes: [movieEpisode],
            headers: { Referer: BASE_URL + "/" },
          }),
        });
      }
    } catch (e) {
      cb({
        success: false,
        errorCode: "LOAD_ERROR",
        message: toErrorMessage(e),
      });
    }
  }

  /**
   * Resolves streams for a specific media item or episode.
   * @param {string} url
   * @param {(res: { success: boolean, data?: any, errorCode?: string, message?: string }) => void} cb
   */
  async function loadStreams(url, cb) {
    try {
      var rawUrls = [];
      var trimmed = String(url || "").trim();

      if (trimmed.startsWith("[")) {
        try {
          var parsedArr = JSON.parse(trimmed);
          if (Array.isArray(parsedArr)) {
            rawUrls = parsedArr;
          }
        } catch (_) {
          rawUrls = [trimmed];
        }
      } else if (trimmed.startsWith("{")) {
        try {
          var parsedObj = JSON.parse(trimmed);
          if (parsedObj.alternativestream) {
            var alt = String(parsedObj.alternativestream).trim();
            if (alt.startsWith("[")) {
              rawUrls = rawUrls.concat(JSON.parse(alt));
            } else {
              rawUrls.push(alt);
            }
          }
          if (parsedObj.stream && typeof parsedObj.stream === "object") {
            var os = parsedObj.stream;
            var list = [
              os.hls && os.hls.high,
              os.dash && os.dash.high,
              os.mxplay && os.mxplay.hls && os.mxplay.hls.high,
              os.mxplay && os.mxplay.dash && os.mxplay.dash.high,
              os.thirdParty && os.thirdParty.hlsUrl,
              os.thirdParty && os.thirdParty.dashUrl,
            ];
            for (var li = 0; li < list.length; li++) {
              if (list[li]) rawUrls.push(list[li]);
            }
          }
        } catch (_) {
          rawUrls = [trimmed];
        }
      } else if (trimmed) {
        rawUrls = [trimmed];
      }

      var distinctUrls = [];
      for (var u = 0; u < rawUrls.length; u++) {
        var candidate = rawUrls[u];
        if (candidate && distinctUrls.indexOf(candidate) === -1) {
          distinctUrls.push(candidate);
        }
      }

      var allStreams = [];
      for (var d = 0; d < distinctUrls.length; d++) {
        var targetUrl = distinctUrls[d];
        var fullUrl = targetUrl.startsWith("video")
          ? ENDPOINT_URL + targetUrl
          : normalizeUrl(targetUrl);
        var label =
          fullUrl.indexOf(".m3u8") !== -1
            ? "HLS"
            : fullUrl.indexOf(".mpd") !== -1
              ? "DASH"
              : "";

        allStreams.push(
          new StreamResult({
            url: fullUrl,
            source: ("M Player " + label).trim(),
            headers: { Referer: BASE_URL + "/" },
          }),
        );
      }

      Analytics.logEvent("mplayer_loadstreams", { count: allStreams.length });
      cb({ success: true, data: allStreams });
    } catch (e) {
      cb({
        success: false,
        errorCode: "STREAM_ERROR",
        message: toErrorMessage(e),
      });
    }
  }

  // ========== Exports ==========
  var root =
    typeof globalThis !== "undefined"
      ? globalThis
      : typeof self !== "undefined"
        ? self
        : typeof window !== "undefined"
          ? window
          : typeof global !== "undefined"
            ? global
            : this;

  root.getHome = getHome;
  root.loadHome = getHome;
  root.loadhome = getHome;
  root.search = search;
  root.load = load;
  root.loadStreams = loadStreams;

  globalThis.getHome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
