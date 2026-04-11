package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2638a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2639b = gb.c.a("eventType");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2640c = gb.c.a("sessionData");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f2641d = gb.c.a("applicationInfo");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        h0 h0Var = (h0) obj;
        gb.e eVar = (gb.e) obj2;
        h0Var.getClass();
        eVar.g(f2639b, k.f2665v);
        eVar.g(f2640c, h0Var.f2653a);
        eVar.g(f2641d, h0Var.f2654b);
    }
}
