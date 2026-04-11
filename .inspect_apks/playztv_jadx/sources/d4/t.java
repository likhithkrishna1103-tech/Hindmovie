package d4;

import java.util.Collections;
import p1.m0;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f4002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1.t f4003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w2.h0 f4004e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p1.q f4005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4006h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4013p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4014q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4015r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4017t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f4018u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f4019v;

    public t(String str, int i) {
        this.f4000a = str;
        this.f4001b = i;
        s1.u uVar = new s1.u(1024);
        this.f4002c = uVar;
        byte[] bArr = uVar.f11709a;
        this.f4003d = new s1.t(bArr.length, bArr);
        this.f4009l = -9223372036854775807L;
    }

    @Override // d4.i
    public final void a() {
        this.f4006h = 0;
        this.f4009l = -9223372036854775807L;
        this.f4010m = false;
    }

    @Override // d4.i
    public final void d(s1.u uVar) throws n0 {
        int i;
        boolean zH;
        s1.d.h(this.f4004e);
        while (uVar.a() > 0) {
            int i10 = this.f4006h;
            if (i10 != 0) {
                if (i10 != 1) {
                    s1.u uVar2 = this.f4002c;
                    s1.t tVar = this.f4003d;
                    if (i10 == 2) {
                        int iX = ((this.f4008k & (-225)) << 8) | uVar.x();
                        this.f4007j = iX;
                        if (iX > uVar2.f11709a.length) {
                            uVar2.G(iX);
                            byte[] bArr = uVar2.f11709a;
                            tVar.getClass();
                            tVar.o(bArr.length, bArr);
                        }
                        this.i = 0;
                        this.f4006h = 3;
                    } else {
                        if (i10 != 3) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(uVar.a(), this.f4007j - this.i);
                        uVar.h(tVar.f11703b, this.i, iMin);
                        int i11 = this.i + iMin;
                        this.i = i11;
                        if (i11 == this.f4007j) {
                            tVar.q(0);
                            if (tVar.h()) {
                                if (this.f4010m) {
                                }
                                this.f4006h = 0;
                            } else {
                                this.f4010m = true;
                                int i12 = tVar.i(1);
                                int i13 = i12 == 1 ? tVar.i(1) : 0;
                                this.f4011n = i13;
                                if (i13 != 0) {
                                    throw n0.a(null, null);
                                }
                                if (i12 == 1) {
                                    tVar.i((tVar.i(2) + 1) * 8);
                                }
                                if (!tVar.h()) {
                                    throw n0.a(null, null);
                                }
                                this.f4012o = tVar.i(6);
                                int i14 = tVar.i(4);
                                int i15 = tVar.i(3);
                                if (i14 != 0 || i15 != 0) {
                                    throw n0.a(null, null);
                                }
                                if (i12 == 0) {
                                    int iG = tVar.g();
                                    int iB = tVar.b();
                                    w2.a aVarO = w2.b.o(tVar, true);
                                    this.f4019v = aVarO.f13566a;
                                    this.f4016s = aVarO.f13567b;
                                    this.f4018u = aVarO.f13568c;
                                    int iB2 = iB - tVar.b();
                                    tVar.q(iG);
                                    byte[] bArr2 = new byte[(iB2 + 7) / 8];
                                    tVar.j(iB2, bArr2);
                                    p1.p pVar = new p1.p();
                                    pVar.f9957a = this.f;
                                    pVar.f9966l = m0.p("video/mp2t");
                                    pVar.f9967m = m0.p("audio/mp4a-latm");
                                    pVar.f9964j = this.f4019v;
                                    pVar.E = this.f4018u;
                                    pVar.F = this.f4016s;
                                    pVar.f9970p = Collections.singletonList(bArr2);
                                    pVar.f9960d = this.f4000a;
                                    pVar.f = this.f4001b;
                                    p1.q qVar = new p1.q(pVar);
                                    if (!qVar.equals(this.f4005g)) {
                                        this.f4005g = qVar;
                                        this.f4017t = 1024000000 / ((long) qVar.G);
                                        this.f4004e.d(qVar);
                                    }
                                } else {
                                    int iB3 = tVar.b();
                                    w2.a aVarO2 = w2.b.o(tVar, true);
                                    this.f4019v = aVarO2.f13566a;
                                    this.f4016s = aVarO2.f13567b;
                                    this.f4018u = aVarO2.f13568c;
                                    tVar.t(tVar.i((tVar.i(2) + 1) * 8) - (iB3 - tVar.b()));
                                }
                                int i16 = tVar.i(3);
                                this.f4013p = i16;
                                if (i16 == 0) {
                                    tVar.t(8);
                                } else if (i16 == 1) {
                                    tVar.t(9);
                                } else if (i16 == 3 || i16 == 4 || i16 == 5) {
                                    tVar.t(6);
                                } else {
                                    if (i16 != 6 && i16 != 7) {
                                        throw new IllegalStateException();
                                    }
                                    tVar.t(1);
                                }
                                boolean zH2 = tVar.h();
                                this.f4014q = zH2;
                                this.f4015r = 0L;
                                if (zH2) {
                                    if (i12 == 1) {
                                        this.f4015r = tVar.i((tVar.i(2) + 1) * 8);
                                    } else {
                                        do {
                                            zH = tVar.h();
                                            this.f4015r = (this.f4015r << 8) + ((long) tVar.i(8));
                                        } while (zH);
                                    }
                                }
                                if (tVar.h()) {
                                    tVar.t(8);
                                }
                            }
                            if (this.f4011n != 0) {
                                throw n0.a(null, null);
                            }
                            if (this.f4012o != 0) {
                                throw n0.a(null, null);
                            }
                            if (this.f4013p != 0) {
                                throw n0.a(null, null);
                            }
                            int i17 = 0;
                            do {
                                i = tVar.i(8);
                                i17 += i;
                            } while (i == 255);
                            int iG2 = tVar.g();
                            if ((iG2 & 7) == 0) {
                                uVar2.J(iG2 >> 3);
                            } else {
                                tVar.j(i17 * 8, uVar2.f11709a);
                                uVar2.J(0);
                            }
                            this.f4004e.f(i17, uVar2);
                            s1.d.g(this.f4009l != -9223372036854775807L);
                            this.f4004e.a(this.f4009l, 1, i17, 0, null);
                            this.f4009l += this.f4017t;
                            if (this.f4014q) {
                                tVar.t((int) this.f4015r);
                            }
                            this.f4006h = 0;
                        } else {
                            continue;
                        }
                    }
                } else {
                    int iX2 = uVar.x();
                    if ((iX2 & 224) == 224) {
                        this.f4008k = iX2;
                        this.f4006h = 2;
                    } else if (iX2 != 86) {
                        this.f4006h = 0;
                    }
                }
            } else if (uVar.x() == 86) {
                this.f4006h = 1;
            }
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f4009l = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f4004e = qVar.q(h0Var.f3888d, 1);
        h0Var.b();
        this.f = h0Var.f3889e;
    }

    @Override // d4.i
    public final void e(boolean z2) {
    }
}
