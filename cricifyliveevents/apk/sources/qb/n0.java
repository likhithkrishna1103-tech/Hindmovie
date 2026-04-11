package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10674e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f10676h;
    public final String i;

    public n0(int i, String str, int i10, long j4, long j7, boolean z10, int i11, String str2, String str3) {
        this.f10670a = i;
        this.f10671b = str;
        this.f10672c = i10;
        this.f10673d = j4;
        this.f10674e = j7;
        this.f = z10;
        this.f10675g = i11;
        this.f10676h = str2;
        this.i = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            n0 n0Var = (n0) ((v1) obj);
            if (this.f10670a == n0Var.f10670a && this.f10671b.equals(n0Var.f10671b) && this.f10672c == n0Var.f10672c && this.f10673d == n0Var.f10673d && this.f10674e == n0Var.f10674e && this.f == n0Var.f && this.f10675g == n0Var.f10675g && this.f10676h.equals(n0Var.f10676h) && this.i.equals(n0Var.i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f10670a ^ 1000003) * 1000003) ^ this.f10671b.hashCode()) * 1000003) ^ this.f10672c) * 1000003;
        long j4 = this.f10673d;
        int i = (iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j7 = this.f10674e;
        return ((((((((i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.f10675g) * 1000003) ^ this.f10676h.hashCode()) * 1000003) ^ this.i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{arch=");
        sb.append(this.f10670a);
        sb.append(", model=");
        sb.append(this.f10671b);
        sb.append(", cores=");
        sb.append(this.f10672c);
        sb.append(", ram=");
        sb.append(this.f10673d);
        sb.append(", diskSpace=");
        sb.append(this.f10674e);
        sb.append(", simulator=");
        sb.append(this.f);
        sb.append(", state=");
        sb.append(this.f10675g);
        sb.append(", manufacturer=");
        sb.append(this.f10676h);
        sb.append(", modelClass=");
        return q4.a.q(sb, this.i, "}");
    }
}
