package n;

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
import androidx.fragment.app.y0;
import java.util.ArrayList;
import o.i2;
import o.l2;
import o.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends s implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int V = g.g.abc_cascading_menu_item_layout;
    public final Handler A;
    public View I;
    public View J;
    public int K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public boolean Q;
    public v R;
    public ViewTreeObserver S;
    public PopupWindow.OnDismissListener T;
    public boolean U;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f8502w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f8503x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f8504y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f8505z;
    public final ArrayList B = new ArrayList();
    public final ArrayList C = new ArrayList();
    public final fa.e D = new fa.e(1, this);
    public final y0 E = new y0(1, this);
    public final m2.e F = new m2.e(this);
    public int G = 0;
    public int H = 0;
    public boolean P = false;

    public e(Context context, View view, int i, boolean z10) {
        this.f8502w = context;
        this.I = view;
        this.f8504y = i;
        this.f8505z = z10;
        this.K = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f8503x = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(g.d.abc_config_prefDialogWidth));
        this.A = new Handler();
    }

    @Override // n.a0
    public final boolean a() {
        ArrayList arrayList = this.C;
        return arrayList.size() > 0 && ((d) arrayList.get(0)).f8499a.U.isShowing();
    }

    @Override // n.w
    public final void c(k kVar, boolean z10) {
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (kVar == ((d) arrayList.get(i)).f8500b) {
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
            ((d) arrayList.get(i10)).f8500b.c(false);
        }
        d dVar = (d) arrayList.remove(i);
        k kVar2 = dVar.f8500b;
        l2 l2Var = dVar.f8499a;
        o.y yVar = l2Var.U;
        kVar2.r(this);
        if (this.U) {
            i2.b(yVar, null);
            yVar.setAnimationStyle(0);
        }
        l2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.K = ((d) arrayList.get(size2 - 1)).f8501c;
        } else {
            this.K = this.I.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z10) {
                ((d) arrayList.get(0)).f8500b.c(false);
                return;
            }
            return;
        }
        dismiss();
        v vVar = this.R;
        if (vVar != null) {
            vVar.c(kVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.S;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.S.removeGlobalOnLayoutListener(this.D);
            }
            this.S = null;
        }
        this.J.removeOnAttachStateChangeListener(this.E);
        this.T.onDismiss();
    }

    @Override // n.a0
    public final void d() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.B;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            w((k) obj);
        }
        arrayList.clear();
        View view = this.I;
        this.J = view;
        if (view != null) {
            boolean z10 = this.S == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.S = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.D);
            }
            this.J.addOnAttachStateChangeListener(this.E);
        }
    }

    @Override // n.a0
    public final void dismiss() {
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        if (size > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.f8499a.U.isShowing()) {
                    dVar.f8499a.dismiss();
                }
            }
        }
    }

    @Override // n.w
    public final void e() {
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((d) obj).f8499a.f9231x.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((h) adapter).notifyDataSetChanged();
        }
    }

    @Override // n.a0
    public final t1 f() {
        ArrayList arrayList = this.C;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).f8499a.f9231x;
    }

    @Override // n.w
    public final boolean i(c0 c0Var) {
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d dVar = (d) obj;
            if (c0Var == dVar.f8500b) {
                dVar.f8499a.f9231x.requestFocus();
                return true;
            }
        }
        if (!c0Var.hasVisibleItems()) {
            return false;
        }
        n(c0Var);
        v vVar = this.R;
        if (vVar != null) {
            vVar.n(c0Var);
        }
        return true;
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
        this.R = vVar;
    }

    @Override // n.s
    public final void n(k kVar) {
        kVar.b(this, this.f8502w);
        if (a()) {
            w(kVar);
        } else {
            this.B.add(kVar);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i);
            if (!dVar.f8499a.U.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (dVar != null) {
            dVar.f8500b.c(false);
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
        if (this.I != view) {
            this.I = view;
            this.H = Gravity.getAbsoluteGravity(this.G, view.getLayoutDirection());
        }
    }

    @Override // n.s
    public final void q(boolean z10) {
        this.P = z10;
    }

    @Override // n.s
    public final void r(int i) {
        if (this.G != i) {
            this.G = i;
            this.H = Gravity.getAbsoluteGravity(i, this.I.getLayoutDirection());
        }
    }

    @Override // n.s
    public final void s(int i) {
        this.L = true;
        this.N = i;
    }

    @Override // n.s
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.T = onDismissListener;
    }

    @Override // n.s
    public final void u(boolean z10) {
        this.Q = z10;
    }

    @Override // n.s
    public final void v(int i) {
        this.M = true;
        this.O = i;
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
    public final void w(n.k r20) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.e.w(n.k):void");
    }

    @Override // n.w
    public final void b(Parcelable parcelable) {
    }
}
