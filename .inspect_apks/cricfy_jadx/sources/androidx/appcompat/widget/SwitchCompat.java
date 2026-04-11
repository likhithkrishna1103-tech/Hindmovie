package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.m;
import com.google.android.gms.internal.measurement.j4;
import g.j;
import java.util.WeakHashMap;
import m1.h;
import o.f3;
import o.n1;
import o.u;
import o.w0;
import o.x3;
import t0.m0;
import t0.z;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final l5.b f581p0 = new l5.b(Float.class, "thumbPos", 7);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int[] f582q0 = {R.attr.state_checked};
    public Drawable A;
    public ColorStateList B;
    public PorterDuff.Mode C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public CharSequence J;
    public CharSequence K;
    public CharSequence L;
    public CharSequence M;
    public boolean N;
    public int O;
    public final int P;
    public float Q;
    public float R;
    public final VelocityTracker S;
    public final int T;
    public float U;
    public int V;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f583a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f584b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f585c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f586d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f587e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f588f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final TextPaint f589g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final ColorStateList f590h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public StaticLayout f591i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public StaticLayout f592j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final l.a f593k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public ObjectAnimator f594l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public u f595m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public h f596n0;
    public final Rect o0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ColorStateList f598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PorterDuff.Mode f599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f601z;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchCompat(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = g.a.switchStyle;
        super(context, attributeSet, i);
        this.f598w = null;
        this.f599x = null;
        this.f600y = false;
        this.f601z = false;
        this.B = null;
        this.C = null;
        this.D = false;
        this.E = false;
        this.S = VelocityTracker.obtain();
        this.f588f0 = true;
        this.o0 = new Rect();
        f3.a(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.f589g0 = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        l7.a aVarF = l7.a.F(context, attributeSet, j.SwitchCompat, i);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        m0.m(this, context, j.SwitchCompat, attributeSet, typedArray, i);
        Drawable drawableU = aVarF.u(j.SwitchCompat_android_thumb);
        this.f597v = drawableU;
        if (drawableU != null) {
            drawableU.setCallback(this);
        }
        Drawable drawableU2 = aVarF.u(j.SwitchCompat_track);
        this.A = drawableU2;
        if (drawableU2 != null) {
            drawableU2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(j.SwitchCompat_android_textOn));
        setTextOffInternal(typedArray.getText(j.SwitchCompat_android_textOff));
        this.N = typedArray.getBoolean(j.SwitchCompat_showText, true);
        this.F = typedArray.getDimensionPixelSize(j.SwitchCompat_thumbTextPadding, 0);
        this.G = typedArray.getDimensionPixelSize(j.SwitchCompat_switchMinWidth, 0);
        this.H = typedArray.getDimensionPixelSize(j.SwitchCompat_switchPadding, 0);
        this.I = typedArray.getBoolean(j.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListR = aVarF.r(j.SwitchCompat_thumbTint);
        if (colorStateListR != null) {
            this.f598w = colorStateListR;
            this.f600y = true;
        }
        PorterDuff.Mode modeC = n1.c(typedArray.getInt(j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f599x != modeC) {
            this.f599x = modeC;
            this.f601z = true;
        }
        if (this.f600y || this.f601z) {
            a();
        }
        ColorStateList colorStateListR2 = aVarF.r(j.SwitchCompat_trackTint);
        if (colorStateListR2 != null) {
            this.B = colorStateListR2;
            this.D = true;
        }
        PorterDuff.Mode modeC2 = n1.c(typedArray.getInt(j.SwitchCompat_trackTintMode, -1), null);
        if (this.C != modeC2) {
            this.C = modeC2;
            this.E = true;
        }
        if (this.D || this.E) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(j.SwitchCompat_switchTextAppearance, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, j.TextAppearance);
            int i10 = j.TextAppearance_android_textColor;
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(i10) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(i10, 0)) == 0 || (colorStateList = i0.c.c(context, resourceId)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(i10) : colorStateList;
            if (colorStateList != null) {
                this.f590h0 = colorStateList;
            } else {
                this.f590h0 = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.TextAppearance_android_textSize, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i11 = typedArrayObtainStyledAttributes.getInt(j.TextAppearance_android_typeface, -1);
            int i12 = typedArrayObtainStyledAttributes.getInt(j.TextAppearance_android_textStyle, -1);
            Typeface typeface = i11 != 1 ? i11 != 2 ? i11 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i12 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i12) : Typeface.create(typeface, i12);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i13 = i12 & (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0));
                textPaint.setFakeBoldText((i13 & 1) != 0);
                textPaint.setTextSkewX((i13 & 2) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(j.TextAppearance_textAllCaps, false)) {
                Context context2 = getContext();
                l.a aVar = new l.a();
                aVar.f7599v = context2.getResources().getConfiguration().locale;
                this.f593k0 = aVar;
            } else {
                this.f593k0 = null;
            }
            setTextOnInternal(this.J);
            setTextOffInternal(this.L);
            typedArrayObtainStyledAttributes.recycle();
        }
        new w0(this).f(attributeSet, i);
        aVarF.G();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.P = viewConfiguration.getScaledTouchSlop();
        this.T = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private u getEmojiTextViewHelper() {
        if (this.f595m0 == null) {
            this.f595m0 = new u(this);
        }
        return this.f595m0;
    }

    private boolean getTargetCheckedState() {
        return this.U > 0.5f;
    }

    private int getThumbOffset() {
        boolean z10 = x3.f9407a;
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.U : this.U) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.A;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.o0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f597v;
        Rect rectB = drawable2 != null ? n1.b(drawable2) : n1.f9277c;
        return ((((this.V - this.f583a0) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.L = charSequence;
        TransformationMethod transformationMethodE = ((u8.a) getEmojiTextViewHelper().f9373b.f7483w).E(this.f593k0);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.M = charSequence;
        this.f592j0 = null;
        if (this.N) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.J = charSequence;
        TransformationMethod transformationMethodE = ((u8.a) getEmojiTextViewHelper().f9373b.f7483w).E(this.f593k0);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.K = charSequence;
        this.f591i0 = null;
        if (this.N) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f597v;
        if (drawable != null) {
            if (this.f600y || this.f601z) {
                Drawable drawableMutate = drawable.mutate();
                this.f597v = drawableMutate;
                if (this.f600y) {
                    drawableMutate.setTintList(this.f598w);
                }
                if (this.f601z) {
                    this.f597v.setTintMode(this.f599x);
                }
                if (this.f597v.isStateful()) {
                    this.f597v.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.A;
        if (drawable != null) {
            if (this.D || this.E) {
                Drawable drawableMutate = drawable.mutate();
                this.A = drawableMutate;
                if (this.D) {
                    drawableMutate.setTintList(this.B);
                }
                if (this.E) {
                    this.A.setTintMode(this.C);
                }
                if (this.A.isStateful()) {
                    this.A.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.J);
        setTextOffInternal(this.L);
        requestLayout();
    }

    public final void d() {
        if (this.f596n0 == null && ((u8.a) this.f595m0.f9373b.f7483w).u() && m.f863k != null) {
            m mVarA = m.a();
            int iB = mVarA.b();
            if (iB == 3 || iB == 0) {
                h hVar = new h(this);
                this.f596n0 = hVar;
                mVarA.f(hVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i10;
        int i11 = this.f584b0;
        int i12 = this.f585c0;
        int i13 = this.f586d0;
        int i14 = this.f587e0;
        int thumbOffset = getThumbOffset() + i11;
        Drawable drawable = this.f597v;
        Rect rectB = drawable != null ? n1.b(drawable) : n1.f9277c;
        Drawable drawable2 = this.A;
        Rect rect = this.o0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i15 = rect.left;
            thumbOffset += i15;
            if (rectB != null) {
                int i16 = rectB.left;
                if (i16 > i15) {
                    i11 += i16 - i15;
                }
                int i17 = rectB.top;
                int i18 = rect.top;
                i = i17 > i18 ? (i17 - i18) + i12 : i12;
                int i19 = rectB.right;
                int i20 = rect.right;
                if (i19 > i20) {
                    i13 -= i19 - i20;
                }
                int i21 = rectB.bottom;
                int i22 = rect.bottom;
                if (i21 > i22) {
                    i10 = i14 - (i21 - i22);
                }
                this.A.setBounds(i11, i, i13, i10);
            } else {
                i = i12;
            }
            i10 = i14;
            this.A.setBounds(i11, i, i13, i10);
        }
        Drawable drawable3 = this.f597v;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i23 = thumbOffset - rect.left;
            int i24 = thumbOffset + this.f583a0 + rect.right;
            this.f597v.setBounds(i23, i12, i24, i14);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i23, i12, i24, i14);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f10) {
        super.drawableHotspotChanged(f, f10);
        Drawable drawable = this.f597v;
        if (drawable != null) {
            drawable.setHotspot(f, f10);
        }
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f597v;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.A;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z10 = x3.f9407a;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.V;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.H : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z10 = x3.f9407a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.V;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.H : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return v.v(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.N;
    }

    public boolean getSplitTrack() {
        return this.I;
    }

    public int getSwitchMinWidth() {
        return this.G;
    }

    public int getSwitchPadding() {
        return this.H;
    }

    public CharSequence getTextOff() {
        return this.L;
    }

    public CharSequence getTextOn() {
        return this.J;
    }

    public Drawable getThumbDrawable() {
        return this.f597v;
    }

    public final float getThumbPosition() {
        return this.U;
    }

    public int getThumbTextPadding() {
        return this.F;
    }

    public ColorStateList getThumbTintList() {
        return this.f598w;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f599x;
    }

    public Drawable getTrackDrawable() {
        return this.A;
    }

    public ColorStateList getTrackTintList() {
        return this.B;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.C;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f597v;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f594l0;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f594l0.end();
        this.f594l0 = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f582q0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.A;
        Rect rect = this.o0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f585c0;
        int i10 = this.f587e0;
        int i11 = i + rect.top;
        int i12 = i10 - rect.bottom;
        Drawable drawable2 = this.f597v;
        if (drawable != null) {
            if (!this.I || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = n1.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.f591i0 : this.f592j0;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.f589g0;
            ColorStateList colorStateList = this.f590h0;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i11 + i12) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.J : this.L;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z10, i, i10, i11, i12);
        int iMax2 = 0;
        if (this.f597v != null) {
            Drawable drawable = this.A;
            Rect rect = this.o0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = n1.b(this.f597v);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        boolean z11 = x3.f9407a;
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.V + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.V) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i13 = this.W;
            int i14 = height2 - (i13 / 2);
            height = i13 + i14;
            paddingTop = i14;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.W + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.W;
        }
        this.f584b0 = paddingLeft;
        this.f585c0 = paddingTop;
        this.f587e0 = height;
        this.f586d0 = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i10) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.N) {
            StaticLayout staticLayout = this.f591i0;
            TextPaint textPaint = this.f589g0;
            if (staticLayout == null) {
                CharSequence charSequence = this.K;
                this.f591i0 = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f592j0 == null) {
                CharSequence charSequence2 = this.M;
                this.f592j0 = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f597v;
        Rect rect = this.o0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f597v.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f597v.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f583a0 = Math.max(this.N ? (this.F * 2) + Math.max(this.f591i0.getWidth(), this.f592j0.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.A.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f597v;
        if (drawable3 != null) {
            Rect rectB = n1.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        int iMax3 = this.f588f0 ? Math.max(this.G, (this.f583a0 * 2) + iMax + iMax2) : this.G;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.V = iMax3;
        this.W = iMax4;
        super.onMeasure(i, i10);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.J : this.L;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object string = this.J;
                if (string == null) {
                    string = getResources().getString(g.h.abc_capital_on);
                }
                Object obj = string;
                WeakHashMap weakHashMap = m0.f11777a;
                new z(g0.c.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object string2 = this.L;
            if (string2 == null) {
                string2 = getResources().getString(g.h.abc_capital_off);
            }
            Object obj2 = string2;
            WeakHashMap weakHashMap2 = m0.f11777a;
            new z(g0.c.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.f594l0;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f581p0, zIsChecked ? 1.0f : 0.0f);
        this.f594l0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.f594l0.setAutoCancel(true);
        this.f594l0.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(v.w(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
        setTextOnInternal(this.J);
        setTextOffInternal(this.L);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.f588f0 = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.N != z10) {
            this.N = z10;
            requestLayout();
            if (z10) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.I = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.G = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.H = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f589g0;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.L;
        if (string == null) {
            string = getResources().getString(g.h.abc_capital_off);
        }
        WeakHashMap weakHashMap = m0.f11777a;
        new z(g0.c.tag_state_description, CharSequence.class, 64, 30, 2).f(this, string);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.J;
        if (string == null) {
            string = getResources().getString(g.h.abc_capital_on);
        }
        WeakHashMap weakHashMap = m0.f11777a;
        new z(g0.c.tag_state_description, CharSequence.class, 64, 30, 2).f(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f597v;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f597v = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.U = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(j4.i(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.F = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f598w = colorStateList;
        this.f600y = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f599x = mode;
        this.f601z = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.A = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(j4.i(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.B = colorStateList;
        this.D = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.C = mode;
        this.E = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f597v || drawable == this.A;
    }
}
