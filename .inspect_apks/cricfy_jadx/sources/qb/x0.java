package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10768e;

    public x0(long j4, String str, String str2, long j7, int i) {
        this.f10764a = j4;
        this.f10765b = str;
        this.f10766c = str2;
        this.f10767d = j7;
        this.f10768e = i;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof z1) {
            x0 x0Var = (x0) ((z1) obj);
            String str2 = x0Var.f10766c;
            if (this.f10764a == x0Var.f10764a && this.f10765b.equals(x0Var.f10765b) && ((str = this.f10766c) != null ? str.equals(str2) : str2 == null) && this.f10767d == x0Var.f10767d && this.f10768e == x0Var.f10768e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f10764a;
        int iHashCode = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f10765b.hashCode()) * 1000003;
        String str = this.f10766c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j7 = this.f10767d;
        return ((iHashCode2 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f10768e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Frame{pc=");
        sb.append(this.f10764a);
        sb.append(", symbol=");
        sb.append(this.f10765b);
        sb.append(", file=");
        sb.append(this.f10766c);
        sb.append(", offset=");
        sb.append(this.f10767d);
        sb.append(", importance=");
        return q4.a.o(sb, this.f10768e, "}");
    }
}
