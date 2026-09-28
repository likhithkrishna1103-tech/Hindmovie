package com.phisher98;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006*"}, d2 = {"Lcom/phisher98/MetaEpisode;", "", "episode", "", "airDateUtc", "runtime", "", "image", "title", "", "overview", "rating", "finaleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/String;", "getAirDateUtc", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImage", "getTitle", "()Ljava/util/Map;", "getOverview", "getRating", "getFinaleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/MetaEpisode;", "equals", "", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaEpisode {

    @Nullable
    private final String airDateUtc;

    @Nullable
    private final String episode;

    @Nullable
    private final String finaleType;

    @Nullable
    private final String image;

    @Nullable
    private final String overview;

    @Nullable
    private final String rating;

    @Nullable
    private final Integer runtime;

    @Nullable
    private final Map<String, String> title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetaEpisode copy$default(MetaEpisode metaEpisode, String str, String str2, Integer num, String str3, Map map, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaEpisode.episode;
        }
        if ((i & 2) != 0) {
            str2 = metaEpisode.airDateUtc;
        }
        if ((i & 4) != 0) {
            num = metaEpisode.runtime;
        }
        if ((i & 8) != 0) {
            str3 = metaEpisode.image;
        }
        if ((i & 16) != 0) {
            map = metaEpisode.title;
        }
        if ((i & 32) != 0) {
            str4 = metaEpisode.overview;
        }
        if ((i & 64) != 0) {
            str5 = metaEpisode.rating;
        }
        if ((i & 128) != 0) {
            str6 = metaEpisode.finaleType;
        }
        String str7 = str5;
        String str8 = str6;
        Map map2 = map;
        String str9 = str4;
        return metaEpisode.copy(str, str2, num, str3, map2, str9, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAirDateUtc() {
        return this.airDateUtc;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final Map<String, String> component5() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFinaleType() {
        return this.finaleType;
    }

    @NotNull
    public final MetaEpisode copy(@Nullable String episode, @Nullable String airDateUtc, @Nullable Integer runtime, @Nullable String image, @Nullable Map<String, String> title, @Nullable String overview, @Nullable String rating, @Nullable String finaleType) {
        return new MetaEpisode(episode, airDateUtc, runtime, image, title, overview, rating, finaleType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaEpisode)) {
            return false;
        }
        MetaEpisode metaEpisode = (MetaEpisode) other;
        return Intrinsics.areEqual(this.episode, metaEpisode.episode) && Intrinsics.areEqual(this.airDateUtc, metaEpisode.airDateUtc) && Intrinsics.areEqual(this.runtime, metaEpisode.runtime) && Intrinsics.areEqual(this.image, metaEpisode.image) && Intrinsics.areEqual(this.title, metaEpisode.title) && Intrinsics.areEqual(this.overview, metaEpisode.overview) && Intrinsics.areEqual(this.rating, metaEpisode.rating) && Intrinsics.areEqual(this.finaleType, metaEpisode.finaleType);
    }

    public int hashCode() {
        return ((((((((((((((this.episode == null ? 0 : this.episode.hashCode()) * 31) + (this.airDateUtc == null ? 0 : this.airDateUtc.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.finaleType != null ? this.finaleType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaEpisode(episode=" + this.episode + ", airDateUtc=" + this.airDateUtc + ", runtime=" + this.runtime + ", image=" + this.image + ", title=" + this.title + ", overview=" + this.overview + ", rating=" + this.rating + ", finaleType=" + this.finaleType + ")";
    }

    public MetaEpisode(@Nullable String episode, @Nullable String airDateUtc, @Nullable Integer runtime, @Nullable String image, @Nullable Map<String, String> map, @Nullable String overview, @Nullable String rating, @Nullable String finaleType) {
        this.episode = episode;
        this.airDateUtc = airDateUtc;
        this.runtime = runtime;
        this.image = image;
        this.title = map;
        this.overview = overview;
        this.rating = rating;
        this.finaleType = finaleType;
    }

    @Nullable
    public final String getEpisode() {
        return this.episode;
    }

    @Nullable
    public final String getAirDateUtc() {
        return this.airDateUtc;
    }

    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final Map<String, String> getTitle() {
        return this.title;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getRating() {
        return this.rating;
    }

    @Nullable
    public final String getFinaleType() {
        return this.finaleType;
    }
}
