package hc;

import a2.o0;
import android.widget.ProgressBar;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.PlayerActivity;
import java.util.List;
import p1.f1;
import p1.g0;
import p1.j0;
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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements u0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6056u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6057v;

    public /* synthetic */ q(int i, Object obj) {
        this.f6056u = i;
        this.f6057v = obj;
    }

    @Override // p1.u0
    public final /* synthetic */ void B(int i, boolean z2) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void C(float f) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final void E(int i) {
        switch (this.f6056u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                PlayerActivity playerActivity = (PlayerActivity) this.f6057v;
                if (i == 3) {
                    playerActivity.f3643w0 = 0;
                    playerActivity.C0 = false;
                }
                kc.a aVar = playerActivity.W;
                if (aVar != null) {
                    aVar.f7616h.setVisibility(i != 2 ? 8 : 0);
                }
                break;
            case 1:
                nc.e eVar = (nc.e) this.f6057v;
                if (i == 4) {
                    o0 o0Var = eVar.f8923s0;
                    o0Var.getClass();
                    o0Var.j1(o0Var.d0(), 0L, false);
                    eVar.f8923s0.X();
                } else if (i == 2) {
                    eVar.f8927w0.removeCallbacksAndMessages(null);
                }
                break;
            default:
                tc.g gVar = (tc.g) this.f6057v;
                if (i == 3) {
                    gVar.f12481u = 0;
                    gVar.f12484x = false;
                }
                b2.g gVar2 = gVar.f12465c;
                if (gVar2 != null) {
                    if (i != 2) {
                        ((ProgressBar) gVar2.f1740e).setVisibility(8);
                    } else {
                        ((ProgressBar) gVar2.f1740e).setVisibility(0);
                    }
                }
                break;
        }
    }

    @Override // p1.u0
    public final /* synthetic */ void F(int i, v0 v0Var, v0 v0Var2) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void G(boolean z2) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void H(int i, int i10) {
        int i11 = this.f6056u;
    }

    @Override // p1.u0
    public final void K(p0 p0Var) {
        switch (this.f6056u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                PlayerActivity playerActivity = (PlayerActivity) this.f6057v;
                int i = p0Var.f9984u;
                if (i == 1002) {
                    playerActivity.f3624c0.Z();
                    playerActivity.f3624c0.d();
                    playerActivity.f3624c0.X();
                } else if (i != 2004 || playerActivity.C0 || playerActivity.f3643w0 >= 3) {
                    playerActivity.f3633m0 = true;
                    playerActivity.W.f7616h.setVisibility(8);
                    playerActivity.X.f7644j.setVisibility(8);
                    playerActivity.X.f7645k.setVisibility(0);
                    playerActivity.B();
                } else {
                    playerActivity.f3624c0.Z();
                    playerActivity.f3624c0.d();
                    playerActivity.f3624c0.X();
                    playerActivity.f3643w0++;
                }
                break;
            case 1:
                ((nc.e) this.f6057v).P();
                break;
            default:
                tc.g gVar = (tc.g) this.f6057v;
                int i10 = p0Var.f9984u;
                if (i10 == 1002) {
                    gVar.f.Z();
                    gVar.f.d();
                    gVar.f.X();
                } else if (i10 != 2004 || gVar.f12484x || gVar.f12481u >= 3) {
                    gVar.f12482v = true;
                    ((ProgressBar) gVar.f12465c.f1740e).setVisibility(8);
                    gVar.g();
                } else {
                    gVar.f.Z();
                    gVar.f.d();
                    gVar.f.X();
                    gVar.f12481u++;
                }
                break;
        }
    }

    @Override // p1.u0
    public final /* synthetic */ void L(p0 p0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void M(t0 t0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void N(l1 l1Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void O(q0 q0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void P(boolean z2) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void a(boolean z2) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void b(r1 r1Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void d(int i) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void e(int i) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void f(int i) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void h(j0 j0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void i(boolean z2) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void j(int i) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void k(f1 f1Var, int i) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void n(j0 j0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void o(int i, g0 g0Var) {
        int i10 = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void p(s0 s0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void q(n1 n1Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void t(boolean z2) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void u() {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void v(l0 l0Var) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void w(p1.d dVar) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void x(r1.c cVar) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void y(List list) {
        int i = this.f6056u;
    }

    @Override // p1.u0
    public final /* synthetic */ void z(int i, boolean z2) {
        int i10 = this.f6056u;
    }

    private final /* synthetic */ void O0() {
    }

    private final /* synthetic */ void P0() {
    }

    private final /* synthetic */ void Q0() {
    }

    private final /* synthetic */ void A(s0 s0Var) {
    }

    private final /* synthetic */ void A0(p0 p0Var) {
    }

    private final /* synthetic */ void B0(p0 p0Var) {
    }

    private final /* synthetic */ void D(s0 s0Var) {
    }

    private final /* synthetic */ void F0(j0 j0Var) {
    }

    private final /* synthetic */ void G0(j0 j0Var) {
    }

    private final /* synthetic */ void H0(j0 j0Var) {
    }

    private final /* synthetic */ void I(s0 s0Var) {
    }

    private final /* synthetic */ void I0(int i) {
    }

    private final /* synthetic */ void J(List list) {
    }

    private final /* synthetic */ void K0(int i) {
    }

    private final /* synthetic */ void M0(int i) {
    }

    private final /* synthetic */ void Q(r1.c cVar) {
    }

    private final /* synthetic */ void R(List list) {
    }

    private final /* synthetic */ void R0(int i) {
    }

    private final /* synthetic */ void S(r1.c cVar) {
    }

    private final /* synthetic */ void S0(int i) {
    }

    private final /* synthetic */ void T(List list) {
    }

    private final /* synthetic */ void T0(int i) {
    }

    private final /* synthetic */ void U(r1.c cVar) {
    }

    private final /* synthetic */ void U0(boolean z2) {
    }

    private final /* synthetic */ void V(t0 t0Var) {
    }

    private final /* synthetic */ void V0(boolean z2) {
    }

    private final /* synthetic */ void W(t0 t0Var) {
    }

    private final /* synthetic */ void W0(boolean z2) {
    }

    private final /* synthetic */ void X(t0 t0Var) {
    }

    private final /* synthetic */ void X0(boolean z2) {
    }

    private final /* synthetic */ void Y(boolean z2) {
    }

    private final /* synthetic */ void Y0(boolean z2) {
    }

    private final /* synthetic */ void Z(boolean z2) {
    }

    private final /* synthetic */ void Z0(boolean z2) {
    }

    private final /* synthetic */ void a0(boolean z2) {
    }

    private final /* synthetic */ void b0(boolean z2) {
    }

    private final /* synthetic */ void c(p1.d dVar) {
    }

    private final /* synthetic */ void c0(boolean z2) {
    }

    private final /* synthetic */ void d0(boolean z2) {
    }

    private final /* synthetic */ void e0(boolean z2) {
    }

    private final /* synthetic */ void f0(boolean z2) {
    }

    private final /* synthetic */ void g(p1.d dVar) {
    }

    private final /* synthetic */ void g0(boolean z2) {
    }

    private final /* synthetic */ void g1(l1 l1Var) {
    }

    private final /* synthetic */ void h1(l1 l1Var) {
    }

    private final /* synthetic */ void i1(l1 l1Var) {
    }

    private final /* synthetic */ void j1(n1 n1Var) {
    }

    private final /* synthetic */ void k0(j0 j0Var) {
    }

    private final /* synthetic */ void k1(n1 n1Var) {
    }

    private final /* synthetic */ void l(p1.d dVar) {
    }

    private final /* synthetic */ void l0(j0 j0Var) {
    }

    private final /* synthetic */ void l1(n1 n1Var) {
    }

    private final /* synthetic */ void m(int i) {
    }

    private final /* synthetic */ void m0(j0 j0Var) {
    }

    private final /* synthetic */ void m1(r1 r1Var) {
    }

    private final /* synthetic */ void n0(l0 l0Var) {
    }

    private final /* synthetic */ void n1(r1 r1Var) {
    }

    private final /* synthetic */ void o0(l0 l0Var) {
    }

    private final /* synthetic */ void o1(r1 r1Var) {
    }

    private final /* synthetic */ void p0(l0 l0Var) {
    }

    private final /* synthetic */ void p1(float f) {
    }

    private final /* synthetic */ void q1(float f) {
    }

    private final /* synthetic */ void r(int i) {
    }

    private final /* synthetic */ void r1(float f) {
    }

    private final /* synthetic */ void s(int i) {
    }

    private final /* synthetic */ void t0(q0 q0Var) {
    }

    private final /* synthetic */ void u0(q0 q0Var) {
    }

    private final /* synthetic */ void v0(q0 q0Var) {
    }

    private final /* synthetic */ void w0(int i) {
    }

    private final /* synthetic */ void x0(int i) {
    }

    private final /* synthetic */ void y0(int i) {
    }

    private final /* synthetic */ void z0(p0 p0Var) {
    }

    private final /* synthetic */ void C0(int i, boolean z2) {
    }

    private final /* synthetic */ void D0(int i, boolean z2) {
    }

    private final /* synthetic */ void E0(int i, boolean z2) {
    }

    private final /* synthetic */ void a1(int i, int i10) {
    }

    private final /* synthetic */ void b1(int i, int i10) {
    }

    private final /* synthetic */ void c1(int i, int i10) {
    }

    private final /* synthetic */ void d1(f1 f1Var, int i) {
    }

    private final /* synthetic */ void e1(f1 f1Var, int i) {
    }

    private final /* synthetic */ void f1(f1 f1Var, int i) {
    }

    private final /* synthetic */ void h0(int i, g0 g0Var) {
    }

    private final /* synthetic */ void i0(int i, g0 g0Var) {
    }

    private final /* synthetic */ void j0(int i, g0 g0Var) {
    }

    private final /* synthetic */ void q0(int i, boolean z2) {
    }

    private final /* synthetic */ void r0(int i, boolean z2) {
    }

    private final /* synthetic */ void s0(int i, boolean z2) {
    }

    private final /* synthetic */ void J0(int i, v0 v0Var, v0 v0Var2) {
    }

    private final /* synthetic */ void L0(int i, v0 v0Var, v0 v0Var2) {
    }

    private final /* synthetic */ void N0(int i, v0 v0Var, v0 v0Var2) {
    }
}
