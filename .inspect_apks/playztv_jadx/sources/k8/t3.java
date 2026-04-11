package k8;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class t3 extends u3 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7433x;

    public t3(x3 x3Var) {
        super(x3Var);
        this.f7443w.L++;
    }

    public final void t1() {
        if (!this.f7433x) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void u1() {
        if (this.f7433x) {
            throw new IllegalStateException("Can't initialize twice");
        }
        v1();
        this.f7443w.M++;
        this.f7433x = true;
    }

    public abstract boolean v1();
}
