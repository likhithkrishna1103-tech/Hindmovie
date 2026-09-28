package com.phisher98;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/phisher98/AnimeDekhoProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Media", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nAnimeDekhoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,354:1\n1795#2,10:355\n2068#2:365\n2069#2:367\n1805#2:368\n1795#2,10:369\n2068#2:379\n2069#2:381\n1805#2:382\n1739#2:402\n1814#2,3:403\n1795#2,10:427\n2068#2:437\n2069#2:439\n1805#2:440\n1795#2,10:441\n2068#2:451\n2069#2:453\n1805#2:454\n1795#2,10:455\n2068#2:465\n2069#2:468\n1805#2:469\n1739#2:470\n1814#2,3:471\n1#3:366\n1#3:380\n1#3:384\n1#3:406\n1#3:408\n1#3:426\n1#3:438\n1#3:452\n1#3:466\n1#3:467\n1#3:474\n1#3:476\n1#3:494\n63#4:383\n64#4,15:385\n63#4:407\n64#4,15:409\n63#4:475\n64#4,15:477\n50#5:400\n43#5:401\n50#5:424\n43#5:425\n50#5:492\n43#5:493\n*S KotlinDebug\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider\n*L\n50#1:355,10\n50#1:365\n50#1:367\n50#1:368\n71#1:369,10\n71#1:379\n71#1:381\n71#1:382\n88#1:402\n88#1:403,3\n158#1:427,10\n158#1:437\n158#1:439\n158#1:440\n159#1:441,10\n159#1:451\n159#1:453\n159#1:454\n171#1:455,10\n171#1:465\n171#1:468\n171#1:469\n212#1:470\n212#1:471,3\n50#1:366\n71#1:380\n77#1:384\n124#1:408\n158#1:438\n159#1:452\n171#1:467\n247#1:476\n77#1:383\n77#1:385,15\n124#1:407\n124#1:409,15\n247#1:475\n247#1:477,15\n77#1:400\n77#1:401\n124#1:424\n124#1:425\n247#1:492\n247#1:493\n*E\n"})
public class AnimeDekhoProvider extends com.lagradost.cloudstream3.MainAPI {
    private final boolean hasDownloadSupport;
    private final boolean hasMainPage;

    @org.jetbrains.annotations.NotNull
    private java.lang.String lang;

    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.lagradost.cloudstream3.MainPageData> mainPage;

    @org.jetbrains.annotations.NotNull
    private java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private java.lang.String name;

    @org.jetbrains.annotations.NotNull
    private final java.util.Set<com.lagradost.cloudstream3.TvType> supportedTypes;

    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AnimeDekhoProvider$Media;", "", "url", "", "poster", "mediaType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/AnimeDekhoProvider$Media;", "equals", "", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Media {

        @org.jetbrains.annotations.Nullable
        private final java.lang.Integer mediaType;

        @org.jetbrains.annotations.Nullable
        private final java.lang.String poster;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String url;

        public Media(@org.jetbrains.annotations.NotNull java.lang.String r1, @org.jetbrains.annotations.Nullable java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.Integer r3) {
                r0 = this;
                r0.<init>()
                r0.url = r1
                r0.poster = r2
                r0.mediaType = r3
                return
        }

        public /* synthetic */ Media(java.lang.String r2, java.lang.String r3, java.lang.Integer r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
                r1 = this;
                r6 = r5 & 2
                r0 = 0
                if (r6 == 0) goto L6
                r3 = r0
            L6:
                r5 = r5 & 4
                if (r5 == 0) goto Lb
                r4 = r0
            Lb:
                r1.<init>(r2, r3, r4)
                return
        }

