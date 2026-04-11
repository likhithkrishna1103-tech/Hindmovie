package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f13698e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f13699g;

    public t0(String str, String str2, int i, long j4, k kVar, String str3, String str4) {
        ge.i.e(str, "sessionId");
        ge.i.e(str2, "firstSessionId");
        ge.i.e(str4, "firebaseAuthenticationToken");
        this.f13694a = str;
        this.f13695b = str2;
        this.f13696c = i;
        this.f13697d = j4;
        this.f13698e = kVar;
        this.f = str3;
        this.f13699g = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return ge.i.a(this.f13694a, t0Var.f13694a) && ge.i.a(this.f13695b, t0Var.f13695b) && this.f13696c == t0Var.f13696c && this.f13697d == t0Var.f13697d && ge.i.a(this.f13698e, t0Var.f13698e) && ge.i.a(this.f, t0Var.f) && ge.i.a(this.f13699g, t0Var.f13699g);
    }

    public final int hashCode() {
        int iE = (l0.e.e(this.f13694a.hashCode() * 31, 31, this.f13695b) + this.f13696c) * 31;
        long j4 = this.f13697d;
        return this.f13699g.hashCode() + l0.e.e((this.f13698e.hashCode() + ((iE + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31, 31, this.f);
    }

    public final String toString() {
        return "SessionInfo(sessionId=" + this.f13694a + ", firstSessionId=" + this.f13695b + ", sessionIndex=" + this.f13696c + ", eventTimestampUs=" + this.f13697d + ", dataCollectionStatus=" + this.f13698e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.f13699g + ')';
    }
}
