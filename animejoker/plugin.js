(function () {
  "use strict";

  // ========== Config ==========
  var BASE_URL = String(
    (typeof manifest !== "undefined" && manifest && manifest.baseUrl) ||
      "https://animejoker.com",
  ).replace(/\/+$/, "");

  var USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";

  var PAGE_HEADERS = {
    "User-Agent": USER_AGENT,
    Accept: "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Accept-Language": "en-US,en;q=0.9",
    Referer: BASE_URL + "/",
  };

  var HGCLOUD_RULES = ["hgcloud.to", "hglink.to", "dhcplay.com"];
  var HGCLOUD_MIRRORS = ["hanerix.com", "audinifer.com", "vibuxer.com"];

  var CACHE_TTL = 5 * 60 * 1000;
  var HOME_CACHE = { value: null, time: 0 };

  // ========== Utilities ==========
  function trim(val) {
    return String(val == null ? "" : val).trim();
  }

  function decodeHtml(str) {
    return String(str || "")
      .replace(/&#0*38;/g, "&")
      .replace(/&amp;/g, "&")
      .replace(/&lt;/g, "<")
      .replace(/&gt;/g, ">")
      .replace(/&quot;/g, '"')
      .replace(/&#0*39;/g, "'")
      .replace(/&#8217;/g, "'")
      .replace(/&#8216;/g, "'")
      .replace(/&#8211;/g, "-")
      .replace(/&#8212;/g, "-")
      .replace(/&nbsp;/g, " ")
      .replace(/&#(\d+);/g, function (_, code) {
        var n = parseInt(code, 10);
        return n > 0 && n < 65536 ? String.fromCharCode(n) : _;
      });
  }

  function cleanText(str) {
    return decodeHtml(
      String(str || "")
        .replace(/<br\s*\/?>/gi, "\n")
        .replace(/<[^>]+>/g, " "),
    )
      .replace(/\s+/g, " ")
      .trim();
  }

  function originOf(url) {
    var m = String(url || "").match(/^(https?:\/\/[^\/]+)/i);
    return m ? m[1].replace(/\/+$/, "") : "";
  }

  function hostOf(url) {
    return originOf(url)
      .replace(/^https?:\/\//i, "")
      .toLowerCase();
  }

  function fixUrl(url, base) {
    url = decodeHtml(trim(url));
    if (!url || /^javascript:/i.test(url) || url === "#" || /^data:/i.test(url))
      return "";
    if (/^https?:\/\//i.test(url)) return url;
    if (url.indexOf("//") === 0) return "https:" + url;
    var root = String(base || BASE_URL).replace(/\/+$/, "");
    if (url[0] === "/") {
      var orig = originOf(root) || BASE_URL;
      return orig + url;
    }
    if (url[0] === "?") {
      return root.split("?")[0] + url;
    }
    return root + "/" + url.replace(/^\/+/, "");
  }

  function uniqueBy(list, keyFn) {
    var seen = Object.create(null);
    var out = [];
    for (var i = 0; i < (list || []).length; i++) {
      var item = list[i];
      if (!item) continue;
      var key = keyFn(item);
      if (!key || seen[key]) continue;
      seen[key] = true;
      out.push(item);
    }
    return out;
  }

  function parseAttrs(tag) {
    var attrs = {};
    String(tag || "").replace(
      /([a-zA-Z0-9:_-]+)\s*=\s*(?:"([^"]*)"|'([^']*)'|([^\s>]+))/g,
      function (_, k, v1, v2, v3) {
        attrs[k.toLowerCase()] = decodeHtml(
          v1 != null ? v1 : v2 != null ? v2 : v3 != null ? v3 : "",
        );
        return "";
      },
    );
    return attrs;
  }

  function parseJsonSafe(str, fallback) {
    if (str && typeof str === "object") return str;
    try {
      return JSON.parse(String(str || ""));
    } catch (_) {
      return fallback !== undefined ? fallback : null;
    }
  }

  function parseQuality(text) {
    var s = String(text || "").toLowerCase();
    var m = s.match(
      /(?:^|[^\d])(2160|1440|1080|720|576|540|480|360|240)p?(?:[^\d]|$)/i,
    );
    if (m) return parseInt(m[1], 10);
    if (/\b(?:4k|uhd)\b/.test(s)) return 2160;
    if (/\b(?:2k|qhd)\b/.test(s)) return 1440;
    if (/\bfhd\b/.test(s)) return 1080;
    if (/\bhd\b/.test(s)) return 720;
    return 0;
  }

  function base64Decode(str) {
    str = String(str || "")
      .replace(/-/g, "+")
      .replace(/_/g, "/")
      .replace(/\s+/g, "");
    while (str.length % 4) str += "=";
    try {
      if (typeof atob === "function") return atob(str);
    } catch (_) {}
    try {
      if (typeof Buffer !== "undefined")
        return Buffer.from(str, "base64").toString("utf8");
    } catch (_) {}
    var chars =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var bytes = [];
    for (var i = 0; i < str.length; i += 4) {
      var a = chars.indexOf(str[i]);
      var b = chars.indexOf(str[i + 1] || "=");
      var c = chars.indexOf(str[i + 2] || "=");
      var d = chars.indexOf(str[i + 3] || "=");
      if (a === -1 || b === -1) break;
      bytes.push((a << 2) | (b >> 4));
      if (c !== -1 && str[i + 2] !== "=")
        bytes.push(((b & 15) << 4) | (c >> 2));
      if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
    }
    var out = "";
    for (var j = 0; j < bytes.length; j++) out += String.fromCharCode(bytes[j]);
    return out;
  }

  // ========== HTTP Helpers ==========
  function normalizeHeaders(headers) {
    var out = {};
    if (!headers) return out;
    if (typeof headers.forEach === "function") {
      try {
        headers.forEach(function (v, k) {
          out[String(k || "").toLowerCase()] = v;
        });
        return out;
      } catch (_) {}
    }
    Object.keys(headers).forEach(function (k) {
      out[String(k || "").toLowerCase()] = headers[k];
    });
    return out;
  }

  function normalizeHttpRes(res, url) {
    return {
      status: Number(
        (res && (res.statusCode || res.status || res.code)) || 200,
      ),
      body: String((res && (res.body != null ? res.body : res.text)) || ""),
      headers: normalizeHeaders(res && res.headers),
      url: String((res && (res.finalUrl || res.url)) || url),
    };
  }

  async function httpGet(url, headers) {
    var hdrs = Object.assign({}, PAGE_HEADERS, headers || {});
    try {
      var res = await http_get(url, hdrs);
      return normalizeHttpRes(res, url);
    } catch (err) {
      try {
        var res2 = await http_get(url, {
          headers: hdrs,
          followRedirects: true,
        });
        return normalizeHttpRes(res2, url);
      } catch (_) {
        throw err;
      }
    }
  }

  async function httpPost(url, body, headers) {
    var hdrs = Object.assign(
      {
        "User-Agent": USER_AGENT,
        Accept: "*/*",
        "X-Requested-With": "XMLHttpRequest",
        Referer: BASE_URL + "/",
      },
      headers || {},
    );
    var payload = typeof body === "string" ? body : JSON.stringify(body || {});
    try {
      var res = await http_post(url, hdrs, payload);
      return normalizeHttpRes(res, url);
    } catch (_) {
      var res2 = await http_post(url, payload, hdrs);
      return normalizeHttpRes(res2, url);
    }
  }

  async function httpParallelGet(requests) {
    var items = (requests || []).filter(function (r) {
      return r && r.url;
    });
    if (!items.length) return [];
    if (typeof http_parallel === "function") {
      try {
        var pRes = await http_parallel(
          items.map(function (r) {
            return {
              method: "GET",
              url: r.url,
              headers: Object.assign({}, PAGE_HEADERS, r.headers || {}),
            };
          }),
        );
        return items.map(function (r, idx) {
          return normalizeHttpRes(pRes && pRes[idx], r.url);
        });
      } catch (_) {}
    }
    return Promise.all(
      items.map(function (r) {
        return httpGet(r.url, r.headers).catch(function () {
          return { status: 599, body: "", headers: {}, url: r.url };
        });
      }),
    );
  }

  // ========== P.A.C.K.E.R. JS Unpacker ==========
  function toBase(n, a) {
    var chars =
      "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if (a <= 36) return n.toString(a);
    if (n === 0) return "0";
    var res = "";
    while (n > 0) {
      res = chars[n % a] + res;
      n = Math.floor(n / a);
    }
    return res;
  }

  function unpackJS(script) {
    if (!script) return "";
    if (typeof getAndUnpack === "function") {
      try {
        var nativeUnpacked = getAndUnpack(script);
        if (nativeUnpacked && nativeUnpacked !== script)
          return String(nativeUnpacked);
      } catch (_) {}
    }
    try {
      if (script.indexOf("function(p,a,c,k,e") === -1) return "";
      var bracePos = script.lastIndexOf("}(");
      if (bracePos === -1) return "";
      var pos = bracePos + 2;
      var len = script.length;

      function skipWS() {
        while (pos < len && /\s/.test(script[pos])) pos++;
      }
      function readStr() {
        var q = script[pos++];
        var out = "";
        while (pos < len) {
          var ch = script[pos++];
          if (ch === "\\") {
            var esc = script[pos++] || "";
            var map = {
              n: "\n",
              r: "\r",
              t: "\t",
              "\\": "\\",
              "'": "'",
              '"': '"',
            };
            out += map[esc] !== undefined ? map[esc] : esc;
          } else if (ch === q) {
            break;
          } else {
            out += ch;
          }
        }
        return out;
      }
      function readInt() {
        var s = pos;
        while (pos < len && /\d/.test(script[pos])) pos++;
        return parseInt(script.slice(s, pos), 10);
      }
      function skipComma() {
        skipWS();
        if (pos < len && script[pos] === ",") pos++;
        skipWS();
      }

      skipWS();
      if (script[pos] !== "'" && script[pos] !== '"') return "";
      var p = readStr();
      skipComma();
      var a = readInt();
      skipComma();
      var c = readInt();
      skipComma();
      var k;
      if (script[pos] === "'" || script[pos] === '"') {
        k = readStr().split("|");
      } else if (script[pos] === "[") {
        pos++;
        k = [];
        while (pos < len && script[pos] !== "]") {
          skipWS();
          if (script[pos] === "'" || script[pos] === '"') k.push(readStr());
          else pos++;
          skipWS();
          if (script[pos] === ",") pos++;
        }
      } else {
        return "";
      }
      if (isNaN(a) || a < 2 || isNaN(c) || c < 0) return "";
      while (c--) {
        if (k[c]) {
          p = p.replace(new RegExp("\\b" + toBase(c, a) + "\\b", "g"), k[c]);
        }
      }
      return p;
    } catch (_) {
      return "";
    }
  }

  function unpackAllScripts(html) {
    var out = [];
    var re = /eval\(function\(p,a,c,k,e(?:,d)?\)[\s\S]*?(?:<\/script>|$)/gi;
    var m;
    while ((m = re.exec(String(html || ""))) !== null) {
      var unpacked = unpackJS(m[0]);
      if (unpacked) out.push(unpacked);
    }
    return out.join("\n");
  }

  // ========== HTML / Card Parsers (ToroFilm / AnimeJoker) ==========
  function extractImgSrc(block) {
    var imgMatch = String(block || "").match(/<img\b([^>]+)>/i);
    if (!imgMatch) return "";
    var attrs = parseAttrs(imgMatch[1]);
    var candidate =
      attrs["data-src"] ||
      attrs["data-lazy-src"] ||
      attrs["data-original"] ||
      attrs["src"] ||
      "";
    if (/^data:image/i.test(candidate) && attrs["data-src"])
      candidate = attrs["data-src"];
    return fixUrl(candidate, BASE_URL);
  }

  function detectMediaType(url, block) {
    var lowerUrl = String(url || "").toLowerCase();
    if (
      lowerUrl.indexOf("/movies/") !== -1 ||
      lowerUrl.indexOf("/movie/") !== -1
    )
      return "movie";
    if (
      lowerUrl.indexOf("/series/") !== -1 ||
      lowerUrl.indexOf("/episode/") !== -1
    )
      return "anime";
    var lowerBlock = String(block || "").toLowerCase();
    if (/\bmovie\b/.test(lowerBlock) && !/\bseries\b/.test(lowerBlock))
      return "movie";
    return "anime";
  }

  function parseArticleCards(html) {
    var items = [];
    var articleRe = /<article\b([^>]*)>([\s\S]*?)<\/article>/gi;
    var m;
    while ((m = articleRe.exec(String(html || ""))) !== null) {
      var attrsStr = m[1] || "";
      var body = m[2] || "";
      var linkMatch =
        body.match(
          /<a\b[^>]*class=["'][^"']*lnk-blk[^"']*["'][^>]*href=["']([^"']+)["']/i,
        ) ||
        body.match(
          /<a\b[^>]*href=["']([^"']+)["'][^>]*class=["'][^"']*lnk-blk[^"']*["']/i,
        ) ||
        body.match(
          /<h[23]\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>\s*<a\b[^>]*href=["']([^"']+)["']/i,
        ) ||
        body.match(
          /<a\b[^>]*href=["']([^"']*(?:\/series\/|\/movies\/|\/movie\/|\/anime\/)[^"']+)["']/i,
        );
      if (!linkMatch) continue;

      var url = fixUrl(linkMatch[1], BASE_URL);
      if (!url || /\/episode\//i.test(url)) continue;

      var titleMatch =
        body.match(
          /<h[23]\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h[23]>/i,
        ) ||
        body.match(
          /<span\b[^>]*class=["'][^"']*title[^"']*["'][^>]*>([\s\S]*?)<\/span>/i,
        ) ||
        body.match(/<h[23]\b[^>]*>([\s\S]*?)<\/h[23]>/i) ||
        body.match(/title=["']([^"']+)["']/i) ||
        body.match(/alt=["']([^"']+)["']/i);
      var title = cleanText(titleMatch ? titleMatch[1] : "");
      if (!title) continue;

      var poster = extractImgSrc(body);
      var yearMatch = body.match(
        /<span\b[^>]*class=["'][^"']*year[^"']*["'][^>]*>(\d{4})<\/span>/i,
      );
      var scoreMatch =
        body.match(/TMDB\s*([\d.]+)/i) ||
        body.match(
          /<span\b[^>]*class=["'][^"']*vote[^"']*["'][^>]*>[\s\S]*?([\d.]+)/i,
        );

      items.push(
        new MultimediaItem({
          title: title,
          url: url,
          posterUrl: poster || "",
          type: detectMediaType(url, attrsStr + " " + body),
          year: yearMatch ? parseInt(yearMatch[1], 10) : undefined,
          score: scoreMatch ? parseFloat(scoreMatch[1]) : undefined,
        }),
      );
    }
    return uniqueBy(items, function (item) {
      return item.url;
    });
  }

  function stripSidebar(html) {
    return String(html || "").replace(/<aside\b[\s\S]*?<\/aside>/gi, "");
  }

  function parseHomeSections(html) {
    var sections = {};
    var cleaned = stripSidebar(html);

    var secRe = /<section\b[^>]*>([\s\S]*?)<\/section>/gi;
    var m;
    while ((m = secRe.exec(cleaned)) !== null) {
      var block = m[1];
      var headingMatch =
        block.match(
          /<h[1-3]\b[^>]*class=["'][^"']*(?:section-title|widget-title|title)[^"']*["'][^>]*>([\s\S]*?)<\/h[1-3]>/i,
        ) || block.match(/<h[23]\b[^>]*>([\s\S]*?)<\/h[23]>/i);
      var heading = cleanText(headingMatch ? headingMatch[1] : "")
        .replace(/\s*view\s*all\s*$/i, "")
        .trim();
      if (!heading) continue;
      if (
        /^(?:network|stream in your language|genres|latest episodes)$/i.test(
          heading,
        )
      )
        continue;

      var cards = parseArticleCards(block);
      if (cards.length) {
        sections[heading] = cards;
      }
    }

    if (!Object.keys(sections).length) {
      var allCards = parseArticleCards(cleaned);
      if (allCards.length) {
        sections["Trending"] = allCards.slice(0, 12);
        sections["Latest"] = allCards;
      }
    } else {
      var keys = Object.keys(sections);
      if (!sections["Trending"] && keys.length) {
        var heroKey = sections["Newest Drops"] ? "Newest Drops" : keys[0];
        var ordered = { Trending: sections[heroKey].slice(0, 10) };
        keys.forEach(function (k) {
          ordered[k] = sections[k];
        });
        sections = ordered;
      }
    }

    return sections;
  }

  // ========== Core API: getHome ==========
  async function getHome(cb) {
    try {
      if (HOME_CACHE.value && Date.now() - HOME_CACHE.time < CACHE_TTL) {
        return cb({ success: true, data: HOME_CACHE.value });
      }

      var homeRes = await httpGet(BASE_URL + "/", { Referer: BASE_URL + "/" });
      var sections = parseHomeSections(homeRes.body);

      if (Object.keys(sections).length < 2) {
        var extraPages = [
          { title: "Series", url: BASE_URL + "/series/" },
          { title: "Movies", url: BASE_URL + "/movies/" },
        ];
        var extraRes = await httpParallelGet(extraPages);
        for (var i = 0; i < extraPages.length; i++) {
          var cards = parseArticleCards(stripSidebar(extraRes[i].body));
          if (cards.length) sections[extraPages[i].title] = cards;
        }
      }

      if (!Object.keys(sections).length) {
        return cb({
          success: false,
          errorCode: "HOME_ERROR",
          message: "No content sections found on " + BASE_URL,
        });
      }

      HOME_CACHE = { value: sections, time: Date.now() };
      cb({ success: true, data: sections });
    } catch (err) {
      cb({
        success: false,
        errorCode: "HOME_ERROR",
        message: String((err && err.message) || err),
      });
    }
  }

  // ========== Core API: search ==========
  async function search(query, cb) {
    try {
      var q = trim(query);
      if (!q) return cb({ success: true, data: [] });

      var searchUrl = BASE_URL + "/?s=" + encodeURIComponent(q);
      var res = await httpGet(searchUrl, { Referer: BASE_URL + "/" });
      var mainHtml = stripSidebar(res.body);
      var results = parseArticleCards(mainHtml);

      cb({ success: true, data: results });
    } catch (err) {
      cb({
        success: false,
        errorCode: "SEARCH_ERROR",
        message: String((err && err.message) || err),
      });
    }
  }

  // ========== Series / Episode Parsing ==========
  function parseMetaTag(html, name) {
    var escaped = name.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
    var re1 = new RegExp(
      "<meta\\b[^>]+(?:property|name)=[\"']" +
        escaped +
        "[\"'][^>]+content=[\"']([^\"']+)[\"']",
      "i",
    );
    var re2 = new RegExp(
      "<meta\\b[^>]+content=[\"']([^\"']+)[\"'][^>]+(?:property|name)=[\"']" +
        escaped +
        "[\"']",
      "i",
    );
    var m = String(html || "").match(re1) || String(html || "").match(re2);
    return m ? decodeHtml(m[1]) : "";
  }

  function parseEpisodesFromHtml(html, fallbackSeason, fallbackPoster) {
    var episodes = [];
    var artRe = /<article\b[^>]*>([\s\S]*?)<\/article>/gi;
    var m;
    while ((m = artRe.exec(String(html || ""))) !== null) {
      var block = m[1];
      var linkMatch =
        block.match(
          /<a\b[^>]*class=["'][^"']*lnk-blk[^"']*["'][^>]*href=["']([^"']+)["']/i,
        ) || block.match(/<a\b[^>]*href=["']([^"']*\/episode\/[^"']+)["']/i);
      if (!linkMatch) continue;

      var epUrl = fixUrl(linkMatch[1], BASE_URL);
      if (!epUrl || !/\/episode\//i.test(epUrl)) continue;

      var numBadge = cleanText(
        (block.match(
          /<span\b[^>]*class=["'][^"']*num-epi[^"']*["'][^>]*>([\s\S]*?)<\/span>/i,
        ) || [])[1] || "",
      );
      var titleRaw = cleanText(
        (block.match(
          /<h[23]\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h[23]>/i,
        ) || [])[1] ||
          (block.match(/<h[23]\b[^>]*>([\s\S]*?)<\/h[23]>/i) || [])[1] ||
          "",
      );

      var sNum = Number(fallbackSeason || 1);
      var eNum = 0;

      var sxeMatch =
        numBadge.match(/(\d+)\s*[xX]\s*(\d+)/) ||
        epUrl.match(/-(\d+)x(\d+)\/?$/i);
      if (sxeMatch) {
        sNum = parseInt(sxeMatch[1], 10);
        eNum = parseInt(sxeMatch[2], 10);
      } else {
        var epOnly =
          numBadge.match(/(\d+)/) || titleRaw.match(/Episode\s*(\d+)/i);
        if (epOnly) eNum = parseInt(epOnly[1], 10);
      }

      var thumb = extractImgSrc(block) || fallbackPoster || "";
      var epName = titleRaw || "Episode " + (eNum || episodes.length + 1);

      episodes.push(
        new Episode({
          name: epName,
          url: epUrl,
          season: sNum || 1,
          episode: eNum || episodes.length + 1,
          posterUrl: thumb || undefined,
        }),
      );
    }

    if (!episodes.length) {
      var liRe =
        /<li\b[^>]*>([\s\S]*?<a\b[^>]*href=["']([^"']*\/episode\/[^"']+)["'][\s\S]*?)<\/li>/gi;
      while ((m = liRe.exec(String(html || ""))) !== null) {
        var liBody = m[1];
        var url2 = fixUrl(m[2], BASE_URL);
        var sxe2 =
          liBody.match(/(\d+)\s*[xX]\s*(\d+)/) ||
          url2.match(/-(\d+)x(\d+)\/?$/i);
        var s2 = sxe2 ? parseInt(sxe2[1], 10) : Number(fallbackSeason || 1);
        var e2 = sxe2 ? parseInt(sxe2[2], 10) : episodes.length + 1;
        var name2 = cleanText(
          (liBody.match(/<h[23]\b[^>]*>([\s\S]*?)<\/h[23]>/i) || [])[1] ||
            "Episode " + e2,
        );
        episodes.push(
          new Episode({
            name: name2,
            url: url2,
            season: s2,
            episode: e2,
            posterUrl: extractImgSrc(liBody) || fallbackPoster || undefined,
          }),
        );
      }
    }

    return uniqueBy(episodes, function (ep) {
      return ep.url;
    });
  }

  function parseSeasonTriggers(html) {
    var triggers = [];
    var seen = Object.create(null);
    var aRe = /<a\b([^>]*data-season=["'][^"']+["'][^>]*)>/gi;
    var m;
    while ((m = aRe.exec(String(html || ""))) !== null) {
      var attrs = parseAttrs(m[1]);
      var postId = trim(attrs["data-post"] || "");
      var seasonNum = parseInt(attrs["data-season"], 10);
      if (!postId || !seasonNum) continue;
      var key = postId + ":" + seasonNum;
      if (seen[key]) continue;
      seen[key] = true;
      triggers.push({ postId: postId, season: seasonNum });
    }
    return triggers.sort(function (a, b) {
      return a.season - b.season;
    });
  }

  // ========== Core API: load ==========
  async function load(url, cb) {
    try {
      var pageUrl = fixUrl(url, BASE_URL);
      var res = await httpGet(pageUrl, { Referer: BASE_URL + "/" });
      var html = res.body;
      if (!html) {
        return cb({
          success: false,
          errorCode: "LOAD_ERROR",
          message: "Empty response from " + pageUrl,
        });
      }

      var isMovie = /\/movies?\//i.test(pageUrl);
      // Isolate primary detail block (exclude sidebar & related cards so year/score/genres stay accurate)
      var primaryHtml = stripSidebar(html).replace(
        /<section\b[^>]*class=["'][^"']*related[^"']*["'][\s\S]*?<\/section>/gi,
        "",
      );
      var singleArticle = primaryHtml;

      var title = cleanText(
        (singleArticle.match(
          /<h1\b[^>]*class=["'][^"']*entry-title[^"']*["'][^>]*>([\s\S]*?)<\/h1>/i,
        ) || [])[1] ||
          (singleArticle.match(/<h1\b[^>]*>([\s\S]*?)<\/h1>/i) || [])[1] ||
          parseMetaTag(html, "og:title"),
      )
        .replace(/\s*[-|–]\s*Anime\s*Joker.*$/i, "")
        .trim();

      var poster =
        extractImgSrc(
          (singleArticle.match(
            /<div\b[^>]*class=["'][^"']*post-thumbnail[^"']*["'][^>]*>[\s\S]*?<\/div>/i,
          ) || [])[0] || "",
        ) || fixUrl(parseMetaTag(html, "og:image"), BASE_URL);

      var bannerMatch =
        html.match(
          /<div\b[^>]*class=["'][^"']*bghd[^"']*["'][^>]*>[\s\S]*?<img\b[^>]+(?:data-src|src)=["']([^"']+)["']/i,
        ) ||
        html.match(
          /<figure\b[^>]*class=["'][^"']*bgft[^"']*["'][^>]*>[\s\S]*?<img\b[^>]+(?:data-src|src)=["']([^"']+)["']/i,
        );
      var banner = bannerMatch ? fixUrl(bannerMatch[1], BASE_URL) : poster;

      var descMatch =
        singleArticle.match(
          /<div\b[^>]*class=["'][^"']*description[^"']*["'][^>]*>([\s\S]*?)<\/div>/i,
        ) ||
        singleArticle.match(
          /<div\b[^>]*class=["'][^"']*overview[^"']*["'][^>]*>([\s\S]*?)<\/div>/i,
        );
      var description = cleanText(
        descMatch
          ? descMatch[1]
          : parseMetaTag(html, "og:description") ||
              parseMetaTag(html, "description"),
      );

      var yearMatch =
        singleArticle.match(
          /<span\b[^>]*class=["'][^"']*year[^"']*["'][^>]*>(\d{4})<\/span>/i,
        ) || singleArticle.match(/release-year\/(\d{4})/i);
      var year = yearMatch ? parseInt(yearMatch[1], 10) : undefined;

      var scoreMatch =
        singleArticle.match(
          /<span\b[^>]*class=["'][^"']*num[^"']*["'][^>]*>([\d.]+)<\/span>\s*TMDB/i,
        ) ||
        singleArticle.match(/([\d.]+)\s*TMDB/i) ||
        singleArticle.match(/TMDB\s*([\d.]+)/i);
      var score = scoreMatch ? parseFloat(scoreMatch[1]) : undefined;

      var durMatch =
        singleArticle.match(/(\d+)\s*h\s*(\d+)\s*m/i) ||
        singleArticle.match(/(\d+)\s*min/i);
      var duration;
      if (durMatch) {
        duration = durMatch[2]
          ? parseInt(durMatch[1], 10) * 60 + parseInt(durMatch[2], 10)
          : parseInt(durMatch[1], 10);
      }

      var genres = [];
      singleArticle.replace(
        /<a\b[^>]*href=["'][^"']*\/(?:genre|category)\/[^"']+["'][^>]*>([\s\S]*?)<\/a>/gi,
        function (_, g) {
          var gt = cleanText(g);
          if (gt && !/^(?:movies|series|anime|cartoon|home)$/i.test(gt))
            genres.push(gt);
          return "";
        },
      );
      genres = uniqueBy(genres, function (g) {
        return g.toLowerCase();
      });

      var cast = [];
      singleArticle.replace(
        /<a\b[^>]*href=["'][^"']*\/cast_tv\/[^"']+["'][^>]*>([\s\S]*?)<\/a>/gi,
        function (_, actorName) {
          var name = cleanText(actorName);
          if (name) cast.push(new Actor({ name: name }));
          return "";
        },
      );

      var trailers = [];
      var ytMatch = html.match(
        /https?:\/\/(?:www\.)?(?:youtube\.com\/(?:watch\?v=|embed\/)|youtu\.be\/)([a-zA-Z0-9_-]{11})/i,
      );
      if (ytMatch) {
        trailers.push(
          new Trailer({ url: "https://www.youtube.com/watch?v=" + ytMatch[1] }),
        );
      }

      var recMatch = html.match(
        /<section\b[^>]*class=["'][^"']*related[^"']*["'][^>]*>([\s\S]*?)<\/section>/i,
      );
      var recommendations = recMatch
        ? parseArticleCards(recMatch[1]).filter(function (r) {
            return r.url !== pageUrl;
          })
        : [];

      var episodes = [];
      if (isMovie) {
        episodes.push(
          new Episode({
            name: "Full Movie",
            url: pageUrl,
            season: 1,
            episode: 1,
            posterUrl: poster || undefined,
          }),
        );
      } else {
        var initialEpsBlock =
          (html.match(
            /<ul\b[^>]*id=["']episode_by_temp["'][^>]*>([\s\S]*?)<\/ul>/i,
          ) || [])[1] || "";
        var initialEps = parseEpisodesFromHtml(
          initialEpsBlock || stripSidebar(html),
          1,
          poster,
        );

        var seasonTriggers = parseSeasonTriggers(html);
        if (seasonTriggers.length > 0) {
          var ajaxUrl = BASE_URL + "/wp-admin/admin-ajax.php";
          var seasonResults = await Promise.all(
            seasonTriggers.map(function (st) {
              var body =
                "action=action_select_season&season=" +
                encodeURIComponent(String(st.season)) +
                "&post=" +
                encodeURIComponent(String(st.postId));
              return httpPost(ajaxUrl, body, {
                "Content-Type":
                  "application/x-www-form-urlencoded; charset=UTF-8",
                Referer: pageUrl,
                Origin: BASE_URL,
              })
                .then(function (r) {
                  return parseEpisodesFromHtml(r.body, st.season, poster);
                })
                .catch(function () {
                  return [];
                });
            }),
          );
          for (var s = 0; s < seasonResults.length; s++) {
            episodes = episodes.concat(seasonResults[s]);
          }
        }

        if (initialEps.length) {
          episodes = uniqueBy(episodes.concat(initialEps), function (ep) {
            return ep.url;
          });
        }

        episodes.sort(function (a, b) {
          if (Number(a.season || 1) !== Number(b.season || 1)) {
            return Number(a.season || 1) - Number(b.season || 1);
          }
          return Number(a.episode || 0) - Number(b.episode || 0);
        });
      }

      var item = new MultimediaItem({
        title: title || "Unknown",
        url: pageUrl,
        posterUrl: poster || "",
        bannerUrl: banner || undefined,
        type: isMovie ? "movie" : "anime",
        description: description || "",
        year: year,
        score: score,
        duration: duration,
        genres: genres.length ? genres : undefined,
        cast: cast.length ? cast : undefined,
        trailers: trailers.length ? trailers : undefined,
        recommendations: recommendations.length ? recommendations : undefined,
        episodes: episodes,
      });

      cb({ success: true, data: item });
    } catch (err) {
      cb({
        success: false,
        errorCode: "LOAD_ERROR",
        message: String((err && err.message) || err),
      });
    }
  }

  // ========== Stream Extraction Helpers ==========
  function isDirectMediaUrl(url) {
    var u = String(url || "").toLowerCase();
    if (!/^https?:\/\//.test(u)) return false;
    if (
      /\.(?:png|jpg|jpeg|gif|webp|svg|ico|css|js|woff2?|ttf|vtt|srt|ass)(?:$|[?#])/i.test(
        u,
      )
    )
      return false;
    return (
      /\.(?:m3u8|mp4|mkv|webm|mpd|ts)(?:$|[?#])/i.test(u) ||
      /\/master\.txt(?:$|[?#])/i.test(u) ||
      /\/playlist\.m3u8/i.test(u) ||
      /\/api\/file\/[a-z0-9]+\?download/i.test(u) ||
      /video-downloads\.googleusercontent\.com/i.test(u)
    );
  }

  function isNoiseUrl(url) {
    var u = String(url || "").toLowerCase();
    return (
      !u ||
      /google-analytics|googletagmanager|doubleclick|googlesyndication|facebook\.com|twitter\.com|t\.me\/|whatsapp|disqus|gravatar|wp-content\/themes|wp-includes|youtube\.com|youtu\.be|vimeo\.com|cloudflareinsights|histats/i.test(
        u,
      )
    );
  }

  function makeStream(url, source, headers, quality, subtitles) {
    url = decodeHtml(trim(url)).replace(/\\\//g, "/");
    if (!url || !/^https?:\/\//i.test(url)) return null;
    var q = Number(quality || 0) || parseQuality(source + " " + url);
    var isHls = /\.m3u8(?:$|[?#])|\/master\.txt(?:$|[?#])/i.test(url);
    var isDash = /\.mpd(?:$|[?#])/i.test(url);
    var obj = {
      url: url,
      source: trim(source || "AnimeJoker"),
      quality: q > 0 ? q : isHls ? "Auto" : undefined,
      headers: headers || { "User-Agent": USER_AGENT },
    };
    if (isHls) obj.type = "hls";
    else if (isDash) obj.type = "dash";
    if (subtitles && subtitles.length) obj.subtitles = subtitles;
    return new StreamResult(obj);
  }

  function extractSubtitlesFromText(text, baseUrl) {
    var subs = [];
    var re =
      /\{[^{}]*(?:file|src)\s*:\s*["']([^"']+\.(?:vtt|srt))["'][^{}]*\}/gi;
    var m;
    while ((m = re.exec(String(text || ""))) !== null) {
      var block = m[0];
      var subUrl = fixUrl(m[1].replace(/\\\//g, "/"), baseUrl);
      if (!subUrl || /thumb|sprite/i.test(block + " " + subUrl)) continue;
      var labelMatch = block.match(
        /(?:label|lang|language)\s*:\s*["']([^"']+)["']/i,
      );
      subs.push({
        url: subUrl,
        label: labelMatch ? cleanText(labelMatch[1]) : "English",
        lang: labelMatch ? cleanText(labelMatch[1]) : "en",
      });
    }
    return uniqueBy(subs, function (s) {
      return s.url;
    });
  }

  function extractDirectLinksFromText(text, baseUrl, sourceName, refererUrl) {
    var streams = [];
    var content = String(text || "");
    var origin = originOf(refererUrl || baseUrl) || BASE_URL;
    var headers = {
      "User-Agent": USER_AGENT,
      Referer: refererUrl || origin + "/",
      Origin: origin,
    };
    var subtitles = extractSubtitlesFromText(content, baseUrl);

    var patterns = [
      /(?:file|src|hls2|hls3|hls4|videoSource|securedLink|streamUrl|playUrl)\s*[:=]\s*["'](https?:\/\/[^"'\s\\]+|(?:\/|\\\/)[^"'\s]+\.(?:m3u8|mp4|mkv|mpd|txt)[^"'\s]*)["']/gi,
      /<source\b[^>]+src=["']([^"']+)["']/gi,
      /(https?:\/\/[^\s"'<>\\]+\.(?:m3u8|mp4|mkv|webm|mpd)(?:\?[^\s"'<>\\]*)?)/gi,
    ];

    for (var p = 0; p < patterns.length; p++) {
      var re = patterns[p];
      var m;
      while ((m = re.exec(content)) !== null) {
        var raw = String(m[1] || "")
          .replace(/\\\//g, "/")
          .replace(/\\u0026/g, "&");
        var full = fixUrl(raw, baseUrl);
        if (!full || isNoiseUrl(full) || !isDirectMediaUrl(full)) continue;
        var st = makeStream(
          full,
          sourceName,
          headers,
          parseQuality(full),
          subtitles,
        );
        if (st) streams.push(st);
      }
    }
    return uniqueBy(streams, function (s) {
      return s.url;
    });
  }

  // Resolver for hgcloud.to / hglink.to / dhcplay.com redirector -> hanerix / audinifer / vibuxer
  async function tryHgCloudMirrors(embedUrl, sourceName, depth) {
    var host = hostOf(embedUrl);
    if (HGCLOUD_RULES.indexOf(host) === -1) return [];
    var pathPart = embedUrl.replace(/^https?:\/\/[^\/]+/i, "");
    for (var i = 0; i < HGCLOUD_MIRRORS.length; i++) {
      var mirrorUrl = "https://" + HGCLOUD_MIRRORS[i] + pathPart;
      try {
        var res = await httpGet(mirrorUrl, { Referer: embedUrl });
        if (!res || res.status >= 400 || !res.body) continue;
        var unpacked = unpackAllScripts(res.body);
        var combined = res.body + "\n" + unpacked;
        var streams = extractDirectLinksFromText(
          combined,
          res.url || mirrorUrl,
          sourceName + " [HGCloud]",
          res.url || mirrorUrl,
        );
        if (streams.length) return streams;
      } catch (_) {}
    }
    return [];
  }

  // Resolver for embedseek.online/#<id> -> /api/public/resolve?file1=<id>
  async function tryEmbedSeek(embedUrl, sourceName, depth) {
    if (embedUrl.indexOf("embedseek") === -1 && embedUrl.indexOf("#") === -1)
      return [];
    var hashIdx = embedUrl.indexOf("#");
    if (hashIdx === -1) return [];
    var fileId = trim(embedUrl.slice(hashIdx + 1));
    if (!fileId) return [];
    var orig = originOf(embedUrl);
    if (!orig) return [];
    try {
      var apiUrl =
        orig + "/api/public/resolve?file1=" + encodeURIComponent(fileId);
      var res = await httpGet(apiUrl, {
        Referer: embedUrl,
        Accept: "application/json, */*",
      });
      var json = parseJsonSafe(res.body);
      if (json && json.url) {
        return resolveEmbedUrl(
          json.url,
          sourceName + " [EmbedSeek]",
          embedUrl,
          depth + 1,
        );
      }
    } catch (_) {}
    return [];
  }

  // Resolver for AS-CDN / ZephyrFlick / AWStream / Short.icu (FirePlayer / getVideo POST API)
  async function tryFirePlayerApi(embedUrl, sourceName, html) {
    var origin = originOf(embedUrl);
    if (!origin) return [];
    var hashMatch =
      embedUrl.match(/\/video\/([a-f0-9]{16,64})/i) ||
      embedUrl.match(/[?&]data=([a-f0-9]{16,64})/i) ||
      String(html || "").match(/FirePlayer\(\s*["']([a-f0-9]{16,64})["']/i);
    if (!hashMatch) return [];
    var hash = hashMatch[1];

    try {
      var apiUrl =
        origin +
        "/player/index.php?data=" +
        encodeURIComponent(hash) +
        "&do=getVideo";
      var res = await httpPost(
        apiUrl,
        "hash=" +
          encodeURIComponent(hash) +
          "&r=" +
          encodeURIComponent(BASE_URL + "/"),
        {
          "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
          Referer: embedUrl,
          Origin: origin,
          "X-Requested-With": "XMLHttpRequest",
        },
      );
      var json = parseJsonSafe(res.body);
      if (!json) return [];
      var mediaUrl = json.securedLink || json.videoSource || json.file || "";
      if (!mediaUrl) return [];
      var headers = {
        "User-Agent": USER_AGENT,
        Referer: origin + "/",
        Origin: origin,
      };
      var st = makeStream(
        mediaUrl,
        sourceName,
        headers,
        parseQuality(mediaUrl),
      );
      return st ? [st] : [];
    } catch (_) {
      return [];
    }
  }

  async function tryBuiltinExtractor(embedUrl, sourceName) {
    if (!embedUrl || typeof globalThis.loadExtractor !== "function") return [];
    try {
      var collected = [];
      var maybeArr = await globalThis.loadExtractor(
        embedUrl,
        function (stream) {
          if (stream && stream.url) {
            if (!stream.source) stream.source = sourceName;
            collected.push(stream);
          }
        },
      );
      if (Array.isArray(maybeArr)) {
        maybeArr.forEach(function (s) {
          if (s && s.url) {
            if (!s.source) s.source = sourceName;
            collected.push(s);
          }
        });
      }
      return uniqueBy(collected, function (s) {
        return s.url;
      });
    } catch (_) {
      return [];
    }
  }

  async function resolveEmbedUrl(embedUrl, sourceName, referer, depth) {
    depth = Number(depth || 0);
    if (depth > 3) return [];
    embedUrl = fixUrl(embedUrl, referer || BASE_URL);
    if (!embedUrl || isNoiseUrl(embedUrl)) return [];

    // 1. Already a direct streamable/downloadable media URL
    if (isDirectMediaUrl(embedUrl)) {
      var direct = makeStream(embedUrl, sourceName, {
        "User-Agent": USER_AGENT,
        Referer: referer || BASE_URL + "/",
      });
      return direct ? [direct] : [];
    }

    // 2. Pixeldrain direct file URL
    if (/pixeldrain\.[a-z]+\/(?:u|api\/file)\/([a-zA-Z0-9]+)/i.test(embedUrl)) {
      var pxlId = embedUrl.match(
        /pixeldrain\.[a-z]+\/(?:u|api\/file)\/([a-zA-Z0-9]+)/i,
      )[1];
      var pxlOrigin = originOf(embedUrl) || "https://pixeldrain.com";
      var pxlStream = makeStream(
        pxlOrigin + "/api/file/" + pxlId + "?download",
        sourceName + " [Pixeldrain]",
        {
          "User-Agent": USER_AGENT,
        },
      );
      return pxlStream ? [pxlStream] : [];
    }

    // 3. HGCloud / HGLink / DHCPlay redirector mirrors (hanerix / audinifer / vibuxer)
    if (HGCLOUD_RULES.indexOf(hostOf(embedUrl)) !== -1) {
      var hgStreams = await tryHgCloudMirrors(embedUrl, sourceName, depth);
      if (hgStreams.length) return hgStreams;
    }

    // 4. EmbedSeek (#id -> /api/public/resolve?file1=id)
    if (embedUrl.indexOf("embedseek") !== -1) {
      var esStreams = await tryEmbedSeek(embedUrl, sourceName, depth);
      if (esStreams.length) return esStreams;
    }

    // 5. Try SkyStream's built-in extractor registry
    var builtinStreams = await tryBuiltinExtractor(embedUrl, sourceName);
    if (builtinStreams.length) return builtinStreams;

    // 6. Fetch the embed page HTML
    var res;
    try {
      res = await httpGet(embedUrl, { Referer: referer || BASE_URL + "/" });
    } catch (_) {
      return [];
    }
    var html = res.body || "";
    var finalUrl = res.url || embedUrl;
    if (!html) return [];

    // 7. Unwrap ToroFilm ?trembed= / same-origin wrapper iframes
    var nestedIframes = [];
    html.replace(/<iframe\b([^>]+)>/gi, function (_, attrsStr) {
      var attrs = parseAttrs(attrsStr);
      var src = fixUrl(
        attrs["data-src"] || attrs["data-lazy-src"] || attrs["src"] || "",
        finalUrl,
      );
      if (src && src !== embedUrl && src !== finalUrl && !isNoiseUrl(src)) {
        nestedIframes.push(src);
      }
      return "";
    });
    nestedIframes = uniqueBy(nestedIframes, function (u) {
      return u;
    });

    var checkedNested = false;
    if (
      nestedIframes.length &&
      (finalUrl.indexOf("trembed=") !== -1 ||
        hostOf(finalUrl) === hostOf(BASE_URL))
    ) {
      checkedNested = true;
      var nestedBatches = await Promise.all(
        nestedIframes.map(function (inner) {
          return resolveEmbedUrl(inner, sourceName, finalUrl, depth + 1);
        }),
      );
      var nestedStreams = uniqueBy(
        [].concat.apply([], nestedBatches),
        function (s) {
          return s && s.url;
        },
      );
      if (nestedStreams.length) return nestedStreams;
    }

    // 8. Try FirePlayer / AS-CDN / ZephyrFlick POST getVideo API
    var fireStreams = await tryFirePlayerApi(finalUrl, sourceName, html);
    if (fireStreams.length) return fireStreams;

    // 9. Unpack P.A.C.K.E.R. JS blocks + scan raw HTML for direct .m3u8 / .mp4 links
    var unpacked = unpackAllScripts(html);
    var combined = html + "\n" + unpacked;

    combined.replace(
      /atob\(\s*["']([A-Za-z0-9+/=_-]{16,})["']\s*\)/gi,
      function (_, b64) {
        var dec = base64Decode(b64);
        if (/https?:\/\//i.test(dec)) combined += "\n" + dec;
        return "";
      },
    );

    var extracted = extractDirectLinksFromText(
      combined,
      finalUrl,
      sourceName,
      finalUrl,
    );
    if (extracted.length) return extracted;

    // 10. Fallback: follow nested iframes only if not already checked above
    if (nestedIframes.length && !checkedNested) {
      var fallbackBatches = await Promise.all(
        nestedIframes.map(function (inner) {
          return resolveEmbedUrl(inner, sourceName, finalUrl, depth + 1);
        }),
      );
      return uniqueBy([].concat.apply([], fallbackBatches), function (s) {
        return s && s.url;
      });
    }

    return [];
  }

  function parseWatchPageEmbeds(html, pageUrl) {
    var embeds = [];
    var labelsByOptionId = {};

    html.replace(
      /<a\b([^>]*href=["']#(options-\d+)["'][^>]*)>([\s\S]*?)<\/a>/gi,
      function (_, attrsStr, optId, inner) {
        var label = cleanText(inner).replace(/\s+/g, " ").trim();
        if (label) labelsByOptionId[optId] = label;
        return "";
      },
    );

    html.replace(
      /<div\b[^>]*id=["'](options-\d+)["'][^>]*>([\s\S]*?)<\/div>/gi,
      function (_, optId, body) {
        var iframeMatch = body.match(/<iframe\b([^>]+)>/i);
        if (!iframeMatch) return "";
        var attrs = parseAttrs(iframeMatch[1]);
        var src = fixUrl(
          attrs["data-src"] || attrs["data-lazy-src"] || attrs["src"] || "",
          pageUrl,
        );
        if (src && !isNoiseUrl(src)) {
          embeds.push({
            url: src,
            label: labelsByOptionId[optId] || "Server " + (embeds.length + 1),
          });
        }
        return "";
      },
    );

    if (!embeds.length) {
      html.replace(/<iframe\b([^>]+)>/gi, function (_, attrsStr) {
        var attrs = parseAttrs(attrsStr);
        var src = fixUrl(
          attrs["data-src"] || attrs["data-lazy-src"] || attrs["src"] || "",
          pageUrl,
        );
        if (src && !isNoiseUrl(src)) {
          embeds.push({
            url: src,
            label: "Server " + (embeds.length + 1),
          });
        }
        return "";
      });
    }

    return uniqueBy(embeds, function (e) {
      return e.url;
    });
  }

  // ========== Core API: loadStreams ==========
  async function loadStreams(url, cb) {
    try {
      var watchUrl = fixUrl(url, BASE_URL);
      var res = await httpGet(watchUrl, { Referer: BASE_URL + "/" });
      var html = res.body || "";
      if (!html) {
        return cb({
          success: false,
          errorCode: "STREAM_ERROR",
          message: "Empty watch page response",
        });
      }

      var embeds = parseWatchPageEmbeds(html, watchUrl);
      if (!embeds.length) {
        var directOnPage = extractDirectLinksFromText(
          html,
          watchUrl,
          "AnimeJoker Direct",
          watchUrl,
        );
        if (directOnPage.length) {
          return cb({ success: true, data: directOnPage });
        }
        return cb({
          success: false,
          errorCode: "STREAM_ERROR",
          message: "No player embeds found on " + watchUrl,
        });
      }

      var batches = await Promise.all(
        embeds.map(function (emb) {
          return resolveEmbedUrl(emb.url, emb.label, watchUrl, 0).catch(
            function () {
              return [];
            },
          );
        }),
      );

      var streams = uniqueBy(
        [].concat.apply([], batches).filter(Boolean),
        function (s) {
          return s && s.url;
        },
      );

      streams.sort(function (a, b) {
        var qa =
          typeof a.quality === "number"
            ? a.quality
            : a.quality === "Auto"
              ? 1000
              : 0;
        var qb =
          typeof b.quality === "number"
            ? b.quality
            : b.quality === "Auto"
              ? 1000
              : 0;
        return qb - qa;
      });

      if (!streams.length) {
        return cb({
          success: false,
          errorCode: "STREAM_ERROR",
          message:
            "Could not resolve any direct streamable links from " +
            embeds.length +
            " embed(s)",
        });
      }

      cb({ success: true, data: streams });
    } catch (err) {
      cb({
        success: false,
        errorCode: "STREAM_ERROR",
        message: String((err && err.message) || err),
      });
    }
  }

  // Export to SkyStream global scope
  globalThis.getHome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
