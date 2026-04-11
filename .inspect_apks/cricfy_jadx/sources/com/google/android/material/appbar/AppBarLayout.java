package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.appbar.AppBarLayout;
import da.d0;
import f0.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k9.g;
import k9.k;
import k9.l;
import m9.f;
import m9.h;
import sd.i;
import t0.m0;
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements f0.a {
    public static final int V = k.Widget_Design_AppBarLayout;
    public int A;
    public p1 B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public ColorStateList G;
    public int H;
    public WeakReference I;
    public ValueAnimator J;
    public ValueAnimator.AnimatorUpdateListener K;
    public final ArrayList L;
    public final LinkedHashSet M;
    public final long N;
    public final TimeInterpolator O;
    public int[] P;
    public int Q;
    public Drawable R;
    public Integer S;
    public final float T;
    public Behavior U;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2754v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2755w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2756x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2757y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2758z;

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static class ScrollingViewBehavior extends f {
        public ScrollingViewBehavior() {
        }

        public static AppBarLayout z(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // f0.b
        public final boolean f(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // f0.b
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            f0.b bVar = ((e) view2.getLayoutParams()).f3897a;
            if (bVar instanceof BaseBehavior) {
                int bottom = (((view2.getBottom() - view.getTop()) + ((BaseBehavior) bVar).E) + this.f8405z) - y(view2);
                WeakHashMap weakHashMap = m0.f11777a;
                view.offsetTopAndBottom(bottom);
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.F) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // f0.b
        public final void i(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                m0.n(coordinatorLayout, null);
            }
        }

        @Override // f0.b
        public final boolean q(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout appBarLayoutZ = z(coordinatorLayout.k(view));
            if (appBarLayoutZ != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f8403x;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayoutZ.d(false, !z10, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ScrollingViewBehavior_Layout);
            this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet) {
        int i = k9.b.appBarLayoutStyle;
        int i10 = V;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f2755w = -1;
        this.f2756x = -1;
        this.f2757y = -1;
        this.A = 0;
        this.L = new ArrayList();
        this.M = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayD = d0.d(context3, attributeSet, h.f8408a, i, i10, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = d0.d(context2, attributeSet, l.AppBarLayout, i, i10, new int[0]);
            this.G = com.bumptech.glide.c.i(context2, typedArrayD2, l.AppBarLayout_liftOnScrollColor);
            this.N = i.C(context2, k9.b.motionDurationMedium2, getResources().getInteger(g.app_bar_elevation_anim_duration));
            this.O = i.D(context2, k9.b.motionEasingStandardInterpolator, l9.a.f7925a);
            if (typedArrayD2.hasValue(l.AppBarLayout_expanded)) {
                d(typedArrayD2.getBoolean(l.AppBarLayout_expanded, false), false, false);
            }
            if (typedArrayD2.hasValue(l.AppBarLayout_elevation)) {
                h.a(this, typedArrayD2.getDimensionPixelSize(l.AppBarLayout_elevation, 0));
            }
            setBackground(typedArrayD2.getDrawable(l.AppBarLayout_android_background));
            if (Build.VERSION.SDK_INT >= 26) {
                if (typedArrayD2.hasValue(l.AppBarLayout_android_keyboardNavigationCluster)) {
                    setKeyboardNavigationCluster(typedArrayD2.getBoolean(l.AppBarLayout_android_keyboardNavigationCluster, false));
                }
                if (typedArrayD2.hasValue(l.AppBarLayout_android_touchscreenBlocksFocus)) {
                    setTouchscreenBlocksFocus(typedArrayD2.getBoolean(l.AppBarLayout_android_touchscreenBlocksFocus, false));
                }
            }
            this.T = getResources().getDimension(k9.d.design_appbar_elevation);
            this.F = typedArrayD2.getBoolean(l.AppBarLayout_liftOnScroll, false);
            this.H = typedArrayD2.getResourceId(l.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(l.AppBarLayout_statusBarForeground));
            typedArrayD2.recycle();
            m2.e eVar = new m2.e(this);
            WeakHashMap weakHashMap = m0.f11777a;
            t0.d0.l(this, eVar);
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    public static m9.d b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            m9.d dVar = new m9.d((LinearLayout.LayoutParams) layoutParams);
            dVar.f8397a = 1;
            return dVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            m9.d dVar2 = new m9.d((ViewGroup.MarginLayoutParams) layoutParams);
            dVar2.f8397a = 1;
            return dVar2;
        }
        m9.d dVar3 = new m9.d(layoutParams);
        dVar3.f8397a = 1;
        return dVar3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final m9.d generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        m9.d dVar = new m9.d(context, attributeSet);
        dVar.f8397a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppBarLayout_Layout);
        dVar.f8397a = typedArrayObtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
        dVar.f8398b = typedArrayObtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollEffect, 0) != 1 ? null : new i2.k(19);
        if (typedArrayObtainStyledAttributes.hasValue(l.AppBarLayout_Layout_layout_scrollInterpolator)) {
            dVar.f8399c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(l.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return dVar;
    }

    public final void c() {
        Behavior behavior = this.U;
        d dVarF = (behavior == null || this.f2755w == -1 || this.A != 0) ? null : behavior.F(a1.c.f111w, this);
        this.f2755w = -1;
        this.f2756x = -1;
        this.f2757y = -1;
        if (dVarF != null) {
            Behavior behavior2 = this.U;
            if (behavior2.H != null) {
                return;
            }
            behavior2.H = dVarF;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof m9.d;
    }

    public final void d(boolean z10, boolean z11, boolean z12) {
        this.A = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.R == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f2754v);
        this.R.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.R;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z10) {
        if (this.C || this.E == z10) {
            return false;
        }
        this.E = z10;
        refreshDrawableState();
        if (!(getBackground() instanceof ka.i)) {
            return true;
        }
        if (this.G != null) {
            g(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.F) {
            return true;
        }
        float f = this.T;
        g(z10 ? 0.0f : f, z10 ? f : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i;
        if (this.I == null && (i = this.H) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.H);
            }
            if (viewFindViewById != null) {
                this.I = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.I;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f, float f10) {
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f10);
        this.J = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.N);
        this.J.setInterpolator(this.O);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.K;
        if (animatorUpdateListener != null) {
            this.J.addUpdateListener(animatorUpdateListener);
        }
        this.J.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        m9.d dVar = new m9.d(-1, -2);
        dVar.f8397a = 1;
        return dVar;
    }

    @Override // f0.a
    public f0.b getBehavior() {
        Behavior behavior = new Behavior();
        this.U = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.f2756x;
        if (i != -1) {
            return i;
        }
        int i10 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                m9.d dVar = (m9.d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = dVar.f8397a;
                if ((i11 & 5) != 5) {
                    if (i10 > 0) {
                        break;
                    }
                } else {
                    int i12 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    if ((i11 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i11 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i12 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i10 += iMin;
                    }
                    iMin = minimumHeight + i12;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i10 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i10);
        this.f2756x = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.f2757y;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i10 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                m9.d dVar = (m9.d) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin + childAt.getMeasuredHeight();
                int i11 = dVar.f8397a;
                if ((i11 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i11 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i10++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f2757y = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.H;
    }

    public ka.i getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof ka.i) {
            return (ka.i) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i = (minimumHeight * 2) + topInset;
            return i < getHeight() ? i : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i10 = (minimumHeight2 * 2) + topInset;
        return i10 < getHeight() ? i10 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.A;
    }

    public Drawable getStatusBarForeground() {
        return this.R;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        p1 p1Var = this.B;
        if (p1Var != null) {
            return p1Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f2755w;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i10 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                m9.d dVar = (m9.d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = dVar.f8397a;
                if ((i11 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin + minimumHeight;
                if (i10 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i11 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i10++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f2755w = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bumptech.glide.e.q(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.P == null) {
            this.P = new int[4];
        }
        int[] iArr = this.P;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z10 = this.D;
        int i10 = k9.b.state_liftable;
        if (!z10) {
            i10 = -i10;
        }
        iArr[0] = i10;
        iArr[1] = (z10 && this.E) ? k9.b.state_lifted : -k9.b.state_lifted;
        int i11 = k9.b.state_collapsible;
        if (!z10) {
            i11 = -i11;
        }
        iArr[2] = i11;
        iArr[3] = (z10 && this.E) ? k9.b.state_collapsed : -k9.b.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.I;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.I = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        boolean z11 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    WeakHashMap weakHashMap = m0.f11777a;
                    childAt2.offsetTopAndBottom(topInset);
                }
            }
        }
        c();
        this.f2758z = false;
        int childCount2 = getChildCount();
        int i13 = 0;
        while (true) {
            if (i13 >= childCount2) {
                break;
            }
            if (((m9.d) getChildAt(i13).getLayoutParams()).f8399c != null) {
                this.f2758z = true;
                break;
            }
            i13++;
        }
        Drawable drawable = this.R;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.C) {
            return;
        }
        if (!this.F) {
            int childCount3 = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount3) {
                    z11 = false;
                    break;
                }
                int i15 = ((m9.d) getChildAt(i14).getLayoutParams()).f8397a;
                if ((i15 & 1) == 1 && (i15 & 10) != 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        if (this.D != z11) {
            this.D = z11;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = w8.e.d(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i10));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        c();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final ka.i iVar;
        ColorStateList colorStateList;
        Context context = getContext();
        final Integer numValueOf = null;
        if (drawable instanceof ka.i) {
            iVar = (ka.i) drawable;
        } else {
            ColorStateList colorStateListR = u8.a.r(drawable);
            if (colorStateListR == null) {
                iVar = null;
            } else {
                ka.i iVar2 = new ka.i();
                iVar2.q(colorStateListR);
                iVar = iVar2;
            }
        }
        if (iVar != null && (colorStateList = iVar.f7334w.f7319d) != null) {
            this.Q = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.G;
            if (colorStateList2 != null) {
                Context context2 = getContext();
                TypedValue typedValueG = android.support.v4.media.session.b.G(context2, k9.b.colorSurface);
                if (typedValueG != null) {
                    int i = typedValueG.resourceId;
                    numValueOf = Integer.valueOf(i != 0 ? context2.getColor(i) : typedValueG.data);
                }
                this.K = new ValueAnimator.AnimatorUpdateListener() { // from class: m9.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num;
                        AppBarLayout appBarLayout = this.f8390a;
                        LinkedHashSet linkedHashSet = appBarLayout.M;
                        ArrayList arrayList = appBarLayout.L;
                        int iD = com.bumptech.glide.f.D(((Float) valueAnimator.getAnimatedValue()).floatValue(), appBarLayout.Q, colorStateList2.getDefaultColor());
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iD);
                        ka.i iVar3 = iVar;
                        iVar3.q(colorStateListValueOf);
                        if (appBarLayout.R != null && (num = appBarLayout.S) != null && num.equals(numValueOf)) {
                            appBarLayout.R.setTint(iD);
                        }
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i10 = 0;
                            while (i10 < size) {
                                Object obj = arrayList.get(i10);
                                i10++;
                                if (obj != null) {
                                    throw new ClassCastException();
                                }
                                if (iVar3.f7334w.f7319d != null) {
                                    throw null;
                                }
                            }
                        }
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            throw q4.a.l(it);
                        }
                    }
                };
            } else {
                iVar.m(context);
                this.K = new m9.c(0, this, iVar);
            }
            drawable = iVar;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        com.bumptech.glide.e.o(this, f);
    }

    public void setExpanded(boolean z10) {
        d(z10, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z10) {
        this.F = z10;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.H = -1;
        if (view != null) {
            this.I = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.I;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.I = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.H = i;
        WeakReference weakReference = this.I;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.I = null;
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.C = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setPendingAction(int i) {
        this.A = i;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.R;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.R = drawableMutate;
            if (drawableMutate instanceof ka.i) {
                numValueOf = Integer.valueOf(((ka.i) drawableMutate).Q);
            } else {
                ColorStateList colorStateListR = u8.a.r(drawableMutate);
                if (colorStateListR != null) {
                    numValueOf = Integer.valueOf(colorStateListR.getDefaultColor());
                }
            }
            this.S = numValueOf;
            Drawable drawable3 = this.R;
            boolean z10 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.R.setState(getDrawableState());
                }
                this.R.setLayoutDirection(getLayoutDirection());
                this.R.setVisible(getVisibility() == 0, false);
                this.R.setCallback(this);
            }
            if (this.R != null && getTopInset() > 0) {
                z10 = true;
            }
            setWillNotDraw(!z10);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(j4.i(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        h.a(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.R;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.R;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static class BaseBehavior<T extends AppBarLayout> extends m9.e {
        public int E;
        public int F;
        public ValueAnimator G;
        public d H;
        public WeakReference I;

        public BaseBehavior() {
            this.A = -1;
            this.C = -1;
        }

        public static View B(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((e) childAt.getLayoutParams()).f3897a instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View D(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof t0.k) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void H(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instruction units count: 207
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.H(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public final void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(y() - i);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iY = y();
            if (iY == i) {
                ValueAnimator valueAnimator = this.G;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.G.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.G;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.G = valueAnimator3;
                valueAnimator3.setInterpolator(l9.a.f7929e);
                this.G.addUpdateListener(new a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.G.setDuration(Math.min(iRound, 600));
            this.G.setIntValues(iY, i);
            this.G.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void E(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.y()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r9 = r2.z(r3, r4, r5, r6, r7)
                r10 = 1
                r13[r10] = r9
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r9 = r4.F
                if (r9 == 0) goto L37
                boolean r9 = r4.f(r11)
                r4.e(r9)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.E(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public final d F(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iW = w();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + iW;
                if (childAt.getTop() + iW <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = a1.c.f111w;
                    }
                    d dVar = new d(parcelable);
                    boolean z10 = iW == 0;
                    dVar.f2772y = z10;
                    dVar.f2771x = !z10 && (-iW) >= appBarLayout.getTotalScrollRange();
                    dVar.f2773z = i;
                    dVar.B = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    dVar.A = bottom / childAt.getHeight();
                    return dVar;
                }
            }
            return null;
        }

        public final void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iY = y() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                m9.d dVar = (m9.d) childAt.getLayoutParams();
                if ((dVar.f8397a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i10 = -iY;
                if (top <= i10 && bottom >= i10) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                m9.d dVar2 = (m9.d) childAt2.getLayoutParams();
                int i11 = dVar2.f8397a;
                if ((i11 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i == 0 && appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if ((i11 & 2) == 2) {
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i11 & 5) == 5) {
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iY < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i11 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) dVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) dVar2).bottomMargin;
                    }
                    if (iY < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    C(coordinatorLayout, appBarLayout, w8.e.d(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // m9.g, f0.b
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.l(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            d dVar = this.H;
            if (dVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i10 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z10) {
                            C(coordinatorLayout, appBarLayout, i10);
                        } else {
                            A(coordinatorLayout, appBarLayout, i10);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            C(coordinatorLayout, appBarLayout, 0);
                        } else {
                            A(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (dVar.f2771x) {
                A(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (dVar.f2772y) {
                A(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(dVar.f2773z);
                int i11 = -childAt.getBottom();
                A(coordinatorLayout, appBarLayout, this.H.B ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i11 : Math.round(childAt.getHeight() * this.H.A) + i11);
            }
            appBarLayout.A = 0;
            this.H = null;
            int iD = w8.e.d(w(), -appBarLayout.getTotalScrollRange(), 0);
            androidx.datastore.preferences.protobuf.k kVar = this.f8406v;
            if (kVar == null) {
                this.f8407w = iD;
            } else if (kVar.f735c != iD) {
                kVar.f735c = iD;
                kVar.a();
            }
            H(coordinatorLayout, appBarLayout, w(), 0, true);
            appBarLayout.f2754v = w();
            if (!appBarLayout.willNotDraw()) {
                appBarLayout.postInvalidateOnAnimation();
            }
            if (m0.d(coordinatorLayout) != null) {
                return true;
            }
            m0.n(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // f0.b
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((e) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.s(appBarLayout, i, i10, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // f0.b
        public final /* bridge */ /* synthetic */ void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10, int[] iArr, int i11) {
            E(coordinatorLayout, (AppBarLayout) view, view2, i10, iArr);
        }

        @Override // f0.b
        public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i11 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = z(coordinatorLayout2, appBarLayout, y() - i11, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i11 == 0 && m0.d(coordinatorLayout2) == null) {
                m0.n(coordinatorLayout2, new b(coordinatorLayout2, this, appBarLayout));
            }
        }

        @Override // f0.b
        public final void r(View view, Parcelable parcelable) {
            if (parcelable instanceof d) {
                this.H = (d) parcelable;
            } else {
                this.H = null;
            }
        }

        @Override // f0.b
        public final Parcelable s(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            d dVarF = F(absSavedState, (AppBarLayout) view);
            return dVarF == null ? absSavedState : dVarF;
        }

        @Override // f0.b
        public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z10 = (i & 2) != 0 && (appBarLayout.F || appBarLayout.E || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z10 && (valueAnimator = this.G) != null) {
                valueAnimator.cancel();
            }
            this.I = null;
            this.F = i10;
            return z10;
        }

        @Override // f0.b
        public final void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.F == 0 || i == 1) {
                G(coordinatorLayout, appBarLayout);
                if (appBarLayout.F) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.I = new WeakReference(view2);
        }

        @Override // m9.e
        public final int y() {
            return w() + this.E;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0165  */
        @Override // m9.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int z(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instruction units count: 381
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.A = -1;
            this.C = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        m9.d dVar = new m9.d(-1, -2);
        dVar.f8397a = 1;
        return dVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }
}
