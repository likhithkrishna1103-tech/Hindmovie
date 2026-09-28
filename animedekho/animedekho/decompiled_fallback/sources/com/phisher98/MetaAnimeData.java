package com.phisher98;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010\u0019\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/phisher98/MetaAnimeData;", "", "titles", "", "", "images", "", "Lcom/phisher98/MetaImage;", "episodes", "Lcom/phisher98/MetaEpisode;", "mappings", "Lcom/phisher98/MetaMappings;", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Lcom/phisher98/MetaMappings;)V", "getTitles", "()Ljava/util/Map;", "getImages", "()Ljava/util/List;", "getEpisodes", "getMappings", "()Lcom/phisher98/MetaMappings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MetaAnimeData {

    @org.jetbrains.annotations.Nullable
    private final java.util.Map<java.lang.String, com.phisher98.MetaEpisode> episodes;

    @org.jetbrains.annotations.Nullable
    private final java.util.List<com.phisher98.MetaImage> images;

    @org.jetbrains.annotations.Nullable
    private final com.phisher98.MetaMappings mappings;

    @org.jetbrains.annotations.Nullable
    private final java.util.Map<java.lang.String, java.lang.String> titles;

    public MetaAnimeData(@org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r1, @org.jetbrains.annotations.Nullable java.util.List<com.phisher98.MetaImage> r2, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r3, @org.jetbrains.annotations.Nullable com.phisher98.MetaMappings r4) {
            r0 = this;
            r0.<init>()
            r0.titles = r1
            r0.images = r2
            r0.episodes = r3
            r0.mappings = r4
            return
    }

    public /* synthetic */ MetaAnimeData(java.util.Map r1, java.util.List r2, java.util.Map r3, com.phisher98.MetaMappings r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto L5
            r4 = 0
        L5:
            r0.<init>(r1, r2, r3, r4)
            return
    }

    public static /* synthetic */ com.phisher98.MetaAnimeData copy$default(com.phisher98.MetaAnimeData r0, java.util.Map r1, java.util.List r2, java.util.Map r3, com.phisher98.MetaMappings r4, int r5, java.lang.Object r6) {
            r6 = r5 & 1
            if (r6 == 0) goto L6
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.titles
        L6:
            r6 = r5 & 2
            if (r6 == 0) goto Lc
            java.util.List<com.phisher98.MetaImage> r2 = r0.images
        Lc:
            r6 = r5 & 4
            if (r6 == 0) goto L12
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r3 = r0.episodes
        L12:
            r5 = r5 & 8
            if (r5 == 0) goto L18
            com.phisher98.MetaMappings r4 = r0.mappings
        L18:
            com.phisher98.MetaAnimeData r0 = r0.copy(r1, r2, r3, r4)
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.String> component1() {
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.titles
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.phisher98.MetaImage> component2() {
            r1 = this;
            java.util.List<com.phisher98.MetaImage> r0 = r1.images
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, com.phisher98.MetaEpisode> component3() {
            r1 = this;
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r0 = r1.episodes
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final com.phisher98.MetaMappings component4() {
            r1 = this;
            com.phisher98.MetaMappings r0 = r1.mappings
            return r0
    }

    @org.jetbrains.annotations.NotNull
    public final com.phisher98.MetaAnimeData copy(@org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r2, @org.jetbrains.annotations.Nullable java.util.List<com.phisher98.MetaImage> r3, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r4, @org.jetbrains.annotations.Nullable com.phisher98.MetaMappings r5) {
            r1 = this;
            com.phisher98.MetaAnimeData r0 = new com.phisher98.MetaAnimeData
            r0.<init>(r2, r3, r4, r5)
            return r0
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
            r5 = this;
            r0 = 1
            if (r5 != r6) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof com.phisher98.MetaAnimeData
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r6
            com.phisher98.MetaAnimeData r1 = (com.phisher98.MetaAnimeData) r1
            java.util.Map<java.lang.String, java.lang.String> r3 = r5.titles
            java.util.Map<java.lang.String, java.lang.String> r4 = r1.titles
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L18
            return r2
        L18:
            java.util.List<com.phisher98.MetaImage> r3 = r5.images
            java.util.List<com.phisher98.MetaImage> r4 = r1.images
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L23
            return r2
        L23:
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r3 = r5.episodes
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r4 = r1.episodes
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 != 0) goto L2e
            return r2
        L2e:
            com.phisher98.MetaMappings r3 = r5.mappings
            com.phisher98.MetaMappings r1 = r1.mappings
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
            if (r1 != 0) goto L39
            return r2
        L39:
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, com.phisher98.MetaEpisode> getEpisodes() {
            r1 = this;
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r0 = r1.episodes
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.phisher98.MetaImage> getImages() {
            r1 = this;
            java.util.List<com.phisher98.MetaImage> r0 = r1.images
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final com.phisher98.MetaMappings getMappings() {
            r1 = this;
            com.phisher98.MetaMappings r0 = r1.mappings
            return r0
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.String> getTitles() {
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.titles
            return r0
    }

    public int hashCode() {
            r4 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.titles
            r1 = 0
            if (r0 != 0) goto L7
            r0 = 0
            goto Ld
        L7:
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.titles
            int r0 = r0.hashCode()
        Ld:
            int r2 = r0 * 31
            java.util.List<com.phisher98.MetaImage> r3 = r4.images
            if (r3 != 0) goto L15
            r3 = 0
            goto L1b
        L15:
            java.util.List<com.phisher98.MetaImage> r3 = r4.images
            int r3 = r3.hashCode()
        L1b:
            int r2 = r2 + r3
            int r0 = r2 * 31
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r3 = r4.episodes
            if (r3 != 0) goto L24
            r3 = 0
            goto L2a
        L24:
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r3 = r4.episodes
            int r3 = r3.hashCode()
        L2a:
            int r0 = r0 + r3
            int r2 = r0 * 31
            com.phisher98.MetaMappings r3 = r4.mappings
            if (r3 != 0) goto L32
            goto L38
        L32:
            com.phisher98.MetaMappings r1 = r4.mappings
            int r1 = r1.hashCode()
        L38:
            int r2 = r2 + r1
            return r2
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
            r6 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.titles
            java.util.List<com.phisher98.MetaImage> r1 = r6.images
            java.util.Map<java.lang.String, com.phisher98.MetaEpisode> r2 = r6.episodes
            com.phisher98.MetaMappings r3 = r6.mappings
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "MetaAnimeData(titles="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r4 = ", images="
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ", episodes="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r1 = ", mappings="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
    }
}
