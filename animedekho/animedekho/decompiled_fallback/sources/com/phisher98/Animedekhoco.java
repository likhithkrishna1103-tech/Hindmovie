package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Animedekhoco;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/Animedekhoco\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,448:1\n2068#2:449\n2069#2:451\n2068#2,2:452\n1#3:450\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/Animedekhoco\n*L\n240#1:449\n240#1:451\n253#1:452,2\n*E\n"})
public final class Animedekhoco extends com.lagradost.cloudstream3.utils.ExtractorApi {

    @org.jetbrains.annotations.NotNull
    private final java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String name;
    private final boolean requiresReferer;

    /* JADX INFO: renamed from: com.phisher98.Animedekhoco$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.Animedekhoco", f = "Extractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {235, 236, 255}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "doc", "url", "referer", "subtitleCallback", "callback", "doc", "text", "links", "$this$forEach$iv", "element$iv", "serverName", "serverUrl"}, nl = {236, 238, 254}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$10;
        java.lang.Object L$11;
        java.lang.Object L$12;
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
        final /* synthetic */ com.phisher98.Animedekhoco this$0;

        AnonymousClass1(com.phisher98.Animedekhoco r1, kotlin.coroutines.Continuation<? super com.phisher98.Animedekhoco.AnonymousClass1> r2) {
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
                com.phisher98.Animedekhoco r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = r1.getUrl(r2, r3, r4, r5, r6)
                return r0
        }
    }

    public Animedekhoco() {
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Animedekhoco"
            r1.name = r0
            java.lang.String r0 = "https://animedekho.co"
            r1.mainUrl = r0
            return
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

    public boolean getRequiresReferer() {
            r1 = this;
            boolean r0 = r1.requiresReferer
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.Nullable java.lang.String r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r33, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r34) {
            r29 = this;
            r2 = r30
            r0 = r34
            boolean r1 = r0 instanceof com.phisher98.Animedekhoco.AnonymousClass1
            if (r1 == 0) goto L1a
            r1 = r0
            com.phisher98.Animedekhoco$getUrl$1 r1 = (com.phisher98.Animedekhoco.AnonymousClass1) r1
            int r3 = r1.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L1a
            int r3 = r1.label
            int r3 = r3 - r4
            r1.label = r3
            r3 = r29
            goto L21
        L1a:
            com.phisher98.Animedekhoco$getUrl$1 r1 = new com.phisher98.Animedekhoco$getUrl$1
            r3 = r29
            r1.<init>(r3, r0)
        L21:
            r15 = r1
            java.lang.Object r1 = r15.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r15.label
            r6 = 1
            java.lang.String r18 = "url="
            r7 = 0
            r8 = 2
            switch(r5) {
                case 0: goto Ld5;
                case 1: goto Lbb;
                case 2: goto L98;
                case 3: goto L3c;
                default: goto L32;
            }
        L32:
            r19 = r1
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3c:
            r5 = 0
            r6 = 0
            java.lang.Object r7 = r15.L$12
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r15.L$11
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r10 = r15.L$10
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r15.L$9
            java.lang.Object r12 = r15.L$8
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r15.L$7
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r15.L$6
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r9 = r15.L$5
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = r15.L$4
            org.jsoup.nodes.Document r0 = (org.jsoup.nodes.Document) r0
            r17 = r0
            java.lang.Object r0 = r15.L$3
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r33 = r0
            java.lang.Object r0 = r15.L$2
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r32 = r0
            java.lang.Object r0 = r15.L$1
            java.lang.String r0 = (java.lang.String) r0
            r31 = r0
            java.lang.Object r0 = r15.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r1)
            r20 = r32
            r2 = r1
            r25 = r8
            r23 = r10
            r16 = r14
            r28 = r15
            r10 = r33
            r1 = r34
            r8 = r2
            r14 = r12
            r15 = r13
            r12 = r31
            r13 = r11
            r11 = r9
            r9 = r7
            r7 = r5
            r5 = r4
            r4 = r0
            r0 = 0
            goto L314
        L98:
            java.lang.Object r0 = r15.L$4
            org.jsoup.nodes.Document r0 = (org.jsoup.nodes.Document) r0
            java.lang.Object r5 = r15.L$3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r9 = r15.L$2
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r15.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r15.L$0
            r2 = r11
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r21 = r0
            r19 = r1
            r3 = r2
            r0 = r4
            r2 = r19
            r1 = 0
            goto L1b9
        Lbb:
            java.lang.Object r0 = r15.L$3
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Object r5 = r15.L$2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r9 = r15.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r15.L$0
            r2 = r10
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            r19 = r3
            r1 = r0
            r0 = r4
            goto L136
        Ld5:
            kotlin.ResultKt.throwOnFailure(r1)
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5 = r18
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r9 = 0
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r5, r7, r8, r9)
            if (r0 == 0) goto L146
            r0 = r1
            com.lagradost.nicehttp.Requests r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r15.L$0 = r2
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r31)
            r15.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r32)
            r15.L$2 = r5
            r5 = r33
            r15.L$3 = r5
            r15.label = r6
            r3 = 0
            r10 = r4
            r4 = 0
            r5 = 0
            r11 = 1
            r6 = 0
            r12 = 0
            r7 = 0
            r13 = 2
            r8 = 0
            r16 = r9
            r9 = 0
            r14 = r10
            r17 = 1
            r10 = 0
            r19 = 0
            r12 = 0
            r20 = 2
            r13 = 0
            r21 = r14
            r14 = 0
            r22 = r16
            r16 = 4094(0xffe, float:5.737E-42)
            r23 = 1
            r17 = 0
            r19 = r0
            r0 = r21
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17)
            if (r1 != r0) goto L12d
            return r0
        L12d:
            r2 = r30
            r9 = r31
            r5 = r32
            r3 = r1
            r1 = r33
        L136:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            org.jsoup.nodes.Document r3 = r3.getDocument()
            r20 = r2
            r2 = r1
            r1 = r9
            r9 = r3
            r3 = r20
            r20 = r5
            goto L152
        L146:
            r19 = r1
            r0 = r4
            r3 = r30
            r1 = r31
            r20 = r32
            r2 = r33
            r9 = 0
        L152:
            r4 = r9
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = r18
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r6, r7, r8, r9)
            if (r5 != 0) goto L1c6
            com.lagradost.nicehttp.Requests r5 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r15.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r15.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
            r15.L$2 = r6
            r15.L$3 = r2
            r15.L$4 = r4
            r15.label = r8
            r9 = r4
            r4 = 0
            r6 = r2
            r2 = r5
            r5 = 0
            r10 = r6
            r6 = 0
            r12 = 0
            r7 = 0
            r26 = 2
            r8 = 0
            r11 = r9
            r9 = 0
            r13 = r10
            r10 = 0
            r14 = r11
            r25 = 0
            r11 = 0
            r16 = r13
            r13 = 0
            r17 = r14
            r14 = 0
            r18 = r16
            r16 = r15
            r15 = 0
            r21 = r17
            r17 = 4094(0xffe, float:5.737E-42)
            r23 = r18
            r18 = 0
            r30 = r1
            r1 = 0
            java.lang.Object r2 = com.lagradost.nicehttp.Requests.get$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)
            r15 = r16
            if (r2 != r0) goto L1b3
            return r0
        L1b3:
            r10 = r30
            r9 = r20
            r5 = r23
        L1b9:
            com.lagradost.nicehttp.NiceResponse r2 = (com.lagradost.nicehttp.NiceResponse) r2
            java.lang.String r2 = r2.getText()
            r20 = r9
            r9 = r2
            r2 = r5
            r4 = r21
            goto L1d0
        L1c6:
            r30 = r1
            r23 = r2
            r21 = r4
            r1 = 0
            r10 = r30
            r9 = 0
        L1d0:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            if (r4 == 0) goto L22f
            java.lang.String r6 = "select#serverSelector option"
            org.jsoup.select.Elements r6 = r4.select(r6)
            if (r6 == 0) goto L22f
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 0
            java.util.Iterator r8 = r6.iterator()
        L1e8:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L22c
            java.lang.Object r11 = r8.next()
            r12 = r11
            org.jsoup.nodes.Element r12 = (org.jsoup.nodes.Element) r12
            r13 = 0
            java.lang.String r14 = "value"
            java.lang.String r14 = r12.attr(r14)
            java.lang.String r16 = r12.text()
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r17 = kotlin.text.StringsKt.isBlank(r16)
            if (r17 == 0) goto L20d
            r16 = 0
            java.lang.String r16 = "Unknown"
        L20d:
            r1 = r16
            java.lang.String r1 = (java.lang.String) r1
            r16 = r14
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = kotlin.text.StringsKt.isBlank(r16)
            if (r16 != 0) goto L225
            r21 = r0
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r14)
            r5.add(r0)
            goto L227
        L225:
            r21 = r0
        L227:
            r0 = r21
            r1 = 0
            goto L1e8
        L22c:
            r21 = r0
            goto L231
        L22f:
            r21 = r0
        L231:
            if (r9 == 0) goto L268
            r0 = r9
            r1 = 0
            kotlin.text.Regex r6 = new kotlin.text.Regex
            java.lang.String r7 = "file\\s*:\\s*\"([^\"]+)\""
            r6.<init>(r7)
            r7 = r0
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8 = 0
            r12 = 0
            r13 = 2
            kotlin.text.MatchResult r7 = kotlin.text.Regex.find$default(r6, r7, r12, r13, r8)
            if (r7 == 0) goto L265
            java.util.List r7 = r7.getGroupValues()
            if (r7 == 0) goto L265
            r11 = 1
            java.lang.Object r7 = r7.get(r11)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L265
            r8 = 0
            java.lang.String r11 = "Player File"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r7)
            boolean r7 = r5.add(r11)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
        L265:
        L268:
            r0 = r5
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r6 = r0.iterator()
            r13 = r0
            r7 = r2
            r14 = r5
            r12 = r6
            r5 = r21
            r2 = r29
            r0 = r34
            r6 = r1
            r1 = r19
        L27d:
            boolean r8 = r12.hasNext()
            if (r8 == 0) goto L32a
            java.lang.Object r11 = r12.next()
            r8 = r11
            kotlin.Pair r8 = (kotlin.Pair) r8
            r16 = 0
            java.lang.Object r17 = r8.component1()
            r23 = r17
            java.lang.String r23 = (java.lang.String) r23
            java.lang.Object r8 = r8.component2()
            r25 = r8
            java.lang.String r25 = (java.lang.String) r25
            com.lagradost.cloudstream3.utils.ExtractorLinkType r26 = com.lagradost.cloudstream3.utils.ExtractorApiKt.getINFER_TYPE()
            com.phisher98.Animedekhoco$getUrl$4$1 r8 = new com.phisher98.Animedekhoco$getUrl$4$1
            r30 = r0
            r0 = 0
            r8.<init>(r2, r0)
            r27 = r8
            kotlin.jvm.functions.Function2 r27 = (kotlin.jvm.functions.Function2) r27
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r15.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r15.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
            r15.L$2 = r8
            r15.L$3 = r7
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r15.L$4 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r15.L$5 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r15.L$6 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r15.L$7 = r8
            r15.L$8 = r12
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r15.L$9 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)
            r15.L$10 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r15.L$11 = r8
            r15.L$12 = r7
            r8 = 3
            r15.label = r8
            r24 = r23
            r28 = r15
            java.lang.Object r8 = com.lagradost.cloudstream3.utils.ExtractorApiKt.newExtractorLink(r23, r24, r25, r26, r27, r28)
            if (r8 != r5) goto L301
            return r5
        L301:
            r17 = r4
            r15 = r13
            r4 = r3
            r13 = r11
            r3 = r2
            r11 = r9
            r2 = r1
            r9 = r7
            r1 = r30
            r7 = r6
            r6 = r16
            r16 = r14
            r14 = r12
            r12 = r10
            r10 = r9
        L314:
            r9.invoke(r8)
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            r6 = r7
            r7 = r10
            r9 = r11
            r10 = r12
            r12 = r14
            r13 = r15
            r14 = r16
            r4 = r17
            r15 = r28
            goto L27d
        L32a:
            r30 = r0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
    }
}
