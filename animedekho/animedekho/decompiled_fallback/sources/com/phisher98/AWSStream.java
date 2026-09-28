package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AWSStream;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Response", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/AWSStream\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,448:1\n73#2,5:449\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/AWSStream\n*L\n148#1:449,5\n*E\n"})
public class AWSStream extends com.lagradost.cloudstream3.utils.ExtractorApi {

    @org.jetbrains.annotations.NotNull
    private final java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String name;
    private final boolean requiresReferer;

    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0014\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/phisher98/AWSStream$Response;", "", "hls", "", "videoImage", "", "videoSource", "securedLink", "downloadLinks", "", "attachmentLinks", "ck", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getHls", "()Z", "getVideoImage", "()Ljava/lang/String;", "getVideoSource", "getSecuredLink", "getDownloadLinks", "()Ljava/util/List;", "getAttachmentLinks", "getCk", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Response {

        @org.jetbrains.annotations.NotNull
        private final java.util.List<java.lang.Object> attachmentLinks;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String ck;

        @org.jetbrains.annotations.NotNull
        private final java.util.List<java.lang.Object> downloadLinks;
        private final boolean hls;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String securedLink;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String videoImage;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String videoSource;

        public Response(boolean r1, @org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
                r0 = this;
                r0.<init>()
                r0.hls = r1
                r0.videoImage = r2
                r0.videoSource = r3
                r0.securedLink = r4
                r0.downloadLinks = r5
                r0.attachmentLinks = r6
                r0.ck = r7
                return
        }

        public static /* synthetic */ com.phisher98.AWSStream.Response copy$default(com.phisher98.AWSStream.Response r0, boolean r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.util.List r5, java.util.List r6, java.lang.String r7, int r8, java.lang.Object r9) {
                r9 = r8 & 1
                if (r9 == 0) goto L6
                boolean r1 = r0.hls
            L6:
                r9 = r8 & 2
                if (r9 == 0) goto Lc
                java.lang.String r2 = r0.videoImage
            Lc:
                r9 = r8 & 4
                if (r9 == 0) goto L12
                java.lang.String r3 = r0.videoSource
            L12:
                r9 = r8 & 8
                if (r9 == 0) goto L18
                java.lang.String r4 = r0.securedLink
            L18:
                r9 = r8 & 16
                if (r9 == 0) goto L1e
                java.util.List<java.lang.Object> r5 = r0.downloadLinks
            L1e:
                r9 = r8 & 32
                if (r9 == 0) goto L24
                java.util.List<java.lang.Object> r6 = r0.attachmentLinks
            L24:
                r8 = r8 & 64
                if (r8 == 0) goto L2a
                java.lang.String r7 = r0.ck
            L2a:
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r2 = r0
                r3 = r1
                com.phisher98.AWSStream$Response r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9)
                return r0
        }

