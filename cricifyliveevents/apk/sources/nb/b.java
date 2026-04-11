package nb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8927c;

    public b(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f8925a = str;
        this.f8926b = str2;
        this.f8927c = str3;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            String str3 = bVar.f8927c;
            String str4 = bVar.f8926b;
            if (this.f8925a.equals(bVar.f8925a) && ((str = this.f8926b) != null ? str.equals(str4) : str4 == null) && ((str2 = this.f8927c) != null ? str2.equals(str3) : str3 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f8925a.hashCode() ^ 1000003) * 1000003;
        String str = this.f8926b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f8927c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb.append(this.f8925a);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f8926b);
        sb.append(", firebaseAuthenticationToken=");
        return q4.a.q(sb, this.f8927c, "}");
    }
}
