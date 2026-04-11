package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2 f13845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13848d;

    public e1(f1 f1Var, String str, String str2, long j5) {
        this.f13845a = f1Var;
        this.f13846b = str;
        this.f13847c = str2;
        this.f13848d = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h2) {
            e1 e1Var = (e1) ((h2) obj);
            if (this.f13845a.equals(e1Var.f13845a) && this.f13846b.equals(e1Var.f13846b) && this.f13847c.equals(e1Var.f13847c) && this.f13848d == e1Var.f13848d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f13845a.hashCode() ^ 1000003) * 1000003) ^ this.f13846b.hashCode()) * 1000003) ^ this.f13847c.hashCode()) * 1000003;
        long j5 = this.f13848d;
        return iHashCode ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RolloutAssignment{rolloutVariant=");
        sb2.append(this.f13845a);
        sb2.append(", parameterKey=");
        sb2.append(this.f13846b);
        sb2.append(", parameterValue=");
        sb2.append(this.f13847c);
        sb2.append(", templateVersion=");
        return l4.a.n(sb2, this.f13848d, "}");
    }
}
