package z6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f14888c;

    public a(Object obj, d dVar, b bVar) {
        this.f14886a = obj;
        this.f14887b = dVar;
        this.f14888c = bVar;
    }

    public final boolean equals(Object obj) {
        b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            b bVar2 = aVar.f14888c;
            if (this.f14886a.equals(aVar.f14886a) && this.f14887b.equals(aVar.f14887b) && ((bVar = this.f14888c) != null ? bVar.equals(bVar2) : bVar2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f14886a.hashCode()) * 1000003) ^ this.f14887b.hashCode()) * 1000003;
        b bVar = this.f14888c;
        return (iHashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f14886a + ", priority=" + this.f14887b + ", productData=" + this.f14888c + ", eventContext=null}";
    }
}
