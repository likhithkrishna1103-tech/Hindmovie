package q8;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import e6.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f11072a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k1.a f11073b = new k1.a(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k1.a f11074c = new k1.a(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k1.a f11075d = new k1.a(k1.a.f6971e);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f11076e = new DecelerateInterpolator();

    public static float a(float f, float f4, float f10) {
        return j.g(f4, f, f10, f);
    }

    public static float b(float f, float f4, float f10, float f11, float f12) {
        return f12 <= f10 ? f : f12 >= f11 ? f4 : a(f, f4, (f12 - f10) / (f11 - f10));
    }

    public static int c(float f, int i, int i10) {
        return Math.round(f * (i10 - i)) + i;
    }
}
