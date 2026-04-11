package ke;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class d0 extends re.i {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7685w;

    public d0(int i) {
        super(false, 0L);
        this.f7685w = i;
    }

    public abstract rd.c d();

    public Throwable h(Object obj) {
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar != null) {
            return oVar.f7717a;
        }
        return null;
    }

    public final void j(Throwable th) {
        x.h(new w("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), d().f());
    }

    public abstract Object m();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            rd.c cVarD = d();
            be.h.c(cVarD, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            pe.f fVar = (pe.f) cVarD;
            td.c cVar = fVar.f10377y;
            Object obj = fVar.A;
            rd.h hVarF = cVar.f();
            Object objK = pe.a.k(hVarF, obj);
            v0 v0Var = null;
            n1 n1VarP = objK != pe.a.f10368d ? x.p(cVar, hVarF, objK) : null;
            try {
                rd.h hVarF2 = cVar.f();
                Object objM = m();
                Throwable thH = h(objM);
                if (thH == null) {
                    int i = this.f7685w;
                    boolean z2 = true;
                    if (i != 1 && i != 2) {
                        z2 = false;
                    }
                    if (z2) {
                        v0Var = (v0) hVarF2.v(s.f7730v);
                    }
                }
                if (v0Var != null && !v0Var.a()) {
                    CancellationException cancellationExceptionS = ((d1) v0Var).s();
                    b(cancellationExceptionS);
                    cVar.g(i5.a.h(cancellationExceptionS));
                } else if (thH != null) {
                    cVar.g(i5.a.h(thH));
                } else {
                    cVar.g(i(objM));
                }
                if (n1VarP != null && !n1VarP.Y()) {
                    return;
                }
                pe.a.g(hVarF, objK);
            } catch (Throwable th) {
                if (n1VarP == null || n1VarP.Y()) {
                    pe.a.g(hVarF, objK);
                }
                throw th;
            }
        } catch (Throwable th2) {
            j(th2);
        }
    }

    public void b(CancellationException cancellationException) {
    }

    public Object i(Object obj) {
        return obj;
    }
}
