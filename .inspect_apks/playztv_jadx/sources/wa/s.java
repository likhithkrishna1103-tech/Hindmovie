package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f14016a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f14017b = gb.c.a("batteryLevel");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f14018c = gb.c.a("batteryVelocity");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f14019d = gb.c.a("proximityOn");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f14020e = gb.c.a("orientation");
    public static final gb.c f = gb.c.a("ramUsed");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f14021g = gb.c.a("diskUsed");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        b1 b1Var = (b1) ((e2) obj);
        eVar.g(f14017b, b1Var.f13799a);
        eVar.b(f14018c, b1Var.f13800b);
        eVar.c(f14019d, b1Var.f13801c);
        eVar.b(f14020e, b1Var.f13802d);
        eVar.d(f, b1Var.f13803e);
        eVar.d(f14021g, b1Var.f);
    }
}
