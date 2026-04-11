package q5;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f10987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f10988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f10989c;

    public a() {
        this.f10987a = new PointF();
        this.f10988b = new PointF();
        this.f10989c = new PointF();
    }

    public final String toString() {
        PointF pointF = this.f10989c;
        Float fValueOf = Float.valueOf(pointF.x);
        Float fValueOf2 = Float.valueOf(pointF.y);
        PointF pointF2 = this.f10987a;
        Float fValueOf3 = Float.valueOf(pointF2.x);
        Float fValueOf4 = Float.valueOf(pointF2.y);
        PointF pointF3 = this.f10988b;
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", fValueOf, fValueOf2, fValueOf3, fValueOf4, Float.valueOf(pointF3.x), Float.valueOf(pointF3.y));
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f10987a = pointF;
        this.f10988b = pointF2;
        this.f10989c = pointF3;
    }
}
