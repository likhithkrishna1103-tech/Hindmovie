package e2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4357b;

    public q(long j5, long j8) {
        this.f4356a = j5;
        this.f4357b = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q.class == obj.getClass()) {
            q qVar = (q) obj;
            if (this.f4356a == qVar.f4356a && this.f4357b == qVar.f4357b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f4356a) * 31) + ((int) this.f4357b);
    }
}
