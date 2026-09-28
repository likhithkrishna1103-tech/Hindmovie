package com.phisher98;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006*"}, d2 = {"Lcom/phisher98/MetaEpisode;", "", "episode", "", "airDateUtc", "runtime", "", "image", "title", "", "overview", "rating", "finaleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/String;", "getAirDateUtc", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getTitle", "()Ljava/util/Map;", "getOverview", "getRating", "getFinaleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/MetaEpisode;", "equals", "", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MetaEpisode {

    @org.jetbrains.annotations.Nullable
    private final java.lang.String airDateUtc;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String episode;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String finaleType;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String image;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String overview;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String rating;

    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer runtime;

    @org.jetbrains.annotations.Nullable
    private final java.util.Map<java.lang.String, java.lang.String> title;

    public MetaEpisode(@org.jetbrains.annotations.Nullable java.lang.String r1, @org.jetbrains.annotations.Nullable java.lang.String r2, @org.jetbrains.annotations.Nullable java.lang.Integer r3, @org.jetbrains.annotations.Nullable java.lang.String r4, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
            r0 = this;
            r0.<init>()
            r0.episode = r1
            r0.airDateUtc = r2
            r0.runtime = r3
            r0.image = r4
            r0.title = r5
            r0.overview = r6
            r0.rating = r7
            r0.finaleType = r8
            return
    }

    public static /* synthetic */ com.phisher98.MetaEpisode copy$default(com.phisher98.MetaEpisode r0, java.lang.String r1, java.lang.String r2, java.lang.Integer r3, java.lang.String r4, java.util.Map r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, java.lang.Object r10) {
            r10 = r9 & 1
            if (r10 == 0) goto L6
            java.lang.String r1 = r0.episode
        L6:
            r10 = r9 & 2
            if (r10 == 0) goto Lc
            java.lang.String r2 = r0.airDateUtc
        Lc:
            r10 = r9 & 4
            if (r10 == 0) goto L12
            java.lang.Integer r3 = r0.runtime
        L12:
            r10 = r9 & 8
            if (r10 == 0) goto L18
            java.lang.String r4 = r0.image
        L18:
            r10 = r9 & 16
            if (r10 == 0) goto L1e
            java.util.Map<java.lang.String, java.lang.String> r5 = r0.title
        L1e:
            r10 = r9 & 32
            if (r10 == 0) goto L24
            java.lang.String r6 = r0.overview
        L24:
            r10 = r9 & 64
            if (r10 == 0) goto L2a
            java.lang.String r7 = r0.rating
        L2a:
            r9 = r9 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L30
            java.lang.String r8 = r0.finaleType
        L30:
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            r2 = r0
            com.phisher98.MetaEpisode r0 = r2.copy(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
            r1 = this;
            java.lang.String r0 = r1.episode
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
            r1 = this;
            java.lang.String r0 = r1.airDateUtc
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component3() {
            r1 = this;
            java.lang.Integer r0 = r1.runtime
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
            r1 = this;
            java.lang.String r0 = r1.image
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.String> component5() {
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.title
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
            r1 = this;
            java.lang.String r0 = r1.overview
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
            r1 = this;
            java.lang.String r0 = r1.rating
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
            r1 = this;
            java.lang.String r0 = r1.finaleType
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final com.phisher98.MetaEpisode copy(@org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.Nullable java.lang.String r11, @org.jetbrains.annotations.Nullable java.lang.Integer r12, @org.jetbrains.annotations.Nullable java.lang.String r13, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r14, @org.jetbrains.annotations.Nullable java.lang.String r15, @org.jetbrains.annotations.Nullable java.lang.String r16, @org.jetbrains.annotations.Nullable java.lang.String r17) {
            r9 = this;
            com.phisher98.MetaEpisode r0 = new com.phisher98.MetaEpisode
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r0
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.phisher98.MetaEpisode
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r6
            com.phisher98.MetaEpisode r1 = (com.phisher98.MetaEpisode) r1
            java.lang.String r3 = r5.episode
            java.lang.String r4 = r1.episode
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L18
            return r2
        L18:
            java.lang.String r3 = r5.airDateUtc
            java.lang.String r4 = r1.airDateUtc
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L23
            return r2
        L23:
            java.lang.Integer r3 = r5.runtime
            java.lang.Integer r4 = r1.runtime
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L2e
            return r2
        L2e:
            java.lang.String r3 = r5.image
            java.lang.String r4 = r1.image
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L39
            return r2
        L39:
            java.util.Map<java.lang.String, java.lang.String> r3 = r5.title
            java.util.Map<java.lang.String, java.lang.String> r4 = r1.title
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L44
            return r2
        L44:
            java.lang.String r3 = r5.overview
            java.lang.String r4 = r1.overview
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L4f
            return r2
        L4f:
            java.lang.String r3 = r5.rating
            java.lang.String r4 = r1.rating
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L5a
            return r2
        L5a:
            java.lang.String r3 = r5.finaleType
            java.lang.String r1 = r1.finaleType
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 != 0) goto L65
            return r2
        L65:
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAirDateUtc() {
            r1 = this;
            java.lang.String r0 = r1.airDateUtc
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEpisode() {
            r1 = this;
            java.lang.String r0 = r1.episode
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFinaleType() {
            r1 = this;
            java.lang.String r0 = r1.finaleType
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getImage() {
            r1 = this;
            java.lang.String r0 = r1.image
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOverview() {
            r1 = this;
            java.lang.String r0 = r1.overview
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRating() {
            r1 = this;
            java.lang.String r0 = r1.rating
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getRuntime() {
            r1 = this;
            java.lang.Integer r0 = r1.runtime
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.String> getTitle() {
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.title
            return r0
    }

    public int hashCode() {
            r4 = this;
            java.lang.String r0 = r4.episode
            r1 = 0
            if (r0 != 0) goto L7
            r0 = 0
            goto Ld
        L7:
            java.lang.String r0 = r4.episode
            int r0 = r0.hashCode()
        Ld:
            int r2 = r0 * 31
            java.lang.String r3 = r4.airDateUtc
            if (r3 != 0) goto L15
            r3 = 0
            goto L1b
        L15:
            java.lang.String r3 = r4.airDateUtc
            int r3 = r3.hashCode()
        L1b:
            int r2 = r2 + r3
            int r0 = r2 * 31
            java.lang.Integer r3 = r4.runtime
            if (r3 != 0) goto L24
            r3 = 0
            goto L2a
        L24:
            java.lang.Integer r3 = r4.runtime
            int r3 = r3.hashCode()
        L2a:
            int r0 = r0 + r3
            int r2 = r0 * 31
            java.lang.String r3 = r4.image
            if (r3 != 0) goto L33
            r3 = 0
            goto L39
        L33:
            java.lang.String r3 = r4.image
            int r3 = r3.hashCode()
        L39:
            int r2 = r2 + r3
            int r0 = r2 * 31
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.title
            if (r3 != 0) goto L42
            r3 = 0
            goto L48
        L42:
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.title
            int r3 = r3.hashCode()
        L48:
            int r0 = r0 + r3
            int r2 = r0 * 31
            java.lang.String r3 = r4.overview
            if (r3 != 0) goto L51
            r3 = 0
            goto L57
        L51:
            java.lang.String r3 = r4.overview
            int r3 = r3.hashCode()
        L57:
            int r2 = r2 + r3
            int r0 = r2 * 31
            java.lang.String r3 = r4.rating
            if (r3 != 0) goto L60
            r3 = 0
            goto L66
        L60:
            java.lang.String r3 = r4.rating
            int r3 = r3.hashCode()
        L66:
            int r0 = r0 + r3
            int r2 = r0 * 31
            java.lang.String r3 = r4.finaleType
            if (r3 != 0) goto L6e
            goto L74
        L6e:
            java.lang.String r1 = r4.finaleType
            int r1 = r1.hashCode()
        L74:
            int r2 = r2 + r1
            return r2
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
            r10 = this;
            java.lang.String r0 = r10.episode
            java.lang.String r1 = r10.airDateUtc
            java.lang.Integer r2 = r10.runtime
            java.lang.String r3 = r10.image
            java.util.Map<java.lang.String, java.lang.String> r4 = r10.title
            java.lang.String r5 = r10.overview
            java.lang.String r6 = r10.rating
            java.lang.String r7 = r10.finaleType
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "MetaEpisode(episode="
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r0 = r8.append(r0)
            java.lang.String r8 = ", airDateUtc="
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", runtime="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = ", image="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = ", title="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r1 = ", overview="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r1 = ", rating="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r1 = ", finaleType="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
    }
}
