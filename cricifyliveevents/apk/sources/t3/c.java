package t3;

import a3.b0;
import a3.d0;
import android.util.Pair;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f11874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f11875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11876c;

    public c(long j4, long[] jArr, long[] jArr2) {
        this.f11874a = jArr;
        this.f11875b = jArr2;
        this.f11876c = j4 == -9223372036854775807L ? a0.O(jArr2[jArr2.length - 1]) : j4;
    }

    public static Pair a(long j4, long[] jArr, long[] jArr2) {
        int iE = a0.e(jArr, j4, true);
        long j7 = jArr[iE];
        long j10 = jArr2[iE];
        int i = iE + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j7), Long.valueOf(j10));
        }
        return Pair.create(Long.valueOf(j4), Long.valueOf(((long) ((jArr[i] == j7 ? 0.0d : (j4 - j7) / (r6 - j7)) * (jArr2[i] - j10))) + j10));
    }

    @Override // t3.f
    public final long b(long j4) {
        return a0.O(((Long) a(j4, this.f11874a, this.f11875b).second).longValue());
    }

    @Override // t3.f
    public final long d() {
        return -1L;
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        Pair pairA = a(a0.b0(a0.j(j4, 0L, this.f11876c)), this.f11875b, this.f11874a);
        d0 d0Var = new d0(a0.O(((Long) pairA.first).longValue()), ((Long) pairA.second).longValue());
        return new b0(d0Var, d0Var);
    }

    @Override // t3.f
    public final int k() {
        return -2147483647;
    }

    @Override // a3.c0
    public final long l() {
        return this.f11876c;
    }
}
