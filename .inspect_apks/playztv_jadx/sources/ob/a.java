package ob;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9482c;

    public a(long j5, long j8, String str) {
        this.f9480a = str;
        this.f9481b = j5;
        this.f9482c = j8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f9480a.equals(aVar.f9480a) && this.f9481b == aVar.f9481b && this.f9482c == aVar.f9482c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f9480a.hashCode() ^ 1000003) * 1000003;
        long j5 = this.f9481b;
        long j8 = this.f9482c;
        return ((iHashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("InstallationTokenResult{token=");
        sb2.append(this.f9480a);
        sb2.append(", tokenExpirationTimestamp=");
        sb2.append(this.f9481b);
        sb2.append(", tokenCreationTimestamp=");
        return l4.a.n(sb2, this.f9482c, "}");
    }
}
