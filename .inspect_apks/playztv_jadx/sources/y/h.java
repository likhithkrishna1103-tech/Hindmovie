package y;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14401a = new b();

    public static boolean a(x.e eVar) {
        int[] iArr = eVar.f14149p0;
        int i = iArr[0];
        int i10 = iArr[1];
        x.e eVar2 = eVar.T;
        x.f fVar = eVar2 != null ? (x.f) eVar2 : null;
        if (fVar != null) {
            int i11 = fVar.f14149p0[0];
        }
        if (fVar != null) {
            int i12 = fVar.f14149p0[1];
        }
        boolean z2 = i == 1 || eVar.A() || i == 2 || (i == 3 && eVar.f14151r == 0 && eVar.W == 0.0f && eVar.t(0)) || (i == 3 && eVar.f14151r == 1 && eVar.u(0, eVar.q()));
        boolean z10 = i10 == 1 || eVar.B() || i10 == 2 || (i10 == 3 && eVar.f14152s == 0 && eVar.W == 0.0f && eVar.t(1)) || (i10 == 3 && eVar.f14152s == 1 && eVar.u(1, eVar.k()));
        return (eVar.W > 0.0f && (z2 || z10)) || (z2 && z10);
    }

    public static n b(x.e eVar, int i, ArrayList arrayList, n nVar) {
        int i10;
        int i11 = i == 0 ? eVar.f14145n0 : eVar.f14147o0;
        if (i11 != -1 && (nVar == null || i11 != nVar.f14408b)) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                n nVar2 = (n) arrayList.get(i12);
                if (nVar2.f14408b == i11) {
                    if (nVar != null) {
                        nVar.c(i, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if (eVar instanceof x.j) {
                x.j jVar = (x.j) eVar;
                int i13 = 0;
                while (true) {
                    if (i13 >= jVar.f14202r0) {
                        i10 = -1;
                        break;
                    }
                    x.e eVar2 = jVar.f14201q0[i13];
                    if ((i == 0 && (i10 = eVar2.f14145n0) != -1) || (i == 1 && (i10 = eVar2.f14147o0) != -1)) {
                        break;
                    }
                    i13++;
                }
                if (i10 != -1) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= arrayList.size()) {
                            break;
                        }
                        n nVar3 = (n) arrayList.get(i14);
                        if (nVar3.f14408b == i10) {
                            nVar = nVar3;
                            break;
                        }
                        i14++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n();
                nVar.f14407a = new ArrayList();
                nVar.f14410d = null;
                nVar.f14411e = -1;
                int i15 = n.f;
                n.f = i15 + 1;
                nVar.f14408b = i15;
                nVar.f14409c = i;
            }
            arrayList.add(nVar);
        }
        int i16 = nVar.f14408b;
        ArrayList arrayList2 = nVar.f14407a;
        if (arrayList2.contains(eVar)) {
            return nVar;
        }
        arrayList2.add(eVar);
        if (eVar instanceof x.i) {
            x.i iVar = (x.i) eVar;
            iVar.f14198t0.c(iVar.f14199u0 == 0 ? 1 : 0, arrayList, nVar);
        }
        if (i == 0) {
            eVar.f14145n0 = i16;
            eVar.I.c(i, arrayList, nVar);
            eVar.K.c(i, arrayList, nVar);
        } else {
            eVar.f14147o0 = i16;
            eVar.J.c(i, arrayList, nVar);
            eVar.M.c(i, arrayList, nVar);
            eVar.L.c(i, arrayList, nVar);
        }
        eVar.P.c(i, arrayList, nVar);
        return nVar;
    }

    public static void c(int i, a0.f fVar, x.e eVar, boolean z2) {
        x.d dVar;
        x.d dVar2;
        boolean z10;
        x.d dVar3;
        x.d dVar4;
        if (eVar.f14142m) {
            return;
        }
        if (!(eVar instanceof x.f) && eVar.z() && a(eVar)) {
            x.f.V(eVar, fVar, new b());
        }
        x.d dVarI = eVar.i(2);
        x.d dVarI2 = eVar.i(4);
        int iD = dVarI.d();
        int iD2 = dVarI2.d();
        HashSet<x.d> hashSet = dVarI.f14114a;
        if (hashSet != null && dVarI.f14116c) {
            for (x.d dVar5 : hashSet) {
                x.e eVar2 = dVar5.f14117d;
                int i10 = i + 1;
                boolean zA = a(eVar2);
                x.d dVar6 = eVar2.I;
                x.d dVar7 = eVar2.K;
                if (eVar2.z() && zA) {
                    z10 = true;
                    x.f.V(eVar2, fVar, new b());
                } else {
                    z10 = true;
                }
                boolean z11 = ((dVar5 == dVar6 && (dVar4 = dVar7.f) != null && dVar4.f14116c) || (dVar5 == dVar7 && (dVar3 = dVar6.f) != null && dVar3.f14116c)) ? z10 : false;
                int i11 = eVar2.f14149p0[0];
                if (i11 != 3 || zA) {
                    if (!eVar2.z()) {
                        if (dVar5 == dVar6 && dVar7.f == null) {
                            int iE = dVar6.e() + iD;
                            eVar2.J(iE, eVar2.q() + iE);
                            c(i10, fVar, eVar2, z2);
                        } else if (dVar5 == dVar7 && dVar6.f == null) {
                            int iE2 = iD - dVar7.e();
                            eVar2.J(iE2 - eVar2.q(), iE2);
                            c(i10, fVar, eVar2, z2);
                        } else if (z11 && !eVar2.x()) {
                            d(i10, fVar, eVar2, z2);
                        }
                    }
                } else if (i11 == 3 && eVar2.f14155v >= 0 && eVar2.f14154u >= 0 && (eVar2.f14133g0 == 8 || (eVar2.f14151r == 0 && eVar2.W == 0.0f))) {
                    if (!eVar2.x() && !eVar2.F && z11 && !eVar2.x()) {
                        e(i10, eVar, fVar, eVar2, z2);
                    }
                }
            }
        }
        if (eVar instanceof x.i) {
            return;
        }
        HashSet<x.d> hashSet2 = dVarI2.f14114a;
        if (hashSet2 != null && dVarI2.f14116c) {
            for (x.d dVar8 : hashSet2) {
                x.e eVar3 = dVar8.f14117d;
                int i12 = i + 1;
                boolean zA2 = a(eVar3);
                x.d dVar9 = eVar3.I;
                x.d dVar10 = eVar3.K;
                if (eVar3.z() && zA2) {
                    x.f.V(eVar3, fVar, new b());
                }
                boolean z12 = (dVar8 == dVar9 && (dVar2 = dVar10.f) != null && dVar2.f14116c) || (dVar8 == dVar10 && (dVar = dVar9.f) != null && dVar.f14116c);
                int i13 = eVar3.f14149p0[0];
                if (i13 != 3 || zA2) {
                    if (!eVar3.z()) {
                        if (dVar8 == dVar9 && dVar10.f == null) {
                            int iE3 = dVar9.e() + iD2;
                            eVar3.J(iE3, eVar3.q() + iE3);
                            c(i12, fVar, eVar3, z2);
                        } else if (dVar8 == dVar10 && dVar9.f == null) {
                            int iE4 = iD2 - dVar10.e();
                            eVar3.J(iE4 - eVar3.q(), iE4);
                            c(i12, fVar, eVar3, z2);
                        } else if (z12 && !eVar3.x()) {
                            d(i12, fVar, eVar3, z2);
                        }
                    }
                } else if (i13 == 3 && eVar3.f14155v >= 0 && eVar3.f14154u >= 0) {
                    if (eVar3.f14133g0 == 8 || (eVar3.f14151r == 0 && eVar3.W == 0.0f)) {
                        if (!eVar3.x() && !eVar3.F && z12 && !eVar3.x()) {
                            e(i12, eVar, fVar, eVar3, z2);
                        }
                    }
                }
            }
        }
        eVar.f14142m = true;
    }

    public static void d(int i, a0.f fVar, x.e eVar, boolean z2) {
        float f = eVar.f14128d0;
        x.d dVar = eVar.I;
        int iD = dVar.f.d();
        x.d dVar2 = eVar.K;
        int iD2 = dVar2.f.d();
        int iE = dVar.e() + iD;
        int iE2 = iD2 - dVar2.e();
        if (iD == iD2) {
            f = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iQ = eVar.q();
        int i10 = (iD2 - iD) - iQ;
        if (iD > iD2) {
            i10 = (iD - iD2) - iQ;
        }
        int i11 = ((int) (i10 > 0 ? (f * i10) + 0.5f : f * i10)) + iD;
        int i12 = i11 + iQ;
        if (iD > iD2) {
            i12 = i11 - iQ;
        }
        eVar.J(i11, i12);
        c(i + 1, fVar, eVar, z2);
    }

    public static void e(int i, x.e eVar, a0.f fVar, x.e eVar2, boolean z2) {
        float f = eVar2.f14128d0;
        x.d dVar = eVar2.I;
        int iE = dVar.e() + dVar.f.d();
        x.d dVar2 = eVar2.K;
        int iD = dVar2.f.d() - dVar2.e();
        if (iD >= iE) {
            int iQ = eVar2.q();
            if (eVar2.f14133g0 != 8) {
                int i10 = eVar2.f14151r;
                if (i10 == 2) {
                    iQ = (int) (eVar2.f14128d0 * 0.5f * (eVar instanceof x.f ? eVar.q() : eVar.T.q()));
                } else if (i10 == 0) {
                    iQ = iD - iE;
                }
                iQ = Math.max(eVar2.f14154u, iQ);
                int i11 = eVar2.f14155v;
                if (i11 > 0) {
                    iQ = Math.min(i11, iQ);
                }
            }
            int i12 = iE + ((int) ((f * ((iD - iE) - iQ)) + 0.5f));
            eVar2.J(i12, iQ + i12);
            c(i + 1, fVar, eVar2, z2);
        }
    }

    public static void f(int i, a0.f fVar, x.e eVar) {
        float f = eVar.f14130e0;
        x.d dVar = eVar.J;
        int iD = dVar.f.d();
        x.d dVar2 = eVar.L;
        int iD2 = dVar2.f.d();
        int iE = dVar.e() + iD;
        int iE2 = iD2 - dVar2.e();
        if (iD == iD2) {
            f = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = eVar.k();
        int i10 = (iD2 - iD) - iK;
        if (iD > iD2) {
            i10 = (iD - iD2) - iK;
        }
        int i11 = (int) (i10 > 0 ? (f * i10) + 0.5f : f * i10);
        int i12 = iD + i11;
        int i13 = i12 + iK;
        if (iD > iD2) {
            i12 = iD - i11;
            i13 = i12 - iK;
        }
        eVar.K(i12, i13);
        i(i + 1, fVar, eVar);
    }

    public static void g(int i, x.e eVar, a0.f fVar, x.e eVar2) {
        float f = eVar2.f14130e0;
        x.d dVar = eVar2.J;
        int iE = dVar.e() + dVar.f.d();
        x.d dVar2 = eVar2.L;
        int iD = dVar2.f.d() - dVar2.e();
        if (iD >= iE) {
            int iK = eVar2.k();
            if (eVar2.f14133g0 != 8) {
                int i10 = eVar2.f14152s;
                if (i10 == 2) {
                    iK = (int) (f * 0.5f * (eVar instanceof x.f ? eVar.k() : eVar.T.k()));
                } else if (i10 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(eVar2.f14157x, iK);
                int i11 = eVar2.f14158y;
                if (i11 > 0) {
                    iK = Math.min(i11, iK);
                }
            }
            int i12 = iE + ((int) ((f * ((iD - iE) - iK)) + 0.5f));
            eVar2.K(i12, iK + i12);
            i(i + 1, fVar, eVar2);
        }
    }

    public static boolean h(int i, int i10, int i11, int i12) {
        return (i11 == 1 || i11 == 2 || (i11 == 4 && i != 2)) || (i12 == 1 || i12 == 2 || (i12 == 4 && i10 != 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(int i, a0.f fVar, x.e eVar) {
        x.d dVar;
        x.d dVar2;
        x.d dVar3;
        x.d dVar4;
        if (eVar.f14144n) {
            return;
        }
        if (!(eVar instanceof x.f) && eVar.z() && a(eVar)) {
            x.f.V(eVar, fVar, new b());
        }
        x.d dVarI = eVar.i(3);
        x.d dVarI2 = eVar.i(5);
        int iD = dVarI.d();
        int iD2 = dVarI2.d();
        HashSet<x.d> hashSet = dVarI.f14114a;
        if (hashSet != null && dVarI.f14116c) {
            for (x.d dVar5 : hashSet) {
                x.e eVar2 = dVar5.f14117d;
                int i10 = i + 1;
                boolean zA = a(eVar2);
                x.d dVar6 = eVar2.J;
                x.d dVar7 = eVar2.L;
                if (eVar2.z() && zA) {
                    x.f.V(eVar2, fVar, new b());
                }
                boolean z2 = (dVar5 == dVar6 && (dVar4 = dVar7.f) != null && dVar4.f14116c) || (dVar5 == dVar7 && (dVar3 = dVar6.f) != null && dVar3.f14116c);
                int i11 = eVar2.f14149p0[1];
                if (i11 != 3 || zA) {
                    if (!eVar2.z()) {
                        if (dVar5 == dVar6 && dVar7.f == null) {
                            int iE = dVar6.e() + iD;
                            eVar2.K(iE, eVar2.k() + iE);
                            i(i10, fVar, eVar2);
                        } else if (dVar5 == dVar7 && dVar6.f == null) {
                            int iE2 = iD - dVar7.e();
                            eVar2.K(iE2 - eVar2.k(), iE2);
                            i(i10, fVar, eVar2);
                        } else if (z2 && !eVar2.y()) {
                            f(i10, fVar, eVar2);
                        }
                    }
                } else if (i11 == 3 && eVar2.f14158y >= 0 && eVar2.f14157x >= 0 && (eVar2.f14133g0 == 8 || (eVar2.f14152s == 0 && eVar2.W == 0.0f))) {
                    if (!eVar2.y() && !eVar2.F && z2 && !eVar2.y()) {
                        g(i10, eVar, fVar, eVar2);
                    }
                }
            }
        }
        char c9 = 1;
        if (eVar instanceof x.i) {
            return;
        }
        HashSet<x.d> hashSet2 = dVarI2.f14114a;
        if (hashSet2 != null && dVarI2.f14116c) {
            for (x.d dVar8 : hashSet2) {
                x.e eVar3 = dVar8.f14117d;
                int i12 = i + 1;
                boolean zA2 = a(eVar3);
                x.d dVar9 = eVar3.J;
                x.d dVar10 = eVar3.L;
                if (eVar3.z() && zA2) {
                    x.f.V(eVar3, fVar, new b());
                }
                boolean z10 = (dVar8 == dVar9 && (dVar2 = dVar10.f) != null && dVar2.f14116c) || (dVar8 == dVar10 && (dVar = dVar9.f) != null && dVar.f14116c);
                int i13 = eVar3.f14149p0[1];
                if (i13 != 3 || zA2) {
                    if (!eVar3.z()) {
                        if (dVar8 == dVar9 && dVar10.f == null) {
                            int iE3 = dVar9.e() + iD2;
                            eVar3.K(iE3, eVar3.k() + iE3);
                            i(i12, fVar, eVar3);
                        } else if (dVar8 == dVar10 && dVar9.f == null) {
                            int iE4 = iD2 - dVar10.e();
                            eVar3.K(iE4 - eVar3.k(), iE4);
                            i(i12, fVar, eVar3);
                        } else if (z10 && !eVar3.y()) {
                            f(i12, fVar, eVar3);
                        }
                    }
                } else if (i13 == 3 && eVar3.f14158y >= 0 && eVar3.f14157x >= 0 && (eVar3.f14133g0 == 8 || (eVar3.f14152s == 0 && eVar3.W == 0.0f))) {
                    if (!eVar3.y() && !eVar3.F && z10 && !eVar3.y()) {
                        g(i12, eVar, fVar, eVar3);
                    }
                }
            }
        }
        x.d dVarI3 = eVar.i(6);
        if (dVarI3.f14114a != null && dVarI3.f14116c) {
            int iD3 = dVarI3.d();
            for (x.d dVar11 : dVarI3.f14114a) {
                x.e eVar4 = dVar11.f14117d;
                int i14 = i + 1;
                boolean zA3 = a(eVar4);
                x.d dVar12 = eVar4.M;
                if (eVar4.z() && zA3) {
                    x.f.V(eVar4, fVar, new b());
                }
                if (eVar4.f14149p0[c9] != 3 || zA3) {
                    if (eVar4.z()) {
                        continue;
                    } else if (dVar11 == dVar12) {
                        int iE5 = dVar11.e() + iD3;
                        if (eVar4.E) {
                            int i15 = iE5 - eVar4.f14122a0;
                            int i16 = eVar4.V + i15;
                            eVar4.Z = i15;
                            eVar4.J.l(i15);
                            eVar4.L.l(i16);
                            dVar12.l(iE5);
                            eVar4.f14141l = c9;
                        }
                        i(i14, fVar, eVar4);
                    }
                }
                c9 = 1;
            }
        }
        eVar.f14144n = true;
    }
}
