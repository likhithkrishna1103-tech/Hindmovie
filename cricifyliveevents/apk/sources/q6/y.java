package q6;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements e0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final y f10442v = new y();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final nb.w f10443w = nb.w.I("c", "v", "i", "o");

    @Override // q6.e0
    public final Object a(r6.a aVar, float f) {
        if (aVar.R() == 1) {
            aVar.a();
        }
        aVar.g();
        ArrayList arrayListC = null;
        ArrayList arrayListC2 = null;
        ArrayList arrayListC3 = null;
        boolean zC = false;
        while (aVar.A()) {
            int iG0 = aVar.g0(f10443w);
            if (iG0 == 0) {
                zC = aVar.C();
            } else if (iG0 == 1) {
                arrayListC = o.c(aVar, f);
            } else if (iG0 == 2) {
                arrayListC2 = o.c(aVar, f);
            } else if (iG0 != 3) {
                aVar.h0();
                aVar.i0();
            } else {
                arrayListC3 = o.c(aVar, f);
            }
        }
        aVar.s();
        if (aVar.R() == 2) {
            aVar.q();
        }
        if (arrayListC == null || arrayListC2 == null || arrayListC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (arrayListC.isEmpty()) {
            return new n6.k(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = arrayListC.size();
        PointF pointF = (PointF) arrayListC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = (PointF) arrayListC.get(i);
            int i10 = i - 1;
            arrayList.add(new l6.a(s6.g.a((PointF) arrayListC.get(i10), (PointF) arrayListC3.get(i10)), s6.g.a(pointF2, (PointF) arrayListC2.get(i)), pointF2));
        }
        if (zC) {
            PointF pointF3 = (PointF) arrayListC.get(0);
            int i11 = size - 1;
            arrayList.add(new l6.a(s6.g.a((PointF) arrayListC.get(i11), (PointF) arrayListC3.get(i11)), s6.g.a(pointF3, (PointF) arrayListC2.get(0)), pointF3));
        }
        return new n6.k(pointF, zC, arrayList);
    }
}
