# Manual plugin testing

The **Manual Plugin Health Check** workflow is separate from `build.yml`.
It has only a `workflow_dispatch` trigger: no push, pull request or schedule
triggers, and no publishing or repository commits.

After these files are on the default branch, open **Actions → Manual Plugin
Health Check → Run workflow**. Every run tests all plugin folders except
`playeztvliveevents` and `playztv` (currently 17 plugins). The excluded folders
are omitted automatically from discovery and the job matrix.

Each plugin is tested independently. The workflow runs the real SkyStream CLI
for `getHome`, `search`, `load` and `loadStreams`. A successful exit code alone
does not pass: responses must contain usable data with the expected structure.
The runner selects **one demo movie and one demo series from `getHome`**.
It uses the item's type, with anime format, title and section hints where
needed, and avoids testing the same URL twice. Search results and fixed demo
URLs do not replace these home samples. Each sample is passed to `load`, then
its first episode URL is passed to `loadStreams` when available. A series with
no episodes fails its stream check. Movies without episode URLs use their
original home URL.
Search queries come from a manual input, `scripts/plugin-health-config.json`,
or a sampled home item's title. If a content type is absent from the home
response, it is reported as `UNAVAILABLE_IN_HOME` with a warning; the available
type is still tested. The summary identifies each movie/series title and
associates every checked stream with its sample. If neither type can be
selected, the plugin fails with `NO_SAMPLE_URL`.

For every returned stream, the runner:

- Detects common query/path expiry timestamps and AWS signed-URL expiry.
- Makes an HTTP GET with the returned headers and a small byte range.
- Separates expired URLs, HTTP errors, network errors and HTML error pages.
- Uses FFprobe to require both video and audio in the single playback URL.
- Decodes three seconds with FFmpeg by default, so HTTP 200 alone cannot pass.
- Serves `magic_m3u8:` playlists over loopback HTTP and unwraps
  `MAGIC_PROXY_v1` URLs for testing.

The default checks **every stream returned for one movie and one series**.
`max_items` increases samples **per type** (up to five movies and five series).
`max_streams=0` means
all streams; a nonzero limit produces a warning if it skips returned links.
`decode_seconds=0` disables decoding but keeps HTTP and track checks.

Failures turn the plugin job red. DRM-protected streams and unsupported schemes
are marked **unverified**, not playable or broken, and produce a warning.
The job summary contains function and stream results. Download the corresponding
`plugin-health-…` artifact for `summary.md`, `report.json`, individual JSON
responses and original CLI logs. Artifacts are retained for seven days.

Run locally from the Hindmovie folder:

```bash
python3 -m unittest discover -s tests -p 'test_plugin_health.py' -v
python3 scripts/plugin_health.py
python3 scripts/plugin_health.py --plugins youtube
python3 scripts/plugin_health.py --plugins all --max-items 2
```

Install `skystream-cli@1.9.3` and FFmpeg (including FFprobe) first. Python uses
only the standard library. Local reports go into `test-results/plugin-health`.
For targeted local troubleshooting only, `--plugins hindmoviez --url 'URL'`
can override home selection. The manual workflow does not expose this override
and always uses the home movie/series samples.

These checks cover the sampled titles and the manifest/client identity used by
the CLI, not every catalog item or sub-provider. They run from GitHub's runner
network; geographic restrictions, anti-bot checks, IP-bound URLs and desktop
codec support can differ from the installed app. A 403 is reported as a 403,
not automatically labelled expired. Unknown expiry formats are caught only
when HTTP/probing/decoding fails; an unknown timestamp is not proof of freshness.
HLS Auto decoding exercises the variant chosen by FFmpeg. Separate quality
URLs are each checked when the plugin returns them. Every alternate audio
rendition and every segment in a long video is not downloaded.

References: [GitHub manual workflow inputs](https://docs.github.com/en/actions/how-tos/write-workflows/choose-when-workflows-run/trigger-a-workflow#defining-inputs-for-manually-triggered-workflows),
[FFprobe documentation](https://ffmpeg.org/ffprobe.html).
