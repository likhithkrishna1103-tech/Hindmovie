package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d0 extends we.i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10228x;

    public d0(int i) {
        super(false, 0L);
        this.f10228x = i;
    }

    public abstract vd.c e();

    public Throwable f(Object obj) {
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null) {
            return pVar.f10263a;
        }
        return null;
    }

    public final void j(Throwable th) {
        x.i(new ee.a("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), e().h());
    }

    public abstract Object m();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            vd.c cVarE = e();
            ge.i.c(cVarE, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            ue.f fVar = (ue.f) cVarE;
            xd.c cVar = fVar.f12465z;
            Object obj = fVar.B;
            vd.h hVarH = cVar.h();
            Object objL = ue.a.l(hVarH, obj);
            v0 v0Var = null;
            m1 m1VarR = objL != ue.a.f12456d ? x.r(cVar, hVarH, objL) : null;
            try {
                vd.h hVarH2 = cVar.h();
                Object objM = m();
                Throwable thF = f(objM);
                if (thF == null) {
                    int i = this.f10228x;
                    boolean z10 = true;
                    if (i != 1 && i != 2) {
                        z10 = false;
                    }
                    if (z10) {
                        v0Var = (v0) hVarH2.C(t.f10271w);
                    }
                }
                if (v0Var != null && !v0Var.a()) {
                    CancellationException cancellationExceptionX = ((c1) v0Var).x();
                    b(cancellationExceptionX);
                    cVar.i(com.bumptech.glide.c.e(cancellationExceptionX));
                } else if (thF != null) {
                    cVar.i(com.bumptech.glide.c.e(thF));
                } else {
                    cVar.i(g(objM));
                }
                if (m1VarR != null && !m1VarR.g0()) {
                    return;
                }
                ue.a.g(hVarH, objL);
            } catch (Throwable th) {
                if (m1VarR == null || m1VarR.g0()) {
                    ue.a.g(hVarH, objL);
                }
                throw th;
            }
        } catch (Throwable th2) {
            j(th2);
        }
    }

    public void b(CancellationException cancellationException) {
    }

    public Object g(Object obj) {
        return obj;
    }
}
