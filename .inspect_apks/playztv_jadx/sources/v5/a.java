package v5;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pb.c f13265a = pb.c.k("k", "x", "y");

    public static q6.c a(w5.b bVar, l5.j jVar) {
        ArrayList arrayList = new ArrayList();
        if (bVar.g0() == 1) {
            bVar.a();
            while (bVar.G()) {
                w5.b bVar2 = bVar;
                l5.j jVar2 = jVar;
                arrayList.add(new o5.l(jVar2, o.b(bVar2, jVar2, x5.g.c(), f.f13280y, bVar.g0() == 3, false)));
                bVar = bVar2;
                jVar = jVar2;
            }
            bVar.v();
            p.b(arrayList);
        } else {
            arrayList.add(new y5.a(n.b(bVar, x5.g.c())));
        }
        return new q6.c(arrayList);
    }

    public static r5.e b(w5.b bVar, l5.j jVar) {
        bVar.d();
        q6.c cVarA = null;
        r5.b bVarY = null;
        boolean z2 = false;
        r5.b bVarY2 = null;
        while (bVar.g0() != 4) {
            int iI0 = bVar.i0(f13265a);
            if (iI0 == 0) {
                cVarA = a(bVar, jVar);
            } else if (iI0 != 1) {
                if (iI0 != 2) {
                    bVar.j0();
                    bVar.k0();
                } else if (bVar.g0() == 6) {
                    bVar.k0();
                    z2 = true;
                } else {
                    bVarY = ga.b.y(bVar, jVar, true);
                }
            } else if (bVar.g0() == 6) {
                bVar.k0();
                z2 = true;
            } else {
                bVarY2 = ga.b.y(bVar, jVar, true);
            }
        }
        bVar.x();
        if (z2) {
            jVar.a("Lottie doesn't support expressions.");
        }
        return cVarA != null ? cVarA : new r5.c(bVarY2, bVarY);
    }
}
