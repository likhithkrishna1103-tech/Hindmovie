package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f10719a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f10720b = ac.c.a("batteryLevel");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f10721c = ac.c.a("batteryVelocity");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f10722d = ac.c.a("proximityOn");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f10723e = ac.c.a("orientation");
    public static final ac.c f = ac.c.a("ramUsed");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f10724g = ac.c.a("diskUsed");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        ac.e eVar = (ac.e) obj2;
        b1 b1Var = (b1) ((e2) obj);
        eVar.g(f10720b, b1Var.f10502a);
        eVar.c(f10721c, b1Var.f10503b);
        eVar.a(f10722d, b1Var.f10504c);
        eVar.c(f10723e, b1Var.f10505d);
        eVar.d(f, b1Var.f10506e);
        eVar.d(f10724g, b1Var.f);
    }
}
