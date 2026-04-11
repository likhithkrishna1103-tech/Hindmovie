package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2 f10548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10551d;

    public e1(f1 f1Var, String str, String str2, long j4) {
        this.f10548a = f1Var;
        this.f10549b = str;
        this.f10550c = str2;
        this.f10551d = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h2) {
            e1 e1Var = (e1) ((h2) obj);
            if (this.f10548a.equals(e1Var.f10548a) && this.f10549b.equals(e1Var.f10549b) && this.f10550c.equals(e1Var.f10550c) && this.f10551d == e1Var.f10551d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f10548a.hashCode() ^ 1000003) * 1000003) ^ this.f10549b.hashCode()) * 1000003) ^ this.f10550c.hashCode()) * 1000003;
        long j4 = this.f10551d;
        return iHashCode ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutVariant=");
        sb.append(this.f10548a);
        sb.append(", parameterKey=");
        sb.append(this.f10549b);
        sb.append(", parameterValue=");
        sb.append(this.f10550c);
        sb.append(", templateVersion=");
        return q4.a.p(sb, this.f10551d, "}");
    }
}
