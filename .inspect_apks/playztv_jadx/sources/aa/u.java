package aa;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends AbstractMap implements Serializable {
    public static final Object D = new Object();
    public transient s A;
    public transient s B;
    public transient n C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public transient Object f749u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient int[] f750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient Object[] f751w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient Object[] f752x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public transient int f753y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public transient int f754z;

    public static u a(int i) {
        u uVar = new u();
        q1.c.g("Expected size must be >= 0", i >= 0);
        uVar.f753y = Math.min(Math.max(i, 1), 1073741823);
        return uVar;
    }

    public final Map b() {
        Object obj = this.f749u;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int c() {
        return (1 << (this.f753y & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (f()) {
            return;
        }
        this.f753y += 32;
        Map mapB = b();
        if (mapB != null) {
            this.f753y = Math.min(Math.max(size(), 3), 1073741823);
            mapB.clear();
            this.f749u = null;
            this.f754z = 0;
            return;
        }
        Arrays.fill(i(), 0, this.f754z, (Object) null);
        Arrays.fill(j(), 0, this.f754z, (Object) null);
        Object obj = this.f749u;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(h(), 0, this.f754z, 0);
        this.f754z = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapB = b();
        return mapB != null ? mapB.containsKey(obj) : d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapB = b();
        if (mapB != null) {
            return mapB.containsValue(obj);
        }
        for (int i = 0; i < this.f754z; i++) {
            if (i5.a.o(obj, j()[i])) {
                return true;
            }
        }
        return false;
    }

    public final int d(Object obj) {
        if (f()) {
            return -1;
        }
        int iS = q.s(obj);
        int iC = c();
        Object obj2 = this.f749u;
        Objects.requireNonNull(obj2);
        int iT = q.t(iS & iC, obj2);
        if (iT == 0) {
            return -1;
        }
        int i = ~iC;
        int i10 = iS & i;
        do {
            int i11 = iT - 1;
            int i12 = h()[i11];
            if ((i12 & i) == i10 && i5.a.o(obj, i()[i11])) {
                return i11;
            }
            iT = i12 & iC;
        } while (iT != 0);
        return -1;
    }

    public final void e(int i, int i10) {
        Object obj = this.f749u;
        Objects.requireNonNull(obj);
        int[] iArrH = h();
        Object[] objArrI = i();
        Object[] objArrJ = j();
        int size = size();
        int i11 = size - 1;
        if (i >= i11) {
            objArrI[i] = null;
            objArrJ[i] = null;
            iArrH[i] = 0;
            return;
        }
        Object obj2 = objArrI[i11];
        objArrI[i] = obj2;
        objArrJ[i] = objArrJ[i11];
        objArrI[i11] = null;
        objArrJ[i11] = null;
        iArrH[i] = iArrH[i11];
        iArrH[i11] = 0;
        int iS = q.s(obj2) & i10;
        int iT = q.t(iS, obj);
        if (iT == size) {
            q.u(iS, i + 1, obj);
            return;
        }
        while (true) {
            int i12 = iT - 1;
            int i13 = iArrH[i12];
            int i14 = i13 & i10;
            if (i14 == size) {
                iArrH[i12] = q.n(i13, i + 1, i10);
                return;
            }
            iT = i14;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        s sVar = this.B;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 0);
        this.B = sVar2;
        return sVar2;
    }

    public final boolean f() {
        return this.f749u == null;
    }

    public final Object g(Object obj) {
        if (!f()) {
            int iC = c();
            Object obj2 = this.f749u;
            Objects.requireNonNull(obj2);
            int iP = q.p(obj, null, iC, obj2, h(), i(), null);
            if (iP != -1) {
                Object obj3 = j()[iP];
                e(iP, iC);
                this.f754z--;
                this.f753y += 32;
                return obj3;
            }
        }
        return D;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapB = b();
        if (mapB != null) {
            return mapB.get(obj);
        }
        int iD = d(obj);
        if (iD == -1) {
            return null;
        }
        return j()[iD];
    }

    public final int[] h() {
        int[] iArr = this.f750v;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] i() {
        Object[] objArr = this.f751w;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.f752x;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int k(int i, int i10, int i11, int i12) {
        Object objD = q.d(i10);
        int i13 = i10 - 1;
        if (i12 != 0) {
            q.u(i11 & i13, i12 + 1, objD);
        }
        Object obj = this.f749u;
        Objects.requireNonNull(obj);
        int[] iArrH = h();
        for (int i14 = 0; i14 <= i; i14++) {
            int iT = q.t(i14, obj);
            while (iT != 0) {
                int i15 = iT - 1;
                int i16 = iArrH[i15];
                int i17 = ((~i) & i16) | i14;
                int i18 = i17 & i13;
                int iT2 = q.t(i18, objD);
                q.u(i18, iT, objD);
                iArrH[i15] = q.n(i17, iT2, i13);
                iT = i16 & i;
            }
        }
        this.f749u = objD;
        this.f753y = q.n(this.f753y, 32 - Integer.numberOfLeadingZeros(i13), 31);
        return i13;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        s sVar = this.A;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 1);
        this.A = sVar2;
        return sVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00fe -> B:37:0x00e4). Please report as a decompilation issue!!! */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object put(java.lang.Object r23, java.lang.Object r24) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.u.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapB = b();
        if (mapB != null) {
            return mapB.remove(obj);
        }
        Object objG = g(obj);
        if (objG == D) {
            return null;
        }
        return objG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapB = b();
        return mapB != null ? mapB.size() : this.f754z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.C;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(1, this);
        this.C = nVar2;
        return nVar2;
    }
}
