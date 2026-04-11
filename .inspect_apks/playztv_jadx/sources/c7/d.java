package c7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2534a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2535b = new gb.c("logSource", l4.a.r(l4.a.q(jb.e.class, new jb.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2536c = new gb.c("logEventDropped", l4.a.r(l4.a.q(jb.e.class, new jb.a(2))));

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        f7.e eVar = (f7.e) obj;
        gb.e eVar2 = (gb.e) obj2;
        eVar2.g(f2535b, eVar.f4804a);
        eVar2.g(f2536c, eVar.f4805b);
    }
}
