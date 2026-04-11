package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13853b;

    public f0(String str, String str2) {
        this.f13852a = str;
        this.f13853b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q1) {
            f0 f0Var = (f0) ((q1) obj);
            if (this.f13852a.equals(f0Var.f13852a) && this.f13853b.equals(f0Var.f13853b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f13852a.hashCode() ^ 1000003) * 1000003) ^ this.f13853b.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CustomAttribute{key=");
        sb2.append(this.f13852a);
        sb2.append(", value=");
        return l4.a.o(sb2, this.f13853b, "}");
    }
}
