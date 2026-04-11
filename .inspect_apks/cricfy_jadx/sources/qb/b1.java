package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f10502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10506e;
    public final long f;

    public b1(Double d10, int i, boolean z10, int i10, long j4, long j7) {
        this.f10502a = d10;
        this.f10503b = i;
        this.f10504c = z10;
        this.f10505d = i10;
        this.f10506e = j4;
        this.f = j7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e2) {
            e2 e2Var = (e2) obj;
            Double d10 = this.f10502a;
            if (d10 != null ? d10.equals(((b1) e2Var).f10502a) : ((b1) e2Var).f10502a == null) {
                b1 b1Var = (b1) e2Var;
                if (this.f10503b == b1Var.f10503b && this.f10504c == b1Var.f10504c && this.f10505d == b1Var.f10505d && this.f10506e == b1Var.f10506e && this.f == b1Var.f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Double d10 = this.f10502a;
        int iHashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f10503b) * 1000003) ^ (this.f10504c ? 1231 : 1237)) * 1000003) ^ this.f10505d) * 1000003;
        long j4 = this.f10506e;
        long j7 = this.f;
        return ((iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{batteryLevel=");
        sb.append(this.f10502a);
        sb.append(", batteryVelocity=");
        sb.append(this.f10503b);
        sb.append(", proximityOn=");
        sb.append(this.f10504c);
        sb.append(", orientation=");
        sb.append(this.f10505d);
        sb.append(", ramUsed=");
        sb.append(this.f10506e);
        sb.append(", diskUsed=");
        return q4.a.p(sb, this.f, "}");
    }
}
