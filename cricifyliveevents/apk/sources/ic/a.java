package ic;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6416c;

    public a(long j4, long j7, String str) {
        this.f6414a = str;
        this.f6415b = j4;
        this.f6416c = j7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f6414a.equals(aVar.f6414a) && this.f6415b == aVar.f6415b && this.f6416c == aVar.f6416c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f6414a.hashCode() ^ 1000003) * 1000003;
        long j4 = this.f6415b;
        long j7 = this.f6416c;
        return ((iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationTokenResult{token=");
        sb.append(this.f6414a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f6415b);
        sb.append(", tokenCreationTimestamp=");
        return q4.a.p(sb, this.f6416c, "}");
    }
}
