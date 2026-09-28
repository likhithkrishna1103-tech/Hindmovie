package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/phisher98/MetaMappings;", "", "mal_id", "", "anilist_id", "themoviedb_id", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMal_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnilist_id", "getThemoviedb_id", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/MetaMappings;", "equals", "", "other", "hashCode", "toString", "", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaMappings {

    @Nullable
    private final Integer anilist_id;

    @Nullable
    private final Integer mal_id;

    @Nullable
    private final Integer themoviedb_id;

    public MetaMappings() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MetaMappings copy$default(MetaMappings metaMappings, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = metaMappings.mal_id;
        }
        if ((i & 2) != 0) {
            num2 = metaMappings.anilist_id;
        }
        if ((i & 4) != 0) {
            num3 = metaMappings.themoviedb_id;
        }
        return metaMappings.copy(num, num2, num3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getMal_id() {
        return this.mal_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getAnilist_id() {
        return this.anilist_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getThemoviedb_id() {
        return this.themoviedb_id;
    }

    @NotNull
    public final MetaMappings copy(@Nullable Integer mal_id, @Nullable Integer anilist_id, @Nullable Integer themoviedb_id) {
        return new MetaMappings(mal_id, anilist_id, themoviedb_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaMappings)) {
            return false;
        }
        MetaMappings metaMappings = (MetaMappings) other;
        return Intrinsics.areEqual(this.mal_id, metaMappings.mal_id) && Intrinsics.areEqual(this.anilist_id, metaMappings.anilist_id) && Intrinsics.areEqual(this.themoviedb_id, metaMappings.themoviedb_id);
    }

    public int hashCode() {
        return ((((this.mal_id == null ? 0 : this.mal_id.hashCode()) * 31) + (this.anilist_id == null ? 0 : this.anilist_id.hashCode())) * 31) + (this.themoviedb_id != null ? this.themoviedb_id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaMappings(mal_id=" + this.mal_id + ", anilist_id=" + this.anilist_id + ", themoviedb_id=" + this.themoviedb_id + ")";
    }

    public MetaMappings(@Nullable Integer mal_id, @Nullable Integer anilist_id, @Nullable Integer themoviedb_id) {
        this.mal_id = mal_id;
        this.anilist_id = anilist_id;
        this.themoviedb_id = themoviedb_id;
    }

    public /* synthetic */ MetaMappings(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }

    @Nullable
    public final Integer getMal_id() {
        return this.mal_id;
    }

    @Nullable
    public final Integer getAnilist_id() {
        return this.anilist_id;
    }

    @Nullable
    public final Integer getThemoviedb_id() {
        return this.themoviedb_id;
    }
}
