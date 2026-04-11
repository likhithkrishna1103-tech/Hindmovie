package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10518a;

    public c1(String str) {
        this.f10518a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return this.f10518a.equals(((c1) ((f2) obj)).f10518a);
    }

    public final int hashCode() {
        return this.f10518a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return q4.a.q(new StringBuilder("Log{content="), this.f10518a, "}");
    }
}
