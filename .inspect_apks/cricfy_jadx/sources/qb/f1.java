package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10558b;

    public f1(String str, String str2) {
        this.f10557a = str;
        this.f10558b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g2) {
            f1 f1Var = (f1) ((g2) obj);
            if (this.f10557a.equals(f1Var.f10557a) && this.f10558b.equals(f1Var.f10558b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f10557a.hashCode() ^ 1000003) * 1000003) ^ this.f10558b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutVariant{rolloutId=");
        sb.append(this.f10557a);
        sb.append(", variantId=");
        return q4.a.q(sb, this.f10558b, "}");
    }
}
