package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10577a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f10578b = ac.c.a("arch");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f10579c = ac.c.a("model");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f10580d = ac.c.a("cores");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f10581e = ac.c.a("ram");
    public static final ac.c f = ac.c.a("diskSpace");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f10582g = ac.c.a("simulator");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ac.c f10583h = ac.c.a("state");
    public static final ac.c i = ac.c.a("manufacturer");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ac.c f10584j = ac.c.a("modelClass");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        ac.e eVar = (ac.e) obj2;
        n0 n0Var = (n0) ((v1) obj);
        eVar.c(f10578b, n0Var.f10670a);
        eVar.g(f10579c, n0Var.f10671b);
        eVar.c(f10580d, n0Var.f10672c);
        eVar.d(f10581e, n0Var.f10673d);
        eVar.d(f, n0Var.f10674e);
        eVar.a(f10582g, n0Var.f);
        eVar.c(f10583h, n0Var.f10675g);
        eVar.g(i, n0Var.f10676h);
        eVar.g(f10584j, n0Var.i);
    }
}
