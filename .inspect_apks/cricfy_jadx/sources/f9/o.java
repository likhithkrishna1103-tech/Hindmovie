package f9;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a9.k f4295d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2 f4296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ya.s f4297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f4298c;

    public o(c2 c2Var) {
        o8.u.g(c2Var);
        this.f4296a = c2Var;
        this.f4297b = new ya.s(3, this, c2Var, false);
    }

    public abstract void a();

    public final void b(long j4) {
        c();
        if (j4 >= 0) {
            c2 c2Var = this.f4296a;
            c2Var.A0().getClass();
            this.f4298c = System.currentTimeMillis();
            if (d().postDelayed(this.f4297b, j4)) {
                return;
            }
            c2Var.C().B.b(Long.valueOf(j4), "Failed to schedule delayed post. time");
        }
    }

    public final void c() {
        this.f4298c = 0L;
        d().removeCallbacks(this.f4297b);
    }

    public final Handler d() {
        a9.k kVar;
        if (f4295d != null) {
            return f4295d;
        }
        synchronized (o.class) {
            try {
                if (f4295d == null) {
                    f4295d = new a9.k(this.f4296a.f0().getMainLooper(), 2);
                }
                kVar = f4295d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kVar;
    }
}
