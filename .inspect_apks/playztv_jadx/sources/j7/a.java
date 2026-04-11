package j7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a f = new a(10485760, 200, 10000, 604800000, 81920);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6813e;

    public a(long j5, int i, int i10, long j8, int i11) {
        this.f6809a = j5;
        this.f6810b = i;
        this.f6811c = i10;
        this.f6812d = j8;
        this.f6813e = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f6809a == aVar.f6809a && this.f6810b == aVar.f6810b && this.f6811c == aVar.f6811c && this.f6812d == aVar.f6812d && this.f6813e == aVar.f6813e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f6809a;
        int i = (((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f6810b) * 1000003) ^ this.f6811c) * 1000003;
        long j8 = this.f6812d;
        return ((i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f6813e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb2.append(this.f6809a);
        sb2.append(", loadBatchSize=");
        sb2.append(this.f6810b);
        sb2.append(", criticalSectionEnterTimeoutMs=");
        sb2.append(this.f6811c);
        sb2.append(", eventCleanUpAge=");
        sb2.append(this.f6812d);
        sb2.append(", maxBlobByteSizePerRow=");
        return x.c.a(sb2, this.f6813e, "}");
    }
}
