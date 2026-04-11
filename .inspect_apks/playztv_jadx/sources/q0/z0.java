package q0;

import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends a1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WindowInsetsAnimation f10525e;

    public z0(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f10525e = windowInsetsAnimation;
    }

    @Override // q0.a1
    public final float a() {
        return this.f10525e.getAlpha();
    }

    @Override // q0.a1
    public final long b() {
        return this.f10525e.getDurationMillis();
    }

    @Override // q0.a1
    public final float c() {
        return this.f10525e.getInterpolatedFraction();
    }

    @Override // q0.a1
    public final int d() {
        return this.f10525e.getTypeMask();
    }

    @Override // q0.a1
    public final void e(float f) {
        this.f10525e.setFraction(f);
    }
}
