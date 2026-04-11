const fs = require("fs");
const path = require("path");
const { execFileSync } = require("child_process");

const root = process.cwd();
const sourcePath = path.join(root, "cricifyliveevents/upstream/CricifyProvider/com/cncverse/ProviderManager.kt");
const templatePath = path.join(root, ".tmp_cricify_iptv_template.js");

const source = fs.readFileSync(sourcePath, "utf8");
const existingDirs = new Set(
    fs.readdirSync(root).filter((name) => {
        try {
            return fs.statSync(path.join(root, name)).isDirectory();
        } catch (_) {
            return false;
        }
    })
);

const regex = /mapOf\("id" to (\d+), "title" to "([^"]*)", "image" to "([^"]*)", "catLink" to "([^"]*)"\)/g;
const created = [];
const skipped = [];

let match;
while ((match = regex.exec(source)) !== null) {
    const title = String(match[2] || "").trim();
    const catLink = String(match[4] || "").trim();
    const slug = title.toLowerCase().replace(/\s+/g, "").replace(/[^a-z0-9]/g, "");

    if (!title || !slug) {
        skipped.push(`invalid-title:${title}`);
        continue;
    }
    if (!/^https?:\/\//i.test(catLink)) {
        skipped.push(`${slug}:invalid-catLink:${catLink}`);
        continue;
    }
    if (existingDirs.has(slug)) {
        skipped.push(`${slug}:exists`);
        continue;
    }

    const description = `${title} live IPTV provider from Cricify CloudStream`;
    execFileSync("skystream", ["add", title, "--description", description], {
        cwd: root,
        stdio: "pipe"
    });

    const pluginDir = path.join(root, slug);
    const manifestPath = path.join(pluginDir, "plugin.json");
    const manifest = JSON.parse(fs.readFileSync(manifestPath, "utf8"));
    manifest.baseUrl = catLink;
    manifest.description = description;
    manifest.version = 1;
    fs.writeFileSync(manifestPath, JSON.stringify(manifest, null, 2) + "\n");
    fs.copyFileSync(templatePath, path.join(pluginDir, "plugin.js"));

    existingDirs.add(slug);
    created.push({ slug, title, catLink });
}

console.log(
    JSON.stringify(
        {
            createdCount: created.length,
            created: created,
            skippedCount: skipped.length,
            skipped: skipped
        },
        null,
        2
    )
);
