package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b1 implements df.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f13580a;
    private static final bf.d descriptor;

    static {
        b1 b1Var = new b1();
        f13580a = b1Var;
        df.n nVar = new df.n("com.google.firebase.sessions.Time", b1Var, 3);
        nVar.l("ms", false);
        nVar.l("us", true);
        nVar.l("seconds", true);
        descriptor = nVar;
    }

    @Override // df.e
    public final ze.a[] a() {
        df.i iVar = df.i.f3708a;
        return new ze.a[]{iVar, iVar, iVar};
    }

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        bf.d dVar = descriptor;
        ff.k kVarC = kVar.c(dVar);
        int i = 0;
        long jK = 0;
        long jK2 = 0;
        long jK3 = 0;
        boolean z10 = true;
        while (z10) {
            int iG = kVarC.g(dVar);
            if (iG == -1) {
                z10 = false;
            } else if (iG == 0) {
                jK = kVarC.k(dVar, 0);
                i |= 1;
            } else if (iG == 1) {
                jK2 = kVarC.k(dVar, 1);
                i |= 2;
            } else {
                if (iG != 2) {
                    throw new ff.g(iG);
                }
                jK3 = kVarC.k(dVar, 2);
                i |= 4;
            }
        }
        kVarC.t(dVar);
        return new d1(i, jK, jK2, jK3);
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        d1 d1Var = (d1) obj;
        ge.i.e(d1Var, "value");
        bf.d dVar = descriptor;
        ff.l lVarA = lVar.a(dVar);
        long j4 = d1Var.f13602a;
        long j7 = d1Var.f13604c;
        long j10 = d1Var.f13603b;
        lVarA.e(dVar, 0, j4);
        if (lVarA.o(dVar) || j10 != ((long) 1000) * j4) {
            lVarA.e(dVar, 1, j10);
        }
        if (lVarA.o(dVar) || j7 != j4 / ((long) 1000)) {
            lVarA.e(dVar, 2, j7);
        }
        lVarA.l(dVar);
    }

    @Override // ze.a
    public final bf.d d() {
        return descriptor;
    }
}
