package d4;

import java.util.concurrent.atomic.AtomicInteger;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1.u f3862a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3865d;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w2.h0 f3867g;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p1.q f3871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3873n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3868h = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f3876q = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f3863b = new AtomicInteger();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3874o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3875p = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3866e = "video/mp2t";

    public g(int i, int i10, String str) {
        this.f3862a = new s1.u(new byte[i10]);
        this.f3864c = str;
        this.f3865d = i;
    }

    @Override // d4.i
    public final void a() {
        this.f3868h = 0;
        this.i = 0;
        this.f3869j = 0;
        this.f3876q = -9223372036854775807L;
        this.f3863b.set(0);
    }

    public final boolean b(s1.u uVar, byte[] bArr, int i) {
        int iMin = Math.min(uVar.a(), i - this.i);
        uVar.h(bArr, this.i, iMin);
        int i10 = this.i + iMin;
        this.i = i10;
        return i10 == i;
    }

    public final void c(w2.a aVar) {
        int i = aVar.f13567b;
        String str = aVar.f13566a;
        int i10 = aVar.f13568c;
        if (i == -2147483647 || i10 == -1) {
            return;
        }
        p1.q qVar = this.f3871l;
        if (qVar != null && i10 == qVar.F && i == qVar.G && str.equals(qVar.f10023n)) {
            return;
        }
        p1.q qVar2 = this.f3871l;
        p1.p pVar = qVar2 == null ? new p1.p() : qVar2.a();
        pVar.f9957a = this.f;
        pVar.f9966l = m0.p(this.f3866e);
        pVar.f9967m = m0.p(str);
        pVar.E = i10;
        pVar.F = i;
        pVar.f9960d = this.f3864c;
        pVar.f = this.f3865d;
        p1.q qVar3 = new p1.q(pVar);
        this.f3871l = qVar3;
        this.f3867g.d(qVar3);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04bb  */
    @Override // d4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s1.u r40) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 1416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.g.d(s1.u):void");
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f3876q = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f = h0Var.f3889e;
        h0Var.b();
        this.f3867g = qVar.q(h0Var.f3888d, 1);
    }

    @Override // d4.i
    public final void e(boolean z2) {
    }
}
