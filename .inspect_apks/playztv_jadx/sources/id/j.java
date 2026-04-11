package id;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6585b;

    public j(int i, long j5) {
        this.f6584a = i;
        this.f6585b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f6584a == jVar.f6584a && this.f6585b == jVar.f6585b;
    }

    public final int hashCode() {
        int i = this.f6584a * 31;
        long j5 = this.f6585b;
        return i + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return "FileSliceInfo(slicingCount=" + this.f6584a + ", bytesPerFileSlice=" + this.f6585b + ")";
    }
}
