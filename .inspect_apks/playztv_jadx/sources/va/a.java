package va;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13429a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f13430b = gb.c.a("rolloutId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f13431c = gb.c.a("parameterKey");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f13432d = gb.c.a("parameterValue");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f13433e = gb.c.a("variantId");
    public static final gb.c f = gb.c.a("templateVersion");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        b bVar = (b) ((n) obj);
        eVar.g(f13430b, bVar.f13434b);
        eVar.g(f13431c, bVar.f13435c);
        eVar.g(f13432d, bVar.f13436d);
        eVar.g(f13433e, bVar.f13437e);
        eVar.d(f, bVar.f);
    }
}
