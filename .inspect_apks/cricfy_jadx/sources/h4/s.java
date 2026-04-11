package h4;

import a3.i0;
import g2.l0;
import java.util.Collections;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f5751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f5753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f5754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5755e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5760l;
    public final boolean[] f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l0 f5756g = new l0(32);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l0 f5757h = new l0(33);
    public final l0 i = new l0(34);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l0 f5758j = new l0(39);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l0 f5759k = new l0(40);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5761m = -9223372036854775807L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final y1.t f5762n = new y1.t();

    public s(d0 d0Var) {
        this.f5751a = d0Var;
    }

    @Override // h4.i
    public final void a() {
        this.f5760l = 0L;
        this.f5761m = -9223372036854775807L;
        z1.o.a(this.f);
        this.f5756g.g();
        this.f5757h.g();
        this.i.g();
        this.f5758j.g();
        this.f5759k.g();
        this.f5751a.f5582d.v(0);
        r rVar = this.f5754d;
        if (rVar != null) {
            rVar.f = false;
            rVar.f5745g = false;
            rVar.f5746h = false;
            rVar.i = false;
            rVar.f5747j = false;
        }
    }

    @Override // h4.i
    public final void b(y1.t tVar) {
        int i;
        y1.d.h(this.f5753c);
        int i10 = y1.a0.f14551a;
        while (tVar.a() > 0) {
            int i11 = tVar.f14610b;
            int i12 = tVar.f14611c;
            byte[] bArr = tVar.f14609a;
            this.f5760l += (long) tVar.a();
            this.f5753c.a(tVar.a(), tVar);
            while (i11 < i12) {
                int iB = z1.o.b(bArr, i11, i12, this.f);
                if (iB == i12) {
                    g(bArr, i11, i12);
                    return;
                }
                int i13 = (bArr[iB + 3] & 126) >> 1;
                if (iB <= 0 || bArr[iB - 1] != 0) {
                    i = 3;
                } else {
                    iB--;
                    i = 4;
                }
                int i14 = iB;
                int i15 = i;
                int i16 = i14 - i11;
                if (i16 > 0) {
                    g(bArr, i11, i14);
                }
                int i17 = i12 - i14;
                long j4 = this.f5760l - ((long) i17);
                f(i17, i16 < 0 ? -i16 : 0, j4, this.f5761m);
                h(i17, i13, j4, this.f5761m);
                i11 = i14 + i15;
            }
        }
    }

    @Override // h4.i
    public final void c(boolean z10) {
        y1.d.h(this.f5753c);
        int i = y1.a0.f14551a;
        if (z10) {
            this.f5751a.f5582d.v(0);
            f(0, 0, this.f5760l, this.f5761m);
            h(0, 48, this.f5760l, this.f5761m);
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5761m = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5752b = g0Var.f5646e;
        g0Var.b();
        i0 i0VarP = rVar.p(g0Var.f5645d, 2);
        this.f5753c = i0VarP;
        this.f5754d = new r(i0VarP);
        this.f5751a.b(rVar, g0Var);
    }

    public final void f(int i, int i10, long j4, long j7) {
        ff.k kVar = this.f5751a.f5582d;
        r rVar = this.f5754d;
        boolean z10 = this.f5755e;
        if (rVar.f5747j && rVar.f5745g) {
            rVar.f5750m = rVar.f5742c;
            rVar.f5747j = false;
        } else if (rVar.f5746h || rVar.f5745g) {
            if (z10 && rVar.i) {
                rVar.a(i + ((int) (j4 - rVar.f5741b)));
            }
            rVar.f5748k = rVar.f5741b;
            rVar.f5749l = rVar.f5744e;
            rVar.f5750m = rVar.f5742c;
            rVar.i = true;
        }
        if (!this.f5755e) {
            l0 l0Var = this.f5756g;
            l0Var.e(i10);
            l0 l0Var2 = this.f5757h;
            l0Var2.e(i10);
            l0 l0Var3 = this.i;
            l0Var3.e(i10);
            if (l0Var.f4795d && l0Var2.f4795d && l0Var3.f4795d) {
                String str = this.f5752b;
                int i11 = l0Var.f4796e;
                byte[] bArr = new byte[l0Var2.f4796e + i11 + l0Var3.f4796e];
                System.arraycopy((byte[]) l0Var.f, 0, bArr, 0, i11);
                System.arraycopy((byte[]) l0Var2.f, 0, bArr, l0Var.f4796e, l0Var2.f4796e);
                System.arraycopy((byte[]) l0Var3.f, 0, bArr, l0Var.f4796e + l0Var2.f4796e, l0Var3.f4796e);
                z1.k kVarH = z1.o.h((byte[]) l0Var2.f, 3, l0Var2.f4796e, null);
                z1.h hVar = kVarH.f15090b;
                String strA = hVar != null ? y1.e.a(hVar.f15077a, hVar.f15078b, hVar.f15079c, hVar.f15080d, hVar.f15081e, hVar.f) : null;
                v1.o oVar = new v1.o();
                oVar.f12883a = str;
                oVar.f12892l = m0.p("video/mp2t");
                oVar.f12893m = m0.p("video/hevc");
                oVar.f12890j = strA;
                oVar.f12900t = kVarH.f15093e;
                oVar.f12901u = kVarH.f;
                oVar.f12902v = kVarH.f15094g;
                oVar.f12903w = kVarH.f15095h;
                oVar.C = new v1.g(kVarH.f15097k, kVarH.f15098l, kVarH.f15099m, null, kVarH.f15091c + 8, kVarH.f15092d + 8);
                oVar.f12906z = kVarH.i;
                oVar.f12895o = kVarH.f15096j;
                oVar.D = kVarH.f15089a + 1;
                oVar.f12896p = Collections.singletonList(bArr);
                v1.p pVar = new v1.p(oVar);
                this.f5753c.f(pVar);
                int i12 = pVar.f12948p;
                if (i12 == -1) {
                    throw new IllegalStateException();
                }
                kVar.I(i12);
                this.f5755e = true;
            }
        }
        l0 l0Var4 = this.f5758j;
        boolean zE = l0Var4.e(i10);
        y1.t tVar = this.f5762n;
        if (zE) {
            tVar.H(z1.o.m(l0Var4.f4796e, (byte[]) l0Var4.f), (byte[]) l0Var4.f);
            tVar.K(5);
            kVar.a(j7, tVar);
        }
        l0 l0Var5 = this.f5759k;
        if (l0Var5.e(i10)) {
            tVar.H(z1.o.m(l0Var5.f4796e, (byte[]) l0Var5.f), (byte[]) l0Var5.f);
            tVar.K(5);
            kVar.a(j7, tVar);
        }
    }

    public final void g(byte[] bArr, int i, int i10) {
        r rVar = this.f5754d;
        if (rVar.f) {
            int i11 = rVar.f5743d;
            int i12 = (i + 2) - i11;
            if (i12 < i10) {
                rVar.f5745g = (bArr[i12] & 128) != 0;
                rVar.f = false;
            } else {
                rVar.f5743d = (i10 - i) + i11;
            }
        }
        if (!this.f5755e) {
            this.f5756g.a(bArr, i, i10);
            this.f5757h.a(bArr, i, i10);
            this.i.a(bArr, i, i10);
        }
        this.f5758j.a(bArr, i, i10);
        this.f5759k.a(bArr, i, i10);
    }

    public final void h(int i, int i10, long j4, long j7) {
        r rVar = this.f5754d;
        boolean z10 = this.f5755e;
        rVar.f5745g = false;
        rVar.f5746h = false;
        rVar.f5744e = j7;
        rVar.f5743d = 0;
        rVar.f5741b = j4;
        if (i10 >= 32 && i10 != 40) {
            if (rVar.i && !rVar.f5747j) {
                if (z10) {
                    rVar.a(i);
                }
                rVar.i = false;
            }
            if ((32 <= i10 && i10 <= 35) || i10 == 39) {
                rVar.f5746h = !rVar.f5747j;
                rVar.f5747j = true;
            }
        }
        boolean z11 = i10 >= 16 && i10 <= 21;
        rVar.f5742c = z11;
        rVar.f = z11 || i10 <= 9;
        if (!this.f5755e) {
            this.f5756g.h(i10);
            this.f5757h.h(i10);
            this.i.h(i10);
        }
        this.f5758j.h(i10);
        this.f5759k.h(i10);
    }
}
