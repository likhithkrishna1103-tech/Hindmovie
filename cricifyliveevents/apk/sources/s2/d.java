package s2;

import g2.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a0, z {
    public long A;
    public g B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a0 f11161v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public z f11162w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c[] f11163x = new c[0];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f11164y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f11165z;

    public d(a0 a0Var, boolean z10, long j4, long j7) {
        this.f11161v = a0Var;
        this.f11164y = z10 ? j4 : -9223372036854775807L;
        this.f11165z = j4;
        this.A = j7;
    }

    @Override // s2.c1
    public final boolean a() {
        return this.f11161v.a();
    }

    public final boolean b() {
        return this.f11164y != -9223372036854775807L;
    }

    @Override // s2.a0
    public final void d(z zVar, long j4) {
        this.f11162w = zVar;
        this.f11161v.d(this, j4);
    }

    @Override // s2.b1
    public final void f(c1 c1Var) {
        z zVar = this.f11162w;
        zVar.getClass();
        zVar.f(this);
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        long j7 = this.f11165z;
        if (j4 == j7) {
            return j7;
        }
        long j10 = y1.a0.j(r1Var.f4892a, 0L, j4 - j7);
        long j11 = r1Var.f4893b;
        long j12 = this.A;
        long j13 = y1.a0.j(j11, 0L, j12 == Long.MIN_VALUE ? Long.MAX_VALUE : j12 - j4);
        if (j10 != r1Var.f4892a || j13 != r1Var.f4893b) {
            r1Var = new r1(j10, j13);
        }
        return this.f11161v.h(j4, r1Var);
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        return this.f11161v.i(s0Var);
    }

    @Override // s2.c1
    public final long j() {
        long j4 = this.f11161v.j();
        if (j4 != Long.MIN_VALUE) {
            long j7 = this.A;
            if (j7 == Long.MIN_VALUE || j4 < j7) {
                return j4;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // s2.z
    public final void k(a0 a0Var) {
        if (this.B != null) {
            return;
        }
        z zVar = this.f11162w;
        zVar.getClass();
        zVar.k(this);
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) {
        this.f11161v.l(z10, j4);
    }

    @Override // s2.a0
    public final long m() {
        if (b()) {
            long j4 = this.f11164y;
            this.f11164y = -9223372036854775807L;
            long jM = m();
            return jM != -9223372036854775807L ? jM : j4;
        }
        long jM2 = this.f11161v.m();
        if (jM2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j7 = this.f11165z;
        long j10 = this.A;
        long jMax = Math.max(jM2, j7);
        return j10 != Long.MIN_VALUE ? Math.min(jMax, j10) : jMax;
    }

    @Override // s2.a0
    public final l1 o() {
        return this.f11161v.o();
    }

    @Override // s2.c1
    public final long q() {
        long jQ = this.f11161v.q();
        if (jQ != Long.MIN_VALUE) {
            long j4 = this.A;
            if (j4 == Long.MIN_VALUE || jQ < j4) {
                return jQ;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // s2.a0
    public final void r() throws g {
        g gVar = this.B;
        if (gVar != null) {
            throw gVar;
        }
        this.f11161v.r();
    }

    @Override // s2.a0
    public final long t(long j4) {
        this.f11164y = -9223372036854775807L;
        for (c cVar : this.f11163x) {
            if (cVar != null) {
                cVar.f11154w = false;
            }
        }
        long jT = this.f11161v.t(j4);
        long j7 = this.f11165z;
        long j10 = this.A;
        long jMax = Math.max(jT, j7);
        return j10 != Long.MIN_VALUE ? Math.min(jMax, j10) : jMax;
    }

    @Override // s2.c1
    public final void u(long j4) {
        this.f11161v.u(j4);
    }

    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        long j7;
        this.f11163x = new c[a1VarArr.length];
        a1[] a1VarArr2 = new a1[a1VarArr.length];
        for (int i = 0; i < a1VarArr.length; i++) {
            c[] cVarArr = this.f11163x;
            c cVar = (c) a1VarArr[i];
            cVarArr[i] = cVar;
            a1VarArr2[i] = cVar != null ? cVar.f11153v : null;
        }
        long jV = this.f11161v.v(qVarArr, zArr, a1VarArr2, zArr2, j4);
        long j10 = this.A;
        long jMax = Math.max(jV, j4);
        if (j10 != Long.MIN_VALUE) {
            jMax = Math.min(jMax, j10);
        }
        if (b()) {
            if (jV >= j4) {
                if (jV != 0) {
                    for (v2.q qVar : qVarArr) {
                        if (qVar != null) {
                            v1.p pVarJ = qVar.j();
                            if (!v1.m0.a(pVarJ.f12946n, pVarJ.f12943k)) {
                            }
                        }
                    }
                }
                j7 = -9223372036854775807L;
            }
            j7 = jMax;
            break;
        } else {
            j7 = -9223372036854775807L;
        }
        this.f11164y = j7;
        for (int i10 = 0; i10 < a1VarArr.length; i10++) {
            a1 a1Var = a1VarArr2[i10];
            if (a1Var == null) {
                this.f11163x[i10] = null;
            } else {
                c[] cVarArr2 = this.f11163x;
                c cVar2 = cVarArr2[i10];
                if (cVar2 == null || cVar2.f11153v != a1Var) {
                    cVarArr2[i10] = new c(this, a1Var);
                }
            }
            a1VarArr[i10] = this.f11163x[i10];
        }
        return jMax;
    }
}
