package b7;

import i2.c0;
import z6.b0;
import z6.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f1831d;

    @Override // i2.c0
    public final int b(Object obj) {
        b0 b0Var = (b0) obj;
        if (b0Var == null) {
            return 1;
        }
        return b0Var.c();
    }

    @Override // i2.c0
    public final void c(Object obj, Object obj2) {
        b0 b0Var = (b0) obj2;
        n nVar = this.f1831d;
        if (nVar == null || b0Var == null) {
            return;
        }
        nVar.f15297e.j(b0Var, true);
    }

    public final void g(int i) {
        long j4;
        if (i >= 40) {
            f(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (this) {
                j4 = this.f5982a;
            }
            f(j4 / 2);
        }
    }
}
