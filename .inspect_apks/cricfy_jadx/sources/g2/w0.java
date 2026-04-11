package g2;

import android.util.Pair;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h2.f f4932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y1.x f4933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.fragment.app.f1 f4934e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4936h;
    public u0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u0 f4937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u0 f4938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u0 f4939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u0 f4940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f4942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4943p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.c1 f4930a = new v1.c1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.e1 f4931b = new v1.e1();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f4944q = new ArrayList();

    public w0(h2.f fVar, y1.x xVar, androidx.fragment.app.f1 f1Var) {
        this.f4932c = fVar;
        this.f4933d = xVar;
        this.f4934e = f1Var;
    }

    public static s2.c0 o(v1.f1 f1Var, Object obj, long j4, long j7, v1.e1 e1Var, v1.c1 c1Var) {
        f1Var.g(obj, c1Var);
        f1Var.n(c1Var.f12618c, e1Var);
        f1Var.b(obj);
        int i = c1Var.f12621g.f12583a;
        if (i != 0) {
            if (i == 1) {
                c1Var.f(0);
            }
            c1Var.f12621g.getClass();
            c1Var.g(0);
        }
        f1Var.g(obj, c1Var);
        int iC = c1Var.c(j4);
        return iC == -1 ? new s2.c0(obj, j7, c1Var.b(j4)) : new s2.c0(obj, iC, c1Var.e(iC), j7, -1);
    }

    public final u0 a() {
        u0 u0Var = this.i;
        if (u0Var == null) {
            return null;
        }
        if (u0Var == this.f4937j) {
            this.f4937j = u0Var.f4913m;
        }
        if (u0Var == this.f4938k) {
            this.f4938k = u0Var.f4913m;
        }
        u0Var.i();
        int i = this.f4941n - 1;
        this.f4941n = i;
        if (i == 0) {
            this.f4939l = null;
            u0 u0Var2 = this.i;
            this.f4942o = u0Var2.f4904b;
            this.f4943p = u0Var2.f4908g.f4919a.f11159d;
        }
        this.i = this.i.f4913m;
        l();
        return this.i;
    }

    public final void b() {
        if (this.f4941n == 0) {
            return;
        }
        u0 u0Var = this.i;
        y1.d.h(u0Var);
        this.f4942o = u0Var.f4904b;
        this.f4943p = u0Var.f4908g.f4919a.f11159d;
        while (u0Var != null) {
            u0Var.i();
            u0Var = u0Var.f4913m;
        }
        this.i = null;
        this.f4939l = null;
        this.f4937j = null;
        this.f4938k = null;
        this.f4941n = 0;
        l();
    }

    public final v0 c(v1.f1 f1Var, u0 u0Var, long j4) {
        long j7;
        v1.c1 c1Var;
        v1.f1 f1Var2;
        Object obj;
        long j10;
        long j11;
        long j12;
        long jQ;
        v0 v0Var = u0Var.f4908g;
        long j13 = (u0Var.f4916p + v0Var.f4923e) - j4;
        if (!v0Var.f4925h) {
            s2.c0 c0Var = v0Var.f4919a;
            Object obj2 = c0Var.f11156a;
            int i = c0Var.f11160e;
            v1.c1 c1Var2 = this.f4930a;
            f1Var.g(obj2, c1Var2);
            boolean z10 = v0Var.f4924g;
            if (!c0Var.b()) {
                if (i != -1) {
                    c1Var2.f(i);
                }
                int iE = c1Var2.e(i);
                c1Var2.g(i);
                if (iE != c1Var2.f12621g.a(i).f12561a) {
                    return e(f1Var, c0Var.f11156a, c0Var.f11160e, iE, v0Var.f4923e, c0Var.f11159d, z10);
                }
                f1Var.g(obj2, c1Var2);
                c1Var2.d(i);
                c1Var2.f12621g.a(i).getClass();
                return f(f1Var, c0Var.f11156a, 0L, v0Var.f4923e, c0Var.f11159d, false);
            }
            int i10 = c0Var.f11157b;
            int i11 = c1Var2.f12621g.a(i10).f12561a;
            if (i11 == -1) {
                return null;
            }
            int iA = c1Var2.f12621g.a(i10).a(c0Var.f11158c);
            if (iA < i11) {
                return e(f1Var, c0Var.f11156a, i10, iA, v0Var.f4921c, c0Var.f11159d, z10);
            }
            long jLongValue = v0Var.f4921c;
            if (jLongValue == -9223372036854775807L) {
                int i12 = c1Var2.f12618c;
                long jMax = Math.max(0L, j13);
                j7 = 0;
                Pair pairJ = f1Var.j(this.f4931b, c1Var2, i12, -9223372036854775807L, jMax);
                c1Var = c1Var2;
                f1Var2 = f1Var;
                if (pairJ == null) {
                    return null;
                }
                jLongValue = ((Long) pairJ.second).longValue();
            } else {
                j7 = 0;
                c1Var = c1Var2;
                f1Var2 = f1Var;
            }
            int i13 = c0Var.f11157b;
            f1Var2.g(obj2, c1Var);
            c1Var.d(i13);
            c1Var.f12621g.a(i13).getClass();
            return f(f1Var, c0Var.f11156a, Math.max(j7, jLongValue), v0Var.f4921c, c0Var.f11159d, z10);
        }
        v0 v0Var2 = u0Var.f4908g;
        s2.c0 c0Var2 = v0Var2.f4919a;
        long j14 = v0Var2.f4921c;
        int iD = f1Var.d(f1Var.b(c0Var2.f11156a), this.f4930a, this.f4931b, this.f4935g, this.f4936h);
        if (iD != -1) {
            v1.c1 c1Var3 = this.f4930a;
            int i14 = f1Var.f(iD, c1Var3, true).f12618c;
            Object obj3 = c1Var3.f12617b;
            obj3.getClass();
            long j15 = c0Var2.f11159d;
            if (f1Var.m(i14, this.f4931b, 0L).f12654n == iD) {
                Pair pairJ2 = f1Var.j(this.f4931b, this.f4930a, i14, -9223372036854775807L, Math.max(0L, j13));
                if (pairJ2 != null) {
                    Object obj4 = pairJ2.first;
                    long jLongValue2 = ((Long) pairJ2.second).longValue();
                    u0 u0Var2 = u0Var.f4913m;
                    if (u0Var2 == null || !u0Var2.f4904b.equals(obj4)) {
                        jQ = q(obj4);
                        if (jQ == -1) {
                            jQ = this.f;
                            this.f = 1 + jQ;
                        }
                    } else {
                        jQ = u0Var2.f4908g.f4919a.f11159d;
                    }
                    obj = obj4;
                    j10 = jLongValue2;
                    j12 = jQ;
                    j11 = -9223372036854775807L;
                }
            } else {
                obj = obj3;
                j10 = 0;
                j11 = 0;
                j12 = j15;
            }
            s2.c0 c0VarO = o(f1Var, obj, j10, j12, this.f4931b, this.f4930a);
            if (j11 != -9223372036854775807L && j14 != -9223372036854775807L) {
                int i15 = f1Var.g(c0Var2.f11156a, c1Var3).f12621g.f12583a;
                c1Var3.f12621g.getClass();
                if (i15 > 0) {
                    c1Var3.g(0);
                }
            }
            return d(f1Var, c0VarO, j11, j10);
        }
        return null;
    }

    public final v0 d(v1.f1 f1Var, s2.c0 c0Var, long j4, long j7) {
        f1Var.g(c0Var.f11156a, this.f4930a);
        return c0Var.b() ? e(f1Var, c0Var.f11156a, c0Var.f11157b, c0Var.f11158c, j4, c0Var.f11159d, false) : f(f1Var, c0Var.f11156a, j7, j4, c0Var.f11159d, false);
    }

    public final v0 e(v1.f1 f1Var, Object obj, int i, int i10, long j4, long j7, boolean z10) {
        s2.c0 c0Var = new s2.c0(obj, i, i10, j7, -1);
        v1.c1 c1Var = this.f4930a;
        long jA = f1Var.g(obj, c1Var).a(i, i10);
        if (i10 == c1Var.e(i)) {
            c1Var.f12621g.getClass();
        }
        c1Var.g(i);
        long jMax = 0;
        if (jA != -9223372036854775807L && 0 >= jA) {
            jMax = Math.max(0L, jA - 1);
        }
        return new v0(c0Var, jMax, j4, -9223372036854775807L, jA, z10, false, false, false, false);
    }

    public final v0 f(v1.f1 f1Var, Object obj, long j4, long j7, long j10, boolean z10) {
        long j11;
        v1.c1 c1Var = this.f4930a;
        f1Var.g(obj, c1Var);
        int iB = c1Var.b(j4);
        boolean z11 = false;
        if (iB != -1) {
            c1Var.g(iB);
        } else if (c1Var.f12621g.f12583a > 0) {
            c1Var.g(0);
        }
        s2.c0 c0Var = new s2.c0(obj, j10, iB);
        if (!c0Var.b() && iB == -1) {
            z11 = true;
        }
        boolean zJ = j(f1Var, c0Var);
        boolean zI = i(f1Var, c0Var, z11);
        if (iB != -1) {
            c1Var.g(iB);
        }
        if (iB != -1) {
            c1Var.f(iB);
        }
        if (iB != -1) {
            c1Var.d(iB);
            j11 = 0;
        } else {
            j11 = -9223372036854775807L;
        }
        long j12 = (j11 == -9223372036854775807L || j11 == Long.MIN_VALUE) ? c1Var.f12619d : j11;
        return new v0(c0Var, (j12 == -9223372036854775807L || j4 < j12) ? j4 : Math.max(0L, j12 - ((long) 1)), j7, j11, j12, z10, false, z11, zJ, zI);
    }

    public final u0 g() {
        return this.f4938k;
    }

    public final v0 h(v1.f1 f1Var, v0 v0Var) {
        long j4;
        s2.c0 c0Var = v0Var.f4919a;
        boolean zB = c0Var.b();
        int i = c0Var.f11160e;
        boolean z10 = !zB && i == -1;
        int i10 = c0Var.f11157b;
        boolean zJ = j(f1Var, c0Var);
        boolean zI = i(f1Var, c0Var, z10);
        Object obj = c0Var.f11156a;
        v1.c1 c1Var = this.f4930a;
        f1Var.g(obj, c1Var);
        if (c0Var.b() || i == -1) {
            j4 = -9223372036854775807L;
        } else {
            c1Var.d(i);
            j4 = 0;
        }
        long jA = c0Var.b() ? c1Var.a(i10, c0Var.f11158c) : (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? c1Var.f12619d : j4;
        if (c0Var.b()) {
            c1Var.g(i10);
        } else if (i != -1) {
            c1Var.g(i);
        }
        return new v0(c0Var, v0Var.f4920b, v0Var.f4921c, j4, jA, v0Var.f, false, z10, zJ, zI);
    }

    public final boolean i(v1.f1 f1Var, s2.c0 c0Var, boolean z10) {
        int iB = f1Var.b(c0Var.f11156a);
        if (!f1Var.m(f1Var.f(iB, this.f4930a, false).f12618c, this.f4931b, 0L).i) {
            if (f1Var.d(iB, this.f4930a, this.f4931b, this.f4935g, this.f4936h) == -1 && z10) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(v1.f1 f1Var, s2.c0 c0Var) {
        boolean z10 = !c0Var.b() && c0Var.f11160e == -1;
        Object obj = c0Var.f11156a;
        if (z10) {
            if (f1Var.m(f1Var.g(obj, this.f4930a).f12618c, this.f4931b, 0L).f12655o == f1Var.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k() {
        u0 u0Var = this.f4940m;
        if (u0Var == null || u0Var.h()) {
            this.f4940m = null;
            for (int i = 0; i < this.f4944q.size(); i++) {
                u0 u0Var2 = (u0) this.f4944q.get(i);
                if (!u0Var2.h()) {
                    this.f4940m = u0Var2;
                    return;
                }
            }
        }
    }

    public final void l() {
        ua.f0 f0VarJ = ua.i0.j();
        for (u0 u0Var = this.i; u0Var != null; u0Var = u0Var.f4913m) {
            f0VarJ.a(u0Var.f4908g.f4919a);
        }
        u0 u0Var2 = this.f4937j;
        this.f4933d.c(new androidx.emoji2.text.n(this, f0VarJ, u0Var2 == null ? null : u0Var2.f4908g.f4919a, 2));
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, s2.c1] */
    public final void m(long j4) {
        u0 u0Var = this.f4939l;
        if (u0Var != null) {
            y1.d.g(u0Var.f4913m == null);
            if (u0Var.f4907e) {
                u0Var.f4903a.u(j4 - u0Var.f4916p);
            }
        }
    }

    public final int n(u0 u0Var) {
        y1.d.h(u0Var);
        int i = 0;
        if (u0Var.equals(this.f4939l)) {
            return 0;
        }
        this.f4939l = u0Var;
        while (true) {
            u0Var = u0Var.f4913m;
            if (u0Var == null) {
                break;
            }
            if (u0Var == this.f4937j) {
                u0 u0Var2 = this.i;
                this.f4937j = u0Var2;
                this.f4938k = u0Var2;
                i = 3;
            }
            if (u0Var == this.f4938k) {
                this.f4938k = this.f4937j;
                i |= 2;
            }
            u0Var.i();
            this.f4941n--;
        }
        u0 u0Var3 = this.f4939l;
        u0Var3.getClass();
        if (u0Var3.f4913m != null) {
            u0Var3.b();
            u0Var3.f4913m = null;
            u0Var3.c();
        }
        l();
        return i;
    }

    public final s2.c0 p(v1.f1 f1Var, Object obj, long j4) {
        long jQ;
        int iB;
        Object obj2 = obj;
        v1.c1 c1Var = this.f4930a;
        int i = f1Var.g(obj2, c1Var).f12618c;
        Object obj3 = this.f4942o;
        if (obj3 == null || (iB = f1Var.b(obj3)) == -1 || f1Var.f(iB, c1Var, false).f12618c != i) {
            u0 u0Var = this.i;
            while (true) {
                if (u0Var == null) {
                    u0 u0Var2 = this.i;
                    while (true) {
                        if (u0Var2 != null) {
                            int iB2 = f1Var.b(u0Var2.f4904b);
                            if (iB2 != -1 && f1Var.f(iB2, c1Var, false).f12618c == i) {
                                jQ = u0Var2.f4908g.f4919a.f11159d;
                                break;
                            }
                            u0Var2 = u0Var2.f4913m;
                        } else {
                            jQ = q(obj2);
                            if (jQ == -1) {
                                jQ = this.f;
                                this.f = 1 + jQ;
                                if (this.i == null) {
                                    this.f4942o = obj2;
                                    this.f4943p = jQ;
                                }
                            }
                        }
                    }
                } else {
                    if (u0Var.f4904b.equals(obj2)) {
                        jQ = u0Var.f4908g.f4919a.f11159d;
                        break;
                    }
                    u0Var = u0Var.f4913m;
                }
            }
        } else {
            jQ = this.f4943p;
        }
        f1Var.g(obj2, c1Var);
        int i10 = c1Var.f12618c;
        v1.e1 e1Var = this.f4931b;
        f1Var.n(i10, e1Var);
        boolean z10 = false;
        for (int iB3 = f1Var.b(obj); iB3 >= e1Var.f12654n; iB3--) {
            f1Var.f(iB3, c1Var, true);
            boolean z11 = c1Var.f12621g.f12583a > 0;
            z10 |= z11;
            if (c1Var.c(c1Var.f12619d) != -1) {
                obj2 = c1Var.f12617b;
                obj2.getClass();
            }
            if (z10 && (!z11 || c1Var.f12619d != 0)) {
                break;
            }
        }
        return o(f1Var, obj2, j4, jQ, this.f4931b, this.f4930a);
    }

    public final long q(Object obj) {
        for (int i = 0; i < this.f4944q.size(); i++) {
            u0 u0Var = (u0) this.f4944q.get(i);
            if (u0Var.f4904b.equals(obj)) {
                return u0Var.f4908g.f4919a.f11159d;
            }
        }
        return -1L;
    }

    public final int r(v1.f1 f1Var) {
        v1.f1 f1Var2;
        u0 u0Var;
        u0 u0Var2 = this.i;
        if (u0Var2 == null) {
            return 0;
        }
        int iB = f1Var.b(u0Var2.f4904b);
        while (true) {
            f1Var2 = f1Var;
            iB = f1Var2.d(iB, this.f4930a, this.f4931b, this.f4935g, this.f4936h);
            while (true) {
                u0Var2.getClass();
                u0Var = u0Var2.f4913m;
                if (u0Var == null || u0Var2.f4908g.f4925h) {
                    break;
                }
                u0Var2 = u0Var;
            }
            if (iB == -1 || u0Var == null || f1Var2.b(u0Var.f4904b) != iB) {
                break;
            }
            u0Var2 = u0Var;
            f1Var = f1Var2;
        }
        int iN = n(u0Var2);
        u0Var2.f4908g = h(f1Var2, u0Var2.f4908g);
        return iN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b4, code lost:
    
        return n(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s(v1.f1 r18, long r19, long r21, long r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            g2.u0 r2 = r0.i
            r3 = 0
        L7:
            r4 = 0
            if (r2 == 0) goto Lb5
            g2.v0 r5 = r2.f4908g
            if (r3 != 0) goto L15
            g2.v0 r3 = r0.h(r1, r5)
            r6 = r19
            goto L30
        L15:
            r6 = r19
            g2.v0 r8 = r0.c(r1, r3, r6)
            if (r8 == 0) goto Lb0
            long r9 = r5.f4920b
            long r11 = r8.f4920b
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto Lb0
            s2.c0 r9 = r5.f4919a
            s2.c0 r10 = r8.f4919a
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto Lb0
            r3 = r8
        L30:
            long r8 = r3.f4923e
            long r10 = r5.f4921c
            long r12 = r5.f4923e
            g2.v0 r10 = r3.a(r10)
            r2.f4908g = r10
            int r10 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r10 == 0) goto La7
            r2.k()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L52
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L55
        L52:
            long r10 = r2.f4916p
            long r8 = r8 + r10
        L55:
            g2.u0 r1 = r0.f4937j
            r10 = 1
            r14 = -9223372036854775808
            if (r2 != r1) goto L6c
            g2.v0 r1 = r2.f4908g
            boolean r1 = r1.f4924g
            if (r1 != 0) goto L6c
            int r1 = (r21 > r14 ? 1 : (r21 == r14 ? 0 : -1))
            if (r1 == 0) goto L6a
            int r1 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
            if (r1 < 0) goto L6c
        L6a:
            r1 = r10
            goto L6d
        L6c:
            r1 = r4
        L6d:
            g2.u0 r11 = r0.f4938k
            if (r2 != r11) goto L7b
            int r11 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r11 == 0) goto L79
            int r8 = (r23 > r8 ? 1 : (r23 == r8 ? 0 : -1))
            if (r8 < 0) goto L7b
        L79:
            r8 = r10
            goto L7c
        L7b:
            r8 = r4
        L7c:
            int r2 = r0.n(r2)
            if (r2 == 0) goto L83
            return r2
        L83:
            int r2 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r2 != 0) goto L99
            long r11 = r5.f4922d
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 != 0) goto L99
            long r11 = r3.f4922d
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 == 0) goto L99
            int r3 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r3 == 0) goto L99
            r3 = r10
            goto L9a
        L99:
            r3 = r4
        L9a:
            if (r1 == 0) goto La1
            if (r2 != 0) goto La0
            if (r3 == 0) goto La1
        La0:
            r4 = r10
        La1:
            if (r8 == 0) goto La6
            r1 = r4 | 2
            return r1
        La6:
            return r4
        La7:
            g2.u0 r3 = r2.f4913m
            r16 = r3
            r3 = r2
            r2 = r16
            goto L7
        Lb0:
            int r1 = r0.n(r3)
            return r1
        Lb5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.w0.s(v1.f1, long, long, long):int");
    }
}
