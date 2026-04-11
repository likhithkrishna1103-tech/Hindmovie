package u7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12280a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f12280a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f12280a.equals(((c) obj).f12280a);
    }

    public final int hashCode() {
        return this.f12280a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return q4.a.q(new StringBuilder("Encoding{name=\""), this.f12280a, "\"}");
    }
}
