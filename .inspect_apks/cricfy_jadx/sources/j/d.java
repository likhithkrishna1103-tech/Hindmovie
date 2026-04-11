package j;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f6480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6482c;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        int i = (int) ((f * this.f6482c) + 0.5f);
        int i10 = this.f6481b;
        int[] iArr = this.f6480a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11];
            if (i < i12) {
                break;
            }
            i -= i12;
            i11++;
        }
        return (i11 / i10) + (i11 < i10 ? i / this.f6482c : 0.0f);
    }
}
