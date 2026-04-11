package ga;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5336c;

    public a(long j5, long j8, long j10) {
        this.f5334a = j5;
        this.f5335b = j8;
        this.f5336c = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f5334a == aVar.f5334a && this.f5335b == aVar.f5335b && this.f5336c == aVar.f5336c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f5334a;
        long j8 = this.f5335b;
        int i = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j10 = this.f5336c;
        return i ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("StartupTime{epochMillis=");
        sb2.append(this.f5334a);
        sb2.append(", elapsedRealtime=");
        sb2.append(this.f5335b);
        sb2.append(", uptimeMillis=");
        return l4.a.n(sb2, this.f5336c, "}");
    }
}
