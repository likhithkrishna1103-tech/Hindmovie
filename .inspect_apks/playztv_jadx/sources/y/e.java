package y;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x.f f14383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x.f f14386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f14387e;
    public a0.f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f14388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f14389h;

    public final void a(f fVar, int i, ArrayList arrayList, l lVar) {
        o oVar = fVar.f14393d;
        l lVar2 = oVar.f14414c;
        f fVar2 = oVar.i;
        f fVar3 = oVar.f14418h;
        if (lVar2 == null) {
            x.f fVar4 = this.f14383a;
            if (oVar == fVar4.f14127d || oVar == fVar4.f14129e) {
                return;
            }
            if (lVar == null) {
                lVar = new l();
                lVar.f14403a = null;
                lVar.f14404b = new ArrayList();
                lVar.f14403a = oVar;
                arrayList.add(lVar);
            }
            oVar.f14414c = lVar;
            lVar.f14404b.add(oVar);
            ArrayList arrayList2 = fVar3.f14398k;
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                d dVar = (d) obj;
                if (dVar instanceof f) {
                    a((f) dVar, i, arrayList, lVar);
                }
            }
            ArrayList arrayList3 = fVar2.f14398k;
            int size2 = arrayList3.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = arrayList3.get(i12);
                i12++;
                d dVar2 = (d) obj2;
                if (dVar2 instanceof f) {
                    a((f) dVar2, i, arrayList, lVar);
                }
            }
            if (i == 1 && (oVar instanceof m)) {
                ArrayList arrayList4 = ((m) oVar).f14405k.f14398k;
                int size3 = arrayList4.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj3 = arrayList4.get(i13);
                    i13++;
                    d dVar3 = (d) obj3;
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i, arrayList, lVar);
                    }
                }
            }
            ArrayList arrayList5 = fVar3.f14399l;
            int size4 = arrayList5.size();
            int i14 = 0;
            while (i14 < size4) {
                Object obj4 = arrayList5.get(i14);
                i14++;
                a((f) obj4, i, arrayList, lVar);
            }
            ArrayList arrayList6 = fVar2.f14399l;
            int size5 = arrayList6.size();
            int i15 = 0;
            while (i15 < size5) {
                Object obj5 = arrayList6.get(i15);
                i15++;
                a((f) obj5, i, arrayList, lVar);
            }
            if (i == 1 && (oVar instanceof m)) {
                ArrayList arrayList7 = ((m) oVar).f14405k.f14399l;
                int size6 = arrayList7.size();
                while (i10 < size6) {
                    Object obj6 = arrayList7.get(i10);
                    i10++;
                    a((f) obj6, i, arrayList, lVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c9, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(x.f r25) {
        /*
            Method dump skipped, instruction units count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.e.b(x.f):void");
    }

    public final void c() {
        x.f fVar = this.f14383a;
        ArrayList arrayList = this.f14389h;
        ArrayList arrayList2 = this.f14387e;
        arrayList2.clear();
        x.f fVar2 = this.f14386d;
        fVar2.f14127d.f();
        fVar2.f14129e.f();
        arrayList2.add(fVar2.f14127d);
        arrayList2.add(fVar2.f14129e);
        ArrayList arrayList3 = fVar2.f14160q0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            x.e eVar = (x.e) obj;
            if (eVar instanceof x.i) {
                i iVar = new i(eVar);
                eVar.f14127d.f();
                eVar.f14129e.f();
                iVar.f = ((x.i) eVar).f14199u0;
                arrayList2.add(iVar);
            } else {
                if (eVar.x()) {
                    if (eVar.f14123b == null) {
                        eVar.f14123b = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f14123b);
                } else {
                    arrayList2.add(eVar.f14127d);
                }
                if (eVar.y()) {
                    if (eVar.f14125c == null) {
                        eVar.f14125c = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f14125c);
                } else {
                    arrayList2.add(eVar.f14129e);
                }
                if (eVar instanceof x.j) {
                    arrayList2.add(new j(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList2.get(i10);
            i10++;
            ((o) obj2).f();
        }
        int size3 = arrayList2.size();
        int i11 = 0;
        while (i11 < size3) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            o oVar = (o) obj3;
            if (oVar.f14413b != fVar2) {
                oVar.d();
            }
        }
        arrayList.clear();
        e(fVar.f14127d, 0, arrayList);
        e(fVar.f14129e, 1, arrayList);
        this.f14384b = false;
    }

    public final int d(x.f fVar, int i) {
        ArrayList arrayList;
        int i10;
        long jMax;
        float f;
        x.f fVar2 = fVar;
        ArrayList arrayList2 = this.f14389h;
        int size = arrayList2.size();
        long j5 = 0;
        int i11 = 0;
        long jMax2 = 0;
        while (i11 < size) {
            o oVar = ((l) arrayList2.get(i11)).f14403a;
            if (!(oVar instanceof c) ? !(i != 0 ? (oVar instanceof m) : (oVar instanceof k)) : ((c) oVar).f != i) {
                f fVar3 = (i == 0 ? fVar2.f14127d : fVar2.f14129e).f14418h;
                f fVar4 = (i == 0 ? fVar2.f14127d : fVar2.f14129e).i;
                f fVar5 = oVar.f14418h;
                f fVar6 = oVar.i;
                boolean zContains = fVar5.f14399l.contains(fVar3);
                boolean zContains2 = fVar6.f14399l.contains(fVar4);
                long j8 = oVar.j();
                if (zContains && zContains2) {
                    long jB = l.b(fVar5, j5);
                    long jA = l.a(fVar6, j5);
                    long j10 = jB - j8;
                    int i12 = fVar6.f;
                    arrayList = arrayList2;
                    i10 = size;
                    if (j10 >= (-i12)) {
                        j10 += (long) i12;
                    }
                    long j11 = fVar5.f;
                    long j12 = ((-jA) - j8) - j11;
                    if (j12 >= j11) {
                        j12 -= j11;
                    }
                    x.e eVar = oVar.f14413b;
                    if (i == 0) {
                        f = eVar.f14128d0;
                    } else if (i == 1) {
                        f = eVar.f14130e0;
                    } else {
                        eVar.getClass();
                        f = -1.0f;
                    }
                    float f4 = f > 0.0f ? (long) ((j10 / (1.0f - f)) + (j12 / f)) : 0L;
                    jMax = (((long) fVar5.f) + ((((long) ((f4 * f) + 0.5f)) + j8) + ((long) e6.j.g(1.0f, f, f4, 0.5f)))) - ((long) fVar6.f);
                } else {
                    arrayList = arrayList2;
                    i10 = size;
                    jMax = zContains ? Math.max(l.b(fVar5, fVar5.f), ((long) fVar5.f) + j8) : zContains2 ? Math.max(-l.a(fVar6, fVar6.f), ((long) (-fVar6.f)) + j8) : (oVar.j() + ((long) fVar5.f)) - ((long) fVar6.f);
                }
            } else {
                arrayList = arrayList2;
                i10 = size;
                jMax = j5;
            }
            jMax2 = Math.max(jMax2, jMax);
            i11++;
            fVar2 = fVar;
            arrayList2 = arrayList;
            size = i10;
            j5 = 0;
        }
        return (int) jMax2;
    }

    public final void e(o oVar, int i, ArrayList arrayList) {
        f fVar = oVar.f14418h;
        f fVar2 = oVar.i;
        ArrayList arrayList2 = fVar.f14398k;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            d dVar = (d) obj;
            if (dVar instanceof f) {
                a((f) dVar, i, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).f14418h, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = fVar2.f14398k;
        int size2 = arrayList3.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList3.get(i12);
            i12++;
            d dVar2 = (d) obj2;
            if (dVar2 instanceof f) {
                a((f) dVar2, i, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((m) oVar).f14405k.f14398k;
            int size3 = arrayList4.size();
            while (i10 < size3) {
                Object obj3 = arrayList4.get(i10);
                i10++;
                d dVar3 = (d) obj3;
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, arrayList, null);
                }
            }
        }
    }

    public final void f(int i, int i10, int i11, int i12, x.e eVar) {
        b bVar = this.f14388g;
        bVar.f14373a = i;
        bVar.f14374b = i11;
        bVar.f14375c = i10;
        bVar.f14376d = i12;
        this.f.b(eVar, bVar);
        eVar.O(bVar.f14377e);
        eVar.L(bVar.f);
        eVar.E = bVar.f14379h;
        eVar.I(bVar.f14378g);
    }

    public final void g() {
        a aVar;
        e eVar = this;
        ArrayList arrayList = eVar.f14383a.f14160q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i10 = i + 1;
            x.e eVar2 = (x.e) arrayList.get(i);
            if (!eVar2.f14121a) {
                int[] iArr = eVar2.f14149p0;
                int i11 = iArr[0];
                int i12 = iArr[1];
                int i13 = eVar2.f14151r;
                int i14 = eVar2.f14152s;
                boolean z2 = i11 == 2 || (i11 == 3 && i13 == 1);
                boolean z10 = i12 == 2 || (i12 == 3 && i14 == 1);
                g gVar = eVar2.f14127d.f14416e;
                boolean z11 = gVar.f14397j;
                g gVar2 = eVar2.f14129e.f14416e;
                boolean z12 = gVar2.f14397j;
                boolean z13 = z2;
                if (z11 && z12) {
                    eVar.f(1, gVar.f14395g, 1, gVar2.f14395g, eVar2);
                    eVar2.f14121a = true;
                } else if (z11 && z10) {
                    f(1, gVar.f14395g, 2, gVar2.f14395g, eVar2);
                    if (i12 == 3) {
                        eVar2.f14129e.f14416e.f14400m = eVar2.k();
                    } else {
                        eVar2.f14129e.f14416e.d(eVar2.k());
                        eVar2.f14121a = true;
                    }
                } else if (z12 && z13) {
                    f(2, gVar.f14395g, 1, gVar2.f14395g, eVar2);
                    if (i11 == 3) {
                        eVar2.f14127d.f14416e.f14400m = eVar2.q();
                    } else {
                        eVar2.f14127d.f14416e.d(eVar2.q());
                        eVar2.f14121a = true;
                    }
                }
                if (eVar2.f14121a && (aVar = eVar2.f14129e.f14406l) != null) {
                    aVar.d(eVar2.f14122a0);
                }
                eVar = this;
            }
            i = i10;
        }
    }
}
