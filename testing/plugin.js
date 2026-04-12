(function() {
    /**
     * @type {import('@skystream/sdk').Manifest}
     */
    // var manifest is injected at runtime

    const cinemetaUrl = "https://v3-cinemeta.strem.io/meta";
    const externalHeaders = { 
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36" 
    };

    const fixUrl = function(u, base) { 
        if (!u) return ""; 
        if (u.startsWith("//")) return "https:" + u;
        if (u.startsWith("/")) return (base || manifest.baseUrl) + u;
        return u;
    };
    const decodeHtml = function(h) { return !h ? "" : h.replace(/&amp;/g, '&').replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&#039;/g, "'").replace(/&apos;/g, "'").replace(/&#(\d+);/g, (m, d) => String.fromCharCode(d)); };
    const wpApiBase = function() { return manifest.baseUrl.replace(/\/+$/, "") + "/wp-json/wp/v2"; };
    const getResponseIssue = function(res) {
        if (!res) return "No response from upstream site";
        const body = (res.body || "").toLowerCase();
        if (res.status >= 400) {
            if (res.status === 403 || body.indexOf("cf-mitigated") !== -1 || body.indexOf("just a moment") !== -1 || body.indexOf("enable javascript and cookies to continue") !== -1 || body.indexOf("__cf_chl") !== -1) {
                return "Upstream site is protected by Cloudflare and blocked the request";
            }
            return "Upstream site returned HTTP " + res.status;
        }
        if (body.indexOf("cf-mitigated") !== -1 || body.indexOf("just a moment") !== -1 || body.indexOf("enable javascript and cookies to continue") !== -1 || body.indexOf("__cf_chl") !== -1) {
            return "Upstream site returned a challenge page instead of content";
        }
        return null;
    };
    const stripTags = function(html) {
        return decodeHtml((html || "")
            .replace(/<script[\s\S]*?<\/script>/gi, " ")
            .replace(/<style[\s\S]*?<\/style>/gi, " ")
            .replace(/<[^>]+>/g, " ")
            .replace(/\s+/g, " ")
            .trim());
    };
    const unique = function(items) { return items.filter(function(v, i, a) { return v && a.indexOf(v) === i; }); };
    const firstMatch = function(text, regex) {
        const match = regex.exec(text || "");
        return match ? decodeHtml(match[1] || "").trim() : "";
    };
    const parseRating = function(text) {
        const match = /(\d+(?:\.\d+)?)/.exec(text || "");
        return match ? parseFloat(match[1]) : 0;
    };
    const parseYear = function(text) {
        const match = /\b((?:19|20)\d{2})\b/.exec(text || "");
        return match ? parseInt(match[1]) : null;
    };

    const getQuality = function(t) {
        if (!t) return "Auto"; t = t.toLowerCase();
        if (t.indexOf("2160") !== -1 || t.indexOf("4k") !== -1) return "2160p";
        if (t.indexOf("1080") !== -1) return "1080p";
        if (t.indexOf("720") !== -1) return "720p";
        if (t.indexOf("480") !== -1) return "480p";
        if (t.indexOf("360") !== -1) return "360p";
        if (t.indexOf("webrip") !== -1 || t.indexOf("web-dl") !== -1 || t.indexOf("web") !== -1) return "WebRip";
        if (t.indexOf("bluray") !== -1) return "BlueRay";
        if (t.indexOf("hdts") !== -1 || t.indexOf("hdcam") !== -1 || t.indexOf("hdtc") !== -1) return "HdCam";
        if (t.indexOf("dvd") !== -1) return "DVD";
        if (t.indexOf("camrip") !== -1 || t.indexOf("rip") !== -1) return "CamRip";
        if (t.indexOf("cam") !== -1) return "Cam";
        if (t.indexOf("hdrip") !== -1 || t.indexOf("hdtv") !== -1) return "HD";
        if (t.indexOf("hq") !== -1) return "HQ";
        
        const m = /(\d{3,4})[pP]/.exec(t);
        if (m) return m[1] + "p";
        return "Auto";
    };

    async function apiGetJson(path) {
        const res = await http_get(wpApiBase() + path, externalHeaders);
        const issue = getResponseIssue(res);
        if (issue) throw new Error(issue);
        return JSON.parse(res.body);
    }

    async function parseRenderedHtml(renderedHtml) {
        return await parseHtml("<html><body>" + (renderedHtml || "") + "</body></html>");
    }

    function getPostTerms(post) {
        const groups = post && post._embedded && post._embedded["wp:term"];
        if (!Array.isArray(groups)) return [];
        const terms = [];
        for (let i = 0; i < groups.length; i++) {
            const group = groups[i];
            if (!Array.isArray(group)) continue;
            for (let j = 0; j < group.length; j++) {
                const term = group[j];
                if (term && term.taxonomy === "category") terms.push(term);
            }
        }
        return terms;
    }

    function getPosterFromPost(post) {
        const media = post && post._embedded && post._embedded["wp:featuredmedia"];
        if (Array.isArray(media) && media[0] && media[0].source_url) {
            return fixUrl(media[0].source_url);
        }
        const contentHtml = post && post.content && post.content.rendered ? post.content.rendered : "";
        const imageMatch = /<img[^>]+src=["']([^"']+)["']/i.exec(contentHtml);
        return imageMatch ? fixUrl(imageMatch[1]) : "";
    }

    function getPostTitle(post) {
        return decodeHtml(post && post.title && post.title.rendered ? post.title.rendered : "")
            .replace(/^Download\s+/i, "")
            .trim();
    }

    function isSeriesPost(post, title, contentText) {
        const terms = getPostTerms(post);
        const slugs = terms.map(function(term) { return (term.slug || "").toLowerCase(); });
        const names = terms.map(function(term) { return (term.name || "").toLowerCase(); });
        const haystack = ((title || "") + " " + (contentText || "")).toLowerCase();
        return slugs.some(function(slug) {
            return slug === "web-series" || slug === "tv-shows" || slug.indexOf("series") !== -1;
        }) || names.some(function(name) {
            return name.indexOf("series") !== -1 || name.indexOf("tv show") !== -1;
        }) || /(season|series|episode|complete season|s\d{2})/i.test(haystack);
    }

    function postToResult(post) {
        if (!post || !post.link) return null;
        const title = getPostTitle(post);
        const contentText = stripTags(post && post.content && post.content.rendered ? post.content.rendered : "");
        return new MultimediaItem({
            title: title,
            url: fixUrl(post.link),
            posterUrl: getPosterFromPost(post),
            type: isSeriesPost(post, title, contentText) ? "series" : "movie",
            quality: getQuality(title)
        });
    }

    async function resolveCategoryId(searchTerm, exactSlug) {
        const categories = await apiGetJson("/categories?search=" + encodeURIComponent(searchTerm) + "&per_page=20&_fields=id,name,slug,count");
        if (!Array.isArray(categories) || categories.length === 0) return null;
        let match = categories.find(function(category) {
            return (category.slug || "").toLowerCase() === (exactSlug || "").toLowerCase();
        });
        if (!match) {
            match = categories.find(function(category) {
                return (category.name || "").toLowerCase() === (searchTerm || "").toLowerCase();
            });
        }
        return (match || categories[0]).id;
    }

    async function fetchPosts(params) {
        return await apiGetJson("/posts?" + params.join("&") + "&_embed=1");
    }

    async function fetchPostByUrl(url) {
        const postIdMatch = /[?&]p=(\d+)/.exec(url);
        if (postIdMatch) {
            return await apiGetJson("/posts/" + postIdMatch[1] + "?_embed=1");
        }
        const slug = url.split("/").filter(Boolean).pop();
        if (!slug) return null;
        const posts = await apiGetJson("/posts?slug=" + encodeURIComponent(slug) + "&per_page=1&_embed=1");
        return Array.isArray(posts) && posts.length > 0 ? posts[0] : null;
    }

    function isGoodStreamLink(link) {
        if (!link) return false;
        const value = link.toLowerCase();
        return value.indexOf("oxxfile") !== -1 ||
            value.indexOf("hubcloud") !== -1 ||
            value.indexOf("hubcdn") !== -1 ||
            value.indexOf("pixeldrain") !== -1 ||
            value.indexOf("/link/") !== -1 ||
            value.indexOf("gamerxyt.com/hubcloud.php") !== -1 ||
            value.indexOf("/p/") !== -1 ||
            value.indexOf(".mkv") !== -1 ||
            value.indexOf(".mp4") !== -1;
    }

    function isDirectStreamUrl(link) {
        if (!link) return false;
        const value = link.toLowerCase();
        if (value.indexOf(".mkv") !== -1 || value.indexOf(".mp4") !== -1 || value.indexOf(".m3u8") !== -1) return true;
        if (value.indexOf("pixeldrain") !== -1 || value.indexOf("hubcdn") !== -1) return true;
        try {
            const parsed = new URL(link);
            const host = parsed.hostname.toLowerCase();
            const pathParts = parsed.pathname.split("/").filter(Boolean);
            const lastPart = pathParts.length > 0 ? pathParts[pathParts.length - 1] : "";
            if ((host.indexOf("hub.") === 0 || host.indexOf(".hub.") !== -1) &&
                (parsed.searchParams.get("token") || /^[a-f0-9]{24,}$/i.test(lastPart))) {
                return true;
            }
        } catch (e) {}
        return false;
    }

    function toDirectStreamResult(link, fallbackText) {
        const value = (link || "").toLowerCase();
        let source = "Cinevood Direct";
        if (value.indexOf("pixeldrain") !== -1) source = "PixelDrain";
        else if (value.indexOf("hubcdn") !== -1) source = "HubCloud CDN";
        else if (value.indexOf("hub.") !== -1) source = "HubCloud";

        const quality = getQuality((link.split("/").pop() || "") + " " + (fallbackText || ""));
        return new StreamResult({
            url: link,
            source: (quality !== "Auto" ? source + " " + quality : source).trim(),
            headers: externalHeaders
        });
    }

    function extractBodyLinks(body, currentBase) {
        const bodyLinks = [];
        const linkRegex = /(?:href|src)=["']([^"']*(?:oxxfile|hubcloud|hubcdn|pixeldrain|gamerxyt|link|download|1cinevood|\.mkv|\.mp4)[^"']*)["']/gi;
        let match;
        while ((match = linkRegex.exec(body || "")) !== null) {
            bodyLinks.push(fixUrl(match[1].trim(), currentBase));
        }
        return unique(bodyLinks.filter(isGoodStreamLink));
    }

    async function getHome(cb) {
        try {
            const sections = [
                { name: "Trending", params: ["per_page=12", "orderby=date", "order=desc"] },
                { name: "Bollywood", categorySearch: "bollywood", slug: "bollywood" },
                { name: "Hollywood", categorySearch: "hollywood", slug: "hollywood" },
                { name: "Web Series", categorySearch: "series", slug: "web-series" },
                { name: "Gujarati", categorySearch: "gujarati", slug: "gujarati" },
                { name: "Marathi", categorySearch: "marathi", slug: "marathi" },
                { name: "Tamil", categorySearch: "tamil", slug: "tamil" }
            ];
            const results = {};
            for (let i = 0; i < sections.length; i++) {
                const s = sections[i];
                let posts = [];
                if (s.params) {
                    posts = await fetchPosts(s.params);
                } else {
                    const categoryId = await resolveCategoryId(s.categorySearch, s.slug);
                    if (categoryId) {
                        posts = await fetchPosts(["categories=" + categoryId, "per_page=12", "orderby=date", "order=desc"]);
                    }
                }
                const items = (posts || []).map(postToResult).filter(Boolean);
                if (items.length > 0) results[s.name] = items;
            }
            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: e.message });
        }
    }

    async function search(query, cb) {
        try {
            const posts = await fetchPosts(["search=" + encodeURIComponent(query), "per_page=20", "orderby=date", "order=desc"]);
            cb({ success: true, data: (posts || []).map(postToResult).filter(Boolean) });
        } catch (e) {
            cb({ success: false, errorCode: "SITE_OFFLINE", message: e.message });
        }
    }

    async function load(url, cb) {
        try {
            const post = await fetchPostByUrl(url);
            if (!post) return cb({ success: false, errorCode: "NOT_FOUND", message: "Unable to resolve post from URL" });

            const contentHtml = post.content && post.content.rendered ? post.content.rendered : "";
            const contentText = stripTags(contentHtml);
            const html = await parseRenderedHtml(contentHtml);
            const currentUrl = fixUrl(post.link || url);
            const currentBase = new URL(currentUrl).origin + "/";
            const slug = post.slug || currentUrl.split("/").filter(Boolean).pop();

            let imdbId = firstMatch(contentHtml, /imdb\.com\/title\/(tt\d+)/i) || firstMatch(contentHtml, /\b(tt\d{7,10})\b/i);
            let title = getPostTitle(post) || "Untitled";
            
            let bodyQuality = getQuality(title);
            if (bodyQuality === "Auto") {
                bodyQuality = getQuality(contentText);
            }
            let description = firstMatch(contentText, /(?:plot|storyline|summary)\s*:\s*(.+?)(?=\s+(?:screenshots|audio|download|rating|release date|runtime|genres|director|writer|actors)\s*:|$)/i);
            if (!description) description = stripTags(post.excerpt && post.excerpt.rendered ? post.excerpt.rendered : "");
            let posterUrl = getPosterFromPost(post);
            let backgroundUrl = posterUrl;
            let type = isSeriesPost(post, title, contentText) ? "series" : "movie";

            let cast = [];
            let genre = firstMatch(contentText, /genres?\s*:\s*(.+?)(?=\s+(?:director|writer|actors|plot|storyline|screenshots|audio|download|rating|release date|runtime)\s*:|$)/i)
                .split(/\s*,\s*/)
                .filter(Boolean);
            let score = parseRating(firstMatch(contentText, /rating\s*:\s*([^\n\r]+)/i));
            let year = parseYear(title) || parseYear(firstMatch(contentText, /release date\s*:\s*([^\n\r]+)/i));
            const castText = firstMatch(contentText, /actors?\s*:\s*(.+?)(?=\s+(?:plot|storyline|screenshots|audio|download|rating|release date|runtime|genres|director|writer)\s*:|$)/i);
            if (castText) {
                cast = castText.split(/\s*,\s*/).filter(Boolean);
            }

            if (imdbId) {
                const cinemetaType = (type === "series") ? "series" : "movie";
                const cmRes = await http_get(cinemetaUrl + "/" + cinemetaType + "/" + imdbId + ".json", externalHeaders);
                if (cmRes.status === 200) {
                    const cmResponse = JSON.parse(cmRes.body);
                    const cmData = cmResponse ? cmResponse.meta : null;
                    if (cmData) {
                        title = cmData.name || title;
                        description = cmData.description || description;
                        posterUrl = cmData.poster || posterUrl;
                        backgroundUrl = cmData.background || backgroundUrl;
                        cast = cmData.cast || [];
                        genre = cmData.genre || [];
                        score = parseFloat(cmData.imdbRating) || 0;
                        year = parseInt(cmData.releaseInfo) || null;
                    }
                }
            }

            const seasonMatch = /S(\d{2})/i.exec(title);
            const extractedSeason = seasonMatch ? seasonMatch[0].toUpperCase() : null;
            if (type === "series" && extractedSeason && title.indexOf(extractedSeason) === -1) {
                title = title.trim() + " " + extractedSeason;
            }

            const oxxfileNodes = html.querySelectorAll("a[href*='oxxfile']");
            const bodyLinks = extractBodyLinks(contentHtml, currentBase);
            const candidateLinks = unique(Array.from(html.querySelectorAll("a[href]")).map(function(node) {
                return fixUrl(node.getAttribute("href"), currentBase);
            }).filter(isGoodStreamLink).concat(bodyLinks));

            const isSeries = type === "series" || Array.from(html.querySelectorAll("a[href*='/p/']")).some(function(n) {
                const href = n.getAttribute("href");
                return href && href.indexOf("/p/") !== -1;
            });

            if (!isSeries) {
                let links = candidateLinks.slice();
                if (links.length === 0) {
                    const postIdMatch = /[?&]p=(\d+)/.exec(currentUrl) || /\/\?p=(\d+)/.exec(post.guid && post.guid.rendered ? post.guid.rendered : "");
                    if (postIdMatch) {
                        const redirectorUrl = currentBase + "link/" + postIdMatch[1] + "/";
                        const redRes = await http_get(redirectorUrl, externalHeaders);
                        if (redRes.status === 200) {
                            links = links.concat(extractBodyLinks(redRes.body, currentBase));
                        }
                    }
                }

                if (links.length === 0) {
                    const packUrl = currentBase + "api/packs/?slug=" + slug;
                    const packRes = await http_get(packUrl, externalHeaders);
                    if (packRes.status === 200 && packRes.body && packRes.body.trim().indexOf("{") === 0) {
                        try {
                            const packData = JSON.parse(packRes.body);
                            if (packData && packData.success && packData.data) {
                                for (let entry of packData.data) {
                                    if (entry.links) {
                                        for (let l of entry.links) {
                                            if (l.url && isGoodStreamLink(l.url)) links.push(fixUrl(l.url));
                                        }
                                    }
                                }
                            }
                        } catch (e) {}
                    }
                }

                const uniqueLinks = unique(links.filter(isGoodStreamLink));
                const data = new MultimediaItem({
                    title: title, url: currentUrl, posterUrl: posterUrl, type: "movie",
                    description: description, score: score, year: year, bannerUrl: backgroundUrl,
                    cast: cast.map(function(c) { return new Actor({ name: c }); }),
                    episodes: [new Episode({ 
                        name: "Full Movie", season: 1, episode: 1, 
                        url: JSON.stringify({ title: title, links: uniqueLinks, bodyQuality: bodyQuality }) 
                    })]
                });
                cb({ success: true, data: data });
            } else {
                let epLinksData = [];
                const packUrl = currentBase + "api/packs/?slug=" + slug;
                const packRes = await http_get(packUrl, externalHeaders);
                
                if (packRes.status === 200 && packRes.body && packRes.body.trim().indexOf("{") === 0) {
                    try {
                        const packData = JSON.parse(packRes.body);
                        if (packData && packData.success && packData.data) {
                            for (let entry of packData.data) {
                                if (entry.links) {
                                    const mappedItems = entry.links.map(function(l) {
                                        return { title: l.title || "Mirror", link: fixUrl(l.url) };
                                    });
                                    epLinksData.push(mappedItems);
                                }
                            }
                        }
                    } catch (e) {}
                }

                if (epLinksData.length === 0) {
                    const packNodes = Array.from(html.querySelectorAll("a[href*='/p/']")).filter(function(n) { 
                        const href = n.getAttribute("href");
                        return href && href.indexOf("/p/") !== -1; 
                    });

                    for (let i = 0; i < packNodes.length; i++) {
                        const href = packNodes[i].getAttribute("href");
                        const apiRes = await http_get(href.replace("/p/", "/api/packs/"), externalHeaders);
                        if (apiRes.status === 200 && apiRes.body && apiRes.body.trim().indexOf("{") === 0) {
                            try {
                                const json = JSON.parse(apiRes.body);
                                const items = (json && json.pack) ? (json.pack.items || []) : [];
                                epLinksData.push(items.map(function(it) {
                                    return { title: it.episode_name || it.file_name || "EP", link: it.hubcloud_link || "" };
                                }));
                            } catch (e) {}
                        }
                    }
                }

                const episodes = [];
                const maxEpisodes = epLinksData.length > 0 ? Math.max.apply(null, epLinksData.map(function(c) { return c.length; })) : 0;
                for (let i = 0; i < maxEpisodes; i++) {
                    const epLinks = epLinksData.map(function(c) { return c[i] ? c[i].link : null; }).filter(Boolean);
                    if (epLinks.length === 0) continue;
                    const firstEp = epLinksData.find(function(c) { return c[i]; });
                    const epTitle = firstEp ? firstEp[i].title : "Episode " + (i + 1);
                    episodes.push(new Episode({
                        name: epTitle,
                        season: 1,
                        episode: i + 1,
                        url: JSON.stringify({ title: title + " - " + epTitle, links: epLinks, bodyQuality: bodyQuality })
                    }));
                }

                const data = new MultimediaItem({
                    title: title, url: currentUrl, posterUrl: posterUrl, type: "series",
                    description: description, score: score, year: year, bannerUrl: backgroundUrl,
                    cast: cast.map(function(c) { return new Actor({ name: c }); }),
                    episodes: episodes
                });
                cb({ success: true, data: data });
            }
        } catch (e) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: e.message });
        }
    }



    async function resolveHubCloud(initialUrl, fallbackText) {
        let currentUrl = initialUrl;
        let lastUrl = initialUrl;
        let maxTries = 4;
        const results = [];

        while (maxTries-- > 0) {
            if (isDirectStreamUrl(currentUrl)) {
                results.push(toDirectStreamResult(currentUrl, fallbackText));
                return results;
            }

            const headers = JSON.parse(JSON.stringify(externalHeaders));
            headers["Referer"] = lastUrl;
            
            const res = await http_get(currentUrl, headers);
            if (getResponseIssue(res)) break;
            
            lastUrl = currentUrl;
            const body = res.body;

            // Check if we hit a final direct video server early
            if (currentUrl.indexOf(".mkv") !== -1 || currentUrl.indexOf(".mp4") !== -1) {
                results.push(new StreamResult({
                    url: currentUrl, name: "Cinevood Mirror", headers: externalHeaders
                }));
                return results;
            }

            // Case 1: We found "FSL" or "Direct" buttons (Final Stage)
            const bRegex = /<a[^>]+href=["']([^"']+)["'][^>]*class=["'][^"']*btn[^"']*["'][^>]*>([\s\S]*?)<\/a>/g;
            let m;
            let foundFinal = false;
            while ((m = bRegex.exec(body)) !== null) {
                const h = fixUrl(m[1].trim());
                const t = decodeHtml(m[2].replace(/<[^>]+>/g, "").trim()).toLowerCase();
                if (t.indexOf("fsl") !== -1 || t.indexOf("download") !== -1 || t.indexOf("10gbps") !== -1 || t.indexOf("direct") !== -1 || t.indexOf("server") !== -1) {
                    const qualityText = t + " " + h.split("/").pop() + " " + (fallbackText || "");
                    const qRes = getQuality(qualityText);
                    const cleanT = t.replace(/download|file|server|\[|\]|\(|\)/gi, "").replace(/\s+/g, " ").trim().toUpperCase();
                    const finalLabel = "HubCloud " + (qRes !== "Auto" ? qRes : "").trim() + (cleanT ? " (" + cleanT + ")" : "");
                    
                    results.push(new StreamResult({
                        url: h,
                        source: finalLabel.replace(/\s+/g, " ").trim(),
                        headers: externalHeaders
                    }));
                    foundFinal = true;
                }
            }

            if (foundFinal) return results;

            // Case 2: We found a redirector for HubCloud (Stage 2)
            const redirectMatch = /var url = '([^']+)'/i.exec(body) || /window\.location\.href = "([^"]+)"/i.exec(body);
            if (redirectMatch) {
                currentUrl = fixUrl(redirectMatch[1]);
                continue;
            }

            // Case 3: We are on a landing page with a primary "Digital" or "HubCloud" button
            const landingMatch = /href=["']([^"']*(?:hubcloud|oxvvfile|video)[^"']*)["'][^>]*class=["'][^"']*btn[^"']*["']/i.exec(body);
            if (landingMatch) {
                const nextUrl = fixUrl(landingMatch[1]);
                if (nextUrl !== currentUrl) {
                    currentUrl = nextUrl;
                    continue;
                }
            }
            break;
        }
        return results;
    }

    async function loadStreams(dataStr, cb) {
        try {
            const payload = JSON.parse(dataStr);
            const title = payload.title || "";
            const bQuality = payload.bodyQuality || "Auto";
            const links = payload.links || (Array.isArray(payload) ? payload : [payload]);
            let results = [];
            
            for (let i = 0; i < links.length; i++) {
                let u = links[i];
                if (typeof u !== "string") continue;
                try {
                    const headers = JSON.parse(JSON.stringify(externalHeaders));
                    if (isDirectStreamUrl(u)) {
                        results.push(toDirectStreamResult(u, title + " " + bQuality));
                        continue;
                    }

                    // Handle OxxFile -> HubCloud Chain
                    if (u.indexOf("oxxfile") !== -1) {
                        const apiUrl = u.replace("/s/", "/api/s/") + "/hubcloud";
                        const apiRes = await http_get(apiUrl, headers);
                        if (apiRes.status === 200) {
                            const varUrlMatch = /var url = '([^']+)'/i.exec(apiRes.body);
                            if (varUrlMatch) u = fixUrl(varUrlMatch[1], new URL(u).origin);
                        }
                    }

                    // Resolve HubCloud / Redirector
                    if (u.indexOf("hubcloud") !== -1 || u.indexOf("oxvvfile") !== -1 || u.indexOf("hub.") !== -1 || u.indexOf("/link/") !== -1 || u.indexOf("php?") !== -1) {
                        const hResults = await resolveHubCloud(u, title + " " + bQuality);
                        results = results.concat(hResults);
                    } else if (u.indexOf("http") === 0 && (u.indexOf(".mkv") !== -1 || u.indexOf(".mp4") !== -1)) {
                        const qRes = getQuality(u.split("/").pop() + " " + title + " " + bQuality);
                        const finalLabel = "Cinevood " + (qRes !== "Auto" ? qRes : "Direct");
                        
                        results.push(new StreamResult({
                            url: u,
                            source: finalLabel.trim(),
                            headers: externalHeaders
                        }));
                    }
                } catch (err) {
                    console.error("Stream extraction failed for: " + u, err);
                }
            }
            
            // Deduplicate streams
            const uniqueResults = [];
            const seenUrls = new Set();
            for (let r of results) {
                if (!seenUrls.has(r.url)) {
                    seenUrls.add(r.url);
                    uniqueResults.push(r);
                }
            }
            
            cb({ success: true, data: uniqueResults });
        } catch (e) {
            cb({ success: true, data: [] });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
