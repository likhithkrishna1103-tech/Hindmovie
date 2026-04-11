package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends p1.f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p1.g0 f9248e;

    public x(p1.g0 g0Var) {
        this.f9248e = g0Var;
    }

    @Override // p1.f1
    public final int b(Object obj) {
        return obj == w.f9241h ? 0 : -1;
    }

    @Override // p1.f1
    public final p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        c1Var.h(z2 ? 0 : null, z2 ? w.f9241h : null, 0, -9223372036854775807L, 0L, p1.b.f9644c, true);
        return c1Var;
    }

    @Override // p1.f1
    public final int h() {
        return 1;
    }

    @Override // p1.f1
    public final Object l(int i) {
        return w.f9241h;
    }

    @Override // p1.f1
    public final p1.e1 m(int i, p1.e1 e1Var, long j5) {
        e1Var.b(p1.e1.f9703q, this.f9248e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
        e1Var.f9721k = true;
        return e1Var;
    }

    @Override // p1.f1
    public final int o() {
        return 1;
    }
}
