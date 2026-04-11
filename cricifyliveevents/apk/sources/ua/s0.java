package ua;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends AbstractSequentialList implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f12389v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ta.f f12390w;

    public s0(List list, ta.f fVar) {
        list.getClass();
        this.f12389v = list;
        this.f12390w = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f12389v.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new q0(this, this.f12389v.listIterator(i), 1);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        this.f12389v.subList(i, i10).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12389v.size();
    }
}
