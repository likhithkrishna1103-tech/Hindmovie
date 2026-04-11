package l6;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f7834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f7835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f7836c;

    public a() {
        this.f7834a = new PointF();
        this.f7835b = new PointF();
        this.f7836c = new PointF();
    }

    public final String toString() {
        PointF pointF = this.f7836c;
        Float fValueOf = Float.valueOf(pointF.x);
        Float fValueOf2 = Float.valueOf(pointF.y);
        PointF pointF2 = this.f7834a;
        Float fValueOf3 = Float.valueOf(pointF2.x);
        Float fValueOf4 = Float.valueOf(pointF2.y);
        PointF pointF3 = this.f7835b;
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", fValueOf, fValueOf2, fValueOf3, fValueOf4, Float.valueOf(pointF3.x), Float.valueOf(pointF3.y));
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f7834a = pointF;
        this.f7835b = pointF2;
        this.f7836c = pointF3;
    }
}
