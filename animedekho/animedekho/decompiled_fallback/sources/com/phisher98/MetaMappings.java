package com.phisher98;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/phisher98/MetaMappings;", "", "mal_id", "", "anilist_id", "themoviedb_id", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMal_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnilist_id", "getThemoviedb_id", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/MetaMappings;", "equals", "", "other", "hashCode", "toString", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MetaMappings {

    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer anilist_id;

    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer mal_id;

    @org.jetbrains.annotations.Nullable
    private final java.lang.Integer themoviedb_id;

    public MetaMappings() {
            r6 = this;
            r4 = 7
            r5 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
    }

    public MetaMappings(@org.jetbrains.annotations.Nullable java.lang.Integer r1, @org.jetbrains.annotations.Nullable java.lang.Integer r2, @org.jetbrains.annotations.Nullable java.lang.Integer r3) {
            r0 = this;
            r0.<init>()
            r0.mal_id = r1
            r0.anilist_id = r2
            r0.themoviedb_id = r3
            return
    }

    public /* synthetic */ MetaMappings(java.lang.Integer r2, java.lang.Integer r3, java.lang.Integer r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
            r1 = this;
            r6 = r5 & 1
            r0 = 0
            if (r6 == 0) goto L6
            r2 = r0
        L6:
            r6 = r5 & 2
            if (r6 == 0) goto Lb
            r3 = r0
        Lb:
            r5 = r5 & 4
            if (r5 == 0) goto L10
            r4 = r0
        L10:
            r1.<init>(r2, r3, r4)
            return
    }

    public static /* synthetic */ com.phisher98.MetaMappings copy$default(com.phisher98.MetaMappings r0, java.lang.Integer r1, java.lang.Integer r2, java.lang.Integer r3, int r4, java.lang.Object r5) {
            r5 = r4 & 1
            if (r5 == 0) goto L6
            java.lang.Integer r1 = r0.mal_id
        L6:
            r5 = r4 & 2
            if (r5 == 0) goto Lc
            java.lang.Integer r2 = r0.anilist_id
        Lc:
            r4 = r4 & 4
            if (r4 == 0) goto L12
            java.lang.Integer r3 = r0.themoviedb_id
        L12:
            com.phisher98.MetaMappings r0 = r0.copy(r1, r2, r3)
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component1() {
            r1 = this;
            java.lang.Integer r0 = r1.mal_id
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component2() {
            r1 = this;
            java.lang.Integer r0 = r1.anilist_id
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component3() {
            r1 = this;
            java.lang.Integer r0 = r1.themoviedb_id
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final com.phisher98.MetaMappings copy(@org.jetbrains.annotations.Nullable java.lang.Integer r2, @org.jetbrains.annotations.Nullable java.lang.Integer r3, @org.jetbrains.annotations.Nullable java.lang.Integer r4) {
            r1 = this;
            com.phisher98.MetaMappings r0 = new com.phisher98.MetaMappings
            r0.<init>(r2, r3, r4)
            return r0
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.phisher98.MetaMappings
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r6
            com.phisher98.MetaMappings r1 = (com.phisher98.MetaMappings) r1
            java.lang.Integer r3 = r5.mal_id
            java.lang.Integer r4 = r1.mal_id
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L18
            return r2
        L18:
            java.lang.Integer r3 = r5.anilist_id
            java.lang.Integer r4 = r1.anilist_id
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L23
            return r2
        L23:
            java.lang.Integer r3 = r5.themoviedb_id
            java.lang.Integer r1 = r1.themoviedb_id
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 != 0) goto L2e
            return r2
        L2e:
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getAnilist_id() {
            r1 = this;
            java.lang.Integer r0 = r1.anilist_id
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getMal_id() {
            r1 = this;
            java.lang.Integer r0 = r1.mal_id
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getThemoviedb_id() {
            r1 = this;
            java.lang.Integer r0 = r1.themoviedb_id
            return r0
    }

    public int hashCode() {
            r4 = this;
            java.lang.Integer r0 = r4.mal_id
            r1 = 0
            if (r0 != 0) goto L7
            r0 = 0
            goto Ld
        L7:
            java.lang.Integer r0 = r4.mal_id
            int r0 = r0.hashCode()
        Ld:
            int r2 = r0 * 31
            java.lang.Integer r3 = r4.anilist_id
            if (r3 != 0) goto L15
            r3 = 0
            goto L1b
        L15:
            java.lang.Integer r3 = r4.anilist_id
            int r3 = r3.hashCode()
        L1b:
            int r2 = r2 + r3
            int r0 = r2 * 31
            java.lang.Integer r3 = r4.themoviedb_id
            if (r3 != 0) goto L23
            goto L29
        L23:
            java.lang.Integer r1 = r4.themoviedb_id
            int r1 = r1.hashCode()
        L29:
            int r0 = r0 + r1
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
            r5 = this;
            java.lang.Integer r0 = r5.mal_id
            java.lang.Integer r1 = r5.anilist_id
            java.lang.Integer r2 = r5.themoviedb_id
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "MetaMappings(mal_id="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = ", anilist_id="
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", themoviedb_id="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
    }
}
