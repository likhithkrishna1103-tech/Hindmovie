const assert = require('node:assert/strict');
const fs = require('node:fs');
const path = require('node:path');
const test = require('node:test');
const vm = require('node:vm');

const source = fs.readFileSync(path.join(__dirname, '..', 'plugin.js'), 'utf8');
const host = 'https://new5.cinecloud.site';
const root = host + '/f/movie';
const key = '0x4AAAAAAFUBbDesHlySPLsN';
const media = 'https://cdn.example.com/movie-1080p.mp4';
const challenge = `<div data-sitekey="${key}"></div><script>fetch('/f/movie/n');fetch('/f/movie/unlock');</script>`;
// Same hidden-container and button structure as the user's /unlock response.
const unlocked = `<style>.c585a48{position:absolute!important;left:-10000px!important}</style>
<div class="c585a48" aria-hidden="true">
 <a href="/f/trap-fast" class="btn-fast fsl-btn">FAST CLOUD [FSL]</a>
 <a href="/f/trap-instant" class="btn-instant">Instant Download</a>
 <a href="/f/trap-resume" class="btn-cloud">Cloud [Resumable]</a>
 <a href="/f/trap-stream" class="btn-stream">Stream Online</a>
</div>
<button id="download-button">Login To DL [10GBPS]</button>
<a href="/f/fast" class="btn-fast fsl-btn"><span>FAST CLOUD [FSL]</span></a>
<a href="/f/vz" class="btn-fastvz fsl-btn">FAST CLOUD [V2]</a>
<a href="/f/instant" class="btn-instant">Instant Download</a>
<a href="/f/instant2" class="btn-instant2">Instant Download [V2]</a>
<a href="/f/resume" class="btn-cloud">Cloud [Resumable]</a>
<a href="/f/stream" class="btn-stream">Stream Online</a>`;

function response(body, extra = {}) {
    return { status: 200, body: typeof body === 'string' ? body : JSON.stringify(body), headers: {}, ...extra };
}

function runtime(options = {}) {
    const calls = [], solves = [], logs = [];
    const context = vm.createContext({
        URL, Buffer, setTimeout, clearTimeout,
        console: { log(message) { logs.push(message); }, error() {} },
        StreamResult: function (data) { Object.assign(this, data); },
        Episode: function (data) { Object.assign(this, data); },
        MultimediaItem: function (data) { Object.assign(this, data); },
        http_get: async (url, headers) => {
            calls.push({ method: 'GET', url, headers });
            if (options.get) {
                const res = await options.get(url, headers);
                if (res) return res;
            }
            if (url === root) return response(options.page === undefined ? challenge : options.page);
            if (url === root + '/n') return response({ n: 'nonce+/=' });
            if (url === host + '/x/movie') return response(options.watch || '');
            throw new Error('Unexpected GET ' + url);
        },
        http_post: async (url, headers, body) => {
            if (url.startsWith('https://www.google-analytics.com/')) return response('');
            calls.push({ method: 'POST', url, headers, body });
            if (options.post) {
                const res = await options.post(url, headers, body);
                if (res) return res;
            }
            if (url === root + '/unlock') return response({ ok: true, html: options.unlocked === undefined ? unlocked : options.unlocked });
            throw new Error('Unexpected POST ' + url);
        }
    });
    if (!options.noSolver) context.solveCaptcha = async (siteKey, url) => {
        solves.push({ siteKey, url });
        if (options.solve) return options.solve(siteKey, url);
        return 'token+/=';
    };
    vm.runInContext(source, context);
    return {
        calls, solves, logs,
        async details(url) {
            const callbacks = [];
            await context.load(url, result => callbacks.push(result));
            assert.equal(callbacks.length, 1);
            return callbacks[0];
        },
        async load(input = root) {
            const callbacks = [];
            await context.loadStreams(typeof input === 'string' ? input : JSON.stringify(input), result => callbacks.push(result));
            assert.equal(callbacks.length, 1);
            return callbacks[0];
        }
    };
}

