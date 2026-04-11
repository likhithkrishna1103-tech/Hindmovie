package j6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends k {
    public final PointF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f6648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f6649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathMeasure f6650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f6651m;

    public m(ArrayList arrayList) {
        super(arrayList);
        this.i = new PointF();
        this.f6648j = new float[2];
        this.f6649k = new float[2];
        this.f6650l = new PathMeasure();
    }

    @Override // j6.e
    public final Object f(t6.a aVar, float f) {
        float f10;
        l lVar = (l) aVar;
        Path path = lVar.f6646q;
        w wVar = this.f6634e;
        if (wVar == null || aVar.f11937h == null) {
            f10 = f;
        } else {
            f10 = f;
            PointF pointF = (PointF) wVar.G(lVar.f11936g, lVar.f11937h.floatValue(), (PointF) lVar.f11932b, (PointF) lVar.f11933c, d(), f10, this.f6633d);
            if (pointF != null) {
                return pointF;
            }
        }
        if (path == null) {
            return (PointF) aVar.f11932b;
        }
        l lVar2 = this.f6651m;
        PathMeasure pathMeasure = this.f6650l;
        if (lVar2 != lVar) {
            pathMeasure.setPath(path, false);
            this.f6651m = lVar;
        }
        float length = pathMeasure.getLength();
        float f11 = f10 * length;
        float[] fArr = this.f6648j;
        float[] fArr2 = this.f6649k;
        pathMeasure.getPosTan(f11, fArr, fArr2);
        float f12 = fArr[0];
        float f13 = fArr[1];
        PointF pointF2 = this.i;
        pointF2.set(f12, f13);
        if (f11 < 0.0f) {
            pointF2.offset(fArr2[0] * f11, fArr2[1] * f11);
            return pointF2;
        }
        if (f11 > length) {
            float f14 = f11 - length;
            pointF2.offset(fArr2[0] * f14, fArr2[1] * f14);
        }
        return pointF2;
    }
}
