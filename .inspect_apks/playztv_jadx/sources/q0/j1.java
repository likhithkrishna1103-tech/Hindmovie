package q0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class j1 extends i1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i0.d f10460n;

    public j1(r1 r1Var, WindowInsets windowInsets) {
        super(r1Var, windowInsets);
        this.f10460n = null;
    }

    @Override // q0.o1
    public r1 b() {
        return r1.h(null, this.f10454c.consumeStableInsets());
    }

    @Override // q0.o1
    public r1 c() {
        return r1.h(null, this.f10454c.consumeSystemWindowInsets());
    }

    @Override // q0.o1
    public final i0.d i() {
        if (this.f10460n == null) {
            WindowInsets windowInsets = this.f10454c;
            this.f10460n = i0.d.c(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f10460n;
    }

    @Override // q0.o1
    public boolean n() {
        return this.f10454c.isConsumed();
    }

    @Override // q0.o1
    public void r(i0.d dVar) {
        this.f10460n = dVar;
    }
}
