package a7;

import android.content.Context;
import f9.c2;
import f9.p1;
import f9.r1;
import g2.g0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import nb.w;
import o8.u;
import t0.z0;
import ua.i0;
import v1.e1;
import v1.f1;
import v1.q0;
import v1.w0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c2, m6.f, w0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f307w;

    public /* synthetic */ a(int i, Object obj) {
        this.f306v = i;
        this.f307w = obj;
    }

    @Override // f9.c2
    public s8.a A0() {
        throw null;
    }

    @Override // f9.c2
    public f9.w0 C() {
        throw null;
    }

    @Override // v1.w0
    public void D() {
        int iE;
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            iE = -1;
        } else {
            int iY = g0Var.Y();
            g0Var.P1();
            int i = g0Var.f4690b0;
            if (i == 1) {
                i = 0;
            }
            g0Var.P1();
            iE = f1VarV0.e(iY, i, g0Var.f4691c0);
        }
        if (iE == -1) {
            d1();
        } else if (iE == g0Var.Y()) {
            j1(g0Var.Y(), -9223372036854775807L, true);
        } else {
            j1(iE, -9223372036854775807L, false);
        }
    }

    @Override // v1.w0
    public void F0(long j4) {
        j1(((g0) this).Y(), j4, false);
    }

    @Override // v1.w0
    public int H() {
        g0 g0Var = (g0) this;
        long jV = g0Var.v();
        long duration = g0Var.getDuration();
        if (jV == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        int i = a0.f14551a;
        long jE = sd.i.E(jV, 100L);
        return a0.i(com.bumptech.glide.d.l((jE == Long.MAX_VALUE || jE == Long.MIN_VALUE) ? jV / (duration / 100) : jE / duration), 0, 100);
    }

    @Override // v1.w0
    public void I(int i, v1.g0 g0Var) {
        ((g0) this).s0(i, i + 1, i0.o(g0Var));
    }

    @Override // v1.w0
    public void J0() {
        int iE;
        g0 g0Var = (g0) this;
        if (g0Var.v0().p() || g0Var.l()) {
            d1();
            return;
        }
        if (!b1()) {
            if (X0() && q0()) {
                j1(g0Var.Y(), -9223372036854775807L, false);
                return;
            } else {
                d1();
                return;
            }
        }
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            iE = -1;
        } else {
            int iY = g0Var.Y();
            g0Var.P1();
            int i = g0Var.f4690b0;
            if (i == 1) {
                i = 0;
            }
            g0Var.P1();
            iE = f1VarV0.e(iY, i, g0Var.f4691c0);
        }
        if (iE == -1) {
            d1();
        } else if (iE == g0Var.Y()) {
            j1(g0Var.Y(), -9223372036854775807L, true);
        } else {
            j1(iE, -9223372036854775807L, false);
        }
    }

    @Override // v1.w0
    public void K(v1.g0 g0Var) {
        ((g0) this).Q0(i0.o(g0Var));
    }

    @Override // v1.w0
    public void K0() {
        g0 g0Var = (g0) this;
        g0Var.P1();
        k1(12, g0Var.S);
    }

    @Override // v1.w0
    public boolean M() {
        g0 g0Var = (g0) this;
        return g0Var.E() == 3 && g0Var.w() && g0Var.r0() == 0;
    }

    @Override // v1.w0
    public void M0() {
        g0 g0Var = (g0) this;
        g0Var.P1();
        k1(11, -g0Var.R);
    }

    @Override // v1.w0
    public long N() {
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            return -9223372036854775807L;
        }
        return a0.b0(f1VarV0.m(g0Var.Y(), (e1) this.f307w, 0L).f12653m);
    }

    @Override // v1.w0
    public void R0() {
        g0 g0Var = (g0) this;
        if (g0Var.v0().p() || g0Var.l()) {
            d1();
            return;
        }
        boolean zC1 = c1();
        if (X0() && !x()) {
            if (zC1) {
                l1(7);
                return;
            } else {
                d1();
                return;
            }
        }
        if (zC1) {
            long jV0 = g0Var.V0();
            g0Var.P1();
            if (jV0 <= g0Var.T) {
                l1(7);
                return;
            }
        }
        j1(g0Var.Y(), 0L, false);
    }

    @Override // v1.w0
    public void S() {
        l1(6);
    }

    @Override // f9.c2
    public jb.b S0() {
        throw null;
    }

    @Override // v1.w0
    public void T() {
        ((g0) this).j(true);
    }

    @Override // m6.f
    public List U0() {
        return (List) this.f307w;
    }

    @Override // v1.w0
    public void V() {
        j1(((g0) this).Y(), -9223372036854775807L, false);
    }

    @Override // v1.w0
    public boolean X0() {
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        return !f1VarV0.p() && f1VarV0.m(g0Var.Y(), (e1) this.f307w, 0L).a();
    }

    @Override // m6.f
    public boolean Y0() {
        List list = (List) this.f307w;
        return list.isEmpty() || (list.size() == 1 && ((t6.a) list.get(0)).c());
    }

    @Override // v1.w0
    public boolean Z(int i) {
        g0 g0Var = (g0) this;
        g0Var.P1();
        return g0Var.f4697i0.a(i);
    }

    public abstract void Z0(b6.f fVar);

    @Override // f9.c2
    public p1 a0() {
        throw null;
    }

    public abstract String a1();

    public boolean b1() {
        int iE;
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            iE = -1;
        } else {
            int iY = g0Var.Y();
            g0Var.P1();
            int i = g0Var.f4690b0;
            if (i == 1) {
                i = 0;
            }
            g0Var.P1();
            iE = f1VarV0.e(iY, i, g0Var.f4691c0);
        }
        return iE != -1;
    }

    @Override // v1.w0
    public void c() {
        ((g0) this).j(false);
    }

    public boolean c1() {
        int iK;
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            iK = -1;
        } else {
            int iY = g0Var.Y();
            g0Var.P1();
            int i = g0Var.f4690b0;
            if (i == 1) {
                i = 0;
            }
            g0Var.P1();
            iK = f1VarV0.k(iY, i, g0Var.f4691c0);
        }
        return iK != -1;
    }

    public void d1() {
        ((g0) this).P1();
    }

    @Override // v1.w0
    public void e(float f) {
        g0 g0Var = (g0) this;
        g0Var.f(new q0(f, g0Var.d().f12969b));
    }

    public void e1(j jVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f307w;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(jVar);
        }
    }

    @Override // f9.c2
    public Context f0() {
        throw null;
    }

    public abstract void f1(z0 z0Var);

    public abstract void g1(z0 z0Var);

    public abstract t0.p1 h1(t0.p1 p1Var, List list);

    public abstract w i1(z0 z0Var, w wVar);

    public abstract void j1(int i, long j4, boolean z10);

    public void k1(int i, long j4) {
        g0 g0Var = (g0) this;
        long jV0 = g0Var.V0() + j4;
        long duration = g0Var.getDuration();
        if (duration != -9223372036854775807L) {
            jV0 = Math.min(jV0, duration);
        }
        j1(g0Var.Y(), Math.max(jV0, 0L), false);
    }

    public void l1(int i) {
        int iK;
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            iK = -1;
        } else {
            int iY = g0Var.Y();
            g0Var.P1();
            int i10 = g0Var.f4690b0;
            if (i10 == 1) {
                i10 = 0;
            }
            g0Var.P1();
            iK = f1VarV0.k(iY, i10, g0Var.f4691c0);
        }
        if (iK == -1) {
            d1();
        } else if (iK == g0Var.Y()) {
            j1(g0Var.Y(), -9223372036854775807L, true);
        } else {
            j1(iK, -9223372036854775807L, false);
        }
    }

    @Override // v1.w0
    public void m(int i) {
        j1(i, -9223372036854775807L, false);
    }

    public void m1() {
        p1 p1Var = ((r1) this.f307w).B;
        r1.g(p1Var);
        p1Var.m1();
    }

    @Override // v1.w0
    public void n(v1.g0 g0Var, long j4) {
        ((g0) this).g(i0.o(g0Var), 0, j4);
    }

    @Override // v1.w0
    public void o0(int i, int i10) {
        if (i != i10) {
            ((g0) this).p0(i, i + 1, i10);
        }
    }

    @Override // v1.w0
    public long p() {
        e1 e1Var = (e1) this.f307w;
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p() || f1VarV0.m(g0Var.Y(), e1Var, 0L).f == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (a0.y(e1Var.f12648g) - e1Var.f) - g0Var.q();
    }

    @Override // v1.w0
    public boolean q0() {
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        return !f1VarV0.p() && f1VarV0.m(g0Var.Y(), (e1) this.f307w, 0L).i;
    }

    @Override // v1.w0
    public void s(int i, long j4) {
        j1(i, j4, false);
    }

    @Override // v1.w0
    public void t0(List list) {
        ((g0) this).t(Integer.MAX_VALUE, list);
    }

    public String toString() {
        switch (this.f306v) {
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                StringBuilder sb = new StringBuilder();
                List list = (List) this.f307w;
                if (!list.isEmpty()) {
                    sb.append("values=");
                    sb.append(Arrays.toString(list.toArray()));
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // v1.w0
    public boolean x() {
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        return !f1VarV0.p() && f1VarV0.m(g0Var.Y(), (e1) this.f307w, 0L).f12649h;
    }

    @Override // v1.w0
    public void y() {
        ((g0) this).H0(0, Integer.MAX_VALUE);
    }

    @Override // v1.w0
    public v1.g0 z() {
        g0 g0Var = (g0) this;
        f1 f1VarV0 = g0Var.v0();
        if (f1VarV0.p()) {
            return null;
        }
        return f1VarV0.m(g0Var.Y(), (e1) this.f307w, 0L).f12645c;
    }

    @Override // v1.w0
    public void z0(int i) {
        ((g0) this).H0(i, i + 1);
    }

    public /* synthetic */ a(int i, boolean z10) {
        this.f306v = i;
    }

    public a(r1 r1Var) {
        this.f306v = 1;
        u.g(r1Var);
        this.f307w = r1Var;
    }

    public a(int i) {
        this.f306v = i;
        switch (i) {
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f307w = new LinkedHashMap();
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f307w = new e1();
                break;
            default:
                char[] cArr = s7.m.f11607a;
                this.f307w = new ArrayDeque(20);
                break;
        }
    }
}
