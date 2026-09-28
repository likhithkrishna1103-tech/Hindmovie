package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimeDekhoProvider.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/MetaImage;", "", "coverType", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCoverType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MetaImage {

    @Nullable
    private final String coverType;

    @Nullable
    private final String url;

    public static /* synthetic */ MetaImage copy$default(MetaImage metaImage, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metaImage.coverType;
        }
        if ((i & 2) != 0) {
            str2 = metaImage.url;
        }
        return metaImage.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCoverType() {
        return this.coverType;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final MetaImage copy(@Nullable String coverType, @Nullable String url) {
        return new MetaImage(coverType, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaImage)) {
            return false;
        }
        MetaImage metaImage = (MetaImage) other;
        return Intrinsics.areEqual(this.coverType, metaImage.coverType) && Intrinsics.areEqual(this.url, metaImage.url);
    }

    public int hashCode() {
        return ((this.coverType == null ? 0 : this.coverType.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MetaImage(coverType=" + this.coverType + ", url=" + this.url + ")";
    }

    public MetaImage(@Nullable String coverType, @Nullable String url) {
        this.coverType = coverType;
        this.url = url;
    }

    @Nullable
    public final String getCoverType() {
        return this.coverType;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
