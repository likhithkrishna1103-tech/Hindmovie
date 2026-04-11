package b2;

import a2.c0;
import a2.f0;
import a2.o0;
import a2.q;
import a2.s;
import aa.j0;
import aa.m0;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;
import java.util.List;
import o2.d0;
import o2.k0;
import o2.u;
import o2.z;
import p1.c1;
import p1.e1;
import p1.f1;
import p1.g0;
import p1.l0;
import p1.l1;
import p1.n1;
import p1.p0;
import p1.q0;
import p1.r1;
import p1.s0;
import p1.t0;
import p1.u0;
import p1.v0;
import p1.w0;
import s1.b0;
import s1.p;
import s1.w;
import s1.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements u0, k0, f2.l {
    public w0 A;
    public y B;
    public boolean C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final w f1742u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c1 f1743v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e1 f1744w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f1745x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final SparseArray f1746y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p f1747z;

    public h(w wVar) {
        wVar.getClass();
        this.f1742u = wVar;
        int i = b0.f11647a;
        Looper looperMyLooper = Looper.myLooper();
        this.f1747z = new p(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, wVar, new s(19));
        c1 c1Var = new c1();
        this.f1743v = c1Var;
        this.f1744w = new e1();
        this.f1745x = new g(c1Var);
        this.f1746y = new SparseArray();
    }

    @Override // o2.k0
    public final void A(int i, d0 d0Var, u uVar, z zVar, IOException iOException, boolean z2) {
        a aVarU = U(i, d0Var);
        W(aVarU, 1003, new f0(aVarU, uVar, zVar, iOException, z2));
    }

    @Override // p1.u0
    public final void B(int i, boolean z2) {
        W(R(), 5, new s(16));
    }

    @Override // p1.u0
    public final void C(float f) {
        W(V(), 22, new s(6));
    }

    @Override // f2.l
    public final void D(int i, d0 d0Var) {
        W(U(i, d0Var), 1023, new d(23));
    }

    @Override // p1.u0
    public final void E(int i) {
        W(R(), 4, new s(20));
    }

    @Override // p1.u0
    public final void F(int i, v0 v0Var, v0 v0Var2) {
        if (i == 1) {
            this.C = false;
        }
        w0 w0Var = this.A;
        w0Var.getClass();
        g gVar = this.f1745x;
        gVar.f1740e = g.j(w0Var, (j0) gVar.f1738c, (d0) gVar.f, (c1) gVar.f1737b);
        a aVarR = R();
        W(aVarR, 11, new c0(aVarR, i, v0Var, v0Var2));
    }

    @Override // p1.u0
    public final void G(boolean z2) {
        W(R(), 9, new s(26));
    }

    @Override // p1.u0
    public final void H(int i, int i10) {
        W(V(), 24, new s(27));
    }

    @Override // o2.k0
    public final void I(int i, d0 d0Var, u uVar, z zVar) {
        W(U(i, d0Var), 1001, new d(9));
    }

    @Override // o2.k0
    public final void J(int i, d0 d0Var, u uVar, z zVar, int i10) {
        W(U(i, d0Var), 1000, new s(28));
    }

    @Override // p1.u0
    public final void K(p0 p0Var) {
        d0 d0Var;
        a aVarR = (!(p0Var instanceof q) || (d0Var = ((q) p0Var).I) == null) ? R() : S(d0Var);
        W(aVarR, 10, new f0(aVarR, p0Var, 7));
    }

    @Override // p1.u0
    public final void L(p0 p0Var) {
        d0 d0Var;
        W((!(p0Var instanceof q) || (d0Var = ((q) p0Var).I) == null) ? R() : S(d0Var), 10, new s(14));
    }

    @Override // p1.u0
    public final void N(l1 l1Var) {
        W(R(), 19, new d(11));
    }

    @Override // p1.u0
    public final void O(q0 q0Var) {
        W(R(), 12, new s(5));
    }

    @Override // p1.u0
    public final void P(boolean z2) {
        W(R(), 7, new s(10));
    }

    @Override // f2.l
    public final void Q(int i, d0 d0Var) {
        W(U(i, d0Var), 1025, new d(21));
    }

    public final a R() {
        return S((d0) this.f1745x.f1740e);
    }

    public final a S(d0 d0Var) {
        this.A.getClass();
        f1 f1Var = d0Var == null ? null : (f1) ((m0) this.f1745x.f1739d).get(d0Var);
        if (d0Var != null && f1Var != null) {
            return T(f1Var, f1Var.g(d0Var.f9090a, this.f1743v).f9678c, d0Var);
        }
        int iD0 = this.A.d0();
        f1 f1VarW0 = this.A.w0();
        if (iD0 >= f1VarW0.o()) {
            f1VarW0 = f1.f9741a;
        }
        return T(f1VarW0, iD0, null);
    }

    public final a T(f1 f1Var, int i, d0 d0Var) {
        d0 d0Var2 = f1Var.p() ? null : d0Var;
        this.f1742u.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z2 = f1Var.equals(this.A.w0()) && i == this.A.d0();
        long jB0 = 0;
        if (d0Var2 == null || !d0Var2.b()) {
            if (z2) {
                jB0 = this.A.s();
            } else if (!f1Var.p()) {
                jB0 = b0.b0(f1Var.m(i, this.f1744w, 0L).f9722l);
            }
        } else if (z2 && this.A.c0() == d0Var2.f9091b && this.A.m0() == d0Var2.f9092c) {
            jB0 = this.A.T0();
        }
        return new a(jElapsedRealtime, f1Var, i, d0Var2, jB0, this.A.w0(), this.A.d0(), (d0) this.f1745x.f1740e, this.A.T0(), this.A.t());
    }

    public final a U(int i, d0 d0Var) {
        this.A.getClass();
        if (d0Var != null) {
            return ((f1) ((m0) this.f1745x.f1739d).get(d0Var)) != null ? S(d0Var) : T(f1.f9741a, i, d0Var);
        }
        f1 f1VarW0 = this.A.w0();
        if (i >= f1VarW0.o()) {
            f1VarW0 = f1.f9741a;
        }
        return T(f1VarW0, i, null);
    }

    public final a V() {
        return S((d0) this.f1745x.f1741g);
    }

    public final void W(a aVar, int i, s1.m mVar) {
        this.f1746y.put(i, aVar);
        this.f1747z.e(i, mVar);
    }

    public final void X(o0 o0Var, Looper looper) {
        s1.d.g(this.A == null || ((j0) this.f1745x.f1738c).isEmpty());
        o0Var.getClass();
        this.A = o0Var;
        this.B = this.f1742u.a(looper, null);
        p pVar = this.f1747z;
        this.f1747z = new p(pVar.f11689d, looper, pVar.f11686a, new b(this, 0, o0Var), pVar.i);
    }

    @Override // p1.u0
    public final void a(boolean z2) {
        W(V(), 23, new d(25));
    }

    @Override // p1.u0
    public final void b(r1 r1Var) {
        a aVarV = V();
        W(aVarV, 25, new a2.k0(aVarV, r1Var));
    }

    @Override // o2.k0
    public final void c(int i, d0 d0Var, u uVar, z zVar) {
        W(U(i, d0Var), 1002, new d(5));
    }

    @Override // p1.u0
    public final void d(int i) {
        W(R(), 8, new s(22));
    }

    @Override // p1.u0
    public final void e(int i) {
        W(V(), 21, new d(12));
    }

    @Override // p1.u0
    public final void f(int i) {
        W(R(), 6, new s(12));
    }

    @Override // o2.k0
    public final void g(int i, d0 d0Var, z zVar) {
        W(U(i, d0Var), 1005, new d(15));
    }

    @Override // p1.u0
    public final void h(p1.j0 j0Var) {
        W(R(), 15, new d(22));
    }

    @Override // p1.u0
    public final void k(f1 f1Var, int i) {
        w0 w0Var = this.A;
        w0Var.getClass();
        g gVar = this.f1745x;
        gVar.f1740e = g.j(w0Var, (j0) gVar.f1738c, (d0) gVar.f, (c1) gVar.f1737b);
        gVar.z(w0Var.w0());
        W(R(), 0, new d(29));
    }

    @Override // o2.k0
    public final void l(int i, d0 d0Var, z zVar) {
        a aVarU = U(i, d0Var);
        W(aVarU, 1004, new b(aVarU, 1, zVar));
    }

    @Override // f2.l
    public final void m(int i, d0 d0Var, Exception exc) {
        W(U(i, d0Var), 1024, new d(8));
    }

    @Override // p1.u0
    public final void n(p1.j0 j0Var) {
        W(R(), 14, new d(1));
    }

    @Override // p1.u0
    public final void o(int i, g0 g0Var) {
        W(R(), 1, new f(0));
    }

    @Override // p1.u0
    public final void p(s0 s0Var) {
        W(R(), 13, new d(28));
    }

    @Override // p1.u0
    public final void q(n1 n1Var) {
        W(R(), 2, new s(15));
    }

    @Override // f2.l
    public final void r(int i, d0 d0Var) {
        W(U(i, d0Var), 1027, new d(16));
    }

    @Override // f2.l
    public final void s(int i, d0 d0Var, int i10) {
        W(U(i, d0Var), 1022, new d(7));
    }

    @Override // p1.u0
    public final void t(boolean z2) {
        W(R(), 3, new d(20));
    }

    @Override // p1.u0
    public final void v(l0 l0Var) {
        W(R(), 28, new s(9));
    }

    @Override // p1.u0
    public final void w(p1.d dVar) {
        W(V(), 20, new d(19));
    }

    @Override // p1.u0
    public final void x(r1.c cVar) {
        W(R(), 27, new s(23));
    }

    @Override // p1.u0
    public final void y(List list) {
        W(R(), 27, new s(18));
    }

    @Override // p1.u0
    public final void z(int i, boolean z2) {
        W(R(), -1, new s(8));
    }

    @Override // p1.u0
    public final void u() {
    }

    @Override // p1.u0
    public final void M(t0 t0Var) {
    }

    @Override // p1.u0
    public final void i(boolean z2) {
    }

    @Override // p1.u0
    public final void j(int i) {
    }
}
