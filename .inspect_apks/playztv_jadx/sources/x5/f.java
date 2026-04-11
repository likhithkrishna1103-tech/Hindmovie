package x5;

import android.graphics.Path;
import android.graphics.PointF;
import e6.j;
import java.util.ArrayList;
import s5.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointF f14266a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f4, float f10) {
        return Math.max(f4, Math.min(f10, f));
    }

    public static int c(float f, float f4) {
        int i = (int) f;
        int i10 = (int) f4;
        int i11 = i / i10;
        int i12 = i % i10;
        if (!((i ^ i10) >= 0) && i12 != 0) {
            i11--;
        }
        return i - (i10 * i11);
    }

    public static void d(k kVar, Path path) {
        Path path2;
        path.reset();
        PointF pointF = kVar.f11837b;
        ArrayList arrayList = kVar.f11836a;
        path.moveTo(pointF.x, pointF.y);
        float f = pointF.x;
        float f4 = pointF.y;
        PointF pointF2 = f14266a;
        pointF2.set(f, f4);
        int i = 0;
        while (i < arrayList.size()) {
            q5.a aVar = (q5.a) arrayList.get(i);
            PointF pointF3 = aVar.f10987a;
            PointF pointF4 = aVar.f10988b;
            PointF pointF5 = aVar.f10989c;
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
        if (kVar.f11838c) {
            path3.close();
        }
    }

    public static float e(float f, float f4, float f10) {
        return j.g(f4, f, f10, f);
    }

    public static void f(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2, n5.k kVar) {
        if (eVar.a(kVar.getName(), i)) {
            String name = kVar.getName();
            q5.e eVar3 = new q5.e(eVar2);
            eVar3.f11011a.add(name);
            q5.e eVar4 = new q5.e(eVar3);
            eVar4.f11012b = kVar;
            arrayList.add(eVar4);
        }
    }
}
