import base64
import functools
import http.server
import importlib.util
import json
from pathlib import Path
import shutil
import subprocess
import sys
import tempfile
import threading
import types
import unittest
from unittest import mock

SPEC = importlib.util.spec_from_file_location('plugin_health', Path(__file__).resolve().parents[1] / 'scripts' / 'plugin_health.py')
health = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(health)


class ResponseTests(unittest.TestCase):
    def test_cli_failure_is_failure_even_with_exit_zero(self):
        log = '[JS LOG] {"success": true}\n--- Result ---\n\x1b[31mStatus: FAILED\x1b[0m\n{"success":false,"errorCode":"STREAM_ERROR"}\n'
        result = health.parse_cli_result(log)
        self.assertEqual(health.validate_response('loadStreams', result), 'STREAM_ERROR')

    def test_empty_success_and_invalid_schema_fail(self):
        for function, data in [('getHome', {'Trending': []}), ('search', []), ('loadStreams', [])]:
            self.assertEqual(health.validate_response(function, {'success': True, 'data': data}), 'EMPTY_RESPONSE')
        self.assertEqual(health.validate_response('loadStreams', {'success': True, 'data': [{'source': 'broken'}]}), 'INVALID_SCHEMA')

    def test_multiple_callbacks_do_not_pass(self):
        with self.assertRaises(ValueError):
            health.parse_cli_result('--- Result ---\n{}\n--- Result ---\n{}')

    def test_expiry_query_path_milliseconds_and_aws(self):
        self.assertEqual(health.expiry_status('https://cdn.test/v?expire=1700000000', now=1700000010), 'EXPIRED')
        self.assertEqual(health.expiry_status('https://cdn.test/expire/1700000020/v', now=1700000010), 'EXPIRING')
        self.assertEqual(health.expiry_status('https://cdn.test/v?expires=1700000000000', now=1700000010), 'EXPIRED')
        self.assertEqual(health.expiry_timestamp('https://cdn.test/v?X-Amz-Date=20240101T000000Z&X-Amz-Expires=3600'), 1704070800)
        self.assertIsNone(health.expiry_status('https://cdn.test/v', now=1700000010))

    def test_process_timeout_is_enforced(self):
        result = health.run_process([sys.executable, '-c', 'import time; time.sleep(10)'], 0.1)
        self.assertTrue(result['timed_out'])

    def test_episode_url_and_safe_url(self):
        self.assertEqual(health.episode_urls({'episodes': {'1': [{'url': 'episode-token'}]}}), ['episode-token'])
        self.assertNotIn('secret', health.safe_url('https://cdn.test/api/manifest/sig/secret?token=secret'))


class HomeSamplingTests(unittest.TestCase):
    def test_movie_and_series_are_selected_from_home(self):
        movie = {'title': 'Demo movie', 'url': 'movie-page', 'type': 'movie'}
        series = {'title': 'Demo series', 'url': 'series-page', 'type': 'series'}
        samples, missing = health.home_samples({'Trending': [movie, movie, series]})
        self.assertEqual([(s['kind'], s['url']) for s in samples], [('movie', 'movie-page'), ('series', 'series-page')])
        self.assertEqual(missing, [])
        self.assertTrue(all(s['origin'] == 'getHome' for s in samples))

    def test_one_sample_limit_is_per_type(self):
        data = [
            {'title': kind + str(i), 'url': kind + str(i), 'type': kind}
            for kind in ('movie', 'series') for i in range(3)
        ]
        samples, _ = health.home_samples(data, 2)
        self.assertEqual(len(samples), 4)
        self.assertEqual([s['kind'] for s in samples], ['movie', 'movie', 'series', 'series'])

    def test_anime_movies_and_series_are_distinguished(self):
        samples, missing = health.home_samples({
            'Anime Movies': [{'title': 'Demo film', 'type': 'anime', 'url': 'film'}],
            'Recently Updated': [{'title': 'Demo anime', 'type': 'anime', 'url': 'show'}],
        })
        self.assertEqual([s['kind'] for s in samples], ['movie', 'series'])
        self.assertEqual(missing, [])

    def test_absent_type_is_reported_without_inventing_a_sample(self):
        samples, missing = health.home_samples([{'title': 'Movie', 'type': 'movie', 'url': 'film'}])
        self.assertEqual(len(samples), 1)
        self.assertEqual(missing, ['series'])

    def test_non_playable_types_are_not_mislabelled(self):
        samples, missing = health.home_samples({'Movies': [
            {'title': 'Live movie', 'type': 'livestream', 'url': 'live'},
            {'title': 'Unknown title', 'url': ''},
        ]})
        self.assertEqual(samples, [])
        self.assertEqual(missing, ['movie', 'series'])

    def test_all_selection_excludes_both_requested_plugins(self):
        with tempfile.TemporaryDirectory() as root:
            repo = Path(root)
            for name in ('youtube', 'hindmoviez', 'playeztvliveevents', 'playztv'):
                folder = repo / name
                folder.mkdir()
                (folder / 'plugin.json').write_text('{}')
            self.assertEqual([p.name for p in health.select_plugins(repo, 'all')], ['hindmoviez', 'youtube'])
            with self.assertRaises(ValueError):
                health.select_plugins(repo, 'playztv')

    def test_series_with_no_episodes_fails_without_using_the_page_as_a_stream(self):
        with tempfile.TemporaryDirectory() as root:
            plugin = Path(root) / 'series-only'
            plugin.mkdir()
            (plugin / 'plugin.json').write_text('{}')
            item = {'title': 'Demo series', 'url': 'series-page', 'type': 'series'}
            def call(plugin, function, query, options, output):
                data = {'Trending': [item]} if function == 'getHome' else [item] if function == 'search' else {**item, 'episodes': []}
                return {'function': function, 'status': 'OK'}, {'success': True, 'data': data}
            options = types.SimpleNamespace(output=Path(root)/'output', max_items=1, query='', url='')
            with mock.patch.object(health, 'call_function', side_effect=call) as cli:
                report = health.test_plugin(plugin, options, {}, None)
            self.assertEqual(report['status'], 'FAIL')
            self.assertEqual(report['functions'][-1]['status'], 'NO_EPISODES')
            self.assertEqual(cli.call_count, 3)
            self.assertTrue(any(s['status'] == 'UNAVAILABLE_IN_HOME' for s in report['samples']))


class MediaTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        if not shutil.which('ffmpeg') or not shutil.which('ffprobe'):
            raise unittest.SkipTest('FFmpeg and FFprobe required for media integration tests')
        cls.temp = tempfile.TemporaryDirectory()
        cls.root = Path(cls.temp.name)
        command = ['ffmpeg', '-nostdin', '-v', 'error', '-f', 'lavfi', '-i', 'testsrc2=size=128x72:rate=10',
                   '-f', 'lavfi', '-i', 'sine=frequency=440:sample_rate=44100', '-t', '2',
                   '-c:v', 'libx264', '-threads', '1', '-c:a', 'aac', '-movflags', '+faststart']
        subprocess.run(command + [str(cls.root / 'av.mp4')], check=True, timeout=30)
        subprocess.run(['ffmpeg', '-nostdin', '-v', 'error', '-i', str(cls.root / 'av.mp4'), '-an', '-c:v', 'copy',
                        str(cls.root / 'silent.mp4')], check=True, timeout=30)
        subprocess.run(['ffmpeg', '-nostdin', '-v', 'error', '-i', str(cls.root / 'av.mp4'), '-c', 'copy',
                        '-f', 'hls', '-hls_time', '1', str(cls.root / 'media.m3u8')], check=True, timeout=30)
        disguised = (cls.root / 'media.m3u8').read_text()
        for segment in cls.root.glob('*.ts'):
            disguised_name = segment.with_suffix('.jpg')
            disguised_name.write_bytes(segment.read_bytes())
            disguised = disguised.replace(segment.name, disguised_name.name)
        (cls.root / 'disguised.m3u8').write_text(disguised)
        cls.requests = []
        requests = cls.requests

        class Handler(http.server.SimpleHTTPRequestHandler):
            def do_GET(self):
                requests.append(dict(self.headers))
                if self.path == '/forbidden':
                    self.send_error(403)
                elif self.path == '/html':
                    body = b'<html>Access denied</html>'
                    self.send_response(200)
                    self.send_header('Content-Type', 'text/html')
                    self.send_header('Content-Length', str(len(body)))
                    self.end_headers()
                    self.wfile.write(body)
                else:
                    super().do_GET()

            def log_message(self, *args):
                pass

        cls.server = http.server.ThreadingHTTPServer(('127.0.0.1', 0), functools.partial(Handler, directory=str(cls.root)))
        cls.thread = threading.Thread(target=cls.server.serve_forever, daemon=True)
        cls.thread.start()
        cls.base = f'http://127.0.0.1:{cls.server.server_port}'
        cls.inline = health.InlinePlaylists()
        cls.options = types.SimpleNamespace(expiry_margin=60, stream_timeout=10, decode_seconds=1, allow_silent=False)

    @classmethod
    def tearDownClass(cls):
        cls.inline.close()
        cls.server.shutdown()
        cls.server.server_close()
        cls.thread.join()
        cls.temp.cleanup()

    def check(self, path, **extra):
        return health.check_stream({'url': self.base + path, 'source': 'fixture', 'headers': {'Referer': 'https://required.test/'}, **extra}, self.options, self.inline)

    def test_audio_and_video_are_decoded_with_headers(self):
        result = self.check('/av.mp4')
        self.assertEqual(result['status'], 'OK', result)
        self.assertTrue(result['decoded'])
        self.assertTrue(any(r.get('Referer') == 'https://required.test/' for r in self.requests))

    def test_video_only_is_detected_even_with_separate_audio_field(self):
        result = self.check('/silent.mp4', audioTracks=[{'url': self.base + '/av.mp4'}])
        self.assertEqual(result['status'], 'VIDEO_ONLY')

    def test_http_403_is_not_labelled_expired(self):
        self.assertEqual(self.check('/forbidden')['status'], 'HTTP_403')
        self.assertEqual(self.check('/missing.mp4')['status'], 'HTTP_404')
        self.assertEqual(self.check('/html')['status'], 'HTML_INSTEAD_OF_MEDIA')

    def test_inline_hls_plays_as_a_single_url(self):
        master = f'#EXTM3U\n#EXT-X-STREAM-INF:BANDWIDTH=100000,CODECS="avc1.64001f,mp4a.40.2"\n{self.base}/media.m3u8\n'
        result = health.check_stream({'url': 'magic_m3u8:' + base64.b64encode(master.encode()).decode()}, self.options, self.inline)
        self.assertEqual(result['status'], 'OK', result)
        self.assertTrue(result['decoded'])

    def test_hls_with_image_segment_names_decodes_actual_video_and_audio(self):
        result = self.check('/disguised.m3u8')
        self.assertEqual(result['status'], 'OK', result)
        self.assertTrue(result['decoded'])

    def test_expired_inline_uri_and_proxy_url(self):
        master = '#EXTM3U\n#EXTINF:5,\nhttps://cdn.test/v?expire=1000000000\n'
        result = health.check_stream({'url': 'magic_m3u8:' + base64.b64encode(master.encode()).decode()}, self.options, self.inline)
        self.assertEqual(result['status'], 'EXPIRED')
        result = health.check_stream({'url': 'MAGIC_PROXY_v1' + base64.b64encode((self.base + '/av.mp4').encode()).decode()}, self.options, self.inline)
        self.assertEqual(result['status'], 'OK', result)

    def test_drm_and_unknown_schemes_are_unverified(self):
        self.assertEqual(self.check('/av.mp4', licenseUrl='https://license.test/')['status'], 'DRM_UNVERIFIED')
        result = health.check_stream({'url': 'magnet:?xt=urn:btih:123'}, self.options, self.inline)
        self.assertEqual(result['status'], 'UNVERIFIED_SCHEME')

    def test_end_to_end_reports_actual_function_and_stream_failure(self):
        repo = self.root / 'repo'
        plugin = repo / 'fixture'
        plugin.mkdir(parents=True, exist_ok=True)
        (plugin / 'plugin.json').write_text('{"name":"Fixture","version":1}')
        (plugin / 'plugin.js').write_text('// CLI stand-in does not execute this file')
        cli = self.root / 'skystream-fixture'
        cli.write_text(f'''#!{sys.executable}
import json,sys
function=sys.argv[sys.argv.index('-f')+1]
query=sys.argv[sys.argv.index('-q')+1] if '-q' in sys.argv else ''
with open({str(self.root / 'cli-invocations.jsonl')!r},'a') as log: log.write(json.dumps({{'function':function,'query':query}})+'\\n')
movie={{'title':'Home movie','url':'{self.base}/movie','type':'movie'}}
series={{'title':'Home series','url':'{self.base}/series','type':'series'}}
item=series if query.endswith('/series') else movie
data={{'Trending':[movie,series]}} if function=='getHome' else [{{'title':'Search outsider','url':'{self.base}/outsider','type':'movie'}}] if function=='search' else {{**item,'episodes':[{{'url':query+'-episode'}}]}} if function=='load' else [{{'url':'{self.base}/forbidden' if 'series-episode' in query else '{self.base}/av.mp4','source':'blocked' if 'series-episode' in query else 'valid'}}]
print('--- Result ---\\nStatus: SUCCESS\\n'+json.dumps({{'success':True,'data':data}}))
''')
        cli.chmod(0o755)
        output = self.root / 'results'
        code = health.main(['--repo', str(repo), '--plugins', 'fixture', '--cli', str(cli), '--output', str(output), '--decode-seconds', '1'])
        self.assertEqual(code, 1)
        report = json.loads((output / 'report.json').read_text())[0]
        self.assertEqual(report['status'], 'FAIL')
        self.assertEqual([c['status'] for c in report['functions']], ['OK'] * 6)
        self.assertEqual([c['status'] for c in report['streams']], ['OK', 'HTTP_403'])
        self.assertEqual([s['kind'] for s in report['samples']], ['movie', 'series'])
        calls = [json.loads(line) for line in (self.root / 'cli-invocations.jsonl').read_text().splitlines()]
        self.assertEqual([c['query'] for c in calls if c['function'] == 'load'], [self.base+'/movie', self.base+'/series'])
        self.assertEqual([c['query'] for c in calls if c['function'] == 'loadStreams'], [self.base+'/movie-episode', self.base+'/series-episode'])
        self.assertTrue((output / 'summary.md').is_file())


if __name__ == '__main__':
    unittest.main()
