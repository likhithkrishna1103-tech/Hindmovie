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
- `sculpture.js`: the charcoal takeaway cup, animated coffee pour, ripples, and floor reflection. A matching static SVG takes its place when WebGL is unavailable.

The two donation buttons sit directly below the introduction and link to the existing Kulhad and Buy Me a Coffee profiles. Amounts and payments are handled on those services.

All page assets and fonts are local. The included fonts are distributed under the SIL Open Font License; their license files are in `assets/fonts/`.

The sculpture pauses outside the viewport and when the tab is hidden. Reduced-motion preferences disable animation. Page navigation and donation links work without JavaScript.

For a local preview, serve this directory with any static server, for example:

```sh
python -m http.server 8000 --directory docs
```

Then visit `http://localhost:8000`.
