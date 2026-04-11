package td;

import com.google.android.gms.internal.measurement.z3;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Map, Serializable, he.b {
    public static final f I;
    public int A;
    public int B;
    public int C;
    public int D;
    public g E;
    public h F;
    public g G;
    public boolean H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f12006v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object[] f12007w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f12008x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f12009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12010z;

    static {
        f fVar = new f(0);
        fVar.H = true;
        I = fVar;
    }

    public f() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int iJ = j(obj);
            int i = this.f12010z * 2;
            int length = this.f12009y.length / 2;
            if (i > length) {
                i = length;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.f12009y;
                int i11 = iArr[iJ];
                if (i11 <= 0) {
                    int i12 = this.A;
                    Object[] objArr = this.f12006v;
                    if (i12 < objArr.length) {
                        int i13 = i12 + 1;
                        this.A = i13;
                        objArr[i12] = obj;
                        this.f12008x[i12] = iJ;
                        iArr[iJ] = i13;
                        this.D++;
                        this.C++;
                        if (i10 > this.f12010z) {
                            this.f12010z = i10;
                        }
                        return i12;
                    }
                    g(1);
                } else {
                    if (ge.i.a(this.f12006v[i11 - 1], obj)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > i) {
                        k(this.f12009y.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.f12009y.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final f b() {
        c();
        this.H = true;
        if (this.D > 0) {
            return this;
        }
        f fVar = I;
        ge.i.c(fVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return fVar;
    }

    public final void c() {
        if (this.H) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i = this.A - 1;
        if (i >= 0) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f12008x;
                int i11 = iArr[i10];
                if (i11 >= 0) {
                    this.f12009y[i11] = 0;
                    iArr[i10] = -1;
                }
                if (i10 == i) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        z3.t(this.f12006v, 0, this.A);
        Object[] objArr = this.f12007w;
        if (objArr != null) {
            z3.t(objArr, 0, this.A);
        }
        this.D = 0;
        this.A = 0;
        this.C++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d(boolean z10) {
        int i;
        Object[] objArr = this.f12007w;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i = this.A;
            if (i10 >= i) {
                break;
            }
            int[] iArr = this.f12008x;
            int i12 = iArr[i10];
            if (i12 >= 0) {
                Object[] objArr2 = this.f12006v;
                objArr2[i11] = objArr2[i10];
                if (objArr != null) {
                    objArr[i11] = objArr[i10];
                }
                if (z10) {
                    iArr[i11] = i12;
                    this.f12009y[i12] = i11 + 1;
                }
                i11++;
            }
            i10++;
        }
        z3.t(this.f12006v, i11, i);
        if (objArr != null) {
            z3.t(objArr, i11, this.A);
        }
        this.A = i11;
    }

    public final boolean e(Collection collection) {
        ge.i.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!f((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.G;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.G = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.D == map.size() && e(map.entrySet());
    }

    public final boolean f(Map.Entry entry) {
        ge.i.e(entry, "entry");
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.f12007w;
        ge.i.b(objArr);
        return ge.i.a(objArr[iH], entry.getValue());
    }

    public final void g(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f12006v;
        int length = objArr.length;
        int i10 = this.A;
        int i11 = length - i10;
        int i12 = i10 - this.D;
        if (i11 < i && i11 + i12 >= i && i12 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i13 = i10 + i;
        if (i13 < 0) {
            throw new OutOfMemoryError();
        }
        if (i13 > objArr.length) {
            int length2 = objArr.length;
            int i14 = length2 + (length2 >> 1);
            if (i14 - i13 < 0) {
                i14 = i13;
            }
            if (i14 - 2147483639 > 0) {
                i14 = i13 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i14);
            ge.i.d(objArrCopyOf2, "copyOf(...)");
            this.f12006v = objArrCopyOf2;
            Object[] objArr2 = this.f12007w;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i14);
                ge.i.d(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.f12007w = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f12008x, i14);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            this.f12008x = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i14 >= 1 ? i14 : 1) * 3);
            if (iHighestOneBit > this.f12009y.length) {
                k(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f12007w;
        ge.i.b(objArr);
        return objArr[iH];
    }

    public final int h(Object obj) {
        int iJ = j(obj);
        int i = this.f12010z;
        while (true) {
            int i10 = this.f12009y[iJ];
            if (i10 == 0) {
                return -1;
            }
            if (i10 > 0) {
                int i11 = i10 - 1;
                if (ge.i.a(this.f12006v[i11], obj)) {
                    return i11;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.f12009y.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i = 0;
        while (dVar.hasNext()) {
            int i10 = dVar.f7624v;
            f fVar = (f) dVar.f7627y;
            if (i10 >= fVar.A) {
                throw new NoSuchElementException();
            }
            dVar.f7624v = i10 + 1;
            dVar.f7625w = i10;
            Object obj = fVar.f12006v[i10];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f12007w;
            ge.i.b(objArr);
            Object obj2 = objArr[dVar.f7625w];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.e();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        int i = this.A;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f12008x[i] >= 0) {
                Object[] objArr = this.f12007w;
                ge.i.b(objArr);
                if (ge.i.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.D == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.B;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f12008x[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.C
            int r0 = r0 + 1
            r5.C = r0
            int r0 = r5.A
            int r1 = r5.D
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f12009y = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.B = r6
        L1c:
            int r6 = r5.A
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f12006v
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.f12010z
        L2c:
            int[] r3 = r5.f12009y
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f12008x
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: td.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.E;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.E = gVar2;
        return gVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f12006v
            java.lang.String r1 = "<this>"
            ge.i.e(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f12007w
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f12008x
            r0 = r0[r12]
            int r1 = r11.f12010z
            int r1 = r1 * 2
            int[] r2 = r11.f12009y
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L20
            r1 = r2
        L20:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L24:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2e
            int[] r0 = r11.f12009y
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.f12010z
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.f12009y
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.f12009y
            r7 = r5[r0]
            if (r7 != 0) goto L44
            r5[r1] = r2
            goto L6c
        L44:
            if (r7 >= 0) goto L4b
            r5[r1] = r6
        L48:
            r1 = r0
            r4 = r2
            goto L65
        L4b:
            java.lang.Object[] r5 = r11.f12006v
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f12009y
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f12008x
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.f12009y
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f12008x
            r0[r12] = r6
            int r12 = r11.D
            int r12 = r12 + r6
            r11.D = r12
            int r12 = r11.C
            int r12 = r12 + 1
            r11.C = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: td.f.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f12007w;
        if (objArr == null) {
            int length = this.f12006v.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f12007w = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        ge.i.e(map, "from");
        c();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        g(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f12007w;
            if (objArr == null) {
                int length = this.f12006v.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f12007w = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!ge.i.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f12007w;
        ge.i.b(objArr);
        Object obj2 = objArr[iH];
        l(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.D;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.D * 3) + 2);
        sb.append("{");
        int i = 0;
        d dVar = new d(this, 0);
        while (dVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i10 = dVar.f7624v;
            f fVar = (f) dVar.f7627y;
            if (i10 >= fVar.A) {
                throw new NoSuchElementException();
            }
            dVar.f7624v = i10 + 1;
            dVar.f7625w = i10;
            Object obj = fVar.f12006v[i10];
            if (obj == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = fVar.f12007w;
            ge.i.b(objArr);
            Object obj2 = objArr[dVar.f7625w];
            if (obj2 == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            dVar.e();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.F;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.F = hVar2;
        return hVar2;
    }

    public f(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f12006v = objArr;
        this.f12007w = null;
        this.f12008x = iArr;
        this.f12009y = new int[iHighestOneBit];
        this.f12010z = 2;
        this.A = 0;
        this.B = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
