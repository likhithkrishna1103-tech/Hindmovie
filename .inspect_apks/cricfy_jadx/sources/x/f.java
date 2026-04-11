package x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends vf.g {
    @Override // vf.g
    public final void O(g gVar, g gVar2) {
        gVar.f14195b = gVar2;
    }

    @Override // vf.g
    public final void Q(g gVar, Thread thread) {
        gVar.f14194a = thread;
    }

    @Override // vf.g
    public final boolean f(h hVar, d dVar, d dVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f14199w != dVar) {
                    return false;
                }
                hVar.f14199w = dVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // vf.g
    public final boolean h(h hVar, Object obj, Object obj2) {
        synchronized (hVar) {
            try {
                if (hVar.f14198v != obj) {
                    return false;
                }
                hVar.f14198v = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // vf.g
    public final boolean j(h hVar, g gVar, g gVar2) {
        synchronized (hVar) {
            try {
                if (hVar.f14200x != gVar) {
                    return false;
                }
                hVar.f14200x = gVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
