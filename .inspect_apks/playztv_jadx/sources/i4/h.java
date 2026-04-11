package i4;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import java.util.List;
import p1.f1;
import p1.l1;
import p1.n1;
import p1.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements p1.u0, View.OnClickListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ s f6226u;

    public h(s sVar) {
        this.f6226u = sVar;
    }

    @Override // p1.u0
    public final void M(p1.t0 t0Var) {
        p1.o oVar = t0Var.f10063a;
        boolean zA = oVar.a(4, 5, 13);
        s sVar = this.f6226u;
        if (zA) {
            sVar.m();
        }
        if (oVar.a(4, 5, 7, 13)) {
            sVar.o();
        }
        if (oVar.a(8, 13)) {
            sVar.p();
        }
        if (oVar.a(9, 13)) {
            sVar.r();
        }
        if (oVar.a(8, 9, 11, 0, 16, 17, 13)) {
            sVar.l();
        }
        if (oVar.a(11, 0, 13)) {
            sVar.s();
        }
        if (oVar.a(12, 13)) {
            sVar.n();
        }
        if (oVar.a(2, 13)) {
            sVar.t();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        s sVar = this.f6226u;
        ImageView imageView = sVar.Q;
        View view2 = sVar.V;
        View view3 = sVar.U;
        View view4 = sVar.T;
        x xVar = sVar.f6278u;
        p1.w0 w0Var = sVar.B0;
        if (w0Var == null) {
            return;
        }
        xVar.g();
        if (sVar.H == view) {
            if (w0Var.e0(9)) {
                w0Var.J0();
                return;
            }
            return;
        }
        if (sVar.G == view) {
            if (w0Var.e0(7)) {
                w0Var.R0();
                return;
            }
            return;
        }
        if (sVar.J == view) {
            if (w0Var.I() == 4 || !w0Var.e0(12)) {
                return;
            }
            w0Var.K0();
            return;
        }
        if (sVar.K == view) {
            if (w0Var.e0(11)) {
                w0Var.M0();
                return;
            }
            return;
        }
        if (sVar.I == view) {
            if (s1.b0.Y(w0Var, sVar.G0)) {
                s1.b0.F(w0Var);
                return;
            } else {
                if (w0Var.e0(1)) {
                    w0Var.f();
                    return;
                }
                return;
            }
        }
        if (sVar.N == view) {
            if (w0Var.e0(15)) {
                int iV0 = w0Var.v0();
                int i = sVar.L0;
                for (int i10 = 1; i10 <= 2; i10++) {
                    int i11 = (iV0 + i10) % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 != 2 || (i & 2) == 0) {
                            }
                        } else if ((i & 1) == 0) {
                        }
                    }
                    iV0 = i11;
                }
                w0Var.i0(iV0);
                return;
            }
            return;
        }
        if (sVar.O == view) {
            if (w0Var.e0(14)) {
                w0Var.G(!w0Var.C0());
                return;
            }
            return;
        }
        if (view4 == view) {
            xVar.f();
            sVar.e(sVar.f6288z, view4);
            return;
        }
        if (view3 == view) {
            xVar.f();
            sVar.e(sVar.A, view3);
        } else if (view2 == view) {
            xVar.f();
            sVar.e(sVar.C, view2);
        } else if (imageView == view) {
            xVar.f();
            sVar.e(sVar.B, imageView);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        s sVar = this.f6226u;
        if (sVar.R0) {
            sVar.f6278u.g();
        }
    }

    @Override // p1.u0
    public final /* synthetic */ void u() {
    }

    @Override // p1.u0
    public final /* synthetic */ void C(float f) {
    }

    @Override // p1.u0
    public final /* synthetic */ void E(int i) {
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
    public final /* synthetic */ void b(r1 r1Var) {
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
    public final /* synthetic */ void q(n1 n1Var) {
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
    public final /* synthetic */ void x(r1.c cVar) {
    }

    @Override // p1.u0
    public final /* synthetic */ void y(List list) {
    }

    @Override // p1.u0
    public final /* synthetic */ void B(int i, boolean z2) {
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

    @Override // p1.u0
    public final /* synthetic */ void F(int i, p1.v0 v0Var, p1.v0 v0Var2) {
    }
}
