package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o1 extends l {
    public final a E;

    public o1(a aVar) {
        this.E = aVar;
    }

    @Override // o2.l
    public final int A(int i, Object obj) {
        return i;
    }

    @Override // o2.l
    public final void B(Object obj, a aVar, p1.f1 f1Var) {
        E(f1Var);
    }

    public abstract void E(p1.f1 f1Var);

    public final void F() {
        C(null, this.E);
    }

    public void G() {
        F();
    }

    @Override // o2.a
    public final p1.f1 i() {
        return this.E.i();
    }

    @Override // o2.a
    public final p1.g0 j() {
        return this.E.j();
    }

    @Override // o2.a
    public final boolean l() {
        return this.E.l();
    }

    @Override // o2.a
    public final void p(v1.e0 e0Var) {
        this.D = e0Var;
        this.C = s1.b0.n(null);
        G();
    }

    @Override // o2.a
    public void x(p1.g0 g0Var) {
        this.E.x(g0Var);
    }

    @Override // o2.l
    public final d0 y(Object obj, d0 d0Var) {
        return D(d0Var);
    }

    @Override // o2.l
    public final long z(long j5, Object obj) {
        return j5;
    }

    public d0 D(d0 d0Var) {
        return d0Var;
    }
}
