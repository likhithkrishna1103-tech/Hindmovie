package w7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f14088a;

    public o(r rVar) {
        z zVar = z.f14110v;
        this.f14088a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        if (!this.f14088a.equals(((o) ((a0) obj)).f14088a)) {
            return false;
        }
        Object obj2 = z.f14110v;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.f14088a.hashCode() ^ 1000003) * 1000003) ^ z.f14110v.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f14088a + ", productIdOrigin=" + z.f14110v + "}";
    }
}
