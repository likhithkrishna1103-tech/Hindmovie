package p3;

import s1.b0;
import w2.a0;
import w2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10201e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long[] f10202g;

    public h(long j5, int i, long j8, int i10, long j10, long[] jArr) {
        this.f10197a = j5;
        this.f10198b = i;
        this.f10199c = j8;
        this.f10200d = i10;
        this.f10201e = j10;
        this.f10202g = jArr;
        this.f = j10 != -1 ? j5 + j10 : -1L;
    }

    @Override // p3.f
    public final long b(long j5) {
        long j8 = j5 - this.f10197a;
        if (!h() || j8 <= this.f10198b) {
            return 0L;
        }
        long[] jArr = this.f10202g;
        s1.d.h(jArr);
        double d10 = (j8 * 256.0d) / this.f10201e;
        int iE = b0.e(jArr, (long) d10, true);
        long j10 = this.f10199c;
        long j11 = (((long) iE) * j10) / 100;
        long j12 = jArr[iE];
        int i = iE + 1;
        long j13 = (j10 * ((long) i)) / 100;
        return Math.round((j12 == (iE == 99 ? 256L : jArr[i]) ? 0.0d : (d10 - j12) / (r0 - j12)) * (j13 - j11)) + j11;
    }

    @Override // p3.f
    public final long d() {
        return this.f;
    }

    @Override // w2.b0
    public final boolean h() {
        return this.f10202g != null;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        double d10;
        double d11;
        boolean zH = h();
        int i = this.f10198b;
        long j8 = this.f10197a;
        if (!zH) {
            c0 c0Var = new c0(0L, j8 + ((long) i));
            return new a0(c0Var, c0Var);
        }
        long j10 = b0.j(j5, 0L, this.f10199c);
        double d12 = (j10 * 100.0d) / this.f10199c;
        double d13 = 0.0d;
        if (d12 <= 0.0d) {
            d10 = 256.0d;
        } else if (d12 >= 100.0d) {
            d10 = 256.0d;
            d13 = 256.0d;
        } else {
            int i10 = (int) d12;
            long[] jArr = this.f10202g;
            s1.d.h(jArr);
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
        long j11 = this.f10201e;
        c0 c0Var2 = new c0(j10, j8 + b0.j(Math.round((d13 / d10) * j11), i, j11 - 1));
        return new a0(c0Var2, c0Var2);
    }

    @Override // p3.f
    public final int j() {
        return this.f10200d;
    }

    @Override // w2.b0
    public final long k() {
        return this.f10199c;
    }
}
