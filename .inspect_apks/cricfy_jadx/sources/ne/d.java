package ne;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ke.c f9142b;

    public d(String str, ke.c cVar) {
        this.f9141a = str;
        this.f9142b = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return ge.i.a(this.f9141a, dVar.f9141a) && ge.i.a(this.f9142b, dVar.f9142b);
    }

    public final int hashCode() {
        return this.f9142b.hashCode() + (this.f9141a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f9141a + ", range=" + this.f9142b + ')';
    }
}
