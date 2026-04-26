package com.horis.cloudstreamplugins.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Tracks.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/Tracks;", "", "kind", "", "file", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Ljava/lang/String;", "getFile", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Tracks {

    @Nullable
    private final String file;

    @Nullable
    private final String kind;

    @Nullable
    private final String label;

    public static /* synthetic */ Tracks copy$default(Tracks tracks, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tracks.kind;
        }
        if ((i & 2) != 0) {
            str2 = tracks.file;
        }
        if ((i & 4) != 0) {
            str3 = tracks.label;
        }
        return tracks.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final Tracks copy(@Nullable String kind, @Nullable String file, @Nullable String label) {
        return new Tracks(kind, file, label);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tracks)) {
            return false;
        }
        Tracks tracks = (Tracks) other;
        return Intrinsics.areEqual(this.kind, tracks.kind) && Intrinsics.areEqual(this.file, tracks.file) && Intrinsics.areEqual(this.label, tracks.label);
    }

    public int hashCode() {
        return ((((this.kind == null ? 0 : this.kind.hashCode()) * 31) + (this.file == null ? 0 : this.file.hashCode())) * 31) + (this.label != null ? this.label.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Tracks(kind=" + this.kind + ", file=" + this.file + ", label=" + this.label + ')';
    }

    public Tracks(@Nullable String kind, @Nullable String file, @Nullable String label) {
        this.kind = kind;
        this.file = file;
        this.label = label;
    }

    @Nullable
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }
}
