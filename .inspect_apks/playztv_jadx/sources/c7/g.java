package c7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2541a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2542b = new gb.c("startMs", l4.a.r(l4.a.q(jb.e.class, new jb.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2543c = new gb.c("endMs", l4.a.r(l4.a.q(jb.e.class, new jb.a(2))));

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        f7.g gVar = (f7.g) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.d(f2542b, gVar.f4808a);
        eVar.d(f2543c, gVar.f4809b);
    }
}
