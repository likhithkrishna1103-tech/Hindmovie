package z9;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f14910u;

    public j(Object obj) {
        this.f14910u = obj;
    }

    @Override // z9.g
    public final Object a() {
        return this.f14910u;
    }

    @Override // z9.g
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f14910u.equals(((j) obj).f14910u);
        }
        return false;
    }

    public final int hashCode() {
        return this.f14910u.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f14910u + ")";
    }
}
