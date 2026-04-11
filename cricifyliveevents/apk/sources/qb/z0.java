package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10784d;

    public z0(String str, int i, int i10, boolean z10) {
        this.f10781a = str;
        this.f10782b = i;
        this.f10783c = i10;
        this.f10784d = z10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c2) {
            z0 z0Var = (z0) ((c2) obj);
            if (this.f10781a.equals(z0Var.f10781a) && this.f10782b == z0Var.f10782b && this.f10783c == z0Var.f10783c && this.f10784d == z0Var.f10784d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f10781a.hashCode() ^ 1000003) * 1000003) ^ this.f10782b) * 1000003) ^ this.f10783c) * 1000003) ^ (this.f10784d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails{processName=" + this.f10781a + ", pid=" + this.f10782b + ", importance=" + this.f10783c + ", defaultProcess=" + this.f10784d + "}";
    }
}
