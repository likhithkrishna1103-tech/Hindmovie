package a3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f206e;
    public final long f;

    public k(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f203b = iArr;
        this.f204c = jArr;
        this.f205d = jArr2;
        this.f206e = jArr3;
        int length = iArr.length;
        this.f202a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        long[] jArr = this.f206e;
        int iE = y1.a0.e(jArr, j4, true);
        long j7 = jArr[iE];
        long[] jArr2 = this.f204c;
        d0 d0Var = new d0(j7, jArr2[iE]);
        if (j7 >= j4 || iE == this.f202a - 1) {
            return new b0(d0Var, d0Var);
        }
        int i = iE + 1;
        return new b0(d0Var, new d0(jArr[i], jArr2[i]));
    }

    @Override // a3.c0
    public final long l() {
        return this.f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f202a + ", sizes=" + Arrays.toString(this.f203b) + ", offsets=" + Arrays.toString(this.f204c) + ", timeUs=" + Arrays.toString(this.f206e) + ", durationsUs=" + Arrays.toString(this.f205d) + ")";
    }
}
