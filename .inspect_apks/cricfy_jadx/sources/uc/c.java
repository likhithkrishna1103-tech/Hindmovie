package uc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12447e;
    public final long f;

    public c(String str, String str2, String str3, String str4, long j4) {
        this.f12444b = str;
        this.f12445c = str2;
        this.f12446d = str3;
        this.f12447e = str4;
        this.f = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            c cVar = (c) ((e) obj);
            if (this.f12444b.equals(cVar.f12444b) && this.f12445c.equals(cVar.f12445c) && this.f12446d.equals(cVar.f12446d) && this.f12447e.equals(cVar.f12447e) && this.f == cVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f12444b.hashCode() ^ 1000003) * 1000003) ^ this.f12445c.hashCode()) * 1000003) ^ this.f12446d.hashCode()) * 1000003) ^ this.f12447e.hashCode()) * 1000003;
        long j4 = this.f;
        return iHashCode ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutId=");
        sb.append(this.f12444b);
        sb.append(", variantId=");
        sb.append(this.f12445c);
        sb.append(", parameterKey=");
        sb.append(this.f12446d);
        sb.append(", parameterValue=");
        sb.append(this.f12447e);
        sb.append(", templateVersion=");
        return q4.a.p(sb, this.f, "}");
    }
}
