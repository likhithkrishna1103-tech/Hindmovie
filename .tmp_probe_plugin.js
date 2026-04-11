const { spawnSync } = require("child_process");

function run(cmd, args) {
    const result = spawnSync(cmd, args, {
        cwd: process.cwd(),
        encoding: "utf8",
        maxBuffer: 1024 * 1024 * 16
    });
    const output = `${result.stdout || ""}\n${result.stderr || ""}`.replace(/\x1b\[[0-9;]*m/g, "");
    const statusMatch = output.match(/Status:\s+(SUCCESS|FAILED)/);
    const errorCodeMatch = output.match(/Error Code:\s+([^\n]+)/);
    const jsonStart = output.indexOf("{");
    let parsed = null;

    if (jsonStart !== -1) {
        try {
            parsed = JSON.parse(output.slice(jsonStart));
        } catch (_) {
            parsed = null;
        }
    }

    return {
        status: statusMatch ? statusMatch[1] : "UNKNOWN",
        errorCode: errorCodeMatch ? errorCodeMatch[1].trim() : "",
        parsed,
        output
    };
}

function firstHomeItem(data) {
    if (!data || typeof data !== "object") return null;
    const keys = Object.keys(data);
    for (let index = 0; index < keys.length; index += 1) {
        const items = data[keys[index]];
        if (Array.isArray(items) && items.length) return items[0];
    }
    return null;
}

function loadTarget(data) {
    if (!data || typeof data !== "object") return "";
    if (Array.isArray(data.episodes) && data.episodes.length && data.episodes[0] && typeof data.episodes[0].url === "string") {
        return data.episodes[0].url;
    }
    if (typeof data.url === "string") return data.url;
    return "";
}

const plugin = process.argv[2];
if (!plugin) {
    console.error("Usage: node .tmp_probe_plugin.js <plugin>");
    process.exit(1);
}

const home = run("timeout", ["45s", "skystream", "test", "-p", plugin, "-f", "getHome"]);
console.log(JSON.stringify({
    stage: "getHome",
    status: home.status,
    errorCode: home.errorCode,
    success: !!(home.parsed && home.parsed.success)
}, null, 2));
if (home.status !== "SUCCESS" || !home.parsed || !home.parsed.success) process.exit(0);

const item = firstHomeItem(home.parsed.data);
if (!item || !item.url) {
    console.log(JSON.stringify({ stage: "pickHomeItem", ok: false }, null, 2));
    process.exit(0);
}

console.log(JSON.stringify({
    stage: "pickedItem",
    title: item.title || "",
    url: item.url
}, null, 2));

const load = run("timeout", ["45s", "skystream", "test", "-p", plugin, "-f", "load", "-q", item.url]);
console.log(JSON.stringify({
    stage: "load",
    status: load.status,
    errorCode: load.errorCode,
    success: !!(load.parsed && load.parsed.success)
}, null, 2));
if (load.status !== "SUCCESS" || !load.parsed || !load.parsed.success) process.exit(0);

const target = loadTarget(load.parsed.data);
console.log(JSON.stringify({
    stage: "loadTarget",
    hasTarget: !!target,
    target
}, null, 2));
if (!target) process.exit(0);

const streams = run("timeout", ["45s", "skystream", "test", "-p", plugin, "-f", "loadStreams", "-q", target]);
const streamData = streams.parsed && streams.parsed.success && Array.isArray(streams.parsed.data) ? streams.parsed.data : [];

console.log(JSON.stringify({
    stage: "loadStreams",
    status: streams.status,
    errorCode: streams.errorCode,
    success: !!(streams.parsed && streams.parsed.success),
    count: streamData.length,
    first: streamData[0] || null
}, null, 2));
