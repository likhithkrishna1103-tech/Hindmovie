package k8;

import com.google.android.gms.internal.measurement.d7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ z1 f7369u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f7370v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f7371w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ boolean f7372x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ z1 f7373y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ g2 f7374z;

    public p2(g2 g2Var, z1 z1Var, long j5, long j8, boolean z2, z1 z1Var2) {
        this.f7369u = z1Var;
        this.f7370v = j5;
        this.f7371w = j8;
        this.f7372x = z2;
        this.f7373y = z1Var2;
        this.f7374z = g2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g2 g2Var = this.f7374z;
        z1 z1Var = this.f7369u;
        g2Var.F1(z1Var);
        d7.a();
        if (!((k1) g2Var.f2454v).A.A1(null, w.X0)) {
            g2Var.J1(false, this.f7370v);
        }
        g2.H1(g2Var, z1Var, this.f7371w, true, this.f7372x);
        g2.I1(g2Var, z1Var, this.f7373y);
    }
}
