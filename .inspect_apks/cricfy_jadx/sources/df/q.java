package df;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f3731a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3732b = new o("kotlin.String", bf.b.f1911h);

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        return kVar.p();
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        String str = (String) obj;
        ge.i.e(str, "value");
        lVar.j(str);
    }

    @Override // ze.a
    public final bf.d d() {
        return f3732b;
    }
}
