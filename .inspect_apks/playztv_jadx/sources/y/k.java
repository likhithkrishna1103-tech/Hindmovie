package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f14402k = new int[2];

    public static void m(int[] iArr, int i, int i10, int i11, int i12, float f, int i13) {
        int i14 = i10 - i;
        int i15 = i12 - i11;
        if (i13 != -1) {
            if (i13 == 0) {
                iArr[0] = (int) ((i15 * f) + 0.5f);
                iArr[1] = i15;
                return;
            } else {
                if (i13 != 1) {
                    return;
                }
                iArr[0] = i14;
                iArr[1] = (int) ((i14 * f) + 0.5f);
                return;
            }
        }
        int i16 = (int) ((i15 * f) + 0.5f);
        int i17 = (int) ((i14 / f) + 0.5f);
        if (i16 <= i14) {
            iArr[0] = i16;
            iArr[1] = i15;
        } else if (i17 <= i15) {
            iArr[0] = i14;
            iArr[1] = i17;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // y.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(y.d r24) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.k.a(y.d):void");
    }

    @Override // y.o
    public final void d() {
        x.e eVar;
        x.e eVar2;
        int i;
        x.e eVar3;
        x.e eVar4;
        int i10;
        x.e eVar5 = this.f14413b;
        boolean z2 = eVar5.f14121a;
        g gVar = this.f14416e;
        if (z2) {
            gVar.d(eVar5.q());
        }
        boolean z10 = gVar.f14397j;
        ArrayList arrayList = gVar.f14398k;
        ArrayList arrayList2 = gVar.f14399l;
        f fVar = this.i;
        f fVar2 = this.f14418h;
        if (!z10) {
            x.e eVar6 = this.f14413b;
            int i11 = eVar6.f14149p0[0];
            this.f14415d = i11;
            if (i11 != 3) {
                if (i11 == 4 && (eVar4 = eVar6.T) != null && ((i10 = eVar4.f14149p0[0]) == 1 || i10 == 4)) {
                    int iQ = (eVar4.q() - this.f14413b.I.e()) - this.f14413b.K.e();
                    o.b(fVar2, eVar4.f14127d.f14418h, this.f14413b.I.e());
                    o.b(fVar, eVar4.f14127d.i, -this.f14413b.K.e());
                    gVar.d(iQ);
                    return;
                }
                if (i11 == 1) {
                    gVar.d(eVar6.q());
                }
            }
        } else if (this.f14415d == 4 && (eVar2 = (eVar = this.f14413b).T) != null && ((i = eVar2.f14149p0[0]) == 1 || i == 4)) {
            o.b(fVar2, eVar2.f14127d.f14418h, eVar.I.e());
            o.b(fVar, eVar2.f14127d.i, -this.f14413b.K.e());
            return;
        }
        if (gVar.f14397j) {
            x.e eVar7 = this.f14413b;
            if (eVar7.f14121a) {
                x.d[] dVarArr = eVar7.Q;
                x.d dVar = dVarArr[0];
                x.d dVar2 = dVar.f;
                if (dVar2 != null && dVarArr[1].f != null) {
                    if (eVar7.x()) {
                        fVar2.f = this.f14413b.Q[0].e();
                        fVar.f = -this.f14413b.Q[1].e();
                        return;
                    }
                    f fVarH = o.h(this.f14413b.Q[0]);
                    if (fVarH != null) {
                        o.b(fVar2, fVarH, this.f14413b.Q[0].e());
                    }
                    f fVarH2 = o.h(this.f14413b.Q[1]);
                    if (fVarH2 != null) {
                        o.b(fVar, fVarH2, -this.f14413b.Q[1].e());
                    }
                    fVar2.f14391b = true;
                    fVar.f14391b = true;
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = o.h(dVar);
                    if (fVarH3 != null) {
                        o.b(fVar2, fVarH3, this.f14413b.Q[0].e());
                        o.b(fVar, fVar2, gVar.f14395g);
                        return;
                    }
                    return;
                }
                x.d dVar3 = dVarArr[1];
                if (dVar3.f != null) {
                    f fVarH4 = o.h(dVar3);
                    if (fVarH4 != null) {
                        o.b(fVar, fVarH4, -this.f14413b.Q[1].e());
                        o.b(fVar2, fVar, -gVar.f14395g);
                        return;
                    }
                    return;
                }
                if ((eVar7 instanceof x.j) || eVar7.T == null || eVar7.i(7).f != null) {
                    return;
                }
                x.e eVar8 = this.f14413b;
                o.b(fVar2, eVar8.T.f14127d.f14418h, eVar8.r());
                o.b(fVar, fVar2, gVar.f14395g);
                return;
            }
        }
        if (this.f14415d == 3) {
            x.e eVar9 = this.f14413b;
            int i12 = eVar9.f14151r;
            if (i12 == 2) {
                x.e eVar10 = eVar9.T;
                if (eVar10 != null) {
                    g gVar2 = eVar10.f14129e.f14416e;
                    arrayList2.add(gVar2);
                    gVar2.f14398k.add(gVar);
                    gVar.f14391b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                }
            } else if (i12 == 3) {
                if (eVar9.f14152s == 3) {
                    fVar2.f14390a = this;
                    fVar.f14390a = this;
                    m mVar = eVar9.f14129e;
                    mVar.f14418h.f14390a = this;
                    mVar.i.f14390a = this;
                    gVar.f14390a = this;
                    if (eVar9.y()) {
                        arrayList2.add(this.f14413b.f14129e.f14416e);
                        this.f14413b.f14129e.f14416e.f14398k.add(gVar);
                        m mVar2 = this.f14413b.f14129e;
                        mVar2.f14416e.f14390a = this;
                        arrayList2.add(mVar2.f14418h);
                        arrayList2.add(this.f14413b.f14129e.i);
                        this.f14413b.f14129e.f14418h.f14398k.add(gVar);
                        this.f14413b.f14129e.i.f14398k.add(gVar);
                    } else if (this.f14413b.x()) {
                        this.f14413b.f14129e.f14416e.f14399l.add(gVar);
                        arrayList.add(this.f14413b.f14129e.f14416e);
                    } else {
                        this.f14413b.f14129e.f14416e.f14399l.add(gVar);
                    }
                } else {
                    g gVar3 = eVar9.f14129e.f14416e;
                    arrayList2.add(gVar3);
                    gVar3.f14398k.add(gVar);
                    this.f14413b.f14129e.f14418h.f14398k.add(gVar);
                    this.f14413b.f14129e.i.f14398k.add(gVar);
                    gVar.f14391b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                    fVar2.f14399l.add(gVar);
                    fVar.f14399l.add(gVar);
                }
            }
        }
        x.e eVar11 = this.f14413b;
        x.d[] dVarArr2 = eVar11.Q;
        x.d dVar4 = dVarArr2[0];
        x.d dVar5 = dVar4.f;
        if (dVar5 != null && dVarArr2[1].f != null) {
            if (eVar11.x()) {
                fVar2.f = this.f14413b.Q[0].e();
                fVar.f = -this.f14413b.Q[1].e();
                return;
            }
            f fVarH5 = o.h(this.f14413b.Q[0]);
            f fVarH6 = o.h(this.f14413b.Q[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f14419j = 4;
            return;
        }
        if (dVar5 != null) {
            f fVarH7 = o.h(dVar4);
            if (fVarH7 != null) {
                o.b(fVar2, fVarH7, this.f14413b.Q[0].e());
                c(fVar, fVar2, 1, gVar);
                return;
            }
            return;
        }
        x.d dVar6 = dVarArr2[1];
        if (dVar6.f != null) {
            f fVarH8 = o.h(dVar6);
            if (fVarH8 != null) {
                o.b(fVar, fVarH8, -this.f14413b.Q[1].e());
                c(fVar2, fVar, -1, gVar);
                return;
            }
            return;
        }
        if ((eVar11 instanceof x.j) || (eVar3 = eVar11.T) == null) {
            return;
        }
        o.b(fVar2, eVar3.f14127d.f14418h, eVar11.r());
        c(fVar, fVar2, 1, gVar);
    }

    @Override // y.o
    public final void e() {
        f fVar = this.f14418h;
        if (fVar.f14397j) {
            this.f14413b.Y = fVar.f14395g;
        }
    }

    @Override // y.o
    public final void f() {
        this.f14414c = null;
        this.f14418h.c();
        this.i.c();
        this.f14416e.c();
        this.f14417g = false;
    }

    @Override // y.o
    public final boolean k() {
        return this.f14415d != 3 || this.f14413b.f14151r == 0;
    }

    public final void n() {
        this.f14417g = false;
        f fVar = this.f14418h;
        fVar.c();
        fVar.f14397j = false;
        f fVar2 = this.i;
        fVar2.c();
        fVar2.f14397j = false;
        this.f14416e.f14397j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f14413b.f14135h0;
    }
}
