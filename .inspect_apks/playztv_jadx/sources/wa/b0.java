package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends n2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13792e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13794h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f13795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m2 f13796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s1 f13797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p1 f13798m;

    public b0(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, m2 m2Var, s1 s1Var, p1 p1Var) {
        this.f13789b = str;
        this.f13790c = str2;
        this.f13791d = i;
        this.f13792e = str3;
        this.f = str4;
        this.f13793g = str5;
        this.f13794h = str6;
        this.i = str7;
        this.f13795j = str8;
        this.f13796k = m2Var;
        this.f13797l = s1Var;
        this.f13798m = p1Var;
    }

    public final a0 a() {
        a0 a0Var = new a0();
        a0Var.f13764a = this.f13789b;
        a0Var.f13765b = this.f13790c;
        a0Var.f13766c = this.f13791d;
        a0Var.f13767d = this.f13792e;
        a0Var.f13768e = this.f;
        a0Var.f = this.f13793g;
        a0Var.f13769g = this.f13794h;
        a0Var.f13770h = this.i;
        a0Var.i = this.f13795j;
        a0Var.f13771j = this.f13796k;
        a0Var.f13772k = this.f13797l;
        a0Var.f13773l = this.f13798m;
        a0Var.f13774m = (byte) 1;
        return a0Var;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        m2 m2Var;
        s1 s1Var;
        p1 p1Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof n2) {
            b0 b0Var = (b0) ((n2) obj);
            p1 p1Var2 = b0Var.f13798m;
            s1 s1Var2 = b0Var.f13797l;
            m2 m2Var2 = b0Var.f13796k;
            String str4 = b0Var.f13794h;
            String str5 = b0Var.f13793g;
            String str6 = b0Var.f;
            if (this.f13789b.equals(b0Var.f13789b) && this.f13790c.equals(b0Var.f13790c) && this.f13791d == b0Var.f13791d && this.f13792e.equals(b0Var.f13792e) && ((str = this.f) != null ? str.equals(str6) : str6 == null) && ((str2 = this.f13793g) != null ? str2.equals(str5) : str5 == null) && ((str3 = this.f13794h) != null ? str3.equals(str4) : str4 == null) && this.i.equals(b0Var.i) && this.f13795j.equals(b0Var.f13795j) && ((m2Var = this.f13796k) != null ? m2Var.equals(m2Var2) : m2Var2 == null) && ((s1Var = this.f13797l) != null ? s1Var.equals(s1Var2) : s1Var2 == null) && ((p1Var = this.f13798m) != null ? p1Var.equals(p1Var2) : p1Var2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f13789b.hashCode() ^ 1000003) * 1000003) ^ this.f13790c.hashCode()) * 1000003) ^ this.f13791d) * 1000003) ^ this.f13792e.hashCode()) * 1000003;
        String str = this.f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f13793g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f13794h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.f13795j.hashCode()) * 1000003;
        m2 m2Var = this.f13796k;
        int iHashCode5 = (iHashCode4 ^ (m2Var == null ? 0 : m2Var.hashCode())) * 1000003;
        s1 s1Var = this.f13797l;
        int iHashCode6 = (iHashCode5 ^ (s1Var == null ? 0 : s1Var.hashCode())) * 1000003;
        p1 p1Var = this.f13798m;
        return iHashCode6 ^ (p1Var != null ? p1Var.hashCode() : 0);
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f13789b + ", gmpAppId=" + this.f13790c + ", platform=" + this.f13791d + ", installationUuid=" + this.f13792e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.f13793g + ", appQualitySessionId=" + this.f13794h + ", buildVersion=" + this.i + ", displayVersion=" + this.f13795j + ", session=" + this.f13796k + ", ndkPayload=" + this.f13797l + ", appExitInfo=" + this.f13798m + "}";
    }
}
