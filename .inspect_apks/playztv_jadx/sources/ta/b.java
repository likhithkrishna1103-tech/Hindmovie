package ta;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12353c;

    public b(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f12351a = str;
        this.f12352b = str2;
        this.f12353c = str3;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            String str3 = bVar.f12353c;
            String str4 = bVar.f12352b;
            if (this.f12351a.equals(bVar.f12351a) && ((str = this.f12352b) != null ? str.equals(str4) : str4 == null) && ((str2 = this.f12353c) != null ? str2.equals(str3) : str3 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f12351a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12352b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f12353c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb2.append(this.f12351a);
        sb2.append(", firebaseInstallationId=");
        sb2.append(this.f12352b);
        sb2.append(", firebaseAuthenticationToken=");
        return l4.a.o(sb2, this.f12353c, "}");
    }
}
