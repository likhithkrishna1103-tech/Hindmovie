package a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ag.o f258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ag.o f259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f260c;

    public z(long j4, long[] jArr, long[] jArr2) {
        y1.d.b(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.f258a = new ag.o(length);
            this.f259b = new ag.o(length);
        } else {
            int i = length + 1;
            ag.o oVar = new ag.o(i);
            this.f258a = oVar;
            ag.o oVar2 = new ag.o(i);
            this.f259b = oVar2;
            oVar.a(0L);
            oVar2.a(0L);
        }
        this.f258a.b(jArr);
        this.f259b.b(jArr2);
        this.f260c = j4;
    }

    @Override // a3.c0
    public final boolean g() {
        return this.f259b.f454w > 0;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        ag.o oVar = this.f259b;
        if (oVar.f454w == 0) {
            d0 d0Var = d0.f157c;
            return new b0(d0Var, d0Var);
        }
        int iB = y1.a0.b(oVar, j4);
        long jG = oVar.g(iB);
        ag.o oVar2 = this.f258a;
        d0 d0Var2 = new d0(jG, oVar2.g(iB));
        if (jG == j4 || iB == oVar.f454w - 1) {
            return new b0(d0Var2, d0Var2);
        }
        int i = iB + 1;
        return new b0(d0Var2, new d0(oVar.g(i), oVar2.g(i)));
    }

    @Override // a3.c0
    public final long l() {
        return this.f260c;
    }
}
