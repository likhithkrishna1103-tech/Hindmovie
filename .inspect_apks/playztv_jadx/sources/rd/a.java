package rd;

import ae.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g f11568u;

    public a(g gVar) {
        this.f11568u = gVar;
    }

    @Override // rd.h
    public h G(g gVar) {
        return q1.c.F(this, gVar);
    }

    @Override // rd.h
    public final h K(h hVar) {
        return q1.c.H(this, hVar);
    }

    @Override // rd.h
    public final Object d(Object obj, p pVar) {
        return pVar.i(obj, this);
    }

    @Override // rd.f
    public final g getKey() {
        return this.f11568u;
    }

    @Override // rd.h
    public f v(g gVar) {
        return q1.c.B(this, gVar);
    }
}
