package m;

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
import androidx.fragment.app.t0;
import n.k2;
import n.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends s implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public static final int O = g.g.abc_popup_menu_item_layout;
    public final int A;
    public final k2 B;
    public PopupWindow.OnDismissListener E;
    public View F;
    public View G;
    public v H;
    public ViewTreeObserver I;
    public boolean J;
    public boolean K;
    public int L;
    public boolean N;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f8176v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f8177w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f8178x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f8179y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f8180z;
    public final l9.o C = new l9.o(2, this);
    public final t0 D = new t0(2, this);
    public int M = 0;

    public b0(Context context, k kVar, View view, int i, boolean z2) {
        this.f8176v = context;
        this.f8177w = kVar;
        this.f8179y = z2;
        this.f8178x = new h(kVar, LayoutInflater.from(context), z2, O);
        this.A = i;
        Resources resources = context.getResources();
        this.f8180z = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.d.abc_config_prefDialogWidth));
        this.F = view;
        this.B = new k2(context, null, i, 0);
        kVar.b(this, context);
    }

    @Override // m.a0
    public final boolean a() {
        return !this.J && this.B.T.isShowing();
    }

    @Override // m.w
    public final void c(k kVar, boolean z2) {
        if (kVar != this.f8177w) {
            return;
        }
        dismiss();
        v vVar = this.H;
        if (vVar != null) {
            vVar.c(kVar, z2);
        }
    }

    @Override // m.a0
    public final void d() {
        View view;
        if (a()) {
            return;
        }
        if (this.J || (view = this.F) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.G = view;
        k2 k2Var = this.B;
        n.a0 a0Var = k2Var.T;
        n.a0 a0Var2 = k2Var.T;
        a0Var.setOnDismissListener(this);
        k2Var.J = this;
        k2Var.S = true;
        a0Var2.setFocusable(true);
        View view2 = this.G;
        boolean z2 = this.I == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.I = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.C);
        }
        view2.addOnAttachStateChangeListener(this.D);
        k2Var.I = view2;
        k2Var.F = this.M;
        boolean z10 = this.K;
        Context context = this.f8176v;
        h hVar = this.f8178x;
        if (!z10) {
            this.L = s.o(hVar, context, this.f8180z);
            this.K = true;
        }
        k2Var.q(this.L);
        a0Var2.setInputMethodMode(2);
        Rect rect = this.f8263u;
        k2Var.R = rect != null ? new Rect(rect) : null;
        k2Var.d();
        t1 t1Var = k2Var.f8383w;
        t1Var.setOnKeyListener(this);
        if (this.N) {
            k kVar = this.f8177w;
            if (kVar.f8215m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(g.g.abc_popup_menu_header_item_layout, (ViewGroup) t1Var, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(kVar.f8215m);
                }
                frameLayout.setEnabled(false);
                t1Var.addHeaderView(frameLayout, null, false);
            }
        }
        k2Var.o(hVar);
        k2Var.d();
    }

    @Override // m.a0
    public final void dismiss() {
        if (a()) {
            this.B.dismiss();
        }
    }

    @Override // m.a0
    public final t1 e() {
        return this.B.f8383w;
    }

    @Override // m.w
    public final void f(boolean z2) {
        this.K = false;
        h hVar = this.f8178x;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // m.w
    public final boolean i() {
        return false;
    }

    @Override // m.w
    public final Parcelable j() {
        return null;
    }

    @Override // m.w
    public final boolean k(c0 c0Var) {
        boolean z2;
        if (c0Var.hasVisibleItems()) {
            u uVar = new u(this.f8176v, c0Var, this.G, this.f8179y, this.A, 0);
            v vVar = this.H;
            uVar.f8272h = vVar;
            s sVar = uVar.i;
            if (sVar != null) {
                sVar.l(vVar);
            }
            int size = c0Var.f.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z2 = false;
                    break;
                }
                MenuItem item = c0Var.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z2 = true;
                    break;
                }
                i++;
            }
            uVar.f8271g = z2;
            s sVar2 = uVar.i;
            if (sVar2 != null) {
                sVar2.q(z2);
            }
            uVar.f8273j = this.E;
            this.E = null;
            this.f8177w.c(false);
            k2 k2Var = this.B;
            int width = k2Var.f8386z;
            int iM = k2Var.m();
            if ((Gravity.getAbsoluteGravity(this.M, this.F.getLayoutDirection()) & 7) == 5) {
                width += this.F.getWidth();
            }
            if (!uVar.b()) {
                if (uVar.f8270e != null) {
                    uVar.d(width, iM, true, true);
                }
            }
            v vVar2 = this.H;
            if (vVar2 != null) {
                vVar2.x(c0Var);
            }
            return true;
        }
        return false;
    }

    @Override // m.w
    public final void l(v vVar) {
        this.H = vVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.J = true;
        this.f8177w.c(true);
        ViewTreeObserver viewTreeObserver = this.I;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.I = this.G.getViewTreeObserver();
            }
            this.I.removeGlobalOnLayoutListener(this.C);
            this.I = null;
        }
        this.G.removeOnAttachStateChangeListener(this.D);
        PopupWindow.OnDismissListener onDismissListener = this.E;
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

    @Override // m.s
    public final void p(View view) {
        this.F = view;
    }

    @Override // m.s
    public final void q(boolean z2) {
        this.f8178x.f8200w = z2;
    }

    @Override // m.s
    public final void r(int i) {
        this.M = i;
    }

    @Override // m.s
    public final void s(int i) {
        this.B.f8386z = i;
    }

    @Override // m.s
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // m.s
    public final void u(boolean z2) {
        this.N = z2;
    }

    @Override // m.s
    public final void v(int i) {
        this.B.i(i);
    }

    @Override // m.w
    public final void b(Parcelable parcelable) {
    }

    @Override // m.s
    public final void n(k kVar) {
    }
}
