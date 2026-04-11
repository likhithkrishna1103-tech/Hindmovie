const fs = require("fs");
const path = require("path");
const { spawnSync } = require("child_process");

const root = process.cwd();

function runSkystream(pluginPath, fn, query) {
    const args = ["test", "-p", pluginPath, "-f", fn];
    if (typeof query === "string") args.push("-q", query);

    const run = spawnSync("skystream", args, {
        cwd: root,
        encoding: "utf8",
        timeout: 90000,
        maxBuffer: 1024 * 1024 * 16
    });

    const output = `${run.stdout || ""}\n${run.stderr || ""}`.replace(/\x1b\[[0-9;]*m/g, "");
    const statusMatch = output.match(/Status:\s+(SUCCESS|FAILED)/);
    const errorCodeMatch = output.match(/Error Code:\s+([^\n]+)/);
    const jsonStart = output.indexOf("{");
    let data = null;

    if (jsonStart !== -1) {
        try {
            data = JSON.parse(output.slice(jsonStart));
        } catch (_) {
            data = null;
        }
    }

    return {
        status: statusMatch ? statusMatch[1] : "UNKNOWN",
        errorCode: errorCodeMatch ? errorCodeMatch[1].trim() : "",
        parsed: data,
        output
    };
}

function getFirstHomeItem(homeData) {
    if (!homeData) return null;
    if (Array.isArray(homeData)) return homeData[0] || null;
    if (typeof homeData !== "object") return null;

    const keys = Object.keys(homeData);
    for (let i = 0; i < keys.length; i += 1) {
        const items = homeData[keys[i]];
        if (Array.isArray(items) && items.length) return items[0];
    }
    return null;
}

function getLoadTarget(loadData) {
    if (!loadData || typeof loadData !== "object") return null;
    if (Array.isArray(loadData.episodes) && loadData.episodes.length && loadData.episodes[0] && loadData.episodes[0].url) {
        return loadData.episodes[0].url;
    }
    if (typeof loadData.url === "string" && loadData.url) return loadData.url;
    return null;
}

function getPluginDirs() {
    return fs.readdirSync(root).filter((name) => {
        const fullPath = path.join(root, name);
        try {
            return fs.statSync(fullPath).isDirectory() &&
                fs.existsSync(path.join(fullPath, "plugin.js")) &&
                fs.existsSync(path.join(fullPath, "plugin.json"));
        } catch (_) {
            return false;
        }
    }).sort();
}

const results = [];
const pluginDirs = getPluginDirs();

for (const pluginDir of pluginDirs) {
    const row = {
        plugin: pluginDir,
        getHome: "",
        load: "",
        loadStreams: "",
        notes: ""
    };

    const home = runSkystream(pluginDir, "getHome");
    row.getHome = home.status === "SUCCESS" ? "ok" : (home.errorCode || home.status);
    if (home.status !== "SUCCESS" || !home.parsed || !home.parsed.success) {
        row.notes = "getHome failed";
        results.push(row);
        continue;
    }

    const firstItem = getFirstHomeItem(home.parsed.data);
    if (!firstItem || !firstItem.url) {
        row.notes = "no home item";
        results.push(row);
        continue;
    }

    const load = runSkystream(pluginDir, "load", firstItem.url);
    row.load = load.status === "SUCCESS" ? "ok" : (load.errorCode || load.status);
    if (load.status !== "SUCCESS" || !load.parsed || !load.parsed.success) {
        row.notes = "load failed";
        results.push(row);
        continue;
    }

    const loadTarget = getLoadTarget(load.parsed.data);
    if (!loadTarget) {
        row.notes = "no load target";
        results.push(row);
        continue;
    }

    const streams = runSkystream(pluginDir, "loadStreams", loadTarget);
    row.loadStreams = streams.status === "SUCCESS" ? "ok" : (streams.errorCode || streams.status);
    if (streams.status === "SUCCESS" && streams.parsed && streams.parsed.success && Array.isArray(streams.parsed.data)) {
        row.notes = `streams=${streams.parsed.data.length}`;
    } else {
        row.notes = "loadStreams failed";
    }
    results.push(row);
}

console.log(JSON.stringify(results, null, 2));
