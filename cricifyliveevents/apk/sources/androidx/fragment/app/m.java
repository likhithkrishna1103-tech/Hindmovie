package androidx.fragment.app;

import f9.q4;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1020v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f1021w;

    public /* synthetic */ m(int i, Object obj) {
        this.f1020v = i;
        this.f1021w = obj;
    }

    private final void a() {
        j9.n nVar = (j9.n) this.f1021w;
        synchronized (nVar.f6704x) {
            try {
                j9.c cVar = (j9.c) nVar.f6705y;
                if (cVar != null) {
                    cVar.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        nf.a aVarB;
        long jNanoTime;
        nf.a aVarB2;
        nf.d dVar = (nf.d) this.f1021w;
        synchronized (dVar) {
            dVar.f9165g++;
            aVarB = dVar.b();
        }
        if (aVarB == null) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        while (true) {
            try {
                threadCurrentThread.setName(aVarB.f9148a);
                Logger logger = ((nf.d) this.f1021w).f9161b;
                nf.c cVar = aVarB.f9150c;
                ge.i.b(cVar);
                boolean zIsLoggable = logger.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = System.nanoTime();
                    vf.g.a(logger, aVarB, cVar, "starting");
                } else {
                    jNanoTime = -1;
                }
                try {
                    long jA = aVarB.a();
                    if (zIsLoggable) {
                        vf.g.a(logger, aVarB, cVar, "finished run in " + vf.g.B(System.nanoTime() - jNanoTime));
                    }
                    nf.d dVar2 = (nf.d) this.f1021w;
                    synchronized (dVar2) {
                        nf.d.a(dVar2, aVarB, jA, true);
                        aVarB2 = dVar2.b();
                    }
                    if (aVarB2 == null) {
                        return;
                    } else {
                        aVarB = aVarB2;
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        vf.g.a(logger, aVarB, cVar, "failed a run in " + vf.g.B(System.nanoTime() - jNanoTime));
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    nf.d dVar3 = (nf.d) this.f1021w;
                    synchronized (dVar3) {
                        nf.d.a(dVar3, aVarB, -1L, false);
                        if (!(th2 instanceof InterruptedException)) {
                            throw th2;
                        }
                        Thread.currentThread().interrupt();
                        return;
                    }
                } finally {
                    threadCurrentThread.setName(name);
                }
            }
        }
    }

    private final void c() {
        boolean zA;
        rc.j jVar = (rc.j) this.f1021w;
        synchronized (jVar) {
            zA = jVar.a();
            if (zA) {
                jVar.j(true);
            }
        }
        if (zA) {
            rc.k kVarC = jVar.f10978q.c();
            jVar.f10977p.getClass();
            if (new Date(System.currentTimeMillis()).before(kVarC.f10981b)) {
                jVar.i();
                return;
            }
            ic.c cVar = (ic.c) jVar.f10972k;
            j9.p pVarE = cVar.e();
            j9.p pVarD = cVar.d();
            j9.p pVarF = vf.g.c0(pVarE, pVarD).f(jVar.f10970h, new c8.b(jVar, pVarE, pVarD, 11));
            vf.g.c0(pVarF).e(jVar.f10970h, new e(22, jVar, pVarF));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x03dc  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.run():void");
    }

    public m(n8.g gVar, ag.o oVar) {
        this.f1020v = 20;
        this.f1021w = oVar;
    }

    public m(f9.c1 c1Var, boolean z10) {
        this.f1020v = 5;
        this.f1021w = c1Var;
    }

    public m(q4 q4Var, ad.b bVar) {
        this.f1020v = 9;
        this.f1021w = q4Var;
    }
}
