package s;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Collection, Set, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int[] f11624u = t.a.f11959a;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f11625v = t.a.f11961c;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11626w;

    public f(int i) {
        if (i > 0) {
            h.a(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iB;
        int i10 = this.f11626w;
        if (obj == null) {
            iB = h.b(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iB = h.b(this, obj, iHashCode);
        }
        if (iB >= 0) {
            return false;
        }
        int i11 = ~iB;
        int[] iArr = this.f11624u;
        if (i10 >= iArr.length) {
            int i12 = 8;
            if (i10 >= 8) {
                i12 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f11625v;
            int[] iArr2 = new int[i12];
            this.f11624u = iArr2;
            this.f11625v = new Object[i12];
            if (i10 != this.f11626w) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                od.h.S(0, 0, iArr.length, iArr, iArr2);
                od.h.U(0, objArr.length, 6, objArr, this.f11625v);
            }
        }
        if (i11 < i10) {
            int[] iArr3 = this.f11624u;
            int i13 = i11 + 1;
            od.h.S(i13, i11, i10, iArr3, iArr3);
            Object[] objArr2 = this.f11625v;
            od.h.T(i13, i11, i10, objArr2, objArr2);
        }
        int i14 = this.f11626w;
        if (i10 == i14) {
            int[] iArr4 = this.f11624u;
            if (i11 < iArr4.length) {
                iArr4[i11] = i;
                this.f11625v[i11] = obj;
                this.f11626w = i14 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        be.h.e(collection, "elements");
        int size = collection.size() + this.f11626w;
        int i = this.f11626w;
        int[] iArr = this.f11624u;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f11625v;
            int[] iArr2 = new int[size];
            this.f11624u = iArr2;
            this.f11625v = new Object[size];
            if (i > 0) {
                od.h.S(0, 0, i, iArr, iArr2);
                od.h.U(0, this.f11626w, 6, objArr, this.f11625v);
            }
        }
        if (this.f11626w != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object b(int i) {
        int i10 = this.f11626w;
        Object[] objArr = this.f11625v;
        Object obj = objArr[i];
        if (i10 <= 1) {
            clear();
            return obj;
        }
        int i11 = i10 - 1;
        int[] iArr = this.f11624u;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                od.h.S(i, i12, i10, iArr, iArr);
                Object[] objArr2 = this.f11625v;
                od.h.T(i, i12, i10, objArr2, objArr2);
            }
            this.f11625v[i11] = null;
        } else {
            int i13 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArr2 = new int[i13];
            this.f11624u = iArr2;
            this.f11625v = new Object[i13];
            if (i > 0) {
                od.h.S(0, 0, i, iArr, iArr2);
                od.h.U(0, i, 6, objArr, this.f11625v);
            }
            if (i < i11) {
                int i14 = i + 1;
                od.h.S(i, i14, i10, iArr, this.f11624u);
                od.h.T(i, i14, i10, objArr, this.f11625v);
            }
        }
        if (i10 != this.f11626w) {
            throw new ConcurrentModificationException();
        }
        this.f11626w = i11;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f11626w != 0) {
            this.f11624u = t.a.f11959a;
            this.f11625v = t.a.f11961c;
            this.f11626w = 0;
        }
        if (this.f11626w != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? h.b(this, null, 0) : h.b(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        be.h.e(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f11626w != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.f11626w;
            for (int i10 = 0; i10 < i; i10++) {
                if (!((Set) obj).contains(this.f11625v[i10])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f11624u;
        int i = this.f11626w;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f11626w <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iB = obj == null ? h.b(this, null, 0) : h.b(this, obj, obj.hashCode());
        if (iB < 0) {
            return false;
        }
        b(iB);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        be.h.e(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean zContains;
        be.h.e(collection, "elements");
        int i = this.f11626w - 1;
        boolean z2 = false;
        while (true) {
            int iIndexOf = -1;
            if (-1 >= i) {
                return z2;
            }
            Object obj = this.f11625v[i];
            Collection collection2 = collection;
            if (collection2 instanceof Collection) {
                zContains = collection2.contains(obj);
            } else {
                if (!(collection2 instanceof List)) {
                    Iterator it = collection2.iterator();
                    int i10 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (i10 < 0) {
                            throw new ArithmeticException("Index overflow has happened.");
                        }
                        if (be.h.a(obj, next)) {
                            iIndexOf = i10;
                            break;
                        }
                        i10++;
                    }
                } else {
                    iIndexOf = ((List) collection2).indexOf(obj);
                }
                zContains = iIndexOf >= 0;
            }
            if (!zContains) {
                b(i);
                z2 = true;
            }
            i--;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f11626w;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return od.h.V(this.f11625v, 0, this.f11626w);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11626w * 14);
        sb2.append('{');
        int i = this.f11626w;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f11625v[i10];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        be.h.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        be.h.e(objArr, "array");
        int i = this.f11626w;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        od.h.T(0, 0, this.f11626w, this.f11625v, objArr);
        return objArr;
    }
}
