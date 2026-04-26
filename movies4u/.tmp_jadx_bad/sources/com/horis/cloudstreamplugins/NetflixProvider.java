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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: NetflixProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001aH\u0082@¢\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020%*\u00020&H\u0002J\u000e\u0010'\u001a\u0004\u0018\u00010(*\u00020&H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0*2\u0006\u0010+\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010,J4\u00100\u001a\b\u0012\u0004\u0012\u0002010*2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00162\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/horis/cloudstreamplugins/NetflixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "headers", "", "getCookie", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "getEpisodes", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Id", "LoadData", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetflixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetflixProvider.kt\ncom/horis/cloudstreamplugins/NetflixProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 Utils.kt\ncom/horis/cloudstreamplugins/UtilsKt\n*L\n1#1,267:1\n1586#2:268\n1661#2,3:269\n1642#2,10:272\n1915#2:282\n1916#2:284\n1652#2:285\n1586#2:287\n1661#2,3:288\n1586#2:293\n1661#2,3:294\n1586#2:297\n1661#2,3:298\n1586#2:301\n1661#2,3:302\n777#2:305\n873#2,2:306\n1586#2:308\n1661#2,3:309\n1661#2,3:312\n1661#2,3:316\n1915#2:321\n1915#2,2:322\n777#2:324\n873#2,2:325\n1586#2:327\n1661#2,3:328\n1916#2:331\n1#3:283\n68#4:286\n68#4:292\n68#4:315\n68#4:320\n51#5:291\n51#5:319\n*S KotlinDebug\n*F\n+ 1 NetflixProvider.kt\ncom/horis/cloudstreamplugins/NetflixProvider\n*L\n62#1:268\n62#1:269,3\n70#1:272,10\n70#1:282\n70#1:284\n70#1:285\n94#1:287\n94#1:288,3\n114#1:293\n114#1:294,3\n115#1:297\n115#1:298,3\n121#1:301\n121#1:302,3\n122#1:305\n122#1:306,2\n125#1:308\n125#1:309,3\n137#1:312,3\n190#1:316,3\n221#1:321\n222#1:322,2\n242#1:324\n242#1:325,2\n242#1:327\n242#1:328,3\n221#1:331\n70#1:283\n92#1:286\n109#1:292\n189#1:315\n219#1:320\n103#1:291\n211#1:319\n*E\n"})
public final class NetflixProvider extends MainAPI {

    @NotNull
    private static String cookie_value = "";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private String lang = "en";

    @NotNull
    private String mainUrl = "https://net52.cc";

