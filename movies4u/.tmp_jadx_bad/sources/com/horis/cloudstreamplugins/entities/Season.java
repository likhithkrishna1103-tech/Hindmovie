package com.horis.cloudstreamplugins.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Season.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/Season;", "", "ep", "", "id", "s", "sele", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEp", "()Ljava/lang/String;", "getId", "getS", "getSele", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Season {

    @NotNull
    private final String ep;

    @NotNull
    private final String id;

    @NotNull
    private final String s;

    @NotNull
    private final String sele;

    public static /* synthetic */ Season copy$default(Season season, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = season.ep;
        }
        if ((i & 2) != 0) {
            str2 = season.id;
        }
        if ((i & 4) != 0) {
            str3 = season.s;
        }
        if ((i & 8) != 0) {
            str4 = season.sele;
        }
        return season.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEp() {
        return this.ep;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getS() {
        return this.s;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSele() {
        return this.sele;
    }

    @NotNull
    public final Season copy(@NotNull String ep, @NotNull String id, @NotNull String s, @NotNull String sele) {
        return new Season(ep, id, s, sele);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Season)) {
            return false;
        }
        Season season = (Season) other;
        return Intrinsics.areEqual(this.ep, season.ep) && Intrinsics.areEqual(this.id, season.id) && Intrinsics.areEqual(this.s, season.s) && Intrinsics.areEqual(this.sele, season.sele);
    }

    public int hashCode() {
        return (((((this.ep.hashCode() * 31) + this.id.hashCode()) * 31) + this.s.hashCode()) * 31) + this.sele.hashCode();
    }

    @NotNull
    public String toString() {
        return "Season(ep=" + this.ep + ", id=" + this.id + ", s=" + this.s + ", sele=" + this.sele + ')';
    }

    public Season(@NotNull String ep, @NotNull String id, @NotNull String s, @NotNull String sele) {
        this.ep = ep;
        this.id = id;
        this.s = s;
        this.sele = sele;
    }

    @NotNull
    public final String getEp() {
        return this.ep;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getS() {
        return this.s;
    }

    @NotNull
    public final String getSele() {
        return this.sele;
    }
}
