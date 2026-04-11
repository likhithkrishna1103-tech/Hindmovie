package re;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.b1;
import pe.c1;
import pe.w0;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends pe.a implements q, g {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f11043y;

    public p(vd.h hVar, c cVar) {
        super(hVar, true);
        this.f11043y = cVar;
    }

    @Override // pe.a
    public final void c0(Throwable th, boolean z10) {
        if (this.f11043y.h(th, false) || z10) {
            return;
        }
        x.i(th, this.f10215x);
    }

    @Override // pe.a
    public final void d0(Object obj) {
        this.f11043y.h(null, false);
    }

    @Override // re.s
    public final Object e(Object obj) {
        return this.f11043y.e(rd.l.f11003a);
    }

    @Override // re.s
    public final Object f(Object obj, vd.c cVar) {
        return this.f11043y.f(obj, cVar);
    }

    @Override // pe.c1, pe.v0
    public final void g(CancellationException cancellationException) {
        Object obj = c1.f10226v.get(this);
        if (obj instanceof pe.p) {
            return;
        }
        if ((obj instanceof b1) && ((b1) obj).e()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new w0(r(), null, this);
        }
        o(cancellationException);
    }

    public final void g0(o oVar) {
        c cVar = this.f11043y;
        cVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.E;
        while (!atomicReferenceFieldUpdater.compareAndSet(cVar, null, oVar)) {
            if (atomicReferenceFieldUpdater.get(cVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(cVar);
                    d5.a aVar = e.f11030q;
                    if (obj != aVar) {
                        if (obj == e.f11031r) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    d5.a aVar2 = e.f11031r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, aVar, aVar2)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != aVar) {
                            break;
                        }
                    }
                    oVar.a(cVar.n());
                    return;
                }
            }
        }
    }

    @Override // pe.c1
    public final void o(CancellationException cancellationException) {
        this.f11043y.h(cancellationException, true);
        n(cancellationException);
    }
}
