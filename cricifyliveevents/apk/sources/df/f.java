package df;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f3702a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3703b = new o("kotlin.Int", bf.b.f);

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        return Integer.valueOf(kVar.h());
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        lVar.c(((Number) obj).intValue());
    }

    @Override // ze.a
    public final bf.d d() {
        return f3703b;
    }
}
