package i7;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.a f6444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6445b;

    public a(l7.a aVar, HashMap map) {
        this.f6444a = aVar;
        this.f6445b = map;
    }

    public final long a(z6.d dVar, long j5, int i) {
        long jG = j5 - this.f6444a.g();
        b bVar = (b) this.f6445b.get(dVar);
        long j8 = bVar.f6446a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * j8 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j8 > 1 ? j8 : 2L) * ((long) r12)))), jG), bVar.f6447b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6444a.equals(aVar.f6444a) && this.f6445b.equals(aVar.f6445b);
    }

    public final int hashCode() {
        return ((this.f6444a.hashCode() ^ 1000003) * 1000003) ^ this.f6445b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f6444a + ", values=" + this.f6445b + "}";
    }
}
