package u7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f12277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12278c;

    public a(Object obj, d dVar, b bVar) {
        this.f12276a = obj;
        this.f12277b = dVar;
        this.f12278c = bVar;
    }

    public final boolean equals(Object obj) {
        b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            b bVar2 = aVar.f12278c;
            if (this.f12276a.equals(aVar.f12276a) && this.f12277b.equals(aVar.f12277b) && ((bVar = this.f12278c) != null ? bVar.equals(bVar2) : bVar2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f12276a.hashCode()) * 1000003) ^ this.f12277b.hashCode()) * 1000003;
        b bVar = this.f12278c;
        return (iHashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f12276a + ", priority=" + this.f12277b + ", productData=" + this.f12278c + ", eventContext=null}";
    }
}
