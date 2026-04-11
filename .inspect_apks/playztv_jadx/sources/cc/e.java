package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f2622a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2623b = gb.c.a("performance");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2624c = gb.c.a("crashlytics");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f2625d = gb.c.a("sessionSamplingRate");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        j jVar = (j) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.g(f2623b, jVar.f2662a);
        eVar.g(f2624c, jVar.f2663b);
        eVar.a(f2625d, jVar.f2664c);
    }
}
