package w2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f13600c = new c0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13602b;

    public c0(long j5, long j8) {
        this.f13601a = j5;
        this.f13602b = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c0.class == obj.getClass()) {
            c0 c0Var = (c0) obj;
            if (this.f13601a == c0Var.f13601a && this.f13602b == c0Var.f13602b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f13601a) * 31) + ((int) this.f13602b);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[timeUs=");
        sb2.append(this.f13601a);
        sb2.append(", position=");
        return l4.a.n(sb2, this.f13602b, "]");
    }
}
