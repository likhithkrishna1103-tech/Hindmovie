package j6;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends t6.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f6646q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final t6.a f6647r;

    public l(g6.i iVar, t6.a aVar) {
        super(iVar, (PointF) aVar.f11932b, (PointF) aVar.f11933c, aVar.f11934d, aVar.f11935e, aVar.f, aVar.f11936g, aVar.f11937h);
        this.f6647r = aVar;
        d();
    }

    public final void d() {
        Object obj;
        Object obj2 = this.f11933c;
        Object obj3 = this.f11932b;
        boolean z10 = (obj2 == null || obj3 == null || !((PointF) obj3).equals(((PointF) obj2).x, ((PointF) obj2).y)) ? false : true;
        if (obj3 == null || (obj = this.f11933c) == null || z10) {
            return;
        }
        PointF pointF = (PointF) obj3;
        PointF pointF2 = (PointF) obj;
        t6.a aVar = this.f6647r;
        PointF pointF3 = aVar.f11943o;
        PointF pointF4 = aVar.f11944p;
        Matrix matrix = s6.i.f11583a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f10 = pointF.y + pointF3.y;
            float f11 = pointF2.x;
            float f12 = f11 + pointF4.x;
            float f13 = pointF2.y;
            path.cubicTo(f, f10, f12, f13 + pointF4.y, f11, f13);
        }
        this.f6646q = path;
    }
}
