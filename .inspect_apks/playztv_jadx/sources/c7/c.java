package c7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2531a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2532b = new gb.c("eventsDroppedCount", l4.a.r(l4.a.q(jb.e.class, new jb.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2533c = new gb.c("reason", l4.a.r(l4.a.q(jb.e.class, new jb.a(3))));

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        f7.d dVar = (f7.d) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.d(f2532b, dVar.f4801a);
        eVar.g(f2533c, dVar.f4802b);
    }
}
