package k8;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 extends d0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7553w;

    public y0(k1 k1Var) {
        super(k1Var);
        ((k1) this.f2454v).Y++;
    }

    public final void t1() {
        if (!this.f7553w) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void u1() {
        if (this.f7553w) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (v1()) {
            return;
        }
        ((k1) this.f2454v).f7280a0.incrementAndGet();
        this.f7553w = true;
    }

    public abstract boolean v1();
}
