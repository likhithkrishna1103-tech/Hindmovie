package o2;

import a2.d2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements b0, a0 {
    public long A = -9223372036854775807L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d0 f9235u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f9236v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s2.e f9237w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f9238x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b0 f9239y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a0 f9240z;

    public v(d0 d0Var, s2.e eVar, long j5) {
        this.f9235u = d0Var;
        this.f9237w = eVar;
        this.f9236v = j5;
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.a(j5, d2Var);
    }

    public final void b(d0 d0Var) {
        long j5 = this.A;
        if (j5 == -9223372036854775807L) {
            j5 = this.f9236v;
        }
        a aVar = this.f9238x;
        aVar.getClass();
        b0 b0VarC = aVar.c(d0Var, this.f9237w, j5);
        this.f9239y = b0VarC;
        if (this.f9240z != null) {
            b0VarC.o(this, j5);
        }
    }

    @Override // o2.e1
    public final boolean c() {
        b0 b0Var = this.f9239y;
        return b0Var != null && b0Var.c();
    }

    @Override // o2.d1
    public final void d(e1 e1Var) {
        a0 a0Var = this.f9240z;
        int i = s1.b0.f11647a;
        a0Var.d(this);
    }

    @Override // o2.e1
    public final long g() {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.g();
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        b0Var.h(z2, j5);
    }

    @Override // o2.b0
    public final long i() {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.i();
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        b0 b0Var = this.f9239y;
        return b0Var != null && b0Var.l(c1Var);
    }

    @Override // o2.a0
    public final void m(b0 b0Var) {
        a0 a0Var = this.f9240z;
        int i = s1.b0.f11647a;
        a0Var.m(this);
    }

    @Override // o2.b0
    public final long n(r2.r[] rVarArr, boolean[] zArr, c1[] c1VarArr, boolean[] zArr2, long j5) {
        long j8 = this.A;
        long j10 = (j8 == -9223372036854775807L || j5 != this.f9236v) ? j5 : j8;
        this.A = -9223372036854775807L;
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.n(rVarArr, zArr, c1VarArr, zArr2, j10);
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.f9240z = a0Var;
        b0 b0Var = this.f9239y;
        if (b0Var != null) {
            long j8 = this.A;
            if (j8 == -9223372036854775807L) {
                j8 = this.f9236v;
            }
            b0Var.o(this, j8);
        }
    }

    @Override // o2.b0
    public final n1 p() {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.p();
    }

    @Override // o2.e1
    public final long r() {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.r();
    }

    @Override // o2.b0
    public final void s() {
        b0 b0Var = this.f9239y;
        if (b0Var != null) {
            b0Var.s();
            return;
        }
        a aVar = this.f9238x;
        if (aVar != null) {
            aVar.n();
        }
    }

    @Override // o2.b0
    public final long t(long j5) {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        return b0Var.t(j5);
    }

    @Override // o2.e1
    public final void v(long j5) {
        b0 b0Var = this.f9239y;
        int i = s1.b0.f11647a;
        b0Var.v(j5);
    }
}
