package d6;

import android.widget.ProgressBar;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.PlayerActivity;
import g2.g0;
import java.util.List;
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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements u0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3420v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3421w;

    public /* synthetic */ j(int i, Object obj) {
        this.f3420v = i;
        this.f3421w = obj;
    }

    @Override // v1.u0
    public final /* synthetic */ void A(x1.c cVar) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void B(int i, v0 v0Var, v0 v0Var2) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final void C(int i) {
        switch (this.f3420v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i == 3) {
                    ((k) this.f3421w).f3441v = false;
                }
                break;
            case 1:
                PlayerActivity playerActivity = (PlayerActivity) this.f3421w;
                u5.a aVar = playerActivity.X;
                if (aVar != null) {
                    if (i != 2) {
                        if (i == 3) {
                            playerActivity.A0 = false;
                        }
                        ((ProgressBar) aVar.f12218h).setVisibility(8);
                    } else {
                        ((ProgressBar) aVar.f12218h).setVisibility(0);
                    }
                }
                break;
            default:
                x5.b bVar = (x5.b) this.f3421w;
                if (i == 4) {
                    g0 g0Var = bVar.f14331t0;
                    g0Var.getClass();
                    g0Var.j1(g0Var.Y(), 0L, false);
                    bVar.f14331t0.T();
                }
                break;
        }
    }

    @Override // v1.u0
    public final /* synthetic */ void D(q0 q0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void E(boolean z10) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void H(int i, int i10) {
        int i11 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void M(n1 n1Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void P(s0 s0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void Q(boolean z10) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void a(r1 r1Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void b(boolean z10) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void c(int i) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void d(int i) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void e(f1 f1Var, int i) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void g(int i) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void h(t0 t0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void i(l1 l1Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void j(j0 j0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void k(int i, v1.g0 g0Var) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void l(boolean z10) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void m(int i) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void n(j0 j0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void p(v1.c cVar) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void q(boolean z10) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void r(l0 l0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void s() {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final void u(p0 p0Var) {
        switch (this.f3420v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = (k) this.f3421w;
                kVar.f3439t = true;
                kVar.e();
                u5.d dVar = kVar.f3425d;
                if (dVar != null) {
                    dVar.f12255o.setVisibility(0);
                    kVar.f3425d.f12254n.setVisibility(8);
                }
                break;
            case 1:
                PlayerActivity playerActivity = (PlayerActivity) this.f3421w;
                u5.a aVar = playerActivity.X;
                if (aVar != null) {
                    playerActivity.f1528m0 = true;
                    ((ProgressBar) aVar.f12218h).setVisibility(8);
                    playerActivity.Y.f12238j.setVisibility(0);
                    playerActivity.Y.f12237h.setVisibility(8);
                    playerActivity.B();
                }
                break;
            default:
                ((x5.b) this.f3421w).R();
                break;
        }
    }

    @Override // v1.u0
    public final /* synthetic */ void v(p0 p0Var) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void w(List list) {
        int i = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void x(int i, boolean z10) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void y(int i, boolean z10) {
        int i10 = this.f3420v;
    }

    @Override // v1.u0
    public final /* synthetic */ void z(float f) {
        int i = this.f3420v;
    }

    private final /* synthetic */ void O0() {
    }

    private final /* synthetic */ void P0() {
    }

    private final /* synthetic */ void Q0() {
    }

    private final /* synthetic */ void A0(p0 p0Var) {
    }

    private final /* synthetic */ void B0(p0 p0Var) {
    }

    private final /* synthetic */ void F(int i) {
    }

    private final /* synthetic */ void F0(j0 j0Var) {
    }

    private final /* synthetic */ void G(int i) {
    }

    private final /* synthetic */ void G0(j0 j0Var) {
    }

    private final /* synthetic */ void H0(j0 j0Var) {
    }

    private final /* synthetic */ void I(int i) {
    }

    private final /* synthetic */ void I0(int i) {
    }

    private final /* synthetic */ void J(s0 s0Var) {
    }

    private final /* synthetic */ void K(s0 s0Var) {
    }

    private final /* synthetic */ void K0(int i) {
    }

    private final /* synthetic */ void L(s0 s0Var) {
    }

    private final /* synthetic */ void M0(int i) {
    }

    private final /* synthetic */ void N(List list) {
    }

    private final /* synthetic */ void O(x1.c cVar) {
    }

    private final /* synthetic */ void R(List list) {
    }

    private final /* synthetic */ void R0(int i) {
    }

    private final /* synthetic */ void S(x1.c cVar) {
    }

    private final /* synthetic */ void S0(int i) {
    }

    private final /* synthetic */ void T(List list) {
    }

    private final /* synthetic */ void T0(int i) {
    }

    private final /* synthetic */ void U(x1.c cVar) {
    }

    private final /* synthetic */ void U0(boolean z10) {
    }

    private final /* synthetic */ void V(t0 t0Var) {
    }

    private final /* synthetic */ void V0(boolean z10) {
    }

    private final /* synthetic */ void W(t0 t0Var) {
    }

    private final /* synthetic */ void W0(boolean z10) {
    }

    private final /* synthetic */ void X(t0 t0Var) {
    }

    private final /* synthetic */ void X0(boolean z10) {
    }

    private final /* synthetic */ void Y(boolean z10) {
    }

    private final /* synthetic */ void Y0(boolean z10) {
    }

    private final /* synthetic */ void Z(boolean z10) {
    }

    private final /* synthetic */ void Z0(boolean z10) {
    }

    private final /* synthetic */ void a0(boolean z10) {
    }

    private final /* synthetic */ void b0(boolean z10) {
    }

    private final /* synthetic */ void c0(boolean z10) {
    }

    private final /* synthetic */ void d0(boolean z10) {
    }

    private final /* synthetic */ void e0(boolean z10) {
    }

    private final /* synthetic */ void f(v1.c cVar) {
    }

    private final /* synthetic */ void f0(boolean z10) {
    }

    private final /* synthetic */ void g0(boolean z10) {
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

    private final /* synthetic */ void l0(j0 j0Var) {
    }

    private final /* synthetic */ void l1(n1 n1Var) {
    }

    private final /* synthetic */ void m0(j0 j0Var) {
    }

    private final /* synthetic */ void m1(r1 r1Var) {
    }

    private final /* synthetic */ void n0(l0 l0Var) {
    }

    private final /* synthetic */ void n1(r1 r1Var) {
    }

    private final /* synthetic */ void o(v1.c cVar) {
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

    private final /* synthetic */ void r1(float f) {
    }

    private final /* synthetic */ void t(v1.c cVar) {
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

    private final /* synthetic */ void C0(int i, boolean z10) {
    }

    private final /* synthetic */ void D0(int i, boolean z10) {
    }

    private final /* synthetic */ void E0(int i, boolean z10) {
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

    private final /* synthetic */ void h0(int i, v1.g0 g0Var) {
    }

    private final /* synthetic */ void i0(int i, v1.g0 g0Var) {
    }

    private final /* synthetic */ void j0(int i, v1.g0 g0Var) {
    }

    private final /* synthetic */ void q0(int i, boolean z10) {
    }

    private final /* synthetic */ void r0(int i, boolean z10) {
    }

    private final /* synthetic */ void s0(int i, boolean z10) {
    }

    private final /* synthetic */ void J0(int i, v0 v0Var, v0 v0Var2) {
    }

    private final /* synthetic */ void L0(int i, v0 v0Var, v0 v0Var2) {
    }

    private final /* synthetic */ void N0(int i, v0 v0Var, v0 v0Var2) {
    }
}
