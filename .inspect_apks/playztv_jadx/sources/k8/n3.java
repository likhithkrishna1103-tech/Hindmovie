package k8;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f7334u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f7335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.k4 f7336w;

    public n3(com.google.android.gms.internal.measurement.k4 k4Var, long j5, long j8) {
        this.f7336w = k4Var;
        this.f7334u = j5;
        this.f7335v = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h1 h1VarX = ((k3) this.f7336w.f3071v).x();
        androidx.fragment.app.e eVar = new androidx.fragment.app.e(10);
        eVar.f1266v = this;
        h1VarX.y1(eVar);
    }
}
