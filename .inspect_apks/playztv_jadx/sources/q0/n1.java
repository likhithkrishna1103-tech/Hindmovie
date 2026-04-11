package q0;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends m1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final r1 f10474s = r1.h(null, WindowInsets.CONSUMED);

    public n1(r1 r1Var, WindowInsets windowInsets) {
        super(r1Var, windowInsets);
    }

    @Override // q0.m1, q0.i1, q0.o1
    public i0.d f(int i) {
        return i0.d.d(this.f10454c.getInsets(q1.a(i)));
    }

    @Override // q0.m1, q0.i1, q0.o1
    public i0.d g(int i) {
        return i0.d.d(this.f10454c.getInsetsIgnoringVisibility(q1.a(i)));
    }
}
