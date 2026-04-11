package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14025d;

    public s0(long j5, long j8, String str, String str2) {
        this.f14022a = j5;
        this.f14023b = j8;
        this.f14024c = str;
        this.f14025d = str2;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof w1) {
            s0 s0Var = (s0) ((w1) obj);
            String str2 = s0Var.f14025d;
            if (this.f14022a == s0Var.f14022a && this.f14023b == s0Var.f14023b && this.f14024c.equals(s0Var.f14024c) && ((str = this.f14025d) != null ? str.equals(str2) : str2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f14022a;
        long j8 = this.f14023b;
        int iHashCode = (((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f14024c.hashCode()) * 1000003;
        String str = this.f14025d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BinaryImage{baseAddress=");
        sb2.append(this.f14022a);
        sb2.append(", size=");
        sb2.append(this.f14023b);
        sb2.append(", name=");
        sb2.append(this.f14024c);
        sb2.append(", uuid=");
        return l4.a.o(sb2, this.f14025d, "}");
    }
}
