package t0;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Interpolator f11828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11829d;

    public y0(int i, Interpolator interpolator, long j4) {
        this.f11826a = i;
        this.f11828c = interpolator;
        this.f11829d = j4;
    }

    public float a() {
        return 1.0f;
    }

    public long b() {
        return this.f11829d;
    }

    public float c() {
        Interpolator interpolator = this.f11828c;
        return interpolator != null ? interpolator.getInterpolation(this.f11827b) : this.f11827b;
    }

    public int d() {
        return this.f11826a;
    }

    public void e(float f) {
        this.f11827b = f;
    }
}
