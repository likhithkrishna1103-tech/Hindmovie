package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f14405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f14406l;

    @Override // y.d
    public final void a(d dVar) {
        float f;
        float f4;
        float f10;
        int i;
        if (v.e.c(this.f14419j) == 3) {
            x.e eVar = this.f14413b;
            l(eVar.J, eVar.L, 1);
            return;
        }
        g gVar = this.f14416e;
        if (gVar.f14392c && !gVar.f14397j && this.f14415d == 3) {
            x.e eVar2 = this.f14413b;
            int i10 = eVar2.f14152s;
            if (i10 == 2) {
                x.e eVar3 = eVar2.T;
                if (eVar3 != null) {
                    if (eVar3.f14129e.f14416e.f14397j) {
                        gVar.d((int) ((r5.f14395g * eVar2.f14159z) + 0.5f));
                    }
                }
            } else if (i10 == 3) {
                g gVar2 = eVar2.f14127d.f14416e;
                if (gVar2.f14397j) {
                    int i11 = eVar2.X;
                    if (i11 == -1) {
                        f = gVar2.f14395g;
                        f4 = eVar2.W;
                    } else if (i11 == 0) {
                        f10 = gVar2.f14395g * eVar2.W;
                        i = (int) (f10 + 0.5f);
                        gVar.d(i);
                    } else if (i11 != 1) {
                        i = 0;
                        gVar.d(i);
                    } else {
                        f = gVar2.f14395g;
                        f4 = eVar2.W;
                    }
                    f10 = f / f4;
                    i = (int) (f10 + 0.5f);
                    gVar.d(i);
                }
            }
        }
        f fVar = this.f14418h;
        boolean z2 = fVar.f14392c;
        ArrayList arrayList = fVar.f14399l;
        if (z2) {
            f fVar2 = this.i;
            boolean z10 = fVar2.f14392c;
            ArrayList arrayList2 = fVar2.f14399l;
            if (z10) {
                if (fVar.f14397j && fVar2.f14397j && gVar.f14397j) {
                    return;
                }
                if (!gVar.f14397j && this.f14415d == 3) {
                    x.e eVar4 = this.f14413b;
                    if (eVar4.f14151r == 0 && !eVar4.y()) {
                        f fVar3 = (f) arrayList.get(0);
                        f fVar4 = (f) arrayList2.get(0);
                        int i12 = fVar3.f14395g + fVar.f;
                        int i13 = fVar4.f14395g + fVar2.f;
                        fVar.d(i12);
                        fVar2.d(i13);
                        gVar.d(i13 - i12);
                        return;
                    }
                }
                if (!gVar.f14397j && this.f14415d == 3 && this.f14412a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar5 = (f) arrayList.get(0);
                    int i14 = (((f) arrayList2.get(0)).f14395g + fVar2.f) - (fVar5.f14395g + fVar.f);
                    int i15 = gVar.f14400m;
                    if (i14 < i15) {
                        gVar.d(i14);
                    } else {
                        gVar.d(i15);
                    }
                }
                if (gVar.f14397j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    f fVar6 = (f) arrayList.get(0);
                    f fVar7 = (f) arrayList2.get(0);
                    int i16 = fVar6.f14395g;
                    int i17 = fVar.f + i16;
                    int i18 = fVar7.f14395g;
                    int i19 = fVar2.f + i18;
                    float f11 = this.f14413b.f14130e0;
                    if (fVar6 == fVar7) {
                        f11 = 0.5f;
                    } else {
                        i16 = i17;
                        i18 = i19;
                    }
                    fVar.d((int) ((((i18 - i16) - gVar.f14395g) * f11) + i16 + 0.5f));
                    fVar2.d(fVar.f14395g + gVar.f14395g);
                }
            }
        }
    }

    @Override // y.o
    public final void d() {
        x.e eVar;
        x.e eVar2;
        x.e eVar3;
        x.e eVar4;
        f fVar = this.f14405k;
        x.e eVar5 = this.f14413b;
        boolean z2 = eVar5.f14121a;
        g gVar = this.f14416e;
        if (z2) {
            gVar.d(eVar5.k());
        }
        boolean z10 = gVar.f14397j;
        ArrayList arrayList = gVar.f14398k;
        ArrayList arrayList2 = gVar.f14399l;
        f fVar2 = this.i;
        f fVar3 = this.f14418h;
        if (!z10) {
            x.e eVar6 = this.f14413b;
            this.f14415d = eVar6.f14149p0[1];
            if (eVar6.E) {
                this.f14406l = new a(this);
            }
            int i = this.f14415d;
            if (i != 3) {
                if (i == 4 && (eVar4 = this.f14413b.T) != null && eVar4.f14149p0[1] == 1) {
                    int iK = (eVar4.k() - this.f14413b.J.e()) - this.f14413b.L.e();
                    o.b(fVar3, eVar4.f14129e.f14418h, this.f14413b.J.e());
                    o.b(fVar2, eVar4.f14129e.i, -this.f14413b.L.e());
                    gVar.d(iK);
                    return;
                }
                if (i == 1) {
                    gVar.d(this.f14413b.k());
                }
            }
        } else if (this.f14415d == 4 && (eVar2 = (eVar = this.f14413b).T) != null && eVar2.f14149p0[1] == 1) {
            o.b(fVar3, eVar2.f14129e.f14418h, eVar.J.e());
            o.b(fVar2, eVar2.f14129e.i, -this.f14413b.L.e());
            return;
        }
        boolean z11 = gVar.f14397j;
        if (z11) {
            x.e eVar7 = this.f14413b;
            if (eVar7.f14121a) {
                x.d[] dVarArr = eVar7.Q;
                x.d dVar = dVarArr[2];
                x.d dVar2 = dVar.f;
                if (dVar2 != null && dVarArr[3].f != null) {
                    if (eVar7.y()) {
                        fVar3.f = this.f14413b.Q[2].e();
                        fVar2.f = -this.f14413b.Q[3].e();
                    } else {
                        f fVarH = o.h(this.f14413b.Q[2]);
                        if (fVarH != null) {
                            o.b(fVar3, fVarH, this.f14413b.Q[2].e());
                        }
                        f fVarH2 = o.h(this.f14413b.Q[3]);
                        if (fVarH2 != null) {
                            o.b(fVar2, fVarH2, -this.f14413b.Q[3].e());
                        }
                        fVar3.f14391b = true;
                        fVar2.f14391b = true;
                    }
                    x.e eVar8 = this.f14413b;
                    if (eVar8.E) {
                        o.b(fVar, fVar3, eVar8.f14122a0);
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = o.h(dVar);
                    if (fVarH3 != null) {
                        o.b(fVar3, fVarH3, this.f14413b.Q[2].e());
                        o.b(fVar2, fVar3, gVar.f14395g);
                        x.e eVar9 = this.f14413b;
                        if (eVar9.E) {
                            o.b(fVar, fVar3, eVar9.f14122a0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.d dVar3 = dVarArr[3];
                if (dVar3.f != null) {
                    f fVarH4 = o.h(dVar3);
                    if (fVarH4 != null) {
                        o.b(fVar2, fVarH4, -this.f14413b.Q[3].e());
                        o.b(fVar3, fVar2, -gVar.f14395g);
                    }
                    x.e eVar10 = this.f14413b;
                    if (eVar10.E) {
                        o.b(fVar, fVar3, eVar10.f14122a0);
                        return;
                    }
                    return;
                }
                x.d dVar4 = dVarArr[4];
                if (dVar4.f != null) {
                    f fVarH5 = o.h(dVar4);
                    if (fVarH5 != null) {
                        o.b(fVar, fVarH5, 0);
                        o.b(fVar3, fVar, -this.f14413b.f14122a0);
                        o.b(fVar2, fVar3, gVar.f14395g);
                        return;
                    }
                    return;
                }
                if ((eVar7 instanceof x.j) || eVar7.T == null || eVar7.i(7).f != null) {
                    return;
                }
                x.e eVar11 = this.f14413b;
                o.b(fVar3, eVar11.T.f14129e.f14418h, eVar11.s());
                o.b(fVar2, fVar3, gVar.f14395g);
                x.e eVar12 = this.f14413b;
                if (eVar12.E) {
                    o.b(fVar, fVar3, eVar12.f14122a0);
                    return;
                }
                return;
            }
        }
        if (z11 || this.f14415d != 3) {
            gVar.b(this);
        } else {
            x.e eVar13 = this.f14413b;
            int i10 = eVar13.f14152s;
            if (i10 == 2) {
                x.e eVar14 = eVar13.T;
                if (eVar14 != null) {
                    g gVar2 = eVar14.f14129e.f14416e;
                    arrayList2.add(gVar2);
                    gVar2.f14398k.add(gVar);
                    gVar.f14391b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            } else if (i10 == 3 && !eVar13.y()) {
                x.e eVar15 = this.f14413b;
                if (eVar15.f14151r != 3) {
                    g gVar3 = eVar15.f14127d.f14416e;
                    arrayList2.add(gVar3);
                    gVar3.f14398k.add(gVar);
                    gVar.f14391b = true;
                    arrayList.add(fVar3);
                    arrayList.add(fVar2);
                }
            }
        }
        x.e eVar16 = this.f14413b;
        x.d[] dVarArr2 = eVar16.Q;
        x.d dVar5 = dVarArr2[2];
        x.d dVar6 = dVar5.f;
        if (dVar6 != null && dVarArr2[3].f != null) {
            if (eVar16.y()) {
                fVar3.f = this.f14413b.Q[2].e();
                fVar2.f = -this.f14413b.Q[3].e();
            } else {
                f fVarH6 = o.h(this.f14413b.Q[2]);
                f fVarH7 = o.h(this.f14413b.Q[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f14419j = 4;
            }
            if (this.f14413b.E) {
                c(fVar, fVar3, 1, this.f14406l);
            }
        } else if (dVar6 != null) {
            f fVarH8 = o.h(dVar5);
            if (fVarH8 != null) {
                o.b(fVar3, fVarH8, this.f14413b.Q[2].e());
                c(fVar2, fVar3, 1, gVar);
                if (this.f14413b.E) {
                    c(fVar, fVar3, 1, this.f14406l);
                }
                if (this.f14415d == 3) {
                    x.e eVar17 = this.f14413b;
                    if (eVar17.W > 0.0f) {
                        k kVar = eVar17.f14127d;
                        if (kVar.f14415d == 3) {
                            kVar.f14416e.f14398k.add(gVar);
                            arrayList2.add(this.f14413b.f14127d.f14416e);
                            gVar.f14390a = this;
                        }
                    }
                }
            }
        } else {
            x.d dVar7 = dVarArr2[3];
            if (dVar7.f != null) {
                f fVarH9 = o.h(dVar7);
                if (fVarH9 != null) {
                    o.b(fVar2, fVarH9, -this.f14413b.Q[3].e());
                    c(fVar3, fVar2, -1, gVar);
                    if (this.f14413b.E) {
                        c(fVar, fVar3, 1, this.f14406l);
                    }
                }
            } else {
                x.d dVar8 = dVarArr2[4];
                if (dVar8.f != null) {
                    f fVarH10 = o.h(dVar8);
                    if (fVarH10 != null) {
                        o.b(fVar, fVarH10, 0);
                        c(fVar3, fVar, -1, this.f14406l);
                        c(fVar2, fVar3, 1, gVar);
                    }
                } else if (!(eVar16 instanceof x.j) && (eVar3 = eVar16.T) != null) {
                    o.b(fVar3, eVar3.f14129e.f14418h, eVar16.s());
                    c(fVar2, fVar3, 1, gVar);
                    if (this.f14413b.E) {
                        c(fVar, fVar3, 1, this.f14406l);
                    }
                    if (this.f14415d == 3) {
                        x.e eVar18 = this.f14413b;
                        if (eVar18.W > 0.0f) {
                            k kVar2 = eVar18.f14127d;
                            if (kVar2.f14415d == 3) {
                                kVar2.f14416e.f14398k.add(gVar);
                                arrayList2.add(this.f14413b.f14127d.f14416e);
                                gVar.f14390a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            gVar.f14392c = true;
        }
    }

    @Override // y.o
    public final void e() {
        f fVar = this.f14418h;
        if (fVar.f14397j) {
            this.f14413b.Z = fVar.f14395g;
        }
    }

    @Override // y.o
    public final void f() {
        this.f14414c = null;
        this.f14418h.c();
        this.i.c();
        this.f14405k.c();
        this.f14416e.c();
        this.f14417g = false;
    }

    @Override // y.o
    public final boolean k() {
        return this.f14415d != 3 || this.f14413b.f14152s == 0;
    }

    public final void m() {
        this.f14417g = false;
        f fVar = this.f14418h;
        fVar.c();
        fVar.f14397j = false;
        f fVar2 = this.i;
        fVar2.c();
        fVar2.f14397j = false;
        f fVar3 = this.f14405k;
        fVar3.c();
        fVar3.f14397j = false;
        this.f14416e.f14397j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f14413b.f14135h0;
    }
}
