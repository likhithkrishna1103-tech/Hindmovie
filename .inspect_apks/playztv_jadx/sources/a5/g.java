package a5;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends RuntimeException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Throwable f551v;

    public g(h hVar, Throwable th) {
        super(th);
        this.f550u = hVar;
        this.f551v = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f551v;
    }
}
