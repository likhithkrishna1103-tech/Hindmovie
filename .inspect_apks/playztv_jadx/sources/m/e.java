package m;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.fragment.app.t0;
import java.util.ArrayList;
import n.h2;
import n.k2;
import n.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends s implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int U = g.g.abc_cascading_menu_item_layout;
    public View H;
    public View I;
    public int J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public boolean P;
    public v Q;
    public ViewTreeObserver R;
    public PopupWindow.OnDismissListener S;
    public boolean T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f8185v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f8186w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f8187x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f8188y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Handler f8189z;
    public final ArrayList A = new ArrayList();
    public final ArrayList B = new ArrayList();
    public final l9.o C = new l9.o(1, this);
    public final t0 D = new t0(1, this);
    public final rc.b E = new rc.b(23, this);
    public int F = 0;
    public int G = 0;
    public boolean O = false;

    public e(Context context, View view, int i, boolean z2) {
        this.f8185v = context;
        this.H = view;
        this.f8187x = i;
        this.f8188y = z2;
        this.J = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f8186w = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.d.abc_config_prefDialogWidth));
        this.f8189z = new Handler();
    }

    @Override // m.a0
    public final boolean a() {
        ArrayList arrayList = this.B;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).f8182a.T.isShowing();
    }

    @Override // m.w
    public final void c(k kVar, boolean z2) {
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (kVar == ((d) arrayList.get(i)).f8183b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i10 = i + 1;
        if (i10 < arrayList.size()) {
            ((d) arrayList.get(i10)).f8183b.c(false);
        }
        d dVar = (d) arrayList.remove(i);
        k kVar2 = dVar.f8183b;
        k2 k2Var = dVar.f8182a;
        n.a0 a0Var = k2Var.T;
        kVar2.r(this);
        if (this.T) {
            h2.b(a0Var, null);
            a0Var.setAnimationStyle(0);
        }
        k2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.J = ((d) arrayList.get(size2 - 1)).f8184c;
        } else {
            this.J = this.H.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z2) {
                ((d) arrayList.get(0)).f8183b.c(false);
                return;
            }
            return;
        }
        dismiss();
        v vVar = this.Q;
        if (vVar != null) {
            vVar.c(kVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.R;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.R.removeGlobalOnLayoutListener(this.C);
            }
            this.R = null;
        }
        this.I.removeOnAttachStateChangeListener(this.D);
        this.S.onDismiss();
    }

    @Override // m.a0
    public final void d() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.A;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            w((k) obj);
        }
        arrayList.clear();
        View view = this.H;
        this.I = view;
        if (view != null) {
            boolean z2 = this.R == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.R = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.C);
            }
            this.I.addOnAttachStateChangeListener(this.D);
        }
    }

    @Override // m.a0
    public final void dismiss() {
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        if (size > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.f8182a.T.isShowing()) {
                    dVar.f8182a.dismiss();
                }
            }
        }
    }

    @Override // m.a0
    public final t1 e() {
        ArrayList arrayList = this.B;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).f8182a.f8383w;
    }

    @Override // m.w
    public final void f(boolean z2) {
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((d) obj).f8182a.f8383w.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((h) adapter).notifyDataSetChanged();
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
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d dVar = (d) obj;
            if (c0Var == dVar.f8183b) {
                dVar.f8182a.f8383w.requestFocus();
                return true;
            }
        }
        if (!c0Var.hasVisibleItems()) {
            return false;
        }
        n(c0Var);
        v vVar = this.Q;
        if (vVar != null) {
            vVar.x(c0Var);
        }
        return true;
    }

    @Override // m.w
    public final void l(v vVar) {
        this.Q = vVar;
    }

    @Override // m.s
    public final void n(k kVar) {
        kVar.b(this, this.f8185v);
        if (a()) {
            w(kVar);
        } else {
            this.A.add(kVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i);
            if (!dVar.f8182a.T.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (dVar != null) {
            dVar.f8183b.c(false);
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
        if (this.H != view) {
            this.H = view;
            this.G = Gravity.getAbsoluteGravity(this.F, view.getLayoutDirection());
        }
    }

    @Override // m.s
    public final void q(boolean z2) {
        this.O = z2;
    }

    @Override // m.s
    public final void r(int i) {
        if (this.F != i) {
            this.F = i;
            this.G = Gravity.getAbsoluteGravity(i, this.H.getLayoutDirection());
        }
    }

    @Override // m.s
    public final void s(int i) {
        this.K = true;
        this.M = i;
    }

    @Override // m.s
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.S = onDismissListener;
    }

    @Override // m.s
    public final void u(boolean z2) {
        this.P = z2;
    }

    @Override // m.s
    public final void v(int i) {
        this.L = true;
        this.N = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(m.k r20) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.e.w(m.k):void");
    }

    @Override // m.w
    public final void b(Parcelable parcelable) {
    }
}
