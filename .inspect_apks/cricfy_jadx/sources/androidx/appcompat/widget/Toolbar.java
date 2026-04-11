package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.j0;
import androidx.fragment.app.m;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.material.datepicker.l;
import g.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m.h;
import m2.e;
import o.a1;
import o.i3;
import o.j1;
import o.j3;
import o.k;
import o.k3;
import o.l3;
import o.m3;
import o.n3;
import o.p3;
import o.q2;
import o.v;
import o.w;
import o.x3;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public final Drawable A;
    public final CharSequence B;
    public v C;
    public View D;
    public Context E;
    public int F;
    public int G;
    public int H;
    public final int I;
    public final int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public q2 O;
    public int P;
    public int Q;
    public final int R;
    public CharSequence S;
    public CharSequence T;
    public ColorStateList U;
    public ColorStateList V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f602a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ArrayList f603b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final ArrayList f604c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int[] f605d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final l7.a f606e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public ArrayList f607f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public m3 f608g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final l4.a f609h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public p3 f610i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public k f611j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public k3 f612k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public o4 f613l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public p6.d f614m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f615n0;
    public OnBackInvokedCallback o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public OnBackInvokedDispatcher f616p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f617q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final m f618r0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ActionMenuView f619v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a1 f620w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a1 f621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public v f622y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public w f623z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.toolbarStyle);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new h(getContext());
    }

    public static l3 h() {
        l3 l3Var = new l3(-2, -2);
        l3Var.f9268b = 0;
        l3Var.f9267a = 8388627;
        return l3Var;
    }

    public static l3 i(ViewGroup.LayoutParams layoutParams) {
        boolean z10 = layoutParams instanceof l3;
        if (z10) {
            l3 l3Var = (l3) layoutParams;
            l3 l3Var2 = new l3(l3Var);
            l3Var2.f9268b = 0;
            l3Var2.f9268b = l3Var.f9268b;
            return l3Var2;
        }
        if (z10) {
            l3 l3Var3 = new l3((l3) layoutParams);
            l3Var3.f9268b = 0;
            return l3Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            l3 l3Var4 = new l3(layoutParams);
            l3Var4.f9268b = 0;
            return l3Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        l3 l3Var5 = new l3(marginLayoutParams);
        l3Var5.f9268b = 0;
        ((ViewGroup.MarginLayoutParams) l3Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) l3Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) l3Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) l3Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return l3Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i, ArrayList arrayList) {
        boolean z10 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z10) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                l3 l3Var = (l3) childAt.getLayoutParams();
                if (l3Var.f9268b == 0 && t(childAt)) {
                    int i11 = l3Var.f9267a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i11, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            l3 l3Var2 = (l3) childAt2.getLayoutParams();
            if (l3Var2.f9268b == 0 && t(childAt2)) {
                int i13 = l3Var2.f9267a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i13, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        l3 l3VarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (l3) layoutParams;
        l3VarH.f9268b = 1;
        if (!z10 || this.D == null) {
            addView(view, l3VarH);
        } else {
            view.setLayoutParams(l3VarH);
            this.f604c0.add(view);
        }
    }

    public final void c() {
        if (this.C == null) {
            v vVar = new v(getContext(), null, g.a.toolbarNavigationButtonStyle);
            this.C = vVar;
            vVar.setImageDrawable(this.A);
            this.C.setContentDescription(this.B);
            l3 l3VarH = h();
            l3VarH.f9267a = (this.I & 112) | 8388611;
            l3VarH.f9268b = 2;
            this.C.setLayoutParams(l3VarH);
            this.C.setOnClickListener(new l(6, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof l3);
    }

    public final void d() {
        if (this.O == null) {
            q2 q2Var = new q2();
            q2Var.f9328a = 0;
            q2Var.f9329b = 0;
            q2Var.f9330c = Integer.MIN_VALUE;
            q2Var.f9331d = Integer.MIN_VALUE;
            q2Var.f9332e = 0;
            q2Var.f = 0;
            q2Var.f9333g = false;
            q2Var.f9334h = false;
            this.O = q2Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f619v;
        if (actionMenuView.K == null) {
            n.k kVar = (n.k) actionMenuView.getMenu();
            if (this.f612k0 == null) {
                this.f612k0 = new k3(this);
            }
            this.f619v.setExpandedActionViewsExclusive(true);
            kVar.b(this.f612k0, this.E);
            v();
        }
    }

    public final void f() {
        if (this.f619v == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f619v = actionMenuView;
            actionMenuView.setPopupTheme(this.F);
            this.f619v.setOnMenuItemClickListener(this.f609h0);
            ActionMenuView actionMenuView2 = this.f619v;
            o4 o4Var = this.f613l0;
            e eVar = new e(this);
            actionMenuView2.P = o4Var;
            actionMenuView2.Q = eVar;
            l3 l3VarH = h();
            l3VarH.f9267a = (this.I & 112) | 8388613;
            this.f619v.setLayoutParams(l3VarH);
            b(this.f619v, false);
        }
    }

    public final void g() {
        if (this.f622y == null) {
            this.f622y = new v(getContext(), null, g.a.toolbarNavigationButtonStyle);
            l3 l3VarH = h();
            l3VarH.f9267a = (this.I & 112) | 8388611;
            this.f622y.setLayoutParams(l3VarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        v vVar = this.C;
        if (vVar != null) {
            return vVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        v vVar = this.C;
        if (vVar != null) {
            return vVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        q2 q2Var = this.O;
        if (q2Var != null) {
            return q2Var.f9333g ? q2Var.f9328a : q2Var.f9329b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.Q;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        q2 q2Var = this.O;
        if (q2Var != null) {
            return q2Var.f9328a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        q2 q2Var = this.O;
        if (q2Var != null) {
            return q2Var.f9329b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        q2 q2Var = this.O;
        if (q2Var != null) {
            return q2Var.f9333g ? q2Var.f9329b : q2Var.f9328a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.P;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        n.k kVar;
        ActionMenuView actionMenuView = this.f619v;
        return (actionMenuView == null || (kVar = actionMenuView.K) == null || !kVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.Q, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.P, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        w wVar = this.f623z;
        if (wVar != null) {
            return wVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        w wVar = this.f623z;
        if (wVar != null) {
            return wVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f619v.getMenu();
    }

    public View getNavButtonView() {
        return this.f622y;
    }

    public CharSequence getNavigationContentDescription() {
        v vVar = this.f622y;
        if (vVar != null) {
            return vVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        v vVar = this.f622y;
        if (vVar != null) {
            return vVar.getDrawable();
        }
        return null;
    }

    public k getOuterActionMenuPresenter() {
        return this.f611j0;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f619v.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.E;
    }

    public int getPopupTheme() {
        return this.F;
    }

    public CharSequence getSubtitle() {
        return this.T;
    }

    public final TextView getSubtitleTextView() {
        return this.f621x;
    }

    public CharSequence getTitle() {
        return this.S;
    }

    public int getTitleMarginBottom() {
        return this.N;
    }

    public int getTitleMarginEnd() {
        return this.L;
    }

    public int getTitleMarginStart() {
        return this.K;
    }

    public int getTitleMarginTop() {
        return this.M;
    }

    public final TextView getTitleTextView() {
        return this.f620w;
    }

    public j1 getWrapper() {
        if (this.f610i0 == null) {
            this.f610i0 = new p3(this, true);
        }
        return this.f610i0;
    }

    public final int j(View view, int i) {
        l3 l3Var = (l3) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i11 = l3Var.f9267a & 112;
        if (i11 != 16 && i11 != 48 && i11 != 80) {
            i11 = this.R & 112;
        }
        if (i11 == 48) {
            return getPaddingTop() - i10;
        }
        if (i11 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) l3Var).bottomMargin) - i10;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) l3Var).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) l3Var).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    public final void m() {
        ArrayList arrayList = this.f607f0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f606e0.f7867x).iterator();
        while (it.hasNext()) {
            ((j0) it.next()).f1007a.k();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f607f0 = currentMenuItems2;
    }

    public final boolean n(View view) {
        return view.getParent() == this || this.f604c0.contains(view);
    }

    public final boolean o() {
        k kVar;
        ActionMenuView actionMenuView = this.f619v;
        return (actionMenuView == null || (kVar = actionMenuView.O) == null || !kVar.f()) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f618r0);
        v();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f602a0 = false;
        }
        if (!this.f602a0) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f602a0 = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f602a0 = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[LOOP:0: B:102:0x028d->B:103:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a7 A[LOOP:1: B:105:0x02a5->B:106:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c7 A[LOOP:2: B:108:0x02c5->B:109:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031a A[LOOP:3: B:117:0x0318->B:118:0x031a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        char c9;
        Object[] objArr;
        int iK;
        int iMax;
        int iCombineMeasuredStates;
        int iK2;
        int iL;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z10 = x3.f9407a;
        int i11 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c9 = 0;
        } else {
            c9 = 1;
            objArr = false;
        }
        if (t(this.f622y)) {
            s(this.f622y, i, 0, i10, this.J);
            iK = k(this.f622y) + this.f622y.getMeasuredWidth();
            iMax = Math.max(0, l(this.f622y) + this.f622y.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f622y.getMeasuredState());
        } else {
            iK = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (t(this.C)) {
            s(this.C, i, 0, i10, this.J);
            iK = k(this.C) + this.C.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.C) + this.C.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.C.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iK);
        int iMax4 = Math.max(0, currentContentInsetStart - iK);
        Object[] objArr2 = objArr;
        int[] iArr = this.f605d0;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (t(this.f619v)) {
            s(this.f619v, i, iMax3, i10, this.J);
            iK2 = k(this.f619v) + this.f619v.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f619v) + this.f619v.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f619v.getMeasuredState());
        } else {
            iK2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iK2);
        iArr[c9] = Math.max(0, currentContentInsetEnd - iK2);
        if (t(this.D)) {
            iMax5 += r(this.D, i, iMax5, i10, 0, iArr);
            iMax = Math.max(iMax, l(this.D) + this.D.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.D.getMeasuredState());
        }
        if (t(this.f623z)) {
            iMax5 += r(this.f623z, i, iMax5, i10, 0, iArr);
            iMax = Math.max(iMax, l(this.f623z) + this.f623z.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f623z.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((l3) childAt.getLayoutParams()).f9268b == 0 && t(childAt)) {
                iMax5 += r(childAt, i, iMax5, i10, 0, iArr);
                int iMax6 = Math.max(iMax, l(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i13 = iMax5;
        int i14 = this.M + this.N;
        int i15 = this.K + this.L;
        if (t(this.f620w)) {
            r(this.f620w, i, i13 + i15, i10, i14, iArr);
            int iK3 = k(this.f620w) + this.f620w.getMeasuredWidth();
            iL = l(this.f620w) + this.f620w.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f620w.getMeasuredState());
            iMax2 = iK3;
        } else {
            iL = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (t(this.f621x)) {
            iMax2 = Math.max(iMax2, r(this.f621x, i, i13 + i15, i10, i14 + iL, iArr));
            iL += l(this.f621x) + this.f621x.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f621x.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iL);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i13 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, iCombineMeasuredStates2 << 16);
        if (!this.f615n0) {
            i11 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (t(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i11 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i11);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof n3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n3 n3Var = (n3) parcelable;
        super.onRestoreInstanceState(n3Var.f112v);
        ActionMenuView actionMenuView = this.f619v;
        n.k kVar = actionMenuView != null ? actionMenuView.K : null;
        int i = n3Var.f9279x;
        if (i != 0 && this.f612k0 != null && kVar != null && (menuItemFindItem = kVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (n3Var.f9280y) {
            m mVar = this.f618r0;
            removeCallbacks(mVar);
            post(mVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        q2 q2Var = this.O;
        boolean z10 = i == 1;
        if (z10 == q2Var.f9333g) {
            return;
        }
        q2Var.f9333g = z10;
        if (!q2Var.f9334h) {
            q2Var.f9328a = q2Var.f9332e;
            q2Var.f9329b = q2Var.f;
            return;
        }
        if (z10) {
            int i10 = q2Var.f9331d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = q2Var.f9332e;
            }
            q2Var.f9328a = i10;
            int i11 = q2Var.f9330c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = q2Var.f;
            }
            q2Var.f9329b = i11;
            return;
        }
        int i12 = q2Var.f9330c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = q2Var.f9332e;
        }
        q2Var.f9328a = i12;
        int i13 = q2Var.f9331d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = q2Var.f;
        }
        q2Var.f9329b = i13;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        n.m mVar;
        n3 n3Var = new n3(super.onSaveInstanceState());
        k3 k3Var = this.f612k0;
        if (k3Var != null && (mVar = k3Var.f9257w) != null) {
            n3Var.f9279x = mVar.f8544a;
        }
        n3Var.f9280y = o();
        return n3Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.W = false;
        }
        if (!this.W) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.W = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.W = false;
        return true;
    }

    public final int p(View view, int i, int i10, int[] iArr) {
        l3 l3Var = (l3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) l3Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i11) + i;
        iArr[0] = Math.max(0, -i11);
        int iJ = j(view, i10);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) l3Var).rightMargin + iMax;
    }

    public final int q(View view, int i, int i10, int[] iArr) {
        l3 l3Var = (l3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) l3Var).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i11);
        iArr[1] = Math.max(0, -i11);
        int iJ = j(view, i10);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) l3Var).leftMargin);
    }

    public final int r(View view, int i, int i10, int i11, int i12, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i13 = marginLayoutParams.leftMargin - iArr[0];
        int i14 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        iArr[1] = Math.max(0, -i14);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i12, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void s(View view, int i, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i12 >= 0) {
            if (mode != 0) {
                i12 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i12);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.f617q0 != z10) {
            this.f617q0 = z10;
            v();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(j4.i(getContext(), i));
    }

    public void setCollapsible(boolean z10) {
        this.f615n0 = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.Q) {
            this.Q = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.P) {
            this.P = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(j4.i(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(j4.i(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f622y.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(m3 m3Var) {
        this.f608g0 = m3Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f619v.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.F != i) {
            this.F = i;
            if (i == 0) {
                this.E = getContext();
            } else {
                this.E = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.N = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.L = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.K = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.M = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public final boolean t(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean u() {
        k kVar;
        ActionMenuView actionMenuView = this.f619v;
        return (actionMenuView == null || (kVar = actionMenuView.O) == null || !kVar.n()) ? false : true;
    }

    public final void v() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = j3.a(this);
            k3 k3Var = this.f612k0;
            boolean z10 = (k3Var == null || k3Var.f9257w == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.f617q0) ? false : true;
            if (z10 && this.f616p0 == null) {
                if (this.o0 == null) {
                    this.o0 = j3.b(new i3(this, 0));
                }
                j3.c(onBackInvokedDispatcherA, this.o0);
                this.f616p0 = onBackInvokedDispatcherA;
                return;
            }
            if (z10 || (onBackInvokedDispatcher = this.f616p0) == null) {
                return;
            }
            j3.d(onBackInvokedDispatcher, this.o0);
            this.f616p0 = null;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.R = 8388627;
        this.f603b0 = new ArrayList();
        this.f604c0 = new ArrayList();
        this.f605d0 = new int[2];
        this.f606e0 = new l7.a(new i3(this, 1));
        this.f607f0 = new ArrayList();
        this.f609h0 = new l4.a((Object) this);
        this.f618r0 = new m(23, this);
        l7.a aVarF = l7.a.F(getContext(), attributeSet, j.Toolbar, i);
        m0.m(this, context, j.Toolbar, attributeSet, (TypedArray) aVarF.f7867x, i);
        int i10 = j.Toolbar_titleTextAppearance;
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        this.G = typedArray.getResourceId(i10, 0);
        this.H = typedArray.getResourceId(j.Toolbar_subtitleTextAppearance, 0);
        this.R = typedArray.getInteger(j.Toolbar_android_gravity, 8388627);
        this.I = typedArray.getInteger(j.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(j.Toolbar_titleMargin, 0);
        dimensionPixelOffset = typedArray.hasValue(j.Toolbar_titleMargins) ? typedArray.getDimensionPixelOffset(j.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.N = dimensionPixelOffset;
        this.M = dimensionPixelOffset;
        this.L = dimensionPixelOffset;
        this.K = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.K = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.L = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.M = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.N = dimensionPixelOffset5;
        }
        this.J = typedArray.getDimensionPixelSize(j.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(j.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(j.Toolbar_contentInsetRight, 0);
        d();
        q2 q2Var = this.O;
        q2Var.f9334h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            q2Var.f9332e = dimensionPixelSize;
            q2Var.f9328a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            q2Var.f = dimensionPixelSize2;
            q2Var.f9329b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            q2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.P = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.Q = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.A = aVarF.u(j.Toolbar_collapseIcon);
        this.B = typedArray.getText(j.Toolbar_collapseContentDescription);
        CharSequence text = typedArray.getText(j.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.E = getContext();
        setPopupTheme(typedArray.getResourceId(j.Toolbar_popupTheme, 0));
        Drawable drawableU = aVarF.u(j.Toolbar_navigationIcon);
        if (drawableU != null) {
            setNavigationIcon(drawableU);
        }
        CharSequence text3 = typedArray.getText(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableU2 = aVarF.u(j.Toolbar_logo);
        if (drawableU2 != null) {
            setLogo(drawableU2);
        }
        CharSequence text4 = typedArray.getText(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(j.Toolbar_titleTextColor)) {
            setTitleTextColor(aVarF.r(j.Toolbar_titleTextColor));
        }
        if (typedArray.hasValue(j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(aVarF.r(j.Toolbar_subtitleTextColor));
        }
        if (typedArray.hasValue(j.Toolbar_menu)) {
            getMenuInflater().inflate(typedArray.getResourceId(j.Toolbar_menu, 0), getMenu());
        }
        aVarF.G();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        l3 l3Var = new l3(context, attributeSet);
        l3Var.f9267a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
        l3Var.f9267a = typedArrayObtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
        typedArrayObtainStyledAttributes.recycle();
        l3Var.f9268b = 0;
        return l3Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        v vVar = this.C;
        if (vVar != null) {
            vVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.C.setImageDrawable(drawable);
        } else {
            v vVar = this.C;
            if (vVar != null) {
                vVar.setImageDrawable(this.A);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f623z == null) {
                this.f623z = new w(getContext(), null, 0);
            }
            if (!n(this.f623z)) {
                b(this.f623z, true);
            }
        } else {
            w wVar = this.f623z;
            if (wVar != null && n(wVar)) {
                removeView(this.f623z);
                this.f604c0.remove(this.f623z);
            }
        }
        w wVar2 = this.f623z;
        if (wVar2 != null) {
            wVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f623z == null) {
            this.f623z = new w(getContext(), null, 0);
        }
        w wVar = this.f623z;
        if (wVar != null) {
            wVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        v vVar = this.f622y;
        if (vVar != null) {
            vVar.setContentDescription(charSequence);
            w4.v.t(this.f622y, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f622y)) {
                b(this.f622y, true);
            }
        } else {
            v vVar = this.f622y;
            if (vVar != null && n(vVar)) {
                removeView(this.f622y);
                this.f604c0.remove(this.f622y);
            }
        }
        v vVar2 = this.f622y;
        if (vVar2 != null) {
            vVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            a1 a1Var = this.f621x;
            if (a1Var != null && n(a1Var)) {
                removeView(this.f621x);
                this.f604c0.remove(this.f621x);
            }
        } else {
            if (this.f621x == null) {
                Context context = getContext();
                a1 a1Var2 = new a1(context, null);
                this.f621x = a1Var2;
                a1Var2.setSingleLine();
                this.f621x.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.H;
                if (i != 0) {
                    this.f621x.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.V;
                if (colorStateList != null) {
                    this.f621x.setTextColor(colorStateList);
                }
            }
            if (!n(this.f621x)) {
                b(this.f621x, true);
            }
        }
        a1 a1Var3 = this.f621x;
        if (a1Var3 != null) {
            a1Var3.setText(charSequence);
        }
        this.T = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.V = colorStateList;
        a1 a1Var = this.f621x;
        if (a1Var != null) {
            a1Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            a1 a1Var = this.f620w;
            if (a1Var != null && n(a1Var)) {
                removeView(this.f620w);
                this.f604c0.remove(this.f620w);
            }
        } else {
            if (this.f620w == null) {
                Context context = getContext();
                a1 a1Var2 = new a1(context, null);
                this.f620w = a1Var2;
                a1Var2.setSingleLine();
                this.f620w.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.G;
                if (i != 0) {
                    this.f620w.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.U;
                if (colorStateList != null) {
                    this.f620w.setTextColor(colorStateList);
                }
            }
            if (!n(this.f620w)) {
                b(this.f620w, true);
            }
        }
        a1 a1Var3 = this.f620w;
        if (a1Var3 != null) {
            a1Var3.setText(charSequence);
        }
        this.S = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.U = colorStateList;
        a1 a1Var = this.f620w;
        if (a1Var != null) {
            a1Var.setTextColor(colorStateList);
        }
    }
}
