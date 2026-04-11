package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import e6.f0;
import k8.b0;
import m.i;
import m.j;
import m.k;
import m.v;
import m.y;
import n.f;
import n.l;
import n.m;
import n.n;
import n.u3;
import n.x1;
import n.y1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends y1 implements j, y {
    public k J;
    public Context K;
    public int L;
    public boolean M;
    public n.k N;
    public f0 O;
    public i P;
    public boolean Q;
    public int R;
    public final int S;
    public final int T;
    public n U;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.S = (int) (56.0f * f);
        this.T = (int) (f * 4.0f);
        this.K = context;
        this.L = 0;
    }

    public static m j() {
        m mVar = new m(-2, -2);
        mVar.f8435a = false;
        ((LinearLayout.LayoutParams) mVar).gravity = 16;
        return mVar;
    }

    public static m k(ViewGroup.LayoutParams layoutParams) {
        m mVar;
        if (layoutParams == null) {
            return j();
        }
        if (layoutParams instanceof m) {
            m mVar2 = (m) layoutParams;
            mVar = new m(mVar2);
            mVar.f8435a = mVar2.f8435a;
        } else {
            mVar = new m(layoutParams);
        }
        if (((LinearLayout.LayoutParams) mVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) mVar).gravity = 16;
        }
        return mVar;
    }

    @Override // m.y
    public final void b(k kVar) {
        this.J = kVar;
    }

    @Override // m.j
    public final boolean c(m.m mVar) {
        return this.J.q(mVar, null, 0);
    }

    @Override // n.y1, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof m;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // n.y1
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ x1 generateDefaultLayoutParams() {
        return j();
    }

    @Override // n.y1
    /* JADX INFO: renamed from: g */
    public final x1 generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    @Override // n.y1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    @Override // n.y1, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public Menu getMenu() {
        if (this.J == null) {
            Context context = getContext();
            k kVar = new k(context);
            this.J = kVar;
            kVar.f8209e = new rc.b(24, this);
            n.k kVar2 = new n.k(context);
            this.N = kVar2;
            kVar2.G = true;
            kVar2.H = true;
            v b0Var = this.O;
            if (b0Var == null) {
                b0Var = new b0(19);
            }
            kVar2.f8425y = b0Var;
            this.J.b(kVar2, this.K);
            n.k kVar3 = this.N;
            kVar3.B = this;
            this.J = kVar3.f8423w;
        }
        return this.J;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        n.k kVar = this.N;
        n.i iVar = kVar.D;
        if (iVar != null) {
            return iVar.getDrawable();
        }
        if (kVar.F) {
            return kVar.E;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.L;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // n.y1
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ x1 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public final boolean l(int i) {
        boolean zB = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof l)) {
            zB = ((l) childAt).b();
        }
        return (i <= 0 || !(childAt2 instanceof l)) ? zB : ((l) childAt2).c() | zB;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n.k kVar = this.N;
        if (kVar != null) {
            kVar.f(false);
            if (this.N.e()) {
                this.N.d();
                this.N.n();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n.k kVar = this.N;
        if (kVar != null) {
            kVar.d();
            f fVar = kVar.O;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.i.dismiss();
        }
    }

    @Override // n.y1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        int width;
        int paddingLeft;
        if (!this.Q) {
            super.onLayout(z2, i, i10, i11, i12);
            return;
        }
        int childCount = getChildCount();
        int i13 = (i12 - i10) / 2;
        int dividerWidth = getDividerWidth();
        int i14 = i11 - i;
        int paddingRight = (i14 - getPaddingRight()) - getPaddingLeft();
        boolean z10 = u3.f8547a;
        boolean z11 = getLayoutDirection() == 1;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.f8435a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (l(i17)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z11) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) mVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) mVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i18 = i13 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i18, width, measuredHeight + i18);
                    paddingRight -= measuredWidth;
                    i15 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) mVar).leftMargin) + ((LinearLayout.LayoutParams) mVar).rightMargin;
                    l(i17);
                    i16++;
                }
            }
        }
        if (childCount == 1 && i15 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i19 = (i14 / 2) - (measuredWidth2 / 2);
            int i20 = i13 - (measuredHeight2 / 2);
            childAt2.layout(i19, i20, measuredWidth2 + i19, measuredHeight2 + i20);
            return;
        }
        int i21 = i16 - (i15 ^ 1);
        int iMax = Math.max(0, i21 > 0 ? paddingRight / i21 : 0);
        if (z11) {
            int width2 = getWidth() - getPaddingRight();
            for (int i22 = 0; i22 < childCount; i22++) {
                View childAt3 = getChildAt(i22);
                m mVar2 = (m) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !mVar2.f8435a) {
                    int i23 = width2 - ((LinearLayout.LayoutParams) mVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i24 = i13 - (measuredHeight3 / 2);
                    childAt3.layout(i23 - measuredWidth3, i24, i23, measuredHeight3 + i24);
                    width2 = i23 - ((measuredWidth3 + ((LinearLayout.LayoutParams) mVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i25 = 0; i25 < childCount; i25++) {
            View childAt4 = getChildAt(i25);
            m mVar3 = (m) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !mVar3.f8435a) {
                int i26 = paddingLeft2 + ((LinearLayout.LayoutParams) mVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i27 = i13 - (measuredHeight4 / 2);
                childAt4.layout(i26, i27, i26 + measuredWidth4, measuredHeight4 + i27);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) mVar3).rightMargin + iMax + i26;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // n.y1, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        int i12;
        ?? r11;
        int i13;
        int i14;
        k kVar;
        boolean z2 = this.Q;
        boolean z10 = View.MeasureSpec.getMode(i) == 1073741824;
        this.Q = z10;
        if (z2 != z10) {
            this.R = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.Q && (kVar = this.J) != null && size != this.R) {
            this.R = size;
            kVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.Q || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                m mVar = (m) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) mVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) mVar).leftMargin = 0;
            }
            super.onMeasure(i, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i10);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.S;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i21 = 0;
        int iMax2 = 0;
        int i22 = 0;
        boolean z11 = false;
        int i23 = 0;
        long j5 = 0;
        while (true) {
            i11 = this.T;
            if (i22 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i22);
            int i24 = size3;
            int i25 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i13 = i20;
            } else {
                boolean z12 = childAt instanceof ActionMenuItemView;
                i21++;
                if (z12) {
                    childAt.setPadding(i11, 0, i11, 0);
                }
                m mVar2 = (m) childAt.getLayoutParams();
                mVar2.f = false;
                mVar2.f8437c = 0;
                mVar2.f8436b = 0;
                mVar2.f8438d = false;
                ((LinearLayout.LayoutParams) mVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) mVar2).rightMargin = 0;
                mVar2.f8439e = z12 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i26 = mVar2.f8435a ? 1 : i18;
                m mVar3 = (m) childAt.getLayoutParams();
                int i27 = i18;
                i13 = i20;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i25, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z12 ? (ActionMenuItemView) childAt : null;
                boolean z13 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z14 = z13;
                if (i26 <= 0 || (z13 && i26 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13 * i26, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i13;
                    if (measuredWidth % i13 != 0) {
                        i14++;
                    }
                    if (z14 && i14 < 2) {
                        i14 = 2;
                    }
                }
                mVar3.f8438d = !mVar3.f8435a && z14;
                mVar3.f8436b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i13, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i14);
                if (mVar2.f8438d) {
                    i23++;
                }
                if (mVar2.f8435a) {
                    z11 = true;
                }
                i18 = i27 - i14;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j5 |= (long) (1 << i22);
                }
            }
            i22++;
            size3 = i24;
            paddingBottom = i25;
            i20 = i13;
        }
        int i28 = size3;
        int i29 = i18;
        int i30 = i20;
        boolean z15 = z11 && i21 == 2;
        int i31 = i29;
        boolean z16 = false;
        while (i23 > 0 && i31 > 0) {
            int i32 = Integer.MAX_VALUE;
            long j8 = 0;
            int i33 = 0;
            int i34 = 0;
            while (i34 < childCount2) {
                int i35 = iMax;
                m mVar4 = (m) getChildAt(i34).getLayoutParams();
                boolean z17 = z15;
                if (mVar4.f8438d) {
                    int i36 = mVar4.f8436b;
                    if (i36 < i32) {
                        j8 = 1 << i34;
                        i32 = i36;
                        i33 = 1;
                    } else if (i36 == i32) {
                        j8 |= 1 << i34;
                        i33++;
                    }
                }
                i34++;
                z15 = z17;
                iMax = i35;
            }
            i12 = iMax;
            boolean z18 = z15;
            j5 |= j8;
            if (i33 > i31) {
                break;
            }
            int i37 = i32 + 1;
            int i38 = 0;
            while (i38 < childCount2) {
                View childAt2 = getChildAt(i38);
                m mVar5 = (m) childAt2.getLayoutParams();
                boolean z19 = z11;
                long j10 = 1 << i38;
                if ((j8 & j10) != 0) {
                    if (z18 && mVar5.f8439e) {
                        r11 = 1;
                        r11 = 1;
                        if (i31 == 1) {
                            childAt2.setPadding(i11 + i30, 0, i11, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    mVar5.f8436b += r11;
                    mVar5.f = r11;
                    i31--;
                } else if (mVar5.f8436b == i37) {
                    j5 |= j10;
                }
                i38++;
                z11 = z19;
            }
            z15 = z18;
            iMax = i12;
            z16 = true;
        }
        i12 = iMax;
        boolean z20 = !z11 && i21 == 1;
        if (i31 > 0 && j5 != 0 && (i31 < i21 - 1 || z20 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j5);
            if (!z20) {
                if ((j5 & 1) != 0 && !((m) getChildAt(0).getLayoutParams()).f8439e) {
                    fBitCount -= 0.5f;
                }
                int i39 = childCount2 - 1;
                if ((j5 & ((long) (1 << i39))) != 0 && !((m) getChildAt(i39).getLayoutParams()).f8439e) {
                    fBitCount -= 0.5f;
                }
            }
            int i40 = fBitCount > 0.0f ? (int) ((i31 * i30) / fBitCount) : 0;
            boolean z21 = z16;
            for (int i41 = 0; i41 < childCount2; i41++) {
                if ((j5 & ((long) (1 << i41))) != 0) {
                    View childAt3 = getChildAt(i41);
                    m mVar6 = (m) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        mVar6.f8437c = i40;
                        mVar6.f = true;
                        if (i41 == 0 && !mVar6.f8439e) {
                            ((LinearLayout.LayoutParams) mVar6).leftMargin = (-i40) / 2;
                        }
                        z21 = true;
                    } else if (mVar6.f8435a) {
                        mVar6.f8437c = i40;
                        mVar6.f = true;
                        ((LinearLayout.LayoutParams) mVar6).rightMargin = (-i40) / 2;
                        z21 = true;
                    } else {
                        if (i41 != 0) {
                            ((LinearLayout.LayoutParams) mVar6).leftMargin = i40 / 2;
                        }
                        if (i41 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) mVar6).rightMargin = i40 / 2;
                        }
                    }
                }
            }
            z16 = z21;
        }
        if (z16) {
            for (int i42 = 0; i42 < childCount2; i42++) {
                View childAt4 = getChildAt(i42);
                m mVar7 = (m) childAt4.getLayoutParams();
                if (mVar7.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((mVar7.f8436b * i30) + mVar7.f8437c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i16, mode != 1073741824 ? i12 : i28);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.N.L = z2;
    }

    public void setOnMenuItemClickListener(n nVar) {
        this.U = nVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        n.k kVar = this.N;
        n.i iVar = kVar.D;
        if (iVar != null) {
            iVar.setImageDrawable(drawable);
        } else {
            kVar.F = true;
            kVar.E = drawable;
        }
    }

    public void setOverflowReserved(boolean z2) {
        this.M = z2;
    }

    public void setPopupTheme(int i) {
        if (this.L != i) {
            this.L = i;
            if (i == 0) {
                this.K = getContext();
            } else {
                this.K = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(n.k kVar) {
        this.N = kVar;
        kVar.B = this;
        this.J = kVar.f8423w;
    }

    @Override // n.y1, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }
}
