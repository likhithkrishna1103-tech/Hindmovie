package be;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f2043a;

    public j(Class cls) {
        this.f2043a = cls;
    }

    @Override // be.d
    public final Class a() {
        return this.f2043a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return h.a(this.f2043a, ((j) obj).f2043a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2043a.hashCode();
    }

    public final String toString() {
        return this.f2043a + " (Kotlin reflection is not available)";
    }
}
