(function () {
    function base64Decode(str) {
        var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var output = "";
        var bytes = [];
        for (var i = 0; i < str.length; i += 4) {
            var a = chars.indexOf(str[i]);
            var b = chars.indexOf(str[i + 1] || "=");
            var c = chars.indexOf(str[i + 2] || "=");
            var d = chars.indexOf(str[i + 3] || "=");
            bytes.push((a << 2) | (b >> 4));
            if (c !== -1 && str[i + 2] !== "=") bytes.push(((b & 15) << 4) | (c >> 2));
            if (d !== -1 && str[i + 3] !== "=") bytes.push(((c & 3) << 6) | d);
        }
        for (var j = 0; j < bytes.length; j++) output += String.fromCharCode(bytes[j]);
        return output;
    }

    const GA_MEASUREMENT_ID = base64Decode("Ry1IWDFNMEREVjhX");
    const GA_API_SECRET = base64Decode("ckNZeWhBUXJUaHFLZ2xiNmc4MGRiZw==");

    const SessionTracker = {
        clientId: null,
        init() { this.clientId = this.generateUuid(); },
        generateUuid() {
            return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random() * 16 | 0;
                return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
        }
    };
    SessionTracker.init();

    const Analytics = {
        clientId: null,
        measurementId: GA_MEASUREMENT_ID,
        apiSecret: GA_API_SECRET,
        queue: [],
        init() { this.clientId = SessionTracker.clientId; },
        logEvent(eventName, parameters) {
            console.log('[Analytics] Event: ' + eventName + ' | clientId: ' + this.clientId);
            if (!this.measurementId || !this.apiSecret) return;
            this.queue.push({ name: eventName, params: Object.assign({ session_id: this.clientId }, parameters || {}) });
            this.flushQueue();
        },
        async flushQueue() {
            if (this.queue.length === 0) return;
            var events = this.queue.splice(0);
            try {
                await http_post(
                    'https://www.google-analytics.com/mp/collect?measurement_id=' + this.measurementId + '&api_secret=' + this.apiSecret,
                    { 'Content-Type': 'application/json' },
                    JSON.stringify({ client_id: this.clientId, events: events })
                );
            } catch (e) { console.log('[Analytics] Send skipped'); }
        }
    };
    Analytics.init();

    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // var manifest is injected at runtime

    class JNode {
        constructor(tag, attrs, parent) {
            this.tag = tag || null;
            this.attrs = attrs || {};
            this.parent = parent || null;
            this.children = [];
            this.text = "";
        }
        attr(name) {
            return this.attrs[name] || "";
        }
        textContent() {
            var out = this.text || "";
            for (var i = 0; i < this.children.length; i++) out += this.children[i].textContent();
            return out;
        }
        matches(selector) {
            if (!this.tag) return false;
            selector = String(selector || "").trim();
            if (!selector) return false;
            if (selector.charAt(0) === "#") return this.attrs.id === selector.slice(1);
            if (selector.charAt(0) === ".") return classList(this.attrs.class).indexOf(selector.slice(1)) !== -1;
            if (selector.indexOf(".") !== -1) {
                var dot = selector.indexOf(".");
                return this.tag === selector.slice(0, dot) && classList(this.attrs.class).indexOf(selector.slice(dot + 1)) !== -1;
            }
            if (selector.indexOf("#") !== -1) {
                var hash = selector.indexOf("#");
                return this.tag === selector.slice(0, hash) && this.attrs.id === selector.slice(hash + 1);
            }
            return this.tag === selector;
        }
        selectFirst(selector) {
            for (var i = 0; i < this.children.length; i++) {
                var child = this.children[i];
                if (child.matches(selector)) return child;
                var nested = child.selectFirst(selector);
                if (nested) return nested;
            }
            return null;
        }
        find(selector) {
            return this.selectFirst(selector);
        }
        select(selector, out) {
            out = out || [];
            for (var i = 0; i < this.children.length; i++) {
                var child = this.children[i];
                if (child.matches(selector)) out.push(child);
                child.select(selector, out);
            }
            return out;
        }
    }

    class JsoupLite {
        constructor(html) {
            this.root = new JNode("root", {}, null);
            var current = this.root;
            var re = /<\/?[^>]+>|[^<]+/g;
            var match;
            while ((match = re.exec(String(html || "")))) {
                var token = match[0];
                if (token.indexOf("</") === 0) {
                    if (current.parent) current = current.parent;
                    continue;
                }
                if (token.charAt(0) === "<") {
                    var selfClosing = /\/>$/.test(token) || /^(?:<\s*)(br|img|input|meta|link|source|track)\b/i.test(token);
                    var clean = token.replace(/^<|\/?>$/g, "").trim();
                    if (!clean || clean.charAt(0) === "!") continue;
                    var spaceIndex = clean.search(/\s/);
                    var tag = (spaceIndex === -1 ? clean : clean.slice(0, spaceIndex)).toLowerCase();
                    var attrs = {};
                    var attrRe = /([:@\w-]+)(?:=(?:"([^"]*)"|'([^']*)'|([^\s"'=<>`]+)))?/g;
                    var attrMatch;
                    while ((attrMatch = attrRe.exec(clean))) {
                        if (attrMatch[1] === tag && attrMatch.index === 0) continue;
                        attrs[attrMatch[1]] = attrMatch[2] || attrMatch[3] || attrMatch[4] || "";
                    }
                    var node = new JNode(tag, attrs, current);
                    current.children.push(node);
                    if (!selfClosing) current = node;
                    continue;
                }
                var text = decodeHtml(token).replace(/\s+/g, " ").trim();
                if (text) {
                    var textNode = new JNode(null, {}, current);
                    textNode.text = text;
                    current.children.push(textNode);
                }
            }
        }
        find(selector) {
            return this.root.find(selector);
        }
        select(selector) {
            return this.root.select(selector, []);
        }
    }

    var BASE_URL = (manifest && manifest.baseUrl) || "https://animekai.be";
    var KAI_ENC = "https://enc-dec.app/api/enc-kai";
    var KAI_DEC = "https://enc-dec.app/api/dec-kai";
    var KAI_MEGA = "https://enc-dec.app/api/dec-mega";
    var MAIN_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36",
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Accept-Language": "en-US,en;q=0.9",
        "Referer": BASE_URL + "/",
        "Origin": BASE_URL
    };
    var AJAX_HEADERS = {
        "User-Agent": MAIN_HEADERS["User-Agent"],
        "Accept": "application/json, text/plain, */*",
        "Accept-Language": MAIN_HEADERS["Accept-Language"],
        "X-Requested-With": "XMLHttpRequest",
        "Referer": BASE_URL + "/",
        "Origin": BASE_URL
    };
    var MEGA_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:134.0) Gecko/20100101 Firefox/134.0",
        "Accept": "text/html, */*; q=0.01",
        "Accept-Language": "en-US,en;q=0.5",
        "Sec-GPC": "1",
        "Sec-Fetch-Dest": "empty",
        "Sec-Fetch-Mode": "cors",
        "Sec-Fetch-Site": "same-origin",
        "Priority": "u=0",
        "Pragma": "no-cache",
        "Cache-Control": "no-cache",
        "Referer": BASE_URL + "/"
    };
    var HOME_ROWS = [
        { name: "Trending", path: "/browse?keyword=&status[]=releasing&sort=trending" },
        { name: "Latest Episode", path: "/browse?keyword=&status[]=releasing&sort=updated_date" },
        { name: "Recently SUB", path: "/browse?keyword=&type[]=tv&status[]=releasing&sort=added_date&language[]=sub&language[]=softsub" },
        { name: "Recently DUB", path: "/browse?keyword=&type[]=tv&status[]=releasing&sort=added_date&language[]=dub" }
    ];
    var MEGA_HOST_RE = /(?:megaup\.(?:live|site|nl|cc)|4spromax\.site|megaup22\.online|rapidairmax\.site|rapidshare\.(?:cc|work))/i;

    function classList(value) {
        return String(value || "").split(/\s+/).filter(Boolean);
    }

    function parseJsonSafe(text, fallback) {
        try {
            return JSON.parse(String(text || ""));
        } catch (e) {
            return fallback;
        }
    }

    function decodeHtml(value) {
        return String(value || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ");
    }

    function cleanText(value) {
        return decodeHtml(String(value || "").replace(/<br\s*\/?>/gi, "\n").replace(/<\/p>/gi, "\n").replace(/<[^>]+>/g, " "))
            .replace(/\n{3,}/g, "\n\n")
            .replace(/[ \t]{2,}/g, " ")
            .trim();
    }

    function absoluteUrl(url, base) {
        url = String(url || "").trim();
        if (!url) return "";
        if (/^https?:\/\//i.test(url)) return url;
        if (url.indexOf("//") === 0) return "https:" + url;
        try {
            return new URL(url, base || BASE_URL).toString();
        } catch (e) {
            return url;
        }
    }

    function uniqueBy(list, keyFn) {
        var out = [];
        var seen = {};
        for (var i = 0; i < (list || []).length; i++) {
            var item = list[i];
            var key = keyFn(item);
            if (!key || seen[key]) continue;
            seen[key] = true;
            out.push(item);
        }
        return out;
    }

    function toInt(value) {
        var n = parseInt(String(value || "").replace(/[^\d]/g, ""), 10);
        return isNaN(n) ? 0 : n;
    }

    function getQuality(value) {
        value = String(value || "").toLowerCase();
        if (value.indexOf("2160") !== -1 || /\b4k\b/.test(value)) return 2160;
        if (value.indexOf("1440") !== -1) return 1440;
        if (value.indexOf("1080") !== -1) return 1080;
        if (value.indexOf("720") !== -1) return 720;
        if (value.indexOf("480") !== -1) return 480;
        if (value.indexOf("360") !== -1) return 360;
        return 0;
    }

    function formatSource(source, quality) {
        var label = String(source || "AnimeKai").replace(/\s+/g, " ").trim();
        if (quality && !new RegExp("\\b" + quality + "p\\b", "i").test(label)) return label + " " + quality + "p";
        return label;
    }

    function guessType(typeText) {
        typeText = String(typeText || "").toLowerCase();
        if (typeText.indexOf("movie") !== -1) return "movie";
        return "anime";
    }

    function buildCardDescription(typeText, subCount, dubCount) {
        var parts = [];
        if (typeText) parts.push(typeText);
        if (subCount) parts.push("Sub: " + subCount);
        if (dubCount) parts.push("Dub: " + dubCount);
        return parts.join(" | ");
    }

    async function httpGetText(url, headers) {
        var seen = {};
        var currentUrl = url;
        for (var attempt = 0; attempt < 5; attempt++) {
            if (seen[currentUrl]) break;
            seen[currentUrl] = true;
            var res = await http_get(currentUrl, headers || MAIN_HEADERS);
            var body = res && res.body ? String(res.body) : "";
            if (!body) return body;
            if (body.indexOf("error-page") !== -1) return body;
            var rm = body.match(/http-equiv=["']refresh["'][^>]*content=["']\d+;url=['"]?([^'">\s]+)/i);
            if (!rm || !rm[1]) return body;
            var next = absoluteUrl(rm[1], currentUrl);
            if (!next || next === currentUrl) return body;
            currentUrl = next;
        }
        var finalRes = await http_get(currentUrl, headers || MAIN_HEADERS);
        return finalRes && finalRes.body ? String(finalRes.body) : "";
    }

    async function httpGetJson(url, headers) {
        var text = await httpGetText(url, headers);
        var json = parseJsonSafe(text, null);
        if (json == null) throw new Error("Invalid JSON from " + url);
        return json;
    }

    async function httpPostText(url, headers, body) {
        if (typeof http_post !== "function") throw new Error("http_post not available");
        try {
            var res1 = await http_post(url, headers || {}, body || "");
            return res1 && res1.body ? String(res1.body) : "";
        } catch (e1) {
            var res2 = await http_post(url, body || "", headers || {});
            return res2 && res2.body ? String(res2.body) : "";
        }
    }

    function parseCards(html) {
        var doc = new JsoupLite(html);
        var cards = doc.select("div.aitem");
        var items = [];
        for (var i = 0; i < cards.length; i++) {
            var card = cards[i];
            var posterAnchor = card.find("a.poster");
            var titleAnchor = card.find("a.title");
            if (!posterAnchor || !titleAnchor) continue;

            var href = absoluteUrl(posterAnchor.attr("href"), BASE_URL);
            var title = titleAnchor.attr("title") || titleAnchor.textContent();
            var imageNode = posterAnchor.find("img");
            var posterUrl = absoluteUrl(imageNode ? (imageNode.attr("data-src") || imageNode.attr("src")) : "", BASE_URL);
            var infoNode = card.find("div.info");
            var subNode = infoNode ? infoNode.find("span.sub") : null;
            var dubNode = infoNode ? infoNode.find("span.dub") : null;
            var typeNode = infoNode ? infoNode.find("b") : null;
            var typeText = (typeNode && typeNode.textContent()) || (card.find("span.fdi-item") ? card.find("span.fdi-item").textContent() : "");
            var subCount = toInt(subNode ? subNode.textContent() : "");
            var dubCount = toInt(dubNode ? dubNode.textContent() : "");

            items.push(new MultimediaItem({
                title: cleanText(title),
                url: href,
                posterUrl: posterUrl,
                type: guessType(typeText),
                description: buildCardDescription(typeText, subCount, dubCount),
                headers: MAIN_HEADERS
            }));
        }
        return uniqueBy(items, function (item) { return item.url; });
    }

    function parseRecommendations(html) {
        var doc = new JsoupLite(html);
        var anchors = doc.select("a.aitem");
        var items = [];
        for (var i = 0; i < anchors.length; i++) {
            var anchor = anchors[i];
            var href = absoluteUrl(anchor.attr("href"), BASE_URL);
            if (!href) continue;
            var titleNode = anchor.find("div.title");
            var title = titleNode ? titleNode.textContent() : "";
            var style = anchor.attr("style");
            var posterMatch = style.match(/url\((?:'|")?([^'")]+)(?:'|")?\)/i);
            items.push(new MultimediaItem({
                title: cleanText(title),
                url: href,
                posterUrl: absoluteUrl(posterMatch ? posterMatch[1] : "", BASE_URL),
                type: "anime",
                headers: MAIN_HEADERS
            }));
        }
        return uniqueBy(items, function (item) { return item.url; });
    }

    function parseGenres(doc) {
        var anchors = [];
        var detailBlocks = doc.select("div.detail");
        for (var d = 0; d < detailBlocks.length; d++) {
            anchors = anchors.concat(detailBlocks[d].select("a"));
        }
        if (!anchors.length) anchors = doc.select("a");
        var tags = [];
        for (var i = 0; i < anchors.length; i++) {
            var href = anchors[i].attr("href");
            if (href.indexOf("/genres/") === -1) continue;
            var text = cleanText(anchors[i].textContent());
            if (text) tags.push(text);
        }
        return uniqueBy(tags, function (tag) { return tag; });
    }

    function buildStreamResult(url, source, headers, quality, subtitles) {
        var stream = new StreamResult({
            url: url,
            source: formatSource(source, quality),
            quality: quality || 0,
            headers: headers || {}
        });
        if (subtitles && subtitles.length) stream.subtitles = subtitles;
        return stream;
    }

    function normalizeSubtitleTrack(track) {
        if (!track || !track.file) return null;
        var kind = String(track.kind || "").toLowerCase();
        if (kind && kind !== "captions" && kind !== "subtitles") return null;
        return {
            url: absoluteUrl(track.file, BASE_URL),
            label: track.label || "Unknown",
            lang: track.lang || "en"
        };
    }

    async function expandM3u8(url, source, headers, subtitles) {
        var text = "";
        try {
            text = await httpGetText(url, headers);
        } catch (e) {
            text = "";
        }

        if (!/#EXTM3U/i.test(text) || text.indexOf("#EXT-X-STREAM-INF") === -1) {
            return [buildStreamResult(url, source, headers, getQuality(url) || 0, subtitles)];
        }

        var lines = text.split(/\r?\n/);
        var streams = [];
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i];
            if (line.indexOf("#EXT-X-STREAM-INF") !== 0) continue;
            var nextLine = "";
            for (var j = i + 1; j < lines.length; j++) {
                if (lines[j] && lines[j].charAt(0) !== "#") {
                    nextLine = lines[j].trim();
                    break;
                }
            }
            if (!nextLine) continue;
            var resMatch = line.match(/RESOLUTION=\d+x(\d+)/i);
            var quality = resMatch ? parseInt(resMatch[1], 10) : getQuality(nextLine);
            streams.push(buildStreamResult(absoluteUrl(nextLine, url), source, headers, quality || 0, subtitles));
        }

        if (!streams.length) streams.push(buildStreamResult(url, source, headers, getQuality(url) || 0, subtitles));
        return uniqueBy(streams, function (stream) { return stream.url + "|" + stream.source; });
    }

    async function getHome(cb) {
        try {
            var data = {};
            for (var i = 0; i < HOME_ROWS.length; i++) {
                var row = HOME_ROWS[i];
                var html = await httpGetText(BASE_URL + row.path, MAIN_HEADERS);
                data[row.name] = parseCards(html).slice(0, 36);
            }
            Analytics.logEvent('animekai_home', {});
            cb({ success: true, data: data });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var html = await httpGetText(BASE_URL + "/browse?keyword=" + encodeURIComponent(query || ""), MAIN_HEADERS);
            Analytics.logEvent('animekai_search', {});
            cb({ success: true, data: parseCards(html) });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var watchUrl = absoluteUrl(url, BASE_URL);
            var html = await httpGetText(watchUrl, MAIN_HEADERS);
            if (!html) throw new Error("Empty AnimeKai page");
            if (html.indexOf("error-page") !== -1) throw new Error("Server error page (bodyLen=" + html.length + ")");

            var doc = new JsoupLite(html);
            var titleNode = doc.find("h1.title");
            var title = cleanText(titleNode ? titleNode.textContent() : "");
            var japaneseTitle = cleanText(titleNode ? titleNode.attr("data-jp") : "");
            var plotNode = doc.find("div.desc");
            var plot = cleanText(plotNode ? plotNode.textContent() : "");
            var posterNode = doc.find("div.poster") ? doc.find("div.poster").find("img") : null;
            var posterUrl = absoluteUrl(posterNode ? posterNode.attr("src") : "", watchUrl);
            var infoNode = doc.find("div.info");
            var typeNode = infoNode ? infoNode.find("b") : null;
            var typeText = cleanText(typeNode ? typeNode.textContent() : "");
            var type = guessType(typeText);
            var ratingNode = doc.find("div.rate-box");
            var animeId = ratingNode ? ratingNode.attr("data-id") : "";
            if (!animeId) throw new Error("AnimeKai content id not found");

            var subCount = toInt(infoNode && infoNode.find("span.sub") ? infoNode.find("span.sub").textContent() : "");
            var dubCount = toInt(infoNode && infoNode.find("span.dub") ? infoNode.find("span.dub").textContent() : "");
            var watchSection = doc.find("div.watch-section");
            var malId = watchSection ? watchSection.attr("data-mal-id") : "";
            var aniListId = watchSection ? watchSection.attr("data-al-id") : "";
            var statusMatch = html.match(/Status(?:<\/[^>]+>|\s)*<span[^>]*>([^<]+)/i);
            var status = statusMatch ? cleanText(statusMatch[1]) : "";
            var bannerMatch = html.match(/(?:watch-section-bg|anisc-poster)[^>]+src=["']([^"']+)["']/i) || html.match(/background-image:\s*url\((?:'|")?([^'")]+)(?:'|")?\)/i);
            var bannerUrl = absoluteUrl(bannerMatch ? bannerMatch[1] : "", watchUrl) || posterUrl;

            var episodes = [];
            var epSection = doc.find("section.episode-section");
            if (epSection) {
                var epLinks = epSection.select("a");
                for (var i = 0; i < epLinks.length; i++) {
                    var link = epLinks[i];
                    var epNum = toInt(link.attr("num"));
                    if (!epNum) continue;
                    var epUrl = absoluteUrl(link.attr("href"), watchUrl);
                    var hasSub = link.attr("data-sub") === "1";
                    var hasDub = link.attr("data-dub") === "1";
                    var epName = "Episode " + epNum;
                    if (hasSub) {
                        episodes.push(new Episode({
                            name: epName,
                            url: JSON.stringify({ url: epUrl, langType: "sub" }),
                            season: 1,
                            episode: epNum,
                            posterUrl: posterUrl,
                            description: plot,
                            headers: MAIN_HEADERS,
                            dubStatus: "sub"
                        }));
                    }
                    if (hasDub) {
                        episodes.push(new Episode({
                            name: epName,
                            url: JSON.stringify({ url: epUrl, langType: "dub" }),
                            season: 1,
                            episode: epNum,
                            posterUrl: posterUrl,
                            description: plot,
                            headers: MAIN_HEADERS,
                            dubStatus: "dub"
                        }));
                    }
                }
            }

            if (!episodes.length) {
                var epNumFallback = toInt(watchUrl.match(/\/ep-(\d+)$/i) ? watchUrl.match(/\/ep-(\d+)$/i)[1] : "1");
                episodes.push(new Episode({
                    name: type === "movie" ? title : "Episode " + epNumFallback,
                    url: JSON.stringify({ url: watchUrl, langType: "sub" }),
                    season: 1,
                    episode: epNumFallback,
                    posterUrl: posterUrl,
                    description: plot,
                    headers: MAIN_HEADERS,
                    dubStatus: "sub"
                }));
            }

            var item = new MultimediaItem({
                title: title,
                japaneseTitle: japaneseTitle || undefined,
                url: watchUrl,
                posterUrl: posterUrl,
                bannerUrl: bannerUrl || undefined,
                description: plot || buildCardDescription(typeText, subCount, dubCount),
                type: type,
                status: /releasing/i.test(status) ? "ongoing" : /finished/i.test(status) ? "completed" : undefined,
                tags: parseGenres(doc),
                recommendations: parseRecommendations(html),
                headers: MAIN_HEADERS,
                syncData: {
                    mal_id: malId || undefined,
                    anilist_id: aniListId || undefined
                },
                episodes: episodes
            });

            Analytics.logEvent('animekai_load', {});
            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e.message || e) });
        }
    }

    async function resolveMegaPlayStream(embedUrl, sourceName) {
        try {
            var origin = (new URL(embedUrl)).origin;
            var pageHtml = await httpGetText(embedUrl, {
                "User-Agent": MAIN_HEADERS["User-Agent"],
                "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
                "Referer": embedUrl
            });
            if (!pageHtml) return [];

            var id = (pageHtml.match(/<title>\s*File\s+(\d+)/i) || [])[1]
                || (pageHtml.match(/data-id=["'](\d+)["']/i) || [])[1]
                || "";
            if (!id) return [];

            var json = await httpGetJson(origin + "/stream/getSources?id=" + encodeURIComponent(id), {
                "User-Agent": MAIN_HEADERS["User-Agent"],
                "Accept": "application/json, text/javascript, */*; q=0.01",
                "X-Requested-With": "XMLHttpRequest",
                "Referer": origin + "/"
            });
            if (!json || !json.sources) return [];

            var file = json.sources.file || (Array.isArray(json.sources) && json.sources[0] && json.sources[0].file) || "";
            if (!file) return [];
            file = file.replace(/\\\//g, "/");

            var subtitles = [];
            var tracks = json.tracks || [];
            for (var t = 0; t < tracks.length; t++) {
                var sub = normalizeSubtitleTrack(tracks[t]);
                if (sub) subtitles.push(sub);
            }

            var streamHeaders = {
                "User-Agent": MAIN_HEADERS["User-Agent"],
                "Referer": origin + "/",
                "Origin": origin
            };

            if (/\.m3u8(?:$|[?#])/i.test(file)) {
                return expandM3u8(file, sourceName, streamHeaders, subtitles);
            }
            return [buildStreamResult(file, sourceName, streamHeaders, getQuality(file) || 0, subtitles)];
        } catch (e) {
            return [];
        }
    }

    async function loadStreams(data, cb) {
        try {
            var payload = {};
            if (typeof data === "object" && data !== null && data.url) {
                payload = data;
            } else if (typeof data === "string") {
                var asObj = parseJsonSafe(data, null);
                if (asObj && asObj.url) { payload = asObj; }
                else {
                    var urlMatch = data.match(/url\s*:\s*['"]?(https?:\/\/[^\s'",}]+)/i);
                    payload.url = urlMatch ? urlMatch[1] : data;
                    var langMatch = data.match(/langType\s*:\s*['"]?(\w+)/i);
                    if (langMatch) payload.langType = langMatch[1];
                }
            }
            var episodeUrl = payload.url ? absoluteUrl(payload.url, BASE_URL) : "";
            var requestedType = payload.langType === "dub" ? "dub" : "sub";
            if (!episodeUrl) throw new Error("AnimeKai episode URL not found");

            var html = await httpGetText(episodeUrl, MAIN_HEADERS);
            if (!html) throw new Error("Empty AnimeKai episode page");

            var doc = new JsoupLite(html);
            var rawResults = [];
            var groups = doc.select("div.server-items");

            for (var g = 0; g < groups.length; g++) {
                if (groups[g].attr("data-id") !== requestedType) continue;
                var servers = groups[g].select("span.server");
                for (var j = 0; j < servers.length; j++) {
                    var streamUrl = servers[j].attr("data-url");
                    if (!streamUrl) continue;
                    var serverName = cleanText(servers[j].textContent()) || "Server";
                    var sourceName = "AnimeKai | " + serverName;
                    rawResults.push({
                        url: streamUrl,
                        source: sourceName
                    });
                }
            }

            if (!rawResults.length) throw new Error("No playable AnimeKai streams found");

            var batches = await Promise.all(rawResults.map(function (item) {
                return resolveMegaPlayStream(item.url, item.source).catch(function () { return []; });
            }));

            var results = uniqueBy([].concat.apply([], batches).filter(Boolean), function (stream) {
                return stream.url + "|" + stream.source;
            });

            if (!results.length) throw new Error("Could not resolve any AnimeKai streams");
            Analytics.logEvent('animekai_loadstreams', {});
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
