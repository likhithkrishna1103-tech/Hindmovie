package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends y0 {
    public final b1 A;
    public final l B;
    public final Object C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c1 f10217z;

    public a1(c1 c1Var, b1 b1Var, l lVar, Object obj) {
        this.f10217z = c1Var;
        this.A = b1Var;
        this.B = lVar;
        this.C = obj;
    }

    @Override // pe.y0
    public final boolean k() {
        return false;
    }

    @Override // pe.y0
    public final void l(Throwable th) {
        l lVar = this.B;
        l lVarS = c1.S(lVar);
        c1 c1Var = this.f10217z;
        b1 b1Var = this.A;
        Object obj = this.C;
        if (lVarS == null || !c1Var.b0(b1Var, lVarS, obj)) {
            b1Var.f10222v.e(new ue.h(2), 2);
            l lVarS2 = c1.S(lVar);
            if (lVarS2 == null || !c1Var.b0(b1Var, lVarS2, obj)) {
                c1Var.j(c1Var.w(b1Var, obj));
            }
        }
    }
}
