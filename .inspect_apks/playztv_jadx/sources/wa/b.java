package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13781a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f13782b = gb.c.a("pid");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f13783c = gb.c.a("processName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f13784d = gb.c.a("reasonCode");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f13785e = gb.c.a("importance");
    public static final gb.c f = gb.c.a("pss");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f13786g = gb.c.a("rss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gb.c f13787h = gb.c.a("timestamp");
    public static final gb.c i = gb.c.a("traceFile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gb.c f13788j = gb.c.a("buildIdMappingForArch");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        d0 d0Var = (d0) ((p1) obj);
        eVar.b(f13782b, d0Var.f13827a);
        eVar.g(f13783c, d0Var.f13828b);
        eVar.b(f13784d, d0Var.f13829c);
        eVar.b(f13785e, d0Var.f13830d);
        eVar.d(f, d0Var.f13831e);
        eVar.d(f13786g, d0Var.f);
        eVar.d(f13787h, d0Var.f13832g);
        eVar.g(i, d0Var.f13833h);
        eVar.g(f13788j, d0Var.i);
    }
}
