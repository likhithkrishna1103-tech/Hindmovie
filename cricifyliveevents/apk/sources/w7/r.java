package w7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f14092a;

    public r(q qVar) {
        this.f14092a = qVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        return this.f14092a.equals(((r) ((d0) obj)).f14092a);
    }

    public final int hashCode() {
        return this.f14092a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f14092a + "}";
    }
}
