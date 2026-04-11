package y7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14965b;

    public a(int i, long j4) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.f14964a = i;
        this.f14965b = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return y.e.a(this.f14964a, aVar.f14964a) && this.f14965b == aVar.f14965b;
    }

    public final int hashCode() {
        int iC = (y.e.c(this.f14964a) ^ 1000003) * 1000003;
        long j4 = this.f14965b;
        return iC ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.f14964a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        return q4.a.p(sb, this.f14965b, "}");
    }
}
