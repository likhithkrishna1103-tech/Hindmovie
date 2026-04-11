package o8;

import n.a1;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f9421a = new o();

    public h() {
    }

    public final void a(Object obj) {
        this.f9421a.m(obj);
    }

    public final boolean b(Exception exc) {
        o oVar = this.f9421a;
        oVar.getClass();
        v.i(exc, "Exception must not be null");
        synchronized (oVar.f9439a) {
            try {
                if (oVar.f9441c) {
                    return false;
                }
                oVar.f9441c = true;
                oVar.f = exc;
                oVar.f9440b.j(oVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Object obj) {
        this.f9421a.o(obj);
    }

    public h(rc.b bVar) {
        a1 a1Var = new a1(this);
        bVar.getClass();
        ((o) bVar.f11562v).d(i.f9422a, new a1(a1Var));
    }
}
