package ua;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 extends AbstractList implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f12385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ta.f f12386w;

    public r0(List list, ta.f fVar) {
        list.getClass();
        this.f12385v = list;
        this.f12386w = fVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f12386w.apply(this.f12385v.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f12385v.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new q0(this, this.f12385v.listIterator(i), 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.f12386w.apply(this.f12385v.remove(i));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        this.f12385v.subList(i, i10).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12385v.size();
    }
}
