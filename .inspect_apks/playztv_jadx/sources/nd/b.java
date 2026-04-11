package nd;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b f8980v = new b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f8981u = 131338;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b bVar = (b) obj;
        be.h.e(bVar, "other");
        return this.f8981u - bVar.f8981u;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        b bVar = obj instanceof b ? (b) obj : null;
        return bVar != null && this.f8981u == bVar.f8981u;
    }

    public final int hashCode() {
        return this.f8981u;
    }

    public final String toString() {
        return "2.1.10";
    }
}
