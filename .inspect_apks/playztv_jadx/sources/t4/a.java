package t4;

import k8.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements rd.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final z f12103v = new z(28);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p f12104u;

    public a(p pVar) {
        be.h.e(pVar, "connectionWrapper");
        this.f12104u = pVar;
    }

    @Override // rd.h
    public final rd.h G(rd.g gVar) {
        return q1.c.F(this, gVar);
    }

    @Override // rd.h
    public final rd.h K(rd.h hVar) {
        return q1.c.H(this, hVar);
    }

    @Override // rd.h
    public final Object d(Object obj, ae.p pVar) {
        return pVar.i(obj, this);
    }

    @Override // rd.f
    public final rd.g getKey() {
        return f12103v;
    }

    @Override // rd.h
    public final rd.f v(rd.g gVar) {
        return q1.c.B(this, gVar);
    }
}
