package a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f0s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f1t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f2u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f3v0;

    @Override // a0.d
    public final boolean A() {
        return this.f3v0;
    }

    @Override // a0.d
    public final boolean B() {
        return this.f3v0;
    }

    public final boolean T() {
        int i;
        int i10;
        int i11;
        boolean z10 = true;
        int i12 = 0;
        while (true) {
            i = this.f108r0;
            if (i12 >= i) {
                break;
            }
            d dVar = this.f107q0[i12];
            if ((this.f1t0 || dVar.c()) && ((((i10 = this.f0s0) == 0 || i10 == 1) && !dVar.A()) || (((i11 = this.f0s0) == 2 || i11 == 3) && !dVar.B()))) {
                z10 = false;
            }
            i12++;
        }
        if (!z10 || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i13 = 0; i13 < this.f108r0; i13++) {
            d dVar2 = this.f107q0[i13];
            if (this.f1t0 || dVar2.c()) {
                if (!z11) {
                    int i14 = this.f0s0;
                    if (i14 == 0) {
                        iMax = dVar2.i(2).d();
                    } else if (i14 == 1) {
                        iMax = dVar2.i(4).d();
                    } else if (i14 == 2) {
                        iMax = dVar2.i(3).d();
                    } else if (i14 == 3) {
                        iMax = dVar2.i(5).d();
                    }
                    z11 = true;
                }
                int i15 = this.f0s0;
                if (i15 == 0) {
                    iMax = Math.min(iMax, dVar2.i(2).d());
                } else if (i15 == 1) {
                    iMax = Math.max(iMax, dVar2.i(4).d());
                } else if (i15 == 2) {
                    iMax = Math.min(iMax, dVar2.i(3).d());
                } else if (i15 == 3) {
                    iMax = Math.max(iMax, dVar2.i(5).d());
                }
            }
        }
        int i16 = iMax + this.f2u0;
        int i17 = this.f0s0;
        if (i17 == 0 || i17 == 1) {
            J(i16, i16);
        } else {
            K(i16, i16);
        }
        this.f3v0 = true;
        return true;
    }

    public final int U() {
        int i = this.f0s0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // a0.d
    public final void b(y.c cVar, boolean z10) {
        boolean z11;
        int i;
        int i10;
        c[] cVarArr = this.Q;
        c cVar2 = this.I;
        cVarArr[0] = cVar2;
        int i11 = 2;
        c cVar3 = this.J;
        cVarArr[2] = cVar3;
        c cVar4 = this.K;
        cVarArr[1] = cVar4;
        c cVar5 = this.L;
        cVarArr[3] = cVar5;
        for (c cVar6 : cVarArr) {
            cVar6.i = cVar.k(cVar6);
        }
        int i12 = this.f0s0;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        c cVar7 = cVarArr[i12];
        if (!this.f3v0) {
            T();
        }
        if (this.f3v0) {
            this.f3v0 = false;
            int i13 = this.f0s0;
            if (i13 == 0 || i13 == 1) {
                cVar.d(cVar2.i, this.Y);
                cVar.d(cVar4.i, this.Y);
                return;
            } else {
                if (i13 == 2 || i13 == 3) {
                    cVar.d(cVar3.i, this.Z);
                    cVar.d(cVar5.i, this.Z);
                    return;
                }
                return;
            }
        }
        for (int i14 = 0; i14 < this.f108r0; i14++) {
            d dVar = this.f107q0[i14];
            if ((this.f1t0 || dVar.c()) && ((((i10 = this.f0s0) == 0 || i10 == 1) && dVar.f54p0[0] == 3 && dVar.I.f != null && dVar.K.f != null) || ((i10 == 2 || i10 == 3) && dVar.f54p0[1] == 3 && dVar.J.f != null && dVar.L.f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = cVar2.g() || cVar4.g();
        boolean z13 = cVar3.g() || cVar5.g();
        int i15 = !(!z11 && (((i = this.f0s0) == 0 && z12) || ((i == 2 && z13) || ((i == 1 && z12) || (i == 3 && z13))))) ? 4 : 5;
        int i16 = 0;
        while (i16 < this.f108r0) {
            d dVar2 = this.f107q0[i16];
            if (this.f1t0 || dVar2.c()) {
                y.f fVarK = cVar.k(dVar2.Q[this.f0s0]);
                c[] cVarArr2 = dVar2.Q;
                int i17 = this.f0s0;
                c cVar8 = cVarArr2[i17];
                cVar8.i = fVarK;
                c cVar9 = cVar8.f;
                int i18 = (cVar9 == null || cVar9.f22d != this) ? 0 : cVar8.f24g;
                if (i17 == 0 || i17 == i11) {
                    y.f fVar = cVar7.i;
                    int i19 = this.f2u0 - i18;
                    y.b bVarL = cVar.l();
                    y.f fVarM = cVar.m();
                    fVarM.f14541y = 0;
                    bVarL.c(fVar, fVarK, fVarM, i19);
                    cVar.c(bVarL);
                } else {
                    y.f fVar2 = cVar7.i;
                    int i20 = this.f2u0 + i18;
                    y.b bVarL2 = cVar.l();
                    y.f fVarM2 = cVar.m();
                    fVarM2.f14541y = 0;
                    bVarL2.b(fVar2, fVarK, fVarM2, i20);
                    cVar.c(bVarL2);
                }
                cVar.e(cVar7.i, fVarK, this.f2u0 + i18, i15);
            }
            i16++;
            i11 = 2;
        }
        int i21 = this.f0s0;
        if (i21 == 0) {
            cVar.e(cVar4.i, cVar2.i, 0, 8);
            cVar.e(cVar2.i, this.T.K.i, 0, 4);
            cVar.e(cVar2.i, this.T.I.i, 0, 0);
            return;
        }
        if (i21 == 1) {
            cVar.e(cVar2.i, cVar4.i, 0, 8);
            cVar.e(cVar2.i, this.T.I.i, 0, 4);
            cVar.e(cVar2.i, this.T.K.i, 0, 0);
        } else if (i21 == 2) {
            cVar.e(cVar5.i, cVar3.i, 0, 8);
            cVar.e(cVar3.i, this.T.L.i, 0, 4);
            cVar.e(cVar3.i, this.T.J.i, 0, 0);
        } else if (i21 == 3) {
            cVar.e(cVar3.i, cVar5.i, 0, 8);
            cVar.e(cVar3.i, this.T.J.i, 0, 4);
            cVar.e(cVar3.i, this.T.L.i, 0, 0);
        }
    }

    @Override // a0.d
    public final boolean c() {
        return true;
    }

    @Override // a0.d
    public final String toString() {
        String strQ = q4.a.q(new StringBuilder("[Barrier] "), this.f40h0, " {");
        for (int i = 0; i < this.f108r0; i++) {
            d dVar = this.f107q0[i];
            if (i > 0) {
                strQ = l0.e.j(strQ, ", ");
            }
            StringBuilder sbB = y.e.b(strQ);
            sbB.append(dVar.f40h0);
            strQ = sbB.toString();
        }
        return l0.e.j(strQ, "}");
    }
}
