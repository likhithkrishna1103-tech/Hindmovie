package s2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements v2.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v2.q f11241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.g1 f11242b;

    public j0(v2.q qVar, v1.g1 g1Var) {
        this.f11241a = qVar;
        this.f11242b = g1Var;
    }

    @Override // v2.q
    public final void a(boolean z10) {
        this.f11241a.a(z10);
    }

    @Override // v2.q
    public final boolean b(int i, long j4) {
        return this.f11241a.b(i, j4);
    }

    @Override // v2.q
    public final v1.p c(int i) {
        return this.f11242b.f12705d[this.f11241a.e(i)];
    }

    @Override // v2.q
    public final void d() {
        this.f11241a.d();
    }

    @Override // v2.q
    public final int e(int i) {
        return this.f11241a.e(i);
    }

    public final boolean equals(Object obj) {
        if (v(obj) && (obj instanceof j0)) {
            return this.f11242b.equals(((j0) obj).f11242b);
        }
        return false;
    }

    @Override // v2.q
    public final int f(long j4, List list) {
        return this.f11241a.f(j4, list);
    }

    @Override // v2.q
    public final void g() {
        this.f11241a.g();
    }

    @Override // v2.q
    public final int h() {
        return this.f11241a.h();
    }

    public final int hashCode() {
        return this.f11242b.hashCode() + (this.f11241a.hashCode() * 31);
    }

    @Override // v2.q
    public final v1.g1 i() {
        return this.f11242b;
    }

    @Override // v2.q
    public final v1.p j() {
        return this.f11242b.f12705d[this.f11241a.h()];
    }

    @Override // v2.q
    public final int k() {
        return this.f11241a.k();
    }

    @Override // v2.q
    public final int l() {
        return this.f11241a.l();
    }

    @Override // v2.q
    public final int length() {
        return this.f11241a.length();
    }

    @Override // v2.q
    public final boolean m(int i, long j4) {
        return this.f11241a.m(i, j4);
    }

    @Override // v2.q
    public final int n(v1.p pVar) {
        return this.f11241a.u(this.f11242b.a(pVar));
    }

    @Override // v2.q
    public final void o(float f) {
        this.f11241a.o(f);
    }

    @Override // v2.q
    public final Object p() {
        return this.f11241a.p();
    }

    @Override // v2.q
    public final void q() {
        this.f11241a.q();
    }

    @Override // v2.q
    public final void r(long j4, long j7, long j10, List list, t2.l[] lVarArr) {
        this.f11241a.r(j4, j7, j10, list, lVarArr);
    }

    @Override // v2.q
    public final void s() {
        this.f11241a.s();
    }

    @Override // v2.q
    public final boolean t(long j4, t2.e eVar, List list) {
        return this.f11241a.t(j4, eVar, list);
    }

    @Override // v2.q
    public final int u(int i) {
        return this.f11241a.u(i);
    }

    public final boolean v(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return this.f11241a.equals(((j0) obj).f11241a);
        }
        return false;
    }
}
