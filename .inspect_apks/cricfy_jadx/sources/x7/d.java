package x7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14416a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f14417b = new ac.c("logSource", l0.e.o(l0.e.n(dc.e.class, new dc.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f14418c = new ac.c("logEventDropped", l0.e.o(l0.e.n(dc.e.class, new dc.a(2))));

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        a8.e eVar = (a8.e) obj;
        ac.e eVar2 = (ac.e) obj2;
        eVar2.g(f14417b, eVar.f352a);
        eVar2.g(f14418c, eVar.f353b);
    }
}
