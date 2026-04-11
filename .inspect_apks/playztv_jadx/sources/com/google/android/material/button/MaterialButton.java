package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import com.bumptech.glide.d;
import j9.e0;
import j9.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p8.b;
import p8.k;
import p8.l;
import q0.e;
import q0.o0;
import q9.j;
import q9.u;
import x8.a;
import x8.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, u {
    public static final int[] L = {R.attr.state_checkable};
    public static final int[] M = {R.attr.state_checked};
    public static final int N = k.Widget_MaterialComponents_Button;
    public PorterDuff.Mode A;
    public ColorStateList B;
    public Drawable C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public boolean J;
    public int K;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f3366x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LinkedHashSet f3367y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f3368z;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        int i = b.materialButtonStyle;
        int i10 = N;
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f3367y = new LinkedHashSet();
        this.I = false;
        this.J = false;
        Context context2 = getContext();
        TypedArray typedArrayD = e0.d(context2, attributeSet, l.MaterialButton, i, i10, new int[0]);
        this.H = typedArrayD.getDimensionPixelSize(l.MaterialButton_iconPadding, 0);
        int i11 = typedArrayD.getInt(l.MaterialButton_iconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.A = f0.e(i11, mode);
        this.B = a.a.i(getContext(), typedArrayD, l.MaterialButton_iconTint);
        this.C = a.a.m(getContext(), typedArrayD, l.MaterialButton_icon);
        this.K = typedArrayD.getInteger(l.MaterialButton_iconGravity, 1);
        this.E = typedArrayD.getDimensionPixelSize(l.MaterialButton_iconSize, 0);
        c cVar = new c(this, q9.k.c(context2, attributeSet, i, i10).a());
        this.f3366x = cVar;
        cVar.f14309c = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetLeft, 0);
        cVar.f14310d = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetRight, 0);
        cVar.f14311e = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetTop, 0);
        cVar.f = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetBottom, 0);
        if (typedArrayD.hasValue(l.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(l.MaterialButton_cornerRadius, -1);
            cVar.f14312g = dimensionPixelSize;
            j jVarF = cVar.f14308b.f();
            jVarF.b(dimensionPixelSize);
            cVar.c(jVarF.a());
            cVar.f14320p = true;
        }
        cVar.f14313h = typedArrayD.getDimensionPixelSize(l.MaterialButton_strokeWidth, 0);
        cVar.i = f0.e(typedArrayD.getInt(l.MaterialButton_backgroundTintMode, -1), mode);
        cVar.f14314j = a.a.i(getContext(), typedArrayD, l.MaterialButton_backgroundTint);
        cVar.f14315k = a.a.i(getContext(), typedArrayD, l.MaterialButton_strokeColor);
        cVar.f14316l = a.a.i(getContext(), typedArrayD, l.MaterialButton_rippleColor);
        cVar.f14321q = typedArrayD.getBoolean(l.MaterialButton_android_checkable, false);
        cVar.f14324t = typedArrayD.getDimensionPixelSize(l.MaterialButton_elevation, 0);
        cVar.f14322r = typedArrayD.getBoolean(l.MaterialButton_toggleCheckedStateOnClick, true);
        WeakHashMap weakHashMap = o0.f10475a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(l.MaterialButton_android_background)) {
            cVar.f14319o = true;
            setSupportBackgroundTintList(cVar.f14314j);
            setSupportBackgroundTintMode(cVar.i);
        } else {
            cVar.e();
        }
        setPaddingRelative(paddingStart + cVar.f14309c, paddingTop + cVar.f14311e, paddingEnd + cVar.f14310d, paddingBottom + cVar.f);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.H);
        c(this.C != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    public final boolean a() {
        c cVar = this.f3366x;
        return (cVar == null || cVar.f14319o) ? false : true;
    }

    public final void b() {
        int i = this.K;
        if (i == 1 || i == 2) {
            setCompoundDrawablesRelative(this.C, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.C, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.C, null, null);
        }
    }

    public final void c(boolean z2) {
        Drawable drawable = this.C;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.C = drawableMutate;
            drawableMutate.setTintList(this.B);
            PorterDuff.Mode mode = this.A;
            if (mode != null) {
                this.C.setTintMode(mode);
            }
            int intrinsicWidth = this.E;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.C.getIntrinsicWidth();
            }
            int intrinsicHeight = this.E;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.C.getIntrinsicHeight();
            }
            Drawable drawable2 = this.C;
            int i = this.F;
            int i10 = this.G;
            drawable2.setBounds(i, i10, intrinsicWidth + i, intrinsicHeight + i10);
            this.C.setVisible(true, z2);
        }
        if (z2) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i11 = this.K;
        if (((i11 == 1 || i11 == 2) && drawable3 != this.C) || (((i11 == 3 || i11 == 4) && drawable5 != this.C) || ((i11 == 16 || i11 == 32) && drawable4 != this.C))) {
            b();
        }
    }

    public final void d(int i, int i10) {
        if (this.C == null || getLayout() == null) {
            return;
        }
        int i11 = this.K;
        if (i11 != 1 && i11 != 2 && i11 != 3 && i11 != 4) {
            if (i11 == 16 || i11 == 32) {
                this.F = 0;
                if (i11 == 16) {
                    this.G = 0;
                    c(false);
                    return;
                }
                int intrinsicHeight = this.E;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.C.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i10 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.H) - getPaddingBottom()) / 2);
                if (this.G != iMax) {
                    this.G = iMax;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.G = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.K;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.F = 0;
            c(false);
            return;
        }
        int intrinsicWidth = this.E;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.C.getIntrinsicWidth();
        }
        int textLayoutWidth = i - getTextLayoutWidth();
        WeakHashMap weakHashMap = o0.f10475a;
        int paddingEnd = (((textLayoutWidth - getPaddingEnd()) - intrinsicWidth) - this.H) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.K == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.F != paddingEnd) {
            this.F = paddingEnd;
            c(false);
        }
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.D)) {
            return this.D;
        }
        c cVar = this.f3366x;
        return ((cVar == null || !cVar.f14321q) ? Button.class : CompoundButton.class).getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f3366x.f14312g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.C;
    }

    public int getIconGravity() {
        return this.K;
    }

    public int getIconPadding() {
        return this.H;
    }

    public int getIconSize() {
        return this.E;
    }

    public ColorStateList getIconTint() {
        return this.B;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.A;
    }

    public int getInsetBottom() {
        return this.f3366x.f;
    }

    public int getInsetTop() {
        return this.f3366x.f14311e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f3366x.f14316l;
        }
        return null;
    }

    public q9.k getShapeAppearanceModel() {
        if (a()) {
            return this.f3366x.f14308b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f3366x.f14315k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f3366x.f14313h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f3366x.f14314j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f3366x.i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.I;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            i5.a.N(this, this.f3366x.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        c cVar = this.f3366x;
        if (cVar != null && cVar.f14321q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, L);
        }
        if (this.I) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, M);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.I);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        c cVar = this.f3366x;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f14321q);
        accessibilityNodeInfo.setChecked(this.I);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x8.b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x8.b bVar = (x8.b) parcelable;
        super.onRestoreInstanceState(bVar.f14205u);
        setChecked(bVar.f14306w);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        x8.b bVar = new x8.b(super.onSaveInstanceState());
        bVar.f14306w = this.I;
        return bVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        super.onTextChanged(charSequence, i, i10, i11);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f3366x.f14322r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.C != null) {
            if (this.C.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.D = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!a()) {
            super.setBackgroundColor(i);
            return;
        }
        c cVar = this.f3366x;
        if (cVar.b(false) != null) {
            cVar.b(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        c cVar = this.f3366x;
        cVar.f14319o = true;
        MaterialButton materialButton = cVar.f14307a;
        materialButton.setSupportBackgroundTintList(cVar.f14314j);
        materialButton.setSupportBackgroundTintMode(cVar.i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? d.p(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (a()) {
            this.f3366x.f14321q = z2;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        c cVar = this.f3366x;
        if (cVar == null || !cVar.f14321q || !isEnabled() || this.I == z2) {
            return;
        }
        this.I = z2;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z10 = this.I;
            if (!materialButtonToggleGroup.f3374z) {
                materialButtonToggleGroup.b(getId(), z10);
            }
        }
        if (this.J) {
            return;
        }
        this.J = true;
        Iterator it = this.f3367y.iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
        this.J = false;
    }

    public void setCornerRadius(int i) {
        if (a()) {
            c cVar = this.f3366x;
            if (cVar.f14320p && cVar.f14312g == i) {
                return;
            }
            cVar.f14312g = i;
            cVar.f14320p = true;
            j jVarF = cVar.f14308b.f();
            jVarF.b(i);
            cVar.c(jVarF.a());
        }
    }

    public void setCornerRadiusResource(int i) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (a()) {
            this.f3366x.b(false).k(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.C != drawable) {
            this.C = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.K != i) {
            this.K = i;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.H != i) {
            this.H = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? d.p(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.E != i) {
            this.E = i;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.A != mode) {
            this.A = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(f0.c.c(getContext(), i));
    }

    public void setInsetBottom(int i) {
        c cVar = this.f3366x;
        cVar.d(cVar.f14311e, i);
    }

    public void setInsetTop(int i) {
        c cVar = this.f3366x;
        cVar.d(i, cVar.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(a aVar) {
        this.f3368z = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        a aVar = this.f3368z;
        if (aVar != null) {
            ((MaterialButtonToggleGroup) ((e) aVar).f10436v).invalidate();
        }
        super.setPressed(z2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            c cVar = this.f3366x;
            MaterialButton materialButton = cVar.f14307a;
            if (cVar.f14316l != colorStateList) {
                cVar.f14316l = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(o9.a.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (a()) {
            setRippleColor(f0.c.c(getContext(), i));
        }
    }

    @Override // q9.u
    public void setShapeAppearanceModel(q9.k kVar) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f3366x.c(kVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (a()) {
            c cVar = this.f3366x;
            cVar.f14318n = z2;
            cVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            c cVar = this.f3366x;
            if (cVar.f14315k != colorStateList) {
                cVar.f14315k = colorStateList;
                cVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (a()) {
            setStrokeColor(f0.c.c(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (a()) {
            c cVar = this.f3366x;
            if (cVar.f14313h != i) {
                cVar.f14313h = i;
                cVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        c cVar = this.f3366x;
        if (cVar.f14314j != colorStateList) {
            cVar.f14314j = colorStateList;
            if (cVar.b(false) != null) {
                cVar.b(false).setTintList(cVar.f14314j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        c cVar = this.f3366x;
        if (cVar.i != mode) {
            cVar.i = mode;
            if (cVar.b(false) == null || cVar.i == null) {
                return;
            }
            cVar.b(false).setTintMode(cVar.i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z2) {
        this.f3366x.f14322r = z2;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.I);
    }
}
