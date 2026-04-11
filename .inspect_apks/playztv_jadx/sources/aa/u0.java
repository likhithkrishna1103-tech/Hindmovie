package aa;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends AbstractSequentialList implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f755u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final z9.f f756v;

    public u0(List list, z9.f fVar) {
        list.getClass();
        this.f755u = list;
        this.f756v = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f755u.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new s0(this, this.f755u.listIterator(i), 1);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        this.f755u.subList(i, i10).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f755u.size();
    }
}
