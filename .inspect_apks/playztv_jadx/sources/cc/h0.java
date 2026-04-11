package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f2653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2654b;

    public h0(p0 p0Var, b bVar) {
        this.f2653a = p0Var;
        this.f2654b = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f2653a.equals(h0Var.f2653a) && this.f2654b.equals(h0Var.f2654b);
    }

    public final int hashCode() {
        return this.f2654b.hashCode() + ((this.f2653a.hashCode() + (k.f2665v.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SessionEvent(eventType=" + k.f2665v + ", sessionData=" + this.f2653a + ", applicationInfo=" + this.f2654b + ')';
    }
}
