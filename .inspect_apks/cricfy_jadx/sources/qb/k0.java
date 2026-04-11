package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10633e;
    public final String f;

    public k0(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f10629a = str;
        this.f10630b = str2;
        this.f10631c = str3;
        this.f10632d = str4;
        this.f10633e = str5;
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
            String str6 = k0Var.f10633e;
            String str7 = k0Var.f10632d;
            String str8 = k0Var.f10631c;
            if (this.f10629a.equals(k0Var.f10629a) && this.f10630b.equals(k0Var.f10630b) && ((str = this.f10631c) != null ? str.equals(str8) : str8 == null) && ((str2 = this.f10632d) != null ? str2.equals(str7) : str7 == null) && ((str3 = this.f10633e) != null ? str3.equals(str6) : str6 == null) && ((str4 = this.f) != null ? str4.equals(str5) : str5 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f10629a.hashCode() ^ 1000003) * 1000003) ^ this.f10630b.hashCode()) * 1000003;
        String str = this.f10631c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f10632d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10633e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{identifier=");
        sb.append(this.f10629a);
        sb.append(", version=");
        sb.append(this.f10630b);
        sb.append(", displayVersion=");
        sb.append(this.f10631c);
        sb.append(", organization=null, installationUuid=");
        sb.append(this.f10632d);
        sb.append(", developmentPlatform=");
        sb.append(this.f10633e);
        sb.append(", developmentPlatformVersion=");
        return q4.a.q(sb, this.f, "}");
    }
}
