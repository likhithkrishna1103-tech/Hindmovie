package com.google.android.material.floatingactionbutton;

import aa.l0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c0.e;
import c0.f;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g9.a;
import g9.b;
import h9.c;
import h9.i;
import j9.e0;
import j9.f0;
import j9.k0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.t;
import p8.d;
import p8.k;
import p8.l;
import q0.o0;
import q9.g;
import q9.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends k0 implements a, u, c0.a {
    public static final int K = k.Widget_Design_FloatingActionButton;
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public final Rect F;
    public final Rect G;
    public final l0 H;
    public final b I;
    public h9.k J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f3447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PorterDuff.Mode f3448w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorStateList f3449x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PorterDuff.Mode f3450y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f3451z;

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        int i = p8.b.floatingActionButtonStyle;
        int i10 = K;
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f6893u = getVisibility();
        this.F = new Rect();
        this.G = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = e0.d(context2, attributeSet, l.FloatingActionButton, i, i10, new int[0]);
        this.f3447v = a.a.i(context2, typedArrayD, l.FloatingActionButton_backgroundTint);
        this.f3448w = f0.e(typedArrayD.getInt(l.FloatingActionButton_backgroundTintMode, -1), null);
        this.f3451z = a.a.i(context2, typedArrayD, l.FloatingActionButton_rippleColor);
        this.A = typedArrayD.getInt(l.FloatingActionButton_fabSize, -1);
        this.B = typedArrayD.getDimensionPixelSize(l.FloatingActionButton_fabCustomSize, 0);
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(l.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayD.getDimension(l.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayD.getDimension(l.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayD.getDimension(l.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.E = typedArrayD.getBoolean(l.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayD.getDimensionPixelSize(l.FloatingActionButton_maxImageSize, 0));
        q8.d dVarA = q8.d.a(context2, typedArrayD, l.FloatingActionButton_showMotionSpec);
        q8.d dVarA2 = q8.d.a(context2, typedArrayD, l.FloatingActionButton_hideMotionSpec);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.MaterialShape, i, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        q9.k kVarA = q9.k.b(context2, resourceId, resourceId2, q9.k.f11122m).a();
        boolean z2 = typedArrayD.getBoolean(l.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayD.getBoolean(l.FloatingActionButton_android_enabled, true));
        typedArrayD.recycle();
        l0 l0Var = new l0(this);
        this.H = l0Var;
        l0Var.s(attributeSet, i);
        b bVar = new b();
        bVar.f5331a = false;
        bVar.f5332b = 0;
        bVar.f5333c = this;
        this.I = bVar;
        getImpl().n(kVarA);
        getImpl().g(this.f3447v, this.f3448w, this.f3451z, dimensionPixelSize);
        getImpl().f6003k = dimensionPixelSize2;
        i impl = getImpl();
        if (impl.f6001h != dimension) {
            impl.f6001h = dimension;
            impl.k(dimension, impl.i, impl.f6002j);
        }
        i impl2 = getImpl();
        if (impl2.i != dimension2) {
            impl2.i = dimension2;
            impl2.k(impl2.f6001h, dimension2, impl2.f6002j);
        }
        i impl3 = getImpl();
        if (impl3.f6002j != dimension3) {
            impl3.f6002j = dimension3;
            impl3.k(impl3.f6001h, impl3.i, dimension3);
        }
        getImpl().f6005m = dVarA;
        getImpl().f6006n = dVarA2;
        getImpl().f = z2;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private i getImpl() {
        if (this.J == null) {
            this.J = new h9.k(this, new rc.b(14, this));
        }
        return this.J;
    }

    public final int c(int i) {
        int i10 = this.B;
        if (i10 != 0) {
            return i10;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(d.design_fab_size_normal) : resources.getDimensionPixelSize(d.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? c(1) : c(0);
    }

    public final void d() {
        i impl = getImpl();
        FloatingActionButton floatingActionButton = impl.f6011s;
        if (floatingActionButton.getVisibility() == 0) {
            if (impl.f6010r == 1) {
                return;
            }
        } else if (impl.f6010r != 2) {
            return;
        }
        Animator animator = impl.f6004l;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton2 = impl.f6011s;
        WeakHashMap weakHashMap = o0.f10475a;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(4, false);
            return;
        }
        q8.d dVar = impl.f6006n;
        AnimatorSet animatorSetB = dVar != null ? impl.b(dVar, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f, i.C, i.D);
        animatorSetB.addListener(new c(impl));
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().j(getDrawableState());
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f3449x;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f3450y;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(t.c(colorForState, mode));
    }

    public final void f() {
        i impl = getImpl();
        FloatingActionButton floatingActionButton = impl.f6011s;
        Matrix matrix = impl.f6016x;
        FloatingActionButton floatingActionButton2 = impl.f6011s;
        int i = 2;
        if (floatingActionButton.getVisibility() != 0) {
            if (impl.f6010r == 2) {
                return;
            }
        } else if (impl.f6010r != 1) {
            return;
        }
        Animator animator = impl.f6004l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = impl.f6005m == null;
        WeakHashMap weakHashMap = o0.f10475a;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(0, false);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.f6008p = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z2 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z2 ? 0.4f : 0.0f);
            float f = z2 ? 0.4f : 0.0f;
            impl.f6008p = f;
            impl.a(f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
        }
        q8.d dVar = impl.f6005m;
        AnimatorSet animatorSetB = dVar != null ? impl.b(dVar, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f, i.A, i.B);
        animatorSetB.addListener(new g5.l(i, impl));
        animatorSetB.start();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f3447v;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f3448w;
    }

    @Override // c0.a
    public c0.b getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f6002j;
    }

    public Drawable getContentBackground() {
        return getImpl().f5999e;
    }

    public int getCustomSize() {
        return this.B;
    }

    public int getExpandedComponentIdHint() {
        return this.I.f5332b;
    }

    public q8.d getHideMotionSpec() {
        return getImpl().f6006n;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f3451z;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f3451z;
    }

    public q9.k getShapeAppearanceModel() {
        q9.k kVar = getImpl().f5995a;
        kVar.getClass();
        return kVar;
    }

    public q8.d getShowMotionSpec() {
        return getImpl().f6005m;
    }

    public int getSize() {
        return this.A;
    }

    public int getSizeDimension() {
        return c(this.A);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f3449x;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f3450y;
    }

    public boolean getUseCompatPadding() {
        return this.E;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().h();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i impl = getImpl();
        FloatingActionButton floatingActionButton = impl.f6011s;
        g gVar = impl.f5996b;
        if (gVar != null) {
            i5.a.N(floatingActionButton, gVar);
        }
        if (impl instanceof h9.k) {
            return;
        }
        ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
        if (impl.f6017y == null) {
            impl.f6017y = new f(1, impl);
        }
        viewTreeObserver.addOnPreDrawListener(impl.f6017y);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f6011s.getViewTreeObserver();
        f fVar = impl.f6017y;
        if (fVar != null) {
            viewTreeObserver.removeOnPreDrawListener(fVar);
            impl.f6017y = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i10) {
        int sizeDimension = getSizeDimension();
        this.C = (sizeDimension - this.D) / 2;
        getImpl().q();
        int iMin = Math.min(View.resolveSize(sizeDimension, i), View.resolveSize(sizeDimension, i10));
        Rect rect = this.F;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof t9.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        t9.a aVar = (t9.a) parcelable;
        super.onRestoreInstanceState(aVar.f14205u);
        Bundle bundle = (Bundle) aVar.f12347w.get("expandableWidgetHelper");
        bundle.getClass();
        b bVar = this.I;
        bVar.getClass();
        bVar.f5331a = bundle.getBoolean("expanded", false);
        bVar.f5332b = bundle.getInt("expandedComponentIdHint", 0);
        if (bVar.f5331a) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) bVar.f5333c;
            ViewParent parent = floatingActionButton.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).i(floatingActionButton);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        t9.a aVar = new t9.a(parcelableOnSaveInstanceState);
        b bVar = this.I;
        bVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", bVar.f5331a);
        bundle.putInt("expandedComponentIdHint", bVar.f5332b);
        aVar.f12347w.put("expandableWidgetHelper", bundle);
        return aVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.G;
            rect.set(0, 0, measuredWidth, measuredHeight);
            int i = rect.left;
            Rect rect2 = this.F;
            rect.left = i + rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
            h9.k kVar = this.J;
            int i10 = -(kVar.f ? Math.max((kVar.f6003k - kVar.f6011s.getSizeDimension()) / 2, 0) : 0);
            rect.inset(i10, i10);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3447v != colorStateList) {
            this.f3447v = colorStateList;
            i impl = getImpl();
            g gVar = impl.f5996b;
            if (gVar != null) {
                gVar.setTintList(colorStateList);
            }
            h9.a aVar = impl.f5998d;
            if (aVar != null) {
                if (colorStateList != null) {
                    aVar.f5971m = colorStateList.getColorForState(aVar.getState(), aVar.f5971m);
                }
                aVar.f5974p = colorStateList;
                aVar.f5972n = true;
                aVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3448w != mode) {
            this.f3448w = mode;
            g gVar = getImpl().f5996b;
            if (gVar != null) {
                gVar.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        i impl = getImpl();
        if (impl.f6001h != f) {
            impl.f6001h = f;
            impl.k(f, impl.i, impl.f6002j);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        i impl = getImpl();
        if (impl.i != f) {
            impl.i = f;
            impl.k(impl.f6001h, f, impl.f6002j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        i impl = getImpl();
        if (impl.f6002j != f) {
            impl.f6002j = f;
            impl.k(impl.f6001h, impl.i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.B) {
            this.B = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        g gVar = getImpl().f5996b;
        if (gVar != null) {
            gVar.k(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().f) {
            getImpl().f = z2;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.I.f5332b = i;
    }

    public void setHideMotionSpec(q8.d dVar) {
        getImpl().f6006n = dVar;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(q8.d.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            i impl = getImpl();
            float f = impl.f6008p;
            impl.f6008p = f;
            Matrix matrix = impl.f6016x;
            impl.a(f, matrix);
            impl.f6011s.setImageMatrix(matrix);
            if (this.f3449x != null) {
                e();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.H.w(i);
        e();
    }

    public void setMaxImageSize(int i) {
        this.D = i;
        i impl = getImpl();
        if (impl.f6009q != i) {
            impl.f6009q = i;
            float f = impl.f6008p;
            impl.f6008p = f;
            Matrix matrix = impl.f6016x;
            impl.a(f, matrix);
            impl.f6011s.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().getClass();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().getClass();
    }

    public void setShadowPaddingEnabled(boolean z2) {
        i impl = getImpl();
        impl.f6000g = z2;
        impl.q();
    }

    @Override // q9.u
    public void setShapeAppearanceModel(q9.k kVar) {
        getImpl().n(kVar);
    }

    public void setShowMotionSpec(q8.d dVar) {
        getImpl().f6005m = dVar;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(q8.d.b(getContext(), i));
    }

    public void setSize(int i) {
        this.B = 0;
        if (i != this.A) {
            this.A = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f3449x != colorStateList) {
            this.f3449x = colorStateList;
            e();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f3450y != mode) {
            this.f3450y = mode;
            e();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            getImpl().i();
        }
    }

    @Override // j9.k0, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static class BaseBehavior<T extends FloatingActionButton> extends c0.b {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Rect f3452u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f3453v;

        public BaseBehavior() {
            this.f3453v = true;
        }

        @Override // c0.b
        public final boolean e(Rect rect, View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.F;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // c0.b
        public final void g(e eVar) {
            if (eVar.f2215h == 0) {
                eVar.f2215h = 80;
            }
        }

        @Override // c0.b
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof e ? ((e) layoutParams).f2209a instanceof BottomSheetBehavior : false) {
                    x(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // c0.b
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListK = coordinatorLayout.k(floatingActionButton);
            int size = arrayListK.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = (View) arrayListK.get(i11);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof e ? ((e) layoutParams).f2209a instanceof BottomSheetBehavior : false) && x(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.r(floatingActionButton, i);
            Rect rect = floatingActionButton.F;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                e eVar = (e) floatingActionButton.getLayoutParams();
                int i12 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) eVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) eVar).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) {
                    i10 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) eVar).topMargin) {
                    i10 = -rect.top;
                }
                if (i10 != 0) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    floatingActionButton.offsetTopAndBottom(i10);
                }
                if (i12 != 0) {
                    WeakHashMap weakHashMap2 = o0.f10475a;
                    floatingActionButton.offsetLeftAndRight(i12);
                }
            }
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            e eVar = (e) floatingActionButton.getLayoutParams();
            if (!this.f3453v || eVar.f != appBarLayout.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f3452u == null) {
                this.f3452u = new Rect();
            }
            Rect rect = this.f3452u;
            j9.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public final boolean x(View view, FloatingActionButton floatingActionButton) {
            e eVar = (e) floatingActionButton.getLayoutParams();
            if (!this.f3453v || eVar.f != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((e) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.FloatingActionButton_Behavior_Layout);
            this.f3453v = typedArrayObtainStyledAttributes.getBoolean(l.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f3451z != colorStateList) {
            this.f3451z = colorStateList;
            getImpl().m(this.f3451z);
        }
    }
}
