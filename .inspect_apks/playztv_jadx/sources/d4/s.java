package d4;

import a2.u0;
import java.util.Collections;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f3988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w2.h0 f3990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f3991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3992e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3997l;
    public final boolean[] f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u0 f3993g = new u0(32);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u0 f3994h = new u0(33);
    public final u0 i = new u0(34);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u0 f3995j = new u0(39);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u0 f3996k = new u0(40);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3998m = -9223372036854775807L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s1.u f3999n = new s1.u();

    public s(d0 d0Var) {
        this.f3988a = d0Var;
    }

    @Override // d4.i
    public final void a() {
        this.f3997l = 0L;
        this.f3998m = -9223372036854775807L;
        t1.p.a(this.f);
        this.f3993g.g();
        this.f3994h.g();
        this.i.g();
        this.f3995j.g();
        this.f3996k.g();
        this.f3988a.f3813d.i(0);
        r rVar = this.f3991d;
        if (rVar != null) {
            rVar.f = false;
            rVar.f3982g = false;
            rVar.f3983h = false;
            rVar.i = false;
            rVar.f3984j = false;
        }
    }

    public final void b(int i, int i10, long j5, long j8) {
        n.p pVar = this.f3988a.f3813d;
        r rVar = this.f3991d;
        boolean z2 = this.f3992e;
        if (rVar.f3984j && rVar.f3982g) {
            rVar.f3987m = rVar.f3979c;
            rVar.f3984j = false;
        } else if (rVar.f3983h || rVar.f3982g) {
            if (z2 && rVar.i) {
                rVar.a(i + ((int) (j5 - rVar.f3978b)));
            }
            rVar.f3985k = rVar.f3978b;
            rVar.f3986l = rVar.f3981e;
            rVar.f3987m = rVar.f3979c;
            rVar.i = true;
        }
        if (!this.f3992e) {
            u0 u0Var = this.f3993g;
            u0Var.e(i10);
            u0 u0Var2 = this.f3994h;
            u0Var2.e(i10);
            u0 u0Var3 = this.i;
            u0Var3.e(i10);
            if (u0Var.f445d && u0Var2.f445d && u0Var3.f445d) {
                String str = this.f3989b;
                int i11 = u0Var.f446e;
                byte[] bArr = new byte[u0Var2.f446e + i11 + u0Var3.f446e];
                System.arraycopy((byte[]) u0Var.f, 0, bArr, 0, i11);
                System.arraycopy((byte[]) u0Var2.f, 0, bArr, u0Var.f446e, u0Var2.f446e);
                System.arraycopy((byte[]) u0Var3.f, 0, bArr, u0Var.f446e + u0Var2.f446e, u0Var3.f446e);
                t1.l lVarH = t1.p.h((byte[]) u0Var2.f, 3, u0Var2.f446e, null);
                t1.i iVar = lVarH.f12025b;
                String strA = iVar != null ? s1.e.a(iVar.f12012a, iVar.f12013b, iVar.f12014c, iVar.f12015d, iVar.f12016e, iVar.f) : null;
                p1.p pVar2 = new p1.p();
                pVar2.f9957a = str;
                pVar2.f9966l = m0.p("video/mp2t");
                pVar2.f9967m = m0.p("video/hevc");
                pVar2.f9964j = strA;
                pVar2.f9974t = lVarH.f12028e;
                pVar2.f9975u = lVarH.f;
                pVar2.f9976v = lVarH.f12029g;
                pVar2.f9977w = lVarH.f12030h;
                pVar2.C = new p1.h(lVarH.f12032k, lVarH.f12033l, lVarH.f12034m, null, lVarH.f12026c + 8, lVarH.f12027d + 8);
                pVar2.f9980z = lVarH.i;
                pVar2.f9969o = lVarH.f12031j;
                pVar2.D = lVarH.f12024a + 1;
                pVar2.f9970p = Collections.singletonList(bArr);
                p1.q qVar = new p1.q(pVar2);
                this.f3990c.d(qVar);
                int i12 = qVar.f10025p;
                if (i12 == -1) {
                    throw new IllegalStateException();
                }
                pVar.x(i12);
                this.f3992e = true;
            }
        }
        u0 u0Var4 = this.f3995j;
        boolean zE = u0Var4.e(i10);
        s1.u uVar = this.f3999n;
        if (zE) {
            uVar.H(t1.p.m(u0Var4.f446e, (byte[]) u0Var4.f), (byte[]) u0Var4.f);
            uVar.K(5);
            pVar.a(j8, uVar);
        }
        u0 u0Var5 = this.f3996k;
        if (u0Var5.e(i10)) {
            uVar.H(t1.p.m(u0Var5.f446e, (byte[]) u0Var5.f), (byte[]) u0Var5.f);
            uVar.K(5);
            pVar.a(j8, uVar);
        }
    }

    public final void c(byte[] bArr, int i, int i10) {
        r rVar = this.f3991d;
        if (rVar.f) {
            int i11 = rVar.f3980d;
            int i12 = (i + 2) - i11;
            if (i12 < i10) {
                rVar.f3982g = (bArr[i12] & 128) != 0;
                rVar.f = false;
            } else {
                rVar.f3980d = (i10 - i) + i11;
            }
        }
        if (!this.f3992e) {
            this.f3993g.a(bArr, i, i10);
            this.f3994h.a(bArr, i, i10);
            this.i.a(bArr, i, i10);
        }
        this.f3995j.a(bArr, i, i10);
        this.f3996k.a(bArr, i, i10);
    }

    @Override // d4.i
    public final void d(s1.u uVar) {
        int i;
        s1.d.h(this.f3990c);
        int i10 = s1.b0.f11647a;
        while (uVar.a() > 0) {
            int i11 = uVar.f11710b;
            int i12 = uVar.f11711c;
            byte[] bArr = uVar.f11709a;
            this.f3997l += (long) uVar.a();
            this.f3990c.f(uVar.a(), uVar);
            while (i11 < i12) {
                int iB = t1.p.b(bArr, i11, i12, this.f);
                if (iB == i12) {
                    c(bArr, i11, i12);
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
                    c(bArr, i11, i14);
                }
                int i17 = i12 - i14;
                long j5 = this.f3997l - ((long) i17);
                b(i17, i16 < 0 ? -i16 : 0, j5, this.f3998m);
                h(i17, i13, j5, this.f3998m);
                i11 = i14 + i15;
            }
        }
    }

    @Override // d4.i
    public final void e(boolean z2) {
        s1.d.h(this.f3990c);
        int i = s1.b0.f11647a;
        if (z2) {
            this.f3988a.f3813d.i(0);
            b(0, 0, this.f3997l, this.f3998m);
            h(0, 48, this.f3997l, this.f3998m);
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f3998m = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f3989b = h0Var.f3889e;
        h0Var.b();
        w2.h0 h0VarQ = qVar.q(h0Var.f3888d, 2);
        this.f3990c = h0VarQ;
        this.f3991d = new r(h0VarQ);
        this.f3988a.b(qVar, h0Var);
    }

    public final void h(int i, int i10, long j5, long j8) {
        r rVar = this.f3991d;
        boolean z2 = this.f3992e;
        rVar.f3982g = false;
        rVar.f3983h = false;
        rVar.f3981e = j8;
        rVar.f3980d = 0;
        rVar.f3978b = j5;
        if (i10 >= 32 && i10 != 40) {
            if (rVar.i && !rVar.f3984j) {
                if (z2) {
                    rVar.a(i);
                }
                rVar.i = false;
            }
            if ((32 <= i10 && i10 <= 35) || i10 == 39) {
                rVar.f3983h = !rVar.f3984j;
                rVar.f3984j = true;
            }
        }
        boolean z10 = i10 >= 16 && i10 <= 21;
        rVar.f3979c = z10;
        rVar.f = z10 || i10 <= 9;
        if (!this.f3992e) {
            this.f3993g.h(i10);
            this.f3994h.h(i10);
            this.i.h(i10);
        }
        this.f3995j.h(i10);
        this.f3996k.h(i10);
    }
}
