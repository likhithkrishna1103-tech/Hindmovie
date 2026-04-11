package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements df.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f13647a;
    private static final bf.d descriptor;

    static {
        i0 i0Var = new i0();
        f13647a = i0Var;
        df.n nVar = new df.n("com.google.firebase.sessions.SessionDetails", i0Var, 4);
        nVar.l("sessionId", false);
        nVar.l("firstSessionId", false);
        nVar.l("sessionIndex", false);
        nVar.l("sessionStartTimestampUs", false);
        descriptor = nVar;
    }

    @Override // df.e
    public final ze.a[] a() {
        df.q qVar = df.q.f3731a;
        return new ze.a[]{qVar, qVar, df.f.f3702a, df.i.f3708a};
    }

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        bf.d dVar = descriptor;
        ff.k kVarC = kVar.c(dVar);
        int i = 0;
        int i10 = 0;
        String strQ = null;
        String strQ2 = null;
        long jK = 0;
        boolean z10 = true;
        while (z10) {
            int iG = kVarC.g(dVar);
            if (iG == -1) {
                z10 = false;
            } else if (iG == 0) {
                strQ = kVarC.q(dVar, 0);
                i |= 1;
            } else if (iG == 1) {
                strQ2 = kVarC.q(dVar, 1);
                i |= 2;
            } else if (iG == 2) {
                i10 = kVarC.i(dVar, 2);
                i |= 4;
            } else {
                if (iG != 3) {
                    throw new ff.g(iG);
                }
                jK = kVarC.k(dVar, 3);
                i |= 8;
            }
        }
        kVarC.t(dVar);
        return new k0(i, strQ, strQ2, i10, jK);
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        k0 k0Var = (k0) obj;
        ge.i.e(k0Var, "value");
        bf.d dVar = descriptor;
        ff.l lVarA = lVar.a(dVar);
        lVarA.k(dVar, 0, k0Var.f13656a);
        lVarA.k(dVar, 1, k0Var.f13657b);
        int i = k0Var.f13658c;
        lVarA.b(dVar, 2);
        lVarA.c(i);
        lVarA.e(dVar, 3, k0Var.f13659d);
        lVarA.l(dVar);
    }

    @Override // ze.a
    public final bf.d d() {
        return descriptor;
    }
}
