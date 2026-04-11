package d7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4090b;

    public a(int i, long j5) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.f4089a = i;
        this.f4090b = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return v.e.a(this.f4089a, aVar.f4089a) && this.f4090b == aVar.f4090b;
    }

    public final int hashCode() {
        int iC = (v.e.c(this.f4089a) ^ 1000003) * 1000003;
        long j5 = this.f4090b;
        return iC ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BackendResponse{status=");
        int i = this.f4089a;
        sb2.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb2.append(", nextRequestWaitMillis=");
        return l4.a.n(sb2, this.f4090b, "}");
    }
}
