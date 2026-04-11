package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2 f13992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e2 f13993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f2 f13994e;
    public final i2 f;

    public p0(long j5, String str, d2 d2Var, e2 e2Var, f2 f2Var, i2 i2Var) {
        this.f13990a = j5;
        this.f13991b = str;
        this.f13992c = d2Var;
        this.f13993d = e2Var;
        this.f13994e = f2Var;
        this.f = i2Var;
    }

    public final o0 a() {
        o0 o0Var = new o0();
        o0Var.f13980a = this.f13990a;
        o0Var.f13981b = this.f13991b;
        o0Var.f13982c = this.f13992c;
        o0Var.f13983d = this.f13993d;
        o0Var.f13984e = this.f13994e;
        o0Var.f = this.f;
        o0Var.f13985g = (byte) 1;
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
            f2 f2Var2 = p0Var.f13994e;
            if (this.f13990a == p0Var.f13990a && this.f13991b.equals(p0Var.f13991b) && this.f13992c.equals(p0Var.f13992c) && this.f13993d.equals(p0Var.f13993d) && ((f2Var = this.f13994e) != null ? f2Var.equals(f2Var2) : f2Var2 == null) && ((i2Var = this.f) != null ? i2Var.equals(i2Var2) : i2Var2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f13990a;
        int iHashCode = (((((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f13991b.hashCode()) * 1000003) ^ this.f13992c.hashCode()) * 1000003) ^ this.f13993d.hashCode()) * 1000003;
        f2 f2Var = this.f13994e;
        int iHashCode2 = (iHashCode ^ (f2Var == null ? 0 : f2Var.hashCode())) * 1000003;
        i2 i2Var = this.f;
        return iHashCode2 ^ (i2Var != null ? i2Var.hashCode() : 0);
    }

    public final String toString() {
        return "Event{timestamp=" + this.f13990a + ", type=" + this.f13991b + ", app=" + this.f13992c + ", device=" + this.f13993d + ", log=" + this.f13994e + ", rollouts=" + this.f + "}";
    }
}
