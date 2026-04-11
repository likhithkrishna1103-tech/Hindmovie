package td;

import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.z3;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends sd.e implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f11993v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11994w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11995x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f11996y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f11997z;

    public b(Object[] objArr, int i, int i10, b bVar, c cVar) {
        ge.i.e(objArr, "backing");
        ge.i.e(cVar, "root");
        this.f11993v = objArr;
        this.f11994w = i;
        this.f11995x = i10;
        this.f11996y = bVar;
        this.f11997z = cVar;
        ((AbstractList) this).modCount = ((AbstractList) cVar).modCount;
    }

    @Override // sd.e
    public final int a() {
        g();
        return this.f11995x;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        h();
        g();
        f(this.f11994w + this.f11995x, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ge.i.e(collection, "elements");
        h();
        g();
        int size = collection.size();
        d(this.f11994w + this.f11995x, collection, size);
        return size > 0;
    }

    @Override // sd.e
    public final Object b(int i) {
        h();
        g();
        int i10 = this.f11995x;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return i(this.f11994w + i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        h();
        g();
        j(this.f11994w, this.f11995x);
    }

    public final void d(int i, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        c cVar = this.f11997z;
        b bVar = this.f11996y;
        if (bVar != null) {
            bVar.d(i, collection, i10);
        } else {
            c cVar2 = c.f11998y;
            cVar.d(i, collection, i10);
        }
        this.f11993v = cVar.f11999v;
        this.f11995x += i10;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        g();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f11993v;
            int i = this.f11995x;
            if (i == list.size()) {
                for (int i10 = 0; i10 < i; i10++) {
                    if (ge.i.a(objArr[this.f11994w + i10], list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f11997z;
        b bVar = this.f11996y;
        if (bVar != null) {
            bVar.f(i, obj);
        } else {
            c cVar2 = c.f11998y;
            cVar.f(i, obj);
        }
        this.f11993v = cVar.f11999v;
        this.f11995x++;
    }

    public final void g() {
        if (((AbstractList) this.f11997z).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        g();
        int i10 = this.f11995x;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return this.f11993v[this.f11994w + i];
    }

    public final void h() {
        if (this.f11997z.f12001x) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        g();
        Object[] objArr = this.f11993v;
        int i = this.f11995x;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[this.f11994w + i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final Object i(int i) {
        Object objI;
        ((AbstractList) this).modCount++;
        b bVar = this.f11996y;
        if (bVar != null) {
            objI = bVar.i(i);
        } else {
            c cVar = c.f11998y;
            objI = this.f11997z.i(i);
        }
        this.f11995x--;
        return objI;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        g();
        for (int i = 0; i < this.f11995x; i++) {
            if (ge.i.a(this.f11993v[this.f11994w + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        g();
        return this.f11995x == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f11996y;
        if (bVar != null) {
            bVar.j(i, i10);
        } else {
            c cVar = c.f11998y;
            this.f11997z.j(i, i10);
        }
        this.f11995x -= i10;
    }

    public final int k(int i, int i10, Collection collection, boolean z10) {
        int iK;
        b bVar = this.f11996y;
        if (bVar != null) {
            iK = bVar.k(i, i10, collection, z10);
        } else {
            c cVar = c.f11998y;
            iK = this.f11997z.k(i, i10, collection, z10);
        }
        if (iK > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f11995x -= iK;
        return iK;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        g();
        for (int i = this.f11995x - 1; i >= 0; i--) {
            if (ge.i.a(this.f11993v[this.f11994w + i], obj)) {
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
        h();
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
        h();
        g();
        return k(this.f11994w, this.f11995x, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        ge.i.e(collection, "elements");
        h();
        g();
        return k(this.f11994w, this.f11995x, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        h();
        g();
        int i10 = this.f11995x;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        Object[] objArr = this.f11993v;
        int i11 = this.f11994w;
        Object obj2 = objArr[i11 + i];
        objArr[i11 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i10) {
        j4.b(i, i10, this.f11995x);
        return new b(this.f11993v, this.f11994w + i, i10 - i, this, this.f11997z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        ge.i.e(objArr, "array");
        g();
        int length = objArr.length;
        int i = this.f11995x;
        int i10 = this.f11994w;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f11993v, i10, i + i10, objArr.getClass());
            ge.i.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        sd.i.h(0, i10, i + i10, this.f11993v, objArr);
        int i11 = this.f11995x;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        g();
        return z3.g(this.f11993v, this.f11994w, this.f11995x, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        g();
        int i10 = this.f11995x;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return new a(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        h();
        g();
        int i10 = this.f11995x;
        if (i >= 0 && i <= i10) {
            f(this.f11994w + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        ge.i.e(collection, "elements");
        h();
        g();
        int i10 = this.f11995x;
        if (i >= 0 && i <= i10) {
            int size = collection.size();
            d(this.f11994w + i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        g();
        Object[] objArr = this.f11993v;
        int i = this.f11995x;
        int i10 = this.f11994w;
        return sd.i.k(objArr, i10, i + i10);
    }
}
