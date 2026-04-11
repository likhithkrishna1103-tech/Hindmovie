package aa;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends m0 {
    public static final h1 A = new h1(null, new Object[0], 0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object f678x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object[] f679y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient int f680z;

    public h1(Object obj, Object[] objArr, int i) {
        this.f678x = obj;
        this.f679y = objArr;
        this.f680z = i;
    }

    public static Object f(Object[] objArr, int i, int i10, int i11) {
        int i12;
        k0 k0Var = null;
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
                int iR = q.r(obj.hashCode());
                while (true) {
                    int i19 = iR & i14;
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
                            k0Var = new k0(obj, obj2, obj3);
                            objArr[i21] = obj2;
                            break;
                        }
                        iR = i19 + 1;
                    }
                }
            }
            return i15 == i ? bArr : new Object[]{bArr, Integer.valueOf(i15), k0Var};
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
                int iR2 = q.r(obj4.hashCode());
                while (true) {
                    int i26 = iR2 & i14;
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
                            k0Var = new k0(obj4, obj5, obj6);
                            objArr[i28] = obj5;
                            break;
                        }
                        iR2 = i26 + 1;
                    }
                }
            }
            return i22 == i ? sArr : new Object[]{sArr, Integer.valueOf(i22), k0Var};
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
            int iR3 = q.r(obj7.hashCode());
            while (true) {
                int i33 = iR3 & i14;
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
                        k0Var = new k0(obj7, obj8, obj9);
                        objArr[i35] = obj8;
                        break;
                    }
                    iR3 = i33 + 1;
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
        objArr2[2] = k0Var;
        return objArr2;
    }

    public static Object g(Object obj, Object[] objArr, int i, int i10, Object obj2) {
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
            int iR = q.r(obj2.hashCode());
            while (true) {
                int i11 = iR & length;
                int i12 = bArr[i11] & 255;
                if (i12 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i12])) {
                    return objArr[i12 ^ 1];
                }
                iR = i11 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iR2 = q.r(obj2.hashCode());
            while (true) {
                int i13 = iR2 & length2;
                int i14 = sArr[i13] & 65535;
                if (i14 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i14])) {
                    return objArr[i14 ^ 1];
                }
                iR2 = i13 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iR3 = q.r(obj2.hashCode());
            while (true) {
                int i15 = iR3 & length3;
                int i16 = iArr[i15];
                if (i16 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i16])) {
                    return objArr[i16 ^ 1];
                }
                iR3 = i15 + 1;
            }
        }
    }

    @Override // aa.m0
    public final e1 b() {
        return new e1(this, this.f679y, 0, this.f680z);
    }

    @Override // aa.m0
    public final f1 c() {
        return new f1(this, new g1(this.f679y, 0, this.f680z));
    }

    @Override // aa.m0
    public final e0 d() {
        return new g1(this.f679y, 1, this.f680z);
    }

    @Override // aa.m0, java.util.Map
    public final Object get(Object obj) {
        Object objG = g(this.f678x, this.f679y, this.f680z, 0, obj);
        if (objG == null) {
            return null;
        }
        return objG;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f680z;
    }
}
