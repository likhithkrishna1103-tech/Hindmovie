package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Media;", "", "url", "", "poster", "mediaType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getUrl", "()Ljava/lang/String;", "getPoster", "getMediaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/Media;", "equals", "", "other", "hashCode", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Media {

    @Nullable
    private final Integer mediaType;

    @Nullable
    private final String poster;

    @NotNull
    private final String url;

    public static /* synthetic */ Media copy$default(Media media, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = media.url;
        }
        if ((i & 2) != 0) {
            str2 = media.poster;
        }
        if ((i & 4) != 0) {
            num = media.mediaType;
        }
        return media.copy(str, str2, num);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getMediaType() {
        return this.mediaType;
    }

    @NotNull
    public final Media copy(@NotNull String url, @Nullable String poster, @Nullable Integer mediaType) {
        return new Media(url, poster, mediaType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Media)) {
            return false;
        }
        Media media = (Media) other;
        return Intrinsics.areEqual(this.url, media.url) && Intrinsics.areEqual(this.poster, media.poster) && Intrinsics.areEqual(this.mediaType, media.mediaType);
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.mediaType != null ? this.mediaType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Media(url=" + this.url + ", poster=" + this.poster + ", mediaType=" + this.mediaType + ")";
    }

    public Media(@NotNull String url, @Nullable String poster, @Nullable Integer mediaType) {
        this.url = url;
        this.poster = poster;
        this.mediaType = mediaType;
    }

    public /* synthetic */ Media(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    @Nullable
    public final Integer getMediaType() {
        return this.mediaType;
    }

    @Nullable
    public final String getPoster() {
        return this.poster;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
