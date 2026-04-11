package ya;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends vf.g {
    @Override // vf.g
    public final c D(o oVar) {
        c cVar;
        c cVar2 = c.f14984d;
        synchronized (oVar) {
            try {
                cVar = oVar.f15007w;
                if (cVar != cVar2) {
                    oVar.f15007w = cVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // vf.g
    public final n E(o oVar) {
        n nVar;
        n nVar2 = n.f15001c;
        synchronized (oVar) {
            try {
                nVar = oVar.f15008x;
                if (nVar != nVar2) {
                    oVar.f15008x = nVar2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    @Override // vf.g
    public final void P(n nVar, n nVar2) {
        nVar.f15003b = nVar2;
    }

    @Override // vf.g
    public final void R(n nVar, Thread thread) {
        nVar.f15002a = thread;
    }

    @Override // vf.g
    public final boolean g(o oVar, c cVar, c cVar2) {
        synchronized (oVar) {
            try {
                if (oVar.f15007w != cVar) {
                    return false;
                }
                oVar.f15007w = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // vf.g
    public final boolean i(o oVar, Object obj, Object obj2) {
        synchronized (oVar) {
            try {
                if (oVar.f15006v != obj) {
                    return false;
                }
                oVar.f15006v = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // vf.g
    public final boolean k(o oVar, n nVar, n nVar2) {
        synchronized (oVar) {
            try {
                if (oVar.f15008x != nVar) {
                    return false;
                }
                oVar.f15008x = nVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
