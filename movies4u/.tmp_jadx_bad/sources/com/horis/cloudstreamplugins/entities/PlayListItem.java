package com.horis.cloudstreamplugins.entities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\bHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/PlayListItem;", "", "sources", "", "Lcom/horis/cloudstreamplugins/entities/Source;", "tracks", "Lcom/horis/cloudstreamplugins/entities/Tracks;", "title", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getSources", "()Ljava/util/List;", "getTracks", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PlayListItem {

    @NotNull
    private final List<Source> sources;

    @NotNull
    private final String title;

    @Nullable
    private final List<Tracks> tracks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayListItem copy$default(PlayListItem playListItem, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = playListItem.sources;
        }
        if ((i & 2) != 0) {
            list2 = playListItem.tracks;
        }
        if ((i & 4) != 0) {
            str = playListItem.title;
        }
        return playListItem.copy(list, list2, str);
    }

    @NotNull
    public final List<Source> component1() {
        return this.sources;
    }

    @Nullable
    public final List<Tracks> component2() {
        return this.tracks;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final PlayListItem copy(@NotNull List<Source> sources, @Nullable List<Tracks> tracks, @NotNull String title) {
        return new PlayListItem(sources, tracks, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayListItem)) {
            return false;
        }
        PlayListItem playListItem = (PlayListItem) other;
        return Intrinsics.areEqual(this.sources, playListItem.sources) && Intrinsics.areEqual(this.tracks, playListItem.tracks) && Intrinsics.areEqual(this.title, playListItem.title);
    }

    public int hashCode() {
        return (((this.sources.hashCode() * 31) + (this.tracks == null ? 0 : this.tracks.hashCode())) * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlayListItem(sources=" + this.sources + ", tracks=" + this.tracks + ", title=" + this.title + ')';
    }

    public PlayListItem(@NotNull List<Source> list, @Nullable List<Tracks> list2, @NotNull String title) {
        this.sources = list;
        this.tracks = list2;
        this.title = title;
    }

    @NotNull
    public final List<Source> getSources() {
        return this.sources;
    }

    @Nullable
    public final List<Tracks> getTracks() {
        return this.tracks;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
