const fs = require("fs");
const path = require("path");
const { spawnSync } = require("child_process");

const root = process.cwd();
const sourcePath = path.join(
    root,
    "cricifyliveevents/upstream/CricifyProvider/com/cncverse/ProviderManager.kt"
);
const source = fs.readFileSync(sourcePath, "utf8");
const regex = /mapOf\("id" to (\d+), "title" to "([^"]*)", "image" to "([^"]*)", "catLink" to "([^"]*)"\)/g;
const slugs = [];

let match;
while ((match = regex.exec(source)) !== null) {
    const title = String(match[2] || "").trim();
    const catLink = String(match[4] || "").trim();
    const slug = title.toLowerCase().replace(/\s+/g, "").replace(/[^a-z0-9]/g, "");
    if (!title || !/^https?:\/\//i.test(catLink) || slug === "darktv") continue;
    slugs.push(slug);
}

const results = [];
for (const slug of slugs) {
    const run = spawnSync("skystream", ["test", "-p", slug, "-f", "getHome"], {
        cwd: root,
        encoding: "utf8",
        timeout: 45000,
        maxBuffer: 1024 * 1024 * 8
    });

    const output = `${run.stdout || ""}\n${run.stderr || ""}`;
    const cleanOutput = output.replace(/\x1b\[[0-9;]*m/g, "");
    const statusMatch = cleanOutput.match(/Status:\s+(SUCCESS|FAILED)/);
    const errorMatch = cleanOutput.match(/Error Code:\s+([^\n]+)/);

    results.push({
        slug,
        status: statusMatch ? statusMatch[1] : (run.error ? "ERROR" : "UNKNOWN"),
        error: errorMatch ? errorMatch[1].trim() : (run.error ? run.error.message : "")
    });
}

const grouped = results.reduce((acc, item) => {
    if (!acc[item.status]) acc[item.status] = [];
    acc[item.status].push(item.error ? `${item.slug} (${item.error})` : item.slug);
    return acc;
}, {});

console.log(JSON.stringify(grouped, null, 2));
