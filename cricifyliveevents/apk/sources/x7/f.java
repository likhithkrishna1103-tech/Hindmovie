package x7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14420a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f14421b = new ac.c("currentCacheSizeBytes", l0.e.o(l0.e.n(dc.e.class, new dc.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f14422c = new ac.c("maxCacheSizeBytes", l0.e.o(l0.e.n(dc.e.class, new dc.a(2))));

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        a8.f fVar = (a8.f) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.d(f14421b, fVar.f354a);
        eVar.d(f14422c, fVar.f355b);
    }
}
