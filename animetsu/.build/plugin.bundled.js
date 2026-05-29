<<<<<<< HEAD
var PluginModule=(()=>{(function(){let l="https://animetsu.net",w=l+"/v2/api/anime",P="https://swiftstream.top/proxy",b={},s={"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",Accept:"application/json, text/plain, */*","Accept-Language":"en-US,en;q=0.5",Origin:l,Referer:l+"/"};function _(e,r){return http_get(e,r||s).then(function(n){if(!n||!n.body)throw new Error("Empty response");return JSON.parse(n.body)})}function J(e,r,n){var i=e[r];return i?Date.now()-i.time>(n||18e5)?(delete e[r],null):i.value:null}function C(e,r,n){return e[r]={value:n,time:Date.now()},n}async function $(e,r,n){var i=JSON.stringify(r||{}),t=Object.assign({"Content-Type":"application/json",Accept:"application/json"},n||{});try{var u=await http_post(e,t,i);if(!u||!u.body)throw new Error("Empty response");return JSON.parse(u.body)}catch{var o=await http_post(e,i,t);if(!o||!o.body)throw new Error("Empty response");return JSON.parse(o.body)}}function L(e,r,n){if(!(!e||!n)){var i={episode:Number(e),season:Number(r||1),unixTime:Number(n)};return typeof NextAiring=="function"?new NextAiring(i):i}}async function z(e){e=e||{};var r=e.anilistId?"al:"+e.anilistId:e.malId?"mal:"+e.malId:e.title?"title:"+String(e.title).toLowerCase():"";if(r){if(Object.prototype.hasOwnProperty.call(b,r))return J(b,r,18e5);try{var n={};e.anilistId?n.id=Number(e.anilistId):e.malId?n.idMal=Number(e.malId):n.search=String(e.title||"");var i=await $("https://graphql.anilist.co",{query:"query($id:Int,$idMal:Int,$search:String){Media(id:$id,idMal:$idMal,search:$search,type:ANIME){status nextAiringEpisode{episode airingAt}}}",variables:n},{"User-Agent":s["User-Agent"]}),t=i&&i.data&&i.data.Media,u=t&&t.nextAiringEpisode;return C(b,r,L(u&&u.episode,1,u&&u.airingAt)||null)}catch{return C(b,r,null)}}}function R(e){return e?String(e).replace(/<br\s*\/?>/gi,`
`).replace(/<\/p>/gi,`
`).replace(/<[^>]+>/g,"").replace(/&amp;/g,"&").replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&quot;/g,'"').replace(/&#39;/g,"'").replace(/&#039;/g,"'").replace(/&nbsp;/g," ").replace(/\n{3,}/g,`

`).trim():""}function f(e){return e==null?"":String(e)}function S(e){if(!(e==null||e===""))return String(e)}function I(e){if(!(e==null||e==="")){var r=Number(e);if(isFinite(r))return Math.round(r)}}function A(e){return e?e.indexOf("http://")===0||e.indexOf("https://")===0?e:l+(e.charAt(0)==="/"?"":"/")+e:""}function x(e){return e?e.indexOf("http://")===0||e.indexOf("https://")===0?e:P+(e.charAt(0)==="/"?"":"/")+e:""}function M(e){var r=(e||"").toUpperCase();return r==="MOVIE"?"movie":"anime"}function U(e){return!e||!e.title?"":f(e.title.english||e.title.romaji||e.title.native||"")}function q(e){return!e||!e.title?"":f(e.title.native||e.title.romaji||"")}function H(e){var r=(e||"").toUpperCase();return r==="RELEASING"?"ongoing":r==="NOT_YET_RELEASED"?"upcoming":r==="FINISHED"||r==="CANCELLED"?"completed":""}function j(e){var r=e&&e.year;return I(r)}function N(e){return!e||!e.cover_image?"":f(e.cover_image.large||e.cover_image.medium||e.cover_image.small||"")}function G(e,r){return x(e&&e.img)||N(r)}function B(e){return e==null?"":typeof e=="string"||typeof e=="number"||typeof e=="boolean"?String(e):typeof e=="object"?f(e.name||e.tag||e.label||e.value||e.id||""):""}function Y(e){return[].concat(e&&e.genres||[]).concat(e&&e.tags||[]).map(B).filter(function(r){return!!r}).slice(0,20)}function W(e,r,n){var i=[],t=String(r||"").trim(),u=t.toLowerCase();return i.push(e||"default"),t&&u!=="master"&&u!=="auto"&&i.push(t),i.push(String(n||"sub").toUpperCase()),i.join(" ")}function O(e,r){r=r||{};var n=U(e);if(!n||!e||!e.id)return null;var i=r.url||l+"/anime/"+e.id,t=new MultimediaItem({title:n,url:i,posterUrl:N(e),bannerUrl:A(e.banner||""),type:M(e.format||e.type),description:R(e.description||r.description||""),year:j(e),headers:s}),u=q(e);return u&&u!==n&&(t.japaneseTitle=u),t}function T(e){for(var r={},n=[],i=0;i<e.length;i++){var t=e[i];!t||!t.url||r[t.url]||(r[t.url]=!0,n.push(t))}return n}function E(e,r){return r=r||{},T((e||[]).map(function(n){return O(n,{url:r.watchEpisode&&n&&n.next_airing_ep&&n.next_airing_ep.ep_num?l+"/watch/"+n.id+"?ep="+n.next_airing_ep.ep_num:l+"/anime/"+(n&&n.id),description:r.descriptionField&&n?n[r.descriptionField]:void 0})}))}function X(e){var r=String(e||"").match(/\/watch\/([^/?#]+)(?:\/([^/?#]+))?(?:\?([^#]+))?/i);if(!r)throw new Error("Invalid episode URL: "+e);var n=r[1],i=r[2]||"",t=r[3]||"",u="default",o="sub";if(t&&t.split("&").forEach(function(c){var v=c.split("="),m=decodeURIComponent(v[0]||""),d=decodeURIComponent(v[1]||"");m==="ep"&&!i&&(i=d),m==="server"&&d&&(u=d),m==="source_type"&&d&&(o=d)}),!i)throw new Error("Episode number not found in URL: "+e);return{animeId:n,epNum:i,server:u,sourceType:o}}async function K(e){try{var r=await _(w+"/home",s),n=E(r&&r.trending||[]).slice(0,20),i=E(r&&r.seasonal||[]).slice(0,20),t=E(r&&r.popular||[]).slice(0,20),u=E(r&&r.top||[]).slice(0,20),o=E(r&&r.upcoming||[]).slice(0,20);e({success:!0,data:{"Trending Now":n,"Popular This Season":i,"Most Popular":t,"Top Rated":u,"Top Upcoming":o}})}catch(c){e({success:!1,errorCode:"HOME_ERROR",message:String(c.message||c)})}}async function V(e,r){try{var n=await _(w+"/search/?query="+encodeURIComponent(e),s),i=T((n&&n.results||[]).map(function(t){return O(t)}));r({success:!0,data:i})}catch(t){r({success:!1,errorCode:"SEARCH_ERROR",message:String(t.message||t)})}}async function Q(e,r){try{var n=String(e||"").match(/\/(?:anime|watch)\/([^/?#]+)/i);if(!n)throw new Error("Could not extract anime id from URL: "+e);var i=n[1],t=await _(w+"/info/"+i,s),u=await _(w+"/eps/"+i,s),o=[];t&&t.trailer&&o.push(new Trailer({name:"Trailer",url:"https://www.youtube.com/watch?v="+t.trailer}));var c=[];(t&&t.characters||[]).slice(0,20).forEach(function(a){c.push(new Actor({name:f(a&&a.name),role:f(a&&a.role),image:f(a&&a.image)}))});var v=T((t&&t.recommendations||t&&t.relations||[]).slice(0,12).map(function(a){return O(a)})),m=(u||[]).map(function(a){var g=I(a&&a.ep_num),h=G(a,t);return new Episode({name:f(a.name||"Episode "+f(g||a.ep_num)),url:l+"/watch/"+i+"?ep="+encodeURIComponent(f(g||a.ep_num))+"&server=default&source_type=sub",season:1,episode:g||1,description:R(a.desc||""),posterUrl:h,thumbnailUrl:h,image:h,headers:s,dubStatus:"sub"})}),d=H(t.status)==="ongoing"?await z({anilistId:S(t.anilist_id),malId:S(t.mal_id),title:U(t)}):void 0,p=new MultimediaItem({title:U(t),japaneseTitle:q(t),url:l+"/anime/"+i,posterUrl:N(t),bannerUrl:A(t.banner||""),logoUrl:A(t.clear_logo||""),description:R(t.description||""),type:M(t.format||t.type),year:j(t),score:typeof t.average_score=="number"?t.average_score/10:void 0,duration:I(t.duration),status:H(t.status),contentRating:t.is_adult?"R18+":void 0,isAdult:!!t.is_adult,tags:Y(t),cast:c,trailers:o,recommendations:v,nextAiring:d||void 0,playbackPolicy:"none",syncData:{anilist_id:S(t.anilist_id),mal_id:S(t.mal_id)},headers:s,episodes:m});r({success:!0,data:p})}catch(a){r({success:!1,errorCode:"LOAD_ERROR",message:String(a.message||a)})}}async function Z(e,r,n,i){return _(w+"/oppai/"+e+"/"+r+"?server="+encodeURIComponent(n||"default")+"&source_type="+encodeURIComponent(i||"sub"),s)}async function k(e,r){return _(w+"/servers/"+e+"/"+r,s)}async function ee(e,r){try{var n=X(e),i=[],t=[],u={};try{i=await k(n.animeId,n.epNum)}catch{i=[]}!i||!i.length?i=[{id:n.server||"default",default:!0}]:i=i.slice().sort(function(y,F){return y.id===n.server?-1:F.id===n.server?1:y.default?-1:F.default?1:0});for(var o=0;o<i.length;o++)for(var c=i[o],v=n.sourceType==="dub"?["dub","sub"]:["sub","dub"],m=0;m<v.length;m++){var d=v[m],p=null;try{p=await Z(n.animeId,n.epNum,c.id,d)}catch{p=null}if(!(!p||!p.sources||!p.sources.length))for(var a=0;a<p.sources.length;a++){var g=p.sources[a],h=g.need_proxy?x(g.url):A(g.url),D=h+"|"+(p.server||c.id)+"|"+d+"|"+(g.quality||"");!h||u[D]||(u[D]=!0,t.push(new StreamResult({url:h,source:W(p.server||c.id||"default",g.quality,d),headers:{"User-Agent":s["User-Agent"],Origin:l,Referer:l+"/"}})))}}if(!t.length)throw new Error("No streams found from any server");r({success:!0,data:t})}catch(y){r({success:!1,errorCode:"STREAM_ERROR",message:String(y.message||y)})}}globalThis.getHome=K,globalThis.search=V,globalThis.load=Q,globalThis.loadStreams=ee})();})();
=======
var PluginModule=(()=>{
(function () {
    /**
     * @typedef {Object} Response
     * @property {boolean} success
     * @property {any} [data]
     * @property {string} [errorCode]
     * @property {string} [message]
     */

    const MAIN_URL = "https://animetsu.net";
    const API_BASE = MAIN_URL + "/v2/api/anime";
    const PROXY_BASE = "https://swiftstream.top/proxy";
    const NEXT_AIRING_CACHE = {};
    const ANIZIP_CACHE = {};

    const HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0",
        "Accept": "application/json, text/plain, */*",
        "Accept-Language": "en-US,en;q=0.5",
        "Origin": MAIN_URL,
        "Referer": MAIN_URL + "/"
    };

    const IMAGE_HEADERS = {
        "User-Agent": HEADERS["User-Agent"],
        "Accept": "image/avif,image/webp,image/png,image/jpeg,image/*,*/*;q=0.8",
        "Referer": MAIN_URL + "/"
    };

    function httpJson(url, headers) {
        return http_get(url, headers || HEADERS).then(function (res) {
            if (!res || !res.body) throw new Error("Empty response");
            return JSON.parse(res.body);
        });
    }

    function cacheGet(cache, key, ttl) {
        var entry = cache[key];
        if (!entry) return null;
        if (Date.now() - entry.time > (ttl || 1800000)) {
            delete cache[key];
            return null;
        }
        return entry.value;
    }

    function cacheSet(cache, key, value) {
        cache[key] = { value: value, time: Date.now() };
        return value;
    }

    async function postJson(url, payload, headers) {
        var body = JSON.stringify(payload || {});
        var mergedHeaders = Object.assign({
            "Content-Type": "application/json",
            "Accept": "application/json"
        }, headers || {});
        try {
            var res1 = await http_post(url, mergedHeaders, body);
            if (!res1 || !res1.body) throw new Error("Empty response");
            return JSON.parse(res1.body);
        } catch (_) {
            var res2 = await http_post(url, body, mergedHeaders);
            if (!res2 || !res2.body) throw new Error("Empty response");
            return JSON.parse(res2.body);
        }
    }

    function buildNextAiring(episode, season, unixTime) {
        if (!episode || !unixTime) return undefined;
        var payload = { episode: Number(episode), season: Number(season || 1), unixTime: Number(unixTime) };
        return typeof NextAiring === "function" ? new NextAiring(payload) : payload;
    }

    async function fetchNextAiring(params) {
        params = params || {};
        var cacheKey = params.anilistId ? ("al:" + params.anilistId)
            : params.malId ? ("mal:" + params.malId)
            : params.title ? ("title:" + String(params.title).toLowerCase())
            : "";
        if (!cacheKey) return undefined;
        if (Object.prototype.hasOwnProperty.call(NEXT_AIRING_CACHE, cacheKey)) {
            return cacheGet(NEXT_AIRING_CACHE, cacheKey, 1800000);
        }
        try {
            var variables = {};
            if (params.anilistId) variables.id = Number(params.anilistId);
            else if (params.malId) variables.idMal = Number(params.malId);
            else variables.search = String(params.title || "");
            var json = await postJson("https://graphql.anilist.co", {
                query: "query($id:Int,$idMal:Int,$search:String){Media(id:$id,idMal:$idMal,search:$search,type:ANIME){status nextAiringEpisode{episode airingAt}}}",
                variables: variables
            }, { "User-Agent": HEADERS["User-Agent"] });
            var media = json && json.data && json.data.Media;
            var next = media && media.nextAiringEpisode;
            return cacheSet(NEXT_AIRING_CACHE, cacheKey, buildNextAiring(next && next.episode, 1, next && next.airingAt) || null);
        } catch (_) {
            return cacheSet(NEXT_AIRING_CACHE, cacheKey, null);
        }
    }

    async function fetchAniZipMeta(malId) {
        if (!malId) return null;
        var cacheKey = "mal:" + String(malId);
        if (Object.prototype.hasOwnProperty.call(ANIZIP_CACHE, cacheKey)) {
            return cacheGet(ANIZIP_CACHE, cacheKey, 1800000);
        }
        try {
            var meta = await httpJson(
                "https://api.ani.zip/mappings?mal_id=" + encodeURIComponent(String(malId)),
                { "Accept": "application/json", "User-Agent": HEADERS["User-Agent"] }
            );
            return cacheSet(ANIZIP_CACHE, cacheKey, meta || null);
        } catch (_) {
            return cacheSet(ANIZIP_CACHE, cacheKey, null);
        }
    }

    function getAniZipEpisodeMeta(aniZipMeta, episodeNumber) {
        if (!aniZipMeta || !aniZipMeta.episodes || episodeNumber == null) return null;
        return aniZipMeta.episodes[String(episodeNumber)] || null;
    }

    function cleanText(str) {
        if (!str) return "";
        return String(str)
            .replace(/<br\s*\/?>/gi, "\n")
            .replace(/<\/p>/gi, "\n")
            .replace(/<[^>]+>/g, "")
            .replace(/&amp;/g, "&")
            .replace(/&lt;/g, "<")
            .replace(/&gt;/g, ">")
            .replace(/&quot;/g, '"')
            .replace(/&#39;/g, "'")
            .replace(/&#039;/g, "'")
            .replace(/&nbsp;/g, " ")
            .replace(/\n{3,}/g, "\n\n")
            .trim();
    }

    function stringOrEmpty(value) {
        return value == null ? "" : String(value);
    }

    function optionalString(value) {
        if (value == null || value === "") return undefined;
        return String(value);
    }

    function integerOrUndefined(value) {
        if (value == null || value === "") return undefined;
        var num = Number(value);
        if (!isFinite(num)) return undefined;
        return Math.round(num);
    }

    function absoluteUrl(url) {
        if (!url) return "";
        if (url.indexOf("http://") === 0 || url.indexOf("https://") === 0) return url;
        return MAIN_URL + (url.charAt(0) === "/" ? "" : "/") + url;
    }

    function proxiedUrl(path) {
        if (!path) return "";
        if (path.indexOf("http://") === 0 || path.indexOf("https://") === 0) return path;
        return PROXY_BASE + (path.charAt(0) === "/" ? "" : "/") + path;
    }

    function animeTypeFromFormat(format) {
        var f = (format || "").toUpperCase();
        if (f === "MOVIE") return "movie";
        return "anime";
    }

    function itemTitle(data) {
        if (!data || !data.title) return "";
        return stringOrEmpty(data.title.english || data.title.romaji || data.title.native || "");
    }

    function itemSubtitle(data) {
        if (!data || !data.title) return "";
        return stringOrEmpty(data.title.native || data.title.romaji || "");
    }

    function mapStatus(status) {
        var s = (status || "").toUpperCase();
        if (s === "RELEASING") return "ongoing";
        if (s === "NOT_YET_RELEASED") return "upcoming";
        if (s === "FINISHED" || s === "CANCELLED") return "completed";
        return "";
    }

    function numericYear(data) {
        var y = data && data.year;
        return integerOrUndefined(y);
    }

    function coverUrl(data) {
        if (!data || !data.cover_image) return "";
        return stringOrEmpty(data.cover_image.large || data.cover_image.medium || data.cover_image.small || "");
    }

    function episodePosterUrl(ep, info, aniZipMeta) {
        var episodeNumber = integerOrUndefined(ep && ep.ep_num);
        var meta = getAniZipEpisodeMeta(aniZipMeta, episodeNumber);
        return stringOrEmpty(meta && meta.image) || proxiedUrl(ep && ep.img) || coverUrl(info);
    }

    function normalizeTag(tag) {
        if (tag == null) return "";
        if (typeof tag === "string" || typeof tag === "number" || typeof tag === "boolean") {
            return String(tag);
        }

        if (typeof tag === "object") {
            return stringOrEmpty(tag.name || tag.tag || tag.label || tag.value || tag.id || "");
        }

        return "";
    }

    function normalizeTags(info) {
        return []
            .concat((info && info.genres) || [])
            .concat((info && info.tags) || [])
            .map(normalizeTag)
            .filter(function (tag) { return !!tag; })
            .slice(0, 20);
    }

    function formatSourceLabel(serverName, quality, sourceType) {
        var parts = [];
        var q = String(quality || "").trim();
        var normalized = q.toLowerCase();

        parts.push(serverName || "default");

        if (q && normalized !== "master" && normalized !== "auto") {
            parts.push(q);
        }

        parts.push(String(sourceType || "sub").toUpperCase());
        return parts.join(" ");
    }

    function toMultimediaItem(data, opts) {
        opts = opts || {};

        var title = itemTitle(data);
        if (!title || !data || !data.id) return null;

        var url = opts.url || (MAIN_URL + "/anime/" + data.id);
        var item = new MultimediaItem({
            title: title,
            url: url,
            posterUrl: coverUrl(data),
            bannerUrl: absoluteUrl(data.banner || ""),
            type: animeTypeFromFormat(data.format || data.type),
            description: cleanText(data.description || opts.description || ""),
            year: numericYear(data),
            headers: HEADERS
        });

        var jp = itemSubtitle(data);
        if (jp && jp !== title) item.japaneseTitle = jp;
        return item;
    }

    function uniqueByUrl(items) {
        var seen = {};
        var out = [];
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            if (!item || !item.url || seen[item.url]) continue;
            seen[item.url] = true;
            out.push(item);
        }
        return out;
    }

    function mapHomeItems(items, opts) {
        opts = opts || {};
        return uniqueByUrl(((items || []).map(function (entry) {
            return toMultimediaItem(entry, {
                url: opts.watchEpisode && entry && entry.next_airing_ep && entry.next_airing_ep.ep_num
                    ? MAIN_URL + "/watch/" + entry.id + "?ep=" + entry.next_airing_ep.ep_num
                    : MAIN_URL + "/anime/" + (entry && entry.id),
                description: opts.descriptionField && entry ? entry[opts.descriptionField] : undefined
            });
        })));
    }

    function parseEpisodeInput(url) {
        var match = String(url || "").match(/\/watch\/([^/?#]+)(?:\/([^/?#]+))?(?:\?([^#]+))?/i);
        if (!match) throw new Error("Invalid episode URL: " + url);

        var animeId = match[1];
        var ep = match[2] || "";
        var query = match[3] || "";
        var server = "default";
        var sourceType = "sub";

        if (query) {
            query.split("&").forEach(function (part) {
                var pair = part.split("=");
                var key = decodeURIComponent(pair[0] || "");
                var value = decodeURIComponent(pair[1] || "");
                if (key === "ep" && !ep) ep = value;
                if (key === "server" && value) server = value;
                if (key === "source_type" && value) sourceType = value;
            });
        }

        if (!ep) throw new Error("Episode number not found in URL: " + url);

        return {
            animeId: animeId,
            epNum: ep,
            server: server,
            sourceType: sourceType
        };
    }

    async function getHome(cb) {
        try {
            var home = await httpJson(API_BASE + "/home", HEADERS);
            var trendingItems = mapHomeItems((home && home.trending) || []).slice(0, 20);
            var seasonalItems = mapHomeItems((home && home.seasonal) || []).slice(0, 20);
            var popularItems = mapHomeItems((home && home.popular) || []).slice(0, 20);
            var topItems = mapHomeItems((home && home.top) || []).slice(0, 20);
            var upcomingItems = mapHomeItems((home && home.upcoming) || []).slice(0, 20);

            cb({
                success: true,
                data: {
                    "Trending Now": trendingItems,
                    "Popular This Season": seasonalItems,
                    "Most Popular": popularItems,
                    "Top Rated": topItems,
                    "Top Upcoming": upcomingItems
                }
            });
        } catch (e) {
            cb({ success: false, errorCode: "HOME_ERROR", message: String(e.message || e) });
        }
    }

    async function search(query, cb) {
        try {
            var data = await httpJson(API_BASE + "/search/?query=" + encodeURIComponent(query), HEADERS);
            var results = uniqueByUrl(((data && data.results) || []).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            cb({ success: true, data: results });
        } catch (e) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: String(e.message || e) });
        }
    }

    async function load(url, cb) {
        try {
            var animeMatch = String(url || "").match(/\/(?:anime|watch)\/([^/?#]+)/i);
            if (!animeMatch) throw new Error("Could not extract anime id from URL: " + url);

            var animeId = animeMatch[1];
            var info = await httpJson(API_BASE + "/info/" + animeId, HEADERS);
            var eps = await httpJson(API_BASE + "/eps/" + animeId, HEADERS);
            var aniZipMeta = await fetchAniZipMeta(optionalString(info && info.mal_id));

            var trailers = [];
            if (info && info.trailer) {
                trailers.push(new Trailer({
                    name: "Trailer",
                    url: "https://www.youtube.com/watch?v=" + info.trailer
                }));
            }

            var cast = [];
            ((info && info.characters) || []).slice(0, 20).forEach(function (character) {
                cast.push(new Actor({
                    name: stringOrEmpty(character && character.name),
                    role: stringOrEmpty(character && character.role),
                    image: stringOrEmpty(character && character.image)
                }));
            });

            var recommendations = uniqueByUrl(((info && info.recommendations) || (info && info.relations) || []).slice(0, 12).map(function (entry) {
                return toMultimediaItem(entry);
            }));

            var episodes = ((eps || [])).map(function (ep) {
                var episodeNumber = integerOrUndefined(ep && ep.ep_num);
                var episodeMeta = getAniZipEpisodeMeta(aniZipMeta, episodeNumber);
                var posterUrl = episodePosterUrl(ep, info, aniZipMeta);
                return new Episode({
                    name: stringOrEmpty((episodeMeta && episodeMeta.title && episodeMeta.title.en) || ep.name || ("Episode " + stringOrEmpty(episodeNumber || ep.ep_num))),
                    url: MAIN_URL + "/watch/" + animeId + "?ep=" + encodeURIComponent(stringOrEmpty(episodeNumber || ep.ep_num)) + "&server=default&source_type=sub",
                    season: 1,
                    episode: episodeNumber || 1,
                    description: cleanText((episodeMeta && (episodeMeta.overview || episodeMeta.summary)) || ep.desc || ""),
                    posterUrl: posterUrl,
                    thumbnailUrl: posterUrl,
                    image: posterUrl,
                    headers: IMAGE_HEADERS,
                    runtime: integerOrUndefined(episodeMeta && (episodeMeta.runtime || episodeMeta.length)),
                    airDate: optionalString((episodeMeta && (episodeMeta.airDate || episodeMeta.airdate)) || (ep && ep.aired_at)),
                    dubStatus: "sub"
                });
            });

            var nextAiring = mapStatus(info.status) === "ongoing"
                ? await fetchNextAiring({
                    anilistId: optionalString(info.anilist_id),
                    malId: optionalString(info.mal_id),
                    title: itemTitle(info)
                })
                : undefined;

            var item = new MultimediaItem({
                title: itemTitle(info),
                japaneseTitle: itemSubtitle(info),
                url: MAIN_URL + "/anime/" + animeId,
                posterUrl: coverUrl(info),
                bannerUrl: absoluteUrl(info.banner || ""),
                logoUrl: absoluteUrl(info.clear_logo || ""),
                description: cleanText(info.description || ""),
                type: animeTypeFromFormat(info.format || info.type),
                year: numericYear(info),
                score: typeof info.average_score === "number" ? info.average_score / 10 : undefined,
                duration: integerOrUndefined(info.duration),
                status: mapStatus(info.status),
                contentRating: info.is_adult ? "R18+" : undefined,
                isAdult: !!info.is_adult,
                tags: normalizeTags(info),
                cast: cast,
                trailers: trailers,
                recommendations: recommendations,
                nextAiring: nextAiring || undefined,
                playbackPolicy: "none",
                syncData: {
                    anilist_id: optionalString(info.anilist_id),
                    mal_id: optionalString(info.mal_id)
                },
                headers: HEADERS,
                episodes: episodes
            });

            cb({ success: true, data: item });
        } catch (e) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: String(e.message || e) });
        }
    }

    async function fetchSources(animeId, epNum, server, sourceType) {
        return httpJson(
            API_BASE + "/oppai/" + animeId + "/" + epNum +
            "?server=" + encodeURIComponent(server || "default") +
            "&source_type=" + encodeURIComponent(sourceType || "sub"),
            HEADERS
        );
    }

    async function fetchServers(animeId, epNum) {
        return httpJson(
            API_BASE + "/servers/" + animeId + "/" + epNum,
            HEADERS
        );
    }

    async function loadStreams(url, cb) {
        try {
            var parsed = parseEpisodeInput(url);
            var serverList = [];
            var streams = [];
            var seen = {};

            try {
                serverList = await fetchServers(parsed.animeId, parsed.epNum);
            } catch (e1) {
                serverList = [];
            }

            if (!serverList || !serverList.length) {
                serverList = [{ id: parsed.server || "default", default: true }];
            } else {
                serverList = serverList.slice().sort(function (a, b) {
                    if (a.id === parsed.server) return -1;
                    if (b.id === parsed.server) return 1;
                    if (a.default) return -1;
                    if (b.default) return 1;
                    return 0;
                });
            }

            for (var i = 0; i < serverList.length; i++) {
                var server = serverList[i];
                var sourceTypes = parsed.sourceType === "dub" ? ["dub", "sub"] : ["sub", "dub"];

                for (var j = 0; j < sourceTypes.length; j++) {
                    var sourceType = sourceTypes[j];
                    var payload = null;

                    try {
                        payload = await fetchSources(parsed.animeId, parsed.epNum, server.id, sourceType);
                    } catch (e2) {
                        payload = null;
                    }

                    if (!payload || !payload.sources || !payload.sources.length) continue;

                    for (var k = 0; k < payload.sources.length; k++) {
                        var source = payload.sources[k];
                        var streamUrl = source.need_proxy ? proxiedUrl(source.url) : absoluteUrl(source.url);
                        var key = streamUrl + "|" + (payload.server || server.id) + "|" + sourceType + "|" + (source.quality || "");
                        if (!streamUrl || seen[key]) continue;
                        seen[key] = true;

                        streams.push(new StreamResult({
                            url: streamUrl,
                            source: formatSourceLabel(payload.server || server.id || "default", source.quality, sourceType),
                            headers: {
                                "User-Agent": HEADERS["User-Agent"],
                                "Origin": MAIN_URL,
                                "Referer": MAIN_URL + "/"
                            }
                        }));
                    }
                }
            }

            if (!streams.length) throw new Error("No streams found from any server");

            cb({ success: true, data: streams });
        } catch (e) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: String(e.message || e) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();

})();
>>>>>>> 7d19e563 (update plugin.json)
Object.assign(globalThis, PluginModule);
