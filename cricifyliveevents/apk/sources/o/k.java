package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements n.w {
    public final int A;
    public final int B;
    public n.y C;
    public int D;
    public i E;
    public Drawable F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public final SparseBooleanArray N;
    public f O;
    public f P;
    public h Q;
    public g R;
    public final kf.i S;
    public int T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f9249v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Context f9250w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public n.k f9251x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LayoutInflater f9252y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n.v f9253z;

    public k(Context context) {
        int i = g.g.abc_action_menu_layout;
        int i10 = g.g.abc_action_menu_item_layout;
        this.f9249v = context;
        this.f9252y = LayoutInflater.from(context);
        this.A = i;
        this.B = i10;
        this.N = new SparseBooleanArray();
        this.S = new kf.i(9, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(n.m mVar, View view, ViewGroup viewGroup) {
        View actionView = mVar.getActionView();
        if (actionView == null || mVar.e()) {
            n.x xVar = view instanceof n.x ? (n.x) view : (n.x) this.f9252y.inflate(this.B, viewGroup, false);
            xVar.a(mVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) xVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.C);
            if (this.R == null) {
                this.R = new g(this);
            }
            actionMenuItemView.setPopupCallback(this.R);
            actionView = (View) xVar;
        }
        actionView.setVisibility(mVar.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof m)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    @Override // n.w
    public final void b(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof j) && (i = ((j) parcelable).f9246v) > 0 && (menuItemFindItem = this.f9251x.findItem(i)) != null) {
            i((n.c0) menuItemFindItem.getSubMenu());
        }
    }

    @Override // n.w
    public final void c(n.k kVar, boolean z10) {
        d();
        f fVar = this.P;
        if (fVar != null && fVar.b()) {
            fVar.i.dismiss();
        }
        n.v vVar = this.f9253z;
        if (vVar != null) {
            vVar.c(kVar, z10);
        }
    }

    public final boolean d() {
        Object obj;
        h hVar = this.Q;
        if (hVar != null && (obj = this.C) != null) {
            ((View) obj).removeCallbacks(hVar);
            this.Q = null;
            return true;
        }
        f fVar = this.O;
        if (fVar == null) {
            return false;
        }
        if (fVar.b()) {
            fVar.i.dismiss();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.w
    public final void e() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.C;
        ArrayList arrayList = null;
        boolean z10 = false;
        if (viewGroup != null) {
            n.k kVar = this.f9251x;
            if (kVar != null) {
                kVar.i();
                ArrayList arrayListL = this.f9251x.l();
                int size = arrayListL.size();
                i = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    n.m mVar = (n.m) arrayListL.get(i10);
                    if ((mVar.f8565x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        n.m itemData = childAt instanceof n.x ? ((n.x) childAt).getItemData() : null;
                        View viewA = a(mVar, childAt, viewGroup);
                        if (mVar != itemData) {
                            viewA.setPressed(false);
                            viewA.jumpDrawablesToCurrentState();
                        }
                        if (viewA != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewA.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewA);
                            }
                            ((ViewGroup) this.C).addView(viewA, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.E) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.C).requestLayout();
        n.k kVar2 = this.f9251x;
        if (kVar2 != null) {
            kVar2.i();
            ArrayList arrayList2 = kVar2.i;
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                n.n nVar = ((n.m) arrayList2.get(i11)).A;
            }
        }
        n.k kVar3 = this.f9251x;
        if (kVar3 != null) {
            kVar3.i();
            arrayList = kVar3.f8526j;
        }
        if (this.H && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z10 = !((n.m) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z10 = true;
            }
        }
        if (z10) {
            if (this.E == null) {
                this.E = new i(this, this.f9249v);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.E.getParent();
            if (viewGroup3 != this.C) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.E);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.C;
                i iVar = this.E;
                actionMenuView.getClass();
                m mVarJ = ActionMenuView.j();
                mVarJ.f9269a = true;
                actionMenuView.addView(iVar, mVarJ);
            }
        } else {
            i iVar2 = this.E;
            if (iVar2 != null) {
                Object parent = iVar2.getParent();
                Object obj = this.C;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.E);
                }
            }
        }
        ((ActionMenuView) this.C).setOverflowReserved(this.H);
    }

    public final boolean f() {
        f fVar = this.O;
        return fVar != null && fVar.b();
    }

    @Override // n.w
    public final boolean g(n.m mVar) {
        return false;
    }

    @Override // n.w
    public final int getId() {
        return this.D;
    }

    @Override // n.w
    public final void h(Context context, n.k kVar) {
        this.f9250w = context;
        LayoutInflater.from(context);
        this.f9251x = kVar;
        Resources resources = context.getResources();
        if (!this.I) {
            this.H = true;
        }
        int i = 2;
        this.J = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600 || ((i10 > 960 && i11 > 720) || (i10 > 720 && i11 > 960))) {
            i = 5;
        } else if (i10 >= 500 || ((i10 > 640 && i11 > 480) || (i10 > 480 && i11 > 640))) {
            i = 4;
        } else if (i10 >= 360) {
            i = 3;
        }
        this.L = i;
        int measuredWidth = this.J;
        if (this.H) {
            if (this.E == null) {
                i iVar = new i(this, this.f9249v);
                this.E = iVar;
                if (this.G) {
                    iVar.setImageDrawable(this.F);
                    this.F = null;
                    this.G = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.E.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.E.getMeasuredWidth();
        } else {
            this.E = null;
        }
        this.K = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.w
    public final boolean i(n.c0 c0Var) {
        boolean z10;
        if (c0Var.hasVisibleItems()) {
            n.c0 c0Var2 = c0Var;
            while (true) {
                n.k kVar = c0Var2.f8498z;
                if (kVar == this.f9251x) {
                    break;
                }
                c0Var2 = (n.c0) kVar;
            }
            n.m mVar = c0Var2.A;
            ViewGroup viewGroup = (ViewGroup) this.C;
            View view = null;
            view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof n.x) && ((n.x) childAt).getItemData() == mVar) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                this.T = c0Var.A.f8544a;
                int size = c0Var.f.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        z10 = false;
                        break;
                    }
                    MenuItem item = c0Var.getItem(i10);
                    if (item.isVisible() && item.getIcon() != null) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
                f fVar = new f(this, this.f9250w, c0Var, view);
                this.P = fVar;
                fVar.f8585g = z10;
                n.s sVar = fVar.i;
                if (sVar != null) {
                    sVar.q(z10);
                }
                f fVar2 = this.P;
                if (!fVar2.b()) {
                    if (fVar2.f8584e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    fVar2.d(0, 0, false, false);
                }
                n.v vVar = this.f9253z;
                if (vVar != null) {
                    vVar.n(c0Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // n.w
    public final boolean j() {
        int size;
        ArrayList arrayListL;
        int i;
        boolean z10;
        k kVar = this;
        n.k kVar2 = kVar.f9251x;
        if (kVar2 != null) {
            arrayListL = kVar2.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i10 = kVar.L;
        int i11 = kVar.K;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) kVar.C;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i = 2;
            z10 = true;
            if (i12 >= size) {
                break;
            }
            n.m mVar = (n.m) arrayListL.get(i12);
            int i15 = mVar.f8566y;
            if ((i15 & 2) == 2) {
                i13++;
            } else if ((i15 & 1) == 1) {
                i14++;
            } else {
                z11 = true;
            }
            if (kVar.M && mVar.C) {
                i10 = 0;
            }
            i12++;
        }
        if (kVar.H && (z11 || i14 + i13 > i10)) {
            i10--;
        }
        int i16 = i10 - i13;
        SparseBooleanArray sparseBooleanArray = kVar.N;
        sparseBooleanArray.clear();
        int i17 = 0;
        int i18 = 0;
        while (i17 < size) {
            n.m mVar2 = (n.m) arrayListL.get(i17);
            int i19 = mVar2.f8566y;
            boolean z12 = (i19 & 2) == i ? z10 : false;
            int i20 = mVar2.f8545b;
            if (z12) {
                View viewA = kVar.a(mVar2, null, viewGroup);
                viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewA.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i18 == 0) {
                    i18 = measuredWidth;
                }
                if (i20 != 0) {
                    sparseBooleanArray.put(i20, z10);
                }
                mVar2.g(z10);
            } else if ((i19 & 1) == z10) {
                boolean z13 = sparseBooleanArray.get(i20);
                boolean z14 = ((i16 > 0 || z13) && i11 > 0) ? z10 : false;
                if (z14) {
                    View viewA2 = kVar.a(mVar2, null, viewGroup);
                    viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i18 == 0) {
                        i18 = measuredWidth2;
                    }
                    z14 &= i11 + i18 > 0;
                }
                if (z14 && i20 != 0) {
                    sparseBooleanArray.put(i20, true);
                } else if (z13) {
                    sparseBooleanArray.put(i20, false);
                    for (int i21 = 0; i21 < i17; i21++) {
                        n.m mVar3 = (n.m) arrayListL.get(i21);
                        if (mVar3.f8545b == i20) {
                            if ((mVar3.f8565x & 32) == 32) {
                                i16++;
                            }
                            mVar3.g(false);
                        }
                    }
                }
                if (z14) {
                    i16--;
                }
                mVar2.g(z14);
            } else {
                mVar2.g(false);
                i17++;
                i = 2;
                kVar = this;
                z10 = true;
            }
            i17++;
            i = 2;
            kVar = this;
            z10 = true;
        }
        return z10;
    }

    @Override // n.w
    public final Parcelable k() {
        j jVar = new j();
        jVar.f9246v = this.T;
        return jVar;
    }

    @Override // n.w
    public final void l(n.v vVar) {
        throw null;
    }

    @Override // n.w
    public final boolean m(n.m mVar) {
        return false;
    }

    public final boolean n() {
        n.k kVar;
        if (!this.H || f() || (kVar = this.f9251x) == null || this.C == null || this.Q != null) {
            return false;
        }
        kVar.i();
        if (kVar.f8526j.isEmpty()) {
            return false;
        }
        h hVar = new h(this, new f(this, this.f9250w, this.f9251x, this.E));
        this.Q = hVar;
        ((View) this.C).post(hVar);
        return true;
    }
}
