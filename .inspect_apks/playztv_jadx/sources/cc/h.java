package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f2646a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2647b = gb.c.a("sessionId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2648c = gb.c.a("firstSessionId");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f2649d = gb.c.a("sessionIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f2650e = gb.c.a("eventTimestampUs");
    public static final gb.c f = gb.c.a("dataCollectionStatus");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f2651g = gb.c.a("firebaseInstallationId");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gb.c f2652h = gb.c.a("firebaseAuthenticationToken");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        p0 p0Var = (p0) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.g(f2647b, p0Var.f2692a);
        eVar.g(f2648c, p0Var.f2693b);
        eVar.b(f2649d, p0Var.f2694c);
        eVar.d(f2650e, p0Var.f2695d);
        eVar.g(f, p0Var.f2696e);
        eVar.g(f2651g, p0Var.f);
        eVar.g(f2652h, p0Var.f2697g);
    }
}
