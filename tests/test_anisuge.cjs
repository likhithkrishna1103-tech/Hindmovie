// Run with: node tests/test_anisuge.cjs
const assert = require('node:assert/strict');
const fs = require('node:fs');
const path = require('node:path');
const vm = require('node:vm');
const crypto = require('node:crypto');
const plugin = fs.readFileSync(path.join(__dirname, '../Anisuge/plugin.js'), 'utf8');
function runtime(respond, bridgeOnly = false) {
  class Item { constructor(data) { Object.assign(this, data); } }
  const decrypt = (data, key, iv) => {
    const d = crypto.createDecipheriv('aes-256-cbc', Buffer.from(key, 'base64'), Buffer.from(iv, 'base64'));
    return Buffer.concat([d.update(Buffer.from(data, 'base64')), d.final()]).toString();
  };
  const ctx = {URL, Buffer, console: {log() {}}, btoa: s => Buffer.from(s, 'binary').toString('base64'),
    atob: s => Buffer.from(s, 'base64').toString('binary'),
    MultimediaItem: Item, Episode: Item, StreamResult: Item, Analytics: {logEvent() {}},
    manifest: {baseUrl: 'https://anisuge.tv'}, http_get: async (url, headers) => respond(url, headers),
    http_post: async () => {throw Error('Optional metadata disabled');},
    crypto: bridgeOnly ? {} : {decryptAES: async (...args) => decrypt(...args)},
    sendMessage: async (id, input) => {
      assert.equal(id, 'crypto_decrypt_aes');
      const {data, key, iv} = JSON.parse(input); return decrypt(data, key, iv);
    }};
  vm.createContext(ctx);
  vm.runInContext(plugin, ctx);
  return ctx;
}
const result = (ctx, func, ...args) => new Promise(resolve => ctx[func](...args, resolve));
const movie = '<a class="poster" href="/anime/demo-film/ep-1"><img data-src="/movie.jpg"></a><span class="type">Movie</span><div class="name"><a href="/anime/demo-film/ep-1">Demo Movie</a></div>';
const series = '<a class="item" href="/anime/demo-series"><div class="poster"><img data-src="/series.jpg"></div><p class="name">Demo Series</p><span class="type">TV</span></a>';
const home = '<section><div class="heading"><h2>Latest Episode</h2></div>'+movie+series+'</section>';
const watch = '<div class="container watch-wrap" data-url="https://anisuge.tv/anime/demo-series" data-id="42"></div><div id="media-info"><h1 class="title">Demo Series</h1><img src="/series.jpg"></div>';
const episodes = '<a title="Opening Story" data-num="Opening Story" data-slug="1" data-ids="episode-servers" data-sub="1">1</a><a data-slug="12" data-num="Finale" data-ids="finale-servers">12</a>';
const servers = '<div class="type" data-type="sub"><div class="server" data-link-id="server-id"><div><span>HD-1</span></div></div></div>';
const master = '#EXTM3U\n#EXT-X-STREAM-INF:RESOLUTION=1280x720,CODECS="avc1.64001f,mp4a.40.2"\n720/index.m3u8\n';
function encryptedSources() {
  const key = Buffer.alloc(32); key.write('i?LMTAx0Q6,:}50U');
  const c = crypto.createCipheriv('aes-256-cbc', key, Buffer.from("W0;27ToaUpl_P%'c"));
  return Buffer.concat([c.update(JSON.stringify({file:'https://media.example/master.m3u8'})), c.final()]).toString('base64url');
}
const body = value => ({status: 200, body: typeof value === 'string' ? value : JSON.stringify(value)});
function site(url) {
  if (url.endsWith('/home')) return body(home);
  if (url.includes('/filter?')) return body(movie+series);
  if (url.includes('/ajax/episode/list/42')) return body({status:200, result:episodes});
  if (url.includes('/ajax/server/list?')) return body({status:200, result:servers});
  if (url.includes('/ajax/server?get=')) return body({status:200, result:{url:'https://megaplay.buzz/stream/s-2/123/sub?s=tcdn'}});
  if (url.includes('/stream/getSourcesNew?')) {
    assert.match(url, /id=321&platform=OTHER/);
    assert.doesNotMatch(url, /[?&]s=tcdn/);
    return body({enc:encryptedSources(), tracks:[{kind:'captions',label:'English',file:'https://media.example/en.vtt'}]});
  }
  if (url.includes('megaplay.buzz/stream/s-2/')) return body('<title>File 321 - MegaPlay</title>');
  if (url === 'https://media.example/master.m3u8') return body(master);
  if (url.includes('/anime/demo-series')) return body(watch);
  return {status:404, body:'Not found'};
}
(async () => {
  for (const bridgeOnly of [false, true]) {
    const ctx = runtime(site, bridgeOnly);
    const h = await result(ctx, 'getHome'); assert.equal(h.success, true);
    assert.deepEqual(Array.from(h.data['Latest Episode'], i=>i.type), ['movie','anime']);
    assert.equal(h.data['Latest Episode'][0].posterUrl, 'https://anisuge.tv/movie.jpg');
    const s = await result(ctx, 'search', 'Demo'); assert.equal(s.success, true); assert.equal(s.data.length, 2);
    const l = await result(ctx, 'load', s.data[1].url); assert.equal(l.success, true);
    assert.deepEqual(Array.from(l.data.episodes, e=>e.episode), [1,12]);
    assert.equal(l.data.episodes[0].name, 'Opening Story');
    const st = await result(ctx, 'loadStreams', l.data.episodes[0].url); assert.equal(st.success, true, st.message);
    assert.equal(st.data.length, 2); assert.equal(st.data[0].quality, 720);
    assert.equal(st.data[0].url, 'https://media.example/720/index.m3u8');
    assert.equal(st.data[0].subtitles[0].language, 'English');
  }
  const legacy = runtime(url=>body(home.replaceAll('/anime/', '/watch/').replaceAll('class="type"', 'class="dot"')));
  assert.equal((await result(legacy,'search','Demo')).data[0].type,'movie');
  const blocked = runtime(()=>({statusCode:403,body:'Forbidden'}));
  const error = await result(blocked,'getHome'); assert.equal(error.success,false); assert.match(error.message,/HTTP 403/);
  const empty = runtime(()=>body('<html>No cards</html>'));
  assert.equal((await result(empty,'getHome')).success,false);
  const unavailable = runtime(url=>url.includes('/ajax/server/list?') ? body({status:200,result:''}) : site(url));
  const l = await result(unavailable,'load','https://anisuge.tv/anime/demo-series');
  const st = await result(unavailable,'loadStreams',l.data.episodes[0].url);
  assert.equal(st.success,false); assert.equal(st.errorCode,'STREAM_ERROR');
  const invalid = runtime(url=>url.includes('/stream/getSourcesNew?') ? body({enc:'bad'}) : site(url));
  const il = await result(invalid,'load','https://anisuge.tv/anime/demo-series');
  const ist = await result(invalid,'loadStreams',il.data.episodes[0].url);
  assert.equal(ist.success,false); assert.match(ist.message,/decryption|decrypt|block length/);
  console.log('PASS: current and legacy cards, episode titles/numbers, native and bridge source decryption, qualities/subtitles, HTTP errors, empty home/servers, invalid sources');
})().catch(e=>{console.error(e);process.exitCode=1;});
