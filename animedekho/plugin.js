(function () {
  "use strict";

  /**
   * @typedef {Object} Response
   * @property {boolean} success
   * @property {any} [data]
   * @property {string} [errorCode]
   * @property {string} [message]
   */

  var DEFAULT_BASE_URL = "https://animedekho.app";
  var TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
  var TMDB_API_BASE = "https://api.themoviedb.org/3";
  var TMDB_IMAGE_BASE = "https://image.tmdb.org/t/p";
  var ANIZIP_BASE = "https://api.ani.zip/mappings";
  var ABYSS_DEC_API = "https://enc-dec.app/api/dec-abyss";

  var runtimeManifest =
    typeof manifest !== "undefined" && manifest && manifest.baseUrl
      ? manifest
      : { baseUrl: DEFAULT_BASE_URL };

  var urlCache = {};
  var CACHE_TTL = 300000; // 5 minutes

  var USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36";

  var DEFAULT_HEADERS = {
    "User-Agent": USER_AGENT,
    Accept: "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
    "Accept-Language": "en-US,en;q=0.9",
  };

  /* ========================================================================= */
  /* String and Parsing Utilities                                              */
  /* ========================================================================= */

  function trim(value) {
    return String(value || "")
      .replace(/\s+/g, " ")
      .replace(/^\s+|\s+$/g, "");
  }

  function decodeHtmlEntities(value) {
    return trim(
      String(value || "")
        .replace(/&#(\d+);/g, function (_, code) {
          return String.fromCharCode(Number(code));
        })
        .replace(/&#x([0-9a-f]+);/gi, function (_, code) {
          return String.fromCharCode(parseInt(code, 16));
        })
        .replace(/&nbsp;/gi, " ")
        .replace(/&amp;/gi, "&")
        .replace(/&quot;/gi, '"')
        .replace(/&#39;/gi, "'")
        .replace(/&lt;/gi, "<")
        .replace(/&gt;/gi, ">")
    );
  }

  function stripTags(value) {
    return decodeHtmlEntities(
      String(value || "")
        .replace(/<br\s*\/?>/gi, "\n")
        .replace(/<[^>]+>/g, " ")
    );
  }

  function parseJsonSafe(value, fallback) {
    if (value && typeof value === "object") return value;
    var raw = String(value || "").trim();
    if (!raw) return fallback;
    try {
      return JSON.parse(raw);
    } catch (_) {
      try {
        var unquoted = raw.replace(/^'+|'+$/g, "").replace(/^"+|"+$/g, "");
        return JSON.parse(unquoted);
      } catch (_) {
        return fallback;
      }
    }
  }

  function absoluteUrl(base, path) {
    var cleanBase = String(base || "").trim();
    var cleanPath = String(path || "").trim();
    if (!cleanPath) return cleanBase;
    if (/^https?:\/\//i.test(cleanPath)) return cleanPath;
    if (cleanPath.indexOf("//") === 0) return "https:" + cleanPath;
    try {
      if (typeof URL !== "undefined") {
        return new URL(cleanPath, cleanBase).toString();
      }
    } catch (_) {}
    if (cleanPath.charAt(0) === "/") {
      var originMatch = cleanBase.match(/^(https?:\/\/[^\/]+)/i);
      var origin = originMatch ? originMatch[1] : cleanBase.replace(/\/+$/, "");
      return origin + cleanPath;
    }
    return cleanBase.replace(/\/+$/, "") + "/" + cleanPath.replace(/^\/+/, "");
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

  function getQualityFromText(text) {
    var lower = String(text || "").toLowerCase();
    if (/\b2160p\b|\b4k\b|\buhd\b/.test(lower)) return 2160;
    if (/\b1440p\b|\bqhd\b/.test(lower)) return 1440;
    if (/\b1080p\b|\bfullhd\b/.test(lower)) return 1080;
    if (/\b720p\b|\bhd\b/.test(lower)) return 720;
    if (/\b480p\b|\bsd\b/.test(lower)) return 480;
    if (/\b360p\b/.test(lower)) return 360;
    return 0;
  }

  /* ========================================================================= */
  /* Network Layer                                                             */
  /* ========================================================================= */

  function request(url, options) {
    url = String(url || "").trim();
    options = options || {};
    var method = options.method || "GET";
    var headers = Object.assign({}, DEFAULT_HEADERS, options.headers || {});
    var body = options.body;
    var allowRedirects = options.allowRedirects !== false;
    var timeout = options.timeout || 20000;

    if (
      method === "GET" &&
      (allowRedirects || typeof fetch !== "function") &&
      typeof http_get === "function"
    ) {
      return Promise.resolve(http_get(url, headers)).then(function (res) {
        return {
          status: res && typeof res.status !== "undefined" ? res.status : 200,
          body: res && typeof res.body !== "undefined" ? res.body : (typeof res === "string" ? res : ""),
          headers: parseHeaders(res && res.headers),
          finalUrl: (res && (res.url || res.finalUrl)) || url,
        };
      });
    }

    if (
      method === "POST" &&
      (allowRedirects || typeof fetch !== "function") &&
      typeof http_post === "function"
    ) {
      return Promise.resolve(http_post(url, headers, body)).then(function (res) {
        return {
          status: res && typeof res.status !== "undefined" ? res.status : 200,
          body: res && typeof res.body !== "undefined" ? res.body : (typeof res === "string" ? res : ""),
          headers: parseHeaders(res && res.headers),
          finalUrl: (res && (res.url || res.finalUrl)) || url,
        };
      });
    }

    if (typeof fetch === "function") {
      var controller =
        typeof AbortController !== "undefined" ? new AbortController() : null;
      var timer = null;
      var fetchOptions = {
        method: method,
        headers: headers,
        body: body,
        redirect: allowRedirects ? "follow" : "manual",
      };
      if (controller) fetchOptions.signal = controller.signal;

      var fetchPromise = fetch(url, fetchOptions).then(function (res) {
        return res.text().then(function (bodyText) {
          return {
            status: res.status,
            body: bodyText,
            headers: parseHeaders(res.headers),
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
          .catch(function (error) {
            clearTimeout(timer);
            throw error;
          });
      }

      return Promise.race([
        fetchPromise,
        new Promise(function (_, reject) {
          timer = setTimeout(function () {
            reject(new Error("Request timeout after " + timeout + "ms"));
          }, timeout);
        }),
      ])
        .then(function (result) {
          clearTimeout(timer);
          return result;
        })
        .catch(function (error) {
          clearTimeout(timer);
          throw error;
        });
    }

    throw new Error("No HTTP client available in runtime");
  }

  function getText(url, headers, allowRedirects) {
    var now = Date.now();
    if (urlCache[url] && now - urlCache[url].time < CACHE_TTL) {
      return Promise.resolve(urlCache[url].body);
    }
    return request(url, {
      headers: headers,
      allowRedirects: allowRedirects,
      timeout: 15000,
    }).then(function (res) {
      var body = res.body || "";
      urlCache[url] = { body: body, time: now };
      return body;
    });
  }

  function getJson(url, headers) {
    return request(url, { headers: headers }).then(function (res) {
      return parseJsonSafe(res.body, {});
    });
  }

  function postForm(url, form, headers, allowRedirects) {
    var body = [];
    for (var key in form) {
      if (!Object.prototype.hasOwnProperty.call(form, key)) continue;
      body.push(encodeURIComponent(key) + "=" + encodeURIComponent(form[key]));
    }
    return request(url, {
      method: "POST",
      body: body.join("&"),
      headers: Object.assign(
        { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" },
        headers || {}
      ),
      allowRedirects: allowRedirects,
    });
  }

  function postJson(url, payload, headers) {
    return request(url, {
      method: "POST",
      body: typeof payload === "string" ? payload : JSON.stringify(payload),
      headers: Object.assign(
        { "Content-Type": "application/json; charset=UTF-8" },
        headers || {}
      ),
    });
  }

  /* ========================================================================= */
  /* JS Unpacker (Dean Edwards p,a,c,k,e,d unpacker)                           */
  /* ========================================================================= */

  function unpackJs(packed) {
    if (!packed || typeof packed !== "string") return "";
    var match = packed.match(
      /eval\s*\(\s*function\s*\(\s*p\s*,\s*a\s*,\s*c\s*,\s*k\s*,\s*e\s*,\s*d\s*\)\s*\{[\s\S]*?\}\s*\(\s*'([\s\S]*?)'\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*'([\s\S]*?)'\.split\('\|'\)/
    );
    if (!match) {
      match = packed.match(
        /}\s*\('([\s\S]*?)'\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*'([\s\S]*?)'\.split\('\|'\)/
      );
    }
    if (!match) return packed;

    var p = match[1];
    var a = parseInt(match[2], 10);
    var c = parseInt(match[3], 10);
    var k = match[4].split("|");

    function encodeBase(val, radix) {
      var num = val % radix;
      var str =
        num > 35
          ? String.fromCharCode(num + 29)
          : Number(num).toString(36);
      if (val >= radix) {
        return encodeBase(Math.floor(val / radix), radix) + str;
      }
      return str;
    }

    while (c--) {
      var token = encodeBase(c, a);
      var replacement = k[c] || token;
      if (replacement) {
        p = p.replace(new RegExp("\\b" + token + "\\b", "g"), replacement);
      }
    }
    return p;
  }

  /* ========================================================================= */
  /* HTML Card / Element Parsers                                               */
  /* ========================================================================= */

  function parsePostArticles(html, baseUrl) {
    var items = [];
    var articleRegex = /<article\b[^>]*>([\s\S]*?)<\/article>/gi;
    var match;
    var seen = {};

    while ((match = articleRegex.exec(html)) !== null) {
      var block = match[1];

      // Link
      var hrefMatch = block.match(/<a\b[^>]*class=["'][^"']*lnk-blk[^"']*["'][^>]*href=["']([^"']+)["']/i);
      if (!hrefMatch) {
        hrefMatch = block.match(/<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*lnk-blk/i);
      }
      if (!hrefMatch) {
        hrefMatch = block.match(/<header[^>]*>\s*<h2[^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i);
      }
      if (!hrefMatch) {
        hrefMatch = block.match(/<a\b[^>]*href=["']([^"']+)["']/i);
      }
      var href = hrefMatch ? absoluteUrl(baseUrl, hrefMatch[1]) : "";
      if (!href || seen[href]) continue;

      // Title
      var titleMatch = block.match(/<header\b[^>]*>[\s\S]*?<h2\b[^>]*>([\s\S]*?)<\/h2>/i);
      if (!titleMatch) {
        titleMatch = block.match(/<h2\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h2>/i);
      }
      if (!titleMatch) {
        titleMatch = block.match(/<h2\b[^>]*>([\s\S]*?)<\/h2>/i);
      }
      var title = titleMatch ? stripTags(titleMatch[1]) : "";
      if (!title) title = "Unknown";

      // Poster
      var posterMatch = block.match(/<img\b[^>]*data-lazy-src=["']([^"']+)["']/i);
      if (!posterMatch) {
        posterMatch = block.match(/<img\b[^>]*src=["']([^"']+)["']/i);
      }
      var posterUrl = "";
      if (posterMatch && posterMatch[1] && !posterMatch[1].startsWith("data:image")) {
        posterUrl = absoluteUrl(baseUrl, posterMatch[1]);
      } else {
        var altPoster = block.match(/<img\b[^>]*data-src=["']([^"']+)["']/i);
        if (altPoster) posterUrl = absoluteUrl(baseUrl, altPoster[1]);
      }

      seen[href] = true;
      items.push(
        new MultimediaItem({
          title: title,
          url: href,
          posterUrl: posterUrl,
          type: "anime",
          headers: { Referer: baseUrl + "/" },
        })
      );
    }

    return items;
  }

  /* ========================================================================= */
  /* Stream Extractors                                                         */
  /* ========================================================================= */

  /**
   * AbyssPlayer Extractor (abyssplayer.com / abyss.to)
   * Resolves sources through https://enc-dec.app/api/dec-abyss
   */
  async function extractAbyss(url) {
    var streams = [];
    try {
      var abyssHeaders = {
        "User-Agent": USER_AGENT,
        Origin: "https://playhydrax.com",
        Referer: "https://playhydrax.com/",
      };
      var res = await request(url, { headers: abyssHeaders, timeout: 15000 });
      var body = res.body || "";
      var match = body.match(/const\s+datas\s*=\s*"([^"]*)"/);
      if (!match || !match[1]) return streams;

      var decRes = await postJson(
        ABYSS_DEC_API,
        { text: match[1] },
        abyssHeaders
      );
      var decData = parseJsonSafe(decRes.body, {});
      if (decData && decData.result && Array.isArray(decData.result.sources)) {
        decData.result.sources.forEach(function (source) {
          if (source.status === true || typeof source.status === "undefined") {
            var qual = source.type || "720";
            var codec = source.codec ? " [" + String(source.codec).toUpperCase() + "]" : "";
            streams.push(
              new StreamResult({
                url: source.url,
                source: "AbyssPlayer" + codec,
                quality: String(qual).endsWith("p") ? qual : qual + "p",
                headers: { Referer: "https://playhydrax.com/" },
              })
            );
          }
        });
      }
    } catch (e) {
      console.log("[ExtractAbyss Error]", String(e));
    }
    return streams;
  }

  /**
   * StreamRuby Extractor (rubystm.com / streamruby.com)
   */
  async function extractStreamRuby(url) {
    var streams = [];
    try {
      var cleanedUrl = url.replace(/\/e(?:\/|$)/, "/");
      var rubyHeaders = {
        "User-Agent": USER_AGENT,
        "X-Requested-With": "XMLHttpRequest",
        Referer: cleanedUrl,
      };
      var body = await getText(cleanedUrl, rubyHeaders);
      var unpacked = unpackJs(body) || body;
      var fileMatch = unpacked.match(/file:\s*["']([^"']+)["']/i) || unpacked.match(/["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/i);
      if (fileMatch && fileMatch[1]) {
        streams.push(
          new StreamResult({
            url: fileMatch[1],
            source: "StreamRuby",
            quality: "HD",
            headers: {
              Accept: "*/*",
              Connection: "keep-alive",
              "Sec-Fetch-Dest": "empty",
              "Sec-Fetch-Mode": "cors",
              "Sec-Fetch-Site": "cross-site",
              Origin: cleanedUrl,
              Referer: cleanedUrl,
            },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractStreamRuby Error]", String(e));
    }
    return streams;
  }

  /**
   * AWSStream / Zephyrflick Extractor (z.awstream.net / as-cdn21.top)
   */
  async function extractAWSStream(url, name) {
    var streams = [];
    try {
      var serverName = name || "AWSStream";
      var origin = absoluteUrl(url, "/").replace(/\/+$/, "");
      var hash = url.split("/").filter(Boolean).pop();
      if (!hash) return streams;

      var apiEndpoint = origin + "/player/index.php?data=" + encodeURIComponent(hash) + "&do=getVideo";
      var formRes = await postForm(
        apiEndpoint,
        { hash: hash, r: origin },
        {
          "User-Agent": USER_AGENT,
          "x-requested-with": "XMLHttpRequest",
          Referer: url,
        }
      );
      var resJson = parseJsonSafe(formRes.body, {});
      if (resJson && resJson.videoSource) {
        streams.push(
          new StreamResult({
            url: resJson.videoSource,
            source: serverName,
            quality: "HD",
            headers: { Referer: origin + "/" },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractAWSStream Error]", String(e));
    }
    return streams;
  }

  /**
   * Blakiteapi Extractor (blakiteapi.xyz)
   */
  async function extractBlakiteapi(url) {
    var streams = [];
    try {
      var origin = absoluteUrl(url, "/").replace(/\/+$/, "");
      var id = url.split("/").filter(Boolean).pop();
      var tmdbMatch = url.match(/embed\/([^\/]+)/);
      var tmdbId = tmdbMatch ? tmdbMatch[1] : "";

      var apiEndpoint = origin + "/api/get.php?id=" + encodeURIComponent(id || "") + "&tmdbId=" + encodeURIComponent(tmdbId);
      var resJson = await getJson(apiEndpoint, { Referer: url });
      if (resJson && resJson.success && resJson.data) {
        var data = resJson.data;
        var format = data.format || "MP4";
        var streamUrl = origin + "/stream/" + data.dataId + "." + format;
        streams.push(
          new StreamResult({
            url: streamUrl,
            source: "Blakiteapi",
            quality: data.quality || "480p",
            headers: { Referer: origin + "/" },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractBlakiteapi Error]", String(e));
    }
    return streams;
  }

  /**
   * Vidhide / Animezia Extractor (animezia.cloud / vidhide* / streamhide*)
   */
  async function extractVidhide(url, name) {
    var streams = [];
    try {
      var serverName = name || "Animezia";
      var body = await getText(url, { Referer: url });
      var unpacked = unpackJs(body);
      var m3u8Match = (unpacked || body).match(/["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/i);
      if (!m3u8Match) {
        m3u8Match = (unpacked || body).match(/sources\s*:\s*\[\s*\{\s*file\s*:\s*["']([^"']+)["']/i);
      }
      if (m3u8Match && m3u8Match[1]) {
        streams.push(
          new StreamResult({
            url: m3u8Match[1],
            source: serverName,
            quality: "Auto",
            headers: { Referer: url },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractVidhide Error]", String(e));
    }
    return streams;
  }

  /**
   * StreamWish / Cdnwish / Multimovies Extractor (cdnwish.com / multimovies.cloud / streamwish)
   */
  async function extractStreamWish(url, name) {
    var streams = [];
    try {
      var serverName = name || "StreamWish";
      var body = await getText(url, { Referer: url });
      var unpacked = unpackJs(body);
      var match = (unpacked || body).match(/sources\s*:\s*\[\s*\{\s*file\s*:\s*["']([^"']+)["']/i);
      if (!match) {
        match = (unpacked || body).match(/file\s*:\s*["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/i);
      }
      if (match && match[1]) {
        streams.push(
          new StreamResult({
            url: match[1],
            source: serverName,
            quality: "Auto",
            headers: { Referer: url },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractStreamWish Error]", String(e));
    }
    return streams;
  }

  /**
   * VidStack / Cloudy / Vidcloud Extractor (cloudy.upns.one / vidcloud.upns.ink / vidc.upns.pro)
   */
  async function extractVidStack(url, name) {
    var streams = [];
    try {
      var serverName = name || "VidCloud";
      var body = await getText(url, { Referer: url });
      var unpacked = unpackJs(body);
      var match = (unpacked || body).match(/file\s*:\s*["']([^"']+)["']/i);
      if (!match) {
        match = (unpacked || body).match(/src\s*:\s*["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/i);
      }
      if (match && match[1]) {
        streams.push(
          new StreamResult({
            url: match[1],
            source: serverName,
            quality: "Auto",
            headers: { Referer: url },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractVidStack Error]", String(e));
    }
    return streams;
  }

  /**
   * FileMoon / Filesim / FilemoonNL Extractor (filemoon.sx / filemoon.nl)
   */
  async function extractFileMoon(url, name) {
    var streams = [];
    try {
      var serverName = name || "FileMoon";
      var body = await getText(url, { Referer: url });
      var unpacked = unpackJs(body);
      var match = (unpacked || body).match(/sources\s*:\s*\[\s*\{\s*file\s*:\s*["']([^"']+)["']/i);
      if (!match) {
        match = (unpacked || body).match(/file\s*:\s*["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/i);
      }
      if (match && match[1]) {
        streams.push(
          new StreamResult({
            url: match[1],
            source: serverName,
            quality: "Auto",
            headers: { Referer: url },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractFileMoon Error]", String(e));
    }
    return streams;
  }

  /**
   * Vidmoly Extractor (vidmoly.net)
   */
  async function extractVidmoly(url) {
    var streams = [];
    try {
      var body = await getText(url, { Referer: url });
      var match = body.match(/sources\s*:\s*\[\s*\{\s*file\s*:\s*["']([^"']+)["']/i);
      if (match && match[1]) {
        streams.push(
          new StreamResult({
            url: match[1],
            source: "Vidmoly",
            quality: "Auto",
            headers: { Referer: url },
          })
        );
      }
    } catch (e) {
      console.log("[ExtractVidmoly Error]", String(e));
    }
    return streams;
  }

  /**
   * Animedekhoco Extractor (animedekho.co)
   */
  async function extractAnimedekhoco(url) {
    var streams = [];
    try {
      var body = await getText(url, { Referer: url });
      // 1) Direct file regex
      var fileMatch = body.match(/file\s*:\s*["']([^"']+)["']/i);
      if (fileMatch && fileMatch[1]) {
        streams.push(
          new StreamResult({
            url: fileMatch[1],
            source: "AnimeDekho Server",
            quality: "HD",
            headers: { Referer: url },
          })
        );
      }
      // 2) Server selector options
      var optionRegex = /<option\b[^>]*value=["']([^"']+)["'][^>]*>([\s\S]*?)<\/option>/gi;
      var optMatch;
      while ((optMatch = optionRegex.exec(body)) !== null) {
        var optVal = optMatch[1];
        var optName = stripTags(optMatch[2]) || "Server";
        if (optVal && optVal !== "0" && /^https?:\/\//i.test(optVal)) {
          var subStreams = await dispatchExtractor(optVal, optName);
          streams.push.apply(streams, subStreams);
        }
      }
    } catch (e) {
      console.log("[ExtractAnimedekhoco Error]", String(e));
    }
    return streams;
  }

  /**
   * Universal Extractor Router
   * Maps server/iframe URLs to appropriate specialized extractors
   */
  async function dispatchExtractor(url, nameHint) {
    if (!url || typeof url !== "string") return [];
    var clean = url.trim();
    if (!/^https?:\/\//i.test(clean)) return [];

    var lower = clean.toLowerCase();

    // AbyssPlayer / Abyss
    if (lower.indexOf("abyssplayer") !== -1 || lower.indexOf("abyss.to") !== -1) {
      return await extractAbyss(clean);
    }

    // StreamRuby / Rubystm
    if (lower.indexOf("rubystm") !== -1 || lower.indexOf("streamruby") !== -1 || lower.indexOf("rubystream") !== -1) {
      return await extractStreamRuby(clean);
    }

    // AWSStream / Zephyrflick / as-cdn21
    if (lower.indexOf("awstream") !== -1 || lower.indexOf("as-cdn21") !== -1 || lower.indexOf("zephyrflick") !== -1) {
      var sName = lower.indexOf("as-cdn21") !== -1 ? "Zephyrflick" : "AWSStream";
      return await extractAWSStream(clean, sName);
    }

    // Blakiteapi
    if (lower.indexOf("blakiteapi") !== -1) {
      return await extractBlakiteapi(clean);
    }

    // Vidhide / Animezia
    if (lower.indexOf("animezia") !== -1 || lower.indexOf("vidhide") !== -1 || lower.indexOf("streamhide") !== -1) {
      return await extractVidhide(clean, nameHint || "Animezia");
    }

    // StreamWish / Cdnwish / Multimovies
    if (lower.indexOf("cdnwish") !== -1 || lower.indexOf("multimovies") !== -1 || lower.indexOf("streamwish") !== -1 || lower.indexOf("wish") !== -1) {
      return await extractStreamWish(clean, nameHint || "StreamWish");
    }

    // VidStack / Cloudy / Vidcloud
    if (lower.indexOf("cloudy.upns") !== -1 || lower.indexOf("vidcloud.upns") !== -1 || lower.indexOf("vidc.upns") !== -1 || lower.indexOf("upns") !== -1) {
      return await extractVidStack(clean, nameHint || "VidCloud");
    }

    // FileMoon / Filesim / FilemoonNL
    if (lower.indexOf("filemoon") !== -1 || lower.indexOf("filesim") !== -1) {
      return await extractFileMoon(clean, nameHint || "FileMoon");
    }

    // Vidmoly
    if (lower.indexOf("vidmoly") !== -1) {
      return await extractVidmoly(clean);
    }

    // Animedekho.co
    if (lower.indexOf("animedekho.co") !== -1) {
      return await extractAnimedekhoco(clean);
    }

    // Fallback: check if direct stream
    if (/\.(m3u8|mp4)(?:$|\?)/i.test(clean)) {
      return [
        new StreamResult({
          url: clean,
          source: nameHint || "Direct Stream",
          quality: "Auto",
          headers: { Referer: clean },
        }),
      ];
    }

    // Generic iframe content scan
    try {
      var body = await getText(clean, { Referer: clean });
      var unpacked = unpackJs(body);
      var m3u8 = (unpacked || body).match(/["'](https?:\/\/[^"']+\.m3u8[^"']*)["']/i);
      if (m3u8 && m3u8[1]) {
        return [
          new StreamResult({
            url: m3u8[1],
            source: nameHint || "HLS Stream",
            quality: "Auto",
            headers: { Referer: clean },
          }),
        ];
      }
    } catch (_) {}

    return [];
  }

  /* ========================================================================= */
  /* Public Plugin API: getHome                                                */
  /* ========================================================================= */

  var HOME_CATEGORIES = [
    { title: "Anime", path: "/category/anime/" },
    { title: "Cartoon", path: "/category/cartoon/" },
    { title: "Crunchyroll", path: "/category/crunchyroll/" },
    { title: "Hindi Dub", path: "/category/hindi-dub/" },
    { title: "Tamil", path: "/category/tamil/" },
    { title: "Telugu", path: "/category/telugu/" },
  ];

  /**
   * Loads the home screen categories.
   * @param {(res: Response) => void} cb
   */
  async function getHome(cb) {
    try {
      var baseUrl = runtimeManifest.baseUrl || DEFAULT_BASE_URL;
      var data = {};

      var promises = HOME_CATEGORIES.map(function (cat) {
        var catUrl = absoluteUrl(baseUrl, cat.path);
        return getText(catUrl, { Referer: baseUrl + "/" })
          .then(function (html) {
            var items = parsePostArticles(html, baseUrl);
            return { title: cat.title, items: items };
          })
          .catch(function () {
            return { title: cat.title, items: [] };
          });
      });

      var results = await Promise.all(promises);

      // Hero Carousel: Trending (populated from Anime category)
      var animeResults = results.find(function (r) {
        return r.title === "Anime";
      });
      if (animeResults && animeResults.items.length > 0) {
        data["Trending"] = animeResults.items.slice(0, 10);
      } else if (results.length > 0 && results[0].items.length > 0) {
        data["Trending"] = results[0].items.slice(0, 10);
      }

      // Add each category row
      results.forEach(function (res) {
        if (res.items.length > 0) {
          data[res.title] = res.items;
        }
      });

      cb({ success: true, data: data });
    } catch (e) {
      cb({ success: false, errorCode: "GET_HOME_ERROR", message: String(e && e.stack ? e.stack : e) });
    }
  }

  /* ========================================================================= */
  /* Public Plugin API: search                                                 */
  /* ========================================================================= */

  /**
   * Searches for anime/media items.
   * @param {string} query
   * @param {(res: Response) => void} cb
   */
  async function search(query, cb) {
    try {
      var baseUrl = runtimeManifest.baseUrl || DEFAULT_BASE_URL;
      var searchUrl = baseUrl + "/?s=" + encodeURIComponent(query);
      var html = await getText(searchUrl, { Referer: baseUrl + "/" });
      var items = parsePostArticles(html, baseUrl);

      cb({ success: true, data: items });
    } catch (e) {
      cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e && e.stack ? e.stack : e) });
    }
  }

  /* ========================================================================= */
  /* Public Plugin API: load                                                   */
  /* ========================================================================= */

  /**
   * Loads details for a specific media item.
   * @param {string} url
   * @param {(res: Response) => void} cb
   */
  async function load(url, cb) {
    try {
      var baseUrl = runtimeManifest.baseUrl || DEFAULT_BASE_URL;
      var cleanUrl = url;

      // Handle JSON-serialized Media string
      if (typeof cleanUrl === "string" && cleanUrl.trim().charAt(0) === "{") {
        var parsedMedia = parseJsonSafe(cleanUrl, null);
        if (parsedMedia && parsedMedia.url) {
          cleanUrl = parsedMedia.url;
        }
      }

      cleanUrl = absoluteUrl(baseUrl, cleanUrl);
      var html = await getText(cleanUrl, {
        Referer: baseUrl + "/",
        Cookie: "toronites_server=vidstream",
      });

      // Title
      var titleMatch = html.match(/<h1\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i);
      var rawTitle = titleMatch ? stripTags(titleMatch[1]) : "";
      if (rawTitle) {
        rawTitle = rawTitle.replace(/^Watch\s+Online\s+/i, "");
      }
      if (!rawTitle) {
        var ogTitle = html.match(/<meta\b[^>]*property=["']og:title["'][^>]*content=["']([^"']+)["']/i);
        if (ogTitle) {
          rawTitle = ogTitle[1].replace(/^Watch\s+Online\s+/i, "").replace(/\s+Movie\s+in\s+Hindi\s+Dubbed\s+Free.*$/i, "");
        }
      }
      var title = trim(rawTitle) || "Unknown Title";

      // Poster
      var posterMatch = html.match(/<div\b[^>]*class=["'][^"']*post-thumbnail[^"']*["'][\s\S]*?<img\b[^>]*data-lazy-src=["']([^"']+)["']/i);
      if (!posterMatch) {
        posterMatch = html.match(/<div\b[^>]*class=["'][^"']*post-thumbnail[^"']*["'][\s\S]*?<img\b[^>]*src=["']([^"']+)["']/i);
      }
      if (!posterMatch) {
        posterMatch = html.match(/<meta\b[^>]*property=["']og:image["'][^>]*content=["']([^"']+)["']/i);
      }
      var posterUrl = posterMatch ? absoluteUrl(baseUrl, posterMatch[1]) : "";

      // Description / Plot
      var plotMatch = html.match(/<div\b[^>]*class=["'][^"']*entry-content[^"']*["'][\s\S]*?<p\b[^>]*>([\s\S]*?)<\/p>/i);
      var description = plotMatch ? stripTags(plotMatch[1]) : "";
      if (!description) {
        var twDesc = html.match(/<meta\b[^>]*name=["']twitter:description["'][^>]*content=["']([^"']+)["']/i);
        if (twDesc) description = decodeHtmlEntities(twDesc[1]);
      }
      if (!description) {
        var ogDesc = html.match(/<meta\b[^>]*property=["']og:description["'][^>]*content=["']([^"']+)["']/i);
        if (ogDesc) description = decodeHtmlEntities(ogDesc[1]);
      }

      // Year
      var yearMatch = html.match(/<span\b[^>]*class=["'][^"']*year[^"']*["'][^>]*>([\s\S]*?)<\/span>/i);
      var yearStr = yearMatch ? stripTags(yearMatch[1]) : "";
      if (!yearStr) {
        var updTime = html.match(/<meta\b[^>]*property=["']og:updated_time["'][^>]*content=["']([^"']+)["']/i);
        if (updTime) {
          var yMatch = updTime[1].match(/\b(19\d\d|20\d\d)\b/);
          if (yMatch) yearStr = yMatch[1];
        }
      }
      var year = parseInt(yearStr, 10) || undefined;

      // Tags / Genres
      var tags = [];
      var genreBlockMatch = html.match(/<ul\b[^>]*class=["'][^"']*details-lst[^"']*["'][\s\S]*?<\/ul>/i);
      var genreSource = genreBlockMatch ? genreBlockMatch[0] : html;
      var genreRegex = /<a\b[^>]*href=["'][^"']*\/genre\/[^"']*["'][^>]*>([\s\S]*?)<\/a>/gi;
      var gMatch;
      while ((gMatch = genreRegex.exec(genreSource)) !== null) {
        var gName = stripTags(gMatch[1]);
        if (gName && tags.indexOf(gName) === -1) tags.push(gName);
      }

      // External Metadata IDs
      var tmdbId = "";
      var tmdbMatch = html.match(/themoviedb\.org\/(?:tv|movie)\/(\d+)/i);
      if (tmdbMatch) tmdbId = tmdbMatch[1];

      var anilistId = "";
      var malId = "";
      var anilistMatch = html.match(/anilist\.php\?id=(\d+)/i);
      if (anilistMatch) anilistId = anilistMatch[1];
      var malMatch = html.match(/myanimelist\.php\?id=(\d+)/i);
      if (malMatch) malId = malMatch[1];

      // AniZip Metadata Resolution
      var bannerUrl = "";
      var aniZipEpisodes = {};
      var aniZipUrls = [];
      if (tmdbId) aniZipUrls.push(ANIZIP_BASE + "?themoviedb_id=" + tmdbId);
      if (anilistId) aniZipUrls.push(ANIZIP_BASE + "?anilist_id=" + anilistId);
      if (malId) aniZipUrls.push(ANIZIP_BASE + "?mal_id=" + malId);

      for (var i = 0; i < aniZipUrls.length; i++) {
        try {
          var aniZipData = await getJson(aniZipUrls[i]);
          if (aniZipData && (aniZipData.images || aniZipData.episodes || aniZipData.mappings)) {
            // Fanart & Poster
            if (Array.isArray(aniZipData.images)) {
              var fanart = aniZipData.images.find(function (img) {
                return img && img.coverType === "Fanart";
              });
              if (fanart && fanart.url) bannerUrl = fanart.url;

              var posterImg = aniZipData.images.find(function (img) {
                return img && img.coverType === "Poster";
              });
              if (posterImg && posterImg.url && !posterUrl) posterUrl = posterImg.url;
            }
            if (aniZipData.episodes && typeof aniZipData.episodes === "object") {
              aniZipEpisodes = aniZipData.episodes;
            }
            if (!tmdbId && aniZipData.mappings && aniZipData.mappings.themoviedb_id) {
              tmdbId = String(aniZipData.mappings.themoviedb_id);
            }
            break;
          }
        } catch (_) {}
      }

      // Check if Series or Movie
      var seasonListRegex = /<ul\b[^>]*class=["'][^"']*seasons-lst[^"']*["']([\s\S]*?)<\/ul>/i;
      var hasSeasonsList = seasonListRegex.test(html);

      // Recommendations
      var recommendations = [];
      var recBlockMatch = html.match(/<div\b[^>]*class=["'][^"']*swiper-wrapper[^"']*["']([\s\S]*?)<\/div>/i);
      if (recBlockMatch) {
        recommendations = parsePostArticles(recBlockMatch[1], baseUrl);
      }

      // Case 1: MOVIE (No seasons list found)
      if (!hasSeasonsList) {
        var movieEpisode = new Episode({
          name: title,
          url: cleanUrl,
          season: 0,
          episode: 0,
          posterUrl: posterUrl,
          description: description,
          headers: { Referer: baseUrl + "/" },
        });

        cb({
          success: true,
          data: new MultimediaItem({
            title: title,
            url: cleanUrl,
            posterUrl: posterUrl,
            bannerUrl: bannerUrl || undefined,
            type: "movie",
            description: description,
            year: year,
            tags: tags,
            episodes: [movieEpisode],
            recommendations: recommendations,
            headers: { Referer: baseUrl + "/" },
          }),
        });
        return;
      }

      // Case 2: SERIES / ANIME (Episodes list)
      var seasonBlock = html.match(seasonListRegex)[1];
      var episodeLiRegex = /<li\b[^>]*>([\s\S]*?)<\/li>/gi;
      var epMatch;
      var episodesRaw = [];
      var seasonsPresent = {};

      while ((epMatch = episodeLiRegex.exec(seasonBlock)) !== null) {
        var epBlock = epMatch[1];

        // Episode link
        var epHrefMatch = epBlock.match(/<a\b[^>]*href=["']([^"']+)["']/i);
        if (!epHrefMatch) continue;
        var epHref = absoluteUrl(baseUrl, epHrefMatch[1]);

        // Title
        var epTitleMatch = epBlock.match(/<h3\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/h3>/i);
        var rawEpTitle = epTitleMatch ? stripTags(epTitleMatch[1]) : "";

        // Span with S01 - E01
        var spanMatch = epBlock.match(/<h3\b[^>]*class=["'][^"']*title[^"']*["'][\s\S]*?<span\b[^>]*>([\s\S]*?)<\/span>/i);
        var spanText = spanMatch ? stripTags(spanMatch[1]) : "";

        // Season & Episode numbers
        var sNum = 1;
        var eNum = 1;
        var sParse = spanText.match(/S(\d+)/i);
        if (sParse) sNum = parseInt(sParse[1], 10);
        var eParse = spanText.match(/E(\d+)/i);
        if (eParse) eNum = parseInt(eParse[1], 10);

        seasonsPresent[sNum] = true;

        // Clean name (removing S01 - E01 part)
        var cleanEpName = rawEpTitle.replace(/S\d+\s*-\s*E\d+/i, "").trim();
        if (!cleanEpName) cleanEpName = "Episode " + eNum;

        // Episode thumbnail
        var epImgMatch = epBlock.match(/<img\b[^>]*data-lazy-src=["']([^"']+)["']/i);
        if (!epImgMatch) {
          epImgMatch = epBlock.match(/<img\b[^>]*src=["']([^"']+)["']/i);
        }
        var epPoster = epImgMatch ? absoluteUrl(baseUrl, epImgMatch[1]) : "";

        episodesRaw.push({
          url: epHref,
          name: cleanEpName,
          season: sNum,
          episode: eNum,
          poster: epPoster,
        });
      }

      // Fetch TMDB Seasons Metadata if tmdbId is present
      var tmdbSeasonData = {};
      if (tmdbId) {
        var seasonNums = Object.keys(seasonsPresent);
        var tmdbPromises = seasonNums.map(function (s) {
          var sUrl = TMDB_API_BASE + "/tv/" + tmdbId + "/season/" + s + "?api_key=" + TMDB_API_KEY;
          return getJson(sUrl)
            .then(function (sJson) {
              if (sJson && Array.isArray(sJson.episodes)) {
                tmdbSeasonData[s] = sJson.episodes;
              }
            })
            .catch(function () {});
        });
        await Promise.all(tmdbPromises);
      }

      // Assemble final Episodes
      var episodes = episodesRaw.map(function (item) {
        var finalName = item.name;
        var finalPoster = item.poster || posterUrl;
        var finalDesc = "";
        var finalScore = undefined;

        // 1) Match from TMDB
        if (tmdbSeasonData[item.season]) {
          var tmdbEp = tmdbSeasonData[item.season].find(function (ep) {
            return ep.episode_number === item.episode;
          });
          if (tmdbEp) {
            if (tmdbEp.name) finalName = tmdbEp.name;
            if (tmdbEp.still_path) finalPoster = TMDB_IMAGE_BASE + "/w500" + tmdbEp.still_path;
            if (tmdbEp.overview) finalDesc = tmdbEp.overview;
            if (tmdbEp.vote_average && tmdbEp.vote_average > 0) finalScore = tmdbEp.vote_average;
          }
        }

        // 2) Fallback to AniZip
        if ((!finalDesc || finalName === item.name) && aniZipEpisodes[String(item.episode)]) {
          var azEp = aniZipEpisodes[String(item.episode)];
          if (azEp.title) {
            finalName = azEp.title.en || azEp.title["x-jat"] || finalName;
          }
          if (azEp.image && !finalPoster) finalPoster = azEp.image;
          if (azEp.overview && !finalDesc) finalDesc = azEp.overview;
          if (azEp.rating && !finalScore) finalScore = parseFloat(azEp.rating);
        }

        return new Episode({
          name: finalName,
          url: item.url,
          season: item.season,
          episode: item.episode,
          posterUrl: finalPoster,
          description: finalDesc,
          score: finalScore,
          headers: { Referer: baseUrl + "/" },
        });
      });

      cb({
        success: true,
        data: new MultimediaItem({
          title: title,
          url: cleanUrl,
          posterUrl: posterUrl,
          bannerUrl: bannerUrl || undefined,
          type: "anime",
          description: description,
          year: year,
          tags: tags,
          episodes: episodes,
          recommendations: recommendations,
          headers: { Referer: baseUrl + "/" },
        }),
      });
    } catch (e) {
      cb({ success: false, errorCode: "LOAD_ERROR", message: String(e && e.stack ? e.stack : e) });
    }
  }

  /* ========================================================================= */
  /* Public Plugin API: loadStreams                                            */
  /* ========================================================================= */

  /**
   * Resolves streams for a specific media item or episode.
   * @param {string} url
   * @param {(res: Response) => void} cb
   */
  async function loadStreams(url, cb) {
    try {
      var baseUrl = runtimeManifest.baseUrl || DEFAULT_BASE_URL;
      var cleanUrl = url;

      // Handle JSON-serialized Media string
      if (typeof cleanUrl === "string" && cleanUrl.trim().charAt(0) === "{") {
        var parsedMedia = parseJsonSafe(cleanUrl, null);
        if (parsedMedia && parsedMedia.url) {
          cleanUrl = parsedMedia.url;
        }
      }

      cleanUrl = absoluteUrl(baseUrl, cleanUrl);

      // Fetch the episode / movie page with vidstream cookie
      var pageHtml = await getText(cleanUrl, {
        Referer: baseUrl + "/",
        Cookie: "toronites_server=vidstream",
      });

      var serverUrls = [];

      // 1) Direct iframes present in the page HTML
      var iframeRegex = /<iframe\b[^>]*src=["']([^"']+)["']/gi;
      var ifMatch;
      while ((ifMatch = iframeRegex.exec(pageHtml)) !== null) {
        var src = ifMatch[1];
        if (src && !/about:blank|googletag/i.test(src)) {
          serverUrls.push(src);
        }
      }

      // 2) Extract postid/term ID from <body> class
      var bodyClassMatch = pageHtml.match(/<body\b[^>]*class=["']([^"']+)["']/i);
      var bodyClass = bodyClassMatch ? bodyClassMatch[1] : "";
      var termMatch = bodyClass.match(/(?:term|postid)-(\d+)/i);
      var termId = termMatch ? termMatch[1] : "";

      // 3) Concurrently query server endpoints: /?trdekho=${i}&trid=${termId}&trtype=2 (or trtype=1 for movies)
      if (termId) {
        var isMovie = /movie/i.test(cleanUrl) || /single-movies/i.test(bodyClass);
        var primaryTrType = isMovie ? 1 : 2;
        var iterations = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        var queryPromises = iterations.map(function (i) {
          var trUrl = baseUrl + "/?trdekho=" + i + "&trid=" + termId + "&trtype=" + primaryTrType;
          return getText(trUrl, { Referer: cleanUrl, Cookie: "toronites_server=vidstream" })
            .then(function (trHtml) {
              var sIframeMatch = trHtml.match(/<iframe\b[^>]*src=["']([^"']+)["']/i);
              return sIframeMatch ? sIframeMatch[1] : null;
            })
            .catch(function () {
              return null;
            });
        });

        var results = await Promise.all(queryPromises);
        results.forEach(function (sUrl) {
          if (sUrl && serverUrls.indexOf(sUrl) === -1) {
            serverUrls.push(sUrl);
          }
        });

        // Fallback: If no servers were found with primary trtype, try secondary trtype
        if (serverUrls.length === 0) {
          var secondaryTrType = isMovie ? 2 : 1;
          var fallbackPromises = iterations.map(function (i) {
            var trUrl = baseUrl + "/?trdekho=" + i + "&trid=" + termId + "&trtype=" + secondaryTrType;
            return getText(trUrl, { Referer: cleanUrl, Cookie: "toronites_server=vidstream" })
              .then(function (trHtml) {
                var sIframeMatch = trHtml.match(/<iframe\b[^>]*src=["']([^"']+)["']/i);
                return sIframeMatch ? sIframeMatch[1] : null;
              })
              .catch(function () {
                return null;
              });
          });
          var fallbackResults = await Promise.all(fallbackPromises);
          fallbackResults.forEach(function (sUrl) {
            if (sUrl && serverUrls.indexOf(sUrl) === -1) {
              serverUrls.push(sUrl);
            }
          });
        }
      }

      // Deduplicate server URLs
      var uniqueServers = [];
      var seenServers = {};
      serverUrls.forEach(function (sUrl) {
        var norm = sUrl.trim();
        if (norm && !seenServers[norm]) {
          seenServers[norm] = true;
          uniqueServers.push(norm);
        }
      });

      // Extract streams from each server URL
      var streamPromises = uniqueServers.map(function (sUrl) {
        return dispatchExtractor(sUrl).catch(function () {
          return [];
        });
      });

      var streamBatches = await Promise.all(streamPromises);
      var allStreams = [];
      var seenStreamUrls = {};

      streamBatches.forEach(function (batch) {
        batch.forEach(function (stream) {
          if (stream && stream.url && !seenStreamUrls[stream.url]) {
            seenStreamUrls[stream.url] = true;
            allStreams.push(stream);
          }
        });
      });

      // Sort streams by quality descending
      allStreams.sort(function (a, b) {
        var qa = getQualityFromText(a.quality || a.source);
        var qb = getQualityFromText(b.quality || b.source);
        return qb - qa;
      });

      cb({ success: true, data: allStreams });
    } catch (e) {
      cb({ success: false, errorCode: "STREAM_ERROR", message: String(e && e.stack ? e.stack : e) });
    }
  }

  // Export to global scope for namespaced IIFE capture
  globalThis.getHome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
