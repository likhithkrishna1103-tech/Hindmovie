package c2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f2309d = new bb.b().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2312c;

    public g(bb.b bVar) {
        this.f2310a = bVar.f1977a;
        this.f2311b = bVar.f1978b;
        this.f2312c = bVar.f1979c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2310a == gVar.f2310a && this.f2311b == gVar.f2311b && this.f2312c == gVar.f2312c;
    }

    public final int hashCode() {
        return ((this.f2310a ? 1 : 0) << 2) + ((this.f2311b ? 1 : 0) << 1) + (this.f2312c ? 1 : 0);
    }
}
