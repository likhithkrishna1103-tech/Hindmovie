package com.horis.cloudstreamplugins;

import com.horis.cloudstreamplugins.entities.EpisodesData;
import com.horis.cloudstreamplugins.entities.MainPage;
import com.horis.cloudstreamplugins.entities.PlayList;
import com.horis.cloudstreamplugins.entities.PlayListItem;
import com.horis.cloudstreamplugins.entities.PostCategory;
import com.horis.cloudstreamplugins.entities.PostData;
import com.horis.cloudstreamplugins.entities.SearchData;
import com.horis.cloudstreamplugins.entities.SearchResult;
import com.horis.cloudstreamplugins.entities.Season;
import com.horis.cloudstreamplugins.entities.Source;
import com.horis.cloudstreamplugins.entities.Suggest;
import com.horis.cloudstreamplugins.entities.Tracks;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PrimeVideoProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001dH\u0082@¢\u0006\u0002\u0010\u001fJ \u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020(*\u00020)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\nH\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020+0.2\u0006\u0010/\u001a\u00020\nH\u0096@¢\u0006\u0002\u00100J\u0018\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\nH\u0096@¢\u0006\u0002\u00100J4\u00104\u001a\b\u0012\u0004\u0012\u0002050.2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0082@¢\u0006\u0002\u00109JF\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u00172\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020@0>H\u0096@¢\u0006\u0002\u0010CR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\b\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/horis/cloudstreamplugins/PrimeVideoProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "newUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "cookie_value", "cookie_value$1", "headers", "", "getCookie", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lcom/horis/cloudstreamplugins/entities/PostCategory;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "id", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getEpisodes", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Id", "LoadData", "Cookie", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPrimeVideoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrimeVideoProvider.kt\ncom/horis/cloudstreamplugins/PrimeVideoProvider\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Utils.kt\ncom/horis/cloudstreamplugins/UtilsKt\n*L\n1#1,268:1\n68#2:269\n68#2:288\n68#2:294\n68#2:317\n68#2:322\n1586#3:270\n1661#3,3:271\n1642#3,10:274\n1915#3:284\n1916#3:286\n1652#3:287\n1586#3:289\n1661#3,3:290\n1586#3:295\n1661#3,3:296\n1586#3:299\n1661#3,3:300\n1586#3:303\n1661#3,3:304\n777#3:307\n873#3,2:308\n1586#3:310\n1661#3,3:311\n1661#3,3:314\n1661#3,3:318\n1915#3:323\n1915#3,2:324\n777#3:326\n873#3,2:327\n1586#3:329\n1661#3,3:330\n1916#3:333\n1#4:285\n51#5:293\n51#5:321\n*S KotlinDebug\n*F\n+ 1 PrimeVideoProvider.kt\ncom/horis/cloudstreamplugins/PrimeVideoProvider\n*L\n63#1:269\n93#1:288\n110#1:294\n187#1:317\n215#1:322\n65#1:270\n65#1:271,3\n74#1:274,10\n74#1:284\n74#1:286\n74#1:287\n95#1:289\n95#1:290,3\n115#1:295\n115#1:296,3\n116#1:299\n116#1:300,3\n122#1:303\n122#1:304,3\n123#1:307\n123#1:308,2\n128#1:310\n128#1:311,3\n140#1:314,3\n188#1:318,3\n217#1:323\n218#1:324,2\n239#1:326\n239#1:327,2\n239#1:329\n239#1:330,3\n217#1:333\n74#1:285\n104#1:293\n209#1:321\n*E\n"})
public final class PrimeVideoProvider extends MainAPI {

    @NotNull
    private static String cookie_value = "";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private String lang = "en";

    @NotNull
    private String mainUrl = "https://net52.cc";

    @NotNull
    private String newUrl = "https://net52.cc";

    @NotNull
    private String name = "PrimeVideo";
    private final boolean hasMainPage = true;

