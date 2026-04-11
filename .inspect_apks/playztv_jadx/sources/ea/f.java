package ea;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e0 f4608u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y f4609v;

    public f(e0 e0Var, y yVar) {
        this.f4608u = e0Var;
        this.f4609v = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4608u.f4625u != this) {
            return;
        }
        if (p.f4624z.f(this.f4608u, this, p.h(this.f4609v))) {
            p.d(this.f4608u, false);
        }
    }
}
