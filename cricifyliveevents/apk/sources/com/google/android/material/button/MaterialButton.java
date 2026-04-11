package com.google.android.material.button;

import android.R;
import android.annotation.SuppressLint;
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
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import com.bumptech.glide.c;
import com.bumptech.glide.e;
import com.google.android.gms.internal.measurement.j4;
import da.d0;
import da.e0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k1.f;
import k1.g;
import k9.b;
import k9.k;
import k9.l;
import ka.f0;
import ka.i;
import ka.m;
import ka.w;
import r9.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, w {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int[] f2819d0 = {R.attr.state_checkable};

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int[] f2820e0 = {R.attr.state_checked};

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f2821f0 = k.Widget_MaterialComponents_Button;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f2822g0 = b.materialSizeOverlay;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final r9.a f2823h0 = new r9.a();
    public r9.b A;
    public PorterDuff.Mode B;
    public ColorStateList C;
    public Drawable D;
    public String E;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public LinearLayout.LayoutParams Q;
    public boolean R;
    public int S;
    public boolean T;
    public int U;
    public f0 V;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f2824a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f2825b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public f f2826c0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f2827y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LinkedHashSet f2828z;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        int i = b.materialButtonStyle;
        int[] iArr = {f2822g0};
        int i10 = f2821f0;
        super(ra.a.b(context, attributeSet, i, i10, iArr), attributeSet, i);
        this.f2828z = new LinkedHashSet();
        this.J = false;
        this.K = false;
        this.M = -1;
        this.N = -1.0f;
        this.O = -1;
        this.P = -1;
        this.U = -1;
        Context context2 = getContext();
        TypedArray typedArrayD = d0.d(context2, attributeSet, l.MaterialButton, i, i10, new int[0]);
        this.I = typedArrayD.getDimensionPixelSize(l.MaterialButton_iconPadding, 0);
        int i11 = typedArrayD.getInt(l.MaterialButton_iconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.B = e0.c(i11, mode);
        this.C = c.i(getContext(), typedArrayD, l.MaterialButton_iconTint);
        this.D = c.l(getContext(), typedArrayD, l.MaterialButton_icon);
        this.L = typedArrayD.getInteger(l.MaterialButton_iconGravity, 1);
        this.F = typedArrayD.getDimensionPixelSize(l.MaterialButton_iconSize, 0);
        ka.d0 d0VarB = ka.d0.b(context2, typedArrayD, l.MaterialButton_shapeAppearance);
        m mVarC = d0VarB != null ? d0VarB.c() : m.c(context2, attributeSet, i, i10).a();
        boolean z10 = typedArrayD.getBoolean(l.MaterialButton_opticalCenterEnabled, false);
        d dVar = new d(this, mVarC);
        this.f2827y = dVar;
        dVar.f = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetLeft, 0);
        dVar.f10902g = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetRight, 0);
        dVar.f10903h = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetTop, 0);
        dVar.i = typedArrayD.getDimensionPixelOffset(l.MaterialButton_android_insetBottom, 0);
        if (typedArrayD.hasValue(l.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(l.MaterialButton_cornerRadius, -1);
            dVar.f10904j = dimensionPixelSize;
            ka.l lVarG = dVar.f10898b.g();
            lVarG.b(dimensionPixelSize);
            dVar.f10898b = lVarG.a();
            dVar.f10899c = null;
            dVar.d();
            dVar.f10913s = true;
        }
        dVar.f10905k = typedArrayD.getDimensionPixelSize(l.MaterialButton_strokeWidth, 0);
        dVar.f10906l = e0.c(typedArrayD.getInt(l.MaterialButton_backgroundTintMode, -1), mode);
        dVar.f10907m = c.i(getContext(), typedArrayD, l.MaterialButton_backgroundTint);
        dVar.f10908n = c.i(getContext(), typedArrayD, l.MaterialButton_strokeColor);
        dVar.f10909o = c.i(getContext(), typedArrayD, l.MaterialButton_rippleColor);
        dVar.f10914t = typedArrayD.getBoolean(l.MaterialButton_android_checkable, false);
        dVar.f10917w = typedArrayD.getDimensionPixelSize(l.MaterialButton_elevation, 0);
        dVar.f10915u = typedArrayD.getBoolean(l.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(l.MaterialButton_android_background)) {
            dVar.f10912r = true;
            setSupportBackgroundTintList(dVar.f10907m);
            setSupportBackgroundTintMode(dVar.f10906l);
        } else {
            dVar.c();
        }
        setPaddingRelative(paddingStart + dVar.f, paddingTop + dVar.f10903h, paddingEnd + dVar.f10902g, paddingBottom + dVar.i);
        setCheckedInternal(typedArrayD.getBoolean(l.MaterialButton_android_checked, false));
        if (d0VarB != null) {
            dVar.f10900d = d();
            if (dVar.f10899c != null) {
                dVar.d();
            }
            dVar.f10899c = d0VarB;
            dVar.d();
        }
        setOpticalCenterEnabled(z10);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.I);
        h(this.D != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.S = materialButton.getOpticalCenterShift();
        materialButton.j();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f2824a0;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        i iVarA;
        if (this.R && this.T && (iVarA = this.f2827y.a(false)) != null) {
            return (int) (iVarA.i() * 0.11f);
        }
        return 0;
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

    private void setCheckedInternal(boolean z10) {
        d dVar = this.f2827y;
        if (dVar == null || !dVar.f10914t || this.J == z10) {
            return;
        }
        this.J = z10;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z11 = this.J;
            if (!materialButtonToggleGroup.H) {
                materialButtonToggleGroup.f(getId(), z11);
            }
        }
        if (this.K) {
            return;
        }
        this.K = true;
        Iterator it = this.f2828z.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        this.K = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.f2824a0 != f) {
            this.f2824a0 = f;
            j();
            invalidate();
            if (getParent() instanceof a) {
                a aVar = (a) getParent();
                int i = (int) this.f2824a0;
                int iIndexOfChild = aVar.indexOfChild(this);
                if (iIndexOfChild < 0) {
                    return;
                }
                int i10 = iIndexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i10 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (aVar.c(i10)) {
                            materialButton2 = (MaterialButton) aVar.getChildAt(i10);
                            break;
                        }
                        i10--;
                    }
                }
                int childCount = aVar.getChildCount();
                while (true) {
                    iIndexOfChild++;
                    if (iIndexOfChild >= childCount) {
                        break;
                    } else if (aVar.c(iIndexOfChild)) {
                        materialButton = (MaterialButton) aVar.getChildAt(iIndexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i / 2);
                materialButton.setDisplayedWidthDecrease((i + 1) / 2);
            }
        }
    }

    public final g d() {
        Context context = getContext();
        int i = b.motionSpringFastSpatial;
        int i10 = k.Motion_Material3_Spring_Standard_Fast_Spatial;
        TypedValue typedValueG = android.support.v4.media.session.b.G(context, i);
        TypedArray typedArrayObtainStyledAttributes = typedValueG == null ? context.obtainStyledAttributes(null, l.MaterialSpring, 0, i10) : context.obtainStyledAttributes(typedValueG.resourceId, l.MaterialSpring);
        g gVar = new g();
        try {
            float f = typedArrayObtainStyledAttributes.getFloat(l.MaterialSpring_stiffness, Float.MIN_VALUE);
            if (f == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f10 = typedArrayObtainStyledAttributes.getFloat(l.MaterialSpring_damping, Float.MIN_VALUE);
            if (f10 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            if (f <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            gVar.f6814a = Math.sqrt(f);
            gVar.f6816c = false;
            if (f10 < 0.0f) {
                throw new IllegalArgumentException("Damping ratio must be non-negative");
            }
            gVar.f6815b = f10;
            gVar.f6816c = false;
            typedArrayObtainStyledAttributes.recycle();
            return gVar;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final boolean e() {
        d dVar = this.f2827y;
        return (dVar == null || dVar.f10912r) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r9) {
        /*
            r8 = this;
            ka.f0 r0 = r8.V
            if (r0 != 0) goto L6
            goto L85
        L6:
            k1.f r0 = r8.f2826c0
            if (r0 != 0) goto L19
            k1.f r0 = new k1.f
            r9.a r1 = com.google.android.material.button.MaterialButton.f2823h0
            r0.<init>(r8, r1)
            r8.f2826c0 = r0
            k1.g r1 = r8.d()
            r0.f6811j = r1
        L19:
            boolean r0 = r8.T
            if (r0 == 0) goto L85
            int r0 = r8.W
            ka.f0 r1 = r8.V
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f7314c
            r4 = 0
            r5 = r4
        L29:
            int r6 = r1.f7312a
            r7 = -1
            if (r5 >= r6) goto L3a
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L37
            goto L3b
        L37:
            int r5 = r5 + 1
            goto L29
        L3a:
            r5 = r7
        L3b:
            if (r5 >= 0) goto L54
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.f7314c
            r5 = r4
        L42:
            int r6 = r1.f7312a
            if (r5 >= r6) goto L53
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L50
            r7 = r5
            goto L53
        L50:
            int r5 = r5 + 1
            goto L42
        L53:
            r5 = r7
        L54:
            if (r5 >= 0) goto L59
            pc.c r1 = r1.f7313b
            goto L5d
        L59:
            pc.c[] r1 = r1.f7315d
            r1 = r1[r5]
        L5d:
            java.lang.Object r1 = r1.f10180v
            ka.e0 r1 = (ka.e0) r1
            int r2 = r8.getWidth()
            float r3 = r1.f7306b
            int r1 = r1.f7305a
            r5 = 1
            if (r1 != r5) goto L70
            float r1 = (float) r2
            float r3 = r3 * r1
        L6e:
            int r4 = (int) r3
            goto L74
        L70:
            r2 = 2
            if (r1 != r2) goto L74
            goto L6e
        L74:
            int r0 = java.lang.Math.min(r0, r4)
            k1.f r1 = r8.f2826c0
            float r0 = (float) r0
            r1.a(r0)
            if (r9 == 0) goto L85
            k1.f r9 = r8.f2826c0
            r9.d()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.f(boolean):void");
    }

    public final void g() {
        int i = this.L;
        if (i == 1 || i == 2) {
            setCompoundDrawablesRelative(this.D, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.D, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.D, null, null);
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.E)) {
            return this.E;
        }
        d dVar = this.f2827y;
        return ((dVar == null || !dVar.f10914t) ? Button.class : CompoundButton.class).getName();
    }

    public int getAllowedWidthDecrease() {
        return this.U;
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
        if (e()) {
            return this.f2827y.f10904j;
        }
        return 0;
    }

    public g getCornerSpringForce() {
        return this.f2827y.f10900d;
    }

    public Drawable getIcon() {
        return this.D;
    }

    public int getIconGravity() {
        return this.L;
    }

    public int getIconPadding() {
        return this.I;
    }

    public int getIconSize() {
        return this.F;
    }

    public ColorStateList getIconTint() {
        return this.C;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.B;
    }

    public int getInsetBottom() {
        return this.f2827y.i;
    }

    public int getInsetTop() {
        return this.f2827y.f10903h;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f2827y.f10909o;
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        if (e()) {
            return this.f2827y.f10898b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ka.d0 getStateListShapeAppearanceModel() {
        if (e()) {
            return this.f2827y.f10899c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f2827y.f10908n;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f2827y.f10905k;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f2827y.f10907m : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f2827y.f10906l : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z10) {
        Drawable drawable = this.D;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.D = drawableMutate;
            drawableMutate.setTintList(this.C);
            PorterDuff.Mode mode = this.B;
            if (mode != null) {
                this.D.setTintMode(mode);
            }
            int intrinsicWidth = this.F;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.D.getIntrinsicWidth();
            }
            int intrinsicHeight = this.F;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.D.getIntrinsicHeight();
            }
            Drawable drawable2 = this.D;
            int i = this.G;
            int i10 = this.H;
            drawable2.setBounds(i, i10, intrinsicWidth + i, intrinsicHeight + i10);
            this.D.setVisible(true, z10);
        }
        if (z10) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i11 = this.L;
        if (((i11 == 1 || i11 == 2) && drawable3 != this.D) || (((i11 == 3 || i11 == 4) && drawable5 != this.D) || ((i11 == 16 || i11 == 32) && drawable4 != this.D))) {
            g();
        }
    }

    public final void i(int i, int i10) {
        if (this.D == null || getLayout() == null) {
            return;
        }
        int i11 = this.L;
        if (i11 != 1 && i11 != 2 && i11 != 3 && i11 != 4) {
            if (i11 == 16 || i11 == 32) {
                this.G = 0;
                if (i11 == 16) {
                    this.H = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.F;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.D.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i10 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.I) - getPaddingBottom()) / 2);
                if (this.H != iMax) {
                    this.H = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.H = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.L;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.G = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.F;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.D.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.I) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.L == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.G != textLayoutWidth) {
            this.G = textLayoutWidth;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.J;
    }

    public final void j() {
        int i = (int) (this.f2824a0 - this.f2825b0);
        int i10 = (i / 2) + this.S;
        getLayoutParams().width = (int) (this.N + i);
        setPaddingRelative(this.O + i10, getPaddingTop(), (this.P + i) - i10, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            e.p(this, this.f2827y.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        d dVar = this.f2827y;
        if (dVar != null && dVar.f10914t) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2819d0);
        }
        if (this.J) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2820e0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.J);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        d dVar = this.f2827y;
        accessibilityNodeInfo.setCheckable(dVar != null && dVar.f10914t);
        accessibilityNodeInfo.setChecked(this.J);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        int i13;
        super.onLayout(z10, i, i10, i11, i12);
        i(getMeasuredWidth(), getMeasuredHeight());
        int i14 = getResources().getConfiguration().orientation;
        if (this.M != i14) {
            this.M = i14;
            this.N = -1.0f;
        }
        if (this.N == -1.0f) {
            this.N = getMeasuredWidth();
            if (this.Q == null && (getParent() instanceof a) && ((a) getParent()).getButtonSizeChange() != null) {
                this.Q = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Q);
                layoutParams.width = (int) this.N;
                setLayoutParams(layoutParams);
            }
        }
        boolean z11 = false;
        if (this.U == -1) {
            if (this.D == null) {
                i13 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.F;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.D.getIntrinsicWidth();
                }
                i13 = iconPadding + intrinsicWidth;
            }
            this.U = (getMeasuredWidth() - getTextLayoutWidth()) - i13;
        }
        if (this.O == -1) {
            this.O = getPaddingStart();
        }
        if (this.P == -1) {
            this.P = getPaddingEnd();
        }
        if ((getParent() instanceof a) && ((a) getParent()).getOrientation() == 0) {
            z11 = true;
        }
        this.T = z11;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof r9.c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        r9.c cVar = (r9.c) parcelable;
        super.onRestoreInstanceState(cVar.f112v);
        setChecked(cVar.f10896x);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        r9.c cVar = new r9.c(super.onSaveInstanceState());
        cVar.f10896x = this.J;
        return cVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i10, int i11) {
        super.onTextChanged(charSequence, i, i10, i11);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f2827y.f10915u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.D != null) {
            if (this.D.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.E = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!e()) {
            super.setBackgroundColor(i);
            return;
        }
        d dVar = this.f2827y;
        if (dVar.a(false) != null) {
            dVar.a(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        d dVar = this.f2827y;
        dVar.f10912r = true;
        MaterialButton materialButton = dVar.f10897a;
        materialButton.setSupportBackgroundTintList(dVar.f10907m);
        materialButton.setSupportBackgroundTintMode(dVar.f10906l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? j4.i(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (e()) {
            this.f2827y.f10914t = z10;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedInternal(z10);
    }

    public void setCornerRadius(int i) {
        if (e()) {
            d dVar = this.f2827y;
            if (dVar.f10913s && dVar.f10904j == i) {
                return;
            }
            dVar.f10904j = i;
            dVar.f10913s = true;
            ka.l lVarG = dVar.f10898b.g();
            lVarG.b(i);
            dVar.f10898b = lVarG.a();
            dVar.f10899c = null;
            dVar.d();
        }
    }

    public void setCornerRadiusResource(int i) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCornerSpringForce(g gVar) {
        d dVar = this.f2827y;
        dVar.f10900d = gVar;
        if (dVar.f10899c != null) {
            dVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i) {
        this.f2825b0 = Math.min(i, this.U);
        j();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (e()) {
            this.f2827y.a(false).p(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.D != drawable) {
            this.D = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.L != i) {
            this.L = i;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.I != i) {
            this.I = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? j4.i(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.F != i) {
            this.F = i;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.B != mode) {
            this.B = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(i0.c.c(getContext(), i));
    }

    public void setInsetBottom(int i) {
        d dVar = this.f2827y;
        dVar.b(dVar.f10903h, i);
    }

    public void setInsetTop(int i) {
        d dVar = this.f2827y;
        dVar.b(i, dVar.i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(r9.b bVar) {
        this.A = bVar;
    }

    public void setOpticalCenterEnabled(boolean z10) {
        if (this.R != z10) {
            this.R = z10;
            d dVar = this.f2827y;
            if (z10) {
                kb.d dVar2 = new kb.d(10, this);
                dVar.f10901e = dVar2;
                i iVarA = dVar.a(false);
                if (iVarA != null) {
                    iVarA.Z = dVar2;
                }
            } else {
                dVar.f10901e = null;
                i iVarA2 = dVar.a(false);
                if (iVarA2 != null) {
                    iVarA2.Z = null;
                }
            }
            post(new pa.c(8, this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        r9.b bVar = this.A;
        if (bVar != null) {
            ((MaterialButtonToggleGroup) ((l4.a) bVar).f7697v).invalidate();
        }
        super.setPressed(z10);
        f(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            d dVar = this.f2827y;
            MaterialButton materialButton = dVar.f10897a;
            if (dVar.f10909o != colorStateList) {
                dVar.f10909o = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(ia.a.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (e()) {
            setRippleColor(i0.c.c(getContext(), i));
        }
    }

    @Override // ka.w
    public void setShapeAppearanceModel(m mVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        d dVar = this.f2827y;
        dVar.f10898b = mVar;
        dVar.f10899c = null;
        dVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (e()) {
            d dVar = this.f2827y;
            dVar.f10911q = z10;
            dVar.e();
        }
    }

    public void setSizeChange(f0 f0Var) {
        if (this.V != f0Var) {
            this.V = f0Var;
            f(true);
        }
    }

    public void setStateListShapeAppearanceModel(ka.d0 d0Var) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        d dVar = this.f2827y;
        if (dVar.f10900d == null && d0Var.d()) {
            dVar.f10900d = d();
            if (dVar.f10899c != null) {
                dVar.d();
            }
        }
        dVar.f10899c = d0Var;
        dVar.d();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            d dVar = this.f2827y;
            if (dVar.f10908n != colorStateList) {
                dVar.f10908n = colorStateList;
                dVar.e();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (e()) {
            setStrokeColor(i0.c.c(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (e()) {
            d dVar = this.f2827y;
            if (dVar.f10905k != i) {
                dVar.f10905k = i;
                dVar.e();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        d dVar = this.f2827y;
        if (dVar.f10907m != colorStateList) {
            dVar.f10907m = colorStateList;
            if (dVar.a(false) != null) {
                dVar.a(false).setTintList(dVar.f10907m);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        d dVar = this.f2827y;
        if (dVar.f10906l != mode) {
            dVar.f10906l = mode;
            if (dVar.a(false) == null || dVar.f10906l == null) {
                return;
            }
            dVar.a(false).setTintMode(dVar.f10906l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f2827y.f10915u = z10;
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.N = -1.0f;
        super.setWidth(i);
    }

    public void setWidthChangeMax(int i) {
        if (this.W != i) {
            this.W = i;
            f(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.J);
    }
}
