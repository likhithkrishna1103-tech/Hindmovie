package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14065e;

    public x0(long j5, String str, String str2, long j8, int i) {
        this.f14061a = j5;
        this.f14062b = str;
        this.f14063c = str2;
        this.f14064d = j8;
        this.f14065e = i;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof z1) {
            x0 x0Var = (x0) ((z1) obj);
            String str2 = x0Var.f14063c;
            if (this.f14061a == x0Var.f14061a && this.f14062b.equals(x0Var.f14062b) && ((str = this.f14063c) != null ? str.equals(str2) : str2 == null) && this.f14064d == x0Var.f14064d && this.f14065e == x0Var.f14065e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f14061a;
        int iHashCode = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f14062b.hashCode()) * 1000003;
        String str = this.f14063c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j8 = this.f14064d;
        return ((iHashCode2 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f14065e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Frame{pc=");
        sb2.append(this.f14061a);
        sb2.append(", symbol=");
        sb2.append(this.f14062b);
        sb2.append(", file=");
        sb2.append(this.f14063c);
        sb2.append(", offset=");
        sb2.append(this.f14064d);
        sb2.append(", importance=");
        return x.c.a(sb2, this.f14065e, "}");
    }
}
