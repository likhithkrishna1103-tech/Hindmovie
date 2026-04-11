const { spawnSync } = require("child_process");

const plugin = process.argv[2];
if (!plugin) {
    console.error("Usage: node .tmp_summarize_gethome.js <plugin>");
    process.exit(1);
}

const run = spawnSync("timeout", ["45s", "skystream", "test", "-p", plugin, "-f", "getHome"], {
    cwd: process.cwd(),
    encoding: "utf8",
    maxBuffer: 1024 * 1024 * 32
});

const output = `${run.stdout || ""}\n${run.stderr || ""}`.replace(/\x1b\[[0-9;]*m/g, "");
const jsonStart = output.indexOf("{");
if (jsonStart === -1) {
    console.log(JSON.stringify({ plugin, parseable: false, output: output.slice(0, 1000) }, null, 2));
    process.exit(0);
}

let parsed = null;
try {
    parsed = JSON.parse(output.slice(jsonStart));
} catch (error) {
    console.log(JSON.stringify({ plugin, parseable: false, error: error.message, output: output.slice(jsonStart, jsonStart + 1200) }, null, 2));
    process.exit(0);
}

const categories = parsed && parsed.data && typeof parsed.data === "object" ? parsed.data : {};
const suspicious = [];
const firstCategories = Object.keys(categories).slice(0, 20).map((name) => {
    const items = Array.isArray(categories[name]) ? categories[name] : [];
    items.slice(0, 5).forEach((item) => {
        const title = String(item && item.title || "");
        if (/telegram|join|whatsapp|contact|support|channel|movie update|request/i.test(title)) {
            suspicious.push({ category: name, title });
        }
    });
    return {
        name,
        count: items.length,
        sample: items.slice(0, 5).map((item) => String(item && item.title || ""))
    };
});

console.log(JSON.stringify({
    plugin,
    success: !!parsed.success,
    categoryCount: Object.keys(categories).length,
    firstCategories,
    suspicious
}, null, 2));
