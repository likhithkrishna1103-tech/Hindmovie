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
import b9.a;
import b9.c;
import b9.d;
import b9.e;
import j9.a0;
import j9.e0;
import j9.f0;
import j9.g;
import j9.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import n.q;
import p8.b;
import p8.f;
import p8.k;
import p8.l;
import q0.o0;
import q9.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class Chip extends q implements d, u, h {
    public static final int R = k.Widget_MaterialComponents_Chip_Action;
    public static final Rect S = new Rect();
    public static final int[] T = {R.attr.state_selected};
    public static final int[] U = {R.attr.state_checkable};
    public RippleDrawable A;
    public View.OnClickListener B;
    public CompoundButton.OnCheckedChangeListener C;
    public g D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public int K;
    public CharSequence L;
    public final c M;
    public boolean N;
    public final Rect O;
    public final RectF P;
    public final a Q;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f3378y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public InsetDrawable f3379z;

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = b.chipStyle;
        int i10 = R;
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.O = new Rect();
        this.P = new RectF();
        this.Q = new a(0, this);
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
        e eVar = new e(context2, attributeSet, i);
        TypedArray typedArrayD = e0.d(eVar.f1973z0, attributeSet, l.Chip, i, i10, new int[0]);
        eVar.Z0 = typedArrayD.hasValue(l.Chip_shapeAppearance);
        int i11 = l.Chip_chipSurfaceColor;
        Context context3 = eVar.f1973z0;
        ColorStateList colorStateListI = a.a.i(context3, typedArrayD, i11);
        if (eVar.S != colorStateListI) {
            eVar.S = colorStateListI;
            eVar.onStateChange(eVar.getState());
        }
        ColorStateList colorStateListI2 = a.a.i(context3, typedArrayD, l.Chip_chipBackgroundColor);
        if (eVar.T != colorStateListI2) {
            eVar.T = colorStateListI2;
            eVar.onStateChange(eVar.getState());
        }
        float dimension = typedArrayD.getDimension(l.Chip_chipMinHeight, 0.0f);
        if (eVar.U != dimension) {
            eVar.U = dimension;
            eVar.invalidateSelf();
            eVar.y();
        }
        if (typedArrayD.hasValue(l.Chip_chipCornerRadius)) {
            eVar.E(typedArrayD.getDimension(l.Chip_chipCornerRadius, 0.0f));
        }
        eVar.J(a.a.i(context3, typedArrayD, l.Chip_chipStrokeColor));
        eVar.K(typedArrayD.getDimension(l.Chip_chipStrokeWidth, 0.0f));
        eVar.T(a.a.i(context3, typedArrayD, l.Chip_rippleColor));
        String text = typedArrayD.getText(l.Chip_android_text);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(eVar.Z, text);
        a0 a0Var = eVar.F0;
        if (!zEquals) {
            eVar.Z = text;
            a0Var.f6840e = true;
            eVar.invalidateSelf();
            eVar.y();
        }
        int i12 = l.Chip_android_textAppearance;
        n9.d dVar = (!typedArrayD.hasValue(i12) || (resourceId = typedArrayD.getResourceId(i12, 0)) == 0) ? null : new n9.d(context3, resourceId);
        dVar.f8869k = typedArrayD.getDimension(l.Chip_android_textSize, dVar.f8869k);
        a0Var.b(dVar, context3);
        int i13 = typedArrayD.getInt(l.Chip_android_ellipsize, 0);
        if (i13 == 1) {
            eVar.W0 = TextUtils.TruncateAt.START;
        } else if (i13 == 2) {
            eVar.W0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i13 == 3) {
            eVar.W0 = TextUtils.TruncateAt.END;
        }
        eVar.I(typedArrayD.getBoolean(l.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            eVar.I(typedArrayD.getBoolean(l.Chip_chipIconEnabled, false));
        }
        eVar.F(a.a.m(context3, typedArrayD, l.Chip_chipIcon));
        if (typedArrayD.hasValue(l.Chip_chipIconTint)) {
            eVar.H(a.a.i(context3, typedArrayD, l.Chip_chipIconTint));
        }
        eVar.G(typedArrayD.getDimension(l.Chip_chipIconSize, -1.0f));
        eVar.Q(typedArrayD.getBoolean(l.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            eVar.Q(typedArrayD.getBoolean(l.Chip_closeIconEnabled, false));
        }
        eVar.L(a.a.m(context3, typedArrayD, l.Chip_closeIcon));
        eVar.P(a.a.i(context3, typedArrayD, l.Chip_closeIconTint));
        eVar.N(typedArrayD.getDimension(l.Chip_closeIconSize, 0.0f));
        eVar.A(typedArrayD.getBoolean(l.Chip_android_checkable, false));
        eVar.D(typedArrayD.getBoolean(l.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            eVar.D(typedArrayD.getBoolean(l.Chip_checkedIconEnabled, false));
        }
        eVar.B(a.a.m(context3, typedArrayD, l.Chip_checkedIcon));
        if (typedArrayD.hasValue(l.Chip_checkedIconTint)) {
            eVar.C(a.a.i(context3, typedArrayD, l.Chip_checkedIconTint));
        }
        eVar.f1963p0 = q8.d.a(context3, typedArrayD, l.Chip_showMotionSpec);
        eVar.f1964q0 = q8.d.a(context3, typedArrayD, l.Chip_hideMotionSpec);
        float dimension2 = typedArrayD.getDimension(l.Chip_chipStartPadding, 0.0f);
        if (eVar.f1965r0 != dimension2) {
            eVar.f1965r0 = dimension2;
            eVar.invalidateSelf();
            eVar.y();
        }
        eVar.S(typedArrayD.getDimension(l.Chip_iconStartPadding, 0.0f));
        eVar.R(typedArrayD.getDimension(l.Chip_iconEndPadding, 0.0f));
        float dimension3 = typedArrayD.getDimension(l.Chip_textStartPadding, 0.0f);
        if (eVar.f1968u0 != dimension3) {
            eVar.f1968u0 = dimension3;
            eVar.invalidateSelf();
            eVar.y();
        }
        float dimension4 = typedArrayD.getDimension(l.Chip_textEndPadding, 0.0f);
        if (eVar.f1969v0 != dimension4) {
            eVar.f1969v0 = dimension4;
            eVar.invalidateSelf();
            eVar.y();
        }
        eVar.O(typedArrayD.getDimension(l.Chip_closeIconStartPadding, 0.0f));
        eVar.M(typedArrayD.getDimension(l.Chip_closeIconEndPadding, 0.0f));
        float dimension5 = typedArrayD.getDimension(l.Chip_chipEndPadding, 0.0f);
        if (eVar.f1972y0 != dimension5) {
            eVar.f1972y0 = dimension5;
            eVar.invalidateSelf();
            eVar.y();
        }
        eVar.Y0 = typedArrayD.getDimensionPixelSize(l.Chip_android_maxWidth, Integer.MAX_VALUE);
        typedArrayD.recycle();
        int[] iArr = l.Chip;
        e0.a(context2, attributeSet, i, i10);
        e0.b(context2, attributeSet, iArr, i, i10, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, i10);
        this.I = typedArrayObtainStyledAttributes.getBoolean(l.Chip_ensureMinTouchTargetSize, false);
        this.K = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(l.Chip_chipMinTouchTargetSize, (float) Math.ceil(f0.b(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(eVar);
        eVar.k(q0.f0.e(this));
        int[] iArr2 = l.Chip;
        e0.a(context2, attributeSet, i, i10);
        e0.b(context2, attributeSet, iArr2, i, i10, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr2, i, i10);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(l.Chip_shapeAppearance);
        typedArrayObtainStyledAttributes2.recycle();
        this.M = new c(this, this);
        d();
        if (!zHasValue) {
            setOutlineProvider(new b9.b(0, this));
        }
        setChecked(this.E);
        setText(eVar.Z);
        setEllipsize(eVar.W0);
        g();
        if (!this.f3378y.X0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.I) {
            setMinHeight(this.K);
        }
        this.J = getLayoutDirection();
        super.setOnCheckedChangeListener(new hc.h(2, this));
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.P;
        rectF.setEmpty();
        if (c() && this.B != null) {
            e eVar = this.f3378y;
            Rect bounds = eVar.getBounds();
            rectF.setEmpty();
            if (eVar.W()) {
                float f = eVar.f1972y0 + eVar.f1971x0 + eVar.f1958j0 + eVar.f1970w0 + eVar.f1969v0;
                if (eVar.getLayoutDirection() == 0) {
                    float f4 = bounds.right;
                    rectF.right = f4;
                    rectF.left = f4 - f;
                } else {
                    float f10 = bounds.left;
                    rectF.left = f10;
                    rectF.right = f10 + f;
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
        Rect rect = this.O;
        rect.set(i, i10, i11, i12);
        return rect;
    }

    private n9.d getTextAppearance() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.F0.f6841g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.G != z2) {
            this.G = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.F != z2) {
            this.F = z2;
            refreshDrawableState();
        }
    }

    public final void b(int i) {
        this.K = i;
        if (!this.I) {
            InsetDrawable insetDrawable = this.f3379z;
            if (insetDrawable == null) {
                int[] iArr = o9.a.f9444a;
                e();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f3379z = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = o9.a.f9444a;
                    e();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.f3378y.U));
        int iMax2 = Math.max(0, i - this.f3378y.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f3379z;
            if (insetDrawable2 == null) {
                int[] iArr3 = o9.a.f9444a;
                e();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f3379z = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = o9.a.f9444a;
                    e();
                    return;
                }
                return;
            }
        }
        int i10 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i11 = iMax > 0 ? iMax / 2 : 0;
        if (this.f3379z != null) {
            Rect rect = new Rect();
            this.f3379z.getPadding(rect);
            if (rect.top == i11 && rect.bottom == i11 && rect.left == i10 && rect.right == i10) {
                int[] iArr5 = o9.a.f9444a;
                e();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.f3379z = new InsetDrawable((Drawable) this.f3378y, i10, i11, i10, i11);
        int[] iArr6 = o9.a.f9444a;
        e();
    }

    public final boolean c() {
        e eVar = this.f3378y;
        if (eVar == null) {
            return false;
        }
        Object obj = eVar.f1955g0;
        if (obj == null) {
            obj = null;
        } else if (obj instanceof j0.c) {
            obj = null;
        }
        return obj != null;
    }

    public final void d() {
        e eVar;
        if (!c() || (eVar = this.f3378y) == null || !eVar.f1954f0 || this.B == null) {
            o0.n(this, null);
            this.N = false;
        } else {
            o0.n(this, this.M);
            this.N = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.N
            if (r0 != 0) goto L9
            boolean r9 = super.dispatchHoverEvent(r9)
            return r9
        L9:
            b9.c r0 = r8.M
            android.view.accessibility.AccessibilityManager r1 = r0.f14427h
            boolean r2 = r1.isEnabled()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L6b
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L1c
            goto L6b
        L1c:
            int r1 = r9.getAction()
            r2 = 7
            r5 = 256(0x100, float:3.59E-43)
            r6 = 128(0x80, float:1.8E-43)
            if (r1 == r2) goto L42
            r2 = 9
            if (r1 == r2) goto L42
            r2 = 10
            if (r1 == r2) goto L30
            goto L6b
        L30:
            int r1 = r0.f14431m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r2) goto L6b
            if (r1 != r2) goto L39
            goto L71
        L39:
            r0.f14431m = r2
            r0.q(r2, r6)
            r0.q(r1, r5)
            return r4
        L42:
            float r1 = r9.getX()
            float r9 = r9.getY()
            com.google.android.material.chip.Chip r2 = r0.f1947q
            boolean r7 = r2.c()
            if (r7 == 0) goto L5d
            android.graphics.RectF r2 = r2.getCloseIconTouchBounds()
            boolean r9 = r2.contains(r1, r9)
            if (r9 == 0) goto L5d
            r3 = r4
        L5d:
            int r9 = r0.f14431m
            if (r9 != r3) goto L62
            goto L71
        L62:
            r0.f14431m = r3
            r0.q(r3, r6)
            r0.q(r9, r5)
            return r4
        L6b:
            boolean r9 = super.dispatchHoverEvent(r9)
            if (r9 == 0) goto L72
        L71:
            return r4
        L72:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.N
            if (r0 != 0) goto L9
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L9:
            b9.c r0 = r9.M
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 0
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1
            if (r1 == r4) goto L9d
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L87
            r5 = 66
            if (r1 == r5) goto L58
            switch(r1) {
                case 19: goto L2a;
                case 20: goto L2a;
                case 21: goto L2a;
                case 22: goto L2a;
                case 23: goto L58;
                default: goto L28;
            }
        L28:
            goto L9d
        L2a:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L9d
            r7 = 19
            if (r1 == r7) goto L42
            r7 = 21
            if (r1 == r7) goto L3f
            r7 = 22
            if (r1 == r7) goto L44
            r5 = 130(0x82, float:1.82E-43)
            goto L44
        L3f:
            r5 = 17
            goto L44
        L42:
            r5 = 33
        L44:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r4
            r7 = r2
        L4a:
            if (r2 >= r1) goto L56
            boolean r8 = r0.m(r5, r6)
            if (r8 == 0) goto L56
            int r2 = r2 + 1
            r7 = r4
            goto L4a
        L56:
            r2 = r7
            goto L9d
        L58:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L9d
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L9d
            int r1 = r0.f14430l
            if (r1 == r3) goto L85
            com.google.android.material.chip.Chip r5 = r0.f1947q
            if (r1 != 0) goto L70
            r5.performClick()
            goto L85
        L70:
            if (r1 != r4) goto L85
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r1 = r5.B
            if (r1 == 0) goto L7c
            r1.onClick(r5)
        L7c:
            boolean r1 = r5.N
            if (r1 == 0) goto L85
            b9.c r1 = r5.M
            r1.q(r4, r4)
        L85:
            r2 = r4
            goto L9d
        L87:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L93
            r1 = 2
            boolean r2 = r0.m(r1, r6)
            goto L9d
        L93:
            boolean r1 = r10.hasModifiers(r4)
            if (r1 == 0) goto L9d
            boolean r2 = r0.m(r4, r6)
        L9d:
            if (r2 == 0) goto La4
            int r0 = r0.f14430l
            if (r0 == r3) goto La4
            return r4
        La4:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // n.q, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i;
        super.drawableStateChanged();
        e eVar = this.f3378y;
        boolean z2 = false;
        if (eVar != null && e.x(eVar.f1955g0)) {
            e eVar2 = this.f3378y;
            ?? IsEnabled = isEnabled();
            int i10 = IsEnabled;
            if (this.H) {
                i10 = IsEnabled + 1;
            }
            int i11 = i10;
            if (this.G) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (this.F) {
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
            } else {
                i = 0;
            }
            if (this.H) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.G) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.F) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            if (!Arrays.equals(eVar2.T0, iArr)) {
                eVar2.T0 = iArr;
                if (eVar2.W()) {
                    z2 = eVar2.z(eVar2.getState(), iArr);
                }
            }
        }
        if (z2) {
            invalidate();
        }
    }

    public final void e() {
        this.A = new RippleDrawable(o9.a.c(this.f3378y.Y), getBackgroundDrawable(), null);
        this.f3378y.getClass();
        RippleDrawable rippleDrawable = this.A;
        WeakHashMap weakHashMap = o0.f10475a;
        setBackground(rippleDrawable);
        f();
    }

    public final void f() {
        e eVar;
        if (TextUtils.isEmpty(getText()) || (eVar = this.f3378y) == null) {
            return;
        }
        int iU = (int) (eVar.u() + eVar.f1972y0 + eVar.f1969v0);
        e eVar2 = this.f3378y;
        int iT = (int) (eVar2.t() + eVar2.f1965r0 + eVar2.f1968u0);
        if (this.f3379z != null) {
            Rect rect = new Rect();
            this.f3379z.getPadding(rect);
            iT += rect.left;
            iU += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = o0.f10475a;
        setPaddingRelative(iT, paddingTop, iU, paddingBottom);
    }

    public final void g() {
        TextPaint paint = getPaint();
        e eVar = this.f3378y;
        if (eVar != null) {
            paint.drawableState = eVar.getState();
        }
        n9.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.Q);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.L)) {
            return this.L;
        }
        e eVar = this.f3378y;
        if (eVar == null || !eVar.l0) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).B.f6834d) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f3379z;
        return insetDrawable == null ? this.f3378y : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1961n0;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1962o0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.T;
        }
        return null;
    }

    public float getChipCornerRadius() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return Math.max(0.0f, eVar.v());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f3378y;
    }

    public float getChipEndPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1972y0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        e eVar = this.f3378y;
        if (eVar == null || (drawable = eVar.f1950b0) == 0) {
            return null;
        }
        if (!(drawable instanceof j0.c)) {
            return drawable;
        }
        return null;
    }

    public float getChipIconSize() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1952d0;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1951c0;
        }
        return null;
    }

    public float getChipMinHeight() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.U;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1965r0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.W;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.X;
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
        e eVar = this.f3378y;
        if (eVar == null || (drawable = eVar.f1955g0) == 0) {
            return null;
        }
        if (!(drawable instanceof j0.c)) {
            return drawable;
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1959k0;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1971x0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1958j0;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1970w0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1957i0;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.W0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.N) {
            c cVar = this.M;
            if (cVar.f14430l == 1 || cVar.f14429k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public q8.d getHideMotionSpec() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1964q0;
        }
        return null;
    }

    public float getIconEndPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1967t0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1966s0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.Y;
        }
        return null;
    }

    public q9.k getShapeAppearanceModel() {
        return this.f3378y.f11105u.f11090a;
    }

    public q8.d getShowMotionSpec() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1963p0;
        }
        return null;
    }

    public float getTextEndPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1969v0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        e eVar = this.f3378y;
        if (eVar != null) {
            return eVar.f1968u0;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i5.a.N(this, this.f3378y);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, T);
        }
        e eVar = this.f3378y;
        if (eVar != null && eVar.l0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, U);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z2, int i, Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (this.N) {
            c cVar = this.M;
            int i10 = cVar.f14430l;
            if (i10 != Integer.MIN_VALUE) {
                cVar.j(i10);
            }
            if (z2) {
                cVar.m(i, rect);
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
        e eVar = this.f3378y;
        int i10 = 0;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.l0);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f6879w) {
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
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) e7.c.a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i, 1, false, isChecked()).f4586u);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.J != i) {
            this.J = i;
            f();
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
            boolean r0 = r5.F
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.F
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.B
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.N
            if (r0 == 0) goto L43
            b9.c r0 = r5.M
            r0.q(r2, r2)
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
        this.L = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.A) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // n.q, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.A) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // n.q, android.view.View
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

    public void setCheckable(boolean z2) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.A(z2);
        }
    }

    public void setCheckableResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.A(eVar.f1973z0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        e eVar = this.f3378y;
        if (eVar == null) {
            this.E = z2;
        } else if (eVar.l0) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.B(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.B(com.bumptech.glide.d.p(eVar.f1973z0, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.C(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.C(f0.c.c(eVar.f1973z0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.D(eVar.f1973z0.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.T == colorStateList) {
            return;
        }
        eVar.T = colorStateList;
        eVar.onStateChange(eVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateListC;
        e eVar = this.f3378y;
        if (eVar == null || eVar.T == (colorStateListC = f0.c.c(eVar.f1973z0, i))) {
            return;
        }
        eVar.T = colorStateListC;
        eVar.onStateChange(eVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.E(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.E(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(e eVar) {
        e eVar2 = this.f3378y;
        if (eVar2 != eVar) {
            if (eVar2 != null) {
                eVar2.V0 = new WeakReference(null);
            }
            this.f3378y = eVar;
            eVar.X0 = false;
            eVar.V0 = new WeakReference(this);
            b(this.K);
        }
    }

    public void setChipEndPadding(float f) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.f1972y0 == f) {
            return;
        }
        eVar.f1972y0 = f;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setChipEndPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            float dimension = eVar.f1973z0.getResources().getDimension(i);
            if (eVar.f1972y0 != dimension) {
                eVar.f1972y0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.F(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.F(com.bumptech.glide.d.p(eVar.f1973z0, i));
        }
    }

    public void setChipIconSize(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.G(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.G(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.H(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.H(f0.c.c(eVar.f1973z0, i));
        }
    }

    public void setChipIconVisible(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.I(eVar.f1973z0.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.U == f) {
            return;
        }
        eVar.U = f;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setChipMinHeightResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            float dimension = eVar.f1973z0.getResources().getDimension(i);
            if (eVar.U != dimension) {
                eVar.U = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setChipStartPadding(float f) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.f1965r0 == f) {
            return;
        }
        eVar.f1965r0 = f;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setChipStartPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            float dimension = eVar.f1973z0.getResources().getDimension(i);
            if (eVar.f1965r0 != dimension) {
                eVar.f1965r0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.J(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.J(f0.c.c(eVar.f1973z0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.K(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.K(eVar.f1973z0.getResources().getDimension(i));
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
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.L(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.f1959k0 == charSequence) {
            return;
        }
        String str = o0.b.f9035b;
        o0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? o0.b.f9038e : o0.b.f9037d;
        bVar.getClass();
        e6.f0 f0Var = o0.g.f9045a;
        eVar.f1959k0 = bVar.c(charSequence);
        eVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.M(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.M(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.L(com.bumptech.glide.d.p(eVar.f1973z0, i));
        }
        d();
    }

    public void setCloseIconSize(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.N(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.N(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.O(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.O(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.P(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.P(f0.c.c(eVar.f1973z0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // n.q, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // n.q, android.widget.TextView
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
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.k(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f3378y == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.W0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.I = z2;
        b(this.K);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(q8.d dVar) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.f1964q0 = dVar;
        }
    }

    public void setHideMotionSpecResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.f1964q0 = q8.d.b(eVar.f1973z0, i);
        }
    }

    public void setIconEndPadding(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.R(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.R(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.S(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.S(eVar.f1973z0.getResources().getDimension(i));
        }
    }

    @Override // j9.h
    public void setInternalOnCheckedChangeListener(g gVar) {
        this.D = gVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f3378y == null) {
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
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.Y0 = i;
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
        this.C = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.B = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.T(colorStateList);
        }
        this.f3378y.getClass();
        e();
    }

    public void setRippleColorResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.T(f0.c.c(eVar.f1973z0, i));
            this.f3378y.getClass();
            e();
        }
    }

    @Override // q9.u
    public void setShapeAppearanceModel(q9.k kVar) {
        this.f3378y.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(q8.d dVar) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.f1963p0 = dVar;
        }
    }

    public void setShowMotionSpecResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.f1963p0 = q8.d.b(eVar.f1973z0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        e eVar = this.f3378y;
        if (eVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(eVar.X0 ? null : charSequence, bufferType);
        e eVar2 = this.f3378y;
        if (eVar2 == null || TextUtils.equals(eVar2.Z, charSequence)) {
            return;
        }
        eVar2.Z = charSequence;
        eVar2.F0.f6840e = true;
        eVar2.invalidateSelf();
        eVar2.y();
    }

    public void setTextAppearance(n9.d dVar) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.F0.b(dVar, eVar.f1973z0);
        }
        g();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.f1969v0 == f) {
            return;
        }
        eVar.f1969v0 = f;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setTextEndPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            float dimension = eVar.f1973z0.getResources().getDimension(i);
            if (eVar.f1969v0 != dimension) {
                eVar.f1969v0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        e eVar = this.f3378y;
        if (eVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            a0 a0Var = eVar.F0;
            n9.d dVar = a0Var.f6841g;
            if (dVar != null) {
                dVar.f8869k = fApplyDimension;
                a0Var.f6836a.setTextSize(fApplyDimension);
                eVar.a();
            }
        }
        g();
    }

    public void setTextStartPadding(float f) {
        e eVar = this.f3378y;
        if (eVar == null || eVar.f1968u0 == f) {
            return;
        }
        eVar.f1968u0 = f;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setTextStartPaddingResource(int i) {
        e eVar = this.f3378y;
        if (eVar != null) {
            float dimension = eVar.f1973z0.getResources().getDimension(i);
            if (eVar.f1968u0 != dimension) {
                eVar.f1968u0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setCloseIconVisible(boolean z2) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.Q(z2);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z2) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.D(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        e eVar = this.f3378y;
        if (eVar != null) {
            eVar.I(z2);
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
        e eVar = this.f3378y;
        if (eVar != null) {
            Context context2 = eVar.f1973z0;
            eVar.F0.b(new n9.d(context2, i), context2);
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        e eVar = this.f3378y;
        if (eVar != null) {
            Context context = eVar.f1973z0;
            eVar.F0.b(new n9.d(context, i), context);
        }
        g();
    }
}
