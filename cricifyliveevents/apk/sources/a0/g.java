package a0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends i {
    public int A0;
    public b0.b B0;
    public d0.f C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public float J0;
    public float K0;
    public float L0;
    public float M0;
    public float N0;
    public float O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public ArrayList W0;
    public d[] X0;
    public d[] Y0;
    public int[] Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public d[] f91a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f92b1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f93s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f94t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f95u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f96v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f97w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f98x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f99y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f100z0;

    @Override // a0.i
    public final void S() {
        for (int i = 0; i < this.f108r0; i++) {
            d dVar = this.f107q0[i];
            if (dVar != null) {
                dVar.F = true;
            }
        }
    }

    public final int T(d dVar, int i) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f54p0;
            if (iArr[1] == 3) {
                int i10 = dVar.f57s;
                if (i10 != 0) {
                    if (i10 == 2) {
                        int i11 = (int) (dVar.f64z * i);
                        if (i11 != dVar.k()) {
                            dVar.f37g = true;
                            V(iArr[0], dVar.q(), 1, i11, dVar);
                        }
                        return i11;
                    }
                    dVar2 = dVar;
                    if (i10 == 1) {
                        return dVar2.k();
                    }
                    if (i10 == 3) {
                        return (int) ((dVar2.q() * dVar2.W) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.k();
        }
        return 0;
    }

    public final int U(d dVar, int i) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f54p0;
            if (iArr[0] == 3) {
                int i10 = dVar.f56r;
                if (i10 != 0) {
                    if (i10 == 2) {
                        int i11 = (int) (dVar.f61w * i);
                        if (i11 != dVar.q()) {
                            dVar.f37g = true;
                            V(1, i11, iArr[1], dVar.k(), dVar);
                        }
                        return i11;
                    }
                    dVar2 = dVar;
                    if (i10 == 1) {
                        return dVar2.q();
                    }
                    if (i10 == 3) {
                        return (int) ((dVar2.k() * dVar2.W) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.q();
        }
        return 0;
    }

    public final void V(int i, int i10, int i11, int i12, d dVar) {
        d0.f fVar;
        d dVar2;
        b0.b bVar = this.B0;
        while (true) {
            fVar = this.C0;
            if (fVar != null || (dVar2 = this.T) == null) {
                break;
            } else {
                this.C0 = ((e) dVar2).f69u0;
            }
        }
        bVar.f1585a = i;
        bVar.f1586b = i11;
        bVar.f1587c = i10;
        bVar.f1588d = i12;
        fVar.b(dVar, bVar);
        dVar.O(bVar.f1589e);
        dVar.L(bVar.f);
        dVar.E = bVar.f1591h;
        dVar.I(bVar.f1590g);
    }

    @Override // a0.d
    public final void b(y.c cVar, boolean z10) {
        d dVar;
        float f;
        int i;
        ArrayList arrayList = this.W0;
        super.b(cVar, z10);
        d dVar2 = this.T;
        boolean z11 = dVar2 != null && ((e) dVar2).f70v0;
        int i10 = this.T0;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    ((f) arrayList.get(i11)).b(i11, z11, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    int size2 = arrayList.size();
                    int i12 = 0;
                    while (i12 < size2) {
                        ((f) arrayList.get(i12)).b(i12, z11, i12 == size2 + (-1));
                        i12++;
                    }
                }
            } else if (this.Z0 != null && this.Y0 != null && this.X0 != null) {
                for (int i13 = 0; i13 < this.f92b1; i13++) {
                    this.f91a1[i13].D();
                }
                int[] iArr = this.Z0;
                int i14 = iArr[0];
                int i15 = iArr[1];
                float f10 = this.J0;
                d dVar3 = null;
                int i16 = 0;
                while (i16 < i14) {
                    if (z11) {
                        i = (i14 - i16) - 1;
                        f = 1.0f - this.J0;
                    } else {
                        f = f10;
                        i = i16;
                    }
                    d dVar4 = this.Y0[i];
                    if (dVar4 != null) {
                        c cVar2 = dVar4.I;
                        if (dVar4.f38g0 != 8) {
                            if (i16 == 0) {
                                dVar4.f(cVar2, this.I, this.f97w0);
                                dVar4.f41i0 = this.D0;
                                dVar4.f33d0 = f;
                            }
                            if (i16 == i14 - 1) {
                                dVar4.f(dVar4.K, this.K, this.f98x0);
                            }
                            if (i16 > 0 && dVar3 != null) {
                                c cVar3 = dVar3.K;
                                dVar4.f(cVar2, cVar3, this.P0);
                                dVar3.f(cVar3, cVar2, 0);
                            }
                            dVar3 = dVar4;
                        }
                    }
                    i16++;
                    f10 = f;
                }
                for (int i17 = 0; i17 < i15; i17++) {
                    d dVar5 = this.X0[i17];
                    if (dVar5 != null) {
                        c cVar4 = dVar5.J;
                        if (dVar5.f38g0 != 8) {
                            if (i17 == 0) {
                                dVar5.f(cVar4, this.J, this.f93s0);
                                dVar5.f43j0 = this.E0;
                                dVar5.f35e0 = this.K0;
                            }
                            if (i17 == i15 - 1) {
                                dVar5.f(dVar5.L, this.L, this.f94t0);
                            }
                            if (i17 > 0 && dVar3 != null) {
                                c cVar5 = dVar3.L;
                                dVar5.f(cVar4, cVar5, this.Q0);
                                dVar3.f(cVar5, cVar4, 0);
                            }
                            dVar3 = dVar5;
                        }
                    }
                }
                for (int i18 = 0; i18 < i14; i18++) {
                    for (int i19 = 0; i19 < i15; i19++) {
                        int i20 = (i19 * i14) + i18;
                        if (this.V0 == 1) {
                            i20 = (i18 * i15) + i19;
                        }
                        d[] dVarArr = this.f91a1;
                        if (i20 < dVarArr.length && (dVar = dVarArr[i20]) != null && dVar.f38g0 != 8) {
                            d dVar6 = this.Y0[i18];
                            d dVar7 = this.X0[i19];
                            if (dVar != dVar6) {
                                dVar.f(dVar.I, dVar6.I, 0);
                                dVar.f(dVar.K, dVar6.K, 0);
                            }
                            if (dVar != dVar7) {
                                dVar.f(dVar.J, dVar7.J, 0);
                                dVar.f(dVar.L, dVar7.L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((f) arrayList.get(0)).b(0, z11, true);
        }
        this.f99y0 = false;
    }
}
