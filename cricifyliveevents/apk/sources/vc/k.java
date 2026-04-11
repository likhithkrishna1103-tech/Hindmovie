package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f13653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f13654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f13655c;

    public k(j jVar, j jVar2, double d10) {
        this.f13653a = jVar;
        this.f13654b = jVar2;
        this.f13655c = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f13653a == kVar.f13653a && this.f13654b == kVar.f13654b && Double.compare(this.f13655c, kVar.f13655c) == 0;
    }

    public final int hashCode() {
        int iHashCode = (this.f13654b.hashCode() + (this.f13653a.hashCode() * 31)) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f13655c);
        return iHashCode + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public final String toString() {
        return "DataCollectionStatus(performance=" + this.f13653a + ", crashlytics=" + this.f13654b + ", sessionSamplingRate=" + this.f13655c + ')';
    }
}
