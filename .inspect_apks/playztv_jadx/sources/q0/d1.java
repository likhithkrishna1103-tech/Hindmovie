package q0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f10434c;

    public d1() {
        this.f10434c = i0.c.h();
    }

    @Override // q0.h1
    public r1 b() {
        a();
        r1 r1VarH = r1.h(null, this.f10434c.build());
        r1VarH.f10492a.p(this.f10449b);
        return r1VarH;
    }

    @Override // q0.h1
    public void d(i0.d dVar) {
        this.f10434c.setMandatorySystemGestureInsets(dVar.e());
    }

    @Override // q0.h1
    public void e(i0.d dVar) {
        this.f10434c.setStableInsets(dVar.e());
    }

    @Override // q0.h1
    public void f(i0.d dVar) {
        this.f10434c.setSystemGestureInsets(dVar.e());
    }

    @Override // q0.h1
    public void g(i0.d dVar) {
        this.f10434c.setSystemWindowInsets(dVar.e());
    }

    @Override // q0.h1
    public void h(i0.d dVar) {
        this.f10434c.setTappableElementInsets(dVar.e());
    }

    public d1(r1 r1Var) {
        WindowInsets.Builder builderH;
        super(r1Var);
        WindowInsets windowInsetsG = r1Var.g();
        if (windowInsetsG != null) {
            builderH = i0.c.i(windowInsetsG);
        } else {
            builderH = i0.c.h();
        }
        this.f10434c = builderH;
    }
}
