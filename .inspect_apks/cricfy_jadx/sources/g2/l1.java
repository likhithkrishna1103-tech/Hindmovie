package g2;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f4797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1 f4798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Looper f4801e;
    public boolean f;

    public l1(j1 j1Var, k1 k1Var, v1.f1 f1Var, int i, Looper looper) {
        this.f4798b = j1Var;
        this.f4797a = k1Var;
        this.f4801e = looper;
    }

    public final synchronized void a(boolean z10) {
        notifyAll();
    }

    public final void b() {
        y1.d.g(!this.f);
        this.f = true;
        o0 o0Var = (o0) this.f4798b;
        if (!o0Var.f4824d0 && o0Var.E.getThread().isAlive()) {
            o0Var.C.a(14, this).b();
        } else {
            y1.b.p("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            a(false);
        }
    }
}
