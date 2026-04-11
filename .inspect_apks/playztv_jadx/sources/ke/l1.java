package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends pe.q implements Runnable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f7707y;

    /* JADX WARN: Illegal instructions before constructor call */
    public l1(long j5, t4.d dVar) {
        rd.h hVar = dVar.f12489v;
        be.h.b(hVar);
        super(hVar, dVar);
        this.f7707y = j5;
    }

    @Override // ke.d1
    public final String M() {
        return super.M() + "(timeMillis=" + this.f7707y + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.e(this.f7673w);
        j(new k1("Timed out waiting for " + this.f7707y + " ms", this));
    }
}
