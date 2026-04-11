package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements vd.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vd.g f14838v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final z f14839w;

    public a(vd.g gVar, z zVar) {
        ge.i.e(zVar, "connectionWrapper");
        this.f14838v = gVar;
        this.f14839w = zVar;
    }

    @Override // vd.h
    public final vd.f C(vd.g gVar) {
        return w8.e.h(this, gVar);
    }

    @Override // vd.h
    public final Object J(Object obj, fe.p pVar) {
        return pVar.j(obj, this);
    }

    @Override // vd.h
    public final vd.h O(vd.g gVar) {
        return w8.e.i(this, gVar);
    }

    @Override // vd.f
    public final vd.g getKey() {
        return this.f14838v;
    }

    @Override // vd.h
    public final vd.h q(vd.h hVar) {
        return w8.e.k(this, hVar);
    }
}
