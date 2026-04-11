package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2 f10695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e2 f10696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f2 f10697e;
    public final i2 f;

    public p0(long j4, String str, d2 d2Var, e2 e2Var, f2 f2Var, i2 i2Var) {
        this.f10693a = j4;
        this.f10694b = str;
        this.f10695c = d2Var;
        this.f10696d = e2Var;
        this.f10697e = f2Var;
        this.f = i2Var;
    }

    public final o0 a() {
        o0 o0Var = new o0();
        o0Var.f10683a = this.f10693a;
        o0Var.f10684b = this.f10694b;
        o0Var.f10685c = this.f10695c;
        o0Var.f10686d = this.f10696d;
        o0Var.f10687e = this.f10697e;
        o0Var.f = this.f;
        o0Var.f10688g = (byte) 1;
        return o0Var;
    }

    public final boolean equals(Object obj) {
        f2 f2Var;
        i2 i2Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof j2) {
            p0 p0Var = (p0) ((j2) obj);
            i2 i2Var2 = p0Var.f;
            f2 f2Var2 = p0Var.f10697e;
            if (this.f10693a == p0Var.f10693a && this.f10694b.equals(p0Var.f10694b) && this.f10695c.equals(p0Var.f10695c) && this.f10696d.equals(p0Var.f10696d) && ((f2Var = this.f10697e) != null ? f2Var.equals(f2Var2) : f2Var2 == null) && ((i2Var = this.f) != null ? i2Var.equals(i2Var2) : i2Var2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f10693a;
        int iHashCode = (((((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f10694b.hashCode()) * 1000003) ^ this.f10695c.hashCode()) * 1000003) ^ this.f10696d.hashCode()) * 1000003;
        f2 f2Var = this.f10697e;
        int iHashCode2 = (iHashCode ^ (f2Var == null ? 0 : f2Var.hashCode())) * 1000003;
        i2 i2Var = this.f;
        return iHashCode2 ^ (i2Var != null ? i2Var.hashCode() : 0);
    }

    public final String toString() {
        return "Event{timestamp=" + this.f10693a + ", type=" + this.f10694b + ", app=" + this.f10695c + ", device=" + this.f10696d + ", log=" + this.f10697e + ", rollouts=" + this.f + "}";
    }
}
