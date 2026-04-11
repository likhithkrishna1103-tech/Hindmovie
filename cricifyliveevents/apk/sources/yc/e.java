package yc;

import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements df.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f15033a;
    private static final bf.d descriptor;

    static {
        e eVar = new e();
        f15033a = eVar;
        df.n nVar = new df.n("com.google.firebase.sessions.settings.SessionConfigs", eVar, 5);
        nVar.l("sessionsEnabled", false);
        nVar.l("sessionSamplingRate", false);
        nVar.l("sessionTimeoutSeconds", false);
        nVar.l("cacheDurationSeconds", false);
        nVar.l("cacheUpdatedTimeSeconds", false);
        descriptor = nVar;
    }

    @Override // df.e
    public final ze.a[] a() {
        ze.a aVarH = t1.h(df.a.f3693a);
        ze.a aVarH2 = t1.h(df.c.f3695a);
        df.f fVar = df.f.f3702a;
        return new ze.a[]{aVarH, aVarH2, t1.h(fVar), t1.h(fVar), t1.h(df.i.f3708a)};
    }

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        bf.d dVar = descriptor;
        ff.k kVarC = kVar.c(dVar);
        int i = 0;
        Boolean bool = null;
        Double d10 = null;
        Integer num = null;
        Integer num2 = null;
        Long l10 = null;
        boolean z10 = true;
        while (z10) {
            int iG = kVarC.g(dVar);
            if (iG == -1) {
                z10 = false;
            } else if (iG == 0) {
                bool = (Boolean) kVarC.m(dVar, 0, df.a.f3693a, bool);
                i |= 1;
            } else if (iG == 1) {
                d10 = (Double) kVarC.m(dVar, 1, df.c.f3695a, d10);
                i |= 2;
            } else if (iG == 2) {
                num = (Integer) kVarC.m(dVar, 2, df.f.f3702a, num);
                i |= 4;
            } else if (iG == 3) {
                num2 = (Integer) kVarC.m(dVar, 3, df.f.f3702a, num2);
                i |= 8;
            } else {
                if (iG != 4) {
                    throw new ff.g(iG);
                }
                l10 = (Long) kVarC.m(dVar, 4, df.i.f3708a, l10);
                i |= 16;
            }
        }
        kVarC.t(dVar);
        return new g(i, bool, d10, num, num2, l10);
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        g gVar = (g) obj;
        ge.i.e(gVar, "value");
        bf.d dVar = descriptor;
        ff.l lVarA = lVar.a(dVar);
        lVarA.g(dVar, 0, df.a.f3693a, gVar.f15034a);
        lVarA.g(dVar, 1, df.c.f3695a, gVar.f15035b);
        df.f fVar = df.f.f3702a;
        lVarA.g(dVar, 2, fVar, gVar.f15036c);
        lVarA.g(dVar, 3, fVar, gVar.f15037d);
        lVarA.g(dVar, 4, df.i.f3708a, gVar.f15038e);
        lVarA.l(dVar);
    }

    @Override // ze.a
    public final bf.d d() {
        return descriptor;
    }
}
