package v1;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f12674a = new b1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12677d;

    static {
        int i = y1.a0.f14551a;
        f12675b = Integer.toString(0, 36);
        f12676c = Integer.toString(1, 36);
        f12677d = Integer.toString(2, 36);
    }

    public int a(boolean z10) {
        return p() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z10) {
        if (p()) {
            return -1;
        }
        return o() - 1;
    }

    public final int d(int i, c1 c1Var, e1 e1Var, int i10, boolean z10) {
        int i11 = f(i, c1Var, false).f12618c;
        if (m(i11, e1Var, 0L).f12655o != i) {
            return i + 1;
        }
        int iE = e(i11, i10, z10);
        if (iE == -1) {
            return -1;
        }
        return m(iE, e1Var, 0L).f12654n;
    }

    public int e(int i, int i10, boolean z10) {
        if (i10 == 0) {
            if (i == c(z10)) {
                return -1;
            }
            return i + 1;
        }
        if (i10 == 1) {
            return i;
        }
        if (i10 == 2) {
            return i == c(z10) ? a(z10) : i + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        int iC;
        if (this != obj) {
            if (obj instanceof f1) {
                f1 f1Var = (f1) obj;
                if (f1Var.o() == o() && f1Var.h() == h()) {
                    e1 e1Var = new e1();
                    c1 c1Var = new c1();
                    e1 e1Var2 = new e1();
                    c1 c1Var2 = new c1();
                    int i = 0;
                    while (true) {
                        if (i >= o()) {
                            int i10 = 0;
                            while (true) {
                                if (i10 >= h()) {
                                    int iA = a(true);
                                    if (iA == f1Var.a(true) && (iC = c(true)) == f1Var.c(true)) {
                                        while (iA != iC) {
                                            int iE = e(iA, 0, true);
                                            if (iE == f1Var.e(iA, 0, true)) {
                                                iA = iE;
                                            }
                                        }
                                    }
                                } else {
                                    if (!f(i10, c1Var, true).equals(f1Var.f(i10, c1Var2, true))) {
                                        break;
                                    }
                                    i10++;
                                }
                            }
                        } else {
                            if (!m(i, e1Var, 0L).equals(f1Var.m(i, e1Var2, 0L))) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract c1 f(int i, c1 c1Var, boolean z10);

    public c1 g(Object obj, c1 c1Var) {
        return f(b(obj), c1Var, true);
    }

    public abstract int h();

    public int hashCode() {
        e1 e1Var = new e1();
        c1 c1Var = new c1();
        int iO = o() + 217;
        for (int i = 0; i < o(); i++) {
            iO = (iO * 31) + m(i, e1Var, 0L).hashCode();
        }
        int iH = h() + (iO * 31);
        for (int i10 = 0; i10 < h(); i10++) {
            iH = (iH * 31) + f(i10, c1Var, true).hashCode();
        }
        int iA = a(true);
        while (iA != -1) {
            iH = (iH * 31) + iA;
            iA = e(iA, 0, true);
        }
        return iH;
    }

    public final Pair i(e1 e1Var, c1 c1Var, int i, long j4) {
        Pair pairJ = j(e1Var, c1Var, i, j4, 0L);
        pairJ.getClass();
        return pairJ;
    }

    public final Pair j(e1 e1Var, c1 c1Var, int i, long j4, long j7) {
        y1.d.c(i, o());
        m(i, e1Var, j7);
        if (j4 == -9223372036854775807L) {
            j4 = e1Var.f12652l;
            if (j4 == -9223372036854775807L) {
                return null;
            }
        }
        int i10 = e1Var.f12654n;
        f(i10, c1Var, false);
        while (i10 < e1Var.f12655o && c1Var.f12620e != j4) {
            int i11 = i10 + 1;
            if (f(i11, c1Var, false).f12620e > j4) {
                break;
            }
            i10 = i11;
        }
        f(i10, c1Var, true);
        long jMin = j4 - c1Var.f12620e;
        long j10 = c1Var.f12619d;
        if (j10 != -9223372036854775807L) {
            jMin = Math.min(jMin, j10 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = c1Var.f12617b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public int k(int i, int i10, boolean z10) {
        if (i10 == 0) {
            if (i == a(z10)) {
                return -1;
            }
            return i - 1;
        }
        if (i10 == 1) {
            return i;
        }
        if (i10 == 2) {
            return i == a(z10) ? c(z10) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object l(int i);

    public abstract e1 m(int i, e1 e1Var, long j4);

    public final void n(int i, e1 e1Var) {
        m(i, e1Var, 0L);
    }

    public abstract int o();

    public final boolean p() {
        return o() == 0;
    }
}
