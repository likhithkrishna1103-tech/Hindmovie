package o2;

import a2.d2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements b0, a0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b0 f9169u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f9170v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a0 f9171w;

    public m1(b0 b0Var, long j5) {
        this.f9169u = b0Var;
        this.f9170v = j5;
    }

    @Override // o2.b0
    public final long a(long j5, d2 d2Var) {
        long j8 = this.f9170v;
        return this.f9169u.a(j5 - j8, d2Var) + j8;
    }

    @Override // o2.e1
    public final boolean c() {
        return this.f9169u.c();
    }

    @Override // o2.d1
    public final void d(e1 e1Var) {
        a0 a0Var = this.f9171w;
        a0Var.getClass();
        a0Var.d(this);
    }

    @Override // o2.e1
    public final long g() {
        long jG = this.f9169u.g();
        if (jG == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jG + this.f9170v;
    }

    @Override // o2.b0
    public final void h(boolean z2, long j5) {
        this.f9169u.h(z2, j5 - this.f9170v);
    }

    @Override // o2.b0
    public final long i() {
        long jI = this.f9169u.i();
        if (jI == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jI + this.f9170v;
    }

    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        a2.b1 b1Var = new a2.b1();
        long j5 = c1Var.f178a;
        b1Var.f165b = c1Var.f179b;
        b1Var.f166c = c1Var.f180c;
        b1Var.f164a = j5 - this.f9170v;
        return this.f9169u.l(new a2.c1(b1Var));
    }

    @Override // o2.a0
    public final void m(b0 b0Var) {
        a0 a0Var = this.f9171w;
        a0Var.getClass();
        a0Var.m(this);
    }

    @Override // o2.b0
    public final long n(r2.r[] rVarArr, boolean[] zArr, c1[] c1VarArr, boolean[] zArr2, long j5) {
        c1[] c1VarArr2 = new c1[c1VarArr.length];
        int i = 0;
        while (true) {
            c1 c1Var = null;
            if (i >= c1VarArr.length) {
                break;
            }
            l1 l1Var = (l1) c1VarArr[i];
            if (l1Var != null) {
                c1Var = l1Var.f9159u;
            }
            c1VarArr2[i] = c1Var;
            i++;
        }
        b0 b0Var = this.f9169u;
        long j8 = this.f9170v;
        long jN = b0Var.n(rVarArr, zArr, c1VarArr2, zArr2, j5 - j8);
        for (int i10 = 0; i10 < c1VarArr.length; i10++) {
            c1 c1Var2 = c1VarArr2[i10];
            if (c1Var2 == null) {
                c1VarArr[i10] = null;
            } else {
                c1 c1Var3 = c1VarArr[i10];
                if (c1Var3 == null || ((l1) c1Var3).f9159u != c1Var2) {
                    c1VarArr[i10] = new l1(c1Var2, j8);
                }
            }
        }
        return jN + j8;
    }

    @Override // o2.b0
    public final void o(a0 a0Var, long j5) {
        this.f9171w = a0Var;
        this.f9169u.o(this, j5 - this.f9170v);
    }

    @Override // o2.b0
    public final n1 p() {
        return this.f9169u.p();
    }

    @Override // o2.e1
    public final long r() {
        long jR = this.f9169u.r();
        if (jR == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jR + this.f9170v;
    }

    @Override // o2.b0
    public final void s() {
        this.f9169u.s();
    }

    @Override // o2.b0
    public final long t(long j5) {
        long j8 = this.f9170v;
        return this.f9169u.t(j5 - j8) + j8;
    }

    @Override // o2.e1
    public final void v(long j5) {
        this.f9169u.v(j5 - this.f9170v);
    }
}
