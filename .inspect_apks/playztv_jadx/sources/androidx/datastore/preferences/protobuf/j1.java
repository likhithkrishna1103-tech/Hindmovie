package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {
    public static final j1 f = new j1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f1072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f1073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1074d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1075e;

    public j1(int i, int[] iArr, Object[] objArr, boolean z2) {
        this.f1071a = i;
        this.f1072b = iArr;
        this.f1073c = objArr;
        this.f1075e = z2;
    }

    public static j1 b() {
        return new j1(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iY;
        int iA;
        int iU;
        int i = this.f1074d;
        if (i != -1) {
            return i;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f1071a; i11++) {
            int i12 = this.f1072b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f1073c[i11]).getClass();
                    iU = k.u(i13);
                } else if (i14 == 2) {
                    iU = k.r(i13, (g) this.f1073c[i11]);
                } else if (i14 == 3) {
                    iY = k.y(i13) * 2;
                    iA = ((j1) this.f1073c[i11]).a();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(b0.b());
                    }
                    ((Integer) this.f1073c[i11]).getClass();
                    iU = k.t(i13);
                }
                i10 = iU + i10;
            } else {
                long jLongValue = ((Long) this.f1073c[i11]).longValue();
                iY = k.y(i13);
                iA = k.A(jLongValue);
            }
            i10 = iA + iY + i10;
        }
        this.f1074d = i10;
        return i10;
    }

    public final void c(int i, Object obj) {
        if (!this.f1075e) {
            throw new UnsupportedOperationException();
        }
        int i10 = this.f1071a;
        int[] iArr = this.f1072b;
        if (i10 == iArr.length) {
            int i11 = i10 + (i10 < 4 ? 8 : i10 >> 1);
            this.f1072b = Arrays.copyOf(iArr, i11);
            this.f1073c = Arrays.copyOf(this.f1073c, i11);
        }
        int[] iArr2 = this.f1072b;
        int i12 = this.f1071a;
        iArr2[i12] = i;
        this.f1073c[i12] = obj;
        this.f1071a = i12 + 1;
    }

    public final void d(k0 k0Var) throws IOException {
        if (this.f1071a == 0) {
            return;
        }
        k0Var.getClass();
        k kVar = (k) k0Var.f1082a;
        for (int i = 0; i < this.f1071a; i++) {
            int i10 = this.f1072b[i];
            Object obj = this.f1073c[i];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                kVar.U(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                kVar.K(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                k0Var.a(i11, (g) obj);
            } else if (i12 == 3) {
                kVar.R(i11, 3);
                ((j1) obj).d(k0Var);
                kVar.R(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(b0.b());
                }
                kVar.I(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        int i = this.f1071a;
        if (i == j1Var.f1071a) {
            int[] iArr = this.f1072b;
            int[] iArr2 = j1Var.f1072b;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    Object[] objArr = this.f1073c;
                    Object[] objArr2 = j1Var.f1073c;
                    int i11 = this.f1071a;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (objArr[i12].equals(objArr2[i12])) {
                        }
                    }
                    return true;
                }
                if (iArr[i10] != iArr2[i10]) {
                    break;
                }
                i10++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f1071a;
        int i10 = (527 + i) * 31;
        int[] iArr = this.f1072b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f1073c;
        int i14 = this.f1071a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
