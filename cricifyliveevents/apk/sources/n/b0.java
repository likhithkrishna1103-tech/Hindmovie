package n;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.y0;
import o.l2;
import o.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends s implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public static final int P = g.g.abc_popup_menu_item_layout;
    public final int A;
    public final int B;
    public final l2 C;
    public PopupWindow.OnDismissListener F;
    public View G;
    public View H;
    public v I;
    public ViewTreeObserver J;
    public boolean K;
    public boolean L;
    public int M;
    public boolean O;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f8494w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f8495x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h f8496y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f8497z;
    public final fa.e D = new fa.e(2, this);
    public final y0 E = new y0(2, this);
    public int N = 0;

    public b0(Context context, k kVar, View view, int i, boolean z10) {
        this.f8494w = context;
        this.f8495x = kVar;
        this.f8497z = z10;
        this.f8496y = new h(kVar, LayoutInflater.from(context), z10, P);
        this.B = i;
        Resources resources = context.getResources();
        this.A = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.d.abc_config_prefDialogWidth));
        this.G = view;
        this.C = new l2(context, null, i, 0);
        kVar.b(this, context);
    }

    @Override // n.a0
    public final boolean a() {
        return !this.K && this.C.U.isShowing();
    }

    @Override // n.w
    public final void c(k kVar, boolean z10) {
        if (kVar != this.f8495x) {
            return;
        }
        dismiss();
        v vVar = this.I;
        if (vVar != null) {
            vVar.c(kVar, z10);
        }
    }

    @Override // n.a0
    public final void d() {
        View view;
        if (a()) {
            return;
        }
        if (this.K || (view = this.G) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.H = view;
        l2 l2Var = this.C;
        o.y yVar = l2Var.U;
        o.y yVar2 = l2Var.U;
        yVar.setOnDismissListener(this);
        l2Var.K = this;
        l2Var.T = true;
        yVar2.setFocusable(true);
        View view2 = this.H;
        boolean z10 = this.J == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.J = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.D);
        }
        view2.addOnAttachStateChangeListener(this.E);
        l2Var.J = view2;
        l2Var.G = this.N;
        boolean z11 = this.L;
        Context context = this.f8494w;
        h hVar = this.f8496y;
        if (!z11) {
            this.M = s.o(hVar, context, this.A);
            this.L = true;
        }
        l2Var.r(this.M);
        yVar2.setInputMethodMode(2);
        Rect rect = this.f8577v;
        l2Var.S = rect != null ? new Rect(rect) : null;
        l2Var.d();
        t1 t1Var = l2Var.f9231x;
        t1Var.setOnKeyListener(this);
        if (this.O) {
            k kVar = this.f8495x;
            if (kVar.f8529m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(g.g.abc_popup_menu_header_item_layout, (ViewGroup) t1Var, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(kVar.f8529m);
                }
                frameLayout.setEnabled(false);
                t1Var.addHeaderView(frameLayout, null, false);
            }
        }
        l2Var.p(hVar);
        l2Var.d();
    }

    @Override // n.a0
    public final void dismiss() {
        if (a()) {
            this.C.dismiss();
        }
    }

    @Override // n.w
    public final void e() {
        this.L = false;
        h hVar = this.f8496y;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // n.a0
    public final t1 f() {
        return this.C.f9231x;
    }

    @Override // n.w
    public final boolean i(c0 c0Var) {
        boolean z10;
        if (c0Var.hasVisibleItems()) {
            u uVar = new u(this.f8494w, c0Var, this.H, this.f8497z, this.B, 0);
            v vVar = this.I;
            uVar.f8586h = vVar;
            s sVar = uVar.i;
            if (sVar != null) {
                sVar.l(vVar);
            }
            int size = c0Var.f.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z10 = false;
                    break;
                }
                MenuItem item = c0Var.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z10 = true;
                    break;
                }
                i++;
            }
            uVar.f8585g = z10;
            s sVar2 = uVar.i;
            if (sVar2 != null) {
                sVar2.q(z10);
            }
            uVar.f8587j = this.F;
            this.F = null;
            this.f8495x.c(false);
            l2 l2Var = this.C;
            int width = l2Var.A;
            int iM = l2Var.m();
            if ((Gravity.getAbsoluteGravity(this.N, this.G.getLayoutDirection()) & 7) == 5) {
                width += this.G.getWidth();
            }
            if (!uVar.b()) {
                if (uVar.f8584e != null) {
                    uVar.d(width, iM, true, true);
                }
            }
            v vVar2 = this.I;
            if (vVar2 != null) {
                vVar2.n(c0Var);
            }
            return true;
        }
        return false;
    }

    @Override // n.w
    public final boolean j() {
        return false;
    }

    @Override // n.w
    public final Parcelable k() {
        return null;
    }

    @Override // n.w
    public final void l(v vVar) {
        this.I = vVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.K = true;
        this.f8495x.c(true);
        ViewTreeObserver viewTreeObserver = this.J;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.J = this.H.getViewTreeObserver();
            }
            this.J.removeGlobalOnLayoutListener(this.D);
            this.J = null;
        }
        this.H.removeOnAttachStateChangeListener(this.E);
        PopupWindow.OnDismissListener onDismissListener = this.F;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // n.s
    public final void p(View view) {
        this.G = view;
    }

    @Override // n.s
    public final void q(boolean z10) {
        this.f8496y.f8515x = z10;
    }

    @Override // n.s
    public final void r(int i) {
        this.N = i;
    }

    @Override // n.s
    public final void s(int i) {
        this.C.A = i;
    }

    @Override // n.s
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.F = onDismissListener;
    }

    @Override // n.s
    public final void u(boolean z10) {
        this.O = z10;
    }

    @Override // n.s
    public final void v(int i) {
        this.C.i(i);
    }

    @Override // n.w
    public final void b(Parcelable parcelable) {
    }

    @Override // n.s
    public final void n(k kVar) {
    }
}
