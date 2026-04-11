package p3;

import s1.b0;
import w2.a0;
import w2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f10192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f10193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10196e;

    public g(long[] jArr, long[] jArr2, long j5, long j8, long j10, int i) {
        this.f10192a = jArr;
        this.f10193b = jArr2;
        this.f10194c = j5;
        this.f10195d = j10;
        this.f10196e = i;
    }

    @Override // p3.f
    public final long b(long j5) {
        return this.f10192a[b0.e(this.f10193b, j5, true)];
    }

    @Override // p3.f
    public final long d() {
        return this.f10195d;
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        long[] jArr = this.f10192a;
        int iE = b0.e(jArr, j5, true);
        long j8 = jArr[iE];
        long[] jArr2 = this.f10193b;
        c0 c0Var = new c0(j8, jArr2[iE]);
        if (j8 >= j5 || iE == jArr.length - 1) {
            return new a0(c0Var, c0Var);
        }
        int i = iE + 1;
        return new a0(c0Var, new c0(jArr[i], jArr2[i]));
    }

    @Override // p3.f
    public final int j() {
        return this.f10196e;
    }

    @Override // w2.b0
    public final long k() {
        return this.f10194c;
    }
}
