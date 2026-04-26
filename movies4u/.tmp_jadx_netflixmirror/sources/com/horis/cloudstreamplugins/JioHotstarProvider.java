package com.horis.cloudstreamplugins;

import com.horis.cloudstreamplugins.entities.PostData;
import com.horis.cloudstreamplugins.entities.SearchResult;
import com.horis.cloudstreamplugins.entities.Season;
import com.horis.cloudstreamplugins.entities.Suggest;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getCookie(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r8) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.horis.cloudstreamplugins.JioHotstarProvider.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.horis.cloudstreamplugins.JioHotstarProvider$getCookie$1 r0 = (com.horis.cloudstreamplugins.JioHotstarProvider.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.horis.cloudstreamplugins.JioHotstarProvider$getCookie$1 r0 = new com.horis.cloudstreamplugins.JioHotstarProvider$getCookie$1
            r0.<init>(r8)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            r5 = 1
            switch(r3) {
                case 0: goto L33;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2e:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L50
        L33:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r3 = com.horis.cloudstreamplugins.JioHotstarProvider.cookie_value
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L42
            r3 = 1
            goto L43
        L42:
            r3 = 0
        L43:
            if (r3 == 0) goto L54
            java.lang.String r3 = r7.newUrl
            r0.label = r5
            java.lang.Object r3 = com.horis.cloudstreamplugins.UtilsKt.bypass(r3, r0)
            if (r3 != r2) goto L50
            return r2
        L50:
            java.lang.String r3 = (java.lang.String) r3
            com.horis.cloudstreamplugins.JioHotstarProvider.cookie_value = r3
        L54:
            r2 = 3
            kotlin.Pair[] r2 = new kotlin.Pair[r2]
            java.lang.String r3 = "t_hash_t"
            java.lang.String r6 = com.horis.cloudstreamplugins.JioHotstarProvider.cookie_value
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r6)
            r2[r4] = r3
            java.lang.String r3 = "ott"
            java.lang.String r4 = "hs"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r2[r5] = r3
            java.lang.String r3 = "hd"
            java.lang.String r4 = "on"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = 2
            r2[r4] = r3
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.JioHotstarProvider.getCookie(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011b A[LOOP:0: B:23:0x0115->B:25:0x011b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getMainPage(int r24, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.MainPageRequest r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r26) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.JioHotstarProvider.getMainPage(int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
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
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r34) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.JioHotstarProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r37, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r38) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.JioHotstarProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getEpisodes(java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.Episode>> r39) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.JioHotstarProvider.getEpisodes(java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
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
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r34, boolean r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r36, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r37, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r38) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.JioHotstarProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
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
