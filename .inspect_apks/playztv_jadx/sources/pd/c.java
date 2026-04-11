package pd;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends od.d implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final c f10346x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object[] f10347u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10348v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10349w;

    static {
        c cVar = new c(0);
        cVar.f10349w = true;
        f10346x = cVar;
    }

    public c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f10347u = new Object[i];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        i();
        int i = this.f10348v;
        ((AbstractList) this).modCount++;
        j(i, 1);
        this.f10347u[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        be.h.e(collection, "elements");
        i();
        int size = collection.size();
        f(this.f10348v, collection, size);
        return size > 0;
    }

    @Override // od.d
    public final int b() {
        return this.f10348v;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        i();
        n(0, this.f10348v);
    }

    @Override // od.d
    public final Object d(int i) {
        i();
        int i10 = this.f10348v;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return l(i);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f10347u;
            int i = this.f10348v;
            if (i == list.size()) {
                for (int i10 = 0; i10 < i; i10++) {
                    if (be.h.a(objArr[i10], list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        j(i, i10);
        Iterator it = collection.iterator();
        for (int i11 = 0; i11 < i10; i11++) {
            this.f10347u[i + i11] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i10 = this.f10348v;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return this.f10347u[i];
    }

    public final void h(int i, Object obj) {
        ((AbstractList) this).modCount++;
        j(i, 1);
        this.f10347u[i] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f10347u;
        int i = this.f10348v;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i() {
        if (this.f10349w) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.f10348v; i++) {
            if (be.h.a(this.f10347u[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f10348v == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, int i10) {
        int i11 = this.f10348v + i10;
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f10347u;
        if (i11 > objArr.length) {
            int length = objArr.length;
            int i12 = length + (length >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            if (i12 - 2147483639 > 0) {
                i12 = i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i12);
            be.h.d(objArrCopyOf, "copyOf(...)");
            this.f10347u = objArrCopyOf;
        }
        Object[] objArr2 = this.f10347u;
        od.h.T(i + i10, i, this.f10348v, objArr2, objArr2);
        this.f10348v += i10;
    }

    public final Object l(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f10347u;
        Object obj = objArr[i];
        od.h.T(i, i + 1, this.f10348v, objArr, objArr);
        Object[] objArr2 = this.f10347u;
        int i10 = this.f10348v - 1;
        be.h.e(objArr2, "<this>");
        objArr2[i10] = null;
        this.f10348v--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.f10348v - 1; i >= 0; i--) {
            if (be.h.a(this.f10347u[i], obj)) {
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
        Object[] objArr = this.f10347u;
        od.h.T(i, i + i10, this.f10348v, objArr, objArr);
        Object[] objArr2 = this.f10347u;
        int i11 = this.f10348v;
        i5.a.I(objArr2, i11 - i10, i11);
        this.f10348v -= i10;
    }

    public final int r(int i, int i10, Collection collection, boolean z2) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i + i11;
            if (collection.contains(this.f10347u[i13]) == z2) {
                Object[] objArr = this.f10347u;
                i11++;
                objArr[i12 + i] = objArr[i13];
                i12++;
            } else {
                i11++;
            }
        }
        int i14 = i10 - i12;
        Object[] objArr2 = this.f10347u;
        od.h.T(i + i12, i10 + i, this.f10348v, objArr2, objArr2);
        Object[] objArr3 = this.f10347u;
        int i15 = this.f10348v;
        i5.a.I(objArr3, i15 - i14, i15);
        if (i14 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f10348v -= i14;
        return i14;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
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
        i();
        return r(0, this.f10348v, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        be.h.e(collection, "elements");
        i();
        return r(0, this.f10348v, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        i();
        int i10 = this.f10348v;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        Object[] objArr = this.f10347u;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i10) {
        z7.a.f(i, i10, this.f10348v);
        return new b(this.f10347u, i, i10 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        be.h.e(objArr, "array");
        int length = objArr.length;
        int i = this.f10348v;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f10347u, 0, i, objArr.getClass());
            be.h.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        od.h.T(0, 0, i, this.f10347u, objArr);
        int i10 = this.f10348v;
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return i5.a.a(this.f10347u, 0, this.f10348v, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i10 = this.f10348v;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        return new a(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        be.h.e(collection, "elements");
        i();
        int i10 = this.f10348v;
        if (i >= 0 && i <= i10) {
            int size = collection.size();
            f(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        i();
        int i10 = this.f10348v;
        if (i >= 0 && i <= i10) {
            ((AbstractList) this).modCount++;
            j(i, 1);
            this.f10347u[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return od.h.V(this.f10347u, 0, this.f10348v);
    }
}
