package te;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements vd.c, xd.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vd.c f12029v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final vd.h f12030w;

    public k(vd.c cVar, vd.h hVar) {
        this.f12029v = cVar;
        this.f12030w = hVar;
    }

    @Override // xd.d
    public final xd.d d() {
        vd.c cVar = this.f12029v;
        if (cVar instanceof xd.d) {
            return (xd.d) cVar;
        }
        return null;
    }

    @Override // vd.c
    public final vd.h h() {
        return this.f12030w;
    }

    @Override // vd.c
    public final void i(Object obj) {
        this.f12029v.i(obj);
    }
}
