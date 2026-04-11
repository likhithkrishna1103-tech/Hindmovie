package x6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f14287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f14288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f14289c;

    public k(Class cls, Class cls2, Class cls3) {
        this.f14287a = cls;
        this.f14288b = cls2;
        this.f14289c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f14287a.equals(kVar.f14287a) && this.f14288b.equals(kVar.f14288b) && m.b(this.f14289c, kVar.f14289c);
    }

    public final int hashCode() {
        int iHashCode = (this.f14288b.hashCode() + (this.f14287a.hashCode() * 31)) * 31;
        Class cls = this.f14289c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f14287a + ", second=" + this.f14288b + '}';
    }
}
