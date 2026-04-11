package x7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14413a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f14414b = new ac.c("eventsDroppedCount", l0.e.o(l0.e.n(dc.e.class, new dc.a(1))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f14415c = new ac.c("reason", l0.e.o(l0.e.n(dc.e.class, new dc.a(3))));

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        a8.d dVar = (a8.d) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.d(f14414b, dVar.f349a);
        eVar.g(f14415c, dVar.f350b);
    }
}
