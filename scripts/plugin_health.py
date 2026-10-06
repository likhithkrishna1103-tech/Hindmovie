#!/usr/bin/env python3
"""Run the real SkyStream CLI and independently verify its returned media."""
import argparse
import base64
import concurrent.futures
import datetime as dt
import functools
import hashlib
import http.server
import json
import os
from pathlib import Path
import re
import shutil
import signal
import subprocess
import sys
import threading
import time
import urllib.error
import urllib.parse
import urllib.request

ANSI = re.compile(r'\x1b\[[0-?]*[ -/]*[@-~]')
URL_PATTERN = re.compile(r'https?://[^\s<>"\']+')
EXCLUDED_PLUGINS = frozenset(('playeztvliveevents', 'playztv'))


def run_process(command, timeout):
    start = time.monotonic()
    process = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                               text=True, errors='replace', start_new_session=True)
    timed_out = False
    try:
        stdout, stderr = process.communicate(timeout=timeout)
    except subprocess.TimeoutExpired:
        timed_out = True
        os.killpg(process.pid, signal.SIGKILL)
        stdout, stderr = process.communicate()
    return {'exit_code': process.returncode, 'stdout': stdout, 'stderr': stderr,
            'timed_out': timed_out, 'seconds': round(time.monotonic() - start, 2)}


def parse_cli_result(log):
    """Only parse the CLI callback block, never JSON inside plugin logging."""
    clean = ANSI.sub('', log)
    results = []
    for block in clean.split('--- Result ---')[1:]:
        offset = block.find('{')
        if offset < 0:
            continue
        try:
            result, _ = json.JSONDecoder().raw_decode(block[offset:])
            results.append(result)
        except json.JSONDecodeError:
            continue
    if len(results) != 1:
        raise ValueError(f'Expected one callback response; found {len(results)}')
    return results[0]


def items_from(data):
    if isinstance(data, list):
        return data
    if isinstance(data, dict):
        return [item for group in data.values() if isinstance(group, list) for item in group]
    return []


def validate_response(function, response):
    if not isinstance(response, dict) or response.get('success') is not True:
        return response.get('errorCode', 'PLUGIN_ERROR') if isinstance(response, dict) else 'INVALID_RESPONSE'
    data = response.get('data')
    if function == 'getHome':
        if not isinstance(data, (dict, list)):
            return 'INVALID_SCHEMA'
        items = items_from(data)
    elif function in ('search', 'loadStreams'):
        if not isinstance(data, list):
            return 'INVALID_SCHEMA'
        items = data
    else:
        if not isinstance(data, dict) or not data.get('title') or not data.get('url'):
            return 'INVALID_SCHEMA'
        return None
    if not items:
        return 'EMPTY_RESPONSE'
    for item in items:
        if not isinstance(item, dict) or not isinstance(item.get('url'), str) or not item['url'].strip():
            return 'INVALID_SCHEMA'
        if function != 'loadStreams' and not item.get('title'):
            return 'INVALID_SCHEMA'
    return None


def expiry_timestamp(url):
    parts = urllib.parse.urlsplit(url)
    query = {k.lower(): v[-1] for k, v in urllib.parse.parse_qs(parts.query).items()}
    values = [query[k] for k in ('expire', 'expires', 'exp', 'expiry') if k in query]
    values += re.findall(r'/(?:expire|expires)/(\d{9,})(?:/|$)', parts.path, flags=re.I)
    expiry = []
    for value in values:
        try:
            number = float(value)
            if number > 1e12:
                number /= 1000
            if number > 1e8:
                expiry.append(number)
        except ValueError:
            try:
                date = dt.datetime.fromisoformat(value.replace('Z', '+00:00'))
                if date.tzinfo:
                    expiry.append(date.timestamp())
            except ValueError:
                pass
    if 'x-amz-date' in query and 'x-amz-expires' in query:
        try:
            date = dt.datetime.strptime(query['x-amz-date'], '%Y%m%dT%H%M%SZ').replace(tzinfo=dt.timezone.utc)
            expiry.append(date.timestamp() + int(query['x-amz-expires']))
        except ValueError:
            pass
    return min(expiry) if expiry else None


