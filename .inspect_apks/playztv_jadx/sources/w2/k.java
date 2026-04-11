package w2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f13646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f13647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f13648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f13649e;
    public final long f;

    public k(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f13646b = iArr;
        this.f13647c = jArr;
        this.f13648d = jArr2;
        this.f13649e = jArr3;
        int length = iArr.length;
        this.f13645a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        long[] jArr = this.f13649e;
        int iE = s1.b0.e(jArr, j5, true);
        long j8 = jArr[iE];
        long[] jArr2 = this.f13647c;
        c0 c0Var = new c0(j8, jArr2[iE]);
        if (j8 >= j5 || iE == this.f13645a - 1) {
            return new a0(c0Var, c0Var);
        }
        int i = iE + 1;
        return new a0(c0Var, new c0(jArr[i], jArr2[i]));
    }

    @Override // w2.b0
    public final long k() {
        return this.f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f13645a + ", sizes=" + Arrays.toString(this.f13646b) + ", offsets=" + Arrays.toString(this.f13647c) + ", timeUs=" + Arrays.toString(this.f13649e) + ", durationsUs=" + Arrays.toString(this.f13648d) + ")";
    }
}
