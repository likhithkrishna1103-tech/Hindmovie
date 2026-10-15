#!/usr/bin/env python3
"""Build the README status table and public JSON from the same repository data."""

import argparse
import hashlib
import json
import re
from datetime import datetime, timezone
from pathlib import Path

START = "<!-- PLUGINS_TABLE_START -->"
END = "<!-- PLUGINS_TABLE_END -->"
LABELS = {"working": "Working", "maintenance": "Maintenance", "issues": "Reported issues", "unknown": "Unknown"}
CATEGORY_NAMES = {
    "anime": "Anime", "movies": "Movies", "series": "Series", "tv shows": "Series",
    "livetv": "Live TV", "live tv": "Live TV", "livestream": "Live TV",
    "others": "Other", "other": "Other",
}


def string_list(value):
    values = value if isinstance(value, list) else str(value or "").split(",")
    return list(dict.fromkeys(str(item).strip() for item in values if str(item).strip()))


def structured_status(raw):
    text = " ".join(str(raw).split())
    clean = re.sub(r"[\U0001F000-\U0001FAFF\u2600-\u27FF\uFE0E\uFE0F\u200D]", "", text).strip()
    if re.search(r"maint(?:enance|ainance)|under repair", clean, re.I):
        state = "maintenance"
    elif re.search(r"\b(?:not\s+working|broken|down|offline|failing|unavailable)\b", clean, re.I):
        state = "issues"
    elif re.search(r"\b(?:working|operational|online)\b", clean, re.I):
        state = "working"
    else:
        state = "unknown"
    note = clean
    if state == "working":
        note = re.sub(r"^(?:working|operational|online)[\s.!:;—-]*(?:but\s+)?", "", clean, flags=re.I).strip()
    if note.casefold() == LABELS[state].casefold():
        note = ""
    if note:
        note = note[0].upper() + note[1:]
    return {"state": state, "label": LABELS[state], "message": text, "note": note}


def collect_plugins(root):
    status_path = root / "status.json"
    statuses = json.loads(status_path.read_text(encoding="utf-8")) if status_path.exists() else {}
    if not isinstance(statuses, dict):
        raise ValueError("status.json must contain an object")
    plugins, rows, seen = [], [], set()
    for directory in sorted(root.iterdir()):
        if directory.name == "dist" or directory.name.startswith(".") or not directory.is_dir():
            continue
        manifest = directory / "plugin.json"
        if not manifest.is_file():
            continue
        data = json.loads(manifest.read_text(encoding="utf-8"))
        package = str(data.get("packageName") or "").strip()
        plugin_id = package or directory.name
        if plugin_id in seen:
            raise ValueError(f"Duplicate plugin identifier: {plugin_id}")
        seen.add(plugin_id)
        name = str(data.get("name") or directory.name).strip()
        version = str(data.get("version", "N/A")).strip()
        status = statuses.get(package) or statuses.get(directory.name) or statuses.get(name) or data.get("status") or "Working ✅️"
        if not isinstance(status, str):
            raise ValueError(f"Status for {name} must be text")
        status = " ".join(status.split())
        raw_categories = string_list(data.get("categories", []))
        languages = string_list(data.get("languages", []))
        categories = list(dict.fromkeys(CATEGORY_NAMES.get(c.casefold(), c) for c in raw_categories)) or ["Other"]
        plugins.append({
            "id": plugin_id, "name": name, "version": version,
            "categories": categories, "languages": languages, "status": structured_status(status),
        })
        rows.append((name, version, status, ", ".join(raw_categories), ", ".join(languages)))
    plugins.sort(key=lambda plugin: (plugin["name"].casefold(), plugin["id"]))
    rows.sort(key=lambda row: row[0].casefold())
    return plugins, rows


def readme_with_table(content, rows):
    def cell(value):
        return str(value).replace("|", r"\|").replace("\n", " ")

    lines = ["| Plugin | Version | Status | Categories | Languages |", "| :--- | :--- | :--- | :--- | :--- |"]
    lines.extend("| " + " | ".join(cell(value) for value in row) + " |" for row in rows)
    block = START + "\n" + "\n".join(lines) + "\n" + END
    if START in content and END in content:
        return re.sub(re.escape(START) + r".*?" + re.escape(END), lambda _: block, content, flags=re.S)
    return content.rstrip() + "\n\n### 🧩 Plugins Status\n\n" + block + "\n"


def build(root, check=False):
    plugins, rows = collect_plugins(root)
    readme_path = root / "README.md"
    original_readme = readme_path.read_text(encoding="utf-8")
    readme = readme_with_table(original_readme, rows)
    payload = json.dumps(plugins, ensure_ascii=False, sort_keys=True, separators=(",", ":"))
    revision = hashlib.sha256(payload.encode("utf-8")).hexdigest()
    output = root / "docs" / "api" / "plugins.json"
    old = json.loads(output.read_text(encoding="utf-8")) if output.exists() else {}
    # Avoid a fresh timestamp and bot commit when the catalog has not changed.
    updated = old.get("updatedAt") if old.get("revision") == revision else None
    updated = updated or datetime.now(timezone.utc).isoformat(timespec="seconds").replace("+00:00", "Z")
    summary = {"total": len(plugins), **{state: sum(p["status"]["state"] == state for p in plugins) for state in LABELS}}
    catalog = {"schemaVersion": 1, "updatedAt": updated, "revision": revision, "summary": summary, "plugins": plugins}
    encoded = json.dumps(catalog, ensure_ascii=False, indent=2) + "\n"
    if check:
        if original_readme != readme or not output.exists() or output.read_text(encoding="utf-8") != encoded:
            raise ValueError("Plugin catalog or README is stale; run generate_plugin_catalog.py")
    else:
        output.parent.mkdir(parents=True, exist_ok=True)
        # Parse and validate every input before writing either generated artifact.
        output.write_text(encoded, encoding="utf-8")
        if readme != original_readme:
            readme_path.write_text(readme, encoding="utf-8")
    return catalog


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parents[2])
    parser.add_argument("--check", action="store_true", help="Verify generated files without changing them")
    args = parser.parse_args()
    try:
        result = build(args.root, check=args.check)
    except (ValueError, OSError, KeyError, TypeError) as error:
        parser.exit(1, f"Catalog generation failed: {error}\n")
    print(f"{'Verified' if args.check else 'Generated'} README and API catalog: {result['summary']['total']} plugins")
