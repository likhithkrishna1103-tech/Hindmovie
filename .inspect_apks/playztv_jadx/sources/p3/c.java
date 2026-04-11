package p3;

import android.util.Pair;
import s1.b0;
import w2.a0;
import w2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f10171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f10172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10173c;

    public c(long j5, long[] jArr, long[] jArr2) {
        this.f10171a = jArr;
        this.f10172b = jArr2;
        this.f10173c = j5 == -9223372036854775807L ? b0.O(jArr2[jArr2.length - 1]) : j5;
    }

    public static Pair a(long j5, long[] jArr, long[] jArr2) {
        int iE = b0.e(jArr, j5, true);
        long j8 = jArr[iE];
        long j10 = jArr2[iE];
        int i = iE + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j8), Long.valueOf(j10));
        }
        return Pair.create(Long.valueOf(j5), Long.valueOf(((long) ((jArr[i] == j8 ? 0.0d : (j5 - j8) / (r6 - j8)) * (jArr2[i] - j10))) + j10));
    }

    @Override // p3.f
    public final long b(long j5) {
        return b0.O(((Long) a(j5, this.f10171a, this.f10172b).second).longValue());
    }

    @Override // p3.f
    public final long d() {
        return -1L;
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        Pair pairA = a(b0.b0(b0.j(j5, 0L, this.f10173c)), this.f10172b, this.f10171a);
        c0 c0Var = new c0(b0.O(((Long) pairA.first).longValue()), ((Long) pairA.second).longValue());
        return new a0(c0Var, c0Var);
    }

    @Override // p3.f
    public final int j() {
        return -2147483647;
    }

    @Override // w2.b0
    public final long k() {
        return this.f10173c;
    }
}
