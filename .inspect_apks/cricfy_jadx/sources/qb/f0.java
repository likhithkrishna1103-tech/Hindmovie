package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10556b;

    public f0(String str, String str2) {
        this.f10555a = str;
        this.f10556b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q1) {
            f0 f0Var = (f0) ((q1) obj);
            if (this.f10555a.equals(f0Var.f10555a) && this.f10556b.equals(f0Var.f10556b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f10555a.hashCode() ^ 1000003) * 1000003) ^ this.f10556b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CustomAttribute{key=");
        sb.append(this.f10555a);
        sb.append(", value=");
        return q4.a.q(sb, this.f10556b, "}");
    }
}
