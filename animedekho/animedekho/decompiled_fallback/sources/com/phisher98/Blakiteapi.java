package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/Blakiteapi;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityFromString", "", "q", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Blakiteapi extends com.lagradost.cloudstream3.utils.ExtractorApi {

    @org.jetbrains.annotations.NotNull
    private final java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String name;
    private final boolean requiresReferer;

    /* JADX INFO: renamed from: com.phisher98.Blakiteapi$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.Blakiteapi", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {329, 342}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "apiurl", "url", "referer", "subtitleCallback", "callback", "apiurl", "responseText", "json", "data", "quality", "format", "dataId", "streamUrl", "success"}, nl = {331, 341}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0"}, v = 2)
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
        boolean Z$0;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.Blakiteapi this$0;

        AnonymousClass1(com.phisher98.Blakiteapi r1, kotlin.coroutines.Continuation<? super com.phisher98.Blakiteapi.AnonymousClass1> r2) {
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
                com.phisher98.Blakiteapi r1 = r7.this$0
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

    /* JADX INFO: renamed from: com.phisher98.Blakiteapi$getUrl$2, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.Blakiteapi$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ java.lang.String $quality;
        private /* synthetic */ java.lang.Object L$0;
        int label;
        final /* synthetic */ com.phisher98.Blakiteapi this$0;

        AnonymousClass2(com.phisher98.Blakiteapi r2, java.lang.String r3, kotlin.coroutines.Continuation<? super com.phisher98.Blakiteapi.AnonymousClass2> r4) {
                r1 = this;
                r1.this$0 = r2
                r1.$quality = r3
                r0 = 2
                r1.<init>(r0, r4)
                return
        }

        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object r4, kotlin.coroutines.Continuation<?> r5) {
                r3 = this;
                com.phisher98.Blakiteapi$getUrl$2 r0 = new com.phisher98.Blakiteapi$getUrl$2
                com.phisher98.Blakiteapi r1 = r3.this$0
                java.lang.String r2 = r3.$quality
                r0.<init>(r1, r2, r5)
                r0.L$0 = r4
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                return r0
        }

        public final java.lang.Object invoke(com.lagradost.cloudstream3.utils.ExtractorLink r3, kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
                r2 = this;
                kotlin.coroutines.Continuation r0 = r2.create(r3, r4)
                com.phisher98.Blakiteapi$getUrl$2 r0 = (com.phisher98.Blakiteapi.AnonymousClass2) r0
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                java.lang.Object r0 = r0.invokeSuspend(r1)
                return r0
        }

        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r2, java.lang.Object r3) {
                r1 = this;
                com.lagradost.cloudstream3.utils.ExtractorLink r2 = (com.lagradost.cloudstream3.utils.ExtractorLink) r2
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r0 = r1.invoke(r2, r3)
                return r0
        }

        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                r3 = this;
                java.lang.Object r0 = r3.L$0
                com.lagradost.cloudstream3.utils.ExtractorLink r0 = (com.lagradost.cloudstream3.utils.ExtractorLink) r0
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
                com.phisher98.Blakiteapi r1 = r3.this$0
                java.lang.String r2 = r3.$quality
                int r1 = com.phisher98.Blakiteapi.access$getQualityFromString(r1, r2)
                r0.setQuality(r1)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
        }
    }

    public Blakiteapi() {
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Blakiteapi"
            r1.name = r0
            java.lang.String r0 = "https://blakiteapi.xyz"
            r1.mainUrl = r0
            return
    }

    public static final /* synthetic */ int access$getQualityFromString(com.phisher98.Blakiteapi r1, java.lang.String r2) {
            int r0 = r1.getQualityFromString(r2)
            return r0
    }

    private final int getQualityFromString(java.lang.String r4) {
            r3 = this;
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "1080"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.contains(r0, r1, r2)
            if (r0 == 0) goto L16
            com.lagradost.cloudstream3.utils.Qualities r0 = com.lagradost.cloudstream3.utils.Qualities.P1080
            int r0 = r0.getValue()
            goto L58
        L16:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "720"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r0 = kotlin.text.StringsKt.contains(r0, r1, r2)
            if (r0 == 0) goto L2a
            com.lagradost.cloudstream3.utils.Qualities r0 = com.lagradost.cloudstream3.utils.Qualities.P720
            int r0 = r0.getValue()
            goto L58
        L2a:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "480"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r0 = kotlin.text.StringsKt.contains(r0, r1, r2)
            if (r0 == 0) goto L3e
            com.lagradost.cloudstream3.utils.Qualities r0 = com.lagradost.cloudstream3.utils.Qualities.P480
            int r0 = r0.getValue()
            goto L58
        L3e:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "360"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r0 = kotlin.text.StringsKt.contains(r0, r1, r2)
            if (r0 == 0) goto L52
            com.lagradost.cloudstream3.utils.Qualities r0 = com.lagradost.cloudstream3.utils.Qualities.P360
            int r0 = r0.getValue()
            goto L58
        L52:
            com.lagradost.cloudstream3.utils.Qualities r0 = com.lagradost.cloudstream3.utils.Qualities.Unknown
            int r0 = r0.getValue()
        L58:
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

    public boolean getRequiresReferer() {
            r1 = this;
            boolean r0 = r1.requiresReferer
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r24, @org.jetbrains.annotations.Nullable java.lang.String r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r28
            boolean r3 = r2 instanceof com.phisher98.Blakiteapi.AnonymousClass1
            if (r3 == 0) goto L1a
            r3 = r2
            com.phisher98.Blakiteapi$getUrl$1 r3 = (com.phisher98.Blakiteapi.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L1a
            int r4 = r3.label
            int r4 = r4 - r5
            r3.label = r4
            goto L1f
        L1a:
            com.phisher98.Blakiteapi$getUrl$1 r3 = new com.phisher98.Blakiteapi$getUrl$1
            r3.<init>(r0, r2)
        L1f:
            r9 = r3
            java.lang.Object r3 = r9.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r9.label
            r6 = 2
            r7 = 0
            switch(r5) {
                case 0: goto La4;
                case 1: goto L82;
                case 2: goto L35;
                default: goto L2d;
            }
        L2d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L35:
            boolean r4 = r9.Z$0
            java.lang.Object r5 = r9.L$12
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r6 = r9.L$11
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r9.L$10
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r9.L$9
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r10 = r9.L$8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r9.L$7
            org.json.JSONObject r11 = (org.json.JSONObject) r11
            java.lang.Object r12 = r9.L$6
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            java.lang.Object r13 = r9.L$5
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r9.L$4
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r9.L$3
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            java.lang.Object r2 = r9.L$2
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r26 = r2
            java.lang.Object r2 = r9.L$1
            java.lang.String r2 = (java.lang.String) r2
            r25 = r2
            java.lang.Object r2 = r9.L$0
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r3)
            r2 = r25
            r17 = r3
            r16 = r15
            r3 = r4
            r15 = r13
            r4 = r17
            r13 = r12
            r12 = r26
            goto L222
        L82:
            java.lang.Object r2 = r9.L$4
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r9.L$3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r8 = r9.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r10 = r9.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r9.L$0
            r1 = r11
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r2
            r2 = r4
            r13 = r5
            r12 = r8
            r11 = r10
            r10 = r1
            r4 = r3
            r1 = r7
            goto L13a
        La4:
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.String r2 = r0.getMainUrl()
            java.lang.String r5 = "/"
            java.lang.String r8 = kotlin.text.StringsKt.substringAfterLast$default(r1, r5, r7, r6, r7)
            java.lang.String r10 = "embed/"
            java.lang.String r10 = kotlin.text.StringsKt.substringAfter$default(r1, r10, r7, r6, r7)
            java.lang.String r5 = kotlin.text.StringsKt.substringBefore$default(r10, r5, r7, r6, r7)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r2 = r10.append(r2)
            java.lang.String r10 = "/api/get.php?id="
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r8 = "&tmdbId="
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = r2.toString()
            r2 = r4
            com.lagradost.nicehttp.Requests r4 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r9.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r9.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)
            r9.L$2 = r8
            r8 = r27
            r9.L$3 = r8
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r9.L$4 = r10
            r10 = 1
            r9.label = r10
            r10 = 2
            r6 = 0
            r11 = r7
            r7 = 0
            r8 = 0
            r18 = r9
            r9 = 0
            r12 = 2
            r10 = 0
            r13 = r11
            r11 = 0
            r14 = 2
            r12 = 0
            r16 = r13
            r15 = 2
            r13 = 0
            r17 = 2
            r15 = 0
            r19 = r16
            r16 = 0
            r20 = 2
            r17 = 0
            r21 = r19
            r19 = 4094(0xffe, float:5.737E-42)
            r22 = 2
            r20 = 0
            r1 = r21
            java.lang.Object r4 = com.lagradost.nicehttp.Requests.get$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20)
            r9 = r18
            if (r4 != r2) goto L131
            return r2
        L131:
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r5
        L13a:
            com.lagradost.nicehttp.NiceResponse r4 = (com.lagradost.nicehttp.NiceResponse) r4
            java.lang.String r15 = r4.getText()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>(r15)
            java.lang.String r5 = "success"
            r6 = 0
            boolean r5 = r4.optBoolean(r5, r6)
            if (r5 == 0) goto L22c
            java.lang.String r6 = "data"
            org.json.JSONObject r6 = r4.getJSONObject(r6)
            java.lang.String r7 = "quality"
            java.lang.String r8 = "480p"
            java.lang.String r7 = r6.optString(r7, r8)
            java.lang.String r8 = "format"
            java.lang.String r1 = "MP4"
            java.lang.String r1 = r6.optString(r8, r1)
            java.lang.String r8 = "dataId"
            r17 = r3
            java.lang.String r3 = ""
            java.lang.String r3 = r6.optString(r8, r3)
            java.lang.String r8 = r0.getMainUrl()
            r24 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r8 = "/stream/"
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r8 = "."
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r4 = r4.toString()
            r8 = r6
            r6 = r4
            java.lang.String r4 = r0.getName()
            java.lang.String r18 = r0.getName()
            com.lagradost.cloudstream3.utils.ExtractorLinkType r19 = com.lagradost.cloudstream3.utils.ExtractorApiKt.getINFER_TYPE()
            r25 = r1
            com.phisher98.Blakiteapi$getUrl$2 r1 = new com.phisher98.Blakiteapi$getUrl$2
            r26 = r3
            r3 = 0
            r1.<init>(r0, r7, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r9.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r9.L$1 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r9.L$2 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r9.L$3 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r9.L$4 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r9.L$5 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r9.L$6 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r9.L$7 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r9.L$8 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r9.L$9 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)
            r9.L$10 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r9.L$11 = r3
            r9.L$12 = r13
            r9.Z$0 = r5
            r3 = 2
            r9.label = r3
            r3 = r5
            r16 = r8
            r5 = r18
            r8 = r1
            r18 = r7
            r7 = r19
            r1 = r24
            java.lang.Object r4 = com.lagradost.cloudstream3.utils.ExtractorApiKt.newExtractorLink(r4, r5, r6, r7, r8, r9)
            if (r4 != r2) goto L214
            return r2
        L214:
            r8 = r25
            r7 = r26
            r2 = r11
            r5 = r13
            r11 = r16
            r13 = r1
            r1 = r10
            r16 = r5
            r10 = r18
        L222:
            r5.invoke(r4)
            r10 = r1
            r11 = r2
            r4 = r13
            r13 = r16
            r5 = r3
            goto L230
        L22c:
            r17 = r3
            r1 = r4
            r3 = r5
        L230:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
    }
}
