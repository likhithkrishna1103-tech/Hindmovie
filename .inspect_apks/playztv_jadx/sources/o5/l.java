package o5;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends y5.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f9390q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final y5.a f9391r;

    public l(l5.j jVar, y5.a aVar) {
        super(jVar, (PointF) aVar.f14522b, (PointF) aVar.f14523c, aVar.f14524d, aVar.f14525e, aVar.f, aVar.f14526g, aVar.f14527h);
        this.f9391r = aVar;
        d();
    }

    public final void d() {
        Object obj;
        Object obj2 = this.f14523c;
        Object obj3 = this.f14522b;
        boolean z2 = (obj2 == null || obj3 == null || !((PointF) obj3).equals(((PointF) obj2).x, ((PointF) obj2).y)) ? false : true;
        if (obj3 == null || (obj = this.f14523c) == null || z2) {
            return;
        }
        PointF pointF = (PointF) obj3;
        PointF pointF2 = (PointF) obj;
        y5.a aVar = this.f9391r;
        PointF pointF3 = aVar.f14533o;
        PointF pointF4 = aVar.f14534p;
        b8.j jVar = x5.g.f14267a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f4 = pointF.y + pointF3.y;
            float f10 = pointF2.x;
            float f11 = f10 + pointF4.x;
            float f12 = pointF2.y;
            path.cubicTo(f, f4, f11, f12 + pointF4.y, f10, f12);
        }
        this.f9390q = path;
    }
}
