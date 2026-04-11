package a2;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w1 f509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1 f510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Looper f513e;
    public boolean f;

    public x1(v1 v1Var, w1 w1Var, p1.f1 f1Var, int i, Looper looper) {
        this.f510b = v1Var;
        this.f509a = w1Var;
        this.f513e = looper;
    }

    public final synchronized void a(boolean z2) {
        notifyAll();
    }

    public final void b() {
        s1.d.g(!this.f);
        this.f = true;
        x0 x0Var = (x0) this.f510b;
        if (!x0Var.f481c0 && x0Var.D.getThread().isAlive()) {
            x0Var.B.a(14, this).b();
        } else {
            s1.b.p("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            a(false);
        }
    }
}