        public static /* synthetic */ com.phisher98.AnimeDekhoProvider.Media copy$default(com.phisher98.AnimeDekhoProvider.Media r0, java.lang.String r1, java.lang.String r2, java.lang.Integer r3, int r4, java.lang.Object r5) {
                r5 = r4 & 1
                if (r5 == 0) goto L6
                java.lang.String r1 = r0.url
            L6:
                r5 = r4 & 2
                if (r5 == 0) goto Lc
                java.lang.String r2 = r0.poster
            Lc:
                r4 = r4 & 4
                if (r4 == 0) goto L12
                java.lang.Integer r3 = r0.mediaType
            L12:
                com.phisher98.AnimeDekhoProvider$Media r0 = r0.copy(r1, r2, r3)
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.url
                return r0
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.poster
                return r0
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer component3() {
                r1 = this;
                java.lang.Integer r0 = r1.mediaType
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.AnimeDekhoProvider.Media copy(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.String r3, @org.jetbrains.annotations.Nullable java.lang.Integer r4) {
                r1 = this;
                com.phisher98.AnimeDekhoProvider$Media r0 = new com.phisher98.AnimeDekhoProvider$Media
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
                r5 = this;
                r0 = 1
                if (r5 != r6) goto L4
                return r0
            L4:
                boolean r1 = r6 instanceof com.phisher98.AnimeDekhoProvider.Media
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r6
                com.phisher98.AnimeDekhoProvider$Media r1 = (com.phisher98.AnimeDekhoProvider.Media) r1
                java.lang.String r3 = r5.url
                java.lang.String r4 = r1.url
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L18
                return r2
            L18:
                java.lang.String r3 = r5.poster
                java.lang.String r4 = r1.poster
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L23
                return r2
            L23:
                java.lang.Integer r3 = r5.mediaType
                java.lang.Integer r1 = r1.mediaType
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
                if (r1 != 0) goto L2e
                return r2
            L2e:
                return r0
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Integer getMediaType() {
                r1 = this;
                java.lang.Integer r0 = r1.mediaType
                return r0
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.String getPoster() {
                r1 = this;
                java.lang.String r0 = r1.poster
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUrl() {
                r1 = this;
                java.lang.String r0 = r1.url
                return r0
        }

        public int hashCode() {
                r4 = this;
                java.lang.String r0 = r4.url
                int r0 = r0.hashCode()
                int r1 = r0 * 31
                java.lang.String r2 = r4.poster
                r3 = 0
                if (r2 != 0) goto Lf
                r2 = 0
                goto L15
            Lf:
                java.lang.String r2 = r4.poster
                int r2 = r2.hashCode()
            L15:
                int r1 = r1 + r2
                int r0 = r1 * 31
                java.lang.Integer r2 = r4.mediaType
                if (r2 != 0) goto L1d
                goto L23
            L1d:
                java.lang.Integer r2 = r4.mediaType
                int r3 = r2.hashCode()
            L23:
                int r0 = r0 + r3
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
                r5 = this;
                java.lang.String r0 = r5.url
                java.lang.String r1 = r5.poster
                java.lang.Integer r2 = r5.mediaType
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Media(url="
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.StringBuilder r0 = r3.append(r0)
                java.lang.String r3 = ", poster="
                java.lang.StringBuilder r0 = r0.append(r3)
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = ", mediaType="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.String r1 = ")"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$getMainPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 0}, l = {48}, m = "getMainPage$suspendImpl", n = {"$this", "request", "link", "page"}, nl = {50}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        int I$0;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider this$0;

        AnonymousClass1(com.phisher98.AnimeDekhoProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.AnonymousClass1> r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
                r4 = this;
                r4.result = r5
                int r0 = r4.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 | r1
                r4.label = r0
                com.phisher98.AnimeDekhoProvider r0 = r4.this$0
                r1 = 0
                r2 = r4
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r3 = 0
                java.lang.Object r0 = com.phisher98.AnimeDekhoProvider.getMainPage$suspendImpl(r0, r3, r1, r2)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {78, 100, 106, 123, 140, 164, 226}, m = "load$suspendImpl", n = {"$this", "url", "media", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "$this$load_u24lambda_u242", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "$this$load_u24lambda_u243", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "aniUrl", "$this$load_u24lambda_u247", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "lst", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "lst", "tmdbIdFinal", "tmdbSeasonData", "apiKey", "episodesList", "seasonsPresent", "$this", "url", "media", "document", "title", "poster", "plot", "year", "tags", "anilistUrl", "malUrl", "tmdbId", "anilist_id", "mal_id", "aniZipData", "backgroundPoster", "metaPoster", "urlsToTry", "lst", "tmdbIdFinal", "tmdbSeasonData", "apiKey", "episodesList", "seasonsPresent", "episodes", "recommendations"}, nl = {79, 101, 107, 124, 154, 171, 139}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25"}, v = 2)
    static final class C00011 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$10;
        java.lang.Object L$11;
        java.lang.Object L$12;
        java.lang.Object L$13;
        java.lang.Object L$14;
        java.lang.Object L$15;
        java.lang.Object L$16;
        java.lang.Object L$17;
        java.lang.Object L$18;
        java.lang.Object L$19;
        java.lang.Object L$2;
        java.lang.Object L$20;
        java.lang.Object L$21;
        java.lang.Object L$22;
        java.lang.Object L$23;
        java.lang.Object L$24;
        java.lang.Object L$25;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        java.lang.Object L$8;
        java.lang.Object L$9;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider this$0;

        C00011(com.phisher98.AnimeDekhoProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.C00011> r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
                r3 = this;
                r3.result = r4
                int r0 = r3.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 | r1
                r3.label = r0
                com.phisher98.AnimeDekhoProvider r0 = r3.this$0
                r1 = 0
                r2 = r3
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r0 = com.phisher98.AnimeDekhoProvider.load$suspendImpl(r0, r1, r2)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$4, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$load$4", f = "AnimeDekhoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass4 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<com.lagradost.cloudstream3.MovieLoadResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> $anilist_id;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> $backgroundPoster;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> $mal_id;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> $metaPoster;
        final /* synthetic */ java.lang.String $plot;
        final /* synthetic */ java.lang.String $poster;
        final /* synthetic */ java.util.List<java.lang.String> $tags;
        final /* synthetic */ java.lang.String $tmdbId;
        final /* synthetic */ java.lang.Integer $year;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        AnonymousClass4(kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> r2, java.lang.String r3, kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> r4, java.lang.String r5, java.lang.Integer r6, java.util.List<java.lang.String> r7, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> r8, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> r9, java.lang.String r10, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.AnonymousClass4> r11) {
                r1 = this;
                r1.$metaPoster = r2
                r1.$poster = r3
                r1.$backgroundPoster = r4
                r1.$plot = r5
                r1.$year = r6
                r1.$tags = r7
                r1.$mal_id = r8
                r1.$anilist_id = r9
                r1.$tmdbId = r10
                r0 = 2
                r1.<init>(r0, r11)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r12, kotlin.coroutines.Continuation<?> r13) {
                r11 = this;
                com.phisher98.AnimeDekhoProvider$load$4 r0 = new com.phisher98.AnimeDekhoProvider$load$4
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r11.$metaPoster
                java.lang.String r2 = r11.$poster
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r3 = r11.$backgroundPoster
                java.lang.String r4 = r11.$plot
                java.lang.Integer r5 = r11.$year
                java.util.List<java.lang.String> r6 = r11.$tags
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r7 = r11.$mal_id
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r8 = r11.$anilist_id
                java.lang.String r9 = r11.$tmdbId
                r10 = r13
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                r0.L$0 = r12
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(com.lagradost.cloudstream3.MovieLoadResponse r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.AnimeDekhoProvider$load$4 r0 = (com.phisher98.AnimeDekhoProvider.AnonymousClass4) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                r1 = this;
                com.lagradost.cloudstream3.MovieLoadResponse r2 = (com.lagradost.cloudstream3.MovieLoadResponse) r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r0 = r1.invoke(r2, r3)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                r4 = this;
                java.lang.Object r0 = r4.L$0
                com.lagradost.cloudstream3.MovieLoadResponse r0 = (com.lagradost.cloudstream3.MovieLoadResponse) r0
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
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
                kotlin.ResultKt.throwOnFailure(r5)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r4.$metaPoster
                java.lang.Object r1 = r1.element
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L21
                java.lang.String r1 = r4.$poster
            L21:
                r0.setPosterUrl(r1)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r4.$backgroundPoster
                java.lang.Object r1 = r1.element
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L2e
                java.lang.String r1 = r4.$poster
            L2e:
                r0.setBackgroundPosterUrl(r1)
                java.lang.String r1 = r4.$plot
                r0.setPlot(r1)
                java.lang.Integer r1 = r4.$year
                r0.setYear(r1)
                java.util.List<java.lang.String> r1 = r4.$tags
                r0.setTags(r1)
                com.lagradost.cloudstream3.LoadResponse$Companion r1 = com.lagradost.cloudstream3.LoadResponse.Companion
                r2 = r0
                com.lagradost.cloudstream3.LoadResponse r2 = (com.lagradost.cloudstream3.LoadResponse) r2
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r3 = r4.$mal_id
                java.lang.Object r3 = r3.element
                java.lang.Integer r3 = (java.lang.Integer) r3
                r1.addMalId(r2, r3)
                com.lagradost.cloudstream3.LoadResponse$Companion r1 = com.lagradost.cloudstream3.LoadResponse.Companion
                r2 = r0
                com.lagradost.cloudstream3.LoadResponse r2 = (com.lagradost.cloudstream3.LoadResponse) r2
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r3 = r4.$anilist_id
                java.lang.Object r3 = r3.element
                java.lang.Integer r3 = (java.lang.Integer) r3
                r1.addAniListId(r2, r3)
                com.lagradost.cloudstream3.LoadResponse$Companion r1 = com.lagradost.cloudstream3.LoadResponse.Companion
                r2 = r0
                com.lagradost.cloudstream3.LoadResponse r2 = (com.lagradost.cloudstream3.LoadResponse) r2
                java.lang.String r3 = r4.$tmdbId
                r1.addTMDbId(r2, r3)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$5, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "s", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$load$5", f = "AnimeDekhoProvider.kt", i = {0}, l = {165}, m = "invokeSuspend", n = {"s"}, nl = {355}, s = {"I$0"}, v = 2)
    @kotlin.jvm.internal.SourceDebugExtension({"SMAP\nAnimeDekhoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider$load$5\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,354:1\n73#2,5:355\n*S KotlinDebug\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider$load$5\n*L\n165#1:355,5\n*E\n"})
    static final class AnonymousClass5 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ java.lang.String $apiKey;
        final /* synthetic */ java.lang.Object $tmdbIdFinal;
        final /* synthetic */ java.util.Map<java.lang.Integer, com.phisher98.TmdbSeasonResponse> $tmdbSeasonData;
        /* synthetic */ int I$0;
        int label;

        AnonymousClass5(java.lang.Object r2, java.lang.String r3, java.util.Map<java.lang.Integer, com.phisher98.TmdbSeasonResponse> r4, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.AnonymousClass5> r5) {
                r1 = this;
                r1.$tmdbIdFinal = r2
                r1.$apiKey = r3
                r1.$tmdbSeasonData = r4
                r0 = 2
                r1.<init>(r0, r5)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r5, kotlin.coroutines.Continuation<?> r6) {
                r4 = this;
                com.phisher98.AnimeDekhoProvider$load$5 r0 = new com.phisher98.AnimeDekhoProvider$load$5
                java.lang.Object r1 = r4.$tmdbIdFinal
                java.lang.String r2 = r4.$apiKey
                java.util.Map<java.lang.Integer, com.phisher98.TmdbSeasonResponse> r3 = r4.$tmdbSeasonData
                r0.<init>(r1, r2, r3, r6)
                r1 = r5
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                r0.I$0 = r1
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(int r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
                kotlin.coroutines.Continuation r0 = r2.create(r0, r4)
                com.phisher98.AnimeDekhoProvider$load$5 r0 = (com.phisher98.AnimeDekhoProvider.AnonymousClass5) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r3, java.lang.Object r4) {
                r2 = this;
                r0 = r3
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                java.lang.Object r0 = r2.invoke(r0, r1)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
                r21 = this;
                r1 = r21
                int r2 = r1.I$0
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                switch(r3) {
                    case 0: goto L1b;
                    case 1: goto L15;
                    default: goto Ld;
                }
            Ld:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r3)
                throw r0
            L15:
                kotlin.ResultKt.throwOnFailure(r22)
                r3 = r22
                goto L6f
            L1b:
                kotlin.ResultKt.throwOnFailure(r22)
                com.lagradost.nicehttp.Requests r4 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                java.lang.Object r3 = r1.$tmdbIdFinal
                java.lang.String r5 = r1.$apiKey
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "https://api.themoviedb.org/3/tv/"
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.StringBuilder r3 = r6.append(r3)
                java.lang.String r6 = "/season/"
                java.lang.StringBuilder r3 = r3.append(r6)
                java.lang.StringBuilder r3 = r3.append(r2)
                java.lang.String r6 = "?api_key="
                java.lang.StringBuilder r3 = r3.append(r6)
                java.lang.StringBuilder r3 = r3.append(r5)
                java.lang.String r5 = r3.toString()
                r18 = r1
                kotlin.coroutines.Continuation r18 = (kotlin.coroutines.Continuation) r18
                r1.I$0 = r2
                r3 = 1
                r1.label = r3
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r19 = 4094(0xffe, float:5.737E-42)
                r20 = 0
                java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20)
                if (r3 != r0) goto L6f
                return r0
            L6f:
                com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
                r4 = 0
                r5 = 0
                com.lagradost.nicehttp.ResponseParser r0 = r3.getParser()     // Catch: java.lang.Exception -> L8a
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L8a
                java.lang.String r6 = r3.getText()     // Catch: java.lang.Exception -> L8a
                java.lang.Class<com.phisher98.TmdbSeasonResponse> r7 = com.phisher98.TmdbSeasonResponse.class
                kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)     // Catch: java.lang.Exception -> L8a
                java.lang.Object r0 = r0.parseSafe(r6, r7)     // Catch: java.lang.Exception -> L8a
                goto L90
            L8a:
                r0 = move-exception
                r0.printStackTrace()
                r0 = r5
            L90:
                com.phisher98.TmdbSeasonResponse r0 = (com.phisher98.TmdbSeasonResponse) r0
                if (r0 == 0) goto La1
                java.util.Map<java.lang.Integer, com.phisher98.TmdbSeasonResponse> r3 = r1.$tmdbSeasonData
                r4 = 0
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
                r3.put(r5, r0)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
            La1:
                return r5
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$load$6, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$load$6", f = "AnimeDekhoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @kotlin.jvm.internal.SourceDebugExtension({"SMAP\nAnimeDekhoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeDekhoProvider.kt\ncom/phisher98/AnimeDekhoProvider$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,354:1\n1#2:355\n*E\n"})
    static final class AnonymousClass6 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<com.lagradost.cloudstream3.AnimeLoadResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> $anilist_id;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> $backgroundPoster;
        final /* synthetic */ java.util.List<com.lagradost.cloudstream3.Episode> $episodes;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> $mal_id;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> $metaPoster;
        final /* synthetic */ java.lang.String $plot;
        final /* synthetic */ java.lang.String $poster;
        final /* synthetic */ java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse> $recommendations;
        final /* synthetic */ java.util.List<java.lang.String> $tags;
        final /* synthetic */ java.lang.String $tmdbId;
        final /* synthetic */ java.lang.Integer $year;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        AnonymousClass6(java.util.List<com.lagradost.cloudstream3.Episode> r2, kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> r3, java.lang.String r4, kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> r5, java.lang.String r6, java.lang.Integer r7, java.util.List<java.lang.String> r8, java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse> r9, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> r10, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Integer> r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.AnonymousClass6> r13) {
                r1 = this;
                r1.$episodes = r2
                r1.$metaPoster = r3
                r1.$poster = r4
                r1.$backgroundPoster = r5
                r1.$plot = r6
                r1.$year = r7
                r1.$tags = r8
                r1.$recommendations = r9
                r1.$mal_id = r10
                r1.$anilist_id = r11
                r1.$tmdbId = r12
                r0 = 2
                r1.<init>(r0, r13)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r14, kotlin.coroutines.Continuation<?> r15) {
                r13 = this;
                com.phisher98.AnimeDekhoProvider$load$6 r0 = new com.phisher98.AnimeDekhoProvider$load$6
                java.util.List<com.lagradost.cloudstream3.Episode> r1 = r13.$episodes
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r2 = r13.$metaPoster
                java.lang.String r3 = r13.$poster
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r4 = r13.$backgroundPoster
                java.lang.String r5 = r13.$plot
                java.lang.Integer r6 = r13.$year
                java.util.List<java.lang.String> r7 = r13.$tags
                java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse> r8 = r13.$recommendations
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r9 = r13.$mal_id
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r10 = r13.$anilist_id
                java.lang.String r11 = r13.$tmdbId
                r12 = r15
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                r0.L$0 = r14
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(com.lagradost.cloudstream3.AnimeLoadResponse r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.AnimeDekhoProvider$load$6 r0 = (com.phisher98.AnimeDekhoProvider.AnonymousClass6) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                r1 = this;
                com.lagradost.cloudstream3.AnimeLoadResponse r2 = (com.lagradost.cloudstream3.AnimeLoadResponse) r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r0 = r1.invoke(r2, r3)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                r6 = this;
                java.lang.Object r0 = r6.L$0
                com.lagradost.cloudstream3.AnimeLoadResponse r0 = (com.lagradost.cloudstream3.AnimeLoadResponse) r0
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
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
                kotlin.ResultKt.throwOnFailure(r7)
                com.lagradost.cloudstream3.DubStatus r1 = com.lagradost.cloudstream3.DubStatus.Subbed
                java.util.List<com.lagradost.cloudstream3.Episode> r2 = r6.$episodes
                com.lagradost.cloudstream3.MainAPIKt.addEpisodes(r0, r1, r2)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r6.$metaPoster
                java.lang.Object r1 = r1.element
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L28
                java.lang.String r1 = r6.$poster
            L28:
                r0.setPosterUrl(r1)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r6.$backgroundPoster
                java.lang.Object r1 = r1.element
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L35
                java.lang.String r1 = r6.$poster
            L35:
                r0.setBackgroundPosterUrl(r1)
                java.lang.String r1 = r6.$plot
                r0.setPlot(r1)
                java.lang.Integer r1 = r6.$year
                r0.setYear(r1)
                java.util.List<java.lang.String> r1 = r6.$tags
                r0.setTags(r1)
                java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse> r1 = r6.$recommendations
                r0.setRecommendations(r1)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r1 = r6.$mal_id
                java.lang.Object r1 = r1.element
                java.lang.Integer r1 = (java.lang.Integer) r1
                if (r1 == 0) goto L67
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                r2 = 0
                com.lagradost.cloudstream3.LoadResponse$Companion r3 = com.lagradost.cloudstream3.LoadResponse.Companion
                r4 = r0
                com.lagradost.cloudstream3.LoadResponse r4 = (com.lagradost.cloudstream3.LoadResponse) r4
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
                r3.addMalId(r4, r5)
            L67:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Integer> r1 = r6.$anilist_id
                java.lang.Object r1 = r1.element
                java.lang.Integer r1 = (java.lang.Integer) r1
                if (r1 == 0) goto L82
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                r2 = 0
                com.lagradost.cloudstream3.LoadResponse$Companion r3 = com.lagradost.cloudstream3.LoadResponse.Companion
                r4 = r0
                com.lagradost.cloudstream3.LoadResponse r4 = (com.lagradost.cloudstream3.LoadResponse) r4
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
                r3.addAniListId(r4, r5)
            L82:
                java.lang.String r1 = r6.$tmdbId
                if (r1 == 0) goto L8f
                r2 = 0
                com.lagradost.cloudstream3.LoadResponse$Companion r3 = com.lagradost.cloudstream3.LoadResponse.Companion
                r4 = r0
                com.lagradost.cloudstream3.LoadResponse r4 = (com.lagradost.cloudstream3.LoadResponse) r4
                r3.addTMDbId(r4, r1)
            L8f:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {254, 255, 272, 283}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "media", "headers", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "headers", "doc", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "headers", "doc", "$this$loadLinks_u24lambda_u242", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "headers", "doc", "bodyClass", "term", "isCasting"}, nl = {255, 271, 271, 300}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0"}, v = 2)
    static final class C00021 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        java.lang.Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider this$0;

        C00021(com.phisher98.AnimeDekhoProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.C00021> r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
                r7 = this;
                r7.result = r8
                int r0 = r7.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 | r1
                r7.label = r0
                com.phisher98.AnimeDekhoProvider r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = com.phisher98.AnimeDekhoProvider.loadLinks$suspendImpl(r1, r2, r3, r4, r5, r6)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$loadLinks$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "iframe", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$loadLinks$2", f = "AnimeDekhoProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {260, 266}, m = "invokeSuspend", n = {"iframe", "serverUrl", "$this$invokeSuspend_u24lambda_u240", "iframe", "serverUrl", "innerIframeUrl"}, nl = {261, 268}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<org.jsoup.nodes.Element, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> $callback;
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> $subtitleCallback;
        /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider this$0;

        AnonymousClass2(com.phisher98.AnimeDekhoProvider r2, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r3, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r4, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.AnonymousClass2> r5) {
                r1 = this;
                r1.this$0 = r2
                r1.$subtitleCallback = r3
                r1.$callback = r4
                r0 = 2
                r1.<init>(r0, r5)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r5, kotlin.coroutines.Continuation<?> r6) {
                r4 = this;
                com.phisher98.AnimeDekhoProvider$loadLinks$2 r0 = new com.phisher98.AnimeDekhoProvider$loadLinks$2
                com.phisher98.AnimeDekhoProvider r1 = r4.this$0
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r2 = r4.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r3 = r4.$callback
                r0.<init>(r1, r2, r3, r6)
                r0.L$0 = r5
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                r1 = this;
                org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r0 = r1.invoke(r2, r3)
                return r0
        }

        public final java.lang.Object invoke(org.jsoup.nodes.Element r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.AnimeDekhoProvider$loadLinks$2 r0 = (com.phisher98.AnimeDekhoProvider.AnonymousClass2) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
                r24 = this;
                r1 = r24
                java.lang.Object r0 = r1.L$0
                r2 = r0
                org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r1.label
                r4 = 1
                r19 = 0
                java.lang.String r5 = "src"
                switch(r0) {
                    case 0: goto L4c;
                    case 1: goto L2e;
                    case 2: goto L1e;
                    default: goto L15;
                }
            L15:
                r4 = r1
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1e:
                java.lang.Object r0 = r1.L$2
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r3 = r1.L$1
                java.lang.String r3 = (java.lang.String) r3
                kotlin.ResultKt.throwOnFailure(r25)
                r4 = r1
                r21 = r2
                goto L133
            L2e:
                r0 = 0
                java.lang.Object r6 = r1.L$2
                com.phisher98.AnimeDekhoProvider r6 = (com.phisher98.AnimeDekhoProvider) r6
                java.lang.Object r7 = r1.L$1
                java.lang.String r7 = (java.lang.String) r7
                kotlin.ResultKt.throwOnFailure(r25)     // Catch: java.lang.Throwable -> L45
                r20 = r0
                r4 = r1
                r21 = r2
                r1 = r3
                r0 = r5
                r2 = r25
                goto Lb8
            L45:
                r0 = move-exception
                r4 = r1
                r21 = r2
                r1 = r3
                goto Le7
            L4c:
                kotlin.ResultKt.throwOnFailure(r25)
                r6 = r3
                java.lang.String r3 = r2.attr(r5)
                r0 = r3
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = kotlin.text.StringsKt.isBlank(r0)
                if (r0 == 0) goto L60
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L60:
                com.phisher98.AnimeDekhoProvider r0 = r1.this$0
                kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Le1
                r20 = 0
                r7 = r2
                com.lagradost.nicehttp.Requests r2 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> Lda
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Throwable -> Lda
                r1.L$0 = r8     // Catch: java.lang.Throwable -> Lda
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)     // Catch: java.lang.Throwable -> Lda
                r1.L$1 = r8     // Catch: java.lang.Throwable -> Lda
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> Lda
                r1.L$2 = r8     // Catch: java.lang.Throwable -> Lda
                r1.label = r4     // Catch: java.lang.Throwable -> Lda
                r8 = 1
                r4 = 0
                r9 = r5
                r5 = 0
                r10 = r6
                r6 = 0
                r11 = r7
                r7 = 0
                r12 = 1
                r8 = 0
                r13 = r9
                r9 = 0
                r14 = r10
                r10 = 0
                r15 = r11
                r16 = 1
                r11 = 0
                r17 = r13
                r13 = 0
                r18 = r14
                r14 = 0
                r21 = r15
                r15 = 0
                r22 = r17
                r17 = 4094(0xffe, float:5.737E-42)
                r23 = r18
                r18 = 0
                r16 = r1
                r1 = r23
                r23 = r0
                r0 = r22
                java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> Ld5
                r4 = r16
                if (r2 != r1) goto Lb5
                return r1
            Lb5:
                r7 = r3
                r6 = r23
            Lb8:
                com.lagradost.nicehttp.NiceResponse r2 = (com.lagradost.nicehttp.NiceResponse) r2     // Catch: java.lang.Throwable -> Ld3
                org.jsoup.nodes.Document r2 = r2.getDocument()     // Catch: java.lang.Throwable -> Ld3
                java.lang.String r3 = "iframe[src]"
                org.jsoup.nodes.Element r2 = r2.selectFirst(r3)     // Catch: java.lang.Throwable -> Ld3
                if (r2 == 0) goto Lcc
            Lc7:
                java.lang.String r0 = r2.attr(r0)     // Catch: java.lang.Throwable -> Ld3
                goto Lce
            Lcc:
                r0 = r19
            Lce:
                java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> Ld3
                goto Lf1
            Ld3:
                r0 = move-exception
                goto Le7
            Ld5:
                r0 = move-exception
                r4 = r16
                r7 = r3
                goto Le7
            Lda:
                r0 = move-exception
                r4 = r1
                r1 = r6
                r21 = r7
                r7 = r3
                goto Le7
            Le1:
                r0 = move-exception
                r4 = r1
                r21 = r2
                r1 = r6
                r7 = r3
            Le7:
                kotlin.Result$Companion r2 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            Lf1:
                r3 = r7
                boolean r2 = kotlin.Result.isFailure-impl(r0)
                if (r2 == 0) goto Lf9
                goto Lfb
            Lf9:
                r19 = r0
            Lfb:
                java.lang.String r19 = (java.lang.String) r19
                r0 = r19
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                if (r2 == 0) goto L10d
                boolean r2 = kotlin.text.StringsKt.isBlank(r2)
                if (r2 == 0) goto L10b
                goto L10d
            L10b:
                r2 = 0
                goto L10e
            L10d:
                r2 = 1
            L10e:
                if (r2 != 0) goto L134
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r2 = r4.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r5 = r4.$callback
                r6 = r4
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21)
                r4.L$0 = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                r4.L$1 = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r4.L$2 = r7
                r7 = 2
                r4.label = r7
                java.lang.Object r2 = com.lagradost.cloudstream3.utils.ExtractorApiKt.loadExtractor(r0, r2, r5, r6)
                if (r2 != r1) goto L133
                return r1
            L133:
            L134:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$loadLinks$3, reason: invalid class name */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider$loadLinks$3", f = "AnimeDekhoProvider.kt", i = {0, 0, 1, 1, 1}, l = {285, 291}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "i", "iframeUrl", "$this$invokeSuspend_u24lambda_u241", "i"}, nl = {286, 290}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super java.lang.Object>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> $callback;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider.Media $media;
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> $subtitleCallback;
        final /* synthetic */ java.lang.String $term;
        /* synthetic */ int I$0;
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider this$0;

        AnonymousClass3(com.phisher98.AnimeDekhoProvider r2, java.lang.String r3, com.phisher98.AnimeDekhoProvider.Media r4, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.AnonymousClass3> r7) {
                r1 = this;
                r1.this$0 = r2
                r1.$term = r3
                r1.$media = r4
                r1.$subtitleCallback = r5
                r1.$callback = r6
                r0 = 2
                r1.<init>(r0, r7)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r8, kotlin.coroutines.Continuation<?> r9) {
                r7 = this;
                com.phisher98.AnimeDekhoProvider$loadLinks$3 r0 = new com.phisher98.AnimeDekhoProvider$loadLinks$3
                com.phisher98.AnimeDekhoProvider r1 = r7.this$0
                java.lang.String r2 = r7.$term
                com.phisher98.AnimeDekhoProvider$Media r3 = r7.$media
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r4 = r7.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r5 = r7.$callback
                r6 = r9
                r0.<init>(r1, r2, r3, r4, r5, r6)
                r9 = r8
                java.lang.Number r9 = (java.lang.Number) r9
                int r9 = r9.intValue()
                r0.I$0 = r9
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(int r3, kotlin.coroutines.Continuation<java.lang.Object> r4) {
                r2 = this;
                java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
                kotlin.coroutines.Continuation r0 = r2.create(r0, r4)
                com.phisher98.AnimeDekhoProvider$loadLinks$3 r0 = (com.phisher98.AnimeDekhoProvider.AnonymousClass3) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r3, java.lang.Object r4) {
                r2 = this;
                r0 = r3
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                java.lang.Object r0 = r2.invoke(r0, r1)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
                r25 = this;
                r1 = r25
                int r2 = r1.I$0
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r1.label
                r4 = 1
                r19 = 0
                java.lang.String r5 = "Error:"
                switch(r0) {
                    case 0: goto L57;
                    case 1: goto L36;
                    case 2: goto L1b;
                    default: goto L12;
                }
            L12:
                r3 = r1
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1b:
                r0 = 0
                java.lang.Object r3 = r1.L$1
                com.phisher98.AnimeDekhoProvider r3 = (com.phisher98.AnimeDekhoProvider) r3
                java.lang.Object r4 = r1.L$0
                java.lang.String r4 = (java.lang.String) r4
                kotlin.ResultKt.throwOnFailure(r26)     // Catch: java.lang.Throwable -> L30
                r9 = r3
                r3 = r1
                r1 = r9
                r15 = r2
                r9 = r5
                r2 = r26
                goto L170
            L30:
                r0 = move-exception
                r3 = r1
                r15 = r2
                r9 = r5
                goto L184
            L36:
                r0 = 0
                java.lang.Object r6 = r1.L$0
                com.phisher98.AnimeDekhoProvider r6 = (com.phisher98.AnimeDekhoProvider) r6
                kotlin.ResultKt.throwOnFailure(r26)     // Catch: java.lang.Throwable -> L4b
                r22 = r3
                r3 = r1
                r1 = r22
                r22 = r2
                r24 = r5
                r2 = r26
                goto Le0
            L4b:
                r0 = move-exception
                r22 = r3
                r3 = r1
                r1 = r22
                r22 = r2
                r24 = r5
                goto L10d
            L57:
                kotlin.ResultKt.throwOnFailure(r26)
                com.phisher98.AnimeDekhoProvider r0 = r1.this$0
                java.lang.String r6 = r1.$term
                com.phisher98.AnimeDekhoProvider$Media r7 = r1.$media
                kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L103
                r20 = 0
                com.lagradost.nicehttp.Requests r8 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> L103
                java.lang.String r9 = r0.getMainUrl()     // Catch: java.lang.Throwable -> L103
                java.lang.Integer r7 = r7.getMediaType()     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L103
                r10.<init>()     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r9 = r10.append(r9)     // Catch: java.lang.Throwable -> L103
                java.lang.String r10 = "/?trdekho="
                java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r9 = r9.append(r2)     // Catch: java.lang.Throwable -> L103
                java.lang.String r10 = "&trid="
                java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r6 = r9.append(r6)     // Catch: java.lang.Throwable -> L103
                java.lang.String r9 = "&trtype="
                java.lang.StringBuilder r6 = r6.append(r9)     // Catch: java.lang.Throwable -> L103
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L103
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L103
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L103
                r1.L$0 = r7     // Catch: java.lang.Throwable -> L103
                r1.I$0 = r2     // Catch: java.lang.Throwable -> L103
                r1.label = r4     // Catch: java.lang.Throwable -> L103
                r7 = 1
                r4 = 0
                r9 = r5
                r5 = 0
                r10 = r3
                r3 = r6
                r6 = 0
                r11 = 1
                r7 = 0
                r12 = r2
                r2 = r8
                r8 = 0
                r13 = r9
                r9 = 0
                r14 = r10
                r10 = 0
                r15 = r12
                r16 = 1
                r11 = 0
                r17 = r13
                r13 = 0
                r18 = r14
                r14 = 0
                r21 = r15
                r15 = 0
                r22 = r17
                r17 = 4094(0xffe, float:5.737E-42)
                r23 = r18
                r18 = 0
                r16 = r1
                r24 = r22
                r1 = r23
                r22 = r21
                java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> Lff
                r3 = r16
                if (r2 != r1) goto Ldd
                return r1
            Ldd:
                r6 = r0
                r0 = r20
            Le0:
                com.lagradost.nicehttp.NiceResponse r2 = (com.lagradost.nicehttp.NiceResponse) r2     // Catch: java.lang.Throwable -> Lfd
                org.jsoup.nodes.Document r2 = r2.getDocument()     // Catch: java.lang.Throwable -> Lfd
                java.lang.String r4 = "iframe"
                org.jsoup.nodes.Element r2 = r2.selectFirst(r4)     // Catch: java.lang.Throwable -> Lfd
                if (r2 == 0) goto Lf6
            Lef:
                java.lang.String r4 = "src"
                java.lang.String r2 = r2.attr(r4)     // Catch: java.lang.Throwable -> Lfd
                goto Lf8
            Lf6:
                r2 = r19
            Lf8:
                java.lang.Object r0 = kotlin.Result.constructor-impl(r2)     // Catch: java.lang.Throwable -> Lfd
                goto L117
            Lfd:
                r0 = move-exception
                goto L10d
            Lff:
                r0 = move-exception
                r3 = r16
                goto L10d
            L103:
                r0 = move-exception
                r22 = r3
                r3 = r1
                r1 = r22
                r22 = r2
                r24 = r5
            L10d:
                kotlin.Result$Companion r2 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            L117:
                boolean r2 = kotlin.Result.isFailure-impl(r0)
                if (r2 == 0) goto L11e
                goto L120
            L11e:
                r19 = r0
            L120:
                java.lang.String r19 = (java.lang.String) r19
                r4 = r19
                r0 = r4
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L132
                int r0 = r0.length()
                if (r0 != 0) goto L130
                goto L132
            L130:
                r0 = 0
                goto L133
            L132:
                r0 = 1
            L133:
                if (r0 != 0) goto L1be
                com.lagradost.api.Log r0 = com.lagradost.api.Log.INSTANCE
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "Found iframe: "
                java.lang.StringBuilder r2 = r2.append(r5)
                java.lang.StringBuilder r2 = r2.append(r4)
                java.lang.String r2 = r2.toString()
                r9 = r24
                r0.d(r9, r2)
                com.phisher98.AnimeDekhoProvider r0 = r3.this$0
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r2 = r3.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r5 = r3.$callback
                kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L181
                r6 = 0
                r3.L$0 = r4     // Catch: java.lang.Throwable -> L181
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L181
                r3.L$1 = r7     // Catch: java.lang.Throwable -> L181
                r15 = r22
                r3.I$0 = r15     // Catch: java.lang.Throwable -> L17f
                r7 = 2
                r3.label = r7     // Catch: java.lang.Throwable -> L17f
                java.lang.Object r2 = com.lagradost.cloudstream3.utils.ExtractorApiKt.loadExtractor(r4, r2, r5, r3)     // Catch: java.lang.Throwable -> L17f
                if (r2 != r1) goto L16e
                return r1
            L16e:
                r1 = r0
                r0 = r6
            L170:
                java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L17f
                boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L17f
                java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)     // Catch: java.lang.Throwable -> L17f
                java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L17f
                goto L18e
            L17f:
                r0 = move-exception
                goto L184
            L181:
                r0 = move-exception
                r15 = r22
            L184:
                kotlin.Result$Companion r1 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            L18e:
                java.lang.Throwable r1 = kotlin.Result.exceptionOrNull-impl(r0)
                if (r1 == 0) goto L1b9
                r2 = 0
                com.lagradost.api.Log r5 = com.lagradost.api.Log.INSTANCE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Failed to load extractor for "
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.StringBuilder r6 = r6.append(r4)
                java.lang.String r7 = " "
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.StringBuilder r6 = r6.append(r1)
                java.lang.String r6 = r6.toString()
                r5.e(r9, r6)
            L1b9:
                kotlin.Result r0 = kotlin.Result.box-impl(r0)
                goto L1dc
            L1be:
                r15 = r22
                r9 = r24
                com.lagradost.api.Log r0 = com.lagradost.api.Log.INSTANCE
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "No iframe found for iteration "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r15)
                java.lang.String r1 = r1.toString()
                r0.w(r9, r1)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
            L1dc:
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimeDekhoProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnimeDekhoProvider.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AnimeDekhoProvider", f = "AnimeDekhoProvider.kt", i = {0, 0}, l = {70}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {71}, s = {"L$0", "L$1"}, v = 2)
    static final class C00031 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider this$0;

        C00031(com.phisher98.AnimeDekhoProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.AnimeDekhoProvider.C00031> r2) {
                r0 = this;
                r0.this$0 = r1
                r0.<init>(r2)
                return
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
                r3 = this;
                r3.result = r4
                int r0 = r3.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 | r1
                r3.label = r0
                com.phisher98.AnimeDekhoProvider r0 = r3.this$0
                r1 = 0
                r2 = r3
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r0 = com.phisher98.AnimeDekhoProvider.search$suspendImpl(r0, r1, r2)
                return r0
        }
    }

    public static /* synthetic */ kotlin.Unit $r8$lambda$61zQ2wintYIYWNJWgOldZKRKgZQ(com.phisher98.AnimeDekhoProvider.Media r0, com.lagradost.cloudstream3.AnimeSearchResponse r1) {
            kotlin.Unit r0 = load$lambda$12$0(r0, r1)
            return r0
    }

    public static /* synthetic */ kotlin.Unit $r8$lambda$j_lD3NLk8kxYMLGi0YVdYF_iMTE(com.phisher98.TmdbEpisode r0, com.phisher98.MetaEpisode r1, java.lang.String r2, java.lang.String r3, java.lang.Integer r4, java.lang.Integer r5, com.lagradost.cloudstream3.Episode r6) {
            kotlin.Unit r0 = load$lambda$11$1(r0, r1, r2, r3, r4, r5, r6)
            return r0
    }

    public AnimeDekhoProvider() {
            r8 = this;
            r8.<init>()
            java.lang.String r0 = "https://animedekho.app"
            r8.mainUrl = r0
            java.lang.String r0 = "Anime Dekho"
            r8.name = r0
            r0 = 1
            r8.hasMainPage = r0
            java.lang.String r1 = "hi"
            r8.lang = r1
            r8.hasDownloadSupport = r0
            r1 = 4
            com.lagradost.cloudstream3.TvType[] r2 = new com.lagradost.cloudstream3.TvType[r1]
            com.lagradost.cloudstream3.TvType r3 = com.lagradost.cloudstream3.TvType.Cartoon
            r4 = 0
            r2[r4] = r3
            com.lagradost.cloudstream3.TvType r3 = com.lagradost.cloudstream3.TvType.Anime
            r2[r0] = r3
            com.lagradost.cloudstream3.TvType r3 = com.lagradost.cloudstream3.TvType.AnimeMovie
            r5 = 2
            r2[r5] = r3
            com.lagradost.cloudstream3.TvType r3 = com.lagradost.cloudstream3.TvType.Movie
            r6 = 3
            r2[r6] = r3
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r2)
            r8.supportedTypes = r2
            r2 = 6
            kotlin.Pair[] r2 = new kotlin.Pair[r2]
            java.lang.String r3 = "/category/anime/"
            java.lang.String r7 = "Anime"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r7)
            r2[r4] = r3
            java.lang.String r3 = "/category/cartoon/"
            java.lang.String r4 = "Cartoon"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r2[r0] = r3
            java.lang.String r0 = "/category/crunchyroll/"
            java.lang.String r3 = "Crunchyroll"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r3)
            r2[r5] = r0
            java.lang.String r0 = "/category/hindi-dub/"
            java.lang.String r3 = "Hindi"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r3)
            r2[r6] = r0
            java.lang.String r0 = "/category/tamil/"
            java.lang.String r3 = "Tamil"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r3)
            r2[r1] = r0
            java.lang.String r0 = "/category/telugu/"
            java.lang.String r1 = "Telugu"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
            r1 = 5
            r2[r1] = r0
            java.util.List r0 = com.lagradost.cloudstream3.MainAPIKt.mainPageOf(r2)
            r8.mainPage = r0
            return
    }

    static /* synthetic */ java.lang.Object getMainPage$suspendImpl(com.phisher98.AnimeDekhoProvider r22, int r23, com.lagradost.cloudstream3.MainPageRequest r24, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r25) {
            r0 = r22
            r1 = r25
            boolean r2 = r1 instanceof com.phisher98.AnimeDekhoProvider.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.AnimeDekhoProvider$getMainPage$1 r2 = (com.phisher98.AnimeDekhoProvider.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.AnimeDekhoProvider$getMainPage$1 r2 = new com.phisher98.AnimeDekhoProvider$getMainPage$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r3 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            switch(r5) {
                case 0: goto L4a;
                case 1: goto L32;
                default: goto L28;
            }
        L28:
            r17 = r2
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L32:
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.L$1
            com.lagradost.cloudstream3.MainPageRequest r6 = (com.lagradost.cloudstream3.MainPageRequest) r6
            java.lang.Object r7 = r2.L$0
            r0 = r7
            com.phisher98.AnimeDekhoProvider r0 = (com.phisher98.AnimeDekhoProvider) r0
            kotlin.ResultKt.throwOnFailure(r3)
            r17 = r2
            r20 = r3
            goto Lbc
        L4a:
            kotlin.ResultKt.throwOnFailure(r3)
            com.phisher98.donation.DonationManager r5 = com.phisher98.donation.DonationManager.INSTANCE
            java.lang.String r6 = r0.getName()
            r5.checkAndShow(r6)
            java.lang.String r5 = r0.getMainUrl()
            java.lang.String r6 = r24.getData()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r5 = r7.append(r5)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = r3
            com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r2.L$0 = r0
            r7 = r24
            r2.L$1 = r7
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r2.L$2 = r8
            r8 = r23
            r2.I$0 = r8
            r9 = 1
            r2.label = r9
            r9 = r4
            r4 = r5
            r5 = 0
            r10 = r6
            r6 = 0
            r7 = 0
            r8 = 0
            r11 = r9
            r9 = 0
            r12 = r10
            r10 = 0
            r13 = r11
            r11 = 0
            r14 = r12
            r15 = r13
            r12 = 0
            r16 = r14
            r14 = 0
            r17 = r15
            r15 = 0
            r18 = r16
            r16 = 0
            r19 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r20 = r19
            r19 = 0
            r21 = r17
            r17 = r2
            r2 = r21
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            if (r3 != r2) goto Lb7
            return r2
        Lb7:
            r6 = r24
            r5 = r4
            r4 = r23
        Lbc:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            org.jsoup.nodes.Document r2 = r3.getDocument()
            java.lang.String r3 = "article"
            org.jsoup.select.Elements r3 = r2.select(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r7 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            r9 = r3
            r10 = 0
            r11 = r9
            r12 = 0
            java.util.Iterator r13 = r11.iterator()
        Lda:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto Lfa
            java.lang.Object r14 = r13.next()
            r15 = r14
            r16 = 0
            r1 = r15
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
            r18 = 0
            com.lagradost.cloudstream3.AnimeSearchResponse r1 = r0.toSearchResult(r1)
            if (r1 == 0) goto Lf7
            r18 = 0
            r8.add(r1)
        Lf7:
            r1 = r25
            goto Lda
        Lfa:
            r1 = r8
            java.util.List r1 = (java.util.List) r1
            java.lang.String r3 = r6.getName()
            r7 = 4
            r8 = 0
            com.lagradost.cloudstream3.HomePageResponse r3 = com.lagradost.cloudstream3.MainAPIKt.newHomePageResponse$default(r3, r1, r8, r7, r8)
            return r3
    }

    private static final kotlin.Unit load$lambda$11$1(com.phisher98.TmdbEpisode r14, com.phisher98.MetaEpisode r15, java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.lang.Integer r19, com.lagradost.cloudstream3.Episode r20) {
            r0 = r20
            r1 = 0
            if (r14 == 0) goto L1a
            java.lang.String r2 = r14.getName()
            if (r2 == 0) goto L1a
            r3 = r2
            r4 = 0
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 != 0) goto L17
            goto L18
        L17:
            r2 = r1
        L18:
            if (r2 != 0) goto L44
        L1a:
            if (r15 == 0) goto L2b
            java.util.Map r2 = r15.getTitle()
            if (r2 == 0) goto L2b
            java.lang.String r3 = "en"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            goto L2c
        L2b:
            r2 = r1
        L2c:
            if (r2 != 0) goto L44
            if (r15 == 0) goto L3f
            java.util.Map r2 = r15.getTitle()
            if (r2 == 0) goto L3f
            java.lang.String r3 = "x-jat"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            goto L40
        L3f:
            r2 = r1
        L40:
            if (r2 != 0) goto L44
            r2 = r16
        L44:
            r0.setName(r2)
            java.lang.String r2 = "null"
            r3 = 1
            r4 = 0
            if (r14 == 0) goto L82
            java.lang.String r5 = r14.getStill_path()
            if (r5 == 0) goto L82
            r6 = r5
            r7 = 0
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            if (r8 != 0) goto L66
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r2)
            if (r8 != 0) goto L66
            r6 = 1
            goto L67
        L66:
            r6 = 0
        L67:
            if (r6 == 0) goto L6a
            goto L6b
        L6a:
            r5 = r1
        L6b:
            if (r5 == 0) goto L82
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "https://image.tmdb.org/t/p/w500"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r5)
            java.lang.String r5 = r7.toString()
            goto L83
        L82:
            r5 = r1
        L83:
            if (r5 != 0) goto L92
            if (r15 == 0) goto L8c
            java.lang.String r6 = r15.getImage()
            goto L8d
        L8c:
            r6 = r1
        L8d:
            if (r6 != 0) goto L93
            r6 = r17
            goto L93
        L92:
            r6 = r5
        L93:
            r0.setPosterUrl(r6)
            r6 = r18
            r0.setSeason(r6)
            r7 = r19
            r0.setEpisode(r7)
            if (r14 == 0) goto Lb7
            java.lang.String r8 = r14.getOverview()
            if (r8 == 0) goto Lb7
            r9 = r8
            r10 = 0
            r11 = r9
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            if (r11 != 0) goto Lb4
            goto Lb5
        Lb4:
            r8 = r1
        Lb5:
            if (r8 != 0) goto Lbf
        Lb7:
            if (r15 == 0) goto Lbe
            java.lang.String r8 = r15.getOverview()
            goto Lbf
        Lbe:
            r8 = r1
        Lbf:
            r0.setDescription(r8)
            if (r14 == 0) goto Le4
            java.lang.String r8 = r14.getAir_date()
            if (r8 == 0) goto Le4
            r9 = r8
            r10 = 0
            r11 = r9
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            if (r11 != 0) goto Ldd
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r2 != 0) goto Ldd
            r2 = 1
            goto Lde
        Ldd:
            r2 = 0
        Lde:
            if (r2 == 0) goto Le1
            goto Le2
        Le1:
            r8 = r1
        Le2:
            if (r8 != 0) goto Lec
        Le4:
            if (r15 == 0) goto Leb
            java.lang.String r8 = r15.getAirDateUtc()
            goto Lec
        Leb:
            r8 = r1
        Lec:
            if (r8 == 0) goto Lf4
            r2 = r8
            r9 = 0
            r10 = 2
            com.lagradost.cloudstream3.MainAPIKt.addDate$default(r0, r2, r1, r10, r1)
        Lf4:
            if (r14 == 0) goto Lfb
            java.lang.Double r2 = r14.getVote_average()
            goto Lfc
        Lfb:
            r2 = r1
        Lfc:
            if (r2 == 0) goto L11a
            double r9 = r2.doubleValue()
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L11a
            com.lagradost.cloudstream3.Score$Companion r9 = com.lagradost.cloudstream3.Score.Companion
            double r10 = r2.doubleValue()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            com.lagradost.cloudstream3.Score r9 = r9.from10(r10)
            r0.setScore(r9)
            goto L12c
        L11a:
            if (r15 == 0) goto L12c
            java.lang.String r9 = r15.getRating()
            if (r9 == 0) goto L12c
            r10 = 0
            com.lagradost.cloudstream3.Score$Companion r11 = com.lagradost.cloudstream3.Score.Companion
            com.lagradost.cloudstream3.Score r11 = r11.from10(r9)
            r0.setScore(r11)
        L12c:
            if (r14 == 0) goto L14a
            java.lang.Integer r9 = r14.getRuntime()
            if (r9 == 0) goto L14a
            r10 = r9
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r11 = 0
            if (r10 <= 0) goto L140
            goto L141
        L140:
            r3 = 0
        L141:
            if (r3 == 0) goto L144
            goto L145
        L144:
            r9 = r1
        L145:
            if (r9 != 0) goto L148
            goto L14a
        L148:
            r1 = r9
            goto L150
        L14a:
            if (r15 == 0) goto L150
            java.lang.Integer r1 = r15.getRuntime()
        L150:
            r0.setRunTime(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
    }

    private static final kotlin.Unit load$lambda$12$0(com.phisher98.AnimeDekhoProvider.Media r1, com.lagradost.cloudstream3.AnimeSearchResponse r2) {
            java.lang.String r0 = r1.getPoster()
            r2.setPosterUrl(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
    }

    static /* synthetic */ java.lang.Object load$suspendImpl(com.phisher98.AnimeDekhoProvider r73, java.lang.String r74, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r75) {
            r1 = r73
            r2 = r75
            boolean r0 = r2 instanceof com.phisher98.AnimeDekhoProvider.C00011
            if (r0 == 0) goto L18
            r0 = r2
            com.phisher98.AnimeDekhoProvider$load$1 r0 = (com.phisher98.AnimeDekhoProvider.C00011) r0
            int r3 = r0.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r0.label
            int r3 = r3 - r4
            r0.label = r3
            goto L1d
        L18:
            com.phisher98.AnimeDekhoProvider$load$1 r0 = new com.phisher98.AnimeDekhoProvider$load$1
            r0.<init>(r1, r2)
        L1d:
            r3 = r0
            java.lang.Object r4 = r3.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            java.lang.String r6 = "S"
            java.lang.String r7 = "h3.title > span"
            java.lang.String r20 = "kotlinx.serialization.serializer.simple"
            java.lang.String r9 = "-"
            java.lang.String r10 = "src"
            java.lang.String r11 = "href"
            switch(r0) {
                case 0: goto L3d2;
                case 1: goto L3ad;
                case 2: goto L323;
                case 3: goto L293;
                case 4: goto L1e9;
                case 5: goto L17d;
                case 6: goto Ld3;
                case 7: goto L3d;
                default: goto L35;
            }
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            java.lang.Object r0 = r3.L$25
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r5 = r3.L$24
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r3.L$23
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r3.L$22
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r3.L$21
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r3.L$20
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r3.L$19
            java.lang.Object r11 = r3.L$18
            org.jsoup.select.Elements r11 = (org.jsoup.select.Elements) r11
            java.lang.Object r12 = r3.L$17
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r3.L$16
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$15
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r3.L$14
            kotlin.jvm.internal.Ref$ObjectRef r15 = (kotlin.jvm.internal.Ref.ObjectRef) r15
            r16 = r0
            java.lang.Object r0 = r3.L$13
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r17 = r0
            java.lang.Object r0 = r3.L$12
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r18 = r0
            java.lang.Object r0 = r3.L$11
            java.lang.String r0 = (java.lang.String) r0
            r19 = r0
            java.lang.Object r0 = r3.L$10
            java.lang.String r0 = (java.lang.String) r0
            r20 = r0
            java.lang.Object r0 = r3.L$9
            java.lang.String r0 = (java.lang.String) r0
            r21 = r0
            java.lang.Object r0 = r3.L$8
            java.util.List r0 = (java.util.List) r0
            r22 = r0
            java.lang.Object r0 = r3.L$7
            java.lang.Integer r0 = (java.lang.Integer) r0
            r23 = r0
            java.lang.Object r0 = r3.L$6
            java.lang.String r0 = (java.lang.String) r0
            r24 = r0
            java.lang.Object r0 = r3.L$5
            java.lang.String r0 = (java.lang.String) r0
            r25 = r0
            java.lang.Object r0 = r3.L$4
            java.lang.String r0 = (java.lang.String) r0
            r26 = r0
            java.lang.Object r0 = r3.L$3
            org.jsoup.nodes.Document r0 = (org.jsoup.nodes.Document) r0
            r27 = r0
            java.lang.Object r0 = r3.L$2
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            r28 = r0
            java.lang.Object r0 = r3.L$1
            java.lang.String r0 = (java.lang.String) r0
            r74 = r0
            java.lang.Object r0 = r3.L$0
            com.phisher98.AnimeDekhoProvider r0 = (com.phisher98.AnimeDekhoProvider) r0
            kotlin.ResultKt.throwOnFailure(r4)
            r48 = r74
            r5 = r4
            r59 = r18
            r30 = r21
            r1 = r25
            r47 = r26
            r18 = r27
            r37 = r28
            goto L14e0
        Ld3:
            java.lang.Object r0 = r3.L$23
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r8 = r3.L$22
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r12 = r3.L$21
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$20
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r14 = r3.L$19
            java.lang.Object r15 = r3.L$18
            org.jsoup.select.Elements r15 = (org.jsoup.select.Elements) r15
            r20 = r0
            java.lang.Object r0 = r3.L$17
            java.util.List r0 = (java.util.List) r0
            r22 = r0
            java.lang.Object r0 = r3.L$16
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r23 = r0
            java.lang.Object r0 = r3.L$15
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r24 = r0
            java.lang.Object r0 = r3.L$14
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r25 = r0
            java.lang.Object r0 = r3.L$13
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r26 = r0
            java.lang.Object r0 = r3.L$12
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r27 = r0
            java.lang.Object r0 = r3.L$11
            java.lang.String r0 = (java.lang.String) r0
            r28 = r0
            java.lang.Object r0 = r3.L$10
            java.lang.String r0 = (java.lang.String) r0
            r29 = r0
            java.lang.Object r0 = r3.L$9
            java.lang.String r0 = (java.lang.String) r0
            r30 = r0
            java.lang.Object r0 = r3.L$8
            java.util.List r0 = (java.util.List) r0
            r31 = r0
            java.lang.Object r0 = r3.L$7
            java.lang.Integer r0 = (java.lang.Integer) r0
            r32 = r0
            java.lang.Object r0 = r3.L$6
            java.lang.String r0 = (java.lang.String) r0
            r33 = r0
            java.lang.Object r0 = r3.L$5
            java.lang.String r0 = (java.lang.String) r0
            r34 = r0
            java.lang.Object r0 = r3.L$4
            java.lang.String r0 = (java.lang.String) r0
            r35 = r0
            java.lang.Object r0 = r3.L$3
            org.jsoup.nodes.Document r0 = (org.jsoup.nodes.Document) r0
            r36 = r0
            java.lang.Object r0 = r3.L$2
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            r37 = r0
            java.lang.Object r0 = r3.L$1
            java.lang.String r0 = (java.lang.String) r0
            r74 = r0
            java.lang.Object r0 = r3.L$0
            com.phisher98.AnimeDekhoProvider r0 = (com.phisher98.AnimeDekhoProvider) r0
            kotlin.ResultKt.throwOnFailure(r4)
            r1 = r15
            r15 = r9
            r9 = r1
            r38 = r6
            r39 = r7
            r42 = r10
            r6 = r13
            r7 = r14
            r1 = r22
            r47 = r23
            r49 = r24
            r17 = r25
            r53 = r26
            r54 = r27
            r10 = r28
            r28 = r29
            r13 = r35
            r18 = r36
            r14 = r74
            r23 = r11
            goto L1112
        L17d:
            java.lang.Object r0 = r3.L$18
            org.jsoup.select.Elements r0 = (org.jsoup.select.Elements) r0
            java.lang.Object r5 = r3.L$17
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r3.L$16
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r3.L$15
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r3.L$14
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r3.L$13
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.L$12
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r3.L$11
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r3.L$10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$9
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r3.L$8
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r15 = r3.L$7
            java.lang.Integer r15 = (java.lang.Integer) r15
            r16 = r0
            java.lang.Object r0 = r3.L$6
            java.lang.String r0 = (java.lang.String) r0
            r17 = r0
            java.lang.Object r0 = r3.L$5
            java.lang.String r0 = (java.lang.String) r0
            r18 = r0
            java.lang.Object r0 = r3.L$4
            java.lang.String r0 = (java.lang.String) r0
            r19 = r0
            java.lang.Object r0 = r3.L$3
            org.jsoup.nodes.Document r0 = (org.jsoup.nodes.Document) r0
            r20 = r0
            java.lang.Object r0 = r3.L$2
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            r21 = r0
            java.lang.Object r0 = r3.L$1
            java.lang.String r0 = (java.lang.String) r0
            r74 = r0
            java.lang.Object r0 = r3.L$0
            com.phisher98.AnimeDekhoProvider r0 = (com.phisher98.AnimeDekhoProvider) r0
            kotlin.ResultKt.throwOnFailure(r4)
            r32 = r74
            r24 = r13
            r1 = r15
            r15 = r16
            r31 = r19
            r13 = r21
            r19 = r4
            goto Lf31
        L1e9:
            r0 = 0
            java.lang.Object r8 = r3.L$20
            com.phisher98.AnimeDekhoProvider r8 = (com.phisher98.AnimeDekhoProvider) r8
            java.lang.Object r12 = r3.L$19
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$18
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r14 = r3.L$17
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r15 = r3.L$16
            kotlin.jvm.internal.Ref$ObjectRef r15 = (kotlin.jvm.internal.Ref.ObjectRef) r15
            r22 = r0
            java.lang.Object r0 = r3.L$15
            r23 = r0
            kotlin.jvm.internal.Ref$ObjectRef r23 = (kotlin.jvm.internal.Ref.ObjectRef) r23
            java.lang.Object r0 = r3.L$14
            r24 = r0
            kotlin.jvm.internal.Ref$ObjectRef r24 = (kotlin.jvm.internal.Ref.ObjectRef) r24
            java.lang.Object r0 = r3.L$13
            r25 = r0
            kotlin.jvm.internal.Ref$ObjectRef r25 = (kotlin.jvm.internal.Ref.ObjectRef) r25
            java.lang.Object r0 = r3.L$12
            r26 = r0
            kotlin.jvm.internal.Ref$ObjectRef r26 = (kotlin.jvm.internal.Ref.ObjectRef) r26
            java.lang.Object r0 = r3.L$11
            r27 = r0
            java.lang.String r27 = (java.lang.String) r27
            java.lang.Object r0 = r3.L$10
            r28 = r0
            java.lang.String r28 = (java.lang.String) r28
            java.lang.Object r0 = r3.L$9
            r29 = r0
            java.lang.String r29 = (java.lang.String) r29
            java.lang.Object r0 = r3.L$8
            r30 = r0
            java.util.List r30 = (java.util.List) r30
            java.lang.Object r0 = r3.L$7
            r31 = r0
            java.lang.Integer r31 = (java.lang.Integer) r31
            java.lang.Object r0 = r3.L$6
            r32 = r0
            java.lang.String r32 = (java.lang.String) r32
            java.lang.Object r0 = r3.L$5
            r33 = r0
            java.lang.String r33 = (java.lang.String) r33
            java.lang.Object r0 = r3.L$4
            r34 = r0
            java.lang.String r34 = (java.lang.String) r34
            java.lang.Object r0 = r3.L$3
            r35 = r0
            org.jsoup.nodes.Document r35 = (org.jsoup.nodes.Document) r35
            java.lang.Object r0 = r3.L$2
            r36 = r0
            com.phisher98.AnimeDekhoProvider$Media r36 = (com.phisher98.AnimeDekhoProvider.Media) r36
            java.lang.Object r0 = r3.L$1
            r37 = r0
            java.lang.String r37 = (java.lang.String) r37
            java.lang.Object r0 = r3.L$0
            r1 = r0
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L27e
            r38 = r6
            r39 = r7
            r18 = r9
            r42 = r10
            r6 = r23
            r7 = r24
            r9 = r25
            r10 = r26
            r24 = r29
            r23 = r11
            r25 = r22
            r11 = r31
            r31 = r4
            goto Lac4
        L27e:
            r0 = move-exception
            r40 = r2
            r38 = r6
            r39 = r7
            r18 = r9
            r42 = r10
            r6 = r23
            r10 = r26
            r2 = r29
            r23 = r11
            goto Ld88
        L293:
            r0 = 0
            java.lang.Object r8 = r3.L$14
            com.phisher98.AnimeDekhoProvider r8 = (com.phisher98.AnimeDekhoProvider) r8
            java.lang.Object r12 = r3.L$13
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r3.L$12
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$11
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r3.L$10
            java.lang.String r15 = (java.lang.String) r15
            r22 = r0
            java.lang.Object r0 = r3.L$9
            r23 = r0
            java.lang.String r23 = (java.lang.String) r23
            java.lang.Object r0 = r3.L$8
            r24 = r0
            java.util.List r24 = (java.util.List) r24
            java.lang.Object r0 = r3.L$7
            r25 = r0
            java.lang.Integer r25 = (java.lang.Integer) r25
            java.lang.Object r0 = r3.L$6
            r26 = r0
            java.lang.String r26 = (java.lang.String) r26
            java.lang.Object r0 = r3.L$5
            r27 = r0
            java.lang.String r27 = (java.lang.String) r27
            java.lang.Object r0 = r3.L$4
            r28 = r0
            java.lang.String r28 = (java.lang.String) r28
            java.lang.Object r0 = r3.L$3
            r29 = r0
            org.jsoup.nodes.Document r29 = (org.jsoup.nodes.Document) r29
            java.lang.Object r0 = r3.L$2
            r30 = r0
            com.phisher98.AnimeDekhoProvider$Media r30 = (com.phisher98.AnimeDekhoProvider.Media) r30
            java.lang.Object r0 = r3.L$1
            r31 = r0
            java.lang.String r31 = (java.lang.String) r31
            java.lang.Object r0 = r3.L$0
            r1 = r0
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L306
            r32 = r1
            r17 = r3
            r2 = r5
            r38 = r6
            r39 = r7
            r1 = r9
            r42 = r10
            r0 = r22
            r41 = r24
            r34 = r26
            r43 = r29
            r40 = r31
            r31 = r4
            r24 = r23
            r23 = r11
            goto L8a8
        L306:
            r0 = move-exception
            r32 = r1
            r17 = r3
            r2 = r5
            r38 = r6
            r39 = r7
            r1 = r9
            r42 = r10
            r41 = r24
            r34 = r26
            r43 = r29
            r40 = r31
            r31 = r4
            r24 = r23
            r23 = r11
            goto L91c
        L323:
            r0 = 0
            java.lang.Object r8 = r3.L$14
            com.phisher98.AnimeDekhoProvider r8 = (com.phisher98.AnimeDekhoProvider) r8
            java.lang.Object r12 = r3.L$13
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r3.L$12
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$11
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r3.L$10
            java.lang.String r15 = (java.lang.String) r15
            r22 = r0
            java.lang.Object r0 = r3.L$9
            r23 = r0
            java.lang.String r23 = (java.lang.String) r23
            java.lang.Object r0 = r3.L$8
            r24 = r0
            java.util.List r24 = (java.util.List) r24
            java.lang.Object r0 = r3.L$7
            r25 = r0
            java.lang.Integer r25 = (java.lang.Integer) r25
            java.lang.Object r0 = r3.L$6
            r26 = r0
            java.lang.String r26 = (java.lang.String) r26
            java.lang.Object r0 = r3.L$5
            r27 = r0
            java.lang.String r27 = (java.lang.String) r27
            java.lang.Object r0 = r3.L$4
            r28 = r0
            java.lang.String r28 = (java.lang.String) r28
            java.lang.Object r0 = r3.L$3
            r29 = r0
            org.jsoup.nodes.Document r29 = (org.jsoup.nodes.Document) r29
            java.lang.Object r0 = r3.L$2
            r30 = r0
            com.phisher98.AnimeDekhoProvider$Media r30 = (com.phisher98.AnimeDekhoProvider.Media) r30
            java.lang.Object r0 = r3.L$1
            r31 = r0
            java.lang.String r31 = (java.lang.String) r31
            java.lang.Object r0 = r3.L$0
            r1 = r0
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L393
            r38 = r6
            r39 = r7
            r42 = r10
            r0 = r22
            r7 = r23
            r34 = r26
            r40 = r31
            r2 = 2
            r31 = r4
            r6 = r5
            r23 = r11
            r5 = r3
            r3 = r1
            r1 = r9
            r9 = r29
            goto L6fd
        L393:
            r0 = move-exception
            r38 = r6
            r39 = r7
            r42 = r10
            r34 = r26
            r40 = r31
            r2 = 2
            r31 = r4
            r6 = r5
            r4 = r23
            r5 = r3
            r23 = r11
            r3 = r1
            r1 = r9
            r9 = r29
            goto L7bf
        L3ad:
            java.lang.Object r0 = r3.L$2
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            java.lang.Object r8 = r3.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r12 = r3.L$0
            r1 = r12
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)
            r31 = r4
            r2 = r5
            r38 = r6
            r39 = r7
            r5 = r8
            r41 = r9
            r42 = r10
            r43 = r11
            r6 = r0
            r4 = r1
            r0 = r31
            r1 = 0
            goto L4d2
        L3d2:
            kotlin.ResultKt.throwOnFailure(r4)
            com.lagradost.cloudstream3.utils.AppUtils r8 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r0 = r74
            r12 = r0
            r13 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L3f1
            r0 = r8
            r14 = 0
            java.lang.Class<com.phisher98.AnimeDekhoProvider$Media> r15 = com.phisher98.AnimeDekhoProvider.Media.class
            kotlin.reflect.KType r15 = kotlin.jvm.internal.Reflection.typeOf(r15)     // Catch: java.lang.Throwable -> L3f1
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r20)     // Catch: java.lang.Throwable -> L3f1
            kotlinx.serialization.KSerializer r15 = kotlinx.serialization.SerializersKt.serializer(r15)     // Catch: java.lang.Throwable -> L3f1
            java.lang.Object r0 = kotlin.Result.constructor-impl(r15)     // Catch: java.lang.Throwable -> L3f1
            goto L3fc
        L3f1:
            r0 = move-exception
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        L3fc:
            java.lang.Throwable r14 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r14 != 0) goto L407
            r19 = r4
            r2 = 2
            r4 = 0
            goto L438
        L407:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L429
            r0 = 0
            kotlinx.serialization.json.Json r15 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L429
            kotlinx.serialization.modules.SerializersModule r15 = r15.getSerializersModule()     // Catch: java.lang.Throwable -> L429
            java.lang.Class<com.phisher98.AnimeDekhoProvider$Media> r22 = com.phisher98.AnimeDekhoProvider.Media.class
            r23 = r0
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r22)     // Catch: java.lang.Throwable -> L429
            r19 = r4
            r2 = 2
            r4 = 0
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r15, r0, r4, r2, r4)     // Catch: java.lang.Throwable -> L427
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L427
            goto L438
        L427:
            r0 = move-exception
            goto L42e
        L429:
            r0 = move-exception
            r19 = r4
            r2 = 2
            r4 = 0
        L42e:
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        L438:
            boolean r14 = kotlin.Result.isFailure-impl(r0)
            if (r14 == 0) goto L43f
            r0 = r4
        L43f:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
            r14 = r0
            if (r14 == 0) goto L45a
        L445:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L451 kotlinx.serialization.SerializationException -> L453
            r15 = r14
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15     // Catch: java.lang.Throwable -> L451 kotlinx.serialization.SerializationException -> L453
            java.lang.Object r0 = r0.decodeFromString(r15, r12)     // Catch: java.lang.Throwable -> L451 kotlinx.serialization.SerializationException -> L453
            goto L473
        L451:
            r0 = move-exception
            goto L45a
        L453:
            r0 = move-exception
            r15 = r0
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r15)
        L45a:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0
            r15 = r12
            r21 = 0
            r22 = 0
            com.phisher98.AnimeDekhoProvider$load$suspendImpl$$inlined$parseJson$1 r23 = new com.phisher98.AnimeDekhoProvider$load$suspendImpl$$inlined$parseJson$1
            r23.<init>()
            r2 = r23
            com.fasterxml.jackson.core.type.TypeReference r2 = (com.fasterxml.jackson.core.type.TypeReference) r2
            java.lang.Object r0 = r0.readValue(r15, r2)
        L473:
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            com.lagradost.nicehttp.Requests r2 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r21 = r4
            java.lang.String r4 = r0.getUrl()
            r3.L$0 = r1
            r8 = r74
            r3.L$1 = r8
            r3.L$2 = r0
            r12 = 1
            r3.label = r12
            r13 = r5
            r5 = 0
            r14 = r6
            r6 = 0
            r15 = r7
            r7 = 0
            r8 = 0
            r18 = r9
            r9 = 0
            r22 = r10
            r10 = 0
            r23 = r11
            r11 = 0
            r25 = r13
            r26 = 1
            r12 = 0
            r27 = r14
            r14 = 0
            r28 = r15
            r15 = 0
            r29 = 10
            r16 = 0
            r30 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r31 = r19
            r19 = 0
            r17 = r3
            r1 = r21
            r42 = r22
            r43 = r23
            r38 = r27
            r39 = r28
            r41 = r30
            r3 = r2
            r2 = r25
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r3 = r17
            if (r4 != r2) goto L4cc
            return r2
        L4cc:
            r5 = r74
            r6 = r0
            r0 = r4
            r4 = r73
        L4d2:
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            org.jsoup.nodes.Document r7 = r0.getDocument()
            java.lang.String r0 = "h1.entry-title"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            java.lang.String r8 = "Watch Online "
            java.lang.String r9 = "content"
            if (r0 == 0) goto L4fe
            java.lang.String r0 = r0.text()
            if (r0 == 0) goto L4fe
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L4fe
            r10 = 2
            java.lang.String r0 = kotlin.text.StringsKt.substringAfter$default(r0, r8, r1, r10, r1)
            if (r0 != 0) goto L51d
            goto L4ff
        L4fe:
            r10 = 2
        L4ff:
            java.lang.String r0 = "meta[property=og:title]"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L51a
            java.lang.String r0 = r0.attr(r9)
            if (r0 == 0) goto L51a
            java.lang.String r0 = kotlin.text.StringsKt.substringAfter$default(r0, r8, r1, r10, r1)
            if (r0 == 0) goto L51a
            java.lang.String r8 = " Movie in Hindi Dubbed Free"
            java.lang.String r0 = kotlin.text.StringsKt.substringBefore$default(r0, r8, r1, r10, r1)
            goto L51d
        L51a:
            java.lang.String r0 = "No Title"
        L51d:
            r8 = r0
            r0 = r4
            com.lagradost.cloudstream3.MainAPI r0 = (com.lagradost.cloudstream3.MainAPI) r0
            java.lang.String r11 = "div.post-thumbnail figure img"
            org.jsoup.nodes.Element r11 = r7.selectFirst(r11)
            if (r11 == 0) goto L532
            r12 = r42
            java.lang.String r11 = r11.attr(r12)
            if (r11 != 0) goto L538
            goto L534
        L532:
            r12 = r42
        L534:
            java.lang.String r11 = r6.getPoster()
        L538:
            java.lang.String r11 = com.lagradost.cloudstream3.MainAPIKt.fixUrlNull(r0, r11)
            java.lang.String r0 = "div.entry-content p"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L556
            java.lang.String r0 = r0.text()
            if (r0 == 0) goto L556
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r15 = r0.toString()
            if (r15 != 0) goto L564
        L556:
            java.lang.String r0 = "meta[name=twitter:description]"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L563
            java.lang.String r15 = r0.attr(r9)
            goto L564
        L563:
            r15 = r1
        L564:
            r13 = r15
            java.lang.String r0 = "span.year"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L584
            java.lang.String r0 = r0.text()
            if (r0 == 0) goto L584
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r15 = r0.toString()
            if (r15 != 0) goto L581
            goto L584
        L581:
            r9 = r41
            goto L5a1
        L584:
            java.lang.String r0 = "meta[property=og:updated_time]"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L59e
            java.lang.String r0 = r0.attr(r9)
            if (r0 == 0) goto L59b
        L594:
            r9 = r41
            java.lang.String r15 = kotlin.text.StringsKt.substringBefore$default(r0, r9, r1, r10, r1)
            goto L5a1
        L59b:
            r9 = r41
            goto L5a0
        L59e:
            r9 = r41
        L5a0:
            r15 = r1
        L5a1:
            if (r15 == 0) goto L5aa
        L5a5:
            java.lang.Integer r15 = kotlin.text.StringsKt.toIntOrNull(r15)
            goto L5ab
        L5aa:
            r15 = r1
        L5ab:
            r14 = r15
            java.lang.String r0 = "ul.details-lst li:contains(Genres) a"
            org.jsoup.select.Elements r0 = r7.select(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r15 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r18 = r9
            r9 = 10
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r9)
            r1.<init>(r10)
            java.util.Collection r1 = (java.util.Collection) r1
            r10 = r0
            r16 = 0
            java.util.Iterator r17 = r10.iterator()
        L5cb:
            boolean r23 = r17.hasNext()
            if (r23 == 0) goto L5e5
            java.lang.Object r23 = r17.next()
            r24 = r23
            org.jsoup.nodes.Element r24 = (org.jsoup.nodes.Element) r24
            r25 = 0
            java.lang.String r9 = r24.text()
            r1.add(r9)
            r9 = 10
            goto L5cb
        L5e5:
            java.util.List r1 = (java.util.List) r1
            java.lang.String r0 = "a[href*='anilist.php?id=']"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L5f9
            r9 = r43
            java.lang.String r15 = r0.attr(r9)
            goto L5fc
        L5f9:
            r9 = r43
            r15 = 0
        L5fc:
            java.lang.String r0 = "a[href*='myanimelist.php?id=']"
            org.jsoup.nodes.Element r0 = r7.selectFirst(r0)
            if (r0 == 0) goto L609
            java.lang.String r0 = r0.attr(r9)
            goto L60a
        L609:
            r0 = 0
        L60a:
            r10 = r0
            java.lang.String r0 = "a[href*='themoviedb.org/tv/'], a[href*='themoviedb.org/movie/']"
            org.jsoup.select.Elements r0 = r7.select(r0)
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L653
            java.lang.String r0 = r0.attr(r9)
            if (r0 == 0) goto L653
            r16 = 0
            r73 = r0
            kotlin.text.Regex r0 = new kotlin.text.Regex
            r23 = r9
            java.lang.String r9 = "themoviedb\\.org/(?:tv|movie)/(\\d+)"
            r0.<init>(r9)
            r9 = r73
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r25 = r2
            r42 = r12
            r74 = r15
            r2 = 0
            r12 = 0
            r15 = 2
            kotlin.text.MatchResult r0 = kotlin.text.Regex.find$default(r0, r9, r12, r15, r2)
            if (r0 == 0) goto L650
            java.util.List r0 = r0.getGroupValues()
            if (r0 == 0) goto L650
            r2 = 1
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r2)
            java.lang.String r0 = (java.lang.String) r0
            r15 = r0
            goto L652
        L650:
            r2 = 1
            r15 = 0
        L652:
            goto L65d
        L653:
            r25 = r2
            r23 = r9
            r42 = r12
            r74 = r15
            r2 = 1
            r15 = 0
        L65d:
            r9 = r15
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r12 = r0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r15 = r0
            if (r74 == 0) goto L7e2
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L786
            r0 = r4
            r24 = 0
            com.lagradost.nicehttp.Requests r16 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> L786
            r3.L$0 = r4     // Catch: java.lang.Throwable -> L786
            r3.L$1 = r5     // Catch: java.lang.Throwable -> L786
            r3.L$2 = r6     // Catch: java.lang.Throwable -> L786
            r3.L$3 = r7     // Catch: java.lang.Throwable -> L786
            r3.L$4 = r8     // Catch: java.lang.Throwable -> L786
            r3.L$5 = r11     // Catch: java.lang.Throwable -> L786
            r3.L$6 = r13     // Catch: java.lang.Throwable -> L786
            r3.L$7 = r14     // Catch: java.lang.Throwable -> L786
            r3.L$8 = r1     // Catch: java.lang.Throwable -> L786
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r74)     // Catch: java.lang.Throwable -> L786
            r3.L$9 = r2     // Catch: java.lang.Throwable -> L786
            r3.L$10 = r10     // Catch: java.lang.Throwable -> L786
            r3.L$11 = r9     // Catch: java.lang.Throwable -> L786
            r3.L$12 = r12     // Catch: java.lang.Throwable -> L786
            r3.L$13 = r15     // Catch: java.lang.Throwable -> L786
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L786
            r3.L$14 = r2     // Catch: java.lang.Throwable -> L786
            r2 = 2
            r3.label = r2     // Catch: java.lang.Throwable -> L762
            r17 = r5
            r5 = 0
            r19 = r6
            r6 = 0
            r27 = r7
            r7 = 0
            r28 = r8
            r8 = 0
            r30 = r9
            r9 = 0
            r32 = r10
            r10 = 0
            r33 = r11
            r11 = 0
            r35 = r12
            r34 = r13
            r12 = 0
            r36 = r14
            r14 = 0
            r37 = r15
            r15 = 0
            r40 = r17
            r17 = r3
            r3 = r16
            r16 = 0
            r41 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r43 = r19
            r19 = 0
            r73 = r4
            r4 = r74
            r74 = r73
            r73 = r1
            r1 = r41
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Throwable -> L747
            r5 = r17
            r6 = r25
            if (r3 != r6) goto L6e4
            return r6
        L6e4:
            r8 = r0
            r7 = r4
            r0 = r24
            r9 = r27
            r14 = r30
            r15 = r32
            r27 = r33
            r13 = r35
            r25 = r36
            r12 = r37
            r30 = r43
            r24 = r73
            r4 = r3
            r3 = r74
        L6fd:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4     // Catch: java.lang.Throwable -> L741
            java.lang.String r4 = r4.getUrl()     // Catch: java.lang.Throwable -> L741
            kotlin.text.Regex r10 = new kotlin.text.Regex     // Catch: java.lang.Throwable -> L741
            java.lang.String r11 = "anilist\\.co/anime/(\\d+)"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L741
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch: java.lang.Throwable -> L741
            r73 = r3
            r74 = r4
            r3 = 0
            r4 = 0
            kotlin.text.MatchResult r10 = kotlin.text.Regex.find$default(r10, r11, r3, r2, r4)     // Catch: java.lang.Throwable -> L73b
            if (r10 == 0) goto L72d
            java.util.List r3 = r10.getGroupValues()     // Catch: java.lang.Throwable -> L73b
            if (r3 == 0) goto L72d
            r4 = 1
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r3, r4)     // Catch: java.lang.Throwable -> L73b
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L73b
            if (r3 == 0) goto L72d
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)     // Catch: java.lang.Throwable -> L73b
            goto L72e
        L72d:
            r3 = 0
        L72e:
            r13.element = r3     // Catch: java.lang.Throwable -> L73b
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L73b
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L73b
            r3 = r73
            r10 = r15
            goto L7ca
        L73b:
            r0 = move-exception
            r3 = r73
            r4 = r7
            goto L7bf
        L741:
            r0 = move-exception
            r73 = r3
            r4 = r7
            goto L7bf
        L747:
            r0 = move-exception
            r5 = r17
            r6 = r25
            r24 = r73
            r3 = r74
            r9 = r27
            r14 = r30
            r15 = r32
            r27 = r33
            r13 = r35
            r25 = r36
            r12 = r37
            r30 = r43
            goto L7bf
        L762:
            r0 = move-exception
            r73 = r4
            r4 = r74
            r74 = r73
            r73 = r1
            r40 = r5
            r43 = r6
            r27 = r7
            r28 = r8
            r30 = r9
            r32 = r10
            r33 = r11
            r35 = r12
            r34 = r13
            r36 = r14
            r37 = r15
            r1 = r18
            r6 = r25
            goto L7aa
        L786:
            r0 = move-exception
            r73 = r4
            r4 = r74
            r74 = r73
            r73 = r1
            r40 = r5
            r43 = r6
            r27 = r7
            r28 = r8
            r30 = r9
            r32 = r10
            r33 = r11
            r35 = r12
            r34 = r13
            r36 = r14
            r37 = r15
            r1 = r18
            r6 = r25
            r2 = 2
        L7aa:
            r5 = r3
            r24 = r73
            r3 = r74
            r9 = r27
            r14 = r30
            r15 = r32
            r27 = r33
            r13 = r35
            r25 = r36
            r12 = r37
            r30 = r43
        L7bf:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.constructor-impl(r0)
            r7 = r4
            r10 = r15
        L7ca:
            r15 = r9
            r4 = r10
            r8 = r13
            r9 = r14
            r10 = r24
            r11 = r25
            r13 = r27
            r2 = r30
            r24 = r7
            r7 = r12
            r14 = r28
            r25 = r6
            r12 = r34
            r6 = r40
            goto L820
        L7e2:
            r73 = r4
            r4 = r74
            r74 = r73
            r73 = r1
            r40 = r5
            r43 = r6
            r27 = r7
            r28 = r8
            r30 = r9
            r32 = r10
            r33 = r11
            r35 = r12
            r34 = r13
            r36 = r14
            r37 = r15
            r1 = r18
            r6 = r25
            r2 = 2
            r5 = r3
            r10 = r73
            r3 = r74
            r24 = r4
            r15 = r27
            r4 = r32
            r13 = r33
            r8 = r35
            r11 = r36
            r7 = r37
            r2 = r43
            r14 = r28
            r12 = r34
            r6 = r40
        L820:
            if (r4 == 0) goto L93a
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L8f0
            r0 = r3
            r27 = 0
            com.lagradost.nicehttp.Requests r16 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> L8f0
            r5.L$0 = r3     // Catch: java.lang.Throwable -> L8f0
            r5.L$1 = r6     // Catch: java.lang.Throwable -> L8f0
            r5.L$2 = r2     // Catch: java.lang.Throwable -> L8f0
            r5.L$3 = r15     // Catch: java.lang.Throwable -> L8f0
            r5.L$4 = r14     // Catch: java.lang.Throwable -> L8f0
            r5.L$5 = r13     // Catch: java.lang.Throwable -> L8f0
            r5.L$6 = r12     // Catch: java.lang.Throwable -> L8f0
            r5.L$7 = r11     // Catch: java.lang.Throwable -> L8f0
            r5.L$8 = r10     // Catch: java.lang.Throwable -> L8f0
            r73 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)     // Catch: java.lang.Throwable -> L8f0
            r5.L$9 = r0     // Catch: java.lang.Throwable -> L8f0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)     // Catch: java.lang.Throwable -> L8f0
            r5.L$10 = r0     // Catch: java.lang.Throwable -> L8f0
            r5.L$11 = r9     // Catch: java.lang.Throwable -> L8f0
            r5.L$12 = r8     // Catch: java.lang.Throwable -> L8f0
            r5.L$13 = r7     // Catch: java.lang.Throwable -> L8f0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r73)     // Catch: java.lang.Throwable -> L8f0
            r5.L$14 = r0     // Catch: java.lang.Throwable -> L8f0
            r0 = 3
            r5.label = r0     // Catch: java.lang.Throwable -> L8f0
            r17 = r5
            r5 = 0
            r40 = r6
            r6 = 0
            r37 = r7
            r7 = 0
            r35 = r8
            r8 = 0
            r30 = r9
            r9 = 0
            r18 = r10
            r10 = 0
            r36 = r11
            r11 = 0
            r34 = r12
            r33 = r13
            r12 = 0
            r28 = r14
            r14 = 0
            r19 = r15
            r15 = 0
            r32 = r3
            r3 = r16
            r16 = 0
            r41 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r43 = r19
            r19 = 0
            r72 = r25
            r25 = r2
            r2 = r72
            java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Throwable -> L8e1
            if (r0 != r2) goto L896
            return r2
        L896:
            r8 = r73
            r15 = r4
            r14 = r30
            r13 = r35
            r12 = r37
            r4 = r0
            r30 = r25
            r0 = r27
            r27 = r33
            r25 = r36
        L8a8:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4     // Catch: java.lang.Throwable -> L8df
            java.lang.String r3 = r4.getUrl()     // Catch: java.lang.Throwable -> L8df
            kotlin.text.Regex r4 = new kotlin.text.Regex     // Catch: java.lang.Throwable -> L8df
            java.lang.String r5 = "myanimelist\\.net/anime/(\\d+)"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L8df
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch: java.lang.Throwable -> L8df
            r6 = 0
            r7 = 0
            r10 = 2
            kotlin.text.MatchResult r4 = kotlin.text.Regex.find$default(r4, r5, r6, r10, r7)     // Catch: java.lang.Throwable -> L8df
            if (r4 == 0) goto L8d5
            java.util.List r4 = r4.getGroupValues()     // Catch: java.lang.Throwable -> L8df
            if (r4 == 0) goto L8d5
            r5 = 1
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r5)     // Catch: java.lang.Throwable -> L8df
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L8df
            if (r4 == 0) goto L8d5
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)     // Catch: java.lang.Throwable -> L8df
            goto L8d6
        L8d5:
            r4 = 0
        L8d6:
            r12.element = r4     // Catch: java.lang.Throwable -> L8df
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L8df
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L8df
            goto L925
        L8df:
            r0 = move-exception
            goto L91c
        L8e1:
            r0 = move-exception
            r15 = r4
            r14 = r30
            r27 = r33
            r13 = r35
            r12 = r37
            r30 = r25
            r25 = r36
            goto L91c
        L8f0:
            r0 = move-exception
            r17 = r25
            r25 = r2
            r2 = r17
            r32 = r3
            r17 = r5
            r40 = r6
            r37 = r7
            r35 = r8
            r30 = r9
            r41 = r10
            r36 = r11
            r34 = r12
            r33 = r13
            r28 = r14
            r43 = r15
            r15 = r4
            r14 = r30
            r27 = r33
            r13 = r35
            r12 = r37
            r30 = r25
            r25 = r36
        L91c:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.constructor-impl(r0)
        L925:
            r7 = r12
            r8 = r13
            r9 = r14
            r4 = r15
            r11 = r25
            r13 = r27
            r14 = r28
            r3 = r32
            r12 = r34
            r6 = r40
            r10 = r41
            r15 = r43
            goto L95a
        L93a:
            r17 = r25
            r25 = r2
            r2 = r17
            r32 = r3
            r17 = r5
            r40 = r6
            r37 = r7
            r35 = r8
            r30 = r9
            r41 = r10
            r36 = r11
            r34 = r12
            r33 = r13
            r28 = r14
            r43 = r15
            r30 = r25
        L95a:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r16 = new kotlin.jvm.internal.Ref$ObjectRef
            r16.<init>()
            if (r9 == 0) goto L989
            r73 = r9
            r18 = 0
            r74 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r25 = r2
            java.lang.String r2 = "https://api.ani.zip/mappings?themoviedb_id="
            java.lang.StringBuilder r0 = r0.append(r2)
            r2 = r73
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L98e
        L989:
            r74 = r0
            r25 = r2
            r0 = 0
        L98e:
            java.lang.Object r2 = r8.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L9b5
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r18 = 0
            r73 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r19 = r4
            java.lang.String r4 = "https://api.ani.zip/mappings?anilist_id="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L9ba
        L9b5:
            r73 = r3
            r19 = r4
            r2 = 0
        L9ba:
            java.lang.Object r3 = r7.element
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L9e1
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r4 = 0
            r18 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r27 = r5
            java.lang.String r5 = "https://api.ani.zip/mappings?mal_id="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r3 = r4.toString()
            goto L9e4
        L9e1:
            r27 = r5
            r3 = 0
        L9e4:
            java.lang.String[] r0 = new java.lang.String[]{r0, r2, r3}
            java.util.List r0 = kotlin.collections.CollectionsKt.listOfNotNull(r0)
            java.util.Iterator r2 = r0.iterator()
            r3 = r73
            r73 = r75
            r18 = r1
            r75 = r2
            r2 = r12
            r1 = r14
            r5 = r15
            r4 = r17
            r28 = r19
            r15 = r6
            r12 = r11
            r14 = r13
            r17 = r16
            r16 = r25
            r6 = r27
            r13 = r30
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r74
            r74 = r0
        La13:
            boolean r0 = r75.hasNext()
            if (r0 == 0) goto Le26
            java.lang.Object r0 = r75.next()
            r19 = r6
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Ld53
            r0 = r3
            r25 = 0
            com.lagradost.nicehttp.Requests r46 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> Ld53
            r4.L$0 = r3     // Catch: java.lang.Throwable -> Ld53
            r4.L$1 = r15     // Catch: java.lang.Throwable -> Ld53
            r4.L$2 = r13     // Catch: java.lang.Throwable -> Ld53
            r4.L$3 = r5     // Catch: java.lang.Throwable -> Ld53
            r4.L$4 = r1     // Catch: java.lang.Throwable -> Ld53
            r4.L$5 = r14     // Catch: java.lang.Throwable -> Ld53
            r4.L$6 = r2     // Catch: java.lang.Throwable -> Ld53
            r4.L$7 = r12     // Catch: java.lang.Throwable -> Ld53
            r4.L$8 = r11     // Catch: java.lang.Throwable -> Ld53
            r27 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)     // Catch: java.lang.Throwable -> Ld53
            r4.L$9 = r0     // Catch: java.lang.Throwable -> Ld53
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)     // Catch: java.lang.Throwable -> Ld53
            r4.L$10 = r0     // Catch: java.lang.Throwable -> Ld53
            r4.L$11 = r10     // Catch: java.lang.Throwable -> Ld53
            r4.L$12 = r9     // Catch: java.lang.Throwable -> Ld53
            r4.L$13 = r8     // Catch: java.lang.Throwable -> Ld53
            r4.L$14 = r7     // Catch: java.lang.Throwable -> Ld53
            r30 = r1
            r1 = r19
            r4.L$15 = r1     // Catch: java.lang.Throwable -> Ld1d
            r19 = r1
            r1 = r17
            r4.L$16 = r1     // Catch: java.lang.Throwable -> Lce6
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r74)     // Catch: java.lang.Throwable -> Lce6
            r4.L$17 = r0     // Catch: java.lang.Throwable -> Lce6
            r17 = r1
            r1 = r75
            r4.L$18 = r1     // Catch: java.lang.Throwable -> Lcb3
            r4.L$19 = r6     // Catch: java.lang.Throwable -> Lcb3
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27)     // Catch: java.lang.Throwable -> Lcb3
            r4.L$20 = r0     // Catch: java.lang.Throwable -> Lcb3
            r0 = 4
            r4.label = r0     // Catch: java.lang.Throwable -> Lcb3
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r61 = 4094(0xffe, float:5.737E-42)
            r62 = 0
            r60 = r4
            r47 = r6
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r57, r58, r59, r60, r61, r62)     // Catch: java.lang.Throwable -> Lc84
            r6 = r16
            if (r4 != r6) goto La9d
            return r6
        La9d:
            r32 = r9
            r9 = r8
            r8 = r27
            r27 = r10
            r10 = r32
            r32 = r2
            r35 = r5
            r5 = r6
            r36 = r13
            r33 = r14
            r37 = r15
            r15 = r17
            r6 = r19
            r34 = r30
            r2 = r73
            r14 = r74
            r13 = r1
            r1 = r3
            r30 = r11
            r11 = r12
            r12 = r47
            r3 = r60
        Lac4:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4     // Catch: java.lang.Throwable -> Lc71
            java.lang.String r0 = r4.getText()     // Catch: java.lang.Throwable -> Lc71
            r4 = r0
            com.lagradost.cloudstream3.utils.AppUtils r0 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE     // Catch: java.lang.Throwable -> Lc71
            r16 = r0
            r73 = r4
            r17 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Laeb
            r0 = r16
            r19 = 0
            java.lang.Class<com.phisher98.MetaAnimeData> r40 = com.phisher98.MetaAnimeData.class
            kotlin.reflect.KType r40 = kotlin.jvm.internal.Reflection.typeOf(r40)     // Catch: java.lang.Throwable -> Laeb
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r20)     // Catch: java.lang.Throwable -> Laeb
            kotlinx.serialization.KSerializer r40 = kotlinx.serialization.SerializersKt.serializer(r40)     // Catch: java.lang.Throwable -> Laeb
            java.lang.Object r0 = kotlin.Result.constructor-impl(r40)     // Catch: java.lang.Throwable -> Laeb
            goto Laf6
        Laeb:
            r0 = move-exception
            kotlin.Result$Companion r19 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Lc71
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> Lc71
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> Lc71
        Laf6:
            java.lang.Throwable r19 = kotlin.Result.exceptionOrNull-impl(r0)     // Catch: java.lang.Throwable -> Lc71
            if (r19 != 0) goto Lb03
            r75 = r1
            r40 = r2
            r41 = r3
            goto Lb40
        Lb03:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Lb2f
            r0 = 0
            kotlinx.serialization.json.Json r40 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> Lb2f
            r74 = r0
            kotlinx.serialization.modules.SerializersModule r0 = r40.getSerializersModule()     // Catch: java.lang.Throwable -> Lb2f
            java.lang.Class<com.phisher98.MetaAnimeData> r40 = com.phisher98.MetaAnimeData.class
            r75 = r1
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r40)     // Catch: java.lang.Throwable -> Lb29
            r40 = r2
            r41 = r3
            r2 = 2
            r3 = 0
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r0, r1, r3, r2, r3)     // Catch: java.lang.Throwable -> Lb27
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> Lb27
            goto Lb40
        Lb27:
            r0 = move-exception
            goto Lb36
        Lb29:
            r0 = move-exception
            r40 = r2
            r41 = r3
            goto Lb36
        Lb2f:
            r0 = move-exception
            r75 = r1
            r40 = r2
            r41 = r3
        Lb36:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> Lc60
        Lb40:
            boolean r1 = kotlin.Result.isFailure-impl(r0)     // Catch: java.lang.Throwable -> Lc60
            if (r1 == 0) goto Lb47
            r0 = 0
        Lb47:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.Throwable -> Lc60
            r1 = r0
            if (r1 == 0) goto Lb6d
        Lb4d:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> Lb5f kotlinx.serialization.SerializationException -> Lb63
            r2 = r1
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2     // Catch: java.lang.Throwable -> Lb5f kotlinx.serialization.SerializationException -> Lb63
            r3 = r73
            java.lang.Object r0 = r0.decodeFromString(r2, r3)     // Catch: java.lang.Throwable -> Lb5b kotlinx.serialization.SerializationException -> Lb5d
            goto Lb8a
        Lb5b:
            r0 = move-exception
            goto Lb6f
        Lb5d:
            r0 = move-exception
            goto Lb66
        Lb5f:
            r0 = move-exception
            r3 = r73
            goto Lb6f
        Lb63:
            r0 = move-exception
            r3 = r73
        Lb66:
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch: java.lang.Throwable -> Lc60
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r2)     // Catch: java.lang.Throwable -> Lc60
            goto Lb6f
        Lb6d:
            r3 = r73
        Lb6f:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()     // Catch: java.lang.Throwable -> Lc60
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0     // Catch: java.lang.Throwable -> Lc60
            r2 = r3
            r19 = 0
            r43 = 0
            com.phisher98.AnimeDekhoProvider$load$lambda$7$$inlined$parseJson$1 r44 = new com.phisher98.AnimeDekhoProvider$load$lambda$7$$inlined$parseJson$1     // Catch: java.lang.Throwable -> Lc60
            r44.<init>()     // Catch: java.lang.Throwable -> Lc60
            r73 = r1
            r1 = r44
            com.fasterxml.jackson.core.type.TypeReference r1 = (com.fasterxml.jackson.core.type.TypeReference) r1     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r1 = r0.readValue(r2, r1)     // Catch: java.lang.Throwable -> Lc60
            r0 = r1
        Lb8a:
            r7.element = r0     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r0 = r7.element     // Catch: java.lang.Throwable -> Lc60
            com.phisher98.MetaAnimeData r0 = (com.phisher98.MetaAnimeData) r0     // Catch: java.lang.Throwable -> Lc60
            java.util.List r0 = r0.getImages()     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lbca
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> Lc60
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lc60
        Lb9c:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> Lc60
            if (r1 == 0) goto Lbc0
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> Lc60
            r2 = r1
            com.phisher98.MetaImage r2 = (com.phisher98.MetaImage) r2     // Catch: java.lang.Throwable -> Lc60
            r3 = 0
            r73 = r0
            java.lang.String r0 = r2.getCoverType()     // Catch: java.lang.Throwable -> Lc60
            r74 = r1
            java.lang.String r1 = "Fanart"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lbbd
            r0 = r74
            goto Lbc1
        Lbbd:
            r0 = r73
            goto Lb9c
        Lbc0:
            r0 = 0
        Lbc1:
            com.phisher98.MetaImage r0 = (com.phisher98.MetaImage) r0     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lbca
            java.lang.String r0 = r0.getUrl()     // Catch: java.lang.Throwable -> Lc60
            goto Lbcb
        Lbca:
            r0 = 0
        Lbcb:
            r6.element = r0     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r0 = r7.element     // Catch: java.lang.Throwable -> Lc60
            com.phisher98.MetaAnimeData r0 = (com.phisher98.MetaAnimeData) r0     // Catch: java.lang.Throwable -> Lc60
            java.util.List r0 = r0.getImages()     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lc0b
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Throwable -> Lc60
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lc60
        Lbdd:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> Lc60
            if (r1 == 0) goto Lc01
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> Lc60
            r2 = r1
            com.phisher98.MetaImage r2 = (com.phisher98.MetaImage) r2     // Catch: java.lang.Throwable -> Lc60
            r3 = 0
            r73 = r0
            java.lang.String r0 = r2.getCoverType()     // Catch: java.lang.Throwable -> Lc60
            r74 = r1
            java.lang.String r1 = "Poster"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lbfe
            r0 = r74
            goto Lc02
        Lbfe:
            r0 = r73
            goto Lbdd
        Lc01:
            r0 = 0
        Lc02:
            com.phisher98.MetaImage r0 = (com.phisher98.MetaImage) r0     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lc0b
            java.lang.String r0 = r0.getUrl()     // Catch: java.lang.Throwable -> Lc60
            goto Lc0c
        Lc0b:
            r0 = 0
        Lc0c:
            r15.element = r0     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r0 = r10.element     // Catch: java.lang.Throwable -> Lc60
            if (r0 != 0) goto Lc24
            java.lang.Object r0 = r7.element     // Catch: java.lang.Throwable -> Lc60
            com.phisher98.MetaAnimeData r0 = (com.phisher98.MetaAnimeData) r0     // Catch: java.lang.Throwable -> Lc60
            com.phisher98.MetaMappings r0 = r0.getMappings()     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lc21
            java.lang.Integer r0 = r0.getAnilist_id()     // Catch: java.lang.Throwable -> Lc60
            goto Lc22
        Lc21:
            r0 = 0
        Lc22:
            r10.element = r0     // Catch: java.lang.Throwable -> Lc60
        Lc24:
            java.lang.Object r0 = r9.element     // Catch: java.lang.Throwable -> Lc60
            if (r0 != 0) goto Lc3a
            java.lang.Object r0 = r7.element     // Catch: java.lang.Throwable -> Lc60
            com.phisher98.MetaAnimeData r0 = (com.phisher98.MetaAnimeData) r0     // Catch: java.lang.Throwable -> Lc60
            com.phisher98.MetaMappings r0 = r0.getMappings()     // Catch: java.lang.Throwable -> Lc60
            if (r0 == 0) goto Lc37
            java.lang.Integer r0 = r0.getMal_id()     // Catch: java.lang.Throwable -> Lc60
            goto Lc38
        Lc37:
            r0 = 0
        Lc38:
            r9.element = r0     // Catch: java.lang.Throwable -> Lc60
        Lc3a:
            r26 = 1
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r26)     // Catch: java.lang.Throwable -> Lc60
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> Lc60
            r3 = r75
            r8 = r9
            r19 = r31
            r4 = r41
            r31 = r11
            r16 = r5
            r9 = r10
            r17 = r15
            r10 = r27
            r2 = r32
            r1 = r34
            r5 = r35
            r15 = r37
            r11 = r30
            goto Ldad
        Lc60:
            r0 = move-exception
            r1 = r75
            r25 = r9
            r2 = r24
            r4 = r31
            r3 = r41
            r24 = r7
            r31 = r11
            goto Ld88
        Lc71:
            r0 = move-exception
            r75 = r1
            r40 = r2
            r41 = r3
            r25 = r9
            r2 = r24
            r4 = r31
            r24 = r7
            r31 = r11
            goto Ld88
        Lc84:
            r0 = move-exception
            r6 = r16
            r40 = r73
            r32 = r2
            r35 = r5
            r5 = r6
            r25 = r8
            r27 = r10
            r36 = r13
            r33 = r14
            r37 = r15
            r15 = r17
            r6 = r19
            r2 = r24
            r34 = r30
            r4 = r31
            r14 = r74
            r13 = r1
            r1 = r3
            r24 = r7
            r10 = r9
            r30 = r11
            r31 = r12
            r12 = r47
            r3 = r60
            goto Ld88
        Lcb3:
            r0 = move-exception
            r60 = r4
            r47 = r6
            r6 = r16
            r40 = r73
            r32 = r2
            r35 = r5
            r5 = r6
            r25 = r8
            r27 = r10
            r36 = r13
            r33 = r14
            r37 = r15
            r15 = r17
            r6 = r19
            r2 = r24
            r34 = r30
            r4 = r31
            r14 = r74
            r13 = r1
            r1 = r3
            r24 = r7
            r10 = r9
            r30 = r11
            r31 = r12
            r12 = r47
            r3 = r60
            goto Ld88
        Lce6:
            r0 = move-exception
            r17 = r1
            r60 = r4
            r47 = r6
            r6 = r16
            r1 = r75
            r40 = r73
            r32 = r2
            r35 = r5
            r5 = r6
            r25 = r8
            r27 = r10
            r36 = r13
            r33 = r14
            r37 = r15
            r15 = r17
            r6 = r19
            r2 = r24
            r34 = r30
            r4 = r31
            r14 = r74
            r13 = r1
            r1 = r3
            r24 = r7
            r10 = r9
            r30 = r11
            r31 = r12
            r12 = r47
            r3 = r60
            goto Ld88
        Ld1d:
            r0 = move-exception
            r19 = r1
            r60 = r4
            r47 = r6
            r6 = r16
            r1 = r75
            r40 = r73
            r32 = r2
            r35 = r5
            r5 = r6
            r25 = r8
            r27 = r10
            r36 = r13
            r33 = r14
            r37 = r15
            r15 = r17
            r6 = r19
            r2 = r24
            r34 = r30
            r4 = r31
            r14 = r74
            r13 = r1
            r1 = r3
            r24 = r7
            r10 = r9
            r30 = r11
            r31 = r12
            r12 = r47
            r3 = r60
            goto Ld88
        Ld53:
            r0 = move-exception
            r30 = r1
            r60 = r4
            r47 = r6
            r6 = r16
            r1 = r75
            r40 = r73
            r32 = r2
            r35 = r5
            r5 = r6
            r25 = r8
            r27 = r10
            r36 = r13
            r33 = r14
            r37 = r15
            r15 = r17
            r6 = r19
            r2 = r24
            r34 = r30
            r4 = r31
            r14 = r74
            r13 = r1
            r1 = r3
            r24 = r7
            r10 = r9
            r30 = r11
            r31 = r12
            r12 = r47
            r3 = r60
        Ld88:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            r19 = r4
            r7 = r24
            r8 = r25
            r24 = r2
            r4 = r3
            r3 = r1
            r16 = r5
            r9 = r10
            r17 = r15
            r10 = r27
            r11 = r30
            r5 = r35
            r15 = r37
            r2 = r32
            r1 = r34
        Ldad:
            java.lang.Throwable r25 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r25 == 0) goto Ldd7
            r27 = 0
            r73 = r0
            com.lagradost.api.Log r0 = com.lagradost.api.Log.INSTANCE
            r74 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r75 = r2
            java.lang.String r2 = "Error fetching ani.zip data for url "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AnimeDekho"
            r0.e(r2, r1)
            goto Lddd
        Ldd7:
            r73 = r0
            r74 = r1
            r75 = r2
        Lddd:
            r21 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r21)
            boolean r1 = kotlin.Result.isFailure-impl(r73)
            if (r1 == 0) goto Ldeb
            goto Lded
        Ldeb:
            r0 = r73
        Lded:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Le12
            r50 = r75
            r0 = r5
            r49 = r6
            r5 = r16
            r51 = r31
            r48 = r33
            r13 = r36
            r31 = r74
            r53 = r8
            r54 = r9
            r55 = r10
            r52 = r11
            r32 = r15
            r47 = r17
            goto Le4c
        Le12:
            r1 = r74
            r2 = r75
            r75 = r13
            r74 = r14
            r12 = r31
            r14 = r33
            r13 = r36
            r73 = r40
            r31 = r19
            goto La13
        Le26:
            r30 = r1
            r60 = r4
            r19 = r6
            r6 = r16
            r40 = r73
            r50 = r2
            r0 = r5
            r5 = r6
            r51 = r12
            r48 = r14
            r49 = r19
            r19 = r31
            r14 = r74
            r31 = r30
            r53 = r8
            r54 = r9
            r55 = r10
            r52 = r11
            r32 = r15
            r47 = r17
        Le4c:
            java.lang.String r1 = "ul.seasons-lst li"
            org.jsoup.select.Elements r15 = r0.select(r1)
            boolean r2 = r15.isEmpty()
            if (r2 == 0) goto Lf35
            r30 = r3
            com.lagradost.cloudstream3.MainAPI r30 = (com.lagradost.cloudstream3.MainAPI) r30
            com.lagradost.cloudstream3.TvType r33 = com.lagradost.cloudstream3.TvType.Movie
            com.lagradost.cloudstream3.utils.AppUtils r1 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            com.phisher98.AnimeDekhoProvider$Media r34 = new com.phisher98.AnimeDekhoProvider$Media
            java.lang.String r35 = r13.getUrl()
            r26 = 1
            java.lang.Integer r37 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r26)
            r38 = 2
            r39 = 0
            r36 = 0
            r34.<init>(r35, r36, r37, r38, r39)
            r2 = r34
            java.lang.String r34 = r1.toJson(r2)
            com.phisher98.AnimeDekhoProvider$load$4 r46 = new com.phisher98.AnimeDekhoProvider$load$4
            r56 = 0
            r46.<init>(r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r2 = r47
            r6 = r48
            r8 = r49
            r9 = r50
            r12 = r51
            r11 = r52
            r10 = r53
            r35 = r46
            kotlin.jvm.functions.Function2 r35 = (kotlin.jvm.functions.Function2) r35
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r4.L$0 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r32)
            r4.L$1 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$2 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r4.L$3 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r31)
            r4.L$4 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r4.L$5 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$6 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r4.L$7 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r4.L$8 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r4.L$9 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)
            r4.L$10 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r55)
            r4.L$11 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r54)
            r4.L$12 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$13 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r4.L$14 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r4.L$15 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r4.L$16 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r4.L$17 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r4.L$18 = r1
            r1 = 0
            r4.L$19 = r1
            r4.L$20 = r1
            r1 = 5
            r4.label = r1
            r36 = r4
            java.lang.Object r4 = com.lagradost.cloudstream3.MainAPIKt.newMovieLoadResponse(r30, r31, r32, r33, r34, r35, r36)
            if (r4 != r5) goto Lf18
            return r5
        Lf18:
            r1 = r8
            r8 = r7
            r7 = r1
            r20 = r0
            r0 = r3
            r18 = r6
            r17 = r9
            r9 = r10
            r1 = r12
            r5 = r14
            r12 = r28
            r3 = r36
            r10 = r54
            r6 = r2
            r14 = r11
            r2 = r40
            r11 = r55
        Lf31:
            com.lagradost.cloudstream3.LoadResponse r4 = (com.lagradost.cloudstream3.LoadResponse) r4
            goto L1503
        Lf35:
            r16 = r5
            r73 = r13
            r74 = r14
            r75 = r15
            r13 = r31
            r14 = r32
            r2 = r47
            r6 = r48
            r8 = r49
            r9 = r50
            r12 = r51
            r11 = r52
            r10 = r53
            r15 = r54
            r5 = r4
            r4 = r55
            if (r4 != 0) goto Lf6b
            r47 = r2
            java.lang.Object r2 = r7.element
            com.phisher98.MetaAnimeData r2 = (com.phisher98.MetaAnimeData) r2
            if (r2 == 0) goto Lf69
            com.phisher98.MetaMappings r2 = r2.getMappings()
            if (r2 == 0) goto Lf69
            java.lang.Integer r2 = r2.getThemoviedb_id()
            goto Lf6e
        Lf69:
            r2 = 0
            goto Lf6e
        Lf6b:
            r47 = r2
            r2 = r4
        Lf6e:
            java.util.LinkedHashMap r17 = new java.util.LinkedHashMap
            r17.<init>()
            r49 = r8
            r8 = r17
            java.util.Map r8 = (java.util.Map) r8
            r17 = r7
            java.lang.String r7 = "1865f43a0549ca50d341dd9ab8b29f49"
            org.jsoup.select.Elements r1 = r0.select(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r20 = 0
            java.util.ArrayList r25 = new java.util.ArrayList
            r25.<init>()
            java.util.Collection r25 = (java.util.Collection) r25
            r27 = r1
            r30 = r25
            r25 = 0
            r31 = r27
            r32 = 0
            java.util.Iterator r33 = r31.iterator()
        Lf9a:
            boolean r34 = r33.hasNext()
            if (r34 == 0) goto Lfce
            java.lang.Object r34 = r33.next()
            r35 = r34
            r36 = 0
            r37 = r35
            org.jsoup.nodes.Element r37 = (org.jsoup.nodes.Element) r37
            r41 = 0
            if (r37 == 0) goto Lfc1
            r41 = r37
            r37 = 0
            r43 = r1
            r53 = r10
            r1 = r30
            r10 = r41
            r1.add(r10)
            goto Lfc7
        Lfc1:
            r43 = r1
            r53 = r10
            r1 = r30
        Lfc7:
            r30 = r1
            r1 = r43
            r10 = r53
            goto Lf9a
        Lfce:
            r43 = r1
            r53 = r10
            r1 = r30
            java.util.List r1 = (java.util.List) r1
            r10 = r1
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            r20 = 0
            java.util.ArrayList r25 = new java.util.ArrayList
            r25.<init>()
            r27 = r10
            r10 = r25
            java.util.Collection r10 = (java.util.Collection) r10
            r25 = r27
            r30 = 0
            r31 = r25
            r32 = 0
            java.util.Iterator r33 = r31.iterator()
        Lff5:
            boolean r34 = r33.hasNext()
            if (r34 == 0) goto L1066
            java.lang.Object r34 = r33.next()
            r35 = r34
            r36 = 0
            r37 = r1
            r1 = r35
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
            r41 = 0
            r54 = r15
            r15 = r39
            org.jsoup.nodes.Element r39 = r1.selectFirst(r15)
            if (r39 == 0) goto L104a
            r43 = r1
            java.lang.String r1 = r39.text()
            if (r1 == 0) goto L1041
            r55 = r4
            r52 = r11
            r39 = r15
            r15 = r38
            r4 = 2
            r11 = 0
            java.lang.String r1 = kotlin.text.StringsKt.substringAfter$default(r1, r15, r11, r4, r11)
            if (r1 == 0) goto L103c
            r38 = r15
            r15 = r18
            java.lang.String r1 = kotlin.text.StringsKt.substringBefore$default(r1, r15, r11, r4, r11)
            if (r1 == 0) goto L1054
            java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
            goto L1055
        L103c:
            r38 = r15
            r15 = r18
            goto L1054
        L1041:
            r55 = r4
            r52 = r11
            r39 = r15
            r15 = r18
            goto L1054
        L104a:
            r43 = r1
            r55 = r4
            r52 = r11
            r39 = r15
            r15 = r18
        L1054:
            r1 = 0
        L1055:
            if (r1 == 0) goto L105b
            r4 = 0
            r10.add(r1)
        L105b:
            r18 = r15
            r1 = r37
            r11 = r52
            r15 = r54
            r4 = r55
            goto Lff5
        L1066:
            r37 = r1
            r55 = r4
            r52 = r11
            r54 = r15
            r15 = r18
            r1 = r10
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.distinct(r1)
            if (r2 == 0) goto L112f
            com.phisher98.AnimeDekhoProvider$load$5 r4 = new com.phisher98.AnimeDekhoProvider$load$5
            r11 = 0
            r4.<init>(r2, r7, r8, r11)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5.L$0 = r3
            r5.L$1 = r14
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r73)
            r5.L$2 = r10
            r5.L$3 = r0
            r5.L$4 = r13
            r5.L$5 = r6
            r5.L$6 = r9
            r5.L$7 = r12
            r11 = r52
            r5.L$8 = r11
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r5.L$9 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)
            r5.L$10 = r10
            r10 = r55
            r5.L$11 = r10
            r18 = r0
            r0 = r54
            r5.L$12 = r0
            r0 = r53
            r5.L$13 = r0
            r0 = r17
            r5.L$14 = r0
            r0 = r49
            r5.L$15 = r0
            r0 = r47
            r5.L$16 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r74)
            r5.L$17 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r75)
            r5.L$18 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$19 = r0
            r5.L$20 = r8
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r5.L$21 = r0
            r0 = r37
            r5.L$22 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r5.L$23 = r0
            r0 = 6
            r5.label = r0
            java.lang.Object r0 = com.lagradost.cloudstream3.ParCollectionsKt.amap(r1, r4, r5)
            r4 = r16
            if (r0 != r4) goto L10f4
            return r4
        L10f4:
            r20 = r1
            r0 = r3
            r3 = r5
            r34 = r6
            r6 = r8
            r33 = r9
            r31 = r11
            r32 = r12
            r30 = r24
            r8 = r37
            r37 = r73
            r1 = r74
            r9 = r75
            r5 = r4
            r12 = r7
            r4 = r19
            r7 = r2
            r2 = r40
        L1112:
            r11 = r9
            r56 = r31
            r55 = r32
            r52 = r34
            r59 = r54
            r9 = r1
            r54 = r33
            r60 = r10
            r48 = r14
            r10 = r17
            r51 = r47
            r58 = r53
            r47 = r13
            r1 = r18
            r53 = r49
            goto L1167
        L112f:
            r18 = r0
            r4 = r16
            r11 = r52
            r10 = r55
            r20 = r1
            r0 = r3
            r3 = r5
            r52 = r6
            r6 = r8
            r56 = r11
            r55 = r12
            r30 = r24
            r8 = r37
            r59 = r54
            r37 = r73
            r11 = r75
            r5 = r4
            r12 = r7
            r54 = r9
            r4 = r19
            r9 = r74
            r7 = r2
            r2 = r40
            r60 = r10
            r48 = r14
            r10 = r17
            r1 = r18
            r51 = r47
            r58 = r53
            r47 = r13
            r53 = r49
        L1167:
            r13 = r8
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r14 = 0
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            r73 = r0
            r0 = r16
            java.util.Collection r0 = (java.util.Collection) r0
            r16 = r13
            r17 = 0
            r18 = r16
            r19 = 0
            java.util.Iterator r24 = r18.iterator()
        L1182:
            boolean r25 = r24.hasNext()
            r74 = r2
            java.lang.String r2 = "a"
            if (r25 == 0) goto L1342
            java.lang.Object r25 = r24.next()
            r27 = r25
            r31 = 0
            r75 = r4
            r4 = r27
            org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
            r32 = 0
            r33 = r7
            java.lang.String r7 = "h3.title"
            org.jsoup.nodes.Element r7 = r4.selectFirst(r7)
            if (r7 == 0) goto L11ac
            java.lang.String r7 = r7.ownText()
            if (r7 != 0) goto L11ae
        L11ac:
            java.lang.String r7 = "null"
        L11ae:
            r64 = r7
            org.jsoup.nodes.Element r2 = r4.selectFirst(r2)
            if (r2 == 0) goto L130f
            r7 = r23
            java.lang.String r2 = r2.attr(r7)
            if (r2 != 0) goto L11d2
            r35 = r4
            r23 = r8
            r34 = r9
            r22 = r11
            r43 = r13
            r8 = r42
            r45 = 2
            r42 = r38
            r38 = r12
            goto L1323
        L11d2:
            r66 = r2
            java.lang.String r2 = "div > div > figure > img"
            org.jsoup.nodes.Element r2 = r4.selectFirst(r2)
            if (r2 == 0) goto L11e7
            r23 = r8
            r8 = r42
            java.lang.String r2 = r2.attr(r8)
            r65 = r2
            goto L11ed
        L11e7:
            r23 = r8
            r8 = r42
            r65 = 0
        L11ed:
            r2 = r65
            r34 = r9
            r9 = r39
            org.jsoup.nodes.Element r35 = r4.selectFirst(r9)
            if (r35 == 0) goto L11fe
            java.lang.String r35 = r35.text()
            goto L1200
        L11fe:
            r35 = 0
        L1200:
            r36 = r2
            java.lang.String r2 = java.lang.String.valueOf(r35)
            r35 = r4
            r39 = r9
            r22 = r11
            r4 = r38
            r9 = 2
            r11 = 0
            r38 = r12
            java.lang.String r12 = kotlin.text.StringsKt.substringAfter$default(r2, r4, r11, r9, r11)
            java.lang.String r12 = kotlin.text.StringsKt.substringBefore$default(r12, r15, r11, r9, r11)
            java.lang.Integer r9 = kotlin.text.StringsKt.toIntOrNull(r12)
            kotlin.text.Regex r11 = new kotlin.text.Regex
            r41 = r2
            java.lang.String r2 = "E(\\d+)"
            r11.<init>(r2)
            r2 = r41
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r42 = r4
            r40 = r12
            r43 = r13
            r4 = 0
            r12 = 2
            r13 = 0
            kotlin.text.MatchResult r2 = kotlin.text.Regex.find$default(r11, r2, r4, r12, r13)
            if (r2 == 0) goto L1248
            java.util.List r2 = r2.getGroupValues()
            if (r2 == 0) goto L1248
            r4 = 1
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r2, r4)
            java.lang.String r2 = (java.lang.String) r2
            goto L1249
        L1248:
            r2 = r13
        L1249:
            if (r2 == 0) goto L1252
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r2)
            r67 = r4
            goto L1254
        L1252:
            r67 = r13
        L1254:
            r4 = r67
            if (r9 == 0) goto L12ab
            if (r4 == 0) goto L12ab
            java.lang.Object r12 = r6.get(r9)
            com.phisher98.TmdbSeasonResponse r12 = (com.phisher98.TmdbSeasonResponse) r12
            if (r12 == 0) goto L12a6
            java.util.List r12 = r12.getEpisodes()
            if (r12 == 0) goto L12a6
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L126e:
            boolean r44 = r12.hasNext()
            if (r44 == 0) goto L129b
            java.lang.Object r44 = r12.next()
            r46 = r44
            com.phisher98.TmdbEpisode r46 = (com.phisher98.TmdbEpisode) r46
            r49 = 0
            java.lang.Integer r50 = r46.getEpisode_number()
            int r13 = r4.intValue()
            r71 = r2
            if (r50 != 0) goto L128b
            goto L1293
        L128b:
            int r2 = r50.intValue()
            if (r2 != r13) goto L1293
            r2 = 1
            goto L1294
        L1293:
            r2 = 0
        L1294:
            if (r2 == 0) goto L1297
            goto L129f
        L1297:
            r2 = r71
            r13 = 0
            goto L126e
        L129b:
            r71 = r2
            r44 = 0
        L129f:
            r2 = r44
            com.phisher98.TmdbEpisode r2 = (com.phisher98.TmdbEpisode) r2
            r62 = r2
            goto L12af
        L12a6:
            r71 = r2
            r62 = 0
            goto L12af
        L12ab:
            r71 = r2
            r62 = 0
        L12af:
            if (r62 != 0) goto L12db
            if (r9 != 0) goto L12b6
            r12 = 1
            goto L12bd
        L12b6:
            int r2 = r9.intValue()
            r12 = 1
            if (r2 == r12) goto L12bf
        L12bd:
            if (r9 != 0) goto L12dc
        L12bf:
            java.lang.Object r2 = r10.element
            com.phisher98.MetaAnimeData r2 = (com.phisher98.MetaAnimeData) r2
            if (r2 == 0) goto L12dc
            java.util.Map r2 = r2.getEpisodes()
            if (r2 == 0) goto L12dc
            if (r71 != 0) goto L12d0
            java.lang.String r13 = ""
            goto L12d2
        L12d0:
            r13 = r71
        L12d2:
            java.lang.Object r2 = r2.get(r13)
            com.phisher98.MetaEpisode r2 = (com.phisher98.MetaEpisode) r2
            r63 = r2
            goto L12de
        L12db:
            r12 = 1
        L12dc:
            r63 = 0
        L12de:
            r2 = r73
            com.lagradost.cloudstream3.MainAPI r2 = (com.lagradost.cloudstream3.MainAPI) r2
            com.lagradost.cloudstream3.utils.AppUtils r13 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            com.phisher98.AnimeDekhoProvider$Media r65 = new com.phisher98.AnimeDekhoProvider$Media
            r45 = 2
            java.lang.Integer r68 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r45)
            r69 = 2
            r70 = 0
            r67 = 0
            r65.<init>(r66, r67, r68, r69, r70)
            r12 = r65
            r26 = r66
            java.lang.String r12 = r13.toJson(r12)
            com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda1 r61 = new com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda1
            r67 = r4
            r66 = r9
            r65 = r36
            r61.<init>(r62, r63, r64, r65, r66, r67)
            r4 = r61
            com.lagradost.cloudstream3.Episode r2 = com.lagradost.cloudstream3.MainAPIKt.newEpisode(r2, r12, r4)
            goto L1324
        L130f:
            r35 = r4
            r34 = r9
            r22 = r11
            r43 = r13
            r7 = r23
            r45 = 2
            r23 = r8
            r8 = r42
            r42 = r38
            r38 = r12
        L1323:
            r2 = 0
        L1324:
            if (r2 == 0) goto L132a
            r4 = 0
            r0.add(r2)
        L132a:
            r2 = r74
            r4 = r75
            r11 = r22
            r9 = r34
            r12 = r38
            r38 = r42
            r13 = r43
            r42 = r8
            r8 = r23
            r23 = r7
            r7 = r33
            goto L1182
        L1342:
            r75 = r4
            r33 = r7
            r34 = r9
            r22 = r11
            r38 = r12
            r43 = r13
            r7 = r23
            r23 = r8
            r8 = r42
            r50 = r0
            java.util.List r50 = (java.util.List) r50
            java.lang.String r0 = "div.swiper-wrapper article"
            org.jsoup.select.Elements r0 = r1.select(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r4 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r11 = 10
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r11)
            r9.<init>(r11)
            java.util.Collection r9 = (java.util.Collection) r9
            r11 = r0
            r12 = 0
            java.util.Iterator r13 = r11.iterator()
        L1377:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L13f0
            java.lang.Object r14 = r13.next()
            r15 = r14
            org.jsoup.nodes.Element r15 = (org.jsoup.nodes.Element) r15
            r16 = 0
            r17 = r0
            java.lang.String r0 = "h2"
            org.jsoup.nodes.Element r0 = r15.selectFirst(r0)
            if (r0 == 0) goto L1396
            java.lang.String r0 = r0.text()
            if (r0 != 0) goto L1398
        L1396:
            java.lang.String r0 = "Unknown"
        L1398:
            r40 = r0
            org.jsoup.nodes.Element r0 = r15.selectFirst(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.attr(r7)
            r18 = r1
            java.lang.String r1 = "figure img"
            org.jsoup.nodes.Element r1 = r15.selectFirst(r1)
            if (r1 == 0) goto L13b4
            java.lang.String r1 = r1.attr(r8)
            goto L13b5
        L13b4:
            r1 = 0
        L13b5:
            r19 = r2
            com.phisher98.AnimeDekhoProvider$Media r2 = new com.phisher98.AnimeDekhoProvider$Media
            r24 = r4
            r21 = 0
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r21)
            r2.<init>(r0, r1, r4)
            com.lagradost.cloudstream3.utils.AppUtils r4 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            java.lang.String r41 = r4.toJson(r2)
            r39 = r73
            com.lagradost.cloudstream3.MainAPI r39 = (com.lagradost.cloudstream3.MainAPI) r39
            com.lagradost.cloudstream3.TvType r42 = com.lagradost.cloudstream3.TvType.Anime
            com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda2 r4 = new com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda2
            r4.<init>(r2)
            r45 = 8
            r46 = 0
            r43 = 0
            r44 = r4
            com.lagradost.cloudstream3.AnimeSearchResponse r4 = com.lagradost.cloudstream3.MainAPIKt.newAnimeSearchResponse$default(r39, r40, r41, r42, r43, r44, r45, r46)
            r9.add(r4)
            r0 = r17
            r1 = r18
            r2 = r19
            r4 = r24
            goto L1377
        L13f0:
            r17 = r0
            r18 = r1
            r24 = r4
            r57 = r9
            java.util.List r57 = (java.util.List) r57
            r46 = r73
            com.lagradost.cloudstream3.MainAPI r46 = (com.lagradost.cloudstream3.MainAPI) r46
            com.lagradost.cloudstream3.TvType r0 = com.lagradost.cloudstream3.TvType.Anime
            com.phisher98.AnimeDekhoProvider$load$6 r49 = new com.phisher98.AnimeDekhoProvider$load$6
            r61 = 0
            r49.<init>(r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61)
            r2 = r50
            r13 = r51
            r1 = r52
            r14 = r53
            r9 = r54
            r51 = r49
            kotlin.jvm.functions.Function2 r51 = (kotlin.jvm.functions.Function2) r51
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r73)
            r3.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r48)
            r3.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r37)
            r3.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18)
            r3.L$3 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r47)
            r3.L$4 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r3.L$5 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r3.L$6 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r55)
            r3.L$7 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r56)
            r3.L$8 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r30)
            r3.L$9 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)
            r3.L$10 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r60)
            r3.L$11 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r59)
            r3.L$12 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r58)
            r3.L$13 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$14 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r3.L$15 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$16 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r34)
            r3.L$17 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)
            r3.L$18 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r33)
            r3.L$19 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r3.L$20 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r38)
            r3.L$21 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)
            r3.L$22 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
            r3.L$23 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$24 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r57)
            r3.L$25 = r4
            r4 = 7
            r3.label = r4
            r50 = 0
            r53 = 8
            r54 = 0
            r49 = r0
            r52 = r3
            java.lang.Object r4 = com.lagradost.cloudstream3.MainAPIKt.newAnimeLoadResponse$default(r46, r47, r48, r49, r50, r51, r52, r53, r54)
            if (r4 != r5) goto L14c7
            return r5
        L14c7:
            r0 = r73
            r2 = r74
            r5 = r75
            r24 = r9
            r15 = r10
            r11 = r22
            r20 = r28
            r12 = r34
            r3 = r52
            r23 = r55
            r22 = r56
            r17 = r58
            r19 = r60
        L14e0:
            com.lagradost.cloudstream3.LoadResponse r4 = (com.lagradost.cloudstream3.LoadResponse) r4
            r6 = r13
            r7 = r14
            r8 = r15
            r9 = r17
            r14 = r22
            r17 = r24
            r24 = r30
            r13 = r37
            r31 = r47
            r32 = r48
            r10 = r59
            r15 = r11
            r11 = r19
            r19 = r5
            r5 = r12
            r12 = r20
            r20 = r18
            r18 = r1
            r1 = r23
        L1503:
            return r4
    }

    static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.phisher98.AnimeDekhoProvider r32, java.lang.String r33, boolean r34, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r35, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r36, kotlin.coroutines.Continuation<? super java.lang.Boolean> r37) {
            r1 = r32
            r2 = r37
            boolean r0 = r2 instanceof com.phisher98.AnimeDekhoProvider.C00021
            if (r0 == 0) goto L18
            r0 = r2
            com.phisher98.AnimeDekhoProvider$loadLinks$1 r0 = (com.phisher98.AnimeDekhoProvider.C00021) r0
            int r3 = r0.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r0.label
            int r3 = r3 - r4
            r0.label = r3
            goto L1d
        L18:
            com.phisher98.AnimeDekhoProvider$loadLinks$1 r0 = new com.phisher98.AnimeDekhoProvider$loadLinks$1
            r0.<init>(r1, r2)
        L1d:
            r3 = r0
            java.lang.Object r4 = r3.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            java.lang.String r6 = "Error:"
            switch(r0) {
                case 0: goto Lfc;
                case 1: goto Ld2;
                case 2: goto L9d;
                case 3: goto L61;
                case 4: goto L33;
                default: goto L2b;
            }
        L2b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L33:
            boolean r0 = r3.Z$0
            java.lang.Object r5 = r3.L$8
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.L$7
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r3.L$6
            org.jsoup.nodes.Document r7 = (org.jsoup.nodes.Document) r7
            java.lang.Object r9 = r3.L$5
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r3.L$4
            com.phisher98.AnimeDekhoProvider$Media r10 = (com.phisher98.AnimeDekhoProvider.Media) r10
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r3.L$2
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.lang.Object r13 = r3.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r3.L$0
            r1 = r14
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)
            r20 = r4
            goto L404
        L61:
            r0 = 0
            boolean r11 = r3.Z$0
            java.lang.Object r12 = r3.L$7
            com.phisher98.AnimeDekhoProvider r12 = (com.phisher98.AnimeDekhoProvider) r12
            java.lang.Object r13 = r3.L$6
            org.jsoup.nodes.Document r13 = (org.jsoup.nodes.Document) r13
            java.lang.Object r14 = r3.L$5
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r15 = r3.L$4
            com.phisher98.AnimeDekhoProvider$Media r15 = (com.phisher98.AnimeDekhoProvider.Media) r15
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r8 = r3.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r7 = r3.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r10 = r3.L$0
            r1 = r10
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Throwable -> L92
            r28 = r1
            r20 = r4
            r2 = r5
            r23 = r6
            r1 = 2
            goto L2e5
        L92:
            r0 = move-exception
            r28 = r1
            r20 = r4
            r2 = r5
            r23 = r6
            r1 = 2
            goto L32d
        L9d:
            boolean r0 = r3.Z$0
            java.lang.Object r7 = r3.L$6
            org.jsoup.nodes.Document r7 = (org.jsoup.nodes.Document) r7
            java.lang.Object r8 = r3.L$5
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r9 = r3.L$4
            com.phisher98.AnimeDekhoProvider$Media r9 = (com.phisher98.AnimeDekhoProvider.Media) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r3.L$2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r3.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$0
            r1 = r13
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)
            r20 = r4
            r2 = r5
            r23 = r6
            r22 = r7
            r25 = r8
            r8 = r9
            r6 = r10
            r5 = r11
            r21 = r12
            r7 = r0
            r4 = r1
            r1 = 2
            goto L26f
        Ld2:
            boolean r0 = r3.Z$0
            java.lang.Object r7 = r3.L$5
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r3.L$4
            com.phisher98.AnimeDekhoProvider$Media r8 = (com.phisher98.AnimeDekhoProvider.Media) r8
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r3.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r3.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r3.L$0
            r1 = r12
            com.phisher98.AnimeDekhoProvider r1 = (com.phisher98.AnimeDekhoProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)
            r20 = r4
            r2 = r5
            r23 = r6
            r4 = r0
            r0 = r1
            r5 = r20
            r1 = 2
            goto L22a
        Lfc:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L1a5
            r7 = r32
            r8 = 0
            com.lagradost.cloudstream3.utils.AppUtils r0 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE     // Catch: java.lang.Throwable -> L1a5
            r9 = r33
            r10 = r0
            r11 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L122
            r0 = r10
            r12 = 0
            java.lang.Class<com.phisher98.AnimeDekhoProvider$Media> r13 = com.phisher98.AnimeDekhoProvider.Media.class
            kotlin.reflect.KType r13 = kotlin.jvm.internal.Reflection.typeOf(r13)     // Catch: java.lang.Throwable -> L122
            java.lang.String r14 = "kotlinx.serialization.serializer.simple"
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r14)     // Catch: java.lang.Throwable -> L122
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.SerializersKt.serializer(r13)     // Catch: java.lang.Throwable -> L122
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> L122
            goto L12d
        L122:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L1a5
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> L1a5
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L1a5
        L12d:
            java.lang.Throwable r12 = kotlin.Result.exceptionOrNull-impl(r0)     // Catch: java.lang.Throwable -> L1a5
            if (r12 != 0) goto L136
            r2 = 0
            r15 = 2
            goto L161
        L136:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L154
            r0 = 0
            kotlinx.serialization.json.Json r13 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L154
            kotlinx.serialization.modules.SerializersModule r13 = r13.getSerializersModule()     // Catch: java.lang.Throwable -> L154
            java.lang.Class<com.phisher98.AnimeDekhoProvider$Media> r14 = com.phisher98.AnimeDekhoProvider.Media.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)     // Catch: java.lang.Throwable -> L154
            r2 = 0
            r15 = 2
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r13, r14, r2, r15, r2)     // Catch: java.lang.Throwable -> L152
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> L152
            goto L161
        L152:
            r0 = move-exception
            goto L157
        L154:
            r0 = move-exception
            r2 = 0
            r15 = 2
        L157:
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L1a3
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Throwable -> L1a3
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L1a3
        L161:
            boolean r12 = kotlin.Result.isFailure-impl(r0)     // Catch: java.lang.Throwable -> L1a3
            if (r12 == 0) goto L168
            r0 = r2
        L168:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.Throwable -> L1a3
            r12 = r0
            if (r12 == 0) goto L183
        L16e:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L17a kotlinx.serialization.SerializationException -> L17c
            r13 = r12
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13     // Catch: java.lang.Throwable -> L17a kotlinx.serialization.SerializationException -> L17c
            java.lang.Object r0 = r0.decodeFromString(r13, r9)     // Catch: java.lang.Throwable -> L17a kotlinx.serialization.SerializationException -> L17c
            goto L19b
        L17a:
            r0 = move-exception
            goto L183
        L17c:
            r0 = move-exception
            r13 = r0
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch: java.lang.Throwable -> L1a3
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r13)     // Catch: java.lang.Throwable -> L1a3
        L183:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()     // Catch: java.lang.Throwable -> L1a3
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0     // Catch: java.lang.Throwable -> L1a3
            r13 = r9
            r14 = 0
            r18 = 0
            com.phisher98.AnimeDekhoProvider$loadLinks$lambda$0$$inlined$parseJson$1 r19 = new com.phisher98.AnimeDekhoProvider$loadLinks$lambda$0$$inlined$parseJson$1     // Catch: java.lang.Throwable -> L1a3
            r19.<init>()     // Catch: java.lang.Throwable -> L1a3
            r2 = r19
            com.fasterxml.jackson.core.type.TypeReference r2 = (com.fasterxml.jackson.core.type.TypeReference) r2     // Catch: java.lang.Throwable -> L1a3
            java.lang.Object r2 = r0.readValue(r13, r2)     // Catch: java.lang.Throwable -> L1a3
            r0 = r2
        L19b:
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0     // Catch: java.lang.Throwable -> L1a3
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L1a3
            goto L1b1
        L1a3:
            r0 = move-exception
            goto L1a7
        L1a5:
            r0 = move-exception
            r15 = 2
        L1a7:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        L1b1:
            java.lang.Throwable r2 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r2 != 0) goto L40b
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            java.lang.String r2 = "Cookie"
            java.lang.String r7 = "toronites_server=vidstream"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r7)
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r2)
            com.lagradost.nicehttp.Requests r7 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r8 = r4
            java.lang.String r4 = r0.getUrl()
            r3.L$0 = r1
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r33)
            r3.L$1 = r9
            r9 = r35
            r3.L$2 = r9
            r10 = r36
            r3.L$3 = r10
            r3.L$4 = r0
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r3.L$5 = r11
            r11 = r34
            r3.Z$0 = r11
            r12 = 1
            r3.label = r12
            r13 = r6
            r6 = 0
            r17 = r3
            r3 = r7
            r7 = 0
            r14 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r18 = r13
            r19 = 1
            r12 = 0
            r20 = r14
            r14 = 0
            r21 = 2
            r15 = 0
            r22 = 0
            r16 = 0
            r23 = r18
            r18 = 4092(0xffc, float:5.734E-42)
            r24 = 1
            r19 = 0
            r1 = r5
            r5 = r2
            r2 = r1
            r1 = 2
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r3 = r17
            if (r4 != r2) goto L21d
            return r2
        L21d:
            r11 = r33
            r10 = r35
            r9 = r36
            r8 = r0
            r7 = r5
            r0 = r32
            r5 = r4
            r4 = r34
        L22a:
            com.lagradost.nicehttp.NiceResponse r5 = (com.lagradost.nicehttp.NiceResponse) r5
            org.jsoup.nodes.Document r5 = r5.getDocument()
            java.lang.String r6 = "iframe.serversel[src]"
            org.jsoup.select.Elements r6 = r5.select(r6)
            java.util.List r6 = (java.util.List) r6
            com.phisher98.AnimeDekhoProvider$loadLinks$2 r12 = new com.phisher98.AnimeDekhoProvider$loadLinks$2
            r13 = 0
            r12.<init>(r0, r10, r9, r13)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r3.L$0 = r0
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$1 = r13
            r3.L$2 = r10
            r3.L$3 = r9
            r3.L$4 = r8
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$5 = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$6 = r13
            r3.Z$0 = r4
            r3.label = r1
            java.lang.Object r6 = com.lagradost.cloudstream3.ParCollectionsKt.amap(r6, r12, r3)
            if (r6 != r2) goto L265
            return r2
        L265:
            r22 = r5
            r25 = r7
            r6 = r9
            r5 = r10
            r21 = r11
            r7 = r4
            r4 = r0
        L26f:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L314
            r0 = r4
            r26 = 0
            com.lagradost.nicehttp.Requests r9 = com.lagradost.cloudstream3.MainActivityKt.getApp()     // Catch: java.lang.Throwable -> L314
            java.lang.String r10 = r8.getUrl()     // Catch: java.lang.Throwable -> L314
            r3.L$0 = r4     // Catch: java.lang.Throwable -> L314
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r21)     // Catch: java.lang.Throwable -> L314
            r3.L$1 = r11     // Catch: java.lang.Throwable -> L314
            r3.L$2 = r5     // Catch: java.lang.Throwable -> L314
            r3.L$3 = r6     // Catch: java.lang.Throwable -> L314
            r3.L$4 = r8     // Catch: java.lang.Throwable -> L314
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)     // Catch: java.lang.Throwable -> L314
            r3.L$5 = r11     // Catch: java.lang.Throwable -> L314
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)     // Catch: java.lang.Throwable -> L314
            r3.L$6 = r11     // Catch: java.lang.Throwable -> L314
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Throwable -> L314
            r3.L$7 = r11     // Catch: java.lang.Throwable -> L314
            r3.Z$0 = r7     // Catch: java.lang.Throwable -> L314
            r11 = 3
            r3.label = r11     // Catch: java.lang.Throwable -> L314
            r11 = r5
            r5 = 0
            r12 = r6
            r6 = 0
            r13 = r7
            r7 = 0
            r14 = r8
            r8 = 0
            r17 = r3
            r3 = r9
            r9 = 0
            r15 = r4
            r4 = r10
            r10 = 0
            r16 = r11
            r11 = 0
            r18 = r12
            r19 = r13
            r12 = 0
            r27 = r14
            r14 = 0
            r28 = r15
            r15 = 0
            r29 = r16
            r16 = 0
            r30 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r31 = r19
            r19 = 0
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Throwable -> L302
            r3 = r17
            if (r4 != r2) goto L2d4
            return r2
        L2d4:
            r12 = r0
            r7 = r21
            r13 = r22
            r14 = r25
            r0 = r26
            r15 = r27
            r8 = r29
            r9 = r30
            r11 = r31
        L2e5:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4     // Catch: java.lang.Throwable -> L300
            org.jsoup.nodes.Document r4 = r4.getDocument()     // Catch: java.lang.Throwable -> L300
            java.lang.String r5 = "body"
            org.jsoup.nodes.Element r4 = r4.selectFirst(r5)     // Catch: java.lang.Throwable -> L300
            if (r4 == 0) goto L2fa
            java.lang.String r5 = "class"
            java.lang.String r10 = r4.attr(r5)     // Catch: java.lang.Throwable -> L300
            goto L2fb
        L2fa:
            r10 = 0
        L2fb:
            java.lang.Object r0 = kotlin.Result.constructor-impl(r10)     // Catch: java.lang.Throwable -> L300
            goto L337
        L300:
            r0 = move-exception
            goto L32d
        L302:
            r0 = move-exception
            r3 = r17
            r7 = r21
            r13 = r22
            r14 = r25
            r15 = r27
            r8 = r29
            r9 = r30
            r11 = r31
            goto L32d
        L314:
            r0 = move-exception
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r27 = r8
            r7 = r21
            r13 = r22
            r14 = r25
            r15 = r27
            r8 = r29
            r9 = r30
            r11 = r31
        L32d:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        L337:
            r10 = r0
            r5 = r7
            r12 = r8
            r0 = r11
            r7 = r13
            r4 = r14
            r11 = r15
            r13 = r9
            r9 = r28
            boolean r6 = kotlin.Result.isFailure-impl(r10)
            if (r6 == 0) goto L348
            r10 = 0
        L348:
            java.lang.String r10 = (java.lang.String) r10
            r6 = r10
            kotlin.text.Regex r8 = new kotlin.text.Regex
            java.lang.String r10 = "(?:term|postid)-(\\d+)"
            r8.<init>(r10)
            if (r6 != 0) goto L358
            java.lang.String r10 = ""
            goto L359
        L358:
            r10 = r6
        L359:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r14 = 0
            r15 = 0
            kotlin.text.MatchResult r1 = kotlin.text.Regex.find$default(r8, r10, r14, r1, r15)
            if (r1 == 0) goto L374
        L364:
            java.util.List r1 = r1.getGroupValues()
            if (r1 == 0) goto L374
        L36b:
            r8 = 1
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r1, r8)
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            goto L375
        L374:
            r10 = r15
        L375:
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L384
            int r1 = r1.length()
            if (r1 != 0) goto L382
            goto L384
        L382:
            r8 = 0
            goto L385
        L384:
            r8 = 1
        L385:
            if (r8 == 0) goto L3a6
            com.lagradost.api.Log r1 = com.lagradost.api.Log.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "No postid/term ID found in body class: "
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r2 = r2.toString()
            r8 = r23
            r1.e(r8, r2)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            return r1
        L3a6:
            kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
            r8 = 10
            r1.<init>(r14, r8)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.toList(r1)
            com.phisher98.AnimeDekhoProvider$loadLinks$3 r8 = new com.phisher98.AnimeDekhoProvider$loadLinks$3
            r14 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r3.L$0 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r3.L$1 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$2 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r3.L$3 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r3.L$4 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r3.L$5 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$6 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r3.L$7 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$8 = r14
            r3.Z$0 = r0
            r14 = 4
            r3.label = r14
            java.lang.Object r1 = com.lagradost.cloudstream3.ParCollectionsKt.amap(r1, r8, r3)
            if (r1 != r2) goto L3fd
            return r2
        L3fd:
            r1 = r13
            r13 = r5
            r5 = r10
            r10 = r11
            r11 = r1
            r1 = r9
            r9 = r4
        L404:
            r24 = 1
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r24)
            return r2
        L40b:
            r20 = r4
            r8 = r6
            r14 = 0
            r0 = 0
            com.lagradost.api.Log r1 = com.lagradost.api.Log.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Failed to parse media JSON "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
            r1.e(r8, r4)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            return r1
    }

    static /* synthetic */ java.lang.Object search$suspendImpl(com.phisher98.AnimeDekhoProvider r22, java.lang.String r23, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse>> r24) {
            r0 = r22
            r1 = r24
            boolean r2 = r1 instanceof com.phisher98.AnimeDekhoProvider.C00031
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.AnimeDekhoProvider$search$1 r2 = (com.phisher98.AnimeDekhoProvider.C00031) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.AnimeDekhoProvider$search$1 r2 = new com.phisher98.AnimeDekhoProvider$search$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r3 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            switch(r5) {
                case 0: goto L46;
                case 1: goto L34;
                default: goto L28;
            }
        L28:
            r17 = r2
            r20 = r3
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            r2.<init>(r3)
            throw r2
        L34:
            java.lang.Object r4 = r2.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.L$0
            r0 = r5
            com.phisher98.AnimeDekhoProvider r0 = (com.phisher98.AnimeDekhoProvider) r0
            kotlin.ResultKt.throwOnFailure(r3)
            r17 = r2
            r20 = r3
            goto La9
        L46:
            kotlin.ResultKt.throwOnFailure(r3)
            r5 = r3
            com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            java.lang.String r6 = r0.getMainUrl()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = "/?s="
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = r23
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r2.L$0 = r0
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r2.L$1 = r8
            r8 = 1
            r2.label = r8
            r8 = r5
            r5 = 0
            r9 = r4
            r4 = r6
            r6 = 0
            r7 = 0
            r10 = r8
            r8 = 0
            r11 = r9
            r9 = 0
            r12 = r10
            r10 = 0
            r13 = r11
            r11 = 0
            r14 = r12
            r15 = r13
            r12 = 0
            r16 = r14
            r14 = 0
            r17 = r15
            r15 = 0
            r18 = r16
            r16 = 0
            r19 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r20 = r19
            r19 = 0
            r21 = r17
            r17 = r2
            r2 = r21
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            if (r3 != r2) goto La7
            return r2
        La7:
            r4 = r23
        La9:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            org.jsoup.nodes.Document r2 = r3.getDocument()
            java.lang.String r3 = "ul[data-results] li article"
            org.jsoup.select.Elements r3 = r2.select(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r5 = 0
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            r7 = r3
            r8 = 0
            r9 = r7
            r10 = 0
            java.util.Iterator r11 = r9.iterator()
        Lc7:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Le5
            java.lang.Object r12 = r11.next()
            r13 = r12
            r14 = 0
            r15 = r13
            org.jsoup.nodes.Element r15 = (org.jsoup.nodes.Element) r15
            r16 = 0
            com.lagradost.cloudstream3.AnimeSearchResponse r15 = r0.toSearchResult(r15)
            if (r15 == 0) goto Le3
            r16 = 0
            r6.add(r15)
        Le3:
            goto Lc7
        Le5:
            java.util.List r6 = (java.util.List) r6
            return r6
    }

    private final com.lagradost.cloudstream3.AnimeSearchResponse toSearchResult(org.jsoup.nodes.Element r12) {
            r11 = this;
            java.lang.String r0 = "a.lnk-blk"
            org.jsoup.nodes.Element r0 = r12.selectFirst(r0)
            r1 = 0
            if (r0 == 0) goto L81
            java.lang.String r2 = "href"
            java.lang.String r0 = r0.attr(r2)
            if (r0 != 0) goto L13
            goto L81
        L13:
            r3 = r0
            java.lang.String r0 = "header h2"
            org.jsoup.nodes.Element r0 = r12.selectFirst(r0)
            if (r0 == 0) goto L22
            java.lang.String r0 = r0.text()
            if (r0 != 0) goto L24
        L22:
            java.lang.String r0 = "null"
        L24:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r10 = r2
            java.lang.String r2 = "div figure img"
            org.jsoup.nodes.Element r4 = r12.selectFirst(r2)
            if (r4 == 0) goto L39
            java.lang.String r5 = "src"
            java.lang.String r4 = r4.attr(r5)
            goto L3a
        L39:
            r4 = r1
        L3a:
            r10.element = r4
            java.lang.Object r4 = r10.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "data:image"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            r7 = 2
            boolean r4 = kotlin.text.StringsKt.contains$default(r4, r5, r6, r7, r1)
            if (r4 == 0) goto L5d
            org.jsoup.nodes.Element r2 = r12.selectFirst(r2)
            if (r2 == 0) goto L5b
            java.lang.String r1 = "data-lazy-src"
            java.lang.String r1 = r2.attr(r1)
        L5b:
            r10.element = r1
        L5d:
            r1 = r11
            com.lagradost.cloudstream3.MainAPI r1 = (com.lagradost.cloudstream3.MainAPI) r1
            com.lagradost.cloudstream3.utils.AppUtils r8 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            com.phisher98.AnimeDekhoProvider$Media r2 = new com.phisher98.AnimeDekhoProvider$Media
            java.lang.Object r4 = r10.element
            java.lang.String r4 = (java.lang.String) r4
            r6 = 4
            r7 = 0
            r5 = 0
            r2.<init>(r3, r4, r5, r6, r7)
            java.lang.String r6 = r8.toJson(r2)
            com.lagradost.cloudstream3.TvType r7 = com.lagradost.cloudstream3.TvType.Anime
            com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda0 r9 = new com.phisher98.AnimeDekhoProvider$$ExternalSyntheticLambda0
            r9.<init>(r10)
            r8 = 0
            r5 = r0
            r4 = r1
            com.lagradost.cloudstream3.AnimeSearchResponse r0 = com.lagradost.cloudstream3.MainAPIKt.newAnimeSearchResponse(r4, r5, r6, r7, r8, r9)
            return r0
        L81:
            return r1
    }

    static final kotlin.Unit toSearchResult$lambda$0(kotlin.jvm.internal.Ref.ObjectRef r1, com.lagradost.cloudstream3.AnimeSearchResponse r2) {
            java.lang.Object r0 = r1.element
            java.lang.String r0 = (java.lang.String) r0
            r2.setPosterUrl(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
    }

    public boolean getHasDownloadSupport() {
            r1 = this;
            boolean r0 = r1.hasDownloadSupport
            return r0
    }

    public boolean getHasMainPage() {
            r1 = this;
            boolean r0 = r1.hasMainPage
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String getLang() {
            r1 = this;
            java.lang.String r0 = r1.lang
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMainPage(int r2, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.MainPageRequest r3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r4) {
            r1 = this;
            java.lang.Object r0 = getMainPage$suspendImpl(r1, r2, r3, r4)
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.util.List<com.lagradost.cloudstream3.MainPageData> getMainPage() {
            r1 = this;
            java.util.List<com.lagradost.cloudstream3.MainPageData> r0 = r1.mainPage
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String getMainUrl() {
            r1 = this;
            java.lang.String r0 = r1.mainUrl
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
            r1 = this;
            java.lang.String r0 = r1.name
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.util.Set<com.lagradost.cloudstream3.TvType> getSupportedTypes() {
            r1 = this;
            java.util.Set<com.lagradost.cloudstream3.TvType> r0 = r1.supportedTypes
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r3) {
            r1 = this;
            java.lang.Object r0 = load$suspendImpl(r1, r2, r3)
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r2, boolean r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
            r1 = this;
            java.lang.Object r0 = loadLinks$suspendImpl(r1, r2, r3, r4, r5, r6)
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse>> r3) {
            r1 = this;
            java.lang.Object r0 = search$suspendImpl(r1, r2, r3)
            return r0
    }

    public void setLang(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            r0.lang = r1
            return
    }

    public void setMainUrl(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            r0.mainUrl = r1
            return
    }

    public void setName(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            r0.name = r1
            return
    }
}
