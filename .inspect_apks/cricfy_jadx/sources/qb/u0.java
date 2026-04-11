package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10745c;

    public u0(long j4, String str, String str2) {
        this.f10743a = str;
        this.f10744b = str2;
        this.f10745c = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y1) {
            u0 u0Var = (u0) ((y1) obj);
            if (this.f10743a.equals(u0Var.f10743a) && this.f10744b.equals(u0Var.f10744b) && this.f10745c == u0Var.f10745c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f10743a.hashCode() ^ 1000003) * 1000003) ^ this.f10744b.hashCode()) * 1000003;
        long j4 = this.f10745c;
        return iHashCode ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Signal{name=");
        sb.append(this.f10743a);
        sb.append(", code=");
        sb.append(this.f10744b);
        sb.append(", address=");
        return q4.a.p(sb, this.f10745c, "}");
    }
}
