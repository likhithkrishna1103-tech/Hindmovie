package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f13962a = new n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f13963b = gb.c.a("type");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f13964c = gb.c.a("reason");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f13965d = gb.c.a("frames");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f13966e = gb.c.a("causedBy");
    public static final gb.c f = gb.c.a("overflowCount");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        t0 t0Var = (t0) ((x1) obj);
        eVar.g(f13963b, t0Var.f14032a);
        eVar.g(f13964c, t0Var.f14033b);
        eVar.g(f13965d, t0Var.f14034c);
        eVar.g(f13966e, t0Var.f14035d);
        eVar.b(f, t0Var.f14036e);
    }
}
