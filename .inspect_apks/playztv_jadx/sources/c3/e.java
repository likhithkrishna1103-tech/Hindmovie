package c3;

import a2.o0;
import aa.j0;
import android.content.Context;
import b1.j;
import b8.h;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import k8.h1;
import k8.h4;
import k8.k1;
import k8.p0;
import k8.w1;
import k8.z0;
import p1.e1;
import p1.f1;
import p1.g0;
import p1.q0;
import p1.w0;
import q0.b1;
import q0.r1;
import s1.b0;
import t7.v;
import ub.o;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements w1, w0, r5.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f2454v;

    public /* synthetic */ e(int i, Object obj) {
        this.f2453u = i;
        this.f2454v = obj;
    }

    @Override // p1.w0
    public void A0(int i) {
        ((o0) this).H0(i, i + 1);
    }

    @Override // p1.w0
    public boolean D() {
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        return !f1VarW0.p() && f1VarW0.m(o0Var.d0(), (e1) this.f2454v, 0L).f9719h;
    }

    @Override // p1.w0
    public void E() {
        ((o0) this).H0(0, Integer.MAX_VALUE);
    }

    @Override // p1.w0
    public g0 F() {
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            return null;
        }
        return f1VarW0.m(o0Var.d0(), (e1) this.f2454v, 0L).f9715c;
    }

    @Override // p1.w0
    public void F0(long j5) {
        j1(((o0) this).d0(), j5, false);
    }

    @Override // p1.w0
    public void H() {
        int iE;
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            iE = -1;
        } else {
            int iD0 = o0Var.d0();
            o0Var.S1();
            int i = o0Var.f342a0;
            if (i == 1) {
                i = 0;
            }
            o0Var.S1();
            iE = f1VarW0.e(iD0, i, o0Var.f343b0);
        }
        if (iE == -1) {
            d1();
        } else if (iE == o0Var.d0()) {
            j1(o0Var.d0(), -9223372036854775807L, true);
        } else {
            j1(iE, -9223372036854775807L, false);
        }
    }

    @Override // p1.w0
    public void J0() {
        int iE;
        o0 o0Var = (o0) this;
        if (o0Var.w0().p() || o0Var.o()) {
            d1();
            return;
        }
        if (!b1()) {
            if (W0() && r0()) {
                j1(o0Var.d0(), -9223372036854775807L, false);
                return;
            } else {
                d1();
                return;
            }
        }
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            iE = -1;
        } else {
            int iD0 = o0Var.d0();
            o0Var.S1();
            int i = o0Var.f342a0;
            if (i == 1) {
                i = 0;
            }
            o0Var.S1();
            iE = f1VarW0.e(iD0, i, o0Var.f343b0);
        }
        if (iE == -1) {
            d1();
        } else if (iE == o0Var.d0()) {
            j1(o0Var.d0(), -9223372036854775807L, true);
        } else {
            j1(iE, -9223372036854775807L, false);
        }
    }

    @Override // p1.w0
    public void K0() {
        o0 o0Var = (o0) this;
        o0Var.S1();
        k1(12, o0Var.R);
    }

    @Override // p1.w0
    public int M() {
        o0 o0Var = (o0) this;
        long jA = o0Var.A();
        long duration = o0Var.getDuration();
        if (jA == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        int i = b0.f11647a;
        long jA2 = h.A(jA, 100L);
        return b0.i(q1.c.n((jA2 == Long.MAX_VALUE || jA2 == Long.MIN_VALUE) ? jA / (duration / 100) : jA2 / duration), 0, 100);
    }

    @Override // p1.w0
    public void M0() {
        o0 o0Var = (o0) this;
        o0Var.S1();
        k1(11, -o0Var.Q);
    }

    @Override // p1.w0
    public boolean P() {
        o0 o0Var = (o0) this;
        return o0Var.I() == 3 && o0Var.C() && o0Var.s0() == 0;
    }

    @Override // p1.w0
    public long Q() {
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            return -9223372036854775807L;
        }
        return b0.b0(f1VarW0.m(o0Var.d0(), (e1) this.f2454v, 0L).f9723m);
    }

    @Override // p1.w0
    public void R0() {
        o0 o0Var = (o0) this;
        if (o0Var.w0().p() || o0Var.o()) {
            d1();
            return;
        }
        boolean zC1 = c1();
        if (W0() && !D()) {
            if (zC1) {
                l1(7);
                return;
            } else {
                d1();
                return;
            }
        }
        if (zC1) {
            long jT0 = o0Var.T0();
            o0Var.S1();
            if (jT0 <= o0Var.S) {
                l1(7);
                return;
            }
        }
        j1(o0Var.d0(), 0L, false);
    }

    @Override // r5.e
    public List S0() {
        return (List) this.f2454v;
    }

    @Override // p1.w0
    public void U0(int i, g0 g0Var) {
        ((o0) this).t0(i, i + 1, j0.v(g0Var));
    }

    @Override // p1.w0
    public void V() {
        l1(6);
    }

    @Override // p1.w0
    public boolean W0() {
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        return !f1VarW0.p() && f1VarW0.m(o0Var.d0(), (e1) this.f2454v, 0L).a();
    }

    @Override // p1.w0
    public void X() {
        ((o0) this).m(true);
    }

    @Override // r5.e
    public boolean Y0() {
        List list = (List) this.f2454v;
        return list.isEmpty() || (list.size() == 1 && ((y5.a) list.get(0)).c());
    }

    @Override // p1.w0
    public void Z() {
        j1(((o0) this).d0(), -9223372036854775807L, false);
    }

    public abstract void Z0(o oVar);

    @Override // k8.w1
    public Context a() {
        return ((k1) this.f2454v).f7282u;
    }

    public abstract String a1();

    @Override // k8.w1
    public q9.e b() {
        return ((k1) this.f2454v).f7287z;
    }

    public boolean b1() {
        int iE;
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            iE = -1;
        } else {
            int iD0 = o0Var.d0();
            o0Var.S1();
            int i = o0Var.f342a0;
            if (i == 1) {
                i = 0;
            }
            o0Var.S1();
            iE = f1VarW0.e(iD0, i, o0Var.f343b0);
        }
        return iE != -1;
    }

    public boolean c1() {
        int iK;
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            iK = -1;
        } else {
            int iD0 = o0Var.d0();
            o0Var.S1();
            int i = o0Var.f342a0;
            if (i == 1) {
                i = 0;
            }
            o0Var.S1();
            iK = f1VarW0.k(iD0, i, o0Var.f343b0);
        }
        return iK != -1;
    }

    public void d1() {
        ((o0) this).S1();
    }

    @Override // p1.w0
    public boolean e0(int i) {
        o0 o0Var = (o0) this;
        o0Var.S1();
        return o0Var.f349h0.a(i);
    }

    public void e1(f6.h hVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f2454v;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(hVar);
        }
    }

    @Override // p1.w0
    public void f() {
        ((o0) this).m(false);
    }

    public abstract void f1(b1 b1Var);

    @Override // k8.w1
    public p0 g() {
        p0 p0Var = ((k1) this.f2454v).C;
        k1.f(p0Var);
        return p0Var;
    }

    public abstract void g1(b1 b1Var);

    public abstract r1 h1(r1 r1Var, List list);

    @Override // p1.w0
    public void i(float f) {
        o0 o0Var = (o0) this;
        o0Var.e(new q0(f, o0Var.h().f10039b));
    }

    public abstract pb.c i1(b1 b1Var, pb.c cVar);

    public abstract void j1(int i, long j5, boolean z2);

    public void k1(int i, long j5) {
        o0 o0Var = (o0) this;
        long jT0 = o0Var.T0() + j5;
        long duration = o0Var.getDuration();
        if (duration != -9223372036854775807L) {
            jT0 = Math.min(jT0, duration);
        }
        j1(o0Var.d0(), Math.max(jT0, 0L), false);
    }

    public void l1(int i) {
        int iK;
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p()) {
            iK = -1;
        } else {
            int iD0 = o0Var.d0();
            o0Var.S1();
            int i10 = o0Var.f342a0;
            if (i10 == 1) {
                i10 = 0;
            }
            o0Var.S1();
            iK = f1VarW0.k(iD0, i10, o0Var.f343b0);
        }
        if (iK == -1) {
            d1();
        } else if (iK == o0Var.d0()) {
            j1(o0Var.d0(), -9223372036854775807L, true);
        } else {
            j1(iK, -9223372036854775807L, false);
        }
    }

    public k8.e m1() {
        return ((k1) this.f2454v).A;
    }

    public z0 n1() {
        z0 z0Var = ((k1) this.f2454v).B;
        k1.d(z0Var);
        return z0Var;
    }

    public h4 o1() {
        h4 h4Var = ((k1) this.f2454v).F;
        k1.d(h4Var);
        return h4Var;
    }

    @Override // p1.w0
    public void p(int i) {
        j1(i, -9223372036854775807L, false);
    }

    @Override // p1.w0
    public void p0(int i, int i10) {
        if (i != i10) {
            ((o0) this).q0(i, i + 1, i10);
        }
    }

    public void p1() {
        h1 h1Var = ((k1) this.f2454v).D;
        k1.f(h1Var);
        h1Var.p1();
    }

    @Override // p1.w0
    public long r() {
        e1 e1Var = (e1) this.f2454v;
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        if (f1VarW0.p() || f1VarW0.m(o0Var.d0(), e1Var, 0L).f == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return (b0.y(e1Var.f9718g) - e1Var.f) - o0Var.s();
    }

    @Override // p1.w0
    public boolean r0() {
        o0 o0Var = (o0) this;
        f1 f1VarW0 = o0Var.w0();
        return !f1VarW0.p() && f1VarW0.m(o0Var.d0(), (e1) this.f2454v, 0L).i;
    }

    public String toString() {
        switch (this.f2453u) {
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                StringBuilder sb2 = new StringBuilder();
                List list = (List) this.f2454v;
                if (!list.isEmpty()) {
                    sb2.append("values=");
                    sb2.append(Arrays.toString(list.toArray()));
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    @Override // p1.w0
    public void u(int i, long j5) {
        j1(i, j5, false);
    }

    @Override // p1.w0
    public void u0(List list) {
        ((o0) this).v(Integer.MAX_VALUE, list);
    }

    @Override // k8.w1
    public h1 x() {
        h1 h1Var = ((k1) this.f2454v).D;
        k1.f(h1Var);
        return h1Var;
    }

    @Override // p1.w0
    public void y(g0 g0Var) {
        ((o0) this).Q0(j0.v(g0Var));
    }

    @Override // k8.w1
    public x7.a y0() {
        return ((k1) this.f2454v).H;
    }

    @Override // p1.w0
    public void z(g0 g0Var, long j5) {
        ((o0) this).j(j0.v(g0Var), 0, j5);
    }

    public /* synthetic */ e(int i, boolean z2) {
        this.f2453u = i;
    }

    public e(int i) {
        this.f2453u = i;
        switch (i) {
            case j.LONG_FIELD_NUMBER /* 4 */:
                this.f2454v = new LinkedHashMap();
                break;
            case j.STRING_FIELD_NUMBER /* 5 */:
                this.f2454v = new e1();
                break;
            default:
                char[] cArr = m.f14291a;
                this.f2454v = new ArrayDeque(20);
                break;
        }
    }

    public e(k1 k1Var) {
        this.f2453u = 3;
        v.h(k1Var);
        this.f2454v = k1Var;
    }
}
