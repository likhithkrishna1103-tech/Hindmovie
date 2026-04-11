package pd;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Map, Serializable, ce.b {
    public static final f H;
    public int A;
    public int B;
    public int C;
    public g D;
    public h E;
    public g F;
    public boolean G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object[] f10354u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f10355v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f10356w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f10357x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10358y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10359z;

    static {
        f fVar = new f(0);
        fVar.G = true;
        H = fVar;
    }

    public f() {
        this(8);
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int i = i(obj);
            int i10 = this.f10358y * 2;
            int length = this.f10357x.length / 2;
            if (i10 > length) {
                i10 = length;
            }
            int i11 = 0;
            while (true) {
                int[] iArr = this.f10357x;
                int i12 = iArr[i];
                if (i12 <= 0) {
                    int i13 = this.f10359z;
                    Object[] objArr = this.f10354u;
                    if (i13 < objArr.length) {
                        int i14 = i13 + 1;
                        this.f10359z = i14;
                        objArr[i13] = obj;
                        this.f10356w[i13] = i;
                        iArr[i] = i14;
                        this.C++;
                        this.B++;
                        if (i11 > this.f10358y) {
                            this.f10358y = i11;
                        }
                        return i13;
                    }
                    f(1);
                } else {
                    if (be.h.a(this.f10354u[i12 - 1], obj)) {
                        return -i12;
                    }
                    i11++;
                    if (i11 > i10) {
                        j(this.f10357x.length * 2);
                        break;
                    }
                    i = i == 0 ? this.f10357x.length - 1 : i - 1;
                }
            }
        }
    }

    public final void b() {
        if (this.G) {
            throw new UnsupportedOperationException();
        }
    }

    public final void c(boolean z2) {
        int i;
        Object[] objArr = this.f10355v;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i = this.f10359z;
            if (i10 >= i) {
                break;
            }
            int[] iArr = this.f10356w;
            int i12 = iArr[i10];
            if (i12 >= 0) {
                Object[] objArr2 = this.f10354u;
                objArr2[i11] = objArr2[i10];
                if (objArr != null) {
                    objArr[i11] = objArr[i10];
                }
                if (z2) {
                    iArr[i11] = i12;
                    this.f10357x[i12] = i11 + 1;
                }
                i11++;
            }
            i10++;
        }
        i5.a.I(this.f10354u, i11, i);
        if (objArr != null) {
            i5.a.I(objArr, i11, this.f10359z);
        }
        this.f10359z = i11;
    }

    @Override // java.util.Map
    public final void clear() {
        b();
        int i = this.f10359z - 1;
        if (i >= 0) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f10356w;
                int i11 = iArr[i10];
                if (i11 >= 0) {
                    this.f10357x[i11] = 0;
                    iArr[i10] = -1;
                }
                if (i10 == i) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        i5.a.I(this.f10354u, 0, this.f10359z);
        Object[] objArr = this.f10355v;
        if (objArr != null) {
            i5.a.I(objArr, 0, this.f10359z);
        }
        this.C = 0;
        this.f10359z = 0;
        this.B++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public final boolean d(Collection collection) {
        be.h.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!e((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean e(Map.Entry entry) {
        be.h.e(entry, "entry");
        int iG = g(entry.getKey());
        if (iG < 0) {
            return false;
        }
        Object[] objArr = this.f10355v;
        be.h.b(objArr);
        return be.h.a(objArr[iG], entry.getValue());
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.F;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.F = gVar2;
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
        return this.C == map.size() && d(map.entrySet());
    }

    public final void f(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f10354u;
        int length = objArr.length;
        int i10 = this.f10359z;
        int i11 = length - i10;
        int i12 = i10 - this.C;
        if (i11 < i && i11 + i12 >= i && i12 >= objArr.length / 4) {
            c(true);
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
            be.h.d(objArrCopyOf2, "copyOf(...)");
            this.f10354u = objArrCopyOf2;
            Object[] objArr2 = this.f10355v;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i14);
                be.h.d(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.f10355v = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f10356w, i14);
            be.h.d(iArrCopyOf, "copyOf(...)");
            this.f10356w = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i14 >= 1 ? i14 : 1) * 3);
            if (iHighestOneBit > this.f10357x.length) {
                j(iHighestOneBit);
            }
        }
    }

    public final int g(Object obj) {
        int i = i(obj);
        int i10 = this.f10358y;
        while (true) {
            int i11 = this.f10357x[i];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (be.h.a(this.f10354u[i12], obj)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            i = i == 0 ? this.f10357x.length - 1 : i - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f10355v;
        be.h.b(objArr);
        return objArr[iG];
    }

    public final int h(Object obj) {
        int i = this.f10359z;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f10356w[i] >= 0) {
                Object[] objArr = this.f10355v;
                be.h.b(objArr);
                if (be.h.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i = 0;
        while (dVar.hasNext()) {
            int i10 = dVar.f4691u;
            f fVar = (f) dVar.f4694x;
            if (i10 >= fVar.f10359z) {
                throw new NoSuchElementException();
            }
            dVar.f4691u = i10 + 1;
            dVar.f4692v = i10;
            Object obj = fVar.f10354u[i10];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f10355v;
            be.h.b(objArr);
            Object obj2 = objArr[dVar.f4692v];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.e();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.A;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.C == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f10356w[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r6) {
        /*
            r5 = this;
            int r0 = r5.B
            int r0 = r0 + 1
            r5.B = r0
            int r0 = r5.f10359z
            int r1 = r5.C
            r2 = 0
            if (r0 <= r1) goto L10
            r5.c(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f10357x = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.A = r6
        L1c:
            int r6 = r5.f10359z
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f10354u
            r0 = r0[r2]
            int r0 = r5.i(r0)
            int r1 = r5.f10358y
        L2c:
            int[] r3 = r5.f10357x
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f10356w
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
        throw new UnsupportedOperationException("Method not decompiled: pd.f.j(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f10354u
            java.lang.String r1 = "<this>"
            be.h.e(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f10355v
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f10356w
            r0 = r0[r12]
            int r1 = r11.f10358y
            int r1 = r1 * 2
            int[] r2 = r11.f10357x
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
            int[] r0 = r11.f10357x
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.f10358y
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.f10357x
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.f10357x
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
            java.lang.Object[] r5 = r11.f10354u
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.i(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f10357x
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f10356w
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.f10357x
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f10356w
            r0[r12] = r6
            int r12 = r11.C
            int r12 = r12 + r6
            r11.C = r12
            int r12 = r11.B
            int r12 = r12 + 1
            r11.B = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pd.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.D;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.D = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        int iA = a(obj);
        Object[] objArr = this.f10355v;
        if (objArr == null) {
            int length = this.f10354u.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f10355v = objArr;
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
        be.h.e(map, "from");
        b();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        f(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f10355v;
            if (objArr == null) {
                int length = this.f10354u.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f10355v = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!be.h.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b();
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f10355v;
        be.h.b(objArr);
        Object obj2 = objArr[iG];
        k(iG);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.C;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.C * 3) + 2);
        sb2.append("{");
        int i = 0;
        d dVar = new d(this, 0);
        while (dVar.hasNext()) {
            if (i > 0) {
                sb2.append(", ");
            }
            int i10 = dVar.f4691u;
            f fVar = (f) dVar.f4694x;
            if (i10 >= fVar.f10359z) {
                throw new NoSuchElementException();
            }
            dVar.f4691u = i10 + 1;
            dVar.f4692v = i10;
            Object obj = fVar.f10354u[i10];
            if (obj == fVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = fVar.f10355v;
            be.h.b(objArr);
            Object obj2 = objArr[dVar.f4692v];
            if (obj2 == fVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            dVar.e();
            i++;
        }
        sb2.append("}");
        String string = sb2.toString();
        be.h.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.E;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.E = hVar2;
        return hVar2;
    }

    public f(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f10354u = objArr;
        this.f10355v = null;
        this.f10356w = iArr;
        this.f10357x = new int[iHighestOneBit];
        this.f10358y = 2;
        this.f10359z = 0;
        this.A = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
