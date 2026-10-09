(function () {
  "use strict";

  var DEFAULT_BASE = "https://new.katdrama.my";
  var base =
    typeof manifest !== "undefined" &&
    /^https?:\/\/(?!example\.com)/i.test(manifest.baseUrl || "")
      ? manifest.baseUrl.replace(/\/+$/, "")
      : DEFAULT_BASE;
  var UA =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36";
  var cache = Object.create(null);

  function text(value) {
    return String(value || "")
      .replace(/<[^>]*>/g, " ")
      .replace(/&#x([a-f\d]+);/gi, function (_, n) {
        return String.fromCharCode(parseInt(n, 16));
      })
      .replace(/&#(\d+);/g, function (_, n) {
        return String.fromCharCode(+n);
      })
      .replace(/&amp;/g, "&")
      .replace(/&quot;/g, '"')
      .replace(/&#0?39;|&apos;/g, "'")
      .replace(/&nbsp;/g, " ")
      .replace(/\s+/g, " ")
      .trim();
  }
  function absolute(value, referer) {
    try {
      var u = new URL(
        String(value || "")
          .replace(/&amp;/g, "&")
          .trim(),
        referer || base + "/",
      );
      return /^https?:$/.test(u.protocol) ? u.href : "";
    } catch (_) {
      return "";
    }
  }
  function unique(items, key) {
    var seen = Object.create(null);
    return items.filter(function (item) {
      var k = key(item);
      if (!k || seen[k]) return false;
      seen[k] = true;
      return true;
    });
  }
  function ignoredHost(url) {
    var host = new URL(url).hostname;
    return (
      /(?:^|\.)(?:gdflix\d*|gofile)\./i.test(host) || /^gd\.kmhd\./i.test(host)
    );
  }
  function quality(value) {
    var m = String(value || "").match(/(?:2160|1440|1080|720|576|480|360)p/i);
    return m ? parseInt(m[0], 10) : /\b4k\b/i.test(value) ? 2160 : 0;
  }
  function failure(cb, code, error) {
    cb({
      success: false,
      errorCode: code,
      message: String((error && error.message) || error),
    });
  }
  async function settledMap(items, limit, fn) {
    var index = 0,
      out = new Array(items.length);
    async function worker() {
      while (index < items.length) {
        var i = index++;
        try {
          out[i] = await fn(items[i], i);
        } catch (e) {
          out[i] = null;
          console.log("[KatDrama] " + String(e.message || e));
        }
      }
    }
    await Promise.all(
      Array.from({ length: Math.min(limit, items.length) }, worker),
    );
    return out.filter(function (v) {
      return v !== null && v !== undefined;
    });
  }
  function limiter(limit) {
    var active = 0,
      queue = [];
    function pump() {
      while (active < limit && queue.length) {
        active++;
        var task = queue.shift();
        (function (task) {
          Promise.resolve()
            .then(task.fn)
            .then(task.resolve, task.reject)
            .then(function () {
              active--;
              pump();
            });
        })(task);
      }
    }
    return function (fn) {
      return new Promise(function (resolve, reject) {
        queue.push({ fn: fn, resolve: resolve, reject: reject });
        pump();
      });
    };
  }

  // Cookies belong to one resolution session and their issuing host/path only.
  function Session() {
    this.cookies = [];
    this.deadline = Date.now() + 100000;
    this.visited = Object.create(null);
    this.requests = Object.create(null);
    this.revisions = Object.create(null);
    this.unlocks = Object.create(null);
    this.domains = Object.create(null);
    this.network = limiter(8);
    this.checkMedia = limiter(4);
    this.checks = Object.create(null);
  }
  Session.prototype.cookieHeader = function (url) {
    var u = new URL(url),
      now = Date.now();
    return this.cookies
      .filter(function (c) {
        return (
          c.expires > now &&
          (c.hostOnly
            ? u.hostname === c.domain
            : u.hostname === c.domain || u.hostname.endsWith("." + c.domain)) &&
          (u.pathname === c.path ||
            u.pathname.startsWith(
              c.path.endsWith("/") ? c.path : c.path + "/",
            )) &&
          (!c.secure || u.protocol === "https:")
        );
      })
      .map(function (c) {
        return c.name + "=" + c.value;
      })
      .join("; ");
  };
  Session.prototype.remember = function (url, headers) {
    var values = headers["set-cookie"] || [];
    if (!Array.isArray(values))
      values = String(values).split(/,(?=\s*[^;,=\s]+=)/);
    var u = new URL(url),
      self = this;
    values.forEach(function (raw) {
      var parts = raw.split(";"),
        pair = parts.shift().trim(),
        at = pair.indexOf("=");
      if (at < 1) return;
      var c = {
        name: pair.slice(0, at),
        value: pair.slice(at + 1),
        domain: u.hostname,
        hostOnly: true,
        path: u.pathname.slice(0, u.pathname.lastIndexOf("/") + 1) || "/",
        secure: false,
        expires: Infinity,
      };
      parts.forEach(function (part) {
        var p = part.trim().split("="),
          key = p.shift().toLowerCase(),
          value = p.join("=");
        if (key === "domain") {
          c.domain = value.replace(/^\./, "").toLowerCase();
          c.hostOnly = false;
        }
        if (key === "path") c.path = value;
        if (key === "secure") c.secure = true;
        if (key === "max-age") c.expires = Date.now() + Number(value) * 1000;
        if (key === "expires" && c.expires === Infinity)
          c.expires = Date.parse(value);
      });
      if (u.hostname !== c.domain && !u.hostname.endsWith("." + c.domain))
        return;
      self.cookies = self.cookies.filter(function (old) {
        return (
          old.name !== c.name || old.domain !== c.domain || old.path !== c.path
        );
      });
      self.cookies.push(c);
    });
  };
  async function request(url, session, options) {
    if (ignoredHost(url))
      throw new Error("Skipped host: " + new URL(url).hostname);
    options = options || {};
    // Share identical GETs only within this playback session. Include cookies,
    // referer and range headers so protected requests never share the wrong body.
    var headers = Object.assign(
      { "User-Agent": UA, Accept: "*/*" },
      options.headers || {},
    );
    var cookies = session.cookieHeader(url);
    if (cookies) headers.Cookie = cookies;
    var isGet = !options.method || options.method === "GET",
      origin = new URL(url).origin;
    // Download actions can change subsequent GET responses without changing a
    // cookie. Separate cached responses before, during and after those actions.
    if (!isGet)
      session.revisions[origin] = (session.revisions[origin] || 0) + 1;
    var key = JSON.stringify([
      url,
      session.revisions[origin] || 0,
      !!options.probe,
      Object.keys(headers)
        .sort()
        .map(function (k) {
          return [k, headers[k]];
        }),
    ]);
    if (isGet && session.requests[key]) return session.requests[key];
    var pending = session.network(function () {
      return requestOnce(url, session, options, headers);
    });
    if (isGet) {
      session.requests[key] = pending;
      pending.catch(function () {
        if (session.requests[key] === pending) delete session.requests[key];
      });
    } else {
      pending = pending.finally(function () {
        session.revisions[origin] = (session.revisions[origin] || 0) + 1;
      });
    }
    return pending;
  }
  async function requestOnce(url, session, options, headers) {
    options = options || {};
    if (Date.now() > session.deadline)
      throw new Error("Stream resolution timed out");
    var response,
      body,
      finalUrl = url,
      status,
      hs = {};
    if (typeof fetch === "function") {
      var timer;
      // AbortController is not present in every SDK runtime; still bound the promise.
      var controller =
        typeof AbortController !== "undefined" ? new AbortController() : null;
      var timeout = Math.min(18000, session.deadline - Date.now());
      try {
        return await Promise.race([
          (async function () {
            response = await fetch(url, {
              method: options.method || "GET",
              headers: headers,
              body: options.body,
              redirect: "manual",
              signal: controller ? controller.signal : undefined,
            });
            response.headers.forEach(function (v, k) {
              hs[k.toLowerCase()] = v;
            });
            if (response.headers.getSetCookie)
              hs["set-cookie"] = response.headers.getSetCookie();
            session.remember(url, hs);
            status = response.status;
            var complete = true;
            if (options.probe && response.body && response.body.getReader) {
              var reader = response.body.getReader(),
                bytes = [],
                size = 0;
              complete = false;
              try {
                while (size < 512) {
                  var chunk = await reader.read();
                  if (chunk.done) {
                    complete = true;
                    break;
                  }
                  var take = chunk.value.slice(0, 512 - size);
                  bytes.push.apply(bytes, Array.from(take));
                  size += take.length;
                }
              } finally {
                await reader.cancel();
              }
              body = String.fromCharCode.apply(null, bytes);
            } else body = await response.text();
            if (status === 206) {
              var range = /^bytes 0-(\d+)\/(\d+)$/.exec(
                hs["content-range"] || "",
              );
              complete = complete && !!range && +range[1] + 1 === +range[2];
            }
            return {
              status: status,
              headers: hs,
              body: body,
              complete: complete,
              url: response.url || url,
            };
          })(),
          new Promise(function (_, reject) {
            timer = setTimeout(function () {
              if (controller) controller.abort();
              reject(new Error("Request timed out: " + new URL(url).hostname));
            }, timeout);
          }),
        ]);
      } catch (error) {
        throw new Error(
          "Request failed at " +
            new URL(url).hostname +
            ": " +
            String(
              (error.cause && error.cause.message) || error.message || error,
            ),
        );
      } finally {
        clearTimeout(timer);
      }
    }
    // SDK bridge signature: http_post(url, headers, body), unlike fetch/axios.
    var bridgeTimer;
    try {
      response = await Promise.race([
        options.method === "POST"
          ? http_post(url, headers, options.body || "")
          : http_get(url, headers),
        new Promise(function (_, reject) {
          bridgeTimer = setTimeout(
            function () {
              reject(new Error("Request timed out: " + new URL(url).hostname));
            },
            Math.min(18000, session.deadline - Date.now()),
          );
        }),
      ]);
    } finally {
      clearTimeout(bridgeTimer);
    }
    for (var key in response.headers || {})
      hs[key.toLowerCase()] = response.headers[key];
    session.remember(url, hs);
    return {
      status: response.status || response.statusCode,
      headers: hs,
      body:
        typeof response.body === "string"
          ? response.body
          : JSON.stringify(response.body),
      url: response.finalUrl || response.url || finalUrl,
    };
  }
  async function follow(url, session, options) {
    options = Object.assign({}, options || {});
    var seen = Object.create(null);
    for (var i = 0; i < 10; i++) {
      if (seen[url])
        throw new Error("Redirect loop at " + new URL(url).hostname);
      seen[url] = true;
      var res = await request(url, session, options);
      if (ignoredHost(res.url))
        throw new Error("Skipped host: " + new URL(res.url).hostname);
      if (res.status >= 300 && res.status < 400 && res.headers.location) {
        var next = absolute(res.headers.location, url);
        if (!next) throw new Error("Invalid redirect");
        if (new URL(next).origin !== new URL(url).origin) {
          options.headers = Object.assign({}, options.headers || {});
          delete options.headers.Cookie;
          delete options.headers.Authorization;
          delete options.headers.Origin;
        }
        if (
          res.status === 303 ||
          (options.method === "POST" &&
            (res.status === 301 || res.status === 302))
        ) {
          options.method = "GET";
          delete options.body;
        }
        options.headers = Object.assign({}, options.headers || {}, {
          Referer: url,
        });
        url = next;
        continue;
      }
      if (res.status < 200 || res.status >= 400)
        throw new Error("HTTP " + res.status + " at " + new URL(url).hostname);
      return res;
    }
    throw new Error("Too many redirects");
  }

  // Svelte's __data.json is newline-delimited devalue tables, including deferred chunks.
  // Decode references instead of executing remote scripts (which also contain adverts).
  function unflatten(table) {
    var memo = Object.create(null);
    function read(index) {
      if (index === -1 || index === -2) return undefined;
      if (index === -3) return NaN;
      if (index === -4) return Infinity;
      if (index === -5) return -Infinity;
      if (index === -6) return -0;
      if (index < 0 || index >= table.length)
        throw new Error("Invalid Svelte reference");
      if (Object.prototype.hasOwnProperty.call(memo, index)) return memo[index];
      var raw = table[index];
      if (raw === null || typeof raw !== "object") return raw;
      if (Array.isArray(raw)) {
        if (raw[0] === "Promise") return { deferredId: table[raw[1]] };
        if (raw[0] === "Date") return raw[1];
        var array = [];
        memo[index] = array;
        raw.forEach(function (ref) {
          array.push(read(ref));
        });
        return array;
      }
      var obj = Object.create(null);
      memo[index] = obj;
      Object.keys(raw).forEach(function (key) {
        obj[key] = read(raw[key]);
      });
      return obj;
    }
    return read(0);
  }
  // A small data-literal parser for the HTML fallback. No eval/Function on site content.
  function literal(source, start) {
    var pos = start || 0;
    function skip() {
      while (/\s/.test(source[pos] || "") && pos < source.length) pos++;
    }
    function string() {
      var quote = source[pos++],
        out = "";
      while (pos < source.length) {
        var c = source[pos++];
        if (c === quote) return out;
        if (c === "\\") {
          c = source[pos++];
          if (c === "u" || c === "x") {
            var len = c === "u" ? 4 : 2;
            out += String.fromCharCode(
              parseInt(source.slice(pos, pos + len), 16),
            );
            pos += len;
          } else out += { n: "\n", r: "\r", t: "\t", b: "\b", f: "\f" }[c] || c;
        } else out += c;
      }
      throw new Error("Unterminated data string");
    }
    function value(depth) {
      if (depth > 80) throw new Error("Data nesting too deep");
      skip();
      var c = source[pos];
      if (c === '"' || c === "'") return string();
      if (c === "{" || c === "[") {
        var object = c === "{",
          result = object ? Object.create(null) : [],
          end = object ? "}" : "]";
        pos++;
        skip();
        while (source[pos] !== end) {
          if (object) {
            var isQuoted = source[pos] === '"' || source[pos] === "'";
            var key =
              source[pos] === '"' || source[pos] === "'"
                ? string()
                : (source.slice(pos).match(/^[\w$]+/) || [""])[0];
            if (!key) throw new Error("Invalid data key");
            if (!isQuoted) pos += key.length;
            skip();
            if (source[pos++] !== ":") throw new Error("Missing data colon");
            result[key] = value(depth + 1);
          } else result.push(value(depth + 1));
          skip();
          if (source[pos] === end) break;
          if (source[pos++] !== ",") throw new Error("Invalid data delimiter");
          skip();
        }
        pos++;
        return result;
      }
      var atom = source
        .slice(pos)
        .match(
          /^(?:true|false|null|undefined|void\s+0|-?\d+(?:\.\d+)?(?:e[+-]?\d+)?|__sveltekit_[\w]+\.defer\(\d+\))/i,
        );
      if (!atom) throw new Error("Unsupported data literal");
      pos += atom[0].length;
      if (/\.defer/.test(atom[0]))
        return { deferredId: Number(atom[0].match(/\((\d+)\)/)[1]) };
      if (/void|undefined/.test(atom[0])) return undefined;
      return JSON.parse(atom[0]);
    }
    return value(0);
  }
  function parseData(body) {
    var nodes = [],
      chunks = [];
    if (/^\s*\{/.test(body)) {
      body
        .trim()
        .split(/\r?\n/)
        .forEach(function (line) {
          var entry = JSON.parse(line);
          if (entry.type === "redirect")
            throw new Error("Svelte redirect: " + entry.location);
          if (entry.type === "data")
            (entry.nodes || []).forEach(function (node) {
              if (node && node.data) nodes.push(unflatten(node.data));
            });
          if (entry.type === "chunk" && entry.data)
            chunks.push(unflatten(entry.data));
        });
    } else {
      var initial = /const data\s*=\s*/.exec(body);
      if (initial)
        nodes = literal(body, initial.index + initial[0].length).map(
          function (node) {
            return node.data;
          },
        );
      var rx = /__sveltekit_[\w]+\.resolve\(/g,
        m;
      while ((m = rx.exec(body))) {
        var chunk = literal(body, rx.lastIndex);
        if (chunk.error) throw new Error("Svelte data error");
        chunks.push(chunk.data);
      }
    }
    if (!nodes.length && !chunks.length)
      throw new Error("No Svelte data found");
    return { nodes: nodes, chunks: chunks };
  }
  function dataUrl(url) {
    var u = new URL(url);
    u.pathname = u.pathname.replace(/\/$/, "") + "/__data.json";
    return u.href;
  }
  async function pageData(url, session, cached) {
    if (cached && cache[url] && Date.now() - cache[url].time < 60000)
      return cache[url].value;
    var result;
    try {
      result = parseData((await follow(dataUrl(url), session)).body);
    } catch (_) {
      result = parseData((await follow(url, session)).body);
    }
    if (cached) cache[url] = { value: result, time: Date.now() };
    return result;
  }
  function unwrap(obj) {
    return obj && obj.success === true ? obj.data : obj;
  }
  function catalogue(data) {
    var values = data.chunks.concat(data.nodes).map(unwrap);
    for (var i = 0; i < values.length; i++)
      if (values[i] && Array.isArray(values[i].items)) return values[i].items;
    throw new Error("Catalogue data is missing");
  }
  function typeOf(title, categories) {
    if (
      /\bfull movie\b/i.test(title) ||
      (categories || []).indexOf("movie") !== -1
    )
      return "movie";
    if (/anime/i.test(title)) return "anime";
    return "series";
  }
  function item(row) {
    var title = text(row.post_title),
      y = title.match(/\b(19\d{2}|20\d{2})\b/);
    return new MultimediaItem({
      title: title,
      url: absolute(row.slug || "post/" + row.id, base + "/"),
      posterUrl: row.thumbnail_image || "",
      type: typeOf(title, row.categories),
      year: y ? +y[1] : undefined,
      genres: (row.categories || []).map(function (x) {
        return x.replace(/-/g, " ");
      }),
      headers: { Referer: base + "/" },
    });
  }
  async function getHome(cb) {
    try {
      var session = new Session(),
        home = catalogue(await pageData(base + "/", session, true));
      var sections = [
        ["Korean Drama in Hindi", "korean-drama-in-hindi"],
        ["Chinese Drama", "chinese-drama-in-hindi"],
        ["Movies", "movie"],
      ];
      var data = {
        Trending: home.slice(0, 6).map(item),
        "Latest Updates": home.map(item),
      };
      var rows = await settledMap(sections, 3, async function (section) {
        return {
          name: section[0],
          items: catalogue(
            await pageData(base + "/category/" + section[1], session, true),
          ).map(item),
        };
      });
      rows.forEach(function (row) {
        if (row.items.length) data[row.name] = row.items;
      });
      cb({ success: true, data: data });
    } catch (e) {
      failure(cb, "HOME_ERROR", e);
    }
  }
  async function search(query, cb) {
    try {
      var q = String(query || "").trim();
      if (!q) {
        cb({ success: true, data: [] });
        return;
      }
      cb({
        success: true,
        data: catalogue(
          await pageData(
            base + "/?q=" + encodeURIComponent(q),
            new Session(),
            true,
          ),
        ).map(item),
      });
    } catch (e) {
      failure(cb, "SEARCH_ERROR", e);
    }
  }
  function anchors(html, url) {
    var out = [],
      rx = /<a\b([^>]*)>([\s\S]*?)<\/a>/gi,
      m;
    html = html.replace(/<!--[\s\S]*?-->/g, "");
    while ((m = rx.exec(html))) {
      var href = m[1].match(/\bhref\s*=\s*["']([^"']+)["']/i);
      if (href)
        out.push({
          url: absolute(href[1], url),
          label: text(m[2]),
          attrs: m[1],
          offset: m.index,
        });
    }
    return out.filter(function (a) {
      return a.url;
    });
  }
  function postDetails(data) {
    var post = {};
    data.nodes.forEach(function (node) {
      if (node && node.post_meta) Object.assign(post, unwrap(node.post_meta));
    });
    data.chunks.forEach(function (chunk) {
      var v = unwrap(chunk);
      if (v && v.post_content) Object.assign(post, v);
    });
    if (!post.post_content)
      throw new Error("Post is unavailable or has no content");
    return post;
  }
  function episodeNumber(name, defaultSeason) {
    var n = String(name || ""),
      s = n.match(/\bS(?:eason[ ._-]*)?(\d+)/i),
      e = n.match(/E(?:p(?:isode)?[ ._-]*)?(\d+)/i);
    return { season: s ? +s[1] : defaultSeason || 1, episode: e ? +e[1] : 0 };
  }
  function payload(url, links, season, episode) {
    return JSON.stringify({
      sourceUrl: url,
      links: links,
      season: season,
      episode: episode,
    });
  }
  function streamInput(input) {
    if (input && typeof input === "object") return input;
    var raw = String(input || "").trim();
    for (var i = 0; i < 5; i++) {
      // CLI single quotes preserve backslashes copied from an escaped SDK URL.
      // Prefer normal JSON first so valid escapes inside values remain intact.
      try {
        var parsed = JSON.parse(raw);
        if (typeof parsed !== "string") return parsed;
        raw = parsed.trim();
        continue;
      } catch (_) {}
      if (/^https?:\/\//i.test(raw)) return raw;
      if (!/^[\[{]/.test(raw))
        throw new Error(
          "Invalid stream input: expected an HTTP URL or JSON payload",
        );
      var decoded = raw.replace(/\\([\\"])/g, "$1");
      if (decoded === raw) break;
      raw = decoded;
    }
    throw new Error("Invalid JSON stream payload");
  }
  function lockedTarget(url) {
    var u = new URL(url),
      encoded = u.searchParams.get("redirect");
    if (!encoded) throw new Error("Locked link is missing its redirect");
    var path;
    try {
      encoded = encoded
        .replace(/ /g, "+")
        .replace(/-/g, "+")
        .replace(/_/g, "/");
      while (encoded.length % 4) encoded += "=";
      path = atob(encoded);
    } catch (_) {
      throw new Error("Invalid locked-link redirect");
    }
    var target = absolute(path, u.origin + "/");
    if (
      !/^\/(?!\/)/.test(path) ||
      !target ||
      new URL(target).origin !== u.origin ||
      !/^\/(?:file\/[^/]+|play)$/.test(new URL(target).pathname)
    )
      throw new Error("Invalid locked-link file target");
    return target;
  }
  function packInfo(data) {
    return data.chunks.map(unwrap).find(function (v) {
      return v && v.info;
    });
  }
  async function load(url, cb) {
    try {
      url = absolute(url);
      if (!url) throw new Error("Invalid post URL");
      var session = new Session(),
        post = postDetails(await pageData(url, session, true));
      var title = text(
          post.post_title || url.split("/").pop().replace(/-/g, " "),
        ),
        content = post.post_content;
      var isMovie = typeOf(title) === "movie",
        defaultSeason = episodeNumber(title).season,
        episodes = Object.create(null);
      var links = anchors(content, url).filter(function (a) {
        return /\/pack\/|\/file\/|\/play\?|hubcloud|gdflix|katdrive|streamtape|hglink|\.m3u8|\.mp4/i.test(
          a.url,
        );
      });
      function add(name, link, q) {
        var n = episodeNumber(name, defaultSeason);
        if (!n.episode) return;
        var key = n.season + ":" + n.episode;
        if (!episodes[key])
          episodes[key] = { season: n.season, episode: n.episode, links: [] };
        episodes[key].links.push({ url: link, quality: q || quality(name) });
      }
      if (!isMovie) {
        await settledMap(
          links.filter(function (l) {
            return /\/pack\/|\/play\?/.test(l.url);
          }),
          4,
          async function (link) {
            var info = packInfo(await pageData(link.url, session, true));
            if (!info) throw new Error("No episodes in " + link.url);
            Object.keys(info.info).forEach(function (id) {
              var value = info.info[id];
              // Store the file page, then refresh its host IDs when playback is requested.
              add(
                value.name || id,
                new URL("/file/" + encodeURIComponent(id), link.url).href,
                quality(value.name) || quality(link.label),
              );
            });
          },
        );
        links
          .filter(function (l) {
            return /\/file\//.test(l.url) && !/\bpack\b|\bzip\b/i.test(l.label);
          })
          .forEach(function (l) {
            var near = text(
              content.slice(Math.max(0, l.offset - 250), l.offset),
            );
            add(
              l.label.match(/\b(?:S\d+E\d+|Episode\s*\d+)\b/i) ? l.label : near,
              l.url,
              quality(l.label),
            );
          });
      }
      var eps = Object.keys(episodes)
        .map(function (key) {
          return episodes[key];
        })
        .sort(function (a, b) {
          return a.season - b.season || a.episode - b.episode;
        });
      var movieLinks = links
        .filter(function (l) {
          return !/\/pack\//.test(l.url) && !/\bzip\b/i.test(l.label);
        })
        .map(function (l) {
          return { url: l.url, quality: quality(l.label) };
        });
      if (!isMovie && !eps.length)
        throw new Error(
          "No individual episodes found; season ZIP archives cannot be played",
        );
      if (isMovie && !movieLinks.length)
        throw new Error("No movie links found");
      var year = title.match(/\b(19\d{2}|20\d{2})\b/),
        score = text(content).match(/IMDb Rating:\s*(\d+(?:\.\d+)?)/i);
      var genres = text(content).match(
        /Genres:\s*(.*?)\s*(?:Quality|Language):/i,
      );
      var cast = text(content).match(/Stars:\s*(.*?)\s*Genres:/i);
      var story = content.match(
        /(?:Storyline|Story Line|Plot):[\s\S]*?<\/h\d>([\s\S]*?)(?:<h[1-6]\b|$)/i,
      );
      var description = story ? text(story[1]) : "";
      var poster =
        post.thumbnail_image ||
        (content.match(/<img[^>]+src=["']([^"']+)/i) || [])[1] ||
        "";
      cb({
        success: true,
        data: new MultimediaItem({
          title: title,
          url: url,
          posterUrl: poster,
          bannerUrl: poster,
          type: isMovie ? "movie" : typeOf(title),
          description: description,
          year: year ? +year[1] : undefined,
          score: score ? +score[1] : undefined,
          genres: genres ? genres[1].split(/,\s*/) : [],
          cast: cast
            ? cast[1].split(/,\s*/).map(function (name) {
                return new Actor({ name: name });
              })
            : [],
          status: /all episodes|complete|full movie/i.test(title)
            ? "completed"
            : "ongoing",
          headers: { Referer: url },
          episodes: isMovie
            ? [
                new Episode({
                  name: "Movie",
                  season: 1,
                  episode: 1,
                  url: payload(url, movieLinks, 1, 1),
                  posterUrl: poster,
                }),
              ]
            : eps.map(function (ep) {
                return new Episode({
                  name: "Episode " + ep.episode,
                  season: ep.season,
                  episode: ep.episode,
                  posterUrl: poster,
                  url: payload(
                    url,
                    unique(ep.links, function (l) {
                      return l.url;
                    }),
                    ep.season,
                    ep.episode,
                  ),
                  headers: { Referer: url },
                });
              }),
        }),
      });
    } catch (e) {
      failure(cb, "LOAD_ERROR", e);
    }
  }

  async function unlockFile(url, session) {
    if (session.cookieHeader(url).indexOf("unlocked=true") !== -1) return;
    var origin = new URL(url).origin;
    // All file qualities use the same unlock cookie. Avoid simultaneous POSTs
    // which can race when the server updates that cookie.
    if (!session.unlocks[origin]) {
      session.unlocks[origin] = unlockOnce(url, session);
      session.unlocks[origin].catch(function () {
        delete session.unlocks[origin];
      });
    }
    await session.unlocks[origin];
    if (!session.cookieHeader(url))
      throw new Error("Unlock did not issue a session cookie");
  }
  async function unlockOnce(url, session) {
    var u = new URL(url),
      form =
        u.origin +
        "/locked?/unlock&redirect=" +
        encodeURIComponent(btoa(u.pathname));
    var res = await request(form, session, {
      method: "POST",
      body: "",
      headers: {
        Origin: u.origin,
        Referer: u.origin + "/locked",
        "Content-Type": "application/x-www-form-urlencoded",
        "x-sveltekit-action": "true",
      },
    });
    if (res.status >= 400) throw new Error("Unlock failed: HTTP " + res.status);
    // The action returns a JSON redirect and Set-Cookie; do not invent the cookie.
    if (!session.cookieHeader(url))
      throw new Error("Unlock did not issue a session cookie");
  }
  async function fileHosts(url, session) {
    await unlockFile(url, session);
    var data = await pageData(url, session, false);
    var info = data.chunks.find(function (v) {
      return v && v.val && v.links;
    });
    if (!info || !info.val.upload_links)
      throw new Error("File hosts are unavailable");
    if (/\bzip\b/i.test(info.val.name)) return [];
    // Streamwish supplied the verified HLS playlists. Ignore download mirrors
    // and Streamtape here so their challenges, redirects and timeouts add no work.
    var hosts = Object.keys(info.val.upload_links)
      .filter(function (key) {
        return /^streamwish(?:_res)?$/i.test(key);
      })
      .map(function (key) {
        var id = info.val.upload_links[key],
          config = info.links[key];
        if (
          !id ||
          /^(?:none|null|undefined|false)$/i.test(String(id)) ||
          !config ||
          !config.link
        )
          return null;
        return {
          url: absolute(/^https?:\/\//.test(id) ? id : config.link + id, url),
          quality: quality(info.val.name),
          source: key.replace(/_res$/, ""),
        };
      })
      .filter(Boolean);
    if (!hosts.length) throw new Error("This file has no Streamwish HLS host");
    return hosts;
  }
  async function refreshHost(entry, url, session) {
    if (/^stream/.test(entry.source)) {
      try {
        var hostKey = entry.source + "_res",
          id = decodeURIComponent(new URL(url).pathname.split("/").pop());
        var touch = await follow(
          new URL(
            "/api/touchme/" + encodeURIComponent(id) + "?c=" + hostKey,
            url,
          ).href,
          session,
          {
            method: "POST",
            body: "",
            headers: { Origin: new URL(url).origin, Referer: url },
          },
        );
        var refreshed = JSON.parse(touch.body);
        if (refreshed.status === "Done" && refreshed.linkId)
          entry.url = absolute(refreshed.linkId, url);
      } catch (_) {} // Existing IDs are still useful when this optional API is unavailable.
    }
    return entry;
  }
  function directUrl(url) {
    var u = new URL(url);
    return (
      /\.(?:m3u8|mp4|mkv|webm|m4v|mov|mpd)(?:$|\?)/i.test(url) ||
      /\.r2\.dev$|\.r2\.cloudflarestorage\.com$/.test(u.hostname) ||
      /\/api\/file\//.test(u.pathname) ||
      /\/get_video$/.test(u.pathname)
    );
  }
  function label(url) {
    var host = new URL(url).hostname;
    if (/streamtape|tapecontent/.test(host)) return "Streamtape";
    if (/katdrive\./.test(host)) return "KatDrive";
    if (/hubcloud|cocktail\.beer/.test(host)) return "HubCloud";
    if (/gdflix|kmhd|indexserver/.test(host)) return "GDFlix";
    if (/pixeldrain/.test(host)) return "Pixeldrain";
    if (/vibuxer|hglink|streamwish|wish|huntrexus|auroravantage/.test(host))
      return "Streamwish";
    return host;
  }
  function stream(url, referer, q, source) {
    var upstream = referer ? label(referer) : "";
    return {
      url: url,
      source:
        (source ||
          (/^(?:GDFlix|HubCloud|KatDrive|Streamwish)$/.test(upstream)
            ? upstream
            : label(url))) + (q ? " [" + q + "p]" : ""),
      headers: { Referer: referer, "User-Agent": UA },
    };
  }
  function quoted(value) {
    return literal(value, 0);
  }
  // Decode Dean Edwards packed players without executing their payload.
  function unpack(body) {
    var rx =
        /}\s*\(\s*('(?:\\.|[^'\\])*'|"(?:\\.|[^"\\])*")\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*('(?:\\.|[^'\\])*'|"(?:\\.|[^"\\])*")\.split\(['"]\|['"]\)/g,
      m,
      result = body;
    while ((m = rx.exec(body))) {
      var radix = +m[2],
        count = +m[3],
        payloadText = quoted(m[1]),
        words = quoted(m[4]).split("|");
      if (radix < 2 || radix > 62 || count > 10000) continue;
      var alphabet =
        "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      function key(n) {
        var out = "";
        do {
          out = alphabet[n % radix] + out;
          n = Math.floor(n / radix);
        } while (n);
        return out;
      }
      // Replace in one pass, so replacements cannot become other dictionary keys.
      var dictionary = Object.create(null);
      for (var i = 0; i < count; i++)
        if (words[i]) dictionary[key(i)] = words[i];
      result +=
        "\n" +
        payloadText.replace(/\b\w+\b/g, function (token) {
          return dictionary[token] || token;
        });
    }
    return result;
  }
  function playerMedia(body, url, q) {
    body = unpack(body);
    var found = [],
      rx = /(?:file|hls\d*|src)\s*["']?\s*[:=]\s*["']([^"']+)["']/gi,
      m;
    while ((m = rx.exec(body))) {
      var u = absolute(m[1].replace(/\\\//g, "/"), url);
      if (u && directUrl(u) && !/\.(?:jpg|vtt|png)(?:\?|$)/i.test(u))
        found.push(stream(u, url, q));
    }
    return unique(found, function (s) {
      return s.url;
    });
  }
  function tapeMedia(body, url, q) {
    // The final assignment supersedes decoy DOM tokens. Only interpret string
    // concatenation and substring operations; never execute the page's scripts.
    var rx =
        /(?:getElementById\(['"](?:robotlink|botlink|ideoolink)['"]\)\.innerHTML)\s*=\s*([^;]+);/g,
      m,
      candidates = [];
    while ((m = rx.exec(body))) {
      var expression = m[1],
        parts =
          expression.match(
            /(['"])(?:\\.|(?!\1)[^\\])*\1(?:\s*\))?(?:\s*\.substring\(\d+(?:\s*,\s*\d+)?\))*/g,
          ) || [],
        value = "";
      parts.forEach(function (part) {
        var str = part.match(/^(['"])(?:\\.|(?!\1)[^\\])*\1/)[0],
          v = quoted(str),
          sub = /\.substring\((\d+)(?:\s*,\s*(\d+))?\)/g,
          s;
        while ((s = sub.exec(part)))
          v = v.substring(+s[1], s[2] === undefined ? undefined : +s[2]);
        value += v;
      });
      var candidate = absolute(value, url);
      if (candidate && /\/get_video\?id=/.test(candidate))
        candidates.push(candidate + "&stream=1");
    }
    return candidates.length
      ? [stream(candidates[candidates.length - 1], url, q, "Streamtape")]
      : [];
  }

  // The redirector changes domains through RC4-encrypted string tables. Interpret
  // its domain expressions and rotation, rather than hardcoding the destination.
  function arithmetic(source) {
    var tokens = source.match(/0x[\da-f]+|\d+(?:\.\d+)?|[()+*\/-]/gi) || [],
      pos = 0;
    if (tokens.join("") !== source.replace(/\s/g, ""))
      throw new Error("Unsupported arithmetic");
    function atom() {
      var t = tokens[pos++];
      if (t === "+") return atom();
      if (t === "-") return -atom();
      if (t === "(") {
        var v = sum();
        if (tokens[pos++] !== ")") throw new Error("Arithmetic delimiter");
        return v;
      }
      if (!t || !/^(?:0x|\d)/.test(t)) throw new Error("Arithmetic token");
      return Number(t);
    }
    function product() {
      var v = atom();
      while (tokens[pos] === "*" || tokens[pos] === "/") {
        var op = tokens[pos++],
          n = atom();
        v = op === "*" ? v * n : v / n;
      }
      return v;
    }
    function sum() {
      var v = product();
      while (tokens[pos] === "+" || tokens[pos] === "-") {
        var op = tokens[pos++],
          n = product();
        v = op === "+" ? v + n : v - n;
      }
      return v;
    }
    var result = sum();
    if (pos !== tokens.length) throw new Error("Arithmetic tail");
    return result;
  }
  function rc4(cipher, key) {
    var alphabet =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+/",
      normal =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var binary = atob(
      cipher.replace(/[a-zA-Z\d+/]/g, function (c) {
        return normal[alphabet.indexOf(c)];
      }),
    );
    var encoded = "";
    for (var b = 0; b < binary.length; b++)
      encoded += "%" + ("0" + binary.charCodeAt(b).toString(16)).slice(-2);
    binary = decodeURIComponent(encoded);
    var state = [],
      j = 0,
      out = "",
      i,
      swap;
    for (i = 0; i < 256; i++) state[i] = i;
    for (i = 0; i < 256; i++) {
      j = (j + state[i] + key.charCodeAt(i % key.length)) % 256;
      swap = state[i];
      state[i] = state[j];
      state[j] = swap;
    }
    i = 0;
    j = 0;
    for (b = 0; b < binary.length; b++) {
      i = (i + 1) % 256;
      j = (j + state[i]) % 256;
      swap = state[i];
      state[i] = state[j];
      state[j] = swap;
      out += String.fromCharCode(
        binary.charCodeAt(b) ^ state[(state[i] + state[j]) % 256],
      );
    }
    return out;
  }
  function redirectDomains(js, url) {
    var tables =
        /(?:const|var|let)\s+\w+\s*=\s*(\[(?:\s*['"][A-Za-z\d+/=]+['"]\s*,?){20,}\])/g,
      tableMatch,
      table = [];
    while ((tableMatch = tables.exec(js))) {
      var candidate = literal(tableMatch[1]);
      if (candidate.length > table.length) table = candidate;
    }
    if (!table.length || table.length > 2000) return [];
    var wrappers = Object.create(null),
      rx =
        /function\s+(\w+)\(([^)]*)\)\s*\{\s*return\s+(\w+)\(([^,]+),\s*(\w+)\)\s*;?\s*\}/g,
      m;
    while ((m = rx.exec(js)))
      wrappers[m[1]] = {
        args: m[2].split(/\s*,\s*/),
        decoder: m[3],
        index: m[4],
        key: m[5],
      };
    var main = /\bmain\s*=\s*\[([\s\S]*?)\]\s*,\s*rules\s*=/.exec(js);
    var dmca = /\bdmca\s*=\s*\[([\s\S]*?)\]\s*,\s*main\s*=/.exec(js);
    var rules = /\brules\s*=\s*\[([\s\S]*?)\]\s*,\s*url\s*=/.exec(js);
    if (!main || !dmca || !rules) return [];
    // Commas inside call arguments do not delimit the domain array.
    function split(expr, delimiter) {
      var out = [],
        start = 0,
        depth = 0,
        quote = "";
      for (var p = 0; p < expr.length; p++) {
        var c = expr[p];
        if (quote) {
          if (c === "\\") p++;
          else if (c === quote) quote = "";
          continue;
        }
        if (c === '"' || c === "'") quote = c;
        else if (c === "(") depth++;
        else if (c === ")") depth--;
        else if (!depth && c === delimiter) {
          out.push(expr.slice(start, p).trim());
          start = p + 1;
        }
      }
      out.push(expr.slice(start).trim());
      return out;
    }
    var firstCall = main[1].match(/(\w+)\(/),
      wrapper = firstCall && wrappers[firstCall[1]];
    if (!wrapper) return [];
    var escaped = wrapper.decoder.replace(/\$/g, "\\$");
    var decoder = new RegExp(
      "function\\s+" +
        escaped +
        "\\((\\w+),[^)]*\\)\\s*\\{\\s*\\1\\s*=\\s*\\1\\s*-\\s*([^;]+);",
    ).exec(js);
    if (!decoder) return [];
    var offset = arithmetic(decoder[2]),
      decodedCache = Object.create(null);
    function domains(expr, rotation) {
      return split(expr, ",").map(function (entry) {
        return split(entry, "+")
          .map(function (part) {
            if (/^["']/.test(part)) return quoted(part);
            var call = /^(\w+)\((.*)\)$/.exec(part),
              w = call && wrappers[call[1]];
            if (!w || w.decoder !== wrapper.decoder)
              throw new Error("Unknown domain expression");
            var args = split(call[2], ","),
              env = Object.create(null);
            w.args.forEach(function (arg, i) {
              env[arg] = args[i];
            });
            var index =
              arithmetic(
                w.index.replace(/\b\w+\b/g, function (id) {
                  return env[id] === undefined ? id : env[id];
                }),
              ) - offset;
            if (index < 0 || index >= table.length)
              throw new Error("Domain index");
            var key = quoted(env[w.key]),
              ciphertext = table[(index + rotation) % table.length],
              k = ciphertext + "|" + key;
            if (!(k in decodedCache)) decodedCache[k] = rc4(ciphertext, key);
            return decodedCache[k];
          })
          .join("");
      });
    }
    for (var rotation = 0; rotation < table.length; rotation++) {
      try {
        var hosts = domains(main[1], rotation);
        if (
          !hosts.every(function (h) {
            return /^[a-z\d-]+(?:\.[a-z\d-]+)+$/.test(h);
          })
        )
          continue;
        var alternate = domains(dmca[1], rotation),
          from = domains(rules[1], rotation);
        if (
          !alternate.concat(from).every(function (h) {
            return /^[a-z\d-]+(?:\.[a-z\d-]+)+$/.test(h);
          })
        )
          continue;
        var u = new URL(url);
        return (from.indexOf(u.hostname) !== -1 ? hosts : alternate).map(
          function (h) {
            return "https://" + h + u.pathname + u.search;
          },
        );
      } catch (_) {}
    }
    return [];
  }

  async function resolve(url, session, q, referer, depth) {
    var candidates = await resolveOne(url, session, q, referer, depth);
    // Leaf extractors can start media checks while other mirrors still resolve.
    if (session.collect) candidates.forEach(session.collect);
    return candidates;
  }
  async function resolveOne(url, session, q, referer, depth) {
    if (!url || depth > 8 || Date.now() > session.deadline) return [];
    url = absolute(url, referer);
    if (!url || session.visited[url]) return [];
    session.visited[url] = true;
    var u = new URL(url),
      host = u.hostname;
    if (ignoredHost(url)) return [];
    if (/\.zip(?:\?|$)/i.test(url)) return [];
    if (/^links\.kmhd\./i.test(host) && /^\/locked$/.test(u.pathname)) {
      return resolve(lockedTarget(url), session, q, url, depth + 1);
    }
    if (directUrl(url)) return [stream(url, referer || u.origin + "/", q)];
    if (/^links\.kmhd\./i.test(host) && /^\/file\//.test(u.pathname)) {
      var hosts = await fileHosts(url, session);
      var results = await settledMap(hosts, 8, async function (entry) {
        await refreshHost(entry, url, session);
        return resolve(entry.url, session, entry.quality || q, url, depth + 1);
      });
      return [].concat.apply([], results);
    }
    if (/^links\.kmhd\./i.test(host) && /^\/play$/.test(u.pathname)) {
      var playlist = await pageData(url, session, false),
        info = packInfo(playlist);
      if (!info) throw new Error("Player has no files");
      var ids = Object.keys(info.info),
        chosen = ids.filter(function (id) {
          var n = episodeNumber(info.info[id].name);
          return n.episode === session.episode && n.season === session.season;
        });
      if (!chosen.length && ids.length === 1) chosen = ids;
      if (!chosen.length)
        throw new Error("Select an episode before resolving this playlist");
      var played = await settledMap(chosen, 2, function (id) {
        return resolve(
          new URL("/file/" + encodeURIComponent(id), url).href,
          session,
          quality(info.info[id].name) || q,
          url,
          depth + 1,
        );
      });
      return [].concat.apply([], played);
    }
    if (/pixeldrain\./i.test(host) && /^\/u\//.test(u.pathname)) {
      return [
        stream(
          u.origin + "/api/file/" + u.pathname.split("/").pop() + "?download",
          referer,
          q,
          "Pixeldrain",
        ),
      ];
    }
    if (/hbplay\.pages\.dev/.test(host)) {
      var target = u.searchParams.get("u");
      return target
        ? resolve(atob(target), session, q, referer, depth + 1)
        : [];
    }
    var res = await follow(url, session, {
      headers: { Referer: referer || u.origin + "/" },
    });
    url = res.url;
    u = new URL(url);
    host = u.hostname;
    if (directUrl(url)) return [stream(url, referer || u.origin + "/", q)];
    var body = res.body;
    if (/hubcloud\.|katdrive\./i.test(host)) q = q || quality(body);
    // HubCloud's PixelServer redirects through a worker to a JavaScript-only
    // button. The media URL is in the final page's query, not an HTML href.
    if (/^(?:www\.)?gamerxyt\.com$/i.test(host) && u.pathname === "/dl.php") {
      var target = absolute(u.searchParams.get("link"), url);
      if (!u.searchParams.get("link") || !target)
        throw new Error("HubCloud download page has no media target");
      return [stream(target, url, q, "HubCloud")];
    }
    if (/katdrive\./i.test(host)) {
      var downloadId = body.match(
        /<[^>]+\bid=["']down-id["'][^>]*>([\s\S]*?)<\/[^>]+>/i,
      );
      if (downloadId && /myDirectDownload\s*\(/.test(body)) {
        var ajax = await follow(
          u.origin + "/ajax.php?ajax=direct-download",
          session,
          {
            method: "POST",
            body: "id=" + encodeURIComponent(text(downloadId[1])),
            headers: {
              Referer: url,
              Origin: u.origin,
              "X-Requested-With": "XMLHttpRequest",
              "Content-Type":
                "application/x-www-form-urlencoded; charset=UTF-8",
            },
          },
        );
        var generated;
        try {
          generated = JSON.parse(ajax.body);
        } catch (_) {
          throw new Error("KatDrive returned an invalid download response");
        }
        if (String(generated.code) !== "200")
          throw new Error(
            "KatDrive code " +
              generated.code +
              ": " +
              text(
                generated.file ||
                  generated.message ||
                  "Download generation failed",
              ),
          );
        var file = /^https?:\/\//i.test(String(generated.file || ""))
          ? absolute(generated.file, url)
          : "";
        if (!file) throw new Error("KatDrive did not return a media URL");
        // These signed endpoints may have no extension. Probe them as media
        // instead of reading an entire movie while looking for HTML links.
        return [stream(file, url, q, "KatDrive")];
      }
    }
    if (/streamtape\.|strtape\.|streamta\.pe/i.test(host))
      return tapeMedia(body, url, q);
    var media = playerMedia(body, url, q);
    if (media.length) return media;
    if (
      /hglink\.|wish|vibuxer|streamhg/i.test(host) &&
      /src=["']\/main\.js/.test(body)
    ) {
      var script = (body.match(/src=["']([^"']*\/main\.js[^"']*)/) || [])[1];
      var redirectJs = await follow(absolute(script, url), session);
      var domainKey = JSON.stringify([redirectJs.url, u.hostname]);
      if (!session.domains[domainKey])
        session.domains[domainKey] = redirectDomains(redirectJs.body, url).map(
          function (dest) {
            return new URL(dest).origin;
          },
        );
      var destinations = session.domains[domainKey].map(function (origin) {
        return origin + u.pathname + u.search;
      });
      if (!destinations.length)
        throw new Error("Streamwish redirect format changed");
      // Try each live alias; a failed alias must not discard other sources.
      var redirected = await settledMap(destinations, 3, function (dest) {
        return resolve(dest, session, q, url, depth + 1);
      });
      return [].concat.apply([], redirected);
    }
    var next = anchors(body, url)
      .filter(function (a) {
        return (
          directUrl(a.url) ||
          /hubcloud\.php|gpdl\.|pixeldrain\.|indexserver\.|busycdn\.|\/cloud\/|\/download\//i.test(
            a.url,
          ) ||
          (/\b(?:download|direct|generate|fast cloud)\b/i.test(a.label) &&
            !/login|telegram|how to|report|account/i.test(a.label))
        );
      })
      .filter(function (a) {
        return !/imdb|facebook|t\.me|katworld|winexch|bonuscaf|goodpics/i.test(
          new URL(a.url).hostname,
        );
      });
    if (/hubcloud\./i.test(host)) {
      var generated = body.match(/\bvar\s+url\s*=\s*['"]([^'"]+)['"]/);
      if (generated) next.push({ url: absolute(generated[1], url) });
    }
    if (/fuckingfast\./i.test(host)) {
      var ff = body.match(/window\.open\(\s*['"]([^'"]+)['"]/);
      if (ff) next.push({ url: absolute(ff[1], url) });
    }
    // Send.cm / 1fichier / KatDrive use the ordinary download form.
    if (!next.length && /send\.cm|1fichier|katdrive/i.test(host)) {
      var form = body.match(/<form\b([^>]*)>([\s\S]*?)<\/form>/i);
      if (form) {
        var inputs = [],
          rx = /<input\b[^>]*>/gi,
          input;
        while ((input = rx.exec(form[2]))) {
          var name = input[0].match(/\bname=['"]([^'"]+)/i),
            value = input[0].match(/\bvalue=['"]([^'"]*)/i);
          if (name)
            inputs.push(
              encodeURIComponent(name[1]) +
                "=" +
                encodeURIComponent(value ? text(value[1]) : ""),
            );
        }
        var action = (form[1].match(/\baction=['"]([^'"]*)/i) || [])[1];
        var posted = await follow(absolute(action || url, url), session, {
          method: "POST",
          body: inputs.join("&"),
          headers: {
            Referer: url,
            Origin: u.origin,
            "Content-Type": "application/x-www-form-urlencoded",
          },
        });
        next = anchors(posted.body, posted.url).filter(function (a) {
          return /download|direct/i.test(a.label) || directUrl(a.url);
        });
        if (directUrl(posted.url)) return [stream(posted.url, url, q)];
      }
    }
    next = unique(next, function (a) {
      return a.url;
    }).slice(0, 10);
    if (!next.length) throw new Error("No playable links at " + host);
    var resolved = await settledMap(next, 3, function (a) {
      return resolve(a.url, session, q, url, depth + 1);
    });
    return [].concat.apply([], resolved);
  }

  async function verify(candidate, session) {
    candidate = Object.assign({}, candidate, {
      headers: Object.assign({}, candidate.headers),
    });
    var res = await follow(candidate.url, session, {
      probe: true,
      headers: Object.assign({}, candidate.headers, { Range: "bytes=0-511" }),
    });
    var body = res.body || "",
      type = String(res.headers["content-type"] || "").toLowerCase();
    if (
      /^\s*(?:<!doctype|<html|<head|<body|\{\s*"(?:error|message)")/i.test(
        body,
      ) ||
      /text\/html|application\/json/.test(type)
    )
      throw new Error(
        "Host returned an error page: " + new URL(candidate.url).hostname,
      );
    var hls = /^\s*#EXTM3U/.test(body),
      mpd = /<MPD[\s>]/.test(body);
    var mkv = body.slice(0, 4) === "\x1a\x45\xdf\xa3",
      mp4 = body.slice(4, 8) === "ftyp" || body.slice(4, 8) === "styp";
    if (
      !hls &&
      !mpd &&
      !mkv &&
      !mp4 &&
      !/^(?:video\/|audio\/)|mpegurl|dash\+xml|octet-stream/.test(type)
    )
      throw new Error(
        "Response is not media: " + new URL(candidate.url).hostname,
      );
    if (!body.length) throw new Error("Empty media response");
    // Check an HLS variant and its first segment too; an accessible master alone
    // does not prove the actual video CDN works.
    if (hls) {
      var manifestRes = res.complete
        ? res
        : await follow(res.url, session, { headers: candidate.headers });
      var manifestBody = manifestRes.body;
      for (var level = 0; level < 3; level++) {
        if (!/^\s*#EXTM3U/.test(manifestBody))
          throw new Error("Invalid HLS playlist");
        var variant = manifestBody.match(
          /#EXT-X-STREAM-INF:[^\r\n]*\r?\n([^#\r\n][^\r\n]*)/,
        );
        if (!variant) break;
        manifestRes = await follow(
          absolute(variant[1].trim(), manifestRes.url),
          session,
          { headers: candidate.headers },
        );
        manifestBody = manifestRes.body;
      }
      var segment = manifestBody.match(
        /#EXTINF:[^\r\n]*\r?\n([^#\r\n][^\r\n]*)/,
      );
      if (!segment) throw new Error("HLS playlist has no video segments");
      var segmentRes = await follow(
        absolute(segment[1].trim(), manifestRes.url),
        session,
        {
          probe: true,
          headers: Object.assign({}, candidate.headers, {
            Range: "bytes=0-511",
          }),
        },
      );
      if (
        !segmentRes.body ||
        /text\/html|application\/json/.test(
          String(segmentRes.headers["content-type"] || ""),
        ) ||
        /^\s*</.test(segmentRes.body)
      )
        throw new Error("HLS segment is unavailable");
    }
    candidate.url = res.url;
    var cookie = session.cookieHeader(candidate.url);
    if (cookie) candidate.headers.Cookie = cookie;
    return new StreamResult(candidate);
  }
  async function loadStreams(url, cb) {
    try {
      var session = new Session(),
        input = streamInput(url),
        data = input;
      if (Array.isArray(data)) data = { links: data };
      if (!data || !Array.isArray(data.links)) {
        if (typeof input !== "string")
          throw new Error("Invalid stream payload: links must be an array");
        input = absolute(input);
        if (!input) throw new Error("Invalid stream URL");
        if (new URL(input).origin === new URL(base).origin) {
          var detail;
          await load(input, function (res) {
            detail = res;
          });
          if (!detail.success) throw new Error(detail.message);
          if (detail.data.type !== "movie")
            throw new Error(
              "Choose an episode from load() before requesting streams",
            );
          data = JSON.parse(detail.data.episodes[0].url);
        } else if (/^\/play$/.test(new URL(input).pathname)) {
          // A playlist URL must be selected by episode, never concatenate every episode.
          throw new Error(
            "Choose an episode from load() before requesting playlist streams",
          );
        } else data = { sourceUrl: input, links: [{ url: input }] };
      }
      session.season = data.season;
      session.episode = data.episode;
      session.collect = function (candidate) {
        if (session.checks[candidate.url]) return;
        session.checks[candidate.url] = session
          .checkMedia(function () {
            return verify(candidate, session);
          })
          .catch(function (error) {
            console.log("[KatDrama] " + String(error.message || error));
            return null;
          });
      };
      var links = unique(
        data.links
          .filter(function (entry) {
            return (
              entry &&
              (typeof entry === "string" || typeof entry.url === "string")
            );
          })
          .sort(function (a, b) {
            return (b.quality || 0) - (a.quality || 0);
          }),
        function (entry) {
          return typeof entry === "string" ? entry : entry.url;
        },
      );
      await settledMap(links, 4, function (entry) {
        return resolve(
          typeof entry === "string" ? entry : entry.url,
          session,
          entry.quality || 0,
          data.sourceUrl || base + "/",
          0,
        );
      });
      var streams = (
        await Promise.all(
          Object.keys(session.checks).map(function (url) {
            return session.checks[url];
          }),
        )
      ).filter(Boolean);
      streams = unique(streams, function (s) {
        return s.url;
      });
      if (!streams.length)
        throw new Error(
          "No verified playable streams. Hosts may be unavailable, expired, or require a browser challenge.",
        );
      streams.sort(function (a, b) {
        return quality(b.source) - quality(a.source);
      });
      cb({ success: true, data: streams });
    } catch (e) {
      failure(cb, "STREAM_ERROR", e);
    }
  }

  globalThis.getHome = getHome;
  globalThis.loadHome = getHome;
  globalThis.loadhome = getHome;
  globalThis.search = search;
  globalThis.load = load;
  globalThis.loadStreams = loadStreams;
})();
