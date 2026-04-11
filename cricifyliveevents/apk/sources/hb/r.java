package hb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f5910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f5911b;

    public r(Class cls, Class cls2) {
        this.f5910a = cls;
        this.f5911b = cls2;
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
        if (this.f5911b.equals(rVar.f5911b)) {
            return this.f5910a.equals(rVar.f5910a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5910a.hashCode() + (this.f5911b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f5911b;
        Class cls2 = this.f5910a;
        if (cls2 == q.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
