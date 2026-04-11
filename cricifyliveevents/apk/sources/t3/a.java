package t3;

import a3.b0;
import a3.c0;
import a3.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f, c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11868e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f11869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f11870h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f11873l;

    public a(long j4, long j7, int i, int i10, boolean z10) {
        this.f11864a = j4;
        this.f11865b = j7;
        this.f11866c = i10 == -1 ? 1 : i10;
        this.f11868e = i;
        this.f11869g = z10;
        if (j4 == -1) {
            this.f11867d = -1L;
            this.f = -9223372036854775807L;
        } else {
            long j10 = j4 - j7;
            this.f11867d = j10;
            this.f = (Math.max(0L, j10) * 8000000) / ((long) i);
        }
        this.f11870h = j7;
        this.i = i;
        this.f11871j = i10;
        this.f11872k = z10;
        this.f11873l = j4 == -1 ? -1L : j4;
    }

    @Override // t3.f
    public final long b(long j4) {
        return (Math.max(0L, j4 - this.f11865b) * 8000000) / ((long) this.f11868e);
    }

    @Override // t3.f
    public final long d() {
        return this.f11873l;
    }

    @Override // a3.c0
    public final boolean g() {
        return this.f11867d != -1 || this.f11869g;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        long j7 = this.f11867d;
        long j10 = this.f11865b;
        if (j7 == -1 && !this.f11869g) {
            d0 d0Var = new d0(0L, j10);
            return new b0(d0Var, d0Var);
        }
        int i = this.f11868e;
        long j11 = this.f11866c;
        long jMin = (((((long) i) * j4) / 8000000) / j11) * j11;
        if (j7 != -1) {
            jMin = Math.min(jMin, j7 - j11);
        }
        long jMax = Math.max(jMin, 0L) + j10;
        long jMax2 = (Math.max(0L, jMax - j10) * 8000000) / ((long) i);
        d0 d0Var2 = new d0(jMax2, jMax);
        if (j7 != -1 && jMax2 < j4) {
            long j12 = jMax + j11;
            if (j12 < this.f11864a) {
                return new b0(d0Var2, new d0((Math.max(0L, j12 - j10) * 8000000) / ((long) i), j12));
            }
        }
        return new b0(d0Var2, d0Var2);
    }

    @Override // t3.f
    public final int k() {
        return this.i;
    }

    @Override // a3.c0
    public final long l() {
        return this.f;
    }
}
