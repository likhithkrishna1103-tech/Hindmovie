package k4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends v1.f1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f7007k = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v1.g0 f7008e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7010h;
    public final v1.a0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f7011j;

    public g1(h1 h1Var) {
        this.f7008e = h1Var.z();
        this.f = h1Var.x();
        this.f7009g = h1Var.q0();
        this.f7010h = !h1Var.v0().p() && h1Var.v0().m(h1Var.Y(), new v1.e1(), 0L).f12651k;
        this.i = h1Var.X0() ? v1.a0.f : null;
        this.f7011j = y1.a0.O(h1Var.N());
    }

    @Override // v1.f1
    public final int b(Object obj) {
        return f7007k.equals(obj) ? 0 : -1;
    }

    @Override // v1.f1
    public final v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        c1Var.getClass();
        v1.b bVar = v1.b.f12580c;
        Object obj = f7007k;
        c1Var.h(obj, obj, 0, this.f7011j, 0L, bVar, false);
        c1Var.f = this.f7010h;
        return c1Var;
    }

    @Override // v1.f1
    public final int h() {
        return 1;
    }

    @Override // v1.f1
    public final Object l(int i) {
        return f7007k;
    }

    @Override // v1.f1
    public final v1.e1 m(int i, v1.e1 e1Var, long j4) {
        e1Var.b(f7007k, this.f7008e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f, this.f7009g, this.i, 0L, this.f7011j, 0, 0, 0L);
        e1Var.f12651k = this.f7010h;
        return e1Var;
    }

    @Override // v1.f1
    public final int o() {
        return 1;
    }
}
