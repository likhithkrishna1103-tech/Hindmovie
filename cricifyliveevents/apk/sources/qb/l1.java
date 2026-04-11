package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10646e;
    public final i2.k f;

    public l1(String str, String str2, String str3, String str4, int i, i2.k kVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f10642a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f10643b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f10644c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f10645d = str4;
        this.f10646e = i;
        this.f = kVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f10642a.equals(l1Var.f10642a) && this.f10643b.equals(l1Var.f10643b) && this.f10644c.equals(l1Var.f10644c) && this.f10645d.equals(l1Var.f10645d) && this.f10646e == l1Var.f10646e && this.f.equals(l1Var.f);
    }

    public final int hashCode() {
        return ((((((((((this.f10642a.hashCode() ^ 1000003) * 1000003) ^ this.f10643b.hashCode()) * 1000003) ^ this.f10644c.hashCode()) * 1000003) ^ this.f10645d.hashCode()) * 1000003) ^ this.f10646e) * 1000003) ^ this.f.hashCode();
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.f10642a + ", versionCode=" + this.f10643b + ", versionName=" + this.f10644c + ", installUuid=" + this.f10645d + ", deliveryMechanism=" + this.f10646e + ", developmentPlatformProvider=" + this.f + "}";
    }
}
