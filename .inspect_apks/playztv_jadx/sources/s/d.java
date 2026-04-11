package s;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Collection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ e f11620u;

    public d(e eVar) {
        this.f11620u = eVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f11620u.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f11620u.a(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f11620u.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f11620u, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f11620u;
        int iA = eVar.a(obj);
        if (iA < 0) {
            return false;
        }
        eVar.h(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f11620u;
        int i = eVar.f11635w;
        int i10 = 0;
        boolean z2 = false;
        while (i10 < i) {
            if (collection.contains(eVar.j(i10))) {
                eVar.h(i10);
                i10--;
                i--;
                z2 = true;
            }
            i10++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f11620u;
        int i = eVar.f11635w;
        int i10 = 0;
        boolean z2 = false;
        while (i10 < i) {
            if (!collection.contains(eVar.j(i10))) {
                eVar.h(i10);
                i10--;
                i--;
                z2 = true;
            }
            i10++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f11620u.f11635w;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f11620u;
        int i = eVar.f11635w;
        Object[] objArr = new Object[i];
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = eVar.j(i10);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f11620u;
        int i = eVar.f11635w;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = eVar.j(i10);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
