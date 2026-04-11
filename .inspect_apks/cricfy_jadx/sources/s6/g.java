package s6;

import android.graphics.Path;
import android.graphics.PointF;
import i6.l;
import java.util.ArrayList;
import n6.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointF f11558a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f10, float f11) {
        return Math.max(f10, Math.min(f11, f));
    }

    public static int c(int i) {
        return Math.max(0, Math.min(255, i));
    }

    public static int d(float f, float f10) {
        int i = (int) f;
        int i10 = (int) f10;
        int i11 = i / i10;
        int i12 = i % i10;
        if (!((i ^ i10) >= 0) && i12 != 0) {
            i11--;
        }
        return i - (i10 * i11);
    }

    public static void e(k kVar, Path path) {
        Path path2;
        path.reset();
        PointF pointF = kVar.f8821b;
        ArrayList arrayList = kVar.f8820a;
        path.moveTo(pointF.x, pointF.y);
        float f = pointF.x;
        float f10 = pointF.y;
        PointF pointF2 = f11558a;
        pointF2.set(f, f10);
        int i = 0;
        while (i < arrayList.size()) {
            l6.a aVar = (l6.a) arrayList.get(i);
            PointF pointF3 = aVar.f7834a;
            PointF pointF4 = aVar.f7835b;
            PointF pointF5 = aVar.f7836c;
            if (pointF3.equals(pointF2) && pointF4.equals(pointF5)) {
                path.lineTo(pointF5.x, pointF5.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(pointF3.x, pointF3.y, pointF4.x, pointF4.y, pointF5.x, pointF5.y);
            }
            pointF2.set(pointF5.x, pointF5.y);
            i++;
            path = path2;
        }
        Path path3 = path;
        if (kVar.f8822c) {
            path3.close();
        }
    }

    public static float f(float f, float f10, float f11) {
        return q4.a.h(f10, f, f11, f);
    }

    public static void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2, l lVar) {
        if (eVar.a(i, lVar.getName())) {
            String name = lVar.getName();
            l6.e eVar3 = new l6.e(eVar2);
            eVar3.f7858a.add(name);
            l6.e eVar4 = new l6.e(eVar3);
            eVar4.f7859b = lVar;
            arrayList.add(eVar4);
        }
    }
}
