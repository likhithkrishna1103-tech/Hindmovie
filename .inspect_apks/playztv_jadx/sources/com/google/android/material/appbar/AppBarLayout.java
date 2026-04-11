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
import androidx.datastore.preferences.protobuf.i;
import b8.h;
import c0.e;
import com.google.android.material.appbar.AppBarLayout;
import j9.e0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p8.k;
import p8.l;
import q0.f0;
import q0.o0;
import q0.r1;
import q0.s0;
import q9.g;
import r8.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements c0.a {
    public static final int S = k.Widget_Design_AppBarLayout;
    public r1 A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public WeakReference G;
    public final boolean H;
    public ValueAnimator I;
    public final ValueAnimator.AnimatorUpdateListener J;
    public final ArrayList K;
    public final long L;
    public final TimeInterpolator M;
    public int[] N;
    public Drawable O;
    public Integer P;
    public final float Q;
    public Behavior R;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3305y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3306z;

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static class ScrollingViewBehavior extends r8.d {
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

        @Override // c0.b
        public final boolean f(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // c0.b
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c0.b bVar = ((e) view2.getLayoutParams()).f2209a;
            if (bVar instanceof BaseBehavior) {
                int bottom = (((view2.getBottom() - view.getTop()) + ((BaseBehavior) bVar).D) + this.f11546y) - y(view2);
                WeakHashMap weakHashMap = o0.f10475a;
                view.offsetTopAndBottom(bottom);
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.E) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // c0.b
        public final void i(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                o0.n(coordinatorLayout, null);
            }
        }

        @Override // c0.b
        public final boolean q(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            AppBarLayout appBarLayoutZ = z(coordinatorLayout.k(view));
            if (appBarLayoutZ != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f11544w;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayoutZ.d(false, !z2, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ScrollingViewBehavior_Layout);
            this.f11547z = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet) {
        Integer numValueOf;
        int i = p8.b.appBarLayoutStyle;
        int i10 = S;
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f3302v = -1;
        this.f3303w = -1;
        this.f3304x = -1;
        this.f3306z = 0;
        this.K = new ArrayList();
        Context context2 = getContext();
        int i11 = 1;
        setOrientation(1);
        int i12 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayD = e0.d(context3, attributeSet, f.f11550a, i, i10, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = e0.d(context2, attributeSet, l.AppBarLayout, i, i10, new int[0]);
            Drawable drawable = typedArrayD2.getDrawable(l.AppBarLayout_android_background);
            WeakHashMap weakHashMap = o0.f10475a;
            setBackground(drawable);
            final ColorStateList colorStateListI = a.a.i(context2, typedArrayD2, l.AppBarLayout_liftOnScrollColor);
            this.H = colorStateListI != null;
            final ColorStateList colorStateListK = a.a.k(getBackground());
            if (colorStateListK != null) {
                final g gVar = new g();
                gVar.l(colorStateListK);
                if (colorStateListI != null) {
                    Context context4 = getContext();
                    TypedValue typedValueY = z7.a.y(context4, p8.b.colorSurface);
                    if (typedValueY != null) {
                        int i13 = typedValueY.resourceId;
                        numValueOf = Integer.valueOf(i13 != 0 ? context4.getColor(i13) : typedValueY.data);
                    } else {
                        numValueOf = null;
                    }
                    final Integer num = numValueOf;
                    this.J = new ValueAnimator.AnimatorUpdateListener() { // from class: r8.a
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Integer num2;
                            AppBarLayout appBarLayout = this.f11532a;
                            ArrayList arrayList = appBarLayout.K;
                            int iR = z7.a.r(((Float) valueAnimator.getAnimatedValue()).floatValue(), colorStateListK.getDefaultColor(), colorStateListI.getDefaultColor());
                            ColorStateList colorStateListValueOf = ColorStateList.valueOf(iR);
                            g gVar2 = gVar;
                            gVar2.l(colorStateListValueOf);
                            if (appBarLayout.O != null && (num2 = appBarLayout.P) != null && num2.equals(num)) {
                                appBarLayout.O.setTint(iR);
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            int size = arrayList.size();
                            int i14 = 0;
                            while (i14 < size) {
                                Object obj = arrayList.get(i14);
                                i14++;
                                if (obj != null) {
                                    throw new ClassCastException();
                                }
                                if (gVar2.f11105u.f11092c != null) {
                                    throw null;
                                }
                            }
                        }
                    };
                    setBackground(gVar);
                } else {
                    gVar.j(context2);
                    this.J = new s0(this, i11, gVar);
                    setBackground(gVar);
                }
            }
            this.L = h.x(context2, p8.b.motionDurationMedium2, getResources().getInteger(p8.g.app_bar_elevation_anim_duration));
            this.M = h.y(context2, p8.b.motionEasingStandardInterpolator, q8.a.f11072a);
            if (typedArrayD2.hasValue(l.AppBarLayout_expanded)) {
                d(typedArrayD2.getBoolean(l.AppBarLayout_expanded, false), false, false);
            }
            if (typedArrayD2.hasValue(l.AppBarLayout_elevation)) {
                f.a(this, typedArrayD2.getDimensionPixelSize(l.AppBarLayout_elevation, 0));
            }
            if (i12 >= 26) {
                if (typedArrayD2.hasValue(l.AppBarLayout_android_keyboardNavigationCluster)) {
                    setKeyboardNavigationCluster(typedArrayD2.getBoolean(l.AppBarLayout_android_keyboardNavigationCluster, false));
                }
                if (typedArrayD2.hasValue(l.AppBarLayout_android_touchscreenBlocksFocus)) {
                    setTouchscreenBlocksFocus(typedArrayD2.getBoolean(l.AppBarLayout_android_touchscreenBlocksFocus, false));
                }
            }
            this.Q = getResources().getDimension(p8.d.design_appbar_elevation);
            this.E = typedArrayD2.getBoolean(l.AppBarLayout_liftOnScroll, false);
            this.F = typedArrayD2.getResourceId(l.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(l.AppBarLayout_statusBarForeground));
            typedArrayD2.recycle();
            f0.l(this, new o4.c(this));
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    public static r8.b b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            r8.b bVar = new r8.b((LinearLayout.LayoutParams) layoutParams);
            bVar.f11537a = 1;
            return bVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            r8.b bVar2 = new r8.b((ViewGroup.MarginLayoutParams) layoutParams);
            bVar2.f11537a = 1;
            return bVar2;
        }
        r8.b bVar3 = new r8.b(layoutParams);
        bVar3.f11537a = 1;
        return bVar3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final r8.b generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        r8.b bVar = new r8.b(context, attributeSet);
        bVar.f11537a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.AppBarLayout_Layout);
        bVar.f11537a = typedArrayObtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollFlags, 0);
        bVar.f11538b = typedArrayObtainStyledAttributes.getInt(l.AppBarLayout_Layout_layout_scrollEffect, 0) != 1 ? null : new p2.c(9);
        if (typedArrayObtainStyledAttributes.hasValue(l.AppBarLayout_Layout_layout_scrollInterpolator)) {
            bVar.f11539c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(l.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return bVar;
    }

    public final void c() {
        Behavior behavior = this.R;
        d dVarF = (behavior == null || this.f3302v == -1 || this.f3306z != 0) ? null : behavior.F(x0.b.f14204v, this);
        this.f3302v = -1;
        this.f3303w = -1;
        this.f3304x = -1;
        if (dVarF != null) {
            Behavior behavior2 = this.R;
            if (behavior2.G != null) {
                return;
            }
            behavior2.G = dVarF;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof r8.b;
    }

    public final void d(boolean z2, boolean z10, boolean z11) {
        this.f3306z = (z2 ? 1 : 2) | (z10 ? 4 : 0) | (z11 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.O == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f3301u);
        this.O.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.O;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z2) {
        if (this.B || this.D == z2) {
            return false;
        }
        this.D = z2;
        refreshDrawableState();
        if (!(getBackground() instanceof g)) {
            return true;
        }
        if (this.H) {
            g(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.E) {
            return true;
        }
        float f = this.Q;
        g(z2 ? 0.0f : f, z2 ? f : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i;
        if (this.G == null && (i = this.F) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.F);
            }
            if (viewFindViewById != null) {
                this.G = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.G;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f, float f4) {
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f4);
        this.I = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.L);
        this.I.setInterpolator(this.M);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.J;
        if (animatorUpdateListener != null) {
            this.I.addUpdateListener(animatorUpdateListener);
        }
        this.I.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        r8.b bVar = new r8.b(-1, -2);
        bVar.f11537a = 1;
        return bVar;
    }

    @Override // c0.a
    public c0.b getBehavior() {
        Behavior behavior = new Behavior();
        this.R = behavior;
        return behavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getDownNestedPreScrollRange() {
        /*
            r9 = this;
            int r0 = r9.f3303w
            r1 = -1
            if (r0 == r1) goto L6
            return r0
        L6:
            int r0 = r9.getChildCount()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        Le:
            if (r0 < 0) goto L69
            android.view.View r3 = r9.getChildAt(r0)
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1d
            goto L66
        L1d:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            r8.b r4 = (r8.b) r4
            int r5 = r3.getMeasuredHeight()
            int r6 = r4.f11537a
            r7 = r6 & 5
            r8 = 5
            if (r7 != r8) goto L63
            int r7 = r4.topMargin
            int r4 = r4.bottomMargin
            int r7 = r7 + r4
            r4 = r6 & 8
            if (r4 == 0) goto L3f
            java.util.WeakHashMap r4 = q0.o0.f10475a
            int r4 = r3.getMinimumHeight()
        L3d:
            int r4 = r4 + r7
            goto L4e
        L3f:
            r4 = r6 & 2
            if (r4 == 0) goto L4c
            java.util.WeakHashMap r4 = q0.o0.f10475a
            int r4 = r3.getMinimumHeight()
            int r4 = r5 - r4
            goto L3d
        L4c:
            int r4 = r7 + r5
        L4e:
            if (r0 != 0) goto L61
            java.util.WeakHashMap r6 = q0.o0.f10475a
            boolean r3 = r3.getFitsSystemWindows()
            if (r3 == 0) goto L61
            int r3 = r9.getTopInset()
            int r5 = r5 - r3
            int r4 = java.lang.Math.min(r4, r5)
        L61:
            int r2 = r2 + r4
            goto L66
        L63:
            if (r2 <= 0) goto L66
            goto L69
        L66:
            int r0 = r0 + (-1)
            goto Le
        L69:
            int r0 = java.lang.Math.max(r1, r2)
            r9.f3303w = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i = this.f3304x;
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
                r8.b bVar = (r8.b) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + childAt.getMeasuredHeight();
                int i11 = bVar.f11537a;
                if ((i11 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i11 & 2) != 0) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i10++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f3304x = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.F;
    }

    public g getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof g) {
            return (g) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = o0.f10475a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f3306z;
    }

    public Drawable getStatusBarForeground() {
        return this.O;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        r1 r1Var = this.A;
        if (r1Var != null) {
            return r1Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f3302v;
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
                r8.b bVar = (r8.b) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = bVar.f11537a;
                if ((i11 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin + minimumHeight;
                if (i10 == 0) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    if (childAt.getFitsSystemWindows()) {
                        topInset -= getTopInset();
                    }
                }
                minimumHeight = topInset;
                if ((i11 & 2) != 0) {
                    WeakHashMap weakHashMap2 = o0.f10475a;
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i10++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f3302v = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i5.a.O(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.N == null) {
            this.N = new int[4];
        }
        int[] iArr = this.N;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z2 = this.C;
        int i10 = p8.b.state_liftable;
        if (!z2) {
            i10 = -i10;
        }
        iArr[0] = i10;
        iArr[1] = (z2 && this.D) ? p8.b.state_lifted : -p8.b.state_lifted;
        int i11 = p8.b.state_collapsible;
        if (!z2) {
            i11 = -i11;
        }
        iArr[2] = i11;
        iArr[3] = (z2 && this.D) ? p8.b.state_collapsed : -p8.b.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.G;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.G = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        WeakHashMap weakHashMap = o0.f10475a;
        boolean z10 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    getChildAt(childCount).offsetTopAndBottom(topInset);
                }
            }
        }
        c();
        this.f3305y = false;
        int childCount2 = getChildCount();
        int i13 = 0;
        while (true) {
            if (i13 >= childCount2) {
                break;
            }
            if (((r8.b) getChildAt(i13).getLayoutParams()).f11539c != null) {
                this.f3305y = true;
                break;
            }
            i13++;
        }
        Drawable drawable = this.O;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.B) {
            return;
        }
        if (!this.E) {
            int childCount3 = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount3) {
                    z10 = false;
                    break;
                }
                int i15 = ((r8.b) getChildAt(i14).getLayoutParams()).f11537a;
                if ((i15 & 1) == 1 && (i15 & 10) != 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        if (this.C != z10) {
            this.C = z10;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = o0.f10475a;
            if (getFitsSystemWindows() && getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                    int measuredHeight = getMeasuredHeight();
                    if (mode == Integer.MIN_VALUE) {
                        measuredHeight = cf.d.f(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i10));
                    } else if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        c();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i5.a.K(this, f);
    }

    public void setExpanded(boolean z2) {
        WeakHashMap weakHashMap = o0.f10475a;
        d(z2, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z2) {
        this.E = z2;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.F = -1;
        if (view != null) {
            this.G = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.G;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.G = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.F = i;
        WeakReference weakReference = this.G;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.G = null;
    }

    public void setLiftableOverrideEnabled(boolean z2) {
        this.B = z2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.O;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.O = drawableMutate;
            if (drawableMutate instanceof g) {
                numValueOf = Integer.valueOf(((g) drawableMutate).O);
            } else {
                ColorStateList colorStateListK = a.a.k(drawableMutate);
                if (colorStateListK != null) {
                    numValueOf = Integer.valueOf(colorStateListK.getDefaultColor());
                }
            }
            this.P = numValueOf;
            Drawable drawable3 = this.O;
            boolean z2 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.O.setState(getDrawableState());
                }
                Drawable drawable4 = this.O;
                WeakHashMap weakHashMap = o0.f10475a;
                drawable4.setLayoutDirection(getLayoutDirection());
                this.O.setVisible(getVisibility() == 0, false);
                this.O.setCallback(this);
            }
            if (this.O != null && getTopInset() > 0) {
                z2 = true;
            }
            setWillNotDraw(!z2);
            WeakHashMap weakHashMap2 = o0.f10475a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(com.bumptech.glide.d.p(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        f.a(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z2 = i == 0;
        Drawable drawable = this.O;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.O;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static class BaseBehavior<T extends AppBarLayout> extends r8.c {
        public int D;
        public int E;
        public ValueAnimator F;
        public d G;
        public WeakReference H;

        public BaseBehavior() {
            this.f11543z = -1;
            this.B = -1;
        }

        public static View B(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((e) childAt.getLayoutParams()).f2209a instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View D(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof q0.l) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void H(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instruction units count: 209
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
                ValueAnimator valueAnimator = this.F;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.F.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.F;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.F = valueAnimator3;
                valueAnimator3.setInterpolator(q8.a.f11076e);
                this.F.addUpdateListener(new a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.F.setDuration(Math.min(iRound, 600));
            this.F.setIntValues(iY, i);
            this.F.start();
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
                boolean r9 = r4.E
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
                        parcelable = x0.b.f14204v;
                    }
                    d dVar = new d(parcelable);
                    boolean z2 = iW == 0;
                    dVar.f3320x = z2;
                    dVar.f3319w = !z2 && (-iW) >= appBarLayout.getTotalScrollRange();
                    dVar.f3321y = i;
                    WeakHashMap weakHashMap = o0.f10475a;
                    dVar.A = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    dVar.f3322z = bottom / childAt.getHeight();
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
                r8.b bVar = (r8.b) childAt.getLayoutParams();
                if ((bVar.f11537a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) bVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) bVar).bottomMargin;
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
                r8.b bVar2 = (r8.b) childAt2.getLayoutParams();
                int i11 = bVar2.f11537a;
                if ((i11 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i == 0) {
                        WeakHashMap weakHashMap = o0.f10475a;
                        if (appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                            topInset -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i11 & 2) == 2) {
                        WeakHashMap weakHashMap2 = o0.f10475a;
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i11 & 5) == 5) {
                        WeakHashMap weakHashMap3 = o0.f10475a;
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iY < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i11 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) bVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) bVar2).bottomMargin;
                    }
                    if (iY < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    C(coordinatorLayout, appBarLayout, cf.d.f(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // r8.e, c0.b
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            int iRound;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.l(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            d dVar = this.G;
            if (dVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z2 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i10 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z2) {
                            C(coordinatorLayout, appBarLayout, i10);
                        } else {
                            A(coordinatorLayout, appBarLayout, i10);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z2) {
                            C(coordinatorLayout, appBarLayout, 0);
                        } else {
                            A(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (dVar.f3319w) {
                A(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (dVar.f3320x) {
                A(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(dVar.f3321y);
                int i11 = -childAt.getBottom();
                if (this.G.A) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    iRound = appBarLayout.getTopInset() + childAt.getMinimumHeight() + i11;
                } else {
                    iRound = Math.round(childAt.getHeight() * this.G.f3322z) + i11;
                }
                A(coordinatorLayout, appBarLayout, iRound);
            }
            appBarLayout.f3306z = 0;
            this.G = null;
            int iF = cf.d.f(w(), -appBarLayout.getTotalScrollRange(), 0);
            i iVar = this.f11548u;
            if (iVar == null) {
                this.f11549v = iF;
            } else if (iVar.f1066c != iF) {
                iVar.f1066c = iF;
                iVar.b();
            }
            H(coordinatorLayout, appBarLayout, w(), 0, true);
            appBarLayout.f3301u = w();
            if (!appBarLayout.willNotDraw()) {
                WeakHashMap weakHashMap2 = o0.f10475a;
                appBarLayout.postInvalidateOnAnimation();
            }
            if (o0.d(coordinatorLayout) != null) {
                return true;
            }
            o0.n(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // c0.b
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((e) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.s(appBarLayout, i, i10, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // c0.b
        public final /* bridge */ /* synthetic */ void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10, int[] iArr, int i11) {
            E(coordinatorLayout, (AppBarLayout) view, view2, i10, iArr);
        }

        @Override // c0.b
        public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i11 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = z(coordinatorLayout2, appBarLayout, y() - i11, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i11 == 0 && o0.d(coordinatorLayout2) == null) {
                o0.n(coordinatorLayout2, new b(coordinatorLayout2, this, appBarLayout));
            }
        }

        @Override // c0.b
        public final void r(View view, Parcelable parcelable) {
            if (parcelable instanceof d) {
                this.G = (d) parcelable;
            } else {
                this.G = null;
            }
        }

        @Override // c0.b
        public final Parcelable s(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            d dVarF = F(absSavedState, (AppBarLayout) view);
            return dVarF == null ? absSavedState : dVarF;
        }

        @Override // c0.b
        public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z2 = (i & 2) != 0 && (appBarLayout.E || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z2 && (valueAnimator = this.F) != null) {
                valueAnimator.cancel();
            }
            this.H = null;
            this.E = i10;
            return z2;
        }

        @Override // c0.b
        public final void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.E == 0 || i == 1) {
                G(coordinatorLayout, appBarLayout);
                if (appBarLayout.E) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.H = new WeakReference(view2);
        }

        @Override // r8.c
        public final int y() {
            return w() + this.D;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x016f  */
        @Override // r8.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int z(androidx.coordinatorlayout.widget.CoordinatorLayout r19, android.view.View r20, int r21, int r22, int r23) {
            /*
                Method dump skipped, instruction units count: 391
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.f11543z = -1;
            this.B = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        r8.b bVar = new r8.b(-1, -2);
        bVar.f11537a = 1;
        return bVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }
}
