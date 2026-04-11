package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f1614k = new int[2];

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
    @Override // b0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(b0.d r24) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.k.a(b0.d):void");
    }

    @Override // b0.o
    public final void d() {
        a0.d dVar;
        a0.d dVar2;
        int i;
        a0.d dVar3;
        a0.d dVar4;
        int i10;
        a0.d dVar5 = this.f1625b;
        boolean z10 = dVar5.f26a;
        g gVar = this.f1628e;
        if (z10) {
            gVar.d(dVar5.q());
        }
        boolean z11 = gVar.f1609j;
        ArrayList arrayList = gVar.f1610k;
        ArrayList arrayList2 = gVar.f1611l;
        f fVar = this.i;
        f fVar2 = this.f1630h;
        if (!z11) {
            a0.d dVar6 = this.f1625b;
            int i11 = dVar6.f54p0[0];
            this.f1627d = i11;
            if (i11 != 3) {
                if (i11 == 4 && (dVar4 = dVar6.T) != null && ((i10 = dVar4.f54p0[0]) == 1 || i10 == 4)) {
                    int iQ = (dVar4.q() - this.f1625b.I.e()) - this.f1625b.K.e();
                    o.b(fVar2, dVar4.f32d.f1630h, this.f1625b.I.e());
                    o.b(fVar, dVar4.f32d.i, -this.f1625b.K.e());
                    gVar.d(iQ);
                    return;
                }
                if (i11 == 1) {
                    gVar.d(dVar6.q());
                }
            }
        } else if (this.f1627d == 4 && (dVar2 = (dVar = this.f1625b).T) != null && ((i = dVar2.f54p0[0]) == 1 || i == 4)) {
            o.b(fVar2, dVar2.f32d.f1630h, dVar.I.e());
            o.b(fVar, dVar2.f32d.i, -this.f1625b.K.e());
            return;
        }
        if (gVar.f1609j) {
            a0.d dVar7 = this.f1625b;
            if (dVar7.f26a) {
                a0.c[] cVarArr = dVar7.Q;
                a0.c cVar = cVarArr[0];
                a0.c cVar2 = cVar.f;
                if (cVar2 != null && cVarArr[1].f != null) {
                    if (dVar7.x()) {
                        fVar2.f = this.f1625b.Q[0].e();
                        fVar.f = -this.f1625b.Q[1].e();
                        return;
                    }
                    f fVarH = o.h(this.f1625b.Q[0]);
                    if (fVarH != null) {
                        o.b(fVar2, fVarH, this.f1625b.Q[0].e());
                    }
                    f fVarH2 = o.h(this.f1625b.Q[1]);
                    if (fVarH2 != null) {
                        o.b(fVar, fVarH2, -this.f1625b.Q[1].e());
                    }
                    fVar2.f1603b = true;
                    fVar.f1603b = true;
                    return;
                }
                if (cVar2 != null) {
                    f fVarH3 = o.h(cVar);
                    if (fVarH3 != null) {
                        o.b(fVar2, fVarH3, this.f1625b.Q[0].e());
                        o.b(fVar, fVar2, gVar.f1607g);
                        return;
                    }
                    return;
                }
                a0.c cVar3 = cVarArr[1];
                if (cVar3.f != null) {
                    f fVarH4 = o.h(cVar3);
                    if (fVarH4 != null) {
                        o.b(fVar, fVarH4, -this.f1625b.Q[1].e());
                        o.b(fVar2, fVar, -gVar.f1607g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof a0.i) || dVar7.T == null || dVar7.i(7).f != null) {
                    return;
                }
                a0.d dVar8 = this.f1625b;
                o.b(fVar2, dVar8.T.f32d.f1630h, dVar8.r());
                o.b(fVar, fVar2, gVar.f1607g);
                return;
            }
        }
        if (this.f1627d == 3) {
            a0.d dVar9 = this.f1625b;
            int i12 = dVar9.f56r;
            if (i12 == 2) {
                a0.d dVar10 = dVar9.T;
                if (dVar10 != null) {
                    g gVar2 = dVar10.f34e.f1628e;
                    arrayList2.add(gVar2);
                    gVar2.f1610k.add(gVar);
                    gVar.f1603b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                }
            } else if (i12 == 3) {
                if (dVar9.f57s == 3) {
                    fVar2.f1602a = this;
                    fVar.f1602a = this;
                    m mVar = dVar9.f34e;
                    mVar.f1630h.f1602a = this;
                    mVar.i.f1602a = this;
                    gVar.f1602a = this;
                    if (dVar9.y()) {
                        arrayList2.add(this.f1625b.f34e.f1628e);
                        this.f1625b.f34e.f1628e.f1610k.add(gVar);
                        m mVar2 = this.f1625b.f34e;
                        mVar2.f1628e.f1602a = this;
                        arrayList2.add(mVar2.f1630h);
                        arrayList2.add(this.f1625b.f34e.i);
                        this.f1625b.f34e.f1630h.f1610k.add(gVar);
                        this.f1625b.f34e.i.f1610k.add(gVar);
                    } else if (this.f1625b.x()) {
                        this.f1625b.f34e.f1628e.f1611l.add(gVar);
                        arrayList.add(this.f1625b.f34e.f1628e);
                    } else {
                        this.f1625b.f34e.f1628e.f1611l.add(gVar);
                    }
                } else {
                    g gVar3 = dVar9.f34e.f1628e;
                    arrayList2.add(gVar3);
                    gVar3.f1610k.add(gVar);
                    this.f1625b.f34e.f1630h.f1610k.add(gVar);
                    this.f1625b.f34e.i.f1610k.add(gVar);
                    gVar.f1603b = true;
                    arrayList.add(fVar2);
                    arrayList.add(fVar);
                    fVar2.f1611l.add(gVar);
                    fVar.f1611l.add(gVar);
                }
            }
        }
        a0.d dVar11 = this.f1625b;
        a0.c[] cVarArr2 = dVar11.Q;
        a0.c cVar4 = cVarArr2[0];
        a0.c cVar5 = cVar4.f;
        if (cVar5 != null && cVarArr2[1].f != null) {
            if (dVar11.x()) {
                fVar2.f = this.f1625b.Q[0].e();
                fVar.f = -this.f1625b.Q[1].e();
                return;
            }
            f fVarH5 = o.h(this.f1625b.Q[0]);
            f fVarH6 = o.h(this.f1625b.Q[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f1631j = 4;
            return;
        }
        if (cVar5 != null) {
            f fVarH7 = o.h(cVar4);
            if (fVarH7 != null) {
                o.b(fVar2, fVarH7, this.f1625b.Q[0].e());
                c(fVar, fVar2, 1, gVar);
                return;
            }
            return;
        }
        a0.c cVar6 = cVarArr2[1];
        if (cVar6.f != null) {
            f fVarH8 = o.h(cVar6);
            if (fVarH8 != null) {
                o.b(fVar, fVarH8, -this.f1625b.Q[1].e());
                c(fVar2, fVar, -1, gVar);
                return;
            }
            return;
        }
        if ((dVar11 instanceof a0.i) || (dVar3 = dVar11.T) == null) {
            return;
        }
        o.b(fVar2, dVar3.f32d.f1630h, dVar11.r());
        c(fVar, fVar2, 1, gVar);
    }

    @Override // b0.o
    public final void e() {
        f fVar = this.f1630h;
        if (fVar.f1609j) {
            this.f1625b.Y = fVar.f1607g;
        }
    }

    @Override // b0.o
    public final void f() {
        this.f1626c = null;
        this.f1630h.c();
        this.i.c();
        this.f1628e.c();
        this.f1629g = false;
    }

    @Override // b0.o
    public final boolean k() {
        return this.f1627d != 3 || this.f1625b.f56r == 0;
    }

    public final void n() {
        this.f1629g = false;
        f fVar = this.f1630h;
        fVar.c();
        fVar.f1609j = false;
        f fVar2 = this.i;
        fVar2.c();
        fVar2.f1609j = false;
        this.f1628e.f1609j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f1625b.f40h0;
    }
}
