package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements df.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f13714a;
    private static final bf.d descriptor;

    static {
        y yVar = new y();
        f13714a = yVar;
        df.n nVar = new df.n("com.google.firebase.sessions.ProcessData", yVar, 2);
        nVar.l("pid", false);
        nVar.l("uuid", false);
        descriptor = nVar;
    }

    @Override // df.e
    public final ze.a[] a() {
        return new ze.a[]{df.f.f3702a, df.q.f3731a};
    }

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        bf.d dVar = descriptor;
        ff.k kVarC = kVar.c(dVar);
        String strQ = null;
        boolean z10 = true;
        int i = 0;
        int i10 = 0;
        while (z10) {
            int iG = kVarC.g(dVar);
            if (iG == -1) {
                z10 = false;
            } else if (iG == 0) {
                i10 = kVarC.i(dVar, 0);
                i |= 1;
            } else {
                if (iG != 1) {
                    throw new ff.g(iG);
                }
                strQ = kVarC.q(dVar, 1);
                i |= 2;
            }
        }
        kVarC.t(dVar);
        return new a0(i, i10, strQ);
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        a0 a0Var = (a0) obj;
        ge.i.e(a0Var, "value");
        bf.d dVar = descriptor;
        ff.l lVarA = lVar.a(dVar);
        int i = a0Var.f13565a;
        lVarA.b(dVar, 0);
        lVarA.c(i);
        lVarA.k(dVar, 1, a0Var.f13566b);
        lVarA.l(dVar);
    }

    @Override // ze.a
    public final bf.d d() {
        return descriptor;
    }
}
