package b7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f1892a;

    public n(l lVar) {
        this.f1892a = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        Object obj2 = y.f1920u;
        if (obj2.equals(obj2)) {
            return this.f1892a.equals(((n) zVar).f1892a);
        }
        return false;
    }

    public final int hashCode() {
        return ((y.f1920u.hashCode() ^ 1000003) * 1000003) ^ this.f1892a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + y.f1920u + ", androidClientInfo=" + this.f1892a + "}";
    }
}
