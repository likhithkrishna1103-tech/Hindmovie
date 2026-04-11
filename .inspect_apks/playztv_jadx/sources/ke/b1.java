package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends z0 {
    public final k A;
    public final Object B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d1 f7676y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c1 f7677z;

    public b1(d1 d1Var, c1 c1Var, k kVar, Object obj) {
        this.f7676y = d1Var;
        this.f7677z = c1Var;
        this.A = kVar;
        this.B = obj;
    }

    @Override // ke.z0
    public final boolean k() {
        return false;
    }

    @Override // ke.z0
    public final void l(Throwable th) {
        k kVar = this.A;
        k kVarN = d1.N(kVar);
        d1 d1Var = this.f7676y;
        c1 c1Var = this.f7677z;
        Object obj = this.B;
        if (kVarN == null || !d1Var.W(c1Var, kVarN, obj)) {
            c1Var.f7684u.e(new pe.h(2), 2);
            k kVarN2 = d1.N(kVar);
            if (kVarN2 == null || !d1Var.W(c1Var, kVarN2, obj)) {
                d1Var.h(d1Var.r(c1Var, obj));
            }
        }
    }
}
