package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13855b;

    public f1(String str, String str2) {
        this.f13854a = str;
        this.f13855b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g2) {
            f1 f1Var = (f1) ((g2) obj);
            if (this.f13854a.equals(f1Var.f13854a) && this.f13855b.equals(f1Var.f13855b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f13854a.hashCode() ^ 1000003) * 1000003) ^ this.f13855b.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RolloutVariant{rolloutId=");
        sb2.append(this.f13854a);
        sb2.append(", variantId=");
        return l4.a.o(sb2, this.f13855b, "}");
    }
}
