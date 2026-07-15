(function () {
  "use strict";
  const MIRRORS = "https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json";
  const CINEMETA = "https://v3-cinemeta.strem.io/meta";
  const defaults = { vegamovies: "https://vegamovies.mq", rogmovies: "https://rogmovies.vip" };
  const abs = (u, b) => { try { return new URL(u, b).href; } catch (_) { return u || ""; } };
  const root = u => { try { return new URL(u).origin; } catch (_) { return u; } };
  const clean = s => String(s || "").replace(/<[^>]+>/g, " ").replace(/&amp;/g, "&").replace(/&#8217;|&#39;/g, "'").replace(/&quot;/g, '"').replace(/\s+/g, " ").trim();
  const attr = (tag, key) => ((String(tag).match(new RegExp("\\b" + key + "\\s*=\\s*([\\\"'])(.*?)\\1", "i")) || [])[2] || "");
  const links = html => [...String(html).matchAll(/<a\b[^>]*>[\s\S]*?<\/a\s*>/gi)].map(m => ({ tag: m[0], href: attr(m[0], "href"), text: clean(m[0]) }));
  const title = s => clean(s).replace(/^Download\s+/i, "");
  const imageUrl = (tag, base) => { const src = attr(tag, "src"), lazy = attr(tag, "data-src") || attr(tag, "data-lazy-src") || attr(tag, "data-original"); return abs(lazy || (/^data:/i.test(src) ? "" : src), base); };
  const image = (html, base) => imageUrl((String(html).match(/<img\b[^>]*>/i) || [""])[0], base);
  async function http(u, o = {}) {
    const method = o.method || "GET", headers = o.headers || {};
    let raw;
    if (typeof http_parallel === "function") {
      const results = await http_parallel([{ method, url: u, headers }]);
      raw = results && results[0];
    } else if (method === "GET" && typeof http_get === "function") {
      raw = await http_get(u, headers);
    } else if (typeof fetch === "function") {
      return fetch(u, o);
    } else if (typeof axios !== "undefined" && axios) {
      const r = await axios({ url: u, method, headers, maxRedirects: o.redirect === "manual" ? 0 : 5, validateStatus: () => true });
      raw = { status: r.status, body: typeof r.data === "string" ? r.data : JSON.stringify(r.data), headers: r.headers };
    } else {
      throw new Error("No SkyStream HTTP bridge is available");
    }
    const status = Number(raw && (raw.status || raw.statusCode)) || 200;
    const body = raw && (raw.body !== undefined ? raw.body : raw.text) || "";
    const responseHeaders = raw && raw.headers || {};
    const header = name => responseHeaders[name] || responseHeaders[String(name).toLowerCase()] || responseHeaders[String(name).toUpperCase()] || null;
    return { ok: status >= 200 && status < 300, status, headers: { get: header }, text: async () => typeof body === "string" ? body : JSON.stringify(body), json: async () => typeof body === "string" ? JSON.parse(body) : body };
  }  const fetchText = async (u, o) => { const r = await http(u, o); if (!r.ok) throw Error("HTTP " + r.status); return r.text(); };
  const fetchJson = async u => { const r = await http(u); if (!r.ok) throw Error("HTTP " + r.status); return r.json(); };  const provider = () => /rog/i.test(manifest.providerId || manifest.baseUrl || "") ? "rogmovies" : "vegamovies";
  async function base() { const key = provider(); try { const urls = await fetchJson(MIRRORS); return (urls[key] || manifest.baseUrl || defaults[key]).replace(/\/$/, ""); } catch (_) { return (manifest.baseUrl || defaults[key]).replace(/\/$/, ""); } }
  const item = x => new MultimediaItem(x);
  function card(a, b) { const img = (a.tag.match(/<img\b[^>]*>/i) || [""])[0], t = title(attr(img, "alt") || a.text), u = abs(a.href, b); return t && u ? item({ title: t, url: u, posterUrl: imageUrl(img, b), type: "movie" }) : null; }
  const categories = key => key === "rogmovies" ? [["Home", "/page/1/"], ["Netflix", "/category/web-series/netflix/page/1/"], ["Disney Plus Hotstar", "/category/web-series/disney-plus-hotstar/page/1/"], ["Amazon Prime", "/category/web-series/amazon-prime-video/page/1/"], ["MX Original", "/category/web-series/mx-original/page/1/"]] : [["Home", "/page/1/"], ["Netflix", "/category/web-series/netflix/page/1/"], ["Disney Plus Hotstar", "/category/web-series/disney-plus-hotstar/page/1/"], ["Amazon Prime", "/category/web-series/amazon-prime-video/page/1/"], ["MX Original", "/category/web-series/mx-original/page/1/"], ["Anime Series", "/category/anime-series/page/1/"], ["Korean Series", "/category/korean-series/page/1/"]];
  async function getHome(cb) { try { const b = await base(), rows = await Promise.all(categories(provider()).map(async ([n, p]) => { try { const h = await fetchText(b + p); return [n, links(h).filter(a => /<img\b/i.test(a.tag)).map(a => card(a, b)).filter(Boolean)]; } catch (_) { return [n, []]; } })); const data = {}; rows.forEach(([n, v]) => { if (v.length) data[n === "Home" ? "Trending" : n] = v; }); cb({ success: true, data }); } catch (e) { cb({ success: false, errorCode: "HOME_ERROR", message: String(e) }); } }
  async function search(query, cb) { try { const b = await base(), r = await fetchJson(b + "/search.php?q=" + encodeURIComponent(query) + "&page=1"); cb({ success: true, data: (r.hits || []).map(x => x.document || x).map(d => item({ title: title(d.post_title), url: abs(d.permalink, b), posterUrl: abs(d.post_thumbnail, b), type: "movie" })) }); } catch (e) { cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e) }); } }
  async function meta(id, type) { if (!id) return null; try { return (await fetchJson(CINEMETA + "/" + type + "/" + id + ".json")).meta || null; } catch (_) { return null; } }
  async function movieSources(html, b) { const buttons = links(html).filter(a => /dwd-button/i.test(a.tag)); const pages = await Promise.all(buttons.map(a => fetchText(abs(a.href, b)).catch(() => ""))); return pages.map(h => links(h).find(a => /V-Cloud/i.test(a.text))?.href).filter(Boolean).map(u => abs(u, b)); }
  async function nexDriveEpisodes(html, m) {
    const directories = links(html).filter(a => /nexdrive\.fit/i.test(a.href)).map(a => a.href);
    if (!directories.length) return [];
    const pages = await Promise.all(directories.map(u => fetchText(u).catch(() => "")));
    const groups = {};
    pages.forEach(page => {
      const re = /<h[1-6]\b[^>]*>([\s\S]*?)<\/h[1-6]\s*>([\s\S]*?)(?=<h[1-6]\b|$)/gi;
      let match;
      while ((match = re.exec(page))) {
        const number = Number((clean(match[1]).match(/Episodes?\s*:?\s*(\d+)/i) || [])[1]);
        if (!number) continue;
        const sources = links(match[2]).filter(a => /vcloud|hubcloud/i.test(a.href)).map(a => a.href);
        if (sources.length) (groups[number] ||= []).push(...sources);
      }
    });
    return Object.entries(groups).sort((a, b) => Number(a[0]) - Number(b[0])).map(([number, sources]) => {
      const episode = Number(number), info = (m?.videos || []).find(v => v.season === 1 && v.episode === episode) || {};
      return new Episode({ name: info.name || info.title || "S01E" + String(episode).padStart(2, "0"), url: "vega-sources:" + btoa(JSON.stringify([...new Set(sources)])), season: 1, episode, posterUrl: info.thumbnail, description: info.overview });
    });
  }  async function episodes(html, b, m) { const fromNexDrive = await nexDriveEpisodes(html, m); if (fromNexDrive.length) return fromNexDrive; const groups = {}, re = /<h([35])\b[^>]*>([\s\S]*?)<\/h\1\s*>([\s\S]*?)(?=<h[35]\b|$)/gi; let x; while ((x = re.exec(html))) { const heading = clean(x[2]); if (!/(?:4K|[0-9]*0p)/i.test(heading) || /zip/i.test(heading)) continue; const season = Number((x[0].match(/(?:Season\s*|S)(\d+)/i) || [])[1] || 0), page = links(x[3]).find(a => /V-Cloud|Episode|Download|G-Direct/i.test(a.text))?.href; if (!page) continue; const h = await fetchText(abs(page, b)).catch(() => ""); links(h).filter(a => /vcloud/i.test(a.href)).forEach((a, i) => { const k = season + ":" + (i + 1); (groups[k] ||= []).push(abs(a.href, b)); }); } return Object.entries(groups).map(([k, v]) => { const [season, episode] = k.split(":").map(Number), info = (m?.videos || []).find(z => z.season === season && z.episode === episode) || {}; return new Episode({ name: info.name || info.title || "Episode " + episode, url: v[0], season, episode, posterUrl: info.thumbnail, description: info.overview }); }); }
  async function load(url, cb) { try { const h = await fetchText(url), imdb = links(h).find(a => /imdb/i.test(a.href))?.href || "", id = (imdb.match(/title\/(tt\d+)/i) || [])[1], type = /Series-(?:SYNOPSIS|PLOT)|Series\s+Info|Series\s+synopsis/i.test(h) ? "series" : "movie", m = await meta(id, type), description = clean((h.match(/<h3\b[^>]*>\s*<span[^>]*>\s*(?:SYNOPSIS|PLOT)[\s\S]*?<\/h3>\s*<[^>]+>([\s\S]*?)<\//i) || [])[1]); const data = { title: m?.name || title((h.match(/<title[^>]*>([\s\S]*?)<\/title>/i) || [])[1]), url, posterUrl: m?.poster || image((h.match(/<p\b[^>]*>[\s\S]*?<\/p>/i) || [h])[0], url), bannerUrl: m?.background, type, description: m?.description || description, tags: m?.genre || m?.genres || [], score: Number(m?.imdbRating) || undefined, year: Number(String(m?.year || "").match(/\d{4}/)?.[0]) || undefined, cast: (m?.cast || []).map(name => new Actor({ name })), syncData: id ? { imdb: id } : undefined }; if (type === "series") data.episodes = await episodes(h, root(url), m); else { const sources = await movieSources(h, root(url)); data.episodes = [new Episode({ name: "S01E01", url: "vega-s1e1:" + btoa(JSON.stringify(sources)), season: 1, episode: 1 })]; } cb({ success: true, data: item(data) }); } catch (e) { cb({ success: false, errorCode: "LOAD_ERROR", message: String(e) }); } }
  const quality = s => ((String(s).match(/(\d{3,4})p/i) || [])[1] || (/8k/i.test(s) ? "4320" : /4k/i.test(s) ? "2160" : /2k/i.test(s) ? "1440" : "Unknown")) + (/(\d{3,4})p/i.test(s) ? "p" : "");
  async function redirect(u) { let current = u; for (let i = 0; i < 7; i++) { try { const r = await http(current, { method: "HEAD", redirect: "manual" }), to = r.headers.get("location"); if (!to) break; current = abs(to, current); } catch (_) { return ""; } } return current; }
  async function vcloud(input) { let u = input; try { const k = /hubcloud/i.test(u) ? "hubcloud" : "vcloud", m = await fetchJson(MIRRORS); if (m[k]) u = u.replace(root(u), m[k]); } catch (_) {} const b = root(u), first = await fetchText(u); let link = ""; if (/\/video\//i.test(u)) link = (first.match(/<div\b[^>]*class=["'][^"']*\bvd\b[^"']*["'][^>]*>[\s\S]*?<a\b[^>]*href=["']([^"']+)/i) || [])[1] || ""; else { const script = (first.match(/<script\b[^>]*>[\s\S]*?<\/script>/gi) || []).find(s => /\burl\b/.test(s)) || "", enc = (script.match(/atob\s*\(\s*atob\s*\(\s*["']([^"']+)/i) || [])[1]; try { link = enc ? atob(atob(enc)) : ((script.match(/var\s+url\s*=\s*['"]([^'"]+)/i) || [])[1] || ""); } catch (_) {} } if (!link) return []; link = abs(link, b); const h = await fetchText(link), head = clean((h.match(/<div\b[^>]*class=["'][^"']*card-header[^"']*["'][^>]*>([\s\S]*?)<\/div>/i) || [])[1]), size = clean((h.match(/<i\b[^>]*id=["']size["'][^>]*>([\s\S]*?)<\/i>/i) || [])[1]), out = []; for (const a of links(h)) { let direct = abs(a.href, link), source = "V-Cloud"; if (/FSL Server/i.test(a.text)) source += " [FSL Server]"; else if (/FSLv2/i.test(a.text)) source += " [FSLv2 Server]"; else if (/Mega Server/i.test(a.text)) source += " [Mega Server]"; else if (/Download File/i.test(a.text)) {} else if (/BuzzServer/i.test(a.text)) { try { const r = await http(direct + "/download", { headers: { Referer: direct }, redirect: "manual" }), p = r.headers.get("hx-redirect"); if (!p) continue; direct = abs(p, root(direct)); source += " [BuzzServer]"; } catch (_) { continue; } } else if (/pixeldra/i.test(direct)) { const p = (h.match(/var\s+pxl\s*=\s*["']([^"']+)/i) || [])[1]; if (!p) continue; direct = /download/i.test(p) ? p : root(p) + "/api/file/" + p.split("/").pop() + "?download"; source += " [Pixeldrain]"; } else if (/Server\s*:\s*10Gbps/i.test(a.text)) { direct = await redirect(direct); if (!direct) continue; if (/link=/.test(direct)) direct = direct.split("link=")[1]; source += " [Download]"; } else continue; const q = quality(head), displayName = [source, q !== "Unknown" ? q : "", head, size ? "[" + size + "]" : ""].filter(Boolean).join(" | "); out.push(new StreamResult({ url: direct, quality: q, source: displayName, headers: { Referer: b } })); } return out; }
  async function loadStreams(url, cb) { try { const packed = /^vega-(?:s1e1|sources):/.test(url), sources = packed ? JSON.parse(atob(url.substring(url.indexOf(":") + 1))) : (/vcloud|hubcloud/i.test(url) ? [url] : await movieSources(await fetchText(url), root(url))); cb({ success: true, data: (await Promise.all(sources.map(u => vcloud(u).catch(() => [])))).flat() }); } catch (e) { cb({ success: false, errorCode: "STREAM_ERROR", message: String(e) }); } }
  globalThis.getHome = getHome; globalThis.search = search; globalThis.load = load; globalThis.loadStreams = loadStreams;
})();






