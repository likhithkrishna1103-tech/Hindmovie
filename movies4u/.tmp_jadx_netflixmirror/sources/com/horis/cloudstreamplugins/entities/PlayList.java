package com.horis.cloudstreamplugins.entities;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlayList.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/PlayList;", "Ljava/util/ArrayList;", "Lcom/horis/cloudstreamplugins/entities/PlayListItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PlayList extends ArrayList<PlayListItem> {
    public /* bridge */ boolean contains(PlayListItem p0) {
        return super.contains((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof PlayListItem) {
            return contains((PlayListItem) element);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(PlayListItem p0) {
        return super.indexOf((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof PlayListItem) {
            return indexOf((PlayListItem) element);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(PlayListItem p0) {
        return super.lastIndexOf((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof PlayListItem) {
            return lastIndexOf((PlayListItem) element);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ PlayListItem remove(int index) {
        return removeAt(index);
    }

    public /* bridge */ boolean remove(PlayListItem p0) {
        return super.remove((Object) p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object element) {
        if (element instanceof PlayListItem) {
            return remove((PlayListItem) element);
        }
        return false;
    }

    public /* bridge */ PlayListItem removeAt(int p0) {
        return (PlayListItem) super.remove(p0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
