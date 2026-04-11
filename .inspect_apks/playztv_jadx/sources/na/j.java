package na;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f8899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8901c;

    public j(int i, int i10, Class cls) {
        this(r.a(cls), i, i10);
    }

    public static j a(Class cls) {
        return new j(1, 0, cls);
    }

    public static j b(r rVar) {
        return new j(rVar, 1, 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f8899a.equals(jVar.f8899a) && this.f8900b == jVar.f8900b && this.f8901c == jVar.f8901c;
    }

    public final int hashCode() {
        return ((((this.f8899a.hashCode() ^ 1000003) * 1000003) ^ this.f8900b) * 1000003) ^ this.f8901c;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.f8899a);
        sb2.append(", type=");
        int i = this.f8900b;
        sb2.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb2.append(", injection=");
        int i10 = this.f8901c;
        if (i10 == 0) {
            str = "direct";
        } else if (i10 == 1) {
            str = "provider";
        } else {
            if (i10 != 2) {
                throw new AssertionError(e6.j.l("Unsupported injection: ", i10));
            }
            str = "deferred";
        }
        return l4.a.o(sb2, str, "}");
    }

    public j(r rVar, int i, int i10) {
        cf.l.i(rVar, "Null dependency anInterface.");
        this.f8899a = rVar;
        this.f8900b = i;
        this.f8901c = i10;
    }
}
