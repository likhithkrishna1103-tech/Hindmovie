package g4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends p1.f1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f5090k = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p1.g0 f5091e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5093h;
    public final p1.b0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f5094j;

    public i1(j1 j1Var) {
        this.f5091e = j1Var.F();
        this.f = j1Var.D();
        this.f5092g = j1Var.r0();
        this.f5093h = !j1Var.w0().p() && j1Var.w0().m(j1Var.d0(), new p1.e1(), 0L).f9721k;
        this.i = j1Var.W0() ? p1.b0.f : null;
        this.f5094j = s1.b0.O(j1Var.Q());
    }

    @Override // p1.f1
    public final int b(Object obj) {
        return f5090k.equals(obj) ? 0 : -1;
    }

    @Override // p1.f1
    public final p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        c1Var.getClass();
        p1.b bVar = p1.b.f9644c;
        Object obj = f5090k;
        c1Var.h(obj, obj, 0, this.f5094j, 0L, bVar, false);
        c1Var.f = this.f5093h;
        return c1Var;
    }

    @Override // p1.f1
    public final int h() {
        return 1;
    }

    @Override // p1.f1
    public final Object l(int i) {
        return f5090k;
    }

    @Override // p1.f1
    public final p1.e1 m(int i, p1.e1 e1Var, long j5) {
        e1Var.b(f5090k, this.f5091e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f, this.f5092g, this.i, 0L, this.f5094j, 0, 0, 0L);
        e1Var.f9721k = this.f5093h;
        return e1Var;
    }

    @Override // p1.f1
    public final int o() {
        return 1;
    }
}
