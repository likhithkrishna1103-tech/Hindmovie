package od;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object[] f9565x = new Object[0];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f9567v = f9565x;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9568w;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i10 = this.f9568w;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        if (i == i10) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        n();
        f(this.f9568w + 1);
        int iL = l(this.f9566u + i);
        int i11 = this.f9568w;
        if (i < ((i11 + 1) >> 1)) {
            if (iL == 0) {
                Object[] objArr = this.f9567v;
                be.h.e(objArr, "<this>");
                iL = objArr.length;
            }
            int i12 = iL - 1;
            int i13 = this.f9566u;
            if (i13 == 0) {
                Object[] objArr2 = this.f9567v;
                be.h.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i13 - 1;
            }
            int i14 = this.f9566u;
            if (i12 >= i14) {
                Object[] objArr3 = this.f9567v;
                objArr3[length] = objArr3[i14];
                h.T(i14, i14 + 1, i12 + 1, objArr3, objArr3);
            } else {
                Object[] objArr4 = this.f9567v;
                h.T(i14 - 1, i14, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f9567v;
                objArr5[objArr5.length - 1] = objArr5[0];
                h.T(0, 1, i12 + 1, objArr5, objArr5);
            }
            this.f9567v[i12] = obj;
            this.f9566u = length;
        } else {
            int iL2 = l(i11 + this.f9566u);
            if (iL < iL2) {
                Object[] objArr6 = this.f9567v;
                h.T(iL + 1, iL, iL2, objArr6, objArr6);
            } else {
                Object[] objArr7 = this.f9567v;
                h.T(1, 0, iL2, objArr7, objArr7);
                Object[] objArr8 = this.f9567v;
                objArr8[0] = objArr8[objArr8.length - 1];
                h.T(iL + 1, iL, objArr8.length - 1, objArr8, objArr8);
            }
            this.f9567v[iL] = obj;
        }
        this.f9568w++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        be.h.e(collection, "elements");
        int i10 = this.f9568w;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.f9568w) {
            return addAll(collection);
        }
        n();
        f(collection.size() + this.f9568w);
        int iL = l(this.f9568w + this.f9566u);
        int iL2 = l(this.f9566u + i);
        int size = collection.size();
        if (i >= ((this.f9568w + 1) >> 1)) {
            int i11 = iL2 + size;
            if (iL2 < iL) {
                int i12 = size + iL;
                Object[] objArr = this.f9567v;
                if (i12 <= objArr.length) {
                    h.T(i11, iL2, iL, objArr, objArr);
                } else if (i11 >= objArr.length) {
                    h.T(i11 - objArr.length, iL2, iL, objArr, objArr);
                } else {
                    int length = iL - (i12 - objArr.length);
                    h.T(0, length, iL, objArr, objArr);
                    Object[] objArr2 = this.f9567v;
                    h.T(i11, iL2, length, objArr2, objArr2);
                }
            } else {
                Object[] objArr3 = this.f9567v;
                h.T(size, 0, iL, objArr3, objArr3);
                Object[] objArr4 = this.f9567v;
                if (i11 >= objArr4.length) {
                    h.T(i11 - objArr4.length, iL2, objArr4.length, objArr4, objArr4);
                } else {
                    h.T(0, objArr4.length - size, objArr4.length, objArr4, objArr4);
                    Object[] objArr5 = this.f9567v;
                    h.T(i11, iL2, objArr5.length - size, objArr5, objArr5);
                }
            }
            e(iL2, collection);
            return true;
        }
        int i13 = this.f9566u;
        int length2 = i13 - size;
        if (iL2 < i13) {
            Object[] objArr6 = this.f9567v;
            h.T(length2, i13, objArr6.length, objArr6, objArr6);
            if (size >= iL2) {
                Object[] objArr7 = this.f9567v;
                h.T(objArr7.length - size, 0, iL2, objArr7, objArr7);
            } else {
                Object[] objArr8 = this.f9567v;
                h.T(objArr8.length - size, 0, size, objArr8, objArr8);
                Object[] objArr9 = this.f9567v;
                h.T(0, size, iL2, objArr9, objArr9);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.f9567v;
            h.T(length2, i13, iL2, objArr10, objArr10);
        } else {
            Object[] objArr11 = this.f9567v;
            length2 += objArr11.length;
            int i14 = iL2 - i13;
            int length3 = objArr11.length - length2;
            if (length3 >= i14) {
                h.T(length2, i13, iL2, objArr11, objArr11);
            } else {
                h.T(length2, i13, i13 + length3, objArr11, objArr11);
                Object[] objArr12 = this.f9567v;
                h.T(0, this.f9566u + length3, iL2, objArr12, objArr12);
            }
        }
        this.f9566u = length2;
        e(i(iL2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        f(this.f9568w + 1);
        int length = this.f9566u;
        if (length == 0) {
            Object[] objArr = this.f9567v;
            be.h.e(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.f9566u = i;
        this.f9567v[i] = obj;
        this.f9568w++;
    }

    public final void addLast(Object obj) {
        n();
        f(b() + 1);
        this.f9567v[l(b() + this.f9566u)] = obj;
        this.f9568w = b() + 1;
    }

    @Override // od.d
    public final int b() {
        return this.f9568w;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            j(this.f9566u, l(b() + this.f9566u));
        }
        this.f9566u = 0;
        this.f9568w = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // od.d
    public final Object d(int i) {
        int i10 = this.f9568w;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(l4.a.l(i, i10, "index: ", ", size: "));
        }
        if (i == j.R(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        n();
        int iL = l(this.f9566u + i);
        Object[] objArr = this.f9567v;
        Object obj = objArr[iL];
        if (i < (this.f9568w >> 1)) {
            int i11 = this.f9566u;
            if (iL >= i11) {
                h.T(i11 + 1, i11, iL, objArr, objArr);
            } else {
                h.T(1, 0, iL, objArr, objArr);
                Object[] objArr2 = this.f9567v;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i12 = this.f9566u;
                h.T(i12 + 1, i12, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f9567v;
            int i13 = this.f9566u;
            objArr3[i13] = null;
            this.f9566u = h(i13);
        } else {
            int iL2 = l(j.R(this) + this.f9566u);
            if (iL <= iL2) {
                Object[] objArr4 = this.f9567v;
                h.T(iL, iL + 1, iL2 + 1, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.f9567v;
                h.T(iL, iL + 1, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.f9567v;
                objArr6[objArr6.length - 1] = objArr6[0];
                h.T(0, 1, iL2 + 1, objArr6, objArr6);
            }
            this.f9567v[iL2] = null;
        }
        this.f9568w--;
        return obj;
    }

    public final void e(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f9567v.length;
        while (i < length && it.hasNext()) {
            this.f9567v[i] = it.next();
            i++;
        }
        int i10 = this.f9566u;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.f9567v[i11] = it.next();
        }
        this.f9568w = collection.size() + this.f9568w;
    }

    public final void f(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f9567v;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f9565x) {
            if (i < 10) {
                i = 10;
            }
            this.f9567v = new Object[i];
            return;
        }
        int length = objArr.length;
        int i10 = length + (length >> 1);
        if (i10 - i < 0) {
            i10 = i;
        }
        if (i10 - 2147483639 > 0) {
            i10 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i10];
        h.T(0, this.f9566u, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.f9567v;
        int length2 = objArr3.length;
        int i11 = this.f9566u;
        h.T(length2 - i11, 0, i11, objArr3, objArr2);
        this.f9566u = 0;
        this.f9567v = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iB = b();
        if (i < 0 || i >= iB) {
            throw new IndexOutOfBoundsException(l4.a.l(i, iB, "index: ", ", size: "));
        }
        return this.f9567v[l(this.f9566u + i)];
    }

    public final int h(int i) {
        be.h.e(this.f9567v, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int i(int i) {
        return i < 0 ? i + this.f9567v.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iL = l(b() + this.f9566u);
        int length = this.f9566u;
        if (length < iL) {
            while (length < iL) {
                if (be.h.a(obj, this.f9567v[length])) {
                    i = this.f9566u;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iL) {
            return -1;
        }
        int length2 = this.f9567v.length;
        while (true) {
            if (length >= length2) {
                for (int i10 = 0; i10 < iL; i10++) {
                    if (be.h.a(obj, this.f9567v[i10])) {
                        length = i10 + this.f9567v.length;
                        i = this.f9566u;
                    }
                }
                return -1;
            }
            if (be.h.a(obj, this.f9567v[length])) {
                i = this.f9566u;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return b() == 0;
    }

    public final void j(int i, int i10) {
        if (i < i10) {
            h.W(this.f9567v, i, i10);
            return;
        }
        Object[] objArr = this.f9567v;
        h.W(objArr, i, objArr.length);
        h.W(this.f9567v, 0, i10);
    }

    public final int l(int i) {
        Object[] objArr = this.f9567v;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iL = l(this.f9568w + this.f9566u);
        int i10 = this.f9566u;
        if (i10 < iL) {
            length = iL - 1;
            if (i10 <= length) {
                while (!be.h.a(obj, this.f9567v[length])) {
                    if (length != i10) {
                        length--;
                    }
                }
                i = this.f9566u;
                return length - i;
            }
            return -1;
        }
        if (i10 > iL) {
            int i11 = iL - 1;
            while (true) {
                if (-1 >= i11) {
                    Object[] objArr = this.f9567v;
                    be.h.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i12 = this.f9566u;
                    if (i12 <= length) {
                        while (!be.h.a(obj, this.f9567v[length])) {
                            if (length != i12) {
                                length--;
                            }
                        }
                        i = this.f9566u;
                    }
                } else {
                    if (be.h.a(obj, this.f9567v[i11])) {
                        length = i11 + this.f9567v.length;
                        i = this.f9566u;
                        break;
                    }
                    i11--;
                }
            }
        }
        return -1;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        d(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iL;
        be.h.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f9567v.length != 0) {
            int iL2 = l(this.f9568w + this.f9566u);
            int i = this.f9566u;
            if (i < iL2) {
                iL = i;
                while (i < iL2) {
                    Object obj = this.f9567v[i];
                    if (collection.contains(obj)) {
                        z2 = true;
                    } else {
                        this.f9567v[iL] = obj;
                        iL++;
                    }
                    i++;
                }
                h.W(this.f9567v, iL, iL2);
            } else {
                int length = this.f9567v.length;
                boolean z10 = false;
                int i10 = i;
                while (i < length) {
                    Object[] objArr = this.f9567v;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z10 = true;
                    } else {
                        this.f9567v[i10] = obj2;
                        i10++;
                    }
                    i++;
                }
                iL = l(i10);
                for (int i11 = 0; i11 < iL2; i11++) {
                    Object[] objArr2 = this.f9567v;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (collection.contains(obj3)) {
                        z10 = true;
                    } else {
                        this.f9567v[iL] = obj3;
                        iL = h(iL);
                    }
                }
                z2 = z10;
            }
            if (z2) {
                n();
                this.f9568w = i(iL - this.f9566u);
            }
        }
        return z2;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.f9567v;
        int i = this.f9566u;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f9566u = h(i);
        this.f9568w = b() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int iL = l(j.R(this) + this.f9566u);
        Object[] objArr = this.f9567v;
        Object obj = objArr[iL];
        objArr[iL] = null;
        this.f9568w = b() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        z7.a.f(i, i10, this.f9568w);
        int i11 = i10 - i;
        if (i11 == 0) {
            return;
        }
        if (i11 == this.f9568w) {
            clear();
            return;
        }
        if (i11 == 1) {
            d(i);
            return;
        }
        n();
        if (i < this.f9568w - i10) {
            int iL = l((i - 1) + this.f9566u);
            int iL2 = l((i10 - 1) + this.f9566u);
            while (i > 0) {
                int i12 = iL + 1;
                int iMin = Math.min(i, Math.min(i12, iL2 + 1));
                Object[] objArr = this.f9567v;
                int i13 = iL2 - iMin;
                int i14 = iL - iMin;
                h.T(i13 + 1, i14 + 1, i12, objArr, objArr);
                iL = i(i14);
                iL2 = i(i13);
                i -= iMin;
            }
            int iL3 = l(this.f9566u + i11);
            j(this.f9566u, iL3);
            this.f9566u = iL3;
        } else {
            int iL4 = l(this.f9566u + i10);
            int iL5 = l(this.f9566u + i);
            int i15 = this.f9568w;
            while (true) {
                i15 -= i10;
                if (i15 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f9567v;
                i10 = Math.min(i15, Math.min(objArr2.length - iL4, objArr2.length - iL5));
                Object[] objArr3 = this.f9567v;
                int i16 = iL4 + i10;
                h.T(iL5, iL4, i16, objArr3, objArr3);
                iL4 = l(i16);
                iL5 = l(iL5 + i10);
            }
            int iL6 = l(this.f9568w + this.f9566u);
            j(i(iL6 - i11), iL6);
        }
        this.f9568w -= i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iL;
        be.h.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f9567v.length != 0) {
            int iL2 = l(this.f9568w + this.f9566u);
            int i = this.f9566u;
            if (i < iL2) {
                iL = i;
                while (i < iL2) {
                    Object obj = this.f9567v[i];
                    if (collection.contains(obj)) {
                        this.f9567v[iL] = obj;
                        iL++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                h.W(this.f9567v, iL, iL2);
            } else {
                int length = this.f9567v.length;
                boolean z10 = false;
                int i10 = i;
                while (i < length) {
                    Object[] objArr = this.f9567v;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.f9567v[i10] = obj2;
                        i10++;
                    } else {
                        z10 = true;
                    }
                    i++;
                }
                iL = l(i10);
                for (int i11 = 0; i11 < iL2; i11++) {
                    Object[] objArr2 = this.f9567v;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (collection.contains(obj3)) {
                        this.f9567v[iL] = obj3;
                        iL = h(iL);
                    } else {
                        z10 = true;
                    }
                }
                z2 = z10;
            }
            if (z2) {
                n();
                this.f9568w = i(iL - this.f9566u);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iB = b();
        if (i < 0 || i >= iB) {
            throw new IndexOutOfBoundsException(l4.a.l(i, iB, "index: ", ", size: "));
        }
        int iL = l(this.f9566u + i);
        Object[] objArr = this.f9567v;
        Object obj2 = objArr[iL];
        objArr[iL] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[b()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        be.h.e(objArr, "array");
        int length = objArr.length;
        int i = this.f9568w;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            be.h.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iL = l(this.f9568w + this.f9566u);
        int i10 = this.f9566u;
        if (i10 < iL) {
            h.U(i10, iL, 2, this.f9567v, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f9567v;
            h.T(0, this.f9566u, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f9567v;
            h.T(objArr3.length - this.f9566u, 0, iL, objArr3, objArr);
        }
        int i11 = this.f9568w;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        be.h.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        n();
        f(collection.size() + b());
        e(l(b() + this.f9566u), collection);
        return true;
    }
}
