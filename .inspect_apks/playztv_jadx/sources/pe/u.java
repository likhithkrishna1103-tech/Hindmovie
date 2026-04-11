package pe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u implements rd.f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f10402u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ThreadLocal f10403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v f10404w;

    public u(t4.p pVar, ThreadLocal threadLocal) {
        this.f10402u = pVar;
        this.f10403v = threadLocal;
        this.f10404w = new v(threadLocal);
    }

    @Override // rd.h
    public final rd.h G(rd.g gVar) {
        return this.f10404w.equals(gVar) ? rd.i.f11572u : this;
    }

    @Override // rd.h
    public final rd.h K(rd.h hVar) {
        return q1.c.H(this, hVar);
    }

    public final void b(Object obj) {
        this.f10403v.set(obj);
    }

    public final Object c(rd.h hVar) {
        ThreadLocal threadLocal = this.f10403v;
        Object obj = threadLocal.get();
        threadLocal.set(this.f10402u);
        return obj;
    }

    @Override // rd.h
    public final Object d(Object obj, ae.p pVar) {
        return pVar.i(obj, this);
    }

    @Override // rd.f
    public final rd.g getKey() {
        return this.f10404w;
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f10402u + ", threadLocal = " + this.f10403v + ')';
    }

    @Override // rd.h
    public final rd.f v(rd.g gVar) {
        if (this.f10404w.equals(gVar)) {
            return this;
        }
        return null;
    }
}
