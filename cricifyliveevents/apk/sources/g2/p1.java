package g2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f4884e;
    public Object f;

    public static void b(e eVar) {
        int i = eVar.C;
        if (i == 2) {
            y1.d.g(i == 2);
            eVar.C = 1;
            eVar.u();
        }
    }

    public static boolean h(e eVar) {
        return eVar.C != 0;
    }

    public static void l(e eVar, long j4) {
        eVar.I = true;
        if (eVar instanceof u2.e) {
            u2.e eVar2 = (u2.e) eVar;
            y1.d.g(eVar2.I);
            eVar2.f12076f0 = j4;
        }
    }

    public void a(e eVar, k kVar) {
        y1.d.g(((e) this.f4884e) == eVar || ((e) this.f) == eVar);
        if (h(eVar)) {
            if (eVar == ((e) kVar.f4783z)) {
                kVar.A = null;
                kVar.f4783z = null;
                kVar.f4779v = true;
            }
            b(eVar);
            y1.d.g(eVar.C == 1);
            eVar.f4659x.q();
            eVar.C = 0;
            eVar.D = null;
            eVar.E = null;
            eVar.I = false;
            eVar.o();
            eVar.L = null;
        }
    }

    public int c() {
        boolean zH = h((e) this.f4884e);
        e eVar = (e) this.f;
        return (zH ? 1 : 0) + ((eVar == null || !h(eVar)) ? 0 : 1);
    }

    public e d(u0 u0Var) {
        s2.a1 a1Var;
        if (u0Var != null && (a1Var = u0Var.f4905c[this.f4882c]) != null) {
            e eVar = (e) this.f4884e;
            if (eVar.D == a1Var) {
                return eVar;
            }
            e eVar2 = (e) this.f;
            if (eVar2 != null && eVar2.D == a1Var) {
                return eVar2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(g2.u0 r8, g2.e r9) {
        /*
            r7 = this;
            int r0 = r7.f4882c
            r1 = 1
            if (r9 != 0) goto L6
            goto L49
        L6:
            s2.a1[] r2 = r8.f4905c
            r2 = r2[r0]
            s2.a1 r3 = r9.D
            if (r3 == 0) goto L49
            if (r3 != r2) goto L3a
            if (r2 == 0) goto L49
            boolean r2 = r9.k()
            if (r2 != 0) goto L49
            g2.u0 r2 = r8.f4913m
            g2.v0 r3 = r8.f4908g
            boolean r3 = r3.f4924g
            if (r3 == 0) goto L3a
            if (r2 == 0) goto L3a
            boolean r3 = r2.f4907e
            if (r3 == 0) goto L3a
            boolean r3 = r9 instanceof u2.e
            if (r3 != 0) goto L39
            boolean r3 = r9 instanceof q2.b
            if (r3 != 0) goto L39
            long r3 = r9.H
            long r5 = r2.e()
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 < 0) goto L3a
            goto L49
        L39:
            return r1
        L3a:
            g2.u0 r8 = r8.f4913m
            if (r8 == 0) goto L47
            s2.a1[] r8 = r8.f4905c
            r8 = r8[r0]
            s2.a1 r9 = r9.D
            if (r8 != r9) goto L47
            goto L49
        L47:
            r8 = 0
            return r8
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.p1.e(g2.u0, g2.e):boolean");
    }

    public boolean f() {
        int i = this.f4883d;
        return i == 2 || i == 4 || i == 3;
    }

    public boolean g() {
        int i = this.f4883d;
        if (i == 0 || i == 2 || i == 4) {
            return h((e) this.f4884e);
        }
        e eVar = (e) this.f;
        eVar.getClass();
        return eVar.C != 0;
    }

    public void i(boolean z10) {
        if (z10) {
            if (this.f4880a) {
                e eVar = (e) this.f4884e;
                y1.d.g(eVar.C == 0);
                eVar.f4659x.q();
                eVar.s();
                this.f4880a = false;
                return;
            }
            return;
        }
        if (this.f4881b) {
            e eVar2 = (e) this.f;
            eVar2.getClass();
            y1.d.g(eVar2.C == 0);
            eVar2.f4659x.q();
            eVar2.s();
            this.f4881b = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int j(e eVar, u0 u0Var, v2.u uVar, k kVar) {
        int i;
        e eVar2 = (e) this.f4884e;
        int i10 = this.f4882c;
        if (eVar == null || eVar.C == 0 || (eVar == eVar2 && ((i = this.f4883d) == 2 || i == 4))) {
            return 1;
        }
        if (eVar == ((e) this.f) && this.f4883d == 3) {
            return 1;
        }
        Object[] objArr = eVar.D != u0Var.f4905c[i10];
        boolean zB = uVar.b(i10);
        if (!zB || objArr != false) {
            if (!eVar.I) {
                v2.q qVar = uVar.f13130c[i10];
                int length = qVar != null ? qVar.length() : 0;
                v1.p[] pVarArr = new v1.p[length];
                for (int i11 = 0; i11 < length; i11++) {
                    qVar.getClass();
                    pVarArr[i11] = qVar.c(i11);
                }
                s2.a1 a1Var = u0Var.f4905c[i10];
                a1Var.getClass();
                eVar.y(pVarArr, a1Var, u0Var.e(), u0Var.f4916p, u0Var.f4908g.f4919a);
                return 3;
            }
            if (!eVar.l()) {
                return 0;
            }
            a(eVar, kVar);
            if (!zB || f()) {
                i(eVar == eVar2);
                return 1;
            }
        }
        return 1;
    }

    public void k() {
        if (!h((e) this.f4884e)) {
            i(true);
        }
        e eVar = (e) this.f;
        if (eVar == null || eVar.C != 0) {
            return;
        }
        i(false);
    }

    public void m() {
        int i;
        e eVar = (e) this.f4884e;
        int i10 = eVar.C;
        if (i10 == 1 && this.f4883d != 4) {
            y1.d.g(i10 == 1);
            eVar.C = 2;
            eVar.t();
            return;
        }
        e eVar2 = (e) this.f;
        if (eVar2 == null || (i = eVar2.C) != 1 || this.f4883d == 3) {
            return;
        }
        y1.d.g(i == 1);
        eVar2.C = 2;
        eVar2.t();
    }
}
