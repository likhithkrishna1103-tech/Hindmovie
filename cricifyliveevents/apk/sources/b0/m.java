package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f1617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f1618l;

    @Override // b0.d
    public final void a(d dVar) {
        float f;
        float f10;
        float f11;
        int i;
        if (y.e.c(this.f1631j) == 3) {
            a0.d dVar2 = this.f1625b;
            l(dVar2.J, dVar2.L, 1);
            return;
        }
        g gVar = this.f1628e;
        if (gVar.f1604c && !gVar.f1609j && this.f1627d == 3) {
            a0.d dVar3 = this.f1625b;
            int i10 = dVar3.f57s;
            if (i10 == 2) {
                a0.d dVar4 = dVar3.T;
                if (dVar4 != null) {
                    if (dVar4.f34e.f1628e.f1609j) {
                        gVar.d((int) ((r5.f1607g * dVar3.f64z) + 0.5f));
                    }
                }
            } else if (i10 == 3) {
                g gVar2 = dVar3.f32d.f1628e;
                if (gVar2.f1609j) {
                    int i11 = dVar3.X;
                    if (i11 == -1) {
                        f = gVar2.f1607g;
                        f10 = dVar3.W;
                    } else if (i11 == 0) {
                        f11 = gVar2.f1607g * dVar3.W;
                        i = (int) (f11 + 0.5f);
                        gVar.d(i);
                    } else if (i11 != 1) {
                        i = 0;
                        gVar.d(i);
                    } else {
                        f = gVar2.f1607g;
                        f10 = dVar3.W;
                    }
                    f11 = f / f10;
                    i = (int) (f11 + 0.5f);
                    gVar.d(i);
                }
            }
        }
        f fVar = this.f1630h;
        boolean z10 = fVar.f1604c;
        ArrayList arrayList = fVar.f1611l;
        if (z10) {
            f fVar2 = this.i;
            boolean z11 = fVar2.f1604c;
            ArrayList arrayList2 = fVar2.f1611l;
            if (z11) {
                if (fVar.f1609j && fVar2.f1609j && gVar.f1609j) {
                    return;
                }
                if (!gVar.f1609j && this.f1627d == 3) {
                    a0.d dVar5 = this.f1625b;
                    if (dVar5.f56r == 0 && !dVar5.y()) {
                        f fVar3 = (f) arrayList.get(0);
                        f fVar4 = (f) arrayList2.get(0);
                        int i12 = fVar3.f1607g + fVar.f;
                        int i13 = fVar4.f1607g + fVar2.f;
                        fVar.d(i12);
                        fVar2.d(i13);
                        gVar.d(i13 - i12);
                        return;
                    }
                }
                if (!gVar.f1609j && this.f1627d == 3 && this.f1624a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar5 = (f) arrayList.get(0);
                    int i14 = (((f) arrayList2.get(0)).f1607g + fVar2.f) - (fVar5.f1607g + fVar.f);
                    int i15 = gVar.f1612m;
                    if (i14 < i15) {
                        gVar.d(i14);
                    } else {
                        gVar.d(i15);
                    }
                }
                if (gVar.f1609j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar6 = (f) arrayList.get(0);
                    f fVar7 = (f) arrayList2.get(0);
                    int i16 = fVar6.f1607g;
                    int i17 = fVar.f + i16;
                    int i18 = fVar7.f1607g;
                    int i19 = fVar2.f + i18;
                    float f12 = this.f1625b.f35e0;
                    if (fVar6 == fVar7) {
                        f12 = 0.5f;
                    } else {
                        i16 = i17;
                        i18 = i19;
                    }
                    fVar.d((int) ((((i18 - i16) - gVar.f1607g) * f12) + i16 + 0.5f));
                    fVar2.d(fVar.f1607g + gVar.f1607g);
                }
            }
        }
    }

    @Override // b0.o
    public final void d() {
        a0.d dVar;
        a0.d dVar2;
        a0.d dVar3;
        a0.d dVar4;
        f fVar = this.f1617k;
        a0.d dVar5 = this.f1625b;
        boolean z10 = dVar5.f26a;
        g gVar = this.f1628e;
        if (z10) {
            gVar.d(dVar5.k());
        }
        boolean z11 = gVar.f1609j;
        ArrayList arrayList = gVar.f1610k;
        ArrayList arrayList2 = gVar.f1611l;
        f fVar2 = this.i;
        f fVar3 = this.f1630h;
        if (!z11) {
            a0.d dVar6 = this.f1625b;
            this.f1627d = dVar6.f54p0[1];
            if (dVar6.E) {
                this.f1618l = new a(this);
            }
            int i = this.f1627d;
            if (i != 3) {
                if (i == 4 && (dVar4 = this.f1625b.T) != null && dVar4.f54p0[1] == 1) {
                    int iK = (dVar4.k() - this.f1625b.J.e()) - this.f1625b.L.e();
                    o.b(fVar3, dVar4.f34e.f1630h, this.f1625b.J.e());
                    o.b(fVar2, dVar4.f34e.i, -this.f1625b.L.e());
                    gVar.d(iK);
                    return;
                }
                if (i == 1) {
                    gVar.d(this.f1625b.k());
                }
            }
        } else if (this.f1627d == 4 && (dVar2 = (dVar = this.f1625b).T) != null && dVar2.f54p0[1] == 1) {
            o.b(fVar3, dVar2.f34e.f1630h, dVar.J.e());
            o.b(fVar2, dVar2.f34e.i, -this.f1625b.L.e());
            return;
        }
        boolean z12 = gVar.f1609j;
        if (z12) {
            a0.d dVar7 = this.f1625b;
            if (dVar7.f26a) {
                a0.c[] cVarArr = dVar7.Q;
                a0.c cVar = cVarArr[2];
                a0.c cVar2 = cVar.f;
                if (cVar2 != null && cVarArr[3].f != null) {
                    if (dVar7.y()) {
                        fVar3.f = this.f1625b.Q[2].e();
                        fVar2.f = -this.f1625b.Q[3].e();
                    } else {
                        f fVarH = o.h(this.f1625b.Q[2]);
                        if (fVarH != null) {
                            o.b(fVar3, fVarH, this.f1625b.Q[2].e());
                        }
                        f fVarH2 = o.h(this.f1625b.Q[3]);
                        if (fVarH2 != null) {
                            o.b(fVar2, fVarH2, -this.f1625b.Q[3].e());
                        }
                        fVar3.f1603b = true;
                        fVar2.f1603b = true;
                    }
                    a0.d dVar8 = this.f1625b;
                    if (dVar8.E) {
                        o.b(fVar, fVar3, dVar8.f27a0);
                        return;
                    }
                    return;
                }
                if (cVar2 != null) {
                    f fVarH3 = o.h(cVar);
                    if (fVarH3 != null) {
                        o.b(fVar3, fVarH3, this.f1625b.Q[2].e());
                        o.b(fVar2, fVar3, gVar.f1607g);
                        a0.d dVar9 = this.f1625b;
                        if (dVar9.E) {
                            o.b(fVar, fVar3, dVar9.f27a0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                a0.c cVar3 = cVarArr[3];
                if (cVar3.f != null) {
                    f fVarH4 = o.h(cVar3);
                    if (fVarH4 != null) {
                        o.b(fVar2, fVarH4, -this.f1625b.Q[3].e());
                        o.b(fVar3, fVar2, -gVar.f1607g);
                    }
                    a0.d dVar10 = this.f1625b;
                    if (dVar10.E) {
                        o.b(fVar, fVar3, dVar10.f27a0);
                        return;
                    }
                    return;
                }
                a0.c cVar4 = cVarArr[4];
                if (cVar4.f != null) {
                    f fVarH5 = o.h(cVar4);
                    if (fVarH5 != null) {
                        o.b(fVar, fVarH5, 0);
                        o.b(fVar3, fVar, -this.f1625b.f27a0);
                        o.b(fVar2, fVar3, gVar.f1607g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof a0.i) || dVar7.T == null || dVar7.i(7).f != null) {
                    return;
                }
                a0.d dVar11 = this.f1625b;
                o.b(fVar3, dVar11.T.f34e.f1630h, dVar11.s());
                o.b(fVar2, fVar3, gVar.f1607g);
                a0.d dVar12 = this.f1625b;
                if (dVar12.E) {
                    o.b(fVar, fVar3, dVar12.f27a0);
                    return;
                }
                return;
            }
        }
        if (z12 || this.f1627d != 3) {
            gVar.b(this);
        } else {
            a0.d dVar13 = this.f1625b;
            int i10 = dVar13.f57s;
            if (i10 == 2) {
                a0.d dVar14 = dVar13.T;
                if (dVar14 != null) {
                    g gVar2 = dVar14.f34e.f1628e;
                    arrayList2.add(gVar2);
                    gVar2.f1610k.add(gVar);
                    gVar.f1603b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            } else if (i10 == 3 && !dVar13.y()) {
                a0.d dVar15 = this.f1625b;
                if (dVar15.f56r != 3) {
                    g gVar3 = dVar15.f32d.f1628e;
                    arrayList2.add(gVar3);
                    gVar3.f1610k.add(gVar);
                    gVar.f1603b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            }
        }
        a0.d dVar16 = this.f1625b;
        a0.c[] cVarArr2 = dVar16.Q;
        a0.c cVar5 = cVarArr2[2];
        a0.c cVar6 = cVar5.f;
        if (cVar6 != null && cVarArr2[3].f != null) {
            if (dVar16.y()) {
                fVar3.f = this.f1625b.Q[2].e();
                fVar2.f = -this.f1625b.Q[3].e();
            } else {
                f fVarH6 = o.h(this.f1625b.Q[2]);
                f fVarH7 = o.h(this.f1625b.Q[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f1631j = 4;
            }
            if (this.f1625b.E) {
                c(fVar, fVar3, 1, this.f1618l);
            }
        } else if (cVar6 != null) {
            f fVarH8 = o.h(cVar5);
            if (fVarH8 != null) {
                o.b(fVar3, fVarH8, this.f1625b.Q[2].e());
                c(fVar2, fVar3, 1, gVar);
                if (this.f1625b.E) {
                    c(fVar, fVar3, 1, this.f1618l);
                }
                if (this.f1627d == 3) {
                    a0.d dVar17 = this.f1625b;
                    if (dVar17.W > 0.0f) {
                        k kVar = dVar17.f32d;
                        if (kVar.f1627d == 3) {
                            kVar.f1628e.f1610k.add(gVar);
                            arrayList2.add(this.f1625b.f32d.f1628e);
                            gVar.f1602a = this;
                        }
                    }
                }
            }
        } else {
            a0.c cVar7 = cVarArr2[3];
            if (cVar7.f != null) {
                f fVarH9 = o.h(cVar7);
                if (fVarH9 != null) {
                    o.b(fVar2, fVarH9, -this.f1625b.Q[3].e());
                    c(fVar3, fVar2, -1, gVar);
                    if (this.f1625b.E) {
                        c(fVar, fVar3, 1, this.f1618l);
                    }
                }
            } else {
                a0.c cVar8 = cVarArr2[4];
                if (cVar8.f != null) {
                    f fVarH10 = o.h(cVar8);
                    if (fVarH10 != null) {
                        o.b(fVar, fVarH10, 0);
                        c(fVar3, fVar, -1, this.f1618l);
                        c(fVar2, fVar3, 1, gVar);
                    }
                } else if (!(dVar16 instanceof a0.i) && (dVar3 = dVar16.T) != null) {
                    o.b(fVar3, dVar3.f34e.f1630h, dVar16.s());
                    c(fVar2, fVar3, 1, gVar);
                    if (this.f1625b.E) {
                        c(fVar, fVar3, 1, this.f1618l);
                    }
                    if (this.f1627d == 3) {
                        a0.d dVar18 = this.f1625b;
                        if (dVar18.W > 0.0f) {
                            k kVar2 = dVar18.f32d;
                            if (kVar2.f1627d == 3) {
                                kVar2.f1628e.f1610k.add(gVar);
                                arrayList2.add(this.f1625b.f32d.f1628e);
                                gVar.f1602a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            gVar.f1604c = true;
        }
    }

    @Override // b0.o
    public final void e() {
        f fVar = this.f1630h;
        if (fVar.f1609j) {
            this.f1625b.Z = fVar.f1607g;
        }
    }

    @Override // b0.o
    public final void f() {
        this.f1626c = null;
        this.f1630h.c();
        this.i.c();
        this.f1617k.c();
        this.f1628e.c();
        this.f1629g = false;
    }

    @Override // b0.o
    public final boolean k() {
        return this.f1627d != 3 || this.f1625b.f57s == 0;
    }

    public final void m() {
        this.f1629g = false;
        f fVar = this.f1630h;
        fVar.c();
        fVar.f1609j = false;
        f fVar2 = this.i;
        fVar2.c();
        fVar2.f1609j = false;
        f fVar3 = this.f1617k;
        fVar3.c();
        fVar3.f1609j = false;
        this.f1628e.f1609j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f1625b.f40h0;
    }
}
