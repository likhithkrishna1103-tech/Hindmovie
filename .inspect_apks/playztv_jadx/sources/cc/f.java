package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2628a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2629b = gb.c.a("processName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2630c = gb.c.a("pid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f2631d = gb.c.a("importance");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f2632e = gb.c.a("defaultProcess");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        s sVar = (s) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.g(f2629b, sVar.f2706a);
        eVar.b(f2630c, sVar.f2707b);
        eVar.b(f2631d, sVar.f2708c);
        eVar.c(f2632e, sVar.f2709d);
    }
}
