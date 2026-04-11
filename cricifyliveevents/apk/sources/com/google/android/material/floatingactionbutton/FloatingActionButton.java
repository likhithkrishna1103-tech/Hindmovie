package com.google.android.material.floatingactionbutton;

import aa.a;
import aa.b;
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
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ba.e;
import ba.f;
import ba.i;
import ba.j;
import com.bumptech.glide.c;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import da.d0;
import da.e0;
import da.h0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k9.d;
import k9.k;
import k9.l;
import ka.m;
import ka.w;
import o.r;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends h0 implements a, w, f0.a {
    public static final int L = k.Widget_Design_FloatingActionButton;
    public ColorStateList A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public final Rect G;
    public final Rect H;
    public final f3.a I;
    public final b J;
    public j K;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ColorStateList f2911w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PorterDuff.Mode f2912x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f2913y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PorterDuff.Mode f2914z;

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateList;
        Drawable drawable;
        Drawable layerDrawable;
        int i = k9.b.floatingActionButtonStyle;
        int i10 = L;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f3619v = getVisibility();
        this.G = new Rect();
        this.H = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = d0.d(context2, attributeSet, l.FloatingActionButton, i, i10, new int[0]);
        this.f2911w = c.i(context2, typedArrayD, l.FloatingActionButton_backgroundTint);
        this.f2912x = e0.c(typedArrayD.getInt(l.FloatingActionButton_backgroundTintMode, -1), null);
        this.A = c.i(context2, typedArrayD, l.FloatingActionButton_rippleColor);
        this.B = typedArrayD.getInt(l.FloatingActionButton_fabSize, -1);
        this.C = typedArrayD.getDimensionPixelSize(l.FloatingActionButton_fabCustomSize, 0);
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(l.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayD.getDimension(l.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayD.getDimension(l.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayD.getDimension(l.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.F = typedArrayD.getBoolean(l.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayD.getDimensionPixelSize(l.FloatingActionButton_maxImageSize, 0));
        l9.d dVarA = l9.d.a(context2, typedArrayD, l.FloatingActionButton_showMotionSpec);
        l9.d dVarA2 = l9.d.a(context2, typedArrayD, l.FloatingActionButton_hideMotionSpec);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.MaterialShape, i, i10);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        m mVarA = m.b(context2, resourceId, resourceId2, m.f7349m).a();
        boolean z10 = typedArrayD.getBoolean(l.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayD.getBoolean(l.FloatingActionButton_android_enabled, true));
        typedArrayD.recycle();
        f3.a aVar = new f3.a(this);
        this.I = aVar;
        aVar.r(attributeSet, i);
        b bVar = new b();
        bVar.f374a = false;
        bVar.f375b = 0;
        bVar.f376c = this;
        this.J = bVar;
        getImpl().g(mVarA);
        j impl = getImpl();
        ColorStateList colorStateList2 = this.f2911w;
        PorterDuff.Mode mode = this.f2912x;
        ColorStateList colorStateList3 = this.A;
        FloatingActionButton floatingActionButton = impl.f1892s;
        m mVar = impl.f1876a;
        mVar.getClass();
        i iVar = new i(mVar);
        impl.f1877b = iVar;
        iVar.setTintList(colorStateList2);
        if (mode != null) {
            impl.f1877b.setTintMode(mode);
        }
        impl.f1877b.m(floatingActionButton.getContext());
        if (dimensionPixelSize > 0) {
            Context context3 = floatingActionButton.getContext();
            m mVar2 = impl.f1876a;
            mVar2.getClass();
            ba.b bVar2 = new ba.b(mVar2);
            int color = context3.getColor(k9.c.design_fab_stroke_top_outer_color);
            int color2 = context3.getColor(k9.c.design_fab_stroke_top_inner_color);
            colorStateList = colorStateList3;
            int color3 = context3.getColor(k9.c.design_fab_stroke_end_inner_color);
            int color4 = context3.getColor(k9.c.design_fab_stroke_end_outer_color);
            bVar2.i = color;
            bVar2.f1849j = color2;
            bVar2.f1850k = color3;
            bVar2.f1851l = color4;
            float f = dimensionPixelSize;
            if (bVar2.f1848h != f) {
                bVar2.f1848h = f;
                bVar2.f1843b.setStrokeWidth(f * 1.3333f);
                bVar2.f1853n = true;
                bVar2.invalidateSelf();
            }
            if (colorStateList2 != null) {
                bVar2.f1852m = colorStateList2.getColorForState(bVar2.getState(), bVar2.f1852m);
            }
            bVar2.f1855p = colorStateList2;
            bVar2.f1853n = true;
            bVar2.invalidateSelf();
            impl.f1879d = bVar2;
            ba.b bVar3 = impl.f1879d;
            bVar3.getClass();
            i iVar2 = impl.f1877b;
            iVar2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{bVar3, iVar2});
            drawable = null;
        } else {
            colorStateList = colorStateList3;
            drawable = null;
            impl.f1879d = null;
            layerDrawable = impl.f1877b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(ia.a.b(colorStateList), layerDrawable, drawable);
        impl.f1878c = rippleDrawable;
        impl.f1880e = rippleDrawable;
        getImpl().f1884k = dimensionPixelSize2;
        j impl2 = getImpl();
        if (impl2.f1882h != dimension) {
            impl2.f1882h = dimension;
            impl2.e(dimension, impl2.i, impl2.f1883j);
        }
        j impl3 = getImpl();
        if (impl3.i != dimension2) {
            impl3.i = dimension2;
            impl3.e(impl3.f1882h, dimension2, impl3.f1883j);
        }
        j impl4 = getImpl();
        if (impl4.f1883j != dimension3) {
            impl4.f1883j = dimension3;
            impl4.e(impl4.f1882h, impl4.i, dimension3);
        }
        getImpl().f1887n = dVarA;
        getImpl().f1888o = dVarA2;
        getImpl().f = z10;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private j getImpl() {
        if (this.K == null) {
            this.K = new j(this, new pc.c(this));
        }
        return this.K;
    }

    public final int c(int i) {
        int i10 = this.C;
        if (i10 != 0) {
            return i10;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(d.design_fab_size_normal) : resources.getDimensionPixelSize(d.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? c(1) : c(0);
    }

    public final void d() {
        j impl = getImpl();
        FloatingActionButton floatingActionButton = impl.f1892s;
        if (floatingActionButton.getVisibility() == 0) {
            if (impl.f1891r == 1) {
                return;
            }
        } else if (impl.f1891r != 2) {
            return;
        }
        Animator animator = impl.f1886m;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton2 = impl.f1892s;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(4, false);
            return;
        }
        l9.d dVar = impl.f1888o;
        AnimatorSet animatorSetB = dVar != null ? impl.b(dVar, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f, j.B, j.C);
        animatorSetB.addListener(new e(impl));
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f2913y;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f2914z;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(r.c(colorForState, mode));
    }

    public final void f() {
        j impl = getImpl();
        FloatingActionButton floatingActionButton = impl.f1892s;
        Matrix matrix = impl.f1897x;
        FloatingActionButton floatingActionButton2 = impl.f1892s;
        if (floatingActionButton.getVisibility() != 0) {
            if (impl.f1891r == 2) {
                return;
            }
        } else if (impl.f1891r != 1) {
            return;
        }
        Animator animator = impl.f1886m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z10 = impl.f1887n == null;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(0, false);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.f1889p = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z10 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z10 ? 0.4f : 0.0f);
            float f = z10 ? 0.4f : 0.0f;
            impl.f1889p = f;
            impl.a(f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
        }
        l9.d dVar = impl.f1887n;
        AnimatorSet animatorSetB = dVar != null ? impl.b(dVar, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f, j.f1875z, j.A);
        animatorSetB.addListener(new f(0, impl));
        animatorSetB.start();
    }

    @Override // android.widget.ImageButton, android.widget.ImageView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f2911w;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2912x;
    }

    @Override // f0.a
    public f0.b getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().f1892s.getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f1883j;
    }

    public Drawable getContentBackground() {
        return getImpl().f1880e;
    }

    public int getCustomSize() {
        return this.C;
    }

    public int getExpandedComponentIdHint() {
        return this.J.f375b;
    }

    public l9.d getHideMotionSpec() {
        return getImpl().f1888o;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.A;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.A;
    }

    public m getShapeAppearanceModel() {
        m mVar = getImpl().f1876a;
        mVar.getClass();
        return mVar;
    }

    public l9.d getShowMotionSpec() {
        return getImpl().f1887n;
    }

    public int getSize() {
        return this.B;
    }

    public int getSizeDimension() {
        return c(this.B);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f2913y;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f2914z;
    }

    public boolean getUseCompatPadding() {
        return this.F;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j impl = getImpl();
        i iVar = impl.f1877b;
        if (iVar != null) {
            com.bumptech.glide.e.p(impl.f1892s, iVar);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().f1892s.getViewTreeObserver();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i10) {
        int sizeDimension = getSizeDimension();
        this.D = (sizeDimension - this.E) / 2;
        getImpl().h();
        int iMin = Math.min(View.resolveSize(sizeDimension, i), View.resolveSize(sizeDimension, i10));
        Rect rect = this.G;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof na.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        na.a aVar = (na.a) parcelable;
        super.onRestoreInstanceState(aVar.f112v);
        Bundle bundle = (Bundle) aVar.f8921x.get("expandableWidgetHelper");
        bundle.getClass();
        b bVar = this.J;
        bVar.getClass();
        bVar.f374a = bundle.getBoolean("expanded", false);
        bVar.f375b = bundle.getInt("expandedComponentIdHint", 0);
        if (bVar.f374a) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) bVar.f376c;
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
        na.a aVar = new na.a(parcelableOnSaveInstanceState);
        b bVar = this.J;
        bVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", bVar.f374a);
        bundle.putInt("expandedComponentIdHint", bVar.f375b);
        aVar.f8921x.put("expandableWidgetHelper", bundle);
        return aVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.H;
            rect.set(0, 0, measuredWidth, measuredHeight);
            int i = rect.left;
            Rect rect2 = this.G;
            rect.left = i + rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
            j jVar = this.K;
            int i10 = -(jVar.f ? Math.max((jVar.f1884k - jVar.f1892s.getSizeDimension()) / 2, 0) : 0);
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
        if (this.f2911w != colorStateList) {
            this.f2911w = colorStateList;
            j impl = getImpl();
            i iVar = impl.f1877b;
            if (iVar != null) {
                iVar.setTintList(colorStateList);
            }
            ba.b bVar = impl.f1879d;
            if (bVar != null) {
                if (colorStateList != null) {
                    bVar.f1852m = colorStateList.getColorForState(bVar.getState(), bVar.f1852m);
                }
                bVar.f1855p = colorStateList;
                bVar.f1853n = true;
                bVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2912x != mode) {
            this.f2912x = mode;
            i iVar = getImpl().f1877b;
            if (iVar != null) {
                iVar.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        j impl = getImpl();
        if (impl.f1882h != f) {
            impl.f1882h = f;
            impl.e(f, impl.i, impl.f1883j);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        j impl = getImpl();
        if (impl.i != f) {
            impl.i = f;
            impl.e(impl.f1882h, f, impl.f1883j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        j impl = getImpl();
        if (impl.f1883j != f) {
            impl.f1883j = f;
            impl.e(impl.f1882h, impl.i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.C) {
            this.C = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i iVar = getImpl().f1877b;
        if (iVar != null) {
            iVar.p(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().f) {
            getImpl().f = z10;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.J.f375b = i;
    }

    public void setHideMotionSpec(l9.d dVar) {
        getImpl().f1888o = dVar;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(l9.d.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            j impl = getImpl();
            float f = impl.f1889p;
            impl.f1889p = f;
            Matrix matrix = impl.f1897x;
            impl.a(f, matrix);
            impl.f1892s.setImageMatrix(matrix);
            if (this.f2913y != null) {
                e();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.I.x(i);
        e();
    }

    public void setMaxImageSize(int i) {
        this.E = i;
        j impl = getImpl();
        if (impl.f1890q != i) {
            impl.f1890q = i;
            float f = impl.f1889p;
            impl.f1889p = f;
            Matrix matrix = impl.f1897x;
            impl.a(f, matrix);
            impl.f1892s.setImageMatrix(matrix);
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

    public void setShadowPaddingEnabled(boolean z10) {
        j impl = getImpl();
        impl.f1881g = z10;
        impl.h();
    }

    @Override // ka.w
    public void setShapeAppearanceModel(m mVar) {
        getImpl().g(mVar);
    }

    public void setShowMotionSpec(l9.d dVar) {
        getImpl().f1887n = dVar;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(l9.d.b(getContext(), i));
    }

    public void setSize(int i) {
        this.C = 0;
        if (i != this.B) {
            this.B = i;
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
        if (this.f2913y != colorStateList) {
            this.f2913y = colorStateList;
            e();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f2914z != mode) {
            this.f2914z = mode;
            e();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().f();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().f();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().f();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.F != z10) {
            this.F = z10;
            getImpl().h();
        }
    }

    @Override // da.h0, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static class BaseBehavior<T extends FloatingActionButton> extends f0.b {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Rect f2915v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f2916w;

        public BaseBehavior() {
            this.f2916w = true;
        }

        @Override // f0.b
        public final boolean e(Rect rect, View view) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.G;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // f0.b
        public final void g(f0.e eVar) {
            if (eVar.f3903h == 0) {
                eVar.f3903h = 80;
            }
        }

        @Override // f0.b
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof f0.e ? ((f0.e) layoutParams).f3897a instanceof BottomSheetBehavior : false) {
                    x(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // f0.b
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListK = coordinatorLayout.k(floatingActionButton);
            int size = arrayListK.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = (View) arrayListK.get(i11);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof f0.e ? ((f0.e) layoutParams).f3897a instanceof BottomSheetBehavior : false) && x(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.r(floatingActionButton, i);
            Rect rect = floatingActionButton.G;
            if (rect.centerX() > 0 && rect.centerY() > 0) {
                f0.e eVar = (f0.e) floatingActionButton.getLayoutParams();
                int i12 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) eVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) eVar).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) {
                    i10 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) eVar).topMargin) {
                    i10 = -rect.top;
                }
                if (i10 != 0) {
                    WeakHashMap weakHashMap = m0.f11777a;
                    floatingActionButton.offsetTopAndBottom(i10);
                }
                if (i12 != 0) {
                    WeakHashMap weakHashMap2 = m0.f11777a;
                    floatingActionButton.offsetLeftAndRight(i12);
                }
            }
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            f0.e eVar = (f0.e) floatingActionButton.getLayoutParams();
            if (!this.f2916w || eVar.f != appBarLayout.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f2915v == null) {
                this.f2915v = new Rect();
            }
            Rect rect = this.f2915v;
            da.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public final boolean x(View view, FloatingActionButton floatingActionButton) {
            f0.e eVar = (f0.e) floatingActionButton.getLayoutParams();
            if (!this.f2916w || eVar.f != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((f0.e) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.d();
                return true;
            }
            floatingActionButton.f();
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.FloatingActionButton_Behavior_Layout);
            this.f2916w = typedArrayObtainStyledAttributes.getBoolean(l.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            j impl = getImpl();
            ColorStateList colorStateList2 = this.A;
            RippleDrawable rippleDrawable = impl.f1878c;
            if (rippleDrawable != null) {
                rippleDrawable.setColor(ia.a.b(colorStateList2));
            } else if (rippleDrawable != null) {
                rippleDrawable.setTintList(ia.a.b(colorStateList2));
            }
        }
    }
}
