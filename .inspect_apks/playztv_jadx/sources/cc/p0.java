package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f2696e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f2697g;

    public p0(String str, String str2, int i, long j5, j jVar, String str3, String str4) {
        be.h.e(str, "sessionId");
        be.h.e(str2, "firstSessionId");
        be.h.e(str4, "firebaseAuthenticationToken");
        this.f2692a = str;
        this.f2693b = str2;
        this.f2694c = i;
        this.f2695d = j5;
        this.f2696e = jVar;
        this.f = str3;
        this.f2697g = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return be.h.a(this.f2692a, p0Var.f2692a) && be.h.a(this.f2693b, p0Var.f2693b) && this.f2694c == p0Var.f2694c && this.f2695d == p0Var.f2695d && be.h.a(this.f2696e, p0Var.f2696e) && be.h.a(this.f, p0Var.f) && be.h.a(this.f2697g, p0Var.f2697g);
    }

    public final int hashCode() {
        int iH = (e6.j.h(this.f2692a.hashCode() * 31, 31, this.f2693b) + this.f2694c) * 31;
        long j5 = this.f2695d;
        return this.f2697g.hashCode() + e6.j.h((this.f2696e.hashCode() + ((iH + ((int) (j5 ^ (j5 >>> 32)))) * 31)) * 31, 31, this.f);
    }

    public final String toString() {
        return "SessionInfo(sessionId=" + this.f2692a + ", firstSessionId=" + this.f2693b + ", sessionIndex=" + this.f2694c + ", eventTimestampUs=" + this.f2695d + ", dataCollectionStatus=" + this.f2696e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.f2697g + ')';
    }
}
