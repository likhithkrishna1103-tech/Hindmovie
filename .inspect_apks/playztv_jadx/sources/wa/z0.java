package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14081d;

    public z0(int i, int i10, String str, boolean z2) {
        this.f14078a = str;
        this.f14079b = i;
        this.f14080c = i10;
        this.f14081d = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c2) {
            z0 z0Var = (z0) ((c2) obj);
            if (this.f14078a.equals(z0Var.f14078a) && this.f14079b == z0Var.f14079b && this.f14080c == z0Var.f14080c && this.f14081d == z0Var.f14081d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f14078a.hashCode() ^ 1000003) * 1000003) ^ this.f14079b) * 1000003) ^ this.f14080c) * 1000003) ^ (this.f14081d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails{processName=" + this.f14078a + ", pid=" + this.f14079b + ", importance=" + this.f14080c + ", defaultProcess=" + this.f14081d + "}";
    }
}
