const fs = require("fs");
const path = require("path");

const root = process.cwd();
const sourcePath = path.join(
    root,
    "cricifyliveevents/upstream/CricifyProvider/com/cncverse/ProviderManager.kt"
);
const templatePath = path.join(root, ".tmp_cricify_iptv_template.js");
const template = fs.readFileSync(templatePath, "utf8");
const source = fs.readFileSync(sourcePath, "utf8");
const regex = /mapOf\("id" to (\d+), "title" to "([^"]*)", "image" to "([^"]*)", "catLink" to "([^"]*)"\)/g;

let updatedCount = 0;
let match;

while ((match = regex.exec(source)) !== null) {
    const title = String(match[2] || "").trim();
    const catLink = String(match[4] || "").trim();
    const slug = title.toLowerCase().replace(/\s+/g, "").replace(/[^a-z0-9]/g, "");
    if (!title || !/^https?:\/\//i.test(catLink) || slug === "darktv") continue;

    const pluginDir = path.join(root, slug);
    const manifestPath = path.join(pluginDir, "plugin.json");
    const pluginPath = path.join(pluginDir, "plugin.js");
    if (!fs.existsSync(manifestPath) || !fs.existsSync(pluginDir)) continue;

    const manifest = JSON.parse(fs.readFileSync(manifestPath, "utf8"));
    manifest.baseUrl = catLink;
    manifest.description = `${title} live IPTV provider from Cricify CloudStream`;
    fs.writeFileSync(manifestPath, JSON.stringify(manifest, null, 2) + "\n");
    fs.writeFileSync(pluginPath, template);
    updatedCount += 1;
}

console.log(JSON.stringify({ updatedCount }, null, 2));
