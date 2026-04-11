package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.bumptech.glide.e;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.o4;
import da.b0;
import da.d0;
import da.g;
import da.h;
import da.z;
import ha.d;
import java.lang.ref.WeakReference;
import java.util.Locale;
import k9.f;
import k9.k;
import k9.l;
import ka.m;
import ka.w;
import ka.y;
import o.p;
import t0.m0;
import v9.a;
import v9.b;
import v9.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class Chip extends p implements b, w, h {
    public static final int S = k.Widget_MaterialComponents_Chip_Action;
    public static final Rect T = new Rect();
    public static final int[] U = {R.attr.state_selected};
    public static final int[] V = {R.attr.state_checkable};
    public InsetDrawable A;
    public RippleDrawable B;
    public View.OnClickListener C;
    public CompoundButton.OnCheckedChangeListener D;
    public g E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;
    public CharSequence M;
    public final a N;
    public boolean O;
    public final Rect P;
    public final RectF Q;
    public final z R;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f2837z;

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = k9.b.chipStyle;
        int i10 = S;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.P = new Rect();
        this.Q = new RectF();
        this.R = new z(1, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        c cVar = new c(context2, attributeSet, i);
        TypedArray typedArrayD = d0.d(cVar.J0, attributeSet, l.Chip, i, i10, new int[0]);
        cVar.f13527j1 = typedArrayD.hasValue(l.Chip_shapeAppearance);
        int i11 = l.Chip_chipSurfaceColor;
        Context context3 = cVar.J0;
        ColorStateList colorStateListI = com.bumptech.glide.c.i(context3, typedArrayD, i11);
        if (cVar.f13513c0 != colorStateListI) {
            cVar.f13513c0 = colorStateListI;
            cVar.onStateChange(cVar.getState());
        }
        ColorStateList colorStateListI2 = com.bumptech.glide.c.i(context3, typedArrayD, l.Chip_chipBackgroundColor);
        if (cVar.f13514d0 != colorStateListI2) {
            cVar.f13514d0 = colorStateListI2;
            cVar.onStateChange(cVar.getState());
        }
        float dimension = typedArrayD.getDimension(l.Chip_chipMinHeight, 0.0f);
        if (cVar.f13516e0 != dimension) {
            cVar.f13516e0 = dimension;
            cVar.invalidateSelf();
            cVar.F();
        }
        if (typedArrayD.hasValue(l.Chip_chipCornerRadius)) {
            cVar.L(typedArrayD.getDimension(l.Chip_chipCornerRadius, 0.0f));
        }
        cVar.Q(com.bumptech.glide.c.i(context3, typedArrayD, l.Chip_chipStrokeColor));
        cVar.R(typedArrayD.getDimension(l.Chip_chipStrokeWidth, 0.0f));
        cVar.b0(com.bumptech.glide.c.i(context3, typedArrayD, l.Chip_rippleColor));
        String text = typedArrayD.getText(l.Chip_android_text);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(cVar.f13526j0, text);
        b0 b0Var = cVar.P0;
        if (!zEquals) {
            cVar.f13526j0 = text;
            b0Var.f3571e = true;
            cVar.invalidateSelf();
            cVar.F();
        }
        int i12 = l.Chip_android_textAppearance;
        d dVar = (!typedArrayD.hasValue(i12) || (resourceId = typedArrayD.getResourceId(i12, 0)) == 0) ? null : new d(context3, resourceId);
        dVar.f5865l = typedArrayD.getDimension(l.Chip_android_textSize, dVar.f5865l);
        b0Var.b(dVar, context3);
        int i13 = typedArrayD.getInt(l.Chip_android_ellipsize, 0);
        if (i13 == 1) {
            cVar.f13521g1 = TextUtils.TruncateAt.START;
        } else if (i13 == 2) {
            cVar.f13521g1 = TextUtils.TruncateAt.MIDDLE;
        } else if (i13 == 3) {
            cVar.f13521g1 = TextUtils.TruncateAt.END;
        }
        cVar.P(typedArrayD.getBoolean(l.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            cVar.P(typedArrayD.getBoolean(l.Chip_chipIconEnabled, false));
        }
        cVar.M(com.bumptech.glide.c.l(context3, typedArrayD, l.Chip_chipIcon));
        if (typedArrayD.hasValue(l.Chip_chipIconTint)) {
            cVar.O(com.bumptech.glide.c.i(context3, typedArrayD, l.Chip_chipIconTint));
        }
        cVar.N(typedArrayD.getDimension(l.Chip_chipIconSize, -1.0f));
        cVar.Y(typedArrayD.getBoolean(l.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            cVar.Y(typedArrayD.getBoolean(l.Chip_closeIconEnabled, false));
        }
        cVar.S(com.bumptech.glide.c.l(context3, typedArrayD, l.Chip_closeIcon));
        cVar.X(com.bumptech.glide.c.i(context3, typedArrayD, l.Chip_closeIconTint));
        cVar.U(typedArrayD.getDimension(l.Chip_closeIconSize, 0.0f));
        cVar.H(typedArrayD.getBoolean(l.Chip_android_checkable, false));
        cVar.K(typedArrayD.getBoolean(l.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            cVar.K(typedArrayD.getBoolean(l.Chip_checkedIconEnabled, false));
        }
        cVar.I(com.bumptech.glide.c.l(context3, typedArrayD, l.Chip_checkedIcon));
        if (typedArrayD.hasValue(l.Chip_checkedIconTint)) {
            cVar.J(com.bumptech.glide.c.i(context3, typedArrayD, l.Chip_checkedIconTint));
        }
        cVar.f13542z0 = l9.d.a(context3, typedArrayD, l.Chip_showMotionSpec);
        cVar.A0 = l9.d.a(context3, typedArrayD, l.Chip_hideMotionSpec);
        float dimension2 = typedArrayD.getDimension(l.Chip_chipStartPadding, 0.0f);
        if (cVar.B0 != dimension2) {
            cVar.B0 = dimension2;
            cVar.invalidateSelf();
            cVar.F();
        }
        cVar.a0(typedArrayD.getDimension(l.Chip_iconStartPadding, 0.0f));
        cVar.Z(typedArrayD.getDimension(l.Chip_iconEndPadding, 0.0f));
        float dimension3 = typedArrayD.getDimension(l.Chip_textStartPadding, 0.0f);
        if (cVar.E0 != dimension3) {
            cVar.E0 = dimension3;
            cVar.invalidateSelf();
            cVar.F();
        }
        float dimension4 = typedArrayD.getDimension(l.Chip_textEndPadding, 0.0f);
        if (cVar.F0 != dimension4) {
            cVar.F0 = dimension4;
            cVar.invalidateSelf();
            cVar.F();
        }
        cVar.V(typedArrayD.getDimension(l.Chip_closeIconStartPadding, 0.0f));
        cVar.T(typedArrayD.getDimension(l.Chip_closeIconEndPadding, 0.0f));
        float dimension5 = typedArrayD.getDimension(l.Chip_chipEndPadding, 0.0f);
        if (cVar.I0 != dimension5) {
            cVar.I0 = dimension5;
            cVar.invalidateSelf();
            cVar.F();
        }
        cVar.f13525i1 = typedArrayD.getDimensionPixelSize(l.Chip_android_maxWidth, Integer.MAX_VALUE);
        typedArrayD.recycle();
        int[] iArr = l.Chip;
        d0.a(context2, attributeSet, i, i10);
        d0.b(context2, attributeSet, iArr, i, i10, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, i10);
        this.J = typedArrayObtainStyledAttributes.getBoolean(l.Chip_ensureMinTouchTargetSize, false);
        int i14 = k9.b.minTouchTargetSize;
        int i15 = k9.d.mtrl_min_touch_target_size;
        TypedValue typedValueG = android.support.v4.media.session.b.G(context2, i14);
        this.L = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(l.Chip_chipMinTouchTargetSize, (int) ((typedValueG == null || typedValueG.type != 5) ? context2.getResources().getDimension(i15) : typedValueG.getDimension(context2.getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(cVar);
        cVar.p(getElevation());
        int[] iArr2 = l.Chip;
        d0.a(context2, attributeSet, i, i10);
        d0.b(context2, attributeSet, iArr2, i, i10, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr2, i, i10);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(l.Chip_shapeAppearance);
        typedArrayObtainStyledAttributes2.recycle();
        this.N = new a(this, this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new y(3, this));
        }
        setChecked(this.F);
        setText(cVar.f13526j0);
        setEllipsize(cVar.f13521g1);
        h();
        if (!this.f2837z.f13523h1) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.J) {
            setMinHeight(this.L);
        }
        this.K = getLayoutDirection();
        super.setOnCheckedChangeListener(new v5.k(2, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.Q;
        rectF.setEmpty();
        if (d() && this.C != null) {
            c cVar = this.f2837z;
            Rect bounds = cVar.getBounds();
            rectF.setEmpty();
            if (cVar.e0()) {
                float f = cVar.I0 + cVar.H0 + cVar.f13536t0 + cVar.G0 + cVar.F0;
                if (cVar.getLayoutDirection() == 0) {
                    float f10 = bounds.right;
                    rectF.right = f10;
                    rectF.left = f10 - f;
                } else {
                    float f11 = bounds.left;
                    rectF.left = f11;
                    rectF.right = f11 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i10 = (int) closeIconTouchBounds.top;
        int i11 = (int) closeIconTouchBounds.right;
        int i12 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.P;
        rect.set(i, i10, i11, i12);
        return rect;
    }

    private d getTextAppearance() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.P0.f3572g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.H != z10) {
            this.H = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.G != z10) {
            this.G = z10;
            refreshDrawableState();
        }
    }

    public final void c(int i) {
        this.L = i;
        if (!this.J) {
            InsetDrawable insetDrawable = this.A;
            if (insetDrawable == null) {
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.A = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.f2837z.f13516e0));
        int iMax2 = Math.max(0, i - this.f2837z.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.A;
            if (insetDrawable2 == null) {
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.A = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int i10 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i11 = iMax > 0 ? iMax / 2 : 0;
        if (this.A != null) {
            Rect rect = new Rect();
            this.A.getPadding(rect);
            if (rect.top == i11 && rect.bottom == i11 && rect.left == i10 && rect.right == i10) {
                f();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.A = new InsetDrawable((Drawable) this.f2837z, i10, i11, i10, i11);
        f();
    }

    public final boolean d() {
        c cVar = this.f2837z;
        if (cVar == null) {
            return false;
        }
        Object obj = cVar.f13533q0;
        if (obj == null) {
            obj = null;
        } else if (obj instanceof m0.b) {
            obj = null;
        }
        return obj != null;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.O ? super.dispatchHoverEvent(motionEvent) : this.N.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.O
            if (r0 != 0) goto L9
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L9:
            v9.a r0 = r9.N
            r0.getClass()
            int r1 = r10.getAction()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            r4 = 0
            if (r1 == r3) goto L84
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L6e
            r5 = 66
            if (r1 == r5) goto L57
            switch(r1) {
                case 19: goto L29;
                case 20: goto L29;
                case 21: goto L29;
                case 22: goto L29;
                case 23: goto L57;
                default: goto L28;
            }
        L28:
            goto L84
        L29:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L84
            r7 = 19
            if (r1 == r7) goto L41
            r7 = 21
            if (r1 == r7) goto L3e
            r7 = 22
            if (r1 == r7) goto L43
            r5 = 130(0x82, float:1.82E-43)
            goto L43
        L3e:
            r5 = 17
            goto L43
        L41:
            r5 = 33
        L43:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r3
            r7 = r4
        L49:
            if (r4 >= r1) goto L55
            boolean r8 = r0.p(r5, r6)
            if (r8 == 0) goto L55
            int r4 = r4 + 1
            r7 = r3
            goto L49
        L55:
            r4 = r7
            goto L84
        L57:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L84
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L84
            int r1 = r0.f1642l
            if (r1 == r2) goto L6c
            r4 = 16
            r0.r(r1, r4)
        L6c:
            r4 = r3
            goto L84
        L6e:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L7a
            r1 = 2
            boolean r4 = r0.p(r1, r6)
            goto L84
        L7a:
            boolean r1 = r10.hasModifiers(r3)
            if (r1 == 0) goto L84
            boolean r4 = r0.p(r3, r6)
        L84:
            if (r4 == 0) goto L8b
            int r0 = r0.f1642l
            if (r0 == r2) goto L8b
            return r3
        L8b:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // o.p, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.f2837z;
        boolean zW = false;
        int i = 0;
        zW = false;
        if (cVar != null && c.E(cVar.f13533q0)) {
            c cVar2 = this.f2837z;
            ?? IsEnabled = isEnabled();
            int i10 = IsEnabled;
            if (this.I) {
                i10 = IsEnabled + 1;
            }
            int i11 = i10;
            if (this.H) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (this.G) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (isChecked()) {
                i13 = i12 + 1;
            }
            int[] iArr = new int[i13];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.I) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.H) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.G) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            zW = cVar2.W(iArr);
        }
        if (zW) {
            invalidate();
        }
    }

    public final void e() {
        c cVar;
        if (!d() || (cVar = this.f2837z) == null || !cVar.f13532p0 || this.C == null) {
            m0.n(this, null);
            this.O = false;
        } else {
            m0.n(this, this.N);
            this.O = true;
        }
    }

    public final void f() {
        this.B = new RippleDrawable(ia.a.b(this.f2837z.f13524i0), getBackgroundDrawable(), null);
        this.f2837z.getClass();
        setBackground(this.B);
        g();
    }

    public final void g() {
        c cVar;
        if (TextUtils.isEmpty(getText()) || (cVar = this.f2837z) == null) {
            return;
        }
        int iB = (int) (cVar.B() + cVar.I0 + cVar.F0);
        c cVar2 = this.f2837z;
        int iA = (int) (cVar2.A() + cVar2.B0 + cVar2.E0);
        if (this.A != null) {
            Rect rect = new Rect();
            this.A.getPadding(rect);
            iA += rect.left;
            iB += rect.right;
        }
        setPaddingRelative(iA, getPaddingTop(), iB, getPaddingBottom());
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.M)) {
            return this.M;
        }
        c cVar = this.f2837z;
        if (cVar == null || !cVar.f13538v0) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).C.f3562b) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.A;
        return insetDrawable == null ? this.f2837z : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13540x0;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13541y0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13514d0;
        }
        return null;
    }

    public float getChipCornerRadius() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return Math.max(0.0f, cVar.C());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2837z;
    }

    public float getChipEndPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.I0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        c cVar = this.f2837z;
        if (cVar == null || (drawable = cVar.f13529l0) == 0) {
            return null;
        }
        if (!(drawable instanceof m0.b)) {
            return drawable;
        }
        return null;
    }

    public float getChipIconSize() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13531n0;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13530m0;
        }
        return null;
    }

    public float getChipMinHeight() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13516e0;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.B0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13520g0;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13522h0;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        c cVar = this.f2837z;
        if (cVar == null || (drawable = cVar.f13533q0) == 0) {
            return null;
        }
        if (!(drawable instanceof m0.b)) {
            return drawable;
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13537u0;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.H0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13536t0;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.G0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13535s0;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13521g1;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.O) {
            a aVar = this.N;
            if (aVar.f1642l == 1 || aVar.f1641k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public l9.d getHideMotionSpec() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.A0;
        }
        return null;
    }

    public float getIconEndPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.D0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.C0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13524i0;
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        return this.f2837z.f7334w.f7316a;
    }

    public l9.d getShowMotionSpec() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.f13542z0;
        }
        return null;
    }

    public float getTextEndPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.F0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c cVar = this.f2837z;
        if (cVar != null) {
            return cVar.E0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        c cVar = this.f2837z;
        if (cVar != null) {
            paint.drawableState = cVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.R);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.p(this, this.f2837z);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, U);
        }
        c cVar = this.f2837z;
        if (cVar != null && cVar.f13538v0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, V);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z10, int i, Rect rect) {
        super.onFocusChanged(z10, i, rect);
        if (this.O) {
            a aVar = this.N;
            int i10 = aVar.f1642l;
            if (i10 != Integer.MIN_VALUE) {
                aVar.j(i10);
            }
            if (z10) {
                aVar.p(i, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        c cVar = this.f2837z;
        int i10 = 0;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f13538v0);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f3614x) {
                int i11 = 0;
                while (true) {
                    if (i10 >= chipGroup.getChildCount()) {
                        i11 = -1;
                        break;
                    }
                    View childAt = chipGroup.getChildAt(i10);
                    if ((childAt instanceof Chip) && chipGroup.getChildAt(i10).getVisibility() == 0) {
                        if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    i10++;
                }
                i = i11;
            } else {
                i = -1;
            }
            Object tag = getTag(f.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) u0.d.a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i, 1, false, isChecked()).f12060v);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.K != i) {
            this.K = i;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.G
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.G
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.C
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.O
            if (r0 == 0) goto L43
            v9.a r0 = r5.N
            r0.w(r2, r2)
        L43:
            r0 = r2
            goto L46
        L45:
            r0 = r3
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.M = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.B) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // o.p, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.B) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // o.p, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.H(z10);
        }
    }

    public void setCheckableResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.H(cVar.J0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        c cVar = this.f2837z;
        if (cVar == null) {
            this.F = z10;
        } else if (cVar.f13538v0) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.I(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.I(j4.i(cVar.J0, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.J(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.J(i0.c.c(cVar.J0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.K(cVar.J0.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.f13514d0 == colorStateList) {
            return;
        }
        cVar.f13514d0 = colorStateList;
        cVar.onStateChange(cVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateListC;
        c cVar = this.f2837z;
        if (cVar == null || cVar.f13514d0 == (colorStateListC = i0.c.c(cVar.J0, i))) {
            return;
        }
        cVar.f13514d0 = colorStateListC;
        cVar.onStateChange(cVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.L(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.L(cVar.J0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(c cVar) {
        c cVar2 = this.f2837z;
        if (cVar2 != cVar) {
            if (cVar2 != null) {
                cVar2.f13519f1 = new WeakReference(null);
            }
            this.f2837z = cVar;
            cVar.f13523h1 = false;
            cVar.f13519f1 = new WeakReference(this);
            c(this.L);
        }
    }

    public void setChipEndPadding(float f) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.I0 == f) {
            return;
        }
        cVar.I0 = f;
        cVar.invalidateSelf();
        cVar.F();
    }

    public void setChipEndPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            float dimension = cVar.J0.getResources().getDimension(i);
            if (cVar.I0 != dimension) {
                cVar.I0 = dimension;
                cVar.invalidateSelf();
                cVar.F();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.M(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.M(j4.i(cVar.J0, i));
        }
    }

    public void setChipIconSize(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.N(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.N(cVar.J0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.O(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.O(i0.c.c(cVar.J0, i));
        }
    }

    public void setChipIconVisible(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.P(cVar.J0.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.f13516e0 == f) {
            return;
        }
        cVar.f13516e0 = f;
        cVar.invalidateSelf();
        cVar.F();
    }

    public void setChipMinHeightResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            float dimension = cVar.J0.getResources().getDimension(i);
            if (cVar.f13516e0 != dimension) {
                cVar.f13516e0 = dimension;
                cVar.invalidateSelf();
                cVar.F();
            }
        }
    }

    public void setChipStartPadding(float f) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.B0 == f) {
            return;
        }
        cVar.B0 = f;
        cVar.invalidateSelf();
        cVar.F();
    }

    public void setChipStartPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            float dimension = cVar.J0.getResources().getDimension(i);
            if (cVar.B0 != dimension) {
                cVar.B0 = dimension;
                cVar.invalidateSelf();
                cVar.F();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.Q(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.Q(i0.c.c(cVar.J0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.R(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.R(cVar.J0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.S(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.f13537u0 == charSequence) {
            return;
        }
        String str = r0.b.f10833b;
        r0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? r0.b.f10836e : r0.b.f10835d;
        bVar.getClass();
        o4 o4Var = r0.f.f10843a;
        cVar.f13537u0 = bVar.c(charSequence);
        cVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.T(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.T(cVar.J0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.S(j4.i(cVar.J0, i));
        }
        e();
    }

    public void setCloseIconSize(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.U(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.U(cVar.J0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.V(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.V(cVar.J0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.X(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.X(i0.c.c(cVar.J0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // o.p, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // o.p, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i10, int i11, int i12) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i10, i11, i12);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i10, int i11, int i12) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i10, i11, i12);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.p(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2837z == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.f13521g1 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.J = z10;
        c(this.L);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(l9.d dVar) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.A0 = dVar;
        }
    }

    public void setHideMotionSpecResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.A0 = l9.d.b(cVar.J0, i);
        }
    }

    public void setIconEndPadding(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.Z(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.Z(cVar.J0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.a0(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.a0(cVar.J0.getResources().getDimension(i));
        }
    }

    @Override // da.h
    public void setInternalOnCheckedChangeListener(g gVar) {
        this.E = gVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f2837z == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.f13525i1 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.D = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
        e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.b0(colorStateList);
        }
        this.f2837z.getClass();
        f();
    }

    public void setRippleColorResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.b0(i0.c.c(cVar.J0, i));
            this.f2837z.getClass();
            f();
        }
    }

    @Override // ka.w
    public void setShapeAppearanceModel(m mVar) {
        this.f2837z.setShapeAppearanceModel(mVar);
    }

    public void setShowMotionSpec(l9.d dVar) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.f13542z0 = dVar;
        }
    }

    public void setShowMotionSpecResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.f13542z0 = l9.d.b(cVar.J0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        c cVar = this.f2837z;
        if (cVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(cVar.f13523h1 ? null : charSequence, bufferType);
        c cVar2 = this.f2837z;
        if (cVar2 == null || TextUtils.equals(cVar2.f13526j0, charSequence)) {
            return;
        }
        cVar2.f13526j0 = charSequence;
        cVar2.P0.f3571e = true;
        cVar2.invalidateSelf();
        cVar2.F();
    }

    public void setTextAppearance(d dVar) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.P0.b(dVar, cVar.J0);
        }
        h();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.F0 == f) {
            return;
        }
        cVar.F0 = f;
        cVar.invalidateSelf();
        cVar.F();
    }

    public void setTextEndPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            float dimension = cVar.J0.getResources().getDimension(i);
            if (cVar.F0 != dimension) {
                cVar.F0 = dimension;
                cVar.invalidateSelf();
                cVar.F();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        c cVar = this.f2837z;
        if (cVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            b0 b0Var = cVar.P0;
            d dVar = b0Var.f3572g;
            if (dVar != null) {
                dVar.f5865l = fApplyDimension;
                b0Var.f3567a.setTextSize(fApplyDimension);
                cVar.a();
            }
        }
        h();
    }

    public void setTextStartPadding(float f) {
        c cVar = this.f2837z;
        if (cVar == null || cVar.E0 == f) {
            return;
        }
        cVar.E0 = f;
        cVar.invalidateSelf();
        cVar.F();
    }

    public void setTextStartPaddingResource(int i) {
        c cVar = this.f2837z;
        if (cVar != null) {
            float dimension = cVar.J0.getResources().getDimension(i);
            if (cVar.E0 != dimension) {
                cVar.E0 = dimension;
                cVar.invalidateSelf();
                cVar.F();
            }
        }
    }

    public void setCloseIconVisible(boolean z10) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.Y(z10);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z10) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.K(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        c cVar = this.f2837z;
        if (cVar != null) {
            cVar.P(z10);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        c cVar = this.f2837z;
        if (cVar != null) {
            Context context2 = cVar.J0;
            cVar.P0.b(new d(context2, i), context2);
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        c cVar = this.f2837z;
        if (cVar != null) {
            Context context = cVar.J0;
            cVar.P0.b(new d(context, i), context);
        }
        h();
    }
}
