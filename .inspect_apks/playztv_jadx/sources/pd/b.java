package pd;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends od.d implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object[] f10341u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10342v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10343w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f10344x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f10345y;

    public b(Object[] objArr, int i, int i10, b bVar, c cVar) {
        be.h.e(objArr, "backing");
        be.h.e(cVar, "root");
        this.f10341u = objArr;
        this.f10342v = i;
        this.f10343w = i10;
        this.f10344x = bVar;
        this.f10345y = cVar;
        ((AbstractList) this).modCount = ((AbstractList) cVar).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        j();
        i();
        h(this.f10342v + this.f10343w, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        be.h.e(collection, "elements");
        j();
        i();
        int size = collection.size();
        f(this.f10342v + this.f10343w, collection, size);
        return size > 0;
    }

    @Override // od.d
    public final int b() {
        i();
        return this.f10343w;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        j();
        i();
        n(this.f10342v, this.f10343w);
    }

    @Override // od.d
    public final Object d(int i) {
        j();
        i();
        int i10 = this.f10343w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return l(this.f10342v + i);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        i();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f10341u;
            int i = this.f10343w;
            if (i == list.size()) {
                for (int i10 = 0; i10 < i; i10++) {
                    if (be.h.a(objArr[this.f10342v + i10], list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        c cVar = this.f10345y;
        b bVar = this.f10344x;
        if (bVar != null) {
            bVar.f(i, collection, i10);
        } else {
            c cVar2 = c.f10346x;
            cVar.f(i, collection, i10);
        }
        this.f10341u = cVar.f10347u;
        this.f10343w += i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        i();
        int i10 = this.f10343w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return this.f10341u[this.f10342v + i];
    }

    public final void h(int i, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f10345y;
        b bVar = this.f10344x;
        if (bVar != null) {
            bVar.h(i, obj);
        } else {
            c cVar2 = c.f10346x;
            cVar.h(i, obj);
        }
        this.f10341u = cVar.f10347u;
        this.f10343w++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        i();
        Object[] objArr = this.f10341u;
        int i = this.f10343w;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[this.f10342v + i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i() {
        if (((AbstractList) this.f10345y).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        i();
        for (int i = 0; i < this.f10343w; i++) {
            if (be.h.a(this.f10341u[this.f10342v + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        i();
        return this.f10343w == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j() {
        if (this.f10345y.f10349w) {
            throw new UnsupportedOperationException();
        }
    }

    public final Object l(int i) {
        Object objL;
        ((AbstractList) this).modCount++;
        b bVar = this.f10344x;
        if (bVar != null) {
            objL = bVar.l(i);
        } else {
            c cVar = c.f10346x;
            objL = this.f10345y.l(i);
        }
        this.f10343w--;
        return objL;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        i();
        for (int i = this.f10343w - 1; i >= 0; i--) {
            if (be.h.a(this.f10341u[this.f10342v + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final void n(int i, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f10344x;
        if (bVar != null) {
            bVar.n(i, i10);
        } else {
            c cVar = c.f10346x;
            this.f10345y.n(i, i10);
        }
        this.f10343w -= i10;
    }

    public final int r(int i, int i10, Collection collection, boolean z2) {
        int iR;
        b bVar = this.f10344x;
        if (bVar != null) {
            iR = bVar.r(i, i10, collection, z2);
        } else {
            c cVar = c.f10346x;
            iR = this.f10345y.r(i, i10, collection, z2);
        }
        if (iR > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f10343w -= iR;
        return iR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        j();
        i();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            d(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        be.h.e(collection, "elements");
        j();
        i();
        return r(this.f10342v, this.f10343w, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        be.h.e(collection, "elements");
        j();
        i();
        return r(this.f10342v, this.f10343w, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        j();
        i();
        int i10 = this.f10343w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        Object[] objArr = this.f10341u;
        int i11 = this.f10342v;
        Object obj2 = objArr[i11 + i];
        objArr[i11 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i10) {
        z7.a.f(i, i10, this.f10343w);
        return new b(this.f10341u, this.f10342v + i, i10 - i, this, this.f10345y);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        be.h.e(objArr, "array");
        i();
        int length = objArr.length;
        int i = this.f10343w;
        int i10 = this.f10342v;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f10341u, i10, i + i10, objArr.getClass());
            be.h.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        od.h.T(0, i10, i + i10, this.f10341u, objArr);
        int i11 = this.f10343w;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        i();
        return i5.a.a(this.f10341u, this.f10342v, this.f10343w, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        i();
        int i10 = this.f10343w;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return new a(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        j();
        i();
        int i10 = this.f10343w;
        if (i >= 0 && i <= i10) {
            h(this.f10342v + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        be.h.e(collection, "elements");
        j();
        i();
        int i10 = this.f10343w;
        if (i >= 0 && i <= i10) {
            int size = collection.size();
            f(this.f10342v + i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        i();
        Object[] objArr = this.f10341u;
        int i = this.f10343w;
        int i10 = this.f10342v;
        return od.h.V(objArr, i10, i + i10);
    }
}
