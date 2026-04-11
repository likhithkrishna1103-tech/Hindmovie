package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f13601d;

    public d0(String str, int i, int i10, boolean z10) {
        this.f13598a = str;
        this.f13599b = i;
        this.f13600c = i10;
        this.f13601d = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return ge.i.a(this.f13598a, d0Var.f13598a) && this.f13599b == d0Var.f13599b && this.f13600c == d0Var.f13600c && this.f13601d == d0Var.f13601d;
    }

    public final int hashCode() {
        return (((((this.f13598a.hashCode() * 31) + this.f13599b) * 31) + this.f13600c) * 31) + (this.f13601d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails(processName=" + this.f13598a + ", pid=" + this.f13599b + ", importance=" + this.f13600c + ", isDefaultProcess=" + this.f13601d + ')';
    }
}
