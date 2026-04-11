package vd;

import fe.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f13718v;

    public a(g gVar) {
        this.f13718v = gVar;
    }

    @Override // vd.h
    public /* bridge */ f C(g gVar) {
        return w8.e.h(this, gVar);
    }

    @Override // vd.h
    public final Object J(Object obj, p pVar) {
        return pVar.j(obj, this);
    }

    @Override // vd.h
    public /* bridge */ h O(g gVar) {
        return w8.e.i(this, gVar);
    }

    @Override // vd.f
    public final g getKey() {
        return this.f13718v;
    }

    @Override // vd.h
    public final /* bridge */ h q(h hVar) {
        return w8.e.k(this, hVar);
    }
}
