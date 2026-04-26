package com.horis.cloudstreamplugins.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PostCategory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/PostCategory;", "", "ids", "", "cate", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getIds", "()Ljava/lang/String;", "getCate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PostCategory {

    @NotNull
    private final String cate;

    @NotNull
    private final String ids;

    public static /* synthetic */ PostCategory copy$default(PostCategory postCategory, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = postCategory.ids;
        }
        if ((i & 2) != 0) {
            str2 = postCategory.cate;
        }
        return postCategory.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIds() {
        return this.ids;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCate() {
        return this.cate;
    }

    @NotNull
    public final PostCategory copy(@NotNull String ids, @NotNull String cate) {
        return new PostCategory(ids, cate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostCategory)) {
            return false;
        }
        PostCategory postCategory = (PostCategory) other;
        return Intrinsics.areEqual(this.ids, postCategory.ids) && Intrinsics.areEqual(this.cate, postCategory.cate);
    }

    public int hashCode() {
        return (this.ids.hashCode() * 31) + this.cate.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostCategory(ids=" + this.ids + ", cate=" + this.cate + ')';
    }

    public PostCategory(@NotNull String ids, @NotNull String cate) {
        this.ids = ids;
        this.cate = cate;
    }

    @NotNull
    public final String getIds() {
        return this.ids;
    }

    @NotNull
    public final String getCate() {
        return this.cate;
    }
}
