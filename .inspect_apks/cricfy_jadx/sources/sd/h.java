package sd;

import com.google.android.gms.internal.measurement.j4;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Object[] f11662y = new Object[0];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11663v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f11664w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11665x;

    public h() {
        this.f11664w = f11662y;
    }

    @Override // sd.e
    public final int a() {
        return this.f11665x;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i10 = this.f11665x;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        if (i == i10) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        j();
        d(this.f11665x + 1);
        int i11 = i(this.f11663v + i);
        int i12 = this.f11665x;
        if (i < ((i12 + 1) >> 1)) {
            if (i11 == 0) {
                Object[] objArr = this.f11664w;
                ge.i.e(objArr, "<this>");
                i11 = objArr.length;
            }
            int i13 = i11 - 1;
            int i14 = this.f11663v;
            if (i14 == 0) {
                Object[] objArr2 = this.f11664w;
                ge.i.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i14 - 1;
            }
            int i15 = this.f11663v;
            if (i13 >= i15) {
                Object[] objArr3 = this.f11664w;
                objArr3[length] = objArr3[i15];
                i.h(i15, i15 + 1, i13 + 1, objArr3, objArr3);
            } else {
                Object[] objArr4 = this.f11664w;
                i.h(i15 - 1, i15, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f11664w;
                objArr5[objArr5.length - 1] = objArr5[0];
                i.h(0, 1, i13 + 1, objArr5, objArr5);
            }
            this.f11664w[i13] = obj;
            this.f11663v = length;
        } else {
            int i16 = i(i12 + this.f11663v);
            if (i11 < i16) {
                Object[] objArr6 = this.f11664w;
                i.h(i11 + 1, i11, i16, objArr6, objArr6);
            } else {
                Object[] objArr7 = this.f11664w;
                i.h(1, 0, i16, objArr7, objArr7);
                Object[] objArr8 = this.f11664w;
                objArr8[0] = objArr8[objArr8.length - 1];
                i.h(i11 + 1, i11, objArr8.length - 1, objArr8, objArr8);
            }
            this.f11664w[i11] = obj;
        }
        this.f11665x++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        ge.i.e(collection, "elements");
        int i10 = this.f11665x;
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.f11665x) {
            return addAll(collection);
        }
        j();
        d(collection.size() + this.f11665x);
        int i11 = i(this.f11665x + this.f11663v);
        int i12 = i(this.f11663v + i);
        int size = collection.size();
        if (i >= ((this.f11665x + 1) >> 1)) {
            int i13 = i12 + size;
            if (i12 < i11) {
                int i14 = size + i11;
                Object[] objArr = this.f11664w;
                if (i14 <= objArr.length) {
                    i.h(i13, i12, i11, objArr, objArr);
                } else if (i13 >= objArr.length) {
                    i.h(i13 - objArr.length, i12, i11, objArr, objArr);
                } else {
                    int length = i11 - (i14 - objArr.length);
                    i.h(0, length, i11, objArr, objArr);
                    Object[] objArr2 = this.f11664w;
                    i.h(i13, i12, length, objArr2, objArr2);
                }
            } else {
                Object[] objArr3 = this.f11664w;
                i.h(size, 0, i11, objArr3, objArr3);
                Object[] objArr4 = this.f11664w;
                if (i13 >= objArr4.length) {
                    i.h(i13 - objArr4.length, i12, objArr4.length, objArr4, objArr4);
                } else {
                    i.h(0, objArr4.length - size, objArr4.length, objArr4, objArr4);
                    Object[] objArr5 = this.f11664w;
                    i.h(i13, i12, objArr5.length - size, objArr5, objArr5);
                }
            }
            c(i12, collection);
            return true;
        }
        int i15 = this.f11663v;
        int length2 = i15 - size;
        if (i12 < i15) {
            Object[] objArr6 = this.f11664w;
            i.h(length2, i15, objArr6.length, objArr6, objArr6);
            if (size >= i12) {
                Object[] objArr7 = this.f11664w;
                i.h(objArr7.length - size, 0, i12, objArr7, objArr7);
            } else {
                Object[] objArr8 = this.f11664w;
                i.h(objArr8.length - size, 0, size, objArr8, objArr8);
                Object[] objArr9 = this.f11664w;
                i.h(0, size, i12, objArr9, objArr9);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.f11664w;
            i.h(length2, i15, i12, objArr10, objArr10);
        } else {
            Object[] objArr11 = this.f11664w;
            length2 += objArr11.length;
            int i16 = i12 - i15;
            int length3 = objArr11.length - length2;
            if (length3 >= i16) {
                i.h(length2, i15, i12, objArr11, objArr11);
            } else {
                i.h(length2, i15, i15 + length3, objArr11, objArr11);
                Object[] objArr12 = this.f11664w;
                i.h(0, this.f11663v + length3, i12, objArr12, objArr12);
            }
        }
        this.f11663v = length2;
        c(g(i12 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        j();
        d(this.f11665x + 1);
        int length = this.f11663v;
        if (length == 0) {
            Object[] objArr = this.f11664w;
            ge.i.e(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.f11663v = i;
        this.f11664w[i] = obj;
        this.f11665x++;
    }

    public final void addLast(Object obj) {
        j();
        d(a() + 1);
        this.f11664w[i(a() + this.f11663v)] = obj;
        this.f11665x = a() + 1;
    }

    @Override // sd.e
    public final Object b(int i) {
        int i10 = this.f11665x;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        if (i == k.d0(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        j();
        int i11 = i(this.f11663v + i);
        Object[] objArr = this.f11664w;
        Object obj = objArr[i11];
        if (i < (this.f11665x >> 1)) {
            int i12 = this.f11663v;
            if (i11 >= i12) {
                i.h(i12 + 1, i12, i11, objArr, objArr);
            } else {
                i.h(1, 0, i11, objArr, objArr);
                Object[] objArr2 = this.f11664w;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i13 = this.f11663v;
                i.h(i13 + 1, i13, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f11664w;
            int i14 = this.f11663v;
            objArr3[i14] = null;
            this.f11663v = f(i14);
        } else {
            int i15 = i(k.d0(this) + this.f11663v);
            if (i11 <= i15) {
                Object[] objArr4 = this.f11664w;
                i.h(i11, i11 + 1, i15 + 1, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.f11664w;
                i.h(i11, i11 + 1, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.f11664w;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.h(0, 1, i15 + 1, objArr6, objArr6);
            }
            this.f11664w[i15] = null;
        }
        this.f11665x--;
        return obj;
    }

    public final void c(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f11664w.length;
        while (i < length && it.hasNext()) {
            this.f11664w[i] = it.next();
            i++;
        }
        int i10 = this.f11663v;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.f11664w[i11] = it.next();
        }
        this.f11665x = collection.size() + this.f11665x;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            j();
            h(this.f11663v, i(a() + this.f11663v));
        }
        this.f11663v = 0;
        this.f11665x = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f11664w;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f11662y) {
            if (i < 10) {
                i = 10;
            }
            this.f11664w = new Object[i];
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
        i.h(0, this.f11663v, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.f11664w;
        int length2 = objArr3.length;
        int i11 = this.f11663v;
        i.h(length2 - i11, 0, i11, objArr3, objArr2);
        this.f11663v = 0;
        this.f11664w = objArr2;
    }

    public final int f(int i) {
        ge.i.e(this.f11664w, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int g(int i) {
        return i < 0 ? i + this.f11664w.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(q4.a.m(i, iA, "index: ", ", size: "));
        }
        return this.f11664w[i(this.f11663v + i)];
    }

    public final void h(int i, int i10) {
        if (i < i10) {
            i.p(this.f11664w, i, i10);
            return;
        }
        Object[] objArr = this.f11664w;
        i.p(objArr, i, objArr.length);
        i.p(this.f11664w, 0, i10);
    }

    public final int i(int i) {
        Object[] objArr = this.f11664w;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int i10 = i(a() + this.f11663v);
        int length = this.f11663v;
        if (length < i10) {
            while (length < i10) {
                if (ge.i.a(obj, this.f11664w[length])) {
                    i = this.f11663v;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i10) {
            return -1;
        }
        int length2 = this.f11664w.length;
        while (true) {
            if (length >= length2) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (ge.i.a(obj, this.f11664w[i11])) {
                        length = i11 + this.f11664w.length;
                        i = this.f11663v;
                    }
                }
                return -1;
            }
            if (ge.i.a(obj, this.f11664w[length])) {
                i = this.f11663v;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final void j() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int i10 = i(this.f11665x + this.f11663v);
        int i11 = this.f11663v;
        if (i11 < i10) {
            length = i10 - 1;
            if (i11 <= length) {
                while (!ge.i.a(obj, this.f11664w[length])) {
                    if (length != i11) {
                        length--;
                    }
                }
                i = this.f11663v;
                return length - i;
            }
            return -1;
        }
        if (i11 > i10) {
            int i12 = i10 - 1;
            while (true) {
                if (-1 >= i12) {
                    Object[] objArr = this.f11664w;
                    ge.i.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i13 = this.f11663v;
                    if (i13 <= length) {
                        while (!ge.i.a(obj, this.f11664w[length])) {
                            if (length != i13) {
                                length--;
                            }
                        }
                        i = this.f11663v;
                    }
                } else {
                    if (ge.i.a(obj, this.f11664w[i12])) {
                        length = i12 + this.f11664w.length;
                        i = this.f11663v;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int i;
        ge.i.e(collection, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f11664w.length != 0) {
            int i10 = i(this.f11665x + this.f11663v);
            int i11 = this.f11663v;
            if (i11 < i10) {
                i = i11;
                while (i11 < i10) {
                    Object obj = this.f11664w[i11];
                    if (collection.contains(obj)) {
                        z10 = true;
                    } else {
                        this.f11664w[i] = obj;
                        i++;
                    }
                    i11++;
                }
                i.p(this.f11664w, i, i10);
            } else {
                int length = this.f11664w.length;
                boolean z11 = false;
                int i12 = i11;
                while (i11 < length) {
                    Object[] objArr = this.f11664w;
                    Object obj2 = objArr[i11];
                    objArr[i11] = null;
                    if (collection.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.f11664w[i12] = obj2;
                        i12++;
                    }
                    i11++;
                }
                i = i(i12);
                for (int i13 = 0; i13 < i10; i13++) {
                    Object[] objArr2 = this.f11664w;
                    Object obj3 = objArr2[i13];
                    objArr2[i13] = null;
                    if (collection.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.f11664w[i] = obj3;
                        i = f(i);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                j();
                this.f11665x = g(i - this.f11663v);
            }
        }
        return z10;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        j();
        Object[] objArr = this.f11664w;
        int i = this.f11663v;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f11663v = f(i);
        this.f11665x = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        j();
        int i = i(k.d0(this) + this.f11663v);
        Object[] objArr = this.f11664w;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f11665x = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i10) {
        j4.b(i, i10, this.f11665x);
        int i11 = i10 - i;
        if (i11 == 0) {
            return;
        }
        if (i11 == this.f11665x) {
            clear();
            return;
        }
        if (i11 == 1) {
            b(i);
            return;
        }
        j();
        if (i < this.f11665x - i10) {
            int i12 = i(this.f11663v + (i - 1));
            int i13 = i(this.f11663v + (i10 - 1));
            while (i > 0) {
                int i14 = i12 + 1;
                int iMin = Math.min(i, Math.min(i14, i13 + 1));
                Object[] objArr = this.f11664w;
                int i15 = i13 - iMin;
                int i16 = i12 - iMin;
                i.h(i15 + 1, i16 + 1, i14, objArr, objArr);
                i12 = g(i16);
                i13 = g(i15);
                i -= iMin;
            }
            int i17 = i(this.f11663v + i11);
            h(this.f11663v, i17);
            this.f11663v = i17;
        } else {
            int i18 = i(this.f11663v + i10);
            int i19 = i(this.f11663v + i);
            int i20 = this.f11665x;
            while (true) {
                i20 -= i10;
                if (i20 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f11664w;
                i10 = Math.min(i20, Math.min(objArr2.length - i18, objArr2.length - i19));
                Object[] objArr3 = this.f11664w;
                int i21 = i18 + i10;
                i.h(i19, i18, i21, objArr3, objArr3);
                i18 = i(i21);
                i19 = i(i19 + i10);
            }
            int i22 = i(this.f11665x + this.f11663v);
            h(g(i22 - i11), i22);
        }
        this.f11665x -= i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int i;
        ge.i.e(collection, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f11664w.length != 0) {
            int i10 = i(this.f11665x + this.f11663v);
            int i11 = this.f11663v;
            if (i11 < i10) {
                i = i11;
                while (i11 < i10) {
                    Object obj = this.f11664w[i11];
                    if (collection.contains(obj)) {
                        this.f11664w[i] = obj;
                        i++;
                    } else {
                        z10 = true;
                    }
                    i11++;
                }
                i.p(this.f11664w, i, i10);
            } else {
                int length = this.f11664w.length;
                boolean z11 = false;
                int i12 = i11;
                while (i11 < length) {
                    Object[] objArr = this.f11664w;
                    Object obj2 = objArr[i11];
                    objArr[i11] = null;
                    if (collection.contains(obj2)) {
                        this.f11664w[i12] = obj2;
                        i12++;
                    } else {
                        z11 = true;
                    }
                    i11++;
                }
                i = i(i12);
                for (int i13 = 0; i13 < i10; i13++) {
                    Object[] objArr2 = this.f11664w;
                    Object obj3 = objArr2[i13];
                    objArr2[i13] = null;
                    if (collection.contains(obj3)) {
                        this.f11664w[i] = obj3;
                        i = f(i);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                j();
                this.f11665x = g(i - this.f11663v);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(q4.a.m(i, iA, "index: ", ", size: "));
        }
        int i10 = i(this.f11663v + i);
        Object[] objArr = this.f11664w;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    public h(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = f11662y;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(l0.e.g(i, "Illegal Capacity: "));
        }
        this.f11664w = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        ge.i.e(objArr, "array");
        int length = objArr.length;
        int i = this.f11665x;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            ge.i.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int i10 = i(this.f11665x + this.f11663v);
        int i11 = this.f11663v;
        if (i11 < i10) {
            i.i(i11, i10, 2, this.f11664w, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f11664w;
            i.h(0, this.f11663v, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f11664w;
            i.h(objArr3.length - this.f11663v, 0, i10, objArr3, objArr);
        }
        int i12 = this.f11665x;
        if (i12 < objArr.length) {
            objArr[i12] = null;
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
        ge.i.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        j();
        d(collection.size() + a());
        c(i(a() + this.f11663v), collection);
        return true;
    }
}
