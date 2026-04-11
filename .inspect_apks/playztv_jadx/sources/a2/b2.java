package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f171e;
    public Object f;

    public static void b(g gVar) {
        int i = gVar.B;
        if (i == 2) {
            s1.d.g(i == 2);
            gVar.B = 1;
            gVar.u();
        }
    }

    public static boolean h(g gVar) {
        return gVar.B != 0;
    }

    public static void l(g gVar, long j5) {
        gVar.H = true;
        if (gVar instanceof q2.f) {
            q2.f fVar = (q2.f) gVar;
            s1.d.g(fVar.H);
            fVar.f10597e0 = j5;
        }
    }

    public void a(g gVar, m mVar) {
        s1.d.g(((g) this.f171e) == gVar || ((g) this.f) == gVar);
        if (h(gVar)) {
            if (gVar == ((g) mVar.f320y)) {
                mVar.f321z = null;
                mVar.f320y = null;
                mVar.f316u = true;
            }
            b(gVar);
            s1.d.g(gVar.B == 1);
            gVar.f233w.F();
            gVar.B = 0;
            gVar.C = null;
            gVar.D = null;
            gVar.H = false;
            gVar.o();
            gVar.K = null;
        }
    }

    public int c() {
        boolean zH = h((g) this.f171e);
        g gVar = (g) this.f;
        return (zH ? 1 : 0) + ((gVar == null || !h(gVar)) ? 0 : 1);
    }

    public g d(e1 e1Var) {
        o2.c1 c1Var;
        if (e1Var != null && (c1Var = e1Var.f195c[this.f169c]) != null) {
            g gVar = (g) this.f171e;
            if (gVar.C == c1Var) {
                return gVar;
            }
            g gVar2 = (g) this.f;
            if (gVar2 != null && gVar2.C == c1Var) {
                return gVar2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(a2.e1 r8, a2.g r9) {
        /*
            r7 = this;
            int r0 = r7.f169c
            r1 = 1
            if (r9 != 0) goto L6
            goto L49
        L6:
            o2.c1[] r2 = r8.f195c
            r2 = r2[r0]
            o2.c1 r3 = r9.C
            if (r3 == 0) goto L49
            if (r3 != r2) goto L3a
            if (r2 == 0) goto L49
            boolean r2 = r9.k()
            if (r2 != 0) goto L49
            a2.e1 r2 = r8.f203m
            a2.f1 r3 = r8.f198g
            boolean r3 = r3.f226g
            if (r3 == 0) goto L3a
            if (r2 == 0) goto L3a
            boolean r3 = r2.f197e
            if (r3 == 0) goto L3a
            boolean r3 = r9 instanceof q2.f
            if (r3 != 0) goto L39
            boolean r3 = r9 instanceof k2.b
            if (r3 != 0) goto L39
            long r3 = r9.G
            long r5 = r2.e()
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 < 0) goto L3a
            goto L49
        L39:
            return r1
        L3a:
            a2.e1 r8 = r8.f203m
            if (r8 == 0) goto L47
            o2.c1[] r8 = r8.f195c
            r8 = r8[r0]
            o2.c1 r9 = r9.C
            if (r8 != r9) goto L47
            goto L49
        L47:
            r8 = 0
            return r8
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.b2.e(a2.e1, a2.g):boolean");
    }

    public boolean f() {
        int i = this.f170d;
        return i == 2 || i == 4 || i == 3;
    }

    public boolean g() {
        int i = this.f170d;
        if (i == 0 || i == 2 || i == 4) {
            return h((g) this.f171e);
        }
        g gVar = (g) this.f;
        gVar.getClass();
        return gVar.B != 0;
    }

    public void i(boolean z2) {
        if (z2) {
            if (this.f167a) {
                g gVar = (g) this.f171e;
                s1.d.g(gVar.B == 0);
                gVar.f233w.F();
                gVar.s();
                this.f167a = false;
                return;
            }
            return;
        }
        if (this.f168b) {
            g gVar2 = (g) this.f;
            gVar2.getClass();
            s1.d.g(gVar2.B == 0);
            gVar2.f233w.F();
            gVar2.s();
            this.f168b = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int j(g gVar, e1 e1Var, r2.v vVar, m mVar) {
        int i;
        g gVar2 = (g) this.f171e;
        int i10 = this.f169c;
        if (gVar == null || gVar.B == 0 || (gVar == gVar2 && ((i = this.f170d) == 2 || i == 4))) {
            return 1;
        }
        if (gVar == ((g) this.f) && this.f170d == 3) {
            return 1;
        }
        Object[] objArr = gVar.C != e1Var.f195c[i10];
        boolean zB = vVar.b(i10);
        if (!zB || objArr != false) {
            if (!gVar.H) {
                r2.r rVar = vVar.f11359c[i10];
                int length = rVar != null ? rVar.length() : 0;
                p1.q[] qVarArr = new p1.q[length];
                for (int i11 = 0; i11 < length; i11++) {
                    rVar.getClass();
                    qVarArr[i11] = rVar.c(i11);
                }
                o2.c1 c1Var = e1Var.f195c[i10];
                c1Var.getClass();
                gVar.y(qVarArr, c1Var, e1Var.e(), e1Var.f206p, e1Var.f198g.f221a);
                return 3;
            }
            if (!gVar.l()) {
                return 0;
            }
            a(gVar, mVar);
            if (!zB || f()) {
                i(gVar == gVar2);
                return 1;
            }
        }
        return 1;
    }

    public void k() {
        if (!h((g) this.f171e)) {
            i(true);
        }
        g gVar = (g) this.f;
        if (gVar == null || gVar.B != 0) {
            return;
        }
        i(false);
    }

    public void m() {
        int i;
        g gVar = (g) this.f171e;
        int i10 = gVar.B;
        if (i10 == 1 && this.f170d != 4) {
            s1.d.g(i10 == 1);
            gVar.B = 2;
            gVar.t();
            return;
        }
        g gVar2 = (g) this.f;
        if (gVar2 == null || (i = gVar2.B) != 1 || this.f170d == 3) {
            return;
        }
        s1.d.g(i == 1);
        gVar2.B = 2;
        gVar2.t();
    }
}