def expiry_status(url, margin=60, now=None):
    expiry = expiry_timestamp(url)
    current = time.time() if now is None else now
    if expiry is not None and expiry <= current:
        return 'EXPIRED'
    if expiry is not None and expiry <= current + margin:
        return 'EXPIRING'
    return None


def safe_url(url):
    try:
        parts = urllib.parse.urlsplit(url)
        # YouTube puts signatures and IP addresses in path components too.
        if '/api/manifest/' in parts.path or '/videoplayback' in parts.path:
            return f'{parts.scheme}://{parts.hostname}/[signed-media-url]'
        return urllib.parse.urlunsplit((parts.scheme, parts.hostname or '', parts.path, '', ''))
    except ValueError:
        return '[invalid URL]'


def safe_text(text):
    return URL_PATTERN.sub(lambda match: safe_url(match.group()), str(text))[:1200]


class InlinePlaylists:
    """Model SkyStream's magic_m3u8 loopback serving for FFmpeg."""
    def __init__(self):
        self.playlists = {}
        playlists = self.playlists

        class Handler(http.server.BaseHTTPRequestHandler):
            def do_GET(self):
                body = playlists.get(self.path)
                if body is None:
                    self.send_error(404)
                    return
                self.send_response(200)
                self.send_header('Content-Type', 'application/vnd.apple.mpegurl')
                self.send_header('Content-Length', str(len(body)))
                self.end_headers()
                self.wfile.write(body)

            def log_message(self, *args):
                pass

        self.server = http.server.ThreadingHTTPServer(('127.0.0.1', 0), Handler)
        self.thread = threading.Thread(target=self.server.serve_forever, daemon=True)
        self.thread.start()

    def add(self, body):
        key = '/' + hashlib.sha256(body).hexdigest() + '.m3u8'
        self.playlists[key] = body
        return f'http://127.0.0.1:{self.server.server_port}{key}'

    def close(self):
        self.server.shutdown()
        self.server.server_close()
        self.thread.join()


def playlist_links(text, base):
    links = []
    for line in text.splitlines():
        line = line.strip()
        if not line:
            continue
        values = re.findall(r'URI="([^"]+)"', line) if line.startswith('#') else [line]
        for value in values:
            links.append(urllib.parse.urljoin(base, value))
    return links


@functools.lru_cache(maxsize=2)
def hls_demuxer_args(binary):
    """Judge remote HLS by decoded media, not the CDN's segment suffixes."""
    help_result = run_process([binary, '-hide_banner', '-h', 'demuxer=hls'], 10)
    help_text = help_result['stdout'] + help_result['stderr']
    args = ['-allowed_extensions', 'ALL']
    if '-allowed_segment_extensions ' in help_text:
        args += ['-allowed_segment_extensions', 'ALL']
    if '-extension_picky ' in help_text:
        args += ['-extension_picky', '0']
    return args


