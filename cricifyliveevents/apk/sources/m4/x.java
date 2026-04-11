package m4;

import android.view.TextureView;
import android.view.View;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
import java.util.List;
import v1.c1;
import v1.f1;
import v1.l1;
import v1.n1;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements v1.u0, View.OnLayoutChangeListener, View.OnClickListener, p, g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c1 f8299v = new c1();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f8300w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ PlayerView f8301x;

    public x(PlayerView playerView) {
        this.f8301x = playerView;
    }

    @Override // v1.u0
    public final void A(x1.c cVar) {
        SubtitleView subtitleView = this.f8301x.B;
        if (subtitleView != null) {
            subtitleView.setCues(cVar.f14268a);
        }
    }

    @Override // v1.u0
    public final void B(int i, v1.v0 v0Var, v1.v0 v0Var2) {
        int i10 = PlayerView.U;
        PlayerView playerView = this.f8301x;
        if (playerView.c() && playerView.S) {
            playerView.b();
        }
    }

    @Override // v1.u0
    public final void C(int i) {
        int i10 = PlayerView.U;
        PlayerView playerView = this.f8301x;
        playerView.j();
        playerView.l();
        if (playerView.c() && playerView.S) {
            playerView.b();
        } else {
            playerView.d(false);
        }
    }

    @Override // v1.u0
    public final void M(n1 n1Var) {
        PlayerView playerView = this.f8301x;
        v1.w0 w0Var = playerView.H;
        w0Var.getClass();
        f1 f1VarV0 = w0Var.Z(17) ? w0Var.v0() : f1.f12674a;
        if (f1VarV0.p()) {
            this.f8300w = null;
        } else {
            boolean Z = w0Var.Z(30);
            c1 c1Var = this.f8299v;
            if (!Z || w0Var.G().f12882a.isEmpty()) {
                Object obj = this.f8300w;
                if (obj != null) {
                    int iB = f1VarV0.b(obj);
                    if (iB != -1) {
                        if (w0Var.Y() == f1VarV0.f(iB, c1Var, false).f12618c) {
                            return;
                        }
                    }
                    this.f8300w = null;
                }
            } else {
                this.f8300w = f1VarV0.f(w0Var.O(), c1Var, true).f12617b;
            }
        }
        playerView.m(false);
    }

    @Override // v1.u0
    public final void a(r1 r1Var) {
        PlayerView playerView;
        v1.w0 w0Var;
        if (r1Var.equals(r1.f12978d) || (w0Var = (playerView = this.f8301x).H) == null || w0Var.E() == 1) {
            return;
        }
        playerView.i();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = PlayerView.U;
        this.f8301x.h();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        PlayerView.a((TextureView) view);
    }

    @Override // v1.u0
    public final void s() {
        View view = this.f8301x.f1307x;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // v1.u0
    public final void y(int i, boolean z10) {
        int i10 = PlayerView.U;
        PlayerView playerView = this.f8301x;
        playerView.j();
        if (playerView.c() && playerView.S) {
            playerView.b();
        } else {
            playerView.d(false);
        }
    }

    @Override // v1.u0
    public final /* synthetic */ void D(v1.q0 q0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void E(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void P(v1.s0 s0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void Q(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void b(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void c(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void d(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void g(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void h(v1.t0 t0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void i(l1 l1Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void j(v1.j0 j0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void l(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void m(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void n(v1.j0 j0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void p(v1.c cVar) {
    }

    @Override // v1.u0
    public final /* synthetic */ void q(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void r(v1.l0 l0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void u(v1.p0 p0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void v(v1.p0 p0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void w(List list) {
    }

    @Override // v1.u0
    public final /* synthetic */ void z(float f) {
    }

    @Override // v1.u0
    public final /* synthetic */ void H(int i, int i10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void e(f1 f1Var, int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void k(int i, v1.g0 g0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void x(int i, boolean z10) {
    }
}
