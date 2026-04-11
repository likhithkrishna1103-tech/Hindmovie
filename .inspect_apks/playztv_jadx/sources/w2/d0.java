package w2;

import aa.c1;
import aa.j0;
import java.util.List;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13617e;
    public q f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h0 f13618g;

    public d0(int i, int i10, String str) {
        this.f13613a = i;
        this.f13614b = i10;
        this.f13615c = str;
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f = qVar;
        h0 h0VarQ = qVar.q(1024, 4);
        this.f13618g = h0VarQ;
        p1.p pVar = new p1.p();
        String str = this.f13615c;
        pVar.f9966l = m0.p(str);
        pVar.f9967m = m0.p(str);
        e6.j.s(pVar, h0VarQ);
        this.f.e();
        this.f.j(new e0());
        this.f13617e = 1;
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        int i = this.f13614b;
        int i10 = this.f13613a;
        s1.d.g((i10 == -1 || i == -1) ? false : true);
        s1.u uVar = new s1.u(i);
        ((l) pVar).r(uVar.f11709a, 0, i, false);
        return uVar.D() == i10;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        if (j5 == 0 || this.f13617e == 1) {
            this.f13617e = 1;
            this.f13616d = 0;
        }
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(p pVar, s sVar) {
        int i = this.f13617e;
        if (i != 1) {
            if (i == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        h0 h0Var = this.f13618g;
        h0Var.getClass();
        int iC = h0Var.c(pVar, 1024, true);
        if (iC != -1) {
            this.f13616d += iC;
            return 0;
        }
        this.f13617e = 2;
        this.f13618g.a(0L, 1, this.f13616d, 0, null);
        this.f13616d = 0;
        return 0;
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
