package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends l0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l1 f7703w;

    public k0(long j5, l1 l1Var) {
        this.f7705u = j5;
        this.f7706v = -1;
        this.f7703w = l1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7703w.run();
    }

    @Override // ke.l0
    public final String toString() {
        return super.toString() + this.f7703w;
    }
}
