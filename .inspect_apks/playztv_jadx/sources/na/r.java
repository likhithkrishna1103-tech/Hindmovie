package na;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f8914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f8915b;

    public r(Class cls, Class cls2) {
        this.f8914a = cls;
        this.f8915b = cls2;
    }

    public static r a(Class cls) {
        return new r(q.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f8915b.equals(rVar.f8915b)) {
            return this.f8914a.equals(rVar.f8914a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8914a.hashCode() + (this.f8915b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f8915b;
        Class cls2 = this.f8914a;
        if (cls2 == q.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
