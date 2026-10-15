(function () {
  // SkyStream SDK: asynchronous HTTP helpers, entity constructors and one callback per entry point.
  var BASE = (
    (typeof manifest !== "undefined" && manifest.baseUrl) ||
    "https://lunarx.to"
  ).replace(/\/+$/, "");
  var API = BASE.replace(/^(https?:\/\/)(?:www\.)?/, "$1api.");
  var UA =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";
  var HEADERS = {
    "User-Agent": UA,
    Referer: BASE + "/",
    Origin: BASE,
    Accept: "application/json",
  };
  var cache = {},
    contextKey = null,
    contextAt = 0;

  function text(value) {
    return String(value == null ? "" : value);
  }
  function clean(value) {
    return text(value)
      .replace(/<br\s*\/?\s*>/gi, "\n")
      .replace(/<[^>]+>/g, "")
      .replace(/&amp;/g, "&")
      .replace(/&quot;/g, '"')
      .replace(/&#39;|&apos;/g, "'")
      .replace(/&lt;/g, "<")
      .replace(/&gt;/g, ">")
      .replace(/&nbsp;/g, " ")
      .trim();
  }
  function status(res) {
    return Number(res && (res.status || res.statusCode)) || 0;
  }
  function body(res) {
    return text(res && (res.body || res.text));
  }
  function urlParts(url) {
    var match = text(url).match(
      /^(https?:)\/\/([^/?#]+)([^?#]*)(\?[^#]*)?(#.*)?$/i,
    );
    if (!match) throw new Error("Invalid HTTP URL");
    return {
      protocol: match[1],
      origin: match[1] + "//" + match[2],
      path: match[3] || "/",
      query: match[4] || "",
      hash: match[5] || "",
    };
  }
  function absolute(url, base) {
    // The app's URL shim lacks searchParams and does not resolve ../ or //.
    // Keep URL handling local so the app and CLI produce identical URLs.
    var reference = text(url),
      parent = urlParts(base || BASE + "/"),
      target;
    if (/^https?:\/\//i.test(reference)) target = urlParts(reference);
    else if (reference.indexOf("//") === 0)
      target = urlParts(parent.protocol + reference);
    else {
      var match = reference.match(/^([^?#]*)(\?[^#]*)?(#.*)?$/);
      if (!match || /^[a-z][a-z0-9+.-]*:/i.test(reference))
        throw new Error("Invalid HTTP URL");
      var path = match[1];
      target = {
        origin: parent.origin,
        path: !path
          ? parent.path
          : path[0] === "/"
            ? path
            : parent.path.slice(0, parent.path.lastIndexOf("/") + 1) + path,
        query: match[2] !== undefined ? match[2] : !path ? parent.query : "",
        hash: match[3] || "",
      };
    }
    var segments = target.path.split("/"),
      normalized = [];
    segments.forEach(function (segment) {
      if (segment === "..") {
        if (normalized.length > 1) normalized.pop();
      } else if (segment !== ".") normalized.push(segment);
    });
    if (/\/(?:\.|\.\.)$/.test(target.path)) normalized.push("");
    return (
      target.origin +
      (normalized.join("/") || "/") +
      target.query +
      target.hash
    );
  }
  function queryValue(url, key) {
    var value = text(url).split("#")[0],
      start = value.indexOf("?");
    if (start < 0) return null;
    function decode(part) {
      part = part.replace(/\+/g, " ");
      try {
        return decodeURIComponent(part);
      } catch (_) {
        return part;
      }
    }
    var pairs = value.slice(start + 1).split("&");
    for (var i = 0; i < pairs.length; i++) {
      var split = pairs[i].indexOf("="),
        name = split < 0 ? pairs[i] : pairs[i].slice(0, split);
      if (decode(name) === key)
        return decode(split < 0 ? "" : pairs[i].slice(split + 1));
    }
    return null;
  }
  function validUrl(url) {
    return /^https?:\/\/[^\s]+$/i.test(text(url));
  }
  function error(cb, code, e) {
    cb({
      success: false,
      errorCode: code,
      message: text((e && e.message) || e),
    });
  }
  async function request(url, headers) {
    var res = await http_get(url, headers || HEADERS);
    if (status(res) < 200 || status(res) >= 300)
      throw new Error("HTTP " + status(res) + " from " + url.split("?")[0]);
    return res;
  }
  async function json(path) {
    var res = await request(/^https?:/.test(path) ? path : API + path);
    var data;
    try {
      data = JSON.parse(body(res));
    } catch (_) {
      throw new Error("Invalid JSON from " + path.split("?")[0]);
    }
    if (!data || data.error || data.success === false)
      throw new Error(
        (data && (data.error || data.message)) || "Empty API response",
      );
    return data;
  }
  async function optional(path) {
    try {
      return await json(path);
    } catch (_) {
      return null;
    }
  }
  function unique(items, key) {
    var seen = {};
    return items.filter(function (item) {
      var value = key(item);
      if (!value || seen[value]) return false;
      seen[value] = true;
      return true;
    });
  }
  function poster(m) {
    return (
      (m.coverImage &&
        (m.coverImage.extraLarge ||
          m.coverImage.large ||
          m.coverImage.medium)) ||
      m.image ||
      m.poster_url ||
      ""
    );
  }
  function title(m) {
    return (
      m.titleEnglish ||
      m.englishTitle ||
      (m.title &&
        (m.title.english || m.title.romaji || m.title.userPreferred)) ||
      m.titleRomaji ||
      m.romajiTitle ||
      (typeof m.title === "string" ? m.title : "") ||
      "Unknown"
    );
  }
  function item(m) {
    var id = m.anilistId || (typeof m.id === "number" ? m.id : null);
    if (!id) return null;
    return new MultimediaItem({
      title: title(m),
      url: BASE + "/anime/" + id,
      posterUrl: poster(m),
      bannerUrl: m.bannerImage || m.bannerUrl || m.backdropUrl || "",
      type: m.format === "MOVIE" ? "movie" : "anime",
      description: clean(m.description || m.synopsis),
      year: Number(m.seasonYear || m.startDateYear || m.year) || 0,
      score: Number(m.averageScore) / 10 || 0,
      tags: m.genres || [],
      isAdult: !!m.isAdult,
      headers: HEADERS,
    });
  }
  function items(list) {
    return unique((list || []).map(item).filter(Boolean), function (m) {
      return m.url;
    });
  }
  function parseUrl(url) {
    var parsed = absolute(url),
      match = urlParts(parsed).path.match(/^\/anime\/([^/]+)(?:\/(\d+)\/(\d+))?\/?$/);
    if (!match)
      throw new Error(
        "Expected a LunarX /anime/title or /anime/title/season/episode URL",
      );
    var audio =
      queryValue(parsed, "audio") ||
      queryValue(parsed, "type") ||
      queryValue(parsed, "language");
    return {
      id: decodeURIComponent(match[1]),
      season: Number(match[2]) || 1,
      episode: Number(match[3]) || 0,
      lang:
        queryValue(parsed, "dub") === "true" ||
        queryValue(parsed, "a") === "1" ||
        /(?:^|-)dub$/.test(audio || "")
          ? "dub"
          : "sub",
    };
  }
  async function resolveId(value) {
    if (/^\d+$/.test(value)) return value;
    var data = await json(
      "/api/anidb/search?q=" +
        encodeURIComponent(
          value.replace(/-[a-z0-9]{5}$/i, "").replace(/-/g, " "),
        ),
    );
    var match = (data.items || []).filter(function (m) {
      return m.id === value || m.animeId === value;
    })[0];
    if (!match || !match.anilistId)
      throw new Error("Could not resolve LunarX title: " + value);
    return String(match.anilistId);
  }
  async function info(id) {
    if (!cache[id]) {
      cache[id] = json(
        "/api/anidb/info?anilistId=" + encodeURIComponent(id),
      ).catch(function (e) {
        delete cache[id];
        throw e;
      });
    }
    return cache[id];
  }
  async function episodes(id, metadata) {
    if (Array.isArray(metadata.episodes) && metadata.episodes.length)
      return metadata.episodes;
    var result = await json(
      "/api/animes/v2/vermillion/episodes?id=" + encodeURIComponent(id),
    );
    return Array.isArray(result.data) ? result.data : [];
  }

  async function getHome(cb) {
    try {
      var result = await json(
        "/api/anidb/feed?feeds=trending,popular,seasonal,topRated,nextSeason&limit=15",
      );
      var feeds = result.feeds || {},
        data = {};
      [
        ["trending", "Trending"],
        ["popular", "Popular"],
        ["seasonal", "This Season"],
        ["topRated", "Top Rated"],
        ["nextSeason", "Upcoming"],
      ].forEach(function (entry) {
        var list = items(feeds[entry[0]] && feeds[entry[0]].items);
        if (list.length) data[entry[1]] = list;
      });
      if (!Object.keys(data).length)
        throw new Error("LunarX returned no home categories");
      cb({ success: true, data: data });
    } catch (e) {
      error(cb, "GET_HOME_ERROR", e);
    }
  }
  async function search(query, cb) {
    try {
      if (!text(query).trim()) return cb({ success: true, data: [] });
      var result = await json(
        "/api/anidb/search?q=" + encodeURIComponent(text(query).trim()),
      );
      cb({ success: true, data: items(result.items) });
    } catch (e) {
      error(cb, "SEARCH_ERROR", e);
    }
  }
  async function load(url, cb) {
    try {
      var parsed = parseUrl(url),
        id = await resolveId(parsed.id),
        m = await info(id),
        list = await episodes(id, m);
      var result = item(m);
      if (!result || !title(m) || title(m) === "Unknown")
        throw new Error("Title metadata is unavailable");
      result.url = BASE + "/anime/" + id;
      result.duration = Number(m.duration) || 0;
      result.status =
        m.status === "FINISHED"
          ? "completed"
          : m.status === "RELEASING"
            ? "ongoing"
            : "upcoming";
      result.logoUrl = (m.logos && m.logos[0] && m.logos[0].src) || "";
      result.cast = (m.characters || []).map(function (c) {
        return new Actor({
          name: c.name || "",
          image: c.image || "",
          role: c.role || "",
        });
      });
      result.trailers = m.trailerId
        ? [
            new Trailer({
              url: "https://www.youtube.com/watch?v=" + m.trailerId,
            }),
          ]
        : [];
      result.recommendations = items(m.recommendations);
      result.syncData = { anilist: String(m.anilistId || id) };
      if (m.malId) result.syncData.mal = String(m.malId);
      var next = m.nextAiringEpisode;
      if (next || m.nextAiringAt) {
        var air =
          typeof next === "object" && next ? next.airingAt : m.nextAiringAt;
        result.nextAiring = new NextAiring({
          episode:
            Math.floor(
              Number(typeof next === "object" && next ? next.episode : next),
            ) || 0,
          season: 1,
          unixTime: Math.floor(Number(air)) || 0,
        });
      }
      result.episodes = [];
      unique(
        list.filter(function (ep) {
          return Number(ep.number) > 0;
        }),
        function (ep) {
          return ep.number;
        },
      )
        .sort(function (a, b) {
          return a.number - b.number;
        })
        .forEach(function (ep) {
          ["sub", "dub"].forEach(function (lang) {
            if (
              ep[lang === "sub" ? "hasSub" : "hasDub"] !== true &&
              !(ep[lang + "Providers"] || []).length
            )
              return;
            result.episodes.push(
              new Episode({
                name:
                  clean(
                    (ep.titles && (ep.titles.en || ep.titles["x-jat"])) ||
                      ep.title,
                  ) || "Episode " + ep.number,
                url:
                  result.url +
                  "/1/" +
                  ep.number +
                  (lang === "dub" ? "?dub=true" : ""),
                season: 1,
                episode: Number(ep.number),
                description: clean(ep.description),
                posterUrl: ep.img || ep.image || result.posterUrl,
                dubStatus: lang,
                headers: HEADERS,
              }),
            );
          });
        });
      cb({ success: true, data: result });
    } catch (e) {
      error(cb, "LOAD_ERROR", e);
    }
  }

  // The public watch page supplies a versioned bytecode descriptor and shuffled hex chunks.
  // Interpret only this data format; never evaluate remote JavaScript or save session keys.
  function decodeContext(props) {
    var names = Object.keys(props);
    for (var index = 0; index < names.length; index++) {
      try {
        var name = names[index],
          value = props[name];
        if (typeof value !== "string") continue;
        var encoded = atob(value.split("").reverse().join("")),
          hash = 0,
          decoded = "";
        for (var h = 0; h < name.length; h++)
          hash = (hash * 31 + name.charCodeAt(h)) & 255;
        for (var k = 0; k < encoded.length; k++)
          decoded += String.fromCharCode(
            encoded.charCodeAt(k) ^ ((hash + 37 * k) & 255),
          );
        var fields = decoded.split("|");
        if (
          fields.length !== 6 ||
          fields[0] !== "3" ||
          !/^[a-f0-9]+$/i.test(fields[4]) ||
          fields[4].length % 3
        )
          continue;
        var seed = parseInt(fields[1], 16),
          mul = parseInt(fields[2], 16),
          add = parseInt(fields[3], 16),
          program = [],
          hex = "";
        if (!isFinite(seed) || !isFinite(mul) || !isFinite(add)) continue;
        for (var p = 0; p < fields[4].length; p += 3) {
          var opcode = parseInt(fields[4][p], 16);
          if (opcode > 7) throw new Error("Unknown context opcode");
          program.push([opcode, parseInt(fields[4].slice(p + 1, p + 3), 16)]);
        }
        fields[5]
          .split(".")
          .filter(Boolean)
          .forEach(function (part) {
            hex += props[part] || "";
          });
        if (!/^(?:[a-f0-9]{2})+$/i.test(hex) || hex.length > 32768) continue;
        var out = [],
          previous = 0;
        for (var b = 0; b < hex.length; b += 2) {
          var cipher = parseInt(hex.slice(b, b + 2), 16),
            n = cipher ^ previous;
          seed = (seed * mul + add) & 255;
          for (var op = program.length - 1; op >= 0; op--) {
            var instruction = program[op][0],
              arg = program[op][1];
            if (instruction === 0) n ^= arg;
            else if (instruction === 1) n -= arg;
            else if (instruction === 2) {
              var rotation = arg & 7 || 1;
              n = ((n & 255) >>> rotation) | (n << (8 - rotation));
            } else if (instruction === 3)
              n = ((n & 15) << 4) | ((n & 255) >>> 4);
            else if (instruction === 4) n ^= seed;
            else if (instruction === 5) n ^= ((b / 2) * (arg | 1) + arg) & 255;
            else if (instruction === 6) n = ~n;
            else n = arg - n;
            n &= 255;
          }
          out.push(n);
          previous = cipher;
        }
        if (out[0] !== 167 || out[1] !== 62 || out[2] !== 145) continue;
        var left = out[3] * 256 + out[4],
          right = out[5] * 256 + out[6];
        if (!left || !right || 7 + left + right > out.length) continue;
        return [
          String.fromCharCode.apply(null, out.slice(7, 7 + left)),
          String.fromCharCode.apply(
            null,
            out.slice(7 + left, 7 + left + right),
          ),
        ];
      } catch (_) {}
    }
    return null;
  }
  function readContext(html) {
    var re = /self\.__next_f\.push\(\[1,("(?:\\.|[^"\\])*")\]\)/g,
      match,
      rsc = "",
      found = null;
    while ((match = re.exec(html))) {
      try {
        rsc += JSON.parse(match[1]);
      } catch (_) {}
    }
    function visit(value, depth) {
      if (!value || typeof value !== "object" || depth > 24 || found) return;
      if (!Array.isArray(value)) found = decodeContext(value);
      if (!found)
        Object.keys(value).forEach(function (key) {
          visit(value[key], depth + 1);
        });
    }
    rsc.split("\n").forEach(function (line) {
      try {
        visit(JSON.parse(line.slice(line.indexOf(":") + 1)), 0);
      } catch (_) {}
    });
    return found;
  }
  // SHA-256 in plain JS, also available in SDKs without WebCrypto or Node modules.
  function sha256(input) {
    var bytes = encodeURIComponent(input).replace(
        /%([0-9a-f]{2})/gi,
        function (_, hex) {
          return String.fromCharCode(parseInt(hex, 16));
        },
      ),
      words = [],
      initial = [],
      constants = [],
      prime = 2;
    while (constants.length < 64) {
      var isPrime = true;
      for (var divisor = 2; divisor * divisor <= prime; divisor++)
        if (prime % divisor === 0) {
          isPrime = false;
          break;
        }
      if (isPrime) {
        if (initial.length < 8)
          initial.push((Math.sqrt(prime) * 4294967296) | 0);
        constants.push((Math.pow(prime, 1 / 3) * 4294967296) | 0);
      }
      prime++;
    }
    var length = bytes.length;
    for (var i = 0; i < length; i++)
      words[i >> 2] =
        (words[i >> 2] || 0) | (bytes.charCodeAt(i) << (24 - (i % 4) * 8));
    words[length >> 2] =
      (words[length >> 2] || 0) | (128 << (24 - (length % 4) * 8));
    words[(((length + 8) >> 6) + 1) * 16 - 1] = length * 8;
    function rotate(x, count) {
      return (x >>> count) | (x << (32 - count));
    }
    for (var block = 0; block < words.length; block += 16) {
      var w = [],
        state = initial.slice();
      for (var t = 0; t < 64; t++) {
        if (t < 16) w[t] = words[block + t] | 0;
        else {
          var x = w[t - 15],
            y = w[t - 2];
          w[t] =
            (w[t - 16] +
              (rotate(x, 7) ^ rotate(x, 18) ^ (x >>> 3)) +
              w[t - 7] +
              (rotate(y, 17) ^ rotate(y, 19) ^ (y >>> 10))) |
            0;
        }
        var a = state[0],
          b = state[1],
          c = state[2],
          d = state[3],
          e = state[4],
          f = state[5],
          g = state[6],
          h = state[7];
        var temp =
          (h +
            (rotate(e, 6) ^ rotate(e, 11) ^ rotate(e, 25)) +
            ((e & f) ^ (~e & g)) +
            constants[t] +
            w[t]) |
          0;
        state = [
          (temp +
            (rotate(a, 2) ^ rotate(a, 13) ^ rotate(a, 22)) +
            ((a & b) ^ (a & c) ^ (b & c))) |
            0,
          a,
          b,
          c,
          (d + temp) | 0,
          e,
          f,
          g,
        ];
      }
      for (var j = 0; j < 8; j++) initial[j] = (initial[j] + state[j]) | 0;
    }
    var out = [];
    initial.forEach(function (word) {
      for (var shift = 24; shift >= 0; shift -= 8)
        out.push((word >>> shift) & 255);
    });
    return out;
  }
  async function streamKey(id, episode, refresh) {
    if (!refresh && contextKey && Date.now() - contextAt < 300000)
      return contextKey;
    var watch = BASE + "/anime/" + id + "/1/" + episode,
      pair = null;
    // Next's dynamic episode route emits the same bootstrap for suffixed episode paths.
    // The text response is also accessible to SDK clients challenged on the document route.
    for (var suffix of [".txt", ""]) {
      try {
        pair = readContext(
          body(
            await request(watch + suffix, {
              "User-Agent": UA,
              Referer: BASE + "/anime/" + id,
              Accept: "text/html",
            }),
          ),
        );
      } catch (_) {}
      if (pair) break;
    }
    if (!pair)
      throw new Error(
        "LunarX stream context is unavailable or its encoding has changed",
      );
    var left = pair[0],
      right = pair[1],
      digest = sha256(left + "\x01" + right),
      key = [];
    for (var i = 0; i < Math.max(left.length, right.length); i++)
      key.push(
        (left.charCodeAt(i % left.length) ^
          right.charCodeAt(i % right.length) ^
          digest[i % 32] ^
          ((83 * i + 29) & 255)) &
          255,
      );
    contextKey = key;
    contextAt = Date.now();
    return key;
  }
  function decodeUrl(value, key) {
    if (validUrl(value)) return value;
    var encoded = text(value).replace(/-/g, "+").replace(/_/g, "/");
    while (encoded.length % 4) encoded += "=";
    var bytes = atob(encoded),
      url = "";
    for (var i = 0; i < bytes.length; i++)
      url += String.fromCharCode(bytes.charCodeAt(i) ^ key[i % key.length]);
    if (!validUrl(url))
      throw new Error("LunarX returned an undecodable stream URL");
    return url;
  }
  function subtitles(tracks) {
    return unique(
      (tracks || [])
        .filter(function (t) {
          return (
            validUrl(t.url || t.file) &&
            !/thumb|episode name/i.test(
              [t.kind, t.label, t.title, t.language].join(" "),
            )
          );
        })
        .map(function (t) {
          return {
            url: t.url || t.file,
            label:
              t.label ||
              t.title ||
              t.language_name ||
              t.lang ||
              t.language ||
              "Subtitles",
          };
        }),
      function (t) {
        return t.url;
      },
    );
  }
  function playbackHeaders(provider, supplied) {
    var referers = {
      yuki: "https://megaplay.buzz/",
      beep: "https://kwik.cx/",
      uwu: "https://kwik.cx/",
      akane: "https://dotstream.buzz/",
      vanity: "https://vidwish.live/",
      miku: "https://megacloud.bloggy.click/",
      ozzy: "https://animekai.to/",
      sora: "https://krussdomi.com/",
      kiwi: "https://krussdomi.com/",
      zen: "https://flixcloud.cc/",
    };
    var headers = {
      "User-Agent": UA,
      Referer: referers[provider] || BASE + "/",
    };
    Object.keys(supplied || {}).forEach(function (k) {
      if (/^(referer|origin|user-agent|cookie|authorization)$/i.test(k)) {
        var canonical = {
          referer: "Referer",
          origin: "Origin",
          "user-agent": "User-Agent",
          cookie: "Cookie",
          authorization: "Authorization",
        }[k.toLowerCase()];
        headers[canonical] = text(supplied[k]);
      }
    });
    if (!headers.Origin) headers.Origin = urlParts(absolute(headers.Referer)).origin;
    return headers;
  }
  function quality(value) {
    var m = text(value).match(/(\d{3,4})p?/);
    return m ? Number(m[1]) : 0;
  }
  function providerPath(id, provider, number, lang, fresh) {
    // The upstream source cache can outlive its URL-encoding key. Its cache key
    // uses the raw episode string: a zero-padded integer requests the same episode
    // with a fresh cache entry. Rotate that representation every five minutes.
    var episode = fresh
      ? new Array(2 + (Math.floor(Date.now() / 300000) % 288)).join("0") +
        number
      : number;
    return (
      "/api/animes/vermillion/sources?id=" +
      id +
      "&host=" +
      encodeURIComponent(provider) +
      "&epNum=" +
      episode +
      "&type=" +
      lang
    );
  }
  function variants(playlist, url) {
    var lines = playlist.split(/\r?\n/),
      list = [],
      pending = null;
    lines.forEach(function (line) {
      line = line.trim();
      if (/^#EXT-X-STREAM-INF:/.test(line)) {
        var match = line.match(/RESOLUTION=\d+x(\d+)/);
        pending = { height: match ? Number(match[1]) : 0 };
      } else if (pending && line && line[0] !== "#") {
        pending.url = absolute(line, url);
        list.push(pending);
        pending = null;
      }
    });
    return list.sort(function (a, b) {
      return b.height - a.height;
    });
  }
  function nativeUrl(url) {
    // FlixCloud v7 uses PNG-wrapped, XOR-scrambled segments and a custom JS loader.
    // An HLS extension alone does not make those playlists playable in the SDK.
    return validUrl(url) && !/\/_v7\//i.test(url);
  }
  async function validatedStreams(candidate) {
    if (!nativeUrl(candidate.url)) return [];
    var res = await request(candidate.url, candidate.headers),
      playlist = body(res);
    if (!/^\s*#EXTM3U/.test(playlist)) return [];
    var base = res.finalUrl || res.url || candidate.url,
      choices = variants(playlist, base);
    var externalAudio = /#EXT-X-MEDIA:.*TYPE=AUDIO.*URI=/i.test(playlist);
    if (!choices.length && !/#EXTINF:|#EXT-X-PART:/.test(playlist)) return [];
    if (!choices.length && /\/_v7\//i.test(playlist)) return [];
    // Keep the master when video variants depend on separate audio renditions.
    if (externalAudio) {
      var check = await request(
        choices.length ? choices[0].url : candidate.url,
        candidate.headers,
      );
      if (!/^\s*#EXTM3U/.test(body(check)) || /\/_v7\//i.test(body(check)))
        return [];
      choices = [{ url: candidate.url, height: 0 }];
    } else if (!choices.length)
      choices = [{ url: candidate.url, height: quality(candidate.quality) }];
    var results = await Promise.all(
      choices.map(async function (choice) {
        try {
          if (!nativeUrl(choice.url)) return null;
          // The SDK's StreamResult has no MIME-type override. Extensionless CDN
          // endpoints can serve HLS as application/octet-stream and fail player detection.
          if (!/\.m3u8(?:$|[?#])/i.test(choice.url)) return null;
          var content =
            choice.url === candidate.url || externalAudio
              ? playlist
              : body(await request(choice.url, candidate.headers));
          if (!/^\s*#EXTM3U/.test(content) || /\/_v7\//i.test(content))
            return null;
          if (!externalAudio && !/#EXTINF:|#EXT-X-PART:/.test(content))
            return null;
          return new StreamResult({
            url: choice.url,
            source:
              "LunarX " +
              candidate.provider +
              " " +
              candidate.lang.toUpperCase() +
              (choice.height ? " " + choice.height + "p" : " Auto"),
            headers: candidate.headers,
            subtitles: candidate.subtitles,
          });
        } catch (_) {
          return null;
        }
      }),
    );
    return results.filter(Boolean);
  }
  async function loadStreams(url, cb) {
    try {
      var parsed = parseUrl(url),
        id = await resolveId(parsed.id);
      if (parsed.season !== 1)
        throw new Error("Use the separate LunarX title for this anime season");
      var metadata = await info(id),
        list = await episodes(id, metadata);
      var number =
        parsed.episode ||
        (metadata.format === "MOVIE" && list.length === 1
          ? Number(list[0].number)
          : 0);
      if (!number) throw new Error("Select an episode before loading streams");
      var episode = list.filter(function (ep) {
        return Number(ep.number) === number;
      })[0];
      if (!episode) throw new Error("Episode " + number + " is unavailable");
      var providers = unique(
        (episode[parsed.lang + "Providers"] || [])
          .map(function (p) {
            return typeof p === "string" ? p : p.id;
          })
          .filter(Boolean),
        function (p) {
          return p;
        },
      );
      if (
        !providers.length &&
        episode[parsed.lang === "dub" ? "hasDub" : "hasSub"] !== true
      )
        throw new Error("This episode has no " + parsed.lang + " release");
      if (!providers.length) {
        var full = await optional(
          "/api/animes/v2/vermillion/episodes?id=" + id,
        );
        var detailed =
          full &&
          (full.data || []).filter(function (ep) {
            return Number(ep.number) === number;
          })[0];
        providers = detailed
          ? (detailed[parsed.lang + "Providers"] || [])
              .map(function (p) {
                return typeof p === "string" ? p : p.id;
              })
              .filter(Boolean)
          : [];
      }
      var requests = providers.map(function (provider) {
        return optional(providerPath(id, provider, number, parsed.lang, false));
      });
      // LunarX's own alternate-player API: use only native HLS, with no fabricated provider IDs.
      requests.push(
        optional(
          "/api/3rdprovider?anilist=" +
            id +
            "&episode=" +
            number +
            "&m3u8=true&a=" +
            (parsed.lang === "dub" ? "1" : "0") +
            "&audio=" +
            parsed.lang,
        ),
      );
      var responses = await Promise.all(requests),
        candidates = [],
        key = null;
      for (var p = 0; p < responses.length; p++) {
        var response = responses[p];
        if (!response) continue;
        var provider = providers[p] || "zen",
          data = response.data || response;
        if (provider === "zen") {
          data = response.stream_data || {};
          if (parsed.lang === "dub" && data.has_dub !== true) continue;
          data = {
            sources: data.m3u8_url ? [{ url: data.m3u8_url }] : [],
            subtitles: data.subtitles,
            headers: data.headers,
          };
        }
        var sources = data.sources || [],
          retried = false;
        // Some providers carry separate Japanese/English audio-video renditions.
        if (
          provider === "beep" &&
          Array.isArray(data.audio) &&
          data.audio.length
        ) {
          var audio = data.audio.filter(function (a) {
            return parsed.lang === "dub"
              ? /^(eng|en|english)$/i.test(a.language || a.name)
              : /^(jpn|ja|japanese)$/i.test(a.language || a.name);
          });
          if (audio.length) sources = audio;
        }
        for (var s = 0; s < sources.length; s++) {
          var src = sources[s];
          if (!src || !src.url || src.type === "embed") continue;
          var decoded;
          try {
            if (!validUrl(src.url) && !key)
              key = await streamKey(id, number, false);
            decoded = decodeUrl(src.url, key);
          } catch (_) {
            try {
              key = await streamKey(id, number, true);
              decoded = decodeUrl(src.url, key);
            } catch (_) {
              if (!retried && provider !== "zen") {
                retried = true;
                var fresh = await optional(
                  providerPath(id, provider, number, parsed.lang, true),
                );
                if (fresh) {
                  data = fresh.data || fresh;
                  sources = data.sources || [];
                  s = -1;
                }
              }
              continue;
            }
          }
          if (nativeUrl(decoded))
            candidates.push({
              url: decoded,
              provider: provider,
              lang: parsed.lang,
              quality: src.quality,
              headers: playbackHeaders(provider, data.headers),
              subtitles: subtitles(data.subtitles),
            });
        }
      }
      var batches = await Promise.all(
        unique(candidates, function (c) {
          return c.url;
        }).map(async function (candidate) {
          try {
            return await validatedStreams(candidate);
          } catch (_) {
            return [];
          }
        }),
      );
      var streams = unique([].concat.apply([], batches), function (stream) {
        return stream.url;
      });
      if (!streams.length)
        throw new Error(
          "No playable HLS source is currently available for episode " +
            number +
            " (" +
            parsed.lang +
            "). Unsupported player endpoints, failed playlists and custom scrambled segments are excluded.",
        );
      cb({ success: true, data: streams });
    } catch (e) {
      error(cb, "STREAM_ERROR", e);
    }
  }

  globalThis.getHome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
