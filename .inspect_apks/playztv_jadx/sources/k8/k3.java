package k8;

import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k3 extends y0 {
    public final o3 A;
    public final com.google.android.gms.internal.measurement.k4 B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.r0 f7289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final u5.c f7291z;

    public k3(k1 k1Var) {
        super(k1Var);
        this.f7290y = true;
        this.f7291z = new u5.c(25, this);
        o3 o3Var = new o3();
        o3Var.f7359x = this;
        k1 k1Var2 = (k1) this.f2454v;
        o3Var.f7358w = new p3(o3Var, k1Var2, 0);
        k1Var2.H.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        o3Var.f7356u = jElapsedRealtime;
        o3Var.f7357v = jElapsedRealtime;
        this.A = o3Var;
        com.google.android.gms.internal.measurement.k4 k4Var = new com.google.android.gms.internal.measurement.k4();
        k4Var.f3071v = this;
        this.B = k4Var;
    }

    @Override // k8.y0
    public final boolean v1() {
        return false;
    }

    public final void w1() {
        p1();
        if (this.f7289x == null) {
            this.f7289x = new com.google.android.gms.internal.measurement.r0(Looper.getMainLooper(), 0);
        }
    }
}
