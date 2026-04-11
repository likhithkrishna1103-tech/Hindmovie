package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {
    public static final b1 f = new b1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f684d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f685e;

    public b1(int i, int[] iArr, Object[] objArr, boolean z10) {
        this.f681a = i;
        this.f682b = iArr;
        this.f683c = objArr;
        this.f685e = z10;
    }

    public final void a(int i) {
        int[] iArr = this.f682b;
        if (i > iArr.length) {
            int i10 = this.f681a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i) {
                i = i11;
            }
            if (i < 8) {
                i = 8;
            }
            this.f682b = Arrays.copyOf(iArr, i);
            this.f683c = Arrays.copyOf(this.f683c, i);
        }
    }

    public final int b() {
        int iG;
        int I;
        int iG2;
        int i = this.f684d;
        if (i != -1) {
            return i;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f681a; i11++) {
            int i12 = this.f682b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f683c[i11]).getClass();
                    iG2 = l.G(i13) + 8;
                } else if (i14 == 2) {
                    iG2 = l.E(i13, (g) this.f683c[i11]);
                } else if (i14 == 3) {
                    iG = l.G(i13) * 2;
                    I = ((b1) this.f683c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(z.b());
                    }
                    ((Integer) this.f683c[i11]).getClass();
                    iG2 = l.G(i13) + 4;
                }
                i10 = iG2 + i10;
            } else {
                long jLongValue = ((Long) this.f683c[i11]).longValue();
                iG = l.G(i13);
                I = l.I(jLongValue);
            }
            i10 = I + iG + i10;
        }
        this.f684d = i10;
        return i10;
    }

    public final void c(int i, Object obj) {
        if (!this.f685e) {
            throw new UnsupportedOperationException();
        }
        a(this.f681a + 1);
        int[] iArr = this.f682b;
        int i10 = this.f681a;
        iArr[i10] = i;
        this.f683c[i10] = obj;
        this.f681a = i10 + 1;
    }

    public final void d(e0 e0Var) {
        if (this.f681a == 0) {
            return;
        }
        e0Var.getClass();
        l lVar = (l) e0Var.f697a;
        for (int i = 0; i < this.f681a; i++) {
            int i10 = this.f682b[i];
            Object obj = this.f683c[i];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                lVar.c0(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                lVar.S(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                lVar.O(i11, (g) obj);
            } else if (i12 == 3) {
                lVar.Z(i11, 3);
                ((b1) obj).d(e0Var);
                lVar.Z(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(z.b());
                }
                lVar.Q(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        int i = this.f681a;
        if (i == b1Var.f681a) {
            int[] iArr = this.f682b;
            int[] iArr2 = b1Var.f682b;
            int i10 = 0;
            while (true) {
                if (i10 >= i) {
                    Object[] objArr = this.f683c;
                    Object[] objArr2 = b1Var.f683c;
                    int i11 = this.f681a;
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
        int i = this.f681a;
        int i10 = (527 + i) * 31;
        int[] iArr = this.f682b;
        int iHashCode = 17;
        int i11 = 17;
        for (int i12 = 0; i12 < i; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        int i13 = (i10 + i11) * 31;
        Object[] objArr = this.f683c;
        int i14 = this.f681a;
        for (int i15 = 0; i15 < i14; i15++) {
            iHashCode = (iHashCode * 31) + objArr[i15].hashCode();
        }
        return i13 + iHashCode;
    }
}
