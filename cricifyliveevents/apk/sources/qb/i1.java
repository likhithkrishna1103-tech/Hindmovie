package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10599d;

    public i1(int i, String str, String str2, boolean z10) {
        this.f10596a = i;
        this.f10597b = str;
        this.f10598c = str2;
        this.f10599d = z10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k2) {
            i1 i1Var = (i1) ((k2) obj);
            if (this.f10596a == i1Var.f10596a && this.f10597b.equals(i1Var.f10597b) && this.f10598c.equals(i1Var.f10598c) && this.f10599d == i1Var.f10599d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f10596a ^ 1000003) * 1000003) ^ this.f10597b.hashCode()) * 1000003) ^ this.f10598c.hashCode()) * 1000003) ^ (this.f10599d ? 1231 : 1237);
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f10596a + ", version=" + this.f10597b + ", buildVersion=" + this.f10598c + ", jailbroken=" + this.f10599d + "}";
    }
}
