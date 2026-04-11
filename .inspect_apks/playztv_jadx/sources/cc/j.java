package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f2662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f2663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f2664c;

    public j(i iVar, i iVar2, double d10) {
        this.f2662a = iVar;
        this.f2663b = iVar2;
        this.f2664c = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f2662a == jVar.f2662a && this.f2663b == jVar.f2663b && Double.compare(this.f2664c, jVar.f2664c) == 0;
    }

    public final int hashCode() {
        int iHashCode = (this.f2663b.hashCode() + (this.f2662a.hashCode() * 31)) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f2664c);
        return iHashCode + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public final String toString() {
        return "DataCollectionStatus(performance=" + this.f2662a + ", crashlytics=" + this.f2663b + ", sessionSamplingRate=" + this.f2664c + ')';
    }
}
