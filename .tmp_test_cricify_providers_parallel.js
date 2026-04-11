const fs = require("fs");
const path = require("path");
const { spawn } = require("child_process");

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

function runProviderTest(slug) {
    return new Promise((resolve) => {
        const child = spawn("skystream", ["test", "-p", slug, "-f", "getHome"], {
            cwd: root,
            stdio: ["ignore", "pipe", "pipe"]
        });

        let stdout = "";
        let stderr = "";
        let finished = false;

        const timeout = setTimeout(() => {
            if (finished) return;
            finished = true;
            child.kill("SIGTERM");
            resolve({
                slug,
                status: "ERROR",
                error: "timeout"
            });
        }, 45000);

        child.stdout.on("data", (chunk) => {
            stdout += chunk.toString();
        });

        child.stderr.on("data", (chunk) => {
            stderr += chunk.toString();
        });

        child.on("error", (error) => {
            if (finished) return;
            finished = true;
            clearTimeout(timeout);
            resolve({
                slug,
                status: "ERROR",
                error: error && error.message ? error.message : String(error)
            });
        });

        child.on("close", () => {
            if (finished) return;
            finished = true;
            clearTimeout(timeout);

            const output = `${stdout}\n${stderr}`.replace(/\x1b\[[0-9;]*m/g, "");
            const statusMatch = output.match(/Status:\s+(SUCCESS|FAILED)/);
            const errorMatch = output.match(/Error Code:\s+([^\n]+)/);

            resolve({
                slug,
                status: statusMatch ? statusMatch[1] : "UNKNOWN",
                error: errorMatch ? errorMatch[1].trim() : ""
            });
        });
    });
}

async function runWithConcurrency(items, concurrency) {
    const results = [];
    let index = 0;

    async function worker() {
        while (index < items.length) {
            const current = items[index];
            index += 1;
            results.push(await runProviderTest(current));
        }
    }

    const workers = [];
    for (let i = 0; i < Math.min(concurrency, items.length); i += 1) {
        workers.push(worker());
    }

    await Promise.all(workers);
    return results;
}

(async function main() {
    const results = await runWithConcurrency(slugs, 8);
    results.sort((a, b) => a.slug.localeCompare(b.slug));

    const grouped = {
        SUCCESS: [],
        FAILED: [],
        ERROR: [],
        UNKNOWN: []
    };

    for (const result of results) {
        const bucket = grouped[result.status] || grouped.UNKNOWN;
        bucket.push(result.error ? `${result.slug} (${result.error})` : result.slug);
    }

    console.log(JSON.stringify(grouped, null, 2));
})();
