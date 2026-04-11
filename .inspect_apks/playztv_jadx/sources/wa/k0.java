package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13930e;
    public final String f;

    public k0(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f13926a = str;
        this.f13927b = str2;
        this.f13928c = str3;
        this.f13929d = str4;
        this.f13930e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj instanceof u1) {
            k0 k0Var = (k0) ((u1) obj);
            String str5 = k0Var.f;
            String str6 = k0Var.f13930e;
            String str7 = k0Var.f13929d;
            String str8 = k0Var.f13928c;
            if (this.f13926a.equals(k0Var.f13926a) && this.f13927b.equals(k0Var.f13927b) && ((str = this.f13928c) != null ? str.equals(str8) : str8 == null) && ((str2 = this.f13929d) != null ? str2.equals(str7) : str7 == null) && ((str3 = this.f13930e) != null ? str3.equals(str6) : str6 == null) && ((str4 = this.f) != null ? str4.equals(str5) : str5 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f13926a.hashCode() ^ 1000003) * 1000003) ^ this.f13927b.hashCode()) * 1000003;
        String str = this.f13928c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f13929d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f13930e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Application{identifier=");
        sb2.append(this.f13926a);
        sb2.append(", version=");
        sb2.append(this.f13927b);
        sb2.append(", displayVersion=");
        sb2.append(this.f13928c);
        sb2.append(", organization=null, installationUuid=");
        sb2.append(this.f13929d);
        sb2.append(", developmentPlatform=");
        sb2.append(this.f13930e);
        sb2.append(", developmentPlatformVersion=");
        return l4.a.o(sb2, this.f, "}");
    }
}
