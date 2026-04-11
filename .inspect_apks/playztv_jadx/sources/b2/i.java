package b2;

import o2.d0;
import p1.e1;
import p1.f1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f1751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1752e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j f1753g;

    public i(j jVar, String str, int i, d0 d0Var) {
        this.f1753g = jVar;
        this.f1748a = str;
        this.f1749b = i;
        this.f1750c = d0Var == null ? -1L : d0Var.f9093d;
        if (d0Var == null || !d0Var.b()) {
            return;
        }
        this.f1751d = d0Var;
    }

    public final boolean a(a aVar) {
        d0 d0Var = aVar.f1722d;
        f1 f1Var = aVar.f1720b;
        if (d0Var == null) {
            return this.f1749b != aVar.f1721c;
        }
        long j5 = this.f1750c;
        if (j5 == -1) {
            return false;
        }
        if (d0Var.f9093d > j5) {
            return true;
        }
        d0 d0Var2 = this.f1751d;
        if (d0Var2 == null) {
            return false;
        }
        int i = d0Var2.f9091b;
        int iB = f1Var.b(d0Var.f9090a);
        int iB2 = f1Var.b(d0Var2.f9090a);
        if (d0Var.f9093d < d0Var2.f9093d || iB < iB2) {
            return false;
        }
        if (iB > iB2) {
            return true;
        }
        if (!d0Var.b()) {
            int i10 = d0Var.f9094e;
            return i10 == -1 || i10 > i;
        }
        int i11 = d0Var.f9091b;
        int i12 = d0Var.f9092c;
        if (i11 <= i) {
            return i11 == i && i12 > d0Var2.f9092c;
        }
        return true;
    }

    public final boolean b(f1 f1Var, f1 f1Var2) {
        d0 d0Var;
        int i = this.f1749b;
        if (i < f1Var.o()) {
            j jVar = this.f1753g;
            e1 e1Var = jVar.f1755a;
            f1Var.n(i, e1Var);
            for (int i10 = e1Var.f9724n; i10 <= e1Var.f9725o; i10++) {
                int iB = f1Var2.b(f1Var.l(i10));
                if (iB != -1) {
                    i = f1Var2.f(iB, jVar.f1756b, false).f9678c;
                    break;
                }
            }
            i = -1;
        } else if (i >= f1Var2.o()) {
            i = -1;
        }
        this.f1749b = i;
        return i != -1 && ((d0Var = this.f1751d) == null || f1Var2.b(d0Var.f9090a) != -1);
    }
}
