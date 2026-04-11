package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m1 extends l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f11276k;

    public m1(a aVar) {
        this.f11276k = aVar;
    }

    public abstract void A(v1.f1 f1Var);

    public final void B() {
        y(null, this.f11276k);
    }

    public void C() {
        B();
    }

    @Override // s2.a
    public final v1.f1 h() {
        return this.f11276k.h();
    }

    @Override // s2.a
    public final v1.g0 i() {
        return this.f11276k.i();
    }

    @Override // s2.a
    public final boolean j() {
        return this.f11276k.j();
    }

    @Override // s2.a
    public final void m(b2.h0 h0Var) {
        this.f11257j = h0Var;
        this.i = y1.a0.n(null);
        C();
    }

    @Override // s2.a
    public void t(v1.g0 g0Var) {
        this.f11276k.t(g0Var);
    }

    @Override // s2.l
    public final c0 u(Object obj, c0 c0Var) {
        return z(c0Var);
    }

    @Override // s2.l
    public final long v(long j4, Object obj) {
        return j4;
    }

    @Override // s2.l
    public final int w(int i, Object obj) {
        return i;
    }

    @Override // s2.l
    public final void x(Object obj, a aVar, v1.f1 f1Var) {
        A(f1Var);
    }

    public c0 z(c0 c0Var) {
        return c0Var;
    }
}
