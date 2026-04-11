package n;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements m.w {
    public final int A;
    public m.y B;
    public int C;
    public i D;
    public Drawable E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public final SparseBooleanArray M;
    public f N;
    public f O;
    public h P;
    public g Q;
    public final wb.c R;
    public int S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f8421u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Context f8422v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m.k f8423w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LayoutInflater f8424x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m.v f8425y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f8426z;

    public k(Context context) {
        int i = g.g.abc_action_menu_layout;
        int i10 = g.g.abc_action_menu_item_layout;
        this.f8421u = context;
        this.f8424x = LayoutInflater.from(context);
        this.f8426z = i;
        this.A = i10;
        this.M = new SparseBooleanArray();
        this.R = new wb.c(26, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(m.m mVar, View view, ViewGroup viewGroup) {
        View actionView = mVar.getActionView();
        if (actionView == null || mVar.e()) {
            m.x xVar = view instanceof m.x ? (m.x) view : (m.x) this.f8424x.inflate(this.A, viewGroup, false);
            xVar.a(mVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) xVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.B);
            if (this.Q == null) {
                this.Q = new g(this);
            }
            actionMenuItemView.setPopupCallback(this.Q);
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

    @Override // m.w
    public final void b(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof j) && (i = ((j) parcelable).f8413u) > 0 && (menuItemFindItem = this.f8423w.findItem(i)) != null) {
            k((m.c0) menuItemFindItem.getSubMenu());
        }
    }

    @Override // m.w
    public final void c(m.k kVar, boolean z2) {
        d();
        f fVar = this.O;
        if (fVar != null && fVar.b()) {
            fVar.i.dismiss();
        }
        m.v vVar = this.f8425y;
        if (vVar != null) {
            vVar.c(kVar, z2);
        }
    }

    public final boolean d() {
        Object obj;
        h hVar = this.P;
        if (hVar != null && (obj = this.B) != null) {
            ((View) obj).removeCallbacks(hVar);
            this.P = null;
            return true;
        }
        f fVar = this.N;
        if (fVar == null) {
            return false;
        }
        if (fVar.b()) {
            fVar.i.dismiss();
        }
        return true;
    }

    public final boolean e() {
        f fVar = this.N;
        return fVar != null && fVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m.w
    public final void f(boolean z2) {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.B;
        ArrayList arrayList = null;
        boolean z10 = false;
        if (viewGroup != null) {
            m.k kVar = this.f8423w;
            if (kVar != null) {
                kVar.i();
                ArrayList arrayListL = this.f8423w.l();
                int size = arrayListL.size();
                i = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    m.m mVar = (m.m) arrayListL.get(i10);
                    if ((mVar.f8251x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        m.m itemData = childAt instanceof m.x ? ((m.x) childAt).getItemData() : null;
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
                            ((ViewGroup) this.B).addView(viewA, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.D) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.B).requestLayout();
        m.k kVar2 = this.f8423w;
        if (kVar2 != null) {
            kVar2.i();
            ArrayList arrayList2 = kVar2.i;
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                m.n nVar = ((m.m) arrayList2.get(i11)).A;
            }
        }
        m.k kVar3 = this.f8423w;
        if (kVar3 != null) {
            kVar3.i();
            arrayList = kVar3.f8212j;
        }
        if (this.G && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z10 = !((m.m) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z10 = true;
            }
        }
        if (z10) {
            if (this.D == null) {
                this.D = new i(this, this.f8421u);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.D.getParent();
            if (viewGroup3 != this.B) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.D);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.B;
                i iVar = this.D;
                actionMenuView.getClass();
                m mVarJ = ActionMenuView.j();
                mVarJ.f8435a = true;
                actionMenuView.addView(iVar, mVarJ);
            }
        } else {
            i iVar2 = this.D;
            if (iVar2 != null) {
                Object parent = iVar2.getParent();
                Object obj = this.B;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.D);
                }
            }
        }
        ((ActionMenuView) this.B).setOverflowReserved(this.G);
    }

    @Override // m.w
    public final boolean g(m.m mVar) {
        return false;
    }

    @Override // m.w
    public final int getId() {
        return this.C;
    }

    @Override // m.w
    public final void h(Context context, m.k kVar) {
        this.f8422v = context;
        LayoutInflater.from(context);
        this.f8423w = kVar;
        Resources resources = context.getResources();
        if (!this.H) {
            this.G = true;
        }
        int i = 2;
        this.I = context.getResources().getDisplayMetrics().widthPixels / 2;
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
        this.K = i;
        int measuredWidth = this.I;
        if (this.G) {
            if (this.D == null) {
                i iVar = new i(this, this.f8421u);
                this.D = iVar;
                if (this.F) {
                    iVar.setImageDrawable(this.E);
                    this.E = null;
                    this.F = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.D.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.D.getMeasuredWidth();
        } else {
            this.D = null;
        }
        this.J = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    @Override // m.w
    public final boolean i() {
        int size;
        ArrayList arrayListL;
        int i;
        boolean z2;
        k kVar = this;
        m.k kVar2 = kVar.f8423w;
        if (kVar2 != null) {
            arrayListL = kVar2.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i10 = kVar.K;
        int i11 = kVar.J;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) kVar.B;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i = 2;
            z2 = true;
            if (i12 >= size) {
                break;
            }
            m.m mVar = (m.m) arrayListL.get(i12);
            int i15 = mVar.f8252y;
            if ((i15 & 2) == 2) {
                i13++;
            } else if ((i15 & 1) == 1) {
                i14++;
            } else {
                z10 = true;
            }
            if (kVar.L && mVar.C) {
                i10 = 0;
            }
            i12++;
        }
        if (kVar.G && (z10 || i14 + i13 > i10)) {
            i10--;
        }
        int i16 = i10 - i13;
        SparseBooleanArray sparseBooleanArray = kVar.M;
        sparseBooleanArray.clear();
        int i17 = 0;
        int i18 = 0;
        while (i17 < size) {
            m.m mVar2 = (m.m) arrayListL.get(i17);
            int i19 = mVar2.f8252y;
            boolean z11 = (i19 & 2) == i ? z2 : false;
            int i20 = mVar2.f8231b;
            if (z11) {
                View viewA = kVar.a(mVar2, null, viewGroup);
                viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewA.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i18 == 0) {
                    i18 = measuredWidth;
                }
                if (i20 != 0) {
                    sparseBooleanArray.put(i20, z2);
                }
                mVar2.g(z2);
            } else if ((i19 & 1) == z2) {
                boolean z12 = sparseBooleanArray.get(i20);
                boolean z13 = ((i16 > 0 || z12) && i11 > 0) ? z2 : false;
                if (z13) {
                    View viewA2 = kVar.a(mVar2, null, viewGroup);
                    viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i18 == 0) {
                        i18 = measuredWidth2;
                    }
                    z13 &= i11 + i18 > 0;
                }
                if (z13 && i20 != 0) {
                    sparseBooleanArray.put(i20, true);
                } else if (z12) {
                    sparseBooleanArray.put(i20, false);
                    for (int i21 = 0; i21 < i17; i21++) {
                        m.m mVar3 = (m.m) arrayListL.get(i21);
                        if (mVar3.f8231b == i20) {
                            if ((mVar3.f8251x & 32) == 32) {
                                i16++;
                            }
                            mVar3.g(false);
                        }
                    }
                }
                if (z13) {
                    i16--;
                }
                mVar2.g(z13);
            } else {
                mVar2.g(false);
                i17++;
                i = 2;
                kVar = this;
                z2 = true;
            }
            i17++;
            i = 2;
            kVar = this;
            z2 = true;
        }
        return z2;
    }

    @Override // m.w
    public final Parcelable j() {
        j jVar = new j();
        jVar.f8413u = this.S;
        return jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m.w
    public final boolean k(m.c0 c0Var) {
        boolean z2;
        if (c0Var.hasVisibleItems()) {
            m.c0 c0Var2 = c0Var;
            while (true) {
                m.k kVar = c0Var2.f8181z;
                if (kVar == this.f8423w) {
                    break;
                }
                c0Var2 = (m.c0) kVar;
            }
            m.m mVar = c0Var2.A;
            ViewGroup viewGroup = (ViewGroup) this.B;
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
                    if ((childAt instanceof m.x) && ((m.x) childAt).getItemData() == mVar) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                this.S = c0Var.A.f8230a;
                int size = c0Var.f.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        z2 = false;
                        break;
                    }
                    MenuItem item = c0Var.getItem(i10);
                    if (item.isVisible() && item.getIcon() != null) {
                        z2 = true;
                        break;
                    }
                    i10++;
                }
                f fVar = new f(this, this.f8422v, c0Var, view);
                this.O = fVar;
                fVar.f8271g = z2;
                m.s sVar = fVar.i;
                if (sVar != null) {
                    sVar.q(z2);
                }
                f fVar2 = this.O;
                if (!fVar2.b()) {
                    if (fVar2.f8270e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    fVar2.d(0, 0, false, false);
                }
                m.v vVar = this.f8425y;
                if (vVar != null) {
                    vVar.x(c0Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // m.w
    public final void l(m.v vVar) {
        throw null;
    }

    @Override // m.w
    public final boolean m(m.m mVar) {
        return false;
    }

    public final boolean n() {
        m.k kVar;
        if (!this.G || e() || (kVar = this.f8423w) == null || this.B == null || this.P != null) {
            return false;
        }
        kVar.i();
        if (kVar.f8212j.isEmpty()) {
            return false;
        }
        h hVar = new h(this, new f(this, this.f8422v, this.f8423w, this.D));
        this.P = hVar;
        ((View) this.B).post(hVar);
        return true;
    }
}
