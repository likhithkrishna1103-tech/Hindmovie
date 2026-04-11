package t3;

import a3.b0;
import a3.d0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f11904e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long[] f11905g;

    public h(long j4, int i, long j7, int i10, long j10, long[] jArr) {
        this.f11900a = j4;
        this.f11901b = i;
        this.f11902c = j7;
        this.f11903d = i10;
        this.f11904e = j10;
        this.f11905g = jArr;
        this.f = j10 != -1 ? j4 + j10 : -1L;
    }

    @Override // t3.f
    public final long b(long j4) {
        long j7 = j4 - this.f11900a;
        if (!g() || j7 <= this.f11901b) {
            return 0L;
        }
        long[] jArr = this.f11905g;
        y1.d.h(jArr);
        double d10 = (j7 * 256.0d) / this.f11904e;
        int iE = a0.e(jArr, (long) d10, true);
        long j10 = this.f11902c;
        long j11 = (((long) iE) * j10) / 100;
        long j12 = jArr[iE];
        int i = iE + 1;
        long j13 = (j10 * ((long) i)) / 100;
        return Math.round((j12 == (iE == 99 ? 256L : jArr[i]) ? 0.0d : (d10 - j12) / (r0 - j12)) * (j13 - j11)) + j11;
    }

    @Override // t3.f
    public final long d() {
        return this.f;
    }

    @Override // a3.c0
    public final boolean g() {
        return this.f11905g != null;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        double d10;
        double d11;
        boolean zG = g();
        int i = this.f11901b;
        long j7 = this.f11900a;
        if (!zG) {
            d0 d0Var = new d0(0L, j7 + ((long) i));
            return new b0(d0Var, d0Var);
        }
        long j10 = a0.j(j4, 0L, this.f11902c);
        double d12 = (j10 * 100.0d) / this.f11902c;
        double d13 = 0.0d;
        if (d12 <= 0.0d) {
            d10 = 256.0d;
        } else if (d12 >= 100.0d) {
            d10 = 256.0d;
            d13 = 256.0d;
        } else {
            int i10 = (int) d12;
            long[] jArr = this.f11905g;
            y1.d.h(jArr);
            double d14 = jArr[i10];
            if (i10 == 99) {
                d10 = 256.0d;
                d11 = 256.0d;
            } else {
                d10 = 256.0d;
                d11 = jArr[i10 + 1];
            }
            d13 = ((d11 - d14) * (d12 - ((double) i10))) + d14;
        }
        long j11 = this.f11904e;
        d0 d0Var2 = new d0(j10, j7 + a0.j(Math.round((d13 / d10) * j11), i, j11 - 1));
        return new b0(d0Var2, d0Var2);
    }

    @Override // t3.f
    public final int k() {
        return this.f11903d;
    }

    @Override // a3.c0
    public final long l() {
        return this.f11902c;
    }
}
