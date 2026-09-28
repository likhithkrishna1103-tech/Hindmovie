package com.phisher98;

/* JADX INFO: compiled from: HindiSubAnime.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u001dH\u0096@¢\u0006\u0002\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/phisher98/HindiSubAnime;", "Lcom/phisher98/AnimeDekhoProvider;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nHindiSubAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HindiSubAnime.kt\ncom/phisher98/HindiSubAnime\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,46:1\n63#2:47\n64#2,15:49\n1#3:48\n50#4:64\n43#4:65\n*S KotlinDebug\n*F\n+ 1 HindiSubAnime.kt\ncom/phisher98/HindiSubAnime\n*L\n33#1:47\n33#1:49,15\n33#1:48\n33#1:64\n33#1:65\n*E\n"})
public final class HindiSubAnime extends com.phisher98.AnimeDekhoProvider {
    private final boolean hasMainPage;

    @org.jetbrains.annotations.NotNull
    private java.lang.String lang;

    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.lagradost.cloudstream3.MainPageData> mainPage;

    @org.jetbrains.annotations.NotNull
    private java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private java.lang.String name;

    /* JADX INFO: renamed from: com.phisher98.HindiSubAnime$loadLinks$1, reason: invalid class name */
    /* JADX INFO: compiled from: HindiSubAnime.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.HindiSubAnime", f = "HindiSubAnime.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {34, 37}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "media", "isCasting", "data", "subtitleCallback", "callback", "media", "body", "term", "isCasting"}, nl = {35, 44}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.HindiSubAnime this$0;

        AnonymousClass1(com.phisher98.HindiSubAnime r1, kotlin.coroutines.Continuation<? super com.phisher98.HindiSubAnime.AnonymousClass1> r2) {
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
                com.phisher98.HindiSubAnime r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = r1.loadLinks(r2, r3, r4, r5, r6)
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.HindiSubAnime$loadLinks$2, reason: invalid class name */
    /* JADX INFO: compiled from: HindiSubAnime.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.HindiSubAnime$loadLinks$2", f = "HindiSubAnime.kt", i = {0, 1, 1}, l = {38, 42}, m = "invokeSuspend", n = {"i", "link", "i"}, nl = {39, 43}, s = {"I$0", "L$0", "I$0"}, v = 2)
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<java.lang.Integer, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> $callback;
        final /* synthetic */ com.phisher98.AnimeDekhoProvider.Media $media;
        final /* synthetic */ kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> $subtitleCallback;
        final /* synthetic */ java.lang.String $term;
        /* synthetic */ int I$0;
        java.lang.Object L$0;
        int label;
        final /* synthetic */ com.phisher98.HindiSubAnime this$0;

        AnonymousClass2(com.phisher98.HindiSubAnime r2, java.lang.String r3, com.phisher98.AnimeDekhoProvider.Media r4, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super com.phisher98.HindiSubAnime.AnonymousClass2> r7) {
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
                com.phisher98.HindiSubAnime$loadLinks$2 r0 = new com.phisher98.HindiSubAnime$loadLinks$2
                com.phisher98.HindiSubAnime r1 = r7.this$0
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

        public final java.lang.Object invoke(int r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
                kotlin.coroutines.Continuation r0 = r2.create(r0, r4)
                com.phisher98.HindiSubAnime$loadLinks$2 r0 = (com.phisher98.HindiSubAnime.AnonymousClass2) r0
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
                goto Lbd
            L1e:
                kotlin.ResultKt.throwOnFailure(r21)
                r3 = r21
                goto L85
            L24:
                kotlin.ResultKt.throwOnFailure(r21)
                com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
                com.phisher98.HindiSubAnime r4 = r0.this$0
                java.lang.String r4 = r4.getMainUrl()
                java.lang.String r5 = r0.$term
                com.phisher98.AnimeDekhoProvider$Media r6 = r0.$media
                java.lang.Integer r6 = r6.getMediaType()
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
                if (r3 == 0) goto Lc0
            L94:
                java.lang.String r4 = "src"
                java.lang.String r3 = r3.attr(r4)
                if (r3 == 0) goto Lc0
                com.lagradost.api.Log r4 = com.lagradost.api.Log.INSTANCE
                java.lang.String r5 = "Phisher"
                r4.d(r5, r3)
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
                if (r4 != r2) goto Lbc
                return r2
            Lbc:
                r2 = r3
            Lbd:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
                return r3
            Lc0:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
                return r2
        }
    }

    public HindiSubAnime() {
            r4 = this;
            r4.<init>()
            java.lang.String r0 = "https://hindisubanime.co"
            r4.mainUrl = r0
            java.lang.String r0 = "HindiSubAnime"
            r4.name = r0
            r0 = 1
            r4.hasMainPage = r0
            java.lang.String r1 = "hi"
            r4.lang = r1
            r1 = 4
            kotlin.Pair[] r1 = new kotlin.Pair[r1]
            java.lang.String r2 = "/category/shounen/"
            java.lang.String r3 = "Shounen"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "/category/action/"
            java.lang.String r3 = "Action"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            r1[r0] = r2
            java.lang.String r0 = "/category/fantasy/"
            java.lang.String r2 = "Fantasy"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)
            r2 = 2
            r1[r2] = r0
            java.lang.String r0 = "/serie/"
            java.lang.String r2 = "Series"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)
            r2 = 3
            r1[r2] = r0
            java.util.List r0 = com.lagradost.cloudstream3.MainAPIKt.mainPageOf(r1)
            r4.mainPage = r0
            return
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public boolean getHasMainPage() {
            r1 = this;
            boolean r0 = r1.hasMainPage
            return r0
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @org.jetbrains.annotations.NotNull
    public java.lang.String getLang() {
            r1 = this;
            java.lang.String r0 = r1.lang
            return r0
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.lagradost.cloudstream3.MainPageData> getMainPage() {
            r1 = this;
            java.util.List<com.lagradost.cloudstream3.MainPageData> r0 = r1.mainPage
            return r0
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @org.jetbrains.annotations.NotNull
    public java.lang.String getMainUrl() {
            r1 = this;
            java.lang.String r0 = r1.mainUrl
            return r0
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
            r1 = this;
            java.lang.String r0 = r1.name
            return r0
    }

    @Override // com.phisher98.AnimeDekhoProvider
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r26, boolean r27, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r29, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r30) {
            r25 = this;
            r1 = r30
            boolean r0 = r1 instanceof com.phisher98.HindiSubAnime.AnonymousClass1
            if (r0 == 0) goto L18
            r0 = r1
            com.phisher98.HindiSubAnime$loadLinks$1 r0 = (com.phisher98.HindiSubAnime.AnonymousClass1) r0
            int r2 = r0.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r2 = r0.label
            int r2 = r2 - r3
            r0.label = r2
            r3 = r25
            goto L1f
        L18:
            com.phisher98.HindiSubAnime$loadLinks$1 r0 = new com.phisher98.HindiSubAnime$loadLinks$1
            r3 = r25
            r0.<init>(r3, r1)
        L1f:
            r2 = r0
            java.lang.Object r4 = r2.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r2.label
            r6 = 2
            r7 = 1
            r8 = 0
            switch(r0) {
                case 0: goto L7b;
                case 1: goto L5a;
                case 2: goto L36;
                default: goto L2e;
            }
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            boolean r0 = r2.Z$0
            java.lang.Object r5 = r2.L$5
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.L$4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r8 = r2.L$3
            com.phisher98.AnimeDekhoProvider$Media r8 = (com.phisher98.AnimeDekhoProvider.Media) r8
            java.lang.Object r9 = r2.L$2
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r2.L$1
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r2.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r4)
            r22 = r4
            r7 = r9
            r15 = 1
            r9 = r2
            goto L1f7
        L5a:
            boolean r0 = r2.Z$0
            java.lang.Object r9 = r2.L$3
            com.phisher98.AnimeDekhoProvider$Media r9 = (com.phisher98.AnimeDekhoProvider.Media) r9
            java.lang.Object r10 = r2.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r2.L$1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r2.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r4)
            r1 = r9
            r9 = r2
            r2 = r5
            r5 = r1
            r22 = r4
            r3 = r8
            r7 = r10
            r6 = r11
            r1 = 2
            goto L16e
        L7b:
            kotlin.ResultKt.throwOnFailure(r4)
            com.lagradost.cloudstream3.utils.AppUtils r9 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r10 = r26
            r11 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L9b
            r0 = r9
            r12 = 0
            java.lang.Class<com.phisher98.AnimeDekhoProvider$Media> r13 = com.phisher98.AnimeDekhoProvider.Media.class
            kotlin.reflect.KType r13 = kotlin.jvm.internal.Reflection.typeOf(r13)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r14 = "kotlinx.serialization.serializer.simple"
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r14)     // Catch: java.lang.Throwable -> L9b
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.SerializersKt.serializer(r13)     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> L9b
            goto La6
        L9b:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        La6:
            java.lang.Throwable r12 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r12 != 0) goto Lad
        Lac:
            goto Ld3
        Lad:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Lc7
            r0 = 0
            kotlinx.serialization.json.Json r13 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> Lc7
            kotlinx.serialization.modules.SerializersModule r13 = r13.getSerializersModule()     // Catch: java.lang.Throwable -> Lc7
            java.lang.Class<com.phisher98.AnimeDekhoProvider$Media> r14 = com.phisher98.AnimeDekhoProvider.Media.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)     // Catch: java.lang.Throwable -> Lc7
            kotlinx.serialization.KSerializer r13 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r13, r14, r8, r6, r8)     // Catch: java.lang.Throwable -> Lc7
            java.lang.Object r0 = kotlin.Result.constructor-impl(r13)     // Catch: java.lang.Throwable -> Lc7
            goto Lac
        Lc7:
            r0 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
            goto Lac
        Ld3:
            boolean r12 = kotlin.Result.isFailure-impl(r0)
            if (r12 == 0) goto Lda
            r0 = r8
        Lda:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
            r12 = r0
            if (r12 == 0) goto Lf5
        Le0:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> Lec kotlinx.serialization.SerializationException -> Lee
            r13 = r12
            kotlinx.serialization.DeserializationStrategy r13 = (kotlinx.serialization.DeserializationStrategy) r13     // Catch: java.lang.Throwable -> Lec kotlinx.serialization.SerializationException -> Lee
            java.lang.Object r0 = r0.decodeFromString(r13, r10)     // Catch: java.lang.Throwable -> Lec kotlinx.serialization.SerializationException -> Lee
            goto L10c
        Lec:
            r0 = move-exception
            goto Lf5
        Lee:
            r0 = move-exception
            r13 = r0
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r13)
        Lf5:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0
            r13 = r10
            r14 = 0
            r15 = 0
            com.phisher98.HindiSubAnime$loadLinks$$inlined$parseJson$1 r16 = new com.phisher98.HindiSubAnime$loadLinks$$inlined$parseJson$1
            r16.<init>()
            r15 = r16
            com.fasterxml.jackson.core.type.TypeReference r15 = (com.fasterxml.jackson.core.type.TypeReference) r15
            java.lang.Object r0 = r0.readValue(r13, r15)
        L10c:
            com.phisher98.AnimeDekhoProvider$Media r0 = (com.phisher98.AnimeDekhoProvider.Media) r0
            r9 = r4
            com.lagradost.nicehttp.Requests r4 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r10 = r5
            java.lang.String r5 = r0.getUrl()
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)
            r2.L$0 = r11
            r11 = r28
            r2.L$1 = r11
            r12 = r29
            r2.L$2 = r12
            r2.L$3 = r0
            r13 = r27
            r2.Z$0 = r13
            r2.label = r7
            r14 = 2
            r6 = 0
            r15 = 1
            r7 = 0
            r16 = r8
            r8 = 0
            r17 = r9
            r9 = 0
            r18 = r10
            r10 = 0
            r11 = 0
            r12 = 0
            r19 = 2
            r13 = 0
            r20 = 1
            r15 = 0
            r21 = r16
            r16 = 0
            r22 = r17
            r17 = 0
            r23 = 2
            r19 = 4094(0xffe, float:5.737E-42)
            r24 = 1
            r20 = 0
            r1 = r18
            r18 = r2
            r2 = r1
            r3 = r21
            r1 = 2
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20)
            r9 = r18
            if (r4 != r2) goto L165
            return r2
        L165:
            r12 = r26
            r6 = r28
            r7 = r29
            r5 = r0
            r0 = r27
        L16e:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4
            org.jsoup.nodes.Document r4 = r4.getDocument()
            java.lang.String r8 = "body"
            org.jsoup.nodes.Element r4 = r4.selectFirst(r8)
            r8 = 0
            if (r4 == 0) goto L204
            java.lang.String r10 = "class"
            java.lang.String r4 = r4.attr(r10)
            if (r4 != 0) goto L187
            goto L204
        L187:
            r10 = r4
            kotlin.text.Regex r4 = new kotlin.text.Regex
            java.lang.String r11 = "(?:term|postid)-(\\d+)"
            r4.<init>(r11)
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            kotlin.text.MatchResult r3 = kotlin.text.Regex.find$default(r4, r11, r8, r1, r3)
            if (r3 == 0) goto L1fc
            java.util.List r3 = r3.getGroupValues()
            if (r3 == 0) goto L1fc
            r15 = 1
            java.lang.Object r3 = r3.get(r15)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L1fc
            kotlin.ranges.IntRange r3 = new kotlin.ranges.IntRange
            r11 = 4
            r3.<init>(r8, r11)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r11 = kotlin.collections.CollectionsKt.toList(r3)
            r18 = r2
            com.phisher98.HindiSubAnime$loadLinks$2 r2 = new com.phisher98.HindiSubAnime$loadLinks$2
            r8 = 0
            r3 = r25
            r13 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r9.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r9.L$1 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r9.L$2 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r9.L$3 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$4 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r9.L$5 = r3
            r9.Z$0 = r0
            r9.label = r1
            java.lang.Object r1 = com.lagradost.cloudstream3.ParCollectionsKt.amap(r11, r2, r9)
            if (r1 != r13) goto L1f1
            return r13
        L1f1:
            r8 = r10
            r10 = r6
            r6 = r8
            r8 = r5
            r11 = r12
            r5 = r4
        L1f7:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r1
        L1fc:
            com.lagradost.cloudstream3.ErrorLoadingException r1 = new com.lagradost.cloudstream3.ErrorLoadingException
            java.lang.String r2 = "no id found"
            r1.<init>(r2)
            throw r1
        L204:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r1
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public void setLang(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            r0.lang = r1
            return
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public void setMainUrl(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            r0.mainUrl = r1
            return
    }

    @Override // com.phisher98.AnimeDekhoProvider
    public void setName(@org.jetbrains.annotations.NotNull java.lang.String r1) {
            r0 = this;
            r0.name = r1
            return
    }
}
