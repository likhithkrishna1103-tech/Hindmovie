package k1;

import android.view.animation.Interpolator;
import e6.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f6972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6973b;

    public b(float[] fArr) {
        this.f6972a = fArr;
        this.f6973b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f6972a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f4 = this.f6973b;
        float f10 = (f - (iMin * f4)) / f4;
        float f11 = fArr[iMin];
        return j.g(fArr[iMin + 1], f11, f10, f11);
    }
}