def check_stream(stream, options, inline):
    result = {'source': str(stream.get('source', stream.get('quality', 'Auto'))),
              'quality': stream.get('quality'), 'status': 'INVALID_URL', 'decoded': False}
    url = stream.get('url', '')
    if not isinstance(url, str) or not url:
        return result
    headers = stream.get('headers') or {}
    if not isinstance(headers, dict) or any('\n' in str(k) + str(v) or '\r' in str(k) + str(v) for k, v in headers.items()):
        return {**result, 'status': 'INVALID_HEADERS'}
    headers = {str(k): str(v) for k, v in headers.items()}
    if not any(k.lower() == 'user-agent' for k in headers):
        headers['User-Agent'] = 'Mozilla/5.0'
    body = None
    try:
        if url.startswith('MAGIC_PROXY_v1'):
            encoded = url[len('MAGIC_PROXY_v1'):].lstrip(':')
            url = base64.b64decode(encoded, validate=True).decode('utf-8')
        if url.startswith('magic_m3u8:'):
            body = base64.b64decode(url.split(':', 1)[1], validate=True)
            text = body.decode('utf-8-sig')
            if not text.lstrip().startswith('#EXTM3U'):
                raise ValueError('Inline content is not an HLS playlist')
            links = playlist_links(text, '')
            if not links or any(urllib.parse.urlsplit(link).scheme not in ('http', 'https') for link in links):
                raise ValueError('Inline playlist needs absolute HTTP(S) media URLs')
            for link in links:
                status = expiry_status(link, options.expiry_margin)
                if status:
                    return {**result, 'status': status, 'url': 'magic_m3u8:[inline]', 'detail': 'An embedded media URL expires too soon'}
            url = inline.add(body)
            result['url'] = 'magic_m3u8:[inline]'
        else:
            scheme = urllib.parse.urlsplit(url).scheme.lower()
            result['url'] = safe_url(url)
            if scheme not in ('http', 'https'):
                return {**result, 'status': 'UNVERIFIED_SCHEME', 'detail': f'{scheme or "missing"} is not checked by this HTTP tester'}
            if not urllib.parse.urlsplit(url).hostname:
                raise ValueError('Missing hostname')
            status = expiry_status(url, options.expiry_margin)
            if status:
                return {**result, 'status': status}
        request_headers = {**headers, 'Range': 'bytes=0-65535', 'Accept-Encoding': 'identity'}
        request = urllib.request.Request(url, headers=request_headers)
        with urllib.request.urlopen(request, timeout=options.stream_timeout) as response:
            result['http_status'] = response.status
            prefix = response.read(65536)
            content_type = response.headers.get_content_type()
            final_url = response.url
        if prefix.lstrip().lower().startswith((b'<!doctype html', b'<html')) or content_type == 'text/html':
            return {**result, 'status': 'HTML_INSTEAD_OF_MEDIA'}
        status = expiry_status(final_url, options.expiry_margin)
        if status:
            return {**result, 'status': status}
        if prefix.lstrip().startswith(b'#EXTM3U'):
            for link in playlist_links(prefix.decode('utf-8', errors='replace'), final_url):
                status = expiry_status(link, options.expiry_margin)
                if status:
                    return {**result, 'status': status, 'detail': 'A manifest contains an expired media URL'}
        if any(stream.get(k) for k in ('licenseUrl', 'drmKid', 'drmKey')):
            return {**result, 'status': 'DRM_UNVERIFIED', 'detail': 'HTTP accessible; requires device DRM verification'}
        ff_headers = ''.join(f'{key}: {value}\r\n' for key, value in headers.items())
        network_args = ['-protocol_whitelist', 'http,https,tcp,tls,crypto',
                        '-rw_timeout', str(options.stream_timeout * 1000000), '-headers', ff_headers]
        is_hls = prefix.lstrip().startswith(b'#EXTM3U')
        probe_hls_args = hls_demuxer_args('ffprobe') if is_hls else []
        probe = run_process(['ffprobe', '-v', 'error', *network_args, *probe_hls_args, '-show_entries',
                             'stream=codec_type,codec_name,width,height', '-of', 'json', url], options.stream_timeout)
        if probe['timed_out']:
            return {**result, 'status': 'PROBE_TIMEOUT'}
        if probe['exit_code']:
            return {**result, 'status': 'PROBE_FAILED', 'detail': safe_text(probe['stderr'])}
        tracks = json.loads(probe['stdout']).get('streams', [])
        result['tracks'] = tracks
        types = {track.get('codec_type') for track in tracks}
        if 'video' not in types:
            return {**result, 'status': 'NO_VIDEO'}
        if 'audio' not in types and not options.allow_silent:
            return {**result, 'status': 'VIDEO_ONLY', 'detail': 'The single URL contains no audio; separate audioTracks cannot establish playback'}
        if options.decode_seconds:
            maps = ['-map', '0:v:0'] + (['-map', '0:a:0'] if 'audio' in types else [])
            decode_hls_args = hls_demuxer_args('ffmpeg') if is_hls else []
            decoded = run_process(['ffmpeg', '-nostdin', '-v', 'error', '-xerror', *network_args, *decode_hls_args, '-i', url,
                                   '-t', str(options.decode_seconds), *maps, '-progress', 'pipe:1',
                                   '-f', 'null', '-'], options.stream_timeout)
            if decoded['timed_out']:
                return {**result, 'status': 'DECODE_TIMEOUT'}
            if decoded['exit_code']:
                return {**result, 'status': 'DECODE_FAILED', 'detail': safe_text(decoded['stderr'])}
            frames = [int(value) for value in re.findall(r'^frame=(\d+)$', decoded['stdout'], flags=re.M)]
            if not frames or max(frames) == 0:
                return {**result, 'status': 'DECODE_FAILED', 'detail': 'No video frames were decoded'}
            result['decoded'] = True
        return {**result, 'status': 'OK'}
    except urllib.error.HTTPError as error:
        code = error.code
        error.close()
        return {**result, 'status': f'HTTP_{code}', 'detail': 'HTTP access denied or unavailable; expiry is not inferred from HTTP status'}
    except (TimeoutError, subprocess.TimeoutExpired) as error:
        return {**result, 'status': 'NETWORK_TIMEOUT', 'detail': safe_text(error)}
    except urllib.error.URLError as error:
        return {**result, 'status': 'NETWORK_ERROR', 'detail': safe_text(error.reason)}
    except (ValueError, UnicodeError) as error:
        return {**result, 'status': 'INVALID_URL_OR_MEDIA', 'detail': safe_text(error)}
    except OSError as error:
        return {**result, 'status': 'TOOL_ERROR', 'detail': safe_text(error)}


