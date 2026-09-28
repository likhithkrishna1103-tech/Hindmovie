package com.phisher98;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/TmdbSeasonResponse;", "", "episodes", "", "Lcom/phisher98/TmdbEpisode;", "<init>", "(Ljava/util/List;)V", "getEpisodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TmdbSeasonResponse {

    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.phisher98.TmdbEpisode> episodes;

    public TmdbSeasonResponse(@org.jetbrains.annotations.Nullable java.util.List<com.phisher98.TmdbEpisode> r1) {
            r0 = this;
            r0.<init>()
            r0.episodes = r1
            return
    }

    public static /* synthetic */ com.phisher98.TmdbSeasonResponse copy$default(com.phisher98.TmdbSeasonResponse r0, java.util.List r1, int r2, java.lang.Object r3) {
            r2 = r2 & 1
            if (r2 == 0) goto L6
            java.util.List<com.phisher98.TmdbEpisode> r1 = r0.episodes
        L6:
            com.phisher98.TmdbSeasonResponse r0 = r0.copy(r1)
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.phisher98.TmdbEpisode> component1() {
            r1 = this;
            java.util.List<com.phisher98.TmdbEpisode> r0 = r1.episodes
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final com.phisher98.TmdbSeasonResponse copy(@org.jetbrains.annotations.Nullable java.util.List<com.phisher98.TmdbEpisode> r2) {
            r1 = this;
            com.phisher98.TmdbSeasonResponse r0 = new com.phisher98.TmdbSeasonResponse
            r0.<init>(r2)
            return r0
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            boolean r1 = r5 instanceof com.phisher98.TmdbSeasonResponse
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r5
            com.phisher98.TmdbSeasonResponse r1 = (com.phisher98.TmdbSeasonResponse) r1
            java.util.List<com.phisher98.TmdbEpisode> r3 = r4.episodes
            java.util.List<com.phisher98.TmdbEpisode> r1 = r1.episodes
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 != 0) goto L18
            return r2
        L18:
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.phisher98.TmdbEpisode> getEpisodes() {
            r1 = this;
            java.util.List<com.phisher98.TmdbEpisode> r0 = r1.episodes
            return r0
    }

    public int hashCode() {
            r1 = this;
            java.util.List<com.phisher98.TmdbEpisode> r0 = r1.episodes
            if (r0 != 0) goto L6
            r0 = 0
            goto Lc
        L6:
            java.util.List<com.phisher98.TmdbEpisode> r0 = r1.episodes
            int r0 = r0.hashCode()
        Lc:
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
            r3 = this;
            java.util.List<com.phisher98.TmdbEpisode> r0 = r3.episodes
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "TmdbSeasonResponse(episodes="
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
    }
}
