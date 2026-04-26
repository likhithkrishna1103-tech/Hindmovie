const fs = require("fs");
const vm = require("vm");

const pluginPath = "/data/data/com.termux/files/home/hindmovie/cinestream/plugin.js";
const pluginSource = fs.readFileSync(pluginPath, "utf8").replace(
  'if (typeof globalThis !== "undefined") {',
  'globalThis.__providers = typeof PROVIDERS !== "undefined" ? PROVIDERS : [];\n    if (typeof globalThis !== "undefined") {'
);

function normalizeHeaders(headers) {
  const out = {};
  if (!headers) return out;
  if (typeof headers.forEach === "function") {
    headers.forEach((value, key) => {
      out[String(key).toLowerCase()] = value;
    });
    return out;
  }
  for (const key of Object.keys(headers)) out[String(key).toLowerCase()] = headers[key];
  return out;
}

async function httpGet(url, headers) {
  const res = await fetch(url, {
    method: "GET",
    headers: headers || {},
    redirect: "follow",
  });
  return {
    status: res.status,
    body: await res.text(),
    headers: normalizeHeaders(res.headers),
    finalUrl: res.url || url,
  };
}

async function httpPost(url, a, b) {
  let headers = {};
  let body = "";
  if (typeof a === "object" && typeof b === "string") {
    headers = a || {};
    body = b || "";
  } else if (typeof a === "string" && typeof b === "object") {
    body = a || "";
    headers = b || {};
  }
  const res = await fetch(url, {
    method: "POST",
    headers,
    body,
    redirect: "follow",
  });
  return {
    status: res.status,
    body: await res.text(),
    headers: normalizeHeaders(res.headers),
    finalUrl: res.url || url,
  };
}

function ctor(data) {
  Object.assign(this, data || {});
}

const sandbox = {
  console,
  Buffer,
  URL,
  TextEncoder,
  TextDecoder,
  Uint8Array,
  ArrayBuffer,
  DataView,
  atob,
  btoa,
  setTimeout,
  clearTimeout,
  fetch,
  require,
  globalThis: null,
  manifest: { baseUrl: "https://cinemeta-catalogs.strem.io" },
  http_get: httpGet,
  http_post: httpPost,
  sendMessage: async () => { throw new Error("sendMessage unsupported"); },
  MultimediaItem: ctor,
  Episode: ctor,
  StreamResult: ctor,
  Actor: ctor,
  SubtitleFile: ctor,
};

sandbox.globalThis = sandbox;
vm.createContext(sandbox);
vm.runInContext(pluginSource, sandbox, { filename: pluginPath });

function callFn(fn, arg) {
  return new Promise((resolve) => {
    sandbox[fn](arg, (result) => resolve(result));
  });
}

function normalize(str) {
  return String(str || "").toLowerCase().replace(/[^a-z0-9]+/g, " ").trim();
}

async function main() {
  const query = process.argv[2] || "oppenheimer";
  const wanted = normalize(process.argv[3] || query);
  const searchRes = await callFn("search", query);
  if (!searchRes || !searchRes.success) {
    console.error("SEARCH_FAILED", JSON.stringify(searchRes, null, 2));
    process.exit(1);
  }

  const rows = searchRes.data || [];
  let match = rows.find((item) => normalize(item.title) === wanted);
  if (!match) match = rows.find((item) => normalize(item.title).includes(wanted));
  if (!match) match = rows[0];
  if (!match) {
    console.error("NO_MATCH");
    process.exit(1);
  }

  console.log("SEARCH_MATCH", JSON.stringify({ title: match.title, type: match.type, url: match.url }, null, 2));
  const loadRes = await callFn("load", match.url);
  if (!loadRes || !loadRes.success) {
    console.error("LOAD_FAILED", JSON.stringify(loadRes, null, 2));
    process.exit(1);
  }

  const media = loadRes.data || {};
  const episodes = media.episodes || [];
  const target = episodes[0];
  if (!target || !target.url) {
    console.error("NO_EPISODE", JSON.stringify(media, null, 2));
    process.exit(1);
  }

  console.log("LOAD_TARGET", JSON.stringify({ title: media.title, episode: target.name, url: target.url }, null, 2));
  const streamsRes = await callFn("loadStreams", target.url);
  console.log("LOADSTREAMS", JSON.stringify(streamsRes, null, 2));

  const providers = Array.isArray(sandbox.__providers) ? sandbox.__providers : [];
  const wantedProviders = ["PrimeSrc", "VidFastPro", "VidRock", "CinemaOS", "VidSrc"];
  for (const name of wantedProviders) {
    const provider = providers.find((item) => item && item.name === name);
    if (!provider || typeof provider.resolve !== "function") continue;
    try {
      const parsed = JSON.parse(target.url);
      const direct = await provider.resolve(parsed);
      console.log("DIRECT_PROVIDER", JSON.stringify({
        name,
        count: Array.isArray(direct) ? direct.length : 0,
        samples: (direct || []).slice(0, 3).map((item) => ({
          source: item.source,
          quality: item.quality,
          url: item.url
        }))
      }, null, 2));
    } catch (error) {
      console.log("DIRECT_PROVIDER", JSON.stringify({
        name,
        error: String(error && error.message || error)
      }, null, 2));
    }
  }
}

main().catch((error) => {
  console.error("HARNESS_ERROR", error && error.stack || error);
  process.exit(1);
});
