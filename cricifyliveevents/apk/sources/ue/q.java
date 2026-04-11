package ue;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class q extends pe.a implements xd.d {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final vd.c f12483y;

    public q(vd.c cVar, vd.h hVar) {
        super(hVar, true);
        this.f12483y = cVar;
    }

    @Override // pe.c1
    public final boolean M() {
        return true;
    }

    @Override // xd.d
    public final xd.d d() {
        vd.c cVar = this.f12483y;
        if (cVar instanceof xd.d) {
            return (xd.d) cVar;
        }
        return null;
    }

    @Override // pe.c1
    public void j(Object obj) {
        a.h(pe.x.m(obj), u8.a.t(this.f12483y));
    }

    @Override // pe.c1
    public void m(Object obj) {
        this.f12483y.i(pe.x.m(obj));
    }
}
