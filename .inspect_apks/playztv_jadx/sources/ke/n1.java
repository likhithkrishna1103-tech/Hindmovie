package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends pe.q {
    private volatile boolean threadLocalIsSet;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ThreadLocal f7715y;

    /* JADX WARN: Illegal instructions before constructor call */
    public n1(rd.h hVar, td.c cVar) {
        o1 o1Var = o1.f7722u;
        super(hVar.v(o1Var) == null ? hVar.K(o1Var) : hVar, cVar);
        this.f7715y = new ThreadLocal();
        if (cVar.f().v(rd.d.f11571u) instanceof r) {
            return;
        }
        Object objK = pe.a.k(hVar, null);
        pe.a.g(hVar, objK);
        Z(hVar, objK);
    }

    public final boolean Y() {
        boolean z2 = this.threadLocalIsSet && this.f7715y.get() == null;
        this.f7715y.remove();
        return !z2;
    }

    public final void Z(rd.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f7715y.set(new nd.f(hVar, obj));
    }

    @Override // pe.q, ke.d1
    public final void i(Object obj) {
        if (this.threadLocalIsSet) {
            nd.f fVar = (nd.f) this.f7715y.get();
            if (fVar != null) {
                pe.a.g((rd.h) fVar.f8983u, fVar.f8984v);
            }
            this.f7715y.remove();
        }
        Object objK = x.k(obj);
        td.c cVar = this.f10397x;
        rd.h hVarF = cVar.f();
        Object objK2 = pe.a.k(hVarF, null);
        n1 n1VarP = objK2 != pe.a.f10368d ? x.p(cVar, hVarF, objK2) : null;
        try {
            this.f10397x.g(objK);
            if (n1VarP == null || n1VarP.Y()) {
                pe.a.g(hVarF, objK2);
            }
        } catch (Throwable th) {
            if (n1VarP == null || n1VarP.Y()) {
                pe.a.g(hVarF, objK2);
            }
            throw th;
        }
    }
}
