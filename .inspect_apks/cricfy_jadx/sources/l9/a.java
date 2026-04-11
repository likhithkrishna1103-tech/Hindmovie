package l9;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f7925a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q1.a f7926b = new q1.a(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q1.a f7927c = new q1.a(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q1.a f7928d = new q1.a(q1.a.f10353e);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f7929e = new DecelerateInterpolator();

    public static float a(float f, float f10, float f11) {
        return q4.a.h(f10, f, f11, f);
    }

    public static float b(float f, float f10, float f11, float f12, float f13) {
        return f13 <= f11 ? f : f13 >= f12 ? f10 : a(f, f10, (f13 - f11) / (f12 - f11));
    }

    public static int c(float f, int i, int i10) {
        return Math.round(f * (i10 - i)) + i;
    }
}
