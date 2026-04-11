package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends s {
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9103h;
    public final boolean i;

    public f(p1.f1 f1Var, long j5, long j8, boolean z2) throws g {
        super(f1Var);
        if (j8 != Long.MIN_VALUE && j8 < j5) {
            throw new g(2, j5, j8);
        }
        boolean z10 = false;
        if (f1Var.h() != 1) {
            throw new g(0);
        }
        p1.e1 e1VarM = f1Var.m(0, new p1.e1(), 0L);
        long jMax = Math.max(0L, j5);
        if (!z2 && !e1VarM.f9721k && jMax != 0 && !e1VarM.f9719h) {
            throw new g(1);
        }
        long jMax2 = j8 == Long.MIN_VALUE ? e1VarM.f9723m : Math.max(0L, j8);
        long j10 = e1VarM.f9723m;
        if (j10 != -9223372036854775807L) {
            jMax2 = jMax2 > j10 ? j10 : jMax2;
            if (jMax > jMax2) {
                jMax = jMax2;
            }
        }
        this.f = jMax;
        this.f9102g = jMax2;
        this.f9103h = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
        if (e1VarM.i && (jMax2 == -9223372036854775807L || (j10 != -9223372036854775807L && jMax2 == j10))) {
            z10 = true;
        }
        this.i = z10;
    }

    @Override // o2.s, p1.f1
    public final p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        this.f9206e.f(0, c1Var, z2);
        long j5 = c1Var.f9680e - this.f;
        long j8 = this.f9103h;
        c1Var.h(c1Var.f9676a, c1Var.f9677b, 0, j8 != -9223372036854775807L ? j8 - j5 : -9223372036854775807L, j5, p1.b.f9644c, false);
        return c1Var;
    }

    @Override // o2.s, p1.f1
    public final p1.e1 m(int i, p1.e1 e1Var, long j5) {
        this.f9206e.m(0, e1Var, 0L);
        long j8 = e1Var.f9726p;
        long j10 = this.f;
        e1Var.f9726p = j8 + j10;
        e1Var.f9723m = this.f9103h;
        e1Var.i = this.i;
        long j11 = e1Var.f9722l;
        if (j11 != -9223372036854775807L) {
            long jMax = Math.max(j11, j10);
            e1Var.f9722l = jMax;
            long j12 = this.f9102g;
            if (j12 != -9223372036854775807L) {
                jMax = Math.min(jMax, j12);
            }
            e1Var.f9722l = jMax - j10;
        }
        long jB0 = s1.b0.b0(j10);
        long j13 = e1Var.f9717e;
        if (j13 != -9223372036854775807L) {
            e1Var.f9717e = j13 + jB0;
        }
        long j14 = e1Var.f;
        if (j14 != -9223372036854775807L) {
            e1Var.f = j14 + jB0;
        }
        return e1Var;
    }
}
