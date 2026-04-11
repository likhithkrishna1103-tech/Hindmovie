package s2;

import g2.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements a0, z {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a0 f11253v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11254w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public z f11255x;

    public k1(a0 a0Var, long j4) {
        this.f11253v = a0Var;
        this.f11254w = j4;
    }

    @Override // s2.c1
    public final boolean a() {
        return this.f11253v.a();
    }

    @Override // s2.a0
    public final void d(z zVar, long j4) {
        this.f11255x = zVar;
        this.f11253v.d(this, j4 - this.f11254w);
    }

    @Override // s2.b1
    public final void f(c1 c1Var) {
        z zVar = this.f11255x;
        zVar.getClass();
        zVar.f(this);
    }

    @Override // s2.a0
    public final long h(long j4, r1 r1Var) {
        long j7 = this.f11254w;
        return this.f11253v.h(j4 - j7, r1Var) + j7;
    }

    @Override // s2.c1
    public final boolean i(g2.s0 s0Var) {
        g2.r0 r0Var = new g2.r0();
        long j4 = s0Var.f4897a;
        r0Var.f4889b = s0Var.f4898b;
        r0Var.f4890c = s0Var.f4899c;
        r0Var.f4888a = j4 - this.f11254w;
        return this.f11253v.i(new g2.s0(r0Var));
    }

    @Override // s2.c1
    public final long j() {
        long j4 = this.f11253v.j();
        if (j4 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return j4 + this.f11254w;
    }

    @Override // s2.z
    public final void k(a0 a0Var) {
        z zVar = this.f11255x;
        zVar.getClass();
        zVar.k(this);
    }

    @Override // s2.a0
    public final void l(boolean z10, long j4) {
        this.f11253v.l(z10, j4 - this.f11254w);
    }

    @Override // s2.a0
    public final long m() {
        long jM = this.f11253v.m();
        if (jM == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jM + this.f11254w;
    }

    @Override // s2.a0
    public final l1 o() {
        return this.f11253v.o();
    }

    @Override // s2.c1
    public final long q() {
        long jQ = this.f11253v.q();
        if (jQ == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jQ + this.f11254w;
    }

    @Override // s2.a0
    public final void r() {
        this.f11253v.r();
    }

    @Override // s2.a0
    public final long t(long j4) {
        long j7 = this.f11254w;
        return this.f11253v.t(j4 - j7) + j7;
    }

    @Override // s2.c1
    public final void u(long j4) {
        this.f11253v.u(j4 - this.f11254w);
    }

    @Override // s2.a0
    public final long v(v2.q[] qVarArr, boolean[] zArr, a1[] a1VarArr, boolean[] zArr2, long j4) {
        a1[] a1VarArr2 = new a1[a1VarArr.length];
        int i = 0;
        while (true) {
            a1 a1Var = null;
            if (i >= a1VarArr.length) {
                break;
            }
            j1 j1Var = (j1) a1VarArr[i];
            if (j1Var != null) {
                a1Var = j1Var.f11243v;
            }
            a1VarArr2[i] = a1Var;
            i++;
        }
        a0 a0Var = this.f11253v;
        long j7 = this.f11254w;
        long jV = a0Var.v(qVarArr, zArr, a1VarArr2, zArr2, j4 - j7);
        for (int i10 = 0; i10 < a1VarArr.length; i10++) {
            a1 a1Var2 = a1VarArr2[i10];
            if (a1Var2 == null) {
                a1VarArr[i10] = null;
            } else {
                a1 a1Var3 = a1VarArr[i10];
                if (a1Var3 == null || ((j1) a1Var3).f11243v != a1Var2) {
                    a1VarArr[i10] = new j1(a1Var2, j7);
                }
            }
        }
        return jV + j7;
    }
}
