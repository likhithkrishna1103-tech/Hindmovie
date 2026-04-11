package f9;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f4499v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4500w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ l4.c0 f4501x;

    public y3(l4.c0 c0Var, long j4, long j7) {
        Objects.requireNonNull(c0Var);
        this.f4501x = c0Var;
        this.f4499v = j4;
        this.f4500w = j7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p1 p1Var = ((r1) ((b4) this.f4501x.f7706x).f307w).B;
        r1.g(p1Var);
        p1Var.v1(new androidx.fragment.app.m(8, this));
    }
}
