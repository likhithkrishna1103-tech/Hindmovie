package a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f78d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f79e;
    public c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f80g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f81h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f82j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f83k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f89q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ g f90r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f76b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77c = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f84l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f85m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f86n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f87o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f88p = 0;

    public f(g gVar, int i, c cVar, c cVar2, c cVar3, c cVar4, int i10) {
        this.f90r = gVar;
        this.f75a = i;
        this.f78d = cVar;
        this.f79e = cVar2;
        this.f = cVar3;
        this.f80g = cVar4;
        this.f81h = gVar.f97w0;
        this.i = gVar.f93s0;
        this.f82j = gVar.f98x0;
        this.f83k = gVar.f94t0;
        this.f89q = i10;
    }

    public final void a(d dVar) {
        int i = this.f75a;
        g gVar = this.f90r;
        if (i == 0) {
            int iU = gVar.U(dVar, this.f89q);
            if (dVar.f54p0[0] == 3) {
                this.f88p++;
                iU = 0;
            }
            this.f84l = iU + (dVar.f38g0 != 8 ? gVar.P0 : 0) + this.f84l;
            int iT = gVar.T(dVar, this.f89q);
            if (this.f76b == null || this.f77c < iT) {
                this.f76b = dVar;
                this.f77c = iT;
                this.f85m = iT;
            }
        } else {
            int iU2 = gVar.U(dVar, this.f89q);
            int iT2 = gVar.T(dVar, this.f89q);
            if (dVar.f54p0[1] == 3) {
                this.f88p++;
                iT2 = 0;
            }
            this.f85m = iT2 + (dVar.f38g0 != 8 ? gVar.Q0 : 0) + this.f85m;
            if (this.f76b == null || this.f77c < iU2) {
                this.f76b = dVar;
                this.f77c = iU2;
                this.f84l = iU2;
            }
        }
        this.f87o++;
    }

    public final void b(int i, boolean z10, boolean z11) {
        g gVar;
        int i10;
        int i11;
        d dVar;
        boolean z12;
        int i12;
        int i13;
        char c9;
        float f;
        float f10;
        float f11;
        int i14;
        float f12;
        float f13;
        int i15;
        int i16 = this.f87o;
        int i17 = 0;
        while (true) {
            gVar = this.f90r;
            if (i17 >= i16 || (i15 = this.f86n + i17) >= gVar.f92b1) {
                break;
            }
            d dVar2 = gVar.f91a1[i15];
            if (dVar2 != null) {
                dVar2.D();
            }
            i17++;
        }
        if (i16 == 0 || this.f76b == null) {
            return;
        }
        boolean z13 = z11 && i == 0;
        int i18 = -1;
        int i19 = -1;
        for (int i20 = 0; i20 < i16; i20++) {
            int i21 = this.f86n + (z10 ? (i16 - 1) - i20 : i20);
            if (i21 >= gVar.f92b1) {
                break;
            }
            d dVar3 = gVar.f91a1[i21];
            if (dVar3 != null && dVar3.f38g0 == 0) {
                if (i18 == -1) {
                    i18 = i20;
                }
                i19 = i20;
            }
        }
        if (this.f75a == 0) {
            d dVar4 = this.f76b;
            dVar4.f43j0 = gVar.E0;
            c cVar = dVar4.L;
            c cVar2 = dVar4.J;
            int i22 = this.i;
            if (i > 0) {
                i22 += gVar.Q0;
            }
            cVar2.a(this.f79e, i22);
            if (z11) {
                cVar.a(this.f80g, this.f83k);
            }
            if (i > 0) {
                this.f79e.f22d.L.a(cVar2, 0);
            }
            if (gVar.S0 != 3 || dVar4.E) {
                dVar = dVar4;
            } else {
                for (int i23 = 0; i23 < i16; i23++) {
                    int i24 = this.f86n + (z10 ? (i16 - 1) - i23 : i23);
                    if (i24 >= gVar.f92b1) {
                        break;
                    }
                    dVar = gVar.f91a1[i24];
                    if (dVar.E) {
                        break;
                    }
                }
                dVar = dVar4;
            }
            int i25 = 0;
            d dVar5 = null;
            while (i25 < i16) {
                int i26 = z10 ? (i16 - 1) - i25 : i25;
                int i27 = this.f86n + i26;
                if (i27 >= gVar.f92b1) {
                    return;
                }
                d dVar6 = gVar.f91a1[i27];
                if (dVar6 == null) {
                    i13 = i16;
                    z12 = z13;
                    i12 = i19;
                    c9 = 3;
                } else {
                    c cVar3 = dVar6.L;
                    c cVar4 = dVar6.J;
                    c cVar5 = dVar6.I;
                    z12 = z13;
                    if (i25 == 0) {
                        i12 = i19;
                        dVar6.f(cVar5, this.f78d, this.f81h);
                    } else {
                        i12 = i19;
                    }
                    if (i26 == 0) {
                        int i28 = gVar.D0;
                        if (z10) {
                            f = 1.0f;
                            f10 = 1.0f - gVar.J0;
                        } else {
                            f = 1.0f;
                            f10 = gVar.J0;
                        }
                        if (this.f86n == 0) {
                            i14 = gVar.F0;
                            f11 = f10;
                            if (i14 != -1) {
                                if (z10) {
                                    f13 = gVar.L0;
                                    f12 = f - f13;
                                    dVar6.f41i0 = i14;
                                    dVar6.f33d0 = f12;
                                } else {
                                    f12 = gVar.L0;
                                    dVar6.f41i0 = i14;
                                    dVar6.f33d0 = f12;
                                }
                            }
                        } else {
                            f11 = f10;
                        }
                        if (!z11 || (i14 = gVar.H0) == -1) {
                            i14 = i28;
                            f12 = f11;
                        } else if (z10) {
                            f13 = gVar.N0;
                            f12 = f - f13;
                        } else {
                            f12 = gVar.N0;
                        }
                        dVar6.f41i0 = i14;
                        dVar6.f33d0 = f12;
                    }
                    if (i25 == i16 - 1) {
                        i13 = i16;
                        dVar6.f(dVar6.K, this.f, this.f82j);
                    } else {
                        i13 = i16;
                    }
                    if (dVar5 != null) {
                        c cVar6 = dVar5.K;
                        cVar5.a(cVar6, gVar.P0);
                        if (i25 == i18) {
                            int i29 = this.f81h;
                            if (cVar5.h()) {
                                cVar5.f25h = i29;
                            }
                        }
                        cVar6.a(cVar5, 0);
                        if (i25 == i12 + 1) {
                            int i30 = this.f82j;
                            if (cVar6.h()) {
                                cVar6.f25h = i30;
                            }
                        }
                    }
                    if (dVar6 != dVar4) {
                        int i31 = gVar.S0;
                        c9 = 3;
                        if (i31 == 3 && dVar.E && dVar6 != dVar && dVar6.E) {
                            dVar6.M.a(dVar.M, 0);
                        } else if (i31 == 0) {
                            cVar4.a(cVar2, 0);
                        } else if (i31 == 1) {
                            cVar3.a(cVar, 0);
                        } else if (z12) {
                            cVar4.a(this.f79e, this.i);
                            cVar3.a(this.f80g, this.f83k);
                        } else {
                            cVar4.a(cVar2, 0);
                            cVar3.a(cVar, 0);
                        }
                    } else {
                        c9 = 3;
                    }
                    dVar5 = dVar6;
                }
                i25++;
                z13 = z12;
                i19 = i12;
                i16 = i13;
            }
            return;
        }
        int i32 = i16;
        boolean z14 = z13;
        int i33 = i19;
        d dVar7 = this.f76b;
        dVar7.f41i0 = gVar.D0;
        c cVar7 = dVar7.I;
        c cVar8 = dVar7.K;
        int i34 = this.f81h;
        if (i > 0) {
            i34 += gVar.P0;
        }
        if (z10) {
            cVar8.a(this.f, i34);
            if (z11) {
                cVar7.a(this.f78d, this.f82j);
            }
            if (i > 0) {
                this.f.f22d.I.a(cVar8, 0);
            }
        } else {
            cVar7.a(this.f78d, i34);
            if (z11) {
                cVar8.a(this.f, this.f82j);
            }
            if (i > 0) {
                this.f78d.f22d.K.a(cVar7, 0);
            }
        }
        int i35 = 0;
        d dVar8 = null;
        while (true) {
            int i36 = i32;
            if (i35 >= i36 || (i10 = this.f86n + i35) >= gVar.f92b1) {
                return;
            }
            d dVar9 = gVar.f91a1[i10];
            if (dVar9 == null) {
                i32 = i36;
            } else {
                c cVar9 = dVar9.J;
                c cVar10 = dVar9.K;
                c cVar11 = dVar9.I;
                if (i35 == 0) {
                    dVar9.f(cVar9, this.f79e, this.i);
                    int i37 = gVar.E0;
                    float f14 = gVar.K0;
                    if (this.f86n == 0) {
                        int i38 = gVar.G0;
                        i32 = i36;
                        i11 = -1;
                        if (i38 != -1) {
                            f14 = gVar.M0;
                        }
                        i37 = i38;
                        dVar9.f43j0 = i37;
                        dVar9.f35e0 = f14;
                    } else {
                        i32 = i36;
                        i11 = -1;
                    }
                    if (z11 && (i38 = gVar.I0) != i11) {
                        f14 = gVar.O0;
                        i37 = i38;
                    }
                    dVar9.f43j0 = i37;
                    dVar9.f35e0 = f14;
                } else {
                    i32 = i36;
                }
                if (i35 == i32 - 1) {
                    dVar9.f(dVar9.L, this.f80g, this.f83k);
                }
                if (dVar8 != null) {
                    c cVar12 = dVar8.L;
                    cVar9.a(cVar12, gVar.Q0);
                    if (i35 == i18) {
                        int i39 = this.i;
                        if (cVar9.h()) {
                            cVar9.f25h = i39;
                        }
                    }
                    cVar12.a(cVar9, 0);
                    if (i35 == i33 + 1) {
                        int i40 = this.f83k;
                        if (cVar12.h()) {
                            cVar12.f25h = i40;
                        }
                    }
                }
                if (dVar9 == dVar7) {
                    dVar8 = dVar9;
                } else if (z10) {
                    int i41 = gVar.R0;
                    if (i41 == 0) {
                        cVar10.a(cVar8, 0);
                    } else if (i41 == 1) {
                        cVar11.a(cVar7, 0);
                    } else if (i41 == 2) {
                        cVar11.a(cVar7, 0);
                        cVar10.a(cVar8, 0);
                    }
                    dVar8 = dVar9;
                } else {
                    int i42 = gVar.R0;
                    if (i42 == 0) {
                        cVar11.a(cVar7, 0);
                    } else if (i42 == 1) {
                        cVar10.a(cVar8, 0);
                    } else if (i42 == 2) {
                        if (z14) {
                            cVar11.a(this.f78d, this.f81h);
                            cVar10.a(this.f, this.f82j);
                        } else {
                            cVar11.a(cVar7, 0);
                            cVar10.a(cVar8, 0);
                        }
                    }
                    dVar8 = dVar9;
                }
            }
            i35++;
        }
    }

    public final int c() {
        return this.f75a == 1 ? this.f85m - this.f90r.Q0 : this.f85m;
    }

    public final int d() {
        return this.f75a == 0 ? this.f84l - this.f90r.P0 : this.f84l;
    }

    public final void e(int i) {
        g gVar;
        int i10;
        int i11 = this.f88p;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f87o;
        int i13 = i / i11;
        int i14 = 0;
        while (true) {
            gVar = this.f90r;
            if (i14 >= i12 || (i10 = this.f86n + i14) >= gVar.f92b1) {
                break;
            }
            d dVar = gVar.f91a1[i10];
            if (this.f75a == 0) {
                if (dVar != null) {
                    int[] iArr = dVar.f54p0;
                    if (iArr[0] == 3 && dVar.f56r == 0) {
                        gVar.V(1, i13, iArr[1], dVar.k(), dVar);
                    }
                }
            } else if (dVar != null) {
                int[] iArr2 = dVar.f54p0;
                if (iArr2[1] == 3 && dVar.f57s == 0) {
                    int i15 = i13;
                    gVar.V(iArr2[0], dVar.q(), 1, i15, dVar);
                    i13 = i15;
                }
            }
            i14++;
        }
        this.f84l = 0;
        this.f85m = 0;
        this.f76b = null;
        this.f77c = 0;
        int i16 = this.f87o;
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = this.f86n + i17;
            if (i18 >= gVar.f92b1) {
                return;
            }
            d dVar2 = gVar.f91a1[i18];
            if (this.f75a == 0) {
                int iQ = dVar2.q();
                int i19 = gVar.P0;
                if (dVar2.f38g0 == 8) {
                    i19 = 0;
                }
                this.f84l = iQ + i19 + this.f84l;
                int iT = gVar.T(dVar2, this.f89q);
                if (this.f76b == null || this.f77c < iT) {
                    this.f76b = dVar2;
                    this.f77c = iT;
                    this.f85m = iT;
                }
            } else {
                int iU = gVar.U(dVar2, this.f89q);
                int iT2 = gVar.T(dVar2, this.f89q);
                int i20 = gVar.Q0;
                if (dVar2.f38g0 == 8) {
                    i20 = 0;
                }
                this.f85m = iT2 + i20 + this.f85m;
                if (this.f76b == null || this.f77c < iU) {
                    this.f76b = dVar2;
                    this.f77c = iU;
                    this.f84l = iU;
                }
            }
        }
    }

    public final void f(int i, c cVar, c cVar2, c cVar3, c cVar4, int i10, int i11, int i12, int i13, int i14) {
        this.f75a = i;
        this.f78d = cVar;
        this.f79e = cVar2;
        this.f = cVar3;
        this.f80g = cVar4;
        this.f81h = i10;
        this.i = i11;
        this.f82j = i12;
        this.f83k = i13;
        this.f89q = i14;
    }
}
