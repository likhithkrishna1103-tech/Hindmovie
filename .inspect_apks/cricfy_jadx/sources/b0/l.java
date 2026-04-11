package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f1615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1616b;

    public static long a(f fVar, long j4) {
        o oVar = fVar.f1605d;
        ArrayList arrayList = fVar.f1610k;
        if (oVar instanceof j) {
            return j4;
        }
        int size = arrayList.size();
        long jMin = j4;
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1605d != oVar) {
                    jMin = Math.min(jMin, a(fVar2, ((long) fVar2.f) + j4));
                }
            }
        }
        f fVar3 = oVar.i;
        f fVar4 = oVar.f1630h;
        if (fVar != fVar3) {
            return jMin;
        }
        long j7 = j4 - oVar.j();
        return Math.min(Math.min(jMin, a(fVar4, j7)), j7 - ((long) fVar4.f));
    }

    public static long b(f fVar, long j4) {
        o oVar = fVar.f1605d;
        ArrayList arrayList = fVar.f1610k;
        if (oVar instanceof j) {
            return j4;
        }
        int size = arrayList.size();
        long jMax = j4;
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f1605d != oVar) {
                    jMax = Math.max(jMax, b(fVar2, ((long) fVar2.f) + j4));
                }
            }
        }
        f fVar3 = oVar.f1630h;
        f fVar4 = oVar.i;
        if (fVar != fVar3) {
            return jMax;
        }
        long j7 = oVar.j() + j4;
        return Math.max(Math.max(jMax, b(fVar4, j7)), j7 - ((long) fVar4.f));
    }
}
