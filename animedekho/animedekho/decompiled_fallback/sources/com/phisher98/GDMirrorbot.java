package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/phisher98/GDMirrorbot;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,448:1\n1#2:449\n1#2:453\n1#2:476\n1#2:497\n93#3,2:450\n63#3:452\n64#3,15:454\n95#3,2:471\n93#3,2:473\n63#3:475\n64#3,15:477\n95#3,2:494\n63#3:496\n64#3,15:498\n50#4:469\n43#4:470\n50#4:492\n43#4:493\n50#4:513\n43#4:514\n2068#5,2:515\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/GDMirrorbot\n*L\n72#1:453\n84#1:476\n93#1:497\n72#1:450,2\n72#1:452\n72#1:454,15\n72#1:471,2\n84#1:473,2\n84#1:475\n84#1:477,15\n84#1:494,2\n93#1:496\n93#1:498,15\n72#1:469\n72#1:470\n84#1:492\n84#1:493\n93#1:513\n93#1:514\n101#1:515,2\n*E\n"})
public class GDMirrorbot extends com.lagradost.cloudstream3.utils.ExtractorApi {

    @org.jetbrains.annotations.NotNull
    private java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private java.lang.String name;
    private final boolean requiresReferer;

    /* JADX INFO: renamed from: com.phisher98.GDMirrorbot$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.GDMirrorbot", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {52, 54, 69, 82, 110, 111, 112}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "pageText", "finalId", "myKey", "idType", "baseUrl", "hostUrl", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "root", "siteUrls", "siteFriendlyNames", "mresultData", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "root", "siteUrls", "siteFriendlyNames", "mresultData", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "postData", "responseText", "root", "siteUrls", "siteFriendlyNames", "mresultData", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "fullUrl", "friendlyName", "base"}, nl = {54, 55, 72, 84, 111, 112, 114}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
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
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        java.lang.Object L$8;
        java.lang.Object L$9;
        int label;
        /* synthetic */ java.lang.Object result;
        final /* synthetic */ com.phisher98.GDMirrorbot this$0;

