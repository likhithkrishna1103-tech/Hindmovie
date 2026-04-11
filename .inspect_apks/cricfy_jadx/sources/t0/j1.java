package t0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class j1 extends i1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l0.c f11763o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l0.c f11764p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public l0.c f11765q;

    public j1(p1 p1Var, WindowInsets windowInsets) {
        super(p1Var, windowInsets);
        this.f11763o = null;
        this.f11764p = null;
        this.f11765q = null;
    }

    @Override // t0.m1
    public l0.c h() {
        if (this.f11764p == null) {
            this.f11764p = l0.c.d(this.f11756c.getMandatorySystemGestureInsets());
        }
        return this.f11764p;
    }

    @Override // t0.m1
    public l0.c j() {
        if (this.f11763o == null) {
            this.f11763o = l0.c.d(this.f11756c.getSystemGestureInsets());
        }
        return this.f11763o;
    }

    @Override // t0.m1
    public l0.c l() {
        if (this.f11765q == null) {
            this.f11765q = l0.c.d(this.f11756c.getTappableElementInsets());
        }
        return this.f11765q;
    }

    @Override // t0.g1, t0.m1
    public p1 m(int i, int i10, int i11, int i12) {
        return p1.h(null, this.f11756c.inset(i, i10, i11, i12));
    }

    @Override // t0.h1, t0.m1
    public void r(l0.c cVar) {
    }
}
