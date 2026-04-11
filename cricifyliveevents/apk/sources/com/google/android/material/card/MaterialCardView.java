package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.e;
import com.bumptech.glide.f;
import com.google.android.gms.internal.measurement.j4;
import da.d0;
import k9.b;
import k9.k;
import k9.l;
import ka.g;
import ka.i;
import ka.m;
import ka.w;
import ra.a;
import s9.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, w {
    public static final int[] G = {R.attr.state_checkable};
    public static final int[] H = {R.attr.state_checked};
    public static final int[] I = {b.state_dragged};
    public static final int J = k.Widget_MaterialComponents_CardView;
    public final c C;
    public final boolean D;
    public boolean E;
    public boolean F;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MaterialCardView(Context context, AttributeSet attributeSet) {
        int i = b.materialCardViewStyle;
        int i10 = J;
        super(a.a(context, attributeSet, i, i10), attributeSet, i);
        this.E = false;
        this.F = false;
        this.D = true;
        TypedArray typedArrayD = d0.d(getContext(), attributeSet, l.MaterialCardView, i, i10, new int[0]);
        c cVar = new c(this, attributeSet, i);
        this.C = cVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        i iVar = cVar.f11626c;
        iVar.q(cardBackgroundColor);
        cVar.f11625b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        cVar.l();
        MaterialCardView materialCardView = cVar.f11624a;
        ColorStateList colorStateListI = com.bumptech.glide.c.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_strokeColor);
        cVar.f11635n = colorStateListI;
        if (colorStateListI == null) {
            cVar.f11635n = ColorStateList.valueOf(-1);
        }
        cVar.f11630h = typedArrayD.getDimensionPixelSize(l.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArrayD.getBoolean(l.MaterialCardView_android_checkable, false);
        cVar.f11640s = z10;
        materialCardView.setLongClickable(z10);
        cVar.f11633l = com.bumptech.glide.c.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_checkedIconTint);
        cVar.g(com.bumptech.glide.c.l(materialCardView.getContext(), typedArrayD, l.MaterialCardView_checkedIcon));
        cVar.f = typedArrayD.getDimensionPixelSize(l.MaterialCardView_checkedIconSize, 0);
        cVar.f11628e = typedArrayD.getDimensionPixelSize(l.MaterialCardView_checkedIconMargin, 0);
        cVar.f11629g = typedArrayD.getInteger(l.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListI2 = com.bumptech.glide.c.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_rippleColor);
        cVar.f11632k = colorStateListI2;
        if (colorStateListI2 == null) {
            cVar.f11632k = ColorStateList.valueOf(f.n(materialCardView, g.a.colorControlHighlight));
        }
        ColorStateList colorStateListI3 = com.bumptech.glide.c.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_cardForegroundColor);
        colorStateListI3 = colorStateListI3 == null ? ColorStateList.valueOf(0) : colorStateListI3;
        i iVar2 = cVar.f11627d;
        iVar2.q(colorStateListI3);
        RippleDrawable rippleDrawable = cVar.f11636o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(cVar.f11632k);
        }
        iVar.p(materialCardView.getCardElevation());
        float f = cVar.f11630h;
        ColorStateList colorStateList = cVar.f11635n;
        iVar2.f7334w.f7324k = f;
        iVar2.invalidateSelf();
        g gVar = iVar2.f7334w;
        if (gVar.f7320e != colorStateList) {
            gVar.f7320e = colorStateList;
            iVar2.onStateChange(iVar2.getState());
        }
        materialCardView.setBackgroundInternal(cVar.d(iVar));
        Drawable drawableC = cVar.j() ? cVar.c() : iVar2;
        cVar.i = drawableC;
        materialCardView.setForeground(cVar.d(drawableC));
        typedArrayD.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.C.f11626c.getBounds());
        return rectF;
    }

    public final void b() {
        c cVar;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (cVar = this.C).f11636o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i = bounds.bottom;
        cVar.f11636o.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        cVar.f11636o.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.C.f11626c.f7334w.f7319d;
    }

    public ColorStateList getCardForegroundColor() {
        return this.C.f11627d.f7334w.f7319d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.C.f11631j;
    }

    public int getCheckedIconGravity() {
        return this.C.f11629g;
    }

    public int getCheckedIconMargin() {
        return this.C.f11628e;
    }

    public int getCheckedIconSize() {
        return this.C.f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.C.f11633l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.C.f11625b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.C.f11625b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.C.f11625b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.C.f11625b.top;
    }

    public float getProgress() {
        return this.C.f11626c.f7334w.f7323j;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.C.f11626c.k();
    }

    public ColorStateList getRippleColor() {
        return this.C.f11632k;
    }

    public m getShapeAppearanceModel() {
        return this.C.f11634m;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.C.f11635n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.C.f11635n;
    }

    public int getStrokeWidth() {
        return this.C.f11630h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.C;
        cVar.k();
        e.p(this, cVar.f11626c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        c cVar = this.C;
        if (cVar != null && cVar.f11640s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, G);
        }
        if (this.E) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        if (this.F) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, I);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.E);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        c cVar = this.C;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f11640s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.E);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        this.C.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.D) {
            c cVar = this.C;
            if (!cVar.f11639r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                cVar.f11639r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.C.f11626c.q(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        c cVar = this.C;
        cVar.f11626c.p(cVar.f11624a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        i iVar = this.C.f11627d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        iVar.q(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.C.f11640s = z10;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.E != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.C.g(drawable);
    }

    public void setCheckedIconGravity(int i) {
        c cVar = this.C;
        if (cVar.f11629g != i) {
            cVar.f11629g = i;
            MaterialCardView materialCardView = cVar.f11624a;
            cVar.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i) {
        this.C.f11628e = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.C.f11628e = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.C.g(j4.i(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.C.f = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.C.f = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c cVar = this.C;
        cVar.f11633l = colorStateList;
        Drawable drawable = cVar.f11631j;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        c cVar = this.C;
        if (cVar != null) {
            cVar.k();
        }
    }

    public void setDragged(boolean z10) {
        if (this.F != z10) {
            this.F = z10;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.C.m();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        c cVar = this.C;
        cVar.m();
        cVar.l();
    }

    public void setProgress(float f) {
        c cVar = this.C;
        cVar.f11626c.r(f);
        i iVar = cVar.f11627d;
        if (iVar != null) {
            iVar.r(f);
        }
        i iVar2 = cVar.f11638q;
        if (iVar2 != null) {
            iVar2.r(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        c cVar = this.C;
        ka.l lVarG = cVar.f11634m.g();
        lVarG.b(f);
        cVar.h(lVarG.a());
        cVar.i.invalidateSelf();
        if (cVar.i() || (cVar.f11624a.getPreventCornerOverlap() && !cVar.f11626c.n())) {
            cVar.l();
        }
        if (cVar.i()) {
            cVar.m();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.C;
        cVar.f11632k = colorStateList;
        RippleDrawable rippleDrawable = cVar.f11636o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        ColorStateList colorStateListC = i0.c.c(getContext(), i);
        c cVar = this.C;
        cVar.f11632k = colorStateListC;
        RippleDrawable rippleDrawable = cVar.f11636o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateListC);
        }
    }

    @Override // ka.w
    public void setShapeAppearanceModel(m mVar) {
        setClipToOutline(mVar.f(getBoundsAsRectF()));
        this.C.h(mVar);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        c cVar = this.C;
        if (i != cVar.f11630h) {
            cVar.f11630h = i;
            i iVar = cVar.f11627d;
            ColorStateList colorStateList = cVar.f11635n;
            iVar.f7334w.f7324k = i;
            iVar.invalidateSelf();
            g gVar = iVar.f7334w;
            if (gVar.f7320e != colorStateList) {
                gVar.f7320e = colorStateList;
                iVar.onStateChange(iVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        c cVar = this.C;
        cVar.m();
        cVar.l();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        c cVar = this.C;
        if (cVar != null && cVar.f11640s && isEnabled()) {
            this.E = !this.E;
            refreshDrawableState();
            b();
            cVar.f(this.E, true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c cVar = this.C;
        if (cVar.f11635n != colorStateList) {
            cVar.f11635n = colorStateList;
            i iVar = cVar.f11627d;
            iVar.f7334w.f7324k = cVar.f11630h;
            iVar.invalidateSelf();
            g gVar = iVar.f7334w;
            if (gVar.f7320e != colorStateList) {
                gVar.f7320e = colorStateList;
                iVar.onStateChange(iVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.C.f11626c.q(colorStateList);
    }

    public void setOnCheckedChangeListener(s9.a aVar) {
    }
}
