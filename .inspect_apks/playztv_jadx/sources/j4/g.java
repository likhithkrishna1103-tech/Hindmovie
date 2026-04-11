package j4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends q1.c {
    public final b f;

    public g(b bVar) {
        be.h.e(bVar, "latestEvent");
        this.f = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && g.class == obj.getClass() && be.h.a(this.f, ((g) obj).f);
    }

    public final int hashCode() {
        return this.f.hashCode() - 31;
    }

    public final String toString() {
        return "InProgress(latestEvent=" + this.f + ", direction=-1)";
    }
}
