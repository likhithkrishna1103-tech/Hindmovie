package t0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends k1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final p1 f11776s = p1.h(null, WindowInsets.CONSUMED);

    public l1(p1 p1Var, WindowInsets windowInsets) {
        super(p1Var, windowInsets);
    }

    @Override // t0.k1, t0.g1, t0.m1
    public l0.c f(int i) {
        return l0.c.d(this.f11756c.getInsets(o1.a(i)));
    }

    @Override // t0.k1, t0.g1, t0.m1
    public l0.c g(int i) {
        return l0.c.d(this.f11756c.getInsetsIgnoringVisibility(o1.a(i)));
    }
}
