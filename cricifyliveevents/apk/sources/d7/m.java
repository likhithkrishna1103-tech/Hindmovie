package d7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3496a;

    public m(String str) {
        this.f3496a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f3496a.equals(((m) obj).f3496a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3496a.hashCode();
    }

    public final String toString() {
        return q4.a.q(new StringBuilder("StringHeaderFactory{value='"), this.f3496a, "'}");
    }
}
