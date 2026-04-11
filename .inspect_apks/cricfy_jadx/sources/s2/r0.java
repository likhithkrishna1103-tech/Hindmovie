package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11301b;

    public r0(int i, boolean z10) {
        this.f11300a = i;
        this.f11301b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r0.class != obj.getClass()) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f11300a == r0Var.f11300a && this.f11301b == r0Var.f11301b;
    }

    public final int hashCode() {
        return (this.f11300a * 31) + (this.f11301b ? 1 : 0);
    }
}
