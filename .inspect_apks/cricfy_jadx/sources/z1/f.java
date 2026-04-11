package z1;

import v1.i0;
import v1.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15074c;

    public f(long j4, long j7, long j10) {
        this.f15072a = j4;
        this.f15073b = j7;
        this.f15074c = j10;
    }

    @Override // v1.k0
    public final /* synthetic */ v1.p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f15072a == fVar.f15072a && this.f15073b == fVar.f15073b && this.f15074c == fVar.f15074c;
    }

    public final int hashCode() {
        return com.bumptech.glide.e.g(this.f15074c) + ((com.bumptech.glide.e.g(this.f15073b) + ((com.bumptech.glide.e.g(this.f15072a) + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.f15072a + ", modification time=" + this.f15073b + ", timescale=" + this.f15074c;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
