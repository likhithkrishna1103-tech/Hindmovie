package a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f157c = new d0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f159b;

    public d0(long j4, long j7) {
        this.f158a = j4;
        this.f159b = j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d0.class == obj.getClass()) {
            d0 d0Var = (d0) obj;
            if (this.f158a == d0Var.f158a && this.f159b == d0Var.f159b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f158a) * 31) + ((int) this.f159b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[timeUs=");
        sb.append(this.f158a);
        sb.append(", position=");
        return q4.a.p(sb, this.f159b, "]");
    }
}
