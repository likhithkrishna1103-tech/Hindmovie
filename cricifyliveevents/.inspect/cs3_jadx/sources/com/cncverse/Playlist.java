package com.cncverse;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Cricify.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/cncverse/Playlist;", "", "items", "", "Lcom/cncverse/PlaylistItem;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Playlist {

    @NotNull
    private final List<PlaylistItem> items;

    /* JADX WARN: Illegal instructions before constructor call */
    public Playlist() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Playlist copy$default(Playlist playlist, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = playlist.items;
        }
        return playlist.copy(list);
    }

    @NotNull
    public final List<PlaylistItem> component1() {
        return this.items;
    }

    @NotNull
    public final Playlist copy(@NotNull List<PlaylistItem> items) {
        return new Playlist(items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Playlist) && Intrinsics.areEqual(this.items, ((Playlist) other).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    @NotNull
    public String toString() {
        return "Playlist(items=" + this.items + ')';
    }

    public Playlist(@NotNull List<PlaylistItem> list) {
        this.items = list;
    }

    public /* synthetic */ Playlist(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final List<PlaylistItem> getItems() {
        return this.items;
    }
}
