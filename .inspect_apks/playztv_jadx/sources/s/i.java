package s;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int[] f11633u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f11634v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11635w;

    public i(int i) {
        this.f11633u = i == 0 ? t.a.f11959a : new int[i];
        this.f11634v = i == 0 ? t.a.f11961c : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.f11635w * 2;
        Object[] objArr = this.f11634v;
        if (obj == null) {
            for (int i10 = 1; i10 < i; i10 += 2) {
                if (objArr[i10] == null) {
                    return i10 >> 1;
                }
            }
            return -1;
        }
        for (int i11 = 1; i11 < i; i11 += 2) {
            if (obj.equals(objArr[i11])) {
                return i11 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i10 = this.f11635w;
        int[] iArr = this.f11633u;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            be.h.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f11633u = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11634v, i * 2);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11634v = objArrCopyOf;
        }
        if (this.f11635w != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i10 = this.f11635w;
        if (i10 == 0) {
            return -1;
        }
        int iA = t.a.a(i10, i, this.f11633u);
        if (iA < 0 || be.h.a(obj, this.f11634v[iA << 1])) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f11633u[i11] == i) {
            if (be.h.a(obj, this.f11634v[i11 << 1])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f11633u[i12] == i; i12--) {
            if (be.h.a(obj, this.f11634v[i12 << 1])) {
                return i12;
            }
        }
        return ~i11;
    }

    public void clear() {
        if (this.f11635w > 0) {
            this.f11633u = t.a.f11959a;
            this.f11634v = t.a.f11961c;
            this.f11635w = 0;
        }
        if (this.f11635w > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i = this.f11635w;
        if (i == 0) {
            return -1;
        }
        int iA = t.a.a(i, 0, this.f11633u);
        if (iA < 0 || this.f11634v[iA << 1] == null) {
            return iA;
        }
        int i10 = iA + 1;
        while (i10 < i && this.f11633u[i10] == 0) {
            if (this.f11634v[i10 << 1] == null) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iA - 1; i11 >= 0 && this.f11633u[i11] == 0; i11--) {
            if (this.f11634v[i11 << 1] == null) {
                return i11;
            }
        }
        return ~i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof i) {
                int i = this.f11635w;
                if (i != ((i) obj).f11635w) {
                    return false;
                }
                i iVar = (i) obj;
                for (int i10 = 0; i10 < i; i10++) {
                    Object objF = f(i10);
                    Object objJ = j(i10);
                    Object obj2 = iVar.get(objF);
                    if (objJ == null) {
                        if (obj2 != null || !iVar.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objJ.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f11635w != ((Map) obj).size()) {
                return false;
            }
            int i11 = this.f11635w;
            for (int i12 = 0; i12 < i11; i12++) {
                Object objF2 = f(i12);
                Object objJ2 = j(i12);
                Object obj3 = ((Map) obj).get(objF2);
                if (objJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objJ2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        if (i < 0 || i >= this.f11635w) {
            throw new IllegalArgumentException(e6.j.l("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        return this.f11634v[i << 1];
    }

    public void g(e eVar) {
        int i = eVar.f11635w;
        b(this.f11635w + i);
        if (this.f11635w != 0) {
            for (int i10 = 0; i10 < i; i10++) {
                put(eVar.f(i10), eVar.j(i10));
            }
        } else if (i > 0) {
            od.h.S(0, 0, i, eVar.f11633u, this.f11633u);
            od.h.T(0, 0, i << 1, eVar.f11634v, this.f11634v);
            this.f11635w = i;
        }
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f11634v[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f11634v[(iD << 1) + 1] : obj2;
    }

    public Object h(int i) {
        int i10;
        if (i < 0 || i >= (i10 = this.f11635w)) {
            throw new IllegalArgumentException(e6.j.l("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        Object[] objArr = this.f11634v;
        int i11 = i << 1;
        Object obj = objArr[i11 + 1];
        if (i10 <= 1) {
            clear();
            return obj;
        }
        int i12 = i10 - 1;
        int[] iArr = this.f11633u;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i < i12) {
                int i13 = i + 1;
                od.h.S(i, i13, i10, iArr, iArr);
                Object[] objArr2 = this.f11634v;
                od.h.T(i11, i13 << 1, i10 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f11634v;
            int i14 = i12 << 1;
            objArr3[i14] = null;
            objArr3[i14 + 1] = null;
        } else {
            int i15 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
            be.h.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f11633u = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11634v, i15 << 1);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11634v = objArrCopyOf;
            if (i10 != this.f11635w) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                od.h.S(0, 0, i, iArr, this.f11633u);
                od.h.T(0, 0, i11, objArr, this.f11634v);
            }
            if (i < i12) {
                int i16 = i + 1;
                od.h.S(i, i16, i10, iArr, this.f11633u);
                od.h.T(i11, i16 << 1, i10 << 1, objArr, this.f11634v);
            }
        }
        if (i10 != this.f11635w) {
            throw new ConcurrentModificationException();
        }
        this.f11635w = i12;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f11633u;
        Object[] objArr = this.f11634v;
        int i = this.f11635w;
        int i10 = 1;
        int i11 = 0;
        int iHashCode = 0;
        while (i11 < i) {
            Object obj = objArr[i10];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i11];
            i11++;
            i10 += 2;
        }
        return iHashCode;
    }

    public Object i(int i, Object obj) {
        if (i < 0 || i >= this.f11635w) {
            throw new IllegalArgumentException(e6.j.l("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        int i10 = (i << 1) + 1;
        Object[] objArr = this.f11634v;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.f11635w <= 0;
    }

    public final Object j(int i) {
        if (i < 0 || i >= this.f11635w) {
            throw new IllegalArgumentException(e6.j.l("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        return this.f11634v[(i << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i = this.f11635w;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i10 = (iC << 1) + 1;
            Object[] objArr = this.f11634v;
            Object obj3 = objArr[i10];
            objArr[i10] = obj2;
            return obj3;
        }
        int i11 = ~iC;
        int[] iArr = this.f11633u;
        if (i >= iArr.length) {
            int i12 = 8;
            if (i >= 8) {
                i12 = (i >> 1) + i;
            } else if (i < 4) {
                i12 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i12);
            be.h.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f11633u = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11634v, i12 << 1);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11634v = objArrCopyOf;
            if (i != this.f11635w) {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < i) {
            int[] iArr2 = this.f11633u;
            int i13 = i11 + 1;
            od.h.S(i13, i11, i, iArr2, iArr2);
            Object[] objArr2 = this.f11634v;
            od.h.T(i13 << 1, i11 << 1, this.f11635w << 1, objArr2, objArr2);
        }
        int i14 = this.f11635w;
        if (i == i14) {
            int[] iArr3 = this.f11633u;
            if (i11 < iArr3.length) {
                iArr3[i11] = iHashCode;
                Object[] objArr3 = this.f11634v;
                int i15 = i11 << 1;
                objArr3[i15] = obj;
                objArr3[i15 + 1] = obj2;
                this.f11635w = i14 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return i(iD, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f11635w;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11635w * 28);
        sb2.append('{');
        int i = this.f11635w;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object objF = f(i10);
            if (objF != sb2) {
                sb2.append(objF);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object objJ = j(i10);
            if (objJ != sb2) {
                sb2.append(objJ);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        be.h.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !be.h.a(obj2, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !be.h.a(obj2, j(iD))) {
            return false;
        }
        i(iD, obj3);
        return true;
    }
}
