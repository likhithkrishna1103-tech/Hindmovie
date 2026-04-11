package a2;

import android.util.Pair;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.h f259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1.y f260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0 f261e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f263h;
    public e1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e1 f264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e1 f265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e1 f266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e1 f267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f269o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f270p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1.c1 f257a = new p1.c1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.e1 f258b = new p1.e1();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f271q = new ArrayList();

    public h1(b2.h hVar, s1.y yVar, f0 f0Var) {
        this.f259c = hVar;
        this.f260d = yVar;
        this.f261e = f0Var;
    }

    public static o2.d0 o(p1.f1 f1Var, Object obj, long j5, long j8, p1.e1 e1Var, p1.c1 c1Var) {
        f1Var.g(obj, c1Var);
        f1Var.n(c1Var.f9678c, e1Var);
        f1Var.b(obj);
        int i = c1Var.f9681g.f9647a;
        if (i != 0) {
            if (i == 1) {
                c1Var.f(0);
            }
            c1Var.f9681g.getClass();
            c1Var.g(0);
        }
        f1Var.g(obj, c1Var);
        int iC = c1Var.c(j5);
        return iC == -1 ? new o2.d0(c1Var.b(j5), j8, obj) : new o2.d0(obj, iC, c1Var.e(iC), j8, -1);
    }

    public final e1 a() {
        e1 e1Var = this.i;
        if (e1Var == null) {
            return null;
        }
        if (e1Var == this.f264j) {
            this.f264j = e1Var.f203m;
        }
        if (e1Var == this.f265k) {
            this.f265k = e1Var.f203m;
        }
        e1Var.i();
        int i = this.f268n - 1;
        this.f268n = i;
        if (i == 0) {
            this.f266l = null;
            e1 e1Var2 = this.i;
            this.f269o = e1Var2.f194b;
            this.f270p = e1Var2.f198g.f221a.f9093d;
        }
        this.i = this.i.f203m;
        l();
        return this.i;
    }

    public final void b() {
        if (this.f268n == 0) {
            return;
        }
        e1 e1Var = this.i;
        s1.d.h(e1Var);
        this.f269o = e1Var.f194b;
        this.f270p = e1Var.f198g.f221a.f9093d;
        while (e1Var != null) {
            e1Var.i();
            e1Var = e1Var.f203m;
        }
        this.i = null;
        this.f266l = null;
        this.f264j = null;
        this.f265k = null;
        this.f268n = 0;
        l();
    }

    public final f1 c(p1.f1 f1Var, e1 e1Var, long j5) {
        long j8;
        p1.c1 c1Var;
        p1.f1 f1Var2;
        Object obj;
        long j10;
        long j11;
        long j12;
        long jQ;
        f1 f1Var3 = e1Var.f198g;
        long j13 = (e1Var.f206p + f1Var3.f225e) - j5;
        if (!f1Var3.f227h) {
            o2.d0 d0Var = f1Var3.f221a;
            Object obj2 = d0Var.f9090a;
            int i = d0Var.f9094e;
            p1.c1 c1Var2 = this.f257a;
            f1Var.g(obj2, c1Var2);
            boolean z2 = f1Var3.f226g;
            if (!d0Var.b()) {
                if (i != -1) {
                    c1Var2.f(i);
                }
                int iE = c1Var2.e(i);
                c1Var2.g(i);
                if (iE != c1Var2.f9681g.a(i).f9620a) {
                    return e(f1Var, d0Var.f9090a, d0Var.f9094e, iE, f1Var3.f225e, d0Var.f9093d, z2);
                }
                f1Var.g(obj2, c1Var2);
                c1Var2.d(i);
                c1Var2.f9681g.a(i).getClass();
                return f(f1Var, d0Var.f9090a, 0L, f1Var3.f225e, d0Var.f9093d, false);
            }
            int i10 = d0Var.f9091b;
            int i11 = c1Var2.f9681g.a(i10).f9620a;
            if (i11 == -1) {
                return null;
            }
            int iA = c1Var2.f9681g.a(i10).a(d0Var.f9092c);
            if (iA < i11) {
                return e(f1Var, d0Var.f9090a, i10, iA, f1Var3.f223c, d0Var.f9093d, z2);
            }
            long jLongValue = f1Var3.f223c;
            if (jLongValue == -9223372036854775807L) {
                int i12 = c1Var2.f9678c;
                long jMax = Math.max(0L, j13);
                j8 = 0;
                Pair pairJ = f1Var.j(this.f258b, c1Var2, i12, -9223372036854775807L, jMax);
                c1Var = c1Var2;
                f1Var2 = f1Var;
                if (pairJ == null) {
                    return null;
                }
                jLongValue = ((Long) pairJ.second).longValue();
            } else {
                j8 = 0;
                c1Var = c1Var2;
                f1Var2 = f1Var;
            }
            int i13 = d0Var.f9091b;
            f1Var2.g(obj2, c1Var);
            c1Var.d(i13);
            c1Var.f9681g.a(i13).getClass();
            return f(f1Var, d0Var.f9090a, Math.max(j8, jLongValue), f1Var3.f223c, d0Var.f9093d, z2);
        }
        f1 f1Var4 = e1Var.f198g;
        o2.d0 d0Var2 = f1Var4.f221a;
        long j14 = f1Var4.f223c;
        int iD = f1Var.d(f1Var.b(d0Var2.f9090a), this.f257a, this.f258b, this.f262g, this.f263h);
        if (iD != -1) {
            p1.c1 c1Var3 = this.f257a;
            int i14 = f1Var.f(iD, c1Var3, true).f9678c;
            Object obj3 = c1Var3.f9677b;
            obj3.getClass();
            long j15 = d0Var2.f9093d;
            if (f1Var.m(i14, this.f258b, 0L).f9724n == iD) {
                Pair pairJ2 = f1Var.j(this.f258b, this.f257a, i14, -9223372036854775807L, Math.max(0L, j13));
                if (pairJ2 != null) {
                    Object obj4 = pairJ2.first;
                    long jLongValue2 = ((Long) pairJ2.second).longValue();
                    e1 e1Var2 = e1Var.f203m;
                    if (e1Var2 == null || !e1Var2.f194b.equals(obj4)) {
                        jQ = q(obj4);
                        if (jQ == -1) {
                            jQ = this.f;
                            this.f = 1 + jQ;
                        }
                    } else {
                        jQ = e1Var2.f198g.f221a.f9093d;
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
            o2.d0 d0VarO = o(f1Var, obj, j10, j12, this.f258b, this.f257a);
            if (j11 != -9223372036854775807L && j14 != -9223372036854775807L) {
                int i15 = f1Var.g(d0Var2.f9090a, c1Var3).f9681g.f9647a;
                c1Var3.f9681g.getClass();
                if (i15 > 0) {
                    c1Var3.g(0);
                }
            }
            return d(f1Var, d0VarO, j11, j10);
        }
        return null;
    }

    public final f1 d(p1.f1 f1Var, o2.d0 d0Var, long j5, long j8) {
        f1Var.g(d0Var.f9090a, this.f257a);
        return d0Var.b() ? e(f1Var, d0Var.f9090a, d0Var.f9091b, d0Var.f9092c, j5, d0Var.f9093d, false) : f(f1Var, d0Var.f9090a, j8, j5, d0Var.f9093d, false);
    }

    public final f1 e(p1.f1 f1Var, Object obj, int i, int i10, long j5, long j8, boolean z2) {
        o2.d0 d0Var = new o2.d0(obj, i, i10, j8, -1);
        p1.c1 c1Var = this.f257a;
        long jA = f1Var.g(obj, c1Var).a(i, i10);
        if (i10 == c1Var.e(i)) {
            c1Var.f9681g.getClass();
        }
        c1Var.g(i);
        long jMax = 0;
        if (jA != -9223372036854775807L && 0 >= jA) {
            jMax = Math.max(0L, jA - 1);
        }
        return new f1(d0Var, jMax, j5, -9223372036854775807L, jA, z2, false, false, false, false);
    }

    public final f1 f(p1.f1 f1Var, Object obj, long j5, long j8, long j10, boolean z2) {
        long j11;
        p1.c1 c1Var = this.f257a;
        f1Var.g(obj, c1Var);
        int iB = c1Var.b(j5);
        boolean z10 = false;
        if (iB != -1) {
            c1Var.g(iB);
        } else if (c1Var.f9681g.f9647a > 0) {
            c1Var.g(0);
        }
        o2.d0 d0Var = new o2.d0(iB, j10, obj);
        if (!d0Var.b() && iB == -1) {
            z10 = true;
        }
        boolean zJ = j(f1Var, d0Var);
        boolean zI = i(f1Var, d0Var, z10);
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
        long j12 = (j11 == -9223372036854775807L || j11 == Long.MIN_VALUE) ? c1Var.f9679d : j11;
        return new f1(d0Var, (j12 == -9223372036854775807L || j5 < j12) ? j5 : Math.max(0L, j12 - ((long) 1)), j8, j11, j12, z2, false, z10, zJ, zI);
    }

    public final e1 g() {
        return this.f265k;
    }

    public final f1 h(p1.f1 f1Var, f1 f1Var2) {
        long j5;
        o2.d0 d0Var = f1Var2.f221a;
        boolean zB = d0Var.b();
        int i = d0Var.f9094e;
        boolean z2 = !zB && i == -1;
        int i10 = d0Var.f9091b;
        boolean zJ = j(f1Var, d0Var);
        boolean zI = i(f1Var, d0Var, z2);
        Object obj = d0Var.f9090a;
        p1.c1 c1Var = this.f257a;
        f1Var.g(obj, c1Var);
        if (d0Var.b() || i == -1) {
            j5 = -9223372036854775807L;
        } else {
            c1Var.d(i);
            j5 = 0;
        }
        long jA = d0Var.b() ? c1Var.a(i10, d0Var.f9092c) : (j5 == -9223372036854775807L || j5 == Long.MIN_VALUE) ? c1Var.f9679d : j5;
        if (d0Var.b()) {
            c1Var.g(i10);
        } else if (i != -1) {
            c1Var.g(i);
        }
        return new f1(d0Var, f1Var2.f222b, f1Var2.f223c, j5, jA, f1Var2.f, false, z2, zJ, zI);
    }

    public final boolean i(p1.f1 f1Var, o2.d0 d0Var, boolean z2) {
        int iB = f1Var.b(d0Var.f9090a);
        if (!f1Var.m(f1Var.f(iB, this.f257a, false).f9678c, this.f258b, 0L).i) {
            if (f1Var.d(iB, this.f257a, this.f258b, this.f262g, this.f263h) == -1 && z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(p1.f1 f1Var, o2.d0 d0Var) {
        boolean z2 = !d0Var.b() && d0Var.f9094e == -1;
        Object obj = d0Var.f9090a;
        if (z2) {
            if (f1Var.m(f1Var.g(obj, this.f257a).f9678c, this.f258b, 0L).f9725o == f1Var.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k() {
        e1 e1Var = this.f267m;
        if (e1Var == null || e1Var.h()) {
            this.f267m = null;
            for (int i = 0; i < this.f271q.size(); i++) {
                e1 e1Var2 = (e1) this.f271q.get(i);
                if (!e1Var2.h()) {
                    this.f267m = e1Var2;
                    return;
                }
            }
        }
    }

    public final void l() {
        aa.g0 g0VarN = aa.j0.n();
        for (e1 e1Var = this.i; e1Var != null; e1Var = e1Var.f203m) {
            g0VarN.a(e1Var.f198g.f221a);
        }
        e1 e1Var2 = this.f264j;
        this.f260d.c(new g1(this, g0VarN, e1Var2 == null ? null : e1Var2.f198g.f221a, 0));
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, o2.e1] */
    public final void m(long j5) {
        e1 e1Var = this.f266l;
        if (e1Var != null) {
            s1.d.g(e1Var.f203m == null);
            if (e1Var.f197e) {
                e1Var.f193a.v(j5 - e1Var.f206p);
            }
        }
    }

    public final int n(e1 e1Var) {
        s1.d.h(e1Var);
        int i = 0;
        if (e1Var.equals(this.f266l)) {
            return 0;
        }
        this.f266l = e1Var;
        while (true) {
            e1Var = e1Var.f203m;
            if (e1Var == null) {
                break;
            }
            if (e1Var == this.f264j) {
                e1 e1Var2 = this.i;
                this.f264j = e1Var2;
                this.f265k = e1Var2;
                i = 3;
            }
            if (e1Var == this.f265k) {
                this.f265k = this.f264j;
                i |= 2;
            }
            e1Var.i();
            this.f268n--;
        }
        e1 e1Var3 = this.f266l;
        e1Var3.getClass();
        if (e1Var3.f203m != null) {
            e1Var3.b();
            e1Var3.f203m = null;
            e1Var3.c();
        }
        l();
        return i;
    }

    public final o2.d0 p(p1.f1 f1Var, Object obj, long j5) {
        long jQ;
        int iB;
        Object obj2 = obj;
        p1.c1 c1Var = this.f257a;
        int i = f1Var.g(obj2, c1Var).f9678c;
        Object obj3 = this.f269o;
        if (obj3 == null || (iB = f1Var.b(obj3)) == -1 || f1Var.f(iB, c1Var, false).f9678c != i) {
            e1 e1Var = this.i;
            while (true) {
                if (e1Var == null) {
                    e1 e1Var2 = this.i;
                    while (true) {
                        if (e1Var2 != null) {
                            int iB2 = f1Var.b(e1Var2.f194b);
                            if (iB2 != -1 && f1Var.f(iB2, c1Var, false).f9678c == i) {
                                jQ = e1Var2.f198g.f221a.f9093d;
                                break;
                            }
                            e1Var2 = e1Var2.f203m;
                        } else {
                            jQ = q(obj2);
                            if (jQ == -1) {
                                jQ = this.f;
                                this.f = 1 + jQ;
                                if (this.i == null) {
                                    this.f269o = obj2;
                                    this.f270p = jQ;
                                }
                            }
                        }
                    }
                } else {
                    if (e1Var.f194b.equals(obj2)) {
                        jQ = e1Var.f198g.f221a.f9093d;
                        break;
                    }
                    e1Var = e1Var.f203m;
                }
            }
        } else {
            jQ = this.f270p;
        }
        f1Var.g(obj2, c1Var);
        int i10 = c1Var.f9678c;
        p1.e1 e1Var3 = this.f258b;
        f1Var.n(i10, e1Var3);
        boolean z2 = false;
        for (int iB3 = f1Var.b(obj); iB3 >= e1Var3.f9724n; iB3--) {
            f1Var.f(iB3, c1Var, true);
            boolean z10 = c1Var.f9681g.f9647a > 0;
            z2 |= z10;
            if (c1Var.c(c1Var.f9679d) != -1) {
                obj2 = c1Var.f9677b;
                obj2.getClass();
            }
            if (z2 && (!z10 || c1Var.f9679d != 0)) {
                break;
            }
        }
        return o(f1Var, obj2, j5, jQ, this.f258b, this.f257a);
    }

    public final long q(Object obj) {
        for (int i = 0; i < this.f271q.size(); i++) {
            e1 e1Var = (e1) this.f271q.get(i);
            if (e1Var.f194b.equals(obj)) {
                return e1Var.f198g.f221a.f9093d;
            }
        }
        return -1L;
    }

    public final int r(p1.f1 f1Var) {
        p1.f1 f1Var2;
        e1 e1Var;
        e1 e1Var2 = this.i;
        if (e1Var2 == null) {
            return 0;
        }
        int iB = f1Var.b(e1Var2.f194b);
        while (true) {
            f1Var2 = f1Var;
            iB = f1Var2.d(iB, this.f257a, this.f258b, this.f262g, this.f263h);
            while (true) {
                e1Var2.getClass();
                e1Var = e1Var2.f203m;
                if (e1Var == null || e1Var2.f198g.f227h) {
                    break;
                }
                e1Var2 = e1Var;
            }
            if (iB == -1 || e1Var == null || f1Var2.b(e1Var.f194b) != iB) {
                break;
            }
            e1Var2 = e1Var;
            f1Var = f1Var2;
        }
        int iN = n(e1Var2);
        e1Var2.f198g = h(f1Var2, e1Var2.f198g);
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
    public final int s(p1.f1 r18, long r19, long r21, long r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            a2.e1 r2 = r0.i
            r3 = 0
        L7:
            r4 = 0
            if (r2 == 0) goto Lb5
            a2.f1 r5 = r2.f198g
            if (r3 != 0) goto L15
            a2.f1 r3 = r0.h(r1, r5)
            r6 = r19
            goto L30
        L15:
            r6 = r19
            a2.f1 r8 = r0.c(r1, r3, r6)
            if (r8 == 0) goto Lb0
            long r9 = r5.f222b
            long r11 = r8.f222b
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto Lb0
            o2.d0 r9 = r5.f221a
            o2.d0 r10 = r8.f221a
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto Lb0
            r3 = r8
        L30:
            long r8 = r3.f225e
            long r10 = r5.f223c
            long r12 = r5.f225e
            a2.f1 r10 = r3.a(r10)
            r2.f198g = r10
            int r10 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r10 == 0) goto La7
            r2.k()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L52
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L55
        L52:
            long r10 = r2.f206p
            long r8 = r8 + r10
        L55:
            a2.e1 r1 = r0.f264j
            r10 = 1
            r14 = -9223372036854775808
            if (r2 != r1) goto L6c
            a2.f1 r1 = r2.f198g
            boolean r1 = r1.f226g
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
            a2.e1 r11 = r0.f265k
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
            long r11 = r5.f224d
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 != 0) goto L99
            long r11 = r3.f224d
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
            a2.e1 r3 = r2.f203m
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
        throw new UnsupportedOperationException("Method not decompiled: a2.h1.s(p1.f1, long, long, long):int");
    }
}
