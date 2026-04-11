package t0;

import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends y0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WindowInsetsAnimation f11825e;

    public x0(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f11825e = windowInsetsAnimation;
    }

    @Override // t0.y0
    public final float a() {
        return this.f11825e.getAlpha();
    }

    @Override // t0.y0
    public final long b() {
        return this.f11825e.getDurationMillis();
    }

    @Override // t0.y0
    public final float c() {
        return this.f11825e.getInterpolatedFraction();
    }

    @Override // t0.y0
    public final int d() {
        return this.f11825e.getTypeMask();
    }

    @Override // t0.y0
    public final void e(float f) {
        this.f11825e.setFraction(f);
    }
}
