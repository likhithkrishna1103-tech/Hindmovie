package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10484a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f10485b = ac.c.a("pid");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f10486c = ac.c.a("processName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f10487d = ac.c.a("reasonCode");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f10488e = ac.c.a("importance");
    public static final ac.c f = ac.c.a("pss");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f10489g = ac.c.a("rss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ac.c f10490h = ac.c.a("timestamp");
    public static final ac.c i = ac.c.a("traceFile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ac.c f10491j = ac.c.a("buildIdMappingForArch");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        ac.e eVar = (ac.e) obj2;
        d0 d0Var = (d0) ((p1) obj);
        eVar.c(f10485b, d0Var.f10530a);
        eVar.g(f10486c, d0Var.f10531b);
        eVar.c(f10487d, d0Var.f10532c);
        eVar.c(f10488e, d0Var.f10533d);
        eVar.d(f, d0Var.f10534e);
        eVar.d(f10489g, d0Var.f);
        eVar.d(f10490h, d0Var.f10535g);
        eVar.g(i, d0Var.f10536h);
        eVar.g(f10491j, d0Var.i);
    }
}
