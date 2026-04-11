package p3;

import w2.a0;
import w2.b0;
import w2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f, b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10165e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10167h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f10168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f10170l;

    public a(long j5, long j8, int i, int i10, boolean z2) {
        this.f10161a = j5;
        this.f10162b = j8;
        this.f10163c = i10 == -1 ? 1 : i10;
        this.f10165e = i;
        this.f10166g = z2;
        if (j5 == -1) {
            this.f10164d = -1L;
            this.f = -9223372036854775807L;
        } else {
            long j10 = j5 - j8;
            this.f10164d = j10;
            this.f = (Math.max(0L, j10) * 8000000) / ((long) i);
        }
        this.f10167h = j8;
        this.i = i;
        this.f10168j = i10;
        this.f10169k = z2;
        this.f10170l = j5 == -1 ? -1L : j5;
    }

    @Override // p3.f
    public final long b(long j5) {
        return (Math.max(0L, j5 - this.f10162b) * 8000000) / ((long) this.f10165e);
    }

    @Override // p3.f
    public final long d() {
        return this.f10170l;
    }

    @Override // w2.b0
    public final boolean h() {
        return this.f10164d != -1 || this.f10166g;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        long j8 = this.f10164d;
        long j10 = this.f10162b;
        if (j8 == -1 && !this.f10166g) {
            c0 c0Var = new c0(0L, j10);
            return new a0(c0Var, c0Var);
        }
        int i = this.f10165e;
        long j11 = this.f10163c;
        long jMin = (((((long) i) * j5) / 8000000) / j11) * j11;
        if (j8 != -1) {
            jMin = Math.min(jMin, j8 - j11);
        }
        long jMax = Math.max(jMin, 0L) + j10;
        long jMax2 = (Math.max(0L, jMax - j10) * 8000000) / ((long) i);
        c0 c0Var2 = new c0(jMax2, jMax);
        if (j8 != -1 && jMax2 < j5) {
            long j12 = jMax + j11;
            if (j12 < this.f10161a) {
                return new a0(c0Var2, new c0((Math.max(0L, j12 - j10) * 8000000) / ((long) i), j12));
            }
        }
        return new a0(c0Var2, c0Var2);
    }

    @Override // p3.f
    public final int j() {
        return this.i;
    }

    @Override // w2.b0
    public final long k() {
        return this.f;
    }
}
