package j9;

import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f6688a = new p();

    public i() {
    }

    public final void a(Object obj) {
        this.f6688a.l(obj);
    }

    public final boolean b(Exception exc) {
        p pVar = this.f6688a;
        pVar.getClass();
        u.h(exc, "Exception must not be null");
        synchronized (pVar.f6706a) {
            try {
                if (pVar.f6708c) {
                    return false;
                }
                pVar.f6708c = true;
                pVar.f = exc;
                pVar.f6707b.i(pVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Object obj) {
        this.f6688a.m(obj);
    }

    public i(pc.c cVar) {
        p6.c cVar2 = new p6.c(24, this);
        cVar.getClass();
        ((p) cVar.f10180v).d(j.f6689a, new p6.c(cVar, cVar2));
    }
}
