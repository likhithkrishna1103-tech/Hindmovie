package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13844c;

    public e0(String str, String str2, String str3) {
        this.f13842a = str;
        this.f13843b = str2;
        this.f13844c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o1) {
            e0 e0Var = (e0) ((o1) obj);
            if (this.f13842a.equals(e0Var.f13842a) && this.f13843b.equals(e0Var.f13843b) && this.f13844c.equals(e0Var.f13844c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f13842a.hashCode() ^ 1000003) * 1000003) ^ this.f13843b.hashCode()) * 1000003) ^ this.f13844c.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BuildIdMappingForArch{arch=");
        sb2.append(this.f13842a);
        sb2.append(", libraryName=");
        sb2.append(this.f13843b);
        sb2.append(", buildId=");
        return l4.a.o(sb2, this.f13844c, "}");
    }
}
