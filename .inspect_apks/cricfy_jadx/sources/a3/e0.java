package a3;

import java.util.List;
import ua.z0;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f174e;
    public r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i0 f175g;

    public e0(int i, int i10, String str) {
        this.f170a = i;
        this.f171b = i10;
        this.f172c = str;
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f = rVar;
        i0 i0VarP = rVar.p(1024, 4);
        this.f175g = i0VarP;
        v1.o oVar = new v1.o();
        String str = this.f172c;
        oVar.f12892l = m0.p(str);
        oVar.f12893m = m0.p(str);
        l0.e.s(oVar, i0VarP);
        this.f.e();
        this.f.s(new f0());
        this.f174e = 1;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        if (j4 == 0 || this.f174e == 1) {
            this.f174e = 1;
            this.f173d = 0;
        }
    }

    @Override // a3.p
    public final List f() {
        ua.g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        int i = this.f171b;
        int i10 = this.f170a;
        y1.d.g((i10 == -1 || i == -1) ? false : true);
        y1.t tVar = new y1.t(i);
        ((l) qVar).v(tVar.f14609a, 0, i, false);
        return tVar.D() == i10;
    }

    @Override // a3.p
    public final int i(q qVar, t tVar) {
        int i = this.f174e;
        if (i != 1) {
            if (i == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        i0 i0Var = this.f175g;
        i0Var.getClass();
        int iB = i0Var.b(qVar, 1024, true);
        if (iB != -1) {
            this.f173d += iB;
            return 0;
        }
        this.f174e = 2;
        this.f175g.e(0L, 1, this.f173d, 0, null);
        this.f173d = 0;
        return 0;
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
