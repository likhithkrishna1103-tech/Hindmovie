package com.phisher98;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010\u0019\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/phisher98/MetaAnimeData;", "", "titles", "", "", "images", "", "Lcom/phisher98/MetaImage;", "episodes", "Lcom/phisher98/MetaEpisode;", "mappings", "Lcom/phisher98/MetaMappings;", "<init>", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Lcom/phisher98/MetaMappings;)V", "getTitles", "()Ljava/util/Map;", "getImages", "()Ljava/util/List;", "getEpisodes", "getMappings", "()Lcom/phisher98/MetaMappings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaAnimeData {

    @Nullable
    private final Map<String, MetaEpisode> episodes;

    @Nullable
    private final List<MetaImage> images;

    @Nullable
    private final MetaMappings mappings;

    @Nullable
    private final Map<String, String> titles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaAnimeData copy$default(MetaAnimeData metaAnimeData, Map map, List list, Map map2, MetaMappings metaMappings, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metaAnimeData.titles;
        }
        if ((i & 2) != 0) {
            list = metaAnimeData.images;
        }
        if ((i & 4) != 0) {
            map2 = metaAnimeData.episodes;
        }
        if ((i & 8) != 0) {
            metaMappings = metaAnimeData.mappings;
        }
        return metaAnimeData.copy(map, list, map2, metaMappings);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.titles;
    }

    @Nullable
    public final List<MetaImage> component2() {
        return this.images;
    }

    @Nullable
    public final Map<String, MetaEpisode> component3() {
        return this.episodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MetaMappings getMappings() {
        return this.mappings;
    }

    @NotNull
    public final MetaAnimeData copy(@Nullable Map<String, String> titles, @Nullable List<MetaImage> images, @Nullable Map<String, MetaEpisode> episodes, @Nullable MetaMappings mappings) {
        return new MetaAnimeData(titles, images, episodes, mappings);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaAnimeData)) {
            return false;
        }
        MetaAnimeData metaAnimeData = (MetaAnimeData) other;
        return Intrinsics.areEqual(this.titles, metaAnimeData.titles) && Intrinsics.areEqual(this.images, metaAnimeData.images) && Intrinsics.areEqual(this.episodes, metaAnimeData.episodes) && Intrinsics.areEqual(this.mappings, metaAnimeData.mappings);
    }

    public int hashCode() {
        return ((((((this.titles == null ? 0 : this.titles.hashCode()) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.mappings != null ? this.mappings.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaAnimeData(titles=" + this.titles + ", images=" + this.images + ", episodes=" + this.episodes + ", mappings=" + this.mappings + ")";
    }

    public MetaAnimeData(@Nullable Map<String, String> map, @Nullable List<MetaImage> list, @Nullable Map<String, MetaEpisode> map2, @Nullable MetaMappings mappings) {
        this.titles = map;
        this.images = list;
        this.episodes = map2;
        this.mappings = mappings;
    }

    public /* synthetic */ MetaAnimeData(Map map, List list, Map map2, MetaMappings metaMappings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, list, map2, (i & 8) != 0 ? null : metaMappings);
    }

    @Nullable
    public final Map<String, String> getTitles() {
        return this.titles;
    }

    @Nullable
    public final List<MetaImage> getImages() {
        return this.images;
    }

    @Nullable
    public final Map<String, MetaEpisode> getEpisodes() {
        return this.episodes;
    }

    @Nullable
    public final MetaMappings getMappings() {
        return this.mappings;
    }
}
