package b0;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1613a = new b();

    public static boolean a(a0.d dVar) {
        int[] iArr = dVar.f54p0;
        int i = iArr[0];
        int i10 = iArr[1];
        a0.d dVar2 = dVar.T;
        a0.e eVar = dVar2 != null ? (a0.e) dVar2 : null;
        if (eVar != null) {
            int i11 = eVar.f54p0[0];
        }
        if (eVar != null) {
            int i12 = eVar.f54p0[1];
        }
        boolean z10 = i == 1 || dVar.A() || i == 2 || (i == 3 && dVar.f56r == 0 && dVar.W == 0.0f && dVar.t(0)) || (i == 3 && dVar.f56r == 1 && dVar.u(0, dVar.q()));
        boolean z11 = i10 == 1 || dVar.B() || i10 == 2 || (i10 == 3 && dVar.f57s == 0 && dVar.W == 0.0f && dVar.t(1)) || (i10 == 3 && dVar.f57s == 1 && dVar.u(1, dVar.k()));
        return (dVar.W > 0.0f && (z10 || z11)) || (z10 && z11);
    }

    public static n b(a0.d dVar, int i, ArrayList arrayList, n nVar) {
        int i10;
        int i11 = i == 0 ? dVar.f51n0 : dVar.o0;
        if (i11 != -1 && (nVar == null || i11 != nVar.f1620b)) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                n nVar2 = (n) arrayList.get(i12);
                if (nVar2.f1620b == i11) {
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
            if (dVar instanceof a0.i) {
                a0.i iVar = (a0.i) dVar;
                int i13 = 0;
                while (true) {
                    if (i13 >= iVar.f108r0) {
                        i10 = -1;
                        break;
                    }
                    a0.d dVar2 = iVar.f107q0[i13];
                    if ((i == 0 && (i10 = dVar2.f51n0) != -1) || (i == 1 && (i10 = dVar2.o0) != -1)) {
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
                        if (nVar3.f1620b == i10) {
                            nVar = nVar3;
                            break;
                        }
                        i14++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n();
                nVar.f1619a = new ArrayList();
                nVar.f1622d = null;
                nVar.f1623e = -1;
                int i15 = n.f;
                n.f = i15 + 1;
                nVar.f1620b = i15;
                nVar.f1621c = i;
            }
            arrayList.add(nVar);
        }
        int i16 = nVar.f1620b;
        ArrayList arrayList2 = nVar.f1619a;
        if (arrayList2.contains(dVar)) {
            return nVar;
        }
        arrayList2.add(dVar);
        if (dVar instanceof a0.h) {
            a0.h hVar = (a0.h) dVar;
            hVar.f104t0.c(hVar.f105u0 == 0 ? 1 : 0, nVar, arrayList);
        }
        if (i == 0) {
            dVar.f51n0 = i16;
            dVar.I.c(i, nVar, arrayList);
            dVar.K.c(i, nVar, arrayList);
        } else {
            dVar.o0 = i16;
            dVar.J.c(i, nVar, arrayList);
            dVar.M.c(i, nVar, arrayList);
            dVar.L.c(i, nVar, arrayList);
        }
        dVar.P.c(i, nVar, arrayList);
        return nVar;
    }

    public static void c(int i, a0.d dVar, d0.f fVar, boolean z10) {
        a0.c cVar;
        a0.c cVar2;
        boolean z11;
        a0.c cVar3;
        a0.c cVar4;
        if (dVar.f48m) {
            return;
        }
        if (!(dVar instanceof a0.e) && dVar.z() && a(dVar)) {
            a0.e.V(dVar, fVar, new b());
        }
        a0.c cVarI = dVar.i(2);
        a0.c cVarI2 = dVar.i(4);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet<a0.c> hashSet = cVarI.f19a;
        if (hashSet != null && cVarI.f21c) {
            for (a0.c cVar5 : hashSet) {
                a0.d dVar2 = cVar5.f22d;
                int i10 = i + 1;
                boolean zA = a(dVar2);
                a0.c cVar6 = dVar2.I;
                a0.c cVar7 = dVar2.K;
                if (dVar2.z() && zA) {
                    z11 = true;
                    a0.e.V(dVar2, fVar, new b());
                } else {
                    z11 = true;
                }
                boolean z12 = ((cVar5 == cVar6 && (cVar4 = cVar7.f) != null && cVar4.f21c) || (cVar5 == cVar7 && (cVar3 = cVar6.f) != null && cVar3.f21c)) ? z11 : false;
                int i11 = dVar2.f54p0[0];
                if (i11 != 3 || zA) {
                    if (!dVar2.z()) {
                        if (cVar5 == cVar6 && cVar7.f == null) {
                            int iE = cVar6.e() + iD;
                            dVar2.J(iE, dVar2.q() + iE);
                            c(i10, dVar2, fVar, z10);
                        } else if (cVar5 == cVar7 && cVar6.f == null) {
                            int iE2 = iD - cVar7.e();
                            dVar2.J(iE2 - dVar2.q(), iE2);
                            c(i10, dVar2, fVar, z10);
                        } else if (z12 && !dVar2.x()) {
                            d(i10, dVar2, fVar, z10);
                        }
                    }
                } else if (i11 == 3 && dVar2.f60v >= 0 && dVar2.f59u >= 0 && (dVar2.f38g0 == 8 || (dVar2.f56r == 0 && dVar2.W == 0.0f))) {
                    if (!dVar2.x() && !dVar2.F && z12 && !dVar2.x()) {
                        e(i10, dVar, fVar, dVar2, z10);
                    }
                }
            }
        }
        if (dVar instanceof a0.h) {
            return;
        }
        HashSet<a0.c> hashSet2 = cVarI2.f19a;
        if (hashSet2 != null && cVarI2.f21c) {
            for (a0.c cVar8 : hashSet2) {
                a0.d dVar3 = cVar8.f22d;
                int i12 = i + 1;
                boolean zA2 = a(dVar3);
                a0.c cVar9 = dVar3.I;
                a0.c cVar10 = dVar3.K;
                if (dVar3.z() && zA2) {
                    a0.e.V(dVar3, fVar, new b());
                }
                boolean z13 = (cVar8 == cVar9 && (cVar2 = cVar10.f) != null && cVar2.f21c) || (cVar8 == cVar10 && (cVar = cVar9.f) != null && cVar.f21c);
                int i13 = dVar3.f54p0[0];
                if (i13 != 3 || zA2) {
                    if (!dVar3.z()) {
                        if (cVar8 == cVar9 && cVar10.f == null) {
                            int iE3 = cVar9.e() + iD2;
                            dVar3.J(iE3, dVar3.q() + iE3);
                            c(i12, dVar3, fVar, z10);
                        } else if (cVar8 == cVar10 && cVar9.f == null) {
                            int iE4 = iD2 - cVar10.e();
                            dVar3.J(iE4 - dVar3.q(), iE4);
                            c(i12, dVar3, fVar, z10);
                        } else if (z13 && !dVar3.x()) {
                            d(i12, dVar3, fVar, z10);
                        }
                    }
                } else if (i13 == 3 && dVar3.f60v >= 0 && dVar3.f59u >= 0) {
                    if (dVar3.f38g0 == 8 || (dVar3.f56r == 0 && dVar3.W == 0.0f)) {
                        if (!dVar3.x() && !dVar3.F && z13 && !dVar3.x()) {
                            e(i12, dVar, fVar, dVar3, z10);
                        }
                    }
                }
            }
        }
        dVar.f48m = true;
    }

    public static void d(int i, a0.d dVar, d0.f fVar, boolean z10) {
        float f = dVar.f33d0;
        a0.c cVar = dVar.I;
        int iD = cVar.f.d();
        a0.c cVar2 = dVar.K;
        int iD2 = cVar2.f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iQ = dVar.q();
        int i10 = (iD2 - iD) - iQ;
        if (iD > iD2) {
            i10 = (iD - iD2) - iQ;
        }
        int i11 = ((int) (i10 > 0 ? (f * i10) + 0.5f : f * i10)) + iD;
        int i12 = i11 + iQ;
        if (iD > iD2) {
            i12 = i11 - iQ;
        }
        dVar.J(i11, i12);
        c(i + 1, dVar, fVar, z10);
    }

    public static void e(int i, a0.d dVar, d0.f fVar, a0.d dVar2, boolean z10) {
        float f = dVar2.f33d0;
        a0.c cVar = dVar2.I;
        int iE = cVar.e() + cVar.f.d();
        a0.c cVar2 = dVar2.K;
        int iD = cVar2.f.d() - cVar2.e();
        if (iD >= iE) {
            int iQ = dVar2.q();
            if (dVar2.f38g0 != 8) {
                int i10 = dVar2.f56r;
                if (i10 == 2) {
                    iQ = (int) (dVar2.f33d0 * 0.5f * (dVar instanceof a0.e ? dVar.q() : dVar.T.q()));
                } else if (i10 == 0) {
                    iQ = iD - iE;
                }
                iQ = Math.max(dVar2.f59u, iQ);
                int i11 = dVar2.f60v;
                if (i11 > 0) {
                    iQ = Math.min(i11, iQ);
                }
            }
            int i12 = iE + ((int) ((f * ((iD - iE) - iQ)) + 0.5f));
            dVar2.J(i12, iQ + i12);
            c(i + 1, dVar2, fVar, z10);
        }
    }

    public static void f(int i, a0.d dVar, d0.f fVar) {
        float f = dVar.f35e0;
        a0.c cVar = dVar.J;
        int iD = cVar.f.d();
        a0.c cVar2 = dVar.L;
        int iD2 = cVar2.f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = dVar.k();
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
        dVar.K(i12, i13);
        i(i + 1, dVar, fVar);
    }

    public static void g(int i, a0.d dVar, d0.f fVar, a0.d dVar2) {
        float f = dVar2.f35e0;
        a0.c cVar = dVar2.J;
        int iE = cVar.e() + cVar.f.d();
        a0.c cVar2 = dVar2.L;
        int iD = cVar2.f.d() - cVar2.e();
        if (iD >= iE) {
            int iK = dVar2.k();
            if (dVar2.f38g0 != 8) {
                int i10 = dVar2.f57s;
                if (i10 == 2) {
                    iK = (int) (f * 0.5f * (dVar instanceof a0.e ? dVar.k() : dVar.T.k()));
                } else if (i10 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(dVar2.f62x, iK);
                int i11 = dVar2.f63y;
                if (i11 > 0) {
                    iK = Math.min(i11, iK);
                }
            }
            int i12 = iE + ((int) ((f * ((iD - iE) - iK)) + 0.5f));
            dVar2.K(i12, iK + i12);
            i(i + 1, dVar2, fVar);
        }
    }

    public static boolean h(int i, int i10, int i11, int i12) {
        return (i11 == 1 || i11 == 2 || (i11 == 4 && i != 2)) || (i12 == 1 || i12 == 2 || (i12 == 4 && i10 != 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(int i, a0.d dVar, d0.f fVar) {
        a0.c cVar;
        a0.c cVar2;
        a0.c cVar3;
        a0.c cVar4;
        if (dVar.f50n) {
            return;
        }
        if (!(dVar instanceof a0.e) && dVar.z() && a(dVar)) {
            a0.e.V(dVar, fVar, new b());
        }
        a0.c cVarI = dVar.i(3);
        a0.c cVarI2 = dVar.i(5);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet<a0.c> hashSet = cVarI.f19a;
        if (hashSet != null && cVarI.f21c) {
            for (a0.c cVar5 : hashSet) {
                a0.d dVar2 = cVar5.f22d;
                int i10 = i + 1;
                boolean zA = a(dVar2);
                a0.c cVar6 = dVar2.J;
                a0.c cVar7 = dVar2.L;
                if (dVar2.z() && zA) {
                    a0.e.V(dVar2, fVar, new b());
                }
                boolean z10 = (cVar5 == cVar6 && (cVar4 = cVar7.f) != null && cVar4.f21c) || (cVar5 == cVar7 && (cVar3 = cVar6.f) != null && cVar3.f21c);
                int i11 = dVar2.f54p0[1];
                if (i11 != 3 || zA) {
                    if (!dVar2.z()) {
                        if (cVar5 == cVar6 && cVar7.f == null) {
                            int iE = cVar6.e() + iD;
                            dVar2.K(iE, dVar2.k() + iE);
                            i(i10, dVar2, fVar);
                        } else if (cVar5 == cVar7 && cVar6.f == null) {
                            int iE2 = iD - cVar7.e();
                            dVar2.K(iE2 - dVar2.k(), iE2);
                            i(i10, dVar2, fVar);
                        } else if (z10 && !dVar2.y()) {
                            f(i10, dVar2, fVar);
                        }
                    }
                } else if (i11 == 3 && dVar2.f63y >= 0 && dVar2.f62x >= 0 && (dVar2.f38g0 == 8 || (dVar2.f57s == 0 && dVar2.W == 0.0f))) {
                    if (!dVar2.y() && !dVar2.F && z10 && !dVar2.y()) {
                        g(i10, dVar, fVar, dVar2);
                    }
                }
            }
        }
        char c9 = 1;
        if (dVar instanceof a0.h) {
            return;
        }
        HashSet<a0.c> hashSet2 = cVarI2.f19a;
        if (hashSet2 != null && cVarI2.f21c) {
            for (a0.c cVar8 : hashSet2) {
                a0.d dVar3 = cVar8.f22d;
                int i12 = i + 1;
                boolean zA2 = a(dVar3);
                a0.c cVar9 = dVar3.J;
                a0.c cVar10 = dVar3.L;
                if (dVar3.z() && zA2) {
                    a0.e.V(dVar3, fVar, new b());
                }
                boolean z11 = (cVar8 == cVar9 && (cVar2 = cVar10.f) != null && cVar2.f21c) || (cVar8 == cVar10 && (cVar = cVar9.f) != null && cVar.f21c);
                int i13 = dVar3.f54p0[1];
                if (i13 != 3 || zA2) {
                    if (!dVar3.z()) {
                        if (cVar8 == cVar9 && cVar10.f == null) {
                            int iE3 = cVar9.e() + iD2;
                            dVar3.K(iE3, dVar3.k() + iE3);
                            i(i12, dVar3, fVar);
                        } else if (cVar8 == cVar10 && cVar9.f == null) {
                            int iE4 = iD2 - cVar10.e();
                            dVar3.K(iE4 - dVar3.k(), iE4);
                            i(i12, dVar3, fVar);
                        } else if (z11 && !dVar3.y()) {
                            f(i12, dVar3, fVar);
                        }
                    }
                } else if (i13 == 3 && dVar3.f63y >= 0 && dVar3.f62x >= 0 && (dVar3.f38g0 == 8 || (dVar3.f57s == 0 && dVar3.W == 0.0f))) {
                    if (!dVar3.y() && !dVar3.F && z11 && !dVar3.y()) {
                        g(i12, dVar, fVar, dVar3);
                    }
                }
            }
        }
        a0.c cVarI3 = dVar.i(6);
        if (cVarI3.f19a != null && cVarI3.f21c) {
            int iD3 = cVarI3.d();
            for (a0.c cVar11 : cVarI3.f19a) {
                a0.d dVar4 = cVar11.f22d;
                int i14 = i + 1;
                boolean zA3 = a(dVar4);
                a0.c cVar12 = dVar4.M;
                if (dVar4.z() && zA3) {
                    a0.e.V(dVar4, fVar, new b());
                }
                if (dVar4.f54p0[c9] != 3 || zA3) {
                    if (dVar4.z()) {
                        continue;
                    } else if (cVar11 == cVar12) {
                        int iE5 = cVar11.e() + iD3;
                        if (dVar4.E) {
                            int i15 = iE5 - dVar4.f27a0;
                            int i16 = dVar4.V + i15;
                            dVar4.Z = i15;
                            dVar4.J.l(i15);
                            dVar4.L.l(i16);
                            cVar12.l(iE5);
                            dVar4.f46l = c9;
                        }
                        i(i14, dVar4, fVar);
                    }
                }
                c9 = 1;
            }
        }
        dVar.f50n = true;
    }
}
