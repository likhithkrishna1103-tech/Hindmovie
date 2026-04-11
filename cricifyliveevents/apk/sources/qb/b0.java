package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends n2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10495e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f10497h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f10498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m2 f10499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s1 f10500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p1 f10501m;

    public b0(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, m2 m2Var, s1 s1Var, p1 p1Var) {
        this.f10492b = str;
        this.f10493c = str2;
        this.f10494d = i;
        this.f10495e = str3;
        this.f = str4;
        this.f10496g = str5;
        this.f10497h = str6;
        this.i = str7;
        this.f10498j = str8;
        this.f10499k = m2Var;
        this.f10500l = s1Var;
        this.f10501m = p1Var;
    }

    public final a0 a() {
        a0 a0Var = new a0();
        a0Var.f10467a = this.f10492b;
        a0Var.f10468b = this.f10493c;
        a0Var.f10469c = this.f10494d;
        a0Var.f10470d = this.f10495e;
        a0Var.f10471e = this.f;
        a0Var.f = this.f10496g;
        a0Var.f10472g = this.f10497h;
        a0Var.f10473h = this.i;
        a0Var.i = this.f10498j;
        a0Var.f10474j = this.f10499k;
        a0Var.f10475k = this.f10500l;
        a0Var.f10476l = this.f10501m;
        a0Var.f10477m = (byte) 1;
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
            p1 p1Var2 = b0Var.f10501m;
            s1 s1Var2 = b0Var.f10500l;
            m2 m2Var2 = b0Var.f10499k;
            String str4 = b0Var.f10497h;
            String str5 = b0Var.f10496g;
            String str6 = b0Var.f;
            if (this.f10492b.equals(b0Var.f10492b) && this.f10493c.equals(b0Var.f10493c) && this.f10494d == b0Var.f10494d && this.f10495e.equals(b0Var.f10495e) && ((str = this.f) != null ? str.equals(str6) : str6 == null) && ((str2 = this.f10496g) != null ? str2.equals(str5) : str5 == null) && ((str3 = this.f10497h) != null ? str3.equals(str4) : str4 == null) && this.i.equals(b0Var.i) && this.f10498j.equals(b0Var.f10498j) && ((m2Var = this.f10499k) != null ? m2Var.equals(m2Var2) : m2Var2 == null) && ((s1Var = this.f10500l) != null ? s1Var.equals(s1Var2) : s1Var2 == null) && ((p1Var = this.f10501m) != null ? p1Var.equals(p1Var2) : p1Var2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f10492b.hashCode() ^ 1000003) * 1000003) ^ this.f10493c.hashCode()) * 1000003) ^ this.f10494d) * 1000003) ^ this.f10495e.hashCode()) * 1000003;
        String str = this.f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f10496g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10497h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.f10498j.hashCode()) * 1000003;
        m2 m2Var = this.f10499k;
        int iHashCode5 = (iHashCode4 ^ (m2Var == null ? 0 : m2Var.hashCode())) * 1000003;
        s1 s1Var = this.f10500l;
        int iHashCode6 = (iHashCode5 ^ (s1Var == null ? 0 : s1Var.hashCode())) * 1000003;
        p1 p1Var = this.f10501m;
        return iHashCode6 ^ (p1Var != null ? p1Var.hashCode() : 0);
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f10492b + ", gmpAppId=" + this.f10493c + ", platform=" + this.f10494d + ", installationUuid=" + this.f10495e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.f10496g + ", appQualitySessionId=" + this.f10497h + ", buildVersion=" + this.i + ", displayVersion=" + this.f10498j + ", session=" + this.f10499k + ", ndkPayload=" + this.f10500l + ", appExitInfo=" + this.f10501m + "}";
    }
}
