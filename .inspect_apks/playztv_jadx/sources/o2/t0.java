package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9215b;

    public t0(int i, boolean z2) {
        this.f9214a = i;
        this.f9215b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t0.class != obj.getClass()) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f9214a == t0Var.f9214a && this.f9215b == t0Var.f9215b;
    }

    public final int hashCode() {
        return (this.f9214a * 31) + (this.f9215b ? 1 : 0);
    }
}
