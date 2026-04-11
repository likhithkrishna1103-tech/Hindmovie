package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10728d;

    public s0(long j4, long j7, String str, String str2) {
        this.f10725a = j4;
        this.f10726b = j7;
        this.f10727c = str;
        this.f10728d = str2;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof w1) {
            s0 s0Var = (s0) ((w1) obj);
            String str2 = s0Var.f10728d;
            if (this.f10725a == s0Var.f10725a && this.f10726b == s0Var.f10726b && this.f10727c.equals(s0Var.f10727c) && ((str = this.f10728d) != null ? str.equals(str2) : str2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f10725a;
        long j7 = this.f10726b;
        int iHashCode = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f10727c.hashCode()) * 1000003;
        String str = this.f10728d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BinaryImage{baseAddress=");
        sb.append(this.f10725a);
        sb.append(", size=");
        sb.append(this.f10726b);
        sb.append(", name=");
        sb.append(this.f10727c);
        sb.append(", uuid=");
        return q4.a.q(sb, this.f10728d, "}");
    }
}
