package i4;

import android.view.TextureView;
import android.view.View;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
import java.util.List;
import p1.c1;
import p1.f1;
import p1.l1;
import p1.n1;
import p1.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements p1.u0, View.OnLayoutChangeListener, View.OnClickListener, r, i {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c1 f6350u = new c1();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f6351v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ PlayerView f6352w;

    public z(PlayerView playerView) {
        this.f6352w = playerView;
    }

    @Override // p1.u0
    public final void B(int i, boolean z2) {
        int i10 = PlayerView.T;
        PlayerView playerView = this.f6352w;
        playerView.k();
        if (playerView.d() && playerView.R) {
            playerView.b();
        } else {
            playerView.e(false);
        }
    }

    @Override // p1.u0
    public final void E(int i) {
        int i10 = PlayerView.T;
        PlayerView playerView = this.f6352w;
        playerView.k();
        playerView.m();
        if (playerView.d() && playerView.R) {
            playerView.b();
        } else {
            playerView.e(false);
        }
    }

    @Override // p1.u0
    public final void F(int i, p1.v0 v0Var, p1.v0 v0Var2) {
        int i10 = PlayerView.T;
        PlayerView playerView = this.f6352w;
        if (playerView.d() && playerView.R) {
            playerView.b();
        }
    }

    @Override // p1.u0
    public final void b(r1 r1Var) {
        PlayerView playerView;
        p1.w0 w0Var;
        if (r1Var.equals(r1.f10046d) || (w0Var = (playerView = this.f6352w).G) == null || w0Var.I() == 1) {
            return;
        }
        playerView.j();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = PlayerView.T;
        this.f6352w.i();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        PlayerView.a((TextureView) view);
    }

    @Override // p1.u0
    public final void q(n1 n1Var) {
        PlayerView playerView = this.f6352w;
        p1.w0 w0Var = playerView.G;
        w0Var.getClass();
        f1 f1VarW0 = w0Var.e0(17) ? w0Var.w0() : f1.f9741a;
        if (f1VarW0.p()) {
            this.f6351v = null;
        } else {
            boolean zE0 = w0Var.e0(30);
            c1 c1Var = this.f6350u;
            if (!zE0 || w0Var.L().f9952a.isEmpty()) {
                Object obj = this.f6351v;
                if (obj != null) {
                    int iB = f1VarW0.b(obj);
                    if (iB != -1) {
                        if (w0Var.d0() == f1VarW0.f(iB, c1Var, false).f9678c) {
                            return;
                        }
                    }
                    this.f6351v = null;
                }
            } else {
                this.f6351v = f1VarW0.f(w0Var.R(), c1Var, true).f9677b;
            }
        }
        playerView.n(false);
    }

    @Override // p1.u0
    public final void u() {
        View view = this.f6352w.f1613w;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // p1.u0
    public final void x(r1.c cVar) {
        SubtitleView subtitleView = this.f6352w.A;
        if (subtitleView != null) {
            subtitleView.setCues(cVar.f11272a);
        }
    }

    @Override // p1.u0
    public final /* synthetic */ void C(float f) {
    }

    @Override // p1.u0
    public final /* synthetic */ void G(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void K(p1.p0 p0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void L(p1.p0 p0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void M(p1.t0 t0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void N(l1 l1Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void O(p1.q0 q0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void P(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void a(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void d(int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void e(int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void f(int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void h(p1.j0 j0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void i(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void j(int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void n(p1.j0 j0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void p(p1.s0 s0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void t(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void v(p1.l0 l0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void w(p1.d dVar) {
    }

    @Override // p1.u0
    public final /* synthetic */ void y(List list) {
    }

    @Override // p1.u0
    public final /* synthetic */ void H(int i, int i10) {
    }

    @Override // p1.u0
    public final /* synthetic */ void k(f1 f1Var, int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void o(int i, p1.g0 g0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void z(int i, boolean z2) {
    }
}
