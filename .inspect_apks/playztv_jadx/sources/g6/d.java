package g6;

import c2.b0;
import e6.n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f5322d;

    @Override // c2.b0
    public final int b(Object obj) {
        e6.b0 b0Var = (e6.b0) obj;
        if (b0Var == null) {
            return 1;
        }
        return b0Var.b();
    }

    @Override // c2.b0
    public final void c(Object obj, Object obj2) {
        e6.b0 b0Var = (e6.b0) obj2;
        n nVar = this.f5322d;
        if (nVar == null || b0Var == null) {
            return;
        }
        nVar.f4544e.i(b0Var, true);
    }

    public final void g(int i) {
        long j5;
        if (i >= 40) {
            f(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (this) {
                j5 = this.f2248a;
            }
            f(j5 / 2);
        }
    }
}