        AnonymousClass1(com.phisher98.GDMirrorbot r1, kotlin.coroutines.Continuation<? super com.phisher98.GDMirrorbot.AnonymousClass1> r2) {
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
                com.phisher98.GDMirrorbot r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = com.phisher98.GDMirrorbot.getUrl$suspendImpl(r1, r2, r3, r4, r5, r6)
                return r0
        }
    }

    public GDMirrorbot() {
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "GDMirrorbot"
            r1.name = r0
            java.lang.String r0 = "https://gdmirrorbot.nl"
            r1.mainUrl = r0
            r0 = 1
            r1.requiresReferer = r0
            return
    }

    private final java.lang.String getBaseUrl(java.lang.String r6) {
            r5 = this;
            io.ktor.http.Url r0 = io.ktor.http.URLUtilsKt.Url(r6)
            r1 = 0
            io.ktor.http.URLProtocol r2 = r0.getProtocol()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = r0.getHost()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = "://"
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r2.toString()
            return r0
    }

    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.GDMirrorbot r38, java.lang.String r39, java.lang.String r40, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r41, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r42, kotlin.coroutines.Continuation<? super kotlin.Unit> r43) {
            r0 = r38
            r3 = r39
            r1 = r40
            r2 = r41
            r4 = r42
            r5 = r43
            boolean r6 = r5 instanceof com.phisher98.GDMirrorbot.AnonymousClass1
            if (r6 == 0) goto L20
            r6 = r5
            com.phisher98.GDMirrorbot$getUrl$1 r6 = (com.phisher98.GDMirrorbot.AnonymousClass1) r6
            int r7 = r6.label
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r7 & r8
            if (r7 == 0) goto L20
            int r7 = r6.label
            int r7 = r7 - r8
            r6.label = r7
            goto L25
        L20:
            com.phisher98.GDMirrorbot$getUrl$1 r6 = new com.phisher98.GDMirrorbot$getUrl$1
            r6.<init>(r0, r5)
        L25:
            java.lang.Object r7 = r6.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r9 = r6.label
            java.lang.String r10 = "/"
            java.lang.String r28 = "kotlinx.serialization.serializer.simple"
            java.lang.String r11 = "Phisher"
            switch(r9) {
                case 0: goto L31c;
                case 1: goto L2e5;
                case 2: goto L2bd;
                case 3: goto L26d;
                case 4: goto L232;
                case 5: goto L16c;
                case 6: goto Ld7;
                case 7: goto L3e;
                default: goto L36;
            }
        L36:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3e:
            r9 = 0
            r14 = 0
            java.lang.Object r15 = r6.L$21
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r12 = r6.L$20
            java.lang.Object r13 = r6.L$19
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r5 = r6.L$18
            java.lang.String r5 = (java.lang.String) r5
            r18 = r5
            java.lang.Object r5 = r6.L$17
            r19 = r5
            java.lang.Object r5 = r6.L$16
            r20 = r5
            java.lang.Object r5 = r6.L$15
            java.util.Iterator r5 = (java.util.Iterator) r5
            r21 = r5
            java.lang.Object r5 = r6.L$14
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r22 = r5
            java.lang.Object r5 = r6.L$13
            java.util.Map r5 = (java.util.Map) r5
            r23 = r5
            java.lang.Object r5 = r6.L$12
            r24 = r5
            java.lang.Object r5 = r6.L$11
            java.util.Map r5 = (java.util.Map) r5
            r25 = r5
            java.lang.Object r5 = r6.L$10
            java.util.Map r5 = (java.util.Map) r5
            r26 = r5
            java.lang.Object r5 = r6.L$9
            java.util.Map r5 = (java.util.Map) r5
            r27 = r5
            java.lang.Object r5 = r6.L$8
            java.lang.String r5 = (java.lang.String) r5
            r28 = r5
            java.lang.Object r5 = r6.L$7
            java.util.Map r5 = (java.util.Map) r5
            r29 = r5
            java.lang.Object r5 = r6.L$6
            java.lang.String r5 = (java.lang.String) r5
            r30 = r5
            java.lang.Object r5 = r6.L$5
            java.lang.String r5 = (java.lang.String) r5
            r31 = r5
            java.lang.Object r5 = r6.L$4
            r4 = r5
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r6.L$3
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r6.L$2
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r6.L$1
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r6.L$0
            com.phisher98.GDMirrorbot r5 = (com.phisher98.GDMirrorbot) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L201
            r0 = r18
            r18 = r15
            r15 = r0
            r16 = r12
            r17 = r13
            r0 = r19
            r12 = r25
            r13 = r26
            r26 = r30
            r36 = 0
            r19 = r43
            r30 = r10
            r10 = r23
            r23 = r24
            r24 = r14
            r14 = r11
            r11 = r9
            r9 = r5
            r5 = r20
            goto Lcf2
        Ld7:
            r9 = 0
            r14 = 0
            java.lang.Object r5 = r6.L$21
            r15 = r5
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r12 = r6.L$20
            java.lang.Object r5 = r6.L$19
            r13 = r5
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r5 = r6.L$18
            java.lang.String r5 = (java.lang.String) r5
            r18 = r5
            java.lang.Object r5 = r6.L$17
            r19 = r5
            java.lang.Object r5 = r6.L$16
            r20 = r5
            java.lang.Object r5 = r6.L$15
            java.util.Iterator r5 = (java.util.Iterator) r5
            r21 = r5
            java.lang.Object r5 = r6.L$14
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r22 = r5
            java.lang.Object r5 = r6.L$13
            java.util.Map r5 = (java.util.Map) r5
            r23 = r5
            java.lang.Object r5 = r6.L$12
            r24 = r5
            java.lang.Object r5 = r6.L$11
            java.util.Map r5 = (java.util.Map) r5
            r25 = r5
            java.lang.Object r5 = r6.L$10
            java.util.Map r5 = (java.util.Map) r5
            r26 = r5
            java.lang.Object r5 = r6.L$9
            java.util.Map r5 = (java.util.Map) r5
            r27 = r5
            java.lang.Object r5 = r6.L$8
            java.lang.String r5 = (java.lang.String) r5
            r28 = r5
            java.lang.Object r5 = r6.L$7
            java.util.Map r5 = (java.util.Map) r5
            r29 = r5
            java.lang.Object r5 = r6.L$6
            java.lang.String r5 = (java.lang.String) r5
            r30 = r5
            java.lang.Object r5 = r6.L$5
            java.lang.String r5 = (java.lang.String) r5
            r31 = r5
            java.lang.Object r5 = r6.L$4
            r4 = r5
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r6.L$3
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r6.L$2
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r6.L$1
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r6.L$0
            com.phisher98.GDMirrorbot r5 = (com.phisher98.GDMirrorbot) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L201
            r16 = r13
            r17 = r15
            r15 = r18
            r0 = r19
            r13 = r26
            r26 = r30
            r36 = 0
            r19 = r43
            r30 = r10
            r10 = r23
            r23 = r24
            r24 = r14
            r14 = r11
            r11 = r12
            r12 = r25
            goto Lc42
        L16c:
            r9 = 0
            r14 = 0
            java.lang.Object r5 = r6.L$21
            r15 = r5
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r12 = r6.L$20
            java.lang.Object r5 = r6.L$19
            r13 = r5
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r5 = r6.L$18
            java.lang.String r5 = (java.lang.String) r5
            r18 = r5
            java.lang.Object r5 = r6.L$17
            r19 = r5
            java.lang.Object r5 = r6.L$16
            r20 = r5
            java.lang.Object r5 = r6.L$15
            java.util.Iterator r5 = (java.util.Iterator) r5
            r21 = r5
            java.lang.Object r5 = r6.L$14
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r22 = r5
            java.lang.Object r5 = r6.L$13
            java.util.Map r5 = (java.util.Map) r5
            r23 = r5
            java.lang.Object r5 = r6.L$12
            r24 = r5
            java.lang.Object r5 = r6.L$11
            java.util.Map r5 = (java.util.Map) r5
            r25 = r5
            java.lang.Object r5 = r6.L$10
            java.util.Map r5 = (java.util.Map) r5
            r26 = r5
            java.lang.Object r5 = r6.L$9
            java.util.Map r5 = (java.util.Map) r5
            r27 = r5
            java.lang.Object r5 = r6.L$8
            java.lang.String r5 = (java.lang.String) r5
            r28 = r5
            java.lang.Object r5 = r6.L$7
            java.util.Map r5 = (java.util.Map) r5
            r29 = r5
            java.lang.Object r5 = r6.L$6
            java.lang.String r5 = (java.lang.String) r5
            r30 = r5
            java.lang.Object r5 = r6.L$5
            java.lang.String r5 = (java.lang.String) r5
            r31 = r5
            java.lang.Object r5 = r6.L$4
            r4 = r5
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r6.L$3
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r6.L$2
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r6.L$1
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r6.L$0
            com.phisher98.GDMirrorbot r5 = (com.phisher98.GDMirrorbot) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L201
            r16 = r13
            r17 = r15
            r15 = r18
            r0 = r19
            r13 = r26
            r26 = r30
            r36 = 0
            r19 = r43
            r30 = r10
            r10 = r23
            r23 = r24
            r24 = r14
            r14 = r11
            r11 = r12
            r12 = r25
            goto Lce8
        L201:
            r0 = move-exception
            r38 = r0
            r0 = r13
            r13 = r26
            r17 = r28
            r16 = r29
            r26 = r30
            r36 = 0
            r29 = r7
            r30 = r10
            r28 = r15
            r15 = r18
            r7 = r21
            r10 = r23
            r23 = r24
            r18 = r31
            r21 = r9
            r24 = r14
            r31 = r19
            r19 = r43
            r9 = r5
            r14 = r11
            r11 = r12
            r5 = r20
            r12 = r25
            r25 = r22
            goto Ld85
        L232:
            java.lang.Object r5 = r6.L$7
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r9 = r6.L$6
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r12 = r6.L$5
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r6.L$4
            r4 = r13
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r13 = r6.L$3
            r2 = r13
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r13 = r6.L$2
            r1 = r13
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r13 = r6.L$1
            r3 = r13
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r13 = r6.L$0
            r0 = r13
            com.phisher98.GDMirrorbot r0 = (com.phisher98.GDMirrorbot) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r33 = r2
            r13 = r5
            r16 = r6
            r29 = r7
            r2 = r8
            r34 = r11
            r36 = 0
            r6 = r4
            r4 = r1
            r1 = r10
            r5 = r3
            r3 = r0
            goto L7ec
        L26d:
            java.lang.Object r5 = r6.L$11
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r9 = r6.L$10
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r12 = r6.L$9
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r6.L$8
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r6.L$7
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r6.L$6
            java.lang.String r15 = (java.lang.String) r15
            r20 = r5
            java.lang.Object r5 = r6.L$5
            java.lang.String r5 = (java.lang.String) r5
            r21 = r5
            java.lang.Object r5 = r6.L$4
            r4 = r5
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r6.L$3
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r6.L$2
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r6.L$1
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r6.L$0
            r0 = r5
            com.phisher98.GDMirrorbot r0 = (com.phisher98.GDMirrorbot) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r5 = r9
            r9 = r6
            r6 = r5
            r31 = r1
            r5 = r4
            r29 = r7
            r33 = r10
            r34 = r11
            r1 = 2
            r36 = 0
            r4 = r2
            r10 = r8
            r2 = 0
            goto L5e8
        L2bd:
            java.lang.Object r5 = r6.L$4
            r4 = r5
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r6.L$3
            r2 = r5
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r5 = r6.L$2
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r6.L$1
            r3 = r5
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r6.L$0
            r0 = r5
            com.phisher98.GDMirrorbot r0 = (com.phisher98.GDMirrorbot) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r5 = r4
            r29 = r7
            r33 = r10
            r34 = r11
            r4 = r2
            r2 = r1
            r1 = r8
            goto L3f6
        L2e5:
            java.lang.Object r5 = r6.L$6
            com.phisher98.GDMirrorbot r5 = (com.phisher98.GDMirrorbot) r5
            java.lang.Object r9 = r6.L$5
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r12 = r6.L$4
            r4 = r12
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r12 = r6.L$3
            r2 = r12
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r12 = r6.L$2
            r1 = r12
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r12 = r6.L$1
            r3 = r12
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r12 = r6.L$0
            r0 = r12
            com.phisher98.GDMirrorbot r0 = (com.phisher98.GDMirrorbot) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r29 = r2
            r2 = r0
            r0 = r5
            r5 = r29
            r29 = r7
            r33 = r10
            r34 = r11
            r7 = r4
            r4 = r1
            r1 = r8
            r8 = r29
            goto L396
        L31c:
            kotlin.ResultKt.throwOnFailure(r7)
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r9 = "key="
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r12 = 0
            r13 = 2
            r14 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r9, r12, r13, r14)
            if (r5 != 0) goto L3b0
            java.lang.String r5 = "embed/"
            java.lang.String r5 = kotlin.text.StringsKt.substringAfterLast$default(r3, r5, r14, r13, r14)
            com.lagradost.nicehttp.Requests r9 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r6.L$0 = r0
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r6.L$1 = r15
            r6.L$2 = r1
            r6.L$3 = r2
            r6.L$4 = r4
            r6.L$5 = r5
            r6.L$6 = r0
            r15 = 1
            r6.label = r15
            r4 = 0
            r16 = r5
            r5 = 0
            r21 = r6
            r6 = 0
            r17 = r7
            r7 = 0
            r18 = r8
            r8 = 0
            r2 = r9
            r9 = 0
            r19 = r10
            r10 = 0
            r20 = r11
            r22 = 0
            r11 = 0
            r23 = 2
            r13 = 0
            r24 = r14
            r14 = 0
            r25 = 1
            r15 = 0
            r26 = r17
            r17 = 4094(0xffe, float:5.737E-42)
            r27 = r18
            r18 = 0
            r33 = r19
            r34 = r20
            r29 = r26
            r1 = r27
            r19 = r16
            r16 = r21
            java.lang.Object r7 = com.lagradost.nicehttp.Requests.get$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)
            r6 = r16
            if (r7 != r1) goto L38c
            return r1
        L38c:
            r4 = r40
            r5 = r41
            r2 = r0
            r8 = r7
            r9 = r19
            r7 = r42
        L396:
            com.lagradost.nicehttp.NiceResponse r8 = (com.lagradost.nicehttp.NiceResponse) r8
            java.lang.String r8 = r8.getUrl()
            java.lang.String r0 = r0.getBaseUrl(r8)
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r9, r0)
            r10 = r1
            r0 = r2
            r2 = r5
            r9 = r6
            r6 = r7
            r1 = r33
            r36 = 0
            goto L745
        L3b0:
            r29 = r7
            r1 = r8
            r33 = r10
            r34 = r11
            com.lagradost.nicehttp.Requests r2 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r6.L$0 = r0
            r6.L$1 = r3
            r4 = r40
            r6.L$2 = r4
            r5 = r41
            r6.L$3 = r5
            r7 = r42
            r6.L$4 = r7
            r8 = 2
            r6.label = r8
            r4 = 0
            r5 = 0
            r16 = r6
            r6 = 0
            r7 = 0
            r13 = 2
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r18 = 2
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 4094(0xffe, float:5.737E-42)
            r37 = 2
            r18 = 0
            java.lang.Object r7 = com.lagradost.nicehttp.Requests.get$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)
            r6 = r16
            if (r7 != r1) goto L3ee
            return r1
        L3ee:
            r3 = r39
            r2 = r40
            r4 = r41
            r5 = r42
        L3f6:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7
            java.lang.String r24 = r7.getText()
            kotlin.text.Regex r7 = new kotlin.text.Regex
            java.lang.String r8 = "FinalID\\s*=\\s*\"([^\"]+)\""
            r7.<init>(r8)
            r8 = r24
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = 0
            r10 = 2
            r11 = 0
            kotlin.text.MatchResult r7 = kotlin.text.Regex.find$default(r7, r8, r9, r10, r11)
            if (r7 == 0) goto L41f
            java.util.List r7 = r7.getGroupValues()
            if (r7 == 0) goto L41f
            r8 = 1
            java.lang.Object r7 = r7.get(r8)
            r15 = r7
            java.lang.String r15 = (java.lang.String) r15
            goto L421
        L41f:
            r8 = 1
            r15 = r11
        L421:
            r7 = r15
            kotlin.text.Regex r12 = new kotlin.text.Regex
            java.lang.String r13 = "myKey\\s*=\\s*\"([^\"]+)\""
            r12.<init>(r13)
            r13 = r24
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            kotlin.text.MatchResult r12 = kotlin.text.Regex.find$default(r12, r13, r9, r10, r11)
            if (r12 == 0) goto L441
            java.util.List r12 = r12.getGroupValues()
            if (r12 == 0) goto L441
            java.lang.Object r12 = r12.get(r8)
            r15 = r12
            java.lang.String r15 = (java.lang.String) r15
            goto L442
        L441:
            r15 = r11
        L442:
            r12 = r15
            kotlin.text.Regex r13 = new kotlin.text.Regex
            java.lang.String r14 = "idType\\s*=\\s*\"([^\"]+)\""
            r13.<init>(r14)
            r14 = r24
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            kotlin.text.MatchResult r13 = kotlin.text.Regex.find$default(r13, r14, r9, r10, r11)
            if (r13 == 0) goto L462
            java.util.List r13 = r13.getGroupValues()
            if (r13 == 0) goto L462
            java.lang.Object r13 = r13.get(r8)
            java.lang.String r13 = (java.lang.String) r13
            if (r13 != 0) goto L464
        L462:
            java.lang.String r13 = "imdbid"
        L464:
            kotlin.text.Regex r14 = new kotlin.text.Regex
            java.lang.String r15 = "let\\s+baseUrl\\s*=\\s*\"([^\"]+)\""
            r14.<init>(r15)
            r15 = r24
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            kotlin.text.MatchResult r14 = kotlin.text.Regex.find$default(r14, r15, r9, r10, r11)
            if (r14 == 0) goto L483
            java.util.List r14 = r14.getGroupValues()
            if (r14 == 0) goto L483
            java.lang.Object r14 = r14.get(r8)
            r15 = r14
            java.lang.String r15 = (java.lang.String) r15
            goto L484
        L483:
            r15 = r11
        L484:
            r25 = r15
            if (r25 == 0) goto L490
            r14 = r25
            r15 = 0
            java.lang.String r15 = r0.getBaseUrl(r14)
            goto L491
        L490:
            r15 = r11
        L491:
            r14 = r15
            if (r7 == 0) goto L5f8
            if (r12 == 0) goto L5f8
            r15 = r3
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            java.lang.String r16 = "/tv/"
            r8 = r16
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.contains$default(r15, r8, r9, r10, r11)
            java.lang.String r15 = "&key="
            if (r8 == 0) goto L52e
            kotlin.text.Regex r8 = new kotlin.text.Regex
            java.lang.String r9 = "/tv/\\d+/(\\d+)/"
            r8.<init>(r9)
            r9 = r3
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r30 = r1
            r1 = 0
            kotlin.text.MatchResult r8 = kotlin.text.Regex.find$default(r8, r9, r1, r10, r11)
            java.lang.String r1 = "1"
            if (r8 == 0) goto L4cb
            java.util.List r8 = r8.getGroupValues()
            if (r8 == 0) goto L4cb
            r9 = 1
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L4cc
        L4cb:
            r8 = r1
        L4cc:
            kotlin.text.Regex r9 = new kotlin.text.Regex
            java.lang.String r10 = "/tv/\\d+/\\d+/(\\d+)"
            r9.<init>(r10)
            r10 = r3
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r38 = r1
            r39 = r14
            r1 = 0
            r14 = 2
            kotlin.text.MatchResult r9 = kotlin.text.Regex.find$default(r9, r10, r1, r14, r11)
            if (r9 == 0) goto L4f2
            java.util.List r9 = r9.getGroupValues()
            if (r9 == 0) goto L4f2
            r10 = 1
            java.lang.Object r9 = r9.get(r10)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L4f5
            goto L4f3
        L4f2:
            r10 = 1
        L4f3:
            r9 = r38
        L4f5:
            java.lang.String r1 = r0.getMainUrl()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r1 = r10.append(r1)
            java.lang.String r10 = "/myseriesapi?tmdbid="
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r10 = "&season="
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r10 = "&epname="
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.StringBuilder r1 = r1.append(r15)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r1 = r1.toString()
            r8 = r1
            goto L561
        L52e:
            r30 = r1
            r39 = r14
            r14 = 2
            java.lang.String r1 = r0.getMainUrl()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r1 = r8.append(r1)
            java.lang.String r8 = "/mymovieapi?"
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.StringBuilder r1 = r1.append(r13)
            java.lang.String r8 = "="
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.StringBuilder r1 = r1.append(r15)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r1 = r1.toString()
            r8 = r1
        L561:
            r15 = r7
            com.lagradost.nicehttp.Requests r7 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r6.L$0 = r0
            r6.L$1 = r3
            r6.L$2 = r2
            r6.L$3 = r4
            r6.L$4 = r5
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r24)
            r6.L$5 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$6 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r6.L$7 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r6.L$8 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r6.L$9 = r1
            r1 = r39
            r6.L$10 = r1
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r6.L$11 = r9
            r9 = 3
            r6.label = r9
            r9 = 0
            r10 = 0
            r32 = r11
            r11 = 0
            r18 = r12
            r12 = 0
            r19 = r13
            r13 = 0
            r37 = 2
            r14 = 0
            r20 = r15
            r15 = 0
            r35 = 1
            r36 = 0
            r16 = 0
            r21 = r18
            r18 = 0
            r22 = r19
            r19 = 0
            r23 = r20
            r20 = 0
            r26 = r22
            r22 = 4094(0xffe, float:5.737E-42)
            r27 = r23
            r23 = 0
            r31 = r2
            r38 = r21
            r2 = r32
            r21 = r6
            r6 = r1
            r1 = 2
            java.lang.Object r7 = com.lagradost.nicehttp.Requests.get$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)
            r9 = r21
            r10 = r30
            if (r7 != r10) goto L5dc
            return r10
        L5dc:
            r14 = r38
            r20 = r8
            r21 = r24
            r12 = r25
            r13 = r26
            r15 = r27
        L5e8:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7
            java.lang.String r24 = r7.getText()
            r25 = r12
            r12 = r14
            r7 = r15
            r14 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r0
            goto L612
        L5f8:
            r10 = r1
            r31 = r2
            r9 = r6
            r27 = r7
            r2 = r11
            r38 = r12
            r26 = r13
            r6 = r14
            r1 = 2
            r36 = 0
            r12 = r38
            r13 = r26
            r7 = r27
            r14 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r0
        L612:
            com.lagradost.cloudstream3.utils.AppUtils r8 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r0 = r24
            r11 = r0
            r15 = 0
            if (r11 != 0) goto L622
            r15 = r2
            r40 = r3
            r41 = r5
            goto L6f4
        L622:
            r38 = r11
            r16 = r8
            r17 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L65e
            r0 = r16
            r18 = 0
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            kotlin.reflect.KTypeProjection$Companion r2 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L65e
            java.lang.Class<java.lang.String> r19 = java.lang.String.class
            r39 = r0
            kotlin.reflect.KType r0 = kotlin.jvm.internal.Reflection.typeOf(r19)     // Catch: java.lang.Throwable -> L65e
            kotlin.reflect.KTypeProjection r0 = r2.invariant(r0)     // Catch: java.lang.Throwable -> L65e
            kotlin.reflect.KTypeProjection$Companion r2 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L65e
            java.lang.Class<java.lang.Object> r19 = java.lang.Object.class
            r40 = r3
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.nullableTypeOf(r19)     // Catch: java.lang.Throwable -> L65c
            kotlin.reflect.KTypeProjection r2 = r2.invariant(r3)     // Catch: java.lang.Throwable -> L65c
            kotlin.reflect.KType r0 = kotlin.jvm.internal.Reflection.typeOf(r1, r0, r2)     // Catch: java.lang.Throwable -> L65c
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r28)     // Catch: java.lang.Throwable -> L65c
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.SerializersKt.serializer(r0)     // Catch: java.lang.Throwable -> L65c
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L65c
            goto L66b
        L65c:
            r0 = move-exception
            goto L661
        L65e:
            r0 = move-exception
            r40 = r3
        L661:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Exception -> L6ef
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Exception -> L6ef
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Exception -> L6ef
        L66b:
            java.lang.Throwable r1 = kotlin.Result.exceptionOrNull-impl(r0)     // Catch: java.lang.Exception -> L6ef
            if (r1 != 0) goto L674
            r41 = r5
            goto L6a3
        L674:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L696
            r0 = 0
            kotlinx.serialization.json.Json r2 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L696
            kotlinx.serialization.modules.SerializersModule r2 = r2.getSerializersModule()     // Catch: java.lang.Throwable -> L696
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)     // Catch: java.lang.Throwable -> L696
            r39 = r1
            r41 = r5
            r1 = 2
            r5 = 0
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r2, r3, r5, r1, r5)     // Catch: java.lang.Throwable -> L694
            java.lang.Object r0 = kotlin.Result.constructor-impl(r2)     // Catch: java.lang.Throwable -> L694
            goto L6a3
        L694:
            r0 = move-exception
            goto L699
        L696:
            r0 = move-exception
            r41 = r5
        L699:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Exception -> L6ed
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Exception -> L6ed
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Exception -> L6ed
        L6a3:
            boolean r1 = kotlin.Result.isFailure-impl(r0)     // Catch: java.lang.Exception -> L6ed
            if (r1 == 0) goto L6aa
            r0 = 0
        L6aa:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.Exception -> L6ed
            r1 = r0
            if (r1 == 0) goto L6d0
        L6b0:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L6c2 kotlinx.serialization.SerializationException -> L6c6
            r2 = r1
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2     // Catch: java.lang.Throwable -> L6c2 kotlinx.serialization.SerializationException -> L6c6
            r3 = r38
            java.lang.Object r0 = r0.decodeFromString(r2, r3)     // Catch: java.lang.Throwable -> L6be kotlinx.serialization.SerializationException -> L6c0
            goto L6ec
        L6be:
            r0 = move-exception
            goto L6d2
        L6c0:
            r0 = move-exception
            goto L6c9
        L6c2:
            r0 = move-exception
            r3 = r38
            goto L6d2
        L6c6:
            r0 = move-exception
            r3 = r38
        L6c9:
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch: java.lang.Exception -> L6ed
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r2)     // Catch: java.lang.Exception -> L6ed
            goto L6d2
        L6d0:
            r3 = r38
        L6d2:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()     // Catch: java.lang.Exception -> L6ed
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0     // Catch: java.lang.Exception -> L6ed
            r2 = r3
            r5 = 0
            r18 = 0
            com.phisher98.GDMirrorbot$getUrl$suspendImpl$$inlined$tryParseJson$1 r19 = new com.phisher98.GDMirrorbot$getUrl$suspendImpl$$inlined$tryParseJson$1     // Catch: java.lang.Exception -> L6ed
            r19.<init>()     // Catch: java.lang.Exception -> L6ed
            r38 = r1
            r1 = r19
            com.fasterxml.jackson.core.type.TypeReference r1 = (com.fasterxml.jackson.core.type.TypeReference) r1     // Catch: java.lang.Exception -> L6ed
            java.lang.Object r1 = r0.readValue(r2, r1)     // Catch: java.lang.Exception -> L6ed
            r0 = r1
        L6ec:
            goto L6f3
        L6ed:
            r0 = move-exception
            goto L6f2
        L6ef:
            r0 = move-exception
            r41 = r5
        L6f2:
            r0 = 0
        L6f3:
            r15 = r0
        L6f4:
            java.util.Map r15 = (java.util.Map) r15
            if (r15 != 0) goto L6fb
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L6fb:
            r1 = r33
            r8 = 2
            r11 = 0
            java.lang.String r0 = kotlin.text.StringsKt.substringAfterLast$default(r4, r1, r11, r8, r11)
            java.lang.String r2 = "data"
            java.lang.Object r2 = r15.get(r2)
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L710
            java.util.List r2 = (java.util.List) r2
            goto L711
        L710:
            r2 = 0
        L711:
            if (r2 == 0) goto L738
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 == 0) goto L738
            java.lang.String r5 = "fileslug"
            java.lang.Object r3 = r3.get(r5)
            if (r3 == 0) goto L738
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L738
            r5 = r3
            r8 = 0
            r11 = r5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            if (r11 != 0) goto L735
            goto L736
        L735:
            r3 = 0
        L736:
            if (r3 != 0) goto L739
        L738:
            r3 = r0
        L739:
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r3, r14)
            r0 = r40
            r2 = r41
            r3 = r4
            r4 = r31
        L745:
            java.lang.Object r5 = r8.component1()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r8.component2()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "sid"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r5)
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r8)
            com.lagradost.nicehttp.Requests r8 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.StringBuilder r11 = r11.append(r7)
            java.lang.String r12 = "/embedhelper.php"
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r9.L$0 = r0
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r9.L$1 = r12
            r9.L$2 = r4
            r9.L$3 = r2
            r9.L$4 = r6
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r9.L$5 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r9.L$6 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r9.L$7 = r12
            r14 = 0
            r9.L$8 = r14
            r9.L$9 = r14
            r9.L$10 = r14
            r9.L$11 = r14
            r12 = 4
            r9.label = r12
            r16 = r9
            r9 = 0
            r27 = r10
            r10 = 0
            r12 = r7
            r7 = r8
            r8 = r11
            r11 = 0
            r14 = r12
            r12 = 0
            r15 = r14
            r14 = 0
            r17 = r15
            r15 = 0
            r21 = r16
            r16 = 0
            r18 = r17
            r17 = 0
            r19 = r18
            r18 = 0
            r20 = r19
            r19 = 0
            r22 = r20
            r25 = r21
            r20 = 0
            r23 = r22
            r22 = 0
            r24 = r23
            r23 = 0
            r26 = r24
            r24 = 0
            r30 = r26
            r26 = 65502(0xffde, float:9.1788E-41)
            r31 = r27
            r27 = 0
            r33 = r2
            r2 = r31
            java.lang.Object r7 = com.lagradost.nicehttp.Requests.post$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27)
            r16 = r25
            if (r7 != r2) goto L7e7
            return r2
        L7e7:
            r12 = r5
            r9 = r30
            r5 = r3
            r3 = r0
        L7ec:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7
            java.lang.String r7 = r7.getText()
            com.lagradost.cloudstream3.utils.AppUtils r8 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r10 = r7
            r11 = 0
            if (r10 != 0) goto L804
            r27 = r2
            r39 = r3
            r40 = r4
            r41 = r5
            r15 = 0
            goto L8d5
        L804:
            r0 = r10
            r14 = r8
            r15 = r0
            r17 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L848
            r0 = r14
            r18 = 0
            r38 = r0
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            r27 = r2
            kotlin.reflect.KTypeProjection$Companion r2 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L846
            java.lang.Class<java.lang.String> r19 = java.lang.String.class
            r39 = r3
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.typeOf(r19)     // Catch: java.lang.Throwable -> L842
            kotlin.reflect.KTypeProjection r2 = r2.invariant(r3)     // Catch: java.lang.Throwable -> L842
            kotlin.reflect.KTypeProjection$Companion r3 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L842
            java.lang.Class<java.lang.Object> r19 = java.lang.Object.class
            r40 = r4
            kotlin.reflect.KType r4 = kotlin.jvm.internal.Reflection.nullableTypeOf(r19)     // Catch: java.lang.Throwable -> L840
            kotlin.reflect.KTypeProjection r3 = r3.invariant(r4)     // Catch: java.lang.Throwable -> L840
            kotlin.reflect.KType r0 = kotlin.jvm.internal.Reflection.typeOf(r0, r2, r3)     // Catch: java.lang.Throwable -> L840
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r28)     // Catch: java.lang.Throwable -> L840
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.SerializersKt.serializer(r0)     // Catch: java.lang.Throwable -> L840
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L840
            goto L859
        L840:
            r0 = move-exception
            goto L84f
        L842:
            r0 = move-exception
            r40 = r4
            goto L84f
        L846:
            r0 = move-exception
            goto L84b
        L848:
            r0 = move-exception
            r27 = r2
        L84b:
            r39 = r3
            r40 = r4
        L84f:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Exception -> L8d0
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Exception -> L8d0
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Exception -> L8d0
        L859:
            java.lang.Throwable r2 = kotlin.Result.exceptionOrNull-impl(r0)     // Catch: java.lang.Exception -> L8d0
            if (r2 != 0) goto L862
            r41 = r5
            goto L891
        L862:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L884
            r0 = 0
            kotlinx.serialization.json.Json r3 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L884
            kotlinx.serialization.modules.SerializersModule r3 = r3.getSerializersModule()     // Catch: java.lang.Throwable -> L884
            java.lang.Class<java.util.Map> r4 = java.util.Map.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)     // Catch: java.lang.Throwable -> L884
            r38 = r2
            r41 = r5
            r2 = 2
            r5 = 0
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r3, r4, r5, r2, r5)     // Catch: java.lang.Throwable -> L882
            java.lang.Object r0 = kotlin.Result.constructor-impl(r3)     // Catch: java.lang.Throwable -> L882
            goto L891
        L882:
            r0 = move-exception
            goto L887
        L884:
            r0 = move-exception
            r41 = r5
        L887:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Exception -> L8ce
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Exception -> L8ce
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Exception -> L8ce
        L891:
            boolean r2 = kotlin.Result.isFailure-impl(r0)     // Catch: java.lang.Exception -> L8ce
            if (r2 == 0) goto L898
            r0 = 0
        L898:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.Exception -> L8ce
            r2 = r0
            if (r2 == 0) goto L8b3
        L89e:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L8aa kotlinx.serialization.SerializationException -> L8ac
            r3 = r2
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3     // Catch: java.lang.Throwable -> L8aa kotlinx.serialization.SerializationException -> L8ac
            java.lang.Object r0 = r0.decodeFromString(r3, r15)     // Catch: java.lang.Throwable -> L8aa kotlinx.serialization.SerializationException -> L8ac
            goto L8cc
        L8aa:
            r0 = move-exception
            goto L8b3
        L8ac:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Exception -> L8ce
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r3)     // Catch: java.lang.Exception -> L8ce
        L8b3:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()     // Catch: java.lang.Exception -> L8ce
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0     // Catch: java.lang.Exception -> L8ce
            r3 = r15
            r4 = 0
            r5 = 0
            com.phisher98.GDMirrorbot$getUrl$suspendImpl$$inlined$tryParseJson$2 r18 = new com.phisher98.GDMirrorbot$getUrl$suspendImpl$$inlined$tryParseJson$2     // Catch: java.lang.Exception -> L8ce
            r18.<init>()     // Catch: java.lang.Exception -> L8ce
            r38 = r2
            r2 = r18
            com.fasterxml.jackson.core.type.TypeReference r2 = (com.fasterxml.jackson.core.type.TypeReference) r2     // Catch: java.lang.Exception -> L8ce
            java.lang.Object r2 = r0.readValue(r3, r2)     // Catch: java.lang.Exception -> L8ce
            r0 = r2
        L8cc:
            r15 = r0
            goto L8d4
        L8ce:
            r0 = move-exception
            goto L8d3
        L8d0:
            r0 = move-exception
            r41 = r5
        L8d3:
            r15 = 0
        L8d4:
        L8d5:
            java.util.Map r15 = (java.util.Map) r15
            if (r15 != 0) goto L8dc
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L8dc:
            java.lang.String r0 = "siteUrls"
            java.lang.Object r0 = r15.get(r0)
            boolean r2 = r0 instanceof java.util.Map
            if (r2 == 0) goto L8e9
            java.util.Map r0 = (java.util.Map) r0
            goto L8ea
        L8e9:
            r0 = 0
        L8ea:
            if (r0 != 0) goto L8ef
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L8ef:
            r2 = r0
            java.lang.String r0 = "siteFriendlyNames"
            java.lang.Object r0 = r15.get(r0)
            boolean r3 = r0 instanceof java.util.Map
            if (r3 == 0) goto L8fd
            java.util.Map r0 = (java.util.Map) r0
            goto L8fe
        L8fd:
            r0 = 0
        L8fe:
            r3 = r0
            java.lang.String r0 = "mresult"
            java.lang.Object r4 = r15.get(r0)
            boolean r0 = r4 instanceof java.util.Map
            if (r0 == 0) goto L913
            r0 = r4
            java.util.Map r0 = (java.util.Map) r0
            r42 = r2
            r18 = r3
            goto L9dd
        L913:
            boolean r0 = r4 instanceof java.lang.String
            if (r0 == 0) goto Le50
            com.lagradost.cloudstream3.utils.AppUtils r0 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE     // Catch: java.lang.Exception -> Le2e
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> Le2e
            java.lang.String r5 = com.lagradost.cloudstream3.MainAPIKt.base64Decode(r5)     // Catch: java.lang.Exception -> Le2e
            r8 = r0
            r10 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L95c
            r0 = r8
            r11 = 0
            java.lang.Class<java.util.Map> r14 = java.util.Map.class
            r38 = r0
            kotlin.reflect.KTypeProjection$Companion r0 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L95c
            java.lang.Class<java.lang.String> r17 = java.lang.String.class
            r42 = r2
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r17)     // Catch: java.lang.Throwable -> L958
            kotlin.reflect.KTypeProjection r0 = r0.invariant(r2)     // Catch: java.lang.Throwable -> L958
            kotlin.reflect.KTypeProjection$Companion r2 = kotlin.reflect.KTypeProjection.Companion     // Catch: java.lang.Throwable -> L958
            java.lang.Class<java.lang.Object> r17 = java.lang.Object.class
            r18 = r3
            kotlin.reflect.KType r3 = kotlin.jvm.internal.Reflection.nullableTypeOf(r17)     // Catch: java.lang.Throwable -> L956
            kotlin.reflect.KTypeProjection r2 = r2.invariant(r3)     // Catch: java.lang.Throwable -> L956
            kotlin.reflect.KType r0 = kotlin.jvm.internal.Reflection.typeOf(r14, r0, r2)     // Catch: java.lang.Throwable -> L956
            kotlin.jvm.internal.MagicApiIntrinsics.voidMagicApiCall(r28)     // Catch: java.lang.Throwable -> L956
            kotlinx.serialization.KSerializer r0 = kotlinx.serialization.SerializersKt.serializer(r0)     // Catch: java.lang.Throwable -> L956
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L956
            goto L96b
        L956:
            r0 = move-exception
            goto L961
        L958:
            r0 = move-exception
            r18 = r3
            goto L961
        L95c:
            r0 = move-exception
            r42 = r2
            r18 = r3
        L961:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Exception -> Le2a
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Exception -> Le2a
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Exception -> Le2a
        L96b:
            java.lang.Throwable r2 = kotlin.Result.exceptionOrNull-impl(r0)     // Catch: java.lang.Exception -> Le2a
            if (r2 != 0) goto L973
            r2 = 0
            goto L99f
        L973:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L993
            r0 = 0
            kotlinx.serialization.json.Json r3 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L993
            kotlinx.serialization.modules.SerializersModule r3 = r3.getSerializersModule()     // Catch: java.lang.Throwable -> L993
            java.lang.Class<java.util.Map> r11 = java.util.Map.class
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)     // Catch: java.lang.Throwable -> L993
            r38 = r2
            r2 = 0
            r14 = 2
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r3, r11, r2, r14, r2)     // Catch: java.lang.Throwable -> L991
            java.lang.Object r0 = kotlin.Result.constructor-impl(r3)     // Catch: java.lang.Throwable -> L991
            goto L99f
        L991:
            r0 = move-exception
            goto L995
        L993:
            r0 = move-exception
            r2 = 0
        L995:
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch: java.lang.Exception -> Le2a
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch: java.lang.Exception -> Le2a
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Exception -> Le2a
        L99f:
            boolean r3 = kotlin.Result.isFailure-impl(r0)     // Catch: java.lang.Exception -> Le2a
            if (r3 == 0) goto L9a6
            r0 = r2
        L9a6:
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch: java.lang.Exception -> Le2a
            r2 = r0
            if (r2 == 0) goto L9c1
        L9ac:
            kotlinx.serialization.json.Json r0 = com.lagradost.cloudstream3.MainAPIKt.getJson()     // Catch: java.lang.Throwable -> L9b8 kotlinx.serialization.SerializationException -> L9ba
            r3 = r2
            kotlinx.serialization.DeserializationStrategy r3 = (kotlinx.serialization.DeserializationStrategy) r3     // Catch: java.lang.Throwable -> L9b8 kotlinx.serialization.SerializationException -> L9ba
            java.lang.Object r0 = r0.decodeFromString(r3, r5)     // Catch: java.lang.Throwable -> L9b8 kotlinx.serialization.SerializationException -> L9ba
            goto L9da
        L9b8:
            r0 = move-exception
            goto L9c1
        L9ba:
            r0 = move-exception
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Exception -> Le2a
            com.lagradost.cloudstream3.mvvm.ArchComponentExtKt.logError(r3)     // Catch: java.lang.Exception -> Le2a
        L9c1:
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()     // Catch: java.lang.Exception -> Le2a
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0     // Catch: java.lang.Exception -> Le2a
            r3 = r5
            r11 = 0
            r14 = 0
            com.phisher98.GDMirrorbot$getUrl$suspendImpl$$inlined$parseJson$1 r17 = new com.phisher98.GDMirrorbot$getUrl$suspendImpl$$inlined$parseJson$1     // Catch: java.lang.Exception -> Le2a
            r17.<init>()     // Catch: java.lang.Exception -> Le2a
            r38 = r2
            r2 = r17
            com.fasterxml.jackson.core.type.TypeReference r2 = (com.fasterxml.jackson.core.type.TypeReference) r2     // Catch: java.lang.Exception -> Le2a
            java.lang.Object r2 = r0.readValue(r3, r2)     // Catch: java.lang.Exception -> Le2a
            r0 = r2
        L9da:
            java.util.Map r0 = (java.util.Map) r0     // Catch: java.lang.Exception -> Le2a
        L9dd:
            java.util.Set r2 = r42.keySet()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r3 = r0.keySet()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Set r2 = kotlin.collections.CollectionsKt.intersect(r2, r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.Iterator r5 = r2.iterator()
            r8 = r18
            r18 = r12
            r12 = r8
            r20 = r41
            r19 = r43
            r10 = r0
            r8 = r2
            r21 = r3
            r11 = r4
            r17 = r7
            r14 = r9
            r2 = r16
            r4 = r33
            r9 = r39
            r3 = r40
            r7 = r5
            r16 = r13
            r5 = r27
            r13 = r42
        La15:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Le26
            java.lang.Object r22 = r7.next()
            r23 = r22
            r24 = 0
            r25 = r8
            r8 = r23
            java.lang.Object r0 = r13.get(r8)
            if (r0 == 0) goto Le00
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto Le00
            r23 = r11
            r26 = r14
            r11 = 1
            char[] r14 = new char[r11]
            r11 = 47
            r14[r36] = r11
            java.lang.String r0 = kotlin.text.StringsKt.trimEnd(r0, r14)
            if (r0 != 0) goto La53
            r14 = r6
            r6 = r2
            r2 = r4
            r4 = r14
            r30 = r1
            r1 = r3
            r31 = r8
            r27 = r15
            r14 = r34
            goto Le13
        La53:
            r14 = r0
            java.lang.Object r0 = r10.get(r8)
            if (r0 == 0) goto Ldee
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto Ldee
            r27 = r15
            r38 = 47
            r11 = 1
            char[] r15 = new char[r11]
            r15[r36] = r38
            java.lang.String r0 = kotlin.text.StringsKt.trimStart(r0, r15)
            if (r0 != 0) goto La80
            r28 = r6
            r6 = r2
            r2 = r4
            r4 = r28
            r30 = r1
            r1 = r3
            r31 = r8
            r28 = r14
            r14 = r34
            goto Le13
        La80:
            r15 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r14)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.String r11 = r0.toString()
            if (r12 == 0) goto Laa4
            java.lang.Object r0 = r12.get(r8)
            if (r0 == 0) goto Laa4
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto Laa5
        Laa4:
            r0 = r8
        Laa5:
            r28 = r0
            com.lagradost.api.Log r0 = com.lagradost.api.Log.INSTANCE     // Catch: java.lang.Exception -> Ld69
            r30 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld63
            r1.<init>()     // Catch: java.lang.Exception -> Ld63
            r31 = r8
            r8 = r28
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Exception -> Ld4e
            r28 = r14
            java.lang.String r14 = " "
            java.lang.StringBuilder r1 = r1.append(r14)     // Catch: java.lang.Exception -> Ld3b
            java.lang.StringBuilder r1 = r1.append(r11)     // Catch: java.lang.Exception -> Ld3b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Ld3b
            r14 = r34
            r0.d(r14, r1)     // Catch: java.lang.Exception -> Ld33
            java.lang.String r0 = "StreamHG"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)     // Catch: java.lang.Exception -> Ld33
            if (r0 != 0) goto Lc4e
            java.lang.String r0 = "EarnVids"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)     // Catch: java.lang.Exception -> Ld33
            if (r0 == 0) goto Lae7
            r1 = r6
            r6 = r2
            r2 = r4
            r4 = r1
            r1 = r3
            r3 = r11
            goto Lc54
        Lae7:
            java.lang.String r0 = "RpmShare"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)     // Catch: java.lang.Exception -> Ld33
            if (r0 != 0) goto Lba4
            java.lang.String r0 = "UpnShare"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)     // Catch: java.lang.Exception -> Lb91
            if (r0 != 0) goto Lba4
            java.lang.String r0 = "StreamP2p"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)     // Catch: java.lang.Exception -> Lb91
            if (r0 == 0) goto Lb01
            goto Lba4
        Lb01:
            if (r3 != 0) goto Lb08
            java.lang.String r0 = r9.getMainUrl()     // Catch: java.lang.Exception -> Lb91
            goto Lb09
        Lb08:
            r0 = r3
        Lb09:
            r2.L$0 = r9     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)     // Catch: java.lang.Exception -> Lb91
            r2.L$1 = r1     // Catch: java.lang.Exception -> Lb91
            r2.L$2 = r3     // Catch: java.lang.Exception -> Lb91
            r2.L$3 = r4     // Catch: java.lang.Exception -> Lb91
            r2.L$4 = r6     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18)     // Catch: java.lang.Exception -> Lb91
            r2.L$5 = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)     // Catch: java.lang.Exception -> Lb91
            r2.L$6 = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)     // Catch: java.lang.Exception -> Lb91
            r2.L$7 = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)     // Catch: java.lang.Exception -> Lb91
            r2.L$8 = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27)     // Catch: java.lang.Exception -> Lb91
            r2.L$9 = r1     // Catch: java.lang.Exception -> Lb91
            r2.L$10 = r13     // Catch: java.lang.Exception -> Lb91
            r2.L$11 = r12     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)     // Catch: java.lang.Exception -> Lb91
            r2.L$12 = r1     // Catch: java.lang.Exception -> Lb91
            r2.L$13 = r10     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)     // Catch: java.lang.Exception -> Lb91
            r2.L$14 = r1     // Catch: java.lang.Exception -> Lb91
            r2.L$15 = r7     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)     // Catch: java.lang.Exception -> Lb91
            r2.L$16 = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r31)     // Catch: java.lang.Exception -> Lb91
            r2.L$17 = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)     // Catch: java.lang.Exception -> Lb91
            r2.L$18 = r1     // Catch: java.lang.Exception -> Lb91
            r2.L$19 = r11     // Catch: java.lang.Exception -> Lb91
            r2.L$20 = r8     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)     // Catch: java.lang.Exception -> Lb91
            r2.L$21 = r1     // Catch: java.lang.Exception -> Lb91
            r1 = 7
            r2.label = r1     // Catch: java.lang.Exception -> Lb91
            java.lang.Object r0 = com.lagradost.cloudstream3.utils.ExtractorApiKt.loadExtractor(r11, r0, r4, r6, r2)     // Catch: java.lang.Exception -> Lb91
            if (r0 != r5) goto Lb6f
            return r5
        Lb6f:
            r0 = r6
            r6 = r2
            r2 = r4
            r4 = r0
            r1 = r3
            r3 = r20
            r0 = r31
            r31 = r18
            r18 = r28
            r28 = r17
            r17 = r11
            r11 = r21
            r21 = r7
            r7 = r29
            r29 = r16
            r16 = r8
            r8 = r5
            r5 = r22
            r22 = r25
            goto Lcf2
        Lb91:
            r0 = move-exception
            r38 = r6
            r6 = r2
            r2 = r4
            r4 = r38
            r38 = r0
            r1 = r3
            r0 = r11
            r3 = r20
            r11 = r8
            r8 = r5
            r5 = r22
            goto Ld85
        Lba4:
            com.lagradost.cloudstream3.extractors.VidStack r0 = new com.lagradost.cloudstream3.extractors.VidStack     // Catch: java.lang.Exception -> Ld33
            r0.<init>()     // Catch: java.lang.Exception -> Ld33
            r2.L$0 = r9     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)     // Catch: java.lang.Exception -> Ld33
            r2.L$1 = r1     // Catch: java.lang.Exception -> Ld33
            r2.L$2 = r3     // Catch: java.lang.Exception -> Ld33
            r2.L$3 = r4     // Catch: java.lang.Exception -> Ld33
            r2.L$4 = r6     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18)     // Catch: java.lang.Exception -> Ld33
            r2.L$5 = r1     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)     // Catch: java.lang.Exception -> Ld33
            r2.L$6 = r1     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)     // Catch: java.lang.Exception -> Ld33
            r2.L$7 = r1     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)     // Catch: java.lang.Exception -> Ld33
            r2.L$8 = r1     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27)     // Catch: java.lang.Exception -> Ld33
            r2.L$9 = r1     // Catch: java.lang.Exception -> Ld33
            r2.L$10 = r13     // Catch: java.lang.Exception -> Ld33
            r2.L$11 = r12     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)     // Catch: java.lang.Exception -> Ld33
            r2.L$12 = r1     // Catch: java.lang.Exception -> Ld33
            r2.L$13 = r10     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)     // Catch: java.lang.Exception -> Ld33
            r2.L$14 = r1     // Catch: java.lang.Exception -> Ld33
            r2.L$15 = r7     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)     // Catch: java.lang.Exception -> Ld33
            r2.L$16 = r1     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r31)     // Catch: java.lang.Exception -> Ld33
            r2.L$17 = r1     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)     // Catch: java.lang.Exception -> Ld33
            r2.L$18 = r1     // Catch: java.lang.Exception -> Ld33
            r2.L$19 = r11     // Catch: java.lang.Exception -> Ld33
            r2.L$20 = r8     // Catch: java.lang.Exception -> Ld33
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)     // Catch: java.lang.Exception -> Ld33
            r2.L$21 = r1     // Catch: java.lang.Exception -> Ld33
            r1 = 6
            r2.label = r1     // Catch: java.lang.Exception -> Ld33
            r38 = r0
            r43 = r2
            r40 = r3
            r41 = r4
            r42 = r6
            r39 = r11
            java.lang.Object r0 = r38.getUrl(r39, r40, r41, r42, r43)     // Catch: java.lang.Exception -> Ld11
            r3 = r39
            r1 = r40
            r2 = r41
            r4 = r42
            r6 = r43
            if (r0 != r5) goto Lc25
            return r5
        Lc25:
            r0 = r28
            r28 = r17
            r17 = r0
            r11 = r8
            r0 = r31
            r8 = r5
            r5 = r9
            r31 = r18
            r9 = r21
            r21 = r7
            r7 = r29
            r29 = r16
            r16 = r3
            r3 = r20
            r20 = r22
            r22 = r25
        Lc42:
            r18 = r17
            r17 = r16
            r16 = r11
            r11 = r9
            r9 = r5
            r5 = r20
            goto Lcf2
        Lc4e:
            r1 = r6
            r6 = r2
            r2 = r4
            r4 = r1
            r1 = r3
            r3 = r11
        Lc54:
            com.lagradost.cloudstream3.extractors.VidHidePro r0 = new com.lagradost.cloudstream3.extractors.VidHidePro     // Catch: java.lang.Exception -> Ld27
            r0.<init>()     // Catch: java.lang.Exception -> Ld27
            r6.L$0 = r9     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)     // Catch: java.lang.Exception -> Ld27
            r6.L$1 = r11     // Catch: java.lang.Exception -> Ld27
            r6.L$2 = r1     // Catch: java.lang.Exception -> Ld27
            r6.L$3 = r2     // Catch: java.lang.Exception -> Ld27
            r6.L$4 = r4     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r18)     // Catch: java.lang.Exception -> Ld27
            r6.L$5 = r11     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)     // Catch: java.lang.Exception -> Ld27
            r6.L$6 = r11     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)     // Catch: java.lang.Exception -> Ld27
            r6.L$7 = r11     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)     // Catch: java.lang.Exception -> Ld27
            r6.L$8 = r11     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27)     // Catch: java.lang.Exception -> Ld27
            r6.L$9 = r11     // Catch: java.lang.Exception -> Ld27
            r6.L$10 = r13     // Catch: java.lang.Exception -> Ld27
            r6.L$11 = r12     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)     // Catch: java.lang.Exception -> Ld27
            r6.L$12 = r11     // Catch: java.lang.Exception -> Ld27
            r6.L$13 = r10     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)     // Catch: java.lang.Exception -> Ld27
            r6.L$14 = r11     // Catch: java.lang.Exception -> Ld27
            r6.L$15 = r7     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r22)     // Catch: java.lang.Exception -> Ld27
            r6.L$16 = r11     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r31)     // Catch: java.lang.Exception -> Ld27
            r6.L$17 = r11     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)     // Catch: java.lang.Exception -> Ld27
            r6.L$18 = r11     // Catch: java.lang.Exception -> Ld27
            r6.L$19 = r3     // Catch: java.lang.Exception -> Ld27
            r6.L$20 = r8     // Catch: java.lang.Exception -> Ld27
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)     // Catch: java.lang.Exception -> Ld27
            r6.L$21 = r11     // Catch: java.lang.Exception -> Ld27
            r11 = 5
            r6.label = r11     // Catch: java.lang.Exception -> Ld27
            r38 = r0
            r40 = r1
            r41 = r2
            r39 = r3
            r42 = r4
            r43 = r6
            java.lang.Object r0 = r38.getUrl(r39, r40, r41, r42, r43)     // Catch: java.lang.Exception -> Ld11
            if (r0 != r5) goto Lccb
            return r5
        Lccb:
            r0 = r28
            r28 = r17
            r17 = r0
            r11 = r8
            r0 = r31
            r8 = r5
            r5 = r9
            r31 = r18
            r9 = r21
            r21 = r7
            r7 = r29
            r29 = r16
            r16 = r3
            r3 = r20
            r20 = r22
            r22 = r25
        Lce8:
            r18 = r17
            r17 = r16
            r16 = r11
            r11 = r9
            r9 = r5
            r5 = r20
        Lcf2:
            r20 = r3
            r3 = r1
            r1 = r20
            r20 = r4
            r4 = r2
            r2 = r20
            r20 = r19
            r19 = r18
            r18 = r17
            r17 = r29
            r29 = r7
            r7 = r21
            r21 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r22
            goto Ldd9
        Ld11:
            r0 = move-exception
            r3 = r39
            r1 = r40
            r2 = r41
            r4 = r42
            r6 = r43
            r38 = r0
            r0 = r3
            r11 = r8
            r3 = r20
            r8 = r5
            r5 = r22
            goto Ld85
        Ld27:
            r0 = move-exception
            r38 = r0
            r0 = r3
            r11 = r8
            r3 = r20
            r8 = r5
            r5 = r22
            goto Ld85
        Ld33:
            r0 = move-exception
            r1 = r6
            r6 = r2
            r2 = r4
            r4 = r1
            r1 = r3
            r3 = r11
            goto Ld44
        Ld3b:
            r0 = move-exception
            r1 = r6
            r6 = r2
            r2 = r4
            r4 = r1
            r1 = r3
            r3 = r11
            r14 = r34
        Ld44:
            r38 = r0
            r0 = r3
            r11 = r8
            r3 = r20
            r8 = r5
            r5 = r22
            goto Ld85
        Ld4e:
            r0 = move-exception
            r1 = r6
            r6 = r2
            r2 = r4
            r4 = r1
            r1 = r3
            r3 = r11
            r28 = r14
            r14 = r34
            r38 = r0
            r0 = r3
            r11 = r8
            r3 = r20
            r8 = r5
            r5 = r22
            goto Ld85
        Ld63:
            r0 = move-exception
            r1 = r6
            r6 = r2
            r2 = r4
            r4 = r1
            goto Ld72
        Ld69:
            r0 = move-exception
            r30 = r6
            r6 = r2
            r2 = r4
            r4 = r30
            r30 = r1
        Ld72:
            r1 = r3
            r31 = r8
            r3 = r11
            r8 = r28
            r28 = r14
            r14 = r34
            r38 = r0
            r0 = r3
            r11 = r8
            r3 = r20
            r8 = r5
            r5 = r22
        Ld85:
            r39 = r38
            r38 = r1
            com.lagradost.api.Log r1 = com.lagradost.api.Log.INSTANCE
            r40 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r41 = r3
            java.lang.String r3 = "Failed to extract from "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r3 = " at "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = ": "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r39
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.e(r14, r2)
            r1 = r18
            r18 = r0
            r0 = r31
            r31 = r1
            r3 = r38
            r1 = r41
            r2 = r4
            r20 = r19
            r19 = r28
            r4 = r40
            r28 = r17
            r17 = r16
            r16 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r25
        Ldd9:
            r5 = r6
            r6 = r2
            r2 = r5
            r5 = r9
            r9 = r10
            r10 = r11
            r16 = r17
            r19 = r20
            r17 = r28
            r18 = r31
            r20 = r1
            r11 = r23
            r15 = r27
            goto Le1e
        Ldee:
            r27 = r6
            r6 = r2
            r2 = r4
            r4 = r27
            r30 = r1
            r1 = r3
            r31 = r8
            r28 = r14
            r27 = r15
            r14 = r34
            goto Le13
        Le00:
            r23 = r6
            r6 = r2
            r2 = r4
            r4 = r23
            r30 = r1
            r1 = r3
            r31 = r8
            r23 = r11
            r26 = r14
            r27 = r15
            r14 = r34
        Le13:
            r3 = r4
            r4 = r2
            r2 = r6
            r6 = r3
            r3 = r1
            r8 = r25
            r11 = r23
            r15 = r27
        Le1e:
            r34 = r14
            r14 = r26
            r1 = r30
            goto La15
        Le26:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        Le2a:
            r0 = move-exception
            r14 = r34
            goto Le35
        Le2e:
            r0 = move-exception
            r42 = r2
            r18 = r3
            r14 = r34
        Le35:
            com.lagradost.api.Log r1 = com.lagradost.api.Log.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to decode mresult: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.e(r14, r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        Le50:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
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
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.String r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            r1 = this;
            java.lang.Object r0 = getUrl$suspendImpl(r1, r2, r3, r4, r5, r6)
            return r0
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
