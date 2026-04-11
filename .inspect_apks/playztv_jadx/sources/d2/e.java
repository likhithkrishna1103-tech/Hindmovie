package d2;

import p1.b0;
import p1.c1;
import p1.f1;
import p1.g0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3709e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3711h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f3712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f3713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e2.c f3714l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g0 f3715m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b0 f3716n;

    public e(long j5, long j8, long j10, int i, long j11, long j12, long j13, e2.c cVar, g0 g0Var, b0 b0Var) {
        s1.d.g(cVar.f4302d == (b0Var != null));
        this.f3709e = j5;
        this.f = j8;
        this.f3710g = j10;
        this.f3711h = i;
        this.i = j11;
        this.f3712j = j12;
        this.f3713k = j13;
        this.f3714l = cVar;
        this.f3715m = g0Var;
        this.f3716n = b0Var;
    }

    @Override // p1.f1
    public final int b(Object obj) {
        int iIntValue;
        if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.f3711h) >= 0 && iIntValue < h()) {
            return iIntValue;
        }
        return -1;
    }

    @Override // p1.f1
    public final c1 f(int i, c1 c1Var, boolean z2) {
        s1.d.c(i, h());
        e2.c cVar = this.f3714l;
        String str = z2 ? cVar.b(i).f4328a : null;
        Integer numValueOf = z2 ? Integer.valueOf(this.f3711h + i) : null;
        long jD = cVar.d(i);
        long jO = s1.b0.O(cVar.b(i).f4329b - cVar.b(0).f4329b) - this.i;
        c1Var.getClass();
        c1Var.h(str, numValueOf, 0, jD, jO, p1.b.f9644c, false);
        return c1Var;
    }

    @Override // p1.f1
    public final int h() {
        return this.f3714l.f4309m.size();
    }

    @Override // p1.f1
    public final Object l(int i) {
        s1.d.c(i, h());
        return Integer.valueOf(this.f3711h + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8  */
    @Override // p1.f1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p1.e1 m(int r24, p1.e1 r25, long r26) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.e.m(int, p1.e1, long):p1.e1");
    }

    @Override // p1.f1
    public final int o() {
        return 1;
    }
}
