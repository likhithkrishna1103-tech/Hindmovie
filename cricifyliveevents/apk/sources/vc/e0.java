package vc;

import java.util.Map;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements df.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f13609a;
    private static final bf.d descriptor;

    static {
        e0 e0Var = new e0();
        f13609a = e0Var;
        df.n nVar = new df.n("com.google.firebase.sessions.SessionData", e0Var, 3);
        nVar.l("sessionDetails", false);
        nVar.l("backgroundTime", true);
        nVar.l("processDataMap", true);
        descriptor = nVar;
    }

    @Override // df.e
    public final ze.a[] a() {
        return new ze.a[]{i0.f13647a, t1.h(b1.f13580a), t1.h(g0.f13621d[2])};
    }

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        bf.d dVar = descriptor;
        ff.k kVarC = kVar.c(dVar);
        ze.a[] aVarArr = g0.f13621d;
        k0 k0Var = null;
        boolean z10 = true;
        int i = 0;
        d1 d1Var = null;
        Map map = null;
        while (z10) {
            int iG = kVarC.g(dVar);
            if (iG == -1) {
                z10 = false;
            } else if (iG == 0) {
                k0Var = (k0) kVarC.n(dVar, 0, i0.f13647a, k0Var);
                i |= 1;
            } else if (iG == 1) {
                d1Var = (d1) kVarC.m(dVar, 1, b1.f13580a, d1Var);
                i |= 2;
            } else {
                if (iG != 2) {
                    throw new ff.g(iG);
                }
                map = (Map) kVarC.m(dVar, 2, aVarArr[2], map);
                i |= 4;
            }
        }
        kVarC.t(dVar);
        return new g0(i, k0Var, d1Var, map);
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        g0 g0Var = (g0) obj;
        ge.i.e(g0Var, "value");
        bf.d dVar = descriptor;
        ff.l lVarA = lVar.a(dVar);
        ze.a[] aVarArr = g0.f13621d;
        i0 i0Var = i0.f13647a;
        k0 k0Var = g0Var.f13622a;
        Map map = g0Var.f13624c;
        d1 d1Var = g0Var.f13623b;
        lVarA.h(dVar, 0, i0Var, k0Var);
        if (lVarA.o(dVar) || d1Var != null) {
            lVarA.g(dVar, 1, b1.f13580a, d1Var);
        }
        if (lVarA.o(dVar) || map != null) {
            lVarA.g(dVar, 2, aVarArr[2], map);
        }
        lVarA.l(dVar);
    }

    @Override // ze.a
    public final bf.d d() {
        return descriptor;
    }
}
