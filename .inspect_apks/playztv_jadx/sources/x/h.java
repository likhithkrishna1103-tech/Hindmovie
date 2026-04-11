package x;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends j {
    public int A0;
    public y.b B0;
    public a0.f C0;
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
    public e[] X0;
    public e[] Y0;
    public int[] Z0;
    public e[] a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f14186b1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f14187s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f14188t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f14189u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f14190v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f14191w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f14192x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f14193y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f14194z0;

    @Override // x.j
    public final void S() {
        for (int i = 0; i < this.f14202r0; i++) {
            e eVar = this.f14201q0[i];
            if (eVar != null) {
                eVar.F = true;
            }
        }
    }

    public final int T(e eVar, int i) {
        e eVar2;
        if (eVar != null) {
            int[] iArr = eVar.f14149p0;
            if (iArr[1] == 3) {
                int i10 = eVar.f14152s;
                if (i10 != 0) {
                    if (i10 == 2) {
                        int i11 = (int) (eVar.f14159z * i);
                        if (i11 != eVar.k()) {
                            eVar.f14132g = true;
                            V(iArr[0], eVar.q(), 1, i11, eVar);
                        }
                        return i11;
                    }
                    eVar2 = eVar;
                    if (i10 == 1) {
                        return eVar2.k();
                    }
                    if (i10 == 3) {
                        return (int) ((eVar2.q() * eVar2.W) + 0.5f);
                    }
                }
            } else {
                eVar2 = eVar;
            }
            return eVar2.k();
        }
        return 0;
    }

    public final int U(e eVar, int i) {
        e eVar2;
        if (eVar != null) {
            int[] iArr = eVar.f14149p0;
            if (iArr[0] == 3) {
                int i10 = eVar.f14151r;
                if (i10 != 0) {
                    if (i10 == 2) {
                        int i11 = (int) (eVar.f14156w * i);
                        if (i11 != eVar.q()) {
                            eVar.f14132g = true;
                            V(1, i11, iArr[1], eVar.k(), eVar);
                        }
                        return i11;
                    }
                    eVar2 = eVar;
                    if (i10 == 1) {
                        return eVar2.q();
                    }
                    if (i10 == 3) {
                        return (int) ((eVar2.k() * eVar2.W) + 0.5f);
                    }
                }
            } else {
                eVar2 = eVar;
            }
            return eVar2.q();
        }
        return 0;
    }

    public final void V(int i, int i10, int i11, int i12, e eVar) {
        a0.f fVar;
        e eVar2;
        y.b bVar = this.B0;
        while (true) {
            fVar = this.C0;
            if (fVar != null || (eVar2 = this.T) == null) {
                break;
            } else {
                this.C0 = ((f) eVar2).f14164u0;
            }
        }
        bVar.f14373a = i;
        bVar.f14374b = i11;
        bVar.f14375c = i10;
        bVar.f14376d = i12;
        fVar.b(eVar, bVar);
        eVar.O(bVar.f14377e);
        eVar.L(bVar.f);
        eVar.E = bVar.f14379h;
        eVar.I(bVar.f14378g);
    }

    @Override // x.e
    public final void b(v.c cVar, boolean z2) {
        e eVar;
        float f;
        int i;
        ArrayList arrayList = this.W0;
        super.b(cVar, z2);
        e eVar2 = this.T;
        boolean z10 = eVar2 != null && ((f) eVar2).f14165v0;
        int i10 = this.T0;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    ((g) arrayList.get(i11)).b(i11, z10, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 != 2) {
                if (i10 == 3) {
                    int size2 = arrayList.size();
                    int i12 = 0;
                    while (i12 < size2) {
                        ((g) arrayList.get(i12)).b(i12, z10, i12 == size2 + (-1));
                        i12++;
                    }
                }
            } else if (this.Z0 != null && this.Y0 != null && this.X0 != null) {
                for (int i13 = 0; i13 < this.f14186b1; i13++) {
                    this.a1[i13].D();
                }
                int[] iArr = this.Z0;
                int i14 = iArr[0];
                int i15 = iArr[1];
                float f4 = this.J0;
                e eVar3 = null;
                int i16 = 0;
                while (i16 < i14) {
                    if (z10) {
                        i = (i14 - i16) - 1;
                        f = 1.0f - this.J0;
                    } else {
                        f = f4;
                        i = i16;
                    }
                    e eVar4 = this.Y0[i];
                    if (eVar4 != null) {
                        d dVar = eVar4.I;
                        if (eVar4.f14133g0 != 8) {
                            if (i16 == 0) {
                                eVar4.f(dVar, this.I, this.f14191w0);
                                eVar4.f14136i0 = this.D0;
                                eVar4.f14128d0 = f;
                            }
                            if (i16 == i14 - 1) {
                                eVar4.f(eVar4.K, this.K, this.f14192x0);
                            }
                            if (i16 > 0 && eVar3 != null) {
                                d dVar2 = eVar3.K;
                                eVar4.f(dVar, dVar2, this.P0);
                                eVar3.f(dVar2, dVar, 0);
                            }
                            eVar3 = eVar4;
                        }
                    }
                    i16++;
                    f4 = f;
                }
                for (int i17 = 0; i17 < i15; i17++) {
                    e eVar5 = this.X0[i17];
                    if (eVar5 != null) {
                        d dVar3 = eVar5.J;
                        if (eVar5.f14133g0 != 8) {
                            if (i17 == 0) {
                                eVar5.f(dVar3, this.J, this.f14187s0);
                                eVar5.f14138j0 = this.E0;
                                eVar5.f14130e0 = this.K0;
                            }
                            if (i17 == i15 - 1) {
                                eVar5.f(eVar5.L, this.L, this.f14188t0);
                            }
                            if (i17 > 0 && eVar3 != null) {
                                d dVar4 = eVar3.L;
                                eVar5.f(dVar3, dVar4, this.Q0);
                                eVar3.f(dVar4, dVar3, 0);
                            }
                            eVar3 = eVar5;
                        }
                    }
                }
                for (int i18 = 0; i18 < i14; i18++) {
                    for (int i19 = 0; i19 < i15; i19++) {
                        int i20 = (i19 * i14) + i18;
                        if (this.V0 == 1) {
                            i20 = (i18 * i15) + i19;
                        }
                        e[] eVarArr = this.a1;
                        if (i20 < eVarArr.length && (eVar = eVarArr[i20]) != null && eVar.f14133g0 != 8) {
                            e eVar6 = this.Y0[i18];
                            e eVar7 = this.X0[i19];
                            if (eVar != eVar6) {
                                eVar.f(eVar.I, eVar6.I, 0);
                                eVar.f(eVar.K, eVar6.K, 0);
                            }
                            if (eVar != eVar7) {
                                eVar.f(eVar.J, eVar7.J, 0);
                                eVar.f(eVar.L, eVar7.L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((g) arrayList.get(0)).b(0, z10, true);
        }
        this.f14193y0 = false;
    }
}
