package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2645d;

    public g0(String str, String str2, int i, long j5) {
        be.h.e(str, "sessionId");
        be.h.e(str2, "firstSessionId");
        this.f2642a = str;
        this.f2643b = str2;
        this.f2644c = i;
        this.f2645d = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return be.h.a(this.f2642a, g0Var.f2642a) && be.h.a(this.f2643b, g0Var.f2643b) && this.f2644c == g0Var.f2644c && this.f2645d == g0Var.f2645d;
    }

    public final int hashCode() {
        int iH = (e6.j.h(this.f2642a.hashCode() * 31, 31, this.f2643b) + this.f2644c) * 31;
        long j5 = this.f2645d;
        return iH + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f2642a + ", firstSessionId=" + this.f2643b + ", sessionIndex=" + this.f2644c + ", sessionStartTimestampUs=" + this.f2645d + ')';
    }
}
