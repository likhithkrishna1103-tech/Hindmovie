package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13943e;
    public final pb.c f;

    public l1(String str, String str2, String str3, String str4, int i, pb.c cVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f13939a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f13940b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f13941c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f13942d = str4;
        this.f13943e = i;
        this.f = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f13939a.equals(l1Var.f13939a) && this.f13940b.equals(l1Var.f13940b) && this.f13941c.equals(l1Var.f13941c) && this.f13942d.equals(l1Var.f13942d) && this.f13943e == l1Var.f13943e && this.f.equals(l1Var.f);
    }

    public final int hashCode() {
        return ((((((((((this.f13939a.hashCode() ^ 1000003) * 1000003) ^ this.f13940b.hashCode()) * 1000003) ^ this.f13941c.hashCode()) * 1000003) ^ this.f13942d.hashCode()) * 1000003) ^ this.f13943e) * 1000003) ^ this.f.hashCode();
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.f13939a + ", versionCode=" + this.f13940b + ", versionName=" + this.f13941c + ", installUuid=" + this.f13942d + ", deliveryMechanism=" + this.f13943e + ", developmentPlatformProvider=" + this.f + "}";
    }
}
