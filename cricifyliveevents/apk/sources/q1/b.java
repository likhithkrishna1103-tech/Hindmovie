package q1;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f10354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10355b;

    public b(float[] fArr) {
        this.f10354a = fArr;
        this.f10355b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f10354a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f10 = this.f10355b;
        float f11 = (f - (iMin * f10)) / f10;
        float f12 = fArr[iMin];
        return q4.a.h(fArr[iMin + 1], f12, f11, f12);
    }
}
