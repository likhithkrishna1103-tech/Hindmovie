package h4;

import a3.i0;
import a3.k0;
import java.util.Collections;
import v1.m0;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f5766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i0 f5767e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v1.p f5768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5769h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5774n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5775o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5776p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5777q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f5778r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5779s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f5780t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5781u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f5782v;

    public t(int i, String str) {
        this.f5763a = str;
        this.f5764b = i;
        y1.t tVar = new y1.t(1024);
        this.f5765c = tVar;
        byte[] bArr = tVar.f14609a;
        this.f5766d = new k0(bArr.length, bArr);
        this.f5772l = -9223372036854775807L;
    }

    @Override // h4.i
    public final void a() {
        this.f5769h = 0;
        this.f5772l = -9223372036854775807L;
        this.f5773m = false;
    }

    @Override // h4.i
    public final void b(y1.t tVar) throws n0 {
        int i;
        boolean zH;
        y1.d.h(this.f5767e);
        while (tVar.a() > 0) {
            int i10 = this.f5769h;
            if (i10 != 0) {
                if (i10 != 1) {
                    y1.t tVar2 = this.f5765c;
                    k0 k0Var = this.f5766d;
                    if (i10 == 2) {
                        int iX = ((this.f5771k & (-225)) << 8) | tVar.x();
                        this.f5770j = iX;
                        if (iX > tVar2.f14609a.length) {
                            tVar2.G(iX);
                            byte[] bArr = tVar2.f14609a;
                            k0Var.getClass();
                            k0Var.o(bArr.length, bArr);
                        }
                        this.i = 0;
                        this.f5769h = 3;
                    } else {
                        if (i10 != 3) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(tVar.a(), this.f5770j - this.i);
                        tVar.h(k0Var.f208b, this.i, iMin);
                        int i11 = this.i + iMin;
                        this.i = i11;
                        if (i11 == this.f5770j) {
                            k0Var.q(0);
                            if (k0Var.h()) {
                                if (this.f5773m) {
                                }
                                this.f5769h = 0;
                            } else {
                                this.f5773m = true;
                                int i12 = k0Var.i(1);
                                int i13 = i12 == 1 ? k0Var.i(1) : 0;
                                this.f5774n = i13;
                                if (i13 != 0) {
                                    throw n0.a(null, null);
                                }
                                if (i12 == 1) {
                                    k0Var.i((k0Var.i(2) + 1) * 8);
                                }
                                if (!k0Var.h()) {
                                    throw n0.a(null, null);
                                }
                                this.f5775o = k0Var.i(6);
                                int i14 = k0Var.i(4);
                                int i15 = k0Var.i(3);
                                if (i14 != 0 || i15 != 0) {
                                    throw n0.a(null, null);
                                }
                                if (i12 == 0) {
                                    int iG = k0Var.g();
                                    int iB = k0Var.b();
                                    a3.a aVarN = a3.b.n(k0Var, true);
                                    this.f5782v = aVarN.f114a;
                                    this.f5779s = aVarN.f115b;
                                    this.f5781u = aVarN.f116c;
                                    int iB2 = iB - k0Var.b();
                                    k0Var.q(iG);
                                    byte[] bArr2 = new byte[(iB2 + 7) / 8];
                                    k0Var.j(iB2, bArr2);
                                    v1.o oVar = new v1.o();
                                    oVar.f12883a = this.f;
                                    oVar.f12892l = m0.p("video/mp2t");
                                    oVar.f12893m = m0.p("audio/mp4a-latm");
                                    oVar.f12890j = this.f5782v;
                                    oVar.E = this.f5781u;
                                    oVar.F = this.f5779s;
                                    oVar.f12896p = Collections.singletonList(bArr2);
                                    oVar.f12886d = this.f5763a;
                                    oVar.f = this.f5764b;
                                    v1.p pVar = new v1.p(oVar);
                                    if (!pVar.equals(this.f5768g)) {
                                        this.f5768g = pVar;
                                        this.f5780t = 1024000000 / ((long) pVar.G);
                                        this.f5767e.f(pVar);
                                    }
                                } else {
                                    int iB3 = k0Var.b();
                                    a3.a aVarN2 = a3.b.n(k0Var, true);
                                    this.f5782v = aVarN2.f114a;
                                    this.f5779s = aVarN2.f115b;
                                    this.f5781u = aVarN2.f116c;
                                    k0Var.t(k0Var.i((k0Var.i(2) + 1) * 8) - (iB3 - k0Var.b()));
                                }
                                int i16 = k0Var.i(3);
                                this.f5776p = i16;
                                if (i16 == 0) {
                                    k0Var.t(8);
                                } else if (i16 == 1) {
                                    k0Var.t(9);
                                } else if (i16 == 3 || i16 == 4 || i16 == 5) {
                                    k0Var.t(6);
                                } else {
                                    if (i16 != 6 && i16 != 7) {
                                        throw new IllegalStateException();
                                    }
                                    k0Var.t(1);
                                }
                                boolean zH2 = k0Var.h();
                                this.f5777q = zH2;
                                this.f5778r = 0L;
                                if (zH2) {
                                    if (i12 == 1) {
                                        this.f5778r = k0Var.i((k0Var.i(2) + 1) * 8);
                                    } else {
                                        do {
                                            zH = k0Var.h();
                                            this.f5778r = (this.f5778r << 8) + ((long) k0Var.i(8));
                                        } while (zH);
                                    }
                                }
                                if (k0Var.h()) {
                                    k0Var.t(8);
                                }
                            }
                            if (this.f5774n != 0) {
                                throw n0.a(null, null);
                            }
                            if (this.f5775o != 0) {
                                throw n0.a(null, null);
                            }
                            if (this.f5776p != 0) {
                                throw n0.a(null, null);
                            }
                            int i17 = 0;
                            do {
                                i = k0Var.i(8);
                                i17 += i;
                            } while (i == 255);
                            int iG2 = k0Var.g();
                            if ((iG2 & 7) == 0) {
                                tVar2.J(iG2 >> 3);
                            } else {
                                k0Var.j(i17 * 8, tVar2.f14609a);
                                tVar2.J(0);
                            }
                            this.f5767e.a(i17, tVar2);
                            y1.d.g(this.f5772l != -9223372036854775807L);
                            this.f5767e.e(this.f5772l, 1, i17, 0, null);
                            this.f5772l += this.f5780t;
                            if (this.f5777q) {
                                k0Var.t((int) this.f5778r);
                            }
                            this.f5769h = 0;
                        } else {
                            continue;
                        }
                    }
                } else {
                    int iX2 = tVar.x();
                    if ((iX2 & 224) == 224) {
                        this.f5771k = iX2;
                        this.f5769h = 2;
                    } else if (iX2 != 86) {
                        this.f5769h = 0;
                    }
                }
            } else if (tVar.x() == 86) {
                this.f5769h = 1;
            }
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5772l = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5767e = rVar.p(g0Var.f5645d, 1);
        g0Var.b();
        this.f = g0Var.f5646e;
    }

    @Override // h4.i
    public final void c(boolean z10) {
    }
}
