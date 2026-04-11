package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k6 {
    public static final k6 f = new k6(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f3075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f3076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3077d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3078e;

    public k6(int i, int[] iArr, Object[] objArr, boolean z2) {
        this.f3074a = i;
        this.f3075b = iArr;
        this.f3076c = objArr;
        this.f3078e = z2;
    }

    public static k6 e() {
        return new k6(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iW;
        int iU;
        int i = this.f3077d;
        if (i != -1) {
            return i;
        }
        int iW2 = 0;
        for (int i10 = 0; i10 < this.f3074a; i10++) {
            int i11 = this.f3075b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f3076c[i10]).getClass();
                    iW2 = l4.a.w(i12 << 3, 8, iW2);
                } else if (i13 == 2) {
                    iW2 = b5.p(i12, (a5) this.f3076c[i10]) + iW2;
                } else if (i13 == 3) {
                    iW = b5.v(i12) << 1;
                    iU = ((k6) this.f3076c[i10]).a();
                } else {
                    if (i13 != 5) {
                        int i14 = r5.f3179u;
                        throw new IllegalStateException(new u5("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f3076c[i10]).getClass();
                    iW2 = l4.a.w(i12 << 3, 4, iW2);
                }
            } else {
                long jLongValue = ((Long) this.f3076c[i10]).longValue();
                iW = b5.w(i12 << 3);
                iU = b5.u(jLongValue);
            }
            iW2 = iU + iW + iW2;
        }
        this.f3077d = iW2;
        return iW2;
    }

    public final void b(int i) {
        int[] iArr = this.f3075b;
        if (i > iArr.length) {
            int i10 = this.f3074a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i) {
                i = i11;
            }
            if (i < 8) {
                i = 8;
            }
            this.f3075b = Arrays.copyOf(iArr, i);
            this.f3076c = Arrays.copyOf(this.f3076c, i);
        }
    }

    public final void c(int i, Object obj) {
        if (!this.f3078e) {
            throw new UnsupportedOperationException();
        }
        b(this.f3074a + 1);
        int[] iArr = this.f3075b;
        int i10 = this.f3074a;
        iArr[i10] = i;
        this.f3076c[i10] = obj;
        this.f3074a = i10 + 1;
    }

    public final void d(x5 x5Var) throws c6.c {
        if (this.f3074a == 0) {
            return;
        }
        x5Var.getClass();
        b5 b5Var = (b5) x5Var.f3235a;
        for (int i = 0; i < this.f3074a; i++) {
            int i10 = this.f3075b[i];
            Object obj = this.f3076c[i];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                b5Var.n(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                b5Var.g(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                a5 a5Var = (a5) obj;
                b5Var.r(i11, 2);
                b5Var.q(a5Var.h());
                b5Var.s(a5Var.f2887v, a5Var.i(), a5Var.h());
            } else if (i12 == 3) {
                b5Var.r(i11, 3);
                ((k6) obj).d(x5Var);
                b5Var.r(i11, 4);
            } else {
                if (i12 != 5) {
                    int i13 = r5.f3179u;
                    throw new RuntimeException(new u5("Protocol message tag had invalid wire type."));
                }
                b5Var.f(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof k6)) {
            return false;
        }
        k6 k6Var = (k6) obj;
        int i = this.f3074a;
        if (i == k6Var.f3074a) {
            int[] iArr = this.f3075b;
            int[] iArr2 = k6Var.f3075b;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    Object[] objArr = this.f3076c;
                    Object[] objArr2 = k6Var.f3076c;
                    int i11 = this.f3074a;
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
        int i = this.f3074a;
        int i10 = (i + 527) * 31;
        int[] iArr = this.f3075b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f3076c;
        int i14 = this.f3074a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
