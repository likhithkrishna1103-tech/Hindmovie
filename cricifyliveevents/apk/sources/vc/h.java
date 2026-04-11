package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f13625a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f13626b = ac.c.a("sessionId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f13627c = ac.c.a("firstSessionId");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f13628d = ac.c.a("sessionIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f13629e = ac.c.a("eventTimestampUs");
    public static final ac.c f = ac.c.a("dataCollectionStatus");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f13630g = ac.c.a("firebaseInstallationId");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ac.c f13631h = ac.c.a("firebaseAuthenticationToken");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        t0 t0Var = (t0) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.g(f13626b, t0Var.f13694a);
        eVar.g(f13627c, t0Var.f13695b);
        eVar.c(f13628d, t0Var.f13696c);
        eVar.d(f13629e, t0Var.f13697d);
        eVar.g(f, t0Var.f13698e);
        eVar.g(f13630g, t0Var.f);
        eVar.g(f13631h, t0Var.f13699g);
    }
}
