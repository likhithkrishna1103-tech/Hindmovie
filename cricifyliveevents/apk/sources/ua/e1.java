package ua;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends k0 {
    public static final e1 B = new e1(null, new Object[0], 0);
    public final transient int A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object f12326y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient Object[] f12327z;

    public e1(Object obj, Object[] objArr, int i) {
        this.f12326y = obj;
        this.f12327z = objArr;
        this.A = i;
    }

    public static e1 f(int i, Object[] objArr, f3.a aVar) {
        if (i == 0) {
            return B;
        }
        if (i == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new e1(null, objArr, 1);
        }
        com.bumptech.glide.d.i(i, objArr.length >> 1);
        Object objG = g(objArr, i, m0.i(i), 0);
        if (objG instanceof Object[]) {
            Object[] objArr2 = (Object[]) objG;
            j0 j0Var = (j0) objArr2[2];
            if (aVar == null) {
                throw j0Var.a();
            }
            aVar.f3937y = j0Var;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objG = obj;
            i = iIntValue;
        }
        return new e1(objG, objArr, i);
    }

    public static Object g(Object[] objArr, int i, int i10, int i11) {
        int i12;
        j0 j0Var = null;
        int i13 = 1;
        if (i == 1) {
            Objects.requireNonNull(objArr[i11]);
            Objects.requireNonNull(objArr[i11 ^ 1]);
            return null;
        }
        int i14 = i10 - 1;
        if (i10 <= 128) {
            byte[] bArr = new byte[i10];
            Arrays.fill(bArr, (byte) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i; i16++) {
                int i17 = (i16 * 2) + i11;
                int i18 = (i15 * 2) + i11;
                Object obj = objArr[i17];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj2);
                int iS = q.s(obj.hashCode());
                while (true) {
                    int i19 = iS & i14;
                    int i20 = bArr[i19] & 255;
                    if (i20 == 255) {
                        bArr[i19] = (byte) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj;
                            objArr[i18 ^ 1] = obj2;
                        }
                        i15++;
                    } else {
                        if (obj.equals(objArr[i20])) {
                            int i21 = i20 ^ 1;
                            Object obj3 = objArr[i21];
                            Objects.requireNonNull(obj3);
                            j0Var = new j0(obj, obj2, obj3);
                            objArr[i21] = obj2;
                            break;
                        }
                        iS = i19 + 1;
                    }
                }
            }
            return i15 == i ? bArr : new Object[]{bArr, Integer.valueOf(i15), j0Var};
        }
        if (i10 <= 32768) {
            short[] sArr = new short[i10];
            Arrays.fill(sArr, (short) -1);
            int i22 = 0;
            for (int i23 = 0; i23 < i; i23++) {
                int i24 = (i23 * 2) + i11;
                int i25 = (i22 * 2) + i11;
                Object obj4 = objArr[i24];
                Objects.requireNonNull(obj4);
                Object obj5 = objArr[i24 ^ 1];
                Objects.requireNonNull(obj5);
                int iS2 = q.s(obj4.hashCode());
                while (true) {
                    int i26 = iS2 & i14;
                    int i27 = sArr[i26] & 65535;
                    if (i27 == 65535) {
                        sArr[i26] = (short) i25;
                        if (i22 < i23) {
                            objArr[i25] = obj4;
                            objArr[i25 ^ 1] = obj5;
                        }
                        i22++;
                    } else {
                        if (obj4.equals(objArr[i27])) {
                            int i28 = i27 ^ 1;
                            Object obj6 = objArr[i28];
                            Objects.requireNonNull(obj6);
                            j0Var = new j0(obj4, obj5, obj6);
                            objArr[i28] = obj5;
                            break;
                        }
                        iS2 = i26 + 1;
                    }
                }
            }
            return i22 == i ? sArr : new Object[]{sArr, Integer.valueOf(i22), j0Var};
        }
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i) {
            int i31 = (i29 * 2) + i11;
            int i32 = (i30 * 2) + i11;
            Object obj7 = objArr[i31];
            Objects.requireNonNull(obj7);
            Object obj8 = objArr[i31 ^ i13];
            Objects.requireNonNull(obj8);
            int iS3 = q.s(obj7.hashCode());
            while (true) {
                int i33 = iS3 & i14;
                int i34 = iArr[i33];
                if (i34 == -1) {
                    iArr[i33] = i32;
                    if (i30 < i29) {
                        objArr[i32] = obj7;
                        objArr[i32 ^ 1] = obj8;
                    }
                    i30++;
                    i12 = i13;
                } else {
                    i12 = i13;
                    if (obj7.equals(objArr[i34])) {
                        int i35 = i34 ^ 1;
                        Object obj9 = objArr[i35];
                        Objects.requireNonNull(obj9);
                        j0Var = new j0(obj7, obj8, obj9);
                        objArr[i35] = obj8;
                        break;
                    }
                    iS3 = i33 + 1;
                    i13 = i12;
                }
            }
            i29++;
            i13 = i12;
        }
        int i36 = i13;
        if (i30 == i) {
            return iArr;
        }
        Integer numValueOf = Integer.valueOf(i30);
        Object[] objArr2 = new Object[3];
        objArr2[0] = iArr;
        objArr2[i36] = numValueOf;
        objArr2[2] = j0Var;
        return objArr2;
    }

    public static Object h(Object obj, Object[] objArr, int i, int i10, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i10];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i10 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iS = q.s(obj2.hashCode());
            while (true) {
                int i11 = iS & length;
                int i12 = bArr[i11] & 255;
                if (i12 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i12])) {
                    return objArr[i12 ^ 1];
                }
                iS = i11 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iS2 = q.s(obj2.hashCode());
            while (true) {
                int i13 = iS2 & length2;
                int i14 = sArr[i13] & 65535;
                if (i14 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i14])) {
                    return objArr[i14 ^ 1];
                }
                iS2 = i13 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iS3 = q.s(obj2.hashCode());
            while (true) {
                int i15 = iS3 & length3;
                int i16 = iArr[i15];
                if (i16 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i16])) {
                    return objArr[i16 ^ 1];
                }
                iS3 = i15 + 1;
            }
        }
    }

    @Override // ua.k0
    public final b1 b() {
        return new b1(this, this.f12327z, 0, this.A);
    }

    @Override // ua.k0
    public final c1 c() {
        return new c1(this, new d1(this.f12327z, 0, this.A));
    }

    @Override // ua.k0
    public final d0 d() {
        return new d1(this.f12327z, 1, this.A);
    }

    @Override // ua.k0, java.util.Map
    public final Object get(Object obj) {
        Object objH = h(this.f12326y, this.f12327z, this.A, 0, obj);
        if (objH == null) {
            return null;
        }
        return objH;
    }

    @Override // java.util.Map
    public final int size() {
        return this.A;
    }
}
