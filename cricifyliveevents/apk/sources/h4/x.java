package h4;

import a3.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f5817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f5818b = new k0(10, new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5819c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y1.y f5821e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5823h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5826l;

    public x(i iVar) {
        this.f5817a = iVar;
    }

    @Override // h4.h0
    public final void a() {
        this.f5819c = 0;
        this.f5820d = 0;
        this.f5823h = false;
        this.f5817a.a();
    }

    @Override // h4.h0
    public final void b(int i, y1.t tVar) {
        y1.d.h(this.f5821e);
        int i10 = i & 1;
        int i11 = -1;
        int i12 = 2;
        i iVar = this.f5817a;
        if (i10 != 0) {
            int i13 = this.f5819c;
            if (i13 != 0 && i13 != 1) {
                if (i13 == 2) {
                    y1.b.p("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i13 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f5824j != -1) {
                        y1.b.p("PesReader", "Unexpected start indicator: expected " + this.f5824j + " more bytes");
                    }
                    iVar.c(tVar.f14611c == 0);
                }
            }
            this.f5819c = 1;
            this.f5820d = 0;
        }
        int i14 = i;
        while (tVar.a() > 0) {
            int i15 = this.f5819c;
            if (i15 != 0) {
                k0 k0Var = this.f5818b;
                if (i15 != 1) {
                    if (i15 == i12) {
                        if (d(tVar, k0Var.f208b, Math.min(10, this.i)) && d(tVar, null, this.i)) {
                            k0Var.q(0);
                            this.f5826l = -9223372036854775807L;
                            if (this.f) {
                                k0Var.t(4);
                                long jI = ((long) k0Var.i(3)) << 30;
                                k0Var.t(1);
                                long jI2 = ((long) (k0Var.i(15) << 15)) | jI;
                                k0Var.t(1);
                                long jI3 = jI2 | ((long) k0Var.i(15));
                                k0Var.t(1);
                                if (!this.f5823h && this.f5822g) {
                                    k0Var.t(4);
                                    long jI4 = ((long) k0Var.i(3)) << 30;
                                    k0Var.t(1);
                                    long jI5 = jI4 | ((long) (k0Var.i(15) << 15));
                                    k0Var.t(1);
                                    long jI6 = jI5 | ((long) k0Var.i(15));
                                    k0Var.t(1);
                                    this.f5821e.b(jI6);
                                    this.f5823h = true;
                                }
                                this.f5826l = this.f5821e.b(jI3);
                            }
                            i14 |= this.f5825k ? 4 : 0;
                            iVar.d(i14, this.f5826l);
                            this.f5819c = 3;
                            this.f5820d = 0;
                        }
                    } else {
                        if (i15 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = tVar.a();
                        int i16 = this.f5824j;
                        int i17 = i16 == i11 ? 0 : iA - i16;
                        if (i17 > 0) {
                            iA -= i17;
                            tVar.I(tVar.f14610b + iA);
                        }
                        iVar.b(tVar);
                        int i18 = this.f5824j;
                        if (i18 != i11) {
                            int i19 = i18 - iA;
                            this.f5824j = i19;
                            if (i19 == 0) {
                                iVar.c(false);
                                this.f5819c = 1;
                                this.f5820d = 0;
                            }
                        }
                    }
                } else if (d(tVar, k0Var.f208b, 9)) {
                    this.f5819c = e() ? 2 : 0;
                    this.f5820d = 0;
                }
            } else {
                tVar.K(tVar.a());
            }
            i11 = -1;
            i12 = 2;
        }
    }

    @Override // h4.h0
    public final void c(y1.y yVar, a3.r rVar, g0 g0Var) {
        this.f5821e = yVar;
        this.f5817a.e(rVar, g0Var);
    }

    public final boolean d(y1.t tVar, byte[] bArr, int i) {
        int iMin = Math.min(tVar.a(), i - this.f5820d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            tVar.K(iMin);
        } else {
            tVar.h(bArr, this.f5820d, iMin);
        }
        int i10 = this.f5820d + iMin;
        this.f5820d = i10;
        return i10 == i;
    }

    public final boolean e() {
        k0 k0Var = this.f5818b;
        k0Var.q(0);
        int i = k0Var.i(24);
        if (i != 1) {
            l0.e.p(i, "Unexpected start code prefix: ", "PesReader");
            this.f5824j = -1;
            return false;
        }
        k0Var.t(8);
        int i10 = k0Var.i(16);
        k0Var.t(5);
        this.f5825k = k0Var.h();
        k0Var.t(2);
        this.f = k0Var.h();
        this.f5822g = k0Var.h();
        k0Var.t(6);
        int i11 = k0Var.i(8);
        this.i = i11;
        if (i10 == 0) {
            this.f5824j = -1;
        } else {
            int i12 = (i10 - 3) - i11;
            this.f5824j = i12;
            if (i12 < 0) {
                y1.b.p("PesReader", "Found negative packet payload size: " + this.f5824j);
                this.f5824j = -1;
            }
        }
        return true;
    }
}
