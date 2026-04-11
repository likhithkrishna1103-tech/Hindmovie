package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends z0 implements j {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d1 f7702y;

    public k(d1 d1Var) {
        this.f7702y = d1Var;
    }

    @Override // ke.j
    public final boolean c(Throwable th) {
        return j().o(th);
    }

    @Override // ke.z0
    public final boolean k() {
        return true;
    }

    @Override // ke.z0
    public final void l(Throwable th) {
        this.f7702y.j(j());
    }
}
