package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10637a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f10638b = ac.c.a("baseAddress");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f10639c = ac.c.a("size");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f10640d = ac.c.a("name");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f10641e = ac.c.a("uuid");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        ac.e eVar = (ac.e) obj2;
        s0 s0Var = (s0) ((w1) obj);
        eVar.d(f10638b, s0Var.f10725a);
        eVar.d(f10639c, s0Var.f10726b);
        eVar.g(f10640d, s0Var.f10727c);
        String str = s0Var.f10728d;
        eVar.g(f10641e, str != null ? str.getBytes(n2.f10678a) : null);
    }
}