    @NotNull
    private String name = "Netflix";
    private final boolean hasMainPage = true;

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$getCookie$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider", f = "NetflixProvider.kt", i = {}, l = {43}, m = "getCookie", n = {}, nl = {46}, s = {}, v = 2)
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
            return NetflixProvider.this.getCookie((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$getEpisodes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider", f = "NetflixProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {178, 188, 184}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "page", "title", "eid", "sid", "episodes", "cookies", "page", "pg", "title", "eid", "sid", "episodes", "cookies", "page", "pg"}, nl = {179, 184, 189}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetflixProvider.this.getEpisodes(null, null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$getMainPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider", f = "NetflixProvider.kt", i = {0, 0, 1, 1}, l = {55, 53}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {56, 59}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetflixProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider", f = "NetflixProvider.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {108, 104, 148, 151, 158}, m = "load", n = {"url", "id", "url", "id", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {104, 109, 151, 156, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetflixProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider", f = "NetflixProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {213, 213, 218, 214, 224, 244}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "title", "id", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "token", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "token", "isCasting", "data", "subtitleCallback", "callback", "title", "id", "token", "playlist", "$this$forEach$iv", "element$iv", "item", "$this$forEach$iv", "element$iv", "it", "isCasting", "$i$f$forEach", "$i$a$-forEach-NetflixProvider$loadLinks$2", "$i$f$forEach", "$i$a$-forEach-NetflixProvider$loadLinks$2$1", "data", "subtitleCallback", "callback", "title", "id", "token", "playlist", "$this$forEach$iv", "element$iv", "item", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "track", "isCasting", "$i$f$forEach", "$i$a$-forEach-NetflixProvider$loadLinks$2", "$i$f$map", "$i$f$mapTo", "$i$a$-map-NetflixProvider$loadLinks$2$3"}, nl = {213, 214, 214, 219, 223, 243}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$13", "L$14", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    static final class C00091 extends ContinuationImpl {
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
        Object L$18;
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

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetflixProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider", f = "NetflixProvider.kt", i = {0, 0, 1, 1}, l = {91, 88}, m = "search", n = {"query", "url", "query", "url"}, nl = {88, 92}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetflixProvider.this.search(null, (Continuation) this);
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
                    String mainUrl = getMainUrl();
                    anonymousClass1.label = 1;
                    objBypass = UtilsKt.bypass(mainUrl, anonymousClass1);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cookie_value = (String) objBypass;
                }
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", cookie_value), TuplesKt.to("ott", "nf"), TuplesKt.to("hd", "on")});
            case 1:
                ResultKt.throwOnFailure($result);
                objBypass = $result;
                cookie_value = (String) objBypass;
                return MapsKt.mapOf(new Pair[]{TuplesKt.to("t_hash_t", cookie_value), TuplesKt.to("ott", "nf"), TuplesKt.to("hd", "on")});
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010e A[LOOP:0: B:23:0x0108->B:25:0x010e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00071 c00071;
        Requests app;
        int page2;
        Object cookie;
        MainPageRequest request2;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                app = UtilsKt.getApp();
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00071.L$1 = app;
                page2 = page;
                c00071.I$0 = page2;
                c00071.label = 1;
                cookie = getCookie(c00071);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                Map mapPlus = MapsKt.plus((Map) cookie, MapsKt.mapOf(TuplesKt.to("user_token", "233123f803cf02184bf6c67e149cdd50")));
                String str = getMainUrl() + '/';
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00071.L$1 = null;
                c00071.I$0 = page2;
                c00071.label = 2;
                $result = Requests.get$default(app, "https://net22.cc/home", (Map) null, str, (Map) null, mapPlus, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4074, (Object) null);
                if ($result != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv = document.select(".lolomoRow");
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(toHomePageList(it));
                }
                List items = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items, Boxing.boxBoolean(false));
            case 1:
                page2 = c00071.I$0;
                app = (Requests) c00071.L$1;
                MainPageRequest request3 = (MainPageRequest) c00071.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request3;
                cookie = $result;
                Map mapPlus2 = MapsKt.plus((Map) cookie, MapsKt.mapOf(TuplesKt.to("user_token", "233123f803cf02184bf6c67e149cdd50")));
                String str2 = getMainUrl() + '/';
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00071.L$1 = null;
                c00071.I$0 = page2;
                c00071.label = 2;
                $result = Requests.get$default(app, "https://net22.cc/home", (Map) null, str2, (Map) null, mapPlus2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4074, (Object) null);
                if ($result != coroutine_suspended) {
                }
                break;
            case 2:
                int i = c00071.I$0;
                ResultKt.throwOnFailure($result);
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv2 = document2.select(".lolomoRow");
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
        String name = $this$toHomePageList.select("h2 > span > div").text();
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("img.lazy");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false, 4, (DefaultConstructorMarker) null);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String id = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default($this$toSearchResult.attr("data-src"), "/", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null);
        final String posterUrl = "https://imgcdn.kim/poster/v/" + id + ".jpg";
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.NetflixProvider$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return NetflixProvider.toSearchResult$lambda$0(posterUrl, this, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, NetflixProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0118 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0159 A[LOOP:0: B:23:0x0153->B:25:0x0159, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Exception {
        C00101 c00101;
        Requests app;
        Object cookie;
        String url;
        String query2;
        String str;
        Object obj;
        String str2;
        Object obj2;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url2 = getMainUrl() + "/search.php?s=" + query + "&t=" + APIHolder.INSTANCE.getUnixTime();
                app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/tv/home";
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00101.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00101.L$2 = app;
                c00101.L$3 = url2;
                c00101.L$4 = str3;
                c00101.label = 1;
                cookie = getCookie(c00101);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url = url2;
                query2 = query;
                str = str3;
                obj = coroutine_suspended;
                str2 = url;
                Map map = (Map) cookie;
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00101.L$1 = SpillingKt.nullOutSpilledVariable(url);
                obj2 = obj;
                c00101.L$2 = null;
                c00101.L$3 = null;
                c00101.L$4 = null;
                c00101.label = 2;
                $result = Requests.get$default(app, str2, (Map) null, str, (Map) null, map, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4074, (Object) null);
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
                    destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getT(), AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.NetflixProvider$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return NetflixProvider.search$lambda$0$0(it, this, (AnimeSearchResponse) obj3);
                        }
                    }, 12, (Object) null));
                }
                return (List) destination$iv$iv;
            case 1:
                String str4 = (String) c00101.L$4;
                String str5 = (String) c00101.L$3;
                app = (Requests) c00101.L$2;
                String url3 = (String) c00101.L$1;
                String query3 = (String) c00101.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str2 = str5;
                str = str4;
                url = url3;
                query2 = query3;
                cookie = $result;
                Map map2 = (Map) cookie;
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00101.L$1 = SpillingKt.nullOutSpilledVariable(url);
                obj2 = obj;
                c00101.L$2 = null;
                c00101.L$3 = null;
                c00101.L$4 = null;
                c00101.label = 2;
                $result = Requests.get$default(app, str2, (Map) null, str, (Map) null, map2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4074, (Object) null);
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
    public static final Unit search$lambda$0$0(SearchResult $it, NetflixProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/poster/v/" + $it.getId() + ".jpg");
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
        C00081 c00081;
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
        C00081 c000812;
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
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        }
        C00081 c000813 = c00081;
        Object $result = c000813.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c000813.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = ((Id) UtilsKt.getJSONParser().parse(url, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = this.headers;
                String str4 = getMainUrl() + "/tv/home";
                c000813.L$0 = url;
                c000813.L$1 = id;
                c000813.L$2 = app;
                c000813.L$3 = str3;
                c000813.L$4 = map2;
                c000813.L$5 = str4;
                c000813.label = 1;
                Object cookie = getCookie(c000813);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = map2;
                obj = cookie;
                str = str4;
                id2 = url;
                str2 = str3;
                requests = app;
                c000813.L$0 = id2;
                c000813.L$1 = id;
                c000813.L$2 = null;
                c000813.L$3 = null;
                c000813.L$4 = null;
                c000813.L$5 = null;
                c000813.label = 2;
                obj2 = Requests.get$default(requests, str2, map, str, (Map) null, (Map) obj, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000813, 4072, (Object) null);
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
                        destination$iv$iv6.add(MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(it.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cloudstreamplugins.NetflixProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj5) {
                                return NetflixProvider.load$lambda$4$0(it, this, (AnimeSearchResponse) obj5);
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
                    Boxing.boxBoolean(episodes6.add(MainAPIKt.newEpisode(this, new LoadData(title3, id3), new Function1() { // from class: com.horis.cloudstreamplugins.NetflixProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj5) {
                            return NetflixProvider.load$lambda$5(data, (Episode) obj5);
                        }
                    })));
                    c000812 = c000813;
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
                    c000812.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c000812.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                    c000812.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c000812.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                    c000812.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                    c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c000812.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                    c000812.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                    c000812.L$8 = SpillingKt.nullOutSpilledVariable(rating5);
                    c000812.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                    c000812.L$10 = SpillingKt.nullOutSpilledVariable(type);
                    c000812.I$0 = runTime2;
                    c000812.label = 5;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type, episodes4, anonymousClass5, c000812);
                    return $result != obj4 ? obj4 : $result;
                }
                Iterable $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                ArrayList destination$iv = episodes6;
                int $i$f$mapTo = 0;
                for (Iterator it2 = $this$mapTo$iv.iterator(); it2.hasNext(); it2 = it2) {
                    Object item$iv = it2.next();
                    Iterable $this$mapTo$iv2 = $this$mapTo$iv;
                    final com.horis.cloudstreamplugins.entities.Episode it3 = (com.horis.cloudstreamplugins.entities.Episode) item$iv;
                    destination$iv.add(MainAPIKt.newEpisode(this, new LoadData(title3, it3.getId()), new Function1() { // from class: com.horis.cloudstreamplugins.NetflixProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj5) {
                            return NetflixProvider.load$lambda$6$0(it3, (Episode) obj5);
                        }
                    }));
                    $this$mapTo$iv = $this$mapTo$iv2;
                    $i$f$mapTo = $i$f$mapTo;
                }
                Integer nextPageShow = data.getNextPageShow();
                if (nextPageShow != null && nextPageShow.intValue() == 1) {
                    String title4 = data.getNextPageSeason();
                    Intrinsics.checkNotNull(title4);
                    c000813.L$0 = id2;
                    c000813.L$1 = id3;
                    c000813.L$2 = data;
                    c000813.L$3 = episodes6;
                    c000813.L$4 = title3;
                    c000813.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c000813.L$6 = cast6;
                    c000813.L$7 = genre2;
                    c000813.L$8 = rating;
                    c000813.L$9 = suggest2;
                    c000813.L$10 = episodes6;
                    c000813.I$0 = runTime;
                    c000813.label = 3;
                    String url5 = id2;
                    episodes = getEpisodes(title3, url5, title4, 2, c000813);
                    c000812 = c000813;
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
                        c000812.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c000812.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                        c000812.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c000812.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c000812.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                        c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                        c000812.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                        c000812.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                        c000812.L$8 = SpillingKt.nullOutSpilledVariable(rating52);
                        c000812.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                        c000812.L$10 = SpillingKt.nullOutSpilledVariable(type2);
                        c000812.I$0 = runTime2;
                        c000812.label = 5;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type2, episodes4, anonymousClass52, c000812);
                        if ($result != obj4) {
                        }
                    } else {
                        List castList4 = genre4;
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(episodes3, this, title, rating3, null);
                        c000812.L$0 = rating3;
                        c000812.L$1 = id4;
                        c000812.L$2 = data3;
                        c000812.L$3 = episodes3;
                        c000812.L$4 = title;
                        c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList4);
                        c000812.L$6 = cast3;
                        c000812.L$7 = genre2;
                        c000812.L$8 = rating;
                        c000812.L$9 = suggest2;
                        c000812.L$10 = null;
                        c000812.I$0 = runTime;
                        c000812.label = 4;
                        objAmap = ParCollectionsKt.amap(listDropLast, anonymousClass4, c000812);
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
                        c000812.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c000812.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                        c000812.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c000812.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                        c000812.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                        c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                        c000812.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                        c000812.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                        c000812.L$8 = SpillingKt.nullOutSpilledVariable(rating522);
                        c000812.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                        c000812.L$10 = SpillingKt.nullOutSpilledVariable(type22);
                        c000812.I$0 = runTime2;
                        c000812.label = 5;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type22, episodes4, anonymousClass522, c000812);
                        if ($result != obj4) {
                        }
                    }
                } else {
                    String url6 = id2;
                    String title5 = title3;
                    c000812 = c000813;
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
                    c000812.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c000812.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                    c000812.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c000812.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                    c000812.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                    c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                    c000812.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                    c000812.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                    c000812.L$8 = SpillingKt.nullOutSpilledVariable(rating5222);
                    c000812.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                    c000812.L$10 = SpillingKt.nullOutSpilledVariable(type222);
                    c000812.I$0 = runTime2;
                    c000812.label = 5;
                    $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type222, episodes4, anonymousClass5222, c000812);
                    if ($result != obj4) {
                    }
                }
                break;
            case 1:
                String str7 = (String) c000813.L$5;
                Map<String, String> map3 = (Map) c000813.L$4;
                String str8 = (String) c000813.L$3;
                Requests requests2 = (Requests) c000813.L$2;
                id = (String) c000813.L$1;
                String url7 = (String) c000813.L$0;
                ResultKt.throwOnFailure($result);
                map = map3;
                obj = $result;
                str = str7;
                str2 = str8;
                id2 = url7;
                requests = requests2;
                c000813.L$0 = id2;
                c000813.L$1 = id;
                c000813.L$2 = null;
                c000813.L$3 = null;
                c000813.L$4 = null;
                c000813.L$5 = null;
                c000813.label = 2;
                obj2 = Requests.get$default(requests, str2, map, str, (Map) null, (Map) obj, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000813, 4072, (Object) null);
                if (obj2 != coroutine_suspended) {
                }
                break;
            case 2:
                String id8 = (String) c000813.L$1;
                String url8 = (String) c000813.L$0;
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
                int runTime3 = c000813.I$0;
                arrayList2 = (ArrayList) c000813.L$10;
                List suggest4 = (List) c000813.L$9;
                rating2 = (String) c000813.L$8;
                genre3 = (List) c000813.L$7;
                cast2 = (List) c000813.L$6;
                List castList5 = (List) c000813.L$5;
                String title6 = (String) c000813.L$4;
                ArrayList episodes7 = (ArrayList) c000813.L$3;
                data2 = (PostData) c000813.L$2;
                id3 = (String) c000813.L$1;
                url2 = (String) c000813.L$0;
                ResultKt.throwOnFailure($result);
                castList = castList5;
                url3 = title6;
                runTime = runTime3;
                c000812 = c000813;
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
                c000812.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c000812.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c000812.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c000812.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                c000812.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                c000812.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                c000812.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                c000812.L$8 = SpillingKt.nullOutSpilledVariable(rating52222);
                c000812.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                c000812.L$10 = SpillingKt.nullOutSpilledVariable(type2222);
                c000812.I$0 = runTime2;
                c000812.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type2222, episodes4, anonymousClass52222, c000812);
                if ($result != obj4) {
                }
                break;
            case 4:
                int runTime4 = c000813.I$0;
                suggest3 = (List) c000813.L$9;
                title2 = (String) c000813.L$8;
                genre5 = (List) c000813.L$7;
                cast3 = (List) c000813.L$6;
                castList2 = (List) c000813.L$5;
                id6 = (String) c000813.L$4;
                ArrayList episodes8 = (ArrayList) c000813.L$3;
                PostData data5 = (PostData) c000813.L$2;
                String id9 = (String) c000813.L$1;
                url4 = (String) c000813.L$0;
                ResultKt.throwOnFailure($result);
                episodes5 = episodes8;
                runTime = runTime4;
                objAmap = $result;
                data3 = data5;
                c000812 = c000813;
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
                c000812.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c000812.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c000812.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c000812.L$3 = SpillingKt.nullOutSpilledVariable(episodes4);
                c000812.L$4 = SpillingKt.nullOutSpilledVariable(id6);
                c000812.L$5 = SpillingKt.nullOutSpilledVariable(castList);
                c000812.L$6 = SpillingKt.nullOutSpilledVariable(cast4);
                c000812.L$7 = SpillingKt.nullOutSpilledVariable(genre5);
                c000812.L$8 = SpillingKt.nullOutSpilledVariable(rating522222);
                c000812.L$9 = SpillingKt.nullOutSpilledVariable(cast5);
                c000812.L$10 = SpillingKt.nullOutSpilledVariable(type22222);
                c000812.I$0 = runTime2;
                c000812.label = 5;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, id6, url4, type22222, episodes4, anonymousClass522222, c000812);
                if ($result != obj4) {
                }
                break;
            case 5:
                int i = c000813.I$0;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Suggest $it, NetflixProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/poster/v/" + $it.getId() + ".jpg");
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
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/epimg/150/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$load$4, reason: invalid class name */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/horis/cloudstreamplugins/entities/Season;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider$load$4", f = "NetflixProvider.kt", i = {0}, l = {152}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<Season, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ String $title;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ NetflixProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(ArrayList<Episode> arrayList, NetflixProvider netflixProvider, String str, String str2, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$episodes = arrayList;
            this.this$0 = netflixProvider;
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

    /* JADX INFO: renamed from: com.horis.cloudstreamplugins.NetflixProvider$load$5, reason: invalid class name */
    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cloudstreamplugins.NetflixProvider$load$5", f = "NetflixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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
        final /* synthetic */ NetflixProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str, NetflixProvider netflixProvider, PostData postData, List<String> list, List<ActorData> list2, String str2, int i, List<AnimeSearchResponse> list3, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = netflixProvider;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl("https://imgcdn.kim/poster/v/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl("https://imgcdn.kim/poster/h/" + this.$id + ".jpg");
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
        C00061 c00061;
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
        NetflixProvider netflixProvider;
        Object $result;
        int pg3;
        NetflixProvider netflixProvider2;
        Object cookie;
        Iterable episodes3;
        EpisodesData data;
        Continuation<? super List<Episode>> continuation2;
        C00061 c000612;
        Continuation<? super List<Episode>> continuation3 = continuation;
        if (continuation3 instanceof C00061) {
            c00061 = (C00061) continuation3;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation3);
            }
        }
        Object $result2 = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                c = 2;
                ResultKt.throwOnFailure($result2);
                episodes = new ArrayList();
                pairArr = new Pair[3];
                c00061.L$0 = title;
                c00061.L$1 = eid;
                c00061.L$2 = sid;
                c00061.L$3 = episodes;
                c00061.L$4 = pairArr;
                c00061.L$5 = pairArr;
                c00061.L$6 = "t_hash_t";
                c00061.I$0 = page;
                c00061.I$1 = 0;
                c00061.label = 1;
                Object cookie2 = getCookie(c00061);
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
                pairArr2[1] = TuplesKt.to("ott", "nf");
                pairArr2[c] = TuplesKt.to("hd", "on");
                cookies = MapsKt.mapOf(pairArr2);
                int pg4 = pg;
                NetflixProvider netflixProvider3 = this;
                Requests app = UtilsKt.getApp();
                Continuation<? super List<Episode>> continuation4 = continuation3;
                String str4 = netflixProvider3.getMainUrl() + "/episodes.php?s=" + eid2 + "&series=" + title2 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg4;
                Map<String, String> map2 = netflixProvider3.headers;
                String str5 = netflixProvider3.getMainUrl() + "/tv/home";
                c00061.L$0 = title3;
                c00061.L$1 = title2;
                c00061.L$2 = eid2;
                c00061.L$3 = episodes;
                c00061.L$4 = SpillingKt.nullOutSpilledVariable(cookies);
                c00061.L$5 = app;
                c00061.L$6 = str4;
                c00061.L$7 = map2;
                c00061.L$8 = str5;
                c00061.I$0 = pg;
                c00061.I$1 = pg4;
                c00061.label = 2;
                cookie = netflixProvider3.getCookie(c00061);
                if (cookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NetflixProvider netflixProvider4 = netflixProvider3;
                page2 = pg;
                netflixProvider = netflixProvider4;
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
                c00061.L$0 = eid3;
                c00061.L$1 = sid3;
                c00061.L$2 = sid2;
                c00061.L$3 = episodes2;
                c00061.L$4 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00061.L$5 = null;
                c00061.L$6 = null;
                c00061.L$7 = null;
                c00061.L$8 = null;
                c00061.I$0 = page2;
                c00061.I$1 = pg2;
                c00061.label = 3;
                C00061 c000613 = c00061;
                $result2 = Requests.get$default(requests, str3, map, str2, (Map) null, (Map) $result2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000613, 4072, (Object) null);
                if ($result2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                NetflixProvider netflixProvider5 = netflixProvider;
                pg3 = pg2;
                cookies = cookies2;
                netflixProvider2 = netflixProvider5;
                c00061 = c000613;
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
                        destination$iv.add(MainAPIKt.newEpisode(netflixProvider2, new LoadData(title3, it.getId()), new Function1() { // from class: com.horis.cloudstreamplugins.NetflixProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                return NetflixProvider.getEpisodes$lambda$0$0(it, (Episode) obj2);
                            }
                        }));
                        data2 = data3;
                        continuation3 = continuation3;
                        c00061 = c00061;
                        $this$mapTo$iv = $this$mapTo$iv;
                    }
                    data = data2;
                    continuation2 = continuation3;
                    c000612 = c00061;
                } else {
                    data = data2;
                    continuation2 = continuation3;
                    c000612 = c00061;
                }
                if (data.getNextPageShow() != 0) {
                    return episodes;
                }
                pg4 = pg3 + 1;
                $result2 = $result3;
                continuation3 = continuation2;
                c00061 = c000612;
                pg = page2;
                netflixProvider3 = netflixProvider2;
                Requests app2 = UtilsKt.getApp();
                Continuation<? super List<Episode>> continuation42 = continuation3;
                String str42 = netflixProvider3.getMainUrl() + "/episodes.php?s=" + eid2 + "&series=" + title2 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg4;
                Map<String, String> map22 = netflixProvider3.headers;
                String str52 = netflixProvider3.getMainUrl() + "/tv/home";
                c00061.L$0 = title3;
                c00061.L$1 = title2;
                c00061.L$2 = eid2;
                c00061.L$3 = episodes;
                c00061.L$4 = SpillingKt.nullOutSpilledVariable(cookies);
                c00061.L$5 = app2;
                c00061.L$6 = str42;
                c00061.L$7 = map22;
                c00061.L$8 = str52;
                c00061.I$0 = pg;
                c00061.I$1 = pg4;
                c00061.label = 2;
                cookie = netflixProvider3.getCookie(c00061);
                if (cookie == coroutine_suspended) {
                }
                break;
            case 1:
                c = 2;
                i = c00061.I$1;
                pg = c00061.I$0;
                str = (String) c00061.L$6;
                pairArr = (Pair[]) c00061.L$5;
                pairArr2 = (Pair[]) c00061.L$4;
                episodes = (ArrayList) c00061.L$3;
                eid2 = (String) c00061.L$2;
                title2 = (String) c00061.L$1;
                title3 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result2);
                obj = $result2;
                pairArr[i] = TuplesKt.to(str, obj);
                pairArr2[1] = TuplesKt.to("ott", "nf");
                pairArr2[c] = TuplesKt.to("hd", "on");
                cookies = MapsKt.mapOf(pairArr2);
                int pg42 = pg;
                NetflixProvider netflixProvider32 = this;
                Requests app22 = UtilsKt.getApp();
                Continuation<? super List<Episode>> continuation422 = continuation3;
                String str422 = netflixProvider32.getMainUrl() + "/episodes.php?s=" + eid2 + "&series=" + title2 + "&t=" + APIHolder.INSTANCE.getUnixTime() + "&page=" + pg42;
                Map<String, String> map222 = netflixProvider32.headers;
                String str522 = netflixProvider32.getMainUrl() + "/tv/home";
                c00061.L$0 = title3;
                c00061.L$1 = title2;
                c00061.L$2 = eid2;
                c00061.L$3 = episodes;
                c00061.L$4 = SpillingKt.nullOutSpilledVariable(cookies);
                c00061.L$5 = app22;
                c00061.L$6 = str422;
                c00061.L$7 = map222;
                c00061.L$8 = str522;
                c00061.I$0 = pg;
                c00061.I$1 = pg42;
                c00061.label = 2;
                cookie = netflixProvider32.getCookie(c00061);
                if (cookie == coroutine_suspended) {
                }
                break;
            case 2:
                pg2 = c00061.I$1;
                page2 = c00061.I$0;
                String str6 = (String) c00061.L$8;
                Map<String, String> map3 = (Map) c00061.L$7;
                String str7 = (String) c00061.L$6;
                Requests requests2 = (Requests) c00061.L$5;
                Map cookies3 = (Map) c00061.L$4;
                ArrayList episodes4 = (ArrayList) c00061.L$3;
                String sid4 = (String) c00061.L$2;
                String eid4 = (String) c00061.L$1;
                String title4 = (String) c00061.L$0;
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
                netflixProvider = this;
                $result = $result2;
                c00061.L$0 = eid3;
                c00061.L$1 = sid3;
                c00061.L$2 = sid2;
                c00061.L$3 = episodes2;
                c00061.L$4 = SpillingKt.nullOutSpilledVariable(cookies2);
                c00061.L$5 = null;
                c00061.L$6 = null;
                c00061.L$7 = null;
                c00061.L$8 = null;
                c00061.I$0 = page2;
                c00061.I$1 = pg2;
                c00061.label = 3;
                C00061 c0006132 = c00061;
                $result2 = Requests.get$default(requests, str3, map, str2, (Map) null, (Map) $result2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0006132, 4072, (Object) null);
                if ($result2 != coroutine_suspended) {
                }
                break;
            case 3:
                int pg5 = c00061.I$1;
                page2 = c00061.I$0;
                Map cookies4 = (Map) c00061.L$4;
                ArrayList episodes5 = (ArrayList) c00061.L$3;
                String sid5 = (String) c00061.L$2;
                String eid5 = (String) c00061.L$1;
                String title5 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result2);
                pg3 = pg5;
                cookies = cookies4;
                netflixProvider2 = this;
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
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/epimg/150/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x027c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0310 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x037c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x052b -> B:55:0x0567). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x061c -> B:61:0x0642). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0693 -> B:64:0x06a1). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function12, @NotNull Continuation<? super Boolean> continuation) throws Exception {
        C00091 c00091;
        String id;
        String mainUrl;
        Function1<? super SubtitleFile, Unit> function13;
        Function1<? super ExtractorLink, Unit> function14;
        boolean isCasting2;
        String str;
        Object obj;
        String data2;
        String data3;
        String title;
        Object videoToken;
        Function1<? super SubtitleFile, Unit> function15;
        Function1<? super ExtractorLink, Unit> function16;
        String title2;
        boolean isCasting3;
        Object cookie;
        Function1<? super SubtitleFile, Unit> function17;
        Requests requests;
        String token;
        String id2;
        Object title3;
        String data4;
        Map<String, String> map;
        String id3;
        Function1<? super ExtractorLink, Unit> function18;
        String str2;
        Object $result;
        C00091 c000912;
        Object obj2;
        boolean z;
        String token2;
        String id4;
        Object title4;
        String data5;
        Function1<? super SubtitleFile, Unit> function19;
        Function1<? super ExtractorLink, Unit> function110;
        Object playlist;
        Iterable $this$forEach$iv;
        Iterator it;
        int $i$f$forEach;
        String data6;
        Function1<? super SubtitleFile, Unit> function111;
        Object title5;
        String id5;
        String id6;
        Object obj3;
        Continuation<? super Boolean> continuation2;
        Function1<? super ExtractorLink, Unit> function112;
        C00091 c000913;
        PlayListItem item;
        NetflixProvider netflixProvider;
        int $i$f$forEach2;
        int i;
        Iterator it2;
        boolean isCasting4;
        Object element$iv;
        List<Source> $this$forEach$iv2;
        PlayListItem item2;
        Iterable tracks;
        Function1<? super ExtractorLink, Unit> function113;
        int $i$f$map;
        Object playlist2;
        Continuation<? super Boolean> continuation3;
        Iterable $this$map$iv;
        Object $this$mapTo$iv$iv;
        String token3;
        Function1<? super SubtitleFile, Unit> function114;
        int $i$f$forEach3;
        NetflixProvider netflixProvider2;
        C00091 c000914;
        Object obj4;
        boolean isCasting5;
        int $i$f$mapTo;
        Iterator it3;
        String id7;
        Collection destination$iv$iv;
        int i2;
        Iterable $this$forEach$iv3;
        Function1<? super ExtractorLink, Unit> function115;
        Object element$iv2;
        String id8;
        boolean isCasting6;
        Object element$iv3;
        String id9;
        PlayListItem item3;
        Object $result2;
        Iterable $this$forEach$iv4;
        Object $result3;
        String token4;
        Collection destination$iv$iv2;
        Iterator it4;
        Iterator it5;
        int $i$f$mapTo2;
        Function1<? super SubtitleFile, Unit> function116;
        C00091 c000915;
        Object obj5;
        Object item$iv$iv;
        int i3;
        int $i$f$forEach4;
        NetflixProvider netflixProvider3;
        int $i$f$map2;
        Collection collection;
        Iterable $this$map$iv2;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        }
        Object $result4 = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result4);
                LoadData loadData = (LoadData) UtilsKt.getJSONParser().parse(data, Reflection.getOrCreateKotlinClass(LoadData.class));
                String title6 = loadData.getTitle();
                id = loadData.getId();
                mainUrl = getMainUrl();
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data);
                function13 = function1;
                c00091.L$1 = function13;
                function14 = function12;
                c00091.L$2 = function14;
                c00091.L$3 = title6;
                c00091.L$4 = id;
                c00091.L$5 = "https://net22.cc";
                c00091.L$6 = mainUrl;
                c00091.L$7 = id;
                isCasting2 = isCasting;
                c00091.Z$0 = isCasting2;
                c00091.label = 1;
                Object cookie2 = getCookie(c00091);
                if (cookie2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = "https://net22.cc";
                obj = cookie2;
                data2 = data;
                data3 = title6;
                title = id;
                Map mapPlus = MapsKt.plus((Map) obj, MapsKt.mapOf(TuplesKt.to("user_token", "233123f803cf02184bf6c67e149cdd50")));
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00091.L$1 = function13;
                c00091.L$2 = function14;
                c00091.L$3 = data3;
                c00091.L$4 = id;
                c00091.L$5 = null;
                c00091.L$6 = null;
                c00091.L$7 = null;
                c00091.Z$0 = isCasting2;
                c00091.label = 2;
                videoToken = UtilsKt.getVideoToken(str, mainUrl, title, mapPlus, c00091);
                if (videoToken != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Function1<? super ExtractorLink, Unit> function117 = function14;
                function15 = function13;
                function16 = function117;
                title2 = id;
                isCasting3 = isCasting2;
                String token5 = (String) videoToken;
                Requests app = UtilsKt.getApp();
                String str3 = getMainUrl() + "/playlist.php?id=" + title2 + "&t=" + data3 + "&tm=" + APIHolder.INSTANCE.getUnixTime() + "&h=" + token5;
                Map<String, String> map2 = this.headers;
                String str4 = getMainUrl() + '/';
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00091.L$1 = function15;
                c00091.L$2 = function16;
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00091.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(token5);
                c00091.L$6 = app;
                c00091.L$7 = str3;
                c00091.L$8 = map2;
                c00091.L$9 = str4;
                c00091.Z$0 = isCasting3;
                c00091.label = 3;
                cookie = getCookie(c00091);
                if (cookie != coroutine_suspended) {
                    return coroutine_suspended;
                }
                function17 = function15;
                requests = app;
                token = token5;
                id2 = title2;
                title3 = data3;
                data4 = data2;
                map = map2;
                id3 = str4;
                function18 = function16;
                str2 = str3;
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00091.L$1 = function17;
                c00091.L$2 = function18;
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00091.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(token);
                c00091.L$6 = null;
                c00091.L$7 = null;
                c00091.L$8 = null;
                c00091.L$9 = null;
                c00091.Z$0 = isCasting3;
                c00091.label = 4;
                Function1<? super ExtractorLink, Unit> function118 = function18;
                Function1<? super SubtitleFile, Unit> function119 = function17;
                $result = $result4;
                c000912 = c00091;
                obj2 = coroutine_suspended;
                z = true;
                $result4 = Requests.get$default(requests, str2, map, id3, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000912, 4072, (Object) null);
                if ($result4 != obj2) {
                    return obj2;
                }
                token2 = token;
                id4 = id2;
                title4 = title3;
                data5 = data4;
                function19 = function119;
                function110 = function118;
                NiceResponse this_$iv = (NiceResponse) $result4;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                playlist = (PlayList) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PlayList.class));
                $this$forEach$iv = (Iterable) playlist;
                NetflixProvider netflixProvider4 = this;
                it = $this$forEach$iv.iterator();
                $i$f$forEach = 0;
                data6 = data5;
                function111 = function19;
                Function1<? super ExtractorLink, Unit> function120 = function110;
                title5 = title4;
                id5 = id4;
                id6 = token2;
                obj3 = obj2;
                boolean isCasting7 = isCasting3;
                continuation2 = continuation;
                if (!it.hasNext()) {
                    element$iv = it.next();
                    PlayListItem item4 = (PlayListItem) element$iv;
                    $this$forEach$iv2 = item4.getSources();
                    function112 = function120;
                    netflixProvider = netflixProvider4;
                    c000913 = c000912;
                    item = item4;
                    i = 0;
                    it2 = $this$forEach$iv2.iterator();
                    isCasting4 = isCasting7;
                    $i$f$forEach2 = 0;
                    while (it2.hasNext()) {
                        Object element$iv4 = it2.next();
                        Source it6 = (Source) element$iv4;
                        String name = netflixProvider.getName();
                        String label = it6.getLabel();
                        Continuation<? super Boolean> continuation4 = continuation2;
                        String str5 = netflixProvider.getMainUrl() + it6.getFile();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        NetflixProvider netflixProvider5 = netflixProvider;
                        Object playlist3 = playlist;
                        NetflixProvider$loadLinks$2$1$1 netflixProvider$loadLinks$2$1$1 = new NetflixProvider$loadLinks$2$1$1(netflixProvider5, null);
                        C00091 c000916 = c000913;
                        c000916.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                        c000916.L$1 = function111;
                        Function1<? super ExtractorLink, Unit> function121 = function112;
                        c000916.L$2 = function121;
                        c000916.L$3 = SpillingKt.nullOutSpilledVariable(title5);
                        c000916.L$4 = SpillingKt.nullOutSpilledVariable(id5);
                        c000916.L$5 = SpillingKt.nullOutSpilledVariable(id6);
                        c000916.L$6 = SpillingKt.nullOutSpilledVariable(playlist3);
                        c000916.L$7 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                        c000916.L$8 = it;
                        c000916.L$9 = SpillingKt.nullOutSpilledVariable(element$iv);
                        PlayListItem item5 = item;
                        c000916.L$10 = item5;
                        c000916.L$11 = SpillingKt.nullOutSpilledVariable($this$forEach$iv2);
                        Iterator it7 = it2;
                        c000916.L$12 = it7;
                        c000916.L$13 = SpillingKt.nullOutSpilledVariable(element$iv4);
                        c000916.L$14 = SpillingKt.nullOutSpilledVariable(it6);
                        c000916.L$15 = function121;
                        c000916.L$16 = null;
                        c000916.L$17 = null;
                        c000916.L$18 = null;
                        c000916.Z$0 = isCasting4;
                        c000916.I$0 = $i$f$forEach;
                        c000916.I$1 = i;
                        c000916.I$2 = $i$f$forEach2;
                        c000916.I$3 = 0;
                        c000916.label = 5;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, label, str5, extractorLinkType, netflixProvider$loadLinks$2$1$1, c000916);
                        if (objNewExtractorLink == obj3) {
                            return obj3;
                        }
                        function112 = function121;
                        item = item5;
                        c000913 = c000916;
                        int i4 = $i$f$forEach;
                        Object element$iv5 = element$iv;
                        String token6 = id6;
                        boolean isCasting8 = isCasting4;
                        Iterable $this$forEach$iv5 = $this$forEach$iv2;
                        Object obj6 = obj3;
                        Iterator it8 = it;
                        int $i$f$forEach5 = $i$f$forEach2;
                        String data7 = data6;
                        Function1<? super SubtitleFile, Unit> function122 = function111;
                        int i5 = i;
                        function112.invoke(objNewExtractorLink);
                        netflixProvider = netflixProvider5;
                        continuation2 = continuation4;
                        $i$f$forEach2 = $i$f$forEach5;
                        obj3 = obj6;
                        i = i5;
                        function111 = function122;
                        it2 = it7;
                        data6 = data7;
                        $i$f$forEach = i4;
                        it = it8;
                        isCasting4 = isCasting8;
                        playlist = playlist3;
                        id6 = token6;
                        element$iv = element$iv5;
                        $this$forEach$iv2 = $this$forEach$iv5;
                    }
                    NetflixProvider netflixProvider6 = netflixProvider;
                    Continuation<? super Boolean> continuation5 = continuation2;
                    Object playlist4 = playlist;
                    Function1<? super ExtractorLink, Unit> function123 = function112;
                    item2 = item;
                    C00091 c000917 = c000913;
                    tracks = item2.getTracks();
                    if (tracks == null) {
                        Iterable $this$filter$iv = tracks;
                        int $i$f$filter = 0;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            Function1<? super ExtractorLink, Unit> function124 = function123;
                            Iterable $this$filter$iv2 = $this$filter$iv;
                            int $i$f$filter2 = $i$f$filter;
                            if (Intrinsics.areEqual(((Tracks) element$iv$iv).getKind(), "captions")) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv2;
                            $i$f$filter = $i$f$filter2;
                            function123 = function124;
                        }
                        Function1<? super ExtractorLink, Unit> function125 = function123;
                        Iterable $this$map$iv3 = (List) destination$iv$iv3;
                        $i$f$map = 0;
                        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        Iterator it9 = $this$map$iv3.iterator();
                        playlist2 = playlist4;
                        continuation3 = continuation5;
                        $this$map$iv = $this$map$iv3;
                        $this$mapTo$iv$iv = $this$map$iv3;
                        token3 = id6;
                        function114 = function111;
                        $i$f$forEach3 = $i$f$forEach;
                        netflixProvider2 = netflixProvider6;
                        c000914 = c000917;
                        obj4 = obj3;
                        isCasting5 = isCasting4;
                        $i$f$mapTo = 0;
                        it3 = it9;
                        id7 = id5;
                        destination$iv$iv = destination$iv$iv4;
                        i2 = i;
                        $this$forEach$iv3 = $this$forEach$iv;
                        function115 = function125;
                        if (it3.hasNext()) {
                            Object item$iv$iv2 = it3.next();
                            Tracks track = (Tracks) item$iv$iv2;
                            element$iv2 = title5;
                            Iterable $this$forEach$iv6 = $this$forEach$iv3;
                            String strValueOf = String.valueOf(track.getLabel());
                            id8 = data6;
                            String data8 = ExtractorApiKt.httpsify(StringsKt.replace$default(String.valueOf(track.getFile()), "\\", "", false, 4, (Object) null));
                            Object obj7 = obj4;
                            NetflixProvider$loadLinks$2$3$1 netflixProvider$loadLinks$2$3$1 = new NetflixProvider$loadLinks$2$3$1(netflixProvider2, null);
                            c000914.L$0 = SpillingKt.nullOutSpilledVariable(id8);
                            c000914.L$1 = function114;
                            c000914.L$2 = function115;
                            c000914.L$3 = SpillingKt.nullOutSpilledVariable(element$iv2);
                            c000914.L$4 = SpillingKt.nullOutSpilledVariable(id7);
                            c000914.L$5 = SpillingKt.nullOutSpilledVariable(token3);
                            c000914.L$6 = SpillingKt.nullOutSpilledVariable(playlist2);
                            c000914.L$7 = SpillingKt.nullOutSpilledVariable($this$forEach$iv6);
                            c000914.L$8 = it;
                            c000914.L$9 = SpillingKt.nullOutSpilledVariable(element$iv);
                            c000914.L$10 = SpillingKt.nullOutSpilledVariable(item2);
                            c000914.L$11 = SpillingKt.nullOutSpilledVariable($this$map$iv);
                            c000914.L$12 = SpillingKt.nullOutSpilledVariable($this$mapTo$iv$iv);
                            c000914.L$13 = destination$iv$iv;
                            c000914.L$14 = it3;
                            c000914.L$15 = SpillingKt.nullOutSpilledVariable(item$iv$iv2);
                            c000914.L$16 = SpillingKt.nullOutSpilledVariable(track);
                            c000914.L$17 = destination$iv$iv;
                            c000914.L$18 = function114;
                            c000914.Z$0 = isCasting5;
                            c000914.I$0 = $i$f$forEach3;
                            c000914.I$1 = i2;
                            c000914.I$2 = $i$f$map;
                            c000914.I$3 = $i$f$mapTo;
                            c000914.I$4 = 0;
                            c000914.label = 6;
                            Object objNewSubtitleFile = MainAPIKt.newSubtitleFile(strValueOf, data8, netflixProvider$loadLinks$2$3$1, c000914);
                            if (objNewSubtitleFile == obj7) {
                                return obj7;
                            }
                            isCasting6 = isCasting5;
                            element$iv3 = element$iv;
                            id9 = id7;
                            item3 = item2;
                            $result2 = $result;
                            $this$forEach$iv4 = $this$forEach$iv6;
                            $result3 = playlist2;
                            token4 = token3;
                            destination$iv$iv2 = destination$iv$iv;
                            it4 = it;
                            it5 = it3;
                            $i$f$mapTo2 = $i$f$mapTo;
                            function116 = function114;
                            c000915 = c000914;
                            obj5 = obj7;
                            item$iv$iv = $this$mapTo$iv$iv;
                            i3 = i2;
                            $i$f$forEach4 = $i$f$forEach3;
                            $result4 = objNewSubtitleFile;
                            netflixProvider3 = netflixProvider2;
                            $i$f$map2 = $i$f$map;
                            collection = destination$iv$iv2;
                            $this$map$iv2 = $this$map$iv;
                            function116.invoke($result4);
                            collection.add(Unit.INSTANCE);
                            $this$map$iv = $this$map$iv2;
                            netflixProvider2 = netflixProvider3;
                            destination$iv$iv = destination$iv$iv2;
                            $i$f$map = $i$f$map2;
                            i2 = i3;
                            $i$f$forEach3 = $i$f$forEach4;
                            isCasting5 = isCasting6;
                            c000914 = c000915;
                            obj4 = obj5;
                            it3 = it5;
                            $i$f$mapTo = $i$f$mapTo2;
                            $this$mapTo$iv$iv = item$iv$iv;
                            title5 = element$iv2;
                            it = it4;
                            $this$forEach$iv3 = $this$forEach$iv4;
                            playlist2 = $result3;
                            token3 = token4;
                            data6 = id8;
                            element$iv = element$iv3;
                            id7 = id9;
                            item2 = item3;
                            $result = $result2;
                            if (it3.hasNext()) {
                                String data9 = data6;
                                Object obj8 = obj4;
                                continuation2 = continuation3;
                                netflixProvider4 = netflixProvider2;
                                $i$f$forEach = $i$f$forEach3;
                                function113 = function115;
                                isCasting7 = isCasting5;
                                obj3 = obj8;
                                id5 = id7;
                                $this$forEach$iv = $this$forEach$iv3;
                                data6 = data9;
                                playlist = playlist2;
                                c000912 = c000914;
                                function111 = function114;
                                id6 = token3;
                                function120 = function113;
                                if (!it.hasNext()) {
                                    return Boxing.boxBoolean(z);
                                }
                            }
                        }
                    } else {
                        function113 = function123;
                        playlist = playlist4;
                        continuation2 = continuation5;
                        isCasting7 = isCasting4;
                        netflixProvider4 = netflixProvider6;
                        c000912 = c000917;
                        function120 = function113;
                        if (!it.hasNext()) {
                        }
                    }
                }
                break;
            case 1:
                boolean isCasting9 = c00091.Z$0;
                title = (String) c00091.L$7;
                mainUrl = (String) c00091.L$6;
                String str6 = (String) c00091.L$5;
                String id10 = (String) c00091.L$4;
                data3 = (String) c00091.L$3;
                Function1<? super ExtractorLink, Unit> function126 = (Function1) c00091.L$2;
                Function1<? super SubtitleFile, Unit> function127 = (Function1) c00091.L$1;
                data2 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result4);
                isCasting2 = isCasting9;
                id = id10;
                function14 = function126;
                obj = $result4;
                str = str6;
                function13 = function127;
                Map mapPlus2 = MapsKt.plus((Map) obj, MapsKt.mapOf(TuplesKt.to("user_token", "233123f803cf02184bf6c67e149cdd50")));
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00091.L$1 = function13;
                c00091.L$2 = function14;
                c00091.L$3 = data3;
                c00091.L$4 = id;
                c00091.L$5 = null;
                c00091.L$6 = null;
                c00091.L$7 = null;
                c00091.Z$0 = isCasting2;
                c00091.label = 2;
                videoToken = UtilsKt.getVideoToken(str, mainUrl, title, mapPlus2, c00091);
                if (videoToken != coroutine_suspended) {
                }
                break;
            case 2:
                isCasting3 = c00091.Z$0;
                String id11 = (String) c00091.L$4;
                String title7 = (String) c00091.L$3;
                function16 = (Function1) c00091.L$2;
                function15 = (Function1) c00091.L$1;
                String data10 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result4);
                data2 = data10;
                data3 = title7;
                title2 = id11;
                videoToken = $result4;
                String token52 = (String) videoToken;
                Requests app2 = UtilsKt.getApp();
                String str32 = getMainUrl() + "/playlist.php?id=" + title2 + "&t=" + data3 + "&tm=" + APIHolder.INSTANCE.getUnixTime() + "&h=" + token52;
                Map<String, String> map22 = this.headers;
                String str42 = getMainUrl() + '/';
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00091.L$1 = function15;
                c00091.L$2 = function16;
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00091.L$4 = SpillingKt.nullOutSpilledVariable(title2);
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(token52);
                c00091.L$6 = app2;
                c00091.L$7 = str32;
                c00091.L$8 = map22;
                c00091.L$9 = str42;
                c00091.Z$0 = isCasting3;
                c00091.label = 3;
                cookie = getCookie(c00091);
                if (cookie != coroutine_suspended) {
                }
                break;
            case 3:
                isCasting3 = c00091.Z$0;
                String str7 = (String) c00091.L$9;
                Map<String, String> map3 = (Map) c00091.L$8;
                str2 = (String) c00091.L$7;
                requests = (Requests) c00091.L$6;
                String token7 = (String) c00091.L$5;
                String id12 = (String) c00091.L$4;
                Object title8 = (String) c00091.L$3;
                Function1<? super ExtractorLink, Unit> function128 = (Function1) c00091.L$2;
                Function1<? super SubtitleFile, Unit> function129 = (Function1) c00091.L$1;
                String data11 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result4);
                id3 = str7;
                map = map3;
                cookie = $result4;
                token = token7;
                id2 = id12;
                title3 = title8;
                function18 = function128;
                function17 = function129;
                data4 = data11;
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00091.L$1 = function17;
                c00091.L$2 = function18;
                c00091.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00091.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00091.L$5 = SpillingKt.nullOutSpilledVariable(token);
                c00091.L$6 = null;
                c00091.L$7 = null;
                c00091.L$8 = null;
                c00091.L$9 = null;
                c00091.Z$0 = isCasting3;
                c00091.label = 4;
                Function1<? super ExtractorLink, Unit> function1182 = function18;
                Function1<? super SubtitleFile, Unit> function1192 = function17;
                $result = $result4;
                c000912 = c00091;
                obj2 = coroutine_suspended;
                z = true;
                $result4 = Requests.get$default(requests, str2, map, id3, (Map) null, (Map) cookie, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000912, 4072, (Object) null);
                if ($result4 != obj2) {
                }
                break;
            case 4:
                isCasting3 = c00091.Z$0;
                token2 = (String) c00091.L$5;
                id4 = (String) c00091.L$4;
                title4 = (String) c00091.L$3;
                function110 = (Function1) c00091.L$2;
                function19 = (Function1) c00091.L$1;
                data5 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result4);
                c000912 = c00091;
                $result = $result4;
                obj2 = coroutine_suspended;
                z = true;
                NiceResponse this_$iv2 = (NiceResponse) $result4;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                playlist = (PlayList) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PlayList.class));
                $this$forEach$iv = (Iterable) playlist;
                NetflixProvider netflixProvider42 = this;
                it = $this$forEach$iv.iterator();
                $i$f$forEach = 0;
                data6 = data5;
                function111 = function19;
                Function1<? super ExtractorLink, Unit> function1202 = function110;
                title5 = title4;
                id5 = id4;
                id6 = token2;
                obj3 = obj2;
                boolean isCasting72 = isCasting3;
                continuation2 = continuation;
                if (!it.hasNext()) {
                }
                break;
            case 5:
                int i6 = c00091.I$3;
                int $i$f$forEach6 = c00091.I$2;
                int i7 = c00091.I$1;
                int $i$f$forEach7 = c00091.I$0;
                boolean isCasting10 = c00091.Z$0;
                Function1 function130 = (Function1) c00091.L$15;
                Object obj9 = c00091.L$13;
                Iterator it10 = (Iterator) c00091.L$12;
                Iterable $this$forEach$iv7 = (Iterable) c00091.L$11;
                PlayListItem item6 = (PlayListItem) c00091.L$10;
                Object element$iv6 = c00091.L$9;
                Iterator it11 = (Iterator) c00091.L$8;
                Iterable $this$forEach$iv8 = (Iterable) c00091.L$7;
                Object playlist5 = (PlayList) c00091.L$6;
                String token8 = (String) c00091.L$5;
                String id13 = (String) c00091.L$4;
                Object title9 = (String) c00091.L$3;
                Function1<? super ExtractorLink, Unit> function131 = (Function1) c00091.L$2;
                Function1<? super SubtitleFile, Unit> function132 = (Function1) c00091.L$1;
                String data12 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result4);
                function112 = function131;
                c000913 = c00091;
                $result = $result4;
                item = item6;
                title5 = title9;
                z = true;
                id5 = id13;
                $this$forEach$iv = $this$forEach$iv8;
                function130.invoke($result4);
                netflixProvider = this;
                continuation2 = continuation;
                $i$f$forEach2 = $i$f$forEach6;
                obj3 = coroutine_suspended;
                i = i7;
                function111 = function132;
                it2 = it10;
                data6 = data12;
                $i$f$forEach = $i$f$forEach7;
                it = it11;
                isCasting4 = isCasting10;
                playlist = playlist5;
                id6 = token8;
                element$iv = element$iv6;
                $this$forEach$iv2 = $this$forEach$iv7;
                while (it2.hasNext()) {
                }
                NetflixProvider netflixProvider62 = netflixProvider;
                Continuation<? super Boolean> continuation52 = continuation2;
                Object playlist42 = playlist;
                Function1<? super ExtractorLink, Unit> function1232 = function112;
                item2 = item;
                C00091 c0009172 = c000913;
                tracks = item2.getTracks();
                if (tracks == null) {
                }
                break;
            case 6:
                int i8 = c00091.I$4;
                int $i$f$mapTo3 = c00091.I$3;
                $i$f$map2 = c00091.I$2;
                i3 = c00091.I$1;
                $i$f$forEach4 = c00091.I$0;
                isCasting6 = c00091.Z$0;
                Function1<? super SubtitleFile, Unit> function133 = (Function1) c00091.L$18;
                Collection collection2 = (Collection) c00091.L$17;
                Object obj10 = c00091.L$15;
                Iterator it12 = (Iterator) c00091.L$14;
                Collection destination$iv$iv5 = (Collection) c00091.L$13;
                item$iv$iv = (Iterable) c00091.L$12;
                Iterable $this$map$iv4 = (Iterable) c00091.L$11;
                PlayListItem item7 = (PlayListItem) c00091.L$10;
                Object element$iv7 = c00091.L$9;
                it4 = (Iterator) c00091.L$8;
                $this$forEach$iv4 = (Iterable) c00091.L$7;
                $result3 = (PlayList) c00091.L$6;
                token4 = (String) c00091.L$5;
                String id14 = (String) c00091.L$4;
                Object title10 = (String) c00091.L$3;
                Function1<? super ExtractorLink, Unit> function134 = (Function1) c00091.L$2;
                Function1<? super SubtitleFile, Unit> function135 = (Function1) c00091.L$1;
                String data13 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result4);
                continuation3 = continuation;
                $result2 = $result4;
                it5 = it12;
                $i$f$mapTo2 = $i$f$mapTo3;
                item3 = item7;
                element$iv3 = element$iv7;
                id9 = id14;
                element$iv2 = title10;
                z = true;
                destination$iv$iv2 = destination$iv$iv5;
                function114 = function135;
                id8 = data13;
                $this$map$iv2 = $this$map$iv4;
                function116 = function133;
                c000915 = c00091;
                netflixProvider3 = this;
                collection = collection2;
                obj5 = coroutine_suspended;
                function115 = function134;
                function116.invoke($result4);
                collection.add(Unit.INSTANCE);
                $this$map$iv = $this$map$iv2;
                netflixProvider2 = netflixProvider3;
                destination$iv$iv = destination$iv$iv2;
                $i$f$map = $i$f$map2;
                i2 = i3;
                $i$f$forEach3 = $i$f$forEach4;
                isCasting5 = isCasting6;
                c000914 = c000915;
                obj4 = obj5;
                it3 = it5;
                $i$f$mapTo = $i$f$mapTo2;
                $this$mapTo$iv$iv = item$iv$iv;
                title5 = element$iv2;
                it = it4;
                $this$forEach$iv3 = $this$forEach$iv4;
                playlist2 = $result3;
                token3 = token4;
                data6 = id8;
                element$iv = element$iv3;
                id7 = id9;
                item2 = item3;
                $result = $result2;
                if (it3.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cloudstreamplugins/NetflixProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: compiled from: NetflixProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cloudstreamplugins/NetflixProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
