package com.phisher98;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Media;", "", "url", "", "poster", "mediaType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/Media;", "equals", "", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Media {

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

    public static /* synthetic */ com.phisher98.Media copy$default(com.phisher98.Media r0, java.lang.String r1, java.lang.String r2, java.lang.Integer r3, int r4, java.lang.Object r5) {
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
            com.phisher98.Media r0 = r0.copy(r1, r2, r3)
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
    public final com.phisher98.Media copy(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.String r3, @org.jetbrains.annotations.Nullable java.lang.Integer r4) {
            r1 = this;
            com.phisher98.Media r0 = new com.phisher98.Media
            r0.<init>(r2, r3, r4)
            return r0
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.phisher98.Media
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r6
            com.phisher98.Media r1 = (com.phisher98.Media) r1
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
