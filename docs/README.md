# ZORO support page

A standalone, responsive donation page. No installation or build is required.

## Publish on GitHub Pages

1. Push the `docs` directory to the `main` branch.
2. Open the repository's **Settings → Pages**.
3. Under **Build and deployment**, select **Deploy from a branch**.
4. Choose **main** and **/docs**, then save.

The page will be available at:
`https://likhithkrishna1103-tech.github.io/Hindmovie/`

## Edit

- `index.html`: text, donation links, and page structure.
- `styles.css`: colors, layout, type, and responsive styles.
- `sculpture.js`: the 3D code-bracket sculpture and its WebGL fallback.
- `plugins.js`: catalog fetching, search, category/status filters, and plugin cards.
- `api/plugins.json`: the workflow-generated JSON catalog. Do not edit it directly.

The two donation buttons sit directly below the introduction and link to the existing Kulhad and Buy Me a Coffee profiles. Amounts and payments are handled on those services.

All page assets and fonts are local. The included fonts are distributed under the SIL Open Font License; their license files are in `assets/fonts/`.

The sculpture pauses outside the viewport and when the tab is hidden. Reduced-motion preferences disable animation. Page navigation and donation links work without JavaScript.

For a local preview, serve this directory with any static server, for example:

```sh
python -m http.server 8000 --directory docs
```

Then visit `http://localhost:8000`.

## Plugin status API

The repository workflow runs `.github/scripts/generate_plugin_catalog.py` after deploying plugins. It reads each source `plugin.json` and `status.json`, then updates the README table and `docs/api/plugins.json` together.

On the hosted page, the directory reads:

```text
https://raw.githubusercontent.com/likhithkrishna1103-tech/Hindmovie/main/docs/api/plugins.json
```

Local previews read `./api/plugins.json`. The published copy is also a fallback when raw GitHub is unavailable. This keeps bot-generated data updates independent of a Pages rebuild: [GitHub documents that commits made with `GITHUB_TOKEN` do not trigger Pages builds](https://docs.github.com/en/actions/concepts/security/github_token).

The response contains `schemaVersion`, `updatedAt`, `revision`, `summary`, and a `plugins` array. Each plugin includes its identifier, name, version, categories, languages, and a structured status with `state`, `label`, `message`, and `note`.

Statuses are the maintainer's reports, not automated availability probes. The existing status precedence is preserved: package name, directory name, display name, manifest status, then the existing default of Working. The API normalizes aliases such as `TV Shows` to `Series` and `Livestream` to `Live TV`; the README retains the manifest's original labels. A note on a working plugin is preserved without classifying it as an outage.

The timestamp changes only when catalog data changes. To regenerate or verify locally:

```sh
python -B .github/scripts/generate_plugin_catalog.py
python -B .github/scripts/generate_plugin_catalog.py --check
python -B -m unittest discover -s .github/scripts -p 'test_*.py'
```

The browser requests the catalog when the page loads. It provides search, combinable category/status filters, language expansion, status notes, empty results, and a retry state. Without JavaScript, a link to the README's status table remains available.
