package rd;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b f10990w = new b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10991v = 131605;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b bVar = (b) obj;
        ge.i.e(bVar, "other");
        return this.f10991v - bVar.f10991v;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        b bVar = obj instanceof b ? (b) obj : null;
        return bVar != null && this.f10991v == bVar.f10991v;
    }

    public final int hashCode() {
        return this.f10991v;
    }

    public final String toString() {
        return "2.2.21";
    }
}
