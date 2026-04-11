package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f14066a = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f14067b = gb.c.a("platform");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f14068c = gb.c.a("version");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f14069d = gb.c.a("buildVersion");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f14070e = gb.c.a("jailbroken");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        i1 i1Var = (i1) ((k2) obj);
        eVar.b(f14067b, i1Var.f13893a);
        eVar.g(f14068c, i1Var.f13894b);
        eVar.g(f14069d, i1Var.f13895c);
        eVar.c(f14070e, i1Var.f13896d);
    }
}