def call_function(plugin, function, query, options, output):
    command = [options.cli, 'test', '-p', str(plugin), '-f', function]
    if function != 'getHome':
        command += ['-q', query]
    execution = run_process(command, options.function_timeout)
    log = execution['stdout'] + '\n' + execution['stderr']
    log_path = output / f'{function}-{hashlib.sha256(query.encode()).hexdigest()[:10]}.log'
    log_path.write_text(log)
    check = {'function': function, 'status': 'OK', 'seconds': execution['seconds'], 'log': log_path.name}
    if execution['timed_out']:
        return {**check, 'status': 'FUNCTION_TIMEOUT'}, None
    try:
        response = parse_cli_result(log)
        error = validate_response(function, response)
        check['status'] = error or ('CLI_ERROR' if execution['exit_code'] else 'OK')
        if response.get('message'):
            check['detail'] = safe_text(response['message'])
        if function != 'load':
            check['items'] = len(items_from(response.get('data')))
        log_path.with_suffix('.json').write_text(json.dumps(response, indent=2, ensure_ascii=False))
        return check, response
    except ValueError as error:
        return {**check, 'status': 'CLI_ERROR' if execution['exit_code'] else 'NO_CALLBACK', 'detail': str(error)}, None


def episode_urls(data):
    episodes = data.get('episodes') or []
    if isinstance(episodes, dict):
        episodes = [episode for group in episodes.values() if isinstance(group, list) for episode in group]
    return [item['url'] for item in episodes if isinstance(item, dict) and isinstance(item.get('url'), str) and item['url']]


