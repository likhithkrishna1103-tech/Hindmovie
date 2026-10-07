var BASE_URL =
  typeof manifest !== "undefined" && manifest && manifest.baseUrl
    ? String(manifest.baseUrl).replace(/\/+$/, "")
    : "https://anilight.live";

var API_URL = "https://api.anilight.live";

var USER_AGENT =
  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";

var HEADERS = {
  "User-Agent": USER_AGENT,
  Accept: "application/json, text/plain, */*",
  Referer: BASE_URL + "/",
  Origin: BASE_URL,
};

var STREAM_HEADERS = {
  "User-Agent": USER_AGENT,
  Referer: BASE_URL + "/",
};

// ========== Utility Functions ==========
function stripHtml(str) {
  return String(str || "")
    .replace(/<[^>]+>/g, "")
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

function responseStatus(res) {
  if (!res) return 0;
  if (typeof res.status === "number") return res.status;
  if (typeof res.statusCode === "number") return res.statusCode;
  return 0;
}

function jsonResponse(res, label) {
  var status = responseStatus(res);
  if (status && (status < 200 || status >= 300))
    throw new Error(label + " returned HTTP " + status);
  var data = parseJsonSafe(res && (res.body || res.text), null);
  if (!data || typeof data !== "object")
    throw new Error(label + " returned invalid JSON");
  if (data.error) throw new Error(label + ": " + data.error);
  return data;
}

function getTvType(format, type) {
  var ft = String(format || type || "").toUpperCase();
  if (ft === "MOVIE" || ft === "SPECIAL") return "movie";
  if (ft === "OVA" || ft === "ONA") return "anime";
  return "anime";
}

function getQualityFromName(quality) {
  if (!quality) return 0;
  var q = String(quality).toLowerCase().replace(/-/g, " ");
  var numMatch = q.match(/(\d+)/);
  if (numMatch) {
    var n = parseInt(numMatch[1], 10);
    if (n >= 2160) return 2160;
    if (n >= 1440) return 1440;
    if (n >= 1080) return 1080;
    if (n >= 720) return 720;
    if (n >= 480) return 480;
    if (n >= 360) return 360;
    if (n >= 240) return 240;
  }
  if (
    q.indexOf("4k") !== -1 ||
    q.indexOf("2160") !== -1 ||
    q.indexOf("uhd") !== -1
  )
    return 2160;
  if (q.indexOf("1080") !== -1 || q.indexOf("fhd") !== -1) return 1080;
  if (q.indexOf("720") !== -1 || q.indexOf("hd") !== -1) return 720;
  if (q.indexOf("480") !== -1 || q.indexOf("sd") !== -1) return 480;
  return 0;
}

function resolveUrl(base, relative) {
  if (!relative) return base;
  if (typeof URL === "function") {
    try { return new URL(relative, base).toString(); } catch (_) {}
  }
  if (relative.indexOf("http://") === 0 || relative.indexOf("https://") === 0)
    return relative;
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
  var lines = m3u8Content.split(/\r?\n/);
  var currentInf = null;
  var hasStreamInf = false;

  for (var i = 0; i < lines.length; i++) {
    var line = lines[i].trim();
    if (line.indexOf("#EXT-X-STREAM-INF") === 0) {
      hasStreamInf = true;
      var resMatch = line.match(/RESOLUTION=(\d+)x(\d+)/i);
      var bwMatch = line.match(/[^-]BANDWIDTH=(\d+)\b/i);
      var nameMatch = line.match(/NAME=["']?([^"',]+)/i);
      currentInf = {
        height: resMatch ? parseInt(resMatch[2], 10) : 0,
        width: resMatch ? parseInt(resMatch[1], 10) : 0,
        bandwidth: bwMatch ? parseInt(bwMatch[1], 10) : 0,
        name: nameMatch ? nameMatch[1] : "",
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
      else if (currentInf.height > 0) label = currentInf.height + "p";
      else if (currentInf.name) label = currentInf.name;
      else label = "Auto";

      variants.push({
        url: vUrl,
        height: currentInf.height || getQualityFromName(label) || 0,
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

// Parallel HTTP using native http_parallel bridge
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
        }),
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
          return { status: 599, body: "{}", headers: {}, url: item.url };
        });
    }),
  );
}

function mapMediaItem(item) {
  if (!item || !item.slug) return null;
  var title =
    (item.title &&
      (item.title.english || item.title.romaji || item.title.native)) ||
    "Unknown";

  var poster =
    (item.tmdb && item.tmdb.poster) ||
    (item.coverImage &&
      (item.coverImage.extraLarge || item.coverImage.large)) ||
    "";

  var banner = (item.tmdb && item.tmdb.backdrop) || item.bannerImage || poster;

  var logo = "";
  if (item.tmdb && item.tmdb.logos) {
    if (
      Array.isArray(item.tmdb.logos.english) &&
      item.tmdb.logos.english.length > 0
    ) {
      logo = item.tmdb.logos.english[0];
    } else if (
      Array.isArray(item.tmdb.logos.japanese) &&
      item.tmdb.logos.japanese.length > 0
    ) {
      logo = item.tmdb.logos.japanese[0];
    }
  }

  var score = item.averageScore
    ? parseFloat((item.averageScore / 10).toFixed(1))
    : 0;
  var year = parseInt(item.year || item.seasonYear || (item.startDate && item.startDate.year), 10) || 0;
  var status = item.status === "FINISHED" ? "completed" : "ongoing";

  return new MultimediaItem({
    title: title,
    url: BASE_URL + "/anime/" + item.slug,
    posterUrl: poster,
    bannerUrl: banner,
    logoUrl: logo,
    type: getTvType(item.format, item.type),
    year: year,
    score: score,
    status: status,
    tags: Array.isArray(item.genres) ? item.genres : [],
    description: stripHtml(item.description || ""),
    headers: HEADERS,
  });
}

// Stream URLs must identify real native media, not an iframe or a guessed
// quality path. VLC can play a master with audio renditions as one URL.
function mediaStream(url, source, headers, subtitles, quality) {
  var stream = new StreamResult({url: url, source: source + (quality ? " [" + quality + "p]" : " [Auto]"), headers: headers, subtitles: subtitles});
  if (quality) stream.quality = quality;
  return stream;
}

function normalizeTracks(tracks) {
  return (Array.isArray(tracks) ? tracks : []).filter(function (track) {
    return track && (track.file || track.url) && (!track.kind || /^(captions|subtitles)$/.test(track.kind));
  }).map(function (track) {
    return {url: track.file || track.url, label: track.label || track.lang || "English", language: track.label || track.lang || "English"};
  });
}

async function expandMedia(url, source, headers, subtitles, quality) {
  if (!/^https?:\/\//i.test(String(url || ""))) throw new Error("Invalid media URL");
  if (!/\.m3u8(?:$|[?#])/i.test(url)) return [mediaStream(url, source, headers, subtitles, quality)];
  var response = await http_get(url, headers);
  var status = responseStatus(response);
  if (status && (status < 200 || status >= 300)) throw new Error("Media playlist returned HTTP " + status);
  var playlist = String(response && (response.body || response.text) || "");
  if (playlist.indexOf("#EXTM3U") === -1) throw new Error("Media URL did not return HLS");
  var rows = [mediaStream(url, source, headers, subtitles, quality)];
  // Child playlists lose externally declared audio. Keep the original master
  // whenever the upstream uses audio renditions; it already combines both.
  if (/#EXT-X-MEDIA:[^\r\n]*TYPE=AUDIO/i.test(playlist)) return rows;
  var variants = parseHlsVariants(playlist, url) || [];
  for (var i = 0; i < variants.length; i++) rows.push(mediaStream(variants[i].url, source, headers, subtitles, variants[i].height));
  return rows;
}

async function decodeEmbedSources(data) {
  if (!data.enc) return data.sources;
  var encrypted = String(data.enc).replace(/-/g, "+").replace(/_/g, "/");
  while (encrypted.length % 4) encrypted += "=";
  var encode = function (value) {
    if (typeof btoa === "function") return btoa(value);
    return Buffer.from(value, "binary").toString("base64");
  };
  // Public MegaPlay e1-player v1.8 source-response AES-256-CBC parameters.
  var key = encode("i?LMTAx0Q6,:}50U" + "\0".repeat(16));
  var iv = encode("W0;27ToaUpl_P%'c");
  var plain = "";
  if (typeof crypto !== "undefined" && typeof crypto.decryptAES === "function") {
    try { plain = await crypto.decryptAES(encrypted, key, iv, {mode: "cbc"}); } catch (_) {}
  }
  if (!plain && typeof sendMessage === "function") plain = await sendMessage("crypto_decrypt_aes", JSON.stringify({data: encrypted, key: key, iv: iv}));
  var decoded = parseJsonSafe(plain, null);
  if (!decoded || !decoded.file) throw new Error("MegaPlay source decryption failed");
  return decoded;
}

async function resolveEpisodeEmbed(embed, type) {
  if (!/^https:\/\/megaplay\.buzz\//i.test(embed)) throw new Error("Unsupported episode embed host");
  // MegaPlay requires the originating site's Referer to expose this episode.
  var page = await http_get(embed, {"User-Agent": USER_AGENT, Referer: BASE_URL + "/", Accept: "text/html"});
  var status = responseStatus(page);
  if (status && (status < 200 || status >= 300)) throw new Error("Episode embed returned HTTP " + status);
  var html = String(page && (page.body || page.text) || "");
  var id = (html.match(/<title>\s*File\s+(\d+)/i) || [])[1] || (html.match(/data-id=["'](\d+)["']/i) || [])[1];
  if (!id) throw new Error("MegaPlay episode embed is unavailable");
  // Omit s=tcdn: that CDN wraps TS bytes in PNG and needs browser JS.
  var data = jsonResponse(await http_get("https://megaplay.buzz/stream/getSourcesNew?id=" + encodeURIComponent(id) + "&platform=OTHER", {
    "User-Agent": USER_AGENT, Referer: embed, "X-Requested-With": "XMLHttpRequest", Accept: "application/json"
  }), "MegaPlay sources");
  var sources = await decodeEmbedSources(data);
  var file = sources && (sources.file || (sources[0] && sources[0].file));
  if (!file) throw new Error("MegaPlay returned no native media URL");
  return expandMedia(file.replace(/\\\//g, "/"), "Anilight MegaPlay " + type, {
    "User-Agent": USER_AGENT, Referer: "https://megaplay.buzz/", Origin: "https://megaplay.buzz"
  }, normalizeTracks(data.tracks), 0);
}

// ========== Core Functions ==========

/**
 * Loads the home screen categories.
 * @param {(res: any) => void} cb
 */
async function getHome(cb) {
  try {
    var categories = [
      {
        name: "Trending",
        url: API_URL + "/api/filter?page=1&sort=TRENDING_DESC",
      },
      {
        name: "Popular Releasing",
        url:
          API_URL + "/api/filter?page=1&status=RELEASING&sort=POPULARITY_DESC",
      },
      {
        name: "Popular",
        url: API_URL + "/api/filter?page=1&sort=POPULARITY_DESC",
      },
      {
        name: "Highest Rated",
        url: API_URL + "/api/filter?page=1&sort=SCORE_DESC",
      },
    ];

    var responses = await httpParallelGet(
      categories.map(function (c) {
        return { url: c.url };
      }),
    );

    var homeData = {};
    for (var i = 0; i < categories.length; i++) {
      var cat = categories[i];
      var res = responses[i];
      var data = jsonResponse(res, cat.name);
      var mediaList = data && Array.isArray(data.media) ? data.media : [];
      var items = mediaList.map(mapMediaItem).filter(Boolean);
      if (items.length > 0) {
        homeData[cat.name] = items;
      }
    }

    if (!Object.keys(homeData).length) throw new Error("No anime returned by home categories");
    cb({ success: true, data: homeData });
  } catch (e) {
    cb({
      success: false,
      errorCode: "GET_HOME_ERROR",
      message: e.stack || e.message,
    });
  }
}

/**
 * Searches for media items.
 * @param {string} query
 * @param {(res: any) => void} cb
 */
async function search(query, cb) {
  try {
    var searchUrl =
      API_URL + "/api/filter?page=1&search=" + encodeURIComponent(query || "");
    var res = await http_get(searchUrl, HEADERS);
    var data = jsonResponse(res, "Search");
    var mediaList = data && Array.isArray(data.media) ? data.media : [];
    var results = mediaList.map(mapMediaItem).filter(Boolean);

    cb({ success: true, data: results });
  } catch (e) {
    cb({
      success: false,
      errorCode: "SEARCH_ERROR",
      message: e.stack || e.message,
    });
  }
}

/**
 * Loads details for a specific media item.
 * @param {string} url
 * @param {(res: any) => void} cb
 */
async function load(url, cb) {
  try {
    var slug = "";
    if (url.indexOf("/api/anime/") !== -1) {
      slug = url.split("/api/anime/")[1];
    } else if (url.indexOf("/anime/") !== -1) {
      slug = url.split("/anime/")[1];
    } else {
      slug = url.split("/").filter(Boolean).pop();
    }
    slug = (slug || "").split("?")[0].replace(/\/+$/, "");

    var detailRequests = [
      { url: API_URL + "/api/anime/" + slug },
      { url: API_URL + "/api/watch/" + slug },
    ];
    var detailResponses = await httpParallelGet(detailRequests);

    var animeData = jsonResponse(detailResponses[0], "Anime details");
    var watchData = jsonResponse(detailResponses[1], "Episode list");
    watchData = watchData.data || watchData;

    if (!animeData || !animeData.slug) {
      cb({
        success: false,
        errorCode: "LOAD_ERROR",
        message: "Failed to load anime details",
      });
      return;
    }

    var title =
      (animeData.title &&
        (animeData.title.english ||
          animeData.title.romaji ||
          animeData.title.native)) ||
      "Unknown";

    var poster =
      (animeData.tmdb && animeData.tmdb.poster) ||
      (animeData.coverImage &&
        (animeData.coverImage.extraLarge || animeData.coverImage.large)) ||
      "";

    var banner =
      (animeData.tmdb && animeData.tmdb.backdrop) ||
      animeData.bannerImage ||
      poster;

    var logo = "";
    if (animeData.tmdb && animeData.tmdb.logos) {
      if (
        Array.isArray(animeData.tmdb.logos.english) &&
        animeData.tmdb.logos.english.length > 0
      ) {
        logo = animeData.tmdb.logos.english[0];
      } else if (
        Array.isArray(animeData.tmdb.logos.japanese) &&
        animeData.tmdb.logos.japanese.length > 0
      ) {
        logo = animeData.tmdb.logos.japanese[0];
      }
    }

    var description = stripHtml(animeData.description || "");
    var score = animeData.averageScore
      ? parseFloat((animeData.averageScore / 10).toFixed(1))
      : 0;
    var year = parseInt(animeData.year || animeData.seasonYear || (animeData.startDate && animeData.startDate.year), 10) || 0;
    var duration = animeData.duration ? parseInt(animeData.duration, 10) : 0;
    var status = animeData.status === "FINISHED" ? "completed" : "ongoing";
    var genres = Array.isArray(animeData.genres) ? animeData.genres : [];

    var anizipEpisodes = null;
    var malId = animeData.idMal || null;
    var anilistId = animeData.anilistId || null;

    if (anilistId) {
      try {
        var anizipRes = await http_get(
          "https://api.ani.zip/mappings?anilist_id=" + anilistId,
          HEADERS,
        );
        var anizipData = parseJsonSafe(
          anizipRes && (anizipRes.body || anizipRes.text),
          null,
        );
        if (anizipData) {
          if (anizipData.episodes) anizipEpisodes = anizipData.episodes;
          if (anizipData.mappings) {
            if (!malId && anizipData.mappings.mal_id)
              malId = anizipData.mappings.mal_id;
            if (!anilistId && anizipData.mappings.anilist_id)
              anilistId = anizipData.mappings.anilist_id;
          }
        }
      } catch (_) {}
    }

    var watchId = watchData.id || animeData.id || 0;
    var servers = watchData.servers || {};
    var subProviders = Array.isArray(servers.subProviders)
      ? servers.subProviders
      : [];
    var dubProviders = Array.isArray(servers.dubProviders)
      ? servers.dubProviders
      : [];
    var rawEpisodes = Array.isArray(watchData.episodes)
      ? watchData.episodes
      : [];

    rawEpisodes.sort(function (a, b) {
      return (parseInt(a.number, 10) || 0) - (parseInt(b.number, 10) || 0);
    });

    var episodes = [];

    for (var i = 0; i < rawEpisodes.length; i++) {
      var ep = rawEpisodes[i];
      var epNum = parseInt(ep.number, 10) || i + 1;
      var anizipEp = anizipEpisodes ? anizipEpisodes[String(epNum)] : null;

      var epTitle =
        ep.title ||
        (anizipEp &&
          anizipEp.title &&
          (anizipEp.title.en ||
            anizipEp.title["x-jat"] ||
            anizipEp.title.romaji)) ||
        "Episode " + epNum;

      var epImg = ep.img || (anizipEp && anizipEp.image) || poster;
      var epDesc = stripHtml(
        ep.description || (anizipEp && anizipEp.overview) || "",
      );
      var epScore =
        anizipEp && anizipEp.rating ? parseFloat(anizipEp.rating) : 0;
      var epAirDate =
        (anizipEp && (anizipEp.airDateUtc || anizipEp.airDate)) || "";
      var epRuntime =
        anizipEp && anizipEp.runtime
          ? parseInt(anizipEp.runtime, 10)
          : duration;

      var availableEmbeds = ep.embed_url || {};
      var hasEmbedLanguages = Object.keys(availableEmbeds).length > 0;
      if (availableEmbeds.sub || subProviders.length > 0 || (!hasEmbedLanguages && dubProviders.length === 0)) {
        episodes.push(
          new Episode({
            name: epTitle,
            url:
              BASE_URL +
              "/watch/" +
              slug +
              "?id=" +
              watchId +
              "&ep=" +
              epNum +
              "&type=sub",
            season: 1,
            episode: epNum,
            description: epDesc,
            posterUrl: epImg,
            rating: epScore,
            runtime: epRuntime,
            airDate: epAirDate,
            dubStatus: "subbed",
            headers: HEADERS,
          }),
        );
      }

      if (availableEmbeds.dub || dubProviders.length > 0) {
        episodes.push(
          new Episode({
            name: epTitle,
            url:
              BASE_URL +
              "/watch/" +
              slug +
              "?id=" +
              watchId +
              "&ep=" +
              epNum +
              "&type=dub",
            season: 1,
            episode: epNum,
            description: epDesc,
            posterUrl: epImg,
            rating: epScore,
            runtime: epRuntime,
            airDate: epAirDate,
            dubStatus: "dubbed",
            headers: HEADERS,
          }),
        );
      }
    }

    if (!episodes.length) throw new Error("No playable episodes listed for " + title);
    var syncDataObj = {};
    if (malId) syncDataObj.mal = String(malId);
    if (anilistId) syncDataObj.anilist = String(anilistId);

    var item = new MultimediaItem({
      title: title,
      url: BASE_URL + "/anime/" + slug,
      posterUrl: poster,
      bannerUrl: banner,
      logoUrl: logo,
      type: getTvType(animeData.format, animeData.type),
      year: year,
      score: score,
      duration: duration,
      status: status,
      tags: genres,
      description: description,
      syncData: syncDataObj,
      episodes: episodes,
      headers: HEADERS,
    });

    cb({ success: true, data: item });
  } catch (e) {
    cb({
      success: false,
      errorCode: "LOAD_ERROR",
      message: e.stack || e.message,
    });
  }
}

/**
 * Provides playable direct stream links.
 * Fetches all providers concurrently in parallel via http_parallel.
 * @param {string} url
 * @param {(res: any) => void} cb
 */
async function loadStreams(url, cb) {
  try {
    var animeId = 0;
    var epNum = 1;
    var type = "sub";
    var slug = "";

    if (typeof url === "string" && url.trim().indexOf("{") === 0) {
      var parsedLink = parseJsonSafe(url, {});
      animeId = parseInt(parsedLink.id, 10) || 0;
      epNum =
        parseInt(parsedLink.epNum || parsedLink.ep || parsedLink.episode, 10) ||
        1;
      type = String(parsedLink.type || "sub").toLowerCase();
      slug = parsedLink.slug || "";
    } else {
      var urlStr = String(url || "");
      var queryIndex = urlStr.indexOf("?");
      var pathPart = queryIndex !== -1 ? urlStr.slice(0, queryIndex) : urlStr;
      var queryPart = queryIndex !== -1 ? urlStr.slice(queryIndex + 1) : "";

      var params = {};
      if (queryPart) {
        var pairs = queryPart.split("&");
        for (var i = 0; i < pairs.length; i++) {
          var kv = pairs[i].split("=");
          if (kv[0])
            params[decodeURIComponent(kv[0])] = decodeURIComponent(kv[1] || "");
        }
      }

      if (params.id) animeId = parseInt(params.id, 10) || 0;
      if (params.ep) epNum = parseInt(params.ep, 10) || 1;
      if (params.type) type = params.type.toLowerCase();
      if (params.dub === "true" || params.dub === "1") type = "dub";

      var pathSegments = pathPart.split("/").filter(Boolean);
      for (var s = 0; s < pathSegments.length; s++) {
        if (
          pathSegments[s] === "watch" ||
          pathSegments[s] === "anime" ||
          pathSegments[s] === "play"
        ) {
          slug = pathSegments[s + 1] || "";
          if (
            !params.ep &&
            pathSegments[s + 2] &&
            /^\d+$/.test(pathSegments[s + 2])
          ) {
            epNum = parseInt(pathSegments[s + 2], 10);
          }
          break;
        }
      }
      if (!slug && pathSegments.length > 0) {
        slug = pathSegments[pathSegments.length - 1];
      }
    }

    if (!slug) throw new Error("A watch/anime slug is required to select an episode");
    var watchData = jsonResponse(await http_get(API_URL + "/api/watch/" + slug, HEADERS), "Episode list");
    watchData = watchData.data || watchData;
    animeId = parseInt(watchData.id, 10) || animeId;
    if (!animeId) throw new Error("Could not determine anime ID for streaming");
    if (type !== "sub" && type !== "dub") throw new Error("Unsupported episode language");

    var episode = (watchData.episodes || []).filter(function (ep) {
      return Number(ep.number || ep.epNum) === epNum;
    })[0];
    if (!episode) throw new Error("Episode " + epNum + " is not listed by AniLight");
    var allStreams = [];
    var failures = [];
    var embed = episode.embed_url && episode.embed_url[type];
    if (embed) {
      try {
        allStreams = await resolveEpisodeEmbed(embed, type);
      } catch (error) { failures.push(String(error.message || error)); }
    }

    // Legacy API responses may still list direct providers. New responses
    // expose an official per-episode embed instead; never invent provider IDs.
    var serverList = watchData.servers && watchData.servers[type === "dub" ? "dubProviders" : "subProviders"];
    var providers = Array.isArray(serverList) ? serverList : [];
    var responses = await httpParallelGet(providers.map(function (provider) {
      return {url: API_URL + "/api/sources?id=" + animeId + "&epNum=" + epNum + "&type=" + type + "&providerId=" + encodeURIComponent(provider.id)};
    }));
    for (var pIdx = 0; pIdx < providers.length; pIdx++) {
      try {
        var provider = providers[pIdx];
        var sourceData = jsonResponse(responses[pIdx], "Provider " + provider.id);
        var sources = Array.isArray(sourceData.sources) ? sourceData.sources : [];
        var subtitles = normalizeTracks(sourceData.tracks);
        for (var si = 0; si < sources.length; si++) {
          var src = sources[si];
          if (!src || !src.url || src.type === "embed") continue;
          var urls = Array.isArray(src.url) ? src.url : [src.url];
          for (var ui = 0; ui < urls.length; ui++) {
            var headers = Object.assign({}, STREAM_HEADERS, sourceData.headers || {}, src.headers || {});
            var rows = await expandMedia(urls[ui], "Anilight " + provider.id + " " + type, headers, subtitles, getQualityFromName(src.quality));
            allStreams = allStreams.concat(rows);
          }
        }
      } catch (error) { failures.push(String(error.message || error)); }
    }
    if (!allStreams.length) {
      throw new Error(failures.join("; ") || "No native media source is available for episode " + epNum + " (" + type + ")");
    }

    // Deduplicate streams by URL
    var seen = {};
    var uniqueStreams = [];
    for (var u = 0; u < allStreams.length; u++) {
      var streamObj = allStreams[u];
      if (streamObj && streamObj.url && !seen[streamObj.url]) {
        seen[streamObj.url] = true;
        uniqueStreams.push(streamObj);
      }
    }

    cb({ success: true, data: uniqueStreams });
  } catch (e) {
    cb({
      success: false,
      errorCode: "STREAM_ERROR",
      message: e.stack || e.message,
    });
  }
}

// ========== Exports ==========
globalThis.getHome = getHome;
globalThis.search = search;
globalThis.load = load;
globalThis.loadStreams = loadStreams;
