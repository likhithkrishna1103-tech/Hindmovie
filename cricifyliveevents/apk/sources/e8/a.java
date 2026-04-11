package e8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a f = new a(10485760, 200, 10000, 604800000, 81920);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3831e;

    public a(long j4, int i, int i10, long j7, int i11) {
        this.f3827a = j4;
        this.f3828b = i;
        this.f3829c = i10;
        this.f3830d = j7;
        this.f3831e = i11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f3827a == aVar.f3827a && this.f3828b == aVar.f3828b && this.f3829c == aVar.f3829c && this.f3830d == aVar.f3830d && this.f3831e == aVar.f3831e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f3827a;
        int i = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f3828b) * 1000003) ^ this.f3829c) * 1000003;
        long j7 = this.f3830d;
        return ((i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f3831e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f3827a);
        sb.append(", loadBatchSize=");
        sb.append(this.f3828b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f3829c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f3830d);
        sb.append(", maxBlobByteSizePerRow=");
        return q4.a.o(sb, this.f3831e, "}");
    }
}