def content_kind(item, section=''):
    kind = str(item.get('type') or item.get('contentType') or '').lower().replace('_', '').replace('-', '')
    if kind in ('livestream', 'live', 'channel', 'channels', 'playlist', 'collection'):
        return None
    if kind in ('series', 'tv', 'tvseries', 'tvshow', 'show', 'animegroup'):
        return 'series'
    if kind in ('movie', 'film', 'animemovie'):
        return 'movie'
    hints = ' '.join(str(item.get(key, '')) for key in ('format', 'mediaType', 'title')) + ' ' + section
    if re.search(r'\b(movie|movies|film|films)\b', hints, re.I):
        return 'movie'
    if kind == 'anime' or re.search(r'\b(series|season|seasons|episode|episodes|shows)\b', hints, re.I):
        return 'series'
    return None


def home_samples(data, per_type=1):
    groups = data.items() if isinstance(data, dict) else [('', data)]
    buckets = {'movie': [], 'series': []}
    seen = set()
    for section, items in groups:
        if not isinstance(items, list):
            continue
        for item in items:
            if not isinstance(item, dict) or not item.get('title') or not isinstance(item.get('url'), str) or not item['url']:
                continue
            kind = content_kind(item, str(section))
            if kind is None or item['url'] in seen or len(buckets[kind]) >= per_type:
                continue
            seen.add(item['url'])
            buckets[kind].append({'kind': kind, 'title': item['title'], 'url': item['url'],
                                  'section': str(section), 'origin': 'getHome'})
    samples = buckets['movie'] + buckets['series']
    missing = [kind for kind, items in buckets.items() if not items]
    return samples, missing


def test_plugin(plugin, options, config, inline):
    manifest = json.loads((plugin / 'plugin.json').read_text())
    output = options.output / plugin.name
    output.mkdir(parents=True, exist_ok=True)
    report = {'plugin': plugin.name, 'name': manifest.get('name'), 'version': manifest.get('version'),
              'functions': [], 'streams': [], 'samples': [], 'warnings': []}
    settings = config.get(plugin.name, {})
    home_check, home = call_function(plugin, 'getHome', '', options, output)
    report['functions'].append(home_check)
    samples, missing = home_samples((home or {}).get('data'), options.max_items)
    home_title = samples[0]['title'] if samples else 'movie'
    query = options.query or settings.get('search_query') or home_title[:100]
    search_check, search = call_function(plugin, 'search', query, options, output)
    report['functions'].append(search_check)
    if options.url:
        # Explicit local troubleshooting remains available; the workflow always
        # samples getHome and does not expose this override.
        samples = [{'kind': 'manual', 'title': 'Manual sample', 'url': options.url, 'section': '', 'origin': 'manual'}]
        missing = []
    report['samples'] = samples
    for kind in missing:
        report['samples'].append({'kind': kind, 'status': 'UNAVAILABLE_IN_HOME', 'origin': 'getHome'})
        report['warnings'].append(f'No {kind} sample is available in the home response')
    candidates = [sample for sample in report['samples'] if sample.get('url')]
    if not candidates:
        report['functions'] += [{'function': f, 'status': 'NO_SAMPLE_URL'} for f in ('load', 'loadStreams')]
    for sample in candidates:
        candidate = sample['url']
        label = {'sample_kind': sample['kind'], 'sample_title': sample['title']}
        sample['status'] = 'FAIL'
        load_check, loaded = call_function(plugin, 'load', candidate, options, output)
        load_check.update(label)
        report['functions'].append(load_check)
        if load_check['status'] != 'OK':
            report['functions'].append({'function': 'loadStreams', 'status': 'SKIPPED_LOAD_FAILED', **label})
            continue
        data = (loaded or {}).get('data')
        episode = episode_urls(data) if isinstance(data, dict) else []
        if sample['kind'] == 'series' and not episode:
            report['functions'].append({'function': 'loadStreams', 'status': 'NO_EPISODES', **label})
            continue
        target = episode[0] if episode else candidate
        sample['stream_input'] = target
        stream_check, response = call_function(plugin, 'loadStreams', target, options, output)
        stream_check.update(label)
        report['functions'].append(stream_check)
        if stream_check['status'] != 'OK':
            continue
        streams = response['data']
        if options.max_streams and len(streams) > options.max_streams:
            report['warnings'].append(f'Checked only {options.max_streams} of {len(streams)} returned streams')
            streams = streams[:options.max_streams]
        with concurrent.futures.ThreadPoolExecutor(max_workers=options.stream_workers) as pool:
            checked = list(pool.map(lambda stream: {**check_stream(stream, options, inline), **label}, streams))
        report['streams'].extend(checked)
        sample['status'] = 'PASS' if all(stream['status'] == 'OK' for stream in checked) else 'WARN' if all(stream['status'] in ('OK', 'DRM_UNVERIFIED', 'UNVERIFIED_SCHEME') for stream in checked) else 'FAIL'
    failures = [item for item in report['functions'] if item['status'] != 'OK']
    failures += [item for item in report['streams'] if item['status'] not in ('OK', 'DRM_UNVERIFIED', 'UNVERIFIED_SCHEME')]
    warnings = report['warnings'] or any(item['status'] != 'OK' for item in report['streams'])
    report['status'] = 'FAIL' if failures else 'WARN' if warnings else 'PASS'
    (output / 'report.json').write_text(json.dumps(report, indent=2, ensure_ascii=False))
    return report


