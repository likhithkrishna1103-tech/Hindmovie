package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.j4;
import da.d0;
import da.e0;
import f9.z;
import g.j;
import java.util.ArrayList;
import java.util.Iterator;
import k9.k;
import o.d2;
import oa.c;
import oa.d;
import oa.h;
import oa.i;
import oa.l;
import p5.a;
import p5.b;
import p5.g;
import q5.o;
import s0.e;
import v5.r;
import v5.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@b
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f2938u0 = k.Widget_Design_TabLayout;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final e f2939v0 = new e(16);
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public ColorStateList G;
    public ColorStateList H;
    public ColorStateList I;
    public Drawable J;
    public int K;
    public final float L;
    public final float M;
    public final float N;
    public final int O;
    public int P;
    public final int Q;
    public final int R;
    public final int S;
    public final int T;
    public int U;
    public final int V;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f2940a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f2941b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f2942c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f2943d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f2944e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f2945f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public z f2946g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final TimeInterpolator f2947h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public d f2948i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final ArrayList f2949j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public l f2950k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public ValueAnimator f2951l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public g f2952m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public a f2953n0;
    public d2 o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public i f2954p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public c f2955q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f2956r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f2957s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final s0.d f2958t0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2959v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f2960w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h f2961x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final oa.g f2962y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f2963z;

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet) {
        int i = k9.b.tabStyle;
        int i10 = f2938u0;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f2959v = -1;
        this.f2960w = new ArrayList();
        this.F = -1;
        this.K = 0;
        this.P = Integer.MAX_VALUE;
        this.f2943d0 = -1;
        this.f2949j0 = new ArrayList();
        this.f2958t0 = new s0.d(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        oa.g gVar = new oa.g(this, context2);
        this.f2962y = gVar;
        super.addView(gVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayD = d0.d(context2, attributeSet, k9.l.TabLayout, i, i10, k9.l.TabLayout_tabTextAppearance);
        ColorStateList colorStateListR = u8.a.r(getBackground());
        if (colorStateListR != null) {
            ka.i iVar = new ka.i();
            iVar.q(colorStateListR);
            iVar.m(context2);
            iVar.p(getElevation());
            setBackground(iVar);
        }
        setSelectedTabIndicator(com.bumptech.glide.c.l(context2, typedArrayD, k9.l.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayD.getColor(k9.l.TabLayout_tabIndicatorColor, 0));
        gVar.b(typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayD.getInt(k9.l.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayD.getInt(k9.l.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayD.getBoolean(k9.l.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabPadding, 0);
        this.C = dimensionPixelSize;
        this.B = dimensionPixelSize;
        this.A = dimensionPixelSize;
        this.f2963z = dimensionPixelSize;
        this.f2963z = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.A = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabPaddingTop, dimensionPixelSize);
        this.B = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabPaddingEnd, dimensionPixelSize);
        this.C = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabPaddingBottom, dimensionPixelSize);
        if (android.support.v4.media.session.b.H(context2, k9.b.isMaterial3Theme, false)) {
            this.D = k9.b.textAppearanceTitleSmall;
        } else {
            this.D = k9.b.textAppearanceButton;
        }
        int resourceId = typedArrayD.getResourceId(k9.l.TabLayout_tabTextAppearance, k.TextAppearance_Design_Tab);
        this.E = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, j.TextAppearance);
        try {
            this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.TextAppearance_android_textSize, 0);
            this.G = com.bumptech.glide.c.i(context2, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayD.hasValue(k9.l.TabLayout_tabSelectedTextAppearance)) {
                this.F = typedArrayD.getResourceId(k9.l.TabLayout_tabSelectedTextAppearance, resourceId);
            }
            int i11 = this.F;
            int[] iArr = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr2 = HorizontalScrollView.SELECTED_STATE_SET;
            if (i11 != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i11, j.TextAppearance);
                try {
                    this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.TextAppearance_android_textSize, (int) r4);
                    ColorStateList colorStateListI = com.bumptech.glide.c.i(context2, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColor);
                    if (colorStateListI != null) {
                        this.G = new ColorStateList(new int[][]{iArr2, iArr}, new int[]{colorStateListI.getColorForState(new int[]{R.attr.state_selected}, colorStateListI.getDefaultColor()), this.G.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (typedArrayD.hasValue(k9.l.TabLayout_tabTextColor)) {
                this.G = com.bumptech.glide.c.i(context2, typedArrayD, k9.l.TabLayout_tabTextColor);
            }
            if (typedArrayD.hasValue(k9.l.TabLayout_tabSelectedTextColor)) {
                this.G = new ColorStateList(new int[][]{iArr2, iArr}, new int[]{typedArrayD.getColor(k9.l.TabLayout_tabSelectedTextColor, 0), this.G.getDefaultColor()});
            }
            this.H = com.bumptech.glide.c.i(context2, typedArrayD, k9.l.TabLayout_tabIconTint);
            e0.c(typedArrayD.getInt(k9.l.TabLayout_tabIconTintMode, -1), null);
            this.I = com.bumptech.glide.c.i(context2, typedArrayD, k9.l.TabLayout_tabRippleColor);
            this.V = typedArrayD.getInt(k9.l.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f2947h0 = sd.i.D(context2, k9.b.motionEasingEmphasizedInterpolator, l9.a.f7926b);
            this.Q = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabMinWidth, -1);
            this.R = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabMaxWidth, -1);
            this.O = typedArrayD.getResourceId(k9.l.TabLayout_tabBackground, 0);
            this.T = typedArrayD.getDimensionPixelSize(k9.l.TabLayout_tabContentStart, 0);
            this.f2940a0 = typedArrayD.getInt(k9.l.TabLayout_tabMode, 1);
            this.U = typedArrayD.getInt(k9.l.TabLayout_tabGravity, 0);
            this.f2941b0 = typedArrayD.getBoolean(k9.l.TabLayout_tabInlineLabel, false);
            this.f2945f0 = typedArrayD.getBoolean(k9.l.TabLayout_tabUnboundedRipple, false);
            typedArrayD.recycle();
            Resources resources = getResources();
            this.N = resources.getDimensionPixelSize(k9.d.design_tab_text_size_2line);
            this.S = resources.getDimensionPixelSize(k9.d.design_tab_scrollable_min_width);
            c();
        } finally {
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f2960w;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.Q;
        if (i != -1) {
            return i;
        }
        int i10 = this.f2940a0;
        if (i10 == 0 || i10 == 2) {
            return this.S;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f2962y.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        oa.g gVar = this.f2962y;
        int childCount = gVar.getChildCount();
        if (i < childCount) {
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = gVar.getChildAt(i10);
                if ((i10 != i || childAt.isSelected()) && (i10 == i || !childAt.isSelected())) {
                    childAt.setSelected(i10 == i);
                    childAt.setActivated(i10 == i);
                } else {
                    childAt.setSelected(i10 == i);
                    childAt.setActivated(i10 == i);
                    if (childAt instanceof oa.k) {
                        ((oa.k) childAt).f();
                    }
                }
                i10++;
            }
        }
    }

    public final void a(h hVar, boolean z10) {
        ArrayList arrayList = this.f2960w;
        int size = arrayList.size();
        if (hVar.f9724d != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        hVar.f9722b = size;
        arrayList.add(size, hVar);
        int size2 = arrayList.size();
        int i = -1;
        for (int i10 = size + 1; i10 < size2; i10++) {
            if (((h) arrayList.get(i10)).f9722b == this.f2959v) {
                i = i10;
            }
            ((h) arrayList.get(i10)).f9722b = i10;
        }
        this.f2959v = i;
        oa.k kVar = hVar.f9725e;
        kVar.setSelected(false);
        kVar.setActivated(false);
        int i11 = hVar.f9722b;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.f2940a0 == 1 && this.U == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f2962y.addView(kVar, i11, layoutParams);
        if (z10) {
            TabLayout tabLayout = hVar.f9724d;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.j(hVar, true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void b(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && isLaidOut()) {
            oa.g gVar = this.f2962y;
            int childCount = gVar.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (gVar.getChildAt(i10).getWidth() > 0) {
                }
            }
            int scrollX = getScrollX();
            int iD = d(i, 0.0f);
            if (scrollX != iD) {
                e();
                this.f2951l0.setIntValues(scrollX, iD);
                this.f2951l0.start();
            }
            ValueAnimator valueAnimator = gVar.f9719v;
            if (valueAnimator != null && valueAnimator.isRunning() && gVar.f9720w.f2959v != i) {
                gVar.f9719v.cancel();
            }
            gVar.d(i, this.V, true);
            return;
        }
        l(i, 0.0f, true, true, true);
    }

    public final void c() {
        int i = this.f2940a0;
        int iMax = (i == 0 || i == 2) ? Math.max(0, this.T - this.f2963z) : 0;
        oa.g gVar = this.f2962y;
        gVar.setPaddingRelative(iMax, 0, 0, 0);
        int i10 = this.f2940a0;
        if (i10 == 0) {
            int i11 = this.U;
            if (i11 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i11 == 1) {
                gVar.setGravity(1);
            } else if (i11 == 2) {
            }
            gVar.setGravity(8388611);
        } else if (i10 == 1 || i10 == 2) {
            if (this.U == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            gVar.setGravity(1);
        }
        n(true);
    }

    public final int d(int i, float f) {
        oa.g gVar;
        View childAt;
        int i10 = this.f2940a0;
        if ((i10 != 0 && i10 != 2) || (childAt = (gVar = this.f2962y).getChildAt(i)) == null) {
            return 0;
        }
        int i11 = i + 1;
        View childAt2 = i11 < gVar.getChildCount() ? gVar.getChildAt(i11) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i12 = (int) ((width + width2) * 0.5f * f);
        return getLayoutDirection() == 0 ? left + i12 : left - i12;
    }

    public final void e() {
        if (this.f2951l0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f2951l0 = valueAnimator;
            valueAnimator.setInterpolator(this.f2947h0);
            this.f2951l0.setDuration(this.V);
            this.f2951l0.addUpdateListener(new oa.b(0, this));
        }
    }

    public final h f(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return (h) this.f2960w.get(i);
    }

    public final h g() {
        h hVar = (h) f2939v0.i();
        if (hVar == null) {
            hVar = new h();
            hVar.f9722b = -1;
        }
        hVar.f9724d = this;
        s0.d dVar = this.f2958t0;
        oa.k kVar = dVar != null ? (oa.k) dVar.i() : null;
        if (kVar == null) {
            kVar = new oa.k(this, getContext());
        }
        kVar.setTab(hVar);
        kVar.setFocusable(true);
        kVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(null)) {
            kVar.setContentDescription(hVar.f9721a);
        } else {
            kVar.setContentDescription(null);
        }
        hVar.f9725e = kVar;
        return hVar;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        h hVar = this.f2961x;
        if (hVar != null) {
            return hVar.f9722b;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f2960w.size();
    }

    public int getTabGravity() {
        return this.U;
    }

    public ColorStateList getTabIconTint() {
        return this.H;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f2944e0;
    }

    public int getTabIndicatorGravity() {
        return this.W;
    }

    public int getTabMaxWidth() {
        return this.P;
    }

    public int getTabMode() {
        return this.f2940a0;
    }

    public ColorStateList getTabRippleColor() {
        return this.I;
    }

    public Drawable getTabSelectedIndicator() {
        return this.J;
    }

    public ColorStateList getTabTextColors() {
        return this.G;
    }

    public final void h() {
        int currentItem;
        String string;
        i();
        a aVar = this.f2953n0;
        if (aVar != null) {
            int iC = aVar.c();
            for (int i = 0; i < iC; i++) {
                h hVarG = g();
                s sVar = ((r) this.f2953n0).f13450g;
                Resources resourcesM = sVar.m();
                int iIntValue = ((Integer) sVar.J0.get(i)).intValue();
                if (iIntValue == 1) {
                    string = resourcesM.getString(o.exo_track_selection_title_audio);
                } else if (iIntValue == 2) {
                    string = resourcesM.getString(o.exo_track_selection_title_video);
                } else {
                    if (iIntValue != 3) {
                        throw new IllegalArgumentException();
                    }
                    string = resourcesM.getString(o.exo_track_selection_title_text);
                }
                if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(string)) {
                    hVarG.f9725e.setContentDescription(string);
                }
                hVarG.f9721a = string;
                oa.k kVar = hVarG.f9725e;
                if (kVar != null) {
                    kVar.d();
                }
                a(hVarG, false);
            }
            g gVar = this.f2952m0;
            if (gVar == null || iC <= 0 || (currentItem = gVar.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            j(f(currentItem), true);
        }
    }

    public final void i() {
        oa.g gVar = this.f2962y;
        int childCount = gVar.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            oa.k kVar = (oa.k) gVar.getChildAt(childCount);
            gVar.removeViewAt(childCount);
            if (kVar != null) {
                kVar.setTab(null);
                kVar.setSelected(false);
                this.f2958t0.b(kVar);
            }
            requestLayout();
        }
        Iterator it = this.f2960w.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            it.remove();
            hVar.f9724d = null;
            hVar.f9725e = null;
            hVar.f9721a = null;
            hVar.f9722b = -1;
            hVar.f9723c = null;
            f2939v0.b(hVar);
        }
        this.f2961x = null;
    }

    public final void j(h hVar, boolean z10) {
        TabLayout tabLayout;
        h hVar2 = this.f2961x;
        ArrayList arrayList = this.f2949j0;
        if (hVar2 == hVar) {
            if (hVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((d) arrayList.get(size)).getClass();
                }
                b(hVar.f9722b);
                return;
            }
            return;
        }
        int i = hVar != null ? hVar.f9722b : -1;
        if (z10) {
            if ((hVar2 == null || hVar2.f9722b == -1) && i != -1) {
                tabLayout = this;
                tabLayout.l(i, 0.0f, true, true, true);
            } else {
                tabLayout = this;
                b(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.f2961x = hVar;
        if (hVar2 != null && hVar2.f9724d != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((d) arrayList.get(size2)).getClass();
            }
        }
        if (hVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((d) arrayList.get(size3)).a(hVar);
            }
        }
    }

    public final void k(a aVar, boolean z10) {
        d2 d2Var;
        a aVar2 = this.f2953n0;
        if (aVar2 != null && (d2Var = this.o0) != null) {
            aVar2.f9990a.unregisterObserver(d2Var);
        }
        this.f2953n0 = aVar;
        if (z10 && aVar != null) {
            if (this.o0 == null) {
                this.o0 = new d2(1, this);
            }
            aVar.f9990a.registerObserver(this.o0);
        }
        h();
    }

    public final void l(int i, float f, boolean z10, boolean z11, boolean z12) {
        float f10 = i + f;
        int iRound = Math.round(f10);
        if (iRound >= 0) {
            oa.g gVar = this.f2962y;
            if (iRound >= gVar.getChildCount()) {
                return;
            }
            if (z11) {
                gVar.f9720w.f2959v = Math.round(f10);
                ValueAnimator valueAnimator = gVar.f9719v;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    gVar.f9719v.cancel();
                }
                gVar.c(gVar.getChildAt(i), gVar.getChildAt(i + 1), f);
            }
            ValueAnimator valueAnimator2 = this.f2951l0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f2951l0.cancel();
            }
            int iD = d(i, f);
            int scrollX = getScrollX();
            boolean z13 = (i < getSelectedTabPosition() && iD >= scrollX) || (i > getSelectedTabPosition() && iD <= scrollX) || i == getSelectedTabPosition();
            if (getLayoutDirection() == 1) {
                z13 = (i < getSelectedTabPosition() && iD <= scrollX) || (i > getSelectedTabPosition() && iD >= scrollX) || i == getSelectedTabPosition();
            }
            if (z13 || this.f2957s0 == 1 || z12) {
                if (i < 0) {
                    iD = 0;
                }
                scrollTo(iD, 0);
            }
            if (z10) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void m(g gVar, boolean z10) {
        TabLayout tabLayout;
        ArrayList arrayList;
        ArrayList arrayList2;
        g gVar2 = this.f2952m0;
        if (gVar2 != null) {
            i iVar = this.f2954p0;
            if (iVar != null && (arrayList2 = gVar2.o0) != null) {
                arrayList2.remove(iVar);
            }
            c cVar = this.f2955q0;
            if (cVar != null && (arrayList = this.f2952m0.f10020q0) != null) {
                arrayList.remove(cVar);
            }
        }
        l lVar = this.f2950k0;
        ArrayList arrayList3 = this.f2949j0;
        if (lVar != null) {
            arrayList3.remove(lVar);
            this.f2950k0 = null;
        }
        if (gVar != null) {
            this.f2952m0 = gVar;
            if (this.f2954p0 == null) {
                this.f2954p0 = new i(this);
            }
            i iVar2 = this.f2954p0;
            iVar2.f9728c = 0;
            iVar2.f9727b = 0;
            if (gVar.o0 == null) {
                gVar.o0 = new ArrayList();
            }
            gVar.o0.add(iVar2);
            l lVar2 = new l(0, gVar);
            this.f2950k0 = lVar2;
            if (!arrayList3.contains(lVar2)) {
                arrayList3.add(lVar2);
            }
            a adapter = gVar.getAdapter();
            if (adapter != null) {
                k(adapter, true);
            }
            if (this.f2955q0 == null) {
                this.f2955q0 = new c(this);
            }
            c cVar2 = this.f2955q0;
            cVar2.f9713a = true;
            if (gVar.f10020q0 == null) {
                gVar.f10020q0 = new ArrayList();
            }
            gVar.f10020q0.add(cVar2);
            l(gVar.getCurrentItem(), 0.0f, true, true, true);
            tabLayout = this;
        } else {
            tabLayout = this;
            tabLayout.f2952m0 = null;
            k(null, false);
        }
        tabLayout.f2956r0 = z10;
    }

    public final void n(boolean z10) {
        int i = 0;
        while (true) {
            oa.g gVar = this.f2962y;
            if (i >= gVar.getChildCount()) {
                return;
            }
            View childAt = gVar.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.f2940a0 == 1 && this.U == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z10) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bumptech.glide.e.q(this);
        if (this.f2952m0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof g) {
                m((g) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2956r0) {
            setupWithViewPager(null);
            this.f2956r0 = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        oa.k kVar;
        Drawable drawable;
        int i = 0;
        while (true) {
            oa.g gVar = this.f2962y;
            if (i >= gVar.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = gVar.getChildAt(i);
            if ((childAt instanceof oa.k) && (drawable = (kVar = (oa.k) childAt).D) != null) {
                drawable.setBounds(kVar.getLeft(), kVar.getTop(), kVar.getRight(), kVar.getBottom());
                kVar.D.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = da.e0.a(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.R
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = da.e0.a(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.P = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.f2940a0
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        com.bumptech.glide.e.o(this, f);
    }

    public void setInlineLabel(boolean z10) {
        if (this.f2941b0 == z10) {
            return;
        }
        this.f2941b0 = z10;
        int i = 0;
        while (true) {
            oa.g gVar = this.f2962y;
            if (i >= gVar.getChildCount()) {
                c();
                return;
            }
            View childAt = gVar.getChildAt(i);
            if (childAt instanceof oa.k) {
                oa.k kVar = (oa.k) childAt;
                kVar.setOrientation(!kVar.F.f2941b0 ? 1 : 0);
                TextView textView = kVar.B;
                if (textView == null && kVar.C == null) {
                    kVar.g(kVar.f9732w, kVar.f9733x, true);
                } else {
                    kVar.g(textView, kVar.C, false);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(oa.e eVar) {
        setOnTabSelectedListener((d) eVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        e();
        this.f2951l0.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.J = drawableMutate;
        int i = this.K;
        if (i != 0) {
            drawableMutate.setTint(i);
        } else {
            drawableMutate.setTintList(null);
        }
        int intrinsicHeight = this.f2943d0;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.J.getIntrinsicHeight();
        }
        this.f2962y.b(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.K = i;
        Drawable drawable = this.J;
        if (i != 0) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
        n(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.W != i) {
            this.W = i;
            this.f2962y.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.f2943d0 = i;
        this.f2962y.b(i);
    }

    public void setTabGravity(int i) {
        if (this.U != i) {
            this.U = i;
            c();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            ArrayList arrayList = this.f2960w;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                oa.k kVar = ((h) arrayList.get(i)).f9725e;
                if (kVar != null) {
                    kVar.d();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(i0.c.c(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.f2944e0 = i;
        if (i == 0) {
            this.f2946g0 = new z(20);
            return;
        }
        if (i == 1) {
            this.f2946g0 = new oa.a(0);
        } else {
            if (i == 2) {
                this.f2946g0 = new oa.a(1);
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.f2942c0 = z10;
        int i = oa.g.f9718x;
        oa.g gVar = this.f2962y;
        gVar.a(gVar.f9720w.getSelectedTabPosition());
        gVar.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.f2940a0) {
            this.f2940a0 = i;
            c();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.I == colorStateList) {
            return;
        }
        this.I = colorStateList;
        int i = 0;
        while (true) {
            oa.g gVar = this.f2962y;
            if (i >= gVar.getChildCount()) {
                return;
            }
            View childAt = gVar.getChildAt(i);
            if (childAt instanceof oa.k) {
                Context context = getContext();
                int i10 = oa.k.G;
                ((oa.k) childAt).e(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(i0.c.c(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            ArrayList arrayList = this.f2960w;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                oa.k kVar = ((h) arrayList.get(i)).f9725e;
                if (kVar != null) {
                    kVar.d();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(a aVar) {
        k(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.f2945f0 == z10) {
            return;
        }
        this.f2945f0 = z10;
        int i = 0;
        while (true) {
            oa.g gVar = this.f2962y;
            if (i >= gVar.getChildCount()) {
                return;
            }
            View childAt = gVar.getChildAt(i);
            if (childAt instanceof oa.k) {
                Context context = getContext();
                int i10 = oa.k.G;
                ((oa.k) childAt).e(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(g gVar) {
        m(gVar, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        d dVar2 = this.f2948i0;
        ArrayList arrayList = this.f2949j0;
        if (dVar2 != null) {
            arrayList.remove(dVar2);
        }
        this.f2948i0 = dVar;
        if (dVar == null || arrayList.contains(dVar)) {
            return;
        }
        arrayList.add(dVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(j4.i(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
