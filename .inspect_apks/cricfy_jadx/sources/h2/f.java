package h2;

import a3.m;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import c2.o;
import g2.g0;
import g2.n;
import java.io.IOException;
import java.util.List;
import s2.c0;
import s2.i0;
import s2.t;
import s2.y;
import ua.k0;
import v1.c1;
import v1.e1;
import v1.f1;
import v1.j0;
import v1.l0;
import v1.l1;
import v1.n1;
import v1.p0;
import v1.q0;
import v1.r1;
import v1.s0;
import v1.t0;
import v1.u0;
import v1.v0;
import v1.w0;
import y1.a0;
import y1.p;
import y1.v;
import y1.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements u0, i0, l2.l {
    public p A;
    public w0 B;
    public x C;
    public boolean D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v f5494v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c1 f5495w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e1 f5496x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o f5497y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SparseArray f5498z;

    public f(v vVar) {
        vVar.getClass();
        this.f5494v = vVar;
        int i = a0.f14551a;
        Looper looperMyLooper = Looper.myLooper();
        this.A = new p(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, vVar, new m(27));
        c1 c1Var = new c1();
        this.f5495w = c1Var;
        this.f5496x = new e1();
        this.f5497y = new o(c1Var);
        this.f5498z = new SparseArray();
    }

    @Override // v1.u0
    public final void A(x1.c cVar) {
        W(R(), 27, new b(1));
    }

    @Override // v1.u0
    public final void B(int i, v0 v0Var, v0 v0Var2) {
        if (i == 1) {
            this.D = false;
        }
        w0 w0Var = this.B;
        w0Var.getClass();
        o oVar = this.f5497y;
        oVar.f2038e = o.k(w0Var, (ua.i0) oVar.f2036c, (c0) oVar.f, (c1) oVar.f2035b);
        a aVarR = R();
        W(aVarR, 11, new g2.x(aVarR, i, v0Var, v0Var2));
    }

    @Override // v1.u0
    public final void C(int i) {
        W(R(), 4, new m(28));
    }

    @Override // v1.u0
    public final void D(q0 q0Var) {
        W(R(), 12, new m(13));
    }

    @Override // v1.u0
    public final void E(boolean z10) {
        W(R(), 9, new b(4));
    }

    @Override // l2.l
    public final void F(int i, c0 c0Var) {
        W(U(i, c0Var), 1027, new b(24));
    }

    @Override // s2.i0
    public final void G(int i, c0 c0Var, t tVar, y yVar) {
        W(U(i, c0Var), 1001, new b(17));
    }

    @Override // v1.u0
    public final void H(int i, int i10) {
        W(V(), 24, new b(5));
    }

    @Override // l2.l
    public final void I(int i, c0 c0Var) {
        W(U(i, c0Var), 1025, new b(29));
    }

    @Override // s2.i0
    public final void J(int i, c0 c0Var, y yVar) {
        a aVarU = U(i, c0Var);
        W(aVarU, 1004, new androidx.fragment.app.e(6, aVarU, yVar));
    }

    @Override // s2.i0
    public final void K(int i, c0 c0Var, y yVar) {
        W(U(i, c0Var), 1005, new b(23));
    }

    @Override // s2.i0
    public final void L(int i, c0 c0Var, t tVar, y yVar) {
        W(U(i, c0Var), 1002, new b(13));
    }

    @Override // v1.u0
    public final void M(n1 n1Var) {
        W(R(), 2, new m(23));
    }

    @Override // l2.l
    public final void N(int i, c0 c0Var, Exception exc) {
        W(U(i, c0Var), 1024, new b(16));
    }

    @Override // l2.l
    public final void O(int i, c0 c0Var, int i10) {
        W(U(i, c0Var), 1022, new b(15));
    }

    @Override // v1.u0
    public final void P(s0 s0Var) {
        W(R(), 13, new e(6));
    }

    @Override // v1.u0
    public final void Q(boolean z10) {
        W(R(), 7, new m(18));
    }

    public final a R() {
        return S((c0) this.f5497y.f2038e);
    }

    public final a S(c0 c0Var) {
        this.B.getClass();
        f1 f1Var = c0Var == null ? null : (f1) ((k0) this.f5497y.f2037d).get(c0Var);
        if (c0Var != null && f1Var != null) {
            return T(f1Var, f1Var.g(c0Var.f11156a, this.f5495w).f12618c, c0Var);
        }
        int iY = this.B.Y();
        f1 f1VarV0 = this.B.v0();
        if (iY >= f1VarV0.o()) {
            f1VarV0 = f1.f12674a;
        }
        return T(f1VarV0, iY, null);
    }

    public final a T(f1 f1Var, int i, c0 c0Var) {
        c0 c0Var2 = f1Var.p() ? null : c0Var;
        this.f5494v.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z10 = f1Var.equals(this.B.v0()) && i == this.B.Y();
        long jB0 = 0;
        if (c0Var2 == null || !c0Var2.b()) {
            if (z10) {
                jB0 = this.B.q();
            } else if (!f1Var.p()) {
                jB0 = a0.b0(f1Var.m(i, this.f5496x, 0L).f12652l);
            }
        } else if (z10 && this.B.X() == c0Var2.f11157b && this.B.k0() == c0Var2.f11158c) {
            jB0 = this.B.V0();
        }
        return new a(jElapsedRealtime, f1Var, i, c0Var2, jB0, this.B.v0(), this.B.Y(), (c0) this.f5497y.f2038e, this.B.V0(), this.B.r());
    }

    public final a U(int i, c0 c0Var) {
        this.B.getClass();
        if (c0Var != null) {
            return ((f1) ((k0) this.f5497y.f2037d).get(c0Var)) != null ? S(c0Var) : T(f1.f12674a, i, c0Var);
        }
        f1 f1VarV0 = this.B.v0();
        if (i >= f1VarV0.o()) {
            f1VarV0 = f1.f12674a;
        }
        return T(f1VarV0, i, null);
    }

    public final a V() {
        return S((c0) this.f5497y.f2039g);
    }

    public final void W(a aVar, int i, y1.m mVar) {
        this.f5498z.put(i, aVar);
        this.A.e(i, mVar);
    }

    public final void X(g0 g0Var, Looper looper) {
        y1.d.g(this.B == null || ((ua.i0) this.f5497y.f2036c).isEmpty());
        g0Var.getClass();
        this.B = g0Var;
        this.C = this.f5494v.a(looper, null);
        p pVar = this.A;
        this.A = new p(pVar.f14594d, looper, pVar.f14591a, new androidx.fragment.app.e(5, this, g0Var), pVar.i);
    }

    @Override // v1.u0
    public final void a(r1 r1Var) {
        a aVarV = V();
        W(aVarV, 25, new g2.c0(aVarV, r1Var));
    }

    @Override // v1.u0
    public final void b(boolean z10) {
        W(V(), 23, new e(3));
    }

    @Override // v1.u0
    public final void c(int i) {
        W(R(), 8, new b(0));
    }

    @Override // v1.u0
    public final void d(int i) {
        W(V(), 21, new b(20));
    }

    @Override // v1.u0
    public final void e(f1 f1Var, int i) {
        w0 w0Var = this.B;
        w0Var.getClass();
        o oVar = this.f5497y;
        oVar.f2038e = o.k(w0Var, (ua.i0) oVar.f2036c, (c0) oVar.f, (c1) oVar.f2035b);
        oVar.B(w0Var.v0());
        W(R(), 0, new e(7));
    }

    @Override // s2.i0
    public final void f(int i, c0 c0Var, t tVar, y yVar, IOException iOException, boolean z10) {
        a aVarU = U(i, c0Var);
        W(aVarU, 1003, new androidx.fragment.app.f1(aVarU, tVar, yVar, iOException, z10));
    }

    @Override // v1.u0
    public final void g(int i) {
        W(R(), 6, new m(20));
    }

    @Override // v1.u0
    public final void i(l1 l1Var) {
        W(R(), 19, new b(19));
    }

    @Override // v1.u0
    public final void j(j0 j0Var) {
        W(R(), 14, new b(9));
    }

    @Override // v1.u0
    public final void k(int i, v1.g0 g0Var) {
        W(R(), 1, new e(8));
    }

    @Override // v1.u0
    public final void n(j0 j0Var) {
        W(R(), 15, new e(0));
    }

    @Override // s2.i0
    public final void o(int i, c0 c0Var, t tVar, y yVar, int i10) {
        W(U(i, c0Var), 1000, new b(6));
    }

    @Override // v1.u0
    public final void p(v1.c cVar) {
        W(V(), 20, new b(27));
    }

    @Override // v1.u0
    public final void q(boolean z10) {
        W(R(), 3, new b(28));
    }

    @Override // v1.u0
    public final void r(l0 l0Var) {
        W(R(), 28, new m(17));
    }

    @Override // l2.l
    public final void t(int i, c0 c0Var) {
        W(U(i, c0Var), 1023, new e(1));
    }

    @Override // v1.u0
    public final void u(p0 p0Var) {
        c0 c0Var;
        a aVarR = (!(p0Var instanceof n) || (c0Var = ((n) p0Var).J) == null) ? R() : S(c0Var);
        W(aVarR, 10, new androidx.fragment.app.f1(aVarR, p0Var, 16));
    }

    @Override // v1.u0
    public final void v(p0 p0Var) {
        c0 c0Var;
        W((!(p0Var instanceof n) || (c0Var = ((n) p0Var).J) == null) ? R() : S(c0Var), 10, new m(22));
    }

    @Override // v1.u0
    public final void w(List list) {
        W(R(), 27, new m(26));
    }

    @Override // v1.u0
    public final void x(int i, boolean z10) {
        W(R(), -1, new m(16));
    }

    @Override // v1.u0
    public final void y(int i, boolean z10) {
        W(R(), 5, new m(24));
    }

    @Override // v1.u0
    public final void z(float f) {
        W(V(), 22, new m(14));
    }

    @Override // v1.u0
    public final void s() {
    }

    @Override // v1.u0
    public final void h(t0 t0Var) {
    }

    @Override // v1.u0
    public final void l(boolean z10) {
    }

    @Override // v1.u0
    public final void m(int i) {
    }
}
