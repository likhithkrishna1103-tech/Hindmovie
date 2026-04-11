package td;

import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.z3;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends sd.e implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c f11998y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f11999v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12000w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12001x;

    static {
        c cVar = new c(0);
        cVar.f12001x = true;
        f11998y = cVar;
    }

    public c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f11999v = new Object[i];
    }

    @Override // sd.e
    public final int a() {
        return this.f12000w;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        int i = this.f12000w;
        ((AbstractList) this).modCount++;
        h(i, 1);
        this.f11999v[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ge.i.e(collection, "elements");
        g();
        int size = collection.size();
        d(this.f12000w, collection, size);
        return size > 0;
    }

    @Override // sd.e
    public final Object b(int i) {
        g();
        int i10 = this.f12000w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return i(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        j(0, this.f12000w);
    }

    public final void d(int i, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        h(i, i10);
        Iterator it = collection.iterator();
        for (int i11 = 0; i11 < i10; i11++) {
            this.f11999v[i + i11] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f11999v;
            int i = this.f12000w;
            if (i == list.size()) {
                for (int i10 = 0; i10 < i; i10++) {
                    if (ge.i.a(objArr[i10], list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, Object obj) {
        ((AbstractList) this).modCount++;
        h(i, 1);
        this.f11999v[i] = obj;
    }

    public final void g() {
        if (this.f12001x) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i10 = this.f12000w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return this.f11999v[i];
    }

    public final void h(int i, int i10) {
        int i11 = this.f12000w + i10;
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f11999v;
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
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f11999v = objArrCopyOf;
        }
        Object[] objArr2 = this.f11999v;
        sd.i.h(i + i10, i, this.f12000w, objArr2, objArr2);
        this.f12000w += i10;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f11999v;
        int i = this.f12000w;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final Object i(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f11999v;
        Object obj = objArr[i];
        sd.i.h(i, i + 1, this.f12000w, objArr, objArr);
        Object[] objArr2 = this.f11999v;
        int i10 = this.f12000w - 1;
        ge.i.e(objArr2, "<this>");
        objArr2[i10] = null;
        this.f12000w--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.f12000w; i++) {
            if (ge.i.a(this.f11999v[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f12000w == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f11999v;
        sd.i.h(i, i + i10, this.f12000w, objArr, objArr);
        Object[] objArr2 = this.f11999v;
        int i11 = this.f12000w;
        z3.t(objArr2, i11 - i10, i11);
        this.f12000w -= i10;
    }

    public final int k(int i, int i10, Collection collection, boolean z10) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i + i11;
            if (collection.contains(this.f11999v[i13]) == z10) {
                Object[] objArr = this.f11999v;
                i11++;
                objArr[i12 + i] = objArr[i13];
                i12++;
            } else {
                i11++;
            }
        }
        int i14 = i10 - i12;
        Object[] objArr2 = this.f11999v;
        sd.i.h(i + i12, i10 + i, this.f12000w, objArr2, objArr2);
        Object[] objArr3 = this.f11999v;
        int i15 = this.f12000w;
        z3.t(objArr3, i15 - i14, i15);
        if (i14 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f12000w -= i14;
        return i14;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.f12000w - 1; i >= 0; i--) {
            if (ge.i.a(this.f11999v[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        ge.i.e(collection, "elements");
        g();
        return k(0, this.f12000w, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        ge.i.e(collection, "elements");
        g();
        return k(0, this.f12000w, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        g();
        int i10 = this.f12000w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        Object[] objArr = this.f11999v;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i10) {
        j4.b(i, i10, this.f12000w);
        return new b(this.f11999v, i, i10 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        ge.i.e(objArr, "array");
        int length = objArr.length;
        int i = this.f12000w;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f11999v, 0, i, objArr.getClass());
            ge.i.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        sd.i.h(0, 0, i, this.f11999v, objArr);
        int i10 = this.f12000w;
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return z3.g(this.f11999v, 0, this.f12000w, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i10 = this.f12000w;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return new a(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        ge.i.e(collection, "elements");
        g();
        int i10 = this.f12000w;
        if (i >= 0 && i <= i10) {
            int size = collection.size();
            d(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        g();
        int i10 = this.f12000w;
        if (i >= 0 && i <= i10) {
            ((AbstractList) this).modCount++;
            h(i, 1);
            this.f11999v[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return sd.i.k(this.f11999v, 0, this.f12000w);
    }
}
