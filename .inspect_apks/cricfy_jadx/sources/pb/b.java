package pb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10151e;
    public final long f;

    public b(String str, String str2, String str3, String str4, long j4) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f10148b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f10149c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f10150d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f10151e = str4;
        this.f = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            b bVar = (b) ((m) obj);
            if (this.f10148b.equals(bVar.f10148b) && this.f10149c.equals(bVar.f10149c) && this.f10150d.equals(bVar.f10150d) && this.f10151e.equals(bVar.f10151e) && this.f == bVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f10148b.hashCode() ^ 1000003) * 1000003) ^ this.f10149c.hashCode()) * 1000003) ^ this.f10150d.hashCode()) * 1000003) ^ this.f10151e.hashCode()) * 1000003;
        long j4 = this.f;
        return iHashCode ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutId=");
        sb.append(this.f10148b);
        sb.append(", parameterKey=");
        sb.append(this.f10149c);
        sb.append(", parameterValue=");
        sb.append(this.f10150d);
        sb.append(", variantId=");
        sb.append(this.f10151e);
        sb.append(", templateVersion=");
        return q4.a.p(sb, this.f, "}");
    }
}
