package h2;

import s2.c0;
import v1.e1;
import v1.f1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f5502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5503e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f5504g;

    public g(h hVar, String str, int i, c0 c0Var) {
        this.f5504g = hVar;
        this.f5499a = str;
        this.f5500b = i;
        this.f5501c = c0Var == null ? -1L : c0Var.f11159d;
        if (c0Var == null || !c0Var.b()) {
            return;
        }
        this.f5502d = c0Var;
    }

    public final boolean a(a aVar) {
        c0 c0Var = aVar.f5483d;
        f1 f1Var = aVar.f5481b;
        if (c0Var == null) {
            return this.f5500b != aVar.f5482c;
        }
        long j4 = this.f5501c;
        if (j4 == -1) {
            return false;
        }
        if (c0Var.f11159d > j4) {
            return true;
        }
        c0 c0Var2 = this.f5502d;
        if (c0Var2 == null) {
            return false;
        }
        int i = c0Var2.f11157b;
        int iB = f1Var.b(c0Var.f11156a);
        int iB2 = f1Var.b(c0Var2.f11156a);
        if (c0Var.f11159d < c0Var2.f11159d || iB < iB2) {
            return false;
        }
        if (iB > iB2) {
            return true;
        }
        if (!c0Var.b()) {
            int i10 = c0Var.f11160e;
            return i10 == -1 || i10 > i;
        }
        int i11 = c0Var.f11157b;
        int i12 = c0Var.f11158c;
        if (i11 <= i) {
            return i11 == i && i12 > c0Var2.f11158c;
        }
        return true;
    }

    public final boolean b(f1 f1Var, f1 f1Var2) {
        c0 c0Var;
        int i = this.f5500b;
        if (i < f1Var.o()) {
            h hVar = this.f5504g;
            e1 e1Var = hVar.f5506a;
            f1Var.n(i, e1Var);
            for (int i10 = e1Var.f12654n; i10 <= e1Var.f12655o; i10++) {
                int iB = f1Var2.b(f1Var.l(i10));
                if (iB != -1) {
                    i = f1Var2.f(iB, hVar.f5507b, false).f12618c;
                    break;
                }
            }
            i = -1;
        } else if (i >= f1Var2.o()) {
            i = -1;
        }
        this.f5500b = i;
        return i != -1 && ((c0Var = this.f5502d) == null || f1Var2.b(c0Var.f11156a) != -1);
    }
}
