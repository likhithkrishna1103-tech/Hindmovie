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
import androidx.fragment.app.e;
import androidx.fragment.app.g0;
import com.google.android.material.datepicker.l;
import e6.f0;
import g.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l.h;
import m.m;
import n.d1;
import n.f3;
import n.g3;
import n.h3;
import n.i3;
import n.j3;
import n.k;
import n.k3;
import n.m1;
import n.m3;
import n.p2;
import n.u3;
import n.x;
import n.y;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public final CharSequence A;
    public x B;
    public View C;
    public Context D;
    public int E;
    public int F;
    public int G;
    public final int H;
    public final int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public p2 N;
    public int O;
    public int P;
    public final int Q;
    public CharSequence R;
    public CharSequence S;
    public ColorStateList T;
    public ColorStateList U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final ArrayList f926a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ArrayList f927b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final int[] f928c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final kc.b f929d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public ArrayList f930e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public j3 f931f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final wb.c f932g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public m3 f933h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public k f934i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public h3 f935j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public f0 f936k0;
    public u5.d l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f937m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public OnBackInvokedCallback f938n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public OnBackInvokedDispatcher f939o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f940p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final e f941q0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ActionMenuView f942u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d1 f943v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d1 f944w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public x f945x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public y f946y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Drawable f947z;

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

    public static i3 h() {
        i3 i3Var = new i3(-2, -2);
        i3Var.f8412b = 0;
        i3Var.f8411a = 8388627;
        return i3Var;
    }

    public static i3 i(ViewGroup.LayoutParams layoutParams) {
        boolean z2 = layoutParams instanceof i3;
        if (z2) {
            i3 i3Var = (i3) layoutParams;
            i3 i3Var2 = new i3(i3Var);
            i3Var2.f8412b = 0;
            i3Var2.f8412b = i3Var.f8412b;
            return i3Var2;
        }
        if (z2) {
            i3 i3Var3 = new i3((i3) layoutParams);
            i3Var3.f8412b = 0;
            return i3Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            i3 i3Var4 = new i3(layoutParams);
            i3Var4.f8412b = 0;
            return i3Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        i3 i3Var5 = new i3(marginLayoutParams);
        i3Var5.f8412b = 0;
        ((ViewGroup.MarginLayoutParams) i3Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) i3Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) i3Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) i3Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return i3Var5;
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
        boolean z2 = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z2) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                i3 i3Var = (i3) childAt.getLayoutParams();
                if (i3Var.f8412b == 0 && u(childAt)) {
                    int i11 = i3Var.f8411a;
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
            i3 i3Var2 = (i3) childAt2.getLayoutParams();
            if (i3Var2.f8412b == 0 && u(childAt2)) {
                int i13 = i3Var2.f8411a;
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

    public final void b(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        i3 i3VarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (i3) layoutParams;
        i3VarH.f8412b = 1;
        if (!z2 || this.C == null) {
            addView(view, i3VarH);
        } else {
            view.setLayoutParams(i3VarH);
            this.f927b0.add(view);
        }
    }

    public final void c() {
        if (this.B == null) {
            x xVar = new x(getContext(), null, g.a.toolbarNavigationButtonStyle);
            this.B = xVar;
            xVar.setImageDrawable(this.f947z);
            this.B.setContentDescription(this.A);
            i3 i3VarH = h();
            i3VarH.f8411a = (this.H & 112) | 8388611;
            i3VarH.f8412b = 2;
            this.B.setLayoutParams(i3VarH);
            this.B.setOnClickListener(new l(7, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof i3);
    }

    public final void d() {
        if (this.N == null) {
            p2 p2Var = new p2();
            p2Var.f8484a = 0;
            p2Var.f8485b = 0;
            p2Var.f8486c = Integer.MIN_VALUE;
            p2Var.f8487d = Integer.MIN_VALUE;
            p2Var.f8488e = 0;
            p2Var.f = 0;
            p2Var.f8489g = false;
            p2Var.f8490h = false;
            this.N = p2Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f942u;
        if (actionMenuView.J == null) {
            m.k kVar = (m.k) actionMenuView.getMenu();
            if (this.f935j0 == null) {
                this.f935j0 = new h3(this);
            }
            this.f942u.setExpandedActionViewsExclusive(true);
            kVar.b(this.f935j0, this.D);
            w();
        }
    }

    public final void f() {
        if (this.f942u == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f942u = actionMenuView;
            actionMenuView.setPopupTheme(this.E);
            this.f942u.setOnMenuItemClickListener(this.f932g0);
            ActionMenuView actionMenuView2 = this.f942u;
            f0 f0Var = this.f936k0;
            rc.b bVar = new rc.b(25, this);
            actionMenuView2.O = f0Var;
            actionMenuView2.P = bVar;
            i3 i3VarH = h();
            i3VarH.f8411a = (this.H & 112) | 8388613;
            this.f942u.setLayoutParams(i3VarH);
            b(this.f942u, false);
        }
    }

    public final void g() {
        if (this.f945x == null) {
            this.f945x = new x(getContext(), null, g.a.toolbarNavigationButtonStyle);
            i3 i3VarH = h();
            i3VarH.f8411a = (this.H & 112) | 8388611;
            this.f945x.setLayoutParams(i3VarH);
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
        x xVar = this.B;
        if (xVar != null) {
            return xVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        x xVar = this.B;
        if (xVar != null) {
            return xVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        p2 p2Var = this.N;
        if (p2Var != null) {
            return p2Var.f8489g ? p2Var.f8484a : p2Var.f8485b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.P;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        p2 p2Var = this.N;
        if (p2Var != null) {
            return p2Var.f8484a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        p2 p2Var = this.N;
        if (p2Var != null) {
            return p2Var.f8485b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        p2 p2Var = this.N;
        if (p2Var != null) {
            return p2Var.f8489g ? p2Var.f8485b : p2Var.f8484a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.O;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        m.k kVar;
        ActionMenuView actionMenuView = this.f942u;
        return (actionMenuView == null || (kVar = actionMenuView.J) == null || !kVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.P, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.O, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        y yVar = this.f946y;
        if (yVar != null) {
            return yVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        y yVar = this.f946y;
        if (yVar != null) {
            return yVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f942u.getMenu();
    }

    public View getNavButtonView() {
        return this.f945x;
    }

    public CharSequence getNavigationContentDescription() {
        x xVar = this.f945x;
        if (xVar != null) {
            return xVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        x xVar = this.f945x;
        if (xVar != null) {
            return xVar.getDrawable();
        }
        return null;
    }

    public k getOuterActionMenuPresenter() {
        return this.f934i0;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f942u.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.D;
    }

    public int getPopupTheme() {
        return this.E;
    }

    public CharSequence getSubtitle() {
        return this.S;
    }

    public final TextView getSubtitleTextView() {
        return this.f944w;
    }

    public CharSequence getTitle() {
        return this.R;
    }

    public int getTitleMarginBottom() {
        return this.M;
    }

    public int getTitleMarginEnd() {
        return this.K;
    }

    public int getTitleMarginStart() {
        return this.J;
    }

    public int getTitleMarginTop() {
        return this.L;
    }

    public final TextView getTitleTextView() {
        return this.f943v;
    }

    public m1 getWrapper() {
        if (this.f933h0 == null) {
            this.f933h0 = new m3(this, true);
        }
        return this.f933h0;
    }

    public final int j(View view, int i) {
        i3 i3Var = (i3) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i11 = i3Var.f8411a & 112;
        if (i11 != 16 && i11 != 48 && i11 != 80) {
            i11 = this.Q & 112;
        }
        if (i11 == 48) {
            return getPaddingTop() - i10;
        }
        if (i11 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) i3Var).bottomMargin) - i10;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i12 = ((ViewGroup.MarginLayoutParams) i3Var).topMargin;
        if (iMax < i12) {
            iMax = i12;
        } else {
            int i13 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i14 = ((ViewGroup.MarginLayoutParams) i3Var).bottomMargin;
            if (i13 < i14) {
                iMax = Math.max(0, iMax - (i14 - i13));
            }
        }
        return paddingTop + iMax;
    }

    public void m(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public final void n() {
        ArrayList arrayList = this.f930e0;
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
        Iterator it = ((CopyOnWriteArrayList) this.f929d0.f7621w).iterator();
        while (it.hasNext()) {
            ((g0) it.next()).f1281a.j();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f930e0 = currentMenuItems2;
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.f927b0.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f941q0);
        w();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.W = false;
        }
        if (!this.W) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.W = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.W = false;
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
        boolean z2 = u3.f8547a;
        int i11 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c9 = 0;
        } else {
            c9 = 1;
            objArr = false;
        }
        if (u(this.f945x)) {
            t(this.f945x, i, 0, i10, this.I);
            iK = k(this.f945x) + this.f945x.getMeasuredWidth();
            iMax = Math.max(0, l(this.f945x) + this.f945x.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f945x.getMeasuredState());
        } else {
            iK = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (u(this.B)) {
            t(this.B, i, 0, i10, this.I);
            iK = k(this.B) + this.B.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.B) + this.B.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.B.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iK);
        int iMax4 = Math.max(0, currentContentInsetStart - iK);
        Object[] objArr2 = objArr;
        int[] iArr = this.f928c0;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (u(this.f942u)) {
            t(this.f942u, i, iMax3, i10, this.I);
            iK2 = k(this.f942u) + this.f942u.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f942u) + this.f942u.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f942u.getMeasuredState());
        } else {
            iK2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iK2);
        iArr[c9] = Math.max(0, currentContentInsetEnd - iK2);
        if (u(this.C)) {
            iMax5 += s(this.C, i, iMax5, i10, 0, iArr);
            iMax = Math.max(iMax, l(this.C) + this.C.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.C.getMeasuredState());
        }
        if (u(this.f946y)) {
            iMax5 += s(this.f946y, i, iMax5, i10, 0, iArr);
            iMax = Math.max(iMax, l(this.f946y) + this.f946y.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f946y.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((i3) childAt.getLayoutParams()).f8412b == 0 && u(childAt)) {
                iMax5 += s(childAt, i, iMax5, i10, 0, iArr);
                int iMax6 = Math.max(iMax, l(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i13 = iMax5;
        int i14 = this.L + this.M;
        int i15 = this.J + this.K;
        if (u(this.f943v)) {
            s(this.f943v, i, i13 + i15, i10, i14, iArr);
            int iK3 = k(this.f943v) + this.f943v.getMeasuredWidth();
            iL = l(this.f943v) + this.f943v.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f943v.getMeasuredState());
            iMax2 = iK3;
        } else {
            iL = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (u(this.f944w)) {
            iMax2 = Math.max(iMax2, s(this.f944w, i, i13 + i15, i10, i14 + iL, iArr));
            iL += l(this.f944w) + this.f944w.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f944w.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iL);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i13 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, iCombineMeasuredStates2 << 16);
        if (!this.f937m0) {
            i11 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            View childAt2 = getChildAt(i16);
            if (u(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i11 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i11);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof k3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k3 k3Var = (k3) parcelable;
        super.onRestoreInstanceState(k3Var.f14205u);
        ActionMenuView actionMenuView = this.f942u;
        m.k kVar = actionMenuView != null ? actionMenuView.J : null;
        int i = k3Var.f8429w;
        if (i != 0 && this.f935j0 != null && kVar != null && (menuItemFindItem = kVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (k3Var.f8430x) {
            e eVar = this.f941q0;
            removeCallbacks(eVar);
            post(eVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        p2 p2Var = this.N;
        boolean z2 = i == 1;
        if (z2 == p2Var.f8489g) {
            return;
        }
        p2Var.f8489g = z2;
        if (!p2Var.f8490h) {
            p2Var.f8484a = p2Var.f8488e;
            p2Var.f8485b = p2Var.f;
            return;
        }
        if (z2) {
            int i10 = p2Var.f8487d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = p2Var.f8488e;
            }
            p2Var.f8484a = i10;
            int i11 = p2Var.f8486c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = p2Var.f;
            }
            p2Var.f8485b = i11;
            return;
        }
        int i12 = p2Var.f8486c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = p2Var.f8488e;
        }
        p2Var.f8484a = i12;
        int i13 = p2Var.f8487d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = p2Var.f;
        }
        p2Var.f8485b = i13;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        m mVar;
        k3 k3Var = new k3(super.onSaveInstanceState());
        h3 h3Var = this.f935j0;
        if (h3Var != null && (mVar = h3Var.f8397v) != null) {
            k3Var.f8429w = mVar.f8230a;
        }
        k3Var.f8430x = p();
        return k3Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.V = false;
        }
        if (!this.V) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.V = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.V = false;
        return true;
    }

    public final boolean p() {
        k kVar;
        ActionMenuView actionMenuView = this.f942u;
        return (actionMenuView == null || (kVar = actionMenuView.N) == null || !kVar.e()) ? false : true;
    }

    public final int q(View view, int i, int i10, int[] iArr) {
        i3 i3Var = (i3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) i3Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i11) + i;
        iArr[0] = Math.max(0, -i11);
        int iJ = j(view, i10);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) i3Var).rightMargin + iMax;
    }

    public final int r(View view, int i, int i10, int[] iArr) {
        i3 i3Var = (i3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) i3Var).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i11);
        iArr[1] = Math.max(0, -i11);
        int iJ = j(view, i10);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) i3Var).leftMargin);
    }

    public final int s(View view, int i, int i10, int i11, int i12, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i13 = marginLayoutParams.leftMargin - iArr[0];
        int i14 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i14) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        iArr[1] = Math.max(0, -i14);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i12, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.f940p0 != z2) {
            this.f940p0 = z2;
            w();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(com.bumptech.glide.d.p(getContext(), i));
    }

    public void setCollapsible(boolean z2) {
        this.f937m0 = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
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

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.O) {
            this.O = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(com.bumptech.glide.d.p(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(com.bumptech.glide.d.p(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f945x.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(j3 j3Var) {
        this.f931f0 = j3Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f942u.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.E != i) {
            this.E = i;
            if (i == 0) {
                this.D = getContext();
            } else {
                this.D = new ContextThemeWrapper(getContext(), i);
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
        this.M = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.K = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.J = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.L = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public final void t(View view, int i, int i10, int i11, int i12) {
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

    public final boolean u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean v() {
        k kVar;
        ActionMenuView actionMenuView = this.f942u;
        return (actionMenuView == null || (kVar = actionMenuView.N) == null || !kVar.n()) ? false : true;
    }

    public final void w() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = g3.a(this);
            h3 h3Var = this.f935j0;
            boolean z2 = (h3Var == null || h3Var.f8397v == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.f940p0) ? false : true;
            if (z2 && this.f939o0 == null) {
                if (this.f938n0 == null) {
                    this.f938n0 = g3.b(new f3(this, 0));
                }
                g3.c(onBackInvokedDispatcherA, this.f938n0);
                this.f939o0 = onBackInvokedDispatcherA;
                return;
            }
            if (z2 || (onBackInvokedDispatcher = this.f939o0) == null) {
                return;
            }
            g3.d(onBackInvokedDispatcher, this.f938n0);
            this.f939o0 = null;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Q = 8388627;
        this.f926a0 = new ArrayList();
        this.f927b0 = new ArrayList();
        this.f928c0 = new int[2];
        this.f929d0 = new kc.b(new f3(this, 1));
        this.f930e0 = new ArrayList();
        this.f932g0 = new wb.c(27, this);
        this.f941q0 = new e(14, this);
        kc.b bVarD = kc.b.D(getContext(), attributeSet, j.Toolbar, i);
        o0.m(this, context, j.Toolbar, attributeSet, (TypedArray) bVarD.f7621w, i);
        int i10 = j.Toolbar_titleTextAppearance;
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        this.F = typedArray.getResourceId(i10, 0);
        this.G = typedArray.getResourceId(j.Toolbar_subtitleTextAppearance, 0);
        this.Q = typedArray.getInteger(j.Toolbar_android_gravity, 8388627);
        this.H = typedArray.getInteger(j.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(j.Toolbar_titleMargin, 0);
        dimensionPixelOffset = typedArray.hasValue(j.Toolbar_titleMargins) ? typedArray.getDimensionPixelOffset(j.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.M = dimensionPixelOffset;
        this.L = dimensionPixelOffset;
        this.K = dimensionPixelOffset;
        this.J = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.J = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.K = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.L = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(j.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.M = dimensionPixelOffset5;
        }
        this.I = typedArray.getDimensionPixelSize(j.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(j.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(j.Toolbar_contentInsetRight, 0);
        d();
        p2 p2Var = this.N;
        p2Var.f8490h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            p2Var.f8488e = dimensionPixelSize;
            p2Var.f8484a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            p2Var.f = dimensionPixelSize2;
            p2Var.f8485b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            p2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.O = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.P = typedArray.getDimensionPixelOffset(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f947z = bVarD.s(j.Toolbar_collapseIcon);
        this.A = typedArray.getText(j.Toolbar_collapseContentDescription);
        CharSequence text = typedArray.getText(j.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.D = getContext();
        setPopupTheme(typedArray.getResourceId(j.Toolbar_popupTheme, 0));
        Drawable drawableS = bVarD.s(j.Toolbar_navigationIcon);
        if (drawableS != null) {
            setNavigationIcon(drawableS);
        }
        CharSequence text3 = typedArray.getText(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableS2 = bVarD.s(j.Toolbar_logo);
        if (drawableS2 != null) {
            setLogo(drawableS2);
        }
        CharSequence text4 = typedArray.getText(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(j.Toolbar_titleTextColor)) {
            setTitleTextColor(bVarD.q(j.Toolbar_titleTextColor));
        }
        if (typedArray.hasValue(j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(bVarD.q(j.Toolbar_subtitleTextColor));
        }
        if (typedArray.hasValue(j.Toolbar_menu)) {
            m(typedArray.getResourceId(j.Toolbar_menu, 0));
        }
        bVarD.E();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        i3 i3Var = new i3(context, attributeSet);
        i3Var.f8411a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
        i3Var.f8411a = typedArrayObtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
        typedArrayObtainStyledAttributes.recycle();
        i3Var.f8412b = 0;
        return i3Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        x xVar = this.B;
        if (xVar != null) {
            xVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.B.setImageDrawable(drawable);
        } else {
            x xVar = this.B;
            if (xVar != null) {
                xVar.setImageDrawable(this.f947z);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f946y == null) {
                this.f946y = new y(getContext(), null, 0);
            }
            if (!o(this.f946y)) {
                b(this.f946y, true);
            }
        } else {
            y yVar = this.f946y;
            if (yVar != null && o(yVar)) {
                removeView(this.f946y);
                this.f927b0.remove(this.f946y);
            }
        }
        y yVar2 = this.f946y;
        if (yVar2 != null) {
            yVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f946y == null) {
            this.f946y = new y(getContext(), null, 0);
        }
        y yVar = this.f946y;
        if (yVar != null) {
            yVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        x xVar = this.f945x;
        if (xVar != null) {
            xVar.setContentDescription(charSequence);
            q1.c.N(this.f945x, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.f945x)) {
                b(this.f945x, true);
            }
        } else {
            x xVar = this.f945x;
            if (xVar != null && o(xVar)) {
                removeView(this.f945x);
                this.f927b0.remove(this.f945x);
            }
        }
        x xVar2 = this.f945x;
        if (xVar2 != null) {
            xVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            d1 d1Var = this.f944w;
            if (d1Var != null && o(d1Var)) {
                removeView(this.f944w);
                this.f927b0.remove(this.f944w);
            }
        } else {
            if (this.f944w == null) {
                Context context = getContext();
                d1 d1Var2 = new d1(context, null);
                this.f944w = d1Var2;
                d1Var2.setSingleLine();
                this.f944w.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.G;
                if (i != 0) {
                    this.f944w.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.U;
                if (colorStateList != null) {
                    this.f944w.setTextColor(colorStateList);
                }
            }
            if (!o(this.f944w)) {
                b(this.f944w, true);
            }
        }
        d1 d1Var3 = this.f944w;
        if (d1Var3 != null) {
            d1Var3.setText(charSequence);
        }
        this.S = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.U = colorStateList;
        d1 d1Var = this.f944w;
        if (d1Var != null) {
            d1Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            d1 d1Var = this.f943v;
            if (d1Var != null && o(d1Var)) {
                removeView(this.f943v);
                this.f927b0.remove(this.f943v);
            }
        } else {
            if (this.f943v == null) {
                Context context = getContext();
                d1 d1Var2 = new d1(context, null);
                this.f943v = d1Var2;
                d1Var2.setSingleLine();
                this.f943v.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.F;
                if (i != 0) {
                    this.f943v.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.T;
                if (colorStateList != null) {
                    this.f943v.setTextColor(colorStateList);
                }
            }
            if (!o(this.f943v)) {
                b(this.f943v, true);
            }
        }
        d1 d1Var3 = this.f943v;
        if (d1Var3 != null) {
            d1Var3.setText(charSequence);
        }
        this.R = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.T = colorStateList;
        d1 d1Var = this.f943v;
        if (d1Var != null) {
            d1Var.setTextColor(colorStateList);
        }
    }
}
