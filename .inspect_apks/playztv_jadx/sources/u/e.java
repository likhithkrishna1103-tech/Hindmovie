package u;

import cf.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends l {
    @Override // cf.l
    public final boolean d(g gVar, c cVar, c cVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f12516v != cVar) {
                    return false;
                }
                gVar.f12516v = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cf.l
    public final boolean e(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            try {
                if (gVar.f12515u != obj) {
                    return false;
                }
                gVar.f12515u = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cf.l
    public final boolean f(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f12517w != fVar) {
                    return false;
                }
                gVar.f12517w = fVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cf.l
    public final void x(f fVar, f fVar2) {
        fVar.f12511b = fVar2;
    }

    @Override // cf.l
    public final void y(f fVar, Thread thread) {
        fVar.f12510a = thread;
    }
}
