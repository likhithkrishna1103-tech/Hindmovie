package x7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14423a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f14424b = new ac.c("startMs", l0.e.o(l0.e.n(dc.e.class, new dc.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f14425c = new ac.c("endMs", l0.e.o(l0.e.n(dc.e.class, new dc.a(2))));

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        a8.g gVar = (a8.g) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.d(f14424b, gVar.f356a);
        eVar.d(f14425c, gVar.f357b);
    }
}
