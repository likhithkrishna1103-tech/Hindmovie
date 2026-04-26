package com.horis.cloudstreamplugins.entities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SearchData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/SearchData;", "", "head", "", "searchResult", "", "Lcom/horis/cloudstreamplugins/entities/SearchResult;", "type", "", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "getHead", "()Ljava/lang/String;", "getSearchResult", "()Ljava/util/List;", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SearchData {

    @NotNull
    private final String head;

    @NotNull
    private final List<SearchResult> searchResult;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchData copy$default(SearchData searchData, String str, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchData.head;
        }
        if ((i2 & 2) != 0) {
            list = searchData.searchResult;
        }
        if ((i2 & 4) != 0) {
            i = searchData.type;
        }
        return searchData.copy(str, list, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    @NotNull
    public final List<SearchResult> component2() {
        return this.searchResult;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final SearchData copy(@NotNull String head, @NotNull List<SearchResult> searchResult, int type) {
        return new SearchData(head, searchResult, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchData)) {
            return false;
        }
        SearchData searchData = (SearchData) other;
        return Intrinsics.areEqual(this.head, searchData.head) && Intrinsics.areEqual(this.searchResult, searchData.searchResult) && this.type == searchData.type;
    }

    public int hashCode() {
        return (((this.head.hashCode() * 31) + this.searchResult.hashCode()) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "SearchData(head=" + this.head + ", searchResult=" + this.searchResult + ", type=" + this.type + ')';
    }

    public SearchData(@NotNull String head, @NotNull List<SearchResult> list, int type) {
        this.head = head;
        this.searchResult = list;
        this.type = type;
    }

    @NotNull
    public final String getHead() {
        return this.head;
    }

    @NotNull
    public final List<SearchResult> getSearchResult() {
        return this.searchResult;
    }

    public final int getType() {
        return this.type;
    }
}
