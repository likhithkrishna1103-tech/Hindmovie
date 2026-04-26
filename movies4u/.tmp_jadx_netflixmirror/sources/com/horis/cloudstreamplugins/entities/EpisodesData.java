package com.horis.cloudstreamplugins.entities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EpisodesData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/EpisodesData;", "", "episodes", "", "Lcom/horis/cloudstreamplugins/entities/Episode;", "nextPage", "", "nextPageSeason", "", "nextPageShow", "<init>", "(Ljava/util/List;ILjava/lang/String;I)V", "getEpisodes", "()Ljava/util/List;", "getNextPage", "()I", "getNextPageSeason", "()Ljava/lang/String;", "getNextPageShow", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EpisodesData {

    @Nullable
    private final List<Episode> episodes;
    private final int nextPage;

    @NotNull
    private final String nextPageSeason;
    private final int nextPageShow;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodesData copy$default(EpisodesData episodesData, List list, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = episodesData.episodes;
        }
        if ((i3 & 2) != 0) {
            i = episodesData.nextPage;
        }
        if ((i3 & 4) != 0) {
            str = episodesData.nextPageSeason;
        }
        if ((i3 & 8) != 0) {
            i2 = episodesData.nextPageShow;
        }
        return episodesData.copy(list, i, str, i2);
    }

    @Nullable
    public final List<Episode> component1() {
        return this.episodes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNextPage() {
        return this.nextPage;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNextPageSeason() {
        return this.nextPageSeason;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getNextPageShow() {
        return this.nextPageShow;
    }

    @NotNull
    public final EpisodesData copy(@Nullable List<Episode> episodes, int nextPage, @NotNull String nextPageSeason, int nextPageShow) {
        return new EpisodesData(episodes, nextPage, nextPageSeason, nextPageShow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodesData)) {
            return false;
        }
        EpisodesData episodesData = (EpisodesData) other;
        return Intrinsics.areEqual(this.episodes, episodesData.episodes) && this.nextPage == episodesData.nextPage && Intrinsics.areEqual(this.nextPageSeason, episodesData.nextPageSeason) && this.nextPageShow == episodesData.nextPageShow;
    }

    public int hashCode() {
        return ((((((this.episodes == null ? 0 : this.episodes.hashCode()) * 31) + this.nextPage) * 31) + this.nextPageSeason.hashCode()) * 31) + this.nextPageShow;
    }

    @NotNull
    public String toString() {
        return "EpisodesData(episodes=" + this.episodes + ", nextPage=" + this.nextPage + ", nextPageSeason=" + this.nextPageSeason + ", nextPageShow=" + this.nextPageShow + ')';
    }

    public EpisodesData(@Nullable List<Episode> list, int nextPage, @NotNull String nextPageSeason, int nextPageShow) {
        this.episodes = list;
        this.nextPage = nextPage;
        this.nextPageSeason = nextPageSeason;
        this.nextPageShow = nextPageShow;
    }

    @Nullable
    public final List<Episode> getEpisodes() {
        return this.episodes;
    }

    public final int getNextPage() {
        return this.nextPage;
    }

    @NotNull
    public final String getNextPageSeason() {
        return this.nextPageSeason;
    }

    public final int getNextPageShow() {
        return this.nextPageShow;
    }
}
