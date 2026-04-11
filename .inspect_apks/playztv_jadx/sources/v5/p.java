package v5;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pb.c f13304a = pb.c.k("k");

    public static ArrayList a(w5.a aVar, l5.j jVar, float f, d0 d0Var, boolean z2) {
        w5.a aVar2;
        l5.j jVar2;
        float f4;
        d0 d0Var2;
        boolean z10;
        ArrayList arrayList = new ArrayList();
        if (aVar.g0() == 6) {
            jVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        aVar.d();
        while (aVar.G()) {
            if (aVar.i0(f13304a) != 0) {
                aVar.k0();
            } else if (aVar.g0() == 1) {
                aVar.a();
                if (aVar.g0() == 7) {
                    w5.a aVar3 = aVar;
                    l5.j jVar3 = jVar;
                    float f10 = f;
                    d0 d0Var3 = d0Var;
                    boolean z11 = z2;
                    y5.a aVarB = o.b(aVar3, jVar3, f10, d0Var3, false, z11);
                    aVar2 = aVar3;
                    jVar2 = jVar3;
                    f4 = f10;
                    d0Var2 = d0Var3;
                    z10 = z11;
                    arrayList.add(aVarB);
                } else {
                    aVar2 = aVar;
                    jVar2 = jVar;
                    f4 = f;
                    d0Var2 = d0Var;
                    z10 = z2;
                    while (aVar2.G()) {
                        arrayList.add(o.b(aVar2, jVar2, f4, d0Var2, true, z10));
                    }
                }
                aVar2.v();
                aVar = aVar2;
                jVar = jVar2;
                f = f4;
                d0Var = d0Var2;
                z2 = z10;
            } else {
                w5.a aVar4 = aVar;
                arrayList.add(o.b(aVar4, jVar, f, d0Var, false, z2));
                aVar = aVar4;
            }
        }
        aVar.x();
        b(arrayList);
        return arrayList;
    }

    public static void b(ArrayList arrayList) {
        int i;
        Object obj;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            i = size - 1;
            if (i10 >= i) {
                break;
            }
            y5.a aVar = (y5.a) arrayList.get(i10);
            i10++;
            y5.a aVar2 = (y5.a) arrayList.get(i10);
            aVar.f14527h = Float.valueOf(aVar2.f14526g);
            if (aVar.f14523c == null && (obj = aVar2.f14522b) != null) {
                aVar.f14523c = obj;
                if (aVar instanceof o5.l) {
                    ((o5.l) aVar).d();
                }
            }
        }
        y5.a aVar3 = (y5.a) arrayList.get(i);
        if ((aVar3.f14522b == null || aVar3.f14523c == null) && arrayList.size() > 1) {
            arrayList.remove(aVar3);
        }
    }
}
