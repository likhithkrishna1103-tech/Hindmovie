package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f13799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13803e;
    public final long f;

    public b1(Double d10, int i, boolean z2, int i10, long j5, long j8) {
        this.f13799a = d10;
        this.f13800b = i;
        this.f13801c = z2;
        this.f13802d = i10;
        this.f13803e = j5;
        this.f = j8;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e2) {
            e2 e2Var = (e2) obj;
            Double d10 = this.f13799a;
            if (d10 != null ? d10.equals(((b1) e2Var).f13799a) : ((b1) e2Var).f13799a == null) {
                b1 b1Var = (b1) e2Var;
                if (this.f13800b == b1Var.f13800b && this.f13801c == b1Var.f13801c && this.f13802d == b1Var.f13802d && this.f13803e == b1Var.f13803e && this.f == b1Var.f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Double d10 = this.f13799a;
        int iHashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f13800b) * 1000003) ^ (this.f13801c ? 1231 : 1237)) * 1000003) ^ this.f13802d) * 1000003;
        long j5 = this.f13803e;
        long j8 = this.f;
        return ((iHashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Device{batteryLevel=");
        sb2.append(this.f13799a);
        sb2.append(", batteryVelocity=");
        sb2.append(this.f13800b);
        sb2.append(", proximityOn=");
        sb2.append(this.f13801c);
        sb2.append(", orientation=");
        sb2.append(this.f13802d);
        sb2.append(", ramUsed=");
        sb2.append(this.f13803e);
        sb2.append(", diskUsed=");
        return l4.a.n(sb2, this.f, "}");
    }
}
