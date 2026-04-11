package se;

import ae.q;
import i4.o0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ke.p1;
import nd.k;
import pe.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ke.e, p1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ke.g f11944u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f11945v;

    public b(c cVar, ke.g gVar) {
        this.f11945v = cVar;
        this.f11944u = gVar;
    }

    @Override // ke.p1
    public final void a(r rVar, int i) {
        this.f11944u.a(rVar, i);
    }

    @Override // ke.e
    public final void e(Object obj, q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.B;
        c cVar = this.f11945v;
        atomicReferenceFieldUpdater.set(cVar, null);
        he.i iVar = new he.i(cVar, this);
        ke.g gVar = this.f11944u;
        gVar.D(k.f8990a, gVar.f7685w, new ke.f(0, iVar));
    }

    @Override // rd.c
    public final rd.h f() {
        return this.f11944u.f7694y;
    }

    @Override // rd.c
    public final void g(Object obj) {
        this.f11944u.g(obj);
    }

    @Override // ke.e
    public final o0 k(Object obj, q qVar) {
        c cVar = this.f11945v;
        ke.f fVar = new ke.f(cVar, this);
        o0 o0VarK = this.f11944u.k((k) obj, fVar);
        if (o0VarK != null) {
            c.B.set(cVar, null);
        }
        return o0VarK;
    }

    @Override // ke.e
    public final void l(Object obj) {
        this.f11944u.l(obj);
    }
}
