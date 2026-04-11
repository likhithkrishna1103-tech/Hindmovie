package q4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10740d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            int i = this.f10737a;
            if (i != aVar.f10737a) {
                return false;
            }
            if (i != 8 || Math.abs(this.f10740d - this.f10738b) != 1 || this.f10740d != aVar.f10738b || this.f10738b != aVar.f10740d) {
                if (this.f10740d != aVar.f10740d || this.f10738b != aVar.f10738b) {
                    return false;
                }
                Object obj2 = this.f10739c;
                if (obj2 != null) {
                    if (!obj2.equals(aVar.f10739c)) {
                        return false;
                    }
                } else if (aVar.f10739c != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f10737a * 31) + this.f10738b) * 31) + this.f10740d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[");
        int i = this.f10737a;
        sb2.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb2.append(",s:");
        sb2.append(this.f10738b);
        sb2.append("c:");
        sb2.append(this.f10740d);
        sb2.append(",p:");
        sb2.append(this.f10739c);
        sb2.append("]");
        return sb2.toString();
    }
}
