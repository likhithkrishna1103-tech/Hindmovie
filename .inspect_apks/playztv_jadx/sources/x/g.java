package x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14170a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f14173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f14174e;
    public d f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f14175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14176h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14178k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14184q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ h f14185r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f14171b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14172c = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14179l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14180m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14181n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14182o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14183p = 0;

    public g(h hVar, int i, d dVar, d dVar2, d dVar3, d dVar4, int i10) {
        this.f14185r = hVar;
        this.f14170a = i;
        this.f14173d = dVar;
        this.f14174e = dVar2;
        this.f = dVar3;
        this.f14175g = dVar4;
        this.f14176h = hVar.f14191w0;
        this.i = hVar.f14187s0;
        this.f14177j = hVar.f14192x0;
        this.f14178k = hVar.f14188t0;
        this.f14184q = i10;
    }

    public final void a(e eVar) {
        int i = this.f14170a;
        h hVar = this.f14185r;
        if (i == 0) {
            int iU = hVar.U(eVar, this.f14184q);
            if (eVar.f14149p0[0] == 3) {
                this.f14183p++;
                iU = 0;
            }
            this.f14179l = iU + (eVar.f14133g0 != 8 ? hVar.P0 : 0) + this.f14179l;
            int iT = hVar.T(eVar, this.f14184q);
            if (this.f14171b == null || this.f14172c < iT) {
                this.f14171b = eVar;
                this.f14172c = iT;
                this.f14180m = iT;
            }
        } else {
            int iU2 = hVar.U(eVar, this.f14184q);
            int iT2 = hVar.T(eVar, this.f14184q);
            if (eVar.f14149p0[1] == 3) {
                this.f14183p++;
                iT2 = 0;
            }
            this.f14180m = iT2 + (eVar.f14133g0 != 8 ? hVar.Q0 : 0) + this.f14180m;
            if (this.f14171b == null || this.f14172c < iU2) {
                this.f14171b = eVar;
                this.f14172c = iU2;
                this.f14179l = iU2;
            }
        }
        this.f14182o++;
    }

    public final void b(int i, boolean z2, boolean z10) {
        h hVar;
        int i10;
        int i11;
        e eVar;
        boolean z11;
        int i12;
        int i13;
        char c9;
        float f;
        float f4;
        float f10;
        int i14;
        float f11;
        float f12;
        int i15;
        int i16 = this.f14182o;
        int i17 = 0;
        while (true) {
            hVar = this.f14185r;
            if (i17 >= i16 || (i15 = this.f14181n + i17) >= hVar.f14186b1) {
                break;
            }
            e eVar2 = hVar.a1[i15];
            if (eVar2 != null) {
                eVar2.D();
            }
            i17++;
        }
        if (i16 == 0 || this.f14171b == null) {
            return;
        }
        boolean z12 = z10 && i == 0;
        int i18 = -1;
        int i19 = -1;
        for (int i20 = 0; i20 < i16; i20++) {
            int i21 = this.f14181n + (z2 ? (i16 - 1) - i20 : i20);
            if (i21 >= hVar.f14186b1) {
                break;
            }
            e eVar3 = hVar.a1[i21];
            if (eVar3 != null && eVar3.f14133g0 == 0) {
                if (i18 == -1) {
                    i18 = i20;
                }
                i19 = i20;
            }
        }
        if (this.f14170a == 0) {
            e eVar4 = this.f14171b;
            eVar4.f14138j0 = hVar.E0;
            d dVar = eVar4.L;
            d dVar2 = eVar4.J;
            int i22 = this.i;
            if (i > 0) {
                i22 += hVar.Q0;
            }
            dVar2.a(this.f14174e, i22);
            if (z10) {
                dVar.a(this.f14175g, this.f14178k);
            }
            if (i > 0) {
                this.f14174e.f14117d.L.a(dVar2, 0);
            }
            if (hVar.S0 != 3 || eVar4.E) {
                eVar = eVar4;
            } else {
                for (int i23 = 0; i23 < i16; i23++) {
                    int i24 = this.f14181n + (z2 ? (i16 - 1) - i23 : i23);
                    if (i24 >= hVar.f14186b1) {
                        break;
                    }
                    eVar = hVar.a1[i24];
                    if (eVar.E) {
                        break;
                    }
                }
                eVar = eVar4;
            }
            int i25 = 0;
            e eVar5 = null;
            while (i25 < i16) {
                int i26 = z2 ? (i16 - 1) - i25 : i25;
                int i27 = this.f14181n + i26;
                if (i27 >= hVar.f14186b1) {
                    return;
                }
                e eVar6 = hVar.a1[i27];
                if (eVar6 == null) {
                    i13 = i16;
                    z11 = z12;
                    i12 = i19;
                    c9 = 3;
                } else {
                    d dVar3 = eVar6.L;
                    d dVar4 = eVar6.J;
                    d dVar5 = eVar6.I;
                    z11 = z12;
                    if (i25 == 0) {
                        i12 = i19;
                        eVar6.f(dVar5, this.f14173d, this.f14176h);
                    } else {
                        i12 = i19;
                    }
                    if (i26 == 0) {
                        int i28 = hVar.D0;
                        if (z2) {
                            f = 1.0f;
                            f4 = 1.0f - hVar.J0;
                        } else {
                            f = 1.0f;
                            f4 = hVar.J0;
                        }
                        if (this.f14181n == 0) {
                            i14 = hVar.F0;
                            f10 = f4;
                            if (i14 != -1) {
                                if (z2) {
                                    f12 = hVar.L0;
                                    f11 = f - f12;
                                    eVar6.f14136i0 = i14;
                                    eVar6.f14128d0 = f11;
                                } else {
                                    f11 = hVar.L0;
                                    eVar6.f14136i0 = i14;
                                    eVar6.f14128d0 = f11;
                                }
                            }
                        } else {
                            f10 = f4;
                        }
                        if (!z10 || (i14 = hVar.H0) == -1) {
                            i14 = i28;
                            f11 = f10;
                        } else if (z2) {
                            f12 = hVar.N0;
                            f11 = f - f12;
                        } else {
                            f11 = hVar.N0;
                        }
                        eVar6.f14136i0 = i14;
                        eVar6.f14128d0 = f11;
                    }
                    if (i25 == i16 - 1) {
                        i13 = i16;
                        eVar6.f(eVar6.K, this.f, this.f14177j);
                    } else {
                        i13 = i16;
                    }
                    if (eVar5 != null) {
                        d dVar6 = eVar5.K;
                        dVar5.a(dVar6, hVar.P0);
                        if (i25 == i18) {
                            int i29 = this.f14176h;
                            if (dVar5.h()) {
                                dVar5.f14120h = i29;
                            }
                        }
                        dVar6.a(dVar5, 0);
                        if (i25 == i12 + 1) {
                            int i30 = this.f14177j;
                            if (dVar6.h()) {
                                dVar6.f14120h = i30;
                            }
                        }
                    }
                    if (eVar6 != eVar4) {
                        int i31 = hVar.S0;
                        c9 = 3;
                        if (i31 == 3 && eVar.E && eVar6 != eVar && eVar6.E) {
                            eVar6.M.a(eVar.M, 0);
                        } else if (i31 == 0) {
                            dVar4.a(dVar2, 0);
                        } else if (i31 == 1) {
                            dVar3.a(dVar, 0);
                        } else if (z11) {
                            dVar4.a(this.f14174e, this.i);
                            dVar3.a(this.f14175g, this.f14178k);
                        } else {
                            dVar4.a(dVar2, 0);
                            dVar3.a(dVar, 0);
                        }
                    } else {
                        c9 = 3;
                    }
                    eVar5 = eVar6;
                }
                i25++;
                z12 = z11;
                i19 = i12;
                i16 = i13;
            }
            return;
        }
        int i32 = i16;
        boolean z13 = z12;
        int i33 = i19;
        e eVar7 = this.f14171b;
        eVar7.f14136i0 = hVar.D0;
        d dVar7 = eVar7.I;
        d dVar8 = eVar7.K;
        int i34 = this.f14176h;
        if (i > 0) {
            i34 += hVar.P0;
        }
        if (z2) {
            dVar8.a(this.f, i34);
            if (z10) {
                dVar7.a(this.f14173d, this.f14177j);
            }
            if (i > 0) {
                this.f.f14117d.I.a(dVar8, 0);
            }
        } else {
            dVar7.a(this.f14173d, i34);
            if (z10) {
                dVar8.a(this.f, this.f14177j);
            }
            if (i > 0) {
                this.f14173d.f14117d.K.a(dVar7, 0);
            }
        }
        int i35 = 0;
        e eVar8 = null;
        while (true) {
            int i36 = i32;
            if (i35 >= i36 || (i10 = this.f14181n + i35) >= hVar.f14186b1) {
                return;
            }
            e eVar9 = hVar.a1[i10];
            if (eVar9 == null) {
                i32 = i36;
            } else {
                d dVar9 = eVar9.J;
                d dVar10 = eVar9.K;
                d dVar11 = eVar9.I;
                if (i35 == 0) {
                    eVar9.f(dVar9, this.f14174e, this.i);
                    int i37 = hVar.E0;
                    float f13 = hVar.K0;
                    if (this.f14181n == 0) {
                        int i38 = hVar.G0;
                        i32 = i36;
                        i11 = -1;
                        if (i38 != -1) {
                            f13 = hVar.M0;
                        }
                        i37 = i38;
                        eVar9.f14138j0 = i37;
                        eVar9.f14130e0 = f13;
                    } else {
                        i32 = i36;
                        i11 = -1;
                    }
                    if (z10 && (i38 = hVar.I0) != i11) {
                        f13 = hVar.O0;
                        i37 = i38;
                    }
                    eVar9.f14138j0 = i37;
                    eVar9.f14130e0 = f13;
                } else {
                    i32 = i36;
                }
                if (i35 == i32 - 1) {
                    eVar9.f(eVar9.L, this.f14175g, this.f14178k);
                }
                if (eVar8 != null) {
                    d dVar12 = eVar8.L;
                    dVar9.a(dVar12, hVar.Q0);
                    if (i35 == i18) {
                        int i39 = this.i;
                        if (dVar9.h()) {
                            dVar9.f14120h = i39;
                        }
                    }
                    dVar12.a(dVar9, 0);
                    if (i35 == i33 + 1) {
                        int i40 = this.f14178k;
                        if (dVar12.h()) {
                            dVar12.f14120h = i40;
                        }
                    }
                }
                if (eVar9 == eVar7) {
                    eVar8 = eVar9;
                } else if (z2) {
                    int i41 = hVar.R0;
                    if (i41 == 0) {
                        dVar10.a(dVar8, 0);
                    } else if (i41 == 1) {
                        dVar11.a(dVar7, 0);
                    } else if (i41 == 2) {
                        dVar11.a(dVar7, 0);
                        dVar10.a(dVar8, 0);
                    }
                    eVar8 = eVar9;
                } else {
                    int i42 = hVar.R0;
                    if (i42 == 0) {
                        dVar11.a(dVar7, 0);
                    } else if (i42 == 1) {
                        dVar10.a(dVar8, 0);
                    } else if (i42 == 2) {
                        if (z13) {
                            dVar11.a(this.f14173d, this.f14176h);
                            dVar10.a(this.f, this.f14177j);
                        } else {
                            dVar11.a(dVar7, 0);
                            dVar10.a(dVar8, 0);
                        }
                    }
                    eVar8 = eVar9;
                }
            }
            i35++;
        }
    }

    public final int c() {
        return this.f14170a == 1 ? this.f14180m - this.f14185r.Q0 : this.f14180m;
    }

    public final int d() {
        return this.f14170a == 0 ? this.f14179l - this.f14185r.P0 : this.f14179l;
    }

    public final void e(int i) {
        h hVar;
        int i10;
        int i11 = this.f14183p;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f14182o;
        int i13 = i / i11;
        int i14 = 0;
        while (true) {
            hVar = this.f14185r;
            if (i14 >= i12 || (i10 = this.f14181n + i14) >= hVar.f14186b1) {
                break;
            }
            e eVar = hVar.a1[i10];
            if (this.f14170a == 0) {
                if (eVar != null) {
                    int[] iArr = eVar.f14149p0;
                    if (iArr[0] == 3 && eVar.f14151r == 0) {
                        hVar.V(1, i13, iArr[1], eVar.k(), eVar);
                    }
                }
            } else if (eVar != null) {
                int[] iArr2 = eVar.f14149p0;
                if (iArr2[1] == 3 && eVar.f14152s == 0) {
                    int i15 = i13;
                    hVar.V(iArr2[0], eVar.q(), 1, i15, eVar);
                    i13 = i15;
                }
            }
            i14++;
        }
        this.f14179l = 0;
        this.f14180m = 0;
        this.f14171b = null;
        this.f14172c = 0;
        int i16 = this.f14182o;
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = this.f14181n + i17;
            if (i18 >= hVar.f14186b1) {
                return;
            }
            e eVar2 = hVar.a1[i18];
            if (this.f14170a == 0) {
                int iQ = eVar2.q();
                int i19 = hVar.P0;
                if (eVar2.f14133g0 == 8) {
                    i19 = 0;
                }
                this.f14179l = iQ + i19 + this.f14179l;
                int iT = hVar.T(eVar2, this.f14184q);
                if (this.f14171b == null || this.f14172c < iT) {
                    this.f14171b = eVar2;
                    this.f14172c = iT;
                    this.f14180m = iT;
                }
            } else {
                int iU = hVar.U(eVar2, this.f14184q);
                int iT2 = hVar.T(eVar2, this.f14184q);
                int i20 = hVar.Q0;
                if (eVar2.f14133g0 == 8) {
                    i20 = 0;
                }
                this.f14180m = iT2 + i20 + this.f14180m;
                if (this.f14171b == null || this.f14172c < iU) {
                    this.f14171b = eVar2;
                    this.f14172c = iU;
                    this.f14179l = iU;
                }
            }
        }
    }

    public final void f(int i, d dVar, d dVar2, d dVar3, d dVar4, int i10, int i11, int i12, int i13, int i14) {
        this.f14170a = i;
        this.f14173d = dVar;
        this.f14174e = dVar2;
        this.f = dVar3;
        this.f14175g = dVar4;
        this.f14176h = i10;
        this.i = i11;
        this.f14177j = i12;
        this.f14178k = i13;
        this.f14184q = i14;
    }
}
