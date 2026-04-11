package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10621a;

    public j1(String str) {
        this.f10621a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        return this.f10621a.equals(((j1) ((l2) obj)).f10621a);
    }

    public final int hashCode() {
        return this.f10621a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return q4.a.q(new StringBuilder("User{identifier="), this.f10621a, "}");
    }
}
