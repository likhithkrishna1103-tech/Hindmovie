package ea;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends android.support.v4.media.session.b {
    @Override // android.support.v4.media.session.b
    public final void M(o oVar, o oVar2) {
        oVar.f4621b = oVar2;
    }

    @Override // android.support.v4.media.session.b
    public final void N(o oVar, Thread thread) {
        oVar.f4620a = thread;
    }

    @Override // android.support.v4.media.session.b
    public final boolean e(p pVar, d dVar, d dVar2) {
        synchronized (pVar) {
            try {
                if (pVar.f4626v != dVar) {
                    return false;
                }
                pVar.f4626v = dVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.support.v4.media.session.b
    public final boolean f(p pVar, Object obj, Object obj2) {
        synchronized (pVar) {
            try {
                if (pVar.f4625u != obj) {
                    return false;
                }
                pVar.f4625u = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.support.v4.media.session.b
    public final boolean g(p pVar, o oVar, o oVar2) {
        synchronized (pVar) {
            try {
                if (pVar.f4627w != oVar) {
                    return false;
                }
                pVar.f4627w = oVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.support.v4.media.session.b
    public final d p(p pVar) {
        d dVar;
        d dVar2 = d.f4598d;
        synchronized (pVar) {
            try {
                dVar = pVar.f4626v;
                if (dVar != dVar2) {
                    pVar.f4626v = dVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // android.support.v4.media.session.b
    public final o q(p pVar) {
        o oVar;
        o oVar2 = o.f4619c;
        synchronized (pVar) {
            try {
                oVar = pVar.f4627w;
                if (oVar != oVar2) {
                    pVar.f4627w = oVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }
}
