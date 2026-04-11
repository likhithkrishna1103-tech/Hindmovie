package ue;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements vd.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12488v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ThreadLocal f12489w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v f12490x;

    public u(Object obj, ThreadLocal threadLocal) {
        this.f12488v = obj;
        this.f12489w = threadLocal;
        this.f12490x = new v(threadLocal);
    }

    @Override // vd.h
    public final vd.f C(vd.g gVar) {
        if (this.f12490x.equals(gVar)) {
            return this;
        }
        return null;
    }

    @Override // vd.h
    public final Object J(Object obj, fe.p pVar) {
        return pVar.j(obj, this);
    }

    @Override // vd.h
    public final vd.h O(vd.g gVar) {
        return this.f12490x.equals(gVar) ? vd.i.f13722v : this;
    }

    public final void b(Object obj) {
        this.f12489w.set(obj);
    }

    public final Object c(vd.h hVar) {
        ThreadLocal threadLocal = this.f12489w;
        Object obj = threadLocal.get();
        threadLocal.set(this.f12488v);
        return obj;
    }

    @Override // vd.f
    public final vd.g getKey() {
        return this.f12490x;
    }

    @Override // vd.h
    public final vd.h q(vd.h hVar) {
        return w8.e.k(this, hVar);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f12488v + ", threadLocal = " + this.f12489w + ')';
    }
}
