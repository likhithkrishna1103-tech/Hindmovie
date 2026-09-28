package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/phisher98/AnimeDekhoProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Media", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimeDekhoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,354:1\n1795#2,10:355\n2068#2:365\n2069#2:367\n1805#2:368\n1795#2,10:369\n2068#2:379\n2069#2:381\n1805#2:382\n1739#2:402\n1814#2,3:403\n1795#2,10:427\n2068#2:437\n2069#2:439\n1805#2:440\n1795#2,10:441\n2068#2:451\n2069#2:453\n1805#2:454\n1795#2,10:455\n2068#2:465\n2069#2:468\n1805#2:469\n1739#2:470\n1814#2,3:471\n1#3:366\n1#3:380\n1#3:384\n1#3:406\n1#3:408\n1#3:426\n1#3:438\n1#3:452\n1#3:466\n1#3:467\n1#3:474\n1#3:476\n1#3:494\n63#4:383\n64#4,15:385\n63#4:407\n64#4,15:409\n63#4:475\n64#4,15:477\n50#5:400\n43#5:401\n50#5:424\n43#5:425\n50#5:492\n43#5:493\n*S KotlinDebug\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider\n*L\n50#1:355,10\n50#1:365\n50#1:367\n50#1:368\n71#1:369,10\n71#1:379\n71#1:381\n71#1:382\n88#1:402\n88#1:403,3\n158#1:427,10\n158#1:437\n158#1:439\n158#1:440\n159#1:441,10\n159#1:451\n159#1:453\n159#1:454\n171#1:455,10\n171#1:465\n171#1:468\n171#1:469\n212#1:470\n212#1:471,3\n50#1:366\n71#1:380\n77#1:384\n124#1:408\n158#1:438\n159#1:452\n171#1:467\n247#1:476\n77#1:383\n77#1:385,15\n124#1:407\n124#1:409,15\n247#1:475\n247#1:477,15\n77#1:400\n77#1:401\n124#1:424\n124#1:425\n247#1:492\n247#1:493\n*E\n"})
public class AnimeDekhoProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://animedekho.app";

    @NotNull
    private String name = "Anime Dekho";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Cartoon, TvType.Anime, TvType.AnimeMovie, TvType.Movie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/category/anime/", "Anime"), TuplesKt.to("/category/cartoon/", "Cartoon"), TuplesKt.to("/category/crunchyroll/", "Crunchyroll"), TuplesKt.to("/category/hindi-dub/", "Hindi"), TuplesKt.to("/category/tamil/", "Tamil"), TuplesKt.to("/category/telugu/", "Telugu")});

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$getMainPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 0}, l = {48}, m = "getMainPage$suspendImpl", n = {"$this", "request", "link", "page"}, nl = {50}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return AnimeDekhoProvider.getMainPage$suspendImpl(AnimeDekhoProvider.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {78, 100, 106, 123, 140, 164, 226}, m = "load$suspendImpl", n = {"$this", "url", "media", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "$this$load_u24lambda_u242", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "$this$load_u24lambda_u243", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "aniUrl", "$this$load_u24lambda_u247", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "lst", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "lst", "tmdbIdFinal", "tmdbSeasonData", "apiKey", "episodesList", "seasonsPresent", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "lst", "tmdbIdFinal", "tmdbSeasonData", "apiKey", "episodesList", "seasonsPresent", "episodes", "recommendations"}, nl = {79, 101, 107, 124, 154, 171, 139}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimeDekhoProvider.load$suspendImpl(AnimeDekhoProvider.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {254, 255, 272, 283}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "media", "headers", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "headers", "doc", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "headers", "doc", "$this$loadLinks_u24lambda_u242", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "headers", "doc", "bodyClass", "term", "isCasting"}, nl = {255, 271, 271, 300}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimeDekhoProvider.loadLinks$suspendImpl(AnimeDekhoProvider.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0}, l = {70}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {71}, s = {"L$0", "L$1"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimeDekhoProvider.search$suspendImpl(AnimeDekhoProvider.this, null, (Continuation) this);
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
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<AnimeSearchResponse>> continuation) {
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
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getMainPage$suspendImpl(AnimeDekhoProvider $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        AnonymousClass1 anonymousClass1;
        MainPageRequest request2;
        AnimeDekhoProvider $this2 = $this;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = $this2.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = $this2.new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow($this2.getName());
                String link = $this2.getMainUrl() + request.getData();
                Requests app = MainActivityKt.getApp();
                anonymousClass1.L$0 = $this2;
                anonymousClass1.L$1 = request;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(link);
                anonymousClass1.I$0 = page;
                anonymousClass1.label = 1;
                $result = Requests.get$default(app, link, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, anonymousClass1, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = anonymousClass1.I$0;
                request2 = (MainPageRequest) anonymousClass1.L$1;
                $this2 = (AnimeDekhoProvider) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    private final AnimeSearchResponse toSearchResult(Element $this$toSearchResult) {
        String href;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a.lnk-blk");
        if (elementSelectFirst == null || (href = elementSelectFirst.attr("href")) == null) {
            return null;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("header h2");
        if (elementSelectFirst2 == null || (title = elementSelectFirst2.text()) == null) {
            title = "null";
        }
        final Ref.ObjectRef posterUrl = new Ref.ObjectRef();
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("div figure img");
        posterUrl.element = elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null;
        Object obj = posterUrl.element;
        Intrinsics.checkNotNull(obj);
        if (StringsKt.contains$default((CharSequence) obj, "data:image", false, 2, (Object) null)) {
            Element elementSelectFirst4 = $this$toSearchResult.selectFirst("div figure img");
            posterUrl.element = elementSelectFirst4 != null ? elementSelectFirst4.attr("data-lazy-src") : null;
        }
        return MainAPIKt.newAnimeSearchResponse(this, title, AppUtils.INSTANCE.toJson(new Media(href, (String) posterUrl.element, null, 4, null)), TvType.Anime, false, new Function1() { // from class: com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                return AnimeDekhoProvider.toSearchResult$lambda$0(posterUrl, (AnimeSearchResponse) obj2);
            }
        });
    }

    static final Unit toSearchResult$lambda$0(Ref.ObjectRef $posterUrl, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl((String) $posterUrl.element);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object search$suspendImpl(AnimeDekhoProvider $this, String query, Continuation<? super List<AnimeSearchResponse>> continuation) {
        C00031 c00031;
        AnimeDekhoProvider $this2 = $this;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this2.new C00031(continuation);
            }
        } else {
            c00031 = $this2.new C00031(continuation);
        }
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = $this2.getMainUrl() + "/?s=" + query;
                c00031.L$0 = $this2;
                c00031.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00031.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00031, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                $this2 = (AnimeDekhoProvider) c00031.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("ul[data-results] li article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:283:0x0ba2 A[Catch: all -> 0x0c60, TryCatch #0 {all -> 0x0c60, blocks: (B:257:0x0b40, B:260:0x0b47, B:278:0x0b8a, B:280:0x0b96, B:281:0x0b9c, B:283:0x0ba2, B:288:0x0bc1, B:290:0x0bc5, B:292:0x0bcb, B:294:0x0bd7, B:295:0x0bdd, B:297:0x0be3, B:302:0x0c02, B:304:0x0c06, B:306:0x0c0c, B:308:0x0c12, B:310:0x0c1c, B:312:0x0c22, B:313:0x0c24, B:315:0x0c28, B:317:0x0c32, B:319:0x0c38, B:320:0x0c3a, B:277:0x0b6f, B:275:0x0b66, B:256:0x0b36), top: B:497:0x0b40 }] */
    /* JADX WARN: Code duplicated, block: B:286:0x0bbd A[LOOP:3: B:281:0x0b9c->B:286:0x0bbd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:562:0x0bba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v42, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v45, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v136 */
    /* JADX WARN: Type inference failed for: r23v36 */
    /* JADX WARN: Type inference failed for: r23v48 */
    /* JADX WARN: Type inference failed for: r23v49 */
    /* JADX WARN: Type inference failed for: r32v25 */
    /* JADX WARN: Type inference failed for: r32v32 */
    /* JADX WARN: Type inference failed for: r32v33 */
    /* JADX WARN: Type inference failed for: r51v0 */
    /* JADX WARN: Type inference failed for: r51v2, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r51v4 */
    /* JADX WARN: Type inference failed for: r55v11, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r55v12 */
    /* JADX WARN: Type inference failed for: r55v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:234:0x0a9d -> B:521:0x0ac4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:336:0x0d88 -> B:337:0x0dad). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object load$suspendImpl(com.phisher98.AnimeDekhoProvider r73, java.lang.String r74, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r75) {
        /*
            Method dump skipped, instruction units count: 5400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.AnimeDekhoProvider.load$suspendImpl(com.phisher98.AnimeDekhoProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$4, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$load$4", f = "AnimeDekhoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $anilist_id;
        final /* synthetic */ Ref.ObjectRef<String> $backgroundPoster;
        final /* synthetic */ Ref.ObjectRef<Integer> $mal_id;
        final /* synthetic */ Ref.ObjectRef<String> $metaPoster;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef<String> objectRef, String str, Ref.ObjectRef<String> objectRef2, String str2, Integer num, List<String> list, Ref.ObjectRef<Integer> objectRef3, Ref.ObjectRef<Integer> objectRef4, String str3, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$metaPoster = objectRef;
            this.$poster = str;
            this.$backgroundPoster = objectRef2;
            this.$plot = str2;
            this.$year = num;
            this.$tags = list;
            this.$mal_id = objectRef3;
            this.$anilist_id = objectRef4;
            this.$tmdbId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$metaPoster, this.$poster, this.$backgroundPoster, this.$plot, this.$year, this.$tags, this.$mal_id, this.$anilist_id, this.$tmdbId, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = (String) this.$metaPoster.element;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setPosterUrl(str);
                    String str2 = (String) this.$backgroundPoster.element;
                    if (str2 == null) {
                        str2 = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    loadResponse.setPlot(this.$plot);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    LoadResponse.Companion.addMalId(loadResponse, (Integer) this.$mal_id.element);
                    LoadResponse.Companion.addAniListId(loadResponse, (Integer) this.$anilist_id.element);
                    LoadResponse.Companion.addTMDbId(loadResponse, this.$tmdbId);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$5, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "s", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$load$5", f = "AnimeDekhoProvider.kt", i = {0}, l = {165}, m = "invokeSuspend", n = {"s"}, nl = {355}, s = {"I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnimeDekhoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider$load$5\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,354:1\n73#2,5:355\n*S KotlinDebug\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider$load$5\n*L\n165#1:355,5\n*E\n"})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apiKey;
        final /* synthetic */ Object $tmdbIdFinal;
        final /* synthetic */ Map<Integer, TmdbSeasonResponse> $tmdbSeasonData;
        /* synthetic */ int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Object obj, String str, Map<Integer, TmdbSeasonResponse> map, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$tmdbIdFinal = obj;
            this.$apiKey = str;
            this.$tmdbSeasonData = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$tmdbIdFinal, this.$apiKey, this.$tmdbSeasonData, continuation);
            anonymousClass5.I$0 = ((Number) obj).intValue();
            return anonymousClass5;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            Object safe;
            int s = this.I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    Object obj2 = this.$tmdbIdFinal;
                    String str = this.$apiKey;
                    this.I$0 = s;
                    this.label = 1;
                    obj = Requests.get$default(app, "https://api.themoviedb.org/3/tv/" + obj2 + "/season/" + s + "?api_key=" + str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) obj;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(TmdbSeasonResponse.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                safe = null;
            }
            TmdbSeasonResponse res = (TmdbSeasonResponse) safe;
            if (res != null) {
                this.$tmdbSeasonData.put(Boxing.boxInt(s), res);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x014a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x014c  */
    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:15:0x002b  */
    /* JADX WARN: Code duplicated, block: B:17:0x002e  */
    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00be  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00eb  */
    public static final Unit load$lambda$11$1(TmdbEpisode $tmdbEp, MetaEpisode $meta, String $name, String $poster, Integer $season, Integer $epNum, Episode $this$newEpisode) {
        String it;
        Map<String, String> title;
        Map<String, String> title2;
        String it2;
        String image;
        String it3;
        String airDate;
        String it4;
        Integer runtime;
        String it5;
        Integer runtime2 = null;
        if ($tmdbEp == null || (it = $tmdbEp.getName()) == null) {
            if ($meta != null || (title2 = $meta.getTitle()) == null) {
                it = null;
            } else {
                it = title2.get("en");
            }
            if (it == null) {
                if ($meta != null || (title = $meta.getTitle()) == null) {
                    it = null;
                } else {
                    it = title.get("x-jat");
                }
                if (it == null) {
                    it = $name;
                }
            }
        } else {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                if ($meta != null) {
                    it = null;
                } else {
                    it = null;
                }
                if (it == null) {
                    if ($meta != null) {
                        it = null;
                    } else {
                        it = null;
                    }
                    if (it == null) {
                        it = $name;
                    }
                }
            }
        }
        $this$newEpisode.setName(it);
        if ($tmdbEp == null || (it5 = $tmdbEp.getStill_path()) == null) {
            it2 = null;
        } else {
            if (!((StringsKt.isBlank(it5) || Intrinsics.areEqual(it5, "null")) ? false : true)) {
                it5 = null;
            }
            if (it5 != null) {
                it2 = "https://image.tmdb.org/t/p/w500" + it5;
            } else {
                it2 = null;
            }
        }
        if (it2 == null) {
            image = $meta != null ? $meta.getImage() : null;
            if (image == null) {
                image = $poster;
            }
        } else {
            image = it2;
        }
        $this$newEpisode.setPosterUrl(image);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode($epNum);
        if ($tmdbEp != null && (it3 = $tmdbEp.getOverview()) != null) {
            if (StringsKt.isBlank(it3)) {
                it3 = null;
            }
            if (it3 == null) {
                if ($meta != null) {
                    it3 = $meta.getOverview();
                } else {
                    it3 = null;
                }
            }
        } else if ($meta != null) {
            it3 = $meta.getOverview();
        } else {
            it3 = null;
        }
        $this$newEpisode.setDescription(it3);
        if ($tmdbEp != null && (airDate = $tmdbEp.getAir_date()) != null) {
            if (!((StringsKt.isBlank(airDate) || Intrinsics.areEqual(airDate, "null")) ? false : true)) {
                airDate = null;
            }
            if (airDate == null) {
                if ($meta != null) {
                    airDate = $meta.getAirDateUtc();
                } else {
                    airDate = null;
                }
            }
        } else if ($meta != null) {
            airDate = $meta.getAirDateUtc();
        } else {
            airDate = null;
        }
        if (airDate != null) {
            String it6 = airDate;
            MainAPIKt.addDate$default($this$newEpisode, it6, (String) null, 2, (Object) null);
        }
        Double vote = $tmdbEp != null ? $tmdbEp.getVote_average() : null;
        if (vote != null && vote.doubleValue() > 0.0d) {
            $this$newEpisode.setScore(Score.Companion.from10(String.valueOf(vote.doubleValue())));
        } else if ($meta != null && (it4 = $meta.getRating()) != null) {
            $this$newEpisode.setScore(Score.Companion.from10(it4));
        }
        if ($tmdbEp != null && (runtime = $tmdbEp.getRuntime()) != null) {
            int it7 = runtime.intValue();
            if (!(it7 > 0)) {
                runtime = null;
            }
            if (runtime != null) {
                runtime2 = runtime;
            } else if ($meta != null) {
                runtime2 = $meta.getRuntime();
            }
        } else if ($meta != null) {
            runtime2 = $meta.getRuntime();
        }
        $this$newEpisode.setRunTime(runtime2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$12$0(Media $mediadata, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($mediadata.getPoster());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$6, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$load$6", f = "AnimeDekhoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nAnimeDekhoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,354:1\n1#2:355\n*E\n"})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $anilist_id;
        final /* synthetic */ Ref.ObjectRef<String> $backgroundPoster;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ Ref.ObjectRef<Integer> $mal_id;
        final /* synthetic */ Ref.ObjectRef<String> $metaPoster;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<AnimeSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(List<Episode> list, Ref.ObjectRef<String> objectRef, String str, Ref.ObjectRef<String> objectRef2, String str2, Integer num, List<String> list2, List<AnimeSearchResponse> list3, Ref.ObjectRef<Integer> objectRef3, Ref.ObjectRef<Integer> objectRef4, String str3, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.$metaPoster = objectRef;
            this.$poster = str;
            this.$backgroundPoster = objectRef2;
            this.$plot = str2;
            this.$year = num;
            this.$tags = list2;
            this.$recommendations = list3;
            this.$mal_id = objectRef3;
            this.$anilist_id = objectRef4;
            this.$tmdbId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass6 = new AnonymousClass6(this.$episodes, this.$metaPoster, this.$poster, this.$backgroundPoster, this.$plot, this.$year, this.$tags, this.$recommendations, this.$mal_id, this.$anilist_id, this.$tmdbId, continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    String str = (String) this.$metaPoster.element;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setPosterUrl(str);
                    String str2 = (String) this.$backgroundPoster.element;
                    if (str2 == null) {
                        str2 = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    loadResponse.setPlot(this.$plot);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setRecommendations(this.$recommendations);
                    Integer num = (Integer) this.$mal_id.element;
                    if (num != null) {
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(num.intValue()));
                    }
                    Integer num2 = (Integer) this.$anilist_id.element;
                    if (num2 != null) {
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(num2.intValue()));
                    }
                    String it = this.$tmdbId;
                    if (it != null) {
                        LoadResponse.Companion.addTMDbId(loadResponse, it);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0374  */
    /* JADX WARN: Code duplicated, block: B:104:0x037b  */
    /* JADX WARN: Code duplicated, block: B:108:0x0384  */
    /* JADX WARN: Code duplicated, block: B:110:0x0387  */
    /* JADX WARN: Code duplicated, block: B:112:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:114:0x03fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:118:0x040b  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x021c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x021d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0264 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x0265  */
    /* JADX WARN: Code duplicated, block: B:74:0x02d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x02f3 A[Catch: all -> 0x0300, TryCatch #0 {all -> 0x0300, blocks: (B:76:0x02e5, B:78:0x02f3, B:80:0x02fb), top: B:120:0x02e5 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:91:0x0347  */
    /* JADX WARN: Code duplicated, block: B:94:0x0355  */
    /* JADX WARN: Code duplicated, block: B:95:0x0358  */
    /* JADX WARN: Code duplicated, block: B:98:0x0364  */
    static /* synthetic */ Object loadLinks$suspendImpl(AnimeDekhoProvider $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00021 c00021;
        Object obj;
        Throwable it;
        Media media;
        Map headers;
        String str;
        Object obj2;
        int i;
        Object obj3;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Media media2;
        Map headers2;
        AnimeDekhoProvider $this2;
        Object obj4;
        boolean isCasting2;
        Object obj5;
        Object obj6;
        Object objDecodeFromString;
        Document doc;
        List listSelect;
        AnonymousClass2 anonymousClass2;
        Document doc2;
        Map headers3;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String data3;
        boolean isCasting3;
        AnimeDekhoProvider $this3;
        AnimeDekhoProvider $this4;
        String data4;
        Document doc3;
        Map headers4;
        Media media3;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        boolean isCasting4;
        Function1<? super SubtitleFile, Unit> function9;
        Function1<? super ExtractorLink, Unit> function10;
        boolean isCasting5;
        Media media4;
        C00021 c00022;
        Object obj7;
        Object obj8;
        String data5;
        Function1<? super SubtitleFile, Unit> function11;
        boolean isCasting6;
        Document doc4;
        Map headers5;
        Media media5;
        Function1<? super ExtractorLink, Unit> function12;
        AnimeDekhoProvider $this5;
        String bodyClass;
        String str2;
        MatchResult matchResultFind$default;
        String term;
        String str3;
        boolean z;
        List list;
        AnonymousClass3 anonymousClass3;
        List groupValues;
        Element elementSelectFirst;
        String strAttr;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = $this.new C00021(continuation);
            }
        } else {
            c00021 = $this.new C00021(continuation);
        }
        C00021 c00023 = c00021;
        Object $result = c00023.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00023.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion2 = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(Media.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj5 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.Companion;
                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj5) == null) {
                        obj6 = null;
                    } else {
                        try {
                            Result.Companion companion4 = Result.Companion;
                            obj6 = null;
                            try {
                                obj5 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Media.class), (List) null, 2, (Object) null));
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    Result.Companion companion5 = Result.Companion;
                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Throwable th3) {
                                    th = th3;
                                    Result.Companion companion6 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj6 = null;
                        }
                    }
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = obj6;
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.AnimeDekhoProvider$loadLinks$lambda$0$$inlined$parseJson$1
                            });
                        } catch (Throwable th5) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.AnimeDekhoProvider$loadLinks$lambda$0$$inlined$parseJson$1
                            });
                        }
                        obj = Result.constructor-impl((Media) objDecodeFromString);
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            Log.INSTANCE.e("Error:", "Failed to parse media JSON " + it);
                            return Boxing.boxBoolean(false);
                        }
                        media = (Media) obj;
                        headers = MapsKt.mapOf(TuplesKt.to("Cookie", "toronites_server=vidstream"));
                        Requests app = MainActivityKt.getApp();
                        String url = media.getUrl();
                        c00023.L$0 = $this;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(data);
                        c00023.L$2 = function1;
                        c00023.L$3 = function2;
                        c00023.L$4 = media;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                        c00023.Z$0 = isCasting;
                        c00023.label = 1;
                        str = "Error:";
                        obj2 = coroutine_suspended;
                        i = 2;
                        obj3 = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4092, (Object) null);
                        if (obj3 == obj2) {
                            c00023 = c00023;
                            return obj2;
                        }
                        c00023 = c00023;
                        data2 = data;
                        function3 = function1;
                        function4 = function2;
                        media2 = media;
                        headers2 = headers;
                        $this2 = $this;
                        obj4 = obj3;
                        isCasting2 = isCasting;
                        doc = ((NiceResponse) obj4).getDocument();
                        listSelect = doc.select("iframe.serversel[src]");
                        anonymousClass2 = $this2.new AnonymousClass2(function3, function4, null);
                        c00023.L$0 = $this2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00023.L$2 = function3;
                        c00023.L$3 = function4;
                        c00023.L$4 = media2;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                        c00023.Z$0 = isCasting2;
                        c00023.label = i;
                        if (ParCollectionsKt.amap(listSelect, anonymousClass2, c00023) == obj2) {
                            return obj2;
                        }
                        doc2 = doc;
                        headers3 = headers2;
                        function5 = function4;
                        function6 = function3;
                        data3 = data2;
                        isCasting3 = isCasting2;
                        $this3 = $this2;
                        try {
                            Result.Companion companion7 = Result.Companion;
                            AnimeDekhoProvider $this$loadLinks_u24lambda_u242 = $this3;
                            Requests app2 = MainActivityKt.getApp();
                            String url2 = media2.getUrl();
                            c00023.L$0 = $this3;
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                            c00023.L$2 = function6;
                            c00023.L$3 = function5;
                            c00023.L$4 = media2;
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                            c00023.L$7 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u242);
                            c00023.Z$0 = isCasting3;
                            c00023.label = 3;
                            function9 = function6;
                            function10 = function5;
                            isCasting5 = isCasting3;
                            media4 = media2;
                            c00022 = c00023;
                            $this4 = $this3;
                            try {
                                $result = Requests.get$default(app2, url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                                c00023 = c00022;
                                if ($result == obj2) {
                                    return obj2;
                                }
                                data4 = data3;
                                doc3 = doc2;
                                headers4 = headers3;
                                media3 = media4;
                                function7 = function9;
                                function8 = function10;
                                isCasting4 = isCasting5;
                                try {
                                    elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                                    if (elementSelectFirst != null) {
                                        strAttr = elementSelectFirst.attr("class");
                                    } else {
                                        strAttr = null;
                                    }
                                    obj7 = Result.constructor-impl(strAttr);
                                } catch (Throwable th6) {
                                    th = th6;
                                    Result.Companion companion8 = Result.Companion;
                                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                obj8 = obj7;
                                data5 = data4;
                                function11 = function7;
                                isCasting6 = isCasting4;
                                doc4 = doc3;
                                headers5 = headers4;
                                media5 = media3;
                                function12 = function8;
                                $this5 = $this4;
                                if (Result.isFailure-impl(obj8)) {
                                    obj8 = null;
                                }
                                bodyClass = (String) obj8;
                                Regex regex = new Regex("(?:term|postid)-(\\d+)");
                                if (bodyClass == null) {
                                    str2 = "";
                                } else {
                                    str2 = bodyClass;
                                }
                                matchResultFind$default = Regex.find$default(regex, str2, 0, i, (Object) null);
                                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                                    term = null;
                                } else {
                                    term = (String) CollectionsKt.getOrNull(groupValues, 1);
                                }
                                str3 = term;
                                if (str3 != null || str3.length() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                                    return Boxing.boxBoolean(false);
                                }
                                list = CollectionsKt.toList(new IntRange(0, 10));
                                anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                                c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                                c00023.Z$0 = isCasting6;
                                c00023.label = 4;
                                if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                                    return obj2;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                c00023 = c00022;
                                data4 = data3;
                                doc3 = doc2;
                                headers4 = headers3;
                                media3 = media4;
                                function7 = function9;
                                function8 = function10;
                                isCasting4 = isCasting5;
                                Result.Companion companion9 = Result.Companion;
                                obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                obj8 = obj7;
                                data5 = data4;
                                function11 = function7;
                                isCasting6 = isCasting4;
                                doc4 = doc3;
                                headers5 = headers4;
                                media5 = media3;
                                function12 = function8;
                                $this5 = $this4;
                                if (Result.isFailure-impl(obj8)) {
                                    obj8 = null;
                                }
                                bodyClass = (String) obj8;
                                Regex regex2 = new Regex("(?:term|postid)-(\\d+)");
                                if (bodyClass == null) {
                                    str2 = "";
                                } else {
                                    str2 = bodyClass;
                                }
                                matchResultFind$default = Regex.find$default(regex2, str2, 0, i, (Object) null);
                                if (matchResultFind$default != null) {
                                    term = null;
                                } else {
                                    term = null;
                                }
                                str3 = term;
                                if (str3 != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                                    return Boxing.boxBoolean(false);
                                }
                                list = CollectionsKt.toList(new IntRange(0, 10));
                                anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                                c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                                c00023.Z$0 = isCasting6;
                                c00023.label = 4;
                                if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                                    return obj2;
                                }
                                return Boxing.boxBoolean(true);
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            $this4 = $this3;
                            boolean z2 = isCasting3;
                            data4 = data3;
                            doc3 = doc2;
                            headers4 = headers3;
                            media3 = media2;
                            function7 = function6;
                            function8 = function5;
                            isCasting4 = z2;
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<Media>() { // from class: com.phisher98.AnimeDekhoProvider$loadLinks$lambda$0$$inlined$parseJson$1
                        });
                        obj = Result.constructor-impl((Media) objDecodeFromString);
                        it = Result.exceptionOrNull-impl(obj);
                        if (it != null) {
                            Log.INSTANCE.e("Error:", "Failed to parse media JSON " + it);
                            return Boxing.boxBoolean(false);
                        }
                        media = (Media) obj;
                        headers = MapsKt.mapOf(TuplesKt.to("Cookie", "toronites_server=vidstream"));
                        Requests app3 = MainActivityKt.getApp();
                        String url3 = media.getUrl();
                        c00023.L$0 = $this;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(data);
                        c00023.L$2 = function1;
                        c00023.L$3 = function2;
                        c00023.L$4 = media;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                        c00023.Z$0 = isCasting;
                        c00023.label = 1;
                        str = "Error:";
                        obj2 = coroutine_suspended;
                        i = 2;
                        obj3 = Requests.get$default(app3, url3, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4092, (Object) null);
                        if (obj3 == obj2) {
                            c00023 = c00023;
                            return obj2;
                        }
                        c00023 = c00023;
                        data2 = data;
                        function3 = function1;
                        function4 = function2;
                        media2 = media;
                        headers2 = headers;
                        $this2 = $this;
                        obj4 = obj3;
                        isCasting2 = isCasting;
                        doc = ((NiceResponse) obj4).getDocument();
                        listSelect = doc.select("iframe.serversel[src]");
                        anonymousClass2 = $this2.new AnonymousClass2(function3, function4, null);
                        c00023.L$0 = $this2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00023.L$2 = function3;
                        c00023.L$3 = function4;
                        c00023.L$4 = media2;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                        c00023.Z$0 = isCasting2;
                        c00023.label = i;
                        if (ParCollectionsKt.amap(listSelect, anonymousClass2, c00023) == obj2) {
                            return obj2;
                        }
                        doc2 = doc;
                        headers3 = headers2;
                        function5 = function4;
                        function6 = function3;
                        data3 = data2;
                        isCasting3 = isCasting2;
                        $this3 = $this2;
                        Result.Companion companion10 = Result.Companion;
                        AnimeDekhoProvider $this$loadLinks_u24lambda_u243 = $this3;
                        Requests app4 = MainActivityKt.getApp();
                        String url4 = media2.getUrl();
                        c00023.L$0 = $this3;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                        c00023.L$2 = function6;
                        c00023.L$3 = function5;
                        c00023.L$4 = media2;
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u243);
                        c00023.Z$0 = isCasting3;
                        c00023.label = 3;
                        function9 = function6;
                        function10 = function5;
                        isCasting5 = isCasting3;
                        media4 = media2;
                        c00022 = c00023;
                        $this4 = $this3;
                        $result = Requests.get$default(app4, url4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                        c00023 = c00022;
                        if ($result == obj2) {
                            return obj2;
                        }
                        data4 = data3;
                        doc3 = doc2;
                        headers4 = headers3;
                        media3 = media4;
                        function7 = function9;
                        function8 = function10;
                        isCasting4 = isCasting5;
                        elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                        if (elementSelectFirst != null) {
                            strAttr = elementSelectFirst.attr("class");
                        } else {
                            strAttr = null;
                        }
                        obj7 = Result.constructor-impl(strAttr);
                        obj8 = obj7;
                        data5 = data4;
                        function11 = function7;
                        isCasting6 = isCasting4;
                        doc4 = doc3;
                        headers5 = headers4;
                        media5 = media3;
                        function12 = function8;
                        $this5 = $this4;
                        if (Result.isFailure-impl(obj8)) {
                            obj8 = null;
                        }
                        bodyClass = (String) obj8;
                        Regex regex3 = new Regex("(?:term|postid)-(\\d+)");
                        if (bodyClass == null) {
                            str2 = "";
                        } else {
                            str2 = bodyClass;
                        }
                        matchResultFind$default = Regex.find$default(regex3, str2, 0, i, (Object) null);
                        if (matchResultFind$default != null) {
                            term = null;
                        } else {
                            term = null;
                        }
                        str3 = term;
                        if (str3 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                            return Boxing.boxBoolean(false);
                        }
                        list = CollectionsKt.toList(new IntRange(0, 10));
                        anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                        c00023.Z$0 = isCasting6;
                        c00023.label = 4;
                        if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                            return obj2;
                        }
                    }
                    break;
                } catch (Throwable th9) {
                    th = th9;
                    Result.Companion companion11 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    it = Result.exceptionOrNull-impl(obj);
                    if (it != null) {
                        Log.INSTANCE.e("Error:", "Failed to parse media JSON " + it);
                        return Boxing.boxBoolean(false);
                    }
                    media = (Media) obj;
                    headers = MapsKt.mapOf(TuplesKt.to("Cookie", "toronites_server=vidstream"));
                    Requests app5 = MainActivityKt.getApp();
                    String url5 = media.getUrl();
                    c00023.L$0 = $this;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(data);
                    c00023.L$2 = function1;
                    c00023.L$3 = function2;
                    c00023.L$4 = media;
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                    c00023.Z$0 = isCasting;
                    c00023.label = 1;
                    str = "Error:";
                    obj2 = coroutine_suspended;
                    i = 2;
                    obj3 = Requests.get$default(app5, url5, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4092, (Object) null);
                    if (obj3 == obj2) {
                        c00023 = c00023;
                        return obj2;
                    }
                    c00023 = c00023;
                    data2 = data;
                    function3 = function1;
                    function4 = function2;
                    media2 = media;
                    headers2 = headers;
                    $this2 = $this;
                    obj4 = obj3;
                    isCasting2 = isCasting;
                    doc = ((NiceResponse) obj4).getDocument();
                    listSelect = doc.select("iframe.serversel[src]");
                    anonymousClass2 = $this2.new AnonymousClass2(function3, function4, null);
                    c00023.L$0 = $this2;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                    c00023.L$2 = function3;
                    c00023.L$3 = function4;
                    c00023.L$4 = media2;
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                    c00023.Z$0 = isCasting2;
                    c00023.label = i;
                    if (ParCollectionsKt.amap(listSelect, anonymousClass2, c00023) == obj2) {
                        return obj2;
                    }
                    doc2 = doc;
                    headers3 = headers2;
                    function5 = function4;
                    function6 = function3;
                    data3 = data2;
                    isCasting3 = isCasting2;
                    $this3 = $this2;
                    Result.Companion companion12 = Result.Companion;
                    AnimeDekhoProvider $this$loadLinks_u24lambda_u244 = $this3;
                    Requests app6 = MainActivityKt.getApp();
                    String url6 = media2.getUrl();
                    c00023.L$0 = $this3;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                    c00023.L$2 = function6;
                    c00023.L$3 = function5;
                    c00023.L$4 = media2;
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u244);
                    c00023.Z$0 = isCasting3;
                    c00023.label = 3;
                    function9 = function6;
                    function10 = function5;
                    isCasting5 = isCasting3;
                    media4 = media2;
                    c00022 = c00023;
                    $this4 = $this3;
                    $result = Requests.get$default(app6, url6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                    c00023 = c00022;
                    if ($result == obj2) {
                        return obj2;
                    }
                    data4 = data3;
                    doc3 = doc2;
                    headers4 = headers3;
                    media3 = media4;
                    function7 = function9;
                    function8 = function10;
                    isCasting4 = isCasting5;
                    elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("class");
                    } else {
                        strAttr = null;
                    }
                    obj7 = Result.constructor-impl(strAttr);
                    obj8 = obj7;
                    data5 = data4;
                    function11 = function7;
                    isCasting6 = isCasting4;
                    doc4 = doc3;
                    headers5 = headers4;
                    media5 = media3;
                    function12 = function8;
                    $this5 = $this4;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    bodyClass = (String) obj8;
                    Regex regex4 = new Regex("(?:term|postid)-(\\d+)");
                    if (bodyClass == null) {
                        str2 = "";
                    } else {
                        str2 = bodyClass;
                    }
                    matchResultFind$default = Regex.find$default(regex4, str2, 0, i, (Object) null);
                    if (matchResultFind$default != null) {
                        term = null;
                    } else {
                        term = null;
                    }
                    str3 = term;
                    if (str3 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                        return Boxing.boxBoolean(false);
                    }
                    list = CollectionsKt.toList(new IntRange(0, 10));
                    anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                    c00023.Z$0 = isCasting6;
                    c00023.label = 4;
                    if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                        return obj2;
                    }
                    return Boxing.boxBoolean(true);
                }
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting7 = c00023.Z$0;
                headers2 = (Map) c00023.L$5;
                media2 = (Media) c00023.L$4;
                function4 = (Function1) c00023.L$3;
                function3 = (Function1) c00023.L$2;
                data2 = (String) c00023.L$1;
                AnimeDekhoProvider $this6 = (AnimeDekhoProvider) c00023.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                str = "Error:";
                isCasting2 = isCasting7;
                $this2 = $this6;
                obj4 = $result;
                i = 2;
                doc = ((NiceResponse) obj4).getDocument();
                listSelect = doc.select("iframe.serversel[src]");
                anonymousClass2 = $this2.new AnonymousClass2(function3, function4, null);
                c00023.L$0 = $this2;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00023.L$2 = function3;
                c00023.L$3 = function4;
                c00023.L$4 = media2;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc);
                c00023.Z$0 = isCasting2;
                c00023.label = i;
                if (ParCollectionsKt.amap(listSelect, anonymousClass2, c00023) == obj2) {
                    return obj2;
                }
                doc2 = doc;
                headers3 = headers2;
                function5 = function4;
                function6 = function3;
                data3 = data2;
                isCasting3 = isCasting2;
                $this3 = $this2;
                Result.Companion companion13 = Result.Companion;
                AnimeDekhoProvider $this$loadLinks_u24lambda_u245 = $this3;
                Requests app7 = MainActivityKt.getApp();
                String url7 = media2.getUrl();
                c00023.L$0 = $this3;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                c00023.L$2 = function6;
                c00023.L$3 = function5;
                c00023.L$4 = media2;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u245);
                c00023.Z$0 = isCasting3;
                c00023.label = 3;
                function9 = function6;
                function10 = function5;
                isCasting5 = isCasting3;
                media4 = media2;
                c00022 = c00023;
                $this4 = $this3;
                $result = Requests.get$default(app7, url7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                c00023 = c00022;
                if ($result == obj2) {
                    return obj2;
                }
                data4 = data3;
                doc3 = doc2;
                headers4 = headers3;
                media3 = media4;
                function7 = function9;
                function8 = function10;
                isCasting4 = isCasting5;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("class");
                } else {
                    strAttr = null;
                }
                obj7 = Result.constructor-impl(strAttr);
                obj8 = obj7;
                data5 = data4;
                function11 = function7;
                isCasting6 = isCasting4;
                doc4 = doc3;
                headers5 = headers4;
                media5 = media3;
                function12 = function8;
                $this5 = $this4;
                if (Result.isFailure-impl(obj8)) {
                    obj8 = null;
                }
                bodyClass = (String) obj8;
                Regex regex5 = new Regex("(?:term|postid)-(\\d+)");
                if (bodyClass == null) {
                    str2 = "";
                } else {
                    str2 = bodyClass;
                }
                matchResultFind$default = Regex.find$default(regex5, str2, 0, i, (Object) null);
                if (matchResultFind$default != null) {
                    term = null;
                } else {
                    term = null;
                }
                str3 = term;
                if (str3 != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                    return Boxing.boxBoolean(false);
                }
                list = CollectionsKt.toList(new IntRange(0, 10));
                anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                c00023.Z$0 = isCasting6;
                c00023.label = 4;
                if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting8 = c00023.Z$0;
                Document doc5 = (Document) c00023.L$6;
                Map headers6 = (Map) c00023.L$5;
                Media media6 = (Media) c00023.L$4;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00023.L$3;
                Function1<? super SubtitleFile, Unit> function14 = (Function1) c00023.L$2;
                String data6 = (String) c00023.L$1;
                AnimeDekhoProvider $this7 = (AnimeDekhoProvider) c00023.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = coroutine_suspended;
                str = "Error:";
                doc2 = doc5;
                headers3 = headers6;
                media2 = media6;
                function5 = function13;
                function6 = function14;
                data3 = data6;
                isCasting3 = isCasting8;
                $this3 = $this7;
                i = 2;
                Result.Companion companion14 = Result.Companion;
                AnimeDekhoProvider $this$loadLinks_u24lambda_u246 = $this3;
                Requests app8 = MainActivityKt.getApp();
                String url8 = media2.getUrl();
                c00023.L$0 = $this3;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                c00023.L$2 = function6;
                c00023.L$3 = function5;
                c00023.L$4 = media2;
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc2);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u246);
                c00023.Z$0 = isCasting3;
                c00023.label = 3;
                function9 = function6;
                function10 = function5;
                isCasting5 = isCasting3;
                media4 = media2;
                c00022 = c00023;
                $this4 = $this3;
                $result = Requests.get$default(app8, url8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                c00023 = c00022;
                if ($result == obj2) {
                    return obj2;
                }
                data4 = data3;
                doc3 = doc2;
                headers4 = headers3;
                media3 = media4;
                function7 = function9;
                function8 = function10;
                isCasting4 = isCasting5;
                elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("class");
                } else {
                    strAttr = null;
                }
                obj7 = Result.constructor-impl(strAttr);
                obj8 = obj7;
                data5 = data4;
                function11 = function7;
                isCasting6 = isCasting4;
                doc4 = doc3;
                headers5 = headers4;
                media5 = media3;
                function12 = function8;
                $this5 = $this4;
                if (Result.isFailure-impl(obj8)) {
                    obj8 = null;
                }
                bodyClass = (String) obj8;
                Regex regex6 = new Regex("(?:term|postid)-(\\d+)");
                if (bodyClass == null) {
                    str2 = "";
                } else {
                    str2 = bodyClass;
                }
                matchResultFind$default = Regex.find$default(regex6, str2, 0, i, (Object) null);
                if (matchResultFind$default != null) {
                    term = null;
                } else {
                    term = null;
                }
                str3 = term;
                if (str3 != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                    return Boxing.boxBoolean(false);
                }
                list = CollectionsKt.toList(new IntRange(0, 10));
                anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                c00023.Z$0 = isCasting6;
                c00023.label = 4;
                if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(true);
            case 3:
                isCasting4 = c00023.Z$0;
                doc3 = (Document) c00023.L$6;
                headers4 = (Map) c00023.L$5;
                media3 = (Media) c00023.L$4;
                function8 = (Function1) c00023.L$3;
                function7 = (Function1) c00023.L$2;
                data4 = (String) c00023.L$1;
                AnimeDekhoProvider $this8 = (AnimeDekhoProvider) c00023.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this4 = $this8;
                    obj2 = coroutine_suspended;
                    str = "Error:";
                    i = 2;
                    elementSelectFirst = ((NiceResponse) $result).getDocument().selectFirst("body");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("class");
                    } else {
                        strAttr = null;
                    }
                    obj7 = Result.constructor-impl(strAttr);
                    break;
                } catch (Throwable th10) {
                    th = th10;
                    $this4 = $this8;
                    obj2 = coroutine_suspended;
                    str = "Error:";
                    i = 2;
                    Result.Companion companion15 = Result.Companion;
                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj8 = obj7;
                    data5 = data4;
                    function11 = function7;
                    isCasting6 = isCasting4;
                    doc4 = doc3;
                    headers5 = headers4;
                    media5 = media3;
                    function12 = function8;
                    $this5 = $this4;
                    if (Result.isFailure-impl(obj8)) {
                        obj8 = null;
                    }
                    bodyClass = (String) obj8;
                    Regex regex7 = new Regex("(?:term|postid)-(\\d+)");
                    if (bodyClass == null) {
                        str2 = "";
                    } else {
                        str2 = bodyClass;
                    }
                    matchResultFind$default = Regex.find$default(regex7, str2, 0, i, (Object) null);
                    if (matchResultFind$default != null) {
                        term = null;
                    } else {
                        term = null;
                    }
                    str3 = term;
                    if (str3 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                        return Boxing.boxBoolean(false);
                    }
                    list = CollectionsKt.toList(new IntRange(0, 10));
                    anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                    c00023.Z$0 = isCasting6;
                    c00023.label = 4;
                    if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                        return obj2;
                    }
                    return Boxing.boxBoolean(true);
                }
                obj8 = obj7;
                data5 = data4;
                function11 = function7;
                isCasting6 = isCasting4;
                doc4 = doc3;
                headers5 = headers4;
                media5 = media3;
                function12 = function8;
                $this5 = $this4;
                if (Result.isFailure-impl(obj8)) {
                    obj8 = null;
                }
                bodyClass = (String) obj8;
                Regex regex8 = new Regex("(?:term|postid)-(\\d+)");
                if (bodyClass == null) {
                    str2 = "";
                } else {
                    str2 = bodyClass;
                }
                matchResultFind$default = Regex.find$default(regex8, str2, 0, i, (Object) null);
                if (matchResultFind$default != null) {
                    term = null;
                } else {
                    term = null;
                }
                str3 = term;
                if (str3 != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    Log.INSTANCE.e(str, "No postid/term ID found in body class: " + bodyClass);
                    return Boxing.boxBoolean(false);
                }
                list = CollectionsKt.toList(new IntRange(0, 10));
                anonymousClass3 = $this5.new AnonymousClass3(term, media5, function11, function12, null);
                c00023.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(media5);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(headers5);
                c00023.L$6 = SpillingKt.nullOutSpilledVariable(doc4);
                c00023.L$7 = SpillingKt.nullOutSpilledVariable(bodyClass);
                c00023.L$8 = SpillingKt.nullOutSpilledVariable(term);
                c00023.Z$0 = isCasting6;
                c00023.label = 4;
                if (ParCollectionsKt.amap(list, anonymousClass3, c00023) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(true);
            case 4:
                boolean z3 = c00023.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$loadLinks$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "iframe", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$loadLinks$2", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {260, 266}, m = "invokeSuspend", n = {"iframe", "serverUrl", "$this$invokeSuspend_u24lambda_u240", "iframe", "serverUrl", "innerIframeUrl"}, nl = {261, 268}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = AnimeDekhoProvider.this.new AnonymousClass2(this.$subtitleCallback, this.$callback, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00c7 A[Catch: all -> 0x00d3, TryCatch #1 {all -> 0x00d3, blocks: (B:26:0x00b8, B:28:0x00c7, B:30:0x00ce), top: B:61:0x00b8 }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:44:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:47:0x0104  */
        /* JADX WARN: Code duplicated, block: B:51:0x010d  */
        /* JADX WARN: Code duplicated, block: B:53:0x0110  */
        /* JADX WARN: Code duplicated, block: B:55:0x0132 A[RETURN] */
        public final Object invokeSuspend(Object $result) {
            AnonymousClass2 anonymousClass2;
            Element iframe;
            Object obj;
            String serverUrl;
            String str;
            Object obj2;
            Object obj3;
            String serverUrl2;
            String innerIframeUrl;
            String str2;
            boolean z;
            Element elementSelectFirst;
            String strAttr;
            Element iframe2 = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String serverUrl3 = iframe2.attr("src");
                    if (StringsKt.isBlank(serverUrl3)) {
                        return Unit.INSTANCE;
                    }
                    AnimeDekhoProvider $this$invokeSuspend_u24lambda_u240 = AnimeDekhoProvider.this;
                    try {
                        Result.Companion companion = Result.Companion;
                        try {
                            Requests app = MainActivityKt.getApp();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(iframe2);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                            this.label = 1;
                            iframe = iframe2;
                            obj = coroutine_suspended;
                            str = "src";
                            try {
                                obj2 = Requests.get$default(app, serverUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                                anonymousClass2 = this;
                                if (obj2 == obj) {
                                    return obj;
                                }
                                serverUrl = serverUrl3;
                                try {
                                    elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("iframe[src]");
                                    if (elementSelectFirst != null) {
                                        strAttr = elementSelectFirst.attr(str);
                                    } else {
                                        strAttr = null;
                                    }
                                    obj3 = Result.constructor-impl(strAttr);
                                    break;
                                } catch (Throwable th) {
                                    th = th;
                                    Result.Companion companion2 = Result.Companion;
                                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                serverUrl2 = serverUrl;
                                innerIframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                                str2 = innerIframeUrl;
                                if (str2 != null || StringsKt.isBlank(str2)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl2);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(innerIframeUrl);
                                    anonymousClass2.label = 2;
                                    if (ExtractorApiKt.loadExtractor(innerIframeUrl, anonymousClass2.$subtitleCallback, anonymousClass2.$callback, (Continuation) anonymousClass2) == obj) {
                                        return obj;
                                    }
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                anonymousClass2 = this;
                                serverUrl = serverUrl3;
                                Result.Companion companion3 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                serverUrl2 = serverUrl;
                                innerIframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                                str2 = innerIframeUrl;
                                if (str2 != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl2);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(innerIframeUrl);
                                    anonymousClass2.label = 2;
                                    if (ExtractorApiKt.loadExtractor(innerIframeUrl, anonymousClass2.$subtitleCallback, anonymousClass2.$callback, (Continuation) anonymousClass2) == obj) {
                                        return obj;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            anonymousClass2 = this;
                            obj = coroutine_suspended;
                            iframe = iframe2;
                            serverUrl = serverUrl3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        anonymousClass2 = this;
                        iframe = iframe2;
                        obj = coroutine_suspended;
                        serverUrl = serverUrl3;
                    }
                    break;
                case 1:
                    serverUrl = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass2 = this;
                        iframe = iframe2;
                        obj = coroutine_suspended;
                        str = "src";
                        obj2 = $result;
                        elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("iframe[src]");
                        if (elementSelectFirst != null) {
                            strAttr = elementSelectFirst.attr(str);
                        } else {
                            strAttr = null;
                        }
                        obj3 = Result.constructor-impl(strAttr);
                        break;
                    } catch (Throwable th5) {
                        th = th5;
                        anonymousClass2 = this;
                        iframe = iframe2;
                        obj = coroutine_suspended;
                        Result.Companion companion4 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        serverUrl2 = serverUrl;
                        innerIframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                        str2 = innerIframeUrl;
                        if (str2 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl2);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(innerIframeUrl);
                            anonymousClass2.label = 2;
                            if (ExtractorApiKt.loadExtractor(innerIframeUrl, anonymousClass2.$subtitleCallback, anonymousClass2.$callback, (Continuation) anonymousClass2) == obj) {
                                return obj;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    serverUrl2 = serverUrl;
                    innerIframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                    str2 = innerIframeUrl;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(serverUrl2);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(innerIframeUrl);
                        anonymousClass2.label = 2;
                        if (ExtractorApiKt.loadExtractor(innerIframeUrl, anonymousClass2.$subtitleCallback, anonymousClass2.$callback, (Continuation) anonymousClass2) == obj) {
                            return obj;
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$loadLinks$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$loadLinks$3", f = "AnimeDekhoProvider.kt", i = {0, 0, 1, 1, 1}, l = {285, 291}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "i", "iframeUrl", "$this$invokeSuspend_u24lambda_u241", "i"}, nl = {286, 290}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Integer, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Media $media;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $term;
        /* synthetic */ int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Media media, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$term = str;
            this.$media = media;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = AnimeDekhoProvider.this.new AnonymousClass3(this.$term, this.$media, this.$subtitleCallback, this.$callback, continuation);
            anonymousClass3.I$0 = ((Number) obj).intValue();
            return anonymousClass3;
        }

        public final Object invoke(int i, Continuation<Object> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation<Object>) obj2);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00ef A[Catch: all -> 0x00fd, TryCatch #4 {all -> 0x00fd, blocks: (B:24:0x00e0, B:26:0x00ef, B:28:0x00f8), top: B:77:0x00e0 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:40:0x011e  */
        /* JADX WARN: Code duplicated, block: B:43:0x0129  */
        /* JADX WARN: Code duplicated, block: B:47:0x0132  */
        /* JADX WARN: Code duplicated, block: B:49:0x0135  */
        /* JADX WARN: Code duplicated, block: B:54:0x016d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x016e  */
        /* JADX WARN: Code duplicated, block: B:65:0x0194  */
        /* JADX WARN: Code duplicated, block: B:67:0x01be  */
        public final Object invokeSuspend(Object $result) {
            AnonymousClass3 anonymousClass3;
            Object obj;
            int i;
            String str;
            Object obj2;
            Object obj3;
            String iframeUrl;
            String str2;
            boolean z;
            String str3;
            Object objLoadExtractor;
            Element elementSelectFirst;
            String strAttr;
            Object obj4;
            Throwable it;
            int i2 = this.I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AnimeDekhoProvider $this$invokeSuspend_u24lambda_u240 = AnimeDekhoProvider.this;
                    String str4 = this.$term;
                    Media media = this.$media;
                    try {
                        Result.Companion companion = Result.Companion;
                        Requests app = MainActivityKt.getApp();
                        String str5 = $this$invokeSuspend_u24lambda_u240.getMainUrl() + "/?trdekho=" + i2 + "&trid=" + str4 + "&trtype=" + media.getMediaType();
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                        this.I$0 = i2;
                        this.label = 1;
                        str = "Error:";
                        obj = coroutine_suspended;
                        i = i2;
                        try {
                            obj2 = Requests.get$default(app, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            anonymousClass3 = this;
                            if (obj2 == obj) {
                                return obj;
                            }
                            try {
                                elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("iframe");
                                if (elementSelectFirst != null) {
                                    strAttr = elementSelectFirst.attr("src");
                                } else {
                                    strAttr = null;
                                }
                                obj3 = Result.constructor-impl(strAttr);
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            iframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                            str2 = iframeUrl;
                            if (str2 != null || str2.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                Log.INSTANCE.w(str, "No iframe found for iteration " + i);
                                return Unit.INSTANCE;
                            }
                            str3 = str;
                            Log.INSTANCE.d(str3, "Found iframe: " + iframeUrl);
                            AnimeDekhoProvider $this$invokeSuspend_u24lambda_u241 = AnimeDekhoProvider.this;
                            Function1<SubtitleFile, Unit> function1 = anonymousClass3.$subtitleCallback;
                            Function1<ExtractorLink, Unit> function2 = anonymousClass3.$callback;
                            try {
                                Result.Companion companion3 = Result.Companion;
                                anonymousClass3.L$0 = iframeUrl;
                                anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u241);
                                try {
                                    anonymousClass3.I$0 = i;
                                    anonymousClass3.label = 2;
                                    objLoadExtractor = ExtractorApiKt.loadExtractor(iframeUrl, function1, function2, anonymousClass3);
                                    if (objLoadExtractor == obj) {
                                        return obj;
                                    }
                                    obj4 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objLoadExtractor).booleanValue()));
                                    it = Result.exceptionOrNull-impl(obj4);
                                    if (it != null) {
                                        Log.INSTANCE.e(str3, "Failed to load extractor for " + iframeUrl + " " + it);
                                    }
                                    return Result.box-impl(obj4);
                                } catch (Throwable th2) {
                                    th = th2;
                                    Result.Companion companion4 = Result.Companion;
                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                Result.Companion companion5 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            anonymousClass3 = this;
                            Result.Companion companion6 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            iframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                            str2 = iframeUrl;
                            if (str2 != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                Log.INSTANCE.w(str, "No iframe found for iteration " + i);
                                return Unit.INSTANCE;
                            }
                            str3 = str;
                            Log.INSTANCE.d(str3, "Found iframe: " + iframeUrl);
                            AnimeDekhoProvider $this$invokeSuspend_u24lambda_u242 = AnimeDekhoProvider.this;
                            Function1<SubtitleFile, Unit> function3 = anonymousClass3.$subtitleCallback;
                            Function1<ExtractorLink, Unit> function4 = anonymousClass3.$callback;
                            Result.Companion companion7 = Result.Companion;
                            anonymousClass3.L$0 = iframeUrl;
                            anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u242);
                            anonymousClass3.I$0 = i;
                            anonymousClass3.label = 2;
                            objLoadExtractor = ExtractorApiKt.loadExtractor(iframeUrl, function3, function4, anonymousClass3);
                            if (objLoadExtractor == obj) {
                                return obj;
                            }
                            obj4 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objLoadExtractor).booleanValue()));
                            it = Result.exceptionOrNull-impl(obj4);
                            if (it != null) {
                                Log.INSTANCE.e(str3, "Failed to load extractor for " + iframeUrl + " " + it);
                            }
                            return Result.box-impl(obj4);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        anonymousClass3 = this;
                        obj = coroutine_suspended;
                        i = i2;
                        str = "Error:";
                    }
                    break;
                case 1:
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass3 = this;
                        obj = coroutine_suspended;
                        i = i2;
                        str = "Error:";
                        obj2 = $result;
                        elementSelectFirst = ((NiceResponse) obj2).getDocument().selectFirst("iframe");
                        if (elementSelectFirst != null) {
                            strAttr = elementSelectFirst.attr("src");
                        } else {
                            strAttr = null;
                        }
                        obj3 = Result.constructor-impl(strAttr);
                        break;
                    } catch (Throwable th6) {
                        th = th6;
                        anonymousClass3 = this;
                        obj = coroutine_suspended;
                        i = i2;
                        str = "Error:";
                        Result.Companion companion8 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        iframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                        str2 = iframeUrl;
                        if (str2 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            Log.INSTANCE.w(str, "No iframe found for iteration " + i);
                            return Unit.INSTANCE;
                        }
                        str3 = str;
                        Log.INSTANCE.d(str3, "Found iframe: " + iframeUrl);
                        AnimeDekhoProvider $this$invokeSuspend_u24lambda_u243 = AnimeDekhoProvider.this;
                        Function1<SubtitleFile, Unit> function5 = anonymousClass3.$subtitleCallback;
                        Function1<ExtractorLink, Unit> function6 = anonymousClass3.$callback;
                        Result.Companion companion9 = Result.Companion;
                        anonymousClass3.L$0 = iframeUrl;
                        anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u243);
                        anonymousClass3.I$0 = i;
                        anonymousClass3.label = 2;
                        objLoadExtractor = ExtractorApiKt.loadExtractor(iframeUrl, function5, function6, anonymousClass3);
                        if (objLoadExtractor == obj) {
                            return obj;
                        }
                        obj4 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objLoadExtractor).booleanValue()));
                        it = Result.exceptionOrNull-impl(obj4);
                        if (it != null) {
                            Log.INSTANCE.e(str3, "Failed to load extractor for " + iframeUrl + " " + it);
                        }
                        return Result.box-impl(obj4);
                    }
                    iframeUrl = (String) (Result.isFailure-impl(obj3) ? null : obj3);
                    str2 = iframeUrl;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        Log.INSTANCE.w(str, "No iframe found for iteration " + i);
                        return Unit.INSTANCE;
                    }
                    str3 = str;
                    Log.INSTANCE.d(str3, "Found iframe: " + iframeUrl);
                    AnimeDekhoProvider $this$invokeSuspend_u24lambda_u244 = AnimeDekhoProvider.this;
                    Function1<SubtitleFile, Unit> function7 = anonymousClass3.$subtitleCallback;
                    Function1<ExtractorLink, Unit> function8 = anonymousClass3.$callback;
                    Result.Companion companion10 = Result.Companion;
                    anonymousClass3.L$0 = iframeUrl;
                    anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u244);
                    anonymousClass3.I$0 = i;
                    anonymousClass3.label = 2;
                    objLoadExtractor = ExtractorApiKt.loadExtractor(iframeUrl, function7, function8, anonymousClass3);
                    if (objLoadExtractor == obj) {
                        return obj;
                    }
                    obj4 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objLoadExtractor).booleanValue()));
                    it = Result.exceptionOrNull-impl(obj4);
                    if (it != null) {
                        Log.INSTANCE.e(str3, "Failed to load extractor for " + iframeUrl + " " + it);
                    }
                    return Result.box-impl(obj4);
                case 2:
                    iframeUrl = (String) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        str3 = "Error:";
                        objLoadExtractor = $result;
                        obj4 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) objLoadExtractor).booleanValue()));
                        break;
                    } catch (Throwable th7) {
                        th = th7;
                        str3 = "Error:";
                        Result.Companion companion11 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    it = Result.exceptionOrNull-impl(obj4);
                    if (it != null) {
                        Log.INSTANCE.e(str3, "Failed to load extractor for " + iframeUrl + " " + it);
                    }
                    return Result.box-impl(obj4);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AnimeDekhoProvider$Media;", "", "url", "", "poster", "mediaType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/AnimeDekhoProvider$Media;", "equals", "", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final Integer mediaType;

        @Nullable
        private final String poster;

        @NotNull
        private final String url;

        public static /* synthetic */ Media copy$default(Media media, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = media.url;
            }
            if ((i & 2) != 0) {
                str2 = media.poster;
            }
            if ((i & 4) != 0) {
                num = media.mediaType;
            }
            return media.copy(str, str2, num);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getMediaType() {
            return this.mediaType;
        }

        @NotNull
        public final Media copy(@NotNull String url, @Nullable String poster, @Nullable Integer mediaType) {
            return new Media(url, poster, mediaType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.poster, media.poster) && Intrinsics.areEqual(this.mediaType, media.mediaType);
        }

        public int hashCode() {
            return (((this.url.hashCode() * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.mediaType != null ? this.mediaType.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(url=" + this.url + ", poster=" + this.poster + ", mediaType=" + this.mediaType + ")";
        }

        public Media(@NotNull String url, @Nullable String poster, @Nullable Integer mediaType) {
            this.url = url;
            this.poster = poster;
            this.mediaType = mediaType;
        }

        public /* synthetic */ Media(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
        }

        @Nullable
        public final Integer getMediaType() {
            return this.mediaType;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }
}
