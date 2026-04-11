package h4;

import a3.i0;
import java.util.concurrent.atomic.AtomicInteger;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y1.t f5627a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5630d;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i0 f5632g;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5635k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public v1.p f5636l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5637m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5638n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5633h = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f5641q = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f5628b = new AtomicInteger();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5639o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5640p = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5631e = "video/mp2t";

    public g(int i, int i10, String str) {
        this.f5627a = new y1.t(new byte[i10]);
        this.f5629c = str;
        this.f5630d = i;
    }

    @Override // h4.i
    public final void a() {
        this.f5633h = 0;
        this.i = 0;
        this.f5634j = 0;
        this.f5641q = -9223372036854775807L;
        this.f5628b.set(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04bb  */
    @Override // h4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r40) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 1416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.g.b(y1.t):void");
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5641q = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f = g0Var.f5646e;
        g0Var.b();
        this.f5632g = rVar.p(g0Var.f5645d, 1);
    }

    public final boolean f(y1.t tVar, byte[] bArr, int i) {
        int iMin = Math.min(tVar.a(), i - this.i);
        tVar.h(bArr, this.i, iMin);
        int i10 = this.i + iMin;
        this.i = i10;
        return i10 == i;
    }

    public final void g(a3.a aVar) {
        int i = aVar.f115b;
        String str = aVar.f114a;
        int i10 = aVar.f116c;
        if (i == -2147483647 || i10 == -1) {
            return;
        }
        v1.p pVar = this.f5636l;
        if (pVar != null && i10 == pVar.F && i == pVar.G && str.equals(pVar.f12946n)) {
            return;
        }
        v1.p pVar2 = this.f5636l;
        v1.o oVar = pVar2 == null ? new v1.o() : pVar2.a();
        oVar.f12883a = this.f;
        oVar.f12892l = m0.p(this.f5631e);
        oVar.f12893m = m0.p(str);
        oVar.E = i10;
        oVar.F = i;
        oVar.f12886d = this.f5629c;
        oVar.f = this.f5630d;
        v1.p pVar3 = new v1.p(oVar);
        this.f5636l = pVar3;
        this.f5632g.f(pVar3);
    }

    @Override // h4.i
    public final void c(boolean z10) {
    }
}
