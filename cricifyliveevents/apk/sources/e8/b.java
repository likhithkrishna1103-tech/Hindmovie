package e8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x7.i f3833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x7.h f3834c;

    public b(long j4, x7.i iVar, x7.h hVar) {
        this.f3832a = j4;
        this.f3833b = iVar;
        this.f3834c = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f3832a == bVar.f3832a && this.f3833b.equals(bVar.f3833b) && this.f3834c.equals(bVar.f3834c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f3832a;
        return ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f3833b.hashCode()) * 1000003) ^ this.f3834c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f3832a + ", transportContext=" + this.f3833b + ", event=" + this.f3834c + "}";
    }
}
