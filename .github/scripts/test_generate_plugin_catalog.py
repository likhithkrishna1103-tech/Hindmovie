import json
import tempfile
import unittest
from pathlib import Path

from generate_plugin_catalog import build, collect_plugins, structured_status


class CatalogTests(unittest.TestCase):
    def setUp(self):
        self.directory = tempfile.TemporaryDirectory()
        self.addCleanup(self.directory.cleanup)
        self.root = Path(self.directory.name)
        (self.root / "README.md").write_text("Before\n<!-- PLUGINS_TABLE_START -->\nold\n<!-- PLUGINS_TABLE_END -->\nAfter\n", encoding="utf-8")

    def plugin(self, directory="sample", **fields):
        path = self.root / directory
        path.mkdir(exist_ok=True)
        data = {"packageName": f"com.test.{directory}", "name": directory.title(), "version": 3, "categories": ["Movies", "TV Shows"], "languages": ["en", "hi"], **fields}
        (path / "plugin.json").write_text(json.dumps(data), encoding="utf-8")
        return data

    def statuses(self, data):
        (self.root / "status.json").write_text(json.dumps(data), encoding="utf-8")

    def test_status_precedence_and_normalized_categories(self):
        self.plugin()
        self.statuses({"com.test.sample": "Under Maintenance", "sample": "Not working", "Sample": "Working"})
        plugins, _ = collect_plugins(self.root)
        self.assertEqual(plugins[0]["status"]["state"], "maintenance")
        self.assertEqual(plugins[0]["categories"], ["Movies", "Series"])
        self.statuses({"sample": "Not working", "Sample": "Working"})
        self.assertEqual(collect_plugins(self.root)[0][0]["status"]["state"], "issues")
        self.statuses({"Sample": "Offline"})
        self.assertEqual(collect_plugins(self.root)[0][0]["status"]["state"], "issues")

    def test_working_note_is_not_reported_as_outage(self):
        status = structured_status("Working ✅️ but some networks need a VPN")
        self.assertEqual(status["state"], "working")
        self.assertEqual(status["note"], "Some networks need a VPN")
        self.assertEqual(structured_status("Working ✅️")["note"], "")
        self.assertEqual(structured_status("Not working")["state"], "issues")
        self.assertEqual(structured_status("Not tested")["state"], "unknown")

    def test_manifest_status_and_legacy_default(self):
        self.plugin(status="Offline")
        self.assertEqual(collect_plugins(self.root)[0][0]["status"]["state"], "issues")
        self.plugin(status=None)
        self.assertEqual(collect_plugins(self.root)[0][0]["status"]["state"], "working")

    def test_api_readme_sync_and_idempotence(self):
        self.plugin(name="Sample | Test")
        first = build(self.root)
        api_path = self.root / "docs/api/plugins.json"
        original = api_path.read_bytes()
        self.assertEqual(build(self.root, check=True), first)
        self.assertEqual(build(self.root), first)
        self.assertEqual(api_path.read_bytes(), original)
        self.assertIn(r"Sample \| Test", (self.root / "README.md").read_text())
        self.assertTrue((self.root / "README.md").read_text().endswith("After\n"))
        self.plugin(name="Sample | Test", version=4)
        with self.assertRaises(ValueError):
            build(self.root, check=True)
        updated = build(self.root)
        self.assertNotEqual(updated["revision"], first["revision"])
        self.assertEqual(updated["plugins"][0]["version"], "4")
        self.assertIn("| 4 |", (self.root / "README.md").read_text())

    def test_status_only_change_updates_summary_and_both_outputs(self):
        self.plugin()
        build(self.root)
        self.statuses({"com.test.sample": "Under Maintenance"})
        updated = build(self.root)
        self.assertEqual(updated["summary"]["maintenance"], 1)
        self.assertEqual(updated["summary"]["working"], 0)
        self.assertIn("Under Maintenance", (self.root / "README.md").read_text())
        self.assertEqual(json.loads((self.root / "docs/api/plugins.json").read_text()), updated)

    def test_invalid_inputs_do_not_overwrite_generated_files(self):
        self.plugin()
        build(self.root)
        original = (self.root / "docs/api/plugins.json").read_bytes()
        self.plugin("duplicate", packageName="com.test.sample")
        with self.assertRaisesRegex(ValueError, "Duplicate"):
            build(self.root)
        self.assertEqual((self.root / "docs/api/plugins.json").read_bytes(), original)


if __name__ == "__main__":
    unittest.main()
