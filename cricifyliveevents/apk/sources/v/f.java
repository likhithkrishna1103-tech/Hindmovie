package v;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Collection, Set, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f12521v = w.a.f13743a;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f12522w = w.a.f13745c;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12523x;

    public f(int i) {
        if (i > 0) {
            i.b(this, i);
        }
    }

    public final Object a(int i) {
        int i10 = this.f12523x;
        Object[] objArr = this.f12522w;
        Object obj = objArr[i];
        if (i10 <= 1) {
            clear();
            return obj;
        }
        int i11 = i10 - 1;
        int[] iArr = this.f12521v;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                sd.i.g(i, i12, i10, iArr, iArr);
                Object[] objArr2 = this.f12522w;
                sd.i.h(i, i12, i10, objArr2, objArr2);
            }
            this.f12522w[i11] = null;
        } else {
            int i13 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArr2 = new int[i13];
            this.f12521v = iArr2;
            this.f12522w = new Object[i13];
            if (i > 0) {
                sd.i.g(0, 0, i, iArr, iArr2);
                sd.i.i(0, i, 6, objArr, this.f12522w);
            }
            if (i < i11) {
                int i14 = i + 1;
                sd.i.g(i, i14, i10, iArr, this.f12521v);
                sd.i.h(i, i14, i10, objArr, this.f12522w);
            }
        }
        if (i10 != this.f12523x) {
            throw new ConcurrentModificationException();
        }
        this.f12523x = i11;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iC;
        int i10 = this.f12523x;
        if (obj == null) {
            iC = i.c(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iC = i.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i11 = ~iC;
        int[] iArr = this.f12521v;
        if (i10 >= iArr.length) {
            int i12 = 8;
            if (i10 >= 8) {
                i12 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f12522w;
            int[] iArr2 = new int[i12];
            this.f12521v = iArr2;
            this.f12522w = new Object[i12];
            if (i10 != this.f12523x) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                sd.i.g(0, 0, iArr.length, iArr, iArr2);
                sd.i.i(0, objArr.length, 6, objArr, this.f12522w);
            }
        }
        if (i11 < i10) {
            int[] iArr3 = this.f12521v;
            int i13 = i11 + 1;
            sd.i.g(i13, i11, i10, iArr3, iArr3);
            Object[] objArr2 = this.f12522w;
            sd.i.h(i13, i11, i10, objArr2, objArr2);
        }
        int i14 = this.f12523x;
        if (i10 == i14) {
            int[] iArr4 = this.f12521v;
            if (i11 < iArr4.length) {
                iArr4[i11] = i;
                this.f12522w[i11] = obj;
                this.f12523x = i14 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        ge.i.e(collection, "elements");
        int size = collection.size() + this.f12523x;
        int i = this.f12523x;
        int[] iArr = this.f12521v;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f12522w;
            int[] iArr2 = new int[size];
            this.f12521v = iArr2;
            this.f12522w = new Object[size];
            if (i > 0) {
                sd.i.g(0, 0, i, iArr, iArr2);
                sd.i.i(0, this.f12523x, 6, objArr, this.f12522w);
            }
        }
        if (this.f12523x != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f12523x != 0) {
            this.f12521v = w.a.f13743a;
            this.f12522w = w.a.f13745c;
            this.f12523x = 0;
        }
        if (this.f12523x != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? i.c(this, null, 0) : i.c(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        ge.i.e(collection, "elements");
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
        if (!(obj instanceof Set) || this.f12523x != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.f12523x;
            for (int i10 = 0; i10 < i; i10++) {
                if (!((Set) obj).contains(this.f12522w[i10])) {
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
        int[] iArr = this.f12521v;
        int i = this.f12523x;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f12523x <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iC = obj == null ? i.c(this, null, 0) : i.c(this, obj, obj.hashCode());
        if (iC < 0) {
            return false;
        }
        a(iC);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        ge.i.e(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        ge.i.e(collection, "elements");
        boolean z10 = false;
        for (int i = this.f12523x - 1; -1 < i; i--) {
            if (!collection.contains(this.f12522w[i])) {
                a(i);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f12523x;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return sd.i.k(this.f12522w, 0, this.f12523x);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12523x * 14);
        sb.append('{');
        int i = this.f12523x;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object obj = this.f12522w[i10];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        ge.i.e(objArr, "array");
        int i = this.f12523x;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        sd.i.h(0, 0, this.f12523x, this.f12522w, objArr);
        return objArr;
    }
}
