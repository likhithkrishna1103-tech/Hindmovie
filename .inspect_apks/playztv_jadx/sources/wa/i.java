package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f13874a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f13875b = gb.c.a("arch");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f13876c = gb.c.a("model");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f13877d = gb.c.a("cores");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f13878e = gb.c.a("ram");
    public static final gb.c f = gb.c.a("diskSpace");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f13879g = gb.c.a("simulator");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gb.c f13880h = gb.c.a("state");
    public static final gb.c i = gb.c.a("manufacturer");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gb.c f13881j = gb.c.a("modelClass");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        n0 n0Var = (n0) ((v1) obj);
        eVar.b(f13875b, n0Var.f13967a);
        eVar.g(f13876c, n0Var.f13968b);
        eVar.b(f13877d, n0Var.f13969c);
        eVar.d(f13878e, n0Var.f13970d);
        eVar.d(f, n0Var.f13971e);
        eVar.c(f13879g, n0Var.f);
        eVar.b(f13880h, n0Var.f13972g);
        eVar.g(i, n0Var.f13973h);
        eVar.g(f13881j, n0Var.i);
    }
}
