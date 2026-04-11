package m4;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import java.util.List;
import v1.f1;
import v1.l1;
import v1.n1;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements v1.u0, View.OnClickListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ q f8173v;

    public f(q qVar) {
        this.f8173v = qVar;
    }

    @Override // v1.u0
    public final void h(v1.t0 t0Var) {
        v1.n nVar = t0Var.f12993a;
        boolean zA = nVar.a(4, 5, 13);
        q qVar = this.f8173v;
        if (zA) {
            qVar.m();
        }
        if (nVar.a(4, 5, 7, 13)) {
            qVar.o();
        }
        if (nVar.a(8, 13)) {
            qVar.p();
        }
        if (nVar.a(9, 13)) {
            qVar.r();
        }
        if (nVar.a(8, 9, 11, 0, 16, 17, 13)) {
            qVar.l();
        }
        if (nVar.a(11, 0, 13)) {
            qVar.s();
        }
        if (nVar.a(12, 13)) {
            qVar.n();
        }
        if (nVar.a(2, 13)) {
            qVar.t();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q qVar = this.f8173v;
        ImageView imageView = qVar.R;
        View view2 = qVar.W;
        View view3 = qVar.V;
        View view4 = qVar.U;
        v vVar = qVar.f8248v;
        v1.w0 w0Var = qVar.C0;
        if (w0Var == null) {
            return;
        }
        vVar.g();
        if (qVar.I == view) {
            if (w0Var.Z(9)) {
                w0Var.J0();
                return;
            }
            return;
        }
        if (qVar.H == view) {
            if (w0Var.Z(7)) {
                w0Var.R0();
                return;
            }
            return;
        }
        if (qVar.K == view) {
            if (w0Var.E() == 4 || !w0Var.Z(12)) {
                return;
            }
            w0Var.K0();
            return;
        }
        if (qVar.L == view) {
            if (w0Var.Z(11)) {
                w0Var.M0();
                return;
            }
            return;
        }
        if (qVar.J == view) {
            if (y1.a0.Y(w0Var, qVar.H0)) {
                y1.a0.F(w0Var);
                return;
            } else {
                if (w0Var.Z(1)) {
                    w0Var.c();
                    return;
                }
                return;
            }
        }
        if (qVar.O == view) {
            if (w0Var.Z(15)) {
                int iU0 = w0Var.u0();
                int i = qVar.M0;
                for (int i10 = 1; i10 <= 2; i10++) {
                    int i11 = (iU0 + i10) % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 != 2 || (i & 2) == 0) {
                            }
                        } else if ((i & 1) == 0) {
                        }
                    }
                    iU0 = i11;
                }
                w0Var.g0(iU0);
                return;
            }
            return;
        }
        if (qVar.P == view) {
            if (w0Var.Z(14)) {
                w0Var.A(!w0Var.C0());
                return;
            }
            return;
        }
        if (view4 == view) {
            vVar.f();
            qVar.e(qVar.A, view4);
            return;
        }
        if (view3 == view) {
            vVar.f();
            qVar.e(qVar.B, view3);
        } else if (view2 == view) {
            vVar.f();
            qVar.e(qVar.D, view2);
        } else if (imageView == view) {
            vVar.f();
            qVar.e(qVar.C, imageView);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        q qVar = this.f8173v;
        if (qVar.S0) {
            qVar.f8248v.g();
        }
    }

    @Override // v1.u0
    public final /* synthetic */ void s() {
    }

    @Override // v1.u0
    public final /* synthetic */ void A(x1.c cVar) {
    }

    @Override // v1.u0
    public final /* synthetic */ void C(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void D(v1.q0 q0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void E(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void M(n1 n1Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void P(v1.s0 s0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void Q(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void a(r1 r1Var) {
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

    @Override // v1.u0
    public final /* synthetic */ void y(int i, boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void B(int i, v1.v0 v0Var, v1.v0 v0Var2) {
    }
}
