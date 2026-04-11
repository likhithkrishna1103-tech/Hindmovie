package ua;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends AbstractMap implements Serializable {
    public static final Object E = new Object();
    public transient int A;
    public transient s B;
    public transient s C;
    public transient n D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient Object f12394v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient int[] f12395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient Object[] f12396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public transient Object[] f12397y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public transient int f12398z;

    public static u a(int i) {
        u uVar = new u();
        com.bumptech.glide.d.f("Expected size must be >= 0", i >= 0);
        uVar.f12398z = Math.min(Math.max(i, 1), 1073741823);
        return uVar;
    }

    public final Map b() {
        Object obj = this.f12394v;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int c() {
        return (1 << (this.f12398z & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (f()) {
            return;
        }
        this.f12398z += 32;
        Map mapB = b();
        if (mapB != null) {
            this.f12398z = Math.min(Math.max(size(), 3), 1073741823);
            mapB.clear();
            this.f12394v = null;
            this.A = 0;
            return;
        }
        Arrays.fill(i(), 0, this.A, (Object) null);
        Arrays.fill(j(), 0, this.A, (Object) null);
        Object obj = this.f12394v;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(h(), 0, this.A, 0);
        this.A = 0;
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
        for (int i = 0; i < this.A; i++) {
            if (com.bumptech.glide.c.h(obj, j()[i])) {
                return true;
            }
        }
        return false;
    }

    public final int d(Object obj) {
        if (f()) {
            return -1;
        }
        int iT = q.t(obj);
        int iC = c();
        Object obj2 = this.f12394v;
        Objects.requireNonNull(obj2);
        int iU = q.u(iT & iC, obj2);
        if (iU == 0) {
            return -1;
        }
        int i = ~iC;
        int i10 = iT & i;
        do {
            int i11 = iU - 1;
            int i12 = h()[i11];
            if ((i12 & i) == i10 && com.bumptech.glide.c.h(obj, i()[i11])) {
                return i11;
            }
            iU = i12 & iC;
        } while (iU != 0);
        return -1;
    }

    public final void e(int i, int i10) {
        Object obj = this.f12394v;
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
        int iT = q.t(obj2) & i10;
        int iU = q.u(iT, obj);
        if (iU == size) {
            q.v(iT, i + 1, obj);
            return;
        }
        while (true) {
            int i12 = iU - 1;
            int i13 = iArrH[i12];
            int i14 = i13 & i10;
            if (i14 == size) {
                iArrH[i12] = q.o(i13, i + 1, i10);
                return;
            }
            iU = i14;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        s sVar = this.C;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 0);
        this.C = sVar2;
        return sVar2;
    }

    public final boolean f() {
        return this.f12394v == null;
    }

    public final Object g(Object obj) {
        if (!f()) {
            int iC = c();
            Object obj2 = this.f12394v;
            Objects.requireNonNull(obj2);
            int iQ = q.q(obj, null, iC, obj2, h(), i(), null);
            if (iQ != -1) {
                Object obj3 = j()[iQ];
                e(iQ, iC);
                this.A--;
                this.f12398z += 32;
                return obj3;
            }
        }
        return E;
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
        int[] iArr = this.f12395w;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] i() {
        Object[] objArr = this.f12396x;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.f12397y;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int k(int i, int i10, int i11, int i12) {
        Object objE = q.e(i10);
        int i13 = i10 - 1;
        if (i12 != 0) {
            q.v(i11 & i13, i12 + 1, objE);
        }
        Object obj = this.f12394v;
        Objects.requireNonNull(obj);
        int[] iArrH = h();
        for (int i14 = 0; i14 <= i; i14++) {
            int iU = q.u(i14, obj);
            while (iU != 0) {
                int i15 = iU - 1;
                int i16 = iArrH[i15];
                int i17 = ((~i) & i16) | i14;
                int i18 = i17 & i13;
                int iU2 = q.u(i18, objE);
                q.v(i18, iU, objE);
                iArrH[i15] = q.o(i17, iU2, i13);
                iU = i16 & i;
            }
        }
        this.f12394v = objE;
        this.f12398z = q.o(this.f12398z, 32 - Integer.numberOfLeadingZeros(i13), 31);
        return i13;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        s sVar = this.B;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 1);
        this.B = sVar2;
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
        throw new UnsupportedOperationException("Method not decompiled: ua.u.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapB = b();
        if (mapB != null) {
            return mapB.remove(obj);
        }
        Object objG = g(obj);
        if (objG == E) {
            return null;
        }
        return objG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapB = b();
        return mapB != null ? mapB.size() : this.A;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.D;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(1, this);
        this.D = nVar2;
        return nVar2;
    }
}