        public final boolean component1() {
                r1 = this;
                boolean r0 = r1.hls
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
                r1 = this;
                java.lang.String r0 = r1.videoImage
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.videoSource
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.securedLink
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Object> component5() {
                r1 = this;
                java.util.List<java.lang.Object> r0 = r1.downloadLinks
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Object> component6() {
                r1 = this;
                java.util.List<java.lang.Object> r0 = r1.attachmentLinks
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component7() {
                r1 = this;
                java.lang.String r0 = r1.ck
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.AWSStream.Response copy(boolean r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> r13, @org.jetbrains.annotations.NotNull java.util.List<? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull java.lang.String r15) {
                r8 = this;
                com.phisher98.AWSStream$Response r0 = new com.phisher98.AWSStream$Response
                r1 = r9
                r2 = r10
                r3 = r11
                r4 = r12
                r5 = r13
                r6 = r14
                r7 = r15
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r0
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
                r5 = this;
                r0 = 1
                if (r5 != r6) goto L4
                return r0
            L4:
                boolean r1 = r6 instanceof com.phisher98.AWSStream.Response
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r6
                com.phisher98.AWSStream$Response r1 = (com.phisher98.AWSStream.Response) r1
                boolean r3 = r5.hls
                boolean r4 = r1.hls
                if (r3 == r4) goto L14
                return r2
            L14:
                java.lang.String r3 = r5.videoImage
                java.lang.String r4 = r1.videoImage
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L1f
                return r2
            L1f:
                java.lang.String r3 = r5.videoSource
                java.lang.String r4 = r1.videoSource
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L2a
                return r2
            L2a:
                java.lang.String r3 = r5.securedLink
                java.lang.String r4 = r1.securedLink
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L35
                return r2
            L35:
                java.util.List<java.lang.Object> r3 = r5.downloadLinks
                java.util.List<java.lang.Object> r4 = r1.downloadLinks
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L40
                return r2
            L40:
                java.util.List<java.lang.Object> r3 = r5.attachmentLinks
                java.util.List<java.lang.Object> r4 = r1.attachmentLinks
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L4b
                return r2
            L4b:
                java.lang.String r3 = r5.ck
                java.lang.String r1 = r1.ck
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
                if (r1 != 0) goto L56
                return r2
            L56:
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Object> getAttachmentLinks() {
                r1 = this;
                java.util.List<java.lang.Object> r0 = r1.attachmentLinks
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCk() {
                r1 = this;
                java.lang.String r0 = r1.ck
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Object> getDownloadLinks() {
                r1 = this;
                java.util.List<java.lang.Object> r0 = r1.downloadLinks
                return r0
        }

        public final boolean getHls() {
                r1 = this;
                boolean r0 = r1.hls
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSecuredLink() {
                r1 = this;
                java.lang.String r0 = r1.securedLink
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVideoImage() {
                r1 = this;
                java.lang.String r0 = r1.videoImage
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getVideoSource() {
                r1 = this;
                java.lang.String r0 = r1.videoSource
                return r0
        }

        public int hashCode() {
                r3 = this;
                boolean r0 = r3.hls
                int r0 = com.phisher98.AWSStream$Response$$ExternalSyntheticBackport0.m(r0)
                int r1 = r0 * 31
                java.lang.String r2 = r3.videoImage
                int r2 = r2.hashCode()
                int r1 = r1 + r2
                int r0 = r1 * 31
                java.lang.String r2 = r3.videoSource
                int r2 = r2.hashCode()
                int r0 = r0 + r2
                int r1 = r0 * 31
                java.lang.String r2 = r3.securedLink
                int r2 = r2.hashCode()
                int r1 = r1 + r2
                int r0 = r1 * 31
                java.util.List<java.lang.Object> r2 = r3.downloadLinks
                int r2 = r2.hashCode()
                int r0 = r0 + r2
                int r1 = r0 * 31
                java.util.List<java.lang.Object> r2 = r3.attachmentLinks
                int r2 = r2.hashCode()
                int r1 = r1 + r2
                int r0 = r1 * 31
                java.lang.String r2 = r3.ck
                int r2 = r2.hashCode()
                int r0 = r0 + r2
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
                r9 = this;
                boolean r0 = r9.hls
                java.lang.String r1 = r9.videoImage
                java.lang.String r2 = r9.videoSource
                java.lang.String r3 = r9.securedLink
                java.util.List<java.lang.Object> r4 = r9.downloadLinks
                java.util.List<java.lang.Object> r5 = r9.attachmentLinks
                java.lang.String r6 = r9.ck
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "Response(hls="
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.StringBuilder r0 = r7.append(r0)
                java.lang.String r7 = ", videoImage="
                java.lang.StringBuilder r0 = r0.append(r7)
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = ", videoSource="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.String r1 = ", securedLink="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r3)
                java.lang.String r1 = ", downloadLinks="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r4)
                java.lang.String r1 = ", attachmentLinks="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r5)
                java.lang.String r1 = ", ck="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r6)
                java.lang.String r1 = ")"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AWSStream$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.AWSStream", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {144, 148, 151, 170}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "doc", "m3u8Url", "header", "formdata", "$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "doc", "m3u8Url", "header", "formdata", "response", "m3u8", "$this", "url", "referer", "subtitleCallback", "callback", "extractedHash", "doc", "m3u8Url", "header", "formdata", "response", "m3u8", "extractedPack", "unpacked", "subtitleUrl"}, nl = {145, 449, 150, 169}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$10;
        java.lang.Object L$11;
        java.lang.Object L$12;
        java.lang.Object L$13;
        java.lang.Object L$14;
        java.lang.Object L$15;
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
        final /* synthetic */ com.phisher98.AWSStream this$0;

        AnonymousClass1(com.phisher98.AWSStream r1, kotlin.coroutines.Continuation<? super com.phisher98.AWSStream.AnonymousClass1> r2) {
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
                com.phisher98.AWSStream r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = com.phisher98.AWSStream.getUrl$suspendImpl(r1, r2, r3, r4, r5, r6)
                return r0
        }
    }

    public AWSStream() {
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "AWSStream"
            r1.name = r0
            java.lang.String r0 = "https://z.awstream.net"
            r1.mainUrl = r0
            r0 = 1
            r1.requiresReferer = r0
            return
    }

    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.AWSStream r35, java.lang.String r36, java.lang.String r37, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
            r0 = r35
            r1 = r40
            boolean r2 = r1 instanceof com.phisher98.AWSStream.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.AWSStream$getUrl$1 r2 = (com.phisher98.AWSStream.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.AWSStream$getUrl$1 r2 = new com.phisher98.AWSStream$getUrl$1
            r2.<init>(r0, r1)
        L1d:
            r6 = r2
            java.lang.Object r2 = r6.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r6.label
            switch(r4) {
                case 0: goto L168;
                case 1: goto L13a;
                case 2: goto Lf5;
                case 3: goto L9f;
                case 4: goto L33;
                default: goto L29;
            }
        L29:
            r26 = r2
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L33:
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.Object r7 = r6.L$15
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r6.L$14
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r6.L$13
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r6.L$12
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r6.L$11
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r6.L$10
            com.phisher98.AWSStream$Response r12 = (com.phisher98.AWSStream.Response) r12
            java.lang.Object r13 = r6.L$9
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r14 = r6.L$8
            java.util.Map r14 = (java.util.Map) r14
            java.lang.Object r15 = r6.L$7
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r1 = r6.L$6
            org.jsoup.nodes.Document r1 = (org.jsoup.nodes.Document) r1
            r16 = r1
            java.lang.Object r1 = r6.L$5
            java.lang.String r1 = (java.lang.String) r1
            r17 = r1
            java.lang.Object r1 = r6.L$4
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r39 = r1
            java.lang.Object r1 = r6.L$3
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r38 = r1
            java.lang.Object r1 = r6.L$2
            java.lang.String r1 = (java.lang.String) r1
            r37 = r1
            java.lang.Object r1 = r6.L$1
            java.lang.String r1 = (java.lang.String) r1
            r36 = r1
            java.lang.Object r1 = r6.L$0
            r0 = r1
            com.phisher98.AWSStream r0 = (com.phisher98.AWSStream) r0
            kotlin.ResultKt.throwOnFailure(r2)
            r1 = r36
            r29 = r37
            r26 = r2
            r18 = r15
            r32 = r17
            r15 = r38
            r2 = r11
            r17 = r14
            r14 = r16
            r11 = r39
            r16 = r3
            r3 = r26
            goto L40f
        L9f:
            r1 = 0
            java.lang.Object r4 = r6.L$12
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r10 = r6.L$11
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r6.L$10
            com.phisher98.AWSStream$Response r11 = (com.phisher98.AWSStream.Response) r11
            java.lang.Object r12 = r6.L$9
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Object r13 = r6.L$8
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Object r14 = r6.L$7
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r6.L$6
            org.jsoup.nodes.Document r15 = (org.jsoup.nodes.Document) r15
            java.lang.Object r5 = r6.L$5
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r6.L$4
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r6.L$3
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r6.L$2
            java.lang.String r9 = (java.lang.String) r9
            r20 = r1
            java.lang.Object r1 = r6.L$1
            java.lang.String r1 = (java.lang.String) r1
            r36 = r1
            java.lang.Object r1 = r6.L$0
            r0 = r1
            com.phisher98.AWSStream r0 = (com.phisher98.AWSStream) r0
            kotlin.ResultKt.throwOnFailure(r2)
            r25 = r36
            r26 = r2
            r1 = r3
            r32 = r5
            r29 = r9
            r9 = r13
            r17 = r14
            r14 = r15
            r16 = r20
            r27 = 0
            r28 = 1
            r15 = r8
            r13 = r12
            r12 = r11
            r11 = r7
            goto L33e
        Lf5:
            java.lang.Object r1 = r6.L$9
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r4 = r6.L$8
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r6.L$7
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r6.L$6
            org.jsoup.nodes.Document r7 = (org.jsoup.nodes.Document) r7
            java.lang.Object r8 = r6.L$5
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r6.L$4
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r6.L$3
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r6.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r6.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r6.L$0
            r0 = r13
            com.phisher98.AWSStream r0 = (com.phisher98.AWSStream) r0
            kotlin.ResultKt.throwOnFailure(r2)
            r26 = r2
            r13 = r5
            r14 = r7
            r32 = r8
            r15 = r10
            r29 = r11
            r25 = r12
            r27 = 0
            r28 = 1
            r10 = r1
            r1 = r3
            r12 = r4
            r11 = r9
            r2 = 2
            r3 = r26
            r9 = r0
            goto L2a1
        L13a:
            java.lang.Object r1 = r6.L$5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r6.L$4
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r6.L$3
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r7 = r6.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r6.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r6.L$0
            r0 = r9
            com.phisher98.AWSStream r0 = (com.phisher98.AWSStream) r0
            kotlin.ResultKt.throwOnFailure(r2)
            r26 = r2
            r29 = r7
            r25 = r8
            r27 = 0
            r28 = 1
            r7 = r1
            r1 = r3
            r3 = r5
            r2 = 2
            r5 = r26
            goto L1d9
        L168:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.String r1 = "/"
            r4 = r36
            r5 = 2
            r7 = 0
            java.lang.String r1 = kotlin.text.StringsKt.substringAfterLast$default(r4, r1, r7, r5, r7)
            r8 = r3
            com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r6.L$0 = r0
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r6.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r37)
            r6.L$2 = r9
            r9 = r38
            r6.L$3 = r9
            r10 = r39
            r6.L$4 = r10
            r6.L$5 = r1
            r11 = 1
            r6.label = r11
            r18 = 2
            r5 = 0
            r17 = r6
            r6 = 0
            r19 = r7
            r7 = 0
            r12 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 1
            r11 = 0
            r14 = r12
            r15 = 1
            r12 = 0
            r20 = r14
            r14 = 0
            r21 = 1
            r15 = 0
            r22 = 0
            r16 = 0
            r23 = 2
            r18 = 4094(0xffe, float:5.737E-42)
            r24 = r19
            r19 = 0
            r25 = r1
            r26 = r2
            r1 = r20
            r2 = 2
            r27 = 0
            r28 = 1
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r6 = r17
            if (r3 != r1) goto L1ce
            return r1
        L1ce:
            r29 = r37
            r4 = r39
            r5 = r3
            r7 = r25
            r25 = r36
            r3 = r38
        L1d9:
            com.lagradost.nicehttp.NiceResponse r5 = (com.lagradost.nicehttp.NiceResponse) r5
            org.jsoup.nodes.Document r5 = r5.getDocument()
            java.lang.String r8 = r0.getMainUrl()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.StringBuilder r8 = r9.append(r8)
            java.lang.String r9 = "/player/index.php?data="
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r8 = r8.append(r7)
            java.lang.String r9 = "&do=getVideo"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "x-requested-with"
            java.lang.String r10 = "XMLHttpRequest"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r9)
            kotlin.Pair[] r10 = new kotlin.Pair[r2]
            java.lang.String r11 = "hash"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r7)
            r10[r27] = r11
            java.lang.String r11 = "r"
            java.lang.String r12 = r0.getMainUrl()
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r12)
            r10[r28] = r11
            java.util.Map r10 = kotlin.collections.MapsKt.mapOf(r10)
            com.lagradost.nicehttp.Requests r11 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r6.L$0 = r0
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r6.L$1 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r29)
            r6.L$2 = r12
            r6.L$3 = r3
            r6.L$4 = r4
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$5 = r12
            r6.L$6 = r5
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r6.L$7 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$8 = r12
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r6.L$9 = r12
            r6.label = r2
            r17 = r6
            r6 = 0
            r12 = r7
            r7 = 0
            r13 = r4
            r4 = r8
            r8 = 0
            r14 = r5
            r5 = r9
            r9 = r10
            r10 = 0
            r15 = r3
            r3 = r11
            r11 = 0
            r16 = r12
            r12 = 0
            r18 = r13
            r13 = 0
            r19 = r14
            r14 = 0
            r20 = r15
            r15 = 0
            r22 = r16
            r21 = r17
            r16 = 0
            r23 = r18
            r18 = 0
            r30 = r19
            r19 = 0
            r31 = r20
            r20 = 0
            r32 = r22
            r22 = 65500(0xffdc, float:9.1785E-41)
            r33 = r23
            r23 = 0
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.post$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)
            r6 = r21
            if (r3 != r1) goto L297
            return r1
        L297:
            r13 = r4
            r12 = r5
            r10 = r9
            r14 = r30
            r15 = r31
            r11 = r33
            r9 = r0
        L2a1:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            r4 = 0
            com.lagradost.nicehttp.ResponseParser r0 = r3.getParser()     // Catch: java.lang.Exception -> L2bb
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L2bb
            java.lang.String r5 = r3.getText()     // Catch: java.lang.Exception -> L2bb
            java.lang.Class<com.phisher98.AWSStream$Response> r7 = com.phisher98.AWSStream.Response.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)     // Catch: java.lang.Exception -> L2bb
            java.lang.Object r0 = r0.parseSafe(r5, r7)     // Catch: java.lang.Exception -> L2bb
            goto L2c1
        L2bb:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
        L2c1:
            com.phisher98.AWSStream$Response r0 = (com.phisher98.AWSStream.Response) r0
            if (r0 == 0) goto L430
            java.lang.String r5 = r0.getVideoSource()
            if (r5 == 0) goto L430
            r16 = 0
            java.lang.String r3 = r9.getName()
            java.lang.String r4 = r9.getName()
            com.lagradost.cloudstream3.utils.ExtractorLinkType r7 = com.lagradost.cloudstream3.utils.ExtractorLinkType.M3U8
            com.phisher98.AWSStream$getUrl$2$1 r8 = new com.phisher98.AWSStream$getUrl$2$1
            r2 = 0
            r8.<init>(r2)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r6.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r29)
            r6.L$2 = r2
            r6.L$3 = r15
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r6.L$4 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r32)
            r6.L$5 = r2
            r6.L$6 = r14
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r6.L$7 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r6.L$8 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r6.L$9 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$10 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r6.L$11 = r2
            r6.L$12 = r11
            r2 = 3
            r6.label = r2
            r34 = r8
            r8 = r6
            r6 = r7
            r7 = r34
            java.lang.Object r2 = com.lagradost.cloudstream3.utils.ExtractorApiKt.newExtractorLink(r3, r4, r5, r6, r7, r8)
            r6 = r8
            if (r2 != r1) goto L335
            return r1
        L335:
            r4 = r12
            r12 = r0
            r0 = r9
            r9 = r4
            r4 = r11
            r17 = r13
            r13 = r10
            r10 = r5
        L33e:
            r4.invoke(r2)
            java.lang.String r2 = "script:containsData(function(p,a,c,k,e,d))"
            org.jsoup.nodes.Element r2 = r14.selectFirst(r2)
            if (r2 == 0) goto L34e
            java.lang.String r2 = r2.data()
            goto L34f
        L34e:
            r2 = 0
        L34f:
            if (r2 != 0) goto L353
            java.lang.String r2 = ""
        L353:
            com.lagradost.cloudstream3.utils.JsUnpacker r3 = new com.lagradost.cloudstream3.utils.JsUnpacker
            r3.<init>(r2)
            java.lang.String r3 = r3.unpack()
            if (r3 == 0) goto L426
            r19 = r3
            r20 = 0
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = "\"kind\":\\s*\"captions\"\\s*,\\s*\"file\":\\s*\"(https.*?\\.srt)"
            r3.<init>(r4)
            r4 = r19
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 0
            r7 = 2
            r8 = 0
            kotlin.text.MatchResult r3 = kotlin.text.Regex.find$default(r3, r4, r5, r7, r8)
            if (r3 == 0) goto L423
        L37a:
            java.util.List r3 = r3.getGroupValues()
            if (r3 == 0) goto L423
        L381:
            r4 = 1
            java.lang.Object r3 = r3.get(r4)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L423
        L38d:
            r18 = 0
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r25)
            r6.L$1 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r29)
            r6.L$2 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r6.L$3 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r6.L$4 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r32)
            r6.L$5 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r6.L$6 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r6.L$7 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r6.L$8 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r6.L$9 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r6.L$10 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r6.L$11 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r6.L$12 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
            r6.L$13 = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r6.L$14 = r3
            r6.L$15 = r15
            r3 = 4
            r6.label = r3
            java.lang.String r3 = "English"
            r5 = 0
            r7 = 4
            r8 = 0
            java.lang.Object r3 = com.lagradost.cloudstream3.MainAPIKt.newSubtitleFile$default(r3, r4, r5, r6, r7, r8)
            if (r3 != r1) goto L3fe
            return r1
        L3fe:
            r1 = r10
            r10 = r2
            r2 = r1
            r8 = r4
            r7 = r15
            r5 = r18
            r4 = r20
            r1 = r25
            r18 = r17
            r17 = r9
            r9 = r19
        L40f:
            r7.invoke(r3)
            r19 = r10
            r10 = r2
            r2 = r19
            r25 = r1
            r20 = r4
            r19 = r9
            r9 = r17
            r17 = r18
            goto L424
        L423:
        L424:
        L426:
            r34 = r9
            r9 = r0
            r0 = r12
            r12 = r34
            r10 = r13
            r13 = r17
        L430:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
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
}
