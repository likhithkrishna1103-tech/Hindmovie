package c7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2538a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2539b = new gb.c("currentCacheSizeBytes", l4.a.r(l4.a.q(jb.e.class, new jb.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2540c = new gb.c("maxCacheSizeBytes", l4.a.r(l4.a.q(jb.e.class, new jb.a(2))));

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        f7.f fVar = (f7.f) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.d(f2539b, fVar.f4806a);
        eVar.d(f2540c, fVar.f4807b);
    }
}
