package t0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h1 extends g1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l0.c f11761n;

    public h1(p1 p1Var, WindowInsets windowInsets) {
        super(p1Var, windowInsets);
        this.f11761n = null;
    }

    @Override // t0.m1
    public p1 b() {
        return p1.h(null, this.f11756c.consumeStableInsets());
    }

    @Override // t0.m1
    public p1 c() {
        return p1.h(null, this.f11756c.consumeSystemWindowInsets());
    }

    @Override // t0.m1
    public final l0.c i() {
        if (this.f11761n == null) {
            WindowInsets windowInsets = this.f11756c;
            this.f11761n = l0.c.c(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f11761n;
    }

    @Override // t0.m1
    public boolean n() {
        return this.f11756c.isConsumed();
    }

    @Override // t0.m1
    public void r(l0.c cVar) {
        this.f11761n = cVar;
    }
}
