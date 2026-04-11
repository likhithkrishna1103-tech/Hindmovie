package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14042c;

    public u0(long j5, String str, String str2) {
        this.f14040a = str;
        this.f14041b = str2;
        this.f14042c = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y1) {
            u0 u0Var = (u0) ((y1) obj);
            if (this.f14040a.equals(u0Var.f14040a) && this.f14041b.equals(u0Var.f14041b) && this.f14042c == u0Var.f14042c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f14040a.hashCode() ^ 1000003) * 1000003) ^ this.f14041b.hashCode()) * 1000003;
        long j5 = this.f14042c;
        return iHashCode ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Signal{name=");
        sb2.append(this.f14040a);
        sb2.append(", code=");
        sb2.append(this.f14041b);
        sb2.append(", address=");
        return l4.a.n(sb2, this.f14042c, "}");
    }
}
