package w7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f14106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f14107b;

    public v(h0 h0Var, g0 g0Var) {
        this.f14106a = h0Var;
        this.f14107b = g0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            h0 h0Var = this.f14106a;
            if (h0Var != null ? h0Var.equals(((v) i0Var).f14106a) : ((v) i0Var).f14106a == null) {
                g0 g0Var = this.f14107b;
                if (g0Var != null ? g0Var.equals(((v) i0Var).f14107b) : ((v) i0Var).f14107b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        h0 h0Var = this.f14106a;
        int iHashCode = ((h0Var == null ? 0 : h0Var.hashCode()) ^ 1000003) * 1000003;
        g0 g0Var = this.f14107b;
        return (g0Var != null ? g0Var.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f14106a + ", mobileSubtype=" + this.f14107b + "}";
    }
}
