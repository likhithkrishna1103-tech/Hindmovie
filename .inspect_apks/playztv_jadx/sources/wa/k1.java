package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f13931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f13932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1 f13933c;

    public k1(l1 l1Var, n1 n1Var, m1 m1Var) {
        this.f13931a = l1Var;
        this.f13932b = n1Var;
        this.f13933c = m1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k1) {
            k1 k1Var = (k1) obj;
            if (this.f13931a.equals(k1Var.f13931a) && this.f13932b.equals(k1Var.f13932b) && this.f13933c.equals(k1Var.f13933c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f13931a.hashCode() ^ 1000003) * 1000003) ^ this.f13932b.hashCode()) * 1000003) ^ this.f13933c.hashCode();
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.f13931a + ", osData=" + this.f13932b + ", deviceData=" + this.f13933c + "}";
    }
}
