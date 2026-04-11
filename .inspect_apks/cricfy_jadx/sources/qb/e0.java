package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10547c;

    public e0(String str, String str2, String str3) {
        this.f10545a = str;
        this.f10546b = str2;
        this.f10547c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o1) {
            e0 e0Var = (e0) ((o1) obj);
            if (this.f10545a.equals(e0Var.f10545a) && this.f10546b.equals(e0Var.f10546b) && this.f10547c.equals(e0Var.f10547c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f10545a.hashCode() ^ 1000003) * 1000003) ^ this.f10546b.hashCode()) * 1000003) ^ this.f10547c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BuildIdMappingForArch{arch=");
        sb.append(this.f10545a);
        sb.append(", libraryName=");
        sb.append(this.f10546b);
        sb.append(", buildId=");
        return q4.a.q(sb, this.f10547c, "}");
    }
}
