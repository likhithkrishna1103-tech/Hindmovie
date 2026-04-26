package com.horis.cloudstreamplugins;

import com.horis.cloudstreamplugins.entities.EpisodesData;
import com.horis.cloudstreamplugins.entities.PlayList;
import com.horis.cloudstreamplugins.entities.PlayListItem;
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
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: JioHotstarProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u0001:\u0003DEFB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001bH\u0082@¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\f\u0010%\u001a\u00020&*\u00020'H\u0002J\u000e\u0010(\u001a\u0004\u0018\u00010)*\u00020'H\u0002J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+2\u0006\u0010,\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010-J4\u00101\u001a\b\u0012\u0004\u0012\u0002020+2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u00106JF\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00172\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0;2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020=0;H\u0096@¢\u0006\u0002\u0010@J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020?H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/horis/cloudstreamplugins/JioHotstarProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "newUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "headers", "", "getCookie", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getEpisodes", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "Companion", "Id", "LoadData", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJioHotstarProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JioHotstarProvider.kt\ncom/horis/cloudstreamplugins/JioHotstarProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 Utils.kt\ncom/horis/cloudstreamplugins/UtilsKt\n*L\n1#1,267:1\n1586#2:268\n1661#2,3:269\n1642#2,10:272\n1915#2:282\n1916#2:284\n1652#2:285\n1586#2:287\n1661#2,3:288\n1586#2:293\n1661#2,3:294\n1586#2:297\n1661#2,3:298\n1586#2:301\n1661#2,3:302\n777#2:305\n873#2,2:306\n1586#2:308\n1661#2,3:309\n1661#2,3:312\n1661#2,3:316\n1915#2:321\n1915#2,2:322\n777#2:324\n873#2,2:325\n1586#2:327\n1661#2,3:328\n1916#2:331\n1#3:283\n68#4:286\n68#4:292\n68#4:315\n68#4:320\n51#5:291\n51#5:319\n*S KotlinDebug\n*F\n+ 1 JioHotstarProvider.kt\ncom/horis/cloudstreamplugins/JioHotstarProvider\n*L\n58#1:268\n58#1:269,3\n66#1:272,10\n66#1:282\n66#1:284\n66#1:285\n84#1:287\n84#1:288,3\n104#1:293\n104#1:294,3\n105#1:297\n105#1:298,3\n111#1:301\n111#1:302,3\n112#1:305\n112#1:306,2\n117#1:308\n117#1:309,3\n129#1:312,3\n182#1:316,3\n211#1:321\n212#1:322,2\n226#1:324\n226#1:325,2\n226#1:327\n226#1:328,3\n211#1:331\n66#1:283\n82#1:286\n99#1:292\n181#1:315\n209#1:320\n93#1:291\n203#1:319\n*E\n"})
public final class JioHotstarProvider extends MainAPI {

    @NotNull
    private static String cookie_value = "";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private String lang = "en";

    @NotNull
    private String mainUrl = "https://net22.cc";

    @NotNull
    private String newUrl = "https://net52.cc";

