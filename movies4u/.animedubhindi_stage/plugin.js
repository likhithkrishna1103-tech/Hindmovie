(function() {
    class JNode {
        constructor(tag, attrs, parent) {
            this.tag = tag || null;
            this.attrs = attrs || {};
            this.parent = parent || null;
            this.children = [];
            this.text = "";
        }
        attr(name) { return this.attrs[String(name || "").toLowerCase()] || ""; }
        textContent() {
            if (!this.tag) return this.text;
            return this.children.map(function(child) { return child.textContent(); }).join("");
        }
        html() { return this.children.map(function(child) { return child.outerHTML(); }).join(""); }
        outerHTML() {
            if (!this.tag) return this.text;
            var attrs = Object.keys(this.attrs).map(function(key) {
                return " " + key + "=\"" + String(this.attrs[key] || "") + "\"";
            }, this).join("");
            return "<" + this.tag + attrs + ">" + this.html() + "</" + this.tag + ">";
        }
        matches(selector) {
            if (!this.tag) return false;
            selector = String(selector || "").trim();
            if (!selector) return false;
            if (selector[0] === "#") return this.attr("id") === selector.slice(1);
            if (selector.indexOf(".") !== -1) {
                var parts = selector.split(".");
                var tag = parts[0];
                var cls = parts[1];
                var tagMatch = !tag || this.tag === tag.toLowerCase();
                var classes = String(this.attr("class") || "").split(/\s+/);
                return tagMatch && classes.indexOf(cls) !== -1;
            }
            return this.tag === selector.toLowerCase();
        }
        select(selector, out) {
            out = out || [];
            for (var i = 0; i < this.children.length; i++) {
                var child = this.children[i];
                if (child.matches && child.matches(selector)) out.push(child);
                if (child.select) child.select(selector, out);
            }
            return out;
        }
        selectFirst(selector) {
            var matches = this.select(selector, []);
            return matches.length ? matches[0] : null;
        }
        find(selector) { return this.selectFirst(selector); }
    }

    class JsoupLite {
        constructor(html) {
            html = String(html || "");
            this.root = new JNode("root", {}, null);
            var current = this.root;
            var re = /<\/?[a-z0-9]+(?:\s+[a-z0-9:_-]+(?:=(?:"[^"]*"|'[^']*'|[^\s>]+))?)*\s*\/?>|[^<]+/gi;
            var match;
            while ((match = re.exec(html))) {
                var token = match[0];
                if (token.slice(0, 2) === "</") {
                    if (current.parent) current = current.parent;
                    continue;
                }
                if (token[0] === "<") {
                    var tagMatch = token.match(/^<([a-z0-9]+)/i);
                    var tag = tagMatch ? tagMatch[1].toLowerCase() : "unknown";
                    var selfClosing = /\/>$/.test(token) || /^(img|br|hr|meta|link|input)$/i.test(tag);
                    var attrs = {};
                    var attrRe = /([a-z0-9:_-]+)(?:=(?:"([^"]*)"|'([^']*)'|([^\s>]+)))?/gi;
                    var attrMatch;
                    while ((attrMatch = attrRe.exec(token))) {
                        if (attrMatch[1].toLowerCase() === tag) continue;
                        attrs[attrMatch[1].toLowerCase()] = attrMatch[2] || attrMatch[3] || attrMatch[4] || "";
                    }
                    var node = new JNode(tag, attrs, current);
                    current.children.push(node);
                    if (!selfClosing) current = node;
                    continue;
                }
                var text = token.replace(/\s+/g, " ").trim();
                if (text) {
                    var textNode = new JNode(null, {}, current);
                    textNode.text = text;
                    current.children.push(textNode);
                }
            }
        }
        find(selector) { return this.root.find(selector); }
        select(selector) { return this.root.select(selector, []); }
    }

    var UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36";
    var MAIN_URL = String((manifest && manifest.baseUrl) || "https://www.animedubhindi.me").replace(/\/+$/, "");
    var LINKS_URL = "https://links.animedubhindi.me";
    var COMMON_HEADERS = {
        "User-Agent": UA,
        "Accept": "*/*"
    };
    var HOME_SECTIONS = [
        { title: "Home", path: "/" },
        { title: "Movies", path: "/category/movie/" },
        { title: "Series", path: "/category/series/" },
        { title: "Action", path: "/category/genres/action/" },
        { title: "Drama", path: "/category/drama/" },
        { title: "Romance", path: "/category/romance/" },
        { title: "Thriller", path: "/category/thriller/" }
    ];

    function decodeHtml(text) {
        return String(text || "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, "\"")
            .replace(/&#39;/g, "'")
            .replace(/&#8211;/g, "-")
            .replace(/&#8217;/g, "'")
            .replace(/&#038;/g, "&")
            .replace(/&nbsp;/g, " ");
    }

    function stripHtml(text) {
        return decodeHtml(String(text || "").replace(/<[^>]+>/g, " ").replace(/\s+/g, " ").trim());
    }

    function cleanText(text) {
        return decodeHtml(String(text || "")).replace(/\s+/g, " ").trim();
    }

    function fixUrl(url, base) {
        url = String(url || "").trim();
        if (!url) return "";
        if (/^https?:\/\//i.test(url)) return url;
        if (url.indexOf("//") === 0) return "https:" + url;
        if (url[0] === "/") return String(base || MAIN_URL).replace(/\/+$/, "") + url;
        return String(base || MAIN_URL).replace(/\/+$/, "") + "/" + url.replace(/^\/+/, "");
    }

    function parseQuality(value) {
        value = cleanText(value).toLowerCase();
        var match = value.match(/\b(2160|1440|1080|720|576|480|360|240)p\b/);
        if (match) return parseInt(match[1], 10) || 0;
        if (/\b(?:4k|uhd)\b/.test(value)) return 2160;
        return 0;
    }

    function qualityLabel(quality) {
        quality = parseInt(quality, 10) || 0;
        return quality > 0 ? quality + "p" : "";
    }

    function normalizeTitle(title) {
        title = cleanText(title)
            .replace(/\s+-\s+Anime Dub Hindi$/i, "")
            .replace(/\s+Movie Download$/i, "")
            .replace(/\s+Series Download$/i, "")
            .trim();
        if (/\(\d{4}\)/.test(title)) return title.substring(0, title.lastIndexOf("(")).trim();
        return title;
    }

    function extractAttr(html, attr) {
        var match = String(html || "").match(new RegExp(attr + "\\s*=\\s*([\"'])(.*?)\\1", "i"));
        return match ? decodeHtml(match[2]) : "";
    }

    function parseCards(html) {
        var doc = new JsoupLite(html);
        var seen = {};
        return doc.select("article").map(function(article) {
            var anchor = article.find("h2") ? article.find("h2").find("a") : null;
            if (!anchor) anchor = article.find("a");
            var url = fixUrl(anchor && anchor.attr("href"));
            if (!url || seen[url]) return null;
            seen[url] = true;
            var title = normalizeTitle(anchor ? anchor.textContent() : "");
            if (!title) return null;
            var img = article.find("img");
            var poster = fixUrl(img ? (img.attr("data-src") || img.attr("src")) : "");
            var lower = url.toLowerCase();
            var type = lower.indexOf("/series/") !== -1 || lower.indexOf("season") !== -1 ? "series" : "movie";
            return new MultimediaItem({
                title: title,
                url: url,
                posterUrl: poster || undefined,
                type: type
            });
        }).filter(Boolean);
    }

    function parseInfoMap(html) {
        var out = {};
        String(html || "").replace(/<li[^>]*>\s*<strong[^>]*>\s*([^:<]+)\s*:?\s*<\/strong>\s*([\s\S]*?)<\/li>/gi, function(_, key, value) {
            out[cleanText(key)] = stripHtml(value).replace(/^:\s*/, "").trim();
            return _;
        });
        return out;
    }

    function parseMeta(html, property) {
        var re = new RegExp('<meta[^>]+(?:property|name)=["\\\']' + property.replace(/[.*+?^${}()|[\]\\]/g, "\\$&") + '["\\\'][^>]+content=["\\\']([^"\\\']+)["\\\']', "i");
        var match = String(html || "").match(re);
        return match ? decodeHtml(match[1]) : "";
    }

    function parseIntermediateUrl(html) {
        var match = String(html || "").match(/<div[^>]*class="[^"]*wp-block-button[^"]*"[\s\S]*?<a[^>]+href="([^"]+)"/i);
        return match ? fixUrl(match[1]) : "";
    }

    function isUsefulLink(url) {
        var value = String(url || "").toLowerCase();
        if (!/^https?:\/\//.test(value) && value.indexOf("/re.php") !== 0 && value.indexOf("/redirect.php") !== 0) return false;
        if (value.indexOf("desidubanime") !== -1) return false;
        if (value.indexOf("t.me/") !== -1) return false;
        if (value.indexOf("watch") !== -1 && value.indexOf("hubcloud") === -1) return false;
        return value.indexOf("hubcloud") !== -1
            || value.indexOf("hubdrive") !== -1
            || value.indexOf("hubcdn") !== -1
            || value.indexOf("gdflix") !== -1
            || value.indexOf("gdlink") !== -1
            || value.indexOf("gdtot") !== -1
            || value.indexOf("fpgo.") !== -1
            || value.indexOf("pixeldrain") !== -1
            || value.indexOf("terabox") !== -1
            || value.indexOf("mega.nz") !== -1
            || value.indexOf("gofile") !== -1
            || value.indexOf("/re.php") !== -1
            || value.indexOf("/redirect.php") !== -1
            || value.indexOf("gadgetsweb") !== -1;
    }

    function parseLinkGroupsFromHeadingBlocks(html, base) {
        var groups = [];
        var re = /<h4[^>]*>([\s\S]*?)<\/h4>/gi;
        var match;
        while ((match = re.exec(String(html || "")))) {
            var block = match[1];
            var headingText = stripHtml(block);
            var quality = parseQuality(headingText);
            var links = [];
            var seen = {};
            block.replace(/<a[^>]+href="([^"]+)"[^>]*>([\s\S]*?)<\/a>/gi, function(_, href, text) {
                var url = fixUrl(href, base || LINKS_URL);
                if (!isUsefulLink(url) || seen[url]) return _;
                seen[url] = true;
                var name = cleanText(stripHtml(text)) || "Link";
                links.push({
                    name: (name + (quality ? " " + quality + "p" : "")).trim(),
                    source: name,
                    url: url,
                    quality: quality || undefined
                });
                return _;
            });
            if (links.length) {
                groups.push({
                    name: qualityLabel(quality) || cleanText(headingText) || "Links",
                    quality: quality || undefined,
                    links: links
                });
            }
        }
        return groups;
    }

    function parseSeriesEpisodes(html) {
        var doc = new JsoupLite(html);
        var out = [];
        var groups = doc.select("div.wp-block-group");
        for (var i = 0; i < groups.length; i++) {
            var group = groups[i];
            var titleNode = group.find("h2");
            var titleText = cleanText(titleNode ? titleNode.textContent() : "");
            if (!/episode/i.test(titleText)) continue;
            var epMatch = titleText.match(/Episode:\s*0*(\d+)/i);
            var epNum = epMatch ? parseInt(epMatch[1], 10) : 0;
            var qualityHint = parseQuality(group.textContent());
            var links = [];
            var seen = {};
            var anchors = group.select("a");
            for (var j = 0; j < anchors.length; j++) {
                var anchor = anchors[j];
                var url = fixUrl(anchor.attr("href"), LINKS_URL);
                if (!isUsefulLink(url) || seen[url]) continue;
                seen[url] = true;
                links.push({
                    name: cleanText(anchor.textContent()) || "Link",
                    source: cleanText(anchor.textContent()) || "Link",
                    url: url,
                    quality: parseQuality(anchor.textContent() + " " + titleText) || qualityHint || undefined
                });
            }
            if (links.length) {
                out.push(new Episode({
                    name: epNum ? ("Episode " + epNum) : (titleText || "Episode"),
                    season: 1,
                    episode: epNum || undefined,
                    url: JSON.stringify([{ name: titleText || "Episode", quality: qualityHint || undefined, links: links }])
                }));
            }
        }
        return out;
    }

    function parseSeriesEpisodesAlt(html) {
        var doc = new JsoupLite(html);
        return doc.select("div.pro-ep-card").map(function(card) {
            var title = cleanText(card.find(".pro-ep-title") ? card.find(".pro-ep-title").textContent() : "");
            var epMatch = title.match(/Episode:\s*0*(\d+)/i);
            var epNum = epMatch ? parseInt(epMatch[1], 10) : 0;
            var links = [];
            var seen = {};
            card.select("a").forEach(function(anchor) {
                var url = fixUrl(anchor.attr("href"), LINKS_URL);
                if (!isUsefulLink(url) || seen[url]) return;
                seen[url] = true;
                links.push({
                    name: cleanText(anchor.textContent()) || "Link",
                    source: cleanText(anchor.textContent()) || "Link",
                    url: url,
                    quality: parseQuality(anchor.textContent() + " " + title) || undefined
                });
            });
            if (!links.length) return null;
            return new Episode({
                name: epNum ? ("Episode " + epNum) : (title || "Episode"),
                season: 1,
                episode: epNum || undefined,
                url: JSON.stringify([{ name: title || "Episode", links: links }])
            });
        }).filter(Boolean);
    }

    async function getHome(cb) {
        try {
            var pairs = await Promise.all(HOME_SECTIONS.map(async function(section) {
                try {
                    var res = await http_get(MAIN_URL + section.path, COMMON_HEADERS);
                    var items = parseCards(res && res.body);
                    return [section.title, items];
                } catch (_) {
                    return [section.title, []];
                }
            }));
            var data = {};
            pairs.forEach(function(pair) {
                if (pair[1] && pair[1].length) data[pair[0]] = pair[1];
            });
            cb({ success: true, data: data });
        } catch (error) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: String(error && error.message || error) });
        }
    }

    async function search(query, cb) {
        try {
            var res = await http_get(MAIN_URL + "/?s=" + encodeURIComponent(query || ""), COMMON_HEADERS);
            cb({ success: true, data: parseCards(res && res.body) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(error && error.message || error) });
        }
    }

    async function load(url, cb) {
        try {
            var res = await http_get(url, COMMON_HEADERS);
            var html = String(res && res.body || "");
            if (!html) return cb({ success: false, errorCode: "LOAD_ERROR", message: "Empty response" });
            var infoMap = parseInfoMap(html);
            var rawTitle = parseMeta(html, "og:title") || cleanText((new JsoupLite(html)).find("h1") && (new JsoupLite(html)).find("h1").textContent());
            var title = normalizeTitle(rawTitle);
            var description = parseMeta(html, "description") || parseMeta(html, "og:description") || "";
            var poster = parseMeta(html, "og:image");
            var genres = infoMap["Genres"] ? infoMap["Genres"].split("|").map(function(item) { return cleanText(item); }).filter(Boolean) : [];
            var rating = parseFloat(String(infoMap["MAL Rating"] || infoMap["IMDb Rating"] || "").split("/")[0]) || undefined;
            var dubBy = infoMap["Official Dub By"] || undefined;
            var audio = infoMap["Audio Tracks"] ? infoMap["Audio Tracks"].split("|").map(function(item) { return cleanText(item); }).filter(Boolean) : [];
            var plot = cleanText(description + (audio.length ? "\n" + audio.join(" | ") : ""));
            var intermediate = parseIntermediateUrl(html);
            if (!intermediate) return cb({ success: false, errorCode: "LOAD_ERROR", message: "Missing link page" });

            var isSeries = /\/episode\//i.test(intermediate) || /season/i.test(rawTitle) || !!infoMap["Total Episode"];
            var linkRes = await http_get(intermediate, COMMON_HEADERS);
            var linkHtml = String(linkRes && linkRes.body || "");

            if (!isSeries) {
                var groups = parseLinkGroupsFromHeadingBlocks(linkHtml, LINKS_URL);
                if (!groups.length) return cb({ success: false, errorCode: "LOAD_ERROR", message: "No movie links found" });
                return cb({
                    success: true,
                    data: new MultimediaItem({
                        title: title || "Unknown",
                        url: url,
                        posterUrl: poster || undefined,
                        description: plot || undefined,
                        type: "movie",
                        genres: genres.length ? genres : undefined,
                        rating: rating,
                        contentRating: dubBy,
                        episodes: [new Episode({
                            name: "Full Movie",
                            season: 1,
                            episode: 1,
                            url: JSON.stringify(groups),
                            posterUrl: poster || undefined
                        })]
                    })
                });
            }

            var episodes = parseSeriesEpisodes(linkHtml);
            if (!episodes.length) episodes = parseSeriesEpisodesAlt(linkHtml);
            if (!episodes.length) return cb({ success: false, errorCode: "LOAD_ERROR", message: "No episodes found" });

            cb({
                success: true,
                data: new MultimediaItem({
                    title: title || "Unknown",
                    url: url,
                    posterUrl: poster || undefined,
                    description: plot || undefined,
                    type: "series",
                    genres: genres.length ? genres : undefined,
                    rating: rating,
                    contentRating: dubBy,
                    episodes: episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: String(error && error.message || error) });
        }
    }

    function normalizeStreamData(dataStr) {
        try {
            var parsed = JSON.parse(String(dataStr || ""));
            if (Array.isArray(parsed)) return parsed;
            if (parsed && typeof parsed === "object") return [parsed];
        } catch (_) {}
        return [{ name: "Direct", links: [{ name: "Direct", url: String(dataStr || "") }] }];
    }

    function buildStreamQueue(groups) {
        var queue = [];
        var seen = {};
        groups.forEach(function(group) {
            (Array.isArray(group && group.links) ? group.links : []).forEach(function(link) {
                var url = fixUrl(link && link.url, LINKS_URL);
                if (!url || seen[url]) return;
                seen[url] = true;
                var quality = parseInt(link && link.quality, 10) || parseQuality((link && link.name) + " " + (group && group.name) + " " + url);
                queue.push({
                    url: url,
                    quality: quality || undefined,
                    source: cleanText((link && (link.source || link.name)) || (group && group.name) || "AnimeDubHindi")
                });
            });
        });
        return queue;
    }

    function sourceWithQuality(source, quality) {
        source = cleanText(source || "AnimeDubHindi");
        var label = qualityLabel(quality);
        return label ? (source.replace(/\b\d{3,4}p\b/i, "").trim() + " " + label).trim() : source;
    }

    function toStreamResult(url, source, quality, headers) {
        return new StreamResult({
            url: url,
            source: sourceWithQuality(source, quality),
            quality: quality || undefined,
            headers: headers || COMMON_HEADERS
        });
    }

    function base64Decode(text) {
        try { return atob(text); } catch (_) { return ""; }
    }

    function pen(text) {
        text = String(text || "");
        var out = "";
        for (var i = 0; i < text.length; i++) {
            var code = text.charCodeAt(i);
            if (code >= 65 && code <= 90) out += String.fromCharCode(((code - 65 + 13) % 26) + 65);
            else if (code >= 97 && code <= 122) out += String.fromCharCode(((code - 97 + 13) % 26) + 97);
            else out += text[i];
        }
        return out;
    }

    async function resolveRedirectUrl(url) {
        url = String(url || "");
        if (!url) return "";
        if (url.indexOf("/re.php") === -1 && url.indexOf("/redirect.php") === -1 && url.indexOf("gadgetsweb") === -1 && url.indexOf("id=") === -1) {
            return url;
        }
        try {
            var res = await http_get(url, COMMON_HEADERS);
            var html = String(res && res.body || "");
            var redirectBase64 = html.match(/var\s+redirectUrl\s*=\s*"([^"]+)"/i);
            if (redirectBase64 && redirectBase64[1]) {
                var redirectDecoded = base64Decode(redirectBase64[1]).trim();
                if (redirectDecoded) return redirectDecoded;
            }
            var combined = "";
            html.replace(/s\('o','([A-Za-z0-9+/=]+)'|ck\('_wp_http_\d+','([^']+)'/g, function(_, a, b) {
                combined += a || b || "";
                return _;
            });
            if (!combined) return url;
            var rawDecoded = base64Decode(combined);
            var pDecoded = pen(base64Decode(rawDecoded));
            var decoded = JSON.parse(base64Decode(pDecoded));
            return decoded && decoded.o ? base64Decode(decoded.o).trim() : url;
        } catch (_) {
            return url;
        }
    }

    async function extractHubCloud(url, source, quality) {
        var results = [];
        try {
            var headers = {
                "User-Agent": UA,
                "Accept": "*/*",
                "Cookie": "xla=s4t"
            };
            var res = await http_get(url, headers);
            var html = String(res && res.body || "");
            if (!html) return results;
            var next = extractAttr(html.match(/<a[^>]+id="download"[\s\S]*?<\/a>/i)?.[0] || "", "href");
            if (next) {
                res = await http_get(fixUrl(next, url), Object.assign({}, headers, { "Referer": url }));
                html = String(res && res.body || "");
            }
            var headerText = stripHtml((html.match(/<div[^>]*class="[^"]*card-header[^"]*"[^>]*>([\s\S]*?)<\/div>/i) || [])[1] || "");
            var mergedQuality = quality || parseQuality(headerText) || parseQuality(html);
            html.replace(/<a[^>]+class="[^"]*\bbtn\b[^"]*"[^>]+href="([^"]+)"[^>]*>([\s\S]*?)<\/a>/gi, function(_, href, text) {
                var finalUrl = fixUrl(href, url);
                var label = cleanText(stripHtml(text)).toLowerCase();
                if (!finalUrl) return _;
                var src = source || "HubCloud";
                if (label.indexOf("buzzserver") !== -1) src += " BuzzServer";
                else if (label.indexOf("pixel") !== -1) src += " Pixeldrain";
                else if (label.indexOf("mega") !== -1) src += " Mega";
                else if (label.indexOf("s3") !== -1) src += " S3";
                else if (label.indexOf("fslv2") !== -1) src += " FSLv2";
                else if (label.indexOf("fsl server") !== -1) src += " FSL";
                else if (label.indexOf("pdl") !== -1) src += " PDL";
                else if (label.indexOf("download") === -1) src += " " + cleanText(stripHtml(text));
                if (label.indexOf("buzzserver") !== -1) {
                    results.push(toStreamResult(finalUrl + "/download", src, mergedQuality, { "User-Agent": UA, "Referer": finalUrl }));
                } else if (label.indexOf("pixel") !== -1 && /\/u\//.test(finalUrl)) {
                    results.push(toStreamResult("https://pixeldrain.dev/api/file/" + finalUrl.split("/").pop() + "?download", src, mergedQuality));
                } else {
                    results.push(toStreamResult(finalUrl, src, mergedQuality, headers));
                }
                return _;
            });
            return dedupeStreams(results);
        } catch (_) {
            return results;
        }
    }

    async function extractGdflix(url, source, quality) {
        var results = [];
        try {
            var res = await http_get(url, COMMON_HEADERS);
            var html = String(res && res.body || "");
            if (!html) return results;
            var originMatch = String(res && res.finalUrl || url).match(/^(https?:\/\/[^\/]+)/i);
            var origin = originMatch ? originMatch[1] : url;
            var fileName = cleanText((html.match(/<title>\s*GDFlix\s*\|\s*([^<]+)<\/title>/i) || [])[1] || parseMeta(html, "og:description"));
            var mergedQuality = quality || parseQuality(fileName) || parseQuality(html);
            html.replace(/<a[^>]+href="([^"]+)"[^>]*>([\s\S]*?)<\/a>/gi, function(_, href, text) {
                var label = cleanText(stripHtml(text));
                var lower = label.toLowerCase();
                var finalUrl = fixUrl(href, origin);
                if (!finalUrl) return _;
                if (lower.indexOf("instant dl") !== -1) {
                    results.push(toStreamResult(finalUrl, source + " Instant", mergedQuality));
                } else if (lower.indexOf("pixel") !== -1 && /\/u\//.test(finalUrl)) {
                    results.push(toStreamResult("https://pixeldrain.dev/api/file/" + finalUrl.split("/").pop() + "?download", source + " Pixeldrain", mergedQuality));
                } else if (lower.indexOf("gofile") !== -1 || lower.indexOf("multiup") !== -1) {
                    results.push(toStreamResult(finalUrl, source + " Gofile", mergedQuality));
                } else if (lower.indexOf("zfile") !== -1 || lower.indexOf("direct") !== -1 || lower.indexOf("cloud") !== -1) {
                    results.push(toStreamResult(finalUrl, source, mergedQuality));
                }
                return _;
            });
            if (!results.length && /pixeldrain\.dev\/u\/([A-Za-z0-9]+)/i.test(html)) {
                var id = html.match(/pixeldrain\.dev\/u\/([A-Za-z0-9]+)/i)[1];
                results.push(toStreamResult("https://pixeldrain.dev/api/file/" + id + "?download", source + " Pixeldrain", mergedQuality));
            }
            return dedupeStreams(results);
        } catch (_) {
            return results;
        }
    }

    function dedupeStreams(items) {
        var out = [];
        var seen = {};
        items.forEach(function(item) {
            var key = item && item.url;
            if (!key || seen[key]) return;
            seen[key] = true;
            out.push(item);
        });
        return out;
    }

    async function resolveStreamLink(link) {
        var url = String(link && link.url || "");
        var source = cleanText(link && link.source || "AnimeDubHindi");
        var quality = parseInt(link && link.quality, 10) || 0;
        if (!url) return [];
        if (url.indexOf("hubcloud") !== -1 || url.indexOf("hubdrive") !== -1 || url.indexOf("hubcdn") !== -1 || url.indexOf("hubrouting.site") !== -1) {
            return extractHubCloud(url, source, quality);
        }
        if (url.indexOf("gdflix") !== -1 || url.indexOf("gdlink") !== -1) {
            return extractGdflix(url, source, quality);
        }
        if (url.indexOf("pixeldrain") !== -1 && /\/u\//.test(url)) {
            return [toStreamResult("https://pixeldrain.dev/api/file/" + url.split("/").pop() + "?download", source, quality)];
        }
        return [toStreamResult(url, source, quality)];
    }

    async function loadStreams(data, cb) {
        try {
            var groups = normalizeStreamData(data);
            var queue = buildStreamQueue(groups);
            var results = [];
            for (var i = 0; i < queue.length; i++) {
                var link = queue[i];
                var resolved = await resolveRedirectUrl(link.url);
                var streams = await resolveStreamLink({
                    url: resolved || link.url,
                    source: link.source,
                    quality: link.quality
                });
                results = results.concat(streams);
            }
            results = dedupeStreams(results).sort(function(a, b) {
                return (parseInt(b.quality, 10) || 0) - (parseInt(a.quality, 10) || 0);
            });
            cb({ success: true, data: results });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(error && error.message || error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
