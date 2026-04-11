package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13897a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f13898b = gb.c.a("generator");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f13899c = gb.c.a("identifier");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f13900d = gb.c.a("appQualitySessionId");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f13901e = gb.c.a("startedAt");
    public static final gb.c f = gb.c.a("endedAt");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f13902g = gb.c.a("crashed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gb.c f13903h = gb.c.a("app");
    public static final gb.c i = gb.c.a("user");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gb.c f13904j = gb.c.a("os");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final gb.c f13905k = gb.c.a("device");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final gb.c f13906l = gb.c.a("events");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final gb.c f13907m = gb.c.a("generatorType");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        j0 j0Var = (j0) ((m2) obj);
        eVar.g(f13898b, j0Var.f13908a);
        eVar.g(f13899c, j0Var.f13909b.getBytes(n2.f13975a));
        eVar.g(f13900d, j0Var.f13910c);
        eVar.d(f13901e, j0Var.f13911d);
        eVar.g(f, j0Var.f13912e);
        eVar.c(f13902g, j0Var.f);
        eVar.g(f13903h, j0Var.f13913g);
        eVar.g(i, j0Var.f13914h);
        eVar.g(f13904j, j0Var.i);
        eVar.g(f13905k, j0Var.f13915j);
        eVar.g(f13906l, j0Var.f13916k);
        eVar.b(f13907m, j0Var.f13917l);
    }
}
