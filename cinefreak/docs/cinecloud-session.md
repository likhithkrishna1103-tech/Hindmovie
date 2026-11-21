# CineCloud session compatibility

The remaining playback failure is unresolved. The plugin resolves the episode URLs and receives successful `/unlock` responses, but subsequent download requests redirect to the placeholder `Watch Online (HD).mp4`. Keeping `cf_pass` and `ci_session` in the plugin's cookie jar has not fixed this in the supplied app logs. Those diagnostic flags prove the jar contains the cookies, not that the native transport sent the same browser state.

## Reference inspected

Downloaded [Cinefreak.cs3](https://github.com/phisher98/cloudstream-extensions-phisher/raw/refs/heads/builds/Cinefreak.cs3) again and decompiled its `classes.dex` with JADX on 2026-10-21. SHA-256 of the archive:

`4d73d1a2de42a2f8baf9a27ff0ef5392cf486d6ff040f4701e371332ea1ea831`

Relevant classes and behavior:

- `CineCloudResolverKt.CINECLOUD_INJECT_JS`: `__ccUnlock` fetches `/n` and posts `ts` and `bc` to `/unlock` inside a persistent WebView, with `credentials: 'same-origin'` and `cache: 'no-store'`.
- `CineCloudResolver.resolveUnlockedHtml` invokes that function through `callInPage`.
- `CineCloudResolver.farmPost` invokes `__ccPost` in the same WebView for `a=play` and instant-download verification.
- `CineCloudResolver.getCookie` reads Android's WebView `CookieManager`; `getWebViewUa` supplies the actual browser User-Agent. `CineCloud` uses both when fetching child downloads.

## SkyStream difference

The documented [`solveCaptcha(siteKey, url)`](https://github.com/akashdh11/skystream-tools/blob/main/DEVELOPER.md#solvecaptchasitekey-url) returns a token string. It does open a browser, but it does not expose that browser's session to plugin code.

The inspected SDK source confirms the separation:

- [`captcha_solver.dart`](https://github.com/akashdh11/skystream/blob/master/lib/core/network/clearance/captcha_solver.dart) borrows a page, extracts a token, and disposes the page in `finally`.
- [`js_engine.dart`](https://github.com/akashdh11/skystream/blob/master/lib/core/extensions/engine/js_engine.dart) exposes captcha solving and HTTP requests; it has no plugin-callable persistent-browser fetch operation.
- [`clearance_interceptor.dart`](https://github.com/akashdh11/skystream/blob/master/lib/core/network/clearance/clearance_interceptor.dart) can merge stored clearance cookies over explicit request cookies and replace the User-Agent. Thus plugin cookie presence alone cannot establish which session reached the server.

This is a confirmed architectural difference, not proof of the server's exact rejection rule. Cookie replacement, concurrent session changes, browser state and request fingerprinting remain possible factors. Changing captcha type or accepting the placeholder video would not reproduce the reference behavior.

## Required integration for a faithful port

SkyStream must expose a supported way to keep the captcha page alive and perform the nonce, unlock and subsequent form requests in that same browser session. Child downloads must retain its cookie state and actual User-Agent, with redirect metadata available without downloading the full video into JavaScript. The native implementation must handle cancellation and the invocation deadline and restrict cookies to their valid hosts and paths.

No speculative bridge API has been added to `plugin.js`. Until that capability is available, the plugin retains the existing token-based flow, returns successful alternatives when available, rejects placeholder media, and reports `CLOUD_SESSION_ERROR` when placeholder redirects leave no playable stream. Fixture tests do not establish live playback success.
