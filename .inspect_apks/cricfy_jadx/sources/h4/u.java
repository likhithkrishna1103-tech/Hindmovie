package h4;

import a3.i0;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y1.t f5783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a3.a0 f5784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5787e;
    public i0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5789h = 0;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5793m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f5794n;

    public u(int i, String str, String str2) {
        y1.t tVar = new y1.t(4);
        this.f5783a = tVar;
        tVar.f14609a[0] = -1;
        this.f5784b = new a3.a0();
        this.f5794n = -9223372036854775807L;
        this.f5785c = str;
        this.f5786d = i;
        this.f5787e = str2;
    }

    @Override // h4.i
    public final void a() {
        this.f5789h = 0;
        this.i = 0;
        this.f5791k = false;
        this.f5794n = -9223372036854775807L;
    }

    @Override // h4.i
    public final void b(y1.t tVar) {
        y1.d.h(this.f);
        while (tVar.a() > 0) {
            int i = this.f5789h;
            y1.t tVar2 = this.f5783a;
            if (i == 0) {
                byte[] bArr = tVar.f14609a;
                int i10 = tVar.f14610b;
                int i11 = tVar.f14611c;
                while (true) {
                    if (i10 >= i11) {
                        tVar.J(i11);
                        break;
                    }
                    byte b8 = bArr[i10];
                    boolean z10 = (b8 & 255) == 255;
                    boolean z11 = this.f5791k && (b8 & 224) == 224;
                    this.f5791k = z10;
                    if (z11) {
                        tVar.J(i10 + 1);
                        this.f5791k = false;
                        tVar2.f14609a[1] = bArr[i10];
                        this.i = 2;
                        this.f5789h = 1;
                        break;
                    }
                    i10++;
                }
            } else if (i == 1) {
                int iMin = Math.min(tVar.a(), 4 - this.i);
                tVar.h(tVar2.f14609a, this.i, iMin);
                int i12 = this.i + iMin;
                this.i = i12;
                if (i12 >= 4) {
                    tVar2.J(0);
                    int iJ = tVar2.j();
                    a3.a0 a0Var = this.f5784b;
                    if (a0Var.a(iJ)) {
                        this.f5793m = a0Var.f118b;
                        if (!this.f5790j) {
                            this.f5792l = (((long) a0Var.f) * 1000000) / ((long) a0Var.f119c);
                            v1.o oVar = new v1.o();
                            oVar.f12883a = this.f5788g;
                            oVar.f12892l = m0.p(this.f5787e);
                            oVar.f12893m = m0.p((String) a0Var.f122g);
                            oVar.f12894n = 4096;
                            oVar.E = a0Var.f120d;
                            oVar.F = a0Var.f119c;
                            oVar.f12886d = this.f5785c;
                            oVar.f = this.f5786d;
                            this.f.f(new v1.p(oVar));
                            this.f5790j = true;
                        }
                        tVar2.J(0);
                        this.f.a(4, tVar2);
                        this.f5789h = 2;
                    } else {
                        this.i = 0;
                        this.f5789h = 1;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iMin2 = Math.min(tVar.a(), this.f5793m - this.i);
                this.f.a(iMin2, tVar);
                int i13 = this.i + iMin2;
                this.i = i13;
                if (i13 >= this.f5793m) {
                    y1.d.g(this.f5794n != -9223372036854775807L);
                    this.f.e(this.f5794n, 1, this.f5793m, 0, null);
                    this.f5794n += this.f5792l;
                    this.i = 0;
                    this.f5789h = 0;
                }
            }
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5794n = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5788g = g0Var.f5646e;
        g0Var.b();
        this.f = rVar.p(g0Var.f5645d, 1);
    }

    @Override // h4.i
    public final void c(boolean z10) {
    }
}
