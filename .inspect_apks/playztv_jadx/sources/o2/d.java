package o2;

import a2.d2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b0, a0 {
    public g A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b0 f9084u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a0 f9085v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c[] f9086w = new c[0];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f9087x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f9088y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f9089z;

    public d(b0 b0Var, boolean z2, long j5, long j8) {
        this.f9084u = b0Var;
        this.f9087x = z2 ? j5 : -9223372036854775807L;
        this.f9088y = j5;
        this.f9089z = j8;
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        long j8 = this.f9088y;
        if (j5 == j8) {
            return j8;
        }
        long j10 = s1.b0.j(d2Var.f187a, 0L, j5 - j8);
        long j11 = d2Var.f188b;
        long j12 = this.f9089z;
        long j13 = s1.b0.j(j11, 0L, j12 == Long.MIN_VALUE ? Long.MAX_VALUE : j12 - j5);
        if (j10 != d2Var.f187a || j13 != d2Var.f188b) {
            d2Var = new d2(j10, j13);
        }
        return this.f9084u.a(j5, d2Var);
    }

    public final boolean b() {
        return this.f9087x != -9223372036854775807L;
    }

    @Override // o2.e1
    public final boolean c() {
        return this.f9084u.c();
    }

    @Override // o2.d1
    public final void d(e1 e1Var) {
        a0 a0Var = this.f9085v;
        a0Var.getClass();
        a0Var.d(this);
    }

    @Override // o2.e1
    public final long g() {
        long jG = this.f9084u.g();
        if (jG != Long.MIN_VALUE) {
            long j5 = this.f9089z;
            if (j5 == Long.MIN_VALUE || jG < j5) {
                return jG;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        this.f9084u.h(z2, j5);
    }

    @Override // o2.b0
    public final long i() {
        if (b()) {
            long j5 = this.f9087x;
            this.f9087x = -9223372036854775807L;
            long jI = i();
            return jI != -9223372036854775807L ? jI : j5;
        }
        long jI2 = this.f9084u.i();
        if (jI2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j8 = this.f9088y;
        long j10 = this.f9089z;
        long jMax = Math.max(jI2, j8);
        return j10 != Long.MIN_VALUE ? Math.min(jMax, j10) : jMax;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        return this.f9084u.l(c1Var);
    }

    @Override // o2.a0
    public final void m(b0 b0Var) {
        if (this.A != null) {
            return;
        }
        a0 a0Var = this.f9085v;
        a0Var.getClass();
        a0Var.m(this);
    }

    @Override // o2.b0
    public final long n(r2.r[] rVarArr, boolean[] zArr, c1[] c1VarArr, boolean[] zArr2, long j5) {
        long j8;
        this.f9086w = new c[c1VarArr.length];
        c1[] c1VarArr2 = new c1[c1VarArr.length];
        for (int i = 0; i < c1VarArr.length; i++) {
            c[] cVarArr = this.f9086w;
            c cVar = (c) c1VarArr[i];
            cVarArr[i] = cVar;
            c1VarArr2[i] = cVar != null ? cVar.f9081u : null;
        }
        long jN = this.f9084u.n(rVarArr, zArr, c1VarArr2, zArr2, j5);
        long j10 = this.f9089z;
        long jMax = Math.max(jN, j5);
        if (j10 != Long.MIN_VALUE) {
            jMax = Math.min(jMax, j10);
        }
        if (b()) {
            if (jN >= j5) {
                if (jN != 0) {
                    for (r2.r rVar : rVarArr) {
                        if (rVar != null) {
                            p1.q qVarL = rVar.l();
                            if (!p1.m0.a(qVarL.f10023n, qVarL.f10020k)) {
                            }
                        }
                    }
                }
                j8 = -9223372036854775807L;
            }
            j8 = jMax;
            break;
        } else {
            j8 = -9223372036854775807L;
        }
        this.f9087x = j8;
        for (int i10 = 0; i10 < c1VarArr.length; i10++) {
            c1 c1Var = c1VarArr2[i10];
            if (c1Var == null) {
                this.f9086w[i10] = null;
            } else {
                c[] cVarArr2 = this.f9086w;
                c cVar2 = cVarArr2[i10];
                if (cVar2 == null || cVar2.f9081u != c1Var) {
                    cVarArr2[i10] = new c(this, c1Var);
                }
            }
            c1VarArr[i10] = this.f9086w[i10];
        }
        return jMax;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.f9085v = a0Var;
        this.f9084u.o(this, j5);
    }

    @Override // o2.b0
    public final n1 p() {
        return this.f9084u.p();
    }

    @Override // o2.e1
    public final long r() {
        long jR = this.f9084u.r();
        if (jR != Long.MIN_VALUE) {
            long j5 = this.f9089z;
            if (j5 == Long.MIN_VALUE || jR < j5) {
                return jR;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // o2.b0
    public final void s() throws g {
        g gVar = this.A;
        if (gVar != null) {
            throw gVar;
        }
        this.f9084u.s();
    }

    @Override // o2.b0
    public final long t(long j5) {
        this.f9087x = -9223372036854775807L;
        for (c cVar : this.f9086w) {
            if (cVar != null) {
                cVar.f9082v = false;
            }
        }
        long jT = this.f9084u.t(j5);
        long j8 = this.f9088y;
        long j10 = this.f9089z;
        long jMax = Math.max(jT, j8);
        return j10 != Long.MIN_VALUE ? Math.min(jMax, j10) : jMax;
    }

    @Override // o2.e1
    public final void v(long j5) {
        this.f9084u.v(j5);
    }
}
