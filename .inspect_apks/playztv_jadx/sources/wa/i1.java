package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13896d;

    public i1(int i, String str, String str2, boolean z2) {
        this.f13893a = i;
        this.f13894b = str;
        this.f13895c = str2;
        this.f13896d = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k2) {
            i1 i1Var = (i1) ((k2) obj);
            if (this.f13893a == i1Var.f13893a && this.f13894b.equals(i1Var.f13894b) && this.f13895c.equals(i1Var.f13895c) && this.f13896d == i1Var.f13896d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f13893a ^ 1000003) * 1000003) ^ this.f13894b.hashCode()) * 1000003) ^ this.f13895c.hashCode()) * 1000003) ^ (this.f13896d ? 1231 : 1237);
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f13893a + ", version=" + this.f13894b + ", buildVersion=" + this.f13895c + ", jailbroken=" + this.f13896d + "}";
    }
}
