package o5;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends k {
    public final PointF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f9392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f9393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathMeasure f9394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f9395m;

    public m(ArrayList arrayList) {
        super(arrayList);
        this.i = new PointF();
        this.f9392j = new float[2];
        this.f9393k = new float[2];
        this.f9394l = new PathMeasure();
    }

    @Override // o5.e
    public final Object f(y5.a aVar, float f) {
        float f4;
        l lVar = (l) aVar;
        Path path = lVar.f9390q;
        if (path == null) {
            return (PointF) aVar.f14522b;
        }
        p2.c cVar = this.f9379e;
        if (cVar != null) {
            f4 = f;
            PointF pointF = (PointF) cVar.n(lVar.f14526g, lVar.f14527h.floatValue(), (PointF) lVar.f14522b, (PointF) lVar.f14523c, d(), f4, this.f9378d);
            if (pointF != null) {
                return pointF;
            }
        } else {
            f4 = f;
        }
        l lVar2 = this.f9395m;
        PathMeasure pathMeasure = this.f9394l;
        if (lVar2 != lVar) {
            pathMeasure.setPath(path, false);
            this.f9395m = lVar;
        }
        float length = pathMeasure.getLength();
        float f10 = f4 * length;
        float[] fArr = this.f9392j;
        float[] fArr2 = this.f9393k;
        pathMeasure.getPosTan(f10, fArr, fArr2);
        float f11 = fArr[0];
        float f12 = fArr[1];
        PointF pointF2 = this.i;
        pointF2.set(f11, f12);
        if (f10 < 0.0f) {
            pointF2.offset(fArr2[0] * f10, fArr2[1] * f10);
            return pointF2;
        }
        if (f10 > length) {
            float f13 = f10 - length;
            pointF2.offset(fArr2[0] * f13, fArr2[1] * f13);
        }
        return pointF2;
    }
}
