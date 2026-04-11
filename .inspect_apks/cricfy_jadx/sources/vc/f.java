package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13611a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f13612b = ac.c.a("processName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f13613c = ac.c.a("pid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f13614d = ac.c.a("importance");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f13615e = ac.c.a("defaultProcess");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        d0 d0Var = (d0) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.g(f13612b, d0Var.f13598a);
        eVar.c(f13613c, d0Var.f13599b);
        eVar.c(f13614d, d0Var.f13600c);
        eVar.a(f13615e, d0Var.f13601d);
    }
}
