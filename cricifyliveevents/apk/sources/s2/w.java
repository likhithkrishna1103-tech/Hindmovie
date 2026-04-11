package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends v1.f1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v1.g0 f11350e;

    public w(v1.g0 g0Var) {
        this.f11350e = g0Var;
    }

    @Override // v1.f1
    public final int b(Object obj) {
        return obj == v.f11337h ? 0 : -1;
    }

    @Override // v1.f1
    public final v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        c1Var.h(z10 ? 0 : null, z10 ? v.f11337h : null, 0, -9223372036854775807L, 0L, v1.b.f12580c, true);
        return c1Var;
    }

    @Override // v1.f1
    public final int h() {
        return 1;
    }

    @Override // v1.f1
    public final Object l(int i) {
        return v.f11337h;
    }

    @Override // v1.f1
    public final v1.e1 m(int i, v1.e1 e1Var, long j4) {
        e1Var.b(v1.e1.f12633q, this.f11350e, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
        e1Var.f12651k = true;
        return e1Var;
    }

    @Override // v1.f1
    public final int o() {
        return 1;
    }
}
