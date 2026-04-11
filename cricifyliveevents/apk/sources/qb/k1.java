package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f10634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f10635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1 f10636c;

    public k1(l1 l1Var, n1 n1Var, m1 m1Var) {
        this.f10634a = l1Var;
        this.f10635b = n1Var;
        this.f10636c = m1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k1) {
            k1 k1Var = (k1) obj;
            if (this.f10634a.equals(k1Var.f10634a) && this.f10635b.equals(k1Var.f10635b) && this.f10636c.equals(k1Var.f10636c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f10634a.hashCode() ^ 1000003) * 1000003) ^ this.f10635b.hashCode()) * 1000003) ^ this.f10636c.hashCode();
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.f10634a + ", osData=" + this.f10635b + ", deviceData=" + this.f10636c + "}";
    }
}
