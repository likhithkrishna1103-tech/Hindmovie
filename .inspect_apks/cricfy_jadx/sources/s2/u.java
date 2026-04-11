package s2;

import g2.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements a0, z {
    public z A;
    public long B = -9223372036854775807L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c0 f11327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final w2.e f11329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f11330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a0 f11331z;

    public u(c0 c0Var, w2.e eVar, long j4) {
        this.f11327v = c0Var;
        this.f11329x = eVar;
        this.f11328w = j4;
    }

    @Override // s2.c1
    public final boolean a() {
        a0 a0Var = this.f11331z;
        return a0Var != null && a0Var.a();
    }

    public final void b(c0 c0Var) {
        long j4 = this.B;
        if (j4 == -9223372036854775807L) {
            j4 = this.f11328w;
        }
        a aVar = this.f11330y;
        aVar.getClass();
        a0 a0VarC = aVar.c(c0Var, this.f11329x, j4);
        this.f11331z = a0VarC;
        if (this.A != null) {
            a0VarC.d(this, j4);
        }
    }

    @Override // s2.a0
    public final void d(z zVar, long j4) {
        this.A = zVar;
        a0 a0Var = this.f11331z;
        if (a0Var != null) {
            long j7 = this.B;
            if (j7 == -9223372036854775807L) {
                j7 = this.f11328w;
            }
            a0Var.d(this, j7);
        }
    }

    @Override // s2.b1
    public final void f(c1 c1Var) {
        z zVar = this.A;
        int i = y1.a0.f14551a;
        zVar.f(this);
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.h(j4, r1Var);
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        a0 a0Var = this.f11331z;
        return a0Var != null && a0Var.i(s0Var);
    }

    @Override // s2.c1
    public final long j() {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.j();
    }

    @Override // s2.z
    public final void k(a0 a0Var) {
        z zVar = this.A;
        int i = y1.a0.f14551a;
        zVar.k(this);
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        a0Var.l(z10, j4);
    }

    @Override // s2.a0
    public final long m() {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.m();
    }

    @Override // s2.a0
    public final l1 o() {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.o();
    }

    @Override // s2.c1
    public final long q() {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.q();
    }

    @Override // s2.a0
    public final void r() {
        a0 a0Var = this.f11331z;
        if (a0Var != null) {
            a0Var.r();
            return;
        }
        a aVar = this.f11330y;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // s2.a0
    public final long t(long j4) {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.t(j4);
    }

    @Override // s2.c1
    public final void u(long j4) {
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        a0Var.u(j4);
    }

    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        long j7 = this.B;
        long j10 = (j7 == -9223372036854775807L || j4 != this.f11328w) ? j4 : j7;
        this.B = -9223372036854775807L;
        a0 a0Var = this.f11331z;
        int i = y1.a0.f14551a;
        return a0Var.v(qVarArr, zArr, a1VarArr, zArr2, j10);
    }
}
