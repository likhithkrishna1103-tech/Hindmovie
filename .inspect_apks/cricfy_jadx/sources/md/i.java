package md;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8440b;

    public i(int i, long j4) {
        this.f8439a = i;
        this.f8440b = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f8439a == iVar.f8439a && this.f8440b == iVar.f8440b;
    }

    public final int hashCode() {
        int i = this.f8439a * 31;
        long j4 = this.f8440b;
        return i + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return "FileSliceInfo(slicingCount=" + this.f8439a + ", bytesPerFileSlice=" + this.f8440b + ")";
    }
}
