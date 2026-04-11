package o2;

import a2.y1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends o1 {
    public final boolean F;
    public final p1.e1 G;
    public final p1.c1 H;
    public w I;
    public v J;
    public boolean K;
    public boolean L;
    public boolean M;

    public y(a aVar, boolean z2) {
        super(aVar);
        this.F = z2 && aVar.l();
        this.G = new p1.e1();
        this.H = new p1.c1();
        p1.f1 f1VarI = aVar.i();
        if (f1VarI == null) {
            this.I = new w(new x(aVar.j()), p1.e1.f9703q, w.f9241h);
        } else {
            this.I = new w(f1VarI, null, null);
            this.M = true;
        }
    }

    @Override // o2.o1
    public final d0 D(d0 d0Var) {
        Object obj = d0Var.f9090a;
        Object obj2 = this.I.f9242g;
        if (obj2 != null && obj2.equals(obj)) {
            obj = w.f9241h;
        }
        return d0Var.a(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // o2.o1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(p1.f1 r12) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.y.E(p1.f1):void");
    }

    @Override // o2.o1
    public final void G() {
        if (this.F) {
            return;
        }
        this.K = true;
        F();
    }

    @Override // o2.a
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final v c(d0 d0Var, s2.e eVar, long j5) {
        v vVar = new v(d0Var, eVar, j5);
        s1.d.g(vVar.f9238x == null);
        vVar.f9238x = this.E;
        if (!this.L) {
            this.J = vVar;
            if (!this.K) {
                this.K = true;
                F();
            }
            return vVar;
        }
        Object obj = d0Var.f9090a;
        if (this.I.f9242g != null && obj.equals(w.f9241h)) {
            obj = this.I.f9242g;
        }
        vVar.b(d0Var.a(obj));
        return vVar;
    }

    public final boolean I(long j5) {
        v vVar = this.J;
        int iB = this.I.b(vVar.f9235u.f9090a);
        if (iB == -1) {
            return false;
        }
        w wVar = this.I;
        p1.c1 c1Var = this.H;
        wVar.f(iB, c1Var, false);
        long j8 = c1Var.f9679d;
        if (j8 != -9223372036854775807L && j5 >= j8) {
            j5 = Math.max(0L, j8 - 1);
        }
        vVar.A = j5;
        return true;
    }

    @Override // o2.a
    public final boolean a(p1.g0 g0Var) {
        return this.E.a(g0Var);
    }

    @Override // o2.a
    public final void r(b0 b0Var) {
        v vVar = (v) b0Var;
        if (vVar.f9239y != null) {
            a aVar = vVar.f9238x;
            aVar.getClass();
            aVar.r(vVar.f9239y);
        }
        if (b0Var == this.J) {
            this.J = null;
        }
    }

    @Override // o2.l, o2.a
    public final void t() {
        this.L = false;
        this.K = false;
        super.t();
    }

    @Override // o2.o1, o2.a
    public final void x(p1.g0 g0Var) {
        if (this.M) {
            w wVar = this.I;
            this.I = new w(new y1(this.I.f9206e, g0Var), wVar.f, wVar.f9242g);
        } else {
            this.I = new w(new x(g0Var), p1.e1.f9703q, w.f9241h);
        }
        this.E.x(g0Var);
    }
}
