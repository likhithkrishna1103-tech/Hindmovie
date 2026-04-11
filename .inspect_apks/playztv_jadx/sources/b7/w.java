package b7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f1918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f1919b;

    public w(i0 i0Var, h0 h0Var) {
        this.f1918a = i0Var;
        this.f1919b = h0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j0) {
            j0 j0Var = (j0) obj;
            i0 i0Var = this.f1918a;
            if (i0Var != null ? i0Var.equals(((w) j0Var).f1918a) : ((w) j0Var).f1918a == null) {
                h0 h0Var = this.f1919b;
                if (h0Var != null ? h0Var.equals(((w) j0Var).f1919b) : ((w) j0Var).f1919b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        i0 i0Var = this.f1918a;
        int iHashCode = ((i0Var == null ? 0 : i0Var.hashCode()) ^ 1000003) * 1000003;
        h0 h0Var = this.f1919b;
        return (h0Var != null ? h0Var.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f1918a + ", mobileSubtype=" + this.f1919b + "}";
    }
}
