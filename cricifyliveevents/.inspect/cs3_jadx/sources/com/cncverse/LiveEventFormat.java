package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/LiveEventFormat;", "", "title", "", "webLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getWebLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LiveEventFormat {

    @Nullable
    private final String title;

    @Nullable
    private final String webLink;

    public static /* synthetic */ LiveEventFormat copy$default(LiveEventFormat liveEventFormat, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveEventFormat.title;
        }
        if ((i & 2) != 0) {
            str2 = liveEventFormat.webLink;
        }
        return liveEventFormat.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getWebLink() {
        return this.webLink;
    }

    @NotNull
    public final LiveEventFormat copy(@Nullable String title, @Nullable String webLink) {
        return new LiveEventFormat(title, webLink);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveEventFormat)) {
            return false;
        }
        LiveEventFormat liveEventFormat = (LiveEventFormat) other;
        return Intrinsics.areEqual(this.title, liveEventFormat.title) && Intrinsics.areEqual(this.webLink, liveEventFormat.webLink);
    }

    public int hashCode() {
        return ((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.webLink != null ? this.webLink.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveEventFormat(title=" + this.title + ", webLink=" + this.webLink + ')';
    }

    public LiveEventFormat(@Nullable String title, @Nullable String webLink) {
        this.title = title;
        this.webLink = webLink;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getWebLink() {
        return this.webLink;
    }
}
