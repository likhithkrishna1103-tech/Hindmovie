package o2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements r2.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r2.r f9157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.g1 f9158b;

    public l0(r2.r rVar, p1.g1 g1Var) {
        this.f9157a = rVar;
        this.f9158b = g1Var;
    }

    @Override // r2.r
    public final void a(boolean z2) {
        this.f9157a.a(z2);
    }

    @Override // r2.r
    public final boolean b(int i, long j5) {
        return this.f9157a.b(i, j5);
    }

    @Override // r2.r
    public final p1.q c(int i) {
        return this.f9158b.f9765d[this.f9157a.e(i)];
    }

    @Override // r2.r
    public final void d() {
        this.f9157a.d();
    }

    @Override // r2.r
    public final int e(int i) {
        return this.f9157a.e(i);
    }

    public final boolean equals(Object obj) {
        if (v(obj) && (obj instanceof l0)) {
            return this.f9158b.equals(((l0) obj).f9158b);
        }
        return false;
    }

    @Override // r2.r
    public final int f(long j5, List list) {
        return this.f9157a.f(j5, list);
    }

    @Override // r2.r
    public final int g(p1.q qVar) {
        return this.f9157a.u(this.f9158b.a(qVar));
    }

    @Override // r2.r
    public final void h() {
        this.f9157a.h();
    }

    public final int hashCode() {
        return this.f9158b.hashCode() + (this.f9157a.hashCode() * 31);
    }

    @Override // r2.r
    public final boolean i(long j5, p2.f fVar, List list) {
        return this.f9157a.i(j5, fVar, list);
    }

    @Override // r2.r
    public final int j() {
        return this.f9157a.j();
    }

    @Override // r2.r
    public final p1.g1 k() {
        return this.f9158b;
    }

    @Override // r2.r
    public final p1.q l() {
        return this.f9158b.f9765d[this.f9157a.j()];
    }

    @Override // r2.r
    public final int length() {
        return this.f9157a.length();
    }

    @Override // r2.r
    public final int m() {
        return this.f9157a.m();
    }

    @Override // r2.r
    public final int n() {
        return this.f9157a.n();
    }

    @Override // r2.r
    public final boolean o(int i, long j5) {
        return this.f9157a.o(i, j5);
    }

    @Override // r2.r
    public final void p(float f) {
        this.f9157a.p(f);
    }

    @Override // r2.r
    public final Object q() {
        return this.f9157a.q();
    }

    @Override // r2.r
    public final void r() {
        this.f9157a.r();
    }

    @Override // r2.r
    public final void s(long j5, long j8, long j10, List list, p2.n[] nVarArr) {
        this.f9157a.s(j5, j8, j10, list, nVarArr);
    }

    @Override // r2.r
    public final void t() {
        this.f9157a.t();
    }

    @Override // r2.r
    public final int u(int i) {
        return this.f9157a.u(i);
    }

    public final boolean v(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            return this.f9157a.equals(((l0) obj).f9157a);
        }
        return false;
    }
}
