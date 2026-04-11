package v5;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x implements d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final x f13317u = new x();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final pb.c f13318v = pb.c.k("c", "v", "i", "o");

    @Override // v5.d0
    public final Object a(w5.a aVar, float f) {
        if (aVar.g0() == 1) {
            aVar.a();
        }
        aVar.d();
        ArrayList arrayListC = null;
        ArrayList arrayListC2 = null;
        ArrayList arrayListC3 = null;
        boolean zH = false;
        while (aVar.G()) {
            int iI0 = aVar.i0(f13318v);
            if (iI0 == 0) {
                zH = aVar.H();
            } else if (iI0 == 1) {
                arrayListC = n.c(aVar, f);
            } else if (iI0 == 2) {
                arrayListC2 = n.c(aVar, f);
            } else if (iI0 != 3) {
                aVar.j0();
                aVar.k0();
            } else {
                arrayListC3 = n.c(aVar, f);
            }
        }
        aVar.x();
        if (aVar.g0() == 2) {
            aVar.v();
        }
        if (arrayListC == null || arrayListC2 == null || arrayListC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (arrayListC.isEmpty()) {
            return new s5.k(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = arrayListC.size();
        PointF pointF = (PointF) arrayListC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = (PointF) arrayListC.get(i);
            int i10 = i - 1;
            arrayList.add(new q5.a(x5.f.a((PointF) arrayListC.get(i10), (PointF) arrayListC3.get(i10)), x5.f.a(pointF2, (PointF) arrayListC2.get(i)), pointF2));
        }
        if (zH) {
            PointF pointF3 = (PointF) arrayListC.get(0);
            int i11 = size - 1;
            arrayList.add(new q5.a(x5.f.a((PointF) arrayListC.get(i11), (PointF) arrayListC3.get(i11)), x5.f.a(pointF3, (PointF) arrayListC2.get(0)), pointF3));
        }
        return new s5.k(pointF, zH, arrayList);
    }
}
