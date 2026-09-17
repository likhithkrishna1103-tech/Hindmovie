(function () {
  /**
   * @typedef {Object} Response
   * @property {boolean} success
   * @property {any} [data]
   * @property {string} [errorCode]
   * @property {string} [message]
   */

  /**
   * @type {import('@skystream/sdk').Manifest}
   */
  var BASE_URL =
    typeof manifest !== "undefined" && manifest && manifest.baseUrl
      ? manifest.baseUrl
      : "https://reanime.to";
  var API_URL = BASE_URL + "/api/v1";

  var USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

  var HEADERS = {
    "User-Agent": USER_AGENT,
    Referer: BASE_URL + "/",
    Origin: BASE_URL,
  };

  // ========== Utility Helpers ==========

  function cleanHtml(str) {
    if (!str) return "";
    return String(str)
      .replace(/<[^>]+>/g, " ")
      .replace(/&quot;/g, '"')
      .replace(/&amp;/g, "&")
      .replace(/&#39;/g, "'")
      .replace(/&lt;/g, "<")
      .replace(/&gt;/g, ">")
      .replace(/\s+/g, " ")
      .trim();
  }

  function parseJsonSafe(val, fallback) {
    if (val && typeof val === "object") return val;
    try {
      return JSON.parse(String(val || ""));
    } catch (_) {
      return fallback !== undefined ? fallback : null;
    }
  }

  function base64Encode(str) {
    if (!str) return "";
    try {
      if (typeof btoa === "function") return btoa(unescape(encodeURIComponent(String(str))));
    } catch (_) {}
    try {
      if (typeof Buffer !== "undefined") return Buffer.from(String(str), "utf8").toString("base64");
    } catch (_) {}
    return String(str);
  }

  function proxifyUrl(url, headers, referer, mirrorHosts) {
    var payload = {
      url: url,
      headers: headers || {},
      options: {
        referer: referer || "",
        mirrorHosts: mirrorHosts || [],
      },
    };
    return "MAGIC_PROXY_v2" + base64Encode(JSON.stringify(payload));
  }

  function extractFlixKeyUrl(variantUrl) {
    try {
      var u = new URL(variantUrl);
      var targetUrl = u.searchParams.get("url") || variantUrl;
      var lastSlash = targetUrl.lastIndexOf("/");
      if (lastSlash !== -1) {
        return targetUrl.slice(0, lastSlash + 1) + "key.bin";
      }
    } catch (_) {}
    return "";
  }

  function buildMagicM3u8(m3u8Body, keyUrl, referer, userAgent) {
    var lines = String(m3u8Body || "").split(/\r?\n/);
    var rewritten = [];
    var proxiedKey = keyUrl ? proxifyUrl(keyUrl, { "User-Agent": userAgent }, referer, ["flixcloud.cc"]) : "";

    for (var i = 0; i < lines.length; i++) {
      var line = lines[i];
      var trimmed = line.trim();
      if (!trimmed) {
        rewritten.push(line);
        continue;
      }
      if (trimmed.charAt(0) === "#") {
        if (/^#EXT-X-KEY:/i.test(trimmed) && /URI="key\.bin"/i.test(trimmed)) {
          if (proxiedKey) {
            rewritten.push(line.replace(/URI="key\.bin"/i, 'URI="' + proxiedKey + '"'));
          } else {
            rewritten.push(line);
          }
        } else {
          rewritten.push(line);
        }
        continue;
      }
      // Segment line
      if (trimmed.indexOf("http") !== 0) {
        rewritten.push(line);
        continue;
      }
      var proxiedSeg = proxifyUrl(trimmed, { "User-Agent": userAgent }, referer, ["rundowncdn.top", "atomic4cdn.top"]);
      rewritten.push(proxiedSeg);
    }
    return "magic_m3u8:" + base64Encode(rewritten.join("\n"));
  }

  async function safeGet(url, headers) {
    try {
      var res = await http_get(url, headers || HEADERS);
      return res;
    } catch (_) {
      return null;
    }
  }

  async function safePost(url, headers, body) {
    try {
      var res = await http_post(url, headers, body);
      if (res) return res;
    } catch (_) {}
    try {
      return await http_post(url, body, headers);
    } catch (_) {}
    return null;
  }

  function getResponseBody(res) {
    if (!res) return "";
    if (typeof res === "string") return res;
    return res.body || res.text || "";
  }

  function preferredTitle(titleObj) {
    if (!titleObj) return "Unknown";
    if (typeof titleObj === "string") return titleObj;
    return (
      titleObj.english ||
      titleObj.romaji ||
      titleObj.user_preferred ||
      titleObj.userPreferred ||
      titleObj.native ||
      "Unknown"
    );
  }

  function getTvType(format) {
    var f = String(format || "").toUpperCase();
    if (f === "MOVIE") return "movie";
    if (f === "TV" || f === "TV_SHORT") return "series";
    if (f === "OVA" || f === "ONA" || f === "SPECIAL") return "anime";
    return "anime";
  }

  function getShowStatus(status) {
    var s = String(status || "").toLowerCase();
    if (s === "finished" || s === "completed") return "completed";
    if (s === "releasing" || s === "ongoing") return "ongoing";
    return "ongoing";
  }

  function getPoster(item) {
    var c = item.cover_image || item.coverImage;
    if (c) {
      if (c.extra_large || c.extraLarge) return c.extra_large || c.extraLarge;
      if (c.large) return c.large;
      if (c.medium) return c.medium;
    }
    if (Array.isArray(item.artworks)) {
      var p = item.artworks.find(function (a) {
        return String(a.imageType || a.image_type || "").toLowerCase() === "poster";
      });
      if (p && p.url) return p.url;
    }
    return "";
  }

  function getBanner(item) {
    if (item.banner_image || item.bannerImage) {
      return item.banner_image || item.bannerImage;
    }
    if (Array.isArray(item.artworks)) {
      var b = item.artworks.find(function (a) {
        return String(a.imageType || a.image_type || "").toLowerCase() === "banner";
      });
      if (b && b.url) return b.url;
    }
    return getPoster(item);
  }

  function getLogo(item) {
    if (item.clearart || item.clear_art) {
      return item.clearart || item.clear_art;
    }
    if (Array.isArray(item.artworks)) {
      var l = item.artworks.find(function (a) {
        var t = String(a.imageType || a.image_type || "").toLowerCase();
        return t === "clearart" || t === "clearlogo" || t === "logo";
      });
      if (l && l.url) return l.url;
    }
    return "";
  }

  function getQualityFromName(quality) {
    if (!quality) return 0;
    var q = String(quality).toLowerCase().replace(/-/g, " ");
    var numMatch = q.match(/(\d+)/);
    if (numMatch) {
      var n = parseInt(numMatch[1], 10);
      if (n >= 2160) return 2160;
      if (n >= 1080) return 1080;
      if (n >= 720) return 720;
      if (n >= 480) return 480;
      if (n >= 360) return 360;
    }
    if (q.indexOf("4k") !== -1 || q.indexOf("2160") !== -1) return 2160;
    if (q.indexOf("fhd") !== -1 || q.indexOf("full hd") !== -1) return 1080;
    if (q.indexOf("hd") !== -1) return 720;
    if (q.indexOf("sd") !== -1) return 480;
    if (q.indexOf("m3u8") !== -1 || q.indexOf("auto") !== -1) return 1080;
    return 0;
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
        var resMatch = line.match(/RESOLUTION=(\d+)x(\d+)/i);
        var bwMatch = line.match(/[^-]BANDWIDTH=(\d+)\b/i);
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
        else label = currentInf.height ? currentInf.height + "p" : "HD";

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

  function mapMediaItem(item) {
    if (!item) return null;
    var animeId = item.anime_id || item.animeId;
    if (!animeId) return null;

    var title = preferredTitle(item.title);
    var poster = getPoster(item);
    var banner = getBanner(item);
    var logo = getLogo(item);
    var desc = cleanHtml(item.description);
    var score = item.average_score ? Number((item.average_score / 10).toFixed(1)) : undefined;
    var year = item.season_year ? parseInt(item.season_year, 10) : undefined;
    var status = getShowStatus(item.status);
    var type = getTvType(item.format);

    var media = new MultimediaItem({
      title: title,
      url: BASE_URL + "/anime/" + animeId,
      posterUrl: poster,
      bannerUrl: banner,
      type: type,
      description: desc,
      status: status,
      score: score,
      year: year,
      headers: { Referer: BASE_URL + "/" },
    });
    if (logo) {
      media.logoUrl = logo;
    }
    return media;
  }

  // ========== Core Plugin Methods ==========

  /**
   * Loads the home screen categories.
   * @param {(res: Response) => void} cb
   */
  async function getHome(cb) {
    try {
      var homeRes = await safeGet(API_URL + "/home", HEADERS);
      var homeData = parseJsonSafe(getResponseBody(homeRes), {});

      var trendingItems = (homeData.trending || []).map(mapMediaItem).filter(Boolean);
      var latestItems = (homeData.latest_aired || []).map(mapMediaItem).filter(Boolean);
      var newItems = (homeData.new_on_site || []).map(mapMediaItem).filter(Boolean);

      var searchCategories = [
        { name: "Currently Airing", query: "status=Releasing&sort=popularity_desc&limit=36&offset=0" },
        { name: "Most Popular", query: "sort=popularity_desc&limit=36&offset=0" },
        { name: "Top Rated", query: "sort=score_desc&limit=36&offset=0" },
        { name: "Anime Movies", query: "format=Movie&sort=popularity_desc&limit=36&offset=0" },
        { name: "Completed Series", query: "status=Finished&sort=popularity_desc&limit=36&offset=0" },
      ];

      var searchPromises = searchCategories.map(async function (cat) {
        var res = await safeGet(API_URL + "/search?" + cat.query, HEADERS);
        var json = parseJsonSafe(getResponseBody(res), {});
        var list = (json.results || []).map(mapMediaItem).filter(Boolean);
        return { name: cat.name, list: list };
      });

      var categoryResults = await Promise.all(searchPromises);

      var data = {};
      // "Trending" is promoted to the Hero Carousel
      data["Trending"] = trendingItems;
      if (latestItems.length > 0) data["Latest Episodes"] = latestItems;
      if (newItems.length > 0) data["New On Site"] = newItems;

      categoryResults.forEach(function (cat) {
        if (cat.list.length > 0) {
          data[cat.name] = cat.list;
        }
      });

      cb({ success: true, data: data });
    } catch (e) {
      cb({ success: false, errorCode: "GET_HOME_ERROR", message: e.stack || e.message });
    }
  }

  /**
   * Searches for media items.
   * @param {string} query
   * @param {(res: Response) => void} cb
   */
  async function search(query, cb) {
    try {
      var searchUrl = API_URL + "/search?q=" + encodeURIComponent(query || "");
      var res = await safeGet(searchUrl, HEADERS);
      var data = parseJsonSafe(getResponseBody(res), {});
      var items = (data.results || []).map(mapMediaItem).filter(Boolean);

      cb({ success: true, data: items });
    } catch (e) {
      cb({ success: false, errorCode: "SEARCH_ERROR", message: e.stack || e.message });
    }
  }

  /**
   * Loads details for a specific media item.
   * @param {string} url
   * @param {(res: Response) => void} cb
   */
  async function load(url, cb) {
    try {
      var idMatch = url.match(/\/anime\/([^\/?#]+)/i);
      var animeId = idMatch ? idMatch[1] : url.split("/").filter(Boolean).pop();

      if (!animeId) {
        cb({ success: false, errorCode: "INVALID_URL", message: "Could not extract anime ID" });
        return;
      }

      var detailRes = await safeGet(API_URL + "/anime/" + animeId, HEADERS);
      var detail = parseJsonSafe(getResponseBody(detailRes), null);

      if (!detail) {
        cb({ success: false, errorCode: "NOT_FOUND", message: "Failed to fetch anime details" });
        return;
      }

      var title = preferredTitle(detail.title);
      var poster = getPoster(detail);
      var banner = getBanner(detail);
      var logo = getLogo(detail);
      var desc = cleanHtml(detail.description);
      var type = getTvType(detail.format);
      var status = getShowStatus(detail.status);
      var score = detail.average_score ? Number((detail.average_score / 10).toFixed(1)) : undefined;
      var year = detail.season_year ? parseInt(detail.season_year, 10) : undefined;
      var anilistId = detail.anilist_id || detail.anilistId;
      var malId = detail.mal_id || detail.malId;

      var studios = [];
      if (Array.isArray(detail.studios)) {
        studios = detail.studios.map(function (s) { return s.name; }).filter(Boolean);
      }

      // Fetch all episodes paginated
      var allEpData = [];
      var offset = 0;
      var limit = 100;
      var hasMore = true;

      while (hasMore) {
        var epRes = await safeGet(
          API_URL + "/anime/" + animeId + "/episodes?offset=" + offset + "&limit=" + limit,
          HEADERS
        );
        var epJson = parseJsonSafe(getResponseBody(epRes), {});
        var batch = epJson.data || epJson.episodes || epJson.results || (Array.isArray(epJson) ? epJson : []);
        if (batch.length > 0) {
          allEpData = allEpData.concat(batch);
          offset += batch.length;
          if (batch.length < limit || (epJson.total && offset >= epJson.total)) {
            hasMore = false;
          }
        } else {
          hasMore = false;
        }
      }

      // AniZip metadata enrichment (optional)
      var anizipEpisodes = {};
      if (anilistId) {
        try {
          var anizipRes = await safeGet("https://api.ani.zip/mappings?anilist_id=" + anilistId);
          var anizipJson = parseJsonSafe(getResponseBody(anizipRes), {});
          if (anizipJson && anizipJson.episodes) {
            anizipEpisodes = anizipJson.episodes;
          }
        } catch (_) {}
      }

      // Build episodes list for SUB and DUB
      var episodes = [];
      allEpData.forEach(function (ep) {
        var epNum = ep.episode_number || parseInt(ep.episodeId?.replace(/\D/g, ""), 10) || 1;
        var epKey = String(epNum);
        var aniEp = anizipEpisodes[epKey] || null;

        var epName =
          (aniEp && aniEp.title && (aniEp.title.en || aniEp.title["x-jat"] || aniEp.title.ja)) ||
          ep.title ||
          "Episode " + epNum;
        var epDesc = ep.description || (aniEp && (aniEp.overview || aniEp.summary)) || "";
        var epThumb = ep.thumbnail || (aniEp && aniEp.image) || poster;
        var epAired = ep.aired || (aniEp && (aniEp.airDateUtc || aniEp.airdate)) || "";

        var canSub = ep.subbed !== false;
        var canDub = ep.dubbed === true;

        if (canSub) {
          episodes.push(
            new Episode({
              name: epName,
              url:
                BASE_URL +
                "/watch/" +
                animeId +
                "?ep=" +
                epNum +
                "|" +
                animeId +
                "|" +
                (ep.episodeId || "ep-" + epNum) +
                "|" +
                (anilistId || "") +
                "|" +
                epNum +
                "|sub",
              season: 1,
              episode: epNum,
              description: epDesc,
              posterUrl: epThumb,
              releaseDate: epAired,
              dubStatus: "sub",
              headers: { Referer: BASE_URL + "/" },
            })
          );
        }

        if (canDub) {
          episodes.push(
            new Episode({
              name: epName,
              url:
                BASE_URL +
                "/watch/" +
                animeId +
                "?ep=" +
                epNum +
                "|" +
                animeId +
                "|" +
                (ep.episodeId || "ep-" + epNum) +
                "|" +
                (anilistId || "") +
                "|" +
                epNum +
                "|dub",
              season: 1,
              episode: epNum,
              description: epDesc,
              posterUrl: epThumb,
              releaseDate: epAired,
              dubStatus: "dub",
              headers: { Referer: BASE_URL + "/" },
            })
          );
        }
      });

      var mediaItem = new MultimediaItem({
        title: title,
        url: BASE_URL + "/anime/" + animeId,
        posterUrl: poster,
        bannerUrl: banner,
        type: type,
        description: desc,
        status: status,
        score: score,
        year: year,
        genres: detail.genres || [],
        episodes: episodes,
        headers: { Referer: BASE_URL + "/" },
      });

      if (logo) mediaItem.logoUrl = logo;
      if (studios.length > 0) mediaItem.studio = studios.join(", ");
      if (anilistId || malId) {
        mediaItem.syncData = {};
        if (anilistId) mediaItem.syncData.anilist = String(anilistId);
        if (malId) mediaItem.syncData.mal = String(malId);
      }

      cb({ success: true, data: mediaItem });
    } catch (e) {
      cb({ success: false, errorCode: "LOAD_ERROR", message: e.stack || e.message });
    }
  }

  /**
   * FlixCloud Stream Extractor
   * Resolves FlixCloud embeds into direct and proxied M3U8 streams with subtitles
   */
  async function resolveFlixCloudEmbed(embedUrl, serverName, dubType, watchReferer) {
    var streams = [];
    try {
      var embedRes = await safeGet(embedUrl, {
        Referer: BASE_URL + "/",
        "User-Agent": USER_AGENT,
      });
      var html = getResponseBody(embedRes);
      if (!html) return streams;

      var scriptMatch = html.match(/<script[^>]*>([\s\S]*?video_id[\s\S]*?)<\/script>/i);
      var scriptContent = scriptMatch ? scriptMatch[1] : html;

      var dataIdx = scriptContent.search(/data:\s*\{/);
      if (dataIdx === -1) return streams;

      var openBrace = scriptContent.indexOf("{", dataIdx);
      if (openBrace === -1) return streams;

      var depth = 0;
      var closeBrace = -1;
      for (var i = openBrace; i < scriptContent.length; i++) {
        if (scriptContent[i] === "{") depth++;
        else if (scriptContent[i] === "}") {
          depth--;
          if (depth === 0) {
            closeBrace = i;
            break;
          }
        }
      }

      if (closeBrace === -1) return streams;

      var rawObjStr = scriptContent.slice(openBrace, closeBrace + 1);
      var jsonStr = rawObjStr.replace(/([{,]\s*)([A-Za-z0-9_]+)(\s*:)/g, '$1"$2"$3');
      var dataObj = parseJsonSafe(jsonStr, null);
      if (!dataObj) return streams;

      // Extract subtitles before deleting
      var rawSubs = Array.isArray(dataObj.subtitles) ? dataObj.subtitles : [];
      var subtitleTracks = rawSubs
        .filter(function (s) { return s && s.url; })
        .map(function (s) {
          var lang = s.language || s.label || "English";
          return {
            url: s.url,
            label: lang,
            lang: lang.slice(0, 2).toLowerCase(),
          };
        });

      delete dataObj.subtitles;

      // Step 1: POST enc-dec.app for token
      var tokenRes = await safePost(
        "https://enc-dec.app/api/dec-flixcloud?type=token",
        {
          "Content-Type": "application/json",
          "User-Agent": USER_AGENT,
        },
        JSON.stringify({ data: dataObj })
      );
      var tokenJson = parseJsonSafe(getResponseBody(tokenRes), {});
      var tokenResult = tokenJson.result || tokenJson;
      var token = tokenResult.token || tokenJson.token;
      var context = tokenResult.context || tokenJson.context;

      if (!token) return streams;

      // Step 2: GET /api/m3u8/{token}
      var flixOrigin = "https://flixcloud.cc";
      try {
        var parsedOrigin = new URL(embedUrl).origin;
        if (parsedOrigin) flixOrigin = parsedOrigin;
      } catch (_) {}

      var m3u8Res = await safeGet(flixOrigin + "/api/m3u8/" + token, {
        Referer: flixOrigin + "/",
        "User-Agent": USER_AGENT,
      });
      var m3u8Json = parseJsonSafe(getResponseBody(m3u8Res), null);
      if (!m3u8Json) return streams;

      // Step 3: POST enc-dec.app for stream decryption
      var streamRes = await safePost(
        "https://enc-dec.app/api/dec-flixcloud?type=stream",
        {
          "Content-Type": "application/json",
          "User-Agent": USER_AGENT,
        },
        JSON.stringify({
          data: {
            context: context,
            stream_response: m3u8Json,
          },
        })
      );
      var streamJson = parseJsonSafe(getResponseBody(streamRes), {});
      var resData = streamJson.result || streamJson;
      var streamUrl = resData.stream || resData.url;
      var wPayload =
        resData.w_payload ||
        (resData.context && resData.context.w_payload) ||
        (context && context.w_payload);

      if (!streamUrl) return streams;

      var finalManifestUrl = streamUrl;
      if (wPayload) {
        finalManifestUrl =
          "https://enc-dec.app/api/parse-flixcloud?url=" +
          encodeURIComponent(streamUrl) +
          "&w_payload=" +
          encodeURIComponent(wPayload);
      }

      var streamHeaders = {
        Referer: flixOrigin + "/",
        "User-Agent": USER_AGENT,
        Origin: flixOrigin,
      };

      var dubTag = dubType ? " (" + dubType.toUpperCase() + ")" : "";
      var baseLabel = (serverName || "FlixCloud") + dubTag;

      // Try parsing HLS variants
      var playlistRes = await safeGet(finalManifestUrl, streamHeaders);
      var playlistBody = getResponseBody(playlistRes);
      var variants = parseHlsVariants(playlistBody, finalManifestUrl);

      if (variants && variants.length > 0) {
        for (var vIdx = 0; vIdx < variants.length; vIdx++) {
          var v = variants[vIdx];
          var qNum = getQualityFromName(v.label) || 1080;

          // 1. Direct Stream Result
          var directStream = new StreamResult({
            url: v.url,
            source: baseLabel + " [" + v.label + " Direct]",
            quality: qNum,
            type: "hls",
            headers: streamHeaders,
            referer: flixOrigin + "/",
          });
          if (subtitleTracks.length > 0) directStream.subtitles = subtitleTracks;
          streams.push(directStream);

          // 2. Built-in SkyStream MAGIC_PROXY_v2 Stream (Rewritten with resolved key & proxified segments)
          try {
            var keyUrl = extractFlixKeyUrl(v.url);
            var varPlaylistRes = await safeGet(v.url, streamHeaders);
            var varBody = getResponseBody(varPlaylistRes);
            if (varBody && varBody.indexOf("#EXTM3U") !== -1) {
              var magicUrl = buildMagicM3u8(varBody, keyUrl, flixOrigin + "/", USER_AGENT);
              var proxiedStream = new StreamResult({
                url: magicUrl,
                source: baseLabel + " [" + v.label + " Proxy]",
                quality: qNum,
                type: "hls",
                headers: {},
              });
              if (subtitleTracks.length > 0) proxiedStream.subtitles = subtitleTracks;
              streams.push(proxiedStream);
            }
          } catch (_) {}
        }
      }

      // Master Playlist Stream (Auto multi-audio option)
      var masterStream = new StreamResult({
        url: finalManifestUrl,
        source: baseLabel + " [Auto/Multi-Audio]",
        quality: 1080,
        type: "hls",
        headers: streamHeaders,
        referer: flixOrigin + "/",
      });
      if (subtitleTracks.length > 0) masterStream.subtitles = subtitleTracks;
      streams.push(masterStream);
    } catch (_) {}

    return streams;
  }

  /**
   * Loads direct streams for a specific episode.
   * @param {string} url
   * @param {(res: Response) => void} cb
   */
  async function loadStreams(url, cb) {
    try {
      var parts = url.split("|");
      var watchUrl = parts[0] || url;
      var animeId = parts[1] || "";
      var episodeId = parts[2] || "";
      var anilistId = parts[3] || "";
      var epNum = parts[4] || 1;
      var dubType = (parts[5] || "sub").toLowerCase();

      // Extract fallbacks if parameters were omitted
      if (!animeId) {
        var m = watchUrl.match(/\/(?:watch|anime)\/([^\/?#]+)/i);
        if (m) animeId = m[1];
      }
      if (!epNum) {
        var epMatch = watchUrl.match(/ep=(\d+)/i);
        epNum = epMatch ? parseInt(epMatch[1], 10) : 1;
      }
      if (!anilistId && animeId) {
        var aRes = await safeGet(API_URL + "/anime/" + animeId, HEADERS);
        var aJson = parseJsonSafe(getResponseBody(aRes), {});
        anilistId = aJson.anilist_id || aJson.anilistId || "";
      }

      var allStreams = [];

      // Primary Route: /api/flix/{anilistId}/{epNum}
      if (anilistId) {
        var flixApiUrl = BASE_URL + "/api/flix/" + anilistId + "/" + epNum;
        var flixRes = await safeGet(flixApiUrl, {
          Referer: BASE_URL + "/watch/" + animeId + "?ep=" + epNum,
          Origin: BASE_URL,
          "User-Agent": USER_AGENT,
        });
        var flixJson = parseJsonSafe(getResponseBody(flixRes), {});

        if (flixJson && Array.isArray(flixJson.servers)) {
          var matchingServers = flixJson.servers.filter(function (s) {
            return String(s.dataType || "").toLowerCase() === dubType;
          });
          if (matchingServers.length === 0) {
            matchingServers = flixJson.servers;
          }

          var resolveTasks = matchingServers.map(function (server) {
            var dataLink = server.dataLink || server.link || "";
            var sName = server.serverName || server.name || "Server";
            var sType = server.dataType || dubType;
            if (!dataLink) return Promise.resolve([]);
            return resolveFlixCloudEmbed(
              dataLink,
              sName,
              sType,
              BASE_URL + "/watch/" + animeId + "?ep=" + epNum
            );
          });

          var resolvedArrays = await Promise.all(resolveTasks);
          resolvedArrays.forEach(function (list) {
            allStreams = allStreams.concat(list);
          });
        }
      }

      // Secondary Fallback Route: /api/v1/anime/{animeId}/episode/{episodeId}/sources
      if (allStreams.length === 0 && animeId && episodeId) {
        try {
          var srcUrl = API_URL + "/anime/" + animeId + "/episode/" + episodeId + "/sources";
          var srcRes = await safeGet(srcUrl, {
            Referer: BASE_URL + "/watch/" + animeId + "?ep=" + epNum,
            "User-Agent": USER_AGENT,
          });
          var srcJson = parseJsonSafe(getResponseBody(srcRes), {});
          if (srcJson && Array.isArray(srcJson.sources)) {
            srcJson.sources.forEach(function (s) {
              var sUrl = s.src || s.url || s.file || "";
              if (!sUrl) return;
              var isHls = sUrl.indexOf(".m3u8") !== -1;
              var qNum = getQualityFromName(s.quality || s.label) || 1080;
              var stream = new StreamResult({
                url: sUrl,
                source: "Source " + (s.label || s.quality || "HD"),
                quality: qNum,
                type: isHls ? "hls" : "mp4",
                headers: { Referer: BASE_URL + "/", "User-Agent": USER_AGENT },
                referer: BASE_URL + "/",
              });
              allStreams.push(stream);
            });
          }
        } catch (_) {}
      }

      cb({ success: true, data: allStreams });
    } catch (e) {
      cb({ success: false, errorCode: "LOAD_STREAMS_ERROR", message: e.stack || e.message });
    }
  }

  // Register methods in global / window scope for SkyStream
  if (typeof module !== "undefined" && module.exports) {
    module.exports = { getHome: getHome, search: search, load: load, loadStreams: loadStreams };
  } else {
    var globalScope = typeof globalThis !== "undefined" ? globalThis : window;
    globalScope.getHome = getHome;
    globalScope.search = search;
    globalScope.load = load;
    globalScope.loadStreams = loadStreams;
  }

  globalThis.getHome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
