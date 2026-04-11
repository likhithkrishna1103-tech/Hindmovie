package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    public static final j0 Companion = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13659d;

    public /* synthetic */ k0(int i, String str, String str2, int i10, long j4) {
        if (15 != (i & 15)) {
            df.k.a(i, 15, i0.f13647a.d());
            throw null;
        }
        this.f13656a = str;
        this.f13657b = str2;
        this.f13658c = i10;
        this.f13659d = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return ge.i.a(this.f13656a, k0Var.f13656a) && ge.i.a(this.f13657b, k0Var.f13657b) && this.f13658c == k0Var.f13658c && this.f13659d == k0Var.f13659d;
    }

    public final int hashCode() {
        int iE = (l0.e.e(this.f13656a.hashCode() * 31, 31, this.f13657b) + this.f13658c) * 31;
        long j4 = this.f13659d;
        return iE + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f13656a + ", firstSessionId=" + this.f13657b + ", sessionIndex=" + this.f13658c + ", sessionStartTimestampUs=" + this.f13659d + ')';
    }

    public k0(String str, String str2, int i, long j4) {
        this.f13656a = str;
        this.f13657b = str2;
        this.f13658c = i;
        this.f13659d = j4;
    }
}
