package aa;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends AbstractList implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f747u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final z9.f f748v;

    public t0(List list, z9.f fVar) {
        list.getClass();
        this.f747u = list;
        this.f748v = fVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f748v.apply(this.f747u.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f747u.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new s0(this, this.f747u.listIterator(i), 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        return this.f748v.apply(this.f747u.remove(i));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        this.f747u.subList(i, i10).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f747u.size();
    }
}
