package o4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f9503a;

    public g(b bVar) {
        ge.i.e(bVar, "latestEvent");
        this.f9503a = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && g.class == obj.getClass() && ge.i.a(this.f9503a, ((g) obj).f9503a);
    }

    public final int hashCode() {
        return this.f9503a.hashCode() - 31;
    }

    public final String toString() {
        return "InProgress(latestEvent=" + this.f9503a + ", direction=-1)";
    }
}
