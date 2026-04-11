package x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends j {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f14095s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f14096t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f14097u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f14098v0;

    @Override // x.e
    public final boolean A() {
        return this.f14098v0;
    }

    @Override // x.e
    public final boolean B() {
        return this.f14098v0;
    }

    public final boolean T() {
        int i;
        int i10;
        int i11;
        boolean z2 = true;
        int i12 = 0;
        while (true) {
            i = this.f14202r0;
            if (i12 >= i) {
                break;
            }
            e eVar = this.f14201q0[i12];
            if ((this.f14096t0 || eVar.c()) && ((((i10 = this.f14095s0) == 0 || i10 == 1) && !eVar.A()) || (((i11 = this.f14095s0) == 2 || i11 == 3) && !eVar.B()))) {
                z2 = false;
            }
            i12++;
        }
        if (!z2 || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z10 = false;
        for (int i13 = 0; i13 < this.f14202r0; i13++) {
            e eVar2 = this.f14201q0[i13];
            if (this.f14096t0 || eVar2.c()) {
                if (!z10) {
                    int i14 = this.f14095s0;
                    if (i14 == 0) {
                        iMax = eVar2.i(2).d();
                    } else if (i14 == 1) {
                        iMax = eVar2.i(4).d();
                    } else if (i14 == 2) {
                        iMax = eVar2.i(3).d();
                    } else if (i14 == 3) {
                        iMax = eVar2.i(5).d();
                    }
                    z10 = true;
                }
                int i15 = this.f14095s0;
                if (i15 == 0) {
                    iMax = Math.min(iMax, eVar2.i(2).d());
                } else if (i15 == 1) {
                    iMax = Math.max(iMax, eVar2.i(4).d());
                } else if (i15 == 2) {
                    iMax = Math.min(iMax, eVar2.i(3).d());
                } else if (i15 == 3) {
                    iMax = Math.max(iMax, eVar2.i(5).d());
                }
            }
        }
        int i16 = iMax + this.f14097u0;
        int i17 = this.f14095s0;
        if (i17 == 0 || i17 == 1) {
            J(i16, i16);
        } else {
            K(i16, i16);
        }
        this.f14098v0 = true;
        return true;
    }

    public final int U() {
        int i = this.f14095s0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // x.e
    public final void b(v.c cVar, boolean z2) {
        boolean z10;
        int i;
        int i10;
        d[] dVarArr = this.Q;
        d dVar = this.I;
        dVarArr[0] = dVar;
        int i11 = 2;
        d dVar2 = this.J;
        dVarArr[2] = dVar2;
        d dVar3 = this.K;
        dVarArr[1] = dVar3;
        d dVar4 = this.L;
        dVarArr[3] = dVar4;
        for (d dVar5 : dVarArr) {
            dVar5.i = cVar.k(dVar5);
        }
        int i12 = this.f14095s0;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        d dVar6 = dVarArr[i12];
        if (!this.f14098v0) {
            T();
        }
        if (this.f14098v0) {
            this.f14098v0 = false;
            int i13 = this.f14095s0;
            if (i13 == 0 || i13 == 1) {
                cVar.d(dVar.i, this.Y);
                cVar.d(dVar3.i, this.Y);
                return;
            } else {
                if (i13 == 2 || i13 == 3) {
                    cVar.d(dVar2.i, this.Z);
                    cVar.d(dVar4.i, this.Z);
                    return;
                }
                return;
            }
        }
        for (int i14 = 0; i14 < this.f14202r0; i14++) {
            e eVar = this.f14201q0[i14];
            if ((this.f14096t0 || eVar.c()) && ((((i10 = this.f14095s0) == 0 || i10 == 1) && eVar.f14149p0[0] == 3 && eVar.I.f != null && eVar.K.f != null) || ((i10 == 2 || i10 == 3) && eVar.f14149p0[1] == 3 && eVar.J.f != null && eVar.L.f != null))) {
                z10 = true;
                break;
            }
        }
        z10 = false;
        boolean z11 = dVar.g() || dVar3.g();
        boolean z12 = dVar2.g() || dVar4.g();
        int i15 = !(!z10 && (((i = this.f14095s0) == 0 && z11) || ((i == 2 && z12) || ((i == 1 && z11) || (i == 3 && z12))))) ? 4 : 5;
        int i16 = 0;
        while (i16 < this.f14202r0) {
            e eVar2 = this.f14201q0[i16];
            if (this.f14096t0 || eVar2.c()) {
                v.f fVarK = cVar.k(eVar2.Q[this.f14095s0]);
                d[] dVarArr2 = eVar2.Q;
                int i17 = this.f14095s0;
                d dVar7 = dVarArr2[i17];
                dVar7.i = fVarK;
                d dVar8 = dVar7.f;
                int i18 = (dVar8 == null || dVar8.f14117d != this) ? 0 : dVar7.f14119g;
                if (i17 == 0 || i17 == i11) {
                    v.f fVar = dVar6.i;
                    int i19 = this.f14097u0 - i18;
                    v.b bVarL = cVar.l();
                    v.f fVarM = cVar.m();
                    fVarM.f13108x = 0;
                    bVarL.c(fVar, fVarK, fVarM, i19);
                    cVar.c(bVarL);
                } else {
                    v.f fVar2 = dVar6.i;
                    int i20 = this.f14097u0 + i18;
                    v.b bVarL2 = cVar.l();
                    v.f fVarM2 = cVar.m();
                    fVarM2.f13108x = 0;
                    bVarL2.b(fVar2, fVarK, fVarM2, i20);
                    cVar.c(bVarL2);
                }
                cVar.e(dVar6.i, fVarK, this.f14097u0 + i18, i15);
            }
            i16++;
            i11 = 2;
        }
        int i21 = this.f14095s0;
        if (i21 == 0) {
            cVar.e(dVar3.i, dVar.i, 0, 8);
            cVar.e(dVar.i, this.T.K.i, 0, 4);
            cVar.e(dVar.i, this.T.I.i, 0, 0);
            return;
        }
        if (i21 == 1) {
            cVar.e(dVar.i, dVar3.i, 0, 8);
            cVar.e(dVar.i, this.T.I.i, 0, 4);
            cVar.e(dVar.i, this.T.K.i, 0, 0);
        } else if (i21 == 2) {
            cVar.e(dVar4.i, dVar2.i, 0, 8);
            cVar.e(dVar2.i, this.T.L.i, 0, 4);
            cVar.e(dVar2.i, this.T.J.i, 0, 0);
        } else if (i21 == 3) {
            cVar.e(dVar2.i, dVar4.i, 0, 8);
            cVar.e(dVar2.i, this.T.J.i, 0, 4);
            cVar.e(dVar2.i, this.T.L.i, 0, 0);
        }
    }

    @Override // x.e
    public final boolean c() {
        return true;
    }

    @Override // x.e
    public final String toString() {
        String strO = l4.a.o(new StringBuilder("[Barrier] "), this.f14135h0, " {");
        for (int i = 0; i < this.f14202r0; i++) {
            e eVar = this.f14201q0[i];
            if (i > 0) {
                strO = e6.j.m(strO, ", ");
            }
            StringBuilder sbB = v.e.b(strO);
            sbB.append(eVar.f14135h0);
            strO = sbB.toString();
        }
        return e6.j.m(strO, "}");
    }
}