test('resolves all six real buttons, skips hidden decoys, and avoids /x when downloads work', async () => {
    const app = runtime({
        get(url) {
            if (url === host + '/f/fast') return response('<a class="download-now" href="/d/fast">Download</a>');
            if (url === host + '/d/fast') return response('', { finalUrl: media });
            if (url === host + '/f/instant') return response(`<script>turnstile.render(box,{sitekey:'${key}'});</script>`);
            if (url === host + '/f/instant2') return response('<a class="btn-instant2" href="/fastdl/v2">Download</a>');
            if (url === host + '/fastdl/v2') return response('', { headers: { location: media + '?v2' } });
            if (url === host + '/f/resume') return response(`<script>var downloadUrl = '${media}?resume';</script>`);
            if (url === 'https://player.example/embed') return response(`var player = {file:'https://cdn.example.com/master.m3u8'};`);
        },
        post(url, headers, body) {
            if (url === host + '/f/instant') {
                assert.equal(new URLSearchParams(body).get('ts'), 'token+/=');
                return response({ html: `<a class="instant-download" href="${media}?instant">Download</a>` });
            }
            if (url === host + '/f/vz') return response({ ok: true, url: 'https://player.example/embed' });
            if (url === host + '/f/stream') return response({ ok: true, vlc: media + '?stream' });
        }
    });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.equal(result.data.length, 6);
    assert.equal(app.calls.some(c => /trap-|\/x\//.test(c.url)), false);
    assert.deepEqual(app.solves.map(s => s.url).sort(), [root, host + '/f/instant'].sort());
    const unlock = app.calls.find(c => c.url === root + '/unlock');
    assert.deepEqual(Object.fromEntries(new URLSearchParams(unlock.body)), { ts: 'token+/=', bc: 'nonce+/=' });
    assert.equal(app.calls.filter(c => c.body === 'a=play').length, 2);
});

test('series timeline rows preserve full links and exclude hidden decoy episodes', async () => {
    const page = 'https://cinefreak.ch/example-full-series-download/';
    const row = (episode, code, label = episode) => `<div class="cft-it" data-k="es05e${episode}">
        <div class="cft-card"><div class="cft-row"><div class="cft-info"><b>Episode ${label}</b></div>
        <a class="cfs-watch cft-pill" href="${host}/f/watch-${code}">Watch</a></div>
        <div class="cft-qs"><a class="dlbtn dlbtn-download cfs-dl" href="${host}/f/${code}"><b>1080p</b></a></div></div></div>`;
    const html = `<h1 class="page-title">Example</h1><script>const dataset = {"type":"series","seasons":[{"episodes":[{"sources":"e0_0"}]}]};</script>
        <div aria-hidden="true">${row('00', 'decoy')}</div><div class="cft">${row('03', 'real-third')}${row('01', 'real-bundle', '01-02')}</div>`;
    const app = runtime({ get: url => response(url === page ? html : {}) });
    const result = await app.details(page);
    assert.equal(result.success, true, result.message);
    const episodes = result.data.episodes;
    assert.deepEqual(Array.from(episodes, ep => [ep.season, ep.episode]), [[5, 1], [5, 3]]);
    assert.equal(episodes[0].name, 'Episode 1-2');
    const links = JSON.parse(episodes[0].url).links;
    assert.deepEqual(links.map(link => link.href), [host + '/f/watch-real-bundle', host + '/f/real-bundle']);
    assert.deepEqual(links.map(link => link.mode), ['watch', 'download']);
    assert.equal(links[1].quality, 1080);
    const streams = await app.load(episodes[0].url);
    assert.equal(streams.errorCode, 'STREAM_EMPTY');
    assert.equal(app.calls.some(call => /\/(?:f|x)\/[e0_]$/.test(call.url)), false);
});

test('dataset episode identifiers are never interpreted as file codes', async () => {
    const page = 'https://cinefreak.ch/example-full-series-download/';
    const html = '<h1 class="page-title">Example</h1><script>const dataset = {"type":"series","seasons":[{"season_name":"Season 01","episodes":[{"ep_num":"01","sources":"e0_0"}]}]};</script>';
    const app = runtime({ get: url => response(url === page ? html : {}) });
    const result = await app.details(page);
    assert.equal(result.success, false);
    assert.equal(result.errorCode, 'LOAD_EMPTY');
    assert.equal(app.calls.some(call => call.url.startsWith(host)), false);
});

test('legacy dataset quality maps still produce complete links', async () => {
    const page = 'https://cinefreak.ch/example-full-series-download/';
    const html = '<h1 class="page-title">Example</h1><script>const dataset = {"type":"series","seasons":[{"season_name":"Season 02","episodes":[{"ep_num":"03","sources":{"1080p":"complete_file-code"}}]}]};</script>';
    const app = runtime({ get: url => response(url === page ? html : {}) });
    const result = await app.details(page);
    assert.equal(result.success, true, result.message);
    assert.equal(result.data.episodes[0].season, 2);
    assert.equal(result.data.episodes[0].episode, 3);
    assert.equal(JSON.parse(result.data.episodes[0].url).links[0].href, host + '/f/complete_file-code');
});

test('hidden ancestor filtering works with changing class names and nested divs', async () => {
    const html = `<section aria-hidden="true"><div><a class="btn-instant" href="/f/trap">Instant Download</a></div></section>
        <div style="display:none"><a class="btn-fast" href="/f/trap2">FAST CLOUD</a></div>
        <div hidden><a class="btn-stream" href="/f/trap3">Stream</a></div>
        <a class="btn-fast" href="${media}">FAST CLOUD</a>`;
    const app = runtime({ page: html });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.equal(result.data.length, 1);
    assert.equal(app.calls.length, 1);
});

test('rejects the decoy mp4 even though it looks playable', async () => {
    const decoy = 'https://pub-example.r2.dev/CINEFREAK.NET%20-%20Watch%20Online%20%28HD%29.mp4';
    const app = runtime({ page: `<a class="btn-fast" href="${decoy}">FAST CLOUD</a>` });
    assert.equal((await app.load()).errorCode, 'STREAM_EMPTY');
    assert.equal((await app.load({ links: [{ href: decoy }] })).errorCode, 'STREAM_EMPTY');
});

test('rejects redirects to the decoy mp4', async () => {
    const app = runtime({ page: '<a class="btn-fast" href="/fc/test">FAST CLOUD</a>', get(url) {
        if (url.endsWith('/fc/test')) return response('', { finalUrl: 'https://pub-example.r2.dev/Watch%20Online%20%28HD%29.mp4' });
    } });
    assert.equal((await app.load()).errorCode, 'CLOUD_SESSION_ERROR');
    assert.ok(app.logs.some(line => line.includes('Rejected decoy redirect')));
});

test('reports placeholder redirects after successful verification even with both cookies', async () => {
    const app = runtime({
        get(url, headers) {
            if (url === host + '/f/child') {
                assert.match(headers.Cookie, /cf_pass=verified/);
                assert.match(headers.Cookie, /ci_session=session/);
                return response('', {finalUrl: 'https://pub-example.r2.dev/Watch%20Online%20%28HD%29.mp4'});
            }
        },
        post(url) {
            if (url === root + '/unlock') return response({ok:true,html:'<a class="btn-fast" href="/f/child">FAST CLOUD</a>'}, {
                headers: {'set-cookie':['cf_pass=verified; Path=/; Secure','ci_session=session; Path=/; Secure']}
            });
        }
    });
    const result = await app.load();
    assert.equal(result.errorCode, 'CLOUD_SESSION_ERROR');
    assert.match(result.message, /placeholder video/);
    assert.ok(app.logs.some(line => line.includes('"verificationCookie":true,"sessionCookie":true')));
    assert.ok(app.logs.every(line => !/cf_pass=|ci_session=/.test(line)));
});

test('a decoy candidate does not discard working streams from other links', async () => {
    const app = runtime({
        page: '<a class="btn-fast" href="/f/child">FAST CLOUD</a>',
        get(url) {
            if (url === host + '/f/child') return response('', {finalUrl: 'https://pub-example.r2.dev/Watch%20Online%20%28HD%29.mp4'});
        }
    });
    const result = await app.load({links:[{href:root},{href:media}]});
    assert.equal(result.success, true);
    assert.equal(result.data.length, 1);
    assert.equal(result.data[0].url, media);
});

test('HTTP cloud links use HTTPS for the captcha page, nonce, verification and children', async () => {
    const app = runtime({
        unlocked: `<a class="btn-fast" href="http://new5.cinecloud.site/f/child">FAST CLOUD</a>`,
        get(url, headers) {
            assert.ok(url.startsWith('https://'));
            if (url === host + '/f/child') {
                assert.equal(headers.Referer, root);
                assert.match(headers.Cookie, /cf_pass=verified/);
                return response('', { finalUrl: media, headers: { 'content-type': 'video/mp4' } });
            }
        },
        post(url, headers) {
            assert.equal(headers.Origin, host);
            assert.equal(headers.Referer, root);
            return response({ok: true, html: `<a class="btn-fast" href="http://new5.cinecloud.site/f/child">FAST CLOUD</a>`}, {
                finalUrl: url,
                headers: {'set-cookie': ['cf_pass=verified; Path=/; Secure']}
            });
        }
    });
    const result = await app.load(root.replace('https:', 'http:'));
    assert.equal(result.success, true, result.message);
    assert.equal(result.data[0].url, media);
    assert.equal(app.solves[0].url, root);
    assert.ok(app.calls.every(call => call.url.startsWith('https://')));
});

test('direct download redirects resolve without an HTML response body', async () => {
    const app = runtime({
        unlocked: '<a class="btn-fast" href="/f/download">FAST CLOUD</a>',
        get(url) {
            if (url === host + '/f/download') return response('', {
                finalUrl: 'https://files.example.com/download?id=signed',
                headers: { 'content-type': 'application/octet-stream', 'content-disposition': 'attachment; filename="movie.mkv"' }
            });
        }
    });
    const result = await app.load();
    assert.equal(result.success, true, result.message);
    assert.equal(result.data[0].url, 'https://files.example.com/download?id=signed');
});

test('follows nested file pages and stops cycles', async () => {
    const app = runtime({ page: '<a class="btn-fast" href="/f/child">FAST CLOUD</a>', get(url) {
        if (url.endsWith('/f/child')) return response(`<a class="btn-fast" href="${root}">FAST CLOUD</a><a class="fsl-btn" href="${media}">Download</a>`);
    } });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.equal(app.calls.length, 2);
});

test('keeps plain external FSL download links playable', async () => {
    const target = 'https://downloads.example.com/file?id=opaque';
    const app = runtime({ page: `<a class="btn-fast" href="${target}">FAST CLOUD</a>` });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.equal(result.data[0].url, target);
});

test('preserves captcha cancellation and can retry later', async () => {
    let attempt = 0;
    const app = runtime({ unlocked: `<a class="btn-fast" href="${media}">FAST CLOUD</a>`, solve() {
        if (++attempt === 1) throw 'Cancelled';
        return 'fresh-token';
    } });
    assert.equal((await app.load()).errorCode, 'CAPTCHA_ERROR');
    assert.equal((await app.load()).success, true);
});

test('watch fallback remains available when downloads are empty', async () => {
    const app = runtime({ page: '', watch: `<iframe src="/embed?id=${encodeURIComponent(media)}"></iframe>` });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.equal(result.data[0].url, media);
});

test('root file redirects can resolve directly without parsing binary media as HTML', async () => {
    const app = runtime({ get(url) {
        if (url === root) return response('binary media', { finalUrl: media });
    } });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.equal(result.data[0].url, media);
    assert.equal(app.calls.length, 1);
});

test('instant gate rejections remain captcha errors and are not cached', async () => {
    const app = runtime({ page: `<div data-sitekey="${key}"></div>`, post(url) {
        if (url === root) return response({ ok: false, message: 'Invalid token' });
    } });
    assert.equal((await app.load()).errorCode, 'CAPTCHA_ERROR');
    assert.equal((await app.load()).errorCode, 'CAPTCHA_ERROR');
    assert.equal(app.solves.length, 2);
});

test('verification cookies reach child GETs and playback POSTs without leaking to the player host', async () => {
    const app = runtime({
        unlocked: '<a class="btn-stream" href="/f/stream">Stream Online</a>',
        get(url, headers) {
            if (url === root) return response(challenge, { headers: { 'set-cookie': ['ci_session=first; Path=/; Secure; HttpOnly'] } });
            if (url === root + '/n') {
                assert.match(headers.Cookie, /ci_session=first/);
                return response({ n: 'nonce' });
            }
            if (url === 'https://player.example/embed') {
                assert.doesNotMatch(headers.Cookie, /ci_session=|cf_pass=/);
                return response(`<source src="${media}">`);
            }
        },
        post(url, headers) {
            if (url === root + '/unlock') {
                assert.match(headers.Cookie, /ci_session=first/);
                return response({ ok: true, html: '<a class="btn-stream" href="/f/stream">Stream Online</a>' }, { headers: { 'set-cookie': ['ci_session=updated; Path=/; Secure', 'cf_pass=verified; Path=/; Secure; HttpOnly; SameSite=Lax'] } });
            }
            if (url === host + '/f/stream') {
                assert.match(headers.Cookie, /ci_session=updated/);
                assert.match(headers.Cookie, /cf_pass=verified/);
                assert.doesNotMatch(headers.Cookie, /ci_session=first/);
                return response({ ok: true, url: 'https://player.example/embed' });
            }
        }
    });
    const result = await app.load();
    assert.equal(result.success, true);
    assert.doesNotMatch(result.data[0].headers.Cookie, /ci_session=|cf_pass=/);
});

test('cookie paths, deletion, combined headers, and foreign domains are honored', async () => {
    const app = runtime({
        get(url, headers) {
            if (url === root) return response(challenge, { headers: { 'set-cookie': 'session=first; Path=/; Expires=Wed, 21 Oct 2037 00:00:00 GMT, private=hidden; Path=/private/, foreign=bad; Domain=evil.example; Path=/' } });
            if (url === root + '/n') {
                assert.match(headers.Cookie, /session=first/);
                assert.doesNotMatch(headers.Cookie, /private=|foreign=/);
                return response({ n: 'nonce' }, { headers: { 'set-cookie': ['session=deleted; Path=/; Max-Age=0'] } });
            }
        },
        post(url, headers) {
            if (url === root + '/unlock') {
                assert.doesNotMatch(headers.Cookie, /session=|private=|foreign=/);
                return response({ ok: true, html: `<a class="btn-fast" href="${media}">FAST CLOUD</a>` });
            }
        }
    });
    assert.equal((await app.load()).success, true);
});
