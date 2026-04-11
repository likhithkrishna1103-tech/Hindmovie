package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import g5.h;
import j9.b0;
import j9.c;
import j9.e0;
import j9.f0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import n.d1;
import n.n1;
import n.t;
import p8.b;
import p8.d;
import p8.k;
import p8.l;
import q0.i0;
import q0.o0;
import q9.e;
import q9.f;
import q9.g;
import q9.i;
import q9.j;
import v9.m;
import v9.p;
import v9.q;
import v9.s;
import v9.u;
import v9.v;
import v9.w;
import v9.x;
import v9.y;
import x9.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int W0 = k.Widget_Design_TextInputLayout;
    public static final int[][] X0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public int A;
    public int A0;
    public int B;
    public Drawable B0;
    public int C;
    public ColorStateList C0;
    public final q D;
    public ColorStateList D0;
    public boolean E;
    public int E0;
    public int F;
    public int F0;
    public boolean G;
    public int G0;
    public x H;
    public ColorStateList H0;
    public d1 I;
    public int I0;
    public int J;
    public int J0;
    public int K;
    public int K0;
    public CharSequence L;
    public int L0;
    public boolean M;
    public int M0;
    public d1 N;
    public int N0;
    public ColorStateList O;
    public boolean O0;
    public int P;
    public final c P0;
    public h Q;
    public boolean Q0;
    public h R;
    public boolean R0;
    public ColorStateList S;
    public ValueAnimator S0;
    public ColorStateList T;
    public boolean T0;
    public ColorStateList U;
    public boolean U0;
    public ColorStateList V;
    public boolean V0;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CharSequence f3500a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f3501b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public g f3502c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public g f3503d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public StateListDrawable f3504e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f3505f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public g f3506g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public g f3507h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public q9.k f3508i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f3509j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final int f3510k0;
    public int l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3511m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3512n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f3513o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f3514p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f3515q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f3516r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final Rect f3517s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final Rect f3518t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FrameLayout f3519u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final RectF f3520u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u f3521v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public Typeface f3522v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final m f3523w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ColorDrawable f3524w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public EditText f3525x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f3526x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f3527y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final LinkedHashSet f3528y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3529z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ColorDrawable f3530z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        int i = b.textInputStyle;
        int i10 = W0;
        super(a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f3529z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = new q(this);
        this.H = new r2.h(11);
        this.f3517s0 = new Rect();
        this.f3518t0 = new Rect();
        this.f3520u0 = new RectF();
        this.f3528y0 = new LinkedHashSet();
        c cVar = new c(this);
        this.P0 = cVar;
        this.V0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f3519u = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = q8.a.f11072a;
        cVar.Q = linearInterpolator;
        cVar.h(false);
        cVar.P = linearInterpolator;
        cVar.h(false);
        if (cVar.f6856g != 8388659) {
            cVar.f6856g = 8388659;
            cVar.h(false);
        }
        kc.b bVarE = e0.e(context2, attributeSet, l.TextInputLayout, i, i10, l.TextInputLayout_counterTextAppearance, l.TextInputLayout_counterOverflowTextAppearance, l.TextInputLayout_errorTextAppearance, l.TextInputLayout_helperTextTextAppearance, l.TextInputLayout_hintTextAppearance);
        u uVar = new u(this, bVarE);
        this.f3521v = uVar;
        int i11 = l.TextInputLayout_hintEnabled;
        TypedArray typedArray = (TypedArray) bVarE.f7621w;
        this.W = typedArray.getBoolean(i11, true);
        setHint(typedArray.getText(l.TextInputLayout_android_hint));
        this.R0 = typedArray.getBoolean(l.TextInputLayout_hintAnimationEnabled, true);
        this.Q0 = typedArray.getBoolean(l.TextInputLayout_expandedHintEnabled, true);
        if (typedArray.hasValue(l.TextInputLayout_android_minEms)) {
            setMinEms(typedArray.getInt(l.TextInputLayout_android_minEms, -1));
        } else if (typedArray.hasValue(l.TextInputLayout_android_minWidth)) {
            setMinWidth(typedArray.getDimensionPixelSize(l.TextInputLayout_android_minWidth, -1));
        }
        if (typedArray.hasValue(l.TextInputLayout_android_maxEms)) {
            setMaxEms(typedArray.getInt(l.TextInputLayout_android_maxEms, -1));
        } else if (typedArray.hasValue(l.TextInputLayout_android_maxWidth)) {
            setMaxWidth(typedArray.getDimensionPixelSize(l.TextInputLayout_android_maxWidth, -1));
        }
        this.f3508i0 = q9.k.c(context2, attributeSet, i, i10).a();
        this.f3510k0 = context2.getResources().getDimensionPixelOffset(d.mtrl_textinput_box_label_cutout_padding);
        this.f3511m0 = typedArray.getDimensionPixelOffset(l.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f3513o0 = typedArray.getDimensionPixelSize(l.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(d.mtrl_textinput_box_stroke_width_default));
        this.f3514p0 = typedArray.getDimensionPixelSize(l.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(d.mtrl_textinput_box_stroke_width_focused));
        this.f3512n0 = this.f3513o0;
        float dimension = typedArray.getDimension(l.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = typedArray.getDimension(l.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = typedArray.getDimension(l.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = typedArray.getDimension(l.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        j jVarF = this.f3508i0.f();
        if (dimension >= 0.0f) {
            jVarF.f11116e = new q9.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            jVarF.f = new q9.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            jVarF.f11117g = new q9.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            jVarF.f11118h = new q9.a(dimension4);
        }
        this.f3508i0 = jVarF.a();
        ColorStateList colorStateListJ = a.a.j(context2, bVarE, l.TextInputLayout_boxBackgroundColor);
        if (colorStateListJ != null) {
            int defaultColor = colorStateListJ.getDefaultColor();
            this.I0 = defaultColor;
            this.f3516r0 = defaultColor;
            if (colorStateListJ.isStateful()) {
                this.J0 = colorStateListJ.getColorForState(new int[]{-16842910}, -1);
                this.K0 = colorStateListJ.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.L0 = colorStateListJ.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.K0 = this.I0;
                ColorStateList colorStateListC = f0.c.c(context2, p8.c.mtrl_filled_background_color);
                this.J0 = colorStateListC.getColorForState(new int[]{-16842910}, -1);
                this.L0 = colorStateListC.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f3516r0 = 0;
            this.I0 = 0;
            this.J0 = 0;
            this.K0 = 0;
            this.L0 = 0;
        }
        if (typedArray.hasValue(l.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListQ = bVarE.q(l.TextInputLayout_android_textColorHint);
            this.D0 = colorStateListQ;
            this.C0 = colorStateListQ;
        }
        ColorStateList colorStateListJ2 = a.a.j(context2, bVarE, l.TextInputLayout_boxStrokeColor);
        this.G0 = typedArray.getColor(l.TextInputLayout_boxStrokeColor, 0);
        this.E0 = context2.getColor(p8.c.mtrl_textinput_default_box_stroke_color);
        this.M0 = context2.getColor(p8.c.mtrl_textinput_disabled_color);
        this.F0 = context2.getColor(p8.c.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListJ2 != null) {
            setBoxStrokeColorStateList(colorStateListJ2);
        }
        if (typedArray.hasValue(l.TextInputLayout_boxStrokeErrorColor)) {
            setBoxStrokeErrorColor(a.a.j(context2, bVarE, l.TextInputLayout_boxStrokeErrorColor));
        }
        if (typedArray.getResourceId(l.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(typedArray.getResourceId(l.TextInputLayout_hintTextAppearance, 0));
        }
        this.U = bVarE.q(l.TextInputLayout_cursorColor);
        this.V = bVarE.q(l.TextInputLayout_cursorErrorColor);
        int resourceId = typedArray.getResourceId(l.TextInputLayout_errorTextAppearance, 0);
        CharSequence text = typedArray.getText(l.TextInputLayout_errorContentDescription);
        int i12 = typedArray.getInt(l.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean z2 = typedArray.getBoolean(l.TextInputLayout_errorEnabled, false);
        int resourceId2 = typedArray.getResourceId(l.TextInputLayout_helperTextTextAppearance, 0);
        boolean z10 = typedArray.getBoolean(l.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = typedArray.getText(l.TextInputLayout_helperText);
        int resourceId3 = typedArray.getResourceId(l.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = typedArray.getText(l.TextInputLayout_placeholderText);
        boolean z11 = typedArray.getBoolean(l.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(typedArray.getInt(l.TextInputLayout_counterMaxLength, -1));
        this.K = typedArray.getResourceId(l.TextInputLayout_counterTextAppearance, 0);
        this.J = typedArray.getResourceId(l.TextInputLayout_counterOverflowTextAppearance, 0);
        setBoxBackgroundMode(typedArray.getInt(l.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i12);
        setCounterOverflowTextAppearance(this.J);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.K);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArray.hasValue(l.TextInputLayout_errorTextColor)) {
            setErrorTextColor(bVarE.q(l.TextInputLayout_errorTextColor));
        }
        if (typedArray.hasValue(l.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(bVarE.q(l.TextInputLayout_helperTextTextColor));
        }
        if (typedArray.hasValue(l.TextInputLayout_hintTextColor)) {
            setHintTextColor(bVarE.q(l.TextInputLayout_hintTextColor));
        }
        if (typedArray.hasValue(l.TextInputLayout_counterTextColor)) {
            setCounterTextColor(bVarE.q(l.TextInputLayout_counterTextColor));
        }
        if (typedArray.hasValue(l.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(bVarE.q(l.TextInputLayout_counterOverflowTextColor));
        }
        if (typedArray.hasValue(l.TextInputLayout_placeholderTextColor)) {
            setPlaceholderTextColor(bVarE.q(l.TextInputLayout_placeholderTextColor));
        }
        m mVar = new m(this, bVarE);
        this.f3523w = mVar;
        boolean z12 = typedArray.getBoolean(l.TextInputLayout_android_enabled, true);
        bVarE.E();
        setImportantForAccessibility(2);
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 26 && i13 >= 26) {
            i0.b(this, 1);
        }
        frameLayout.addView(uVar);
        frameLayout.addView(mVar);
        addView(frameLayout);
        setEnabled(z12);
        setHelperTextEnabled(z10);
        setErrorEnabled(z2);
        setCounterEnabled(z11);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f3525x;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.f3502c0;
        }
        int iM = z7.a.m(this.f3525x, b.colorControlHighlight);
        int i = this.l0;
        int[][] iArr = X0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            g gVar = this.f3502c0;
            int i10 = this.f3516r0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{z7.a.r(0.1f, iM, i10), i10}), gVar, gVar);
        }
        Context context = getContext();
        g gVar2 = this.f3502c0;
        TypedValue typedValueB = z7.a.B(b.colorSurface, context, "TextInputLayout");
        int i11 = typedValueB.resourceId;
        int color = i11 != 0 ? context.getColor(i11) : typedValueB.data;
        g gVar3 = new g(gVar2.f11105u.f11090a);
        int iR = z7.a.r(0.1f, iM, color);
        gVar3.l(new ColorStateList(iArr, new int[]{iR, 0}));
        gVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iR, color});
        g gVar4 = new g(gVar2.f11105u.f11090a);
        gVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar3, gVar4), gVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f3504e0 == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f3504e0 = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f3504e0.addState(new int[0], f(false));
        }
        return this.f3504e0;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f3503d0 == null) {
            this.f3503d0 = f(true);
        }
        return this.f3503d0;
    }

    public static void k(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z2);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3525x != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f3525x = editText;
        int i = this.f3529z;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.B);
        }
        int i10 = this.A;
        if (i10 != -1) {
            setMaxEms(i10);
        } else {
            setMaxWidth(this.C);
        }
        this.f3505f0 = false;
        i();
        setTextInputAccessibilityDelegate(new w(this));
        Typeface typeface = this.f3525x.getTypeface();
        c cVar = this.P0;
        cVar.m(typeface);
        float textSize = this.f3525x.getTextSize();
        if (cVar.f6857h != textSize) {
            cVar.f6857h = textSize;
            cVar.h(false);
        }
        int i11 = Build.VERSION.SDK_INT;
        float letterSpacing = this.f3525x.getLetterSpacing();
        if (cVar.W != letterSpacing) {
            cVar.W = letterSpacing;
            cVar.h(false);
        }
        int gravity = this.f3525x.getGravity();
        int i12 = (gravity & (-113)) | 48;
        if (cVar.f6856g != i12) {
            cVar.f6856g = i12;
            cVar.h(false);
        }
        if (cVar.f != gravity) {
            cVar.f = gravity;
            cVar.h(false);
        }
        WeakHashMap weakHashMap = o0.f10475a;
        this.N0 = editText.getMinimumHeight();
        this.f3525x.addTextChangedListener(new v(this, editText));
        if (this.C0 == null) {
            this.C0 = this.f3525x.getHintTextColors();
        }
        if (this.W) {
            if (TextUtils.isEmpty(this.f3500a0)) {
                CharSequence hint = this.f3525x.getHint();
                this.f3527y = hint;
                setHint(hint);
                this.f3525x.setHint((CharSequence) null);
            }
            this.f3501b0 = true;
        }
        if (i11 >= 29) {
            p();
        }
        if (this.I != null) {
            n(this.f3525x.getText());
        }
        r();
        this.D.b();
        this.f3521v.bringToFront();
        m mVar = this.f3523w;
        mVar.bringToFront();
        Iterator it = this.f3528y0.iterator();
        while (it.hasNext()) {
            ((v9.l) it.next()).a(this);
        }
        mVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        u(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f3500a0)) {
            return;
        }
        this.f3500a0 = charSequence;
        c cVar = this.P0;
        if (charSequence == null || !TextUtils.equals(cVar.A, charSequence)) {
            cVar.A = charSequence;
            cVar.B = null;
            Bitmap bitmap = cVar.E;
            if (bitmap != null) {
                bitmap.recycle();
                cVar.E = null;
            }
            cVar.h(false);
        }
        if (this.O0) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.M == z2) {
            return;
        }
        if (z2) {
            d1 d1Var = this.N;
            if (d1Var != null) {
                this.f3519u.addView(d1Var);
                this.N.setVisibility(0);
            }
        } else {
            d1 d1Var2 = this.N;
            if (d1Var2 != null) {
                d1Var2.setVisibility(8);
            }
            this.N = null;
        }
        this.M = z2;
    }

    public final void a(float f) {
        c cVar = this.P0;
        if (cVar.f6847b == f) {
            return;
        }
        if (this.S0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.S0 = valueAnimator;
            valueAnimator.setInterpolator(b8.h.y(getContext(), b.motionEasingEmphasizedInterpolator, q8.a.f11073b));
            this.S0.setDuration(b8.h.x(getContext(), b.motionDurationMedium4, 167));
            this.S0.addUpdateListener(new b0(3, this));
        }
        this.S0.setFloatValues(cVar.f6847b, f);
        this.S0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f3519u;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    public final void b() {
        int i;
        int i10;
        g gVar = this.f3502c0;
        if (gVar == null) {
            return;
        }
        q9.k kVar = gVar.f11105u.f11090a;
        q9.k kVar2 = this.f3508i0;
        if (kVar != kVar2) {
            gVar.setShapeAppearanceModel(kVar2);
        }
        if (this.l0 == 2 && (i = this.f3512n0) > -1 && (i10 = this.f3515q0) != 0) {
            g gVar2 = this.f3502c0;
            gVar2.f11105u.f11097j = i;
            gVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i10);
            f fVar = gVar2.f11105u;
            if (fVar.f11093d != colorStateListValueOf) {
                fVar.f11093d = colorStateListValueOf;
                gVar2.onStateChange(gVar2.getState());
            }
        }
        int iB = this.f3516r0;
        if (this.l0 == 1) {
            iB = i0.b.b(this.f3516r0, z7.a.l(getContext(), b.colorSurface, 0));
        }
        this.f3516r0 = iB;
        this.f3502c0.l(ColorStateList.valueOf(iB));
        g gVar3 = this.f3506g0;
        if (gVar3 != null && this.f3507h0 != null) {
            if (this.f3512n0 > -1 && this.f3515q0 != 0) {
                gVar3.l(this.f3525x.isFocused() ? ColorStateList.valueOf(this.E0) : ColorStateList.valueOf(this.f3515q0));
                this.f3507h0.l(ColorStateList.valueOf(this.f3515q0));
            }
            invalidate();
        }
        s();
    }

    public final int c() {
        float fD;
        if (!this.W) {
            return 0;
        }
        int i = this.l0;
        c cVar = this.P0;
        if (i == 0) {
            fD = cVar.d();
        } else {
            if (i != 2) {
                return 0;
            }
            fD = cVar.d() / 2.0f;
        }
        return (int) fD;
    }

    public final h d() {
        h hVar = new h();
        hVar.f5300w = b8.h.x(getContext(), b.motionDurationShort2, 87);
        hVar.f5301x = b8.h.y(getContext(), b.motionEasingLinearInterpolator, q8.a.f11072a);
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.f3525x;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f3527y != null) {
            boolean z2 = this.f3501b0;
            this.f3501b0 = false;
            CharSequence hint = editText.getHint();
            this.f3525x.setHint(this.f3527y);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f3525x.setHint(hint);
                this.f3501b0 = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.f3519u;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i10 = 0; i10 < frameLayout.getChildCount(); i10++) {
            View childAt = frameLayout.getChildAt(i10);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i10);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.f3525x) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.U0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.U0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        g gVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z2 = this.W;
        c cVar = this.P0;
        if (z2) {
            TextPaint textPaint = cVar.N;
            RectF rectF = cVar.f6853e;
            int iSave = canvas2.save();
            if (cVar.B != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(cVar.G);
                float f = cVar.f6864p;
                float f4 = cVar.f6865q;
                float f10 = cVar.F;
                if (f10 != 1.0f) {
                    canvas2.scale(f10, f10, f, f4);
                }
                if (cVar.f6852d0 <= 1 || cVar.C) {
                    canvas2.translate(f, f4);
                    cVar.Y.draw(canvas2);
                } else {
                    float lineStart = cVar.f6864p - cVar.Y.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f4);
                    float f11 = alpha;
                    textPaint.setAlpha((int) (cVar.f6848b0 * f11));
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 31) {
                        float f12 = cVar.H;
                        float f13 = cVar.I;
                        float f14 = cVar.J;
                        int i10 = cVar.K;
                        textPaint.setShadowLayer(f12, f13, f14, i0.b.d(i10, (textPaint.getAlpha() * Color.alpha(i10)) / 255));
                    }
                    cVar.Y.draw(canvas2);
                    textPaint.setAlpha((int) (cVar.f6846a0 * f11));
                    if (i >= 31) {
                        float f15 = cVar.H;
                        float f16 = cVar.I;
                        float f17 = cVar.J;
                        int i11 = cVar.K;
                        textPaint.setShadowLayer(f15, f16, f17, i0.b.d(i11, (Color.alpha(i11) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = cVar.Y.getLineBaseline(0);
                    CharSequence charSequence = cVar.f6850c0;
                    float f18 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f18, textPaint);
                    if (i >= 31) {
                        textPaint.setShadowLayer(cVar.H, cVar.I, cVar.J, cVar.K);
                    }
                    String strTrim = cVar.f6850c0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(cVar.Y.getLineEnd(0), str.length()), 0.0f, f18, (Paint) textPaint);
                }
                canvas2.restoreToCount(iSave);
            }
        }
        if (this.f3507h0 == null || (gVar = this.f3506g0) == null) {
            return;
        }
        gVar.draw(canvas2);
        if (this.f3525x.isFocused()) {
            Rect bounds = this.f3507h0.getBounds();
            Rect bounds2 = this.f3506g0.getBounds();
            float f19 = cVar.f6847b;
            int iCenterX = bounds2.centerX();
            bounds.left = q8.a.c(f19, iCenterX, bounds2.left);
            bounds.right = q8.a.c(f19, iCenterX, bounds2.right);
            this.f3507h0.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.T0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.T0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            j9.c r3 = r4.P0
            if (r3 == 0) goto L2f
            r3.L = r1
            android.content.res.ColorStateList r1 = r3.f6859k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f6858j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.h(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f3525x
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = q0.o0.f10475a
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = r2
        L44:
            r4.u(r0, r2)
        L47:
            r4.r()
            r4.x()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.T0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final boolean e() {
        return this.W && !TextUtils.isEmpty(this.f3500a0) && (this.f3502c0 instanceof v9.g);
    }

    public final g f(boolean z2) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(d.mtrl_shape_corner_size_small_component);
        float f = z2 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f3525x;
        float popupElevation = editText instanceof s ? ((s) editText).getPopupElevation() : getResources().getDimensionPixelOffset(d.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        i iVar = new i();
        i iVar2 = new i();
        i iVar3 = new i();
        i iVar4 = new i();
        int i = 0;
        e eVar = new e(i);
        e eVar2 = new e(i);
        e eVar3 = new e(i);
        e eVar4 = new e(i);
        q9.a aVar = new q9.a(f);
        q9.a aVar2 = new q9.a(f);
        q9.a aVar3 = new q9.a(dimensionPixelOffset);
        q9.a aVar4 = new q9.a(dimensionPixelOffset);
        q9.k kVar = new q9.k();
        kVar.f11123a = iVar;
        kVar.f11124b = iVar2;
        kVar.f11125c = iVar3;
        kVar.f11126d = iVar4;
        kVar.f11127e = aVar;
        kVar.f = aVar2;
        kVar.f11128g = aVar4;
        kVar.f11129h = aVar3;
        kVar.i = eVar;
        kVar.f11130j = eVar2;
        kVar.f11131k = eVar3;
        kVar.f11132l = eVar4;
        EditText editText2 = this.f3525x;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof s ? ((s) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = g.R;
            TypedValue typedValueB = z7.a.B(b.colorSurface, context, g.class.getSimpleName());
            int i10 = typedValueB.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i10 != 0 ? context.getColor(i10) : typedValueB.data);
        }
        g gVar = new g();
        gVar.j(context);
        gVar.l(dropDownBackgroundTintList);
        gVar.k(popupElevation);
        gVar.setShapeAppearanceModel(kVar);
        f fVar = gVar.f11105u;
        if (fVar.f11095g == null) {
            fVar.f11095g = new Rect();
        }
        gVar.f11105u.f11095g.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        gVar.invalidateSelf();
        return gVar;
    }

    public final int g(int i, boolean z2) {
        return ((z2 || getPrefixText() == null) ? (!z2 || getSuffixText() == null) ? this.f3525x.getCompoundPaddingLeft() : this.f3523w.c() : this.f3521v.a()) + i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3525x;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public g getBoxBackground() {
        int i = this.l0;
        if (i == 1 || i == 2) {
            return this.f3502c0;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f3516r0;
    }

    public int getBoxBackgroundMode() {
        return this.l0;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f3511m0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean zD = f0.d(this);
        RectF rectF = this.f3520u0;
        return zD ? this.f3508i0.f11129h.a(rectF) : this.f3508i0.f11128g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean zD = f0.d(this);
        RectF rectF = this.f3520u0;
        return zD ? this.f3508i0.f11128g.a(rectF) : this.f3508i0.f11129h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean zD = f0.d(this);
        RectF rectF = this.f3520u0;
        return zD ? this.f3508i0.f11127e.a(rectF) : this.f3508i0.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean zD = f0.d(this);
        RectF rectF = this.f3520u0;
        return zD ? this.f3508i0.f.a(rectF) : this.f3508i0.f11127e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.G0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.H0;
    }

    public int getBoxStrokeWidth() {
        return this.f3513o0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f3514p0;
    }

    public int getCounterMaxLength() {
        return this.F;
    }

    public CharSequence getCounterOverflowDescription() {
        d1 d1Var;
        if (this.E && this.G && (d1Var = this.I) != null) {
            return d1Var.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.T;
    }

    public ColorStateList getCounterTextColor() {
        return this.S;
    }

    public ColorStateList getCursorColor() {
        return this.U;
    }

    public ColorStateList getCursorErrorColor() {
        return this.V;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.C0;
    }

    public EditText getEditText() {
        return this.f3525x;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f3523w.A.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f3523w.A.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f3523w.G;
    }

    public int getEndIconMode() {
        return this.f3523w.C;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f3523w.H;
    }

    public CheckableImageButton getEndIconView() {
        return this.f3523w.A;
    }

    public CharSequence getError() {
        q qVar = this.D;
        if (qVar.f13400q) {
            return qVar.f13399p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.D.f13403t;
    }

    public CharSequence getErrorContentDescription() {
        return this.D.f13402s;
    }

    public int getErrorCurrentTextColors() {
        d1 d1Var = this.D.f13401r;
        if (d1Var != null) {
            return d1Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f3523w.f13372w.getDrawable();
    }

    public CharSequence getHelperText() {
        q qVar = this.D;
        if (qVar.f13407x) {
            return qVar.f13406w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        d1 d1Var = this.D.f13408y;
        if (d1Var != null) {
            return d1Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.W) {
            return this.f3500a0;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.P0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        c cVar = this.P0;
        return cVar.e(cVar.f6859k);
    }

    public ColorStateList getHintTextColor() {
        return this.D0;
    }

    public x getLengthCounter() {
        return this.H;
    }

    public int getMaxEms() {
        return this.A;
    }

    public int getMaxWidth() {
        return this.C;
    }

    public int getMinEms() {
        return this.f3529z;
    }

    public int getMinWidth() {
        return this.B;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3523w.A.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3523w.A.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.M) {
            return this.L;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.P;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.O;
    }

    public CharSequence getPrefixText() {
        return this.f3521v.f13419w;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f3521v.f13418v.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f3521v.f13418v;
    }

    public q9.k getShapeAppearanceModel() {
        return this.f3508i0;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f3521v.f13420x.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f3521v.f13420x.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f3521v.A;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f3521v.B;
    }

    public CharSequence getSuffixText() {
        return this.f3523w.J;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f3523w.K.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f3523w.K;
    }

    public Typeface getTypeface() {
        return this.f3522v0;
    }

    public final int h(int i, boolean z2) {
        return i - ((z2 || getSuffixText() == null) ? (!z2 || getPrefixText() == null) ? this.f3525x.getCompoundPaddingRight() : this.f3521v.a() : this.f3523w.c());
    }

    public final void i() {
        int i = this.l0;
        if (i == 0) {
            this.f3502c0 = null;
            this.f3506g0 = null;
            this.f3507h0 = null;
        } else if (i == 1) {
            this.f3502c0 = new g(this.f3508i0);
            this.f3506g0 = new g();
            this.f3507h0 = new g();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(x.c.a(new StringBuilder(), this.l0, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.W || (this.f3502c0 instanceof v9.g)) {
                this.f3502c0 = new g(this.f3508i0);
            } else {
                q9.k kVar = this.f3508i0;
                int i10 = v9.g.T;
                if (kVar == null) {
                    kVar = new q9.k();
                }
                v9.f fVar = new v9.f(kVar, new RectF());
                v9.g gVar = new v9.g(fVar);
                gVar.S = fVar;
                this.f3502c0 = gVar;
            }
            this.f3506g0 = null;
            this.f3507h0 = null;
        }
        s();
        x();
        if (this.l0 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f3511m0 = getResources().getDimensionPixelSize(d.material_font_2_0_box_collapsed_padding_top);
            } else if (a.a.y(getContext())) {
                this.f3511m0 = getResources().getDimensionPixelSize(d.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.f3525x != null && this.l0 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.f3525x;
                WeakHashMap weakHashMap = o0.f10475a;
                editText.setPaddingRelative(editText.getPaddingStart(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_2_0_padding_top), this.f3525x.getPaddingEnd(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_2_0_padding_bottom));
            } else if (a.a.y(getContext())) {
                EditText editText2 = this.f3525x;
                WeakHashMap weakHashMap2 = o0.f10475a;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_1_3_padding_top), this.f3525x.getPaddingEnd(), getResources().getDimensionPixelSize(d.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.l0 != 0) {
            t();
        }
        EditText editText3 = this.f3525x;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i11 = this.l0;
                if (i11 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i11 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.j():void");
    }

    public final void l(d1 d1Var, int i) {
        try {
            d1Var.setTextAppearance(i);
            if (d1Var.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        d1Var.setTextAppearance(k.TextAppearance_AppCompat_Caption);
        d1Var.setTextColor(getContext().getColor(p8.c.design_error));
    }

    public final boolean m() {
        q qVar = this.D;
        return (qVar.f13398o != 1 || qVar.f13401r == null || TextUtils.isEmpty(qVar.f13399p)) ? false : true;
    }

    public final void n(Editable editable) {
        ((r2.h) this.H).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z2 = this.G;
        int i = this.F;
        if (i == -1) {
            this.I.setText(String.valueOf(length));
            this.I.setContentDescription(null);
            this.G = false;
        } else {
            this.G = length > i;
            Context context = getContext();
            this.I.setContentDescription(context.getString(this.G ? p8.j.character_counter_overflowed_content_description : p8.j.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.F)));
            if (z2 != this.G) {
                o();
            }
            String str = o0.b.f9035b;
            o0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? o0.b.f9038e : o0.b.f9037d;
            d1 d1Var = this.I;
            String string = getContext().getString(p8.j.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.F));
            bVar.getClass();
            e6.f0 f0Var = o0.g.f9045a;
            d1Var.setText(string != null ? bVar.c(string).toString() : null);
        }
        if (this.f3525x == null || z2 == this.G) {
            return;
        }
        u(false, false);
        x();
        r();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        d1 d1Var = this.I;
        if (d1Var != null) {
            l(d1Var, this.G ? this.J : this.K);
            if (!this.G && (colorStateList2 = this.S) != null) {
                this.I.setTextColor(colorStateList2);
            }
            if (!this.G || (colorStateList = this.T) == null) {
                return;
            }
            this.I.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.P0.g(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        m mVar = this.f3523w;
        mVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z2 = false;
        this.V0 = false;
        if (this.f3525x != null && this.f3525x.getMeasuredHeight() < (iMax = Math.max(mVar.getMeasuredHeight(), this.f3521v.getMeasuredHeight()))) {
            this.f3525x.setMinimumHeight(iMax);
            z2 = true;
        }
        boolean zQ = q();
        if (z2 || zQ) {
            this.f3525x.post(new nc.b(13, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        EditText editText = this.f3525x;
        if (editText != null) {
            Rect rect = this.f3517s0;
            j9.d.a(this, editText, rect);
            g gVar = this.f3506g0;
            if (gVar != null) {
                int i13 = rect.bottom;
                gVar.setBounds(rect.left, i13 - this.f3513o0, rect.right, i13);
            }
            g gVar2 = this.f3507h0;
            if (gVar2 != null) {
                int i14 = rect.bottom;
                gVar2.setBounds(rect.left, i14 - this.f3514p0, rect.right, i14);
            }
            if (this.W) {
                float textSize = this.f3525x.getTextSize();
                c cVar = this.P0;
                if (cVar.f6857h != textSize) {
                    cVar.f6857h = textSize;
                    cVar.h(false);
                }
                int gravity = this.f3525x.getGravity();
                int i15 = (gravity & (-113)) | 48;
                if (cVar.f6856g != i15) {
                    cVar.f6856g = i15;
                    cVar.h(false);
                }
                if (cVar.f != gravity) {
                    cVar.f = gravity;
                    cVar.h(false);
                }
                if (this.f3525x == null) {
                    throw new IllegalStateException();
                }
                boolean zD = f0.d(this);
                int i16 = rect.bottom;
                Rect rect2 = this.f3518t0;
                rect2.bottom = i16;
                int i17 = this.l0;
                if (i17 == 1) {
                    rect2.left = g(rect.left, zD);
                    rect2.top = rect.top + this.f3511m0;
                    rect2.right = h(rect.right, zD);
                } else if (i17 != 2) {
                    rect2.left = g(rect.left, zD);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, zD);
                } else {
                    rect2.left = this.f3525x.getPaddingLeft() + rect.left;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.f3525x.getPaddingRight();
                }
                int i18 = rect2.left;
                int i19 = rect2.top;
                int i20 = rect2.right;
                int i21 = rect2.bottom;
                Rect rect3 = cVar.f6851d;
                if (rect3.left != i18 || rect3.top != i19 || rect3.right != i20 || rect3.bottom != i21) {
                    rect3.set(i18, i19, i20, i21);
                    cVar.M = true;
                }
                if (this.f3525x == null) {
                    throw new IllegalStateException();
                }
                TextPaint textPaint = cVar.O;
                textPaint.setTextSize(cVar.f6857h);
                textPaint.setTypeface(cVar.f6869u);
                textPaint.setLetterSpacing(cVar.W);
                float f = -textPaint.ascent();
                rect2.left = this.f3525x.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.l0 != 1 || this.f3525x.getMinLines() > 1) ? rect.top + this.f3525x.getCompoundPaddingTop() : (int) (rect.centerY() - (f / 2.0f));
                rect2.right = rect.right - this.f3525x.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.l0 != 1 || this.f3525x.getMinLines() > 1) ? rect.bottom - this.f3525x.getCompoundPaddingBottom() : (int) (rect2.top + f);
                rect2.bottom = compoundPaddingBottom;
                int i22 = rect2.left;
                int i23 = rect2.top;
                int i24 = rect2.right;
                Rect rect4 = cVar.f6849c;
                if (rect4.left != i22 || rect4.top != i23 || rect4.right != i24 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i22, i23, i24, compoundPaddingBottom);
                    cVar.M = true;
                }
                cVar.h(false);
                if (!e() || this.O0) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        EditText editText;
        super.onMeasure(i, i10);
        boolean z2 = this.V0;
        m mVar = this.f3523w;
        if (!z2) {
            mVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.V0 = true;
        }
        if (this.N != null && (editText = this.f3525x) != null) {
            this.N.setGravity(editText.getGravity());
            this.N.setPadding(this.f3525x.getCompoundPaddingLeft(), this.f3525x.getCompoundPaddingTop(), this.f3525x.getCompoundPaddingRight(), this.f3525x.getCompoundPaddingBottom());
        }
        mVar.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        super.onRestoreInstanceState(yVar.f14205u);
        setError(yVar.f13427w);
        if (yVar.f13428x) {
            post(new androidx.fragment.app.e(26, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z2 = i == 1;
        if (z2 != this.f3509j0) {
            q9.c cVar = this.f3508i0.f11127e;
            RectF rectF = this.f3520u0;
            float fA = cVar.a(rectF);
            float fA2 = this.f3508i0.f.a(rectF);
            float fA3 = this.f3508i0.f11129h.a(rectF);
            float fA4 = this.f3508i0.f11128g.a(rectF);
            q9.k kVar = this.f3508i0;
            ga.b bVar = kVar.f11123a;
            ga.b bVar2 = kVar.f11124b;
            ga.b bVar3 = kVar.f11126d;
            ga.b bVar4 = kVar.f11125c;
            e eVar = new e(0);
            e eVar2 = new e(0);
            e eVar3 = new e(0);
            e eVar4 = new e(0);
            q9.a aVar = new q9.a(fA2);
            q9.a aVar2 = new q9.a(fA);
            q9.a aVar3 = new q9.a(fA4);
            q9.a aVar4 = new q9.a(fA3);
            q9.k kVar2 = new q9.k();
            kVar2.f11123a = bVar2;
            kVar2.f11124b = bVar;
            kVar2.f11125c = bVar3;
            kVar2.f11126d = bVar4;
            kVar2.f11127e = aVar;
            kVar2.f = aVar2;
            kVar2.f11128g = aVar4;
            kVar2.f11129h = aVar3;
            kVar2.i = eVar;
            kVar2.f11130j = eVar2;
            kVar2.f11131k = eVar3;
            kVar2.f11132l = eVar4;
            this.f3509j0 = z2;
            setShapeAppearanceModel(kVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        if (m()) {
            yVar.f13427w = getError();
        }
        m mVar = this.f3523w;
        yVar.f13428x = mVar.C != 0 && mVar.A.f3458x;
        return yVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            r4 = this;
            android.content.res.ColorStateList r0 = r4.U
            if (r0 == 0) goto L5
            goto L25
        L5:
            android.content.Context r0 = r4.getContext()
            int r1 = p8.b.colorControlActivated
            android.util.TypedValue r1 = z7.a.y(r0, r1)
            r2 = 0
            if (r1 != 0) goto L14
        L12:
            r0 = r2
            goto L25
        L14:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1d
            android.content.res.ColorStateList r0 = f0.c.c(r0, r3)
            goto L25
        L1d:
            int r0 = r1.data
            if (r0 == 0) goto L12
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L25:
            android.widget.EditText r1 = r4.f3525x
            if (r1 == 0) goto L50
            android.graphics.drawable.Drawable r1 = r0.c.a(r1)
            if (r1 != 0) goto L30
            goto L50
        L30:
            android.widget.EditText r1 = r4.f3525x
            android.graphics.drawable.Drawable r1 = r0.c.a(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.m()
            if (r2 != 0) goto L48
            n.d1 r2 = r4.I
            if (r2 == 0) goto L4d
            boolean r2 = r4.G
            if (r2 == 0) goto L4d
        L48:
            android.content.res.ColorStateList r2 = r4.V
            if (r2 == 0) goto L4d
            r0 = r2
        L4d:
            r1.setTintList(r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        d1 d1Var;
        EditText editText = this.f3525x;
        if (editText == null || this.l0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = n1.f8458a;
        Drawable drawableMutate = background.mutate();
        if (m()) {
            drawableMutate.setColorFilter(t.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.G && (d1Var = this.I) != null) {
            drawableMutate.setColorFilter(t.c(d1Var.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.f3525x.refreshDrawableState();
        }
    }

    public final void s() {
        EditText editText = this.f3525x;
        if (editText == null || this.f3502c0 == null) {
            return;
        }
        if ((this.f3505f0 || editText.getBackground() == null) && this.l0 != 0) {
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            EditText editText2 = this.f3525x;
            WeakHashMap weakHashMap = o0.f10475a;
            editText2.setBackground(editTextBoxBackground);
            this.f3505f0 = true;
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f3516r0 != i) {
            this.f3516r0 = i;
            this.I0 = i;
            this.K0 = i;
            this.L0 = i;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.I0 = defaultColor;
        this.f3516r0 = defaultColor;
        this.J0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.K0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.L0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.l0) {
            return;
        }
        this.l0 = i;
        if (this.f3525x != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.f3511m0 = i;
    }

    public void setBoxCornerFamily(int i) {
        j jVarF = this.f3508i0.f();
        q9.c cVar = this.f3508i0.f11127e;
        jVarF.f11112a = i5.a.g(i);
        jVarF.f11116e = cVar;
        q9.c cVar2 = this.f3508i0.f;
        jVarF.f11113b = i5.a.g(i);
        jVarF.f = cVar2;
        q9.c cVar3 = this.f3508i0.f11129h;
        jVarF.f11115d = i5.a.g(i);
        jVarF.f11118h = cVar3;
        q9.c cVar4 = this.f3508i0.f11128g;
        jVarF.f11114c = i5.a.g(i);
        jVarF.f11117g = cVar4;
        this.f3508i0 = jVarF.a();
        b();
    }

    public void setBoxStrokeColor(int i) {
        if (this.G0 != i) {
            this.G0 = i;
            x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.E0 = colorStateList.getDefaultColor();
            this.M0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.F0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.G0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.G0 != colorStateList.getDefaultColor()) {
            this.G0 = colorStateList.getDefaultColor();
        }
        x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.H0 != colorStateList) {
            this.H0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f3513o0 = i;
        x();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f3514p0 = i;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.E != z2) {
            q qVar = this.D;
            if (z2) {
                d1 d1Var = new d1(getContext(), null);
                this.I = d1Var;
                d1Var.setId(p8.f.textinput_counter);
                Typeface typeface = this.f3522v0;
                if (typeface != null) {
                    this.I.setTypeface(typeface);
                }
                this.I.setMaxLines(1);
                qVar.a(this.I, 2);
                ((ViewGroup.MarginLayoutParams) this.I.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(d.mtrl_textinput_counter_margin_start));
                o();
                if (this.I != null) {
                    EditText editText = this.f3525x;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                qVar.g(this.I, 2);
                this.I = null;
            }
            this.E = z2;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.F != i) {
            if (i > 0) {
                this.F = i;
            } else {
                this.F = -1;
            }
            if (!this.E || this.I == null) {
                return;
            }
            EditText editText = this.f3525x;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.J != i) {
            this.J = i;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.K != i) {
            this.K = i;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (m() || (this.I != null && this.G)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.C0 = colorStateList;
        this.D0 = colorStateList;
        if (this.f3525x != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        k(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f3523w.A.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f3523w.A.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i) {
        m mVar = this.f3523w;
        CharSequence text = i != 0 ? mVar.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = mVar.A;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        m mVar = this.f3523w;
        Drawable drawableP = i != 0 ? com.bumptech.glide.d.p(mVar.getContext(), i) : null;
        TextInputLayout textInputLayout = mVar.f13370u;
        CheckableImageButton checkableImageButton = mVar.A;
        checkableImageButton.setImageDrawable(drawableP);
        if (drawableP != null) {
            i5.a.b(textInputLayout, checkableImageButton, mVar.E, mVar.F);
            i5.a.H(textInputLayout, checkableImageButton, mVar.E);
        }
    }

    public void setEndIconMinSize(int i) {
        m mVar = this.f3523w;
        if (i < 0) {
            mVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != mVar.G) {
            mVar.G = i;
            CheckableImageButton checkableImageButton = mVar.A;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = mVar.f13372w;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.f3523w.g(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        m mVar = this.f3523w;
        CheckableImageButton checkableImageButton = mVar.A;
        View.OnLongClickListener onLongClickListener = mVar.I;
        checkableImageButton.setOnClickListener(onClickListener);
        i5.a.M(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        m mVar = this.f3523w;
        mVar.I = onLongClickListener;
        CheckableImageButton checkableImageButton = mVar.A;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        i5.a.M(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        m mVar = this.f3523w;
        mVar.H = scaleType;
        mVar.A.setScaleType(scaleType);
        mVar.f13372w.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        m mVar = this.f3523w;
        if (mVar.E != colorStateList) {
            mVar.E = colorStateList;
            i5.a.b(mVar.f13370u, mVar.A, colorStateList, mVar.F);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        m mVar = this.f3523w;
        if (mVar.F != mode) {
            mVar.F = mode;
            i5.a.b(mVar.f13370u, mVar.A, mVar.E, mode);
        }
    }

    public void setEndIconVisible(boolean z2) {
        this.f3523w.h(z2);
    }

    public void setError(CharSequence charSequence) {
        q qVar = this.D;
        if (!qVar.f13400q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            qVar.f();
            return;
        }
        qVar.c();
        qVar.f13399p = charSequence;
        qVar.f13401r.setText(charSequence);
        int i = qVar.f13397n;
        if (i != 1) {
            qVar.f13398o = 1;
        }
        qVar.i(i, qVar.f13398o, qVar.h(qVar.f13401r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        q qVar = this.D;
        qVar.f13403t = i;
        d1 d1Var = qVar.f13401r;
        if (d1Var != null) {
            WeakHashMap weakHashMap = o0.f10475a;
            d1Var.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        q qVar = this.D;
        qVar.f13402s = charSequence;
        d1 d1Var = qVar.f13401r;
        if (d1Var != null) {
            d1Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        q qVar = this.D;
        TextInputLayout textInputLayout = qVar.f13392h;
        if (qVar.f13400q == z2) {
            return;
        }
        qVar.c();
        if (z2) {
            d1 d1Var = new d1(qVar.f13391g, null);
            qVar.f13401r = d1Var;
            d1Var.setId(p8.f.textinput_error);
            qVar.f13401r.setTextAlignment(5);
            Typeface typeface = qVar.B;
            if (typeface != null) {
                qVar.f13401r.setTypeface(typeface);
            }
            int i = qVar.f13404u;
            qVar.f13404u = i;
            d1 d1Var2 = qVar.f13401r;
            if (d1Var2 != null) {
                qVar.f13392h.l(d1Var2, i);
            }
            ColorStateList colorStateList = qVar.f13405v;
            qVar.f13405v = colorStateList;
            d1 d1Var3 = qVar.f13401r;
            if (d1Var3 != null && colorStateList != null) {
                d1Var3.setTextColor(colorStateList);
            }
            CharSequence charSequence = qVar.f13402s;
            qVar.f13402s = charSequence;
            d1 d1Var4 = qVar.f13401r;
            if (d1Var4 != null) {
                d1Var4.setContentDescription(charSequence);
            }
            int i10 = qVar.f13403t;
            qVar.f13403t = i10;
            d1 d1Var5 = qVar.f13401r;
            if (d1Var5 != null) {
                WeakHashMap weakHashMap = o0.f10475a;
                d1Var5.setAccessibilityLiveRegion(i10);
            }
            qVar.f13401r.setVisibility(4);
            qVar.a(qVar.f13401r, 0);
        } else {
            qVar.f();
            qVar.g(qVar.f13401r, 0);
            qVar.f13401r = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        qVar.f13400q = z2;
    }

    public void setErrorIconDrawable(int i) {
        m mVar = this.f3523w;
        mVar.i(i != 0 ? com.bumptech.glide.d.p(mVar.getContext(), i) : null);
        i5.a.H(mVar.f13370u, mVar.f13372w, mVar.f13373x);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        m mVar = this.f3523w;
        CheckableImageButton checkableImageButton = mVar.f13372w;
        View.OnLongClickListener onLongClickListener = mVar.f13375z;
        checkableImageButton.setOnClickListener(onClickListener);
        i5.a.M(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        m mVar = this.f3523w;
        mVar.f13375z = onLongClickListener;
        CheckableImageButton checkableImageButton = mVar.f13372w;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        i5.a.M(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        m mVar = this.f3523w;
        if (mVar.f13373x != colorStateList) {
            mVar.f13373x = colorStateList;
            i5.a.b(mVar.f13370u, mVar.f13372w, colorStateList, mVar.f13374y);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        m mVar = this.f3523w;
        if (mVar.f13374y != mode) {
            mVar.f13374y = mode;
            i5.a.b(mVar.f13370u, mVar.f13372w, mVar.f13373x, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        q qVar = this.D;
        qVar.f13404u = i;
        d1 d1Var = qVar.f13401r;
        if (d1Var != null) {
            qVar.f13392h.l(d1Var, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        q qVar = this.D;
        qVar.f13405v = colorStateList;
        d1 d1Var = qVar.f13401r;
        if (d1Var == null || colorStateList == null) {
            return;
        }
        d1Var.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.Q0 != z2) {
            this.Q0 = z2;
            u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        q qVar = this.D;
        if (zIsEmpty) {
            if (qVar.f13407x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!qVar.f13407x) {
            setHelperTextEnabled(true);
        }
        qVar.c();
        qVar.f13406w = charSequence;
        qVar.f13408y.setText(charSequence);
        int i = qVar.f13397n;
        if (i != 2) {
            qVar.f13398o = 2;
        }
        qVar.i(i, qVar.f13398o, qVar.h(qVar.f13408y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        q qVar = this.D;
        qVar.A = colorStateList;
        d1 d1Var = qVar.f13408y;
        if (d1Var == null || colorStateList == null) {
            return;
        }
        d1Var.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        q qVar = this.D;
        TextInputLayout textInputLayout = qVar.f13392h;
        if (qVar.f13407x == z2) {
            return;
        }
        qVar.c();
        if (z2) {
            d1 d1Var = new d1(qVar.f13391g, null);
            qVar.f13408y = d1Var;
            d1Var.setId(p8.f.textinput_helper_text);
            qVar.f13408y.setTextAlignment(5);
            Typeface typeface = qVar.B;
            if (typeface != null) {
                qVar.f13408y.setTypeface(typeface);
            }
            qVar.f13408y.setVisibility(4);
            qVar.f13408y.setAccessibilityLiveRegion(1);
            int i = qVar.f13409z;
            qVar.f13409z = i;
            d1 d1Var2 = qVar.f13408y;
            if (d1Var2 != null) {
                d1Var2.setTextAppearance(i);
            }
            ColorStateList colorStateList = qVar.A;
            qVar.A = colorStateList;
            d1 d1Var3 = qVar.f13408y;
            if (d1Var3 != null && colorStateList != null) {
                d1Var3.setTextColor(colorStateList);
            }
            qVar.a(qVar.f13408y, 1);
            qVar.f13408y.setAccessibilityDelegate(new p(qVar));
        } else {
            qVar.c();
            int i10 = qVar.f13397n;
            if (i10 == 2) {
                qVar.f13398o = 0;
            }
            qVar.i(i10, qVar.f13398o, qVar.h(qVar.f13408y, ""));
            qVar.g(qVar.f13408y, 1);
            qVar.f13408y = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        qVar.f13407x = z2;
    }

    public void setHelperTextTextAppearance(int i) {
        q qVar = this.D;
        qVar.f13409z = i;
        d1 d1Var = qVar.f13408y;
        if (d1Var != null) {
            d1Var.setTextAppearance(i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.W) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.R0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.W) {
            this.W = z2;
            if (z2) {
                CharSequence hint = this.f3525x.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f3500a0)) {
                        setHint(hint);
                    }
                    this.f3525x.setHint((CharSequence) null);
                }
                this.f3501b0 = true;
            } else {
                this.f3501b0 = false;
                if (!TextUtils.isEmpty(this.f3500a0) && TextUtils.isEmpty(this.f3525x.getHint())) {
                    this.f3525x.setHint(this.f3500a0);
                }
                setHintInternal(null);
            }
            if (this.f3525x != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        c cVar = this.P0;
        TextInputLayout textInputLayout = cVar.f6845a;
        n9.d dVar = new n9.d(textInputLayout.getContext(), i);
        ColorStateList colorStateList = dVar.f8868j;
        if (colorStateList != null) {
            cVar.f6859k = colorStateList;
        }
        float f = dVar.f8869k;
        if (f != 0.0f) {
            cVar.i = f;
        }
        ColorStateList colorStateList2 = dVar.f8861a;
        if (colorStateList2 != null) {
            cVar.U = colorStateList2;
        }
        cVar.S = dVar.f8865e;
        cVar.T = dVar.f;
        cVar.R = dVar.f8866g;
        cVar.V = dVar.i;
        n9.a aVar = cVar.f6873y;
        if (aVar != null) {
            aVar.f8855c = true;
        }
        u5.d dVar2 = new u5.d(19, cVar);
        dVar.a();
        cVar.f6873y = new n9.a(dVar2, dVar.f8872n);
        dVar.c(textInputLayout.getContext(), cVar.f6873y);
        cVar.h(false);
        this.D0 = cVar.f6859k;
        if (this.f3525x != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.D0 != colorStateList) {
            if (this.C0 == null) {
                c cVar = this.P0;
                if (cVar.f6859k != colorStateList) {
                    cVar.f6859k = colorStateList;
                    cVar.h(false);
                }
            }
            this.D0 = colorStateList;
            if (this.f3525x != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(x xVar) {
        this.H = xVar;
    }

    public void setMaxEms(int i) {
        this.A = i;
        EditText editText = this.f3525x;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.C = i;
        EditText editText = this.f3525x;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.f3529z = i;
        EditText editText = this.f3525x;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.B = i;
        EditText editText = this.f3525x;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        m mVar = this.f3523w;
        mVar.A.setContentDescription(i != 0 ? mVar.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        m mVar = this.f3523w;
        mVar.A.setImageDrawable(i != 0 ? com.bumptech.glide.d.p(mVar.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        m mVar = this.f3523w;
        if (z2 && mVar.C != 1) {
            mVar.g(1);
        } else if (z2) {
            mVar.getClass();
        } else {
            mVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        m mVar = this.f3523w;
        mVar.E = colorStateList;
        i5.a.b(mVar.f13370u, mVar.A, colorStateList, mVar.F);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        m mVar = this.f3523w;
        mVar.F = mode;
        i5.a.b(mVar.f13370u, mVar.A, mVar.E, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.N == null) {
            d1 d1Var = new d1(getContext(), null);
            this.N = d1Var;
            d1Var.setId(p8.f.textinput_placeholder);
            this.N.setImportantForAccessibility(2);
            h hVarD = d();
            this.Q = hVarD;
            hVarD.f5299v = 67L;
            this.R = d();
            setPlaceholderTextAppearance(this.P);
            setPlaceholderTextColor(this.O);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.M) {
                setPlaceholderTextEnabled(true);
            }
            this.L = charSequence;
        }
        EditText editText = this.f3525x;
        v(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.P = i;
        d1 d1Var = this.N;
        if (d1Var != null) {
            d1Var.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            d1 d1Var = this.N;
            if (d1Var == null || colorStateList == null) {
                return;
            }
            d1Var.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        u uVar = this.f3521v;
        uVar.getClass();
        uVar.f13419w = TextUtils.isEmpty(charSequence) ? null : charSequence;
        uVar.f13418v.setText(charSequence);
        uVar.e();
    }

    public void setPrefixTextAppearance(int i) {
        this.f3521v.f13418v.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f3521v.f13418v.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(q9.k kVar) {
        g gVar = this.f3502c0;
        if (gVar == null || gVar.f11105u.f11090a == kVar) {
            return;
        }
        this.f3508i0 = kVar;
        b();
    }

    public void setStartIconCheckable(boolean z2) {
        this.f3521v.f13420x.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? com.bumptech.glide.d.p(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        u uVar = this.f3521v;
        if (i < 0) {
            uVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != uVar.A) {
            uVar.A = i;
            CheckableImageButton checkableImageButton = uVar.f13420x;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        u uVar = this.f3521v;
        CheckableImageButton checkableImageButton = uVar.f13420x;
        View.OnLongClickListener onLongClickListener = uVar.C;
        checkableImageButton.setOnClickListener(onClickListener);
        i5.a.M(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        u uVar = this.f3521v;
        uVar.C = onLongClickListener;
        CheckableImageButton checkableImageButton = uVar.f13420x;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        i5.a.M(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        u uVar = this.f3521v;
        uVar.B = scaleType;
        uVar.f13420x.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        u uVar = this.f3521v;
        if (uVar.f13421y != colorStateList) {
            uVar.f13421y = colorStateList;
            i5.a.b(uVar.f13417u, uVar.f13420x, colorStateList, uVar.f13422z);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        u uVar = this.f3521v;
        if (uVar.f13422z != mode) {
            uVar.f13422z = mode;
            i5.a.b(uVar.f13417u, uVar.f13420x, uVar.f13421y, mode);
        }
    }

    public void setStartIconVisible(boolean z2) {
        this.f3521v.c(z2);
    }

    public void setSuffixText(CharSequence charSequence) {
        m mVar = this.f3523w;
        mVar.getClass();
        mVar.J = TextUtils.isEmpty(charSequence) ? null : charSequence;
        mVar.K.setText(charSequence);
        mVar.n();
    }

    public void setSuffixTextAppearance(int i) {
        this.f3523w.K.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f3523w.K.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(w wVar) {
        EditText editText = this.f3525x;
        if (editText != null) {
            o0.n(editText, wVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f3522v0) {
            this.f3522v0 = typeface;
            this.P0.m(typeface);
            q qVar = this.D;
            if (typeface != qVar.B) {
                qVar.B = typeface;
                d1 d1Var = qVar.f13401r;
                if (d1Var != null) {
                    d1Var.setTypeface(typeface);
                }
                d1 d1Var2 = qVar.f13408y;
                if (d1Var2 != null) {
                    d1Var2.setTypeface(typeface);
                }
            }
            d1 d1Var3 = this.I;
            if (d1Var3 != null) {
                d1Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.l0 != 1) {
            FrameLayout frameLayout = this.f3519u;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iC = c();
            if (iC != layoutParams.topMargin) {
                layoutParams.topMargin = iC;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z2, boolean z10) {
        ColorStateList colorStateList;
        d1 d1Var;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f3525x;
        boolean z11 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f3525x;
        boolean z12 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.C0;
        c cVar = this.P0;
        if (colorStateList2 != null) {
            cVar.i(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.C0;
            cVar.i(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.M0) : this.M0));
        } else if (m()) {
            d1 d1Var2 = this.D.f13401r;
            cVar.i(d1Var2 != null ? d1Var2.getTextColors() : null);
        } else if (this.G && (d1Var = this.I) != null) {
            cVar.i(d1Var.getTextColors());
        } else if (z12 && (colorStateList = this.D0) != null && cVar.f6859k != colorStateList) {
            cVar.f6859k = colorStateList;
            cVar.h(false);
        }
        m mVar = this.f3523w;
        u uVar = this.f3521v;
        if (z11 || !this.Q0 || (isEnabled() && z12)) {
            if (z10 || this.O0) {
                ValueAnimator valueAnimator = this.S0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.S0.cancel();
                }
                if (z2 && this.R0) {
                    a(1.0f);
                } else {
                    cVar.k(1.0f);
                }
                this.O0 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.f3525x;
                v(editText3 != null ? editText3.getText() : null);
                uVar.D = false;
                uVar.e();
                mVar.L = false;
                mVar.n();
                return;
            }
            return;
        }
        if (z10 || !this.O0) {
            ValueAnimator valueAnimator2 = this.S0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.S0.cancel();
            }
            if (z2 && this.R0) {
                a(0.0f);
            } else {
                cVar.k(0.0f);
            }
            if (e() && !((v9.g) this.f3502c0).S.f13353r.isEmpty() && e()) {
                ((v9.g) this.f3502c0).r(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.O0 = true;
            d1 d1Var3 = this.N;
            if (d1Var3 != null && this.M) {
                d1Var3.setText((CharSequence) null);
                g5.t.a(this.f3519u, this.R);
                this.N.setVisibility(4);
            }
            uVar.D = true;
            uVar.e();
            mVar.L = true;
            mVar.n();
        }
    }

    public final void v(Editable editable) {
        ((r2.h) this.H).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f3519u;
        if (length != 0 || this.O0) {
            d1 d1Var = this.N;
            if (d1Var == null || !this.M) {
                return;
            }
            d1Var.setText((CharSequence) null);
            g5.t.a(frameLayout, this.R);
            this.N.setVisibility(4);
            return;
        }
        if (this.N == null || !this.M || TextUtils.isEmpty(this.L)) {
            return;
        }
        this.N.setText(this.L);
        g5.t.a(frameLayout, this.Q);
        this.N.setVisibility(0);
        this.N.bringToFront();
        announceForAccessibility(this.L);
    }

    public final void w(boolean z2, boolean z10) {
        int defaultColor = this.H0.getDefaultColor();
        int colorForState = this.H0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.H0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z2) {
            this.f3515q0 = colorForState2;
        } else if (z10) {
            this.f3515q0 = colorForState;
        } else {
            this.f3515q0 = defaultColor;
        }
    }

    public final void x() {
        d1 d1Var;
        EditText editText;
        EditText editText2;
        if (this.f3502c0 == null || this.l0 == 0) {
            return;
        }
        boolean z2 = false;
        boolean z10 = isFocused() || ((editText2 = this.f3525x) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f3525x) != null && editText.isHovered())) {
            z2 = true;
        }
        if (!isEnabled()) {
            this.f3515q0 = this.M0;
        } else if (m()) {
            if (this.H0 != null) {
                w(z10, z2);
            } else {
                this.f3515q0 = getErrorCurrentTextColors();
            }
        } else if (!this.G || (d1Var = this.I) == null) {
            if (z10) {
                this.f3515q0 = this.G0;
            } else if (z2) {
                this.f3515q0 = this.F0;
            } else {
                this.f3515q0 = this.E0;
            }
        } else if (this.H0 != null) {
            w(z10, z2);
        } else {
            this.f3515q0 = d1Var.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        m mVar = this.f3523w;
        TextInputLayout textInputLayout = mVar.f13370u;
        CheckableImageButton checkableImageButton = mVar.A;
        TextInputLayout textInputLayout2 = mVar.f13370u;
        mVar.l();
        i5.a.H(textInputLayout2, mVar.f13372w, mVar.f13373x);
        i5.a.H(textInputLayout2, checkableImageButton, mVar.E);
        if (mVar.b() instanceof v9.j) {
            if (!textInputLayout.m() || checkableImageButton.getDrawable() == null) {
                i5.a.b(textInputLayout, checkableImageButton, mVar.E, mVar.F);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        u uVar = this.f3521v;
        i5.a.H(uVar.f13417u, uVar.f13420x, uVar.f13421y);
        if (this.l0 == 2) {
            int i = this.f3512n0;
            if (z10 && isEnabled()) {
                this.f3512n0 = this.f3514p0;
            } else {
                this.f3512n0 = this.f3513o0;
            }
            if (this.f3512n0 != i && e() && !this.O0) {
                if (e()) {
                    ((v9.g) this.f3502c0).r(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.l0 == 1) {
            if (!isEnabled()) {
                this.f3516r0 = this.J0;
            } else if (z2 && !z10) {
                this.f3516r0 = this.L0;
            } else if (z10) {
                this.f3516r0 = this.K0;
            } else {
                this.f3516r0 = this.I0;
            }
        }
        b();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3521v.f13420x;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f3521v.b(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3523w.A.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3523w.A.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f3523w.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3523w.A;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        m mVar = this.f3523w;
        TextInputLayout textInputLayout = mVar.f13370u;
        CheckableImageButton checkableImageButton = mVar.A;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            i5.a.b(textInputLayout, checkableImageButton, mVar.E, mVar.F);
            i5.a.H(textInputLayout, checkableImageButton, mVar.E);
        }
    }
}
