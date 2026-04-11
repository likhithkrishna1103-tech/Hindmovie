package t0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c1 extends f1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f11736c;

    public c1() {
        this.f11736c = b1.d();
    }

    @Override // t0.f1
    public p1 b() {
        a();
        p1 p1VarH = p1.h(null, this.f11736c.build());
        p1VarH.f11791a.p(this.f11744b);
        return p1VarH;
    }

    @Override // t0.f1
    public void d(l0.c cVar) {
        this.f11736c.setMandatorySystemGestureInsets(cVar.e());
    }

    @Override // t0.f1
    public void e(l0.c cVar) {
        this.f11736c.setStableInsets(cVar.e());
    }

    @Override // t0.f1
    public void f(l0.c cVar) {
        this.f11736c.setSystemGestureInsets(cVar.e());
    }

    @Override // t0.f1
    public void g(l0.c cVar) {
        this.f11736c.setSystemWindowInsets(cVar.e());
    }

    @Override // t0.f1
    public void h(l0.c cVar) {
        this.f11736c.setTappableElementInsets(cVar.e());
    }

    public c1(p1 p1Var) {
        WindowInsets.Builder builderD;
        super(p1Var);
        WindowInsets windowInsetsG = p1Var.g();
        if (windowInsetsG != null) {
            builderD = b1.e(windowInsetsG);
        } else {
            builderD = b1.d();
        }
        this.f11736c = builderD;
    }
}
