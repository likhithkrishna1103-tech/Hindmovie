package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends ue.q {
    private volatile boolean threadLocalIsSet;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ThreadLocal f10252z;

    /* JADX WARN: Illegal instructions before constructor call */
    public m1(vd.c cVar, vd.h hVar) {
        n1 n1Var = n1.f10253v;
        super(cVar, hVar.C(n1Var) == null ? hVar.q(n1Var) : hVar);
        this.f10252z = new ThreadLocal();
        if (cVar.h().C(vd.d.f13721v) instanceof s) {
            return;
        }
        Object objL = ue.a.l(hVar, null);
        ue.a.g(hVar, objL);
        h0(hVar, objL);
    }

    public final boolean g0() {
        boolean z10 = this.threadLocalIsSet && this.f10252z.get() == null;
        this.f10252z.remove();
        return !z10;
    }

    public final void h0(vd.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f10252z.set(new rd.f(hVar, obj));
    }

    @Override // ue.q, pe.c1
    public final void m(Object obj) {
        if (this.threadLocalIsSet) {
            rd.f fVar = (rd.f) this.f10252z.get();
            if (fVar != null) {
                ue.a.g((vd.h) fVar.f10993v, fVar.f10994w);
            }
            this.f10252z.remove();
        }
        Object objM = x.m(obj);
        vd.c cVar = this.f12483y;
        vd.h hVarH = cVar.h();
        Object objL = ue.a.l(hVarH, null);
        m1 m1VarR = objL != ue.a.f12456d ? x.r(cVar, hVarH, objL) : null;
        try {
            this.f12483y.i(objM);
            if (m1VarR == null || m1VarR.g0()) {
                ue.a.g(hVarH, objL);
            }
        } catch (Throwable th) {
            if (m1VarR == null || m1VarR.g0()) {
                ue.a.g(hVarH, objL);
            }
            throw th;
        }
    }
}
