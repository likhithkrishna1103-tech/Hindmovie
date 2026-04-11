package q0;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f10414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Interpolator f10415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10416d;

    public a1(int i, Interpolator interpolator, long j5) {
        this.f10413a = i;
        this.f10415c = interpolator;
        this.f10416d = j5;
    }

    public float a() {
        return 1.0f;
    }

    public long b() {
        return this.f10416d;
    }

    public float c() {
        Interpolator interpolator = this.f10415c;
        return interpolator != null ? interpolator.getInterpolation(this.f10414b) : this.f10414b;
    }

    public int d() {
        return this.f10413a;
    }

    public void e(float f) {
        this.f10414b = f;
    }
}
