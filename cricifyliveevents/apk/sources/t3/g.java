package t3;

import a3.b0;
import a3.d0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f11895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f11896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11899e;

    public g(long[] jArr, long[] jArr2, long j4, long j7, long j10, int i) {
        this.f11895a = jArr;
        this.f11896b = jArr2;
        this.f11897c = j4;
        this.f11898d = j10;
        this.f11899e = i;
    }

    @Override // t3.f
    public final long b(long j4) {
        return this.f11895a[a0.e(this.f11896b, j4, true)];
    }

    @Override // t3.f
    public final long d() {
        return this.f11898d;
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        long[] jArr = this.f11895a;
        int iE = a0.e(jArr, j4, true);
        long j7 = jArr[iE];
        long[] jArr2 = this.f11896b;
        d0 d0Var = new d0(j7, jArr2[iE]);
        if (j7 >= j4 || iE == jArr.length - 1) {
            return new b0(d0Var, d0Var);
        }
        int i = iE + 1;
        return new b0(d0Var, new d0(jArr[i], jArr2[i]));
    }

    @Override // t3.f
    public final int k() {
        return this.f11899e;
    }

    @Override // a3.c0
    public final long l() {
        return this.f11897c;
    }
}
