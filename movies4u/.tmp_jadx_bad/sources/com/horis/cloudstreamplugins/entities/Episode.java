package com.horis.cloudstreamplugins.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Episode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/Episode;", "", "complate", "", "ep", "id", "s", "t", "time", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getComplate", "()Ljava/lang/String;", "getEp", "getId", "getS", "getT", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Episode {

    @NotNull
    private final String complate;

    @NotNull
    private final String ep;

    @NotNull
    private final String id;

    @NotNull
    private final String s;

    @NotNull
    private final String t;

    @NotNull
    private final String time;

    public static /* synthetic */ Episode copy$default(Episode episode, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episode.complate;
        }
        if ((i & 2) != 0) {
            str2 = episode.ep;
        }
        if ((i & 4) != 0) {
            str3 = episode.id;
        }
        if ((i & 8) != 0) {
            str4 = episode.s;
        }
        if ((i & 16) != 0) {
            str5 = episode.t;
        }
        if ((i & 32) != 0) {
            str6 = episode.time;
        }
        String str7 = str5;
        String str8 = str6;
        return episode.copy(str, str2, str3, str4, str7, str8);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getComplate() {
        return this.complate;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEp() {
        return this.ep;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getS() {
        return this.s;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getT() {
        return this.t;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final Episode copy(@NotNull String complate, @NotNull String ep, @NotNull String id, @NotNull String s, @NotNull String t, @NotNull String time) {
        return new Episode(complate, ep, id, s, t, time);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Episode)) {
            return false;
        }
        Episode episode = (Episode) other;
        return Intrinsics.areEqual(this.complate, episode.complate) && Intrinsics.areEqual(this.ep, episode.ep) && Intrinsics.areEqual(this.id, episode.id) && Intrinsics.areEqual(this.s, episode.s) && Intrinsics.areEqual(this.t, episode.t) && Intrinsics.areEqual(this.time, episode.time);
    }

    public int hashCode() {
        return (((((((((this.complate.hashCode() * 31) + this.ep.hashCode()) * 31) + this.id.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.time.hashCode();
    }

    @NotNull
    public String toString() {
        return "Episode(complate=" + this.complate + ", ep=" + this.ep + ", id=" + this.id + ", s=" + this.s + ", t=" + this.t + ", time=" + this.time + ')';
    }

    public Episode(@NotNull String complate, @NotNull String ep, @NotNull String id, @NotNull String s, @NotNull String t, @NotNull String time) {
        this.complate = complate;
        this.ep = ep;
        this.id = id;
        this.s = s;
        this.t = t;
        this.time = time;
    }

    @NotNull
    public final String getComplate() {
        return this.complate;
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
    public final String getT() {
        return this.t;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }
}
