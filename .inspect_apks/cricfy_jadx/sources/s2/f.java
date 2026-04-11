package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends r {
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f11191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f11192h;
    public final boolean i;

    public f(v1.f1 f1Var, long j4, long j7, boolean z10) throws g {
        super(f1Var);
        if (j7 != Long.MIN_VALUE && j7 < j4) {
            throw new g(2, j4, j7);
        }
        boolean z11 = false;
        if (f1Var.h() != 1) {
            throw new g(0);
        }
        v1.e1 e1VarM = f1Var.m(0, new v1.e1(), 0L);
        long jMax = Math.max(0L, j4);
        if (!z10 && !e1VarM.f12651k && jMax != 0 && !e1VarM.f12649h) {
            throw new g(1);
        }
        long jMax2 = j7 == Long.MIN_VALUE ? e1VarM.f12653m : Math.max(0L, j7);
        long j10 = e1VarM.f12653m;
        if (j10 != -9223372036854775807L) {
            jMax2 = jMax2 > j10 ? j10 : jMax2;
            if (jMax > jMax2) {
                jMax = jMax2;
            }
        }
        this.f = jMax;
        this.f11191g = jMax2;
        this.f11192h = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
        if (e1VarM.i && (jMax2 == -9223372036854775807L || (j10 != -9223372036854775807L && jMax2 == j10))) {
            z11 = true;
        }
        this.i = z11;
    }

    @Override // s2.r, v1.f1
    public final v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        this.f11299e.f(0, c1Var, z10);
        long j4 = c1Var.f12620e - this.f;
        long j7 = this.f11192h;
        c1Var.h(c1Var.f12616a, c1Var.f12617b, 0, j7 != -9223372036854775807L ? j7 - j4 : -9223372036854775807L, j4, v1.b.f12580c, false);
        return c1Var;
    }

    @Override // s2.r, v1.f1
    public final v1.e1 m(int i, v1.e1 e1Var, long j4) {
        this.f11299e.m(0, e1Var, 0L);
        long j7 = e1Var.f12656p;
        long j10 = this.f;
        e1Var.f12656p = j7 + j10;
        e1Var.f12653m = this.f11192h;
        e1Var.i = this.i;
        long j11 = e1Var.f12652l;
        if (j11 != -9223372036854775807L) {
            long jMax = Math.max(j11, j10);
            e1Var.f12652l = jMax;
            long j12 = this.f11191g;
            if (j12 != -9223372036854775807L) {
                jMax = Math.min(jMax, j12);
            }
            e1Var.f12652l = jMax - j10;
        }
        long jB0 = y1.a0.b0(j10);
        long j13 = e1Var.f12647e;
        if (j13 != -9223372036854775807L) {
            e1Var.f12647e = j13 + jB0;
        }
        long j14 = e1Var.f;
        if (j14 != -9223372036854775807L) {
            e1Var.f = j14 + jB0;
        }
        return e1Var;
    }
}
