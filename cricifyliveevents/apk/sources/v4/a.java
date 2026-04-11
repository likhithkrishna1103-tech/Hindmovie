package v4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f13176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13177d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            int i = this.f13174a;
            if (i != aVar.f13174a) {
                return false;
            }
            if (i != 8 || Math.abs(this.f13177d - this.f13175b) != 1 || this.f13177d != aVar.f13175b || this.f13175b != aVar.f13177d) {
                if (this.f13177d != aVar.f13177d || this.f13175b != aVar.f13175b) {
                    return false;
                }
                Object obj2 = this.f13176c;
                if (obj2 != null) {
                    if (!obj2.equals(aVar.f13176c)) {
                        return false;
                    }
                } else if (aVar.f13176c != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f13174a * 31) + this.f13175b) * 31) + this.f13177d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i = this.f13174a;
        sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.f13175b);
        sb.append("c:");
        sb.append(this.f13177d);
        sb.append(",p:");
        sb.append(this.f13176c);
        sb.append("]");
        return sb.toString();
    }
}