def markdown_report(reports):
    def cell(value):
        return safe_text(value).replace('|', '\\|').replace('\n', ' ').replace('\r', ' ').replace('<', '&lt;').replace('>', '&gt;')
    lines = ['# Plugin health report', '', f'UTC: {dt.datetime.now(dt.timezone.utc).isoformat()}', '',
             'PASS verifies only the sampled items at test time. It does not certify every episode or device.', '',
             '| Plugin | Result | Functions | Streams OK / checked |', '| --- | --- | --- | --- |']
    for report in reports:
        checked = report['streams']
        functions = ', '.join(f'{item["function"]}' + (f' ({item["sample_kind"]})' if item.get('sample_kind') else '') + f': {item["status"]}' for item in report['functions'])
        lines.append(f'| {cell(report["plugin"])} | {report["status"]} | {cell(functions)} | {sum(s["status"] == "OK" for s in checked)} / {len(checked)} |')
    for report in reports:
        lines += ['', f'## {cell(report["plugin"])}', '', '| Home sample | Title | Result |', '| --- | --- | --- |']
        for sample in report.get('samples', []):
            lines.append(f'| {cell(sample["kind"])} | {cell(sample.get("title", "—"))} | {cell(sample["status"])} |')
        lines += ['', '| Sample | Source | Result | Decoded | Tracks / detail |', '| --- | --- | --- | --- | --- |']
        for stream in report['streams']:
            tracks = ', '.join(f'{t.get("codec_type")}: {t.get("codec_name")} {t.get("height", "")}' for t in stream.get('tracks', []))
            lines.append(f'| {cell(stream.get("sample_kind", ""))} | {cell(stream["source"])} | {stream["status"]} | {stream.get("decoded", False)} | {cell(stream.get("detail") or tracks)} |')
        for warning in report['warnings']:
            lines += ['', f'Warning: {cell(warning)}']
    return '\n'.join(lines) + '\n'


def select_plugins(repo, selection):
    plugins = {path.name: path for path in repo.iterdir() if path.is_dir() and (path / 'plugin.json').is_file() and not path.name.startswith('.') and path.name not in EXCLUDED_PLUGINS}
    names = sorted(plugins) if selection.strip().lower() == 'all' else list(dict.fromkeys(re.split(r'[,\s]+', selection.strip())))
    if not names or any(name not in plugins for name in names):
        raise ValueError(f'Unknown plugin selection. Available: {", ".join(sorted(plugins))}')
    return [plugins[name] for name in names]


def bounded_int(low, high):
    def parse(value):
        number = int(value)
        if not low <= number <= high:
            raise argparse.ArgumentTypeError(f'Must be between {low} and {high}')
        return number
    return parse


