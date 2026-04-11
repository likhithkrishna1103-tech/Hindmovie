package df;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f3708a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3709b = new o("kotlin.Long", bf.b.f1910g);

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        return Long.valueOf(kVar.j());
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        lVar.d(((Number) obj).longValue());
    }

    @Override // ze.a
    public final bf.d d() {
        return f3709b;
    }
}
