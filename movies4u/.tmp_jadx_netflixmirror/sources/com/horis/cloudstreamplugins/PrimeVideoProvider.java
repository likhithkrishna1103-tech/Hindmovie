package com.horis.cloudstreamplugins;

import com.horis.cloudstreamplugins.entities.PostCategory;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getCookie(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r8) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.horis.cloudstreamplugins.PrimeVideoProvider.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.horis.cloudstreamplugins.PrimeVideoProvider$getCookie$1 r0 = (com.horis.cloudstreamplugins.PrimeVideoProvider.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.horis.cloudstreamplugins.PrimeVideoProvider$getCookie$1 r0 = new com.horis.cloudstreamplugins.PrimeVideoProvider$getCookie$1
            r0.<init>(r8)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 0
            r5 = 1
            switch(r3) {
                case 0: goto L37;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2e:
            java.lang.Object r2 = r0.L$0
            com.horis.cloudstreamplugins.PrimeVideoProvider r2 = (com.horis.cloudstreamplugins.PrimeVideoProvider) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L57
        L37:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r3 = r7.cookie_value
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L46
            r3 = 1
            goto L47
        L46:
            r3 = 0
        L47:
            if (r3 == 0) goto L5b
            java.lang.String r3 = r7.newUrl
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r3 = com.horis.cloudstreamplugins.UtilsKt.bypass(r3, r0)
            if (r3 != r2) goto L56
            return r2
        L56:
            r2 = r7
        L57:
            java.lang.String r3 = (java.lang.String) r3
            r2.cookie_value = r3
        L5b:
            r2 = 3
            kotlin.Pair[] r2 = new kotlin.Pair[r2]
            java.lang.String r3 = "t_hash_t"
            java.lang.String r6 = r7.cookie_value
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r6)
            r2[r4] = r3
            java.lang.String r3 = "ott"
            java.lang.String r4 = "pv"
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
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.PrimeVideoProvider.getCookie(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012e A[LOOP:0: B:23:0x0128->B:25:0x012e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getMainPage(int r24, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.MainPageRequest r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r26) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.PrimeVideoProvider.getMainPage(int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
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
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.PrimeVideoProvider.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.PrimeVideoProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getEpisodes(java.lang.String r28, java.lang.String r29, java.lang.String r30, int r31, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.Episode>> r32) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.PrimeVideoProvider.getEpisodes(java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
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
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r38, boolean r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r41, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r42) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cloudstreamplugins.PrimeVideoProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
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
