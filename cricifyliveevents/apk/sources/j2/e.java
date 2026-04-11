package j2;

import v1.a0;
import v1.c1;
import v1.f1;
import v1.g0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6529e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f6530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6531h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f6532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f6533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k2.c f6534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g0 f6535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a0 f6536n;

    public e(long j4, long j7, long j10, int i, long j11, long j12, long j13, k2.c cVar, g0 g0Var, a0 a0Var) {
        y1.d.g(cVar.f6834d == (a0Var != null));
        this.f6529e = j4;
        this.f = j7;
        this.f6530g = j10;
        this.f6531h = i;
        this.i = j11;
        this.f6532j = j12;
        this.f6533k = j13;
        this.f6534l = cVar;
        this.f6535m = g0Var;
        this.f6536n = a0Var;
    }

    @Override // v1.f1
    public final int b(Object obj) {
        int iIntValue;
        if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.f6531h) >= 0 && iIntValue < h()) {
            return iIntValue;
        }
        return -1;
    }

    @Override // v1.f1
    public final c1 f(int i, c1 c1Var, boolean z10) {
        y1.d.c(i, h());
        k2.c cVar = this.f6534l;
        String str = z10 ? cVar.b(i).f6859a : null;
        Integer numValueOf = z10 ? Integer.valueOf(this.f6531h + i) : null;
        long jD = cVar.d(i);
        long jO = y1.a0.O(cVar.b(i).f6860b - cVar.b(0).f6860b) - this.i;
        c1Var.getClass();
        c1Var.h(str, numValueOf, 0, jD, jO, v1.b.f12580c, false);
        return c1Var;
    }

    @Override // v1.f1
    public final int h() {
        return this.f6534l.f6841m.size();
    }

    @Override // v1.f1
    public final Object l(int i) {
        y1.d.c(i, h());
        return Integer.valueOf(this.f6531h + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8  */
    @Override // v1.f1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v1.e1 m(int r24, v1.e1 r25, long r26) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.e.m(int, v1.e1, long):v1.e1");
    }

    @Override // v1.f1
    public final int o() {
        return 1;
    }
}
