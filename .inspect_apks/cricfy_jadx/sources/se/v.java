package se;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements c, te.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ x f11715v;

    public v(x xVar) {
        this.f11715v = xVar;
    }

    @Override // te.e
    public final c j(vd.h hVar, int i, re.a aVar) {
        return ((((i < 0 || i >= 2) && i != -2) || aVar != re.a.f11005w) && !((i == 0 || i == -3) && aVar == re.a.f11004v)) ? new b(this, hVar, i, aVar, 1) : this;
    }

    @Override // se.c
    public final Object z(d dVar, xd.c cVar) throws Throwable {
        this.f11715v.z(dVar, cVar);
        return wd.a.f14143v;
    }
}
