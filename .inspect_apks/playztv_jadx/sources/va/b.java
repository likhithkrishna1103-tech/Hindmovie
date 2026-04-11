package va;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13437e;
    public final long f;

    public b(String str, String str2, String str3, String str4, long j5) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f13434b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f13435c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f13436d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f13437e = str4;
        this.f = j5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            b bVar = (b) ((n) obj);
            if (this.f13434b.equals(bVar.f13434b) && this.f13435c.equals(bVar.f13435c) && this.f13436d.equals(bVar.f13436d) && this.f13437e.equals(bVar.f13437e) && this.f == bVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f13434b.hashCode() ^ 1000003) * 1000003) ^ this.f13435c.hashCode()) * 1000003) ^ this.f13436d.hashCode()) * 1000003) ^ this.f13437e.hashCode()) * 1000003;
        long j5 = this.f;
        return iHashCode ^ ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RolloutAssignment{rolloutId=");
        sb2.append(this.f13434b);
        sb2.append(", parameterKey=");
        sb2.append(this.f13435c);
        sb2.append(", parameterValue=");
        sb2.append(this.f13436d);
        sb2.append(", variantId=");
        sb2.append(this.f13437e);
        sb2.append(", templateVersion=");
        return l4.a.n(sb2, this.f, "}");
    }
}
