package androidx.navigation;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f1325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1328d;

    public d(y yVar, boolean z10, Object obj, boolean z11) {
        if (!yVar.f1411a && z10) {
            throw new IllegalArgumentException(yVar.b().concat(" does not allow nullable values"));
        }
        if (!z10 && z11 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + yVar.b() + " has null value but is not nullable.");
        }
        this.f1325a = yVar;
        this.f1326b = z10;
        this.f1328d = obj;
        this.f1327c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            Object obj2 = dVar.f1328d;
            if (this.f1326b != dVar.f1326b || this.f1327c != dVar.f1327c || !this.f1325a.equals(dVar.f1325a)) {
                return false;
            }
            Object obj3 = this.f1328d;
            if (obj3 != null) {
                return obj3.equals(obj2);
            }
            if (obj2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.f1325a.hashCode() * 31) + (this.f1326b ? 1 : 0)) * 31) + (this.f1327c ? 1 : 0)) * 31;
        Object obj = this.f1328d;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }
}