def main(argv=None):
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--repo', type=Path, default=Path(__file__).resolve().parents[1])
    parser.add_argument('--plugins', default=os.environ.get('HEALTH_PLUGINS', 'all'))
    parser.add_argument('--list', action='store_true', help='Print selected plugin folders as JSON without testing')
    parser.add_argument('--github-output', action='store_true', help='Write plugin selection to GITHUB_OUTPUT with --list')
    parser.add_argument('--query', default=os.environ.get('HEALTH_QUERY', ''))
    parser.add_argument('--url', default=os.environ.get('HEALTH_URL', ''))
    parser.add_argument('--max-items', type=bounded_int(1, 5), default=os.environ.get('HEALTH_MAX_ITEMS', '1'), help='Home samples per content type: 1 tests one movie and one series')
    parser.add_argument('--max-streams', type=bounded_int(0, 100), default=os.environ.get('HEALTH_MAX_STREAMS', '0'), help='0 checks every returned stream')
    parser.add_argument('--decode-seconds', type=bounded_int(0, 10), default=os.environ.get('HEALTH_DECODE_SECONDS', '3'))
    parser.add_argument('--function-timeout', type=bounded_int(5, 300), default=90)
    parser.add_argument('--stream-timeout', type=bounded_int(5, 120), default=40)
    parser.add_argument('--stream-workers', type=bounded_int(1, 4), default=2)
    parser.add_argument('--expiry-margin', type=bounded_int(0, 3600), default=60)
    parser.add_argument('--allow-silent', action='store_true', help='Allow video with no audio if silence is expected')
    parser.add_argument('--cli', default='skystream')
    parser.add_argument('--output', type=Path, default=Path('test-results/plugin-health'))
    options = parser.parse_args(argv)
    options.repo = options.repo.resolve()
    try:
        plugins = select_plugins(options.repo, options.plugins)
        if options.url and len(plugins) != 1:
            raise ValueError('--url requires selecting exactly one plugin')
        if options.list:
            selected = json.dumps([plugin.name for plugin in plugins])
            print(selected)
            if options.github_output:
                with open(os.environ['GITHUB_OUTPUT'], 'a') as handle:
                    handle.write('plugins=' + selected + '\n')
            return 0
        for executable in [options.cli, 'ffprobe'] + (['ffmpeg'] if options.decode_seconds else []):
            if not shutil.which(executable):
                raise ValueError(f'Missing executable: {executable}')
        config_path = options.repo / 'scripts' / 'plugin-health-config.json'
        config = json.loads(config_path.read_text()) if config_path.exists() else {}
    except (ValueError, OSError) as error:
        parser.error(str(error))
    options.output = options.output.resolve()
    options.output.mkdir(parents=True, exist_ok=True)
    reports = []
    inline = InlinePlaylists()
    try:
        for plugin in plugins:
            print(f'Testing {plugin.name}: getHome, search, load, loadStreams and media', flush=True)
            try:
                report = test_plugin(plugin, options, config, inline)
            except Exception as error:
                report = {'plugin': plugin.name, 'status': 'FAIL', 'functions': [{'function': 'runner', 'status': 'RUNNER_ERROR', 'detail': safe_text(error)}], 'streams': [], 'warnings': []}
            reports.append(report)
            print(f'{plugin.name}: {report["status"]}; {len(report["streams"])} streams checked', flush=True)
    finally:
        inline.close()
    summary = markdown_report(reports)
    (options.output / 'summary.md').write_text(summary)
    (options.output / 'report.json').write_text(json.dumps(reports, indent=2, ensure_ascii=False))
    if os.environ.get('GITHUB_STEP_SUMMARY'):
        with open(os.environ['GITHUB_STEP_SUMMARY'], 'a') as handle:
            handle.write(summary)
    print(f'Report: {options.output / "summary.md"}')
    return int(any(report['status'] == 'FAIL' for report in reports))


if __name__ == '__main__':
    sys.exit(main())
