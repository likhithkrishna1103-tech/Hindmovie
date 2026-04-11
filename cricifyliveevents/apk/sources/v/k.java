package v;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f12540v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f12541w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12542x;

    public k(int i) {
        this.f12540v = i == 0 ? w.a.f13743a : new int[i];
        this.f12541w = i == 0 ? w.a.f13745c : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.f12542x * 2;
        Object[] objArr = this.f12541w;
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
        int i10 = this.f12542x;
        int[] iArr = this.f12540v;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            this.f12540v = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12541w, i * 2);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12541w = objArrCopyOf;
        }
        if (this.f12542x != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i10 = this.f12542x;
        if (i10 == 0) {
            return -1;
        }
        int iA = w.a.a(i10, i, this.f12540v);
        if (iA < 0 || ge.i.a(obj, this.f12541w[iA << 1])) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f12540v[i11] == i) {
            if (ge.i.a(obj, this.f12541w[i11 << 1])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f12540v[i12] == i; i12--) {
            if (ge.i.a(obj, this.f12541w[i12 << 1])) {
                return i12;
            }
        }
        return ~i11;
    }

    public void clear() {
        if (this.f12542x > 0) {
            this.f12540v = w.a.f13743a;
            this.f12541w = w.a.f13745c;
            this.f12542x = 0;
        }
        if (this.f12542x > 0) {
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
        int i = this.f12542x;
        if (i == 0) {
            return -1;
        }
        int iA = w.a.a(i, 0, this.f12540v);
        if (iA < 0 || this.f12541w[iA << 1] == null) {
            return iA;
        }
        int i10 = iA + 1;
        while (i10 < i && this.f12540v[i10] == 0) {
            if (this.f12541w[i10 << 1] == null) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iA - 1; i11 >= 0 && this.f12540v[i11] == 0; i11--) {
            if (this.f12541w[i11 << 1] == null) {
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
            if (obj instanceof k) {
                int i = this.f12542x;
                if (i != ((k) obj).f12542x) {
                    return false;
                }
                k kVar = (k) obj;
                for (int i10 = 0; i10 < i; i10++) {
                    Object objF = f(i10);
                    Object objJ = j(i10);
                    Object obj2 = kVar.get(objF);
                    if (objJ == null) {
                        if (obj2 != null || !kVar.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objJ.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f12542x != ((Map) obj).size()) {
                return false;
            }
            int i11 = this.f12542x;
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
        boolean z10 = false;
        if (i >= 0 && i < this.f12542x) {
            z10 = true;
        }
        if (z10) {
            return this.f12541w[i << 1];
        }
        w.a.c("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public void g(e eVar) {
        int i = eVar.f12542x;
        b(this.f12542x + i);
        if (this.f12542x != 0) {
            for (int i10 = 0; i10 < i; i10++) {
                put(eVar.f(i10), eVar.j(i10));
            }
        } else if (i > 0) {
            sd.i.g(0, 0, i, eVar.f12540v, this.f12540v);
            sd.i.h(0, 0, i << 1, eVar.f12541w, this.f12541w);
            this.f12542x = i;
        }
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f12541w[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f12541w[(iD << 1) + 1] : obj2;
    }

    public Object h(int i) {
        int i10;
        if (i < 0 || i >= (i10 = this.f12542x)) {
            w.a.c("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        Object[] objArr = this.f12541w;
        int i11 = i << 1;
        Object obj = objArr[i11 + 1];
        if (i10 <= 1) {
            clear();
            return obj;
        }
        int i12 = i10 - 1;
        int[] iArr = this.f12540v;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i < i12) {
                int i13 = i + 1;
                sd.i.g(i, i13, i10, iArr, iArr);
                Object[] objArr2 = this.f12541w;
                sd.i.h(i11, i13 << 1, i10 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f12541w;
            int i14 = i12 << 1;
            objArr3[i14] = null;
            objArr3[i14 + 1] = null;
        } else {
            int i15 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            this.f12540v = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12541w, i15 << 1);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12541w = objArrCopyOf;
            if (i10 != this.f12542x) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                sd.i.g(0, 0, i, iArr, this.f12540v);
                sd.i.h(0, 0, i11, objArr, this.f12541w);
            }
            if (i < i12) {
                int i16 = i + 1;
                sd.i.g(i, i16, i10, iArr, this.f12540v);
                sd.i.h(i11, i16 << 1, i10 << 1, objArr, this.f12541w);
            }
        }
        if (i10 != this.f12542x) {
            throw new ConcurrentModificationException();
        }
        this.f12542x = i12;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f12540v;
        Object[] objArr = this.f12541w;
        int i = this.f12542x;
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
        boolean z10 = false;
        if (i >= 0 && i < this.f12542x) {
            z10 = true;
        }
        if (!z10) {
            w.a.c("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        int i10 = (i << 1) + 1;
        Object[] objArr = this.f12541w;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.f12542x <= 0;
    }

    public final Object j(int i) {
        boolean z10 = false;
        if (i >= 0 && i < this.f12542x) {
            z10 = true;
        }
        if (z10) {
            return this.f12541w[(i << 1) + 1];
        }
        w.a.c("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public Object put(Object obj, Object obj2) {
        int i = this.f12542x;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i10 = (iC << 1) + 1;
            Object[] objArr = this.f12541w;
            Object obj3 = objArr[i10];
            objArr[i10] = obj2;
            return obj3;
        }
        int i11 = ~iC;
        int[] iArr = this.f12540v;
        if (i >= iArr.length) {
            int i12 = 8;
            if (i >= 8) {
                i12 = (i >> 1) + i;
            } else if (i < 4) {
                i12 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i12);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            this.f12540v = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12541w, i12 << 1);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12541w = objArrCopyOf;
            if (i != this.f12542x) {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < i) {
            int[] iArr2 = this.f12540v;
            int i13 = i11 + 1;
            sd.i.g(i13, i11, i, iArr2, iArr2);
            Object[] objArr2 = this.f12541w;
            sd.i.h(i13 << 1, i11 << 1, this.f12542x << 1, objArr2, objArr2);
        }
        int i14 = this.f12542x;
        if (i == i14) {
            int[] iArr3 = this.f12540v;
            if (i11 < iArr3.length) {
                iArr3[i11] = iHashCode;
                Object[] objArr3 = this.f12541w;
                int i15 = i11 << 1;
                objArr3[i15] = obj;
                objArr3[i15 + 1] = obj2;
                this.f12542x = i14 + 1;
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
        return this.f12542x;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12542x * 28);
        sb.append('{');
        int i = this.f12542x;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object objF = f(i10);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i10);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !ge.i.a(obj2, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !ge.i.a(obj2, j(iD))) {
            return false;
        }
        i(iD, obj3);
        return true;
    }
}
