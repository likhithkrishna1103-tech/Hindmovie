package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f14006a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f14007b = gb.c.a("processName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f14008c = gb.c.a("pid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f14009d = gb.c.a("importance");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f14010e = gb.c.a("defaultProcess");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        z0 z0Var = (z0) ((c2) obj);
        eVar.g(f14007b, z0Var.f14078a);
        eVar.b(f14008c, z0Var.f14079b);
        eVar.b(f14009d, z0Var.f14080c);
        eVar.c(f14010e, z0Var.f14081d);
    }
}
