package bc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1994a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f1995b = gb.c.a("rolloutId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f1996c = gb.c.a("variantId");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f1997d = gb.c.a("parameterKey");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f1998e = gb.c.a("parameterValue");
    public static final gb.c f = gb.c.a("templateVersion");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        gb.e eVar = (gb.e) obj2;
        c cVar = (c) ((e) obj);
        eVar.g(f1995b, cVar.f2004b);
        eVar.g(f1996c, cVar.f2005c);
        eVar.g(f1997d, cVar.f2006d);
        eVar.g(f1998e, cVar.f2007e);
        eVar.d(f, cVar.f);
    }
}
