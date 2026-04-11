package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends m1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final v1.e1 f11358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v1.c1 f11359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public v f11360o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public u f11361p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11362q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11363r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11364s;

    public x(a aVar, boolean z10) {
        super(aVar);
        this.f11357l = z10 && aVar.j();
        this.f11358m = new v1.e1();
        this.f11359n = new v1.c1();
        v1.f1 f1VarH = aVar.h();
        if (f1VarH == null) {
            this.f11360o = new v(new w(aVar.i()), v1.e1.f12633q, v.f11337h);
        } else {
            this.f11360o = new v(f1VarH, null, null);
            this.f11364s = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // s2.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(v1.f1 r12) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.x.A(v1.f1):void");
    }

    @Override // s2.m1
    public final void C() {
        if (this.f11357l) {
            return;
        }
        this.f11362q = true;
        B();
    }

    @Override // s2.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final u c(c0 c0Var, w2.e eVar, long j4) {
        u uVar = new u(c0Var, eVar, j4);
        y1.d.g(uVar.f11330y == null);
        uVar.f11330y = this.f11276k;
        if (!this.f11363r) {
            this.f11361p = uVar;
            if (!this.f11362q) {
                this.f11362q = true;
                B();
            }
            return uVar;
        }
        Object obj = c0Var.f11156a;
        if (this.f11360o.f11338g != null && obj.equals(v.f11337h)) {
            obj = this.f11360o.f11338g;
        }
        uVar.b(c0Var.a(obj));
        return uVar;
    }

    public final boolean E(long j4) {
        u uVar = this.f11361p;
        int iB = this.f11360o.b(uVar.f11327v.f11156a);
        if (iB == -1) {
            return false;
        }
        v vVar = this.f11360o;
        v1.c1 c1Var = this.f11359n;
        vVar.f(iB, c1Var, false);
        long j7 = c1Var.f12619d;
        if (j7 != -9223372036854775807L && j4 >= j7) {
            j4 = Math.max(0L, j7 - 1);
        }
        uVar.B = j4;
        return true;
    }

    @Override // s2.a
    public final boolean a(v1.g0 g0Var) {
        return this.f11276k.a(g0Var);
    }

    @Override // s2.a
    public final void o(a0 a0Var) {
        u uVar = (u) a0Var;
        if (uVar.f11331z != null) {
            a aVar = uVar.f11330y;
            aVar.getClass();
            aVar.o(uVar.f11331z);
        }
        if (a0Var == this.f11361p) {
            this.f11361p = null;
        }
    }

    @Override // s2.l, s2.a
    public final void q() {
        this.f11363r = false;
        this.f11362q = false;
        super.q();
    }

    @Override // s2.m1, s2.a
    public final void t(v1.g0 g0Var) {
        if (this.f11364s) {
            v vVar = this.f11360o;
            this.f11360o = new v(new g2.m1(this.f11360o.f11299e, g0Var), vVar.f, vVar.f11338g);
        } else {
            this.f11360o = new v(new w(g0Var), v1.e1.f12633q, v.f11337h);
        }
        this.f11276k.t(g0Var);
    }

    @Override // s2.m1
    public final c0 z(c0 c0Var) {
        Object obj = c0Var.f11156a;
        Object obj2 = this.f11360o.f11338g;
        if (obj2 != null && obj2.equals(obj)) {
            obj = v.f11337h;
        }
        return c0Var.a(obj);
    }
}
