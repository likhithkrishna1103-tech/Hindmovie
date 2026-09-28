package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/phisher98/Abyass;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AbyssResponse", "Result", "AbyssSource", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@kotlin.jvm.internal.SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/phisher98/Abyass\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,448:1\n73#2,5:449\n777#3:454\n873#3,2:455\n2068#3,2:457\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/phisher98/Abyass\n*L\n407#1:449,5\n410#1:454\n410#1:455,2\n411#1:457,2\n*E\n"})
public class Abyass extends com.lagradost.cloudstream3.utils.ExtractorApi {

    @org.jetbrains.annotations.NotNull
    private java.lang.String mainUrl;

    @org.jetbrains.annotations.NotNull
    private java.lang.String name;
    private final boolean requiresReferer;

    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/Abyass$AbyssResponse;", "", "status", "", "result", "Lcom/phisher98/Abyass$Result;", "<init>", "(JLcom/phisher98/Abyass$Result;)V", "getStatus", "()J", "getResult", "()Lcom/phisher98/Abyass$Result;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AbyssResponse {

        @org.jetbrains.annotations.NotNull
        private final com.phisher98.Abyass.Result result;
        private final long status;

        public AbyssResponse(long r1, @org.jetbrains.annotations.NotNull com.phisher98.Abyass.Result r3) {
                r0 = this;
                r0.<init>()
                r0.status = r1
                r0.result = r3
                return
        }

        public static /* synthetic */ com.phisher98.Abyass.AbyssResponse copy$default(com.phisher98.Abyass.AbyssResponse r0, long r1, com.phisher98.Abyass.Result r3, int r4, java.lang.Object r5) {
                r5 = r4 & 1
                if (r5 == 0) goto L6
                long r1 = r0.status
            L6:
                r4 = r4 & 2
                if (r4 == 0) goto Lc
                com.phisher98.Abyass$Result r3 = r0.result
            Lc:
                com.phisher98.Abyass$AbyssResponse r0 = r0.copy(r1, r3)
                return r0
        }

        public final long component1() {
                r2 = this;
                long r0 = r2.status
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.Abyass.Result component2() {
                r1 = this;
                com.phisher98.Abyass$Result r0 = r1.result
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.Abyass.AbyssResponse copy(long r2, @org.jetbrains.annotations.NotNull com.phisher98.Abyass.Result r4) {
                r1 = this;
                com.phisher98.Abyass$AbyssResponse r0 = new com.phisher98.Abyass$AbyssResponse
                r0.<init>(r2, r4)
                return r0
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r9) {
                r8 = this;
                r0 = 1
                if (r8 != r9) goto L4
                return r0
            L4:
                boolean r1 = r9 instanceof com.phisher98.Abyass.AbyssResponse
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r9
                com.phisher98.Abyass$AbyssResponse r1 = (com.phisher98.Abyass.AbyssResponse) r1
                long r3 = r8.status
                long r5 = r1.status
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 == 0) goto L16
                return r2
            L16:
                com.phisher98.Abyass$Result r3 = r8.result
                com.phisher98.Abyass$Result r1 = r1.result
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
                if (r1 != 0) goto L21
                return r2
            L21:
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.Abyass.Result getResult() {
                r1 = this;
                com.phisher98.Abyass$Result r0 = r1.result
                return r0
        }

        public final long getStatus() {
                r2 = this;
                long r0 = r2.status
                return r0
        }

        public int hashCode() {
                r3 = this;
                long r0 = r3.status
                int r0 = com.phisher98.Abyass$AbyssResponse$$ExternalSyntheticBackport0.m(r0)
                int r1 = r0 * 31
                com.phisher98.Abyass$Result r2 = r3.result
                int r2 = r2.hashCode()
                int r1 = r1 + r2
                return r1
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
                r5 = this;
                long r0 = r5.status
                com.phisher98.Abyass$Result r2 = r5.result
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "AbyssResponse(status="
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.StringBuilder r0 = r3.append(r0)
                java.lang.String r1 = ", result="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.String r1 = ")"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/phisher98/Abyass$AbyssSource;", "", "url", "", "size", "", "type", "codec", "status", "", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "getSize", "()J", "getType", "getCodec", "getStatus", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AbyssSource {

        @org.jetbrains.annotations.NotNull
        private final java.lang.String codec;
        private final long size;
        private final boolean status;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String type;

        @org.jetbrains.annotations.NotNull
        private final java.lang.String url;

        public AbyssSource(@org.jetbrains.annotations.NotNull java.lang.String r1, long r2, @org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6) {
                r0 = this;
                r0.<init>()
                r0.url = r1
                r0.size = r2
                r0.type = r4
                r0.codec = r5
                r0.status = r6
                return
        }

        public static /* synthetic */ com.phisher98.Abyass.AbyssSource copy$default(com.phisher98.Abyass.AbyssSource r0, java.lang.String r1, long r2, java.lang.String r4, java.lang.String r5, boolean r6, int r7, java.lang.Object r8) {
                r8 = r7 & 1
                if (r8 == 0) goto L6
                java.lang.String r1 = r0.url
            L6:
                r8 = r7 & 2
                if (r8 == 0) goto Lc
                long r2 = r0.size
            Lc:
                r8 = r7 & 4
                if (r8 == 0) goto L12
                java.lang.String r4 = r0.type
            L12:
                r8 = r7 & 8
                if (r8 == 0) goto L18
                java.lang.String r5 = r0.codec
            L18:
                r7 = r7 & 16
                if (r7 == 0) goto L1e
                boolean r6 = r0.status
            L1e:
                r7 = r5
                r8 = r6
                r6 = r4
                r4 = r2
                r2 = r0
                r3 = r1
                com.phisher98.Abyass$AbyssSource r0 = r2.copy(r3, r4, r6, r7, r8)
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
                r1 = this;
                java.lang.String r0 = r1.url
                return r0
        }

        public final long component2() {
                r2 = this;
                long r0 = r2.size
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
                r1 = this;
                java.lang.String r0 = r1.type
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
                r1 = this;
                java.lang.String r0 = r1.codec
                return r0
        }

        public final boolean component5() {
                r1 = this;
                boolean r0 = r1.status
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.Abyass.AbyssSource copy(@org.jetbrains.annotations.NotNull java.lang.String r8, long r9, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, boolean r13) {
                r7 = this;
                com.phisher98.Abyass$AbyssSource r0 = new com.phisher98.Abyass$AbyssSource
                r1 = r8
                r2 = r9
                r4 = r11
                r5 = r12
                r6 = r13
                r0.<init>(r1, r2, r4, r5, r6)
                return r0
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r9) {
                r8 = this;
                r0 = 1
                if (r8 != r9) goto L4
                return r0
            L4:
                boolean r1 = r9 instanceof com.phisher98.Abyass.AbyssSource
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r9
                com.phisher98.Abyass$AbyssSource r1 = (com.phisher98.Abyass.AbyssSource) r1
                java.lang.String r3 = r8.url
                java.lang.String r4 = r1.url
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L18
                return r2
            L18:
                long r3 = r8.size
                long r5 = r1.size
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 == 0) goto L21
                return r2
            L21:
                java.lang.String r3 = r8.type
                java.lang.String r4 = r1.type
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L2c
                return r2
            L2c:
                java.lang.String r3 = r8.codec
                java.lang.String r4 = r1.codec
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 != 0) goto L37
                return r2
            L37:
                boolean r3 = r8.status
                boolean r1 = r1.status
                if (r3 == r1) goto L3e
                return r2
            L3e:
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCodec() {
                r1 = this;
                java.lang.String r0 = r1.codec
                return r0
        }

        public final long getSize() {
                r2 = this;
                long r0 = r2.size
                return r0
        }

        public final boolean getStatus() {
                r1 = this;
                boolean r0 = r1.status
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.lang.String getType() {
                r1 = this;
                java.lang.String r0 = r1.type
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
                long r2 = r4.size
                int r2 = com.phisher98.Abyass$AbyssSource$$ExternalSyntheticBackport0.m(r2)
                int r1 = r1 + r2
                int r0 = r1 * 31
                java.lang.String r2 = r4.type
                int r2 = r2.hashCode()
                int r0 = r0 + r2
                int r1 = r0 * 31
                java.lang.String r2 = r4.codec
                int r2 = r2.hashCode()
                int r1 = r1 + r2
                int r0 = r1 * 31
                boolean r2 = r4.status
                int r2 = com.phisher98.Abyass$AbyssSource$$ExternalSyntheticBackport1.m(r2)
                int r0 = r0 + r2
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
                r8 = this;
                java.lang.String r0 = r8.url
                long r1 = r8.size
                java.lang.String r3 = r8.type
                java.lang.String r4 = r8.codec
                boolean r5 = r8.status
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "AbyssSource(url="
                java.lang.StringBuilder r6 = r6.append(r7)
                java.lang.StringBuilder r0 = r6.append(r0)
                java.lang.String r6 = ", size="
                java.lang.StringBuilder r0 = r0.append(r6)
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = ", type="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r3)
                java.lang.String r1 = ", codec="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r4)
                java.lang.String r1 = ", status="
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r5)
                java.lang.String r1 = ")"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/Abyass$Result;", "", "sources", "", "Lcom/phisher98/Abyass$AbyssSource;", "<init>", "(Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Result {

        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.phisher98.Abyass.AbyssSource> sources;

        public Result(@org.jetbrains.annotations.NotNull java.util.List<com.phisher98.Abyass.AbyssSource> r1) {
                r0 = this;
                r0.<init>()
                r0.sources = r1
                return
        }

        public static /* synthetic */ com.phisher98.Abyass.Result copy$default(com.phisher98.Abyass.Result r0, java.util.List r1, int r2, java.lang.Object r3) {
                r2 = r2 & 1
                if (r2 == 0) goto L6
                java.util.List<com.phisher98.Abyass$AbyssSource> r1 = r0.sources
            L6:
                com.phisher98.Abyass$Result r0 = r0.copy(r1)
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.phisher98.Abyass.AbyssSource> component1() {
                r1 = this;
                java.util.List<com.phisher98.Abyass$AbyssSource> r0 = r1.sources
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final com.phisher98.Abyass.Result copy(@org.jetbrains.annotations.NotNull java.util.List<com.phisher98.Abyass.AbyssSource> r2) {
                r1 = this;
                com.phisher98.Abyass$Result r0 = new com.phisher98.Abyass$Result
                r0.<init>(r2)
                return r0
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
                r4 = this;
                r0 = 1
                if (r4 != r5) goto L4
                return r0
            L4:
                boolean r1 = r5 instanceof com.phisher98.Abyass.Result
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                r1 = r5
                com.phisher98.Abyass$Result r1 = (com.phisher98.Abyass.Result) r1
                java.util.List<com.phisher98.Abyass$AbyssSource> r3 = r4.sources
                java.util.List<com.phisher98.Abyass$AbyssSource> r1 = r1.sources
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
                if (r1 != 0) goto L18
                return r2
            L18:
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.phisher98.Abyass.AbyssSource> getSources() {
                r1 = this;
                java.util.List<com.phisher98.Abyass$AbyssSource> r0 = r1.sources
                return r0
        }

        public int hashCode() {
                r1 = this;
                java.util.List<com.phisher98.Abyass$AbyssSource> r0 = r1.sources
                int r0 = r0.hashCode()
                return r0
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
                r3 = this;
                java.util.List<com.phisher98.Abyass$AbyssSource> r0 = r3.sources
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Result(sources="
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r0 = r1.append(r0)
                java.lang.String r1 = ")"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Abyass$getUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extractor.kt */
    @kotlin.Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "com.phisher98.Abyass", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {385, 397, 414}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "headers", "$this", "url", "referer", "subtitleCallback", "callback", "headers", "document", "scripts", "encrypted", "$this", "url", "referer", "subtitleCallback", "callback", "headers", "document", "scripts", "encrypted", "decrypted", "$this$forEach$iv", "element$iv", "source"}, nl = {387, 407, 413}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13"}, v = 2)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$10;
        java.lang.Object L$11;
        java.lang.Object L$12;
        java.lang.Object L$13;
        java.lang.Object L$14;
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
        final /* synthetic */ com.phisher98.Abyass this$0;

        AnonymousClass1(com.phisher98.Abyass r1, kotlin.coroutines.Continuation<? super com.phisher98.Abyass.AnonymousClass1> r2) {
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
                com.phisher98.Abyass r1 = r7.this$0
                r5 = 0
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2 = 0
                r3 = 0
                r4 = 0
                java.lang.Object r0 = com.phisher98.Abyass.getUrl$suspendImpl(r1, r2, r3, r4, r5, r6)
                return r0
        }
    }

    public Abyass() {
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Abyass"
            r1.name = r0
            java.lang.String r0 = "https://abyssplayer.com"
            r1.mainUrl = r0
            r0 = 1
            r1.requiresReferer = r0
            return
    }

    static final java.lang.CharSequence getUrl$lambda$0(org.jsoup.nodes.Element r1) {
            java.lang.String r0 = r1.data()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            return r0
    }

    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.Abyass r31, java.lang.String r32, java.lang.String r33, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r34, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r35, kotlin.coroutines.Continuation<? super kotlin.Unit> r36) {
            r0 = r31
            r1 = r36
            boolean r2 = r1 instanceof com.phisher98.Abyass.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.phisher98.Abyass$getUrl$1 r2 = (com.phisher98.Abyass.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r3 = r2.label
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            com.phisher98.Abyass$getUrl$1 r2 = new com.phisher98.Abyass$getUrl$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r3 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            r6 = 0
            r9 = 2
            r10 = 1
            switch(r5) {
                case 0: goto Lf9;
                case 1: goto Lcb;
                case 2: goto L99;
                case 3: goto L33;
                default: goto L2b;
            }
        L2b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L33:
            r5 = 0
            r6 = 0
            java.lang.Object r9 = r2.L$14
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r2.L$13
            com.phisher98.Abyass$AbyssSource r10 = (com.phisher98.Abyass.AbyssSource) r10
            java.lang.Object r11 = r2.L$12
            java.lang.Object r12 = r2.L$11
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$10
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$9
            com.phisher98.Abyass$Result r14 = (com.phisher98.Abyass.Result) r14
            java.lang.Object r15 = r2.L$8
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r8 = r2.L$7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r2.L$6
            org.jsoup.nodes.Document r7 = (org.jsoup.nodes.Document) r7
            java.lang.Object r1 = r2.L$5
            java.util.Map r1 = (java.util.Map) r1
            r18 = r1
            java.lang.Object r1 = r2.L$4
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r35 = r1
            java.lang.Object r1 = r2.L$3
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r34 = r1
            java.lang.Object r1 = r2.L$2
            java.lang.String r1 = (java.lang.String) r1
            r33 = r1
            java.lang.Object r1 = r2.L$1
            java.lang.String r1 = (java.lang.String) r1
            r32 = r1
            java.lang.Object r1 = r2.L$0
            r0 = r1
            com.phisher98.Abyass r0 = (com.phisher98.Abyass) r0
            kotlin.ResultKt.throwOnFailure(r3)
            r1 = r0
            r21 = r3
            r22 = r5
            r17 = r11
            r16 = r13
            r19 = r14
            r20 = r15
            r5 = 3
            r13 = r32
            r14 = r35
            r0 = r36
            r11 = r10
            r15 = r12
            r12 = r33
            r10 = r34
            goto L3ce
        L99:
            java.lang.Object r1 = r2.L$8
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r2.L$7
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.L$6
            org.jsoup.nodes.Document r6 = (org.jsoup.nodes.Document) r6
            java.lang.Object r7 = r2.L$5
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r8 = r2.L$4
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r2.L$3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r2.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$0
            r0 = r12
            com.phisher98.Abyass r0 = (com.phisher98.Abyass) r0
            kotlin.ResultKt.throwOnFailure(r3)
            r30 = r0
            r17 = r2
            r24 = r3
            r2 = r1
            r1 = r4
            goto L27c
        Lcb:
            java.lang.Object r1 = r2.L$5
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r5 = r2.L$4
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r7 = r2.L$3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r2.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r11 = r2.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r2.L$0
            r0 = r12
            com.phisher98.Abyass r0 = (com.phisher98.Abyass) r0
            kotlin.ResultKt.throwOnFailure(r3)
            r6 = r1
            r24 = r3
            r1 = r4
            r28 = r7
            r27 = r8
            r26 = r11
            r3 = r0
            r4 = r2
            r7 = r24
            r0 = 0
            r2 = 2
            goto L185
        Lf9:
            kotlin.ResultKt.throwOnFailure(r3)
            r1 = 3
            kotlin.Pair[] r5 = new kotlin.Pair[r1]
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            r5[r6] = r7
            java.lang.String r7 = "Origin"
            java.lang.String r8 = "https://playhydrax.com"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            r5[r10] = r7
            java.lang.String r7 = "Referer"
            java.lang.String r8 = "https://playhydrax.com/"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
            r5[r9] = r7
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)
            r7 = r3
            com.lagradost.nicehttp.Requests r3 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r2.L$0 = r0
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r32)
            r2.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r33)
            r2.L$2 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r34)
            r2.L$3 = r8
            r8 = r35
            r2.L$4 = r8
            r2.L$5 = r5
            r2.label = r10
            r11 = 0
            r6 = 0
            r12 = r7
            r7 = 0
            r8 = 0
            r13 = 2
            r9 = 0
            r14 = 1
            r10 = 0
            r15 = 0
            r11 = 0
            r17 = r12
            r18 = 2
            r12 = 0
            r19 = 1
            r14 = 0
            r20 = 0
            r15 = 0
            r21 = 0
            r16 = 0
            r22 = 2
            r18 = 4092(0xffc, float:5.734E-42)
            r23 = 1
            r19 = 0
            r1 = r4
            r24 = r17
            r0 = 0
            r4 = r32
            r17 = r2
            r2 = 2
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19)
            r4 = r17
            if (r3 != r1) goto L179
            return r1
        L179:
            r26 = r32
            r27 = r33
            r28 = r34
            r7 = r3
            r6 = r5
            r3 = r31
            r5 = r35
        L185:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7
            org.jsoup.nodes.Document r7 = r7.getDocument()
            java.lang.String r8 = "script"
            org.jsoup.select.Elements r8 = r7.select(r8)
            r9 = r8
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.String r8 = "\n"
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            com.phisher98.Abyass$$ExternalSyntheticLambda0 r15 = new com.phisher98.Abyass$$ExternalSyntheticLambda0
            r15.<init>()
            r16 = 30
            r17 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r29 = kotlin.collections.CollectionsKt.joinToString$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            kotlin.text.Regex r8 = new kotlin.text.Regex
            java.lang.String r9 = "const\\s+datas\\s*=\\s*\"([^\"]*)\""
            r8.<init>(r9)
            r9 = r29
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10 = 0
            kotlin.text.MatchResult r0 = kotlin.text.Regex.find$default(r8, r9, r0, r2, r10)
            if (r0 == 0) goto L400
        L1bf:
            java.util.List r0 = r0.getGroupValues()
            if (r0 == 0) goto L3f7
        L1c6:
            r14 = 1
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r14)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L3ee
            com.lagradost.nicehttp.Requests r8 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            okhttp3.RequestBody$Companion r9 = okhttp3.RequestBody.Companion
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "\n        {\n            \"text\": \""
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r11 = "\"\n        }\n    "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = kotlin.text.StringsKt.trimIndent(r10)
            okhttp3.MediaType$Companion r11 = okhttp3.MediaType.Companion
            java.lang.String r12 = "application/json"
            okhttp3.MediaType r11 = r11.get(r12)
            okhttp3.RequestBody r12 = r9.create(r10, r11)
            r4.L$0 = r3
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r26)
            r4.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r27)
            r4.L$2 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r28)
            r4.L$3 = r9
            r4.L$4 = r5
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r4.L$5 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r4.L$6 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r29)
            r4.L$7 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r4.L$8 = r9
            r4.label = r2
            r17 = r4
            java.lang.String r4 = "https://enc-dec.app/api/dec-abyss"
            r2 = r5
            r5 = r6
            r6 = 0
            r9 = r7
            r7 = 0
            r10 = r3
            r3 = r8
            r8 = 0
            r11 = r9
            r9 = 0
            r13 = r10
            r10 = 0
            r14 = r11
            r11 = 0
            r15 = r13
            r13 = 0
            r16 = r14
            r14 = 0
            r18 = r15
            r15 = 0
            r19 = r16
            r21 = r17
            r16 = 0
            r20 = r18
            r18 = 0
            r22 = r19
            r19 = 0
            r23 = r20
            r20 = 0
            r25 = r22
            r22 = 65276(0xfefc, float:9.1471E-41)
            r30 = r23
            r23 = 0
            java.lang.Object r3 = com.lagradost.nicehttp.Requests.post$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)
            r17 = r21
            if (r3 != r1) goto L26f
            return r1
        L26f:
            r8 = r2
            r7 = r5
            r6 = r25
            r11 = r26
            r10 = r27
            r9 = r28
            r5 = r29
            r2 = r0
        L27c:
            com.lagradost.nicehttp.NiceResponse r3 = (com.lagradost.nicehttp.NiceResponse) r3
            r4 = 0
            com.lagradost.nicehttp.ResponseParser r0 = r3.getParser()     // Catch: java.lang.Exception -> L297
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L297
            java.lang.String r12 = r3.getText()     // Catch: java.lang.Exception -> L297
            java.lang.Class<com.phisher98.Abyass$AbyssResponse> r13 = com.phisher98.Abyass.AbyssResponse.class
            kotlin.reflect.KClass r13 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r13)     // Catch: java.lang.Exception -> L297
            java.lang.Object r0 = r0.parseSafe(r12, r13)     // Catch: java.lang.Exception -> L297
            goto L29d
        L297:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
        L29d:
            com.phisher98.Abyass$AbyssResponse r0 = (com.phisher98.Abyass.AbyssResponse) r0
            if (r0 == 0) goto L3eb
        L2a2:
            com.phisher98.Abyass$Result r0 = r0.getResult()
            if (r0 == 0) goto L3eb
            java.util.List r3 = r0.getSources()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            r13 = r3
            r14 = 0
            java.util.Iterator r15 = r13.iterator()
        L2bd:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L2db
            r31 = r0
            java.lang.Object r0 = r15.next()
            r16 = r0
            com.phisher98.Abyass$AbyssSource r16 = (com.phisher98.Abyass.AbyssSource) r16
            r18 = 0
            boolean r16 = r16.getStatus()
            if (r16 == 0) goto L2d8
            r12.add(r0)
        L2d8:
            r0 = r31
            goto L2bd
        L2db:
            r31 = r0
            r0 = r12
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r3 = 0
            java.util.Iterator r4 = r0.iterator()
            r15 = r31
            r14 = r0
            r16 = r2
            r13 = r4
            r12 = r8
            r2 = r17
            r0 = r36
            r4 = r1
            r8 = r5
            r1 = r30
            r5 = r3
            r3 = r24
        L2fb:
            boolean r17 = r13.hasNext()
            if (r17 == 0) goto L3e6
            java.lang.Object r17 = r13.next()
            r18 = r0
            r0 = r17
            com.phisher98.Abyass$AbyssSource r0 = (com.phisher98.Abyass.AbyssSource) r0
            r19 = 0
            java.lang.String r20 = r1.getName()
            r21 = r3
            java.lang.String r3 = r1.getName()
            r22 = r5
            java.lang.String r5 = r0.getCodec()
            r23 = r6
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toUpperCase(r6)
            java.lang.String r6 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r3 = r6.append(r3)
            java.lang.String r6 = " ["
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r5 = "]"
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = r0.getUrl()
            com.lagradost.cloudstream3.utils.ExtractorLinkType r6 = com.lagradost.cloudstream3.utils.ExtractorApiKt.getINFER_TYPE()
            r32 = r3
            com.phisher98.Abyass$getUrl$3$1 r3 = new com.phisher98.Abyass$getUrl$3$1
            r33 = r5
            r5 = 0
            r3.<init>(r0, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r2.L$0 = r1
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r2.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$3 = r5
            r2.L$4 = r12
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r2.L$5 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)
            r2.L$6 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$7 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r2.L$8 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r2.L$9 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r2.L$10 = r5
            r2.L$11 = r13
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r17)
            r2.L$12 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r2.L$13 = r5
            r2.L$14 = r12
            r5 = 3
            r2.label = r5
            r36 = r2
            r35 = r3
            r34 = r6
            r31 = r20
            java.lang.Object r3 = com.lagradost.cloudstream3.utils.ExtractorApiKt.newExtractorLink(r31, r32, r33, r34, r35, r36)
            if (r3 != r4) goto L3b9
            return r4
        L3b9:
            r20 = r16
            r6 = r19
            r16 = r14
            r19 = r15
            r14 = r12
            r15 = r13
            r12 = r10
            r13 = r11
            r11 = r0
            r10 = r9
            r9 = r14
            r0 = r18
            r18 = r7
            r7 = r23
        L3ce:
            r9.invoke(r3)
            r6 = r7
            r9 = r10
            r10 = r12
            r11 = r13
            r12 = r14
            r13 = r15
            r14 = r16
            r7 = r18
            r15 = r19
            r16 = r20
            r3 = r21
            r5 = r22
            goto L2fb
        L3e6:
            r18 = r0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L3eb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L3ee:
            r30 = r3
            r17 = r4
            r2 = r5
            r5 = r6
            r25 = r7
            goto L408
        L3f7:
            r30 = r3
            r17 = r4
            r2 = r5
            r5 = r6
            r25 = r7
            goto L408
        L400:
            r30 = r3
            r17 = r4
            r2 = r5
            r5 = r6
            r25 = r7
        L408:
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
