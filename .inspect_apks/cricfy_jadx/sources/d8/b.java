package d8;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g8.a f3523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3524b;

    public b(g8.a aVar, HashMap map) {
        this.f3523a = aVar;
        this.f3524b = map;
    }

    public final long a(u7.d dVar, long j4, int i) {
        long jL = j4 - this.f3523a.l();
        c cVar = (c) this.f3524b.get(dVar);
        long j7 = cVar.f3525a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * j7 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j7 > 1 ? j7 : 2L) * ((long) r12)))), jL), cVar.f3526b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3523a.equals(bVar.f3523a) && this.f3524b.equals(bVar.f3524b);
    }

    public final int hashCode() {
        return ((this.f3523a.hashCode() ^ 1000003) * 1000003) ^ this.f3524b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f3523a + ", values=" + this.f3524b + "}";
    }
}
