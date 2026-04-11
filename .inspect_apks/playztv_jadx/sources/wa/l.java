package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f13934a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f13935b = gb.c.a("baseAddress");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f13936c = gb.c.a("size");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f13937d = gb.c.a("name");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f13938e = gb.c.a("uuid");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        s0 s0Var = (s0) ((w1) obj);
        eVar.d(f13935b, s0Var.f14022a);
        eVar.d(f13936c, s0Var.f14023b);
        eVar.g(f13937d, s0Var.f14024c);
        String str = s0Var.f14025d;
        eVar.g(f13938e, str != null ? str.getBytes(n2.f13975a) : null);
    }
}
