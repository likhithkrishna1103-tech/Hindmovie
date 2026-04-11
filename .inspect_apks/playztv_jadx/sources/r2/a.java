package r2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11291b;

    public a(long j5, long j8) {
        this.f11290a = j5;
        this.f11291b = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11290a == aVar.f11290a && this.f11291b == aVar.f11291b;
    }

    public final int hashCode() {
        return (((int) this.f11290a) * 31) + ((int) this.f11291b);
    }
}