    @NotNull
    private String name = "JioHotstar";
    private final boolean hasMainPage = true;

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$getCookie$1, reason: invalid class name */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider", f = "JioHotstarProvider.kt", i = {}, l = {43}, m = "getCookie", n = {}, nl = {46}, s = {}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JioHotstarProvider.this.getCookie((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$getEpisodes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider", f = "JioHotstarProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {170, 180, 176}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "page", "title", "eid", "sid", "episodes", "cookies", "page", "pg", "title", "eid", "sid", "episodes", "cookies", "page", "pg"}, nl = {171, 176, 181}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JioHotstarProvider.this.getEpisodes(null, null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$getMainPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider", f = "JioHotstarProvider.kt", i = {0, 0, 1, 1}, l = {55, 53}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {56, 57}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JioHotstarProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider", f = "JioHotstarProvider.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {98, 94, 140, 143, 150}, m = "load", n = {"url", "id", "url", "id", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {94, 99, 143, 148, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JioHotstarProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider", f = "JioHotstarProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {208, 204, 214, 228}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "title", "id", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "playlist", "$this$forEach$iv", "element$iv", "item", "$this$forEach$iv", "element$iv", "it", "isCasting", "$i$f$forEach", "$i$a$-forEach-JioHotstarProvider$loadLinks$2", "$i$f$forEach", "$i$a$-forEach-JioHotstarProvider$loadLinks$2$1", "data", "subtitleCallback", "callback", "title", "id", "playlist", "$this$forEach$iv", "element$iv", "item", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "track", "isCasting", "$i$f$forEach", "$i$a$-forEach-JioHotstarProvider$loadLinks$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-JioHotstarProvider$loadLinks$2$3"}, nl = {204, 209, 213, 227}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$12", "L$13", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JioHotstarProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider", f = "JioHotstarProvider.kt", i = {0, 0, 1, 1}, l = {82, 82}, m = "search", n = {"query", "url", "query", "url"}, nl = {82, 268}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JioHotstarProvider.this.search(null, (Continuation) this);
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
                if (cookie_value.length() == 0) {
                    String str = this.newUrl;
                    anonymousClass1.label = 1;
                    objBypass = UtilsKt.bypass(str, anonymousClass1);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cookie_value = (String) objBypass;
                }
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", cookie_value), TuplesKt.to("ott", "hs"), TuplesKt.to("hd", "on")});
            case 1:
                ResultKt.throwOnFailure($result);
                objBypass = $result;
                cookie_value = (String) objBypass;
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", cookie_value), TuplesKt.to("ott", "hs"), TuplesKt.to("hd", "on")});
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011b A[LOOP:0: B:23:0x0115->B:25:0x011b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00011 c00011;
        Requests app;
        String str;
        int page2;
        Object cookie;
        MainPageRequest request2;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                app = UtilsKt.getApp();
                str = getMainUrl() + "/mobile/home";
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00011.L$1 = app;
                c00011.L$2 = str;
                page2 = page;
                c00011.I$0 = page2;
                c00011.label = 1;
                cookie = getCookie(c00011);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                String str2 = getMainUrl() + "/home";
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = null;
                c00011.L$2 = null;
                c00011.I$0 = page2;
                c00011.label = 2;
                $result = Requests.get$default(app, str, (Map) null, str2, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4074, (Object) null);
                if ($result != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv = document.select(".tray-container, #top10");
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it));
                }
                List items = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items, Boxing.boxBoolean(false));
            case 1:
                page2 = c00011.I$0;
                str = (String) c00011.L$2;
                app = (Requests) c00011.L$1;
                MainPageRequest request3 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request3;
                cookie = $result;
                String str22 = getMainUrl() + "/home";
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = null;
                c00011.L$2 = null;
                c00011.I$0 = page2;
                c00011.label = 2;
                $result = Requests.get$default(app, str, (Map) null, str22, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4074, (Object) null);
                if ($result != coroutine_suspended) {
                }
                break;
            case 2:
                int i = c00011.I$0;
                ResultKt.throwOnFailure($result);
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv2 = document2.select(".tray-container, #top10");
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r10.hasNext()) {
                }
                List items2 = (List) destination$iv$iv2;
                return MainAPIKt.newHomePageResponse(items2, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList) {
        String name = $this$toHomePageList.select("h2, span").text();
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("article, .top10-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        final String id;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a");
        if (elementSelectFirst == null || (id = elementSelectFirst.attr("data-post")) == null) {
            id = $this$toSearchResult.attr("data-post");
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return JioHotstarProvider.toSearchResult$lambda$0(id, this, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $id, JioHotstarProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + $id + ".jpg");
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
        C00051 c00051;
        Requests app;
        Object cookie;
        String url;
        String query2;
        String str;
        Object obj;
        String str2;
        Object obj2;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        }
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url2 = getMainUrl() + "/mobile/hs/search.php?s=" + query + "&t=" + APIHolder.INSTANCE.getUnixTime();
                app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/home";
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00051.L$2 = app;
                c00051.L$3 = url2;
                c00051.L$4 = str3;
                c00051.label = 1;
                cookie = getCookie(c00051);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url = url2;
                query2 = query;
                str = str3;
                obj = coroutine_suspended;
                str2 = url;
                Map map = (Map) cookie;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(url);
                obj2 = obj;
                c00051.L$2 = null;
                c00051.L$3 = null;
                c00051.L$4 = null;
                c00051.label = 2;
                $result = Requests.get$default(app, str2, (Map) null, str, (Map) null, map, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4074, (Object) null);
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
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getT(), AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj3) {
                            return JioHotstarProvider.search$lambda$0$0(it, this, (AnimeSearchResponse) obj3);
                        }
                    }, 12, (Object) null));
                }
                return (List) destination$iv$iv;
            case 1:
                String str4 = (String) c00051.L$4;
                String str5 = (String) c00051.L$3;
                app = (Requests) c00051.L$2;
                String url3 = (String) c00051.L$1;
                String query3 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str2 = str5;
                str = str4;
                url = url3;
                query2 = query3;
                cookie = $result;
                Map map2 = (Map) cookie;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(url);
                obj2 = obj;
                c00051.L$2 = null;
                c00051.L$3 = null;
                c00051.L$4 = null;
                c00051.label = 2;
                $result = Requests.get$default(app, str2, (Map) null, str, (Map) null, map2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4074, (Object) null);
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
    public static final Unit search$lambda$0$0(SearchResult $it, JioHotstarProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + $it.getId() + ".jpg");
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
        C00031 c00031;
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
        C00031 c000312;
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
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        }
        C00031 c000313 = c00031;
        Object $result = c000313.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c000313.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = ((Id) UtilsKt.getJSONParser().parse(url, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/mobile/hs/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = this.headers;
                String str4 = getMainUrl() + "/home";
                c000313.L$0 = url;
                c000313.L$1 = id;
                c000313.L$2 = app;
                c000313.L$3 = str3;
                c000313.L$4 = map2;
                c000313.L$5 = str4;
                c000313.label = 1;
                Object cookie = getCookie(c000313);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = map2;
                obj = cookie;
                str = str4;
                id2 = url;
                str2 = str3;
                requests = app;
                c000313.L$0 = id2;
                c000313.L$1 = id;
                c000313.L$2 = null;
                c000313.L$3 = null;
                c000313.L$4 = null;
                c000313.L$5 = null;
                c000313.label = 2;
                obj2 = Requests.get$default(requests, str2, map, str, (Map) null, (Map) obj, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000313, 4072, (Object) null);
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
                        destination$iv$iv6.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return JioHotstarProvider.load$lambda$4$0(it, this, (AnimeSearchResponse) obj5);
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
                    Boxing.boxBoolean(episodes6.add(MainAPIKt.newEpisode(this, new LoadData(title3, id3), new Function1() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj5) {
                            return JioHotstarProvider.load$lambda$5(data, (Episode) obj5);
                        }
                    })));
                    c000312 = c000313;
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
                    c000312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c000312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                    c000312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c000312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                    c000312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                    c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c000312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                    c000312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                    c000312.L$8 = SpillingKt.nullOutSpilledVariable(rating5);
                    c000312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                    c000312.L$10 = SpillingKt.nullOutSpilledVariable(type);
                    c000312.I$0 = runTime2;
                    c000312.label = 5;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type, episodes4, anonymousClass5, c000312);
                    return $result != obj4 ? obj4 : $result;
                }
                Iterable $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                ArrayList destination$iv = episodes6;
                int $i$f$mapTo = 0;
                for (Iterator it2 = $this$mapTo$iv.iterator(); it2.hasNext(); it2 = it2) {
                    Object item$iv = it2.next();
                    Iterable $this$mapTo$iv2 = $this$mapTo$iv;
                    final com.horis.cloudstreamplugins.entities.Episode it3 = (com.horis.cloudstreamplugins.entities.Episode) item$iv;
                    destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title3, it3.getId()), new Function1() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj5) {
                            return JioHotstarProvider.load$lambda$6$0(it3, (Episode) obj5);
                        }
                    }));
                    $this$mapTo$iv = $this$mapTo$iv2;
                    $i$f$mapTo = $i$f$mapTo;
                }
                Integer nextPageShow = data.getNextPageShow();
                if (nextPageShow != null && nextPageShow.intValue() == 1) {
                    String title4 = data.getNextPageSeason();
                    Intrinsics.checkNotNull(title4);
                    c000313.L$0 = id2;
                    c000313.L$1 = id3;
                    c000313.L$2 = data;
                    c000313.L$3 = episodes6;
                    c000313.L$4 = title3;
                    c000313.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c000313.L$6 = cast6;
                    c000313.L$7 = genre2;
                    c000313.L$8 = rating;
                    c000313.L$9 = suggest2;
                    c000313.L$10 = episodes6;
                    c000313.I$0 = runTime;
                    c000313.label = 3;
                    String url5 = id2;
                    episodes = getEpisodes(title3, url5, title4, 2, c000313);
                    c000312 = c000313;
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
                        c000312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c000312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                        c000312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c000312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c000312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                        c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                        c000312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                        c000312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                        c000312.L$8 = SpillingKt.nullOutSpilledVariable(rating52);
                        c000312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                        c000312.L$10 = SpillingKt.nullOutSpilledVariable(type2);
                        c000312.I$0 = runTime2;
                        c000312.label = 5;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type2, episodes4, anonymousClass52, c000312);
                        if ($result != obj4) {
                        }
                    } else {
                        List castList4 = genre4;
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(episodes3, this, title, rating3, null);
                        c000312.L$0 = rating3;
                        c000312.L$1 = id4;
                        c000312.L$2 = data3;
                        c000312.L$3 = episodes3;
                        c000312.L$4 = title;
                        c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList4);
                        c000312.L$6 = cast3;
                        c000312.L$7 = genre2;
                        c000312.L$8 = rating;
                        c000312.L$9 = suggest2;
                        c000312.L$10 = null;
                        c000312.I$0 = runTime;
                        c000312.label = 4;
                        objAmap = ParCollectionsKt.amap(listDropLast, anonymousClass4, c000312);
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
                        c000312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c000312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                        c000312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c000312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c000312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                        c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                        c000312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                        c000312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                        c000312.L$8 = SpillingKt.nullOutSpilledVariable(rating522);
                        c000312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                        c000312.L$10 = SpillingKt.nullOutSpilledVariable(type22);
                        c000312.I$0 = runTime2;
                        c000312.label = 5;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type22, episodes4, anonymousClass522, c000312);
                        if ($result != obj4) {
                        }
                    }
                } else {
                    String url6 = id2;
                    String title5 = title3;
                    c000312 = c000313;
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
                    c000312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c000312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                    c000312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c000312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                    c000312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                    c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c000312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                    c000312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                    c000312.L$8 = SpillingKt.nullOutSpilledVariable(rating5222);
                    c000312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                    c000312.L$10 = SpillingKt.nullOutSpilledVariable(type222);
                    c000312.I$0 = runTime2;
                    c000312.label = 5;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type222, episodes4, anonymousClass5222, c000312);
                    if ($result != obj4) {
                    }
                }
                break;
            case 1:
                String str7 = (String) c000313.L$5;
                Map<String, String> map3 = (Map) c000313.L$4;
                String str8 = (String) c000313.L$3;
                Requests requests2 = (Requests) c000313.L$2;
                id = (String) c000313.L$1;
                String url7 = (String) c000313.L$0;
                ResultKt.throwOnFailure($result);
                map = map3;
                obj = $result;
                str = str7;
                str2 = str8;
                id2 = url7;
                requests = requests2;
                c000313.L$0 = id2;
                c000313.L$1 = id;
                c000313.L$2 = null;
                c000313.L$3 = null;
                c000313.L$4 = null;
                c000313.L$5 = null;
                c000313.label = 2;
                obj2 = Requests.get$default(requests, str2, map, str, (Map) null, (Map) obj, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000313, 4072, (Object) null);
                if (obj2 != coroutine_suspended) {
                }
                break;
            case 2:
                String id8 = (String) c000313.L$1;
                String url8 = (String) c000313.L$0;
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
                int runTime3 = c000313.I$0;
                arrayList2 = (ArrayList) c000313.L$10;
                List suggest4 = (List) c000313.L$9;
                rating2 = (String) c000313.L$8;
                genre3 = (List) c000313.L$7;
                cast2 = (List) c000313.L$6;
                List castList5 = (List) c000313.L$5;
                String title6 = (String) c000313.L$4;
                ArrayList episodes7 = (ArrayList) c000313.L$3;
                data2 = (PostData) c000313.L$2;
                id3 = (String) c000313.L$1;
                url2 = (String) c000313.L$0;
                ResultKt.throwOnFailure($result);
                castList = castList5;
                url3 = title6;
                runTime = runTime3;
                c000312 = c000313;
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
                c000312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c000312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c000312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c000312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                c000312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                c000312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                c000312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                c000312.L$8 = SpillingKt.nullOutSpilledVariable(rating52222);
                c000312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                c000312.L$10 = SpillingKt.nullOutSpilledVariable(type2222);
                c000312.I$0 = runTime2;
                c000312.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type2222, episodes4, anonymousClass52222, c000312);
                if ($result != obj4) {
                }
                break;
            case 4:
                int runTime4 = c000313.I$0;
                suggest3 = (List) c000313.L$9;
                title2 = (String) c000313.L$8;
                genre5 = (List) c000313.L$7;
                cast3 = (List) c000313.L$6;
                castList2 = (List) c000313.L$5;
                id6 = (String) c000313.L$4;
                ArrayList episodes8 = (ArrayList) c000313.L$3;
                PostData data5 = (PostData) c000313.L$2;
                String id9 = (String) c000313.L$1;
                url4 = (String) c000313.L$0;
                ResultKt.throwOnFailure($result);
                episodes5 = episodes8;
                runTime = runTime4;
                objAmap = $result;
                data3 = data5;
                c000312 = c000313;
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
                c000312.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c000312.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c000312.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c000312.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                c000312.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                c000312.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                c000312.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                c000312.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                c000312.L$8 = SpillingKt.nullOutSpilledVariable(rating522222);
                c000312.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                c000312.L$10 = SpillingKt.nullOutSpilledVariable(type22222);
                c000312.I$0 = runTime2;
                c000312.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type22222, episodes4, anonymousClass522222, c000312);
                if ($result != obj4) {
                }
                break;
            case 5:
                int i = c000313.I$0;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Suggest $it, JioHotstarProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + $it.getId() + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
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
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/hsepimg/150/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$load$4, reason: invalid class name */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/horis/cloudstreamplugins/entities/Season;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider$load$4", f = "JioHotstarProvider.kt", i = {0}, l = {144}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<Season, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ String $title;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ JioHotstarProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ArrayList<Episode> arrayList, JioHotstarProvider jioHotstarProvider, String str, String str2, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$episodes = arrayList;
            this.this$0 = jioHotstarProvider;
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

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.JioHotstarProvider$load$5, reason: invalid class name */
    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.JioHotstarProvider$load$5", f = "JioHotstarProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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
        final /* synthetic */ JioHotstarProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str, JioHotstarProvider jioHotstarProvider, PostData postData, List<String> list, List<ActorData> list2, String str2, int i, List<AnimeSearchResponse> list3, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = jioHotstarProvider;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl("https://imgcdn.kim/hs/h/" + this.$id + ".jpg");
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
    /* JADX WARN: Removed duplicated region for block: B:22:0x01a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0297 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x01fc -> B:28:0x0206). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getEpisodes(String title, String eid, String sid, int page, Continuation<? super List<Episode>> continuation) throws Exception {
        C00001 c00001;
        char c;
        ArrayList episodes;
        Pair[] pairArr;
        String title2;
        int pg;
        Object obj;
        String title3;
        String eid2;
        String str;
        int i;
        Pair[] pairArr2;
        Map cookies;
        int pg2;
        int page2;
        String str2;
        Map<String, String> map;
        String str3;
        Requests requests;
        Map cookies2;
        ArrayList episodes2;
        String sid2;
        String sid3;
        String eid3;
        JioHotstarProvider jioHotstarProvider;
        Object $result;
        int pg3;
        JioHotstarProvider jioHotstarProvider2;
        Object cookie;
        Iterable episodes3;
        EpisodesData data;
        Continuation<? super List<Episode>> continuation2;
        C00001 c000012;
        Continuation<? super List<Episode>> continuation3 = continuation;
        if (continuation3 instanceof C00001) {
            c00001 = (C00001) continuation3;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation3);
            }
        }
        Object $result2 = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                c = 2;
                ResultKt.throwOnFailure($result2);
                episodes = new ArrayList();
                pairArr = new Pair[3];
                c00001.L$0 = title;
                c00001.L$1 = eid;
                c00001.L$2 = sid;
                c00001.L$3 = episodes;
                c00001.L$4 = pairArr;
                c00001.L$5 = pairArr;
                c00001.L$6 = "t_hash_t";
                c00001.I$0 = page;
                c00001.I$1 = 0;
                c00001.label = 1;
                Object cookie2 = getCookie(c00001);
                if (cookie2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                title2 = eid;
                pg = page;
                obj = cookie2;
                title3 = title;
                eid2 = sid;
                str = "t_hash_t";
                i = 0;
                pairArr2 = pairArr;
                pairArr[i] = TuplesKt.to(str, obj);
                pairArr2[1] = TuplesKt.to("hd", "on");
                pairArr2[c] = TuplesKt.to("ott", "hs");
                cookies = MapsKt.mapOf(pairArr2);
                int pg4 = pg;
                JioHotstarProvider jioHotstarProvider3 = this;
                Requests app = UtilsKt.getApp();
                Continuation<? super List<Episode>> continuation4 = continuation3;
                String str4 = jioHotstarProvider3.getMainUrl() + "/mobile/hs/episodes.php?s=" + eid2 + "&series=" + title2 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg4;
                Map<String, String> map2 = jioHotstarProvider3.headers;
                String str5 = jioHotstarProvider3.getMainUrl() + "/home";
                c00001.L$0 = title3;
                c00001.L$1 = title2;
                c00001.L$2 = eid2;
                c00001.L$3 = episodes;
                c00001.L$4 = SpillingKt.nullOutSpilledVariable(cookies);
                c00001.L$5 = app;
                c00001.L$6 = str4;
                c00001.L$7 = map2;
                c00001.L$8 = str5;
                c00001.I$0 = pg;
                c00001.I$1 = pg4;
                c00001.label = 2;
                cookie = jioHotstarProvider3.getCookie(c00001);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                JioHotstarProvider jioHotstarProvider4 = jioHotstarProvider3;
                page2 = pg;
                jioHotstarProvider = jioHotstarProvider4;
                str3 = str4;
                str2 = str5;
                $result = $result2;
                requests = app;
                map = map2;
                episodes2 = episodes;
                sid2 = eid2;
                sid3 = title2;
                eid3 = title3;
                $result2 = cookie;
                continuation3 = continuation4;
                cookies2 = cookies;
                pg2 = pg4;
                c00001.L$0 = eid3;
                c00001.L$1 = sid3;
                c00001.L$2 = sid2;
                c00001.L$3 = episodes2;
                c00001.L$4 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00001.L$5 = null;
                c00001.L$6 = null;
                c00001.L$7 = null;
                c00001.L$8 = null;
                c00001.I$0 = page2;
                c00001.I$1 = pg2;
                c00001.label = 3;
                C00001 c000013 = c00001;
                $result2 = Requests.get$default(requests, str3, map, str2, (Map) null, (Map) $result2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000013, 4072, (Object) null);
                if ($result2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                JioHotstarProvider jioHotstarProvider5 = jioHotstarProvider;
                pg3 = pg2;
                cookies = cookies2;
                jioHotstarProvider2 = jioHotstarProvider5;
                c00001 = c000013;
                title3 = eid3;
                title2 = sid3;
                eid2 = sid2;
                episodes = episodes2;
                NiceResponse this_$iv = (NiceResponse) $result2;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                Object $result3 = $result;
                EpisodesData data2 = (EpisodesData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(EpisodesData.class));
                episodes3 = data2.getEpisodes();
                if (episodes3 == null) {
                    Iterable $this$mapTo$iv = episodes3;
                    ArrayList destination$iv = episodes;
                    for (Object item$iv : $this$mapTo$iv) {
                        EpisodesData data3 = data2;
                        final com.horis.cloudstreamplugins.entities.Episode it = (com.horis.cloudstreamplugins.entities.Episode) item$iv;
                        destination$iv.add(MainAPIKt.newEpisode(jioHotstarProvider2, new LoadData(title3, it.getId()), new Function1() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                return JioHotstarProvider.getEpisodes$lambda$0$0(it, (Episode) obj2);
                            }
                        }));
                        data2 = data3;
                        continuation3 = continuation3;
                        c00001 = c00001;
                        $this$mapTo$iv = $this$mapTo$iv;
                    }
                    data = data2;
                    continuation2 = continuation3;
                    c000012 = c00001;
                } else {
                    data = data2;
                    continuation2 = continuation3;
                    c000012 = c00001;
                }
                if (data.getNextPageShow() != 0) {
                    return episodes;
                }
                pg4 = pg3 + 1;
                $result2 = $result3;
                continuation3 = continuation2;
                c00001 = c000012;
                pg = page2;
                jioHotstarProvider3 = jioHotstarProvider2;
                Requests app2 = UtilsKt.getApp();
                Continuation<? super List<Episode>> continuation42 = continuation3;
                String str42 = jioHotstarProvider3.getMainUrl() + "/mobile/hs/episodes.php?s=" + eid2 + "&series=" + title2 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg4;
                Map<String, String> map22 = jioHotstarProvider3.headers;
                String str52 = jioHotstarProvider3.getMainUrl() + "/home";
                c00001.L$0 = title3;
                c00001.L$1 = title2;
                c00001.L$2 = eid2;
                c00001.L$3 = episodes;
                c00001.L$4 = SpillingKt.nullOutSpilledVariable(cookies);
                c00001.L$5 = app2;
                c00001.L$6 = str42;
                c00001.L$7 = map22;
                c00001.L$8 = str52;
                c00001.I$0 = pg;
                c00001.I$1 = pg4;
                c00001.label = 2;
                cookie = jioHotstarProvider3.getCookie(c00001);
                if (cookie == coroutine_suspended) {
                }
                break;
            case 1:
                c = 2;
                i = c00001.I$1;
                pg = c00001.I$0;
                str = (String) c00001.L$6;
                pairArr = (Pair[]) c00001.L$5;
                pairArr2 = (Pair[]) c00001.L$4;
                episodes = (ArrayList) c00001.L$3;
                eid2 = (String) c00001.L$2;
                title2 = (String) c00001.L$1;
                title3 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result2);
                obj = $result2;
                pairArr[i] = TuplesKt.to(str, obj);
                pairArr2[1] = TuplesKt.to("hd", "on");
                pairArr2[c] = TuplesKt.to("ott", "hs");
                cookies = MapsKt.mapOf(pairArr2);
                int pg42 = pg;
                JioHotstarProvider jioHotstarProvider32 = this;
                Requests app22 = UtilsKt.getApp();
                Continuation<? super List<Episode>> continuation422 = continuation3;
                String str422 = jioHotstarProvider32.getMainUrl() + "/mobile/hs/episodes.php?s=" + eid2 + "&series=" + title2 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg42;
                Map<String, String> map222 = jioHotstarProvider32.headers;
                String str522 = jioHotstarProvider32.getMainUrl() + "/home";
                c00001.L$0 = title3;
                c00001.L$1 = title2;
                c00001.L$2 = eid2;
                c00001.L$3 = episodes;
                c00001.L$4 = SpillingKt.nullOutSpilledVariable(cookies);
                c00001.L$5 = app22;
                c00001.L$6 = str422;
                c00001.L$7 = map222;
                c00001.L$8 = str522;
                c00001.I$0 = pg;
                c00001.I$1 = pg42;
                c00001.label = 2;
                cookie = jioHotstarProvider32.getCookie(c00001);
                if (cookie == coroutine_suspended) {
                }
                break;
            case 2:
                pg2 = c00001.I$1;
                page2 = c00001.I$0;
                String str6 = (String) c00001.L$8;
                Map<String, String> map3 = (Map) c00001.L$7;
                String str7 = (String) c00001.L$6;
                Requests requests2 = (Requests) c00001.L$5;
                Map cookies3 = (Map) c00001.L$4;
                ArrayList episodes4 = (ArrayList) c00001.L$3;
                String sid4 = (String) c00001.L$2;
                String eid4 = (String) c00001.L$1;
                String title4 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result2);
                str2 = str6;
                map = map3;
                str3 = str7;
                requests = requests2;
                cookies2 = cookies3;
                episodes2 = episodes4;
                sid2 = sid4;
                sid3 = eid4;
                eid3 = title4;
                jioHotstarProvider = this;
                $result = $result2;
                c00001.L$0 = eid3;
                c00001.L$1 = sid3;
                c00001.L$2 = sid2;
                c00001.L$3 = episodes2;
                c00001.L$4 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00001.L$5 = null;
                c00001.L$6 = null;
                c00001.L$7 = null;
                c00001.L$8 = null;
                c00001.I$0 = page2;
                c00001.I$1 = pg2;
                c00001.label = 3;
                C00001 c0000132 = c00001;
                $result2 = Requests.get$default(requests, str3, map, str2, (Map) null, (Map) $result2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0000132, 4072, (Object) null);
                if ($result2 != coroutine_suspended) {
                }
                break;
            case 3:
                int pg5 = c00001.I$1;
                page2 = c00001.I$0;
                Map cookies4 = (Map) c00001.L$4;
                ArrayList episodes5 = (ArrayList) c00001.L$3;
                String sid5 = (String) c00001.L$2;
                String eid5 = (String) c00001.L$1;
                String title5 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result2);
                pg3 = pg5;
                cookies = cookies4;
                jioHotstarProvider2 = this;
                $result = $result2;
                title3 = title5;
                title2 = eid5;
                eid2 = sid5;
                episodes = episodes5;
                NiceResponse this_$iv2 = (NiceResponse) $result2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                Object $result32 = $result;
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
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/hsepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x02b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0471 -> B:45:0x04af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x055e -> B:51:0x0584). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x05d3 -> B:54:0x05ea). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function12, @NotNull Continuation<? super Boolean> continuation) throws Exception {
        C00041 c00041;
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
        Function1<? super ExtractorLink, Unit> function15;
        boolean z;
        boolean isCasting3;
        C00041 c000412;
        Object $result2;
        Object obj2;
        String data3;
        String id3;
        String title2;
        Function1<? super SubtitleFile, Unit> function16;
        Iterator<PlayListItem> it;
        Function1<? super SubtitleFile, Unit> function17;
        String data4;
        String id4;
        String title3;
        Object obj3;
        Iterable $this$forEach$iv;
        Continuation<? super Boolean> continuation2;
        Collection $this$forEach$iv2;
        Object $result3;
        Iterable $this$forEach$iv3;
        Function1<? super ExtractorLink, Unit> function18;
        boolean isCasting4;
        PlayListItem item;
        JioHotstarProvider jioHotstarProvider;
        int $i$f$forEach;
        int i;
        int $i$f$forEach2;
        Iterator it2;
        Object element$iv;
        PlayListItem item2;
        JioHotstarProvider jioHotstarProvider2;
        Function1<? super ExtractorLink, Unit> function19;
        Iterable tracks;
        JioHotstarProvider jioHotstarProvider3;
        Iterator it3;
        int $i$f$map;
        Continuation<? super Boolean> continuation3;
        Iterable $this$map$iv;
        int $i$f$map2;
        Iterable $this$forEach$iv4;
        String id5;
        int $i$f$mapTo;
        boolean isCasting5;
        Collection destination$iv$iv;
        Object obj4;
        Function1<? super SubtitleFile, Unit> function110;
        int $i$f$forEach3;
        Object $result4;
        Collection $result5;
        Iterable $this$mapTo$iv$iv;
        C00041 c000413;
        Object element$iv2;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        String id6;
        Object element$iv3;
        PlayListItem item3;
        Iterable $this$forEach$iv5;
        C00041 c000414;
        Iterator<PlayListItem> it4;
        int $i$f$mapTo2;
        boolean isCasting6;
        Function1<? super SubtitleFile, Unit> function111;
        Object obj5;
        int i2;
        Function1<? super ExtractorLink, Unit> function112;
        Collection collection;
        JioHotstarProvider jioHotstarProvider4;
        Iterator it5;
        String data5;
        int $i$f$map3;
        Function1<? super SubtitleFile, Unit> function113;
        String data6;
        Iterable $this$mapTo$iv$iv2;
        Collection destination$iv$iv3;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        }
        Object $result6 = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result6);
                LoadData loadData = (LoadData) UtilsKt.getJSONParser().parse(data, Reflection.getOrCreateKotlinClass(LoadData.class));
                String title4 = loadData.getTitle();
                String id7 = loadData.getId();
                Requests app = UtilsKt.getApp();
                String str2 = this.newUrl + "/mobile/hs/playlist.php?id=" + id7 + "&t=" + title4 + "&tm=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = this.headers;
                id = getMainUrl() + '/';
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function12;
                c00041.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00041.L$4 = SpillingKt.nullOutSpilledVariable(id7);
                c00041.L$5 = app;
                c00041.L$6 = str2;
                c00041.L$7 = map2;
                c00041.L$8 = id;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                cookie = getCookie(c00041);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = $result6;
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
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00041.L$1 = function13;
                c00041.L$2 = function14;
                c00041.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00041.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00041.L$5 = null;
                c00041.L$6 = null;
                c00041.L$7 = null;
                c00041.L$8 = null;
                c00041.Z$0 = isCasting2;
                c00041.label = 2;
                Function1<? super SubtitleFile, Unit> function114 = function13;
                function15 = function14;
                z = true;
                isCasting3 = isCasting2;
                c000412 = c00041;
                $result2 = $result;
                String data7 = data2;
                obj2 = obj;
                $result6 = Requests.get$default(requests, str, map, id, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000412, 4072, (Object) null);
                if ($result6 != obj2) {
                    return obj2;
                }
                data3 = data7;
                id3 = id2;
                title2 = title;
                function16 = function114;
                NiceResponse this_$iv = (NiceResponse) $result6;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                Collection playlist = (PlayList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PlayList.class));
                Collection $this$forEach$iv6 = playlist;
                JioHotstarProvider jioHotstarProvider5 = this;
                int $i$f$forEach4 = 0;
                it = $this$forEach$iv6.iterator();
                function17 = function16;
                data4 = data3;
                id4 = id3;
                title3 = title2;
                obj3 = obj2;
                $this$forEach$iv = $this$forEach$iv6;
                continuation2 = continuation;
                $this$forEach$iv2 = playlist;
                $result3 = $result2;
                c00041 = c000412;
                if (!it.hasNext()) {
                    Object element$iv4 = it.next();
                    PlayListItem item4 = (PlayListItem) element$iv4;
                    Iterable $this$forEach$iv7 = item4.getSources();
                    jioHotstarProvider = jioHotstarProvider5;
                    element$iv = element$iv4;
                    item = item4;
                    i = 0;
                    it2 = $this$forEach$iv7.iterator();
                    function18 = function15;
                    isCasting4 = isCasting3;
                    $i$f$forEach2 = $i$f$forEach4;
                    $this$forEach$iv3 = $this$forEach$iv7;
                    $i$f$forEach = 0;
                    while (it2.hasNext()) {
                        Object element$iv5 = it2.next();
                        Source it6 = (Source) element$iv5;
                        String name = jioHotstarProvider.getName();
                        String label = it6.getLabel();
                        Continuation<? super Boolean> continuation4 = continuation2;
                        Object $result7 = $result3;
                        JioHotstarProvider jioHotstarProvider6 = jioHotstarProvider;
                        Collection playlist2 = $this$forEach$iv2;
                        String str3 = jioHotstarProvider6.newUrl + '/' + it6.getFile();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        JioHotstarProvider$loadLinks$2$1$1 jioHotstarProvider$loadLinks$2$1$1 = new JioHotstarProvider$loadLinks$2$1$1(jioHotstarProvider6, it6, null);
                        c00041.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00041.L$1 = function17;
                        Function1<? super ExtractorLink, Unit> function115 = function18;
                        c00041.L$2 = function115;
                        c00041.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                        c00041.L$4 = SpillingKt.nullOutSpilledVariable(id4);
                        c00041.L$5 = SpillingKt.nullOutSpilledVariable(playlist2);
                        c00041.L$6 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        c00041.L$7 = it;
                        c00041.L$8 = SpillingKt.nullOutSpilledVariable(element$iv);
                        PlayListItem item5 = item;
                        c00041.L$9 = item5;
                        c00041.L$10 = SpillingKt.nullOutSpilledVariable($this$forEach$iv3);
                        Iterator it7 = it2;
                        c00041.L$11 = it7;
                        c00041.L$12 = SpillingKt.nullOutSpilledVariable(element$iv5);
                        c00041.L$13 = SpillingKt.nullOutSpilledVariable(it6);
                        c00041.L$14 = function115;
                        c00041.L$15 = null;
                        c00041.L$16 = null;
                        c00041.L$17 = null;
                        c00041.Z$0 = isCasting4;
                        c00041.I$0 = $i$f$forEach2;
                        c00041.I$1 = i;
                        c00041.I$2 = $i$f$forEach;
                        c00041.I$3 = 0;
                        c00041.label = 3;
                        C00041 c000415 = c00041;
                        int $i$f$forEach5 = $i$f$forEach2;
                        int i3 = i;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, label, str3, extractorLinkType, jioHotstarProvider$loadLinks$2$1$1, c000415);
                        if (objNewExtractorLink == obj3) {
                            return obj3;
                        }
                        function18 = function115;
                        c00041 = c000415;
                        Object element$iv6 = element$iv;
                        item = item5;
                        Iterator<PlayListItem> it8 = it;
                        int $i$f$forEach6 = $i$f$forEach;
                        String data8 = data4;
                        Function1<? super SubtitleFile, Unit> function116 = function17;
                        String title5 = title3;
                        function18.invoke(objNewExtractorLink);
                        jioHotstarProvider = jioHotstarProvider6;
                        continuation2 = continuation4;
                        $result3 = $result7;
                        title3 = title5;
                        function17 = function116;
                        data4 = data8;
                        $i$f$forEach = $i$f$forEach6;
                        it = it8;
                        i = i3;
                        $i$f$forEach2 = $i$f$forEach5;
                        $this$forEach$iv2 = playlist2;
                        it2 = it7;
                        element$iv = element$iv6;
                    }
                    Continuation<? super Boolean> continuation5 = continuation2;
                    C00041 c000416 = c00041;
                    Object $result8 = $result3;
                    int i4 = i;
                    int $i$f$forEach7 = $i$f$forEach2;
                    item2 = item;
                    jioHotstarProvider2 = jioHotstarProvider;
                    Collection playlist3 = $this$forEach$iv2;
                    function19 = function18;
                    tracks = item2.getTracks();
                    if (tracks == null) {
                        Iterable $this$filter$iv = tracks;
                        Collection destination$iv$iv4 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            int i5 = i4;
                            Iterable $this$filter$iv2 = $this$filter$iv;
                            int $i$f$forEach8 = $i$f$forEach7;
                            if (Intrinsics.areEqual(((Tracks) element$iv$iv).getKind(), "captions")) {
                                destination$iv$iv4.add(element$iv$iv);
                            }
                            i4 = i5;
                            $this$filter$iv = $this$filter$iv2;
                            $i$f$forEach7 = $i$f$forEach8;
                        }
                        int i6 = i4;
                        int $i$f$forEach9 = $i$f$forEach7;
                        Iterable $this$map$iv3 = (List) destination$iv$iv4;
                        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        it3 = $this$map$iv3.iterator();
                        $i$f$map = i6;
                        continuation3 = continuation5;
                        $this$map$iv = $this$map$iv3;
                        $i$f$map2 = 0;
                        $this$forEach$iv4 = $this$forEach$iv;
                        id5 = id4;
                        $i$f$mapTo = 0;
                        isCasting5 = isCasting4;
                        destination$iv$iv = destination$iv$iv5;
                        obj4 = obj3;
                        function110 = function17;
                        $i$f$forEach3 = $i$f$forEach9;
                        $result4 = $result8;
                        $result5 = playlist3;
                        $this$mapTo$iv$iv = $this$map$iv3;
                        c000413 = c000416;
                        if (it3.hasNext()) {
                            Object item$iv$iv = it3.next();
                            Tracks track = (Tracks) item$iv$iv;
                            String title6 = title3;
                            element$iv2 = $result4;
                            String strValueOf = String.valueOf(track.getLabel());
                            String data9 = data4;
                            String data10 = ExtractorApiKt.httpsify(StringsKt.replace$default(String.valueOf(track.getFile()), "\\", "", false, 4, (Object) null));
                            Object obj6 = obj4;
                            JioHotstarProvider$loadLinks$2$3$1 jioHotstarProvider$loadLinks$2$3$1 = new JioHotstarProvider$loadLinks$2$3$1(jioHotstarProvider2, null);
                            c000413.L$0 = SpillingKt.nullOutSpilledVariable(data9);
                            c000413.L$1 = function110;
                            c000413.L$2 = function19;
                            c000413.L$3 = SpillingKt.nullOutSpilledVariable(title6);
                            c000413.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                            c000413.L$5 = SpillingKt.nullOutSpilledVariable($result5);
                            c000413.L$6 = SpillingKt.nullOutSpilledVariable($this$forEach$iv4);
                            c000413.L$7 = it;
                            c000413.L$8 = SpillingKt.nullOutSpilledVariable(element$iv);
                            c000413.L$9 = SpillingKt.nullOutSpilledVariable(item2);
                            c000413.L$10 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                            c000413.L$11 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                            c000413.L$12 = destination$iv$iv;
                            c000413.L$13 = it3;
                            c000413.L$14 = SpillingKt.nullOutSpilledVariable(item$iv$iv);
                            c000413.L$15 = SpillingKt.nullOutSpilledVariable(track);
                            c000413.L$16 = destination$iv$iv;
                            c000413.L$17 = function110;
                            c000413.Z$0 = isCasting5;
                            c000413.I$0 = $i$f$forEach3;
                            c000413.I$1 = $i$f$map;
                            c000413.I$2 = $i$f$map2;
                            c000413.I$3 = $i$f$mapTo;
                            c000413.I$4 = 0;
                            c000413.label = 4;
                            Object objNewSubtitleFile = MainAPIKt.newSubtitleFile(strValueOf, data10, jioHotstarProvider$loadLinks$2$3$1, c000413);
                            if (objNewSubtitleFile == obj6) {
                                return obj6;
                            }
                            $this$map$iv2 = $this$map$iv;
                            destination$iv$iv2 = destination$iv$iv;
                            id6 = id5;
                            element$iv3 = element$iv;
                            item3 = item2;
                            $this$forEach$iv5 = $this$forEach$iv4;
                            c000414 = c000413;
                            it4 = it;
                            $i$f$mapTo2 = $i$f$mapTo;
                            isCasting6 = isCasting5;
                            function111 = function110;
                            obj5 = obj6;
                            i2 = $i$f$map;
                            function112 = function19;
                            collection = destination$iv$iv2;
                            jioHotstarProvider4 = jioHotstarProvider2;
                            $result6 = objNewSubtitleFile;
                            it5 = it3;
                            data5 = data9;
                            $i$f$map3 = $i$f$map2;
                            function113 = function111;
                            data6 = title6;
                            $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                            destination$iv$iv3 = $result5;
                            function113.invoke($result6);
                            collection.add(Unit.INSTANCE);
                            $result5 = destination$iv$iv3;
                            jioHotstarProvider2 = jioHotstarProvider4;
                            function19 = function112;
                            function110 = function111;
                            c000413 = c000414;
                            $i$f$map2 = $i$f$map3;
                            $i$f$map = i2;
                            destination$iv$iv = destination$iv$iv2;
                            isCasting5 = isCasting6;
                            data4 = data5;
                            obj4 = obj5;
                            it = it4;
                            it3 = it5;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                            $this$map$iv = $this$map$iv2;
                            $i$f$mapTo = $i$f$mapTo2;
                            $result4 = element$iv2;
                            $this$forEach$iv4 = $this$forEach$iv5;
                            title3 = data6;
                            id5 = id6;
                            element$iv = element$iv3;
                            item2 = item3;
                            if (it3.hasNext()) {
                                Object $result9 = $result4;
                                String data11 = data4;
                                Object obj7 = obj4;
                                continuation2 = continuation3;
                                $i$f$forEach4 = $i$f$forEach3;
                                jioHotstarProvider3 = jioHotstarProvider2;
                                function17 = function110;
                                c00041 = c000413;
                                obj3 = obj7;
                                id4 = id5;
                                $result3 = $result9;
                                data4 = data11;
                                function15 = function19;
                                isCasting3 = isCasting5;
                                $this$forEach$iv2 = $result5;
                                $this$forEach$iv = $this$forEach$iv4;
                                jioHotstarProvider5 = jioHotstarProvider3;
                                if (!it.hasNext()) {
                                    return Boxing.boxBoolean(z);
                                }
                            }
                        }
                    } else {
                        continuation2 = continuation5;
                        jioHotstarProvider3 = jioHotstarProvider2;
                        function15 = function19;
                        c00041 = c000416;
                        $i$f$forEach4 = $i$f$forEach7;
                        isCasting3 = isCasting4;
                        $this$forEach$iv2 = playlist3;
                        $result3 = $result8;
                        jioHotstarProvider5 = jioHotstarProvider3;
                        if (!it.hasNext()) {
                        }
                    }
                }
                break;
            case 1:
                boolean isCasting7 = c00041.Z$0;
                String str4 = (String) c00041.L$8;
                Map<String, String> map3 = (Map) c00041.L$7;
                String str5 = (String) c00041.L$6;
                Requests requests2 = (Requests) c00041.L$5;
                String id8 = (String) c00041.L$4;
                String title7 = (String) c00041.L$3;
                Function1<? super ExtractorLink, Unit> function117 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function118 = (Function1) c00041.L$1;
                String data12 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result6);
                cookie = $result6;
                id2 = id8;
                title = title7;
                id = str4;
                requests = requests2;
                isCasting2 = isCasting7;
                map = map3;
                function13 = function118;
                data2 = data12;
                obj = coroutine_suspended;
                str = str5;
                function14 = function117;
                $result = cookie;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00041.L$1 = function13;
                c00041.L$2 = function14;
                c00041.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00041.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00041.L$5 = null;
                c00041.L$6 = null;
                c00041.L$7 = null;
                c00041.L$8 = null;
                c00041.Z$0 = isCasting2;
                c00041.label = 2;
                Function1<? super SubtitleFile, Unit> function1142 = function13;
                function15 = function14;
                z = true;
                isCasting3 = isCasting2;
                c000412 = c00041;
                $result2 = $result;
                String data72 = data2;
                obj2 = obj;
                $result6 = Requests.get$default(requests, str, map, id, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000412, 4072, (Object) null);
                if ($result6 != obj2) {
                }
                break;
            case 2:
                boolean isCasting8 = c00041.Z$0;
                id3 = (String) c00041.L$4;
                title2 = (String) c00041.L$3;
                Function1<? super ExtractorLink, Unit> function119 = (Function1) c00041.L$2;
                function16 = (Function1) c00041.L$1;
                data3 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result6);
                isCasting3 = isCasting8;
                c000412 = c00041;
                $result2 = $result6;
                obj2 = coroutine_suspended;
                function15 = function119;
                z = true;
                NiceResponse this_$iv2 = (NiceResponse) $result6;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                Collection playlist4 = (PlayList) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PlayList.class));
                Collection $this$forEach$iv62 = playlist4;
                JioHotstarProvider jioHotstarProvider52 = this;
                int $i$f$forEach42 = 0;
                it = $this$forEach$iv62.iterator();
                function17 = function16;
                data4 = data3;
                id4 = id3;
                title3 = title2;
                obj3 = obj2;
                $this$forEach$iv = $this$forEach$iv62;
                continuation2 = continuation;
                $this$forEach$iv2 = playlist4;
                $result3 = $result2;
                c00041 = c000412;
                if (!it.hasNext()) {
                }
                break;
            case 3:
                int i7 = c00041.I$3;
                int $i$f$forEach10 = c00041.I$2;
                int i8 = c00041.I$1;
                int $i$f$forEach11 = c00041.I$0;
                boolean isCasting9 = c00041.Z$0;
                Function1 function120 = (Function1) c00041.L$14;
                Object obj8 = c00041.L$12;
                Iterator it9 = (Iterator) c00041.L$11;
                Iterable $this$forEach$iv8 = (Iterable) c00041.L$10;
                PlayListItem item6 = (PlayListItem) c00041.L$9;
                Object element$iv7 = c00041.L$8;
                Iterator<PlayListItem> it10 = (Iterator) c00041.L$7;
                Iterable $this$forEach$iv9 = (Iterable) c00041.L$6;
                Collection playlist5 = (PlayList) c00041.L$5;
                String id9 = (String) c00041.L$4;
                String title8 = (String) c00041.L$3;
                Function1<? super ExtractorLink, Unit> function121 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function122 = (Function1) c00041.L$1;
                String data13 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result6);
                $this$forEach$iv = $this$forEach$iv9;
                $this$forEach$iv3 = $this$forEach$iv8;
                function18 = function121;
                isCasting4 = isCasting9;
                item = item6;
                id4 = id9;
                z = true;
                obj3 = coroutine_suspended;
                function120.invoke($result6);
                jioHotstarProvider = this;
                continuation2 = continuation;
                $result3 = $result6;
                title3 = title8;
                function17 = function122;
                data4 = data13;
                $i$f$forEach = $i$f$forEach10;
                it = it10;
                i = i8;
                $i$f$forEach2 = $i$f$forEach11;
                $this$forEach$iv2 = playlist5;
                it2 = it9;
                element$iv = element$iv7;
                while (it2.hasNext()) {
                }
                Continuation<? super Boolean> continuation52 = continuation2;
                C00041 c0004162 = c00041;
                Object $result82 = $result3;
                int i42 = i;
                int $i$f$forEach72 = $i$f$forEach2;
                item2 = item;
                jioHotstarProvider2 = jioHotstarProvider;
                Collection playlist32 = $this$forEach$iv2;
                function19 = function18;
                tracks = item2.getTracks();
                if (tracks == null) {
                }
                break;
            case 4:
                int i9 = c00041.I$4;
                int $i$f$mapTo3 = c00041.I$3;
                $i$f$map3 = c00041.I$2;
                i2 = c00041.I$1;
                int $i$f$forEach12 = c00041.I$0;
                isCasting6 = c00041.Z$0;
                Function1<? super SubtitleFile, Unit> function123 = (Function1) c00041.L$17;
                Collection collection2 = (Collection) c00041.L$16;
                Object obj9 = c00041.L$14;
                Iterator it11 = (Iterator) c00041.L$13;
                Collection destination$iv$iv6 = (Collection) c00041.L$12;
                $this$mapTo$iv$iv2 = (Iterable) c00041.L$11;
                $this$map$iv2 = (Iterable) c00041.L$10;
                PlayListItem item7 = (PlayListItem) c00041.L$9;
                Object element$iv8 = c00041.L$8;
                Iterator<PlayListItem> it12 = (Iterator) c00041.L$7;
                $this$forEach$iv5 = (Iterable) c00041.L$6;
                Collection playlist6 = (PlayList) c00041.L$5;
                String id10 = (String) c00041.L$4;
                data6 = (String) c00041.L$3;
                Function1<? super ExtractorLink, Unit> function124 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function125 = (Function1) c00041.L$1;
                String data14 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result6);
                jioHotstarProvider4 = this;
                function113 = function123;
                data5 = data14;
                collection = collection2;
                obj5 = coroutine_suspended;
                continuation3 = continuation;
                it5 = it11;
                item3 = item7;
                element$iv3 = element$iv8;
                it4 = it12;
                id6 = id10;
                z = true;
                function111 = function125;
                c000414 = c00041;
                element$iv2 = $result6;
                $i$f$mapTo2 = $i$f$mapTo3;
                $i$f$forEach3 = $i$f$forEach12;
                destination$iv$iv2 = destination$iv$iv6;
                destination$iv$iv3 = playlist6;
                function112 = function124;
                function113.invoke($result6);
                collection.add(Unit.INSTANCE);
                $result5 = destination$iv$iv3;
                jioHotstarProvider2 = jioHotstarProvider4;
                function19 = function112;
                function110 = function111;
                c000413 = c000414;
                $i$f$map2 = $i$f$map3;
                $i$f$map = i2;
                destination$iv$iv = destination$iv$iv2;
                isCasting5 = isCasting6;
                data4 = data5;
                obj4 = obj5;
                it = it4;
                it3 = it5;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                $this$map$iv = $this$map$iv2;
                $i$f$mapTo = $i$f$mapTo2;
                $result4 = element$iv2;
                $this$forEach$iv4 = $this$forEach$iv5;
                title3 = data6;
                id5 = id6;
                element$iv = element$iv3;
                item2 = item3;
                if (it3.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.horis.cloudstreamplugins.JioHotstarProvider.getVideoInterceptor.1
            public Response intercept(Interceptor.Chain chain) {
                Request request = chain.request();
                if (StringsKt.contains$default(request.url().toString(), ".m3u8", false, 2, (Object) null)) {
                    Request newRequest = request.newBuilder().header("Cookie", "hd=on").build();
                    return chain.proceed(newRequest);
                }
                return chain.proceed(request);
            }
        };
    }

    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cloudstreamplugins/JioHotstarProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: compiled from: JioHotstarProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cloudstreamplugins/JioHotstarProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
}
