package k8;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile com.google.android.gms.internal.measurement.r0 f7320d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w1 f7321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ea.t f7322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f7323c;

    public n(w1 w1Var) {
        t7.v.h(w1Var);
        this.f7321a = w1Var;
        this.f7322b = new ea.t(7, this, w1Var, false);
    }

    public final void a() {
        this.f7323c = 0L;
        d().removeCallbacks(this.f7322b);
    }

    public final void b(long j5) {
        a();
        if (j5 >= 0) {
            this.f7321a.y0().getClass();
            this.f7323c = System.currentTimeMillis();
            if (d().postDelayed(this.f7322b, j5)) {
                return;
            }
            this.f7321a.g().A.c(Long.valueOf(j5), "Failed to schedule delayed post. time");
        }
    }

    public abstract void c();

    public final Handler d() {
        com.google.android.gms.internal.measurement.r0 r0Var;
        if (f7320d != null) {
            return f7320d;
        }
        synchronized (n.class) {
            try {
                if (f7320d == null) {
                    f7320d = new com.google.android.gms.internal.measurement.r0(this.f7321a.a().getMainLooper(), 0);
                }
                r0Var = f7320d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return r0Var;
    }
}
