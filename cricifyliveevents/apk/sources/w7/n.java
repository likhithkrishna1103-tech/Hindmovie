package w7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f14087a;

    public n(l lVar) {
        this.f14087a = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        Object obj2 = x.f14108v;
        if (obj2.equals(obj2)) {
            return this.f14087a.equals(((n) yVar).f14087a);
        }
        return false;
    }

    public final int hashCode() {
        return ((x.f14108v.hashCode() ^ 1000003) * 1000003) ^ this.f14087a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + x.f14108v + ", androidClientInfo=" + this.f14087a + "}";
    }
}
