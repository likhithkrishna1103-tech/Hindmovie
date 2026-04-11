package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n6 {
    public static final n6 f = new n6(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f2551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2553d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2554e;

    public n6(int i, int[] iArr, Object[] objArr, boolean z10) {
        this.f2550a = i;
        this.f2551b = iArr;
        this.f2552c = objArr;
        this.f2554e = z10;
    }

    public static n6 a() {
        return new n6(0, new int[8], new Object[8], true);
    }

    public final void b(w5 w5Var) throws a2.a {
        if (this.f2550a != 0) {
            for (int i = 0; i < this.f2550a; i++) {
                int i10 = this.f2551b[i];
                Object obj = this.f2552c[i];
                int i11 = i10 & 7;
                int i12 = i10 >>> 3;
                if (i11 == 0) {
                    ((b5) w5Var.f2709a).k0(i12, ((Long) obj).longValue());
                } else if (i11 == 1) {
                    ((b5) w5Var.f2709a).l0(i12, ((Long) obj).longValue());
                } else if (i11 == 2) {
                    b5 b5Var = (b5) w5Var.f2709a;
                    b5Var.p0((i12 << 3) | 2);
                    b5Var.m0((a5) obj);
                } else if (i11 == 3) {
                    ((b5) w5Var.f2709a).g0(i12, 3);
                    ((n6) obj).b(w5Var);
                    ((b5) w5Var.f2709a).g0(i12, 4);
                } else {
                    if (i11 != 5) {
                        throw new RuntimeException(new q5());
                    }
                    ((b5) w5Var.f2709a).j0(i12, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int c() {
        int iV0;
        int iE0;
        int iV02;
        int i = this.f2553d;
        if (i != -1) {
            return i;
        }
        int iJ = 0;
        for (int i10 = 0; i10 < this.f2550a; i10++) {
            int i11 = this.f2551b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f2552c[i10]).getClass();
                    iV02 = b5.v0(i12 << 3) + 8;
                } else if (i13 == 2) {
                    int i14 = i12 << 3;
                    a5 a5Var = (a5) this.f2552c[i10];
                    int iV03 = b5.v0(i14);
                    int iC = a5Var.c();
                    iJ = q4.a.j(iC, iC, iV03, iJ);
                } else if (i13 == 3) {
                    int iV04 = b5.v0(i12 << 3);
                    iV0 = iV04 + iV04;
                    iE0 = ((n6) this.f2552c[i10]).c();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(new q5());
                    }
                    ((Integer) this.f2552c[i10]).getClass();
                    iV02 = b5.v0(i12 << 3) + 4;
                }
                iJ = iV02 + iJ;
            } else {
                int i15 = i12 << 3;
                long jLongValue = ((Long) this.f2552c[i10]).longValue();
                iV0 = b5.v0(i15);
                iE0 = b5.e0(jLongValue);
            }
            iJ = iE0 + iV0 + iJ;
        }
        this.f2553d = iJ;
        return iJ;
    }

    public final void d(int i, Object obj) {
        if (!this.f2554e) {
            throw new UnsupportedOperationException();
        }
        e(this.f2550a + 1);
        int[] iArr = this.f2551b;
        int i10 = this.f2550a;
        iArr[i10] = i;
        this.f2552c[i10] = obj;
        this.f2550a = i10 + 1;
    }

    public final void e(int i) {
        int[] iArr = this.f2551b;
        if (i > iArr.length) {
            int i10 = this.f2550a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i) {
                i = i11;
            }
            if (i < 8) {
                i = 8;
            }
            this.f2551b = Arrays.copyOf(iArr, i);
            this.f2552c = Arrays.copyOf(this.f2552c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof n6)) {
            return false;
        }
        n6 n6Var = (n6) obj;
        int i = this.f2550a;
        if (i == n6Var.f2550a) {
            int[] iArr = this.f2551b;
            int[] iArr2 = n6Var.f2551b;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    Object[] objArr = this.f2552c;
                    Object[] objArr2 = n6Var.f2552c;
                    int i11 = this.f2550a;
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
        int i = this.f2550a;
        int i10 = i + 527;
        int[] iArr = this.f2551b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = ((i10 * 31) + i11) * 31;
        Object[] objArr = this.f2552c;
        int i14 = this.f2550a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
