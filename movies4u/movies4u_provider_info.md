# Movies4u Provider Detailed Information

## 1. Overview
The **Movies4u** provider is a scraper implemented within the `CineStream` plugin for the Cloudstream framework. It scrapes `movies4u.style` (and its mirrors) for movie and TV show links, including high-quality cloud storage mirrors.

## 2. Key Files & Locations
- **Registration:** `com/megix/ProviderRegistry.kt`
- **Core Logic:** `com/megix/CineStreamExtractors.kt` (Function: `invokeMovies4u`)
- **API Constants:** `com/megix/ApiConstants.kt`
- **Utility Functions:** `com/megix/CineStreamUtils.kt`
- **Dynamic URL Config:** `https://raw.githubusercontent.com/SaurabhKaperwan/Utils/refs/heads/main/urls.json`

## 3. Configuration & Connectivity
- **Internal Key:** `p_movies4u`
- **Display Name:** `Movies4u`
- **Base URL:** Dynamic, currently `https://new1.movies4u.style` (fetched via `api("movies4u")`).
- **Headers:**
  - `Cookie`: `xla=s4t`
  - `User-Agent`: `Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36`
  - `Referer`: `Base URL`

## 4. Scraping Logic (`invokeMovies4u`)

### A. Search Phase
1. **Query Construction:**
   - **Movies:** `${title} ${year}`
   - **TV Shows:** `${title} season ${season}`
2. **Endpoint:** `${movies4uAPI}/?s=${searchQuery}`
3. **Parsing:** Selects `article h3 a` to find post links.

### B. Validation Phase
- For each search result, it visits the post page.
- It extracts the **IMDb ID** from the link containing "IMDb Rating".
- It verifies if the extracted IMDb ID matches the requested ID (`imdbId != id.toString()`).

### C. Extraction Phase (Movies)
- Navigates to a secondary page via the link in `div.download-links-div a.btn`.
- Scrapes all source buttons from `div.downloads-btns-div a.btn`.
- Passes each URL to `loadSourceNameExtractor`.

### D. Extraction Phase (TV Shows)
- Identifies the correct **Season Block** using `div.downloads-btns-div` and matching the header text (e.g., "Season 1").
- Follows the season link to an **Episode List** page.
- Selects the requested **Episode Block** and extracts all available source links (`a.btn`).

## 5. Source Link Handling (`loadSourceNameExtractor`)
The provider doesn't just return raw video links; it handles various cloud and redirector domains specifically:
- **HubCloud / VCloud:** Handled by `HubCloud()` extractor.
- **GDFlix / GDLink:** Handled by `GDFlix()` extractor.
- **FastDLServer:** Handled by `fastdlserver()` extractor.
- **Linksmod:** Handled by `Linksmod()` extractor.
- **Hubdrive:** Handled by `Hubdrive()` extractor.
- **Gofile:** Handled by `Gofile()` extractor.
- **Driveleech / Driveseed:** Handled by `Driveleech()` extractor.
- **Howblogs:** Handled by `Howblogs()` extractor.
- **Others:** Falls back to the standard `loadExtractor(url, ...)` for generic video hosts.

## 6. Implementation Snippet
```kotlin
val searchQuery = if(season == null) "${title?.replace(" ", "+")}+${year}" else "${title?.replace(" ", "+")}+season+${season}"
val searchUrl = "$movies4uAPI/?s=$searchQuery"
// ...
val imdbId = postDoc.select("p a:contains(IMDb Rating)").attr("href")
                .substringAfter("title/").substringBefore("/")
```

## 7. Dependencies
- **Cloudstream Core:** Uses `ExtractorLink`, `SubtitleFile`, and `app` (NiceHttp).
- **Utils:** Uses `safeAmap` for parallel processing and `toSansSerifBold` for formatting UI labels.
