package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f14403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f14404b;

    public static long a(f fVar, long j5) {
        o oVar = fVar.f14393d;
        ArrayList arrayList = fVar.f14398k;
        if (oVar instanceof j) {
            return j5;
        }
        int size = arrayList.size();
        long jMin = j5;
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f14393d != oVar) {
                    jMin = Math.min(jMin, a(fVar2, ((long) fVar2.f) + j5));
                }
            }
        }
        f fVar3 = oVar.i;
        f fVar4 = oVar.f14418h;
        if (fVar != fVar3) {
            return jMin;
        }
        long j8 = j5 - oVar.j();
        return Math.min(Math.min(jMin, a(fVar4, j8)), j8 - ((long) fVar4.f));
    }

    public static long b(f fVar, long j5) {
        o oVar = fVar.f14393d;
        ArrayList arrayList = fVar.f14398k;
        if (oVar instanceof j) {
            return j5;
        }
        int size = arrayList.size();
        long jMax = j5;
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f14393d != oVar) {
                    jMax = Math.max(jMax, b(fVar2, ((long) fVar2.f) + j5));
                }
            }
        }
        f fVar3 = oVar.f14418h;
        f fVar4 = oVar.i;
        if (fVar != fVar3) {
            return jMax;
        }
        long j8 = oVar.j() + j5;
        return Math.max(Math.max(jMax, b(fVar4, j8)), j8 - ((long) fVar4.f));
    }
}
