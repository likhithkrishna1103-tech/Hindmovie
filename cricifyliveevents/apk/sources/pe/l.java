package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends y0 implements k {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c1 f10247z;

    public l(c1 c1Var) {
        this.f10247z = c1Var;
    }

    @Override // pe.k
    public final boolean c(Throwable th) {
        return j().t(th);
    }

    @Override // pe.y0
    public final boolean k() {
        return true;
    }

    @Override // pe.y0
    public final void l(Throwable th) {
        this.f10247z.n(j());
    }
}