    /* JADX INFO: renamed from: cookie_value$1, reason: from kotlin metadata */
    @NotNull
    private String cookie_value = "";

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$getCookie$1, reason: invalid class name */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider", f = "PrimeVideoProvider.kt", i = {}, l = {47}, m = "getCookie", n = {}, nl = {50}, s = {}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoProvider.this.getCookie((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$getEpisodes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider", f = "PrimeVideoProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {186, 182}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "page", "pg", "title", "eid", "sid", "episodes", "page", "pg"}, nl = {182, 187}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoProvider.this.getEpisodes(null, null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$getMainPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider", f = "PrimeVideoProvider.kt", i = {0, 0, 1, 1}, l = {59, 57}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {60, 63}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider", f = "PrimeVideoProvider.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {109, 105, 151, 154, 161}, m = "load", n = {"url", "id", "url", "id", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {105, 110, 154, 159, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider", f = "PrimeVideoProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {214, 210, 220, 241}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "title", "id", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "playlist", "$this$forEach$iv", "element$iv", "item", "$this$forEach$iv", "element$iv", "it", "isCasting", "$i$f$forEach", "$i$a$-forEach-PrimeVideoProvider$loadLinks$2", "$i$f$forEach", "$i$a$-forEach-PrimeVideoProvider$loadLinks$2$1", "data", "subtitleCallback", "callback", "title", "id", "playlist", "$this$forEach$iv", "element$iv", "item", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "track", "isCasting", "$i$f$forEach", "$i$a$-forEach-PrimeVideoProvider$loadLinks$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-PrimeVideoProvider$loadLinks$2$3"}, nl = {210, 215, 219, 240}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$12", "L$13", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
        Object L$2;
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

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider", f = "PrimeVideoProvider.kt", i = {0, 0, 1, 1}, l = {93, 93}, m = "search", n = {"query", "url", "query", "url"}, nl = {93, 269}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PrimeVideoProvider.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCookie(Continuation<? super Map<String, String>> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        Object objBypass;
        PrimeVideoProvider primeVideoProvider;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.cookie_value.length() == 0) {
                    String str = this.newUrl;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.label = 1;
                    objBypass = UtilsKt.bypass(str, anonymousClass1);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    primeVideoProvider = this;
                    primeVideoProvider.cookie_value = (String) objBypass;
                }
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "pv"), TuplesKt.to("hd", "on")});
            case 1:
                primeVideoProvider = (PrimeVideoProvider) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                objBypass = $result;
                primeVideoProvider.cookie_value = (String) objBypass;
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "pv"), TuplesKt.to("hd", "on")});
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012e A[LOOP:0: B:23:0x0128->B:25:0x012e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00121 c00121;
        Requests app;
        String str;
        int page2;
        Object cookie;
        MainPageRequest request2;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        }
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                app = UtilsKt.getApp();
                str = getMainUrl() + "/pv/homepage.php";
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00121.L$1 = app;
                c00121.L$2 = str;
                page2 = page;
                c00121.I$0 = page2;
                c00121.label = 1;
                cookie = getCookie(c00121);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                String str2 = getMainUrl() + '/';
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00121.L$1 = null;
                c00121.L$2 = null;
                c00121.I$0 = page2;
                c00121.label = 2;
                $result = Requests.get$default(app, str, (Map) null, str2, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00121, 4074, (Object) null);
                if ($result != coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse res = (NiceResponse) $result;
                ResponseParser parser = res.getParser();
                Intrinsics.checkNotNull(parser);
                MainPage data = (MainPage) parser.parse(res.getText(), Reflection.getOrCreateKotlinClass(MainPage.class));
                Iterable $this$map$iv = data.getPost();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    PostCategory it = (PostCategory) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it));
                }
                List items = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items, Boxing.boxBoolean(false));
            case 1:
                page2 = c00121.I$0;
                str = (String) c00121.L$2;
                app = (Requests) c00121.L$1;
                MainPageRequest request3 = (MainPageRequest) c00121.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request3;
                cookie = $result;
                String str22 = getMainUrl() + '/';
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00121.L$1 = null;
                c00121.L$2 = null;
                c00121.I$0 = page2;
                c00121.label = 2;
                $result = Requests.get$default(app, str, (Map) null, str22, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00121, 4074, (Object) null);
                if ($result != coroutine_suspended) {
                }
                break;
            case 2:
                int i = c00121.I$0;
                ResultKt.throwOnFailure($result);
                NiceResponse res2 = (NiceResponse) $result;
                ResponseParser parser2 = res2.getParser();
                Intrinsics.checkNotNull(parser2);
                MainPage data2 = (MainPage) parser2.parse(res2.getText(), Reflection.getOrCreateKotlinClass(MainPage.class));
                Iterable $this$map$iv2 = data2.getPost();
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                }
                List items2 = (List) destination$iv$iv2;
                return MainAPIKt.newHomePageResponse(items2, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final HomePageList toHomePageList(PostCategory $this$toHomePageList) {
        String name = $this$toHomePageList.getCate();
        Iterable $this$mapNotNull$iv = StringsKt.split$default($this$toHomePageList.getIds(), new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String it = (String) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false);
    }

    private final SearchResponse toSearchResult(final String id) {
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.PrimeVideoProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return PrimeVideoProvider.toSearchResult$lambda$0(id, this, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $id, PrimeVideoProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://wsrv.nl/?url=https://imgcdn.kim/pv/v/" + $id + ".jpg&w=500");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0155 A[LOOP:0: B:23:0x014f->B:25:0x0155, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Exception {
        C00151 c00151;
        Requests app;
        Object cookie;
        String url;
        String query2;
        String str;
        Object obj;
        String str2;
        Object obj2;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        }
        Object $result = c00151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00151.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url2 = getMainUrl() + "/pv/search.php?s=" + query + "&t=" + APIHolder.INSTANCE.getUnixTime();
                app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/home";
                c00151.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00151.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00151.L$2 = app;
                c00151.L$3 = url2;
                c00151.L$4 = str3;
                c00151.label = 1;
                cookie = getCookie(c00151);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url = url2;
                query2 = query;
                str = str3;
                obj = coroutine_suspended;
                str2 = url;
                Map map = (Map) cookie;
                c00151.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00151.L$1 = SpillingKt.nullOutSpilledVariable(url);
                obj2 = obj;
                c00151.L$2 = null;
                c00151.L$3 = null;
                c00151.L$4 = null;
                c00151.label = 2;
                $result = Requests.get$default(app, str2, (Map) null, str, (Map) null, map, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00151, 4074, (Object) null);
                if ($result != obj2) {
                    return obj2;
                }
                NiceResponse this_$iv = (NiceResponse) $result;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                SearchData data = (SearchData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv = data.getSearchResult();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    final SearchResult it = (SearchResult) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getT(), AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.PrimeVideoProvider$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return PrimeVideoProvider.search$lambda$0$0(it, this, (AnimeSearchResponse) obj3);
                        }
                    }, 12, (Object) null));
                }
                return (List) destination$iv$iv;
            case 1:
                String str4 = (String) c00151.L$4;
                String str5 = (String) c00151.L$3;
                app = (Requests) c00151.L$2;
                String url3 = (String) c00151.L$1;
                String query3 = (String) c00151.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str2 = str5;
                str = str4;
                url = url3;
                query2 = query3;
                cookie = $result;
                Map map2 = (Map) cookie;
                c00151.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00151.L$1 = SpillingKt.nullOutSpilledVariable(url);
                obj2 = obj;
                c00151.L$2 = null;
                c00151.L$3 = null;
                c00151.L$4 = null;
                c00151.label = 2;
                $result = Requests.get$default(app, str2, (Map) null, str, (Map) null, map2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00151, 4074, (Object) null);
                if ($result != obj2) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                SearchData data2 = (SearchData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
                Iterable $this$map$iv2 = data2.getSearchResult();
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r10.hasNext()) {
                }
                return (List) destination$iv$iv2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(SearchResult $it, PrimeVideoProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://wsrv.nl/?url=https://imgcdn.kim/pv/v/" + $it.getId() + ".jpg&w=500");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x05d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x026d A[LOOP:1: B:36:0x0267->B:38:0x026d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x04f0  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00131 c00131;
        String id;
        Map<String, String> map;
        Object obj;
        String str;
        String id2;
        String str2;
        Requests requests;
        Object obj2;
        String id3;
        final PostData data;
        String cast;
        List destination$iv$iv;
        String genre;
        List genre2;
        String rating;
        int runTime;
        Iterable suggest;
        Object obj3;
        List castList;
        ArrayList arrayList;
        List suggest2;
        C00131 c001312;
        Object obj4;
        Object episodes;
        PostData data2;
        List genre3;
        String url2;
        String rating2;
        ArrayList episodes2;
        String url3;
        List cast2;
        ArrayList arrayList2;
        String title;
        String rating3;
        ArrayList episodes3;
        String id4;
        List cast3;
        PostData data3;
        List genre4;
        List cast4;
        String id5;
        String rating4;
        List genre5;
        String url4;
        List cast5;
        int runTime2;
        ArrayList episodes4;
        String id6;
        PostData data4;
        Iterable iterableSplit$default;
        Iterable iterableSplit$default2;
        List<Season> season;
        List listDropLast;
        Object objAmap;
        List castList2;
        ArrayList episodes5;
        List suggest3;
        String id7;
        String title2;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        }
        C00131 c001313 = c00131;
        Object $result = c001313.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c001313.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = ((Id) UtilsKt.getJSONParser().parse(url, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/pv/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = this.headers;
                String str4 = getMainUrl() + "/tv/home";
                c001313.L$0 = url;
                c001313.L$1 = id;
                c001313.L$2 = app;
                c001313.L$3 = str3;
                c001313.L$4 = map2;
                c001313.L$5 = str4;
                c001313.label = 1;
                Object cookie = getCookie(c001313);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = map2;
                obj = cookie;
                str = str4;
                id2 = url;
                str2 = str3;
                requests = app;
                c001313.L$0 = id2;
                c001313.L$1 = id;
                c001313.L$2 = null;
                c001313.L$3 = null;
                c001313.L$4 = null;
                c001313.L$5 = null;
                c001313.label = 2;
                obj2 = Requests.get$default(requests, str2, map, str, (Map) null, (Map) obj, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001313, 4072, (Object) null);
                if (obj2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                id3 = id;
                NiceResponse this_$iv = (NiceResponse) obj2;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                data = (PostData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                ArrayList episodes6 = new ArrayList();
                String title3 = data.getTitle();
                cast = data.getCast();
                String str5 = ",";
                if (cast != null || (iterableSplit$default2 = StringsKt.split$default(cast, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv = iterableSplit$default2;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        destination$iv$iv2.add(StringsKt.trim((String) item$iv$iv).toString());
                    }
                    destination$iv$iv = (List) destination$iv$iv2;
                }
                List castList3 = destination$iv$iv;
                List $this$map$iv2 = castList3;
                int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                Collection destination$iv$iv3 = new ArrayList($i$f$map);
                for (Object item$iv$iv2 : $this$map$iv2) {
                    destination$iv$iv3.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    str5 = str5;
                    $this$map$iv2 = $this$map$iv2;
                    $result = $result;
                }
                String str6 = str5;
                List cast6 = (List) destination$iv$iv3;
                genre = data.getGenre();
                if (genre != null || (iterableSplit$default = StringsKt.split$default(genre, new String[]{str6}, false, 0, 6, (Object) null)) == null) {
                    genre2 = null;
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv3 : $this$map$iv3) {
                        destination$iv$iv4.add(StringsKt.trim((String) item$iv$iv3).toString());
                        $this$map$iv3 = $this$map$iv3;
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv4;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        if (((String) element$iv$iv).length() > 0) {
                            destination$iv$iv5.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                    }
                    genre2 = (List) destination$iv$iv5;
                }
                String match = data.getMatch();
                rating = match == null ? StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null) : null;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest == null) {
                    Iterable $this$map$iv4 = suggest;
                    int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10);
                    Collection destination$iv$iv6 = new ArrayList($i$f$map2);
                    Iterable $this$mapTo$iv$iv = $this$map$iv4;
                    for (Object item$iv$iv4 : $this$mapTo$iv$iv) {
                        Iterable $this$map$iv5 = $this$map$iv4;
                        final Suggest it = (Suggest) item$iv$iv4;
                        destination$iv$iv6.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.PrimeVideoProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj5) {
                                return PrimeVideoProvider.load$lambda$4$0(it, this, (AnimeSearchResponse) obj5);
                            }
                        }, 12, (Object) null));
                        $this$map$iv4 = $this$map$iv5;
                        castList3 = castList3;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        coroutine_suspended = coroutine_suspended;
                    }
                    obj3 = coroutine_suspended;
                    castList = castList3;
                    arrayList = (List) destination$iv$iv6;
                } else {
                    obj3 = coroutine_suspended;
                    castList = castList3;
                    arrayList = null;
                }
                suggest2 = arrayList;
                if (CollectionsKt.first(data.getEpisodes()) != null) {
                    Boxing.boxBoolean(episodes6.add(MainAPIKt.newEpisode(this, new LoadData(title3, id3), new Function1() { // from class: com.horis.cloudstreamplugins.PrimeVideoProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj5) {
                            return PrimeVideoProvider.load$lambda$5(data, (Episode) obj5);
                        }
                    })));
                    c001312 = c001313;
                    cast4 = cast6;
                    id5 = id3;
                    rating4 = rating;
                    genre5 = genre2;
                    obj4 = obj3;
                    url4 = id2;
                    cast5 = suggest2;
                    runTime2 = runTime;
                    episodes4 = episodes6;
                    id6 = title3;
                    data4 = data;
                    TvType type = CollectionsKt.first(data4.getEpisodes()) != null ? TvType.Movie : TvType.TvSeries;
                    String rating5 = rating4;
                    AnonymousClass5 anonymousClass5 = new AnonymousClass5(id5, this, data4, genre5, cast4, rating4, runTime2, cast5, null);
                    c001312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c001312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                    c001312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c001312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                    c001312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                    c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c001312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                    c001312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                    c001312.L$8 = SpillingKt.nullOutSpilledVariable(rating5);
                    c001312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                    c001312.L$10 = SpillingKt.nullOutSpilledVariable(type);
                    c001312.I$0 = runTime2;
                    c001312.label = 5;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type, episodes4, anonymousClass5, c001312);
                    return $result != obj4 ? obj4 : $result;
                }
                Iterable $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                ArrayList destination$iv = episodes6;
                int $i$f$mapTo = 0;
                for (Iterator it2 = $this$mapTo$iv.iterator(); it2.hasNext(); it2 = it2) {
                    Object item$iv = it2.next();
                    Iterable $this$mapTo$iv2 = $this$mapTo$iv;
                    final com.horis.cloudstreamplugins.entities.Episode it3 = (com.horis.cloudstreamplugins.entities.Episode) item$iv;
                    destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title3, it3.getId()), new Function1() { // from class: com.horis.cloudstreamplugins.PrimeVideoProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj5) {
                            return PrimeVideoProvider.load$lambda$6$0(it3, (Episode) obj5);
                        }
                    }));
                    $this$mapTo$iv = $this$mapTo$iv2;
                    $i$f$mapTo = $i$f$mapTo;
                }
                Integer nextPageShow = data.getNextPageShow();
                if (nextPageShow != null && nextPageShow.intValue() == 1) {
                    String title4 = data.getNextPageSeason();
                    Intrinsics.checkNotNull(title4);
                    c001313.L$0 = id2;
                    c001313.L$1 = id3;
                    c001313.L$2 = data;
                    c001313.L$3 = episodes6;
                    c001313.L$4 = title3;
                    c001313.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c001313.L$6 = cast6;
                    c001313.L$7 = genre2;
                    c001313.L$8 = rating;
                    c001313.L$9 = suggest2;
                    c001313.L$10 = episodes6;
                    c001313.I$0 = runTime;
                    c001313.label = 3;
                    String url5 = id2;
                    episodes = getEpisodes(title3, url5, title4, 2, c001313);
                    c001312 = c001313;
                    obj4 = obj3;
                    if (episodes == obj4) {
                        return obj4;
                    }
                    List list = genre2;
                    data2 = data;
                    genre3 = list;
                    url2 = url5;
                    rating2 = rating;
                    episodes2 = episodes6;
                    url3 = title3;
                    cast2 = cast6;
                    arrayList2 = episodes2;
                    arrayList2.addAll((Collection) episodes);
                    List list2 = cast2;
                    id4 = id3;
                    cast3 = list2;
                    title = url3;
                    rating = rating2;
                    episodes3 = episodes2;
                    data3 = data2;
                    rating3 = url2;
                    genre2 = genre3;
                    genre4 = castList;
                    season = data3.getSeason();
                    if (season != null || (listDropLast = CollectionsKt.dropLast(season, 1)) == null) {
                        List list3 = genre2;
                        url4 = rating3;
                        genre5 = list3;
                        castList = genre4;
                        cast4 = cast3;
                        cast5 = suggest2;
                        runTime2 = runTime;
                        episodes4 = episodes3;
                        id5 = id4;
                        id6 = title;
                        data4 = data3;
                        rating4 = rating;
                        TvType type2 = CollectionsKt.first(data4.getEpisodes()) != null ? TvType.Movie : TvType.TvSeries;
                        String rating52 = rating4;
                        AnonymousClass5 anonymousClass52 = new AnonymousClass5(id5, this, data4, genre5, cast4, rating4, runTime2, cast5, null);
                        c001312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c001312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                        c001312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c001312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c001312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                        c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                        c001312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                        c001312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                        c001312.L$8 = SpillingKt.nullOutSpilledVariable(rating52);
                        c001312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                        c001312.L$10 = SpillingKt.nullOutSpilledVariable(type2);
                        c001312.I$0 = runTime2;
                        c001312.label = 5;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type2, episodes4, anonymousClass52, c001312);
                        if ($result != obj4) {
                        }
                    } else {
                        List castList4 = genre4;
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(episodes3, this, title, rating3, null);
                        c001312.L$0 = rating3;
                        c001312.L$1 = id4;
                        c001312.L$2 = data3;
                        c001312.L$3 = episodes3;
                        c001312.L$4 = title;
                        c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList4);
                        c001312.L$6 = cast3;
                        c001312.L$7 = genre2;
                        c001312.L$8 = rating;
                        c001312.L$9 = suggest2;
                        c001312.L$10 = null;
                        c001312.I$0 = runTime;
                        c001312.label = 4;
                        objAmap = ParCollectionsKt.amap(listDropLast, anonymousClass4, c001312);
                        if (objAmap == obj4) {
                            return obj4;
                        }
                        List list4 = genre2;
                        url4 = rating3;
                        genre5 = list4;
                        castList2 = castList4;
                        episodes5 = episodes3;
                        suggest3 = suggest2;
                        id7 = id4;
                        id6 = title;
                        title2 = rating;
                        List list5 = cast3;
                        cast5 = suggest3;
                        id5 = id7;
                        cast4 = list5;
                        PostData postData = data3;
                        rating4 = title2;
                        data4 = postData;
                        castList = castList2;
                        runTime2 = runTime;
                        episodes4 = episodes5;
                        TvType type22 = CollectionsKt.first(data4.getEpisodes()) != null ? TvType.Movie : TvType.TvSeries;
                        String rating522 = rating4;
                        AnonymousClass5 anonymousClass522 = new AnonymousClass5(id5, this, data4, genre5, cast4, rating4, runTime2, cast5, null);
                        c001312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c001312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                        c001312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c001312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c001312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                        c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                        c001312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                        c001312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                        c001312.L$8 = SpillingKt.nullOutSpilledVariable(rating522);
                        c001312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                        c001312.L$10 = SpillingKt.nullOutSpilledVariable(type22);
                        c001312.I$0 = runTime2;
                        c001312.label = 5;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type22, episodes4, anonymousClass522, c001312);
                        if ($result != obj4) {
                        }
                    }
                } else {
                    String url6 = id2;
                    String title5 = title3;
                    c001312 = c001313;
                    obj4 = obj3;
                    title = title5;
                    rating3 = url6;
                    episodes3 = episodes6;
                    id4 = id3;
                    cast3 = cast6;
                    data3 = data;
                    genre4 = castList;
                    season = data3.getSeason();
                    if (season != null) {
                    }
                    List list32 = genre2;
                    url4 = rating3;
                    genre5 = list32;
                    castList = genre4;
                    cast4 = cast3;
                    cast5 = suggest2;
                    runTime2 = runTime;
                    episodes4 = episodes3;
                    id5 = id4;
                    id6 = title;
                    data4 = data3;
                    rating4 = rating;
                    TvType type222 = CollectionsKt.first(data4.getEpisodes()) != null ? TvType.Movie : TvType.TvSeries;
                    String rating5222 = rating4;
                    AnonymousClass5 anonymousClass5222 = new AnonymousClass5(id5, this, data4, genre5, cast4, rating4, runTime2, cast5, null);
                    c001312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c001312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                    c001312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c001312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                    c001312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                    c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c001312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                    c001312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                    c001312.L$8 = SpillingKt.nullOutSpilledVariable(rating5222);
                    c001312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                    c001312.L$10 = SpillingKt.nullOutSpilledVariable(type222);
                    c001312.I$0 = runTime2;
                    c001312.label = 5;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type222, episodes4, anonymousClass5222, c001312);
                    if ($result != obj4) {
                    }
                }
                break;
            case 1:
                String str7 = (String) c001313.L$5;
                Map<String, String> map3 = (Map) c001313.L$4;
                String str8 = (String) c001313.L$3;
                Requests requests2 = (Requests) c001313.L$2;
                id = (String) c001313.L$1;
                String url7 = (String) c001313.L$0;
                ResultKt.throwOnFailure($result);
                map = map3;
                obj = $result;
                str = str7;
                str2 = str8;
                id2 = url7;
                requests = requests2;
                c001313.L$0 = id2;
                c001313.L$1 = id;
                c001313.L$2 = null;
                c001313.L$3 = null;
                c001313.L$4 = null;
                c001313.L$5 = null;
                c001313.label = 2;
                obj2 = Requests.get$default(requests, str2, map, str, (Map) null, (Map) obj, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001313, 4072, (Object) null);
                if (obj2 != coroutine_suspended) {
                }
                break;
            case 2:
                String id8 = (String) c001313.L$1;
                String url8 = (String) c001313.L$0;
                ResultKt.throwOnFailure($result);
                id3 = id8;
                id2 = url8;
                obj2 = $result;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data = (PostData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                ArrayList episodes62 = new ArrayList();
                String title32 = data.getTitle();
                cast = data.getCast();
                String str52 = ",";
                if (cast != null) {
                    destination$iv$iv = CollectionsKt.emptyList();
                    List castList32 = destination$iv$iv;
                    List $this$map$iv22 = castList32;
                    int $i$f$map3 = CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10);
                    Collection destination$iv$iv32 = new ArrayList($i$f$map3);
                    while (r19.hasNext()) {
                    }
                    String str62 = str52;
                    List cast62 = (List) destination$iv$iv32;
                    genre = data.getGenre();
                    if (genre != null) {
                        genre2 = null;
                        String match2 = data.getMatch();
                        rating = match2 == null ? StringsKt.replace$default(match2, "IMDb ", "", false, 4, (Object) null) : null;
                        runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                        suggest = data.getSuggest();
                        if (suggest == null) {
                        }
                        suggest2 = arrayList;
                        if (CollectionsKt.first(data.getEpisodes()) != null) {
                        }
                    }
                }
            case 3:
                int runTime3 = c001313.I$0;
                arrayList2 = (ArrayList) c001313.L$10;
                List suggest4 = (List) c001313.L$9;
                rating2 = (String) c001313.L$8;
                genre3 = (List) c001313.L$7;
                cast2 = (List) c001313.L$6;
                List castList5 = (List) c001313.L$5;
                String title6 = (String) c001313.L$4;
                ArrayList episodes7 = (ArrayList) c001313.L$3;
                data2 = (PostData) c001313.L$2;
                id3 = (String) c001313.L$1;
                url2 = (String) c001313.L$0;
                ResultKt.throwOnFailure($result);
                castList = castList5;
                url3 = title6;
                runTime = runTime3;
                c001312 = c001313;
                episodes2 = episodes7;
                obj4 = coroutine_suspended;
                suggest2 = suggest4;
                episodes = $result;
                arrayList2.addAll((Collection) episodes);
                List list22 = cast2;
                id4 = id3;
                cast3 = list22;
                title = url3;
                rating = rating2;
                episodes3 = episodes2;
                data3 = data2;
                rating3 = url2;
                genre2 = genre3;
                genre4 = castList;
                season = data3.getSeason();
                if (season != null) {
                }
                List list322 = genre2;
                url4 = rating3;
                genre5 = list322;
                castList = genre4;
                cast4 = cast3;
                cast5 = suggest2;
                runTime2 = runTime;
                episodes4 = episodes3;
                id5 = id4;
                id6 = title;
                data4 = data3;
                rating4 = rating;
                TvType type2222 = CollectionsKt.first(data4.getEpisodes()) != null ? TvType.Movie : TvType.TvSeries;
                String rating52222 = rating4;
                AnonymousClass5 anonymousClass52222 = new AnonymousClass5(id5, this, data4, genre5, cast4, rating4, runTime2, cast5, null);
                c001312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c001312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c001312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c001312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                c001312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                c001312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                c001312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                c001312.L$8 = SpillingKt.nullOutSpilledVariable(rating52222);
                c001312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                c001312.L$10 = SpillingKt.nullOutSpilledVariable(type2222);
                c001312.I$0 = runTime2;
                c001312.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type2222, episodes4, anonymousClass52222, c001312);
                if ($result != obj4) {
                }
                break;
            case 4:
                int runTime4 = c001313.I$0;
                suggest3 = (List) c001313.L$9;
                title2 = (String) c001313.L$8;
                genre5 = (List) c001313.L$7;
                cast3 = (List) c001313.L$6;
                castList2 = (List) c001313.L$5;
                id6 = (String) c001313.L$4;
                ArrayList episodes8 = (ArrayList) c001313.L$3;
                PostData data5 = (PostData) c001313.L$2;
                String id9 = (String) c001313.L$1;
                url4 = (String) c001313.L$0;
                ResultKt.throwOnFailure($result);
                episodes5 = episodes8;
                runTime = runTime4;
                objAmap = $result;
                data3 = data5;
                c001312 = c001313;
                id7 = id9;
                obj4 = coroutine_suspended;
                List list52 = cast3;
                cast5 = suggest3;
                id5 = id7;
                cast4 = list52;
                PostData postData2 = data3;
                rating4 = title2;
                data4 = postData2;
                castList = castList2;
                runTime2 = runTime;
                episodes4 = episodes5;
                TvType type22222 = CollectionsKt.first(data4.getEpisodes()) != null ? TvType.Movie : TvType.TvSeries;
                String rating522222 = rating4;
                AnonymousClass5 anonymousClass522222 = new AnonymousClass5(id5, this, data4, genre5, cast4, rating4, runTime2, cast5, null);
                c001312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c001312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c001312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c001312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                c001312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                c001312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                c001312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                c001312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                c001312.L$8 = SpillingKt.nullOutSpilledVariable(rating522222);
                c001312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                c001312.L$10 = SpillingKt.nullOutSpilledVariable(type22222);
                c001312.I$0 = runTime2;
                c001312.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type22222, episodes4, anonymousClass522222, c001312);
                if ($result != obj4) {
                }
                break;
            case 5:
                int i = c001313.I$0;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Suggest $it, PrimeVideoProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://wsrv.nl/?url=https://imgcdn.kim/pv/v/" + $it.getId() + ".jpg&w=500");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/tv/home")));
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$5(PostData $data, Episode $this$newEpisode) {
        $this$newEpisode.setName($data.getTitle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0(com.horis.cloudstreamplugins.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/pvepimg/150/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$load$4, reason: invalid class name */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/horis/cloudstreamplugins/entities/Season;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider$load$4", f = "PrimeVideoProvider.kt", i = {0}, l = {155}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<Season, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ String $title;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PrimeVideoProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ArrayList<Episode> arrayList, PrimeVideoProvider primeVideoProvider, String str, String str2, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$episodes = arrayList;
            this.this$0 = primeVideoProvider;
            this.$title = str;
            this.$url = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$episodes, this.this$0, this.$title, this.$url, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        public final Object invoke(Season season, Continuation<? super Boolean> continuation) {
            return create(season, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) throws Exception {
            Object episodes;
            ArrayList<Episode> arrayList;
            Season it = (Season) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ArrayList<Episode> arrayList2 = this.$episodes;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = arrayList2;
                    this.label = 1;
                    episodes = this.this$0.getEpisodes(this.$title, this.$url, it.getId(), 1, (Continuation) this);
                    if (episodes == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    arrayList = arrayList2;
                    break;
                    break;
                case 1:
                    arrayList = (ArrayList) this.L$1;
                    ResultKt.throwOnFailure($result);
                    episodes = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Boxing.boxBoolean(arrayList.addAll((Collection) episodes));
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.PrimeVideoProvider$load$5, reason: invalid class name */
    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.PrimeVideoProvider$load$5", f = "PrimeVideoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $cast;
        final /* synthetic */ PostData $data;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $id;
        final /* synthetic */ String $rating;
        final /* synthetic */ int $runTime;
        final /* synthetic */ List<AnimeSearchResponse> $suggest;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PrimeVideoProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str, PrimeVideoProvider primeVideoProvider, PostData postData, List<String> list, List<ActorData> list2, String str2, int i, List<AnimeSearchResponse> list3, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = primeVideoProvider;
            this.$data = postData;
            this.$genre = list;
            this.$cast = list2;
            this.$rating = str2;
            this.$runTime = i;
            this.$suggest = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$id, this.this$0, this.$data, this.$genre, this.$cast, this.$rating, this.$runTime, this.$suggest, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl("https://wsrv.nl/?url=https://imgcdn.kim/pv/v/" + this.$id + ".jpg&w=500");
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl("https://wsrv.nl/?url=https://imgcdn.kim/pv/h/" + this.$id + ".jpg&w=500");
                    $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl() + "/home")));
                    $this$newTvSeriesLoadResponse.setPlot(this.$data.getDesc());
                    $this$newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(this.$data.getYear()));
                    $this$newTvSeriesLoadResponse.setTags(this.$genre);
                    $this$newTvSeriesLoadResponse.setActors(this.$cast);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newTvSeriesLoadResponse.setDuration(Boxing.boxInt(this.$runTime));
                    $this$newTvSeriesLoadResponse.setContentRating(this.$data.getUa());
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$suggest);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x021d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x017e -> B:23:0x0190). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getEpisodes(String title, String eid, String sid, int page, Continuation<? super List<Episode>> continuation) throws Exception {
        C00111 c00111;
        PrimeVideoProvider primeVideoProvider;
        PrimeVideoProvider primeVideoProvider2;
        Object $result;
        ArrayList episodes;
        Continuation<? super List<Episode>> continuation2;
        C00111 c001112;
        String title2;
        String str;
        Map<String, String> map;
        String str2;
        Requests requests;
        C00111 c001113;
        PrimeVideoProvider primeVideoProvider3;
        Object $result2;
        int pg;
        int page2;
        ArrayList episodes2;
        String sid2;
        String eid2;
        String title3;
        Object obj;
        int pg2;
        Object obj2;
        String eid3;
        String sid3;
        int page3;
        Iterable episodes3;
        String eid4;
        Object obj3;
        EpisodesData data;
        int page4;
        Continuation<? super List<Episode>> continuation3 = continuation;
        if (continuation3 instanceof C00111) {
            c00111 = (C00111) continuation3;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
                primeVideoProvider = this;
            } else {
                primeVideoProvider = this;
                c00111 = primeVideoProvider.new C00111(continuation3);
            }
        }
        Object $result3 = c00111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00111.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                ArrayList episodes4 = new ArrayList();
                primeVideoProvider2 = primeVideoProvider;
                $result = $result3;
                Object obj4 = coroutine_suspended;
                episodes = episodes4;
                int pg3 = page;
                String sid4 = sid;
                continuation2 = continuation3;
                c001112 = c00111;
                title2 = title;
                String eid5 = eid;
                int page5 = page;
                Requests app = UtilsKt.getApp();
                String str3 = primeVideoProvider2.getMainUrl() + "/pv/episodes.php?s=" + sid4 + "&series=" + eid5 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg3;
                Map<String, String> map2 = primeVideoProvider2.headers;
                String str4 = primeVideoProvider2.getMainUrl() + "/home";
                c001112.L$0 = title2;
                c001112.L$1 = eid5;
                c001112.L$2 = sid4;
                c001112.L$3 = episodes;
                c001112.L$4 = app;
                c001112.L$5 = str3;
                c001112.L$6 = map2;
                c001112.L$7 = str4;
                c001112.I$0 = page5;
                c001112.I$1 = pg3;
                c001112.label = 1;
                Object cookie = primeVideoProvider2.getCookie(c001112);
                if (cookie != obj4) {
                    return obj4;
                }
                C00111 c001114 = c001112;
                sid2 = sid4;
                $result3 = cookie;
                c001113 = c001114;
                $result2 = $result;
                primeVideoProvider3 = primeVideoProvider2;
                eid2 = eid5;
                str = str4;
                page2 = page5;
                coroutine_suspended = obj4;
                pg = pg3;
                requests = app;
                map = map2;
                title3 = title2;
                continuation3 = continuation2;
                episodes2 = episodes;
                str2 = str3;
                c001113.L$0 = title3;
                c001113.L$1 = eid2;
                c001113.L$2 = sid2;
                c001113.L$3 = episodes2;
                ArrayList episodes5 = episodes2;
                c001113.L$4 = null;
                c001113.L$5 = null;
                c001113.L$6 = null;
                c001113.L$7 = null;
                c001113.I$0 = page2;
                c001113.I$1 = pg;
                c001113.label = 2;
                obj = coroutine_suspended;
                String sid5 = sid2;
                int page6 = page2;
                String str5 = str2;
                pg2 = pg;
                Requests requests2 = requests;
                String eid6 = eid2;
                String title4 = title3;
                Continuation<? super List<Episode>> continuation4 = continuation3;
                $result3 = Requests.get$default(requests2, str5, map, str, (Map) null, (Map) $result3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001113, 4072, (Object) null);
                if ($result3 != obj) {
                    return obj;
                }
                continuation2 = continuation4;
                obj2 = obj;
                c001112 = c001113;
                $result = $result2;
                primeVideoProvider2 = primeVideoProvider3;
                eid3 = eid6;
                title2 = title4;
                episodes = episodes5;
                sid3 = sid5;
                page3 = page6;
                NiceResponse this_$iv = (NiceResponse) $result3;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                EpisodesData data2 = (EpisodesData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(EpisodesData.class));
                episodes3 = data2.getEpisodes();
                if (episodes3 == null) {
                    Iterable $this$mapTo$iv = episodes3;
                    ArrayList destination$iv = episodes;
                    for (Object item$iv : $this$mapTo$iv) {
                        String eid7 = eid3;
                        final com.horis.cloudstreamplugins.entities.Episode it = (com.horis.cloudstreamplugins.entities.Episode) item$iv;
                        destination$iv.add(MainAPIKt.newEpisode(primeVideoProvider2, new LoadData(title2, it.getId()), new Function1() { // from class: com.horis.cloudstreamplugins.PrimeVideoProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj5) {
                                return PrimeVideoProvider.getEpisodes$lambda$0$0(it, (Episode) obj5);
                            }
                        }));
                        eid3 = eid7;
                        obj2 = obj2;
                        data2 = data2;
                        page3 = page3;
                    }
                    eid4 = eid3;
                    obj3 = obj2;
                    data = data2;
                    page4 = page3;
                } else {
                    eid4 = eid3;
                    obj3 = obj2;
                    data = data2;
                    page4 = page3;
                }
                if (data.getNextPageShow() != 0) {
                    return episodes;
                }
                pg3 = pg2 + 1;
                eid5 = eid4;
                sid4 = sid3;
                obj4 = obj3;
                page5 = page4;
                Requests app2 = UtilsKt.getApp();
                String str32 = primeVideoProvider2.getMainUrl() + "/pv/episodes.php?s=" + sid4 + "&series=" + eid5 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg3;
                Map<String, String> map22 = primeVideoProvider2.headers;
                String str42 = primeVideoProvider2.getMainUrl() + "/home";
                c001112.L$0 = title2;
                c001112.L$1 = eid5;
                c001112.L$2 = sid4;
                c001112.L$3 = episodes;
                c001112.L$4 = app2;
                c001112.L$5 = str32;
                c001112.L$6 = map22;
                c001112.L$7 = str42;
                c001112.I$0 = page5;
                c001112.I$1 = pg3;
                c001112.label = 1;
                Object cookie2 = primeVideoProvider2.getCookie(c001112);
                if (cookie2 != obj4) {
                }
                break;
            case 1:
                int pg4 = c00111.I$1;
                int page7 = c00111.I$0;
                str = (String) c00111.L$7;
                map = (Map) c00111.L$6;
                str2 = (String) c00111.L$5;
                requests = (Requests) c00111.L$4;
                ArrayList episodes6 = (ArrayList) c00111.L$3;
                String sid6 = (String) c00111.L$2;
                String eid8 = (String) c00111.L$1;
                String title5 = (String) c00111.L$0;
                ResultKt.throwOnFailure($result3);
                c001113 = c00111;
                primeVideoProvider3 = primeVideoProvider;
                $result2 = $result3;
                pg = pg4;
                page2 = page7;
                episodes2 = episodes6;
                sid2 = sid6;
                eid2 = eid8;
                title3 = title5;
                c001113.L$0 = title3;
                c001113.L$1 = eid2;
                c001113.L$2 = sid2;
                c001113.L$3 = episodes2;
                ArrayList episodes52 = episodes2;
                c001113.L$4 = null;
                c001113.L$5 = null;
                c001113.L$6 = null;
                c001113.L$7 = null;
                c001113.I$0 = page2;
                c001113.I$1 = pg;
                c001113.label = 2;
                obj = coroutine_suspended;
                String sid52 = sid2;
                int page62 = page2;
                String str52 = str2;
                pg2 = pg;
                Requests requests22 = requests;
                String eid62 = eid2;
                String title42 = title3;
                Continuation<? super List<Episode>> continuation42 = continuation3;
                $result3 = Requests.get$default(requests22, str52, map, str, (Map) null, (Map) $result3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001113, 4072, (Object) null);
                if ($result3 != obj) {
                }
                break;
            case 2:
                int pg5 = c00111.I$1;
                int page8 = c00111.I$0;
                ArrayList episodes7 = (ArrayList) c00111.L$3;
                sid3 = (String) c00111.L$2;
                String eid9 = (String) c00111.L$1;
                String title6 = (String) c00111.L$0;
                ResultKt.throwOnFailure($result3);
                primeVideoProvider2 = primeVideoProvider;
                obj2 = coroutine_suspended;
                pg2 = pg5;
                page3 = page8;
                continuation2 = continuation3;
                c001112 = c00111;
                eid3 = eid9;
                title2 = title6;
                episodes = episodes7;
                $result = $result3;
                NiceResponse this_$iv2 = (NiceResponse) $result3;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                EpisodesData data22 = (EpisodesData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(EpisodesData.class));
                episodes3 = data22.getEpisodes();
                if (episodes3 == null) {
                }
                if (data.getNextPageShow() != 0) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEpisodes$lambda$0$0(com.horis.cloudstreamplugins.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://img.nfmirrorcdn.top/pvepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x029a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0451 -> B:45:0x048d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x053c -> B:51:0x0565). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x05b2 -> B:54:0x05c3). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function12, @NotNull Continuation<? super Boolean> continuation) throws Exception {
        C00141 c00141;
        String id;
        Object cookie;
        Object $result;
        Requests requests;
        Map<String, String> map;
        Function1<? super SubtitleFile, Unit> function13;
        Object obj;
        String str;
        Function1<? super ExtractorLink, Unit> function14;
        String id2;
        String title;
        boolean isCasting2;
        String data2;
        Object $result2;
        boolean z;
        Function1<? super ExtractorLink, Unit> function15;
        C00141 c001412;
        Object obj2;
        String data3;
        String id3;
        String title2;
        boolean isCasting3;
        Function1<? super SubtitleFile, Unit> function16;
        Iterator<PlayListItem> it;
        Function1<? super SubtitleFile, Unit> function17;
        String data4;
        String id4;
        String title3;
        Object obj3;
        Iterable $this$forEach$iv;
        Object $this$forEach$iv2;
        Object $result3;
        Continuation<? super Boolean> continuation2;
        Function1<? super ExtractorLink, Unit> function18;
        C00141 c001413;
        PlayListItem item;
        PrimeVideoProvider primeVideoProvider;
        int $i$f$forEach;
        Iterator it2;
        int $i$f$forEach2;
        int $i$f$forEach3;
        boolean isCasting4;
        Object element$iv;
        List<Source> $this$forEach$iv3;
        PlayListItem item2;
        Iterable tracks;
        PrimeVideoProvider primeVideoProvider2;
        int $i$f$map;
        Continuation<? super Boolean> continuation3;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$forEach$iv4;
        String id5;
        int $i$f$forEach4;
        boolean isCasting5;
        Collection destination$iv$iv;
        int $i$f$mapTo;
        Iterator it3;
        int i;
        Function1<? super ExtractorLink, Unit> function19;
        C00141 c001414;
        Object obj4;
        Function1<? super SubtitleFile, Unit> function110;
        Object $result4;
        Object $result5;
        Object $this$mapTo$iv$iv2;
        Iterable $this$forEach$iv5;
        boolean isCasting6;
        Object element$iv2;
        String id6;
        PlayListItem item3;
        int $i$f$map2;
        Collection collection;
        Object element$iv3;
        Iterator it4;
        int $i$f$mapTo2;
        Object $result6;
        String data5;
        Object $result7;
        int $i$f$forEach5;
        C00141 c001415;
        String data6;
        Object item$iv$iv;
        Iterable $this$mapTo$iv$iv3;
        int i2;
        Iterator<PlayListItem> it5;
        PrimeVideoProvider primeVideoProvider3;
        Function1<? super SubtitleFile, Unit> function111;
        Collection destination$iv$iv2;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        }
        Object $result8 = c00141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result8);
                LoadData loadData = (LoadData) UtilsKt.getJSONParser().parse(data, Reflection.getOrCreateKotlinClass(LoadData.class));
                String title4 = loadData.getTitle();
                String id7 = loadData.getId();
                Requests app = UtilsKt.getApp();
                String str2 = this.newUrl + "/pv/playlist.php?id=" + id7 + "&t=" + title4 + "&tm=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = this.headers;
                id = this.newUrl + "/home";
                c00141.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00141.L$1 = function1;
                c00141.L$2 = function12;
                c00141.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00141.L$4 = SpillingKt.nullOutSpilledVariable(id7);
                c00141.L$5 = app;
                c00141.L$6 = str2;
                c00141.L$7 = map2;
                c00141.L$8 = id;
                c00141.Z$0 = isCasting;
                c00141.label = 1;
                cookie = getCookie(c00141);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = $result8;
                requests = app;
                map = map2;
                function13 = function1;
                obj = coroutine_suspended;
                str = str2;
                function14 = function12;
                id2 = id7;
                title = title4;
                isCasting2 = isCasting;
                data2 = data;
                c00141.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00141.L$1 = function13;
                c00141.L$2 = function14;
                c00141.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00141.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00141.L$5 = null;
                c00141.L$6 = null;
                c00141.L$7 = null;
                c00141.L$8 = null;
                c00141.Z$0 = isCasting2;
                c00141.label = 2;
                Function1<? super SubtitleFile, Unit> function112 = function13;
                boolean isCasting7 = isCasting2;
                $result2 = $result;
                z = true;
                function15 = function14;
                c001412 = c00141;
                obj2 = obj;
                $result8 = Requests.get$default(requests, str, map, id, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001412, 4072, (Object) null);
                if ($result8 != obj2) {
                    return obj2;
                }
                data3 = data2;
                id3 = id2;
                title2 = title;
                isCasting3 = isCasting7;
                function16 = function112;
                NiceResponse this_$iv = (NiceResponse) $result8;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                Object playlist = (PlayList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PlayList.class));
                Iterable $this$forEach$iv6 = (Iterable) playlist;
                PrimeVideoProvider primeVideoProvider4 = this;
                int $i$f$forEach6 = 0;
                it = $this$forEach$iv6.iterator();
                function17 = function16;
                data4 = data3;
                id4 = id3;
                title3 = title2;
                obj3 = obj2;
                $this$forEach$iv = $this$forEach$iv6;
                boolean isCasting8 = isCasting3;
                $this$forEach$iv2 = playlist;
                $result3 = $result2;
                continuation2 = continuation;
                if (!it.hasNext()) {
                    Object element$iv4 = it.next();
                    PlayListItem item4 = (PlayListItem) element$iv4;
                    $this$forEach$iv3 = item4.getSources();
                    primeVideoProvider = primeVideoProvider4;
                    item = item4;
                    c001413 = c001412;
                    it2 = $this$forEach$iv3.iterator();
                    function18 = function15;
                    $i$f$forEach3 = $i$f$forEach6;
                    element$iv = element$iv4;
                    $i$f$forEach2 = 0;
                    isCasting4 = isCasting8;
                    $i$f$forEach = 0;
                    while (it2.hasNext()) {
                        Object element$iv5 = it2.next();
                        Source it6 = (Source) element$iv5;
                        String name = primeVideoProvider.getName();
                        String name2 = primeVideoProvider.getName();
                        Continuation<? super Boolean> continuation4 = continuation2;
                        Object $result9 = $result3;
                        PrimeVideoProvider primeVideoProvider5 = primeVideoProvider;
                        Object playlist2 = $this$forEach$iv2;
                        String str3 = primeVideoProvider5.newUrl + it6.getFile();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        PrimeVideoProvider$loadLinks$2$1$1 primeVideoProvider$loadLinks$2$1$1 = new PrimeVideoProvider$loadLinks$2$1$1(primeVideoProvider5, it6, null);
                        C00141 c001416 = c001413;
                        c001416.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c001416.L$1 = function17;
                        Function1<? super ExtractorLink, Unit> function113 = function18;
                        c001416.L$2 = function113;
                        c001416.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                        c001416.L$4 = SpillingKt.nullOutSpilledVariable(id4);
                        c001416.L$5 = SpillingKt.nullOutSpilledVariable(playlist2);
                        c001416.L$6 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        c001416.L$7 = it;
                        c001416.L$8 = SpillingKt.nullOutSpilledVariable(element$iv);
                        PlayListItem item5 = item;
                        c001416.L$9 = item5;
                        c001416.L$10 = SpillingKt.nullOutSpilledVariable($this$forEach$iv3);
                        Iterator it7 = it2;
                        c001416.L$11 = it7;
                        c001416.L$12 = SpillingKt.nullOutSpilledVariable(element$iv5);
                        c001416.L$13 = SpillingKt.nullOutSpilledVariable(it6);
                        c001416.L$14 = function113;
                        c001416.L$15 = null;
                        c001416.L$16 = null;
                        c001416.L$17 = null;
                        c001416.Z$0 = isCasting4;
                        c001416.I$0 = $i$f$forEach3;
                        c001416.I$1 = $i$f$forEach2;
                        c001416.I$2 = $i$f$forEach;
                        c001416.I$3 = 0;
                        c001416.label = 3;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, str3, extractorLinkType, primeVideoProvider$loadLinks$2$1$1, c001416);
                        if (objNewExtractorLink == obj3) {
                            return obj3;
                        }
                        Function1<? super SubtitleFile, Unit> function114 = function17;
                        Iterator<PlayListItem> it8 = it;
                        String data7 = data4;
                        boolean isCasting9 = isCasting4;
                        function18 = function113;
                        Iterable $this$forEach$iv7 = $this$forEach$iv3;
                        item = item5;
                        c001413 = c001416;
                        Iterable $this$forEach$iv8 = $this$forEach$iv;
                        Object element$iv6 = element$iv;
                        int $i$f$forEach7 = $i$f$forEach;
                        int $i$f$forEach8 = $i$f$forEach3;
                        int $i$f$forEach9 = $i$f$forEach2;
                        String title5 = title3;
                        function18.invoke(objNewExtractorLink);
                        primeVideoProvider = primeVideoProvider5;
                        continuation2 = continuation4;
                        $result3 = $result9;
                        $i$f$forEach = $i$f$forEach7;
                        function17 = function114;
                        it2 = it7;
                        data4 = data7;
                        $i$f$forEach2 = $i$f$forEach9;
                        it = it8;
                        $i$f$forEach3 = $i$f$forEach8;
                        isCasting4 = isCasting9;
                        $this$forEach$iv = $this$forEach$iv8;
                        $this$forEach$iv2 = playlist2;
                        element$iv = element$iv6;
                        title3 = title5;
                        $this$forEach$iv3 = $this$forEach$iv7;
                    }
                    PrimeVideoProvider primeVideoProvider6 = primeVideoProvider;
                    Continuation<? super Boolean> continuation5 = continuation2;
                    Object $result10 = $result3;
                    Object playlist3 = $this$forEach$iv2;
                    Function1<? super ExtractorLink, Unit> function115 = function18;
                    item2 = item;
                    C00141 c001417 = c001413;
                    tracks = item2.getTracks();
                    if (tracks == null) {
                        Iterable $this$filter$iv = tracks;
                        int $i$f$filter = 0;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            Iterable $this$filter$iv2 = $this$filter$iv;
                            Function1<? super ExtractorLink, Unit> function116 = function115;
                            int $i$f$filter2 = $i$f$filter;
                            if (Intrinsics.areEqual(((Tracks) element$iv$iv).getKind(), "captions")) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv2;
                            $i$f$filter = $i$f$filter2;
                            function115 = function116;
                        }
                        Function1<? super ExtractorLink, Unit> function117 = function115;
                        Iterable $this$map$iv = (List) destination$iv$iv3;
                        $i$f$map = 0;
                        continuation3 = continuation5;
                        $this$mapTo$iv$iv = $this$map$iv;
                        $this$forEach$iv4 = $this$forEach$iv;
                        id5 = id4;
                        $i$f$forEach4 = $i$f$forEach3;
                        isCasting5 = isCasting4;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $i$f$mapTo = 0;
                        it3 = $this$map$iv.iterator();
                        i = $i$f$forEach2;
                        function19 = function117;
                        c001414 = c001417;
                        obj4 = obj3;
                        function110 = function17;
                        $result4 = $result10;
                        $result5 = playlist3;
                        $this$mapTo$iv$iv2 = $this$map$iv;
                        primeVideoProvider2 = primeVideoProvider6;
                        if (it3.hasNext()) {
                            Object item$iv$iv2 = it3.next();
                            Tracks track = (Tracks) item$iv$iv2;
                            String title6 = title3;
                            Object $result11 = $result4;
                            String strValueOf = String.valueOf(track.getLabel());
                            String data8 = data4;
                            String data9 = ExtractorApiKt.httpsify(StringsKt.replace$default(String.valueOf(track.getFile()), "\\", "", false, 4, (Object) null));
                            Object obj5 = obj4;
                            PrimeVideoProvider$loadLinks$2$3$1 primeVideoProvider$loadLinks$2$3$1 = new PrimeVideoProvider$loadLinks$2$3$1(primeVideoProvider2, null);
                            c001414.L$0 = SpillingKt.nullOutSpilledVariable(data8);
                            c001414.L$1 = function110;
                            c001414.L$2 = function19;
                            c001414.L$3 = SpillingKt.nullOutSpilledVariable(title6);
                            c001414.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                            c001414.L$5 = SpillingKt.nullOutSpilledVariable($result5);
                            c001414.L$6 = SpillingKt.nullOutSpilledVariable($this$forEach$iv4);
                            c001414.L$7 = it;
                            c001414.L$8 = SpillingKt.nullOutSpilledVariable(element$iv);
                            c001414.L$9 = SpillingKt.nullOutSpilledVariable(item2);
                            c001414.L$10 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv2);
                            c001414.L$11 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                            c001414.L$12 = destination$iv$iv;
                            c001414.L$13 = it3;
                            c001414.L$14 = SpillingKt.nullOutSpilledVariable(item$iv$iv2);
                            c001414.L$15 = SpillingKt.nullOutSpilledVariable(track);
                            c001414.L$16 = destination$iv$iv;
                            c001414.L$17 = function110;
                            c001414.Z$0 = isCasting5;
                            c001414.I$0 = $i$f$forEach4;
                            c001414.I$1 = i;
                            c001414.I$2 = $i$f$map;
                            c001414.I$3 = $i$f$mapTo;
                            c001414.I$4 = 0;
                            c001414.label = 4;
                            Object objNewSubtitleFile = MainAPIKt.newSubtitleFile(strValueOf, data9, primeVideoProvider$loadLinks$2$3$1, c001414);
                            if (objNewSubtitleFile == obj5) {
                                return obj5;
                            }
                            $this$forEach$iv5 = $this$forEach$iv4;
                            isCasting6 = isCasting5;
                            element$iv2 = element$iv;
                            id6 = id5;
                            item3 = item2;
                            $i$f$map2 = $i$f$map;
                            collection = destination$iv$iv;
                            element$iv3 = obj5;
                            it4 = it3;
                            $i$f$mapTo2 = $i$f$mapTo;
                            $result6 = $result11;
                            data5 = data8;
                            $result7 = $result5;
                            $i$f$forEach5 = $i$f$forEach4;
                            c001415 = c001414;
                            $result8 = objNewSubtitleFile;
                            data6 = title6;
                            item$iv$iv = $this$mapTo$iv$iv2;
                            $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            i2 = i;
                            it5 = it;
                            primeVideoProvider3 = primeVideoProvider2;
                            function111 = function110;
                            destination$iv$iv2 = collection;
                            function111.invoke($result8);
                            collection.add(Unit.INSTANCE);
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                            primeVideoProvider2 = primeVideoProvider3;
                            c001414 = c001415;
                            $i$f$map = $i$f$map2;
                            i = i2;
                            $i$f$forEach4 = $i$f$forEach5;
                            isCasting5 = isCasting6;
                            destination$iv$iv = destination$iv$iv2;
                            $result4 = $result6;
                            data4 = data5;
                            obj4 = element$iv3;
                            it3 = it4;
                            $this$mapTo$iv$iv2 = item$iv$iv;
                            $i$f$mapTo = $i$f$mapTo2;
                            it = it5;
                            $this$forEach$iv4 = $this$forEach$iv5;
                            $result5 = $result7;
                            title3 = data6;
                            element$iv = element$iv2;
                            id5 = id6;
                            item2 = item3;
                            if (it3.hasNext()) {
                                Object $result12 = $result4;
                                continuation2 = continuation3;
                                $i$f$forEach3 = $i$f$forEach4;
                                isCasting8 = isCasting5;
                                function17 = function110;
                                obj3 = obj4;
                                id4 = id5;
                                $result3 = $result12;
                                data4 = data4;
                                $this$forEach$iv = $this$forEach$iv4;
                                function15 = function19;
                                c001412 = c001414;
                                $this$forEach$iv2 = $result5;
                                $i$f$forEach6 = $i$f$forEach3;
                                primeVideoProvider4 = primeVideoProvider2;
                                if (!it.hasNext()) {
                                    return Boxing.boxBoolean(z);
                                }
                            }
                        }
                    } else {
                        $this$forEach$iv2 = playlist3;
                        continuation2 = continuation5;
                        $result3 = $result10;
                        isCasting8 = isCasting4;
                        primeVideoProvider2 = primeVideoProvider6;
                        function15 = function115;
                        c001412 = c001417;
                        $i$f$forEach6 = $i$f$forEach3;
                        primeVideoProvider4 = primeVideoProvider2;
                        if (!it.hasNext()) {
                        }
                    }
                }
                break;
            case 1:
                boolean isCasting10 = c00141.Z$0;
                String str4 = (String) c00141.L$8;
                Map<String, String> map3 = (Map) c00141.L$7;
                String str5 = (String) c00141.L$6;
                Requests requests2 = (Requests) c00141.L$5;
                String id8 = (String) c00141.L$4;
                String title7 = (String) c00141.L$3;
                Function1<? super ExtractorLink, Unit> function118 = (Function1) c00141.L$2;
                Function1<? super SubtitleFile, Unit> function119 = (Function1) c00141.L$1;
                String data10 = (String) c00141.L$0;
                ResultKt.throwOnFailure($result8);
                obj = coroutine_suspended;
                str = str5;
                function14 = function118;
                cookie = $result8;
                id2 = id8;
                title = title7;
                $result = cookie;
                id = str4;
                requests = requests2;
                isCasting2 = isCasting10;
                map = map3;
                function13 = function119;
                data2 = data10;
                c00141.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00141.L$1 = function13;
                c00141.L$2 = function14;
                c00141.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00141.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00141.L$5 = null;
                c00141.L$6 = null;
                c00141.L$7 = null;
                c00141.L$8 = null;
                c00141.Z$0 = isCasting2;
                c00141.label = 2;
                Function1<? super SubtitleFile, Unit> function1122 = function13;
                boolean isCasting72 = isCasting2;
                $result2 = $result;
                z = true;
                function15 = function14;
                c001412 = c00141;
                obj2 = obj;
                $result8 = Requests.get$default(requests, str, map, id, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c001412, 4072, (Object) null);
                if ($result8 != obj2) {
                }
                break;
            case 2:
                isCasting3 = c00141.Z$0;
                id3 = (String) c00141.L$4;
                title2 = (String) c00141.L$3;
                Function1<? super ExtractorLink, Unit> function120 = (Function1) c00141.L$2;
                function16 = (Function1) c00141.L$1;
                data3 = (String) c00141.L$0;
                ResultKt.throwOnFailure($result8);
                c001412 = c00141;
                $result2 = $result8;
                obj2 = coroutine_suspended;
                function15 = function120;
                z = true;
                NiceResponse this_$iv2 = (NiceResponse) $result8;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                Object playlist4 = (PlayList) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PlayList.class));
                Iterable $this$forEach$iv62 = (Iterable) playlist4;
                PrimeVideoProvider primeVideoProvider42 = this;
                int $i$f$forEach62 = 0;
                it = $this$forEach$iv62.iterator();
                function17 = function16;
                data4 = data3;
                id4 = id3;
                title3 = title2;
                obj3 = obj2;
                $this$forEach$iv = $this$forEach$iv62;
                boolean isCasting82 = isCasting3;
                $this$forEach$iv2 = playlist4;
                $result3 = $result2;
                continuation2 = continuation;
                if (!it.hasNext()) {
                }
                break;
            case 3:
                int i3 = c00141.I$3;
                int $i$f$forEach10 = c00141.I$2;
                int i4 = c00141.I$1;
                int $i$f$forEach11 = c00141.I$0;
                boolean isCasting11 = c00141.Z$0;
                Function1 function121 = (Function1) c00141.L$14;
                Object obj6 = c00141.L$12;
                Iterator it9 = (Iterator) c00141.L$11;
                Iterable $this$forEach$iv9 = (Iterable) c00141.L$10;
                PlayListItem item6 = (PlayListItem) c00141.L$9;
                Object element$iv7 = c00141.L$8;
                Iterator<PlayListItem> it10 = (Iterator) c00141.L$7;
                Iterable $this$forEach$iv10 = (Iterable) c00141.L$6;
                Object playlist5 = (PlayList) c00141.L$5;
                String id9 = (String) c00141.L$4;
                String title8 = (String) c00141.L$3;
                Function1<? super ExtractorLink, Unit> function122 = (Function1) c00141.L$2;
                Function1<? super SubtitleFile, Unit> function123 = (Function1) c00141.L$1;
                String data11 = (String) c00141.L$0;
                ResultKt.throwOnFailure($result8);
                function18 = function122;
                c001413 = c00141;
                item = item6;
                id4 = id9;
                z = true;
                obj3 = coroutine_suspended;
                function121.invoke($result8);
                primeVideoProvider = this;
                continuation2 = continuation;
                $result3 = $result8;
                $i$f$forEach = $i$f$forEach10;
                function17 = function123;
                it2 = it9;
                data4 = data11;
                $i$f$forEach2 = i4;
                it = it10;
                $i$f$forEach3 = $i$f$forEach11;
                isCasting4 = isCasting11;
                $this$forEach$iv = $this$forEach$iv10;
                $this$forEach$iv2 = playlist5;
                element$iv = element$iv7;
                title3 = title8;
                $this$forEach$iv3 = $this$forEach$iv9;
                while (it2.hasNext()) {
                }
                PrimeVideoProvider primeVideoProvider62 = primeVideoProvider;
                Continuation<? super Boolean> continuation52 = continuation2;
                Object $result102 = $result3;
                Object playlist32 = $this$forEach$iv2;
                Function1<? super ExtractorLink, Unit> function1152 = function18;
                item2 = item;
                C00141 c0014172 = c001413;
                tracks = item2.getTracks();
                if (tracks == null) {
                }
                break;
            case 4:
                int i5 = c00141.I$4;
                int $i$f$mapTo3 = c00141.I$3;
                $i$f$map2 = c00141.I$2;
                i2 = c00141.I$1;
                $i$f$forEach5 = c00141.I$0;
                isCasting6 = c00141.Z$0;
                Function1<? super SubtitleFile, Unit> function124 = (Function1) c00141.L$17;
                Collection collection2 = (Collection) c00141.L$16;
                Object obj7 = c00141.L$14;
                Iterator it11 = (Iterator) c00141.L$13;
                Collection destination$iv$iv4 = (Collection) c00141.L$12;
                Iterable $this$mapTo$iv$iv4 = (Iterable) c00141.L$11;
                item$iv$iv = (Iterable) c00141.L$10;
                PlayListItem item7 = (PlayListItem) c00141.L$9;
                Object element$iv8 = c00141.L$8;
                it5 = (Iterator) c00141.L$7;
                $this$forEach$iv5 = (Iterable) c00141.L$6;
                $result7 = (PlayList) c00141.L$5;
                String id10 = (String) c00141.L$4;
                data6 = (String) c00141.L$3;
                Function1<? super ExtractorLink, Unit> function125 = (Function1) c00141.L$2;
                Function1<? super SubtitleFile, Unit> function126 = (Function1) c00141.L$1;
                String data12 = (String) c00141.L$0;
                ResultKt.throwOnFailure($result8);
                continuation3 = continuation;
                element$iv3 = coroutine_suspended;
                it4 = it11;
                item3 = item7;
                element$iv2 = element$iv8;
                id6 = id10;
                z = true;
                function110 = function126;
                function19 = function125;
                $i$f$mapTo2 = $i$f$mapTo3;
                data5 = data12;
                c001415 = c00141;
                collection = collection2;
                primeVideoProvider3 = this;
                $result6 = $result8;
                function111 = function124;
                destination$iv$iv2 = destination$iv$iv4;
                $this$mapTo$iv$iv3 = $this$mapTo$iv$iv4;
                function111.invoke($result8);
                collection.add(Unit.INSTANCE);
                $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                primeVideoProvider2 = primeVideoProvider3;
                c001414 = c001415;
                $i$f$map = $i$f$map2;
                i = i2;
                $i$f$forEach4 = $i$f$forEach5;
                isCasting5 = isCasting6;
                destination$iv$iv = destination$iv$iv2;
                $result4 = $result6;
                data4 = data5;
                obj4 = element$iv3;
                it3 = it4;
                $this$mapTo$iv$iv2 = item$iv$iv;
                $i$f$mapTo = $i$f$mapTo2;
                it = it5;
                $this$forEach$iv4 = $this$forEach$iv5;
                $result5 = $result7;
                title3 = data6;
                element$iv = element$iv2;
                id5 = id6;
                item2 = item3;
                if (it3.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cloudstreamplugins/PrimeVideoProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Id {

        @NotNull
        private final String id;

        public static /* synthetic */ Id copy$default(Id id, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = id.id;
            }
            return id.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Id copy(@NotNull String id) {
            return new Id(id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Id) && Intrinsics.areEqual(this.id, ((Id) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "Id(id=" + this.id + ')';
        }

        public Id(@NotNull String id) {
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cloudstreamplugins/PrimeVideoProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String id;

        @NotNull
        private final String title;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.title;
            }
            if ((i & 2) != 0) {
                str2 = loadData.id;
            }
            return loadData.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final LoadData copy(@NotNull String title, @NotNull String id) {
            return new LoadData(title, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.id, loadData.id);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(title=" + this.title + ", id=" + this.id + ')';
        }

        public LoadData(@NotNull String title, @NotNull String id) {
            this.title = title;
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: PrimeVideoProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cloudstreamplugins/PrimeVideoProvider$Cookie;", "", "cookie", "", "<init>", "(Ljava/lang/String;)V", "getCookie", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Cookie {

        @NotNull
        private final String cookie;

        public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cookie.cookie;
            }
            return cookie.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCookie() {
            return this.cookie;
        }

        @NotNull
        public final Cookie copy(@NotNull String cookie) {
            return new Cookie(cookie);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Cookie) && Intrinsics.areEqual(this.cookie, ((Cookie) other).cookie);
        }

        public int hashCode() {
            return this.cookie.hashCode();
        }

        @NotNull
        public String toString() {
            return "Cookie(cookie=" + this.cookie + ')';
        }

        public Cookie(@NotNull String cookie) {
            this.cookie = cookie;
        }

        @NotNull
        public final String getCookie() {
            return this.cookie;
        }
    }
}
