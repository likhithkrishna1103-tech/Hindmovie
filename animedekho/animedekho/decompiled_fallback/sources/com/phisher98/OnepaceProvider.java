package com.phisher98;

/* JADX INFO: compiled from: OnePace.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020%*\u00020&H\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u001a2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020301H\u0096@¢\u0006\u0002\u00106J\f\u00107\u001a\u00020\u0005*\u00020&H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/phisher98/OnepaceProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getsrcAttribute", "Media", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nOnePace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnePace.kt\ncom/phisher98/OnepaceProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,155:1\n1739#2:156\n1814#2,3:157\n1795#2,10:160\n2068#2:170\n2069#2:172\n1805#2:173\n1795#2,10:193\n2068#2:203\n2069#2:205\n1805#2:206\n1#3:171\n1#3:175\n1#3:204\n1#3:208\n63#4:174\n64#4,15:176\n63#4:207\n64#4,15:209\n50#5:191\n43#5:192\n50#5:224\n43#5:225\n*S KotlinDebug\n*F\n+ 1 OnePace.kt\ncom/phisher98/OnepaceProvider\n*L\n35#1:156\n35#1:157,3\n74#1:160,10\n74#1:170\n74#1:172\n74#1:173\n102#1:193,10\n102#1:203\n102#1:205\n102#1:206\n74#1:171\n80#1:175\n102#1:204\n129#1:208\n80#1:174\n80#1:176,15\n129#1:207\n129#1:209,15\n80#1:191\n80#1:192\n129#1:224\n129#1:225\n*E\n"})
public class OnepaceProvider extends com.lagradost.cloudstream3.MainAPI {
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

    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/OnepaceProvider$Media;", "", "url", "", "poster", "mediaType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Media {

        @org.jetbrains.annotations.Nullable
        private final java.lang.String mediaType;

        @org.jetbrains.annotations.Nullable
        private final java.lang.String poster;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String url;

        public Media(@org.jetbrains.annotations.NotNull java.lang.String r1, @org.jetbrains.annotations.Nullable java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
                r0 = this;
                r0.<init>()
                r0.url = r1
                r0.poster = r2
                r0.mediaType = r3
                return
        }

        public /* synthetic */ Media(java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
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

        public static /* synthetic */ com.phisher98.OnepaceProvider.Media copy$default(com.phisher98.OnepaceProvider.Media r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, int r4, java.lang.Object r5) {
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
                java.lang.String r3 = r0.mediaType
            L12:
                com.phisher98.OnepaceProvider$Media r0 = r0.copy(r1, r2, r3)
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
        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.mediaType
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.OnepaceProvider.Media copy(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.String r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
                r1 = this;
                com.phisher98.OnepaceProvider$Media r0 = new com.phisher98.OnepaceProvider$Media
                r0.<init>(r2, r3, r4)
                return r0
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
                r5 = this;
                r0 = 1
                if (r5 != r6) goto L4
                return r0
            L4:
                boolean r1 = r6 instanceof com.phisher98.OnepaceProvider.Media
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r6
                com.phisher98.OnepaceProvider$Media r1 = (com.phisher98.OnepaceProvider.Media) r1
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
                java.lang.String r3 = r5.mediaType
                java.lang.String r1 = r1.mediaType
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
                if (r1 != 0) goto L2e
                return r2
            L2e:
                return r0
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.String getMediaType() {
                r1 = this;
                java.lang.String r0 = r1.mediaType
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
                java.lang.String r2 = r4.mediaType
                if (r2 != 0) goto L1d
                goto L23
            L1d:
                java.lang.String r2 = r4.mediaType
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
                java.lang.String r2 = r5.mediaType
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

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$getMainPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0, 0, 0}, l = {33}, m = "getMainPage$suspendImpl", n = {"$this", "request", "link", "page"}, nl = {35}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        int I$0;
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.OnepaceProvider this$0;

        AnonymousClass1(com.phisher98.OnepaceProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.AnonymousClass1> r2) {
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
                com.phisher98.OnepaceProvider r0 = r4.this$0
                r1 = 0
                r2 = r4
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r3 = 0
                java.lang.Object r0 = com.phisher98.OnepaceProvider.getMainPage$suspendImpl(r0, r3, r1, r2)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {81, 93, 115}, m = "load$suspendImpl", n = {"$this", "url", "media", "$this", "url", "media", "document", "ArcINT", "element", "title", "poster", "plot", "year", "lst", "$this", "url", "media", "document", "ArcINT", "element", "title", "poster", "plot", "year", "lst", "episodes"}, nl = {82, 102, 92}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00041 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$10;
        java.lang.Object L$11;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        java.lang.Object L$8;
        java.lang.Object L$9;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.OnepaceProvider this$0;

        C00041(com.phisher98.OnepaceProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.C00041> r2) {
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
                com.phisher98.OnepaceProvider r0 = r3.this$0
                r1 = 0
                r2 = r3
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r0 = com.phisher98.OnepaceProvider.load$suspendImpl(r0, r1, r2)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$2, reason: invalid class name */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider$load$2", f = "OnePace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<com.lagradost.cloudstream3.MovieLoadResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ java.lang.String $plot;
        final /* synthetic */ java.lang.String $poster;
        final /* synthetic */ java.lang.Integer $year;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        AnonymousClass2(java.lang.String r2, java.lang.String r3, java.lang.Integer r4, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.AnonymousClass2> r5) {
                r1 = this;
                r1.$poster = r2
                r1.$plot = r3
                r1.$year = r4
                r0 = 2
                r1.<init>(r0, r5)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r5, kotlin.coroutines.Continuation<?> r6) {
                r4 = this;
                com.phisher98.OnepaceProvider$load$2 r0 = new com.phisher98.OnepaceProvider$load$2
                java.lang.String r1 = r4.$poster
                java.lang.String r2 = r4.$plot
                java.lang.Integer r3 = r4.$year
                r0.<init>(r1, r2, r3, r6)
                r0.L$0 = r5
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(com.lagradost.cloudstream3.MovieLoadResponse r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.OnepaceProvider$load$2 r0 = (com.phisher98.OnepaceProvider.AnonymousClass2) r0
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

        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                java.lang.Object r0 = r3.L$0
                com.lagradost.cloudstream3.MovieLoadResponse r0 = (com.lagradost.cloudstream3.MovieLoadResponse) r0
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
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
                kotlin.ResultKt.throwOnFailure(r4)
                java.lang.String r1 = r3.$poster
                r0.setPosterUrl(r1)
                java.lang.String r1 = r3.$plot
                r0.setPlot(r1)
                java.lang.Integer r1 = r3.$year
                r0.setYear(r1)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$load$3, reason: invalid class name */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider$load$3", f = "OnePace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<com.lagradost.cloudstream3.TvSeriesLoadResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ java.lang.String $plot;
        final /* synthetic */ java.lang.String $poster;
        final /* synthetic */ java.lang.Integer $year;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        AnonymousClass3(java.lang.String r2, java.lang.String r3, java.lang.Integer r4, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.AnonymousClass3> r5) {
                r1 = this;
                r1.$poster = r2
                r1.$plot = r3
                r1.$year = r4
                r0 = 2
                r1.<init>(r0, r5)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r5, kotlin.coroutines.Continuation<?> r6) {
                r4 = this;
                com.phisher98.OnepaceProvider$load$3 r0 = new com.phisher98.OnepaceProvider$load$3
                java.lang.String r1 = r4.$poster
                java.lang.String r2 = r4.$plot
                java.lang.Integer r3 = r4.$year
                r0.<init>(r1, r2, r3, r6)
                r0.L$0 = r5
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(com.lagradost.cloudstream3.TvSeriesLoadResponse r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.OnepaceProvider$load$3 r0 = (com.phisher98.OnepaceProvider.AnonymousClass3) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                r1 = this;
                com.lagradost.cloudstream3.TvSeriesLoadResponse r2 = (com.lagradost.cloudstream3.TvSeriesLoadResponse) r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r0 = r1.invoke(r2, r3)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                java.lang.Object r0 = r3.L$0
                com.lagradost.cloudstream3.TvSeriesLoadResponse r0 = (com.lagradost.cloudstream3.TvSeriesLoadResponse) r0
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
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
                kotlin.ResultKt.throwOnFailure(r4)
                java.lang.String r1 = r3.$poster
                r0.setPosterUrl(r1)
                java.lang.String r1 = r3.$plot
                r0.setPlot(r1)
                java.lang.Integer r1 = r3.$year
                r0.setYear(r1)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$loadLinks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {130, 132}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "media", "isCasting", "$this", "data", "subtitleCallback", "callback", "media", "body", "term", "isCasting"}, nl = {131, 138}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00051 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.OnepaceProvider this$0;

        C00051(com.phisher98.OnepaceProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.C00051> r2) {
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
                com.phisher98.OnepaceProvider r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = com.phisher98.OnepaceProvider.loadLinks$suspendImpl(r1, r2, r3, r4, r5, r6)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$loadLinks$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider$loadLinks$2", f = "OnePace.kt", i = {0, 1, 1}, l = {133, 136}, m = "invokeSuspend", n = {"i", "link", "i"}, nl = {134, 137}, s = {"I$0", "L$0", "I$0"}, v = 2)
    static final class C00062 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> $callback;
        final /* synthetic */ com.phisher98.OnepaceProvider.Media $media;
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> $subtitleCallback;
        final /* synthetic */ java.lang.String $term;
        /* synthetic */ int I$0;
        java.lang.Object L$0;
        int label;
        final /* synthetic */ com.phisher98.OnepaceProvider this$0;

        C00062(com.phisher98.OnepaceProvider r2, java.lang.String r3, com.phisher98.OnepaceProvider.Media r4, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.C00062> r7) {
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
                com.phisher98.OnepaceProvider$loadLinks$2 r0 = new com.phisher98.OnepaceProvider$loadLinks$2
                com.phisher98.OnepaceProvider r1 = r7.this$0
                java.lang.String r2 = r7.$term
                com.phisher98.OnepaceProvider$Media r3 = r7.$media
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

        public final java.lang.Object invoke(int r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
                kotlin.coroutines.Continuation r0 = r2.create(r0, r4)
                com.phisher98.OnepaceProvider$loadLinks$2 r0 = (com.phisher98.OnepaceProvider.C00062) r0
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

        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
                r20 = this;
                r0 = r20
                int r1 = r0.I$0
                java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r0.label
                switch(r3) {
                    case 0: goto L24;
                    case 1: goto L1e;
                    case 2: goto L15;
                    default: goto Ld;
                }
            Ld:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
                r2.<init>(r3)
                throw r2
            L15:
                java.lang.Object r2 = r0.L$0
                java.lang.String r2 = (java.lang.String) r2
                kotlin.ResultKt.throwOnFailure(r21)
                goto Lb6
            L1e:
                kotlin.ResultKt.throwOnFailure(r21)
                r3 = r21
                goto L85
            L24:
                kotlin.ResultKt.throwOnFailure(r21)
                com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                com.phisher98.OnepaceProvider r4 = r0.this$0
                java.lang.String r4 = r4.getMainUrl()
                java.lang.String r5 = r0.$term
                com.phisher98.OnepaceProvider$Media r6 = r0.$media
                java.lang.String r6 = r6.getMediaType()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.StringBuilder r4 = r7.append(r4)
                java.lang.String r7 = "/?trdekho="
                java.lang.StringBuilder r4 = r4.append(r7)
                java.lang.StringBuilder r4 = r4.append(r1)
                java.lang.String r7 = "&trid="
                java.lang.StringBuilder r4 = r4.append(r7)
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r5 = "&trtype="
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.StringBuilder r4 = r4.append(r6)
                java.lang.String r4 = r4.toString()
                r17 = r0
                kotlin.coroutines.Continuation r17 = (kotlin.coroutines.Continuation) r17
                r0.I$0 = r1
                r5 = 1
                r0.label = r5
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r18 = 4094(0xffe, float:5.737E-42)
                r19 = 0
                java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
                if (r3 != r2) goto L85
                return r2
            L85:
                com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
                org.jsoup.nodes.Document r3 = r3.getDocument()
                java.lang.String r4 = "iframe"
                org.jsoup.nodes.Element r3 = r3.selectFirst(r4)
                if (r3 == 0) goto Lb9
            L94:
                java.lang.String r4 = "src"
                java.lang.String r3 = r3.attr(r4)
                if (r3 == 0) goto Lb9
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r4 = r0.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r5 = r0.$callback
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                r0.L$0 = r7
                r0.I$0 = r1
                r7 = 2
                r0.label = r7
                java.lang.Object r4 = com.lagradost.cloudstream3.utils.ExtractorApiKt.loadExtractor(r3, r4, r5, r6)
                if (r4 != r2) goto Lb5
                return r2
            Lb5:
                r2 = r3
            Lb6:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            Lb9:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
                return r2
        }
    }

    /* JADX INFO: renamed from: com.phisher98.OnepaceProvider$search$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OnePace.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.OnepaceProvider", f = "OnePace.kt", i = {0, 0}, l = {73}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {74}, s = {"L$0", "L$1"}, v = 2)
    static final class C00071 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.OnepaceProvider this$0;

        C00071(com.phisher98.OnepaceProvider r1, kotlin.coroutines.Continuation<? super com.phisher98.OnepaceProvider.C00071> r2) {
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
                com.phisher98.OnepaceProvider r0 = r3.this$0
                r1 = 0
                r2 = r3
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r0 = com.phisher98.OnepaceProvider.search$suspendImpl(r0, r1, r2)
                return r0
        }
    }

    public static /* synthetic */ kotlin.Unit $r8$lambda$pomU8X4bMlA97fbj30QvF6E4CZI(java.lang.String r0, java.lang.String r1, java.lang.Integer r2, com.lagradost.cloudstream3.Episode r3) {
            kotlin.Unit r0 = load$lambda$0$0(r0, r1, r2, r3)
            return r0
    }

    public OnepaceProvider() {
            r4 = this;
            r4.<init>()
            java.lang.String r0 = "https://onepace.me"
            r4.mainUrl = r0
            java.lang.String r0 = "OnePace"
            r4.name = r0
            r0 = 1
            r4.hasMainPage = r0
            java.lang.String r1 = "en"
            r4.lang = r1
            com.lagradost.cloudstream3.TvType r1 = com.lagradost.cloudstream3.TvType.Anime
            java.util.Set r1 = kotlin.collections.SetsKt.setOf(r1)
            r4.supportedTypes = r1
            r1 = 2
            kotlin.Pair[] r1 = new kotlin.Pair[r1]
            java.lang.String r2 = "/series/one-pace-english-sub/"
            java.lang.String r3 = "One Pace English Sub"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "/series/one-pace-english-dub/"
            java.lang.String r3 = "One Pace English Dub"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r1[r0] = r2
            java.util.List r0 = com.lagradost.cloudstream3.MainAPIKt.mainPageOf(r1)
            r4.mainPage = r0
            return
    }

    static /* synthetic */ java.lang.Object getMainPage$suspendImpl(com.phisher98.OnepaceProvider r22, int r23, com.lagradost.cloudstream3.MainPageRequest r24, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r25) {
            r0 = r22
            r1 = r25
            boolean r2 = r1 instanceof com.phisher98.OnepaceProvider.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.OnepaceProvider$getMainPage$1 r2 = (com.phisher98.OnepaceProvider.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.OnepaceProvider$getMainPage$1 r2 = new com.phisher98.OnepaceProvider$getMainPage$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r3 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            switch(r5) {
                case 0: goto L4c;
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
            int r4 = r2.I$0
            java.lang.Object r5 = r2.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.L$1
            com.lagradost.cloudstream3.MainPageRequest r6 = (com.lagradost.cloudstream3.MainPageRequest) r6
            java.lang.Object r7 = r2.L$0
            r0 = r7
            com.phisher98.OnepaceProvider r0 = (com.phisher98.OnepaceProvider) r0
            kotlin.ResultKt.throwOnFailure(r3)
            r17 = r2
            r20 = r3
            goto Lbe
        L4c:
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
            if (r3 != r2) goto Lb9
            return r2
        Lb9:
            r6 = r24
            r5 = r4
            r4 = r23
        Lbe:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            org.jsoup.nodes.Document r2 = r3.getDocument()
            java.lang.String r3 = "div.seasons.aa-crd > div.seasons-bx"
            org.jsoup.select.Elements r3 = r2.select(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r7 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = 10
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r9)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            r9 = r3
            r10 = 0
            java.util.Iterator r11 = r9.iterator()
        Le0:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Lf6
            java.lang.Object r12 = r11.next()
            r13 = r12
            org.jsoup.nodes.Element r13 = (org.jsoup.nodes.Element) r13
            r14 = 0
            com.lagradost.cloudstream3.AnimeSearchResponse r13 = r0.toSearchResult(r13)
            r8.add(r13)
            goto Le0
        Lf6:
            java.util.List r8 = (java.util.List) r8
            java.lang.String r3 = r6.getName()
            r7 = 4
            r9 = 0
            com.lagradost.cloudstream3.HomePageResponse r3 = com.lagradost.cloudstream3.MainAPIKt.newHomePageResponse$default(r3, r8, r9, r7, r9)
            return r3
    }

    private final java.lang.String getsrcAttribute(org.jsoup.nodes.Element r9) {
            r8 = this;
            java.lang.String r0 = "src"
            java.lang.String r0 = r9.attr(r0)
            java.lang.String r1 = "data-src"
            java.lang.String r1 = r9.attr(r1)
            java.lang.String r2 = "data-lazy-src"
            java.lang.String r2 = r9.attr(r2)
            java.lang.String r3 = "http"
            r4 = 0
            r5 = 2
            r6 = 0
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r0, r3, r4, r5, r6)
            if (r7 == 0) goto L20
            r3 = r0
            goto L32
        L20:
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r1, r3, r4, r5, r6)
            if (r7 == 0) goto L28
            r3 = r1
            goto L32
        L28:
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r2, r3, r4, r5, r6)
            if (r3 == 0) goto L30
            r3 = r2
            goto L32
        L30:
            java.lang.String r3 = ""
        L32:
            return r3
    }

    private static final kotlin.Unit load$lambda$0$0(java.lang.String r1, java.lang.String r2, java.lang.Integer r3, com.lagradost.cloudstream3.Episode r4) {
            r4.setName(r1)
            r4.setPosterUrl(r2)
            r4.setSeason(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
    }

    static /* synthetic */ java.lang.Object load$suspendImpl(com.phisher98.OnepaceProvider r41, java.lang.String r42, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r43) {
            r1 = r41
            r2 = r43
            boolean r0 = r2 instanceof com.phisher98.OnepaceProvider.C00041
            if (r0 == 0) goto L18
            r0 = r2
            com.phisher98.OnepaceProvider$load$1 r0 = (com.phisher98.OnepaceProvider.C00041) r0
            int r3 = r0.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r0.label
            int r3 = r3 - r4
            r0.label = r3
            goto L1d
        L18:
            com.phisher98.OnepaceProvider$load$1 r0 = new com.phisher98.OnepaceProvider$load$1
            r0.<init>(r1, r2)
        L1d:
            r9 = r0
            java.lang.Object r3 = r9.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.label
            r5 = 1
            r6 = 2
            r7 = 0
            switch(r0) {
                case 0: goto Lbb;
                case 1: goto La0;
                case 2: goto L6c;
                case 3: goto L34;
                default: goto L2c;
            }
        L2c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L34:
            java.lang.Object r0 = r9.L$11
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r4 = r9.L$10
            org.jsoup.select.Elements r4 = (org.jsoup.select.Elements) r4
            java.lang.Object r5 = r9.L$9
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r6 = r9.L$8
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r9.L$7
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r9.L$6
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r10 = r9.L$5
            org.jsoup.nodes.Element r10 = (org.jsoup.nodes.Element) r10
            java.lang.Object r11 = r9.L$4
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r9.L$3
            org.jsoup.nodes.Document r12 = (org.jsoup.nodes.Document) r12
            java.lang.Object r13 = r9.L$2
            com.phisher98.OnepaceProvider$Media r13 = (com.phisher98.OnepaceProvider.Media) r13
            java.lang.Object r14 = r9.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r9.L$0
            r1 = r15
            com.phisher98.OnepaceProvider r1 = (com.phisher98.OnepaceProvider) r1
            kotlin.ResultKt.throwOnFailure(r3)
            r21 = r3
            goto L438
        L6c:
            java.lang.Object r0 = r9.L$10
            org.jsoup.select.Elements r0 = (org.jsoup.select.Elements) r0
            java.lang.Object r4 = r9.L$9
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r5 = r9.L$8
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r9.L$7
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r9.L$6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r9.L$5
            org.jsoup.nodes.Element r8 = (org.jsoup.nodes.Element) r8
            java.lang.Object r10 = r9.L$4
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r9.L$3
            org.jsoup.nodes.Document r11 = (org.jsoup.nodes.Document) r11
            java.lang.Object r12 = r9.L$2
            com.phisher98.OnepaceProvider$Media r12 = (com.phisher98.OnepaceProvider.Media) r12
            java.lang.Object r13 = r9.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r9.L$0
            r1 = r14
            com.phisher98.OnepaceProvider r1 = (com.phisher98.OnepaceProvider) r1
            kotlin.ResultKt.throwOnFailure(r3)
            r21 = r3
            goto L2e0
        La0:
            java.lang.Object r0 = r9.L$2
            com.phisher98.OnepaceProvider$Media r0 = (com.phisher98.OnepaceProvider.Media) r0
            java.lang.Object r8 = r9.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r10 = r9.L$0
            r1 = r10
            com.phisher98.OnepaceProvider r1 = (com.phisher98.OnepaceProvider) r1
            kotlin.ResultKt.throwOnFailure(r3)
            r13 = r0
            r0 = r1
            r21 = r3
            r1 = r4
            r5 = r8
            r2 = 2
            r23 = 1
            goto L19b
        Lbb:
            kotlin.ResultKt.throwOnFailure(r3)
            com.lagradost.cloudstream3.utils.AppUtils r8 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r0 = r42
            r10 = r0
            r11 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Ldc
            r0 = r8
            r12 = 0
            java.lang.Class<com.phisher98.OnepaceProvider$Media> r13 = com.phisher98.OnepaceProvider.Media.class
            kotlin.reflect.KType r13 = kotlin.jvm.internal.Reflection.typeOf(r13)     // Catch: java.lang.Throwable -> Ldc
            java.lang.String r14 = "kotlinx.serialization.serializer.simple"
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r14)     // Catch: java.lang.Throwable -> Ldc
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.SerializersKt.serializer(r13)     // Catch: java.lang.Throwable -> Ldc
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> Ldc
            goto Le7
        Ldc:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        Le7:
            java.lang.Throwable r12 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r12 != 0) goto Lee
        Led:
            goto L114
        Lee:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L108
            r0 = 0
            kotlinx.serialization.json.Json r13 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L108
            kotlinx.serialization.modules.SerializersModule r13 = r13.getSerializersModule()     // Catch: java.lang.Throwable -> L108
            java.lang.Class<com.phisher98.OnepaceProvider$Media> r14 = com.phisher98.OnepaceProvider.Media.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)     // Catch: java.lang.Throwable -> L108
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r13, r14, r7, r6, r7)     // Catch: java.lang.Throwable -> L108
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> L108
            goto Led
        L108:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            goto Led
        L114:
            boolean r12 = kotlin.Result.isFailure-impl(r0)
            if (r12 == 0) goto L11b
            r0 = r7
        L11b:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
            r12 = r0
            if (r12 == 0) goto L136
        L121:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L12d kotlinx.serialization.SerializationException -> L12f
            r13 = r12
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13     // Catch: java.lang.Throwable -> L12d kotlinx.serialization.SerializationException -> L12f
            java.lang.Object r0 = r0.decodeFromString(r13, r10)     // Catch: java.lang.Throwable -> L12d kotlinx.serialization.SerializationException -> L12f
            goto L14d
        L12d:
            r0 = move-exception
            goto L136
        L12f:
            r0 = move-exception
            r13 = r0
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r13)
        L136:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0
            r13 = r10
            r14 = 0
            r15 = 0
            com.phisher98.OnepaceProvider$load$suspendImpl$$inlined$parseJson$1 r16 = new com.phisher98.OnepaceProvider$load$suspendImpl$$inlined$parseJson$1
            r16.<init>()
            r15 = r16
            com.fasterxml.jackson.core.type.TypeReference r15 = (com.fasterxml.jackson.core.type.TypeReference) r15
            java.lang.Object r0 = r0.readValue(r13, r15)
        L14d:
            com.phisher98.OnepaceProvider$Media r0 = (com.phisher98.OnepaceProvider.Media) r0
            r8 = r3
            com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r10 = r4
            java.lang.String r4 = r0.getUrl()
            r9.L$0 = r1
            r11 = r42
            r9.L$1 = r11
            r9.L$2 = r0
            r9.label = r5
            r12 = 1
            r5 = 0
            r13 = 2
            r6 = 0
            r14 = r7
            r7 = 0
            r15 = r8
            r8 = 0
            r17 = r9
            r9 = 0
            r16 = r10
            r10 = 0
            r11 = 0
            r18 = 1
            r19 = 2
            r12 = 0
            r20 = r14
            r14 = 0
            r21 = r15
            r15 = 0
            r22 = r16
            r16 = 0
            r23 = 1
            r18 = 4094(0xffe, float:5.737E-42)
            r24 = 2
            r19 = 0
            r1 = r22
            r2 = 2
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r9 = r17
            if (r3 != r1) goto L196
            return r1
        L196:
            r5 = r42
            r13 = r0
            r0 = r41
        L19b:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            org.jsoup.nodes.Document r12 = r3.getDocument()
            java.lang.String r3 = r13.getMediaType()
            if (r3 == 0) goto L1af
            java.lang.String r4 = "Arc "
            r14 = 0
            java.lang.String r7 = kotlin.text.StringsKt.substringAfter$default(r3, r4, r14, r2, r14)
            goto L1b0
        L1af:
            r7 = 0
        L1b0:
            r11 = r7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "div.seasons.aa-crd > div.seasons-bx:contains("
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r11)
            java.lang.String r4 = ")"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            org.jsoup.nodes.Element r10 = r12.selectFirst(r3)
            java.lang.String r3 = r13.getMediaType()
            if (r3 != 0) goto L1d6
            java.lang.String r3 = "No Title"
        L1d6:
            r4 = r3
            java.lang.String r14 = "https://images3.alphacoders.com/134/1342304.jpeg"
            java.lang.String r3 = "div.entry-content p"
            org.jsoup.nodes.Element r3 = r12.selectFirst(r3)
            java.lang.String r6 = "content"
            if (r3 == 0) goto L1f5
            java.lang.String r3 = r3.text()
            if (r3 == 0) goto L1f5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim(r3)
            java.lang.String r7 = r3.toString()
            if (r7 != 0) goto L203
        L1f5:
            java.lang.String r3 = "meta[name=twitter:description]"
            org.jsoup.nodes.Element r3 = r12.selectFirst(r3)
            if (r3 == 0) goto L202
            java.lang.String r7 = r3.attr(r6)
            goto L203
        L202:
            r7 = 0
        L203:
            r15 = r7
            java.lang.String r3 = "span.year"
            org.jsoup.nodes.Element r3 = r12.selectFirst(r3)
            java.lang.String r7 = "-"
            if (r3 == 0) goto L221
            java.lang.String r3 = r3.text()
            if (r3 == 0) goto L221
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim(r3)
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L238
        L221:
        L222:
            java.lang.String r3 = "meta[property=og:updated_time]"
            org.jsoup.nodes.Element r3 = r12.selectFirst(r3)
            if (r3 == 0) goto L237
            java.lang.String r3 = r3.attr(r6)
            if (r3 == 0) goto L237
        L231:
            r6 = 0
            java.lang.String r3 = kotlin.text.StringsKt.substringBefore$default(r3, r7, r6, r2, r6)
            goto L238
        L237:
            r3 = 0
        L238:
            if (r3 == 0) goto L241
        L23c:
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)
            goto L242
        L241:
            r3 = 0
        L242:
            java.lang.String r6 = "ul.seasons-lst.anm-a li"
            if (r10 == 0) goto L24c
            org.jsoup.select.Elements r8 = r10.select(r6)
            goto L24d
        L24c:
            r8 = 0
        L24d:
            r16 = r8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16)
            boolean r8 = r16.isEmpty()
            if (r8 == 0) goto L2e4
            r6 = r0
            com.lagradost.cloudstream3.MainAPI r6 = (com.lagradost.cloudstream3.MainAPI) r6
            r7 = r6
            com.lagradost.cloudstream3.TvType r6 = com.lagradost.cloudstream3.TvType.Movie
            com.lagradost.cloudstream3.utils.AppUtils r8 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            com.phisher98.Media r24 = new com.phisher98.Media
            java.lang.String r25 = r13.getUrl()
            java.lang.Integer r27 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r23)
            r28 = 2
            r29 = 0
            r26 = 0
            r24.<init>(r25, r26, r27, r28, r29)
            r2 = r24
            java.lang.String r2 = r8.toJson(r2)
            com.phisher98.OnepaceProvider$load$2 r8 = new com.phisher98.OnepaceProvider$load$2
            r41 = r2
            r2 = 0
            r8.<init>(r14, r15, r3, r2)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r9.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r9.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r9.L$2 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r9.L$3 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r9.L$4 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$5 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r9.L$6 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r9.L$7 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r9.L$8 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r9.L$9 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r9.L$10 = r2
            r2 = 2
            r9.label = r2
            r2 = r3
            r3 = r7
            r7 = r41
            java.lang.Object r3 = com.lagradost.cloudstream3.MainAPIKt.newMovieLoadResponse(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r1) goto L2d4
            return r1
        L2d4:
            r1 = r0
            r7 = r4
            r8 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r6 = r14
            r0 = r16
            r4 = r2
            r13 = r5
            r5 = r15
        L2e0:
            com.lagradost.cloudstream3.LoadResponse r3 = (com.lagradost.cloudstream3.LoadResponse) r3
            goto L444
        L2e4:
            r2 = r3
            org.jsoup.select.Elements r3 = r10.select(r6)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r6 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            r17 = r3
            r18 = 0
            r22 = r17
            r23 = 0
            java.util.Iterator r24 = r22.iterator()
        L2ff:
            boolean r25 = r24.hasNext()
            if (r25 == 0) goto L3ba
            java.lang.Object r25 = r24.next()
            r26 = r25
            r27 = 0
            r41 = r0
            r0 = r26
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            r28 = 0
            r42 = r3
            java.lang.String r3 = "h3.title"
            org.jsoup.nodes.Element r3 = r0.selectFirst(r3)
            if (r3 == 0) goto L325
            java.lang.String r3 = r3.ownText()
            if (r3 != 0) goto L327
        L325:
            java.lang.String r3 = "null"
        L327:
            r29 = r4
            java.lang.String r4 = "a"
            org.jsoup.nodes.Element r4 = r0.selectFirst(r4)
            if (r4 == 0) goto L39b
            r30 = r5
            java.lang.String r5 = "href"
            java.lang.String r4 = r4.attr(r5)
            if (r4 != 0) goto L344
            r37 = r0
            r38 = r6
            r19 = r10
            r39 = 2
            goto L3a5
        L344:
            r32 = r4
            java.lang.String r4 = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/OnePack.png"
            java.lang.String r5 = "h3.title > span"
            org.jsoup.nodes.Element r5 = r0.selectFirst(r5)
            if (r5 == 0) goto L355
            java.lang.String r5 = r5.text()
            goto L356
        L355:
            r5 = 0
        L356:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r37 = r0
            java.lang.String r0 = "S"
            r38 = r6
            r19 = r10
            r6 = 2
            r10 = 0
            java.lang.String r0 = kotlin.text.StringsKt.substringAfter$default(r5, r0, r10, r6, r10)
            java.lang.String r0 = kotlin.text.StringsKt.substringBefore$default(r0, r7, r10, r6, r10)
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r0)
            r10 = r41
            com.lagradost.cloudstream3.MainAPI r10 = (com.lagradost.cloudstream3.MainAPI) r10
            r39 = 2
            com.lagradost.cloudstream3.utils.AppUtils r6 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            com.phisher98.AnimeDekhoProvider$Media r31 = new com.phisher98.AnimeDekhoProvider$Media
            java.lang.Integer r34 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r39)
            r35 = 2
            r36 = 0
            r33 = 0
            r31.<init>(r32, r33, r34, r35, r36)
            r40 = r31
            r31 = r0
            r0 = r40
            java.lang.String r0 = r6.toJson(r0)
            com.phisher98.OnepaceProvider$$ExternalSyntheticLambda0 r6 = new com.phisher98.OnepaceProvider$$ExternalSyntheticLambda0
            r6.<init>(r3, r4, r5)
            com.lagradost.cloudstream3.Episode r0 = com.lagradost.cloudstream3.MainAPIKt.newEpisode(r10, r0, r6)
            goto L3a6
        L39b:
            r37 = r0
            r30 = r5
            r38 = r6
            r19 = r10
            r39 = 2
        L3a5:
            r0 = 0
        L3a6:
            if (r0 == 0) goto L3ac
            r3 = 0
            r8.add(r0)
        L3ac:
            r0 = r41
            r3 = r42
            r10 = r19
            r4 = r29
            r5 = r30
            r6 = r38
            goto L2ff
        L3ba:
            r41 = r0
            r42 = r3
            r29 = r4
            r30 = r5
            r38 = r6
            r19 = r10
            r7 = r8
            java.util.List r7 = (java.util.List) r7
            r3 = r41
            com.lagradost.cloudstream3.MainAPI r3 = (com.lagradost.cloudstream3.MainAPI) r3
            com.lagradost.cloudstream3.TvType r6 = com.lagradost.cloudstream3.TvType.TvSeries
            com.phisher98.OnepaceProvider$load$3 r0 = new com.phisher98.OnepaceProvider$load$3
            r10 = 0
            r0.<init>(r14, r15, r2, r10)
            r8 = r0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r41)
            r9.L$0 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r30)
            r9.L$1 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r9.L$2 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r9.L$3 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r9.L$4 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
            r9.L$5 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r29)
            r9.L$6 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r9.L$7 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r9.L$8 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r9.L$9 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r9.L$10 = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r9.L$11 = r0
            r0 = 3
            r9.label = r0
            java.lang.Object r3 = com.lagradost.cloudstream3.MainAPIKt.newTvSeriesLoadResponse(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r1) goto L42d
            return r1
        L42d:
            r1 = r41
            r8 = r4
            r7 = r14
            r6 = r15
            r4 = r16
            r10 = r19
            r14 = r5
            r5 = r2
        L438:
            com.lagradost.cloudstream3.LoadResponse r3 = (com.lagradost.cloudstream3.LoadResponse) r3
            r0 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
        L444:
            return r3
    }

    static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.phisher98.OnepaceProvider r25, java.lang.String r26, boolean r27, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r28, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r29, kotlin.coroutines.Continuation<? super java.lang.Boolean> r30) {
            r1 = r25
            r2 = r30
            boolean r0 = r2 instanceof com.phisher98.OnepaceProvider.C00051
            if (r0 == 0) goto L18
            r0 = r2
            com.phisher98.OnepaceProvider$loadLinks$1 r0 = (com.phisher98.OnepaceProvider.C00051) r0
            int r3 = r0.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r0.label
            int r3 = r3 - r4
            r0.label = r3
            goto L1d
        L18:
            com.phisher98.OnepaceProvider$loadLinks$1 r0 = new com.phisher98.OnepaceProvider$loadLinks$1
            r0.<init>(r1, r2)
        L1d:
            r3 = r0
            java.lang.Object r4 = r3.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            switch(r0) {
                case 0: goto L7e;
                case 1: goto L5b;
                case 2: goto L34;
                default: goto L2c;
            }
        L2c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L34:
            boolean r0 = r3.Z$0
            java.lang.Object r5 = r3.L$6
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.L$5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r8 = r3.L$4
            com.phisher98.OnepaceProvider$Media r8 = (com.phisher98.OnepaceProvider.Media) r8
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r3.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r3.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r3.L$0
            r1 = r12
            com.phisher98.OnepaceProvider r1 = (com.phisher98.OnepaceProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)
            r24 = r4
            r13 = 1
            goto L1fa
        L5b:
            boolean r0 = r3.Z$0
            java.lang.Object r9 = r3.L$4
            com.phisher98.OnepaceProvider$Media r9 = (com.phisher98.OnepaceProvider.Media) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r3.L$2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r3.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r3.L$0
            r1 = r13
            com.phisher98.OnepaceProvider r1 = (com.phisher98.OnepaceProvider) r1
            kotlin.ResultKt.throwOnFailure(r4)
            r6 = r1
            r24 = r4
            r1 = r5
            r8 = r9
            r9 = r11
            r2 = 2
            goto L171
        L7e:
            kotlin.ResultKt.throwOnFailure(r4)
            com.lagradost.cloudstream3.utils.AppUtils r9 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r10 = r26
            r11 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L9e
            r0 = r9
            r12 = 0
            java.lang.Class<com.phisher98.OnepaceProvider$Media> r13 = com.phisher98.OnepaceProvider.Media.class
            kotlin.reflect.KType r13 = kotlin.jvm.internal.Reflection.typeOf(r13)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r14 = "kotlinx.serialization.serializer.simple"
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r14)     // Catch: java.lang.Throwable -> L9e
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.SerializersKt.serializer(r13)     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> L9e
            goto La9
        L9e:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        La9:
            java.lang.Throwable r12 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r12 != 0) goto Lb0
        Laf:
            goto Ld6
        Lb0:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Lca
            r0 = 0
            kotlinx.serialization.json.Json r13 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> Lca
            kotlinx.serialization.modules.SerializersModule r13 = r13.getSerializersModule()     // Catch: java.lang.Throwable -> Lca
            java.lang.Class<com.phisher98.OnepaceProvider$Media> r14 = com.phisher98.OnepaceProvider.Media.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)     // Catch: java.lang.Throwable -> Lca
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r13, r14, r8, r6, r8)     // Catch: java.lang.Throwable -> Lca
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> Lca
            goto Laf
        Lca:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            goto Laf
        Ld6:
            boolean r12 = kotlin.Result.isFailure-impl(r0)
            if (r12 == 0) goto Ldd
            r0 = r8
        Ldd:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
            r12 = r0
            if (r12 == 0) goto Lf8
        Le3:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> Lef kotlinx.serialization.SerializationException -> Lf1
            r13 = r12
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13     // Catch: java.lang.Throwable -> Lef kotlinx.serialization.SerializationException -> Lf1
            java.lang.Object r0 = r0.decodeFromString(r13, r10)     // Catch: java.lang.Throwable -> Lef kotlinx.serialization.SerializationException -> Lf1
            goto L10f
        Lef:
            r0 = move-exception
            goto Lf8
        Lf1:
            r0 = move-exception
            r13 = r0
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r13)
        Lf8:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0
            r13 = r10
            r14 = 0
            r15 = 0
            com.phisher98.OnepaceProvider$loadLinks$suspendImpl$$inlined$parseJson$1 r16 = new com.phisher98.OnepaceProvider$loadLinks$suspendImpl$$inlined$parseJson$1
            r16.<init>()
            r15 = r16
            com.fasterxml.jackson.core.type.TypeReference r15 = (com.fasterxml.jackson.core.type.TypeReference) r15
            java.lang.Object r0 = r0.readValue(r13, r15)
        L10f:
            com.phisher98.OnepaceProvider$Media r0 = (com.phisher98.OnepaceProvider.Media) r0
            com.lagradost.nicehttp.Requests r9 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r10 = r4
            java.lang.String r4 = r0.getUrl()
            r3.L$0 = r1
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)
            r3.L$1 = r11
            r11 = r28
            r3.L$2 = r11
            r12 = r29
            r3.L$3 = r12
            r3.L$4 = r0
            r13 = r27
            r3.Z$0 = r13
            r3.label = r7
            r14 = r5
            r5 = 0
            r15 = 2
            r6 = 0
            r16 = 1
            r7 = 0
            r17 = r8
            r8 = 0
            r18 = r17
            r17 = r3
            r3 = r9
            r9 = 0
            r19 = r10
            r10 = 0
            r11 = 0
            r12 = 0
            r20 = r14
            r14 = 0
            r21 = 2
            r15 = 0
            r22 = 1
            r16 = 0
            r23 = r18
            r18 = 4094(0xffe, float:5.737E-42)
            r24 = r19
            r19 = 0
            r1 = r20
            r2 = 2
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r3 = r17
            if (r4 != r1) goto L166
            return r1
        L166:
            r6 = r25
            r12 = r26
            r9 = r28
            r10 = r29
            r8 = r0
            r0 = r27
        L171:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4
            org.jsoup.nodes.Document r4 = r4.getDocument()
            java.lang.String r5 = "body"
            org.jsoup.nodes.Element r4 = r4.selectFirst(r5)
            r5 = 0
            if (r4 == 0) goto L207
            java.lang.String r7 = "class"
            java.lang.String r4 = r4.attr(r7)
            if (r4 != 0) goto L18a
            goto L207
        L18a:
            kotlin.text.Regex r7 = new kotlin.text.Regex
            java.lang.String r11 = "(?:term|postid)-(\\d+)"
            r7.<init>(r11)
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r13 = 0
            kotlin.text.MatchResult r7 = kotlin.text.Regex.find$default(r7, r11, r5, r2, r13)
            if (r7 == 0) goto L1ff
            java.util.List r7 = r7.getGroupValues()
            if (r7 == 0) goto L1ff
            r13 = 1
            java.lang.Object r7 = r7.get(r13)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L1ff
            kotlin.ranges.IntRange r11 = new kotlin.ranges.IntRange
            r14 = 4
            r11.<init>(r5, r14)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.List r14 = kotlin.collections.CollectionsKt.toList(r11)
            com.phisher98.OnepaceProvider$loadLinks$2 r5 = new com.phisher98.OnepaceProvider$loadLinks$2
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r3.L$0 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$1 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r3.L$2 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r3.L$3 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$4 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r3.L$5 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r3.L$6 = r11
            r3.Z$0 = r0
            r3.label = r2
            java.lang.Object r2 = com.lagradost.cloudstream3.ParCollectionsKt.amap(r14, r5, r3)
            if (r2 != r1) goto L1f3
            return r1
        L1f3:
            r1 = r10
            r10 = r9
            r9 = r1
            r1 = r6
            r5 = r7
            r11 = r12
            r6 = r4
        L1fa:
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            return r2
        L1ff:
            com.lagradost.cloudstream3.ErrorLoadingException r1 = new com.lagradost.cloudstream3.ErrorLoadingException
            java.lang.String r2 = "no id found"
            r1.<init>(r2)
            throw r1
        L207:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r1
    }

    static /* synthetic */ java.lang.Object search$suspendImpl(com.phisher98.OnepaceProvider r22, java.lang.String r23, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.AnimeSearchResponse>> r24) {
            r0 = r22
            r1 = r24
            boolean r2 = r1 instanceof com.phisher98.OnepaceProvider.C00071
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.OnepaceProvider$search$1 r2 = (com.phisher98.OnepaceProvider.C00071) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.OnepaceProvider$search$1 r2 = new com.phisher98.OnepaceProvider$search$1
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
            com.phisher98.OnepaceProvider r0 = (com.phisher98.OnepaceProvider) r0
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

    private final com.lagradost.cloudstream3.AnimeSearchResponse toSearchResult(org.jsoup.nodes.Element r14) {
            r13 = this;
            java.lang.String r0 = "picture img"
            org.jsoup.nodes.Element r0 = r14.selectFirst(r0)
            r1 = 0
            if (r0 == 0) goto L10
            java.lang.String r2 = "alt"
            java.lang.String r0 = r0.attr(r2)
            goto L11
        L10:
            r0 = r1
        L11:
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            r4 = 0
            if (r3 <= 0) goto L22
            r3 = 1
            goto L23
        L22:
            r3 = 0
        L23:
            r5 = 2
            java.lang.String r6 = "Dub"
            if (r3 == 0) goto L39
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r3 = kotlin.text.StringsKt.contains$default(r3, r7, r4, r5, r1)
            if (r3 == 0) goto L37
            java.lang.String r2 = "https://onepace.me/series/one-pace-english-dub"
            goto L39
        L37:
            java.lang.String r2 = "https://onepace.me/series/one-pace-english-sub"
        L39:
            java.lang.String r3 = "p"
            org.jsoup.nodes.Element r3 = r14.selectFirst(r3)
            if (r3 == 0) goto L47
            java.lang.String r3 = r3.text()
            if (r3 != 0) goto L49
        L47:
            java.lang.String r3 = ""
        L49:
            r8 = r3
            java.lang.String r3 = "img"
            org.jsoup.nodes.Element r3 = r14.selectFirst(r3)
            if (r3 == 0) goto L57
            java.lang.String r3 = r13.getsrcAttribute(r3)
            goto L58
        L57:
            r3 = r1
        L58:
            r7 = 0
            r9 = 0
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r1 = kotlin.text.StringsKt.contains$default(r10, r6, r4, r5, r1)
            if (r1 == 0) goto L68
            r1 = 1
            r4 = 0
            goto L6a
        L68:
            r1 = 0
            r4 = 1
        L6a:
            r7 = r13
            com.lagradost.cloudstream3.MainAPI r7 = (com.lagradost.cloudstream3.MainAPI) r7
            com.lagradost.cloudstream3.utils.AppUtils r5 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            com.phisher98.OnepaceProvider$Media r6 = new com.phisher98.OnepaceProvider$Media
            r6.<init>(r2, r3, r8)
            java.lang.String r9 = r5.toJson(r6)
            com.lagradost.cloudstream3.TvType r10 = com.lagradost.cloudstream3.TvType.Anime
            com.phisher98.OnepaceProvider$$ExternalSyntheticLambda1 r12 = new com.phisher98.OnepaceProvider$$ExternalSyntheticLambda1
            r12.<init>(r3, r1, r4)
            r11 = 0
            com.lagradost.cloudstream3.AnimeSearchResponse r5 = com.lagradost.cloudstream3.MainAPIKt.newAnimeSearchResponse(r7, r8, r9, r10, r11, r12)
            return r5
    }

    static final kotlin.Unit toSearchResult$lambda$0(java.lang.String r7, boolean r8, boolean r9, com.lagradost.cloudstream3.AnimeSearchResponse r10) {
            r10.setPosterUrl(r7)
            r5 = 12
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r8
            r2 = r9
            r0 = r10
            com.lagradost.cloudstream3.MainAPIKt.addDubStatus$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
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
