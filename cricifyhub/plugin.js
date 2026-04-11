(function() {
    const DEFAULT_HEADERS = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; rv:78.0) Gecko/20100101 Firefox/78.0",
        "Accept": "*/*",
        "Accept-Language": "en-US,en;q=0.5",
        "Connection": "keep-alive"
    };
    const FIREBASE_CONFIG = {
        packageName: "com.cricfy.tv",
        apiKey: "AIzaSyAh9jkEU0E_UYxH0m_BKAt-uUSTiTPqhb8",
        appId: "1:963020218535:android:47ec53252c64fb3c9c7b82",
        projectNumber: "963020218535",
        sdkVersion: "22.1.0",
        appVersion: "5.0",
        appBuild: "50"
    };
    const DEFAULT_BASE_URLS = [
        "https://cfykjgvjjjvn106.top",
        "https://indsp1.site",
        "https://cfymarkscanjiostar80.top",
        "https://cfyhljddgbkkufh82.top",
        "https://cfynewihgf1.top",
        "https://cfyshgdkuytv15.top",
        "https://cfykshdbdkidv75.top",
        "https://cfyksgsksnbslv67.top"
    ];
    const PROVIDER_KEYS = [
        { key: "M2hIenhZQWdTR0k4L2hhbQ==", iv: "VXFDdmt2amVjRUl6ODQyVg==" },
        { key: "TXFlWUdDVDRBWUtvSEtyVA==", iv: "b0hLclRRdVB4OHpsOG9KKw==" }
    ];
    const PROVIDER_TITLE_FALLBACKS = {
        sonyin: ["sonyin2", "sonybd"],
        jioind: ["jioind2", "jiotv", "jiohotstar", "jiocinemaind"],
        vootind: ["jiocinemaind"],
        dishhomebd: ["dishtv"],
        fancodebd: ["fancodeind"],
        darktv: []
    };
    const SECTION_DEFINITIONS = [
        {
            title: "India",
            keys: ["jioind", "jiotv", "jiocinemaind", "jiohotstar", "sonyin", "sonyin2", "sundirect", "sunnxt", "vootind", "zee5in2", "dangaltv"]
        },
        {
            title: "Bangladesh",
            keys: ["ayna", "ayna2", "jagobd", "jiobd", "toffeebd", "sonybd", "dishhomebd", "akash", "fancodebd"]
        },
        {
            title: "Pakistan",
            keys: ["tapmadpk", "shooqpk"]
        },
        {
            title: "Sports",
            keys: ["fancodeind", "crichd", "zapsports", "freesports"]
        },
        {
            title: "Global & Free TV",
            keys: ["distrotv", "piratestv", "pishow", "dishtv", "samsungtv", "worldtv", "runtv", "wavesott", "freetv", "yupptv"]
        }
    ];
    const PROVIDERS = {
        fancodeind: {
            title: "FANCODE IND",
            image: "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q",
            catLink: "https://raw.githubusercontent.com/Jitendra-unatti/fancode/refs/heads/main/data/fancode.m3u"
        },
        jioind: {
            title: "JIO IND",
            image: "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png",
            catLink: "https://jiotv.byte-vault.workers.dev/?token=42e4f5-2d873b-3c37d8-7f3f50"
        },
        sonyin: {
            title: "SONY IN",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU",
            catLink: "https://sonyliv.logic-lane.workers.dev?token=a14d9c-4b782a-6c90fd-9a1b84"
        },
        sonyin2: {
            title: "SONY IN 2",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU",
            catLink: "https://raw.githubusercontent.com/ramnarayan01/data/refs/heads/main/s0nyind.m3u.html"
        },
        sundirect: {
            title: "SUN DIRECT",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwc4OuqPmOP-Fi9dhfiDw_q-s3rOmgCPla_IaE76VD2KRQ7c4KHeI2zJY&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/suntv.m3u"
        },
        vootind: {
            title: "VOOT IND",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfS6QZFts2FoedMGZE28H7Kh158PsrNIiabFBVJMy_jXa8Tvvb9WAlut8&s=10",
            catLink: "https://jiocinema-live.cloud-hatchh.workers.dev/?token=42e4f5-2d414b-3c37d8-5f3f45"
        },
        sunnxt: {
            title: "SUN NXT",
            image: "https://upload.wikimedia.org/wikipedia/en/d/d5/Sun_NXT_logo_small.png",
            catLink: "https://raw.githubusercontent.com/alexandermail371/cricfytv/refs/heads/main/sunxt.m3u"
        },
        distrotv: {
            title: "DISTRO TV",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYQjBTT5SL_kuJF7CbQtoSEA7PzyiH9RYIuDO9F1sx87CtiULDyiDf7ybt&s=10",
            catLink: "https://playlist-storage.pages.dev/PLAYLIST/DistroTV.m3u"
        },
        jiotv: {
            title: "JIOTV+",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh5KeAyYdOyxaCWDPbiUsJW7Oy4v_7uFqf06rIwGxaWc6nQuNVqZ2Q_Qej&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jtv.m3u"
        },
        tapmadpk: {
            title: "TAPMAD PK",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4X-7suwtvYWwoa6m0ngFTKZt5Hg5Z2kQF1g&usqp=CAU",
            catLink: "https://tv.noobon.top/playlist/tapmad.php"
        },
        worldtv: {
            title: "WORLD TV",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg8OiEwOT5UL5UttBZ5Tnhgsod8i2EQlfB97FFchdBOo8e_PfxvR8RJ68&s=10",
            catLink: "https://ranapk.short.gy/WorldTV11.m3u"
        },
        ayna: {
            title: "AYNA",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvAant65yQ_au1e51MFs-uiE6juswXv4ZJoNCpzBBSg4q7DzJ1NeliS80c&s=10",
            catLink: "https://playlist-cricfy.noobon.top/aynaott.php"
        },
        jiocinemaind: {
            title: "JIO CINEMA IND",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc3qZ1WgzPyFRX4cWIBJF0MSjWW3gZcLFycg&usqp=CAU",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jcinema.m3u"
        },
        dishtv: {
            title: "DISH TV",
            image: "https://m.media-amazon.com/images/S/stores-image-uploads-eu-prod/1/AmazonStores/A21TJRUUN4KGV/d5086253b614724be106c06be13f7d54.w600.h600._RO299,1,0,0,0,0,0,0,0,0,15_FMpng_.jpg",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/dishtv.m3u"
        },
        shooqpk: {
            title: "SHOOQ PK",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvSWLnpgyvbzV9rHkREzbsX1Rzh2IbEZBL8yPpSv8aCPmy1nVcv7BhIWQ&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/shoq.m3u"
        },
        samsungtv: {
            title: "SAMSUNG TV",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQI9T5vcm8wU-dLuaK5vBfoHpz8KL9Ru0aU1eoVaKNcqauxGtRTfvI1rGTA&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/samsungtv.m3u"
        },
        jagobd: {
            title: "JAGOBD",
            image: "https://www.jagobd.com/wp-content/uploads/2015/10/web_hi_res_512.png",
            catLink: "https://tv.noobon.top/playlist/jagobd.php"
        },
        pishow: {
            title: "PISHOW",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1hOo397X8uamgdXoknED8klICRLPCqwuEUtB394H2cc7YIyYiD78s-B8&s=10",
            catLink: "http://playlist-storage.pages.dev/PLAYLIST/playboxtv.m3u"
        },
        crichd: {
            title: "CRICHD",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ08h1gOe7MPxwehZBrbYKAUtjv22B6rAJ1kMkN-cea64Ka49KUyGU2lpTz&s=10",
            catLink: "https://github.com/abusaeeidx/CricHd-playlists-Auto-Update-permanent/raw/main/ALL.m3u"
        },
        zapsports: {
            title: "ZAP SPORTS",
            image: "https://i.ibb.co/dJfysm3V/zap-Sports.png",
            catLink: "https://tv.noobon.top/zapx/api.php?action=getIPTVPlaylist"
        },
        piratestv: {
            title: "Pirates TV",
            image: "https://raw.githubusercontent.com/FunctionError/Logos/main/Pirates-Tv.png",
            catLink: "https://raw.githubusercontent.com/FunctionError/PiratesTv/refs/heads/main/combined_playlist.m3u"
        },
        yupptv: {
            title: "YUPPTV",
            image: "https://d229kpbsb5jevy.cloudfront.net/bott/v2/networks/circularimages/yupptv.png",
            catLink: "https://tv.noobon.top/playlist/yapp.php"
        },
        dangaltv: {
            title: "DANGAL TV",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMnDuHwjd3WEFHmObqo53bAjkIB6E7JvIIPjGGGxqZzbNsKT85D_sRYNc&s=10",
            catLink: "https://playlist-storage.pages.dev/PLAYLIST/DangalPlay.m3u"
        },
        jiohotstar: {
            title: "JIOHOTSTAR",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPuz9ekmjh3vEpEc3lYL4nh6Gj7y2CQTswVG-ZCHnIS1foScuwPzuyxic&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jstar.m3u"
        },
        fancodebd: {
            title: "FANCODE BD",
            image: "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q",
            catLink: "https://ranapk.short.gy/FCBD/playlist.php"
        },
        jiobd: {
            title: "JIO BD",
            image: "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png",
            catLink: "https://ranapk.short.gy/JIOBD.m3u"
        },
        runtv: {
            title: "RUN TV",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7zqXTonSH_Xo--YxMlOacinf7mhLwuwSFFF1KJa8lGw&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/runn.m3u"
        },
        wavesott: {
            title: "WAVES OTT",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNyx_lxD3xXIB8jpFGnMnHZIziUo1vKW9sSS-7zP-h0vhZT4cPB6wly6o&s=10",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/waves.m3u"
        },
        toffeebd: {
            title: "TOFFEE BD",
            image: "https://yt3.googleusercontent.com/q0CJuxOL2f7Duy3hiM3uKArC_Zvji24XVGNfcf2TMqXMxTW6RO3R3tqwH2XAxbcz5TG-d2p6=s900-c-k-c0x00ffffff-no-rj",
            catLink: "https://playlist-cricfy.noobon.top/toffee.php"
        },
        zee5in2: {
            title: "ZEE5 IN 2",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU",
            catLink: "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/z5.m3u"
        },
        sonybd: {
            title: "SONY BD",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU",
            catLink: "https://ranapk.short.gy/sonybd/playlist.php"
        },
        ayna2: {
            title: "AYNA 2",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvAant65yQ_au1e51MFs-uiE6juswXv4ZJoNCpzBBSg4q7DzJ1NeliS80c&s=10",
            catLink: "https://bdix2.short.gy/AYNA/playlist.php"
        },
        akash: {
            title: "AKASH",
            image: "https://image.winudf.com/v2/image1/Y29tLmFrYXNoLmdvX2ljb25fMTcyMjU3ODg2N18wNTA/icon.png?w=184&fakeurl=1",
            catLink: "https://playlist-cricfy.noobon.top/akashgo.php"
        },
        freetv: {
            title: "FREE TV",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS4HoWswvKYjnMyenamwz-xBJq0PLSyZYpo0kp3oN6gw&s=10",
            catLink: "https://playlist-storage.pages.dev/PLAYLIST/freetv.m3u"
        },
        dishhomebd: {
            title: "DISH HOME BD",
            image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfc5DoDgZ5r5s1_umhMp0UUBENdkOUdWWFcSAzv-EUxA&s",
            catLink: "https://dish.data-vortex.workers.dev?token=42e4f5-2d863b-3c37d8-7f3f51"
        },
        freesports: {
            title: "FREE SPORTS",
            image: "https://media.unreel.me/prod/freelivesports/general/6496be67-a318-46c6-a25d-93c161f86845",
            catLink: "https://playlist-storage.pages.dev/PLAYLIST/freelivesports.m3u"
        }
    };

    let activeCatalogBaseUrl = null;
    let remoteBaseUrlsPromise = null;
    let providerCatalogPromise = null;
    const providerDetailCache = {};

    function trimToString(value) {
        return typeof value === "string" ? value.trim() : "";
    }

    function normalizeBaseUrl(value) {
        const normalized = trimToString(value).replace(/\/+$/, "");
        if (!normalized || /example\.com/i.test(normalized)) return "";
        return normalized;
    }

    function normalizeProviderKey(value) {
        return trimToString(value).toLowerCase().replace(/[^a-z0-9]/g, "");
    }

    function safeDecode(value) {
        try {
            return decodeURIComponent(value);
        } catch (_) {
            return value;
        }
    }

    function safeParseJson(value) {
        try {
            return JSON.parse(value);
        } catch (_) {
            return null;
        }
    }

    function getResponseStatus(response) {
        if (!response || typeof response !== "object") return 200;
        if (typeof response.status !== "undefined") return response.status;
        if (typeof response.statusCode !== "undefined") return response.statusCode;
        return 200;
    }

    function extractResponseBody(response) {
        if (typeof response === "string") return response;
        if (response && typeof response.body === "string") return response.body;
        return "";
    }

    function createAppInstanceId() {
        let value = "";
        while (value.length < 32) {
            value += Math.random().toString(16).slice(2);
        }
        return value.slice(0, 32);
    }

    async function postJson(url, payload, headers) {
        const body = JSON.stringify(payload);
        if (typeof http_post === "function") {
            return http_post(url, body, headers);
        }
        if (typeof fetch === "function") {
            const response = await fetch(url, {
                method: "POST",
                headers,
                body
            });
            return {
                status: response.status,
                body: await response.text()
            };
        }
        throw new Error("POST requests are not supported in this runtime");
    }

    async function fetchRemoteBaseUrls() {
        if (remoteBaseUrlsPromise) return remoteBaseUrlsPromise;

        remoteBaseUrlsPromise = (async function() {
            const endpoint = "https://firebaseremoteconfig.googleapis.com/v1/projects/" +
                FIREBASE_CONFIG.projectNumber +
                "/namespaces/firebase:fetch";
            const payload = {
                appInstanceId: createAppInstanceId(),
                appInstanceIdToken: "",
                appId: FIREBASE_CONFIG.appId,
                countryCode: "US",
                languageCode: "en-US",
                platformVersion: "30",
                timeZone: "UTC",
                appVersion: FIREBASE_CONFIG.appVersion,
                appBuild: FIREBASE_CONFIG.appBuild,
                packageName: FIREBASE_CONFIG.packageName,
                sdkVersion: FIREBASE_CONFIG.sdkVersion,
                analyticsUserProperties: {}
            };
            const headers = {
                "Content-Type": "application/json",
                "Accept": "application/json",
                "X-Android-Package": FIREBASE_CONFIG.packageName,
                "X-Goog-Api-Key": FIREBASE_CONFIG.apiKey,
                "X-Google-GFE-Can-Retry": "yes",
                "User-Agent": "okhttp/4.12.0"
            };

            try {
                const response = await postJson(endpoint, payload, headers);
                if (getResponseStatus(response) >= 400) return [];

                const data = safeParseJson(trimToString(extractResponseBody(response)));
                const entries = data && typeof data.entries === "object" ? data.entries : {};
                const urls = [];

                function addUrl(value) {
                    const normalized = normalizeBaseUrl(value);
                    if (normalized && urls.indexOf(normalized) === -1) {
                        urls.push(normalized);
                    }
                }

                addUrl(entries.cric_api2);
                addUrl(entries.cric_api1);
                return urls;
            } catch (_) {
                return [];
            }
        })();

        return remoteBaseUrlsPromise;
    }

    async function getCatalogBaseUrls() {
        const urls = [];

        function addUrl(value) {
            const normalized = normalizeBaseUrl(value);
            if (normalized && urls.indexOf(normalized) === -1) {
                urls.push(normalized);
            }
        }

        addUrl(activeCatalogBaseUrl);
        (await fetchRemoteBaseUrls()).forEach(addUrl);
        DEFAULT_BASE_URLS.forEach(addUrl);
        return urls;
    }

    async function fetchEncryptedJson(url) {
        const response = await http_get(url, {
            "User-Agent": "Dalvik/2.1.0 (Linux; U; Android 10; SM-A505F)",
            "Host": url.split("//")[1].split("/")[0]
        });
        const body = trimToString(extractResponseBody(response));
        if (!body) return null;

        const directData = safeParseJson(body);
        if (directData) return directData;

        const compactBody = body.replace(/\s+/g, "");
        if (!compactBody) return null;

        for (let index = 0; index < PROVIDER_KEYS.length; index++) {
            const keyInfo = PROVIDER_KEYS[index];
            try {
                const decrypted = await crypto.decryptAES(compactBody, keyInfo.key, keyInfo.iv);
                const parsed = safeParseJson(trimToString(decrypted));
                if (parsed) return parsed;
            } catch (_) {
                // Try the next key.
            }
        }

        return null;
    }

    async function fetchProviderCatalog() {
        if (providerCatalogPromise) return providerCatalogPromise;

        providerCatalogPromise = (async function() {
            const baseUrls = await getCatalogBaseUrls();
            for (let index = 0; index < baseUrls.length; index++) {
                const baseUrl = baseUrls[index];
                try {
                    const data = await fetchEncryptedJson(baseUrl + "/cats.txt");
                    if (Array.isArray(data) && data.length) {
                        activeCatalogBaseUrl = baseUrl;
                        return data;
                    }
                } catch (_) {
                    // Try the next host.
                }
            }
            return [];
        })();

        return providerCatalogPromise;
    }

    async function getCatalogProviderMap() {
        const catalog = await fetchProviderCatalog();
        const map = {};
        for (let index = 0; index < catalog.length; index++) {
            const provider = catalog[index];
            const key = normalizeProviderKey(provider && provider.title);
            if (key && !map[key]) {
                map[key] = provider;
            }
        }
        return map;
    }

    function ensurePosterUrl(title, poster) {
        const cleanPoster = trimToString(poster);
        if (cleanPoster && !cleanPoster.includes("placehold.co")) return cleanPoster;
        return "https://placehold.co/400x600.png?text=" + encodeURIComponent(trimToString(title) || "Channel");
    }

    function isPlaylistResponse(body) {
        const text = trimToString(body);
        return text.startsWith("#EXTM3U") || text.startsWith("#EXTINF") || text.startsWith("#KODIPROP");
    }

    function extractPlaylistText(body) {
        const text = trimToString(body);
        if (!text) return "";
        if (isPlaylistResponse(text)) return text;

        const extM3UIndex = text.indexOf("#EXTM3U");
        const extInfIndex = text.indexOf("#EXTINF");
        const kodiIndex = text.indexOf("#KODIPROP");
        const indexes = [extM3UIndex, extInfIndex, kodiIndex].filter(function(index) {
            return index >= 0;
        });

        if (!indexes.length) return "";
        return text.slice(Math.min.apply(null, indexes)).trim();
    }

    function looksLikeEncryptedPlaylist(text) {
        const compact = trimToString(text).replace(/\s+/g, "");
        return compact.length >= 79 && /^[A-Za-z0-9+/=]+$/.test(compact);
    }

    async function decryptContent(content) {
        const text = trimToString(content);
        if (!text || isPlaylistResponse(text) || !crypto || typeof crypto.decryptAES !== "function") {
            return text;
        }
        if (!looksLikeEncryptedPlaylist(text)) return text;

        try {
            const encryptedData = text.slice(0, 10) + text.slice(34, text.length - 54) + text.slice(text.length - 10);
            const ivBase64 = text.slice(10, 34);
            const keyBase64 = text.slice(text.length - 54, text.length - 10);
            const decrypted = await crypto.decryptAES(encryptedData, keyBase64, ivBase64);
            return trimToString(decrypted) || text;
        } catch (_) {
            return text;
        }
    }

    function getProviderByKey(providerKey) {
        return PROVIDERS[normalizeProviderKey(providerKey)] || null;
    }

    function getProviderBucket(providerKey) {
        for (let index = 0; index < SECTION_DEFINITIONS.length; index++) {
            const section = SECTION_DEFINITIONS[index];
            if (section.keys.indexOf(providerKey) !== -1) {
                return section.title;
            }
        }
        return "Other";
    }

    function buildProviderPayload(providerKey) {
        return JSON.stringify({
            kind: "provider",
            providerKey: providerKey
        });
    }

    function buildProviderCard(providerKey) {
        const provider = getProviderByKey(providerKey);
        if (!provider) return null;

        const bucket = getProviderBucket(providerKey);
        return new MultimediaItem({
            title: provider.title,
            url: buildProviderPayload(providerKey),
            posterUrl: ensurePosterUrl(provider.title, provider.image),
            type: "series",
            description: bucket + " provider",
            headers: {}
        });
    }

    async function buildPlaylistCandidates(provider) {
        const candidates = [];

        function addCandidate(value) {
            const normalized = trimToString(value);
            if (normalized && normalized !== "https://example.com" && candidates.indexOf(normalized) === -1) {
                candidates.push(normalized);
            }
        }

        const catalogByKey = await getCatalogProviderMap();
        addCandidate(catalogByKey[normalizeProviderKey(provider.title)] && catalogByKey[normalizeProviderKey(provider.title)].catLink);

        const fallbackKeys = PROVIDER_TITLE_FALLBACKS[normalizeProviderKey(provider.title)] || [];
        for (let index = 0; index < fallbackKeys.length; index++) {
            const fallbackKey = fallbackKeys[index];
            addCandidate(catalogByKey[fallbackKey] && catalogByKey[fallbackKey].catLink);
        }

        addCandidate(provider.catLink);
        if (Array.isArray(provider.candidateUrls)) {
            provider.candidateUrls.forEach(addCandidate);
        }

        return candidates;
    }

    async function fetchProviderPlaylist(provider) {
        const failures = [];
        const candidates = await buildPlaylistCandidates(provider);
        if (!candidates.length) {
            throw new Error("No playlist URL configured for " + provider.title);
        }

        for (let index = 0; index < candidates.length; index++) {
            const url = candidates[index];
            try {
                const response = await http_get(url, DEFAULT_HEADERS);
                const status = getResponseStatus(response);
                const rawBody = extractResponseBody(response);
                const directPlaylist = extractPlaylistText(rawBody);
                if (status >= 200 && status < 300 && directPlaylist) {
                    return directPlaylist;
                }

                const decryptedBody = await decryptContent(rawBody);
                const decryptedPlaylist = extractPlaylistText(decryptedBody);
                if (status >= 200 && status < 300 && decryptedPlaylist) {
                    return decryptedPlaylist;
                }

                const previewSource = decryptedBody || rawBody || "";
                const preview = trimToString(previewSource).slice(0, 120).replace(/\s+/g, " ") || "empty response body";
                failures.push(url + " -> " + status + " (" + preview + ")");
            } catch (error) {
                failures.push(url + " -> " + (error && error.message ? error.message : String(error)));
            }
        }

        throw new Error("Unable to fetch playlist for " + provider.title + ". " + failures.join(" | "));
    }

    function splitExtInfLine(line) {
        const payload = line.replace(/^#EXTINF:[^ ]+/, "").trim();
        let lastCommaIndex = -1;
        let insideQuotes = false;

        for (let index = 0; index < payload.length; index++) {
            const char = payload[index];
            if (char === "\"") {
                insideQuotes = !insideQuotes;
            } else if (char === "," && !insideQuotes) {
                lastCommaIndex = index;
            }
        }

        if (lastCommaIndex === -1) {
            return {
                attributesPart: payload,
                title: payload.replace(/^,/, "").trim() || "Unknown Channel"
            };
        }

        return {
            attributesPart: payload.slice(0, lastCommaIndex).trim(),
            title: payload.slice(lastCommaIndex + 1).trim() || "Unknown Channel"
        };
    }

    function extractAttributes(attributesPart) {
        const attributes = {};
        const regex = /(\w[-\w]*)\s*=\s*(?:"([^"]*)"|([^\s,]+))/gi;
        let match;

        while ((match = regex.exec(attributesPart)) !== null) {
            const key = match[1];
            const value = trimToString(match[2] || match[3] || "");
            if (key) attributes[key] = value;
        }

        return attributes;
    }

    function parseExtHttpLine(line) {
        return safeParseJson(line.replace(/^#EXTHTTP:/, "").trim());
    }

    function isHexString(value) {
        return /^[0-9a-f]+$/i.test(value) && value.length % 2 === 0;
    }

    function base64UrlToHexOrNull(value) {
        if (typeof atob !== "function") return null;
        try {
            const normalized = String(value || "").trim().replace(/-/g, "+").replace(/_/g, "/");
            if (!normalized) return null;
            const padding = normalized.length % 4 === 0 ? "" : "=".repeat(4 - (normalized.length % 4));
            const decoded = atob(normalized + padding);
            let hex = "";
            for (let index = 0; index < decoded.length; index++) {
                hex += decoded.charCodeAt(index).toString(16).padStart(2, "0");
            }
            return hex || null;
        } catch (_) {
            return null;
        }
    }

    function normalizeDrmValue(value) {
        const text = trimToString(value).replace(/-/g, "");
        if (!text || /^null$/i.test(text)) return "";
        if (isHexString(text)) return text.toLowerCase();
        const base64Hex = base64UrlToHexOrNull(text);
        return base64Hex || text;
    }

    function parseLicenseKeyPayload(licenseValue) {
        const normalizedLicense = trimToString(licenseValue);
        const result = { key: "", keyid: "", drmKeys: {}, licenseUrl: "" };
        if (!normalizedLicense) return result;

        if (/^https?:\/\//i.test(normalizedLicense)) {
            result.licenseUrl = normalizedLicense;
            return result;
        }

        if (normalizedLicense.startsWith("{")) {
            const parsed = safeParseJson(normalizedLicense);
            const keys = parsed && Array.isArray(parsed.keys) ? parsed.keys : [];
            for (let index = 0; index < keys.length; index++) {
                const entry = keys[index];
                if (!entry || typeof entry !== "object") continue;
                const keyid = normalizeDrmValue(entry.kid);
                const key = normalizeDrmValue(entry.k);
                if (keyid && key) {
                    result.drmKeys[keyid] = key;
                    if (!result.keyid) result.keyid = keyid;
                    if (!result.key) result.key = key;
                }
            }
            return result;
        }

        const separator = normalizedLicense.includes(":") ? ":" : (normalizedLicense.includes(",") ? "," : "");
        if (!separator) return result;
        const parts = normalizedLicense.split(separator, 2);
        result.keyid = normalizeDrmValue(parts[0]);
        result.key = normalizeDrmValue(parts[1]);
        return result;
    }

    function parsePipeSuffix(suffix) {
        const data = {
            headers: {},
            userAgent: "",
            cookie: "",
            key: "",
            keyid: "",
            licenseUrl: "",
            licenseType: ""
        };
        if (!suffix) return data;

        const pairs = String(suffix).split("&");
        for (let index = 0; index < pairs.length; index++) {
            const pair = pairs[index];
            const equalsIndex = pair.indexOf("=");
            if (equalsIndex === -1) continue;

            const rawKey = safeDecode(pair.slice(0, equalsIndex).trim());
            const rawValue = safeDecode(pair.slice(equalsIndex + 1).trim());
            const key = rawKey.toLowerCase();
            const value = trimToString(rawValue);

            if (!rawKey || !value) continue;

            if (key === "user-agent") {
                data.headers["User-Agent"] = value;
                data.userAgent = value;
            } else if (key === "cookie") {
                data.headers["Cookie"] = value;
                data.cookie = value;
            } else if (key === "referer" || key === "referrer") {
                data.headers["Referer"] = value;
            } else if (key === "origin") {
                data.headers["Origin"] = value;
            } else if (key === "key" || key === "drm-key") {
                data.key = normalizeDrmValue(value);
            } else if (key === "keyid" || key === "kid" || key === "drm-keyid") {
                data.keyid = normalizeDrmValue(value);
            } else if (key === "licenseurl" || key === "drmlicense" || key === "drmlicenseurl") {
                data.licenseUrl = value;
            } else if (key === "drmscheme" || key === "license_type") {
                data.licenseType = value.toLowerCase();
            } else {
                data.headers[rawKey] = value;
            }
        }

        return data;
    }

    function parseStreamLine(line) {
        const separatorIndex = line.indexOf("|");
        const urlPart = separatorIndex === -1 ? line : line.slice(0, separatorIndex);
        const suffix = separatorIndex === -1 ? "" : line.slice(separatorIndex + 1);
        const pipeData = parsePipeSuffix(suffix);

        return {
            url: trimToString(urlPart),
            headers: pipeData.headers,
            userAgent: pipeData.userAgent,
            cookie: pipeData.cookie,
            key: pipeData.key,
            keyid: pipeData.keyid,
            licenseUrl: pipeData.licenseUrl,
            licenseType: pipeData.licenseType
        };
    }

    function isPlayableUrl(url) {
        return /^[a-z][a-z0-9+.-]*:\/\//i.test(trimToString(url));
    }

    function parseM3UToChannels(m3uString, provider) {
        const lines = String(m3uString || "").split(/\r?\n/);
        const channels = [];
        let bufferedTitle = "";
        let bufferedAttributes = {};
        let bufferedHeaders = {};
        let bufferedUserAgent = "";
        let bufferedCookie = "";
        let bufferedKey = "";
        let bufferedKeyid = "";
        let bufferedLicenseUrl = "";
        let bufferedLicenseType = "";
        let bufferedDrmKeys = {};

        function resetBuffers() {
            bufferedTitle = "";
            bufferedAttributes = {};
            bufferedHeaders = {};
            bufferedUserAgent = "";
            bufferedCookie = "";
            bufferedKey = "";
            bufferedKeyid = "";
            bufferedLicenseUrl = "";
            bufferedLicenseType = "";
            bufferedDrmKeys = {};
        }

        for (let index = 0; index < lines.length; index++) {
            const line = trimToString(lines[index]);
            if (!line) continue;

            if (line.startsWith("#EXTINF")) {
                const extInfParts = splitExtInfLine(line);
                bufferedTitle = extInfParts.title;
                bufferedAttributes = extractAttributes(extInfParts.attributesPart);
                if (!bufferedKey) bufferedKey = normalizeDrmValue(bufferedAttributes.key || bufferedAttributes["drm-key"] || "");
                if (!bufferedKeyid) bufferedKeyid = normalizeDrmValue(bufferedAttributes.keyid || bufferedAttributes.kid || bufferedAttributes["drm-keyid"] || "");
                continue;
            }

            if (line.startsWith("#EXTHTTP:")) {
                const extHttp = parseExtHttpLine(line);
                if (extHttp && typeof extHttp === "object") {
                    if (trimToString(extHttp.cookie)) bufferedCookie = trimToString(extHttp.cookie);
                    if (trimToString(extHttp["user-agent"])) bufferedUserAgent = trimToString(extHttp["user-agent"]);
                }
                continue;
            }

            if (line.startsWith("#EXTVLCOPT:")) {
                const optionMatch = /^#EXTVLCOPT:([^=]+)=(.*)$/.exec(line);
                if (optionMatch) {
                    const optionKey = trimToString(optionMatch[1]).toLowerCase();
                    const optionValue = trimToString(optionMatch[2]);
                    if (optionKey === "http-user-agent" && optionValue) {
                        bufferedUserAgent = optionValue;
                    } else if ((optionKey === "http-referrer" || optionKey === "http-referer") && optionValue) {
                        bufferedHeaders.Referer = optionValue;
                    }
                }
                continue;
            }

            if (line.startsWith("#KODIPROP:inputstream.adaptive.license_type=")) {
                bufferedLicenseType = trimToString(line.split("=").slice(1).join("=")).toLowerCase();
                continue;
            }

            if (line.startsWith("#KODIPROP:inputstream.adaptive.license_key=")) {
                const parsedLicense = parseLicenseKeyPayload(trimToString(line.split("=").slice(1).join("=")));
                if (parsedLicense.licenseUrl) bufferedLicenseUrl = parsedLicense.licenseUrl;
                if (parsedLicense.key) bufferedKey = parsedLicense.key;
                if (parsedLicense.keyid) bufferedKeyid = parsedLicense.keyid;
                if (parsedLicense.drmKeys && Object.keys(parsedLicense.drmKeys).length) bufferedDrmKeys = parsedLicense.drmKeys;
                continue;
            }

            if (line.startsWith("#")) continue;

            const streamLine = parseStreamLine(line);
            if (!isPlayableUrl(streamLine.url)) {
                resetBuffers();
                continue;
            }

            const headers = Object.assign({}, bufferedHeaders, streamLine.headers);
            const userAgent = streamLine.userAgent || bufferedUserAgent;
            const cookie = streamLine.cookie || bufferedCookie;
            const key = streamLine.key || bufferedKey;
            const keyid = streamLine.keyid || bufferedKeyid;
            const licenseUrl = streamLine.licenseUrl || bufferedLicenseUrl;
            const licenseType = streamLine.licenseType || bufferedLicenseType || (licenseUrl ? "widevine" : "");

            if (userAgent && !headers["User-Agent"]) headers["User-Agent"] = userAgent;
            if (cookie && !headers["Cookie"]) headers["Cookie"] = cookie;

            const title = bufferedTitle || trimToString(bufferedAttributes["tvg-name"]) || "Unknown Channel";
            const group = trimToString(bufferedAttributes["group-title"]) || "Other Channels";
            const poster = ensurePosterUrl(title, bufferedAttributes["tvg-logo"] || "");

            channels.push({
                title: title,
                group: group,
                poster: poster,
                url: streamLine.url,
                headers: headers,
                userAgent: userAgent,
                cookie: cookie,
                key: key,
                keyid: keyid,
                licenseUrl: licenseUrl,
                licenseType: licenseType,
                drmKeys: bufferedDrmKeys,
                providerKey: normalizeProviderKey(provider.title),
                providerTitle: provider.title
            });

            resetBuffers();
        }

        return channels;
    }

    function buildProviderEpisodes(provider, channels) {
        const sortedChannels = channels.slice().sort(function(left, right) {
            const groupCompare = left.group.localeCompare(right.group);
            if (groupCompare !== 0) return groupCompare;
            return left.title.localeCompare(right.title);
        });
        const groupIndexes = {};
        const groupCounts = {};
        let nextGroupIndex = 1;

        return sortedChannels.map(function(channel) {
            if (!groupIndexes[channel.group]) {
                groupIndexes[channel.group] = nextGroupIndex;
                nextGroupIndex += 1;
                groupCounts[channel.group] = 0;
            }
            groupCounts[channel.group] += 1;
            return new Episode({
                name: channel.group + " - " + channel.title,
                season: groupIndexes[channel.group],
                episode: groupCounts[channel.group],
                url: JSON.stringify({
                    kind: "channel",
                    providerKey: normalizeProviderKey(provider.title),
                    data: channel
                }),
                posterUrl: channel.poster,
                description: provider.title + " - " + channel.group,
                headers: channel.headers || {}
            });
        });
    }

    async function getProviderDetail(providerKey) {
        const normalizedKey = normalizeProviderKey(providerKey);
        if (providerDetailCache[normalizedKey]) return providerDetailCache[normalizedKey];

        providerDetailCache[normalizedKey] = (async function() {
            const provider = getProviderByKey(normalizedKey);
            if (!provider) throw new Error("Unknown provider");

            const playlist = await fetchProviderPlaylist(provider);
            const channels = parseM3UToChannels(playlist, provider);
            if (!channels.length) {
                throw new Error(provider.title + " returned an empty playlist");
            }

            return {
                provider: provider,
                channels: channels,
                episodes: buildProviderEpisodes(provider, channels)
            };
        })();

        return providerDetailCache[normalizedKey];
    }

    function buildHomeSections() {
        const sections = {};

        for (let index = 0; index < SECTION_DEFINITIONS.length; index++) {
            const section = SECTION_DEFINITIONS[index];
            const items = [];
            for (let keyIndex = 0; keyIndex < section.keys.length; keyIndex++) {
                const card = buildProviderCard(section.keys[keyIndex]);
                if (card) items.push(card);
            }
            if (items.length) sections[section.title] = items;
        }

        return sections;
    }

    function buildProviderSearchResults(query) {
        const loweredQuery = trimToString(query).toLowerCase();
        const results = [];

        Object.keys(PROVIDERS).forEach(function(providerKey) {
            const provider = PROVIDERS[providerKey];
            const haystack = [
                provider.title,
                providerKey,
                getProviderBucket(providerKey)
            ].join(" ").toLowerCase();

            if (!loweredQuery || haystack.includes(loweredQuery)) {
                const card = buildProviderCard(providerKey);
                if (card) results.push(card);
            }
        });

        return results.sort(function(left, right) {
            return String(left.title).localeCompare(String(right.title));
        });
    }

    async function getHome(cb) {
        try {
            cb({ success: true, data: buildHomeSections() });
        } catch (error) {
            cb({ success: false, errorCode: "PARSE_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    async function search(query, cb) {
        try {
            cb({ success: true, data: buildProviderSearchResults(query) });
        } catch (error) {
            cb({ success: false, errorCode: "SEARCH_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    async function load(url, cb) {
        try {
            const payload = safeParseJson(url);
            if (!payload || payload.kind !== "provider" || !trimToString(payload.providerKey)) {
                return cb({ success: false, errorCode: "LOAD_ERROR", message: "Invalid provider payload" });
            }

            const detail = await getProviderDetail(payload.providerKey);
            const provider = detail.provider;
            cb({
                success: true,
                data: new MultimediaItem({
                    title: provider.title,
                    url: buildProviderPayload(normalizeProviderKey(provider.title)),
                    posterUrl: ensurePosterUrl(provider.title, provider.image),
                    type: "series",
                    description: "Browse live channels from " + provider.title,
                    tags: [getProviderBucket(normalizeProviderKey(provider.title))],
                    headers: {},
                    episodes: detail.episodes
                })
            });
        } catch (error) {
            cb({ success: false, errorCode: "LOAD_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    async function loadStreams(url, cb) {
        try {
            const payload = safeParseJson(url);
            const channelData = payload && payload.kind === "channel" ? payload.data : null;
            if (!channelData || !trimToString(channelData.url)) {
                return cb({ success: false, errorCode: "STREAM_ERROR", message: "Missing stream data" });
            }

            const headers = Object.assign({}, channelData.headers || {});
            if (trimToString(channelData.userAgent) && !headers["User-Agent"]) headers["User-Agent"] = trimToString(channelData.userAgent);
            if (trimToString(channelData.cookie) && !headers["Cookie"]) headers["Cookie"] = trimToString(channelData.cookie);

            const stream = new StreamResult({
                url: trimToString(channelData.url),
                source: trimToString(channelData.providerTitle) || trimToString(channelData.title) || "Auto",
                headers: headers
            });

            const normalizedKey = normalizeDrmValue(channelData.key);
            const normalizedKeyid = normalizeDrmValue(channelData.keyid);
            if (normalizedKey && normalizedKeyid) {
                stream.drmType = "clearkey";
                stream.drmKey = normalizedKey;
                stream.drmKid = normalizedKeyid;
            } else if (trimToString(channelData.licenseUrl)) {
                const licenseUrl = trimToString(channelData.licenseUrl);
                stream.drmType = trimToString(channelData.licenseType) || "widevine";
                stream.licenseUrl = licenseUrl;
                stream.drmLicenseUrl = licenseUrl;
            }

            cb({ success: true, data: [stream] });
        } catch (error) {
            cb({ success: false, errorCode: "STREAM_ERROR", message: error && error.message ? error.message : String(error) });
        }
    }

    globalThis.getHome = getHome;
    globalThis.search = search;
    globalThis.load = load;
    globalThis.loadStreams = loadStreams;
})();
