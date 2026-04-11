package v;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Set {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f12513v;

    public b(e eVar) {
        this.f12513v = eVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f12513v.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f12513v.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f12513v.k(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        e eVar = this.f12513v;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        try {
            if (eVar.f12542x == set.size()) {
                return eVar.k(set);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        e eVar = this.f12513v;
        int iHashCode = 0;
        for (int i = eVar.f12542x - 1; i >= 0; i--) {
            Object objF = eVar.f(i);
            iHashCode += objF == null ? 0 : objF.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f12513v.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f12513v, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f12513v;
        int iD = eVar.d(obj);
        if (iD < 0) {
            return false;
        }
        eVar.h(iD);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f12513v.l(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f12513v;
        int i = eVar.f12542x;
        for (int i10 = i - 1; i10 >= 0; i10--) {
            if (!collection.contains(eVar.f(i10))) {
                eVar.h(i10);
            }
        }
        return i != eVar.f12542x;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f12513v.f12542x;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f12513v;
        int i = eVar.f12542x;
        Object[] objArr = new Object[i];
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = eVar.f(i10);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f12513v;
        int i = eVar.f12542x;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = eVar.f(i10);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
