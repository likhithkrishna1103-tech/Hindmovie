package com.megix;

import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CineStreamProvider.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/movies4u/.jadx/cinestream/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001:\u000bRSTUVWXYZ[\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010+\u001a\u00020/2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002050)2\u0006\u00106\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0004\u0018\u0001092\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107JF\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u000e2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020@0>H\u0096@¢\u0006\u0002\u0010CJ \u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\u0004\u0018\u00010\u00182\u0006\u0010J\u001a\u00020KH\u0002¢\u0006\u0002\u0010LJ\u0017\u0010M\u001a\u0004\u0018\u00010\u00182\u0006\u0010J\u001a\u00020KH\u0002¢\u0006\u0002\u0010LJR\u0010N\u001a\u00020@2\u0006\u0010J\u001a\u00020K2\b\u0010O\u001a\u0004\u0018\u00010\u00182\b\u0010P\u001a\u0004\u0018\u00010\u00182\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020@0>H\u0082@¢\u0006\u0002\u0010QR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0014\u0010\u001b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0014\u0010\u001d\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0014\u0010\u001f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0014\u0010!\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006]"}, d2 = {"Lcom/megix/CineStreamProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "skipMap", "", "", "cinemeta_url", "getCinemeta_url", "kitsu_url", "getKitsu_url", "haglund_url", "getHaglund_url", "image_proxy", "getImage_proxy", "aiometa_url", "getAiometa_url", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "getPosterUrl", "url", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExternalIds", "Lcom/megix/CineStreamProvider$ExtenalIds;", "id", "type", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getYear", "res", "Lcom/megix/CineStreamProvider$LoadLinksData;", "(Lcom/megix/CineStreamProvider$LoadLinksData;)Ljava/lang/Integer;", "getSeasonYear", "runKitsuInvokers", "year", "seasonYear", "(Lcom/megix/CineStreamProvider$LoadLinksData;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoadLinksData", "PassData", "Meta", "AppExtras", "Cast", "SearchResult", "Media", "EpisodeDetails", "ResponseData", "Home", "ExtenalIds", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCineStreamProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CineStreamProvider.kt\ncom/megix/CineStreamProvider\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,545:1\n23#2,2:546\n15#2:548\n25#2,2:551\n15#2:567\n23#2,2:570\n15#2:572\n25#2,2:575\n15#2:588\n23#2,2:591\n15#2:593\n25#2,2:596\n23#2,2:598\n15#2:600\n25#2,2:603\n50#3:549\n43#3:550\n50#3:568\n43#3:569\n50#3:573\n43#3:574\n50#3:589\n43#3:590\n50#3:594\n43#3:595\n50#3:601\n43#3:602\n1642#4,10:553\n1915#4:563\n1916#4:565\n1652#4:566\n1807#4,3:578\n777#4:581\n873#4,2:582\n1586#4:584\n1661#4,3:585\n1#5:564\n1#5:577\n*S KotlinDebug\n*F\n+ 1 CineStreamProvider.kt\ncom/megix/CineStreamProvider\n*L\n94#1:546,2\n94#1:548\n94#1:551,2\n168#1:567\n179#1:570,2\n179#1:572\n179#1:575,2\n312#1:588\n478#1:591,2\n478#1:593\n478#1:596,2\n504#1:598,2\n504#1:600\n504#1:603,2\n94#1:549\n94#1:550\n168#1:568\n168#1:569\n179#1:573\n179#1:574\n312#1:589\n312#1:590\n478#1:594\n478#1:595\n504#1:601\n504#1:602\n103#1:553,10\n103#1:563\n103#1:565\n103#1:566\n205#1:578,3\n253#1:581\n253#1:582,2\n254#1:584\n254#1:585,3\n103#1:564\n*E\n"})
public class CineStreamProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://cinemeta-catalogs.strem.io";

    @NotNull
    private String name = "CineStream";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Map<String, Integer> skipMap = new LinkedHashMap();

    @NotNull
    private final String cinemeta_url = "https://v3-cinemeta.strem.io";

    @NotNull
    private final String kitsu_url = "https://anime-kitsu.strem.fun";

    @NotNull
    private final String haglund_url = "https://arm.haglund.dev/api/v2";

    @NotNull
    private final String image_proxy = "https://wsrv.nl/?url=";

    @NotNull
    private final String aiometa_url = "https://aiometadata.elfhosted.com/stremio/9197a4a9-2f5b-4911-845e-8704c520bdf7";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama, TvType.Anime, TvType.Torrent});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###", "Top Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###", "Top Series"), TuplesKt.to(this.aiometa_url + "/catalog/anime/mal.airing/skip=###", "Top Airing Anime"), TuplesKt.to(this.kitsu_url + "/catalog/anime/kitsu-anime-trending/skip=###", "Top Anime"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Action", "Top Action Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Action", "Top Action Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Comedy", "Top Comedy Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Comedy", "Top Comedy Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Romance", "Top Romance Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Romance", "Top Romance Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Horror", "Top Horror Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Horror", "Top Horror Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Thriller", "Top Thriller Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Thriller", "Top Thriller Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Sci-Fi", "Top Sci-Fi Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Sci-Fi", "Top Sci-Fi Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Fantasy", "Top Fantasy Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Fantasy", "Top Fantasy Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Mystery", "Top Mystery Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Mystery", "Top Mystery Series"), TuplesKt.to(getMainUrl() + "/top/catalog/movie/top/skip=###&genre=Crime", "Top Crime Movies"), TuplesKt.to(getMainUrl() + "/top/catalog/series/top/skip=###&genre=Crime", "Top Crime Series")});

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$getExternalIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider", f = "CineStreamProvider.kt", i = {0, 0, 0}, l = {477}, m = "getExternalIds", n = {"id", "type", "url"}, nl = {478}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineStreamProvider.this.getExternalIds(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$getMainPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider", f = "CineStreamProvider.kt", i = {0, 0, 0, 0, 0}, l = {93}, m = "getMainPage$suspendImpl", n = {"$this", "request", "newRequestData", "page", "skip"}, nl = {94}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 2)
    static final class C01221 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01221(Continuation<? super C01221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineStreamProvider.getMainPage$suspendImpl(CineStreamProvider.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider", f = "CineStreamProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {178, 183, 199, 235, 287}, m = "load$suspendImpl", n = {"$this", "url", "movie", "tvtype", "id", "type", "meta_url", "kitsuId", "isKitsu", "$this", "url", "movie", "tvtype", "id", "type", "meta_url", "kitsuId", "json", "movieData", "isKitsu", "$this", "url", "movie", "tvtype", "id", "type", "meta_url", "kitsuId", "json", "movieData", "externalIds", "malId", "anilistId", "title", "engTitle", "posterUrl", "logo", "imdbRating", "year", "releaseInfo", "tmdbId", "description", "isKitsu", "$this", "url", "movie", "tvtype", "id", "type", "meta_url", "kitsuId", "json", "movieData", "externalIds", "malId", "anilistId", "title", "engTitle", "posterUrl", "logo", "imdbRating", "year", "releaseInfo", "tmdbId", "description", "actors", "country", "genre", "background", "isAnime", "data", "isKitsu", "isCartoon", "isBollywood", "isAsian", "$this", "url", "movie", "tvtype", "id", "type", "meta_url", "kitsuId", "json", "movieData", "externalIds", "malId", "anilistId", "title", "engTitle", "posterUrl", "logo", "imdbRating", "year", "releaseInfo", "tmdbId", "description", "actors", "country", "genre", "background", "isAnime", "episodes", "isKitsu", "isCartoon", "isBollywood", "isAsian"}, nl = {179, 184, 196, 252, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "I$0", "I$1", "Z$0", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "I$0", "I$1", "Z$0", "I$2"}, v = 2)
    static final class C01231 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01231(Continuation<? super C01231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineStreamProvider.load$suspendImpl(CineStreamProvider.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider", f = "CineStreamProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {318, 322}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "res", "year", "seasonYear", "isCasting", "$this", "data", "subtitleCallback", "callback", "res", "year", "seasonYear", "isCasting"}, nl = {319, 357}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C01241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01241(Continuation<? super C01241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineStreamProvider.loadLinks$suspendImpl(CineStreamProvider.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$runKitsuInvokers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider", f = "CineStreamProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {503, 517}, m = "runKitsuInvokers", n = {"res", "year", "seasonYear", "subtitleCallback", "callback", "imdbTitle", "imdbYear", "tmdbId", "res", "year", "seasonYear", "subtitleCallback", "callback", "imdbTitle", "imdbYear", "tmdbId"}, nl = {504, 542}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C01271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C01271(Continuation<? super C01271> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CineStreamProvider.this.runKitsuInvokers(null, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function12, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function12, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public final String getCinemeta_url() {
        return this.cinemeta_url;
    }

    @NotNull
    public final String getKitsu_url() {
        return this.kitsu_url;
    }

    @NotNull
    public final String getHaglund_url() {
        return this.haglund_url;
    }

    @NotNull
    public final String getImage_proxy() {
        return this.image_proxy;
    }

    @NotNull
    public final String getAiometa_url() {
        return this.aiometa_url;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    static /* synthetic */ String getPosterUrl$default(CineStreamProvider cineStreamProvider, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPosterUrl");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return cineStreamProvider.getPosterUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPosterUrl(String url) {
        if (url == null) {
            return null;
        }
        if (StringsKt.contains$default(url, "metahub.space", false, 2, (Object) null) || StringsKt.contains$default(url, "kitsu.", false, 2, (Object) null)) {
            return this.image_proxy + url;
        }
        return url;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object getMainPage$suspendImpl(com.megix.CineStreamProvider r33, int r34, com.lagradost.cloudstream3.MainPageRequest r35, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r36) {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.getMainPage$suspendImpl(com.megix.CineStreamProvider, int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(CineStreamProvider this$0, Media $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.getPosterUrl($movie.getPoster()));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($movie.getImdbRating()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$search$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider$search$2", f = "CineStreamProvider.kt", i = {0, 0}, l = {154}, m = "invokeSuspend", n = {"$this$coroutineScope", "endpoints"}, nl = {152}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nCineStreamProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CineStreamProvider.kt\ncom/megix/CineStreamProvider$search$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,545:1\n1586#2:546\n1661#2,3:547\n1586#2:558\n1661#2,3:559\n1#3:550\n23#4,2:551\n15#4:553\n25#4,2:556\n50#5:554\n43#5:555\n*S KotlinDebug\n*F\n+ 1 CineStreamProvider.kt\ncom/megix/CineStreamProvider$search$2\n*L\n152#1:546\n152#1:547,3\n127#1:558\n127#1:559,3\n127#1:551,2\n127#1:553\n127#1:556,2\n127#1:554\n127#1:555\n*E\n"})
    static final class C01282 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SearchResponse>>, Object> {
        final /* synthetic */ String $query;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01282(String str, Continuation<? super C01282> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01282 = CineStreamProvider.this.new C01282(this.$query, continuation);
            c01282.L$0 = obj;
            return c01282;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SearchResponse>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objAwaitAll;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Integer num = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable endpoints = CollectionsKt.listOf(new String[]{CineStreamProvider.this.getCinemeta_url() + "/catalog/movie/top/search=" + this.$query + ".json", CineStreamProvider.this.getCinemeta_url() + "/catalog/series/top/search=" + this.$query + ".json", CineStreamProvider.this.getKitsu_url() + "/catalog/anime/kitsu-anime-airing/search=" + this.$query + ".json"});
                    Iterable $this$map$iv = endpoints;
                    CineStreamProvider cineStreamProvider = CineStreamProvider.this;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CineStreamProvider$search$2$resultsLists$1$1(it, $this$coroutineScope, cineStreamProvider, null), 3, (Object) null));
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(endpoints);
                    this.label = 1;
                    objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAwaitAll = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<List> resultsLists = (List) objAwaitAll;
            Iterator it2 = resultsLists.iterator();
            if (it2.hasNext()) {
                List it3 = (List) it2.next();
                Integer numBoxInt = Boxing.boxInt(it3.size());
                while (true) {
                    num = numBoxInt;
                    while (it2.hasNext()) {
                        List it4 = (List) it2.next();
                        numBoxInt = Boxing.boxInt(it4.size());
                        if (num.compareTo(numBoxInt) < 0) {
                            break;
                        }
                    }
                }
            }
            Integer num2 = num;
            int maxSize = num2 != null ? num2.intValue() : 0;
            List $this$invokeSuspend_u24lambda_u243 = CollectionsKt.createListBuilder();
            for (int i = 0; i < maxSize; i++) {
                for (List list : resultsLists) {
                    if (i < list.size()) {
                        $this$invokeSuspend_u24lambda_u243.add(list.get(i));
                    }
                }
            }
            return CollectionsKt.build($this$invokeSuspend_u24lambda_u243);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01b9 A[Catch: all -> 0x01c4, TryCatch #1 {all -> 0x01c4, blocks: (B:24:0x00b1, B:34:0x00e1, B:36:0x00e5, B:38:0x00eb, B:39:0x0101, B:41:0x0107, B:43:0x0115, B:48:0x0127, B:50:0x013e, B:52:0x0160, B:51:0x015c, B:45:0x011f, B:53:0x01ae, B:55:0x01bf, B:54:0x01b9, B:29:0x00c5), top: B:74:0x00b1 }] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01fa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object invokeSuspend$fetchResults(kotlinx.coroutines.CoroutineScope r30, com.megix.CineStreamProvider r31, java.lang.String r32, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r33) {
            /*
                Method dump skipped, instruction units count: 520
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.C01282.invokeSuspend$fetchResults(kotlinx.coroutines.CoroutineScope, com.megix.CineStreamProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    static /* synthetic */ Object search$suspendImpl(CineStreamProvider $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        return CoroutineScopeKt.coroutineScope($this.new C01282(query, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x076c A[PHI: r27
      0x076c: PHI (r27v22 java.lang.CharSequence) = (r27v9 java.lang.CharSequence), (r27v23 java.lang.CharSequence) binds: [B:185:0x0768, B:182:0x0763] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0771  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0a91  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0a94  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0a9d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0b8e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0b8f  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0734 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0539  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object load$suspendImpl(com.megix.CineStreamProvider r61, java.lang.String r62, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r63) {
        /*
            Method dump skipped, instruction units count: 3010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.load$suspendImpl(com.megix.CineStreamProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider$load$2", f = "CineStreamProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ Integer $anilistId;
        final /* synthetic */ String $background;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ Ref.ObjectRef<String> $id;
        final /* synthetic */ Double $imdbRating;
        final /* synthetic */ boolean $isKitsu;
        final /* synthetic */ String $logo;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ String $releaseInfo;
        final /* synthetic */ String $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, List<String> list, Double d, String str3, String str4, String str5, String str6, boolean z, List<ActorData> list2, Integer num, Integer num2, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$description = str2;
            this.$genre = list;
            this.$imdbRating = d;
            this.$year = str3;
            this.$releaseInfo = str4;
            this.$background = str5;
            this.$logo = str6;
            this.$isKitsu = z;
            this.$actors = list2;
            this.$anilistId = num;
            this.$malId = num2;
            this.$id = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$posterUrl, this.$description, this.$genre, this.$imdbRating, this.$year, this.$releaseInfo, this.$background, this.$logo, this.$isKitsu, this.$actors, this.$anilistId, this.$malId, this.$id, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer intOrNull;
            String strSubstringBefore$default;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$posterUrl);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$genre);
                    loadResponse.setScore(Score.Companion.from10(this.$imdbRating));
                    String str = this.$year;
                    if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                        String str2 = this.$releaseInfo;
                        intOrNull = str2 != null ? StringsKt.toIntOrNull(str2) : null;
                        if (intOrNull == null) {
                            String str3 = this.$year;
                            intOrNull = (str3 == null || (strSubstringBefore$default = StringsKt.substringBefore$default(str3, "-", (String) null, 2, (Object) null)) == null) ? null : StringsKt.toIntOrNull(strSubstringBefore$default);
                        }
                    }
                    loadResponse.setYear(intOrNull);
                    loadResponse.setBackgroundPosterUrl(this.$background);
                    loadResponse.setLogoUrl(this.$logo);
                    loadResponse.setContentRating(this.$isKitsu ? "Kitsu" : "IMDB");
                    loadResponse.setActors(this.$actors);
                    LoadResponse.Companion.addAniListId(loadResponse, this.$anilistId);
                    LoadResponse.Companion.addMalId(loadResponse, this.$malId);
                    LoadResponse.Companion.addImdbId(loadResponse, (String) this.$id.element);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0(EpisodeDetails $ep, CineStreamProvider this$0, Episode $this$newEpisode) {
        String name = $ep.getName();
        if (name == null) {
            name = $ep.getTitle();
        }
        $this$newEpisode.setName(name);
        $this$newEpisode.setSeason(Integer.valueOf($ep.getSeason()));
        $this$newEpisode.setEpisode(Integer.valueOf($ep.getEpisode()));
        $this$newEpisode.setPosterUrl(this$0.getPosterUrl($ep.getThumbnail()));
        $this$newEpisode.setDescription($ep.getOverview());
        Score.Companion companion = Score.Companion;
        String rating = $ep.getRating();
        $this$newEpisode.setScore(companion.from10(rating != null ? StringsKt.toDoubleOrNull(rating) : null));
        String firstAired = $ep.getFirstAired();
        if (firstAired == null) {
            firstAired = $ep.getReleased();
        }
        MainAPIKt.addDate$default($this$newEpisode, firstAired, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$load$3, reason: invalid class name */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider$load$3", f = "CineStreamProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ Integer $anilistId;
        final /* synthetic */ String $background;
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ Ref.ObjectRef<String> $id;
        final /* synthetic */ Double $imdbRating;
        final /* synthetic */ boolean $isKitsu;
        final /* synthetic */ String $logo;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ String $releaseInfo;
        final /* synthetic */ String $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<Episode> list, String str, String str2, String str3, String str4, String str5, List<String> list2, String str6, Double d, boolean z, List<ActorData> list3, Integer num, Integer num2, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.$posterUrl = str;
            this.$background = str2;
            this.$year = str3;
            this.$releaseInfo = str4;
            this.$description = str5;
            this.$genre = list2;
            this.$logo = str6;
            this.$imdbRating = d;
            this.$isKitsu = z;
            this.$actors = list3;
            this.$anilistId = num;
            this.$malId = num2;
            this.$id = objectRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$episodes, this.$posterUrl, this.$background, this.$year, this.$releaseInfo, this.$description, this.$genre, this.$logo, this.$imdbRating, this.$isKitsu, this.$actors, this.$anilistId, this.$malId, this.$id, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[PHI: r1
          0x003d: PHI (r1v26 java.lang.Integer) = (r1v7 java.lang.Integer), (r1v28 java.lang.Integer) binds: [B:20:0x004f, B:11:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                com.lagradost.cloudstream3.AnimeLoadResponse r0 = (com.lagradost.cloudstream3.AnimeLoadResponse) r0
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                switch(r1) {
                    case 0: goto L14;
                    default: goto Lc;
                }
            Lc:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L14:
                kotlin.ResultKt.throwOnFailure(r6)
                com.lagradost.cloudstream3.DubStatus r1 = com.lagradost.cloudstream3.DubStatus.Subbed
                java.util.List<com.lagradost.cloudstream3.Episode> r2 = r5.$episodes
                com.lagradost.cloudstream3.MainAPIKt.addEpisodes(r0, r1, r2)
                java.lang.String r1 = r5.$posterUrl
                r0.setPosterUrl(r1)
                java.lang.String r1 = r5.$background
                r0.setBackgroundPosterUrl(r1)
                java.lang.String r1 = r5.$year
                java.lang.String r2 = "–"
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L3f
                java.lang.String r1 = kotlin.text.StringsKt.substringBefore$default(r1, r2, r4, r3, r4)
                if (r1 == 0) goto L3f
                java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
                if (r1 != 0) goto L3d
                goto L3f
            L3d:
                r4 = r1
                goto L61
            L3f:
                java.lang.String r1 = r5.$releaseInfo
                if (r1 == 0) goto L4e
                java.lang.String r1 = kotlin.text.StringsKt.substringBefore$default(r1, r2, r4, r3, r4)
                if (r1 == 0) goto L4e
                java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
                goto L4f
            L4e:
                r1 = r4
            L4f:
                if (r1 != 0) goto L3d
                java.lang.String r1 = r5.$year
                if (r1 == 0) goto L61
                java.lang.String r2 = "-"
                java.lang.String r1 = kotlin.text.StringsKt.substringBefore$default(r1, r2, r4, r3, r4)
                if (r1 == 0) goto L61
                java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r1)
            L61:
                r0.setYear(r4)
                java.lang.String r1 = r5.$description
                r0.setPlot(r1)
                java.util.List<java.lang.String> r1 = r5.$genre
                r0.setTags(r1)
                java.lang.String r1 = r5.$logo
                r0.setLogoUrl(r1)
                com.lagradost.cloudstream3.Score$Companion r1 = com.lagradost.cloudstream3.Score.Companion
                java.lang.Double r2 = r5.$imdbRating
                com.lagradost.cloudstream3.Score r1 = r1.from10(r2)
                r0.setScore(r1)
                boolean r1 = r5.$isKitsu
                if (r1 == 0) goto L85
                java.lang.String r1 = "Kitsu"
                goto L87
            L85:
                java.lang.String r1 = "IMDB"
            L87:
                r0.setContentRating(r1)
                java.util.List<com.lagradost.cloudstream3.ActorData> r1 = r5.$actors
                r0.setActors(r1)
                com.lagradost.cloudstream3.LoadResponse$Companion r1 = com.lagradost.cloudstream3.LoadResponse.Companion
                r2 = r0
                com.lagradost.cloudstream3.LoadResponse r2 = (com.lagradost.cloudstream3.LoadResponse) r2
                java.lang.Integer r3 = r5.$anilistId
                r1.addAniListId(r2, r3)
                com.lagradost.cloudstream3.LoadResponse$Companion r1 = com.lagradost.cloudstream3.LoadResponse.Companion
                r2 = r0
                com.lagradost.cloudstream3.LoadResponse r2 = (com.lagradost.cloudstream3.LoadResponse) r2
                java.lang.Integer r3 = r5.$malId
                r1.addMalId(r2, r3)
                com.lagradost.cloudstream3.LoadResponse$Companion r1 = com.lagradost.cloudstream3.LoadResponse.Companion
                r2 = r0
                com.lagradost.cloudstream3.LoadResponse r2 = (com.lagradost.cloudstream3.LoadResponse) r2
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r3 = r5.$id
                java.lang.Object r3 = r3.element
                java.lang.String r3 = (java.lang.String) r3
                r1.addImdbId(r2, r3)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.megix.CineStreamProvider r19, java.lang.String r20, boolean r21, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super java.lang.Boolean> r24) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.loadLinks$suspendImpl(com.megix.CineStreamProvider, java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$loadLinks$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider$loadLinks$2", f = "CineStreamProvider.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, nl = {349}, s = {}, v = 2)
    static final class C01252 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadLinksData $res;
        final /* synthetic */ Integer $seasonYear;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01252(LoadLinksData loadLinksData, Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C01252> continuation) {
            super(1, continuation);
            this.$res = loadLinksData;
            this.$year = num;
            this.$seasonYear = num2;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C01252(this.$res, this.$year, this.$seasonYear, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (CineStreamExtractors.INSTANCE.invokeAllSources(new AllLoadLinksData(this.$res.getTitle(), this.$res.getId(), this.$res.getTmdbId(), this.$res.getAnilistId(), this.$res.getMalId(), this.$res.getKitsuId(), this.$year, this.$seasonYear, this.$res.getSeason(), this.$res.getEpisode(), this.$res.isAnime(), this.$res.isBollywood(), this.$res.isAsian(), this.$res.isCartoon(), null, null, null, null, null), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.megix.CineStreamProvider$loadLinks$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.megix.CineStreamProvider$loadLinks$3", f = "CineStreamProvider.kt", i = {1, 1}, l = {352, 353}, m = "invokeSuspend", n = {"aniId", "malId"}, nl = {353, 355}, s = {"L$0", "L$1"}, v = 2)
    static final class C01263 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadLinksData $res;
        final /* synthetic */ Integer $seasonYear;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ Integer $year;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01263(LoadLinksData loadLinksData, Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C01263> continuation) {
            super(1, continuation);
            this.$res = loadLinksData;
            this.$year = num;
            this.$seasonYear = num2;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C01263(this.$res, this.$year, this.$seasonYear, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x008e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                switch(r1) {
                    case 0: goto L23;
                    case 1: goto L1e;
                    case 2: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L11:
                java.lang.Object r0 = r11.L$1
                java.lang.Integer r0 = (java.lang.Integer) r0
                java.lang.Object r1 = r11.L$0
                java.lang.Integer r1 = (java.lang.Integer) r1
                kotlin.ResultKt.throwOnFailure(r12)
                goto L91
            L1e:
                kotlin.ResultKt.throwOnFailure(r12)
                r1 = r12
                goto L5c
            L23:
                kotlin.ResultKt.throwOnFailure(r12)
                com.megix.CineStreamProvider$LoadLinksData r1 = r11.$res
                boolean r1 = r1.isAnime()
                if (r1 == 0) goto L92
                com.megix.CineStreamProvider$LoadLinksData r1 = r11.$res
                java.lang.String r1 = r1.getTitle()
                java.lang.Integer r2 = r11.$year
                com.megix.CineStreamProvider$LoadLinksData r3 = r11.$res
                java.lang.String r3 = r3.getFirstAired()
                com.megix.CineStreamProvider$LoadLinksData r4 = r11.$res
                java.lang.String r4 = r4.getTvtype()
                java.lang.String r5 = "movie"
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                if (r4 == 0) goto L4d
                com.lagradost.cloudstream3.TvType r4 = com.lagradost.cloudstream3.TvType.AnimeMovie
                goto L4f
            L4d:
                com.lagradost.cloudstream3.TvType r4 = com.lagradost.cloudstream3.TvType.Anime
            L4f:
                r5 = r11
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6 = 1
                r11.label = r6
                java.lang.Object r1 = com.megix.CineStreamUtilsKt.convertImdbToAnimeId(r1, r2, r3, r4, r5)
                if (r1 != r0) goto L5c
                return r0
            L5c:
                com.megix.AniIds r1 = (com.megix.AniIds) r1
                java.lang.Integer r4 = r1.getId()
                java.lang.Integer r3 = r1.getIdMal()
                com.megix.CineStreamExtractors r2 = com.megix.CineStreamExtractors.INSTANCE
                com.megix.CineStreamProvider$LoadLinksData r1 = r11.$res
                java.lang.Integer r5 = r1.getEpisode()
                java.lang.Integer r6 = r11.$seasonYear
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r8 = r11.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r9 = r11.$callback
                r10 = r11
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r11.L$0 = r1
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                r11.L$1 = r1
                r1 = 2
                r11.label = r1
                java.lang.String r7 = "imdb"
                java.lang.Object r1 = r2.invokeAnimes(r3, r4, r5, r6, r7, r8, r9, r10)
                if (r1 != r0) goto L8f
                return r0
            L8f:
                r0 = r3
                r1 = r4
            L91:
            L92:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.C01263.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b8\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010;\u001a\u00020\rHÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jâ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\u0014\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010C\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010D\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010%R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010%R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010%R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010%R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001eR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b¨\u0006E"}, d2 = {"Lcom/megix/CineStreamProvider$LoadLinksData;", "", "title", "", "id", "tmdbId", "", "tvtype", "year", "season", "episode", "firstAired", "isAnime", "", "isBollywood", "isAsian", "isCartoon", "imdb_id", "imdbSeason", "imdbEpisode", "isKitsu", "anilistId", "malId", "kitsuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "getTmdbId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTvtype", "getYear", "getSeason", "getEpisode", "getFirstAired", "()Z", "getImdb_id", "getImdbSeason", "getImdbEpisode", "getAnilistId", "getMalId", "getKitsuId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/megix/CineStreamProvider$LoadLinksData;", "equals", "other", "hashCode", "toString", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadLinksData {

        @Nullable
        private final Integer anilistId;

        @Nullable
        private final Integer episode;

        @Nullable
        private final String firstAired;

        @NotNull
        private final String id;

        @Nullable
        private final Integer imdbEpisode;

        @Nullable
        private final Integer imdbSeason;

        @Nullable
        private final String imdb_id;
        private final boolean isAnime;
        private final boolean isAsian;
        private final boolean isBollywood;
        private final boolean isCartoon;
        private final boolean isKitsu;

        @Nullable
        private final String kitsuId;

        @Nullable
        private final Integer malId;

        @Nullable
        private final Integer season;

        @NotNull
        private final String title;

        @Nullable
        private final Integer tmdbId;

        @NotNull
        private final String tvtype;

        @Nullable
        private final String year;

        public static /* synthetic */ LoadLinksData copy$default(LoadLinksData loadLinksData, String str, String str2, Integer num, String str3, String str4, Integer num2, Integer num3, String str5, boolean z, boolean z2, boolean z3, boolean z4, String str6, Integer num4, Integer num5, boolean z5, Integer num6, Integer num7, String str7, int i, Object obj) {
            String str8;
            Integer num8;
            String str9 = (i & 1) != 0 ? loadLinksData.title : str;
            String str10 = (i & 2) != 0 ? loadLinksData.id : str2;
            Integer num9 = (i & 4) != 0 ? loadLinksData.tmdbId : num;
            String str11 = (i & 8) != 0 ? loadLinksData.tvtype : str3;
            String str12 = (i & 16) != 0 ? loadLinksData.year : str4;
            Integer num10 = (i & 32) != 0 ? loadLinksData.season : num2;
            Integer num11 = (i & 64) != 0 ? loadLinksData.episode : num3;
            String str13 = (i & 128) != 0 ? loadLinksData.firstAired : str5;
            boolean z6 = (i & 256) != 0 ? loadLinksData.isAnime : z;
            boolean z7 = (i & 512) != 0 ? loadLinksData.isBollywood : z2;
            boolean z8 = (i & 1024) != 0 ? loadLinksData.isAsian : z3;
            boolean z9 = (i & 2048) != 0 ? loadLinksData.isCartoon : z4;
            String str14 = (i & 4096) != 0 ? loadLinksData.imdb_id : str6;
            Integer num12 = (i & 8192) != 0 ? loadLinksData.imdbSeason : num4;
            String str15 = str9;
            Integer num13 = (i & 16384) != 0 ? loadLinksData.imdbEpisode : num5;
            boolean z10 = (i & 32768) != 0 ? loadLinksData.isKitsu : z5;
            Integer num14 = (i & 65536) != 0 ? loadLinksData.anilistId : num6;
            Integer num15 = (i & 131072) != 0 ? loadLinksData.malId : num7;
            if ((i & 262144) != 0) {
                num8 = num15;
                str8 = loadLinksData.kitsuId;
            } else {
                str8 = str7;
                num8 = num15;
            }
            return loadLinksData.copy(str15, str10, num9, str11, str12, num10, num11, str13, z6, z7, z8, z9, str14, num12, num13, z10, num14, num8, str8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsBollywood() {
            return this.isBollywood;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getIsAsian() {
            return this.isAsian;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getIsCartoon() {
            return this.isCartoon;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Integer getImdbSeason() {
            return this.imdbSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getImdbEpisode() {
            return this.imdbEpisode;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final boolean getIsKitsu() {
            return this.isKitsu;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getKitsuId() {
            return this.kitsuId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTvtype() {
            return this.tvtype;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getFirstAired() {
            return this.firstAired;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsAnime() {
            return this.isAnime;
        }

        @NotNull
        public final LoadLinksData copy(@NotNull String title, @NotNull String id, @Nullable Integer tmdbId, @NotNull String tvtype, @Nullable String year, @Nullable Integer season, @Nullable Integer episode, @Nullable String firstAired, boolean isAnime, boolean isBollywood, boolean isAsian, boolean isCartoon, @Nullable String imdb_id, @Nullable Integer imdbSeason, @Nullable Integer imdbEpisode, boolean isKitsu, @Nullable Integer anilistId, @Nullable Integer malId, @Nullable String kitsuId) {
            return new LoadLinksData(title, id, tmdbId, tvtype, year, season, episode, firstAired, isAnime, isBollywood, isAsian, isCartoon, imdb_id, imdbSeason, imdbEpisode, isKitsu, anilistId, malId, kitsuId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadLinksData)) {
                return false;
            }
            LoadLinksData loadLinksData = (LoadLinksData) other;
            return Intrinsics.areEqual(this.title, loadLinksData.title) && Intrinsics.areEqual(this.id, loadLinksData.id) && Intrinsics.areEqual(this.tmdbId, loadLinksData.tmdbId) && Intrinsics.areEqual(this.tvtype, loadLinksData.tvtype) && Intrinsics.areEqual(this.year, loadLinksData.year) && Intrinsics.areEqual(this.season, loadLinksData.season) && Intrinsics.areEqual(this.episode, loadLinksData.episode) && Intrinsics.areEqual(this.firstAired, loadLinksData.firstAired) && this.isAnime == loadLinksData.isAnime && this.isBollywood == loadLinksData.isBollywood && this.isAsian == loadLinksData.isAsian && this.isCartoon == loadLinksData.isCartoon && Intrinsics.areEqual(this.imdb_id, loadLinksData.imdb_id) && Intrinsics.areEqual(this.imdbSeason, loadLinksData.imdbSeason) && Intrinsics.areEqual(this.imdbEpisode, loadLinksData.imdbEpisode) && this.isKitsu == loadLinksData.isKitsu && Intrinsics.areEqual(this.anilistId, loadLinksData.anilistId) && Intrinsics.areEqual(this.malId, loadLinksData.malId) && Intrinsics.areEqual(this.kitsuId, loadLinksData.kitsuId);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((this.title.hashCode() * 31) + this.id.hashCode()) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + this.tvtype.hashCode()) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.firstAired == null ? 0 : this.firstAired.hashCode())) * 31) + CineStreamProvider$LoadLinksData$$ExternalSyntheticBackport0.m(this.isAnime)) * 31) + CineStreamProvider$LoadLinksData$$ExternalSyntheticBackport0.m(this.isBollywood)) * 31) + CineStreamProvider$LoadLinksData$$ExternalSyntheticBackport0.m(this.isAsian)) * 31) + CineStreamProvider$LoadLinksData$$ExternalSyntheticBackport0.m(this.isCartoon)) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.imdbSeason == null ? 0 : this.imdbSeason.hashCode())) * 31) + (this.imdbEpisode == null ? 0 : this.imdbEpisode.hashCode())) * 31) + CineStreamProvider$LoadLinksData$$ExternalSyntheticBackport0.m(this.isKitsu)) * 31) + (this.anilistId == null ? 0 : this.anilistId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.kitsuId != null ? this.kitsuId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LoadLinksData(title=").append(this.title).append(", id=").append(this.id).append(", tmdbId=").append(this.tmdbId).append(", tvtype=").append(this.tvtype).append(", year=").append(this.year).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", firstAired=").append(this.firstAired).append(", isAnime=").append(this.isAnime).append(", isBollywood=").append(this.isBollywood).append(", isAsian=").append(this.isAsian).append(", isCartoon=");
            sb.append(this.isCartoon).append(", imdb_id=").append(this.imdb_id).append(", imdbSeason=").append(this.imdbSeason).append(", imdbEpisode=").append(this.imdbEpisode).append(", isKitsu=").append(this.isKitsu).append(", anilistId=").append(this.anilistId).append(", malId=").append(this.malId).append(", kitsuId=").append(this.kitsuId).append(')');
            return sb.toString();
        }

        public LoadLinksData(@NotNull String title, @NotNull String id, @Nullable Integer tmdbId, @NotNull String tvtype, @Nullable String year, @Nullable Integer season, @Nullable Integer episode, @Nullable String firstAired, boolean isAnime, boolean isBollywood, boolean isAsian, boolean isCartoon, @Nullable String imdb_id, @Nullable Integer imdbSeason, @Nullable Integer imdbEpisode, boolean isKitsu, @Nullable Integer anilistId, @Nullable Integer malId, @Nullable String kitsuId) {
            this.title = title;
            this.id = id;
            this.tmdbId = tmdbId;
            this.tvtype = tvtype;
            this.year = year;
            this.season = season;
            this.episode = episode;
            this.firstAired = firstAired;
            this.isAnime = isAnime;
            this.isBollywood = isBollywood;
            this.isAsian = isAsian;
            this.isCartoon = isCartoon;
            this.imdb_id = imdb_id;
            this.imdbSeason = imdbSeason;
            this.imdbEpisode = imdbEpisode;
            this.isKitsu = isKitsu;
            this.anilistId = anilistId;
            this.malId = malId;
            this.kitsuId = kitsuId;
        }

        public /* synthetic */ LoadLinksData(String str, String str2, Integer num, String str3, String str4, Integer num2, Integer num3, String str5, boolean z, boolean z2, boolean z3, boolean z4, String str6, Integer num4, Integer num5, boolean z5, Integer num6, Integer num7, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, num, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? false : z, (i & 512) != 0 ? false : z2, (i & 1024) != 0 ? false : z3, (i & 2048) != 0 ? false : z4, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? null : num4, (i & 16384) != 0 ? null : num5, (32768 & i) != 0 ? false : z5, (65536 & i) != 0 ? null : num6, (131072 & i) != 0 ? null : num7, (i & 262144) != 0 ? null : str7);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @NotNull
        public final String getTvtype() {
            return this.tvtype;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getFirstAired() {
            return this.firstAired;
        }

        public final boolean isAnime() {
            return this.isAnime;
        }

        public final boolean isBollywood() {
            return this.isBollywood;
        }

        public final boolean isAsian() {
            return this.isAsian;
        }

        public final boolean isCartoon() {
            return this.isCartoon;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final Integer getImdbSeason() {
            return this.imdbSeason;
        }

        @Nullable
        public final Integer getImdbEpisode() {
            return this.imdbEpisode;
        }

        public final boolean isKitsu() {
            return this.isKitsu;
        }

        @Nullable
        public final Integer getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        public final String getKitsuId() {
            return this.kitsuId;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/megix/CineStreamProvider$PassData;", "", "id", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PassData {

        @NotNull
        private final String id;

        @NotNull
        private final String type;

        public static /* synthetic */ PassData copy$default(PassData passData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passData.id;
            }
            if ((i & 2) != 0) {
                str2 = passData.type;
            }
            return passData.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final PassData copy(@NotNull String id, @NotNull String type) {
            return new PassData(id, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PassData)) {
                return false;
            }
            PassData passData = (PassData) other;
            return Intrinsics.areEqual(this.id, passData.id) && Intrinsics.areEqual(this.type, passData.type);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "PassData(id=" + this.id + ", type=" + this.type + ')';
        }

        public PassData(@NotNull String id, @NotNull String type) {
            this.id = id;
            this.type = type;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0012¢\u0006\u0004\b \u0010!J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010C\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\tHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0012HÆ\u0003JÌ\u0002\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010WJ\u0014\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010[\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\\\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b>\u00102¨\u0006]"}, d2 = {"Lcom/megix/CineStreamProvider$Meta;", "", "id", "", "imdb_id", "awards", "type", "aliases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "poster", "logo", "background", "moviedb_id", "", "name", "description", "genre", "", "genres", "releaseInfo", "status", "runtime", "cast", "app_extras", "Lcom/megix/CineStreamProvider$AppExtras;", "language", "country", "imdbRating", "year", "videos", "Lcom/megix/CineStreamProvider$EpisodeDetails;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/megix/CineStreamProvider$AppExtras;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getImdb_id", "getAwards", "getType", "getAliases", "()Ljava/util/ArrayList;", "getPoster", "getLogo", "getBackground", "getMoviedb_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getDescription", "getGenre", "()Ljava/util/List;", "getGenres", "getReleaseInfo", "getStatus", "getRuntime", "getCast", "getApp_extras", "()Lcom/megix/CineStreamProvider$AppExtras;", "getLanguage", "getCountry", "getImdbRating", "getYear", "getVideos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/megix/CineStreamProvider$AppExtras;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/megix/CineStreamProvider$Meta;", "equals", "", "other", "hashCode", "toString", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Meta {

        @Nullable
        private final ArrayList<String> aliases;

        @Nullable
        private final AppExtras app_extras;

        @Nullable
        private final String awards;

        @Nullable
        private final String background;

        @Nullable
        private final List<String> cast;

        @Nullable
        private final String country;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> genre;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final String id;

        @Nullable
        private final String imdbRating;

        @Nullable
        private final String imdb_id;

        @Nullable
        private final String language;

        @Nullable
        private final String logo;

        @Nullable
        private final Integer moviedb_id;

        @Nullable
        private final String name;

        @Nullable
        private final String poster;

        @Nullable
        private final String releaseInfo;

        @Nullable
        private final String runtime;

        @Nullable
        private final String status;

        @Nullable
        private final String type;

        @Nullable
        private final List<EpisodeDetails> videos;

        @Nullable
        private final String year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, String str3, String str4, ArrayList arrayList, String str5, String str6, String str7, Integer num, String str8, String str9, List list, List list2, String str10, String str11, String str12, List list3, AppExtras appExtras, String str13, String str14, String str15, String str16, List list4, int i, Object obj) {
            List list5;
            String str17;
            String str18 = (i & 1) != 0 ? meta.id : str;
            String str19 = (i & 2) != 0 ? meta.imdb_id : str2;
            String str20 = (i & 4) != 0 ? meta.awards : str3;
            String str21 = (i & 8) != 0 ? meta.type : str4;
            ArrayList arrayList2 = (i & 16) != 0 ? meta.aliases : arrayList;
            String str22 = (i & 32) != 0 ? meta.poster : str5;
            String str23 = (i & 64) != 0 ? meta.logo : str6;
            String str24 = (i & 128) != 0 ? meta.background : str7;
            Integer num2 = (i & 256) != 0 ? meta.moviedb_id : num;
            String str25 = (i & 512) != 0 ? meta.name : str8;
            String str26 = (i & 1024) != 0 ? meta.description : str9;
            List list6 = (i & 2048) != 0 ? meta.genre : list;
            List list7 = (i & 4096) != 0 ? meta.genres : list2;
            String str27 = (i & 8192) != 0 ? meta.releaseInfo : str10;
            String str28 = str18;
            String str29 = (i & 16384) != 0 ? meta.status : str11;
            String str30 = (i & 32768) != 0 ? meta.runtime : str12;
            List list8 = (i & 65536) != 0 ? meta.cast : list3;
            AppExtras appExtras2 = (i & 131072) != 0 ? meta.app_extras : appExtras;
            String str31 = (i & 262144) != 0 ? meta.language : str13;
            String str32 = (i & 524288) != 0 ? meta.country : str14;
            String str33 = (i & 1048576) != 0 ? meta.imdbRating : str15;
            String str34 = (i & 2097152) != 0 ? meta.year : str16;
            if ((i & 4194304) != 0) {
                str17 = str34;
                list5 = meta.videos;
            } else {
                list5 = list4;
                str17 = str34;
            }
            return meta.copy(str28, str19, str20, str21, arrayList2, str22, str23, str24, num2, str25, str26, list6, list7, str27, str29, str30, list8, appExtras2, str31, str32, str33, str17, list5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> component12() {
            return this.genre;
        }

        @Nullable
        public final List<String> component13() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final List<String> component17() {
            return this.cast;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final AppExtras getApp_extras() {
            return this.app_extras;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final List<EpisodeDetails> component23() {
            return this.videos;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAwards() {
            return this.awards;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final ArrayList<String> component5() {
            return this.aliases;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getMoviedb_id() {
            return this.moviedb_id;
        }

        @NotNull
        public final Meta copy(@Nullable String id, @Nullable String imdb_id, @Nullable String awards, @Nullable String type, @Nullable ArrayList<String> aliases, @Nullable String poster, @Nullable String logo, @Nullable String background, @Nullable Integer moviedb_id, @Nullable String name, @Nullable String description, @Nullable List<String> genre, @Nullable List<String> genres, @Nullable String releaseInfo, @Nullable String status, @Nullable String runtime, @Nullable List<String> cast, @Nullable AppExtras app_extras, @Nullable String language, @Nullable String country, @Nullable String imdbRating, @Nullable String year, @Nullable List<EpisodeDetails> videos) {
            return new Meta(id, imdb_id, awards, type, aliases, poster, logo, background, moviedb_id, name, description, genre, genres, releaseInfo, status, runtime, cast, app_extras, language, country, imdbRating, year, videos);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Meta)) {
                return false;
            }
            Meta meta = (Meta) other;
            return Intrinsics.areEqual(this.id, meta.id) && Intrinsics.areEqual(this.imdb_id, meta.imdb_id) && Intrinsics.areEqual(this.awards, meta.awards) && Intrinsics.areEqual(this.type, meta.type) && Intrinsics.areEqual(this.aliases, meta.aliases) && Intrinsics.areEqual(this.poster, meta.poster) && Intrinsics.areEqual(this.logo, meta.logo) && Intrinsics.areEqual(this.background, meta.background) && Intrinsics.areEqual(this.moviedb_id, meta.moviedb_id) && Intrinsics.areEqual(this.name, meta.name) && Intrinsics.areEqual(this.description, meta.description) && Intrinsics.areEqual(this.genre, meta.genre) && Intrinsics.areEqual(this.genres, meta.genres) && Intrinsics.areEqual(this.releaseInfo, meta.releaseInfo) && Intrinsics.areEqual(this.status, meta.status) && Intrinsics.areEqual(this.runtime, meta.runtime) && Intrinsics.areEqual(this.cast, meta.cast) && Intrinsics.areEqual(this.app_extras, meta.app_extras) && Intrinsics.areEqual(this.language, meta.language) && Intrinsics.areEqual(this.country, meta.country) && Intrinsics.areEqual(this.imdbRating, meta.imdbRating) && Intrinsics.areEqual(this.year, meta.year) && Intrinsics.areEqual(this.videos, meta.videos);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.awards == null ? 0 : this.awards.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.aliases == null ? 0 : this.aliases.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.moviedb_id == null ? 0 : this.moviedb_id.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.releaseInfo == null ? 0 : this.releaseInfo.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.cast == null ? 0 : this.cast.hashCode())) * 31) + (this.app_extras == null ? 0 : this.app_extras.hashCode())) * 31) + (this.language == null ? 0 : this.language.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.videos != null ? this.videos.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Meta(id=").append(this.id).append(", imdb_id=").append(this.imdb_id).append(", awards=").append(this.awards).append(", type=").append(this.type).append(", aliases=").append(this.aliases).append(", poster=").append(this.poster).append(", logo=").append(this.logo).append(", background=").append(this.background).append(", moviedb_id=").append(this.moviedb_id).append(", name=").append(this.name).append(", description=").append(this.description).append(", genre=");
            sb.append(this.genre).append(", genres=").append(this.genres).append(", releaseInfo=").append(this.releaseInfo).append(", status=").append(this.status).append(", runtime=").append(this.runtime).append(", cast=").append(this.cast).append(", app_extras=").append(this.app_extras).append(", language=").append(this.language).append(", country=").append(this.country).append(", imdbRating=").append(this.imdbRating).append(", year=").append(this.year).append(", videos=").append(this.videos);
            sb.append(')');
            return sb.toString();
        }

        public Meta(@Nullable String id, @Nullable String imdb_id, @Nullable String awards, @Nullable String type, @Nullable ArrayList<String> arrayList, @Nullable String poster, @Nullable String logo, @Nullable String background, @Nullable Integer moviedb_id, @Nullable String name, @Nullable String description, @Nullable List<String> list, @Nullable List<String> list2, @Nullable String releaseInfo, @Nullable String status, @Nullable String runtime, @Nullable List<String> list3, @Nullable AppExtras app_extras, @Nullable String language, @Nullable String country, @Nullable String imdbRating, @Nullable String year, @Nullable List<EpisodeDetails> list4) {
            this.id = id;
            this.imdb_id = imdb_id;
            this.awards = awards;
            this.type = type;
            this.aliases = arrayList;
            this.poster = poster;
            this.logo = logo;
            this.background = background;
            this.moviedb_id = moviedb_id;
            this.name = name;
            this.description = description;
            this.genre = list;
            this.genres = list2;
            this.releaseInfo = releaseInfo;
            this.status = status;
            this.runtime = runtime;
            this.cast = list3;
            this.app_extras = app_extras;
            this.language = language;
            this.country = country;
            this.imdbRating = imdbRating;
            this.year = year;
            this.videos = list4;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Meta(String str, String str2, String str3, String str4, ArrayList arrayList, String str5, String str6, String str7, Integer num, String str8, String str9, List list, List list2, String str10, String str11, String str12, List list3, AppExtras appExtras, String str13, String str14, String str15, String str16, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            AppExtras appExtras2;
            if ((i & 131072) == 0) {
                appExtras2 = appExtras;
            } else {
                appExtras2 = null;
            }
            this(str, str2, str3, str4, arrayList, str5, str6, str7, num, str8, str9, list, list2, str10, str11, str12, list3, appExtras2, str13, str14, str15, str16, list4);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final String getAwards() {
            return this.awards;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final ArrayList<String> getAliases() {
            return this.aliases;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final Integer getMoviedb_id() {
            return this.moviedb_id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> getGenre() {
            return this.genre;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final String getReleaseInfo() {
            return this.releaseInfo;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final List<String> getCast() {
            return this.cast;
        }

        @Nullable
        public final AppExtras getApp_extras() {
            return this.app_extras;
        }

        @Nullable
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        public final String getCountry() {
            return this.country;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final List<EpisodeDetails> getVideos() {
            return this.videos;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/megix/CineStreamProvider$AppExtras;", "", "cast", "", "Lcom/megix/CineStreamProvider$Cast;", "<init>", "(Ljava/util/List;)V", "getCast", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AppExtras {

        @NotNull
        private final List<Cast> cast;

        /* JADX WARN: Illegal instructions before constructor call */
        public AppExtras() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppExtras copy$default(AppExtras appExtras, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = appExtras.cast;
            }
            return appExtras.copy(list);
        }

        @NotNull
        public final List<Cast> component1() {
            return this.cast;
        }

        @NotNull
        public final AppExtras copy(@NotNull List<Cast> cast) {
            return new AppExtras(cast);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AppExtras) && Intrinsics.areEqual(this.cast, ((AppExtras) other).cast);
        }

        public int hashCode() {
            return this.cast.hashCode();
        }

        @NotNull
        public String toString() {
            return "AppExtras(cast=" + this.cast + ')';
        }

        public AppExtras(@NotNull List<Cast> list) {
            this.cast = list;
        }

        public /* synthetic */ AppExtras(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final List<Cast> getCast() {
            return this.cast;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/megix/CineStreamProvider$Cast;", "", "name", "", "character", "photo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCharacter", "getPhoto", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Cast {

        @Nullable
        private final String character;

        @Nullable
        private final String name;

        @Nullable
        private final String photo;

        public Cast() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Cast copy$default(Cast cast, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cast.name;
            }
            if ((i & 2) != 0) {
                str2 = cast.character;
            }
            if ((i & 4) != 0) {
                str3 = cast.photo;
            }
            return cast.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPhoto() {
            return this.photo;
        }

        @NotNull
        public final Cast copy(@Nullable String name, @Nullable String character, @Nullable String photo) {
            return new Cast(name, character, photo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cast)) {
                return false;
            }
            Cast cast = (Cast) other;
            return Intrinsics.areEqual(this.name, cast.name) && Intrinsics.areEqual(this.character, cast.character) && Intrinsics.areEqual(this.photo, cast.photo);
        }

        public int hashCode() {
            return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.photo != null ? this.photo.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Cast(name=" + this.name + ", character=" + this.character + ", photo=" + this.photo + ')';
        }

        public Cast(@Nullable String name, @Nullable String character, @Nullable String photo) {
            this.name = name;
            this.character = character;
            this.photo = photo;
        }

        public /* synthetic */ Cast(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        public final String getPhoto() {
            return this.photo;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/megix/CineStreamProvider$SearchResult;", "", "metas", "", "Lcom/megix/CineStreamProvider$Media;", "<init>", "(Ljava/util/List;)V", "getMetas", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SearchResult {

        @NotNull
        private final List<Media> metas;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchResult.metas;
            }
            return searchResult.copy(list);
        }

        @NotNull
        public final List<Media> component1() {
            return this.metas;
        }

        @NotNull
        public final SearchResult copy(@NotNull List<Media> metas) {
            return new SearchResult(metas);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SearchResult) && Intrinsics.areEqual(this.metas, ((SearchResult) other).metas);
        }

        public int hashCode() {
            return this.metas.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchResult(metas=" + this.metas + ')';
        }

        public SearchResult(@NotNull List<Media> list) {
            this.metas = list;
        }

        @NotNull
        public final List<Media> getMetas() {
            return this.metas;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bHÆ\u0003Jk\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/megix/CineStreamProvider$Media;", "", "id", "", "type", "name", "poster", "description", "imdbRating", "aliases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getPoster", "getDescription", "getImdbRating", "getAliases", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final ArrayList<String> aliases;

        @Nullable
        private final String description;

        @NotNull
        private final String id;

        @Nullable
        private final String imdbRating;

        @Nullable
        private final String name;

        @Nullable
        private final String poster;

        @NotNull
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Media copy$default(Media media, String str, String str2, String str3, String str4, String str5, String str6, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.id;
            }
            if ((i & 2) != 0) {
                str2 = media.type;
            }
            if ((i & 4) != 0) {
                str3 = media.name;
            }
            if ((i & 8) != 0) {
                str4 = media.poster;
            }
            if ((i & 16) != 0) {
                str5 = media.description;
            }
            if ((i & 32) != 0) {
                str6 = media.imdbRating;
            }
            if ((i & 64) != 0) {
                arrayList = media.aliases;
            }
            String str7 = str6;
            ArrayList arrayList2 = arrayList;
            String str8 = str5;
            String str9 = str3;
            return media.copy(str, str2, str9, str4, str8, str7, arrayList2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final ArrayList<String> component7() {
            return this.aliases;
        }

        @NotNull
        public final Media copy(@NotNull String id, @NotNull String type, @Nullable String name, @Nullable String poster, @Nullable String description, @Nullable String imdbRating, @Nullable ArrayList<String> aliases) {
            return new Media(id, type, name, poster, description, imdbRating, aliases);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.type, media.type) && Intrinsics.areEqual(this.name, media.name) && Intrinsics.areEqual(this.poster, media.poster) && Intrinsics.areEqual(this.description, media.description) && Intrinsics.areEqual(this.imdbRating, media.imdbRating) && Intrinsics.areEqual(this.aliases, media.aliases);
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.aliases != null ? this.aliases.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", poster=" + this.poster + ", description=" + this.description + ", imdbRating=" + this.imdbRating + ", aliases=" + this.aliases + ')';
        }

        public Media(@NotNull String id, @NotNull String type, @Nullable String name, @Nullable String poster, @Nullable String description, @Nullable String imdbRating, @Nullable ArrayList<String> arrayList) {
            this.id = id;
            this.type = type;
            this.name = name;
            this.poster = poster;
            this.description = description;
            this.imdbRating = imdbRating;
            this.aliases = arrayList;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final ArrayList<String> getAliases() {
            return this.aliases;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J²\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00105J\u0014\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010:\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!¨\u0006;"}, d2 = {"Lcom/megix/CineStreamProvider$EpisodeDetails;", "", "id", "", "name", "title", "season", "", "episode", "rating", "released", "firstAired", "overview", "thumbnail", "moviedb_id", "imdb_id", "imdbSeason", "imdbEpisode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getName", "getTitle", "getSeason", "()I", "getEpisode", "getRating", "getReleased", "getFirstAired", "getOverview", "getThumbnail", "getMoviedb_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdb_id", "getImdbSeason", "getImdbEpisode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/megix/CineStreamProvider$EpisodeDetails;", "equals", "", "other", "hashCode", "toString", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EpisodeDetails {
        private final int episode;

        @Nullable
        private final String firstAired;

        @Nullable
        private final String id;

        @Nullable
        private final Integer imdbEpisode;

        @Nullable
        private final Integer imdbSeason;

        @Nullable
        private final String imdb_id;

        @Nullable
        private final Integer moviedb_id;

        @Nullable
        private final String name;

        @Nullable
        private final String overview;

        @Nullable
        private final String rating;

        @Nullable
        private final String released;
        private final int season;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getMoviedb_id() {
            return this.moviedb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Integer getImdbSeason() {
            return this.imdbSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Integer getImdbEpisode() {
            return this.imdbEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getSeason() {
            return this.season;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getFirstAired() {
            return this.firstAired;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @NotNull
        public final EpisodeDetails copy(@Nullable String id, @Nullable String name, @Nullable String title, int season, int episode, @Nullable String rating, @Nullable String released, @Nullable String firstAired, @Nullable String overview, @Nullable String thumbnail, @Nullable Integer moviedb_id, @Nullable String imdb_id, @Nullable Integer imdbSeason, @Nullable Integer imdbEpisode) {
            return new EpisodeDetails(id, name, title, season, episode, rating, released, firstAired, overview, thumbnail, moviedb_id, imdb_id, imdbSeason, imdbEpisode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeDetails)) {
                return false;
            }
            EpisodeDetails episodeDetails = (EpisodeDetails) other;
            return Intrinsics.areEqual(this.id, episodeDetails.id) && Intrinsics.areEqual(this.name, episodeDetails.name) && Intrinsics.areEqual(this.title, episodeDetails.title) && this.season == episodeDetails.season && this.episode == episodeDetails.episode && Intrinsics.areEqual(this.rating, episodeDetails.rating) && Intrinsics.areEqual(this.released, episodeDetails.released) && Intrinsics.areEqual(this.firstAired, episodeDetails.firstAired) && Intrinsics.areEqual(this.overview, episodeDetails.overview) && Intrinsics.areEqual(this.thumbnail, episodeDetails.thumbnail) && Intrinsics.areEqual(this.moviedb_id, episodeDetails.moviedb_id) && Intrinsics.areEqual(this.imdb_id, episodeDetails.imdb_id) && Intrinsics.areEqual(this.imdbSeason, episodeDetails.imdbSeason) && Intrinsics.areEqual(this.imdbEpisode, episodeDetails.imdbEpisode);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + this.season) * 31) + this.episode) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.firstAired == null ? 0 : this.firstAired.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.moviedb_id == null ? 0 : this.moviedb_id.hashCode())) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.imdbSeason == null ? 0 : this.imdbSeason.hashCode())) * 31) + (this.imdbEpisode != null ? this.imdbEpisode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("EpisodeDetails(id=").append(this.id).append(", name=").append(this.name).append(", title=").append(this.title).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", rating=").append(this.rating).append(", released=").append(this.released).append(", firstAired=").append(this.firstAired).append(", overview=").append(this.overview).append(", thumbnail=").append(this.thumbnail).append(", moviedb_id=").append(this.moviedb_id).append(", imdb_id=");
            sb.append(this.imdb_id).append(", imdbSeason=").append(this.imdbSeason).append(", imdbEpisode=").append(this.imdbEpisode).append(')');
            return sb.toString();
        }

        public EpisodeDetails(@Nullable String id, @Nullable String name, @Nullable String title, int season, int episode, @Nullable String rating, @Nullable String released, @Nullable String firstAired, @Nullable String overview, @Nullable String thumbnail, @Nullable Integer moviedb_id, @Nullable String imdb_id, @Nullable Integer imdbSeason, @Nullable Integer imdbEpisode) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.season = season;
            this.episode = episode;
            this.rating = rating;
            this.released = released;
            this.firstAired = firstAired;
            this.overview = overview;
            this.thumbnail = thumbnail;
            this.moviedb_id = moviedb_id;
            this.imdb_id = imdb_id;
            this.imdbSeason = imdbSeason;
            this.imdbEpisode = imdbEpisode;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public final int getSeason() {
            return this.season;
        }

        public final int getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        public final String getFirstAired() {
            return this.firstAired;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final Integer getMoviedb_id() {
            return this.moviedb_id;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final Integer getImdbSeason() {
            return this.imdbSeason;
        }

        @Nullable
        public final Integer getImdbEpisode() {
            return this.imdbEpisode;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/megix/CineStreamProvider$ResponseData;", "", "meta", "Lcom/megix/CineStreamProvider$Meta;", "<init>", "(Lcom/megix/CineStreamProvider$Meta;)V", "getMeta", "()Lcom/megix/CineStreamProvider$Meta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ResponseData {

        @NotNull
        private final Meta meta;

        public static /* synthetic */ ResponseData copy$default(ResponseData responseData, Meta meta, int i, Object obj) {
            if ((i & 1) != 0) {
                meta = responseData.meta;
            }
            return responseData.copy(meta);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Meta getMeta() {
            return this.meta;
        }

        @NotNull
        public final ResponseData copy(@NotNull Meta meta) {
            return new ResponseData(meta);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResponseData) && Intrinsics.areEqual(this.meta, ((ResponseData) other).meta);
        }

        public int hashCode() {
            return this.meta.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResponseData(meta=" + this.meta + ')';
        }

        public ResponseData(@NotNull Meta meta) {
            this.meta = meta;
        }

        @NotNull
        public final Meta getMeta() {
            return this.meta;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/megix/CineStreamProvider$Home;", "", "metas", "", "Lcom/megix/CineStreamProvider$Media;", "hasMore", "", "<init>", "(Ljava/util/List;Z)V", "getMetas", "()Ljava/util/List;", "getHasMore", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Home {
        private final boolean hasMore;

        @NotNull
        private final List<Media> metas;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Home copy$default(Home home, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = home.metas;
            }
            if ((i & 2) != 0) {
                z = home.hasMore;
            }
            return home.copy(list, z);
        }

        @NotNull
        public final List<Media> component1() {
            return this.metas;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        @NotNull
        public final Home copy(@NotNull List<Media> metas, boolean hasMore) {
            return new Home(metas, hasMore);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Home)) {
                return false;
            }
            Home home = (Home) other;
            return Intrinsics.areEqual(this.metas, home.metas) && this.hasMore == home.hasMore;
        }

        public int hashCode() {
            return (this.metas.hashCode() * 31) + CineStreamProvider$Home$$ExternalSyntheticBackport0.m(this.hasMore);
        }

        @NotNull
        public String toString() {
            return "Home(metas=" + this.metas + ", hasMore=" + this.hasMore + ')';
        }

        public Home(@NotNull List<Media> list, boolean hasMore) {
            this.metas = list;
            this.hasMore = hasMore;
        }

        public /* synthetic */ Home(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? true : z);
        }

        @NotNull
        public final List<Media> getMetas() {
            return this.metas;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }
    }

    /* JADX INFO: compiled from: CineStreamProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/megix/CineStreamProvider$ExtenalIds;", "", "anilist", "", "anidb", "myanimelist", "kitsu", "anisearch", "livechart", "themoviedb", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAnilist", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnidb", "getMyanimelist", "getKitsu", "getAnisearch", "getLivechart", "getThemoviedb", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/megix/CineStreamProvider$ExtenalIds;", "equals", "", "other", "hashCode", "toString", "", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ExtenalIds {

        @Nullable
        private final Integer anidb;

        @Nullable
        private final Integer anilist;

        @Nullable
        private final Integer anisearch;

        @Nullable
        private final Integer kitsu;

        @Nullable
        private final Integer livechart;

        @Nullable
        private final Integer myanimelist;

        @Nullable
        private final Integer themoviedb;

        public static /* synthetic */ ExtenalIds copy$default(ExtenalIds extenalIds, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i, Object obj) {
            if ((i & 1) != 0) {
                num = extenalIds.anilist;
            }
            if ((i & 2) != 0) {
                num2 = extenalIds.anidb;
            }
            if ((i & 4) != 0) {
                num3 = extenalIds.myanimelist;
            }
            if ((i & 8) != 0) {
                num4 = extenalIds.kitsu;
            }
            if ((i & 16) != 0) {
                num5 = extenalIds.anisearch;
            }
            if ((i & 32) != 0) {
                num6 = extenalIds.livechart;
            }
            if ((i & 64) != 0) {
                num7 = extenalIds.themoviedb;
            }
            Integer num8 = num6;
            Integer num9 = num7;
            Integer num10 = num5;
            Integer num11 = num3;
            return extenalIds.copy(num, num2, num11, num4, num10, num8, num9);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getAnilist() {
            return this.anilist;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getAnidb() {
            return this.anidb;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getMyanimelist() {
            return this.myanimelist;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getKitsu() {
            return this.kitsu;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getAnisearch() {
            return this.anisearch;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getLivechart() {
            return this.livechart;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getThemoviedb() {
            return this.themoviedb;
        }

        @NotNull
        public final ExtenalIds copy(@Nullable Integer anilist, @Nullable Integer anidb, @Nullable Integer myanimelist, @Nullable Integer kitsu, @Nullable Integer anisearch, @Nullable Integer livechart, @Nullable Integer themoviedb) {
            return new ExtenalIds(anilist, anidb, myanimelist, kitsu, anisearch, livechart, themoviedb);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExtenalIds)) {
                return false;
            }
            ExtenalIds extenalIds = (ExtenalIds) other;
            return Intrinsics.areEqual(this.anilist, extenalIds.anilist) && Intrinsics.areEqual(this.anidb, extenalIds.anidb) && Intrinsics.areEqual(this.myanimelist, extenalIds.myanimelist) && Intrinsics.areEqual(this.kitsu, extenalIds.kitsu) && Intrinsics.areEqual(this.anisearch, extenalIds.anisearch) && Intrinsics.areEqual(this.livechart, extenalIds.livechart) && Intrinsics.areEqual(this.themoviedb, extenalIds.themoviedb);
        }

        public int hashCode() {
            return ((((((((((((this.anilist == null ? 0 : this.anilist.hashCode()) * 31) + (this.anidb == null ? 0 : this.anidb.hashCode())) * 31) + (this.myanimelist == null ? 0 : this.myanimelist.hashCode())) * 31) + (this.kitsu == null ? 0 : this.kitsu.hashCode())) * 31) + (this.anisearch == null ? 0 : this.anisearch.hashCode())) * 31) + (this.livechart == null ? 0 : this.livechart.hashCode())) * 31) + (this.themoviedb != null ? this.themoviedb.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ExtenalIds(anilist=" + this.anilist + ", anidb=" + this.anidb + ", myanimelist=" + this.myanimelist + ", kitsu=" + this.kitsu + ", anisearch=" + this.anisearch + ", livechart=" + this.livechart + ", themoviedb=" + this.themoviedb + ')';
        }

        public ExtenalIds(@Nullable Integer anilist, @Nullable Integer anidb, @Nullable Integer myanimelist, @Nullable Integer kitsu, @Nullable Integer anisearch, @Nullable Integer livechart, @Nullable Integer themoviedb) {
            this.anilist = anilist;
            this.anidb = anidb;
            this.myanimelist = myanimelist;
            this.kitsu = kitsu;
            this.anisearch = anisearch;
            this.livechart = livechart;
            this.themoviedb = themoviedb;
        }

        @Nullable
        public final Integer getAnilist() {
            return this.anilist;
        }

        @Nullable
        public final Integer getAnidb() {
            return this.anidb;
        }

        @Nullable
        public final Integer getMyanimelist() {
            return this.myanimelist;
        }

        @Nullable
        public final Integer getKitsu() {
            return this.kitsu;
        }

        @Nullable
        public final Integer getAnisearch() {
            return this.anisearch;
        }

        @Nullable
        public final Integer getLivechart() {
            return this.livechart;
        }

        @Nullable
        public final Integer getThemoviedb() {
            return this.themoviedb;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getExternalIds(@org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.megix.CineStreamProvider.ExtenalIds> r24) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.getExternalIds(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Integer getYear(LoadLinksData res) {
        String strSubstringBefore$default;
        String strSubstringBefore$default2;
        Integer intOrNull;
        if (Intrinsics.areEqual(res.getTvtype(), "movie")) {
            String year = res.getYear();
            if (year != null) {
                return StringsKt.toIntOrNull(year);
            }
            return null;
        }
        String year2 = res.getYear();
        if (year2 != null && (strSubstringBefore$default2 = StringsKt.substringBefore$default(year2, "-", (String) null, 2, (Object) null)) != null && (intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default2)) != null) {
            return intOrNull;
        }
        String year3 = res.getYear();
        if (year3 == null || (strSubstringBefore$default = StringsKt.substringBefore$default(year3, "–", (String) null, 2, (Object) null)) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(strSubstringBefore$default);
    }

    private final Integer getSeasonYear(LoadLinksData res) {
        String strSubstringBefore$default;
        String strSubstringBefore$default2;
        Integer intOrNull;
        if (Intrinsics.areEqual(res.getTvtype(), "movie")) {
            return getYear(res);
        }
        String firstAired = res.getFirstAired();
        if (firstAired != null && (strSubstringBefore$default2 = StringsKt.substringBefore$default(firstAired, "-", (String) null, 2, (Object) null)) != null && (intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default2)) != null) {
            return intOrNull;
        }
        String firstAired2 = res.getFirstAired();
        if (firstAired2 == null || (strSubstringBefore$default = StringsKt.substringBefore$default(firstAired2, "–", (String) null, 2, (Object) null)) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(strSubstringBefore$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c2 A[Catch: Exception -> 0x01e5, TryCatch #5 {Exception -> 0x01e5, blocks: (B:26:0x0139, B:41:0x017d, B:43:0x0181, B:45:0x0187, B:47:0x0194, B:49:0x01a0, B:65:0x01ce, B:53:0x01a9, B:55:0x01af, B:57:0x01b9, B:61:0x01c2, B:63:0x01c8), top: B:92:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runKitsuInvokers(com.megix.CineStreamProvider.LoadLinksData r43, java.lang.Integer r44, java.lang.Integer r45, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r47, kotlin.coroutines.Continuation<? super kotlin.Unit> r48) {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megix.CineStreamProvider.runKitsuInvokers(com.megix.CineStreamProvider$LoadLinksData, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
