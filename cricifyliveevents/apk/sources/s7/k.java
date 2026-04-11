package s7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f11603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f11604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f11605c;

    public k(Class cls, Class cls2, Class cls3) {
        this.f11603a = cls;
        this.f11604b = cls2;
        this.f11605c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f11603a.equals(kVar.f11603a) && this.f11604b.equals(kVar.f11604b) && m.b(this.f11605c, kVar.f11605c);
    }

    public final int hashCode() {
        int iHashCode = (this.f11604b.hashCode() + (this.f11603a.hashCode() * 31)) * 31;
        Class cls = this.f11605c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f11603a + ", second=" + this.f11604b + '}';
    }
}
