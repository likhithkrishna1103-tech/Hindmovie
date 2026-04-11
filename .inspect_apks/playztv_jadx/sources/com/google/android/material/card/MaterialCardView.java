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
import com.bumptech.glide.d;
import j9.e0;
import p8.b;
import p8.k;
import p8.l;
import q9.f;
import q9.g;
import q9.u;
import x9.a;
import y8.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, u {
    public static final int[] F = {R.attr.state_checkable};
    public static final int[] G = {R.attr.state_checked};
    public static final int[] H = {b.state_dragged};
    public static final int I = k.Widget_MaterialComponents_CardView;
    public final c B;
    public final boolean C;
    public boolean D;
    public boolean E;

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
        int i10 = I;
        super(a.a(context, attributeSet, i, i10), attributeSet, i);
        this.D = false;
        this.E = false;
        this.C = true;
        TypedArray typedArrayD = e0.d(getContext(), attributeSet, l.MaterialCardView, i, i10, new int[0]);
        c cVar = new c(this, attributeSet, i);
        this.B = cVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        g gVar = cVar.f14545c;
        gVar.l(cardBackgroundColor);
        cVar.f14544b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        cVar.l();
        MaterialCardView materialCardView = cVar.f14543a;
        ColorStateList colorStateListI = a.a.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_strokeColor);
        cVar.f14554n = colorStateListI;
        if (colorStateListI == null) {
            cVar.f14554n = ColorStateList.valueOf(-1);
        }
        cVar.f14549h = typedArrayD.getDimensionPixelSize(l.MaterialCardView_strokeWidth, 0);
        boolean z2 = typedArrayD.getBoolean(l.MaterialCardView_android_checkable, false);
        cVar.f14559s = z2;
        materialCardView.setLongClickable(z2);
        cVar.f14552l = a.a.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_checkedIconTint);
        cVar.g(a.a.m(materialCardView.getContext(), typedArrayD, l.MaterialCardView_checkedIcon));
        cVar.f = typedArrayD.getDimensionPixelSize(l.MaterialCardView_checkedIconSize, 0);
        cVar.f14547e = typedArrayD.getDimensionPixelSize(l.MaterialCardView_checkedIconMargin, 0);
        cVar.f14548g = typedArrayD.getInteger(l.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListI2 = a.a.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_rippleColor);
        cVar.f14551k = colorStateListI2;
        if (colorStateListI2 == null) {
            cVar.f14551k = ColorStateList.valueOf(z7.a.m(materialCardView, b.colorControlHighlight));
        }
        ColorStateList colorStateListI3 = a.a.i(materialCardView.getContext(), typedArrayD, l.MaterialCardView_cardForegroundColor);
        colorStateListI3 = colorStateListI3 == null ? ColorStateList.valueOf(0) : colorStateListI3;
        g gVar2 = cVar.f14546d;
        gVar2.l(colorStateListI3);
        int[] iArr = o9.a.f9444a;
        RippleDrawable rippleDrawable = cVar.f14555o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(cVar.f14551k);
        }
        gVar.k(materialCardView.getCardElevation());
        float f = cVar.f14549h;
        ColorStateList colorStateList = cVar.f14554n;
        gVar2.f11105u.f11097j = f;
        gVar2.invalidateSelf();
        f fVar = gVar2.f11105u;
        if (fVar.f11093d != colorStateList) {
            fVar.f11093d = colorStateList;
            gVar2.onStateChange(gVar2.getState());
        }
        materialCardView.setBackgroundInternal(cVar.d(gVar));
        Drawable drawableC = cVar.j() ? cVar.c() : gVar2;
        cVar.i = drawableC;
        materialCardView.setForeground(cVar.d(drawableC));
        typedArrayD.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.B.f14545c.getBounds());
        return rectF;
    }

    public final void b() {
        c cVar;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (cVar = this.B).f14555o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i = bounds.bottom;
        cVar.f14555o.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        cVar.f14555o.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.B.f14545c.f11105u.f11092c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.B.f14546d.f11105u.f11092c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.B.f14550j;
    }

    public int getCheckedIconGravity() {
        return this.B.f14548g;
    }

    public int getCheckedIconMargin() {
        return this.B.f14547e;
    }

    public int getCheckedIconSize() {
        return this.B.f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.B.f14552l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.B.f14544b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.B.f14544b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.B.f14544b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.B.f14544b.top;
    }

    public float getProgress() {
        return this.B.f14545c.f11105u.i;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.B.f14545c.h();
    }

    public ColorStateList getRippleColor() {
        return this.B.f14551k;
    }

    public q9.k getShapeAppearanceModel() {
        return this.B.f14553m;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.B.f14554n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.B.f14554n;
    }

    public int getStrokeWidth() {
        return this.B.f14549h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.D;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.B;
        cVar.k();
        i5.a.N(this, cVar.f14545c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        c cVar = this.B;
        if (cVar != null && cVar.f14559s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        if (this.D) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, G);
        }
        if (this.E) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.D);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        c cVar = this.B;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f14559s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.D);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        this.B.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.C) {
            c cVar = this.B;
            if (!cVar.f14558r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                cVar.f14558r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.B.f14545c.l(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        c cVar = this.B;
        cVar.f14545c.k(cVar.f14543a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.B.f14546d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.l(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.B.f14559s = z2;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.D != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.B.g(drawable);
    }

    public void setCheckedIconGravity(int i) {
        c cVar = this.B;
        if (cVar.f14548g != i) {
            cVar.f14548g = i;
            MaterialCardView materialCardView = cVar.f14543a;
            cVar.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i) {
        this.B.f14547e = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.B.f14547e = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.B.g(d.p(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.B.f = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.B.f = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c cVar = this.B;
        cVar.f14552l = colorStateList;
        Drawable drawable = cVar.f14550j;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        c cVar = this.B;
        if (cVar != null) {
            cVar.k();
        }
    }

    public void setDragged(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.B.m();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        c cVar = this.B;
        cVar.m();
        cVar.l();
    }

    public void setProgress(float f) {
        c cVar = this.B;
        cVar.f14545c.m(f);
        g gVar = cVar.f14546d;
        if (gVar != null) {
            gVar.m(f);
        }
        g gVar2 = cVar.f14557q;
        if (gVar2 != null) {
            gVar2.m(f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    @Override // androidx.cardview.widget.CardView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setRadius(float r3) {
        /*
            r2 = this;
            super.setRadius(r3)
            y8.c r0 = r2.B
            q9.k r1 = r0.f14553m
            q9.j r1 = r1.f()
            r1.b(r3)
            q9.k r3 = r1.a()
            r0.h(r3)
            android.graphics.drawable.Drawable r3 = r0.i
            r3.invalidateSelf()
            boolean r3 = r0.i()
            if (r3 != 0) goto L38
            com.google.android.material.card.MaterialCardView r3 = r0.f14543a
            boolean r3 = r3.getPreventCornerOverlap()
            if (r3 == 0) goto L3b
            q9.g r3 = r0.f14545c
            q9.f r1 = r3.f11105u
            q9.k r1 = r1.f11090a
            android.graphics.RectF r3 = r3.g()
            boolean r3 = r1.e(r3)
            if (r3 != 0) goto L3b
        L38:
            r0.l()
        L3b:
            boolean r3 = r0.i()
            if (r3 == 0) goto L44
            r0.m()
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.setRadius(float):void");
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.B;
        cVar.f14551k = colorStateList;
        int[] iArr = o9.a.f9444a;
        RippleDrawable rippleDrawable = cVar.f14555o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        ColorStateList colorStateListC = f0.c.c(getContext(), i);
        c cVar = this.B;
        cVar.f14551k = colorStateListC;
        int[] iArr = o9.a.f9444a;
        RippleDrawable rippleDrawable = cVar.f14555o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateListC);
        }
    }

    @Override // q9.u
    public void setShapeAppearanceModel(q9.k kVar) {
        setClipToOutline(kVar.e(getBoundsAsRectF()));
        this.B.h(kVar);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        c cVar = this.B;
        if (i != cVar.f14549h) {
            cVar.f14549h = i;
            g gVar = cVar.f14546d;
            ColorStateList colorStateList = cVar.f14554n;
            gVar.f11105u.f11097j = i;
            gVar.invalidateSelf();
            f fVar = gVar.f11105u;
            if (fVar.f11093d != colorStateList) {
                fVar.f11093d = colorStateList;
                gVar.onStateChange(gVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        c cVar = this.B;
        cVar.m();
        cVar.l();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        c cVar = this.B;
        if (cVar != null && cVar.f14559s && isEnabled()) {
            this.D = !this.D;
            refreshDrawableState();
            b();
            cVar.f(this.D, true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c cVar = this.B;
        if (cVar.f14554n != colorStateList) {
            cVar.f14554n = colorStateList;
            g gVar = cVar.f14546d;
            gVar.f11105u.f11097j = cVar.f14549h;
            gVar.invalidateSelf();
            f fVar = gVar.f11105u;
            if (fVar.f11093d != colorStateList) {
                fVar.f11093d = colorStateList;
                gVar.onStateChange(gVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.B.f14545c.l(colorStateList);
    }

    public void setOnCheckedChangeListener(y8.a aVar) {
    }
}
