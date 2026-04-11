package ab;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f379c;

    public a(long j4, long j7, long j10) {
        this.f377a = j4;
        this.f378b = j7;
        this.f379c = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f377a == aVar.f377a && this.f378b == aVar.f378b && this.f379c == aVar.f379c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f377a;
        long j7 = this.f378b;
        int i = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j10 = this.f379c;
        return i ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartupTime{epochMillis=");
        sb.append(this.f377a);
        sb.append(", elapsedRealtime=");
        sb.append(this.f378b);
        sb.append(", uptimeMillis=");
        return q4.a.p(sb, this.f379c, "}");
    }
}
