package j;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f6645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6647c;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        int i = (int) ((f * this.f6647c) + 0.5f);
        int i10 = this.f6646b;
        int[] iArr = this.f6645a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11];
            if (i < i12) {
                break;
            }
            i -= i12;
            i11++;
        }
        return (i11 / i10) + (i11 < i10 ? i / this.f6647c : 0.0f);
    }
}
