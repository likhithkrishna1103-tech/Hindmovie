package bc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2007e;
    public final long f;

    public c(String str, String str2, String str3, String str4, long j5) {
        this.f2004b = str;
        this.f2005c = str2;
        this.f2006d = str3;
        this.f2007e = str4;
        this.f = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            c cVar = (c) ((e) obj);
            if (this.f2004b.equals(cVar.f2004b) && this.f2005c.equals(cVar.f2005c) && this.f2006d.equals(cVar.f2006d) && this.f2007e.equals(cVar.f2007e) && this.f == cVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f2004b.hashCode() ^ 1000003) * 1000003) ^ this.f2005c.hashCode()) * 1000003) ^ this.f2006d.hashCode()) * 1000003) ^ this.f2007e.hashCode()) * 1000003;
        long j5 = this.f;
        return iHashCode ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RolloutAssignment{rolloutId=");
        sb2.append(this.f2004b);
        sb2.append(", variantId=");
        sb2.append(this.f2005c);
        sb2.append(", parameterKey=");
        sb2.append(this.f2006d);
        sb2.append(", parameterValue=");
        sb2.append(this.f2007e);
        sb2.append(", templateVersion=");
        return l4.a.n(sb2, this.f, "}");
    }
}
