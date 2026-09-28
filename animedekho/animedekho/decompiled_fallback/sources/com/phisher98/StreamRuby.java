package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StreamRuby;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class StreamRuby extends com.lagradost.cloudstream3.utils.ExtractorApi {

    @org.jetbrains.annotations.NotNull
    private final java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String name;
    private final boolean requiresReferer;

    /* JADX INFO: renamed from: com.phisher98.StreamRuby$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.StreamRuby", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {281, 300}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "cleanedUrl", "url", "referer", "subtitleCallback", "callback", "cleanedUrl", "response", "scriptData", "headers", "link"}, nl = {285, 299}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
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
        final /* synthetic */ com.phisher98.StreamRuby this$0;

        AnonymousClass1(com.phisher98.StreamRuby r1, kotlin.coroutines.Continuation<? super com.phisher98.StreamRuby.AnonymousClass1> r2) {
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
                com.phisher98.StreamRuby r1 = r7.this$0
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

    public StreamRuby() {
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "StreamRuby"
            r1.name = r0
            java.lang.String r0 = "https://rubystm.com"
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
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
            r22 = this;
            r0 = r22
            r1 = r27
            boolean r2 = r1 instanceof com.phisher98.StreamRuby.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.StreamRuby$getUrl$1 r2 = (com.phisher98.StreamRuby.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.StreamRuby$getUrl$1 r2 = new com.phisher98.StreamRuby$getUrl$1
            r2.<init>(r0, r1)
        L1d:
            r8 = r2
            java.lang.Object r2 = r8.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r8.label
            r5 = 1
            switch(r4) {
                case 0: goto L8c;
                case 1: goto L6a;
                case 2: goto L34;
                default: goto L2a;
            }
        L2a:
            r20 = r2
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L34:
            r3 = 0
            java.lang.Object r4 = r8.L$9
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r8.L$8
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r8.L$7
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r8.L$6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r9 = r8.L$5
            org.jsoup.nodes.Document r9 = (org.jsoup.nodes.Document) r9
            java.lang.Object r10 = r8.L$4
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r8.L$3
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r8.L$2
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.lang.Object r13 = r8.L$1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r8.L$0
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r20 = r2
            r16 = r3
            r17 = r8
            r3 = r20
            goto L1f5
        L6a:
            java.lang.Object r4 = r8.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r8.L$3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r8.L$2
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r9 = r8.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r20 = r2
            r1 = r3
            r12 = r6
            r11 = r7
            r3 = r20
            r2 = 1
            r13 = r4
            goto L105
        L8c:
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = 4
            r16 = 0
            java.lang.String r12 = "/e"
            java.lang.String r13 = ""
            r14 = 0
            r11 = r23
            java.lang.String r4 = kotlin.text.StringsKt.replace$default(r11, r12, r13, r14, r15, r16)
            r6 = r3
            com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            java.lang.String r7 = "X-Requested-With"
            java.lang.String r9 = "XMLHttpRequest"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r9)
            java.util.Map r7 = kotlin.collections.MapsKt.mapOf(r7)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)
            r8.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r8.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r8.L$2 = r9
            r9 = r26
            r8.L$3 = r9
            r8.L$4 = r4
            r8.label = r5
            r5 = r7
            r10 = 1
            r7 = 0
            r17 = r8
            r8 = 0
            r9 = 0
            r11 = 1
            r10 = 0
            r12 = 1
            r11 = 0
            r14 = 1
            r12 = 0
            r15 = 1
            r14 = 0
            r16 = 1
            r15 = 0
            r18 = 1
            r16 = 0
            r19 = 1
            r18 = 4088(0xff8, float:5.729E-42)
            r20 = 1
            r19 = 0
            r21 = r6
            r6 = r4
            r20 = r2
            r1 = r21
            r2 = 1
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r8 = r17
            if (r3 != r1) goto Lfc
            return r1
        Lfc:
            r10 = r23
            r9 = r24
            r11 = r25
            r12 = r26
            r13 = r4
        L105:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            org.jsoup.nodes.Document r3 = r3.getDocument()
            r14 = r3
            java.lang.String r3 = "script:containsData(vplayer)"
            org.jsoup.nodes.Element r3 = r14.selectFirst(r3)
            r4 = 0
            if (r3 == 0) goto L11a
            java.lang.String r3 = r3.data()
            goto L11b
        L11a:
            r3 = r4
        L11b:
            if (r3 != 0) goto L11f
            java.lang.String r3 = ""
        L11f:
            r15 = r3
            r3 = 6
            kotlin.Pair[] r3 = new kotlin.Pair[r3]
            java.lang.String r5 = "Accept"
            java.lang.String r6 = "*/*"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r6)
            r6 = 0
            r3[r6] = r5
            java.lang.String r5 = "Connection"
            java.lang.String r7 = "keep-alive"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)
            r3[r2] = r5
            java.lang.String r5 = "Sec-Fetch-Dest"
            java.lang.String r7 = "empty"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)
            r7 = 2
            r3[r7] = r5
            java.lang.String r5 = "Sec-Fetch-Mode"
            java.lang.String r2 = "cors"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r5, r2)
            r5 = 3
            r3[r5] = r2
            java.lang.String r2 = "Sec-Fetch-Site"
            java.lang.String r5 = "cross-site"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r5 = 4
            r3[r5] = r2
            java.lang.String r2 = "Origin"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r13)
            r5 = 5
            r3[r5] = r2
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r3)
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r5 = "file:\"(.*)\""
            r3.<init>(r5)
            r5 = r15
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            kotlin.text.MatchResult r3 = kotlin.text.Regex.find$default(r3, r5, r6, r7, r4)
            if (r3 == 0) goto L204
            java.util.List r3 = r3.getGroupValues()
            if (r3 == 0) goto L204
            r5 = 1
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r3, r5)
            r5 = r3
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L204
            r16 = 0
            java.lang.String r3 = r0.getName()
            java.lang.String r6 = r0.getName()
            r17 = r6
            com.lagradost.cloudstream3.utils.ExtractorLinkType r6 = com.lagradost.cloudstream3.utils.ExtractorApiKt.getINFER_TYPE()
            com.phisher98.StreamRuby$getUrl$2$1 r7 = new com.phisher98.StreamRuby$getUrl$2$1
            r7.<init>(r0, r2, r4)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r8.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r8.L$2 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r8.L$3 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r8.L$4 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r8.L$5 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r8.L$6 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r8.L$7 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r8.L$8 = r4
            r8.L$9 = r12
            r4 = 2
            r8.label = r4
            r4 = r17
            java.lang.Object r3 = com.lagradost.cloudstream3.utils.ExtractorApiKt.newExtractorLink(r3, r4, r5, r6, r7, r8)
            r17 = r8
            if (r3 != r1) goto L1eb
            return r1
        L1eb:
            r4 = r13
            r13 = r9
            r9 = r14
            r14 = r10
            r10 = r4
            r6 = r2
            r4 = r12
            r7 = r15
            r12 = r11
            r11 = r4
        L1f5:
            r4.invoke(r3)
            r2 = r14
            r14 = r9
            r9 = r13
            r13 = r10
            r10 = r2
            r2 = r12
            r12 = r11
            r11 = r2
            r2 = r6
            r15 = r7
            goto L206
        L204:
            r17 = r8
        L206:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
    }
}
